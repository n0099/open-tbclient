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
    private Window bNG;
    private TextView bNH;
    private RelativeLayout bNI;
    private RelativeLayout bNJ;
    private TextView bNK;
    private TextView bNL;
    private TextView bNM;
    private TextView bNN;
    private ImageView bNO;
    private int bNP;
    private int bNQ;
    public o bNT;
    public t bNU;
    private EditText mEditText;
    private Drawable bNR = null;
    public DynamicHeightListView bNS = null;
    private BroadcastReceiver bNV = new a(this);
    private AdapterView.OnItemClickListener wL = new b(this);

    static {
        TbadkApplication.getInst().RegisterIntent(ScreenLockActivityConfig.class, ScreenLockActivity.class);
        try {
            TbadkApplication.getInst().getApp().getClassLoader().loadClass(ScreenLockNotifyService.class.getName());
            f.acB();
            TbadkApplication.getInst().getApp().startService(new Intent(TbadkApplication.getInst().getApp(), ScreenLockNotifyService.class));
            BdLog.i("-------------------启动ScreenlockManager,service!");
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.hN().d("plugin_load", "screenlock_failed", null, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bNG = getWindow();
        this.bNG.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.bNG.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(x.activity_screen_lock);
        if (com.baidu.adp.lib.util.l.fx()) {
            this.bNR = acz();
            if (this.bNR != null) {
                this.bNG.setBackgroundDrawable(this.bNR);
            }
        }
        initUI();
        this.bNP = com.baidu.adp.lib.util.l.d(getPageContext().getPageActivity(), u.ds400);
        this.bNQ = com.baidu.adp.lib.util.l.d(getPageContext().getPageActivity(), u.ds484);
    }

    public void initUI() {
        this.bNI = (RelativeLayout) findViewById(w.screenlock_input_layout);
        this.bNH = (TextView) findViewById(w.screenlock_send_button);
        this.mEditText = (EditText) findViewById(w.screenlock_edit_view);
        this.bNJ = (RelativeLayout) findViewById(w.one_chat_head_layout);
        this.bNK = (TextView) findViewById(w.friend_name_head);
        this.bNL = (TextView) findViewById(w.last_msg_time_head);
        this.bNN = (TextView) findViewById(w.unread_msg_count);
        this.bNM = (TextView) findViewById(w.look_more_textview);
        this.bNM.setOnClickListener(new c(this));
        this.bNH.setOnClickListener(new d(this));
        this.bNO = (ImageView) findViewById(w.head_close);
        this.bNO.setOnClickListener(new e(this));
        this.bNS = (DynamicHeightListView) findViewById(w.screenlock_chat_list_content);
        this.bNT = new o(getPageContext().getPageActivity());
        this.bNS.setAdapter((ListAdapter) this.bNT);
        this.bNS.setOnItemClickListener(this.wL);
        registerReceiver(this.bNV, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.acB().bOh = false;
    }

    public String acy() {
        if (this.mEditText != null) {
            return com.baidu.adp.lib.util.k.a(this.mEditText.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(acA())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        List<t> acC = f.acB().acC();
        if (acC == null || acC.isEmpty()) {
            f.acB().bOb.acH();
            finish();
            return;
        }
        if (f.acB().acD().size() == 1) {
            this.bNI.setVisibility(0);
            t tVar = f.acB().acD().get(0);
            this.bNJ.setVisibility(0);
            this.bNN.setText(hz(tVar.bOt));
            this.bNN.setVisibility(0);
            this.bNK.setText(tVar.groupName);
            this.bNL.setText(aj(tVar.IR));
            this.bNM.setVisibility(8);
            this.bNT.ep(false);
            this.bNS.setMaxHeight(this.bNP);
        } else {
            this.bNI.setVisibility(8);
            this.bNJ.setVisibility(8);
            this.bNN.setVisibility(8);
            if (f.acB().acD().size() <= 3) {
                this.bNM.setVisibility(8);
            } else {
                this.bNM.setVisibility(0);
            }
            this.bNT.ep(true);
            this.bNS.setMaxHeight(this.bNQ);
        }
        this.bNT.setData(acC);
        this.bNT.notifyDataSetChanged();
        f.acB().bOe = 1;
        f.acB().bOc = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.acB().bOe = 0;
        f.acB().bOc = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.bNV);
        f.acB().bOe = 0;
        this.bNR = null;
    }

    public void a(t tVar) {
        if (tVar != null) {
            if (tVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(tVar.groupId), tVar.groupName, 0L, "from_lock")));
                f.acB().c(tVar);
                f.acB().bOc = 0;
                finish();
            } else if (tVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(this.bNU.groupId, 0L), tVar.groupName, tVar.bOu, 0, tVar.bOw ? 1 : 0)));
                f.acB().c(tVar);
                f.acB().bOc = 0;
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.acB().bOb.acH();
            finish();
            return true;
        } else if (i == 82) {
            f.acB().bOb.acH();
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
    public String hz(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable acz() {
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

    public String acA() {
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
