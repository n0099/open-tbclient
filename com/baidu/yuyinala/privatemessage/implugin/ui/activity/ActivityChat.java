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
    public static boolean oQF;
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
    private ChatUser oQB;
    protected QMGroupInfo oQC;
    protected long oQD;
    public boolean oQE;
    private Animation oQH;
    private Animation oQI;
    private String oQL;
    private UserStatus oQM;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c oQN;
    protected ImBaseEntity oQO;
    private com.baidu.yuyinala.privatemessage.implugin.ui.a.a oQP;
    private long oQS;
    private RelativeLayout oQi;
    private View oQj;
    private TextView oQk;
    private TextView oQl;
    private TextView oQm;
    private View oQn;
    private FrameLayout oQo;
    private FrameLayout oQp;
    private LinearLayout oQq;
    private RelativeLayout oQr;
    private FrameLayout oQs;
    private FrameLayout oQt;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a oQu;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b oQv;
    private LinearLayout oQw;
    private TextView oQx;
    private ImageView oQy;
    private ImageView oQz;
    private int kdg = 0;
    public boolean oQG = false;
    private int mChatStatus = 1;
    private String mListenerKey = "";
    private int oQJ = -1;
    private long oQK = -1;
    private c oQQ = new c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.1
        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.c
        public void ehV() {
            ActivityChat.this.oQR.sendEmptyMessage(1002);
        }
    };
    private f oQR = new f();
    private boolean oQT = false;
    private View.OnClickListener oQU = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().getLoginState(ActivityChat.this);
            ActivityChat.this.oQS = System.currentTimeMillis();
            ActivityChat.this.oQT = false;
            if (loginState == 3) {
                ActivityChat.this.oQR.removeCallbacks(ActivityChat.this.gaM);
                ActivityChat.this.oQR.postDelayed(ActivityChat.this.gaM, ActivityChat.this.ehB());
                ActivityChat.this.oQt.setVisibility(8);
                ActivityChat.this.init(ActivityChat.this.getIntent());
                return;
            }
            ActivityChat.this.oQR.postDelayed(ActivityChat.this.gaM, 7000L);
            ActivityChat.this.ehC();
        }
    };
    private Runnable gaM = new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mTimeOutRunnable run ");
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().getLoginState(ActivityChat.this) != 3) {
                ActivityChat.this.oQT = true;
                ActivityChat.this.ehD();
                return;
            }
            ActivityChat.this.ehE();
        }
    };
    private h oQV = new h();
    private View.OnClickListener oQW = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChat.this.ehQ();
            if (ActivityChat.this.mChatStatus == 0 && ActivityChat.this.oQv != null) {
                ActivityChat.this.oQv.eiB();
            }
        }
    };
    private l oQX = new l();
    private k oQY = new k();
    private j oQZ = new j();
    private a oRa = new a();
    private b oRb = new b();
    d oRc = new d();
    e oRd = new e();

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
    public void Xf(String str) {
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
        return this.oQR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class f extends Handler {
        private final SoftReference<ActivityChat> oRi;

        private f(ActivityChat activityChat) {
            this.oRi = new SoftReference<>(activityChat);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = null;
            int i = 0;
            boolean z = false;
            super.handleMessage(message);
            if (this.oRi.get() != null) {
                try {
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.oRi.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "current is no support");
                        this.oRi.get().oQq.setVisibility(4);
                        ChatInfo.mStatus = 10;
                        if (this.oRi.get().oQv != null) {
                            this.oRi.get().oQv.eiv();
                        }
                        if (this.oRi.get().oQu != null) {
                            this.oRi.get().oQu.eiv();
                            return;
                        }
                        return;
                    case 2:
                        if (message.arg1 == 1) {
                            com.baidu.yuyinala.privatemessage.implugin.f.j.Ar(true);
                            postDelayed(new i(this.oRi), 1000L);
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().bx(this.oRi.get().getApplicationContext(), this.oRi.get().getString(a.h.bd_im_zhida_success_tip));
                            if (this.oRi.get().oQN != null) {
                                this.oRi.get().oQN.dismiss();
                            }
                            String ehw = com.baidu.yuyinala.privatemessage.implugin.f.j.ehw();
                            if (!TextUtils.isEmpty(ehw)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("sign", "media_" + ehw);
                                    jSONObject.put("relation", 1);
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().B(this.oRi.get().getApplicationContext(), "com.baidu.channel.subscribe", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
                                    return;
                                } catch (UnsupportedEncodingException e2) {
                                    e2.printStackTrace();
                                    return;
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            this.oRi.get();
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
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().bw(this.oRi.get().getApplicationContext(), str);
                            return;
                        } else {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().bw(this.oRi.get().getApplicationContext(), this.oRi.get().getString(a.h.bd_im_subscribe_fail_tip));
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                        return;
                    case 3:
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().showToast(this.oRi.get().getApplicationContext(), this.oRi.get().getString(a.h.bd_im_zhida_fail_net_tip));
                        return;
                    case 5:
                        this.oRi.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 1 ");
                        this.oRi.get().finish();
                        this.oRi.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 2 ");
                        return;
                    case 6:
                        Bundle data = message.getData();
                        String str2 = "";
                        if (data != null) {
                            str2 = data.getString("subscribe_data");
                            z = data.getBoolean("update_subscribe", false);
                        }
                        com.baidu.yuyinala.privatemessage.implugin.f.j.Xc(str2);
                        ChatInfo.mPainfo.setMsgNotify(com.baidu.yuyinala.privatemessage.implugin.f.j.isNeedNotify());
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.ehx() || !z) {
                            if (this.oRi.get().oQN != null && this.oRi.get().oQN.eiV()) {
                                this.oRi.get().oQN.dismiss();
                            }
                        } else {
                            this.oRi.get().Ni(1);
                        }
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.getData() != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.b.D(this.oRi.get().getApplicationContext(), String.valueOf(this.oRi.get().mPaid), com.baidu.yuyinala.privatemessage.implugin.f.j.getData().toString());
                            return;
                        }
                        return;
                    case 7:
                        this.oRi.get().Ni(0);
                        return;
                    case 8:
                        if (message.arg1 == 0) {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().bw(this.oRi.get(), "关注成功");
                            this.oRi.get().oQN.dismiss();
                            this.oRi.get().ehS();
                            this.oRi.get().isFollowed = true;
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().bw(this.oRi.get(), "关注失败");
                        return;
                    case 1001:
                        if (this.oRi.get().oQw != null && this.oRi.get().oQw.getVisibility() == 0) {
                            this.oRi.get().oQw.setAnimation(AnimationUtils.loadAnimation(this.oRi.get(), a.C0194a.bd_im_slip_out_from_right));
                            this.oRi.get().oQw.setVisibility(4);
                            return;
                        }
                        return;
                    case 1002:
                        this.oRi.get().ehH();
                        return;
                    case 1003:
                        if (this.oRi.get().oQy != null && this.oRi.get().oQy.getVisibility() == 0) {
                            this.oRi.get().oQy.setAnimation(AnimationUtils.loadAnimation(this.oRi.get(), a.C0194a.bd_im_disappear_out));
                            this.oRi.get().oQy.setVisibility(4);
                            return;
                        }
                        return;
                    case 1006:
                        this.oRi.get().oQq.setVisibility(4);
                        ChatInfo.mStatus = 11;
                        if (this.oRi.get().oQv != null) {
                            this.oRi.get().oQv.eiv();
                        }
                        this.oRi.get().oQs.setVisibility(0);
                        return;
                    case 1007:
                    case 1008:
                        return;
                    case 1009:
                        if (this.oRi.get().oQu != null) {
                            this.oRi.get().oQu.Au(false);
                        }
                        this.oRi.get().oQt.setVisibility(8);
                        this.oRi.get().init(this.oRi.get().getIntent());
                        return;
                    case 1010:
                        if (this.oRi.get().oQu != null) {
                            this.oRi.get().oQu.Au(true);
                        }
                        if (this.oRi.get().oQv != null) {
                            this.oRi.get().oQv.eiv();
                            return;
                        }
                        return;
                    case 1011:
                        this.oRi.get().oQq.setVisibility(4);
                        ChatInfo.mStatus = 12;
                        if (this.oRi.get().oQv != null) {
                            this.oRi.get().oQv.eiv();
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
        private final SoftReference<ActivityChat> oRi;

        private i(SoftReference<ActivityChat> softReference) {
            this.oRi = softReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRi.get() != null) {
                this.oRi.get().w(this.oRi.get().mPaid, false);
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
        this.oQP = new com.baidu.yuyinala.privatemessage.implugin.ui.a.a();
        ehP();
        init(getIntent());
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().isCuidLogin(this) || com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().eht()) {
            this.oQG = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    private void ehA() {
        this.oQS = System.currentTimeMillis();
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "loginOver loginState: " + loginState);
        if (this.oQu != null) {
            this.oQu.eiw();
        }
        switch (loginState) {
            case 2:
                this.oQR.postDelayed(this.gaM, 7000L);
                ehC();
                return;
            case 3:
                this.oQR.postDelayed(this.gaM, ehB());
                this.oQt.setVisibility(8);
                this.oQR.sendEmptyMessage(1009);
                return;
            default:
                this.oQR.postDelayed(this.gaM, 7000L);
                ehF();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ehB() {
        long currentTimeMillis = 10000 - (System.currentTimeMillis() - this.oQS);
        if (currentTimeMillis > 7000) {
            return 7000L;
        }
        return currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehC() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "retryLogin timeout " + this.oQT);
        if (!this.oQT) {
            this.oQR.sendEmptyMessage(1010);
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
        if (this.oQu != null) {
            this.oQu.Au(false);
        }
        if (this.oQv != null) {
            this.oQv.eiv();
        }
        this.oQt.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehE() {
        if (this.oQu != null) {
            this.oQu.Au(false);
        }
    }

    private void ehF() {
        this.oQR.sendEmptyMessage(1010);
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
                        ActivityChat.this.oQR.removeCallbacks(ActivityChat.this.gaM);
                        ActivityChat.this.oQR.postDelayed(ActivityChat.this.gaM, ActivityChat.this.ehB());
                        ActivityChat.this.oQR.sendEmptyMessage(1009);
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
            if (this.oQw == null) {
                this.oQw = (LinearLayout) findViewById(a.f.bd_im_chat_unread_msgs_layout);
                this.oQx = (TextView) findViewById(a.f.bd_im_chat_unread_msgs_txt);
                this.oQx.setText(this.kdg + getString(a.h.bd_im_alert_unread_msgs));
            }
            this.oQz = (ImageView) findViewById(a.f.bd_im_chat_unread_msgs_up);
            try {
                this.oQw.setBackgroundResource(ThemeManager.U(this, a.e.bd_im_chat_unread_msgs_background));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.oQw.setAnimation(AnimationUtils.loadAnimation(this, a.C0194a.bd_im_slip_in_from_right));
            this.oQw.setVisibility(0);
            this.oQw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.oQu.Nj(ActivityChat.this.kdg);
                    ActivityChat.this.oQw.setAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0194a.bd_im_slip_out_from_right));
                    ActivityChat.this.oQw.setVisibility(4);
                }
            });
            this.oQR.sendEmptyMessageDelayed(1001, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehH() {
        if (this.oQy == null) {
            this.oQy = (ImageView) findViewById(a.f.bd_im_chat_new_msgs_tip);
            this.oQy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.oQu.eil();
                    ActivityChat.this.oQy.startAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0194a.bd_im_disappear_out));
                    ActivityChat.this.oQy.setVisibility(4);
                }
            });
        }
        if (this.oQy.getVisibility() != 0) {
            this.oQy.startAnimation(AnimationUtils.loadAnimation(this, a.C0194a.bd_im_disappear_in));
            this.oQy.setVisibility(0);
        }
        this.oQR.removeMessages(1003);
        this.oQR.sendEmptyMessageDelayed(1003, 10000L);
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
        switch (ChatInfo.oPf) {
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
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mChatCategory " + ChatInfo.oPf + " mOnlineStatus " + this.oQM);
        if (ChatInfo.oPf == ChatInfo.ChatCategory.C2C && this.oQM != null) {
            ehI();
        }
        if (this.oQu != null) {
            this.oQu.a((com.baidu.yuyinala.privatemessage.implugin.ui.activity.a) null);
        }
        if (this.oQv != null) {
            this.oQv.onDestroy();
        }
        if (this.oQu != null) {
            this.oQu.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i2) {
    }

    private void ehI() {
        Intent intent = new Intent(IMConstants.NOTICE_USER_STATE);
        intent.putExtra(IMConstants.NOTICE_USER_STATE_OBJECT, this.oQM);
        sendBroadcast(intent);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "noticeSessionState com.baidu.android.imsdk.notice.userstate");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onResume--->");
        super.onResume();
        com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().Aq(true);
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onResume mIsCuidOrIncompleteLogin: " + this.oQG + " loginState: " + loginState);
        if (this.oQG && (!com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().isCuidLogin(this) || !com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().eht() || (loginState != 0 && loginState != 3))) {
            ehA();
        } else if (this.oQN != null && this.oQN.eiV() && ChatInfo.ChatCategory.DUZHAN == ChatInfo.oPf) {
            w(this.mPaid, true);
        }
        if (this.oQv != null) {
            this.oQv.onResume();
        }
        if (this.oQu != null) {
            this.oQu.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStop--->");
        super.onStop();
        if (this.oQv != null) {
            this.oQv.onStop();
        }
        if (this.oQu != null) {
            this.oQu.onStop();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStop");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStart--->");
        super.onStart();
        if (this.oQv != null) {
            this.oQv.onStart();
        }
        if (this.oQu != null) {
            this.oQu.onStart();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStart");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onPause--->");
        super.onPause();
        com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().Aq(false);
        if (this.oQv != null) {
            this.oQv.onPause();
        }
        if (this.oQu != null) {
            this.oQu.onPause();
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
            this.aQm = ExtraParamsManager.getEncryptionUserId(extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWS));
            this.oQE = extras.getBoolean("isMediaRole");
            this.mGroupId = extras.getString("groupid");
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("miliao", "mIsmediaRole：" + this.oQE);
            this.mLiveId = extras.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            oQF = this.oQE;
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oWS, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWS));
            jSONObject.put("paid", extras.getString("paid"));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oWU, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWU));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oWW, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWW));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oWV, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWV));
            String jSONObject2 = jSONObject.toString();
            try {
                if (!TextUtils.isEmpty(extras.getString("action"))) {
                    Serializable serializable = extras.getSerializable("params");
                    if (serializable instanceof ImBaseEntity) {
                        this.oQO = (ImBaseEntity) serializable;
                        if (this.oQC == null) {
                            GroupInfo groupInfo = new GroupInfo(String.valueOf(this.oQO.id));
                            groupInfo.setGroupName(this.oQO.name);
                            groupInfo.setDescription(this.oQO.description);
                            groupInfo.setHeadUrl(this.oQO.headUrl);
                            this.oQC = new QMGroupInfo(groupInfo);
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
        if (this.oQq != null) {
            if (this.oQE) {
                this.oQq.setVisibility(8);
            } else {
                this.oQq.setVisibility(0);
            }
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + aw);
        ChatInfo.mContacter = -1L;
        ChatInfo.oPh = -1L;
        ChatInfo.mAppid = -1L;
        ChatInfo.mUid = -1L;
        ChatInfo.oPi = "";
        ChatInfo.oPj = "";
        ChatInfo.oPk = -1;
        ChatInfo.oPo = 0;
        ChatInfo.oPr = true;
        ChatInfo.oPq = false;
        try {
            JSONObject jSONObject = new JSONObject(aw);
            int i2 = jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.oWV) ? jSONObject.getInt(com.baidu.yuyinala.privatemessage.implugin.util.d.oWV) : -1;
            if (i2 == -1) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "invoke error -1");
                return;
            }
            if (i2 == 80) {
                parseLong = Long.parseLong(jSONObject.optString("paid", "-1"));
            } else {
                parseLong = Long.parseLong(jSONObject.optString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWS, "-1"));
            }
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + aw);
            if (this.oQJ != -1 && (this.oQJ != i2 || this.oQK != parseLong)) {
                if (this.oQu != null) {
                    this.oQu.eiw();
                }
                if (this.oQl != null) {
                    this.oQl.setText("");
                }
            }
            this.oQJ = i2;
            switch (i2) {
                case 0:
                    ChatInfo.oPf = ChatInfo.ChatCategory.C2C;
                    try {
                        this.oQD = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWS));
                        ChatInfo.mUid = this.oQD;
                        ehK();
                        this.mNickName = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWU);
                        this.mIcon = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWW);
                        if (jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.oWY)) {
                            ChatInfo.oPr = jSONObject.getBoolean(com.baidu.yuyinala.privatemessage.implugin.util.d.oWY);
                        }
                    } catch (Exception e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "init uid and name error");
                    }
                    this.oQm.setVisibility(8);
                    this.mListenerKey = String.valueOf(this.oQD);
                    Xg(this.mNickName);
                    hV(this.oQD);
                    return;
                case 80:
                    ChatInfo.oPf = ChatInfo.ChatCategory.DUZHAN;
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
            if (this.oQE) {
                long parseLong = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oWS));
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
        this.oQm.setVisibility(8);
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
                    ActivityChat.this.oQR.post(ActivityChat.this.oQV);
                }
            });
        } else {
            this.oQR.post(this.oQV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class h implements Runnable {
        private final SoftReference<ActivityChat> oRj;

        private h(ActivityChat activityChat) {
            this.oRj = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRj.get() != null) {
                try {
                    ChatInfo.oPh = AccountManager.getUK(this.oRj.get().getApplicationContext());
                    this.oRj.get();
                    LogUtils.d(MAFragmentActivity.TAG, "parunnable ---> " + ChatInfo.oPh);
                    if (ChatInfo.oPh != -1) {
                        this.oRj.get().mChatStatus = 0;
                        this.oRj.get().ehJ();
                        this.oRj.get();
                        LogUtils.d(MAFragmentActivity.TAG, "parunnable -->1");
                        ChatInfo.mContacter = this.oRj.get().mPaInfo.getPaId();
                        ChatInfo.mPainfo = this.oRj.get().mPaInfo;
                        if (ChatInfo.oPf == ChatInfo.ChatCategory.DUZHAN) {
                            this.oRj.get().kdg = ChatMsgManager.getUnReadMsgCountByPaid(this.oRj.get(), this.oRj.get().mPaid);
                            if (this.oRj.get().kdg > 200) {
                                this.oRj.get().kdg = 200;
                            }
                        }
                        this.oRj.get().SN();
                        this.oRj.get().w(this.oRj.get().mPaid, true);
                    } else {
                        this.oRj.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    this.oRj.get().oQL = TextUtils.isEmpty(this.oRj.get().oQL) ? this.oRj.get().mPaInfo.getNickName() : this.oRj.get().oQL;
                    this.oRj.get().oQl.setText(String.valueOf(this.oRj.get().oQL));
                    this.oRj.get().ehG();
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
                    ChatInfo.oPi = ActivityChat.this.Xi(arrayList2.get(0).getIconUrl());
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
        return this.oQJ == 2 || this.oQJ == 11;
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
        this.oQi = (RelativeLayout) findViewById(a.f.bd_im_chat_title_root);
        this.oQj = findViewById(a.f.bd_im_chat_cell_space_line);
        this.oQk = (TextView) findViewById(a.f.bd_im_chat_open_main);
        this.oQq = (LinearLayout) findViewById(a.f.bd_im_chat_open_main_click_parent);
        this.oQq.setOnClickListener(this.oQW);
        this.oQr = (RelativeLayout) findViewById(a.f.bd_im_chat_back_layout);
        this.oQr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.onBackClick();
            }
        });
        this.oQl = (TextView) findViewById(a.f.bd_im_chat_title);
        this.oQm = (TextView) findViewById(a.f.bd_im_chat_subtitle);
        this.oQn = findViewById(a.f.bd_im_chat_main_input);
        this.oQo = (FrameLayout) findViewById(a.f.bd_im_chat_main_content);
        this.oQp = (FrameLayout) findViewById(a.f.bd_im_chat_main_input);
        this.oQs = (FrameLayout) findViewById(a.f.bd_im_chat_main_error_content);
        this.oQA = (ImageView) findViewById(a.f.bd_im_chat_main_error_image);
        this.oQs.setVisibility(8);
        this.oQt = (FrameLayout) findViewById(a.f.bd_im_chat_main_retry_content);
        this.oQt.setVisibility(8);
        findViewById(a.f.bd_im_chat_main_retry_button).setOnClickListener(this.oQU);
        this.oQl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.ehT();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SN() {
        if (this.oQu == null) {
            FrameLayout frameLayout = this.oQo;
            this.oQo.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_chat, null));
            this.oQu = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.a(this, this.oQo, this.mListenerKey, this.oQQ, this.kdg);
        }
        if (this.oQv == null) {
            FrameLayout frameLayout2 = this.oQp;
            this.oQp.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_input, null));
            this.oQv = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.a(this, this.oQp, this.mListenerKey, this.oQQ);
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
        if (this.oQu != null) {
            this.oQu.a(this);
        }
        hW(this.oQD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void ehP() {
        this.oQH = AnimationUtils.loadAnimation(this, a.C0194a.bd_im_fragment_in_from_bottom);
        this.oQI = AnimationUtils.loadAnimation(this, a.C0194a.bd_im_fragment_out_to_bottom);
    }

    private void hV(long j2) {
        if (j2 == 0) {
            this.oQB = null;
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
                        ((ActivityChat) softReference.get()).oQR.post(ActivityChat.this.oRa);
                        return;
                    }
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        ((ActivityChat) softReference.get()).oQB = arrayList3.get(0);
                    }
                    if (((ActivityChat) softReference.get()).oQB == null) {
                        ((ActivityChat) softReference.get()).oQR.post(ActivityChat.this.oQZ);
                        return;
                    }
                    ArrayList<Long> arrayList4 = new ArrayList<>();
                    arrayList4.add(Long.valueOf(ActivityChat.this.oQB.getUk()));
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().a(ActivityChat.this.getApplicationContext(), arrayList4, new b.InterfaceC0962b() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7.1
                        @Override // com.baidu.android.imsdk.chatuser.IGetUserStatusListener
                        public void onGetUsersStatusResult(int i3, String str2, ArrayList<UserStatus> arrayList5) {
                            if (i3 == 0 && arrayList5.size() == 1) {
                                ((ActivityChat) softReference.get()).oQM = arrayList5.get(0);
                                ((ActivityChat) softReference.get()).oQR.post(ActivityChat.this.oQX);
                            }
                        }
                    });
                    ((ActivityChat) softReference.get()).oQR.post(ActivityChat.this.oQY);
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
                            ActivityChat.this.oQR.sendEmptyMessageDelayed(7, 1000L);
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
        return this.oQO;
    }

    protected void ehS() {
    }

    protected void Xg(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oQl.setText(str);
        } else if (this.mNickName != null) {
            this.oQl.setText(String.valueOf(this.mNickName));
        } else if (this.oQB != null) {
            this.oQl.setText(String.valueOf(this.oQB.getUserName()));
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
        private final SoftReference<ActivityChat> oRi;

        private l(ActivityChat activityChat) {
            this.oRi = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes10.dex */
    private static class k implements Runnable {
        private final SoftReference<ActivityChat> oRi;

        private k(ActivityChat activityChat) {
            this.oRi = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRi.get() != null) {
                try {
                    ChatInfo.oPh = AccountManager.getUK(this.oRi.get().getApplicationContext());
                    if (ChatInfo.oPh != -1) {
                        this.oRi.get().mChatStatus = 0;
                        this.oRi.get().ehU();
                        this.oRi.get().SN();
                        this.oRi.get().hX(this.oRi.get().oQD);
                    } else {
                        this.oRi.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    if (this.oRi.get().mNickName == null) {
                        if (this.oRi.get().oQB != null) {
                            this.oRi.get().oQl.setText(String.valueOf(this.oRi.get().oQB.getUserName()));
                            return;
                        }
                        return;
                    }
                    this.oRi.get().oQl.setText(String.valueOf(this.oRi.get().mNickName));
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hX(long j2) {
        if (Xh(String.valueOf(j2))) {
        }
    }

    private boolean Xh(String str) {
        String C = com.baidu.yuyinala.privatemessage.implugin.util.c.b.C(getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXs, null);
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
        ChatInfo.mContacter = this.oQB.getUk();
        ChatInfo.mUid = this.oQB.getBuid();
        ChatInfo.mStatus = 3;
        ChatInfo.oPg = this.oQB.getUserName();
        if (!TextUtils.isEmpty(this.mIcon)) {
            ChatInfo.oPj = this.mIcon;
        } else {
            ChatInfo.oPj = Xi(this.oQB.getIconUrl());
        }
        BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
        LogUtils.i(MAFragmentActivity.TAG, "uk:" + ChatInfo.oPh);
        LogUtils.i(MAFragmentActivity.TAG, "header:" + ChatInfo.oPi);
        LogUtils.i(MAFragmentActivity.TAG, "" + this.oQB.toString());
    }

    /* loaded from: classes10.dex */
    private static class j implements Runnable {
        private final SoftReference<ActivityChat> oRi;

        private j(ActivityChat activityChat) {
            this.oRi = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRi.get() != null) {
                try {
                    ChatInfo.oPh = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().hu(this.oRi.get().getApplicationContext()).longValue();
                    this.oRi.get().mChatStatus = 0;
                    this.oRi.get().SN();
                    if (this.oRi.get().mNickName != null) {
                        this.oRi.get().oQl.setText(String.valueOf(this.oRi.get().mNickName));
                    }
                    this.oRi.get().oQR.sendEmptyMessage(1);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        private final SoftReference<ActivityChat> oRi;

        private a(ActivityChat activityChat) {
            this.oRi = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRi.get() != null) {
                try {
                    ChatInfo.oPh = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().hu(this.oRi.get().getApplicationContext()).longValue();
                    this.oRi.get().mChatStatus = 1;
                    this.oRi.get().SN();
                    if (this.oRi.get().mNickName != null) {
                        this.oRi.get().oQl.setText(String.valueOf(this.oRi.get().mNickName));
                    }
                    this.oRi.get().oQR.sendEmptyMessage(1006);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class b implements Runnable {
        private final SoftReference<ActivityChat> oRi;

        private b(ActivityChat activityChat) {
            this.oRi = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRi.get() != null) {
                try {
                    ChatInfo.oPh = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().hu(this.oRi.get().getApplicationContext()).longValue();
                    String str = null;
                    if (this.oRi.get().oQC != null) {
                        str = this.oRi.get().oQC.mInfo.getGroupName();
                    }
                    if (ChatInfo.oPk == 2) {
                        if (str == null || "".equals(str.trim())) {
                            if (this.oRi.get().mNickName != null) {
                                this.oRi.get().oQl.setText(String.valueOf(this.oRi.get().mNickName));
                                return;
                            } else if (this.oRi.get().oQC != null) {
                                this.oRi.get().oQl.setText(String.valueOf(str));
                                return;
                            } else {
                                return;
                            }
                        }
                        this.oRi.get().oQl.setText(String.valueOf(str));
                    } else if (!TextUtils.isEmpty(str)) {
                        this.oRi.get().oQl.setText(String.valueOf(str));
                        this.oRi.get().oQm.setText(this.oRi.get().oQC.mInfo.getNum() + "人");
                    } else if (!TextUtils.isEmpty(this.oRi.get().mNickName)) {
                        this.oRi.get().oQl.setText(String.valueOf(this.oRi.get().mNickName));
                        this.oRi.get().oQm.setText(this.oRi.get().oQC.mInfo.getNum() + "人");
                    } else if (this.oRi.get().oQC != null) {
                        this.oRi.get().oQl.setText("未知群");
                        this.oRi.get().oQm.setText(this.oRi.get().oQC.mInfo.getNum() + "人");
                    }
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class d implements Runnable {
        private final SoftReference<ActivityChat> oRi;

        private d(ActivityChat activityChat) {
            this.oRi = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRi.get() != null) {
                try {
                    this.oRi.get().oQn.setVisibility(0);
                    this.oRi.get().oQn.startAnimation(this.oRi.get().oQH);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class e implements Runnable {
        private final SoftReference<ActivityChat> oRi;

        private e(ActivityChat activityChat) {
            this.oRi = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oRi.get() != null) {
                try {
                    this.oRi.get().oQn.setVisibility(8);
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
                ActivityChat.this.oQR.sendMessage(message);
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
                date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.c.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXx + ChatInfo.mPaid + ChatInfo.oPh, 0L));
            } else {
                return;
            }
        } else if (i2 == 0) {
            str = "ugc";
            j2 = this.oQD;
            date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.c.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXy + this.oQD, 0L));
        } else {
            str = null;
            date = null;
        }
        if (!com.baidu.yuyinala.privatemessage.implugin.util.f.c(date, new Date())) {
            if ((this.oQN == null || !this.oQN.eiV() || this.oQN.eiW() != i2) && this.oQu != null) {
                this.oQN = this.oQu.ao(i2, ehO());
                if (this.oQN != null) {
                    try {
                        this.oQN.c(str, j2, new g(this, i2));
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
            if (this.oQv != null) {
                this.oQv.eiB();
            }
            if (this.oQN != null) {
                this.oQN.eiU();
            }
        }
        finish();
        if (!ChatInfo.oPr) {
            com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().hx(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Xi(String str) {
        return str;
    }
}
