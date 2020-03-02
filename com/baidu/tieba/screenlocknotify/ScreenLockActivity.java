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
    private ImageView fjU;
    private Window jOQ;
    public c jOS;
    public d jOT;
    private ScreenLockLoadMoreModel jOW;
    private ScreenLockHeaderView jOX;
    private Drawable jCg = null;
    public DynamicHeightListView jOR = null;
    private int jOU = 0;
    private TextView jOV = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver jOY = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.cEb().jPe.cOX();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener jOZ = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.jOX != null && !StringUtils.isNull(ScreenLockActivity.this.jOX.getInputMsg()) && (data = ScreenLockActivity.this.jOX.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).s("msg_id", data.msgId / 100).s("task_id", data.taskId).cy(TiebaInitialize.Params.OBJ_TO, data.url).cy("app_version", TbConfig.getVersion()).X("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.jOX.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKE().uo(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.jOX.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.jPt);
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKE().uo(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.cEb().jPe.cOX();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.jOT = ScreenLockActivity.this.jOS.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.jOT);
        }
    };
    private View.OnClickListener jPa = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.jOX != null) {
                ScreenLockActivity.this.jOT = ScreenLockActivity.this.jOX.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.jOT);
            }
        }
    };
    private com.baidu.adp.framework.listener.a jPb = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.jOV != null) {
                            ScreenLockActivity.this.jOV.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.jOV.setEnabled(true);
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
                        ArrayList<d> items = data.getItems();
                        if (ScreenLockActivity.this.jOS != null) {
                            ScreenLockActivity.this.jOS.ec(items);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.jOS.setHasMore(false);
                            if (ScreenLockActivity.this.jOV != null) {
                                ScreenLockActivity.this.jOR.removeFooterView(ScreenLockActivity.this.jOV);
                                ScreenLockActivity.this.jOV = null;
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
        this.jOQ = getWindow();
        this.jOQ.addFlags(524288);
        this.jOQ.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.jCg = com.baidu.tieba.v.b.cPb();
            if (this.jCg != null) {
                this.jOQ.setBackgroundDrawable(this.jCg);
            }
        }
        this.jOU = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.jOW = new ScreenLockLoadMoreModel(this);
        registerListener(this.jPb);
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
        this.fjU = (ImageView) findViewById(R.id.head_close);
        this.fjU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.jOS.getCount() > 0 && (item = ScreenLockActivity.this.jOS.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").s("msg_id", item.msgId / 100).s("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.cEb().jPe.cOX();
            }
        });
        this.jOR = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.jOS = new c(getPageContext().getPageActivity());
        this.jOR.setAdapter((ListAdapter) this.jOS);
        this.jOR.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.jOY, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.cEb().jPk = false;
        this.jOR.setMaxHeight(this.jOU);
        this.jOR.setTranscriptMode(0);
        this.jOR.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.jOV != null && ScreenLockActivity.this.jOV.getParent() != null) {
                    if (ScreenLockActivity.this.jOR.getHeight() != ScreenLockActivity.this.jOU) {
                        ScreenLockActivity.this.jOV.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.jOV.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.jOV.isEnabled()) {
                            ScreenLockActivity.this.jOV.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.jOV.setEnabled(false);
                        }
                        ScreenLockActivity.this.bGw();
                    }
                }
            }
        });
    }

    private void cDZ() {
        this.jOV = new TextView(getActivity());
        this.jOV.setGravity(17);
        this.jOV.setText(R.string.click_load_more);
        this.jOV.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.jOV.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.jOV.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.jOV.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.jOV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.jOV.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.jOV.setEnabled(false);
                ScreenLockActivity.this.bGw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(cEa())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGw() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.jOW.cEh();
            if (this.jOS != null && this.jOS.getCount() > 0 && (item = this.jOS.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").s("msg_id", item.msgId / 100).s("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.cEb().jPh = 1;
        a.cEb().jPf = 0;
        List<d> cEd = a.cEb().cEd();
        d cEe = a.cEb().cEe();
        a.cEb().release();
        if ((cEd == null || cEd.isEmpty()) && cEe == null && this.jOS.getCount() == 0 && this.jOR.getHeaderViewsCount() == 0) {
            a.cEb().jPe.cOX();
            finish();
            return;
        }
        eb(cEd);
        if (cEe != null) {
            a(cEe);
        }
        if (this.jOX != null) {
            this.jOX.sk(this.jOS.getCount() == 0);
        }
    }

    private void eb(List<d> list) {
        if (list != null && list.size() > 0 && this.jOS != null) {
            this.jOS.ec(list);
            if (this.jOS.isHasMore() && this.jOV == null) {
                cDZ();
                this.jOR.addFooterView(this.jOV);
            }
        }
    }

    private void a(d dVar) {
        if (this.jOX == null) {
            this.jOX = new ScreenLockHeaderView(getActivity());
            this.jOX.setUIClickListener(this.jOZ, this.jPa);
            this.jOX.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.jOR.addHeaderView(this.jOX);
        }
        this.jOX.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.cEb().jPh = 0;
        a.cEb().jPf = 0;
        if (this.jOX != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.jOX.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.jOY);
        a.cEb().release();
        a.cEb().jPh = 0;
        this.jCg = null;
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
            TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).s("msg_id", dVar.msgId / 100).s("task_id", dVar.taskId).cy(TiebaInitialize.Params.OBJ_TO, dVar.url).cy("app_version", TbConfig.getVersion()).X("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ba.aGG().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + "is_from_push=true"});
                TiebaStatic.log(new an("c10316").cy("obj_type", dVar.stat).X("obj_locate", 2));
                a.cEb().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.cEb().d(dVar);
                a.cEb().jPe.cOX();
                if (!a.cEb().jPe.cOZ()) {
                    a.cEb().jPe.cOY();
                }
                a.cEb().jPf = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.jOT.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.jPt, 0, dVar.joh ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.cEb().d(dVar);
                a.cEb().jPf = 0;
                a.cEb().jPe.cOX();
                if (!a.cEb().jPe.cOZ()) {
                    a.cEb().jPe.cOY();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.jOT.groupId, 0L), dVar.groupName, dVar.jPt, 0, 4)));
                a.cEb().d(dVar);
                a.cEb().jPf = 0;
                a.cEb().jPe.cOX();
                if (!a.cEb().jPe.cOZ()) {
                    a.cEb().jPe.cOY();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.cEb().d(dVar);
                a.cEb().jPe.cOX();
                if (!a.cEb().jPe.cOZ()) {
                    a.cEb().jPe.cOY();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.cEb().jPe.cOX();
            finish();
            return true;
        } else if (i == 82) {
            a.cEb().jPe.cOX();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cEa() {
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
