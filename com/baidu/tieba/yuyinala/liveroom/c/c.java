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
    private FrameLayout hqt;
    private LinearLayout htd;
    private com.baidu.tieba.yuyinala.liveroom.activeview.b oto;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.c otp;
    private com.baidu.tieba.yuyinala.liveroom.i.b otq;
    private com.baidu.tieba.yuyinala.liveroom.audiencelist.b otr;
    private h ots;
    private com.baidu.tieba.yuyinala.liveroom.ranklist.a ott;
    private g otu;
    private com.baidu.tieba.yuyinala.liveroom.charmrank.a otv;
    private com.baidu.tieba.yuyinala.liveroom.l.a otw;
    private boolean otx;
    private boolean oty;
    private long lastClickTime = 0;
    private com.baidu.live.liveroom.g.c hqH = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.1
        @Override // com.baidu.live.liveroom.g.c
        public void Nd() {
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cI(boolean z) {
            if (z) {
                if (c.this.osV != null) {
                    c.this.osV.Mc(8);
                }
            } else if (c.this.osV != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                    c.this.osV.Mc(0);
                } else {
                    c.this.osV.Mc(8);
                }
            }
            if (c.this.hrF != null) {
                c.this.hrF.bD(z);
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
                    if (!c.this.oty) {
                        c.this.oty = true;
                        if (c.this.otv != null) {
                            c.this.otv.zT(c.this.oty);
                        }
                    }
                } else if (!c.this.otx && c.this.oty) {
                    c.this.oty = false;
                    if (c.this.otv != null) {
                        c.this.otv.zT(c.this.oty);
                    }
                }
            }
        }
    };
    private CustomMessageListener otz = new CustomMessageListener(2501032) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501032) {
                long currentTimeMillis = System.currentTimeMillis();
                if (c.this.eaF().oud.Fm() != null && c.this.eaF().oud.Fm().mLiveInfo != null) {
                    c.this.eaF().oud.a(c.this.eaF().oud.Fm().mLiveInfo.live_id, c.this.eaF().fromType, c.this.eaF().enterTime, currentTimeMillis);
                }
            }
        }
    };
    private HttpMessageListener hqL = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Ow() != null) {
                        e.Qz().bBd = getQuickGiftHttpResponseMessage.Ow();
                        c.this.cam();
                    }
                }
            }
        }
    };
    CustomMessageListener hqQ = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2913168) {
            }
        }
    };
    private CustomMessageListener hqP = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                d.KN().setSwitchStatus(true);
                d.KN().setSelectId((String) customResponsedMessage.getData());
                if (c.this.mHandler == null) {
                    c.this.mHandler = new Handler();
                }
                c.this.otj = true;
                c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.caZ();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.yuyinala.liveroom.operation.b otA = new com.baidu.tieba.yuyinala.liveroom.operation.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3
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
                    c.this.eaP();
                    c.this.a(strArr, -1, -1, -1);
                } else if (i == 1) {
                    if (c.this.hrr != null) {
                        c.this.caZ();
                    }
                } else if (i == 3) {
                    c.this.osW.d(c.this.eaF().oud.Fm(), false);
                } else if (i == 8) {
                    if (c.this.brL != null) {
                        c.this.brL.cC(false);
                    }
                    c.this.eaR();
                } else if (i != 12) {
                    if (i == 14) {
                        c.this.eaQ();
                        ab Fm = c.this.eaF().oud.Fm();
                        if (Fm != null && Fm.aId != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmCardActivityConfig(c.this.eaF().pageContext.getPageActivity(), Fm.aId.userName, Long.toString(Fm.aId.userId), Long.toString(Fm.aId.charmCount), String.valueOf(Fm.mLiveInfo.group_id), String.valueOf(Fm.mLiveInfo.live_id), false, String.valueOf(Fm.aId.userId), Long.toString(Fm.aIz.userId), Fm.aIz.userName, Fm.aIz.portrait, 0L, c.this.Lo(), Fm.aJb)));
                        }
                    } else if (i == 11) {
                        c.this.cbe();
                        c.this.cbf();
                    } else if (i == 16) {
                        if (c.this.eaF() != null && (bvVar = com.baidu.live.ae.a.Qj().bAS) != null && (coVar = bvVar.aPM) != null) {
                            String str3 = coVar.aRu.aRE;
                            if (!TextUtils.isEmpty(str3)) {
                                long j = 0;
                                if (c.this.eaF().oud != null && c.this.eaF().oud.Fm() != null && c.this.eaF().oud.Fm().mLiveInfo != null) {
                                    j = c.this.eaF().oud.Fm().mLiveInfo.live_id;
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", c.this.eaF().oud.Fm().mLiveInfo.room_id + "", c.this.eaF().oud.Fm().mLiveInfo.feed_id, c.this.Lo());
                                }
                                if (str3.contains("?")) {
                                    str2 = str3 + "&liveId=" + j;
                                } else {
                                    str2 = str3 + "?liveId=" + j;
                                }
                                if (c.this.bgE == null) {
                                    c.this.bgE = new com.baidu.live.an.a(c.this.eaF().pageContext.getPageActivity());
                                }
                                com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                                cVar.url = str2;
                                c.this.bgE.a(cVar);
                            }
                        }
                    } else if (i == 20) {
                        if (c.this.eaF() != null) {
                            ab abVar = null;
                            if (c.this.eaF().oud != null) {
                                abVar = c.this.eaF().oud.Fm();
                            }
                            if (abVar != null && abVar.mLiveInfo != null && com.baidu.tieba.yuyinala.liveroom.p.b.ebL().bvg != null) {
                                String str4 = com.baidu.tieba.yuyinala.liveroom.p.b.ebL().bvg.aKd;
                                if (!TextUtils.isEmpty(str4)) {
                                    if (str4.contains("?")) {
                                        str = str4 + "&live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    } else {
                                        str = str4 + "?live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                    }
                                    if (c.this.bgE == null) {
                                        c.this.bgE = new com.baidu.live.an.a(c.this.eaF().pageContext.getPageActivity());
                                    }
                                    com.baidu.live.an.c cVar2 = new com.baidu.live.an.c();
                                    cVar2.url = str;
                                    c.this.bgE.a(cVar2);
                                }
                            }
                        }
                    } else if (i == 22) {
                        c.this.otw.ah(c.this.eaF().oud.Fm());
                        c.this.eaO();
                    } else if (i == 23 && c.this.HZ()) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ag(BdBaseApplication.getInst(), String.valueOf(c.this.eaF().oud.cjz().live_id), String.valueOf(c.this.eaF().oud.cjz().group_id))));
                            c.this.eaN();
                        } catch (Exception e) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(c.this.eaF().pageContext.getPageActivity(), "请稍后重试", 1).show();
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
                if (c.this.ots == null) {
                    c.this.ots = new h(c.this.eaF().pageContext);
                }
                c.this.ots.b(eVar);
            }
        }
    };
    private boolean htn = false;

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
    }

    public void a(ab abVar, String str, String str2) {
        this.htn = false;
        eaF().oue.setIsForceHandledTouch(false);
        eaF().oue.setSwipeClearEnable(false);
        eaF().oue.setOnLiveViewScrollListener(this.hqH);
        if (this.hsa != null) {
            this.hsa.setVisibility(0);
        }
        ccf();
        caq();
        cas();
        cax();
        eaJ();
        cbn();
        q.edE().a(eaF(), abVar);
        cae();
        if (abVar != null && abVar.aIU != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_FEED_LOAD_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "audioConnect", null);
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().aS(abVar.aIU.aTK, str2, str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void m(ab abVar) {
        super.m(abVar);
        this.htn = false;
        eaF().oue.setIsForceHandledTouch(false);
        eaF().oue.setSwipeClearEnable(false);
        eaF().oue.setOnLiveViewScrollListener(this.hqH);
        if (this.hsa != null) {
            this.hsa.setVisibility(0);
        }
        ccf();
        if (this.otq != null) {
            this.otq.a(abVar, this.hsa);
        }
        car();
        cav();
        cas();
        cax();
        eaM();
        eaK();
        eaH();
        eaJ();
        nQ(false);
        cbi();
        cbh();
        cbn();
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ak(abVar);
        q.edE().a(eaF(), abVar);
        can();
        cbj();
        cbA();
        cag();
        cam();
        cbw();
        bZY();
        cbz();
        c(this.grr);
        caj();
        MessageManager.getInstance().registerListener(this.otz);
        MessageManager.getInstance().registerListener(this.hqL);
        MessageManager.getInstance().registerListener(this.hqP);
        MessageManager.getInstance().registerListener(this.hqQ);
        MessageManager.getInstance().registerListener(this.cak);
        caB();
        cau();
        cae();
        eaI();
    }

    private void eaH() {
        if (eaF().oud != null && eaF().oud.Fm() != null) {
            ab Fm = eaF().oud.Fm();
            if (Fm.aIY != null && Fm.aIY.getRoomMode() == 2 && eaF() != null && eaF().oud != null) {
                eaF().oud.owK = true;
                eaF().oud.ag(eaF().oud.Fm());
            }
        }
    }

    private void eaI() {
        q.edE().a(new q.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.7
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.q.a
            public void LS(int i) {
                c.this.cbZ();
                c.this.ccb();
            }
        });
    }

    private void eaJ() {
        if (eaF().oud.Fm() != null && eaF().oud.Fm().aId != null && eaF().oud.Fm().mLiveInfo != null && this.otw == null) {
            this.otw = new com.baidu.tieba.yuyinala.liveroom.l.a(eaF().pageContext);
        }
    }

    private void eaK() {
        if (eaF().oud.Fm() != null && eaF().oud.Fm().aId != null && eaF().oud.Fm().mLiveInfo != null) {
            if (this.otv == null) {
                this.otv = new com.baidu.tieba.yuyinala.liveroom.charmrank.a(eaF().pageContext);
            }
            long j = eaF().oud.Fm().aId.userId;
            int i = eaF().oud.Fm().mLiveInfo.live_type;
            String str = eaF().oud.Fm().aId.portrait;
            String str2 = eaF().oud.Fm().mLiveInfo.feed_id;
            long j2 = eaF().oud.Fm().mLiveInfo.live_id;
            String str3 = eaF().oud.Fm().aId.userName;
            this.otx = eaF().oud.Fm().aJw;
            if (eaF().oud.Fm().aIY.getRoomMode() == 100 && !this.otx) {
                this.oty = false;
            } else {
                this.oty = true;
            }
            this.otv.a(i, j, str3, false, str, Lo(), str2, j2, this.oty);
            this.otv.aF(this.hsa);
            this.otv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ab Fm = c.this.eaF().oud.Fm();
                    if (Fm != null && Fm.aId != null) {
                        c.this.eaL();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaCharmRankActivityConfig(c.this.eaF().pageContext.getPageActivity(), Fm.aId.userName, Long.toString(Fm.aId.userId), Long.toString(Fm.aId.charmCount), String.valueOf(Fm.aIU.croom_id), String.valueOf(Fm.mLiveInfo.live_id), false, String.valueOf(Fm.aId.userId), Long.toString(Fm.aIz.userId), Fm.aIz.userName, Fm.aIz.portrait, 0L, Fm.aIz.userType, c.this.oty)));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaL() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = eaF().oud.Fm();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fm.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "charmlist_clk").setContentExt(jSONObject));
    }

    private void eaM() {
        if (eaF().oud.Fm() != null && eaF().oud.Fm().aId != null && eaF().oud.Fm().mLiveInfo != null) {
            if (this.otu == null) {
                this.otu = new g(eaF().pageContext);
            }
            this.otu.af(eaF().oud.Fm());
            this.otu.aF(this.hsa);
            this.otu.cGS();
        }
    }

    public void cax() {
        if (eaF().oud.Fm() != null && eaF().oud.Fm().mLiveInfo != null && eaF().oud.Fm().aIU != null && eaF().oud.Fm().aIZ) {
            if (this.ott == null) {
                this.ott = new com.baidu.tieba.yuyinala.liveroom.ranklist.a(eaF().pageContext);
            }
            String str = eaF().oud.Fm().aIz.userUk;
            int i = eaF().oud.Fm().mLiveInfo.live_type;
            String str2 = eaF().oud.Fm().aIU.cover;
            String str3 = eaF().oud.Fm().mLiveInfo.feed_id;
            long j = eaF().oud.Fm().mLiveInfo.live_id;
            this.ott.a(i, str, eaF().oud.Fm().aId.userName, false, str2, Lo(), str3, j, eaF().oud.Fm().aIU.croom_id, eaF().oud.Fm().aIU.aTT, eaF().oud.Fm().aIU.aTK, eaF().oud.Fm().aIU.cover, eaF().oud.Fm().aIU.room_name);
            this.ott.aF(this.hsa);
            this.ott.cGS();
        }
    }

    private void bZY() {
        if (this.otf != null) {
            this.otf.a(new a.InterfaceC0932a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.9
                @Override // com.baidu.tieba.yuyinala.liveroom.recommend.a.InterfaceC0932a
                public void cP(boolean z) {
                }
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(ab abVar) {
        super.k(abVar);
        if (this.otq != null) {
            this.otq.N(abVar);
        }
        aa(abVar);
        if (this.ott != null && abVar != null && abVar.aIU != null) {
            this.ott.Mg(abVar.aIU.aTT);
        }
        if (this.oto != null) {
            this.oto.j(abVar);
            this.oto.nI(this.hsk);
            this.oto.updateView();
            if (abVar != null && this.hrS != null && !this.hrS.hasInit && !TextUtils.isEmpty(this.hrS.aQj)) {
                this.hrS.hasInit = true;
                this.oto.Hv(this.hrS.aQj);
            }
        }
    }

    private void aa(ab abVar) {
        if (abVar != null && abVar.aIY != null && abVar.aIY.getRoomMode() == 2) {
            if (eaF() != null && eaF().oud != null) {
                eaF().oud.owK = true;
                eaF().oud.ag(abVar);
            }
        } else if (eaF() != null && eaF().oud != null) {
            eaF().oud.owK = false;
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(v vVar) {
        if (vVar != null) {
            if (this.otp != null && vVar.getList() != null) {
                this.otp.e(vVar);
            }
            if (this.otr != null) {
                this.otr.ff(vVar.getCount());
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cv(int i) {
        super.cv(i);
    }

    private void cae() {
        if (eaF() != null && eaF().pageContext != null && eaF().pageContext.getPageActivity() != null) {
            if (this.byA == null) {
                this.byA = new PendantParentView(eaF().pageContext.getPageActivity(), PendantParentView.Model.VERTICAL);
                u.a(eaF().oue, this.byA, new ViewGroup.LayoutParams(-1, -1), 50);
                this.byA.setDefaultItemMargin(eaF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
                this.byA.setPadding(eaF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, eaF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            }
            cbZ();
        }
    }

    private void cag() {
        if (this.oto == null) {
            this.oto = new com.baidu.tieba.yuyinala.liveroom.activeview.b(eaF().pageContext);
        }
        if (eaF() != null && eaF().oud != null) {
            this.oto.Hs(eaF().oud.cjD());
        }
        this.oto.setOtherParams(Lo());
        this.oto.c(eaF().oud.Fm(), false);
        this.oto.setHost(false);
        this.oto.nI(this.hsk);
        this.oto.a(1, this.byA);
        this.oto.a(2, this.byA);
        this.oto.setVisible(this.hse ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbZ() {
        if (this.byA != null) {
            int roomMode = eaF().oud.Fm().aIY.getRoomMode();
            this.byA.setIsAudioRoom(true);
            this.byA.setModel(roomMode != 0 ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            this.byA.setPosition(eaF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds164), 0, eaF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200), eaF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102));
            return;
        }
        cae();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccb() {
        if (this.hrr != null && this.hqt != null && this.hrr.Kd() != null && this.hrr.Kd().getView() != null) {
            int I = com.baidu.tieba.yuyinala.liveroom.q.a.I(this.hse, eaF().oud.Fm().aIY.getRoomMode());
            if (this.hsb.indexOfChild(this.hqt) != -1 && this.hqt.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqt.getLayoutParams();
                layoutParams.height = I;
                this.hqt.setLayoutParams(layoutParams);
            }
            if (this.hqt.indexOfChild(this.hrr.Kd().getView()) != -1 && this.hrr.Kd().getView().getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hrr.Kd().getView().getLayoutParams();
                layoutParams2.height = I;
                this.hrr.Kd().getView().setLayoutParams(layoutParams2);
            }
            this.hrr.Kd().Kc();
        }
    }

    private void ccf() {
        if (this.htd == null) {
            this.htd = new LinearLayout(eaF().pageContext.getPageActivity());
            this.htd.setOrientation(1);
        }
        if (this.htd.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = eaF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = eaF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            u.a(eaF().oue, this.htd, layoutParams, 600);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cam() {
        if (this.osV == null) {
            cas();
        }
        this.osV.setOtherParams(Lo());
        this.osV.a(e.Qz().bBd, eaF().oud.Fm());
    }

    private void cbn() {
        if (this.otb != null && eaF() != null && eaF().oud != null) {
            this.otb.d(this.hsa, eaF().oud.Fm());
        }
    }

    private void can() {
        CustomResponsedMessage runTask;
        if (this.hrr == null && (runTask = MessageManager.getInstance().runTask(2501045, k.class, eaF().pageContext)) != null && runTask.getData() != null) {
            this.hrr = (k) runTask.getData();
            this.hrr.setFromMaster(false);
            this.hrr.Kd().getView().setId(a.f.ala_liveroom_msg_list);
            this.hrr.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2
                @Override // com.baidu.live.im.k.a
                public boolean Kh() {
                    return c.this.HZ();
                }

                @Override // com.baidu.live.im.k.a
                public void Ki() {
                    c.this.hsi = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hb(String str) {
                    if (!c.this.hse) {
                        c.this.nN(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(c.this.eaF().pageContext.getPageActivity(), c.this.eaF().hBs.getLiveContainerView());
                    }
                    c.this.Hz(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Kj() {
                    if (c.this.hse) {
                        c.this.nN(true);
                        c.this.eaF().hBs.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.eaF().pageContext.getPageActivity(), c.this.eaF().hBs.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.hrr != null) {
                        c.this.hrr.Ke().setQuickInputPanelVisible(false);
                        c.this.hrr.Ke().LZ();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Kk() {
                    if (c.this.hse) {
                        c.this.nN(true);
                        c.this.eaF().hBs.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(c.this.eaF().pageContext.getPageActivity(), c.this.eaF().hBs.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (c.this.hrr != null) {
                        c.this.hrr.Ke().setQuickInputPanelVisible(false);
                        c.this.hrr.Ke().LZ();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Kl() {
                    if (c.this.hse) {
                        c.this.caI();
                        if (c.this.hrs != null) {
                            c.this.hrs.zQ();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Km() {
                    return c.this.caV();
                }

                @Override // com.baidu.live.im.k.a
                public int Kn() {
                    return c.this.caW();
                }

                @Override // com.baidu.live.im.k.a
                public boolean Ko() {
                    return false;
                }
            });
            this.hqt = new FrameLayout(eaF().pageContext.getPageActivity());
            this.hqt.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hrr != null && this.hqt != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(eaF().pageContext.getPageActivity()) * 0.7f);
            int I = com.baidu.tieba.yuyinala.liveroom.q.a.I(false, eaF().oud.Fm().aIY.getRoomMode());
            if (this.hsb.indexOfChild(this.hqt) < 0) {
                if (this.hqt.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hqt.getParent()).removeView(this.hqt);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, I);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.tieba.yuyinala.liveroom.q.a.dr(false);
                this.hsb.addView(this.hqt, layoutParams);
            }
            if (this.hqt.indexOfChild(this.hrr.Kd().getView()) < 0) {
                if (this.hrr.Kd().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrr.Kd().getView()).removeView(this.hrr.Kd().getView());
                }
                this.hqt.addView(this.hrr.Kd().getView(), new FrameLayout.LayoutParams(equipmentWidth, I));
            }
            if (eaF().oue.indexOfChild(this.hrr.Ke().getView()) < 0) {
                if (this.hrr.Ke().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrr.Ke().getView().getParent()).removeView(this.hrr.Ke().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cbc();
                u.a(eaF().oue, this.hrr.Ke().getView(), layoutParams2, 450);
            }
            ab Fm = eaF().oud.Fm();
            if (Fm != null && Fm.mLiveInfo != null) {
                this.hrr.setLogData(Fm.mLiveInfo.feed_id, Lo());
            }
            this.hrr.a(String.valueOf(eaF().oud.Fm().mLiveInfo.group_id), String.valueOf(eaF().oud.Fm().mLiveInfo.last_msg_id), String.valueOf(eaF().oud.Fm().aId.userId), String.valueOf(eaF().oud.Fm().mLiveInfo.live_id), eaF().oud.Fm().aId.appId, (Fm == null || Fm.aIR == null || !Fm.aIR.Bf()) ? false : true, eaF().oud.Fm().getGuardName());
            nN(false);
        }
    }

    private void caq() {
        if (this.otq == null) {
            this.otq = new com.baidu.tieba.yuyinala.liveroom.i.b(eaF().pageContext);
        }
        this.otq.e(this.hsa, eaF().oud.Fm());
    }

    private void car() {
        if (this.otp == null) {
            this.otp = new com.baidu.tieba.yuyinala.liveroom.audiencelist.c(eaF().pageContext, this);
        }
        this.otp.a(String.valueOf(eaF().oud.Fm().mLiveInfo.live_id), eaF().oud.Fm());
        this.otp.c(this.hsa, a.f.ala_liveroom_hostheader, a.f.ala_liveroom_audience_count_layout);
        this.otp.e(eaF().oud.bTK());
        this.otp.setOtherParams(Lo());
    }

    private void cas() {
        if (this.osV == null) {
            this.osV = new com.baidu.tieba.yuyinala.liveroom.operation.a(eaF().pageContext);
        }
        this.osV.a(eaF(), this.hsb, eaF().oud.Fm().mLiveInfo, true, this.otA);
        this.osV.setOtherParams(Lo());
    }

    public void nV(boolean z) {
        if (this.osV != null) {
            this.osV.nV(z);
        }
    }

    private void cav() {
        if (this.otr == null) {
            this.otr = new com.baidu.tieba.yuyinala.liveroom.audiencelist.b(eaF().pageContext.getPageActivity());
        }
        long j = 1;
        if (eaF().oud.bTK() != null) {
            j = eaF().oud.bTK().getCount();
        }
        this.otr.a(this.otA);
        this.otr.a(this.hsa, a.f.ala_liveroom_audience, j);
        this.otr.setVisible(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaN() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = eaF().oud.Fm();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fm.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "msgbtn_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaO() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = eaF().oud.Fm();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fm.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "morefunc_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaP() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = eaF().oud.Fm();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fm.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "giftbtn_clk").setContentExt(jSONObject));
    }

    public void caw() {
        this.osW.d(eaF().oud.Fm(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = eaF().oud.Fm();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fm.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "olnumber_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaR() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = eaF().oud.Fm();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fm.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "closebtn_clk").setContentExt(jSONObject));
    }

    private void caB() {
        if (this.hsi || this.hsj) {
            if ((TbadkCoreApplication.isLogin() && this.hrr.Ke().hasText()) || this.hsj) {
                this.hsi = false;
                this.hsj = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.otj = true;
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.4
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.caZ();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void cat() {
        cau();
    }

    private void cau() {
        if (this.osV != null) {
            int i = eaF().oud.Fm().aIz.isUegBlock;
            int i2 = eaF().oud.Fm().aIz.isBlock;
            String str = eaF().oud.Fm().aIz.userName;
            if (i > 0 || i2 > 0) {
                this.osV.b(true, i, i2, str);
                this.hrr.a(true, i, i2, str);
                this.ota.b(true, i, i2, str);
                return;
            }
            this.osV.b(false, i, i2, str);
            this.hrr.a(false, i, i2, str);
            this.ota.b(false, i, i2, str);
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
                    if (eaF().oud.Fm() != null && eaF().oud.Fm().mLiveInfo != null) {
                        eaF().oud.a(eaF().oud.Fm().mLiveInfo.live_id, eaF().fromType, eaF().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && eaF().oud.Fm() != null && eaF().oud.Fm().mLiveInfo != null && eaF().oud.Fm().aIz != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == eaF().oud.Fm().aIz.userId && optLong2 == eaF().oud.Fm().mLiveInfo.live_id) {
                        jSONObject.optInt("challenge_status");
                        jSONObject.optLong("challenge_id");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void Hu(String str) {
        if (this.oto != null) {
            this.oto.Hu(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void cH(boolean z) {
        super.cH(z);
        if (eaF().oue != null) {
            eaF().oue.clj();
            eaF().oue.setLiveViewOnDispatchTouchEventListener(null);
            eaF().oue.setLiveViewOnTouchEventListener(null);
            eaF().oue.setOnLiveViewScrollListener(null);
        }
        if (eaF().brO != null) {
            eaF().brO.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        caC();
        if (this.osV != null) {
            this.osV.cjP();
        }
        if (this.byA != null) {
            this.byA.removeAllViews();
            this.byA = null;
        }
        if (this.htd != null) {
            this.htd.removeAllViews();
            this.htd = null;
        }
        if (this.oto != null) {
            this.oto.release();
        }
        if (this.ott != null) {
            this.ott.Ar();
        }
        if (this.otu != null) {
            this.otu.Ar();
        }
        if (this.otv != null) {
            this.otv.Ar();
        }
        if (this.otq != null) {
            this.otq.Ar();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        caC();
        if (this.otq != null) {
            this.otq.onDestroy();
        }
        if (this.otp != null) {
            this.otp.onDestroy();
        }
        if (this.hrr != null) {
            this.hrr.onDestroy();
        }
        if (this.osV != null) {
            this.osV.onDestory();
        }
        if (this.oto != null) {
            this.oto.release();
        }
        if (this.ott != null) {
            this.ott.onDestroy();
        }
        if (this.otu != null) {
            this.otu.onDestroy();
        }
        if (this.otv != null) {
            this.otv.onDestroy();
        }
        if (this.ots != null) {
            this.ots.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.otz);
        MessageManager.getInstance().unRegisterListener(this.hqL);
        MessageManager.getInstance().unRegisterListener(this.hqP);
        MessageManager.getInstance().unRegisterListener(this.hqQ);
        MessageManager.getInstance().unRegisterListener(this.cak);
    }

    private void caC() {
        if (this.hrr != null && this.hrr.Kd().getView() != null && this.hrr.Kd().getView().getParent() != null) {
            ((ViewGroup) this.hrr.Kd().getView().getParent()).removeView(this.hrr.Kd().getView());
        }
        if (this.hqt != null && this.hqt.getParent() != null) {
            ((ViewGroup) this.hqt.getParent()).removeView(this.hqt);
        }
        if (this.hrr != null && this.hrr.Ke().getView() != null) {
            this.hsb.removeView(this.hrr.Ke().getView());
        }
        if (this.hrr != null) {
            this.hrr.Kd().setMsgData(new LinkedList());
            this.hrr.zR();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void a(ax axVar) {
        if (this.hrr != null) {
            caZ();
            this.hrr.Ke().setEditText(" @" + axVar.getNameShow() + " ");
        }
        if (this.osV != null) {
            this.osV.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hrr != null) {
            caZ();
            this.hrr.Ke().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.osV != null) {
            this.osV.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected void b(ax axVar) {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    protected View caD() {
        if (this.hrr != null) {
            return this.hrr.Ke().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public boolean caE() {
        if (this.hrr == null || !this.hrr.Ke().LY()) {
            return false;
        }
        nN(false);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    /* renamed from: ccm */
    public PendantParentView caG() {
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
                    this.hsf = false;
                    a(null, intExtra, intExtra2, intExtra3);
                    return;
                }
                caw();
                return;
            }
            awo();
        } else if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            HU(P(intent));
        }
    }

    private void HU(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) eaF().pageContext.getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.otq != null) {
            this.otq.HH(fromJson.getBigurl());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            if (!this.otj) {
                if (this.hrr != null && this.hrr.Ke() != null) {
                    this.hrr.Ke().LX();
                    return;
                }
                return;
            }
        } else {
            this.otj = false;
        }
        if (this.hrr != null && this.hrr.Kd() != null) {
            this.hrr.Kd().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hrr == null || this.hrr.Ke() == null || !this.hrr.Ke().LY()) {
            if (z) {
                if (this.osV != null) {
                    this.osV.setVisibility(8);
                }
                if (this.hrt != null && this.hrt.EJ() != null) {
                    this.hrt.EJ().setVisibility(8);
                }
                caI();
                if (this.hrr != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hrr.Ke().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hrr.Ke().getView().setLayoutParams(layoutParams);
                    this.hrr.Ke().getView().setVisibility(0);
                    this.hrr.Ke().setQuickInputPanelVisible(false);
                }
                if (this.hsa != null) {
                    this.hsa.setVisibility(8);
                }
                if (this.hrs != null) {
                    this.hrs.zQ();
                }
                if (this.oto != null) {
                    this.oto.setVisible(8);
                }
                if (this.hrT != null) {
                    this.hrT.setCanVisible(false);
                }
            } else {
                caH();
            }
            ccb();
            if (this.hrF != null) {
                this.hrF.bC(z);
            }
        }
    }

    private void caH() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.osV != null) {
            this.osV.setVisibility(0);
        }
        if (this.hqt != null && (layoutParams = (RelativeLayout.LayoutParams) this.hqt.getLayoutParams()) != null) {
            layoutParams.bottomMargin = eaF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds120);
            this.hqt.setLayoutParams(layoutParams);
        }
        if (this.hrr != null) {
            cbc();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrr.Ke().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hrr.Ke().getView().setLayoutParams(layoutParams2);
        }
        if (this.osV != null) {
            this.osV.setVisibility(0);
        }
        if (this.hrt != null && this.hrt.EJ() != null) {
            this.hrt.EJ().setVisibility(0);
        }
        if (this.hsa != null) {
            this.hsa.setVisibility(0);
        }
        if (this.oto != null) {
            this.oto.setVisible(0);
        }
        if (this.hrs != null) {
            this.hrs.zQ();
        }
        if (this.hrT != null) {
            this.hrT.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caI() {
        boolean z;
        boolean z2;
        if (this.hqt != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqt.getLayoutParams();
            if (this.hrr == null || this.hrr.Ke() == null) {
                z = false;
                z2 = false;
            } else {
                boolean LW = this.hrr.Ke().LW();
                z = this.hrr.Ke().LX();
                z2 = LW;
            }
            int O = O(z2, z);
            if (layoutParams.bottomMargin != O) {
                layoutParams.bottomMargin = O;
                this.hqt.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(boolean z) {
        this.htn = z;
        if (z) {
            this.hrr.Ke().setQuickInputPanelVisible(true);
            return;
        }
        caH();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3 && this.otp != null) {
            this.otp.cr(i3);
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
            if (this.osV != null) {
                this.osV.setVisibility(8);
            }
            if (this.hrr != null) {
                this.hrr.Kd().getView().setVisibility(4);
            }
            if (this.oto != null) {
                this.oto.bM(2, 8);
            }
            if (this.otc != null) {
                this.otc.oM(false);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.a.a
    public void dG(int i) {
        super.dG(i);
        if (i == 11) {
            if (this.osV != null) {
                this.osV.setVisibility(0);
            }
            if (this.hrr != null) {
                this.hrr.Kd().getView().setVisibility(0);
            }
            if (this.oto != null) {
                this.oto.setVisible(0);
            }
            if (this.otc != null) {
                this.otc.oM(true);
            }
            this.hsa.setVisibility(0);
        }
    }

    private void caj() {
        if (this.osV != null) {
            this.osV.a(new a.InterfaceC0931a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.c.5
            });
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.oto != null) {
            this.oto.onStop();
        }
        if (this.ott != null) {
            this.ott.ckm();
        }
        if (this.otu != null) {
            this.otu.ckm();
        }
        if (this.otv != null) {
            this.otv.ckm();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.edg().onDestroy();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.c.a, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.oto != null) {
            this.oto.onStart();
        }
        if (this.ott != null) {
            this.ott.ckl();
        }
        if (this.otu != null) {
            this.otu.ckl();
        }
        if (this.otv != null) {
            this.otv.ckl();
        }
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c cVar) {
        ViewGroup edG = q.edE().edG();
        if (edG != null && (edG instanceof TeamFightLayout)) {
            ((TeamFightLayout) edG).b(cVar);
        }
    }
}
