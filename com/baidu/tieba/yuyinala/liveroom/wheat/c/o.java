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
    private static o ogd = new o();
    private BroadcastReceiver mBroadcastReceiver;
    private Rect mRect;
    private TbPageContext oey;
    private com.baidu.tieba.yuyinala.liveroom.wheat.d.a oge;
    private AlaLiveRoomBlurPageLayout ogf;
    private com.baidu.tieba.yuyinala.player.b ogh;
    private boolean ogi;
    private long ogj;
    private boolean ogk;
    private a ogl;
    private long ogg = 10000;
    private CustomMessageListener aYK = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                w wVar = (w) customResponsedMessage.getData();
                if (o.this.ah(wVar)) {
                    if (o.this.oge != null) {
                        ViewGroup dZB = o.this.oge.dZB();
                        if (dZB != null && dZB.getParent() != null) {
                            ((ViewGroup) dZB.getParent()).removeView(dZB);
                        }
                        o.this.oge.onDestroy();
                        o.this.oge = null;
                        return;
                    }
                    return;
                }
                if (o.this.af(wVar)) {
                    o.this.ag(wVar);
                } else if (o.this.oge != null) {
                    o.this.oge.ai(wVar);
                }
                o.this.dZI();
            }
        }
    };
    private CustomMessageListener ogm = new CustomMessageListener(2501009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501009) {
                if (customResponsedMessage.getData() == null) {
                    if (o.this.oge != null) {
                        o.this.oge.loadData();
                    }
                } else if ((customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).contains(Headers.REFRESH) && o.this.oge != null) {
                    o.this.oge.eaq();
                }
            }
        }
    };
    private CustomMessageListener ogn = new CustomMessageListener(2501022) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501022 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = (String) hashMap.get("user_uk");
                String str2 = (String) hashMap.get("webp_url");
                String str3 = (String) hashMap.get("result_url");
                if (o.this.oge != null) {
                    o.this.oge.aM(str, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener ogo = new CustomMessageListener(2501024) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501024 && customResponsedMessage.getData() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().Vn(str).Bv();
                }
            }
        }
    };
    private CustomMessageListener ogp = new CustomMessageListener(2501026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.15
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
                        if (optBoolean || (!optBoolean && !o.this.Vf(optString))) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.15.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (TextUtils.equals(optString2, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().Br())) {
                                        if (optInt == 1) {
                                            if (o.this.oge != null) {
                                                o.this.oge.VJ(optString);
                                            }
                                        } else if (o.this.oge != null) {
                                            o.this.oge.VK(optString);
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
    private CustomMessageListener ogq = new CustomMessageListener(2501023) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501023 && customResponsedMessage.getData() != null && o.this.oge != null) {
                o.this.oge.loadData();
            }
        }
    };
    com.baidu.live.al.c ogr = new com.baidu.live.al.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.17
        @Override // com.baidu.live.al.c
        public boolean isApplying() {
            if (o.this.oge != null) {
                return o.this.oge.isApplying();
            }
            return false;
        }

        @Override // com.baidu.live.al.c
        public boolean iP(String str) {
            if (o.this.oge != null) {
                return o.this.oge.iP(str);
            }
            return false;
        }

        @Override // com.baidu.live.al.c
        public boolean iQ(String str) {
            if (o.this.oge != null) {
                return o.this.oge.iQ(str);
            }
            return false;
        }

        @Override // com.baidu.live.al.c
        public boolean iR(String str) {
            if (o.this.oge != null) {
                return o.this.oge.iR(str);
            }
            return false;
        }

        @Override // com.baidu.live.al.c
        public AlaWheatInfoData iS(String str) {
            if (o.this.oge != null) {
                return o.this.oge.VI(str);
            }
            return null;
        }

        @Override // com.baidu.live.al.c
        public AlaWheatInfoData Wz() {
            if (o.this.oge != null) {
                return o.this.oge.Wz();
            }
            return null;
        }

        @Override // com.baidu.live.al.c
        public void F(String str, boolean z) {
            if (o.this.oge != null) {
                o.this.oge.F(str, z);
            }
        }

        @Override // com.baidu.live.al.c
        public boolean iT(String str) {
            if (o.this.oge != null) {
                return o.this.oge.iT(str);
            }
            return false;
        }

        @Override // com.baidu.live.al.c
        public void a(com.baidu.live.al.a aVar) {
            if (o.this.oge != null) {
                o.this.oge.a(aVar);
            }
        }

        @Override // com.baidu.live.al.c
        public List<AlaWheatInfoData> WA() {
            if (o.this.oge != null) {
                return o.this.oge.WA();
            }
            return null;
        }

        @Override // com.baidu.live.al.c
        public List<AlaWheatInfoData> WB() {
            if (o.this.oge != null) {
                return o.this.oge.WB();
            }
            return null;
        }

        @Override // com.baidu.live.al.c
        public String WC() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().WC();
        }

        @Override // com.baidu.live.al.c
        public String WD() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.WD();
        }

        @Override // com.baidu.live.al.c
        public String getCustomRoomId() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().getCustomRoomId();
        }

        @Override // com.baidu.live.al.c
        public w WE() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().WE();
        }

        @Override // com.baidu.live.al.c
        public String WF() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().WF();
        }

        @Override // com.baidu.live.al.c
        public void muteOrUnmuteAudio(boolean z) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM() != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().muteOrUnmuteAudio(z);
            }
        }

        @Override // com.baidu.live.al.c
        public void WG() {
            o.this.zn(false);
        }

        @Override // com.baidu.live.al.c
        public void WH() {
            o.this.dZH();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void MA(int i);
    }

    public static o dZz() {
        return ogd;
    }

    private o() {
    }

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mRect = rect;
        this.oey = tbPageContext;
        this.ogf = alaLiveRoomBlurPageLayout;
    }

    public void dZA() {
        if (this.oge != null) {
            this.oge.loadData();
        }
    }

    public ViewGroup dZB() {
        if (this.oge != null) {
            return this.oge.dZB();
        }
        return null;
    }

    public List<AlaWheatInfoData> WB() {
        if (this.oge != null) {
            return this.oge.WB();
        }
        return null;
    }

    public List<AlaWheatInfoData> WA() {
        if (this.oge != null) {
            return this.oge.WA();
        }
        return null;
    }

    public boolean dZC() {
        if (this.oge != null) {
            return this.oge.dZC();
        }
        return false;
    }

    public boolean dYR() {
        if (this.oge != null) {
            return this.oge.dYR();
        }
        return false;
    }

    public boolean iQ(String str) {
        if (this.oge != null) {
            return this.oge.iQ(str);
        }
        return false;
    }

    public boolean Vf(String str) {
        if (this.oge != null) {
            return this.oge.Vf(str);
        }
        return false;
    }

    public String WD() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.WD();
    }

    public boolean iP(String str) {
        if (this.oge != null) {
            return this.oge.iP(str);
        }
        return false;
    }

    public boolean iR(String str) {
        if (this.oge != null) {
            return this.oge.iR(str);
        }
        return false;
    }

    public boolean VB(String str) {
        if (this.oge != null) {
            return this.oge.VB(str);
        }
        return false;
    }

    public AlaWheatInfoData iS(String str) {
        if (this.oge != null) {
            return this.oge.iS(str);
        }
        return null;
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        if (this.oge != null) {
            return this.oge.bi(str, z);
        }
        return null;
    }

    public int dZD() {
        if (this.oge != null) {
            return this.oge.dZD();
        }
        return -1;
    }

    public TbPageContext dZE() {
        if (this.oge != null) {
            return this.oge.dZE();
        }
        return null;
    }

    public boolean isApplying() {
        if (this.oge != null) {
            return this.oge.isApplying();
        }
        return false;
    }

    public void setMaskBg(boolean z) {
        if (this.oge != null) {
            this.oge.setMaskBg(z);
        }
    }

    public void zk(boolean z) {
        if (this.oge != null) {
            this.oge.zk(z);
        }
    }

    public void zl(boolean z) {
        if (this.oge != null) {
            this.oge.zl(z);
        }
    }

    public void l(w wVar) {
        if (wVar != null && wVar.aIe != null) {
            wVar.aIe.isEnterLiveData = true;
            ad(wVar);
            if (this.oge != null) {
                this.oge.a(this.ogh);
                this.oge.l(wVar);
            }
            registerListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(w wVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aIe;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            if (this.oge == null || !(this.oge instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
                this.oge = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
                this.oge.a(this.oey, this.ogf, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            if (this.oge == null || !(this.oge instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c)) {
                this.oge = new com.baidu.tieba.yuyinala.liveroom.wheat.d.c();
                this.oge.a(this.oey, this.ogf, this.mRect);
            }
        } else if (this.oge == null || !(this.oge instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
            this.oge = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
            this.oge.a(this.oey, this.ogf, this.mRect);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if ((r4.oge instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
        if ((r4.oge instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean ae(w wVar) {
        boolean z = true;
        if (wVar.aIq) {
            wVar.aIq = false;
            return false;
        } else if (dZF()) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aIe;
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.oge != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                if (this.oge != null) {
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
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aIe;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            return this.oge == null || !(this.oge instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            return this.oge == null || !(this.oge instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c);
        } else {
            return false;
        }
    }

    private boolean dZF() {
        if (com.baidu.live.aa.a.Ph().bms == null || com.baidu.live.aa.a.Ph().bms.aLN == null || com.baidu.live.aa.a.Ph().bms.aLN.aOV == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.dZV().a(com.baidu.live.aa.a.Ph().bms.aLN.aOV.Ej(), true);
    }

    public void CD() {
        if (this.oge != null) {
            this.oge.CD();
        }
        onDestroy();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().onDestroy();
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.ogh = bVar;
    }

    public void zm(boolean z) {
        if (this.oge != null) {
            this.oge.zm(z);
        }
    }

    public boolean dZG() {
        if (this.oge != null) {
            return this.oge.dZG();
        }
        return false;
    }

    private void registerListener() {
        onDestroy();
        MessageManager.getInstance().registerListener(this.aYK);
        com.baidu.live.al.b.Wy().a(this.ogr);
        MessageManager.getInstance().registerListener(this.ogm);
        MessageManager.getInstance().registerListener(this.ogp);
        MessageManager.getInstance().registerListener(this.ogo);
        MessageManager.getInstance().registerListener(this.ogq);
        MessageManager.getInstance().registerListener(this.ogn);
        dZK();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aYK);
        MessageManager.getInstance().unRegisterListener(this.ogm);
        MessageManager.getInstance().unRegisterListener(this.ogn);
        MessageManager.getInstance().unRegisterListener(this.ogo);
        MessageManager.getInstance().unRegisterListener(this.ogp);
        MessageManager.getInstance().unRegisterListener(this.ogq);
        dZL();
        if (this.oge != null) {
            this.oge.onDestroy();
        }
    }

    public void cFe() {
        if (this.oge != null) {
            this.oge = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(final w wVar) {
        final int i;
        if (this.oge instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_common_mode_text)).show();
            i = 0;
        } else if (this.oge instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_dating_mode_text)).show();
            i = 1;
        } else {
            i = 0;
        }
        if (ae(wVar)) {
            if (System.currentTimeMillis() - this.ogj > 1000) {
                this.ogj = System.currentTimeMillis();
                this.ogk = true;
                View view = null;
                if (this.oey != null && this.oey.getPageActivity() != null) {
                    view = this.oey.getPageActivity().findViewById(a.f.ala_liveroom_view);
                }
                if (view != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.dZV().cR((ViewGroup) view);
                }
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.11
                    @Override // java.lang.Runnable
                    public void run() {
                        o.this.ad(wVar);
                        if (o.this.oge != null) {
                            o.this.oge.ai(wVar);
                        }
                        if (o.this.ogl != null) {
                            o.this.ogl.MA(i);
                        }
                        o.this.ogk = false;
                    }
                }, 1500L);
                return;
            }
            return;
        }
        ad(wVar);
        if (this.oge != null) {
            this.oge.ai(wVar);
        }
        if (this.ogl != null) {
            this.ogl.MA(i);
        }
    }

    public void a(a aVar) {
        this.ogl = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZH() {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(this.oey, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.18
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
            public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
            public void onFail(int i, String str) {
            }
        }).gP(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().Br(), "1");
    }

    public void dZI() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYM = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM();
        if (dYM != null) {
            if (dYR()) {
                if (dYM.dYI() && dYM.dYF() && !iP(WD())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYM2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM();
                            if (dYM2.dYI() && dYM2.dYF() && !o.this.iP(o.this.WD())) {
                                dYM2.dYu();
                                o.this.dZJ();
                            }
                        }
                    }, this.ogg);
                } else if (dYM.dYI() && !dYM.dYF() && !iP(WD())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.3
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYM2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM();
                            if (dYM2.dYI() && !dYM2.dYF() && !o.this.iP(o.this.WD())) {
                                dYM2.dYC();
                            }
                        }
                    }, this.ogg);
                } else if (!dYM.dYI() && dYM.dYF() && iP(WD())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYM2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM();
                            if (!dYM2.dYI() && dYM2.dYF() && o.this.iP(o.this.WD())) {
                                o.this.WG();
                            }
                        }
                    }, this.ogg);
                } else if (!dYM.dYI() && !dYM.dYF() && iP(WD())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.5
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYM2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM();
                            if (!dYM2.dYI() && !dYM2.dYF() && o.this.iP(o.this.WD())) {
                                o.this.WG();
                                dYM2.dYC();
                            }
                        }
                    }, this.ogg);
                } else if (dYM.dYI() && dYM.dYF() && iP(WD())) {
                    dYM.azE();
                }
            } else if (dYM.dYF() && !iP(WD())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.6
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYM2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM();
                        if (dYM2 != null && dYM2.dYF() && !o.this.iP(o.this.WD())) {
                            dYM2.dYu();
                            o.this.dZJ();
                        }
                    }
                }, this.ogg);
            } else if (!dYM.dYF() && ((dYM.dYv() == 0 || dYM.dYv() == 4 || dYM.dYv() == 3) && iP(WD()))) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYM2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM();
                        if (!dYM2.dYF()) {
                            if ((dYM2.dYv() == 0 || dYM2.dYv() == 4 || dYM2.dYv() == 3) && o.this.iP(o.this.WD())) {
                                o.this.WG();
                            }
                        }
                    }
                }, this.ogg);
            } else if (dYM.dYF() && iP(WD()) && dYM.dYx()) {
                dYM.azE();
            }
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.ocS) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZJ() {
        if (!dYR()) {
            e.dZj().onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501071));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WG() {
        zn(true);
    }

    public void zn(boolean z) {
        String str;
        if (z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYM = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM();
            if (dYM != null) {
                String dYJ = dYM.dYJ();
                if (dYR()) {
                    str = dYJ + ",isOwnerJoinChat:" + dYM.dYI() + ",mIsSelfInRctRoom:" + dYM.dYF() + ",isOwner:true";
                } else {
                    str = dYJ + ",mIsSelfInRctRoom:" + dYM.dYF() + ",getRtcStatus:" + dYM.dYv() + ",isOwner:false";
                }
                int length = str.length();
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.ocS) {
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
                    o.this.dZJ();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str2) {
                }
            }).a(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().Br(), dZz().WD(), 1, str);
            return;
        }
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.9
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void onFail(int i, String str2) {
            }
        }).gP(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().Br(), dZz().WD());
    }

    private void dZK() {
        if (this.oey != null && this.oey.getPageActivity() != null) {
            this.mBroadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.10
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (TextUtils.equals(intent.getAction(), "com.baidu.open.log.debug")) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a.ocS = true;
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.ocS = true;
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.open.log.debug");
            this.ogi = true;
            this.oey.getPageActivity().registerReceiver(this.mBroadcastReceiver, intentFilter);
        }
    }

    private void dZL() {
        if (this.oey != null && this.oey.getPageActivity() != null && this.mBroadcastReceiver != null && this.ogi) {
            this.ogi = false;
            this.oey.getPageActivity().unregisterReceiver(this.mBroadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    public int getWheatHeight() {
        if (this.oge != null) {
            return this.oge.getWheatHeight();
        }
        return 0;
    }

    public boolean dZM() {
        return this.ogk;
    }

    public boolean ah(w wVar) {
        return (wVar == null || wVar.mLiveInfo == null || wVar.mLiveInfo.live_status != 2) ? false : true;
    }
}
