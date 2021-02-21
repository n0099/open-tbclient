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
    public static boolean pbs;
    protected String aTp;
    protected boolean isFollowed;
    private LinearLayout mContainer;
    private String mGroupId;
    private String mIcon;
    private String mLiveId;
    private String mNickName;
    private PaInfo mPaInfo;
    public long mPaid;
    private RelativeLayout paV;
    private View paW;
    private TextView paX;
    private TextView paY;
    private TextView paZ;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c pbA;
    protected ImBaseEntity pbB;
    private com.baidu.yuyinala.privatemessage.implugin.ui.a.a pbC;
    private long pbF;
    private View pba;
    private FrameLayout pbb;
    private FrameLayout pbc;
    private LinearLayout pbd;
    private RelativeLayout pbe;
    private FrameLayout pbf;
    private FrameLayout pbg;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a pbh;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b pbi;
    private LinearLayout pbj;
    private TextView pbk;
    private ImageView pbl;
    private ImageView pbm;
    private ImageView pbn;
    private ChatUser pbo;
    protected QMGroupInfo pbp;
    protected long pbq;
    public boolean pbr;
    private Animation pbu;
    private Animation pbv;
    private String pby;
    private UserStatus pbz;
    private int klE = 0;
    public boolean pbt = false;
    private int mChatStatus = 1;
    private String mListenerKey = "";
    private int pbw = -1;
    private long pbx = -1;
    private c pbD = new c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.1
        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.c
        public void ekx() {
            ActivityChat.this.pbE.sendEmptyMessage(1002);
        }
    };
    private f pbE = new f();
    private boolean pbG = false;
    private View.OnClickListener pbH = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().getLoginState(ActivityChat.this);
            ActivityChat.this.pbF = System.currentTimeMillis();
            ActivityChat.this.pbG = false;
            if (loginState == 3) {
                ActivityChat.this.pbE.removeCallbacks(ActivityChat.this.gdh);
                ActivityChat.this.pbE.postDelayed(ActivityChat.this.gdh, ActivityChat.this.ekd());
                ActivityChat.this.pbg.setVisibility(8);
                ActivityChat.this.init(ActivityChat.this.getIntent());
                return;
            }
            ActivityChat.this.pbE.postDelayed(ActivityChat.this.gdh, 7000L);
            ActivityChat.this.eke();
        }
    };
    private Runnable gdh = new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mTimeOutRunnable run ");
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().getLoginState(ActivityChat.this) != 3) {
                ActivityChat.this.pbG = true;
                ActivityChat.this.ekf();
                return;
            }
            ActivityChat.this.ekg();
        }
    };
    private h pbI = new h();
    private View.OnClickListener pbJ = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChat.this.eks();
            if (ActivityChat.this.mChatStatus == 0 && ActivityChat.this.pbi != null) {
                ActivityChat.this.pbi.eld();
            }
        }
    };
    private l pbK = new l();
    private k pbL = new k();
    private j pbM = new j();
    private a pbN = new a();
    private b pbO = new b();
    d pbP = new d();
    e pbQ = new e();

    /* loaded from: classes11.dex */
    public interface c {
        void ekx();
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
    public void Yt(String str) {
        if ("greet_link".equals(str)) {
            String ekC = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.ekC();
            String str2 = "";
            if (!TextUtils.isEmpty(ChatInfo.nickname)) {
                str2 = ChatInfo.nickname;
            } else if (!TextUtils.isEmpty(ChatInfo.displayname)) {
                str2 = ChatInfo.displayname;
            }
            com.baidu.yuyinala.privatemessage.model.message.a.emK().C(this, ekC.replace("XXX", str2), this.mListenerKey);
        } else if ("welcom_link".equals(str)) {
            com.baidu.yuyinala.privatemessage.model.message.a.emK().C(this, com.baidu.yuyinala.privatemessage.implugin.ui.common.b.ekD(), this.mListenerKey);
        }
    }

    public f ekb() {
        return this.pbE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class f extends Handler {
        private final SoftReference<ActivityChat> pbV;

        private f(ActivityChat activityChat) {
            this.pbV = new SoftReference<>(activityChat);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = null;
            int i = 0;
            boolean z = false;
            super.handleMessage(message);
            if (this.pbV.get() != null) {
                try {
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.pbV.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "current is no support");
                        this.pbV.get().pbd.setVisibility(4);
                        ChatInfo.mStatus = 10;
                        if (this.pbV.get().pbi != null) {
                            this.pbV.get().pbi.ekX();
                        }
                        if (this.pbV.get().pbh != null) {
                            this.pbV.get().pbh.ekX();
                            return;
                        }
                        return;
                    case 2:
                        if (message.arg1 == 1) {
                            com.baidu.yuyinala.privatemessage.implugin.f.j.AK(true);
                            postDelayed(new i(this.pbV), 1000L);
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elz().bv(this.pbV.get().getApplicationContext(), this.pbV.get().getString(a.h.bd_im_zhida_success_tip));
                            if (this.pbV.get().pbA != null) {
                                this.pbV.get().pbA.dismiss();
                            }
                            String ejY = com.baidu.yuyinala.privatemessage.implugin.f.j.ejY();
                            if (!TextUtils.isEmpty(ejY)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("sign", "media_" + ejY);
                                    jSONObject.put("relation", 1);
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().z(this.pbV.get().getApplicationContext(), "com.baidu.channel.subscribe", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
                                    return;
                                } catch (UnsupportedEncodingException e2) {
                                    e2.printStackTrace();
                                    return;
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            this.pbV.get();
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
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elz().bu(this.pbV.get().getApplicationContext(), str);
                            return;
                        } else {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elz().bu(this.pbV.get().getApplicationContext(), this.pbV.get().getString(a.h.bd_im_subscribe_fail_tip));
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                        return;
                    case 3:
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elz().showToast(this.pbV.get().getApplicationContext(), this.pbV.get().getString(a.h.bd_im_zhida_fail_net_tip));
                        return;
                    case 5:
                        this.pbV.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 1 ");
                        this.pbV.get().finish();
                        this.pbV.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 2 ");
                        return;
                    case 6:
                        Bundle data = message.getData();
                        String str2 = "";
                        if (data != null) {
                            str2 = data.getString("subscribe_data");
                            z = data.getBoolean("update_subscribe", false);
                        }
                        com.baidu.yuyinala.privatemessage.implugin.f.j.Yq(str2);
                        ChatInfo.mPainfo.setMsgNotify(com.baidu.yuyinala.privatemessage.implugin.f.j.isNeedNotify());
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.ejZ() || !z) {
                            if (this.pbV.get().pbA != null && this.pbV.get().pbA.elx()) {
                                this.pbV.get().pbA.dismiss();
                            }
                        } else {
                            this.pbV.get().NE(1);
                        }
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.getData() != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.b.B(this.pbV.get().getApplicationContext(), String.valueOf(this.pbV.get().mPaid), com.baidu.yuyinala.privatemessage.implugin.f.j.getData().toString());
                            return;
                        }
                        return;
                    case 7:
                        this.pbV.get().NE(0);
                        return;
                    case 8:
                        if (message.arg1 == 0) {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elz().bu(this.pbV.get(), "关注成功");
                            this.pbV.get().pbA.dismiss();
                            this.pbV.get().eku();
                            this.pbV.get().isFollowed = true;
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elz().bu(this.pbV.get(), "关注失败");
                        return;
                    case 1001:
                        if (this.pbV.get().pbj != null && this.pbV.get().pbj.getVisibility() == 0) {
                            this.pbV.get().pbj.setAnimation(AnimationUtils.loadAnimation(this.pbV.get(), a.C0195a.bd_im_slip_out_from_right));
                            this.pbV.get().pbj.setVisibility(4);
                            return;
                        }
                        return;
                    case 1002:
                        this.pbV.get().ekj();
                        return;
                    case 1003:
                        if (this.pbV.get().pbl != null && this.pbV.get().pbl.getVisibility() == 0) {
                            this.pbV.get().pbl.setAnimation(AnimationUtils.loadAnimation(this.pbV.get(), a.C0195a.bd_im_disappear_out));
                            this.pbV.get().pbl.setVisibility(4);
                            return;
                        }
                        return;
                    case 1006:
                        this.pbV.get().pbd.setVisibility(4);
                        ChatInfo.mStatus = 11;
                        if (this.pbV.get().pbi != null) {
                            this.pbV.get().pbi.ekX();
                        }
                        this.pbV.get().pbf.setVisibility(0);
                        return;
                    case 1007:
                    case 1008:
                        return;
                    case 1009:
                        if (this.pbV.get().pbh != null) {
                            this.pbV.get().pbh.AN(false);
                        }
                        this.pbV.get().pbg.setVisibility(8);
                        this.pbV.get().init(this.pbV.get().getIntent());
                        return;
                    case 1010:
                        if (this.pbV.get().pbh != null) {
                            this.pbV.get().pbh.AN(true);
                        }
                        if (this.pbV.get().pbi != null) {
                            this.pbV.get().pbi.ekX();
                            return;
                        }
                        return;
                    case 1011:
                        this.pbV.get().pbd.setVisibility(4);
                        ChatInfo.mStatus = 12;
                        if (this.pbV.get().pbi != null) {
                            this.pbV.get().pbi.ekX();
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
        private final SoftReference<ActivityChat> pbV;

        private i(SoftReference<ActivityChat> softReference) {
            this.pbV = softReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbV.get() != null) {
                this.pbV.get().v(this.pbV.get().mPaid, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BIMManager.mediaSetRole(getActivity(), true);
        ekp();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        setContentView(a.g.bd_im_chat_activity_layout);
        this.mContainer = (LinearLayout) findViewById(a.f.bd_im_chat_root);
        this.pbC = new com.baidu.yuyinala.privatemessage.implugin.ui.a.a();
        ekr();
        init(getIntent());
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().isCuidLogin(this) || com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().ejV()) {
            this.pbt = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    private void ekc() {
        this.pbF = System.currentTimeMillis();
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "loginOver loginState: " + loginState);
        if (this.pbh != null) {
            this.pbh.ekY();
        }
        switch (loginState) {
            case 2:
                this.pbE.postDelayed(this.gdh, 7000L);
                eke();
                return;
            case 3:
                this.pbE.postDelayed(this.gdh, ekd());
                this.pbg.setVisibility(8);
                this.pbE.sendEmptyMessage(1009);
                return;
            default:
                this.pbE.postDelayed(this.gdh, 7000L);
                ekh();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ekd() {
        long currentTimeMillis = 10000 - (System.currentTimeMillis() - this.pbF);
        if (currentTimeMillis > 7000) {
            return 7000L;
        }
        return currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eke() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "retryLogin timeout " + this.pbG);
        if (!this.pbG) {
            this.pbE.sendEmptyMessage(1010);
            com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().a(this, new b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.13
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
    public void ekf() {
        if (this.pbh != null) {
            this.pbh.AN(false);
        }
        if (this.pbi != null) {
            this.pbi.ekX();
        }
        this.pbg.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekg() {
        if (this.pbh != null) {
            this.pbh.AN(false);
        }
    }

    private void ekh() {
        this.pbE.sendEmptyMessage(1010);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus ");
        com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().a(this, new b.e() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.14
            @Override // com.baidu.android.imsdk.account.ILoginStateChangedListener
            public void onLoginStateChanged(int i2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus onLoginStateChanged state: " + i2);
                switch (i2) {
                    case 2:
                        ActivityChat.this.eke();
                        return;
                    case 3:
                        ActivityChat.this.pbE.removeCallbacks(ActivityChat.this.gdh);
                        ActivityChat.this.pbE.postDelayed(ActivityChat.this.gdh, ActivityChat.this.ekd());
                        ActivityChat.this.pbE.sendEmptyMessage(1009);
                        return;
                    default:
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "waitting");
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eki() {
        if (this.klE > 8) {
            if (this.pbj == null) {
                this.pbj = (LinearLayout) findViewById(a.f.bd_im_chat_unread_msgs_layout);
                this.pbk = (TextView) findViewById(a.f.bd_im_chat_unread_msgs_txt);
                this.pbk.setText(this.klE + getString(a.h.bd_im_alert_unread_msgs));
            }
            this.pbm = (ImageView) findViewById(a.f.bd_im_chat_unread_msgs_up);
            try {
                this.pbj.setBackgroundResource(ThemeManager.U(this, a.e.bd_im_chat_unread_msgs_background));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.pbj.setAnimation(AnimationUtils.loadAnimation(this, a.C0195a.bd_im_slip_in_from_right));
            this.pbj.setVisibility(0);
            this.pbj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.pbh.NF(ActivityChat.this.klE);
                    ActivityChat.this.pbj.setAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0195a.bd_im_slip_out_from_right));
                    ActivityChat.this.pbj.setVisibility(4);
                }
            });
            this.pbE.sendEmptyMessageDelayed(1001, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekj() {
        if (this.pbl == null) {
            this.pbl = (ImageView) findViewById(a.f.bd_im_chat_new_msgs_tip);
            this.pbl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.pbh.ekN();
                    ActivityChat.this.pbl.startAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0195a.bd_im_disappear_out));
                    ActivityChat.this.pbl.setVisibility(4);
                }
            });
        }
        if (this.pbl.getVisibility() != 0) {
            this.pbl.startAnimation(AnimationUtils.loadAnimation(this, a.C0195a.bd_im_disappear_in));
            this.pbl.setVisibility(0);
        }
        this.pbE.removeMessages(1003);
        this.pbE.sendEmptyMessageDelayed(1003, 10000L);
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
        switch (ChatInfo.oZQ) {
            case GROUP:
                com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().setAllMsgRead(getApplicationContext(), 1, ChatInfo.mContacter, false);
                break;
            default:
                BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
                break;
        }
        try {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.elp();
            com.baidu.yuyinala.privatemessage.implugin.imagechooser.a.ejS();
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().c(this, th);
        }
        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elz().dismiss();
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mChatCategory " + ChatInfo.oZQ + " mOnlineStatus " + this.pbz);
        if (ChatInfo.oZQ == ChatInfo.ChatCategory.C2C && this.pbz != null) {
            ekk();
        }
        if (this.pbh != null) {
            this.pbh.a((com.baidu.yuyinala.privatemessage.implugin.ui.activity.a) null);
        }
        if (this.pbi != null) {
            this.pbi.onDestroy();
        }
        if (this.pbh != null) {
            this.pbh.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i2) {
    }

    private void ekk() {
        Intent intent = new Intent(IMConstants.NOTICE_USER_STATE);
        intent.putExtra(IMConstants.NOTICE_USER_STATE_OBJECT, this.pbz);
        sendBroadcast(intent);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "noticeSessionState com.baidu.android.imsdk.notice.userstate");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onResume--->");
        super.onResume();
        com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().AJ(true);
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onResume mIsCuidOrIncompleteLogin: " + this.pbt + " loginState: " + loginState);
        if (this.pbt && (!com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().isCuidLogin(this) || !com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().ejV() || (loginState != 0 && loginState != 3))) {
            ekc();
        } else if (this.pbA != null && this.pbA.elx() && ChatInfo.ChatCategory.DUZHAN == ChatInfo.oZQ) {
            v(this.mPaid, true);
        }
        if (this.pbi != null) {
            this.pbi.onResume();
        }
        if (this.pbh != null) {
            this.pbh.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStop--->");
        super.onStop();
        if (this.pbi != null) {
            this.pbi.onStop();
        }
        if (this.pbh != null) {
            this.pbh.onStop();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStop");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStart--->");
        super.onStart();
        if (this.pbi != null) {
            this.pbi.onStart();
        }
        if (this.pbh != null) {
            this.pbh.onStart();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStart");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onPause--->");
        super.onPause();
        com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().AJ(false);
        if (this.pbi != null) {
            this.pbi.onPause();
        }
        if (this.pbh != null) {
            this.pbh.onPause();
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
            this.aTp = ExtraParamsManager.getEncryptionUserId(extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phG));
            this.pbr = extras.getBoolean("isMediaRole");
            this.mGroupId = extras.getString("groupid");
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("miliao", "mIsmediaRole：" + this.pbr);
            this.mLiveId = extras.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            pbs = this.pbr;
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.phG, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phG));
            jSONObject.put("paid", extras.getString("paid"));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.phI, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phI));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.phK, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phK));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.phJ, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phJ));
            String jSONObject2 = jSONObject.toString();
            try {
                if (!TextUtils.isEmpty(extras.getString("action"))) {
                    Serializable serializable = extras.getSerializable("params");
                    if (serializable instanceof ImBaseEntity) {
                        this.pbB = (ImBaseEntity) serializable;
                        if (this.pbp == null) {
                            GroupInfo groupInfo = new GroupInfo(String.valueOf(this.pbB.id));
                            groupInfo.setGroupName(this.pbB.name);
                            groupInfo.setDescription(this.pbB.description);
                            groupInfo.setHeadUrl(this.pbB.headUrl);
                            this.pbp = new QMGroupInfo(groupInfo);
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
        ekn();
        String aw = aw(intent);
        if (this.pbd != null) {
            if (this.pbr) {
                this.pbd.setVisibility(8);
            } else {
                this.pbd.setVisibility(0);
            }
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + aw);
        ChatInfo.mContacter = -1L;
        ChatInfo.oZS = -1L;
        ChatInfo.mAppid = -1L;
        ChatInfo.mUid = -1L;
        ChatInfo.oZT = "";
        ChatInfo.oZU = "";
        ChatInfo.oZV = -1;
        ChatInfo.oZZ = 0;
        ChatInfo.pac = true;
        ChatInfo.pab = false;
        try {
            JSONObject jSONObject = new JSONObject(aw);
            int i2 = jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.phJ) ? jSONObject.getInt(com.baidu.yuyinala.privatemessage.implugin.util.d.phJ) : -1;
            if (i2 == -1) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "invoke error -1");
                return;
            }
            if (i2 == 80) {
                parseLong = Long.parseLong(jSONObject.optString("paid", "-1"));
            } else {
                parseLong = Long.parseLong(jSONObject.optString(com.baidu.yuyinala.privatemessage.implugin.util.d.phG, "-1"));
            }
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + aw);
            if (this.pbw != -1 && (this.pbw != i2 || this.pbx != parseLong)) {
                if (this.pbh != null) {
                    this.pbh.ekY();
                }
                if (this.paY != null) {
                    this.paY.setText("");
                }
            }
            this.pbw = i2;
            switch (i2) {
                case 0:
                    ChatInfo.oZQ = ChatInfo.ChatCategory.C2C;
                    try {
                        this.pbq = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phG));
                        ChatInfo.mUid = this.pbq;
                        ekm();
                        this.mNickName = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phI);
                        this.mIcon = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phK);
                        if (jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.phM)) {
                            ChatInfo.pac = jSONObject.getBoolean(com.baidu.yuyinala.privatemessage.implugin.util.d.phM);
                        }
                    } catch (Exception e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "init uid and name error");
                    }
                    this.paZ.setVisibility(8);
                    this.mListenerKey = String.valueOf(this.pbq);
                    Yu(this.mNickName);
                    hY(this.pbq);
                    return;
                case 80:
                    ChatInfo.oZQ = ChatInfo.ChatCategory.DUZHAN;
                    eQ(jSONObject);
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
            com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().c(this, e3);
        }
    }

    private void eQ(JSONObject jSONObject) {
        try {
            this.mPaid = Long.parseLong(jSONObject.getString("paid"));
            ChatInfo.mPaid = this.mPaid;
            if (this.pbr) {
                long parseLong = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phG));
                if (parseLong > 0) {
                    ChatInfo.mUid = parseLong;
                }
            }
            eko();
        } catch (Exception e2) {
            LogUtils.e(MAFragmentActivity.TAG, "init appid error");
        }
        this.mListenerKey = String.valueOf(this.mPaid);
        hX(this.mPaid);
    }

    private void hX(long j2) {
        this.paZ.setVisibility(8);
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
                    ActivityChat.this.pbE.post(ActivityChat.this.pbI);
                }
            });
        } else {
            this.pbE.post(this.pbI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class h implements Runnable {
        private final SoftReference<ActivityChat> pbW;

        private h(ActivityChat activityChat) {
            this.pbW = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbW.get() != null) {
                try {
                    ChatInfo.oZS = AccountManager.getUK(this.pbW.get().getApplicationContext());
                    this.pbW.get();
                    LogUtils.d(MAFragmentActivity.TAG, "parunnable ---> " + ChatInfo.oZS);
                    if (ChatInfo.oZS != -1) {
                        this.pbW.get().mChatStatus = 0;
                        this.pbW.get().ekl();
                        this.pbW.get();
                        LogUtils.d(MAFragmentActivity.TAG, "parunnable -->1");
                        ChatInfo.mContacter = this.pbW.get().mPaInfo.getPaId();
                        ChatInfo.mPainfo = this.pbW.get().mPaInfo;
                        if (ChatInfo.oZQ == ChatInfo.ChatCategory.DUZHAN) {
                            this.pbW.get().klE = ChatMsgManager.getUnReadMsgCountByPaid(this.pbW.get(), this.pbW.get().mPaid);
                            if (this.pbW.get().klE > 200) {
                                this.pbW.get().klE = 200;
                            }
                        }
                        this.pbW.get().Uu();
                        this.pbW.get().v(this.pbW.get().mPaid, true);
                    } else {
                        this.pbW.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    this.pbW.get().pby = TextUtils.isEmpty(this.pbW.get().pby) ? this.pbW.get().mPaInfo.getNickName() : this.pbW.get().pby;
                    this.pbW.get().paY.setText(String.valueOf(this.pbW.get().pby));
                    this.pbW.get().eki();
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekl() {
        com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().a(getActivity(), new IGetUsersProfileBatchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.18
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2) {
                if (i2 == 0 && arrayList2 != null && arrayList2.size() == 1) {
                    ChatInfo.oZT = ActivityChat.this.Yw(arrayList2.get(0).getIconUrl());
                    ChatInfo.displayname = arrayList2.get(0).getUserName();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekm() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.b(ExtraParamsManager.getEncryptionUserId(ChatInfo.mUid + "")));
    }

    private static void ekn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031061, com.baidu.live.a.avJ + "ala/audio/user/preFollow");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void eko() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.a(ExtraParamsManager.getEncryptionUserId(this.mPaid + "")));
    }

    private void ekp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031067, com.baidu.live.a.avJ + "ala/audio/user/getPaBindInfo");
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
                        ActivityChat.this.ekm();
                    }
                }
            }
        });
    }

    public boolean ekq() {
        return this.pbw == 2 || this.pbw == 11;
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
        this.paV = (RelativeLayout) findViewById(a.f.bd_im_chat_title_root);
        this.paW = findViewById(a.f.bd_im_chat_cell_space_line);
        this.paX = (TextView) findViewById(a.f.bd_im_chat_open_main);
        this.pbd = (LinearLayout) findViewById(a.f.bd_im_chat_open_main_click_parent);
        this.pbd.setOnClickListener(this.pbJ);
        this.pbe = (RelativeLayout) findViewById(a.f.bd_im_chat_back_layout);
        this.pbe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.onBackClick();
            }
        });
        this.paY = (TextView) findViewById(a.f.bd_im_chat_title);
        this.paZ = (TextView) findViewById(a.f.bd_im_chat_subtitle);
        this.pba = findViewById(a.f.bd_im_chat_main_input);
        this.pbb = (FrameLayout) findViewById(a.f.bd_im_chat_main_content);
        this.pbc = (FrameLayout) findViewById(a.f.bd_im_chat_main_input);
        this.pbf = (FrameLayout) findViewById(a.f.bd_im_chat_main_error_content);
        this.pbn = (ImageView) findViewById(a.f.bd_im_chat_main_error_image);
        this.pbf.setVisibility(8);
        this.pbg = (FrameLayout) findViewById(a.f.bd_im_chat_main_retry_content);
        this.pbg.setVisibility(8);
        findViewById(a.f.bd_im_chat_main_retry_button).setOnClickListener(this.pbH);
        this.paY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.ekv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uu() {
        if (this.pbh == null) {
            FrameLayout frameLayout = this.pbb;
            this.pbb.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_chat, null));
            this.pbh = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.a(this, this.pbb, this.mListenerKey, this.pbD, this.klE);
        }
        if (this.pbi == null) {
            FrameLayout frameLayout2 = this.pbc;
            this.pbc.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_input, null));
            this.pbi = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.a(this, this.pbc, this.mListenerKey, this.pbD);
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "initFragment : ");
        if (!isFinishing()) {
            try {
                com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "mTransaction.commitAllowingStateLoss() : ");
            } catch (Exception e2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "e :" + e2);
                com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().c(this, e2);
            }
        }
        if (this.pbh != null) {
            this.pbh.a(this);
        }
        hZ(this.pbq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void ekr() {
        this.pbu = AnimationUtils.loadAnimation(this, a.C0195a.bd_im_fragment_in_from_bottom);
        this.pbv = AnimationUtils.loadAnimation(this, a.C0195a.bd_im_fragment_out_to_bottom);
    }

    private void hY(long j2) {
        if (j2 == 0) {
            this.pbo = null;
            showToast(a.h.bd_im_read_error);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j2));
        final SoftReference softReference = new SoftReference(this);
        com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().a(getApplicationContext(), arrayList, false, new b.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList2, ArrayList<ChatUser> arrayList3) {
                if (softReference.get() != null) {
                    if (i2 != 0) {
                        ((ActivityChat) softReference.get()).pbE.post(ActivityChat.this.pbN);
                        return;
                    }
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        ((ActivityChat) softReference.get()).pbo = arrayList3.get(0);
                    }
                    if (((ActivityChat) softReference.get()).pbo == null) {
                        ((ActivityChat) softReference.get()).pbE.post(ActivityChat.this.pbM);
                        return;
                    }
                    ArrayList<Long> arrayList4 = new ArrayList<>();
                    arrayList4.add(Long.valueOf(ActivityChat.this.pbo.getUk()));
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().a(ActivityChat.this.getApplicationContext(), arrayList4, new b.InterfaceC0968b() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7.1
                        @Override // com.baidu.android.imsdk.chatuser.IGetUserStatusListener
                        public void onGetUsersStatusResult(int i3, String str2, ArrayList<UserStatus> arrayList5) {
                            if (i3 == 0 && arrayList5.size() == 1) {
                                ((ActivityChat) softReference.get()).pbz = arrayList5.get(0);
                                ((ActivityChat) softReference.get()).pbE.post(ActivityChat.this.pbK);
                            }
                        }
                    });
                    ((ActivityChat) softReference.get()).pbE.post(ActivityChat.this.pbL);
                }
            }
        });
        com.baidu.yuyinala.privatemessage.implugin.f.k.hC(getApplicationContext()).b(j2, new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.8
            @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
            public void d(int i2, String str, long j3) {
                try {
                    LogUtils.d(MAFragmentActivity.TAG, "getUserSubscribe->" + str);
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1) == 0) {
                        JSONArray jSONArray = jSONObject.optJSONObject("data").getJSONArray("items");
                        if (jSONArray == null || jSONArray.length() < 1) {
                            ActivityChat.this.pbE.sendEmptyMessageDelayed(7, 1000L);
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
            com.baidu.yuyinala.privatemessage.implugin.e.a.hB(getApplicationContext()).hh("542", "chat_flow_time");
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
        }
    }

    protected void hZ(long j2) {
    }

    protected void eks() {
    }

    public ImBaseEntity ekt() {
        return this.pbB;
    }

    protected void eku() {
    }

    protected void Yu(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.paY.setText(str);
        } else if (this.mNickName != null) {
            this.paY.setText(String.valueOf(this.mNickName));
        } else if (this.pbo != null) {
            this.paY.setText(String.valueOf(this.pbo.getUserName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekv() {
        String liveId = getLiveId();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getActivity(), ChatInfo.mUid + "", null, null, null, 0, 0, null, null, 0L, 0L, 0L, 0, getGroupId(), liveId, false, null, null, null, null, null)));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
    }

    /* loaded from: classes11.dex */
    private static class l implements Runnable {
        private final SoftReference<ActivityChat> pbV;

        private l(ActivityChat activityChat) {
            this.pbV = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes11.dex */
    private static class k implements Runnable {
        private final SoftReference<ActivityChat> pbV;

        private k(ActivityChat activityChat) {
            this.pbV = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbV.get() != null) {
                try {
                    ChatInfo.oZS = AccountManager.getUK(this.pbV.get().getApplicationContext());
                    if (ChatInfo.oZS != -1) {
                        this.pbV.get().mChatStatus = 0;
                        this.pbV.get().ekw();
                        this.pbV.get().Uu();
                        this.pbV.get().ia(this.pbV.get().pbq);
                    } else {
                        this.pbV.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    if (this.pbV.get().mNickName == null) {
                        if (this.pbV.get().pbo != null) {
                            this.pbV.get().paY.setText(String.valueOf(this.pbV.get().pbo.getUserName()));
                            return;
                        }
                        return;
                    }
                    this.pbV.get().paY.setText(String.valueOf(this.pbV.get().mNickName));
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(long j2) {
        if (Yv(String.valueOf(j2))) {
        }
    }

    private boolean Yv(String str) {
        String A = com.baidu.yuyinala.privatemessage.implugin.util.c.b.A(getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pii, null);
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
    public void ekw() {
        ekl();
        ChatInfo.mContacter = this.pbo.getUk();
        ChatInfo.mUid = this.pbo.getBuid();
        ChatInfo.mStatus = 3;
        ChatInfo.oZR = this.pbo.getUserName();
        if (!TextUtils.isEmpty(this.mIcon)) {
            ChatInfo.oZU = this.mIcon;
        } else {
            ChatInfo.oZU = Yw(this.pbo.getIconUrl());
        }
        BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
        LogUtils.i(MAFragmentActivity.TAG, "uk:" + ChatInfo.oZS);
        LogUtils.i(MAFragmentActivity.TAG, "header:" + ChatInfo.oZT);
        LogUtils.i(MAFragmentActivity.TAG, "" + this.pbo.toString());
    }

    /* loaded from: classes11.dex */
    private static class j implements Runnable {
        private final SoftReference<ActivityChat> pbV;

        private j(ActivityChat activityChat) {
            this.pbV = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbV.get() != null) {
                try {
                    ChatInfo.oZS = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().hx(this.pbV.get().getApplicationContext()).longValue();
                    this.pbV.get().mChatStatus = 0;
                    this.pbV.get().Uu();
                    if (this.pbV.get().mNickName != null) {
                        this.pbV.get().paY.setText(String.valueOf(this.pbV.get().mNickName));
                    }
                    this.pbV.get().pbE.sendEmptyMessage(1);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        private final SoftReference<ActivityChat> pbV;

        private a(ActivityChat activityChat) {
            this.pbV = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbV.get() != null) {
                try {
                    ChatInfo.oZS = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().hx(this.pbV.get().getApplicationContext()).longValue();
                    this.pbV.get().mChatStatus = 1;
                    this.pbV.get().Uu();
                    if (this.pbV.get().mNickName != null) {
                        this.pbV.get().paY.setText(String.valueOf(this.pbV.get().mNickName));
                    }
                    this.pbV.get().pbE.sendEmptyMessage(1006);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private final SoftReference<ActivityChat> pbV;

        private b(ActivityChat activityChat) {
            this.pbV = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbV.get() != null) {
                try {
                    ChatInfo.oZS = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().hx(this.pbV.get().getApplicationContext()).longValue();
                    String str = null;
                    if (this.pbV.get().pbp != null) {
                        str = this.pbV.get().pbp.mInfo.getGroupName();
                    }
                    if (ChatInfo.oZV == 2) {
                        if (str == null || "".equals(str.trim())) {
                            if (this.pbV.get().mNickName != null) {
                                this.pbV.get().paY.setText(String.valueOf(this.pbV.get().mNickName));
                                return;
                            } else if (this.pbV.get().pbp != null) {
                                this.pbV.get().paY.setText(String.valueOf(str));
                                return;
                            } else {
                                return;
                            }
                        }
                        this.pbV.get().paY.setText(String.valueOf(str));
                    } else if (!TextUtils.isEmpty(str)) {
                        this.pbV.get().paY.setText(String.valueOf(str));
                        this.pbV.get().paZ.setText(this.pbV.get().pbp.mInfo.getNum() + "人");
                    } else if (!TextUtils.isEmpty(this.pbV.get().mNickName)) {
                        this.pbV.get().paY.setText(String.valueOf(this.pbV.get().mNickName));
                        this.pbV.get().paZ.setText(this.pbV.get().pbp.mInfo.getNum() + "人");
                    } else if (this.pbV.get().pbp != null) {
                        this.pbV.get().paY.setText("未知群");
                        this.pbV.get().paZ.setText(this.pbV.get().pbp.mInfo.getNum() + "人");
                    }
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class d implements Runnable {
        private final SoftReference<ActivityChat> pbV;

        private d(ActivityChat activityChat) {
            this.pbV = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbV.get() != null) {
                try {
                    this.pbV.get().pba.setVisibility(0);
                    this.pbV.get().pba.startAnimation(this.pbV.get().pbu);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class e implements Runnable {
        private final SoftReference<ActivityChat> pbV;

        private e(ActivityChat activityChat) {
            this.pbV = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbV.get() != null) {
                try {
                    this.pbV.get().pba.setVisibility(8);
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
        com.baidu.yuyinala.privatemessage.implugin.f.k.hC(getApplicationContext()).a(j2, new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.9
            @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
            public void d(int i2, String str, long j3) {
                Message message = new Message();
                message.what = 6;
                Bundle bundle = new Bundle();
                bundle.putString("subscribe_data", str);
                bundle.putBoolean("update_subscribe", z);
                message.setData(bundle);
                ActivityChat.this.pbE.sendMessage(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NE(int i2) {
        String str;
        Date date;
        long j2 = -1;
        if (i2 == 1) {
            str = com.baidu.yuyinala.privatemessage.implugin.f.j.getType();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.baidu.yuyinala.privatemessage.implugin.f.j.ejY())) {
                try {
                    j2 = Long.parseLong(com.baidu.yuyinala.privatemessage.implugin.f.j.ejY());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.c.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pio + ChatInfo.mPaid + ChatInfo.oZS, 0L));
            } else {
                return;
            }
        } else if (i2 == 0) {
            str = "ugc";
            j2 = this.pbq;
            date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.c.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pip + this.pbq, 0L));
        } else {
            str = null;
            date = null;
        }
        if (!com.baidu.yuyinala.privatemessage.implugin.util.f.c(date, new Date())) {
            if ((this.pbA == null || !this.pbA.elx() || this.pbA.ely() != i2) && this.pbh != null) {
                this.pbA = this.pbh.ao(i2, ekq());
                if (this.pbA != null) {
                    try {
                        this.pbA.c(str, j2, new g(this, i2));
                    } catch (NumberFormatException e3) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, e3.getMessage());
                    }
                    com.baidu.yuyinala.privatemessage.implugin.e.a.hB(getApplicationContext()).add("416", "subscribe_show");
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
                    activityChat.ekb().sendMessage(message);
                } else if (this.flag == 0) {
                    Message message2 = new Message();
                    if (z) {
                        message2.arg1 = 0;
                    } else {
                        message2.arg1 = -1;
                    }
                    message2.what = 8;
                    activityChat.ekb().sendMessage(message2);
                }
            }
        }
    }

    public void onBackClick() {
        if (this.mChatStatus == 0) {
            if (this.pbi != null) {
                this.pbi.eld();
            }
            if (this.pbA != null) {
                this.pbA.elw();
            }
        }
        finish();
        if (!ChatInfo.pac) {
            com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().hA(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Yw(String str) {
        return str;
    }
}
