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
    private com.baidu.tieba.yuyinala.liveroom.data.a onG;
    protected com.baidu.tieba.yuyinala.liveroom.operation.a onH;
    protected com.baidu.tieba.yuyinala.liveroom.share.a onI;
    protected com.baidu.tieba.yuyinala.liveroom.n.b onJ;
    private com.baidu.tieba.yuyinala.liveroom.f.a onK;
    protected com.baidu.tieba.yuyinala.liveroom.tippop.a onL;
    protected e onM;
    protected com.baidu.tieba.yuyinala.liveroom.b.a onN;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.b onO;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.lucky.a onP;
    protected com.baidu.tieba.yuyinala.liveroom.m.b onR;
    protected com.baidu.tieba.yuyinala.liveroom.f.c onS;
    protected com.baidu.tieba.yuyinala.liveroom.recommend.a onT;
    private CustomMessageTask onU;
    private CustomMessageTask.CustomRunnable<Integer> onV;
    com.baidu.tieba.yuyinala.liveroom.h.b onW;
    protected com.baidu.tieba.yuyinala.liveroom.e.a onX;
    protected String otherParams;
    private int onQ = 0;
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
            a.this.ceb();
        }
    };
    private CustomMessageListener hsW = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(a.this.eck().ooQ.HR().aKu.userId);
            com.baidu.live.view.a.Zy().a(valueOf, new f(a.this.eck().ooQ.HR().aKu.portrait, valueOf, true, a.this.eck().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener hsX = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof x) && a.this.onI != null) {
                a.this.onI.d((x) customResponsedMessage.getData(), false);
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
                    str = a.this.onG.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                a.this.If(str);
            }
        }
    };
    private CustomMessageListener gPf = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.eck().pageContext.getPageActivity());
            } else if (a.this.onI != null) {
                a.this.onI.d(a.this.eck().ooQ.HR(), false);
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
                    String valueOf = String.valueOf(a.this.eck().ooQ.HR().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(a.this.eck().ooQ.HR().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(a.this.eck().ooQ.HR().mLiveInfo.room_id);
                    String valueOf4 = String.valueOf(a.this.eck().ooQ.HR().aKu.userId);
                    if (a.this.onJ == null) {
                        a.this.onJ = new com.baidu.tieba.yuyinala.liveroom.n.b();
                    }
                    a.this.onJ.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, valueOf4, false, obj);
                    a.this.onJ.a(a.this.onY);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private h.a onY = new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.3
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
            if (a.this.onW != null) {
                a.this.onW.If();
            }
        }
    };
    private CustomMessageListener hte = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof dc) {
                if (TextUtils.equals(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()), ((dc) customResponsedMessage.getData()).aVt)) {
                    BdUtilHelper.getCustomToast().showToast(a.this.onG.pageContext.getString(a.h.yuyin_sdk_redpacket_snatch_host_alert), 1);
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
            a.this.H(a.this.eck().ooQ.HR());
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
                a.this.a(a.this.eck().ooQ.HR(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener htn = new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.20
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.cer();
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener onZ = new CustomMessageListener(2501034) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.24
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

    public abstract boolean cdA();

    protected abstract ViewGroup cdC();

    protected abstract void cdp();

    protected abstract View cdz();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(br brVar) {
        this.hso = brVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hsw = (RelativeLayout) eck().ooR.findViewById(a.f.ala_live_header_view);
        this.hsx = (RelativeLayout) eck().ooR.findViewById(a.f.ala_live_footer_view);
        II();
        registerListener();
    }

    public void cdH() {
    }

    private void II() {
        if (this.onI == null) {
            this.onI = new com.baidu.tieba.yuyinala.liveroom.share.a(eck().pageContext);
        }
        this.onN = new com.baidu.tieba.yuyinala.liveroom.b.a(eck().pageContext, false);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            if (!TbadkCoreApplication.getInst().isHaokan() || !subappVersionName.startsWith("4.14.")) {
            }
            if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && subappVersionName.startsWith("1.14.")) {
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            }
        }
        this.onL = new com.baidu.tieba.yuyinala.liveroom.tippop.a(eck().pageContext, this);
        cdK();
        cdN();
        cdU();
        cdV();
        cdO();
    }

    private void cdU() {
        this.onO = new com.baidu.tieba.yuyinala.liveroom.turntable.b(eck().pageContext.getPageActivity());
    }

    private void cdK() {
        this.hrK = new m();
    }

    public void nH(boolean z) {
        this.hsz = z;
    }

    private void cdN() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501037, e.class, eck().pageContext);
        if (runTask != null && runTask.getData() != null) {
            try {
                this.onM = (e) runTask.getData();
                this.onM.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.13
                    @Override // com.baidu.live.view.input.e.a
                    public void aaa() {
                        a.this.wJ(11);
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public void aab() {
                        a.this.fg(11);
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public boolean ME() {
                        return a.this.KE();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public boolean Nt() {
                        return a.this.cdR();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public int MK() {
                        return a.this.cdS();
                    }
                });
                this.onV = new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.14
                    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<Integer> run(CustomMessage<Integer> customMessage) {
                        return new CustomResponsedMessage<>(2501083, Integer.valueOf(a.this.hrL != null ? a.this.hrL.getImMsgListViewHeight() : 0));
                    }
                };
                this.onU = new CustomMessageTask(2501083, this.onV);
                this.onU.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                MessageManager.getInstance().registerTask(this.onU);
            } catch (Exception e) {
            }
        }
    }

    void nI(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cdR() {
        x HR;
        if (eck() == null || eck().ooQ == null || (HR = eck().ooQ.HR()) == null || HR.aKQ == null) {
            return false;
        }
        String str = HR.aKQ.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int cdS() {
        x HR;
        if (eck() != null && eck().ooQ != null && (HR = eck().ooQ.HR()) != null && !ListUtils.isEmpty(HR.aLb)) {
            for (AlaLiveMarkData alaLiveMarkData : HR.aLb) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void cdV() {
        this.onR = new com.baidu.tieba.yuyinala.liveroom.m.b(eck().pageContext.getPageActivity());
    }

    private void cdO() {
        this.onW = new com.baidu.tieba.yuyinala.liveroom.h.b(this.onG.pageContext);
        this.onW.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.15
            @Override // com.baidu.tieba.yuyinala.liveroom.h.b.a
            public boolean ceK() {
                x HR;
                if (a.this.eck() == null || a.this.eck().ooQ == null || (HR = a.this.eck().ooQ.HR()) == null || HR.aLl == null) {
                    return false;
                }
                return HR.aLl.is_followed;
            }
        });
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.hsZ);
        MessageManager.getInstance().registerListener(this.onZ);
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
        ViewHelper.skipToLoginActivity(eck().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(eck().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(eck().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.16
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.af.a.SE().bwi.aOv;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = eck().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = eck().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.17
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(a.this.eck().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(eck().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdX() {
        if (this.hrL != null && this.onM != null) {
            this.hrL.MB().a(this.onM.RH(), z.HJ().HL(), eck().ooQ.HR().mLiveInfo);
            nI(true);
            if (this.hsd == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501042, af.class, eck().pageContext.getPageActivity());
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
        if (this.onX == null) {
            this.onX = new com.baidu.tieba.yuyinala.liveroom.e.a(eck().pageContext);
            this.onX.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.onX.a(eck().ooQ.HR(), alaLastLiveroomInfo);
        this.onX.aF(this.hsx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cea() {
        if (this.hrL != null) {
            this.hrL.MB().hide();
            nI(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String[] strArr, int i, int i2, int i3) {
        if (eck().ooQ.HR() != null && eck().ooQ.HR().aKu != null && eck().ooQ.HR().mLiveInfo != null) {
            a(eck().ooQ.HR(), strArr, i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, String[] strArr, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(ac.class) != null && KE()) {
            if (xVar == null) {
                xVar = eck().ooQ.HR();
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
            ac acVar = new ac(eck().pageContext.getPageActivity(), strArr, valueOf, str, valueOf2, valueOf3, i6, Ia, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.mAlaLiveSwitchData != null) {
                acVar.bk(xVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            acVar.bi(z);
            if (com.baidu.tieba.yuyinala.liveroom.p.b.edq().bwr != null) {
                acVar.bj(com.baidu.tieba.yuyinala.liveroom.p.b.edq().bwr.aMl != 1);
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
    public void ceb() {
        fg(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(dc dcVar) {
        if (dcVar != null && KE()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.aj(eck().pageContext.getPageActivity(), dcVar.aSC, dcVar.liveId, dcVar.aVt, dcVar.roomId, dcVar.time)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && com.baidu.live.af.a.SE().bwi != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(eck().pageContext.getPageActivity(), String.valueOf(xVar.mLiveInfo.live_id), String.valueOf(xVar.mLiveInfo.user_id), com.baidu.live.af.a.SE().bwi.aPa, 1, false)));
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(eck().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cec() {
        if (this.onM != null) {
            this.onM.d(this.onG.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ced() {
        x HR = eck().ooQ.HR();
        LogManager.getCommonLogger().doClickQuickImHiLog((HR == null || HR.mLiveInfo == null) ? "" : HR.mLiveInfo.feed_id, NL());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ig(String str) {
        if (this.onM != null) {
            this.onM.hn(str);
        }
    }

    private void cee() {
        if ("home_rec_play".equals(eck().fromType) || "frs_play".equals(eck().fromType) || "frs_live_play".equals(eck().fromType) || "person_play".equals(eck().fromType) || "search".equals(eck().fromType) || "person_attention".equals(eck().fromType)) {
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
            fVar.context = eck().pageContext.getPageActivity();
            fVar.aXg = z;
            fVar.fromType = eck().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501040, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrN = (ad) runTask.getData();
            }
        }
        if (this.hrN != null && (Hn = this.hrN.Hn()) != null && this.onG.ooR.indexOfChild(Hn) < 0) {
            u.a(eck().ooR, Hn, new RelativeLayout.LayoutParams(-1, -1), 250);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cef() {
        View Ie;
        if (this.hrZ == null) {
            com.baidu.live.gift.ak akVar = new com.baidu.live.gift.ak();
            akVar.aWW = false;
            akVar.pageContext = eck().pageContext;
            akVar.fromType = eck().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501065, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrZ = (ag) runTask.getData();
            }
        }
        if (this.hrZ != null && (Ie = this.hrZ.Ie()) != null && eck().ooR.indexOfChild(Ie) < 0) {
            if (Ie.getParent() instanceof ViewGroup) {
                ((ViewGroup) Ie.getParent()).removeView(Ie);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = eck().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            u.a(eck().ooR, Ie, layoutParams, 550);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ceg() {
        View HQ;
        if (this.hrO == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aWW = false;
            aVar.context = eck().pageContext.getPageActivity();
            aVar.fromType = eck().fromType;
            aVar.aWX = eck().hBV;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501041, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrO = (ab) runTask.getData();
            }
        }
        if (this.hrO != null && (HQ = this.hrO.HQ()) != null && eck().ooR.indexOfChild(HQ) < 0) {
            if (HQ.getParent() instanceof ViewGroup) {
                ((ViewGroup) HQ.getParent()).removeView(HQ);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = (BdUtilHelper.getDimens(eck().pageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(eck().pageContext.getPageActivity(), a.d.sdk_ds12) : 0)) + BdUtilHelper.getDimens(eck().pageContext.getPageActivity(), a.d.sdk_ds152) + (eck().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18) * (-1));
            u.a(eck().ooR, HQ, layoutParams, 300);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ceh() {
        CustomResponsedMessage runTask;
        if (this.hrM == null && (runTask = MessageManager.getInstance().runTask(2501052, com.baidu.live.im.b.a.class, eck().pageContext)) != null) {
            this.hrM = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hrM != null) {
            this.hrM.setOtherParams(this.otherParams);
            this.hrM.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.18
                @Override // com.baidu.live.im.b.a.InterfaceC0186a
                public void Nj() {
                    a.this.cer();
                }
            });
            this.hrM.a(eck().ooQ.HR(), false);
            View Da = this.hrM.Da();
            if (Da != null && this.hsx.indexOfChild(Da) < 0) {
                Resources resources = eck().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(eck().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.hsx.addView(Da, layoutParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501053));
        }
    }

    private void cei() {
        if (this.onK == null) {
            this.onK = new com.baidu.tieba.yuyinala.liveroom.f.a(eck().pageContext);
        }
        if (this.hsC != null) {
            this.onK.Im(this.hsC.user_id);
        }
        this.onK.aF(null);
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
                            eck().ooQ.HR().aKQ.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            eck().ooQ.HR().aKQ.isAdmin = 0;
                            eck().ooQ.cmm();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        eck().ooQ.HR().aKQ.isAdmin = 0;
                        eck().ooQ.cmm();
                    }
                } else if ("task".equals(optString2)) {
                    dT(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.onL != null && !eck().hBU) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = eck().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = eck().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = eck().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bYQ()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.onL.c(eck().hBO.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    if (eck().ooQ.HR() != null && eck().ooQ.HR().mLiveInfo != null) {
                        eck().ooQ.a(eck().ooQ.HR().mLiveInfo.live_id, eck().fromType, eck().enterTime);
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.yuyinala.liveroom.o.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (eck().ooQ.HR() != null && eck().ooQ.HR().aKQ != null && eck().ooQ.HR().aKQ.userId == optLong2) {
                        eck().ooQ.HR().aKQ.isBlock = 1;
                        cdp();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (eck().ooQ.HR() != null && eck().ooQ.HR().aKQ != null && eck().ooQ.HR().aKQ.userId == optLong3) {
                        eck().ooQ.HR().aKQ.isBlock = 0;
                        cdp();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (eck().ooQ.HR() != null && eck().ooQ.HR().aKQ != null && eck().ooQ.HR().aKQ.userId == optLong4) {
                        eck().ooQ.HR().aKQ.isUegBlock = 1;
                        cdp();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (eck().ooQ.HR() != null && eck().ooQ.HR().aKQ != null && eck().ooQ.HR().aKQ.userId == optLong5) {
                        eck().ooQ.HR().aKQ.isUegBlock = 0;
                        cdp();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (eck() != null && eck().ooQ != null && eck().ooQ.HR() != null && eck().ooQ.HR().aKQ != null) {
                        if (eck().ooQ.HR().aKQ.userId == jSONObject2.optLong("user_id")) {
                            eck().ooQ.cmm();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, eck().ooQ.HR().aKQ));
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
                    com.baidu.tieba.yuyinala.liveroom.j.c.a(eck(), bVar, jSONObject2);
                }
            }
        } else if (bVar.getMsgType() != 125 && bVar.getMsgType() == 24) {
            com.baidu.tieba.yuyinala.liveroom.j.c.b(eck(), bVar, jSONObject2, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.19
                @Override // com.baidu.tieba.yuyinala.liveroom.j.c.a
                public void VO(String str4) {
                    a.this.Ib(str4);
                }
            });
        }
    }

    protected void Ib(String str) {
    }

    void cer() {
        if (ces() && this.hrL != null) {
            if (!this.hrL.MB().Ov()) {
                this.hrL.MB().hide();
            }
            BdUtilHelper.hideSoftKeyPad(eck().pageContext.getPageActivity(), eck().hBO.getLiveContainerView());
            cdA();
        }
    }

    private boolean ces() {
        if (cdz() == null || cdz().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(x xVar) {
        CustomResponsedMessage runTask;
        eck().ooR.setOnTouchListener(this.htn);
        ceC();
        cei();
        if (this.hrK != null) {
            this.hrK.h(eck().ooQ.HR());
        }
        if (this.onM != null) {
            this.onM.b(eck().ooQ.HR(), NL());
        }
        if (this.onW != null) {
            this.onW.f(eck().ooQ.HR());
        }
        if (eck().ooR != null) {
            eck().ooR.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.21
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
            eck().ooR.setLiveViewOnTouchEventListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.22
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return a.this.P(motionEvent);
                }
            });
        }
        if (this.hsd == null && (runTask = MessageManager.getInstance().runTask(2501042, af.class, eck().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hsd = (af) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ceu() {
        x HR;
        ViewGroup viewGroup;
        if (eck() != null && eck().ooQ != null && (HR = eck().ooQ.HR()) != null && HR.mLiveInfo != null && HR.aLs && (viewGroup = (ViewGroup) eck().hBO) != null) {
            if (this.onT == null) {
                this.onT = new com.baidu.tieba.yuyinala.liveroom.recommend.a(eck().pageContext);
            }
            this.onT.o(HR);
            this.onT.a(eck().ooR);
            this.onT.aF(viewGroup);
            a((d) this.onT);
            a((com.baidu.live.liveroom.g.b) this.onT);
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

    protected void cev() {
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

    protected void cew() {
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
    public void cex() {
        if (this.onS == null && this.hso != null && this.hso.aRO && eck() != null && eck().ooQ != null && eck().ooQ.HR() != null) {
            this.onS = new com.baidu.tieba.yuyinala.liveroom.f.c(eck().pageContext, this.hso);
            this.onS.J(eck().ooQ.HR());
            if (this.hso.aRR == 1) {
                if (this.hrL != null) {
                    this.hsF = true;
                }
            } else if (this.hso.aRR == 2) {
                a(eck().ooQ.HR(), null, -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cey() {
        CustomResponsedMessage runTask;
        if (eck() != null && (runTask = MessageManager.getInstance().runTask(2501047, k.class, eck().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.ab.a)) {
            this.hsp = (com.baidu.live.ab.a) runTask.getData();
            this.hsp.s(cdC());
            if (eck().ooQ != null) {
                this.hsG = this.hsp.p(eck().ooQ.HR());
            }
            this.hsp.setCanVisible(!this.hsA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(boolean z, boolean z2) {
        Rect rect = new Rect();
        eck().hBO.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(eck().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(eck().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? eck().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + eck().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? eck().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds192) : 0) + eck().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds32);
    }

    private void ceC() {
        if (this.hrH == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ai.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.hrH = (com.baidu.live.ai.a) runTask.getData();
            }
            ceD();
        }
    }

    private void dT(JSONObject jSONObject) {
        if (this.hrH != null) {
            this.hrH.cY(true);
            this.hrH.Z(jSONObject);
        }
    }

    private void ceD() {
        if (this.hrH != null && eck().ooQ.HR() != null && eck().ooQ.HR().aLf != null) {
            this.hrH.cY(true);
            this.hrH.j(eck().ooQ.HR());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(x xVar) {
        if (xVar != null) {
            ceD();
            if (this.onK != null && xVar.aKu != null) {
                this.onK.Im(String.valueOf(xVar.aKu.userId));
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
        if (!eck().hBU) {
            if (this.hsy < 0 && i == 0) {
                this.hsy = i;
            } else if (this.hsy != i) {
                if (i == 1) {
                    if (!this.onL.xA(2)) {
                        String string = eck().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(eck().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.onL.a(eck().hBO.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = eck().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.onL.xB(2);
                    this.onL.xB(3);
                    if (bYQ()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.onL.c(eck().hBO.getLiveContainerView(), string2, 3);
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
            ceE();
        }
        if (this.onI != null) {
            this.onI.DC();
        }
        if (this.hrH != null) {
            this.hrH.onDestroy();
            this.hrH = null;
        }
        if (this.onW != null) {
            this.onW.onDestroy();
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
        if (this.onL != null) {
            this.onL.DC();
        }
        this.hsy = -1;
        if (this.onK != null) {
            this.onK.DC();
            this.onK.onDestroy();
        }
        if (this.onN != null) {
            this.onN.ccL();
            this.onN.Id();
        }
        if (this.hrK != null) {
            this.hrK.Id();
        }
        if (this.onM != null) {
            this.onM.Id();
        }
        if (this.onS != null) {
            this.onS.onDestroy();
        }
        if (this.hsd != null) {
            this.hsd.Id();
        }
        if (this.onJ != null) {
            this.onJ.onDestory();
        }
        if (this.hsp != null) {
            this.hsp.Id();
        }
        if (this.onR != null) {
            this.onR.Id();
        }
        if (this.hrZ != null) {
            this.hrZ.onDestroy();
        }
        if (this.onT != null) {
            this.onT.DC();
            b((d) this.onT);
            b((com.baidu.live.liveroom.g.b) this.onT);
        }
        ShowUtil.windowCount = 0;
        cev();
        cew();
    }

    private void ceE() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = eck().ooR.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = eck().ooR.getChildAt(i);
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
        cee();
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
        if (this.onL != null) {
            this.onL.onDestroy();
        }
        if (this.onI != null) {
            this.onI.onDestroy();
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
        if (this.onM != null) {
            this.onM.a(null);
            this.onM.release();
        }
        if (this.onS != null) {
            this.onS.onDestroy();
        }
        if (this.onR != null) {
            this.onR.release();
        }
        if (this.hsd != null) {
            this.hsd.release();
        }
        if (this.onJ != null) {
            this.onJ.onDestory();
        }
        if (this.hsp != null) {
            this.hsp.release();
        }
        if (this.onW != null) {
            this.onW.a((b.a) null);
            this.onW.onDestroy();
        }
        if (this.onT != null) {
            this.onT.onDestroy();
            b((d) this.onT);
            b((com.baidu.live.liveroom.g.b) this.onT);
        }
        cev();
        cew();
        MessageManager.getInstance().unRegisterListener(this.hsT);
        MessageManager.getInstance().unRegisterListener(this.hsU);
        MessageManager.getInstance().unRegisterListener(this.hsV);
        MessageManager.getInstance().unRegisterListener(this.hsZ);
        MessageManager.getInstance().unRegisterListener(this.hta);
        MessageManager.getInstance().unRegisterListener(this.onZ);
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
        cdA();
        if (this.onR != null) {
            this.onR.pause();
        }
        if (this.hrZ != null) {
            this.hrZ.onPause();
        }
        if (this.onW != null) {
            this.onW.ok(false);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.hsJ = false;
        if (this.hsB && this.hsC != null) {
            a(this.hsC);
            this.hsB = false;
        }
        if (this.onR != null) {
            this.onR.resume();
        }
        if (this.hrZ != null) {
            this.hrZ.onResume();
        }
        if (this.onW != null) {
            this.onW.ok(true);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azK() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.onT != null && this.onT.isOpen()) {
            this.onT.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            azK();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    a(null, -1, -1, -1);
                    return;
                }
                return;
            }
            azK();
        } else if (i == 25034) {
            ceb();
        } else if (i == 25043 && i2 == -1) {
            ceH();
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
        if (this.onJ != null) {
            this.onJ.bnP();
        }
        if (this.onT != null) {
            this.onT.C(i, i3);
        }
        if (this.onW != null) {
            this.onW.bnP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        this.onG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.yuyinala.liveroom.data.a eck() {
        return this.onG;
    }

    private void ceH() {
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
            if (cdz() != null) {
                cdz().setVisibility(8);
                return true;
            }
            return true;
        } else if (2 == i) {
            return !this.hsA;
        } else if (3 == i) {
            if (eck().ooR == null) {
                return false;
            }
            eck().ooR.setEnabled(false);
            if (this.bsW != null) {
                this.bsW.e(!eck().hBS, false);
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
            eck().ooR.setEnabled(true);
            if (this.bsW != null) {
                this.bsW.e(!eck().hBS, true);
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

    private boolean bYQ() {
        return eck().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gtp = alaLastLiveroomInfo;
    }
}
