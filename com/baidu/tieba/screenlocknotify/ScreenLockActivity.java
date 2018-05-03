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
    private ImageView dFE;
    private Window geS;
    public c geV;
    public e geW;
    private ScreenLockLoadMoreModel geZ;
    private ScreenLockHeaderView gfa;
    private Drawable geT = null;
    public DynamicHeightListView geU = null;
    private int geX = 0;
    private TextView geY = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gfb = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bkG().gfh.bkL();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gfc = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e data;
            if (ScreenLockActivity.this.gfa != null && !StringUtils.isNull(ScreenLockActivity.this.gfa.getInputMsg()) && (data = ScreenLockActivity.this.gfa.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new al("c11703").f("msg_id", data.msgId / 100).f("task_id", data.taskId).ac("obj_to", data.url).ac(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gfa.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().fh(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gfa.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.gfB);
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().fh(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bkG().gfh.bkL();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            ScreenLockActivity.this.geW = ScreenLockActivity.this.geV.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.geW);
        }
    };
    private View.OnClickListener gfd = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (ScreenLockActivity.this.gfa != null) {
                ScreenLockActivity.this.geW = ScreenLockActivity.this.gfa.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.geW);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gfe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.k.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.geY != null) {
                            ScreenLockActivity.this.geY.setText(ScreenLockActivity.this.getResources().getString(d.k.data_load_error));
                            ScreenLockActivity.this.geY.setEnabled(true);
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
                        if (ScreenLockActivity.this.geV != null) {
                            ScreenLockActivity.this.geV.de(bkO);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.geV.setHasMore(false);
                            if (ScreenLockActivity.this.geY != null) {
                                ScreenLockActivity.this.geU.removeFooterView(ScreenLockActivity.this.geY);
                                ScreenLockActivity.this.geY = null;
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
        this.geS = getWindow();
        this.geS.addFlags(524288);
        this.geS.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.i.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0126d.transparent, true);
        if (l.hj()) {
            this.geT = bkE();
            if (this.geT != null) {
                this.geS.setBackgroundDrawable(this.geT);
            }
        }
        this.geX = l.e(getPageContext().getPageActivity(), d.e.ds935) - l.e(getPageContext().getPageActivity(), d.e.ds80);
        this.geZ = new ScreenLockLoadMoreModel(this);
        registerListener(this.gfe);
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
        this.dFE = (ImageView) findViewById(d.g.head_close);
        this.dFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e item;
                if (ScreenLockActivity.this.geV.getCount() > 0 && (item = ScreenLockActivity.this.geV.getItem(0)) != null) {
                    TiebaStatic.log(new al("c11704").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bkG().gfh.bkL();
            }
        });
        this.geU = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.geV = new c(getPageContext().getPageActivity());
        this.geU.setAdapter((ListAdapter) this.geV);
        this.geU.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gfb, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bkG().gfn = false;
        this.geU.setMaxHeight(this.geX);
        this.geU.setTranscriptMode(0);
        this.geU.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.geY != null && ScreenLockActivity.this.geY.getParent() != null) {
                    if (ScreenLockActivity.this.geU.getHeight() != ScreenLockActivity.this.geX) {
                        ScreenLockActivity.this.geY.setText(ScreenLockActivity.this.getResources().getString(d.k.click_load_more));
                        ScreenLockActivity.this.geY.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.geY.isEnabled()) {
                            ScreenLockActivity.this.geY.setText(ScreenLockActivity.this.getResources().getString(d.k.loading));
                            ScreenLockActivity.this.geY.setEnabled(false);
                        }
                        ScreenLockActivity.this.arh();
                    }
                }
            }
        });
    }

    private void bkD() {
        this.geY = new TextView(getActivity());
        this.geY.setGravity(17);
        this.geY.setText(d.k.click_load_more);
        this.geY.setHeight((int) getResources().getDimension(d.e.ds80));
        this.geY.setBackgroundResource(d.f.screen_notify_item_background);
        this.geY.setTextColor(getResources().getColorStateList(d.C0126d.screen_notify_load_more_text_color));
        this.geY.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.geY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ScreenLockActivity.this.geY.setText(ScreenLockActivity.this.getResources().getString(d.k.loading));
                ScreenLockActivity.this.geY.setEnabled(false);
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
            this.geZ.bkP();
            if (this.geV != null && this.geV.getCount() > 0 && (item = this.geV.getItem(0)) != null) {
                TiebaStatic.log(new al("c11738").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bkG().gfk = 1;
        a.bkG().gfi = 0;
        List<e> bkI = a.bkG().bkI();
        e bkJ = a.bkG().bkJ();
        a.bkG().release();
        if ((bkI == null || bkI.isEmpty()) && bkJ == null && this.geV.getCount() == 0 && this.geU.getHeaderViewsCount() == 0) {
            a.bkG().gfh.bkL();
            finish();
            return;
        }
        dd(bkI);
        if (bkJ != null) {
            a(bkJ);
        }
        if (this.gfa != null) {
            this.gfa.lK(this.geV.getCount() == 0);
        }
    }

    private void dd(List<e> list) {
        if (list != null && list.size() > 0 && this.geV != null) {
            this.geV.de(list);
            if (this.geV.isHasMore() && this.geY == null) {
                bkD();
                this.geU.addFooterView(this.geY);
            }
        }
    }

    private void a(e eVar) {
        if (this.gfa == null) {
            this.gfa = new ScreenLockHeaderView(getActivity());
            this.gfa.setUIClickListener(this.gfc, this.gfd);
            this.gfa.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.geU.addHeaderView(this.gfa);
        }
        this.gfa.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bkG().gfk = 0;
        a.bkG().gfi = 0;
        if (this.gfa != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gfa.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gfb);
        a.bkG().release();
        a.bkG().gfk = 0;
        this.geT = null;
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
                a.bkG().gfh.bkL();
                if (!a.bkG().gfh.bkN()) {
                    a.bkG().gfh.bkM();
                }
                a.bkG().gfi = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.geW.groupId, 0L), eVar.groupName, eVar.gfB, 0, eVar.fJK ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(eVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bkG().d(eVar);
                a.bkG().gfi = 0;
                a.bkG().gfh.bkL();
                if (!a.bkG().gfh.bkN()) {
                    a.bkG().gfh.bkM();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.geW.groupId, 0L), eVar.groupName, eVar.gfB, 0, 4)));
                a.bkG().d(eVar);
                a.bkG().gfi = 0;
                a.bkG().gfh.bkL();
                if (!a.bkG().gfh.bkN()) {
                    a.bkG().gfh.bkM();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bkG().d(eVar);
                a.bkG().gfh.bkL();
                if (!a.bkG().gfh.bkN()) {
                    a.bkG().gfh.bkM();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bkG().gfh.bkL();
            finish();
            return true;
        } else if (i == 82) {
            a.bkG().gfh.bkL();
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
