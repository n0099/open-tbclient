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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
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
    private ImageView dVU;
    private Window gvj;
    public c gvm;
    public e gvn;
    private ScreenLockLoadMoreModel gvq;
    private ScreenLockHeaderView gvr;
    private Drawable gvk = null;
    public DynamicHeightListView gvl = null;
    private int gvo = 0;
    private TextView gvp = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gvs = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bqe().gvy.bqj();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gvt = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.gvr != null && !StringUtils.isNull(ScreenLockActivity.this.gvr.getInputMsg()) && (data = ScreenLockActivity.this.gvr.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an("c11703").f("msg_id", data.msgId / 100).f("task_id", data.taskId).ah("obj_to", data.url).ah("app_version", TbConfig.getVersion()).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gvr.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dp().fI(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gvr.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.nameShow, data.gvS);
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dp().fI(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ah("lockscreen_reply", true).start();
                a.bqe().gvy.bqj();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gvn = ScreenLockActivity.this.gvm.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gvn);
        }
    };
    private View.OnClickListener gvu = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gvr != null) {
                ScreenLockActivity.this.gvn = ScreenLockActivity.this.gvr.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gvn);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gvv = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.k.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gvp != null) {
                            ScreenLockActivity.this.gvp.setText(ScreenLockActivity.this.getResources().getString(d.k.data_load_error));
                            ScreenLockActivity.this.gvp.setEnabled(true);
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
                        ArrayList<e> bqm = data.bqm();
                        if (ScreenLockActivity.this.gvm != null) {
                            ScreenLockActivity.this.gvm.dq(bqm);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gvm.setHasMore(false);
                            if (ScreenLockActivity.this.gvp != null) {
                                ScreenLockActivity.this.gvl.removeFooterView(ScreenLockActivity.this.gvp);
                                ScreenLockActivity.this.gvp = null;
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
        this.gvj = getWindow();
        this.gvj.addFlags(524288);
        this.gvj.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.i.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0142d.transparent, true);
        if (l.jX()) {
            this.gvk = bqc();
            if (this.gvk != null) {
                this.gvj.setBackgroundDrawable(this.gvk);
            }
        }
        this.gvo = l.e(getPageContext().getPageActivity(), d.e.ds935) - l.e(getPageContext().getPageActivity(), d.e.ds80);
        this.gvq = new ScreenLockLoadMoreModel(this);
        registerListener(this.gvv);
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
        this.dVU = (ImageView) findViewById(d.g.head_close);
        this.dVU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.gvm.getCount() > 0 && (item = ScreenLockActivity.this.gvm.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bqe().gvy.bqj();
            }
        });
        this.gvl = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.gvm = new c(getPageContext().getPageActivity());
        this.gvl.setAdapter((ListAdapter) this.gvm);
        this.gvl.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gvs, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bqe().gvE = false;
        this.gvl.setMaxHeight(this.gvo);
        this.gvl.setTranscriptMode(0);
        this.gvl.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gvp != null && ScreenLockActivity.this.gvp.getParent() != null) {
                    if (ScreenLockActivity.this.gvl.getHeight() != ScreenLockActivity.this.gvo) {
                        ScreenLockActivity.this.gvp.setText(ScreenLockActivity.this.getResources().getString(d.k.click_load_more));
                        ScreenLockActivity.this.gvp.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gvp.isEnabled()) {
                            ScreenLockActivity.this.gvp.setText(ScreenLockActivity.this.getResources().getString(d.k.loading));
                            ScreenLockActivity.this.gvp.setEnabled(false);
                        }
                        ScreenLockActivity.this.avO();
                    }
                }
            }
        });
    }

    private void bqb() {
        this.gvp = new TextView(getActivity());
        this.gvp.setGravity(17);
        this.gvp.setText(d.k.click_load_more);
        this.gvp.setHeight((int) getResources().getDimension(d.e.ds80));
        this.gvp.setBackgroundResource(d.f.screen_notify_item_background);
        this.gvp.setTextColor(getResources().getColorStateList(d.C0142d.screen_notify_load_more_text_color));
        this.gvp.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.gvp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gvp.setText(ScreenLockActivity.this.getResources().getString(d.k.loading));
                ScreenLockActivity.this.gvp.setEnabled(false);
                ScreenLockActivity.this.avO();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bqd())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avO() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gvq.bqn();
            if (this.gvm != null && this.gvm.getCount() > 0 && (item = this.gvm.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bqe().gvB = 1;
        a.bqe().gvz = 0;
        List<e> bqg = a.bqe().bqg();
        e bqh = a.bqe().bqh();
        a.bqe().release();
        if ((bqg == null || bqg.isEmpty()) && bqh == null && this.gvm.getCount() == 0 && this.gvl.getHeaderViewsCount() == 0) {
            a.bqe().gvy.bqj();
            finish();
            return;
        }
        dp(bqg);
        if (bqh != null) {
            a(bqh);
        }
        if (this.gvr != null) {
            this.gvr.mb(this.gvm.getCount() == 0);
        }
    }

    private void dp(List<e> list) {
        if (list != null && list.size() > 0 && this.gvm != null) {
            this.gvm.dq(list);
            if (this.gvm.isHasMore() && this.gvp == null) {
                bqb();
                this.gvl.addFooterView(this.gvp);
            }
        }
    }

    private void a(e eVar) {
        if (this.gvr == null) {
            this.gvr = new ScreenLockHeaderView(getActivity());
            this.gvr.setUIClickListener(this.gvt, this.gvu);
            this.gvr.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gvl.addHeaderView(this.gvr);
        }
        this.gvr.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bqe().gvB = 0;
        a.bqe().gvz = 0;
        if (this.gvr != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gvr.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gvs);
        a.bqe().release();
        a.bqe().gvB = 0;
        this.gvk = null;
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
            TiebaStatic.log(new an("c11703").f("msg_id", eVar.msgId / 100).f("task_id", eVar.taskId).ah("obj_to", eVar.url).ah("app_version", TbConfig.getVersion()).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
            if (!j.jD()) {
                showToast(getResources().getString(d.k.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                az.zV().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new an("c10316").ah("obj_type", eVar.stat).r("obj_locate", 2));
                a.bqe().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(eVar.groupId, 0L), eVar.groupName, 0L, "from_lock")));
                a.bqe().d(eVar);
                a.bqe().gvy.bqj();
                if (!a.bqe().gvy.bql()) {
                    a.bqe().gvy.bqk();
                }
                a.bqe().gvz = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gvn.groupId, 0L), eVar.groupName, eVar.nameShow, eVar.gvS, 0, eVar.gac ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(eVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bqe().d(eVar);
                a.bqe().gvz = 0;
                a.bqe().gvy.bqj();
                if (!a.bqe().gvy.bql()) {
                    a.bqe().gvy.bqk();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gvn.groupId, 0L), eVar.groupName, eVar.gvS, 0, 4)));
                a.bqe().d(eVar);
                a.bqe().gvz = 0;
                a.bqe().gvy.bqj();
                if (!a.bqe().gvy.bql()) {
                    a.bqe().gvy.bqk();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bqe().d(eVar);
                a.bqe().gvy.bqj();
                if (!a.bqe().gvy.bql()) {
                    a.bqe().gvy.bqk();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bqe().gvy.bqj();
            finish();
            return true;
        } else if (i == 82) {
            a.bqe().gvy.bqj();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bqc() {
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

    public String bqd() {
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
