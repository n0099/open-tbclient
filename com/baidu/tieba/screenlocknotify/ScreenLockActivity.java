package com.baidu.tieba.screenlocknotify;

import android.app.ActivityManager;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView buI;
    private Window fLh;
    public c fLk;
    public e fLl;
    private ScreenLockLoadMoreModel fLo;
    private com.baidu.tieba.screenlocknotify.a.a fLp;
    private Drawable fLi = null;
    public DynamicHeightListView fLj = null;
    private int fLm = 0;
    private TextView fLn = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fLq = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.biA().fLw.biF();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener fLr = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.fLp != null && !StringUtils.isNull(ScreenLockActivity.this.fLp.getInputMsg()) && (data = ScreenLockActivity.this.fLp.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f(PbActivityConfig.KEY_MSG_ID, data.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId).ad("obj_to", data.url).ad(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.fLp.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.zd().eL(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.fLp.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.fLQ);
                    com.baidu.tbadk.coreExtra.messageCenter.a.zd().eL(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.biA().fLw.biF();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.fLl = ScreenLockActivity.this.fLk.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.fLl);
        }
    };
    private View.OnClickListener fLs = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.fLp != null) {
                ScreenLockActivity.this.fLl = ScreenLockActivity.this.fLp.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.fLl);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fLt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.l.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.fLn != null) {
                            ScreenLockActivity.this.fLn.setText(ScreenLockActivity.this.getResources().getString(d.l.data_load_error));
                            ScreenLockActivity.this.fLn.setEnabled(true);
                            return;
                        }
                        return;
                    }
                    if (responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) {
                        data = ((ScreenLockLoadMoreHttpResponseMessage) responsedMessage).getData();
                    } else {
                        data = responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage ? ((ScreenLockLoadMoreSocketResponseMessage) responsedMessage).getData() : null;
                    }
                    if (data != null) {
                        ArrayList<e> biI = data.biI();
                        if (ScreenLockActivity.this.fLk != null) {
                            ScreenLockActivity.this.fLk.dc(biI);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.fLk.setHasMore(false);
                            if (ScreenLockActivity.this.fLn != null) {
                                ScreenLockActivity.this.fLj.removeFooterView(ScreenLockActivity.this.fLn);
                                ScreenLockActivity.this.fLn = null;
                            }
                        }
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.fLh = getWindow();
        this.fLh.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fLh.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.transparent, true);
        if (k.hC()) {
            this.fLi = biy();
            if (this.fLi != null) {
                this.fLh.setBackgroundDrawable(this.fLi);
            }
        }
        this.fLm = k.f(getPageContext().getPageActivity(), d.f.ds935) - k.f(getPageContext().getPageActivity(), d.f.ds80);
        this.fLo = new ScreenLockLoadMoreModel(this);
        registerListener(this.fLt);
        initUI();
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
        this.buI = (ImageView) findViewById(d.h.head_close);
        this.buI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.fLk.getCount() > 0 && (item = ScreenLockActivity.this.fLk.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.biA().fLw.biF();
            }
        });
        this.fLj = (DynamicHeightListView) findViewById(d.h.screenlock_chat_list_content);
        this.fLk = new c(getPageContext().getPageActivity());
        this.fLj.setAdapter((ListAdapter) this.fLk);
        this.fLj.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fLq, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.biA().fLC = false;
        this.fLj.setMaxHeight(this.fLm);
        this.fLj.setTranscriptMode(0);
        this.fLj.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.fLn != null && ScreenLockActivity.this.fLn.getParent() != null) {
                    if (ScreenLockActivity.this.fLj.getHeight() != ScreenLockActivity.this.fLm) {
                        ScreenLockActivity.this.fLn.setText(ScreenLockActivity.this.getResources().getString(d.l.click_load_more));
                        ScreenLockActivity.this.fLn.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.fLn.isEnabled()) {
                            ScreenLockActivity.this.fLn.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                            ScreenLockActivity.this.fLn.setEnabled(false);
                        }
                        ScreenLockActivity.this.NM();
                    }
                }
            }
        });
    }

    private void bix() {
        this.fLn = new TextView(getActivity());
        this.fLn.setGravity(17);
        this.fLn.setText(d.l.click_load_more);
        this.fLn.setHeight((int) getResources().getDimension(d.f.ds80));
        this.fLn.setBackgroundResource(d.g.screen_notify_item_background);
        this.fLn.setTextColor(getResources().getColorStateList(d.e.screen_notify_load_more_text_color));
        this.fLn.setTextSize(0, getResources().getDimension(d.f.fontsize32));
        this.fLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.fLn.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                ScreenLockActivity.this.fLn.setEnabled(false);
                ScreenLockActivity.this.NM();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(biz())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NM() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fLo.biJ();
            if (this.fLk != null && this.fLk.getCount() > 0 && (item = this.fLk.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.biA().fLz = 1;
        a.biA().fLx = 0;
        List<e> biC = a.biA().biC();
        e biD = a.biA().biD();
        a.biA().release();
        if ((biC == null || biC.isEmpty()) && biD == null && this.fLk.getCount() == 0 && this.fLj.getHeaderViewsCount() == 0) {
            a.biA().fLw.biF();
            finish();
            return;
        }
        db(biC);
        if (biD != null) {
            a(biD);
        }
        if (this.fLp != null) {
            this.fLp.lR(this.fLk.getCount() == 0);
        }
    }

    private void db(List<e> list) {
        if (list != null && list.size() > 0 && this.fLk != null) {
            this.fLk.dc(list);
            if (this.fLk.isHasMore() && this.fLn == null) {
                bix();
                this.fLj.addFooterView(this.fLn);
            }
        }
    }

    private void a(e eVar) {
        if (this.fLp == null) {
            this.fLp = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.fLp.a(this.fLr, this.fLs);
            this.fLp.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fLj.addHeaderView(this.fLp);
        }
        this.fLp.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.biA().fLz = 0;
        a.biA().fLx = 0;
        if (this.fLp != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fLp.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fLq);
        a.biA().release();
        a.biA().fLz = 0;
        this.fLi = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new ak("c11703").f(PbActivityConfig.KEY_MSG_ID, eVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId).ad("obj_to", eVar.url).ad(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!i.hi()) {
                showToast(getResources().getString(d.l.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                au.wd().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new ak("c10316").ad("obj_type", eVar.stat).r("obj_locate", 2));
                a.biA().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.biA().d(eVar);
                a.biA().fLw.biF();
                if (!a.biA().fLw.biH()) {
                    a.biA().fLw.biG();
                }
                a.biA().fLx = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fLl.groupId, 0L), eVar.groupName, eVar.fLQ, 0, eVar.fkO ? 1 : 0)));
                a.biA().d(eVar);
                a.biA().fLx = 0;
                a.biA().fLw.biF();
                if (!a.biA().fLw.biH()) {
                    a.biA().fLw.biG();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fLl.groupId, 0L), eVar.groupName, eVar.fLQ, 0, 4)));
                a.biA().d(eVar);
                a.biA().fLx = 0;
                a.biA().fLw.biF();
                if (!a.biA().fLw.biH()) {
                    a.biA().fLw.biG();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.biA().d(eVar);
                a.biA().fLw.biF();
                if (!a.biA().fLw.biH()) {
                    a.biA().fLw.biG();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.biA().fLw.biF();
            finish();
            return true;
        } else if (i == 82) {
            a.biA().fLw.biF();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable biy() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(k.ae(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(k.af(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String biz() {
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
