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
    private static q oGR;
    private Rect mRect;
    private com.baidu.tieba.yuyinala.liveroom.wheat.d.a oGS;
    private AlaLiveRoomBlurPageLayout oGT;
    private com.baidu.tieba.yuyinala.player.b oGV;
    private long oGW;
    private boolean oGX;
    private a oGY;
    private p oGZ;
    private TbPageContext oGe;
    private com.baidu.tieba.yuyinala.liveroom.data.a oHa;
    private long oGU = 10000;
    private CustomMessageListener bci = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                ab abVar = (ab) customResponsedMessage.getData();
                if (q.this.aq(abVar)) {
                    if (q.this.oGS != null) {
                        ViewGroup edG = q.this.oGS.edG();
                        if (edG != null && edG.getParent() != null) {
                            ((ViewGroup) edG.getParent()).removeView(edG);
                        }
                        q.this.oGS.onDestroy();
                        q.this.oGS = null;
                        return;
                    }
                    return;
                }
                if (q.this.ao(abVar)) {
                    q.this.ap(abVar);
                } else if (q.this.oGS != null) {
                    q.this.oGS.ar(abVar);
                }
                q.this.edP();
            }
        }
    };
    private CustomMessageListener oHb = new CustomMessageListener(2501009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501009) {
                if (customResponsedMessage.getData() == null) {
                    if (q.this.oGS != null) {
                        q.this.oGS.loadData();
                    }
                } else if ((customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).contains(Headers.REFRESH) && q.this.oGS != null) {
                    q.this.oGS.eeD();
                }
            }
        }
    };
    private CustomMessageListener oHc = new CustomMessageListener(2501022) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501022 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = (String) hashMap.get("user_uk");
                String str2 = (String) hashMap.get("webp_url");
                String str3 = (String) hashMap.get("result_url");
                if (q.this.oGS != null) {
                    q.this.oGS.aT(str, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener oHd = new CustomMessageListener(2501076) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501076 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaWheatMoreFunctionData)) {
                new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h(q.this.oGe, (AlaWheatMoreFunctionData) customResponsedMessage.getData()).show();
            }
        }
    };
    private CustomMessageListener oHe = new CustomMessageListener(2501084) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501084 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                if (q.this.oGZ == null) {
                    q.this.oGZ = new p();
                }
                q.this.oGZ.a(q.this.oGe, (com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener oHf = new CustomMessageListener(2501024) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501024 && customResponsedMessage.getData() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Wa(str).yp();
                }
            }
        }
    };
    private CustomMessageListener oHg = new CustomMessageListener(2501026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.19
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
                        if (optBoolean || (!optBoolean && !q.this.VT(optString))) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (TextUtils.equals(optString2, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ym())) {
                                        if (optInt == 1) {
                                            if (q.this.oGS != null) {
                                                q.this.oGS.WA(optString);
                                            }
                                        } else if (q.this.oGS != null) {
                                            q.this.oGS.WB(optString);
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
    private CustomMessageListener oHh = new CustomMessageListener(2501023) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501023 && customResponsedMessage.getData() != null && q.this.oGS != null) {
                q.this.oGS.loadData();
            }
        }
    };
    private CustomMessageListener oHi = new CustomMessageListener(2501077) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage == null || customResponsedMessage.getCmd() == 2501077) && q.this.oGS != null && (q.this.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.e)) {
                ((com.baidu.tieba.yuyinala.liveroom.wheat.d.e) q.this.oGS).setTeamFightProgressData((String) customResponsedMessage.getData());
            }
        }
    };
    com.baidu.live.ao.b oHj = new com.baidu.live.ao.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.3
        @Override // com.baidu.live.ao.b
        public boolean isApplying() {
            if (q.this.oGS != null) {
                return q.this.oGS.isApplying();
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public boolean iH(String str) {
            if (q.this.oGS != null) {
                return q.this.oGS.iH(str);
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public boolean Yk() {
            if (q.this.oGS != null) {
                return q.this.oGS.Yk();
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public boolean iI(String str) {
            if (q.this.oGS != null) {
                return q.this.oGS.iI(str);
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public boolean iJ(String str) {
            if (q.this.oGS != null) {
                return q.this.oGS.iJ(str);
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public AlaWheatInfoData iK(String str) {
            if (q.this.oGS != null) {
                return q.this.oGS.Wz(str);
            }
            return null;
        }

        @Override // com.baidu.live.ao.b
        public AlaWheatInfoData Yl() {
            if (q.this.oGS != null) {
                return q.this.oGS.Yl();
            }
            return null;
        }

        @Override // com.baidu.live.ao.b
        public void G(String str, boolean z) {
            if (q.this.oGS != null) {
                q.this.oGS.G(str, z);
            }
        }

        @Override // com.baidu.live.ao.b
        public boolean iL(String str) {
            if (q.this.oGS != null) {
                return q.this.oGS.iL(str);
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public List<AlaWheatInfoData> Ym() {
            if (q.this.oGS != null) {
                return q.this.oGS.Ym();
            }
            return null;
        }

        @Override // com.baidu.live.ao.b
        public List<AlaWheatInfoData> Yn() {
            if (q.this.oGS != null) {
                return q.this.oGS.Yn();
            }
            return null;
        }

        @Override // com.baidu.live.ao.b
        public String Yo() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yo();
        }

        @Override // com.baidu.live.ao.b
        public String Yp() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Yp();
        }

        @Override // com.baidu.live.ao.b
        public String getCustomRoomId() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().getCustomRoomId();
        }

        @Override // com.baidu.live.ao.b
        public ab Yq() {
            return q.this.Yq();
        }

        @Override // com.baidu.live.ao.b
        public String Yr() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yr();
        }

        @Override // com.baidu.live.ao.b
        public void muteOrUnmuteAudio(boolean z) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL() != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL().muteOrUnmuteAudio(z);
            }
        }

        @Override // com.baidu.live.ao.b
        public void Ys() {
            q.this.R(false, "");
        }

        @Override // com.baidu.live.ao.b
        public void Yt() {
            q.this.edO();
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void LS(int i);
    }

    public static q edE() {
        if (oGR == null) {
            synchronized (q.class) {
                if (oGR == null) {
                    oGR = new q();
                }
            }
        }
        return oGR;
    }

    private q() {
    }

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mRect = rect;
        this.oGe = tbPageContext;
        this.oGT = alaLiveRoomBlurPageLayout;
    }

    public void edF() {
        if (this.oGS != null) {
            this.oGS.loadData();
        }
    }

    public ViewGroup edG() {
        if (this.oGS != null) {
            return this.oGS.edG();
        }
        return null;
    }

    public List<AlaWheatInfoData> Yn() {
        if (this.oGS != null) {
            return this.oGS.Yn();
        }
        return null;
    }

    public List<AlaWheatInfoData> Ym() {
        if (this.oGS != null) {
            return this.oGS.Ym();
        }
        return null;
    }

    public List<AlaWheatInfoData> edH() {
        if (this.oGS != null) {
            return this.oGS.edH();
        }
        return null;
    }

    public boolean edI() {
        if (this.oGS != null) {
            return this.oGS.edI();
        }
        return false;
    }

    public boolean Yk() {
        if (this.oGS != null) {
            return this.oGS.Yk();
        }
        return false;
    }

    public boolean iI(String str) {
        if (this.oGS != null) {
            return this.oGS.iI(str);
        }
        return false;
    }

    public boolean VT(String str) {
        if (this.oGS != null) {
            return this.oGS.VT(str);
        }
        return false;
    }

    public String Yp() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Yp();
    }

    public boolean iH(String str) {
        if (this.oGS != null) {
            return this.oGS.iH(str);
        }
        return false;
    }

    public boolean iJ(String str) {
        if (this.oGS == null || str == null) {
            return false;
        }
        return this.oGS.iJ(str);
    }

    public boolean Wr(String str) {
        if (this.oGS == null || str == null) {
            return false;
        }
        return this.oGS.Wr(str);
    }

    public AlaWheatInfoData iK(String str) {
        if (this.oGS != null) {
            return this.oGS.iK(str);
        }
        return null;
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        if (this.oGS != null) {
            return this.oGS.bi(str, z);
        }
        return null;
    }

    public int edJ() {
        if (this.oGS != null) {
            return this.oGS.edJ();
        }
        return -1;
    }

    public TbPageContext edK() {
        if (this.oGS != null) {
            return this.oGS.edK();
        }
        return null;
    }

    public boolean isApplying() {
        if (this.oGS != null) {
            return this.oGS.isApplying();
        }
        return false;
    }

    public void setMaskBg(boolean z) {
        if (this.oGS != null) {
            this.oGS.setMaskBg(z);
        }
    }

    public void Af(boolean z) {
        if (this.oGS != null) {
            this.oGS.Af(z);
        }
    }

    public void Ag(boolean z) {
        if (this.oGS != null) {
            this.oGS.Ag(z);
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, ab abVar) {
        this.oHa = aVar;
        if (abVar != null && abVar.aIY != null) {
            abVar.aIY.isEnterLiveData = true;
            am(abVar);
            if (this.oGS != null) {
                this.oGS.a(this.oGV);
                this.oGS.m(abVar);
            }
            registerListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(ab abVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aIY;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            if (this.oGS == null || !(this.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
                this.oGS = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
                this.oGS.a(this.oGe, this.oGT, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            if (this.oGS == null || !(this.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c)) {
                this.oGS = new com.baidu.tieba.yuyinala.liveroom.wheat.d.c();
                this.oGS.a(this.oGe, this.oGT, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
            if (this.oGS == null || !(this.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.e)) {
                this.oGS = new com.baidu.tieba.yuyinala.liveroom.wheat.d.e();
                this.oGS.a(this.oGe, this.oGT, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 100) {
            if (this.oGS == null || !(this.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d)) {
                this.oGS = new com.baidu.tieba.yuyinala.liveroom.wheat.d.d();
                this.oGS.a(this.oGe, this.oGT, this.mRect);
            }
        } else if (this.oGS == null || !(this.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
            this.oGS = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
            this.oGS.a(this.oGe, this.oGT, this.mRect);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if ((r5.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
        if ((r5.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
        if ((r5.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.e) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0057, code lost:
        if ((r5.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean an(ab abVar) {
        boolean z = true;
        if (abVar.aJn) {
            abVar.aJn = false;
            return false;
        } else if (edL()) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aIY;
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.oGS != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                if (this.oGS != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
                if (this.oGS != null) {
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() != 100) {
                z = false;
            } else if (this.oGS != null) {
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
            return this.oGS == null || !(this.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            return this.oGS == null || !(this.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
            return this.oGS == null || !(this.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.e);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 100) {
            return this.oGS == null || !(this.oGS instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d);
        } else {
            return false;
        }
    }

    private boolean edL() {
        if (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNt == null || com.baidu.live.ae.a.Qj().buX.aNt.aRi == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeg().a(com.baidu.live.ae.a.Qj().buX.aNt.aRi.CC(), true);
    }

    public void Ar() {
        if (this.oGS != null) {
            this.oGS.Ar();
        }
        onDestroy();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().onDestroy();
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oGV = bVar;
    }

    public void Ah(boolean z) {
        if (this.oGS != null) {
            this.oGS.Ah(z);
        }
    }

    public boolean edM() {
        if (this.oGS != null) {
            return this.oGS.edM();
        }
        return false;
    }

    private void registerListener() {
        onDestroy();
        MessageManager.getInstance().registerListener(this.bci);
        com.baidu.live.ao.a.Yj().a(this.oHj);
        MessageManager.getInstance().registerListener(this.oHb);
        MessageManager.getInstance().registerListener(this.oHg);
        MessageManager.getInstance().registerListener(this.oHf);
        MessageManager.getInstance().registerListener(this.oHh);
        MessageManager.getInstance().registerListener(this.oHi);
        MessageManager.getInstance().registerListener(this.oHc);
        MessageManager.getInstance().registerListener(this.oHd);
        MessageManager.getInstance().registerListener(this.oHe);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bci);
        MessageManager.getInstance().unRegisterListener(this.oHb);
        MessageManager.getInstance().unRegisterListener(this.oHc);
        MessageManager.getInstance().unRegisterListener(this.oHf);
        MessageManager.getInstance().unRegisterListener(this.oHg);
        MessageManager.getInstance().unRegisterListener(this.oHh);
        MessageManager.getInstance().unRegisterListener(this.oHi);
        MessageManager.getInstance().unRegisterListener(this.oHd);
        MessageManager.getInstance().unRegisterListener(this.oHe);
        if (this.oGS != null) {
            this.oGS.onDestroy();
        }
    }

    public void cKQ() {
        if (this.oGS != null) {
            this.oGS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(final ab abVar) {
        final AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aIY;
        if (!edE().edM() && abVar != null && !abVar.aJn) {
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
            if (System.currentTimeMillis() - this.oGW > 1500) {
                this.oGW = System.currentTimeMillis();
                View findViewById = (this.oGe == null || this.oGe.getPageActivity() == null) ? null : this.oGe.getPageActivity().findViewById(a.f.ala_liveroom_view);
                if (findViewById != null && !this.oGX) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeg().a((ViewGroup) findViewById, (com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c) null);
                }
                this.oGX = true;
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!q.this.edN()) {
                            q.this.am(abVar);
                            if (q.this.oGS != null) {
                                q.this.oGS.ar(abVar);
                            }
                            if (q.this.oGY != null) {
                                q.this.oGY.LS(alaWheatInfoDataWrapper != null ? alaWheatInfoDataWrapper.getRoomMode() : 0);
                            }
                            q.this.oGX = false;
                        }
                    }
                }, 1400L);
                return;
            }
            this.oGX = false;
            return;
        }
        am(abVar);
        if (this.oGS != null) {
            this.oGS.ar(abVar);
        }
        if (this.oGY != null) {
            this.oGY.LS(alaWheatInfoDataWrapper != null ? alaWheatInfoDataWrapper.getRoomMode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean edN() {
        return Build.VERSION.SDK_INT >= 17 ? this.oGe == null || this.oGe.getPageActivity() == null || this.oGe.getPageActivity().isFinishing() || this.oGe.getPageActivity().isDestroyed() : this.oGe == null || this.oGe.getPageActivity() == null || this.oGe.getPageActivity().isFinishing();
    }

    public void a(a aVar) {
        this.oGY = aVar;
    }

    public ab Yq() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edO() {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(this.oGe, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void onFail(int i, String str) {
            }
        }).gY(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ym(), "1");
    }

    public void edP() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecL = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL();
        if (ecL != null) {
            if (Yk()) {
                if (ecL.ecH() && ecL.ecC() && !iH(Yp())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.5
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecL2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL();
                            if (ecL2.ecH() && ecL2.ecC() && !q.this.iH(q.this.Yp())) {
                                ecL2.VY("dealExceptionHungUpWheat");
                                q.this.edQ();
                            }
                        }
                    }, this.oGU);
                } else if (ecL.ecH() && !ecL.ecC() && !iH(Yp())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.6
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecL2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL();
                            if (ecL2.ecH() && !ecL2.ecC() && !q.this.iH(q.this.Yp())) {
                                ecL2.ecz();
                            }
                        }
                    }, this.oGU);
                } else if (!ecL.ecH() && ecL.ecC() && iH(Yp())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.7
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecL2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL();
                            if (!ecL2.ecH() && ecL2.ecC() && q.this.iH(q.this.Yp())) {
                                ecL2.VY("dealExceptionHungUpWheat-timeout");
                                q.this.R(true, "dealExceptionHungUpWheat");
                            }
                        }
                    }, this.oGU);
                } else if (!ecL.ecH() && !ecL.ecC() && iH(Yp())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.8
                        @Override // java.lang.Runnable
                        public void run() {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecL2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL();
                            if (!ecL2.ecH() && !ecL2.ecC() && q.this.iH(q.this.Yp())) {
                                q.this.R(true, "dealExceptionHungUpWheat");
                                ecL2.ecz();
                            }
                        }
                    }, this.oGU);
                } else if (ecL.ecH() && ecL.ecC() && iH(Yp())) {
                    ecL.aAJ();
                }
            } else if (ecL.ecC() && !iH(Yp())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecL2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL();
                        if (ecL2 != null && ecL2.ecC() && !q.this.iH(q.this.Yp())) {
                            ecL2.VY("dealExceptionHungUpWheat");
                            q.this.edQ();
                        }
                    }
                }, this.oGU);
            } else if (!ecL.ecC() && iH(Yp())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecL2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL();
                        if (!ecL2.ecC() && q.this.iH(q.this.Yp())) {
                            ecL2.VY("dealExceptionHungUpWheat-timeout");
                            q.this.R(true, "dealExceptionHungUpWheat");
                        }
                    }
                }, this.oGU);
            } else if (ecL.ecC() && iH(Yp()) && ecL.ecv()) {
                ecL.aAJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edQ() {
        if (!Yk()) {
            f.edj().onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501071));
        }
    }

    public void R(boolean z, String str) {
        String str2;
        if (z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecL = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL();
            if (ecL != null) {
                String ecI = ecL.ecI();
                if (Yk()) {
                    str2 = ecI + "#" + System.currentTimeMillis() + ":" + str + ",isOwnerJoinChat:" + ecL.ecH() + ",mIsSelfInRctRoom:" + ecL.ecC() + ",isOwner:true";
                } else {
                    str2 = ecI + "#" + System.currentTimeMillis() + ":" + str + ",mIsSelfInRctRoom:" + ecL.ecC() + ",isOwner:false";
                }
                int length = str2.length();
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oDA) {
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
                        ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq();
                        if (Yq != null && Yq.aIU != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
                        }
                        jSONObject.put("error_code", 10004);
                        jSONObject.put("error_msg", "兜底下麦：" + com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL().ecI());
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "lost_chat").setContentExt(jSONObject));
                    q.this.edQ();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
                public void onFail(int i, String str3) {
                }
            }).d(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ym(), edE().Yp(), 1, str2);
            return;
        }
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.f(null, new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.13
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void onFail(int i, String str3) {
            }
        }).gY(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ym(), edE().Yp());
    }

    public int getWheatHeight() {
        if (this.oGS != null) {
            return this.oGS.getWheatHeight();
        }
        return 0;
    }

    public boolean aq(ab abVar) {
        return (abVar == null || abVar.mLiveInfo == null || abVar.mLiveInfo.live_status != 2) ? false : true;
    }

    public boolean edR() {
        ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq();
        return (Yq == null || Yq.aIY == null || Yq.aIY.getRoomMode() != 2) ? false : true;
    }

    public boolean ebC() {
        ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq();
        return (Yq == null || Yq.aIY == null || Yq.aIY.getRoomMode() != 100) ? false : true;
    }

    public com.baidu.tieba.yuyinala.liveroom.data.a edS() {
        return this.oHa;
    }
}
