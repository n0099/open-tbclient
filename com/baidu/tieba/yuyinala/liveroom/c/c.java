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
/* loaded from: classes11.dex */
public class c extends a {
    private com.baidu.live.an.a bgE;
    private PendantParentView byA;
    private FrameLayout hqH;
    private LinearLayout htr;
    private com.baidu.tieba.yuyinala.liveroom.activeview.b otO;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.c otP;
    private com.baidu.tieba.yuyinala.liveroom.i.b otQ;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.b otR;
    private h otS;
    private com.baidu.tieba.yuyinala.liveroom.ranklist.a otT;
    private g otU;
    private com.baidu.tieba.yuyinala.liveroom.charmrank.a otV;
    private com.baidu.tieba.yuyinala.liveroom.l.a otW;
    private boolean otX;
    private boolean otY;
    private long lastClickTime = 0;
    private com.baidu.live.liveroom.g.c hqV = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.1
        @Override // com.baidu.live.liveroom.g.c
        public void Nd() {
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cI(boolean z) {
            if (z) {
                if (c.this.otv != null) {
                    c.this.otv.Md(8);
                }
            } else if (c.this.otv != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                    c.this.otv.Md(0);
                } else {
                    c.this.otv.Md(8);
                }
            }
            if (c.this.hrT != null) {
                c.this.hrT.bD(z);
            }
        }
    };
    private CustomMessageListener cak = new CustomMessageListener(2501074) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501074) {
                ab Yq = com.baidu.live.ao.a.Yj().Yq();
                if (Yq == null || Yq.aIY == null || Yq.aIY.getRoomMode() != 100) {
                    if (!c.this.otY) {
                        c.this.otY = true;
                        if (c.this.otV != null) {
                            c.this.otV.zT(c.this.otY);
                        }
                    }
                } else if (!c.this.otX && c.this.otY) {
                    c.this.otY = false;
                    if (c.this.otV != null) {
                        c.this.otV.zT(c.this.otY);
                    }
                }
            }
        }
    };
    private CustomMessageListener otZ = new CustomMessageListener(2501032) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501032) {
                long currentTimeMillis = System.currentTimeMillis();
                if (c.this.eaN().ouE.Fm() != null && c.this.eaN().ouE.Fm().mLiveInfo != null) {
                    c.this.eaN().ouE.a(c.this.eaN().ouE.Fm().mLiveInfo.live_id, c.this.eaN().fromType, c.this.eaN().enterTime, currentTimeMillis);
                }
            }
        }
    };
    private HttpMessageListener hqZ = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Ow() != null) {
                        e.Qz().bBd = getQuickGiftHttpResponseMessage.Ow();
                        c.this.cat();
                    }
                }
            }
        }
    };
    CustomMessageListener hre = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2913168) {
            }
        }
    };
    private CustomMessageListener hrd = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                d.KN().setSwitchStatus(true);
                d.KN().setSelectId((String) customResponsedMessage.getData());
                if (c.this.mHandler == null) {
                    c.this.mHandler = new Handler();
                }
                c.this.otJ = true;
                c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.cbg();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.yuyinala.liveroom.operation.b oua = new com.baidu.tieba.yuyinala.liveroom.operation.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3
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
                    c.this.eaX();
                    c.this.a(strArr, -1, -1, -1);
                } else if (i == 1) {
                    if (c.this.hrF != null) {
                        c.this.cbg();
                    }
                } else if (i == 3) {
                    c.this.otw.d(c.this.eaN().ouE.Fm(), false);
                } else if (i == 8) {
                    if (c.this.brL != null) {
                        c.this.brL.cC(false);
                    }
                    c.this.eaZ();
                } else if (i != 12) {
                    if (i == 14) {
                        c.this.eaY();
                        ab Fm = c.this.eaN().ouE.Fm();
                        if (Fm != null && Fm.aId != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmCardActivityConfig(c.this.eaN().pageContext.getPageActivity(), Fm.aId.userName, Long.toString(Fm.aId.userId), Long.toString(Fm.aId.charmCount), String.valueOf(Fm.mLiveInfo.group_id), String.valueOf(Fm.mLiveInfo.live_id), false, String.valueOf(Fm.aId.userId), Long.toString(Fm.aIz.userId), Fm.aIz.userName, Fm.aIz.portrait, 0L, c.this.Lo(), Fm.aJb)));
                        }
                    } else if (i == 11) {
                        c.this.cbl();
                        c.this.cbm();
                    } else if (i == 16) {
                        if (c.this.eaN() != null && (bvVar = com.baidu.live.ae.a.Qj().bAS) != null && (coVar = bvVar.aPM) != null) {
                            String str3 = coVar.aRu.aRE;
                            if (!TextUtils.isEmpty(str3)) {
                                long j = 0;
                                if (c.this.eaN().ouE != null && c.this.eaN().ouE.Fm() != null && c.this.eaN().ouE.Fm().mLiveInfo != null) {
                                    j = c.this.eaN().ouE.Fm().mLiveInfo.live_id;
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", c.this.eaN().ouE.Fm().mLiveInfo.room_id + "", c.this.eaN().ouE.Fm().mLiveInfo.feed_id, c.this.Lo());
                                }
                                if (str3.contains("?")) {
                                    str2 = str3 + "&liveId=" + j;
                                } else {
                                    str2 = str3 + "?liveId=" + j;
                                }
                                if (c.this.bgE == null) {
                                    c.this.bgE = new com.baidu.live.an.a(c.this.eaN().pageContext.getPageActivity());
                                }
                                com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                                cVar.url = str2;
                                c.this.bgE.a(cVar);
                            }
                        }
                    } else if (i == 20) {
                        if (c.this.eaN() != null) {
                            ab abVar = null;
                            if (c.this.eaN().ouE != null) {
                                abVar = c.this.eaN().ouE.Fm();
                            }
                            if (abVar != null && abVar.mLiveInfo != null && com.baidu.tieba.yuyinala.liveroom.p.b.ebT().bvg != null) {
                                String str4 = com.baidu.tieba.yuyinala.liveroom.p.b.ebT().bvg.aKd;
                                if (!TextUtils.isEmpty(str4)) {
                                    if (str4.contains("?")) {
                                        str = str4 + "&live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    } else {
                                        str = str4 + "?live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    }
                                    if (c.this.bgE == null) {
                                        c.this.bgE = new com.baidu.live.an.a(c.this.eaN().pageContext.getPageActivity());
                                    }
                                    com.baidu.live.an.c cVar2 = new com.baidu.live.an.c();
                                    cVar2.url = str;
                                    c.this.bgE.a(cVar2);
                                }
                            }
                        }
                    } else if (i == 22) {
                        c.this.otW.ah(c.this.eaN().ouE.Fm());
                        c.this.eaW();
                    } else if (i == 23 && c.this.HZ()) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ag(BdBaseApplication.getInst(), String.valueOf(c.this.eaN().ouE.cjG().live_id), String.valueOf(c.this.eaN().ouE.cjG().group_id))));
                            c.this.eaV();
                        } catch (Exception e) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(c.this.eaN().pageContext.getPageActivity(), "请稍后重试", 1).show();
                                }
                            });
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.operation.b
        public void a(int i, com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
            if (i == 21 && c.this.HZ()) {
                if (c.this.otS == null) {
                    c.this.otS = new h(c.this.eaN().pageContext);
                }
                c.this.otS.b(eVar);
            }
        }
    };
    private boolean htB = false;

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
    }

    public void a(ab abVar, String str, String str2) {
        this.htB = false;
        eaN().ouF.setIsForceHandledTouch(false);
        eaN().ouF.setSwipeClearEnable(false);
        eaN().ouF.setOnLiveViewScrollListener(this.hqV);
        if (this.hso != null) {
            this.hso.setVisibility(0);
        }
        ccm();
        cax();
        caz();
        caE();
        eaR();
        cbu();
        q.edM().a(eaN(), abVar);
        cal();
        if (abVar != null && abVar.aIU != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_FEED_LOAD_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "audioConnect", null);
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().aS(abVar.aIU.aTK, str2, str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void m(ab abVar) {
        super.m(abVar);
        this.htB = false;
        eaN().ouF.setIsForceHandledTouch(false);
        eaN().ouF.setSwipeClearEnable(false);
        eaN().ouF.setOnLiveViewScrollListener(this.hqV);
        if (this.hso != null) {
            this.hso.setVisibility(0);
        }
        ccm();
        if (this.otQ != null) {
            this.otQ.a(abVar, this.hso);
        }
        cay();
        caC();
        caz();
        caE();
        eaU();
        eaS();
        eaP();
        eaR();
        nQ(false);
        cbp();
        cbo();
        cbu();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ak(abVar);
        q.edM().a(eaN(), abVar);
        cau();
        cbq();
        cbH();
        can();
        cat();
        cbD();
        caf();
        cbG();
        c(this.grF);
        caq();
        MessageManager.getInstance().registerListener(this.otZ);
        MessageManager.getInstance().registerListener(this.hqZ);
        MessageManager.getInstance().registerListener(this.hrd);
        MessageManager.getInstance().registerListener(this.hre);
        MessageManager.getInstance().registerListener(this.cak);
        caI();
        caB();
        cal();
        eaQ();
    }

    private void eaP() {
        if (eaN().ouE != null && eaN().ouE.Fm() != null) {
            ab Fm = eaN().ouE.Fm();
            if (Fm.aIY != null && Fm.aIY.getRoomMode() == 2 && eaN() != null && eaN().ouE != null) {
                eaN().ouE.oxk = true;
                eaN().ouE.ag(eaN().ouE.Fm());
            }
        }
    }

    private void eaQ() {
        q.edM().a(new q.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.q.a
            public void LT(int i) {
                c.this.ccg();
                c.this.cci();
            }
        });
    }

    private void eaR() {
        if (eaN().ouE.Fm() != null && eaN().ouE.Fm().aId != null && eaN().ouE.Fm().mLiveInfo != null && this.otW == null) {
            this.otW = new com.baidu.tieba.yuyinala.liveroom.l.a(eaN().pageContext);
        }
    }

    private void eaS() {
        if (eaN().ouE.Fm() != null && eaN().ouE.Fm().aId != null && eaN().ouE.Fm().mLiveInfo != null) {
            if (this.otV == null) {
                this.otV = new com.baidu.tieba.yuyinala.liveroom.charmrank.a(eaN().pageContext);
            }
            long j = eaN().ouE.Fm().aId.userId;
            int i = eaN().ouE.Fm().mLiveInfo.live_type;
            String str = eaN().ouE.Fm().aId.portrait;
            String str2 = eaN().ouE.Fm().mLiveInfo.feed_id;
            long j2 = eaN().ouE.Fm().mLiveInfo.live_id;
            String str3 = eaN().ouE.Fm().aId.userName;
            this.otX = eaN().ouE.Fm().aJw;
            if (eaN().ouE.Fm().aIY.getRoomMode() == 100 && !this.otX) {
                this.otY = false;
            } else {
                this.otY = true;
            }
            this.otV.a(i, j, str3, false, str, Lo(), str2, j2, this.otY);
            this.otV.aF(this.hso);
            this.otV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ab Fm = c.this.eaN().ouE.Fm();
                    if (Fm != null && Fm.aId != null) {
                        c.this.eaT();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmRankActivityConfig(c.this.eaN().pageContext.getPageActivity(), Fm.aId.userName, Long.toString(Fm.aId.userId), Long.toString(Fm.aId.charmCount), String.valueOf(Fm.aIU.croom_id), String.valueOf(Fm.mLiveInfo.live_id), false, String.valueOf(Fm.aId.userId), Long.toString(Fm.aIz.userId), Fm.aIz.userName, Fm.aIz.portrait, 0L, Fm.aIz.userType, c.this.otY)));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaT() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = eaN().ouE.Fm();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fm.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "charmlist_clk").setContentExt(jSONObject));
    }

    private void eaU() {
        if (eaN().ouE.Fm() != null && eaN().ouE.Fm().aId != null && eaN().ouE.Fm().mLiveInfo != null) {
            if (this.otU == null) {
                this.otU = new g(eaN().pageContext);
            }
            this.otU.af(eaN().ouE.Fm());
            this.otU.aF(this.hso);
            this.otU.cGZ();
        }
    }

    public void caE() {
        if (eaN().ouE.Fm() != null && eaN().ouE.Fm().mLiveInfo != null && eaN().ouE.Fm().aIU != null && eaN().ouE.Fm().aIZ) {
            if (this.otT == null) {
                this.otT = new com.baidu.tieba.yuyinala.liveroom.ranklist.a(eaN().pageContext);
            }
            String str = eaN().ouE.Fm().aIz.userUk;
            int i = eaN().ouE.Fm().mLiveInfo.live_type;
            String str2 = eaN().ouE.Fm().aIU.cover;
            String str3 = eaN().ouE.Fm().mLiveInfo.feed_id;
            long j = eaN().ouE.Fm().mLiveInfo.live_id;
            this.otT.a(i, str, eaN().ouE.Fm().aId.userName, false, str2, Lo(), str3, j, eaN().ouE.Fm().aIU.croom_id, eaN().ouE.Fm().aIU.aTT, eaN().ouE.Fm().aIU.aTK, eaN().ouE.Fm().aIU.cover, eaN().ouE.Fm().aIU.room_name);
            this.otT.aF(this.hso);
            this.otT.cGZ();
        }
    }

    private void caf() {
        if (this.otF != null) {
            this.otF.a(new a.InterfaceC0934a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.9
                @Override // com.baidu.tieba.yuyinala.liveroom.recommend.a.InterfaceC0934a
                public void cP(boolean z) {
                }
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(ab abVar) {
        super.k(abVar);
        if (this.otQ != null) {
            this.otQ.N(abVar);
        }
        aa(abVar);
        if (this.otT != null && abVar != null && abVar.aIU != null) {
            this.otT.Mh(abVar.aIU.aTT);
        }
        if (this.otO != null) {
            this.otO.j(abVar);
            this.otO.nI(this.hsy);
            this.otO.updateView();
            if (abVar != null && this.hsg != null && !this.hsg.hasInit && !TextUtils.isEmpty(this.hsg.aQj)) {
                this.hsg.hasInit = true;
                this.otO.Hw(this.hsg.aQj);
            }
        }
    }

    private void aa(ab abVar) {
        if (abVar != null && abVar.aIY != null && abVar.aIY.getRoomMode() == 2) {
            if (eaN() != null && eaN().ouE != null) {
                eaN().ouE.oxk = true;
                eaN().ouE.ag(abVar);
            }
        } else if (eaN() != null && eaN().ouE != null) {
            eaN().ouE.oxk = false;
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(v vVar) {
        if (vVar != null) {
            if (this.otP != null && vVar.getList() != null) {
                this.otP.e(vVar);
            }
            if (this.otR != null) {
                this.otR.ff(vVar.getCount());
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cv(int i) {
        super.cv(i);
    }

    private void cal() {
        if (eaN() != null && eaN().pageContext != null && eaN().pageContext.getPageActivity() != null) {
            if (this.byA == null) {
                this.byA = new PendantParentView(eaN().pageContext.getPageActivity(), PendantParentView.Model.VERTICAL);
                u.a(eaN().ouF, this.byA, new ViewGroup.LayoutParams(-1, -1), 50);
                this.byA.setDefaultItemMargin(eaN().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
                this.byA.setPadding(eaN().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, eaN().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            }
            ccg();
        }
    }

    private void can() {
        if (this.otO == null) {
            this.otO = new com.baidu.tieba.yuyinala.liveroom.activeview.b(eaN().pageContext);
        }
        if (eaN() != null && eaN().ouE != null) {
            this.otO.Ht(eaN().ouE.cjK());
        }
        this.otO.setOtherParams(Lo());
        this.otO.c(eaN().ouE.Fm(), false);
        this.otO.setHost(false);
        this.otO.nI(this.hsy);
        this.otO.a(1, this.byA);
        this.otO.a(2, this.byA);
        this.otO.setVisible(this.hss ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccg() {
        if (this.byA != null) {
            int roomMode = eaN().ouE.Fm().aIY.getRoomMode();
            this.byA.setIsAudioRoom(true);
            this.byA.setModel(roomMode != 0 ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            this.byA.setPosition(eaN().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds164), 0, eaN().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200), eaN().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102));
            return;
        }
        cal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cci() {
        if (this.hrF != null && this.hqH != null && this.hrF.Kd() != null && this.hrF.Kd().getView() != null) {
            int I = com.baidu.tieba.yuyinala.liveroom.q.a.I(this.hss, eaN().ouE.Fm().aIY.getRoomMode());
            if (this.hsp.indexOfChild(this.hqH) != -1 && this.hqH.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqH.getLayoutParams();
                layoutParams.height = I;
                this.hqH.setLayoutParams(layoutParams);
            }
            if (this.hqH.indexOfChild(this.hrF.Kd().getView()) != -1 && this.hrF.Kd().getView().getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hrF.Kd().getView().getLayoutParams();
                layoutParams2.height = I;
                this.hrF.Kd().getView().setLayoutParams(layoutParams2);
            }
            this.hrF.Kd().Kc();
        }
    }

    private void ccm() {
        if (this.htr == null) {
            this.htr = new LinearLayout(eaN().pageContext.getPageActivity());
            this.htr.setOrientation(1);
        }
        if (this.htr.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = eaN().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = eaN().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            u.a(eaN().ouF, this.htr, layoutParams, 600);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cat() {
        if (this.otv == null) {
            caz();
        }
        this.otv.setOtherParams(Lo());
        this.otv.a(e.Qz().bBd, eaN().ouE.Fm());
    }

    private void cbu() {
        if (this.otB != null && eaN() != null && eaN().ouE != null) {
            this.otB.d(this.hso, eaN().ouE.Fm());
        }
    }

    private void cau() {
        CustomResponsedMessage runTask;
        if (this.hrF == null && (runTask = MessageManager.getInstance().runTask(2501045, k.class, eaN().pageContext)) != null && runTask.getData() != null) {
            this.hrF = (k) runTask.getData();
            this.hrF.setFromMaster(false);
            this.hrF.Kd().getView().setId(a.f.ala_liveroom_msg_list);
            this.hrF.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2
                @Override // com.baidu.live.im.k.a
                public boolean Kh() {
                    return c.this.HZ();
                }

                @Override // com.baidu.live.im.k.a
                public void Ki() {
                    c.this.hsw = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hb(String str) {
                    if (!c.this.hss) {
                        c.this.nN(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(c.this.eaN().pageContext.getPageActivity(), c.this.eaN().hBG.getLiveContainerView());
                    }
                    c.this.HA(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Kj() {
                    if (c.this.hss) {
                        c.this.nN(true);
                        c.this.eaN().hBG.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.eaN().pageContext.getPageActivity(), c.this.eaN().hBG.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.hrF != null) {
                        c.this.hrF.Ke().setQuickInputPanelVisible(false);
                        c.this.hrF.Ke().LZ();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Kk() {
                    if (c.this.hss) {
                        c.this.nN(true);
                        c.this.eaN().hBG.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.eaN().pageContext.getPageActivity(), c.this.eaN().hBG.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.hrF != null) {
                        c.this.hrF.Ke().setQuickInputPanelVisible(false);
                        c.this.hrF.Ke().LZ();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Kl() {
                    if (c.this.hss) {
                        c.this.caP();
                        if (c.this.hrG != null) {
                            c.this.hrG.zQ();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Km() {
                    return c.this.cbc();
                }

                @Override // com.baidu.live.im.k.a
                public int Kn() {
                    return c.this.cbd();
                }

                @Override // com.baidu.live.im.k.a
                public boolean Ko() {
                    return false;
                }
            });
            this.hqH = new FrameLayout(eaN().pageContext.getPageActivity());
            this.hqH.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hrF != null && this.hqH != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(eaN().pageContext.getPageActivity()) * 0.7f);
            int I = com.baidu.tieba.yuyinala.liveroom.q.a.I(false, eaN().ouE.Fm().aIY.getRoomMode());
            if (this.hsp.indexOfChild(this.hqH) < 0) {
                if (this.hqH.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hqH.getParent()).removeView(this.hqH);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, I);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.tieba.yuyinala.liveroom.q.a.dr(false);
                this.hsp.addView(this.hqH, layoutParams);
            }
            if (this.hqH.indexOfChild(this.hrF.Kd().getView()) < 0) {
                if (this.hrF.Kd().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrF.Kd().getView()).removeView(this.hrF.Kd().getView());
                }
                this.hqH.addView(this.hrF.Kd().getView(), new FrameLayout.LayoutParams(equipmentWidth, I));
            }
            if (eaN().ouF.indexOfChild(this.hrF.Ke().getView()) < 0) {
                if (this.hrF.Ke().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrF.Ke().getView().getParent()).removeView(this.hrF.Ke().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cbj();
                u.a(eaN().ouF, this.hrF.Ke().getView(), layoutParams2, 450);
            }
            ab Fm = eaN().ouE.Fm();
            if (Fm != null && Fm.mLiveInfo != null) {
                this.hrF.setLogData(Fm.mLiveInfo.feed_id, Lo());
            }
            this.hrF.a(String.valueOf(eaN().ouE.Fm().mLiveInfo.group_id), String.valueOf(eaN().ouE.Fm().mLiveInfo.last_msg_id), String.valueOf(eaN().ouE.Fm().aId.userId), String.valueOf(eaN().ouE.Fm().mLiveInfo.live_id), eaN().ouE.Fm().aId.appId, (Fm == null || Fm.aIR == null || !Fm.aIR.Bf()) ? false : true, eaN().ouE.Fm().getGuardName());
            nN(false);
        }
    }

    private void cax() {
        if (this.otQ == null) {
            this.otQ = new com.baidu.tieba.yuyinala.liveroom.i.b(eaN().pageContext);
        }
        this.otQ.e(this.hso, eaN().ouE.Fm());
    }

    private void cay() {
        if (this.otP == null) {
            this.otP = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(eaN().pageContext, this);
        }
        this.otP.a(String.valueOf(eaN().ouE.Fm().mLiveInfo.live_id), eaN().ouE.Fm());
        this.otP.c(this.hso, a.f.ala_liveroom_hostheader, a.f.ala_liveroom_audience_count_layout);
        this.otP.e(eaN().ouE.bTR());
        this.otP.setOtherParams(Lo());
    }

    private void caz() {
        if (this.otv == null) {
            this.otv = new com.baidu.tieba.yuyinala.liveroom.operation.a(eaN().pageContext);
        }
        this.otv.a(eaN(), this.hsp, eaN().ouE.Fm().mLiveInfo, true, this.oua);
        this.otv.setOtherParams(Lo());
    }

    public void nV(boolean z) {
        if (this.otv != null) {
            this.otv.nV(z);
        }
    }

    private void caC() {
        if (this.otR == null) {
            this.otR = new com.baidu.tieba.yuyinala.liveroom.audiencelist.b(eaN().pageContext.getPageActivity());
        }
        long j = 1;
        if (eaN().ouE.bTR() != null) {
            j = eaN().ouE.bTR().getCount();
        }
        this.otR.a(this.oua);
        this.otR.a(this.hso, a.f.ala_liveroom_audience, j);
        this.otR.setVisible(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaV() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = eaN().ouE.Fm();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fm.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "msgbtn_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaW() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = eaN().ouE.Fm();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fm.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "morefunc_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaX() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = eaN().ouE.Fm();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fm.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "giftbtn_clk").setContentExt(jSONObject));
    }

    public void caD() {
        this.otw.d(eaN().ouE.Fm(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaY() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = eaN().ouE.Fm();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fm.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "olnumber_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = eaN().ouE.Fm();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fm.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "closebtn_clk").setContentExt(jSONObject));
    }

    private void caI() {
        if (this.hsw || this.hsx) {
            if ((TbadkCoreApplication.isLogin() && this.hrF.Ke().hasText()) || this.hsx) {
                this.hsw = false;
                this.hsx = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.otJ = true;
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.cbg();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void caA() {
        caB();
    }

    private void caB() {
        if (this.otv != null) {
            int i = eaN().ouE.Fm().aIz.isUegBlock;
            int i2 = eaN().ouE.Fm().aIz.isBlock;
            String str = eaN().ouE.Fm().aIz.userName;
            if (i > 0 || i2 > 0) {
                this.otv.b(true, i, i2, str);
                this.hrF.a(true, i, i2, str);
                this.otA.b(true, i, i2, str);
                return;
            }
            this.otv.b(false, i, i2, str);
            this.hrF.a(false, i, i2, str);
            this.otA.b(false, i, i2, str);
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
                    if (eaN().ouE.Fm() != null && eaN().ouE.Fm().mLiveInfo != null) {
                        eaN().ouE.a(eaN().ouE.Fm().mLiveInfo.live_id, eaN().fromType, eaN().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && eaN().ouE.Fm() != null && eaN().ouE.Fm().mLiveInfo != null && eaN().ouE.Fm().aIz != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == eaN().ouE.Fm().aIz.userId && optLong2 == eaN().ouE.Fm().mLiveInfo.live_id) {
                        jSONObject.optInt("challenge_status");
                        jSONObject.optLong("challenge_id");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void Hv(String str) {
        if (this.otO != null) {
            this.otO.Hv(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void cH(boolean z) {
        super.cH(z);
        if (eaN().ouF != null) {
            eaN().ouF.clq();
            eaN().ouF.setLiveViewOnDispatchTouchEventListener(null);
            eaN().ouF.setLiveViewOnTouchEventListener(null);
            eaN().ouF.setOnLiveViewScrollListener(null);
        }
        if (eaN().brO != null) {
            eaN().brO.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        caJ();
        if (this.otv != null) {
            this.otv.cjW();
        }
        if (this.byA != null) {
            this.byA.removeAllViews();
            this.byA = null;
        }
        if (this.htr != null) {
            this.htr.removeAllViews();
            this.htr = null;
        }
        if (this.otO != null) {
            this.otO.release();
        }
        if (this.otT != null) {
            this.otT.Ar();
        }
        if (this.otU != null) {
            this.otU.Ar();
        }
        if (this.otV != null) {
            this.otV.Ar();
        }
        if (this.otQ != null) {
            this.otQ.Ar();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        caJ();
        if (this.otQ != null) {
            this.otQ.onDestroy();
        }
        if (this.otP != null) {
            this.otP.onDestroy();
        }
        if (this.hrF != null) {
            this.hrF.onDestroy();
        }
        if (this.otv != null) {
            this.otv.onDestory();
        }
        if (this.otO != null) {
            this.otO.release();
        }
        if (this.otT != null) {
            this.otT.onDestroy();
        }
        if (this.otU != null) {
            this.otU.onDestroy();
        }
        if (this.otV != null) {
            this.otV.onDestroy();
        }
        if (this.otS != null) {
            this.otS.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.otZ);
        MessageManager.getInstance().unRegisterListener(this.hqZ);
        MessageManager.getInstance().unRegisterListener(this.hrd);
        MessageManager.getInstance().unRegisterListener(this.hre);
        MessageManager.getInstance().unRegisterListener(this.cak);
    }

    private void caJ() {
        if (this.hrF != null && this.hrF.Kd().getView() != null && this.hrF.Kd().getView().getParent() != null) {
            ((ViewGroup) this.hrF.Kd().getView().getParent()).removeView(this.hrF.Kd().getView());
        }
        if (this.hqH != null && this.hqH.getParent() != null) {
            ((ViewGroup) this.hqH.getParent()).removeView(this.hqH);
        }
        if (this.hrF != null && this.hrF.Ke().getView() != null) {
            this.hsp.removeView(this.hrF.Ke().getView());
        }
        if (this.hrF != null) {
            this.hrF.Kd().setMsgData(new LinkedList());
            this.hrF.zR();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void a(ax axVar) {
        if (this.hrF != null) {
            cbg();
            this.hrF.Ke().setEditText(" @" + axVar.getNameShow() + " ");
        }
        if (this.otv != null) {
            this.otv.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hrF != null) {
            cbg();
            this.hrF.Ke().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.otv != null) {
            this.otv.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void b(ax axVar) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected View caK() {
        if (this.hrF != null) {
            return this.hrF.Ke().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public boolean caL() {
        if (this.hrF == null || !this.hrF.Ke().LY()) {
            return false;
        }
        nN(false);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    /* renamed from: cct */
    public PendantParentView caN() {
        return this.byA;
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
                    this.hst = false;
                    a(null, intExtra, intExtra2, intExtra3);
                    return;
                }
                caD();
                return;
            }
            awo();
        } else if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            HV(P(intent));
        }
    }

    private void HV(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) eaN().pageContext.getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.otQ != null) {
            this.otQ.HI(fromJson.getBigurl());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            if (!this.otJ) {
                if (this.hrF != null && this.hrF.Ke() != null) {
                    this.hrF.Ke().LX();
                    return;
                }
                return;
            }
        } else {
            this.otJ = false;
        }
        if (this.hrF != null && this.hrF.Kd() != null) {
            this.hrF.Kd().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hrF == null || this.hrF.Ke() == null || !this.hrF.Ke().LY()) {
            if (z) {
                if (this.otv != null) {
                    this.otv.setVisibility(8);
                }
                if (this.hrH != null && this.hrH.EJ() != null) {
                    this.hrH.EJ().setVisibility(8);
                }
                caP();
                if (this.hrF != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hrF.Ke().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hrF.Ke().getView().setLayoutParams(layoutParams);
                    this.hrF.Ke().getView().setVisibility(0);
                    this.hrF.Ke().setQuickInputPanelVisible(false);
                }
                if (this.hso != null) {
                    this.hso.setVisibility(8);
                }
                if (this.hrG != null) {
                    this.hrG.zQ();
                }
                if (this.otO != null) {
                    this.otO.setVisible(8);
                }
                if (this.hsh != null) {
                    this.hsh.setCanVisible(false);
                }
            } else {
                caO();
            }
            cci();
            if (this.hrT != null) {
                this.hrT.bC(z);
            }
        }
    }

    private void caO() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.otv != null) {
            this.otv.setVisibility(0);
        }
        if (this.hqH != null && (layoutParams = (RelativeLayout.LayoutParams) this.hqH.getLayoutParams()) != null) {
            layoutParams.bottomMargin = eaN().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds120);
            this.hqH.setLayoutParams(layoutParams);
        }
        if (this.hrF != null) {
            cbj();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrF.Ke().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hrF.Ke().getView().setLayoutParams(layoutParams2);
        }
        if (this.otv != null) {
            this.otv.setVisibility(0);
        }
        if (this.hrH != null && this.hrH.EJ() != null) {
            this.hrH.EJ().setVisibility(0);
        }
        if (this.hso != null) {
            this.hso.setVisibility(0);
        }
        if (this.otO != null) {
            this.otO.setVisible(0);
        }
        if (this.hrG != null) {
            this.hrG.zQ();
        }
        if (this.hsh != null) {
            this.hsh.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caP() {
        boolean z;
        boolean z2;
        if (this.hqH != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqH.getLayoutParams();
            if (this.hrF == null || this.hrF.Ke() == null) {
                z = false;
                z2 = false;
            } else {
                boolean LW = this.hrF.Ke().LW();
                z = this.hrF.Ke().LX();
                z2 = LW;
            }
            int O = O(z2, z);
            if (layoutParams.bottomMargin != O) {
                layoutParams.bottomMargin = O;
                this.hqH.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(boolean z) {
        this.htB = z;
        if (z) {
            this.hrF.Ke().setQuickInputPanelVisible(true);
            return;
        }
        caO();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3 && this.otP != null) {
            this.otP.cr(i3);
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public boolean dF(int i) {
        return super.dF(i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void vo(int i) {
        super.vo(i);
        if (i == 11) {
            if (this.otv != null) {
                this.otv.setVisibility(8);
            }
            if (this.hrF != null) {
                this.hrF.Kd().getView().setVisibility(4);
            }
            if (this.otO != null) {
                this.otO.bN(2, 8);
            }
            if (this.otC != null) {
                this.otC.oM(false);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public void dG(int i) {
        super.dG(i);
        if (i == 11) {
            if (this.otv != null) {
                this.otv.setVisibility(0);
            }
            if (this.hrF != null) {
                this.hrF.Kd().getView().setVisibility(0);
            }
            if (this.otO != null) {
                this.otO.setVisible(0);
            }
            if (this.otC != null) {
                this.otC.oM(true);
            }
            this.hso.setVisibility(0);
        }
    }

    private void caq() {
        if (this.otv != null) {
            this.otv.a(new a.InterfaceC0933a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.otO != null) {
            this.otO.onStop();
        }
        if (this.otT != null) {
            this.otT.ckt();
        }
        if (this.otU != null) {
            this.otU.ckt();
        }
        if (this.otV != null) {
            this.otV.ckt();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.edo().onDestroy();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.otO != null) {
            this.otO.onStart();
        }
        if (this.otT != null) {
            this.otT.cks();
        }
        if (this.otU != null) {
            this.otU.cks();
        }
        if (this.otV != null) {
            this.otV.cks();
        }
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c cVar) {
        ViewGroup edO = q.edM().edO();
        if (edO != null && (edO instanceof TeamFightLayout)) {
            ((TeamFightLayout) edO).b(cVar);
        }
    }
}
