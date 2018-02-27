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
    private ImageView ekM;
    private Window gJF;
    public c gJI;
    public e gJJ;
    private ScreenLockLoadMoreModel gJM;
    private com.baidu.tieba.screenlocknotify.a.a gJN;
    private Drawable gJG = null;
    public DynamicHeightListView gJH = null;
    private int gJK = 0;
    private TextView gJL = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gJO = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bpy().gJU.bpD();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gJP = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.gJN != null && !StringUtils.isNull(ScreenLockActivity.this.gJN.getInputMsg()) && (data = ScreenLockActivity.this.gJN.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f("msg_id", data.msgId / 100).f("task_id", data.taskId).ab("obj_to", data.url).ab(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gJN.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.GI().fp(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gJN.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.gKo);
                    com.baidu.tbadk.coreExtra.messageCenter.a.GI().fp(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bpy().gJU.bpD();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gJJ = ScreenLockActivity.this.gJI.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gJJ);
        }
    };
    private View.OnClickListener gJQ = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gJN != null) {
                ScreenLockActivity.this.gJJ = ScreenLockActivity.this.gJN.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gJJ);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gJR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gJL != null) {
                            ScreenLockActivity.this.gJL.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.gJL.setEnabled(true);
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
                        ArrayList<e> bpG = data.bpG();
                        if (ScreenLockActivity.this.gJI != null) {
                            ScreenLockActivity.this.gJI.dm(bpG);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gJI.setHasMore(false);
                            if (ScreenLockActivity.this.gJL != null) {
                                ScreenLockActivity.this.gJH.removeFooterView(ScreenLockActivity.this.gJL);
                                ScreenLockActivity.this.gJL = null;
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
        this.gJF = getWindow();
        this.gJF.addFlags(524288);
        this.gJF.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0141d.transparent, true);
        if (l.pd()) {
            this.gJG = bpw();
            if (this.gJG != null) {
                this.gJF.setBackgroundDrawable(this.gJG);
            }
        }
        this.gJK = l.t(getPageContext().getPageActivity(), d.e.ds935) - l.t(getPageContext().getPageActivity(), d.e.ds80);
        this.gJM = new ScreenLockLoadMoreModel(this);
        registerListener(this.gJR);
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
        this.ekM = (ImageView) findViewById(d.g.head_close);
        this.ekM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.gJI.getCount() > 0 && (item = ScreenLockActivity.this.gJI.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bpy().gJU.bpD();
            }
        });
        this.gJH = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.gJI = new c(getPageContext().getPageActivity());
        this.gJH.setAdapter((ListAdapter) this.gJI);
        this.gJH.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gJO, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bpy().gKa = false;
        this.gJH.setMaxHeight(this.gJK);
        this.gJH.setTranscriptMode(0);
        this.gJH.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gJL != null && ScreenLockActivity.this.gJL.getParent() != null) {
                    if (ScreenLockActivity.this.gJH.getHeight() != ScreenLockActivity.this.gJK) {
                        ScreenLockActivity.this.gJL.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.gJL.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gJL.isEnabled()) {
                            ScreenLockActivity.this.gJL.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.gJL.setEnabled(false);
                        }
                        ScreenLockActivity.this.awP();
                    }
                }
            }
        });
    }

    private void bpv() {
        this.gJL = new TextView(getActivity());
        this.gJL.setGravity(17);
        this.gJL.setText(d.j.click_load_more);
        this.gJL.setHeight((int) getResources().getDimension(d.e.ds80));
        this.gJL.setBackgroundResource(d.f.screen_notify_item_background);
        this.gJL.setTextColor(getResources().getColorStateList(d.C0141d.screen_notify_load_more_text_color));
        this.gJL.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.gJL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gJL.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.gJL.setEnabled(false);
                ScreenLockActivity.this.awP();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bpx())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awP() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gJM.bpH();
            if (this.gJI != null && this.gJI.getCount() > 0 && (item = this.gJI.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bpy().gJX = 1;
        a.bpy().gJV = 0;
        List<e> bpA = a.bpy().bpA();
        e bpB = a.bpy().bpB();
        a.bpy().release();
        if ((bpA == null || bpA.isEmpty()) && bpB == null && this.gJI.getCount() == 0 && this.gJH.getHeaderViewsCount() == 0) {
            a.bpy().gJU.bpD();
            finish();
            return;
        }
        dl(bpA);
        if (bpB != null) {
            a(bpB);
        }
        if (this.gJN != null) {
            this.gJN.me(this.gJI.getCount() == 0);
        }
    }

    private void dl(List<e> list) {
        if (list != null && list.size() > 0 && this.gJI != null) {
            this.gJI.dm(list);
            if (this.gJI.isHasMore() && this.gJL == null) {
                bpv();
                this.gJH.addFooterView(this.gJL);
            }
        }
    }

    private void a(e eVar) {
        if (this.gJN == null) {
            this.gJN = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.gJN.a(this.gJP, this.gJQ);
            this.gJN.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gJH.addHeaderView(this.gJN);
        }
        this.gJN.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bpy().gJX = 0;
        a.bpy().gJV = 0;
        if (this.gJN != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gJN.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gJO);
        a.bpy().release();
        a.bpy().gJX = 0;
        this.gJG = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new ak("c11703").f("msg_id", eVar.msgId / 100).f("task_id", eVar.taskId).ab("obj_to", eVar.url).ab(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!j.oJ()) {
                showToast(getResources().getString(d.j.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                aw.Dt().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new ak("c10316").ab("obj_type", eVar.stat).s("obj_locate", 2));
                a.bpy().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.bpy().d(eVar);
                a.bpy().gJU.bpD();
                if (!a.bpy().gJU.bpF()) {
                    a.bpy().gJU.bpE();
                }
                a.bpy().gJV = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gJJ.groupId, 0L), eVar.groupName, eVar.gKo, 0, eVar.goV ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(eVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bpy().d(eVar);
                a.bpy().gJV = 0;
                a.bpy().gJU.bpD();
                if (!a.bpy().gJU.bpF()) {
                    a.bpy().gJU.bpE();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gJJ.groupId, 0L), eVar.groupName, eVar.gKo, 0, 4)));
                a.bpy().d(eVar);
                a.bpy().gJV = 0;
                a.bpy().gJU.bpD();
                if (!a.bpy().gJU.bpF()) {
                    a.bpy().gJU.bpE();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bpy().d(eVar);
                a.bpy().gJU.bpD();
                if (!a.bpy().gJU.bpF()) {
                    a.bpy().gJU.bpE();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bpy().gJU.bpD();
            finish();
            return true;
        } else if (i == 82) {
            a.bpy().gJU.bpD();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bpw() {
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

    public String bpx() {
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
