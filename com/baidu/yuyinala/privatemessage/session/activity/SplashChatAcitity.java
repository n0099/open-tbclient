package com.baidu.yuyinala.privatemessage.session.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatuser.IStatusListener;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.yuyinala.privatemessage.implugin.common.ChatInfo;
import com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat;
import com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c;
import com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d;
import com.baidu.yuyinala.privatemessage.session.b.g;
import com.baidu.yuyinala.privatemessage.session.b.h;
import com.baidu.yuyinala.privatemessage.session.util.a;
import com.baidu.yuyinala.privatemessage.session.view.b;
/* loaded from: classes4.dex */
public class SplashChatAcitity extends ActivityChat {
    public static String oGy = SplashChatAcitity.class.getName();
    public CustomMessageListener bek = new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && !SplashChatAcitity.this.isFinishing()) {
                SplashChatAcitity.this.finish();
            }
        }
    };
    private CustomMessageListener oGs = new CustomMessageListener(2501070) { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && !SplashChatAcitity.this.isFinishing()) {
                SplashChatAcitity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat, com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.bek);
        MessageManager.getInstance().registerListener(this.oGs);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat, com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bek);
        MessageManager.getInstance().unRegisterListener(this.oGs);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat
    protected void hu(long j) {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat
    protected void efS() {
        b bVar = new b(this, ChatInfo.mUid, this.oyk, this.mPaid);
        bVar.a(new b.InterfaceC0958b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.1
            @Override // com.baidu.yuyinala.privatemessage.session.view.b.InterfaceC0958b
            public void eiv() {
                BIMManager.deleteMsgs(SplashChatAcitity.this.getApplicationContext(), 0, ChatInfo.mContacter, false);
                a.hz(ChatInfo.mContacter);
                c XE = d.egN().XE(d.egN().egO());
                if (XE != null) {
                    XE.egk();
                }
                SplashChatAcitity.this.showToast("操作成功");
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.b.InterfaceC0958b
            public void Oc(int i) {
                if (SplashChatAcitity.this.mPaid > 0) {
                    SplashChatAcitity.this.i(SplashChatAcitity.this.mPaid, i, 7);
                } else {
                    SplashChatAcitity.this.i(ChatInfo.mContacter, i, 0);
                }
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.b.InterfaceC0958b
            public void onCancel() {
            }
        });
        bVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(long j, int i, int i2) {
        Log.i("chat_im_setUserBlack", "shieldUid=" + j + "shieldType=" + i + "chatType=" + i2);
        IMBoxManager.setShield(getApplicationContext(), j, i2, i, new IStatusListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.2
            @Override // com.baidu.android.imsdk.chatuser.IStatusListener
            public void onResult(int i3, String str, int i4, long j2) {
                Log.i("chat_im_setUserBlack", "responseCode=" + i3 + "strMsg=" + str);
                if (i3 == 0) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SplashChatAcitity.this.showToast("操作成功");
                        }
                    });
                } else {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            SplashChatAcitity.this.showToast("操作失败");
                        }
                    });
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat
    public void a(String str, final com.baidu.yuyinala.privatemessage.implugin.ui.activity.b bVar) {
        if (!TextUtils.isEmpty(str)) {
            final String encryptionUserId = ExtraParamsManager.getEncryptionUserId(str);
            String XJ = h.eix().XJ(encryptionUserId);
            if (!TextUtils.isEmpty(XJ)) {
                bVar.Xq(XJ);
            }
            h.eix().a(BdBaseApplication.getInst(), encryptionUserId, 3, new g() { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.3
                @Override // com.baidu.yuyinala.privatemessage.session.b.g
                public void aSR() {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bVar != null) {
                                bVar.Xq(encryptionUserId);
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat, com.baidu.live.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat
    protected void efU() {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat, com.baidu.yuyinala.privatemessage.implugin.ui.activity.c
    public void Xy(String str) {
        super.Xy(str);
        char c = 65535;
        switch (str.hashCode()) {
            case -1503905936:
                if (str.equals("invite_link")) {
                    c = 0;
                    break;
                }
                break;
            case -166619280:
                if (str.equals("greet_link")) {
                    c = 1;
                    break;
                }
                break;
            case -8569514:
                if (str.equals("welcom_link")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (this.oyi != null && this.oyi.mInfo != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("params", this.oyi);
                    bundle.putString("groupicon", this.oyi.mInfo.getHeadUrl());
                    return;
                }
                return;
            case 1:
            case 2:
            default:
                return;
        }
    }
}
