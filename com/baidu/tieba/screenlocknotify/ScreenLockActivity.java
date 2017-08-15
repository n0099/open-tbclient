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
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
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
    private ImageView bth;
    private Window fMp;
    public c fMs;
    public e fMt;
    private ScreenLockLoadMoreModel fMw;
    private com.baidu.tieba.screenlocknotify.a.a fMx;
    private Drawable fMq = null;
    public DynamicHeightListView fMr = null;
    private int fMu = 0;
    private TextView fMv = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fMy = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bjv().fME.bjA();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener fMz = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.fMx != null && !StringUtils.isNull(ScreenLockActivity.this.fMx.getInputMsg()) && (data = ScreenLockActivity.this.fMx.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new aj("c11703").g(PbActivityConfig.KEY_MSG_ID, data.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId).aa("obj_to", data.url).aa(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.fMx.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.yZ().eN(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.fMx.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L), data.userName, data.fMY);
                    com.baidu.tbadk.coreExtra.messageCenter.a.yZ().eN(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new af("lockscreen_reply", true).start();
                a.bjv().fME.bjA();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.fMt = ScreenLockActivity.this.fMs.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.fMt);
        }
    };
    private View.OnClickListener fMA = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.fMx != null) {
                ScreenLockActivity.this.fMt = ScreenLockActivity.this.fMx.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.fMt);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fMB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.l.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.fMv != null) {
                            ScreenLockActivity.this.fMv.setText(ScreenLockActivity.this.getResources().getString(d.l.data_load_error));
                            ScreenLockActivity.this.fMv.setEnabled(true);
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
                        ArrayList<e> bjD = data.bjD();
                        if (ScreenLockActivity.this.fMs != null) {
                            ScreenLockActivity.this.fMs.de(bjD);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.fMs.setHasMore(false);
                            if (ScreenLockActivity.this.fMv != null) {
                                ScreenLockActivity.this.fMr.removeFooterView(ScreenLockActivity.this.fMv);
                                ScreenLockActivity.this.fMv = null;
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
        this.fMp = getWindow();
        this.fMp.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fMp.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.transparent, true);
        if (k.hL()) {
            this.fMq = bju();
            if (this.fMq != null) {
                this.fMp.setBackgroundDrawable(this.fMq);
            }
        }
        this.fMu = k.g(getPageContext().getPageActivity(), d.f.ds935) - k.g(getPageContext().getPageActivity(), d.f.ds80);
        this.fMw = new ScreenLockLoadMoreModel(this);
        registerListener(this.fMB);
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
        this.bth = (ImageView) findViewById(d.h.head_close);
        this.bth.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.fMs.getCount() > 0 && (item = ScreenLockActivity.this.fMs.getItem(0)) != null) {
                    TiebaStatic.log(new aj("c11704").g(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bjv().fME.bjA();
            }
        });
        this.fMr = (DynamicHeightListView) findViewById(d.h.screenlock_chat_list_content);
        this.fMs = new c(getPageContext().getPageActivity());
        this.fMr.setAdapter((ListAdapter) this.fMs);
        this.fMr.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fMy, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bjv().fMK = false;
        this.fMr.setMaxHeight(this.fMu);
        this.fMr.setTranscriptMode(0);
        this.fMr.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.fMv != null && ScreenLockActivity.this.fMv.getParent() != null) {
                    if (ScreenLockActivity.this.fMr.getHeight() != ScreenLockActivity.this.fMu) {
                        ScreenLockActivity.this.fMv.setText(ScreenLockActivity.this.getResources().getString(d.l.click_load_more));
                        ScreenLockActivity.this.fMv.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.fMv.isEnabled()) {
                            ScreenLockActivity.this.fMv.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                            ScreenLockActivity.this.fMv.setEnabled(false);
                        }
                        ScreenLockActivity.this.Nv();
                    }
                }
            }
        });
    }

    private void bjt() {
        this.fMv = new TextView(getActivity());
        this.fMv.setGravity(17);
        this.fMv.setText(d.l.click_load_more);
        this.fMv.setHeight((int) getResources().getDimension(d.f.ds80));
        this.fMv.setBackgroundResource(d.g.screen_notify_item_background);
        this.fMv.setTextColor(getResources().getColorStateList(d.e.screen_notify_load_more_text_color));
        this.fMv.setTextSize(0, getResources().getDimension(d.f.fontsize32));
        this.fMv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.fMv.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                ScreenLockActivity.this.fMv.setEnabled(false);
                ScreenLockActivity.this.Nv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bhB())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nv() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fMw.bjE();
            if (this.fMs != null && this.fMs.getCount() > 0 && (item = this.fMs.getItem(0)) != null) {
                TiebaStatic.log(new aj("c11738").g(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bjv().fMH = 1;
        a.bjv().fMF = 0;
        List<e> bjx = a.bjv().bjx();
        e bjy = a.bjv().bjy();
        a.bjv().release();
        if ((bjx == null || bjx.isEmpty()) && bjy == null && this.fMs.getCount() == 0 && this.fMr.getHeaderViewsCount() == 0) {
            a.bjv().fME.bjA();
            finish();
            return;
        }
        dd(bjx);
        if (bjy != null) {
            a(bjy);
        }
        if (this.fMx != null) {
            this.fMx.lK(this.fMs.getCount() == 0);
        }
    }

    private void dd(List<e> list) {
        if (list != null && list.size() > 0 && this.fMs != null) {
            this.fMs.de(list);
            if (this.fMs.isHasMore() && this.fMv == null) {
                bjt();
                this.fMr.addFooterView(this.fMv);
            }
        }
    }

    private void a(e eVar) {
        if (this.fMx == null) {
            this.fMx = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.fMx.b(this.fMz, this.fMA);
            this.fMx.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fMr.addHeaderView(this.fMx);
        }
        this.fMx.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bjv().fMH = 0;
        a.bjv().fMF = 0;
        if (this.fMx != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fMx.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fMy);
        a.bjv().release();
        a.bjv().fMH = 0;
        this.fMq = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new aj("c11703").g(PbActivityConfig.KEY_MSG_ID, eVar.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId).aa("obj_to", eVar.url).aa(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!i.hr()) {
                showToast(getResources().getString(d.l.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                at.wf().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new aj("c10316").aa("obj_type", eVar.stat).r("obj_locate", 2));
                a.bjv().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.bjv().d(eVar);
                a.bjv().fME.bjA();
                if (!a.bjv().fME.bjC()) {
                    a.bjv().fME.bjB();
                }
                a.bjv().fMF = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.fMt.groupId, 0L), eVar.groupName, eVar.fMY, 0, eVar.flz ? 1 : 0)));
                a.bjv().d(eVar);
                a.bjv().fMF = 0;
                a.bjv().fME.bjA();
                if (!a.bjv().fME.bjC()) {
                    a.bjv().fME.bjB();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.fMt.groupId, 0L), eVar.groupName, eVar.fMY, 0, 4)));
                a.bjv().d(eVar);
                a.bjv().fMF = 0;
                a.bjv().fME.bjA();
                if (!a.bjv().fME.bjC()) {
                    a.bjv().fME.bjB();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.bjv().d(eVar);
                a.bjv().fME.bjA();
                if (!a.bjv().fME.bjC()) {
                    a.bjv().fME.bjB();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bjv().fME.bjA();
            finish();
            return true;
        } else if (i == 82) {
            a.bjv().fME.bjA();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bju() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(k.ag(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(k.ah(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String bhB() {
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
