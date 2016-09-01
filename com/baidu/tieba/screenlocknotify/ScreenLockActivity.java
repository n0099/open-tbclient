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
import com.baidu.tieba.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private EditText dlt;
    private int fcA;
    private int fcB;
    public n fcE;
    public p fcF;
    private Window fcr;
    private TextView fcs;
    private RelativeLayout fct;
    private RelativeLayout fcu;
    private TextView fcv;
    private TextView fcw;
    private TextView fcx;
    private TextView fcy;
    private ImageView fcz;
    private InputMethodManager mInputManager;
    private Drawable fcC = null;
    public DynamicHeightListView fcD = null;
    private BroadcastReceiver fcG = new a(this);
    private AdapterView.OnItemClickListener BG = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.fcr = getWindow();
        this.fcr.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fcr.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(t.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(t.d.transparent, true);
        if (com.baidu.adp.lib.util.k.gG()) {
            this.fcC = bbL();
            if (this.fcC != null) {
                this.fcr.setBackgroundDrawable(this.fcC);
            }
        }
        initUI();
        this.fcA = com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), t.e.ds360);
        this.fcB = com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), t.e.ds484);
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
        this.fct = (RelativeLayout) findViewById(t.g.screenlock_input_layout);
        this.fcs = (TextView) findViewById(t.g.screenlock_send_button);
        this.dlt = (EditText) findViewById(t.g.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.fcu = (RelativeLayout) findViewById(t.g.one_chat_head_layout);
        this.fcv = (TextView) findViewById(t.g.friend_name_head);
        this.fcw = (TextView) findViewById(t.g.last_msg_time_head);
        this.fcy = (TextView) findViewById(t.g.unread_msg_count);
        this.fcx = (TextView) findViewById(t.g.look_more_textview);
        this.fcx.setOnClickListener(new c(this));
        this.fcs.setOnClickListener(new d(this));
        this.fcz = (ImageView) findViewById(t.g.head_close);
        this.fcz.setOnClickListener(new e(this));
        this.fcD = (DynamicHeightListView) findViewById(t.g.screenlock_chat_list_content);
        this.fcE = new n(getPageContext().getPageActivity());
        this.fcD.setAdapter((ListAdapter) this.fcE);
        this.fcD.setOnItemClickListener(this.BG);
        registerReceiver(this.fcG, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.bbM().fcR = false;
    }

    public String aCn() {
        if (this.dlt != null) {
            return com.baidu.adp.lib.util.j.a(this.dlt.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(baT())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> bbO = f.bbM().bbO();
        if (bbO == null || bbO.isEmpty()) {
            f.bbM().fcL.bbU();
            finish();
            return;
        }
        if (f.bbM().bbP().size() == 1) {
            p pVar = f.bbM().bbP().get(0);
            if (f.bbM().bbT()) {
                this.fct.setVisibility(8);
                this.fcy.setVisibility(8);
                this.fcu.setVisibility(8);
                this.fcD.setMaxHeight(0);
            } else {
                this.fct.setVisibility(0);
                this.fcy.setText(qJ(pVar.fdj));
                this.fcy.setVisibility(0);
                this.fcu.setVisibility(0);
                this.fcv.setText(pVar.groupName);
                this.fcw.setText(cR(pVar.lastTime));
                this.fcD.setMaxHeight(this.fcA);
                this.fcD.setTranscriptMode(2);
            }
            this.fcx.setVisibility(8);
            this.fcE.kd(false);
        } else {
            this.fct.setVisibility(8);
            this.fcu.setVisibility(8);
            this.fcy.setVisibility(8);
            if (f.bbM().bbT()) {
                if (f.bbM().bbP().size() < 3) {
                    this.fcx.setVisibility(8);
                    linkedList = bbO;
                } else {
                    List<p> bbO2 = f.bbM().bbO();
                    LinkedList linkedList2 = new LinkedList(bbO2.subList(0, 2));
                    linkedList2.add(bbO2.get(bbO2.size() - 1));
                    this.fcx.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (f.bbM().bbP().size() <= 3) {
                this.fcx.setVisibility(8);
                linkedList = bbO;
            } else {
                this.fcx.setVisibility(0);
                linkedList = bbO;
            }
            this.fcE.kd(true);
            this.fcD.setMaxHeight(this.fcB);
            this.fcD.setTranscriptMode(0);
            bbO = linkedList;
        }
        this.fcE.ke(f.bbM().bbT());
        this.fcE.setData(bbO);
        this.fcE.notifyDataSetChanged();
        f.bbM().fcO = 1;
        f.bbM().fcM = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.bbM().fcO = 0;
        f.bbM().fcM = 0;
        HidenSoftKeyPad(this.mInputManager, this.dlt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fcG);
        f.bbM().fcO = 0;
        this.fcC = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void a(p pVar) {
        if (pVar != null) {
            if (!TextUtils.isEmpty(pVar.url)) {
                bi.vx().c(getPageContext(), new String[]{pVar.url});
                TiebaStatic.log(new ay("c10316").ab("obj_type", pVar.stat).s("obj_locate", 2));
                f.bbM().c(pVar);
                finish();
            } else if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                f.bbM().c(pVar);
                f.bbM().fcL.bbU();
                if (!f.bbM().fcL.bbW()) {
                    f.bbM().fcL.bbV();
                }
                f.bbM().fcM = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.fcF.groupId, 0L), pVar.groupName, pVar.fdk, 0, pVar.eIs ? 1 : 0)));
                f.bbM().c(pVar);
                f.bbM().fcM = 0;
                f.bbM().fcL.bbU();
                if (!f.bbM().fcL.bbW()) {
                    f.bbM().fcL.bbV();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.fcF.groupId, 0L), pVar.groupName, pVar.fdk, 0, 4)));
                f.bbM().c(pVar);
                f.bbM().fcM = 0;
                f.bbM().fcL.bbU();
                if (!f.bbM().fcL.bbW()) {
                    f.bbM().fcL.bbV();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.bbM().c(pVar);
                f.bbM().fcL.bbU();
                if (!f.bbM().fcL.bbW()) {
                    f.bbM().fcL.bbV();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.bbM().fcL.bbU();
            finish();
            return true;
        } else if (i == 82) {
            f.bbM().fcL.bbU();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cR(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String qJ(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable bbL() {
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

    public String baT() {
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
