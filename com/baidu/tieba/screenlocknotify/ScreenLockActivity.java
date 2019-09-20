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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.view.ScreenLockHeaderView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView gnI;
    private Window iRL;
    public c iRN;
    public d iRO;
    private ScreenLockLoadMoreModel iRR;
    private ScreenLockHeaderView iRS;
    private Drawable iFH = null;
    public DynamicHeightListView iRM = null;
    private int iRP = 0;
    private TextView iRQ = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver iRT = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.ckh().iRZ.cuE();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener iRU = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.iRS != null && !StringUtils.isNull(ScreenLockActivity.this.iRS.getInputMsg()) && (data = ScreenLockActivity.this.iRS.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an("c11703").n("msg_id", data.msgId / 100).n("task_id", data.taskId).bT("obj_to", data.url).bT("app_version", TbConfig.getVersion()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.iRS.getInputMsg(), com.baidu.adp.lib.g.b.e(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.anR().pw(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.iRS.getInputMsg(), com.baidu.adp.lib.g.b.e(data.groupId, 0L), data.userName, data.nameShow, data.iSp);
                    com.baidu.tbadk.coreExtra.messageCenter.b.anR().pw(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.ckh().iRZ.cuE();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.iRO = ScreenLockActivity.this.iRN.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.iRO);
        }
    };
    private View.OnClickListener iRV = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.iRS != null) {
                ScreenLockActivity.this.iRO = ScreenLockActivity.this.iRS.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.iRO);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iRW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.iRQ != null) {
                            ScreenLockActivity.this.iRQ.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.iRQ.setEnabled(true);
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
                        ArrayList<d> ckn = data.ckn();
                        if (ScreenLockActivity.this.iRN != null) {
                            ScreenLockActivity.this.iRN.eb(ckn);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.iRN.setHasMore(false);
                            if (ScreenLockActivity.this.iRQ != null) {
                                ScreenLockActivity.this.iRM.removeFooterView(ScreenLockActivity.this.iRQ);
                                ScreenLockActivity.this.iRQ = null;
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
        this.iRL = getWindow();
        this.iRL.addFlags(524288);
        this.iRL.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.kw()) {
            this.iFH = com.baidu.tieba.t.b.cuI();
            if (this.iFH != null) {
                this.iRL.setBackgroundDrawable(this.iFH);
            }
        }
        this.iRP = l.g(getPageContext().getPageActivity(), R.dimen.ds935) - l.g(getPageContext().getPageActivity(), R.dimen.ds80);
        this.iRR = new ScreenLockLoadMoreModel(this);
        registerListener(this.iRW);
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
        this.gnI = (ImageView) findViewById(R.id.head_close);
        this.gnI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.iRN.getCount() > 0 && (item = ScreenLockActivity.this.iRN.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").n("msg_id", item.msgId / 100).n("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.ckh().iRZ.cuE();
            }
        });
        this.iRM = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.iRN = new c(getPageContext().getPageActivity());
        this.iRM.setAdapter((ListAdapter) this.iRN);
        this.iRM.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.iRT, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.ckh().iSf = false;
        this.iRM.setMaxHeight(this.iRP);
        this.iRM.setTranscriptMode(0);
        this.iRM.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.iRQ != null && ScreenLockActivity.this.iRQ.getParent() != null) {
                    if (ScreenLockActivity.this.iRM.getHeight() != ScreenLockActivity.this.iRP) {
                        ScreenLockActivity.this.iRQ.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.iRQ.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.iRQ.isEnabled()) {
                            ScreenLockActivity.this.iRQ.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.iRQ.setEnabled(false);
                        }
                        ScreenLockActivity.this.bpr();
                    }
                }
            }
        });
    }

    private void ckf() {
        this.iRQ = new TextView(getActivity());
        this.iRQ.setGravity(17);
        this.iRQ.setText(R.string.click_load_more);
        this.iRQ.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.iRQ.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.iRQ.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.iRQ.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.iRQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.iRQ.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.iRQ.setEnabled(false);
                ScreenLockActivity.this.bpr();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(ckg())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpr() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.iRR.cko();
            if (this.iRN != null && this.iRN.getCount() > 0 && (item = this.iRN.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").n("msg_id", item.msgId / 100).n("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.ckh().iSc = 1;
        a.ckh().iSa = 0;
        List<d> ckj = a.ckh().ckj();
        d ckk = a.ckh().ckk();
        a.ckh().release();
        if ((ckj == null || ckj.isEmpty()) && ckk == null && this.iRN.getCount() == 0 && this.iRM.getHeaderViewsCount() == 0) {
            a.ckh().iRZ.cuE();
            finish();
            return;
        }
        ea(ckj);
        if (ckk != null) {
            a(ckk);
        }
        if (this.iRS != null) {
            this.iRS.qD(this.iRN.getCount() == 0);
        }
    }

    private void ea(List<d> list) {
        if (list != null && list.size() > 0 && this.iRN != null) {
            this.iRN.eb(list);
            if (this.iRN.isHasMore() && this.iRQ == null) {
                ckf();
                this.iRM.addFooterView(this.iRQ);
            }
        }
    }

    private void a(d dVar) {
        if (this.iRS == null) {
            this.iRS = new ScreenLockHeaderView(getActivity());
            this.iRS.setUIClickListener(this.iRU, this.iRV);
            this.iRS.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.iRM.addHeaderView(this.iRS);
        }
        this.iRS.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.ckh().iSc = 0;
        a.ckh().iSa = 0;
        if (this.iRS != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.iRS.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.iRT);
        a.ckh().release();
        a.ckh().iSc = 0;
        this.iFH = null;
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
            TiebaStatic.log(new an("c11703").n("msg_id", dVar.msgId / 100).n("task_id", dVar.taskId).bT("obj_to", dVar.url).bT("app_version", TbConfig.getVersion()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
            if (!j.kc()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ba.ajK().c(getPageContext(), new String[]{dVar.url + "&is_from_push=true"});
                TiebaStatic.log(new an("c10316").bT("obj_type", dVar.stat).P("obj_locate", 2));
                a.ckh().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.e(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.ckh().d(dVar);
                a.ckh().iRZ.cuE();
                if (!a.ckh().iRZ.cuG()) {
                    a.ckh().iRZ.cuF();
                }
                a.ckh().iSa = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.e(this.iRO.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.iSp, 0, dVar.itu ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.ckh().d(dVar);
                a.ckh().iSa = 0;
                a.ckh().iRZ.cuE();
                if (!a.ckh().iRZ.cuG()) {
                    a.ckh().iRZ.cuF();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.e(this.iRO.groupId, 0L), dVar.groupName, dVar.iSp, 0, 4)));
                a.ckh().d(dVar);
                a.ckh().iSa = 0;
                a.ckh().iRZ.cuE();
                if (!a.ckh().iRZ.cuG()) {
                    a.ckh().iRZ.cuF();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.ckh().d(dVar);
                a.ckh().iRZ.cuE();
                if (!a.ckh().iRZ.cuG()) {
                    a.ckh().iRZ.cuF();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.ckh().iRZ.cuE();
            finish();
            return true;
        } else if (i == 82) {
            a.ckh().iRZ.cuE();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String ckg() {
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
