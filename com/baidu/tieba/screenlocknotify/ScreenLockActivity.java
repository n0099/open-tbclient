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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.u;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private EditText cWP;
    private Window eHd;
    private TextView eHe;
    private RelativeLayout eHf;
    private RelativeLayout eHg;
    private TextView eHh;
    private TextView eHi;
    private TextView eHj;
    private TextView eHk;
    private ImageView eHl;
    private int eHm;
    private int eHn;
    public n eHq;
    public p eHr;
    private InputMethodManager mInputManager;
    private Drawable eHo = null;
    public DynamicHeightListView eHp = null;
    private BroadcastReceiver eHs = new a(this);
    private AdapterView.OnItemClickListener yQ = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.eHd = getWindow();
        this.eHd.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.eHd.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(u.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(u.d.transparent, true);
        if (com.baidu.adp.lib.util.k.fL()) {
            this.eHo = aUW();
            if (this.eHo != null) {
                this.eHd.setBackgroundDrawable(this.eHo);
            }
        }
        nl();
        this.eHm = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), u.e.ds360);
        this.eHn = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), u.e.ds484);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    public void nl() {
        this.eHf = (RelativeLayout) findViewById(u.g.screenlock_input_layout);
        this.eHe = (TextView) findViewById(u.g.screenlock_send_button);
        this.cWP = (EditText) findViewById(u.g.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eHg = (RelativeLayout) findViewById(u.g.one_chat_head_layout);
        this.eHh = (TextView) findViewById(u.g.friend_name_head);
        this.eHi = (TextView) findViewById(u.g.last_msg_time_head);
        this.eHk = (TextView) findViewById(u.g.unread_msg_count);
        this.eHj = (TextView) findViewById(u.g.look_more_textview);
        this.eHj.setOnClickListener(new c(this));
        this.eHe.setOnClickListener(new d(this));
        this.eHl = (ImageView) findViewById(u.g.head_close);
        this.eHl.setOnClickListener(new e(this));
        this.eHp = (DynamicHeightListView) findViewById(u.g.screenlock_chat_list_content);
        this.eHq = new n(getPageContext().getPageActivity());
        this.eHp.setAdapter((ListAdapter) this.eHq);
        this.eHp.setOnItemClickListener(this.yQ);
        registerReceiver(this.eHs, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.aUX().eHD = false;
    }

    public String aUV() {
        if (this.cWP != null) {
            return com.baidu.adp.lib.util.j.a(this.cWP.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(aUn())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> aUZ = f.aUX().aUZ();
        if (aUZ == null || aUZ.isEmpty()) {
            f.aUX().eHx.aVf();
            finish();
            return;
        }
        if (f.aUX().aVa().size() == 1) {
            p pVar = f.aUX().aVa().get(0);
            if (f.aUX().aVe()) {
                this.eHf.setVisibility(8);
                this.eHk.setVisibility(8);
                this.eHg.setVisibility(8);
                this.eHp.setMaxHeight(0);
            } else {
                this.eHf.setVisibility(0);
                this.eHk.setText(pP(pVar.eHV));
                this.eHk.setVisibility(0);
                this.eHg.setVisibility(0);
                this.eHh.setText(pVar.groupName);
                this.eHi.setText(cz(pVar.lastTime));
                this.eHp.setMaxHeight(this.eHm);
                this.eHp.setTranscriptMode(2);
            }
            this.eHj.setVisibility(8);
            this.eHq.jD(false);
        } else {
            this.eHf.setVisibility(8);
            this.eHg.setVisibility(8);
            this.eHk.setVisibility(8);
            if (f.aUX().aVe()) {
                if (f.aUX().aVa().size() < 3) {
                    this.eHj.setVisibility(8);
                    linkedList = aUZ;
                } else {
                    List<p> aUZ2 = f.aUX().aUZ();
                    LinkedList linkedList2 = new LinkedList(aUZ2.subList(0, 2));
                    linkedList2.add(aUZ2.get(aUZ2.size() - 1));
                    this.eHj.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (f.aUX().aVa().size() <= 3) {
                this.eHj.setVisibility(8);
                linkedList = aUZ;
            } else {
                this.eHj.setVisibility(0);
                linkedList = aUZ;
            }
            this.eHq.jD(true);
            this.eHp.setMaxHeight(this.eHn);
            this.eHp.setTranscriptMode(0);
            aUZ = linkedList;
        }
        this.eHq.jE(f.aUX().aVe());
        this.eHq.setData(aUZ);
        this.eHq.notifyDataSetChanged();
        f.aUX().eHA = 1;
        f.aUX().eHy = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.aUX().eHA = 0;
        f.aUX().eHy = 0;
        HidenSoftKeyPad(this.mInputManager, this.cWP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.eHs);
        f.aUX().eHA = 0;
        this.eHo = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void a(p pVar) {
        if (pVar != null) {
            if (!TextUtils.isEmpty(pVar.url)) {
                bi.us().c(getPageContext(), new String[]{pVar.url});
                TiebaStatic.log(new ay("c10316").ab("obj_type", pVar.stat).s("obj_locate", 2));
                f.aUX().c(pVar);
                finish();
            } else if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                f.aUX().c(pVar);
                f.aUX().eHx.aVf();
                if (!f.aUX().eHx.aVh()) {
                    f.aUX().eHx.aVg();
                }
                f.aUX().eHy = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.eHr.groupId, 0L), pVar.groupName, pVar.eHW, 0, pVar.eHY ? 1 : 0)));
                f.aUX().c(pVar);
                f.aUX().eHy = 0;
                f.aUX().eHx.aVf();
                if (!f.aUX().eHx.aVh()) {
                    f.aUX().eHx.aVg();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.eHr.groupId, 0L), pVar.groupName, pVar.eHW, 0, 4)));
                f.aUX().c(pVar);
                f.aUX().eHy = 0;
                f.aUX().eHx.aVf();
                if (!f.aUX().eHx.aVh()) {
                    f.aUX().eHx.aVg();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.aUX().c(pVar);
                f.aUX().eHx.aVf();
                if (!f.aUX().eHx.aVh()) {
                    f.aUX().eHx.aVg();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.aUX().eHx.aVf();
            finish();
            return true;
        } else if (i == 82) {
            f.aUX().eHx.aVf();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cz(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String pP(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable aUW() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(com.baidu.adp.lib.util.k.A(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String aUn() {
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
