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
import com.baidu.tieba.d;
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
    private ImageView fNE;
    private Window ioZ;
    public c ipb;
    public d ipc;
    private ScreenLockLoadMoreModel ipf;
    private ScreenLockHeaderView ipg;
    private Drawable idm = null;
    public DynamicHeightListView ipa = null;
    private int ipd = 0;
    private TextView ipe = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver iph = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bYe().ipn.ciE();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener ipi = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.ipg != null && !StringUtils.isNull(ScreenLockActivity.this.ipg.getInputMsg()) && (data = ScreenLockActivity.this.ipg.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new am("c11703").k("msg_id", data.msgId / 100).k("task_id", data.taskId).bJ("obj_to", data.url).bJ(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.ipg.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahx().nL(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.ipg.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L), data.userName, data.nameShow, data.ipD);
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahx().nL(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bYe().ipn.ciE();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.ipc = ScreenLockActivity.this.ipb.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.ipc);
        }
    };
    private View.OnClickListener ipj = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.ipg != null) {
                ScreenLockActivity.this.ipc = ScreenLockActivity.this.ipg.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.ipc);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ipk = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.ipe != null) {
                            ScreenLockActivity.this.ipe.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.ipe.setEnabled(true);
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
                        ArrayList<d> bYk = data.bYk();
                        if (ScreenLockActivity.this.ipb != null) {
                            ScreenLockActivity.this.ipb.dQ(bYk);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.ipb.setHasMore(false);
                            if (ScreenLockActivity.this.ipe != null) {
                                ScreenLockActivity.this.ipa.removeFooterView(ScreenLockActivity.this.ipe);
                                ScreenLockActivity.this.ipe = null;
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
        this.ioZ = getWindow();
        this.ioZ.addFlags(524288);
        this.ioZ.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0277d.transparent, true);
        if (l.lr()) {
            this.idm = com.baidu.tieba.t.b.ciH();
            if (this.idm != null) {
                this.ioZ.setBackgroundDrawable(this.idm);
            }
        }
        this.ipd = l.h(getPageContext().getPageActivity(), d.e.ds935) - l.h(getPageContext().getPageActivity(), d.e.ds80);
        this.ipf = new ScreenLockLoadMoreModel(this);
        registerListener(this.ipk);
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
        this.fNE = (ImageView) findViewById(d.g.head_close);
        this.fNE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.ipb.getCount() > 0 && (item = ScreenLockActivity.this.ipb.getItem(0)) != null) {
                    TiebaStatic.log(new am("c11704").k("msg_id", item.msgId / 100).k("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bYe().ipn.ciE();
            }
        });
        this.ipa = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.ipb = new c(getPageContext().getPageActivity());
        this.ipa.setAdapter((ListAdapter) this.ipb);
        this.ipa.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.iph, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bYe().ipt = false;
        this.ipa.setMaxHeight(this.ipd);
        this.ipa.setTranscriptMode(0);
        this.ipa.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.ipe != null && ScreenLockActivity.this.ipe.getParent() != null) {
                    if (ScreenLockActivity.this.ipa.getHeight() != ScreenLockActivity.this.ipd) {
                        ScreenLockActivity.this.ipe.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.ipe.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.ipe.isEnabled()) {
                            ScreenLockActivity.this.ipe.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.ipe.setEnabled(false);
                        }
                        ScreenLockActivity.this.beX();
                    }
                }
            }
        });
    }

    private void bYc() {
        this.ipe = new TextView(getActivity());
        this.ipe.setGravity(17);
        this.ipe.setText(d.j.click_load_more);
        this.ipe.setHeight((int) getResources().getDimension(d.e.ds80));
        this.ipe.setBackgroundResource(d.f.screen_notify_item_background);
        this.ipe.setTextColor(getResources().getColorStateList(d.C0277d.screen_notify_load_more_text_color));
        this.ipe.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.ipe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.ipe.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.ipe.setEnabled(false);
                ScreenLockActivity.this.beX();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bYd())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beX() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.ipf.bYl();
            if (this.ipb != null && this.ipb.getCount() > 0 && (item = this.ipb.getItem(0)) != null) {
                TiebaStatic.log(new am("c11738").k("msg_id", item.msgId / 100).k("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bYe().ipq = 1;
        a.bYe().ipo = 0;
        List<d> bYg = a.bYe().bYg();
        d bYh = a.bYe().bYh();
        a.bYe().release();
        if ((bYg == null || bYg.isEmpty()) && bYh == null && this.ipb.getCount() == 0 && this.ipa.getHeaderViewsCount() == 0) {
            a.bYe().ipn.ciE();
            finish();
            return;
        }
        dP(bYg);
        if (bYh != null) {
            a(bYh);
        }
        if (this.ipg != null) {
            this.ipg.pu(this.ipb.getCount() == 0);
        }
    }

    private void dP(List<d> list) {
        if (list != null && list.size() > 0 && this.ipb != null) {
            this.ipb.dQ(list);
            if (this.ipb.isHasMore() && this.ipe == null) {
                bYc();
                this.ipa.addFooterView(this.ipe);
            }
        }
    }

    private void a(d dVar) {
        if (this.ipg == null) {
            this.ipg = new ScreenLockHeaderView(getActivity());
            this.ipg.setUIClickListener(this.ipi, this.ipj);
            this.ipg.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.ipa.addHeaderView(this.ipg);
        }
        this.ipg.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bYe().ipq = 0;
        a.bYe().ipo = 0;
        if (this.ipg != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.ipg.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.iph);
        a.bYe().release();
        a.bYe().ipq = 0;
        this.idm = null;
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
            TiebaStatic.log(new am("c11703").k("msg_id", dVar.msgId / 100).k("task_id", dVar.taskId).bJ("obj_to", dVar.url).bJ(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
            if (!j.kY()) {
                showToast(getResources().getString(d.j.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ba.adA().c(getPageContext(), new String[]{dVar.url + "&is_from_push=true"});
                TiebaStatic.log(new am("c10316").bJ("obj_type", dVar.stat).T("obj_locate", 2));
                a.bYe().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.bYe().d(dVar);
                a.bYe().ipn.ciE();
                if (!a.bYe().ipn.ciG()) {
                    a.bYe().ipn.ciF();
                }
                a.bYe().ipo = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.ipc.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.ipD, 0, dVar.hRj ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bYe().d(dVar);
                a.bYe().ipo = 0;
                a.bYe().ipn.ciE();
                if (!a.bYe().ipn.ciG()) {
                    a.bYe().ipn.ciF();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.ipc.groupId, 0L), dVar.groupName, dVar.ipD, 0, 4)));
                a.bYe().d(dVar);
                a.bYe().ipo = 0;
                a.bYe().ipn.ciE();
                if (!a.bYe().ipn.ciG()) {
                    a.bYe().ipn.ciF();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bYe().d(dVar);
                a.bYe().ipn.ciE();
                if (!a.bYe().ipn.ciG()) {
                    a.bYe().ipn.ciF();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bYe().ipn.ciE();
            finish();
            return true;
        } else if (i == 82) {
            a.bYe().ipn.ciE();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String bYd() {
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
