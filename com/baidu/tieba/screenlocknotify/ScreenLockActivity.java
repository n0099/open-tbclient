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
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
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
/* loaded from: classes15.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView gIn;
    private Window lLK;
    public c lLM;
    public d lLN;
    private ScreenLockLoadMoreModel lLQ;
    private ScreenLockHeaderView lLR;
    private Drawable lyz = null;
    public DynamicHeightListView lLL = null;
    private int lLO = 0;
    private TextView lLP = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver lLS = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.dpc().lLY.dAH();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener lLT = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.lLR != null && !StringUtils.isNull(ScreenLockActivity.this.lLR.getInputMsg()) && (data = ScreenLockActivity.this.lLR.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.PUSH_CCLICK).u("msg_id", data.msgId / 100).u("task_id", data.taskId).dD(TiebaInitialize.Params.OBJ_TO, data.url).dD("app_version", TbConfig.getVersion()).ai("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.lLR.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.bnV().Ba(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.lLR.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.lMn);
                    com.baidu.tbadk.coreExtra.messageCenter.b.bnV().Ba(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new aj("lockscreen_reply", true).start();
                a.dpc().lLY.dAH();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.lLN = ScreenLockActivity.this.lLM.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.lLN);
        }
    };
    private View.OnClickListener lLU = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.lLR != null) {
                ScreenLockActivity.this.lLN = ScreenLockActivity.this.lLR.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.lLN);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lLV = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.lLP != null) {
                            ScreenLockActivity.this.lLP.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.lLP.setEnabled(true);
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
                        ArrayList<d> dpi = data.dpi();
                        if (ScreenLockActivity.this.lLM != null) {
                            ScreenLockActivity.this.lLM.fb(dpi);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.lLM.setHasMore(false);
                            if (ScreenLockActivity.this.lLP != null) {
                                ScreenLockActivity.this.lLL.removeFooterView(ScreenLockActivity.this.lLP);
                                ScreenLockActivity.this.lLP = null;
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
        this.lLK = getWindow();
        this.lLK.addFlags(524288);
        this.lLK.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.lyz = com.baidu.tieba.v.b.dAL();
            if (this.lyz != null) {
                this.lLK.setBackgroundDrawable(this.lyz);
            }
        }
        this.lLO = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.lLQ = new ScreenLockLoadMoreModel(this);
        registerListener(this.lLV);
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
        this.gIn = (ImageView) findViewById(R.id.head_close);
        this.gIn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.lLM.getCount() > 0 && (item = ScreenLockActivity.this.lLM.getItem(0)) != null) {
                    TiebaStatic.log(new aq("c11704").u("msg_id", item.msgId / 100).u("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.dpc().lLY.dAH();
            }
        });
        this.lLL = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.lLM = new c(getPageContext().getPageActivity());
        this.lLL.setAdapter((ListAdapter) this.lLM);
        this.lLL.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.lLS, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.dpc().lMe = false;
        this.lLL.setMaxHeight(this.lLO);
        this.lLL.setTranscriptMode(0);
        this.lLL.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.lLP != null && ScreenLockActivity.this.lLP.getParent() != null) {
                    if (ScreenLockActivity.this.lLL.getHeight() != ScreenLockActivity.this.lLO) {
                        ScreenLockActivity.this.lLP.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.lLP.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.lLP.isEnabled()) {
                            ScreenLockActivity.this.lLP.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.lLP.setEnabled(false);
                        }
                        ScreenLockActivity.this.coV();
                    }
                }
            }
        });
    }

    private void dpa() {
        this.lLP = new TextView(getActivity());
        this.lLP.setGravity(17);
        this.lLP.setText(R.string.click_load_more);
        this.lLP.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.lLP.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.lLP.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.lLP.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.lLP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.lLP.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.lLP.setEnabled(false);
                ScreenLockActivity.this.coV();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(dpb())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coV() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.lLQ.dpj();
            if (this.lLM != null && this.lLM.getCount() > 0 && (item = this.lLM.getItem(0)) != null) {
                TiebaStatic.log(new aq("c11738").u("msg_id", item.msgId / 100).u("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.dpc().lMb = 1;
        a.dpc().lLZ = 0;
        List<d> dpe = a.dpc().dpe();
        d dpf = a.dpc().dpf();
        a.dpc().release();
        if ((dpe == null || dpe.isEmpty()) && dpf == null && this.lLM.getCount() == 0 && this.lLL.getHeaderViewsCount() == 0) {
            a.dpc().lLY.dAH();
            finish();
            return;
        }
        fa(dpe);
        if (dpf != null) {
            a(dpf);
        }
        if (this.lLR != null) {
            this.lLR.vx(this.lLM.getCount() == 0);
        }
    }

    private void fa(List<d> list) {
        if (list != null && list.size() > 0 && this.lLM != null) {
            this.lLM.fb(list);
            if (this.lLM.isHasMore() && this.lLP == null) {
                dpa();
                this.lLL.addFooterView(this.lLP);
            }
        }
    }

    private void a(d dVar) {
        if (this.lLR == null) {
            this.lLR = new ScreenLockHeaderView(getActivity());
            this.lLR.setUIClickListener(this.lLT, this.lLU);
            this.lLR.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.lLL.addHeaderView(this.lLR);
        }
        this.lLR.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.dpc().lMb = 0;
        a.dpc().lLZ = 0;
        if (this.lLR != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.lLR.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.lLS);
        a.dpc().release();
        a.dpc().lMb = 0;
        this.lyz = null;
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
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.PUSH_CCLICK).u("msg_id", dVar.msgId / 100).u("task_id", dVar.taskId).dD(TiebaInitialize.Params.OBJ_TO, dVar.url).dD("app_version", TbConfig.getVersion()).ai("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                be.bju().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY + "=true"});
                TiebaStatic.log(new aq("c10316").dD("obj_type", dVar.stat).ai("obj_locate", 2));
                a.dpc().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.dpc().d(dVar);
                a.dpc().lLY.dAH();
                if (!a.dpc().lLY.dAJ()) {
                    a.dpc().lLY.dAI();
                }
                a.dpc().lLZ = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.lLN.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.lMn, 0, dVar.llX ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.dpc().d(dVar);
                a.dpc().lLZ = 0;
                a.dpc().lLY.dAH();
                if (!a.dpc().lLY.dAJ()) {
                    a.dpc().lLY.dAI();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.lLN.groupId, 0L), dVar.groupName, dVar.lMn, 0, 4)));
                a.dpc().d(dVar);
                a.dpc().lLZ = 0;
                a.dpc().lLY.dAH();
                if (!a.dpc().lLY.dAJ()) {
                    a.dpc().lLY.dAI();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.dpc().d(dVar);
                a.dpc().lLY.dAH();
                if (!a.dpc().lLY.dAJ()) {
                    a.dpc().lLY.dAI();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.dpc().lLY.dAH();
            finish();
            return true;
        } else if (i == 82) {
            a.dpc().lLY.dAH();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String dpb() {
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
