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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.util.av;
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
    private ImageView eUY;
    private ScreenLockLoadMoreModel fRB;
    private com.baidu.tieba.screenlocknotify.a.a fRC;
    private Window fRu;
    public c fRx;
    public e fRy;
    private Drawable fRv = null;
    public DynamicHeightListView fRw = null;
    private int fRz = 0;
    private TextView fRA = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fRD = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bku().fRJ.bkz();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener fRE = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.fRC != null && !StringUtils.isNull(ScreenLockActivity.this.fRC.getInputMsg()) && (data = ScreenLockActivity.this.fRC.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f(PbActivityConfig.KEY_MSG_ID, data.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId).ac("obj_to", data.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.fRC.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().eK(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.fRC.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.fSd);
                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().eK(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bku().fRJ.bkz();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.fRy = ScreenLockActivity.this.fRx.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.fRy);
        }
    };
    private View.OnClickListener fRF = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.fRC != null) {
                ScreenLockActivity.this.fRy = ScreenLockActivity.this.fRC.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.fRy);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fRG = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.fRA != null) {
                            ScreenLockActivity.this.fRA.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.fRA.setEnabled(true);
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
                        ArrayList<e> bkC = data.bkC();
                        if (ScreenLockActivity.this.fRx != null) {
                            ScreenLockActivity.this.fRx.db(bkC);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.fRx.setHasMore(false);
                            if (ScreenLockActivity.this.fRA != null) {
                                ScreenLockActivity.this.fRw.removeFooterView(ScreenLockActivity.this.fRA);
                                ScreenLockActivity.this.fRA = null;
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
        this.fRu = getWindow();
        this.fRu.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fRu.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0080d.transparent, true);
        if (l.hB()) {
            this.fRv = bks();
            if (this.fRv != null) {
                this.fRu.setBackgroundDrawable(this.fRv);
            }
        }
        this.fRz = l.f(getPageContext().getPageActivity(), d.e.ds935) - l.f(getPageContext().getPageActivity(), d.e.ds80);
        this.fRB = new ScreenLockLoadMoreModel(this);
        registerListener(this.fRG);
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
        this.eUY = (ImageView) findViewById(d.g.head_close);
        this.eUY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.fRx.getCount() > 0 && (item = ScreenLockActivity.this.fRx.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bku().fRJ.bkz();
            }
        });
        this.fRw = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.fRx = new c(getPageContext().getPageActivity());
        this.fRw.setAdapter((ListAdapter) this.fRx);
        this.fRw.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fRD, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bku().fRP = false;
        this.fRw.setMaxHeight(this.fRz);
        this.fRw.setTranscriptMode(0);
        this.fRw.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.fRA != null && ScreenLockActivity.this.fRA.getParent() != null) {
                    if (ScreenLockActivity.this.fRw.getHeight() != ScreenLockActivity.this.fRz) {
                        ScreenLockActivity.this.fRA.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.fRA.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.fRA.isEnabled()) {
                            ScreenLockActivity.this.fRA.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.fRA.setEnabled(false);
                        }
                        ScreenLockActivity.this.Os();
                    }
                }
            }
        });
    }

    private void bkr() {
        this.fRA = new TextView(getActivity());
        this.fRA.setGravity(17);
        this.fRA.setText(d.j.click_load_more);
        this.fRA.setHeight((int) getResources().getDimension(d.e.ds80));
        this.fRA.setBackgroundResource(d.f.screen_notify_item_background);
        this.fRA.setTextColor(getResources().getColorStateList(d.C0080d.screen_notify_load_more_text_color));
        this.fRA.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.fRA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.fRA.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.fRA.setEnabled(false);
                ScreenLockActivity.this.Os();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bkt())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fRB.bkD();
            if (this.fRx != null && this.fRx.getCount() > 0 && (item = this.fRx.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bku().fRM = 1;
        a.bku().fRK = 0;
        List<e> bkw = a.bku().bkw();
        e bkx = a.bku().bkx();
        a.bku().release();
        if ((bkw == null || bkw.isEmpty()) && bkx == null && this.fRx.getCount() == 0 && this.fRw.getHeaderViewsCount() == 0) {
            a.bku().fRJ.bkz();
            finish();
            return;
        }
        da(bkw);
        if (bkx != null) {
            a(bkx);
        }
        if (this.fRC != null) {
            this.fRC.lM(this.fRx.getCount() == 0);
        }
    }

    private void da(List<e> list) {
        if (list != null && list.size() > 0 && this.fRx != null) {
            this.fRx.db(list);
            if (this.fRx.isHasMore() && this.fRA == null) {
                bkr();
                this.fRw.addFooterView(this.fRA);
            }
        }
    }

    private void a(e eVar) {
        if (this.fRC == null) {
            this.fRC = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.fRC.a(this.fRE, this.fRF);
            this.fRC.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fRw.addHeaderView(this.fRC);
        }
        this.fRC.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bku().fRM = 0;
        a.bku().fRK = 0;
        if (this.fRC != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fRC.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fRD);
        a.bku().release();
        a.bku().fRM = 0;
        this.fRv = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new ak("c11703").f(PbActivityConfig.KEY_MSG_ID, eVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId).ac("obj_to", eVar.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!j.hh()) {
                showToast(getResources().getString(d.j.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                av.vI().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new ak("c10316").ac("obj_type", eVar.stat).r("obj_locate", 2));
                a.bku().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.bku().d(eVar);
                a.bku().fRJ.bkz();
                if (!a.bku().fRJ.bkB()) {
                    a.bku().fRJ.bkA();
                }
                a.bku().fRK = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fRy.groupId, 0L), eVar.groupName, eVar.fSd, 0, eVar.foT ? 1 : 0)));
                a.bku().d(eVar);
                a.bku().fRK = 0;
                a.bku().fRJ.bkz();
                if (!a.bku().fRJ.bkB()) {
                    a.bku().fRJ.bkA();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fRy.groupId, 0L), eVar.groupName, eVar.fSd, 0, 4)));
                a.bku().d(eVar);
                a.bku().fRK = 0;
                a.bku().fRJ.bkz();
                if (!a.bku().fRJ.bkB()) {
                    a.bku().fRJ.bkA();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.bku().d(eVar);
                a.bku().fRJ.bkz();
                if (!a.bku().fRJ.bkB()) {
                    a.bku().fRJ.bkA();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bku().fRJ.bkz();
            finish();
            return true;
        } else if (i == 82) {
            a.bku().fRJ.bkz();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bks() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(l.ac(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(l.ae(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String bkt() {
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
