package com.baidu.tieba.yuyinala.liveroom.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.d.ac;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.ao;
import com.baidu.live.data.ax;
import com.baidu.live.data.bh;
import com.baidu.live.data.bn;
import com.baidu.live.data.bv;
import com.baidu.live.data.bw;
import com.baidu.live.data.di;
import com.baidu.live.data.f;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.af;
import com.baidu.live.gift.ag;
import com.baidu.live.gift.aj;
import com.baidu.live.gift.ak;
import com.baidu.live.gift.z;
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
import com.baidu.live.guardclub.g;
import com.baidu.live.im.b.a;
import com.baidu.live.im.k;
import com.baidu.live.im.m;
import com.baidu.live.liveroom.g.d;
import com.baidu.live.message.YuyinSupportRoomMessage;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.personmanager.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.data.OfficialNoticeData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.utils.t;
import com.baidu.live.utils.u;
import com.baidu.live.view.input.e;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.yuyinala.liveroom.h.b;
import com.baidu.tieba.yuyinala.liveroom.j.c;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class a extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a {
    protected com.baidu.live.an.a bif;
    protected AlaLastLiveroomInfo gto;
    protected ag htC;
    private af htE;
    protected bw htP;
    protected com.baidu.live.aa.a htQ;
    protected RelativeLayout htX;
    protected RelativeLayout htY;
    protected com.baidu.live.ag.a htk;
    private m htn;
    k hto;
    com.baidu.live.im.b.a htp;
    protected ad htq;
    protected ab htr;
    protected boolean hua;
    protected ax hud;
    protected GuardClubInfoHttpResponseMessage hue;
    boolean huf;
    boolean hug;
    boolean huh;
    public boolean huj;
    public boolean huk;
    protected List<d> huo;
    protected List<com.baidu.live.liveroom.g.b> hup;
    protected String otherParams;
    private com.baidu.tieba.yuyinala.liveroom.data.a ovA;
    protected com.baidu.tieba.yuyinala.liveroom.operation.a ovB;
    protected com.baidu.tieba.yuyinala.liveroom.share.a ovC;
    protected com.baidu.tieba.yuyinala.liveroom.n.b ovD;
    private com.baidu.tieba.yuyinala.liveroom.f.a ovE;
    protected com.baidu.tieba.yuyinala.liveroom.tippop.a ovF;
    protected e ovG;
    protected com.baidu.tieba.yuyinala.liveroom.b.a ovH;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.lucky.a ovI;
    protected com.baidu.tieba.yuyinala.liveroom.f.c ovK;
    protected com.baidu.tieba.yuyinala.liveroom.recommend.a ovL;
    private CustomMessageTask ovM;
    private CustomMessageTask.CustomRunnable<Integer> ovN;
    com.baidu.tieba.yuyinala.liveroom.h.b ovO;
    protected com.baidu.tieba.yuyinala.liveroom.e.a ovQ;
    private int ovJ = 0;
    private int htZ = -1;
    protected int mOrientation = 0;
    protected boolean hub = false;
    protected boolean huc = false;
    public boolean ovP = false;
    private CustomMessageListener huu = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ao aoVar;
            if ((customResponsedMessage.getData() instanceof ao) && (aoVar = (ao) customResponsedMessage.getData()) != null) {
                a.this.a(aoVar.aLz, null, aoVar.aLv, aoVar.aLw, aoVar.aLx, aoVar.aLy);
            }
        }
    };
    private CustomMessageListener huv = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.vq(7);
        }
    };
    private CustomMessageListener huw = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.cbq();
        }
    };
    private CustomMessageListener hux = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(a.this.eaV().owJ.Fp().aJD.userId);
            com.baidu.live.view.a.Xr().a(valueOf, new f(a.this.eaV().owJ.Fp().aJD.portrait, valueOf, true, a.this.eaV().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener huy = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.data.ab) && a.this.ovC != null) {
                a.this.ovC.d((com.baidu.live.data.ab) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bzm = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hto != null) {
                a.this.hto.g(z.Fh().Fj());
            }
        }
    };
    private CustomMessageListener huz = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = a.this.ovA.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                a.this.HI(str);
            }
        }
    };
    private CustomMessageListener gPc = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.eaV().pageContext.getPageActivity());
            } else if (a.this.ovC != null) {
                a.this.ovC.d(a.this.eaV().owJ.Fp(), false);
            }
        }
    };
    private CustomMessageListener huA = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ax) {
                    a.this.huc = true;
                    a.this.hud = (ax) data;
                    a.this.b(a.this.hud);
                } else if (data instanceof com.baidu.live.data.a) {
                    a.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener huB = new CustomMessageListener(2501060) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(a.this.eaV().owJ.Fp().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(a.this.eaV().owJ.Fp().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(a.this.eaV().owJ.Fp().mLiveInfo.room_id);
                    String valueOf4 = String.valueOf(a.this.eaV().owJ.Fp().aJD.userId);
                    if (a.this.ovD == null) {
                        a.this.ovD = new com.baidu.tieba.yuyinala.liveroom.n.b();
                    }
                    a.this.ovD.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, valueOf4, false, obj);
                    a.this.ovD.a(a.this.ovR);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private h.a ovR = new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.3
    };
    private CustomMessageListener huD = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                a.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                a.this.otherParams = str;
            }
        }
    };
    CustomMessageListener huE = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.huf = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.ovO != null) {
                a.this.ovO.FD();
            }
        }
    };
    private CustomMessageListener huF = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof di) {
                if (TextUtils.equals(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()), ((di) customResponsedMessage.getData()).aVj)) {
                    BdUtilHelper.getCustomToast().showToast(a.this.ovA.pageContext.getString(a.h.yuyin_sdk_redpacket_snatch_host_alert), 1);
                } else {
                    a.this.a((di) customResponsedMessage.getData());
                }
            }
        }
    };
    private CustomMessageListener huG = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.H(a.this.eaV().owJ.Fp());
        }
    };
    private CustomMessageListener huL = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (a.this.htC != null) {
                    ((com.baidu.tieba.yuyinala.liveroom.m.a) a.this.htC).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hfH = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.an.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (a.this.bif == null) {
                a.this.bif = new com.baidu.live.an.a(a.this.eaV().pageContext.getPageActivity());
            }
            a.this.bif.a((com.baidu.live.an.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener huM = new CustomMessageListener(2501031) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                a.this.a(a.this.eaV().owJ.Fp(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener huO = new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.21
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.cbG();
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener ovS = new CustomMessageListener(2501034) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinSupportRoomMessage) {
                a.this.a(null, -1, -1, -1);
            }
        }
    };

    protected abstract void a(ax axVar);

    protected abstract void b(ax axVar);

    protected abstract void caG();

    protected abstract View caQ();

    public abstract boolean caR();

    protected abstract ViewGroup caT();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bw bwVar) {
        this.htP = bwVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.htX = (RelativeLayout) eaV().owK.findViewById(a.f.ala_live_header_view);
        this.htY = (RelativeLayout) eaV().owK.findViewById(a.f.ala_live_footer_view);
        Gg();
        registerListener();
    }

    public void caY() {
    }

    private void Gg() {
        if (this.ovC == null) {
            this.ovC = new com.baidu.tieba.yuyinala.liveroom.share.a(eaV().pageContext);
        }
        this.ovH = new com.baidu.tieba.yuyinala.liveroom.b.a(eaV().pageContext, false);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            if (!TbadkCoreApplication.getInst().isHaokan() || !subappVersionName.startsWith("4.14.")) {
            }
            if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && subappVersionName.startsWith("1.14.")) {
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            }
        }
        this.ovF = new com.baidu.tieba.yuyinala.liveroom.tippop.a(eaV().pageContext, this);
        cbb();
        cbe();
        cbf();
    }

    private void cbb() {
        this.htn = new m();
    }

    public void nO(boolean z) {
        this.hua = z;
    }

    private void cbe() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501037, e.class, eaV().pageContext);
        if (runTask != null && runTask.getData() != null) {
            try {
                this.ovG = (e) runTask.getData();
                this.ovG.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.14
                    @Override // com.baidu.live.view.input.e.a
                    public void XV() {
                        a.this.vq(11);
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public void XW() {
                        a.this.dH(11);
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public boolean Kk() {
                        return a.this.Ic();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public boolean KZ() {
                        return a.this.cbi();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public int Kq() {
                        return a.this.cbj();
                    }
                });
                this.ovN = new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.15
                    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<Integer> run(CustomMessage<Integer> customMessage) {
                        return new CustomResponsedMessage<>(2501083, Integer.valueOf(a.this.hto != null ? a.this.hto.getImMsgListViewHeight() : 0));
                    }
                };
                this.ovM = new CustomMessageTask(2501083, this.ovN);
                this.ovM.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                MessageManager.getInstance().registerTask(this.ovM);
            } catch (Exception e) {
            }
        }
    }

    void nP(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cbi() {
        com.baidu.live.data.ab Fp;
        if (eaV() == null || eaV().owJ == null || (Fp = eaV().owJ.Fp()) == null || Fp.aJZ == null) {
            return false;
        }
        String str = Fp.aJZ.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int cbj() {
        com.baidu.live.data.ab Fp;
        if (eaV() != null && eaV().owJ != null && (Fp = eaV().owJ.Fp()) != null && !ListUtils.isEmpty(Fp.aKk)) {
            for (AlaLiveMarkData alaLiveMarkData : Fp.aKk) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void cbf() {
        this.ovO = new com.baidu.tieba.yuyinala.liveroom.h.b(this.ovA.pageContext);
        this.ovO.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.16
            @Override // com.baidu.tieba.yuyinala.liveroom.h.b.a
            public boolean cbZ() {
                com.baidu.live.data.ab Fp;
                if (a.this.eaV() == null || a.this.eaV().owJ == null || (Fp = a.this.eaV().owJ.Fp()) == null || Fp.aKu == null) {
                    return false;
                }
                return Fp.aKu.is_followed;
            }
        });
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.huA);
        MessageManager.getInstance().registerListener(this.ovS);
        MessageManager.getInstance().registerListener(this.huB);
        MessageManager.getInstance().registerListener(this.huD);
        MessageManager.getInstance().registerListener(this.hux);
        MessageManager.getInstance().registerListener(this.huy);
        MessageManager.getInstance().registerListener(this.gPc);
        MessageManager.getInstance().registerListener(this.huz);
        MessageManager.getInstance().registerListener(this.gPp);
        MessageManager.getInstance().registerListener(this.huE);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.bzm);
        MessageManager.getInstance().registerListener(this.huF);
        MessageManager.getInstance().registerListener(this.huG);
        MessageManager.getInstance().registerListener(this.huL);
        MessageManager.getInstance().registerListener(this.huM);
        MessageManager.getInstance().registerListener(this.huu);
        MessageManager.getInstance().registerListener(this.huv);
        MessageManager.getInstance().registerListener(this.huw);
        MessageManager.getInstance().registerListener(this.hfH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ic() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(eaV().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HI(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(eaV().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(eaV().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.17
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.Qm().bwx.aNS;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = eaV().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = eaV().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(a.this.eaV().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(eaV().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbm() {
        if (this.hto != null && this.ovG != null) {
            this.ovP = true;
            this.hto.Kh().a(this.ovG.Po(), z.Fh().Fj(), eaV().owJ.Fp().mLiveInfo);
            nP(true);
            if (this.htE == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501042, af.class, eaV().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.htE = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.htE.gC("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.ovQ == null) {
            this.ovQ = new com.baidu.tieba.yuyinala.liveroom.e.a(eaV().pageContext);
            this.ovQ.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.ovQ.a(eaV().owJ.Fp(), alaLastLiveroomInfo);
        this.ovQ.aF(this.htY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbp() {
        if (this.hto != null) {
            this.hto.Kh().hide();
            nP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String[] strArr, int i, int i2, int i3) {
        if (eaV().owJ.Fp() != null && eaV().owJ.Fp().aJD != null && eaV().owJ.Fp().mLiveInfo != null) {
            a(eaV().owJ.Fp(), strArr, i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.ab abVar, String[] strArr, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(ac.class) != null && Ic()) {
            if (abVar == null) {
                abVar = eaV().owJ.Fp();
            }
            String valueOf = String.valueOf(abVar.aJD.userId);
            String str = abVar.aJD.userName;
            String valueOf2 = String.valueOf(abVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(abVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(abVar.mLiveInfo.feed_id);
            int i6 = abVar.aJZ.isBlock;
            String Fy = aj.Fy();
            String str2 = abVar.mLiveInfo.appId;
            boolean z2 = abVar.aJZ.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (abVar.mLiveInfo.live_type == 1 && abVar.mLiveInfo.screen_direction == 1 && com.baidu.live.ae.a.Qm().bwx.aMT) {
                z3 = true;
            }
            int i7 = -1;
            if (abVar.aJZ == null) {
                z = false;
            } else {
                boolean z4 = abVar.aJZ.isNewUser;
                i7 = abVar.aJZ.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.hue != null && this.hue.bky != null && this.hue.bky.anchorId == abVar.aJD.userId) {
                z5 = this.hue.bkD;
            }
            ac acVar = new ac(eaV().pageContext.getPageActivity(), strArr, valueOf, str, valueOf2, valueOf3, i6, Fy, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.mAlaLiveSwitchData != null) {
                acVar.bi(abVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            acVar.bg(z);
            if (com.baidu.tieba.yuyinala.liveroom.p.b.ecb().bwG != null) {
                acVar.bh(com.baidu.tieba.yuyinala.liveroom.p.b.ecb().bwG.aLC != 1);
            }
            bn IY = g.IW().IY();
            if (IY == null || IY.aQJ <= 0) {
                i5 = 1000;
            } else {
                i5 = IY.aQJ;
            }
            acVar.cq(i5);
            boolean z6 = false;
            if (abVar != null && abVar.aJZ != null) {
                String str3 = abVar.aJZ.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            acVar.bj(z6);
            boolean z7 = true;
            bv bvVar = com.baidu.live.ae.a.Qm().bCs;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bvVar != null && bvVar.aRp != null && (!bvVar.aRp.aUa || !bvVar.aRp.aUb || !bvVar.aRp.aUc)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            acVar.bk(z7);
            if (abVar != null && abVar.aKc != null) {
                acVar.fn(abVar.aKc.toJsonString());
            }
            if (!this.huj) {
                this.huk = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, acVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbq() {
        dH(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(di diVar) {
        if (diVar != null && Ic()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.aj(eaV().pageContext.getPageActivity(), diVar.aSq, diVar.liveId, diVar.aVj, diVar.roomId, diVar.time)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(com.baidu.live.data.ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && com.baidu.live.ae.a.Qm().bwx != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(eaV().pageContext.getPageActivity(), String.valueOf(abVar.mLiveInfo.live_id), String.valueOf(abVar.mLiveInfo.user_id), com.baidu.live.ae.a.Qm().bwx.aOA, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.ab abVar, NobleDetailInfo nobleDetailInfo) {
        if (Ic() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (abVar != null) {
                if (abVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(abVar.mLiveInfo.live_id));
                }
                if (abVar.aJD != null) {
                    hashMap.put("anchor_id", Long.valueOf(abVar.aJD.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", t.Fy());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put(Config.TRACE_VISIT_RECENT_DAY, Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(eaV().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbr() {
        if (this.ovG != null) {
            this.ovG.d(this.ovA.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbs() {
        com.baidu.live.data.ab Fp = eaV().owJ.Fp();
        LogManager.getCommonLogger().doClickQuickImHiLog((Fp == null || Fp.mLiveInfo == null) ? "" : Fp.mLiveInfo.feed_id, Lr());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void HJ(String str) {
        if (this.ovG != null) {
            this.ovG.gF(str);
        }
    }

    private void cbt() {
        if ("home_rec_play".equals(eaV().fromType) || "frs_play".equals(eaV().fromType) || "frs_live_play".equals(eaV().fromType) || "person_play".equals(eaV().fromType) || "search".equals(eaV().fromType) || "person_attention".equals(eaV().fromType)) {
            com.baidu.live.c.xe().aV(true);
        } else {
            com.baidu.live.c.xe().aV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nQ(boolean z) {
        View EL;
        if (this.htq == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aWN = false;
            fVar.context = eaV().pageContext.getPageActivity();
            fVar.aWX = z;
            fVar.fromType = eaV().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501040, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.htq = (ad) runTask.getData();
            }
        }
        if (this.htq != null && (EL = this.htq.EL()) != null && this.ovA.owK.indexOfChild(EL) < 0) {
            u.a(eaV().owK, EL, new RelativeLayout.LayoutParams(-1, -1), 250);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbu() {
        View FC;
        if (this.htC == null) {
            ak akVar = new ak();
            akVar.aWN = false;
            akVar.pageContext = eaV().pageContext;
            akVar.fromType = eaV().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501065, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.htC = (ag) runTask.getData();
            }
        }
        if (this.htC != null && (FC = this.htC.FC()) != null && eaV().owK.indexOfChild(FC) < 0) {
            if (FC.getParent() instanceof ViewGroup) {
                ((ViewGroup) FC.getParent()).removeView(FC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = eaV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            u.a(eaV().owK, FC, layoutParams, 550);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbv() {
        View Fo;
        if (this.htr == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aWN = false;
            aVar.context = eaV().pageContext.getPageActivity();
            aVar.fromType = eaV().fromType;
            aVar.aWO = eaV().hDw;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501041, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.htr = (ab) runTask.getData();
            }
        }
        if (this.htr != null && (Fo = this.htr.Fo()) != null && eaV().owK.indexOfChild(Fo) < 0) {
            if (Fo.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fo.getParent()).removeView(Fo);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = (BdUtilHelper.getDimens(eaV().pageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(eaV().pageContext.getPageActivity(), a.d.sdk_ds12) : 0)) + BdUtilHelper.getDimens(eaV().pageContext.getPageActivity(), a.d.sdk_ds152) + (eaV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18) * (-1));
            u.a(eaV().owK, Fo, layoutParams, 300);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbw() {
        CustomResponsedMessage runTask;
        if (this.htp == null && (runTask = MessageManager.getInstance().runTask(2501052, com.baidu.live.im.b.a.class, eaV().pageContext)) != null) {
            this.htp = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.htp != null) {
            this.htp.setOtherParams(this.otherParams);
            this.htp.a(new a.InterfaceC0185a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.19
                @Override // com.baidu.live.im.b.a.InterfaceC0185a
                public void KP() {
                    a.this.cbG();
                }
            });
            this.htp.a(eaV().owJ.Fp(), false);
            View zS = this.htp.zS();
            if (zS != null && this.htY.indexOfChild(zS) < 0) {
                Resources resources = eaV().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(eaV().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.htY.addView(zS, layoutParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501053));
        }
    }

    private void cbx() {
        if (this.ovE == null) {
            this.ovE = new com.baidu.tieba.yuyinala.liveroom.f.a(eaV().pageContext);
        }
        if (this.hud != null) {
            this.ovE.HP(this.hud.user_id);
        }
        this.ovE.aF(null);
    }

    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject2 = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject2 = new JSONObject(bVar.getContent());
            }
            String optString = jSONObject2.optString("ext");
            if (!TextUtils.isEmpty(optString)) {
                new JSONObject(new String(Base64.decode(optString.getBytes(), 0)));
            }
            jSONObject = jSONObject2.optJSONObject("ext_data");
        } catch (JSONException e) {
            jSONObject = null;
        }
        if (bVar.getMsgType() == 12 || bVar.getMsgType() == 13) {
            if (jSONObject2 != null) {
                String optString2 = jSONObject2.optString("content_type");
                BdLog.e("收到系统通知2: " + optString2);
                if ("live_on_private".equals(optString2)) {
                    boolean z = jSONObject2.optInt("on_private", 0) == 1;
                    if (this.btl != null) {
                        this.btl.cE(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        vs(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            eaV().owJ.Fp().aJZ.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            eaV().owJ.Fp().aJZ.isAdmin = 0;
                            eaV().owJ.cjA();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        eaV().owJ.Fp().aJZ.isAdmin = 0;
                        eaV().owJ.cjA();
                    }
                } else if ("task".equals(optString2)) {
                    dW(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt(UbcStatConstant.KEY_CONTENT_EXT_LM_NETWORK);
                    if (this.ovF != null && !eaV().hDv) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = eaV().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = eaV().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = eaV().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bVQ()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.ovF.a(eaV().hDp.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    if (eaV().owJ.Fp() != null && eaV().owJ.Fp().mLiveInfo != null) {
                        eaV().owJ.a(eaV().owJ.Fp().mLiveInfo.live_id, eaV().fromType, eaV().enterTime);
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.yuyinala.liveroom.o.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (eaV().owJ.Fp() != null && eaV().owJ.Fp().aJZ != null && eaV().owJ.Fp().aJZ.userId == optLong2) {
                        eaV().owJ.Fp().aJZ.isBlock = 1;
                        caG();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (eaV().owJ.Fp() != null && eaV().owJ.Fp().aJZ != null && eaV().owJ.Fp().aJZ.userId == optLong3) {
                        eaV().owJ.Fp().aJZ.isBlock = 0;
                        caG();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (eaV().owJ.Fp() != null && eaV().owJ.Fp().aJZ != null && eaV().owJ.Fp().aJZ.userId == optLong4) {
                        eaV().owJ.Fp().aJZ.isUegBlock = 1;
                        caG();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (eaV().owJ.Fp() != null && eaV().owJ.Fp().aJZ != null && eaV().owJ.Fp().aJZ.userId == optLong5) {
                        eaV().owJ.Fp().aJZ.isUegBlock = 0;
                        caG();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (eaV() != null && eaV().owJ != null && eaV().owJ.Fp() != null && eaV().owJ.Fp().aJZ != null) {
                        if (eaV().owJ.Fp().aJZ.userId == jSONObject2.optLong("user_id")) {
                            eaV().owJ.cjA();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, eaV().owJ.Fp().aJZ));
                    }
                } else if ("guard_seat".equals(optString2)) {
                    if (jSONObject2.optInt("seat_status") == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913156));
                    }
                } else if ("official_notice".equals(optString2)) {
                    long optLong6 = jSONObject2.optLong("user_id");
                    if (jSONObject != null) {
                        String str2 = optLong6 + "";
                        TbadkCoreApplication.getInst();
                        if (str2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                } else if ("privilege_award_royal_success".equals(optString2)) {
                    String str3 = jSONObject2.optInt("effect_id") + "";
                    com.baidu.live.data.a Lc = bVar.Lc();
                    if (Lc != null && aj.gx(str3)) {
                        aj.d(str3, 1L, "", "", Lc.userId, Lc.portrait, Lc.userName, "", "", false, "", "", "", false, false, true, -1L, bVar.boO);
                    }
                } else if ("challenge_mvp".equals(optString2)) {
                    if (jSONObject2 != null) {
                        bh bhVar = new bh();
                        bhVar.parseJson(jSONObject2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, bhVar));
                    }
                } else if (TextUtils.equals(optString2, "challenge_mvp_punish")) {
                    if (jSONObject2 != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject2));
                    }
                } else if (TextUtils.equals(optString2, "send_redpacket")) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject("live_redpacket");
                    if (optJSONObject != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913221, new RedPacketCharmInfo(optJSONObject)));
                    }
                } else if (TextUtils.equals(optString2, "gift_combo_end")) {
                    com.baidu.tieba.yuyinala.liveroom.j.c.a(eaV(), bVar, jSONObject2);
                }
            }
        } else if (bVar.getMsgType() != 125 && bVar.getMsgType() == 24) {
            com.baidu.tieba.yuyinala.liveroom.j.c.b(eaV(), bVar, jSONObject2, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.20
                @Override // com.baidu.tieba.yuyinala.liveroom.j.c.a
                public void VY(String str4) {
                    a.this.HE(str4);
                }
            });
        }
    }

    protected void HE(String str) {
    }

    void cbG() {
        if (cbH()) {
            BdUtilHelper.hideSoftKeyPad(eaV().pageContext.getPageActivity(), eaV().hDp.getLiveContainerView());
            caR();
        }
    }

    private boolean cbH() {
        if (caQ() == null || caQ().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(com.baidu.live.data.ab abVar) {
        CustomResponsedMessage runTask;
        eaV().owK.setOnTouchListener(this.huO);
        cbR();
        cbx();
        if (this.htn != null) {
            this.htn.g(eaV().owJ.Fp());
        }
        if (this.ovG != null) {
            this.ovG.b(eaV().owJ.Fp(), Lr());
        }
        if (this.ovO != null) {
            this.ovO.h(eaV().owJ.Fp());
        }
        if (eaV().owK != null) {
            eaV().owK.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.22
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    return a.this.Q(motionEvent);
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Nf() {
                    if (a.this.hup == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : a.this.hup) {
                        if (bVar.Nf()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            eaV().owK.setLiveViewOnTouchEventListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.24
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return a.this.P(motionEvent);
                }
            });
        }
        if (this.htE == null && (runTask = MessageManager.getInstance().runTask(2501042, af.class, eaV().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.htE = (af) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbJ() {
        com.baidu.live.data.ab Fp;
        ViewGroup viewGroup;
        if (eaV() != null && eaV().owJ != null && (Fp = eaV().owJ.Fp()) != null && Fp.mLiveInfo != null && Fp.aKA && (viewGroup = (ViewGroup) eaV().hDp) != null) {
            if (this.ovL == null) {
                this.ovL = new com.baidu.tieba.yuyinala.liveroom.recommend.a(eaV().pageContext);
            }
            this.ovL.o(Fp);
            this.ovL.a(eaV().owK);
            this.ovL.aF(viewGroup);
            a((d) this.ovL);
            a((com.baidu.live.liveroom.g.b) this.ovL);
        }
    }

    protected void a(d dVar) {
        if (this.huo == null) {
            this.huo = new ArrayList();
        }
        if (!this.huo.contains(dVar)) {
            this.huo.add(dVar);
        }
    }

    protected void b(d dVar) {
        if (this.huo != null && this.huo.contains(dVar)) {
            this.huo.remove(dVar);
        }
    }

    protected void cbK() {
        if (this.huo != null) {
            this.huo.clear();
            this.huo = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.huo == null) {
            return false;
        }
        Iterator<d> it = this.huo.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = it.next().onTouchEvent(motionEvent);
            if (z2 || !z) {
                z = z2;
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.b bVar) {
        if (this.hup == null) {
            this.hup = new ArrayList();
        }
        if (!this.hup.contains(bVar)) {
            this.hup.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hup != null && this.hup.contains(bVar)) {
            this.hup.remove(bVar);
        }
    }

    protected void cbL() {
        if (this.hup != null) {
            this.hup.clear();
            this.hup = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hup == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hup.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = it.next().dispatchTouchEvent(motionEvent);
            if (z2 || !z) {
                z = z2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbM() {
        if (this.ovK == null && this.htP != null && this.htP.aRC && eaV() != null && eaV().owJ != null && eaV().owJ.Fp() != null) {
            this.ovK = new com.baidu.tieba.yuyinala.liveroom.f.c(eaV().pageContext, this.htP);
            this.ovK.K(eaV().owJ.Fp());
            if (this.htP.aRF == 1) {
                if (this.hto != null) {
                    this.hug = true;
                }
            } else if (this.htP.aRF == 2) {
                a(eaV().owJ.Fp(), null, -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbN() {
        CustomResponsedMessage runTask;
        if (eaV() != null && (runTask = MessageManager.getInstance().runTask(2501047, k.class, eaV().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.htQ = (com.baidu.live.aa.a) runTask.getData();
            this.htQ.q(caT());
            if (eaV().owJ != null) {
                this.huh = this.htQ.p(eaV().owJ.Fp());
            }
            this.htQ.setCanVisible(!this.hub);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(boolean z, boolean z2) {
        Rect rect = new Rect();
        eaV().hDp.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(eaV().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(eaV().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? eaV().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + eaV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? eaV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds192) : 0) + eaV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds32);
    }

    private void cbR() {
        if (this.htk == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ag.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.htk = (com.baidu.live.ag.a) runTask.getData();
            }
            cbS();
        }
    }

    private void dW(JSONObject jSONObject) {
        if (this.htk != null) {
            this.htk.dc(true);
            this.htk.ad(jSONObject);
        }
    }

    private void cbS() {
        if (this.htk != null && eaV().owJ.Fp() != null && eaV().owJ.Fp().aKo != null) {
            this.htk.dc(true);
            this.htk.j(eaV().owJ.Fp());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(com.baidu.live.data.ab abVar) {
        if (abVar != null) {
            cbS();
            if (this.ovE != null && abVar.aJD != null) {
                this.ovE.HP(String.valueOf(abVar.aJD.userId));
            }
            if (this.htr != null && abVar.mLiveInfo != null) {
                this.htr.a(abVar.mLiveInfo, abVar.aJD);
            }
            if (this.htp != null) {
                this.htp.a(abVar);
            }
            if (this.htQ != null) {
                this.huh = this.htQ.p(abVar);
            }
            vs(abVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void vs(int i) {
        if (!eaV().hDv) {
            if (this.htZ < 0 && i == 0) {
                this.htZ = i;
            } else if (this.htZ != i) {
                if (i == 1) {
                    if (!this.ovF.wh(2)) {
                        String string = eaV().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(eaV().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.ovF.a(eaV().hDp.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = eaV().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.ovF.wi(2);
                    this.ovF.wi(3);
                    if (bVQ()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.ovF.a(eaV().hDp.getLiveContainerView(), string2, 3);
                    }
                }
                this.htZ = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cH(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.cH(z);
        if (z) {
            cbT();
        }
        if (this.ovC != null) {
            this.ovC.Au();
        }
        if (this.htk != null) {
            this.htk.onDestroy();
            this.htk = null;
        }
        if (this.ovO != null) {
            this.ovO.onDestroy();
        }
        if (this.htq != null) {
            View EL = this.htq.EL();
            if (EL != null && EL.getParent() != null) {
                ((ViewGroup) EL.getParent()).removeView(EL);
            }
            this.htq.onDestroy();
            this.htq = null;
        }
        if (this.htp != null) {
            this.htp.a((a.InterfaceC0185a) null);
            this.htp.zU();
        }
        if (this.ovF != null) {
            this.ovF.Au();
        }
        this.htZ = -1;
        if (this.ovE != null) {
            this.ovE.Au();
            this.ovE.onDestroy();
        }
        if (this.ovH != null) {
            this.ovH.cac();
            this.ovH.FB();
        }
        if (this.htn != null) {
            this.htn.FB();
        }
        if (this.ovG != null) {
            this.ovG.FB();
        }
        if (this.ovK != null) {
            this.ovK.onDestroy();
        }
        if (this.htE != null) {
            this.htE.FB();
        }
        if (this.ovD != null) {
            this.ovD.onDestory();
        }
        if (this.htQ != null) {
            this.htQ.FB();
        }
        if (this.htC != null) {
            this.htC.onDestroy();
        }
        if (this.ovL != null) {
            this.ovL.Au();
            b((d) this.ovL);
            b((com.baidu.live.liveroom.g.b) this.ovL);
        }
        ShowUtil.windowCount = 0;
        cbK();
        cbL();
    }

    private void cbT() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = eaV().owK.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = eaV().owK.getChildAt(i);
            if (childAt != this.htX && childAt != this.htY) {
                linkedList.add(childAt);
            }
        }
        for (View view : linkedList) {
            if (view != null) {
                try {
                    if (view.getParent() instanceof ViewGroup) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                } catch (NullPointerException e) {
                }
            }
        }
        if (this.htX != null) {
            this.htX.removeAllViews();
        }
        if (this.htY != null) {
            this.htY.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, com.baidu.live.data.ab abVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(com.baidu.live.data.ab abVar) {
        View zS;
        View EL;
        if (this.htq != null && (EL = this.htq.EL()) != null && EL.getParent() != null) {
            ((ViewGroup) EL.getParent()).removeView(EL);
        }
        if (this.htp != null && (zS = this.htp.zS()) != null && zS.getParent() != null) {
            ((ViewGroup) zS.getParent()).removeView(zS);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean Nb() {
        cbt();
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        if (this.htk != null) {
            this.htk.onDestroy();
            this.htk = null;
        }
        if (this.htq != null) {
            this.htq.onDestroy();
            this.htq = null;
        }
        if (this.htr != null) {
            this.htr.onDestroy();
            this.htr = null;
        }
        if (this.ovF != null) {
            this.ovF.onDestroy();
        }
        if (this.ovC != null) {
            this.ovC.onDestroy();
        }
        if (this.htC != null) {
            this.htC.onDestroy();
            this.htC = null;
        }
        if (this.htp != null) {
            this.htp.a((a.InterfaceC0185a) null);
            this.htp.release();
            this.htp = null;
        }
        if (this.ovG != null) {
            this.ovG.a(null);
            this.ovG.release();
        }
        if (this.ovK != null) {
            this.ovK.onDestroy();
        }
        if (this.htE != null) {
            this.htE.release();
        }
        if (this.ovD != null) {
            this.ovD.onDestory();
        }
        if (this.htQ != null) {
            this.htQ.release();
        }
        if (this.ovO != null) {
            this.ovO.a((b.a) null);
            this.ovO.onDestroy();
        }
        if (this.ovL != null) {
            this.ovL.onDestroy();
            b((d) this.ovL);
            b((com.baidu.live.liveroom.g.b) this.ovL);
        }
        cbK();
        cbL();
        MessageManager.getInstance().unRegisterListener(this.huu);
        MessageManager.getInstance().unRegisterListener(this.huv);
        MessageManager.getInstance().unRegisterListener(this.huw);
        MessageManager.getInstance().unRegisterListener(this.huA);
        MessageManager.getInstance().unRegisterListener(this.huB);
        MessageManager.getInstance().unRegisterListener(this.ovS);
        MessageManager.getInstance().unRegisterListener(this.huD);
        MessageManager.getInstance().unRegisterListener(this.hux);
        MessageManager.getInstance().unRegisterListener(this.huy);
        MessageManager.getInstance().unRegisterListener(this.gPc);
        MessageManager.getInstance().unRegisterListener(this.huz);
        MessageManager.getInstance().unRegisterListener(this.gPp);
        MessageManager.getInstance().unRegisterListener(this.huE);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.bzm);
        MessageManager.getInstance().unRegisterListener(this.huF);
        MessageManager.getInstance().unRegisterListener(this.huG);
        MessageManager.getInstance().unRegisterListener(this.huL);
        MessageManager.getInstance().unRegisterListener(this.huM);
        MessageManager.getInstance().unRegisterListener(this.hfH);
        MessageManager.getInstance().unRegisterTask(2501083);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        caR();
        if (this.htC != null) {
            this.htC.onPause();
        }
        if (this.ovO != null) {
            this.ovO.oq(false);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.huk = false;
        if (this.huc && this.hud != null) {
            a(this.hud);
            this.huc = false;
        }
        if (this.htC != null) {
            this.htC.onResume();
        }
        if (this.ovO != null) {
            this.ovO.oq(true);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awr() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.ovL != null && this.ovL.isOpen()) {
            this.ovL.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            awr();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    a(null, -1, -1, -1);
                    return;
                }
                return;
            }
            awr();
        } else if (i == 25034) {
            cbq();
        } else if (i == 25043 && i2 == -1) {
            cbW();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void e(boolean z, int i) {
        this.hub = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            this.mOrientation = i3;
        }
        if (this.ovD != null) {
            this.ovD.bkr();
        }
        if (this.ovL != null) {
            this.ovL.C(i, i3);
        }
        if (this.ovO != null) {
            this.ovO.bkr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        this.ovA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.yuyinala.liveroom.data.a eaV() {
        return this.ovA;
    }

    private void cbW() {
        String IX = g.IW().IX();
        if (!TextUtils.isEmpty(IX)) {
            try {
                a(null, -1, Integer.parseInt(IX), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                a(null, -1, -1, -1);
            }
        }
    }

    @Override // com.baidu.live.liveroom.a.a
    public boolean dG(int i) {
        if (1 == i) {
            if (caQ() != null) {
                caQ().setVisibility(8);
                return true;
            }
            return true;
        } else if (2 == i) {
            return !this.hub;
        } else if (3 == i) {
            if (eaV().owK == null) {
                return false;
            }
            eaV().owK.setEnabled(false);
            if (this.btl != null) {
                this.btl.e(!eaV().hDt, false);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    public void vq(int i) {
    }

    @Override // com.baidu.live.liveroom.a.a
    public void dH(int i) {
        if (3 == i) {
            eaV().owK.setEnabled(true);
            if (this.btl != null) {
                this.btl.e(!eaV().hDt, true);
            }
            if (this.htk != null) {
                this.htk.dc(true);
                return;
            }
            return;
        }
        if (2 == i) {
        }
    }

    public String Lr() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.htp != null) {
            this.htp.setOtherParams(str);
        }
    }

    private boolean bVQ() {
        return eaV().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gto = alaLastLiveroomInfo;
    }
}
