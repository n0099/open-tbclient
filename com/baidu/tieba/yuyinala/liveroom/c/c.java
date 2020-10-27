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
import com.baidu.live.b.af;
import com.baidu.live.data.ap;
import com.baidu.live.data.bm;
import com.baidu.live.data.cb;
import com.baidu.live.data.ch;
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
import com.baidu.live.z.e;
import com.baidu.tieba.yuyinala.liveroom.introduce.g;
import com.baidu.tieba.yuyinala.liveroom.operation.a;
import com.baidu.tieba.yuyinala.liveroom.recommend.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.f;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.n;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends a {
    private PendantParentView bqg;
    private com.baidu.live.ai.a gFm;
    private FrameLayout gPS;
    private LinearLayout gSo;
    private com.baidu.tieba.yuyinala.liveroom.activeview.b nOJ;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.c nOK;
    private com.baidu.tieba.yuyinala.liveroom.h.b nOL;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.b nOM;
    private f nON;
    private com.baidu.tieba.yuyinala.liveroom.ranklist.a nOO;
    private g nOP;
    private com.baidu.tieba.yuyinala.liveroom.charmrank.a nOQ;
    private com.baidu.tieba.yuyinala.liveroom.j.a nOR;
    private long lastClickTime = 0;
    private com.baidu.live.liveroom.g.c gQe = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.1
        @Override // com.baidu.live.liveroom.g.c
        public void NB() {
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cj(boolean z) {
            if (z) {
                if (c.this.nOs != null) {
                    c.this.nOs.LO(8);
                }
            } else if (c.this.nOs != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                    c.this.nOs.LO(0);
                } else {
                    c.this.nOs.LO(8);
                }
            }
            if (c.this.gQW != null) {
                c.this.gQW.bs(z);
            }
        }
    };
    private CustomMessageListener nOS = new CustomMessageListener(2501032) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501032) {
                long currentTimeMillis = System.currentTimeMillis();
                if (c.this.dUX().nPk.GH() != null && c.this.dUX().nPk.GH().mLiveInfo != null) {
                    c.this.dUX().nPk.a(c.this.dUX().nPk.GH().mLiveInfo.live_id, c.this.dUX().fromType, c.this.dUX().enterTime, currentTimeMillis);
                }
            }
        }
    };
    private HttpMessageListener gQg = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.NK() != null) {
                        e.PD().bsJ = getQuickGiftHttpResponseMessage.NK();
                        c.this.bUS();
                    }
                }
            }
        }
    };
    CustomMessageListener gQl = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2913168) {
            }
        }
    };
    private CustomMessageListener gQi = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (c.this.nOC != null) {
                    c.this.nOC.hM(str);
                }
            }
        }
    };
    private CustomMessageListener gQk = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (c.this.nOz != null) {
                    c.this.nOz.dismiss();
                }
                if (c.this.nOC != null) {
                    c.this.nOC.dismiss();
                }
                d.LG().setSwitchStatus(true);
                d.LG().setSelectId((String) customResponsedMessage.getData());
                if (c.this.mHandler == null) {
                    c.this.mHandler = new Handler();
                }
                c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.bVG();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.yuyinala.liveroom.operation.b nOT = new com.baidu.tieba.yuyinala.liveroom.operation.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2
        @Override // com.baidu.tieba.yuyinala.liveroom.operation.b
        public void b(View view, int i, String str) {
            bm bmVar;
            cb cbVar;
            ch chVar;
            String str2;
            bm bmVar2;
            cb cbVar2;
            String str3;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c.this.lastClickTime >= 300) {
                c.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    c.this.dVg();
                    c.this.h(str, -1, -1, -1);
                } else if (i == 1) {
                    if (c.this.gQJ != null) {
                        c.this.bVG();
                    }
                } else if (i == 3) {
                    c.this.nOt.c(c.this.dUX().nPk.GH(), false);
                } else if (i == 8) {
                    if (c.this.bmm != null) {
                        c.this.bmm.cd(false);
                    }
                    c.this.dVi();
                } else if (i != 12) {
                    if (i == 14) {
                        c.this.dVh();
                        w GH = c.this.dUX().nPk.GH();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmCardActivityConfig(c.this.dUX().pageContext.getPageActivity(), GH.aIe.userName, Long.toString(GH.aIe.userId), Long.toString(GH.aIe.charmCount), String.valueOf(GH.mLiveInfo.group_id), String.valueOf(GH.mLiveInfo.live_id), false, String.valueOf(GH.aIe.userId), Long.toString(GH.aIA.userId), GH.aIA.userName, GH.aIA.portrait, c.this.nOM.getCount(), c.this.Md(), GH.aIZ)));
                    } else if (i == 11) {
                        c.this.bVJ();
                        c.this.bVK();
                    } else if (i == 16) {
                        if (c.this.dUX() != null && (bmVar2 = com.baidu.live.z.a.Pq().bsy) != null && (cbVar2 = bmVar2.aOA) != null) {
                            String str4 = cbVar2.aPQ.aPY;
                            if (!TextUtils.isEmpty(str4)) {
                                long j = 0;
                                if (c.this.dUX().nPk != null && c.this.dUX().nPk.GH() != null && c.this.dUX().nPk.GH().mLiveInfo != null) {
                                    j = c.this.dUX().nPk.GH().mLiveInfo.live_id;
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", c.this.dUX().nPk.GH().mLiveInfo.room_id + "", c.this.dUX().nPk.GH().mLiveInfo.feed_id, c.this.Md());
                                }
                                if (str4.contains("?")) {
                                    str3 = str4 + "&liveId=" + j;
                                } else {
                                    str3 = str4 + "?liveId=" + j;
                                }
                                if (c.this.gFm == null) {
                                    c.this.gFm = new com.baidu.live.ai.a(c.this.dUX().pageContext.getPageActivity());
                                }
                                com.baidu.live.ai.c cVar = new com.baidu.live.ai.c();
                                cVar.url = str3;
                                c.this.gFm.a(cVar);
                            }
                        }
                    } else if (i == 20) {
                        if (c.this.dUX() != null) {
                            w wVar = null;
                            if (c.this.dUX().nPk != null) {
                                wVar = c.this.dUX().nPk.GH();
                            }
                            if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.yuyinala.liveroom.n.b.dVE().bmT != null) {
                                String str5 = com.baidu.tieba.yuyinala.liveroom.n.b.dVE().bmT.aJA;
                                if (!TextUtils.isEmpty(str5)) {
                                    if (str5.contains("?")) {
                                        str2 = str5 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    } else {
                                        str2 = str5 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    }
                                    if (c.this.gFm == null) {
                                        c.this.gFm = new com.baidu.live.ai.a(c.this.dUX().pageContext.getPageActivity());
                                    }
                                    com.baidu.live.ai.c cVar2 = new com.baidu.live.ai.c();
                                    cVar2.url = str2;
                                    c.this.gFm.a(cVar2);
                                }
                            }
                        }
                    } else if (i == 17) {
                        if (c.this.Jl() && c.this.dUX() != null && (bmVar = com.baidu.live.z.a.Pq().bsy) != null && (cbVar = bmVar.aOA) != null && (chVar = cbVar.aPR) != null && !TextUtils.isEmpty(chVar.webUrl) && c.this.nOz != null && c.this.dUX().nPk != null && c.this.dUX().nPk.GH() != null) {
                            w GH2 = c.this.dUX().nPk.GH();
                            c.this.nOz.a(chVar.webUrl, GH2.mLiveInfo.live_id, GH2.aIA.userId, GH2.aIe.userId);
                        }
                    } else if (i == 21 && c.this.Jl()) {
                        c.this.dVd();
                        int i2 = 0;
                        if (view.getTag() != null) {
                            i2 = ((Integer) view.getTag()).intValue();
                        }
                        if (c.this.nON == null) {
                            c.this.nON = new f(c.this.dUX().pageContext, c.this.dUX().nPk.GH());
                        }
                        c.this.nON.setClickType(i2);
                        c.this.nON.show();
                    } else if (i == 22) {
                        c.this.nOR.R(c.this.dUX().nPk.GH());
                        c.this.dVf();
                    } else if (i == 23 && c.this.Jl()) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new af(BdBaseApplication.getInst(), String.valueOf(c.this.dUX().nPk.cdW().live_id), String.valueOf(c.this.dUX().nPk.cdW().group_id))));
                            c.this.dVe();
                        } catch (Exception e) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(c.this.dUX().pageContext.getPageActivity(), "请稍后重试", 1).show();
                                }
                            });
                        }
                    }
                }
            }
        }
    };
    private boolean gSt = false;

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
    }

    public void a(w wVar, String str, String str2) {
        this.gSt = false;
        dUX().nPl.setIsForceHandledTouch(false);
        dUX().nPl.setSwipeClearEnable(false);
        dUX().nPl.setOnLiveViewScrollListener(this.gQe);
        if (this.gRo != null) {
            this.gRo.setVisibility(0);
        }
        bUK();
        bWB();
        bUV();
        bUX();
        bVc();
        dVc();
        dVa();
        dUZ();
        bVR();
        M(wVar);
        n.dWB().m(wVar);
        if (wVar != null && wVar.aIS != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().aK(wVar.aIS.aRy, str2, str);
        }
    }

    private void M(w wVar) {
        if (this.nOK == null) {
            this.nOK = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(dUX().pageContext, this);
        }
        if (wVar != null && wVar.aIS != null) {
            this.nOK.UX(wVar.aIS.live_id);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        super.m(wVar);
        this.gSt = false;
        dUX().nPl.setIsForceHandledTouch(false);
        dUX().nPl.setSwipeClearEnable(false);
        dUX().nPl.setOnLiveViewScrollListener(this.gQe);
        if (this.gRo != null) {
            this.gRo.setVisibility(0);
        }
        bUK();
        bWB();
        bUV();
        bUW();
        bVa();
        bUX();
        bVc();
        dVc();
        dVa();
        dUZ();
        mF(false);
        bVN();
        bVM();
        bVR();
        bUT();
        bVO();
        bWb();
        bUM();
        bUS();
        bVX();
        bUF();
        bWa();
        c(this.fVh);
        bUP();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().U(wVar);
        n.dWB().m(wVar);
        MessageManager.getInstance().registerListener(this.nOS);
        MessageManager.getInstance().registerListener(this.gQg);
        MessageManager.getInstance().registerListener(this.gQk);
        MessageManager.getInstance().registerListener(this.gQl);
        MessageManager.getInstance().registerListener(this.gQi);
        bVf();
        bUZ();
    }

    private void dUZ() {
        if (dUX().nPk.GH() != null && dUX().nPk.GH().aIe != null && dUX().nPk.GH().mLiveInfo != null && this.nOR == null) {
            this.nOR = new com.baidu.tieba.yuyinala.liveroom.j.a(dUX().pageContext);
        }
    }

    private void dVa() {
        if (dUX().nPk.GH() != null && dUX().nPk.GH().aIe != null && dUX().nPk.GH().mLiveInfo != null) {
            if (this.nOQ == null) {
                this.nOQ = new com.baidu.tieba.yuyinala.liveroom.charmrank.a(dUX().pageContext);
            }
            long j = dUX().nPk.GH().aIe.userId;
            int i = dUX().nPk.GH().mLiveInfo.live_type;
            String str = dUX().nPk.GH().aIe.portrait;
            String str2 = dUX().nPk.GH().mLiveInfo.feed_id;
            long j2 = dUX().nPk.GH().mLiveInfo.live_id;
            this.nOQ.a(i, j, dUX().nPk.GH().aIe.userName, false, str, Md(), str2, j2);
            this.nOQ.av(this.gRo);
            this.nOQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.dVb();
                    w GH = c.this.dUX().nPk.GH();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmRankActivityConfig(c.this.dUX().pageContext.getPageActivity(), GH.aIe.userName, Long.toString(GH.aIe.userId), Long.toString(GH.aIe.charmCount), String.valueOf(GH.aIS.croom_id), String.valueOf(GH.mLiveInfo.live_id), false, String.valueOf(GH.aIe.userId), Long.toString(GH.aIA.userId), GH.aIA.userName, GH.aIA.portrait, c.this.nOM.getCount(), GH.aIA.userType)));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVb() {
        JSONObject jSONObject = new JSONObject();
        try {
            w GH = dUX().nPk.GH();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, GH.aIS.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "charmlist_clk").setContentExt(jSONObject));
    }

    private void dVc() {
        if (dUX().nPk.GH() != null && dUX().nPk.GH().aIe != null && dUX().nPk.GH().mLiveInfo != null) {
            if (this.nOP == null) {
                this.nOP = new g(dUX().pageContext);
            }
            long j = dUX().nPk.GH().aIe.userId;
            int i = dUX().nPk.GH().mLiveInfo.live_type;
            String str = dUX().nPk.GH().aIe.portrait;
            String str2 = dUX().nPk.GH().mLiveInfo.feed_id;
            long j2 = dUX().nPk.GH().mLiveInfo.live_id;
            String str3 = dUX().nPk.GH().aIe.userName;
            String str4 = dUX().nPk.GH().aIS.aRy;
            this.nOP.Q(dUX().nPk.GH());
            this.nOP.av(this.gRo);
            this.nOP.czY();
        }
    }

    public void bVc() {
        if (dUX().nPk.GH() != null && dUX().nPk.GH().mLiveInfo != null && dUX().nPk.GH().aIS != null && dUX().nPk.GH().aIX) {
            if (this.nOO == null) {
                this.nOO = new com.baidu.tieba.yuyinala.liveroom.ranklist.a(dUX().pageContext);
            }
            String str = dUX().nPk.GH().aIA.userUk;
            int i = dUX().nPk.GH().mLiveInfo.live_type;
            String str2 = dUX().nPk.GH().aIS.cover;
            String str3 = dUX().nPk.GH().mLiveInfo.feed_id;
            long j = dUX().nPk.GH().mLiveInfo.live_id;
            this.nOO.a(i, str, dUX().nPk.GH().aIe.userName, false, str2, Md(), str3, j, dUX().nPk.GH().aIS.croom_id, dUX().nPk.GH().aIS.aRD, dUX().nPk.GH().aIS.aRy, dUX().nPk.GH().aIS.cover, dUX().nPk.GH().aIS.room_name);
            this.nOO.av(this.gRo);
            this.nOO.czY();
        }
    }

    private void bUF() {
        if (this.nOE != null) {
            this.nOE.a(new a.InterfaceC0896a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6
                @Override // com.baidu.tieba.yuyinala.liveroom.recommend.a.InterfaceC0896a
                public void cq(boolean z) {
                }
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(w wVar) {
        super.k(wVar);
        if (this.nOL != null) {
            this.nOL.C(wVar);
        }
        if (this.nOO != null && wVar != null && wVar.aIS != null) {
            this.nOO.LT(wVar.aIS.aRD);
        }
        if (this.nOJ != null) {
            this.nOJ.j(wVar);
            this.nOJ.mx(this.gRy);
            this.nOJ.updateView();
            if (wVar != null && this.gRj != null && !this.gRj.hasInit && !TextUtils.isEmpty(this.gRj.aOU)) {
                this.gRj.hasInit = true;
                this.nOJ.Hw(this.gRj.aOU);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(q qVar) {
        if (qVar != null) {
            if (this.nOK != null && qVar.getList() != null) {
                this.nOK.e(qVar);
            }
            if (this.nOM != null) {
                this.nOM.ea(qVar.getCount());
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dM(int i) {
        super.dM(i);
    }

    private void bUK() {
        if (this.bqg == null) {
            this.bqg = new PendantParentView(dUX().pageContext.getPageActivity(), PendantParentView.Model.VERTICAL);
            dUX().nPl.addView(this.bqg, new ViewGroup.LayoutParams(-1, -1));
            this.bqg.setDefaultItemMargin(dUX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bqg.setPadding(dUX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, dUX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bWw();
        }
    }

    private void bUM() {
        if (this.nOJ == null) {
            this.nOJ = new com.baidu.tieba.yuyinala.liveroom.activeview.b(dUX().pageContext);
        }
        if (dUX() != null && dUX().nPk != null) {
            this.nOJ.Ht(dUX().nPk.cea());
        }
        this.nOJ.setOtherParams(Md());
        this.nOJ.b(dUX().nPk.GH(), false);
        this.nOJ.setHost(false);
        this.nOJ.mx(this.gRy);
        this.nOJ.a(1, this.bqg);
        this.nOJ.a(2, this.bqg);
        this.nOJ.setVisible(this.gRs ? 8 : 0);
    }

    private void bWw() {
        if (this.bqg != null) {
            this.bqg.setModel(PendantParentView.Model.VERTICAL);
            int dimensionPixelSize = dUX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds164);
            int dimensionPixelSize2 = dUX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.bqg.setPosition(dimensionPixelSize, 0, dUX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200), dimensionPixelSize2);
            return;
        }
        bUK();
    }

    private void bWx() {
        if (this.gQJ != null && this.gPS != null && this.gQJ.Lj() != null && this.gQJ.Lj().getView() != null) {
            int yM = com.baidu.tieba.yuyinala.liveroom.o.a.yM(this.gRs);
            if (this.gRp.indexOfChild(this.gPS) != -1 && this.gPS.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPS.getLayoutParams();
                layoutParams.height = yM;
                this.gPS.setLayoutParams(layoutParams);
            }
            if (this.gPS.indexOfChild(this.gQJ.Lj().getView()) != -1 && this.gQJ.Lj().getView().getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gQJ.Lj().getView().getLayoutParams();
                layoutParams2.height = yM;
                this.gQJ.Lj().getView().setLayoutParams(layoutParams2);
            }
            this.gQJ.Lj().Li();
        }
    }

    private void bWB() {
        if (this.gSo == null) {
            this.gSo = new LinearLayout(dUX().pageContext.getPageActivity());
            this.gSo.setOrientation(1);
        }
        if (this.gSo.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = dUX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = dUX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            dUX().nPl.addView(this.gSo, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUS() {
        if (this.nOs == null) {
            bUX();
        }
        this.nOs.setOtherParams(Md());
        this.nOs.a(e.PD().bsJ, dUX().nPk.GH());
    }

    private void bVR() {
        if (this.nOy != null && dUX() != null && dUX().nPk != null) {
            this.nOy.c(this.gRo, dUX().nPk.GH());
        }
    }

    private void bUT() {
        CustomResponsedMessage runTask;
        if (this.gQJ == null && (runTask = MessageManager.getInstance().runTask(2501045, k.class, dUX().pageContext)) != null && runTask.getData() != null) {
            this.gQJ = (k) runTask.getData();
            this.gQJ.setFromMaster(false);
            this.gQJ.Lj().getView().setId(a.g.ala_liveroom_msg_list);
            this.gQJ.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.12
                @Override // com.baidu.live.im.k.a
                public boolean Lm() {
                    return c.this.Jl();
                }

                @Override // com.baidu.live.im.k.a
                public void Ln() {
                    c.this.gRw = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hC(String str) {
                    if (!c.this.gRs) {
                        c.this.mC(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(c.this.dUX().pageContext.getPageActivity(), c.this.dUX().haA.getLiveContainerView());
                    }
                    c.this.Hz(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Lo() {
                    if (c.this.gRs) {
                        c.this.mC(true);
                        c.this.dUX().haA.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.dUX().pageContext.getPageActivity(), c.this.dUX().haA.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.gQJ != null) {
                        c.this.gQJ.Lk().setQuickInputPanelVisible(false);
                        c.this.gQJ.Lk().MF();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Lp() {
                    if (c.this.gRs) {
                        c.this.bVm();
                        if (c.this.gQK != null) {
                            c.this.gQK.Cs();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Lq() {
                    return c.this.bVA();
                }

                @Override // com.baidu.live.im.k.a
                public int Lr() {
                    return c.this.bVB();
                }
            });
            this.gPS = new FrameLayout(dUX().pageContext.getPageActivity());
            this.gPS.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.gQJ != null && this.gPS != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(dUX().pageContext.getPageActivity()) * 0.7f);
            int yM = com.baidu.tieba.yuyinala.liveroom.o.a.yM(false);
            if (this.gRp.indexOfChild(this.gPS) < 0) {
                if (this.gPS.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gPS.getParent()).removeView(this.gPS);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, yM);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.tieba.yuyinala.liveroom.o.a.cN(false);
                this.gRp.addView(this.gPS, layoutParams);
            }
            if (this.gPS.indexOfChild(this.gQJ.Lj().getView()) < 0) {
                if (this.gQJ.Lj().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gQJ.Lj().getView()).removeView(this.gQJ.Lj().getView());
                }
                this.gPS.addView(this.gQJ.Lj().getView(), new FrameLayout.LayoutParams(equipmentWidth, yM));
            }
            if (dUX().nPl.indexOfChild(this.gQJ.Lk().getView()) < 0) {
                if (this.gQJ.Lk().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gQJ.Lk().getView().getParent()).removeView(this.gQJ.Lk().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bVH();
                dUX().nPl.addView(this.gQJ.Lk().getView(), layoutParams2);
            }
            w GH = dUX().nPk.GH();
            if (GH != null && GH.mLiveInfo != null) {
                this.gQJ.setLogData(GH.mLiveInfo.feed_id, Md());
            }
            this.gQJ.a(String.valueOf(dUX().nPk.GH().mLiveInfo.group_id), String.valueOf(dUX().nPk.GH().mLiveInfo.last_msg_id), String.valueOf(dUX().nPk.GH().aIe.userId), String.valueOf(dUX().nPk.GH().mLiveInfo.live_id), dUX().nPk.GH().aIe.appId, (GH == null || GH.aIQ == null || !GH.aIQ.DH()) ? false : true);
            mC(false);
        }
    }

    private void bUV() {
        if (this.nOL == null) {
            this.nOL = new com.baidu.tieba.yuyinala.liveroom.h.b(this.activity);
        }
        this.nOL.d(this.gRo, dUX().nPk.GH());
    }

    private void bUW() {
        if (this.nOK == null) {
            this.nOK = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(dUX().pageContext, this);
        }
        String.valueOf(dUX().nPk.GH().mLiveInfo.group_id);
        String valueOf = String.valueOf(dUX().nPk.GH().mLiveInfo.live_id);
        String.valueOf(dUX().nPk.GH().aIe.userId);
        this.nOK.a(valueOf, dUX().nPk.GH());
        this.nOK.c(this.gRo, a.g.ala_liveroom_hostheader, a.g.ala_liveroom_audience_count_layout);
        this.nOK.e(dUX().nPk.bOQ());
        this.nOK.setOtherParams(Md());
    }

    private void bUX() {
        if (this.nOs == null) {
            this.nOs = new com.baidu.tieba.yuyinala.liveroom.operation.a(dUX().pageContext);
        }
        this.nOs.a(dUX(), this.gRp, dUX().nPk.GH().mLiveInfo, true, this.nOT);
        this.nOs.setOtherParams(Md());
    }

    public void mJ(boolean z) {
        if (this.nOs != null) {
            this.nOs.mJ(z);
        }
    }

    private void bVa() {
        if (this.nOM == null) {
            this.nOM = new com.baidu.tieba.yuyinala.liveroom.audiencelist.b(dUX().pageContext.getPageActivity());
        }
        long j = 1;
        if (dUX().nPk.bOQ() != null) {
            j = dUX().nPk.bOQ().getCount();
        }
        this.nOM.a(this.nOT);
        this.nOM.a(this.gRo, a.g.ala_liveroom_audience, j);
        this.nOM.setVisible(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVd() {
        JSONObject jSONObject = new JSONObject();
        try {
            w GH = dUX().nPk.GH();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, GH.aIS.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "miclinkbtn_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVe() {
        JSONObject jSONObject = new JSONObject();
        try {
            w GH = dUX().nPk.GH();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, GH.aIS.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "msgbtn_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVf() {
        JSONObject jSONObject = new JSONObject();
        try {
            w GH = dUX().nPk.GH();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, GH.aIS.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "morefunc_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVg() {
        JSONObject jSONObject = new JSONObject();
        try {
            w GH = dUX().nPk.GH();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, GH.aIS.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "giftbtn_clk").setContentExt(jSONObject));
    }

    public void bVb() {
        this.nOt.c(dUX().nPk.GH(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVh() {
        JSONObject jSONObject = new JSONObject();
        try {
            w GH = dUX().nPk.GH();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, GH.aIS.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "olnumber_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVi() {
        JSONObject jSONObject = new JSONObject();
        try {
            w GH = dUX().nPk.GH();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, GH.aIS.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "closebtn_clk").setContentExt(jSONObject));
    }

    private void bVf() {
        if (this.gRw || this.gRx) {
            if ((TbadkCoreApplication.isLogin() && this.gQJ.Lk().hasText()) || this.gRx) {
                this.gRw = false;
                this.gRx = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.bVG();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void bUY() {
        bUZ();
    }

    private void bUZ() {
        if (this.nOs != null) {
            int i = dUX().nPk.GH().aIA.isUegBlock;
            int i2 = dUX().nPk.GH().aIA.isBlock;
            String str = dUX().nPk.GH().aIA.userName;
            if (i > 0 || i2 > 0) {
                this.nOs.b(true, i, i2, str);
                this.gQJ.a(true, i, i2, str);
                this.nOx.b(true, i, i2, str);
                return;
            }
            this.nOs.b(false, i, i2, str);
            this.gQJ.a(false, i, i2, str);
            this.nOx.b(false, i, i2, str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void s(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        super.s(aVar);
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
        } catch (JSONException e) {
            jSONObject = null;
        }
        if ((aVar.getMsgType() == 12 || aVar.getMsgType() == 13) && jSONObject != null) {
            String optString = jSONObject.optString("content_type");
            if (!"enter_live".equals(optString)) {
                if ("update_liveinfo".equals(optString)) {
                    if (dUX().nPk.GH() != null && dUX().nPk.GH().mLiveInfo != null) {
                        dUX().nPk.a(dUX().nPk.GH().mLiveInfo.live_id, dUX().fromType, dUX().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && dUX().nPk.GH() != null && dUX().nPk.GH().mLiveInfo != null && dUX().nPk.GH().aIA != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == dUX().nPk.GH().aIA.userId && optLong2 == dUX().nPk.GH().mLiveInfo.live_id) {
                        jSONObject.optInt("challenge_status");
                        jSONObject.optLong("challenge_id");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void Hv(String str) {
        if (this.nOJ != null) {
            this.nOJ.Hv(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void ci(boolean z) {
        super.ci(z);
        if (dUX().nPl != null) {
            dUX().nPl.cft();
            dUX().nPl.setLiveViewOnDispatchTouchEventListener(null);
            dUX().nPl.setLiveViewOnTouchEventListener(null);
            dUX().nPl.setOnLiveViewScrollListener(null);
        }
        if (dUX().bmp != null) {
            dUX().bmp.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        bVg();
        if (this.nOs != null) {
            this.nOs.ced();
        }
        if (this.bqg != null) {
            this.bqg.removeAllViews();
            this.bqg = null;
        }
        if (this.gSo != null) {
            this.gSo.removeAllViews();
            this.gSo = null;
        }
        if (this.nOJ != null) {
            this.nOJ.release();
        }
        if (this.nOO != null) {
            this.nOO.CT();
        }
        if (this.nOP != null) {
            this.nOP.CT();
        }
        if (this.nOQ != null) {
            this.nOQ.CT();
        }
        n.dWB().CT();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cg(boolean z) {
        super.cg(z);
        bVg();
        if (this.nOL != null) {
            this.nOL.onDestroy();
        }
        if (this.nOK != null) {
            this.nOK.onDestroy();
        }
        if (this.gQJ != null) {
            this.gQJ.onDestroy();
        }
        if (this.nOs != null) {
            this.nOs.onDestory();
        }
        if (this.nOJ != null) {
            this.nOJ.release();
        }
        if (this.nOO != null) {
            this.nOO.onDestroy();
        }
        if (this.nOP != null) {
            this.nOP.onDestroy();
        }
        if (this.nOQ != null) {
            this.nOQ.onDestroy();
        }
        if (this.nON != null) {
            this.nON.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.nOS);
        MessageManager.getInstance().unRegisterListener(this.gQg);
        MessageManager.getInstance().unRegisterListener(this.gQk);
        MessageManager.getInstance().unRegisterListener(this.gQl);
        MessageManager.getInstance().unRegisterListener(this.gQi);
    }

    private void bVg() {
        if (this.gQJ != null && this.gQJ.Lj().getView() != null && this.gQJ.Lj().getView().getParent() != null) {
            ((ViewGroup) this.gQJ.Lj().getView().getParent()).removeView(this.gQJ.Lj().getView());
        }
        if (this.gPS != null && this.gPS.getParent() != null) {
            ((ViewGroup) this.gPS.getParent()).removeView(this.gPS);
        }
        if (this.gQJ != null && this.gQJ.Lk().getView() != null) {
            this.gRp.removeView(this.gQJ.Lk().getView());
        }
        if (this.gQJ != null) {
            this.gQJ.Lj().setMsgData(new LinkedList());
            this.gQJ.Ct();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void a(ap apVar) {
        if (this.gQJ != null) {
            bVG();
            this.gQJ.Lk().setEditText(" @" + apVar.getNameShow() + " ");
        }
        if (this.nOs != null) {
            this.nOs.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void g(com.baidu.live.data.a aVar) {
        if (this.gQJ != null) {
            bVG();
            this.gQJ.Lk().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.nOs != null) {
            this.nOs.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void b(ap apVar) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected View bVh() {
        if (this.gQJ != null) {
            return this.gQJ.Lk().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public boolean bVi() {
        if (this.gQJ == null || !this.gQJ.Lk().ME()) {
            return false;
        }
        mC(false);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    /* renamed from: bWD */
    public PendantParentView bVk() {
        return this.bqg;
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
                    this.gRt = false;
                    h(null, intExtra, intExtra2, intExtra3);
                    return;
                }
                bVb();
                return;
            }
            ats();
        } else if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            HT(O(intent));
        }
    }

    private void HT(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) dUX().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.nOL != null) {
            this.nOL.HF(fromJson.getSmallurl());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.gQJ != null && this.gQJ.Lj() != null) {
            this.gQJ.Lj().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gQJ == null || this.gQJ.Lk() == null || !this.gQJ.Lk().ME()) {
            if (z) {
                if (this.nOs != null) {
                    this.nOs.setVisibility(8);
                }
                if (this.gQL != null && this.gQL.Gg() != null) {
                    this.gQL.Gg().setVisibility(8);
                }
                bVm();
                if (this.gQJ != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gQJ.Lk().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gQJ.Lk().getView().setLayoutParams(layoutParams);
                    this.gQJ.Lk().getView().setVisibility(0);
                    this.gQJ.Lk().setQuickInputPanelVisible(false);
                }
                if (this.gRo != null) {
                    this.gRo.setVisibility(8);
                }
                if (this.gQK != null) {
                    this.gQK.Cs();
                }
                if (this.nOJ != null) {
                    this.nOJ.setVisible(8);
                }
                if (this.gRk != null) {
                    this.gRk.setCanVisible(false);
                }
            } else {
                bVl();
            }
            bWx();
            if (this.gQW != null) {
                this.gQW.br(z);
            }
        }
    }

    private void bVl() {
        if (this.nOs != null) {
            this.nOs.setVisibility(0);
        }
        if (this.gPS != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPS.getLayoutParams();
            layoutParams.bottomMargin = dUX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120);
            this.gPS.setLayoutParams(layoutParams);
        }
        if (this.gQJ != null) {
            bVH();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gQJ.Lk().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.gQJ.Lk().getView().setLayoutParams(layoutParams2);
        }
        if (this.nOs != null) {
            this.nOs.setVisibility(0);
        }
        if (this.gQL != null && this.gQL.Gg() != null) {
            this.gQL.Gg().setVisibility(0);
        }
        if (this.gRo != null) {
            this.gRo.setVisibility(0);
        }
        if (this.nOJ != null) {
            this.nOJ.setVisible(0);
        }
        if (this.gQK != null) {
            this.gQK.Cs();
        }
        if (this.gRk != null) {
            this.gRk.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVm() {
        boolean z;
        boolean z2 = false;
        if (this.gPS != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPS.getLayoutParams();
            if (this.gQJ == null || this.gQJ.Lk() == null) {
                z = false;
            } else {
                z = this.gQJ.Lk().MC();
                z2 = this.gQJ.Lk().MD();
            }
            int M = M(z, z2);
            if (layoutParams.bottomMargin != M) {
                layoutParams.bottomMargin = M;
                this.gPS.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mC(boolean z) {
        this.gSt = z;
        if (z) {
            this.gQJ.Lk().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPS.getLayoutParams();
            int quickInputPanelExpandHeight = this.gQJ.Lk().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.gPS.setLayoutParams(layoutParams);
                if (this.gQJ.Lj() != null) {
                    this.gQJ.Lj().Li();
                    return;
                }
                return;
            }
            return;
        }
        bVl();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3 && this.nOK != null) {
            this.nOK.dI(i3);
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public boolean eO(int i) {
        return super.eO(i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void vi(int i) {
        super.vi(i);
        if (i == 7 || i == 11) {
            if (this.nOs != null) {
                this.nOs.setVisibility(8);
            }
            if (this.gQJ != null) {
                this.gQJ.Lj().getView().setVisibility(4);
            }
            if (this.nOJ != null) {
                this.nOJ.bK(2, 8);
            }
            if (this.nOA != null) {
                this.nOA.nC(false);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public void eP(int i) {
        super.eP(i);
        if (i == 7 || i == 11) {
            if (this.nOs != null) {
                this.nOs.setVisibility(0);
            }
            if (this.gQJ != null) {
                this.gQJ.Lj().getView().setVisibility(0);
            }
            if (this.nOJ != null) {
                this.nOJ.setVisible(0);
            }
            if (this.nOA != null) {
                this.nOA.nC(true);
            }
            this.gRo.setVisibility(0);
        }
    }

    private void bUP() {
        if (this.nOs != null) {
            this.nOs.a(new a.InterfaceC0895a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.nOJ != null) {
            this.nOJ.onStop();
        }
        if (this.nOO != null) {
            this.nOO.cez();
        }
        if (this.nOP != null) {
            this.nOP.cez();
        }
        if (this.nOQ != null) {
            this.nOQ.cez();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.b.c.dWj().onDestroy();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.nOJ != null) {
            this.nOJ.onStart();
        }
        if (this.nOO != null) {
            this.nOO.cey();
        }
        if (this.nOP != null) {
            this.nOP.cey();
        }
        if (this.nOQ != null) {
            this.nOQ.cey();
        }
    }
}
