package com.baidu.tieba.yuyinala.liveroom.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ae.e;
import com.baidu.live.d.ag;
import com.baidu.live.data.ab;
import com.baidu.live.data.ax;
import com.baidu.live.data.bv;
import com.baidu.live.data.co;
import com.baidu.live.data.v;
import com.baidu.live.im.b.d;
import com.baidu.live.im.k;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.EditHeadActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaCharmRankActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.coreextra.data.PhotoUrlData;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.img.WriteImagesInfo;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcAudioFlowStatisticManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.u;
import com.baidu.tieba.yuyinala.liveroom.introduce.g;
import com.baidu.tieba.yuyinala.liveroom.operation.a;
import com.baidu.tieba.yuyinala.liveroom.recommend.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends a {
    private PendantParentView bAa;
    private com.baidu.live.an.a bif;
    private FrameLayout hsq;
    private LinearLayout hva;
    private com.baidu.tieba.yuyinala.liveroom.activeview.b ovU;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.c ovV;
    private com.baidu.tieba.yuyinala.liveroom.i.b ovW;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.b ovX;
    private h ovY;
    private com.baidu.tieba.yuyinala.liveroom.ranklist.a ovZ;
    private g owa;
    private com.baidu.tieba.yuyinala.liveroom.charmrank.a owb;
    private com.baidu.tieba.yuyinala.liveroom.l.a owc;
    private boolean owd;
    private boolean owe;
    private long lastClickTime = 0;
    private com.baidu.live.liveroom.g.c hsE = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.1
        @Override // com.baidu.live.liveroom.g.c
        public void Ng() {
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cI(boolean z) {
            if (z) {
                if (c.this.ovB != null) {
                    c.this.ovB.Mh(8);
                }
            } else if (c.this.ovB != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                    c.this.ovB.Mh(0);
                } else {
                    c.this.ovB.Mh(8);
                }
            }
            if (c.this.htC != null) {
                c.this.htC.bD(z);
            }
        }
    };
    private CustomMessageListener cbL = new CustomMessageListener(2501074) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501074) {
                ab Yt = com.baidu.live.ao.a.Ym().Yt();
                if (Yt == null || Yt.aKy == null || Yt.aKy.getRoomMode() != 100) {
                    if (!c.this.owe) {
                        c.this.owe = true;
                        if (c.this.owb != null) {
                            c.this.owb.zS(c.this.owe);
                        }
                    }
                } else if (!c.this.owd && c.this.owe) {
                    c.this.owe = false;
                    if (c.this.owb != null) {
                        c.this.owb.zS(c.this.owe);
                    }
                }
            }
        }
    };
    private CustomMessageListener owf = new CustomMessageListener(2501032) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501032) {
                long currentTimeMillis = System.currentTimeMillis();
                if (c.this.eaV().owJ.Fp() != null && c.this.eaV().owJ.Fp().mLiveInfo != null) {
                    c.this.eaV().owJ.a(c.this.eaV().owJ.Fp().mLiveInfo.live_id, c.this.eaV().fromType, c.this.eaV().enterTime, currentTimeMillis);
                }
            }
        }
    };
    private HttpMessageListener hsI = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Oz() != null) {
                        e.QC().bCD = getQuickGiftHttpResponseMessage.Oz();
                        c.this.caz();
                    }
                }
            }
        }
    };
    CustomMessageListener hsN = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2913168) {
            }
        }
    };
    private CustomMessageListener hsM = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                d.KQ().setSwitchStatus(true);
                d.KQ().setSelectId((String) customResponsedMessage.getData());
                if (c.this.mHandler == null) {
                    c.this.mHandler = new Handler();
                }
                c.this.ovP = true;
                c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.cbm();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.yuyinala.liveroom.operation.b owg = new com.baidu.tieba.yuyinala.liveroom.operation.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3
        @Override // com.baidu.tieba.yuyinala.liveroom.operation.b
        public void a(View view, int i, String[] strArr) {
            String str;
            bv bvVar;
            co coVar;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c.this.lastClickTime >= 300) {
                c.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    c.this.ebf();
                    c.this.a(strArr, -1, -1, -1);
                } else if (i == 1) {
                    if (c.this.hto != null) {
                        c.this.cbm();
                    }
                } else if (i == 3) {
                    c.this.ovC.d(c.this.eaV().owJ.Fp(), false);
                } else if (i == 8) {
                    if (c.this.btl != null) {
                        c.this.btl.cC(false);
                    }
                    c.this.ebh();
                } else if (i != 12) {
                    if (i == 14) {
                        c.this.ebg();
                        ab Fp = c.this.eaV().owJ.Fp();
                        if (Fp != null && Fp.aJD != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmCardActivityConfig(c.this.eaV().pageContext.getPageActivity(), Fp.aJD.userName, Long.toString(Fp.aJD.userId), Long.toString(Fp.aJD.charmCount), String.valueOf(Fp.mLiveInfo.group_id), String.valueOf(Fp.mLiveInfo.live_id), false, String.valueOf(Fp.aJD.userId), Long.toString(Fp.aJZ.userId), Fp.aJZ.userName, Fp.aJZ.portrait, 0L, c.this.Lr(), Fp.aKB)));
                        }
                    } else if (i == 11) {
                        c.this.cbr();
                        c.this.cbs();
                    } else if (i == 16) {
                        if (c.this.eaV() != null && (bvVar = com.baidu.live.ae.a.Qm().bCs) != null && (coVar = bvVar.aRm) != null) {
                            String str3 = coVar.aSU.aTe;
                            if (!TextUtils.isEmpty(str3)) {
                                long j = 0;
                                if (c.this.eaV().owJ != null && c.this.eaV().owJ.Fp() != null && c.this.eaV().owJ.Fp().mLiveInfo != null) {
                                    j = c.this.eaV().owJ.Fp().mLiveInfo.live_id;
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", c.this.eaV().owJ.Fp().mLiveInfo.room_id + "", c.this.eaV().owJ.Fp().mLiveInfo.feed_id, c.this.Lr());
                                }
                                if (str3.contains("?")) {
                                    str2 = str3 + "&liveId=" + j;
                                } else {
                                    str2 = str3 + "?liveId=" + j;
                                }
                                if (c.this.bif == null) {
                                    c.this.bif = new com.baidu.live.an.a(c.this.eaV().pageContext.getPageActivity());
                                }
                                com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                                cVar.url = str2;
                                c.this.bif.a(cVar);
                            }
                        }
                    } else if (i == 20) {
                        if (c.this.eaV() != null) {
                            ab abVar = null;
                            if (c.this.eaV().owJ != null) {
                                abVar = c.this.eaV().owJ.Fp();
                            }
                            if (abVar != null && abVar.mLiveInfo != null && com.baidu.tieba.yuyinala.liveroom.p.b.ecb().bwG != null) {
                                String str4 = com.baidu.tieba.yuyinala.liveroom.p.b.ecb().bwG.aLD;
                                if (!TextUtils.isEmpty(str4)) {
                                    if (str4.contains("?")) {
                                        str = str4 + "&live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    } else {
                                        str = str4 + "?live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    }
                                    if (c.this.bif == null) {
                                        c.this.bif = new com.baidu.live.an.a(c.this.eaV().pageContext.getPageActivity());
                                    }
                                    com.baidu.live.an.c cVar2 = new com.baidu.live.an.c();
                                    cVar2.url = str;
                                    c.this.bif.a(cVar2);
                                }
                            }
                        }
                    } else if (i == 22) {
                        c.this.owc.ah(c.this.eaV().owJ.Fp());
                        c.this.ebe();
                    } else if (i == 23 && c.this.Ic()) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ag(BdBaseApplication.getInst(), String.valueOf(c.this.eaV().owJ.cjM().live_id), String.valueOf(c.this.eaV().owJ.cjM().group_id))));
                            c.this.ebd();
                        } catch (Exception e) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(c.this.eaV().pageContext.getPageActivity(), "请稍后重试", 1).show();
                                }
                            });
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.operation.b
        public void a(int i, com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
            if (i == 21 && c.this.Ic()) {
                if (c.this.ovY == null) {
                    c.this.ovY = new h(c.this.eaV().pageContext);
                }
                c.this.ovY.b(eVar);
            }
        }
    };
    private boolean hvk = false;

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
    }

    public void a(ab abVar, String str, String str2) {
        this.hvk = false;
        eaV().owK.setIsForceHandledTouch(false);
        eaV().owK.setSwipeClearEnable(false);
        eaV().owK.setOnLiveViewScrollListener(this.hsE);
        if (this.htX != null) {
            this.htX.setVisibility(0);
        }
        ccs();
        caD();
        caF();
        caK();
        eaZ();
        cbA();
        q.edU().a(eaV(), abVar);
        car();
        if (abVar != null && abVar.aKu != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_FEED_LOAD_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "audioConnect", null);
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().aS(abVar.aKu.aVk, str2, str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void m(ab abVar) {
        super.m(abVar);
        this.hvk = false;
        eaV().owK.setIsForceHandledTouch(false);
        eaV().owK.setSwipeClearEnable(false);
        eaV().owK.setOnLiveViewScrollListener(this.hsE);
        if (this.htX != null) {
            this.htX.setVisibility(0);
        }
        ccs();
        if (this.ovW != null) {
            this.ovW.a(abVar, this.htX);
        }
        caE();
        caI();
        caF();
        caK();
        ebc();
        eba();
        eaX();
        eaZ();
        nQ(false);
        cbv();
        cbu();
        cbA();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().ak(abVar);
        q.edU().a(eaV(), abVar);
        caA();
        cbw();
        cbN();
        cat();
        caz();
        cbJ();
        cal();
        cbM();
        c(this.gto);
        caw();
        MessageManager.getInstance().registerListener(this.owf);
        MessageManager.getInstance().registerListener(this.hsI);
        MessageManager.getInstance().registerListener(this.hsM);
        MessageManager.getInstance().registerListener(this.hsN);
        MessageManager.getInstance().registerListener(this.cbL);
        caO();
        caH();
        car();
        eaY();
    }

    private void eaX() {
        if (eaV().owJ != null && eaV().owJ.Fp() != null) {
            ab Fp = eaV().owJ.Fp();
            if (Fp.aKy != null && Fp.aKy.getRoomMode() == 2 && eaV() != null && eaV().owJ != null) {
                eaV().owJ.ozp = true;
                eaV().owJ.ag(eaV().owJ.Fp());
            }
        }
    }

    private void eaY() {
        q.edU().a(new q.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.q.a
            public void LX(int i) {
                c.this.ccm();
                c.this.cco();
            }
        });
    }

    private void eaZ() {
        if (eaV().owJ.Fp() != null && eaV().owJ.Fp().aJD != null && eaV().owJ.Fp().mLiveInfo != null && this.owc == null) {
            this.owc = new com.baidu.tieba.yuyinala.liveroom.l.a(eaV().pageContext);
        }
    }

    private void eba() {
        if (eaV().owJ.Fp() != null && eaV().owJ.Fp().aJD != null && eaV().owJ.Fp().mLiveInfo != null) {
            if (this.owb == null) {
                this.owb = new com.baidu.tieba.yuyinala.liveroom.charmrank.a(eaV().pageContext);
            }
            long j = eaV().owJ.Fp().aJD.userId;
            int i = eaV().owJ.Fp().mLiveInfo.live_type;
            String str = eaV().owJ.Fp().aJD.portrait;
            String str2 = eaV().owJ.Fp().mLiveInfo.feed_id;
            long j2 = eaV().owJ.Fp().mLiveInfo.live_id;
            String str3 = eaV().owJ.Fp().aJD.userName;
            this.owd = eaV().owJ.Fp().aKW;
            if (eaV().owJ.Fp().aKy.getRoomMode() == 100 && !this.owd) {
                this.owe = false;
            } else {
                this.owe = true;
            }
            this.owb.a(i, j, str3, false, str, Lr(), str2, j2, this.owe);
            this.owb.aF(this.htX);
            this.owb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ab Fp = c.this.eaV().owJ.Fp();
                    if (Fp != null && Fp.aJD != null) {
                        c.this.ebb();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmRankActivityConfig(c.this.eaV().pageContext.getPageActivity(), Fp.aJD.userName, Long.toString(Fp.aJD.userId), Long.toString(Fp.aJD.charmCount), String.valueOf(Fp.aKu.croom_id), String.valueOf(Fp.mLiveInfo.live_id), false, String.valueOf(Fp.aJD.userId), Long.toString(Fp.aJZ.userId), Fp.aJZ.userName, Fp.aJZ.portrait, 0L, Fp.aJZ.userType, c.this.owe)));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebb() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fp = eaV().owJ.Fp();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fp.aKu.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "charmlist_clk").setContentExt(jSONObject));
    }

    private void ebc() {
        if (eaV().owJ.Fp() != null && eaV().owJ.Fp().aJD != null && eaV().owJ.Fp().mLiveInfo != null) {
            if (this.owa == null) {
                this.owa = new g(eaV().pageContext);
            }
            this.owa.af(eaV().owJ.Fp());
            this.owa.aF(this.htX);
            this.owa.cHf();
        }
    }

    public void caK() {
        if (eaV().owJ.Fp() != null && eaV().owJ.Fp().mLiveInfo != null && eaV().owJ.Fp().aKu != null && eaV().owJ.Fp().aKz) {
            if (this.ovZ == null) {
                this.ovZ = new com.baidu.tieba.yuyinala.liveroom.ranklist.a(eaV().pageContext);
            }
            String str = eaV().owJ.Fp().aJZ.userUk;
            int i = eaV().owJ.Fp().mLiveInfo.live_type;
            String str2 = eaV().owJ.Fp().aKu.cover;
            String str3 = eaV().owJ.Fp().mLiveInfo.feed_id;
            long j = eaV().owJ.Fp().mLiveInfo.live_id;
            this.ovZ.a(i, str, eaV().owJ.Fp().aJD.userName, false, str2, Lr(), str3, j, eaV().owJ.Fp().aKu.croom_id, eaV().owJ.Fp().aKu.aVt, eaV().owJ.Fp().aKu.aVk, eaV().owJ.Fp().aKu.cover, eaV().owJ.Fp().aKu.room_name);
            this.ovZ.aF(this.htX);
            this.ovZ.cHf();
        }
    }

    private void cal() {
        if (this.ovL != null) {
            this.ovL.a(new a.InterfaceC0940a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.9
                @Override // com.baidu.tieba.yuyinala.liveroom.recommend.a.InterfaceC0940a
                public void cP(boolean z) {
                }
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(ab abVar) {
        super.k(abVar);
        if (this.ovW != null) {
            this.ovW.N(abVar);
        }
        aa(abVar);
        if (this.ovZ != null && abVar != null && abVar.aKu != null) {
            this.ovZ.Ml(abVar.aKu.aVt);
        }
        if (this.ovU != null) {
            this.ovU.j(abVar);
            this.ovU.nI(this.huh);
            this.ovU.updateView();
            if (abVar != null && this.htP != null && !this.htP.hasInit && !TextUtils.isEmpty(this.htP.aRJ)) {
                this.htP.hasInit = true;
                this.ovU.HF(this.htP.aRJ);
            }
        }
    }

    private void aa(ab abVar) {
        if (abVar != null && abVar.aKy != null && abVar.aKy.getRoomMode() == 2) {
            if (eaV() != null && eaV().owJ != null) {
                eaV().owJ.ozp = true;
                eaV().owJ.ag(abVar);
            }
        } else if (eaV() != null && eaV().owJ != null) {
            eaV().owJ.ozp = false;
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(v vVar) {
        if (vVar != null) {
            if (this.ovV != null && vVar.getList() != null) {
                this.ovV.e(vVar);
            }
            if (this.ovX != null) {
                this.ovX.ff(vVar.getCount());
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cw(int i) {
        super.cw(i);
    }

    private void car() {
        if (eaV() != null && eaV().pageContext != null && eaV().pageContext.getPageActivity() != null) {
            if (this.bAa == null) {
                this.bAa = new PendantParentView(eaV().pageContext.getPageActivity(), PendantParentView.Model.VERTICAL);
                u.a(eaV().owK, this.bAa, new ViewGroup.LayoutParams(-1, -1), 50);
                this.bAa.setDefaultItemMargin(eaV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
                this.bAa.setPadding(eaV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, eaV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            }
            ccm();
        }
    }

    private void cat() {
        if (this.ovU == null) {
            this.ovU = new com.baidu.tieba.yuyinala.liveroom.activeview.b(eaV().pageContext);
        }
        if (eaV() != null && eaV().owJ != null) {
            this.ovU.HC(eaV().owJ.cjQ());
        }
        this.ovU.setOtherParams(Lr());
        this.ovU.c(eaV().owJ.Fp(), false);
        this.ovU.setHost(false);
        this.ovU.nI(this.huh);
        this.ovU.a(1, this.bAa);
        this.ovU.a(2, this.bAa);
        this.ovU.setVisible(this.hub ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccm() {
        if (this.bAa != null) {
            int roomMode = eaV().owJ.Fp().aKy.getRoomMode();
            this.bAa.setIsAudioRoom(true);
            this.bAa.setModel(roomMode != 0 ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            this.bAa.setPosition(eaV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds164), 0, eaV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200), eaV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102));
            return;
        }
        car();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cco() {
        if (this.hto != null && this.hsq != null && this.hto.Kg() != null && this.hto.Kg().getView() != null) {
            int I = com.baidu.tieba.yuyinala.liveroom.q.a.I(this.hub, eaV().owJ.Fp().aKy.getRoomMode());
            if (this.htY.indexOfChild(this.hsq) != -1 && this.hsq.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsq.getLayoutParams();
                layoutParams.height = I;
                this.hsq.setLayoutParams(layoutParams);
            }
            if (this.hsq.indexOfChild(this.hto.Kg().getView()) != -1 && this.hto.Kg().getView().getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hto.Kg().getView().getLayoutParams();
                layoutParams2.height = I;
                this.hto.Kg().getView().setLayoutParams(layoutParams2);
            }
            this.hto.Kg().Kf();
        }
    }

    private void ccs() {
        if (this.hva == null) {
            this.hva = new LinearLayout(eaV().pageContext.getPageActivity());
            this.hva.setOrientation(1);
        }
        if (this.hva.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = eaV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = eaV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            u.a(eaV().owK, this.hva, layoutParams, 600);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caz() {
        if (this.ovB == null) {
            caF();
        }
        this.ovB.setOtherParams(Lr());
        this.ovB.a(e.QC().bCD, eaV().owJ.Fp());
    }

    private void cbA() {
        if (this.ovH != null && eaV() != null && eaV().owJ != null) {
            this.ovH.d(this.htX, eaV().owJ.Fp());
        }
    }

    private void caA() {
        CustomResponsedMessage runTask;
        if (this.hto == null && (runTask = MessageManager.getInstance().runTask(2501045, k.class, eaV().pageContext)) != null && runTask.getData() != null) {
            this.hto = (k) runTask.getData();
            this.hto.setFromMaster(false);
            this.hto.Kg().getView().setId(a.f.ala_liveroom_msg_list);
            this.hto.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2
                @Override // com.baidu.live.im.k.a
                public boolean Kk() {
                    return c.this.Ic();
                }

                @Override // com.baidu.live.im.k.a
                public void Kl() {
                    c.this.huf = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hh(String str) {
                    if (!c.this.hub) {
                        c.this.nN(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(c.this.eaV().pageContext.getPageActivity(), c.this.eaV().hDp.getLiveContainerView());
                    }
                    c.this.HJ(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Km() {
                    if (c.this.hub) {
                        c.this.nN(true);
                        c.this.eaV().hDp.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.eaV().pageContext.getPageActivity(), c.this.eaV().hDp.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.hto != null) {
                        c.this.hto.Kh().setQuickInputPanelVisible(false);
                        c.this.hto.Kh().Mc();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Kn() {
                    if (c.this.hub) {
                        c.this.nN(true);
                        c.this.eaV().hDp.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.eaV().pageContext.getPageActivity(), c.this.eaV().hDp.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.hto != null) {
                        c.this.hto.Kh().setQuickInputPanelVisible(false);
                        c.this.hto.Kh().Mc();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Ko() {
                    if (c.this.hub) {
                        c.this.caV();
                        if (c.this.htp != null) {
                            c.this.htp.zT();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Kp() {
                    return c.this.cbi();
                }

                @Override // com.baidu.live.im.k.a
                public int Kq() {
                    return c.this.cbj();
                }

                @Override // com.baidu.live.im.k.a
                public boolean Kr() {
                    return false;
                }
            });
            this.hsq = new FrameLayout(eaV().pageContext.getPageActivity());
            this.hsq.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hto != null && this.hsq != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(eaV().pageContext.getPageActivity()) * 0.7f);
            int I = com.baidu.tieba.yuyinala.liveroom.q.a.I(false, eaV().owJ.Fp().aKy.getRoomMode());
            if (this.htY.indexOfChild(this.hsq) < 0) {
                if (this.hsq.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hsq.getParent()).removeView(this.hsq);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, I);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.tieba.yuyinala.liveroom.q.a.dr(false);
                this.htY.addView(this.hsq, layoutParams);
            }
            if (this.hsq.indexOfChild(this.hto.Kg().getView()) < 0) {
                if (this.hto.Kg().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hto.Kg().getView()).removeView(this.hto.Kg().getView());
                }
                this.hsq.addView(this.hto.Kg().getView(), new FrameLayout.LayoutParams(equipmentWidth, I));
            }
            if (eaV().owK.indexOfChild(this.hto.Kh().getView()) < 0) {
                if (this.hto.Kh().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hto.Kh().getView().getParent()).removeView(this.hto.Kh().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cbp();
                u.a(eaV().owK, this.hto.Kh().getView(), layoutParams2, 450);
            }
            ab Fp = eaV().owJ.Fp();
            if (Fp != null && Fp.mLiveInfo != null) {
                this.hto.setLogData(Fp.mLiveInfo.feed_id, Lr());
            }
            this.hto.a(String.valueOf(eaV().owJ.Fp().mLiveInfo.group_id), String.valueOf(eaV().owJ.Fp().mLiveInfo.last_msg_id), String.valueOf(eaV().owJ.Fp().aJD.userId), String.valueOf(eaV().owJ.Fp().mLiveInfo.live_id), eaV().owJ.Fp().aJD.appId, (Fp == null || Fp.aKr == null || !Fp.aKr.Bi()) ? false : true, eaV().owJ.Fp().getGuardName());
            nN(false);
        }
    }

    private void caD() {
        if (this.ovW == null) {
            this.ovW = new com.baidu.tieba.yuyinala.liveroom.i.b(eaV().pageContext);
        }
        this.ovW.e(this.htX, eaV().owJ.Fp());
    }

    private void caE() {
        if (this.ovV == null) {
            this.ovV = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(eaV().pageContext, this);
        }
        this.ovV.a(String.valueOf(eaV().owJ.Fp().mLiveInfo.live_id), eaV().owJ.Fp());
        this.ovV.c(this.htX, a.f.ala_liveroom_hostheader, a.f.ala_liveroom_audience_count_layout);
        this.ovV.e(eaV().owJ.bTX());
        this.ovV.setOtherParams(Lr());
    }

    private void caF() {
        if (this.ovB == null) {
            this.ovB = new com.baidu.tieba.yuyinala.liveroom.operation.a(eaV().pageContext);
        }
        this.ovB.a(eaV(), this.htY, eaV().owJ.Fp().mLiveInfo, true, this.owg);
        this.ovB.setOtherParams(Lr());
    }

    public void nV(boolean z) {
        if (this.ovB != null) {
            this.ovB.nV(z);
        }
    }

    private void caI() {
        if (this.ovX == null) {
            this.ovX = new com.baidu.tieba.yuyinala.liveroom.audiencelist.b(eaV().pageContext.getPageActivity());
        }
        long j = 1;
        if (eaV().owJ.bTX() != null) {
            j = eaV().owJ.bTX().getCount();
        }
        this.ovX.a(this.owg);
        this.ovX.a(this.htX, a.f.ala_liveroom_audience, j);
        this.ovX.setVisible(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebd() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fp = eaV().owJ.Fp();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fp.aKu.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "msgbtn_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebe() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fp = eaV().owJ.Fp();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fp.aKu.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "morefunc_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebf() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fp = eaV().owJ.Fp();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fp.aKu.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "giftbtn_clk").setContentExt(jSONObject));
    }

    public void caJ() {
        this.ovC.d(eaV().owJ.Fp(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebg() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fp = eaV().owJ.Fp();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fp.aKu.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "olnumber_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebh() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fp = eaV().owJ.Fp();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fp.aKu.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "closebtn_clk").setContentExt(jSONObject));
    }

    private void caO() {
        if (this.huf || this.hug) {
            if ((TbadkCoreApplication.isLogin() && this.hto.Kh().hasText()) || this.hug) {
                this.huf = false;
                this.hug = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.ovP = true;
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.cbm();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void caG() {
        caH();
    }

    private void caH() {
        if (this.ovB != null) {
            int i = eaV().owJ.Fp().aJZ.isUegBlock;
            int i2 = eaV().owJ.Fp().aJZ.isBlock;
            String str = eaV().owJ.Fp().aJZ.userName;
            if (i > 0 || i2 > 0) {
                this.ovB.b(true, i, i2, str);
                this.hto.a(true, i, i2, str);
                this.ovG.b(true, i, i2, str);
                return;
            }
            this.ovB.b(false, i, i2, str);
            this.hto.a(false, i, i2, str);
            this.ovG.b(false, i, i2, str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        super.t(bVar);
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
        } catch (JSONException e) {
            jSONObject = null;
        }
        if ((bVar.getMsgType() == 12 || bVar.getMsgType() == 13) && jSONObject != null) {
            String optString = jSONObject.optString("content_type");
            if (!"enter_live".equals(optString)) {
                if ("update_liveinfo".equals(optString)) {
                    if (eaV().owJ.Fp() != null && eaV().owJ.Fp().mLiveInfo != null) {
                        eaV().owJ.a(eaV().owJ.Fp().mLiveInfo.live_id, eaV().fromType, eaV().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && eaV().owJ.Fp() != null && eaV().owJ.Fp().mLiveInfo != null && eaV().owJ.Fp().aJZ != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == eaV().owJ.Fp().aJZ.userId && optLong2 == eaV().owJ.Fp().mLiveInfo.live_id) {
                        jSONObject.optInt("challenge_status");
                        jSONObject.optLong("challenge_id");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void HE(String str) {
        if (this.ovU != null) {
            this.ovU.HE(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void cH(boolean z) {
        super.cH(z);
        if (eaV().owK != null) {
            eaV().owK.clw();
            eaV().owK.setLiveViewOnDispatchTouchEventListener(null);
            eaV().owK.setLiveViewOnTouchEventListener(null);
            eaV().owK.setOnLiveViewScrollListener(null);
        }
        if (eaV().btp != null) {
            eaV().btp.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        caP();
        if (this.ovB != null) {
            this.ovB.ckc();
        }
        if (this.bAa != null) {
            this.bAa.removeAllViews();
            this.bAa = null;
        }
        if (this.hva != null) {
            this.hva.removeAllViews();
            this.hva = null;
        }
        if (this.ovU != null) {
            this.ovU.release();
        }
        if (this.ovZ != null) {
            this.ovZ.Au();
        }
        if (this.owa != null) {
            this.owa.Au();
        }
        if (this.owb != null) {
            this.owb.Au();
        }
        if (this.ovW != null) {
            this.ovW.Au();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        caP();
        if (this.ovW != null) {
            this.ovW.onDestroy();
        }
        if (this.ovV != null) {
            this.ovV.onDestroy();
        }
        if (this.hto != null) {
            this.hto.onDestroy();
        }
        if (this.ovB != null) {
            this.ovB.onDestory();
        }
        if (this.ovU != null) {
            this.ovU.release();
        }
        if (this.ovZ != null) {
            this.ovZ.onDestroy();
        }
        if (this.owa != null) {
            this.owa.onDestroy();
        }
        if (this.owb != null) {
            this.owb.onDestroy();
        }
        if (this.ovY != null) {
            this.ovY.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.owf);
        MessageManager.getInstance().unRegisterListener(this.hsI);
        MessageManager.getInstance().unRegisterListener(this.hsM);
        MessageManager.getInstance().unRegisterListener(this.hsN);
        MessageManager.getInstance().unRegisterListener(this.cbL);
    }

    private void caP() {
        if (this.hto != null && this.hto.Kg().getView() != null && this.hto.Kg().getView().getParent() != null) {
            ((ViewGroup) this.hto.Kg().getView().getParent()).removeView(this.hto.Kg().getView());
        }
        if (this.hsq != null && this.hsq.getParent() != null) {
            ((ViewGroup) this.hsq.getParent()).removeView(this.hsq);
        }
        if (this.hto != null && this.hto.Kh().getView() != null) {
            this.htY.removeView(this.hto.Kh().getView());
        }
        if (this.hto != null) {
            this.hto.Kg().setMsgData(new LinkedList());
            this.hto.zU();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void a(ax axVar) {
        if (this.hto != null) {
            cbm();
            this.hto.Kh().setEditText(" @" + axVar.getNameShow() + " ");
        }
        if (this.ovB != null) {
            this.ovB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hto != null) {
            cbm();
            this.hto.Kh().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.ovB != null) {
            this.ovB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void b(ax axVar) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected View caQ() {
        if (this.hto != null) {
            return this.hto.Kh().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public boolean caR() {
        if (this.hto == null || !this.hto.Kh().Mb()) {
            return false;
        }
        nN(false);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    /* renamed from: ccz */
    public PendantParentView caT() {
        return this.bAa;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 24009) {
            if (i2 == -1) {
                if (intent != null && "ala_live_room_show_gift_panel".equals(intent.getStringExtra("ala_live_room_show_panel_key"))) {
                    int intExtra = intent.getIntExtra("ala_live_room_gift_panel_tab_id", -1);
                    int intExtra2 = intent.getIntExtra("ala_live_room_gift_panel_category_id", -1);
                    int intExtra3 = intent.getIntExtra("ala_live_room_gift_panel_gift_id", -1);
                    this.huc = false;
                    a(null, intExtra, intExtra2, intExtra3);
                    return;
                }
                caJ();
                return;
            }
            awr();
        } else if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            Ie(P(intent));
        }
    }

    private void Ie(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) eaV().pageContext.getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String P(Intent intent) {
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("album_result");
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        if (stringExtra != null) {
            writeImagesInfo.parseJson(stringExtra);
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            if (ListUtils.isEmpty(chosedFiles) || chosedFiles.get(0) == null) {
                return null;
            }
            return chosedFiles.get(0).getFilePath();
        }
        return null;
    }

    private void Q(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.ovW != null) {
            this.ovW.HR(fromJson.getBigurl());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            if (!this.ovP) {
                if (this.hto != null && this.hto.Kh() != null) {
                    this.hto.Kh().Ma();
                    return;
                }
                return;
            }
        } else {
            this.ovP = false;
        }
        if (this.hto != null && this.hto.Kg() != null) {
            this.hto.Kg().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hto == null || this.hto.Kh() == null || !this.hto.Kh().Mb()) {
            if (z) {
                if (this.ovB != null) {
                    this.ovB.setVisibility(8);
                }
                if (this.htq != null && this.htq.EM() != null) {
                    this.htq.EM().setVisibility(8);
                }
                caV();
                if (this.hto != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hto.Kh().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hto.Kh().getView().setLayoutParams(layoutParams);
                    this.hto.Kh().getView().setVisibility(0);
                    this.hto.Kh().setQuickInputPanelVisible(false);
                }
                if (this.htX != null) {
                    this.htX.setVisibility(8);
                }
                if (this.htp != null) {
                    this.htp.zT();
                }
                if (this.ovU != null) {
                    this.ovU.setVisible(8);
                }
                if (this.htQ != null) {
                    this.htQ.setCanVisible(false);
                }
            } else {
                caU();
            }
            cco();
            if (this.htC != null) {
                this.htC.bC(z);
            }
        }
    }

    private void caU() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.ovB != null) {
            this.ovB.setVisibility(0);
        }
        if (this.hsq != null && (layoutParams = (RelativeLayout.LayoutParams) this.hsq.getLayoutParams()) != null) {
            layoutParams.bottomMargin = eaV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds120);
            this.hsq.setLayoutParams(layoutParams);
        }
        if (this.hto != null) {
            cbp();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hto.Kh().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hto.Kh().getView().setLayoutParams(layoutParams2);
        }
        if (this.ovB != null) {
            this.ovB.setVisibility(0);
        }
        if (this.htq != null && this.htq.EM() != null) {
            this.htq.EM().setVisibility(0);
        }
        if (this.htX != null) {
            this.htX.setVisibility(0);
        }
        if (this.ovU != null) {
            this.ovU.setVisible(0);
        }
        if (this.htp != null) {
            this.htp.zT();
        }
        if (this.htQ != null) {
            this.htQ.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caV() {
        boolean z;
        boolean z2;
        if (this.hsq != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsq.getLayoutParams();
            if (this.hto == null || this.hto.Kh() == null) {
                z = false;
                z2 = false;
            } else {
                boolean LZ = this.hto.Kh().LZ();
                z = this.hto.Kh().Ma();
                z2 = LZ;
            }
            int O = O(z2, z);
            if (layoutParams.bottomMargin != O) {
                layoutParams.bottomMargin = O;
                this.hsq.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(boolean z) {
        this.hvk = z;
        if (z) {
            this.hto.Kh().setQuickInputPanelVisible(true);
            return;
        }
        caU();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3 && this.ovV != null) {
            this.ovV.cs(i3);
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public boolean dG(int i) {
        return super.dG(i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void vq(int i) {
        super.vq(i);
        if (i == 11) {
            if (this.ovB != null) {
                this.ovB.setVisibility(8);
            }
            if (this.hto != null) {
                this.hto.Kg().getView().setVisibility(4);
            }
            if (this.ovU != null) {
                this.ovU.bN(2, 8);
            }
            if (this.ovI != null) {
                this.ovI.oM(false);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public void dH(int i) {
        super.dH(i);
        if (i == 11) {
            if (this.ovB != null) {
                this.ovB.setVisibility(0);
            }
            if (this.hto != null) {
                this.hto.Kg().getView().setVisibility(0);
            }
            if (this.ovU != null) {
                this.ovU.setVisible(0);
            }
            if (this.ovI != null) {
                this.ovI.oM(true);
            }
            this.htX.setVisibility(0);
        }
    }

    private void caw() {
        if (this.ovB != null) {
            this.ovB.a(new a.InterfaceC0939a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.ovU != null) {
            this.ovU.onStop();
        }
        if (this.ovZ != null) {
            this.ovZ.ckz();
        }
        if (this.owa != null) {
            this.owa.ckz();
        }
        if (this.owb != null) {
            this.owb.ckz();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.edw().onDestroy();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.ovU != null) {
            this.ovU.onStart();
        }
        if (this.ovZ != null) {
            this.ovZ.cky();
        }
        if (this.owa != null) {
            this.owa.cky();
        }
        if (this.owb != null) {
            this.owb.cky();
        }
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c cVar) {
        ViewGroup edW = q.edU().edW();
        if (edW != null && (edW instanceof TeamFightLayout)) {
            ((TeamFightLayout) edW).b(cVar);
        }
    }
}
