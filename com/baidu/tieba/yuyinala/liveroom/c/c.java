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
    private PendantParentView brz;
    private com.baidu.live.ak.a gKY;
    private FrameLayout gVW;
    private LinearLayout gYt;
    private com.baidu.tieba.yuyinala.liveroom.activeview.b nUG;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.c nUH;
    private com.baidu.tieba.yuyinala.liveroom.h.b nUI;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.b nUJ;
    private g nUK;
    private com.baidu.tieba.yuyinala.liveroom.ranklist.a nUL;
    private com.baidu.tieba.yuyinala.liveroom.introduce.g nUM;
    private com.baidu.tieba.yuyinala.liveroom.charmrank.a nUN;
    private com.baidu.tieba.yuyinala.liveroom.j.a nUO;
    private com.baidu.tieba.yuyinala.liveroom.datingnavigation.a nUP;
    private long lastClickTime = 0;
    private com.baidu.live.liveroom.g.c gWi = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.1
        @Override // com.baidu.live.liveroom.g.c
        public void Ob() {
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ck(boolean z) {
            if (z) {
                if (c.this.nUp != null) {
                    c.this.nUp.Mg(8);
                }
            } else if (c.this.nUp != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                    c.this.nUp.Mg(0);
                } else {
                    c.this.nUp.Mg(8);
                }
            }
            if (c.this.gXa != null) {
                c.this.gXa.bt(z);
            }
        }
    };
    private CustomMessageListener nUQ = new CustomMessageListener(2501032) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501032) {
                long currentTimeMillis = System.currentTimeMillis();
                if (c.this.dXx().nVs.Hi() != null && c.this.dXx().nVs.Hi().mLiveInfo != null) {
                    c.this.dXx().nVs.a(c.this.dXx().nVs.Hi().mLiveInfo.live_id, c.this.dXx().fromType, c.this.dXx().enterTime, currentTimeMillis);
                }
            }
        }
    };
    private HttpMessageListener gWk = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Ok() != null) {
                        e.Qe().bue = getQuickGiftHttpResponseMessage.Ok();
                        c.this.bXs();
                    }
                }
            }
        }
    };
    CustomMessageListener gWp = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2913168) {
            }
        }
    };
    private CustomMessageListener gWm = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (c.this.nUz != null) {
                    c.this.nUz.hT(str);
                }
            }
        }
    };
    private CustomMessageListener gWo = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (c.this.nUw != null) {
                    c.this.nUw.dismiss();
                }
                if (c.this.nUz != null) {
                    c.this.nUz.dismiss();
                }
                d.Mg().setSwitchStatus(true);
                d.Mg().setSelectId((String) customResponsedMessage.getData());
                if (c.this.mHandler == null) {
                    c.this.mHandler = new Handler();
                }
                c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.bYg();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.yuyinala.liveroom.operation.b nUR = new com.baidu.tieba.yuyinala.liveroom.operation.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5
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
                    c.this.dXH();
                    c.this.a(strArr, -1, -1, -1);
                } else if (i == 1) {
                    if (c.this.gWN != null) {
                        c.this.bYg();
                    }
                } else if (i == 3) {
                    c.this.nUq.c(c.this.dXx().nVs.Hi(), false);
                } else if (i == 8) {
                    if (c.this.bnG != null) {
                        c.this.bnG.ce(false);
                    }
                    c.this.dXJ();
                } else if (i != 12) {
                    if (i == 14) {
                        c.this.dXI();
                        w Hi = c.this.dXx().nVs.Hi();
                        if (Hi != null && Hi.aIV != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmCardActivityConfig(c.this.dXx().pageContext.getPageActivity(), Hi.aIV.userName, Long.toString(Hi.aIV.userId), Long.toString(Hi.aIV.charmCount), String.valueOf(Hi.mLiveInfo.group_id), String.valueOf(Hi.mLiveInfo.live_id), false, String.valueOf(Hi.aIV.userId), Long.toString(Hi.aJr.userId), Hi.aJr.userName, Hi.aJr.portrait, 0L, c.this.MD(), Hi.aJS)));
                        }
                    } else if (i == 11) {
                        c.this.bYj();
                        c.this.bYk();
                    } else if (i == 16) {
                        if (c.this.dXx() != null && (bnVar2 = com.baidu.live.aa.a.PQ().btT) != null && (cdVar2 = bnVar2.aPx) != null) {
                            String str3 = cdVar2.aQS.aRa;
                            if (!TextUtils.isEmpty(str3)) {
                                long j = 0;
                                if (c.this.dXx().nVs != null && c.this.dXx().nVs.Hi() != null && c.this.dXx().nVs.Hi().mLiveInfo != null) {
                                    j = c.this.dXx().nVs.Hi().mLiveInfo.live_id;
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", c.this.dXx().nVs.Hi().mLiveInfo.room_id + "", c.this.dXx().nVs.Hi().mLiveInfo.feed_id, c.this.MD());
                                }
                                if (str3.contains("?")) {
                                    str2 = str3 + "&liveId=" + j;
                                } else {
                                    str2 = str3 + "?liveId=" + j;
                                }
                                if (c.this.gKY == null) {
                                    c.this.gKY = new com.baidu.live.ak.a(c.this.dXx().pageContext.getPageActivity());
                                }
                                com.baidu.live.ak.c cVar = new com.baidu.live.ak.c();
                                cVar.url = str2;
                                c.this.gKY.a(cVar);
                            }
                        }
                    } else if (i == 20) {
                        if (c.this.dXx() != null) {
                            w wVar = null;
                            if (c.this.dXx().nVs != null) {
                                wVar = c.this.dXx().nVs.Hi();
                            }
                            if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.yuyinala.liveroom.n.b.dYt().bom != null) {
                                String str4 = com.baidu.tieba.yuyinala.liveroom.n.b.dYt().bom.aKA;
                                if (!TextUtils.isEmpty(str4)) {
                                    if (str4.contains("?")) {
                                        str = str4 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    } else {
                                        str = str4 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    }
                                    if (c.this.gKY == null) {
                                        c.this.gKY = new com.baidu.live.ak.a(c.this.dXx().pageContext.getPageActivity());
                                    }
                                    com.baidu.live.ak.c cVar2 = new com.baidu.live.ak.c();
                                    cVar2.url = str;
                                    c.this.gKY.a(cVar2);
                                }
                            }
                        }
                    } else if (i == 17) {
                        if (c.this.JM() && c.this.dXx() != null && (bnVar = com.baidu.live.aa.a.PQ().btT) != null && (cdVar = bnVar.aPx) != null && (cjVar = cdVar.aQT) != null && !TextUtils.isEmpty(cjVar.webUrl) && c.this.nUw != null && c.this.dXx().nVs != null && c.this.dXx().nVs.Hi() != null && c.this.dXx().nVs.Hi().aIV != null) {
                            w Hi2 = c.this.dXx().nVs.Hi();
                            c.this.nUw.a(cjVar.webUrl, Hi2.mLiveInfo.live_id, Hi2.aJr.userId, Hi2.aIV.userId);
                        }
                    } else if (i == 22) {
                        c.this.nUO.Y(c.this.dXx().nVs.Hi());
                        c.this.dXG();
                    } else if (i == 23 && c.this.JM()) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new af(BdBaseApplication.getInst(), String.valueOf(c.this.dXx().nVs.cgx().live_id), String.valueOf(c.this.dXx().nVs.cgx().group_id))));
                            c.this.dXF();
                        } catch (Exception e) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(c.this.dXx().pageContext.getPageActivity(), "请稍后重试", 1).show();
                                }
                            });
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.operation.b
        public void a(int i, com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
            if (i == 21 && c.this.JM()) {
                if (c.this.nUK == null) {
                    c.this.nUK = new g(c.this.dXx().pageContext);
                }
                c.this.nUK.b(eVar);
            }
        }
    };
    private boolean gYy = false;

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
    }

    public void a(w wVar, String str, String str2) {
        this.gYy = false;
        dXx().nVt.setIsForceHandledTouch(false);
        dXx().nVt.setSwipeClearEnable(false);
        dXx().nVt.setOnLiveViewScrollListener(this.gWi);
        if (this.gXu != null) {
            this.gXu.setVisibility(0);
        }
        bZd();
        bXv();
        bXx();
        bXC();
        dXE();
        dXC();
        dXB();
        bYr();
        R(wVar);
        o.dZA().l(wVar);
        bXk();
        if (wVar != null && wVar.aJK != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().aL(wVar.aJK.aSP, str2, str);
        }
    }

    private void R(w wVar) {
        if (this.nUH == null) {
            this.nUH = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(dXx().pageContext, this);
        }
        if (wVar != null && wVar.aJK != null) {
            this.nUH.Vo(wVar.aJK.live_id);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        super.l(wVar);
        this.gYy = false;
        dXx().nVt.setIsForceHandledTouch(false);
        dXx().nVt.setSwipeClearEnable(false);
        dXx().nVt.setOnLiveViewScrollListener(this.gWi);
        if (this.gXu != null) {
            this.gXu.setVisibility(0);
        }
        bZd();
        bXv();
        bXw();
        bXA();
        bXx();
        bXC();
        dXE();
        dXC();
        dXA();
        dXB();
        mO(false);
        bYn();
        bYm();
        bYr();
        bXt();
        bYo();
        bYC();
        bXm();
        bXs();
        bYy();
        bXf();
        bYB();
        c(this.gaY);
        bXp();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().ab(wVar);
        o.dZA().l(wVar);
        MessageManager.getInstance().registerListener(this.nUQ);
        MessageManager.getInstance().registerListener(this.gWk);
        MessageManager.getInstance().registerListener(this.gWo);
        MessageManager.getInstance().registerListener(this.gWp);
        MessageManager.getInstance().registerListener(this.gWm);
        bXF();
        bXz();
        bXk();
        dXz();
    }

    private void dXz() {
        o.dZA().a(new o.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.8
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
            public void LX(int i) {
                c.this.bYY();
                c.this.bYZ();
            }
        });
    }

    private void dXA() {
        if (dXx().nVs.Hi() != null && dXx().nVs.Hi().aIV != null && dXx().nVs.Hi().mLiveInfo != null) {
            w Hi = dXx().nVs.Hi();
            if (Hi.aJP != null && Hi.aJP.getRoomMode() == 1) {
                if (this.nUP == null) {
                    this.nUP = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(dXx().pageContext);
                }
                this.nUP.U(dXx().nVs.Hi());
                this.nUP.ax(this.gXu);
            }
        }
    }

    private void dXB() {
        if (dXx().nVs.Hi() != null && dXx().nVs.Hi().aIV != null && dXx().nVs.Hi().mLiveInfo != null && this.nUO == null) {
            this.nUO = new com.baidu.tieba.yuyinala.liveroom.j.a(dXx().pageContext);
        }
    }

    private void dXC() {
        if (dXx().nVs.Hi() != null && dXx().nVs.Hi().aIV != null && dXx().nVs.Hi().mLiveInfo != null) {
            if (this.nUN == null) {
                this.nUN = new com.baidu.tieba.yuyinala.liveroom.charmrank.a(dXx().pageContext);
            }
            long j = dXx().nVs.Hi().aIV.userId;
            int i = dXx().nVs.Hi().mLiveInfo.live_type;
            String str = dXx().nVs.Hi().aIV.portrait;
            String str2 = dXx().nVs.Hi().mLiveInfo.feed_id;
            long j2 = dXx().nVs.Hi().mLiveInfo.live_id;
            this.nUN.a(i, j, dXx().nVs.Hi().aIV.userName, false, str, MD(), str2, j2);
            this.nUN.ax(this.gXu);
            this.nUN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.dXD();
                    w Hi = c.this.dXx().nVs.Hi();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmRankActivityConfig(c.this.dXx().pageContext.getPageActivity(), Hi.aIV.userName, Long.toString(Hi.aIV.userId), Long.toString(Hi.aIV.charmCount), String.valueOf(Hi.aJK.croom_id), String.valueOf(Hi.mLiveInfo.live_id), false, String.valueOf(Hi.aIV.userId), Long.toString(Hi.aJr.userId), Hi.aJr.userName, Hi.aJr.portrait, 0L, Hi.aJr.userType)));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXD() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Hi = dXx().nVs.Hi();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Hi.aJK.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "charmlist_clk").setContentExt(jSONObject));
    }

    private void dXE() {
        if (dXx().nVs.Hi() != null && dXx().nVs.Hi().aIV != null && dXx().nVs.Hi().mLiveInfo != null) {
            if (this.nUM == null) {
                this.nUM = new com.baidu.tieba.yuyinala.liveroom.introduce.g(dXx().pageContext);
            }
            this.nUM.U(dXx().nVs.Hi());
            this.nUM.ax(this.gXu);
            this.nUM.cCz();
        }
    }

    public void bXC() {
        if (dXx().nVs.Hi() != null && dXx().nVs.Hi().mLiveInfo != null && dXx().nVs.Hi().aJK != null && dXx().nVs.Hi().aJQ) {
            if (this.nUL == null) {
                this.nUL = new com.baidu.tieba.yuyinala.liveroom.ranklist.a(dXx().pageContext);
            }
            String str = dXx().nVs.Hi().aJr.userUk;
            int i = dXx().nVs.Hi().mLiveInfo.live_type;
            String str2 = dXx().nVs.Hi().aJK.cover;
            String str3 = dXx().nVs.Hi().mLiveInfo.feed_id;
            long j = dXx().nVs.Hi().mLiveInfo.live_id;
            this.nUL.a(i, str, dXx().nVs.Hi().aIV.userName, false, str2, MD(), str3, j, dXx().nVs.Hi().aJK.croom_id, dXx().nVs.Hi().aJK.aSU, dXx().nVs.Hi().aJK.aSP, dXx().nVs.Hi().aJK.cover, dXx().nVs.Hi().aJK.room_name);
            this.nUL.ax(this.gXu);
            this.nUL.cCz();
        }
    }

    private void bXf() {
        if (this.nUB != null) {
            this.nUB.a(new a.InterfaceC0912a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.10
                @Override // com.baidu.tieba.yuyinala.liveroom.recommend.a.InterfaceC0912a
                public void cr(boolean z) {
                }
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        super.j(wVar);
        if (this.nUI != null) {
            this.nUI.H(wVar);
        }
        S(wVar);
        if (this.nUL != null && wVar != null && wVar.aJK != null) {
            this.nUL.Mk(wVar.aJK.aSU);
        }
        if (this.nUG != null) {
            this.nUG.i(wVar);
            this.nUG.mH(this.gXE);
            this.nUG.updateView();
            if (wVar != null && this.gXn != null && !this.gXn.hasInit && !TextUtils.isEmpty(this.gXn.aPR)) {
                this.gXn.hasInit = true;
                this.nUG.HO(this.gXn.aPR);
            }
        }
    }

    private void S(w wVar) {
        if (wVar != null && wVar.aJP != null && wVar.aJP.getRoomMode() == 1) {
            if (this.nUP != null) {
                this.nUP.j(wVar);
            } else if (o.dZA().dZN()) {
                this.nUP = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(dXx().pageContext);
                this.nUP.U(wVar);
                this.nUP.cS(this.gXu);
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.nUP != null) {
                            c.this.nUP.dXM();
                        }
                    }
                }, 1500L);
            } else {
                this.nUP = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(dXx().pageContext);
                this.nUP.U(wVar);
                this.nUP.cS(this.gXu);
                this.nUP.dXM();
            }
        } else if (o.dZA().dZN()) {
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.12
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.nUP != null) {
                        c.this.nUP.onDestroy();
                        c.this.nUP = null;
                    }
                }
            }, 1500L);
        } else if (this.nUP != null) {
            this.nUP.onDestroy();
            this.nUP = null;
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(q qVar) {
        if (qVar != null) {
            if (this.nUH != null && qVar.getList() != null) {
                this.nUH.e(qVar);
            }
            if (this.nUJ != null) {
                this.nUJ.ew(qVar.getCount());
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dM(int i) {
        super.dM(i);
    }

    private void bXk() {
        if (dXx() != null && dXx().pageContext != null && dXx().pageContext.getPageActivity() != null) {
            if (this.brz == null) {
                this.brz = new PendantParentView(dXx().pageContext.getPageActivity(), PendantParentView.Model.VERTICAL);
                dXx().nVt.addView(this.brz, new ViewGroup.LayoutParams(-1, -1));
                this.brz.setDefaultItemMargin(dXx().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
                this.brz.setPadding(dXx().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, dXx().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            }
            bYY();
        }
    }

    private void bXm() {
        if (this.nUG == null) {
            this.nUG = new com.baidu.tieba.yuyinala.liveroom.activeview.b(dXx().pageContext);
        }
        if (dXx() != null && dXx().nVs != null) {
            this.nUG.HL(dXx().nVs.cgB());
        }
        this.nUG.setOtherParams(MD());
        this.nUG.b(dXx().nVs.Hi(), false);
        this.nUG.setHost(false);
        this.nUG.mH(this.gXE);
        this.nUG.a(1, this.brz);
        this.nUG.a(2, this.brz);
        this.nUG.setVisible(this.gXy ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYY() {
        if (this.brz != null) {
            this.brz.setModel(dXx().nVs.Hi().aJP.getRoomMode() == 1 ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            this.brz.setPosition(dXx().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds164), 0, dXx().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200), dXx().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102));
            return;
        }
        bXk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYZ() {
        if (this.gWN != null && this.gVW != null && this.gWN.LJ() != null && this.gWN.LJ().getView() != null) {
            int K = com.baidu.tieba.yuyinala.liveroom.o.a.K(this.gXy, dXx().nVs.Hi().aJP.getRoomMode());
            if (this.gXv.indexOfChild(this.gVW) != -1 && this.gVW.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVW.getLayoutParams();
                layoutParams.height = K;
                this.gVW.setLayoutParams(layoutParams);
            }
            if (this.gVW.indexOfChild(this.gWN.LJ().getView()) != -1 && this.gWN.LJ().getView().getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gWN.LJ().getView().getLayoutParams();
                layoutParams2.height = K;
                this.gWN.LJ().getView().setLayoutParams(layoutParams2);
            }
            this.gWN.LJ().LI();
        }
    }

    private void bZd() {
        if (this.gYt == null) {
            this.gYt = new LinearLayout(dXx().pageContext.getPageActivity());
            this.gYt.setOrientation(1);
        }
        if (this.gYt.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = dXx().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = dXx().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            dXx().nVt.addView(this.gYt, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXs() {
        if (this.nUp == null) {
            bXx();
        }
        this.nUp.setOtherParams(MD());
        this.nUp.a(e.Qe().bue, dXx().nVs.Hi());
    }

    private void bYr() {
        if (this.nUv != null && dXx() != null && dXx().nVs != null) {
            this.nUv.c(this.gXu, dXx().nVs.Hi());
        }
    }

    private void bXt() {
        CustomResponsedMessage runTask;
        if (this.gWN == null && (runTask = MessageManager.getInstance().runTask(2501045, k.class, dXx().pageContext)) != null && runTask.getData() != null) {
            this.gWN = (k) runTask.getData();
            this.gWN.setFromMaster(false);
            this.gWN.LJ().getView().setId(a.f.ala_liveroom_msg_list);
            this.gWN.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4
                @Override // com.baidu.live.im.k.a
                public boolean LM() {
                    return c.this.JM();
                }

                @Override // com.baidu.live.im.k.a
                public void LN() {
                    c.this.gXC = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hJ(String str) {
                    if (!c.this.gXy) {
                        c.this.mL(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(c.this.dXx().pageContext.getPageActivity(), c.this.dXx().hgC.getLiveContainerView());
                    }
                    c.this.HR(str);
                }

                @Override // com.baidu.live.im.k.a
                public void LO() {
                    if (c.this.gXy) {
                        c.this.mL(true);
                        c.this.dXx().hgC.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.dXx().pageContext.getPageActivity(), c.this.dXx().hgC.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.gWN != null) {
                        c.this.gWN.LK().setQuickInputPanelVisible(false);
                        c.this.gWN.LK().Nf();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void LP() {
                    if (c.this.gXy) {
                        c.this.bXM();
                        if (c.this.gWO != null) {
                            c.this.gWO.CL();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean LQ() {
                    return c.this.bYa();
                }

                @Override // com.baidu.live.im.k.a
                public int LR() {
                    return c.this.bYb();
                }
            });
            this.gVW = new FrameLayout(dXx().pageContext.getPageActivity());
            this.gVW.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.gWN != null && this.gVW != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(dXx().pageContext.getPageActivity()) * 0.7f);
            int K = com.baidu.tieba.yuyinala.liveroom.o.a.K(false, dXx().nVs.Hi().aJP.getRoomMode());
            if (this.gXv.indexOfChild(this.gVW) < 0) {
                if (this.gVW.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gVW.getParent()).removeView(this.gVW);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, K);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.tieba.yuyinala.liveroom.o.a.cU(false);
                this.gXv.addView(this.gVW, layoutParams);
            }
            if (this.gVW.indexOfChild(this.gWN.LJ().getView()) < 0) {
                if (this.gWN.LJ().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gWN.LJ().getView()).removeView(this.gWN.LJ().getView());
                }
                this.gVW.addView(this.gWN.LJ().getView(), new FrameLayout.LayoutParams(equipmentWidth, K));
            }
            if (dXx().nVt.indexOfChild(this.gWN.LK().getView()) < 0) {
                if (this.gWN.LK().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gWN.LK().getView().getParent()).removeView(this.gWN.LK().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bYh();
                dXx().nVt.addView(this.gWN.LK().getView(), layoutParams2);
            }
            w Hi = dXx().nVs.Hi();
            if (Hi != null && Hi.mLiveInfo != null) {
                this.gWN.setLogData(Hi.mLiveInfo.feed_id, MD());
            }
            this.gWN.a(String.valueOf(dXx().nVs.Hi().mLiveInfo.group_id), String.valueOf(dXx().nVs.Hi().mLiveInfo.last_msg_id), String.valueOf(dXx().nVs.Hi().aIV.userId), String.valueOf(dXx().nVs.Hi().mLiveInfo.live_id), dXx().nVs.Hi().aIV.appId, (Hi == null || Hi.aJH == null || !Hi.aJH.Ea()) ? false : true);
            mL(false);
        }
    }

    private void bXv() {
        if (this.nUI == null) {
            this.nUI = new com.baidu.tieba.yuyinala.liveroom.h.b(this.activity);
        }
        this.nUI.d(this.gXu, dXx().nVs.Hi());
    }

    private void bXw() {
        if (this.nUH == null) {
            this.nUH = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(dXx().pageContext, this);
        }
        String.valueOf(dXx().nVs.Hi().mLiveInfo.group_id);
        String valueOf = String.valueOf(dXx().nVs.Hi().mLiveInfo.live_id);
        String.valueOf(dXx().nVs.Hi().aIV.userId);
        this.nUH.a(valueOf, dXx().nVs.Hi());
        this.nUH.c(this.gXu, a.f.ala_liveroom_hostheader, a.f.ala_liveroom_audience_count_layout);
        this.nUH.e(dXx().nVs.bRq());
        this.nUH.setOtherParams(MD());
    }

    private void bXx() {
        if (this.nUp == null) {
            this.nUp = new com.baidu.tieba.yuyinala.liveroom.operation.a(dXx().pageContext);
        }
        this.nUp.a(dXx(), this.gXv, dXx().nVs.Hi().mLiveInfo, true, this.nUR);
        this.nUp.setOtherParams(MD());
    }

    public void mS(boolean z) {
        if (this.nUp != null) {
            this.nUp.mS(z);
        }
    }

    private void bXA() {
        if (this.nUJ == null) {
            this.nUJ = new com.baidu.tieba.yuyinala.liveroom.audiencelist.b(dXx().pageContext.getPageActivity());
        }
        long j = 1;
        if (dXx().nVs.bRq() != null) {
            j = dXx().nVs.bRq().getCount();
        }
        this.nUJ.a(this.nUR);
        this.nUJ.a(this.gXu, a.f.ala_liveroom_audience, j);
        this.nUJ.setVisible(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXF() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Hi = dXx().nVs.Hi();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Hi.aJK.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "msgbtn_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXG() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Hi = dXx().nVs.Hi();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Hi.aJK.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "morefunc_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXH() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Hi = dXx().nVs.Hi();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Hi.aJK.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "giftbtn_clk").setContentExt(jSONObject));
    }

    public void bXB() {
        this.nUq.c(dXx().nVs.Hi(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXI() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Hi = dXx().nVs.Hi();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Hi.aJK.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "olnumber_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            w Hi = dXx().nVs.Hi();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Hi.aJK.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "closebtn_clk").setContentExt(jSONObject));
    }

    private void bXF() {
        if (this.gXC || this.gXD) {
            if ((TbadkCoreApplication.isLogin() && this.gWN.LK().hasText()) || this.gXD) {
                this.gXC = false;
                this.gXD = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.bYg();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void bXy() {
        bXz();
    }

    private void bXz() {
        if (this.nUp != null) {
            int i = dXx().nVs.Hi().aJr.isUegBlock;
            int i2 = dXx().nVs.Hi().aJr.isBlock;
            String str = dXx().nVs.Hi().aJr.userName;
            if (i > 0 || i2 > 0) {
                this.nUp.b(true, i, i2, str);
                this.gWN.a(true, i, i2, str);
                this.nUu.b(true, i, i2, str);
                return;
            }
            this.nUp.b(false, i, i2, str);
            this.gWN.a(false, i, i2, str);
            this.nUu.b(false, i, i2, str);
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
                    if (dXx().nVs.Hi() != null && dXx().nVs.Hi().mLiveInfo != null) {
                        dXx().nVs.a(dXx().nVs.Hi().mLiveInfo.live_id, dXx().fromType, dXx().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && dXx().nVs.Hi() != null && dXx().nVs.Hi().mLiveInfo != null && dXx().nVs.Hi().aJr != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == dXx().nVs.Hi().aJr.userId && optLong2 == dXx().nVs.Hi().mLiveInfo.live_id) {
                        jSONObject.optInt("challenge_status");
                        jSONObject.optLong("challenge_id");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void HN(String str) {
        if (this.nUG != null) {
            this.nUG.HN(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void cj(boolean z) {
        super.cj(z);
        if (dXx().nVt != null) {
            dXx().nVt.chW();
            dXx().nVt.setLiveViewOnDispatchTouchEventListener(null);
            dXx().nVt.setLiveViewOnTouchEventListener(null);
            dXx().nVt.setOnLiveViewScrollListener(null);
        }
        if (dXx().bnJ != null) {
            dXx().bnJ.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        bXG();
        if (this.nUp != null) {
            this.nUp.cgE();
        }
        if (this.nUP != null) {
            this.nUP.Dm();
        }
        if (this.brz != null) {
            this.brz.removeAllViews();
            this.brz = null;
        }
        if (this.gYt != null) {
            this.gYt.removeAllViews();
            this.gYt = null;
        }
        if (this.nUG != null) {
            this.nUG.release();
        }
        if (this.nUL != null) {
            this.nUL.Dm();
        }
        if (this.nUM != null) {
            this.nUM.Dm();
        }
        if (this.nUN != null) {
            this.nUN.Dm();
        }
        o.dZA().Dm();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void ch(boolean z) {
        super.ch(z);
        bXG();
        if (this.nUI != null) {
            this.nUI.onDestroy();
        }
        if (this.nUH != null) {
            this.nUH.onDestroy();
        }
        if (this.gWN != null) {
            this.gWN.onDestroy();
        }
        if (this.nUp != null) {
            this.nUp.onDestory();
        }
        if (this.nUG != null) {
            this.nUG.release();
        }
        if (this.nUL != null) {
            this.nUL.onDestroy();
        }
        if (this.nUM != null) {
            this.nUM.onDestroy();
        }
        if (this.nUN != null) {
            this.nUN.onDestroy();
        }
        if (this.nUK != null) {
            this.nUK.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.nUQ);
        MessageManager.getInstance().unRegisterListener(this.gWk);
        MessageManager.getInstance().unRegisterListener(this.gWo);
        MessageManager.getInstance().unRegisterListener(this.gWp);
        MessageManager.getInstance().unRegisterListener(this.gWm);
    }

    private void bXG() {
        if (this.gWN != null && this.gWN.LJ().getView() != null && this.gWN.LJ().getView().getParent() != null) {
            ((ViewGroup) this.gWN.LJ().getView().getParent()).removeView(this.gWN.LJ().getView());
        }
        if (this.gVW != null && this.gVW.getParent() != null) {
            ((ViewGroup) this.gVW.getParent()).removeView(this.gVW);
        }
        if (this.gWN != null && this.gWN.LK().getView() != null) {
            this.gXv.removeView(this.gWN.LK().getView());
        }
        if (this.gWN != null) {
            this.gWN.LJ().setMsgData(new LinkedList());
            this.gWN.CM();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void a(aq aqVar) {
        if (this.gWN != null) {
            bYg();
            this.gWN.LK().setEditText(" @" + aqVar.getNameShow() + " ");
        }
        if (this.nUp != null) {
            this.nUp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void g(com.baidu.live.data.a aVar) {
        if (this.gWN != null) {
            bYg();
            this.gWN.LK().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.nUp != null) {
            this.nUp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void b(aq aqVar) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected View bXH() {
        if (this.gWN != null) {
            return this.gWN.LK().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public boolean bXI() {
        if (this.gWN == null || !this.gWN.LK().Ne()) {
            return false;
        }
        mL(false);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    /* renamed from: bZf */
    public PendantParentView bXK() {
        return this.brz;
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
                    this.gXz = false;
                    a(null, intExtra, intExtra2, intExtra3);
                    return;
                }
                bXB();
                return;
            }
            avS();
        } else if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            Ik(O(intent));
        }
    }

    private void Ik(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) dXx().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.nUI != null) {
            this.nUI.HX(fromJson.getSmallurl());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.gWN != null && this.gWN.LJ() != null) {
            this.gWN.LJ().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gWN == null || this.gWN.LK() == null || !this.gWN.LK().Ne()) {
            if (z) {
                if (this.nUp != null) {
                    this.nUp.setVisibility(8);
                }
                if (this.gWP != null && this.gWP.GH() != null) {
                    this.gWP.GH().setVisibility(8);
                }
                bXM();
                if (this.gWN != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gWN.LK().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gWN.LK().getView().setLayoutParams(layoutParams);
                    this.gWN.LK().getView().setVisibility(0);
                    this.gWN.LK().setQuickInputPanelVisible(false);
                }
                if (this.gXu != null) {
                    this.gXu.setVisibility(8);
                }
                if (this.gWO != null) {
                    this.gWO.CL();
                }
                if (this.nUG != null) {
                    this.nUG.setVisible(8);
                }
                if (this.gXo != null) {
                    this.gXo.setCanVisible(false);
                }
            } else {
                bXL();
            }
            bYZ();
            if (this.gXa != null) {
                this.gXa.bs(z);
            }
        }
    }

    private void bXL() {
        if (this.nUp != null) {
            this.nUp.setVisibility(0);
        }
        if (this.gVW != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVW.getLayoutParams();
            layoutParams.bottomMargin = dXx().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds120);
            this.gVW.setLayoutParams(layoutParams);
        }
        if (this.gWN != null) {
            bYh();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gWN.LK().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.gWN.LK().getView().setLayoutParams(layoutParams2);
        }
        if (this.nUp != null) {
            this.nUp.setVisibility(0);
        }
        if (this.gWP != null && this.gWP.GH() != null) {
            this.gWP.GH().setVisibility(0);
        }
        if (this.gXu != null) {
            this.gXu.setVisibility(0);
        }
        if (this.nUG != null) {
            this.nUG.setVisible(0);
        }
        if (this.gWO != null) {
            this.gWO.CL();
        }
        if (this.gXo != null) {
            this.gXo.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXM() {
        boolean z;
        boolean z2 = false;
        if (this.gVW != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVW.getLayoutParams();
            if (this.gWN == null || this.gWN.LK() == null) {
                z = false;
            } else {
                z = this.gWN.LK().Nc();
                z2 = this.gWN.LK().Nd();
            }
            int M = M(z, z2);
            if (layoutParams.bottomMargin != M) {
                layoutParams.bottomMargin = M;
                this.gVW.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL(boolean z) {
        this.gYy = z;
        if (z) {
            this.gWN.LK().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVW.getLayoutParams();
            int quickInputPanelExpandHeight = this.gWN.LK().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.gVW.setLayoutParams(layoutParams);
                if (this.gWN.LJ() != null) {
                    this.gWN.LJ().LI();
                    return;
                }
                return;
            }
            return;
        }
        bXL();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3 && this.nUH != null) {
            this.nUH.dI(i3);
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public boolean eO(int i) {
        return super.eO(i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void vv(int i) {
        super.vv(i);
        if (i == 7 || i == 11) {
            if (this.nUp != null) {
                this.nUp.setVisibility(8);
            }
            if (this.gWN != null) {
                this.gWN.LJ().getView().setVisibility(4);
            }
            if (this.nUG != null) {
                this.nUG.bM(2, 8);
            }
            if (this.nUx != null) {
                this.nUx.nL(false);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public void eP(int i) {
        super.eP(i);
        if (i == 7 || i == 11) {
            if (this.nUp != null) {
                this.nUp.setVisibility(0);
            }
            if (this.gWN != null) {
                this.gWN.LJ().getView().setVisibility(0);
            }
            if (this.nUG != null) {
                this.nUG.setVisible(0);
            }
            if (this.nUx != null) {
                this.nUx.nL(true);
            }
            this.gXu.setVisibility(0);
        }
    }

    private void bXp() {
        if (this.nUp != null) {
            this.nUp.a(new a.InterfaceC0911a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.nUG != null) {
            this.nUG.onStop();
        }
        if (this.nUL != null) {
            this.nUL.chc();
        }
        if (this.nUM != null) {
            this.nUM.chc();
        }
        if (this.nUN != null) {
            this.nUN.chc();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.dZi().onDestroy();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.nUG != null) {
            this.nUG.onStart();
        }
        if (this.nUL != null) {
            this.nUL.chb();
        }
        if (this.nUM != null) {
            this.nUM.chb();
        }
        if (this.nUN != null) {
            this.nUN.chb();
        }
    }
}
