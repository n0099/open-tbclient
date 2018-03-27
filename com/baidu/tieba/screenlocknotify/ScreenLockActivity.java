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
    private ImageView elc;
    private Window gJV;
    public c gJY;
    public e gJZ;
    private ScreenLockLoadMoreModel gKc;
    private com.baidu.tieba.screenlocknotify.a.a gKd;
    private Drawable gJW = null;
    public DynamicHeightListView gJX = null;
    private int gKa = 0;
    private TextView gKb = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gKe = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bpz().gKk.bpE();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gKf = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.gKd != null && !StringUtils.isNull(ScreenLockActivity.this.gKd.getInputMsg()) && (data = ScreenLockActivity.this.gKd.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f("msg_id", data.msgId / 100).f("task_id", data.taskId).ab("obj_to", data.url).ab(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gKd.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.GJ().fp(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gKd.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.gKE);
                    com.baidu.tbadk.coreExtra.messageCenter.a.GJ().fp(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bpz().gKk.bpE();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gJZ = ScreenLockActivity.this.gJY.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gJZ);
        }
    };
    private View.OnClickListener gKg = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gKd != null) {
                ScreenLockActivity.this.gJZ = ScreenLockActivity.this.gKd.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gJZ);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gKh = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gKb != null) {
                            ScreenLockActivity.this.gKb.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.gKb.setEnabled(true);
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
                        if (ScreenLockActivity.this.gJY != null) {
                            ScreenLockActivity.this.gJY.dm(bpH);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gJY.setHasMore(false);
                            if (ScreenLockActivity.this.gKb != null) {
                                ScreenLockActivity.this.gJX.removeFooterView(ScreenLockActivity.this.gKb);
                                ScreenLockActivity.this.gKb = null;
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
        this.gJV = getWindow();
        this.gJV.addFlags(524288);
        this.gJV.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0141d.transparent, true);
        if (l.pd()) {
            this.gJW = bpx();
            if (this.gJW != null) {
                this.gJV.setBackgroundDrawable(this.gJW);
            }
        }
        this.gKa = l.t(getPageContext().getPageActivity(), d.e.ds935) - l.t(getPageContext().getPageActivity(), d.e.ds80);
        this.gKc = new ScreenLockLoadMoreModel(this);
        registerListener(this.gKh);
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
        this.elc = (ImageView) findViewById(d.g.head_close);
        this.elc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.gJY.getCount() > 0 && (item = ScreenLockActivity.this.gJY.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bpz().gKk.bpE();
            }
        });
        this.gJX = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.gJY = new c(getPageContext().getPageActivity());
        this.gJX.setAdapter((ListAdapter) this.gJY);
        this.gJX.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gKe, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bpz().gKq = false;
        this.gJX.setMaxHeight(this.gKa);
        this.gJX.setTranscriptMode(0);
        this.gJX.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gKb != null && ScreenLockActivity.this.gKb.getParent() != null) {
                    if (ScreenLockActivity.this.gJX.getHeight() != ScreenLockActivity.this.gKa) {
                        ScreenLockActivity.this.gKb.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.gKb.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gKb.isEnabled()) {
                            ScreenLockActivity.this.gKb.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.gKb.setEnabled(false);
                        }
                        ScreenLockActivity.this.awR();
                    }
                }
            }
        });
    }

    private void bpw() {
        this.gKb = new TextView(getActivity());
        this.gKb.setGravity(17);
        this.gKb.setText(d.j.click_load_more);
        this.gKb.setHeight((int) getResources().getDimension(d.e.ds80));
        this.gKb.setBackgroundResource(d.f.screen_notify_item_background);
        this.gKb.setTextColor(getResources().getColorStateList(d.C0141d.screen_notify_load_more_text_color));
        this.gKb.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.gKb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gKb.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.gKb.setEnabled(false);
                ScreenLockActivity.this.awR();
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
    public void awR() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gKc.bpI();
            if (this.gJY != null && this.gJY.getCount() > 0 && (item = this.gJY.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bpz().gKn = 1;
        a.bpz().gKl = 0;
        List<e> bpB = a.bpz().bpB();
        e bpC = a.bpz().bpC();
        a.bpz().release();
        if ((bpB == null || bpB.isEmpty()) && bpC == null && this.gJY.getCount() == 0 && this.gJX.getHeaderViewsCount() == 0) {
            a.bpz().gKk.bpE();
            finish();
            return;
        }
        dl(bpB);
        if (bpC != null) {
            a(bpC);
        }
        if (this.gKd != null) {
            this.gKd.mj(this.gJY.getCount() == 0);
        }
    }

    private void dl(List<e> list) {
        if (list != null && list.size() > 0 && this.gJY != null) {
            this.gJY.dm(list);
            if (this.gJY.isHasMore() && this.gKb == null) {
                bpw();
                this.gJX.addFooterView(this.gKb);
            }
        }
    }

    private void a(e eVar) {
        if (this.gKd == null) {
            this.gKd = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.gKd.a(this.gKf, this.gKg);
            this.gKd.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gJX.addHeaderView(this.gKd);
        }
        this.gKd.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bpz().gKn = 0;
        a.bpz().gKl = 0;
        if (this.gKd != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gKd.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gKe);
        a.bpz().release();
        a.bpz().gKn = 0;
        this.gJW = null;
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
                a.bpz().gKk.bpE();
                if (!a.bpz().gKk.bpG()) {
                    a.bpz().gKk.bpF();
                }
                a.bpz().gKl = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gJZ.groupId, 0L), eVar.groupName, eVar.gKE, 0, eVar.gpl ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(eVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bpz().d(eVar);
                a.bpz().gKl = 0;
                a.bpz().gKk.bpE();
                if (!a.bpz().gKk.bpG()) {
                    a.bpz().gKk.bpF();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gJZ.groupId, 0L), eVar.groupName, eVar.gKE, 0, 4)));
                a.bpz().d(eVar);
                a.bpz().gKl = 0;
                a.bpz().gKk.bpE();
                if (!a.bpz().gKk.bpG()) {
                    a.bpz().gKk.bpF();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bpz().d(eVar);
                a.bpz().gKk.bpE();
                if (!a.bpz().gKk.bpG()) {
                    a.bpz().gKk.bpF();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bpz().gKk.bpE();
            finish();
            return true;
        } else if (i == 82) {
            a.bpz().gKk.bpE();
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
