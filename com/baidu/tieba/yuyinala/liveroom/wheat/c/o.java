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
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.AlaWheatMoreFunctionData;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaEndConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.f;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class o {
    private static o oxl;
    private BroadcastReceiver mBroadcastReceiver;
    private Rect mRect;
    private TbPageContext ovz;
    private com.baidu.tieba.yuyinala.liveroom.wheat.d.a oxm;
    private AlaLiveRoomBlurPageLayout oxn;
    private com.baidu.tieba.yuyinala.player.b oxp;
    private boolean oxq;
    private long oxr;
    private boolean oxs;
    private a oxt;
    private long oxo = 10000;
    private CustomMessageListener aZa = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof x)) {
                x xVar = (x) customResponsedMessage.getData();
                if (o.this.aq(xVar)) {
                    if (o.this.oxm != null) {
                        ViewGroup ebq = o.this.oxm.ebq();
                        if (ebq != null && ebq.getParent() != null) {
                            ((ViewGroup) ebq.getParent()).removeView(ebq);
                        }
                        o.this.oxm.onDestroy();
                        o.this.oxm = null;
                        return;
                    }
                    return;
                }
                if (o.this.ao(xVar)) {
                    o.this.ap(xVar);
                } else if (o.this.oxm != null) {
                    o.this.oxm.ar(xVar);
                }
                o.this.ebz();
            }
        }
    };
    private CustomMessageListener oxu = new CustomMessageListener(2501009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501009) {
                if (customResponsedMessage.getData() == null) {
                    if (o.this.oxm != null) {
                        o.this.oxm.loadData();
                    }
                } else if ((customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).contains(Headers.REFRESH) && o.this.oxm != null) {
                    o.this.oxm.ecp();
                }
            }
        }
    };
    private CustomMessageListener oxv = new CustomMessageListener(2501022) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501022 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = (String) hashMap.get("user_uk");
                String str2 = (String) hashMap.get("webp_url");
                String str3 = (String) hashMap.get("result_url");
                if (o.this.oxm != null) {
                    o.this.oxm.aS(str, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener oxw = new CustomMessageListener(2501076) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501076 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaWheatMoreFunctionData)) {
                new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h(o.this.ovz, (AlaWheatMoreFunctionData) customResponsedMessage.getData()).show();
            }
        }
    };
    private CustomMessageListener oxx = new CustomMessageListener(2501024) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501024 && customResponsedMessage.getData() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().Vc(str).yA();
                }
            }
        }
    };
    private CustomMessageListener oxy = new CustomMessageListener(2501026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.18
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
                        if (optBoolean || (!optBoolean && !o.this.UU(optString))) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.18.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (TextUtils.equals(optString2, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().yv())) {
                                        if (optInt == 1) {
                                            if (o.this.oxm != null) {
                                                o.this.oxm.VB(optString);
                                            }
                                        } else if (o.this.oxm != null) {
                                            o.this.oxm.VC(optString);
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
    private CustomMessageListener oxz = new CustomMessageListener(2501023) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501023 && customResponsedMessage.getData() != null && o.this.oxm != null) {
                o.this.oxm.loadData();
            }
        }
    };
    private CustomMessageListener oxA = new CustomMessageListener(2501077) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage == null || customResponsedMessage.getCmd() == 2501077) && o.this.oxm != null && (o.this.oxm instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d)) {
                ((com.baidu.tieba.yuyinala.liveroom.wheat.d.d) o.this.oxm).setTeamFightProgressData((String) customResponsedMessage.getData());
            }
        }
    };
    com.baidu.live.aq.b oxB = new com.baidu.live.aq.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.2
        @Override // com.baidu.live.aq.b
        public boolean isApplying() {
            if (o.this.oxm != null) {
                return o.this.oxm.isApplying();
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public boolean ib(String str) {
            if (o.this.oxm != null) {
                return o.this.oxm.ib(str);
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public boolean ic(String str) {
            if (o.this.oxm != null) {
                return o.this.oxm.ic(str);
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public boolean id(String str) {
            if (o.this.oxm != null) {
                return o.this.oxm.id(str);
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public AlaWheatInfoData ie(String str) {
            if (o.this.oxm != null) {
                return o.this.oxm.VA(str);
            }
            return null;
        }

        @Override // com.baidu.live.aq.b
        public AlaWheatInfoData Wv() {
            if (o.this.oxm != null) {
                return o.this.oxm.Wv();
            }
            return null;
        }

        @Override // com.baidu.live.aq.b
        public void G(String str, boolean z) {
            if (o.this.oxm != null) {
                o.this.oxm.G(str, z);
            }
        }

        @Override // com.baidu.live.aq.b
        /* renamed from: if */
        public boolean mo18if(String str) {
            if (o.this.oxm != null) {
                return o.this.oxm.m48if(str);
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public List<AlaWheatInfoData> Ww() {
            if (o.this.oxm != null) {
                return o.this.oxm.Ww();
            }
            return null;
        }

        @Override // com.baidu.live.aq.b
        public List<AlaWheatInfoData> Wx() {
            if (o.this.oxm != null) {
                return o.this.oxm.Wx();
            }
            return null;
        }

        @Override // com.baidu.live.aq.b
        public String Wy() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().Wy();
        }

        @Override // com.baidu.live.aq.b
        public String Wz() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Wz();
        }

        @Override // com.baidu.live.aq.b
        public String getCustomRoomId() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().getCustomRoomId();
        }

        @Override // com.baidu.live.aq.b
        public x WA() {
            return o.this.WA();
        }

        @Override // com.baidu.live.aq.b
        public String WB() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WB();
        }

        @Override // com.baidu.live.aq.b
        public void muteOrUnmuteAudio(boolean z) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz() != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().muteOrUnmuteAudio(z);
            }
        }

        @Override // com.baidu.live.aq.b
        public void WC() {
            o.this.J(false, "");
        }

        @Override // com.baidu.live.aq.b
        public void WD() {
            o.this.eby();
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void Lx(int i);
    }

    public static o ebo() {
        if (oxl == null) {
            synchronized (o.class) {
                if (oxl == null) {
                    oxl = new o();
                }
            }
        }
        return oxl;
    }

    private o() {
    }

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mRect = rect;
        this.ovz = tbPageContext;
        this.oxn = alaLiveRoomBlurPageLayout;
    }

    public void ebp() {
        if (this.oxm != null) {
            this.oxm.loadData();
        }
    }

    public ViewGroup ebq() {
        if (this.oxm != null) {
            return this.oxm.ebq();
        }
        return null;
    }

    public List<AlaWheatInfoData> Wx() {
        if (this.oxm != null) {
            return this.oxm.Wx();
        }
        return null;
    }

    public List<AlaWheatInfoData> Ww() {
        if (this.oxm != null) {
            return this.oxm.Ww();
        }
        return null;
    }

    public List<AlaWheatInfoData> ebr() {
        if (this.oxm != null) {
            return this.oxm.ebr();
        }
        return null;
    }

    public boolean ebs() {
        if (this.oxm != null) {
            return this.oxm.ebs();
        }
        return false;
    }

    public boolean eaE() {
        if (this.oxm != null) {
            return this.oxm.eaE();
        }
        return false;
    }

    public boolean ic(String str) {
        if (this.oxm != null) {
            return this.oxm.ic(str);
        }
        return false;
    }

    public boolean UU(String str) {
        if (this.oxm != null) {
            return this.oxm.UU(str);
        }
        return false;
    }

    public String Wz() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Wz();
    }

    public boolean ib(String str) {
        if (this.oxm != null) {
            return this.oxm.ib(str);
        }
        return false;
    }

    public boolean id(String str) {
        if (this.oxm == null || str == null) {
            return false;
        }
        return this.oxm.id(str);
    }

    public boolean Vr(String str) {
        if (this.oxm == null || str == null) {
            return false;
        }
        return this.oxm.Vr(str);
    }

    public AlaWheatInfoData ie(String str) {
        if (this.oxm != null) {
            return this.oxm.ie(str);
        }
        return null;
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        if (this.oxm != null) {
            return this.oxm.bi(str, z);
        }
        return null;
    }

    public int ebt() {
        if (this.oxm != null) {
            return this.oxm.ebt();
        }
        return -1;
    }

    public TbPageContext ebu() {
        if (this.oxm != null) {
            return this.oxm.ebu();
        }
        return null;
    }

    public boolean isApplying() {
        if (this.oxm != null) {
            return this.oxm.isApplying();
        }
        return false;
    }

    public void setMaskBg(boolean z) {
        if (this.oxm != null) {
            this.oxm.setMaskBg(z);
        }
    }

    public void zM(boolean z) {
        if (this.oxm != null) {
            this.oxm.zM(z);
        }
    }

    public void zN(boolean z) {
        if (this.oxm != null) {
            this.oxm.zN(z);
        }
    }

    public void m(x xVar) {
        if (xVar != null && xVar.aGD != null) {
            xVar.aGD.isEnterLiveData = true;
            am(xVar);
            if (this.oxm != null) {
                this.oxm.a(this.oxp);
                this.oxm.m(xVar);
            }
            registerListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(x xVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = xVar.aGD;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            if (this.oxm == null || !(this.oxm instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
                this.oxm = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
                this.oxm.a(this.ovz, this.oxn, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            if (this.oxm == null || !(this.oxm instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c)) {
                this.oxm = new com.baidu.tieba.yuyinala.liveroom.wheat.d.c();
                this.oxm.a(this.ovz, this.oxn, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
            if (this.oxm == null || !(this.oxm instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d)) {
                this.oxm = new com.baidu.tieba.yuyinala.liveroom.wheat.d.d();
                this.oxm.a(this.ovz, this.oxn, this.mRect);
            }
        } else if (this.oxm == null || !(this.oxm instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
            this.oxm = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
            this.oxm.a(this.ovz, this.oxn, this.mRect);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if ((r4.oxm instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
        if ((r4.oxm instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
        if ((r4.oxm instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean an(x xVar) {
        boolean z = true;
        if (xVar.aGP) {
            xVar.aGP = false;
            return false;
        } else if (ebv()) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = xVar.aGD;
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.oxm != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                if (this.oxm != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() != 2) {
                z = false;
            } else if (this.oxm != null) {
            }
            return z;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ao(x xVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = xVar.aGD;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            return this.oxm == null || !(this.oxm instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            return this.oxm == null || !(this.oxm instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
            return this.oxm == null || !(this.oxm instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d);
        } else {
            return false;
        }
    }

    private boolean ebv() {
        if (com.baidu.live.af.a.OJ().bru == null || com.baidu.live.af.a.OJ().bru.aKD == null || com.baidu.live.af.a.OJ().bru.aKD.aOf == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.ebS().a(com.baidu.live.af.a.OJ().bru.aKD.aOf.Bp(), true);
    }

    public void zH() {
        if (this.oxm != null) {
            this.oxm.zH();
        }
        onDestroy();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().onDestroy();
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oxp = bVar;
    }

    public void zO(boolean z) {
        if (this.oxm != null) {
            this.oxm.zO(z);
        }
    }

    public boolean ebw() {
        if (this.oxm != null) {
            return this.oxm.ebw();
        }
        return false;
    }

    private void registerListener() {
        onDestroy();
        MessageManager.getInstance().registerListener(this.aZa);
        com.baidu.live.aq.a.Wu().a(this.oxB);
        MessageManager.getInstance().registerListener(this.oxu);
        MessageManager.getInstance().registerListener(this.oxy);
        MessageManager.getInstance().registerListener(this.oxx);
        MessageManager.getInstance().registerListener(this.oxz);
        MessageManager.getInstance().registerListener(this.oxA);
        MessageManager.getInstance().registerListener(this.oxv);
        MessageManager.getInstance().registerListener(this.oxw);
        ebB();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aZa);
        MessageManager.getInstance().unRegisterListener(this.oxu);
        MessageManager.getInstance().unRegisterListener(this.oxv);
        MessageManager.getInstance().unRegisterListener(this.oxx);
        MessageManager.getInstance().unRegisterListener(this.oxy);
        MessageManager.getInstance().unRegisterListener(this.oxz);
        MessageManager.getInstance().unRegisterListener(this.oxA);
        MessageManager.getInstance().unRegisterListener(this.oxw);
        ebC();
        if (this.oxm != null) {
            this.oxm.onDestroy();
        }
    }

    public void cJD() {
        if (this.oxm != null) {
            this.oxm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(final x xVar) {
        final AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = xVar.aGD;
        if (!ebo().ebw() && xVar != null && !xVar.aGP) {
            if (alaWheatInfoDataWrapper != null && alaWheatInfoDataWrapper.getRoomMode() == 0) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_common_mode_text)).show();
            } else if (alaWheatInfoDataWrapper != null && alaWheatInfoDataWrapper.getRoomMode() == 1) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_dating_mode_text)).show();
            } else if (alaWheatInfoDataWrapper != null && alaWheatInfoDataWrapper.getRoomMode() == 2) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_team_fight_mode_text)).show();
            }
        }
        if (an(xVar)) {
            if (System.currentTimeMillis() - this.oxr > 1500) {
                this.oxr = System.currentTimeMillis();
                View findViewById = (this.ovz == null || this.ovz.getPageActivity() == null) ? null : this.ovz.getPageActivity().findViewById(a.f.ala_liveroom_view);
                if (findViewById != null && !this.oxs) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.ebS().a((ViewGroup) findViewById, (com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c) null);
                }
                this.oxs = true;
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!o.this.ebx()) {
                            o.this.am(xVar);
                            if (o.this.oxm != null) {
                                o.this.oxm.ar(xVar);
                            }
                            if (o.this.oxt != null) {
                                o.this.oxt.Lx(alaWheatInfoDataWrapper != null ? alaWheatInfoDataWrapper.getRoomMode() : 0);
                            }
                            o.this.oxs = false;
                        }
                    }
                }, 1400L);
                return;
            }
            this.oxs = false;
            return;
        }
        am(xVar);
        if (this.oxm != null) {
            this.oxm.ar(xVar);
        }
        if (this.oxt != null) {
            this.oxt.Lx(alaWheatInfoDataWrapper != null ? alaWheatInfoDataWrapper.getRoomMode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ebx() {
        return Build.VERSION.SDK_INT >= 17 ? this.ovz == null || this.ovz.getPageActivity() == null || this.ovz.getPageActivity().isFinishing() || this.ovz.getPageActivity().isDestroyed() : this.ovz == null || this.ovz.getPageActivity() == null || this.ovz.getPageActivity().isFinishing();
    }

    public void a(a aVar) {
        this.oxt = aVar;
    }

    public x WA() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eby() {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(this.ovz, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void onFail(int i, String str) {
            }
        }).gR(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().yv(), "1");
    }

    public void ebz() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eaz = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz();
        if (eaz != null) {
            if (eaE()) {
                if (eaz.eav() && eaz.eas() && !ib(Wz())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eaz2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz();
                            if (eaz2.eav() && eaz2.eas() && !o.this.ib(o.this.Wz())) {
                                eaz2.UX("dealExceptionHungUpWheat");
                                o.this.ebA();
                            }
                        }
                    }, this.oxo);
                } else if (eaz.eav() && !eaz.eas() && !ib(Wz())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.5
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eaz2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz();
                            if (eaz2.eav() && !eaz2.eas() && !o.this.ib(o.this.Wz())) {
                                eaz2.eap();
                            }
                        }
                    }, this.oxo);
                } else if (!eaz.eav() && eaz.eas() && ib(Wz())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.6
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eaz2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz();
                            if (!eaz2.eav() && eaz2.eas() && o.this.ib(o.this.Wz())) {
                                o.this.J(true, "dealExceptionHungUpWheat");
                            }
                        }
                    }, this.oxo);
                } else if (!eaz.eav() && !eaz.eas() && ib(Wz())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.7
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eaz2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz();
                            if (!eaz2.eav() && !eaz2.eas() && o.this.ib(o.this.Wz())) {
                                o.this.J(true, "dealExceptionHungUpWheat");
                                eaz2.eap();
                            }
                        }
                    }, this.oxo);
                } else if (eaz.eav() && eaz.eas() && ib(Wz())) {
                    eaz.aAl();
                }
            } else if (eaz.eas() && !ib(Wz())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.8
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eaz2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz();
                        if (eaz2 != null && eaz2.eas() && !o.this.ib(o.this.Wz())) {
                            eaz2.UX("dealExceptionHungUpWheat");
                            o.this.ebA();
                        }
                    }
                }, this.oxo);
            } else if (!eaz.eas() && ((eaz.eai() == 0 || eaz.eai() == 4 || eaz.eai() == 3) && ib(Wz()))) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eaz2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz();
                        if (!eaz2.eas()) {
                            if ((eaz2.eai() == 0 || eaz2.eai() == 4 || eaz2.eai() == 3) && o.this.ib(o.this.Wz())) {
                                o.this.J(true, "dealExceptionHungUpWheat");
                            }
                        }
                    }
                }, this.oxo);
            } else if (eaz.eas() && ib(Wz()) && eaz.eak()) {
                eaz.aAl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebA() {
        if (!eaE()) {
            e.eaX().onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501071));
        }
    }

    public void J(boolean z, String str) {
        String str2;
        if (z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eaz = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz();
            if (eaz != null) {
                String eaw = eaz.eaw();
                if (eaE()) {
                    str2 = eaw + "#" + System.currentTimeMillis() + ":" + str + ",isOwnerJoinChat:" + eaz.eav() + ",mIsSelfInRctRoom:" + eaz.eas() + ",isOwner:true";
                } else {
                    str2 = eaw + "#" + System.currentTimeMillis() + ":" + str + ",mIsSelfInRctRoom:" + eaz.eas() + ",getRtcStatus:" + eaz.eai() + ",isOwner:false";
                }
                int length = str2.length();
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.otO) {
                    Log.i("AudioRoom", str2);
                }
                if (str2 != null && length > 1900) {
                    str2 = str2.substring(length - 1900, length);
                }
            } else {
                str2 = null;
            }
            new com.baidu.tieba.yuyinala.liveroom.wheat.model.f(null, new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.10
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
                public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_rtc_room_succ_anchor_7", false);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        x WA = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
                        if (WA != null && WA.aGy != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
                        }
                        jSONObject.put("error_code", 10004);
                        jSONObject.put("error_msg", "兜底下麦：" + com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().eaw());
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "lost_chat").setContentExt(jSONObject));
                    o.this.ebA();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
                public void onFail(int i, String str3) {
                }
            }).d(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().yv(), ebo().Wz(), 1, str2);
            return;
        }
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.f(null, new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.11
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void onFail(int i, String str3) {
            }
        }).gR(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().yv(), ebo().Wz());
    }

    private void ebB() {
        if (this.ovz != null && this.ovz.getPageActivity() != null) {
            this.mBroadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.13
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (TextUtils.equals(intent.getAction(), "com.baidu.open.log.debug")) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a.otO = true;
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.otO = true;
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.open.log.debug");
            this.oxq = true;
            this.ovz.getPageActivity().registerReceiver(this.mBroadcastReceiver, intentFilter);
        }
    }

    private void ebC() {
        if (this.ovz != null && this.ovz.getPageActivity() != null && this.mBroadcastReceiver != null && this.oxq) {
            this.oxq = false;
            this.ovz.getPageActivity().unregisterReceiver(this.mBroadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    public int getWheatHeight() {
        if (this.oxm != null) {
            return this.oxm.getWheatHeight();
        }
        return 0;
    }

    public boolean ebD() {
        return this.oxs;
    }

    public boolean aq(x xVar) {
        return (xVar == null || xVar.mLiveInfo == null || xVar.mLiveInfo.live_status != 2) ? false : true;
    }

    public boolean ebE() {
        x WA = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
        return (WA == null || WA.aGD == null || WA.aGD.getRoomMode() != 2) ? false : true;
    }
}
