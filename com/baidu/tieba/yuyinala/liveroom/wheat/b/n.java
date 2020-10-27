package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.j;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaEndConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaOnLineHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatLayout;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n {
    private static n nXj = new n();
    private boolean aWc;
    private w alaLiveShowData;
    private Activity mActivity;
    private BroadcastReceiver mBroadcastReceiver;
    private TbPageContext nVE;
    private AlaLiveRoomBlurPageLayout nXf;
    private WheatLayout nXg;
    private com.baidu.live.aj.a nXh;
    private boolean nXi;
    private int nXk;
    private boolean nXl;
    private boolean nXm;
    private com.baidu.tieba.yuyinala.liveroom.wheat.c.j nXo;
    private com.baidu.tieba.yuyinala.player.b nXp;
    private boolean nXq;
    private long nXr;
    private List<AlaWheatInfoData> nXa = new ArrayList();
    private List<AlaWheatInfoData> nXb = new ArrayList();
    private List<AlaWheatInfoData> nXc = new ArrayList();
    private List<AlaWheatInfoData> nXd = new ArrayList();
    private Set<String> nXe = new HashSet();
    private long nXn = 10000;
    com.baidu.live.aj.c nXs = new com.baidu.live.aj.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.15
        @Override // com.baidu.live.aj.c
        public boolean UI() {
            return n.this.UI();
        }

        @Override // com.baidu.live.aj.c
        public boolean iI(String str) {
            return n.this.iI(str);
        }

        @Override // com.baidu.live.aj.c
        public boolean iJ(String str) {
            return n.this.iJ(str);
        }

        @Override // com.baidu.live.aj.c
        public boolean iK(String str) {
            return n.this.iK(str);
        }

        @Override // com.baidu.live.aj.c
        public AlaWheatInfoData iL(String str) {
            return n.this.iL(str);
        }

        @Override // com.baidu.live.aj.c
        public AlaWheatInfoData UJ() {
            return n.this.UJ();
        }

        @Override // com.baidu.live.aj.c
        public void F(String str, boolean z) {
            n.this.F(str, z);
        }

        @Override // com.baidu.live.aj.c
        public boolean iM(String str) {
            return n.this.iM(str);
        }

        @Override // com.baidu.live.aj.c
        public void a(com.baidu.live.aj.a aVar) {
            n.this.a(aVar);
        }

        @Override // com.baidu.live.aj.c
        public List<AlaWheatInfoData> UK() {
            return n.this.UK();
        }

        @Override // com.baidu.live.aj.c
        public List<AlaWheatInfoData> UL() {
            return n.this.UL();
        }

        @Override // com.baidu.live.aj.c
        public String UM() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().UM();
        }

        @Override // com.baidu.live.aj.c
        public String UN() {
            return n.this.UN();
        }

        @Override // com.baidu.live.aj.c
        public String getCustomRoomId() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().getCustomRoomId();
        }

        @Override // com.baidu.live.aj.c
        public w UO() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().UO();
        }

        @Override // com.baidu.live.aj.c
        public String UP() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().UP();
        }

        @Override // com.baidu.live.aj.c
        public void muteOrUnmuteAudio(boolean z) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX() != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().muteOrUnmuteAudio(z);
            }
        }

        @Override // com.baidu.live.aj.c
        public void UQ() {
            n.this.yV(false);
        }

        @Override // com.baidu.live.aj.c
        public void UR() {
            n.this.dWI();
        }
    };
    private CustomMessageListener aZd = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                n.this.V((w) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener nXt = new CustomMessageListener(2501009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501009) {
                if (customResponsedMessage.getData() == null) {
                    n.this.dWC();
                } else if ((customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).contains(Headers.REFRESH)) {
                    n.this.dWD();
                }
            }
        }
    };
    private CustomMessageListener nXu = new CustomMessageListener(2501022) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501022 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = (String) hashMap.get("user_uk");
                String str2 = (String) hashMap.get("webp_url");
                String str3 = (String) hashMap.get("result_url");
                if (n.this.nXp != null && !n.this.nXp.dWO()) {
                    n.this.nXg.aM(str, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener nXv = new CustomMessageListener(2501023) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501023 && customResponsedMessage.getData() != null) {
                n.this.dWC();
            }
        }
    };
    private CustomMessageListener nXw = new CustomMessageListener(2501024) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501024 && customResponsedMessage.getData() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().Vl(str).BO();
                }
            }
        }
    };
    private CustomMessageListener nXx = new CustomMessageListener(2501026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501026 && customResponsedMessage.getData() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        final int optInt = jSONObject.optInt("status");
                        final String optString = jSONObject.optString("uk");
                        final String optString2 = jSONObject.optString("room_id");
                        boolean optBoolean = jSONObject.optBoolean("isLocalData", false);
                        if (optBoolean || (!optBoolean && !n.this.Vd(optString))) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.11.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (TextUtils.equals(optString2, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa())) {
                                        if (optInt == 1) {
                                            n.this.nXg.Vy(optString);
                                        } else {
                                            n.this.nXg.Vz(optString);
                                        }
                                    }
                                }
                            });
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    public static n dWB() {
        return nXj;
    }

    private n() {
    }

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.nXa.clear();
        this.nXb.clear();
        this.nXc.clear();
        this.nXd.clear();
        this.nXe.clear();
        this.nXi = false;
        this.nXk = 0;
        this.nXl = false;
        this.nXm = false;
        this.mActivity = tbPageContext.getPageActivity();
        this.nVE = tbPageContext;
        this.nXf = alaLiveRoomBlurPageLayout;
        this.nXg = new WheatLayout(this.mActivity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.nXf.d(this.nXg, layoutParams);
        this.nXg.setOnItemClickListener(new WheatLayout.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatLayout.a
            public void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i) {
                n.this.ao(z ? 0 : i + 1, alaWheatInfoData != null);
                n.this.nXk = i;
                n.this.a(alaWheatInfoData, z ? f.nWu : f.nWv);
            }
        });
        registerListener();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().aA(this.mActivity).f(this.nVE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(int i, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w UO = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().UO();
            if (UO != null && UO.aIS != null) {
                jSONObject.put("live_id", UO.aIS.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, UO.aIS.croom_id);
            }
            jSONObject.put("loc", i);
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, z ? "occupy" : SchemeCollecter.CLASSIFY_EMPTY);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "micpos_clk").setContentExt(jSONObject));
    }

    private void registerListener() {
        onDestroy();
        com.baidu.live.aj.b.UH().a(this.nXs);
        MessageManager.getInstance().registerListener(this.nXt);
        MessageManager.getInstance().registerListener(this.aZd);
        MessageManager.getInstance().registerListener(this.nXx);
        MessageManager.getInstance().registerListener(this.nXw);
        MessageManager.getInstance().registerListener(this.nXv);
        MessageManager.getInstance().registerListener(this.nXu);
        dWM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaWheatInfoData alaWheatInfoData, int i) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mActivity);
        } else if (alaWheatInfoData == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501010, Integer.valueOf(i)));
        } else {
            w UO = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().UO();
            if (UO != null && UO.aIA != null && UO.mLiveInfo != null) {
                AlaLiveUserInfoData alaLiveUserInfoData = UO.aIA;
                if (TextUtils.equals(alaWheatInfoData.uk, alaLiveUserInfoData.userUk)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.nVE.getPageActivity(), ExtraParamsManager.getDecryptUserId(alaLiveUserInfoData.userUk), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, null, null, 0L, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaLiveUserInfoData.userStatus, Long.toString(UO.mLiveInfo.group_id), Long.toString(UO.mLiveInfo.live_id), false, null, null, alaLiveUserInfoData.nickName, "")));
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501011, alaWheatInfoData.uk));
            }
        }
    }

    public void dWC() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
    }

    public AlaWheatInfoData UJ() {
        w UO = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().UO();
        if (UO == null || UO.mLiveInfo == null) {
            return null;
        }
        AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
        alaWheatInfoData.uk = UO.mLiveInfo.user_uk;
        alaWheatInfoData.userName = UO.mLiveInfo.user_name;
        alaWheatInfoData.portrait = UO.mLiveInfo.user_avatar;
        return alaWheatInfoData;
    }

    public void F(String str, boolean z) {
        if (this.nXe != null) {
            if (z) {
                if (!this.nXe.contains(str)) {
                    this.nXe.add(str);
                    return;
                }
                return;
            }
            this.nXe.remove(str);
        }
    }

    public boolean iM(String str) {
        return this.nXe != null && this.nXe.contains(str);
    }

    public void D(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        this.nXm = false;
        this.nXa.clear();
        this.nXb.clear();
        this.nXc.clear();
        this.nXd.clear();
        this.nXc.addAll(list);
        this.nXd.addAll(list2);
        if (!ListUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                AlaWheatInfoData alaWheatInfoData = list.get(i);
                if (alaWheatInfoData != null) {
                    this.nXm = true;
                    alaWheatInfoData.realWheatPosition = i;
                    this.nXa.add(alaWheatInfoData);
                }
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null) {
                    this.nXm = true;
                    alaWheatInfoData2.realWheatPosition = i2 + 1;
                    this.nXb.add(alaWheatInfoData2);
                }
            }
        }
        dWD();
        if (this.nXh != null) {
            this.nXh.UG();
        }
        if (dWL()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501068));
        }
        this.aWc = false;
        startPlayer();
    }

    private void startPlayer() {
        boolean z = true;
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.nTZ) {
            Log.i("AudioRoom", "isFirstEnterLiveRoom" + this.aWc + "  havePersonOnWheat:" + this.nXm + "  isOnWheat(getCurrentUserUK())" + iI(UN()));
        }
        if (!this.aWc && this.nXm && !iI(UN())) {
            final com.baidu.tieba.yuyinala.liveroom.wheat.a.b dVX = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.nTZ) {
                StringBuilder append = new StringBuilder().append("am != null").append(dVX != null).append("  am.isPlayerPlaying():");
                if (dVX == null || dVX.dVJ()) {
                    z = false;
                }
                Log.i("AudioRoom", append.append(z).toString());
            }
            if (dVX != null && !dVX.dVJ()) {
                if (this.nXo == null) {
                    this.nXo = new com.baidu.tieba.yuyinala.liveroom.wheat.c.j(null, new j.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.12
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.j.a
                        public void a(AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage) {
                            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.nTZ) {
                                Log.i("AudioRoom", "resp.isSuccess()" + alaOnLineHttpResponseMessage.isSuccess() + "  resp.isOnline():" + alaOnLineHttpResponseMessage.isOnline());
                            }
                            if (alaOnLineHttpResponseMessage.isSuccess() && !alaOnLineHttpResponseMessage.isOnline() && dVX != null) {
                                dVX.dVR();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.j.a
                        public void onFail(int i, String str) {
                        }
                    });
                }
                this.nXo.request();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dWD() {
        try {
            if (this.nXg != null) {
                if (BdUtilHelper.isMainThread()) {
                    this.nXg.E(this.nXc, this.nXd);
                } else {
                    this.nXg.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.14
                        @Override // java.lang.Runnable
                        public void run() {
                            n.this.nXg.E(n.this.nXc, n.this.nXd);
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WheatLayout dWE() {
        return this.nXg;
    }

    public List<AlaWheatInfoData> UL() {
        return this.nXa;
    }

    public List<AlaWheatInfoData> UK() {
        return this.nXb;
    }

    public void dWF() {
        if (dWd() && this.alaLiveShowData != null && this.alaLiveShowData.mLiveInfo != null && this.alaLiveShowData.mLiveInfo.apply_count > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("count", this.alaLiveShowData.mLiveInfo.apply_count);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", jSONObject);
                jSONObject2.toString();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, jSONObject2.toString()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(com.baidu.live.aj.a aVar) {
        this.nXh = aVar;
    }

    public boolean isHost() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            return false;
        }
        String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        return (TextUtils.isEmpty(encryptionUserId) || dWd() || !iK(encryptionUserId)) ? false : true;
    }

    public boolean dWd() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return iJ(ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean iJ(String str) {
        return (this.alaLiveShowData == null || this.alaLiveShowData.mLiveInfo == null || str == null || !TextUtils.equals(str, this.alaLiveShowData.mLiveInfo.user_uk)) ? false : true;
    }

    public boolean Vd(String str) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return TextUtils.equals(str, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public String UN() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        }
        return null;
    }

    public boolean iI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (iK(str)) {
            return true;
        }
        return Vt(str);
    }

    public boolean iK(String str) {
        List<AlaWheatInfoData> UL = UL();
        for (int i = 0; i < ListUtils.getCount(UL); i++) {
            AlaWheatInfoData alaWheatInfoData = UL.get(i);
            if (alaWheatInfoData != null && str.equals(alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public boolean Vt(String str) {
        List<AlaWheatInfoData> UK = UK();
        for (int i = 0; i < ListUtils.getCount(UK); i++) {
            AlaWheatInfoData alaWheatInfoData = UK.get(i);
            if (alaWheatInfoData != null && str.equals(alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    private void dWG() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dVX = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX();
        if (dVX != null) {
            if (dWd()) {
                if (dVX.dVT() && dVX.dVQ() && !iI(UN())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.16
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dVX2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX();
                            if (dVX2.dVT() && dVX2.dVQ() && !n.this.iI(n.this.UN())) {
                                dVX2.Vi(dVX2.getRoomId());
                                n.this.dWH();
                            }
                        }
                    }, this.nXn);
                } else if (dVX.dVT() && !dVX.dVQ() && !iI(UN())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.17
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dVX2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX();
                            if (dVX2.dVT() && !dVX2.dVQ() && !n.this.iI(n.this.UN())) {
                                dVX2.dVN();
                            }
                        }
                    }, this.nXn);
                } else if (!dVX.dVT() && dVX.dVQ() && iI(UN())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.18
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dVX2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX();
                            if (!dVX2.dVT() && dVX2.dVQ() && n.this.iI(n.this.UN())) {
                                n.this.UQ();
                            }
                        }
                    }, this.nXn);
                } else if (!dVX.dVT() && !dVX.dVQ() && iI(UN())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.19
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dVX2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX();
                            if (!dVX2.dVT() && !dVX2.dVQ() && n.this.iI(n.this.UN())) {
                                n.this.UQ();
                                dVX2.dVN();
                            }
                        }
                    }, this.nXn);
                } else if (dVX.dVT() && dVX.dVQ() && iI(UN())) {
                    dVX.axM();
                }
            } else if (dVX.dVQ() && !iI(UN())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.20
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dVX2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX();
                        if (dVX2 != null && dVX2.dVQ() && !n.this.iI(n.this.UN())) {
                            dVX2.Vi(dVX2.getRoomId());
                            n.this.dWH();
                        }
                    }
                }, this.nXn);
            } else if (!dVX.dVQ() && ((dVX.dVH() == 0 || dVX.dVH() == 4 || dVX.dVH() == 3) && iI(UN()))) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dVX2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX();
                        if (!dVX2.dVQ()) {
                            if ((dVX2.dVH() == 0 || dVX2.dVH() == 4 || dVX2.dVH() == 3) && n.this.iI(n.this.UN())) {
                                n.this.UQ();
                            }
                        }
                    }
                }, this.nXn);
            } else if (dVX.dVQ() && iI(UN()) && dVX.dVJ()) {
                dVX.axM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWH() {
        if (!dWd()) {
            e.dWm().onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501071));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWI() {
        new com.baidu.tieba.yuyinala.liveroom.wheat.c.d(this.nVE, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void onFail(int i, String str) {
            }
        }).gN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa(), "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UQ() {
        yV(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yV(boolean z) {
        String str;
        if (z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dVX = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX();
            if (dVX != null) {
                String dVU = dVX.dVU();
                if (dWd()) {
                    str = dVU + ",isOwnerJoinChat:" + dVX.dVT() + ",mIsSelfInRctRoom:" + dVX.dVQ() + ",isOwner:true";
                } else {
                    str = dVU + ",mIsSelfInRctRoom:" + dVX.dVQ() + ",getRtcStatus:" + dVX.dVH() + ",isOwner:false";
                }
                int length = str.length();
                if (str != null && length > 1900) {
                    str = str.substring(length - 1900, length);
                }
            } else {
                str = null;
            }
            new com.baidu.tieba.yuyinala.liveroom.wheat.c.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.4
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.e.a
                public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
                    n.this.dWH();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.e.a
                public void onFail(int i, String str2) {
                }
            }).a(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa(), dWB().UN(), 1, str);
            return;
        }
        new com.baidu.tieba.yuyinala.liveroom.wheat.c.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.e.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.e.a
            public void onFail(int i, String str2) {
            }
        }).gN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa(), dWB().UN());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(w wVar) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dVX;
        if (wVar != null && wVar.aIW != null) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = new AlaWheatInfoDataWrapper(wVar.aIW);
            D(alaWheatInfoDataWrapper.getHostWheatLists(), alaWheatInfoDataWrapper.getAnchorWheatLists());
            if (this.nXq) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.nXr > 100 && currentTimeMillis - this.nXr < 5000) {
                    if (iI(UN())) {
                        if (dWd()) {
                            com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("connection_wheat_succ_host_5", true);
                        } else {
                            com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("connection_wheat_succ_anchor_8", false);
                        }
                        this.nXq = false;
                    }
                } else {
                    this.nXq = false;
                }
            }
            dWG();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.nTZ && (dVX = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX()) != null) {
                Log.i("AudioRoom", "getLogInfo: " + dVX.dVU());
            }
        }
    }

    public AlaWheatInfoData iL(String str) {
        if (this.nXg != null) {
            return this.nXg.iL(str);
        }
        return null;
    }

    public AlaWheatInfoData Vu(String str) {
        if (this.nXg != null) {
            return this.nXg.Vu(str);
        }
        return null;
    }

    public void setMaskBg(boolean z) {
        if (this.nXg != null) {
            this.nXg.setMaskBg(z);
        }
    }

    public void setVisible(boolean z) {
        if (this.nXg != null) {
            this.nXg.setVisibility(z ? 0 : 8);
        }
    }

    public int dWJ() {
        return this.nXk;
    }

    public TbPageContext dWK() {
        return this.nVE;
    }

    public boolean UI() {
        return this.nXi;
    }

    public void yW(boolean z) {
        this.nXi = z;
    }

    public boolean dWL() {
        return this.nXl;
    }

    public void yX(boolean z) {
        this.nXl = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.nXt);
        MessageManager.getInstance().unRegisterListener(this.nXu);
        MessageManager.getInstance().unRegisterListener(this.nXw);
        MessageManager.getInstance().unRegisterListener(this.nXx);
        MessageManager.getInstance().unRegisterListener(this.nXv);
        MessageManager.getInstance().unRegisterListener(this.aZd);
        dWN();
        if (this.nXo != null) {
            this.nXo.onDestroy();
            this.nXo = null;
        }
    }

    public void m(w wVar) {
        this.alaLiveShowData = wVar;
        this.aWc = true;
        if ((wVar == null || wVar.mLiveInfo == null || wVar.mLiveInfo.live_status != 2) && this.nXg != null && this.nXg.getVisibility() != 0) {
            setVisible(true);
        }
        V(wVar);
        dWF();
        registerListener();
    }

    public void CT() {
        this.nXa.clear();
        this.nXb.clear();
        this.nXc.clear();
        this.nXd.clear();
        this.nXe.clear();
        this.nXi = false;
        this.nXk = 0;
        this.nXl = false;
        this.nXm = false;
        dWB().setVisible(false);
        onDestroy();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().onDestroy();
    }

    private void dWM() {
        if (this.nVE != null && this.nVE.getPageActivity() != null) {
            this.mBroadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.n.13
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (TextUtils.equals(intent.getAction(), "com.baidu.open.log.debug")) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a.nTZ = true;
                        com.baidu.tieba.yuyinala.liveroom.wheat.d.d.nTZ = true;
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.open.log.debug");
            this.nVE.getPageActivity().registerReceiver(this.mBroadcastReceiver, intentFilter);
        }
    }

    private void dWN() {
        if (this.nVE != null && this.nVE.getPageActivity() != null && this.mBroadcastReceiver != null) {
            this.nVE.getPageActivity().unregisterReceiver(this.mBroadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.nXp = bVar;
    }

    public void yY(boolean z) {
        this.nXq = z;
        this.nXr = System.currentTimeMillis();
    }

    public boolean dWO() {
        if (this.nXp != null) {
            return this.nXp.dWO();
        }
        return false;
    }
}
