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
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView egM;
    private Window gHp;
    public c gHs;
    public e gHt;
    private ScreenLockLoadMoreModel gHw;
    private com.baidu.tieba.screenlocknotify.a.a gHx;
    private Drawable gHq = null;
    public DynamicHeightListView gHr = null;
    private int gHu = 0;
    private TextView gHv = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gHy = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.boc().gHE.boh();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gHz = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.gHx != null && !StringUtils.isNull(ScreenLockActivity.this.gHx.getInputMsg()) && (data = ScreenLockActivity.this.gHx.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f("msg_id", data.msgId / 100).f("task_id", data.taskId).aa("obj_to", data.url).aa(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gHx.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gh().fe(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gHx.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.gHY);
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gh().fe(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.boc().gHE.boh();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gHt = ScreenLockActivity.this.gHs.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gHt);
        }
    };
    private View.OnClickListener gHA = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gHx != null) {
                ScreenLockActivity.this.gHt = ScreenLockActivity.this.gHx.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gHt);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gHB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gHv != null) {
                            ScreenLockActivity.this.gHv.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.gHv.setEnabled(true);
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
                        ArrayList<e> bok = data.bok();
                        if (ScreenLockActivity.this.gHs != null) {
                            ScreenLockActivity.this.gHs.dg(bok);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gHs.setHasMore(false);
                            if (ScreenLockActivity.this.gHv != null) {
                                ScreenLockActivity.this.gHr.removeFooterView(ScreenLockActivity.this.gHv);
                                ScreenLockActivity.this.gHv = null;
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
        this.gHp = getWindow();
        this.gHp.addFlags(524288);
        this.gHp.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0108d.transparent, true);
        if (l.pd()) {
            this.gHq = boa();
            if (this.gHq != null) {
                this.gHp.setBackgroundDrawable(this.gHq);
            }
        }
        this.gHu = l.s(getPageContext().getPageActivity(), d.e.ds935) - l.s(getPageContext().getPageActivity(), d.e.ds80);
        this.gHw = new ScreenLockLoadMoreModel(this);
        registerListener(this.gHB);
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
        this.egM = (ImageView) findViewById(d.g.head_close);
        this.egM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.gHs.getCount() > 0 && (item = ScreenLockActivity.this.gHs.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.boc().gHE.boh();
            }
        });
        this.gHr = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.gHs = new c(getPageContext().getPageActivity());
        this.gHr.setAdapter((ListAdapter) this.gHs);
        this.gHr.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gHy, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.boc().gHK = false;
        this.gHr.setMaxHeight(this.gHu);
        this.gHr.setTranscriptMode(0);
        this.gHr.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gHv != null && ScreenLockActivity.this.gHv.getParent() != null) {
                    if (ScreenLockActivity.this.gHr.getHeight() != ScreenLockActivity.this.gHu) {
                        ScreenLockActivity.this.gHv.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.gHv.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gHv.isEnabled()) {
                            ScreenLockActivity.this.gHv.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.gHv.setEnabled(false);
                        }
                        ScreenLockActivity.this.WT();
                    }
                }
            }
        });
    }

    private void bnZ() {
        this.gHv = new TextView(getActivity());
        this.gHv.setGravity(17);
        this.gHv.setText(d.j.click_load_more);
        this.gHv.setHeight((int) getResources().getDimension(d.e.ds80));
        this.gHv.setBackgroundResource(d.f.screen_notify_item_background);
        this.gHv.setTextColor(getResources().getColorStateList(d.C0108d.screen_notify_load_more_text_color));
        this.gHv.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.gHv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gHv.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.gHv.setEnabled(false);
                ScreenLockActivity.this.WT();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bob())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WT() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gHw.bol();
            if (this.gHs != null && this.gHs.getCount() > 0 && (item = this.gHs.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.boc().gHH = 1;
        a.boc().gHF = 0;
        List<e> boe = a.boc().boe();
        e bof = a.boc().bof();
        a.boc().release();
        if ((boe == null || boe.isEmpty()) && bof == null && this.gHs.getCount() == 0 && this.gHr.getHeaderViewsCount() == 0) {
            a.boc().gHE.boh();
            finish();
            return;
        }
        df(boe);
        if (bof != null) {
            a(bof);
        }
        if (this.gHx != null) {
            this.gHx.lX(this.gHs.getCount() == 0);
        }
    }

    private void df(List<e> list) {
        if (list != null && list.size() > 0 && this.gHs != null) {
            this.gHs.dg(list);
            if (this.gHs.isHasMore() && this.gHv == null) {
                bnZ();
                this.gHr.addFooterView(this.gHv);
            }
        }
    }

    private void a(e eVar) {
        if (this.gHx == null) {
            this.gHx = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.gHx.a(this.gHz, this.gHA);
            this.gHx.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gHr.addHeaderView(this.gHx);
        }
        this.gHx.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.boc().gHH = 0;
        a.boc().gHF = 0;
        if (this.gHx != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gHx.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gHy);
        a.boc().release();
        a.boc().gHH = 0;
        this.gHq = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new ak("c11703").f("msg_id", eVar.msgId / 100).f("task_id", eVar.taskId).aa("obj_to", eVar.url).aa(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!j.oJ()) {
                showToast(getResources().getString(d.j.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                av.Da().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new ak("c10316").aa("obj_type", eVar.stat).s("obj_locate", 2));
                a.boc().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.boc().d(eVar);
                a.boc().gHE.boh();
                if (!a.boc().gHE.boj()) {
                    a.boc().gHE.boi();
                }
                a.boc().gHF = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gHt.groupId, 0L), eVar.groupName, eVar.gHY, 0, eVar.gnw ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(eVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.boc().d(eVar);
                a.boc().gHF = 0;
                a.boc().gHE.boh();
                if (!a.boc().gHE.boj()) {
                    a.boc().gHE.boi();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gHt.groupId, 0L), eVar.groupName, eVar.gHY, 0, 4)));
                a.boc().d(eVar);
                a.boc().gHF = 0;
                a.boc().gHE.boh();
                if (!a.boc().gHE.boj()) {
                    a.boc().gHE.boi();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.boc().d(eVar);
                a.boc().gHE.boh();
                if (!a.boc().gHE.boj()) {
                    a.boc().gHE.boi();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.boc().gHE.boh();
            finish();
            return true;
        } else if (i == 82) {
            a.boc().gHE.boh();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable boa() {
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

    public String bob() {
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
