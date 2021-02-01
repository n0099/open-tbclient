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
    public static boolean paS;
    protected String aTp;
    protected boolean isFollowed;
    private LinearLayout mContainer;
    private String mGroupId;
    private String mIcon;
    private String mLiveId;
    private String mNickName;
    private PaInfo mPaInfo;
    public long mPaid;
    private View paA;
    private FrameLayout paB;
    private FrameLayout paC;
    private LinearLayout paD;
    private RelativeLayout paE;
    private FrameLayout paF;
    private FrameLayout paG;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a paH;
    private com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b paI;
    private LinearLayout paJ;
    private TextView paK;
    private ImageView paL;
    private ImageView paM;
    private ImageView paN;
    private ChatUser paO;
    protected QMGroupInfo paP;
    protected long paQ;
    public boolean paR;
    private Animation paU;
    private Animation paV;
    private String paY;
    private UserStatus paZ;
    private RelativeLayout pau;
    private View pav;
    private TextView paw;
    private TextView pax;
    private TextView paz;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c pba;
    protected ImBaseEntity pbb;
    private com.baidu.yuyinala.privatemessage.implugin.ui.a.a pbc;
    private long pbf;
    private int klq = 0;
    public boolean paT = false;
    private int mChatStatus = 1;
    private String mListenerKey = "";
    private int paW = -1;
    private long paX = -1;
    private c pbd = new c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.1
        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.c
        public void ekp() {
            ActivityChat.this.pbe.sendEmptyMessage(1002);
        }
    };
    private f pbe = new f();
    private boolean pbg = false;
    private View.OnClickListener pbh = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().getLoginState(ActivityChat.this);
            ActivityChat.this.pbf = System.currentTimeMillis();
            ActivityChat.this.pbg = false;
            if (loginState == 3) {
                ActivityChat.this.pbe.removeCallbacks(ActivityChat.this.gdc);
                ActivityChat.this.pbe.postDelayed(ActivityChat.this.gdc, ActivityChat.this.ejV());
                ActivityChat.this.paG.setVisibility(8);
                ActivityChat.this.init(ActivityChat.this.getIntent());
                return;
            }
            ActivityChat.this.pbe.postDelayed(ActivityChat.this.gdc, 7000L);
            ActivityChat.this.ejW();
        }
    };
    private Runnable gdc = new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mTimeOutRunnable run ");
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().getLoginState(ActivityChat.this) != 3) {
                ActivityChat.this.pbg = true;
                ActivityChat.this.ejX();
                return;
            }
            ActivityChat.this.ejY();
        }
    };
    private h pbi = new h();
    private View.OnClickListener pbj = new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChat.this.ekk();
            if (ActivityChat.this.mChatStatus == 0 && ActivityChat.this.paI != null) {
                ActivityChat.this.paI.ekV();
            }
        }
    };
    private l pbk = new l();
    private k pbl = new k();
    private j pbm = new j();
    private a pbn = new a();
    private b pbo = new b();
    d pbp = new d();
    e pbq = new e();

    /* loaded from: classes11.dex */
    public interface c {
        void ekp();
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
    public void Yh(String str) {
        if ("greet_link".equals(str)) {
            String eku = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.eku();
            String str2 = "";
            if (!TextUtils.isEmpty(ChatInfo.nickname)) {
                str2 = ChatInfo.nickname;
            } else if (!TextUtils.isEmpty(ChatInfo.displayname)) {
                str2 = ChatInfo.displayname;
            }
            com.baidu.yuyinala.privatemessage.model.message.a.emC().D(this, eku.replace("XXX", str2), this.mListenerKey);
        } else if ("welcom_link".equals(str)) {
            com.baidu.yuyinala.privatemessage.model.message.a.emC().D(this, com.baidu.yuyinala.privatemessage.implugin.ui.common.b.ekv(), this.mListenerKey);
        }
    }

    public f ejT() {
        return this.pbe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class f extends Handler {
        private final SoftReference<ActivityChat> pbv;

        private f(ActivityChat activityChat) {
            this.pbv = new SoftReference<>(activityChat);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = null;
            int i = 0;
            boolean z = false;
            super.handleMessage(message);
            if (this.pbv.get() != null) {
                try {
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.pbv.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "current is no support");
                        this.pbv.get().paD.setVisibility(4);
                        ChatInfo.mStatus = 10;
                        if (this.pbv.get().paI != null) {
                            this.pbv.get().paI.ekP();
                        }
                        if (this.pbv.get().paH != null) {
                            this.pbv.get().paH.ekP();
                            return;
                        }
                        return;
                    case 2:
                        if (message.arg1 == 1) {
                            com.baidu.yuyinala.privatemessage.implugin.f.j.AK(true);
                            postDelayed(new i(this.pbv), 1000L);
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elr().bw(this.pbv.get().getApplicationContext(), this.pbv.get().getString(a.h.bd_im_zhida_success_tip));
                            if (this.pbv.get().pba != null) {
                                this.pbv.get().pba.dismiss();
                            }
                            String ejQ = com.baidu.yuyinala.privatemessage.implugin.f.j.ejQ();
                            if (!TextUtils.isEmpty(ejQ)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("sign", "media_" + ejQ);
                                    jSONObject.put("relation", 1);
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().A(this.pbv.get().getApplicationContext(), "com.baidu.channel.subscribe", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
                                    return;
                                } catch (UnsupportedEncodingException e2) {
                                    e2.printStackTrace();
                                    return;
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            this.pbv.get();
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
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elr().bv(this.pbv.get().getApplicationContext(), str);
                            return;
                        } else {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elr().bv(this.pbv.get().getApplicationContext(), this.pbv.get().getString(a.h.bd_im_subscribe_fail_tip));
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                        return;
                    case 3:
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elr().showToast(this.pbv.get().getApplicationContext(), this.pbv.get().getString(a.h.bd_im_zhida_fail_net_tip));
                        return;
                    case 5:
                        this.pbv.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 1 ");
                        this.pbv.get().finish();
                        this.pbv.get();
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "AAA 2 ");
                        return;
                    case 6:
                        Bundle data = message.getData();
                        String str2 = "";
                        if (data != null) {
                            str2 = data.getString("subscribe_data");
                            z = data.getBoolean("update_subscribe", false);
                        }
                        com.baidu.yuyinala.privatemessage.implugin.f.j.Ye(str2);
                        ChatInfo.mPainfo.setMsgNotify(com.baidu.yuyinala.privatemessage.implugin.f.j.isNeedNotify());
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.ejR() || !z) {
                            if (this.pbv.get().pba != null && this.pbv.get().pba.elp()) {
                                this.pbv.get().pba.dismiss();
                            }
                        } else {
                            this.pbv.get().ND(1);
                        }
                        if (com.baidu.yuyinala.privatemessage.implugin.f.j.getData() != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.b.C(this.pbv.get().getApplicationContext(), String.valueOf(this.pbv.get().mPaid), com.baidu.yuyinala.privatemessage.implugin.f.j.getData().toString());
                            return;
                        }
                        return;
                    case 7:
                        this.pbv.get().ND(0);
                        return;
                    case 8:
                        if (message.arg1 == 0) {
                            com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elr().bv(this.pbv.get(), "关注成功");
                            this.pbv.get().pba.dismiss();
                            this.pbv.get().ekm();
                            this.pbv.get().isFollowed = true;
                            return;
                        }
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elr().bv(this.pbv.get(), "关注失败");
                        return;
                    case 1001:
                        if (this.pbv.get().paJ != null && this.pbv.get().paJ.getVisibility() == 0) {
                            this.pbv.get().paJ.setAnimation(AnimationUtils.loadAnimation(this.pbv.get(), a.C0195a.bd_im_slip_out_from_right));
                            this.pbv.get().paJ.setVisibility(4);
                            return;
                        }
                        return;
                    case 1002:
                        this.pbv.get().ekb();
                        return;
                    case 1003:
                        if (this.pbv.get().paL != null && this.pbv.get().paL.getVisibility() == 0) {
                            this.pbv.get().paL.setAnimation(AnimationUtils.loadAnimation(this.pbv.get(), a.C0195a.bd_im_disappear_out));
                            this.pbv.get().paL.setVisibility(4);
                            return;
                        }
                        return;
                    case 1006:
                        this.pbv.get().paD.setVisibility(4);
                        ChatInfo.mStatus = 11;
                        if (this.pbv.get().paI != null) {
                            this.pbv.get().paI.ekP();
                        }
                        this.pbv.get().paF.setVisibility(0);
                        return;
                    case 1007:
                    case 1008:
                        return;
                    case 1009:
                        if (this.pbv.get().paH != null) {
                            this.pbv.get().paH.AN(false);
                        }
                        this.pbv.get().paG.setVisibility(8);
                        this.pbv.get().init(this.pbv.get().getIntent());
                        return;
                    case 1010:
                        if (this.pbv.get().paH != null) {
                            this.pbv.get().paH.AN(true);
                        }
                        if (this.pbv.get().paI != null) {
                            this.pbv.get().paI.ekP();
                            return;
                        }
                        return;
                    case 1011:
                        this.pbv.get().paD.setVisibility(4);
                        ChatInfo.mStatus = 12;
                        if (this.pbv.get().paI != null) {
                            this.pbv.get().paI.ekP();
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
        private final SoftReference<ActivityChat> pbv;

        private i(SoftReference<ActivityChat> softReference) {
            this.pbv = softReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbv.get() != null) {
                this.pbv.get().v(this.pbv.get().mPaid, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BIMManager.mediaSetRole(getActivity(), true);
        ekh();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        setContentView(a.g.bd_im_chat_activity_layout);
        this.mContainer = (LinearLayout) findViewById(a.f.bd_im_chat_root);
        this.pbc = new com.baidu.yuyinala.privatemessage.implugin.ui.a.a();
        ekj();
        init(getIntent());
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().isCuidLogin(this) || com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().ejN()) {
            this.paT = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    private void ejU() {
        this.pbf = System.currentTimeMillis();
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "loginOver loginState: " + loginState);
        if (this.paH != null) {
            this.paH.ekQ();
        }
        switch (loginState) {
            case 2:
                this.pbe.postDelayed(this.gdc, 7000L);
                ejW();
                return;
            case 3:
                this.pbe.postDelayed(this.gdc, ejV());
                this.paG.setVisibility(8);
                this.pbe.sendEmptyMessage(1009);
                return;
            default:
                this.pbe.postDelayed(this.gdc, 7000L);
                ejZ();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ejV() {
        long currentTimeMillis = 10000 - (System.currentTimeMillis() - this.pbf);
        if (currentTimeMillis > 7000) {
            return 7000L;
        }
        return currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejW() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "retryLogin timeout " + this.pbg);
        if (!this.pbg) {
            this.pbe.sendEmptyMessage(1010);
            com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().a(this, new b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.13
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
    public void ejX() {
        if (this.paH != null) {
            this.paH.AN(false);
        }
        if (this.paI != null) {
            this.paI.ekP();
        }
        this.paG.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejY() {
        if (this.paH != null) {
            this.paH.AN(false);
        }
    }

    private void ejZ() {
        this.pbe.sendEmptyMessage(1010);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus ");
        com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().a(this, new b.e() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.14
            @Override // com.baidu.android.imsdk.account.ILoginStateChangedListener
            public void onLoginStateChanged(int i2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "listenLoginStatus onLoginStateChanged state: " + i2);
                switch (i2) {
                    case 2:
                        ActivityChat.this.ejW();
                        return;
                    case 3:
                        ActivityChat.this.pbe.removeCallbacks(ActivityChat.this.gdc);
                        ActivityChat.this.pbe.postDelayed(ActivityChat.this.gdc, ActivityChat.this.ejV());
                        ActivityChat.this.pbe.sendEmptyMessage(1009);
                        return;
                    default:
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "waitting");
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eka() {
        if (this.klq > 8) {
            if (this.paJ == null) {
                this.paJ = (LinearLayout) findViewById(a.f.bd_im_chat_unread_msgs_layout);
                this.paK = (TextView) findViewById(a.f.bd_im_chat_unread_msgs_txt);
                this.paK.setText(this.klq + getString(a.h.bd_im_alert_unread_msgs));
            }
            this.paM = (ImageView) findViewById(a.f.bd_im_chat_unread_msgs_up);
            try {
                this.paJ.setBackgroundResource(ThemeManager.U(this, a.e.bd_im_chat_unread_msgs_background));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.paJ.setAnimation(AnimationUtils.loadAnimation(this, a.C0195a.bd_im_slip_in_from_right));
            this.paJ.setVisibility(0);
            this.paJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.paH.NE(ActivityChat.this.klq);
                    ActivityChat.this.paJ.setAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0195a.bd_im_slip_out_from_right));
                    ActivityChat.this.paJ.setVisibility(4);
                }
            });
            this.pbe.sendEmptyMessageDelayed(1001, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekb() {
        if (this.paL == null) {
            this.paL = (ImageView) findViewById(a.f.bd_im_chat_new_msgs_tip);
            this.paL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityChat.this.paH.ekF();
                    ActivityChat.this.paL.startAnimation(AnimationUtils.loadAnimation(ActivityChat.this, a.C0195a.bd_im_disappear_out));
                    ActivityChat.this.paL.setVisibility(4);
                }
            });
        }
        if (this.paL.getVisibility() != 0) {
            this.paL.startAnimation(AnimationUtils.loadAnimation(this, a.C0195a.bd_im_disappear_in));
            this.paL.setVisibility(0);
        }
        this.pbe.removeMessages(1003);
        this.pbe.sendEmptyMessageDelayed(1003, 10000L);
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
        switch (ChatInfo.oZq) {
            case GROUP:
                com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().setAllMsgRead(getApplicationContext(), 1, ChatInfo.mContacter, false);
                break;
            default:
                BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
                break;
        }
        try {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.elh();
            com.baidu.yuyinala.privatemessage.implugin.imagechooser.a.ejK();
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().c(this, th);
        }
        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elr().dismiss();
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "mChatCategory " + ChatInfo.oZq + " mOnlineStatus " + this.paZ);
        if (ChatInfo.oZq == ChatInfo.ChatCategory.C2C && this.paZ != null) {
            ekc();
        }
        if (this.paH != null) {
            this.paH.a((com.baidu.yuyinala.privatemessage.implugin.ui.activity.a) null);
        }
        if (this.paI != null) {
            this.paI.onDestroy();
        }
        if (this.paH != null) {
            this.paH.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i2) {
    }

    private void ekc() {
        Intent intent = new Intent(IMConstants.NOTICE_USER_STATE);
        intent.putExtra(IMConstants.NOTICE_USER_STATE_OBJECT, this.paZ);
        sendBroadcast(intent);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "noticeSessionState com.baidu.android.imsdk.notice.userstate");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onResume--->");
        super.onResume();
        com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().AJ(true);
        int loginState = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().getLoginState(this);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onResume mIsCuidOrIncompleteLogin: " + this.paT + " loginState: " + loginState);
        if (this.paT && (!com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().isCuidLogin(this) || !com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().ejN() || (loginState != 0 && loginState != 3))) {
            ejU();
        } else if (this.pba != null && this.pba.elp() && ChatInfo.ChatCategory.DUZHAN == ChatInfo.oZq) {
            v(this.mPaid, true);
        }
        if (this.paI != null) {
            this.paI.onResume();
        }
        if (this.paH != null) {
            this.paH.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStop--->");
        super.onStop();
        if (this.paI != null) {
            this.paI.onStop();
        }
        if (this.paH != null) {
            this.paH.onStop();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStop");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onStart--->");
        super.onStart();
        if (this.paI != null) {
            this.paI.onStart();
        }
        if (this.paH != null) {
            this.paH.onStart();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "<---onStart");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d(MAFragmentActivity.TAG, "onPause--->");
        super.onPause();
        com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().AJ(false);
        if (this.paI != null) {
            this.paI.onPause();
        }
        if (this.paH != null) {
            this.paH.onPause();
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
            this.aTp = ExtraParamsManager.getEncryptionUserId(extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phg));
            this.paR = extras.getBoolean("isMediaRole");
            this.mGroupId = extras.getString("groupid");
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("miliao", "mIsmediaRole：" + this.paR);
            this.mLiveId = extras.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            paS = this.paR;
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.phg, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phg));
            jSONObject.put("paid", extras.getString("paid"));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.phi, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phi));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.phk, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phk));
            jSONObject.put(com.baidu.yuyinala.privatemessage.implugin.util.d.phj, extras.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phj));
            String jSONObject2 = jSONObject.toString();
            try {
                if (!TextUtils.isEmpty(extras.getString("action"))) {
                    Serializable serializable = extras.getSerializable("params");
                    if (serializable instanceof ImBaseEntity) {
                        this.pbb = (ImBaseEntity) serializable;
                        if (this.paP == null) {
                            GroupInfo groupInfo = new GroupInfo(String.valueOf(this.pbb.id));
                            groupInfo.setGroupName(this.pbb.name);
                            groupInfo.setDescription(this.pbb.description);
                            groupInfo.setHeadUrl(this.pbb.headUrl);
                            this.paP = new QMGroupInfo(groupInfo);
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
        ekf();
        String aw = aw(intent);
        if (this.paD != null) {
            if (this.paR) {
                this.paD.setVisibility(8);
            } else {
                this.paD.setVisibility(0);
            }
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + aw);
        ChatInfo.mContacter = -1L;
        ChatInfo.oZs = -1L;
        ChatInfo.mAppid = -1L;
        ChatInfo.mUid = -1L;
        ChatInfo.oZt = "";
        ChatInfo.oZu = "";
        ChatInfo.oZv = -1;
        ChatInfo.oZz = 0;
        ChatInfo.oZC = true;
        ChatInfo.oZB = false;
        try {
            JSONObject jSONObject = new JSONObject(aw);
            int i2 = jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.phj) ? jSONObject.getInt(com.baidu.yuyinala.privatemessage.implugin.util.d.phj) : -1;
            if (i2 == -1) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "invoke error -1");
                return;
            }
            if (i2 == 80) {
                parseLong = Long.parseLong(jSONObject.optString("paid", "-1"));
            } else {
                parseLong = Long.parseLong(jSONObject.optString(com.baidu.yuyinala.privatemessage.implugin.util.d.phg, "-1"));
            }
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "invoke : " + aw);
            if (this.paW != -1 && (this.paW != i2 || this.paX != parseLong)) {
                if (this.paH != null) {
                    this.paH.ekQ();
                }
                if (this.pax != null) {
                    this.pax.setText("");
                }
            }
            this.paW = i2;
            switch (i2) {
                case 0:
                    ChatInfo.oZq = ChatInfo.ChatCategory.C2C;
                    try {
                        this.paQ = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phg));
                        ChatInfo.mUid = this.paQ;
                        eke();
                        this.mNickName = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phi);
                        this.mIcon = jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phk);
                        if (jSONObject.has(com.baidu.yuyinala.privatemessage.implugin.util.d.phm)) {
                            ChatInfo.oZC = jSONObject.getBoolean(com.baidu.yuyinala.privatemessage.implugin.util.d.phm);
                        }
                    } catch (Exception e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "init uid and name error");
                    }
                    this.paz.setVisibility(8);
                    this.mListenerKey = String.valueOf(this.paQ);
                    Yi(this.mNickName);
                    hY(this.paQ);
                    return;
                case 80:
                    ChatInfo.oZq = ChatInfo.ChatCategory.DUZHAN;
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
            com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().c(this, e3);
        }
    }

    private void eQ(JSONObject jSONObject) {
        try {
            this.mPaid = Long.parseLong(jSONObject.getString("paid"));
            ChatInfo.mPaid = this.mPaid;
            if (this.paR) {
                long parseLong = Long.parseLong(jSONObject.getString(com.baidu.yuyinala.privatemessage.implugin.util.d.phg));
                if (parseLong > 0) {
                    ChatInfo.mUid = parseLong;
                }
            }
            ekg();
        } catch (Exception e2) {
            LogUtils.e(MAFragmentActivity.TAG, "init appid error");
        }
        this.mListenerKey = String.valueOf(this.mPaid);
        hX(this.mPaid);
    }

    private void hX(long j2) {
        this.paz.setVisibility(8);
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
                    ActivityChat.this.pbe.post(ActivityChat.this.pbi);
                }
            });
        } else {
            this.pbe.post(this.pbi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class h implements Runnable {
        private final SoftReference<ActivityChat> pbw;

        private h(ActivityChat activityChat) {
            this.pbw = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbw.get() != null) {
                try {
                    ChatInfo.oZs = AccountManager.getUK(this.pbw.get().getApplicationContext());
                    this.pbw.get();
                    LogUtils.d(MAFragmentActivity.TAG, "parunnable ---> " + ChatInfo.oZs);
                    if (ChatInfo.oZs != -1) {
                        this.pbw.get().mChatStatus = 0;
                        this.pbw.get().ekd();
                        this.pbw.get();
                        LogUtils.d(MAFragmentActivity.TAG, "parunnable -->1");
                        ChatInfo.mContacter = this.pbw.get().mPaInfo.getPaId();
                        ChatInfo.mPainfo = this.pbw.get().mPaInfo;
                        if (ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN) {
                            this.pbw.get().klq = ChatMsgManager.getUnReadMsgCountByPaid(this.pbw.get(), this.pbw.get().mPaid);
                            if (this.pbw.get().klq > 200) {
                                this.pbw.get().klq = 200;
                            }
                        }
                        this.pbw.get().Uu();
                        this.pbw.get().v(this.pbw.get().mPaid, true);
                    } else {
                        this.pbw.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    this.pbw.get().paY = TextUtils.isEmpty(this.pbw.get().paY) ? this.pbw.get().mPaInfo.getNickName() : this.pbw.get().paY;
                    this.pbw.get().pax.setText(String.valueOf(this.pbw.get().paY));
                    this.pbw.get().eka();
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekd() {
        com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().a(getActivity(), new IGetUsersProfileBatchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.18
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2) {
                if (i2 == 0 && arrayList2 != null && arrayList2.size() == 1) {
                    ChatInfo.oZt = ActivityChat.this.Yk(arrayList2.get(0).getIconUrl());
                    ChatInfo.displayname = arrayList2.get(0).getUserName();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eke() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.b(ExtraParamsManager.getEncryptionUserId(ChatInfo.mUid + "")));
    }

    private static void ekf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031061, com.baidu.live.a.avJ + "ala/audio/user/preFollow");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void ekg() {
        MessageManager.getInstance().sendMessage(new com.baidu.yuyinala.privatemessage.model.http.a(ExtraParamsManager.getEncryptionUserId(this.mPaid + "")));
    }

    private void ekh() {
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
                        ActivityChat.this.eke();
                    }
                }
            }
        });
    }

    public boolean eki() {
        return this.paW == 2 || this.paW == 11;
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
        this.pau = (RelativeLayout) findViewById(a.f.bd_im_chat_title_root);
        this.pav = findViewById(a.f.bd_im_chat_cell_space_line);
        this.paw = (TextView) findViewById(a.f.bd_im_chat_open_main);
        this.paD = (LinearLayout) findViewById(a.f.bd_im_chat_open_main_click_parent);
        this.paD.setOnClickListener(this.pbj);
        this.paE = (RelativeLayout) findViewById(a.f.bd_im_chat_back_layout);
        this.paE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.onBackClick();
            }
        });
        this.pax = (TextView) findViewById(a.f.bd_im_chat_title);
        this.paz = (TextView) findViewById(a.f.bd_im_chat_subtitle);
        this.paA = findViewById(a.f.bd_im_chat_main_input);
        this.paB = (FrameLayout) findViewById(a.f.bd_im_chat_main_content);
        this.paC = (FrameLayout) findViewById(a.f.bd_im_chat_main_input);
        this.paF = (FrameLayout) findViewById(a.f.bd_im_chat_main_error_content);
        this.paN = (ImageView) findViewById(a.f.bd_im_chat_main_error_image);
        this.paF.setVisibility(8);
        this.paG = (FrameLayout) findViewById(a.f.bd_im_chat_main_retry_content);
        this.paG.setVisibility(8);
        findViewById(a.f.bd_im_chat_main_retry_button).setOnClickListener(this.pbh);
        this.pax.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityChat.this.ekn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uu() {
        if (this.paH == null) {
            FrameLayout frameLayout = this.paB;
            this.paB.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_chat, null));
            this.paH = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.a(this, this.paB, this.mListenerKey, this.pbd, this.klq);
        }
        if (this.paI == null) {
            FrameLayout frameLayout2 = this.paC;
            this.paC.addView(FrameLayout.inflate(this, a.g.bd_im_chat_fragment_input, null));
            this.paI = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.a(this, this.paC, this.mListenerKey, this.pbd);
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "initFragment : ");
        if (!isFinishing()) {
            try {
                com.baidu.yuyinala.privatemessage.implugin.util.c.i("ActivityChat", "mTransaction.commitAllowingStateLoss() : ");
            } catch (Exception e2) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, "e :" + e2);
                com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().c(this, e2);
            }
        }
        if (this.paH != null) {
            this.paH.a(this);
        }
        hZ(this.paQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void ekj() {
        this.paU = AnimationUtils.loadAnimation(this, a.C0195a.bd_im_fragment_in_from_bottom);
        this.paV = AnimationUtils.loadAnimation(this, a.C0195a.bd_im_fragment_out_to_bottom);
    }

    private void hY(long j2) {
        if (j2 == 0) {
            this.paO = null;
            showToast(a.h.bd_im_read_error);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j2));
        final SoftReference softReference = new SoftReference(this);
        com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().a(getApplicationContext(), arrayList, false, new b.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7
            @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
            public void onGetUsersProfileBatchResult(int i2, String str, ArrayList<Long> arrayList2, ArrayList<ChatUser> arrayList3) {
                if (softReference.get() != null) {
                    if (i2 != 0) {
                        ((ActivityChat) softReference.get()).pbe.post(ActivityChat.this.pbn);
                        return;
                    }
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        ((ActivityChat) softReference.get()).paO = arrayList3.get(0);
                    }
                    if (((ActivityChat) softReference.get()).paO == null) {
                        ((ActivityChat) softReference.get()).pbe.post(ActivityChat.this.pbm);
                        return;
                    }
                    ArrayList<Long> arrayList4 = new ArrayList<>();
                    arrayList4.add(Long.valueOf(ActivityChat.this.paO.getUk()));
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().a(ActivityChat.this.getApplicationContext(), arrayList4, new b.InterfaceC0966b() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat.7.1
                        @Override // com.baidu.android.imsdk.chatuser.IGetUserStatusListener
                        public void onGetUsersStatusResult(int i3, String str2, ArrayList<UserStatus> arrayList5) {
                            if (i3 == 0 && arrayList5.size() == 1) {
                                ((ActivityChat) softReference.get()).paZ = arrayList5.get(0);
                                ((ActivityChat) softReference.get()).pbe.post(ActivityChat.this.pbk);
                            }
                        }
                    });
                    ((ActivityChat) softReference.get()).pbe.post(ActivityChat.this.pbl);
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
                            ActivityChat.this.pbe.sendEmptyMessageDelayed(7, 1000L);
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
            com.baidu.yuyinala.privatemessage.implugin.e.a.hB(getApplicationContext()).hf("542", "chat_flow_time");
        } catch (Throwable th) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e(MAFragmentActivity.TAG, th.getMessage());
        }
    }

    protected void hZ(long j2) {
    }

    protected void ekk() {
    }

    public ImBaseEntity ekl() {
        return this.pbb;
    }

    protected void ekm() {
    }

    protected void Yi(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.pax.setText(str);
        } else if (this.mNickName != null) {
            this.pax.setText(String.valueOf(this.mNickName));
        } else if (this.paO != null) {
            this.pax.setText(String.valueOf(this.paO.getUserName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekn() {
        String liveId = getLiveId();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getActivity(), ChatInfo.mUid + "", null, null, null, 0, 0, null, null, 0L, 0L, 0L, 0, getGroupId(), liveId, false, null, null, null, null, null)));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
    }

    /* loaded from: classes11.dex */
    private static class l implements Runnable {
        private final SoftReference<ActivityChat> pbv;

        private l(ActivityChat activityChat) {
            this.pbv = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes11.dex */
    private static class k implements Runnable {
        private final SoftReference<ActivityChat> pbv;

        private k(ActivityChat activityChat) {
            this.pbv = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbv.get() != null) {
                try {
                    ChatInfo.oZs = AccountManager.getUK(this.pbv.get().getApplicationContext());
                    if (ChatInfo.oZs != -1) {
                        this.pbv.get().mChatStatus = 0;
                        this.pbv.get().eko();
                        this.pbv.get().Uu();
                        this.pbv.get().ia(this.pbv.get().paQ);
                    } else {
                        this.pbv.get().showToast(a.h.bd_im_zhida_login_error);
                    }
                    if (this.pbv.get().mNickName == null) {
                        if (this.pbv.get().paO != null) {
                            this.pbv.get().pax.setText(String.valueOf(this.pbv.get().paO.getUserName()));
                            return;
                        }
                        return;
                    }
                    this.pbv.get().pax.setText(String.valueOf(this.pbv.get().mNickName));
                } catch (Exception e) {
                    LogUtils.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(long j2) {
        if (Yj(String.valueOf(j2))) {
        }
    }

    private boolean Yj(String str) {
        String B = com.baidu.yuyinala.privatemessage.implugin.util.c.b.B(getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.phG, null);
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
    public void eko() {
        ekd();
        ChatInfo.mContacter = this.paO.getUk();
        ChatInfo.mUid = this.paO.getBuid();
        ChatInfo.mStatus = 3;
        ChatInfo.oZr = this.paO.getUserName();
        if (!TextUtils.isEmpty(this.mIcon)) {
            ChatInfo.oZu = this.mIcon;
        } else {
            ChatInfo.oZu = Yk(this.paO.getIconUrl());
        }
        BIMManager.setAllMsgRead(getApplicationContext(), 0, ChatInfo.mContacter, false);
        LogUtils.i(MAFragmentActivity.TAG, "uk:" + ChatInfo.oZs);
        LogUtils.i(MAFragmentActivity.TAG, "header:" + ChatInfo.oZt);
        LogUtils.i(MAFragmentActivity.TAG, "" + this.paO.toString());
    }

    /* loaded from: classes11.dex */
    private static class j implements Runnable {
        private final SoftReference<ActivityChat> pbv;

        private j(ActivityChat activityChat) {
            this.pbv = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbv.get() != null) {
                try {
                    ChatInfo.oZs = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().hx(this.pbv.get().getApplicationContext()).longValue();
                    this.pbv.get().mChatStatus = 0;
                    this.pbv.get().Uu();
                    if (this.pbv.get().mNickName != null) {
                        this.pbv.get().pax.setText(String.valueOf(this.pbv.get().mNickName));
                    }
                    this.pbv.get().pbe.sendEmptyMessage(1);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        private final SoftReference<ActivityChat> pbv;

        private a(ActivityChat activityChat) {
            this.pbv = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbv.get() != null) {
                try {
                    ChatInfo.oZs = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().hx(this.pbv.get().getApplicationContext()).longValue();
                    this.pbv.get().mChatStatus = 1;
                    this.pbv.get().Uu();
                    if (this.pbv.get().mNickName != null) {
                        this.pbv.get().pax.setText(String.valueOf(this.pbv.get().mNickName));
                    }
                    this.pbv.get().pbe.sendEmptyMessage(1006);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private final SoftReference<ActivityChat> pbv;

        private b(ActivityChat activityChat) {
            this.pbv = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbv.get() != null) {
                try {
                    ChatInfo.oZs = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().hx(this.pbv.get().getApplicationContext()).longValue();
                    String str = null;
                    if (this.pbv.get().paP != null) {
                        str = this.pbv.get().paP.mInfo.getGroupName();
                    }
                    if (ChatInfo.oZv == 2) {
                        if (str == null || "".equals(str.trim())) {
                            if (this.pbv.get().mNickName != null) {
                                this.pbv.get().pax.setText(String.valueOf(this.pbv.get().mNickName));
                                return;
                            } else if (this.pbv.get().paP != null) {
                                this.pbv.get().pax.setText(String.valueOf(str));
                                return;
                            } else {
                                return;
                            }
                        }
                        this.pbv.get().pax.setText(String.valueOf(str));
                    } else if (!TextUtils.isEmpty(str)) {
                        this.pbv.get().pax.setText(String.valueOf(str));
                        this.pbv.get().paz.setText(this.pbv.get().paP.mInfo.getNum() + "人");
                    } else if (!TextUtils.isEmpty(this.pbv.get().mNickName)) {
                        this.pbv.get().pax.setText(String.valueOf(this.pbv.get().mNickName));
                        this.pbv.get().paz.setText(this.pbv.get().paP.mInfo.getNum() + "人");
                    } else if (this.pbv.get().paP != null) {
                        this.pbv.get().pax.setText("未知群");
                        this.pbv.get().paz.setText(this.pbv.get().paP.mInfo.getNum() + "人");
                    }
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ActivityChat", "activity had destroyed");
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class d implements Runnable {
        private final SoftReference<ActivityChat> pbv;

        private d(ActivityChat activityChat) {
            this.pbv = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbv.get() != null) {
                try {
                    this.pbv.get().paA.setVisibility(0);
                    this.pbv.get().paA.startAnimation(this.pbv.get().paU);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class e implements Runnable {
        private final SoftReference<ActivityChat> pbv;

        private e(ActivityChat activityChat) {
            this.pbv = new SoftReference<>(activityChat);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pbv.get() != null) {
                try {
                    this.pbv.get().paA.setVisibility(8);
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
                ActivityChat.this.pbe.sendMessage(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ND(int i2) {
        String str;
        Date date;
        long j2 = -1;
        if (i2 == 1) {
            str = com.baidu.yuyinala.privatemessage.implugin.f.j.getType();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.baidu.yuyinala.privatemessage.implugin.f.j.ejQ())) {
                try {
                    j2 = Long.parseLong(com.baidu.yuyinala.privatemessage.implugin.f.j.ejQ());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.c.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.c.a.phL + ChatInfo.mPaid + ChatInfo.oZs, 0L));
            } else {
                return;
            }
        } else if (i2 == 0) {
            str = "ugc";
            j2 = this.paQ;
            date = new Date(com.baidu.yuyinala.privatemessage.implugin.util.c.b.f(this, com.baidu.yuyinala.privatemessage.implugin.util.c.a.phM + this.paQ, 0L));
        } else {
            str = null;
            date = null;
        }
        if (!com.baidu.yuyinala.privatemessage.implugin.util.f.c(date, new Date())) {
            if ((this.pba == null || !this.pba.elp() || this.pba.elq() != i2) && this.paH != null) {
                this.pba = this.paH.ao(i2, eki());
                if (this.pba != null) {
                    try {
                        this.pba.c(str, j2, new g(this, i2));
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
                    activityChat.ejT().sendMessage(message);
                } else if (this.flag == 0) {
                    Message message2 = new Message();
                    if (z) {
                        message2.arg1 = 0;
                    } else {
                        message2.arg1 = -1;
                    }
                    message2.what = 8;
                    activityChat.ejT().sendMessage(message2);
                }
            }
        }
    }

    public void onBackClick() {
        if (this.mChatStatus == 0) {
            if (this.paI != null) {
                this.paI.ekV();
            }
            if (this.pba != null) {
                this.pba.elo();
            }
        }
        finish();
        if (!ChatInfo.oZC) {
            com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().hA(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Yk(String str) {
        return str;
    }
}
