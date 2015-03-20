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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private Window bYc;
    private TextView bYd;
    private RelativeLayout bYe;
    private RelativeLayout bYf;
    private TextView bYg;
    private TextView bYh;
    private TextView bYi;
    private TextView bYj;
    private ImageView bYk;
    private int bYl;
    private int bYm;
    public m bYp;
    public r bYq;
    private EditText mEditText;
    private InputMethodManager mInputManager;
    private Drawable bYn = null;
    public DynamicHeightListView bYo = null;
    private BroadcastReceiver bYr = new a(this);
    private AdapterView.OnItemClickListener HD = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.bYc = getWindow();
        this.bYc.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.bYc.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(w.activity_screen_lock);
        if (com.baidu.adp.lib.util.n.ja()) {
            this.bYn = afL();
            if (this.bYn != null) {
                this.bYc.setBackgroundDrawable(this.bYn);
            }
        }
        initUI();
        this.bYl = com.baidu.adp.lib.util.n.d(getPageContext().getPageActivity(), t.ds400);
        this.bYm = com.baidu.adp.lib.util.n.d(getPageContext().getPageActivity(), t.ds484);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    public void initUI() {
        this.bYe = (RelativeLayout) findViewById(v.screenlock_input_layout);
        this.bYd = (TextView) findViewById(v.screenlock_send_button);
        this.mEditText = (EditText) findViewById(v.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bYf = (RelativeLayout) findViewById(v.one_chat_head_layout);
        this.bYg = (TextView) findViewById(v.friend_name_head);
        this.bYh = (TextView) findViewById(v.last_msg_time_head);
        this.bYj = (TextView) findViewById(v.unread_msg_count);
        this.bYi = (TextView) findViewById(v.look_more_textview);
        this.bYi.setOnClickListener(new c(this));
        this.bYd.setOnClickListener(new d(this));
        this.bYk = (ImageView) findViewById(v.head_close);
        this.bYk.setOnClickListener(new e(this));
        this.bYo = (DynamicHeightListView) findViewById(v.screenlock_chat_list_content);
        this.bYp = new m(getPageContext().getPageActivity());
        this.bYo.setAdapter((ListAdapter) this.bYp);
        this.bYo.setOnItemClickListener(this.HD);
        registerReceiver(this.bYr, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.afN().bYD = false;
    }

    public String afI() {
        if (this.mEditText != null) {
            return com.baidu.adp.lib.util.m.a(this.mEditText.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(afM())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        List<r> afO = f.afN().afO();
        if (afO == null || afO.isEmpty()) {
            afK();
            finish();
            return;
        }
        if (f.afN().afP().size() == 1) {
            this.bYe.setVisibility(0);
            r rVar = f.afN().afP().get(0);
            this.bYf.setVisibility(0);
            this.bYj.setText(hO(rVar.bYQ));
            this.bYj.setVisibility(0);
            this.bYg.setText(rVar.groupName);
            this.bYh.setText(am(rVar.Uw));
            this.bYi.setVisibility(8);
            this.bYp.eo(false);
            this.bYo.setMaxHeight(this.bYl);
        } else {
            this.bYe.setVisibility(8);
            this.bYf.setVisibility(8);
            this.bYj.setVisibility(8);
            if (f.afN().afP().size() <= 3) {
                this.bYi.setVisibility(8);
            } else {
                this.bYi.setVisibility(0);
            }
            this.bYp.eo(true);
            this.bYo.setMaxHeight(this.bYm);
        }
        this.bYp.setData(afO);
        this.bYp.notifyDataSetChanged();
        f.afN().bYA = 1;
        f.afN().bYy = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.afN().bYA = 0;
        f.afN().bYy = 0;
        HidenSoftKeyPad(this.mInputManager, this.mEditText);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.bYr);
        f.afN().bYA = 0;
        this.bYn = null;
    }

    public void a(r rVar) {
        if (rVar != null) {
            if (rVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(rVar.groupId), rVar.groupName, 0L, "from_lock")));
                f.afN().c(rVar);
                afK();
                if (!f.afN().bYx.afT()) {
                    afJ();
                }
                f.afN().bYy = 0;
                finish();
            } else if (rVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(this.bYq.groupId, 0L), rVar.groupName, rVar.bYR, 0, rVar.bYT ? 1 : 0)));
                f.afN().c(rVar);
                f.afN().bYy = 0;
                afK();
                if (!f.afN().bYx.afT()) {
                    afJ();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                afK();
                if (!f.afN().bYx.afT()) {
                    afJ();
                }
                finish();
            }
        }
    }

    public void afJ() {
        f.afN().bYx.afJ();
    }

    public void afK() {
        f.afN().bYx.afK();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            afK();
            finish();
            return true;
        } else if (i == 82) {
            afK();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String am(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String hO(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable afL() {
        Bitmap bitmap;
        Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
        if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            int min = Math.min(com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity()), bitmap.getWidth());
            int min2 = Math.min(com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity()), bitmap.getHeight());
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
    }

    public String afM() {
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
