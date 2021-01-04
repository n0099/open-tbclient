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
    private static o oBR;
    private BroadcastReceiver mBroadcastReceiver;
    private Rect mRect;
    private TbPageContext oAf;
    private com.baidu.tieba.yuyinala.liveroom.wheat.d.a oBS;
    private AlaLiveRoomBlurPageLayout oBT;
    private com.baidu.tieba.yuyinala.player.b oBV;
    private boolean oBW;
    private long oBX;
    private boolean oBY;
    private a oBZ;
    private long oBU = 10000;
    private CustomMessageListener bdO = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof x)) {
                x xVar = (x) customResponsedMessage.getData();
                if (o.this.aq(xVar)) {
                    if (o.this.oBS != null) {
                        ViewGroup efh = o.this.oBS.efh();
                        if (efh != null && efh.getParent() != null) {
                            ((ViewGroup) efh.getParent()).removeView(efh);
                        }
                        o.this.oBS.onDestroy();
                        o.this.oBS = null;
                        return;
                    }
                    return;
                }
                if (o.this.ao(xVar)) {
                    o.this.ap(xVar);
                } else if (o.this.oBS != null) {
                    o.this.oBS.ar(xVar);
                }
                o.this.efq();
            }
        }
    };
    private CustomMessageListener oCa = new CustomMessageListener(2501009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501009) {
                if (customResponsedMessage.getData() == null) {
                    if (o.this.oBS != null) {
                        o.this.oBS.loadData();
                    }
                } else if ((customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).contains(Headers.REFRESH) && o.this.oBS != null) {
                    o.this.oBS.egg();
                }
            }
        }
    };
    private CustomMessageListener oCb = new CustomMessageListener(2501022) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501022 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = (String) hashMap.get("user_uk");
                String str2 = (String) hashMap.get("webp_url");
                String str3 = (String) hashMap.get("result_url");
                if (o.this.oBS != null) {
                    o.this.oBS.aT(str, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener oCc = new CustomMessageListener(2501076) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501076 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaWheatMoreFunctionData)) {
                new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h(o.this.oAf, (AlaWheatMoreFunctionData) customResponsedMessage.getData()).show();
            }
        }
    };
    private CustomMessageListener oCd = new CustomMessageListener(2501024) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501024 && customResponsedMessage.getData() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Wl(str).Cv();
                }
            }
        }
    };
    private CustomMessageListener oCe = new CustomMessageListener(2501026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.18
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
                        if (optBoolean || (!optBoolean && !o.this.Wd(optString))) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.18.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (TextUtils.equals(optString2, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq())) {
                                        if (optInt == 1) {
                                            if (o.this.oBS != null) {
                                                o.this.oBS.WK(optString);
                                            }
                                        } else if (o.this.oBS != null) {
                                            o.this.oBS.WL(optString);
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
    private CustomMessageListener oCf = new CustomMessageListener(2501023) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501023 && customResponsedMessage.getData() != null && o.this.oBS != null) {
                o.this.oBS.loadData();
            }
        }
    };
    private CustomMessageListener oCg = new CustomMessageListener(2501077) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage == null || customResponsedMessage.getCmd() == 2501077) && o.this.oBS != null && (o.this.oBS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d)) {
                ((com.baidu.tieba.yuyinala.liveroom.wheat.d.d) o.this.oBS).setTeamFightProgressData((String) customResponsedMessage.getData());
            }
        }
    };
    com.baidu.live.aq.b oCh = new com.baidu.live.aq.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.2
        @Override // com.baidu.live.aq.b
        public boolean isApplying() {
            if (o.this.oBS != null) {
                return o.this.oBS.isApplying();
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public boolean jm(String str) {
            if (o.this.oBS != null) {
                return o.this.oBS.jm(str);
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public boolean jn(String str) {
            if (o.this.oBS != null) {
                return o.this.oBS.jn(str);
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public boolean jo(String str) {
            if (o.this.oBS != null) {
                return o.this.oBS.jo(str);
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public AlaWheatInfoData jp(String str) {
            if (o.this.oBS != null) {
                return o.this.oBS.WJ(str);
            }
            return null;
        }

        @Override // com.baidu.live.aq.b
        public AlaWheatInfoData aan() {
            if (o.this.oBS != null) {
                return o.this.oBS.aan();
            }
            return null;
        }

        @Override // com.baidu.live.aq.b
        public void G(String str, boolean z) {
            if (o.this.oBS != null) {
                o.this.oBS.G(str, z);
            }
        }

        @Override // com.baidu.live.aq.b
        public boolean jq(String str) {
            if (o.this.oBS != null) {
                return o.this.oBS.jq(str);
            }
            return false;
        }

        @Override // com.baidu.live.aq.b
        public List<AlaWheatInfoData> aao() {
            if (o.this.oBS != null) {
                return o.this.oBS.aao();
            }
            return null;
        }

        @Override // com.baidu.live.aq.b
        public List<AlaWheatInfoData> aap() {
            if (o.this.oBS != null) {
                return o.this.oBS.aap();
            }
            return null;
        }

        @Override // com.baidu.live.aq.b
        public String aaq() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aaq();
        }

        @Override // com.baidu.live.aq.b
        public String aar() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aar();
        }

        @Override // com.baidu.live.aq.b
        public String getCustomRoomId() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().getCustomRoomId();
        }

        @Override // com.baidu.live.aq.b
        public x aas() {
            return o.this.aas();
        }

        @Override // com.baidu.live.aq.b
        public String aat() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aat();
        }

        @Override // com.baidu.live.aq.b
        public void muteOrUnmuteAudio(boolean z) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq() != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().muteOrUnmuteAudio(z);
            }
        }

        @Override // com.baidu.live.aq.b
        public void aau() {
            o.this.J(false, "");
        }

        @Override // com.baidu.live.aq.b
        public void aav() {
            o.this.efp();
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void Ne(int i);
    }

    public static o eff() {
        if (oBR == null) {
            synchronized (o.class) {
                if (oBR == null) {
                    oBR = new o();
                }
            }
        }
        return oBR;
    }

    private o() {
    }

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mRect = rect;
        this.oAf = tbPageContext;
        this.oBT = alaLiveRoomBlurPageLayout;
    }

    public void efg() {
        if (this.oBS != null) {
            this.oBS.loadData();
        }
    }

    public ViewGroup efh() {
        if (this.oBS != null) {
            return this.oBS.efh();
        }
        return null;
    }

    public List<AlaWheatInfoData> aap() {
        if (this.oBS != null) {
            return this.oBS.aap();
        }
        return null;
    }

    public List<AlaWheatInfoData> aao() {
        if (this.oBS != null) {
            return this.oBS.aao();
        }
        return null;
    }

    public List<AlaWheatInfoData> efi() {
        if (this.oBS != null) {
            return this.oBS.efi();
        }
        return null;
    }

    public boolean efj() {
        if (this.oBS != null) {
            return this.oBS.efj();
        }
        return false;
    }

    public boolean eev() {
        if (this.oBS != null) {
            return this.oBS.eev();
        }
        return false;
    }

    public boolean jn(String str) {
        if (this.oBS != null) {
            return this.oBS.jn(str);
        }
        return false;
    }

    public boolean Wd(String str) {
        if (this.oBS != null) {
            return this.oBS.Wd(str);
        }
        return false;
    }

    public String aar() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aar();
    }

    public boolean jm(String str) {
        if (this.oBS != null) {
            return this.oBS.jm(str);
        }
        return false;
    }

    public boolean jo(String str) {
        if (this.oBS == null || str == null) {
            return false;
        }
        return this.oBS.jo(str);
    }

    public boolean WA(String str) {
        if (this.oBS == null || str == null) {
            return false;
        }
        return this.oBS.WA(str);
    }

    public AlaWheatInfoData jp(String str) {
        if (this.oBS != null) {
            return this.oBS.jp(str);
        }
        return null;
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        if (this.oBS != null) {
            return this.oBS.bi(str, z);
        }
        return null;
    }

    public int efk() {
        if (this.oBS != null) {
            return this.oBS.efk();
        }
        return -1;
    }

    public TbPageContext efl() {
        if (this.oBS != null) {
            return this.oBS.efl();
        }
        return null;
    }

    public boolean isApplying() {
        if (this.oBS != null) {
            return this.oBS.isApplying();
        }
        return false;
    }

    public void setMaskBg(boolean z) {
        if (this.oBS != null) {
            this.oBS.setMaskBg(z);
        }
    }

    public void zQ(boolean z) {
        if (this.oBS != null) {
            this.oBS.zQ(z);
        }
    }

    public void zR(boolean z) {
        if (this.oBS != null) {
            this.oBS.zR(z);
        }
    }

    public void m(x xVar) {
        if (xVar != null && xVar.aLq != null) {
            xVar.aLq.isEnterLiveData = true;
            am(xVar);
            if (this.oBS != null) {
                this.oBS.a(this.oBV);
                this.oBS.m(xVar);
            }
            registerListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(x xVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = xVar.aLq;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            if (this.oBS == null || !(this.oBS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
                this.oBS = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
                this.oBS.a(this.oAf, this.oBT, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            if (this.oBS == null || !(this.oBS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c)) {
                this.oBS = new com.baidu.tieba.yuyinala.liveroom.wheat.d.c();
                this.oBS.a(this.oAf, this.oBT, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
            if (this.oBS == null || !(this.oBS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d)) {
                this.oBS = new com.baidu.tieba.yuyinala.liveroom.wheat.d.d();
                this.oBS.a(this.oAf, this.oBT, this.mRect);
            }
        } else if (this.oBS == null || !(this.oBS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
            this.oBS = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
            this.oBS.a(this.oAf, this.oBT, this.mRect);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if ((r4.oBS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
        if ((r4.oBS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
        if ((r4.oBS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean an(x xVar) {
        boolean z = true;
        if (xVar.aLC) {
            xVar.aLC = false;
            return false;
        } else if (efm()) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = xVar.aLq;
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.oBS != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                if (this.oBS != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() != 2) {
                z = false;
            } else if (this.oBS != null) {
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
            return this.oBS == null || !(this.oBS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            return this.oBS == null || !(this.oBS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
            return this.oBS == null || !(this.oBS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d);
        } else {
            return false;
        }
    }

    private boolean efm() {
        if (com.baidu.live.af.a.SE().bwi == null || com.baidu.live.af.a.SE().bwi.aPq == null || com.baidu.live.af.a.SE().bwi.aPq.aSS == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efJ().a(com.baidu.live.af.a.SE().bwi.aPq.aSS.Fk(), true);
    }

    public void DC() {
        if (this.oBS != null) {
            this.oBS.DC();
        }
        onDestroy();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().onDestroy();
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oBV = bVar;
    }

    public void zS(boolean z) {
        if (this.oBS != null) {
            this.oBS.zS(z);
        }
    }

    public boolean efn() {
        if (this.oBS != null) {
            return this.oBS.efn();
        }
        return false;
    }

    private void registerListener() {
        onDestroy();
        MessageManager.getInstance().registerListener(this.bdO);
        com.baidu.live.aq.a.aam().a(this.oCh);
        MessageManager.getInstance().registerListener(this.oCa);
        MessageManager.getInstance().registerListener(this.oCe);
        MessageManager.getInstance().registerListener(this.oCd);
        MessageManager.getInstance().registerListener(this.oCf);
        MessageManager.getInstance().registerListener(this.oCg);
        MessageManager.getInstance().registerListener(this.oCb);
        MessageManager.getInstance().registerListener(this.oCc);
        efs();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bdO);
        MessageManager.getInstance().unRegisterListener(this.oCa);
        MessageManager.getInstance().unRegisterListener(this.oCb);
        MessageManager.getInstance().unRegisterListener(this.oCd);
        MessageManager.getInstance().unRegisterListener(this.oCe);
        MessageManager.getInstance().unRegisterListener(this.oCf);
        MessageManager.getInstance().unRegisterListener(this.oCg);
        MessageManager.getInstance().unRegisterListener(this.oCc);
        eft();
        if (this.oBS != null) {
            this.oBS.onDestroy();
        }
    }

    public void cNu() {
        if (this.oBS != null) {
            this.oBS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(final x xVar) {
        final AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = xVar.aLq;
        if (!eff().efn() && xVar != null && !xVar.aLC) {
            if (alaWheatInfoDataWrapper != null && alaWheatInfoDataWrapper.getRoomMode() == 0) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_common_mode_text)).show();
            } else if (alaWheatInfoDataWrapper != null && alaWheatInfoDataWrapper.getRoomMode() == 1) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_dating_mode_text)).show();
            } else if (alaWheatInfoDataWrapper != null && alaWheatInfoDataWrapper.getRoomMode() == 2) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_team_fight_mode_text)).show();
            }
        }
        if (an(xVar)) {
            if (System.currentTimeMillis() - this.oBX > 1500) {
                this.oBX = System.currentTimeMillis();
                View findViewById = (this.oAf == null || this.oAf.getPageActivity() == null) ? null : this.oAf.getPageActivity().findViewById(a.f.ala_liveroom_view);
                if (findViewById != null && !this.oBY) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efJ().a((ViewGroup) findViewById, (com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c) null);
                }
                this.oBY = true;
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!o.this.efo()) {
                            o.this.am(xVar);
                            if (o.this.oBS != null) {
                                o.this.oBS.ar(xVar);
                            }
                            if (o.this.oBZ != null) {
                                o.this.oBZ.Ne(alaWheatInfoDataWrapper != null ? alaWheatInfoDataWrapper.getRoomMode() : 0);
                            }
                            o.this.oBY = false;
                        }
                    }
                }, 1400L);
                return;
            }
            this.oBY = false;
            return;
        }
        am(xVar);
        if (this.oBS != null) {
            this.oBS.ar(xVar);
        }
        if (this.oBZ != null) {
            this.oBZ.Ne(alaWheatInfoDataWrapper != null ? alaWheatInfoDataWrapper.getRoomMode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean efo() {
        return Build.VERSION.SDK_INT >= 17 ? this.oAf == null || this.oAf.getPageActivity() == null || this.oAf.getPageActivity().isFinishing() || this.oAf.getPageActivity().isDestroyed() : this.oAf == null || this.oAf.getPageActivity() == null || this.oAf.getPageActivity().isFinishing();
    }

    public void a(a aVar) {
        this.oBZ = aVar;
    }

    public x aas() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efp() {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(this.oAf, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void onFail(int i, String str) {
            }
        }).gS(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq(), "1");
    }

    public void efq() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
        if (eeq != null) {
            if (eev()) {
                if (eeq.eem() && eeq.eej() && !jm(aar())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                            if (eeq2.eem() && eeq2.eej() && !o.this.jm(o.this.aar())) {
                                eeq2.Wg("dealExceptionHungUpWheat");
                                o.this.efr();
                            }
                        }
                    }, this.oBU);
                } else if (eeq.eem() && !eeq.eej() && !jm(aar())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.5
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                            if (eeq2.eem() && !eeq2.eej() && !o.this.jm(o.this.aar())) {
                                eeq2.eeg();
                            }
                        }
                    }, this.oBU);
                } else if (!eeq.eem() && eeq.eej() && jm(aar())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.6
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                            if (!eeq2.eem() && eeq2.eej() && o.this.jm(o.this.aar())) {
                                o.this.J(true, "dealExceptionHungUpWheat");
                            }
                        }
                    }, this.oBU);
                } else if (!eeq.eem() && !eeq.eej() && jm(aar())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.7
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                            if (!eeq2.eem() && !eeq2.eej() && o.this.jm(o.this.aar())) {
                                o.this.J(true, "dealExceptionHungUpWheat");
                                eeq2.eeg();
                            }
                        }
                    }, this.oBU);
                } else if (eeq.eem() && eeq.eej() && jm(aar())) {
                    eeq.aEe();
                }
            } else if (eeq.eej() && !jm(aar())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.8
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                        if (eeq2 != null && eeq2.eej() && !o.this.jm(o.this.aar())) {
                            eeq2.Wg("dealExceptionHungUpWheat");
                            o.this.efr();
                        }
                    }
                }, this.oBU);
            } else if (!eeq.eej() && ((eeq.edZ() == 0 || eeq.edZ() == 4 || eeq.edZ() == 3) && jm(aar()))) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                        if (!eeq2.eej()) {
                            if ((eeq2.edZ() == 0 || eeq2.edZ() == 4 || eeq2.edZ() == 3) && o.this.jm(o.this.aar())) {
                                o.this.J(true, "dealExceptionHungUpWheat");
                            }
                        }
                    }
                }, this.oBU);
            } else if (eeq.eej() && jm(aar()) && eeq.eeb()) {
                eeq.aEe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efr() {
        if (!eev()) {
            e.eeO().onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501071));
        }
    }

    public void J(boolean z, String str) {
        String str2;
        if (z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
            if (eeq != null) {
                String een = eeq.een();
                if (eev()) {
                    str2 = een + "#" + System.currentTimeMillis() + ":" + str + ",isOwnerJoinChat:" + eeq.eem() + ",mIsSelfInRctRoom:" + eeq.eej() + ",isOwner:true";
                } else {
                    str2 = een + "#" + System.currentTimeMillis() + ":" + str + ",mIsSelfInRctRoom:" + eeq.eej() + ",getRtcStatus:" + eeq.edZ() + ",isOwner:false";
                }
                int length = str2.length();
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyv) {
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
                        x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
                        if (aas != null && aas.aLl != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
                        }
                        jSONObject.put("error_code", 10004);
                        jSONObject.put("error_msg", "兜底下麦：" + com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().een());
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "lost_chat").setContentExt(jSONObject));
                    o.this.efr();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
                public void onFail(int i, String str3) {
                }
            }).d(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq(), eff().aar(), 1, str2);
            return;
        }
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.f(null, new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.11
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void onFail(int i, String str3) {
            }
        }).gS(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq(), eff().aar());
    }

    private void efs() {
        if (this.oAf != null && this.oAf.getPageActivity() != null) {
            this.mBroadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.o.13
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (TextUtils.equals(intent.getAction(), "com.baidu.open.log.debug")) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyv = true;
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.oyv = true;
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.open.log.debug");
            this.oBW = true;
            this.oAf.getPageActivity().registerReceiver(this.mBroadcastReceiver, intentFilter);
        }
    }

    private void eft() {
        if (this.oAf != null && this.oAf.getPageActivity() != null && this.mBroadcastReceiver != null && this.oBW) {
            this.oBW = false;
            this.oAf.getPageActivity().unregisterReceiver(this.mBroadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    public int getWheatHeight() {
        if (this.oBS != null) {
            return this.oBS.getWheatHeight();
        }
        return 0;
    }

    public boolean efu() {
        return this.oBY;
    }

    public boolean aq(x xVar) {
        return (xVar == null || xVar.mLiveInfo == null || xVar.mLiveInfo.live_status != 2) ? false : true;
    }

    public boolean efv() {
        x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
        return (aas == null || aas.aLq == null || aas.aLq.getRoomMode() != 2) ? false : true;
    }
}
