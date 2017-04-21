package com.baidu.tieba.screenlocknotify;

import android.app.ActivityManager;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView biG;
    private Window fhW;
    public q fhZ;
    public s fia;
    private ScreenLockLoadMoreModel fie;
    private com.baidu.tieba.screenlocknotify.a.a fif;
    private Drawable fhX = null;
    public DynamicHeightListView fhY = null;
    private int fib = 0;
    private TextView fic = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fig = new a(this);
    View.OnClickListener fih = new b(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new c(this);
    private View.OnClickListener fii = new d(this);
    private com.baidu.adp.framework.listener.a fij = new e(this, CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.fhW = getWindow();
        this.fhW.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fhW.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(w.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(w.e.transparent, true);
        if (com.baidu.adp.lib.util.k.hE()) {
            this.fhX = bbV();
            if (this.fhX != null) {
                this.fhW.setBackgroundDrawable(this.fhX);
            }
        }
        this.fib = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds935) - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds80);
        this.fie = new ScreenLockLoadMoreModel(this);
        registerListener(this.fij);
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
        this.biG = (ImageView) findViewById(w.h.head_close);
        this.biG.setOnClickListener(new f(this));
        this.fhY = (DynamicHeightListView) findViewById(w.h.screenlock_chat_list_content);
        this.fhZ = new q(getPageContext().getPageActivity());
        this.fhY.setAdapter((ListAdapter) this.fhZ);
        this.fhY.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fig, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        i.bbW().fit = false;
        this.fhY.setMaxHeight(this.fib);
        this.fhY.setTranscriptMode(0);
        this.fhY.setOnScrollListener(new g(this));
    }

    private void bbU() {
        this.fic = new TextView(getActivity());
        this.fic.setGravity(17);
        this.fic.setText(w.l.click_load_more);
        this.fic.setHeight((int) getResources().getDimension(w.f.ds80));
        this.fic.setBackgroundResource(w.g.screen_notify_item_background);
        this.fic.setTextColor(getResources().getColorStateList(w.e.screen_notify_load_more_text_color));
        this.fic.setTextSize(0, getResources().getDimension(w.f.fontsize32));
        this.fic.setOnClickListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bah())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ko() {
        s item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fie.bcf();
            if (this.fhZ != null && this.fhZ.getCount() > 0 && (item = this.fhZ.getItem(0)) != null) {
                TiebaStatic.log(new as("c11738").g(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        i.bbW().fiq = 1;
        i.bbW().fio = 0;
        List<s> bbY = i.bbW().bbY();
        s bbZ = i.bbW().bbZ();
        i.bbW().release();
        if ((bbY == null || bbY.isEmpty()) && bbZ == null && this.fhZ.getCount() == 0 && this.fhY.getHeaderViewsCount() == 0) {
            i.bbW().fin.bcb();
            finish();
            return;
        }
        cB(bbY);
        if (bbZ != null) {
            a(bbZ);
        }
        if (this.fif != null) {
            this.fif.kN(this.fhZ.getCount() == 0);
        }
    }

    private void cB(List<s> list) {
        if (list != null && list.size() > 0 && this.fhZ != null) {
            this.fhZ.cC(list);
            if (this.fhZ.isHasMore() && this.fic == null) {
                bbU();
                this.fhY.addFooterView(this.fic);
            }
        }
    }

    private void a(s sVar) {
        if (this.fif == null) {
            this.fif = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.fif.b(this.fih, this.fii);
            this.fif.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fhY.addHeaderView(this.fif);
        }
        this.fif.f(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        i.bbW().fiq = 0;
        i.bbW().fio = 0;
        if (this.fif != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fif.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fig);
        i.bbW().release();
        i.bbW().fiq = 0;
        this.fhX = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void b(s sVar) {
        if (sVar != null) {
            TiebaStatic.log(new as("c11703").g(PbActivityConfig.KEY_MSG_ID, sVar.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, sVar.taskId).aa("url", sVar.url).aa("app_version", TbConfig.getVersion()));
            if (!com.baidu.adp.lib.util.i.hk()) {
                showToast(getResources().getString(w.l.neterror));
            } else if (!TextUtils.isEmpty(sVar.url)) {
                bb.wn().c(getPageContext(), new String[]{String.valueOf(sVar.url) + "&is_from_push=true"});
                TiebaStatic.log(new as("c10316").aa("obj_type", sVar.stat).s("obj_locate", 2));
                i.bbW().d(sVar);
                finish();
            } else if (sVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(sVar.groupId), sVar.groupName, 0L, "from_lock")));
                i.bbW().d(sVar);
                i.bbW().fin.bcb();
                if (!i.bbW().fin.bcd()) {
                    i.bbW().fin.bcc();
                }
                i.bbW().fio = 0;
                finish();
            } else if (sVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fia.groupId, 0L), sVar.groupName, sVar.fiH, 0, sVar.eIb ? 1 : 0)));
                i.bbW().d(sVar);
                i.bbW().fio = 0;
                i.bbW().fin.bcb();
                if (!i.bbW().fin.bcd()) {
                    i.bbW().fin.bcc();
                }
                finish();
            } else if (sVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fia.groupId, 0L), sVar.groupName, sVar.fiH, 0, 4)));
                i.bbW().d(sVar);
                i.bbW().fio = 0;
                i.bbW().fin.bcb();
                if (!i.bbW().fin.bcd()) {
                    i.bbW().fin.bcc();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                i.bbW().d(sVar);
                i.bbW().fin.bcb();
                if (!i.bbW().fin.bcd()) {
                    i.bbW().fin.bcc();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            i.bbW().fin.bcb();
            finish();
            return true;
        } else if (i == 82) {
            i.bbW().fin.bcb();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bbV() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String bah() {
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
