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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes20.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView iZp;
    private Window lUR;
    public c lUT;
    public d lUU;
    private ScreenLockLoadMoreModel lUX;
    private ScreenLockHeaderView lUY;
    private Drawable lHA = null;
    public DynamicHeightListView lUS = null;
    private int lUV = 0;
    private TextView lUW = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver lUZ = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.dsP().lVf.dEK();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener lVa = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.lUY != null && !StringUtils.isNull(ScreenLockActivity.this.lUY.getInputMsg()) && (data = ScreenLockActivity.this.lUY.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.PUSH_CCLICK).u("msg_id", data.msgId / 100).u("task_id", data.taskId).u(Constants.EXTRA_SERVICE, data.serviceId).dF("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).dF(TiebaInitialize.Params.OBJ_TO, data.url).dF("app_version", TbConfig.getVersion()).ai("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.lUY.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.boP().Bx(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.lUY.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.lVu);
                    com.baidu.tbadk.coreExtra.messageCenter.b.boP().Bx(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new aj("lockscreen_reply", true).start();
                a.dsP().lVf.dEK();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.lUU = ScreenLockActivity.this.lUT.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.lUU);
        }
    };
    private View.OnClickListener lVb = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.lUY != null) {
                ScreenLockActivity.this.lUU = ScreenLockActivity.this.lUY.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.lUU);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lVc = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.lUW != null) {
                            ScreenLockActivity.this.lUW.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.lUW.setEnabled(true);
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
                        ArrayList<d> dsV = data.dsV();
                        if (ScreenLockActivity.this.lUT != null) {
                            ScreenLockActivity.this.lUT.fj(dsV);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.lUT.setHasMore(false);
                            if (ScreenLockActivity.this.lUW != null) {
                                ScreenLockActivity.this.lUS.removeFooterView(ScreenLockActivity.this.lUW);
                                ScreenLockActivity.this.lUW = null;
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
        this.lUR = getWindow();
        this.lUR.addFlags(524288);
        this.lUR.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.lHA = com.baidu.tieba.v.b.dEO();
            if (this.lHA != null) {
                this.lUR.setBackgroundDrawable(this.lHA);
            }
        }
        this.lUV = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.lUX = new ScreenLockLoadMoreModel(this);
        registerListener(this.lVc);
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
        this.iZp = (ImageView) findViewById(R.id.head_close);
        this.iZp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.lUT.getCount() > 0 && (item = ScreenLockActivity.this.lUT.getItem(0)) != null) {
                    TiebaStatic.log(new aq("c11704").u("msg_id", item.msgId / 100).u("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.dsP().lVf.dEK();
            }
        });
        this.lUS = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.lUT = new c(getPageContext().getPageActivity());
        this.lUS.setAdapter((ListAdapter) this.lUT);
        this.lUS.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.lUZ, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.dsP().lVl = false;
        this.lUS.setMaxHeight(this.lUV);
        this.lUS.setTranscriptMode(0);
        this.lUS.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.lUW != null && ScreenLockActivity.this.lUW.getParent() != null) {
                    if (ScreenLockActivity.this.lUS.getHeight() != ScreenLockActivity.this.lUV) {
                        ScreenLockActivity.this.lUW.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.lUW.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.lUW.isEnabled()) {
                            ScreenLockActivity.this.lUW.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.lUW.setEnabled(false);
                        }
                        ScreenLockActivity.this.csj();
                    }
                }
            }
        });
    }

    private void dsN() {
        this.lUW = new TextView(getActivity());
        this.lUW.setGravity(17);
        this.lUW.setText(R.string.click_load_more);
        this.lUW.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.lUW.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.lUW.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.lUW.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.lUW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.lUW.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.lUW.setEnabled(false);
                ScreenLockActivity.this.csj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(dsO())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csj() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.lUX.dsW();
            if (this.lUT != null && this.lUT.getCount() > 0 && (item = this.lUT.getItem(0)) != null) {
                TiebaStatic.log(new aq("c11738").u("msg_id", item.msgId / 100).u("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.dsP().lVi = 1;
        a.dsP().lVg = 0;
        List<d> dsR = a.dsP().dsR();
        d dsS = a.dsP().dsS();
        a.dsP().release();
        if ((dsR == null || dsR.isEmpty()) && dsS == null && this.lUT.getCount() == 0 && this.lUS.getHeaderViewsCount() == 0) {
            a.dsP().lVf.dEK();
            finish();
            return;
        }
        fi(dsR);
        if (dsS != null) {
            a(dsS);
        }
        if (this.lUY != null) {
            this.lUY.vH(this.lUT.getCount() == 0);
        }
    }

    private void fi(List<d> list) {
        if (list != null && list.size() > 0 && this.lUT != null) {
            this.lUT.fj(list);
            if (this.lUT.isHasMore() && this.lUW == null) {
                dsN();
                this.lUS.addFooterView(this.lUW);
            }
        }
    }

    private void a(d dVar) {
        if (this.lUY == null) {
            this.lUY = new ScreenLockHeaderView(getActivity());
            this.lUY.setUIClickListener(this.lVa, this.lVb);
            this.lUY.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.lUS.addHeaderView(this.lUY);
        }
        this.lUY.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.dsP().lVi = 0;
        a.dsP().lVg = 0;
        if (this.lUY != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.lUY.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.lUZ);
        a.dsP().release();
        a.dsP().lVi = 0;
        this.lHA = null;
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
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.PUSH_CCLICK).u("msg_id", dVar.msgId / 100).u("task_id", dVar.taskId).u(Constants.EXTRA_SERVICE, dVar.serviceId).dF("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).dF(TiebaInitialize.Params.OBJ_TO, dVar.url).dF("app_version", TbConfig.getVersion()).ai("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                be.bkp().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY + "=true"});
                TiebaStatic.log(new aq("c10316").dF("obj_type", dVar.stat).ai("obj_locate", 2));
                a.dsP().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.dsP().d(dVar);
                a.dsP().lVf.dEK();
                if (!a.dsP().lVf.dEM()) {
                    a.dsP().lVf.dEL();
                }
                a.dsP().lVg = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.lUU.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.lVu, 0, dVar.lvf ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.dsP().d(dVar);
                a.dsP().lVg = 0;
                a.dsP().lVf.dEK();
                if (!a.dsP().lVf.dEM()) {
                    a.dsP().lVf.dEL();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.lUU.groupId, 0L), dVar.groupName, dVar.lVu, 0, 4)));
                a.dsP().d(dVar);
                a.dsP().lVg = 0;
                a.dsP().lVf.dEK();
                if (!a.dsP().lVf.dEM()) {
                    a.dsP().lVf.dEL();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.dsP().d(dVar);
                a.dsP().lVf.dEK();
                if (!a.dsP().lVf.dEM()) {
                    a.dsP().lVf.dEL();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.dsP().lVf.dEK();
            finish();
            return true;
        } else if (i == 82) {
            a.dsP().lVf.dEK();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String dsO() {
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
