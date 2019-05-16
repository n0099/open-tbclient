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
    private ImageView geN;
    private Window iHN;
    public c iHP;
    public d iHQ;
    private ScreenLockLoadMoreModel iHT;
    private ScreenLockHeaderView iHU;
    private Drawable ivQ = null;
    public DynamicHeightListView iHO = null;
    private int iHR = 0;
    private TextView iHS = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver iHV = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.cgj().iIb.cqH();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener iHW = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.iHU != null && !StringUtils.isNull(ScreenLockActivity.this.iHU.getInputMsg()) && (data = ScreenLockActivity.this.iHU.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new am("c11703").l("msg_id", data.msgId / 100).l("task_id", data.taskId).bT("obj_to", data.url).bT(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.iHU.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.amy().oV(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.iHU.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.nameShow, data.iIr);
                    com.baidu.tbadk.coreExtra.messageCenter.b.amy().oV(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.cgj().iIb.cqH();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.iHQ = ScreenLockActivity.this.iHP.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.iHQ);
        }
    };
    private View.OnClickListener iHX = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.iHU != null) {
                ScreenLockActivity.this.iHQ = ScreenLockActivity.this.iHU.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.iHQ);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iHY = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.iHS != null) {
                            ScreenLockActivity.this.iHS.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.iHS.setEnabled(true);
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
                        ArrayList<d> cgp = data.cgp();
                        if (ScreenLockActivity.this.iHP != null) {
                            ScreenLockActivity.this.iHP.ea(cgp);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.iHP.setHasMore(false);
                            if (ScreenLockActivity.this.iHS != null) {
                                ScreenLockActivity.this.iHO.removeFooterView(ScreenLockActivity.this.iHS);
                                ScreenLockActivity.this.iHS = null;
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
        this.iHN = getWindow();
        this.iHN.addFlags(524288);
        this.iHN.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.kl()) {
            this.ivQ = com.baidu.tieba.t.b.cqK();
            if (this.ivQ != null) {
                this.iHN.setBackgroundDrawable(this.ivQ);
            }
        }
        this.iHR = l.g(getPageContext().getPageActivity(), R.dimen.ds935) - l.g(getPageContext().getPageActivity(), R.dimen.ds80);
        this.iHT = new ScreenLockLoadMoreModel(this);
        registerListener(this.iHY);
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
        this.geN = (ImageView) findViewById(R.id.head_close);
        this.geN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.iHP.getCount() > 0 && (item = ScreenLockActivity.this.iHP.getItem(0)) != null) {
                    TiebaStatic.log(new am("c11704").l("msg_id", item.msgId / 100).l("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.cgj().iIb.cqH();
            }
        });
        this.iHO = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.iHP = new c(getPageContext().getPageActivity());
        this.iHO.setAdapter((ListAdapter) this.iHP);
        this.iHO.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.iHV, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.cgj().iIh = false;
        this.iHO.setMaxHeight(this.iHR);
        this.iHO.setTranscriptMode(0);
        this.iHO.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.iHS != null && ScreenLockActivity.this.iHS.getParent() != null) {
                    if (ScreenLockActivity.this.iHO.getHeight() != ScreenLockActivity.this.iHR) {
                        ScreenLockActivity.this.iHS.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.iHS.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.iHS.isEnabled()) {
                            ScreenLockActivity.this.iHS.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.iHS.setEnabled(false);
                        }
                        ScreenLockActivity.this.bmp();
                    }
                }
            }
        });
    }

    private void cgh() {
        this.iHS = new TextView(getActivity());
        this.iHS.setGravity(17);
        this.iHS.setText(R.string.click_load_more);
        this.iHS.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.iHS.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.iHS.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.iHS.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.iHS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.iHS.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.iHS.setEnabled(false);
                ScreenLockActivity.this.bmp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(cgi())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmp() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.iHT.cgq();
            if (this.iHP != null && this.iHP.getCount() > 0 && (item = this.iHP.getItem(0)) != null) {
                TiebaStatic.log(new am("c11738").l("msg_id", item.msgId / 100).l("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.cgj().iIe = 1;
        a.cgj().iIc = 0;
        List<d> cgl = a.cgj().cgl();
        d cgm = a.cgj().cgm();
        a.cgj().release();
        if ((cgl == null || cgl.isEmpty()) && cgm == null && this.iHP.getCount() == 0 && this.iHO.getHeaderViewsCount() == 0) {
            a.cgj().iIb.cqH();
            finish();
            return;
        }
        dZ(cgl);
        if (cgm != null) {
            a(cgm);
        }
        if (this.iHU != null) {
            this.iHU.qj(this.iHP.getCount() == 0);
        }
    }

    private void dZ(List<d> list) {
        if (list != null && list.size() > 0 && this.iHP != null) {
            this.iHP.ea(list);
            if (this.iHP.isHasMore() && this.iHS == null) {
                cgh();
                this.iHO.addFooterView(this.iHS);
            }
        }
    }

    private void a(d dVar) {
        if (this.iHU == null) {
            this.iHU = new ScreenLockHeaderView(getActivity());
            this.iHU.setUIClickListener(this.iHW, this.iHX);
            this.iHU.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.iHO.addHeaderView(this.iHU);
        }
        this.iHU.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.cgj().iIe = 0;
        a.cgj().iIc = 0;
        if (this.iHU != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.iHU.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.iHV);
        a.cgj().release();
        a.cgj().iIe = 0;
        this.ivQ = null;
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
                a.cgj().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.cgj().d(dVar);
                a.cgj().iIb.cqH();
                if (!a.cgj().iIb.cqJ()) {
                    a.cgj().iIb.cqI();
                }
                a.cgj().iIc = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.iHQ.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.iIr, 0, dVar.ijV ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.cgj().d(dVar);
                a.cgj().iIc = 0;
                a.cgj().iIb.cqH();
                if (!a.cgj().iIb.cqJ()) {
                    a.cgj().iIb.cqI();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.iHQ.groupId, 0L), dVar.groupName, dVar.iIr, 0, 4)));
                a.cgj().d(dVar);
                a.cgj().iIc = 0;
                a.cgj().iIb.cqH();
                if (!a.cgj().iIb.cqJ()) {
                    a.cgj().iIb.cqI();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.cgj().d(dVar);
                a.cgj().iIb.cqH();
                if (!a.cgj().iIb.cqJ()) {
                    a.cgj().iIb.cqI();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.cgj().iIb.cqH();
            finish();
            return true;
        } else if (i == 82) {
            a.cgj().iIb.cqH();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cgi() {
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
