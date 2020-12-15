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
    private com.baidu.live.ao.a gTT;
    private FrameLayout heZ;
    private LinearLayout hhG;
    private com.baidu.tieba.yuyinala.liveroom.activeview.b olj;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.c olk;
    private com.baidu.tieba.yuyinala.liveroom.h.b oll;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.b olm;
    private g oln;
    private com.baidu.tieba.yuyinala.liveroom.ranklist.a olo;
    private com.baidu.tieba.yuyinala.liveroom.introduce.g olp;
    private com.baidu.tieba.yuyinala.liveroom.charmrank.a olq;
    private com.baidu.tieba.yuyinala.liveroom.j.a olr;
    private com.baidu.tieba.yuyinala.liveroom.datingnavigation.a ols;
    private long lastClickTime = 0;
    private com.baidu.live.liveroom.g.c hfn = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.1
        @Override // com.baidu.live.liveroom.g.c
        public void PL() {
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cA(boolean z) {
            if (z) {
                if (c.this.okS != null) {
                    c.this.okS.NB(8);
                }
            } else if (c.this.okS != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                    c.this.okS.NB(0);
                } else {
                    c.this.okS.NB(8);
                }
            }
            if (c.this.hgk != null) {
                c.this.hgk.bE(z);
            }
        }
    };
    private CustomMessageListener olt = new CustomMessageListener(2501032) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501032) {
                long currentTimeMillis = System.currentTimeMillis();
                if (c.this.edb().olV.Iq() != null && c.this.edb().olV.Iq().mLiveInfo != null) {
                    c.this.edb().olV.a(c.this.edb().olV.Iq().mLiveInfo.live_id, c.this.edb().fromType, c.this.edb().enterTime, currentTimeMillis);
                }
            }
        }
    };
    private HttpMessageListener hfp = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.PU() != null) {
                        e.RP().bxB = getQuickGiftHttpResponseMessage.PU();
                        c.this.caB();
                    }
                }
            }
        }
    };
    CustomMessageListener hfv = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2913168) {
            }
        }
    };
    private CustomMessageListener hfs = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (c.this.olc != null) {
                    c.this.olc.ir(str);
                }
            }
        }
    };
    private CustomMessageListener hfu = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (c.this.okZ != null) {
                    c.this.okZ.dismiss();
                }
                if (c.this.olc != null) {
                    c.this.olc.dismiss();
                }
                d.NK().setSwitchStatus(true);
                d.NK().setSelectId((String) customResponsedMessage.getData());
                if (c.this.mHandler == null) {
                    c.this.mHandler = new Handler();
                }
                c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.cbq();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.yuyinala.liveroom.operation.b olu = new com.baidu.tieba.yuyinala.liveroom.operation.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5
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
                    c.this.edl();
                    c.this.a(strArr, -1, -1, -1);
                } else if (i == 1) {
                    if (c.this.hfW != null) {
                        c.this.cbq();
                    }
                } else if (i == 3) {
                    c.this.okT.c(c.this.edb().olV.Iq(), false);
                } else if (i == 8) {
                    if (c.this.brc != null) {
                        c.this.brc.cu(false);
                    }
                    c.this.edn();
                } else if (i != 12) {
                    if (i == 14) {
                        c.this.edm();
                        w Iq = c.this.edb().olV.Iq();
                        if (Iq != null && Iq.aJV != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmCardActivityConfig(c.this.edb().pageContext.getPageActivity(), Iq.aJV.userName, Long.toString(Iq.aJV.userId), Long.toString(Iq.aJV.charmCount), String.valueOf(Iq.mLiveInfo.group_id), String.valueOf(Iq.mLiveInfo.live_id), false, String.valueOf(Iq.aJV.userId), Long.toString(Iq.aKr.userId), Iq.aKr.userName, Iq.aKr.portrait, 0L, c.this.Oj(), Iq.aKT)));
                        }
                    } else if (i == 11) {
                        c.this.cbu();
                        c.this.cbv();
                    } else if (i == 16) {
                        if (c.this.edb() != null && (boVar2 = com.baidu.live.ae.a.RB().bxq) != null && (cfVar2 = boVar2.aQM) != null) {
                            String str3 = cfVar2.aSj.aSr;
                            if (!TextUtils.isEmpty(str3)) {
                                long j = 0;
                                if (c.this.edb().olV != null && c.this.edb().olV.Iq() != null && c.this.edb().olV.Iq().mLiveInfo != null) {
                                    j = c.this.edb().olV.Iq().mLiveInfo.live_id;
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", c.this.edb().olV.Iq().mLiveInfo.room_id + "", c.this.edb().olV.Iq().mLiveInfo.feed_id, c.this.Oj());
                                }
                                if (str3.contains("?")) {
                                    str2 = str3 + "&liveId=" + j;
                                } else {
                                    str2 = str3 + "?liveId=" + j;
                                }
                                if (c.this.gTT == null) {
                                    c.this.gTT = new com.baidu.live.ao.a(c.this.edb().pageContext.getPageActivity());
                                }
                                com.baidu.live.ao.c cVar = new com.baidu.live.ao.c();
                                cVar.url = str2;
                                c.this.gTT.a(cVar);
                            }
                        }
                    } else if (i == 20) {
                        if (c.this.edb() != null) {
                            w wVar = null;
                            if (c.this.edb().olV != null) {
                                wVar = c.this.edb().olV.Iq();
                            }
                            if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.yuyinala.liveroom.n.b.edX().brJ != null) {
                                String str4 = com.baidu.tieba.yuyinala.liveroom.n.b.edX().brJ.aLI;
                                if (!TextUtils.isEmpty(str4)) {
                                    if (str4.contains("?")) {
                                        str = str4 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    } else {
                                        str = str4 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    }
                                    if (c.this.gTT == null) {
                                        c.this.gTT = new com.baidu.live.ao.a(c.this.edb().pageContext.getPageActivity());
                                    }
                                    com.baidu.live.ao.c cVar2 = new com.baidu.live.ao.c();
                                    cVar2.url = str;
                                    c.this.gTT.a(cVar2);
                                }
                            }
                        }
                    } else if (i == 17) {
                        if (c.this.Le() && c.this.edb() != null && (boVar = com.baidu.live.ae.a.RB().bxq) != null && (cfVar = boVar.aQM) != null && (clVar = cfVar.aSk) != null && !TextUtils.isEmpty(clVar.webUrl) && c.this.okZ != null && c.this.edb().olV != null && c.this.edb().olV.Iq() != null && c.this.edb().olV.Iq().aJV != null) {
                            w Iq2 = c.this.edb().olV.Iq();
                            c.this.okZ.a(clVar.webUrl, Iq2.mLiveInfo.live_id, Iq2.aKr.userId, Iq2.aJV.userId);
                        }
                    } else if (i == 22) {
                        c.this.olr.ad(c.this.edb().olV.Iq());
                        c.this.edk();
                    } else if (i == 23 && c.this.Le()) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ag(BdBaseApplication.getInst(), String.valueOf(c.this.edb().olV.cjL().live_id), String.valueOf(c.this.edb().olV.cjL().group_id))));
                            c.this.edj();
                        } catch (Exception e) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(c.this.edb().pageContext.getPageActivity(), "请稍后重试", 1).show();
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
                if (c.this.oln == null) {
                    c.this.oln = new g(c.this.edb().pageContext);
                }
                c.this.oln.b(eVar);
            }
        }
    };
    private boolean hhL = false;

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
    }

    public void a(w wVar, String str, String str2) {
        this.hhL = false;
        edb().olW.setIsForceHandledTouch(false);
        edb().olW.setSwipeClearEnable(false);
        edb().olW.setOnLiveViewScrollListener(this.hfn);
        if (this.hgG != null) {
            this.hgG.setVisibility(0);
        }
        ccr();
        caF();
        caH();
        caM();
        edi();
        edg();
        edf();
        cbD();
        W(wVar);
        o.efe().l(wVar);
        cat();
        if (wVar != null && wVar.aKL != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aO(wVar.aKL.aUg, str2, str);
        }
    }

    private void W(w wVar) {
        if (this.olk == null) {
            this.olk = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(edb().pageContext, this);
        }
        if (wVar != null && wVar.aKL != null) {
            this.olk.Wo(wVar.aKL.live_id);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        super.l(wVar);
        this.hhL = false;
        edb().olW.setIsForceHandledTouch(false);
        edb().olW.setSwipeClearEnable(false);
        edb().olW.setOnLiveViewScrollListener(this.hfn);
        if (this.hgG != null) {
            this.hgG.setVisibility(0);
        }
        ccr();
        caF();
        caG();
        caK();
        caH();
        caM();
        edi();
        edg();
        ede();
        edf();
        nj(false);
        cby();
        cbx();
        cbD();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().ag(wVar);
        o.efe().l(wVar);
        caC();
        cbz();
        cbP();
        cav();
        caB();
        cbL();
        can();
        cbO();
        c(this.giS);
        cay();
        MessageManager.getInstance().registerListener(this.olt);
        MessageManager.getInstance().registerListener(this.hfp);
        MessageManager.getInstance().registerListener(this.hfu);
        MessageManager.getInstance().registerListener(this.hfv);
        MessageManager.getInstance().registerListener(this.hfs);
        caQ();
        caJ();
        cat();
        edd();
    }

    private void edd() {
        o.efe().a(new o.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.8
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
            public void Ns(int i) {
                c.this.ccm();
                c.this.ccn();
            }
        });
    }

    private void ede() {
        if (edb().olV.Iq() != null && edb().olV.Iq().aJV != null && edb().olV.Iq().mLiveInfo != null) {
            w Iq = edb().olV.Iq();
            if (Iq.aKQ != null && Iq.aKQ.getRoomMode() == 1) {
                if (this.ols == null) {
                    this.ols = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(edb().pageContext);
                }
                this.ols.Z(edb().olV.Iq());
                this.ols.at(this.hgG);
            }
        }
    }

    private void edf() {
        if (edb().olV.Iq() != null && edb().olV.Iq().aJV != null && edb().olV.Iq().mLiveInfo != null && this.olr == null) {
            this.olr = new com.baidu.tieba.yuyinala.liveroom.j.a(edb().pageContext);
        }
    }

    private void edg() {
        if (edb().olV.Iq() != null && edb().olV.Iq().aJV != null && edb().olV.Iq().mLiveInfo != null) {
            if (this.olq == null) {
                this.olq = new com.baidu.tieba.yuyinala.liveroom.charmrank.a(edb().pageContext);
            }
            long j = edb().olV.Iq().aJV.userId;
            int i = edb().olV.Iq().mLiveInfo.live_type;
            String str = edb().olV.Iq().aJV.portrait;
            String str2 = edb().olV.Iq().mLiveInfo.feed_id;
            long j2 = edb().olV.Iq().mLiveInfo.live_id;
            this.olq.a(i, j, edb().olV.Iq().aJV.userName, false, str, Oj(), str2, j2);
            this.olq.at(this.hgG);
            this.olq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    w Iq = c.this.edb().olV.Iq();
                    if (Iq != null && Iq.aJV != null) {
                        c.this.edh();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmRankActivityConfig(c.this.edb().pageContext.getPageActivity(), Iq.aJV.userName, Long.toString(Iq.aJV.userId), Long.toString(Iq.aJV.charmCount), String.valueOf(Iq.aKL.croom_id), String.valueOf(Iq.mLiveInfo.live_id), false, String.valueOf(Iq.aJV.userId), Long.toString(Iq.aKr.userId), Iq.aKr.userName, Iq.aKr.portrait, 0L, Iq.aKr.userType)));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edh() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = edb().olV.Iq();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Iq.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "charmlist_clk").setContentExt(jSONObject));
    }

    private void edi() {
        if (edb().olV.Iq() != null && edb().olV.Iq().aJV != null && edb().olV.Iq().mLiveInfo != null) {
            if (this.olp == null) {
                this.olp = new com.baidu.tieba.yuyinala.liveroom.introduce.g(edb().pageContext);
            }
            this.olp.Z(edb().olV.Iq());
            this.olp.at(this.hgG);
            this.olp.cGx();
        }
    }

    public void caM() {
        if (edb().olV.Iq() != null && edb().olV.Iq().mLiveInfo != null && edb().olV.Iq().aKL != null && edb().olV.Iq().aKR) {
            if (this.olo == null) {
                this.olo = new com.baidu.tieba.yuyinala.liveroom.ranklist.a(edb().pageContext);
            }
            String str = edb().olV.Iq().aKr.userUk;
            int i = edb().olV.Iq().mLiveInfo.live_type;
            String str2 = edb().olV.Iq().aKL.cover;
            String str3 = edb().olV.Iq().mLiveInfo.feed_id;
            long j = edb().olV.Iq().mLiveInfo.live_id;
            this.olo.a(i, str, edb().olV.Iq().aJV.userName, false, str2, Oj(), str3, j, edb().olV.Iq().aKL.croom_id, edb().olV.Iq().aKL.aUl, edb().olV.Iq().aKL.aUg, edb().olV.Iq().aKL.cover, edb().olV.Iq().aKL.room_name);
            this.olo.at(this.hgG);
            this.olo.cGx();
        }
    }

    private void can() {
        if (this.ole != null) {
            this.ole.a(new a.InterfaceC0932a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.10
                @Override // com.baidu.tieba.yuyinala.liveroom.recommend.a.InterfaceC0932a
                public void cH(boolean z) {
                }
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        super.j(wVar);
        if (this.oll != null) {
            this.oll.M(wVar);
        }
        X(wVar);
        if (this.olo != null && wVar != null && wVar.aKL != null) {
            this.olo.NF(wVar.aKL.aUl);
        }
        if (this.olj != null) {
            this.olj.i(wVar);
            this.olj.nc(this.hgQ);
            this.olj.updateView();
            if (wVar != null && this.hgy != null && !this.hgy.hasInit && !TextUtils.isEmpty(this.hgy.aRg)) {
                this.hgy.hasInit = true;
                this.olj.Id(this.hgy.aRg);
            }
        }
    }

    private void X(w wVar) {
        if (wVar != null && wVar.aKQ != null && wVar.aKQ.getRoomMode() == 1) {
            if (this.ols != null) {
                this.ols.j(wVar);
            } else if (o.efe().efs()) {
                this.ols = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(edb().pageContext);
                this.ols.Z(wVar);
                this.ols.cR(this.hgG);
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.ols != null) {
                            c.this.ols.edq();
                        }
                    }
                }, 1500L);
            } else {
                this.ols = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(edb().pageContext);
                this.ols.Z(wVar);
                this.ols.cR(this.hgG);
                this.ols.edq();
            }
        } else if (o.efe().efs()) {
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.12
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ols != null) {
                        c.this.ols.onDestroy();
                        c.this.ols = null;
                    }
                }
            }, 1500L);
        } else if (this.ols != null) {
            this.ols.onDestroy();
            this.ols = null;
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(q qVar) {
        if (qVar != null) {
            if (this.olk != null && qVar.getList() != null) {
                this.olk.e(qVar);
            }
            if (this.olm != null) {
                this.olm.eZ(qVar.getCount());
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void eb(int i) {
        super.eb(i);
    }

    private void cat() {
        if (edb() != null && edb().pageContext != null && edb().pageContext.getPageActivity() != null) {
            if (this.buZ == null) {
                this.buZ = new PendantParentView(edb().pageContext.getPageActivity(), PendantParentView.Model.VERTICAL);
                edb().olW.addView(this.buZ, new ViewGroup.LayoutParams(-1, -1));
                this.buZ.setDefaultItemMargin(edb().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
                this.buZ.setPadding(edb().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, edb().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            }
            ccm();
        }
    }

    private void cav() {
        if (this.olj == null) {
            this.olj = new com.baidu.tieba.yuyinala.liveroom.activeview.b(edb().pageContext);
        }
        if (edb() != null && edb().olV != null) {
            this.olj.Ia(edb().olV.cjP());
        }
        this.olj.setOtherParams(Oj());
        this.olj.b(edb().olV.Iq(), false);
        this.olj.setHost(false);
        this.olj.nc(this.hgQ);
        this.olj.a(1, this.buZ);
        this.olj.a(2, this.buZ);
        this.olj.setVisible(this.hgK ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccm() {
        if (this.buZ != null) {
            this.buZ.setModel(edb().olV.Iq().aKQ.getRoomMode() == 1 ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            this.buZ.setPosition(edb().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds164), 0, edb().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200), edb().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102));
            return;
        }
        cat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccn() {
        if (this.hfW != null && this.heZ != null && this.hfW.Nd() != null && this.hfW.Nd().getView() != null) {
            int J = com.baidu.tieba.yuyinala.liveroom.o.a.J(this.hgK, edb().olV.Iq().aKQ.getRoomMode());
            if (this.hgH.indexOfChild(this.heZ) != -1 && this.heZ.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heZ.getLayoutParams();
                layoutParams.height = J;
                this.heZ.setLayoutParams(layoutParams);
            }
            if (this.heZ.indexOfChild(this.hfW.Nd().getView()) != -1 && this.hfW.Nd().getView().getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hfW.Nd().getView().getLayoutParams();
                layoutParams2.height = J;
                this.hfW.Nd().getView().setLayoutParams(layoutParams2);
            }
            this.hfW.Nd().Nc();
        }
    }

    private void ccr() {
        if (this.hhG == null) {
            this.hhG = new LinearLayout(edb().pageContext.getPageActivity());
            this.hhG.setOrientation(1);
        }
        if (this.hhG.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = edb().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = edb().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            edb().olW.addView(this.hhG, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caB() {
        if (this.okS == null) {
            caH();
        }
        this.okS.setOtherParams(Oj());
        this.okS.a(e.RP().bxB, edb().olV.Iq());
    }

    private void cbD() {
        if (this.okY != null && edb() != null && edb().olV != null) {
            this.okY.d(this.hgG, edb().olV.Iq());
        }
    }

    private void caC() {
        CustomResponsedMessage runTask;
        if (this.hfW == null && (runTask = MessageManager.getInstance().runTask(2501045, k.class, edb().pageContext)) != null && runTask.getData() != null) {
            this.hfW = (k) runTask.getData();
            this.hfW.setFromMaster(false);
            this.hfW.Nd().getView().setId(a.f.ala_liveroom_msg_list);
            this.hfW.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4
                @Override // com.baidu.live.im.k.a
                public boolean Nh() {
                    return c.this.Le();
                }

                @Override // com.baidu.live.im.k.a
                public void Ni() {
                    c.this.hgO = true;
                }

                @Override // com.baidu.live.im.k.a
                public void id(String str) {
                    if (!c.this.hgK) {
                        c.this.ng(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(c.this.edb().pageContext.getPageActivity(), c.this.edb().hpS.getLiveContainerView());
                    }
                    c.this.Ih(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Nj() {
                    if (c.this.hgK) {
                        c.this.ng(true);
                        c.this.edb().hpS.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.edb().pageContext.getPageActivity(), c.this.edb().hpS.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.hfW != null) {
                        c.this.hfW.Ne().setQuickInputPanelVisible(false);
                        c.this.hfW.Ne().OR();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Nk() {
                    if (c.this.hgK) {
                        c.this.caX();
                        if (c.this.hfX != null) {
                            c.this.hfX.DM();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Nl() {
                    return c.this.cbk();
                }

                @Override // com.baidu.live.im.k.a
                public int Nm() {
                    return c.this.cbl();
                }
            });
            this.heZ = new FrameLayout(edb().pageContext.getPageActivity());
            this.heZ.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hfW != null && this.heZ != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(edb().pageContext.getPageActivity()) * 0.7f);
            int J = com.baidu.tieba.yuyinala.liveroom.o.a.J(false, edb().olV.Iq().aKQ.getRoomMode());
            if (this.hgH.indexOfChild(this.heZ) < 0) {
                if (this.heZ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.heZ.getParent()).removeView(this.heZ);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, J);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.tieba.yuyinala.liveroom.o.a.dk(false);
                this.hgH.addView(this.heZ, layoutParams);
            }
            if (this.heZ.indexOfChild(this.hfW.Nd().getView()) < 0) {
                if (this.hfW.Nd().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hfW.Nd().getView()).removeView(this.hfW.Nd().getView());
                }
                this.heZ.addView(this.hfW.Nd().getView(), new FrameLayout.LayoutParams(equipmentWidth, J));
            }
            if (edb().olW.indexOfChild(this.hfW.Ne().getView()) < 0) {
                if (this.hfW.Ne().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hfW.Ne().getView().getParent()).removeView(this.hfW.Ne().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cbs();
                edb().olW.addView(this.hfW.Ne().getView(), layoutParams2);
            }
            w Iq = edb().olV.Iq();
            if (Iq != null && Iq.mLiveInfo != null) {
                this.hfW.setLogData(Iq.mLiveInfo.feed_id, Oj());
            }
            this.hfW.a(String.valueOf(edb().olV.Iq().mLiveInfo.group_id), String.valueOf(edb().olV.Iq().mLiveInfo.last_msg_id), String.valueOf(edb().olV.Iq().aJV.userId), String.valueOf(edb().olV.Iq().mLiveInfo.live_id), edb().olV.Iq().aJV.appId, (Iq == null || Iq.aKI == null || !Iq.aKI.Fb()) ? false : true, edb().olV.Iq().getGuardName());
            ng(false);
        }
    }

    private void caF() {
        if (this.oll == null) {
            this.oll = new com.baidu.tieba.yuyinala.liveroom.h.b(this.activity);
        }
        this.oll.e(this.hgG, edb().olV.Iq());
    }

    private void caG() {
        if (this.olk == null) {
            this.olk = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(edb().pageContext, this);
        }
        String.valueOf(edb().olV.Iq().mLiveInfo.group_id);
        String valueOf = String.valueOf(edb().olV.Iq().mLiveInfo.live_id);
        String.valueOf(edb().olV.Iq().aJV.userId);
        this.olk.a(valueOf, edb().olV.Iq());
        this.olk.c(this.hgG, a.f.ala_liveroom_hostheader, a.f.ala_liveroom_audience_count_layout);
        this.olk.e(edb().olV.bUu());
        this.olk.setOtherParams(Oj());
    }

    private void caH() {
        if (this.okS == null) {
            this.okS = new com.baidu.tieba.yuyinala.liveroom.operation.a(edb().pageContext);
        }
        this.okS.a(edb(), this.hgH, edb().olV.Iq().mLiveInfo, true, this.olu);
        this.okS.setOtherParams(Oj());
    }

    public void no(boolean z) {
        if (this.okS != null) {
            this.okS.no(z);
        }
    }

    private void caK() {
        if (this.olm == null) {
            this.olm = new com.baidu.tieba.yuyinala.liveroom.audiencelist.b(edb().pageContext.getPageActivity());
        }
        long j = 1;
        if (edb().olV.bUu() != null) {
            j = edb().olV.bUu().getCount();
        }
        this.olm.a(this.olu);
        this.olm.a(this.hgG, a.f.ala_liveroom_audience, j);
        this.olm.setVisible(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edj() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = edb().olV.Iq();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Iq.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "msgbtn_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edk() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = edb().olV.Iq();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Iq.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "morefunc_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edl() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = edb().olV.Iq();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Iq.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "giftbtn_clk").setContentExt(jSONObject));
    }

    public void caL() {
        this.okT.c(edb().olV.Iq(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edm() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = edb().olV.Iq();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Iq.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "olnumber_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edn() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = edb().olV.Iq();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Iq.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "closebtn_clk").setContentExt(jSONObject));
    }

    private void caQ() {
        if (this.hgO || this.hgP) {
            if ((TbadkCoreApplication.isLogin() && this.hfW.Ne().hasText()) || this.hgP) {
                this.hgO = false;
                this.hgP = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.cbq();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void caI() {
        caJ();
    }

    private void caJ() {
        if (this.okS != null) {
            int i = edb().olV.Iq().aKr.isUegBlock;
            int i2 = edb().olV.Iq().aKr.isBlock;
            String str = edb().olV.Iq().aKr.userName;
            if (i > 0 || i2 > 0) {
                this.okS.b(true, i, i2, str);
                this.hfW.a(true, i, i2, str);
                this.okX.b(true, i, i2, str);
                return;
            }
            this.okS.b(false, i, i2, str);
            this.hfW.a(false, i, i2, str);
            this.okX.b(false, i, i2, str);
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
                    if (edb().olV.Iq() != null && edb().olV.Iq().mLiveInfo != null) {
                        edb().olV.a(edb().olV.Iq().mLiveInfo.live_id, edb().fromType, edb().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && edb().olV.Iq() != null && edb().olV.Iq().mLiveInfo != null && edb().olV.Iq().aKr != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == edb().olV.Iq().aKr.userId && optLong2 == edb().olV.Iq().mLiveInfo.live_id) {
                        jSONObject.optInt("challenge_status");
                        jSONObject.optLong("challenge_id");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void Ic(String str) {
        if (this.olj != null) {
            this.olj.Ic(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void cz(boolean z) {
        super.cz(z);
        if (edb().olW != null) {
            edb().olW.cll();
            edb().olW.setLiveViewOnDispatchTouchEventListener(null);
            edb().olW.setLiveViewOnTouchEventListener(null);
            edb().olW.setOnLiveViewScrollListener(null);
        }
        if (edb().brf != null) {
            edb().brf.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        caR();
        if (this.okS != null) {
            this.okS.cjS();
        }
        if (this.ols != null) {
            this.ols.En();
        }
        if (this.buZ != null) {
            this.buZ.removeAllViews();
            this.buZ = null;
        }
        if (this.hhG != null) {
            this.hhG.removeAllViews();
            this.hhG = null;
        }
        if (this.olj != null) {
            this.olj.release();
        }
        if (this.olo != null) {
            this.olo.En();
        }
        if (this.olp != null) {
            this.olp.En();
        }
        if (this.olq != null) {
            this.olq.En();
        }
        o.efe().En();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cx(boolean z) {
        super.cx(z);
        caR();
        if (this.oll != null) {
            this.oll.onDestroy();
        }
        if (this.olk != null) {
            this.olk.onDestroy();
        }
        if (this.hfW != null) {
            this.hfW.onDestroy();
        }
        if (this.okS != null) {
            this.okS.onDestory();
        }
        if (this.olj != null) {
            this.olj.release();
        }
        if (this.olo != null) {
            this.olo.onDestroy();
        }
        if (this.olp != null) {
            this.olp.onDestroy();
        }
        if (this.olq != null) {
            this.olq.onDestroy();
        }
        if (this.oln != null) {
            this.oln.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.olt);
        MessageManager.getInstance().unRegisterListener(this.hfp);
        MessageManager.getInstance().unRegisterListener(this.hfu);
        MessageManager.getInstance().unRegisterListener(this.hfv);
        MessageManager.getInstance().unRegisterListener(this.hfs);
    }

    private void caR() {
        if (this.hfW != null && this.hfW.Nd().getView() != null && this.hfW.Nd().getView().getParent() != null) {
            ((ViewGroup) this.hfW.Nd().getView().getParent()).removeView(this.hfW.Nd().getView());
        }
        if (this.heZ != null && this.heZ.getParent() != null) {
            ((ViewGroup) this.heZ.getParent()).removeView(this.heZ);
        }
        if (this.hfW != null && this.hfW.Ne().getView() != null) {
            this.hgH.removeView(this.hfW.Ne().getView());
        }
        if (this.hfW != null) {
            this.hfW.Nd().setMsgData(new LinkedList());
            this.hfW.DN();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void a(ar arVar) {
        if (this.hfW != null) {
            cbq();
            this.hfW.Ne().setEditText(" @" + arVar.getNameShow() + " ");
        }
        if (this.okS != null) {
            this.okS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hfW != null) {
            cbq();
            this.hfW.Ne().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.okS != null) {
            this.okS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void b(ar arVar) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected View caS() {
        if (this.hfW != null) {
            return this.hfW.Ne().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public boolean caT() {
        if (this.hfW == null || !this.hfW.Ne().OQ()) {
            return false;
        }
        ng(false);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    /* renamed from: cct */
    public PendantParentView caV() {
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
                    this.hgL = false;
                    a(null, intExtra, intExtra2, intExtra3);
                    return;
                }
                caL();
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
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) edb().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.oll != null) {
            this.oll.In(fromJson.getSmallurl());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.hfW != null && this.hfW.Nd() != null) {
            this.hfW.Nd().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hfW == null || this.hfW.Ne() == null || !this.hfW.Ne().OQ()) {
            if (z) {
                if (this.okS != null) {
                    this.okS.setVisibility(8);
                }
                if (this.hfY != null && this.hfY.HN() != null) {
                    this.hfY.HN().setVisibility(8);
                }
                caX();
                if (this.hfW != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfW.Ne().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hfW.Ne().getView().setLayoutParams(layoutParams);
                    this.hfW.Ne().getView().setVisibility(0);
                    this.hfW.Ne().setQuickInputPanelVisible(false);
                }
                if (this.hgG != null) {
                    this.hgG.setVisibility(8);
                }
                if (this.hfX != null) {
                    this.hfX.DM();
                }
                if (this.olj != null) {
                    this.olj.setVisible(8);
                }
                if (this.hgz != null) {
                    this.hgz.setCanVisible(false);
                }
            } else {
                caW();
            }
            ccn();
            if (this.hgk != null) {
                this.hgk.bD(z);
            }
        }
    }

    private void caW() {
        if (this.okS != null) {
            this.okS.setVisibility(0);
        }
        if (this.heZ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heZ.getLayoutParams();
            layoutParams.bottomMargin = edb().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds120);
            this.heZ.setLayoutParams(layoutParams);
        }
        if (this.hfW != null) {
            cbs();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hfW.Ne().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hfW.Ne().getView().setLayoutParams(layoutParams2);
        }
        if (this.okS != null) {
            this.okS.setVisibility(0);
        }
        if (this.hfY != null && this.hfY.HN() != null) {
            this.hfY.HN().setVisibility(0);
        }
        if (this.hgG != null) {
            this.hgG.setVisibility(0);
        }
        if (this.olj != null) {
            this.olj.setVisible(0);
        }
        if (this.hfX != null) {
            this.hfX.DM();
        }
        if (this.hgz != null) {
            this.hgz.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caX() {
        boolean z;
        boolean z2 = false;
        if (this.heZ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heZ.getLayoutParams();
            if (this.hfW == null || this.hfW.Ne() == null) {
                z = false;
            } else {
                z = this.hfW.Ne().OO();
                z2 = this.hfW.Ne().OP();
            }
            int M = M(z, z2);
            if (layoutParams.bottomMargin != M) {
                layoutParams.bottomMargin = M;
                this.heZ.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng(boolean z) {
        this.hhL = z;
        if (z) {
            this.hfW.Ne().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heZ.getLayoutParams();
            int quickInputPanelExpandHeight = this.hfW.Ne().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.heZ.setLayoutParams(layoutParams);
                if (this.hfW.Nd() != null) {
                    this.hfW.Nd().Nc();
                    return;
                }
                return;
            }
            return;
        }
        caW();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3 && this.olk != null) {
            this.olk.dX(i3);
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
            if (this.okS != null) {
                this.okS.setVisibility(8);
            }
            if (this.hfW != null) {
                this.hfW.Nd().getView().setVisibility(4);
            }
            if (this.olj != null) {
                this.olj.bQ(2, 8);
            }
            if (this.ola != null) {
                this.ola.oh(false);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public void fi(int i) {
        super.fi(i);
        if (i == 7 || i == 11) {
            if (this.okS != null) {
                this.okS.setVisibility(0);
            }
            if (this.hfW != null) {
                this.hfW.Nd().getView().setVisibility(0);
            }
            if (this.olj != null) {
                this.olj.setVisible(0);
            }
            if (this.ola != null) {
                this.ola.oh(true);
            }
            this.hgG.setVisibility(0);
        }
    }

    private void cay() {
        if (this.okS != null) {
            this.okS.a(new a.InterfaceC0931a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.olj != null) {
            this.olj.onStop();
        }
        if (this.olo != null) {
            this.olo.ckq();
        }
        if (this.olp != null) {
            this.olp.ckq();
        }
        if (this.olq != null) {
            this.olq.ckq();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeM().onDestroy();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.olj != null) {
            this.olj.onStart();
        }
        if (this.olo != null) {
            this.olo.ckp();
        }
        if (this.olp != null) {
            this.olp.ckp();
        }
        if (this.olq != null) {
            this.olq.ckp();
        }
    }
}
