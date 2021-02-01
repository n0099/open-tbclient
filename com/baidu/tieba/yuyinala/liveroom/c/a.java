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
    protected AlaLastLiveroomInfo grr;
    protected ag hrF;
    private af hrH;
    protected bw hrS;
    protected com.baidu.live.aa.a hrT;
    protected com.baidu.live.ag.a hrn;
    private m hrq;
    k hrr;
    com.baidu.live.im.b.a hrs;
    protected ad hrt;
    protected ab hru;
    protected RelativeLayout hsa;
    protected RelativeLayout hsb;
    protected boolean hsd;
    protected ax hsg;
    protected GuardClubInfoHttpResponseMessage hsh;
    boolean hsi;
    boolean hsj;
    boolean hsk;
    public boolean hsm;
    public boolean hsn;
    protected List<d> hsr;
    protected List<com.baidu.live.liveroom.g.b> hss;
    private com.baidu.tieba.yuyinala.liveroom.data.a osU;
    protected com.baidu.tieba.yuyinala.liveroom.operation.a osV;
    protected com.baidu.tieba.yuyinala.liveroom.share.a osW;
    protected com.baidu.tieba.yuyinala.liveroom.n.b osX;
    private com.baidu.tieba.yuyinala.liveroom.f.a osY;
    protected com.baidu.tieba.yuyinala.liveroom.tippop.a osZ;
    protected e ota;
    protected com.baidu.tieba.yuyinala.liveroom.b.a otb;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.lucky.a otc;
    protected com.baidu.tieba.yuyinala.liveroom.f.c ote;
    protected com.baidu.tieba.yuyinala.liveroom.recommend.a otf;
    private CustomMessageTask otg;
    private CustomMessageTask.CustomRunnable<Integer> oth;
    protected String otherParams;
    com.baidu.tieba.yuyinala.liveroom.h.b oti;
    protected com.baidu.tieba.yuyinala.liveroom.e.a otk;
    private int otd = 0;
    private int hsc = -1;
    protected int mOrientation = 0;
    protected boolean hse = false;
    protected boolean hsf = false;
    public boolean otj = false;
    private CustomMessageListener hsx = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ao aoVar;
            if ((customResponsedMessage.getData() instanceof ao) && (aoVar = (ao) customResponsedMessage.getData()) != null) {
                a.this.a(aoVar.aJZ, null, aoVar.aJV, aoVar.aJW, aoVar.aJX, aoVar.aJY);
            }
        }
    };
    private CustomMessageListener hsy = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.vo(7);
        }
    };
    private CustomMessageListener hsz = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.cbd();
        }
    };
    private CustomMessageListener hsA = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(a.this.eaF().oud.Fm().aId.userId);
            com.baidu.live.view.a.Xo().a(valueOf, new f(a.this.eaF().oud.Fm().aId.portrait, valueOf, true, a.this.eaF().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener hsB = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.data.ab) && a.this.osW != null) {
                a.this.osW.d((com.baidu.live.data.ab) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bxM = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hrr != null) {
                a.this.hrr.g(z.Fe().Fg());
            }
        }
    };
    private CustomMessageListener hsC = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = a.this.osU.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                a.this.Hy(str);
            }
        }
    };
    private CustomMessageListener gNf = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.eaF().pageContext.getPageActivity());
            } else if (a.this.osW != null) {
                a.this.osW.d(a.this.eaF().oud.Fm(), false);
            }
        }
    };
    private CustomMessageListener hsD = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ax) {
                    a.this.hsf = true;
                    a.this.hsg = (ax) data;
                    a.this.b(a.this.hsg);
                } else if (data instanceof com.baidu.live.data.a) {
                    a.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener hsE = new CustomMessageListener(2501060) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(a.this.eaF().oud.Fm().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(a.this.eaF().oud.Fm().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(a.this.eaF().oud.Fm().mLiveInfo.room_id);
                    String valueOf4 = String.valueOf(a.this.eaF().oud.Fm().aId.userId);
                    if (a.this.osX == null) {
                        a.this.osX = new com.baidu.tieba.yuyinala.liveroom.n.b();
                    }
                    a.this.osX.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, valueOf4, false, obj);
                    a.this.osX.a(a.this.otl);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private h.a otl = new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.3
    };
    private CustomMessageListener hsG = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                a.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener gNs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.5
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
    CustomMessageListener hsH = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.hsi = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.oti != null) {
                a.this.oti.FA();
            }
        }
    };
    private CustomMessageListener hsI = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof di) {
                if (TextUtils.equals(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()), ((di) customResponsedMessage.getData()).aTJ)) {
                    BdUtilHelper.getCustomToast().showToast(a.this.osU.pageContext.getString(a.h.yuyin_sdk_redpacket_snatch_host_alert), 1);
                } else {
                    a.this.a((di) customResponsedMessage.getData());
                }
            }
        }
    };
    private CustomMessageListener hsJ = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.H(a.this.eaF().oud.Fm());
        }
    };
    private CustomMessageListener hsO = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (a.this.hrF != null) {
                    ((com.baidu.tieba.yuyinala.liveroom.m.a) a.this.hrF).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hdK = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.an.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (a.this.bgE == null) {
                a.this.bgE = new com.baidu.live.an.a(a.this.eaF().pageContext.getPageActivity());
            }
            a.this.bgE.a((com.baidu.live.an.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener hsP = new CustomMessageListener(2501031) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                a.this.a(a.this.eaF().oud.Fm(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener hsR = new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.21
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.cbt();
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener otm = new CustomMessageListener(2501034) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.25
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

    protected abstract View caD();

    public abstract boolean caE();

    protected abstract ViewGroup caG();

    protected abstract void cat();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bw bwVar) {
        this.hrS = bwVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hsa = (RelativeLayout) eaF().oue.findViewById(a.f.ala_live_header_view);
        this.hsb = (RelativeLayout) eaF().oue.findViewById(a.f.ala_live_footer_view);
        Gd();
        registerListener();
    }

    public void caL() {
    }

    private void Gd() {
        if (this.osW == null) {
            this.osW = new com.baidu.tieba.yuyinala.liveroom.share.a(eaF().pageContext);
        }
        this.otb = new com.baidu.tieba.yuyinala.liveroom.b.a(eaF().pageContext, false);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            if (!TbadkCoreApplication.getInst().isHaokan() || !subappVersionName.startsWith("4.14.")) {
            }
            if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && subappVersionName.startsWith("1.14.")) {
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            }
        }
        this.osZ = new com.baidu.tieba.yuyinala.liveroom.tippop.a(eaF().pageContext, this);
        caO();
        caR();
        caS();
    }

    private void caO() {
        this.hrq = new m();
    }

    public void nO(boolean z) {
        this.hsd = z;
    }

    private void caR() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501037, e.class, eaF().pageContext);
        if (runTask != null && runTask.getData() != null) {
            try {
                this.ota = (e) runTask.getData();
                this.ota.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.14
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
                        return a.this.caV();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public int Kn() {
                        return a.this.caW();
                    }
                });
                this.oth = new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.15
                    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<Integer> run(CustomMessage<Integer> customMessage) {
                        return new CustomResponsedMessage<>(2501083, Integer.valueOf(a.this.hrr != null ? a.this.hrr.getImMsgListViewHeight() : 0));
                    }
                };
                this.otg = new CustomMessageTask(2501083, this.oth);
                this.otg.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                MessageManager.getInstance().registerTask(this.otg);
            } catch (Exception e) {
            }
        }
    }

    void nP(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean caV() {
        com.baidu.live.data.ab Fm;
        if (eaF() == null || eaF().oud == null || (Fm = eaF().oud.Fm()) == null || Fm.aIz == null) {
            return false;
        }
        String str = Fm.aIz.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int caW() {
        com.baidu.live.data.ab Fm;
        if (eaF() != null && eaF().oud != null && (Fm = eaF().oud.Fm()) != null && !ListUtils.isEmpty(Fm.aIK)) {
            for (AlaLiveMarkData alaLiveMarkData : Fm.aIK) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void caS() {
        this.oti = new com.baidu.tieba.yuyinala.liveroom.h.b(this.osU.pageContext);
        this.oti.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.16
            @Override // com.baidu.tieba.yuyinala.liveroom.h.b.a
            public boolean cbM() {
                com.baidu.live.data.ab Fm;
                if (a.this.eaF() == null || a.this.eaF().oud == null || (Fm = a.this.eaF().oud.Fm()) == null || Fm.aIU == null) {
                    return false;
                }
                return Fm.aIU.is_followed;
            }
        });
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.hsD);
        MessageManager.getInstance().registerListener(this.otm);
        MessageManager.getInstance().registerListener(this.hsE);
        MessageManager.getInstance().registerListener(this.hsG);
        MessageManager.getInstance().registerListener(this.hsA);
        MessageManager.getInstance().registerListener(this.hsB);
        MessageManager.getInstance().registerListener(this.gNf);
        MessageManager.getInstance().registerListener(this.hsC);
        MessageManager.getInstance().registerListener(this.gNs);
        MessageManager.getInstance().registerListener(this.hsH);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.bxM);
        MessageManager.getInstance().registerListener(this.hsI);
        MessageManager.getInstance().registerListener(this.hsJ);
        MessageManager.getInstance().registerListener(this.hsO);
        MessageManager.getInstance().registerListener(this.hsP);
        MessageManager.getInstance().registerListener(this.hsx);
        MessageManager.getInstance().registerListener(this.hsy);
        MessageManager.getInstance().registerListener(this.hsz);
        MessageManager.getInstance().registerListener(this.hdK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean HZ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(eaF().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(eaF().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(eaF().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.17
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.Qj().buX.aMs;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = eaF().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = eaF().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(a.this.eaF().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(eaF().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caZ() {
        if (this.hrr != null && this.ota != null) {
            this.otj = true;
            this.hrr.Ke().a(this.ota.Pl(), z.Fe().Fg(), eaF().oud.Fm().mLiveInfo);
            nP(true);
            if (this.hrH == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501042, af.class, eaF().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hrH = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrH.gw("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.otk == null) {
            this.otk = new com.baidu.tieba.yuyinala.liveroom.e.a(eaF().pageContext);
            this.otk.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.otk.a(eaF().oud.Fm(), alaLastLiveroomInfo);
        this.otk.aF(this.hsb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbc() {
        if (this.hrr != null) {
            this.hrr.Ke().hide();
            nP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String[] strArr, int i, int i2, int i3) {
        if (eaF().oud.Fm() != null && eaF().oud.Fm().aId != null && eaF().oud.Fm().mLiveInfo != null) {
            a(eaF().oud.Fm(), strArr, i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.ab abVar, String[] strArr, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(ac.class) != null && HZ()) {
            if (abVar == null) {
                abVar = eaF().oud.Fm();
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
            if (this.hsh != null && this.hsh.biY != null && this.hsh.biY.anchorId == abVar.aId.userId) {
                z5 = this.hsh.bjd;
            }
            ac acVar = new ac(eaF().pageContext.getPageActivity(), strArr, valueOf, str, valueOf2, valueOf3, i6, Fv, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.mAlaLiveSwitchData != null) {
                acVar.bi(abVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            acVar.bg(z);
            if (com.baidu.tieba.yuyinala.liveroom.p.b.ebL().bvg != null) {
                acVar.bh(com.baidu.tieba.yuyinala.liveroom.p.b.ebL().bvg.aKc != 1);
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
            if (!this.hsm) {
                this.hsn = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, acVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbd() {
        dG(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(di diVar) {
        if (diVar != null && HZ()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.aj(eaF().pageContext.getPageActivity(), diVar.aQQ, diVar.liveId, diVar.aTJ, diVar.roomId, diVar.time)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(com.baidu.live.data.ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && com.baidu.live.ae.a.Qj().buX != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(eaF().pageContext.getPageActivity(), String.valueOf(abVar.mLiveInfo.live_id), String.valueOf(abVar.mLiveInfo.user_id), com.baidu.live.ae.a.Qj().buX.aNa, 1, false)));
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(eaF().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbe() {
        if (this.ota != null) {
            this.ota.d(this.osU.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbf() {
        com.baidu.live.data.ab Fm = eaF().oud.Fm();
        LogManager.getCommonLogger().doClickQuickImHiLog((Fm == null || Fm.mLiveInfo == null) ? "" : Fm.mLiveInfo.feed_id, Lo());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Hz(String str) {
        if (this.ota != null) {
            this.ota.gz(str);
        }
    }

    private void cbg() {
        if ("home_rec_play".equals(eaF().fromType) || "frs_play".equals(eaF().fromType) || "frs_live_play".equals(eaF().fromType) || "person_play".equals(eaF().fromType) || "search".equals(eaF().fromType) || "person_attention".equals(eaF().fromType)) {
            com.baidu.live.c.xb().aV(true);
        } else {
            com.baidu.live.c.xb().aV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nQ(boolean z) {
        View EI;
        if (this.hrt == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aVn = false;
            fVar.context = eaF().pageContext.getPageActivity();
            fVar.aVx = z;
            fVar.fromType = eaF().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501040, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrt = (ad) runTask.getData();
            }
        }
        if (this.hrt != null && (EI = this.hrt.EI()) != null && this.osU.oue.indexOfChild(EI) < 0) {
            u.a(eaF().oue, EI, new RelativeLayout.LayoutParams(-1, -1), 250);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbh() {
        View Fz;
        if (this.hrF == null) {
            ak akVar = new ak();
            akVar.aVn = false;
            akVar.pageContext = eaF().pageContext;
            akVar.fromType = eaF().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501065, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrF = (ag) runTask.getData();
            }
        }
        if (this.hrF != null && (Fz = this.hrF.Fz()) != null && eaF().oue.indexOfChild(Fz) < 0) {
            if (Fz.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fz.getParent()).removeView(Fz);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = eaF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            u.a(eaF().oue, Fz, layoutParams, 550);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbi() {
        View Fl;
        if (this.hru == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aVn = false;
            aVar.context = eaF().pageContext.getPageActivity();
            aVar.fromType = eaF().fromType;
            aVar.aVo = eaF().hBz;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501041, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hru = (ab) runTask.getData();
            }
        }
        if (this.hru != null && (Fl = this.hru.Fl()) != null && eaF().oue.indexOfChild(Fl) < 0) {
            if (Fl.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fl.getParent()).removeView(Fl);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = (BdUtilHelper.getDimens(eaF().pageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(eaF().pageContext.getPageActivity(), a.d.sdk_ds12) : 0)) + BdUtilHelper.getDimens(eaF().pageContext.getPageActivity(), a.d.sdk_ds152) + (eaF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18) * (-1));
            u.a(eaF().oue, Fl, layoutParams, 300);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbj() {
        CustomResponsedMessage runTask;
        if (this.hrs == null && (runTask = MessageManager.getInstance().runTask(2501052, com.baidu.live.im.b.a.class, eaF().pageContext)) != null) {
            this.hrs = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hrs != null) {
            this.hrs.setOtherParams(this.otherParams);
            this.hrs.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.19
                @Override // com.baidu.live.im.b.a.InterfaceC0179a
                public void KM() {
                    a.this.cbt();
                }
            });
            this.hrs.a(eaF().oud.Fm(), false);
            View zP = this.hrs.zP();
            if (zP != null && this.hsb.indexOfChild(zP) < 0) {
                Resources resources = eaF().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(eaF().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.hsb.addView(zP, layoutParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501053));
        }
    }

    private void cbk() {
        if (this.osY == null) {
            this.osY = new com.baidu.tieba.yuyinala.liveroom.f.a(eaF().pageContext);
        }
        if (this.hsg != null) {
            this.osY.HF(this.hsg.user_id);
        }
        this.osY.aF(null);
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
                            eaF().oud.Fm().aIz.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            eaF().oud.Fm().aIz.isAdmin = 0;
                            eaF().oud.cjn();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        eaF().oud.Fm().aIz.isAdmin = 0;
                        eaF().oud.cjn();
                    }
                } else if ("task".equals(optString2)) {
                    dU(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt(UbcStatConstant.KEY_CONTENT_EXT_LM_NETWORK);
                    if (this.osZ != null && !eaF().hBy) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = eaF().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = eaF().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = eaF().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bVD()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.osZ.c(eaF().hBs.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    if (eaF().oud.Fm() != null && eaF().oud.Fm().mLiveInfo != null) {
                        eaF().oud.a(eaF().oud.Fm().mLiveInfo.live_id, eaF().fromType, eaF().enterTime);
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.yuyinala.liveroom.o.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (eaF().oud.Fm() != null && eaF().oud.Fm().aIz != null && eaF().oud.Fm().aIz.userId == optLong2) {
                        eaF().oud.Fm().aIz.isBlock = 1;
                        cat();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (eaF().oud.Fm() != null && eaF().oud.Fm().aIz != null && eaF().oud.Fm().aIz.userId == optLong3) {
                        eaF().oud.Fm().aIz.isBlock = 0;
                        cat();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (eaF().oud.Fm() != null && eaF().oud.Fm().aIz != null && eaF().oud.Fm().aIz.userId == optLong4) {
                        eaF().oud.Fm().aIz.isUegBlock = 1;
                        cat();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (eaF().oud.Fm() != null && eaF().oud.Fm().aIz != null && eaF().oud.Fm().aIz.userId == optLong5) {
                        eaF().oud.Fm().aIz.isUegBlock = 0;
                        cat();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (eaF() != null && eaF().oud != null && eaF().oud.Fm() != null && eaF().oud.Fm().aIz != null) {
                        if (eaF().oud.Fm().aIz.userId == jSONObject2.optLong("user_id")) {
                            eaF().oud.cjn();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, eaF().oud.Fm().aIz));
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
                    com.baidu.tieba.yuyinala.liveroom.j.c.a(eaF(), bVar, jSONObject2);
                }
            }
        } else if (bVar.getMsgType() != 125 && bVar.getMsgType() == 24) {
            com.baidu.tieba.yuyinala.liveroom.j.c.b(eaF(), bVar, jSONObject2, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.20
                @Override // com.baidu.tieba.yuyinala.liveroom.j.c.a
                public void VF(String str4) {
                    a.this.Hu(str4);
                }
            });
        }
    }

    protected void Hu(String str) {
    }

    void cbt() {
        if (cbu()) {
            BdUtilHelper.hideSoftKeyPad(eaF().pageContext.getPageActivity(), eaF().hBs.getLiveContainerView());
            caE();
        }
    }

    private boolean cbu() {
        if (caD() == null || caD().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(com.baidu.live.data.ab abVar) {
        CustomResponsedMessage runTask;
        eaF().oue.setOnTouchListener(this.hsR);
        cbE();
        cbk();
        if (this.hrq != null) {
            this.hrq.g(eaF().oud.Fm());
        }
        if (this.ota != null) {
            this.ota.b(eaF().oud.Fm(), Lo());
        }
        if (this.oti != null) {
            this.oti.h(eaF().oud.Fm());
        }
        if (eaF().oue != null) {
            eaF().oue.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.22
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    return a.this.Q(motionEvent);
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Nc() {
                    if (a.this.hss == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : a.this.hss) {
                        if (bVar.Nc()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            eaF().oue.setLiveViewOnTouchEventListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.24
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return a.this.P(motionEvent);
                }
            });
        }
        if (this.hrH == null && (runTask = MessageManager.getInstance().runTask(2501042, af.class, eaF().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hrH = (af) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbw() {
        com.baidu.live.data.ab Fm;
        ViewGroup viewGroup;
        if (eaF() != null && eaF().oud != null && (Fm = eaF().oud.Fm()) != null && Fm.mLiveInfo != null && Fm.aJa && (viewGroup = (ViewGroup) eaF().hBs) != null) {
            if (this.otf == null) {
                this.otf = new com.baidu.tieba.yuyinala.liveroom.recommend.a(eaF().pageContext);
            }
            this.otf.o(Fm);
            this.otf.a(eaF().oue);
            this.otf.aF(viewGroup);
            a((d) this.otf);
            a((com.baidu.live.liveroom.g.b) this.otf);
        }
    }

    protected void a(d dVar) {
        if (this.hsr == null) {
            this.hsr = new ArrayList();
        }
        if (!this.hsr.contains(dVar)) {
            this.hsr.add(dVar);
        }
    }

    protected void b(d dVar) {
        if (this.hsr != null && this.hsr.contains(dVar)) {
            this.hsr.remove(dVar);
        }
    }

    protected void cbx() {
        if (this.hsr != null) {
            this.hsr.clear();
            this.hsr = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hsr == null) {
            return false;
        }
        Iterator<d> it = this.hsr.iterator();
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
        if (this.hss == null) {
            this.hss = new ArrayList();
        }
        if (!this.hss.contains(bVar)) {
            this.hss.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hss != null && this.hss.contains(bVar)) {
            this.hss.remove(bVar);
        }
    }

    protected void cby() {
        if (this.hss != null) {
            this.hss.clear();
            this.hss = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hss == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hss.iterator();
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
    public void cbz() {
        if (this.ote == null && this.hrS != null && this.hrS.aQc && eaF() != null && eaF().oud != null && eaF().oud.Fm() != null) {
            this.ote = new com.baidu.tieba.yuyinala.liveroom.f.c(eaF().pageContext, this.hrS);
            this.ote.K(eaF().oud.Fm());
            if (this.hrS.aQf == 1) {
                if (this.hrr != null) {
                    this.hsj = true;
                }
            } else if (this.hrS.aQf == 2) {
                a(eaF().oud.Fm(), null, -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbA() {
        CustomResponsedMessage runTask;
        if (eaF() != null && (runTask = MessageManager.getInstance().runTask(2501047, k.class, eaF().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.hrT = (com.baidu.live.aa.a) runTask.getData();
            this.hrT.q(caG());
            if (eaF().oud != null) {
                this.hsk = this.hrT.p(eaF().oud.Fm());
            }
            this.hrT.setCanVisible(!this.hse);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(boolean z, boolean z2) {
        Rect rect = new Rect();
        eaF().hBs.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(eaF().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(eaF().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? eaF().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + eaF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? eaF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds192) : 0) + eaF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds32);
    }

    private void cbE() {
        if (this.hrn == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ag.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.hrn = (com.baidu.live.ag.a) runTask.getData();
            }
            cbF();
        }
    }

    private void dU(JSONObject jSONObject) {
        if (this.hrn != null) {
            this.hrn.dc(true);
            this.hrn.ab(jSONObject);
        }
    }

    private void cbF() {
        if (this.hrn != null && eaF().oud.Fm() != null && eaF().oud.Fm().aIO != null) {
            this.hrn.dc(true);
            this.hrn.j(eaF().oud.Fm());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(com.baidu.live.data.ab abVar) {
        if (abVar != null) {
            cbF();
            if (this.osY != null && abVar.aId != null) {
                this.osY.HF(String.valueOf(abVar.aId.userId));
            }
            if (this.hru != null && abVar.mLiveInfo != null) {
                this.hru.a(abVar.mLiveInfo, abVar.aId);
            }
            if (this.hrs != null) {
                this.hrs.a(abVar);
            }
            if (this.hrT != null) {
                this.hsk = this.hrT.p(abVar);
            }
            vq(abVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void vq(int i) {
        if (!eaF().hBy) {
            if (this.hsc < 0 && i == 0) {
                this.hsc = i;
            } else if (this.hsc != i) {
                if (i == 1) {
                    if (!this.osZ.wf(2)) {
                        String string = eaF().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(eaF().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.osZ.a(eaF().hBs.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = eaF().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.osZ.wg(2);
                    this.osZ.wg(3);
                    if (bVD()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.osZ.c(eaF().hBs.getLiveContainerView(), string2, 3);
                    }
                }
                this.hsc = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cH(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.cH(z);
        if (z) {
            cbG();
        }
        if (this.osW != null) {
            this.osW.Ar();
        }
        if (this.hrn != null) {
            this.hrn.onDestroy();
            this.hrn = null;
        }
        if (this.oti != null) {
            this.oti.onDestroy();
        }
        if (this.hrt != null) {
            View EI = this.hrt.EI();
            if (EI != null && EI.getParent() != null) {
                ((ViewGroup) EI.getParent()).removeView(EI);
            }
            this.hrt.onDestroy();
            this.hrt = null;
        }
        if (this.hrs != null) {
            this.hrs.a((a.InterfaceC0179a) null);
            this.hrs.zR();
        }
        if (this.osZ != null) {
            this.osZ.Ar();
        }
        this.hsc = -1;
        if (this.osY != null) {
            this.osY.Ar();
            this.osY.onDestroy();
        }
        if (this.otb != null) {
            this.otb.bZP();
            this.otb.Fy();
        }
        if (this.hrq != null) {
            this.hrq.Fy();
        }
        if (this.ota != null) {
            this.ota.Fy();
        }
        if (this.ote != null) {
            this.ote.onDestroy();
        }
        if (this.hrH != null) {
            this.hrH.Fy();
        }
        if (this.osX != null) {
            this.osX.onDestory();
        }
        if (this.hrT != null) {
            this.hrT.Fy();
        }
        if (this.hrF != null) {
            this.hrF.onDestroy();
        }
        if (this.otf != null) {
            this.otf.Ar();
            b((d) this.otf);
            b((com.baidu.live.liveroom.g.b) this.otf);
        }
        ShowUtil.windowCount = 0;
        cbx();
        cby();
    }

    private void cbG() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = eaF().oue.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = eaF().oue.getChildAt(i);
            if (childAt != this.hsa && childAt != this.hsb) {
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
        if (this.hsa != null) {
            this.hsa.removeAllViews();
        }
        if (this.hsb != null) {
            this.hsb.removeAllViews();
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
        if (this.hrt != null && (EI = this.hrt.EI()) != null && EI.getParent() != null) {
            ((ViewGroup) EI.getParent()).removeView(EI);
        }
        if (this.hrs != null && (zP = this.hrs.zP()) != null && zP.getParent() != null) {
            ((ViewGroup) zP.getParent()).removeView(zP);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean MY() {
        cbg();
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        if (this.hrn != null) {
            this.hrn.onDestroy();
            this.hrn = null;
        }
        if (this.hrt != null) {
            this.hrt.onDestroy();
            this.hrt = null;
        }
        if (this.hru != null) {
            this.hru.onDestroy();
            this.hru = null;
        }
        if (this.osZ != null) {
            this.osZ.onDestroy();
        }
        if (this.osW != null) {
            this.osW.onDestroy();
        }
        if (this.hrF != null) {
            this.hrF.onDestroy();
            this.hrF = null;
        }
        if (this.hrs != null) {
            this.hrs.a((a.InterfaceC0179a) null);
            this.hrs.release();
            this.hrs = null;
        }
        if (this.ota != null) {
            this.ota.a(null);
            this.ota.release();
        }
        if (this.ote != null) {
            this.ote.onDestroy();
        }
        if (this.hrH != null) {
            this.hrH.release();
        }
        if (this.osX != null) {
            this.osX.onDestory();
        }
        if (this.hrT != null) {
            this.hrT.release();
        }
        if (this.oti != null) {
            this.oti.a((b.a) null);
            this.oti.onDestroy();
        }
        if (this.otf != null) {
            this.otf.onDestroy();
            b((d) this.otf);
            b((com.baidu.live.liveroom.g.b) this.otf);
        }
        cbx();
        cby();
        MessageManager.getInstance().unRegisterListener(this.hsx);
        MessageManager.getInstance().unRegisterListener(this.hsy);
        MessageManager.getInstance().unRegisterListener(this.hsz);
        MessageManager.getInstance().unRegisterListener(this.hsD);
        MessageManager.getInstance().unRegisterListener(this.hsE);
        MessageManager.getInstance().unRegisterListener(this.otm);
        MessageManager.getInstance().unRegisterListener(this.hsG);
        MessageManager.getInstance().unRegisterListener(this.hsA);
        MessageManager.getInstance().unRegisterListener(this.hsB);
        MessageManager.getInstance().unRegisterListener(this.gNf);
        MessageManager.getInstance().unRegisterListener(this.hsC);
        MessageManager.getInstance().unRegisterListener(this.gNs);
        MessageManager.getInstance().unRegisterListener(this.hsH);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.bxM);
        MessageManager.getInstance().unRegisterListener(this.hsI);
        MessageManager.getInstance().unRegisterListener(this.hsJ);
        MessageManager.getInstance().unRegisterListener(this.hsO);
        MessageManager.getInstance().unRegisterListener(this.hsP);
        MessageManager.getInstance().unRegisterListener(this.hdK);
        MessageManager.getInstance().unRegisterTask(2501083);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        caE();
        if (this.hrF != null) {
            this.hrF.onPause();
        }
        if (this.oti != null) {
            this.oti.oq(false);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.hsn = false;
        if (this.hsf && this.hsg != null) {
            a(this.hsg);
            this.hsf = false;
        }
        if (this.hrF != null) {
            this.hrF.onResume();
        }
        if (this.oti != null) {
            this.oti.oq(true);
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
        if (i == 4 && this.otf != null && this.otf.isOpen()) {
            this.otf.onClose();
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
            cbd();
        } else if (i == 25043 && i2 == -1) {
            cbJ();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void e(boolean z, int i) {
        this.hse = z;
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
        if (this.osX != null) {
            this.osX.bkp();
        }
        if (this.otf != null) {
            this.otf.C(i, i3);
        }
        if (this.oti != null) {
            this.oti.bkp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        this.osU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.yuyinala.liveroom.data.a eaF() {
        return this.osU;
    }

    private void cbJ() {
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
            if (caD() != null) {
                caD().setVisibility(8);
                return true;
            }
            return true;
        } else if (2 == i) {
            return !this.hse;
        } else if (3 == i) {
            if (eaF().oue == null) {
                return false;
            }
            eaF().oue.setEnabled(false);
            if (this.brL != null) {
                this.brL.e(!eaF().hBw, false);
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
            eaF().oue.setEnabled(true);
            if (this.brL != null) {
                this.brL.e(!eaF().hBw, true);
            }
            if (this.hrn != null) {
                this.hrn.dc(true);
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
        if (this.hrs != null) {
            this.hrs.setOtherParams(str);
        }
    }

    private boolean bVD() {
        return eaF().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.grr = alaLastLiveroomInfo;
    }
}
