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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private EditText bHW;
    private Window cJX;
    private TextView cJY;
    private RelativeLayout cJZ;
    private RelativeLayout cKa;
    private TextView cKb;
    private TextView cKc;
    private TextView cKd;
    private TextView cKe;
    private ImageView cKf;
    private int cKg;
    private int cKh;
    public n cKk;
    public p cKl;
    private InputMethodManager mInputManager;
    private Drawable cKi = null;
    public DynamicHeightListView cKj = null;
    private BroadcastReceiver cKm = new a(this);
    private AdapterView.OnItemClickListener Hx = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.cJX = getWindow();
        this.cJX.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.cJX.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(i.g.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (com.baidu.adp.lib.util.k.jh()) {
            this.cKi = aqF();
            if (this.cKi != null) {
                this.cJX.setBackgroundDrawable(this.cKi);
            }
        }
        initUI();
        this.cKg = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds360);
        this.cKh = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds484);
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
        this.cJZ = (RelativeLayout) findViewById(i.f.screenlock_input_layout);
        this.cJY = (TextView) findViewById(i.f.screenlock_send_button);
        this.bHW = (EditText) findViewById(i.f.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.cKa = (RelativeLayout) findViewById(i.f.one_chat_head_layout);
        this.cKb = (TextView) findViewById(i.f.friend_name_head);
        this.cKc = (TextView) findViewById(i.f.last_msg_time_head);
        this.cKe = (TextView) findViewById(i.f.unread_msg_count);
        this.cKd = (TextView) findViewById(i.f.look_more_textview);
        this.cKd.setOnClickListener(new c(this));
        this.cJY.setOnClickListener(new d(this));
        this.cKf = (ImageView) findViewById(i.f.head_close);
        this.cKf.setOnClickListener(new e(this));
        this.cKj = (DynamicHeightListView) findViewById(i.f.screenlock_chat_list_content);
        this.cKk = new n(getPageContext().getPageActivity());
        this.cKj.setAdapter((ListAdapter) this.cKk);
        this.cKj.setOnItemClickListener(this.Hx);
        registerReceiver(this.cKm, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.aqH().cKx = false;
    }

    public String aqE() {
        if (this.bHW != null) {
            return com.baidu.adp.lib.util.j.a(this.bHW.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(aqG())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> aqJ = f.aqH().aqJ();
        if (aqJ == null || aqJ.isEmpty()) {
            f.aqH().cKr.aqP();
            finish();
            return;
        }
        if (f.aqH().aqK().size() == 1) {
            p pVar = f.aqH().aqK().get(0);
            if (f.aqH().aqO()) {
                this.cJZ.setVisibility(8);
                this.cKe.setVisibility(8);
                this.cKa.setVisibility(8);
                this.cKj.setMaxHeight(0);
            } else {
                this.cJZ.setVisibility(0);
                this.cKe.setText(kt(pVar.cKQ));
                this.cKe.setVisibility(0);
                this.cKa.setVisibility(0);
                this.cKb.setText(pVar.groupName);
                this.cKc.setText(bh(pVar.cIR));
                this.cKj.setMaxHeight(this.cKg);
            }
            this.cKd.setVisibility(8);
            this.cKk.fP(false);
        } else {
            this.cJZ.setVisibility(8);
            this.cKa.setVisibility(8);
            this.cKe.setVisibility(8);
            if (f.aqH().aqO()) {
                if (f.aqH().aqK().size() < 3) {
                    this.cKd.setVisibility(8);
                    linkedList = aqJ;
                } else {
                    List<p> aqJ2 = f.aqH().aqJ();
                    LinkedList linkedList2 = new LinkedList(aqJ2.subList(0, 2));
                    linkedList2.add(aqJ2.get(aqJ2.size() - 1));
                    this.cKd.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (f.aqH().aqK().size() <= 3) {
                this.cKd.setVisibility(8);
                linkedList = aqJ;
            } else {
                this.cKd.setVisibility(0);
                linkedList = aqJ;
            }
            this.cKk.fP(true);
            this.cKj.setMaxHeight(this.cKh);
            aqJ = linkedList;
        }
        this.cKk.fQ(f.aqH().aqO());
        this.cKk.setData(aqJ);
        this.cKk.notifyDataSetChanged();
        f.aqH().cKu = 1;
        f.aqH().cKs = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.aqH().cKu = 0;
        f.aqH().cKs = 0;
        HidenSoftKeyPad(this.mInputManager, this.bHW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.cKm);
        f.aqH().cKu = 0;
        this.cKi = null;
    }

    public void a(p pVar) {
        if (pVar != null) {
            if (!TextUtils.isEmpty(pVar.url)) {
                az.uW().b(getPageContext(), new String[]{pVar.url});
                TiebaStatic.log(new aq("c10316").ae("obj_type", pVar.stat).r("obj_locate", 2));
                f.aqH().c(pVar);
                finish();
            } else if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                f.aqH().c(pVar);
                f.aqH().cKr.aqP();
                if (!f.aqH().cKr.aqR()) {
                    f.aqH().cKr.aqQ();
                }
                f.aqH().cKs = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.cKl.groupId, 0L), pVar.groupName, pVar.cKR, 0, pVar.cKT ? 1 : 0)));
                f.aqH().c(pVar);
                f.aqH().cKs = 0;
                f.aqH().cKr.aqP();
                if (!f.aqH().cKr.aqR()) {
                    f.aqH().cKr.aqQ();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.cKl.groupId, 0L), pVar.groupName, pVar.cKR, 0, 4)));
                f.aqH().c(pVar);
                f.aqH().cKs = 0;
                f.aqH().cKr.aqP();
                if (!f.aqH().cKr.aqR()) {
                    f.aqH().cKr.aqQ();
                }
                TiebaStatic.log(new aq("c10321").r("obj_type", 1).ae("obj_name", "click"));
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.aqH().c(pVar);
                f.aqH().cKr.aqP();
                if (!f.aqH().cKr.aqR()) {
                    f.aqH().cKr.aqQ();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.aqH().cKr.aqP();
            finish();
            return true;
        } else if (i == 82) {
            f.aqH().cKr.aqP();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String bh(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String kt(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable aqF() {
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

    public String aqG() {
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
