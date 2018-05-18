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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.view.ScreenLockHeaderView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView dGK;
    private Window gfY;
    public c ggb;
    public e ggc;
    private ScreenLockLoadMoreModel ggf;
    private ScreenLockHeaderView ggg;
    private Drawable gfZ = null;
    public DynamicHeightListView gga = null;
    private int ggd = 0;
    private TextView gge = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver ggh = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bkF().ggn.bkK();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener ggi = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e data;
            if (ScreenLockActivity.this.ggg != null && !StringUtils.isNull(ScreenLockActivity.this.ggg.getInputMsg()) && (data = ScreenLockActivity.this.ggg.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new al("c11703").f("msg_id", data.msgId / 100).f("task_id", data.taskId).ac("obj_to", data.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.ggg.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.zw().fh(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.ggg.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.ggH);
                    com.baidu.tbadk.coreExtra.messageCenter.a.zw().fh(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bkF().ggn.bkK();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            ScreenLockActivity.this.ggc = ScreenLockActivity.this.ggb.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.ggc);
        }
    };
    private View.OnClickListener ggj = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (ScreenLockActivity.this.ggg != null) {
                ScreenLockActivity.this.ggc = ScreenLockActivity.this.ggg.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.ggc);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ggk = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.k.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gge != null) {
                            ScreenLockActivity.this.gge.setText(ScreenLockActivity.this.getResources().getString(d.k.data_load_error));
                            ScreenLockActivity.this.gge.setEnabled(true);
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
                        ArrayList<e> bkN = data.bkN();
                        if (ScreenLockActivity.this.ggb != null) {
                            ScreenLockActivity.this.ggb.dh(bkN);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.ggb.setHasMore(false);
                            if (ScreenLockActivity.this.gge != null) {
                                ScreenLockActivity.this.gga.removeFooterView(ScreenLockActivity.this.gge);
                                ScreenLockActivity.this.gge = null;
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
        this.gfY = getWindow();
        this.gfY.addFlags(524288);
        this.gfY.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.i.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0126d.transparent, true);
        if (l.hj()) {
            this.gfZ = bkD();
            if (this.gfZ != null) {
                this.gfY.setBackgroundDrawable(this.gfZ);
            }
        }
        this.ggd = l.e(getPageContext().getPageActivity(), d.e.ds935) - l.e(getPageContext().getPageActivity(), d.e.ds80);
        this.ggf = new ScreenLockLoadMoreModel(this);
        registerListener(this.ggk);
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
        this.dGK = (ImageView) findViewById(d.g.head_close);
        this.dGK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e item;
                if (ScreenLockActivity.this.ggb.getCount() > 0 && (item = ScreenLockActivity.this.ggb.getItem(0)) != null) {
                    TiebaStatic.log(new al("c11704").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bkF().ggn.bkK();
            }
        });
        this.gga = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.ggb = new c(getPageContext().getPageActivity());
        this.gga.setAdapter((ListAdapter) this.ggb);
        this.gga.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.ggh, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bkF().ggt = false;
        this.gga.setMaxHeight(this.ggd);
        this.gga.setTranscriptMode(0);
        this.gga.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gge != null && ScreenLockActivity.this.gge.getParent() != null) {
                    if (ScreenLockActivity.this.gga.getHeight() != ScreenLockActivity.this.ggd) {
                        ScreenLockActivity.this.gge.setText(ScreenLockActivity.this.getResources().getString(d.k.click_load_more));
                        ScreenLockActivity.this.gge.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gge.isEnabled()) {
                            ScreenLockActivity.this.gge.setText(ScreenLockActivity.this.getResources().getString(d.k.loading));
                            ScreenLockActivity.this.gge.setEnabled(false);
                        }
                        ScreenLockActivity.this.arg();
                    }
                }
            }
        });
    }

    private void bkC() {
        this.gge = new TextView(getActivity());
        this.gge.setGravity(17);
        this.gge.setText(d.k.click_load_more);
        this.gge.setHeight((int) getResources().getDimension(d.e.ds80));
        this.gge.setBackgroundResource(d.f.screen_notify_item_background);
        this.gge.setTextColor(getResources().getColorStateList(d.C0126d.screen_notify_load_more_text_color));
        this.gge.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.gge.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ScreenLockActivity.this.gge.setText(ScreenLockActivity.this.getResources().getString(d.k.loading));
                ScreenLockActivity.this.gge.setEnabled(false);
                ScreenLockActivity.this.arg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bkE())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arg() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.ggf.bkO();
            if (this.ggb != null && this.ggb.getCount() > 0 && (item = this.ggb.getItem(0)) != null) {
                TiebaStatic.log(new al("c11738").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bkF().ggq = 1;
        a.bkF().ggo = 0;
        List<e> bkH = a.bkF().bkH();
        e bkI = a.bkF().bkI();
        a.bkF().release();
        if ((bkH == null || bkH.isEmpty()) && bkI == null && this.ggb.getCount() == 0 && this.gga.getHeaderViewsCount() == 0) {
            a.bkF().ggn.bkK();
            finish();
            return;
        }
        dg(bkH);
        if (bkI != null) {
            a(bkI);
        }
        if (this.ggg != null) {
            this.ggg.lL(this.ggb.getCount() == 0);
        }
    }

    private void dg(List<e> list) {
        if (list != null && list.size() > 0 && this.ggb != null) {
            this.ggb.dh(list);
            if (this.ggb.isHasMore() && this.gge == null) {
                bkC();
                this.gga.addFooterView(this.gge);
            }
        }
    }

    private void a(e eVar) {
        if (this.ggg == null) {
            this.ggg = new ScreenLockHeaderView(getActivity());
            this.ggg.setUIClickListener(this.ggi, this.ggj);
            this.ggg.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gga.addHeaderView(this.ggg);
        }
        this.ggg.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bkF().ggq = 0;
        a.bkF().ggo = 0;
        if (this.ggg != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.ggg.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.ggh);
        a.bkF().release();
        a.bkF().ggq = 0;
        this.gfZ = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new al("c11703").f("msg_id", eVar.msgId / 100).f("task_id", eVar.taskId).ac("obj_to", eVar.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!j.gP()) {
                showToast(getResources().getString(d.k.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                ax.wf().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new al("c10316").ac("obj_type", eVar.stat).r("obj_locate", 2));
                a.bkF().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(eVar.groupId, 0L), eVar.groupName, 0L, "from_lock")));
                a.bkF().d(eVar);
                a.bkF().ggn.bkK();
                if (!a.bkF().ggn.bkM()) {
                    a.bkF().ggn.bkL();
                }
                a.bkF().ggo = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.ggc.groupId, 0L), eVar.groupName, eVar.ggH, 0, eVar.fKQ ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(eVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bkF().d(eVar);
                a.bkF().ggo = 0;
                a.bkF().ggn.bkK();
                if (!a.bkF().ggn.bkM()) {
                    a.bkF().ggn.bkL();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.ggc.groupId, 0L), eVar.groupName, eVar.ggH, 0, 4)));
                a.bkF().d(eVar);
                a.bkF().ggo = 0;
                a.bkF().ggn.bkK();
                if (!a.bkF().ggn.bkM()) {
                    a.bkF().ggn.bkL();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bkF().d(eVar);
                a.bkF().ggn.bkK();
                if (!a.bkF().ggn.bkM()) {
                    a.bkF().ggn.bkL();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bkF().ggn.bkK();
            finish();
            return true;
        } else if (i == 82) {
            a.bkF().ggn.bkK();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bkD() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(l.af(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(l.ah(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String bkE() {
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
