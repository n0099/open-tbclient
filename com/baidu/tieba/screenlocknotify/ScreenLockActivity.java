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
    private ImageView drL;
    private Window gba;
    public c gbd;
    public e gbe;
    private ScreenLockLoadMoreModel gbh;
    private com.baidu.tieba.screenlocknotify.a.a gbi;
    private Drawable gbb = null;
    public DynamicHeightListView gbc = null;
    private int gbf = 0;
    private TextView gbg = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gbj = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bmu().gbp.bmz();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gbk = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.gbi != null && !StringUtils.isNull(ScreenLockActivity.this.gbi.getInputMsg()) && (data = ScreenLockActivity.this.gbi.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f("msg_id", data.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId).ac("obj_to", data.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gbi.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.yM().eP(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gbi.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.gbJ);
                    com.baidu.tbadk.coreExtra.messageCenter.a.yM().eP(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bmu().gbp.bmz();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gbe = ScreenLockActivity.this.gbd.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gbe);
        }
    };
    private View.OnClickListener gbl = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gbi != null) {
                ScreenLockActivity.this.gbe = ScreenLockActivity.this.gbi.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gbe);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gbm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gbg != null) {
                            ScreenLockActivity.this.gbg.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.gbg.setEnabled(true);
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
                        ArrayList<e> bmC = data.bmC();
                        if (ScreenLockActivity.this.gbd != null) {
                            ScreenLockActivity.this.gbd.dn(bmC);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gbd.setHasMore(false);
                            if (ScreenLockActivity.this.gbg != null) {
                                ScreenLockActivity.this.gbc.removeFooterView(ScreenLockActivity.this.gbg);
                                ScreenLockActivity.this.gbg = null;
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
        this.gba = getWindow();
        this.gba.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.gba.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0082d.transparent, true);
        if (l.hB()) {
            this.gbb = bms();
            if (this.gbb != null) {
                this.gba.setBackgroundDrawable(this.gbb);
            }
        }
        this.gbf = l.f(getPageContext().getPageActivity(), d.e.ds935) - l.f(getPageContext().getPageActivity(), d.e.ds80);
        this.gbh = new ScreenLockLoadMoreModel(this);
        registerListener(this.gbm);
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
        this.drL = (ImageView) findViewById(d.g.head_close);
        this.drL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.gbd.getCount() > 0 && (item = ScreenLockActivity.this.gbd.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f("msg_id", item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bmu().gbp.bmz();
            }
        });
        this.gbc = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.gbd = new c(getPageContext().getPageActivity());
        this.gbc.setAdapter((ListAdapter) this.gbd);
        this.gbc.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gbj, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bmu().gbv = false;
        this.gbc.setMaxHeight(this.gbf);
        this.gbc.setTranscriptMode(0);
        this.gbc.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gbg != null && ScreenLockActivity.this.gbg.getParent() != null) {
                    if (ScreenLockActivity.this.gbc.getHeight() != ScreenLockActivity.this.gbf) {
                        ScreenLockActivity.this.gbg.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.gbg.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gbg.isEnabled()) {
                            ScreenLockActivity.this.gbg.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.gbg.setEnabled(false);
                        }
                        ScreenLockActivity.this.PF();
                    }
                }
            }
        });
    }

    private void bmr() {
        this.gbg = new TextView(getActivity());
        this.gbg.setGravity(17);
        this.gbg.setText(d.j.click_load_more);
        this.gbg.setHeight((int) getResources().getDimension(d.e.ds80));
        this.gbg.setBackgroundResource(d.f.screen_notify_item_background);
        this.gbg.setTextColor(getResources().getColorStateList(d.C0082d.screen_notify_load_more_text_color));
        this.gbg.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.gbg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gbg.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.gbg.setEnabled(false);
                ScreenLockActivity.this.PF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bmt())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gbh.bmD();
            if (this.gbd != null && this.gbd.getCount() > 0 && (item = this.gbd.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f("msg_id", item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bmu().gbs = 1;
        a.bmu().gbq = 0;
        List<e> bmw = a.bmu().bmw();
        e bmx = a.bmu().bmx();
        a.bmu().release();
        if ((bmw == null || bmw.isEmpty()) && bmx == null && this.gbd.getCount() == 0 && this.gbc.getHeaderViewsCount() == 0) {
            a.bmu().gbp.bmz();
            finish();
            return;
        }
        dm(bmw);
        if (bmx != null) {
            a(bmx);
        }
        if (this.gbi != null) {
            this.gbi.ml(this.gbd.getCount() == 0);
        }
    }

    private void dm(List<e> list) {
        if (list != null && list.size() > 0 && this.gbd != null) {
            this.gbd.dn(list);
            if (this.gbd.isHasMore() && this.gbg == null) {
                bmr();
                this.gbc.addFooterView(this.gbg);
            }
        }
    }

    private void a(e eVar) {
        if (this.gbi == null) {
            this.gbi = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.gbi.a(this.gbk, this.gbl);
            this.gbi.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gbc.addHeaderView(this.gbi);
        }
        this.gbi.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bmu().gbs = 0;
        a.bmu().gbq = 0;
        if (this.gbi != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gbi.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gbj);
        a.bmu().release();
        a.bmu().gbs = 0;
        this.gbb = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new ak("c11703").f("msg_id", eVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId).ac("obj_to", eVar.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!j.hh()) {
                showToast(getResources().getString(d.j.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                av.vL().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new ak("c10316").ac("obj_type", eVar.stat).r("obj_locate", 2));
                a.bmu().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.bmu().d(eVar);
                a.bmu().gbp.bmz();
                if (!a.bmu().gbp.bmB()) {
                    a.bmu().gbp.bmA();
                }
                a.bmu().gbq = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gbe.groupId, 0L), eVar.groupName, eVar.gbJ, 0, eVar.fxH ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(eVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.bmu().d(eVar);
                a.bmu().gbq = 0;
                a.bmu().gbp.bmz();
                if (!a.bmu().gbp.bmB()) {
                    a.bmu().gbp.bmA();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gbe.groupId, 0L), eVar.groupName, eVar.gbJ, 0, 4)));
                a.bmu().d(eVar);
                a.bmu().gbq = 0;
                a.bmu().gbp.bmz();
                if (!a.bmu().gbp.bmB()) {
                    a.bmu().gbp.bmA();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.bmu().d(eVar);
                a.bmu().gbp.bmz();
                if (!a.bmu().gbp.bmB()) {
                    a.bmu().gbp.bmA();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bmu().gbp.bmz();
            finish();
            return true;
        } else if (i == 82) {
            a.bmu().gbp.bmz();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bms() {
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

    public String bmt() {
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
