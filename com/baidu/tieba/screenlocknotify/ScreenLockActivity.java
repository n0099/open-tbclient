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
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView ekY;
    private Window gJU;
    public c gJX;
    public e gJY;
    private ScreenLockLoadMoreModel gKb;
    private com.baidu.tieba.screenlocknotify.a.a gKc;
    private Drawable gJV = null;
    public DynamicHeightListView gJW = null;
    private int gJZ = 0;
    private TextView gKa = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gKd = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bpz().gKj.bpE();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gKe = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.gKc != null && !StringUtils.isNull(ScreenLockActivity.this.gKc.getInputMsg()) && (data = ScreenLockActivity.this.gKc.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f("msg_id", data.msgId / 100).f("task_id", data.taskId).ab("obj_to", data.url).ab(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gKc.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.GJ().fp(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gKc.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.gKD);
                    com.baidu.tbadk.coreExtra.messageCenter.a.GJ().fp(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bpz().gKj.bpE();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gJY = ScreenLockActivity.this.gJX.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gJY);
        }
    };
    private View.OnClickListener gKf = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gKc != null) {
                ScreenLockActivity.this.gJY = ScreenLockActivity.this.gKc.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gJY);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gKg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gKa != null) {
                            ScreenLockActivity.this.gKa.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.gKa.setEnabled(true);
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
                        ArrayList<e> bpH = data.bpH();
                        if (ScreenLockActivity.this.gJX != null) {
                            ScreenLockActivity.this.gJX.dm(bpH);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gJX.setHasMore(false);
                            if (ScreenLockActivity.this.gKa != null) {
                                ScreenLockActivity.this.gJW.removeFooterView(ScreenLockActivity.this.gKa);
                                ScreenLockActivity.this.gKa = null;
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
        this.gJU = getWindow();
        this.gJU.addFlags(524288);
        this.gJU.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0140d.transparent, true);
        if (l.pd()) {
            this.gJV = bpx();
            if (this.gJV != null) {
                this.gJU.setBackgroundDrawable(this.gJV);
            }
        }
        this.gJZ = l.t(getPageContext().getPageActivity(), d.e.ds935) - l.t(getPageContext().getPageActivity(), d.e.ds80);
        this.gKb = new ScreenLockLoadMoreModel(this);
        registerListener(this.gKg);
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
        this.ekY = (ImageView) findViewById(d.g.head_close);
        this.ekY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.gJX.getCount() > 0 && (item = ScreenLockActivity.this.gJX.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bpz().gKj.bpE();
            }
        });
        this.gJW = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.gJX = new c(getPageContext().getPageActivity());
        this.gJW.setAdapter((ListAdapter) this.gJX);
        this.gJW.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gKd, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bpz().gKp = false;
        this.gJW.setMaxHeight(this.gJZ);
        this.gJW.setTranscriptMode(0);
        this.gJW.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gKa != null && ScreenLockActivity.this.gKa.getParent() != null) {
                    if (ScreenLockActivity.this.gJW.getHeight() != ScreenLockActivity.this.gJZ) {
                        ScreenLockActivity.this.gKa.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.gKa.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gKa.isEnabled()) {
                            ScreenLockActivity.this.gKa.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.gKa.setEnabled(false);
                        }
                        ScreenLockActivity.this.awQ();
                    }
                }
            }
        });
    }

    private void bpw() {
        this.gKa = new TextView(getActivity());
        this.gKa.setGravity(17);
        this.gKa.setText(d.j.click_load_more);
        this.gKa.setHeight((int) getResources().getDimension(d.e.ds80));
        this.gKa.setBackgroundResource(d.f.screen_notify_item_background);
        this.gKa.setTextColor(getResources().getColorStateList(d.C0140d.screen_notify_load_more_text_color));
        this.gKa.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.gKa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gKa.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.gKa.setEnabled(false);
                ScreenLockActivity.this.awQ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bpy())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awQ() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gKb.bpI();
            if (this.gJX != null && this.gJX.getCount() > 0 && (item = this.gJX.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bpz().gKm = 1;
        a.bpz().gKk = 0;
        List<e> bpB = a.bpz().bpB();
        e bpC = a.bpz().bpC();
        a.bpz().release();
        if ((bpB == null || bpB.isEmpty()) && bpC == null && this.gJX.getCount() == 0 && this.gJW.getHeaderViewsCount() == 0) {
            a.bpz().gKj.bpE();
            finish();
            return;
        }
        dl(bpB);
        if (bpC != null) {
            a(bpC);
        }
        if (this.gKc != null) {
            this.gKc.me(this.gJX.getCount() == 0);
        }
    }

    private void dl(List<e> list) {
        if (list != null && list.size() > 0 && this.gJX != null) {
            this.gJX.dm(list);
            if (this.gJX.isHasMore() && this.gKa == null) {
                bpw();
                this.gJW.addFooterView(this.gKa);
            }
        }
    }

    private void a(e eVar) {
        if (this.gKc == null) {
            this.gKc = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.gKc.a(this.gKe, this.gKf);
            this.gKc.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gJW.addHeaderView(this.gKc);
        }
        this.gKc.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bpz().gKm = 0;
        a.bpz().gKk = 0;
        if (this.gKc != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gKc.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gKd);
        a.bpz().release();
        a.bpz().gKm = 0;
        this.gJV = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new ak("c11703").f("msg_id", eVar.msgId / 100).f("task_id", eVar.taskId).ab("obj_to", eVar.url).ab(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!j.oJ()) {
                showToast(getResources().getString(d.j.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                aw.Du().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new ak("c10316").ab("obj_type", eVar.stat).s("obj_locate", 2));
                a.bpz().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.bpz().d(eVar);
                a.bpz().gKj.bpE();
                if (!a.bpz().gKj.bpG()) {
                    a.bpz().gKj.bpF();
                }
                a.bpz().gKk = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gJY.groupId, 0L), eVar.groupName, eVar.gKD, 0, eVar.gpg ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(eVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bpz().d(eVar);
                a.bpz().gKk = 0;
                a.bpz().gKj.bpE();
                if (!a.bpz().gKj.bpG()) {
                    a.bpz().gKj.bpF();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gJY.groupId, 0L), eVar.groupName, eVar.gKD, 0, 4)));
                a.bpz().d(eVar);
                a.bpz().gKk = 0;
                a.bpz().gKj.bpE();
                if (!a.bpz().gKj.bpG()) {
                    a.bpz().gKj.bpF();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bpz().d(eVar);
                a.bpz().gKj.bpE();
                if (!a.bpz().gKj.bpG()) {
                    a.bpz().gKj.bpF();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bpz().gKj.bpE();
            finish();
            return true;
        } else if (i == 82) {
            a.bpz().gKj.bpE();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bpx() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(l.ao(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(l.aq(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String bpy() {
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
