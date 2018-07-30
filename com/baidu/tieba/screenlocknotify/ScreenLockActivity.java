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
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
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
    private ImageView dZM;
    private ScreenLockLoadMoreModel gwC;
    private ScreenLockHeaderView gwD;
    private Window gww;
    public c gwy;
    public d gwz;
    private Drawable gkT = null;
    public DynamicHeightListView gwx = null;
    private int gwA = 0;
    private TextView gwB = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gwE = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.boJ().gwK.bzZ();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gwF = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.gwD != null && !StringUtils.isNull(ScreenLockActivity.this.gwD.getInputMsg()) && (data = ScreenLockActivity.this.gwD.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an("c11703").f("msg_id", data.msgId / 100).f("task_id", data.taskId).af("obj_to", data.url).af("app_version", TbConfig.getVersion()).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gwD.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().fG(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gwD.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.nameShow, data.gxa);
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().fG(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ah("lockscreen_reply", true).start();
                a.boJ().gwK.bzZ();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gwz = ScreenLockActivity.this.gwy.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gwz);
        }
    };
    private View.OnClickListener gwG = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gwD != null) {
                ScreenLockActivity.this.gwz = ScreenLockActivity.this.gwD.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gwz);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gwH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gwB != null) {
                            ScreenLockActivity.this.gwB.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.gwB.setEnabled(true);
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
                        ArrayList<d> boP = data.boP();
                        if (ScreenLockActivity.this.gwy != null) {
                            ScreenLockActivity.this.gwy.dm(boP);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gwy.setHasMore(false);
                            if (ScreenLockActivity.this.gwB != null) {
                                ScreenLockActivity.this.gwx.removeFooterView(ScreenLockActivity.this.gwB);
                                ScreenLockActivity.this.gwB = null;
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
        this.gww = getWindow();
        this.gww.addFlags(524288);
        this.gww.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0140d.transparent, true);
        if (l.jY()) {
            this.gkT = com.baidu.tieba.t.a.bAc();
            if (this.gkT != null) {
                this.gww.setBackgroundDrawable(this.gkT);
            }
        }
        this.gwA = l.f(getPageContext().getPageActivity(), d.e.ds935) - l.f(getPageContext().getPageActivity(), d.e.ds80);
        this.gwC = new ScreenLockLoadMoreModel(this);
        registerListener(this.gwH);
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
        this.dZM = (ImageView) findViewById(d.g.head_close);
        this.dZM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.gwy.getCount() > 0 && (item = ScreenLockActivity.this.gwy.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.boJ().gwK.bzZ();
            }
        });
        this.gwx = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.gwy = new c(getPageContext().getPageActivity());
        this.gwx.setAdapter((ListAdapter) this.gwy);
        this.gwx.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gwE, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.boJ().gwQ = false;
        this.gwx.setMaxHeight(this.gwA);
        this.gwx.setTranscriptMode(0);
        this.gwx.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gwB != null && ScreenLockActivity.this.gwB.getParent() != null) {
                    if (ScreenLockActivity.this.gwx.getHeight() != ScreenLockActivity.this.gwA) {
                        ScreenLockActivity.this.gwB.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.gwB.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gwB.isEnabled()) {
                            ScreenLockActivity.this.gwB.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.gwB.setEnabled(false);
                        }
                        ScreenLockActivity.this.awt();
                    }
                }
            }
        });
    }

    private void boH() {
        this.gwB = new TextView(getActivity());
        this.gwB.setGravity(17);
        this.gwB.setText(d.j.click_load_more);
        this.gwB.setHeight((int) getResources().getDimension(d.e.ds80));
        this.gwB.setBackgroundResource(d.f.screen_notify_item_background);
        this.gwB.setTextColor(getResources().getColorStateList(d.C0140d.screen_notify_load_more_text_color));
        this.gwB.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.gwB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gwB.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.gwB.setEnabled(false);
                ScreenLockActivity.this.awt();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(boI())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awt() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gwC.boQ();
            if (this.gwy != null && this.gwy.getCount() > 0 && (item = this.gwy.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.boJ().gwN = 1;
        a.boJ().gwL = 0;
        List<d> boL = a.boJ().boL();
        d boM = a.boJ().boM();
        a.boJ().release();
        if ((boL == null || boL.isEmpty()) && boM == null && this.gwy.getCount() == 0 && this.gwx.getHeaderViewsCount() == 0) {
            a.boJ().gwK.bzZ();
            finish();
            return;
        }
        dl(boL);
        if (boM != null) {
            a(boM);
        }
        if (this.gwD != null) {
            this.gwD.lM(this.gwy.getCount() == 0);
        }
    }

    private void dl(List<d> list) {
        if (list != null && list.size() > 0 && this.gwy != null) {
            this.gwy.dm(list);
            if (this.gwy.isHasMore() && this.gwB == null) {
                boH();
                this.gwx.addFooterView(this.gwB);
            }
        }
    }

    private void a(d dVar) {
        if (this.gwD == null) {
            this.gwD = new ScreenLockHeaderView(getActivity());
            this.gwD.setUIClickListener(this.gwF, this.gwG);
            this.gwD.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gwx.addHeaderView(this.gwD);
        }
        this.gwD.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.boJ().gwN = 0;
        a.boJ().gwL = 0;
        if (this.gwD != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gwD.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gwE);
        a.boJ().release();
        a.boJ().gwN = 0;
        this.gkT = null;
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
            TiebaStatic.log(new an("c11703").f("msg_id", dVar.msgId / 100).f("task_id", dVar.taskId).af("obj_to", dVar.url).af("app_version", TbConfig.getVersion()).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
            if (!j.jE()) {
                showToast(getResources().getString(d.j.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ay.zK().c(getPageContext(), new String[]{dVar.url + "&is_from_push=true"});
                TiebaStatic.log(new an("c10316").af("obj_type", dVar.stat).r("obj_locate", 2));
                a.boJ().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.boJ().d(dVar);
                a.boJ().gwK.bzZ();
                if (!a.boJ().gwK.bAb()) {
                    a.boJ().gwK.bAa();
                }
                a.boJ().gwL = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gwz.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.gxa, 0, dVar.gat ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.boJ().d(dVar);
                a.boJ().gwL = 0;
                a.boJ().gwK.bzZ();
                if (!a.boJ().gwK.bAb()) {
                    a.boJ().gwK.bAa();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gwz.groupId, 0L), dVar.groupName, dVar.gxa, 0, 4)));
                a.boJ().d(dVar);
                a.boJ().gwL = 0;
                a.boJ().gwK.bzZ();
                if (!a.boJ().gwK.bAb()) {
                    a.boJ().gwK.bAa();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.boJ().d(dVar);
                a.boJ().gwK.bzZ();
                if (!a.boJ().gwK.bAb()) {
                    a.boJ().gwK.bAa();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.boJ().gwK.bzZ();
            finish();
            return true;
        } else if (i == 82) {
            a.boJ().gwK.bzZ();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String boI() {
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
