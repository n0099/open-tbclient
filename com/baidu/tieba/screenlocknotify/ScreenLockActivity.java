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
    private ImageView bws;
    private Window fHR;
    public c fHU;
    public e fHV;
    private ScreenLockLoadMoreModel fHY;
    private com.baidu.tieba.screenlocknotify.a.a fHZ;
    private Drawable fHS = null;
    public DynamicHeightListView fHT = null;
    private int fHW = 0;
    private TextView fHX = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fIa = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bhb().fIg.bhg();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener fIb = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.fHZ != null && !StringUtils.isNull(ScreenLockActivity.this.fHZ.getInputMsg()) && (data = ScreenLockActivity.this.fHZ.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f(PbActivityConfig.KEY_MSG_ID, data.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId).ad("obj_to", data.url).ad(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.fHZ.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.yB().eE(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.fHZ.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.fIA);
                    com.baidu.tbadk.coreExtra.messageCenter.a.yB().eE(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bhb().fIg.bhg();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.fHV = ScreenLockActivity.this.fHU.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.fHV);
        }
    };
    private View.OnClickListener fIc = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.fHZ != null) {
                ScreenLockActivity.this.fHV = ScreenLockActivity.this.fHZ.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.fHV);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fId = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.l.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.fHX != null) {
                            ScreenLockActivity.this.fHX.setText(ScreenLockActivity.this.getResources().getString(d.l.data_load_error));
                            ScreenLockActivity.this.fHX.setEnabled(true);
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
                        ArrayList<e> bhj = data.bhj();
                        if (ScreenLockActivity.this.fHU != null) {
                            ScreenLockActivity.this.fHU.cY(bhj);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.fHU.setHasMore(false);
                            if (ScreenLockActivity.this.fHX != null) {
                                ScreenLockActivity.this.fHT.removeFooterView(ScreenLockActivity.this.fHX);
                                ScreenLockActivity.this.fHX = null;
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
        this.fHR = getWindow();
        this.fHR.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fHR.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.transparent, true);
        if (l.hB()) {
            this.fHS = bgZ();
            if (this.fHS != null) {
                this.fHR.setBackgroundDrawable(this.fHS);
            }
        }
        this.fHW = l.f(getPageContext().getPageActivity(), d.f.ds935) - l.f(getPageContext().getPageActivity(), d.f.ds80);
        this.fHY = new ScreenLockLoadMoreModel(this);
        registerListener(this.fId);
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
        this.bws = (ImageView) findViewById(d.h.head_close);
        this.bws.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.fHU.getCount() > 0 && (item = ScreenLockActivity.this.fHU.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bhb().fIg.bhg();
            }
        });
        this.fHT = (DynamicHeightListView) findViewById(d.h.screenlock_chat_list_content);
        this.fHU = new c(getPageContext().getPageActivity());
        this.fHT.setAdapter((ListAdapter) this.fHU);
        this.fHT.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fIa, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bhb().fIm = false;
        this.fHT.setMaxHeight(this.fHW);
        this.fHT.setTranscriptMode(0);
        this.fHT.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.fHX != null && ScreenLockActivity.this.fHX.getParent() != null) {
                    if (ScreenLockActivity.this.fHT.getHeight() != ScreenLockActivity.this.fHW) {
                        ScreenLockActivity.this.fHX.setText(ScreenLockActivity.this.getResources().getString(d.l.click_load_more));
                        ScreenLockActivity.this.fHX.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.fHX.isEnabled()) {
                            ScreenLockActivity.this.fHX.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                            ScreenLockActivity.this.fHX.setEnabled(false);
                        }
                        ScreenLockActivity.this.Oh();
                    }
                }
            }
        });
    }

    private void bgY() {
        this.fHX = new TextView(getActivity());
        this.fHX.setGravity(17);
        this.fHX.setText(d.l.click_load_more);
        this.fHX.setHeight((int) getResources().getDimension(d.f.ds80));
        this.fHX.setBackgroundResource(d.g.screen_notify_item_background);
        this.fHX.setTextColor(getResources().getColorStateList(d.e.screen_notify_load_more_text_color));
        this.fHX.setTextSize(0, getResources().getDimension(d.f.fontsize32));
        this.fHX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.fHX.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                ScreenLockActivity.this.fHX.setEnabled(false);
                ScreenLockActivity.this.Oh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bha())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fHY.bhk();
            if (this.fHU != null && this.fHU.getCount() > 0 && (item = this.fHU.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bhb().fIj = 1;
        a.bhb().fIh = 0;
        List<e> bhd = a.bhb().bhd();
        e bhe = a.bhb().bhe();
        a.bhb().release();
        if ((bhd == null || bhd.isEmpty()) && bhe == null && this.fHU.getCount() == 0 && this.fHT.getHeaderViewsCount() == 0) {
            a.bhb().fIg.bhg();
            finish();
            return;
        }
        cX(bhd);
        if (bhe != null) {
            a(bhe);
        }
        if (this.fHZ != null) {
            this.fHZ.lK(this.fHU.getCount() == 0);
        }
    }

    private void cX(List<e> list) {
        if (list != null && list.size() > 0 && this.fHU != null) {
            this.fHU.cY(list);
            if (this.fHU.isHasMore() && this.fHX == null) {
                bgY();
                this.fHT.addFooterView(this.fHX);
            }
        }
    }

    private void a(e eVar) {
        if (this.fHZ == null) {
            this.fHZ = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.fHZ.a(this.fIb, this.fIc);
            this.fHZ.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fHT.addHeaderView(this.fHZ);
        }
        this.fHZ.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bhb().fIj = 0;
        a.bhb().fIh = 0;
        if (this.fHZ != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fHZ.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fIa);
        a.bhb().release();
        a.bhb().fIj = 0;
        this.fHS = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new ak("c11703").f(PbActivityConfig.KEY_MSG_ID, eVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId).ad("obj_to", eVar.url).ad(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!j.hh()) {
                showToast(getResources().getString(d.l.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                av.vH().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new ak("c10316").ad("obj_type", eVar.stat).r("obj_locate", 2));
                a.bhb().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.bhb().d(eVar);
                a.bhb().fIg.bhg();
                if (!a.bhb().fIg.bhi()) {
                    a.bhb().fIg.bhh();
                }
                a.bhb().fIh = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fHV.groupId, 0L), eVar.groupName, eVar.fIA, 0, eVar.fgn ? 1 : 0)));
                a.bhb().d(eVar);
                a.bhb().fIh = 0;
                a.bhb().fIg.bhg();
                if (!a.bhb().fIg.bhi()) {
                    a.bhb().fIg.bhh();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fHV.groupId, 0L), eVar.groupName, eVar.fIA, 0, 4)));
                a.bhb().d(eVar);
                a.bhb().fIh = 0;
                a.bhb().fIg.bhg();
                if (!a.bhb().fIg.bhi()) {
                    a.bhb().fIg.bhh();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.bhb().d(eVar);
                a.bhb().fIg.bhg();
                if (!a.bhb().fIg.bhi()) {
                    a.bhb().fIg.bhh();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bhb().fIg.bhg();
            finish();
            return true;
        } else if (i == 82) {
            a.bhb().fIg.bhg();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bgZ() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(l.ad(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(l.af(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String bha() {
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
