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
/* loaded from: classes11.dex */
public abstract class a extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a {
    protected com.baidu.live.an.a bgE;
    protected AlaLastLiveroomInfo grF;
    protected com.baidu.live.ag.a hrB;
    private m hrE;
    k hrF;
    com.baidu.live.im.b.a hrG;
    protected ad hrH;
    protected ab hrI;
    protected ag hrT;
    private af hrV;
    public boolean hsA;
    public boolean hsB;
    protected List<d> hsF;
    protected List<com.baidu.live.liveroom.g.b> hsG;
    protected bw hsg;
    protected com.baidu.live.aa.a hsh;
    protected RelativeLayout hso;
    protected RelativeLayout hsp;
    protected boolean hsr;
    protected ax hsu;
    protected GuardClubInfoHttpResponseMessage hsv;
    boolean hsw;
    boolean hsx;
    boolean hsy;
    protected e otA;
    protected com.baidu.tieba.yuyinala.liveroom.b.a otB;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.lucky.a otC;
    protected com.baidu.tieba.yuyinala.liveroom.f.c otE;
    protected com.baidu.tieba.yuyinala.liveroom.recommend.a otF;
    private CustomMessageTask otG;
    private CustomMessageTask.CustomRunnable<Integer> otH;
    com.baidu.tieba.yuyinala.liveroom.h.b otI;
    protected com.baidu.tieba.yuyinala.liveroom.e.a otK;
    protected String otherParams;
    private com.baidu.tieba.yuyinala.liveroom.data.a otu;
    protected com.baidu.tieba.yuyinala.liveroom.operation.a otv;
    protected com.baidu.tieba.yuyinala.liveroom.share.a otw;
    protected com.baidu.tieba.yuyinala.liveroom.n.b otx;
    private com.baidu.tieba.yuyinala.liveroom.f.a oty;
    protected com.baidu.tieba.yuyinala.liveroom.tippop.a otz;
    private int otD = 0;
    private int hsq = -1;
    protected int mOrientation = 0;
    protected boolean hss = false;
    protected boolean hst = false;
    public boolean otJ = false;
    private CustomMessageListener hsL = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ao aoVar;
            if ((customResponsedMessage.getData() instanceof ao) && (aoVar = (ao) customResponsedMessage.getData()) != null) {
                a.this.a(aoVar.aJZ, null, aoVar.aJV, aoVar.aJW, aoVar.aJX, aoVar.aJY);
            }
        }
    };
    private CustomMessageListener hsM = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.vo(7);
        }
    };
    private CustomMessageListener hsN = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.cbk();
        }
    };
    private CustomMessageListener hsO = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(a.this.eaN().ouE.Fm().aId.userId);
            com.baidu.live.view.a.Xo().a(valueOf, new f(a.this.eaN().ouE.Fm().aId.portrait, valueOf, true, a.this.eaN().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener hsP = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.data.ab) && a.this.otw != null) {
                a.this.otw.d((com.baidu.live.data.ab) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bxM = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hrF != null) {
                a.this.hrF.g(z.Fe().Fg());
            }
        }
    };
    private CustomMessageListener hsQ = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = a.this.otu.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                a.this.Hz(str);
            }
        }
    };
    private CustomMessageListener gNt = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.eaN().pageContext.getPageActivity());
            } else if (a.this.otw != null) {
                a.this.otw.d(a.this.eaN().ouE.Fm(), false);
            }
        }
    };
    private CustomMessageListener hsR = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ax) {
                    a.this.hst = true;
                    a.this.hsu = (ax) data;
                    a.this.b(a.this.hsu);
                } else if (data instanceof com.baidu.live.data.a) {
                    a.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener hsS = new CustomMessageListener(2501060) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(a.this.eaN().ouE.Fm().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(a.this.eaN().ouE.Fm().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(a.this.eaN().ouE.Fm().mLiveInfo.room_id);
                    String valueOf4 = String.valueOf(a.this.eaN().ouE.Fm().aId.userId);
                    if (a.this.otx == null) {
                        a.this.otx = new com.baidu.tieba.yuyinala.liveroom.n.b();
                    }
                    a.this.otx.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, valueOf4, false, obj);
                    a.this.otx.a(a.this.otL);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private h.a otL = new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.3
    };
    private CustomMessageListener hsU = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                a.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.5
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
    CustomMessageListener hsV = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.hsw = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.otI != null) {
                a.this.otI.FA();
            }
        }
    };
    private CustomMessageListener hsW = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof di) {
                if (TextUtils.equals(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()), ((di) customResponsedMessage.getData()).aTJ)) {
                    BdUtilHelper.getCustomToast().showToast(a.this.otu.pageContext.getString(a.h.yuyin_sdk_redpacket_snatch_host_alert), 1);
                } else {
                    a.this.a((di) customResponsedMessage.getData());
                }
            }
        }
    };
    private CustomMessageListener hsX = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.H(a.this.eaN().ouE.Fm());
        }
    };
    private CustomMessageListener htc = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (a.this.hrT != null) {
                    ((com.baidu.tieba.yuyinala.liveroom.m.a) a.this.hrT).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hdY = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.an.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (a.this.bgE == null) {
                a.this.bgE = new com.baidu.live.an.a(a.this.eaN().pageContext.getPageActivity());
            }
            a.this.bgE.a((com.baidu.live.an.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener htd = new CustomMessageListener(2501031) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                a.this.a(a.this.eaN().ouE.Fm(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener htf = new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.21
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.cbA();
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener otM = new CustomMessageListener(2501034) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.25
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

    protected abstract void caA();

    protected abstract View caK();

    public abstract boolean caL();

    protected abstract ViewGroup caN();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bw bwVar) {
        this.hsg = bwVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hso = (RelativeLayout) eaN().ouF.findViewById(a.f.ala_live_header_view);
        this.hsp = (RelativeLayout) eaN().ouF.findViewById(a.f.ala_live_footer_view);
        Gd();
        registerListener();
    }

    public void caS() {
    }

    private void Gd() {
        if (this.otw == null) {
            this.otw = new com.baidu.tieba.yuyinala.liveroom.share.a(eaN().pageContext);
        }
        this.otB = new com.baidu.tieba.yuyinala.liveroom.b.a(eaN().pageContext, false);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            if (!TbadkCoreApplication.getInst().isHaokan() || !subappVersionName.startsWith("4.14.")) {
            }
            if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && subappVersionName.startsWith("1.14.")) {
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            }
        }
        this.otz = new com.baidu.tieba.yuyinala.liveroom.tippop.a(eaN().pageContext, this);
        caV();
        caY();
        caZ();
    }

    private void caV() {
        this.hrE = new m();
    }

    public void nO(boolean z) {
        this.hsr = z;
    }

    private void caY() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501037, e.class, eaN().pageContext);
        if (runTask != null && runTask.getData() != null) {
            try {
                this.otA = (e) runTask.getData();
                this.otA.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.14
                    @Override // com.baidu.live.view.input.e.a
                    public void XS() {
                        a.this.vo(11);
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public void XT() {
                        a.this.dG(11);
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public boolean Kh() {
                        return a.this.HZ();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public boolean KW() {
                        return a.this.cbc();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public int Kn() {
                        return a.this.cbd();
                    }
                });
                this.otH = new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.15
                    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<Integer> run(CustomMessage<Integer> customMessage) {
                        return new CustomResponsedMessage<>(2501083, Integer.valueOf(a.this.hrF != null ? a.this.hrF.getImMsgListViewHeight() : 0));
                    }
                };
                this.otG = new CustomMessageTask(2501083, this.otH);
                this.otG.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                MessageManager.getInstance().registerTask(this.otG);
            } catch (Exception e) {
            }
        }
    }

    void nP(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cbc() {
        com.baidu.live.data.ab Fm;
        if (eaN() == null || eaN().ouE == null || (Fm = eaN().ouE.Fm()) == null || Fm.aIz == null) {
            return false;
        }
        String str = Fm.aIz.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int cbd() {
        com.baidu.live.data.ab Fm;
        if (eaN() != null && eaN().ouE != null && (Fm = eaN().ouE.Fm()) != null && !ListUtils.isEmpty(Fm.aIK)) {
            for (AlaLiveMarkData alaLiveMarkData : Fm.aIK) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void caZ() {
        this.otI = new com.baidu.tieba.yuyinala.liveroom.h.b(this.otu.pageContext);
        this.otI.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.16
            @Override // com.baidu.tieba.yuyinala.liveroom.h.b.a
            public boolean cbT() {
                com.baidu.live.data.ab Fm;
                if (a.this.eaN() == null || a.this.eaN().ouE == null || (Fm = a.this.eaN().ouE.Fm()) == null || Fm.aIU == null) {
                    return false;
                }
                return Fm.aIU.is_followed;
            }
        });
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.hsR);
        MessageManager.getInstance().registerListener(this.otM);
        MessageManager.getInstance().registerListener(this.hsS);
        MessageManager.getInstance().registerListener(this.hsU);
        MessageManager.getInstance().registerListener(this.hsO);
        MessageManager.getInstance().registerListener(this.hsP);
        MessageManager.getInstance().registerListener(this.gNt);
        MessageManager.getInstance().registerListener(this.hsQ);
        MessageManager.getInstance().registerListener(this.gNG);
        MessageManager.getInstance().registerListener(this.hsV);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.bxM);
        MessageManager.getInstance().registerListener(this.hsW);
        MessageManager.getInstance().registerListener(this.hsX);
        MessageManager.getInstance().registerListener(this.htc);
        MessageManager.getInstance().registerListener(this.htd);
        MessageManager.getInstance().registerListener(this.hsL);
        MessageManager.getInstance().registerListener(this.hsM);
        MessageManager.getInstance().registerListener(this.hsN);
        MessageManager.getInstance().registerListener(this.hdY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean HZ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(eaN().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hz(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(eaN().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(eaN().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.17
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.Qj().buX.aMs;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = eaN().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = eaN().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(a.this.eaN().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(eaN().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbg() {
        if (this.hrF != null && this.otA != null) {
            this.otJ = true;
            this.hrF.Ke().a(this.otA.Pl(), z.Fe().Fg(), eaN().ouE.Fm().mLiveInfo);
            nP(true);
            if (this.hrV == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501042, af.class, eaN().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hrV = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrV.gw("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.otK == null) {
            this.otK = new com.baidu.tieba.yuyinala.liveroom.e.a(eaN().pageContext);
            this.otK.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.otK.a(eaN().ouE.Fm(), alaLastLiveroomInfo);
        this.otK.aF(this.hsp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbj() {
        if (this.hrF != null) {
            this.hrF.Ke().hide();
            nP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String[] strArr, int i, int i2, int i3) {
        if (eaN().ouE.Fm() != null && eaN().ouE.Fm().aId != null && eaN().ouE.Fm().mLiveInfo != null) {
            a(eaN().ouE.Fm(), strArr, i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.ab abVar, String[] strArr, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(ac.class) != null && HZ()) {
            if (abVar == null) {
                abVar = eaN().ouE.Fm();
            }
            String valueOf = String.valueOf(abVar.aId.userId);
            String str = abVar.aId.userName;
            String valueOf2 = String.valueOf(abVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(abVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(abVar.mLiveInfo.feed_id);
            int i6 = abVar.aIz.isBlock;
            String Fv = aj.Fv();
            String str2 = abVar.mLiveInfo.appId;
            boolean z2 = abVar.aIz.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (abVar.mLiveInfo.live_type == 1 && abVar.mLiveInfo.screen_direction == 1 && com.baidu.live.ae.a.Qj().buX.aLt) {
                z3 = true;
            }
            int i7 = -1;
            if (abVar.aIz == null) {
                z = false;
            } else {
                boolean z4 = abVar.aIz.isNewUser;
                i7 = abVar.aIz.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.hsv != null && this.hsv.biY != null && this.hsv.biY.anchorId == abVar.aId.userId) {
                z5 = this.hsv.bjd;
            }
            ac acVar = new ac(eaN().pageContext.getPageActivity(), strArr, valueOf, str, valueOf2, valueOf3, i6, Fv, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.mAlaLiveSwitchData != null) {
                acVar.bi(abVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            acVar.bg(z);
            if (com.baidu.tieba.yuyinala.liveroom.p.b.ebT().bvg != null) {
                acVar.bh(com.baidu.tieba.yuyinala.liveroom.p.b.ebT().bvg.aKc != 1);
            }
            bn IV = g.IT().IV();
            if (IV == null || IV.aPj <= 0) {
                i5 = 1000;
            } else {
                i5 = IV.aPj;
            }
            acVar.cp(i5);
            boolean z6 = false;
            if (abVar != null && abVar.aIz != null) {
                String str3 = abVar.aIz.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            acVar.bj(z6);
            boolean z7 = true;
            bv bvVar = com.baidu.live.ae.a.Qj().bAS;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bvVar != null && bvVar.aPP != null && (!bvVar.aPP.aSA || !bvVar.aPP.aSB || !bvVar.aPP.aSC)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            acVar.bk(z7);
            if (abVar != null && abVar.aIC != null) {
                acVar.fh(abVar.aIC.toJsonString());
            }
            if (!this.hsA) {
                this.hsB = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, acVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbk() {
        dG(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(di diVar) {
        if (diVar != null && HZ()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.aj(eaN().pageContext.getPageActivity(), diVar.aQQ, diVar.liveId, diVar.aTJ, diVar.roomId, diVar.time)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(com.baidu.live.data.ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && com.baidu.live.ae.a.Qj().buX != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(eaN().pageContext.getPageActivity(), String.valueOf(abVar.mLiveInfo.live_id), String.valueOf(abVar.mLiveInfo.user_id), com.baidu.live.ae.a.Qj().buX.aNa, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.ab abVar, NobleDetailInfo nobleDetailInfo) {
        if (HZ() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (abVar != null) {
                if (abVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(abVar.mLiveInfo.live_id));
                }
                if (abVar.aId != null) {
                    hashMap.put("anchor_id", Long.valueOf(abVar.aId.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", t.Fv());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put(Config.TRACE_VISIT_RECENT_DAY, Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(eaN().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbl() {
        if (this.otA != null) {
            this.otA.d(this.otu.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbm() {
        com.baidu.live.data.ab Fm = eaN().ouE.Fm();
        LogManager.getCommonLogger().doClickQuickImHiLog((Fm == null || Fm.mLiveInfo == null) ? "" : Fm.mLiveInfo.feed_id, Lo());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void HA(String str) {
        if (this.otA != null) {
            this.otA.gz(str);
        }
    }

    private void cbn() {
        if ("home_rec_play".equals(eaN().fromType) || "frs_play".equals(eaN().fromType) || "frs_live_play".equals(eaN().fromType) || "person_play".equals(eaN().fromType) || "search".equals(eaN().fromType) || "person_attention".equals(eaN().fromType)) {
            com.baidu.live.c.xb().aV(true);
        } else {
            com.baidu.live.c.xb().aV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nQ(boolean z) {
        View EI;
        if (this.hrH == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aVn = false;
            fVar.context = eaN().pageContext.getPageActivity();
            fVar.aVx = z;
            fVar.fromType = eaN().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501040, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrH = (ad) runTask.getData();
            }
        }
        if (this.hrH != null && (EI = this.hrH.EI()) != null && this.otu.ouF.indexOfChild(EI) < 0) {
            u.a(eaN().ouF, EI, new RelativeLayout.LayoutParams(-1, -1), 250);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbo() {
        View Fz;
        if (this.hrT == null) {
            ak akVar = new ak();
            akVar.aVn = false;
            akVar.pageContext = eaN().pageContext;
            akVar.fromType = eaN().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501065, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrT = (ag) runTask.getData();
            }
        }
        if (this.hrT != null && (Fz = this.hrT.Fz()) != null && eaN().ouF.indexOfChild(Fz) < 0) {
            if (Fz.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fz.getParent()).removeView(Fz);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = eaN().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            u.a(eaN().ouF, Fz, layoutParams, 550);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbp() {
        View Fl;
        if (this.hrI == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aVn = false;
            aVar.context = eaN().pageContext.getPageActivity();
            aVar.fromType = eaN().fromType;
            aVar.aVo = eaN().hBN;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501041, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrI = (ab) runTask.getData();
            }
        }
        if (this.hrI != null && (Fl = this.hrI.Fl()) != null && eaN().ouF.indexOfChild(Fl) < 0) {
            if (Fl.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fl.getParent()).removeView(Fl);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = (BdUtilHelper.getDimens(eaN().pageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(eaN().pageContext.getPageActivity(), a.d.sdk_ds12) : 0)) + BdUtilHelper.getDimens(eaN().pageContext.getPageActivity(), a.d.sdk_ds152) + (eaN().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18) * (-1));
            u.a(eaN().ouF, Fl, layoutParams, 300);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbq() {
        CustomResponsedMessage runTask;
        if (this.hrG == null && (runTask = MessageManager.getInstance().runTask(2501052, com.baidu.live.im.b.a.class, eaN().pageContext)) != null) {
            this.hrG = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hrG != null) {
            this.hrG.setOtherParams(this.otherParams);
            this.hrG.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.19
                @Override // com.baidu.live.im.b.a.InterfaceC0179a
                public void KM() {
                    a.this.cbA();
                }
            });
            this.hrG.a(eaN().ouE.Fm(), false);
            View zP = this.hrG.zP();
            if (zP != null && this.hsp.indexOfChild(zP) < 0) {
                Resources resources = eaN().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(eaN().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.hsp.addView(zP, layoutParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501053));
        }
    }

    private void cbr() {
        if (this.oty == null) {
            this.oty = new com.baidu.tieba.yuyinala.liveroom.f.a(eaN().pageContext);
        }
        if (this.hsu != null) {
            this.oty.HG(this.hsu.user_id);
        }
        this.oty.aF(null);
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
                    if (this.brL != null) {
                        this.brL.cE(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        vq(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            eaN().ouE.Fm().aIz.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            eaN().ouE.Fm().aIz.isAdmin = 0;
                            eaN().ouE.cju();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        eaN().ouE.Fm().aIz.isAdmin = 0;
                        eaN().ouE.cju();
                    }
                } else if ("task".equals(optString2)) {
                    dU(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt(UbcStatConstant.KEY_CONTENT_EXT_LM_NETWORK);
                    if (this.otz != null && !eaN().hBM) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = eaN().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = eaN().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = eaN().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bVK()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.otz.c(eaN().hBG.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    if (eaN().ouE.Fm() != null && eaN().ouE.Fm().mLiveInfo != null) {
                        eaN().ouE.a(eaN().ouE.Fm().mLiveInfo.live_id, eaN().fromType, eaN().enterTime);
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.yuyinala.liveroom.o.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (eaN().ouE.Fm() != null && eaN().ouE.Fm().aIz != null && eaN().ouE.Fm().aIz.userId == optLong2) {
                        eaN().ouE.Fm().aIz.isBlock = 1;
                        caA();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (eaN().ouE.Fm() != null && eaN().ouE.Fm().aIz != null && eaN().ouE.Fm().aIz.userId == optLong3) {
                        eaN().ouE.Fm().aIz.isBlock = 0;
                        caA();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (eaN().ouE.Fm() != null && eaN().ouE.Fm().aIz != null && eaN().ouE.Fm().aIz.userId == optLong4) {
                        eaN().ouE.Fm().aIz.isUegBlock = 1;
                        caA();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (eaN().ouE.Fm() != null && eaN().ouE.Fm().aIz != null && eaN().ouE.Fm().aIz.userId == optLong5) {
                        eaN().ouE.Fm().aIz.isUegBlock = 0;
                        caA();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (eaN() != null && eaN().ouE != null && eaN().ouE.Fm() != null && eaN().ouE.Fm().aIz != null) {
                        if (eaN().ouE.Fm().aIz.userId == jSONObject2.optLong("user_id")) {
                            eaN().ouE.cju();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, eaN().ouE.Fm().aIz));
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
                    com.baidu.live.data.a KZ = bVar.KZ();
                    if (KZ != null && aj.gq(str3)) {
                        aj.d(str3, 1L, "", "", KZ.userId, KZ.portrait, KZ.userName, "", "", false, "", "", "", false, false, true, -1L, bVar.bno);
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
                    com.baidu.tieba.yuyinala.liveroom.j.c.a(eaN(), bVar, jSONObject2);
                }
            }
        } else if (bVar.getMsgType() != 125 && bVar.getMsgType() == 24) {
            com.baidu.tieba.yuyinala.liveroom.j.c.b(eaN(), bVar, jSONObject2, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.20
                @Override // com.baidu.tieba.yuyinala.liveroom.j.c.a
                public void VR(String str4) {
                    a.this.Hv(str4);
                }
            });
        }
    }

    protected void Hv(String str) {
    }

    void cbA() {
        if (cbB()) {
            BdUtilHelper.hideSoftKeyPad(eaN().pageContext.getPageActivity(), eaN().hBG.getLiveContainerView());
            caL();
        }
    }

    private boolean cbB() {
        if (caK() == null || caK().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(com.baidu.live.data.ab abVar) {
        CustomResponsedMessage runTask;
        eaN().ouF.setOnTouchListener(this.htf);
        cbL();
        cbr();
        if (this.hrE != null) {
            this.hrE.g(eaN().ouE.Fm());
        }
        if (this.otA != null) {
            this.otA.b(eaN().ouE.Fm(), Lo());
        }
        if (this.otI != null) {
            this.otI.h(eaN().ouE.Fm());
        }
        if (eaN().ouF != null) {
            eaN().ouF.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.22
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    return a.this.Q(motionEvent);
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Nc() {
                    if (a.this.hsG == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : a.this.hsG) {
                        if (bVar.Nc()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            eaN().ouF.setLiveViewOnTouchEventListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.24
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return a.this.P(motionEvent);
                }
            });
        }
        if (this.hrV == null && (runTask = MessageManager.getInstance().runTask(2501042, af.class, eaN().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hrV = (af) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbD() {
        com.baidu.live.data.ab Fm;
        ViewGroup viewGroup;
        if (eaN() != null && eaN().ouE != null && (Fm = eaN().ouE.Fm()) != null && Fm.mLiveInfo != null && Fm.aJa && (viewGroup = (ViewGroup) eaN().hBG) != null) {
            if (this.otF == null) {
                this.otF = new com.baidu.tieba.yuyinala.liveroom.recommend.a(eaN().pageContext);
            }
            this.otF.o(Fm);
            this.otF.a(eaN().ouF);
            this.otF.aF(viewGroup);
            a((d) this.otF);
            a((com.baidu.live.liveroom.g.b) this.otF);
        }
    }

    protected void a(d dVar) {
        if (this.hsF == null) {
            this.hsF = new ArrayList();
        }
        if (!this.hsF.contains(dVar)) {
            this.hsF.add(dVar);
        }
    }

    protected void b(d dVar) {
        if (this.hsF != null && this.hsF.contains(dVar)) {
            this.hsF.remove(dVar);
        }
    }

    protected void cbE() {
        if (this.hsF != null) {
            this.hsF.clear();
            this.hsF = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hsF == null) {
            return false;
        }
        Iterator<d> it = this.hsF.iterator();
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
        if (this.hsG == null) {
            this.hsG = new ArrayList();
        }
        if (!this.hsG.contains(bVar)) {
            this.hsG.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hsG != null && this.hsG.contains(bVar)) {
            this.hsG.remove(bVar);
        }
    }

    protected void cbF() {
        if (this.hsG != null) {
            this.hsG.clear();
            this.hsG = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hsG == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hsG.iterator();
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
    public void cbG() {
        if (this.otE == null && this.hsg != null && this.hsg.aQc && eaN() != null && eaN().ouE != null && eaN().ouE.Fm() != null) {
            this.otE = new com.baidu.tieba.yuyinala.liveroom.f.c(eaN().pageContext, this.hsg);
            this.otE.K(eaN().ouE.Fm());
            if (this.hsg.aQf == 1) {
                if (this.hrF != null) {
                    this.hsx = true;
                }
            } else if (this.hsg.aQf == 2) {
                a(eaN().ouE.Fm(), null, -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbH() {
        CustomResponsedMessage runTask;
        if (eaN() != null && (runTask = MessageManager.getInstance().runTask(2501047, k.class, eaN().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.hsh = (com.baidu.live.aa.a) runTask.getData();
            this.hsh.q(caN());
            if (eaN().ouE != null) {
                this.hsy = this.hsh.p(eaN().ouE.Fm());
            }
            this.hsh.setCanVisible(!this.hss);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(boolean z, boolean z2) {
        Rect rect = new Rect();
        eaN().hBG.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(eaN().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(eaN().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? eaN().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + eaN().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? eaN().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds192) : 0) + eaN().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds32);
    }

    private void cbL() {
        if (this.hrB == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ag.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.hrB = (com.baidu.live.ag.a) runTask.getData();
            }
            cbM();
        }
    }

    private void dU(JSONObject jSONObject) {
        if (this.hrB != null) {
            this.hrB.dc(true);
            this.hrB.ab(jSONObject);
        }
    }

    private void cbM() {
        if (this.hrB != null && eaN().ouE.Fm() != null && eaN().ouE.Fm().aIO != null) {
            this.hrB.dc(true);
            this.hrB.j(eaN().ouE.Fm());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(com.baidu.live.data.ab abVar) {
        if (abVar != null) {
            cbM();
            if (this.oty != null && abVar.aId != null) {
                this.oty.HG(String.valueOf(abVar.aId.userId));
            }
            if (this.hrI != null && abVar.mLiveInfo != null) {
                this.hrI.a(abVar.mLiveInfo, abVar.aId);
            }
            if (this.hrG != null) {
                this.hrG.a(abVar);
            }
            if (this.hsh != null) {
                this.hsy = this.hsh.p(abVar);
            }
            vq(abVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void vq(int i) {
        if (!eaN().hBM) {
            if (this.hsq < 0 && i == 0) {
                this.hsq = i;
            } else if (this.hsq != i) {
                if (i == 1) {
                    if (!this.otz.wf(2)) {
                        String string = eaN().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(eaN().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.otz.a(eaN().hBG.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = eaN().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.otz.wg(2);
                    this.otz.wg(3);
                    if (bVK()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.otz.c(eaN().hBG.getLiveContainerView(), string2, 3);
                    }
                }
                this.hsq = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cH(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.cH(z);
        if (z) {
            cbN();
        }
        if (this.otw != null) {
            this.otw.Ar();
        }
        if (this.hrB != null) {
            this.hrB.onDestroy();
            this.hrB = null;
        }
        if (this.otI != null) {
            this.otI.onDestroy();
        }
        if (this.hrH != null) {
            View EI = this.hrH.EI();
            if (EI != null && EI.getParent() != null) {
                ((ViewGroup) EI.getParent()).removeView(EI);
            }
            this.hrH.onDestroy();
            this.hrH = null;
        }
        if (this.hrG != null) {
            this.hrG.a((a.InterfaceC0179a) null);
            this.hrG.zR();
        }
        if (this.otz != null) {
            this.otz.Ar();
        }
        this.hsq = -1;
        if (this.oty != null) {
            this.oty.Ar();
            this.oty.onDestroy();
        }
        if (this.otB != null) {
            this.otB.bZW();
            this.otB.Fy();
        }
        if (this.hrE != null) {
            this.hrE.Fy();
        }
        if (this.otA != null) {
            this.otA.Fy();
        }
        if (this.otE != null) {
            this.otE.onDestroy();
        }
        if (this.hrV != null) {
            this.hrV.Fy();
        }
        if (this.otx != null) {
            this.otx.onDestory();
        }
        if (this.hsh != null) {
            this.hsh.Fy();
        }
        if (this.hrT != null) {
            this.hrT.onDestroy();
        }
        if (this.otF != null) {
            this.otF.Ar();
            b((d) this.otF);
            b((com.baidu.live.liveroom.g.b) this.otF);
        }
        ShowUtil.windowCount = 0;
        cbE();
        cbF();
    }

    private void cbN() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = eaN().ouF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = eaN().ouF.getChildAt(i);
            if (childAt != this.hso && childAt != this.hsp) {
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
        if (this.hso != null) {
            this.hso.removeAllViews();
        }
        if (this.hsp != null) {
            this.hsp.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, com.baidu.live.data.ab abVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(com.baidu.live.data.ab abVar) {
        View zP;
        View EI;
        if (this.hrH != null && (EI = this.hrH.EI()) != null && EI.getParent() != null) {
            ((ViewGroup) EI.getParent()).removeView(EI);
        }
        if (this.hrG != null && (zP = this.hrG.zP()) != null && zP.getParent() != null) {
            ((ViewGroup) zP.getParent()).removeView(zP);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean MY() {
        cbn();
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        if (this.hrB != null) {
            this.hrB.onDestroy();
            this.hrB = null;
        }
        if (this.hrH != null) {
            this.hrH.onDestroy();
            this.hrH = null;
        }
        if (this.hrI != null) {
            this.hrI.onDestroy();
            this.hrI = null;
        }
        if (this.otz != null) {
            this.otz.onDestroy();
        }
        if (this.otw != null) {
            this.otw.onDestroy();
        }
        if (this.hrT != null) {
            this.hrT.onDestroy();
            this.hrT = null;
        }
        if (this.hrG != null) {
            this.hrG.a((a.InterfaceC0179a) null);
            this.hrG.release();
            this.hrG = null;
        }
        if (this.otA != null) {
            this.otA.a(null);
            this.otA.release();
        }
        if (this.otE != null) {
            this.otE.onDestroy();
        }
        if (this.hrV != null) {
            this.hrV.release();
        }
        if (this.otx != null) {
            this.otx.onDestory();
        }
        if (this.hsh != null) {
            this.hsh.release();
        }
        if (this.otI != null) {
            this.otI.a((b.a) null);
            this.otI.onDestroy();
        }
        if (this.otF != null) {
            this.otF.onDestroy();
            b((d) this.otF);
            b((com.baidu.live.liveroom.g.b) this.otF);
        }
        cbE();
        cbF();
        MessageManager.getInstance().unRegisterListener(this.hsL);
        MessageManager.getInstance().unRegisterListener(this.hsM);
        MessageManager.getInstance().unRegisterListener(this.hsN);
        MessageManager.getInstance().unRegisterListener(this.hsR);
        MessageManager.getInstance().unRegisterListener(this.hsS);
        MessageManager.getInstance().unRegisterListener(this.otM);
        MessageManager.getInstance().unRegisterListener(this.hsU);
        MessageManager.getInstance().unRegisterListener(this.hsO);
        MessageManager.getInstance().unRegisterListener(this.hsP);
        MessageManager.getInstance().unRegisterListener(this.gNt);
        MessageManager.getInstance().unRegisterListener(this.hsQ);
        MessageManager.getInstance().unRegisterListener(this.gNG);
        MessageManager.getInstance().unRegisterListener(this.hsV);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.bxM);
        MessageManager.getInstance().unRegisterListener(this.hsW);
        MessageManager.getInstance().unRegisterListener(this.hsX);
        MessageManager.getInstance().unRegisterListener(this.htc);
        MessageManager.getInstance().unRegisterListener(this.htd);
        MessageManager.getInstance().unRegisterListener(this.hdY);
        MessageManager.getInstance().unRegisterTask(2501083);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        caL();
        if (this.hrT != null) {
            this.hrT.onPause();
        }
        if (this.otI != null) {
            this.otI.oq(false);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.hsB = false;
        if (this.hst && this.hsu != null) {
            a(this.hsu);
            this.hst = false;
        }
        if (this.hrT != null) {
            this.hrT.onResume();
        }
        if (this.otI != null) {
            this.otI.oq(true);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awo() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.otF != null && this.otF.isOpen()) {
            this.otF.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            awo();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    a(null, -1, -1, -1);
                    return;
                }
                return;
            }
            awo();
        } else if (i == 25034) {
            cbk();
        } else if (i == 25043 && i2 == -1) {
            cbQ();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void e(boolean z, int i) {
        this.hss = z;
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
        if (this.otx != null) {
            this.otx.bkp();
        }
        if (this.otF != null) {
            this.otF.C(i, i3);
        }
        if (this.otI != null) {
            this.otI.bkp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        this.otu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.yuyinala.liveroom.data.a eaN() {
        return this.otu;
    }

    private void cbQ() {
        String IU = g.IT().IU();
        if (!TextUtils.isEmpty(IU)) {
            try {
                a(null, -1, Integer.parseInt(IU), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                a(null, -1, -1, -1);
            }
        }
    }

    @Override // com.baidu.live.liveroom.a.a
    public boolean dF(int i) {
        if (1 == i) {
            if (caK() != null) {
                caK().setVisibility(8);
                return true;
            }
            return true;
        } else if (2 == i) {
            return !this.hss;
        } else if (3 == i) {
            if (eaN().ouF == null) {
                return false;
            }
            eaN().ouF.setEnabled(false);
            if (this.brL != null) {
                this.brL.e(!eaN().hBK, false);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    public void vo(int i) {
    }

    @Override // com.baidu.live.liveroom.a.a
    public void dG(int i) {
        if (3 == i) {
            eaN().ouF.setEnabled(true);
            if (this.brL != null) {
                this.brL.e(!eaN().hBK, true);
            }
            if (this.hrB != null) {
                this.hrB.dc(true);
                return;
            }
            return;
        }
        if (2 == i) {
        }
    }

    public String Lo() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.hrG != null) {
            this.hrG.setOtherParams(str);
        }
    }

    private boolean bVK() {
        return eaN().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.grF = alaLastLiveroomInfo;
    }
}
