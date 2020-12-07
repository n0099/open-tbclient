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
    private static o ovd;
    private BroadcastReceiver mBroadcastReceiver;
    private Rect mRect;
    private TbPageContext oty;
    private com.baidu.tieba.yuyinala.liveroom.wheat.d.a ove;
    private AlaLiveRoomBlurPageLayout ovf;
    private com.baidu.tieba.yuyinala.player.b ovh;
    private boolean ovi;
    private long ovj;
    private boolean ovk;
    private a ovl;
    private long ovg = 10000;
    private CustomMessageListener bcg = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                w wVar = (w) customResponsedMessage.getData();
                if (o.this.am(wVar)) {
                    if (o.this.ove != null) {
                        ViewGroup eff = o.this.ove.eff();
                        if (eff != null && eff.getParent() != null) {
                            ((ViewGroup) eff.getParent()).removeView(eff);
                        }
                        o.this.ove.onDestroy();
                        o.this.ove = null;
                        return;
                    }
                    return;
                }
                if (o.this.ak(wVar)) {
                    o.this.al(wVar);
                } else if (o.this.ove != null) {
                    o.this.ove.an(wVar);
                }
                o.this.efn();
            }
        }
    };
    private CustomMessageListener ovm = new CustomMessageListener(2501009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501009) {
                if (customResponsedMessage.getData() == null) {
                    if (o.this.ove != null) {
                        o.this.ove.loadData();
                    }
                } else if ((customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).contains(Headers.REFRESH) && o.this.ove != null) {
                    o.this.ove.efV();
                }
            }
        }
    };
    private CustomMessageListener ovn = new CustomMessageListener(2501022) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501022 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = (String) hashMap.get("user_uk");
                String str2 = (String) hashMap.get("webp_url");
                String str3 = (String) hashMap.get("result_url");
                if (o.this.ove != null) {
                    o.this.ove.aP(str, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener ovo = new CustomMessageListener(2501024) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501024 && customResponsedMessage.getData() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().WC(str).De();
                }
            }
        }
    };
    private CustomMessageListener ovp = new CustomMessageListener(2501026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.15
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
                                    if (TextUtils.equals(optString2, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().CZ())) {
                                        if (optInt == 1) {
                                            if (o.this.ove != null) {
                                                o.this.ove.WY(optString);
                                            }
                                        } else if (o.this.ove != null) {
                                            o.this.ove.WZ(optString);
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
    private CustomMessageListener ovq = new CustomMessageListener(2501023) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501023 && customResponsedMessage.getData() != null && o.this.ove != null) {
                o.this.ove.loadData();
            }
        }
    };
    com.baidu.live.ap.c ovr = new com.baidu.live.ap.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.17
        @Override // com.baidu.live.ap.c
        public boolean isApplying() {
            if (o.this.ove != null) {
                return o.this.ove.isApplying();
            }
            return false;
        }

        @Override // com.baidu.live.ap.c
        public boolean jt(String str) {
            if (o.this.ove != null) {
                return o.this.ove.jt(str);
            }
            return false;
        }

        @Override // com.baidu.live.ap.c
        public boolean ju(String str) {
            if (o.this.ove != null) {
                return o.this.ove.ju(str);
            }
            return false;
        }

        @Override // com.baidu.live.ap.c
        public boolean jv(String str) {
            if (o.this.ove != null) {
                return o.this.ove.jv(str);
            }
            return false;
        }

        @Override // com.baidu.live.ap.c
        public AlaWheatInfoData jw(String str) {
            if (o.this.ove != null) {
                return o.this.ove.WX(str);
            }
            return null;
        }

        @Override // com.baidu.live.ap.c
        public AlaWheatInfoData YY() {
            if (o.this.ove != null) {
                return o.this.ove.YY();
            }
            return null;
        }

        @Override // com.baidu.live.ap.c
        public void G(String str, boolean z) {
            if (o.this.ove != null) {
                o.this.ove.G(str, z);
            }
        }

        @Override // com.baidu.live.ap.c
        public boolean jx(String str) {
            if (o.this.ove != null) {
                return o.this.ove.jx(str);
            }
            return false;
        }

        @Override // com.baidu.live.ap.c
        public void a(com.baidu.live.ap.a aVar) {
            if (o.this.ove != null) {
                o.this.ove.a(aVar);
            }
        }

        @Override // com.baidu.live.ap.c
        public List<AlaWheatInfoData> YZ() {
            if (o.this.ove != null) {
                return o.this.ove.YZ();
            }
            return null;
        }

        @Override // com.baidu.live.ap.c
        public List<AlaWheatInfoData> Za() {
            if (o.this.ove != null) {
                return o.this.ove.Za();
            }
            return null;
        }

        @Override // com.baidu.live.ap.c
        public String Zb() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Zb();
        }

        @Override // com.baidu.live.ap.c
        public String Zc() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Zc();
        }

        @Override // com.baidu.live.ap.c
        public String getCustomRoomId() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().getCustomRoomId();
        }

        @Override // com.baidu.live.ap.c
        public w Zd() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Zd();
        }

        @Override // com.baidu.live.ap.c
        public String Ze() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Ze();
        }

        @Override // com.baidu.live.ap.c
        public void muteOrUnmuteAudio(boolean z) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq() != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().muteOrUnmuteAudio(z);
            }
        }

        @Override // com.baidu.live.ap.c
        public void Zf() {
            o.this.zR(false);
        }

        @Override // com.baidu.live.ap.c
        public void Zg() {
            o.this.efm();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void Ns(int i);
    }

    public static o efd() {
        if (ovd == null) {
            synchronized (o.class) {
                if (ovd == null) {
                    ovd = new o();
                }
            }
        }
        return ovd;
    }

    private o() {
    }

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mRect = rect;
        this.oty = tbPageContext;
        this.ovf = alaLiveRoomBlurPageLayout;
    }

    public void efe() {
        if (this.ove != null) {
            this.ove.loadData();
        }
    }

    public ViewGroup eff() {
        if (this.ove != null) {
            return this.ove.eff();
        }
        return null;
    }

    public List<AlaWheatInfoData> Za() {
        if (this.ove != null) {
            return this.ove.Za();
        }
        return null;
    }

    public List<AlaWheatInfoData> YZ() {
        if (this.ove != null) {
            return this.ove.YZ();
        }
        return null;
    }

    public boolean efg() {
        if (this.ove != null) {
            return this.ove.efg();
        }
        return false;
    }

    public boolean eev() {
        if (this.ove != null) {
            return this.ove.eev();
        }
        return false;
    }

    public boolean ju(String str) {
        if (this.ove != null) {
            return this.ove.ju(str);
        }
        return false;
    }

    public boolean Wu(String str) {
        if (this.ove != null) {
            return this.ove.Wu(str);
        }
        return false;
    }

    public String Zc() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Zc();
    }

    public boolean jt(String str) {
        if (this.ove != null) {
            return this.ove.jt(str);
        }
        return false;
    }

    public boolean jv(String str) {
        if (this.ove != null) {
            return this.ove.jv(str);
        }
        return false;
    }

    public boolean WQ(String str) {
        if (this.ove != null) {
            return this.ove.WQ(str);
        }
        return false;
    }

    public AlaWheatInfoData jw(String str) {
        if (this.ove != null) {
            return this.ove.jw(str);
        }
        return null;
    }

    public AlaWheatInfoData bj(String str, boolean z) {
        if (this.ove != null) {
            return this.ove.bj(str, z);
        }
        return null;
    }

    public int efh() {
        if (this.ove != null) {
            return this.ove.efh();
        }
        return -1;
    }

    public TbPageContext efi() {
        if (this.ove != null) {
            return this.ove.efi();
        }
        return null;
    }

    public boolean isApplying() {
        if (this.ove != null) {
            return this.ove.isApplying();
        }
        return false;
    }

    public void setMaskBg(boolean z) {
        if (this.ove != null) {
            this.ove.setMaskBg(z);
        }
    }

    public void zO(boolean z) {
        if (this.ove != null) {
            this.ove.zO(z);
        }
    }

    public void zP(boolean z) {
        if (this.ove != null) {
            this.ove.zP(z);
        }
    }

    public void l(w wVar) {
        if (wVar != null && wVar.aKQ != null) {
            wVar.aKQ.isEnterLiveData = true;
            ai(wVar);
            if (this.ove != null) {
                this.ove.a(this.ovh);
                this.ove.l(wVar);
            }
            registerListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(w wVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aKQ;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            if (this.ove == null || !(this.ove instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
                this.ove = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
                this.ove.a(this.oty, this.ovf, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            if (this.ove == null || !(this.ove instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c)) {
                this.ove = new com.baidu.tieba.yuyinala.liveroom.wheat.d.c();
                this.ove.a(this.oty, this.ovf, this.mRect);
            }
        } else if (this.ove == null || !(this.ove instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
            this.ove = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
            this.ove.a(this.oty, this.ovf, this.mRect);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if ((r4.ove instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
        if ((r4.ove instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean aj(w wVar) {
        boolean z = true;
        if (wVar.aLc) {
            wVar.aLc = false;
            return false;
        } else if (efj()) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aKQ;
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.ove != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                if (this.ove != null) {
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
            return this.ove == null || !(this.ove instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            return this.ove == null || !(this.ove instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c);
        } else {
            return false;
        }
    }

    private boolean efj() {
        if (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOJ == null || com.baidu.live.ae.a.RB().brA.aOJ.aRX == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efA().a(com.baidu.live.ae.a.RB().brA.aOJ.aRX.FU(), true);
    }

    public void En() {
        if (this.ove != null) {
            this.ove.En();
        }
        onDestroy();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().onDestroy();
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.ovh = bVar;
    }

    public void zQ(boolean z) {
        if (this.ove != null) {
            this.ove.zQ(z);
        }
    }

    public boolean efk() {
        if (this.ove != null) {
            return this.ove.efk();
        }
        return false;
    }

    private void registerListener() {
        onDestroy();
        MessageManager.getInstance().registerListener(this.bcg);
        com.baidu.live.ap.b.YX().a(this.ovr);
        MessageManager.getInstance().registerListener(this.ovm);
        MessageManager.getInstance().registerListener(this.ovp);
        MessageManager.getInstance().registerListener(this.ovo);
        MessageManager.getInstance().registerListener(this.ovq);
        MessageManager.getInstance().registerListener(this.ovn);
        efp();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bcg);
        MessageManager.getInstance().unRegisterListener(this.ovm);
        MessageManager.getInstance().unRegisterListener(this.ovn);
        MessageManager.getInstance().unRegisterListener(this.ovo);
        MessageManager.getInstance().unRegisterListener(this.ovp);
        MessageManager.getInstance().unRegisterListener(this.ovq);
        efq();
        if (this.ove != null) {
            this.ove.onDestroy();
        }
    }

    public void cKt() {
        if (this.ove != null) {
            this.ove = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(final w wVar) {
        final int i;
        if (this.ove instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_common_mode_text)).show();
            i = 0;
        } else if (this.ove instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_dating_mode_text)).show();
            i = 1;
        } else {
            i = 0;
        }
        if (aj(wVar)) {
            if (System.currentTimeMillis() - this.ovj > 1000) {
                this.ovj = System.currentTimeMillis();
                this.ovk = true;
                View view = null;
                if (this.oty != null && this.oty.getPageActivity() != null) {
                    view = this.oty.getPageActivity().findViewById(a.f.ala_liveroom_view);
                }
                if (view != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efA().cU((ViewGroup) view);
                }
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!o.this.efl()) {
                            o.this.ai(wVar);
                            if (o.this.ove != null) {
                                o.this.ove.an(wVar);
                            }
                            if (o.this.ovl != null) {
                                o.this.ovl.Ns(i);
                            }
                        }
                        o.this.ovk = false;
                    }
                }, 1500L);
                return;
            }
            return;
        }
        ai(wVar);
        if (this.ove != null) {
            this.ove.an(wVar);
        }
        if (this.ovl != null) {
            this.ovl.Ns(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean efl() {
        return Build.VERSION.SDK_INT >= 17 ? this.oty == null || this.oty.getPageActivity() == null || this.oty.getPageActivity().isFinishing() || this.oty.getPageActivity().isDestroyed() : this.oty == null || this.oty.getPageActivity() == null || this.oty.getPageActivity().isFinishing();
    }

    public void a(a aVar) {
        this.ovl = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efm() {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(this.oty, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.18
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
            public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
            public void onFail(int i, String str) {
            }
        }).gU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().CZ(), "1");
    }

    public void efn() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
        if (eeq != null) {
            if (eev()) {
                if (eeq.eem() && eeq.eej() && !jt(Zc())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                            if (eeq2.eem() && eeq2.eej() && !o.this.jt(o.this.Zc())) {
                                eeq2.edY();
                                o.this.efo();
                            }
                        }
                    }, this.ovg);
                } else if (eeq.eem() && !eeq.eej() && !jt(Zc())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.3
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                            if (eeq2.eem() && !eeq2.eej() && !o.this.jt(o.this.Zc())) {
                                eeq2.eeg();
                            }
                        }
                    }, this.ovg);
                } else if (!eeq.eem() && eeq.eej() && jt(Zc())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                            if (!eeq2.eem() && eeq2.eej() && o.this.jt(o.this.Zc())) {
                                o.this.Zf();
                            }
                        }
                    }, this.ovg);
                } else if (!eeq.eem() && !eeq.eej() && jt(Zc())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.5
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                            if (!eeq2.eem() && !eeq2.eej() && o.this.jt(o.this.Zc())) {
                                o.this.Zf();
                                eeq2.eeg();
                            }
                        }
                    }, this.ovg);
                } else if (eeq.eem() && eeq.eej() && jt(Zc())) {
                    eeq.aCN();
                }
            } else if (eeq.eej() && !jt(Zc())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.6
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                        if (eeq2 != null && eeq2.eej() && !o.this.jt(o.this.Zc())) {
                            eeq2.edY();
                            o.this.efo();
                        }
                    }
                }, this.ovg);
            } else if (!eeq.eej() && ((eeq.edZ() == 0 || eeq.edZ() == 4 || eeq.edZ() == 3) && jt(Zc()))) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                        if (!eeq2.eej()) {
                            if ((eeq2.edZ() == 0 || eeq2.edZ() == 4 || eeq2.edZ() == 3) && o.this.jt(o.this.Zc())) {
                                o.this.Zf();
                            }
                        }
                    }
                }, this.ovg);
            } else if (eeq.eej() && jt(Zc()) && eeq.eeb()) {
                eeq.aCN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efo() {
        if (!eev()) {
            e.eeN().onDestroy();
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
            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
            if (eeq != null) {
                String een = eeq.een();
                if (eev()) {
                    str = een + ",isOwnerJoinChat:" + eeq.eem() + ",mIsSelfInRctRoom:" + eeq.eej() + ",isOwner:true";
                } else {
                    str = een + ",mIsSelfInRctRoom:" + eeq.eej() + ",getRtcStatus:" + eeq.edZ() + ",isOwner:false";
                }
                int length = str.length();
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orS) {
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
                    o.this.efo();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str2) {
                }
            }).d(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().CZ(), efd().Zc(), 1, str);
            return;
        }
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.9
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void onFail(int i, String str2) {
            }
        }).gU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().CZ(), efd().Zc());
    }

    private void efp() {
        if (this.oty != null && this.oty.getPageActivity() != null) {
            this.mBroadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.10
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (TextUtils.equals(intent.getAction(), "com.baidu.open.log.debug")) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orS = true;
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.orS = true;
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.open.log.debug");
            this.ovi = true;
            this.oty.getPageActivity().registerReceiver(this.mBroadcastReceiver, intentFilter);
        }
    }

    private void efq() {
        if (this.oty != null && this.oty.getPageActivity() != null && this.mBroadcastReceiver != null && this.ovi) {
            this.ovi = false;
            this.oty.getPageActivity().unregisterReceiver(this.mBroadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    public int getWheatHeight() {
        if (this.ove != null) {
            return this.ove.getWheatHeight();
        }
        return 0;
    }

    public boolean efr() {
        return this.ovk;
    }

    public boolean am(w wVar) {
        return (wVar == null || wVar.mLiveInfo == null || wVar.mLiveInfo.live_status != 2) ? false : true;
    }
}
