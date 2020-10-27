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
/* loaded from: classes21.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView jAO;
    private Window mwZ;
    public c mxb;
    public d mxc;
    private ScreenLockLoadMoreModel mxf;
    private ScreenLockHeaderView mxg;
    private Drawable mjp = null;
    public DynamicHeightListView mxa = null;
    private int mxd = 0;
    private TextView mxe = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver mxh = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.dzI().mxn.dLE();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener mxi = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.mxg != null && !StringUtils.isNull(ScreenLockActivity.this.mxg.getInputMsg()) && (data = ScreenLockActivity.this.mxg.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.PUSH_CCLICK).w("msg_id", data.msgId / 100).w("task_id", data.taskId).w(Constants.EXTRA_SERVICE, data.serviceId).dR("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).dR(TiebaInitialize.Params.OBJ_TO, data.url).dR("app_version", TbConfig.getVersion()).aj("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.mxg.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.bts().CC(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.mxg.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.mxC);
                    com.baidu.tbadk.coreExtra.messageCenter.b.bts().CC(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new aj("lockscreen_reply", true).start();
                a.dzI().mxn.dLE();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.mxc = ScreenLockActivity.this.mxb.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.mxc);
        }
    };
    private View.OnClickListener mxj = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.mxg != null) {
                ScreenLockActivity.this.mxc = ScreenLockActivity.this.mxg.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.mxc);
            }
        }
    };
    private com.baidu.adp.framework.listener.a mxk = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.mxe != null) {
                            ScreenLockActivity.this.mxe.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.mxe.setEnabled(true);
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
                        ArrayList<d> dzO = data.dzO();
                        if (ScreenLockActivity.this.mxb != null) {
                            ScreenLockActivity.this.mxb.fv(dzO);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.mxb.setHasMore(false);
                            if (ScreenLockActivity.this.mxe != null) {
                                ScreenLockActivity.this.mxa.removeFooterView(ScreenLockActivity.this.mxe);
                                ScreenLockActivity.this.mxe = null;
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
        this.mwZ = getWindow();
        this.mwZ.addFlags(524288);
        this.mwZ.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.mjp = com.baidu.tieba.v.b.dLI();
            if (this.mjp != null) {
                this.mwZ.setBackgroundDrawable(this.mjp);
            }
        }
        this.mxd = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.mxf = new ScreenLockLoadMoreModel(this);
        registerListener(this.mxk);
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
        this.jAO = (ImageView) findViewById(R.id.head_close);
        this.jAO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.mxb.getCount() > 0 && (item = ScreenLockActivity.this.mxb.getItem(0)) != null) {
                    TiebaStatic.log(new aq("c11704").w("msg_id", item.msgId / 100).w("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.dzI().mxn.dLE();
            }
        });
        this.mxa = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.mxb = new c(getPageContext().getPageActivity());
        this.mxa.setAdapter((ListAdapter) this.mxb);
        this.mxa.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.mxh, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.dzI().mxt = false;
        this.mxa.setMaxHeight(this.mxd);
        this.mxa.setTranscriptMode(0);
        this.mxa.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.mxe != null && ScreenLockActivity.this.mxe.getParent() != null) {
                    if (ScreenLockActivity.this.mxa.getHeight() != ScreenLockActivity.this.mxd) {
                        ScreenLockActivity.this.mxe.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.mxe.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.mxe.isEnabled()) {
                            ScreenLockActivity.this.mxe.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.mxe.setEnabled(false);
                        }
                        ScreenLockActivity.this.cyN();
                    }
                }
            }
        });
    }

    private void dzG() {
        this.mxe = new TextView(getActivity());
        this.mxe.setGravity(17);
        this.mxe.setText(R.string.click_load_more);
        this.mxe.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.mxe.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.mxe.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.mxe.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.mxe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.mxe.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.mxe.setEnabled(false);
                ScreenLockActivity.this.cyN();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(dzH())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyN() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.mxf.dzP();
            if (this.mxb != null && this.mxb.getCount() > 0 && (item = this.mxb.getItem(0)) != null) {
                TiebaStatic.log(new aq("c11738").w("msg_id", item.msgId / 100).w("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.dzI().mxq = 1;
        a.dzI().mxo = 0;
        List<d> dzK = a.dzI().dzK();
        d dzL = a.dzI().dzL();
        a.dzI().release();
        if ((dzK == null || dzK.isEmpty()) && dzL == null && this.mxb.getCount() == 0 && this.mxa.getHeaderViewsCount() == 0) {
            a.dzI().mxn.dLE();
            finish();
            return;
        }
        fu(dzK);
        if (dzL != null) {
            a(dzL);
        }
        if (this.mxg != null) {
            this.mxg.wF(this.mxb.getCount() == 0);
        }
    }

    private void fu(List<d> list) {
        if (list != null && list.size() > 0 && this.mxb != null) {
            this.mxb.fv(list);
            if (this.mxb.isHasMore() && this.mxe == null) {
                dzG();
                this.mxa.addFooterView(this.mxe);
            }
        }
    }

    private void a(d dVar) {
        if (this.mxg == null) {
            this.mxg = new ScreenLockHeaderView(getActivity());
            this.mxg.setUIClickListener(this.mxi, this.mxj);
            this.mxg.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.mxa.addHeaderView(this.mxg);
        }
        this.mxg.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.dzI().mxq = 0;
        a.dzI().mxo = 0;
        if (this.mxg != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.mxg.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mxh);
        a.dzI().release();
        a.dzI().mxq = 0;
        this.mjp = null;
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
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.PUSH_CCLICK).w("msg_id", dVar.msgId / 100).w("task_id", dVar.taskId).w(Constants.EXTRA_SERVICE, dVar.serviceId).dR("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).dR(TiebaInitialize.Params.OBJ_TO, dVar.url).dR("app_version", TbConfig.getVersion()).aj("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                be.boR().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY + "=true"});
                TiebaStatic.log(new aq("c10316").dR("obj_type", dVar.stat).aj("obj_locate", 2));
                a.dzI().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.dzI().d(dVar);
                a.dzI().mxn.dLE();
                if (!a.dzI().mxn.dLG()) {
                    a.dzI().mxn.dLF();
                }
                a.dzI().mxo = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.mxc.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.mxC, 0, dVar.lWN ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.dzI().d(dVar);
                a.dzI().mxo = 0;
                a.dzI().mxn.dLE();
                if (!a.dzI().mxn.dLG()) {
                    a.dzI().mxn.dLF();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.mxc.groupId, 0L), dVar.groupName, dVar.mxC, 0, 4)));
                a.dzI().d(dVar);
                a.dzI().mxo = 0;
                a.dzI().mxn.dLE();
                if (!a.dzI().mxn.dLG()) {
                    a.dzI().mxn.dLF();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.dzI().d(dVar);
                a.dzI().mxn.dLE();
                if (!a.dzI().mxn.dLG()) {
                    a.dzI().mxn.dLF();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.dzI().mxn.dLE();
            finish();
            return true;
        } else if (i == 82) {
            a.dzI().mxn.dLE();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String dzH() {
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
