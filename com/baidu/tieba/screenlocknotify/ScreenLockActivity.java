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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
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
    private ImageView eUD;
    private com.baidu.tieba.screenlocknotify.a.a fQA;
    private Window fQs;
    public c fQv;
    public e fQw;
    private ScreenLockLoadMoreModel fQz;
    private Drawable fQt = null;
    public DynamicHeightListView fQu = null;
    private int fQx = 0;
    private TextView fQy = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fQB = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bkj().fQH.bko();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener fQC = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.fQA != null && !StringUtils.isNull(ScreenLockActivity.this.fQA.getInputMsg()) && (data = ScreenLockActivity.this.fQA.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f(PbActivityConfig.KEY_MSG_ID, data.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId).ac("obj_to", data.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.fQA.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.yC().eK(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.fQA.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.fRb);
                    com.baidu.tbadk.coreExtra.messageCenter.a.yC().eK(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bkj().fQH.bko();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.fQw = ScreenLockActivity.this.fQv.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.fQw);
        }
    };
    private View.OnClickListener fQD = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.fQA != null) {
                ScreenLockActivity.this.fQw = ScreenLockActivity.this.fQA.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.fQw);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fQE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.fQy != null) {
                            ScreenLockActivity.this.fQy.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.fQy.setEnabled(true);
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
                        ArrayList<e> bkr = data.bkr();
                        if (ScreenLockActivity.this.fQv != null) {
                            ScreenLockActivity.this.fQv.da(bkr);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.fQv.setHasMore(false);
                            if (ScreenLockActivity.this.fQy != null) {
                                ScreenLockActivity.this.fQu.removeFooterView(ScreenLockActivity.this.fQy);
                                ScreenLockActivity.this.fQy = null;
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
        this.fQs = getWindow();
        this.fQs.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fQs.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0080d.transparent, true);
        if (l.hB()) {
            this.fQt = bkh();
            if (this.fQt != null) {
                this.fQs.setBackgroundDrawable(this.fQt);
            }
        }
        this.fQx = l.f(getPageContext().getPageActivity(), d.e.ds935) - l.f(getPageContext().getPageActivity(), d.e.ds80);
        this.fQz = new ScreenLockLoadMoreModel(this);
        registerListener(this.fQE);
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
        this.eUD = (ImageView) findViewById(d.g.head_close);
        this.eUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.fQv.getCount() > 0 && (item = ScreenLockActivity.this.fQv.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bkj().fQH.bko();
            }
        });
        this.fQu = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.fQv = new c(getPageContext().getPageActivity());
        this.fQu.setAdapter((ListAdapter) this.fQv);
        this.fQu.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fQB, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bkj().fQN = false;
        this.fQu.setMaxHeight(this.fQx);
        this.fQu.setTranscriptMode(0);
        this.fQu.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.fQy != null && ScreenLockActivity.this.fQy.getParent() != null) {
                    if (ScreenLockActivity.this.fQu.getHeight() != ScreenLockActivity.this.fQx) {
                        ScreenLockActivity.this.fQy.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.fQy.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.fQy.isEnabled()) {
                            ScreenLockActivity.this.fQy.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.fQy.setEnabled(false);
                        }
                        ScreenLockActivity.this.Oh();
                    }
                }
            }
        });
    }

    private void bkg() {
        this.fQy = new TextView(getActivity());
        this.fQy.setGravity(17);
        this.fQy.setText(d.j.click_load_more);
        this.fQy.setHeight((int) getResources().getDimension(d.e.ds80));
        this.fQy.setBackgroundResource(d.f.screen_notify_item_background);
        this.fQy.setTextColor(getResources().getColorStateList(d.C0080d.screen_notify_load_more_text_color));
        this.fQy.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.fQy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.fQy.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.fQy.setEnabled(false);
                ScreenLockActivity.this.Oh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bki())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fQz.bks();
            if (this.fQv != null && this.fQv.getCount() > 0 && (item = this.fQv.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bkj().fQK = 1;
        a.bkj().fQI = 0;
        List<e> bkl = a.bkj().bkl();
        e bkm = a.bkj().bkm();
        a.bkj().release();
        if ((bkl == null || bkl.isEmpty()) && bkm == null && this.fQv.getCount() == 0 && this.fQu.getHeaderViewsCount() == 0) {
            a.bkj().fQH.bko();
            finish();
            return;
        }
        cZ(bkl);
        if (bkm != null) {
            a(bkm);
        }
        if (this.fQA != null) {
            this.fQA.lE(this.fQv.getCount() == 0);
        }
    }

    private void cZ(List<e> list) {
        if (list != null && list.size() > 0 && this.fQv != null) {
            this.fQv.da(list);
            if (this.fQv.isHasMore() && this.fQy == null) {
                bkg();
                this.fQu.addFooterView(this.fQy);
            }
        }
    }

    private void a(e eVar) {
        if (this.fQA == null) {
            this.fQA = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.fQA.a(this.fQC, this.fQD);
            this.fQA.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fQu.addHeaderView(this.fQA);
        }
        this.fQA.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bkj().fQK = 0;
        a.bkj().fQI = 0;
        if (this.fQA != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fQA.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fQB);
        a.bkj().release();
        a.bkj().fQK = 0;
        this.fQt = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new ak("c11703").f(PbActivityConfig.KEY_MSG_ID, eVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId).ac("obj_to", eVar.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!j.hh()) {
                showToast(getResources().getString(d.j.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                av.vI().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new ak("c10316").ac("obj_type", eVar.stat).r("obj_locate", 2));
                a.bkj().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.bkj().d(eVar);
                a.bkj().fQH.bko();
                if (!a.bkj().fQH.bkq()) {
                    a.bkj().fQH.bkp();
                }
                a.bkj().fQI = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fQw.groupId, 0L), eVar.groupName, eVar.fRb, 0, eVar.fow ? 1 : 0)));
                a.bkj().d(eVar);
                a.bkj().fQI = 0;
                a.bkj().fQH.bko();
                if (!a.bkj().fQH.bkq()) {
                    a.bkj().fQH.bkp();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fQw.groupId, 0L), eVar.groupName, eVar.fRb, 0, 4)));
                a.bkj().d(eVar);
                a.bkj().fQI = 0;
                a.bkj().fQH.bko();
                if (!a.bkj().fQH.bkq()) {
                    a.bkj().fQH.bkp();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.bkj().d(eVar);
                a.bkj().fQH.bko();
                if (!a.bkj().fQH.bkq()) {
                    a.bkj().fQH.bkp();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bkj().fQH.bko();
            finish();
            return true;
        } else if (i == 82) {
            a.bkj().fQH.bko();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bkh() {
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

    public String bki() {
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
