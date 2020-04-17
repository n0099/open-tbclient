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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
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
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView fOY;
    private Window kzS;
    public c kzU;
    public d kzV;
    private ScreenLockLoadMoreModel kzY;
    private ScreenLockHeaderView kzZ;
    private Drawable knK = null;
    public DynamicHeightListView kzT = null;
    private int kzW = 0;
    private TextView kzX = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver kAa = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.cOX().kAg.dao();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener kAb = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.kzZ != null && !StringUtils.isNull(ScreenLockActivity.this.kzZ.getInputMsg()) && (data = ScreenLockActivity.this.kzZ.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).t("msg_id", data.msgId / 100).t("task_id", data.taskId).cI(TiebaInitialize.Params.OBJ_TO, data.url).cI("app_version", TbConfig.getVersion()).af("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.kzZ.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.aTg().vD(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.kzZ.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.kAv);
                    com.baidu.tbadk.coreExtra.messageCenter.b.aTg().vD(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.cOX().kAg.dao();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.kzV = ScreenLockActivity.this.kzU.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.kzV);
        }
    };
    private View.OnClickListener kAc = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.kzZ != null) {
                ScreenLockActivity.this.kzV = ScreenLockActivity.this.kzZ.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.kzV);
            }
        }
    };
    private com.baidu.adp.framework.listener.a kAd = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.kzX != null) {
                            ScreenLockActivity.this.kzX.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.kzX.setEnabled(true);
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
                        ArrayList<d> cPd = data.cPd();
                        if (ScreenLockActivity.this.kzU != null) {
                            ScreenLockActivity.this.kzU.eq(cPd);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.kzU.setHasMore(false);
                            if (ScreenLockActivity.this.kzX != null) {
                                ScreenLockActivity.this.kzT.removeFooterView(ScreenLockActivity.this.kzX);
                                ScreenLockActivity.this.kzX = null;
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
        this.kzS = getWindow();
        this.kzS.addFlags(524288);
        this.kzS.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.knK = com.baidu.tieba.v.b.das();
            if (this.knK != null) {
                this.kzS.setBackgroundDrawable(this.knK);
            }
        }
        this.kzW = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.kzY = new ScreenLockLoadMoreModel(this);
        registerListener(this.kAd);
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
        this.fOY = (ImageView) findViewById(R.id.head_close);
        this.fOY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.kzU.getCount() > 0 && (item = ScreenLockActivity.this.kzU.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").t("msg_id", item.msgId / 100).t("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.cOX().kAg.dao();
            }
        });
        this.kzT = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.kzU = new c(getPageContext().getPageActivity());
        this.kzT.setAdapter((ListAdapter) this.kzU);
        this.kzT.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.kAa, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.cOX().kAm = false;
        this.kzT.setMaxHeight(this.kzW);
        this.kzT.setTranscriptMode(0);
        this.kzT.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.kzX != null && ScreenLockActivity.this.kzX.getParent() != null) {
                    if (ScreenLockActivity.this.kzT.getHeight() != ScreenLockActivity.this.kzW) {
                        ScreenLockActivity.this.kzX.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.kzX.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.kzX.isEnabled()) {
                            ScreenLockActivity.this.kzX.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.kzX.setEnabled(false);
                        }
                        ScreenLockActivity.this.bRk();
                    }
                }
            }
        });
    }

    private void cOV() {
        this.kzX = new TextView(getActivity());
        this.kzX.setGravity(17);
        this.kzX.setText(R.string.click_load_more);
        this.kzX.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.kzX.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.kzX.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.kzX.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.kzX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.kzX.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.kzX.setEnabled(false);
                ScreenLockActivity.this.bRk();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(cOW())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRk() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.kzY.cPe();
            if (this.kzU != null && this.kzU.getCount() > 0 && (item = this.kzU.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").t("msg_id", item.msgId / 100).t("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.cOX().kAj = 1;
        a.cOX().kAh = 0;
        List<d> cOZ = a.cOX().cOZ();
        d cPa = a.cOX().cPa();
        a.cOX().release();
        if ((cOZ == null || cOZ.isEmpty()) && cPa == null && this.kzU.getCount() == 0 && this.kzT.getHeaderViewsCount() == 0) {
            a.cOX().kAg.dao();
            finish();
            return;
        }
        ep(cOZ);
        if (cPa != null) {
            a(cPa);
        }
        if (this.kzZ != null) {
            this.kzZ.tr(this.kzU.getCount() == 0);
        }
    }

    private void ep(List<d> list) {
        if (list != null && list.size() > 0 && this.kzU != null) {
            this.kzU.eq(list);
            if (this.kzU.isHasMore() && this.kzX == null) {
                cOV();
                this.kzT.addFooterView(this.kzX);
            }
        }
    }

    private void a(d dVar) {
        if (this.kzZ == null) {
            this.kzZ = new ScreenLockHeaderView(getActivity());
            this.kzZ.setUIClickListener(this.kAb, this.kAc);
            this.kzZ.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.kzT.addHeaderView(this.kzZ);
        }
        this.kzZ.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.cOX().kAj = 0;
        a.cOX().kAh = 0;
        if (this.kzZ != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.kzZ.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.kAa);
        a.cOX().release();
        a.cOX().kAj = 0;
        this.knK = null;
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
            TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).t("msg_id", dVar.msgId / 100).t("task_id", dVar.taskId).cI(TiebaInitialize.Params.OBJ_TO, dVar.url).cI("app_version", TbConfig.getVersion()).af("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ba.aOY().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + "is_from_push=true"});
                TiebaStatic.log(new an("c10316").cI("obj_type", dVar.stat).af("obj_locate", 2));
                a.cOX().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.cOX().d(dVar);
                a.cOX().kAg.dao();
                if (!a.cOX().kAg.daq()) {
                    a.cOX().kAg.dap();
                }
                a.cOX().kAh = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.kzV.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.kAv, 0, dVar.kag ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.cOX().d(dVar);
                a.cOX().kAh = 0;
                a.cOX().kAg.dao();
                if (!a.cOX().kAg.daq()) {
                    a.cOX().kAg.dap();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.kzV.groupId, 0L), dVar.groupName, dVar.kAv, 0, 4)));
                a.cOX().d(dVar);
                a.cOX().kAh = 0;
                a.cOX().kAg.dao();
                if (!a.cOX().kAg.daq()) {
                    a.cOX().kAg.dap();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.cOX().d(dVar);
                a.cOX().kAg.dao();
                if (!a.cOX().kAg.daq()) {
                    a.cOX().kAg.dap();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.cOX().kAg.dao();
            finish();
            return true;
        } else if (i == 82) {
            a.cOX().kAg.dao();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cOW() {
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
