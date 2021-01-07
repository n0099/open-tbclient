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
    public static long pdf = 0;
    public static long pdg = 0;
    private CommonEmptyView bxT;
    private AlaLoadingView ceG;
    private String mGroupId;
    private String mLiveId;
    private PTRLayoutView pda;
    private SMRListView pdb;
    private com.baidu.yuyinala.privatemessage.session.a.a pdc;
    private com.baidu.yuyinala.privatemessage.model.a pdd;
    private long pde = 0;
    private View bNO = null;
    private boolean pdh = true;
    private String pdi = "privateletter";
    private b pdj = new b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.1
        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void Pp(int i) {
            if (ChatListActivity.this.pdd != null) {
                if (ListUtils.isEmpty(ChatListActivity.this.pdd.getDataList())) {
                    ChatListActivity.this.bUM();
                } else {
                    ChatListActivity.this.pdc.setData(ChatListActivity.this.pdd.getDataList());
                    ChatListActivity.this.pda.Pv(0);
                    ChatListActivity.this.bxT.setVisibility(8);
                    if (ChatListActivity.this.bNO != null) {
                        ChatListActivity.this.pdb.removeFooterView(ChatListActivity.this.bNO);
                    }
                }
            }
            ChatListActivity.this.hideLoadingView();
        }

        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void x(String str, int i, String str2) {
            ChatListActivity.this.eoo();
            ChatListActivity.this.hideLoadingView();
        }
    };
    private b pdk = new AnonymousClass4();
    private CustomMessageListener pdl = new CustomMessageListener(2501070) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && !ChatListActivity.this.isFinishing()) {
                ChatListActivity.this.finish();
            }
        }
    };
    IChatSessionChangeListener pdm = new IChatSessionChangeListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.2
        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatSessionUpdate(ChatSession chatSession, boolean z) {
            if (ChatListActivity.this.eos() && chatSession != null) {
                if (chatSession.getChatType() == 0 || chatSession.getChatType() == 3 || chatSession.getChatType() == 4) {
                    ChatListActivity.this.pdn.removeMessages(0);
                    Message obtainMessage = ChatListActivity.this.pdn.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.obj = chatSession;
                    ChatListActivity.this.pdn.sendMessageDelayed(obtainMessage, 100L);
                }
            }
        }

        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatRecordDelete(int i, long j) {
            if (BIMManager.CATEGORY.SINGLEPERSON.getValue() == i || BIMManager.CATEGORY.GROUP.getValue() == i) {
                ChatListActivity.this.pdn.removeMessages(1);
                ChatListActivity.this.pdn.sendEmptyMessageDelayed(1, 500L);
            }
        }
    };
    private a pdn = new a(this);
    public CustomMessageListener bih = new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.3
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
        public void Pp(int i) {
            BIMManager.mediaGetChatSessions(ChatListActivity.this.getPageContext().getPageActivity(), 0L, ChatListActivity.pdf, 21, new IMediaGetChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
                public void onMediaGetChatSessionResult(int i2, int i3, boolean z, List<ChatSession> list) {
                    ChatListActivity.pdg = ChatListActivity.pdf;
                    if (list == null || list.size() <= 0 || !z) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ChatListActivity.this.pda.Pw(0);
                                if (ChatListActivity.this.pdb.getFooterViewsCount() == 0) {
                                    ChatListActivity.this.bNO = LayoutInflater.from(ChatListActivity.this).inflate(a.g.yuyin_msg_list_footview, (ViewGroup) ChatListActivity.this.pdb, false);
                                    ChatListActivity.this.pdb.addFooterView(ChatListActivity.this.bNO);
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
        pdf = list.get(list.size() - 1).getLastMsgTime();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                ChatSession chatSession = list.get(i2);
                if (pdg != chatSession.getLastMsgTime()) {
                    chatSession.setLastMsgTime(chatSession.getLastMsgTime() / 1000);
                    arrayList.add(new i().aW(chatSession));
                }
                i = i2 + 1;
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatListActivity.this.pdc.cA(arrayList);
                        ChatListActivity.this.pda.Pw(0);
                        if (ChatListActivity.this.bNO != null) {
                            ChatListActivity.this.pdb.removeFooterView(ChatListActivity.this.bNO);
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
        MessageManager.getInstance().registerListener(this.pdl);
        BIMManager.mediaSetRole(getActivity(), true);
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        setContentView(a.g.yuyin_activity_chat_list);
        eon();
        N(getIntent());
        abo();
        emd();
        MessageManager.getInstance().registerListener(this.bih);
    }

    private void eon() {
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

    private void abo() {
        this.bxT = (CommonEmptyView) findViewById(a.f.yuyin_ala_empty_view);
        this.ceG = (AlaLoadingView) findViewById(a.f.yuyin_ala_loading_view);
        this.pdd = new com.baidu.yuyinala.privatemessage.session.c.a();
        this.pdb = (SMRListView) findViewById(a.f.news_inner_listview);
        this.pda = (PTRLayoutView) findViewById(a.f.refresh_view);
        if (this.pdd != null) {
            this.pdc = new com.baidu.yuyinala.privatemessage.session.a.a(this, this.pdd.getDataList());
        }
        this.pdb.setAdapter((ListAdapter) this.pdc);
        this.pdb.setMenuCreator(new d() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.8
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.d
            public void a(c cVar) {
                e eVar = new e(ChatListActivity.this.getPageContext().getPageActivity());
                eVar.setBackground(new ColorDrawable(Color.rgb(249, 63, 37)));
                eVar.setWidth(ChatListActivity.this.wT(60));
                eVar.setTitle("删除");
                eVar.setTitleColor(Color.rgb(255, 255, 255));
                eVar.setTitleSize(15);
                cVar.c(eVar);
            }
        });
        this.pdb.setOnMenuItemClickListener(new SMListView.a() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.9
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMListView.a
            public boolean a(int i, c cVar, int i2) {
                com.baidu.yuyinala.privatemessage.session.b.a item = ChatListActivity.this.pdc.getItem(i);
                if (item != null && (item instanceof j)) {
                    ChatListActivity.this.pdd.a(ChatListActivity.this, (j) item, new IMediaDeleteChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.9.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener
                        public void onMediaDeleteChatSessionResult(int i3, String str) {
                            if (i3 == 0) {
                                ChatListActivity.this.pdc.Ps(i3);
                                if (ChatListActivity.this.pdc.getCount() == 0) {
                                    ChatListActivity.this.bUM();
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
        this.pdb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChatListActivity.this.pdc.getCount() > 0 && ChatListActivity.this.pdc.getCount() > i) {
                    com.baidu.yuyinala.privatemessage.session.b.a item = ChatListActivity.this.pdc.getItem(i);
                    if (item != null && (item instanceof j)) {
                        j jVar = (j) item;
                        com.baidu.yuyinala.privatemessage.session.util.a.a(ChatListActivity.this, jVar.name, jVar.pdK, jVar.isMediaRole, ChatListActivity.this.mLiveId, ChatListActivity.this.mGroupId, jVar.paid > 0 ? "80" : "0", jVar.paid, jVar.iconUrl);
                        LogUtils.d("miliao", "entity.isMediaRole：" + jVar.isMediaRole);
                    }
                    if (item instanceof j) {
                        ((j) item).pdM = null;
                        ChatListActivity.this.pdc.notifyDataSetChanged();
                    }
                }
            }
        });
        this.pda.setOnRefreshListener(new PTRLayoutView.b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.11
            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.b
            public void a(PTRLayoutView pTRLayoutView) {
                ChatListActivity.this.eoq();
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.PTRLayoutView.b
            public void b(PTRLayoutView pTRLayoutView) {
                ChatListActivity.this.eor();
            }
        });
        eoq();
        eop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUM() {
        if (this.bxT != null && this.pdc != null) {
            this.bxT.setVisibility(0);
            this.bxT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_list_empty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eoo() {
        if (this.pdc != null && this.bxT != null) {
            this.pdc.setData(null);
            this.pdc.notifyDataSetChanged();
            this.bxT.setVisibility(0);
            this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_network_error);
        }
    }

    private void eop() {
        if (this.ceG != null && this.bxT != null) {
            this.bxT.setVisibility(8);
            this.ceG.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.ceG != null) {
            this.ceG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eoq() {
        this.pdd.a(this, this.pdj, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eor() {
        this.pdd.a(this, this.pdk, 4);
    }

    /* loaded from: classes11.dex */
    private static class a extends Handler {
        private final WeakReference<ChatListActivity> pds;

        a(ChatListActivity chatListActivity) {
            this.pds = new WeakReference<>(chatListActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ChatListActivity chatListActivity = this.pds.get();
            if (chatListActivity != null) {
                switch (message.what) {
                    case 0:
                        ChatSession chatSession = (ChatSession) message.obj;
                        if (chatSession != null) {
                            chatListActivity.pdc.a(new i().aW(chatSession));
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
    public boolean eos() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.pde <= 0 || currentTimeMillis - this.pde > 500) {
            this.pde = currentTimeMillis;
            return true;
        }
        return false;
    }

    private void emd() {
        BIMManager.registerChatSessionChangeListener(this, this.pdm);
    }

    private void eme() {
        BIMManager.unregisterChatSessionChangeListener(this, this.pdm);
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
        MessageManager.getInstance().unRegisterListener(this.pdl);
        MessageManager.getInstance().unRegisterListener(this.bih);
        com.baidu.yuyinala.privatemessage.model.c.eoe();
        if ("privateletter".equals(this.pdi)) {
            eme();
            if (this.pdd != null) {
                this.pdd.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (this.pdh) {
            eoq();
        }
        this.pdh = false;
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
    public int wT(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }
}
