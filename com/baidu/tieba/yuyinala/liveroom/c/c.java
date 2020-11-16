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
import com.baidu.live.aa.e;
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
import com.baidu.live.data.aq;
import com.baidu.live.data.bn;
import com.baidu.live.data.cd;
import com.baidu.live.data.cj;
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
    private PendantParentView bpO;
    private com.baidu.live.ak.a gKF;
    private FrameLayout gVD;
    private LinearLayout gYa;
    private com.baidu.tieba.yuyinala.liveroom.activeview.b nWj;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.c nWk;
    private com.baidu.tieba.yuyinala.liveroom.h.b nWl;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.b nWm;
    private g nWn;
    private com.baidu.tieba.yuyinala.liveroom.ranklist.a nWo;
    private com.baidu.tieba.yuyinala.liveroom.introduce.g nWp;
    private com.baidu.tieba.yuyinala.liveroom.charmrank.a nWq;
    private com.baidu.tieba.yuyinala.liveroom.j.a nWr;
    private com.baidu.tieba.yuyinala.liveroom.datingnavigation.a nWs;
    private long lastClickTime = 0;
    private com.baidu.live.liveroom.g.c gVP = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.1
        @Override // com.baidu.live.liveroom.g.c
        public void Ns() {
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cm(boolean z) {
            if (z) {
                if (c.this.nVS != null) {
                    c.this.nVS.MJ(8);
                }
            } else if (c.this.nVS != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                    c.this.nVS.MJ(0);
                } else {
                    c.this.nVS.MJ(8);
                }
            }
            if (c.this.gWH != null) {
                c.this.gWH.bv(z);
            }
        }
    };
    private CustomMessageListener nWt = new CustomMessageListener(2501032) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501032) {
                long currentTimeMillis = System.currentTimeMillis();
                if (c.this.dXw().nWV.Gz() != null && c.this.dXw().nWV.Gz().mLiveInfo != null) {
                    c.this.dXw().nWV.a(c.this.dXw().nWV.Gz().mLiveInfo.live_id, c.this.dXw().fromType, c.this.dXw().enterTime, currentTimeMillis);
                }
            }
        }
    };
    private HttpMessageListener gVR = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.NB() != null) {
                        e.Pv().bss = getQuickGiftHttpResponseMessage.NB();
                        c.this.bWL();
                    }
                }
            }
        }
    };
    CustomMessageListener gVW = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2913168) {
            }
        }
    };
    private CustomMessageListener gVT = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (c.this.nWc != null) {
                    c.this.nWc.hN(str);
                }
            }
        }
    };
    private CustomMessageListener gVV = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (c.this.nVZ != null) {
                    c.this.nVZ.dismiss();
                }
                if (c.this.nWc != null) {
                    c.this.nWc.dismiss();
                }
                d.Lx().setSwitchStatus(true);
                d.Lx().setSelectId((String) customResponsedMessage.getData());
                if (c.this.mHandler == null) {
                    c.this.mHandler = new Handler();
                }
                c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.bXz();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.yuyinala.liveroom.operation.b nWu = new com.baidu.tieba.yuyinala.liveroom.operation.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5
        @Override // com.baidu.tieba.yuyinala.liveroom.operation.b
        public void a(View view, int i, String[] strArr) {
            bn bnVar;
            cd cdVar;
            cj cjVar;
            String str;
            bn bnVar2;
            cd cdVar2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c.this.lastClickTime >= 300) {
                c.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    c.this.dXG();
                    c.this.a(strArr, -1, -1, -1);
                } else if (i == 1) {
                    if (c.this.gWu != null) {
                        c.this.bXz();
                    }
                } else if (i == 3) {
                    c.this.nVT.c(c.this.dXw().nWV.Gz(), false);
                } else if (i == 8) {
                    if (c.this.blV != null) {
                        c.this.blV.cg(false);
                    }
                    c.this.dXI();
                } else if (i != 12) {
                    if (i == 14) {
                        c.this.dXH();
                        w Gz = c.this.dXw().nWV.Gz();
                        if (Gz != null && Gz.aHk != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmCardActivityConfig(c.this.dXw().pageContext.getPageActivity(), Gz.aHk.userName, Long.toString(Gz.aHk.userId), Long.toString(Gz.aHk.charmCount), String.valueOf(Gz.mLiveInfo.group_id), String.valueOf(Gz.mLiveInfo.live_id), false, String.valueOf(Gz.aHk.userId), Long.toString(Gz.aHG.userId), Gz.aHG.userName, Gz.aHG.portrait, 0L, c.this.LU(), Gz.aIh)));
                        }
                    } else if (i == 11) {
                        c.this.bXC();
                        c.this.bXD();
                    } else if (i == 16) {
                        if (c.this.dXw() != null && (bnVar2 = com.baidu.live.aa.a.Ph().bsh) != null && (cdVar2 = bnVar2.aNM) != null) {
                            String str3 = cdVar2.aPh.aPp;
                            if (!TextUtils.isEmpty(str3)) {
                                long j = 0;
                                if (c.this.dXw().nWV != null && c.this.dXw().nWV.Gz() != null && c.this.dXw().nWV.Gz().mLiveInfo != null) {
                                    j = c.this.dXw().nWV.Gz().mLiveInfo.live_id;
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", c.this.dXw().nWV.Gz().mLiveInfo.room_id + "", c.this.dXw().nWV.Gz().mLiveInfo.feed_id, c.this.LU());
                                }
                                if (str3.contains("?")) {
                                    str2 = str3 + "&liveId=" + j;
                                } else {
                                    str2 = str3 + "?liveId=" + j;
                                }
                                if (c.this.gKF == null) {
                                    c.this.gKF = new com.baidu.live.ak.a(c.this.dXw().pageContext.getPageActivity());
                                }
                                com.baidu.live.ak.c cVar = new com.baidu.live.ak.c();
                                cVar.url = str2;
                                c.this.gKF.a(cVar);
                            }
                        }
                    } else if (i == 20) {
                        if (c.this.dXw() != null) {
                            w wVar = null;
                            if (c.this.dXw().nWV != null) {
                                wVar = c.this.dXw().nWV.Gz();
                            }
                            if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.yuyinala.liveroom.n.b.dYs().bmB != null) {
                                String str4 = com.baidu.tieba.yuyinala.liveroom.n.b.dYs().bmB.aIP;
                                if (!TextUtils.isEmpty(str4)) {
                                    if (str4.contains("?")) {
                                        str = str4 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    } else {
                                        str = str4 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    }
                                    if (c.this.gKF == null) {
                                        c.this.gKF = new com.baidu.live.ak.a(c.this.dXw().pageContext.getPageActivity());
                                    }
                                    com.baidu.live.ak.c cVar2 = new com.baidu.live.ak.c();
                                    cVar2.url = str;
                                    c.this.gKF.a(cVar2);
                                }
                            }
                        }
                    } else if (i == 17) {
                        if (c.this.Jd() && c.this.dXw() != null && (bnVar = com.baidu.live.aa.a.Ph().bsh) != null && (cdVar = bnVar.aNM) != null && (cjVar = cdVar.aPi) != null && !TextUtils.isEmpty(cjVar.webUrl) && c.this.nVZ != null && c.this.dXw().nWV != null && c.this.dXw().nWV.Gz() != null && c.this.dXw().nWV.Gz().aHk != null) {
                            w Gz2 = c.this.dXw().nWV.Gz();
                            c.this.nVZ.a(cjVar.webUrl, Gz2.mLiveInfo.live_id, Gz2.aHG.userId, Gz2.aHk.userId);
                        }
                    } else if (i == 22) {
                        c.this.nWr.Y(c.this.dXw().nWV.Gz());
                        c.this.dXF();
                    } else if (i == 23 && c.this.Jd()) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new af(BdBaseApplication.getInst(), String.valueOf(c.this.dXw().nWV.cfQ().live_id), String.valueOf(c.this.dXw().nWV.cfQ().group_id))));
                            c.this.dXE();
                        } catch (Exception e) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(c.this.dXw().pageContext.getPageActivity(), "请稍后重试", 1).show();
                                }
                            });
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.operation.b
        public void a(int i, com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
            if (i == 21 && c.this.Jd()) {
                if (c.this.nWn == null) {
                    c.this.nWn = new g(c.this.dXw().pageContext);
                }
                c.this.nWn.b(eVar);
            }
        }
    };
    private boolean gYf = false;

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
    }

    public void a(w wVar, String str, String str2) {
        this.gYf = false;
        dXw().nWW.setIsForceHandledTouch(false);
        dXw().nWW.setSwipeClearEnable(false);
        dXw().nWW.setOnLiveViewScrollListener(this.gVP);
        if (this.gXb != null) {
            this.gXb.setVisibility(0);
        }
        bYw();
        bWO();
        bWQ();
        bWV();
        dXD();
        dXB();
        dXA();
        bXK();
        R(wVar);
        o.dZz().l(wVar);
        bWD();
        if (wVar != null && wVar.aHZ != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().aL(wVar.aHZ.aRe, str2, str);
        }
    }

    private void R(w wVar) {
        if (this.nWk == null) {
            this.nWk = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(dXw().pageContext, this);
        }
        if (wVar != null && wVar.aHZ != null) {
            this.nWk.UZ(wVar.aHZ.live_id);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        super.l(wVar);
        this.gYf = false;
        dXw().nWW.setIsForceHandledTouch(false);
        dXw().nWW.setSwipeClearEnable(false);
        dXw().nWW.setOnLiveViewScrollListener(this.gVP);
        if (this.gXb != null) {
            this.gXb.setVisibility(0);
        }
        bYw();
        bWO();
        bWP();
        bWT();
        bWQ();
        bWV();
        dXD();
        dXB();
        dXz();
        dXA();
        mP(false);
        bXG();
        bXF();
        bXK();
        bWM();
        bXH();
        bXV();
        bWF();
        bWL();
        bXR();
        bWy();
        bXU();
        c(this.gaF);
        bWI();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().ab(wVar);
        o.dZz().l(wVar);
        MessageManager.getInstance().registerListener(this.nWt);
        MessageManager.getInstance().registerListener(this.gVR);
        MessageManager.getInstance().registerListener(this.gVV);
        MessageManager.getInstance().registerListener(this.gVW);
        MessageManager.getInstance().registerListener(this.gVT);
        bWY();
        bWS();
        bWD();
        dXy();
    }

    private void dXy() {
        o.dZz().a(new o.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.8
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
            public void MA(int i) {
                c.this.bYr();
                c.this.bYs();
            }
        });
    }

    private void dXz() {
        if (dXw().nWV.Gz() != null && dXw().nWV.Gz().aHk != null && dXw().nWV.Gz().mLiveInfo != null) {
            w Gz = dXw().nWV.Gz();
            if (Gz.aIe != null && Gz.aIe.getRoomMode() == 1) {
                if (this.nWs == null) {
                    this.nWs = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(dXw().pageContext);
                }
                this.nWs.U(dXw().nWV.Gz());
                this.nWs.at(this.gXb);
            }
        }
    }

    private void dXA() {
        if (dXw().nWV.Gz() != null && dXw().nWV.Gz().aHk != null && dXw().nWV.Gz().mLiveInfo != null && this.nWr == null) {
            this.nWr = new com.baidu.tieba.yuyinala.liveroom.j.a(dXw().pageContext);
        }
    }

    private void dXB() {
        if (dXw().nWV.Gz() != null && dXw().nWV.Gz().aHk != null && dXw().nWV.Gz().mLiveInfo != null) {
            if (this.nWq == null) {
                this.nWq = new com.baidu.tieba.yuyinala.liveroom.charmrank.a(dXw().pageContext);
            }
            long j = dXw().nWV.Gz().aHk.userId;
            int i = dXw().nWV.Gz().mLiveInfo.live_type;
            String str = dXw().nWV.Gz().aHk.portrait;
            String str2 = dXw().nWV.Gz().mLiveInfo.feed_id;
            long j2 = dXw().nWV.Gz().mLiveInfo.live_id;
            this.nWq.a(i, j, dXw().nWV.Gz().aHk.userName, false, str, LU(), str2, j2);
            this.nWq.at(this.gXb);
            this.nWq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.dXC();
                    w Gz = c.this.dXw().nWV.Gz();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmRankActivityConfig(c.this.dXw().pageContext.getPageActivity(), Gz.aHk.userName, Long.toString(Gz.aHk.userId), Long.toString(Gz.aHk.charmCount), String.valueOf(Gz.aHZ.croom_id), String.valueOf(Gz.mLiveInfo.live_id), false, String.valueOf(Gz.aHk.userId), Long.toString(Gz.aHG.userId), Gz.aHG.userName, Gz.aHG.portrait, 0L, Gz.aHG.userType)));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXC() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Gz = dXw().nWV.Gz();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Gz.aHZ.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "charmlist_clk").setContentExt(jSONObject));
    }

    private void dXD() {
        if (dXw().nWV.Gz() != null && dXw().nWV.Gz().aHk != null && dXw().nWV.Gz().mLiveInfo != null) {
            if (this.nWp == null) {
                this.nWp = new com.baidu.tieba.yuyinala.liveroom.introduce.g(dXw().pageContext);
            }
            this.nWp.U(dXw().nWV.Gz());
            this.nWp.at(this.gXb);
            this.nWp.cCd();
        }
    }

    public void bWV() {
        if (dXw().nWV.Gz() != null && dXw().nWV.Gz().mLiveInfo != null && dXw().nWV.Gz().aHZ != null && dXw().nWV.Gz().aIf) {
            if (this.nWo == null) {
                this.nWo = new com.baidu.tieba.yuyinala.liveroom.ranklist.a(dXw().pageContext);
            }
            String str = dXw().nWV.Gz().aHG.userUk;
            int i = dXw().nWV.Gz().mLiveInfo.live_type;
            String str2 = dXw().nWV.Gz().aHZ.cover;
            String str3 = dXw().nWV.Gz().mLiveInfo.feed_id;
            long j = dXw().nWV.Gz().mLiveInfo.live_id;
            this.nWo.a(i, str, dXw().nWV.Gz().aHk.userName, false, str2, LU(), str3, j, dXw().nWV.Gz().aHZ.croom_id, dXw().nWV.Gz().aHZ.aRj, dXw().nWV.Gz().aHZ.aRe, dXw().nWV.Gz().aHZ.cover, dXw().nWV.Gz().aHZ.room_name);
            this.nWo.at(this.gXb);
            this.nWo.cCd();
        }
    }

    private void bWy() {
        if (this.nWe != null) {
            this.nWe.a(new a.InterfaceC0915a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.10
                @Override // com.baidu.tieba.yuyinala.liveroom.recommend.a.InterfaceC0915a
                public void ct(boolean z) {
                }
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        super.j(wVar);
        if (this.nWl != null) {
            this.nWl.H(wVar);
        }
        S(wVar);
        if (this.nWo != null && wVar != null && wVar.aHZ != null) {
            this.nWo.MN(wVar.aHZ.aRj);
        }
        if (this.nWj != null) {
            this.nWj.i(wVar);
            this.nWj.mI(this.gXl);
            this.nWj.updateView();
            if (wVar != null && this.gWU != null && !this.gWU.hasInit && !TextUtils.isEmpty(this.gWU.aOg)) {
                this.gWU.hasInit = true;
                this.nWj.Hp(this.gWU.aOg);
            }
        }
    }

    private void S(w wVar) {
        if (wVar != null && wVar.aIe != null && wVar.aIe.getRoomMode() == 1) {
            if (this.nWs != null) {
                this.nWs.j(wVar);
            } else if (o.dZz().dZM()) {
                this.nWs = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(dXw().pageContext);
                this.nWs.U(wVar);
                this.nWs.cO(this.gXb);
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.nWs != null) {
                            c.this.nWs.dXL();
                        }
                    }
                }, 1500L);
            } else {
                this.nWs = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(dXw().pageContext);
                this.nWs.U(wVar);
                this.nWs.cO(this.gXb);
                this.nWs.dXL();
            }
        } else if (o.dZz().dZM()) {
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.12
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.nWs != null) {
                        c.this.nWs.onDestroy();
                        c.this.nWs = null;
                    }
                }
            }, 1500L);
        } else if (this.nWs != null) {
            this.nWs.onDestroy();
            this.nWs = null;
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(q qVar) {
        if (qVar != null) {
            if (this.nWk != null && qVar.getList() != null) {
                this.nWk.e(qVar);
            }
            if (this.nWm != null) {
                this.nWm.ew(qVar.getCount());
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dI(int i) {
        super.dI(i);
    }

    private void bWD() {
        if (dXw() != null && dXw().pageContext != null && dXw().pageContext.getPageActivity() != null) {
            if (this.bpO == null) {
                this.bpO = new PendantParentView(dXw().pageContext.getPageActivity(), PendantParentView.Model.VERTICAL);
                dXw().nWW.addView(this.bpO, new ViewGroup.LayoutParams(-1, -1));
                this.bpO.setDefaultItemMargin(dXw().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
                this.bpO.setPadding(dXw().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, dXw().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            }
            bYr();
        }
    }

    private void bWF() {
        if (this.nWj == null) {
            this.nWj = new com.baidu.tieba.yuyinala.liveroom.activeview.b(dXw().pageContext);
        }
        if (dXw() != null && dXw().nWV != null) {
            this.nWj.Hm(dXw().nWV.cfU());
        }
        this.nWj.setOtherParams(LU());
        this.nWj.b(dXw().nWV.Gz(), false);
        this.nWj.setHost(false);
        this.nWj.mI(this.gXl);
        this.nWj.a(1, this.bpO);
        this.nWj.a(2, this.bpO);
        this.nWj.setVisible(this.gXf ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYr() {
        if (this.bpO != null) {
            this.bpO.setModel(dXw().nWV.Gz().aIe.getRoomMode() == 1 ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            this.bpO.setPosition(dXw().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds164), 0, dXw().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200), dXw().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102));
            return;
        }
        bWD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYs() {
        if (this.gWu != null && this.gVD != null && this.gWu.La() != null && this.gWu.La().getView() != null) {
            int J = com.baidu.tieba.yuyinala.liveroom.o.a.J(this.gXf, dXw().nWV.Gz().aIe.getRoomMode());
            if (this.gXc.indexOfChild(this.gVD) != -1 && this.gVD.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVD.getLayoutParams();
                layoutParams.height = J;
                this.gVD.setLayoutParams(layoutParams);
            }
            if (this.gVD.indexOfChild(this.gWu.La().getView()) != -1 && this.gWu.La().getView().getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gWu.La().getView().getLayoutParams();
                layoutParams2.height = J;
                this.gWu.La().getView().setLayoutParams(layoutParams2);
            }
            this.gWu.La().KZ();
        }
    }

    private void bYw() {
        if (this.gYa == null) {
            this.gYa = new LinearLayout(dXw().pageContext.getPageActivity());
            this.gYa.setOrientation(1);
        }
        if (this.gYa.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = dXw().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = dXw().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            dXw().nWW.addView(this.gYa, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWL() {
        if (this.nVS == null) {
            bWQ();
        }
        this.nVS.setOtherParams(LU());
        this.nVS.a(e.Pv().bss, dXw().nWV.Gz());
    }

    private void bXK() {
        if (this.nVY != null && dXw() != null && dXw().nWV != null) {
            this.nVY.c(this.gXb, dXw().nWV.Gz());
        }
    }

    private void bWM() {
        CustomResponsedMessage runTask;
        if (this.gWu == null && (runTask = MessageManager.getInstance().runTask(2501045, k.class, dXw().pageContext)) != null && runTask.getData() != null) {
            this.gWu = (k) runTask.getData();
            this.gWu.setFromMaster(false);
            this.gWu.La().getView().setId(a.f.ala_liveroom_msg_list);
            this.gWu.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4
                @Override // com.baidu.live.im.k.a
                public boolean Ld() {
                    return c.this.Jd();
                }

                @Override // com.baidu.live.im.k.a
                public void Le() {
                    c.this.gXj = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hD(String str) {
                    if (!c.this.gXf) {
                        c.this.mM(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(c.this.dXw().pageContext.getPageActivity(), c.this.dXw().hgj.getLiveContainerView());
                    }
                    c.this.Hs(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Lf() {
                    if (c.this.gXf) {
                        c.this.mM(true);
                        c.this.dXw().hgj.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.dXw().pageContext.getPageActivity(), c.this.dXw().hgj.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.gWu != null) {
                        c.this.gWu.Lb().setQuickInputPanelVisible(false);
                        c.this.gWu.Lb().Mw();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Lg() {
                    if (c.this.gXf) {
                        c.this.bXf();
                        if (c.this.gWv != null) {
                            c.this.gWv.Cc();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Lh() {
                    return c.this.bXt();
                }

                @Override // com.baidu.live.im.k.a
                public int Li() {
                    return c.this.bXu();
                }
            });
            this.gVD = new FrameLayout(dXw().pageContext.getPageActivity());
            this.gVD.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.gWu != null && this.gVD != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(dXw().pageContext.getPageActivity()) * 0.7f);
            int J = com.baidu.tieba.yuyinala.liveroom.o.a.J(false, dXw().nWV.Gz().aIe.getRoomMode());
            if (this.gXc.indexOfChild(this.gVD) < 0) {
                if (this.gVD.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gVD.getParent()).removeView(this.gVD);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, J);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.tieba.yuyinala.liveroom.o.a.cW(false);
                this.gXc.addView(this.gVD, layoutParams);
            }
            if (this.gVD.indexOfChild(this.gWu.La().getView()) < 0) {
                if (this.gWu.La().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gWu.La().getView()).removeView(this.gWu.La().getView());
                }
                this.gVD.addView(this.gWu.La().getView(), new FrameLayout.LayoutParams(equipmentWidth, J));
            }
            if (dXw().nWW.indexOfChild(this.gWu.Lb().getView()) < 0) {
                if (this.gWu.Lb().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gWu.Lb().getView().getParent()).removeView(this.gWu.Lb().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bXA();
                dXw().nWW.addView(this.gWu.Lb().getView(), layoutParams2);
            }
            w Gz = dXw().nWV.Gz();
            if (Gz != null && Gz.mLiveInfo != null) {
                this.gWu.setLogData(Gz.mLiveInfo.feed_id, LU());
            }
            this.gWu.a(String.valueOf(dXw().nWV.Gz().mLiveInfo.group_id), String.valueOf(dXw().nWV.Gz().mLiveInfo.last_msg_id), String.valueOf(dXw().nWV.Gz().aHk.userId), String.valueOf(dXw().nWV.Gz().mLiveInfo.live_id), dXw().nWV.Gz().aHk.appId, (Gz == null || Gz.aHW == null || !Gz.aHW.Dr()) ? false : true);
            mM(false);
        }
    }

    private void bWO() {
        if (this.nWl == null) {
            this.nWl = new com.baidu.tieba.yuyinala.liveroom.h.b(this.activity);
        }
        this.nWl.d(this.gXb, dXw().nWV.Gz());
    }

    private void bWP() {
        if (this.nWk == null) {
            this.nWk = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(dXw().pageContext, this);
        }
        String.valueOf(dXw().nWV.Gz().mLiveInfo.group_id);
        String valueOf = String.valueOf(dXw().nWV.Gz().mLiveInfo.live_id);
        String.valueOf(dXw().nWV.Gz().aHk.userId);
        this.nWk.a(valueOf, dXw().nWV.Gz());
        this.nWk.c(this.gXb, a.f.ala_liveroom_hostheader, a.f.ala_liveroom_audience_count_layout);
        this.nWk.e(dXw().nWV.bQJ());
        this.nWk.setOtherParams(LU());
    }

    private void bWQ() {
        if (this.nVS == null) {
            this.nVS = new com.baidu.tieba.yuyinala.liveroom.operation.a(dXw().pageContext);
        }
        this.nVS.a(dXw(), this.gXc, dXw().nWV.Gz().mLiveInfo, true, this.nWu);
        this.nVS.setOtherParams(LU());
    }

    public void mT(boolean z) {
        if (this.nVS != null) {
            this.nVS.mT(z);
        }
    }

    private void bWT() {
        if (this.nWm == null) {
            this.nWm = new com.baidu.tieba.yuyinala.liveroom.audiencelist.b(dXw().pageContext.getPageActivity());
        }
        long j = 1;
        if (dXw().nWV.bQJ() != null) {
            j = dXw().nWV.bQJ().getCount();
        }
        this.nWm.a(this.nWu);
        this.nWm.a(this.gXb, a.f.ala_liveroom_audience, j);
        this.nWm.setVisible(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXE() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Gz = dXw().nWV.Gz();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Gz.aHZ.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "msgbtn_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXF() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Gz = dXw().nWV.Gz();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Gz.aHZ.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "morefunc_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXG() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Gz = dXw().nWV.Gz();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Gz.aHZ.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "giftbtn_clk").setContentExt(jSONObject));
    }

    public void bWU() {
        this.nVT.c(dXw().nWV.Gz(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXH() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Gz = dXw().nWV.Gz();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Gz.aHZ.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "olnumber_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXI() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Gz = dXw().nWV.Gz();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Gz.aHZ.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "closebtn_clk").setContentExt(jSONObject));
    }

    private void bWY() {
        if (this.gXj || this.gXk) {
            if ((TbadkCoreApplication.isLogin() && this.gWu.Lb().hasText()) || this.gXk) {
                this.gXj = false;
                this.gXk = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.bXz();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void bWR() {
        bWS();
    }

    private void bWS() {
        if (this.nVS != null) {
            int i = dXw().nWV.Gz().aHG.isUegBlock;
            int i2 = dXw().nWV.Gz().aHG.isBlock;
            String str = dXw().nWV.Gz().aHG.userName;
            if (i > 0 || i2 > 0) {
                this.nVS.b(true, i, i2, str);
                this.gWu.a(true, i, i2, str);
                this.nVX.b(true, i, i2, str);
                return;
            }
            this.nVS.b(false, i, i2, str);
            this.gWu.a(false, i, i2, str);
            this.nVX.b(false, i, i2, str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void t(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        super.t(aVar);
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
                    if (dXw().nWV.Gz() != null && dXw().nWV.Gz().mLiveInfo != null) {
                        dXw().nWV.a(dXw().nWV.Gz().mLiveInfo.live_id, dXw().fromType, dXw().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && dXw().nWV.Gz() != null && dXw().nWV.Gz().mLiveInfo != null && dXw().nWV.Gz().aHG != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == dXw().nWV.Gz().aHG.userId && optLong2 == dXw().nWV.Gz().mLiveInfo.live_id) {
                        jSONObject.optInt("challenge_status");
                        jSONObject.optLong("challenge_id");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void Ho(String str) {
        if (this.nWj != null) {
            this.nWj.Ho(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void cl(boolean z) {
        super.cl(z);
        if (dXw().nWW != null) {
            dXw().nWW.chp();
            dXw().nWW.setLiveViewOnDispatchTouchEventListener(null);
            dXw().nWW.setLiveViewOnTouchEventListener(null);
            dXw().nWW.setOnLiveViewScrollListener(null);
        }
        if (dXw().blY != null) {
            dXw().blY.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        bWZ();
        if (this.nVS != null) {
            this.nVS.cfX();
        }
        if (this.nWs != null) {
            this.nWs.CD();
        }
        if (this.bpO != null) {
            this.bpO.removeAllViews();
            this.bpO = null;
        }
        if (this.gYa != null) {
            this.gYa.removeAllViews();
            this.gYa = null;
        }
        if (this.nWj != null) {
            this.nWj.release();
        }
        if (this.nWo != null) {
            this.nWo.CD();
        }
        if (this.nWp != null) {
            this.nWp.CD();
        }
        if (this.nWq != null) {
            this.nWq.CD();
        }
        o.dZz().CD();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cj(boolean z) {
        super.cj(z);
        bWZ();
        if (this.nWl != null) {
            this.nWl.onDestroy();
        }
        if (this.nWk != null) {
            this.nWk.onDestroy();
        }
        if (this.gWu != null) {
            this.gWu.onDestroy();
        }
        if (this.nVS != null) {
            this.nVS.onDestory();
        }
        if (this.nWj != null) {
            this.nWj.release();
        }
        if (this.nWo != null) {
            this.nWo.onDestroy();
        }
        if (this.nWp != null) {
            this.nWp.onDestroy();
        }
        if (this.nWq != null) {
            this.nWq.onDestroy();
        }
        if (this.nWn != null) {
            this.nWn.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.nWt);
        MessageManager.getInstance().unRegisterListener(this.gVR);
        MessageManager.getInstance().unRegisterListener(this.gVV);
        MessageManager.getInstance().unRegisterListener(this.gVW);
        MessageManager.getInstance().unRegisterListener(this.gVT);
    }

    private void bWZ() {
        if (this.gWu != null && this.gWu.La().getView() != null && this.gWu.La().getView().getParent() != null) {
            ((ViewGroup) this.gWu.La().getView().getParent()).removeView(this.gWu.La().getView());
        }
        if (this.gVD != null && this.gVD.getParent() != null) {
            ((ViewGroup) this.gVD.getParent()).removeView(this.gVD);
        }
        if (this.gWu != null && this.gWu.Lb().getView() != null) {
            this.gXc.removeView(this.gWu.Lb().getView());
        }
        if (this.gWu != null) {
            this.gWu.La().setMsgData(new LinkedList());
            this.gWu.Cd();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void a(aq aqVar) {
        if (this.gWu != null) {
            bXz();
            this.gWu.Lb().setEditText(" @" + aqVar.getNameShow() + " ");
        }
        if (this.nVS != null) {
            this.nVS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void g(com.baidu.live.data.a aVar) {
        if (this.gWu != null) {
            bXz();
            this.gWu.Lb().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.nVS != null) {
            this.nVS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void b(aq aqVar) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected View bXa() {
        if (this.gWu != null) {
            return this.gWu.Lb().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public boolean bXb() {
        if (this.gWu == null || !this.gWu.Lb().Mv()) {
            return false;
        }
        mM(false);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    /* renamed from: bYy */
    public PendantParentView bXd() {
        return this.bpO;
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
                    this.gXg = false;
                    a(null, intExtra, intExtra2, intExtra3);
                    return;
                }
                bWU();
                return;
            }
            avk();
        } else if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            HL(O(intent));
        }
    }

    private void HL(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) dXw().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.nWl != null) {
            this.nWl.Hy(fromJson.getSmallurl());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.gWu != null && this.gWu.La() != null) {
            this.gWu.La().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gWu == null || this.gWu.Lb() == null || !this.gWu.Lb().Mv()) {
            if (z) {
                if (this.nVS != null) {
                    this.nVS.setVisibility(8);
                }
                if (this.gWw != null && this.gWw.FY() != null) {
                    this.gWw.FY().setVisibility(8);
                }
                bXf();
                if (this.gWu != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gWu.Lb().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gWu.Lb().getView().setLayoutParams(layoutParams);
                    this.gWu.Lb().getView().setVisibility(0);
                    this.gWu.Lb().setQuickInputPanelVisible(false);
                }
                if (this.gXb != null) {
                    this.gXb.setVisibility(8);
                }
                if (this.gWv != null) {
                    this.gWv.Cc();
                }
                if (this.nWj != null) {
                    this.nWj.setVisible(8);
                }
                if (this.gWV != null) {
                    this.gWV.setCanVisible(false);
                }
            } else {
                bXe();
            }
            bYs();
            if (this.gWH != null) {
                this.gWH.bu(z);
            }
        }
    }

    private void bXe() {
        if (this.nVS != null) {
            this.nVS.setVisibility(0);
        }
        if (this.gVD != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVD.getLayoutParams();
            layoutParams.bottomMargin = dXw().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds120);
            this.gVD.setLayoutParams(layoutParams);
        }
        if (this.gWu != null) {
            bXA();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gWu.Lb().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.gWu.Lb().getView().setLayoutParams(layoutParams2);
        }
        if (this.nVS != null) {
            this.nVS.setVisibility(0);
        }
        if (this.gWw != null && this.gWw.FY() != null) {
            this.gWw.FY().setVisibility(0);
        }
        if (this.gXb != null) {
            this.gXb.setVisibility(0);
        }
        if (this.nWj != null) {
            this.nWj.setVisible(0);
        }
        if (this.gWv != null) {
            this.gWv.Cc();
        }
        if (this.gWV != null) {
            this.gWV.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXf() {
        boolean z;
        boolean z2 = false;
        if (this.gVD != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVD.getLayoutParams();
            if (this.gWu == null || this.gWu.Lb() == null) {
                z = false;
            } else {
                z = this.gWu.Lb().Mt();
                z2 = this.gWu.Lb().Mu();
            }
            int M = M(z, z2);
            if (layoutParams.bottomMargin != M) {
                layoutParams.bottomMargin = M;
                this.gVD.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mM(boolean z) {
        this.gYf = z;
        if (z) {
            this.gWu.Lb().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVD.getLayoutParams();
            int quickInputPanelExpandHeight = this.gWu.Lb().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.gVD.setLayoutParams(layoutParams);
                if (this.gWu.La() != null) {
                    this.gWu.La().KZ();
                    return;
                }
                return;
            }
            return;
        }
        bXe();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3 && this.nWk != null) {
            this.nWk.dE(i3);
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public boolean eK(int i) {
        return super.eK(i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void vT(int i) {
        super.vT(i);
        if (i == 7 || i == 11) {
            if (this.nVS != null) {
                this.nVS.setVisibility(8);
            }
            if (this.gWu != null) {
                this.gWu.La().getView().setVisibility(4);
            }
            if (this.nWj != null) {
                this.nWj.bM(2, 8);
            }
            if (this.nWa != null) {
                this.nWa.nM(false);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public void eL(int i) {
        super.eL(i);
        if (i == 7 || i == 11) {
            if (this.nVS != null) {
                this.nVS.setVisibility(0);
            }
            if (this.gWu != null) {
                this.gWu.La().getView().setVisibility(0);
            }
            if (this.nWj != null) {
                this.nWj.setVisible(0);
            }
            if (this.nWa != null) {
                this.nWa.nM(true);
            }
            this.gXb.setVisibility(0);
        }
    }

    private void bWI() {
        if (this.nVS != null) {
            this.nVS.a(new a.InterfaceC0914a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.nWj != null) {
            this.nWj.onStop();
        }
        if (this.nWo != null) {
            this.nWo.cgv();
        }
        if (this.nWp != null) {
            this.nWp.cgv();
        }
        if (this.nWq != null) {
            this.nWq.cgv();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.dZh().onDestroy();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.nWj != null) {
            this.nWj.onStart();
        }
        if (this.nWo != null) {
            this.nWo.cgu();
        }
        if (this.nWp != null) {
            this.nWp.cgu();
        }
        if (this.nWq != null) {
            this.nWq.cgu();
        }
    }
}
