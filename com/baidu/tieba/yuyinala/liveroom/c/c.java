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
import com.baidu.live.af.e;
import com.baidu.live.d.ag;
import com.baidu.live.data.at;
import com.baidu.live.data.bq;
import com.baidu.live.data.ch;
import com.baidu.live.data.cn;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
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
import com.baidu.tieba.yuyinala.liveroom.operation.a;
import com.baidu.tieba.yuyinala.liveroom.recommend.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends a {
    private PendantParentView buY;
    private com.baidu.live.ap.a hba;
    private FrameLayout hmf;
    private LinearLayout hoT;
    private g ojA;
    private com.baidu.tieba.yuyinala.liveroom.ranklist.a ojB;
    private com.baidu.tieba.yuyinala.liveroom.introduce.g ojC;
    private com.baidu.tieba.yuyinala.liveroom.charmrank.a ojD;
    private com.baidu.tieba.yuyinala.liveroom.l.a ojE;
    private com.baidu.tieba.yuyinala.liveroom.datingnavigation.a ojF;
    private com.baidu.tieba.yuyinala.liveroom.alaaudiopk.a ojG;
    private com.baidu.tieba.yuyinala.liveroom.activeview.b ojw;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.c ojx;
    private com.baidu.tieba.yuyinala.liveroom.i.b ojy;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.b ojz;
    private long lastClickTime = 0;
    private com.baidu.live.liveroom.g.c hmt = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.1
        @Override // com.baidu.live.liveroom.g.c
        public void LF() {
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cz(boolean z) {
            if (z) {
                if (c.this.ojc != null) {
                    c.this.ojc.LH(8);
                }
            } else if (c.this.ojc != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                    c.this.ojc.LH(0);
                } else {
                    c.this.ojc.LH(8);
                }
            }
            if (c.this.hns != null) {
                c.this.hns.by(z);
            }
        }
    };
    private CustomMessageListener ojH = new CustomMessageListener(2501032) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501032) {
                long currentTimeMillis = System.currentTimeMillis();
                if (c.this.dYs().okl.DW() != null && c.this.dYs().okl.DW().mLiveInfo != null) {
                    c.this.dYs().okl.a(c.this.dYs().okl.DW().mLiveInfo.live_id, c.this.dYs().fromType, c.this.dYs().enterTime, currentTimeMillis);
                }
            }
        }
    };
    private HttpMessageListener hmx = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.MY() != null) {
                        e.OY().bxA = getQuickGiftHttpResponseMessage.MY();
                        c.this.bZq();
                    }
                }
            }
        }
    };
    CustomMessageListener hmD = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2913168) {
            }
        }
    };
    private CustomMessageListener hmA = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (c.this.ojm != null) {
                    c.this.ojm.gT(str);
                }
            }
        }
    };
    private CustomMessageListener hmC = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (c.this.ojj != null) {
                    c.this.ojj.dismiss();
                }
                if (c.this.ojm != null) {
                    c.this.ojm.dismiss();
                }
                d.Jp().setSwitchStatus(true);
                d.Jp().setSelectId((String) customResponsedMessage.getData());
                if (c.this.mHandler == null) {
                    c.this.mHandler = new Handler();
                }
                c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.caf();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.yuyinala.liveroom.operation.b ojI = new com.baidu.tieba.yuyinala.liveroom.operation.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7
        @Override // com.baidu.tieba.yuyinala.liveroom.operation.b
        public void a(View view, int i, String[] strArr) {
            bq bqVar;
            ch chVar;
            cn cnVar;
            String str;
            bq bqVar2;
            ch chVar2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c.this.lastClickTime >= 300) {
                c.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    c.this.dYD();
                    c.this.a(strArr, -1, -1, -1);
                } else if (i == 1) {
                    if (c.this.hne != null) {
                        c.this.caf();
                    }
                } else if (i == 3) {
                    c.this.ojd.d(c.this.dYs().okl.DW(), false);
                } else if (i == 8) {
                    if (c.this.bok != null) {
                        c.this.bok.ct(false);
                    }
                    c.this.dYF();
                } else if (i != 12) {
                    if (i == 14) {
                        c.this.dYE();
                        x DW = c.this.dYs().okl.DW();
                        if (DW != null && DW.aFH != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmCardActivityConfig(c.this.dYs().pageContext.getPageActivity(), DW.aFH.userName, Long.toString(DW.aFH.userId), Long.toString(DW.aFH.charmCount), String.valueOf(DW.mLiveInfo.group_id), String.valueOf(DW.mLiveInfo.live_id), false, String.valueOf(DW.aFH.userId), Long.toString(DW.aGd.userId), DW.aGd.userName, DW.aGd.portrait, 0L, c.this.JQ(), DW.aGG)));
                        }
                    } else if (i == 11) {
                        c.this.cak();
                        c.this.cal();
                    } else if (i == 16) {
                        if (c.this.dYs() != null && (bqVar2 = com.baidu.live.af.a.OJ().bxp) != null && (chVar2 = bqVar2.aMO) != null) {
                            String str3 = chVar2.aOr.aOC;
                            if (!TextUtils.isEmpty(str3)) {
                                long j = 0;
                                if (c.this.dYs().okl != null && c.this.dYs().okl.DW() != null && c.this.dYs().okl.DW().mLiveInfo != null) {
                                    j = c.this.dYs().okl.DW().mLiveInfo.live_id;
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", c.this.dYs().okl.DW().mLiveInfo.room_id + "", c.this.dYs().okl.DW().mLiveInfo.feed_id, c.this.JQ());
                                }
                                if (str3.contains("?")) {
                                    str2 = str3 + "&liveId=" + j;
                                } else {
                                    str2 = str3 + "?liveId=" + j;
                                }
                                if (c.this.hba == null) {
                                    c.this.hba = new com.baidu.live.ap.a(c.this.dYs().pageContext.getPageActivity());
                                }
                                com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                                cVar.url = str2;
                                c.this.hba.a(cVar);
                            }
                        }
                    } else if (i == 20) {
                        if (c.this.dYs() != null) {
                            x xVar = null;
                            if (c.this.dYs().okl != null) {
                                xVar = c.this.dYs().okl.DW();
                            }
                            if (xVar != null && xVar.mLiveInfo != null && com.baidu.tieba.yuyinala.liveroom.p.b.dZy().brD != null) {
                                String str4 = com.baidu.tieba.yuyinala.liveroom.p.b.dZy().brD.aHz;
                                if (!TextUtils.isEmpty(str4)) {
                                    if (str4.contains("?")) {
                                        str = str4 + "&live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    } else {
                                        str = str4 + "?live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    }
                                    if (c.this.hba == null) {
                                        c.this.hba = new com.baidu.live.ap.a(c.this.dYs().pageContext.getPageActivity());
                                    }
                                    com.baidu.live.ap.c cVar2 = new com.baidu.live.ap.c();
                                    cVar2.url = str;
                                    c.this.hba.a(cVar2);
                                }
                            }
                        }
                    } else if (i == 17) {
                        if (c.this.GJ() && c.this.dYs() != null && (bqVar = com.baidu.live.af.a.OJ().bxp) != null && (chVar = bqVar.aMO) != null && (cnVar = chVar.aOs) != null && !TextUtils.isEmpty(cnVar.webUrl) && c.this.ojj != null && c.this.dYs().okl != null && c.this.dYs().okl.DW() != null && c.this.dYs().okl.DW().aFH != null) {
                            x DW2 = c.this.dYs().okl.DW();
                            c.this.ojj.b(cnVar.webUrl, DW2.mLiveInfo.live_id, DW2.aGd.userId, DW2.aFH.userId);
                        }
                    } else if (i == 22) {
                        c.this.ojE.ah(c.this.dYs().okl.DW());
                        c.this.dYC();
                    } else if (i == 23 && c.this.GJ()) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ag(BdBaseApplication.getInst(), String.valueOf(c.this.dYs().okl.ciG().live_id), String.valueOf(c.this.dYs().okl.ciG().group_id))));
                            c.this.dYB();
                        } catch (Exception e) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(c.this.dYs().pageContext.getPageActivity(), "请稍后重试", 1).show();
                                }
                            });
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.operation.b
        public void a(int i, com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
            if (i == 21 && c.this.GJ()) {
                if (c.this.ojA == null) {
                    c.this.ojA = new g(c.this.dYs().pageContext);
                }
                c.this.ojA.b(eVar);
            }
        }
    };
    private boolean hpc = false;

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
    }

    public void a(x xVar, String str, String str2) {
        this.hpc = false;
        dYs().okm.setIsForceHandledTouch(false);
        dYs().okm.setSwipeClearEnable(false);
        dYs().okm.setOnLiveViewScrollListener(this.hmt);
        if (this.hnP != null) {
            this.hnP.setVisibility(0);
        }
        cbl();
        bZu();
        bZw();
        bZB();
        dYA();
        dYy();
        dYx();
        cat();
        o.ebo().m(xVar);
        bZi();
        if (xVar != null && xVar.aGy != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_FEED_LOAD_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "audioConnect", null);
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().aR(xVar.aGy.aQH, str2, str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void m(x xVar) {
        super.m(xVar);
        this.hpc = false;
        dYs().okm.setIsForceHandledTouch(false);
        dYs().okm.setSwipeClearEnable(false);
        dYs().okm.setOnLiveViewScrollListener(this.hmt);
        if (this.hnP != null) {
            this.hnP.setVisibility(0);
        }
        cbl();
        if (this.ojy != null) {
            this.ojy.a(xVar, this.hnP);
        }
        bZv();
        bZz();
        bZw();
        bZB();
        dYA();
        dYy();
        dYw();
        dYu();
        dYx();
        nF(false);
        cao();
        can();
        cat();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().ak(xVar);
        o.ebo().m(xVar);
        bZr();
        cap();
        caG();
        bZk();
        bZq();
        caC();
        bZc();
        caF();
        c(this.goI);
        bZn();
        MessageManager.getInstance().registerListener(this.ojH);
        MessageManager.getInstance().registerListener(this.hmx);
        MessageManager.getInstance().registerListener(this.hmC);
        MessageManager.getInstance().registerListener(this.hmD);
        MessageManager.getInstance().registerListener(this.hmA);
        bZF();
        bZy();
        bZi();
        dYv();
    }

    private void dYu() {
        if (dYs().okl != null && dYs().okl.DW() != null) {
            x DW = dYs().okl.DW();
            if (DW.aGD != null && DW.aGD.getRoomMode() == 2) {
                if (this.ojG == null) {
                    this.ojG = new com.baidu.tieba.yuyinala.liveroom.alaaudiopk.a(dYs().pageContext);
                }
                this.ojG.Y(dYs().okl.DW());
                this.ojG.aF(this.hnP);
                if (dYs() != null && dYs().okl != null) {
                    dYs().okl.omS = true;
                    dYs().okl.ag(dYs().okl.DW());
                }
            }
        }
    }

    private void dYv() {
        o.ebo().a(new o.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.10
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
            public void Lx(int i) {
                c.this.cbf();
                c.this.cbh();
            }
        });
    }

    private void dYw() {
        if (dYs().okl.DW() != null && dYs().okl.DW().aFH != null && dYs().okl.DW().mLiveInfo != null) {
            x DW = dYs().okl.DW();
            if (DW.aGD != null && DW.aGD.getRoomMode() == 1) {
                if (this.ojF == null) {
                    this.ojF = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(dYs().pageContext);
                }
                this.ojF.Y(dYs().okl.DW());
                this.ojF.aF(this.hnP);
            }
        }
    }

    private void dYx() {
        if (dYs().okl.DW() != null && dYs().okl.DW().aFH != null && dYs().okl.DW().mLiveInfo != null && this.ojE == null) {
            this.ojE = new com.baidu.tieba.yuyinala.liveroom.l.a(dYs().pageContext);
        }
    }

    private void dYy() {
        if (dYs().okl.DW() != null && dYs().okl.DW().aFH != null && dYs().okl.DW().mLiveInfo != null) {
            if (this.ojD == null) {
                this.ojD = new com.baidu.tieba.yuyinala.liveroom.charmrank.a(dYs().pageContext);
            }
            long j = dYs().okl.DW().aFH.userId;
            int i = dYs().okl.DW().mLiveInfo.live_type;
            String str = dYs().okl.DW().aFH.portrait;
            String str2 = dYs().okl.DW().mLiveInfo.feed_id;
            long j2 = dYs().okl.DW().mLiveInfo.live_id;
            this.ojD.a(i, j, dYs().okl.DW().aFH.userName, false, str, JQ(), str2, j2);
            this.ojD.aF(this.hnP);
            this.ojD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    x DW = c.this.dYs().okl.DW();
                    if (DW != null && DW.aFH != null) {
                        c.this.dYz();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmRankActivityConfig(c.this.dYs().pageContext.getPageActivity(), DW.aFH.userName, Long.toString(DW.aFH.userId), Long.toString(DW.aFH.charmCount), String.valueOf(DW.aGy.croom_id), String.valueOf(DW.mLiveInfo.live_id), false, String.valueOf(DW.aFH.userId), Long.toString(DW.aGd.userId), DW.aGd.userName, DW.aGd.portrait, 0L, DW.aGd.userType)));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYz() {
        JSONObject jSONObject = new JSONObject();
        try {
            x DW = dYs().okl.DW();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DW.aGy.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "charmlist_clk").setContentExt(jSONObject));
    }

    private void dYA() {
        if (dYs().okl.DW() != null && dYs().okl.DW().aFH != null && dYs().okl.DW().mLiveInfo != null) {
            if (this.ojC == null) {
                this.ojC = new com.baidu.tieba.yuyinala.liveroom.introduce.g(dYs().pageContext);
            }
            this.ojC.Y(dYs().okl.DW());
            this.ojC.aF(this.hnP);
            this.ojC.cFF();
        }
    }

    public void bZB() {
        if (dYs().okl.DW() != null && dYs().okl.DW().mLiveInfo != null && dYs().okl.DW().aGy != null && dYs().okl.DW().aGE) {
            if (this.ojB == null) {
                this.ojB = new com.baidu.tieba.yuyinala.liveroom.ranklist.a(dYs().pageContext);
            }
            String str = dYs().okl.DW().aGd.userUk;
            int i = dYs().okl.DW().mLiveInfo.live_type;
            String str2 = dYs().okl.DW().aGy.cover;
            String str3 = dYs().okl.DW().mLiveInfo.feed_id;
            long j = dYs().okl.DW().mLiveInfo.live_id;
            this.ojB.a(i, str, dYs().okl.DW().aFH.userName, false, str2, JQ(), str3, j, dYs().okl.DW().aGy.croom_id, dYs().okl.DW().aGy.aQQ, dYs().okl.DW().aGy.aQH, dYs().okl.DW().aGy.cover, dYs().okl.DW().aGy.room_name);
            this.ojB.aF(this.hnP);
            this.ojB.cFF();
        }
    }

    private void bZc() {
        if (this.ojo != null) {
            this.ojo.a(new a.InterfaceC0928a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.12
                @Override // com.baidu.tieba.yuyinala.liveroom.recommend.a.InterfaceC0928a
                public void cG(boolean z) {
                }
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(x xVar) {
        super.k(xVar);
        if (this.ojy != null) {
            this.ojy.M(xVar);
        }
        ab(xVar);
        aa(xVar);
        if (this.ojB != null && xVar != null && xVar.aGy != null) {
            this.ojB.LL(xVar.aGy.aQQ);
        }
        if (this.ojw != null) {
            this.ojw.j(xVar);
            this.ojw.nx(this.hnZ);
            this.ojw.updateView();
            if (xVar != null && this.hnH != null && !this.hnH.hasInit && !TextUtils.isEmpty(this.hnH.aNi)) {
                this.hnH.hasInit = true;
                this.ojw.GR(this.hnH.aNi);
            }
        }
    }

    private void aa(x xVar) {
        if (xVar != null && xVar.aGD != null && xVar.aGD.getRoomMode() == 2) {
            if (this.ojG == null) {
                if (o.ebo().ebD()) {
                    this.ojG = new com.baidu.tieba.yuyinala.liveroom.alaaudiopk.a(dYs().pageContext);
                    this.ojG.Y(xVar);
                    this.ojG.aF(this.hnP);
                    this.ojG.dpI();
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.13
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.ojG.showView();
                        }
                    }, 1500L);
                } else {
                    this.ojG = new com.baidu.tieba.yuyinala.liveroom.alaaudiopk.a(dYs().pageContext);
                    this.ojG.Y(xVar);
                    this.ojG.aF(this.hnP);
                    this.ojG.showView();
                }
            }
            if (dYs() != null && dYs().okl != null) {
                dYs().okl.omS = true;
                dYs().okl.ag(xVar);
                return;
            }
            return;
        }
        if (o.ebo().ebD()) {
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.14
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ojG != null) {
                        c.this.ojG.onDestroy();
                        c.this.ojG = null;
                    }
                }
            }, 1500L);
        } else if (this.ojG != null) {
            this.ojG.onDestroy();
            this.ojG = null;
        }
        if (dYs() != null && dYs().okl != null) {
            dYs().okl.omS = false;
        }
    }

    private void ab(x xVar) {
        if (xVar != null && xVar.aGD != null && xVar.aGD.getRoomMode() == 1) {
            if (this.ojF != null) {
                this.ojF.k(xVar);
            } else if (o.ebo().ebD()) {
                this.ojF = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(dYs().pageContext);
                this.ojF.Y(xVar);
                this.ojF.de(this.hnP);
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.15
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.ojF != null) {
                            c.this.ojF.dYI();
                        }
                    }
                }, 1500L);
            } else {
                this.ojF = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(dYs().pageContext);
                this.ojF.Y(xVar);
                this.ojF.de(this.hnP);
                this.ojF.dYI();
            }
        } else if (o.ebo().ebD()) {
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.16
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ojF != null) {
                        c.this.ojF.onDestroy();
                        c.this.ojF = null;
                    }
                }
            }, 1500L);
        } else if (this.ojF != null) {
            this.ojF.onDestroy();
            this.ojF = null;
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(r rVar) {
        if (rVar != null) {
            if (this.ojx != null && rVar.getList() != null) {
                this.ojx.e(rVar);
            }
            if (this.ojz != null) {
                this.ojz.eZ(rVar.getCount());
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cs(int i) {
        super.cs(i);
    }

    private void bZi() {
        if (dYs() != null && dYs().pageContext != null && dYs().pageContext.getPageActivity() != null) {
            if (this.buY == null) {
                this.buY = new PendantParentView(dYs().pageContext.getPageActivity(), PendantParentView.Model.VERTICAL);
                u.a(dYs().okm, this.buY, new ViewGroup.LayoutParams(-1, -1), 50);
                this.buY.setDefaultItemMargin(dYs().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
                this.buY.setPadding(dYs().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, dYs().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            }
            cbf();
        }
    }

    private void bZk() {
        if (this.ojw == null) {
            this.ojw = new com.baidu.tieba.yuyinala.liveroom.activeview.b(dYs().pageContext);
        }
        if (dYs() != null && dYs().okl != null) {
            this.ojw.GO(dYs().okl.ciK());
        }
        this.ojw.setOtherParams(JQ());
        this.ojw.c(dYs().okl.DW(), false);
        this.ojw.setHost(false);
        this.ojw.nx(this.hnZ);
        this.ojw.a(1, this.buY);
        this.ojw.a(2, this.buY);
        this.ojw.setVisible(this.hnT ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbf() {
        if (this.buY != null) {
            this.buY.setModel(dYs().okl.DW().aGD.getRoomMode() != 0 ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            this.buY.setPosition(dYs().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds164), 0, dYs().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200), dYs().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102));
            return;
        }
        bZi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbh() {
        if (this.hne != null && this.hmf != null && this.hne.IF() != null && this.hne.IF().getView() != null) {
            int I = com.baidu.tieba.yuyinala.liveroom.q.a.I(this.hnT, dYs().okl.DW().aGD.getRoomMode());
            if (this.hnQ.indexOfChild(this.hmf) != -1 && this.hmf.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hmf.getLayoutParams();
                layoutParams.height = I;
                this.hmf.setLayoutParams(layoutParams);
            }
            if (this.hmf.indexOfChild(this.hne.IF().getView()) != -1 && this.hne.IF().getView().getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hne.IF().getView().getLayoutParams();
                layoutParams2.height = I;
                this.hne.IF().getView().setLayoutParams(layoutParams2);
            }
            this.hne.IF().IE();
        }
    }

    private void cbl() {
        if (this.hoT == null) {
            this.hoT = new LinearLayout(dYs().pageContext.getPageActivity());
            this.hoT.setOrientation(1);
        }
        if (this.hoT.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = dYs().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = dYs().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            u.a(dYs().okm, this.hoT, layoutParams, 600);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZq() {
        if (this.ojc == null) {
            bZw();
        }
        this.ojc.setOtherParams(JQ());
        this.ojc.a(e.OY().bxA, dYs().okl.DW());
    }

    private void cat() {
        if (this.oji != null && dYs() != null && dYs().okl != null) {
            this.oji.d(this.hnP, dYs().okl.DW());
        }
    }

    private void bZr() {
        CustomResponsedMessage runTask;
        if (this.hne == null && (runTask = MessageManager.getInstance().runTask(2501045, k.class, dYs().pageContext)) != null && runTask.getData() != null) {
            this.hne = (k) runTask.getData();
            this.hne.setFromMaster(false);
            this.hne.IF().getView().setId(a.f.ala_liveroom_msg_list);
            this.hne.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6
                @Override // com.baidu.live.im.k.a
                public boolean IJ() {
                    return c.this.GJ();
                }

                @Override // com.baidu.live.im.k.a
                public void IK() {
                    c.this.hnX = true;
                }

                @Override // com.baidu.live.im.k.a
                public void gD(String str) {
                    if (!c.this.hnT) {
                        c.this.nC(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(c.this.dYs().pageContext.getPageActivity(), c.this.dYs().hxi.getLiveContainerView());
                    }
                    c.this.GV(str);
                }

                @Override // com.baidu.live.im.k.a
                public void IL() {
                    if (c.this.hnT) {
                        c.this.nC(true);
                        c.this.dYs().hxi.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.dYs().pageContext.getPageActivity(), c.this.dYs().hxi.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.hne != null) {
                        c.this.hne.IG().setQuickInputPanelVisible(false);
                        c.this.hne.IG().KB();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void IM() {
                    if (c.this.hnT) {
                        c.this.nC(true);
                        c.this.dYs().hxi.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6.2
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.dYs().pageContext.getPageActivity(), c.this.dYs().hxi.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.hne != null) {
                        c.this.hne.IG().setQuickInputPanelVisible(false);
                        c.this.hne.IG().KB();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void IN() {
                    if (c.this.hnT) {
                        c.this.bZM();
                        if (c.this.hnf != null) {
                            c.this.hnf.zg();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean IO() {
                    return c.this.bZZ();
                }

                @Override // com.baidu.live.im.k.a
                public int IP() {
                    return c.this.caa();
                }

                @Override // com.baidu.live.im.k.a
                public boolean IQ() {
                    return false;
                }
            });
            this.hmf = new FrameLayout(dYs().pageContext.getPageActivity());
            this.hmf.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hne != null && this.hmf != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(dYs().pageContext.getPageActivity()) * 0.7f);
            int I = com.baidu.tieba.yuyinala.liveroom.q.a.I(false, dYs().okl.DW().aGD.getRoomMode());
            if (this.hnQ.indexOfChild(this.hmf) < 0) {
                if (this.hmf.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hmf.getParent()).removeView(this.hmf);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, I);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.tieba.yuyinala.liveroom.q.a.dj(false);
                this.hnQ.addView(this.hmf, layoutParams);
            }
            if (this.hmf.indexOfChild(this.hne.IF().getView()) < 0) {
                if (this.hne.IF().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hne.IF().getView()).removeView(this.hne.IF().getView());
                }
                this.hmf.addView(this.hne.IF().getView(), new FrameLayout.LayoutParams(equipmentWidth, I));
            }
            if (dYs().okm.indexOfChild(this.hne.IG().getView()) < 0) {
                if (this.hne.IG().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hne.IG().getView().getParent()).removeView(this.hne.IG().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cai();
                dYs().okm.addView(this.hne.IG().getView(), layoutParams2);
            }
            x DW = dYs().okl.DW();
            if (DW != null && DW.mLiveInfo != null) {
                this.hne.setLogData(DW.mLiveInfo.feed_id, JQ());
            }
            this.hne.a(String.valueOf(dYs().okl.DW().mLiveInfo.group_id), String.valueOf(dYs().okl.DW().mLiveInfo.last_msg_id), String.valueOf(dYs().okl.DW().aFH.userId), String.valueOf(dYs().okl.DW().mLiveInfo.live_id), dYs().okl.DW().aFH.appId, (DW == null || DW.aGv == null || !DW.aGv.Av()) ? false : true, dYs().okl.DW().getGuardName());
            nC(false);
        }
    }

    private void bZu() {
        if (this.ojy == null) {
            this.ojy = new com.baidu.tieba.yuyinala.liveroom.i.b(dYs().pageContext);
        }
        this.ojy.e(this.hnP, dYs().okl.DW());
    }

    private void bZv() {
        if (this.ojx == null) {
            this.ojx = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(dYs().pageContext, this);
        }
        this.ojx.a(String.valueOf(dYs().okl.DW().mLiveInfo.live_id), dYs().okl.DW());
        this.ojx.c(this.hnP, a.f.ala_liveroom_hostheader, a.f.ala_liveroom_audience_count_layout);
        this.ojx.e(dYs().okl.bTh());
        this.ojx.setOtherParams(JQ());
    }

    private void bZw() {
        if (this.ojc == null) {
            this.ojc = new com.baidu.tieba.yuyinala.liveroom.operation.a(dYs().pageContext);
        }
        this.ojc.a(dYs(), this.hnQ, dYs().okl.DW().mLiveInfo, true, this.ojI);
        this.ojc.setOtherParams(JQ());
    }

    public void nK(boolean z) {
        if (this.ojc != null) {
            this.ojc.nK(z);
        }
    }

    private void bZz() {
        if (this.ojz == null) {
            this.ojz = new com.baidu.tieba.yuyinala.liveroom.audiencelist.b(dYs().pageContext.getPageActivity());
        }
        long j = 1;
        if (dYs().okl.bTh() != null) {
            j = dYs().okl.bTh().getCount();
        }
        this.ojz.a(this.ojI);
        this.ojz.a(this.hnP, a.f.ala_liveroom_audience, j);
        this.ojz.setVisible(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYB() {
        JSONObject jSONObject = new JSONObject();
        try {
            x DW = dYs().okl.DW();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DW.aGy.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "msgbtn_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYC() {
        JSONObject jSONObject = new JSONObject();
        try {
            x DW = dYs().okl.DW();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DW.aGy.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "morefunc_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYD() {
        JSONObject jSONObject = new JSONObject();
        try {
            x DW = dYs().okl.DW();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DW.aGy.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "giftbtn_clk").setContentExt(jSONObject));
    }

    public void bZA() {
        this.ojd.d(dYs().okl.DW(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYE() {
        JSONObject jSONObject = new JSONObject();
        try {
            x DW = dYs().okl.DW();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DW.aGy.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "olnumber_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYF() {
        JSONObject jSONObject = new JSONObject();
        try {
            x DW = dYs().okl.DW();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DW.aGy.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "closebtn_clk").setContentExt(jSONObject));
    }

    private void bZF() {
        if (this.hnX || this.hnY) {
            if ((TbadkCoreApplication.isLogin() && this.hne.IG().hasText()) || this.hnY) {
                this.hnX = false;
                this.hnY = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.caf();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void bZx() {
        bZy();
    }

    private void bZy() {
        if (this.ojc != null) {
            int i = dYs().okl.DW().aGd.isUegBlock;
            int i2 = dYs().okl.DW().aGd.isBlock;
            String str = dYs().okl.DW().aGd.userName;
            if (i > 0 || i2 > 0) {
                this.ojc.b(true, i, i2, str);
                this.hne.a(true, i, i2, str);
                this.ojh.b(true, i, i2, str);
                return;
            }
            this.ojc.b(false, i, i2, str);
            this.hne.a(false, i, i2, str);
            this.ojh.b(false, i, i2, str);
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
                    if (dYs().okl.DW() != null && dYs().okl.DW().mLiveInfo != null) {
                        dYs().okl.a(dYs().okl.DW().mLiveInfo.live_id, dYs().fromType, dYs().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && dYs().okl.DW() != null && dYs().okl.DW().mLiveInfo != null && dYs().okl.DW().aGd != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == dYs().okl.DW().aGd.userId && optLong2 == dYs().okl.DW().mLiveInfo.live_id) {
                        jSONObject.optInt("challenge_status");
                        jSONObject.optLong("challenge_id");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void GQ(String str) {
        if (this.ojw != null) {
            this.ojw.GQ(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void cy(boolean z) {
        super.cy(z);
        if (dYs().okm != null) {
            dYs().okm.ckl();
            dYs().okm.setLiveViewOnDispatchTouchEventListener(null);
            dYs().okm.setLiveViewOnTouchEventListener(null);
            dYs().okm.setOnLiveViewScrollListener(null);
        }
        if (dYs().bon != null) {
            dYs().bon.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        bZG();
        if (this.ojc != null) {
            this.ojc.ciQ();
        }
        if (this.ojF != null) {
            this.ojF.zH();
        }
        if (this.ojG != null) {
            this.ojG.zH();
        }
        if (this.buY != null) {
            this.buY.removeAllViews();
            this.buY = null;
        }
        if (this.hoT != null) {
            this.hoT.removeAllViews();
            this.hoT = null;
        }
        if (this.ojw != null) {
            this.ojw.release();
        }
        if (this.ojB != null) {
            this.ojB.zH();
        }
        if (this.ojC != null) {
            this.ojC.zH();
        }
        if (this.ojD != null) {
            this.ojD.zH();
        }
        if (this.ojy != null) {
            this.ojy.zH();
        }
        o.ebo().zH();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cw(boolean z) {
        super.cw(z);
        bZG();
        if (this.ojy != null) {
            this.ojy.onDestroy();
        }
        if (this.ojx != null) {
            this.ojx.onDestroy();
        }
        if (this.hne != null) {
            this.hne.onDestroy();
        }
        if (this.ojc != null) {
            this.ojc.onDestory();
        }
        if (this.ojw != null) {
            this.ojw.release();
        }
        if (this.ojB != null) {
            this.ojB.onDestroy();
        }
        if (this.ojC != null) {
            this.ojC.onDestroy();
        }
        if (this.ojD != null) {
            this.ojD.onDestroy();
        }
        if (this.ojA != null) {
            this.ojA.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.ojH);
        MessageManager.getInstance().unRegisterListener(this.hmx);
        MessageManager.getInstance().unRegisterListener(this.hmC);
        MessageManager.getInstance().unRegisterListener(this.hmD);
        MessageManager.getInstance().unRegisterListener(this.hmA);
    }

    private void bZG() {
        if (this.hne != null && this.hne.IF().getView() != null && this.hne.IF().getView().getParent() != null) {
            ((ViewGroup) this.hne.IF().getView().getParent()).removeView(this.hne.IF().getView());
        }
        if (this.hmf != null && this.hmf.getParent() != null) {
            ((ViewGroup) this.hmf.getParent()).removeView(this.hmf);
        }
        if (this.hne != null && this.hne.IG().getView() != null) {
            this.hnQ.removeView(this.hne.IG().getView());
        }
        if (this.hne != null) {
            this.hne.IF().setMsgData(new LinkedList());
            this.hne.zh();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void a(at atVar) {
        if (this.hne != null) {
            caf();
            this.hne.IG().setEditText(" @" + atVar.getNameShow() + " ");
        }
        if (this.ojc != null) {
            this.ojc.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hne != null) {
            caf();
            this.hne.IG().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.ojc != null) {
            this.ojc.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void b(at atVar) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected View bZH() {
        if (this.hne != null) {
            return this.hne.IG().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public boolean bZI() {
        if (this.hne != null) {
            nC(false);
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    /* renamed from: cbr */
    public PendantParentView bZK() {
        return this.buY;
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
                    this.hnU = false;
                    a(null, intExtra, intExtra2, intExtra3);
                    return;
                }
                bZA();
                return;
            }
            avQ();
        } else if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            Hq(P(intent));
        }
    }

    private void Hq(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) dYs().pageContext.getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.ojy != null) {
            this.ojy.Hd(fromJson.getBigurl());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.hne != null && this.hne.IF() != null) {
            this.hne.IF().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hne == null || this.hne.IG() == null || !this.hne.IG().KA()) {
            if (z) {
                if (this.ojc != null) {
                    this.ojc.setVisibility(8);
                }
                if (this.hng != null && this.hng.Dt() != null) {
                    this.hng.Dt().setVisibility(8);
                }
                bZM();
                if (this.hne != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hne.IG().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hne.IG().getView().setLayoutParams(layoutParams);
                    this.hne.IG().getView().setVisibility(0);
                    this.hne.IG().setQuickInputPanelVisible(false);
                }
                if (this.hnP != null) {
                    this.hnP.setVisibility(8);
                }
                if (this.hnf != null) {
                    this.hnf.zg();
                }
                if (this.ojw != null) {
                    this.ojw.setVisible(8);
                }
                if (this.hnI != null) {
                    this.hnI.setCanVisible(false);
                }
            } else {
                bZL();
            }
            cbh();
            if (this.hns != null) {
                this.hns.bx(z);
            }
        }
    }

    private void bZL() {
        if (this.ojc != null) {
            this.ojc.setVisibility(0);
        }
        if (this.hmf != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hmf.getLayoutParams();
            layoutParams.bottomMargin = dYs().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds120);
            this.hmf.setLayoutParams(layoutParams);
        }
        if (this.hne != null) {
            cai();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hne.IG().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hne.IG().getView().setLayoutParams(layoutParams2);
        }
        if (this.ojc != null) {
            this.ojc.setVisibility(0);
        }
        if (this.hng != null && this.hng.Dt() != null) {
            this.hng.Dt().setVisibility(0);
        }
        if (this.hnP != null) {
            this.hnP.setVisibility(0);
        }
        if (this.ojw != null) {
            this.ojw.setVisible(0);
        }
        if (this.hnf != null) {
            this.hnf.zg();
        }
        if (this.hnI != null) {
            this.hnI.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZM() {
        boolean z;
        boolean z2;
        if (this.hmf != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hmf.getLayoutParams();
            if (this.hne == null || this.hne.IG() == null) {
                z = false;
                z2 = false;
            } else {
                boolean Ky = this.hne.IG().Ky();
                z = this.hne.IG().Kz();
                z2 = Ky;
            }
            int O = O(z2, z);
            if (layoutParams.bottomMargin != O) {
                layoutParams.bottomMargin = O;
                this.hmf.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nC(boolean z) {
        this.hpc = z;
        if (z) {
            this.hne.IG().setQuickInputPanelVisible(true);
            return;
        }
        bZL();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3 && this.ojx != null) {
            this.ojx.co(i3);
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public boolean dz(int i) {
        return super.dz(i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void vd(int i) {
        super.vd(i);
        if (i == 11) {
            if (this.ojc != null) {
                this.ojc.setVisibility(8);
            }
            if (this.hne != null) {
                this.hne.IF().getView().setVisibility(4);
            }
            if (this.ojw != null) {
                this.ojw.bP(2, 8);
            }
            if (this.ojk != null) {
                this.ojk.oC(false);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public void dA(int i) {
        super.dA(i);
        if (i == 11) {
            if (this.ojc != null) {
                this.ojc.setVisibility(0);
            }
            if (this.hne != null) {
                this.hne.IF().getView().setVisibility(0);
            }
            if (this.ojw != null) {
                this.ojw.setVisible(0);
            }
            if (this.ojk != null) {
                this.ojk.oC(true);
            }
            this.hnP.setVisibility(0);
        }
    }

    private void bZn() {
        if (this.ojc != null) {
            this.ojc.a(new a.InterfaceC0927a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.9
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.ojw != null) {
            this.ojw.onStop();
        }
        if (this.ojB != null) {
            this.ojB.cjn();
        }
        if (this.ojC != null) {
            this.ojC.cjn();
        }
        if (this.ojD != null) {
            this.ojD.cjn();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eaV().onDestroy();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.ojw != null) {
            this.ojw.onStart();
        }
        if (this.ojB != null) {
            this.ojB.cjm();
        }
        if (this.ojC != null) {
            this.ojC.cjm();
        }
        if (this.ojD != null) {
            this.ojD.cjm();
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d dVar) {
        if (this.ojG != null) {
            this.ojG.a(dVar);
        }
    }
}
