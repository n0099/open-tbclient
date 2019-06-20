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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
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
    private ImageView geQ;
    private Window iHT;
    public c iHV;
    public d iHW;
    private ScreenLockLoadMoreModel iHZ;
    private ScreenLockHeaderView iIa;
    private Drawable ivU = null;
    public DynamicHeightListView iHU = null;
    private int iHX = 0;
    private TextView iHY = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver iIb = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.cgm().iIh.cqK();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener iIc = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.iIa != null && !StringUtils.isNull(ScreenLockActivity.this.iIa.getInputMsg()) && (data = ScreenLockActivity.this.iIa.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new am("c11703").l("msg_id", data.msgId / 100).l("task_id", data.taskId).bT("obj_to", data.url).bT(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.iIa.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.amy().oU(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.iIa.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.nameShow, data.iIx);
                    com.baidu.tbadk.coreExtra.messageCenter.b.amy().oU(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.cgm().iIh.cqK();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.iHW = ScreenLockActivity.this.iHV.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.iHW);
        }
    };
    private View.OnClickListener iId = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.iIa != null) {
                ScreenLockActivity.this.iHW = ScreenLockActivity.this.iIa.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.iHW);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iIe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.iHY != null) {
                            ScreenLockActivity.this.iHY.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.iHY.setEnabled(true);
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
                        ArrayList<d> cgs = data.cgs();
                        if (ScreenLockActivity.this.iHV != null) {
                            ScreenLockActivity.this.iHV.ea(cgs);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.iHV.setHasMore(false);
                            if (ScreenLockActivity.this.iHY != null) {
                                ScreenLockActivity.this.iHU.removeFooterView(ScreenLockActivity.this.iHY);
                                ScreenLockActivity.this.iHY = null;
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
        this.iHT = getWindow();
        this.iHT.addFlags(524288);
        this.iHT.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.kl()) {
            this.ivU = com.baidu.tieba.t.b.cqN();
            if (this.ivU != null) {
                this.iHT.setBackgroundDrawable(this.ivU);
            }
        }
        this.iHX = l.g(getPageContext().getPageActivity(), R.dimen.ds935) - l.g(getPageContext().getPageActivity(), R.dimen.ds80);
        this.iHZ = new ScreenLockLoadMoreModel(this);
        registerListener(this.iIe);
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
        this.geQ = (ImageView) findViewById(R.id.head_close);
        this.geQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.iHV.getCount() > 0 && (item = ScreenLockActivity.this.iHV.getItem(0)) != null) {
                    TiebaStatic.log(new am("c11704").l("msg_id", item.msgId / 100).l("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.cgm().iIh.cqK();
            }
        });
        this.iHU = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.iHV = new c(getPageContext().getPageActivity());
        this.iHU.setAdapter((ListAdapter) this.iHV);
        this.iHU.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.iIb, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.cgm().iIn = false;
        this.iHU.setMaxHeight(this.iHX);
        this.iHU.setTranscriptMode(0);
        this.iHU.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.iHY != null && ScreenLockActivity.this.iHY.getParent() != null) {
                    if (ScreenLockActivity.this.iHU.getHeight() != ScreenLockActivity.this.iHX) {
                        ScreenLockActivity.this.iHY.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.iHY.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.iHY.isEnabled()) {
                            ScreenLockActivity.this.iHY.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.iHY.setEnabled(false);
                        }
                        ScreenLockActivity.this.bms();
                    }
                }
            }
        });
    }

    private void cgk() {
        this.iHY = new TextView(getActivity());
        this.iHY.setGravity(17);
        this.iHY.setText(R.string.click_load_more);
        this.iHY.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.iHY.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.iHY.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.iHY.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.iHY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.iHY.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.iHY.setEnabled(false);
                ScreenLockActivity.this.bms();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(cgl())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bms() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.iHZ.cgt();
            if (this.iHV != null && this.iHV.getCount() > 0 && (item = this.iHV.getItem(0)) != null) {
                TiebaStatic.log(new am("c11738").l("msg_id", item.msgId / 100).l("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.cgm().iIk = 1;
        a.cgm().iIi = 0;
        List<d> cgo = a.cgm().cgo();
        d cgp = a.cgm().cgp();
        a.cgm().release();
        if ((cgo == null || cgo.isEmpty()) && cgp == null && this.iHV.getCount() == 0 && this.iHU.getHeaderViewsCount() == 0) {
            a.cgm().iIh.cqK();
            finish();
            return;
        }
        dZ(cgo);
        if (cgp != null) {
            a(cgp);
        }
        if (this.iIa != null) {
            this.iIa.qk(this.iHV.getCount() == 0);
        }
    }

    private void dZ(List<d> list) {
        if (list != null && list.size() > 0 && this.iHV != null) {
            this.iHV.ea(list);
            if (this.iHV.isHasMore() && this.iHY == null) {
                cgk();
                this.iHU.addFooterView(this.iHY);
            }
        }
    }

    private void a(d dVar) {
        if (this.iIa == null) {
            this.iIa = new ScreenLockHeaderView(getActivity());
            this.iIa.setUIClickListener(this.iIc, this.iId);
            this.iIa.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.iHU.addHeaderView(this.iIa);
        }
        this.iIa.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.cgm().iIk = 0;
        a.cgm().iIi = 0;
        if (this.iIa != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.iIa.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.iIb);
        a.cgm().release();
        a.cgm().iIk = 0;
        this.ivU = null;
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
            TiebaStatic.log(new am("c11703").l("msg_id", dVar.msgId / 100).l("task_id", dVar.taskId).bT("obj_to", dVar.url).bT(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
            if (!j.jS()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ba.aiz().c(getPageContext(), new String[]{dVar.url + "&is_from_push=true"});
                TiebaStatic.log(new am("c10316").bT("obj_type", dVar.stat).P("obj_locate", 2));
                a.cgm().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.cgm().d(dVar);
                a.cgm().iIh.cqK();
                if (!a.cgm().iIh.cqM()) {
                    a.cgm().iIh.cqL();
                }
                a.cgm().iIi = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.iHW.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.iIx, 0, dVar.ijZ ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.cgm().d(dVar);
                a.cgm().iIi = 0;
                a.cgm().iIh.cqK();
                if (!a.cgm().iIh.cqM()) {
                    a.cgm().iIh.cqL();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.iHW.groupId, 0L), dVar.groupName, dVar.iIx, 0, 4)));
                a.cgm().d(dVar);
                a.cgm().iIi = 0;
                a.cgm().iIh.cqK();
                if (!a.cgm().iIh.cqM()) {
                    a.cgm().iIh.cqL();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.cgm().d(dVar);
                a.cgm().iIh.cqK();
                if (!a.cgm().iIh.cqM()) {
                    a.cgm().iIh.cqL();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.cgm().iIh.cqK();
            finish();
            return true;
        } else if (i == 82) {
            a.cgm().iIh.cqK();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cgl() {
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
