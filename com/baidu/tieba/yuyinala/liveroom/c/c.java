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
    private com.baidu.tieba.yuyinala.liveroom.activeview.b ooc;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.c ood;
    private com.baidu.tieba.yuyinala.liveroom.i.b ooe;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.b oof;
    private g oog;
    private com.baidu.tieba.yuyinala.liveroom.ranklist.a ooh;
    private com.baidu.tieba.yuyinala.liveroom.introduce.g ooi;
    private com.baidu.tieba.yuyinala.liveroom.charmrank.a ooj;
    private com.baidu.tieba.yuyinala.liveroom.l.a ook;
    private com.baidu.tieba.yuyinala.liveroom.datingnavigation.a ool;
    private com.baidu.tieba.yuyinala.liveroom.alaaudiopk.a oom;
    private long lastClickTime = 0;
    private com.baidu.live.liveroom.g.c hra = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.1
        @Override // com.baidu.live.liveroom.g.c
        public void PA() {
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cD(boolean z) {
            if (z) {
                if (c.this.onI != null) {
                    c.this.onI.No(8);
                }
            } else if (c.this.onI != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                    c.this.onI.No(0);
                } else {
                    c.this.onI.No(8);
                }
            }
            if (c.this.hrZ != null) {
                c.this.hrZ.bC(z);
            }
        }
    };
    private CustomMessageListener oon = new CustomMessageListener(2501032) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501032) {
                long currentTimeMillis = System.currentTimeMillis();
                if (c.this.ecj().ooR.HR() != null && c.this.ecj().ooR.HR().mLiveInfo != null) {
                    c.this.ecj().ooR.a(c.this.ecj().ooR.HR().mLiveInfo.live_id, c.this.ecj().fromType, c.this.ecj().enterTime, currentTimeMillis);
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
                        c.this.cdh();
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
                if (c.this.onS != null) {
                    c.this.onS.ie(str);
                }
            }
        }
    };
    private CustomMessageListener hrj = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (c.this.onP != null) {
                    c.this.onP.dismiss();
                }
                if (c.this.onS != null) {
                    c.this.onS.dismiss();
                }
                d.Nk().setSwitchStatus(true);
                d.Nk().setSelectId((String) customResponsedMessage.getData());
                if (c.this.mHandler == null) {
                    c.this.mHandler = new Handler();
                }
                c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.cdW();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.yuyinala.liveroom.operation.b ooo = new com.baidu.tieba.yuyinala.liveroom.operation.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7
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
                    c.this.ecu();
                    c.this.a(strArr, -1, -1, -1);
                } else if (i == 1) {
                    if (c.this.hrL != null) {
                        c.this.cdW();
                    }
                } else if (i == 3) {
                    c.this.onJ.d(c.this.ecj().ooR.HR(), false);
                } else if (i == 8) {
                    if (c.this.bsW != null) {
                        c.this.bsW.cx(false);
                    }
                    c.this.ecw();
                } else if (i != 12) {
                    if (i == 14) {
                        c.this.ecv();
                        x HR = c.this.ecj().ooR.HR();
                        if (HR != null && HR.aKu != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmCardActivityConfig(c.this.ecj().pageContext.getPageActivity(), HR.aKu.userName, Long.toString(HR.aKu.userId), Long.toString(HR.aKu.charmCount), String.valueOf(HR.mLiveInfo.group_id), String.valueOf(HR.mLiveInfo.live_id), false, String.valueOf(HR.aKu.userId), Long.toString(HR.aKQ.userId), HR.aKQ.userName, HR.aKQ.portrait, 0L, c.this.NL(), HR.aLt)));
                        }
                    } else if (i == 11) {
                        c.this.ceb();
                        c.this.cec();
                    } else if (i == 16) {
                        if (c.this.ecj() != null && (bqVar2 = com.baidu.live.af.a.SE().bCb) != null && (chVar2 = bqVar2.aRB) != null) {
                            String str3 = chVar2.aTe.aTp;
                            if (!TextUtils.isEmpty(str3)) {
                                long j = 0;
                                if (c.this.ecj().ooR != null && c.this.ecj().ooR.HR() != null && c.this.ecj().ooR.HR().mLiveInfo != null) {
                                    j = c.this.ecj().ooR.HR().mLiveInfo.live_id;
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", c.this.ecj().ooR.HR().mLiveInfo.room_id + "", c.this.ecj().ooR.HR().mLiveInfo.feed_id, c.this.NL());
                                }
                                if (str3.contains("?")) {
                                    str2 = str3 + "&liveId=" + j;
                                } else {
                                    str2 = str3 + "?liveId=" + j;
                                }
                                if (c.this.hfG == null) {
                                    c.this.hfG = new com.baidu.live.ap.a(c.this.ecj().pageContext.getPageActivity());
                                }
                                com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                                cVar.url = str2;
                                c.this.hfG.a(cVar);
                            }
                        }
                    } else if (i == 20) {
                        if (c.this.ecj() != null) {
                            x xVar = null;
                            if (c.this.ecj().ooR != null) {
                                xVar = c.this.ecj().ooR.HR();
                            }
                            if (xVar != null && xVar.mLiveInfo != null && com.baidu.tieba.yuyinala.liveroom.p.b.edp().bwr != null) {
                                String str4 = com.baidu.tieba.yuyinala.liveroom.p.b.edp().bwr.aMm;
                                if (!TextUtils.isEmpty(str4)) {
                                    if (str4.contains("?")) {
                                        str = str4 + "&live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    } else {
                                        str = str4 + "?live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    }
                                    if (c.this.hfG == null) {
                                        c.this.hfG = new com.baidu.live.ap.a(c.this.ecj().pageContext.getPageActivity());
                                    }
                                    com.baidu.live.ap.c cVar2 = new com.baidu.live.ap.c();
                                    cVar2.url = str;
                                    c.this.hfG.a(cVar2);
                                }
                            }
                        }
                    } else if (i == 17) {
                        if (c.this.KE() && c.this.ecj() != null && (bqVar = com.baidu.live.af.a.SE().bCb) != null && (chVar = bqVar.aRB) != null && (cnVar = chVar.aTf) != null && !TextUtils.isEmpty(cnVar.webUrl) && c.this.onP != null && c.this.ecj().ooR != null && c.this.ecj().ooR.HR() != null && c.this.ecj().ooR.HR().aKu != null) {
                            x HR2 = c.this.ecj().ooR.HR();
                            c.this.onP.b(cnVar.webUrl, HR2.mLiveInfo.live_id, HR2.aKQ.userId, HR2.aKu.userId);
                        }
                    } else if (i == 22) {
                        c.this.ook.ah(c.this.ecj().ooR.HR());
                        c.this.ect();
                    } else if (i == 23 && c.this.KE()) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ag(BdBaseApplication.getInst(), String.valueOf(c.this.ecj().ooR.cmx().live_id), String.valueOf(c.this.ecj().ooR.cmx().group_id))));
                            c.this.ecs();
                        } catch (Exception e) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(c.this.ecj().pageContext.getPageActivity(), "请稍后重试", 1).show();
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
                if (c.this.oog == null) {
                    c.this.oog = new g(c.this.ecj().pageContext);
                }
                c.this.oog.b(eVar);
            }
        }
    };
    private CustomMessageListener hGC = new CustomMessageListener(2913084, true) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean booleanValue;
            if ((customResponsedMessage.getData() instanceof Boolean) && (booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue())) {
                c.this.onKeyboardVisibilityChanged(booleanValue);
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
        ecj().ooS.setIsForceHandledTouch(false);
        ecj().ooS.setSwipeClearEnable(false);
        ecj().ooS.setOnLiveViewScrollListener(this.hra);
        if (this.hsw != null) {
            this.hsw.setVisibility(0);
        }
        cfc();
        cdl();
        cdn();
        cds();
        ecr();
        ecp();
        eco();
        cek();
        o.eff().m(xVar);
        ccZ();
        if (xVar != null && xVar.aLl != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_FEED_LOAD_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "audioConnect", null);
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aS(xVar.aLl.aVu, str2, str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void m(x xVar) {
        super.m(xVar);
        this.htI = false;
        ecj().ooS.setIsForceHandledTouch(false);
        ecj().ooS.setSwipeClearEnable(false);
        ecj().ooS.setOnLiveViewScrollListener(this.hra);
        if (this.hsw != null) {
            this.hsw.setVisibility(0);
        }
        cfc();
        if (this.ooe != null) {
            this.ooe.a(xVar, this.hsw);
        }
        cdm();
        cdq();
        cdn();
        cds();
        ecr();
        ecp();
        ecn();
        ecl();
        eco();
        nJ(false);
        cef();
        cee();
        cek();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().ak(xVar);
        o.eff().m(xVar);
        cdi();
        ceg();
        cex();
        cdb();
        cdh();
        cet();
        ccT();
        cew();
        c(this.gtp);
        cde();
        MessageManager.getInstance().registerListener(this.oon);
        MessageManager.getInstance().registerListener(this.hre);
        MessageManager.getInstance().registerListener(this.hrj);
        MessageManager.getInstance().registerListener(this.hrk);
        MessageManager.getInstance().registerListener(this.hrh);
        MessageManager.getInstance().registerListener(this.hGC);
        cdw();
        cdp();
        ccZ();
        ecm();
    }

    private void ecl() {
        if (ecj().ooR != null && ecj().ooR.HR() != null) {
            x HR = ecj().ooR.HR();
            if (HR.aLq != null && HR.aLq.getRoomMode() == 2) {
                if (this.oom == null) {
                    this.oom = new com.baidu.tieba.yuyinala.liveroom.alaaudiopk.a(ecj().pageContext);
                }
                this.oom.Y(ecj().ooR.HR());
                this.oom.aF(this.hsw);
                if (ecj() != null && ecj().ooR != null) {
                    ecj().ooR.orA = true;
                    ecj().ooR.ag(ecj().ooR.HR());
                }
            }
        }
    }

    private void ecm() {
        o.eff().a(new o.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.11
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
            public void Ne(int i) {
                c.this.ceW();
                c.this.ceY();
            }
        });
    }

    private void ecn() {
        if (ecj().ooR.HR() != null && ecj().ooR.HR().aKu != null && ecj().ooR.HR().mLiveInfo != null) {
            x HR = ecj().ooR.HR();
            if (HR.aLq != null && HR.aLq.getRoomMode() == 1) {
                if (this.ool == null) {
                    this.ool = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(ecj().pageContext);
                }
                this.ool.Y(ecj().ooR.HR());
                this.ool.aF(this.hsw);
            }
        }
    }

    private void eco() {
        if (ecj().ooR.HR() != null && ecj().ooR.HR().aKu != null && ecj().ooR.HR().mLiveInfo != null && this.ook == null) {
            this.ook = new com.baidu.tieba.yuyinala.liveroom.l.a(ecj().pageContext);
        }
    }

    private void ecp() {
        if (ecj().ooR.HR() != null && ecj().ooR.HR().aKu != null && ecj().ooR.HR().mLiveInfo != null) {
            if (this.ooj == null) {
                this.ooj = new com.baidu.tieba.yuyinala.liveroom.charmrank.a(ecj().pageContext);
            }
            long j = ecj().ooR.HR().aKu.userId;
            int i = ecj().ooR.HR().mLiveInfo.live_type;
            String str = ecj().ooR.HR().aKu.portrait;
            String str2 = ecj().ooR.HR().mLiveInfo.feed_id;
            long j2 = ecj().ooR.HR().mLiveInfo.live_id;
            this.ooj.a(i, j, ecj().ooR.HR().aKu.userName, false, str, NL(), str2, j2);
            this.ooj.aF(this.hsw);
            this.ooj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    x HR = c.this.ecj().ooR.HR();
                    if (HR != null && HR.aKu != null) {
                        c.this.ecq();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmRankActivityConfig(c.this.ecj().pageContext.getPageActivity(), HR.aKu.userName, Long.toString(HR.aKu.userId), Long.toString(HR.aKu.charmCount), String.valueOf(HR.aLl.croom_id), String.valueOf(HR.mLiveInfo.live_id), false, String.valueOf(HR.aKu.userId), Long.toString(HR.aKQ.userId), HR.aKQ.userName, HR.aKQ.portrait, 0L, HR.aKQ.userType)));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecq() {
        JSONObject jSONObject = new JSONObject();
        try {
            x HR = ecj().ooR.HR();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, HR.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "charmlist_clk").setContentExt(jSONObject));
    }

    private void ecr() {
        if (ecj().ooR.HR() != null && ecj().ooR.HR().aKu != null && ecj().ooR.HR().mLiveInfo != null) {
            if (this.ooi == null) {
                this.ooi = new com.baidu.tieba.yuyinala.liveroom.introduce.g(ecj().pageContext);
            }
            this.ooi.Y(ecj().ooR.HR());
            this.ooi.aF(this.hsw);
            this.ooi.cJw();
        }
    }

    public void cds() {
        if (ecj().ooR.HR() != null && ecj().ooR.HR().mLiveInfo != null && ecj().ooR.HR().aLl != null && ecj().ooR.HR().aLr) {
            if (this.ooh == null) {
                this.ooh = new com.baidu.tieba.yuyinala.liveroom.ranklist.a(ecj().pageContext);
            }
            String str = ecj().ooR.HR().aKQ.userUk;
            int i = ecj().ooR.HR().mLiveInfo.live_type;
            String str2 = ecj().ooR.HR().aLl.cover;
            String str3 = ecj().ooR.HR().mLiveInfo.feed_id;
            long j = ecj().ooR.HR().mLiveInfo.live_id;
            this.ooh.a(i, str, ecj().ooR.HR().aKu.userName, false, str2, NL(), str3, j, ecj().ooR.HR().aLl.croom_id, ecj().ooR.HR().aLl.aVD, ecj().ooR.HR().aLl.aVu, ecj().ooR.HR().aLl.cover, ecj().ooR.HR().aLl.room_name);
            this.ooh.aF(this.hsw);
            this.ooh.cJw();
        }
    }

    private void ccT() {
        if (this.onU != null) {
            this.onU.a(new a.InterfaceC0907a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.13
                @Override // com.baidu.tieba.yuyinala.liveroom.recommend.a.InterfaceC0907a
                public void cK(boolean z) {
                }
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(x xVar) {
        super.k(xVar);
        if (this.ooe != null) {
            this.ooe.M(xVar);
        }
        ab(xVar);
        aa(xVar);
        if (this.ooh != null && xVar != null && xVar.aLl != null) {
            this.ooh.Ns(xVar.aLl.aVD);
        }
        if (this.ooc != null) {
            this.ooc.j(xVar);
            this.ooc.nB(this.hsG);
            this.ooc.updateView();
            if (xVar != null && this.hso != null && !this.hso.hasInit && !TextUtils.isEmpty(this.hso.aRV)) {
                this.hso.hasInit = true;
                this.ooc.Id(this.hso.aRV);
            }
        }
    }

    private void aa(x xVar) {
        if (xVar != null && xVar.aLq != null && xVar.aLq.getRoomMode() == 2) {
            if (this.oom == null) {
                if (o.eff().efu()) {
                    this.oom = new com.baidu.tieba.yuyinala.liveroom.alaaudiopk.a(ecj().pageContext);
                    this.oom.Y(xVar);
                    this.oom.aF(this.hsw);
                    this.oom.dtz();
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.14
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.oom.showView();
                        }
                    }, 1500L);
                } else {
                    this.oom = new com.baidu.tieba.yuyinala.liveroom.alaaudiopk.a(ecj().pageContext);
                    this.oom.Y(xVar);
                    this.oom.aF(this.hsw);
                    this.oom.showView();
                }
            }
            if (ecj() != null && ecj().ooR != null) {
                ecj().ooR.orA = true;
                ecj().ooR.ag(xVar);
                return;
            }
            return;
        }
        if (o.eff().efu()) {
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.15
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.oom != null) {
                        c.this.oom.onDestroy();
                        c.this.oom = null;
                    }
                }
            }, 1500L);
        } else if (this.oom != null) {
            this.oom.onDestroy();
            this.oom = null;
        }
        if (ecj() != null && ecj().ooR != null) {
            ecj().ooR.orA = false;
        }
    }

    private void ab(x xVar) {
        if (xVar != null && xVar.aLq != null && xVar.aLq.getRoomMode() == 1) {
            if (this.ool != null) {
                this.ool.k(xVar);
            } else if (o.eff().efu()) {
                this.ool = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(ecj().pageContext);
                this.ool.Y(xVar);
                this.ool.de(this.hsw);
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.ool != null) {
                            c.this.ool.ecz();
                        }
                    }
                }, 1500L);
            } else {
                this.ool = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a(ecj().pageContext);
                this.ool.Y(xVar);
                this.ool.de(this.hsw);
                this.ool.ecz();
            }
        } else if (o.eff().efu()) {
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.17
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
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(r rVar) {
        if (rVar != null) {
            if (this.ood != null && rVar.getList() != null) {
                this.ood.e(rVar);
            }
            if (this.oof != null) {
                this.oof.eZ(rVar.getCount());
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dY(int i) {
        super.dY(i);
    }

    private void ccZ() {
        if (ecj() != null && ecj().pageContext != null && ecj().pageContext.getPageActivity() != null) {
            if (this.bzK == null) {
                this.bzK = new PendantParentView(ecj().pageContext.getPageActivity(), PendantParentView.Model.VERTICAL);
                u.a(ecj().ooS, this.bzK, new ViewGroup.LayoutParams(-1, -1), 50);
                this.bzK.setDefaultItemMargin(ecj().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
                this.bzK.setPadding(ecj().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, ecj().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            }
            ceW();
        }
    }

    private void cdb() {
        if (this.ooc == null) {
            this.ooc = new com.baidu.tieba.yuyinala.liveroom.activeview.b(ecj().pageContext);
        }
        if (ecj() != null && ecj().ooR != null) {
            this.ooc.Ia(ecj().ooR.cmB());
        }
        this.ooc.setOtherParams(NL());
        this.ooc.c(ecj().ooR.HR(), false);
        this.ooc.setHost(false);
        this.ooc.nB(this.hsG);
        this.ooc.a(1, this.bzK);
        this.ooc.a(2, this.bzK);
        this.ooc.setVisible(this.hsA ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceW() {
        if (this.bzK != null) {
            this.bzK.setModel(ecj().ooR.HR().aLq.getRoomMode() != 0 ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            this.bzK.setPosition(ecj().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds164), 0, ecj().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200), ecj().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102));
            return;
        }
        ccZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceY() {
        if (this.hrL != null && this.hqM != null && this.hrL.MA() != null && this.hrL.MA().getView() != null) {
            int I = com.baidu.tieba.yuyinala.liveroom.q.a.I(this.hsA, ecj().ooR.HR().aLq.getRoomMode());
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

    private void cfc() {
        if (this.htz == null) {
            this.htz = new LinearLayout(ecj().pageContext.getPageActivity());
            this.htz.setOrientation(1);
        }
        if (this.htz.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = ecj().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = ecj().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            u.a(ecj().ooS, this.htz, layoutParams, 600);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdh() {
        if (this.onI == null) {
            cdn();
        }
        this.onI.setOtherParams(NL());
        this.onI.a(e.ST().bCm, ecj().ooR.HR());
    }

    private void cek() {
        if (this.onO != null && ecj() != null && ecj().ooR != null) {
            this.onO.d(this.hsw, ecj().ooR.HR());
        }
    }

    private void cdi() {
        CustomResponsedMessage runTask;
        if (this.hrL == null && (runTask = MessageManager.getInstance().runTask(2501045, k.class, ecj().pageContext)) != null && runTask.getData() != null) {
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
                        BdUtilHelper.hideSoftKeyPad(c.this.ecj().pageContext.getPageActivity(), c.this.ecj().hBO.getLiveContainerView());
                    }
                    c.this.Ih(str);
                }

                @Override // com.baidu.live.im.k.a
                public void MG() {
                    if (c.this.hsA) {
                        c.this.nG(true);
                        c.this.ecj().hBO.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.ecj().pageContext.getPageActivity(), c.this.ecj().hBO.getLiveContainerView());
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
                        c.this.ecj().hBO.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.6.2
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.ecj().pageContext.getPageActivity(), c.this.ecj().hBO.getLiveContainerView());
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
                        c.this.cdD();
                        if (c.this.hrM != null) {
                            c.this.hrM.Db();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean MJ() {
                    return c.this.cdQ();
                }

                @Override // com.baidu.live.im.k.a
                public int MK() {
                    return c.this.cdR();
                }

                @Override // com.baidu.live.im.k.a
                public boolean ML() {
                    return false;
                }
            });
            this.hqM = new FrameLayout(ecj().pageContext.getPageActivity());
            this.hqM.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hrL != null && this.hqM != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(ecj().pageContext.getPageActivity()) * 0.7f);
            int I = com.baidu.tieba.yuyinala.liveroom.q.a.I(false, ecj().ooR.HR().aLq.getRoomMode());
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
            if (ecj().ooS.indexOfChild(this.hrL.MB().getView()) < 0) {
                if (this.hrL.MB().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrL.MB().getView().getParent()).removeView(this.hrL.MB().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cdZ();
                ecj().ooS.addView(this.hrL.MB().getView(), layoutParams2);
            }
            x HR = ecj().ooR.HR();
            if (HR != null && HR.mLiveInfo != null) {
                this.hrL.setLogData(HR.mLiveInfo.feed_id, NL());
            }
            this.hrL.a(String.valueOf(ecj().ooR.HR().mLiveInfo.group_id), String.valueOf(ecj().ooR.HR().mLiveInfo.last_msg_id), String.valueOf(ecj().ooR.HR().aKu.userId), String.valueOf(ecj().ooR.HR().mLiveInfo.live_id), ecj().ooR.HR().aKu.appId, (HR == null || HR.aLi == null || !HR.aLi.Eq()) ? false : true, ecj().ooR.HR().getGuardName());
            nG(false);
        }
    }

    private void cdl() {
        if (this.ooe == null) {
            this.ooe = new com.baidu.tieba.yuyinala.liveroom.i.b(ecj().pageContext);
        }
        this.ooe.e(this.hsw, ecj().ooR.HR());
    }

    private void cdm() {
        if (this.ood == null) {
            this.ood = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(ecj().pageContext, this);
        }
        this.ood.a(String.valueOf(ecj().ooR.HR().mLiveInfo.live_id), ecj().ooR.HR());
        this.ood.c(this.hsw, a.f.ala_liveroom_hostheader, a.f.ala_liveroom_audience_count_layout);
        this.ood.e(ecj().ooR.bWY());
        this.ood.setOtherParams(NL());
    }

    private void cdn() {
        if (this.onI == null) {
            this.onI = new com.baidu.tieba.yuyinala.liveroom.operation.a(ecj().pageContext);
        }
        this.onI.a(ecj(), this.hsx, ecj().ooR.HR().mLiveInfo, true, this.ooo);
        this.onI.setOtherParams(NL());
    }

    public void nO(boolean z) {
        if (this.onI != null) {
            this.onI.nO(z);
        }
    }

    private void cdq() {
        if (this.oof == null) {
            this.oof = new com.baidu.tieba.yuyinala.liveroom.audiencelist.b(ecj().pageContext.getPageActivity());
        }
        long j = 1;
        if (ecj().ooR.bWY() != null) {
            j = ecj().ooR.bWY().getCount();
        }
        this.oof.a(this.ooo);
        this.oof.a(this.hsw, a.f.ala_liveroom_audience, j);
        this.oof.setVisible(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecs() {
        JSONObject jSONObject = new JSONObject();
        try {
            x HR = ecj().ooR.HR();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, HR.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "msgbtn_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ect() {
        JSONObject jSONObject = new JSONObject();
        try {
            x HR = ecj().ooR.HR();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, HR.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "morefunc_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecu() {
        JSONObject jSONObject = new JSONObject();
        try {
            x HR = ecj().ooR.HR();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, HR.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "giftbtn_clk").setContentExt(jSONObject));
    }

    public void cdr() {
        this.onJ.d(ecj().ooR.HR(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecv() {
        JSONObject jSONObject = new JSONObject();
        try {
            x HR = ecj().ooR.HR();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, HR.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "olnumber_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecw() {
        JSONObject jSONObject = new JSONObject();
        try {
            x HR = ecj().ooR.HR();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, HR.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "closebtn_clk").setContentExt(jSONObject));
    }

    private void cdw() {
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
                        c.this.cdW();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void cdo() {
        cdp();
    }

    private void cdp() {
        if (this.onI != null) {
            int i = ecj().ooR.HR().aKQ.isUegBlock;
            int i2 = ecj().ooR.HR().aKQ.isBlock;
            String str = ecj().ooR.HR().aKQ.userName;
            if (i > 0 || i2 > 0) {
                this.onI.b(true, i, i2, str);
                this.hrL.a(true, i, i2, str);
                this.onN.b(true, i, i2, str);
                return;
            }
            this.onI.b(false, i, i2, str);
            this.hrL.a(false, i, i2, str);
            this.onN.b(false, i, i2, str);
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
                    if (ecj().ooR.HR() != null && ecj().ooR.HR().mLiveInfo != null) {
                        ecj().ooR.a(ecj().ooR.HR().mLiveInfo.live_id, ecj().fromType, ecj().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && ecj().ooR.HR() != null && ecj().ooR.HR().mLiveInfo != null && ecj().ooR.HR().aKQ != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == ecj().ooR.HR().aKQ.userId && optLong2 == ecj().ooR.HR().mLiveInfo.live_id) {
                        jSONObject.optInt("challenge_status");
                        jSONObject.optLong("challenge_id");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void Ic(String str) {
        if (this.ooc != null) {
            this.ooc.Ic(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void cC(boolean z) {
        super.cC(z);
        if (ecj().ooS != null) {
            ecj().ooS.coc();
            ecj().ooS.setLiveViewOnDispatchTouchEventListener(null);
            ecj().ooS.setLiveViewOnTouchEventListener(null);
            ecj().ooS.setOnLiveViewScrollListener(null);
        }
        if (ecj().bsZ != null) {
            ecj().bsZ.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        cdx();
        if (this.onI != null) {
            this.onI.cmH();
        }
        if (this.ool != null) {
            this.ool.DC();
        }
        if (this.oom != null) {
            this.oom.DC();
        }
        if (this.bzK != null) {
            this.bzK.removeAllViews();
            this.bzK = null;
        }
        if (this.htz != null) {
            this.htz.removeAllViews();
            this.htz = null;
        }
        if (this.ooc != null) {
            this.ooc.release();
        }
        if (this.ooh != null) {
            this.ooh.DC();
        }
        if (this.ooi != null) {
            this.ooi.DC();
        }
        if (this.ooj != null) {
            this.ooj.DC();
        }
        if (this.ooe != null) {
            this.ooe.DC();
        }
        o.eff().DC();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cA(boolean z) {
        super.cA(z);
        cdx();
        if (this.ooe != null) {
            this.ooe.onDestroy();
        }
        if (this.ood != null) {
            this.ood.onDestroy();
        }
        if (this.hrL != null) {
            this.hrL.onDestroy();
        }
        if (this.onI != null) {
            this.onI.onDestory();
        }
        if (this.ooc != null) {
            this.ooc.release();
        }
        if (this.ooh != null) {
            this.ooh.onDestroy();
        }
        if (this.ooi != null) {
            this.ooi.onDestroy();
        }
        if (this.ooj != null) {
            this.ooj.onDestroy();
        }
        if (this.oog != null) {
            this.oog.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.oon);
        MessageManager.getInstance().unRegisterListener(this.hre);
        MessageManager.getInstance().unRegisterListener(this.hrj);
        MessageManager.getInstance().unRegisterListener(this.hrk);
        MessageManager.getInstance().unRegisterListener(this.hrh);
        MessageManager.getInstance().unRegisterListener(this.hGC);
    }

    private void cdx() {
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
            cdW();
            this.hrL.MB().setEditText(" @" + atVar.getNameShow() + " ");
        }
        if (this.onI != null) {
            this.onI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hrL != null) {
            cdW();
            this.hrL.MB().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.onI != null) {
            this.onI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void b(at atVar) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected View cdy() {
        if (this.hrL != null) {
            return this.hrL.MB().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public boolean cdz() {
        if (this.hrL != null) {
            nG(false);
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    /* renamed from: cfi */
    public PendantParentView cdB() {
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
                cdr();
                return;
            }
            azJ();
        } else if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            IC(P(intent));
        }
    }

    private void IC(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) ecj().pageContext.getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.ooe != null) {
            this.ooe.Ip(fromJson.getBigurl());
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
                if (this.onI != null) {
                    this.onI.setVisibility(8);
                }
                if (this.hrN != null && this.hrN.Ho() != null) {
                    this.hrN.Ho().setVisibility(8);
                }
                cdD();
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
                if (this.ooc != null) {
                    this.ooc.setVisible(8);
                }
                if (this.hsp != null) {
                    this.hsp.setCanVisible(false);
                }
            } else {
                cdC();
            }
            if (this.hrZ != null) {
                this.hrZ.bB(z);
            }
        }
    }

    private void cdC() {
        if (this.onI != null) {
            this.onI.setVisibility(0);
        }
        if (this.hqM != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqM.getLayoutParams();
            layoutParams.bottomMargin = ecj().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds120);
            this.hqM.setLayoutParams(layoutParams);
        }
        if (this.hrL != null) {
            cdZ();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrL.MB().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hrL.MB().getView().setLayoutParams(layoutParams2);
        }
        if (this.onI != null) {
            this.onI.setVisibility(0);
        }
        if (this.hrN != null && this.hrN.Ho() != null) {
            this.hrN.Ho().setVisibility(0);
        }
        if (this.hsw != null) {
            this.hsw.setVisibility(0);
        }
        if (this.ooc != null) {
            this.ooc.setVisible(0);
        }
        if (this.hrM != null) {
            this.hrM.Db();
        }
        if (this.hsp != null) {
            this.hsp.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdD() {
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
        cdC();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3 && this.ood != null) {
            this.ood.dU(i3);
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
            if (this.onI != null) {
                this.onI.setVisibility(8);
            }
            if (this.hrL != null) {
                this.hrL.MA().getView().setVisibility(4);
            }
            if (this.ooc != null) {
                this.ooc.bP(2, 8);
            }
            if (this.onQ != null) {
                this.onQ.oG(false);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public void fg(int i) {
        super.fg(i);
        if (i == 11) {
            if (this.onI != null) {
                this.onI.setVisibility(0);
            }
            if (this.hrL != null) {
                this.hrL.MA().getView().setVisibility(0);
            }
            if (this.ooc != null) {
                this.ooc.setVisible(0);
            }
            if (this.onQ != null) {
                this.onQ.oG(true);
            }
            this.hsw.setVisibility(0);
        }
    }

    private void cde() {
        if (this.onI != null) {
            this.onI.a(new a.InterfaceC0906a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.10
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.ooc != null) {
            this.ooc.onStop();
        }
        if (this.ooh != null) {
            this.ooh.cne();
        }
        if (this.ooi != null) {
            this.ooi.cne();
        }
        if (this.ooj != null) {
            this.ooj.cne();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeM().onDestroy();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.ooc != null) {
            this.ooc.onStart();
        }
        if (this.ooh != null) {
            this.ooh.cnd();
        }
        if (this.ooi != null) {
            this.ooi.cnd();
        }
        if (this.ooj != null) {
            this.ooj.cnd();
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d dVar) {
        if (this.oom != null) {
            this.oom.a(dVar);
        }
    }
}
