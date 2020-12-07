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
import com.baidu.live.data.ar;
import com.baidu.live.data.bo;
import com.baidu.live.data.cf;
import com.baidu.live.data.cl;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.operation.a;
import com.baidu.tieba.yuyinala.liveroom.recommend.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends a {
    private PendantParentView buZ;
    private com.baidu.live.ao.a gTR;
    private FrameLayout heX;
    private LinearLayout hhE;
    private com.baidu.tieba.yuyinala.liveroom.activeview.b olh;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.c oli;
    private com.baidu.tieba.yuyinala.liveroom.h.b olj;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.b olk;
    private g oll;
    private com.baidu.tieba.yuyinala.liveroom.ranklist.a olm;
    private com.baidu.tieba.yuyinala.liveroom.introduce.g oln;
    private com.baidu.tieba.yuyinala.liveroom.charmrank.a olo;
    private com.baidu.tieba.yuyinala.liveroom.j.a olp;
    private com.baidu.tieba.yuyinala.liveroom.datingnavigation.a olq;
    private long lastClickTime = 0;
    private com.baidu.live.liveroom.g.c hfl = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.1
        @Override // com.baidu.live.liveroom.g.c
        public void PL() {
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cA(boolean z) {
            if (z) {
                if (c.this.okQ != null) {
                    c.this.okQ.NB(8);
                }
            } else if (c.this.okQ != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                    c.this.okQ.NB(0);
                } else {
                    c.this.okQ.NB(8);
                }
            }
            if (c.this.hgi != null) {
                c.this.hgi.bE(z);
            }
        }
    };
    private CustomMessageListener olr = new CustomMessageListener(2501032) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501032) {
                long currentTimeMillis = System.currentTimeMillis();
                if (c.this.eda().olT.Iq() != null && c.this.eda().olT.Iq().mLiveInfo != null) {
                    c.this.eda().olT.a(c.this.eda().olT.Iq().mLiveInfo.live_id, c.this.eda().fromType, c.this.eda().enterTime, currentTimeMillis);
                }
            }
        }
    };
    private HttpMessageListener hfn = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.PU() != null) {
                        e.RP().bxB = getQuickGiftHttpResponseMessage.PU();
                        c.this.caA();
                    }
                }
            }
        }
    };
    CustomMessageListener hft = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2913168) {
            }
        }
    };
    private CustomMessageListener hfq = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (c.this.ola != null) {
                    c.this.ola.ir(str);
                }
            }
        }
    };
    private CustomMessageListener hfs = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (c.this.okX != null) {
                    c.this.okX.dismiss();
                }
                if (c.this.ola != null) {
                    c.this.ola.dismiss();
                }
                d.NK().setSwitchStatus(true);
                d.NK().setSelectId((String) customResponsedMessage.getData());
                if (c.this.mHandler == null) {
                    c.this.mHandler = new Handler();
                }
                c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.cbp();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.yuyinala.liveroom.operation.b ols = new com.baidu.tieba.yuyinala.liveroom.operation.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5
        @Override // com.baidu.tieba.yuyinala.liveroom.operation.b
        public void a(View view, int i, String[] strArr) {
            bo boVar;
            cf cfVar;
            cl clVar;
            String str;
            bo boVar2;
            cf cfVar2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c.this.lastClickTime >= 300) {
                c.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    c.this.edk();
                    c.this.a(strArr, -1, -1, -1);
                } else if (i == 1) {
                    if (c.this.hfU != null) {
                        c.this.cbp();
                    }
                } else if (i == 3) {
                    c.this.okR.c(c.this.eda().olT.Iq(), false);
                } else if (i == 8) {
                    if (c.this.brc != null) {
                        c.this.brc.cu(false);
                    }
                    c.this.edm();
                } else if (i != 12) {
                    if (i == 14) {
                        c.this.edl();
                        w Iq = c.this.eda().olT.Iq();
                        if (Iq != null && Iq.aJV != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmCardActivityConfig(c.this.eda().pageContext.getPageActivity(), Iq.aJV.userName, Long.toString(Iq.aJV.userId), Long.toString(Iq.aJV.charmCount), String.valueOf(Iq.mLiveInfo.group_id), String.valueOf(Iq.mLiveInfo.live_id), false, String.valueOf(Iq.aJV.userId), Long.toString(Iq.aKr.userId), Iq.aKr.userName, Iq.aKr.portrait, 0L, c.this.Oj(), Iq.aKT)));
                        }
                    } else if (i == 11) {
                        c.this.cbt();
                        c.this.cbu();
                    } else if (i == 16) {
                        if (c.this.eda() != null && (boVar2 = com.baidu.live.ae.a.RB().bxq) != null && (cfVar2 = boVar2.aQM) != null) {
                            String str3 = cfVar2.aSj.aSr;
                            if (!TextUtils.isEmpty(str3)) {
                                long j = 0;
                                if (c.this.eda().olT != null && c.this.eda().olT.Iq() != null && c.this.eda().olT.Iq().mLiveInfo != null) {
                                    j = c.this.eda().olT.Iq().mLiveInfo.live_id;
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", c.this.eda().olT.Iq().mLiveInfo.room_id + "", c.this.eda().olT.Iq().mLiveInfo.feed_id, c.this.Oj());
                                }
                                if (str3.contains("?")) {
                                    str2 = str3 + "&liveId=" + j;
                                } else {
                                    str2 = str3 + "?liveId=" + j;
                                }
                                if (c.this.gTR == null) {
                                    c.this.gTR = new com.baidu.live.ao.a(c.this.eda().pageContext.getPageActivity());
                                }
                                com.baidu.live.ao.c cVar = new com.baidu.live.ao.c();
                                cVar.url = str2;
                                c.this.gTR.a(cVar);
                            }
                        }
                    } else if (i == 20) {
                        if (c.this.eda() != null) {
                            w wVar = null;
                            if (c.this.eda().olT != null) {
                                wVar = c.this.eda().olT.Iq();
                            }
                            if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.yuyinala.liveroom.n.b.edW().brJ != null) {
                                String str4 = com.baidu.tieba.yuyinala.liveroom.n.b.edW().brJ.aLI;
                                if (!TextUtils.isEmpty(str4)) {
                                    if (str4.contains("?")) {
                                        str = str4 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    } else {
                                        str = str4 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    }
                                    if (c.this.gTR == null) {
                                        c.this.gTR = new com.baidu.live.ao.a(c.this.eda().pageContext.getPageActivity());
                                    }
                                    com.baidu.live.ao.c cVar2 = new com.baidu.live.ao.c();
                                    cVar2.url = str;
                                    c.this.gTR.a(cVar2);
                                }
                            }
                        }
                    } else if (i == 17) {
                        if (c.this.Le() && c.this.eda() != null && (boVar = com.baidu.live.ae.a.RB().bxq) != null && (cfVar = boVar.aQM) != null && (clVar = cfVar.aSk) != null && !TextUtils.isEmpty(clVar.webUrl) && c.this.okX != null && c.this.eda().olT != null && c.this.eda().olT.Iq() != null && c.this.eda().olT.Iq().aJV != null) {
                            w Iq2 = c.this.eda().olT.Iq();
                            c.this.okX.a(clVar.webUrl, Iq2.mLiveInfo.live_id, Iq2.aKr.userId, Iq2.aJV.userId);
                        }
                    } else if (i == 22) {
                        c.this.olp.ad(c.this.eda().olT.Iq());
                        c.this.edj();
                    } else if (i == 23 && c.this.Le()) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ag(BdBaseApplication.getInst(), String.valueOf(c.this.eda().olT.cjK().live_id), String.valueOf(c.this.eda().olT.cjK().group_id))));
                            c.this.edi();
                        } catch (Exception e) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(c.this.eda().pageContext.getPageActivity(), "请稍后重试", 1).show();
                                }
                            });
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.operation.b
        public void a(int i, com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
            if (i == 21 && c.this.Le()) {
                if (c.this.oll == null) {
                    c.this.oll = new g(c.this.eda().pageContext);
                }
                c.this.oll.b(eVar);
            }
        }
    };
    private boolean hhJ = false;

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
    }

    public void a(w wVar, String str, String str2) {
        this.hhJ = false;
        eda().olU.setIsForceHandledTouch(false);
        eda().olU.setSwipeClearEnable(false);
        eda().olU.setOnLiveViewScrollListener(this.hfl);
        if (this.hgE != null) {
            this.hgE.setVisibility(0);
        }
        ccq();
        caE();
        caG();
        caL();
        edh();
        edf();
        ede();
        cbC();
        W(wVar);
        o.efd().l(wVar);
        cas();
        if (wVar != null && wVar.aKL != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aO(wVar.aKL.aUg, str2, str);
        }
    }

    private void W(w wVar) {
        if (this.oli == null) {
            this.oli = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(eda().pageContext, this);
        }
        if (wVar != null && wVar.aKL != null) {
            this.oli.Wo(wVar.aKL.live_id);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        super.l(wVar);
        this.hhJ = false;
        eda().olU.setIsForceHandledTouch(false);
        eda().olU.setSwipeClearEnable(false);
        eda().olU.setOnLiveViewScrollListener(this.hfl);
        if (this.hgE != null) {
            this.hgE.setVisibility(0);
        }
        ccq();
        caE();
        caF();
        caJ();
        caG();
        caL();
        edh();
        edf();
        edd();
        ede();
        nj(false);
        cbx();
        cbw();
        cbC();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().ag(wVar);
        o.efd().l(wVar);
        caB();
        cby();
        cbO();
        cau();
        caA();
        cbK();
        cam();
        cbN();
        c(this.giQ);
        cax();
        MessageManager.getInstance().registerListener(this.olr);
        MessageManager.getInstance().registerListener(this.hfn);
        MessageManager.getInstance().registerListener(this.hfs);
        MessageManager.getInstance().registerListener(this.hft);
        MessageManager.getInstance().registerListener(this.hfq);
        caP();
        caI();
        cas();
        edc();
    }

    private void edc() {
        o.efd().a(new o.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.8
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
            public void Ns(int i) {
                c.this.ccl();
                c.this.ccm();
            }
        });
    }

    private void edd() {
        if (eda().olT.Iq() != null && eda().olT.Iq().aJV != null && eda().olT.Iq().mLiveInfo != null) {
            w Iq = eda().olT.Iq();
            if (Iq.aKQ != null && Iq.aKQ.getRoomMode() == 1) {
                if (this.olq == null) {
                    this.olq = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(eda().pageContext);
                }
                this.olq.Z(eda().olT.Iq());
                this.olq.at(this.hgE);
            }
        }
    }

    private void ede() {
        if (eda().olT.Iq() != null && eda().olT.Iq().aJV != null && eda().olT.Iq().mLiveInfo != null && this.olp == null) {
            this.olp = new com.baidu.tieba.yuyinala.liveroom.j.a(eda().pageContext);
        }
    }

    private void edf() {
        if (eda().olT.Iq() != null && eda().olT.Iq().aJV != null && eda().olT.Iq().mLiveInfo != null) {
            if (this.olo == null) {
                this.olo = new com.baidu.tieba.yuyinala.liveroom.charmrank.a(eda().pageContext);
            }
            long j = eda().olT.Iq().aJV.userId;
            int i = eda().olT.Iq().mLiveInfo.live_type;
            String str = eda().olT.Iq().aJV.portrait;
            String str2 = eda().olT.Iq().mLiveInfo.feed_id;
            long j2 = eda().olT.Iq().mLiveInfo.live_id;
            this.olo.a(i, j, eda().olT.Iq().aJV.userName, false, str, Oj(), str2, j2);
            this.olo.at(this.hgE);
            this.olo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    w Iq = c.this.eda().olT.Iq();
                    if (Iq != null && Iq.aJV != null) {
                        c.this.edg();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmRankActivityConfig(c.this.eda().pageContext.getPageActivity(), Iq.aJV.userName, Long.toString(Iq.aJV.userId), Long.toString(Iq.aJV.charmCount), String.valueOf(Iq.aKL.croom_id), String.valueOf(Iq.mLiveInfo.live_id), false, String.valueOf(Iq.aJV.userId), Long.toString(Iq.aKr.userId), Iq.aKr.userName, Iq.aKr.portrait, 0L, Iq.aKr.userType)));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edg() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = eda().olT.Iq();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Iq.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "charmlist_clk").setContentExt(jSONObject));
    }

    private void edh() {
        if (eda().olT.Iq() != null && eda().olT.Iq().aJV != null && eda().olT.Iq().mLiveInfo != null) {
            if (this.oln == null) {
                this.oln = new com.baidu.tieba.yuyinala.liveroom.introduce.g(eda().pageContext);
            }
            this.oln.Z(eda().olT.Iq());
            this.oln.at(this.hgE);
            this.oln.cGw();
        }
    }

    public void caL() {
        if (eda().olT.Iq() != null && eda().olT.Iq().mLiveInfo != null && eda().olT.Iq().aKL != null && eda().olT.Iq().aKR) {
            if (this.olm == null) {
                this.olm = new com.baidu.tieba.yuyinala.liveroom.ranklist.a(eda().pageContext);
            }
            String str = eda().olT.Iq().aKr.userUk;
            int i = eda().olT.Iq().mLiveInfo.live_type;
            String str2 = eda().olT.Iq().aKL.cover;
            String str3 = eda().olT.Iq().mLiveInfo.feed_id;
            long j = eda().olT.Iq().mLiveInfo.live_id;
            this.olm.a(i, str, eda().olT.Iq().aJV.userName, false, str2, Oj(), str3, j, eda().olT.Iq().aKL.croom_id, eda().olT.Iq().aKL.aUl, eda().olT.Iq().aKL.aUg, eda().olT.Iq().aKL.cover, eda().olT.Iq().aKL.room_name);
            this.olm.at(this.hgE);
            this.olm.cGw();
        }
    }

    private void cam() {
        if (this.olc != null) {
            this.olc.a(new a.InterfaceC0932a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.10
                @Override // com.baidu.tieba.yuyinala.liveroom.recommend.a.InterfaceC0932a
                public void cH(boolean z) {
                }
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        super.j(wVar);
        if (this.olj != null) {
            this.olj.M(wVar);
        }
        X(wVar);
        if (this.olm != null && wVar != null && wVar.aKL != null) {
            this.olm.NF(wVar.aKL.aUl);
        }
        if (this.olh != null) {
            this.olh.i(wVar);
            this.olh.nc(this.hgO);
            this.olh.updateView();
            if (wVar != null && this.hgw != null && !this.hgw.hasInit && !TextUtils.isEmpty(this.hgw.aRg)) {
                this.hgw.hasInit = true;
                this.olh.Id(this.hgw.aRg);
            }
        }
    }

    private void X(w wVar) {
        if (wVar != null && wVar.aKQ != null && wVar.aKQ.getRoomMode() == 1) {
            if (this.olq != null) {
                this.olq.j(wVar);
            } else if (o.efd().efr()) {
                this.olq = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(eda().pageContext);
                this.olq.Z(wVar);
                this.olq.cR(this.hgE);
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.olq != null) {
                            c.this.olq.edp();
                        }
                    }
                }, 1500L);
            } else {
                this.olq = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(eda().pageContext);
                this.olq.Z(wVar);
                this.olq.cR(this.hgE);
                this.olq.edp();
            }
        } else if (o.efd().efr()) {
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.12
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.olq != null) {
                        c.this.olq.onDestroy();
                        c.this.olq = null;
                    }
                }
            }, 1500L);
        } else if (this.olq != null) {
            this.olq.onDestroy();
            this.olq = null;
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(q qVar) {
        if (qVar != null) {
            if (this.oli != null && qVar.getList() != null) {
                this.oli.e(qVar);
            }
            if (this.olk != null) {
                this.olk.eZ(qVar.getCount());
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void eb(int i) {
        super.eb(i);
    }

    private void cas() {
        if (eda() != null && eda().pageContext != null && eda().pageContext.getPageActivity() != null) {
            if (this.buZ == null) {
                this.buZ = new PendantParentView(eda().pageContext.getPageActivity(), PendantParentView.Model.VERTICAL);
                eda().olU.addView(this.buZ, new ViewGroup.LayoutParams(-1, -1));
                this.buZ.setDefaultItemMargin(eda().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
                this.buZ.setPadding(eda().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, eda().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            }
            ccl();
        }
    }

    private void cau() {
        if (this.olh == null) {
            this.olh = new com.baidu.tieba.yuyinala.liveroom.activeview.b(eda().pageContext);
        }
        if (eda() != null && eda().olT != null) {
            this.olh.Ia(eda().olT.cjO());
        }
        this.olh.setOtherParams(Oj());
        this.olh.b(eda().olT.Iq(), false);
        this.olh.setHost(false);
        this.olh.nc(this.hgO);
        this.olh.a(1, this.buZ);
        this.olh.a(2, this.buZ);
        this.olh.setVisible(this.hgI ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccl() {
        if (this.buZ != null) {
            this.buZ.setModel(eda().olT.Iq().aKQ.getRoomMode() == 1 ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            this.buZ.setPosition(eda().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds164), 0, eda().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200), eda().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102));
            return;
        }
        cas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccm() {
        if (this.hfU != null && this.heX != null && this.hfU.Nd() != null && this.hfU.Nd().getView() != null) {
            int J = com.baidu.tieba.yuyinala.liveroom.o.a.J(this.hgI, eda().olT.Iq().aKQ.getRoomMode());
            if (this.hgF.indexOfChild(this.heX) != -1 && this.heX.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heX.getLayoutParams();
                layoutParams.height = J;
                this.heX.setLayoutParams(layoutParams);
            }
            if (this.heX.indexOfChild(this.hfU.Nd().getView()) != -1 && this.hfU.Nd().getView().getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hfU.Nd().getView().getLayoutParams();
                layoutParams2.height = J;
                this.hfU.Nd().getView().setLayoutParams(layoutParams2);
            }
            this.hfU.Nd().Nc();
        }
    }

    private void ccq() {
        if (this.hhE == null) {
            this.hhE = new LinearLayout(eda().pageContext.getPageActivity());
            this.hhE.setOrientation(1);
        }
        if (this.hhE.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = eda().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = eda().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            eda().olU.addView(this.hhE, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caA() {
        if (this.okQ == null) {
            caG();
        }
        this.okQ.setOtherParams(Oj());
        this.okQ.a(e.RP().bxB, eda().olT.Iq());
    }

    private void cbC() {
        if (this.okW != null && eda() != null && eda().olT != null) {
            this.okW.d(this.hgE, eda().olT.Iq());
        }
    }

    private void caB() {
        CustomResponsedMessage runTask;
        if (this.hfU == null && (runTask = MessageManager.getInstance().runTask(2501045, k.class, eda().pageContext)) != null && runTask.getData() != null) {
            this.hfU = (k) runTask.getData();
            this.hfU.setFromMaster(false);
            this.hfU.Nd().getView().setId(a.f.ala_liveroom_msg_list);
            this.hfU.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4
                @Override // com.baidu.live.im.k.a
                public boolean Nh() {
                    return c.this.Le();
                }

                @Override // com.baidu.live.im.k.a
                public void Ni() {
                    c.this.hgM = true;
                }

                @Override // com.baidu.live.im.k.a
                public void id(String str) {
                    if (!c.this.hgI) {
                        c.this.ng(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(c.this.eda().pageContext.getPageActivity(), c.this.eda().hpQ.getLiveContainerView());
                    }
                    c.this.Ih(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Nj() {
                    if (c.this.hgI) {
                        c.this.ng(true);
                        c.this.eda().hpQ.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.eda().pageContext.getPageActivity(), c.this.eda().hpQ.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.hfU != null) {
                        c.this.hfU.Ne().setQuickInputPanelVisible(false);
                        c.this.hfU.Ne().OR();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Nk() {
                    if (c.this.hgI) {
                        c.this.caW();
                        if (c.this.hfV != null) {
                            c.this.hfV.DM();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Nl() {
                    return c.this.cbj();
                }

                @Override // com.baidu.live.im.k.a
                public int Nm() {
                    return c.this.cbk();
                }
            });
            this.heX = new FrameLayout(eda().pageContext.getPageActivity());
            this.heX.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hfU != null && this.heX != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(eda().pageContext.getPageActivity()) * 0.7f);
            int J = com.baidu.tieba.yuyinala.liveroom.o.a.J(false, eda().olT.Iq().aKQ.getRoomMode());
            if (this.hgF.indexOfChild(this.heX) < 0) {
                if (this.heX.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.heX.getParent()).removeView(this.heX);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, J);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.tieba.yuyinala.liveroom.o.a.dk(false);
                this.hgF.addView(this.heX, layoutParams);
            }
            if (this.heX.indexOfChild(this.hfU.Nd().getView()) < 0) {
                if (this.hfU.Nd().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hfU.Nd().getView()).removeView(this.hfU.Nd().getView());
                }
                this.heX.addView(this.hfU.Nd().getView(), new FrameLayout.LayoutParams(equipmentWidth, J));
            }
            if (eda().olU.indexOfChild(this.hfU.Ne().getView()) < 0) {
                if (this.hfU.Ne().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hfU.Ne().getView().getParent()).removeView(this.hfU.Ne().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cbr();
                eda().olU.addView(this.hfU.Ne().getView(), layoutParams2);
            }
            w Iq = eda().olT.Iq();
            if (Iq != null && Iq.mLiveInfo != null) {
                this.hfU.setLogData(Iq.mLiveInfo.feed_id, Oj());
            }
            this.hfU.a(String.valueOf(eda().olT.Iq().mLiveInfo.group_id), String.valueOf(eda().olT.Iq().mLiveInfo.last_msg_id), String.valueOf(eda().olT.Iq().aJV.userId), String.valueOf(eda().olT.Iq().mLiveInfo.live_id), eda().olT.Iq().aJV.appId, (Iq == null || Iq.aKI == null || !Iq.aKI.Fb()) ? false : true, eda().olT.Iq().getGuardName());
            ng(false);
        }
    }

    private void caE() {
        if (this.olj == null) {
            this.olj = new com.baidu.tieba.yuyinala.liveroom.h.b(this.activity);
        }
        this.olj.e(this.hgE, eda().olT.Iq());
    }

    private void caF() {
        if (this.oli == null) {
            this.oli = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(eda().pageContext, this);
        }
        String.valueOf(eda().olT.Iq().mLiveInfo.group_id);
        String valueOf = String.valueOf(eda().olT.Iq().mLiveInfo.live_id);
        String.valueOf(eda().olT.Iq().aJV.userId);
        this.oli.a(valueOf, eda().olT.Iq());
        this.oli.c(this.hgE, a.f.ala_liveroom_hostheader, a.f.ala_liveroom_audience_count_layout);
        this.oli.e(eda().olT.bUt());
        this.oli.setOtherParams(Oj());
    }

    private void caG() {
        if (this.okQ == null) {
            this.okQ = new com.baidu.tieba.yuyinala.liveroom.operation.a(eda().pageContext);
        }
        this.okQ.a(eda(), this.hgF, eda().olT.Iq().mLiveInfo, true, this.ols);
        this.okQ.setOtherParams(Oj());
    }

    public void no(boolean z) {
        if (this.okQ != null) {
            this.okQ.no(z);
        }
    }

    private void caJ() {
        if (this.olk == null) {
            this.olk = new com.baidu.tieba.yuyinala.liveroom.audiencelist.b(eda().pageContext.getPageActivity());
        }
        long j = 1;
        if (eda().olT.bUt() != null) {
            j = eda().olT.bUt().getCount();
        }
        this.olk.a(this.ols);
        this.olk.a(this.hgE, a.f.ala_liveroom_audience, j);
        this.olk.setVisible(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edi() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = eda().olT.Iq();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Iq.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "msgbtn_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edj() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = eda().olT.Iq();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Iq.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "morefunc_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edk() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = eda().olT.Iq();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Iq.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "giftbtn_clk").setContentExt(jSONObject));
    }

    public void caK() {
        this.okR.c(eda().olT.Iq(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edl() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = eda().olT.Iq();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Iq.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "olnumber_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edm() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = eda().olT.Iq();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Iq.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "closebtn_clk").setContentExt(jSONObject));
    }

    private void caP() {
        if (this.hgM || this.hgN) {
            if ((TbadkCoreApplication.isLogin() && this.hfU.Ne().hasText()) || this.hgN) {
                this.hgM = false;
                this.hgN = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.cbp();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void caH() {
        caI();
    }

    private void caI() {
        if (this.okQ != null) {
            int i = eda().olT.Iq().aKr.isUegBlock;
            int i2 = eda().olT.Iq().aKr.isBlock;
            String str = eda().olT.Iq().aKr.userName;
            if (i > 0 || i2 > 0) {
                this.okQ.b(true, i, i2, str);
                this.hfU.a(true, i, i2, str);
                this.okV.b(true, i, i2, str);
                return;
            }
            this.okQ.b(false, i, i2, str);
            this.hfU.a(false, i, i2, str);
            this.okV.b(false, i, i2, str);
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
                    if (eda().olT.Iq() != null && eda().olT.Iq().mLiveInfo != null) {
                        eda().olT.a(eda().olT.Iq().mLiveInfo.live_id, eda().fromType, eda().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && eda().olT.Iq() != null && eda().olT.Iq().mLiveInfo != null && eda().olT.Iq().aKr != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == eda().olT.Iq().aKr.userId && optLong2 == eda().olT.Iq().mLiveInfo.live_id) {
                        jSONObject.optInt("challenge_status");
                        jSONObject.optLong("challenge_id");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void Ic(String str) {
        if (this.olh != null) {
            this.olh.Ic(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void cz(boolean z) {
        super.cz(z);
        if (eda().olU != null) {
            eda().olU.clk();
            eda().olU.setLiveViewOnDispatchTouchEventListener(null);
            eda().olU.setLiveViewOnTouchEventListener(null);
            eda().olU.setOnLiveViewScrollListener(null);
        }
        if (eda().brf != null) {
            eda().brf.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        caQ();
        if (this.okQ != null) {
            this.okQ.cjR();
        }
        if (this.olq != null) {
            this.olq.En();
        }
        if (this.buZ != null) {
            this.buZ.removeAllViews();
            this.buZ = null;
        }
        if (this.hhE != null) {
            this.hhE.removeAllViews();
            this.hhE = null;
        }
        if (this.olh != null) {
            this.olh.release();
        }
        if (this.olm != null) {
            this.olm.En();
        }
        if (this.oln != null) {
            this.oln.En();
        }
        if (this.olo != null) {
            this.olo.En();
        }
        o.efd().En();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cx(boolean z) {
        super.cx(z);
        caQ();
        if (this.olj != null) {
            this.olj.onDestroy();
        }
        if (this.oli != null) {
            this.oli.onDestroy();
        }
        if (this.hfU != null) {
            this.hfU.onDestroy();
        }
        if (this.okQ != null) {
            this.okQ.onDestory();
        }
        if (this.olh != null) {
            this.olh.release();
        }
        if (this.olm != null) {
            this.olm.onDestroy();
        }
        if (this.oln != null) {
            this.oln.onDestroy();
        }
        if (this.olo != null) {
            this.olo.onDestroy();
        }
        if (this.oll != null) {
            this.oll.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.olr);
        MessageManager.getInstance().unRegisterListener(this.hfn);
        MessageManager.getInstance().unRegisterListener(this.hfs);
        MessageManager.getInstance().unRegisterListener(this.hft);
        MessageManager.getInstance().unRegisterListener(this.hfq);
    }

    private void caQ() {
        if (this.hfU != null && this.hfU.Nd().getView() != null && this.hfU.Nd().getView().getParent() != null) {
            ((ViewGroup) this.hfU.Nd().getView().getParent()).removeView(this.hfU.Nd().getView());
        }
        if (this.heX != null && this.heX.getParent() != null) {
            ((ViewGroup) this.heX.getParent()).removeView(this.heX);
        }
        if (this.hfU != null && this.hfU.Ne().getView() != null) {
            this.hgF.removeView(this.hfU.Ne().getView());
        }
        if (this.hfU != null) {
            this.hfU.Nd().setMsgData(new LinkedList());
            this.hfU.DN();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void a(ar arVar) {
        if (this.hfU != null) {
            cbp();
            this.hfU.Ne().setEditText(" @" + arVar.getNameShow() + " ");
        }
        if (this.okQ != null) {
            this.okQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hfU != null) {
            cbp();
            this.hfU.Ne().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.okQ != null) {
            this.okQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void b(ar arVar) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected View caR() {
        if (this.hfU != null) {
            return this.hfU.Ne().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public boolean caS() {
        if (this.hfU == null || !this.hfU.Ne().OQ()) {
            return false;
        }
        ng(false);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    /* renamed from: ccs */
    public PendantParentView caU() {
        return this.buZ;
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
                    this.hgJ = false;
                    a(null, intExtra, intExtra2, intExtra3);
                    return;
                }
                caK();
                return;
            }
            ays();
        } else if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            IA(O(intent));
        }
    }

    private void IA(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) eda().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String O(Intent intent) {
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

    private void P(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.olj != null) {
            this.olj.In(fromJson.getSmallurl());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.hfU != null && this.hfU.Nd() != null) {
            this.hfU.Nd().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hfU == null || this.hfU.Ne() == null || !this.hfU.Ne().OQ()) {
            if (z) {
                if (this.okQ != null) {
                    this.okQ.setVisibility(8);
                }
                if (this.hfW != null && this.hfW.HN() != null) {
                    this.hfW.HN().setVisibility(8);
                }
                caW();
                if (this.hfU != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfU.Ne().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hfU.Ne().getView().setLayoutParams(layoutParams);
                    this.hfU.Ne().getView().setVisibility(0);
                    this.hfU.Ne().setQuickInputPanelVisible(false);
                }
                if (this.hgE != null) {
                    this.hgE.setVisibility(8);
                }
                if (this.hfV != null) {
                    this.hfV.DM();
                }
                if (this.olh != null) {
                    this.olh.setVisible(8);
                }
                if (this.hgx != null) {
                    this.hgx.setCanVisible(false);
                }
            } else {
                caV();
            }
            ccm();
            if (this.hgi != null) {
                this.hgi.bD(z);
            }
        }
    }

    private void caV() {
        if (this.okQ != null) {
            this.okQ.setVisibility(0);
        }
        if (this.heX != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heX.getLayoutParams();
            layoutParams.bottomMargin = eda().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds120);
            this.heX.setLayoutParams(layoutParams);
        }
        if (this.hfU != null) {
            cbr();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hfU.Ne().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hfU.Ne().getView().setLayoutParams(layoutParams2);
        }
        if (this.okQ != null) {
            this.okQ.setVisibility(0);
        }
        if (this.hfW != null && this.hfW.HN() != null) {
            this.hfW.HN().setVisibility(0);
        }
        if (this.hgE != null) {
            this.hgE.setVisibility(0);
        }
        if (this.olh != null) {
            this.olh.setVisible(0);
        }
        if (this.hfV != null) {
            this.hfV.DM();
        }
        if (this.hgx != null) {
            this.hgx.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caW() {
        boolean z;
        boolean z2 = false;
        if (this.heX != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heX.getLayoutParams();
            if (this.hfU == null || this.hfU.Ne() == null) {
                z = false;
            } else {
                z = this.hfU.Ne().OO();
                z2 = this.hfU.Ne().OP();
            }
            int M = M(z, z2);
            if (layoutParams.bottomMargin != M) {
                layoutParams.bottomMargin = M;
                this.heX.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng(boolean z) {
        this.hhJ = z;
        if (z) {
            this.hfU.Ne().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heX.getLayoutParams();
            int quickInputPanelExpandHeight = this.hfU.Ne().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.heX.setLayoutParams(layoutParams);
                if (this.hfU.Nd() != null) {
                    this.hfU.Nd().Nc();
                    return;
                }
                return;
            }
            return;
        }
        caV();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3 && this.oli != null) {
            this.oli.dX(i3);
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public boolean fh(int i) {
        return super.fh(i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void wy(int i) {
        super.wy(i);
        if (i == 7 || i == 11) {
            if (this.okQ != null) {
                this.okQ.setVisibility(8);
            }
            if (this.hfU != null) {
                this.hfU.Nd().getView().setVisibility(4);
            }
            if (this.olh != null) {
                this.olh.bQ(2, 8);
            }
            if (this.okY != null) {
                this.okY.oh(false);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public void fi(int i) {
        super.fi(i);
        if (i == 7 || i == 11) {
            if (this.okQ != null) {
                this.okQ.setVisibility(0);
            }
            if (this.hfU != null) {
                this.hfU.Nd().getView().setVisibility(0);
            }
            if (this.olh != null) {
                this.olh.setVisible(0);
            }
            if (this.okY != null) {
                this.okY.oh(true);
            }
            this.hgE.setVisibility(0);
        }
    }

    private void cax() {
        if (this.okQ != null) {
            this.okQ.a(new a.InterfaceC0931a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.olh != null) {
            this.olh.onStop();
        }
        if (this.olm != null) {
            this.olm.ckp();
        }
        if (this.oln != null) {
            this.oln.ckp();
        }
        if (this.olo != null) {
            this.olo.ckp();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeL().onDestroy();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.olh != null) {
            this.olh.onStart();
        }
        if (this.olm != null) {
            this.olm.cko();
        }
        if (this.oln != null) {
            this.oln.cko();
        }
        if (this.olo != null) {
            this.olo.cko();
        }
    }
}
