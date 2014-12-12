package com.baidu.tieba.screenlocknotify;

import android.app.ActivityManager;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.KeyEvent;
import android.view.Window;
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
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private Window bLX;
    private TextView bLY;
    private RelativeLayout bLZ;
    private RelativeLayout bMa;
    private TextView bMb;
    private TextView bMc;
    private TextView bMd;
    private TextView bMe;
    private ImageView bMf;
    private int bMg;
    private int bMh;
    public o bMk;
    public t bMl;
    private EditText mEditText;
    private Drawable bMi = null;
    public DynamicHeightListView bMj = null;
    private BroadcastReceiver bMm = new a(this);
    private AdapterView.OnItemClickListener wO = new b(this);

    static {
        TbadkApplication.getInst().RegisterIntent(ScreenLockActivityConfig.class, ScreenLockActivity.class);
        try {
            TbadkApplication.getInst().getApp().getClassLoader().loadClass(ScreenLockNotifyService.class.getName());
            f.acd();
            TbadkApplication.getInst().getApp().startService(new Intent(TbadkApplication.getInst().getApp(), ScreenLockNotifyService.class));
            BdLog.i("-------------------启动ScreenlockManager,service!");
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.hU().c("plugin_load", "screenlock_failed", null, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bLX = getWindow();
        this.bLX.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.bLX.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(x.activity_screen_lock);
        if (com.baidu.adp.lib.util.l.fy()) {
            this.bMi = acb();
            if (this.bMi != null) {
                this.bLX.setBackgroundDrawable(this.bMi);
            }
        }
        initUI();
        this.bMg = com.baidu.adp.lib.util.l.d(getPageContext().getPageActivity(), u.ds400);
        this.bMh = com.baidu.adp.lib.util.l.d(getPageContext().getPageActivity(), u.ds484);
    }

    public void initUI() {
        this.bLZ = (RelativeLayout) findViewById(w.screenlock_input_layout);
        this.bLY = (TextView) findViewById(w.screenlock_send_button);
        this.mEditText = (EditText) findViewById(w.screenlock_edit_view);
        this.bMa = (RelativeLayout) findViewById(w.one_chat_head_layout);
        this.bMb = (TextView) findViewById(w.friend_name_head);
        this.bMc = (TextView) findViewById(w.last_msg_time_head);
        this.bMe = (TextView) findViewById(w.unread_msg_count);
        this.bMd = (TextView) findViewById(w.look_more_textview);
        this.bMd.setOnClickListener(new c(this));
        this.bLY.setOnClickListener(new d(this));
        this.bMf = (ImageView) findViewById(w.head_close);
        this.bMf.setOnClickListener(new e(this));
        this.bMj = (DynamicHeightListView) findViewById(w.screenlock_chat_list_content);
        this.bMk = new o(getPageContext().getPageActivity());
        this.bMj.setAdapter((ListAdapter) this.bMk);
        this.bMj.setOnItemClickListener(this.wO);
        registerReceiver(this.bMm, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.acd().bMy = false;
    }

    public String abZ() {
        if (this.mEditText != null) {
            return com.baidu.adp.lib.util.k.a(this.mEditText.getText(), null);
        }
        return null;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(acc())) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        List<t> ace = f.acd().ace();
        if (ace == null || ace.isEmpty()) {
            aca();
            finish();
            return;
        }
        if (f.acd().acf().size() == 1) {
            this.bLZ.setVisibility(0);
            t tVar = f.acd().acf().get(0);
            this.bMa.setVisibility(0);
            this.bMe.setText(hq(tVar.bMK));
            this.bMe.setVisibility(0);
            this.bMb.setText(tVar.groupName);
            this.bMc.setText(aj(tVar.IK));
            this.bMd.setVisibility(8);
            this.bMk.ei(false);
            this.bMj.setMaxHeight(this.bMg);
        } else {
            this.bLZ.setVisibility(8);
            this.bMa.setVisibility(8);
            this.bMe.setVisibility(8);
            if (f.acd().acf().size() <= 3) {
                this.bMd.setVisibility(8);
            } else {
                this.bMd.setVisibility(0);
            }
            this.bMk.ei(true);
            this.bMj.setMaxHeight(this.bMh);
        }
        this.bMk.setData(ace);
        this.bMk.notifyDataSetChanged();
        f.acd().bMv = 1;
        f.acd().bMt = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.acd().bMv = 0;
        f.acd().bMt = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.bMm);
        f.acd().bMv = 0;
        this.bMi = null;
    }

    public void a(t tVar) {
        if (tVar != null) {
            if (tVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(tVar.groupId), tVar.groupName, 0L, "from_lock")));
                f.acd().c(tVar);
                f.acd().bMt = 0;
                finish();
            } else if (tVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(this.bMl.groupId, 0L), tVar.groupName, tVar.bML, 0, tVar.bMN ? 1 : 0)));
                f.acd().c(tVar);
                f.acd().bMt = 0;
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                finish();
            }
        }
    }

    public void aca() {
        f.acd().bMs.aca();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aca();
            finish();
            return true;
        } else if (i == 82) {
            aca();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String aj(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String hq(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable acb() {
        Bitmap bitmap;
        Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
        if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            int min = Math.min(com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity()), bitmap.getWidth());
            int min2 = Math.min(com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String acc() {
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
