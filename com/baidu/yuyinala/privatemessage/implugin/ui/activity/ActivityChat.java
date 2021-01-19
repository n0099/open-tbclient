package com.baidu.yuyinala.privatemessage.implugin.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.chatuser.UserStatus;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.pubaccount.IGetPaInfoListener;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.megapp.ma.MAFragmentActivity;
import com.baidu.yuyinala.privatemessage.implugin.common.ChatInfo;
import com.baidu.yuyinala.privatemessage.implugin.d.b;
import com.baidu.yuyinala.privatemessage.implugin.entity.ImBaseEntity;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
import com.baidu.yuyinala.privatemessage.model.group.QMGroupInfo;
import com.baidu.yuyinala.privatemessage.model.http.YuyinAlaAudioUserGetPaBindInfoResponseMessage;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ActivityChat extends BaseFragmentActivity implements com.baidu.yuyinala.privatemessage.implugin.ui.activity.a, com.baidu.yuyinala.privatemessage.implugin.ui.activity.c, ThemeManager.a {
    public static boolean oQG;
    protected String aQm;
    protected boolean isFollowed;
    private LinearLayout mContainer;
    private String mGroupId;
    private String mIcon;
    private String mLiveId;
    private String mNickName;
    private PaInfo mPaInfo;
    public long mPaid;
    private ImageView oQA;
    private ImageView oQB;
    private ChatUser oQC;
    protected QMGroupInfo oQD;
    protected long oQE;
    public boolean oQF;
    private Animation oQI;
    private Animation oQJ;
    private String oQM;
    private UserStatus oQN;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c oQO;
    protected ImBaseEntity oQP;
    private com.baidu.yuyinala.privatemessage.implugin.ui.a.a oQQ;
    private long oQT;
    private RelativeLayout oQj;
    private View oQk;
    private TextView oQl;
    private TextView oQm;
    private TextView oQn;
    private View oQo;
    private FrameLayout oQp;
    private FrameLayout oQq;
    private LinearLayout oQr;
    private RelativeLayout oQs;
    private FrameLayout oQt;
    private FrameLayout oQu;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a oQv;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b oQw;
    private LinearLayout oQx;
    private TextView oQy;
    private ImageView oQz;
    private int kdg = 0;
    public boolean oQH = false;
    private int mChatStatus = 1;
    private String mListenerKey = "";
    private int oQK = -1;
    private long oQL = -1;
    private c oQR = new c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.1
        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.c
        public void ehV() {
            ActivityChat.this.oQS.sendEmptyMessage(1002);
        }
    };
    private f oQS = new f();
    private boolean oQU = false;
    private View.OnClickListener oQV = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().getLoginState(ActivityChat.this);
            ActivityChat.this.oQT = System.currentTimeMillis();
            ActivityChat.this.oQU = false;
            if (loginState == 3) {
                ActivityChat.this.oQS.removeCallbacks(ActivityChat.this.gaM);
                ActivityChat.this.oQS.postDelayed(ActivityChat.this.gaM, ActivityChat.this.ehB());
                ActivityChat.this.oQu.setVisibility(8);
                ActivityChat.this.init(ActivityChat.this.getIntent());
                return;
            }
            ActivityChat.this.oQS.postDelayed(ActivityChat.this.gaM, 7000L);
            ActivityChat.this.ehC();
        }
    };
    private Runnable gaM = new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mTimeOutRunnable run ");
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().getLoginState(ActivityChat.this) != 3) {
                ActivityChat.this.oQU = true;
                ActivityChat.this.ehD();
                return;
            }
            ActivityChat.this.ehE();
        }
    };
    private h oQW = new h();
    private View.OnClickListener oQX = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChat.this.ehQ();
            if (ActivityChat.this.mChatStatus == 0 && ActivityChat.this.oQw != null) {
                ActivityChat.this.oQw.eiB();
            }
        }
    };
    private l oQY = new l();
    private k oQZ = new k();
    private j oRa = new j();
    private a oRb = new a();
    private b oRc = new b();
    d oRd = new d();
    e oRe = new e();

    /* loaded from: classes10.dex */
    public interface c {
        void ehV();
    }

    public String getLiveId() {
        return this.mLiveId;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public void a(String str, com.baidu.yuyinala.privatemessage.implugin.ui.activity.b bVar) {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.c
    public void Xg(String str) {
        if ("greet_link".equals(str)) {
            String eia = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.eia();
            String str2 = "";
            if (!TextUtils.isEmpty(ChatInfo.nickname)) {
                str2 = ChatInfo.nickname;
            } else if (!TextUtils.isEmpty(ChatInfo.displayname)) {
                str2 = ChatInfo.displayname;
            }
            com.baidu.yuyinala.privatemessage.model.message.a.ekk().E(this, eia.replace("XXX", str2), this.mListenerKey);
        } else if ("welcom_link".equals(str)) {
            com.baidu.yuyinala.privatemessage.model.message.a.ekk().E(this, com.baidu.yuyinala.privatemessage.implugin.ui.common.b.eib(), this.mListenerKey);
        }
    }

    public f ehz() {
        return this.oQS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class f extends Handler {
        private final SoftReference<ActivityChat> oRj;

        private f(ActivityChat activityChat) {
            this.oRj = new SoftReference<>(activityChat);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = null;
            int i = 0;
            boolean z = false;
            super.handleMessage(message);
            if (this.oRj.get() != null) {
                try {
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.oRj.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "current is no support");
                        this.oRj.get().oQr.setVisibility(4);
                        ChatInfo.mStatus = 10;
                        if (this.oRj.get().oQw != null) {
                            this.oRj.get().oQw.eiv();
                        }
                        if (this.oRj.get().oQv != null) {
                            this.oRj.get().oQv.eiv();
                            return;
                        }
                        return;
                    case 2:
                        if (message.arg1 == 1) {
                            com.baidu.yuyinala.privatemessage.implugin.f.j.Ar(true);
                            postDelayed(new i(this.oRj), 1000L);
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().bx(this.oRj.get().getApplicationContext(), this.oRj.get().getString(a.h.bd_im_zhida_success_tip));
                            if (this.oRj.get().oQO != null) {
                                this.oRj.get().oQO.dismiss();
                            }
                            String ehw = com.baidu.yuyinala.privatemessage.implugin.f.j.ehw();
                            if (!TextUtils.isEmpty(ehw)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("sign", "media_" + ehw);
                                    jSONObject.put("relation", 1);
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().B(this.oRj.get().getApplicationContext(), "com.baidu.channel.subscribe", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
                                    return;
                                } catch (UnsupportedEncodingException e2) {
                                    e2.printStackTrace();
                                    return;
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            this.oRj.get();
                            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "sendAPSBroadcast thirdId is empty!");
                            return;
                        }
                        try {
                            JSONObject jSONObject2 = new JSONObject((String) message.obj);
                            i = jSONObject2.optInt(BaseJsonData.TAG_ERRNO);
                            str = jSONObject2.optString(BaseJsonData.TAG_ERRMSG);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        if (i == 800200 && !TextUtils.isEmpty(str)) {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().bw(this.oRj.get().getApplicationContext(), str);
                            return;
                        } else {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().bw(this.oRj.get().getApplicationContext(), this.oRj.get().getString(a.h.bd_im_subscribe_fail_tip));
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                        return;
                    case 3:
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().showToast(this.oRj.get().getApplicationContext(), this.oRj.get().getString(a.h.bd_im_zhida_fail_net_tip));
                        return;
                    case 5:
                        this.oRj.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 1 ");
                        this.oRj.get().finish();
                        this.oRj.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 2 ");
                        return;
                    case 6:
                        Bundle data = message.getData();
                        String str2 = "";
                        if (data != null) {
                            str2 = data.getString("subscribe_data");
                            z = data.getBoolean("update_subscribe", false);
                        }
                        com.baidu.yuyinala.privatemessage.implugin.f.j.Xd(str2);
                        ChatInfo.mPainfo.setMsgNotify(com.baidu.yuyinala.privatemessage.implugin.f.j.isNeedNotify());
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.ehx() || !z) {
                            if (this.oRj.get().oQO != null && this.oRj.get().oQO.eiV()) {
                                this.oRj.get().oQO.dismiss();
                            }
                        } else {
                            this.oRj.get().Ni(1);
                        }
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.getData() != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.b.D(this.oRj.get().getApplicationContext(), String.valueOf(this.oRj.get().mPaid), com.baidu.yuyinala.privatemessage.implugin.f.j.getData().toString());
                            return;
                        }
                        return;
                    case 7:
                        this.oRj.get().Ni(0);
                        return;
                    case 8:
                        if (message.arg1 == 0) {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().bw(this.oRj.get(), "关注成功");
                            this.oRj.get().oQO.dismiss();
                            this.oRj.get().ehS();
                            this.oRj.get().isFollowed = true;
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().bw(this.oRj.get(), "关注失败");
                        return;
                    case 1001:
                        if (this.oRj.get().oQx != null && this.oRj.get().oQx.getVisibility() == 0) {
                            this.oRj.get().oQx.setAnimation(AnimationUtils.loadAnimation(this.oRj.get(), a.C0194a.bd_im_slip_out_from_right));
                            this.oRj.get().oQx.setVisibility(4);
                            return;
                        }
                        return;
                    case 1002:
                        this.oRj.get().ehH();
                        return;
                    case 1003:
                        if (this.oRj.get().oQz != null && this.oRj.get().oQz.getVisibility() == 0) {
                            this.oRj.get().oQz.setAnimation(AnimationUtils.loadAnimation(this.oRj.get(), a.C0194a.bd_im_disappear_out));
                            this.oRj.get().oQz.setVisibility(4);
                            return;
                        }
                        return;
                    case 1006:
                        this.oRj.get().oQr.setVisibility(4);
                        ChatInfo.mStatus = 11;
                        if (this.oRj.get().oQw != null) {
                            this.oRj.get().oQw.eiv();
                        }
                        this.oRj.get().oQt.setVisibility(0);
                        return;
                    case 1007:
                    case 1008:
                        return;
                    case 1009:
                        if (this.oRj.get().oQv != null) {
                            this.oRj.get().oQv.Au(false);
                        }
                        this.oRj.get().oQu.setVisibility(8);
                        this.oRj.get().init(this.oRj.get().getIntent());
                        return;
                    case 1010:
                        if (this.oRj.get().oQv != null) {
                            this.oRj.get().oQv.Au(true);
                        }
                        if (this.oRj.get().oQw != null) {
                            this.oRj.get().oQw.eiv();
                            return;
                        }
                        return;
                    case 1011:
                        this.oRj.get().oQr.setVisibility(4);
                        ChatInfo.mStatus = 12;
                        if (this.oRj.get().oQw != null) {
                            this.oRj.get().oQw.eiv();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class i implements Runnable {
        private final SoftReference<ActivityChat> oRj;

        private i(SoftReference<ActivityChat> softReference) {
            this.oRj = softReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRj.get() != null) {
                this.oRj.get().w(this.oRj.get().mPaid, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BIMManager.mediaSetRole(getActivity(), true);
        ehN();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        setContentView(a.g.bd_im_chat_activity_layout);
        this.mContainer = (LinearLayout) findViewById(a.f.bd_im_chat_root);
        this.oQQ = new com.baidu.yuyinala.privatemessage.implugin.ui.a.a();
        ehP();
        init(getIntent());
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().isCuidLogin(this) || com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().eht()) {
            this.oQH = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    private void ehA() {
        this.oQT = System.currentTimeMillis();
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "loginOver loginState: " + loginState);
        if (this.oQv != null) {
            this.oQv.eiw();
        }
        switch (loginState) {
            case 2:
                this.oQS.postDelayed(this.gaM, 7000L);
                ehC();
                return;
            case 3:
                this.oQS.postDelayed(this.gaM, ehB());
                this.oQu.setVisibility(8);
                this.oQS.sendEmptyMessage(1009);
                return;
            default:
                this.oQS.postDelayed(this.gaM, 7000L);
                ehF();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ehB() {
        long currentTimeMillis = 10000 - (System.currentTimeMillis() - this.oQT);
        if (currentTimeMillis > 7000) {
            return 7000L;
        }
        return currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehC() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "retryLogin timeout " + this.oQU);
        if (!this.oQU) {
            this.oQS.sendEmptyMessage(1010);
            com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().a(this, new b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.13
                @Override // com.baidu.android.imsdk.account.ILoginListener
                public void onLoginResult(int i2, String str) {
                }

                @Override // com.baidu.android.imsdk.account.ILoginListener
                public void onLogoutResult(int i2, String str, int i3) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehD() {
        if (this.oQv != null) {
            this.oQv.Au(false);
        }
        if (this.oQw != null) {
            this.oQw.eiv();
        }
        this.oQu.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehE() {
        if (this.oQv != null) {
            this.oQv.Au(false);
        }
    }

    private void ehF() {
        this.oQS.sendEmptyMessage(1010);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus ");
        com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().a(this, new b.e() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.14
            @Override // com.baidu.android.imsdk.account.ILoginStateChangedListener
            public void onLoginStateChanged(int i2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus onLoginStateChanged state: " + i2);
                switch (i2) {
                    case 2:
                        ActivityChat.this.ehC();
                        return;
                    case 3:
                        ActivityChat.this.oQS.removeCallbacks(ActivityChat.this.gaM);
                        ActivityChat.this.oQS.postDelayed(ActivityChat.this.gaM, ActivityChat.this.ehB());
                        ActivityChat.this.oQS.sendEmptyMessage(1009);
                        return;
                    default:
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "waitting");
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehG() {
        if (this.kdg > 8) {
            if (this.oQx == null) {
                this.oQx = (LinearLayout) findViewById(a.f.bd_im_chat_unread_msgs_layout);
                this.oQy = (TextView) findViewById(a.f.bd_im_chat_unread_msgs_txt);
                this.oQy.setText(this.kdg + getString(a.h.bd_im_alert_unread_msgs));
            }
            this.oQA = (ImageView) findViewById(a.f.bd_im_chat_unread_msgs_up);
            try {
                this.oQx.setBackgroundResource(ThemeManager.U(this, a.e.bd_im_chat_unread_msgs_background));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.oQx.setAnimation(AnimationUtils.loadAnimation(this, a.C0194a.bd_im_slip_in_from_right));
            this.oQx.setVisibility(0);
            this.oQx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.oQv.Nj(ActivityChat.this.kdg);
                    ActivityChat.this.oQx.setAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0194a.bd_im_slip_out_from_right));
                    ActivityChat.this.oQx.setVisibility(4);
                }
            });
            this.oQS.sendEmptyMessageDelayed(1001, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehH() {
        if (this.oQz == null) {
            this.oQz = (ImageView) findViewById(a.f.bd_im_chat_new_msgs_tip);
            this.oQz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.oQv.eil();
                    ActivityChat.this.oQz.startAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0194a.bd_im_disappear_out));
                    ActivityChat.this.oQz.setVisibility(4);
                }
            });
        }
        if (this.oQz.getVisibility() != 0) {
            this.oQz.startAnimation(AnimationUtils.loadAnimation(this, a.C0194a.bd_im_disappear_in));
            this.oQz.setVisibility(0);
        }
        this.oQS.removeMessages(1003);
        this.oQS.sendEmptyMessageDelayed(1003, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "new intent" + intent.toString());
        init(intent);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        switch (ChatInfo.oPg) {
            case GROUP:
                com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().setAllMsgRead(getApplicationContext(), 1, ChatInfo.mContacter, false);
                break;
            default:
                BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
                break;
        }
        try {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.eiN();
            com.baidu.yuyinala.privatemessage.implugin.imagechooser.a.ehq();
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().c(this, th);
        }
        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().dismiss();
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mChatCategory " + ChatInfo.oPg + " mOnlineStatus " + this.oQN);
        if (ChatInfo.oPg == ChatInfo.ChatCategory.C2C && this.oQN != null) {
            ehI();
        }
        if (this.oQv != null) {
            this.oQv.a((com.baidu.yuyinala.privatemessage.implugin.ui.activity.a) null);
        }
        if (this.oQw != null) {
            this.oQw.onDestroy();
        }
        if (this.oQv != null) {
            this.oQv.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i2) {
    }

    private void ehI() {
        Intent intent = new Intent(IMConstants.NOTICE_USER_STATE);
        intent.putExtra(IMConstants.NOTICE_USER_STATE_OBJECT, this.oQN);
        sendBroadcast(intent);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "noticeSessionState com.baidu.android.imsdk.notice.userstate");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onResume--->");
        super.onResume();
        com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().Aq(true);
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onResume mIsCuidOrIncompleteLogin: " + this.oQH + " loginState: " + loginState);
        if (this.oQH && (!com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().isCuidLogin(this) || !com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().eht() || (loginState != 0 && loginState != 3))) {
            ehA();
        } else if (this.oQO != null && this.oQO.eiV() && ChatInfo.ChatCategory.DUZHAN == ChatInfo.oPg) {
            w(this.mPaid, true);
        }
        if (this.oQw != null) {
            this.oQw.onResume();
        }
        if (this.oQv != null) {
            this.oQv.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStop--->");
        super.onStop();
        if (this.oQw != null) {
            this.oQw.onStop();
        }
        if (this.oQv != null) {
            this.oQv.onStop();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStop");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStart--->");
        super.onStart();
        if (this.oQw != null) {
            this.oQw.onStart();
        }
        if (this.oQv != null) {
            this.oQv.onStart();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStart");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onPause--->");
        super.onPause();
        com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().Aq(false);
        if (this.oQw != null) {
            this.oQw.onPause();
        }
        if (this.oQv != null) {
            this.oQv.onPause();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<----onPause");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        onBackClick();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        super.dispatchKeyEvent(keyEvent);
        return false;
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    @SuppressLint({"Override"})
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    private String aw(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            this.aQm = ExtraParamsManager.getEncryptionUserId(extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWT));
            this.oQF = extras.getBoolean("isMediaRole");
            this.mGroupId = extras.getString("groupid");
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("miliao", "mIsmediaRole：" + this.oQF);
            this.mLiveId = extras.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            oQG = this.oQF;
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oWT, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWT));
            jSONObject.put("paid", extras.getString("paid"));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oWV, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWV));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oWX, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWX));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oWW, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWW));
            String jSONObject2 = jSONObject.toString();
            try {
                if (!TextUtils.isEmpty(extras.getString("action"))) {
                    Serializable serializable = extras.getSerializable("params");
                    if (serializable instanceof ImBaseEntity) {
                        this.oQP = (ImBaseEntity) serializable;
                        if (this.oQD == null) {
                            GroupInfo groupInfo = new GroupInfo(String.valueOf(this.oQP.id));
                            groupInfo.setGroupName(this.oQP.name);
                            groupInfo.setDescription(this.oQP.description);
                            groupInfo.setHeadUrl(this.oQP.headUrl);
                            this.oQD = new QMGroupInfo(groupInfo);
                        }
                    }
                }
                return jSONObject2;
            } catch (Exception e2) {
                return jSONObject2;
            }
        } catch (Exception e3) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init(Intent intent) {
        long parseLong;
        initViews();
        ehL();
        String aw = aw(intent);
        if (this.oQr != null) {
            if (this.oQF) {
                this.oQr.setVisibility(8);
            } else {
                this.oQr.setVisibility(0);
            }
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + aw);
        ChatInfo.mContacter = -1L;
        ChatInfo.oPi = -1L;
        ChatInfo.mAppid = -1L;
        ChatInfo.mUid = -1L;
        ChatInfo.oPj = "";
        ChatInfo.oPk = "";
        ChatInfo.oPl = -1;
        ChatInfo.oPp = 0;
        ChatInfo.oPs = true;
        ChatInfo.oPr = false;
        try {
            JSONObject jSONObject = new JSONObject(aw);
            int i2 = jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.oWW) ? jSONObject.getInt(com.baidu.yuyinala.privatemessage.implugin.util.d.oWW) : -1;
            if (i2 == -1) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "invoke error -1");
                return;
            }
            if (i2 == 80) {
                parseLong = Long.parseLong(jSONObject.optString("paid", "-1"));
            } else {
                parseLong = Long.parseLong(jSONObject.optString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWT, "-1"));
            }
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + aw);
            if (this.oQK != -1 && (this.oQK != i2 || this.oQL != parseLong)) {
                if (this.oQv != null) {
                    this.oQv.eiw();
                }
                if (this.oQm != null) {
                    this.oQm.setText("");
                }
            }
            this.oQK = i2;
            switch (i2) {
                case 0:
                    ChatInfo.oPg = ChatInfo.ChatCategory.C2C;
                    try {
                        this.oQE = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWT));
                        ChatInfo.mUid = this.oQE;
                        ehK();
                        this.mNickName = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWV);
                        this.mIcon = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWX);
                        if (jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.oWZ)) {
                            ChatInfo.oPs = jSONObject.getBoolean(com.baidu.yuyinala.privatemessage.implugin.util.d.oWZ);
                        }
                    } catch (Exception e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "init uid and name error");
                    }
                    this.oQn.setVisibility(8);
                    this.mListenerKey = String.valueOf(this.oQE);
                    Xh(this.mNickName);
                    hV(this.oQE);
                    return;
                case 80:
                    ChatInfo.oPg = ChatInfo.ChatCategory.DUZHAN;
                    eP(jSONObject);
                    return;
                case 10000:
                    if (this != null && !isFinishing()) {
                        finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e3) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "Exception : " + e3.getMessage());
            Log.e(MAFragmentActivity.TAG, e3.getMessage() + "");
            com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().c(this, e3);
        }
    }

    private void eP(JSONObject jSONObject) {
        try {
            this.mPaid = Long.parseLong(jSONObject.getString("paid"));
            ChatInfo.mPaid = this.mPaid;
            if (this.oQF) {
                long parseLong = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWT));
                if (parseLong > 0) {
                    ChatInfo.mUid = parseLong;
                }
            }
            ehM();
        } catch (Exception e2) {
            LogUtils.e(MAFragmentActivity.TAG, "init appid error");
        }
        this.mListenerKey = String.valueOf(this.mPaid);
        hU(this.mPaid);
    }

    private void hU(long j2) {
        this.oQn.setVisibility(8);
        if (j2 <= 0) {
            this.mPaInfo = null;
            showToast(a.h.bd_im_read_error);
            return;
        }
        this.mPaInfo = PaManager.getPaInfo(getApplicationContext(), j2);
        if (this.mPaInfo == null) {
            PaManagerImpl.getInstance(this).getPaInfo(j2, new IGetPaInfoListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.17
                @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfoListener
                public void onGetPaInfoResult(int i2, String str, PaInfo paInfo) {
                    LogUtils.d("FXF", "get painfo " + paInfo.toString() + " thread " + Thread.currentThread().getId());
                    ActivityChat.this.mPaInfo = paInfo;
                    ActivityChat.this.oQS.post(ActivityChat.this.oQW);
                }
            });
        } else {
            this.oQS.post(this.oQW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class h implements Runnable {
        private final SoftReference<ActivityChat> oRk;

        private h(ActivityChat activityChat) {
            this.oRk = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRk.get() != null) {
                try {
                    ChatInfo.oPi = AccountManager.getUK(this.oRk.get().getApplicationContext());
                    this.oRk.get();
                    LogUtils.d(MAFragmentActivity.TAG, "parunnable ---> " + ChatInfo.oPi);
                    if (ChatInfo.oPi != -1) {
                        this.oRk.get().mChatStatus = 0;
                        this.oRk.get().ehJ();
                        this.oRk.get();
                        LogUtils.d(MAFragmentActivity.TAG, "parunnable -->1");
                        ChatInfo.mContacter = this.oRk.get().mPaInfo.getPaId();
                        ChatInfo.mPainfo = this.oRk.get().mPaInfo;
                        if (ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN) {
                            this.oRk.get().kdg = ChatMsgManager.getUnReadMsgCountByPaid(this.oRk.get(), this.oRk.get().mPaid);
                            if (this.oRk.get().kdg > 200) {
                                this.oRk.get().kdg = 200;
                            }
                        }
                        this.oRk.get().SN();
                        this.oRk.get().w(this.oRk.get().mPaid, true);
                    } else {
                        this.oRk.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    this.oRk.get().oQM = TextUtils.isEmpty(this.oRk.get().oQM) ? this.oRk.get().mPaInfo.getNickName() : this.oRk.get().oQM;
                    this.oRk.get().oQm.setText(String.valueOf(this.oRk.get().oQM));
                    this.oRk.get().ehG();
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehJ() {
        com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().a(getActivity(), new IGetUsersProfileBatchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.18
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2) {
                if (i2 == 0 && arrayList2 != null && arrayList2.size() == 1) {
                    ChatInfo.oPj = ActivityChat.this.Xj(arrayList2.get(0).getIconUrl());
                    ChatInfo.displayname = arrayList2.get(0).getUserName();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehK() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.b(ExtraParamsManager.getEncryptionUserId(ChatInfo.mUid + "")));
    }

    private static void ehL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031061, com.baidu.live.a.avU + "ala/audio/user/preFollow");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void ehM() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.a(ExtraParamsManager.getEncryptionUserId(this.mPaid + "")));
    }

    private void ehN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031067, com.baidu.live.a.avU + "ala/audio/user/getPaBindInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(YuyinAlaAudioUserGetPaBindInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(new HttpMessageListener(1031067) { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof YuyinAlaAudioUserGetPaBindInfoResponseMessage)) {
                    if (httpResponsedMessage.getError() == 0 || httpResponsedMessage.isSuccess()) {
                        ChatInfo.mUid = Long.parseLong(ExtraParamsManager.getDecryptUserId(((YuyinAlaAudioUserGetPaBindInfoResponseMessage) httpResponsedMessage).uk));
                        ActivityChat.this.ehK();
                    }
                }
            }
        });
    }

    public boolean ehO() {
        return this.oQK == 2 || this.oQK == 11;
    }

    private void initViews() {
        findViewById(a.f.yuyin_privatechat_empty_location).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ActivityChat.this.finish();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
                return true;
            }
        });
        this.oQj = (RelativeLayout) findViewById(a.f.bd_im_chat_title_root);
        this.oQk = findViewById(a.f.bd_im_chat_cell_space_line);
        this.oQl = (TextView) findViewById(a.f.bd_im_chat_open_main);
        this.oQr = (LinearLayout) findViewById(a.f.bd_im_chat_open_main_click_parent);
        this.oQr.setOnClickListener(this.oQX);
        this.oQs = (RelativeLayout) findViewById(a.f.bd_im_chat_back_layout);
        this.oQs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.onBackClick();
            }
        });
        this.oQm = (TextView) findViewById(a.f.bd_im_chat_title);
        this.oQn = (TextView) findViewById(a.f.bd_im_chat_subtitle);
        this.oQo = findViewById(a.f.bd_im_chat_main_input);
        this.oQp = (FrameLayout) findViewById(a.f.bd_im_chat_main_content);
        this.oQq = (FrameLayout) findViewById(a.f.bd_im_chat_main_input);
        this.oQt = (FrameLayout) findViewById(a.f.bd_im_chat_main_error_content);
        this.oQB = (ImageView) findViewById(a.f.bd_im_chat_main_error_image);
        this.oQt.setVisibility(8);
        this.oQu = (FrameLayout) findViewById(a.f.bd_im_chat_main_retry_content);
        this.oQu.setVisibility(8);
        findViewById(a.f.bd_im_chat_main_retry_button).setOnClickListener(this.oQV);
        this.oQm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.ehT();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SN() {
        if (this.oQv == null) {
            FrameLayout frameLayout = this.oQp;
            this.oQp.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_chat, null));
            this.oQv = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.a(this, this.oQp, this.mListenerKey, this.oQR, this.kdg);
        }
        if (this.oQw == null) {
            FrameLayout frameLayout2 = this.oQq;
            this.oQq.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_input, null));
            this.oQw = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.a(this, this.oQq, this.mListenerKey, this.oQR);
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "initFragment : ");
        if (!isFinishing()) {
            try {
                com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "mTransaction.commitAllowingStateLoss() : ");
            } catch (Exception e2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "e :" + e2);
                com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().c(this, e2);
            }
        }
        if (this.oQv != null) {
            this.oQv.a(this);
        }
        hW(this.oQE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void ehP() {
        this.oQI = AnimationUtils.loadAnimation(this, a.C0194a.bd_im_fragment_in_from_bottom);
        this.oQJ = AnimationUtils.loadAnimation(this, a.C0194a.bd_im_fragment_out_to_bottom);
    }

    private void hV(long j2) {
        if (j2 == 0) {
            this.oQC = null;
            showToast(a.h.bd_im_read_error);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j2));
        final SoftReference softReference = new SoftReference(this);
        com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().a(getApplicationContext(), arrayList, false, new b.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList2, ArrayList<ChatUser> arrayList3) {
                if (softReference.get() != null) {
                    if (i2 != 0) {
                        ((ActivityChat) softReference.get()).oQS.post(ActivityChat.this.oRb);
                        return;
                    }
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        ((ActivityChat) softReference.get()).oQC = arrayList3.get(0);
                    }
                    if (((ActivityChat) softReference.get()).oQC == null) {
                        ((ActivityChat) softReference.get()).oQS.post(ActivityChat.this.oRa);
                        return;
                    }
                    ArrayList<Long> arrayList4 = new ArrayList<>();
                    arrayList4.add(Long.valueOf(ActivityChat.this.oQC.getUk()));
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().a(ActivityChat.this.getApplicationContext(), arrayList4, new b.InterfaceC0962b() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7.1
                        @Override // com.baidu.android.imsdk.chatuser.IGetUserStatusListener
                        public void onGetUsersStatusResult(int i3, String str2, ArrayList<UserStatus> arrayList5) {
                            if (i3 == 0 && arrayList5.size() == 1) {
                                ((ActivityChat) softReference.get()).oQN = arrayList5.get(0);
                                ((ActivityChat) softReference.get()).oQS.post(ActivityChat.this.oQY);
                            }
                        }
                    });
                    ((ActivityChat) softReference.get()).oQS.post(ActivityChat.this.oQZ);
                }
            }
        });
        com.baidu.yuyinala.privatemessage.implugin.f.k.hz(getApplicationContext()).b(j2, new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.8
            @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
            public void d(int i2, String str, long j3) {
                try {
                    LogUtils.d(MAFragmentActivity.TAG, "getUserSubscribe->" + str);
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1) == 0) {
                        JSONArray jSONArray = jSONObject.optJSONObject("data").getJSONArray("items");
                        if (jSONArray == null || jSONArray.length() < 1) {
                            ActivityChat.this.oQS.sendEmptyMessageDelayed(7, 1000L);
                        } else if (jSONArray.length() > 1) {
                            LogUtils.d(MAFragmentActivity.TAG, "getUserSubscribe->items->" + jSONArray.toString());
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
        try {
            com.baidu.yuyinala.privatemessage.implugin.e.a.hy(getApplicationContext()).gY("542", "chat_flow_time");
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
        }
    }

    protected void hW(long j2) {
    }

    protected void ehQ() {
    }

    public ImBaseEntity ehR() {
        return this.oQP;
    }

    protected void ehS() {
    }

    protected void Xh(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oQm.setText(str);
        } else if (this.mNickName != null) {
            this.oQm.setText(String.valueOf(this.mNickName));
        } else if (this.oQC != null) {
            this.oQm.setText(String.valueOf(this.oQC.getUserName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehT() {
        String liveId = getLiveId();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getActivity(), ChatInfo.mUid + "", null, null, null, 0, 0, null, null, 0L, 0L, 0L, 0, getGroupId(), liveId, false, null, null, null, null, null)));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
    }

    /* loaded from: classes10.dex */
    private static class l implements Runnable {
        private final SoftReference<ActivityChat> oRj;

        private l(ActivityChat activityChat) {
            this.oRj = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes10.dex */
    private static class k implements Runnable {
        private final SoftReference<ActivityChat> oRj;

        private k(ActivityChat activityChat) {
            this.oRj = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRj.get() != null) {
                try {
                    ChatInfo.oPi = AccountManager.getUK(this.oRj.get().getApplicationContext());
                    if (ChatInfo.oPi != -1) {
                        this.oRj.get().mChatStatus = 0;
                        this.oRj.get().ehU();
                        this.oRj.get().SN();
                        this.oRj.get().hX(this.oRj.get().oQE);
                    } else {
                        this.oRj.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    if (this.oRj.get().mNickName == null) {
                        if (this.oRj.get().oQC != null) {
                            this.oRj.get().oQm.setText(String.valueOf(this.oRj.get().oQC.getUserName()));
                            return;
                        }
                        return;
                    }
                    this.oRj.get().oQm.setText(String.valueOf(this.oRj.get().mNickName));
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hX(long j2) {
        if (Xi(String.valueOf(j2))) {
        }
    }

    private boolean Xi(String str) {
        String C = com.baidu.yuyinala.privatemessage.implugin.util.c.b.C(getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXt, null);
        boolean z = false;
        if (!TextUtils.isEmpty(C)) {
            try {
                JSONObject jSONObject = new JSONObject(C);
                if (jSONObject.has(str)) {
                    z = jSONObject.getBoolean(str);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        LogUtils.i(MAFragmentActivity.TAG, "is support IM:" + z + " data:" + C);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehU() {
        ehJ();
        ChatInfo.mContacter = this.oQC.getUk();
        ChatInfo.mUid = this.oQC.getBuid();
        ChatInfo.mStatus = 3;
        ChatInfo.oPh = this.oQC.getUserName();
        if (!TextUtils.isEmpty(this.mIcon)) {
            ChatInfo.oPk = this.mIcon;
        } else {
            ChatInfo.oPk = Xj(this.oQC.getIconUrl());
        }
        BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
        LogUtils.i(MAFragmentActivity.TAG, "uk:" + ChatInfo.oPi);
        LogUtils.i(MAFragmentActivity.TAG, "header:" + ChatInfo.oPj);
        LogUtils.i(MAFragmentActivity.TAG, "" + this.oQC.toString());
    }

    /* loaded from: classes10.dex */
    private static class j implements Runnable {
        private final SoftReference<ActivityChat> oRj;

        private j(ActivityChat activityChat) {
            this.oRj = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRj.get() != null) {
                try {
                    ChatInfo.oPi = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().hu(this.oRj.get().getApplicationContext()).longValue();
                    this.oRj.get().mChatStatus = 0;
                    this.oRj.get().SN();
                    if (this.oRj.get().mNickName != null) {
                        this.oRj.get().oQm.setText(String.valueOf(this.oRj.get().mNickName));
                    }
                    this.oRj.get().oQS.sendEmptyMessage(1);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        private final SoftReference<ActivityChat> oRj;

        private a(ActivityChat activityChat) {
            this.oRj = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRj.get() != null) {
                try {
                    ChatInfo.oPi = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().hu(this.oRj.get().getApplicationContext()).longValue();
                    this.oRj.get().mChatStatus = 1;
                    this.oRj.get().SN();
                    if (this.oRj.get().mNickName != null) {
                        this.oRj.get().oQm.setText(String.valueOf(this.oRj.get().mNickName));
                    }
                    this.oRj.get().oQS.sendEmptyMessage(1006);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class b implements Runnable {
        private final SoftReference<ActivityChat> oRj;

        private b(ActivityChat activityChat) {
            this.oRj = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRj.get() != null) {
                try {
                    ChatInfo.oPi = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().hu(this.oRj.get().getApplicationContext()).longValue();
                    String str = null;
                    if (this.oRj.get().oQD != null) {
                        str = this.oRj.get().oQD.mInfo.getGroupName();
                    }
                    if (ChatInfo.oPl == 2) {
                        if (str == null || "".equals(str.trim())) {
                            if (this.oRj.get().mNickName != null) {
                                this.oRj.get().oQm.setText(String.valueOf(this.oRj.get().mNickName));
                                return;
                            } else if (this.oRj.get().oQD != null) {
                                this.oRj.get().oQm.setText(String.valueOf(str));
                                return;
                            } else {
                                return;
                            }
                        }
                        this.oRj.get().oQm.setText(String.valueOf(str));
                    } else if (!TextUtils.isEmpty(str)) {
                        this.oRj.get().oQm.setText(String.valueOf(str));
                        this.oRj.get().oQn.setText(this.oRj.get().oQD.mInfo.getNum() + "人");
                    } else if (!TextUtils.isEmpty(this.oRj.get().mNickName)) {
                        this.oRj.get().oQm.setText(String.valueOf(this.oRj.get().mNickName));
                        this.oRj.get().oQn.setText(this.oRj.get().oQD.mInfo.getNum() + "人");
                    } else if (this.oRj.get().oQD != null) {
                        this.oRj.get().oQm.setText("未知群");
                        this.oRj.get().oQn.setText(this.oRj.get().oQD.mInfo.getNum() + "人");
                    }
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class d implements Runnable {
        private final SoftReference<ActivityChat> oRj;

        private d(ActivityChat activityChat) {
            this.oRj = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRj.get() != null) {
                try {
                    this.oRj.get().oQo.setVisibility(0);
                    this.oRj.get().oQo.startAnimation(this.oRj.get().oQI);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class e implements Runnable {
        private final SoftReference<ActivityChat> oRj;

        private e(ActivityChat activityChat) {
            this.oRj = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRj.get() != null) {
                try {
                    this.oRj.get().oQo.setVisibility(8);
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j2, final boolean z) {
        com.baidu.yuyinala.privatemessage.implugin.f.k.hz(getApplicationContext()).a(j2, new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.9
            @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
            public void d(int i2, String str, long j3) {
                Message message = new Message();
                message.what = 6;
                Bundle bundle = new Bundle();
                bundle.putString("subscribe_data", str);
                bundle.putBoolean("update_subscribe", z);
                message.setData(bundle);
                ActivityChat.this.oQS.sendMessage(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ni(int i2) {
        String str;
        Date date;
        long j2 = -1;
        if (i2 == 1) {
            str = com.baidu.yuyinala.privatemessage.implugin.f.j.getType();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.baidu.yuyinala.privatemessage.implugin.f.j.ehw())) {
                try {
                    j2 = Long.parseLong(com.baidu.yuyinala.privatemessage.implugin.f.j.ehw());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.c.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXy + ChatInfo.mPaid + ChatInfo.oPi, 0L));
            } else {
                return;
            }
        } else if (i2 == 0) {
            str = "ugc";
            j2 = this.oQE;
            date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.c.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXz + this.oQE, 0L));
        } else {
            str = null;
            date = null;
        }
        if (!com.baidu.yuyinala.privatemessage.implugin.util.f.c(date, new Date())) {
            if ((this.oQO == null || !this.oQO.eiV() || this.oQO.eiW() != i2) && this.oQv != null) {
                this.oQO = this.oQv.ao(i2, ehO());
                if (this.oQO != null) {
                    try {
                        this.oQO.c(str, j2, new g(this, i2));
                    } catch (NumberFormatException e3) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, e3.getMessage());
                    }
                    com.baidu.yuyinala.privatemessage.implugin.e.a.hy(getApplicationContext()).add("416", "subscribe_show");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class g implements IIsSubscribedListener {
        private final int flag;
        private final WeakReference<ActivityChat> mActivity;

        public g(ActivityChat activityChat, int i) {
            this.mActivity = new WeakReference<>(activityChat);
            this.flag = i;
        }

        @Override // com.baidu.android.imsdk.pubaccount.IIsSubscribedListener
        public void onIsSubscribedResult(int i, String str, long j, boolean z) {
            ActivityChat activityChat = this.mActivity.get();
            if (activityChat != null) {
                if (this.flag == 1) {
                    Message message = new Message();
                    message.what = 2;
                    message.arg1 = z ? 1 : 0;
                    message.obj = str;
                    activityChat.ehz().sendMessage(message);
                } else if (this.flag == 0) {
                    Message message2 = new Message();
                    if (z) {
                        message2.arg1 = 0;
                    } else {
                        message2.arg1 = -1;
                    }
                    message2.what = 8;
                    activityChat.ehz().sendMessage(message2);
                }
            }
        }
    }

    public void onBackClick() {
        if (this.mChatStatus == 0) {
            if (this.oQw != null) {
                this.oQw.eiB();
            }
            if (this.oQO != null) {
                this.oQO.eiU();
            }
        }
        finish();
        if (!ChatInfo.oPs) {
            com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().hx(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Xj(String str) {
        return str;
    }
}
