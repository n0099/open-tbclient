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
/* loaded from: classes11.dex */
public class ActivityChat extends BaseFragmentActivity implements com.baidu.yuyinala.privatemessage.implugin.ui.activity.a, com.baidu.yuyinala.privatemessage.implugin.ui.activity.c, ThemeManager.a {
    public static boolean oVh;
    protected String aUZ;
    protected boolean isFollowed;
    private LinearLayout mContainer;
    private String mGroupId;
    private String mIcon;
    private String mLiveId;
    private String mNickName;
    private PaInfo mPaInfo;
    public long mPaid;
    private RelativeLayout oUK;
    private View oUL;
    private TextView oUM;
    private TextView oUN;
    private TextView oUO;
    private View oUP;
    private FrameLayout oUQ;
    private FrameLayout oUR;
    private LinearLayout oUS;
    private RelativeLayout oUT;
    private FrameLayout oUU;
    private FrameLayout oUV;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a oUW;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b oUX;
    private LinearLayout oUY;
    private TextView oUZ;
    private ImageView oVa;
    private ImageView oVb;
    private ImageView oVc;
    private ChatUser oVd;
    protected QMGroupInfo oVe;
    protected long oVf;
    public boolean oVg;
    private Animation oVj;
    private Animation oVk;
    private String oVn;
    private UserStatus oVo;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c oVp;
    protected ImBaseEntity oVq;
    private com.baidu.yuyinala.privatemessage.implugin.ui.a.a oVr;
    private long oVu;
    private int khM = 0;
    public boolean oVi = false;
    private int mChatStatus = 1;
    private String mListenerKey = "";
    private int oVl = -1;
    private long oVm = -1;
    private c oVs = new c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.1
        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.c
        public void elO() {
            ActivityChat.this.oVt.sendEmptyMessage(1002);
        }
    };
    private f oVt = new f();
    private boolean oVv = false;
    private View.OnClickListener oVw = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ell().getLoginState(ActivityChat.this);
            ActivityChat.this.oVu = System.currentTimeMillis();
            ActivityChat.this.oVv = false;
            if (loginState == 3) {
                ActivityChat.this.oVt.removeCallbacks(ActivityChat.this.gfv);
                ActivityChat.this.oVt.postDelayed(ActivityChat.this.gfv, ActivityChat.this.elu());
                ActivityChat.this.oUV.setVisibility(8);
                ActivityChat.this.init(ActivityChat.this.getIntent());
                return;
            }
            ActivityChat.this.oVt.postDelayed(ActivityChat.this.gfv, 7000L);
            ActivityChat.this.elv();
        }
    };
    private Runnable gfv = new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mTimeOutRunnable run ");
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.ell().getLoginState(ActivityChat.this) != 3) {
                ActivityChat.this.oVv = true;
                ActivityChat.this.elw();
                return;
            }
            ActivityChat.this.elx();
        }
    };
    private h oVx = new h();
    private View.OnClickListener oVy = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChat.this.elJ();
            if (ActivityChat.this.mChatStatus == 0 && ActivityChat.this.oUX != null) {
                ActivityChat.this.oUX.emu();
            }
        }
    };
    private l oVz = new l();
    private k oVA = new k();
    private j oVB = new j();
    private a oVC = new a();
    private b oVD = new b();
    d oVE = new d();
    e oVF = new e();

    /* loaded from: classes11.dex */
    public interface c {
        void elO();
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
    public void Yo(String str) {
        if ("greet_link".equals(str)) {
            String elT = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.elT();
            String str2 = "";
            if (!TextUtils.isEmpty(ChatInfo.nickname)) {
                str2 = ChatInfo.nickname;
            } else if (!TextUtils.isEmpty(ChatInfo.displayname)) {
                str2 = ChatInfo.displayname;
            }
            com.baidu.yuyinala.privatemessage.model.message.a.eoe().E(this, elT.replace("XXX", str2), this.mListenerKey);
        } else if ("welcom_link".equals(str)) {
            com.baidu.yuyinala.privatemessage.model.message.a.eoe().E(this, com.baidu.yuyinala.privatemessage.implugin.ui.common.b.elU(), this.mListenerKey);
        }
    }

    public f els() {
        return this.oVt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class f extends Handler {
        private final SoftReference<ActivityChat> oVK;

        private f(ActivityChat activityChat) {
            this.oVK = new SoftReference<>(activityChat);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = null;
            int i = 0;
            boolean z = false;
            super.handleMessage(message);
            if (this.oVK.get() != null) {
                try {
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.oVK.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "current is no support");
                        this.oVK.get().oUS.setVisibility(4);
                        ChatInfo.mStatus = 10;
                        if (this.oVK.get().oUX != null) {
                            this.oVK.get().oUX.emo();
                        }
                        if (this.oVK.get().oUW != null) {
                            this.oVK.get().oUW.emo();
                            return;
                        }
                        return;
                    case 2:
                        if (message.arg1 == 1) {
                            com.baidu.yuyinala.privatemessage.implugin.f.j.Av(true);
                            postDelayed(new i(this.oVK), 1000L);
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emQ().bx(this.oVK.get().getApplicationContext(), this.oVK.get().getString(a.h.bd_im_zhida_success_tip));
                            if (this.oVK.get().oVp != null) {
                                this.oVK.get().oVp.dismiss();
                            }
                            String elp = com.baidu.yuyinala.privatemessage.implugin.f.j.elp();
                            if (!TextUtils.isEmpty(elp)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("sign", "media_" + elp);
                                    jSONObject.put("relation", 1);
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.ell().B(this.oVK.get().getApplicationContext(), "com.baidu.channel.subscribe", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
                                    return;
                                } catch (UnsupportedEncodingException e2) {
                                    e2.printStackTrace();
                                    return;
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            this.oVK.get();
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
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emQ().bw(this.oVK.get().getApplicationContext(), str);
                            return;
                        } else {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emQ().bw(this.oVK.get().getApplicationContext(), this.oVK.get().getString(a.h.bd_im_subscribe_fail_tip));
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                        return;
                    case 3:
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emQ().showToast(this.oVK.get().getApplicationContext(), this.oVK.get().getString(a.h.bd_im_zhida_fail_net_tip));
                        return;
                    case 5:
                        this.oVK.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 1 ");
                        this.oVK.get().finish();
                        this.oVK.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 2 ");
                        return;
                    case 6:
                        Bundle data = message.getData();
                        String str2 = "";
                        if (data != null) {
                            str2 = data.getString("subscribe_data");
                            z = data.getBoolean("update_subscribe", false);
                        }
                        com.baidu.yuyinala.privatemessage.implugin.f.j.Yl(str2);
                        ChatInfo.mPainfo.setMsgNotify(com.baidu.yuyinala.privatemessage.implugin.f.j.isNeedNotify());
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.elq() || !z) {
                            if (this.oVK.get().oVp != null && this.oVK.get().oVp.emO()) {
                                this.oVK.get().oVp.dismiss();
                            }
                        } else {
                            this.oVK.get().OP(1);
                        }
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.getData() != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.b.D(this.oVK.get().getApplicationContext(), String.valueOf(this.oVK.get().mPaid), com.baidu.yuyinala.privatemessage.implugin.f.j.getData().toString());
                            return;
                        }
                        return;
                    case 7:
                        this.oVK.get().OP(0);
                        return;
                    case 8:
                        if (message.arg1 == 0) {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emQ().bw(this.oVK.get(), "关注成功");
                            this.oVK.get().oVp.dismiss();
                            this.oVK.get().elL();
                            this.oVK.get().isFollowed = true;
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emQ().bw(this.oVK.get(), "关注失败");
                        return;
                    case 1001:
                        if (this.oVK.get().oUY != null && this.oVK.get().oUY.getVisibility() == 0) {
                            this.oVK.get().oUY.setAnimation(AnimationUtils.loadAnimation(this.oVK.get(), a.C0203a.bd_im_slip_out_from_right));
                            this.oVK.get().oUY.setVisibility(4);
                            return;
                        }
                        return;
                    case 1002:
                        this.oVK.get().elA();
                        return;
                    case 1003:
                        if (this.oVK.get().oVa != null && this.oVK.get().oVa.getVisibility() == 0) {
                            this.oVK.get().oVa.setAnimation(AnimationUtils.loadAnimation(this.oVK.get(), a.C0203a.bd_im_disappear_out));
                            this.oVK.get().oVa.setVisibility(4);
                            return;
                        }
                        return;
                    case 1006:
                        this.oVK.get().oUS.setVisibility(4);
                        ChatInfo.mStatus = 11;
                        if (this.oVK.get().oUX != null) {
                            this.oVK.get().oUX.emo();
                        }
                        this.oVK.get().oUU.setVisibility(0);
                        return;
                    case 1007:
                    case 1008:
                        return;
                    case 1009:
                        if (this.oVK.get().oUW != null) {
                            this.oVK.get().oUW.Ay(false);
                        }
                        this.oVK.get().oUV.setVisibility(8);
                        this.oVK.get().init(this.oVK.get().getIntent());
                        return;
                    case 1010:
                        if (this.oVK.get().oUW != null) {
                            this.oVK.get().oUW.Ay(true);
                        }
                        if (this.oVK.get().oUX != null) {
                            this.oVK.get().oUX.emo();
                            return;
                        }
                        return;
                    case 1011:
                        this.oVK.get().oUS.setVisibility(4);
                        ChatInfo.mStatus = 12;
                        if (this.oVK.get().oUX != null) {
                            this.oVK.get().oUX.emo();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class i implements Runnable {
        private final SoftReference<ActivityChat> oVK;

        private i(SoftReference<ActivityChat> softReference) {
            this.oVK = softReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oVK.get() != null) {
                this.oVK.get().v(this.oVK.get().mPaid, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BIMManager.mediaSetRole(getActivity(), true);
        elG();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        setContentView(a.g.bd_im_chat_activity_layout);
        this.mContainer = (LinearLayout) findViewById(a.f.bd_im_chat_root);
        this.oVr = new com.baidu.yuyinala.privatemessage.implugin.ui.a.a();
        elI();
        init(getIntent());
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.ell().isCuidLogin(this) || com.baidu.yuyinala.privatemessage.implugin.d.b.ell().elm()) {
            this.oVi = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    private void elt() {
        this.oVu = System.currentTimeMillis();
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ell().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "loginOver loginState: " + loginState);
        if (this.oUW != null) {
            this.oUW.emp();
        }
        switch (loginState) {
            case 2:
                this.oVt.postDelayed(this.gfv, 7000L);
                elv();
                return;
            case 3:
                this.oVt.postDelayed(this.gfv, elu());
                this.oUV.setVisibility(8);
                this.oVt.sendEmptyMessage(1009);
                return;
            default:
                this.oVt.postDelayed(this.gfv, 7000L);
                ely();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long elu() {
        long currentTimeMillis = 10000 - (System.currentTimeMillis() - this.oVu);
        if (currentTimeMillis > 7000) {
            return 7000L;
        }
        return currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elv() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "retryLogin timeout " + this.oVv);
        if (!this.oVv) {
            this.oVt.sendEmptyMessage(1010);
            com.baidu.yuyinala.privatemessage.implugin.d.b.ell().a(this, new b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.13
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
    public void elw() {
        if (this.oUW != null) {
            this.oUW.Ay(false);
        }
        if (this.oUX != null) {
            this.oUX.emo();
        }
        this.oUV.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elx() {
        if (this.oUW != null) {
            this.oUW.Ay(false);
        }
    }

    private void ely() {
        this.oVt.sendEmptyMessage(1010);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus ");
        com.baidu.yuyinala.privatemessage.implugin.d.b.ell().a(this, new b.e() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.14
            @Override // com.baidu.android.imsdk.account.ILoginStateChangedListener
            public void onLoginStateChanged(int i2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus onLoginStateChanged state: " + i2);
                switch (i2) {
                    case 2:
                        ActivityChat.this.elv();
                        return;
                    case 3:
                        ActivityChat.this.oVt.removeCallbacks(ActivityChat.this.gfv);
                        ActivityChat.this.oVt.postDelayed(ActivityChat.this.gfv, ActivityChat.this.elu());
                        ActivityChat.this.oVt.sendEmptyMessage(1009);
                        return;
                    default:
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "waitting");
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elz() {
        if (this.khM > 8) {
            if (this.oUY == null) {
                this.oUY = (LinearLayout) findViewById(a.f.bd_im_chat_unread_msgs_layout);
                this.oUZ = (TextView) findViewById(a.f.bd_im_chat_unread_msgs_txt);
                this.oUZ.setText(this.khM + getString(a.h.bd_im_alert_unread_msgs));
            }
            this.oVb = (ImageView) findViewById(a.f.bd_im_chat_unread_msgs_up);
            try {
                this.oUY.setBackgroundResource(ThemeManager.U(this, a.e.bd_im_chat_unread_msgs_background));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.oUY.setAnimation(AnimationUtils.loadAnimation(this, a.C0203a.bd_im_slip_in_from_right));
            this.oUY.setVisibility(0);
            this.oUY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.oUW.OQ(ActivityChat.this.khM);
                    ActivityChat.this.oUY.setAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0203a.bd_im_slip_out_from_right));
                    ActivityChat.this.oUY.setVisibility(4);
                }
            });
            this.oVt.sendEmptyMessageDelayed(1001, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elA() {
        if (this.oVa == null) {
            this.oVa = (ImageView) findViewById(a.f.bd_im_chat_new_msgs_tip);
            this.oVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.oUW.eme();
                    ActivityChat.this.oVa.startAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0203a.bd_im_disappear_out));
                    ActivityChat.this.oVa.setVisibility(4);
                }
            });
        }
        if (this.oVa.getVisibility() != 0) {
            this.oVa.startAnimation(AnimationUtils.loadAnimation(this, a.C0203a.bd_im_disappear_in));
            this.oVa.setVisibility(0);
        }
        this.oVt.removeMessages(1003);
        this.oVt.sendEmptyMessageDelayed(1003, 10000L);
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
        switch (ChatInfo.oTH) {
            case GROUP:
                com.baidu.yuyinala.privatemessage.implugin.d.b.ell().setAllMsgRead(getApplicationContext(), 1, ChatInfo.mContacter, false);
                break;
            default:
                BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
                break;
        }
        try {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emG();
            com.baidu.yuyinala.privatemessage.implugin.imagechooser.a.elj();
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.ell().c(this, th);
        }
        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emQ().dismiss();
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mChatCategory " + ChatInfo.oTH + " mOnlineStatus " + this.oVo);
        if (ChatInfo.oTH == ChatInfo.ChatCategory.C2C && this.oVo != null) {
            elB();
        }
        if (this.oUW != null) {
            this.oUW.a((com.baidu.yuyinala.privatemessage.implugin.ui.activity.a) null);
        }
        if (this.oUX != null) {
            this.oUX.onDestroy();
        }
        if (this.oUW != null) {
            this.oUW.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i2) {
    }

    private void elB() {
        Intent intent = new Intent(IMConstants.NOTICE_USER_STATE);
        intent.putExtra(IMConstants.NOTICE_USER_STATE_OBJECT, this.oVo);
        sendBroadcast(intent);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "noticeSessionState com.baidu.android.imsdk.notice.userstate");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onResume--->");
        super.onResume();
        com.baidu.yuyinala.privatemessage.implugin.d.b.ell().Au(true);
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ell().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onResume mIsCuidOrIncompleteLogin: " + this.oVi + " loginState: " + loginState);
        if (this.oVi && (!com.baidu.yuyinala.privatemessage.implugin.d.b.ell().isCuidLogin(this) || !com.baidu.yuyinala.privatemessage.implugin.d.b.ell().elm() || (loginState != 0 && loginState != 3))) {
            elt();
        } else if (this.oVp != null && this.oVp.emO() && ChatInfo.ChatCategory.DUZHAN == ChatInfo.oTH) {
            v(this.mPaid, true);
        }
        if (this.oUX != null) {
            this.oUX.onResume();
        }
        if (this.oUW != null) {
            this.oUW.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStop--->");
        super.onStop();
        if (this.oUX != null) {
            this.oUX.onStop();
        }
        if (this.oUW != null) {
            this.oUW.onStop();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStop");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStart--->");
        super.onStart();
        if (this.oUX != null) {
            this.oUX.onStart();
        }
        if (this.oUW != null) {
            this.oUW.onStart();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStart");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onPause--->");
        super.onPause();
        com.baidu.yuyinala.privatemessage.implugin.d.b.ell().Au(false);
        if (this.oUX != null) {
            this.oUX.onPause();
        }
        if (this.oUW != null) {
            this.oUW.onPause();
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
            this.aUZ = ExtraParamsManager.getEncryptionUserId(extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pbw));
            this.oVg = extras.getBoolean("isMediaRole");
            this.mGroupId = extras.getString("groupid");
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("miliao", "mIsmediaRole：" + this.oVg);
            this.mLiveId = extras.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            oVh = this.oVg;
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.pbw, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pbw));
            jSONObject.put("paid", extras.getString("paid"));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.pby, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pby));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.pbA, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pbA));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.pbz, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pbz));
            String jSONObject2 = jSONObject.toString();
            try {
                if (!TextUtils.isEmpty(extras.getString("action"))) {
                    Serializable serializable = extras.getSerializable("params");
                    if (serializable instanceof ImBaseEntity) {
                        this.oVq = (ImBaseEntity) serializable;
                        if (this.oVe == null) {
                            GroupInfo groupInfo = new GroupInfo(String.valueOf(this.oVq.id));
                            groupInfo.setGroupName(this.oVq.name);
                            groupInfo.setDescription(this.oVq.description);
                            groupInfo.setHeadUrl(this.oVq.headUrl);
                            this.oVe = new QMGroupInfo(groupInfo);
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
        elE();
        String aw = aw(intent);
        if (this.oUS != null) {
            if (this.oVg) {
                this.oUS.setVisibility(8);
            } else {
                this.oUS.setVisibility(0);
            }
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + aw);
        ChatInfo.mContacter = -1L;
        ChatInfo.oTJ = -1L;
        ChatInfo.mAppid = -1L;
        ChatInfo.mUid = -1L;
        ChatInfo.oTK = "";
        ChatInfo.oTL = "";
        ChatInfo.oTM = -1;
        ChatInfo.oTQ = 0;
        ChatInfo.oTT = true;
        ChatInfo.oTS = false;
        try {
            JSONObject jSONObject = new JSONObject(aw);
            int i2 = jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.pbz) ? jSONObject.getInt(com.baidu.yuyinala.privatemessage.implugin.util.d.pbz) : -1;
            if (i2 == -1) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "invoke error -1");
                return;
            }
            if (i2 == 80) {
                parseLong = Long.parseLong(jSONObject.optString("paid", "-1"));
            } else {
                parseLong = Long.parseLong(jSONObject.optString(com.baidu.yuyinala.privatemessage.implugin.util.d.pbw, "-1"));
            }
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + aw);
            if (this.oVl != -1 && (this.oVl != i2 || this.oVm != parseLong)) {
                if (this.oUW != null) {
                    this.oUW.emp();
                }
                if (this.oUN != null) {
                    this.oUN.setText("");
                }
            }
            this.oVl = i2;
            switch (i2) {
                case 0:
                    ChatInfo.oTH = ChatInfo.ChatCategory.C2C;
                    try {
                        this.oVf = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pbw));
                        ChatInfo.mUid = this.oVf;
                        elD();
                        this.mNickName = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pby);
                        this.mIcon = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pbA);
                        if (jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.pbC)) {
                            ChatInfo.oTT = jSONObject.getBoolean(com.baidu.yuyinala.privatemessage.implugin.util.d.pbC);
                        }
                    } catch (Exception e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "init uid and name error");
                    }
                    this.oUO.setVisibility(8);
                    this.mListenerKey = String.valueOf(this.oVf);
                    Yp(this.mNickName);
                    hV(this.oVf);
                    return;
                case 80:
                    ChatInfo.oTH = ChatInfo.ChatCategory.DUZHAN;
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
            com.baidu.yuyinala.privatemessage.implugin.d.b.ell().c(this, e3);
        }
    }

    private void eP(JSONObject jSONObject) {
        try {
            this.mPaid = Long.parseLong(jSONObject.getString("paid"));
            ChatInfo.mPaid = this.mPaid;
            if (this.oVg) {
                long parseLong = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pbw));
                if (parseLong > 0) {
                    ChatInfo.mUid = parseLong;
                }
            }
            elF();
        } catch (Exception e2) {
            LogUtils.e(MAFragmentActivity.TAG, "init appid error");
        }
        this.mListenerKey = String.valueOf(this.mPaid);
        hU(this.mPaid);
    }

    private void hU(long j2) {
        this.oUO.setVisibility(8);
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
                    ActivityChat.this.oVt.post(ActivityChat.this.oVx);
                }
            });
        } else {
            this.oVt.post(this.oVx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class h implements Runnable {
        private final SoftReference<ActivityChat> oVL;

        private h(ActivityChat activityChat) {
            this.oVL = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oVL.get() != null) {
                try {
                    ChatInfo.oTJ = AccountManager.getUK(this.oVL.get().getApplicationContext());
                    this.oVL.get();
                    LogUtils.d(MAFragmentActivity.TAG, "parunnable ---> " + ChatInfo.oTJ);
                    if (ChatInfo.oTJ != -1) {
                        this.oVL.get().mChatStatus = 0;
                        this.oVL.get().elC();
                        this.oVL.get();
                        LogUtils.d(MAFragmentActivity.TAG, "parunnable -->1");
                        ChatInfo.mContacter = this.oVL.get().mPaInfo.getPaId();
                        ChatInfo.mPainfo = this.oVL.get().mPaInfo;
                        if (ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN) {
                            this.oVL.get().khM = ChatMsgManager.getUnReadMsgCountByPaid(this.oVL.get(), this.oVL.get().mPaid);
                            if (this.oVL.get().khM > 200) {
                                this.oVL.get().khM = 200;
                            }
                        }
                        this.oVL.get().WF();
                        this.oVL.get().v(this.oVL.get().mPaid, true);
                    } else {
                        this.oVL.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    this.oVL.get().oVn = TextUtils.isEmpty(this.oVL.get().oVn) ? this.oVL.get().mPaInfo.getNickName() : this.oVL.get().oVn;
                    this.oVL.get().oUN.setText(String.valueOf(this.oVL.get().oVn));
                    this.oVL.get().elz();
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elC() {
        com.baidu.yuyinala.privatemessage.implugin.d.b.ell().a(getActivity(), new IGetUsersProfileBatchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.18
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2) {
                if (i2 == 0 && arrayList2 != null && arrayList2.size() == 1) {
                    ChatInfo.oTK = ActivityChat.this.Yr(arrayList2.get(0).getIconUrl());
                    ChatInfo.displayname = arrayList2.get(0).getUserName();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elD() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.b(ExtraParamsManager.getEncryptionUserId(ChatInfo.mUid + "")));
    }

    private static void elE() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031061, com.baidu.live.a.aAH + "ala/audio/user/preFollow");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void elF() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.a(ExtraParamsManager.getEncryptionUserId(this.mPaid + "")));
    }

    private void elG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031067, com.baidu.live.a.aAH + "ala/audio/user/getPaBindInfo");
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
                        ActivityChat.this.elD();
                    }
                }
            }
        });
    }

    public boolean elH() {
        return this.oVl == 2 || this.oVl == 11;
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
        this.oUK = (RelativeLayout) findViewById(a.f.bd_im_chat_title_root);
        this.oUL = findViewById(a.f.bd_im_chat_cell_space_line);
        this.oUM = (TextView) findViewById(a.f.bd_im_chat_open_main);
        this.oUS = (LinearLayout) findViewById(a.f.bd_im_chat_open_main_click_parent);
        this.oUS.setOnClickListener(this.oVy);
        this.oUT = (RelativeLayout) findViewById(a.f.bd_im_chat_back_layout);
        this.oUT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.onBackClick();
            }
        });
        this.oUN = (TextView) findViewById(a.f.bd_im_chat_title);
        this.oUO = (TextView) findViewById(a.f.bd_im_chat_subtitle);
        this.oUP = findViewById(a.f.bd_im_chat_main_input);
        this.oUQ = (FrameLayout) findViewById(a.f.bd_im_chat_main_content);
        this.oUR = (FrameLayout) findViewById(a.f.bd_im_chat_main_input);
        this.oUU = (FrameLayout) findViewById(a.f.bd_im_chat_main_error_content);
        this.oVc = (ImageView) findViewById(a.f.bd_im_chat_main_error_image);
        this.oUU.setVisibility(8);
        this.oUV = (FrameLayout) findViewById(a.f.bd_im_chat_main_retry_content);
        this.oUV.setVisibility(8);
        findViewById(a.f.bd_im_chat_main_retry_button).setOnClickListener(this.oVw);
        this.oUN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.elM();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WF() {
        if (this.oUW == null) {
            FrameLayout frameLayout = this.oUQ;
            this.oUQ.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_chat, null));
            this.oUW = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.a(this, this.oUQ, this.mListenerKey, this.oVs, this.khM);
        }
        if (this.oUX == null) {
            FrameLayout frameLayout2 = this.oUR;
            this.oUR.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_input, null));
            this.oUX = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.a(this, this.oUR, this.mListenerKey, this.oVs);
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "initFragment : ");
        if (!isFinishing()) {
            try {
                com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "mTransaction.commitAllowingStateLoss() : ");
            } catch (Exception e2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "e :" + e2);
                com.baidu.yuyinala.privatemessage.implugin.d.b.ell().c(this, e2);
            }
        }
        if (this.oUW != null) {
            this.oUW.a(this);
        }
        hW(this.oVf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void elI() {
        this.oVj = AnimationUtils.loadAnimation(this, a.C0203a.bd_im_fragment_in_from_bottom);
        this.oVk = AnimationUtils.loadAnimation(this, a.C0203a.bd_im_fragment_out_to_bottom);
    }

    private void hV(long j2) {
        if (j2 == 0) {
            this.oVd = null;
            showToast(a.h.bd_im_read_error);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j2));
        final SoftReference softReference = new SoftReference(this);
        com.baidu.yuyinala.privatemessage.implugin.d.b.ell().a(getApplicationContext(), arrayList, false, new b.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList2, ArrayList<ChatUser> arrayList3) {
                if (softReference.get() != null) {
                    if (i2 != 0) {
                        ((ActivityChat) softReference.get()).oVt.post(ActivityChat.this.oVC);
                        return;
                    }
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        ((ActivityChat) softReference.get()).oVd = arrayList3.get(0);
                    }
                    if (((ActivityChat) softReference.get()).oVd == null) {
                        ((ActivityChat) softReference.get()).oVt.post(ActivityChat.this.oVB);
                        return;
                    }
                    ArrayList<Long> arrayList4 = new ArrayList<>();
                    arrayList4.add(Long.valueOf(ActivityChat.this.oVd.getUk()));
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ell().a(ActivityChat.this.getApplicationContext(), arrayList4, new b.InterfaceC0941b() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7.1
                        @Override // com.baidu.android.imsdk.chatuser.IGetUserStatusListener
                        public void onGetUsersStatusResult(int i3, String str2, ArrayList<UserStatus> arrayList5) {
                            if (i3 == 0 && arrayList5.size() == 1) {
                                ((ActivityChat) softReference.get()).oVo = arrayList5.get(0);
                                ((ActivityChat) softReference.get()).oVt.post(ActivityChat.this.oVz);
                            }
                        }
                    });
                    ((ActivityChat) softReference.get()).oVt.post(ActivityChat.this.oVA);
                }
            }
        });
        com.baidu.yuyinala.privatemessage.implugin.f.k.hB(getApplicationContext()).b(j2, new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.8
            @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
            public void d(int i2, String str, long j3) {
                try {
                    LogUtils.d(MAFragmentActivity.TAG, "getUserSubscribe->" + str);
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1) == 0) {
                        JSONArray jSONArray = jSONObject.optJSONObject("data").getJSONArray("items");
                        if (jSONArray == null || jSONArray.length() < 1) {
                            ActivityChat.this.oVt.sendEmptyMessageDelayed(7, 1000L);
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
            com.baidu.yuyinala.privatemessage.implugin.e.a.hA(getApplicationContext()).gZ("542", "chat_flow_time");
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
        }
    }

    protected void hW(long j2) {
    }

    protected void elJ() {
    }

    public ImBaseEntity elK() {
        return this.oVq;
    }

    protected void elL() {
    }

    protected void Yp(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oUN.setText(str);
        } else if (this.mNickName != null) {
            this.oUN.setText(String.valueOf(this.mNickName));
        } else if (this.oVd != null) {
            this.oUN.setText(String.valueOf(this.oVd.getUserName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elM() {
        String liveId = getLiveId();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getActivity(), ChatInfo.mUid + "", null, null, null, 0, 0, null, null, 0L, 0L, 0L, 0, getGroupId(), liveId, false, null, null, null, null, null)));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
    }

    /* loaded from: classes11.dex */
    private static class l implements Runnable {
        private final SoftReference<ActivityChat> oVK;

        private l(ActivityChat activityChat) {
            this.oVK = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes11.dex */
    private static class k implements Runnable {
        private final SoftReference<ActivityChat> oVK;

        private k(ActivityChat activityChat) {
            this.oVK = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oVK.get() != null) {
                try {
                    ChatInfo.oTJ = AccountManager.getUK(this.oVK.get().getApplicationContext());
                    if (ChatInfo.oTJ != -1) {
                        this.oVK.get().mChatStatus = 0;
                        this.oVK.get().elN();
                        this.oVK.get().WF();
                        this.oVK.get().hX(this.oVK.get().oVf);
                    } else {
                        this.oVK.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    if (this.oVK.get().mNickName == null) {
                        if (this.oVK.get().oVd != null) {
                            this.oVK.get().oUN.setText(String.valueOf(this.oVK.get().oVd.getUserName()));
                            return;
                        }
                        return;
                    }
                    this.oVK.get().oUN.setText(String.valueOf(this.oVK.get().mNickName));
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hX(long j2) {
        if (Yq(String.valueOf(j2))) {
        }
    }

    private boolean Yq(String str) {
        String C = com.baidu.yuyinala.privatemessage.implugin.util.c.b.C(getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pbW, null);
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
    public void elN() {
        elC();
        ChatInfo.mContacter = this.oVd.getUk();
        ChatInfo.mUid = this.oVd.getBuid();
        ChatInfo.mStatus = 3;
        ChatInfo.oTI = this.oVd.getUserName();
        if (!TextUtils.isEmpty(this.mIcon)) {
            ChatInfo.oTL = this.mIcon;
        } else {
            ChatInfo.oTL = Yr(this.oVd.getIconUrl());
        }
        BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
        LogUtils.i(MAFragmentActivity.TAG, "uk:" + ChatInfo.oTJ);
        LogUtils.i(MAFragmentActivity.TAG, "header:" + ChatInfo.oTK);
        LogUtils.i(MAFragmentActivity.TAG, "" + this.oVd.toString());
    }

    /* loaded from: classes11.dex */
    private static class j implements Runnable {
        private final SoftReference<ActivityChat> oVK;

        private j(ActivityChat activityChat) {
            this.oVK = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oVK.get() != null) {
                try {
                    ChatInfo.oTJ = com.baidu.yuyinala.privatemessage.implugin.d.b.ell().hw(this.oVK.get().getApplicationContext()).longValue();
                    this.oVK.get().mChatStatus = 0;
                    this.oVK.get().WF();
                    if (this.oVK.get().mNickName != null) {
                        this.oVK.get().oUN.setText(String.valueOf(this.oVK.get().mNickName));
                    }
                    this.oVK.get().oVt.sendEmptyMessage(1);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        private final SoftReference<ActivityChat> oVK;

        private a(ActivityChat activityChat) {
            this.oVK = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oVK.get() != null) {
                try {
                    ChatInfo.oTJ = com.baidu.yuyinala.privatemessage.implugin.d.b.ell().hw(this.oVK.get().getApplicationContext()).longValue();
                    this.oVK.get().mChatStatus = 1;
                    this.oVK.get().WF();
                    if (this.oVK.get().mNickName != null) {
                        this.oVK.get().oUN.setText(String.valueOf(this.oVK.get().mNickName));
                    }
                    this.oVK.get().oVt.sendEmptyMessage(1006);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private final SoftReference<ActivityChat> oVK;

        private b(ActivityChat activityChat) {
            this.oVK = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oVK.get() != null) {
                try {
                    ChatInfo.oTJ = com.baidu.yuyinala.privatemessage.implugin.d.b.ell().hw(this.oVK.get().getApplicationContext()).longValue();
                    String str = null;
                    if (this.oVK.get().oVe != null) {
                        str = this.oVK.get().oVe.mInfo.getGroupName();
                    }
                    if (ChatInfo.oTM == 2) {
                        if (str == null || "".equals(str.trim())) {
                            if (this.oVK.get().mNickName != null) {
                                this.oVK.get().oUN.setText(String.valueOf(this.oVK.get().mNickName));
                                return;
                            } else if (this.oVK.get().oVe != null) {
                                this.oVK.get().oUN.setText(String.valueOf(str));
                                return;
                            } else {
                                return;
                            }
                        }
                        this.oVK.get().oUN.setText(String.valueOf(str));
                    } else if (!TextUtils.isEmpty(str)) {
                        this.oVK.get().oUN.setText(String.valueOf(str));
                        this.oVK.get().oUO.setText(this.oVK.get().oVe.mInfo.getNum() + "人");
                    } else if (!TextUtils.isEmpty(this.oVK.get().mNickName)) {
                        this.oVK.get().oUN.setText(String.valueOf(this.oVK.get().mNickName));
                        this.oVK.get().oUO.setText(this.oVK.get().oVe.mInfo.getNum() + "人");
                    } else if (this.oVK.get().oVe != null) {
                        this.oVK.get().oUN.setText("未知群");
                        this.oVK.get().oUO.setText(this.oVK.get().oVe.mInfo.getNum() + "人");
                    }
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class d implements Runnable {
        private final SoftReference<ActivityChat> oVK;

        private d(ActivityChat activityChat) {
            this.oVK = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oVK.get() != null) {
                try {
                    this.oVK.get().oUP.setVisibility(0);
                    this.oVK.get().oUP.startAnimation(this.oVK.get().oVj);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class e implements Runnable {
        private final SoftReference<ActivityChat> oVK;

        private e(ActivityChat activityChat) {
            this.oVK = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oVK.get() != null) {
                try {
                    this.oVK.get().oUP.setVisibility(8);
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
    public void v(long j2, final boolean z) {
        com.baidu.yuyinala.privatemessage.implugin.f.k.hB(getApplicationContext()).a(j2, new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.9
            @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
            public void d(int i2, String str, long j3) {
                Message message = new Message();
                message.what = 6;
                Bundle bundle = new Bundle();
                bundle.putString("subscribe_data", str);
                bundle.putBoolean("update_subscribe", z);
                message.setData(bundle);
                ActivityChat.this.oVt.sendMessage(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OP(int i2) {
        String str;
        Date date;
        long j2 = -1;
        if (i2 == 1) {
            str = com.baidu.yuyinala.privatemessage.implugin.f.j.getType();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.baidu.yuyinala.privatemessage.implugin.f.j.elp())) {
                try {
                    j2 = Long.parseLong(com.baidu.yuyinala.privatemessage.implugin.f.j.elp());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.c.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pcb + ChatInfo.mPaid + ChatInfo.oTJ, 0L));
            } else {
                return;
            }
        } else if (i2 == 0) {
            str = "ugc";
            j2 = this.oVf;
            date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.c.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pcc + this.oVf, 0L));
        } else {
            str = null;
            date = null;
        }
        if (!com.baidu.yuyinala.privatemessage.implugin.util.f.c(date, new Date())) {
            if ((this.oVp == null || !this.oVp.emO() || this.oVp.emP() != i2) && this.oUW != null) {
                this.oVp = this.oUW.ao(i2, elH());
                if (this.oVp != null) {
                    try {
                        this.oVp.c(str, j2, new g(this, i2));
                    } catch (NumberFormatException e3) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, e3.getMessage());
                    }
                    com.baidu.yuyinala.privatemessage.implugin.e.a.hA(getApplicationContext()).add("416", "subscribe_show");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
                    activityChat.els().sendMessage(message);
                } else if (this.flag == 0) {
                    Message message2 = new Message();
                    if (z) {
                        message2.arg1 = 0;
                    } else {
                        message2.arg1 = -1;
                    }
                    message2.what = 8;
                    activityChat.els().sendMessage(message2);
                }
            }
        }
    }

    public void onBackClick() {
        if (this.mChatStatus == 0) {
            if (this.oUX != null) {
                this.oUX.emu();
            }
            if (this.oVp != null) {
                this.oVp.emN();
            }
        }
        finish();
        if (!ChatInfo.oTT) {
            com.baidu.yuyinala.privatemessage.implugin.d.b.ell().hz(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Yr(String str) {
        return str;
    }
}
