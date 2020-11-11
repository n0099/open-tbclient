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
    public static boolean oyl;
    protected String aSJ;
    protected boolean isFollowed;
    private LinearLayout mContainer;
    private String mGroupId;
    private String mIcon;
    private String mLiveId;
    private String mNickName;
    private PaInfo mPaInfo;
    public long mPaid;
    private RelativeLayout oxO;
    private View oxP;
    private TextView oxQ;
    private TextView oxR;
    private TextView oxS;
    private View oxT;
    private FrameLayout oxU;
    private FrameLayout oxV;
    private LinearLayout oxW;
    private RelativeLayout oxX;
    private FrameLayout oxY;
    private FrameLayout oxZ;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a oya;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b oyb;
    private LinearLayout oyc;
    private TextView oyd;
    private ImageView oye;
    private ImageView oyf;
    private ImageView oyg;
    private ChatUser oyh;
    protected QMGroupInfo oyi;
    protected long oyj;
    public boolean oyk;
    private Animation oyn;
    private Animation oyo;
    private String oyr;
    private UserStatus oys;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c oyt;
    protected ImBaseEntity oyu;
    private com.baidu.yuyinala.privatemessage.implugin.ui.a.a oyv;
    private long oyy;
    private int jFX = 0;
    public boolean oym = false;
    private int byk = 1;
    private String mListenerKey = "";
    private int oyp = -1;
    private long oyq = -1;
    private c oyw = new c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.1
        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.c
        public void efX() {
            ActivityChat.this.oyx.sendEmptyMessage(1002);
        }
    };
    private f oyx = new f();
    private boolean oyz = false;
    private View.OnClickListener oyA = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().getLoginState(ActivityChat.this);
            ActivityChat.this.oyy = System.currentTimeMillis();
            ActivityChat.this.oyz = false;
            if (loginState == 3) {
                ActivityChat.this.oyx.removeCallbacks(ActivityChat.this.fOA);
                ActivityChat.this.oyx.postDelayed(ActivityChat.this.fOA, ActivityChat.this.efD());
                ActivityChat.this.oxZ.setVisibility(8);
                ActivityChat.this.init(ActivityChat.this.getIntent());
                return;
            }
            ActivityChat.this.oyx.postDelayed(ActivityChat.this.fOA, 7000L);
            ActivityChat.this.efE();
        }
    };
    private Runnable fOA = new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mTimeOutRunnable run ");
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.efv().getLoginState(ActivityChat.this) != 3) {
                ActivityChat.this.oyz = true;
                ActivityChat.this.efF();
                return;
            }
            ActivityChat.this.efG();
        }
    };
    private h oyB = new h();
    private View.OnClickListener oyC = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChat.this.efS();
            if (ActivityChat.this.byk == 0 && ActivityChat.this.oyb != null) {
                ActivityChat.this.oyb.egF();
            }
        }
    };
    private l oyD = new l();
    private k oyE = new k();
    private j oyF = new j();
    private a oyG = new a();
    private b oyH = new b();
    d oyI = new d();
    e oyJ = new e();

    /* loaded from: classes4.dex */
    public interface c {
        void efX();
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
    public void Xy(String str) {
        if ("greet_link".equals(str)) {
            String egc = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.egc();
            String str2 = "";
            if (!TextUtils.isEmpty(ChatInfo.nickname)) {
                str2 = ChatInfo.nickname;
            } else if (!TextUtils.isEmpty(ChatInfo.displayname)) {
                str2 = ChatInfo.displayname;
            }
            com.baidu.yuyinala.privatemessage.model.message.a.eil().B(this, egc.replace("XXX", str2), this.mListenerKey);
        } else if ("welcom_link".equals(str)) {
            com.baidu.yuyinala.privatemessage.model.message.a.eil().B(this, com.baidu.yuyinala.privatemessage.implugin.ui.common.b.egd(), this.mListenerKey);
        }
    }

    public f efB() {
        return this.oyx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class f extends Handler {
        private final SoftReference<ActivityChat> oyO;

        private f(ActivityChat activityChat) {
            this.oyO = new SoftReference<>(activityChat);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            String str;
            int i2 = 0;
            boolean z = false;
            super.handleMessage(message);
            if (this.oyO.get() != null) {
                try {
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.oyO.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "current is no support");
                        this.oyO.get().oxW.setVisibility(4);
                        ChatInfo.mStatus = 10;
                        if (this.oyO.get().oyb != null) {
                            this.oyO.get().oyb.egy();
                        }
                        if (this.oyO.get().oya != null) {
                            this.oyO.get().oya.egy();
                            return;
                        }
                        return;
                    case 2:
                        if (message.arg1 == 1) {
                            com.baidu.yuyinala.privatemessage.implugin.f.j.zK(true);
                            postDelayed(new i(this.oyO), 1000L);
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.ehb().br(this.oyO.get().getApplicationContext(), this.oyO.get().getString(a.h.bd_im_zhida_success_tip));
                            if (this.oyO.get().oyt != null) {
                                this.oyO.get().oyt.dismiss();
                            }
                            String efz = com.baidu.yuyinala.privatemessage.implugin.f.j.efz();
                            if (!TextUtils.isEmpty(efz)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("sign", "media_" + efz);
                                    jSONObject.put("relation", 1);
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.efv().y(this.oyO.get().getApplicationContext(), "com.baidu.channel.subscribe", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
                                    return;
                                } catch (UnsupportedEncodingException e2) {
                                    e2.printStackTrace();
                                    return;
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            this.oyO.get();
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
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.ehb().bq(this.oyO.get().getApplicationContext(), str);
                            return;
                        } else {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.ehb().bq(this.oyO.get().getApplicationContext(), this.oyO.get().getString(a.h.bd_im_subscribe_fail_tip));
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                        return;
                    case 3:
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.ehb().showToast(this.oyO.get().getApplicationContext(), this.oyO.get().getString(a.h.bd_im_zhida_fail_net_tip));
                        return;
                    case 5:
                        this.oyO.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 1 ");
                        this.oyO.get().finish();
                        this.oyO.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 2 ");
                        return;
                    case 6:
                        Bundle data = message.getData();
                        String str2 = "";
                        if (data != null) {
                            str2 = data.getString("subscribe_data");
                            z = data.getBoolean("update_subscribe", false);
                        }
                        com.baidu.yuyinala.privatemessage.implugin.f.j.Xv(str2);
                        ChatInfo.mPainfo.setMsgNotify(com.baidu.yuyinala.privatemessage.implugin.f.j.isNeedNotify());
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.isSubscribed() || !z) {
                            if (this.oyO.get().oyt != null && this.oyO.get().oyt.egZ()) {
                                this.oyO.get().oyt.dismiss();
                            }
                        } else {
                            this.oyO.get().Nz(1);
                        }
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.getData() != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.b.b.A(this.oyO.get().getApplicationContext(), String.valueOf(this.oyO.get().mPaid), com.baidu.yuyinala.privatemessage.implugin.f.j.getData().toString());
                            return;
                        }
                        return;
                    case 7:
                        this.oyO.get().Nz(0);
                        return;
                    case 8:
                        if (message.arg1 == 0) {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.ehb().bq(this.oyO.get(), "关注成功");
                            this.oyO.get().oyt.dismiss();
                            this.oyO.get().efU();
                            this.oyO.get().isFollowed = true;
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.ehb().bq(this.oyO.get(), "关注失败");
                        return;
                    case 1001:
                        if (this.oyO.get().oyc != null && this.oyO.get().oyc.getVisibility() == 0) {
                            this.oyO.get().oyc.setAnimation(AnimationUtils.loadAnimation(this.oyO.get(), a.C0197a.bd_im_slip_out_from_right));
                            this.oyO.get().oyc.setVisibility(4);
                            return;
                        }
                        return;
                    case 1002:
                        this.oyO.get().efJ();
                        return;
                    case 1003:
                        if (this.oyO.get().oye != null && this.oyO.get().oye.getVisibility() == 0) {
                            this.oyO.get().oye.setAnimation(AnimationUtils.loadAnimation(this.oyO.get(), a.C0197a.bd_im_disappear_out));
                            this.oyO.get().oye.setVisibility(4);
                            return;
                        }
                        return;
                    case 1006:
                        this.oyO.get().oxW.setVisibility(4);
                        ChatInfo.mStatus = 11;
                        if (this.oyO.get().oyb != null) {
                            this.oyO.get().oyb.egy();
                        }
                        this.oyO.get().oxY.setVisibility(0);
                        return;
                    case 1007:
                    case 1008:
                        return;
                    case 1009:
                        if (this.oyO.get().oya != null) {
                            this.oyO.get().oya.zN(false);
                        }
                        this.oyO.get().oxZ.setVisibility(8);
                        this.oyO.get().init(this.oyO.get().getIntent());
                        return;
                    case 1010:
                        if (this.oyO.get().oya != null) {
                            this.oyO.get().oya.zN(true);
                        }
                        if (this.oyO.get().oyb != null) {
                            this.oyO.get().oyb.egy();
                            return;
                        }
                        return;
                    case 1011:
                        this.oyO.get().oxW.setVisibility(4);
                        ChatInfo.mStatus = 12;
                        if (this.oyO.get().oyb != null) {
                            this.oyO.get().oyb.egy();
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
        private final SoftReference<ActivityChat> oyO;

        private i(SoftReference<ActivityChat> softReference) {
            this.oyO = softReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oyO.get() != null) {
                this.oyO.get().u(this.oyO.get().mPaid, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BIMManager.mediaSetRole(getActivity(), true);
        efP();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        setContentView(a.g.bd_im_chat_activity_layout);
        this.mContainer = (LinearLayout) findViewById(a.f.bd_im_chat_root);
        this.oyv = new com.baidu.yuyinala.privatemessage.implugin.ui.a.a();
        efR();
        init(getIntent());
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.efv().isCuidLogin(this) || com.baidu.yuyinala.privatemessage.implugin.d.b.efv().efw()) {
            this.oym = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    private void efC() {
        this.oyy = System.currentTimeMillis();
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "loginOver loginState: " + loginState);
        if (this.oya != null) {
            this.oya.egz();
        }
        switch (loginState) {
            case 2:
                this.oyx.postDelayed(this.fOA, 7000L);
                efE();
                return;
            case 3:
                this.oyx.postDelayed(this.fOA, efD());
                this.oxZ.setVisibility(8);
                this.oyx.sendEmptyMessage(1009);
                return;
            default:
                this.oyx.postDelayed(this.fOA, 7000L);
                efH();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long efD() {
        long currentTimeMillis = 10000 - (System.currentTimeMillis() - this.oyy);
        if (currentTimeMillis > 7000) {
            return 7000L;
        }
        return currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efE() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "retryLogin timeout " + this.oyz);
        if (!this.oyz) {
            this.oyx.sendEmptyMessage(1010);
            com.baidu.yuyinala.privatemessage.implugin.d.b.efv().a(this, new b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.13
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
    public void efF() {
        if (this.oya != null) {
            this.oya.zN(false);
        }
        if (this.oyb != null) {
            this.oyb.egy();
        }
        this.oxZ.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efG() {
        if (this.oya != null) {
            this.oya.zN(false);
        }
    }

    private void efH() {
        this.oyx.sendEmptyMessage(1010);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus ");
        com.baidu.yuyinala.privatemessage.implugin.d.b.efv().a(this, new b.e() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.14
            @Override // com.baidu.android.imsdk.account.ILoginStateChangedListener
            public void onLoginStateChanged(int i2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus onLoginStateChanged state: " + i2);
                switch (i2) {
                    case 2:
                        ActivityChat.this.efE();
                        return;
                    case 3:
                        ActivityChat.this.oyx.removeCallbacks(ActivityChat.this.fOA);
                        ActivityChat.this.oyx.postDelayed(ActivityChat.this.fOA, ActivityChat.this.efD());
                        ActivityChat.this.oyx.sendEmptyMessage(1009);
                        return;
                    default:
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "waitting");
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efI() {
        if (this.jFX > 8) {
            if (this.oyc == null) {
                this.oyc = (LinearLayout) findViewById(a.f.bd_im_chat_unread_msgs_layout);
                this.oyd = (TextView) findViewById(a.f.bd_im_chat_unread_msgs_txt);
                this.oyd.setText(this.jFX + getString(a.h.bd_im_alert_unread_msgs));
            }
            this.oyf = (ImageView) findViewById(a.f.bd_im_chat_unread_msgs_up);
            try {
                this.oyc.setBackgroundResource(ThemeManager.L(this, a.e.bd_im_chat_unread_msgs_background));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.oyc.setAnimation(AnimationUtils.loadAnimation(this, a.C0197a.bd_im_slip_in_from_right));
            this.oyc.setVisibility(0);
            this.oyc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.oya.NA(ActivityChat.this.jFX);
                    ActivityChat.this.oyc.setAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0197a.bd_im_slip_out_from_right));
                    ActivityChat.this.oyc.setVisibility(4);
                }
            });
            this.oyx.sendEmptyMessageDelayed(1001, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efJ() {
        if (this.oye == null) {
            this.oye = (ImageView) findViewById(a.f.bd_im_chat_new_msgs_tip);
            this.oye.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.oya.ego();
                    ActivityChat.this.oye.startAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0197a.bd_im_disappear_out));
                    ActivityChat.this.oye.setVisibility(4);
                }
            });
        }
        if (this.oye.getVisibility() != 0) {
            this.oye.startAnimation(AnimationUtils.loadAnimation(this, a.C0197a.bd_im_disappear_in));
            this.oye.setVisibility(0);
        }
        this.oyx.removeMessages(1003);
        this.oyx.sendEmptyMessageDelayed(1003, 10000L);
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
        switch (ChatInfo.owN) {
            case GROUP:
                com.baidu.yuyinala.privatemessage.implugin.d.b.efv().setAllMsgRead(getApplicationContext(), 1, ChatInfo.mContacter, false);
                break;
            default:
                BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
                break;
        }
        try {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.egR();
            com.baidu.yuyinala.privatemessage.implugin.imagechooser.a.eft();
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.efv().c(this, th);
        }
        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.ehb().dismiss();
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mChatCategory " + ChatInfo.owN + " mOnlineStatus " + this.oys);
        if (ChatInfo.owN == ChatInfo.ChatCategory.C2C && this.oys != null) {
            efK();
        }
        if (this.oya != null) {
            this.oya.a((com.baidu.yuyinala.privatemessage.implugin.ui.activity.a) null);
        }
        if (this.oyb != null) {
            this.oyb.onDestroy();
        }
        if (this.oya != null) {
            this.oya.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i2) {
    }

    private void efK() {
        Intent intent = new Intent(IMConstants.NOTICE_USER_STATE);
        intent.putExtra(IMConstants.NOTICE_USER_STATE_OBJECT, this.oys);
        sendBroadcast(intent);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "noticeSessionState com.baidu.android.imsdk.notice.userstate");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onResume--->");
        super.onResume();
        com.baidu.yuyinala.privatemessage.implugin.d.b.efv().zJ(true);
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onResume mIsCuidOrIncompleteLogin: " + this.oym + " loginState: " + loginState);
        if (this.oym && (!com.baidu.yuyinala.privatemessage.implugin.d.b.efv().isCuidLogin(this) || !com.baidu.yuyinala.privatemessage.implugin.d.b.efv().efw() || (loginState != 0 && loginState != 3))) {
            efC();
        } else if (this.oyt != null && this.oyt.egZ() && ChatInfo.ChatCategory.DUZHAN == ChatInfo.owN) {
            u(this.mPaid, true);
        }
        if (this.oyb != null) {
            this.oyb.onResume();
        }
        if (this.oya != null) {
            this.oya.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStop--->");
        super.onStop();
        if (this.oyb != null) {
            this.oyb.onStop();
        }
        if (this.oya != null) {
            this.oya.onStop();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStop");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStart--->");
        super.onStart();
        if (this.oyb != null) {
            this.oyb.onStart();
        }
        if (this.oya != null) {
            this.oya.onStart();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStart");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onPause--->");
        super.onPause();
        com.baidu.yuyinala.privatemessage.implugin.d.b.efv().zJ(false);
        if (this.oyb != null) {
            this.oyb.onPause();
        }
        if (this.oya != null) {
            this.oya.onPause();
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
            this.aSJ = ExtraParamsManager.getEncryptionUserId(extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oEE));
            this.oyk = extras.getBoolean("isMediaRole");
            this.mGroupId = extras.getString("groupid");
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("miliao", "mIsmediaRole：" + this.oyk);
            this.mLiveId = extras.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            oyl = this.oyk;
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oEE, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oEE));
            jSONObject.put("paid", extras.getString("paid"));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oEG, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oEG));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oEI, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oEI));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oEH, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oEH));
            String jSONObject2 = jSONObject.toString();
            try {
                if (!TextUtils.isEmpty(extras.getString("action"))) {
                    Serializable serializable = extras.getSerializable("params");
                    if (serializable instanceof ImBaseEntity) {
                        this.oyu = (ImBaseEntity) serializable;
                        if (this.oyi == null) {
                            GroupInfo groupInfo = new GroupInfo(String.valueOf(this.oyu.id));
                            groupInfo.setGroupName(this.oyu.name);
                            groupInfo.setDescription(this.oyu.description);
                            groupInfo.setHeadUrl(this.oyu.headUrl);
                            this.oyi = new QMGroupInfo(groupInfo);
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
        efN();
        String ay = ay(intent);
        if (this.oxW != null) {
            if (this.oyk) {
                this.oxW.setVisibility(8);
            } else {
                this.oxW.setVisibility(0);
            }
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + ay);
        ChatInfo.mContacter = -1L;
        ChatInfo.owP = -1L;
        ChatInfo.mAppid = -1L;
        ChatInfo.mUid = -1L;
        ChatInfo.owQ = "";
        ChatInfo.owR = "";
        ChatInfo.kaU = -1;
        ChatInfo.owV = 0;
        ChatInfo.owY = true;
        ChatInfo.owX = false;
        try {
            JSONObject jSONObject = new JSONObject(ay);
            int i2 = jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.oEH) ? jSONObject.getInt(com.baidu.yuyinala.privatemessage.implugin.util.d.oEH) : -1;
            if (i2 == -1) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "invoke error -1");
                return;
            }
            if (i2 == 80) {
                parseLong = Long.parseLong(jSONObject.optString("paid", "-1"));
            } else {
                parseLong = Long.parseLong(jSONObject.optString(com.baidu.yuyinala.privatemessage.implugin.util.d.oEE, "-1"));
            }
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + ay);
            if (this.oyp != -1 && (this.oyp != i2 || this.oyq != parseLong)) {
                if (this.oya != null) {
                    this.oya.egz();
                }
                if (this.oxR != null) {
                    this.oxR.setText("");
                }
            }
            this.oyp = i2;
            switch (i2) {
                case 0:
                    ChatInfo.owN = ChatInfo.ChatCategory.C2C;
                    try {
                        this.oyj = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oEE));
                        ChatInfo.mUid = this.oyj;
                        efM();
                        this.mNickName = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oEG);
                        this.mIcon = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oEI);
                        if (jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.oEK)) {
                            ChatInfo.owY = jSONObject.getBoolean(com.baidu.yuyinala.privatemessage.implugin.util.d.oEK);
                        }
                    } catch (Exception e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "init uid and name error");
                    }
                    this.oxS.setVisibility(8);
                    this.mListenerKey = String.valueOf(this.oyj);
                    Xz(this.mNickName);
                    ht(this.oyj);
                    return;
                case 80:
                    ChatInfo.owN = ChatInfo.ChatCategory.DUZHAN;
                    eG(jSONObject);
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
            com.baidu.yuyinala.privatemessage.implugin.d.b.efv().c(this, e3);
        }
    }

    private void eG(JSONObject jSONObject) {
        try {
            this.mPaid = Long.parseLong(jSONObject.getString("paid"));
            ChatInfo.mPaid = this.mPaid;
            if (this.oyk) {
                long parseLong = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oEE));
                if (parseLong > 0) {
                    ChatInfo.mUid = parseLong;
                }
            }
            efO();
        } catch (Exception e2) {
            LogUtils.e(MAFragmentActivity.TAG, "init appid error");
        }
        this.mListenerKey = String.valueOf(this.mPaid);
        hs(this.mPaid);
    }

    private void hs(long j2) {
        this.oxS.setVisibility(8);
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
                    ActivityChat.this.oyx.post(ActivityChat.this.oyB);
                }
            });
        } else {
            this.oyx.post(this.oyB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class h implements Runnable {
        private final SoftReference<ActivityChat> oyP;

        private h(ActivityChat activityChat) {
            this.oyP = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oyP.get() != null) {
                try {
                    ChatInfo.owP = AccountManager.getUK(this.oyP.get().getApplicationContext());
                    this.oyP.get();
                    LogUtils.d(MAFragmentActivity.TAG, "parunnable ---> " + ChatInfo.owP);
                    if (ChatInfo.owP != -1) {
                        this.oyP.get().byk = 0;
                        this.oyP.get().efL();
                        this.oyP.get();
                        LogUtils.d(MAFragmentActivity.TAG, "parunnable -->1");
                        ChatInfo.mContacter = this.oyP.get().mPaInfo.getPaId();
                        ChatInfo.mPainfo = this.oyP.get().mPaInfo;
                        if (ChatInfo.owN == ChatInfo.ChatCategory.DUZHAN) {
                            this.oyP.get().jFX = ChatMsgManager.getUnReadMsgCountByPaid(this.oyP.get(), this.oyP.get().mPaid);
                            if (this.oyP.get().jFX > 200) {
                                this.oyP.get().jFX = 200;
                            }
                        }
                        this.oyP.get().TM();
                        this.oyP.get().u(this.oyP.get().mPaid, true);
                    } else {
                        this.oyP.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    this.oyP.get().oyr = TextUtils.isEmpty(this.oyP.get().oyr) ? this.oyP.get().mPaInfo.getNickName() : this.oyP.get().oyr;
                    this.oyP.get().oxR.setText(String.valueOf(this.oyP.get().oyr));
                    this.oyP.get().efI();
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efL() {
        com.baidu.yuyinala.privatemessage.implugin.d.b.efv().a(getActivity(), new IGetUsersProfileBatchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.18
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2) {
                if (i2 == 0 && arrayList2 != null && arrayList2.size() == 1) {
                    ChatInfo.owQ = ActivityChat.this.XB(arrayList2.get(0).getIconUrl());
                    ChatInfo.displayname = arrayList2.get(0).getUserName();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efM() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.b(ExtraParamsManager.getEncryptionUserId(ChatInfo.mUid + "")));
    }

    private static void efN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031061, TbConfig.SERVER_ADDRESS + "ala/audio/user/preFollow");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void efO() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.a(ExtraParamsManager.getEncryptionUserId(this.mPaid + "")));
    }

    private void efP() {
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
                        ActivityChat.this.efM();
                    }
                }
            }
        });
    }

    public boolean efQ() {
        return this.oyp == 2 || this.oyp == 11;
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
        this.oxO = (RelativeLayout) findViewById(a.f.bd_im_chat_title_root);
        this.oxP = findViewById(a.f.bd_im_chat_cell_space_line);
        this.oxQ = (TextView) findViewById(a.f.bd_im_chat_open_main);
        this.oxW = (LinearLayout) findViewById(a.f.bd_im_chat_open_main_click_parent);
        this.oxW.setOnClickListener(this.oyC);
        this.oxX = (RelativeLayout) findViewById(a.f.bd_im_chat_back_layout);
        this.oxX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.onBackClick();
            }
        });
        this.oxR = (TextView) findViewById(a.f.bd_im_chat_title);
        this.oxS = (TextView) findViewById(a.f.bd_im_chat_subtitle);
        this.oxT = findViewById(a.f.bd_im_chat_main_input);
        this.oxU = (FrameLayout) findViewById(a.f.bd_im_chat_main_content);
        this.oxV = (FrameLayout) findViewById(a.f.bd_im_chat_main_input);
        this.oxY = (FrameLayout) findViewById(a.f.bd_im_chat_main_error_content);
        this.oyg = (ImageView) findViewById(a.f.bd_im_chat_main_error_image);
        this.oxY.setVisibility(8);
        this.oxZ = (FrameLayout) findViewById(a.f.bd_im_chat_main_retry_content);
        this.oxZ.setVisibility(8);
        findViewById(a.f.bd_im_chat_main_retry_button).setOnClickListener(this.oyA);
        this.oxR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.efV();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TM() {
        if (this.oya == null) {
            FrameLayout frameLayout = this.oxU;
            this.oxU.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_chat, null));
            this.oya = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.a(this, this.oxU, this.mListenerKey, this.oyw, this.jFX);
        }
        if (this.oyb == null) {
            FrameLayout frameLayout2 = this.oxV;
            this.oxV.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_input, null));
            this.oyb = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.a(this, this.oxV, this.mListenerKey, this.oyw);
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "initFragment : ");
        if (!isFinishing()) {
            try {
                com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "mTransaction.commitAllowingStateLoss() : ");
            } catch (Exception e2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "e :" + e2);
                com.baidu.yuyinala.privatemessage.implugin.d.b.efv().c(this, e2);
            }
        }
        if (this.oya != null) {
            this.oya.a(this);
        }
        hu(this.oyj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void efR() {
        this.oyn = AnimationUtils.loadAnimation(this, a.C0197a.bd_im_fragment_in_from_bottom);
        this.oyo = AnimationUtils.loadAnimation(this, a.C0197a.bd_im_fragment_out_to_bottom);
    }

    private void ht(long j2) {
        if (j2 == 0) {
            this.oyh = null;
            showToast(a.h.bd_im_read_error);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j2));
        final SoftReference softReference = new SoftReference(this);
        com.baidu.yuyinala.privatemessage.implugin.d.b.efv().a(getApplicationContext(), arrayList, false, new b.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList2, ArrayList<ChatUser> arrayList3) {
                if (softReference.get() != null) {
                    if (i2 != 0) {
                        ((ActivityChat) softReference.get()).oyx.post(ActivityChat.this.oyG);
                        return;
                    }
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        ((ActivityChat) softReference.get()).oyh = arrayList3.get(0);
                    }
                    if (((ActivityChat) softReference.get()).oyh == null) {
                        ((ActivityChat) softReference.get()).oyx.post(ActivityChat.this.oyF);
                        return;
                    }
                    ArrayList<Long> arrayList4 = new ArrayList<>();
                    arrayList4.add(Long.valueOf(ActivityChat.this.oyh.getUk()));
                    com.baidu.yuyinala.privatemessage.implugin.d.b.efv().a(ActivityChat.this.getApplicationContext(), arrayList4, new b.InterfaceC0945b() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7.1
                        @Override // com.baidu.android.imsdk.chatuser.IGetUserStatusListener
                        public void onGetUsersStatusResult(int i3, String str2, ArrayList<UserStatus> arrayList5) {
                            if (i3 == 0 && arrayList5.size() == 1) {
                                ((ActivityChat) softReference.get()).oys = arrayList5.get(0);
                                ((ActivityChat) softReference.get()).oyx.post(ActivityChat.this.oyD);
                            }
                        }
                    });
                    ((ActivityChat) softReference.get()).oyx.post(ActivityChat.this.oyE);
                }
            }
        });
        com.baidu.yuyinala.privatemessage.implugin.f.k.gF(getApplicationContext()).b(j2, new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.8
            @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
            public void d(int i2, String str, long j3) {
                try {
                    LogUtils.d(MAFragmentActivity.TAG, "getUserSubscribe->" + str);
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1) == 0) {
                        JSONArray jSONArray = jSONObject.optJSONObject("data").getJSONArray("items");
                        if (jSONArray == null || jSONArray.length() < 1) {
                            ActivityChat.this.oyx.sendEmptyMessageDelayed(7, 1000L);
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
            com.baidu.yuyinala.privatemessage.implugin.e.a.gE(getApplicationContext()).gT("542", "chat_flow_time");
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
        }
    }

    protected void hu(long j2) {
    }

    protected void efS() {
    }

    public ImBaseEntity efT() {
        return this.oyu;
    }

    protected void efU() {
    }

    protected void Xz(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oxR.setText(str);
        } else if (this.mNickName != null) {
            this.oxR.setText(String.valueOf(this.mNickName));
        } else if (this.oyh != null) {
            this.oxR.setText(String.valueOf(this.oyh.getUserName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efV() {
        String liveId = getLiveId();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig((Context) getActivity(), ChatInfo.mUid + "", (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, 0L, 0L, 0L, 0, getGroupId(), liveId, false, (String) null, (String) null, (String) null, (String) null, (String) null)));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
    }

    /* loaded from: classes4.dex */
    private static class l implements Runnable {
        private final SoftReference<ActivityChat> oyO;

        private l(ActivityChat activityChat) {
            this.oyO = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes4.dex */
    private static class k implements Runnable {
        private final SoftReference<ActivityChat> oyO;

        private k(ActivityChat activityChat) {
            this.oyO = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oyO.get() != null) {
                try {
                    ChatInfo.owP = AccountManager.getUK(this.oyO.get().getApplicationContext());
                    if (ChatInfo.owP != -1) {
                        this.oyO.get().byk = 0;
                        this.oyO.get().efW();
                        this.oyO.get().TM();
                        this.oyO.get().hv(this.oyO.get().oyj);
                    } else {
                        this.oyO.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    if (this.oyO.get().mNickName == null) {
                        if (this.oyO.get().oyh != null) {
                            this.oyO.get().oxR.setText(String.valueOf(this.oyO.get().oyh.getUserName()));
                            return;
                        }
                        return;
                    }
                    this.oyO.get().oxR.setText(String.valueOf(this.oyO.get().mNickName));
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hv(long j2) {
        if (XA(String.valueOf(j2))) {
        }
    }

    private boolean XA(String str) {
        String z = com.baidu.yuyinala.privatemessage.implugin.util.b.b.z(getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oFa, null);
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
    public void efW() {
        efL();
        ChatInfo.mContacter = this.oyh.getUk();
        ChatInfo.mUid = this.oyh.getBuid();
        ChatInfo.mStatus = 3;
        ChatInfo.owO = this.oyh.getUserName();
        if (!TextUtils.isEmpty(this.mIcon)) {
            ChatInfo.owR = this.mIcon;
        } else {
            ChatInfo.owR = XB(this.oyh.getIconUrl());
        }
        BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
        LogUtils.i(MAFragmentActivity.TAG, "uk:" + ChatInfo.owP);
        LogUtils.i(MAFragmentActivity.TAG, "header:" + ChatInfo.owQ);
        LogUtils.i(MAFragmentActivity.TAG, "" + this.oyh.toString());
    }

    /* loaded from: classes4.dex */
    private static class j implements Runnable {
        private final SoftReference<ActivityChat> oyO;

        private j(ActivityChat activityChat) {
            this.oyO = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oyO.get() != null) {
                try {
                    ChatInfo.owP = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().gA(this.oyO.get().getApplicationContext()).longValue();
                    this.oyO.get().byk = 0;
                    this.oyO.get().TM();
                    if (this.oyO.get().mNickName != null) {
                        this.oyO.get().oxR.setText(String.valueOf(this.oyO.get().mNickName));
                    }
                    this.oyO.get().oyx.sendEmptyMessage(1);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final SoftReference<ActivityChat> oyO;

        private a(ActivityChat activityChat) {
            this.oyO = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oyO.get() != null) {
                try {
                    ChatInfo.owP = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().gA(this.oyO.get().getApplicationContext()).longValue();
                    this.oyO.get().byk = 1;
                    this.oyO.get().TM();
                    if (this.oyO.get().mNickName != null) {
                        this.oyO.get().oxR.setText(String.valueOf(this.oyO.get().mNickName));
                    }
                    this.oyO.get().oyx.sendEmptyMessage(1006);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class b implements Runnable {
        private final SoftReference<ActivityChat> oyO;

        private b(ActivityChat activityChat) {
            this.oyO = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oyO.get() != null) {
                try {
                    ChatInfo.owP = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().gA(this.oyO.get().getApplicationContext()).longValue();
                    String str = null;
                    if (this.oyO.get().oyi != null) {
                        str = this.oyO.get().oyi.mInfo.getGroupName();
                    }
                    if (ChatInfo.kaU == 2) {
                        if (str == null || "".equals(str.trim())) {
                            if (this.oyO.get().mNickName != null) {
                                this.oyO.get().oxR.setText(String.valueOf(this.oyO.get().mNickName));
                                return;
                            } else if (this.oyO.get().oyi != null) {
                                this.oyO.get().oxR.setText(String.valueOf(str));
                                return;
                            } else {
                                return;
                            }
                        }
                        this.oyO.get().oxR.setText(String.valueOf(str));
                    } else if (!TextUtils.isEmpty(str)) {
                        this.oyO.get().oxR.setText(String.valueOf(str));
                        this.oyO.get().oxS.setText(this.oyO.get().oyi.mInfo.getNum() + "人");
                    } else if (!TextUtils.isEmpty(this.oyO.get().mNickName)) {
                        this.oyO.get().oxR.setText(String.valueOf(this.oyO.get().mNickName));
                        this.oyO.get().oxS.setText(this.oyO.get().oyi.mInfo.getNum() + "人");
                    } else if (this.oyO.get().oyi != null) {
                        this.oyO.get().oxR.setText("未知群");
                        this.oyO.get().oxS.setText(this.oyO.get().oyi.mInfo.getNum() + "人");
                    }
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class d implements Runnable {
        private final SoftReference<ActivityChat> oyO;

        private d(ActivityChat activityChat) {
            this.oyO = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oyO.get() != null) {
                try {
                    this.oyO.get().oxT.setVisibility(0);
                    this.oyO.get().oxT.startAnimation(this.oyO.get().oyn);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class e implements Runnable {
        private final SoftReference<ActivityChat> oyO;

        private e(ActivityChat activityChat) {
            this.oyO = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oyO.get() != null) {
                try {
                    this.oyO.get().oxT.setVisibility(8);
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
        com.baidu.yuyinala.privatemessage.implugin.f.k.gF(getApplicationContext()).a(j2, new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.9
            @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
            public void d(int i2, String str, long j3) {
                Message message = new Message();
                message.what = 6;
                Bundle bundle = new Bundle();
                bundle.putString("subscribe_data", str);
                bundle.putBoolean("update_subscribe", z);
                message.setData(bundle);
                ActivityChat.this.oyx.sendMessage(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nz(int i2) {
        Date date;
        String str = null;
        long j2 = -1;
        if (i2 == 1) {
            str = com.baidu.yuyinala.privatemessage.implugin.f.j.getType();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.baidu.yuyinala.privatemessage.implugin.f.j.efz())) {
                try {
                    j2 = Long.parseLong(com.baidu.yuyinala.privatemessage.implugin.f.j.efz());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.b.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oFf + ChatInfo.mPaid + ChatInfo.owP, 0L));
            } else {
                return;
            }
        } else if (i2 == 0) {
            str = "ugc";
            j2 = this.oyj;
            date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.b.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oFg + this.oyj, 0L));
        } else {
            date = null;
        }
        if (!com.baidu.yuyinala.privatemessage.implugin.util.f.c(date, new Date())) {
            if ((this.oyt == null || !this.oyt.egZ() || this.oyt.eha() != i2) && this.oya != null) {
                this.oyt = this.oya.aq(i2, efQ());
                if (this.oyt != null) {
                    try {
                        this.oyt.c(str, j2, new g(this, i2));
                    } catch (NumberFormatException e3) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, e3.getMessage());
                    }
                    com.baidu.yuyinala.privatemessage.implugin.e.a.gE(getApplicationContext()).add("416", "subscribe_show");
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
                    activityChat.efB().sendMessage(message);
                } else if (this.flag == 0) {
                    Message message2 = new Message();
                    if (z) {
                        message2.arg1 = 0;
                    } else {
                        message2.arg1 = -1;
                    }
                    message2.what = 8;
                    activityChat.efB().sendMessage(message2);
                }
            }
        }
    }

    public void onBackClick() {
        if (this.byk == 0) {
            if (this.oyb != null) {
                this.oyb.egF();
            }
            if (this.oyt != null) {
                this.oyt.egY();
            }
        }
        finish();
        if (!ChatInfo.owY) {
            com.baidu.yuyinala.privatemessage.implugin.d.b.efv().gD(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String XB(String str) {
        return str;
    }
}
