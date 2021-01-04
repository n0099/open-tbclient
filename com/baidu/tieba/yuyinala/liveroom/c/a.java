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
import com.baidu.live.data.ak;
import com.baidu.live.data.at;
import com.baidu.live.data.bd;
import com.baidu.live.data.bi;
import com.baidu.live.data.bq;
import com.baidu.live.data.br;
import com.baidu.live.data.dc;
import com.baidu.live.data.f;
import com.baidu.live.data.x;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.af;
import com.baidu.live.gift.ag;
import com.baidu.live.gift.aj;
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
    protected AlaLastLiveroomInfo gtp;
    protected com.baidu.live.ai.a hrH;
    private m hrK;
    k hrL;
    com.baidu.live.im.b.a hrM;
    protected ad hrN;
    protected ab hrO;
    protected ag hrZ;
    protected at hsC;
    protected GuardClubInfoHttpResponseMessage hsD;
    boolean hsE;
    boolean hsF;
    boolean hsG;
    public boolean hsI;
    public boolean hsJ;
    protected List<d> hsN;
    protected List<com.baidu.live.liveroom.g.b> hsO;
    private af hsd;
    protected br hso;
    protected com.baidu.live.ab.a hsp;
    protected RelativeLayout hsw;
    protected RelativeLayout hsx;
    protected boolean hsz;
    private com.baidu.tieba.yuyinala.liveroom.data.a onH;
    protected com.baidu.tieba.yuyinala.liveroom.operation.a onI;
    protected com.baidu.tieba.yuyinala.liveroom.share.a onJ;
    protected com.baidu.tieba.yuyinala.liveroom.n.b onK;
    private com.baidu.tieba.yuyinala.liveroom.f.a onL;
    protected com.baidu.tieba.yuyinala.liveroom.tippop.a onM;
    protected e onN;
    protected com.baidu.tieba.yuyinala.liveroom.b.a onO;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.b onP;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.lucky.a onQ;
    protected com.baidu.tieba.yuyinala.liveroom.m.b onS;
    protected com.baidu.tieba.yuyinala.liveroom.f.c onT;
    protected com.baidu.tieba.yuyinala.liveroom.recommend.a onU;
    private CustomMessageTask onV;
    private CustomMessageTask.CustomRunnable<Integer> onW;
    com.baidu.tieba.yuyinala.liveroom.h.b onX;
    protected com.baidu.tieba.yuyinala.liveroom.e.a onY;
    protected String otherParams;
    private int onR = 0;
    private int hsy = -1;
    protected int mOrientation = 0;
    protected boolean hsA = false;
    protected boolean hsB = false;
    private CustomMessageListener hsT = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ak akVar;
            if ((customResponsedMessage.getData() instanceof ak) && (akVar = (ak) customResponsedMessage.getData()) != null) {
                a.this.a(akVar.aMh, null, akVar.aMd, akVar.aMe, akVar.aMf, akVar.aMg);
            }
        }
    };
    private CustomMessageListener hsU = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.wJ(7);
        }
    };
    private CustomMessageListener hsV = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.cea();
        }
    };
    private CustomMessageListener hsW = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(a.this.ecj().ooR.HR().aKu.userId);
            com.baidu.live.view.a.Zx().a(valueOf, new f(a.this.ecj().ooR.HR().aKu.portrait, valueOf, true, a.this.ecj().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener hsX = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof x) && a.this.onJ != null) {
                a.this.onJ.d((x) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bzb = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hrL != null) {
                a.this.hrL.g(z.HJ().HL());
            }
        }
    };
    private CustomMessageListener hsY = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = a.this.onH.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                a.this.Ig(str);
            }
        }
    };
    private CustomMessageListener gPf = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.ecj().pageContext.getPageActivity());
            } else if (a.this.onJ != null) {
                a.this.onJ.d(a.this.ecj().ooR.HR(), false);
            }
        }
    };
    private CustomMessageListener hsZ = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof at) {
                    a.this.hsB = true;
                    a.this.hsC = (at) data;
                    a.this.b(a.this.hsC);
                } else if (data instanceof com.baidu.live.data.a) {
                    a.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener hta = new CustomMessageListener(2501060) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(a.this.ecj().ooR.HR().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(a.this.ecj().ooR.HR().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(a.this.ecj().ooR.HR().mLiveInfo.room_id);
                    String valueOf4 = String.valueOf(a.this.ecj().ooR.HR().aKu.userId);
                    if (a.this.onK == null) {
                        a.this.onK = new com.baidu.tieba.yuyinala.liveroom.n.b();
                    }
                    a.this.onK.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, valueOf4, false, obj);
                    a.this.onK.a(a.this.onZ);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private h.a onZ = new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.3
    };
    private CustomMessageListener htc = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                a.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.5
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
    CustomMessageListener htd = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.hsE = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.onX != null) {
                a.this.onX.If();
            }
        }
    };
    private CustomMessageListener hte = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof dc) {
                if (TextUtils.equals(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()), ((dc) customResponsedMessage.getData()).aVt)) {
                    BdUtilHelper.getCustomToast().showToast(a.this.onH.pageContext.getString(a.h.yuyin_sdk_redpacket_snatch_host_alert), 1);
                } else {
                    a.this.a((dc) customResponsedMessage.getData());
                }
            }
        }
    };
    private CustomMessageListener htf = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.H(a.this.ecj().ooR.HR());
        }
    };
    private CustomMessageListener htk = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (a.this.hrZ != null) {
                    ((com.baidu.tieba.yuyinala.liveroom.m.a) a.this.hrZ).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener htl = new CustomMessageListener(2501031) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                a.this.a(a.this.ecj().ooR.HR(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener htn = new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.20
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.ceq();
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener ooa = new CustomMessageListener(2501034) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinSupportRoomMessage) {
                a.this.a(null, -1, -1, -1);
            }
        }
    };

    protected abstract void a(at atVar);

    protected abstract void b(at atVar);

    protected abstract ViewGroup cdB();

    protected abstract void cdo();

    protected abstract View cdy();

    public abstract boolean cdz();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(br brVar) {
        this.hso = brVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hsw = (RelativeLayout) ecj().ooS.findViewById(a.f.ala_live_header_view);
        this.hsx = (RelativeLayout) ecj().ooS.findViewById(a.f.ala_live_footer_view);
        II();
        registerListener();
    }

    public void cdG() {
    }

    private void II() {
        if (this.onJ == null) {
            this.onJ = new com.baidu.tieba.yuyinala.liveroom.share.a(ecj().pageContext);
        }
        this.onO = new com.baidu.tieba.yuyinala.liveroom.b.a(ecj().pageContext, false);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            if (!TbadkCoreApplication.getInst().isHaokan() || !subappVersionName.startsWith("4.14.")) {
            }
            if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && subappVersionName.startsWith("1.14.")) {
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            }
        }
        this.onM = new com.baidu.tieba.yuyinala.liveroom.tippop.a(ecj().pageContext, this);
        cdJ();
        cdM();
        cdT();
        cdU();
        cdN();
    }

    private void cdT() {
        this.onP = new com.baidu.tieba.yuyinala.liveroom.turntable.b(ecj().pageContext.getPageActivity());
    }

    private void cdJ() {
        this.hrK = new m();
    }

    public void nH(boolean z) {
        this.hsz = z;
    }

    private void cdM() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501037, e.class, ecj().pageContext);
        if (runTask != null && runTask.getData() != null) {
            try {
                this.onN = (e) runTask.getData();
                this.onN.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.13
                    @Override // com.baidu.live.view.input.e.a
                    public void ZZ() {
                        a.this.wJ(11);
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public void aaa() {
                        a.this.fg(11);
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public boolean ME() {
                        return a.this.KE();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public boolean Nt() {
                        return a.this.cdQ();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public int MK() {
                        return a.this.cdR();
                    }
                });
                this.onW = new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.14
                    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<Integer> run(CustomMessage<Integer> customMessage) {
                        return new CustomResponsedMessage<>(2501083, Integer.valueOf(a.this.hrL != null ? a.this.hrL.getImMsgListViewHeight() : 0));
                    }
                };
                this.onV = new CustomMessageTask(2501083, this.onW);
                this.onV.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                MessageManager.getInstance().registerTask(this.onV);
            } catch (Exception e) {
            }
        }
    }

    void nI(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cdQ() {
        x HR;
        if (ecj() == null || ecj().ooR == null || (HR = ecj().ooR.HR()) == null || HR.aKQ == null) {
            return false;
        }
        String str = HR.aKQ.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int cdR() {
        x HR;
        if (ecj() != null && ecj().ooR != null && (HR = ecj().ooR.HR()) != null && !ListUtils.isEmpty(HR.aLb)) {
            for (AlaLiveMarkData alaLiveMarkData : HR.aLb) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void cdU() {
        this.onS = new com.baidu.tieba.yuyinala.liveroom.m.b(ecj().pageContext.getPageActivity());
    }

    private void cdN() {
        this.onX = new com.baidu.tieba.yuyinala.liveroom.h.b(this.onH.pageContext);
        this.onX.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.15
            @Override // com.baidu.tieba.yuyinala.liveroom.h.b.a
            public boolean ceJ() {
                x HR;
                if (a.this.ecj() == null || a.this.ecj().ooR == null || (HR = a.this.ecj().ooR.HR()) == null || HR.aLl == null) {
                    return false;
                }
                return HR.aLl.is_followed;
            }
        });
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.hsZ);
        MessageManager.getInstance().registerListener(this.ooa);
        MessageManager.getInstance().registerListener(this.hta);
        MessageManager.getInstance().registerListener(this.htc);
        MessageManager.getInstance().registerListener(this.hsW);
        MessageManager.getInstance().registerListener(this.hsX);
        MessageManager.getInstance().registerListener(this.gPf);
        MessageManager.getInstance().registerListener(this.hsY);
        MessageManager.getInstance().registerListener(this.gPs);
        MessageManager.getInstance().registerListener(this.htd);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.bzb);
        MessageManager.getInstance().registerListener(this.hte);
        MessageManager.getInstance().registerListener(this.htf);
        MessageManager.getInstance().registerListener(this.htk);
        MessageManager.getInstance().registerListener(this.htl);
        MessageManager.getInstance().registerListener(this.hsT);
        MessageManager.getInstance().registerListener(this.hsU);
        MessageManager.getInstance().registerListener(this.hsV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean KE() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(ecj().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ig(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ecj().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(ecj().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.16
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.af.a.SE().bwi.aOv;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = ecj().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = ecj().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.17
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(a.this.ecj().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(ecj().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdW() {
        if (this.hrL != null && this.onN != null) {
            this.hrL.MB().a(this.onN.RH(), z.HJ().HL(), ecj().ooR.HR().mLiveInfo);
            nI(true);
            if (this.hsd == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501042, af.class, ecj().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hsd = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsd.hk("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.onY == null) {
            this.onY = new com.baidu.tieba.yuyinala.liveroom.e.a(ecj().pageContext);
            this.onY.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.onY.a(ecj().ooR.HR(), alaLastLiveroomInfo);
        this.onY.aF(this.hsx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdZ() {
        if (this.hrL != null) {
            this.hrL.MB().hide();
            nI(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String[] strArr, int i, int i2, int i3) {
        if (ecj().ooR.HR() != null && ecj().ooR.HR().aKu != null && ecj().ooR.HR().mLiveInfo != null) {
            a(ecj().ooR.HR(), strArr, i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, String[] strArr, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(ac.class) != null && KE()) {
            if (xVar == null) {
                xVar = ecj().ooR.HR();
            }
            String valueOf = String.valueOf(xVar.aKu.userId);
            String str = xVar.aKu.userName;
            String valueOf2 = String.valueOf(xVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(xVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(xVar.mLiveInfo.feed_id);
            int i6 = xVar.aKQ.isBlock;
            String Ia = aj.Ia();
            String str2 = xVar.mLiveInfo.appId;
            boolean z2 = xVar.aKQ.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (xVar.mLiveInfo.live_type == 1 && xVar.mLiveInfo.screen_direction == 1 && com.baidu.live.af.a.SE().bwi.aNw) {
                z3 = true;
            }
            int i7 = -1;
            if (xVar.aKQ == null) {
                z = false;
            } else {
                boolean z4 = xVar.aKQ.isNewUser;
                i7 = xVar.aKQ.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.hsD != null && this.hsD.bkF != null && this.hsD.bkF.anchorId == xVar.aKu.userId) {
                z5 = this.hsD.bkK;
            }
            ac acVar = new ac(ecj().pageContext.getPageActivity(), strArr, valueOf, str, valueOf2, valueOf3, i6, Ia, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.mAlaLiveSwitchData != null) {
                acVar.bk(xVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            acVar.bi(z);
            if (com.baidu.tieba.yuyinala.liveroom.p.b.edp().bwr != null) {
                acVar.bj(com.baidu.tieba.yuyinala.liveroom.p.b.edp().bwr.aMl != 1);
            }
            bi LA = g.Ly().LA();
            if (LA == null || LA.aQY <= 0) {
                i5 = 1000;
            } else {
                i5 = LA.aQY;
            }
            acVar.dS(i5);
            boolean z6 = false;
            if (xVar != null && xVar.aKQ != null) {
                String str3 = xVar.aKQ.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            acVar.bl(z6);
            boolean z7 = true;
            bq bqVar = com.baidu.live.af.a.SE().bCb;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bqVar != null && bqVar.aRE != null && (!bqVar.aRE.aUl || !bqVar.aRE.aUm || !bqVar.aRE.aUn)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            acVar.bm(z7);
            if (xVar != null && xVar.aKT != null) {
                acVar.ga(xVar.aKT.toJsonString());
            }
            if (!this.hsI) {
                this.hsJ = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, acVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cea() {
        fg(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(dc dcVar) {
        if (dcVar != null && KE()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.aj(ecj().pageContext.getPageActivity(), dcVar.aSC, dcVar.liveId, dcVar.aVt, dcVar.roomId, dcVar.time)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && com.baidu.live.af.a.SE().bwi != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(ecj().pageContext.getPageActivity(), String.valueOf(xVar.mLiveInfo.live_id), String.valueOf(xVar.mLiveInfo.user_id), com.baidu.live.af.a.SE().bwi.aPa, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, NobleDetailInfo nobleDetailInfo) {
        if (KE() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (xVar != null) {
                if (xVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(xVar.mLiveInfo.live_id));
                }
                if (xVar.aKu != null) {
                    hashMap.put("anchor_id", Long.valueOf(xVar.aKu.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", t.Ia());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put(Config.TRACE_VISIT_RECENT_DAY, Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(ecj().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ceb() {
        if (this.onN != null) {
            this.onN.d(this.onH.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cec() {
        x HR = ecj().ooR.HR();
        LogManager.getCommonLogger().doClickQuickImHiLog((HR == null || HR.mLiveInfo == null) ? "" : HR.mLiveInfo.feed_id, NL());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ih(String str) {
        if (this.onN != null) {
            this.onN.hn(str);
        }
    }

    private void ced() {
        if ("home_rec_play".equals(ecj().fromType) || "frs_play".equals(ecj().fromType) || "frs_live_play".equals(ecj().fromType) || "person_play".equals(ecj().fromType) || "search".equals(ecj().fromType) || "person_attention".equals(ecj().fromType)) {
            com.baidu.live.c.AZ().aZ(true);
        } else {
            com.baidu.live.c.AZ().aZ(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nJ(boolean z) {
        View Hn;
        if (this.hrN == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aWW = false;
            fVar.context = ecj().pageContext.getPageActivity();
            fVar.aXg = z;
            fVar.fromType = ecj().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501040, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrN = (ad) runTask.getData();
            }
        }
        if (this.hrN != null && (Hn = this.hrN.Hn()) != null && this.onH.ooS.indexOfChild(Hn) < 0) {
            u.a(ecj().ooS, Hn, new RelativeLayout.LayoutParams(-1, -1), 250);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cee() {
        View Ie;
        if (this.hrZ == null) {
            com.baidu.live.gift.ak akVar = new com.baidu.live.gift.ak();
            akVar.aWW = false;
            akVar.pageContext = ecj().pageContext;
            akVar.fromType = ecj().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501065, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrZ = (ag) runTask.getData();
            }
        }
        if (this.hrZ != null && (Ie = this.hrZ.Ie()) != null && ecj().ooS.indexOfChild(Ie) < 0) {
            if (Ie.getParent() instanceof ViewGroup) {
                ((ViewGroup) Ie.getParent()).removeView(Ie);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = ecj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            u.a(ecj().ooS, Ie, layoutParams, 550);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cef() {
        View HQ;
        if (this.hrO == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aWW = false;
            aVar.context = ecj().pageContext.getPageActivity();
            aVar.fromType = ecj().fromType;
            aVar.aWX = ecj().hBV;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501041, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrO = (ab) runTask.getData();
            }
        }
        if (this.hrO != null && (HQ = this.hrO.HQ()) != null && ecj().ooS.indexOfChild(HQ) < 0) {
            if (HQ.getParent() instanceof ViewGroup) {
                ((ViewGroup) HQ.getParent()).removeView(HQ);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = (BdUtilHelper.getDimens(ecj().pageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(ecj().pageContext.getPageActivity(), a.d.sdk_ds12) : 0)) + BdUtilHelper.getDimens(ecj().pageContext.getPageActivity(), a.d.sdk_ds152) + (ecj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18) * (-1));
            u.a(ecj().ooS, HQ, layoutParams, 300);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ceg() {
        CustomResponsedMessage runTask;
        if (this.hrM == null && (runTask = MessageManager.getInstance().runTask(2501052, com.baidu.live.im.b.a.class, ecj().pageContext)) != null) {
            this.hrM = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hrM != null) {
            this.hrM.setOtherParams(this.otherParams);
            this.hrM.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.18
                @Override // com.baidu.live.im.b.a.InterfaceC0186a
                public void Nj() {
                    a.this.ceq();
                }
            });
            this.hrM.a(ecj().ooR.HR(), false);
            View Da = this.hrM.Da();
            if (Da != null && this.hsx.indexOfChild(Da) < 0) {
                Resources resources = ecj().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(ecj().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.hsx.addView(Da, layoutParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501053));
        }
    }

    private void ceh() {
        if (this.onL == null) {
            this.onL = new com.baidu.tieba.yuyinala.liveroom.f.a(ecj().pageContext);
        }
        if (this.hsC != null) {
            this.onL.In(this.hsC.user_id);
        }
        this.onL.aF(null);
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
                    if (this.bsW != null) {
                        this.bsW.cz(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        wL(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            ecj().ooR.HR().aKQ.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            ecj().ooR.HR().aKQ.isAdmin = 0;
                            ecj().ooR.cml();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        ecj().ooR.HR().aKQ.isAdmin = 0;
                        ecj().ooR.cml();
                    }
                } else if ("task".equals(optString2)) {
                    dT(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.onM != null && !ecj().hBU) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = ecj().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = ecj().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = ecj().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bYP()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.onM.c(ecj().hBO.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    if (ecj().ooR.HR() != null && ecj().ooR.HR().mLiveInfo != null) {
                        ecj().ooR.a(ecj().ooR.HR().mLiveInfo.live_id, ecj().fromType, ecj().enterTime);
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.yuyinala.liveroom.o.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (ecj().ooR.HR() != null && ecj().ooR.HR().aKQ != null && ecj().ooR.HR().aKQ.userId == optLong2) {
                        ecj().ooR.HR().aKQ.isBlock = 1;
                        cdo();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (ecj().ooR.HR() != null && ecj().ooR.HR().aKQ != null && ecj().ooR.HR().aKQ.userId == optLong3) {
                        ecj().ooR.HR().aKQ.isBlock = 0;
                        cdo();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (ecj().ooR.HR() != null && ecj().ooR.HR().aKQ != null && ecj().ooR.HR().aKQ.userId == optLong4) {
                        ecj().ooR.HR().aKQ.isUegBlock = 1;
                        cdo();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (ecj().ooR.HR() != null && ecj().ooR.HR().aKQ != null && ecj().ooR.HR().aKQ.userId == optLong5) {
                        ecj().ooR.HR().aKQ.isUegBlock = 0;
                        cdo();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (ecj() != null && ecj().ooR != null && ecj().ooR.HR() != null && ecj().ooR.HR().aKQ != null) {
                        if (ecj().ooR.HR().aKQ.userId == jSONObject2.optLong("user_id")) {
                            ecj().ooR.cml();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, ecj().ooR.HR().aKQ));
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
                    com.baidu.live.data.a Nw = bVar.Nw();
                    if (Nw != null && aj.hg(str3)) {
                        aj.d(str3, 1L, "", "", Nw.userId, Nw.portrait, Nw.userName, "", "", false, "", "", "", false, false, true, -1L, bVar.boI);
                    }
                } else if ("challenge_mvp".equals(optString2)) {
                    if (jSONObject2 != null) {
                        bd bdVar = new bd();
                        bdVar.parseJson(jSONObject2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, bdVar));
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
                    com.baidu.tieba.yuyinala.liveroom.j.c.a(ecj(), bVar, jSONObject2);
                }
            }
        } else if (bVar.getMsgType() != 125 && bVar.getMsgType() == 24) {
            com.baidu.tieba.yuyinala.liveroom.j.c.b(ecj(), bVar, jSONObject2, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.19
                @Override // com.baidu.tieba.yuyinala.liveroom.j.c.a
                public void VP(String str4) {
                    a.this.Ic(str4);
                }
            });
        }
    }

    protected void Ic(String str) {
    }

    void ceq() {
        if (cer() && this.hrL != null) {
            if (!this.hrL.MB().Ov()) {
                this.hrL.MB().hide();
            }
            BdUtilHelper.hideSoftKeyPad(ecj().pageContext.getPageActivity(), ecj().hBO.getLiveContainerView());
            cdz();
        }
    }

    private boolean cer() {
        if (cdy() == null || cdy().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(x xVar) {
        CustomResponsedMessage runTask;
        ecj().ooS.setOnTouchListener(this.htn);
        ceB();
        ceh();
        if (this.hrK != null) {
            this.hrK.h(ecj().ooR.HR());
        }
        if (this.onN != null) {
            this.onN.b(ecj().ooR.HR(), NL());
        }
        if (this.onX != null) {
            this.onX.f(ecj().ooR.HR());
        }
        if (ecj().ooS != null) {
            ecj().ooS.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.21
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    return a.this.Q(motionEvent);
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Pz() {
                    if (a.this.hsO == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : a.this.hsO) {
                        if (bVar.Pz()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            ecj().ooS.setLiveViewOnTouchEventListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.22
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return a.this.P(motionEvent);
                }
            });
        }
        if (this.hsd == null && (runTask = MessageManager.getInstance().runTask(2501042, af.class, ecj().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hsd = (af) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cet() {
        x HR;
        ViewGroup viewGroup;
        if (ecj() != null && ecj().ooR != null && (HR = ecj().ooR.HR()) != null && HR.mLiveInfo != null && HR.aLs && (viewGroup = (ViewGroup) ecj().hBO) != null) {
            if (this.onU == null) {
                this.onU = new com.baidu.tieba.yuyinala.liveroom.recommend.a(ecj().pageContext);
            }
            this.onU.o(HR);
            this.onU.a(ecj().ooS);
            this.onU.aF(viewGroup);
            a((d) this.onU);
            a((com.baidu.live.liveroom.g.b) this.onU);
        }
    }

    protected void a(d dVar) {
        if (this.hsN == null) {
            this.hsN = new ArrayList();
        }
        if (!this.hsN.contains(dVar)) {
            this.hsN.add(dVar);
        }
    }

    protected void b(d dVar) {
        if (this.hsN != null && this.hsN.contains(dVar)) {
            this.hsN.remove(dVar);
        }
    }

    protected void ceu() {
        if (this.hsN != null) {
            this.hsN.clear();
            this.hsN = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hsN == null) {
            return false;
        }
        Iterator<d> it = this.hsN.iterator();
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
        if (this.hsO == null) {
            this.hsO = new ArrayList();
        }
        if (!this.hsO.contains(bVar)) {
            this.hsO.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hsO != null && this.hsO.contains(bVar)) {
            this.hsO.remove(bVar);
        }
    }

    protected void cev() {
        if (this.hsO != null) {
            this.hsO.clear();
            this.hsO = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hsO == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hsO.iterator();
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
    public void cew() {
        if (this.onT == null && this.hso != null && this.hso.aRO && ecj() != null && ecj().ooR != null && ecj().ooR.HR() != null) {
            this.onT = new com.baidu.tieba.yuyinala.liveroom.f.c(ecj().pageContext, this.hso);
            this.onT.J(ecj().ooR.HR());
            if (this.hso.aRR == 1) {
                if (this.hrL != null) {
                    this.hsF = true;
                }
            } else if (this.hso.aRR == 2) {
                a(ecj().ooR.HR(), null, -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cex() {
        CustomResponsedMessage runTask;
        if (ecj() != null && (runTask = MessageManager.getInstance().runTask(2501047, k.class, ecj().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.ab.a)) {
            this.hsp = (com.baidu.live.ab.a) runTask.getData();
            this.hsp.s(cdB());
            if (ecj().ooR != null) {
                this.hsG = this.hsp.p(ecj().ooR.HR());
            }
            this.hsp.setCanVisible(!this.hsA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(boolean z, boolean z2) {
        Rect rect = new Rect();
        ecj().hBO.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(ecj().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(ecj().pageContext.getPageActivity(), 48.0f) : 0);
        int keyboardHeight = dip2px == 0 ? TbadkCoreApplication.getInst().getKeyboardHeight() : dip2px;
        int dimensionPixelOffset = z2 ? ecj().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + keyboardHeight + ecj().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? ecj().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds192) : 0) + ecj().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds32);
    }

    private void ceB() {
        if (this.hrH == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ai.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.hrH = (com.baidu.live.ai.a) runTask.getData();
            }
            ceC();
        }
    }

    private void dT(JSONObject jSONObject) {
        if (this.hrH != null) {
            this.hrH.cY(true);
            this.hrH.Z(jSONObject);
        }
    }

    private void ceC() {
        if (this.hrH != null && ecj().ooR.HR() != null && ecj().ooR.HR().aLf != null) {
            this.hrH.cY(true);
            this.hrH.j(ecj().ooR.HR());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(x xVar) {
        if (xVar != null) {
            ceC();
            if (this.onL != null && xVar.aKu != null) {
                this.onL.In(String.valueOf(xVar.aKu.userId));
            }
            if (this.hrO != null && xVar.mLiveInfo != null) {
                this.hrO.a(xVar.mLiveInfo, xVar.aKu);
            }
            if (this.hrM != null) {
                this.hrM.a(xVar);
            }
            if (this.hsp != null) {
                this.hsG = this.hsp.p(xVar);
            }
            wL(xVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void wL(int i) {
        if (!ecj().hBU) {
            if (this.hsy < 0 && i == 0) {
                this.hsy = i;
            } else if (this.hsy != i) {
                if (i == 1) {
                    if (!this.onM.xA(2)) {
                        String string = ecj().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(ecj().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.onM.a(ecj().hBO.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = ecj().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.onM.xB(2);
                    this.onM.xB(3);
                    if (bYP()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.onM.c(ecj().hBO.getLiveContainerView(), string2, 3);
                    }
                }
                this.hsy = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cC(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.cC(z);
        if (z) {
            ceD();
        }
        if (this.onJ != null) {
            this.onJ.DC();
        }
        if (this.hrH != null) {
            this.hrH.onDestroy();
            this.hrH = null;
        }
        if (this.onX != null) {
            this.onX.onDestroy();
        }
        if (this.hrN != null) {
            View Hn = this.hrN.Hn();
            if (Hn != null && Hn.getParent() != null) {
                ((ViewGroup) Hn.getParent()).removeView(Hn);
            }
            this.hrN.onDestroy();
            this.hrN = null;
        }
        if (this.hrM != null) {
            this.hrM.a((a.InterfaceC0186a) null);
            this.hrM.Dc();
        }
        if (this.onM != null) {
            this.onM.DC();
        }
        this.hsy = -1;
        if (this.onL != null) {
            this.onL.DC();
            this.onL.onDestroy();
        }
        if (this.onO != null) {
            this.onO.ccK();
            this.onO.Id();
        }
        if (this.hrK != null) {
            this.hrK.Id();
        }
        if (this.onN != null) {
            this.onN.Id();
        }
        if (this.onT != null) {
            this.onT.onDestroy();
        }
        if (this.hsd != null) {
            this.hsd.Id();
        }
        if (this.onK != null) {
            this.onK.onDestory();
        }
        if (this.hsp != null) {
            this.hsp.Id();
        }
        if (this.onS != null) {
            this.onS.Id();
        }
        if (this.hrZ != null) {
            this.hrZ.onDestroy();
        }
        if (this.onU != null) {
            this.onU.DC();
            b((d) this.onU);
            b((com.baidu.live.liveroom.g.b) this.onU);
        }
        ShowUtil.windowCount = 0;
        ceu();
        cev();
    }

    private void ceD() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = ecj().ooS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = ecj().ooS.getChildAt(i);
            if (childAt != this.hsw && childAt != this.hsx) {
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
        if (this.hsw != null) {
            this.hsw.removeAllViews();
        }
        if (this.hsx != null) {
            this.hsx.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, x xVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(x xVar) {
        View Da;
        View Hn;
        if (this.hrN != null && (Hn = this.hrN.Hn()) != null && Hn.getParent() != null) {
            ((ViewGroup) Hn.getParent()).removeView(Hn);
        }
        if (this.hrM != null && (Da = this.hrM.Da()) != null && Da.getParent() != null) {
            ((ViewGroup) Da.getParent()).removeView(Da);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean Pv() {
        ced();
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cA(boolean z) {
        super.cA(z);
        if (this.hrH != null) {
            this.hrH.onDestroy();
            this.hrH = null;
        }
        if (this.hrN != null) {
            this.hrN.onDestroy();
            this.hrN = null;
        }
        if (this.hrO != null) {
            this.hrO.onDestroy();
            this.hrO = null;
        }
        if (this.onM != null) {
            this.onM.onDestroy();
        }
        if (this.onJ != null) {
            this.onJ.onDestroy();
        }
        if (this.hrZ != null) {
            this.hrZ.onDestroy();
            this.hrZ = null;
        }
        if (this.hrM != null) {
            this.hrM.a((a.InterfaceC0186a) null);
            this.hrM.release();
            this.hrM = null;
        }
        if (this.onN != null) {
            this.onN.a(null);
            this.onN.release();
        }
        if (this.onT != null) {
            this.onT.onDestroy();
        }
        if (this.onS != null) {
            this.onS.release();
        }
        if (this.hsd != null) {
            this.hsd.release();
        }
        if (this.onK != null) {
            this.onK.onDestory();
        }
        if (this.hsp != null) {
            this.hsp.release();
        }
        if (this.onX != null) {
            this.onX.a((b.a) null);
            this.onX.onDestroy();
        }
        if (this.onU != null) {
            this.onU.onDestroy();
            b((d) this.onU);
            b((com.baidu.live.liveroom.g.b) this.onU);
        }
        ceu();
        cev();
        MessageManager.getInstance().unRegisterListener(this.hsT);
        MessageManager.getInstance().unRegisterListener(this.hsU);
        MessageManager.getInstance().unRegisterListener(this.hsV);
        MessageManager.getInstance().unRegisterListener(this.hsZ);
        MessageManager.getInstance().unRegisterListener(this.hta);
        MessageManager.getInstance().unRegisterListener(this.ooa);
        MessageManager.getInstance().unRegisterListener(this.htc);
        MessageManager.getInstance().unRegisterListener(this.hsW);
        MessageManager.getInstance().unRegisterListener(this.hsX);
        MessageManager.getInstance().unRegisterListener(this.gPf);
        MessageManager.getInstance().unRegisterListener(this.hsY);
        MessageManager.getInstance().unRegisterListener(this.gPs);
        MessageManager.getInstance().unRegisterListener(this.htd);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.bzb);
        MessageManager.getInstance().unRegisterListener(this.hte);
        MessageManager.getInstance().unRegisterListener(this.htf);
        MessageManager.getInstance().unRegisterListener(this.htk);
        MessageManager.getInstance().unRegisterListener(this.htl);
        MessageManager.getInstance().unRegisterTask(2501083);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        cdz();
        if (this.onS != null) {
            this.onS.pause();
        }
        if (this.hrZ != null) {
            this.hrZ.onPause();
        }
        if (this.onX != null) {
            this.onX.ok(false);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.hsJ = false;
        if (this.hsB && this.hsC != null) {
            a(this.hsC);
            this.hsB = false;
        }
        if (this.onS != null) {
            this.onS.resume();
        }
        if (this.hrZ != null) {
            this.hrZ.onResume();
        }
        if (this.onX != null) {
            this.onX.ok(true);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azJ() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.onU != null && this.onU.isOpen()) {
            this.onU.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            azJ();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    a(null, -1, -1, -1);
                    return;
                }
                return;
            }
            azJ();
        } else if (i == 25034) {
            cea();
        } else if (i == 25043 && i2 == -1) {
            ceG();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void e(boolean z, int i) {
        this.hsA = z;
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
        if (this.onK != null) {
            this.onK.bnO();
        }
        if (this.onU != null) {
            this.onU.C(i, i3);
        }
        if (this.onX != null) {
            this.onX.bnO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        this.onH = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.yuyinala.liveroom.data.a ecj() {
        return this.onH;
    }

    private void ceG() {
        String Lz = g.Ly().Lz();
        if (!TextUtils.isEmpty(Lz)) {
            try {
                a(null, -1, Integer.parseInt(Lz), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                a(null, -1, -1, -1);
            }
        }
    }

    @Override // com.baidu.live.liveroom.a.a
    public boolean ff(int i) {
        if (1 == i) {
            if (cdy() != null) {
                cdy().setVisibility(8);
                return true;
            }
            return true;
        } else if (2 == i) {
            return !this.hsA;
        } else if (3 == i) {
            if (ecj().ooS == null) {
                return false;
            }
            ecj().ooS.setEnabled(false);
            if (this.bsW != null) {
                this.bsW.e(!ecj().hBS, false);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    public void wJ(int i) {
    }

    @Override // com.baidu.live.liveroom.a.a
    public void fg(int i) {
        if (3 == i) {
            ecj().ooS.setEnabled(true);
            if (this.bsW != null) {
                this.bsW.e(!ecj().hBS, true);
            }
            if (this.hrH != null) {
                this.hrH.cY(true);
                return;
            }
            return;
        }
        if (2 == i) {
        }
    }

    public String NL() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.hrM != null) {
            this.hrM.setOtherParams(str);
        }
    }

    private boolean bYP() {
        return ecj().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gtp = alaLastLiveroomInfo;
    }
}
