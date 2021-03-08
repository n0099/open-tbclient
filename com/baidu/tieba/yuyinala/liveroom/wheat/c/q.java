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
/* loaded from: classes10.dex */
public class q {
    private static q oJw;
    private Rect mRect;
    private TbPageContext oIJ;
    private com.baidu.tieba.yuyinala.player.b oJA;
    private long oJB;
    private boolean oJC;
    private a oJD;
    private p oJE;
    private com.baidu.tieba.yuyinala.liveroom.data.a oJF;
    private com.baidu.tieba.yuyinala.liveroom.wheat.d.a oJx;
    private AlaLiveRoomBlurPageLayout oJy;
    private long oJz = 10000;
    private CustomMessageListener bdI = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                ab abVar = (ab) customResponsedMessage.getData();
                if (q.this.aq(abVar)) {
                    if (q.this.oJx != null) {
                        ViewGroup edW = q.this.oJx.edW();
                        if (edW != null && edW.getParent() != null) {
                            ((ViewGroup) edW.getParent()).removeView(edW);
                        }
                        q.this.oJx.onDestroy();
                        q.this.oJx = null;
                        return;
                    }
                    return;
                }
                if (q.this.ao(abVar)) {
                    q.this.ap(abVar);
                } else if (q.this.oJx != null) {
                    q.this.oJx.ar(abVar);
                }
                q.this.eef();
            }
        }
    };
    private CustomMessageListener oJG = new CustomMessageListener(2501009) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501009) {
                if (customResponsedMessage.getData() == null) {
                    if (q.this.oJx != null) {
                        q.this.oJx.loadData();
                    }
                } else if ((customResponsedMessage.getData() instanceof String) && ((String) customResponsedMessage.getData()).contains(Headers.REFRESH) && q.this.oJx != null) {
                    q.this.oJx.eeT();
                }
            }
        }
    };
    private CustomMessageListener oJH = new CustomMessageListener(2501022) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501022 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = (String) hashMap.get("user_uk");
                String str2 = (String) hashMap.get("webp_url");
                String str3 = (String) hashMap.get("result_url");
                if (q.this.oJx != null) {
                    q.this.oJx.aT(str, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener oJI = new CustomMessageListener(2501076) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501076 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaWheatMoreFunctionData)) {
                new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h(q.this.oIJ, (AlaWheatMoreFunctionData) customResponsedMessage.getData()).show();
            }
        }
    };
    private CustomMessageListener oJJ = new CustomMessageListener(2501084) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501084 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                if (q.this.oJE == null) {
                    q.this.oJE = new p();
                }
                q.this.oJE.a(q.this.oIJ, (com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener oJK = new CustomMessageListener(2501024) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501024 && customResponsedMessage.getData() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Wt(str).ys();
                }
            }
        }
    };
    private CustomMessageListener oJL = new CustomMessageListener(2501026) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.19
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
                        if (optBoolean || (!optBoolean && !q.this.Wm(optString))) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (TextUtils.equals(optString2, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp())) {
                                        if (optInt == 1) {
                                            if (q.this.oJx != null) {
                                                q.this.oJx.WT(optString);
                                            }
                                        } else if (q.this.oJx != null) {
                                            q.this.oJx.WU(optString);
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
    private CustomMessageListener oJM = new CustomMessageListener(2501023) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501023 && customResponsedMessage.getData() != null && q.this.oJx != null) {
                q.this.oJx.loadData();
            }
        }
    };
    private CustomMessageListener oJN = new CustomMessageListener(2501077) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage == null || customResponsedMessage.getCmd() == 2501077) && q.this.oJx != null && (q.this.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.e)) {
                ((com.baidu.tieba.yuyinala.liveroom.wheat.d.e) q.this.oJx).setTeamFightProgressData((String) customResponsedMessage.getData());
            }
        }
    };
    com.baidu.live.ao.b oJO = new com.baidu.live.ao.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.3
        @Override // com.baidu.live.ao.b
        public boolean isApplying() {
            if (q.this.oJx != null) {
                return q.this.oJx.isApplying();
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public boolean iN(String str) {
            if (q.this.oJx != null) {
                return q.this.oJx.iN(str);
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public boolean Yn() {
            if (q.this.oJx != null) {
                return q.this.oJx.Yn();
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public boolean iO(String str) {
            if (q.this.oJx != null) {
                return q.this.oJx.iO(str);
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public boolean iP(String str) {
            if (q.this.oJx != null) {
                return q.this.oJx.iP(str);
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public AlaWheatInfoData iQ(String str) {
            if (q.this.oJx != null) {
                return q.this.oJx.WS(str);
            }
            return null;
        }

        @Override // com.baidu.live.ao.b
        public AlaWheatInfoData Yo() {
            if (q.this.oJx != null) {
                return q.this.oJx.Yo();
            }
            return null;
        }

        @Override // com.baidu.live.ao.b
        public void G(String str, boolean z) {
            if (q.this.oJx != null) {
                q.this.oJx.G(str, z);
            }
        }

        @Override // com.baidu.live.ao.b
        public boolean iR(String str) {
            if (q.this.oJx != null) {
                return q.this.oJx.iR(str);
            }
            return false;
        }

        @Override // com.baidu.live.ao.b
        public List<AlaWheatInfoData> Yp() {
            if (q.this.oJx != null) {
                return q.this.oJx.Yp();
            }
            return null;
        }

        @Override // com.baidu.live.ao.b
        public List<AlaWheatInfoData> Yq() {
            if (q.this.oJx != null) {
                return q.this.oJx.Yq();
            }
            return null;
        }

        @Override // com.baidu.live.ao.b
        public String Yr() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yr();
        }

        @Override // com.baidu.live.ao.b
        public String Ys() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Ys();
        }

        @Override // com.baidu.live.ao.b
        public String getCustomRoomId() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().getCustomRoomId();
        }

        @Override // com.baidu.live.ao.b
        public ab Yt() {
            return q.this.Yt();
        }

        @Override // com.baidu.live.ao.b
        public String Yu() {
            return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yu();
        }

        @Override // com.baidu.live.ao.b
        public void muteOrUnmuteAudio(boolean z) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb() != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().muteOrUnmuteAudio(z);
            }
        }

        @Override // com.baidu.live.ao.b
        public void Yv() {
            q.this.R(false, "");
        }

        @Override // com.baidu.live.ao.b
        public void Yw() {
            q.this.eee();
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void LX(int i);
    }

    public static q edU() {
        if (oJw == null) {
            synchronized (q.class) {
                if (oJw == null) {
                    oJw = new q();
                }
            }
        }
        return oJw;
    }

    private q() {
    }

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mRect = rect;
        this.oIJ = tbPageContext;
        this.oJy = alaLiveRoomBlurPageLayout;
    }

    public void edV() {
        if (this.oJx != null) {
            this.oJx.loadData();
        }
    }

    public ViewGroup edW() {
        if (this.oJx != null) {
            return this.oJx.edW();
        }
        return null;
    }

    public List<AlaWheatInfoData> Yq() {
        if (this.oJx != null) {
            return this.oJx.Yq();
        }
        return null;
    }

    public List<AlaWheatInfoData> Yp() {
        if (this.oJx != null) {
            return this.oJx.Yp();
        }
        return null;
    }

    public List<AlaWheatInfoData> edX() {
        if (this.oJx != null) {
            return this.oJx.edX();
        }
        return null;
    }

    public boolean edY() {
        if (this.oJx != null) {
            return this.oJx.edY();
        }
        return false;
    }

    public boolean Yn() {
        if (this.oJx != null) {
            return this.oJx.Yn();
        }
        return false;
    }

    public boolean iO(String str) {
        if (this.oJx != null) {
            return this.oJx.iO(str);
        }
        return false;
    }

    public boolean Wm(String str) {
        if (this.oJx != null) {
            return this.oJx.Wm(str);
        }
        return false;
    }

    public String Ys() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Ys();
    }

    public boolean iN(String str) {
        if (this.oJx != null) {
            return this.oJx.iN(str);
        }
        return false;
    }

    public boolean iP(String str) {
        if (this.oJx == null || str == null) {
            return false;
        }
        return this.oJx.iP(str);
    }

    public boolean WK(String str) {
        if (this.oJx == null || str == null) {
            return false;
        }
        return this.oJx.WK(str);
    }

    public AlaWheatInfoData iQ(String str) {
        if (this.oJx != null) {
            return this.oJx.iQ(str);
        }
        return null;
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        if (this.oJx != null) {
            return this.oJx.bi(str, z);
        }
        return null;
    }

    public int edZ() {
        if (this.oJx != null) {
            return this.oJx.edZ();
        }
        return -1;
    }

    public TbPageContext eea() {
        if (this.oJx != null) {
            return this.oJx.eea();
        }
        return null;
    }

    public boolean isApplying() {
        if (this.oJx != null) {
            return this.oJx.isApplying();
        }
        return false;
    }

    public void setMaskBg(boolean z) {
        if (this.oJx != null) {
            this.oJx.setMaskBg(z);
        }
    }

    public void Ae(boolean z) {
        if (this.oJx != null) {
            this.oJx.Ae(z);
        }
    }

    public void Af(boolean z) {
        if (this.oJx != null) {
            this.oJx.Af(z);
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, ab abVar) {
        this.oJF = aVar;
        if (abVar != null && abVar.aKy != null) {
            abVar.aKy.isEnterLiveData = true;
            am(abVar);
            if (this.oJx != null) {
                this.oJx.a(this.oJA);
                this.oJx.m(abVar);
            }
            registerListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(ab abVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aKy;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            if (this.oJx == null || !(this.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
                this.oJx = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
                this.oJx.a(this.oIJ, this.oJy, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            if (this.oJx == null || !(this.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c)) {
                this.oJx = new com.baidu.tieba.yuyinala.liveroom.wheat.d.c();
                this.oJx.a(this.oIJ, this.oJy, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
            if (this.oJx == null || !(this.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.e)) {
                this.oJx = new com.baidu.tieba.yuyinala.liveroom.wheat.d.e();
                this.oJx.a(this.oIJ, this.oJy, this.mRect);
            }
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 100) {
            if (this.oJx == null || !(this.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d)) {
                this.oJx = new com.baidu.tieba.yuyinala.liveroom.wheat.d.d();
                this.oJx.a(this.oIJ, this.oJy, this.mRect);
            }
        } else if (this.oJx == null || !(this.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b)) {
            this.oJx = new com.baidu.tieba.yuyinala.liveroom.wheat.d.b();
            this.oJx.a(this.oIJ, this.oJy, this.mRect);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if ((r5.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
        if ((r5.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
        if ((r5.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.e) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0057, code lost:
        if ((r5.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean an(ab abVar) {
        boolean z = true;
        if (abVar.aKN) {
            abVar.aKN = false;
            return false;
        } else if (eeb()) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aKy;
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.oJx != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                if (this.oJx != null) {
                }
                z = false;
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
                if (this.oJx != null) {
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() != 100) {
                z = false;
            } else if (this.oJx != null) {
            }
            return z;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ao(ab abVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aKy;
        if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
            return this.oJx == null || !(this.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.b);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
            return this.oJx == null || !(this.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.c);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
            return this.oJx == null || !(this.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.e);
        } else if (alaWheatInfoDataWrapper.getRoomMode() == 100) {
            return this.oJx == null || !(this.oJx instanceof com.baidu.tieba.yuyinala.liveroom.wheat.d.d);
        } else {
            return false;
        }
    }

    private boolean eeb() {
        if (com.baidu.live.ae.a.Qm().bwx == null || com.baidu.live.ae.a.Qm().bwx.aOT == null || com.baidu.live.ae.a.Qm().bwx.aOT.aSI == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eew().a(com.baidu.live.ae.a.Qm().bwx.aOT.aSI.CF(), true);
    }

    public void Au() {
        if (this.oJx != null) {
            this.oJx.Au();
        }
        onDestroy();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().onDestroy();
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oJA = bVar;
    }

    public void Ag(boolean z) {
        if (this.oJx != null) {
            this.oJx.Ag(z);
        }
    }

    public boolean eec() {
        if (this.oJx != null) {
            return this.oJx.eec();
        }
        return false;
    }

    private void registerListener() {
        onDestroy();
        MessageManager.getInstance().registerListener(this.bdI);
        com.baidu.live.ao.a.Ym().a(this.oJO);
        MessageManager.getInstance().registerListener(this.oJG);
        MessageManager.getInstance().registerListener(this.oJL);
        MessageManager.getInstance().registerListener(this.oJK);
        MessageManager.getInstance().registerListener(this.oJM);
        MessageManager.getInstance().registerListener(this.oJN);
        MessageManager.getInstance().registerListener(this.oJH);
        MessageManager.getInstance().registerListener(this.oJI);
        MessageManager.getInstance().registerListener(this.oJJ);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bdI);
        MessageManager.getInstance().unRegisterListener(this.oJG);
        MessageManager.getInstance().unRegisterListener(this.oJH);
        MessageManager.getInstance().unRegisterListener(this.oJK);
        MessageManager.getInstance().unRegisterListener(this.oJL);
        MessageManager.getInstance().unRegisterListener(this.oJM);
        MessageManager.getInstance().unRegisterListener(this.oJN);
        MessageManager.getInstance().unRegisterListener(this.oJI);
        MessageManager.getInstance().unRegisterListener(this.oJJ);
        if (this.oJx != null) {
            this.oJx.onDestroy();
        }
    }

    public void cLd() {
        if (this.oJx != null) {
            this.oJx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(final ab abVar) {
        final AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aKy;
        if (!edU().eec() && abVar != null && !abVar.aKN) {
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
            if (System.currentTimeMillis() - this.oJB > 1500) {
                this.oJB = System.currentTimeMillis();
                View findViewById = (this.oIJ == null || this.oIJ.getPageActivity() == null) ? null : this.oIJ.getPageActivity().findViewById(a.f.ala_liveroom_view);
                if (findViewById != null && !this.oJC) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eew().a((ViewGroup) findViewById, (com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c) null);
                }
                this.oJC = true;
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!q.this.eed()) {
                            q.this.am(abVar);
                            if (q.this.oJx != null) {
                                q.this.oJx.ar(abVar);
                            }
                            if (q.this.oJD != null) {
                                q.this.oJD.LX(alaWheatInfoDataWrapper != null ? alaWheatInfoDataWrapper.getRoomMode() : 0);
                            }
                            q.this.oJC = false;
                        }
                    }
                }, 1400L);
                return;
            }
            this.oJC = false;
            return;
        }
        am(abVar);
        if (this.oJx != null) {
            this.oJx.ar(abVar);
        }
        if (this.oJD != null) {
            this.oJD.LX(alaWheatInfoDataWrapper != null ? alaWheatInfoDataWrapper.getRoomMode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eed() {
        return Build.VERSION.SDK_INT >= 17 ? this.oIJ == null || this.oIJ.getPageActivity() == null || this.oIJ.getPageActivity().isFinishing() || this.oIJ.getPageActivity().isDestroyed() : this.oIJ == null || this.oIJ.getPageActivity() == null || this.oIJ.getPageActivity().isFinishing();
    }

    public void a(a aVar) {
        this.oJD = aVar;
    }

    public ab Yt() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eee() {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(this.oIJ, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
            public void onFail(int i, String str) {
            }
        }).ha(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp(), "1");
    }

    public void eef() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.b edb = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb();
        if (edb != null) {
            if (Yn()) {
                if (edb.ecX() && edb.ecS() && !iN(Ys())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.5
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b edb2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb();
                            if (edb2.ecX() && edb2.ecS() && !q.this.iN(q.this.Ys())) {
                                edb2.Wr("dealExceptionHungUpWheat");
                                q.this.eeg();
                            }
                        }
                    }, this.oJz);
                } else if (edb.ecX() && !edb.ecS() && !iN(Ys())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.6
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b edb2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb();
                            if (edb2.ecX() && !edb2.ecS() && !q.this.iN(q.this.Ys())) {
                                edb2.ecP();
                            }
                        }
                    }, this.oJz);
                } else if (!edb.ecX() && edb.ecS() && iN(Ys())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.7
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b edb2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb();
                            if (!edb2.ecX() && edb2.ecS() && q.this.iN(q.this.Ys())) {
                                edb2.Wr("dealExceptionHungUpWheat-timeout");
                                q.this.R(true, "dealExceptionHungUpWheat");
                            }
                        }
                    }, this.oJz);
                } else if (!edb.ecX() && !edb.ecS() && iN(Ys())) {
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.8
                        @Override // java.lang.Runnable
                        public void run() {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.b edb2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb();
                            if (!edb2.ecX() && !edb2.ecS() && q.this.iN(q.this.Ys())) {
                                q.this.R(true, "dealExceptionHungUpWheat");
                                edb2.ecP();
                            }
                        }
                    }, this.oJz);
                } else if (edb.ecX() && edb.ecS() && iN(Ys())) {
                    edb.aAM();
                }
            } else if (edb.ecS() && !iN(Ys())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b edb2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb();
                        if (edb2 != null && edb2.ecS() && !q.this.iN(q.this.Ys())) {
                            edb2.Wr("dealExceptionHungUpWheat");
                            q.this.eeg();
                        }
                    }
                }, this.oJz);
            } else if (!edb.ecS() && iN(Ys())) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b edb2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb();
                        if (!edb2.ecS() && q.this.iN(q.this.Ys())) {
                            edb2.Wr("dealExceptionHungUpWheat-timeout");
                            q.this.R(true, "dealExceptionHungUpWheat");
                        }
                    }
                }, this.oJz);
            } else if (edb.ecS() && iN(Ys()) && edb.ecL()) {
                edb.aAM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeg() {
        if (!Yn()) {
            f.edz().onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501071));
        }
    }

    public void R(boolean z, String str) {
        String str2;
        if (z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.b edb = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb();
            if (edb != null) {
                String ecY = edb.ecY();
                if (Yn()) {
                    str2 = ecY + "#" + System.currentTimeMillis() + ":" + str + ",isOwnerJoinChat:" + edb.ecX() + ",mIsSelfInRctRoom:" + edb.ecS() + ",isOwner:true";
                } else {
                    str2 = ecY + "#" + System.currentTimeMillis() + ":" + str + ",mIsSelfInRctRoom:" + edb.ecS() + ",isOwner:false";
                }
                int length = str2.length();
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oGf) {
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
                        ab Yt = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
                        if (Yt != null && Yt.aKu != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yt.aKu.live_id);
                        }
                        jSONObject.put("error_code", 10004);
                        jSONObject.put("error_msg", "兜底下麦：" + com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().ecY());
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "lost_chat").setContentExt(jSONObject));
                    q.this.eeg();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
                public void onFail(int i, String str3) {
                }
            }).d(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp(), edU().Ys(), 1, str2);
            return;
        }
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.f(null, new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.q.13
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void a(AlaEndConnectionWheatHttpResponseMessage alaEndConnectionWheatHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
            public void onFail(int i, String str3) {
            }
        }).ha(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp(), edU().Ys());
    }

    public int getWheatHeight() {
        if (this.oJx != null) {
            return this.oJx.getWheatHeight();
        }
        return 0;
    }

    public boolean aq(ab abVar) {
        return (abVar == null || abVar.mLiveInfo == null || abVar.mLiveInfo.live_status != 2) ? false : true;
    }

    public boolean eeh() {
        ab Yt = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
        return (Yt == null || Yt.aKy == null || Yt.aKy.getRoomMode() != 2) ? false : true;
    }

    public boolean ebS() {
        ab Yt = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
        return (Yt == null || Yt.aKy == null || Yt.aKy.getRoomMode() != 100) ? false : true;
    }

    public com.baidu.tieba.yuyinala.liveroom.data.a eei() {
        return this.oJF;
    }
}
