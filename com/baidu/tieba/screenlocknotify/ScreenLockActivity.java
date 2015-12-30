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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.n;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private EditText cbx;
    private Window dqS;
    private TextView dqT;
    private RelativeLayout dqU;
    private RelativeLayout dqV;
    private TextView dqW;
    private TextView dqX;
    private TextView dqY;
    private TextView dqZ;
    private ImageView dra;
    private int drb;
    private int drc;
    public n drf;
    public p drg;
    private InputMethodManager mInputManager;
    private Drawable drd = null;
    public DynamicHeightListView dre = null;
    private BroadcastReceiver drh = new a(this);
    private AdapterView.OnItemClickListener If = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.dqS = getWindow();
        this.dqS.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.dqS.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(n.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(n.d.transparent, true);
        if (com.baidu.adp.lib.util.k.jk()) {
            this.drd = ayM();
            if (this.drd != null) {
                this.dqS.setBackgroundDrawable(this.drd);
            }
        }
        initUI();
        this.drb = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.e.ds360);
        this.drc = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.e.ds484);
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
        this.dqU = (RelativeLayout) findViewById(n.g.screenlock_input_layout);
        this.dqT = (TextView) findViewById(n.g.screenlock_send_button);
        this.cbx = (EditText) findViewById(n.g.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dqV = (RelativeLayout) findViewById(n.g.one_chat_head_layout);
        this.dqW = (TextView) findViewById(n.g.friend_name_head);
        this.dqX = (TextView) findViewById(n.g.last_msg_time_head);
        this.dqZ = (TextView) findViewById(n.g.unread_msg_count);
        this.dqY = (TextView) findViewById(n.g.look_more_textview);
        this.dqY.setOnClickListener(new c(this));
        this.dqT.setOnClickListener(new d(this));
        this.dra = (ImageView) findViewById(n.g.head_close);
        this.dra.setOnClickListener(new e(this));
        this.dre = (DynamicHeightListView) findViewById(n.g.screenlock_chat_list_content);
        this.drf = new n(getPageContext().getPageActivity());
        this.dre.setAdapter((ListAdapter) this.drf);
        this.dre.setOnItemClickListener(this.If);
        registerReceiver(this.drh, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.ayO().drs = false;
    }

    public String ayL() {
        if (this.cbx != null) {
            return com.baidu.adp.lib.util.j.a(this.cbx.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(ayN())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> ayQ = f.ayO().ayQ();
        if (ayQ == null || ayQ.isEmpty()) {
            f.ayO().drm.ayW();
            finish();
            return;
        }
        if (f.ayO().ayR().size() == 1) {
            p pVar = f.ayO().ayR().get(0);
            if (f.ayO().ayV()) {
                this.dqU.setVisibility(8);
                this.dqZ.setVisibility(8);
                this.dqV.setVisibility(8);
                this.dre.setMaxHeight(0);
            } else {
                this.dqU.setVisibility(0);
                this.dqZ.setText(mq(pVar.drK));
                this.dqZ.setVisibility(0);
                this.dqV.setVisibility(0);
                this.dqW.setText(pVar.groupName);
                this.dqX.setText(bK(pVar.drM));
                this.dre.setMaxHeight(this.drb);
            }
            this.dqY.setVisibility(8);
            this.drf.gQ(false);
        } else {
            this.dqU.setVisibility(8);
            this.dqV.setVisibility(8);
            this.dqZ.setVisibility(8);
            if (f.ayO().ayV()) {
                if (f.ayO().ayR().size() < 3) {
                    this.dqY.setVisibility(8);
                    linkedList = ayQ;
                } else {
                    List<p> ayQ2 = f.ayO().ayQ();
                    LinkedList linkedList2 = new LinkedList(ayQ2.subList(0, 2));
                    linkedList2.add(ayQ2.get(ayQ2.size() - 1));
                    this.dqY.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (f.ayO().ayR().size() <= 3) {
                this.dqY.setVisibility(8);
                linkedList = ayQ;
            } else {
                this.dqY.setVisibility(0);
                linkedList = ayQ;
            }
            this.drf.gQ(true);
            this.dre.setMaxHeight(this.drc);
            ayQ = linkedList;
        }
        this.drf.gR(f.ayO().ayV());
        this.drf.setData(ayQ);
        this.drf.notifyDataSetChanged();
        f.ayO().drp = 1;
        f.ayO().drn = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.ayO().drp = 0;
        f.ayO().drn = 0;
        HidenSoftKeyPad(this.mInputManager, this.cbx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.drh);
        f.ayO().drp = 0;
        this.drd = null;
    }

    public void a(p pVar) {
        if (pVar != null) {
            if (!TextUtils.isEmpty(pVar.url)) {
                bf.vn().b(getPageContext(), new String[]{pVar.url});
                TiebaStatic.log(new av("c10316").aa("obj_type", pVar.stat).r("obj_locate", 2));
                f.ayO().c(pVar);
                finish();
            } else if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                f.ayO().c(pVar);
                f.ayO().drm.ayW();
                if (!f.ayO().drm.ayY()) {
                    f.ayO().drm.ayX();
                }
                f.ayO().drn = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.drg.groupId, 0L), pVar.groupName, pVar.drL, 0, pVar.drO ? 1 : 0)));
                f.ayO().c(pVar);
                f.ayO().drn = 0;
                f.ayO().drm.ayW();
                if (!f.ayO().drm.ayY()) {
                    f.ayO().drm.ayX();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.drg.groupId, 0L), pVar.groupName, pVar.drL, 0, 4)));
                f.ayO().c(pVar);
                f.ayO().drn = 0;
                f.ayO().drm.ayW();
                if (!f.ayO().drm.ayY()) {
                    f.ayO().drm.ayX();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.ayO().c(pVar);
                f.ayO().drm.ayW();
                if (!f.ayO().drm.ayY()) {
                    f.ayO().drm.ayX();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.ayO().drm.ayW();
            finish();
            return true;
        } else if (i == 82) {
            f.ayO().drm.ayW();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String bK(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String mq(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable ayM() {
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

    public String ayN() {
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
