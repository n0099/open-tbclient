package com.baidu.tieba.screenlocknotify;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.view.ScreenLockHeaderView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView glb;
    private Window iOl;
    public c iOn;
    public d iOo;
    private ScreenLockLoadMoreModel iOr;
    private ScreenLockHeaderView iOs;
    private Drawable iCl = null;
    public DynamicHeightListView iOm = null;
    private int iOp = 0;
    private TextView iOq = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver iOt = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.cjd().iOz.ctu();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener iOu = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.iOs != null && !StringUtils.isNull(ScreenLockActivity.this.iOs.getInputMsg()) && (data = ScreenLockActivity.this.iOs.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an("c11703").l("msg_id", data.msgId / 100).l("task_id", data.taskId).bT("obj_to", data.url).bT(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.iOs.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.anD().pl(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.iOs.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.nameShow, data.iOP);
                    com.baidu.tbadk.coreExtra.messageCenter.b.anD().pl(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.cjd().iOz.ctu();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.iOo = ScreenLockActivity.this.iOn.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.iOo);
        }
    };
    private View.OnClickListener iOv = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.iOs != null) {
                ScreenLockActivity.this.iOo = ScreenLockActivity.this.iOs.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.iOo);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iOw = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.iOq != null) {
                            ScreenLockActivity.this.iOq.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.iOq.setEnabled(true);
                            return;
                        }
                        return;
                    }
                    if (responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) {
                        data = ((ScreenLockLoadMoreHttpResponseMessage) responsedMessage).getData();
                    } else {
                        data = responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage ? ((ScreenLockLoadMoreSocketResponseMessage) responsedMessage).getData() : null;
                    }
                    if (data != null) {
                        ArrayList<d> cjj = data.cjj();
                        if (ScreenLockActivity.this.iOn != null) {
                            ScreenLockActivity.this.iOn.ec(cjj);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.iOn.setHasMore(false);
                            if (ScreenLockActivity.this.iOq != null) {
                                ScreenLockActivity.this.iOm.removeFooterView(ScreenLockActivity.this.iOq);
                                ScreenLockActivity.this.iOq = null;
                            }
                        }
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.iOl = getWindow();
        this.iOl.addFlags(524288);
        this.iOl.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.kw()) {
            this.iCl = com.baidu.tieba.t.b.cty();
            if (this.iCl != null) {
                this.iOl.setBackgroundDrawable(this.iCl);
            }
        }
        this.iOp = l.g(getPageContext().getPageActivity(), R.dimen.ds935) - l.g(getPageContext().getPageActivity(), R.dimen.ds80);
        this.iOr = new ScreenLockLoadMoreModel(this);
        registerListener(this.iOw);
        initUI();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    public void initUI() {
        this.glb = (ImageView) findViewById(R.id.head_close);
        this.glb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.iOn.getCount() > 0 && (item = ScreenLockActivity.this.iOn.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").l("msg_id", item.msgId / 100).l("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.cjd().iOz.ctu();
            }
        });
        this.iOm = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.iOn = new c(getPageContext().getPageActivity());
        this.iOm.setAdapter((ListAdapter) this.iOn);
        this.iOm.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.iOt, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.cjd().iOF = false;
        this.iOm.setMaxHeight(this.iOp);
        this.iOm.setTranscriptMode(0);
        this.iOm.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.iOq != null && ScreenLockActivity.this.iOq.getParent() != null) {
                    if (ScreenLockActivity.this.iOm.getHeight() != ScreenLockActivity.this.iOp) {
                        ScreenLockActivity.this.iOq.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.iOq.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.iOq.isEnabled()) {
                            ScreenLockActivity.this.iOq.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.iOq.setEnabled(false);
                        }
                        ScreenLockActivity.this.bot();
                    }
                }
            }
        });
    }

    private void cjb() {
        this.iOq = new TextView(getActivity());
        this.iOq.setGravity(17);
        this.iOq.setText(R.string.click_load_more);
        this.iOq.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.iOq.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.iOq.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.iOq.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.iOq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.iOq.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.iOq.setEnabled(false);
                ScreenLockActivity.this.bot();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(cjc())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bot() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.iOr.cjk();
            if (this.iOn != null && this.iOn.getCount() > 0 && (item = this.iOn.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").l("msg_id", item.msgId / 100).l("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.cjd().iOC = 1;
        a.cjd().iOA = 0;
        List<d> cjf = a.cjd().cjf();
        d cjg = a.cjd().cjg();
        a.cjd().release();
        if ((cjf == null || cjf.isEmpty()) && cjg == null && this.iOn.getCount() == 0 && this.iOm.getHeaderViewsCount() == 0) {
            a.cjd().iOz.ctu();
            finish();
            return;
        }
        eb(cjf);
        if (cjg != null) {
            a(cjg);
        }
        if (this.iOs != null) {
            this.iOs.qz(this.iOn.getCount() == 0);
        }
    }

    private void eb(List<d> list) {
        if (list != null && list.size() > 0 && this.iOn != null) {
            this.iOn.ec(list);
            if (this.iOn.isHasMore() && this.iOq == null) {
                cjb();
                this.iOm.addFooterView(this.iOq);
            }
        }
    }

    private void a(d dVar) {
        if (this.iOs == null) {
            this.iOs = new ScreenLockHeaderView(getActivity());
            this.iOs.setUIClickListener(this.iOu, this.iOv);
            this.iOs.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.iOm.addHeaderView(this.iOs);
        }
        this.iOs.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.cjd().iOC = 0;
        a.cjd().iOA = 0;
        if (this.iOs != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.iOs.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.iOt);
        a.cjd().release();
        a.cjd().iOC = 0;
        this.iCl = null;
    }

    public void b(d dVar) {
        int i;
        if (dVar != null) {
            switch (dVar.customGroupType) {
                case 1:
                case 2:
                    i = 3;
                    break;
                case 3:
                default:
                    i = 0;
                    break;
                case 4:
                    i = 2;
                    break;
                case 5:
                    i = 1;
                    break;
            }
            TiebaStatic.log(new an("c11703").l("msg_id", dVar.msgId / 100).l("task_id", dVar.taskId).bT("obj_to", dVar.url).bT(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
            if (!j.kc()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                bb.ajC().c(getPageContext(), new String[]{dVar.url + "&is_from_push=true"});
                TiebaStatic.log(new an("c10316").bT("obj_type", dVar.stat).P("obj_locate", 2));
                a.cjd().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.cjd().d(dVar);
                a.cjd().iOz.ctu();
                if (!a.cjd().iOz.ctw()) {
                    a.cjd().iOz.ctv();
                }
                a.cjd().iOA = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.iOo.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.iOP, 0, dVar.iqr ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.cjd().d(dVar);
                a.cjd().iOA = 0;
                a.cjd().iOz.ctu();
                if (!a.cjd().iOz.ctw()) {
                    a.cjd().iOz.ctv();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.iOo.groupId, 0L), dVar.groupName, dVar.iOP, 0, 4)));
                a.cjd().d(dVar);
                a.cjd().iOA = 0;
                a.cjd().iOz.ctu();
                if (!a.cjd().iOz.ctw()) {
                    a.cjd().iOz.ctv();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.cjd().d(dVar);
                a.cjd().iOz.ctu();
                if (!a.cjd().iOz.ctw()) {
                    a.cjd().iOz.ctv();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.cjd().iOz.ctu();
            finish();
            return true;
        } else if (i == 82) {
            a.cjd().iOz.ctu();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cjc() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) TbadkApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(5);
        if (runningTasks == null || runningTasks.size() <= 0) {
            return null;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
        if (runningTaskInfo == null) {
            return null;
        }
        return runningTaskInfo.topActivity.getClassName();
    }
}
