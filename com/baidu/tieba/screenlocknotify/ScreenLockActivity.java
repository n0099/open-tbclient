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
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
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
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private EditText cfX;
    private Window dGW;
    private TextView dGX;
    private RelativeLayout dGY;
    private RelativeLayout dGZ;
    private TextView dHa;
    private TextView dHb;
    private TextView dHc;
    private TextView dHd;
    private ImageView dHe;
    private int dHf;
    private int dHg;
    public n dHj;
    public p dHk;
    private InputMethodManager mInputManager;
    private Drawable dHh = null;
    public DynamicHeightListView dHi = null;
    private BroadcastReceiver dHl = new a(this);
    private AdapterView.OnItemClickListener Is = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.dGW = getWindow();
        this.dGW.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.dGW.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(t.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(t.d.transparent, true);
        if (com.baidu.adp.lib.util.k.jt()) {
            this.dHh = aFU();
            if (this.dHh != null) {
                this.dGW.setBackgroundDrawable(this.dHh);
            }
        }
        qD();
        this.dHf = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds360);
        this.dHg = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds484);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    public void qD() {
        this.dGY = (RelativeLayout) findViewById(t.g.screenlock_input_layout);
        this.dGX = (TextView) findViewById(t.g.screenlock_send_button);
        this.cfX = (EditText) findViewById(t.g.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dGZ = (RelativeLayout) findViewById(t.g.one_chat_head_layout);
        this.dHa = (TextView) findViewById(t.g.friend_name_head);
        this.dHb = (TextView) findViewById(t.g.last_msg_time_head);
        this.dHd = (TextView) findViewById(t.g.unread_msg_count);
        this.dHc = (TextView) findViewById(t.g.look_more_textview);
        this.dHc.setOnClickListener(new c(this));
        this.dGX.setOnClickListener(new d(this));
        this.dHe = (ImageView) findViewById(t.g.head_close);
        this.dHe.setOnClickListener(new e(this));
        this.dHi = (DynamicHeightListView) findViewById(t.g.screenlock_chat_list_content);
        this.dHj = new n(getPageContext().getPageActivity());
        this.dHi.setAdapter((ListAdapter) this.dHj);
        this.dHi.setOnItemClickListener(this.Is);
        registerReceiver(this.dHl, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.aFV().dHw = false;
    }

    public String aFT() {
        if (this.cfX != null) {
            return com.baidu.adp.lib.util.j.a(this.cfX.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(aEl())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> aFX = f.aFV().aFX();
        if (aFX == null || aFX.isEmpty()) {
            f.aFV().dHq.aGd();
            finish();
            return;
        }
        if (f.aFV().aFY().size() == 1) {
            p pVar = f.aFV().aFY().get(0);
            if (f.aFV().aGc()) {
                this.dGY.setVisibility(8);
                this.dHd.setVisibility(8);
                this.dGZ.setVisibility(8);
                this.dHi.setMaxHeight(0);
            } else {
                this.dGY.setVisibility(0);
                this.dHd.setText(nC(pVar.dHO));
                this.dHd.setVisibility(0);
                this.dGZ.setVisibility(0);
                this.dHa.setText(pVar.groupName);
                this.dHb.setText(bO(pVar.dHQ));
                this.dHi.setMaxHeight(this.dHf);
            }
            this.dHc.setVisibility(8);
            this.dHj.hq(false);
        } else {
            this.dGY.setVisibility(8);
            this.dGZ.setVisibility(8);
            this.dHd.setVisibility(8);
            if (f.aFV().aGc()) {
                if (f.aFV().aFY().size() < 3) {
                    this.dHc.setVisibility(8);
                    linkedList = aFX;
                } else {
                    List<p> aFX2 = f.aFV().aFX();
                    LinkedList linkedList2 = new LinkedList(aFX2.subList(0, 2));
                    linkedList2.add(aFX2.get(aFX2.size() - 1));
                    this.dHc.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (f.aFV().aFY().size() <= 3) {
                this.dHc.setVisibility(8);
                linkedList = aFX;
            } else {
                this.dHc.setVisibility(0);
                linkedList = aFX;
            }
            this.dHj.hq(true);
            this.dHi.setMaxHeight(this.dHg);
            aFX = linkedList;
        }
        this.dHj.hr(f.aFV().aGc());
        this.dHj.setData(aFX);
        this.dHj.notifyDataSetChanged();
        f.aFV().dHt = 1;
        f.aFV().dHr = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.aFV().dHt = 0;
        f.aFV().dHr = 0;
        HidenSoftKeyPad(this.mInputManager, this.cfX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.dHl);
        f.aFV().dHt = 0;
        this.dHh = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void a(p pVar) {
        if (pVar != null) {
            if (!TextUtils.isEmpty(pVar.url)) {
                be.wt().c(getPageContext(), new String[]{pVar.url});
                TiebaStatic.log(new au("c10316").aa("obj_type", pVar.stat).r("obj_locate", 2));
                f.aFV().c(pVar);
                finish();
            } else if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                f.aFV().c(pVar);
                f.aFV().dHq.aGd();
                if (!f.aFV().dHq.aGf()) {
                    f.aFV().dHq.aGe();
                }
                f.aFV().dHr = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.dHk.groupId, 0L), pVar.groupName, pVar.dHP, 0, pVar.dHS ? 1 : 0)));
                f.aFV().c(pVar);
                f.aFV().dHr = 0;
                f.aFV().dHq.aGd();
                if (!f.aFV().dHq.aGf()) {
                    f.aFV().dHq.aGe();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.dHk.groupId, 0L), pVar.groupName, pVar.dHP, 0, 4)));
                f.aFV().c(pVar);
                f.aFV().dHr = 0;
                f.aFV().dHq.aGd();
                if (!f.aFV().dHq.aGf()) {
                    f.aFV().dHq.aGe();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.aFV().c(pVar);
                f.aFV().dHq.aGd();
                if (!f.aFV().dHq.aGf()) {
                    f.aFV().dHq.aGe();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.aFV().dHq.aGd();
            finish();
            return true;
        } else if (i == 82) {
            f.aFV().dHq.aGd();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String bO(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String nC(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable aFU() {
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

    public String aEl() {
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
