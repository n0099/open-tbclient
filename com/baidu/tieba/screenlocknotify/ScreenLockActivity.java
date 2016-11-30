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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private com.baidu.tieba.screenlocknotify.a.a fmA;
    private Window fmr;
    private ImageView fms;
    public q fmv;
    public s fmw;
    private com.baidu.tieba.screenlocknotify.loadmore.b fmz;
    private Drawable fmt = null;
    public DynamicHeightListView fmu = null;
    private int fmx = 0;
    private TextView fmy = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fmB = new a(this);
    View.OnClickListener fmC = new b(this);
    private AdapterView.OnItemClickListener BG = new c(this);
    private View.OnClickListener fmD = new d(this);
    private com.baidu.adp.framework.listener.a fmE = new e(this, CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.fmr = getWindow();
        this.fmr.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fmr.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(r.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(r.d.transparent, true);
        if (com.baidu.adp.lib.util.k.gG()) {
            this.fmt = beW();
            if (this.fmt != null) {
                this.fmr.setBackgroundDrawable(this.fmt);
            }
        }
        this.fmx = com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds935) - com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds80);
        this.fmz = new com.baidu.tieba.screenlocknotify.loadmore.b(this);
        registerListener(this.fmE);
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
        this.fms = (ImageView) findViewById(r.g.head_close);
        this.fms.setOnClickListener(new f(this));
        this.fmu = (DynamicHeightListView) findViewById(r.g.screenlock_chat_list_content);
        this.fmv = new q(getPageContext().getPageActivity());
        this.fmu.setAdapter((ListAdapter) this.fmv);
        this.fmu.setOnItemClickListener(this.BG);
        registerReceiver(this.fmB, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        i.beX().fmO = false;
        this.fmu.setMaxHeight(this.fmx);
        this.fmu.setTranscriptMode(0);
        this.fmu.setOnScrollListener(new g(this));
    }

    private void aIs() {
        this.fmy = new TextView(this);
        this.fmy.setGravity(17);
        this.fmy.setText(r.j.screen_notify_load_more);
        this.fmy.setHeight((int) getResources().getDimension(r.e.ds80));
        this.fmy.setBackgroundResource(r.f.screen_notify_item_background);
        this.fmy.setTextColor(getResources().getColorStateList(r.d.screen_notify_load_more_text_color));
        this.fmy.setTextSize(0, getResources().getDimension(r.e.fontsize32));
        this.fmy.setOnClickListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bdX())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JA() {
        s item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fmz.bfg();
            if (this.fmv != null && this.fmv.getCount() > 0 && (item = this.fmv.getItem(0)) != null) {
                TiebaStatic.log(new av("c11738").g(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        i.beX().fmL = 1;
        i.beX().fmJ = 0;
        List<s> beZ = i.beX().beZ();
        s bfa = i.beX().bfa();
        i.beX().release();
        if ((beZ == null || beZ.isEmpty()) && bfa == null && this.fmv.getCount() == 0 && this.fmu.getHeaderViewsCount() == 0) {
            i.beX().fmI.bfc();
            finish();
            return;
        }
        cZ(beZ);
        if (bfa != null) {
            a(bfa);
        }
        if (this.fmA != null) {
            this.fmA.kI(this.fmv.getCount() == 0);
        }
    }

    private void cZ(List<s> list) {
        if (list != null && list.size() > 0 && this.fmv != null) {
            this.fmv.da(list);
            if (this.fmv.isHasMore() && this.fmy == null) {
                aIs();
                this.fmu.addFooterView(this.fmy);
            }
        }
    }

    private void a(s sVar) {
        if (this.fmA == null) {
            this.fmA = new com.baidu.tieba.screenlocknotify.a.a(this);
            this.fmA.b(this.fmC, this.fmD);
            this.fmA.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fmu.addHeaderView(this.fmA);
        }
        this.fmA.f(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        i.beX().fmL = 0;
        i.beX().fmJ = 0;
        if (this.fmA != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fmA.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fmB);
        i.beX().release();
        i.beX().fmL = 0;
        this.fmt = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void b(s sVar) {
        if (sVar != null) {
            TiebaStatic.log(new av("c11703").g(PbActivityConfig.KEY_MSG_ID, sVar.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, sVar.taskId));
            if (!com.baidu.adp.lib.util.i.gm()) {
                showToast(getResources().getString(r.j.neterror));
            } else if (!TextUtils.isEmpty(sVar.url)) {
                bf.vP().c(getPageContext(), new String[]{sVar.url});
                TiebaStatic.log(new av("c10316").ab("obj_type", sVar.stat).s("obj_locate", 2));
                i.beX().d(sVar);
                finish();
            } else if (sVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(sVar.groupId), sVar.groupName, 0L, "from_lock")));
                i.beX().d(sVar);
                i.beX().fmI.bfc();
                if (!i.beX().fmI.bfe()) {
                    i.beX().fmI.bfd();
                }
                i.beX().fmJ = 0;
                finish();
            } else if (sVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.fmw.groupId, 0L), sVar.groupName, sVar.fnb, 0, sVar.eQU ? 1 : 0)));
                i.beX().d(sVar);
                i.beX().fmJ = 0;
                i.beX().fmI.bfc();
                if (!i.beX().fmI.bfe()) {
                    i.beX().fmI.bfd();
                }
                finish();
            } else if (sVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.fmw.groupId, 0L), sVar.groupName, sVar.fnb, 0, 4)));
                i.beX().d(sVar);
                i.beX().fmJ = 0;
                i.beX().fmI.bfc();
                if (!i.beX().fmI.bfe()) {
                    i.beX().fmI.bfd();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                i.beX().d(sVar);
                i.beX().fmI.bfc();
                if (!i.beX().fmI.bfe()) {
                    i.beX().fmI.bfd();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            i.beX().fmI.bfc();
            finish();
            return true;
        } else if (i == 82) {
            i.beX().fmI.bfc();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable beW() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String bdX() {
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
