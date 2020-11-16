package com.baidu.yuyinala.privatemessage.implugin.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.baidu.live.tbadk.TbConfig;
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
/* loaded from: classes4.dex */
public class ActivityChat extends BaseFragmentActivity implements com.baidu.yuyinala.privatemessage.implugin.ui.activity.a, com.baidu.yuyinala.privatemessage.implugin.ui.activity.c, ThemeManager.a {
    public static boolean ozP;
    protected String aQY;
    protected boolean isFollowed;
    private LinearLayout mContainer;
    private String mGroupId;
    private String mIcon;
    private String mLiveId;
    private String mNickName;
    private PaInfo mPaInfo;
    public long mPaid;
    private long oAc;
    private LinearLayout ozA;
    private RelativeLayout ozB;
    private FrameLayout ozC;
    private FrameLayout ozD;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a ozE;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b ozF;
    private LinearLayout ozG;
    private TextView ozH;
    private ImageView ozI;
    private ImageView ozJ;
    private ImageView ozK;
    private ChatUser ozL;
    protected QMGroupInfo ozM;
    protected long ozN;
    public boolean ozO;
    private Animation ozR;
    private Animation ozS;
    private String ozV;
    private UserStatus ozW;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c ozX;
    protected ImBaseEntity ozY;
    private com.baidu.yuyinala.privatemessage.implugin.ui.a.a ozZ;
    private RelativeLayout ozs;
    private View ozt;
    private TextView ozu;
    private TextView ozv;
    private TextView ozw;
    private View ozx;
    private FrameLayout ozy;
    private FrameLayout ozz;
    private int jGW = 0;
    public boolean ozQ = false;
    private int bwz = 1;
    private String mListenerKey = "";
    private int ozT = -1;
    private long ozU = -1;
    private c oAa = new c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.1
        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.c
        public void efV() {
            ActivityChat.this.oAb.sendEmptyMessage(1002);
        }
    };
    private f oAb = new f();
    private boolean oAd = false;
    private View.OnClickListener oAe = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().getLoginState(ActivityChat.this);
            ActivityChat.this.oAc = System.currentTimeMillis();
            ActivityChat.this.oAd = false;
            if (loginState == 3) {
                ActivityChat.this.oAb.removeCallbacks(ActivityChat.this.fOd);
                ActivityChat.this.oAb.postDelayed(ActivityChat.this.fOd, ActivityChat.this.efB());
                ActivityChat.this.ozD.setVisibility(8);
                ActivityChat.this.init(ActivityChat.this.getIntent());
                return;
            }
            ActivityChat.this.oAb.postDelayed(ActivityChat.this.fOd, 7000L);
            ActivityChat.this.efC();
        }
    };
    private Runnable fOd = new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mTimeOutRunnable run ");
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.eft().getLoginState(ActivityChat.this) != 3) {
                ActivityChat.this.oAd = true;
                ActivityChat.this.efD();
                return;
            }
            ActivityChat.this.efE();
        }
    };
    private h oAf = new h();
    private View.OnClickListener oAg = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChat.this.efQ();
            if (ActivityChat.this.bwz == 0 && ActivityChat.this.ozF != null) {
                ActivityChat.this.ozF.egD();
            }
        }
    };
    private l oAh = new l();
    private k oAi = new k();
    private j oAj = new j();
    private a oAk = new a();
    private b oAl = new b();
    d oAm = new d();
    e oAn = new e();

    /* loaded from: classes4.dex */
    public interface c {
        void efV();
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
    public void Xj(String str) {
        if ("greet_link".equals(str)) {
            String ega = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.ega();
            String str2 = "";
            if (!TextUtils.isEmpty(ChatInfo.nickname)) {
                str2 = ChatInfo.nickname;
            } else if (!TextUtils.isEmpty(ChatInfo.displayname)) {
                str2 = ChatInfo.displayname;
            }
            com.baidu.yuyinala.privatemessage.model.message.a.eij().B(this, ega.replace("XXX", str2), this.mListenerKey);
        } else if ("welcom_link".equals(str)) {
            com.baidu.yuyinala.privatemessage.model.message.a.eij().B(this, com.baidu.yuyinala.privatemessage.implugin.ui.common.b.egb(), this.mListenerKey);
        }
    }

    public f efz() {
        return this.oAb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class f extends Handler {
        private final SoftReference<ActivityChat> oAs;

        private f(ActivityChat activityChat) {
            this.oAs = new SoftReference<>(activityChat);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            String str;
            int i2 = 0;
            boolean z = false;
            super.handleMessage(message);
            if (this.oAs.get() != null) {
                try {
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.oAs.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "current is no support");
                        this.oAs.get().ozA.setVisibility(4);
                        ChatInfo.mStatus = 10;
                        if (this.oAs.get().ozF != null) {
                            this.oAs.get().ozF.egw();
                        }
                        if (this.oAs.get().ozE != null) {
                            this.oAs.get().ozE.egw();
                            return;
                        }
                        return;
                    case 2:
                        if (message.arg1 == 1) {
                            com.baidu.yuyinala.privatemessage.implugin.f.j.zR(true);
                            postDelayed(new i(this.oAs), 1000L);
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.egZ().bo(this.oAs.get().getApplicationContext(), this.oAs.get().getString(a.h.bd_im_zhida_success_tip));
                            if (this.oAs.get().ozX != null) {
                                this.oAs.get().ozX.dismiss();
                            }
                            String efx = com.baidu.yuyinala.privatemessage.implugin.f.j.efx();
                            if (!TextUtils.isEmpty(efx)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("sign", "media_" + efx);
                                    jSONObject.put("relation", 1);
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.eft().y(this.oAs.get().getApplicationContext(), "com.baidu.channel.subscribe", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
                                    return;
                                } catch (UnsupportedEncodingException e2) {
                                    e2.printStackTrace();
                                    return;
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            this.oAs.get();
                            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "sendAPSBroadcast thirdId is empty!");
                            return;
                        }
                        try {
                            JSONObject jSONObject2 = new JSONObject((String) message.obj);
                            i2 = jSONObject2.optInt(BaseJsonData.TAG_ERRNO);
                            i = i2;
                            str = jSONObject2.optString(BaseJsonData.TAG_ERRMSG);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                            i = i2;
                            str = null;
                        }
                        if (i == 800200 && !TextUtils.isEmpty(str)) {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.egZ().bn(this.oAs.get().getApplicationContext(), str);
                            return;
                        } else {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.egZ().bn(this.oAs.get().getApplicationContext(), this.oAs.get().getString(a.h.bd_im_subscribe_fail_tip));
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                        return;
                    case 3:
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.egZ().showToast(this.oAs.get().getApplicationContext(), this.oAs.get().getString(a.h.bd_im_zhida_fail_net_tip));
                        return;
                    case 5:
                        this.oAs.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 1 ");
                        this.oAs.get().finish();
                        this.oAs.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 2 ");
                        return;
                    case 6:
                        Bundle data = message.getData();
                        String str2 = "";
                        if (data != null) {
                            str2 = data.getString("subscribe_data");
                            z = data.getBoolean("update_subscribe", false);
                        }
                        com.baidu.yuyinala.privatemessage.implugin.f.j.Xg(str2);
                        ChatInfo.mPainfo.setMsgNotify(com.baidu.yuyinala.privatemessage.implugin.f.j.isNeedNotify());
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.isSubscribed() || !z) {
                            if (this.oAs.get().ozX != null && this.oAs.get().ozX.egX()) {
                                this.oAs.get().ozX.dismiss();
                            }
                        } else {
                            this.oAs.get().Oc(1);
                        }
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.getData() != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.b.b.A(this.oAs.get().getApplicationContext(), String.valueOf(this.oAs.get().mPaid), com.baidu.yuyinala.privatemessage.implugin.f.j.getData().toString());
                            return;
                        }
                        return;
                    case 7:
                        this.oAs.get().Oc(0);
                        return;
                    case 8:
                        if (message.arg1 == 0) {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.egZ().bn(this.oAs.get(), "关注成功");
                            this.oAs.get().ozX.dismiss();
                            this.oAs.get().efS();
                            this.oAs.get().isFollowed = true;
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.egZ().bn(this.oAs.get(), "关注失败");
                        return;
                    case 1001:
                        if (this.oAs.get().ozG != null && this.oAs.get().ozG.getVisibility() == 0) {
                            this.oAs.get().ozG.setAnimation(AnimationUtils.loadAnimation(this.oAs.get(), a.C0195a.bd_im_slip_out_from_right));
                            this.oAs.get().ozG.setVisibility(4);
                            return;
                        }
                        return;
                    case 1002:
                        this.oAs.get().efH();
                        return;
                    case 1003:
                        if (this.oAs.get().ozI != null && this.oAs.get().ozI.getVisibility() == 0) {
                            this.oAs.get().ozI.setAnimation(AnimationUtils.loadAnimation(this.oAs.get(), a.C0195a.bd_im_disappear_out));
                            this.oAs.get().ozI.setVisibility(4);
                            return;
                        }
                        return;
                    case 1006:
                        this.oAs.get().ozA.setVisibility(4);
                        ChatInfo.mStatus = 11;
                        if (this.oAs.get().ozF != null) {
                            this.oAs.get().ozF.egw();
                        }
                        this.oAs.get().ozC.setVisibility(0);
                        return;
                    case 1007:
                    case 1008:
                        return;
                    case 1009:
                        if (this.oAs.get().ozE != null) {
                            this.oAs.get().ozE.zU(false);
                        }
                        this.oAs.get().ozD.setVisibility(8);
                        this.oAs.get().init(this.oAs.get().getIntent());
                        return;
                    case 1010:
                        if (this.oAs.get().ozE != null) {
                            this.oAs.get().ozE.zU(true);
                        }
                        if (this.oAs.get().ozF != null) {
                            this.oAs.get().ozF.egw();
                            return;
                        }
                        return;
                    case 1011:
                        this.oAs.get().ozA.setVisibility(4);
                        ChatInfo.mStatus = 12;
                        if (this.oAs.get().ozF != null) {
                            this.oAs.get().ozF.egw();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class i implements Runnable {
        private final SoftReference<ActivityChat> oAs;

        private i(SoftReference<ActivityChat> softReference) {
            this.oAs = softReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oAs.get() != null) {
                this.oAs.get().u(this.oAs.get().mPaid, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BIMManager.mediaSetRole(getActivity(), true);
        efN();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        setContentView(a.g.bd_im_chat_activity_layout);
        this.mContainer = (LinearLayout) findViewById(a.f.bd_im_chat_root);
        this.ozZ = new com.baidu.yuyinala.privatemessage.implugin.ui.a.a();
        efP();
        init(getIntent());
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.eft().isCuidLogin(this) || com.baidu.yuyinala.privatemessage.implugin.d.b.eft().efu()) {
            this.ozQ = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    private void efA() {
        this.oAc = System.currentTimeMillis();
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "loginOver loginState: " + loginState);
        if (this.ozE != null) {
            this.ozE.egx();
        }
        switch (loginState) {
            case 2:
                this.oAb.postDelayed(this.fOd, 7000L);
                efC();
                return;
            case 3:
                this.oAb.postDelayed(this.fOd, efB());
                this.ozD.setVisibility(8);
                this.oAb.sendEmptyMessage(1009);
                return;
            default:
                this.oAb.postDelayed(this.fOd, 7000L);
                efF();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long efB() {
        long currentTimeMillis = 10000 - (System.currentTimeMillis() - this.oAc);
        if (currentTimeMillis > 7000) {
            return 7000L;
        }
        return currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efC() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "retryLogin timeout " + this.oAd);
        if (!this.oAd) {
            this.oAb.sendEmptyMessage(1010);
            com.baidu.yuyinala.privatemessage.implugin.d.b.eft().a(this, new b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.13
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
    public void efD() {
        if (this.ozE != null) {
            this.ozE.zU(false);
        }
        if (this.ozF != null) {
            this.ozF.egw();
        }
        this.ozD.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efE() {
        if (this.ozE != null) {
            this.ozE.zU(false);
        }
    }

    private void efF() {
        this.oAb.sendEmptyMessage(1010);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus ");
        com.baidu.yuyinala.privatemessage.implugin.d.b.eft().a(this, new b.e() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.14
            @Override // com.baidu.android.imsdk.account.ILoginStateChangedListener
            public void onLoginStateChanged(int i2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus onLoginStateChanged state: " + i2);
                switch (i2) {
                    case 2:
                        ActivityChat.this.efC();
                        return;
                    case 3:
                        ActivityChat.this.oAb.removeCallbacks(ActivityChat.this.fOd);
                        ActivityChat.this.oAb.postDelayed(ActivityChat.this.fOd, ActivityChat.this.efB());
                        ActivityChat.this.oAb.sendEmptyMessage(1009);
                        return;
                    default:
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "waitting");
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efG() {
        if (this.jGW > 8) {
            if (this.ozG == null) {
                this.ozG = (LinearLayout) findViewById(a.f.bd_im_chat_unread_msgs_layout);
                this.ozH = (TextView) findViewById(a.f.bd_im_chat_unread_msgs_txt);
                this.ozH.setText(this.jGW + getString(a.h.bd_im_alert_unread_msgs));
            }
            this.ozJ = (ImageView) findViewById(a.f.bd_im_chat_unread_msgs_up);
            try {
                this.ozG.setBackgroundResource(ThemeManager.L(this, a.e.bd_im_chat_unread_msgs_background));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.ozG.setAnimation(AnimationUtils.loadAnimation(this, a.C0195a.bd_im_slip_in_from_right));
            this.ozG.setVisibility(0);
            this.ozG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.ozE.Od(ActivityChat.this.jGW);
                    ActivityChat.this.ozG.setAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0195a.bd_im_slip_out_from_right));
                    ActivityChat.this.ozG.setVisibility(4);
                }
            });
            this.oAb.sendEmptyMessageDelayed(1001, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efH() {
        if (this.ozI == null) {
            this.ozI = (ImageView) findViewById(a.f.bd_im_chat_new_msgs_tip);
            this.ozI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.ozE.egm();
                    ActivityChat.this.ozI.startAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0195a.bd_im_disappear_out));
                    ActivityChat.this.ozI.setVisibility(4);
                }
            });
        }
        if (this.ozI.getVisibility() != 0) {
            this.ozI.startAnimation(AnimationUtils.loadAnimation(this, a.C0195a.bd_im_disappear_in));
            this.ozI.setVisibility(0);
        }
        this.oAb.removeMessages(1003);
        this.oAb.sendEmptyMessageDelayed(1003, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "new intent" + intent.toString());
        init(intent);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        switch (ChatInfo.oyr) {
            case GROUP:
                com.baidu.yuyinala.privatemessage.implugin.d.b.eft().setAllMsgRead(getApplicationContext(), 1, ChatInfo.mContacter, false);
                break;
            default:
                BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
                break;
        }
        try {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.egP();
            com.baidu.yuyinala.privatemessage.implugin.imagechooser.a.efr();
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.eft().c(this, th);
        }
        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.egZ().dismiss();
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mChatCategory " + ChatInfo.oyr + " mOnlineStatus " + this.ozW);
        if (ChatInfo.oyr == ChatInfo.ChatCategory.C2C && this.ozW != null) {
            efI();
        }
        if (this.ozE != null) {
            this.ozE.a((com.baidu.yuyinala.privatemessage.implugin.ui.activity.a) null);
        }
        if (this.ozF != null) {
            this.ozF.onDestroy();
        }
        if (this.ozE != null) {
            this.ozE.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i2) {
    }

    private void efI() {
        Intent intent = new Intent(IMConstants.NOTICE_USER_STATE);
        intent.putExtra(IMConstants.NOTICE_USER_STATE_OBJECT, this.ozW);
        sendBroadcast(intent);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "noticeSessionState com.baidu.android.imsdk.notice.userstate");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onResume--->");
        super.onResume();
        com.baidu.yuyinala.privatemessage.implugin.d.b.eft().zQ(true);
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onResume mIsCuidOrIncompleteLogin: " + this.ozQ + " loginState: " + loginState);
        if (this.ozQ && (!com.baidu.yuyinala.privatemessage.implugin.d.b.eft().isCuidLogin(this) || !com.baidu.yuyinala.privatemessage.implugin.d.b.eft().efu() || (loginState != 0 && loginState != 3))) {
            efA();
        } else if (this.ozX != null && this.ozX.egX() && ChatInfo.ChatCategory.DUZHAN == ChatInfo.oyr) {
            u(this.mPaid, true);
        }
        if (this.ozF != null) {
            this.ozF.onResume();
        }
        if (this.ozE != null) {
            this.ozE.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStop--->");
        super.onStop();
        if (this.ozF != null) {
            this.ozF.onStop();
        }
        if (this.ozE != null) {
            this.ozE.onStop();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStop");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStart--->");
        super.onStart();
        if (this.ozF != null) {
            this.ozF.onStart();
        }
        if (this.ozE != null) {
            this.ozE.onStart();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStart");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onPause--->");
        super.onPause();
        com.baidu.yuyinala.privatemessage.implugin.d.b.eft().zQ(false);
        if (this.ozF != null) {
            this.ozF.onPause();
        }
        if (this.ozE != null) {
            this.ozE.onPause();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<----onPause");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        onBackClick();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        super.dispatchKeyEvent(keyEvent);
        return false;
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    @SuppressLint({"Override"})
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    private String ay(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            this.aQY = ExtraParamsManager.getEncryptionUserId(extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oGi));
            this.ozO = extras.getBoolean("isMediaRole");
            this.mGroupId = extras.getString("groupid");
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("miliao", "mIsmediaRole：" + this.ozO);
            this.mLiveId = extras.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            ozP = this.ozO;
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oGi, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oGi));
            jSONObject.put("paid", extras.getString("paid"));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oGk, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oGk));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oGm, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oGm));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oGl, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oGl));
            String jSONObject2 = jSONObject.toString();
            try {
                if (!TextUtils.isEmpty(extras.getString("action"))) {
                    Serializable serializable = extras.getSerializable("params");
                    if (serializable instanceof ImBaseEntity) {
                        this.ozY = (ImBaseEntity) serializable;
                        if (this.ozM == null) {
                            GroupInfo groupInfo = new GroupInfo(String.valueOf(this.ozY.id));
                            groupInfo.setGroupName(this.ozY.name);
                            groupInfo.setDescription(this.ozY.description);
                            groupInfo.setHeadUrl(this.ozY.headUrl);
                            this.ozM = new QMGroupInfo(groupInfo);
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
        efL();
        String ay = ay(intent);
        if (this.ozA != null) {
            if (this.ozO) {
                this.ozA.setVisibility(8);
            } else {
                this.ozA.setVisibility(0);
            }
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + ay);
        ChatInfo.mContacter = -1L;
        ChatInfo.oyt = -1L;
        ChatInfo.mAppid = -1L;
        ChatInfo.mUid = -1L;
        ChatInfo.oyu = "";
        ChatInfo.oyv = "";
        ChatInfo.kbE = -1;
        ChatInfo.oyz = 0;
        ChatInfo.oyC = true;
        ChatInfo.oyB = false;
        try {
            JSONObject jSONObject = new JSONObject(ay);
            int i2 = jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.oGl) ? jSONObject.getInt(com.baidu.yuyinala.privatemessage.implugin.util.d.oGl) : -1;
            if (i2 == -1) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "invoke error -1");
                return;
            }
            if (i2 == 80) {
                parseLong = Long.parseLong(jSONObject.optString("paid", "-1"));
            } else {
                parseLong = Long.parseLong(jSONObject.optString(com.baidu.yuyinala.privatemessage.implugin.util.d.oGi, "-1"));
            }
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + ay);
            if (this.ozT != -1 && (this.ozT != i2 || this.ozU != parseLong)) {
                if (this.ozE != null) {
                    this.ozE.egx();
                }
                if (this.ozv != null) {
                    this.ozv.setText("");
                }
            }
            this.ozT = i2;
            switch (i2) {
                case 0:
                    ChatInfo.oyr = ChatInfo.ChatCategory.C2C;
                    try {
                        this.ozN = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oGi));
                        ChatInfo.mUid = this.ozN;
                        efK();
                        this.mNickName = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oGk);
                        this.mIcon = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oGm);
                        if (jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.oGo)) {
                            ChatInfo.oyC = jSONObject.getBoolean(com.baidu.yuyinala.privatemessage.implugin.util.d.oGo);
                        }
                    } catch (Exception e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "init uid and name error");
                    }
                    this.ozw.setVisibility(8);
                    this.mListenerKey = String.valueOf(this.ozN);
                    Xk(this.mNickName);
                    hw(this.ozN);
                    return;
                case 80:
                    ChatInfo.oyr = ChatInfo.ChatCategory.DUZHAN;
                    eB(jSONObject);
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
            com.baidu.yuyinala.privatemessage.implugin.d.b.eft().c(this, e3);
        }
    }

    private void eB(JSONObject jSONObject) {
        try {
            this.mPaid = Long.parseLong(jSONObject.getString("paid"));
            ChatInfo.mPaid = this.mPaid;
            if (this.ozO) {
                long parseLong = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oGi));
                if (parseLong > 0) {
                    ChatInfo.mUid = parseLong;
                }
            }
            efM();
        } catch (Exception e2) {
            LogUtils.e(MAFragmentActivity.TAG, "init appid error");
        }
        this.mListenerKey = String.valueOf(this.mPaid);
        hv(this.mPaid);
    }

    private void hv(long j2) {
        this.ozw.setVisibility(8);
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
                    ActivityChat.this.oAb.post(ActivityChat.this.oAf);
                }
            });
        } else {
            this.oAb.post(this.oAf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class h implements Runnable {
        private final SoftReference<ActivityChat> oAt;

        private h(ActivityChat activityChat) {
            this.oAt = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oAt.get() != null) {
                try {
                    ChatInfo.oyt = AccountManager.getUK(this.oAt.get().getApplicationContext());
                    this.oAt.get();
                    LogUtils.d(MAFragmentActivity.TAG, "parunnable ---> " + ChatInfo.oyt);
                    if (ChatInfo.oyt != -1) {
                        this.oAt.get().bwz = 0;
                        this.oAt.get().efJ();
                        this.oAt.get();
                        LogUtils.d(MAFragmentActivity.TAG, "parunnable -->1");
                        ChatInfo.mContacter = this.oAt.get().mPaInfo.getPaId();
                        ChatInfo.mPainfo = this.oAt.get().mPaInfo;
                        if (ChatInfo.oyr == ChatInfo.ChatCategory.DUZHAN) {
                            this.oAt.get().jGW = ChatMsgManager.getUnReadMsgCountByPaid(this.oAt.get(), this.oAt.get().mPaid);
                            if (this.oAt.get().jGW > 200) {
                                this.oAt.get().jGW = 200;
                            }
                        }
                        this.oAt.get().Td();
                        this.oAt.get().u(this.oAt.get().mPaid, true);
                    } else {
                        this.oAt.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    this.oAt.get().ozV = TextUtils.isEmpty(this.oAt.get().ozV) ? this.oAt.get().mPaInfo.getNickName() : this.oAt.get().ozV;
                    this.oAt.get().ozv.setText(String.valueOf(this.oAt.get().ozV));
                    this.oAt.get().efG();
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efJ() {
        com.baidu.yuyinala.privatemessage.implugin.d.b.eft().a(getActivity(), new IGetUsersProfileBatchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.18
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2) {
                if (i2 == 0 && arrayList2 != null && arrayList2.size() == 1) {
                    ChatInfo.oyu = ActivityChat.this.Xm(arrayList2.get(0).getIconUrl());
                    ChatInfo.displayname = arrayList2.get(0).getUserName();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efK() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.b(ExtraParamsManager.getEncryptionUserId(ChatInfo.mUid + "")));
    }

    private static void efL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031061, TbConfig.SERVER_ADDRESS + "ala/audio/user/preFollow");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void efM() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.a(ExtraParamsManager.getEncryptionUserId(this.mPaid + "")));
    }

    private void efN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031067, TbConfig.SERVER_ADDRESS + "ala/audio/user/getPaBindInfo");
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
                        ActivityChat.this.efK();
                    }
                }
            }
        });
    }

    public boolean efO() {
        return this.ozT == 2 || this.ozT == 11;
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
        this.ozs = (RelativeLayout) findViewById(a.f.bd_im_chat_title_root);
        this.ozt = findViewById(a.f.bd_im_chat_cell_space_line);
        this.ozu = (TextView) findViewById(a.f.bd_im_chat_open_main);
        this.ozA = (LinearLayout) findViewById(a.f.bd_im_chat_open_main_click_parent);
        this.ozA.setOnClickListener(this.oAg);
        this.ozB = (RelativeLayout) findViewById(a.f.bd_im_chat_back_layout);
        this.ozB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.onBackClick();
            }
        });
        this.ozv = (TextView) findViewById(a.f.bd_im_chat_title);
        this.ozw = (TextView) findViewById(a.f.bd_im_chat_subtitle);
        this.ozx = findViewById(a.f.bd_im_chat_main_input);
        this.ozy = (FrameLayout) findViewById(a.f.bd_im_chat_main_content);
        this.ozz = (FrameLayout) findViewById(a.f.bd_im_chat_main_input);
        this.ozC = (FrameLayout) findViewById(a.f.bd_im_chat_main_error_content);
        this.ozK = (ImageView) findViewById(a.f.bd_im_chat_main_error_image);
        this.ozC.setVisibility(8);
        this.ozD = (FrameLayout) findViewById(a.f.bd_im_chat_main_retry_content);
        this.ozD.setVisibility(8);
        findViewById(a.f.bd_im_chat_main_retry_button).setOnClickListener(this.oAe);
        this.ozv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.efT();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Td() {
        if (this.ozE == null) {
            FrameLayout frameLayout = this.ozy;
            this.ozy.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_chat, null));
            this.ozE = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.a(this, this.ozy, this.mListenerKey, this.oAa, this.jGW);
        }
        if (this.ozF == null) {
            FrameLayout frameLayout2 = this.ozz;
            this.ozz.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_input, null));
            this.ozF = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.a(this, this.ozz, this.mListenerKey, this.oAa);
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "initFragment : ");
        if (!isFinishing()) {
            try {
                com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "mTransaction.commitAllowingStateLoss() : ");
            } catch (Exception e2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "e :" + e2);
                com.baidu.yuyinala.privatemessage.implugin.d.b.eft().c(this, e2);
            }
        }
        if (this.ozE != null) {
            this.ozE.a(this);
        }
        hx(this.ozN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void efP() {
        this.ozR = AnimationUtils.loadAnimation(this, a.C0195a.bd_im_fragment_in_from_bottom);
        this.ozS = AnimationUtils.loadAnimation(this, a.C0195a.bd_im_fragment_out_to_bottom);
    }

    private void hw(long j2) {
        if (j2 == 0) {
            this.ozL = null;
            showToast(a.h.bd_im_read_error);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j2));
        final SoftReference softReference = new SoftReference(this);
        com.baidu.yuyinala.privatemessage.implugin.d.b.eft().a(getApplicationContext(), arrayList, false, new b.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList2, ArrayList<ChatUser> arrayList3) {
                if (softReference.get() != null) {
                    if (i2 != 0) {
                        ((ActivityChat) softReference.get()).oAb.post(ActivityChat.this.oAk);
                        return;
                    }
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        ((ActivityChat) softReference.get()).ozL = arrayList3.get(0);
                    }
                    if (((ActivityChat) softReference.get()).ozL == null) {
                        ((ActivityChat) softReference.get()).oAb.post(ActivityChat.this.oAj);
                        return;
                    }
                    ArrayList<Long> arrayList4 = new ArrayList<>();
                    arrayList4.add(Long.valueOf(ActivityChat.this.ozL.getUk()));
                    com.baidu.yuyinala.privatemessage.implugin.d.b.eft().a(ActivityChat.this.getApplicationContext(), arrayList4, new b.InterfaceC0948b() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7.1
                        @Override // com.baidu.android.imsdk.chatuser.IGetUserStatusListener
                        public void onGetUsersStatusResult(int i3, String str2, ArrayList<UserStatus> arrayList5) {
                            if (i3 == 0 && arrayList5.size() == 1) {
                                ((ActivityChat) softReference.get()).ozW = arrayList5.get(0);
                                ((ActivityChat) softReference.get()).oAb.post(ActivityChat.this.oAh);
                            }
                        }
                    });
                    ((ActivityChat) softReference.get()).oAb.post(ActivityChat.this.oAi);
                }
            }
        });
        com.baidu.yuyinala.privatemessage.implugin.f.k.gD(getApplicationContext()).b(j2, new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.8
            @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
            public void d(int i2, String str, long j3) {
                try {
                    LogUtils.d(MAFragmentActivity.TAG, "getUserSubscribe->" + str);
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1) == 0) {
                        JSONArray jSONArray = jSONObject.optJSONObject("data").getJSONArray("items");
                        if (jSONArray == null || jSONArray.length() < 1) {
                            ActivityChat.this.oAb.sendEmptyMessageDelayed(7, 1000L);
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
            com.baidu.yuyinala.privatemessage.implugin.e.a.gC(getApplicationContext()).gT("542", "chat_flow_time");
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
        }
    }

    protected void hx(long j2) {
    }

    protected void efQ() {
    }

    public ImBaseEntity efR() {
        return this.ozY;
    }

    protected void efS() {
    }

    protected void Xk(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ozv.setText(str);
        } else if (this.mNickName != null) {
            this.ozv.setText(String.valueOf(this.mNickName));
        } else if (this.ozL != null) {
            this.ozv.setText(String.valueOf(this.ozL.getUserName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efT() {
        String liveId = getLiveId();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig((Context) getActivity(), ChatInfo.mUid + "", (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, 0L, 0L, 0L, 0, getGroupId(), liveId, false, (String) null, (String) null, (String) null, (String) null, (String) null)));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
    }

    /* loaded from: classes4.dex */
    private static class l implements Runnable {
        private final SoftReference<ActivityChat> oAs;

        private l(ActivityChat activityChat) {
            this.oAs = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes4.dex */
    private static class k implements Runnable {
        private final SoftReference<ActivityChat> oAs;

        private k(ActivityChat activityChat) {
            this.oAs = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oAs.get() != null) {
                try {
                    ChatInfo.oyt = AccountManager.getUK(this.oAs.get().getApplicationContext());
                    if (ChatInfo.oyt != -1) {
                        this.oAs.get().bwz = 0;
                        this.oAs.get().efU();
                        this.oAs.get().Td();
                        this.oAs.get().hy(this.oAs.get().ozN);
                    } else {
                        this.oAs.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    if (this.oAs.get().mNickName == null) {
                        if (this.oAs.get().ozL != null) {
                            this.oAs.get().ozv.setText(String.valueOf(this.oAs.get().ozL.getUserName()));
                            return;
                        }
                        return;
                    }
                    this.oAs.get().ozv.setText(String.valueOf(this.oAs.get().mNickName));
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hy(long j2) {
        if (Xl(String.valueOf(j2))) {
        }
    }

    private boolean Xl(String str) {
        String z = com.baidu.yuyinala.privatemessage.implugin.util.b.b.z(getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGE, null);
        boolean z2 = false;
        if (!TextUtils.isEmpty(z)) {
            try {
                JSONObject jSONObject = new JSONObject(z);
                if (jSONObject.has(str)) {
                    z2 = jSONObject.getBoolean(str);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        LogUtils.i(MAFragmentActivity.TAG, "is support IM:" + z2 + " data:" + z);
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efU() {
        efJ();
        ChatInfo.mContacter = this.ozL.getUk();
        ChatInfo.mUid = this.ozL.getBuid();
        ChatInfo.mStatus = 3;
        ChatInfo.oys = this.ozL.getUserName();
        if (!TextUtils.isEmpty(this.mIcon)) {
            ChatInfo.oyv = this.mIcon;
        } else {
            ChatInfo.oyv = Xm(this.ozL.getIconUrl());
        }
        BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
        LogUtils.i(MAFragmentActivity.TAG, "uk:" + ChatInfo.oyt);
        LogUtils.i(MAFragmentActivity.TAG, "header:" + ChatInfo.oyu);
        LogUtils.i(MAFragmentActivity.TAG, "" + this.ozL.toString());
    }

    /* loaded from: classes4.dex */
    private static class j implements Runnable {
        private final SoftReference<ActivityChat> oAs;

        private j(ActivityChat activityChat) {
            this.oAs = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oAs.get() != null) {
                try {
                    ChatInfo.oyt = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().gx(this.oAs.get().getApplicationContext()).longValue();
                    this.oAs.get().bwz = 0;
                    this.oAs.get().Td();
                    if (this.oAs.get().mNickName != null) {
                        this.oAs.get().ozv.setText(String.valueOf(this.oAs.get().mNickName));
                    }
                    this.oAs.get().oAb.sendEmptyMessage(1);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final SoftReference<ActivityChat> oAs;

        private a(ActivityChat activityChat) {
            this.oAs = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oAs.get() != null) {
                try {
                    ChatInfo.oyt = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().gx(this.oAs.get().getApplicationContext()).longValue();
                    this.oAs.get().bwz = 1;
                    this.oAs.get().Td();
                    if (this.oAs.get().mNickName != null) {
                        this.oAs.get().ozv.setText(String.valueOf(this.oAs.get().mNickName));
                    }
                    this.oAs.get().oAb.sendEmptyMessage(1006);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class b implements Runnable {
        private final SoftReference<ActivityChat> oAs;

        private b(ActivityChat activityChat) {
            this.oAs = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oAs.get() != null) {
                try {
                    ChatInfo.oyt = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().gx(this.oAs.get().getApplicationContext()).longValue();
                    String str = null;
                    if (this.oAs.get().ozM != null) {
                        str = this.oAs.get().ozM.mInfo.getGroupName();
                    }
                    if (ChatInfo.kbE == 2) {
                        if (str == null || "".equals(str.trim())) {
                            if (this.oAs.get().mNickName != null) {
                                this.oAs.get().ozv.setText(String.valueOf(this.oAs.get().mNickName));
                                return;
                            } else if (this.oAs.get().ozM != null) {
                                this.oAs.get().ozv.setText(String.valueOf(str));
                                return;
                            } else {
                                return;
                            }
                        }
                        this.oAs.get().ozv.setText(String.valueOf(str));
                    } else if (!TextUtils.isEmpty(str)) {
                        this.oAs.get().ozv.setText(String.valueOf(str));
                        this.oAs.get().ozw.setText(this.oAs.get().ozM.mInfo.getNum() + "人");
                    } else if (!TextUtils.isEmpty(this.oAs.get().mNickName)) {
                        this.oAs.get().ozv.setText(String.valueOf(this.oAs.get().mNickName));
                        this.oAs.get().ozw.setText(this.oAs.get().ozM.mInfo.getNum() + "人");
                    } else if (this.oAs.get().ozM != null) {
                        this.oAs.get().ozv.setText("未知群");
                        this.oAs.get().ozw.setText(this.oAs.get().ozM.mInfo.getNum() + "人");
                    }
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class d implements Runnable {
        private final SoftReference<ActivityChat> oAs;

        private d(ActivityChat activityChat) {
            this.oAs = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oAs.get() != null) {
                try {
                    this.oAs.get().ozx.setVisibility(0);
                    this.oAs.get().ozx.startAnimation(this.oAs.get().ozR);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class e implements Runnable {
        private final SoftReference<ActivityChat> oAs;

        private e(ActivityChat activityChat) {
            this.oAs = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oAs.get() != null) {
                try {
                    this.oAs.get().ozx.setVisibility(8);
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j2, final boolean z) {
        com.baidu.yuyinala.privatemessage.implugin.f.k.gD(getApplicationContext()).a(j2, new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.9
            @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
            public void d(int i2, String str, long j3) {
                Message message = new Message();
                message.what = 6;
                Bundle bundle = new Bundle();
                bundle.putString("subscribe_data", str);
                bundle.putBoolean("update_subscribe", z);
                message.setData(bundle);
                ActivityChat.this.oAb.sendMessage(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oc(int i2) {
        Date date;
        String str = null;
        long j2 = -1;
        if (i2 == 1) {
            str = com.baidu.yuyinala.privatemessage.implugin.f.j.getType();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.baidu.yuyinala.privatemessage.implugin.f.j.efx())) {
                try {
                    j2 = Long.parseLong(com.baidu.yuyinala.privatemessage.implugin.f.j.efx());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.b.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGJ + ChatInfo.mPaid + ChatInfo.oyt, 0L));
            } else {
                return;
            }
        } else if (i2 == 0) {
            str = "ugc";
            j2 = this.ozN;
            date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.b.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGK + this.ozN, 0L));
        } else {
            date = null;
        }
        if (!com.baidu.yuyinala.privatemessage.implugin.util.f.c(date, new Date())) {
            if ((this.ozX == null || !this.ozX.egX() || this.ozX.egY() != i2) && this.ozE != null) {
                this.ozX = this.ozE.aq(i2, efO());
                if (this.ozX != null) {
                    try {
                        this.ozX.c(str, j2, new g(this, i2));
                    } catch (NumberFormatException e3) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, e3.getMessage());
                    }
                    com.baidu.yuyinala.privatemessage.implugin.e.a.gC(getApplicationContext()).add("416", "subscribe_show");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
                    activityChat.efz().sendMessage(message);
                } else if (this.flag == 0) {
                    Message message2 = new Message();
                    if (z) {
                        message2.arg1 = 0;
                    } else {
                        message2.arg1 = -1;
                    }
                    message2.what = 8;
                    activityChat.efz().sendMessage(message2);
                }
            }
        }
    }

    public void onBackClick() {
        if (this.bwz == 0) {
            if (this.ozF != null) {
                this.ozF.egD();
            }
            if (this.ozX != null) {
                this.ozX.egW();
            }
        }
        finish();
        if (!ChatInfo.oyC) {
            com.baidu.yuyinala.privatemessage.implugin.d.b.eft().gB(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Xm(String str) {
        return str;
    }
}
