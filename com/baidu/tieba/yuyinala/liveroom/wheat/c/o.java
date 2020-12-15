package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.net.http.Headers;
import android.os.Build;
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
    private static o ovf;
    private BroadcastReceiver mBroadcastReceiver;
    private Rect mRect;
    private TbPageContext otA;
    private com.baidu.tieba.yuyinala.liveroom.wheat.d.a ovg;
    private AlaLiveRoomBlurPageLayout ovh;
    private com.baidu.tieba.yuyinala.player.b ovj;
    private boolean ovk;
    private long ovl;
    private boolean ovm;
    private a ovn;
    private long ovi = 10000;
    private CustomMessageListener bcg = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                w wVar = (w) customResponsedMessage.getData();
                if (o.this.am(wVar)) {
                    if (o.this.ovg != null) {
                        ViewGroup efg = o.this.ovg.efg();
                        if (efg != null && efg.getParent() != null) {
                            ((ViewGroup) efg.getParent()).removeView(efg);
                        }
                        o.this.ovg.onDestroy();
                        o.this.ovg = null;
                        return;
                    }
                    return;
                }
                if (o.this.ak(wVar)) {
                    o.this.al(wVar);
                } else if (o.this.ovg != null) {
                    o.this.ovg.an(wVar);
                }
                o.this.efo();
            }
        }
    };
    private CustomMessageListener ovo = new CustomMessageListener(2501009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501009) {
                if (customResponsedMessage.getData() == null) {
                    if (o.this.ovg != null) {
                        o.this.ovg.loadData();
                    }
                } else if ((customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).contains(Headers.REFRESH) && o.this.ovg != null) {
                    o.this.ovg.efW();
                }
            }
        }
    };
    private CustomMessageListener ovp = new CustomMessageListener(2501022) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501022 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = (String) hashMap.get("user_uk");
                String str2 = (String) hashMap.get("webp_url");
                String str3 = (String) hashMap.get("result_url");
                if (o.this.ovg != null) {
                    o.this.ovg.aP(str, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener ovq = new CustomMessageListener(2501024) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501024 && customResponsedMessage.getData() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().WC(str).De();
                }
            }
        }
    };
    private CustomMessageListener ovr = new CustomMessageListener(2501026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.15
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
                        if (optBoolean || (!optBoolean && !o.this.Wu(optString))) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.15.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (TextUtils.equals(optString2, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().CZ())) {
                                        if (optInt == 1) {
                                            if (o.this.ovg != null) {
                                                o.this.ovg.WY(optString);
                                            }
                                        } else if (o.this.ovg != null) {
                                            o.this.ovg.WZ(optString);
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
    private CustomMessageListener ovs = new CustomMessageListener(2501023) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501023 && customResponsedMessage.getData() != null && o.this.ovg != null) {
                o.this.ovg.loadData();
            }
        }
    };
    com.baidu.live.ap.c ovt = new com.baidu.live.ap.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.17
        @Override // com.baidu.live.ap.c
        public boolean isApplying() {
            if (o.this.ovg != null) {
                return o.this.ovg.isApplying();
            }
            return false;
        }

        @Override // com.baidu.live.ap.c
        public boolean jt(String str) {
            if (o.this.ovg != null) {
                return o.this.ovg.jt(str);
            }
            return false;
        }

        @Override // com.baidu.live.ap.c
        public boolean ju(String str) {
            if (o.this.ovg != null) {
                return o.this.ovg.ju(str);
            }
            return false;
        }

        @Override // com.baidu.live.ap.c
        public boolean jv(String str) {
            if (o.this.ovg != null) {
                return o.this.ovg.jv(str);
            }
            return false;
        }

        @Override // com.baidu.live.ap.c
        public AlaWheatInfoData jw(String str) {
            if (o.this.ovg != null) {
                return o.this.ovg.WX(str);
            }
            return null;
        }

        @Override // com.baidu.live.ap.c
        public AlaWheatInfoData YY() {
            if (o.this.ovg != null) {
                return o.this.ovg.YY();
            }
            return null;
        }

        @Override // com.baidu.live.ap.c
        public void G(String str, boolean z) {
            if (o.this.ovg != null) {
                o.this.ovg.G(str, z);
            }
        }

        @Override // com.baidu.live.ap.c
        public boolean jx(String str) {
            if (o.this.ovg != null) {
                return o.this.ovg.jx(str);
            }
            return false;
        }

        @Override // com.baidu.live.ap.c
        public void a(com.baidu.live.ap.a aVar) {
            if (o.this.ovg != null) {
                o.this.ovg.a(aVar);
            }
        }

        @Override // com.baidu.live.ap.c
        public List<AlaWheatInfoData> YZ() {
            if (o.this.ovg != null) {
                return o.this.ovg.YZ();
            }
            return null;
        }

        @Override // com.baidu.live.ap.c
        public List<AlaWheatInfoData> Za() {
            if (o.this.ovg != null) {
                return o.this.ovg.Za();
            }
            return null;
        }

        @Override // com.baidu.live.ap.c
        public String Zb() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Zb();
        }

        @Override // com.baidu.live.ap.c
        public String Zc() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Zc();
        }

        @Override // com.baidu.live.ap.c
        public String getCustomRoomId() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().getCustomRoomId();
        }

        @Override // com.baidu.live.ap.c
        public w Zd() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Zd();
        }

        @Override // com.baidu.live.ap.c
        public String Ze() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Ze();
        }

        @Override // com.baidu.live.ap.c
        public void muteOrUnmuteAudio(boolean z) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer() != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().muteOrUnmuteAudio(z);
            }
        }

        @Override // com.baidu.live.ap.c
        public void Zf() {
            o.this.zR(false);
        }

        @Override // com.baidu.live.ap.c
        public void Zg() {
            o.this.efn();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void Ns(int i);
    }

    public static o efe() {
        if (ovf == null) {
            synchronized (o.class) {
                if (ovf == null) {
                    ovf = new o();
                }
            }
        }
        return ovf;
    }

    private o() {
    }

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mRect = rect;
        this.otA = tbPageContext;
        this.ovh = alaLiveRoomBlurPageLayout;
    }

    public void eff() {
        if (this.ovg != null) {
            this.ovg.loadData();
        }
    }

    public ViewGroup efg() {
        if (this.ovg != null) {
            return this.ovg.efg();
        }
        return null;
    }

    public List<AlaWheatInfoData> Za() {
        if (this.ovg != null) {
            return this.ovg.Za();
        }
        return null;
    }

    public List<AlaWheatInfoData> YZ() {
        if (this.ovg != null) {
            return this.ovg.YZ();
        }
        return null;
    }

    public boolean efh() {
        if (this.ovg != null) {
            return this.ovg.efh();
        }
        return false;
    }

    public boolean eew() {
        if (this.ovg != null) {
            return this.ovg.eew();
        }
        return false;
    }

    public boolean ju(String str) {
        if (this.ovg != null) {
            return this.ovg.ju(str);
        }
        return false;
    }

    public boolean Wu(String str) {
        if (this.ovg != null) {
            return this.ovg.Wu(str);
        }
        return false;
    }

    public String Zc() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Zc();
    }

    public boolean jt(String str) {
        if (this.ovg != null) {
            return this.ovg.jt(str);
        }
        return false;
    }

    public boolean jv(String str) {
        if (this.ovg != null) {
            return this.ovg.jv(str);
        }
        return false;
    }

    public boolean WQ(String str) {
        if (this.ovg != null) {
            return this.ovg.WQ(str);
        }
        return false;
    }

    public AlaWheatInfoData jw(String str) {
        if (this.ovg != null) {
            return this.ovg.jw(str);
        }
        return null;
    }

    public AlaWheatInfoData bj(String str, boolean z) {
        if (this.ovg != null) {
            return this.ovg.bj(str, z);
        }
        return null;
    }

    public int efi() {
        if (this.ovg != null) {
            return this.ovg.efi();
        }
        return -1;
    }

    public TbPageContext efj() {
        if (this.ovg != null) {
            return this.ovg.efj();
        }
        return null;
    }

    public boolean isApplying() {
        if (this.ovg != null) {
            return this.ovg.isApplying();
        }
        return false;
    }

    public void setMaskBg(boolean z) {
        if (this.ovg != null) {
            this.ovg.setMaskBg(z);
        }
    }

    public void zO(boolean z) {
        if (this.ovg != null) {
            this.ovg.zO(z);
        }
    }

    public void zP(boolean z) {
        if (this.ovg != null) {
            this.ovg.zP(z);
        }
    }

    public void l(w wVar) {
        if (wVar != null && wVar.aKQ != null) {
            wVar.aKQ.isEnterLiveData = true;
            ai(wVar);
            if (this.ovg != null) {
                this.ovg.a(this.ovj);
                this.ovg.l(wVar);
            }
            registerListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(w wVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aKQ;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            if (this.ovg == null || !(this.ovg instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
                this.ovg = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
                this.ovg.a(this.otA, this.ovh, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            if (this.ovg == null || !(this.ovg instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c)) {
                this.ovg = new com.baidu.tieba.yuyinala.liveroom.wheat.d.c();
                this.ovg.a(this.otA, this.ovh, this.mRect);
            }
        } else if (this.ovg == null || !(this.ovg instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
            this.ovg = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
            this.ovg.a(this.otA, this.ovh, this.mRect);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if ((r4.ovg instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
        if ((r4.ovg instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean aj(w wVar) {
        boolean z = true;
        if (wVar.aLc) {
            wVar.aLc = false;
            return false;
        } else if (efk()) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aKQ;
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.ovg != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                if (this.ovg != null) {
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
    public boolean ak(w wVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aKQ;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            return this.ovg == null || !(this.ovg instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            return this.ovg == null || !(this.ovg instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c);
        } else {
            return false;
        }
    }

    private boolean efk() {
        if (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOJ == null || com.baidu.live.ae.a.RB().brA.aOJ.aRX == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efB().a(com.baidu.live.ae.a.RB().brA.aOJ.aRX.FU(), true);
    }

    public void En() {
        if (this.ovg != null) {
            this.ovg.En();
        }
        onDestroy();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().onDestroy();
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.ovj = bVar;
    }

    public void zQ(boolean z) {
        if (this.ovg != null) {
            this.ovg.zQ(z);
        }
    }

    public boolean efl() {
        if (this.ovg != null) {
            return this.ovg.efl();
        }
        return false;
    }

    private void registerListener() {
        onDestroy();
        MessageManager.getInstance().registerListener(this.bcg);
        com.baidu.live.ap.b.YX().a(this.ovt);
        MessageManager.getInstance().registerListener(this.ovo);
        MessageManager.getInstance().registerListener(this.ovr);
        MessageManager.getInstance().registerListener(this.ovq);
        MessageManager.getInstance().registerListener(this.ovs);
        MessageManager.getInstance().registerListener(this.ovp);
        efq();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bcg);
        MessageManager.getInstance().unRegisterListener(this.ovo);
        MessageManager.getInstance().unRegisterListener(this.ovp);
        MessageManager.getInstance().unRegisterListener(this.ovq);
        MessageManager.getInstance().unRegisterListener(this.ovr);
        MessageManager.getInstance().unRegisterListener(this.ovs);
        efr();
        if (this.ovg != null) {
            this.ovg.onDestroy();
        }
    }

    public void cKu() {
        if (this.ovg != null) {
            this.ovg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(final w wVar) {
        final int i;
        if (this.ovg instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_common_mode_text)).show();
            i = 0;
        } else if (this.ovg instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_dating_mode_text)).show();
            i = 1;
        } else {
            i = 0;
        }
        if (aj(wVar)) {
            if (System.currentTimeMillis() - this.ovl > 1000) {
                this.ovl = System.currentTimeMillis();
                this.ovm = true;
                View view = null;
                if (this.otA != null && this.otA.getPageActivity() != null) {
                    view = this.otA.getPageActivity().findViewById(a.f.ala_liveroom_view);
                }
                if (view != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efB().cU((ViewGroup) view);
                }
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!o.this.efm()) {
                            o.this.ai(wVar);
                            if (o.this.ovg != null) {
                                o.this.ovg.an(wVar);
                            }
                            if (o.this.ovn != null) {
                                o.this.ovn.Ns(i);
                            }
                        }
                        o.this.ovm = false;
                    }
                }, 1500L);
                return;
            }
            return;
        }
        ai(wVar);
        if (this.ovg != null) {
            this.ovg.an(wVar);
        }
        if (this.ovn != null) {
            this.ovn.Ns(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean efm() {
        return Build.VERSION.SDK_INT >= 17 ? this.otA == null || this.otA.getPageActivity() == null || this.otA.getPageActivity().isFinishing() || this.otA.getPageActivity().isDestroyed() : this.otA == null || this.otA.getPageActivity() == null || this.otA.getPageActivity().isFinishing();
    }

    public void a(a aVar) {
        this.ovn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efn() {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(this.otA, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.18
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
            public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
            public void onFail(int i, String str) {
            }
        }).gU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().CZ(), "1");
    }

    public void efo() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
        if (eer != null) {
            if (eew()) {
                if (eer.een() && eer.eek() && !jt(Zc())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                            if (eer2.een() && eer2.eek() && !o.this.jt(o.this.Zc())) {
                                eer2.edZ();
                                o.this.efp();
                            }
                        }
                    }, this.ovi);
                } else if (eer.een() && !eer.eek() && !jt(Zc())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.3
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                            if (eer2.een() && !eer2.eek() && !o.this.jt(o.this.Zc())) {
                                eer2.eeh();
                            }
                        }
                    }, this.ovi);
                } else if (!eer.een() && eer.eek() && jt(Zc())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                            if (!eer2.een() && eer2.eek() && o.this.jt(o.this.Zc())) {
                                o.this.Zf();
                            }
                        }
                    }, this.ovi);
                } else if (!eer.een() && !eer.eek() && jt(Zc())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.5
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                            if (!eer2.een() && !eer2.eek() && o.this.jt(o.this.Zc())) {
                                o.this.Zf();
                                eer2.eeh();
                            }
                        }
                    }, this.ovi);
                } else if (eer.een() && eer.eek() && jt(Zc())) {
                    eer.aCN();
                }
            } else if (eer.eek() && !jt(Zc())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.6
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                        if (eer2 != null && eer2.eek() && !o.this.jt(o.this.Zc())) {
                            eer2.edZ();
                            o.this.efp();
                        }
                    }
                }, this.ovi);
            } else if (!eer.eek() && ((eer.eea() == 0 || eer.eea() == 4 || eer.eea() == 3) && jt(Zc()))) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                        if (!eer2.eek()) {
                            if ((eer2.eea() == 0 || eer2.eea() == 4 || eer2.eea() == 3) && o.this.jt(o.this.Zc())) {
                                o.this.Zf();
                            }
                        }
                    }
                }, this.ovi);
            } else if (eer.eek() && jt(Zc()) && eer.eec()) {
                eer.aCN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efp() {
        if (!eew()) {
            e.eeO().onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501071));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zf() {
        zR(true);
    }

    public void zR(boolean z) {
        String str;
        if (z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
            if (eer != null) {
                String eeo = eer.eeo();
                if (eew()) {
                    str = eeo + ",isOwnerJoinChat:" + eer.een() + ",mIsSelfInRctRoom:" + eer.eek() + ",isOwner:true";
                } else {
                    str = eeo + ",mIsSelfInRctRoom:" + eer.eek() + ",getRtcStatus:" + eer.eea() + ",isOwner:false";
                }
                int length = str.length();
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orU) {
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
                    o.this.efp();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str2) {
                }
            }).d(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().CZ(), efe().Zc(), 1, str);
            return;
        }
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.9
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void onFail(int i, String str2) {
            }
        }).gU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().CZ(), efe().Zc());
    }

    private void efq() {
        if (this.otA != null && this.otA.getPageActivity() != null) {
            this.mBroadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.10
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (TextUtils.equals(intent.getAction(), "com.baidu.open.log.debug")) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orU = true;
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.orU = true;
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.open.log.debug");
            this.ovk = true;
            this.otA.getPageActivity().registerReceiver(this.mBroadcastReceiver, intentFilter);
        }
    }

    private void efr() {
        if (this.otA != null && this.otA.getPageActivity() != null && this.mBroadcastReceiver != null && this.ovk) {
            this.ovk = false;
            this.otA.getPageActivity().unregisterReceiver(this.mBroadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    public int getWheatHeight() {
        if (this.ovg != null) {
            return this.ovg.getWheatHeight();
        }
        return 0;
    }

    public boolean efs() {
        return this.ovm;
    }

    public boolean am(w wVar) {
        return (wVar == null || wVar.mLiveInfo == null || wVar.mLiveInfo.live_status != 2) ? false : true;
    }
}
