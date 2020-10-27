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
    public static boolean ooQ;
    protected String aRs;
    protected boolean isFollowed;
    private LinearLayout mContainer;
    private String mGroupId;
    private String mIcon;
    private String mLiveId;
    private String mNickName;
    private PaInfo mPaInfo;
    public long mPaid;
    private FrameLayout ooA;
    private LinearLayout ooB;
    private RelativeLayout ooC;
    private FrameLayout ooD;
    private FrameLayout ooE;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a ooF;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b ooG;
    private LinearLayout ooH;
    private TextView ooI;
    private ImageView ooJ;
    private ImageView ooK;
    private ImageView ooL;
    private ChatUser ooM;
    protected QMGroupInfo ooN;
    protected long ooO;
    public boolean ooP;
    private Animation ooS;
    private Animation ooT;
    private String ooW;
    private UserStatus ooX;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c ooY;
    protected ImBaseEntity ooZ;
    private RelativeLayout oot;
    private View oou;
    private TextView oov;
    private TextView oow;
    private TextView oox;
    private View ooy;
    private FrameLayout ooz;
    private com.baidu.yuyinala.privatemessage.implugin.ui.a.a opa;
    private long opd;
    private int jAa = 0;
    public boolean ooR = false;
    private int bBa = 1;
    private String mListenerKey = "";
    private int ooU = -1;
    private long ooV = -1;
    private c opb = new c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.1
        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.c
        public void eci() {
            ActivityChat.this.opc.sendEmptyMessage(1002);
        }
    };
    private f opc = new f();
    private boolean ope = false;
    private View.OnClickListener opf = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().getLoginState(ActivityChat.this);
            ActivityChat.this.opd = System.currentTimeMillis();
            ActivityChat.this.ope = false;
            if (loginState == 3) {
                ActivityChat.this.opc.removeCallbacks(ActivityChat.this.fIK);
                ActivityChat.this.opc.postDelayed(ActivityChat.this.fIK, ActivityChat.this.ebO());
                ActivityChat.this.ooE.setVisibility(8);
                ActivityChat.this.init(ActivityChat.this.getIntent());
                return;
            }
            ActivityChat.this.opc.postDelayed(ActivityChat.this.fIK, 7000L);
            ActivityChat.this.ebP();
        }
    };
    private Runnable fIK = new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mTimeOutRunnable run ");
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().getLoginState(ActivityChat.this) != 3) {
                ActivityChat.this.ope = true;
                ActivityChat.this.ebQ();
                return;
            }
            ActivityChat.this.ebR();
        }
    };
    private h opg = new h();
    private View.OnClickListener oph = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChat.this.ecd();
            if (ActivityChat.this.bBa == 0 && ActivityChat.this.ooG != null) {
                ActivityChat.this.ooG.ecQ();
            }
        }
    };
    private l opi = new l();
    private k opj = new k();
    private j opk = new j();
    private a opl = new a();
    private b opm = new b();
    d opn = new d();
    e opo = new e();

    /* loaded from: classes4.dex */
    public interface c {
        void eci();
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
    public void WU(String str) {
        if ("greet_link".equals(str)) {
            String ecn = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.ecn();
            String str2 = "";
            if (!TextUtils.isEmpty(ChatInfo.nickname)) {
                str2 = ChatInfo.nickname;
            } else if (!TextUtils.isEmpty(ChatInfo.displayname)) {
                str2 = ChatInfo.displayname;
            }
            com.baidu.yuyinala.privatemessage.model.message.a.eew().B(this, ecn.replace("XXX", str2), this.mListenerKey);
        } else if ("welcom_link".equals(str)) {
            com.baidu.yuyinala.privatemessage.model.message.a.eew().B(this, com.baidu.yuyinala.privatemessage.implugin.ui.common.b.eco(), this.mListenerKey);
        }
    }

    public f ebM() {
        return this.opc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class f extends Handler {
        private final SoftReference<ActivityChat> opu;

        private f(ActivityChat activityChat) {
            this.opu = new SoftReference<>(activityChat);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            String str;
            int i2 = 0;
            boolean z = false;
            super.handleMessage(message);
            if (this.opu.get() != null) {
                try {
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.opu.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "current is no support");
                        this.opu.get().ooB.setVisibility(4);
                        ChatInfo.mStatus = 10;
                        if (this.opu.get().ooG != null) {
                            this.opu.get().ooG.ecJ();
                        }
                        if (this.opu.get().ooF != null) {
                            this.opu.get().ooF.ecJ();
                            return;
                        }
                        return;
                    case 2:
                        if (message.arg1 == 1) {
                            com.baidu.yuyinala.privatemessage.implugin.f.j.zz(true);
                            postDelayed(new i(this.opu), 1000L);
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.edm().br(this.opu.get().getApplicationContext(), this.opu.get().getString(a.i.bd_im_zhida_success_tip));
                            if (this.opu.get().ooY != null) {
                                this.opu.get().ooY.dismiss();
                            }
                            String ebK = com.baidu.yuyinala.privatemessage.implugin.f.j.ebK();
                            if (!TextUtils.isEmpty(ebK)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("sign", "media_" + ebK);
                                    jSONObject.put("relation", 1);
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().y(this.opu.get().getApplicationContext(), "com.baidu.channel.subscribe", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
                                    return;
                                } catch (UnsupportedEncodingException e2) {
                                    e2.printStackTrace();
                                    return;
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            this.opu.get();
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
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.edm().bq(this.opu.get().getApplicationContext(), str);
                            return;
                        } else {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.edm().bq(this.opu.get().getApplicationContext(), this.opu.get().getString(a.i.bd_im_subscribe_fail_tip));
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                        return;
                    case 3:
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.edm().showToast(this.opu.get().getApplicationContext(), this.opu.get().getString(a.i.bd_im_zhida_fail_net_tip));
                        return;
                    case 5:
                        this.opu.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 1 ");
                        this.opu.get().finish();
                        this.opu.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 2 ");
                        return;
                    case 6:
                        Bundle data = message.getData();
                        String str2 = "";
                        if (data != null) {
                            str2 = data.getString("subscribe_data");
                            z = data.getBoolean("update_subscribe", false);
                        }
                        com.baidu.yuyinala.privatemessage.implugin.f.j.WR(str2);
                        ChatInfo.mPainfo.setMsgNotify(com.baidu.yuyinala.privatemessage.implugin.f.j.isNeedNotify());
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.isSubscribed() || !z) {
                            if (this.opu.get().ooY != null && this.opu.get().ooY.edk()) {
                                this.opu.get().ooY.dismiss();
                            }
                        } else {
                            this.opu.get().Ne(1);
                        }
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.getData() != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.b.b.A(this.opu.get().getApplicationContext(), String.valueOf(this.opu.get().mPaid), com.baidu.yuyinala.privatemessage.implugin.f.j.getData().toString());
                            return;
                        }
                        return;
                    case 7:
                        this.opu.get().Ne(0);
                        return;
                    case 8:
                        if (message.arg1 == 0) {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.edm().bq(this.opu.get(), "关注成功");
                            this.opu.get().ooY.dismiss();
                            this.opu.get().ecf();
                            this.opu.get().isFollowed = true;
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.edm().bq(this.opu.get(), "关注失败");
                        return;
                    case 1001:
                        if (this.opu.get().ooH != null && this.opu.get().ooH.getVisibility() == 0) {
                            this.opu.get().ooH.setAnimation(AnimationUtils.loadAnimation(this.opu.get(), a.C0195a.bd_im_slip_out_from_right));
                            this.opu.get().ooH.setVisibility(4);
                            return;
                        }
                        return;
                    case 1002:
                        this.opu.get().ebU();
                        return;
                    case 1003:
                        if (this.opu.get().ooJ != null && this.opu.get().ooJ.getVisibility() == 0) {
                            this.opu.get().ooJ.setAnimation(AnimationUtils.loadAnimation(this.opu.get(), a.C0195a.bd_im_disappear_out));
                            this.opu.get().ooJ.setVisibility(4);
                            return;
                        }
                        return;
                    case 1006:
                        this.opu.get().ooB.setVisibility(4);
                        ChatInfo.mStatus = 11;
                        if (this.opu.get().ooG != null) {
                            this.opu.get().ooG.ecJ();
                        }
                        this.opu.get().ooD.setVisibility(0);
                        return;
                    case 1007:
                    case 1008:
                        return;
                    case 1009:
                        if (this.opu.get().ooF != null) {
                            this.opu.get().ooF.zC(false);
                        }
                        this.opu.get().ooE.setVisibility(8);
                        this.opu.get().init(this.opu.get().getIntent());
                        return;
                    case 1010:
                        if (this.opu.get().ooF != null) {
                            this.opu.get().ooF.zC(true);
                        }
                        if (this.opu.get().ooG != null) {
                            this.opu.get().ooG.ecJ();
                            return;
                        }
                        return;
                    case 1011:
                        this.opu.get().ooB.setVisibility(4);
                        ChatInfo.mStatus = 12;
                        if (this.opu.get().ooG != null) {
                            this.opu.get().ooG.ecJ();
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
        private final SoftReference<ActivityChat> opu;

        private i(SoftReference<ActivityChat> softReference) {
            this.opu = softReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.opu.get() != null) {
                this.opu.get().u(this.opu.get().mPaid, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BIMManager.mediaSetRole(getActivity(), true);
        eca();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        setContentView(a.h.bd_im_chat_activity_layout);
        this.mContainer = (LinearLayout) findViewById(a.g.bd_im_chat_root);
        this.opa = new com.baidu.yuyinala.privatemessage.implugin.ui.a.a();
        ecc();
        init(getIntent());
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().isCuidLogin(this) || com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().ebH()) {
            this.ooR = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    private void ebN() {
        this.opd = System.currentTimeMillis();
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "loginOver loginState: " + loginState);
        if (this.ooF != null) {
            this.ooF.ecK();
        }
        switch (loginState) {
            case 2:
                this.opc.postDelayed(this.fIK, 7000L);
                ebP();
                return;
            case 3:
                this.opc.postDelayed(this.fIK, ebO());
                this.ooE.setVisibility(8);
                this.opc.sendEmptyMessage(1009);
                return;
            default:
                this.opc.postDelayed(this.fIK, 7000L);
                ebS();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ebO() {
        long currentTimeMillis = 10000 - (System.currentTimeMillis() - this.opd);
        if (currentTimeMillis > 7000) {
            return 7000L;
        }
        return currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebP() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "retryLogin timeout " + this.ope);
        if (!this.ope) {
            this.opc.sendEmptyMessage(1010);
            com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().a(this, new b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.13
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
    public void ebQ() {
        if (this.ooF != null) {
            this.ooF.zC(false);
        }
        if (this.ooG != null) {
            this.ooG.ecJ();
        }
        this.ooE.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebR() {
        if (this.ooF != null) {
            this.ooF.zC(false);
        }
    }

    private void ebS() {
        this.opc.sendEmptyMessage(1010);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus ");
        com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().a(this, new b.e() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.14
            @Override // com.baidu.android.imsdk.account.ILoginStateChangedListener
            public void onLoginStateChanged(int i2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus onLoginStateChanged state: " + i2);
                switch (i2) {
                    case 2:
                        ActivityChat.this.ebP();
                        return;
                    case 3:
                        ActivityChat.this.opc.removeCallbacks(ActivityChat.this.fIK);
                        ActivityChat.this.opc.postDelayed(ActivityChat.this.fIK, ActivityChat.this.ebO());
                        ActivityChat.this.opc.sendEmptyMessage(1009);
                        return;
                    default:
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "waitting");
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebT() {
        if (this.jAa > 8) {
            if (this.ooH == null) {
                this.ooH = (LinearLayout) findViewById(a.g.bd_im_chat_unread_msgs_layout);
                this.ooI = (TextView) findViewById(a.g.bd_im_chat_unread_msgs_txt);
                this.ooI.setText(this.jAa + getString(a.i.bd_im_alert_unread_msgs));
            }
            this.ooK = (ImageView) findViewById(a.g.bd_im_chat_unread_msgs_up);
            try {
                this.ooH.setBackgroundResource(ThemeManager.K(this, a.f.bd_im_chat_unread_msgs_background));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.ooH.setAnimation(AnimationUtils.loadAnimation(this, a.C0195a.bd_im_slip_in_from_right));
            this.ooH.setVisibility(0);
            this.ooH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.ooF.Nf(ActivityChat.this.jAa);
                    ActivityChat.this.ooH.setAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0195a.bd_im_slip_out_from_right));
                    ActivityChat.this.ooH.setVisibility(4);
                }
            });
            this.opc.sendEmptyMessageDelayed(1001, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebU() {
        if (this.ooJ == null) {
            this.ooJ = (ImageView) findViewById(a.g.bd_im_chat_new_msgs_tip);
            this.ooJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.ooF.ecz();
                    ActivityChat.this.ooJ.startAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0195a.bd_im_disappear_out));
                    ActivityChat.this.ooJ.setVisibility(4);
                }
            });
        }
        if (this.ooJ.getVisibility() != 0) {
            this.ooJ.startAnimation(AnimationUtils.loadAnimation(this, a.C0195a.bd_im_disappear_in));
            this.ooJ.setVisibility(0);
        }
        this.opc.removeMessages(1003);
        this.opc.sendEmptyMessageDelayed(1003, 10000L);
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
        switch (ChatInfo.ons) {
            case GROUP:
                com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().setAllMsgRead(getApplicationContext(), 1, ChatInfo.mContacter, false);
                break;
            default:
                BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
                break;
        }
        try {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.edc();
            com.baidu.yuyinala.privatemessage.implugin.imagechooser.a.ebE();
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().c(this, th);
        }
        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.edm().dismiss();
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mChatCategory " + ChatInfo.ons + " mOnlineStatus " + this.ooX);
        if (ChatInfo.ons == ChatInfo.ChatCategory.C2C && this.ooX != null) {
            ebV();
        }
        if (this.ooF != null) {
            this.ooF.a((com.baidu.yuyinala.privatemessage.implugin.ui.activity.a) null);
        }
        if (this.ooG != null) {
            this.ooG.onDestroy();
        }
        if (this.ooF != null) {
            this.ooF.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i2) {
    }

    private void ebV() {
        Intent intent = new Intent(IMConstants.NOTICE_USER_STATE);
        intent.putExtra(IMConstants.NOTICE_USER_STATE_OBJECT, this.ooX);
        sendBroadcast(intent);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "noticeSessionState com.baidu.android.imsdk.notice.userstate");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onResume--->");
        super.onResume();
        com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().zy(true);
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onResume mIsCuidOrIncompleteLogin: " + this.ooR + " loginState: " + loginState);
        if (this.ooR && (!com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().isCuidLogin(this) || !com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().ebH() || (loginState != 0 && loginState != 3))) {
            ebN();
        } else if (this.ooY != null && this.ooY.edk() && ChatInfo.ChatCategory.DUZHAN == ChatInfo.ons) {
            u(this.mPaid, true);
        }
        if (this.ooG != null) {
            this.ooG.onResume();
        }
        if (this.ooF != null) {
            this.ooF.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStop--->");
        super.onStop();
        if (this.ooG != null) {
            this.ooG.onStop();
        }
        if (this.ooF != null) {
            this.ooF.onStop();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStop");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStart--->");
        super.onStart();
        if (this.ooG != null) {
            this.ooG.onStart();
        }
        if (this.ooF != null) {
            this.ooF.onStart();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStart");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onPause--->");
        super.onPause();
        com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().zy(false);
        if (this.ooG != null) {
            this.ooG.onPause();
        }
        if (this.ooF != null) {
            this.ooF.onPause();
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
            this.aRs = ExtraParamsManager.getEncryptionUserId(extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.ovm));
            this.ooP = extras.getBoolean("isMediaRole");
            this.mGroupId = extras.getString("groupid");
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("miliao", "mIsmediaRole：" + this.ooP);
            this.mLiveId = extras.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            ooQ = this.ooP;
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.ovm, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.ovm));
            jSONObject.put("paid", extras.getString("paid"));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.ovo, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.ovo));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.ovq, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.ovq));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.ovp, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.ovp));
            String jSONObject2 = jSONObject.toString();
            try {
                if (!TextUtils.isEmpty(extras.getString("action"))) {
                    Serializable serializable = extras.getSerializable("params");
                    if (serializable instanceof ImBaseEntity) {
                        this.ooZ = (ImBaseEntity) serializable;
                        if (this.ooN == null) {
                            GroupInfo groupInfo = new GroupInfo(String.valueOf(this.ooZ.id));
                            groupInfo.setGroupName(this.ooZ.name);
                            groupInfo.setDescription(this.ooZ.description);
                            groupInfo.setHeadUrl(this.ooZ.headUrl);
                            this.ooN = new QMGroupInfo(groupInfo);
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
        ebY();
        String ay = ay(intent);
        if (this.ooB != null) {
            if (this.ooP) {
                this.ooB.setVisibility(8);
            } else {
                this.ooB.setVisibility(0);
            }
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + ay);
        ChatInfo.mContacter = -1L;
        ChatInfo.onu = -1L;
        ChatInfo.mAppid = -1L;
        ChatInfo.mUid = -1L;
        ChatInfo.onv = "";
        ChatInfo.onw = "";
        ChatInfo.jUX = -1;
        ChatInfo.onA = 0;
        ChatInfo.onD = true;
        ChatInfo.onC = false;
        try {
            JSONObject jSONObject = new JSONObject(ay);
            int i2 = jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.ovp) ? jSONObject.getInt(com.baidu.yuyinala.privatemessage.implugin.util.d.ovp) : -1;
            if (i2 == -1) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "invoke error -1");
                return;
            }
            if (i2 == 80) {
                parseLong = Long.parseLong(jSONObject.optString("paid", "-1"));
            } else {
                parseLong = Long.parseLong(jSONObject.optString(com.baidu.yuyinala.privatemessage.implugin.util.d.ovm, "-1"));
            }
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + ay);
            if (this.ooU != -1 && (this.ooU != i2 || this.ooV != parseLong)) {
                if (this.ooF != null) {
                    this.ooF.ecK();
                }
                if (this.oow != null) {
                    this.oow.setText("");
                }
            }
            this.ooU = i2;
            switch (i2) {
                case 0:
                    ChatInfo.ons = ChatInfo.ChatCategory.C2C;
                    try {
                        this.ooO = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.ovm));
                        ChatInfo.mUid = this.ooO;
                        ebX();
                        this.mNickName = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.ovo);
                        this.mIcon = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.ovq);
                        if (jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.ovs)) {
                            ChatInfo.onD = jSONObject.getBoolean(com.baidu.yuyinala.privatemessage.implugin.util.d.ovs);
                        }
                    } catch (Exception e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "init uid and name error");
                    }
                    this.oox.setVisibility(8);
                    this.mListenerKey = String.valueOf(this.ooO);
                    WV(this.mNickName);
                    gX(this.ooO);
                    return;
                case 80:
                    ChatInfo.ons = ChatInfo.ChatCategory.DUZHAN;
                    eA(jSONObject);
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
            com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().c(this, e3);
        }
    }

    private void eA(JSONObject jSONObject) {
        try {
            this.mPaid = Long.parseLong(jSONObject.getString("paid"));
            ChatInfo.mPaid = this.mPaid;
            if (this.ooP) {
                long parseLong = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.ovm));
                if (parseLong > 0) {
                    ChatInfo.mUid = parseLong;
                }
            }
            ebZ();
        } catch (Exception e2) {
            LogUtils.e(MAFragmentActivity.TAG, "init appid error");
        }
        this.mListenerKey = String.valueOf(this.mPaid);
        gW(this.mPaid);
    }

    private void gW(long j2) {
        this.oox.setVisibility(8);
        if (j2 <= 0) {
            this.mPaInfo = null;
            showToast(a.i.bd_im_read_error);
            return;
        }
        this.mPaInfo = PaManager.getPaInfo(getApplicationContext(), j2);
        if (this.mPaInfo == null) {
            PaManagerImpl.getInstance(this).getPaInfo(j2, new IGetPaInfoListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.17
                @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfoListener
                public void onGetPaInfoResult(int i2, String str, PaInfo paInfo) {
                    LogUtils.d("FXF", "get painfo " + paInfo.toString() + " thread " + Thread.currentThread().getId());
                    ActivityChat.this.mPaInfo = paInfo;
                    ActivityChat.this.opc.post(ActivityChat.this.opg);
                }
            });
        } else {
            this.opc.post(this.opg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class h implements Runnable {
        private final SoftReference<ActivityChat> opv;

        private h(ActivityChat activityChat) {
            this.opv = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.opv.get() != null) {
                try {
                    ChatInfo.onu = AccountManager.getUK(this.opv.get().getApplicationContext());
                    this.opv.get();
                    LogUtils.d(MAFragmentActivity.TAG, "parunnable ---> " + ChatInfo.onu);
                    if (ChatInfo.onu != -1) {
                        this.opv.get().bBa = 0;
                        this.opv.get().ebW();
                        this.opv.get();
                        LogUtils.d(MAFragmentActivity.TAG, "parunnable -->1");
                        ChatInfo.mContacter = this.opv.get().mPaInfo.getPaId();
                        ChatInfo.mPainfo = this.opv.get().mPaInfo;
                        if (ChatInfo.ons == ChatInfo.ChatCategory.DUZHAN) {
                            this.opv.get().jAa = ChatMsgManager.getUnReadMsgCountByPaid(this.opv.get(), this.opv.get().mPaid);
                            if (this.opv.get().jAa > 200) {
                                this.opv.get().jAa = 200;
                            }
                        }
                        this.opv.get().Re();
                        this.opv.get().u(this.opv.get().mPaid, true);
                    } else {
                        this.opv.get().showToast(a.i.bd_im_zhida_login_error);
                    }
                    this.opv.get().ooW = TextUtils.isEmpty(this.opv.get().ooW) ? this.opv.get().mPaInfo.getNickName() : this.opv.get().ooW;
                    this.opv.get().oow.setText(String.valueOf(this.opv.get().ooW));
                    this.opv.get().ebT();
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebW() {
        com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().a(getActivity(), new IGetUsersProfileBatchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.18
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2) {
                if (i2 == 0 && arrayList2 != null && arrayList2.size() == 1) {
                    ChatInfo.onv = ActivityChat.this.WX(arrayList2.get(0).getIconUrl());
                    ChatInfo.displayname = arrayList2.get(0).getUserName();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebX() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.b(ExtraParamsManager.getEncryptionUserId(ChatInfo.mUid + "")));
    }

    private static void ebY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031061, TbConfig.SERVER_ADDRESS + "ala/audio/user/preFollow");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void ebZ() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.a(ExtraParamsManager.getEncryptionUserId(this.mPaid + "")));
    }

    private void eca() {
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
                        ActivityChat.this.ebX();
                    }
                }
            }
        });
    }

    public boolean ecb() {
        return this.ooU == 2 || this.ooU == 11;
    }

    private void initViews() {
        findViewById(a.g.yuyin_privatechat_empty_location).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ActivityChat.this.finish();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
                return true;
            }
        });
        this.oot = (RelativeLayout) findViewById(a.g.bd_im_chat_title_root);
        this.oou = findViewById(a.g.bd_im_chat_cell_space_line);
        this.oov = (TextView) findViewById(a.g.bd_im_chat_open_main);
        this.ooB = (LinearLayout) findViewById(a.g.bd_im_chat_open_main_click_parent);
        this.ooB.setOnClickListener(this.oph);
        this.ooC = (RelativeLayout) findViewById(a.g.bd_im_chat_back_layout);
        this.ooC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.onBackClick();
            }
        });
        this.oow = (TextView) findViewById(a.g.bd_im_chat_title);
        this.oox = (TextView) findViewById(a.g.bd_im_chat_subtitle);
        this.ooy = findViewById(a.g.bd_im_chat_main_input);
        this.ooz = (FrameLayout) findViewById(a.g.bd_im_chat_main_content);
        this.ooA = (FrameLayout) findViewById(a.g.bd_im_chat_main_input);
        this.ooD = (FrameLayout) findViewById(a.g.bd_im_chat_main_error_content);
        this.ooL = (ImageView) findViewById(a.g.bd_im_chat_main_error_image);
        this.ooD.setVisibility(8);
        this.ooE = (FrameLayout) findViewById(a.g.bd_im_chat_main_retry_content);
        this.ooE.setVisibility(8);
        findViewById(a.g.bd_im_chat_main_retry_button).setOnClickListener(this.opf);
        this.oow.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.ecg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Re() {
        if (this.ooF == null) {
            FrameLayout frameLayout = this.ooz;
            this.ooz.addView(FrameLayout.inflate(this, a.h.bd_im_chat_fragment_chat, null));
            this.ooF = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.a(this, this.ooz, this.mListenerKey, this.opb, this.jAa);
        }
        if (this.ooG == null) {
            FrameLayout frameLayout2 = this.ooA;
            this.ooA.addView(FrameLayout.inflate(this, a.h.bd_im_chat_fragment_input, null));
            this.ooG = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.a(this, this.ooA, this.mListenerKey, this.opb);
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "initFragment : ");
        if (!isFinishing()) {
            try {
                com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "mTransaction.commitAllowingStateLoss() : ");
            } catch (Exception e2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "e :" + e2);
                com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().c(this, e2);
            }
        }
        if (this.ooF != null) {
            this.ooF.a(this);
        }
        gY(this.ooO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void ecc() {
        this.ooS = AnimationUtils.loadAnimation(this, a.C0195a.bd_im_fragment_in_from_bottom);
        this.ooT = AnimationUtils.loadAnimation(this, a.C0195a.bd_im_fragment_out_to_bottom);
    }

    private void gX(long j2) {
        if (j2 == 0) {
            this.ooM = null;
            showToast(a.i.bd_im_read_error);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j2));
        final SoftReference softReference = new SoftReference(this);
        com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().a(getApplicationContext(), arrayList, false, new b.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList2, ArrayList<ChatUser> arrayList3) {
                if (softReference.get() != null) {
                    if (i2 != 0) {
                        ((ActivityChat) softReference.get()).opc.post(ActivityChat.this.opl);
                        return;
                    }
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        ((ActivityChat) softReference.get()).ooM = arrayList3.get(0);
                    }
                    if (((ActivityChat) softReference.get()).ooM == null) {
                        ((ActivityChat) softReference.get()).opc.post(ActivityChat.this.opk);
                        return;
                    }
                    ArrayList<Long> arrayList4 = new ArrayList<>();
                    arrayList4.add(Long.valueOf(ActivityChat.this.ooM.getUk()));
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().a(ActivityChat.this.getApplicationContext(), arrayList4, new b.InterfaceC0927b() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7.1
                        @Override // com.baidu.android.imsdk.chatuser.IGetUserStatusListener
                        public void onGetUsersStatusResult(int i3, String str2, ArrayList<UserStatus> arrayList5) {
                            if (i3 == 0 && arrayList5.size() == 1) {
                                ((ActivityChat) softReference.get()).ooX = arrayList5.get(0);
                                ((ActivityChat) softReference.get()).opc.post(ActivityChat.this.opi);
                            }
                        }
                    });
                    ((ActivityChat) softReference.get()).opc.post(ActivityChat.this.opj);
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
                            ActivityChat.this.opc.sendEmptyMessageDelayed(7, 1000L);
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
            com.baidu.yuyinala.privatemessage.implugin.e.a.gE(getApplicationContext()).gR("542", "chat_flow_time");
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
        }
    }

    protected void gY(long j2) {
    }

    protected void ecd() {
    }

    public ImBaseEntity ece() {
        return this.ooZ;
    }

    protected void ecf() {
    }

    protected void WV(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oow.setText(str);
        } else if (this.mNickName != null) {
            this.oow.setText(String.valueOf(this.mNickName));
        } else if (this.ooM != null) {
            this.oow.setText(String.valueOf(this.ooM.getUserName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecg() {
        String liveId = getLiveId();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig((Context) getActivity(), ChatInfo.mUid + "", (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, 0L, 0L, 0L, 0, getGroupId(), liveId, false, (String) null, (String) null, (String) null, (String) null, (String) null)));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
    }

    /* loaded from: classes4.dex */
    private static class l implements Runnable {
        private final SoftReference<ActivityChat> opu;

        private l(ActivityChat activityChat) {
            this.opu = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes4.dex */
    private static class k implements Runnable {
        private final SoftReference<ActivityChat> opu;

        private k(ActivityChat activityChat) {
            this.opu = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.opu.get() != null) {
                try {
                    ChatInfo.onu = AccountManager.getUK(this.opu.get().getApplicationContext());
                    if (ChatInfo.onu != -1) {
                        this.opu.get().bBa = 0;
                        this.opu.get().ech();
                        this.opu.get().Re();
                        this.opu.get().gZ(this.opu.get().ooO);
                    } else {
                        this.opu.get().showToast(a.i.bd_im_zhida_login_error);
                    }
                    if (this.opu.get().mNickName == null) {
                        if (this.opu.get().ooM != null) {
                            this.opu.get().oow.setText(String.valueOf(this.opu.get().ooM.getUserName()));
                            return;
                        }
                        return;
                    }
                    this.opu.get().oow.setText(String.valueOf(this.opu.get().mNickName));
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gZ(long j2) {
        if (WW(String.valueOf(j2))) {
        }
    }

    private boolean WW(String str) {
        String z = com.baidu.yuyinala.privatemessage.implugin.util.b.b.z(getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovI, null);
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
    public void ech() {
        ebW();
        ChatInfo.mContacter = this.ooM.getUk();
        ChatInfo.mUid = this.ooM.getBuid();
        ChatInfo.mStatus = 3;
        ChatInfo.ont = this.ooM.getUserName();
        if (!TextUtils.isEmpty(this.mIcon)) {
            ChatInfo.onw = this.mIcon;
        } else {
            ChatInfo.onw = WX(this.ooM.getIconUrl());
        }
        BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
        LogUtils.i(MAFragmentActivity.TAG, "uk:" + ChatInfo.onu);
        LogUtils.i(MAFragmentActivity.TAG, "header:" + ChatInfo.onv);
        LogUtils.i(MAFragmentActivity.TAG, "" + this.ooM.toString());
    }

    /* loaded from: classes4.dex */
    private static class j implements Runnable {
        private final SoftReference<ActivityChat> opu;

        private j(ActivityChat activityChat) {
            this.opu = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.opu.get() != null) {
                try {
                    ChatInfo.onu = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().gA(this.opu.get().getApplicationContext()).longValue();
                    this.opu.get().bBa = 0;
                    this.opu.get().Re();
                    if (this.opu.get().mNickName != null) {
                        this.opu.get().oow.setText(String.valueOf(this.opu.get().mNickName));
                    }
                    this.opu.get().opc.sendEmptyMessage(1);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final SoftReference<ActivityChat> opu;

        private a(ActivityChat activityChat) {
            this.opu = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.opu.get() != null) {
                try {
                    ChatInfo.onu = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().gA(this.opu.get().getApplicationContext()).longValue();
                    this.opu.get().bBa = 1;
                    this.opu.get().Re();
                    if (this.opu.get().mNickName != null) {
                        this.opu.get().oow.setText(String.valueOf(this.opu.get().mNickName));
                    }
                    this.opu.get().opc.sendEmptyMessage(1006);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class b implements Runnable {
        private final SoftReference<ActivityChat> opu;

        private b(ActivityChat activityChat) {
            this.opu = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.opu.get() != null) {
                try {
                    ChatInfo.onu = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().gA(this.opu.get().getApplicationContext()).longValue();
                    String str = null;
                    if (this.opu.get().ooN != null) {
                        str = this.opu.get().ooN.mInfo.getGroupName();
                    }
                    if (ChatInfo.jUX == 2) {
                        if (str == null || "".equals(str.trim())) {
                            if (this.opu.get().mNickName != null) {
                                this.opu.get().oow.setText(String.valueOf(this.opu.get().mNickName));
                                return;
                            } else if (this.opu.get().ooN != null) {
                                this.opu.get().oow.setText(String.valueOf(str));
                                return;
                            } else {
                                return;
                            }
                        }
                        this.opu.get().oow.setText(String.valueOf(str));
                    } else if (!TextUtils.isEmpty(str)) {
                        this.opu.get().oow.setText(String.valueOf(str));
                        this.opu.get().oox.setText(this.opu.get().ooN.mInfo.getNum() + "人");
                    } else if (!TextUtils.isEmpty(this.opu.get().mNickName)) {
                        this.opu.get().oow.setText(String.valueOf(this.opu.get().mNickName));
                        this.opu.get().oox.setText(this.opu.get().ooN.mInfo.getNum() + "人");
                    } else if (this.opu.get().ooN != null) {
                        this.opu.get().oow.setText("未知群");
                        this.opu.get().oox.setText(this.opu.get().ooN.mInfo.getNum() + "人");
                    }
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class d implements Runnable {
        private final SoftReference<ActivityChat> opu;

        private d(ActivityChat activityChat) {
            this.opu = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.opu.get() != null) {
                try {
                    this.opu.get().ooy.setVisibility(0);
                    this.opu.get().ooy.startAnimation(this.opu.get().ooS);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class e implements Runnable {
        private final SoftReference<ActivityChat> opu;

        private e(ActivityChat activityChat) {
            this.opu = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.opu.get() != null) {
                try {
                    this.opu.get().ooy.setVisibility(8);
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
                ActivityChat.this.opc.sendMessage(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ne(int i2) {
        Date date;
        String str = null;
        long j2 = -1;
        if (i2 == 1) {
            str = com.baidu.yuyinala.privatemessage.implugin.f.j.getType();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.baidu.yuyinala.privatemessage.implugin.f.j.ebK())) {
                try {
                    j2 = Long.parseLong(com.baidu.yuyinala.privatemessage.implugin.f.j.ebK());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.b.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovN + ChatInfo.mPaid + ChatInfo.onu, 0L));
            } else {
                return;
            }
        } else if (i2 == 0) {
            str = "ugc";
            j2 = this.ooO;
            date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.b.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovO + this.ooO, 0L));
        } else {
            date = null;
        }
        if (!com.baidu.yuyinala.privatemessage.implugin.util.f.c(date, new Date())) {
            if ((this.ooY == null || !this.ooY.edk() || this.ooY.edl() != i2) && this.ooF != null) {
                this.ooY = this.ooF.aq(i2, ecb());
                if (this.ooY != null) {
                    try {
                        this.ooY.c(str, j2, new g(this, i2));
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
                    activityChat.ebM().sendMessage(message);
                } else if (this.flag == 0) {
                    Message message2 = new Message();
                    if (z) {
                        message2.arg1 = 0;
                    } else {
                        message2.arg1 = -1;
                    }
                    message2.what = 8;
                    activityChat.ebM().sendMessage(message2);
                }
            }
        }
    }

    public void onBackClick() {
        if (this.bBa == 0) {
            if (this.ooG != null) {
                this.ooG.ecQ();
            }
            if (this.ooY != null) {
                this.ooY.edj();
            }
        }
        finish();
        if (!ChatInfo.onD) {
            com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().gD(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String WX(String str) {
        return str;
    }
}
