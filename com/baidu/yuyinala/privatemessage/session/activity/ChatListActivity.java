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
    public static long oYB = 0;
    public static long oYC = 0;
    private AlaLoadingView bZQ;
    private CommonEmptyView btf;
    private String mGroupId;
    private String mLiveId;
    private PTRLayoutView oYw;
    private SMRListView oYx;
    private com.baidu.yuyinala.privatemessage.session.a.a oYy;
    private com.baidu.yuyinala.privatemessage.model.a oYz;
    private long oYA = 0;
    private View bJc = null;
    private boolean oYD = true;
    private String oYE = "privateletter";
    private b oYF = new b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.1
        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void NI(int i) {
            if (ChatListActivity.this.oYz != null) {
                if (ListUtils.isEmpty(ChatListActivity.this.oYz.getDataList())) {
                    ChatListActivity.this.bQU();
                } else {
                    ChatListActivity.this.oYy.setData(ChatListActivity.this.oYz.getDataList());
                    ChatListActivity.this.oYw.NO(0);
                    ChatListActivity.this.btf.setVisibility(8);
                    if (ChatListActivity.this.bJc != null) {
                        ChatListActivity.this.oYx.removeFooterView(ChatListActivity.this.bJc);
                    }
                }
            }
            ChatListActivity.this.hideLoadingView();
        }

        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void x(String str, int i, String str2) {
            ChatListActivity.this.eks();
            ChatListActivity.this.hideLoadingView();
        }
    };
    private b oYG = new AnonymousClass4();
    private CustomMessageListener oYH = new CustomMessageListener(2501070) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && !ChatListActivity.this.isFinishing()) {
                ChatListActivity.this.finish();
            }
        }
    };
    IChatSessionChangeListener oYI = new IChatSessionChangeListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.2
        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatSessionUpdate(ChatSession chatSession, boolean z) {
            if (ChatListActivity.this.ekw() && chatSession != null) {
                if (chatSession.getChatType() == 0 || chatSession.getChatType() == 3 || chatSession.getChatType() == 4) {
                    ChatListActivity.this.oYJ.removeMessages(0);
                    Message obtainMessage = ChatListActivity.this.oYJ.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.obj = chatSession;
                    ChatListActivity.this.oYJ.sendMessageDelayed(obtainMessage, 100L);
                }
            }
        }

        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatRecordDelete(int i, long j) {
            if (BIMManager.CATEGORY.SINGLEPERSON.getValue() == i || BIMManager.CATEGORY.GROUP.getValue() == i) {
                ChatListActivity.this.oYJ.removeMessages(1);
                ChatListActivity.this.oYJ.sendEmptyMessageDelayed(1, 500L);
            }
        }
    };
    private a oYJ = new a(this);
    public CustomMessageListener bdo = new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.3
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
        public void NI(int i) {
            BIMManager.mediaGetChatSessions(ChatListActivity.this.getPageContext().getPageActivity(), 0L, ChatListActivity.oYB, 21, new IMediaGetChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
                public void onMediaGetChatSessionResult(int i2, int i3, boolean z, List<ChatSession> list) {
                    ChatListActivity.oYC = ChatListActivity.oYB;
                    if (list == null || list.size() <= 0 || !z) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ChatListActivity.this.oYw.NP(0);
                                if (ChatListActivity.this.oYx.getFooterViewsCount() == 0) {
                                    ChatListActivity.this.bJc = LayoutInflater.from(ChatListActivity.this).inflate(a.g.yuyin_msg_list_footview, (ViewGroup) ChatListActivity.this.oYx, false);
                                    ChatListActivity.this.oYx.addFooterView(ChatListActivity.this.bJc);
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
                    ChatListActivity.this.gE(list);
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
    public void gE(List<ChatSession> list) {
        final ArrayList arrayList = new ArrayList();
        oYB = list.get(list.size() - 1).getLastMsgTime();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                ChatSession chatSession = list.get(i2);
                if (oYC != chatSession.getLastMsgTime()) {
                    chatSession.setLastMsgTime(chatSession.getLastMsgTime() / 1000);
                    arrayList.add(new i().aW(chatSession));
                }
                i = i2 + 1;
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatListActivity.this.oYy.cA(arrayList);
                        ChatListActivity.this.oYw.NP(0);
                        if (ChatListActivity.this.bJc != null) {
                            ChatListActivity.this.oYx.removeFooterView(ChatListActivity.this.bJc);
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
        MessageManager.getInstance().registerListener(this.oYH);
        BIMManager.mediaSetRole(getActivity(), true);
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        setContentView(a.g.yuyin_activity_chat_list);
        ekr();
        N(getIntent());
        Xv();
        eij();
        MessageManager.getInstance().registerListener(this.bdo);
    }

    private void ekr() {
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

    private void Xv() {
        this.btf = (CommonEmptyView) findViewById(a.f.yuyin_ala_empty_view);
        this.bZQ = (AlaLoadingView) findViewById(a.f.yuyin_ala_loading_view);
        this.oYz = new com.baidu.yuyinala.privatemessage.session.c.a();
        this.oYx = (SMRListView) findViewById(a.f.news_inner_listview);
        this.oYw = (PTRLayoutView) findViewById(a.f.refresh_view);
        if (this.oYz != null) {
            this.oYy = new com.baidu.yuyinala.privatemessage.session.a.a(this, this.oYz.getDataList());
        }
        this.oYx.setAdapter((ListAdapter) this.oYy);
        this.oYx.setMenuCreator(new d() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.8
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.d
            public void a(c cVar) {
                e eVar = new e(ChatListActivity.this.getPageContext().getPageActivity());
                eVar.setBackground(new ColorDrawable(Color.rgb(249, 63, 37)));
                eVar.setWidth(ChatListActivity.this.vn(60));
                eVar.setTitle("删除");
                eVar.setTitleColor(Color.rgb(255, 255, 255));
                eVar.setTitleSize(15);
                cVar.c(eVar);
            }
        });
        this.oYx.setOnMenuItemClickListener(new SMListView.a() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.9
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMListView.a
            public boolean a(int i, c cVar, int i2) {
                com.baidu.yuyinala.privatemessage.session.b.a item = ChatListActivity.this.oYy.getItem(i);
                if (item != null && (item instanceof j)) {
                    ChatListActivity.this.oYz.a(ChatListActivity.this, (j) item, new IMediaDeleteChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.9.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener
                        public void onMediaDeleteChatSessionResult(int i3, String str) {
                            if (i3 == 0) {
                                ChatListActivity.this.oYy.NL(i3);
                                if (ChatListActivity.this.oYy.getCount() == 0) {
                                    ChatListActivity.this.bQU();
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
        this.oYx.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChatListActivity.this.oYy.getCount() > 0 && ChatListActivity.this.oYy.getCount() > i) {
                    com.baidu.yuyinala.privatemessage.session.b.a item = ChatListActivity.this.oYy.getItem(i);
                    if (item != null && (item instanceof j)) {
                        j jVar = (j) item;
                        com.baidu.yuyinala.privatemessage.session.util.a.a(ChatListActivity.this, jVar.name, jVar.oZg, jVar.isMediaRole, ChatListActivity.this.mLiveId, ChatListActivity.this.mGroupId, jVar.paid > 0 ? "80" : "0", jVar.paid, jVar.iconUrl);
                        LogUtils.d("miliao", "entity.isMediaRole：" + jVar.isMediaRole);
                    }
                    if (item instanceof j) {
                        ((j) item).oZi = null;
                        ChatListActivity.this.oYy.notifyDataSetChanged();
                    }
                }
            }
        });
        this.oYw.setOnRefreshListener(new PTRLayoutView.b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.11
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.b
            public void a(PTRLayoutView pTRLayoutView) {
                ChatListActivity.this.eku();
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.b
            public void b(PTRLayoutView pTRLayoutView) {
                ChatListActivity.this.ekv();
            }
        });
        eku();
        ekt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQU() {
        if (this.btf != null && this.oYy != null) {
            this.btf.setVisibility(0);
            this.btf.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_list_empty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eks() {
        if (this.oYy != null && this.btf != null) {
            this.oYy.setData(null);
            this.oYy.notifyDataSetChanged();
            this.btf.setVisibility(0);
            this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_network_error);
        }
    }

    private void ekt() {
        if (this.bZQ != null && this.btf != null) {
            this.btf.setVisibility(8);
            this.bZQ.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.bZQ != null) {
            this.bZQ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eku() {
        this.oYz.a(this, this.oYF, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekv() {
        this.oYz.a(this, this.oYG, 4);
    }

    /* loaded from: classes10.dex */
    private static class a extends Handler {
        private final WeakReference<ChatListActivity> oYO;

        a(ChatListActivity chatListActivity) {
            this.oYO = new WeakReference<>(chatListActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ChatListActivity chatListActivity = this.oYO.get();
            if (chatListActivity != null) {
                switch (message.what) {
                    case 0:
                        ChatSession chatSession = (ChatSession) message.obj;
                        if (chatSession != null) {
                            chatListActivity.oYy.a(new i().aW(chatSession));
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
    public boolean ekw() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.oYA <= 0 || currentTimeMillis - this.oYA > 500) {
            this.oYA = currentTimeMillis;
            return true;
        }
        return false;
    }

    private void eij() {
        BIMManager.registerChatSessionChangeListener(this, this.oYI);
    }

    private void eik() {
        BIMManager.unregisterChatSessionChangeListener(this, this.oYI);
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
        MessageManager.getInstance().unRegisterListener(this.oYH);
        MessageManager.getInstance().unRegisterListener(this.bdo);
        com.baidu.yuyinala.privatemessage.model.c.ekj();
        if ("privateletter".equals(this.oYE)) {
            eik();
            if (this.oYz != null) {
                this.oYz.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (this.oYD) {
            eku();
        }
        this.oYD = false;
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
    public int vn(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }
}
