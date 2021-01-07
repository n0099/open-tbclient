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
/* loaded from: classes11.dex */
public class o {
    private static o oBQ;
    private BroadcastReceiver mBroadcastReceiver;
    private Rect mRect;
    private TbPageContext oAe;
    private com.baidu.tieba.yuyinala.liveroom.wheat.d.a oBR;
    private AlaLiveRoomBlurPageLayout oBS;
    private com.baidu.tieba.yuyinala.player.b oBU;
    private boolean oBV;
    private long oBW;
    private boolean oBX;
    private a oBY;
    private long oBT = 10000;
    private CustomMessageListener bdO = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof x)) {
                x xVar = (x) customResponsedMessage.getData();
                if (o.this.aq(xVar)) {
                    if (o.this.oBR != null) {
                        ViewGroup efi = o.this.oBR.efi();
                        if (efi != null && efi.getParent() != null) {
                            ((ViewGroup) efi.getParent()).removeView(efi);
                        }
                        o.this.oBR.onDestroy();
                        o.this.oBR = null;
                        return;
                    }
                    return;
                }
                if (o.this.ao(xVar)) {
                    o.this.ap(xVar);
                } else if (o.this.oBR != null) {
                    o.this.oBR.ar(xVar);
                }
                o.this.efr();
            }
        }
    };
    private CustomMessageListener oBZ = new CustomMessageListener(2501009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501009) {
                if (customResponsedMessage.getData() == null) {
                    if (o.this.oBR != null) {
                        o.this.oBR.loadData();
                    }
                } else if ((customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).contains(Headers.REFRESH) && o.this.oBR != null) {
                    o.this.oBR.egh();
                }
            }
        }
    };
    private CustomMessageListener oCa = new CustomMessageListener(2501022) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501022 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = (String) hashMap.get("user_uk");
                String str2 = (String) hashMap.get("webp_url");
                String str3 = (String) hashMap.get("result_url");
                if (o.this.oBR != null) {
                    o.this.oBR.aT(str, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener oCb = new CustomMessageListener(2501076) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501076 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaWheatMoreFunctionData)) {
                new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h(o.this.oAe, (AlaWheatMoreFunctionData) customResponsedMessage.getData()).show();
            }
        }
    };
    private CustomMessageListener oCc = new CustomMessageListener(2501024) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501024 && customResponsedMessage.getData() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Wk(str).Cv();
                }
            }
        }
    };
    private CustomMessageListener oCd = new CustomMessageListener(2501026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.18
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
                        if (optBoolean || (!optBoolean && !o.this.Wc(optString))) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.18.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (TextUtils.equals(optString2, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq())) {
                                        if (optInt == 1) {
                                            if (o.this.oBR != null) {
                                                o.this.oBR.WJ(optString);
                                            }
                                        } else if (o.this.oBR != null) {
                                            o.this.oBR.WK(optString);
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
    private CustomMessageListener oCe = new CustomMessageListener(2501023) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501023 && customResponsedMessage.getData() != null && o.this.oBR != null) {
                o.this.oBR.loadData();
            }
        }
    };
    private CustomMessageListener oCf = new CustomMessageListener(2501077) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage == null || customResponsedMessage.getCmd() == 2501077) && o.this.oBR != null && (o.this.oBR instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d)) {
                ((com.baidu.tieba.yuyinala.liveroom.wheat.d.d) o.this.oBR).setTeamFightProgressData((String) customResponsedMessage.getData());
            }
        }
    };
    com.baidu.live.aq.b oCg = new com.baidu.live.aq.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.2
        @Override // com.baidu.live.aq.b
        public boolean isApplying() {
            if (o.this.oBR != null) {
                return o.this.oBR.isApplying();
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public boolean jm(String str) {
            if (o.this.oBR != null) {
                return o.this.oBR.jm(str);
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public boolean jn(String str) {
            if (o.this.oBR != null) {
                return o.this.oBR.jn(str);
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public boolean jo(String str) {
            if (o.this.oBR != null) {
                return o.this.oBR.jo(str);
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public AlaWheatInfoData jp(String str) {
            if (o.this.oBR != null) {
                return o.this.oBR.WI(str);
            }
            return null;
        }

        @Override // com.baidu.live.aq.b
        public AlaWheatInfoData aao() {
            if (o.this.oBR != null) {
                return o.this.oBR.aao();
            }
            return null;
        }

        @Override // com.baidu.live.aq.b
        public void G(String str, boolean z) {
            if (o.this.oBR != null) {
                o.this.oBR.G(str, z);
            }
        }

        @Override // com.baidu.live.aq.b
        public boolean jq(String str) {
            if (o.this.oBR != null) {
                return o.this.oBR.jq(str);
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public List<AlaWheatInfoData> aap() {
            if (o.this.oBR != null) {
                return o.this.oBR.aap();
            }
            return null;
        }

        @Override // com.baidu.live.aq.b
        public List<AlaWheatInfoData> aaq() {
            if (o.this.oBR != null) {
                return o.this.oBR.aaq();
            }
            return null;
        }

        @Override // com.baidu.live.aq.b
        public String aar() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aar();
        }

        @Override // com.baidu.live.aq.b
        public String aas() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aas();
        }

        @Override // com.baidu.live.aq.b
        public String getCustomRoomId() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().getCustomRoomId();
        }

        @Override // com.baidu.live.aq.b
        public x aat() {
            return o.this.aat();
        }

        @Override // com.baidu.live.aq.b
        public String aau() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aau();
        }

        @Override // com.baidu.live.aq.b
        public void muteOrUnmuteAudio(boolean z) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer() != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().muteOrUnmuteAudio(z);
            }
        }

        @Override // com.baidu.live.aq.b
        public void aav() {
            o.this.J(false, "");
        }

        @Override // com.baidu.live.aq.b
        public void aaw() {
            o.this.efq();
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void Ne(int i);
    }

    public static o efg() {
        if (oBQ == null) {
            synchronized (o.class) {
                if (oBQ == null) {
                    oBQ = new o();
                }
            }
        }
        return oBQ;
    }

    private o() {
    }

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mRect = rect;
        this.oAe = tbPageContext;
        this.oBS = alaLiveRoomBlurPageLayout;
    }

    public void efh() {
        if (this.oBR != null) {
            this.oBR.loadData();
        }
    }

    public ViewGroup efi() {
        if (this.oBR != null) {
            return this.oBR.efi();
        }
        return null;
    }

    public List<AlaWheatInfoData> aaq() {
        if (this.oBR != null) {
            return this.oBR.aaq();
        }
        return null;
    }

    public List<AlaWheatInfoData> aap() {
        if (this.oBR != null) {
            return this.oBR.aap();
        }
        return null;
    }

    public List<AlaWheatInfoData> efj() {
        if (this.oBR != null) {
            return this.oBR.efj();
        }
        return null;
    }

    public boolean efk() {
        if (this.oBR != null) {
            return this.oBR.efk();
        }
        return false;
    }

    public boolean eew() {
        if (this.oBR != null) {
            return this.oBR.eew();
        }
        return false;
    }

    public boolean jn(String str) {
        if (this.oBR != null) {
            return this.oBR.jn(str);
        }
        return false;
    }

    public boolean Wc(String str) {
        if (this.oBR != null) {
            return this.oBR.Wc(str);
        }
        return false;
    }

    public String aas() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aas();
    }

    public boolean jm(String str) {
        if (this.oBR != null) {
            return this.oBR.jm(str);
        }
        return false;
    }

    public boolean jo(String str) {
        if (this.oBR == null || str == null) {
            return false;
        }
        return this.oBR.jo(str);
    }

    public boolean Wz(String str) {
        if (this.oBR == null || str == null) {
            return false;
        }
        return this.oBR.Wz(str);
    }

    public AlaWheatInfoData jp(String str) {
        if (this.oBR != null) {
            return this.oBR.jp(str);
        }
        return null;
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        if (this.oBR != null) {
            return this.oBR.bi(str, z);
        }
        return null;
    }

    public int efl() {
        if (this.oBR != null) {
            return this.oBR.efl();
        }
        return -1;
    }

    public TbPageContext efm() {
        if (this.oBR != null) {
            return this.oBR.efm();
        }
        return null;
    }

    public boolean isApplying() {
        if (this.oBR != null) {
            return this.oBR.isApplying();
        }
        return false;
    }

    public void setMaskBg(boolean z) {
        if (this.oBR != null) {
            this.oBR.setMaskBg(z);
        }
    }

    public void zQ(boolean z) {
        if (this.oBR != null) {
            this.oBR.zQ(z);
        }
    }

    public void zR(boolean z) {
        if (this.oBR != null) {
            this.oBR.zR(z);
        }
    }

    public void m(x xVar) {
        if (xVar != null && xVar.aLq != null) {
            xVar.aLq.isEnterLiveData = true;
            am(xVar);
            if (this.oBR != null) {
                this.oBR.a(this.oBU);
                this.oBR.m(xVar);
            }
            registerListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(x xVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = xVar.aLq;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            if (this.oBR == null || !(this.oBR instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
                this.oBR = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
                this.oBR.a(this.oAe, this.oBS, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            if (this.oBR == null || !(this.oBR instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c)) {
                this.oBR = new com.baidu.tieba.yuyinala.liveroom.wheat.d.c();
                this.oBR.a(this.oAe, this.oBS, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
            if (this.oBR == null || !(this.oBR instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d)) {
                this.oBR = new com.baidu.tieba.yuyinala.liveroom.wheat.d.d();
                this.oBR.a(this.oAe, this.oBS, this.mRect);
            }
        } else if (this.oBR == null || !(this.oBR instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
            this.oBR = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
            this.oBR.a(this.oAe, this.oBS, this.mRect);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if ((r4.oBR instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
        if ((r4.oBR instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
        if ((r4.oBR instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean an(x xVar) {
        boolean z = true;
        if (xVar.aLC) {
            xVar.aLC = false;
            return false;
        } else if (efn()) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = xVar.aLq;
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.oBR != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                if (this.oBR != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() != 2) {
                z = false;
            } else if (this.oBR != null) {
            }
            return z;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ao(x xVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = xVar.aLq;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            return this.oBR == null || !(this.oBR instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            return this.oBR == null || !(this.oBR instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
            return this.oBR == null || !(this.oBR instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d);
        } else {
            return false;
        }
    }

    private boolean efn() {
        if (com.baidu.live.af.a.SE().bwi == null || com.baidu.live.af.a.SE().bwi.aPq == null || com.baidu.live.af.a.SE().bwi.aPq.aSS == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efK().a(com.baidu.live.af.a.SE().bwi.aPq.aSS.Fk(), true);
    }

    public void DC() {
        if (this.oBR != null) {
            this.oBR.DC();
        }
        onDestroy();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().onDestroy();
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oBU = bVar;
    }

    public void zS(boolean z) {
        if (this.oBR != null) {
            this.oBR.zS(z);
        }
    }

    public boolean efo() {
        if (this.oBR != null) {
            return this.oBR.efo();
        }
        return false;
    }

    private void registerListener() {
        onDestroy();
        MessageManager.getInstance().registerListener(this.bdO);
        com.baidu.live.aq.a.aan().a(this.oCg);
        MessageManager.getInstance().registerListener(this.oBZ);
        MessageManager.getInstance().registerListener(this.oCd);
        MessageManager.getInstance().registerListener(this.oCc);
        MessageManager.getInstance().registerListener(this.oCe);
        MessageManager.getInstance().registerListener(this.oCf);
        MessageManager.getInstance().registerListener(this.oCa);
        MessageManager.getInstance().registerListener(this.oCb);
        eft();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bdO);
        MessageManager.getInstance().unRegisterListener(this.oBZ);
        MessageManager.getInstance().unRegisterListener(this.oCa);
        MessageManager.getInstance().unRegisterListener(this.oCc);
        MessageManager.getInstance().unRegisterListener(this.oCd);
        MessageManager.getInstance().unRegisterListener(this.oCe);
        MessageManager.getInstance().unRegisterListener(this.oCf);
        MessageManager.getInstance().unRegisterListener(this.oCb);
        efu();
        if (this.oBR != null) {
            this.oBR.onDestroy();
        }
    }

    public void cNv() {
        if (this.oBR != null) {
            this.oBR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(final x xVar) {
        final AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = xVar.aLq;
        if (!efg().efo() && xVar != null && !xVar.aLC) {
            if (alaWheatInfoDataWrapper != null && alaWheatInfoDataWrapper.getRoomMode() == 0) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_common_mode_text)).show();
            } else if (alaWheatInfoDataWrapper != null && alaWheatInfoDataWrapper.getRoomMode() == 1) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_dating_mode_text)).show();
            } else if (alaWheatInfoDataWrapper != null && alaWheatInfoDataWrapper.getRoomMode() == 2) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_team_fight_mode_text)).show();
            }
        }
        if (an(xVar)) {
            if (System.currentTimeMillis() - this.oBW > 1500) {
                this.oBW = System.currentTimeMillis();
                View findViewById = (this.oAe == null || this.oAe.getPageActivity() == null) ? null : this.oAe.getPageActivity().findViewById(a.f.ala_liveroom_view);
                if (findViewById != null && !this.oBX) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efK().a((ViewGroup) findViewById, (com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c) null);
                }
                this.oBX = true;
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!o.this.efp()) {
                            o.this.am(xVar);
                            if (o.this.oBR != null) {
                                o.this.oBR.ar(xVar);
                            }
                            if (o.this.oBY != null) {
                                o.this.oBY.Ne(alaWheatInfoDataWrapper != null ? alaWheatInfoDataWrapper.getRoomMode() : 0);
                            }
                            o.this.oBX = false;
                        }
                    }
                }, 1400L);
                return;
            }
            this.oBX = false;
            return;
        }
        am(xVar);
        if (this.oBR != null) {
            this.oBR.ar(xVar);
        }
        if (this.oBY != null) {
            this.oBY.Ne(alaWheatInfoDataWrapper != null ? alaWheatInfoDataWrapper.getRoomMode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean efp() {
        return Build.VERSION.SDK_INT >= 17 ? this.oAe == null || this.oAe.getPageActivity() == null || this.oAe.getPageActivity().isFinishing() || this.oAe.getPageActivity().isDestroyed() : this.oAe == null || this.oAe.getPageActivity() == null || this.oAe.getPageActivity().isFinishing();
    }

    public void a(a aVar) {
        this.oBY = aVar;
    }

    public x aat() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efq() {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(this.oAe, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void onFail(int i, String str) {
            }
        }).gS(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq(), "1");
    }

    public void efr() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
        if (eer != null) {
            if (eew()) {
                if (eer.een() && eer.eek() && !jm(aas())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                            if (eer2.een() && eer2.eek() && !o.this.jm(o.this.aas())) {
                                eer2.Wf("dealExceptionHungUpWheat");
                                o.this.efs();
                            }
                        }
                    }, this.oBT);
                } else if (eer.een() && !eer.eek() && !jm(aas())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.5
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                            if (eer2.een() && !eer2.eek() && !o.this.jm(o.this.aas())) {
                                eer2.eeh();
                            }
                        }
                    }, this.oBT);
                } else if (!eer.een() && eer.eek() && jm(aas())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.6
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                            if (!eer2.een() && eer2.eek() && o.this.jm(o.this.aas())) {
                                o.this.J(true, "dealExceptionHungUpWheat");
                            }
                        }
                    }, this.oBT);
                } else if (!eer.een() && !eer.eek() && jm(aas())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.7
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                            if (!eer2.een() && !eer2.eek() && o.this.jm(o.this.aas())) {
                                o.this.J(true, "dealExceptionHungUpWheat");
                                eer2.eeh();
                            }
                        }
                    }, this.oBT);
                } else if (eer.een() && eer.eek() && jm(aas())) {
                    eer.aEf();
                }
            } else if (eer.eek() && !jm(aas())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.8
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                        if (eer2 != null && eer2.eek() && !o.this.jm(o.this.aas())) {
                            eer2.Wf("dealExceptionHungUpWheat");
                            o.this.efs();
                        }
                    }
                }, this.oBT);
            } else if (!eer.eek() && ((eer.eea() == 0 || eer.eea() == 4 || eer.eea() == 3) && jm(aas()))) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                        if (!eer2.eek()) {
                            if ((eer2.eea() == 0 || eer2.eea() == 4 || eer2.eea() == 3) && o.this.jm(o.this.aas())) {
                                o.this.J(true, "dealExceptionHungUpWheat");
                            }
                        }
                    }
                }, this.oBT);
            } else if (eer.eek() && jm(aas()) && eer.eec()) {
                eer.aEf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efs() {
        if (!eew()) {
            e.eeP().onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501071));
        }
    }

    public void J(boolean z, String str) {
        String str2;
        if (z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
            if (eer != null) {
                String eeo = eer.eeo();
                if (eew()) {
                    str2 = eeo + "#" + System.currentTimeMillis() + ":" + str + ",isOwnerJoinChat:" + eer.een() + ",mIsSelfInRctRoom:" + eer.eek() + ",isOwner:true";
                } else {
                    str2 = eeo + "#" + System.currentTimeMillis() + ":" + str + ",mIsSelfInRctRoom:" + eer.eek() + ",getRtcStatus:" + eer.eea() + ",isOwner:false";
                }
                int length = str2.length();
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyu) {
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
                        x aat = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat();
                        if (aat != null && aat.aLl != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat.aLl.live_id);
                        }
                        jSONObject.put("error_code", 10004);
                        jSONObject.put("error_msg", "兜底下麦：" + com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().eeo());
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "lost_chat").setContentExt(jSONObject));
                    o.this.efs();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
                public void onFail(int i, String str3) {
                }
            }).d(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq(), efg().aas(), 1, str2);
            return;
        }
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.f(null, new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.11
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void onFail(int i, String str3) {
            }
        }).gS(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq(), efg().aas());
    }

    private void eft() {
        if (this.oAe != null && this.oAe.getPageActivity() != null) {
            this.mBroadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.13
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (TextUtils.equals(intent.getAction(), "com.baidu.open.log.debug")) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyu = true;
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.oyu = true;
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.open.log.debug");
            this.oBV = true;
            this.oAe.getPageActivity().registerReceiver(this.mBroadcastReceiver, intentFilter);
        }
    }

    private void efu() {
        if (this.oAe != null && this.oAe.getPageActivity() != null && this.mBroadcastReceiver != null && this.oBV) {
            this.oBV = false;
            this.oAe.getPageActivity().unregisterReceiver(this.mBroadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    public int getWheatHeight() {
        if (this.oBR != null) {
            return this.oBR.getWheatHeight();
        }
        return 0;
    }

    public boolean efv() {
        return this.oBX;
    }

    public boolean aq(x xVar) {
        return (xVar == null || xVar.mLiveInfo == null || xVar.mLiveInfo.live_status != 2) ? false : true;
    }

    public boolean efw() {
        x aat = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat();
        return (aat == null || aat.aLq == null || aat.aLq.getRoomMode() != 2) ? false : true;
    }
}
