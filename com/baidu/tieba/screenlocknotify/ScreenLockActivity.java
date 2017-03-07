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
    private ImageView bgJ;
    private Window fed;
    public q feh;
    public s fei;
    private ScreenLockLoadMoreModel fel;
    private com.baidu.tieba.screenlocknotify.a.a fem;
    private Drawable fef = null;
    public DynamicHeightListView feg = null;
    private int fej = 0;
    private TextView fek = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fen = new a(this);
    View.OnClickListener feo = new b(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new c(this);
    private View.OnClickListener fep = new d(this);
    private com.baidu.adp.framework.listener.a feq = new e(this, CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.fed = getWindow();
        this.fed.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fed.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(w.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(w.e.transparent, true);
        if (com.baidu.adp.lib.util.k.hy()) {
            this.fef = bal();
            if (this.fef != null) {
                this.fed.setBackgroundDrawable(this.fef);
            }
        }
        this.fej = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds935) - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds80);
        this.fel = new ScreenLockLoadMoreModel(this);
        registerListener(this.feq);
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
        this.bgJ = (ImageView) findViewById(w.h.head_close);
        this.bgJ.setOnClickListener(new f(this));
        this.feg = (DynamicHeightListView) findViewById(w.h.screenlock_chat_list_content);
        this.feh = new q(getPageContext().getPageActivity());
        this.feg.setAdapter((ListAdapter) this.feh);
        this.feg.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fen, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        i.bam().feA = false;
        this.feg.setMaxHeight(this.fej);
        this.feg.setTranscriptMode(0);
        this.feg.setOnScrollListener(new g(this));
    }

    private void bak() {
        this.fek = new TextView(getActivity());
        this.fek.setGravity(17);
        this.fek.setText(w.l.click_load_more);
        this.fek.setHeight((int) getResources().getDimension(w.f.ds80));
        this.fek.setBackgroundResource(w.g.screen_notify_item_background);
        this.fek.setTextColor(getResources().getColorStateList(w.e.screen_notify_load_more_text_color));
        this.fek.setTextSize(0, getResources().getDimension(w.f.fontsize32));
        this.fek.setOnClickListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(aYX())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JO() {
        s item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fel.bav();
            if (this.feh != null && this.feh.getCount() > 0 && (item = this.feh.getItem(0)) != null) {
                TiebaStatic.log(new as("c11738").g(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        i.bam().fex = 1;
        i.bam().fev = 0;
        List<s> bao = i.bam().bao();
        s bap = i.bam().bap();
        i.bam().release();
        if ((bao == null || bao.isEmpty()) && bap == null && this.feh.getCount() == 0 && this.feg.getHeaderViewsCount() == 0) {
            i.bam().feu.bar();
            finish();
            return;
        }
        cB(bao);
        if (bap != null) {
            a(bap);
        }
        if (this.fem != null) {
            this.fem.kB(this.feh.getCount() == 0);
        }
    }

    private void cB(List<s> list) {
        if (list != null && list.size() > 0 && this.feh != null) {
            this.feh.cC(list);
            if (this.feh.isHasMore() && this.fek == null) {
                bak();
                this.feg.addFooterView(this.fek);
            }
        }
    }

    private void a(s sVar) {
        if (this.fem == null) {
            this.fem = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.fem.b(this.feo, this.fep);
            this.fem.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.feg.addHeaderView(this.fem);
        }
        this.fem.f(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        i.bam().fex = 0;
        i.bam().fev = 0;
        if (this.fem != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fem.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fen);
        i.bam().release();
        i.bam().fex = 0;
        this.fef = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void b(s sVar) {
        if (sVar != null) {
            TiebaStatic.log(new as("c11703").g(PbActivityConfig.KEY_MSG_ID, sVar.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, sVar.taskId).Z("url", sVar.url).Z("app_version", TbConfig.getVersion()));
            if (!com.baidu.adp.lib.util.i.he()) {
                showToast(getResources().getString(w.l.neterror));
            } else if (!TextUtils.isEmpty(sVar.url)) {
                bb.vQ().c(getPageContext(), new String[]{sVar.url});
                TiebaStatic.log(new as("c10316").Z("obj_type", sVar.stat).s("obj_locate", 2));
                i.bam().d(sVar);
                finish();
            } else if (sVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(sVar.groupId), sVar.groupName, 0L, "from_lock")));
                i.bam().d(sVar);
                i.bam().feu.bar();
                if (!i.bam().feu.bat()) {
                    i.bam().feu.bas();
                }
                i.bam().fev = 0;
                finish();
            } else if (sVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fei.groupId, 0L), sVar.groupName, sVar.feN, 0, sVar.eHQ ? 1 : 0)));
                i.bam().d(sVar);
                i.bam().fev = 0;
                i.bam().feu.bar();
                if (!i.bam().feu.bat()) {
                    i.bam().feu.bas();
                }
                finish();
            } else if (sVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fei.groupId, 0L), sVar.groupName, sVar.feN, 0, 4)));
                i.bam().d(sVar);
                i.bam().fev = 0;
                i.bam().feu.bar();
                if (!i.bam().feu.bat()) {
                    i.bam().feu.bas();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                i.bam().d(sVar);
                i.bam().feu.bar();
                if (!i.bam().feu.bat()) {
                    i.bam().feu.bas();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            i.bam().feu.bar();
            finish();
            return true;
        } else if (i == 82) {
            i.bam().feu.bar();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bal() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(com.baidu.adp.lib.util.k.ah(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String aYX() {
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
