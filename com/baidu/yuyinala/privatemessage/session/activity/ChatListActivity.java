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
    private CommonEmptyView btg;
    private String mGroupId;
    private String mLiveId;
    private SwipeListView oWW;
    private com.baidu.yuyinala.privatemessage.session.a.a oWX;
    private com.baidu.yuyinala.privatemessage.model.a oWY;
    private long oWZ = 0;
    private String oXa = "privateletter";
    private b oXb = new b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.1
        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void PB(int i) {
            if (ChatListActivity.this.oWY != null) {
                if (ListUtils.isEmpty(ChatListActivity.this.oWY.getDataList())) {
                    ChatListActivity.this.bSi();
                    return;
                }
                ChatListActivity.this.oWW.setVisibility(0);
                ChatListActivity.this.oWX.setData(ChatListActivity.this.oWY.getDataList());
                ChatListActivity.this.oWX.notifyDataSetChanged();
                if (ChatListActivity.this.oWW.getFooterViewsCount() == 0) {
                    ChatListActivity.this.oWW.addFooterView(LayoutInflater.from(ChatListActivity.this).inflate(a.g.yuyin_msg_list_footview, (ViewGroup) ChatListActivity.this.oWW, false));
                }
                ChatListActivity.this.btg.setVisibility(8);
            }
        }

        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void x(String str, int i, String str2) {
            ChatListActivity.this.eog();
        }
    };
    private CustomMessageListener oXc = new CustomMessageListener(2501070) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && !ChatListActivity.this.isFinishing()) {
                ChatListActivity.this.finish();
            }
        }
    };
    IChatSessionChangeListener oXd = new IChatSessionChangeListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.5
        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatSessionUpdate(ChatSession chatSession, boolean z) {
            if (ChatListActivity.this.eoi() && chatSession != null) {
                if (chatSession.getChatType() == 0 || chatSession.getChatType() == 3 || chatSession.getChatType() == 4) {
                    ChatListActivity.this.oXe.removeMessages(0);
                    Message obtainMessage = ChatListActivity.this.oXe.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.obj = chatSession;
                    ChatListActivity.this.oXe.sendMessageDelayed(obtainMessage, 100L);
                }
            }
        }

        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatRecordDelete(int i, long j) {
            if (BIMManager.CATEGORY.SINGLEPERSON.getValue() == i || BIMManager.CATEGORY.GROUP.getValue() == i) {
                ChatListActivity.this.oXe.removeMessages(1);
                ChatListActivity.this.oXe.sendEmptyMessageDelayed(1, 500L);
            }
        }
    };
    private a oXe = new a(this);
    public CustomMessageListener bgy = new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.6
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
        MessageManager.getInstance().registerListener(this.oXc);
        BIMManager.mediaSetRole(getActivity(), true);
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        setContentView(a.g.yuyin_activity_chat_list);
        eoe();
        M(getIntent());
        ZG();
        elY();
        MessageManager.getInstance().registerListener(this.bgy);
    }

    private void eoe() {
        findViewById(a.f.yuyin_chatlist_view_top).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.3
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

    private void ZG() {
        this.btg = (CommonEmptyView) findViewById(a.f.yuyin_ala_empty_view);
        this.oWY = new com.baidu.yuyinala.privatemessage.session.c.a();
        this.oWW = (SwipeListView) findViewById(a.f.news_inner_listview);
        if (this.oWY != null) {
            this.oWX = new com.baidu.yuyinala.privatemessage.session.a.a(this, this.oWY.getDataList());
        }
        this.oWW.setListener(new com.baidu.yuyinala.privatemessage.session.view.a() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4
            @Override // com.baidu.yuyinala.privatemessage.session.view.a
            public void s(View view, int i) {
                com.baidu.yuyinala.privatemessage.session.b.a item;
                if (ChatListActivity.this.oWX.getCount() > 0 && (item = ChatListActivity.this.oWX.getItem(i)) != null && (item instanceof j)) {
                    j jVar = (j) item;
                    com.baidu.yuyinala.privatemessage.session.util.a.a(ChatListActivity.this, jVar.name, jVar.oXz, jVar.isMediaRole, ChatListActivity.this.mLiveId, ChatListActivity.this.mGroupId, jVar.paid > 0 ? "80" : "0", jVar.paid, jVar.iconUrl);
                    LogUtils.d("miliao", "entity.isMediaRole：" + jVar.isMediaRole);
                }
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.a
            public boolean G(View view, int i) {
                return false;
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.a
            public void a(int i, View view, final int i2) {
                com.baidu.yuyinala.privatemessage.session.b.a item;
                if (i == a.f.yuyin_tv_chatlist_delete && (item = ChatListActivity.this.oWX.getItem(i2)) != null && (item instanceof j)) {
                    ChatListActivity.this.oWY.a(ChatListActivity.this, (j) item, new IMediaDeleteChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener
                        public void onMediaDeleteChatSessionResult(int i3, String str) {
                            if (i3 == 0) {
                                ChatListActivity.this.oWX.PE(i2);
                                if (ChatListActivity.this.oWX.getCount() == 0) {
                                    ChatListActivity.this.bSi();
                                    return;
                                }
                                return;
                            }
                            ChatListActivity.this.showToast(str);
                        }
                    });
                }
            }
        }, new int[]{a.f.yuyin_tv_chatlist_delete});
        this.oWW.setAdapter((ListAdapter) this.oWX);
        this.oWW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSi() {
        if (this.btg != null && this.oWX != null) {
            this.oWW.setVisibility(8);
            this.btg.setVisibility(0);
            this.btg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_list_empty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eog() {
        if (this.oWX != null && this.btg != null) {
            this.oWW.setVisibility(8);
            this.oWX.setData(null);
            this.oWX.notifyDataSetChanged();
            this.btg.setVisibility(0);
            this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_network_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eoh() {
        this.oWY.a(this, this.oXb, 2);
    }

    /* loaded from: classes4.dex */
    private static class a extends Handler {
        private final WeakReference<ChatListActivity> oXh;

        a(ChatListActivity chatListActivity) {
            this.oXh = new WeakReference<>(chatListActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ChatListActivity chatListActivity = this.oXh.get();
            if (chatListActivity != null) {
                switch (message.what) {
                    case 0:
                        if (((ChatSession) message.obj) != null) {
                            chatListActivity.eoh();
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
    public boolean eoi() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.oWZ <= 0 || currentTimeMillis - this.oWZ > 500) {
            this.oWZ = currentTimeMillis;
            return true;
        }
        return false;
    }

    private void elY() {
        BIMManager.registerChatSessionChangeListener(this, this.oXd);
    }

    private void elZ() {
        BIMManager.unregisterChatSessionChangeListener(this, this.oXd);
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
        MessageManager.getInstance().unRegisterListener(this.oXc);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        c.enX();
        if ("privateletter".equals(this.oXa)) {
            elZ();
            if (this.oWY != null) {
                this.oWY.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        eoh();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
