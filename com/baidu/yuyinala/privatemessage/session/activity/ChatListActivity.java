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
    private CommonEmptyView bpJ;
    private String mGroupId;
    private String mLiveId;
    private SwipeListView oGm;
    private com.baidu.yuyinala.privatemessage.session.a.a oGn;
    private com.baidu.yuyinala.privatemessage.model.a oGo;
    private long oGp = 0;
    private String oGq = "privateletter";
    private b oGr = new b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.1
        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void Oa(int i) {
            if (ChatListActivity.this.oGo != null) {
                if (ListUtils.isEmpty(ChatListActivity.this.oGo.getDataList())) {
                    ChatListActivity.this.bPe();
                    return;
                }
                ChatListActivity.this.oGm.setVisibility(0);
                ChatListActivity.this.oGn.setData(ChatListActivity.this.oGo.getDataList());
                ChatListActivity.this.oGn.notifyDataSetChanged();
                if (ChatListActivity.this.oGm.getFooterViewsCount() == 0) {
                    ChatListActivity.this.oGm.addFooterView(LayoutInflater.from(ChatListActivity.this).inflate(a.g.yuyin_msg_list_footview, (ViewGroup) ChatListActivity.this.oGm, false));
                }
                ChatListActivity.this.bpJ.setVisibility(8);
            }
        }

        @Override // com.baidu.yuyinala.privatemessage.session.b
        public void w(String str, int i, String str2) {
            ChatListActivity.this.eis();
        }
    };
    private CustomMessageListener oGs = new CustomMessageListener(2501070) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && !ChatListActivity.this.isFinishing()) {
                ChatListActivity.this.finish();
            }
        }
    };
    IChatSessionChangeListener oGt = new IChatSessionChangeListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.5
        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatSessionUpdate(ChatSession chatSession, boolean z) {
            if (ChatListActivity.this.eiu() && chatSession != null) {
                if (chatSession.getChatType() == 0 || chatSession.getChatType() == 3 || chatSession.getChatType() == 4) {
                    ChatListActivity.this.oGu.removeMessages(0);
                    Message obtainMessage = ChatListActivity.this.oGu.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.obj = chatSession;
                    ChatListActivity.this.oGu.sendMessageDelayed(obtainMessage, 100L);
                }
            }
        }

        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatRecordDelete(int i, long j) {
            if (BIMManager.CATEGORY.SINGLEPERSON.getValue() == i || BIMManager.CATEGORY.GROUP.getValue() == i) {
                ChatListActivity.this.oGu.removeMessages(1);
                ChatListActivity.this.oGu.sendEmptyMessageDelayed(1, 500L);
            }
        }
    };
    private a oGu = new a(this);
    public CustomMessageListener bek = new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.6
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
        MessageManager.getInstance().registerListener(this.oGs);
        BIMManager.mediaSetRole(getActivity(), true);
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        setContentView(a.g.yuyin_activity_chat_list);
        eir();
        M(getIntent());
        XQ();
        egm();
        MessageManager.getInstance().registerListener(this.bek);
    }

    private void eir() {
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

    private void XQ() {
        this.bpJ = (CommonEmptyView) findViewById(a.f.yuyin_ala_empty_view);
        this.oGo = new com.baidu.yuyinala.privatemessage.session.c.a();
        this.oGm = (SwipeListView) findViewById(a.f.news_inner_listview);
        if (this.oGo != null) {
            this.oGn = new com.baidu.yuyinala.privatemessage.session.a.a(this, this.oGo.getDataList());
        }
        this.oGm.setListener(new com.baidu.yuyinala.privatemessage.session.view.a() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4
            @Override // com.baidu.yuyinala.privatemessage.session.view.a
            public void p(View view, int i) {
                com.baidu.yuyinala.privatemessage.session.b.a item;
                if (ChatListActivity.this.oGn.getCount() > 0 && (item = ChatListActivity.this.oGn.getItem(i)) != null && (item instanceof j)) {
                    j jVar = (j) item;
                    com.baidu.yuyinala.privatemessage.session.util.a.a(ChatListActivity.this, jVar.name, jVar.oGP, jVar.isMediaRole, ChatListActivity.this.mLiveId, ChatListActivity.this.mGroupId, jVar.paid > 0 ? "80" : "0", jVar.paid, jVar.iconUrl);
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
                if (i == a.f.yuyin_tv_chatlist_delete && (item = ChatListActivity.this.oGn.getItem(i2)) != null && (item instanceof j)) {
                    ChatListActivity.this.oGo.a(ChatListActivity.this, (j) item, new IMediaDeleteChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity.4.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener
                        public void onMediaDeleteChatSessionResult(int i3, String str) {
                            if (i3 == 0) {
                                ChatListActivity.this.oGn.Od(i2);
                                if (ChatListActivity.this.oGn.getCount() == 0) {
                                    ChatListActivity.this.bPe();
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
        this.oGm.setAdapter((ListAdapter) this.oGn);
        this.oGm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPe() {
        if (this.bpJ != null && this.oGn != null) {
            this.oGm.setVisibility(8);
            this.bpJ.setVisibility(0);
            this.bpJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_list_empty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eis() {
        if (this.oGn != null && this.bpJ != null) {
            this.oGm.setVisibility(8);
            this.oGn.setData(null);
            this.oGn.notifyDataSetChanged();
            this.bpJ.setVisibility(0);
            this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK).setTextColor(Color.parseColor("#525252")).setTitle(a.h.yuyin_sdk_privatemsg_network_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eit() {
        this.oGo.a(this, this.oGr, 2);
    }

    /* loaded from: classes4.dex */
    private static class a extends Handler {
        private final WeakReference<ChatListActivity> oGx;

        a(ChatListActivity chatListActivity) {
            this.oGx = new WeakReference<>(chatListActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ChatListActivity chatListActivity = this.oGx.get();
            if (chatListActivity != null) {
                switch (message.what) {
                    case 0:
                        if (((ChatSession) message.obj) != null) {
                            chatListActivity.eit();
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
    public boolean eiu() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.oGp <= 0 || currentTimeMillis - this.oGp > 500) {
            this.oGp = currentTimeMillis;
            return true;
        }
        return false;
    }

    private void egm() {
        BIMManager.registerChatSessionChangeListener(this, this.oGt);
    }

    private void egn() {
        BIMManager.unregisterChatSessionChangeListener(this, this.oGt);
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
        MessageManager.getInstance().unRegisterListener(this.oGs);
        MessageManager.getInstance().unRegisterListener(this.bek);
        c.eik();
        if ("privateletter".equals(this.oGq)) {
            egn();
            if (this.oGo != null) {
                this.oGo.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        eit();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
