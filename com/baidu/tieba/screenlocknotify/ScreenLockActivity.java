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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.r;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private EditText dmQ;
    private Window feZ;
    private TextView ffa;
    private RelativeLayout ffb;
    private RelativeLayout ffc;
    private TextView ffd;
    private TextView ffe;
    private TextView fff;
    private TextView ffg;
    private ImageView ffh;
    private int ffi;
    private int ffj;
    public n ffm;
    public p ffn;
    private InputMethodManager mInputManager;
    private Drawable ffk = null;
    public DynamicHeightListView ffl = null;
    private BroadcastReceiver ffo = new a(this);
    private AdapterView.OnItemClickListener BG = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.feZ = getWindow();
        this.feZ.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.feZ.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(r.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(r.d.transparent, true);
        if (com.baidu.adp.lib.util.k.gG()) {
            this.ffk = bcv();
            if (this.ffk != null) {
                this.feZ.setBackgroundDrawable(this.ffk);
            }
        }
        initUI();
        this.ffi = com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds360);
        this.ffj = com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds484);
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
        this.ffb = (RelativeLayout) findViewById(r.g.screenlock_input_layout);
        this.ffa = (TextView) findViewById(r.g.screenlock_send_button);
        this.dmQ = (EditText) findViewById(r.g.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.ffc = (RelativeLayout) findViewById(r.g.one_chat_head_layout);
        this.ffd = (TextView) findViewById(r.g.friend_name_head);
        this.ffe = (TextView) findViewById(r.g.last_msg_time_head);
        this.ffg = (TextView) findViewById(r.g.unread_msg_count);
        this.fff = (TextView) findViewById(r.g.look_more_textview);
        this.fff.setOnClickListener(new c(this));
        this.ffa.setOnClickListener(new d(this));
        this.ffh = (ImageView) findViewById(r.g.head_close);
        this.ffh.setOnClickListener(new e(this));
        this.ffl = (DynamicHeightListView) findViewById(r.g.screenlock_chat_list_content);
        this.ffm = new n(getPageContext().getPageActivity());
        this.ffl.setAdapter((ListAdapter) this.ffm);
        this.ffl.setOnItemClickListener(this.BG);
        registerReceiver(this.ffo, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.bcw().ffz = false;
    }

    public String aCN() {
        if (this.dmQ != null) {
            return com.baidu.adp.lib.util.j.a(this.dmQ.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bbA())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> bcy = f.bcw().bcy();
        if (bcy == null || bcy.isEmpty()) {
            f.bcw().fft.bcE();
            finish();
            return;
        }
        if (f.bcw().bcz().size() == 1) {
            p pVar = f.bcw().bcz().get(0);
            if (f.bcw().bcD()) {
                this.ffb.setVisibility(8);
                this.ffg.setVisibility(8);
                this.ffc.setVisibility(8);
                this.ffl.setMaxHeight(0);
            } else {
                this.ffb.setVisibility(0);
                this.ffg.setText(qX(pVar.ffR));
                this.ffg.setVisibility(0);
                this.ffc.setVisibility(0);
                this.ffd.setText(pVar.groupName);
                this.ffe.setText(cR(pVar.lastTime));
                this.ffl.setMaxHeight(this.ffi);
                this.ffl.setTranscriptMode(2);
            }
            this.fff.setVisibility(8);
            this.ffm.kg(false);
        } else {
            this.ffb.setVisibility(8);
            this.ffc.setVisibility(8);
            this.ffg.setVisibility(8);
            if (f.bcw().bcD()) {
                if (f.bcw().bcz().size() < 3) {
                    this.fff.setVisibility(8);
                    linkedList = bcy;
                } else {
                    List<p> bcy2 = f.bcw().bcy();
                    LinkedList linkedList2 = new LinkedList(bcy2.subList(0, 2));
                    linkedList2.add(bcy2.get(bcy2.size() - 1));
                    this.fff.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (f.bcw().bcz().size() <= 3) {
                this.fff.setVisibility(8);
                linkedList = bcy;
            } else {
                this.fff.setVisibility(0);
                linkedList = bcy;
            }
            this.ffm.kg(true);
            this.ffl.setMaxHeight(this.ffj);
            this.ffl.setTranscriptMode(0);
            bcy = linkedList;
        }
        this.ffm.kh(f.bcw().bcD());
        this.ffm.setData(bcy);
        this.ffm.notifyDataSetChanged();
        f.bcw().ffw = 1;
        f.bcw().ffu = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.bcw().ffw = 0;
        f.bcw().ffu = 0;
        HidenSoftKeyPad(this.mInputManager, this.dmQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.ffo);
        f.bcw().ffw = 0;
        this.ffk = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void a(p pVar) {
        if (pVar != null) {
            TiebaStatic.log(new ax("c11703").g(PbActivityConfig.KEY_MSG_ID, pVar.msgId));
            if (!TextUtils.isEmpty(pVar.url)) {
                bh.vL().c(getPageContext(), new String[]{pVar.url});
                TiebaStatic.log(new ax("c10316").ab("obj_type", pVar.stat).s("obj_locate", 2));
                f.bcw().c(pVar);
                finish();
            } else if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                f.bcw().c(pVar);
                f.bcw().fft.bcE();
                if (!f.bcw().fft.bcG()) {
                    f.bcw().fft.bcF();
                }
                f.bcw().ffu = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.ffn.groupId, 0L), pVar.groupName, pVar.ffS, 0, pVar.eKw ? 1 : 0)));
                f.bcw().c(pVar);
                f.bcw().ffu = 0;
                f.bcw().fft.bcE();
                if (!f.bcw().fft.bcG()) {
                    f.bcw().fft.bcF();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.ffn.groupId, 0L), pVar.groupName, pVar.ffS, 0, 4)));
                f.bcw().c(pVar);
                f.bcw().ffu = 0;
                f.bcw().fft.bcE();
                if (!f.bcw().fft.bcG()) {
                    f.bcw().fft.bcF();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.bcw().c(pVar);
                f.bcw().fft.bcE();
                if (!f.bcw().fft.bcG()) {
                    f.bcw().fft.bcF();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.bcw().fft.bcE();
            finish();
            return true;
        } else if (i == 82) {
            f.bcw().fft.bcE();
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
    public String qX(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable bcv() {
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

    public String bbA() {
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
