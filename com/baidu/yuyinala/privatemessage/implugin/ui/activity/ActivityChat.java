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
    public static boolean oOX;
    protected String aUa;
    protected boolean isFollowed;
    private LinearLayout mContainer;
    private String mGroupId;
    private String mIcon;
    private String mLiveId;
    private String mNickName;
    private PaInfo mPaInfo;
    public long mPaid;
    private RelativeLayout oOA;
    private View oOB;
    private TextView oOC;
    private TextView oOD;
    private TextView oOE;
    private View oOF;
    private FrameLayout oOG;
    private FrameLayout oOH;
    private LinearLayout oOI;
    private RelativeLayout oOJ;
    private FrameLayout oOK;
    private FrameLayout oOL;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a oOM;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b oON;
    private LinearLayout oOO;
    private TextView oOP;
    private ImageView oOQ;
    private ImageView oOR;
    private ImageView oOS;
    private ChatUser oOT;
    protected QMGroupInfo oOU;
    protected long oOV;
    public boolean oOW;
    private Animation oOZ;
    private Animation oPa;
    private String oPd;
    private UserStatus oPe;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c oPf;
    protected ImBaseEntity oPg;
    private com.baidu.yuyinala.privatemessage.implugin.ui.a.a oPh;
    private long oPk;
    private int jUB = 0;
    public boolean oOY = false;
    private int mChatStatus = 1;
    private String mListenerKey = "";
    private int oPb = -1;
    private long oPc = -1;
    private c oPi = new c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.1
        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.c
        public void elK() {
            ActivityChat.this.oPj.sendEmptyMessage(1002);
        }
    };
    private f oPj = new f();
    private boolean oPl = false;
    private View.OnClickListener oPm = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().getLoginState(ActivityChat.this);
            ActivityChat.this.oPk = System.currentTimeMillis();
            ActivityChat.this.oPl = false;
            if (loginState == 3) {
                ActivityChat.this.oPj.removeCallbacks(ActivityChat.this.fVP);
                ActivityChat.this.oPj.postDelayed(ActivityChat.this.fVP, ActivityChat.this.elq());
                ActivityChat.this.oOL.setVisibility(8);
                ActivityChat.this.init(ActivityChat.this.getIntent());
                return;
            }
            ActivityChat.this.oPj.postDelayed(ActivityChat.this.fVP, 7000L);
            ActivityChat.this.elr();
        }
    };
    private Runnable fVP = new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mTimeOutRunnable run ");
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.elh().getLoginState(ActivityChat.this) != 3) {
                ActivityChat.this.oPl = true;
                ActivityChat.this.els();
                return;
            }
            ActivityChat.this.elt();
        }
    };
    private h oPn = new h();
    private View.OnClickListener oPo = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChat.this.elF();
            if (ActivityChat.this.mChatStatus == 0 && ActivityChat.this.oON != null) {
                ActivityChat.this.oON.ems();
            }
        }
    };
    private l oPp = new l();
    private k oPq = new k();
    private j oPr = new j();
    private a oPs = new a();
    private b oPt = new b();
    d oPu = new d();
    e oPv = new e();

    /* loaded from: classes4.dex */
    public interface c {
        void elK();
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
    public void YE(String str) {
        if ("greet_link".equals(str)) {
            String elP = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.elP();
            String str2 = "";
            if (!TextUtils.isEmpty(ChatInfo.nickname)) {
                str2 = ChatInfo.nickname;
            } else if (!TextUtils.isEmpty(ChatInfo.displayname)) {
                str2 = ChatInfo.displayname;
            }
            com.baidu.yuyinala.privatemessage.model.message.a.enZ().D(this, elP.replace("XXX", str2), this.mListenerKey);
        } else if ("welcom_link".equals(str)) {
            com.baidu.yuyinala.privatemessage.model.message.a.enZ().D(this, com.baidu.yuyinala.privatemessage.implugin.ui.common.b.elQ(), this.mListenerKey);
        }
    }

    public f elo() {
        return this.oPj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class f extends Handler {
        private final SoftReference<ActivityChat> oPA;

        private f(ActivityChat activityChat) {
            this.oPA = new SoftReference<>(activityChat);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            String str;
            int i2 = 0;
            boolean z = false;
            super.handleMessage(message);
            if (this.oPA.get() != null) {
                try {
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.oPA.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "current is no support");
                        this.oPA.get().oOI.setVisibility(4);
                        ChatInfo.mStatus = 10;
                        if (this.oPA.get().oON != null) {
                            this.oPA.get().oON.eml();
                        }
                        if (this.oPA.get().oOM != null) {
                            this.oPA.get().oOM.eml();
                            return;
                        }
                        return;
                    case 2:
                        if (message.arg1 == 1) {
                            com.baidu.yuyinala.privatemessage.implugin.f.j.Av(true);
                            postDelayed(new i(this.oPA), 1000L);
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emO().bs(this.oPA.get().getApplicationContext(), this.oPA.get().getString(a.h.bd_im_zhida_success_tip));
                            if (this.oPA.get().oPf != null) {
                                this.oPA.get().oPf.dismiss();
                            }
                            String ell = com.baidu.yuyinala.privatemessage.implugin.f.j.ell();
                            if (!TextUtils.isEmpty(ell)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("sign", "media_" + ell);
                                    jSONObject.put("relation", 1);
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.elh().A(this.oPA.get().getApplicationContext(), "com.baidu.channel.subscribe", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
                                    return;
                                } catch (UnsupportedEncodingException e2) {
                                    e2.printStackTrace();
                                    return;
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            this.oPA.get();
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
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emO().br(this.oPA.get().getApplicationContext(), str);
                            return;
                        } else {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emO().br(this.oPA.get().getApplicationContext(), this.oPA.get().getString(a.h.bd_im_subscribe_fail_tip));
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                        return;
                    case 3:
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emO().showToast(this.oPA.get().getApplicationContext(), this.oPA.get().getString(a.h.bd_im_zhida_fail_net_tip));
                        return;
                    case 5:
                        this.oPA.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 1 ");
                        this.oPA.get().finish();
                        this.oPA.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 2 ");
                        return;
                    case 6:
                        Bundle data = message.getData();
                        String str2 = "";
                        if (data != null) {
                            str2 = data.getString("subscribe_data");
                            z = data.getBoolean("update_subscribe", false);
                        }
                        com.baidu.yuyinala.privatemessage.implugin.f.j.YB(str2);
                        ChatInfo.mPainfo.setMsgNotify(com.baidu.yuyinala.privatemessage.implugin.f.j.isNeedNotify());
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.elm() || !z) {
                            if (this.oPA.get().oPf != null && this.oPA.get().oPf.emM()) {
                                this.oPA.get().oPf.dismiss();
                            }
                        } else {
                            this.oPA.get().Pa(1);
                        }
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.getData() != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.b.b.C(this.oPA.get().getApplicationContext(), String.valueOf(this.oPA.get().mPaid), com.baidu.yuyinala.privatemessage.implugin.f.j.getData().toString());
                            return;
                        }
                        return;
                    case 7:
                        this.oPA.get().Pa(0);
                        return;
                    case 8:
                        if (message.arg1 == 0) {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emO().br(this.oPA.get(), "关注成功");
                            this.oPA.get().oPf.dismiss();
                            this.oPA.get().elH();
                            this.oPA.get().isFollowed = true;
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emO().br(this.oPA.get(), "关注失败");
                        return;
                    case 1001:
                        if (this.oPA.get().oOO != null && this.oPA.get().oOO.getVisibility() == 0) {
                            this.oPA.get().oOO.setAnimation(AnimationUtils.loadAnimation(this.oPA.get(), a.C0205a.bd_im_slip_out_from_right));
                            this.oPA.get().oOO.setVisibility(4);
                            return;
                        }
                        return;
                    case 1002:
                        this.oPA.get().elw();
                        return;
                    case 1003:
                        if (this.oPA.get().oOQ != null && this.oPA.get().oOQ.getVisibility() == 0) {
                            this.oPA.get().oOQ.setAnimation(AnimationUtils.loadAnimation(this.oPA.get(), a.C0205a.bd_im_disappear_out));
                            this.oPA.get().oOQ.setVisibility(4);
                            return;
                        }
                        return;
                    case 1006:
                        this.oPA.get().oOI.setVisibility(4);
                        ChatInfo.mStatus = 11;
                        if (this.oPA.get().oON != null) {
                            this.oPA.get().oON.eml();
                        }
                        this.oPA.get().oOK.setVisibility(0);
                        return;
                    case 1007:
                    case 1008:
                        return;
                    case 1009:
                        if (this.oPA.get().oOM != null) {
                            this.oPA.get().oOM.Ay(false);
                        }
                        this.oPA.get().oOL.setVisibility(8);
                        this.oPA.get().init(this.oPA.get().getIntent());
                        return;
                    case 1010:
                        if (this.oPA.get().oOM != null) {
                            this.oPA.get().oOM.Ay(true);
                        }
                        if (this.oPA.get().oON != null) {
                            this.oPA.get().oON.eml();
                            return;
                        }
                        return;
                    case 1011:
                        this.oPA.get().oOI.setVisibility(4);
                        ChatInfo.mStatus = 12;
                        if (this.oPA.get().oON != null) {
                            this.oPA.get().oON.eml();
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
        private final SoftReference<ActivityChat> oPA;

        private i(SoftReference<ActivityChat> softReference) {
            this.oPA = softReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPA.get() != null) {
                this.oPA.get().u(this.oPA.get().mPaid, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BIMManager.mediaSetRole(getActivity(), true);
        elC();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        setContentView(a.g.bd_im_chat_activity_layout);
        this.mContainer = (LinearLayout) findViewById(a.f.bd_im_chat_root);
        this.oPh = new com.baidu.yuyinala.privatemessage.implugin.ui.a.a();
        elE();
        init(getIntent());
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.elh().isCuidLogin(this) || com.baidu.yuyinala.privatemessage.implugin.d.b.elh().eli()) {
            this.oOY = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    private void elp() {
        this.oPk = System.currentTimeMillis();
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "loginOver loginState: " + loginState);
        if (this.oOM != null) {
            this.oOM.emm();
        }
        switch (loginState) {
            case 2:
                this.oPj.postDelayed(this.fVP, 7000L);
                elr();
                return;
            case 3:
                this.oPj.postDelayed(this.fVP, elq());
                this.oOL.setVisibility(8);
                this.oPj.sendEmptyMessage(1009);
                return;
            default:
                this.oPj.postDelayed(this.fVP, 7000L);
                elu();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long elq() {
        long currentTimeMillis = 10000 - (System.currentTimeMillis() - this.oPk);
        if (currentTimeMillis > 7000) {
            return 7000L;
        }
        return currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elr() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "retryLogin timeout " + this.oPl);
        if (!this.oPl) {
            this.oPj.sendEmptyMessage(1010);
            com.baidu.yuyinala.privatemessage.implugin.d.b.elh().a(this, new b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.13
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
    public void els() {
        if (this.oOM != null) {
            this.oOM.Ay(false);
        }
        if (this.oON != null) {
            this.oON.eml();
        }
        this.oOL.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elt() {
        if (this.oOM != null) {
            this.oOM.Ay(false);
        }
    }

    private void elu() {
        this.oPj.sendEmptyMessage(1010);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus ");
        com.baidu.yuyinala.privatemessage.implugin.d.b.elh().a(this, new b.e() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.14
            @Override // com.baidu.android.imsdk.account.ILoginStateChangedListener
            public void onLoginStateChanged(int i2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus onLoginStateChanged state: " + i2);
                switch (i2) {
                    case 2:
                        ActivityChat.this.elr();
                        return;
                    case 3:
                        ActivityChat.this.oPj.removeCallbacks(ActivityChat.this.fVP);
                        ActivityChat.this.oPj.postDelayed(ActivityChat.this.fVP, ActivityChat.this.elq());
                        ActivityChat.this.oPj.sendEmptyMessage(1009);
                        return;
                    default:
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "waitting");
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elv() {
        if (this.jUB > 8) {
            if (this.oOO == null) {
                this.oOO = (LinearLayout) findViewById(a.f.bd_im_chat_unread_msgs_layout);
                this.oOP = (TextView) findViewById(a.f.bd_im_chat_unread_msgs_txt);
                this.oOP.setText(this.jUB + getString(a.h.bd_im_alert_unread_msgs));
            }
            this.oOR = (ImageView) findViewById(a.f.bd_im_chat_unread_msgs_up);
            try {
                this.oOO.setBackgroundResource(ThemeManager.U(this, a.e.bd_im_chat_unread_msgs_background));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.oOO.setAnimation(AnimationUtils.loadAnimation(this, a.C0205a.bd_im_slip_in_from_right));
            this.oOO.setVisibility(0);
            this.oOO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.oOM.Pb(ActivityChat.this.jUB);
                    ActivityChat.this.oOO.setAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0205a.bd_im_slip_out_from_right));
                    ActivityChat.this.oOO.setVisibility(4);
                }
            });
            this.oPj.sendEmptyMessageDelayed(1001, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elw() {
        if (this.oOQ == null) {
            this.oOQ = (ImageView) findViewById(a.f.bd_im_chat_new_msgs_tip);
            this.oOQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.oOM.emb();
                    ActivityChat.this.oOQ.startAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0205a.bd_im_disappear_out));
                    ActivityChat.this.oOQ.setVisibility(4);
                }
            });
        }
        if (this.oOQ.getVisibility() != 0) {
            this.oOQ.startAnimation(AnimationUtils.loadAnimation(this, a.C0205a.bd_im_disappear_in));
            this.oOQ.setVisibility(0);
        }
        this.oPj.removeMessages(1003);
        this.oPj.sendEmptyMessageDelayed(1003, 10000L);
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
        switch (ChatInfo.oNz) {
            case GROUP:
                com.baidu.yuyinala.privatemessage.implugin.d.b.elh().setAllMsgRead(getApplicationContext(), 1, ChatInfo.mContacter, false);
                break;
            default:
                BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
                break;
        }
        try {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emE();
            com.baidu.yuyinala.privatemessage.implugin.imagechooser.a.elf();
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.elh().c(this, th);
        }
        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emO().dismiss();
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mChatCategory " + ChatInfo.oNz + " mOnlineStatus " + this.oPe);
        if (ChatInfo.oNz == ChatInfo.ChatCategory.C2C && this.oPe != null) {
            elx();
        }
        if (this.oOM != null) {
            this.oOM.a((com.baidu.yuyinala.privatemessage.implugin.ui.activity.a) null);
        }
        if (this.oON != null) {
            this.oON.onDestroy();
        }
        if (this.oOM != null) {
            this.oOM.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i2) {
    }

    private void elx() {
        Intent intent = new Intent(IMConstants.NOTICE_USER_STATE);
        intent.putExtra(IMConstants.NOTICE_USER_STATE_OBJECT, this.oPe);
        sendBroadcast(intent);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "noticeSessionState com.baidu.android.imsdk.notice.userstate");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onResume--->");
        super.onResume();
        com.baidu.yuyinala.privatemessage.implugin.d.b.elh().Au(true);
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onResume mIsCuidOrIncompleteLogin: " + this.oOY + " loginState: " + loginState);
        if (this.oOY && (!com.baidu.yuyinala.privatemessage.implugin.d.b.elh().isCuidLogin(this) || !com.baidu.yuyinala.privatemessage.implugin.d.b.elh().eli() || (loginState != 0 && loginState != 3))) {
            elp();
        } else if (this.oPf != null && this.oPf.emM() && ChatInfo.ChatCategory.DUZHAN == ChatInfo.oNz) {
            u(this.mPaid, true);
        }
        if (this.oON != null) {
            this.oON.onResume();
        }
        if (this.oOM != null) {
            this.oOM.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStop--->");
        super.onStop();
        if (this.oON != null) {
            this.oON.onStop();
        }
        if (this.oOM != null) {
            this.oOM.onStop();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStop");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStart--->");
        super.onStart();
        if (this.oON != null) {
            this.oON.onStart();
        }
        if (this.oOM != null) {
            this.oOM.onStart();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStart");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onPause--->");
        super.onPause();
        com.baidu.yuyinala.privatemessage.implugin.d.b.elh().Au(false);
        if (this.oON != null) {
            this.oON.onPause();
        }
        if (this.oOM != null) {
            this.oOM.onPause();
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
            this.aUa = ExtraParamsManager.getEncryptionUserId(extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVq));
            this.oOW = extras.getBoolean("isMediaRole");
            this.mGroupId = extras.getString("groupid");
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("miliao", "mIsmediaRole：" + this.oOW);
            this.mLiveId = extras.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            oOX = this.oOW;
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oVq, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVq));
            jSONObject.put("paid", extras.getString("paid"));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oVs, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVs));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oVu, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVu));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oVt, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVt));
            String jSONObject2 = jSONObject.toString();
            try {
                if (!TextUtils.isEmpty(extras.getString("action"))) {
                    Serializable serializable = extras.getSerializable("params");
                    if (serializable instanceof ImBaseEntity) {
                        this.oPg = (ImBaseEntity) serializable;
                        if (this.oOU == null) {
                            GroupInfo groupInfo = new GroupInfo(String.valueOf(this.oPg.id));
                            groupInfo.setGroupName(this.oPg.name);
                            groupInfo.setDescription(this.oPg.description);
                            groupInfo.setHeadUrl(this.oPg.headUrl);
                            this.oOU = new QMGroupInfo(groupInfo);
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
        elA();
        String ay = ay(intent);
        if (this.oOI != null) {
            if (this.oOW) {
                this.oOI.setVisibility(8);
            } else {
                this.oOI.setVisibility(0);
            }
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + ay);
        ChatInfo.mContacter = -1L;
        ChatInfo.oNB = -1L;
        ChatInfo.mAppid = -1L;
        ChatInfo.mUid = -1L;
        ChatInfo.oNC = "";
        ChatInfo.oND = "";
        ChatInfo.kpk = -1;
        ChatInfo.oNH = 0;
        ChatInfo.oNK = true;
        ChatInfo.oNJ = false;
        try {
            JSONObject jSONObject = new JSONObject(ay);
            int i2 = jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.oVt) ? jSONObject.getInt(com.baidu.yuyinala.privatemessage.implugin.util.d.oVt) : -1;
            if (i2 == -1) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "invoke error -1");
                return;
            }
            if (i2 == 80) {
                parseLong = Long.parseLong(jSONObject.optString("paid", "-1"));
            } else {
                parseLong = Long.parseLong(jSONObject.optString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVq, "-1"));
            }
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + ay);
            if (this.oPb != -1 && (this.oPb != i2 || this.oPc != parseLong)) {
                if (this.oOM != null) {
                    this.oOM.emm();
                }
                if (this.oOD != null) {
                    this.oOD.setText("");
                }
            }
            this.oPb = i2;
            switch (i2) {
                case 0:
                    ChatInfo.oNz = ChatInfo.ChatCategory.C2C;
                    try {
                        this.oOV = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVq));
                        ChatInfo.mUid = this.oOV;
                        elz();
                        this.mNickName = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVs);
                        this.mIcon = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVu);
                        if (jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.oVw)) {
                            ChatInfo.oNK = jSONObject.getBoolean(com.baidu.yuyinala.privatemessage.implugin.util.d.oVw);
                        }
                    } catch (Exception e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "init uid and name error");
                    }
                    this.oOE.setVisibility(8);
                    this.mListenerKey = String.valueOf(this.oOV);
                    YF(this.mNickName);
                    ib(this.oOV);
                    return;
                case 80:
                    ChatInfo.oNz = ChatInfo.ChatCategory.DUZHAN;
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
            com.baidu.yuyinala.privatemessage.implugin.d.b.elh().c(this, e3);
        }
    }

    private void eB(JSONObject jSONObject) {
        try {
            this.mPaid = Long.parseLong(jSONObject.getString("paid"));
            ChatInfo.mPaid = this.mPaid;
            if (this.oOW) {
                long parseLong = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVq));
                if (parseLong > 0) {
                    ChatInfo.mUid = parseLong;
                }
            }
            elB();
        } catch (Exception e2) {
            LogUtils.e(MAFragmentActivity.TAG, "init appid error");
        }
        this.mListenerKey = String.valueOf(this.mPaid);
        ia(this.mPaid);
    }

    private void ia(long j2) {
        this.oOE.setVisibility(8);
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
                    ActivityChat.this.oPj.post(ActivityChat.this.oPn);
                }
            });
        } else {
            this.oPj.post(this.oPn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class h implements Runnable {
        private final SoftReference<ActivityChat> oPB;

        private h(ActivityChat activityChat) {
            this.oPB = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPB.get() != null) {
                try {
                    ChatInfo.oNB = AccountManager.getUK(this.oPB.get().getApplicationContext());
                    this.oPB.get();
                    LogUtils.d(MAFragmentActivity.TAG, "parunnable ---> " + ChatInfo.oNB);
                    if (ChatInfo.oNB != -1) {
                        this.oPB.get().mChatStatus = 0;
                        this.oPB.get().ely();
                        this.oPB.get();
                        LogUtils.d(MAFragmentActivity.TAG, "parunnable -->1");
                        ChatInfo.mContacter = this.oPB.get().mPaInfo.getPaId();
                        ChatInfo.mPainfo = this.oPB.get().mPaInfo;
                        if (ChatInfo.oNz == ChatInfo.ChatCategory.DUZHAN) {
                            this.oPB.get().jUB = ChatMsgManager.getUnReadMsgCountByPaid(this.oPB.get(), this.oPB.get().mPaid);
                            if (this.oPB.get().jUB > 200) {
                                this.oPB.get().jUB = 200;
                            }
                        }
                        this.oPB.get().VD();
                        this.oPB.get().u(this.oPB.get().mPaid, true);
                    } else {
                        this.oPB.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    this.oPB.get().oPd = TextUtils.isEmpty(this.oPB.get().oPd) ? this.oPB.get().mPaInfo.getNickName() : this.oPB.get().oPd;
                    this.oPB.get().oOD.setText(String.valueOf(this.oPB.get().oPd));
                    this.oPB.get().elv();
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ely() {
        com.baidu.yuyinala.privatemessage.implugin.d.b.elh().a(getActivity(), new IGetUsersProfileBatchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.18
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2) {
                if (i2 == 0 && arrayList2 != null && arrayList2.size() == 1) {
                    ChatInfo.oNC = ActivityChat.this.YH(arrayList2.get(0).getIconUrl());
                    ChatInfo.displayname = arrayList2.get(0).getUserName();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elz() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.b(ExtraParamsManager.getEncryptionUserId(ChatInfo.mUid + "")));
    }

    private static void elA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031061, TbConfig.SERVER_ADDRESS + "ala/audio/user/preFollow");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void elB() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.a(ExtraParamsManager.getEncryptionUserId(this.mPaid + "")));
    }

    private void elC() {
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
                        ActivityChat.this.elz();
                    }
                }
            }
        });
    }

    public boolean elD() {
        return this.oPb == 2 || this.oPb == 11;
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
        this.oOA = (RelativeLayout) findViewById(a.f.bd_im_chat_title_root);
        this.oOB = findViewById(a.f.bd_im_chat_cell_space_line);
        this.oOC = (TextView) findViewById(a.f.bd_im_chat_open_main);
        this.oOI = (LinearLayout) findViewById(a.f.bd_im_chat_open_main_click_parent);
        this.oOI.setOnClickListener(this.oPo);
        this.oOJ = (RelativeLayout) findViewById(a.f.bd_im_chat_back_layout);
        this.oOJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.onBackClick();
            }
        });
        this.oOD = (TextView) findViewById(a.f.bd_im_chat_title);
        this.oOE = (TextView) findViewById(a.f.bd_im_chat_subtitle);
        this.oOF = findViewById(a.f.bd_im_chat_main_input);
        this.oOG = (FrameLayout) findViewById(a.f.bd_im_chat_main_content);
        this.oOH = (FrameLayout) findViewById(a.f.bd_im_chat_main_input);
        this.oOK = (FrameLayout) findViewById(a.f.bd_im_chat_main_error_content);
        this.oOS = (ImageView) findViewById(a.f.bd_im_chat_main_error_image);
        this.oOK.setVisibility(8);
        this.oOL = (FrameLayout) findViewById(a.f.bd_im_chat_main_retry_content);
        this.oOL.setVisibility(8);
        findViewById(a.f.bd_im_chat_main_retry_button).setOnClickListener(this.oPm);
        this.oOD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.elI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VD() {
        if (this.oOM == null) {
            FrameLayout frameLayout = this.oOG;
            this.oOG.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_chat, null));
            this.oOM = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.a(this, this.oOG, this.mListenerKey, this.oPi, this.jUB);
        }
        if (this.oON == null) {
            FrameLayout frameLayout2 = this.oOH;
            this.oOH.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_input, null));
            this.oON = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.a(this, this.oOH, this.mListenerKey, this.oPi);
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "initFragment : ");
        if (!isFinishing()) {
            try {
                com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "mTransaction.commitAllowingStateLoss() : ");
            } catch (Exception e2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "e :" + e2);
                com.baidu.yuyinala.privatemessage.implugin.d.b.elh().c(this, e2);
            }
        }
        if (this.oOM != null) {
            this.oOM.a(this);
        }
        ic(this.oOV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void elE() {
        this.oOZ = AnimationUtils.loadAnimation(this, a.C0205a.bd_im_fragment_in_from_bottom);
        this.oPa = AnimationUtils.loadAnimation(this, a.C0205a.bd_im_fragment_out_to_bottom);
    }

    private void ib(long j2) {
        if (j2 == 0) {
            this.oOT = null;
            showToast(a.h.bd_im_read_error);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j2));
        final SoftReference softReference = new SoftReference(this);
        com.baidu.yuyinala.privatemessage.implugin.d.b.elh().a(getApplicationContext(), arrayList, false, new b.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList2, ArrayList<ChatUser> arrayList3) {
                if (softReference.get() != null) {
                    if (i2 != 0) {
                        ((ActivityChat) softReference.get()).oPj.post(ActivityChat.this.oPs);
                        return;
                    }
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        ((ActivityChat) softReference.get()).oOT = arrayList3.get(0);
                    }
                    if (((ActivityChat) softReference.get()).oOT == null) {
                        ((ActivityChat) softReference.get()).oPj.post(ActivityChat.this.oPr);
                        return;
                    }
                    ArrayList<Long> arrayList4 = new ArrayList<>();
                    arrayList4.add(Long.valueOf(ActivityChat.this.oOT.getUk()));
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elh().a(ActivityChat.this.getApplicationContext(), arrayList4, new b.InterfaceC0965b() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7.1
                        @Override // com.baidu.android.imsdk.chatuser.IGetUserStatusListener
                        public void onGetUsersStatusResult(int i3, String str2, ArrayList<UserStatus> arrayList5) {
                            if (i3 == 0 && arrayList5.size() == 1) {
                                ((ActivityChat) softReference.get()).oPe = arrayList5.get(0);
                                ((ActivityChat) softReference.get()).oPj.post(ActivityChat.this.oPp);
                            }
                        }
                    });
                    ((ActivityChat) softReference.get()).oPj.post(ActivityChat.this.oPq);
                }
            }
        });
        com.baidu.yuyinala.privatemessage.implugin.f.k.hm(getApplicationContext()).b(j2, new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.8
            @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
            public void d(int i2, String str, long j3) {
                try {
                    LogUtils.d(MAFragmentActivity.TAG, "getUserSubscribe->" + str);
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1) == 0) {
                        JSONArray jSONArray = jSONObject.optJSONObject("data").getJSONArray("items");
                        if (jSONArray == null || jSONArray.length() < 1) {
                            ActivityChat.this.oPj.sendEmptyMessageDelayed(7, 1000L);
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
            com.baidu.yuyinala.privatemessage.implugin.e.a.hl(getApplicationContext()).hb("542", "chat_flow_time");
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
        }
    }

    protected void ic(long j2) {
    }

    protected void elF() {
    }

    public ImBaseEntity elG() {
        return this.oPg;
    }

    protected void elH() {
    }

    protected void YF(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oOD.setText(str);
        } else if (this.mNickName != null) {
            this.oOD.setText(String.valueOf(this.mNickName));
        } else if (this.oOT != null) {
            this.oOD.setText(String.valueOf(this.oOT.getUserName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elI() {
        String liveId = getLiveId();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig((Context) getActivity(), ChatInfo.mUid + "", (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, 0L, 0L, 0L, 0, getGroupId(), liveId, false, (String) null, (String) null, (String) null, (String) null, (String) null)));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
    }

    /* loaded from: classes4.dex */
    private static class l implements Runnable {
        private final SoftReference<ActivityChat> oPA;

        private l(ActivityChat activityChat) {
            this.oPA = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes4.dex */
    private static class k implements Runnable {
        private final SoftReference<ActivityChat> oPA;

        private k(ActivityChat activityChat) {
            this.oPA = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPA.get() != null) {
                try {
                    ChatInfo.oNB = AccountManager.getUK(this.oPA.get().getApplicationContext());
                    if (ChatInfo.oNB != -1) {
                        this.oPA.get().mChatStatus = 0;
                        this.oPA.get().elJ();
                        this.oPA.get().VD();
                        this.oPA.get().id(this.oPA.get().oOV);
                    } else {
                        this.oPA.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    if (this.oPA.get().mNickName == null) {
                        if (this.oPA.get().oOT != null) {
                            this.oPA.get().oOD.setText(String.valueOf(this.oPA.get().oOT.getUserName()));
                            return;
                        }
                        return;
                    }
                    this.oPA.get().oOD.setText(String.valueOf(this.oPA.get().mNickName));
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void id(long j2) {
        if (YG(String.valueOf(j2))) {
        }
    }

    private boolean YG(String str) {
        String B = com.baidu.yuyinala.privatemessage.implugin.util.b.b.B(getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVM, null);
        boolean z = false;
        if (!TextUtils.isEmpty(B)) {
            try {
                JSONObject jSONObject = new JSONObject(B);
                if (jSONObject.has(str)) {
                    z = jSONObject.getBoolean(str);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        LogUtils.i(MAFragmentActivity.TAG, "is support IM:" + z + " data:" + B);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elJ() {
        ely();
        ChatInfo.mContacter = this.oOT.getUk();
        ChatInfo.mUid = this.oOT.getBuid();
        ChatInfo.mStatus = 3;
        ChatInfo.oNA = this.oOT.getUserName();
        if (!TextUtils.isEmpty(this.mIcon)) {
            ChatInfo.oND = this.mIcon;
        } else {
            ChatInfo.oND = YH(this.oOT.getIconUrl());
        }
        BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
        LogUtils.i(MAFragmentActivity.TAG, "uk:" + ChatInfo.oNB);
        LogUtils.i(MAFragmentActivity.TAG, "header:" + ChatInfo.oNC);
        LogUtils.i(MAFragmentActivity.TAG, "" + this.oOT.toString());
    }

    /* loaded from: classes4.dex */
    private static class j implements Runnable {
        private final SoftReference<ActivityChat> oPA;

        private j(ActivityChat activityChat) {
            this.oPA = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPA.get() != null) {
                try {
                    ChatInfo.oNB = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().hh(this.oPA.get().getApplicationContext()).longValue();
                    this.oPA.get().mChatStatus = 0;
                    this.oPA.get().VD();
                    if (this.oPA.get().mNickName != null) {
                        this.oPA.get().oOD.setText(String.valueOf(this.oPA.get().mNickName));
                    }
                    this.oPA.get().oPj.sendEmptyMessage(1);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final SoftReference<ActivityChat> oPA;

        private a(ActivityChat activityChat) {
            this.oPA = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPA.get() != null) {
                try {
                    ChatInfo.oNB = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().hh(this.oPA.get().getApplicationContext()).longValue();
                    this.oPA.get().mChatStatus = 1;
                    this.oPA.get().VD();
                    if (this.oPA.get().mNickName != null) {
                        this.oPA.get().oOD.setText(String.valueOf(this.oPA.get().mNickName));
                    }
                    this.oPA.get().oPj.sendEmptyMessage(1006);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class b implements Runnable {
        private final SoftReference<ActivityChat> oPA;

        private b(ActivityChat activityChat) {
            this.oPA = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPA.get() != null) {
                try {
                    ChatInfo.oNB = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().hh(this.oPA.get().getApplicationContext()).longValue();
                    String str = null;
                    if (this.oPA.get().oOU != null) {
                        str = this.oPA.get().oOU.mInfo.getGroupName();
                    }
                    if (ChatInfo.kpk == 2) {
                        if (str == null || "".equals(str.trim())) {
                            if (this.oPA.get().mNickName != null) {
                                this.oPA.get().oOD.setText(String.valueOf(this.oPA.get().mNickName));
                                return;
                            } else if (this.oPA.get().oOU != null) {
                                this.oPA.get().oOD.setText(String.valueOf(str));
                                return;
                            } else {
                                return;
                            }
                        }
                        this.oPA.get().oOD.setText(String.valueOf(str));
                    } else if (!TextUtils.isEmpty(str)) {
                        this.oPA.get().oOD.setText(String.valueOf(str));
                        this.oPA.get().oOE.setText(this.oPA.get().oOU.mInfo.getNum() + "人");
                    } else if (!TextUtils.isEmpty(this.oPA.get().mNickName)) {
                        this.oPA.get().oOD.setText(String.valueOf(this.oPA.get().mNickName));
                        this.oPA.get().oOE.setText(this.oPA.get().oOU.mInfo.getNum() + "人");
                    } else if (this.oPA.get().oOU != null) {
                        this.oPA.get().oOD.setText("未知群");
                        this.oPA.get().oOE.setText(this.oPA.get().oOU.mInfo.getNum() + "人");
                    }
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class d implements Runnable {
        private final SoftReference<ActivityChat> oPA;

        private d(ActivityChat activityChat) {
            this.oPA = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPA.get() != null) {
                try {
                    this.oPA.get().oOF.setVisibility(0);
                    this.oPA.get().oOF.startAnimation(this.oPA.get().oOZ);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class e implements Runnable {
        private final SoftReference<ActivityChat> oPA;

        private e(ActivityChat activityChat) {
            this.oPA = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPA.get() != null) {
                try {
                    this.oPA.get().oOF.setVisibility(8);
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
        com.baidu.yuyinala.privatemessage.implugin.f.k.hm(getApplicationContext()).a(j2, new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.9
            @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
            public void d(int i2, String str, long j3) {
                Message message = new Message();
                message.what = 6;
                Bundle bundle = new Bundle();
                bundle.putString("subscribe_data", str);
                bundle.putBoolean("update_subscribe", z);
                message.setData(bundle);
                ActivityChat.this.oPj.sendMessage(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pa(int i2) {
        Date date;
        String str = null;
        long j2 = -1;
        if (i2 == 1) {
            str = com.baidu.yuyinala.privatemessage.implugin.f.j.getType();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.baidu.yuyinala.privatemessage.implugin.f.j.ell())) {
                try {
                    j2 = Long.parseLong(com.baidu.yuyinala.privatemessage.implugin.f.j.ell());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.b.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVR + ChatInfo.mPaid + ChatInfo.oNB, 0L));
            } else {
                return;
            }
        } else if (i2 == 0) {
            str = "ugc";
            j2 = this.oOV;
            date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.b.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVS + this.oOV, 0L));
        } else {
            date = null;
        }
        if (!com.baidu.yuyinala.privatemessage.implugin.util.f.c(date, new Date())) {
            if ((this.oPf == null || !this.oPf.emM() || this.oPf.emN() != i2) && this.oOM != null) {
                this.oPf = this.oOM.aq(i2, elD());
                if (this.oPf != null) {
                    try {
                        this.oPf.c(str, j2, new g(this, i2));
                    } catch (NumberFormatException e3) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, e3.getMessage());
                    }
                    com.baidu.yuyinala.privatemessage.implugin.e.a.hl(getApplicationContext()).add("416", "subscribe_show");
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
                    activityChat.elo().sendMessage(message);
                } else if (this.flag == 0) {
                    Message message2 = new Message();
                    if (z) {
                        message2.arg1 = 0;
                    } else {
                        message2.arg1 = -1;
                    }
                    message2.what = 8;
                    activityChat.elo().sendMessage(message2);
                }
            }
        }
    }

    public void onBackClick() {
        if (this.mChatStatus == 0) {
            if (this.oON != null) {
                this.oON.ems();
            }
            if (this.oPf != null) {
                this.oPf.emL();
            }
        }
        finish();
        if (!ChatInfo.oNK) {
            com.baidu.yuyinala.privatemessage.implugin.d.b.elh().hk(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String YH(String str) {
        return str;
    }
}
