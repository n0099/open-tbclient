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
    public static long piR = 0;
    public static long piS = 0;
    private CommonEmptyView bwJ;
    private AlaLoadingView cdW;
    private String mGroupId;
    private String mLiveId;
    private PTRLayoutView piM;
    private SMRListView piN;
    private com.baidu.yuyinala.privatemessage.session.a.a piO;
    private com.baidu.yuyinala.privatemessage.model.a piP;
    private long piQ = 0;
    private View bMM = null;
    private boolean piT = true;
    private String piU = "privateletter";
    private b piV = new b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.1
        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void Od(int i) {
            if (ChatListActivity.this.piP != null) {
                if (ListUtils.isEmpty(ChatListActivity.this.piP.getDataList())) {
                    ChatListActivity.this.bRy();
                } else {
                    ChatListActivity.this.piO.setData(ChatListActivity.this.piP.getDataList());
                    ChatListActivity.this.piM.Oj(0);
                    ChatListActivity.this.bwJ.setVisibility(8);
                    if (ChatListActivity.this.bMM != null) {
                        ChatListActivity.this.piN.removeFooterView(ChatListActivity.this.bMM);
                    }
                }
            }
            ChatListActivity.this.hideLoadingView();
        }

        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void x(String str, int i, String str2) {
            ChatListActivity.this.emK();
            ChatListActivity.this.hideLoadingView();
        }
    };
    private b piW = new AnonymousClass4();
    private CustomMessageListener piX = new CustomMessageListener(2501070) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && !ChatListActivity.this.isFinishing()) {
                ChatListActivity.this.finish();
            }
        }
    };
    IChatSessionChangeListener piY = new IChatSessionChangeListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.2
        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatSessionUpdate(ChatSession chatSession, boolean z) {
            if (ChatListActivity.this.emO() && chatSession != null) {
                if (chatSession.getChatType() == 0 || chatSession.getChatType() == 3 || chatSession.getChatType() == 4) {
                    ChatListActivity.this.piZ.removeMessages(0);
                    Message obtainMessage = ChatListActivity.this.piZ.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.obj = chatSession;
                    ChatListActivity.this.piZ.sendMessageDelayed(obtainMessage, 100L);
                }
            }
        }

        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatRecordDelete(int i, long j) {
            if (BIMManager.CATEGORY.SINGLEPERSON.getValue() == i || BIMManager.CATEGORY.GROUP.getValue() == i) {
                ChatListActivity.this.piZ.removeMessages(1);
                ChatListActivity.this.piZ.sendEmptyMessageDelayed(1, 500L);
            }
        }
    };
    private a piZ = new a(this);
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
        public void Od(int i) {
            BIMManager.mediaGetChatSessions(ChatListActivity.this.getPageContext().getPageActivity(), 0L, ChatListActivity.piR, 21, new IMediaGetChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
                public void onMediaGetChatSessionResult(int i2, int i3, boolean z, List<ChatSession> list) {
                    ChatListActivity.piS = ChatListActivity.piR;
                    if (list == null || list.size() <= 0 || !z) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ChatListActivity.this.piM.Ok(0);
                                if (ChatListActivity.this.piN.getFooterViewsCount() == 0) {
                                    ChatListActivity.this.bMM = LayoutInflater.from(ChatListActivity.this).inflate(a.g.yuyin_msg_list_footview, (ViewGroup) ChatListActivity.this.piN, false);
                                    ChatListActivity.this.piN.addFooterView(ChatListActivity.this.bMM);
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
        piR = list.get(list.size() - 1).getLastMsgTime();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                ChatSession chatSession = list.get(i2);
                if (piS != chatSession.getLastMsgTime()) {
                    chatSession.setLastMsgTime(chatSession.getLastMsgTime() / 1000);
                    arrayList.add(new i().aW(chatSession));
                }
                i = i2 + 1;
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatListActivity.this.piO.cv(arrayList);
                        ChatListActivity.this.piM.Ok(0);
                        if (ChatListActivity.this.bMM != null) {
                            ChatListActivity.this.piN.removeFooterView(ChatListActivity.this.bMM);
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
        MessageManager.getInstance().registerListener(this.piX);
        BIMManager.mediaSetRole(getActivity(), true);
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        setContentView(a.g.yuyin_activity_chat_list);
        emJ();
        N(getIntent());
        Zl();
        ekD();
        MessageManager.getInstance().registerListener(this.bgy);
    }

    private void emJ() {
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
        this.piP = new com.baidu.yuyinala.privatemessage.session.c.a();
        this.piN = (SMRListView) findViewById(a.f.news_inner_listview);
        this.piM = (PTRLayoutView) findViewById(a.f.refresh_view);
        if (this.piP != null) {
            this.piO = new com.baidu.yuyinala.privatemessage.session.a.a(this, this.piP.getDataList());
        }
        this.piN.setAdapter((ListAdapter) this.piO);
        this.piN.setMenuCreator(new d() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.8
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
        this.piN.setOnMenuItemClickListener(new SMListView.a() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.9
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMListView.a
            public boolean a(int i, c cVar, int i2) {
                com.baidu.yuyinala.privatemessage.session.b.a item = ChatListActivity.this.piO.getItem(i);
                if (item != null && (item instanceof j)) {
                    ChatListActivity.this.piP.a(ChatListActivity.this, (j) item, new IMediaDeleteChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.9.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener
                        public void onMediaDeleteChatSessionResult(int i3, String str) {
                            if (i3 == 0) {
                                ChatListActivity.this.piO.Og(i3);
                                if (ChatListActivity.this.piO.getCount() == 0) {
                                    ChatListActivity.this.bRy();
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
        this.piN.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChatListActivity.this.piO.getCount() > 0 && ChatListActivity.this.piO.getCount() > i) {
                    com.baidu.yuyinala.privatemessage.session.b.a item = ChatListActivity.this.piO.getItem(i);
                    if (item != null && (item instanceof j)) {
                        j jVar = (j) item;
                        com.baidu.yuyinala.privatemessage.session.util.a.a(ChatListActivity.this, jVar.name, jVar.pjw, jVar.isMediaRole, ChatListActivity.this.mLiveId, ChatListActivity.this.mGroupId, jVar.paid > 0 ? "80" : "0", jVar.paid, jVar.iconUrl);
                        LogUtils.d("miliao", "entity.isMediaRole：" + jVar.isMediaRole);
                    }
                    if (item instanceof j) {
                        ((j) item).pjy = null;
                        ChatListActivity.this.piO.notifyDataSetChanged();
                    }
                }
            }
        });
        this.piM.setOnRefreshListener(new PTRLayoutView.b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.11
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.b
            public void a(PTRLayoutView pTRLayoutView) {
                ChatListActivity.this.emM();
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.b
            public void b(PTRLayoutView pTRLayoutView) {
                ChatListActivity.this.emN();
            }
        });
        emM();
        emL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRy() {
        if (this.bwJ != null && this.piO != null) {
            this.bwJ.setVisibility(0);
            this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_list_empty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emK() {
        if (this.piO != null && this.bwJ != null) {
            this.piO.setData(null);
            this.piO.notifyDataSetChanged();
            this.bwJ.setVisibility(0);
            this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_network_error);
        }
    }

    private void emL() {
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
    public void emM() {
        this.piP.a(this, this.piV, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emN() {
        this.piP.a(this, this.piW, 4);
    }

    /* loaded from: classes11.dex */
    private static class a extends Handler {
        private final WeakReference<ChatListActivity> pje;

        a(ChatListActivity chatListActivity) {
            this.pje = new WeakReference<>(chatListActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ChatListActivity chatListActivity = this.pje.get();
            if (chatListActivity != null) {
                switch (message.what) {
                    case 0:
                        ChatSession chatSession = (ChatSession) message.obj;
                        if (chatSession != null) {
                            chatListActivity.piO.a(new i().aW(chatSession));
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
    public boolean emO() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.piQ <= 0 || currentTimeMillis - this.piQ > 500) {
            this.piQ = currentTimeMillis;
            return true;
        }
        return false;
    }

    private void ekD() {
        BIMManager.registerChatSessionChangeListener(this, this.piY);
    }

    private void ekE() {
        BIMManager.unregisterChatSessionChangeListener(this, this.piY);
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
        MessageManager.getInstance().unRegisterListener(this.piX);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        com.baidu.yuyinala.privatemessage.model.c.emB();
        if ("privateletter".equals(this.piU)) {
            ekE();
            if (this.piP != null) {
                this.piP.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (this.piT) {
            emM();
        }
        this.piT = false;
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
