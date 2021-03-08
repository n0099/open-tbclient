package com.baidu.yuyinala.privatemessage.session.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener;
import com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener;
import com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.view.AlaLoadingView;
import com.baidu.yuyinala.privatemessage.session.b;
import com.baidu.yuyinala.privatemessage.session.b.i;
import com.baidu.yuyinala.privatemessage.session.b.j;
import com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView;
import com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMListView;
import com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMRListView;
import com.baidu.yuyinala.privatemessage.session.view.smrlistview.c;
import com.baidu.yuyinala.privatemessage.session.view.smrlistview.d;
import com.baidu.yuyinala.privatemessage.session.view.smrlistview.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes10.dex */
public class ChatListActivity extends BaseFragmentActivity {
    public static long plx = 0;
    public static long ply = 0;
    private CommonEmptyView byj;
    private AlaLoadingView cfw;
    private String mGroupId;
    private String mLiveId;
    private PTRLayoutView pls;
    private SMRListView plt;
    private com.baidu.yuyinala.privatemessage.session.a.a plu;
    private com.baidu.yuyinala.privatemessage.model.a plv;
    private long plw = 0;
    private View bOm = null;
    private boolean plz = true;
    private String plA = "privateletter";
    private b plB = new b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.1
        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void Oi(int i) {
            if (ChatListActivity.this.plv != null) {
                if (ListUtils.isEmpty(ChatListActivity.this.plv.getDataList())) {
                    ChatListActivity.this.bRL();
                } else {
                    ChatListActivity.this.plu.setData(ChatListActivity.this.plv.getDataList());
                    ChatListActivity.this.pls.Oo(0);
                    ChatListActivity.this.byj.setVisibility(8);
                    if (ChatListActivity.this.bOm != null) {
                        ChatListActivity.this.plt.removeFooterView(ChatListActivity.this.bOm);
                    }
                }
            }
            ChatListActivity.this.hideLoadingView();
        }

        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void y(String str, int i, String str2) {
            ChatListActivity.this.enc();
            ChatListActivity.this.hideLoadingView();
        }
    };
    private b plC = new AnonymousClass4();
    private CustomMessageListener plD = new CustomMessageListener(2501070) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && !ChatListActivity.this.isFinishing()) {
                ChatListActivity.this.finish();
            }
        }
    };
    IChatSessionChangeListener plE = new IChatSessionChangeListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.2
        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatSessionUpdate(ChatSession chatSession, boolean z) {
            if (ChatListActivity.this.enh() && chatSession != null) {
                if (chatSession.getChatType() == 0 || chatSession.getChatType() == 3 || chatSession.getChatType() == 4) {
                    ChatListActivity.this.plF.removeMessages(0);
                    Message obtainMessage = ChatListActivity.this.plF.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.obj = chatSession;
                    ChatListActivity.this.plF.sendMessageDelayed(obtainMessage, 100L);
                }
            }
        }

        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatRecordDelete(int i, long j) {
            if (BIMManager.CATEGORY.SINGLEPERSON.getValue() == i || BIMManager.CATEGORY.GROUP.getValue() == i) {
                ChatListActivity.this.plF.removeMessages(1);
                ChatListActivity.this.plF.sendEmptyMessageDelayed(1, 500L);
            }
        }
    };
    private a plF = new a(this);
    public CustomMessageListener bhY = new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!ChatListActivity.this.isFinishing()) {
                ChatListActivity.this.finish();
            }
        }
    };

    /* renamed from: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity$4  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass4 implements b {
        AnonymousClass4() {
        }

        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void Oi(int i) {
            BIMManager.mediaGetChatSessions(ChatListActivity.this.getPageContext().getPageActivity(), 0L, ChatListActivity.plx, 21, new IMediaGetChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
                public void onMediaGetChatSessionResult(int i2, int i3, boolean z, List<ChatSession> list) {
                    ChatListActivity.ply = ChatListActivity.plx;
                    if (list == null || list.size() <= 0 || !z) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ChatListActivity.this.pls.Op(0);
                                if (ChatListActivity.this.plt.getFooterViewsCount() == 0) {
                                    ChatListActivity.this.bOm = LayoutInflater.from(ChatListActivity.this).inflate(a.g.yuyin_msg_list_footview, (ViewGroup) ChatListActivity.this.plt, false);
                                    ChatListActivity.this.plt.addFooterView(ChatListActivity.this.bOm);
                                }
                            }
                        });
                        return;
                    }
                    Collections.sort(list, new Comparator<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(ChatSession chatSession, ChatSession chatSession2) {
                            return (int) (chatSession2.getLastMsgTime() - chatSession.getLastMsgTime());
                        }
                    });
                    ChatListActivity.this.gC(list);
                }
            });
            ChatListActivity.this.hideLoadingView();
        }

        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void y(String str, int i, String str2) {
            ChatListActivity.this.hideLoadingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(List<ChatSession> list) {
        final ArrayList arrayList = new ArrayList();
        plx = list.get(list.size() - 1).getLastMsgTime();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                ChatSession chatSession = list.get(i2);
                if (ply != chatSession.getLastMsgTime()) {
                    chatSession.setLastMsgTime(chatSession.getLastMsgTime() / 1000);
                    arrayList.add(new i().aY(chatSession));
                }
                i = i2 + 1;
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatListActivity.this.plu.cv(arrayList);
                        ChatListActivity.this.pls.Op(0);
                        if (ChatListActivity.this.bOm != null) {
                            ChatListActivity.this.plt.removeFooterView(ChatListActivity.this.bOm);
                        }
                    }
                });
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        MessageManager.getInstance().registerListener(this.plD);
        BIMManager.mediaSetRole(getActivity(), true);
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        setContentView(a.g.yuyin_activity_chat_list);
        enb();
        N(getIntent());
        Zo();
        ekV();
        MessageManager.getInstance().registerListener(this.bhY);
    }

    private void enb() {
        findViewById(a.f.yuyin_chatlist_view_top).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ChatListActivity.this.finish();
                return false;
            }
        });
    }

    private void N(Intent intent) {
        if (intent != null) {
            this.mLiveId = intent.getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            this.mGroupId = intent.getStringExtra("groupid");
        }
    }

    private void Zo() {
        this.byj = (CommonEmptyView) findViewById(a.f.yuyin_ala_empty_view);
        this.cfw = (AlaLoadingView) findViewById(a.f.yuyin_ala_loading_view);
        this.plv = new com.baidu.yuyinala.privatemessage.session.c.a();
        this.plt = (SMRListView) findViewById(a.f.news_inner_listview);
        this.pls = (PTRLayoutView) findViewById(a.f.refresh_view);
        if (this.plv != null) {
            this.plu = new com.baidu.yuyinala.privatemessage.session.a.a(this, this.plv.getDataList());
        }
        this.plt.setAdapter((ListAdapter) this.plu);
        this.plt.setMenuCreator(new d() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.8
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.d
            public void a(c cVar) {
                e eVar = new e(ChatListActivity.this.getPageContext().getPageActivity());
                eVar.setBackground(new ColorDrawable(Color.rgb(249, 63, 37)));
                eVar.setWidth(ChatListActivity.this.vA(60));
                eVar.setTitle("删除");
                eVar.setTitleColor(Color.rgb(255, 255, 255));
                eVar.setTitleSize(15);
                cVar.c(eVar);
            }
        });
        this.plt.setOnMenuItemClickListener(new SMListView.a() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.9
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMListView.a
            public boolean a(int i, c cVar, int i2) {
                com.baidu.yuyinala.privatemessage.session.b.a item = ChatListActivity.this.plu.getItem(i);
                if (item != null && (item instanceof j)) {
                    ChatListActivity.this.plv.a(ChatListActivity.this, (j) item, new IMediaDeleteChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.9.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener
                        public void onMediaDeleteChatSessionResult(int i3, String str) {
                            if (i3 == 0) {
                                ChatListActivity.this.plu.Ol(i3);
                                if (ChatListActivity.this.plu.getCount() == 0) {
                                    ChatListActivity.this.bRL();
                                    return;
                                }
                                return;
                            }
                            ChatListActivity.this.showToast(str);
                        }
                    });
                    return false;
                }
                return false;
            }
        });
        this.plt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChatListActivity.this.plu.getCount() > 0 && ChatListActivity.this.plu.getCount() > i) {
                    com.baidu.yuyinala.privatemessage.session.b.a item = ChatListActivity.this.plu.getItem(i);
                    if (item != null && (item instanceof j)) {
                        j jVar = (j) item;
                        com.baidu.yuyinala.privatemessage.session.util.a.a(ChatListActivity.this, jVar.name, jVar.pmc, jVar.isMediaRole, ChatListActivity.this.mLiveId, ChatListActivity.this.mGroupId, jVar.paid > 0 ? "80" : "0", jVar.paid, jVar.iconUrl);
                        LogUtils.d("miliao", "entity.isMediaRole：" + jVar.isMediaRole);
                    }
                    if (item instanceof j) {
                        ((j) item).pme = null;
                        ChatListActivity.this.plu.notifyDataSetChanged();
                    }
                }
            }
        });
        this.pls.setOnRefreshListener(new PTRLayoutView.b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.11
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.b
            public void a(PTRLayoutView pTRLayoutView) {
                ChatListActivity.this.enf();
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.b
            public void b(PTRLayoutView pTRLayoutView) {
                ChatListActivity.this.eng();
            }
        });
        enf();
        ene();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRL() {
        if (this.byj != null && this.plu != null) {
            this.byj.setVisibility(0);
            this.byj.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_list_empty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enc() {
        if (this.plu != null && this.byj != null) {
            this.plu.setData(null);
            this.plu.notifyDataSetChanged();
            this.byj.setVisibility(0);
            this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_network_error);
        }
    }

    private void ene() {
        if (this.cfw != null && this.byj != null) {
            this.byj.setVisibility(8);
            this.cfw.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.cfw != null) {
            this.cfw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enf() {
        this.plv.a(this, this.plB, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eng() {
        this.plv.a(this, this.plC, 4);
    }

    /* loaded from: classes10.dex */
    private static class a extends Handler {
        private final WeakReference<ChatListActivity> plK;

        a(ChatListActivity chatListActivity) {
            this.plK = new WeakReference<>(chatListActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ChatListActivity chatListActivity = this.plK.get();
            if (chatListActivity != null) {
                switch (message.what) {
                    case 0:
                        ChatSession chatSession = (ChatSession) message.obj;
                        if (chatSession != null) {
                            chatListActivity.plu.a(new i().aY(chatSession));
                            return;
                        }
                        return;
                    case 1:
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean enh() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.plw <= 0 || currentTimeMillis - this.plw > 500) {
            this.plw = currentTimeMillis;
            return true;
        }
        return false;
    }

    private void ekV() {
        BIMManager.registerChatSessionChangeListener(this, this.plE);
    }

    private void ekW() {
        BIMManager.unregisterChatSessionChangeListener(this, this.plE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.plD);
        MessageManager.getInstance().unRegisterListener(this.bhY);
        com.baidu.yuyinala.privatemessage.model.c.emT();
        if ("privateletter".equals(this.plA)) {
            ekW();
            if (this.plv != null) {
                this.plv.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (this.plz) {
            enf();
        }
        this.plz = false;
        super.onResume();
        UtilHelper.changeStatusBarIconAndTextColor(true, getPageContext().getPageActivity());
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int vA(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }
}
