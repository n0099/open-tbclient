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
    private EditText cqC;
    private int dZA;
    public n dZD;
    public p dZE;
    private Window dZq;
    private TextView dZr;
    private RelativeLayout dZs;
    private RelativeLayout dZt;
    private TextView dZu;
    private TextView dZv;
    private TextView dZw;
    private TextView dZx;
    private ImageView dZy;
    private int dZz;
    private InputMethodManager mInputManager;
    private Drawable dZB = null;
    public DynamicHeightListView dZC = null;
    private BroadcastReceiver dZF = new a(this);
    private AdapterView.OnItemClickListener Iy = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.dZq = getWindow();
        this.dZq.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.dZq.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(t.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(t.d.transparent, true);
        if (com.baidu.adp.lib.util.k.jz()) {
            this.dZB = aME();
            if (this.dZB != null) {
                this.dZq.setBackgroundDrawable(this.dZB);
            }
        }
        pU();
        this.dZz = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds360);
        this.dZA = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds484);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    public void pU() {
        this.dZs = (RelativeLayout) findViewById(t.g.screenlock_input_layout);
        this.dZr = (TextView) findViewById(t.g.screenlock_send_button);
        this.cqC = (EditText) findViewById(t.g.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dZt = (RelativeLayout) findViewById(t.g.one_chat_head_layout);
        this.dZu = (TextView) findViewById(t.g.friend_name_head);
        this.dZv = (TextView) findViewById(t.g.last_msg_time_head);
        this.dZx = (TextView) findViewById(t.g.unread_msg_count);
        this.dZw = (TextView) findViewById(t.g.look_more_textview);
        this.dZw.setOnClickListener(new c(this));
        this.dZr.setOnClickListener(new d(this));
        this.dZy = (ImageView) findViewById(t.g.head_close);
        this.dZy.setOnClickListener(new e(this));
        this.dZC = (DynamicHeightListView) findViewById(t.g.screenlock_chat_list_content);
        this.dZD = new n(getPageContext().getPageActivity());
        this.dZC.setAdapter((ListAdapter) this.dZD);
        this.dZC.setOnItemClickListener(this.Iy);
        registerReceiver(this.dZF, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.aMF().dZQ = false;
    }

    public String aMD() {
        if (this.cqC != null) {
            return com.baidu.adp.lib.util.j.a(this.cqC.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(aLb())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> aMH = f.aMF().aMH();
        if (aMH == null || aMH.isEmpty()) {
            f.aMF().dZK.aMN();
            finish();
            return;
        }
        if (f.aMF().aMI().size() == 1) {
            p pVar = f.aMF().aMI().get(0);
            if (f.aMF().aMM()) {
                this.dZs.setVisibility(8);
                this.dZx.setVisibility(8);
                this.dZt.setVisibility(8);
                this.dZC.setMaxHeight(0);
            } else {
                this.dZs.setVisibility(0);
                this.dZx.setText(oH(pVar.eai));
                this.dZx.setVisibility(0);
                this.dZt.setVisibility(0);
                this.dZu.setText(pVar.groupName);
                this.dZv.setText(bY(pVar.eak));
                this.dZC.setMaxHeight(this.dZz);
            }
            this.dZw.setVisibility(8);
            this.dZD.id(false);
        } else {
            this.dZs.setVisibility(8);
            this.dZt.setVisibility(8);
            this.dZx.setVisibility(8);
            if (f.aMF().aMM()) {
                if (f.aMF().aMI().size() < 3) {
                    this.dZw.setVisibility(8);
                    linkedList = aMH;
                } else {
                    List<p> aMH2 = f.aMF().aMH();
                    LinkedList linkedList2 = new LinkedList(aMH2.subList(0, 2));
                    linkedList2.add(aMH2.get(aMH2.size() - 1));
                    this.dZw.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (f.aMF().aMI().size() <= 3) {
                this.dZw.setVisibility(8);
                linkedList = aMH;
            } else {
                this.dZw.setVisibility(0);
                linkedList = aMH;
            }
            this.dZD.id(true);
            this.dZC.setMaxHeight(this.dZA);
            aMH = linkedList;
        }
        this.dZD.ie(f.aMF().aMM());
        this.dZD.setData(aMH);
        this.dZD.notifyDataSetChanged();
        f.aMF().dZN = 1;
        f.aMF().dZL = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.aMF().dZN = 0;
        f.aMF().dZL = 0;
        HidenSoftKeyPad(this.mInputManager, this.cqC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.dZF);
        f.aMF().dZN = 0;
        this.dZB = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void a(p pVar) {
        if (pVar != null) {
            if (!TextUtils.isEmpty(pVar.url)) {
                bg.wM().c(getPageContext(), new String[]{pVar.url});
                TiebaStatic.log(new aw("c10316").ac("obj_type", pVar.stat).r("obj_locate", 2));
                f.aMF().c(pVar);
                finish();
            } else if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                f.aMF().c(pVar);
                f.aMF().dZK.aMN();
                if (!f.aMF().dZK.aMP()) {
                    f.aMF().dZK.aMO();
                }
                f.aMF().dZL = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.dZE.groupId, 0L), pVar.groupName, pVar.eaj, 0, pVar.eam ? 1 : 0)));
                f.aMF().c(pVar);
                f.aMF().dZL = 0;
                f.aMF().dZK.aMN();
                if (!f.aMF().dZK.aMP()) {
                    f.aMF().dZK.aMO();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.dZE.groupId, 0L), pVar.groupName, pVar.eaj, 0, 4)));
                f.aMF().c(pVar);
                f.aMF().dZL = 0;
                f.aMF().dZK.aMN();
                if (!f.aMF().dZK.aMP()) {
                    f.aMF().dZK.aMO();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.aMF().c(pVar);
                f.aMF().dZK.aMN();
                if (!f.aMF().dZK.aMP()) {
                    f.aMF().dZK.aMO();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.aMF().dZK.aMN();
            finish();
            return true;
        } else if (i == 82) {
            f.aMF().dZK.aMN();
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
    public String oH(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable aME() {
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

    public String aLb() {
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
