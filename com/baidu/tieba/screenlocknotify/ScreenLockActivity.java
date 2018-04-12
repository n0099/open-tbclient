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
    private ImageView dFH;
    private Window geV;
    public c geY;
    public e geZ;
    private ScreenLockLoadMoreModel gfc;
    private ScreenLockHeaderView gfd;
    private Drawable geW = null;
    public DynamicHeightListView geX = null;
    private int gfa = 0;
    private TextView gfb = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gfe = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bkG().gfk.bkL();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gff = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e data;
            if (ScreenLockActivity.this.gfd != null && !StringUtils.isNull(ScreenLockActivity.this.gfd.getInputMsg()) && (data = ScreenLockActivity.this.gfd.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new al("c11703").f("msg_id", data.msgId / 100).f("task_id", data.taskId).ac("obj_to", data.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gfd.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().fh(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gfd.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.gfE);
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().fh(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bkG().gfk.bkL();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            ScreenLockActivity.this.geZ = ScreenLockActivity.this.geY.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.geZ);
        }
    };
    private View.OnClickListener gfg = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (ScreenLockActivity.this.gfd != null) {
                ScreenLockActivity.this.geZ = ScreenLockActivity.this.gfd.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.geZ);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gfh = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.k.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gfb != null) {
                            ScreenLockActivity.this.gfb.setText(ScreenLockActivity.this.getResources().getString(d.k.data_load_error));
                            ScreenLockActivity.this.gfb.setEnabled(true);
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
                        ArrayList<e> bkO = data.bkO();
                        if (ScreenLockActivity.this.geY != null) {
                            ScreenLockActivity.this.geY.de(bkO);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.geY.setHasMore(false);
                            if (ScreenLockActivity.this.gfb != null) {
                                ScreenLockActivity.this.geX.removeFooterView(ScreenLockActivity.this.gfb);
                                ScreenLockActivity.this.gfb = null;
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
        this.geV = getWindow();
        this.geV.addFlags(524288);
        this.geV.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.i.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0126d.transparent, true);
        if (l.hj()) {
            this.geW = bkE();
            if (this.geW != null) {
                this.geV.setBackgroundDrawable(this.geW);
            }
        }
        this.gfa = l.e(getPageContext().getPageActivity(), d.e.ds935) - l.e(getPageContext().getPageActivity(), d.e.ds80);
        this.gfc = new ScreenLockLoadMoreModel(this);
        registerListener(this.gfh);
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
        this.dFH = (ImageView) findViewById(d.g.head_close);
        this.dFH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e item;
                if (ScreenLockActivity.this.geY.getCount() > 0 && (item = ScreenLockActivity.this.geY.getItem(0)) != null) {
                    TiebaStatic.log(new al("c11704").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bkG().gfk.bkL();
            }
        });
        this.geX = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.geY = new c(getPageContext().getPageActivity());
        this.geX.setAdapter((ListAdapter) this.geY);
        this.geX.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gfe, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bkG().gfq = false;
        this.geX.setMaxHeight(this.gfa);
        this.geX.setTranscriptMode(0);
        this.geX.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gfb != null && ScreenLockActivity.this.gfb.getParent() != null) {
                    if (ScreenLockActivity.this.geX.getHeight() != ScreenLockActivity.this.gfa) {
                        ScreenLockActivity.this.gfb.setText(ScreenLockActivity.this.getResources().getString(d.k.click_load_more));
                        ScreenLockActivity.this.gfb.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gfb.isEnabled()) {
                            ScreenLockActivity.this.gfb.setText(ScreenLockActivity.this.getResources().getString(d.k.loading));
                            ScreenLockActivity.this.gfb.setEnabled(false);
                        }
                        ScreenLockActivity.this.arh();
                    }
                }
            }
        });
    }

    private void bkD() {
        this.gfb = new TextView(getActivity());
        this.gfb.setGravity(17);
        this.gfb.setText(d.k.click_load_more);
        this.gfb.setHeight((int) getResources().getDimension(d.e.ds80));
        this.gfb.setBackgroundResource(d.f.screen_notify_item_background);
        this.gfb.setTextColor(getResources().getColorStateList(d.C0126d.screen_notify_load_more_text_color));
        this.gfb.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.gfb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ScreenLockActivity.this.gfb.setText(ScreenLockActivity.this.getResources().getString(d.k.loading));
                ScreenLockActivity.this.gfb.setEnabled(false);
                ScreenLockActivity.this.arh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bkF())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arh() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gfc.bkP();
            if (this.geY != null && this.geY.getCount() > 0 && (item = this.geY.getItem(0)) != null) {
                TiebaStatic.log(new al("c11738").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bkG().gfn = 1;
        a.bkG().gfl = 0;
        List<e> bkI = a.bkG().bkI();
        e bkJ = a.bkG().bkJ();
        a.bkG().release();
        if ((bkI == null || bkI.isEmpty()) && bkJ == null && this.geY.getCount() == 0 && this.geX.getHeaderViewsCount() == 0) {
            a.bkG().gfk.bkL();
            finish();
            return;
        }
        dd(bkI);
        if (bkJ != null) {
            a(bkJ);
        }
        if (this.gfd != null) {
            this.gfd.lK(this.geY.getCount() == 0);
        }
    }

    private void dd(List<e> list) {
        if (list != null && list.size() > 0 && this.geY != null) {
            this.geY.de(list);
            if (this.geY.isHasMore() && this.gfb == null) {
                bkD();
                this.geX.addFooterView(this.gfb);
            }
        }
    }

    private void a(e eVar) {
        if (this.gfd == null) {
            this.gfd = new ScreenLockHeaderView(getActivity());
            this.gfd.setUIClickListener(this.gff, this.gfg);
            this.gfd.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.geX.addHeaderView(this.gfd);
        }
        this.gfd.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bkG().gfn = 0;
        a.bkG().gfl = 0;
        if (this.gfd != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gfd.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gfe);
        a.bkG().release();
        a.bkG().gfn = 0;
        this.geW = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new al("c11703").f("msg_id", eVar.msgId / 100).f("task_id", eVar.taskId).ac("obj_to", eVar.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!j.gP()) {
                showToast(getResources().getString(d.k.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                ax.wg().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new al("c10316").ac("obj_type", eVar.stat).r("obj_locate", 2));
                a.bkG().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(eVar.groupId, 0L), eVar.groupName, 0L, "from_lock")));
                a.bkG().d(eVar);
                a.bkG().gfk.bkL();
                if (!a.bkG().gfk.bkN()) {
                    a.bkG().gfk.bkM();
                }
                a.bkG().gfl = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.geZ.groupId, 0L), eVar.groupName, eVar.gfE, 0, eVar.fJN ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(eVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bkG().d(eVar);
                a.bkG().gfl = 0;
                a.bkG().gfk.bkL();
                if (!a.bkG().gfk.bkN()) {
                    a.bkG().gfk.bkM();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.geZ.groupId, 0L), eVar.groupName, eVar.gfE, 0, 4)));
                a.bkG().d(eVar);
                a.bkG().gfl = 0;
                a.bkG().gfk.bkL();
                if (!a.bkG().gfk.bkN()) {
                    a.bkG().gfk.bkM();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bkG().d(eVar);
                a.bkG().gfk.bkL();
                if (!a.bkG().gfk.bkN()) {
                    a.bkG().gfk.bkM();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bkG().gfk.bkL();
            finish();
            return true;
        } else if (i == 82) {
            a.bkG().gfk.bkL();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bkE() {
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

    public String bkF() {
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
