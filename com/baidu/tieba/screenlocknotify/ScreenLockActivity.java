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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.view.ScreenLockHeaderView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView dSa;
    private ScreenLockHeaderView grA;
    private Window grs;
    public c grv;
    public e grw;
    private ScreenLockLoadMoreModel grz;
    private Drawable grt = null;
    public DynamicHeightListView gru = null;
    private int grx = 0;
    private TextView gry = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver grB = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bpD().grH.bpI();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener grC = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.grA != null && !StringUtils.isNull(ScreenLockActivity.this.grA.getInputMsg()) && (data = ScreenLockActivity.this.grA.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new am("c11703").f("msg_id", data.msgId / 100).f("task_id", data.taskId).ah("obj_to", data.url).ah("app_version", TbConfig.getVersion()).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.grA.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.CX().fE(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.grA.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.nameShow, data.gsb);
                    com.baidu.tbadk.coreExtra.messageCenter.a.CX().fE(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ah("lockscreen_reply", true).start();
                a.bpD().grH.bpI();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.grw = ScreenLockActivity.this.grv.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.grw);
        }
    };
    private View.OnClickListener grD = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.grA != null) {
                ScreenLockActivity.this.grw = ScreenLockActivity.this.grA.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.grw);
            }
        }
    };
    private com.baidu.adp.framework.listener.a grE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.k.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gry != null) {
                            ScreenLockActivity.this.gry.setText(ScreenLockActivity.this.getResources().getString(d.k.data_load_error));
                            ScreenLockActivity.this.gry.setEnabled(true);
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
                        ArrayList<e> bpL = data.bpL();
                        if (ScreenLockActivity.this.grv != null) {
                            ScreenLockActivity.this.grv.dm(bpL);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.grv.setHasMore(false);
                            if (ScreenLockActivity.this.gry != null) {
                                ScreenLockActivity.this.gru.removeFooterView(ScreenLockActivity.this.gry);
                                ScreenLockActivity.this.gry = null;
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
        this.grs = getWindow();
        this.grs.addFlags(524288);
        this.grs.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.i.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0141d.transparent, true);
        if (l.jX()) {
            this.grt = bpB();
            if (this.grt != null) {
                this.grs.setBackgroundDrawable(this.grt);
            }
        }
        this.grx = l.e(getPageContext().getPageActivity(), d.e.ds935) - l.e(getPageContext().getPageActivity(), d.e.ds80);
        this.grz = new ScreenLockLoadMoreModel(this);
        registerListener(this.grE);
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
        this.dSa = (ImageView) findViewById(d.g.head_close);
        this.dSa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.grv.getCount() > 0 && (item = ScreenLockActivity.this.grv.getItem(0)) != null) {
                    TiebaStatic.log(new am("c11704").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bpD().grH.bpI();
            }
        });
        this.gru = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.grv = new c(getPageContext().getPageActivity());
        this.gru.setAdapter((ListAdapter) this.grv);
        this.gru.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.grB, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bpD().grN = false;
        this.gru.setMaxHeight(this.grx);
        this.gru.setTranscriptMode(0);
        this.gru.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gry != null && ScreenLockActivity.this.gry.getParent() != null) {
                    if (ScreenLockActivity.this.gru.getHeight() != ScreenLockActivity.this.grx) {
                        ScreenLockActivity.this.gry.setText(ScreenLockActivity.this.getResources().getString(d.k.click_load_more));
                        ScreenLockActivity.this.gry.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gry.isEnabled()) {
                            ScreenLockActivity.this.gry.setText(ScreenLockActivity.this.getResources().getString(d.k.loading));
                            ScreenLockActivity.this.gry.setEnabled(false);
                        }
                        ScreenLockActivity.this.avl();
                    }
                }
            }
        });
    }

    private void bpA() {
        this.gry = new TextView(getActivity());
        this.gry.setGravity(17);
        this.gry.setText(d.k.click_load_more);
        this.gry.setHeight((int) getResources().getDimension(d.e.ds80));
        this.gry.setBackgroundResource(d.f.screen_notify_item_background);
        this.gry.setTextColor(getResources().getColorStateList(d.C0141d.screen_notify_load_more_text_color));
        this.gry.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.gry.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gry.setText(ScreenLockActivity.this.getResources().getString(d.k.loading));
                ScreenLockActivity.this.gry.setEnabled(false);
                ScreenLockActivity.this.avl();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bpC())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avl() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.grz.bpM();
            if (this.grv != null && this.grv.getCount() > 0 && (item = this.grv.getItem(0)) != null) {
                TiebaStatic.log(new am("c11738").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bpD().grK = 1;
        a.bpD().grI = 0;
        List<e> bpF = a.bpD().bpF();
        e bpG = a.bpD().bpG();
        a.bpD().release();
        if ((bpF == null || bpF.isEmpty()) && bpG == null && this.grv.getCount() == 0 && this.gru.getHeaderViewsCount() == 0) {
            a.bpD().grH.bpI();
            finish();
            return;
        }
        dl(bpF);
        if (bpG != null) {
            a(bpG);
        }
        if (this.grA != null) {
            this.grA.lR(this.grv.getCount() == 0);
        }
    }

    private void dl(List<e> list) {
        if (list != null && list.size() > 0 && this.grv != null) {
            this.grv.dm(list);
            if (this.grv.isHasMore() && this.gry == null) {
                bpA();
                this.gru.addFooterView(this.gry);
            }
        }
    }

    private void a(e eVar) {
        if (this.grA == null) {
            this.grA = new ScreenLockHeaderView(getActivity());
            this.grA.setUIClickListener(this.grC, this.grD);
            this.grA.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gru.addHeaderView(this.grA);
        }
        this.grA.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bpD().grK = 0;
        a.bpD().grI = 0;
        if (this.grA != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.grA.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.grB);
        a.bpD().release();
        a.bpD().grK = 0;
        this.grt = null;
    }

    public void b(e eVar) {
        int i;
        if (eVar != null) {
            switch (eVar.customGroupType) {
                case 1:
                case 2:
                    i = 3;
                    break;
                case 3:
                default:
                    i = 0;
                    break;
                case 4:
                    i = 2;
                    break;
                case 5:
                    i = 1;
                    break;
            }
            TiebaStatic.log(new am("c11703").f("msg_id", eVar.msgId / 100).f("task_id", eVar.taskId).ah("obj_to", eVar.url).ah("app_version", TbConfig.getVersion()).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
            if (!j.jD()) {
                showToast(getResources().getString(d.k.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                ay.zG().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new am("c10316").ah("obj_type", eVar.stat).r("obj_locate", 2));
                a.bpD().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(eVar.groupId, 0L), eVar.groupName, 0L, "from_lock")));
                a.bpD().d(eVar);
                a.bpD().grH.bpI();
                if (!a.bpD().grH.bpK()) {
                    a.bpD().grH.bpJ();
                }
                a.bpD().grI = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.grw.groupId, 0L), eVar.groupName, eVar.nameShow, eVar.gsb, 0, eVar.fWc ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(eVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bpD().d(eVar);
                a.bpD().grI = 0;
                a.bpD().grH.bpI();
                if (!a.bpD().grH.bpK()) {
                    a.bpD().grH.bpJ();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.grw.groupId, 0L), eVar.groupName, eVar.gsb, 0, 4)));
                a.bpD().d(eVar);
                a.bpD().grI = 0;
                a.bpD().grH.bpI();
                if (!a.bpD().grH.bpK()) {
                    a.bpD().grH.bpJ();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bpD().d(eVar);
                a.bpD().grH.bpI();
                if (!a.bpD().grH.bpK()) {
                    a.bpD().grH.bpJ();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bpD().grH.bpI();
            finish();
            return true;
        } else if (i == 82) {
            a.bpD().grH.bpI();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bpB() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(l.ah(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(l.aj(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String bpC() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) TbadkApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(5);
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
