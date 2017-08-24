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
    private ImageView bti;
    private Window fMq;
    public c fMt;
    public e fMu;
    private ScreenLockLoadMoreModel fMx;
    private com.baidu.tieba.screenlocknotify.a.a fMy;
    private Drawable fMr = null;
    public DynamicHeightListView fMs = null;
    private int fMv = 0;
    private TextView fMw = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fMz = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bjq().fMF.bjv();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener fMA = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.fMy != null && !StringUtils.isNull(ScreenLockActivity.this.fMy.getInputMsg()) && (data = ScreenLockActivity.this.fMy.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new aj("c11703").g(PbActivityConfig.KEY_MSG_ID, data.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId).aa("obj_to", data.url).aa(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.fMy.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.yZ().eR(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.fMy.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L), data.userName, data.fMZ);
                    com.baidu.tbadk.coreExtra.messageCenter.a.yZ().eR(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new af("lockscreen_reply", true).start();
                a.bjq().fMF.bjv();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.fMu = ScreenLockActivity.this.fMt.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.fMu);
        }
    };
    private View.OnClickListener fMB = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.fMy != null) {
                ScreenLockActivity.this.fMu = ScreenLockActivity.this.fMy.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.fMu);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fMC = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.l.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.fMw != null) {
                            ScreenLockActivity.this.fMw.setText(ScreenLockActivity.this.getResources().getString(d.l.data_load_error));
                            ScreenLockActivity.this.fMw.setEnabled(true);
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
                        ArrayList<e> bjy = data.bjy();
                        if (ScreenLockActivity.this.fMt != null) {
                            ScreenLockActivity.this.fMt.de(bjy);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.fMt.setHasMore(false);
                            if (ScreenLockActivity.this.fMw != null) {
                                ScreenLockActivity.this.fMs.removeFooterView(ScreenLockActivity.this.fMw);
                                ScreenLockActivity.this.fMw = null;
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
        this.fMq = getWindow();
        this.fMq.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fMq.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.transparent, true);
        if (k.hL()) {
            this.fMr = bjp();
            if (this.fMr != null) {
                this.fMq.setBackgroundDrawable(this.fMr);
            }
        }
        this.fMv = k.g(getPageContext().getPageActivity(), d.f.ds935) - k.g(getPageContext().getPageActivity(), d.f.ds80);
        this.fMx = new ScreenLockLoadMoreModel(this);
        registerListener(this.fMC);
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
        this.bti = (ImageView) findViewById(d.h.head_close);
        this.bti.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.fMt.getCount() > 0 && (item = ScreenLockActivity.this.fMt.getItem(0)) != null) {
                    TiebaStatic.log(new aj("c11704").g(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bjq().fMF.bjv();
            }
        });
        this.fMs = (DynamicHeightListView) findViewById(d.h.screenlock_chat_list_content);
        this.fMt = new c(getPageContext().getPageActivity());
        this.fMs.setAdapter((ListAdapter) this.fMt);
        this.fMs.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fMz, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bjq().fML = false;
        this.fMs.setMaxHeight(this.fMv);
        this.fMs.setTranscriptMode(0);
        this.fMs.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.fMw != null && ScreenLockActivity.this.fMw.getParent() != null) {
                    if (ScreenLockActivity.this.fMs.getHeight() != ScreenLockActivity.this.fMv) {
                        ScreenLockActivity.this.fMw.setText(ScreenLockActivity.this.getResources().getString(d.l.click_load_more));
                        ScreenLockActivity.this.fMw.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.fMw.isEnabled()) {
                            ScreenLockActivity.this.fMw.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                            ScreenLockActivity.this.fMw.setEnabled(false);
                        }
                        ScreenLockActivity.this.Nv();
                    }
                }
            }
        });
    }

    private void bjo() {
        this.fMw = new TextView(getActivity());
        this.fMw.setGravity(17);
        this.fMw.setText(d.l.click_load_more);
        this.fMw.setHeight((int) getResources().getDimension(d.f.ds80));
        this.fMw.setBackgroundResource(d.g.screen_notify_item_background);
        this.fMw.setTextColor(getResources().getColorStateList(d.e.screen_notify_load_more_text_color));
        this.fMw.setTextSize(0, getResources().getDimension(d.f.fontsize32));
        this.fMw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.fMw.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                ScreenLockActivity.this.fMw.setEnabled(false);
                ScreenLockActivity.this.Nv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bhw())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nv() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fMx.bjz();
            if (this.fMt != null && this.fMt.getCount() > 0 && (item = this.fMt.getItem(0)) != null) {
                TiebaStatic.log(new aj("c11738").g(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bjq().fMI = 1;
        a.bjq().fMG = 0;
        List<e> bjs = a.bjq().bjs();
        e bjt = a.bjq().bjt();
        a.bjq().release();
        if ((bjs == null || bjs.isEmpty()) && bjt == null && this.fMt.getCount() == 0 && this.fMs.getHeaderViewsCount() == 0) {
            a.bjq().fMF.bjv();
            finish();
            return;
        }
        dd(bjs);
        if (bjt != null) {
            a(bjt);
        }
        if (this.fMy != null) {
            this.fMy.lK(this.fMt.getCount() == 0);
        }
    }

    private void dd(List<e> list) {
        if (list != null && list.size() > 0 && this.fMt != null) {
            this.fMt.de(list);
            if (this.fMt.isHasMore() && this.fMw == null) {
                bjo();
                this.fMs.addFooterView(this.fMw);
            }
        }
    }

    private void a(e eVar) {
        if (this.fMy == null) {
            this.fMy = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.fMy.a(this.fMA, this.fMB);
            this.fMy.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fMs.addHeaderView(this.fMy);
        }
        this.fMy.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bjq().fMI = 0;
        a.bjq().fMG = 0;
        if (this.fMy != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fMy.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fMz);
        a.bjq().release();
        a.bjq().fMI = 0;
        this.fMr = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new aj("c11703").g(PbActivityConfig.KEY_MSG_ID, eVar.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId).aa("obj_to", eVar.url).aa(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!i.hr()) {
                showToast(getResources().getString(d.l.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                at.wg().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new aj("c10316").aa("obj_type", eVar.stat).r("obj_locate", 2));
                a.bjq().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.bjq().d(eVar);
                a.bjq().fMF.bjv();
                if (!a.bjq().fMF.bjx()) {
                    a.bjq().fMF.bjw();
                }
                a.bjq().fMG = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.fMu.groupId, 0L), eVar.groupName, eVar.fMZ, 0, eVar.flB ? 1 : 0)));
                a.bjq().d(eVar);
                a.bjq().fMG = 0;
                a.bjq().fMF.bjv();
                if (!a.bjq().fMF.bjx()) {
                    a.bjq().fMF.bjw();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.fMu.groupId, 0L), eVar.groupName, eVar.fMZ, 0, 4)));
                a.bjq().d(eVar);
                a.bjq().fMG = 0;
                a.bjq().fMF.bjv();
                if (!a.bjq().fMF.bjx()) {
                    a.bjq().fMF.bjw();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.bjq().d(eVar);
                a.bjq().fMF.bjv();
                if (!a.bjq().fMF.bjx()) {
                    a.bjq().fMF.bjw();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bjq().fMF.bjv();
            finish();
            return true;
        } else if (i == 82) {
            a.bjq().fMF.bjv();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bjp() {
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

    public String bhw() {
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
