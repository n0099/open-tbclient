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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private EditText crz;
    private RelativeLayout ecA;
    private TextView ecB;
    private TextView ecC;
    private TextView ecD;
    private TextView ecE;
    private ImageView ecF;
    private int ecG;
    private int ecH;
    public n ecK;
    public p ecL;
    private Window ecx;
    private TextView ecy;
    private RelativeLayout ecz;
    private InputMethodManager mInputManager;
    private Drawable ecI = null;
    public DynamicHeightListView ecJ = null;
    private BroadcastReceiver ecM = new a(this);
    private AdapterView.OnItemClickListener yR = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.ecx = getWindow();
        this.ecx.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.ecx.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(t.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(t.d.transparent, true);
        if (com.baidu.adp.lib.util.k.fK()) {
            this.ecI = aMO();
            if (this.ecI != null) {
                this.ecx.setBackgroundDrawable(this.ecI);
            }
        }
        nq();
        this.ecG = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds360);
        this.ecH = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds484);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    public void nq() {
        this.ecz = (RelativeLayout) findViewById(t.g.screenlock_input_layout);
        this.ecy = (TextView) findViewById(t.g.screenlock_send_button);
        this.crz = (EditText) findViewById(t.g.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.ecA = (RelativeLayout) findViewById(t.g.one_chat_head_layout);
        this.ecB = (TextView) findViewById(t.g.friend_name_head);
        this.ecC = (TextView) findViewById(t.g.last_msg_time_head);
        this.ecE = (TextView) findViewById(t.g.unread_msg_count);
        this.ecD = (TextView) findViewById(t.g.look_more_textview);
        this.ecD.setOnClickListener(new c(this));
        this.ecy.setOnClickListener(new d(this));
        this.ecF = (ImageView) findViewById(t.g.head_close);
        this.ecF.setOnClickListener(new e(this));
        this.ecJ = (DynamicHeightListView) findViewById(t.g.screenlock_chat_list_content);
        this.ecK = new n(getPageContext().getPageActivity());
        this.ecJ.setAdapter((ListAdapter) this.ecK);
        this.ecJ.setOnItemClickListener(this.yR);
        registerReceiver(this.ecM, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.aMP().ecX = false;
    }

    public String aMN() {
        if (this.crz != null) {
            return com.baidu.adp.lib.util.j.a(this.crz.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(aLf())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> aMR = f.aMP().aMR();
        if (aMR == null || aMR.isEmpty()) {
            f.aMP().ecR.aMX();
            finish();
            return;
        }
        if (f.aMP().aMS().size() == 1) {
            p pVar = f.aMP().aMS().get(0);
            if (f.aMP().aMW()) {
                this.ecz.setVisibility(8);
                this.ecE.setVisibility(8);
                this.ecA.setVisibility(8);
                this.ecJ.setMaxHeight(0);
            } else {
                this.ecz.setVisibility(0);
                this.ecE.setText(oB(pVar.edp));
                this.ecE.setVisibility(0);
                this.ecA.setVisibility(0);
                this.ecB.setText(pVar.groupName);
                this.ecC.setText(bY(pVar.lastTime));
                this.ecJ.setMaxHeight(this.ecG);
            }
            this.ecD.setVisibility(8);
            this.ecK.iS(false);
        } else {
            this.ecz.setVisibility(8);
            this.ecA.setVisibility(8);
            this.ecE.setVisibility(8);
            if (f.aMP().aMW()) {
                if (f.aMP().aMS().size() < 3) {
                    this.ecD.setVisibility(8);
                    linkedList = aMR;
                } else {
                    List<p> aMR2 = f.aMP().aMR();
                    LinkedList linkedList2 = new LinkedList(aMR2.subList(0, 2));
                    linkedList2.add(aMR2.get(aMR2.size() - 1));
                    this.ecD.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (f.aMP().aMS().size() <= 3) {
                this.ecD.setVisibility(8);
                linkedList = aMR;
            } else {
                this.ecD.setVisibility(0);
                linkedList = aMR;
            }
            this.ecK.iS(true);
            this.ecJ.setMaxHeight(this.ecH);
            aMR = linkedList;
        }
        this.ecK.iT(f.aMP().aMW());
        this.ecK.setData(aMR);
        this.ecK.notifyDataSetChanged();
        f.aMP().ecU = 1;
        f.aMP().ecS = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.aMP().ecU = 0;
        f.aMP().ecS = 0;
        HidenSoftKeyPad(this.mInputManager, this.crz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.ecM);
        f.aMP().ecU = 0;
        this.ecI = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void a(p pVar) {
        if (pVar != null) {
            if (!TextUtils.isEmpty(pVar.url)) {
                bg.us().c(getPageContext(), new String[]{pVar.url});
                TiebaStatic.log(new aw("c10316").ac("obj_type", pVar.stat).s("obj_locate", 2));
                f.aMP().c(pVar);
                finish();
            } else if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                f.aMP().c(pVar);
                f.aMP().ecR.aMX();
                if (!f.aMP().ecR.aMZ()) {
                    f.aMP().ecR.aMY();
                }
                f.aMP().ecS = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.ecL.groupId, 0L), pVar.groupName, pVar.edq, 0, pVar.eds ? 1 : 0)));
                f.aMP().c(pVar);
                f.aMP().ecS = 0;
                f.aMP().ecR.aMX();
                if (!f.aMP().ecR.aMZ()) {
                    f.aMP().ecR.aMY();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.ecL.groupId, 0L), pVar.groupName, pVar.edq, 0, 4)));
                f.aMP().c(pVar);
                f.aMP().ecS = 0;
                f.aMP().ecR.aMX();
                if (!f.aMP().ecR.aMZ()) {
                    f.aMP().ecR.aMY();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.aMP().c(pVar);
                f.aMP().ecR.aMX();
                if (!f.aMP().ecR.aMZ()) {
                    f.aMP().ecR.aMY();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.aMP().ecR.aMX();
            finish();
            return true;
        } else if (i == 82) {
            f.aMP().ecR.aMX();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String bY(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String oB(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable aMO() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(com.baidu.adp.lib.util.k.C(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String aLf() {
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
