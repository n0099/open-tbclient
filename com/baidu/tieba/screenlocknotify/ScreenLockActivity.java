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
    private Window fHS;
    public c fHV;
    public e fHW;
    private ScreenLockLoadMoreModel fHZ;
    private com.baidu.tieba.screenlocknotify.a.a fIa;
    private Drawable fHT = null;
    public DynamicHeightListView fHU = null;
    private int fHX = 0;
    private TextView fHY = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fIb = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bhc().fIh.bhh();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener fIc = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.fIa != null && !StringUtils.isNull(ScreenLockActivity.this.fIa.getInputMsg()) && (data = ScreenLockActivity.this.fIa.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f(PbActivityConfig.KEY_MSG_ID, data.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId).ad("obj_to", data.url).ad(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.fIa.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.yB().eE(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.fIa.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.fIB);
                    com.baidu.tbadk.coreExtra.messageCenter.a.yB().eE(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bhc().fIh.bhh();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.fHW = ScreenLockActivity.this.fHV.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.fHW);
        }
    };
    private View.OnClickListener fId = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.fIa != null) {
                ScreenLockActivity.this.fHW = ScreenLockActivity.this.fIa.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.fHW);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fIe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.l.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.fHY != null) {
                            ScreenLockActivity.this.fHY.setText(ScreenLockActivity.this.getResources().getString(d.l.data_load_error));
                            ScreenLockActivity.this.fHY.setEnabled(true);
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
                        ArrayList<e> bhk = data.bhk();
                        if (ScreenLockActivity.this.fHV != null) {
                            ScreenLockActivity.this.fHV.cY(bhk);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.fHV.setHasMore(false);
                            if (ScreenLockActivity.this.fHY != null) {
                                ScreenLockActivity.this.fHU.removeFooterView(ScreenLockActivity.this.fHY);
                                ScreenLockActivity.this.fHY = null;
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
        this.fHS = getWindow();
        this.fHS.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fHS.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.transparent, true);
        if (l.hB()) {
            this.fHT = bha();
            if (this.fHT != null) {
                this.fHS.setBackgroundDrawable(this.fHT);
            }
        }
        this.fHX = l.f(getPageContext().getPageActivity(), d.f.ds935) - l.f(getPageContext().getPageActivity(), d.f.ds80);
        this.fHZ = new ScreenLockLoadMoreModel(this);
        registerListener(this.fIe);
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
                if (ScreenLockActivity.this.fHV.getCount() > 0 && (item = ScreenLockActivity.this.fHV.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bhc().fIh.bhh();
            }
        });
        this.fHU = (DynamicHeightListView) findViewById(d.h.screenlock_chat_list_content);
        this.fHV = new c(getPageContext().getPageActivity());
        this.fHU.setAdapter((ListAdapter) this.fHV);
        this.fHU.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fIb, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bhc().fIn = false;
        this.fHU.setMaxHeight(this.fHX);
        this.fHU.setTranscriptMode(0);
        this.fHU.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.fHY != null && ScreenLockActivity.this.fHY.getParent() != null) {
                    if (ScreenLockActivity.this.fHU.getHeight() != ScreenLockActivity.this.fHX) {
                        ScreenLockActivity.this.fHY.setText(ScreenLockActivity.this.getResources().getString(d.l.click_load_more));
                        ScreenLockActivity.this.fHY.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.fHY.isEnabled()) {
                            ScreenLockActivity.this.fHY.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                            ScreenLockActivity.this.fHY.setEnabled(false);
                        }
                        ScreenLockActivity.this.Oh();
                    }
                }
            }
        });
    }

    private void bgZ() {
        this.fHY = new TextView(getActivity());
        this.fHY.setGravity(17);
        this.fHY.setText(d.l.click_load_more);
        this.fHY.setHeight((int) getResources().getDimension(d.f.ds80));
        this.fHY.setBackgroundResource(d.g.screen_notify_item_background);
        this.fHY.setTextColor(getResources().getColorStateList(d.e.screen_notify_load_more_text_color));
        this.fHY.setTextSize(0, getResources().getDimension(d.f.fontsize32));
        this.fHY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.fHY.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                ScreenLockActivity.this.fHY.setEnabled(false);
                ScreenLockActivity.this.Oh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bhb())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fHZ.bhl();
            if (this.fHV != null && this.fHV.getCount() > 0 && (item = this.fHV.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bhc().fIk = 1;
        a.bhc().fIi = 0;
        List<e> bhe = a.bhc().bhe();
        e bhf = a.bhc().bhf();
        a.bhc().release();
        if ((bhe == null || bhe.isEmpty()) && bhf == null && this.fHV.getCount() == 0 && this.fHU.getHeaderViewsCount() == 0) {
            a.bhc().fIh.bhh();
            finish();
            return;
        }
        cX(bhe);
        if (bhf != null) {
            a(bhf);
        }
        if (this.fIa != null) {
            this.fIa.lK(this.fHV.getCount() == 0);
        }
    }

    private void cX(List<e> list) {
        if (list != null && list.size() > 0 && this.fHV != null) {
            this.fHV.cY(list);
            if (this.fHV.isHasMore() && this.fHY == null) {
                bgZ();
                this.fHU.addFooterView(this.fHY);
            }
        }
    }

    private void a(e eVar) {
        if (this.fIa == null) {
            this.fIa = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.fIa.a(this.fIc, this.fId);
            this.fIa.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fHU.addHeaderView(this.fIa);
        }
        this.fIa.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bhc().fIk = 0;
        a.bhc().fIi = 0;
        if (this.fIa != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fIa.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fIb);
        a.bhc().release();
        a.bhc().fIk = 0;
        this.fHT = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new ak("c11703").f(PbActivityConfig.KEY_MSG_ID, eVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId).ad("obj_to", eVar.url).ad(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!j.hh()) {
                showToast(getResources().getString(d.l.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                av.vH().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new ak("c10316").ad("obj_type", eVar.stat).r("obj_locate", 2));
                a.bhc().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.bhc().d(eVar);
                a.bhc().fIh.bhh();
                if (!a.bhc().fIh.bhj()) {
                    a.bhc().fIh.bhi();
                }
                a.bhc().fIi = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fHW.groupId, 0L), eVar.groupName, eVar.fIB, 0, eVar.fgo ? 1 : 0)));
                a.bhc().d(eVar);
                a.bhc().fIi = 0;
                a.bhc().fIh.bhh();
                if (!a.bhc().fIh.bhj()) {
                    a.bhc().fIh.bhi();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fHW.groupId, 0L), eVar.groupName, eVar.fIB, 0, 4)));
                a.bhc().d(eVar);
                a.bhc().fIi = 0;
                a.bhc().fIh.bhh();
                if (!a.bhc().fIh.bhj()) {
                    a.bhc().fIh.bhi();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.bhc().d(eVar);
                a.bhc().fIh.bhh();
                if (!a.bhc().fIh.bhj()) {
                    a.bhc().fIh.bhi();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bhc().fIh.bhh();
            finish();
            return true;
        } else if (i == 82) {
            a.bhc().fIh.bhh();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bha() {
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

    public String bhb() {
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
