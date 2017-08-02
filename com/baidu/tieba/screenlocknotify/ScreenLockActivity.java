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
    private ImageView brI;
    private Window fJj;
    public c fJm;
    public e fJn;
    private ScreenLockLoadMoreModel fJq;
    private com.baidu.tieba.screenlocknotify.a.a fJr;
    private Drawable fJk = null;
    public DynamicHeightListView fJl = null;
    private int fJo = 0;
    private TextView fJp = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fJs = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.biF().fJy.biK();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener fJt = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.fJr != null && !StringUtils.isNull(ScreenLockActivity.this.fJr.getInputMsg()) && (data = ScreenLockActivity.this.fJr.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new aj("c11703").f(PbActivityConfig.KEY_MSG_ID, data.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId).aa("obj_to", data.url).aa(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.fJr.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.yR().eH(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.fJr.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.fJS);
                    com.baidu.tbadk.coreExtra.messageCenter.a.yR().eH(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new af("lockscreen_reply", true).start();
                a.biF().fJy.biK();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.fJn = ScreenLockActivity.this.fJm.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.fJn);
        }
    };
    private View.OnClickListener fJu = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.fJr != null) {
                ScreenLockActivity.this.fJn = ScreenLockActivity.this.fJr.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.fJn);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fJv = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.l.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.fJp != null) {
                            ScreenLockActivity.this.fJp.setText(ScreenLockActivity.this.getResources().getString(d.l.data_load_error));
                            ScreenLockActivity.this.fJp.setEnabled(true);
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
                        ArrayList<e> biN = data.biN();
                        if (ScreenLockActivity.this.fJm != null) {
                            ScreenLockActivity.this.fJm.db(biN);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.fJm.setHasMore(false);
                            if (ScreenLockActivity.this.fJp != null) {
                                ScreenLockActivity.this.fJl.removeFooterView(ScreenLockActivity.this.fJp);
                                ScreenLockActivity.this.fJp = null;
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
        this.fJj = getWindow();
        this.fJj.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fJj.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.transparent, true);
        if (k.hB()) {
            this.fJk = biE();
            if (this.fJk != null) {
                this.fJj.setBackgroundDrawable(this.fJk);
            }
        }
        this.fJo = k.g(getPageContext().getPageActivity(), d.f.ds935) - k.g(getPageContext().getPageActivity(), d.f.ds80);
        this.fJq = new ScreenLockLoadMoreModel(this);
        registerListener(this.fJv);
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
        this.brI = (ImageView) findViewById(d.h.head_close);
        this.brI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.fJm.getCount() > 0 && (item = ScreenLockActivity.this.fJm.getItem(0)) != null) {
                    TiebaStatic.log(new aj("c11704").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.biF().fJy.biK();
            }
        });
        this.fJl = (DynamicHeightListView) findViewById(d.h.screenlock_chat_list_content);
        this.fJm = new c(getPageContext().getPageActivity());
        this.fJl.setAdapter((ListAdapter) this.fJm);
        this.fJl.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fJs, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.biF().fJE = false;
        this.fJl.setMaxHeight(this.fJo);
        this.fJl.setTranscriptMode(0);
        this.fJl.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.fJp != null && ScreenLockActivity.this.fJp.getParent() != null) {
                    if (ScreenLockActivity.this.fJl.getHeight() != ScreenLockActivity.this.fJo) {
                        ScreenLockActivity.this.fJp.setText(ScreenLockActivity.this.getResources().getString(d.l.click_load_more));
                        ScreenLockActivity.this.fJp.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.fJp.isEnabled()) {
                            ScreenLockActivity.this.fJp.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                            ScreenLockActivity.this.fJp.setEnabled(false);
                        }
                        ScreenLockActivity.this.Nq();
                    }
                }
            }
        });
    }

    private void biD() {
        this.fJp = new TextView(getActivity());
        this.fJp.setGravity(17);
        this.fJp.setText(d.l.click_load_more);
        this.fJp.setHeight((int) getResources().getDimension(d.f.ds80));
        this.fJp.setBackgroundResource(d.g.screen_notify_item_background);
        this.fJp.setTextColor(getResources().getColorStateList(d.e.screen_notify_load_more_text_color));
        this.fJp.setTextSize(0, getResources().getDimension(d.f.fontsize32));
        this.fJp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.fJp.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                ScreenLockActivity.this.fJp.setEnabled(false);
                ScreenLockActivity.this.Nq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bgL())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nq() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fJq.biO();
            if (this.fJm != null && this.fJm.getCount() > 0 && (item = this.fJm.getItem(0)) != null) {
                TiebaStatic.log(new aj("c11738").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.biF().fJB = 1;
        a.biF().fJz = 0;
        List<e> biH = a.biF().biH();
        e biI = a.biF().biI();
        a.biF().release();
        if ((biH == null || biH.isEmpty()) && biI == null && this.fJm.getCount() == 0 && this.fJl.getHeaderViewsCount() == 0) {
            a.biF().fJy.biK();
            finish();
            return;
        }
        da(biH);
        if (biI != null) {
            a(biI);
        }
        if (this.fJr != null) {
            this.fJr.lH(this.fJm.getCount() == 0);
        }
    }

    private void da(List<e> list) {
        if (list != null && list.size() > 0 && this.fJm != null) {
            this.fJm.db(list);
            if (this.fJm.isHasMore() && this.fJp == null) {
                biD();
                this.fJl.addFooterView(this.fJp);
            }
        }
    }

    private void a(e eVar) {
        if (this.fJr == null) {
            this.fJr = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.fJr.b(this.fJt, this.fJu);
            this.fJr.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fJl.addHeaderView(this.fJr);
        }
        this.fJr.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.biF().fJB = 0;
        a.biF().fJz = 0;
        if (this.fJr != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fJr.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fJs);
        a.biF().release();
        a.biF().fJB = 0;
        this.fJk = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new aj("c11703").f(PbActivityConfig.KEY_MSG_ID, eVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId).aa("obj_to", eVar.url).aa(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!i.hh()) {
                showToast(getResources().getString(d.l.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                at.vV().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new aj("c10316").aa("obj_type", eVar.stat).r("obj_locate", 2));
                a.biF().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.biF().d(eVar);
                a.biF().fJy.biK();
                if (!a.biF().fJy.biM()) {
                    a.biF().fJy.biL();
                }
                a.biF().fJz = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fJn.groupId, 0L), eVar.groupName, eVar.fJS, 0, eVar.fit ? 1 : 0)));
                a.biF().d(eVar);
                a.biF().fJz = 0;
                a.biF().fJy.biK();
                if (!a.biF().fJy.biM()) {
                    a.biF().fJy.biL();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fJn.groupId, 0L), eVar.groupName, eVar.fJS, 0, 4)));
                a.biF().d(eVar);
                a.biF().fJz = 0;
                a.biF().fJy.biK();
                if (!a.biF().fJy.biM()) {
                    a.biF().fJy.biL();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.biF().d(eVar);
                a.biF().fJy.biK();
                if (!a.biF().fJy.biM()) {
                    a.biF().fJy.biL();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.biF().fJy.biK();
            finish();
            return true;
        } else if (i == 82) {
            a.biF().fJy.biK();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable biE() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(k.af(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(k.ag(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String bgL() {
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
