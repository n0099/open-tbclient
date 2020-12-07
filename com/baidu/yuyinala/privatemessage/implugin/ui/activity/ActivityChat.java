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
    public static boolean oOV;
    protected String aUa;
    protected boolean isFollowed;
    private LinearLayout mContainer;
    private String mGroupId;
    private String mIcon;
    private String mLiveId;
    private String mNickName;
    private PaInfo mPaInfo;
    public long mPaid;
    private TextView oOA;
    private TextView oOB;
    private TextView oOC;
    private View oOD;
    private FrameLayout oOE;
    private FrameLayout oOF;
    private LinearLayout oOG;
    private RelativeLayout oOH;
    private FrameLayout oOI;
    private FrameLayout oOJ;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a oOK;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b oOL;
    private LinearLayout oOM;
    private TextView oON;
    private ImageView oOO;
    private ImageView oOP;
    private ImageView oOQ;
    private ChatUser oOR;
    protected QMGroupInfo oOS;
    protected long oOT;
    public boolean oOU;
    private Animation oOX;
    private Animation oOY;
    private RelativeLayout oOy;
    private View oOz;
    private String oPb;
    private UserStatus oPc;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c oPd;
    protected ImBaseEntity oPe;
    private com.baidu.yuyinala.privatemessage.implugin.ui.a.a oPf;
    private long oPi;
    private int jUz = 0;
    public boolean oOW = false;
    private int mChatStatus = 1;
    private String mListenerKey = "";
    private int oOZ = -1;
    private long oPa = -1;
    private c oPg = new c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.1
        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.c
        public void elJ() {
            ActivityChat.this.oPh.sendEmptyMessage(1002);
        }
    };
    private f oPh = new f();
    private boolean oPj = false;
    private View.OnClickListener oPk = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().getLoginState(ActivityChat.this);
            ActivityChat.this.oPi = System.currentTimeMillis();
            ActivityChat.this.oPj = false;
            if (loginState == 3) {
                ActivityChat.this.oPh.removeCallbacks(ActivityChat.this.fVN);
                ActivityChat.this.oPh.postDelayed(ActivityChat.this.fVN, ActivityChat.this.elp());
                ActivityChat.this.oOJ.setVisibility(8);
                ActivityChat.this.init(ActivityChat.this.getIntent());
                return;
            }
            ActivityChat.this.oPh.postDelayed(ActivityChat.this.fVN, 7000L);
            ActivityChat.this.elq();
        }
    };
    private Runnable fVN = new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mTimeOutRunnable run ");
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.elg().getLoginState(ActivityChat.this) != 3) {
                ActivityChat.this.oPj = true;
                ActivityChat.this.elr();
                return;
            }
            ActivityChat.this.els();
        }
    };
    private h oPl = new h();
    private View.OnClickListener oPm = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChat.this.elE();
            if (ActivityChat.this.mChatStatus == 0 && ActivityChat.this.oOL != null) {
                ActivityChat.this.oOL.emr();
            }
        }
    };
    private l oPn = new l();
    private k oPo = new k();
    private j oPp = new j();
    private a oPq = new a();
    private b oPr = new b();
    d oPs = new d();
    e oPt = new e();

    /* loaded from: classes4.dex */
    public interface c {
        void elJ();
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
            String elO = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.elO();
            String str2 = "";
            if (!TextUtils.isEmpty(ChatInfo.nickname)) {
                str2 = ChatInfo.nickname;
            } else if (!TextUtils.isEmpty(ChatInfo.displayname)) {
                str2 = ChatInfo.displayname;
            }
            com.baidu.yuyinala.privatemessage.model.message.a.enY().D(this, elO.replace("XXX", str2), this.mListenerKey);
        } else if ("welcom_link".equals(str)) {
            com.baidu.yuyinala.privatemessage.model.message.a.enY().D(this, com.baidu.yuyinala.privatemessage.implugin.ui.common.b.elP(), this.mListenerKey);
        }
    }

    public f eln() {
        return this.oPh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class f extends Handler {
        private final SoftReference<ActivityChat> oPy;

        private f(ActivityChat activityChat) {
            this.oPy = new SoftReference<>(activityChat);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            String str;
            int i2 = 0;
            boolean z = false;
            super.handleMessage(message);
            if (this.oPy.get() != null) {
                try {
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.oPy.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "current is no support");
                        this.oPy.get().oOG.setVisibility(4);
                        ChatInfo.mStatus = 10;
                        if (this.oPy.get().oOL != null) {
                            this.oPy.get().oOL.emk();
                        }
                        if (this.oPy.get().oOK != null) {
                            this.oPy.get().oOK.emk();
                            return;
                        }
                        return;
                    case 2:
                        if (message.arg1 == 1) {
                            com.baidu.yuyinala.privatemessage.implugin.f.j.Av(true);
                            postDelayed(new i(this.oPy), 1000L);
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emN().bs(this.oPy.get().getApplicationContext(), this.oPy.get().getString(a.h.bd_im_zhida_success_tip));
                            if (this.oPy.get().oPd != null) {
                                this.oPy.get().oPd.dismiss();
                            }
                            String elk = com.baidu.yuyinala.privatemessage.implugin.f.j.elk();
                            if (!TextUtils.isEmpty(elk)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("sign", "media_" + elk);
                                    jSONObject.put("relation", 1);
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.elg().A(this.oPy.get().getApplicationContext(), "com.baidu.channel.subscribe", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
                                    return;
                                } catch (UnsupportedEncodingException e2) {
                                    e2.printStackTrace();
                                    return;
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            this.oPy.get();
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
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emN().br(this.oPy.get().getApplicationContext(), str);
                            return;
                        } else {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emN().br(this.oPy.get().getApplicationContext(), this.oPy.get().getString(a.h.bd_im_subscribe_fail_tip));
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                        return;
                    case 3:
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emN().showToast(this.oPy.get().getApplicationContext(), this.oPy.get().getString(a.h.bd_im_zhida_fail_net_tip));
                        return;
                    case 5:
                        this.oPy.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 1 ");
                        this.oPy.get().finish();
                        this.oPy.get();
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
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.ell() || !z) {
                            if (this.oPy.get().oPd != null && this.oPy.get().oPd.emL()) {
                                this.oPy.get().oPd.dismiss();
                            }
                        } else {
                            this.oPy.get().Pa(1);
                        }
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.getData() != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.b.b.C(this.oPy.get().getApplicationContext(), String.valueOf(this.oPy.get().mPaid), com.baidu.yuyinala.privatemessage.implugin.f.j.getData().toString());
                            return;
                        }
                        return;
                    case 7:
                        this.oPy.get().Pa(0);
                        return;
                    case 8:
                        if (message.arg1 == 0) {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emN().br(this.oPy.get(), "关注成功");
                            this.oPy.get().oPd.dismiss();
                            this.oPy.get().elG();
                            this.oPy.get().isFollowed = true;
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emN().br(this.oPy.get(), "关注失败");
                        return;
                    case 1001:
                        if (this.oPy.get().oOM != null && this.oPy.get().oOM.getVisibility() == 0) {
                            this.oPy.get().oOM.setAnimation(AnimationUtils.loadAnimation(this.oPy.get(), a.C0205a.bd_im_slip_out_from_right));
                            this.oPy.get().oOM.setVisibility(4);
                            return;
                        }
                        return;
                    case 1002:
                        this.oPy.get().elv();
                        return;
                    case 1003:
                        if (this.oPy.get().oOO != null && this.oPy.get().oOO.getVisibility() == 0) {
                            this.oPy.get().oOO.setAnimation(AnimationUtils.loadAnimation(this.oPy.get(), a.C0205a.bd_im_disappear_out));
                            this.oPy.get().oOO.setVisibility(4);
                            return;
                        }
                        return;
                    case 1006:
                        this.oPy.get().oOG.setVisibility(4);
                        ChatInfo.mStatus = 11;
                        if (this.oPy.get().oOL != null) {
                            this.oPy.get().oOL.emk();
                        }
                        this.oPy.get().oOI.setVisibility(0);
                        return;
                    case 1007:
                    case 1008:
                        return;
                    case 1009:
                        if (this.oPy.get().oOK != null) {
                            this.oPy.get().oOK.Ay(false);
                        }
                        this.oPy.get().oOJ.setVisibility(8);
                        this.oPy.get().init(this.oPy.get().getIntent());
                        return;
                    case 1010:
                        if (this.oPy.get().oOK != null) {
                            this.oPy.get().oOK.Ay(true);
                        }
                        if (this.oPy.get().oOL != null) {
                            this.oPy.get().oOL.emk();
                            return;
                        }
                        return;
                    case 1011:
                        this.oPy.get().oOG.setVisibility(4);
                        ChatInfo.mStatus = 12;
                        if (this.oPy.get().oOL != null) {
                            this.oPy.get().oOL.emk();
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
        private final SoftReference<ActivityChat> oPy;

        private i(SoftReference<ActivityChat> softReference) {
            this.oPy = softReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPy.get() != null) {
                this.oPy.get().u(this.oPy.get().mPaid, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BIMManager.mediaSetRole(getActivity(), true);
        elB();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        setContentView(a.g.bd_im_chat_activity_layout);
        this.mContainer = (LinearLayout) findViewById(a.f.bd_im_chat_root);
        this.oPf = new com.baidu.yuyinala.privatemessage.implugin.ui.a.a();
        elD();
        init(getIntent());
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.elg().isCuidLogin(this) || com.baidu.yuyinala.privatemessage.implugin.d.b.elg().elh()) {
            this.oOW = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    private void elo() {
        this.oPi = System.currentTimeMillis();
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "loginOver loginState: " + loginState);
        if (this.oOK != null) {
            this.oOK.eml();
        }
        switch (loginState) {
            case 2:
                this.oPh.postDelayed(this.fVN, 7000L);
                elq();
                return;
            case 3:
                this.oPh.postDelayed(this.fVN, elp());
                this.oOJ.setVisibility(8);
                this.oPh.sendEmptyMessage(1009);
                return;
            default:
                this.oPh.postDelayed(this.fVN, 7000L);
                elt();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long elp() {
        long currentTimeMillis = 10000 - (System.currentTimeMillis() - this.oPi);
        if (currentTimeMillis > 7000) {
            return 7000L;
        }
        return currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elq() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "retryLogin timeout " + this.oPj);
        if (!this.oPj) {
            this.oPh.sendEmptyMessage(1010);
            com.baidu.yuyinala.privatemessage.implugin.d.b.elg().a(this, new b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.13
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
    public void elr() {
        if (this.oOK != null) {
            this.oOK.Ay(false);
        }
        if (this.oOL != null) {
            this.oOL.emk();
        }
        this.oOJ.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void els() {
        if (this.oOK != null) {
            this.oOK.Ay(false);
        }
    }

    private void elt() {
        this.oPh.sendEmptyMessage(1010);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus ");
        com.baidu.yuyinala.privatemessage.implugin.d.b.elg().a(this, new b.e() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.14
            @Override // com.baidu.android.imsdk.account.ILoginStateChangedListener
            public void onLoginStateChanged(int i2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus onLoginStateChanged state: " + i2);
                switch (i2) {
                    case 2:
                        ActivityChat.this.elq();
                        return;
                    case 3:
                        ActivityChat.this.oPh.removeCallbacks(ActivityChat.this.fVN);
                        ActivityChat.this.oPh.postDelayed(ActivityChat.this.fVN, ActivityChat.this.elp());
                        ActivityChat.this.oPh.sendEmptyMessage(1009);
                        return;
                    default:
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "waitting");
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elu() {
        if (this.jUz > 8) {
            if (this.oOM == null) {
                this.oOM = (LinearLayout) findViewById(a.f.bd_im_chat_unread_msgs_layout);
                this.oON = (TextView) findViewById(a.f.bd_im_chat_unread_msgs_txt);
                this.oON.setText(this.jUz + getString(a.h.bd_im_alert_unread_msgs));
            }
            this.oOP = (ImageView) findViewById(a.f.bd_im_chat_unread_msgs_up);
            try {
                this.oOM.setBackgroundResource(ThemeManager.U(this, a.e.bd_im_chat_unread_msgs_background));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.oOM.setAnimation(AnimationUtils.loadAnimation(this, a.C0205a.bd_im_slip_in_from_right));
            this.oOM.setVisibility(0);
            this.oOM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.oOK.Pb(ActivityChat.this.jUz);
                    ActivityChat.this.oOM.setAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0205a.bd_im_slip_out_from_right));
                    ActivityChat.this.oOM.setVisibility(4);
                }
            });
            this.oPh.sendEmptyMessageDelayed(1001, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elv() {
        if (this.oOO == null) {
            this.oOO = (ImageView) findViewById(a.f.bd_im_chat_new_msgs_tip);
            this.oOO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.oOK.ema();
                    ActivityChat.this.oOO.startAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0205a.bd_im_disappear_out));
                    ActivityChat.this.oOO.setVisibility(4);
                }
            });
        }
        if (this.oOO.getVisibility() != 0) {
            this.oOO.startAnimation(AnimationUtils.loadAnimation(this, a.C0205a.bd_im_disappear_in));
            this.oOO.setVisibility(0);
        }
        this.oPh.removeMessages(1003);
        this.oPh.sendEmptyMessageDelayed(1003, 10000L);
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
        switch (ChatInfo.oNx) {
            case GROUP:
                com.baidu.yuyinala.privatemessage.implugin.d.b.elg().setAllMsgRead(getApplicationContext(), 1, ChatInfo.mContacter, false);
                break;
            default:
                BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
                break;
        }
        try {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emD();
            com.baidu.yuyinala.privatemessage.implugin.imagechooser.a.ele();
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.elg().c(this, th);
        }
        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emN().dismiss();
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mChatCategory " + ChatInfo.oNx + " mOnlineStatus " + this.oPc);
        if (ChatInfo.oNx == ChatInfo.ChatCategory.C2C && this.oPc != null) {
            elw();
        }
        if (this.oOK != null) {
            this.oOK.a((com.baidu.yuyinala.privatemessage.implugin.ui.activity.a) null);
        }
        if (this.oOL != null) {
            this.oOL.onDestroy();
        }
        if (this.oOK != null) {
            this.oOK.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i2) {
    }

    private void elw() {
        Intent intent = new Intent(IMConstants.NOTICE_USER_STATE);
        intent.putExtra(IMConstants.NOTICE_USER_STATE_OBJECT, this.oPc);
        sendBroadcast(intent);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "noticeSessionState com.baidu.android.imsdk.notice.userstate");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onResume--->");
        super.onResume();
        com.baidu.yuyinala.privatemessage.implugin.d.b.elg().Au(true);
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onResume mIsCuidOrIncompleteLogin: " + this.oOW + " loginState: " + loginState);
        if (this.oOW && (!com.baidu.yuyinala.privatemessage.implugin.d.b.elg().isCuidLogin(this) || !com.baidu.yuyinala.privatemessage.implugin.d.b.elg().elh() || (loginState != 0 && loginState != 3))) {
            elo();
        } else if (this.oPd != null && this.oPd.emL() && ChatInfo.ChatCategory.DUZHAN == ChatInfo.oNx) {
            u(this.mPaid, true);
        }
        if (this.oOL != null) {
            this.oOL.onResume();
        }
        if (this.oOK != null) {
            this.oOK.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStop--->");
        super.onStop();
        if (this.oOL != null) {
            this.oOL.onStop();
        }
        if (this.oOK != null) {
            this.oOK.onStop();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStop");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStart--->");
        super.onStart();
        if (this.oOL != null) {
            this.oOL.onStart();
        }
        if (this.oOK != null) {
            this.oOK.onStart();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStart");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onPause--->");
        super.onPause();
        com.baidu.yuyinala.privatemessage.implugin.d.b.elg().Au(false);
        if (this.oOL != null) {
            this.oOL.onPause();
        }
        if (this.oOK != null) {
            this.oOK.onPause();
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
            this.aUa = ExtraParamsManager.getEncryptionUserId(extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVo));
            this.oOU = extras.getBoolean("isMediaRole");
            this.mGroupId = extras.getString("groupid");
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("miliao", "mIsmediaRole：" + this.oOU);
            this.mLiveId = extras.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            oOV = this.oOU;
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oVo, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVo));
            jSONObject.put("paid", extras.getString("paid"));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oVq, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVq));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oVs, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVs));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.oVr, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVr));
            String jSONObject2 = jSONObject.toString();
            try {
                if (!TextUtils.isEmpty(extras.getString("action"))) {
                    Serializable serializable = extras.getSerializable("params");
                    if (serializable instanceof ImBaseEntity) {
                        this.oPe = (ImBaseEntity) serializable;
                        if (this.oOS == null) {
                            GroupInfo groupInfo = new GroupInfo(String.valueOf(this.oPe.id));
                            groupInfo.setGroupName(this.oPe.name);
                            groupInfo.setDescription(this.oPe.description);
                            groupInfo.setHeadUrl(this.oPe.headUrl);
                            this.oOS = new QMGroupInfo(groupInfo);
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
        elz();
        String ay = ay(intent);
        if (this.oOG != null) {
            if (this.oOU) {
                this.oOG.setVisibility(8);
            } else {
                this.oOG.setVisibility(0);
            }
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + ay);
        ChatInfo.mContacter = -1L;
        ChatInfo.oNz = -1L;
        ChatInfo.mAppid = -1L;
        ChatInfo.mUid = -1L;
        ChatInfo.oNA = "";
        ChatInfo.oNB = "";
        ChatInfo.kpi = -1;
        ChatInfo.oNF = 0;
        ChatInfo.oNI = true;
        ChatInfo.oNH = false;
        try {
            JSONObject jSONObject = new JSONObject(ay);
            int i2 = jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.oVr) ? jSONObject.getInt(com.baidu.yuyinala.privatemessage.implugin.util.d.oVr) : -1;
            if (i2 == -1) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "invoke error -1");
                return;
            }
            if (i2 == 80) {
                parseLong = Long.parseLong(jSONObject.optString("paid", "-1"));
            } else {
                parseLong = Long.parseLong(jSONObject.optString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVo, "-1"));
            }
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + ay);
            if (this.oOZ != -1 && (this.oOZ != i2 || this.oPa != parseLong)) {
                if (this.oOK != null) {
                    this.oOK.eml();
                }
                if (this.oOB != null) {
                    this.oOB.setText("");
                }
            }
            this.oOZ = i2;
            switch (i2) {
                case 0:
                    ChatInfo.oNx = ChatInfo.ChatCategory.C2C;
                    try {
                        this.oOT = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVo));
                        ChatInfo.mUid = this.oOT;
                        ely();
                        this.mNickName = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVq);
                        this.mIcon = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVs);
                        if (jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.oVu)) {
                            ChatInfo.oNI = jSONObject.getBoolean(com.baidu.yuyinala.privatemessage.implugin.util.d.oVu);
                        }
                    } catch (Exception e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "init uid and name error");
                    }
                    this.oOC.setVisibility(8);
                    this.mListenerKey = String.valueOf(this.oOT);
                    YF(this.mNickName);
                    ib(this.oOT);
                    return;
                case 80:
                    ChatInfo.oNx = ChatInfo.ChatCategory.DUZHAN;
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
            com.baidu.yuyinala.privatemessage.implugin.d.b.elg().c(this, e3);
        }
    }

    private void eB(JSONObject jSONObject) {
        try {
            this.mPaid = Long.parseLong(jSONObject.getString("paid"));
            ChatInfo.mPaid = this.mPaid;
            if (this.oOU) {
                long parseLong = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.oVo));
                if (parseLong > 0) {
                    ChatInfo.mUid = parseLong;
                }
            }
            elA();
        } catch (Exception e2) {
            LogUtils.e(MAFragmentActivity.TAG, "init appid error");
        }
        this.mListenerKey = String.valueOf(this.mPaid);
        ia(this.mPaid);
    }

    private void ia(long j2) {
        this.oOC.setVisibility(8);
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
                    ActivityChat.this.oPh.post(ActivityChat.this.oPl);
                }
            });
        } else {
            this.oPh.post(this.oPl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class h implements Runnable {
        private final SoftReference<ActivityChat> oPz;

        private h(ActivityChat activityChat) {
            this.oPz = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPz.get() != null) {
                try {
                    ChatInfo.oNz = AccountManager.getUK(this.oPz.get().getApplicationContext());
                    this.oPz.get();
                    LogUtils.d(MAFragmentActivity.TAG, "parunnable ---> " + ChatInfo.oNz);
                    if (ChatInfo.oNz != -1) {
                        this.oPz.get().mChatStatus = 0;
                        this.oPz.get().elx();
                        this.oPz.get();
                        LogUtils.d(MAFragmentActivity.TAG, "parunnable -->1");
                        ChatInfo.mContacter = this.oPz.get().mPaInfo.getPaId();
                        ChatInfo.mPainfo = this.oPz.get().mPaInfo;
                        if (ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN) {
                            this.oPz.get().jUz = ChatMsgManager.getUnReadMsgCountByPaid(this.oPz.get(), this.oPz.get().mPaid);
                            if (this.oPz.get().jUz > 200) {
                                this.oPz.get().jUz = 200;
                            }
                        }
                        this.oPz.get().VD();
                        this.oPz.get().u(this.oPz.get().mPaid, true);
                    } else {
                        this.oPz.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    this.oPz.get().oPb = TextUtils.isEmpty(this.oPz.get().oPb) ? this.oPz.get().mPaInfo.getNickName() : this.oPz.get().oPb;
                    this.oPz.get().oOB.setText(String.valueOf(this.oPz.get().oPb));
                    this.oPz.get().elu();
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elx() {
        com.baidu.yuyinala.privatemessage.implugin.d.b.elg().a(getActivity(), new IGetUsersProfileBatchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.18
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2) {
                if (i2 == 0 && arrayList2 != null && arrayList2.size() == 1) {
                    ChatInfo.oNA = ActivityChat.this.YH(arrayList2.get(0).getIconUrl());
                    ChatInfo.displayname = arrayList2.get(0).getUserName();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ely() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.b(ExtraParamsManager.getEncryptionUserId(ChatInfo.mUid + "")));
    }

    private static void elz() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031061, TbConfig.SERVER_ADDRESS + "ala/audio/user/preFollow");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void elA() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.a(ExtraParamsManager.getEncryptionUserId(this.mPaid + "")));
    }

    private void elB() {
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
                        ActivityChat.this.ely();
                    }
                }
            }
        });
    }

    public boolean elC() {
        return this.oOZ == 2 || this.oOZ == 11;
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
        this.oOy = (RelativeLayout) findViewById(a.f.bd_im_chat_title_root);
        this.oOz = findViewById(a.f.bd_im_chat_cell_space_line);
        this.oOA = (TextView) findViewById(a.f.bd_im_chat_open_main);
        this.oOG = (LinearLayout) findViewById(a.f.bd_im_chat_open_main_click_parent);
        this.oOG.setOnClickListener(this.oPm);
        this.oOH = (RelativeLayout) findViewById(a.f.bd_im_chat_back_layout);
        this.oOH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.onBackClick();
            }
        });
        this.oOB = (TextView) findViewById(a.f.bd_im_chat_title);
        this.oOC = (TextView) findViewById(a.f.bd_im_chat_subtitle);
        this.oOD = findViewById(a.f.bd_im_chat_main_input);
        this.oOE = (FrameLayout) findViewById(a.f.bd_im_chat_main_content);
        this.oOF = (FrameLayout) findViewById(a.f.bd_im_chat_main_input);
        this.oOI = (FrameLayout) findViewById(a.f.bd_im_chat_main_error_content);
        this.oOQ = (ImageView) findViewById(a.f.bd_im_chat_main_error_image);
        this.oOI.setVisibility(8);
        this.oOJ = (FrameLayout) findViewById(a.f.bd_im_chat_main_retry_content);
        this.oOJ.setVisibility(8);
        findViewById(a.f.bd_im_chat_main_retry_button).setOnClickListener(this.oPk);
        this.oOB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.elH();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VD() {
        if (this.oOK == null) {
            FrameLayout frameLayout = this.oOE;
            this.oOE.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_chat, null));
            this.oOK = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.a(this, this.oOE, this.mListenerKey, this.oPg, this.jUz);
        }
        if (this.oOL == null) {
            FrameLayout frameLayout2 = this.oOF;
            this.oOF.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_input, null));
            this.oOL = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.a(this, this.oOF, this.mListenerKey, this.oPg);
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "initFragment : ");
        if (!isFinishing()) {
            try {
                com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "mTransaction.commitAllowingStateLoss() : ");
            } catch (Exception e2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "e :" + e2);
                com.baidu.yuyinala.privatemessage.implugin.d.b.elg().c(this, e2);
            }
        }
        if (this.oOK != null) {
            this.oOK.a(this);
        }
        ic(this.oOT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void elD() {
        this.oOX = AnimationUtils.loadAnimation(this, a.C0205a.bd_im_fragment_in_from_bottom);
        this.oOY = AnimationUtils.loadAnimation(this, a.C0205a.bd_im_fragment_out_to_bottom);
    }

    private void ib(long j2) {
        if (j2 == 0) {
            this.oOR = null;
            showToast(a.h.bd_im_read_error);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j2));
        final SoftReference softReference = new SoftReference(this);
        com.baidu.yuyinala.privatemessage.implugin.d.b.elg().a(getApplicationContext(), arrayList, false, new b.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList2, ArrayList<ChatUser> arrayList3) {
                if (softReference.get() != null) {
                    if (i2 != 0) {
                        ((ActivityChat) softReference.get()).oPh.post(ActivityChat.this.oPq);
                        return;
                    }
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        ((ActivityChat) softReference.get()).oOR = arrayList3.get(0);
                    }
                    if (((ActivityChat) softReference.get()).oOR == null) {
                        ((ActivityChat) softReference.get()).oPh.post(ActivityChat.this.oPp);
                        return;
                    }
                    ArrayList<Long> arrayList4 = new ArrayList<>();
                    arrayList4.add(Long.valueOf(ActivityChat.this.oOR.getUk()));
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elg().a(ActivityChat.this.getApplicationContext(), arrayList4, new b.InterfaceC0965b() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7.1
                        @Override // com.baidu.android.imsdk.chatuser.IGetUserStatusListener
                        public void onGetUsersStatusResult(int i3, String str2, ArrayList<UserStatus> arrayList5) {
                            if (i3 == 0 && arrayList5.size() == 1) {
                                ((ActivityChat) softReference.get()).oPc = arrayList5.get(0);
                                ((ActivityChat) softReference.get()).oPh.post(ActivityChat.this.oPn);
                            }
                        }
                    });
                    ((ActivityChat) softReference.get()).oPh.post(ActivityChat.this.oPo);
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
                            ActivityChat.this.oPh.sendEmptyMessageDelayed(7, 1000L);
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

    protected void elE() {
    }

    public ImBaseEntity elF() {
        return this.oPe;
    }

    protected void elG() {
    }

    protected void YF(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oOB.setText(str);
        } else if (this.mNickName != null) {
            this.oOB.setText(String.valueOf(this.mNickName));
        } else if (this.oOR != null) {
            this.oOB.setText(String.valueOf(this.oOR.getUserName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elH() {
        String liveId = getLiveId();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig((Context) getActivity(), ChatInfo.mUid + "", (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, 0L, 0L, 0L, 0, getGroupId(), liveId, false, (String) null, (String) null, (String) null, (String) null, (String) null)));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
    }

    /* loaded from: classes4.dex */
    private static class l implements Runnable {
        private final SoftReference<ActivityChat> oPy;

        private l(ActivityChat activityChat) {
            this.oPy = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes4.dex */
    private static class k implements Runnable {
        private final SoftReference<ActivityChat> oPy;

        private k(ActivityChat activityChat) {
            this.oPy = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPy.get() != null) {
                try {
                    ChatInfo.oNz = AccountManager.getUK(this.oPy.get().getApplicationContext());
                    if (ChatInfo.oNz != -1) {
                        this.oPy.get().mChatStatus = 0;
                        this.oPy.get().elI();
                        this.oPy.get().VD();
                        this.oPy.get().id(this.oPy.get().oOT);
                    } else {
                        this.oPy.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    if (this.oPy.get().mNickName == null) {
                        if (this.oPy.get().oOR != null) {
                            this.oPy.get().oOB.setText(String.valueOf(this.oPy.get().oOR.getUserName()));
                            return;
                        }
                        return;
                    }
                    this.oPy.get().oOB.setText(String.valueOf(this.oPy.get().mNickName));
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
        String B = com.baidu.yuyinala.privatemessage.implugin.util.b.b.B(getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVK, null);
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
    public void elI() {
        elx();
        ChatInfo.mContacter = this.oOR.getUk();
        ChatInfo.mUid = this.oOR.getBuid();
        ChatInfo.mStatus = 3;
        ChatInfo.oNy = this.oOR.getUserName();
        if (!TextUtils.isEmpty(this.mIcon)) {
            ChatInfo.oNB = this.mIcon;
        } else {
            ChatInfo.oNB = YH(this.oOR.getIconUrl());
        }
        BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
        LogUtils.i(MAFragmentActivity.TAG, "uk:" + ChatInfo.oNz);
        LogUtils.i(MAFragmentActivity.TAG, "header:" + ChatInfo.oNA);
        LogUtils.i(MAFragmentActivity.TAG, "" + this.oOR.toString());
    }

    /* loaded from: classes4.dex */
    private static class j implements Runnable {
        private final SoftReference<ActivityChat> oPy;

        private j(ActivityChat activityChat) {
            this.oPy = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPy.get() != null) {
                try {
                    ChatInfo.oNz = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().hh(this.oPy.get().getApplicationContext()).longValue();
                    this.oPy.get().mChatStatus = 0;
                    this.oPy.get().VD();
                    if (this.oPy.get().mNickName != null) {
                        this.oPy.get().oOB.setText(String.valueOf(this.oPy.get().mNickName));
                    }
                    this.oPy.get().oPh.sendEmptyMessage(1);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final SoftReference<ActivityChat> oPy;

        private a(ActivityChat activityChat) {
            this.oPy = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPy.get() != null) {
                try {
                    ChatInfo.oNz = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().hh(this.oPy.get().getApplicationContext()).longValue();
                    this.oPy.get().mChatStatus = 1;
                    this.oPy.get().VD();
                    if (this.oPy.get().mNickName != null) {
                        this.oPy.get().oOB.setText(String.valueOf(this.oPy.get().mNickName));
                    }
                    this.oPy.get().oPh.sendEmptyMessage(1006);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class b implements Runnable {
        private final SoftReference<ActivityChat> oPy;

        private b(ActivityChat activityChat) {
            this.oPy = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPy.get() != null) {
                try {
                    ChatInfo.oNz = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().hh(this.oPy.get().getApplicationContext()).longValue();
                    String str = null;
                    if (this.oPy.get().oOS != null) {
                        str = this.oPy.get().oOS.mInfo.getGroupName();
                    }
                    if (ChatInfo.kpi == 2) {
                        if (str == null || "".equals(str.trim())) {
                            if (this.oPy.get().mNickName != null) {
                                this.oPy.get().oOB.setText(String.valueOf(this.oPy.get().mNickName));
                                return;
                            } else if (this.oPy.get().oOS != null) {
                                this.oPy.get().oOB.setText(String.valueOf(str));
                                return;
                            } else {
                                return;
                            }
                        }
                        this.oPy.get().oOB.setText(String.valueOf(str));
                    } else if (!TextUtils.isEmpty(str)) {
                        this.oPy.get().oOB.setText(String.valueOf(str));
                        this.oPy.get().oOC.setText(this.oPy.get().oOS.mInfo.getNum() + "人");
                    } else if (!TextUtils.isEmpty(this.oPy.get().mNickName)) {
                        this.oPy.get().oOB.setText(String.valueOf(this.oPy.get().mNickName));
                        this.oPy.get().oOC.setText(this.oPy.get().oOS.mInfo.getNum() + "人");
                    } else if (this.oPy.get().oOS != null) {
                        this.oPy.get().oOB.setText("未知群");
                        this.oPy.get().oOC.setText(this.oPy.get().oOS.mInfo.getNum() + "人");
                    }
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class d implements Runnable {
        private final SoftReference<ActivityChat> oPy;

        private d(ActivityChat activityChat) {
            this.oPy = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPy.get() != null) {
                try {
                    this.oPy.get().oOD.setVisibility(0);
                    this.oPy.get().oOD.startAnimation(this.oPy.get().oOX);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class e implements Runnable {
        private final SoftReference<ActivityChat> oPy;

        private e(ActivityChat activityChat) {
            this.oPy = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oPy.get() != null) {
                try {
                    this.oPy.get().oOD.setVisibility(8);
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
                ActivityChat.this.oPh.sendMessage(message);
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
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.baidu.yuyinala.privatemessage.implugin.f.j.elk())) {
                try {
                    j2 = Long.parseLong(com.baidu.yuyinala.privatemessage.implugin.f.j.elk());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.b.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVP + ChatInfo.mPaid + ChatInfo.oNz, 0L));
            } else {
                return;
            }
        } else if (i2 == 0) {
            str = "ugc";
            j2 = this.oOT;
            date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.b.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVQ + this.oOT, 0L));
        } else {
            date = null;
        }
        if (!com.baidu.yuyinala.privatemessage.implugin.util.f.c(date, new Date())) {
            if ((this.oPd == null || !this.oPd.emL() || this.oPd.emM() != i2) && this.oOK != null) {
                this.oPd = this.oOK.aq(i2, elC());
                if (this.oPd != null) {
                    try {
                        this.oPd.c(str, j2, new g(this, i2));
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
                    activityChat.eln().sendMessage(message);
                } else if (this.flag == 0) {
                    Message message2 = new Message();
                    if (z) {
                        message2.arg1 = 0;
                    } else {
                        message2.arg1 = -1;
                    }
                    message2.what = 8;
                    activityChat.eln().sendMessage(message2);
                }
            }
        }
    }

    public void onBackClick() {
        if (this.mChatStatus == 0) {
            if (this.oOL != null) {
                this.oOL.emr();
            }
            if (this.oPd != null) {
                this.oPd.emK();
            }
        }
        finish();
        if (!ChatInfo.oNI) {
            com.baidu.yuyinala.privatemessage.implugin.d.b.elg().hk(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String YH(String str) {
        return str;
    }
}
