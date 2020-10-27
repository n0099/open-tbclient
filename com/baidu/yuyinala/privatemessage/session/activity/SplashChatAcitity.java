package com.baidu.yuyinala.privatemessage.session.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatuser.ChatUserManager;
import com.baidu.android.imsdk.chatuser.IUserPrivacyListener;
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
    public static String oxg = SplashChatAcitity.class.getName();
    public CustomMessageListener bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && !SplashChatAcitity.this.isFinishing()) {
                SplashChatAcitity.this.finish();
            }
        }
    };
    private CustomMessageListener oxa = new CustomMessageListener(2501070) { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.5
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
        MessageManager.getInstance().registerListener(this.bcQ);
        MessageManager.getInstance().registerListener(this.oxa);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat, com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bcQ);
        MessageManager.getInstance().unRegisterListener(this.oxa);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat
    protected void gY(long j) {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat
    protected void ecd() {
        b bVar = new b(this, ChatInfo.mUid, this.ooP, this.mPaid);
        bVar.a(new b.InterfaceC0939b() { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.1
            @Override // com.baidu.yuyinala.privatemessage.session.view.b.InterfaceC0939b
            public void eeG() {
                BIMManager.deleteMsgs(SplashChatAcitity.this.getApplicationContext(), 0, ChatInfo.mContacter, false);
                a.hd(ChatInfo.mContacter);
                c Xa = d.ecY().Xa(d.ecY().ecZ());
                if (Xa != null) {
                    Xa.ecv();
                }
                SplashChatAcitity.this.showToast("操作成功");
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.b.InterfaceC0939b
            public void NH(int i) {
                SplashChatAcitity.this.F(ChatInfo.mUid, i);
            }

            @Override // com.baidu.yuyinala.privatemessage.session.view.b.InterfaceC0939b
            public void onCancel() {
            }
        });
        bVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(long j, int i) {
        ChatUserManager.setUserBlack(getApplicationContext(), j, i, new IUserPrivacyListener() { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.2
            @Override // com.baidu.android.imsdk.chatuser.IUserPrivacyListener
            public void onResult(int i2, String str) {
                if (i2 == 0) {
                    SplashChatAcitity.this.showToast("操作成功");
                } else {
                    SplashChatAcitity.this.showToast("操作失败");
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat
    public void a(String str, final com.baidu.yuyinala.privatemessage.implugin.ui.activity.b bVar) {
        if (!TextUtils.isEmpty(str)) {
            final String encryptionUserId = ExtraParamsManager.getEncryptionUserId(str);
            String Xf = h.eeI().Xf(encryptionUserId);
            if (!TextUtils.isEmpty(Xf)) {
                bVar.WM(Xf);
            }
            h.eeI().a(BdBaseApplication.getInst(), encryptionUserId, 3, new g() { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.3
                @Override // com.baidu.yuyinala.privatemessage.session.b.g
                public void aQr() {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bVar != null) {
                                bVar.WM(encryptionUserId);
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
    protected void ecf() {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat, com.baidu.yuyinala.privatemessage.implugin.ui.activity.c
    public void WU(String str) {
        super.WU(str);
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
                if (this.ooN != null && this.ooN.mInfo != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("params", this.ooN);
                    bundle.putString("groupicon", this.ooN.mInfo.getHeadUrl());
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
