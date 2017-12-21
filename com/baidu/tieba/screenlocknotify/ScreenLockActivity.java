package com.baidu.tieba.screenlocknotify;

import android.app.ActivityManager;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView dsU;
    private Window gdL;
    public c gdO;
    public e gdP;
    private ScreenLockLoadMoreModel gdS;
    private com.baidu.tieba.screenlocknotify.a.a gdT;
    private Drawable gdM = null;
    public DynamicHeightListView gdN = null;
    private int gdQ = 0;
    private TextView gdR = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gdU = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bna().gea.bnf();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gdV = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.gdT != null && !StringUtils.isNull(ScreenLockActivity.this.gdT.getInputMsg()) && (data = ScreenLockActivity.this.gdT.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f("msg_id", data.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId).ac("obj_to", data.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gdT.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().eP(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gdT.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.gev);
                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().eP(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bna().gea.bnf();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gdP = ScreenLockActivity.this.gdO.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gdP);
        }
    };
    private View.OnClickListener gdW = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gdT != null) {
                ScreenLockActivity.this.gdP = ScreenLockActivity.this.gdT.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gdP);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gdX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gdR != null) {
                            ScreenLockActivity.this.gdR.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.gdR.setEnabled(true);
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
                        ArrayList<e> bni = data.bni();
                        if (ScreenLockActivity.this.gdO != null) {
                            ScreenLockActivity.this.gdO.dm(bni);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gdO.setHasMore(false);
                            if (ScreenLockActivity.this.gdR != null) {
                                ScreenLockActivity.this.gdN.removeFooterView(ScreenLockActivity.this.gdR);
                                ScreenLockActivity.this.gdR = null;
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
        this.gdL = getWindow();
        this.gdL.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.gdL.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0095d.transparent, true);
        if (l.hB()) {
            this.gdM = bmY();
            if (this.gdM != null) {
                this.gdL.setBackgroundDrawable(this.gdM);
            }
        }
        this.gdQ = l.f(getPageContext().getPageActivity(), d.e.ds935) - l.f(getPageContext().getPageActivity(), d.e.ds80);
        this.gdS = new ScreenLockLoadMoreModel(this);
        registerListener(this.gdX);
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
        this.dsU = (ImageView) findViewById(d.g.head_close);
        this.dsU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.gdO.getCount() > 0 && (item = ScreenLockActivity.this.gdO.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f("msg_id", item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bna().gea.bnf();
            }
        });
        this.gdN = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.gdO = new c(getPageContext().getPageActivity());
        this.gdN.setAdapter((ListAdapter) this.gdO);
        this.gdN.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gdU, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bna().geg = false;
        this.gdN.setMaxHeight(this.gdQ);
        this.gdN.setTranscriptMode(0);
        this.gdN.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gdR != null && ScreenLockActivity.this.gdR.getParent() != null) {
                    if (ScreenLockActivity.this.gdN.getHeight() != ScreenLockActivity.this.gdQ) {
                        ScreenLockActivity.this.gdR.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.gdR.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gdR.isEnabled()) {
                            ScreenLockActivity.this.gdR.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.gdR.setEnabled(false);
                        }
                        ScreenLockActivity.this.PF();
                    }
                }
            }
        });
    }

    private void bmX() {
        this.gdR = new TextView(getActivity());
        this.gdR.setGravity(17);
        this.gdR.setText(d.j.click_load_more);
        this.gdR.setHeight((int) getResources().getDimension(d.e.ds80));
        this.gdR.setBackgroundResource(d.f.screen_notify_item_background);
        this.gdR.setTextColor(getResources().getColorStateList(d.C0095d.screen_notify_load_more_text_color));
        this.gdR.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.gdR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gdR.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.gdR.setEnabled(false);
                ScreenLockActivity.this.PF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bmZ())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gdS.bnj();
            if (this.gdO != null && this.gdO.getCount() > 0 && (item = this.gdO.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f("msg_id", item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bna().ged = 1;
        a.bna().geb = 0;
        List<e> bnc = a.bna().bnc();
        e bnd = a.bna().bnd();
        a.bna().release();
        if ((bnc == null || bnc.isEmpty()) && bnd == null && this.gdO.getCount() == 0 && this.gdN.getHeaderViewsCount() == 0) {
            a.bna().gea.bnf();
            finish();
            return;
        }
        dl(bnc);
        if (bnd != null) {
            a(bnd);
        }
        if (this.gdT != null) {
            this.gdT.mn(this.gdO.getCount() == 0);
        }
    }

    private void dl(List<e> list) {
        if (list != null && list.size() > 0 && this.gdO != null) {
            this.gdO.dm(list);
            if (this.gdO.isHasMore() && this.gdR == null) {
                bmX();
                this.gdN.addFooterView(this.gdR);
            }
        }
    }

    private void a(e eVar) {
        if (this.gdT == null) {
            this.gdT = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.gdT.a(this.gdV, this.gdW);
            this.gdT.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gdN.addHeaderView(this.gdT);
        }
        this.gdT.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bna().ged = 0;
        a.bna().geb = 0;
        if (this.gdT != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gdT.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gdU);
        a.bna().release();
        a.bna().ged = 0;
        this.gdM = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new ak("c11703").f("msg_id", eVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId).ac("obj_to", eVar.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!j.hh()) {
                showToast(getResources().getString(d.j.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                av.vI().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new ak("c10316").ac("obj_type", eVar.stat).r("obj_locate", 2));
                a.bna().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.bna().d(eVar);
                a.bna().gea.bnf();
                if (!a.bna().gea.bnh()) {
                    a.bna().gea.bng();
                }
                a.bna().geb = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gdP.groupId, 0L), eVar.groupName, eVar.gev, 0, eVar.fyD ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(eVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.bna().d(eVar);
                a.bna().geb = 0;
                a.bna().gea.bnf();
                if (!a.bna().gea.bnh()) {
                    a.bna().gea.bng();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gdP.groupId, 0L), eVar.groupName, eVar.gev, 0, 4)));
                a.bna().d(eVar);
                a.bna().geb = 0;
                a.bna().gea.bnf();
                if (!a.bna().gea.bnh()) {
                    a.bna().gea.bng();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.bna().d(eVar);
                a.bna().gea.bnf();
                if (!a.bna().gea.bnh()) {
                    a.bna().gea.bng();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bna().gea.bnf();
            finish();
            return true;
        } else if (i == 82) {
            a.bna().gea.bnf();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bmY() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(l.ac(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(l.ae(getPageContext().getPageActivity()), bitmap.getHeight());
                try {
                    return new BitmapDrawable(Bitmap.createBitmap(bitmap, 0, 0, min, min2));
                } catch (Throwable th) {
                    try {
                        return new BitmapDrawable(Bitmap.createBitmap(bitmap, 0, 0, min, min2));
                    } catch (Throwable th2) {
                        BdLog.e(th2.getMessage());
                        return null;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String bmZ() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) TbadkApplication.getInst().getSystemService("activity")).getRunningTasks(5);
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
