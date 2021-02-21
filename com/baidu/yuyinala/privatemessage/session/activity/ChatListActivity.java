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
/* loaded from: classes11.dex */
public class ChatListActivity extends BaseFragmentActivity {
    public static long pjr = 0;
    public static long pjs = 0;
    private CommonEmptyView bwJ;
    private AlaLoadingView cdW;
    private String mGroupId;
    private String mLiveId;
    private PTRLayoutView pjm;
    private SMRListView pjn;
    private com.baidu.yuyinala.privatemessage.session.a.a pjo;
    private com.baidu.yuyinala.privatemessage.model.a pjp;
    private long pjq = 0;
    private View bMM = null;
    private boolean pjt = true;
    private String pju = "privateletter";
    private b pjv = new b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.1
        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void Oe(int i) {
            if (ChatListActivity.this.pjp != null) {
                if (ListUtils.isEmpty(ChatListActivity.this.pjp.getDataList())) {
                    ChatListActivity.this.bRF();
                } else {
                    ChatListActivity.this.pjo.setData(ChatListActivity.this.pjp.getDataList());
                    ChatListActivity.this.pjm.Ok(0);
                    ChatListActivity.this.bwJ.setVisibility(8);
                    if (ChatListActivity.this.bMM != null) {
                        ChatListActivity.this.pjn.removeFooterView(ChatListActivity.this.bMM);
                    }
                }
            }
            ChatListActivity.this.hideLoadingView();
        }

        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void x(String str, int i, String str2) {
            ChatListActivity.this.emS();
            ChatListActivity.this.hideLoadingView();
        }
    };
    private b pjw = new AnonymousClass4();
    private CustomMessageListener pjx = new CustomMessageListener(2501070) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && !ChatListActivity.this.isFinishing()) {
                ChatListActivity.this.finish();
            }
        }
    };
    IChatSessionChangeListener pjy = new IChatSessionChangeListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.2
        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatSessionUpdate(ChatSession chatSession, boolean z) {
            if (ChatListActivity.this.emW() && chatSession != null) {
                if (chatSession.getChatType() == 0 || chatSession.getChatType() == 3 || chatSession.getChatType() == 4) {
                    ChatListActivity.this.pjz.removeMessages(0);
                    Message obtainMessage = ChatListActivity.this.pjz.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.obj = chatSession;
                    ChatListActivity.this.pjz.sendMessageDelayed(obtainMessage, 100L);
                }
            }
        }

        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatRecordDelete(int i, long j) {
            if (BIMManager.CATEGORY.SINGLEPERSON.getValue() == i || BIMManager.CATEGORY.GROUP.getValue() == i) {
                ChatListActivity.this.pjz.removeMessages(1);
                ChatListActivity.this.pjz.sendEmptyMessageDelayed(1, 500L);
            }
        }
    };
    private a pjz = new a(this);
    public CustomMessageListener bgy = new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!ChatListActivity.this.isFinishing()) {
                ChatListActivity.this.finish();
            }
        }
    };

    /* renamed from: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity$4  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass4 implements b {
        AnonymousClass4() {
        }

        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void Oe(int i) {
            BIMManager.mediaGetChatSessions(ChatListActivity.this.getPageContext().getPageActivity(), 0L, ChatListActivity.pjr, 21, new IMediaGetChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
                public void onMediaGetChatSessionResult(int i2, int i3, boolean z, List<ChatSession> list) {
                    ChatListActivity.pjs = ChatListActivity.pjr;
                    if (list == null || list.size() <= 0 || !z) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ChatListActivity.this.pjm.Ol(0);
                                if (ChatListActivity.this.pjn.getFooterViewsCount() == 0) {
                                    ChatListActivity.this.bMM = LayoutInflater.from(ChatListActivity.this).inflate(a.g.yuyin_msg_list_footview, (ViewGroup) ChatListActivity.this.pjn, false);
                                    ChatListActivity.this.pjn.addFooterView(ChatListActivity.this.bMM);
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
        public void x(String str, int i, String str2) {
            ChatListActivity.this.hideLoadingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(List<ChatSession> list) {
        final ArrayList arrayList = new ArrayList();
        pjr = list.get(list.size() - 1).getLastMsgTime();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                ChatSession chatSession = list.get(i2);
                if (pjs != chatSession.getLastMsgTime()) {
                    chatSession.setLastMsgTime(chatSession.getLastMsgTime() / 1000);
                    arrayList.add(new i().aW(chatSession));
                }
                i = i2 + 1;
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatListActivity.this.pjo.cv(arrayList);
                        ChatListActivity.this.pjm.Ol(0);
                        if (ChatListActivity.this.bMM != null) {
                            ChatListActivity.this.pjn.removeFooterView(ChatListActivity.this.bMM);
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
        MessageManager.getInstance().registerListener(this.pjx);
        BIMManager.mediaSetRole(getActivity(), true);
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        setContentView(a.g.yuyin_activity_chat_list);
        emR();
        N(getIntent());
        Zl();
        ekL();
        MessageManager.getInstance().registerListener(this.bgy);
    }

    private void emR() {
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

    private void Zl() {
        this.bwJ = (CommonEmptyView) findViewById(a.f.yuyin_ala_empty_view);
        this.cdW = (AlaLoadingView) findViewById(a.f.yuyin_ala_loading_view);
        this.pjp = new com.baidu.yuyinala.privatemessage.session.c.a();
        this.pjn = (SMRListView) findViewById(a.f.news_inner_listview);
        this.pjm = (PTRLayoutView) findViewById(a.f.refresh_view);
        if (this.pjp != null) {
            this.pjo = new com.baidu.yuyinala.privatemessage.session.a.a(this, this.pjp.getDataList());
        }
        this.pjn.setAdapter((ListAdapter) this.pjo);
        this.pjn.setMenuCreator(new d() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.8
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.d
            public void a(c cVar) {
                e eVar = new e(ChatListActivity.this.getPageContext().getPageActivity());
                eVar.setBackground(new ColorDrawable(Color.rgb(249, 63, 37)));
                eVar.setWidth(ChatListActivity.this.vy(60));
                eVar.setTitle("删除");
                eVar.setTitleColor(Color.rgb(255, 255, 255));
                eVar.setTitleSize(15);
                cVar.c(eVar);
            }
        });
        this.pjn.setOnMenuItemClickListener(new SMListView.a() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.9
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMListView.a
            public boolean a(int i, c cVar, int i2) {
                com.baidu.yuyinala.privatemessage.session.b.a item = ChatListActivity.this.pjo.getItem(i);
                if (item != null && (item instanceof j)) {
                    ChatListActivity.this.pjp.a(ChatListActivity.this, (j) item, new IMediaDeleteChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.9.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener
                        public void onMediaDeleteChatSessionResult(int i3, String str) {
                            if (i3 == 0) {
                                ChatListActivity.this.pjo.Oh(i3);
                                if (ChatListActivity.this.pjo.getCount() == 0) {
                                    ChatListActivity.this.bRF();
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
        this.pjn.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChatListActivity.this.pjo.getCount() > 0 && ChatListActivity.this.pjo.getCount() > i) {
                    com.baidu.yuyinala.privatemessage.session.b.a item = ChatListActivity.this.pjo.getItem(i);
                    if (item != null && (item instanceof j)) {
                        j jVar = (j) item;
                        com.baidu.yuyinala.privatemessage.session.util.a.a(ChatListActivity.this, jVar.name, jVar.pjW, jVar.isMediaRole, ChatListActivity.this.mLiveId, ChatListActivity.this.mGroupId, jVar.paid > 0 ? "80" : "0", jVar.paid, jVar.iconUrl);
                        LogUtils.d("miliao", "entity.isMediaRole：" + jVar.isMediaRole);
                    }
                    if (item instanceof j) {
                        ((j) item).pjY = null;
                        ChatListActivity.this.pjo.notifyDataSetChanged();
                    }
                }
            }
        });
        this.pjm.setOnRefreshListener(new PTRLayoutView.b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.11
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.b
            public void a(PTRLayoutView pTRLayoutView) {
                ChatListActivity.this.emU();
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.b
            public void b(PTRLayoutView pTRLayoutView) {
                ChatListActivity.this.emV();
            }
        });
        emU();
        emT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRF() {
        if (this.bwJ != null && this.pjo != null) {
            this.bwJ.setVisibility(0);
            this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_list_empty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emS() {
        if (this.pjo != null && this.bwJ != null) {
            this.pjo.setData(null);
            this.pjo.notifyDataSetChanged();
            this.bwJ.setVisibility(0);
            this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_network_error);
        }
    }

    private void emT() {
        if (this.cdW != null && this.bwJ != null) {
            this.bwJ.setVisibility(8);
            this.cdW.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.cdW != null) {
            this.cdW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emU() {
        this.pjp.a(this, this.pjv, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emV() {
        this.pjp.a(this, this.pjw, 4);
    }

    /* loaded from: classes11.dex */
    private static class a extends Handler {
        private final WeakReference<ChatListActivity> pjE;

        a(ChatListActivity chatListActivity) {
            this.pjE = new WeakReference<>(chatListActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ChatListActivity chatListActivity = this.pjE.get();
            if (chatListActivity != null) {
                switch (message.what) {
                    case 0:
                        ChatSession chatSession = (ChatSession) message.obj;
                        if (chatSession != null) {
                            chatListActivity.pjo.a(new i().aW(chatSession));
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
    public boolean emW() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.pjq <= 0 || currentTimeMillis - this.pjq > 500) {
            this.pjq = currentTimeMillis;
            return true;
        }
        return false;
    }

    private void ekL() {
        BIMManager.registerChatSessionChangeListener(this, this.pjy);
    }

    private void ekM() {
        BIMManager.unregisterChatSessionChangeListener(this, this.pjy);
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
        MessageManager.getInstance().unRegisterListener(this.pjx);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        com.baidu.yuyinala.privatemessage.model.c.emJ();
        if ("privateletter".equals(this.pju)) {
            ekM();
            if (this.pjp != null) {
                this.pjp.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (this.pjt) {
            emU();
        }
        this.pjt = false;
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
    public int vy(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }
}
