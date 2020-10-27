package com.baidu.yuyinala.privatemessage.session.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener;
import com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.yuyinala.privatemessage.model.c;
import com.baidu.yuyinala.privatemessage.session.b;
import com.baidu.yuyinala.privatemessage.session.b.j;
import com.baidu.yuyinala.privatemessage.session.view.SwipeListView;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class ChatListActivity extends BaseFragmentActivity {
    private CommonEmptyView boq;
    private String mGroupId;
    private String mLiveId;
    private SwipeListView owU;
    private com.baidu.yuyinala.privatemessage.session.a.a owV;
    private com.baidu.yuyinala.privatemessage.model.a owW;
    private long owX = 0;
    private String owY = "privateletter";
    private b owZ = new b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.1
        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void NF(int i) {
            if (ChatListActivity.this.owW != null) {
                if (ListUtils.isEmpty(ChatListActivity.this.owW.getDataList())) {
                    ChatListActivity.this.bME();
                    return;
                }
                ChatListActivity.this.owU.setVisibility(0);
                ChatListActivity.this.owV.setData(ChatListActivity.this.owW.getDataList());
                ChatListActivity.this.owV.notifyDataSetChanged();
                if (ChatListActivity.this.owU.getFooterViewsCount() == 0) {
                    ChatListActivity.this.owU.addFooterView(LayoutInflater.from(ChatListActivity.this).inflate(a.h.yuyin_msg_list_footview, (ViewGroup) ChatListActivity.this.owU, false));
                }
                ChatListActivity.this.boq.setVisibility(8);
            }
        }

        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void v(String str, int i, String str2) {
            ChatListActivity.this.eeD();
        }
    };
    private CustomMessageListener oxa = new CustomMessageListener(2501070) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && !ChatListActivity.this.isFinishing()) {
                ChatListActivity.this.finish();
            }
        }
    };
    IChatSessionChangeListener oxb = new IChatSessionChangeListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.5
        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatSessionUpdate(ChatSession chatSession, boolean z) {
            if (ChatListActivity.this.eeF() && chatSession != null) {
                if (chatSession.getChatType() == 0 || chatSession.getChatType() == 3 || chatSession.getChatType() == 4) {
                    ChatListActivity.this.oxc.removeMessages(0);
                    Message obtainMessage = ChatListActivity.this.oxc.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.obj = chatSession;
                    ChatListActivity.this.oxc.sendMessageDelayed(obtainMessage, 100L);
                }
            }
        }

        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatRecordDelete(int i, long j) {
            if (BIMManager.CATEGORY.SINGLEPERSON.getValue() == i || BIMManager.CATEGORY.GROUP.getValue() == i) {
                ChatListActivity.this.oxc.removeMessages(1);
                ChatListActivity.this.oxc.sendEmptyMessageDelayed(1, 500L);
            }
        }
    };
    private a oxc = new a(this);
    public CustomMessageListener bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!ChatListActivity.this.isFinishing()) {
                ChatListActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        MessageManager.getInstance().registerListener(this.oxa);
        BIMManager.mediaSetRole(getActivity(), true);
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        setContentView(a.h.yuyin_activity_chat_list);
        eeC();
        M(getIntent());
        Vr();
        ecx();
        MessageManager.getInstance().registerListener(this.bcQ);
    }

    private void eeC() {
        findViewById(a.g.yuyin_chatlist_view_top).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ChatListActivity.this.finish();
                return false;
            }
        });
    }

    private void M(Intent intent) {
        if (intent != null) {
            this.mLiveId = intent.getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            this.mGroupId = intent.getStringExtra("groupid");
        }
    }

    private void Vr() {
        this.boq = (CommonEmptyView) findViewById(a.g.yuyin_ala_empty_view);
        this.owW = new com.baidu.yuyinala.privatemessage.session.c.a();
        this.owU = (SwipeListView) findViewById(a.g.news_inner_listview);
        if (this.owW != null) {
            this.owV = new com.baidu.yuyinala.privatemessage.session.a.a(this, this.owW.getDataList());
        }
        this.owU.setListener(new com.baidu.yuyinala.privatemessage.session.view.a() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4
            @Override // com.baidu.yuyinala.privatemessage.session.view.a
            public void p(View view, int i) {
                com.baidu.yuyinala.privatemessage.session.b.a item = ChatListActivity.this.owV.getItem(i);
                if (item != null && (item instanceof j)) {
                    j jVar = (j) item;
                    com.baidu.yuyinala.privatemessage.session.util.a.a(ChatListActivity.this, jVar.name, jVar.oxw, jVar.isMediaRole, ChatListActivity.this.mLiveId, ChatListActivity.this.mGroupId, jVar.paid > 0 ? "80" : "0", jVar.paid, jVar.iconUrl);
                    LogUtils.d("miliao", "entity.isMediaRole：" + jVar.isMediaRole);
                }
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.a
            public boolean E(View view, int i) {
                return false;
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.a
            public void a(int i, View view, final int i2) {
                com.baidu.yuyinala.privatemessage.session.b.a item;
                if (i == a.g.yuyin_tv_chatlist_delete && (item = ChatListActivity.this.owV.getItem(i2)) != null && (item instanceof j)) {
                    ChatListActivity.this.owW.a(ChatListActivity.this, (j) item, new IMediaDeleteChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener
                        public void onMediaDeleteChatSessionResult(int i3, String str) {
                            if (i3 == 0) {
                                ChatListActivity.this.owV.NI(i2);
                                if (ChatListActivity.this.owV.getCount() == 0) {
                                    ChatListActivity.this.bME();
                                    return;
                                }
                                return;
                            }
                            ChatListActivity.this.showToast(str);
                        }
                    });
                }
            }
        }, new int[]{a.g.yuyin_tv_chatlist_delete});
        this.owU.setAdapter((ListAdapter) this.owV);
        this.owU.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bME() {
        if (this.boq != null && this.owV != null) {
            this.owU.setVisibility(8);
            this.boq.setVisibility(0);
            this.boq.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.i.yuyin_sdk_privatemsg_list_empty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeD() {
        if (this.owV != null && this.boq != null) {
            this.owU.setVisibility(8);
            this.owV.setData(null);
            this.owV.notifyDataSetChanged();
            this.boq.setVisibility(0);
            this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.i.yuyin_sdk_privatemsg_network_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeE() {
        this.owW.a(this, this.owZ, 2);
    }

    /* loaded from: classes4.dex */
    private static class a extends Handler {
        private final WeakReference<ChatListActivity> oxf;

        a(ChatListActivity chatListActivity) {
            this.oxf = new WeakReference<>(chatListActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ChatListActivity chatListActivity = this.oxf.get();
            if (chatListActivity != null) {
                switch (message.what) {
                    case 0:
                        if (((ChatSession) message.obj) != null) {
                            chatListActivity.eeE();
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
    public boolean eeF() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.owX <= 0 || currentTimeMillis - this.owX > 500) {
            this.owX = currentTimeMillis;
            return true;
        }
        return false;
    }

    private void ecx() {
        BIMManager.registerChatSessionChangeListener(this, this.oxb);
    }

    private void ecy() {
        BIMManager.unregisterChatSessionChangeListener(this, this.oxb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.oxa);
        MessageManager.getInstance().unRegisterListener(this.bcQ);
        c.eev();
        if ("privateletter".equals(this.owY)) {
            ecy();
            if (this.owW != null) {
                this.owW.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        eeE();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
