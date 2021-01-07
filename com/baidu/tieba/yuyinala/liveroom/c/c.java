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
/* loaded from: classes11.dex */
public class c extends a {
    private PendantParentView bzK;
    private com.baidu.live.ap.a hfG;
    private FrameLayout hqM;
    private LinearLayout htz;
    private com.baidu.tieba.yuyinala.liveroom.activeview.b oob;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.c ooc;
    private com.baidu.tieba.yuyinala.liveroom.i.b ood;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.b ooe;
    private g oof;
    private com.baidu.tieba.yuyinala.liveroom.ranklist.a oog;
    private com.baidu.tieba.yuyinala.liveroom.introduce.g ooh;
    private com.baidu.tieba.yuyinala.liveroom.charmrank.a ooi;
    private com.baidu.tieba.yuyinala.liveroom.l.a ooj;
    private com.baidu.tieba.yuyinala.liveroom.datingnavigation.a ook;
    private com.baidu.tieba.yuyinala.liveroom.alaaudiopk.a ool;
    private long lastClickTime = 0;
    private com.baidu.live.liveroom.g.c hra = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.1
        @Override // com.baidu.live.liveroom.g.c
        public void PA() {
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cD(boolean z) {
            if (z) {
                if (c.this.onH != null) {
                    c.this.onH.No(8);
                }
            } else if (c.this.onH != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                    c.this.onH.No(0);
                } else {
                    c.this.onH.No(8);
                }
            }
            if (c.this.hrZ != null) {
                c.this.hrZ.bC(z);
            }
        }
    };
    private CustomMessageListener oom = new CustomMessageListener(2501032) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501032) {
                long currentTimeMillis = System.currentTimeMillis();
                if (c.this.eck().ooQ.HR() != null && c.this.eck().ooQ.HR().mLiveInfo != null) {
                    c.this.eck().ooQ.a(c.this.eck().ooQ.HR().mLiveInfo.live_id, c.this.eck().fromType, c.this.eck().enterTime, currentTimeMillis);
                }
            }
        }
    };
    private HttpMessageListener hre = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.QT() != null) {
                        e.ST().bCm = getQuickGiftHttpResponseMessage.QT();
                        c.this.cdi();
                    }
                }
            }
        }
    };
    CustomMessageListener hrk = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2913168) {
            }
        }
    };
    private CustomMessageListener hrh = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (c.this.onR != null) {
                    c.this.onR.ie(str);
                }
            }
        }
    };
    private CustomMessageListener hrj = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (c.this.onO != null) {
                    c.this.onO.dismiss();
                }
                if (c.this.onR != null) {
                    c.this.onR.dismiss();
                }
                d.Nk().setSwitchStatus(true);
                d.Nk().setSelectId((String) customResponsedMessage.getData());
                if (c.this.mHandler == null) {
                    c.this.mHandler = new Handler();
                }
                c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.cdX();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.yuyinala.liveroom.operation.b oon = new com.baidu.tieba.yuyinala.liveroom.operation.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7
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
                    c.this.ecv();
                    c.this.a(strArr, -1, -1, -1);
                } else if (i == 1) {
                    if (c.this.hrL != null) {
                        c.this.cdX();
                    }
                } else if (i == 3) {
                    c.this.onI.d(c.this.eck().ooQ.HR(), false);
                } else if (i == 8) {
                    if (c.this.bsW != null) {
                        c.this.bsW.cx(false);
                    }
                    c.this.ecx();
                } else if (i != 12) {
                    if (i == 14) {
                        c.this.ecw();
                        x HR = c.this.eck().ooQ.HR();
                        if (HR != null && HR.aKu != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmCardActivityConfig(c.this.eck().pageContext.getPageActivity(), HR.aKu.userName, Long.toString(HR.aKu.userId), Long.toString(HR.aKu.charmCount), String.valueOf(HR.mLiveInfo.group_id), String.valueOf(HR.mLiveInfo.live_id), false, String.valueOf(HR.aKu.userId), Long.toString(HR.aKQ.userId), HR.aKQ.userName, HR.aKQ.portrait, 0L, c.this.NL(), HR.aLt)));
                        }
                    } else if (i == 11) {
                        c.this.cec();
                        c.this.ced();
                    } else if (i == 16) {
                        if (c.this.eck() != null && (bqVar2 = com.baidu.live.af.a.SE().bCb) != null && (chVar2 = bqVar2.aRB) != null) {
                            String str3 = chVar2.aTe.aTp;
                            if (!TextUtils.isEmpty(str3)) {
                                long j = 0;
                                if (c.this.eck().ooQ != null && c.this.eck().ooQ.HR() != null && c.this.eck().ooQ.HR().mLiveInfo != null) {
                                    j = c.this.eck().ooQ.HR().mLiveInfo.live_id;
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", c.this.eck().ooQ.HR().mLiveInfo.room_id + "", c.this.eck().ooQ.HR().mLiveInfo.feed_id, c.this.NL());
                                }
                                if (str3.contains("?")) {
                                    str2 = str3 + "&liveId=" + j;
                                } else {
                                    str2 = str3 + "?liveId=" + j;
                                }
                                if (c.this.hfG == null) {
                                    c.this.hfG = new com.baidu.live.ap.a(c.this.eck().pageContext.getPageActivity());
                                }
                                com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                                cVar.url = str2;
                                c.this.hfG.a(cVar);
                            }
                        }
                    } else if (i == 20) {
                        if (c.this.eck() != null) {
                            x xVar = null;
                            if (c.this.eck().ooQ != null) {
                                xVar = c.this.eck().ooQ.HR();
                            }
                            if (xVar != null && xVar.mLiveInfo != null && com.baidu.tieba.yuyinala.liveroom.p.b.edq().bwr != null) {
                                String str4 = com.baidu.tieba.yuyinala.liveroom.p.b.edq().bwr.aMm;
                                if (!TextUtils.isEmpty(str4)) {
                                    if (str4.contains("?")) {
                                        str = str4 + "&live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    } else {
                                        str = str4 + "?live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    }
                                    if (c.this.hfG == null) {
                                        c.this.hfG = new com.baidu.live.ap.a(c.this.eck().pageContext.getPageActivity());
                                    }
                                    com.baidu.live.ap.c cVar2 = new com.baidu.live.ap.c();
                                    cVar2.url = str;
                                    c.this.hfG.a(cVar2);
                                }
                            }
                        }
                    } else if (i == 17) {
                        if (c.this.KE() && c.this.eck() != null && (bqVar = com.baidu.live.af.a.SE().bCb) != null && (chVar = bqVar.aRB) != null && (cnVar = chVar.aTf) != null && !TextUtils.isEmpty(cnVar.webUrl) && c.this.onO != null && c.this.eck().ooQ != null && c.this.eck().ooQ.HR() != null && c.this.eck().ooQ.HR().aKu != null) {
                            x HR2 = c.this.eck().ooQ.HR();
                            c.this.onO.b(cnVar.webUrl, HR2.mLiveInfo.live_id, HR2.aKQ.userId, HR2.aKu.userId);
                        }
                    } else if (i == 22) {
                        c.this.ooj.ah(c.this.eck().ooQ.HR());
                        c.this.ecu();
                    } else if (i == 23 && c.this.KE()) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ag(BdBaseApplication.getInst(), String.valueOf(c.this.eck().ooQ.cmy().live_id), String.valueOf(c.this.eck().ooQ.cmy().group_id))));
                            c.this.ect();
                        } catch (Exception e) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(c.this.eck().pageContext.getPageActivity(), "请稍后重试", 1).show();
                                }
                            });
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.operation.b
        public void a(int i, com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
            if (i == 21 && c.this.KE()) {
                if (c.this.oof == null) {
                    c.this.oof = new g(c.this.eck().pageContext);
                }
                c.this.oof.b(eVar);
            }
        }
    };
    private boolean htI = false;

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
    }

    public void a(x xVar, String str, String str2) {
        this.htI = false;
        eck().ooR.setIsForceHandledTouch(false);
        eck().ooR.setSwipeClearEnable(false);
        eck().ooR.setOnLiveViewScrollListener(this.hra);
        if (this.hsw != null) {
            this.hsw.setVisibility(0);
        }
        cfd();
        cdm();
        cdo();
        cdt();
        ecs();
        ecq();
        ecp();
        cel();
        o.efg().m(xVar);
        cda();
        if (xVar != null && xVar.aLl != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_FEED_LOAD_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "audioConnect", null);
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aS(xVar.aLl.aVu, str2, str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void m(x xVar) {
        super.m(xVar);
        this.htI = false;
        eck().ooR.setIsForceHandledTouch(false);
        eck().ooR.setSwipeClearEnable(false);
        eck().ooR.setOnLiveViewScrollListener(this.hra);
        if (this.hsw != null) {
            this.hsw.setVisibility(0);
        }
        cfd();
        if (this.ood != null) {
            this.ood.a(xVar, this.hsw);
        }
        cdn();
        cdr();
        cdo();
        cdt();
        ecs();
        ecq();
        eco();
        ecm();
        ecp();
        nJ(false);
        ceg();
        cef();
        cel();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().ak(xVar);
        o.efg().m(xVar);
        cdj();
        ceh();
        cey();
        cdc();
        cdi();
        ceu();
        ccU();
        cex();
        c(this.gtp);
        cdf();
        MessageManager.getInstance().registerListener(this.oom);
        MessageManager.getInstance().registerListener(this.hre);
        MessageManager.getInstance().registerListener(this.hrj);
        MessageManager.getInstance().registerListener(this.hrk);
        MessageManager.getInstance().registerListener(this.hrh);
        cdx();
        cdq();
        cda();
        ecn();
    }

    private void ecm() {
        if (eck().ooQ != null && eck().ooQ.HR() != null) {
            x HR = eck().ooQ.HR();
            if (HR.aLq != null && HR.aLq.getRoomMode() == 2) {
                if (this.ool == null) {
                    this.ool = new com.baidu.tieba.yuyinala.liveroom.alaaudiopk.a(eck().pageContext);
                }
                this.ool.Y(eck().ooQ.HR());
                this.ool.aF(this.hsw);
                if (eck() != null && eck().ooQ != null) {
                    eck().ooQ.orz = true;
                    eck().ooQ.ag(eck().ooQ.HR());
                }
            }
        }
    }

    private void ecn() {
        o.efg().a(new o.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.10
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
            public void Ne(int i) {
                c.this.ceX();
                c.this.ceZ();
            }
        });
    }

    private void eco() {
        if (eck().ooQ.HR() != null && eck().ooQ.HR().aKu != null && eck().ooQ.HR().mLiveInfo != null) {
            x HR = eck().ooQ.HR();
            if (HR.aLq != null && HR.aLq.getRoomMode() == 1) {
                if (this.ook == null) {
                    this.ook = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(eck().pageContext);
                }
                this.ook.Y(eck().ooQ.HR());
                this.ook.aF(this.hsw);
            }
        }
    }

    private void ecp() {
        if (eck().ooQ.HR() != null && eck().ooQ.HR().aKu != null && eck().ooQ.HR().mLiveInfo != null && this.ooj == null) {
            this.ooj = new com.baidu.tieba.yuyinala.liveroom.l.a(eck().pageContext);
        }
    }

    private void ecq() {
        if (eck().ooQ.HR() != null && eck().ooQ.HR().aKu != null && eck().ooQ.HR().mLiveInfo != null) {
            if (this.ooi == null) {
                this.ooi = new com.baidu.tieba.yuyinala.liveroom.charmrank.a(eck().pageContext);
            }
            long j = eck().ooQ.HR().aKu.userId;
            int i = eck().ooQ.HR().mLiveInfo.live_type;
            String str = eck().ooQ.HR().aKu.portrait;
            String str2 = eck().ooQ.HR().mLiveInfo.feed_id;
            long j2 = eck().ooQ.HR().mLiveInfo.live_id;
            this.ooi.a(i, j, eck().ooQ.HR().aKu.userName, false, str, NL(), str2, j2);
            this.ooi.aF(this.hsw);
            this.ooi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    x HR = c.this.eck().ooQ.HR();
                    if (HR != null && HR.aKu != null) {
                        c.this.ecr();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmRankActivityConfig(c.this.eck().pageContext.getPageActivity(), HR.aKu.userName, Long.toString(HR.aKu.userId), Long.toString(HR.aKu.charmCount), String.valueOf(HR.aLl.croom_id), String.valueOf(HR.mLiveInfo.live_id), false, String.valueOf(HR.aKu.userId), Long.toString(HR.aKQ.userId), HR.aKQ.userName, HR.aKQ.portrait, 0L, HR.aKQ.userType)));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecr() {
        JSONObject jSONObject = new JSONObject();
        try {
            x HR = eck().ooQ.HR();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, HR.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "charmlist_clk").setContentExt(jSONObject));
    }

    private void ecs() {
        if (eck().ooQ.HR() != null && eck().ooQ.HR().aKu != null && eck().ooQ.HR().mLiveInfo != null) {
            if (this.ooh == null) {
                this.ooh = new com.baidu.tieba.yuyinala.liveroom.introduce.g(eck().pageContext);
            }
            this.ooh.Y(eck().ooQ.HR());
            this.ooh.aF(this.hsw);
            this.ooh.cJx();
        }
    }

    public void cdt() {
        if (eck().ooQ.HR() != null && eck().ooQ.HR().mLiveInfo != null && eck().ooQ.HR().aLl != null && eck().ooQ.HR().aLr) {
            if (this.oog == null) {
                this.oog = new com.baidu.tieba.yuyinala.liveroom.ranklist.a(eck().pageContext);
            }
            String str = eck().ooQ.HR().aKQ.userUk;
            int i = eck().ooQ.HR().mLiveInfo.live_type;
            String str2 = eck().ooQ.HR().aLl.cover;
            String str3 = eck().ooQ.HR().mLiveInfo.feed_id;
            long j = eck().ooQ.HR().mLiveInfo.live_id;
            this.oog.a(i, str, eck().ooQ.HR().aKu.userName, false, str2, NL(), str3, j, eck().ooQ.HR().aLl.croom_id, eck().ooQ.HR().aLl.aVD, eck().ooQ.HR().aLl.aVu, eck().ooQ.HR().aLl.cover, eck().ooQ.HR().aLl.room_name);
            this.oog.aF(this.hsw);
            this.oog.cJx();
        }
    }

    private void ccU() {
        if (this.onT != null) {
            this.onT.a(new a.InterfaceC0945a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.12
                @Override // com.baidu.tieba.yuyinala.liveroom.recommend.a.InterfaceC0945a
                public void cK(boolean z) {
                }
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(x xVar) {
        super.k(xVar);
        if (this.ood != null) {
            this.ood.M(xVar);
        }
        ab(xVar);
        aa(xVar);
        if (this.oog != null && xVar != null && xVar.aLl != null) {
            this.oog.Ns(xVar.aLl.aVD);
        }
        if (this.oob != null) {
            this.oob.j(xVar);
            this.oob.nB(this.hsG);
            this.oob.updateView();
            if (xVar != null && this.hso != null && !this.hso.hasInit && !TextUtils.isEmpty(this.hso.aRV)) {
                this.hso.hasInit = true;
                this.oob.Ic(this.hso.aRV);
            }
        }
    }

    private void aa(x xVar) {
        if (xVar != null && xVar.aLq != null && xVar.aLq.getRoomMode() == 2) {
            if (this.ool == null) {
                if (o.efg().efv()) {
                    this.ool = new com.baidu.tieba.yuyinala.liveroom.alaaudiopk.a(eck().pageContext);
                    this.ool.Y(xVar);
                    this.ool.aF(this.hsw);
                    this.ool.dtA();
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.13
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.ool.showView();
                        }
                    }, 1500L);
                } else {
                    this.ool = new com.baidu.tieba.yuyinala.liveroom.alaaudiopk.a(eck().pageContext);
                    this.ool.Y(xVar);
                    this.ool.aF(this.hsw);
                    this.ool.showView();
                }
            }
            if (eck() != null && eck().ooQ != null) {
                eck().ooQ.orz = true;
                eck().ooQ.ag(xVar);
                return;
            }
            return;
        }
        if (o.efg().efv()) {
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.14
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ool != null) {
                        c.this.ool.onDestroy();
                        c.this.ool = null;
                    }
                }
            }, 1500L);
        } else if (this.ool != null) {
            this.ool.onDestroy();
            this.ool = null;
        }
        if (eck() != null && eck().ooQ != null) {
            eck().ooQ.orz = false;
        }
    }

    private void ab(x xVar) {
        if (xVar != null && xVar.aLq != null && xVar.aLq.getRoomMode() == 1) {
            if (this.ook != null) {
                this.ook.k(xVar);
            } else if (o.efg().efv()) {
                this.ook = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(eck().pageContext);
                this.ook.Y(xVar);
                this.ook.de(this.hsw);
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.15
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.ook != null) {
                            c.this.ook.ecA();
                        }
                    }
                }, 1500L);
            } else {
                this.ook = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(eck().pageContext);
                this.ook.Y(xVar);
                this.ook.de(this.hsw);
                this.ook.ecA();
            }
        } else if (o.efg().efv()) {
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.16
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ook != null) {
                        c.this.ook.onDestroy();
                        c.this.ook = null;
                    }
                }
            }, 1500L);
        } else if (this.ook != null) {
            this.ook.onDestroy();
            this.ook = null;
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(r rVar) {
        if (rVar != null) {
            if (this.ooc != null && rVar.getList() != null) {
                this.ooc.e(rVar);
            }
            if (this.ooe != null) {
                this.ooe.eZ(rVar.getCount());
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dY(int i) {
        super.dY(i);
    }

    private void cda() {
        if (eck() != null && eck().pageContext != null && eck().pageContext.getPageActivity() != null) {
            if (this.bzK == null) {
                this.bzK = new PendantParentView(eck().pageContext.getPageActivity(), PendantParentView.Model.VERTICAL);
                u.a(eck().ooR, this.bzK, new ViewGroup.LayoutParams(-1, -1), 50);
                this.bzK.setDefaultItemMargin(eck().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
                this.bzK.setPadding(eck().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, eck().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            }
            ceX();
        }
    }

    private void cdc() {
        if (this.oob == null) {
            this.oob = new com.baidu.tieba.yuyinala.liveroom.activeview.b(eck().pageContext);
        }
        if (eck() != null && eck().ooQ != null) {
            this.oob.HZ(eck().ooQ.cmC());
        }
        this.oob.setOtherParams(NL());
        this.oob.c(eck().ooQ.HR(), false);
        this.oob.setHost(false);
        this.oob.nB(this.hsG);
        this.oob.a(1, this.bzK);
        this.oob.a(2, this.bzK);
        this.oob.setVisible(this.hsA ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceX() {
        if (this.bzK != null) {
            this.bzK.setModel(eck().ooQ.HR().aLq.getRoomMode() != 0 ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            this.bzK.setPosition(eck().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds164), 0, eck().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200), eck().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102));
            return;
        }
        cda();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceZ() {
        if (this.hrL != null && this.hqM != null && this.hrL.MA() != null && this.hrL.MA().getView() != null) {
            int I = com.baidu.tieba.yuyinala.liveroom.q.a.I(this.hsA, eck().ooQ.HR().aLq.getRoomMode());
            if (this.hsx.indexOfChild(this.hqM) != -1 && this.hqM.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqM.getLayoutParams();
                layoutParams.height = I;
                this.hqM.setLayoutParams(layoutParams);
            }
            if (this.hqM.indexOfChild(this.hrL.MA().getView()) != -1 && this.hrL.MA().getView().getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hrL.MA().getView().getLayoutParams();
                layoutParams2.height = I;
                this.hrL.MA().getView().setLayoutParams(layoutParams2);
            }
            this.hrL.MA().Mz();
        }
    }

    private void cfd() {
        if (this.htz == null) {
            this.htz = new LinearLayout(eck().pageContext.getPageActivity());
            this.htz.setOrientation(1);
        }
        if (this.htz.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = eck().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = eck().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            u.a(eck().ooR, this.htz, layoutParams, 600);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdi() {
        if (this.onH == null) {
            cdo();
        }
        this.onH.setOtherParams(NL());
        this.onH.a(e.ST().bCm, eck().ooQ.HR());
    }

    private void cel() {
        if (this.onN != null && eck() != null && eck().ooQ != null) {
            this.onN.d(this.hsw, eck().ooQ.HR());
        }
    }

    private void cdj() {
        CustomResponsedMessage runTask;
        if (this.hrL == null && (runTask = MessageManager.getInstance().runTask(2501045, k.class, eck().pageContext)) != null && runTask.getData() != null) {
            this.hrL = (k) runTask.getData();
            this.hrL.setFromMaster(false);
            this.hrL.MA().getView().setId(a.f.ala_liveroom_msg_list);
            this.hrL.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6
                @Override // com.baidu.live.im.k.a
                public boolean ME() {
                    return c.this.KE();
                }

                @Override // com.baidu.live.im.k.a
                public void MF() {
                    c.this.hsE = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hO(String str) {
                    if (!c.this.hsA) {
                        c.this.nG(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(c.this.eck().pageContext.getPageActivity(), c.this.eck().hBO.getLiveContainerView());
                    }
                    c.this.Ig(str);
                }

                @Override // com.baidu.live.im.k.a
                public void MG() {
                    if (c.this.hsA) {
                        c.this.nG(true);
                        c.this.eck().hBO.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.eck().pageContext.getPageActivity(), c.this.eck().hBO.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.hrL != null) {
                        c.this.hrL.MB().setQuickInputPanelVisible(false);
                        c.this.hrL.MB().Ow();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void MH() {
                    if (c.this.hsA) {
                        c.this.nG(true);
                        c.this.eck().hBO.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6.2
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.eck().pageContext.getPageActivity(), c.this.eck().hBO.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.hrL != null) {
                        c.this.hrL.MB().setQuickInputPanelVisible(false);
                        c.this.hrL.MB().Ow();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void MI() {
                    if (c.this.hsA) {
                        c.this.cdE();
                        if (c.this.hrM != null) {
                            c.this.hrM.Db();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean MJ() {
                    return c.this.cdR();
                }

                @Override // com.baidu.live.im.k.a
                public int MK() {
                    return c.this.cdS();
                }

                @Override // com.baidu.live.im.k.a
                public boolean ML() {
                    return false;
                }
            });
            this.hqM = new FrameLayout(eck().pageContext.getPageActivity());
            this.hqM.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hrL != null && this.hqM != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(eck().pageContext.getPageActivity()) * 0.7f);
            int I = com.baidu.tieba.yuyinala.liveroom.q.a.I(false, eck().ooQ.HR().aLq.getRoomMode());
            if (this.hsx.indexOfChild(this.hqM) < 0) {
                if (this.hqM.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hqM.getParent()).removeView(this.hqM);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, I);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.tieba.yuyinala.liveroom.q.a.dn(false);
                this.hsx.addView(this.hqM, layoutParams);
            }
            if (this.hqM.indexOfChild(this.hrL.MA().getView()) < 0) {
                if (this.hrL.MA().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrL.MA().getView()).removeView(this.hrL.MA().getView());
                }
                this.hqM.addView(this.hrL.MA().getView(), new FrameLayout.LayoutParams(equipmentWidth, I));
            }
            if (eck().ooR.indexOfChild(this.hrL.MB().getView()) < 0) {
                if (this.hrL.MB().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrL.MB().getView().getParent()).removeView(this.hrL.MB().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cea();
                eck().ooR.addView(this.hrL.MB().getView(), layoutParams2);
            }
            x HR = eck().ooQ.HR();
            if (HR != null && HR.mLiveInfo != null) {
                this.hrL.setLogData(HR.mLiveInfo.feed_id, NL());
            }
            this.hrL.a(String.valueOf(eck().ooQ.HR().mLiveInfo.group_id), String.valueOf(eck().ooQ.HR().mLiveInfo.last_msg_id), String.valueOf(eck().ooQ.HR().aKu.userId), String.valueOf(eck().ooQ.HR().mLiveInfo.live_id), eck().ooQ.HR().aKu.appId, (HR == null || HR.aLi == null || !HR.aLi.Eq()) ? false : true, eck().ooQ.HR().getGuardName());
            nG(false);
        }
    }

    private void cdm() {
        if (this.ood == null) {
            this.ood = new com.baidu.tieba.yuyinala.liveroom.i.b(eck().pageContext);
        }
        this.ood.e(this.hsw, eck().ooQ.HR());
    }

    private void cdn() {
        if (this.ooc == null) {
            this.ooc = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(eck().pageContext, this);
        }
        this.ooc.a(String.valueOf(eck().ooQ.HR().mLiveInfo.live_id), eck().ooQ.HR());
        this.ooc.c(this.hsw, a.f.ala_liveroom_hostheader, a.f.ala_liveroom_audience_count_layout);
        this.ooc.e(eck().ooQ.bWZ());
        this.ooc.setOtherParams(NL());
    }

    private void cdo() {
        if (this.onH == null) {
            this.onH = new com.baidu.tieba.yuyinala.liveroom.operation.a(eck().pageContext);
        }
        this.onH.a(eck(), this.hsx, eck().ooQ.HR().mLiveInfo, true, this.oon);
        this.onH.setOtherParams(NL());
    }

    public void nO(boolean z) {
        if (this.onH != null) {
            this.onH.nO(z);
        }
    }

    private void cdr() {
        if (this.ooe == null) {
            this.ooe = new com.baidu.tieba.yuyinala.liveroom.audiencelist.b(eck().pageContext.getPageActivity());
        }
        long j = 1;
        if (eck().ooQ.bWZ() != null) {
            j = eck().ooQ.bWZ().getCount();
        }
        this.ooe.a(this.oon);
        this.ooe.a(this.hsw, a.f.ala_liveroom_audience, j);
        this.ooe.setVisible(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ect() {
        JSONObject jSONObject = new JSONObject();
        try {
            x HR = eck().ooQ.HR();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, HR.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "msgbtn_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecu() {
        JSONObject jSONObject = new JSONObject();
        try {
            x HR = eck().ooQ.HR();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, HR.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "morefunc_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecv() {
        JSONObject jSONObject = new JSONObject();
        try {
            x HR = eck().ooQ.HR();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, HR.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "giftbtn_clk").setContentExt(jSONObject));
    }

    public void cds() {
        this.onI.d(eck().ooQ.HR(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecw() {
        JSONObject jSONObject = new JSONObject();
        try {
            x HR = eck().ooQ.HR();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, HR.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "olnumber_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecx() {
        JSONObject jSONObject = new JSONObject();
        try {
            x HR = eck().ooQ.HR();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, HR.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "closebtn_clk").setContentExt(jSONObject));
    }

    private void cdx() {
        if (this.hsE || this.hsF) {
            if ((TbadkCoreApplication.isLogin() && this.hrL.MB().hasText()) || this.hsF) {
                this.hsE = false;
                this.hsF = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.cdX();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void cdp() {
        cdq();
    }

    private void cdq() {
        if (this.onH != null) {
            int i = eck().ooQ.HR().aKQ.isUegBlock;
            int i2 = eck().ooQ.HR().aKQ.isBlock;
            String str = eck().ooQ.HR().aKQ.userName;
            if (i > 0 || i2 > 0) {
                this.onH.b(true, i, i2, str);
                this.hrL.a(true, i, i2, str);
                this.onM.b(true, i, i2, str);
                return;
            }
            this.onH.b(false, i, i2, str);
            this.hrL.a(false, i, i2, str);
            this.onM.b(false, i, i2, str);
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
                    if (eck().ooQ.HR() != null && eck().ooQ.HR().mLiveInfo != null) {
                        eck().ooQ.a(eck().ooQ.HR().mLiveInfo.live_id, eck().fromType, eck().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && eck().ooQ.HR() != null && eck().ooQ.HR().mLiveInfo != null && eck().ooQ.HR().aKQ != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == eck().ooQ.HR().aKQ.userId && optLong2 == eck().ooQ.HR().mLiveInfo.live_id) {
                        jSONObject.optInt("challenge_status");
                        jSONObject.optLong("challenge_id");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void Ib(String str) {
        if (this.oob != null) {
            this.oob.Ib(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void cC(boolean z) {
        super.cC(z);
        if (eck().ooR != null) {
            eck().ooR.cod();
            eck().ooR.setLiveViewOnDispatchTouchEventListener(null);
            eck().ooR.setLiveViewOnTouchEventListener(null);
            eck().ooR.setOnLiveViewScrollListener(null);
        }
        if (eck().bsZ != null) {
            eck().bsZ.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        cdy();
        if (this.onH != null) {
            this.onH.cmI();
        }
        if (this.ook != null) {
            this.ook.DC();
        }
        if (this.ool != null) {
            this.ool.DC();
        }
        if (this.bzK != null) {
            this.bzK.removeAllViews();
            this.bzK = null;
        }
        if (this.htz != null) {
            this.htz.removeAllViews();
            this.htz = null;
        }
        if (this.oob != null) {
            this.oob.release();
        }
        if (this.oog != null) {
            this.oog.DC();
        }
        if (this.ooh != null) {
            this.ooh.DC();
        }
        if (this.ooi != null) {
            this.ooi.DC();
        }
        if (this.ood != null) {
            this.ood.DC();
        }
        o.efg().DC();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cA(boolean z) {
        super.cA(z);
        cdy();
        if (this.ood != null) {
            this.ood.onDestroy();
        }
        if (this.ooc != null) {
            this.ooc.onDestroy();
        }
        if (this.hrL != null) {
            this.hrL.onDestroy();
        }
        if (this.onH != null) {
            this.onH.onDestory();
        }
        if (this.oob != null) {
            this.oob.release();
        }
        if (this.oog != null) {
            this.oog.onDestroy();
        }
        if (this.ooh != null) {
            this.ooh.onDestroy();
        }
        if (this.ooi != null) {
            this.ooi.onDestroy();
        }
        if (this.oof != null) {
            this.oof.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.oom);
        MessageManager.getInstance().unRegisterListener(this.hre);
        MessageManager.getInstance().unRegisterListener(this.hrj);
        MessageManager.getInstance().unRegisterListener(this.hrk);
        MessageManager.getInstance().unRegisterListener(this.hrh);
    }

    private void cdy() {
        if (this.hrL != null && this.hrL.MA().getView() != null && this.hrL.MA().getView().getParent() != null) {
            ((ViewGroup) this.hrL.MA().getView().getParent()).removeView(this.hrL.MA().getView());
        }
        if (this.hqM != null && this.hqM.getParent() != null) {
            ((ViewGroup) this.hqM.getParent()).removeView(this.hqM);
        }
        if (this.hrL != null && this.hrL.MB().getView() != null) {
            this.hsx.removeView(this.hrL.MB().getView());
        }
        if (this.hrL != null) {
            this.hrL.MA().setMsgData(new LinkedList());
            this.hrL.Dc();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void a(at atVar) {
        if (this.hrL != null) {
            cdX();
            this.hrL.MB().setEditText(" @" + atVar.getNameShow() + " ");
        }
        if (this.onH != null) {
            this.onH.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hrL != null) {
            cdX();
            this.hrL.MB().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.onH != null) {
            this.onH.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void b(at atVar) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected View cdz() {
        if (this.hrL != null) {
            return this.hrL.MB().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public boolean cdA() {
        if (this.hrL != null) {
            nG(false);
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    /* renamed from: cfj */
    public PendantParentView cdC() {
        return this.bzK;
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
                    this.hsB = false;
                    a(null, intExtra, intExtra2, intExtra3);
                    return;
                }
                cds();
                return;
            }
            azK();
        } else if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            IB(P(intent));
        }
    }

    private void IB(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) eck().pageContext.getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.ood != null) {
            this.ood.Io(fromJson.getBigurl());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.hrL != null && this.hrL.MA() != null) {
            this.hrL.MA().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hrL == null || this.hrL.MB() == null || !this.hrL.MB().Ov()) {
            if (z) {
                if (this.onH != null) {
                    this.onH.setVisibility(8);
                }
                if (this.hrN != null && this.hrN.Ho() != null) {
                    this.hrN.Ho().setVisibility(8);
                }
                cdE();
                if (this.hrL != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hrL.MB().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hrL.MB().getView().setLayoutParams(layoutParams);
                    this.hrL.MB().getView().setVisibility(0);
                    this.hrL.MB().setQuickInputPanelVisible(false);
                }
                if (this.hsw != null) {
                    this.hsw.setVisibility(8);
                }
                if (this.hrM != null) {
                    this.hrM.Db();
                }
                if (this.oob != null) {
                    this.oob.setVisible(8);
                }
                if (this.hsp != null) {
                    this.hsp.setCanVisible(false);
                }
            } else {
                cdD();
            }
            ceZ();
            if (this.hrZ != null) {
                this.hrZ.bB(z);
            }
        }
    }

    private void cdD() {
        if (this.onH != null) {
            this.onH.setVisibility(0);
        }
        if (this.hqM != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqM.getLayoutParams();
            layoutParams.bottomMargin = eck().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds120);
            this.hqM.setLayoutParams(layoutParams);
        }
        if (this.hrL != null) {
            cea();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrL.MB().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hrL.MB().getView().setLayoutParams(layoutParams2);
        }
        if (this.onH != null) {
            this.onH.setVisibility(0);
        }
        if (this.hrN != null && this.hrN.Ho() != null) {
            this.hrN.Ho().setVisibility(0);
        }
        if (this.hsw != null) {
            this.hsw.setVisibility(0);
        }
        if (this.oob != null) {
            this.oob.setVisible(0);
        }
        if (this.hrM != null) {
            this.hrM.Db();
        }
        if (this.hsp != null) {
            this.hsp.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdE() {
        boolean z;
        boolean z2;
        if (this.hqM != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqM.getLayoutParams();
            if (this.hrL == null || this.hrL.MB() == null) {
                z = false;
                z2 = false;
            } else {
                boolean Ot = this.hrL.MB().Ot();
                z = this.hrL.MB().Ou();
                z2 = Ot;
            }
            int O = O(z2, z);
            if (layoutParams.bottomMargin != O) {
                layoutParams.bottomMargin = O;
                this.hqM.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nG(boolean z) {
        this.htI = z;
        if (z) {
            this.hrL.MB().setQuickInputPanelVisible(true);
            return;
        }
        cdD();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3 && this.ooc != null) {
            this.ooc.dU(i3);
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public boolean ff(int i) {
        return super.ff(i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void wJ(int i) {
        super.wJ(i);
        if (i == 11) {
            if (this.onH != null) {
                this.onH.setVisibility(8);
            }
            if (this.hrL != null) {
                this.hrL.MA().getView().setVisibility(4);
            }
            if (this.oob != null) {
                this.oob.bP(2, 8);
            }
            if (this.onP != null) {
                this.onP.oG(false);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public void fg(int i) {
        super.fg(i);
        if (i == 11) {
            if (this.onH != null) {
                this.onH.setVisibility(0);
            }
            if (this.hrL != null) {
                this.hrL.MA().getView().setVisibility(0);
            }
            if (this.oob != null) {
                this.oob.setVisible(0);
            }
            if (this.onP != null) {
                this.onP.oG(true);
            }
            this.hsw.setVisibility(0);
        }
    }

    private void cdf() {
        if (this.onH != null) {
            this.onH.a(new a.InterfaceC0944a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.9
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.oob != null) {
            this.oob.onStop();
        }
        if (this.oog != null) {
            this.oog.cnf();
        }
        if (this.ooh != null) {
            this.ooh.cnf();
        }
        if (this.ooi != null) {
            this.ooi.cnf();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeN().onDestroy();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.oob != null) {
            this.oob.onStart();
        }
        if (this.oog != null) {
            this.oog.cne();
        }
        if (this.ooh != null) {
            this.ooh.cne();
        }
        if (this.ooi != null) {
            this.ooi.cne();
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d dVar) {
        if (this.ool != null) {
            this.ool.a(dVar);
        }
    }
}
