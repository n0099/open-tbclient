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
    public static boolean pdy;
    protected String aUP;
    protected boolean isFollowed;
    private LinearLayout mContainer;
    private String mGroupId;
    private String mIcon;
    private String mLiveId;
    private String mNickName;
    private PaInfo mPaInfo;
    public long mPaid;
    private Animation pdA;
    private Animation pdB;
    private String pdE;
    private UserStatus pdF;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c pdG;
    protected ImBaseEntity pdH;
    private com.baidu.yuyinala.privatemessage.implugin.ui.a.a pdI;
    private long pdL;
    private RelativeLayout pdb;
    private View pdc;
    private TextView pdd;
    private TextView pde;
    private TextView pdf;
    private View pdg;
    private FrameLayout pdh;
    private FrameLayout pdi;
    private LinearLayout pdj;
    private RelativeLayout pdk;
    private FrameLayout pdl;
    private FrameLayout pdm;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a pdn;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b pdo;
    private LinearLayout pdp;
    private TextView pdq;
    private ImageView pdr;
    private ImageView pds;
    private ImageView pdt;
    private ChatUser pdu;
    protected QMGroupInfo pdv;
    protected long pdw;
    public boolean pdx;
    private int knG = 0;
    public boolean pdz = false;
    private int mChatStatus = 1;
    private String mListenerKey = "";
    private int pdC = -1;
    private long pdD = -1;
    private c pdJ = new c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.1
        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.c
        public void ekH() {
            ActivityChat.this.pdK.sendEmptyMessage(1002);
        }
    };
    private f pdK = new f();
    private boolean pdM = false;
    private View.OnClickListener pdN = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().getLoginState(ActivityChat.this);
            ActivityChat.this.pdL = System.currentTimeMillis();
            ActivityChat.this.pdM = false;
            if (loginState == 3) {
                ActivityChat.this.pdK.removeCallbacks(ActivityChat.this.geL);
                ActivityChat.this.pdK.postDelayed(ActivityChat.this.geL, ActivityChat.this.ekn());
                ActivityChat.this.pdm.setVisibility(8);
                ActivityChat.this.init(ActivityChat.this.getIntent());
                return;
            }
            ActivityChat.this.pdK.postDelayed(ActivityChat.this.geL, 7000L);
            ActivityChat.this.eko();
        }
    };
    private Runnable geL = new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mTimeOutRunnable run ");
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.eke().getLoginState(ActivityChat.this) != 3) {
                ActivityChat.this.pdM = true;
                ActivityChat.this.ekp();
                return;
            }
            ActivityChat.this.ekq();
        }
    };
    private h pdO = new h();
    private View.OnClickListener pdP = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChat.this.ekC();
            if (ActivityChat.this.mChatStatus == 0 && ActivityChat.this.pdo != null) {
                ActivityChat.this.pdo.eln();
            }
        }
    };
    private l pdQ = new l();
    private k pdR = new k();
    private j pdS = new j();
    private a pdT = new a();
    private b pdU = new b();
    d pdV = new d();
    e pdW = new e();

    /* loaded from: classes10.dex */
    public interface c {
        void ekH();
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
    public void YA(String str) {
        if ("greet_link".equals(str)) {
            String ekM = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.ekM();
            String str2 = "";
            if (!TextUtils.isEmpty(ChatInfo.nickname)) {
                str2 = ChatInfo.nickname;
            } else if (!TextUtils.isEmpty(ChatInfo.displayname)) {
                str2 = ChatInfo.displayname;
            }
            com.baidu.yuyinala.privatemessage.model.message.a.emU().C(this, ekM.replace("XXX", str2), this.mListenerKey);
        } else if ("welcom_link".equals(str)) {
            com.baidu.yuyinala.privatemessage.model.message.a.emU().C(this, com.baidu.yuyinala.privatemessage.implugin.ui.common.b.ekN(), this.mListenerKey);
        }
    }

    public f ekl() {
        return this.pdK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class f extends Handler {
        private final SoftReference<ActivityChat> peb;

        private f(ActivityChat activityChat) {
            this.peb = new SoftReference<>(activityChat);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = null;
            int i = 0;
            boolean z = false;
            super.handleMessage(message);
            if (this.peb.get() != null) {
                try {
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.peb.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "current is no support");
                        this.peb.get().pdj.setVisibility(4);
                        ChatInfo.mStatus = 10;
                        if (this.peb.get().pdo != null) {
                            this.peb.get().pdo.elh();
                        }
                        if (this.peb.get().pdn != null) {
                            this.peb.get().pdn.elh();
                            return;
                        }
                        return;
                    case 2:
                        if (message.arg1 == 1) {
                            com.baidu.yuyinala.privatemessage.implugin.f.j.AJ(true);
                            postDelayed(new i(this.peb), 1000L);
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elJ().bv(this.peb.get().getApplicationContext(), this.peb.get().getString(a.h.bd_im_zhida_success_tip));
                            if (this.peb.get().pdG != null) {
                                this.peb.get().pdG.dismiss();
                            }
                            String eki = com.baidu.yuyinala.privatemessage.implugin.f.j.eki();
                            if (!TextUtils.isEmpty(eki)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("sign", "media_" + eki);
                                    jSONObject.put("relation", 1);
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.eke().z(this.peb.get().getApplicationContext(), "com.baidu.channel.subscribe", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
                                    return;
                                } catch (UnsupportedEncodingException e2) {
                                    e2.printStackTrace();
                                    return;
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            this.peb.get();
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
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elJ().bu(this.peb.get().getApplicationContext(), str);
                            return;
                        } else {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elJ().bu(this.peb.get().getApplicationContext(), this.peb.get().getString(a.h.bd_im_subscribe_fail_tip));
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                        return;
                    case 3:
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elJ().showToast(this.peb.get().getApplicationContext(), this.peb.get().getString(a.h.bd_im_zhida_fail_net_tip));
                        return;
                    case 5:
                        this.peb.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 1 ");
                        this.peb.get().finish();
                        this.peb.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 2 ");
                        return;
                    case 6:
                        Bundle data = message.getData();
                        String str2 = "";
                        if (data != null) {
                            str2 = data.getString("subscribe_data");
                            z = data.getBoolean("update_subscribe", false);
                        }
                        com.baidu.yuyinala.privatemessage.implugin.f.j.Yx(str2);
                        ChatInfo.mPainfo.setMsgNotify(com.baidu.yuyinala.privatemessage.implugin.f.j.isNeedNotify());
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.ekj() || !z) {
                            if (this.peb.get().pdG != null && this.peb.get().pdG.elH()) {
                                this.peb.get().pdG.dismiss();
                            }
                        } else {
                            this.peb.get().NI(1);
                        }
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.getData() != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.b.B(this.peb.get().getApplicationContext(), String.valueOf(this.peb.get().mPaid), com.baidu.yuyinala.privatemessage.implugin.f.j.getData().toString());
                            return;
                        }
                        return;
                    case 7:
                        this.peb.get().NI(0);
                        return;
                    case 8:
                        if (message.arg1 == 0) {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elJ().bu(this.peb.get(), "关注成功");
                            this.peb.get().pdG.dismiss();
                            this.peb.get().ekE();
                            this.peb.get().isFollowed = true;
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elJ().bu(this.peb.get(), "关注失败");
                        return;
                    case 1001:
                        if (this.peb.get().pdp != null && this.peb.get().pdp.getVisibility() == 0) {
                            this.peb.get().pdp.setAnimation(AnimationUtils.loadAnimation(this.peb.get(), a.C0201a.bd_im_slip_out_from_right));
                            this.peb.get().pdp.setVisibility(4);
                            return;
                        }
                        return;
                    case 1002:
                        this.peb.get().ekt();
                        return;
                    case 1003:
                        if (this.peb.get().pdr != null && this.peb.get().pdr.getVisibility() == 0) {
                            this.peb.get().pdr.setAnimation(AnimationUtils.loadAnimation(this.peb.get(), a.C0201a.bd_im_disappear_out));
                            this.peb.get().pdr.setVisibility(4);
                            return;
                        }
                        return;
                    case 1006:
                        this.peb.get().pdj.setVisibility(4);
                        ChatInfo.mStatus = 11;
                        if (this.peb.get().pdo != null) {
                            this.peb.get().pdo.elh();
                        }
                        this.peb.get().pdl.setVisibility(0);
                        return;
                    case 1007:
                    case 1008:
                        return;
                    case 1009:
                        if (this.peb.get().pdn != null) {
                            this.peb.get().pdn.AM(false);
                        }
                        this.peb.get().pdm.setVisibility(8);
                        this.peb.get().init(this.peb.get().getIntent());
                        return;
                    case 1010:
                        if (this.peb.get().pdn != null) {
                            this.peb.get().pdn.AM(true);
                        }
                        if (this.peb.get().pdo != null) {
                            this.peb.get().pdo.elh();
                            return;
                        }
                        return;
                    case 1011:
                        this.peb.get().pdj.setVisibility(4);
                        ChatInfo.mStatus = 12;
                        if (this.peb.get().pdo != null) {
                            this.peb.get().pdo.elh();
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
        private final SoftReference<ActivityChat> peb;

        private i(SoftReference<ActivityChat> softReference) {
            this.peb = softReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.peb.get() != null) {
                this.peb.get().v(this.peb.get().mPaid, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BIMManager.mediaSetRole(getActivity(), true);
        ekz();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        setContentView(a.g.bd_im_chat_activity_layout);
        this.mContainer = (LinearLayout) findViewById(a.f.bd_im_chat_root);
        this.pdI = new com.baidu.yuyinala.privatemessage.implugin.ui.a.a();
        ekB();
        init(getIntent());
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.eke().isCuidLogin(this) || com.baidu.yuyinala.privatemessage.implugin.d.b.eke().ekf()) {
            this.pdz = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    private void ekm() {
        this.pdL = System.currentTimeMillis();
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "loginOver loginState: " + loginState);
        if (this.pdn != null) {
            this.pdn.eli();
        }
        switch (loginState) {
            case 2:
                this.pdK.postDelayed(this.geL, 7000L);
                eko();
                return;
            case 3:
                this.pdK.postDelayed(this.geL, ekn());
                this.pdm.setVisibility(8);
                this.pdK.sendEmptyMessage(1009);
                return;
            default:
                this.pdK.postDelayed(this.geL, 7000L);
                ekr();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ekn() {
        long currentTimeMillis = 10000 - (System.currentTimeMillis() - this.pdL);
        if (currentTimeMillis > 7000) {
            return 7000L;
        }
        return currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eko() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "retryLogin timeout " + this.pdM);
        if (!this.pdM) {
            this.pdK.sendEmptyMessage(1010);
            com.baidu.yuyinala.privatemessage.implugin.d.b.eke().a(this, new b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.13
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
    public void ekp() {
        if (this.pdn != null) {
            this.pdn.AM(false);
        }
        if (this.pdo != null) {
            this.pdo.elh();
        }
        this.pdm.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekq() {
        if (this.pdn != null) {
            this.pdn.AM(false);
        }
    }

    private void ekr() {
        this.pdK.sendEmptyMessage(1010);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus ");
        com.baidu.yuyinala.privatemessage.implugin.d.b.eke().a(this, new b.e() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.14
            @Override // com.baidu.android.imsdk.account.ILoginStateChangedListener
            public void onLoginStateChanged(int i2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus onLoginStateChanged state: " + i2);
                switch (i2) {
                    case 2:
                        ActivityChat.this.eko();
                        return;
                    case 3:
                        ActivityChat.this.pdK.removeCallbacks(ActivityChat.this.geL);
                        ActivityChat.this.pdK.postDelayed(ActivityChat.this.geL, ActivityChat.this.ekn());
                        ActivityChat.this.pdK.sendEmptyMessage(1009);
                        return;
                    default:
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "waitting");
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eks() {
        if (this.knG > 8) {
            if (this.pdp == null) {
                this.pdp = (LinearLayout) findViewById(a.f.bd_im_chat_unread_msgs_layout);
                this.pdq = (TextView) findViewById(a.f.bd_im_chat_unread_msgs_txt);
                this.pdq.setText(this.knG + getString(a.h.bd_im_alert_unread_msgs));
            }
            this.pds = (ImageView) findViewById(a.f.bd_im_chat_unread_msgs_up);
            try {
                this.pdp.setBackgroundResource(ThemeManager.U(this, a.e.bd_im_chat_unread_msgs_background));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.pdp.setAnimation(AnimationUtils.loadAnimation(this, a.C0201a.bd_im_slip_in_from_right));
            this.pdp.setVisibility(0);
            this.pdp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.pdn.NJ(ActivityChat.this.knG);
                    ActivityChat.this.pdp.setAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0201a.bd_im_slip_out_from_right));
                    ActivityChat.this.pdp.setVisibility(4);
                }
            });
            this.pdK.sendEmptyMessageDelayed(1001, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekt() {
        if (this.pdr == null) {
            this.pdr = (ImageView) findViewById(a.f.bd_im_chat_new_msgs_tip);
            this.pdr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.pdn.ekX();
                    ActivityChat.this.pdr.startAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0201a.bd_im_disappear_out));
                    ActivityChat.this.pdr.setVisibility(4);
                }
            });
        }
        if (this.pdr.getVisibility() != 0) {
            this.pdr.startAnimation(AnimationUtils.loadAnimation(this, a.C0201a.bd_im_disappear_in));
            this.pdr.setVisibility(0);
        }
        this.pdK.removeMessages(1003);
        this.pdK.sendEmptyMessageDelayed(1003, 10000L);
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
        switch (ChatInfo.pbX) {
            case GROUP:
                com.baidu.yuyinala.privatemessage.implugin.d.b.eke().setAllMsgRead(getApplicationContext(), 1, ChatInfo.mContacter, false);
                break;
            default:
                BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
                break;
        }
        try {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.elz();
            com.baidu.yuyinala.privatemessage.implugin.imagechooser.a.ekc();
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.eke().c(this, th);
        }
        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elJ().dismiss();
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mChatCategory " + ChatInfo.pbX + " mOnlineStatus " + this.pdF);
        if (ChatInfo.pbX == ChatInfo.ChatCategory.C2C && this.pdF != null) {
            eku();
        }
        if (this.pdn != null) {
            this.pdn.a((com.baidu.yuyinala.privatemessage.implugin.ui.activity.a) null);
        }
        if (this.pdo != null) {
            this.pdo.onDestroy();
        }
        if (this.pdn != null) {
            this.pdn.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i2) {
    }

    private void eku() {
        Intent intent = new Intent(IMConstants.NOTICE_USER_STATE);
        intent.putExtra(IMConstants.NOTICE_USER_STATE_OBJECT, this.pdF);
        sendBroadcast(intent);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "noticeSessionState com.baidu.android.imsdk.notice.userstate");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onResume--->");
        super.onResume();
        com.baidu.yuyinala.privatemessage.implugin.d.b.eke().AI(true);
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onResume mIsCuidOrIncompleteLogin: " + this.pdz + " loginState: " + loginState);
        if (this.pdz && (!com.baidu.yuyinala.privatemessage.implugin.d.b.eke().isCuidLogin(this) || !com.baidu.yuyinala.privatemessage.implugin.d.b.eke().ekf() || (loginState != 0 && loginState != 3))) {
            ekm();
        } else if (this.pdG != null && this.pdG.elH() && ChatInfo.ChatCategory.DUZHAN == ChatInfo.pbX) {
            v(this.mPaid, true);
        }
        if (this.pdo != null) {
            this.pdo.onResume();
        }
        if (this.pdn != null) {
            this.pdn.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStop--->");
        super.onStop();
        if (this.pdo != null) {
            this.pdo.onStop();
        }
        if (this.pdn != null) {
            this.pdn.onStop();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStop");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStart--->");
        super.onStart();
        if (this.pdo != null) {
            this.pdo.onStart();
        }
        if (this.pdn != null) {
            this.pdn.onStart();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStart");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onPause--->");
        super.onPause();
        com.baidu.yuyinala.privatemessage.implugin.d.b.eke().AI(false);
        if (this.pdo != null) {
            this.pdo.onPause();
        }
        if (this.pdn != null) {
            this.pdn.onPause();
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
            this.aUP = ExtraParamsManager.getEncryptionUserId(extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pjO));
            this.pdx = extras.getBoolean("isMediaRole");
            this.mGroupId = extras.getString("groupid");
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("miliao", "mIsmediaRole：" + this.pdx);
            this.mLiveId = extras.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            pdy = this.pdx;
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.pjO, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pjO));
            jSONObject.put("paid", extras.getString("paid"));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.pjQ, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pjQ));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.pjS, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pjS));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.pjR, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pjR));
            String jSONObject2 = jSONObject.toString();
            try {
                if (!TextUtils.isEmpty(extras.getString("action"))) {
                    Serializable serializable = extras.getSerializable("params");
                    if (serializable instanceof ImBaseEntity) {
                        this.pdH = (ImBaseEntity) serializable;
                        if (this.pdv == null) {
                            GroupInfo groupInfo = new GroupInfo(String.valueOf(this.pdH.id));
                            groupInfo.setGroupName(this.pdH.name);
                            groupInfo.setDescription(this.pdH.description);
                            groupInfo.setHeadUrl(this.pdH.headUrl);
                            this.pdv = new QMGroupInfo(groupInfo);
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
        ekx();
        String aw = aw(intent);
        if (this.pdj != null) {
            if (this.pdx) {
                this.pdj.setVisibility(8);
            } else {
                this.pdj.setVisibility(0);
            }
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + aw);
        ChatInfo.mContacter = -1L;
        ChatInfo.pbZ = -1L;
        ChatInfo.mAppid = -1L;
        ChatInfo.mUid = -1L;
        ChatInfo.pca = "";
        ChatInfo.pcb = "";
        ChatInfo.pcc = -1;
        ChatInfo.pcg = 0;
        ChatInfo.pcj = true;
        ChatInfo.pci = false;
        try {
            JSONObject jSONObject = new JSONObject(aw);
            int i2 = jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.pjR) ? jSONObject.getInt(com.baidu.yuyinala.privatemessage.implugin.util.d.pjR) : -1;
            if (i2 == -1) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "invoke error -1");
                return;
            }
            if (i2 == 80) {
                parseLong = Long.parseLong(jSONObject.optString("paid", "-1"));
            } else {
                parseLong = Long.parseLong(jSONObject.optString(com.baidu.yuyinala.privatemessage.implugin.util.d.pjO, "-1"));
            }
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + aw);
            if (this.pdC != -1 && (this.pdC != i2 || this.pdD != parseLong)) {
                if (this.pdn != null) {
                    this.pdn.eli();
                }
                if (this.pde != null) {
                    this.pde.setText("");
                }
            }
            this.pdC = i2;
            switch (i2) {
                case 0:
                    ChatInfo.pbX = ChatInfo.ChatCategory.C2C;
                    try {
                        this.pdw = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pjO));
                        ChatInfo.mUid = this.pdw;
                        ekw();
                        this.mNickName = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pjQ);
                        this.mIcon = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pjS);
                        if (jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.pjU)) {
                            ChatInfo.pcj = jSONObject.getBoolean(com.baidu.yuyinala.privatemessage.implugin.util.d.pjU);
                        }
                    } catch (Exception e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "init uid and name error");
                    }
                    this.pdf.setVisibility(8);
                    this.mListenerKey = String.valueOf(this.pdw);
                    YB(this.mNickName);
                    hY(this.pdw);
                    return;
                case 80:
                    ChatInfo.pbX = ChatInfo.ChatCategory.DUZHAN;
                    eT(jSONObject);
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
            com.baidu.yuyinala.privatemessage.implugin.d.b.eke().c(this, e3);
        }
    }

    private void eT(JSONObject jSONObject) {
        try {
            this.mPaid = Long.parseLong(jSONObject.getString("paid"));
            ChatInfo.mPaid = this.mPaid;
            if (this.pdx) {
                long parseLong = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.pjO));
                if (parseLong > 0) {
                    ChatInfo.mUid = parseLong;
                }
            }
            eky();
        } catch (Exception e2) {
            LogUtils.e(MAFragmentActivity.TAG, "init appid error");
        }
        this.mListenerKey = String.valueOf(this.mPaid);
        hX(this.mPaid);
    }

    private void hX(long j2) {
        this.pdf.setVisibility(8);
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
                    ActivityChat.this.pdK.post(ActivityChat.this.pdO);
                }
            });
        } else {
            this.pdK.post(this.pdO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class h implements Runnable {
        private final SoftReference<ActivityChat> pec;

        private h(ActivityChat activityChat) {
            this.pec = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pec.get() != null) {
                try {
                    ChatInfo.pbZ = AccountManager.getUK(this.pec.get().getApplicationContext());
                    this.pec.get();
                    LogUtils.d(MAFragmentActivity.TAG, "parunnable ---> " + ChatInfo.pbZ);
                    if (ChatInfo.pbZ != -1) {
                        this.pec.get().mChatStatus = 0;
                        this.pec.get().ekv();
                        this.pec.get();
                        LogUtils.d(MAFragmentActivity.TAG, "parunnable -->1");
                        ChatInfo.mContacter = this.pec.get().mPaInfo.getPaId();
                        ChatInfo.mPainfo = this.pec.get().mPaInfo;
                        if (ChatInfo.pbX == ChatInfo.ChatCategory.DUZHAN) {
                            this.pec.get().knG = ChatMsgManager.getUnReadMsgCountByPaid(this.pec.get(), this.pec.get().mPaid);
                            if (this.pec.get().knG > 200) {
                                this.pec.get().knG = 200;
                            }
                        }
                        this.pec.get().Ux();
                        this.pec.get().v(this.pec.get().mPaid, true);
                    } else {
                        this.pec.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    this.pec.get().pdE = TextUtils.isEmpty(this.pec.get().pdE) ? this.pec.get().mPaInfo.getNickName() : this.pec.get().pdE;
                    this.pec.get().pde.setText(String.valueOf(this.pec.get().pdE));
                    this.pec.get().eks();
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekv() {
        com.baidu.yuyinala.privatemessage.implugin.d.b.eke().a(getActivity(), new IGetUsersProfileBatchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.18
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2) {
                if (i2 == 0 && arrayList2 != null && arrayList2.size() == 1) {
                    ChatInfo.pca = ActivityChat.this.YD(arrayList2.get(0).getIconUrl());
                    ChatInfo.displayname = arrayList2.get(0).getUserName();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekw() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.b(ExtraParamsManager.getEncryptionUserId(ChatInfo.mUid + "")));
    }

    private static void ekx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031061, com.baidu.live.a.axj + "ala/audio/user/preFollow");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void eky() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.a(ExtraParamsManager.getEncryptionUserId(this.mPaid + "")));
    }

    private void ekz() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031067, com.baidu.live.a.axj + "ala/audio/user/getPaBindInfo");
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
                        ActivityChat.this.ekw();
                    }
                }
            }
        });
    }

    public boolean ekA() {
        return this.pdC == 2 || this.pdC == 11;
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
        this.pdb = (RelativeLayout) findViewById(a.f.bd_im_chat_title_root);
        this.pdc = findViewById(a.f.bd_im_chat_cell_space_line);
        this.pdd = (TextView) findViewById(a.f.bd_im_chat_open_main);
        this.pdj = (LinearLayout) findViewById(a.f.bd_im_chat_open_main_click_parent);
        this.pdj.setOnClickListener(this.pdP);
        this.pdk = (RelativeLayout) findViewById(a.f.bd_im_chat_back_layout);
        this.pdk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.onBackClick();
            }
        });
        this.pde = (TextView) findViewById(a.f.bd_im_chat_title);
        this.pdf = (TextView) findViewById(a.f.bd_im_chat_subtitle);
        this.pdg = findViewById(a.f.bd_im_chat_main_input);
        this.pdh = (FrameLayout) findViewById(a.f.bd_im_chat_main_content);
        this.pdi = (FrameLayout) findViewById(a.f.bd_im_chat_main_input);
        this.pdl = (FrameLayout) findViewById(a.f.bd_im_chat_main_error_content);
        this.pdt = (ImageView) findViewById(a.f.bd_im_chat_main_error_image);
        this.pdl.setVisibility(8);
        this.pdm = (FrameLayout) findViewById(a.f.bd_im_chat_main_retry_content);
        this.pdm.setVisibility(8);
        findViewById(a.f.bd_im_chat_main_retry_button).setOnClickListener(this.pdN);
        this.pde.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.ekF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ux() {
        if (this.pdn == null) {
            FrameLayout frameLayout = this.pdh;
            this.pdh.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_chat, null));
            this.pdn = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.a(this, this.pdh, this.mListenerKey, this.pdJ, this.knG);
        }
        if (this.pdo == null) {
            FrameLayout frameLayout2 = this.pdi;
            this.pdi.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_input, null));
            this.pdo = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.a(this, this.pdi, this.mListenerKey, this.pdJ);
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "initFragment : ");
        if (!isFinishing()) {
            try {
                com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "mTransaction.commitAllowingStateLoss() : ");
            } catch (Exception e2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "e :" + e2);
                com.baidu.yuyinala.privatemessage.implugin.d.b.eke().c(this, e2);
            }
        }
        if (this.pdn != null) {
            this.pdn.a(this);
        }
        hZ(this.pdw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void ekB() {
        this.pdA = AnimationUtils.loadAnimation(this, a.C0201a.bd_im_fragment_in_from_bottom);
        this.pdB = AnimationUtils.loadAnimation(this, a.C0201a.bd_im_fragment_out_to_bottom);
    }

    private void hY(long j2) {
        if (j2 == 0) {
            this.pdu = null;
            showToast(a.h.bd_im_read_error);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j2));
        final SoftReference softReference = new SoftReference(this);
        com.baidu.yuyinala.privatemessage.implugin.d.b.eke().a(getApplicationContext(), arrayList, false, new b.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList2, ArrayList<ChatUser> arrayList3) {
                if (softReference.get() != null) {
                    if (i2 != 0) {
                        ((ActivityChat) softReference.get()).pdK.post(ActivityChat.this.pdT);
                        return;
                    }
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        ((ActivityChat) softReference.get()).pdu = arrayList3.get(0);
                    }
                    if (((ActivityChat) softReference.get()).pdu == null) {
                        ((ActivityChat) softReference.get()).pdK.post(ActivityChat.this.pdS);
                        return;
                    }
                    ArrayList<Long> arrayList4 = new ArrayList<>();
                    arrayList4.add(Long.valueOf(ActivityChat.this.pdu.getUk()));
                    com.baidu.yuyinala.privatemessage.implugin.d.b.eke().a(ActivityChat.this.getApplicationContext(), arrayList4, new b.InterfaceC0974b() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7.1
                        @Override // com.baidu.android.imsdk.chatuser.IGetUserStatusListener
                        public void onGetUsersStatusResult(int i3, String str2, ArrayList<UserStatus> arrayList5) {
                            if (i3 == 0 && arrayList5.size() == 1) {
                                ((ActivityChat) softReference.get()).pdF = arrayList5.get(0);
                                ((ActivityChat) softReference.get()).pdK.post(ActivityChat.this.pdQ);
                            }
                        }
                    });
                    ((ActivityChat) softReference.get()).pdK.post(ActivityChat.this.pdR);
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
                            ActivityChat.this.pdK.sendEmptyMessageDelayed(7, 1000L);
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
            com.baidu.yuyinala.privatemessage.implugin.e.a.hA(getApplicationContext()).hh("542", "chat_flow_time");
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
        }
    }

    protected void hZ(long j2) {
    }

    protected void ekC() {
    }

    public ImBaseEntity ekD() {
        return this.pdH;
    }

    protected void ekE() {
    }

    protected void YB(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.pde.setText(str);
        } else if (this.mNickName != null) {
            this.pde.setText(String.valueOf(this.mNickName));
        } else if (this.pdu != null) {
            this.pde.setText(String.valueOf(this.pdu.getUserName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekF() {
        String liveId = getLiveId();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getActivity(), ChatInfo.mUid + "", null, null, null, 0, 0, null, null, 0L, 0L, 0L, 0, getGroupId(), liveId, false, null, null, null, null, null)));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
    }

    /* loaded from: classes10.dex */
    private static class l implements Runnable {
        private final SoftReference<ActivityChat> peb;

        private l(ActivityChat activityChat) {
            this.peb = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes10.dex */
    private static class k implements Runnable {
        private final SoftReference<ActivityChat> peb;

        private k(ActivityChat activityChat) {
            this.peb = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.peb.get() != null) {
                try {
                    ChatInfo.pbZ = AccountManager.getUK(this.peb.get().getApplicationContext());
                    if (ChatInfo.pbZ != -1) {
                        this.peb.get().mChatStatus = 0;
                        this.peb.get().ekG();
                        this.peb.get().Ux();
                        this.peb.get().ia(this.peb.get().pdw);
                    } else {
                        this.peb.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    if (this.peb.get().mNickName == null) {
                        if (this.peb.get().pdu != null) {
                            this.peb.get().pde.setText(String.valueOf(this.peb.get().pdu.getUserName()));
                            return;
                        }
                        return;
                    }
                    this.peb.get().pde.setText(String.valueOf(this.peb.get().mNickName));
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(long j2) {
        if (YC(String.valueOf(j2))) {
        }
    }

    private boolean YC(String str) {
        String A = com.baidu.yuyinala.privatemessage.implugin.util.c.b.A(getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pkp, null);
        boolean z = false;
        if (!TextUtils.isEmpty(A)) {
            try {
                JSONObject jSONObject = new JSONObject(A);
                if (jSONObject.has(str)) {
                    z = jSONObject.getBoolean(str);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        LogUtils.i(MAFragmentActivity.TAG, "is support IM:" + z + " data:" + A);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekG() {
        ekv();
        ChatInfo.mContacter = this.pdu.getUk();
        ChatInfo.mUid = this.pdu.getBuid();
        ChatInfo.mStatus = 3;
        ChatInfo.pbY = this.pdu.getUserName();
        if (!TextUtils.isEmpty(this.mIcon)) {
            ChatInfo.pcb = this.mIcon;
        } else {
            ChatInfo.pcb = YD(this.pdu.getIconUrl());
        }
        BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
        LogUtils.i(MAFragmentActivity.TAG, "uk:" + ChatInfo.pbZ);
        LogUtils.i(MAFragmentActivity.TAG, "header:" + ChatInfo.pca);
        LogUtils.i(MAFragmentActivity.TAG, "" + this.pdu.toString());
    }

    /* loaded from: classes10.dex */
    private static class j implements Runnable {
        private final SoftReference<ActivityChat> peb;

        private j(ActivityChat activityChat) {
            this.peb = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.peb.get() != null) {
                try {
                    ChatInfo.pbZ = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().hw(this.peb.get().getApplicationContext()).longValue();
                    this.peb.get().mChatStatus = 0;
                    this.peb.get().Ux();
                    if (this.peb.get().mNickName != null) {
                        this.peb.get().pde.setText(String.valueOf(this.peb.get().mNickName));
                    }
                    this.peb.get().pdK.sendEmptyMessage(1);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        private final SoftReference<ActivityChat> peb;

        private a(ActivityChat activityChat) {
            this.peb = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.peb.get() != null) {
                try {
                    ChatInfo.pbZ = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().hw(this.peb.get().getApplicationContext()).longValue();
                    this.peb.get().mChatStatus = 1;
                    this.peb.get().Ux();
                    if (this.peb.get().mNickName != null) {
                        this.peb.get().pde.setText(String.valueOf(this.peb.get().mNickName));
                    }
                    this.peb.get().pdK.sendEmptyMessage(1006);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class b implements Runnable {
        private final SoftReference<ActivityChat> peb;

        private b(ActivityChat activityChat) {
            this.peb = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.peb.get() != null) {
                try {
                    ChatInfo.pbZ = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().hw(this.peb.get().getApplicationContext()).longValue();
                    String str = null;
                    if (this.peb.get().pdv != null) {
                        str = this.peb.get().pdv.mInfo.getGroupName();
                    }
                    if (ChatInfo.pcc == 2) {
                        if (str == null || "".equals(str.trim())) {
                            if (this.peb.get().mNickName != null) {
                                this.peb.get().pde.setText(String.valueOf(this.peb.get().mNickName));
                                return;
                            } else if (this.peb.get().pdv != null) {
                                this.peb.get().pde.setText(String.valueOf(str));
                                return;
                            } else {
                                return;
                            }
                        }
                        this.peb.get().pde.setText(String.valueOf(str));
                    } else if (!TextUtils.isEmpty(str)) {
                        this.peb.get().pde.setText(String.valueOf(str));
                        this.peb.get().pdf.setText(this.peb.get().pdv.mInfo.getNum() + "人");
                    } else if (!TextUtils.isEmpty(this.peb.get().mNickName)) {
                        this.peb.get().pde.setText(String.valueOf(this.peb.get().mNickName));
                        this.peb.get().pdf.setText(this.peb.get().pdv.mInfo.getNum() + "人");
                    } else if (this.peb.get().pdv != null) {
                        this.peb.get().pde.setText("未知群");
                        this.peb.get().pdf.setText(this.peb.get().pdv.mInfo.getNum() + "人");
                    }
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class d implements Runnable {
        private final SoftReference<ActivityChat> peb;

        private d(ActivityChat activityChat) {
            this.peb = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.peb.get() != null) {
                try {
                    this.peb.get().pdg.setVisibility(0);
                    this.peb.get().pdg.startAnimation(this.peb.get().pdA);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class e implements Runnable {
        private final SoftReference<ActivityChat> peb;

        private e(ActivityChat activityChat) {
            this.peb = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.peb.get() != null) {
                try {
                    this.peb.get().pdg.setVisibility(8);
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
                ActivityChat.this.pdK.sendMessage(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NI(int i2) {
        String str;
        Date date;
        long j2 = -1;
        if (i2 == 1) {
            str = com.baidu.yuyinala.privatemessage.implugin.f.j.getType();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.baidu.yuyinala.privatemessage.implugin.f.j.eki())) {
                try {
                    j2 = Long.parseLong(com.baidu.yuyinala.privatemessage.implugin.f.j.eki());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.c.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pku + ChatInfo.mPaid + ChatInfo.pbZ, 0L));
            } else {
                return;
            }
        } else if (i2 == 0) {
            str = "ugc";
            j2 = this.pdw;
            date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.c.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pkv + this.pdw, 0L));
        } else {
            str = null;
            date = null;
        }
        if (!com.baidu.yuyinala.privatemessage.implugin.util.f.c(date, new Date())) {
            if ((this.pdG == null || !this.pdG.elH() || this.pdG.elI() != i2) && this.pdn != null) {
                this.pdG = this.pdn.ao(i2, ekA());
                if (this.pdG != null) {
                    try {
                        this.pdG.c(str, j2, new g(this, i2));
                    } catch (NumberFormatException e3) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, e3.getMessage());
                    }
                    com.baidu.yuyinala.privatemessage.implugin.e.a.hA(getApplicationContext()).add("416", "subscribe_show");
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
                    activityChat.ekl().sendMessage(message);
                } else if (this.flag == 0) {
                    Message message2 = new Message();
                    if (z) {
                        message2.arg1 = 0;
                    } else {
                        message2.arg1 = -1;
                    }
                    message2.what = 8;
                    activityChat.ekl().sendMessage(message2);
                }
            }
        }
    }

    public void onBackClick() {
        if (this.mChatStatus == 0) {
            if (this.pdo != null) {
                this.pdo.eln();
            }
            if (this.pdG != null) {
                this.pdG.elG();
            }
        }
        finish();
        if (!ChatInfo.pcj) {
            com.baidu.yuyinala.privatemessage.implugin.d.b.eke().hz(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String YD(String str) {
        return str;
    }
}
