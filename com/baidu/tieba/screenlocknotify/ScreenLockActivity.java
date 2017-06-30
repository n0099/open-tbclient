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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.w;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes2.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView bnN;
    private Window fvZ;
    public q fwc;
    public s fwd;
    private ScreenLockLoadMoreModel fwg;
    private com.baidu.tieba.screenlocknotify.a.a fwh;
    private Drawable fwa = null;
    public DynamicHeightListView fwb = null;
    private int fwe = 0;
    private TextView fwf = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fwi = new a(this);
    View.OnClickListener fwj = new b(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new c(this);
    private View.OnClickListener fwk = new d(this);
    private com.baidu.adp.framework.listener.a fwl = new e(this, CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.fvZ = getWindow();
        this.fvZ.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fvZ.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(w.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(w.e.transparent, true);
        if (com.baidu.adp.lib.util.k.hD()) {
            this.fwa = bfd();
            if (this.fwa != null) {
                this.fvZ.setBackgroundDrawable(this.fwa);
            }
        }
        this.fwe = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds935) - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds80);
        this.fwg = new ScreenLockLoadMoreModel(this);
        registerListener(this.fwl);
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
        this.bnN = (ImageView) findViewById(w.h.head_close);
        this.bnN.setOnClickListener(new f(this));
        this.fwb = (DynamicHeightListView) findViewById(w.h.screenlock_chat_list_content);
        this.fwc = new q(getPageContext().getPageActivity());
        this.fwb.setAdapter((ListAdapter) this.fwc);
        this.fwb.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fwi, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        i.bfe().fwu = false;
        this.fwb.setMaxHeight(this.fwe);
        this.fwb.setTranscriptMode(0);
        this.fwb.setOnScrollListener(new g(this));
    }

    private void bfc() {
        this.fwf = new TextView(getActivity());
        this.fwf.setGravity(17);
        this.fwf.setText(w.l.click_load_more);
        this.fwf.setHeight((int) getResources().getDimension(w.f.ds80));
        this.fwf.setBackgroundResource(w.g.screen_notify_item_background);
        this.fwf.setTextColor(getResources().getColorStateList(w.e.screen_notify_load_more_text_color));
        this.fwf.setTextSize(0, getResources().getDimension(w.f.fontsize32));
        this.fwf.setOnClickListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bdk())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nu() {
        s item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fwg.bfn();
            if (this.fwc != null && this.fwc.getCount() > 0 && (item = this.fwc.getItem(0)) != null) {
                TiebaStatic.log(new au("c11738").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        i.bfe().fwr = 1;
        i.bfe().fwp = 0;
        List<s> bfg = i.bfe().bfg();
        s bfh = i.bfe().bfh();
        i.bfe().release();
        if ((bfg == null || bfg.isEmpty()) && bfh == null && this.fwc.getCount() == 0 && this.fwb.getHeaderViewsCount() == 0) {
            i.bfe().fwo.bfj();
            finish();
            return;
        }
        cJ(bfg);
        if (bfh != null) {
            a(bfh);
        }
        if (this.fwh != null) {
            this.fwh.lm(this.fwc.getCount() == 0);
        }
    }

    private void cJ(List<s> list) {
        if (list != null && list.size() > 0 && this.fwc != null) {
            this.fwc.cK(list);
            if (this.fwc.isHasMore() && this.fwf == null) {
                bfc();
                this.fwb.addFooterView(this.fwf);
            }
        }
    }

    private void a(s sVar) {
        if (this.fwh == null) {
            this.fwh = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.fwh.b(this.fwj, this.fwk);
            this.fwh.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fwb.addHeaderView(this.fwh);
        }
        this.fwh.f(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        i.bfe().fwr = 0;
        i.bfe().fwp = 0;
        if (this.fwh != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fwh.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fwi);
        i.bfe().release();
        i.bfe().fwr = 0;
        this.fwa = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void b(s sVar) {
        if (sVar != null) {
            TiebaStatic.log(new au("c11703").f(PbActivityConfig.KEY_MSG_ID, sVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, sVar.taskId).Z("obj_to", sVar.url).Z(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!com.baidu.adp.lib.util.i.hj()) {
                showToast(getResources().getString(w.l.neterror));
            } else if (!TextUtils.isEmpty(sVar.url)) {
                be.vP().c(getPageContext(), new String[]{String.valueOf(sVar.url) + "&is_from_push=true"});
                TiebaStatic.log(new au("c10316").Z("obj_type", sVar.stat).r("obj_locate", 2));
                i.bfe().d(sVar);
                finish();
            } else if (sVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(sVar.groupId), sVar.groupName, 0L, "from_lock")));
                i.bfe().d(sVar);
                i.bfe().fwo.bfj();
                if (!i.bfe().fwo.bfl()) {
                    i.bfe().fwo.bfk();
                }
                i.bfe().fwp = 0;
                finish();
            } else if (sVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fwd.groupId, 0L), sVar.groupName, sVar.fwI, 0, sVar.eVT ? 1 : 0)));
                i.bfe().d(sVar);
                i.bfe().fwp = 0;
                i.bfe().fwo.bfj();
                if (!i.bfe().fwo.bfl()) {
                    i.bfe().fwo.bfk();
                }
                finish();
            } else if (sVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fwd.groupId, 0L), sVar.groupName, sVar.fwI, 0, 4)));
                i.bfe().d(sVar);
                i.bfe().fwp = 0;
                i.bfe().fwo.bfj();
                if (!i.bfe().fwo.bfl()) {
                    i.bfe().fwo.bfk();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                i.bfe().d(sVar);
                i.bfe().fwo.bfj();
                if (!i.bfe().fwo.bfl()) {
                    i.bfe().fwo.bfk();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            i.bfe().fwo.bfj();
            finish();
            return true;
        } else if (i == 82) {
            i.bfe().fwo.bfj();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bfd() {
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

    public String bdk() {
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
