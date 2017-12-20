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
    private ImageView dsQ;
    private Window gdG;
    public c gdJ;
    public e gdK;
    private ScreenLockLoadMoreModel gdN;
    private com.baidu.tieba.screenlocknotify.a.a gdO;
    private Drawable gdH = null;
    public DynamicHeightListView gdI = null;
    private int gdL = 0;
    private TextView gdM = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gdP = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bmZ().gdV.bne();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gdQ = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.gdO != null && !StringUtils.isNull(ScreenLockActivity.this.gdO.getInputMsg()) && (data = ScreenLockActivity.this.gdO.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f("msg_id", data.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId).ac("obj_to", data.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gdO.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().eP(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gdO.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.geq);
                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().eP(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bmZ().gdV.bne();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gdK = ScreenLockActivity.this.gdJ.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gdK);
        }
    };
    private View.OnClickListener gdR = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gdO != null) {
                ScreenLockActivity.this.gdK = ScreenLockActivity.this.gdO.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gdK);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gdS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gdM != null) {
                            ScreenLockActivity.this.gdM.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.gdM.setEnabled(true);
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
                        ArrayList<e> bnh = data.bnh();
                        if (ScreenLockActivity.this.gdJ != null) {
                            ScreenLockActivity.this.gdJ.dm(bnh);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gdJ.setHasMore(false);
                            if (ScreenLockActivity.this.gdM != null) {
                                ScreenLockActivity.this.gdI.removeFooterView(ScreenLockActivity.this.gdM);
                                ScreenLockActivity.this.gdM = null;
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
        this.gdG = getWindow();
        this.gdG.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.gdG.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0096d.transparent, true);
        if (l.hB()) {
            this.gdH = bmX();
            if (this.gdH != null) {
                this.gdG.setBackgroundDrawable(this.gdH);
            }
        }
        this.gdL = l.f(getPageContext().getPageActivity(), d.e.ds935) - l.f(getPageContext().getPageActivity(), d.e.ds80);
        this.gdN = new ScreenLockLoadMoreModel(this);
        registerListener(this.gdS);
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
        this.dsQ = (ImageView) findViewById(d.g.head_close);
        this.dsQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.gdJ.getCount() > 0 && (item = ScreenLockActivity.this.gdJ.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f("msg_id", item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bmZ().gdV.bne();
            }
        });
        this.gdI = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.gdJ = new c(getPageContext().getPageActivity());
        this.gdI.setAdapter((ListAdapter) this.gdJ);
        this.gdI.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gdP, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bmZ().geb = false;
        this.gdI.setMaxHeight(this.gdL);
        this.gdI.setTranscriptMode(0);
        this.gdI.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gdM != null && ScreenLockActivity.this.gdM.getParent() != null) {
                    if (ScreenLockActivity.this.gdI.getHeight() != ScreenLockActivity.this.gdL) {
                        ScreenLockActivity.this.gdM.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.gdM.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gdM.isEnabled()) {
                            ScreenLockActivity.this.gdM.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.gdM.setEnabled(false);
                        }
                        ScreenLockActivity.this.PF();
                    }
                }
            }
        });
    }

    private void bmW() {
        this.gdM = new TextView(getActivity());
        this.gdM.setGravity(17);
        this.gdM.setText(d.j.click_load_more);
        this.gdM.setHeight((int) getResources().getDimension(d.e.ds80));
        this.gdM.setBackgroundResource(d.f.screen_notify_item_background);
        this.gdM.setTextColor(getResources().getColorStateList(d.C0096d.screen_notify_load_more_text_color));
        this.gdM.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.gdM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gdM.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.gdM.setEnabled(false);
                ScreenLockActivity.this.PF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bmY())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gdN.bni();
            if (this.gdJ != null && this.gdJ.getCount() > 0 && (item = this.gdJ.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f("msg_id", item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bmZ().gdY = 1;
        a.bmZ().gdW = 0;
        List<e> bnb = a.bmZ().bnb();
        e bnc = a.bmZ().bnc();
        a.bmZ().release();
        if ((bnb == null || bnb.isEmpty()) && bnc == null && this.gdJ.getCount() == 0 && this.gdI.getHeaderViewsCount() == 0) {
            a.bmZ().gdV.bne();
            finish();
            return;
        }
        dl(bnb);
        if (bnc != null) {
            a(bnc);
        }
        if (this.gdO != null) {
            this.gdO.mn(this.gdJ.getCount() == 0);
        }
    }

    private void dl(List<e> list) {
        if (list != null && list.size() > 0 && this.gdJ != null) {
            this.gdJ.dm(list);
            if (this.gdJ.isHasMore() && this.gdM == null) {
                bmW();
                this.gdI.addFooterView(this.gdM);
            }
        }
    }

    private void a(e eVar) {
        if (this.gdO == null) {
            this.gdO = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.gdO.a(this.gdQ, this.gdR);
            this.gdO.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gdI.addHeaderView(this.gdO);
        }
        this.gdO.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bmZ().gdY = 0;
        a.bmZ().gdW = 0;
        if (this.gdO != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gdO.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gdP);
        a.bmZ().release();
        a.bmZ().gdY = 0;
        this.gdH = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new ak("c11703").f("msg_id", eVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId).ac("obj_to", eVar.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!j.hh()) {
                showToast(getResources().getString(d.j.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                av.vI().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new ak("c10316").ac("obj_type", eVar.stat).r("obj_locate", 2));
                a.bmZ().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.bmZ().d(eVar);
                a.bmZ().gdV.bne();
                if (!a.bmZ().gdV.bng()) {
                    a.bmZ().gdV.bnf();
                }
                a.bmZ().gdW = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gdK.groupId, 0L), eVar.groupName, eVar.geq, 0, eVar.fyy ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(eVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.bmZ().d(eVar);
                a.bmZ().gdW = 0;
                a.bmZ().gdV.bne();
                if (!a.bmZ().gdV.bng()) {
                    a.bmZ().gdV.bnf();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gdK.groupId, 0L), eVar.groupName, eVar.geq, 0, 4)));
                a.bmZ().d(eVar);
                a.bmZ().gdW = 0;
                a.bmZ().gdV.bne();
                if (!a.bmZ().gdV.bng()) {
                    a.bmZ().gdV.bnf();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.bmZ().d(eVar);
                a.bmZ().gdV.bne();
                if (!a.bmZ().gdV.bng()) {
                    a.bmZ().gdV.bnf();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bmZ().gdV.bne();
            finish();
            return true;
        } else if (i == 82) {
            a.bmZ().gdV.bne();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bmX() {
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

    public String bmY() {
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
