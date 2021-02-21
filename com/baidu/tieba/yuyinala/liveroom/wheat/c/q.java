package com.baidu.tieba.yuyinala.liveroom.wheat.c;

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
import com.baidu.live.data.ab;
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
public class q {
    private static q oHr;
    private Rect mRect;
    private TbPageContext oGE;
    private com.baidu.tieba.yuyinala.liveroom.data.a oHA;
    private com.baidu.tieba.yuyinala.liveroom.wheat.d.a oHs;
    private AlaLiveRoomBlurPageLayout oHt;
    private com.baidu.tieba.yuyinala.player.b oHv;
    private long oHw;
    private boolean oHx;
    private a oHy;
    private p oHz;
    private long oHu = 10000;
    private CustomMessageListener bci = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                ab abVar = (ab) customResponsedMessage.getData();
                if (q.this.aq(abVar)) {
                    if (q.this.oHs != null) {
                        ViewGroup edO = q.this.oHs.edO();
                        if (edO != null && edO.getParent() != null) {
                            ((ViewGroup) edO.getParent()).removeView(edO);
                        }
                        q.this.oHs.onDestroy();
                        q.this.oHs = null;
                        return;
                    }
                    return;
                }
                if (q.this.ao(abVar)) {
                    q.this.ap(abVar);
                } else if (q.this.oHs != null) {
                    q.this.oHs.ar(abVar);
                }
                q.this.edX();
            }
        }
    };
    private CustomMessageListener oHB = new CustomMessageListener(2501009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501009) {
                if (customResponsedMessage.getData() == null) {
                    if (q.this.oHs != null) {
                        q.this.oHs.loadData();
                    }
                } else if ((customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).contains(Headers.REFRESH) && q.this.oHs != null) {
                    q.this.oHs.eeL();
                }
            }
        }
    };
    private CustomMessageListener oHC = new CustomMessageListener(2501022) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501022 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = (String) hashMap.get("user_uk");
                String str2 = (String) hashMap.get("webp_url");
                String str3 = (String) hashMap.get("result_url");
                if (q.this.oHs != null) {
                    q.this.oHs.aT(str, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener oHD = new CustomMessageListener(2501076) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501076 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaWheatMoreFunctionData)) {
                new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h(q.this.oGE, (AlaWheatMoreFunctionData) customResponsedMessage.getData()).show();
            }
        }
    };
    private CustomMessageListener oHE = new CustomMessageListener(2501084) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501084 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                if (q.this.oHz == null) {
                    q.this.oHz = new p();
                }
                q.this.oHz.a(q.this.oGE, (com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener oHF = new CustomMessageListener(2501024) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501024 && customResponsedMessage.getData() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Wm(str).yp();
                }
            }
        }
    };
    private CustomMessageListener oHG = new CustomMessageListener(2501026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.19
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
                        if (optBoolean || (!optBoolean && !q.this.Wf(optString))) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (TextUtils.equals(optString2, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym())) {
                                        if (optInt == 1) {
                                            if (q.this.oHs != null) {
                                                q.this.oHs.WM(optString);
                                            }
                                        } else if (q.this.oHs != null) {
                                            q.this.oHs.WN(optString);
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
    private CustomMessageListener oHH = new CustomMessageListener(2501023) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501023 && customResponsedMessage.getData() != null && q.this.oHs != null) {
                q.this.oHs.loadData();
            }
        }
    };
    private CustomMessageListener oHI = new CustomMessageListener(2501077) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage == null || customResponsedMessage.getCmd() == 2501077) && q.this.oHs != null && (q.this.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.e)) {
                ((com.baidu.tieba.yuyinala.liveroom.wheat.d.e) q.this.oHs).setTeamFightProgressData((String) customResponsedMessage.getData());
            }
        }
    };
    com.baidu.live.ao.b oHJ = new com.baidu.live.ao.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.3
        @Override // com.baidu.live.ao.b
        public boolean isApplying() {
            if (q.this.oHs != null) {
                return q.this.oHs.isApplying();
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public boolean iH(String str) {
            if (q.this.oHs != null) {
                return q.this.oHs.iH(str);
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public boolean Yk() {
            if (q.this.oHs != null) {
                return q.this.oHs.Yk();
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public boolean iI(String str) {
            if (q.this.oHs != null) {
                return q.this.oHs.iI(str);
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public boolean iJ(String str) {
            if (q.this.oHs != null) {
                return q.this.oHs.iJ(str);
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public AlaWheatInfoData iK(String str) {
            if (q.this.oHs != null) {
                return q.this.oHs.WL(str);
            }
            return null;
        }

        @Override // com.baidu.live.ao.b
        public AlaWheatInfoData Yl() {
            if (q.this.oHs != null) {
                return q.this.oHs.Yl();
            }
            return null;
        }

        @Override // com.baidu.live.ao.b
        public void G(String str, boolean z) {
            if (q.this.oHs != null) {
                q.this.oHs.G(str, z);
            }
        }

        @Override // com.baidu.live.ao.b
        public boolean iL(String str) {
            if (q.this.oHs != null) {
                return q.this.oHs.iL(str);
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public List<AlaWheatInfoData> Ym() {
            if (q.this.oHs != null) {
                return q.this.oHs.Ym();
            }
            return null;
        }

        @Override // com.baidu.live.ao.b
        public List<AlaWheatInfoData> Yn() {
            if (q.this.oHs != null) {
                return q.this.oHs.Yn();
            }
            return null;
        }

        @Override // com.baidu.live.ao.b
        public String Yo() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yo();
        }

        @Override // com.baidu.live.ao.b
        public String Yp() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Yp();
        }

        @Override // com.baidu.live.ao.b
        public String getCustomRoomId() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().getCustomRoomId();
        }

        @Override // com.baidu.live.ao.b
        public ab Yq() {
            return q.this.Yq();
        }

        @Override // com.baidu.live.ao.b
        public String Yr() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yr();
        }

        @Override // com.baidu.live.ao.b
        public void muteOrUnmuteAudio(boolean z) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT() != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().muteOrUnmuteAudio(z);
            }
        }

        @Override // com.baidu.live.ao.b
        public void Ys() {
            q.this.R(false, "");
        }

        @Override // com.baidu.live.ao.b
        public void Yt() {
            q.this.edW();
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void LT(int i);
    }

    public static q edM() {
        if (oHr == null) {
            synchronized (q.class) {
                if (oHr == null) {
                    oHr = new q();
                }
            }
        }
        return oHr;
    }

    private q() {
    }

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mRect = rect;
        this.oGE = tbPageContext;
        this.oHt = alaLiveRoomBlurPageLayout;
    }

    public void edN() {
        if (this.oHs != null) {
            this.oHs.loadData();
        }
    }

    public ViewGroup edO() {
        if (this.oHs != null) {
            return this.oHs.edO();
        }
        return null;
    }

    public List<AlaWheatInfoData> Yn() {
        if (this.oHs != null) {
            return this.oHs.Yn();
        }
        return null;
    }

    public List<AlaWheatInfoData> Ym() {
        if (this.oHs != null) {
            return this.oHs.Ym();
        }
        return null;
    }

    public List<AlaWheatInfoData> edP() {
        if (this.oHs != null) {
            return this.oHs.edP();
        }
        return null;
    }

    public boolean edQ() {
        if (this.oHs != null) {
            return this.oHs.edQ();
        }
        return false;
    }

    public boolean Yk() {
        if (this.oHs != null) {
            return this.oHs.Yk();
        }
        return false;
    }

    public boolean iI(String str) {
        if (this.oHs != null) {
            return this.oHs.iI(str);
        }
        return false;
    }

    public boolean Wf(String str) {
        if (this.oHs != null) {
            return this.oHs.Wf(str);
        }
        return false;
    }

    public String Yp() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Yp();
    }

    public boolean iH(String str) {
        if (this.oHs != null) {
            return this.oHs.iH(str);
        }
        return false;
    }

    public boolean iJ(String str) {
        if (this.oHs == null || str == null) {
            return false;
        }
        return this.oHs.iJ(str);
    }

    public boolean WD(String str) {
        if (this.oHs == null || str == null) {
            return false;
        }
        return this.oHs.WD(str);
    }

    public AlaWheatInfoData iK(String str) {
        if (this.oHs != null) {
            return this.oHs.iK(str);
        }
        return null;
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        if (this.oHs != null) {
            return this.oHs.bi(str, z);
        }
        return null;
    }

    public int edR() {
        if (this.oHs != null) {
            return this.oHs.edR();
        }
        return -1;
    }

    public TbPageContext edS() {
        if (this.oHs != null) {
            return this.oHs.edS();
        }
        return null;
    }

    public boolean isApplying() {
        if (this.oHs != null) {
            return this.oHs.isApplying();
        }
        return false;
    }

    public void setMaskBg(boolean z) {
        if (this.oHs != null) {
            this.oHs.setMaskBg(z);
        }
    }

    public void Af(boolean z) {
        if (this.oHs != null) {
            this.oHs.Af(z);
        }
    }

    public void Ag(boolean z) {
        if (this.oHs != null) {
            this.oHs.Ag(z);
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, ab abVar) {
        this.oHA = aVar;
        if (abVar != null && abVar.aIY != null) {
            abVar.aIY.isEnterLiveData = true;
            am(abVar);
            if (this.oHs != null) {
                this.oHs.a(this.oHv);
                this.oHs.m(abVar);
            }
            registerListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(ab abVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aIY;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            if (this.oHs == null || !(this.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
                this.oHs = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
                this.oHs.a(this.oGE, this.oHt, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            if (this.oHs == null || !(this.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c)) {
                this.oHs = new com.baidu.tieba.yuyinala.liveroom.wheat.d.c();
                this.oHs.a(this.oGE, this.oHt, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
            if (this.oHs == null || !(this.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.e)) {
                this.oHs = new com.baidu.tieba.yuyinala.liveroom.wheat.d.e();
                this.oHs.a(this.oGE, this.oHt, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 100) {
            if (this.oHs == null || !(this.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d)) {
                this.oHs = new com.baidu.tieba.yuyinala.liveroom.wheat.d.d();
                this.oHs.a(this.oGE, this.oHt, this.mRect);
            }
        } else if (this.oHs == null || !(this.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
            this.oHs = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
            this.oHs.a(this.oGE, this.oHt, this.mRect);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if ((r5.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
        if ((r5.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
        if ((r5.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.e) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0057, code lost:
        if ((r5.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean an(ab abVar) {
        boolean z = true;
        if (abVar.aJn) {
            abVar.aJn = false;
            return false;
        } else if (edT()) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aIY;
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.oHs != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                if (this.oHs != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
                if (this.oHs != null) {
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() != 100) {
                z = false;
            } else if (this.oHs != null) {
            }
            return z;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ao(ab abVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aIY;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            return this.oHs == null || !(this.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            return this.oHs == null || !(this.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
            return this.oHs == null || !(this.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.e);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 100) {
            return this.oHs == null || !(this.oHs instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d);
        } else {
            return false;
        }
    }

    private boolean edT() {
        if (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNt == null || com.baidu.live.ae.a.Qj().buX.aNt.aRi == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().a(com.baidu.live.ae.a.Qj().buX.aNt.aRi.CC(), true);
    }

    public void Ar() {
        if (this.oHs != null) {
            this.oHs.Ar();
        }
        onDestroy();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().onDestroy();
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oHv = bVar;
    }

    public void Ah(boolean z) {
        if (this.oHs != null) {
            this.oHs.Ah(z);
        }
    }

    public boolean edU() {
        if (this.oHs != null) {
            return this.oHs.edU();
        }
        return false;
    }

    private void registerListener() {
        onDestroy();
        MessageManager.getInstance().registerListener(this.bci);
        com.baidu.live.ao.a.Yj().a(this.oHJ);
        MessageManager.getInstance().registerListener(this.oHB);
        MessageManager.getInstance().registerListener(this.oHG);
        MessageManager.getInstance().registerListener(this.oHF);
        MessageManager.getInstance().registerListener(this.oHH);
        MessageManager.getInstance().registerListener(this.oHI);
        MessageManager.getInstance().registerListener(this.oHC);
        MessageManager.getInstance().registerListener(this.oHD);
        MessageManager.getInstance().registerListener(this.oHE);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bci);
        MessageManager.getInstance().unRegisterListener(this.oHB);
        MessageManager.getInstance().unRegisterListener(this.oHC);
        MessageManager.getInstance().unRegisterListener(this.oHF);
        MessageManager.getInstance().unRegisterListener(this.oHG);
        MessageManager.getInstance().unRegisterListener(this.oHH);
        MessageManager.getInstance().unRegisterListener(this.oHI);
        MessageManager.getInstance().unRegisterListener(this.oHD);
        MessageManager.getInstance().unRegisterListener(this.oHE);
        if (this.oHs != null) {
            this.oHs.onDestroy();
        }
    }

    public void cKX() {
        if (this.oHs != null) {
            this.oHs = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(final ab abVar) {
        final AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aIY;
        if (!edM().edU() && abVar != null && !abVar.aJn) {
            if (alaWheatInfoDataWrapper != null && alaWheatInfoDataWrapper.getRoomMode() == 0) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_common_mode_text)).show();
            } else if (alaWheatInfoDataWrapper != null && alaWheatInfoDataWrapper.getRoomMode() == 1) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_dating_mode_text)).show();
            } else if (alaWheatInfoDataWrapper != null && alaWheatInfoDataWrapper.getRoomMode() == 2) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_team_fight_mode_text)).show();
            } else if (alaWheatInfoDataWrapper != null && alaWheatInfoDataWrapper.getRoomMode() == 100) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_enter_single_wheat_mode_text)).show();
            }
        }
        if (an(abVar)) {
            if (System.currentTimeMillis() - this.oHw > 1500) {
                this.oHw = System.currentTimeMillis();
                View findViewById = (this.oGE == null || this.oGE.getPageActivity() == null) ? null : this.oGE.getPageActivity().findViewById(a.f.ala_liveroom_view);
                if (findViewById != null && !this.oHx) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().a((ViewGroup) findViewById, (com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c) null);
                }
                this.oHx = true;
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!q.this.edV()) {
                            q.this.am(abVar);
                            if (q.this.oHs != null) {
                                q.this.oHs.ar(abVar);
                            }
                            if (q.this.oHy != null) {
                                q.this.oHy.LT(alaWheatInfoDataWrapper != null ? alaWheatInfoDataWrapper.getRoomMode() : 0);
                            }
                            q.this.oHx = false;
                        }
                    }
                }, 1400L);
                return;
            }
            this.oHx = false;
            return;
        }
        am(abVar);
        if (this.oHs != null) {
            this.oHs.ar(abVar);
        }
        if (this.oHy != null) {
            this.oHy.LT(alaWheatInfoDataWrapper != null ? alaWheatInfoDataWrapper.getRoomMode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean edV() {
        return Build.VERSION.SDK_INT >= 17 ? this.oGE == null || this.oGE.getPageActivity() == null || this.oGE.getPageActivity().isFinishing() || this.oGE.getPageActivity().isDestroyed() : this.oGE == null || this.oGE.getPageActivity() == null || this.oGE.getPageActivity().isFinishing();
    }

    public void a(a aVar) {
        this.oHy = aVar;
    }

    public ab Yq() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edW() {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(this.oGE, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void onFail(int i, String str) {
            }
        }).ha(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym(), "1");
    }

    public void edX() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecT = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT();
        if (ecT != null) {
            if (Yk()) {
                if (ecT.ecP() && ecT.ecK() && !iH(Yp())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.5
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecT2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT();
                            if (ecT2.ecP() && ecT2.ecK() && !q.this.iH(q.this.Yp())) {
                                ecT2.Wk("dealExceptionHungUpWheat");
                                q.this.edY();
                            }
                        }
                    }, this.oHu);
                } else if (ecT.ecP() && !ecT.ecK() && !iH(Yp())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.6
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecT2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT();
                            if (ecT2.ecP() && !ecT2.ecK() && !q.this.iH(q.this.Yp())) {
                                ecT2.ecH();
                            }
                        }
                    }, this.oHu);
                } else if (!ecT.ecP() && ecT.ecK() && iH(Yp())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.7
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecT2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT();
                            if (!ecT2.ecP() && ecT2.ecK() && q.this.iH(q.this.Yp())) {
                                ecT2.Wk("dealExceptionHungUpWheat-timeout");
                                q.this.R(true, "dealExceptionHungUpWheat");
                            }
                        }
                    }, this.oHu);
                } else if (!ecT.ecP() && !ecT.ecK() && iH(Yp())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.8
                        @Override // java.lang.Runnable
                        public void run() {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecT2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT();
                            if (!ecT2.ecP() && !ecT2.ecK() && q.this.iH(q.this.Yp())) {
                                q.this.R(true, "dealExceptionHungUpWheat");
                                ecT2.ecH();
                            }
                        }
                    }, this.oHu);
                } else if (ecT.ecP() && ecT.ecK() && iH(Yp())) {
                    ecT.aAJ();
                }
            } else if (ecT.ecK() && !iH(Yp())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecT2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT();
                        if (ecT2 != null && ecT2.ecK() && !q.this.iH(q.this.Yp())) {
                            ecT2.Wk("dealExceptionHungUpWheat");
                            q.this.edY();
                        }
                    }
                }, this.oHu);
            } else if (!ecT.ecK() && iH(Yp())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecT2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT();
                        if (!ecT2.ecK() && q.this.iH(q.this.Yp())) {
                            ecT2.Wk("dealExceptionHungUpWheat-timeout");
                            q.this.R(true, "dealExceptionHungUpWheat");
                        }
                    }
                }, this.oHu);
            } else if (ecT.ecK() && iH(Yp()) && ecT.ecD()) {
                ecT.aAJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edY() {
        if (!Yk()) {
            f.edr().onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501071));
        }
    }

    public void R(boolean z, String str) {
        String str2;
        if (z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecT = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT();
            if (ecT != null) {
                String ecQ = ecT.ecQ();
                if (Yk()) {
                    str2 = ecQ + "#" + System.currentTimeMillis() + ":" + str + ",isOwnerJoinChat:" + ecT.ecP() + ",mIsSelfInRctRoom:" + ecT.ecK() + ",isOwner:true";
                } else {
                    str2 = ecQ + "#" + System.currentTimeMillis() + ":" + str + ",mIsSelfInRctRoom:" + ecT.ecK() + ",isOwner:false";
                }
                int length = str2.length();
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oEa) {
                    Log.i("AudioRoom", str2);
                }
                if (str2 != null && length > 1900) {
                    str2 = str2.substring(length - 1900, length);
                }
            } else {
                str2 = null;
            }
            new com.baidu.tieba.yuyinala.liveroom.wheat.model.f(null, new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.11
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
                public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_rtc_room_succ_anchor_7", false);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
                        if (Yq != null && Yq.aIU != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
                        }
                        jSONObject.put("error_code", 10004);
                        jSONObject.put("error_msg", "兜底下麦：" + com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().ecQ());
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "lost_chat").setContentExt(jSONObject));
                    q.this.edY();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
                public void onFail(int i, String str3) {
                }
            }).d(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym(), edM().Yp(), 1, str2);
            return;
        }
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.f(null, new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.13
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void onFail(int i, String str3) {
            }
        }).ha(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym(), edM().Yp());
    }

    public int getWheatHeight() {
        if (this.oHs != null) {
            return this.oHs.getWheatHeight();
        }
        return 0;
    }

    public boolean aq(ab abVar) {
        return (abVar == null || abVar.mLiveInfo == null || abVar.mLiveInfo.live_status != 2) ? false : true;
    }

    public boolean edZ() {
        ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
        return (Yq == null || Yq.aIY == null || Yq.aIY.getRoomMode() != 2) ? false : true;
    }

    public boolean ebK() {
        ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
        return (Yq == null || Yq.aIY == null || Yq.aIY.getRoomMode() != 100) ? false : true;
    }

    public com.baidu.tieba.yuyinala.liveroom.data.a eea() {
        return this.oHA;
    }
}
