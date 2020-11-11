package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaEndConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.e;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    private static o oez = new o();
    private BroadcastReceiver mBroadcastReceiver;
    private Rect mRect;
    private TbPageContext ocV;
    private com.baidu.tieba.yuyinala.liveroom.wheat.d.a oeA;
    private AlaLiveRoomBlurPageLayout oeB;
    private com.baidu.tieba.yuyinala.player.b oeD;
    private boolean oeE;
    private long oeF;
    private boolean oeG;
    private a oeH;
    private long oeC = 10000;
    private CustomMessageListener baw = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                w wVar = (w) customResponsedMessage.getData();
                if (o.this.ah(wVar)) {
                    if (o.this.oeA != null) {
                        ViewGroup dZC = o.this.oeA.dZC();
                        if (dZC != null && dZC.getParent() != null) {
                            ((ViewGroup) dZC.getParent()).removeView(dZC);
                        }
                        o.this.oeA.onDestroy();
                        o.this.oeA = null;
                        return;
                    }
                    return;
                }
                if (o.this.af(wVar)) {
                    o.this.ag(wVar);
                } else if (o.this.oeA != null) {
                    o.this.oeA.ai(wVar);
                }
                o.this.dZJ();
            }
        }
    };
    private CustomMessageListener oeI = new CustomMessageListener(2501009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501009) {
                if (customResponsedMessage.getData() == null) {
                    if (o.this.oeA != null) {
                        o.this.oeA.loadData();
                    }
                } else if ((customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).contains(Headers.REFRESH) && o.this.oeA != null) {
                    o.this.oeA.ear();
                }
            }
        }
    };
    private CustomMessageListener oeJ = new CustomMessageListener(2501022) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501022 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = (String) hashMap.get("user_uk");
                String str2 = (String) hashMap.get("webp_url");
                String str3 = (String) hashMap.get("result_url");
                if (o.this.oeA != null) {
                    o.this.oeA.aM(str, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener oeK = new CustomMessageListener(2501024) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501024 && customResponsedMessage.getData() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().VC(str).Ce();
                }
            }
        }
    };
    private CustomMessageListener oeL = new CustomMessageListener(2501026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.15
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
                        if (optBoolean || (!optBoolean && !o.this.Vu(optString))) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.15.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (TextUtils.equals(optString2, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca())) {
                                        if (optInt == 1) {
                                            if (o.this.oeA != null) {
                                                o.this.oeA.VY(optString);
                                            }
                                        } else if (o.this.oeA != null) {
                                            o.this.oeA.VZ(optString);
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
    private CustomMessageListener oeM = new CustomMessageListener(2501023) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501023 && customResponsedMessage.getData() != null && o.this.oeA != null) {
                o.this.oeA.loadData();
            }
        }
    };
    com.baidu.live.al.c oeN = new com.baidu.live.al.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.17
        @Override // com.baidu.live.al.c
        public boolean isApplying() {
            if (o.this.oeA != null) {
                return o.this.oeA.isApplying();
            }
            return false;
        }

        @Override // com.baidu.live.al.c
        public boolean iV(String str) {
            if (o.this.oeA != null) {
                return o.this.oeA.iV(str);
            }
            return false;
        }

        @Override // com.baidu.live.al.c
        public boolean iW(String str) {
            if (o.this.oeA != null) {
                return o.this.oeA.iW(str);
            }
            return false;
        }

        @Override // com.baidu.live.al.c
        public boolean iX(String str) {
            if (o.this.oeA != null) {
                return o.this.oeA.iX(str);
            }
            return false;
        }

        @Override // com.baidu.live.al.c
        public AlaWheatInfoData iY(String str) {
            if (o.this.oeA != null) {
                return o.this.oeA.VX(str);
            }
            return null;
        }

        @Override // com.baidu.live.al.c
        public AlaWheatInfoData Xi() {
            if (o.this.oeA != null) {
                return o.this.oeA.Xi();
            }
            return null;
        }

        @Override // com.baidu.live.al.c
        public void F(String str, boolean z) {
            if (o.this.oeA != null) {
                o.this.oeA.F(str, z);
            }
        }

        @Override // com.baidu.live.al.c
        public boolean iZ(String str) {
            if (o.this.oeA != null) {
                return o.this.oeA.iZ(str);
            }
            return false;
        }

        @Override // com.baidu.live.al.c
        public void a(com.baidu.live.al.a aVar) {
            if (o.this.oeA != null) {
                o.this.oeA.a(aVar);
            }
        }

        @Override // com.baidu.live.al.c
        public List<AlaWheatInfoData> Xj() {
            if (o.this.oeA != null) {
                return o.this.oeA.Xj();
            }
            return null;
        }

        @Override // com.baidu.live.al.c
        public List<AlaWheatInfoData> Xk() {
            if (o.this.oeA != null) {
                return o.this.oeA.Xk();
            }
            return null;
        }

        @Override // com.baidu.live.al.c
        public String Xl() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Xl();
        }

        @Override // com.baidu.live.al.c
        public String Xm() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Xm();
        }

        @Override // com.baidu.live.al.c
        public String getCustomRoomId() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().getCustomRoomId();
        }

        @Override // com.baidu.live.al.c
        public w Xn() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Xn();
        }

        @Override // com.baidu.live.al.c
        public String Xo() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Xo();
        }

        @Override // com.baidu.live.al.c
        public void muteOrUnmuteAudio(boolean z) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN() != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().muteOrUnmuteAudio(z);
            }
        }

        @Override // com.baidu.live.al.c
        public void Xp() {
            o.this.zg(false);
        }

        @Override // com.baidu.live.al.c
        public void Xq() {
            o.this.dZI();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void LX(int i);
    }

    public static o dZA() {
        return oez;
    }

    private o() {
    }

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mRect = rect;
        this.ocV = tbPageContext;
        this.oeB = alaLiveRoomBlurPageLayout;
    }

    public void dZB() {
        if (this.oeA != null) {
            this.oeA.loadData();
        }
    }

    public ViewGroup dZC() {
        if (this.oeA != null) {
            return this.oeA.dZC();
        }
        return null;
    }

    public List<AlaWheatInfoData> Xk() {
        if (this.oeA != null) {
            return this.oeA.Xk();
        }
        return null;
    }

    public List<AlaWheatInfoData> Xj() {
        if (this.oeA != null) {
            return this.oeA.Xj();
        }
        return null;
    }

    public boolean dZD() {
        if (this.oeA != null) {
            return this.oeA.dZD();
        }
        return false;
    }

    public boolean dYS() {
        if (this.oeA != null) {
            return this.oeA.dYS();
        }
        return false;
    }

    public boolean iW(String str) {
        if (this.oeA != null) {
            return this.oeA.iW(str);
        }
        return false;
    }

    public boolean Vu(String str) {
        if (this.oeA != null) {
            return this.oeA.Vu(str);
        }
        return false;
    }

    public String Xm() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Xm();
    }

    public boolean iV(String str) {
        if (this.oeA != null) {
            return this.oeA.iV(str);
        }
        return false;
    }

    public boolean iX(String str) {
        if (this.oeA != null) {
            return this.oeA.iX(str);
        }
        return false;
    }

    public boolean VQ(String str) {
        if (this.oeA != null) {
            return this.oeA.VQ(str);
        }
        return false;
    }

    public AlaWheatInfoData iY(String str) {
        if (this.oeA != null) {
            return this.oeA.iY(str);
        }
        return null;
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        if (this.oeA != null) {
            return this.oeA.bi(str, z);
        }
        return null;
    }

    public int dZE() {
        if (this.oeA != null) {
            return this.oeA.dZE();
        }
        return -1;
    }

    public TbPageContext dZF() {
        if (this.oeA != null) {
            return this.oeA.dZF();
        }
        return null;
    }

    public boolean isApplying() {
        if (this.oeA != null) {
            return this.oeA.isApplying();
        }
        return false;
    }

    public void setMaskBg(boolean z) {
        if (this.oeA != null) {
            this.oeA.setMaskBg(z);
        }
    }

    public void zd(boolean z) {
        if (this.oeA != null) {
            this.oeA.zd(z);
        }
    }

    public void ze(boolean z) {
        if (this.oeA != null) {
            this.oeA.ze(z);
        }
    }

    public void l(w wVar) {
        if (wVar != null && wVar.aJP != null) {
            wVar.aJP.isEnterLiveData = true;
            ad(wVar);
            if (this.oeA != null) {
                this.oeA.a(this.oeD);
                this.oeA.l(wVar);
            }
            registerListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(w wVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aJP;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            if (this.oeA == null || !(this.oeA instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
                this.oeA = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
                this.oeA.a(this.ocV, this.oeB, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            if (this.oeA == null || !(this.oeA instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c)) {
                this.oeA = new com.baidu.tieba.yuyinala.liveroom.wheat.d.c();
                this.oeA.a(this.ocV, this.oeB, this.mRect);
            }
        } else if (this.oeA == null || !(this.oeA instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
            this.oeA = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
            this.oeA.a(this.ocV, this.oeB, this.mRect);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if ((r4.oeA instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
        if ((r4.oeA instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean ae(w wVar) {
        boolean z = true;
        if (wVar.aKb) {
            wVar.aKb = false;
            return false;
        } else if (dZG()) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aJP;
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.oeA != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                if (this.oeA != null) {
                }
                z = false;
            } else {
                z = false;
            }
            return z;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean af(w wVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aJP;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            return this.oeA == null || !(this.oeA instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            return this.oeA == null || !(this.oeA instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c);
        } else {
            return false;
        }
    }

    private boolean dZG() {
        if (com.baidu.live.aa.a.PQ().bod == null || com.baidu.live.aa.a.PQ().bod.aNy == null || com.baidu.live.aa.a.PQ().bod.aNy.aQG == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.dZW().a(com.baidu.live.aa.a.PQ().bod.aNy.aQG.ES(), true);
    }

    public void Dm() {
        if (this.oeA != null) {
            this.oeA.Dm();
        }
        onDestroy();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().onDestroy();
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oeD = bVar;
    }

    public void zf(boolean z) {
        if (this.oeA != null) {
            this.oeA.zf(z);
        }
    }

    public boolean dZH() {
        if (this.oeA != null) {
            return this.oeA.dZH();
        }
        return false;
    }

    private void registerListener() {
        onDestroy();
        MessageManager.getInstance().registerListener(this.baw);
        com.baidu.live.al.b.Xh().a(this.oeN);
        MessageManager.getInstance().registerListener(this.oeI);
        MessageManager.getInstance().registerListener(this.oeL);
        MessageManager.getInstance().registerListener(this.oeK);
        MessageManager.getInstance().registerListener(this.oeM);
        MessageManager.getInstance().registerListener(this.oeJ);
        dZL();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.baw);
        MessageManager.getInstance().unRegisterListener(this.oeI);
        MessageManager.getInstance().unRegisterListener(this.oeJ);
        MessageManager.getInstance().unRegisterListener(this.oeK);
        MessageManager.getInstance().unRegisterListener(this.oeL);
        MessageManager.getInstance().unRegisterListener(this.oeM);
        dZM();
        if (this.oeA != null) {
            this.oeA.onDestroy();
        }
    }

    public void cFz() {
        if (this.oeA != null) {
            this.oeA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(final w wVar) {
        final int i;
        if (this.oeA instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_common_mode_text)).show();
            i = 0;
        } else if (this.oeA instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_dating_mode_text)).show();
            i = 1;
        } else {
            i = 0;
        }
        if (ae(wVar)) {
            if (System.currentTimeMillis() - this.oeF > 1000) {
                this.oeF = System.currentTimeMillis();
                this.oeG = true;
                View view = null;
                if (this.ocV != null && this.ocV.getPageActivity() != null) {
                    view = this.ocV.getPageActivity().findViewById(a.f.ala_liveroom_view);
                }
                if (view != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.dZW().cV((ViewGroup) view);
                }
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.11
                    @Override // java.lang.Runnable
                    public void run() {
                        o.this.ad(wVar);
                        if (o.this.oeA != null) {
                            o.this.oeA.ai(wVar);
                        }
                        if (o.this.oeH != null) {
                            o.this.oeH.LX(i);
                        }
                        o.this.oeG = false;
                    }
                }, 1500L);
                return;
            }
            return;
        }
        ad(wVar);
        if (this.oeA != null) {
            this.oeA.ai(wVar);
        }
        if (this.oeH != null) {
            this.oeH.LX(i);
        }
    }

    public void a(a aVar) {
        this.oeH = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZI() {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(this.ocV, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.18
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
            public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
            public void onFail(int i, String str) {
            }
        }).gP(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca(), "1");
    }

    public void dZJ() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYN = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN();
        if (dYN != null) {
            if (dYS()) {
                if (dYN.dYJ() && dYN.dYG() && !iV(Xm())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYN2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN();
                            if (dYN2.dYJ() && dYN2.dYG() && !o.this.iV(o.this.Xm())) {
                                dYN2.dYv();
                                o.this.dZK();
                            }
                        }
                    }, this.oeC);
                } else if (dYN.dYJ() && !dYN.dYG() && !iV(Xm())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.3
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYN2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN();
                            if (dYN2.dYJ() && !dYN2.dYG() && !o.this.iV(o.this.Xm())) {
                                dYN2.dYD();
                            }
                        }
                    }, this.oeC);
                } else if (!dYN.dYJ() && dYN.dYG() && iV(Xm())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYN2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN();
                            if (!dYN2.dYJ() && dYN2.dYG() && o.this.iV(o.this.Xm())) {
                                o.this.Xp();
                            }
                        }
                    }, this.oeC);
                } else if (!dYN.dYJ() && !dYN.dYG() && iV(Xm())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.5
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYN2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN();
                            if (!dYN2.dYJ() && !dYN2.dYG() && o.this.iV(o.this.Xm())) {
                                o.this.Xp();
                                dYN2.dYD();
                            }
                        }
                    }, this.oeC);
                } else if (dYN.dYJ() && dYN.dYG() && iV(Xm())) {
                    dYN.aAm();
                }
            } else if (dYN.dYG() && !iV(Xm())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.6
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYN2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN();
                        if (dYN2 != null && dYN2.dYG() && !o.this.iV(o.this.Xm())) {
                            dYN2.dYv();
                            o.this.dZK();
                        }
                    }
                }, this.oeC);
            } else if (!dYN.dYG() && ((dYN.dYw() == 0 || dYN.dYw() == 4 || dYN.dYw() == 3) && iV(Xm()))) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYN2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN();
                        if (!dYN2.dYG()) {
                            if ((dYN2.dYw() == 0 || dYN2.dYw() == 4 || dYN2.dYw() == 3) && o.this.iV(o.this.Xm())) {
                                o.this.Xp();
                            }
                        }
                    }
                }, this.oeC);
            } else if (dYN.dYG() && iV(Xm()) && dYN.dYy()) {
                dYN.aAm();
            }
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.obo) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZK() {
        if (!dYS()) {
            e.dZk().onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501071));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xp() {
        zg(true);
    }

    public void zg(boolean z) {
        String str;
        if (z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYN = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN();
            if (dYN != null) {
                String dYK = dYN.dYK();
                if (dYS()) {
                    str = dYK + ",isOwnerJoinChat:" + dYN.dYJ() + ",mIsSelfInRctRoom:" + dYN.dYG() + ",isOwner:true";
                } else {
                    str = dYK + ",mIsSelfInRctRoom:" + dYN.dYG() + ",getRtcStatus:" + dYN.dYw() + ",isOwner:false";
                }
                int length = str.length();
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.obo) {
                    Log.i("AudioRoom", str);
                }
                if (str != null && length > 1900) {
                    str = str.substring(length - 1900, length);
                }
            } else {
                str = null;
            }
            new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.8
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
                    o.this.dZK();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str2) {
                }
            }).a(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca(), dZA().Xm(), 1, str);
            return;
        }
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.9
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void onFail(int i, String str2) {
            }
        }).gP(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca(), dZA().Xm());
    }

    private void dZL() {
        if (this.ocV != null && this.ocV.getPageActivity() != null) {
            this.mBroadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.10
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (TextUtils.equals(intent.getAction(), "com.baidu.open.log.debug")) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a.obo = true;
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.obo = true;
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.open.log.debug");
            this.oeE = true;
            this.ocV.getPageActivity().registerReceiver(this.mBroadcastReceiver, intentFilter);
        }
    }

    private void dZM() {
        if (this.ocV != null && this.ocV.getPageActivity() != null && this.mBroadcastReceiver != null && this.oeE) {
            this.oeE = false;
            this.ocV.getPageActivity().unregisterReceiver(this.mBroadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    public int getWheatHeight() {
        if (this.oeA != null) {
            return this.oeA.getWheatHeight();
        }
        return 0;
    }

    public boolean dZN() {
        return this.oeG;
    }

    public boolean ah(w wVar) {
        return (wVar == null || wVar.mLiveInfo == null || wVar.mLiveInfo.live_status != 2) ? false : true;
    }
}
