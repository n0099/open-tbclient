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
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.b.ab;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.ag;
import com.baidu.live.data.ap;
import com.baidu.live.data.ay;
import com.baidu.live.data.bd;
import com.baidu.live.data.bm;
import com.baidu.live.data.bn;
import com.baidu.live.data.cs;
import com.baidu.live.data.f;
import com.baidu.live.data.w;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.ae;
import com.baidu.live.gift.af;
import com.baidu.live.gift.ai;
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
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.utils.s;
import com.baidu.live.view.input.d;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class a extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a {
    protected AlaLastLiveroomInfo fVh;
    protected com.baidu.live.ac.a gQF;
    private m gQI;
    k gQJ;
    com.baidu.live.im.b.a gQK;
    protected ac gQL;
    protected aa gQM;
    protected af gQW;
    public boolean gRA;
    public boolean gRB;
    protected List<d> gRF;
    protected List<com.baidu.live.liveroom.g.b> gRG;
    private ae gRb;
    protected bn gRj;
    protected com.baidu.live.v.a gRk;
    protected RelativeLayout gRo;
    protected RelativeLayout gRp;
    protected boolean gRr;
    protected ap gRu;
    protected GuardClubInfoHttpResponseMessage gRv;
    boolean gRw;
    boolean gRx;
    boolean gRy;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.lucky.a nOA;
    protected com.baidu.tieba.yuyinala.liveroom.k.b nOC;
    protected com.baidu.tieba.yuyinala.liveroom.f.c nOD;
    protected com.baidu.tieba.yuyinala.liveroom.recommend.a nOE;
    protected com.baidu.tieba.yuyinala.liveroom.e.a nOF;
    private com.baidu.tieba.yuyinala.liveroom.data.a nOr;
    protected com.baidu.tieba.yuyinala.liveroom.operation.a nOs;
    protected com.baidu.tieba.yuyinala.liveroom.share.a nOt;
    protected com.baidu.tieba.yuyinala.liveroom.l.b nOu;
    private com.baidu.tieba.yuyinala.liveroom.f.a nOv;
    protected com.baidu.tieba.yuyinala.liveroom.tippop.a nOw;
    protected com.baidu.live.view.input.d nOx;
    protected com.baidu.tieba.yuyinala.liveroom.b.a nOy;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.b nOz;
    protected String otherParams;
    private int nOB = 0;
    private int gRq = -1;
    protected int mOrientation = 0;
    protected boolean gRs = false;
    protected boolean gRt = false;
    private CustomMessageListener gRL = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ag agVar;
            if ((customResponsedMessage.getData() instanceof ag) && (agVar = (ag) customResponsedMessage.getData()) != null) {
                a.this.a(agVar.aJv, null, agVar.aJr, agVar.aJs, agVar.aJt, agVar.aJu);
            }
        }
    };
    private CustomMessageListener gRM = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.vi(7);
        }
    };
    private CustomMessageListener gRN = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bVI();
        }
    };
    private CustomMessageListener gRO = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(a.this.dUX().nPk.GH().aIe.userId);
            com.baidu.live.view.a.TX().a(valueOf, new f(a.this.dUX().nPk.GH().aIe.portrait, valueOf, true, a.this.dUX().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener gRP = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof w) && a.this.nOt != null) {
                a.this.nOt.c((w) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bpy = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.gQJ != null) {
                a.this.gQJ.g(z.GB().GD());
            }
        }
    };
    private CustomMessageListener gRQ = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = a.this.nOr.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                a.this.Hy(str);
            }
        }
    };
    private CustomMessageListener gRR = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.dUX().pageContext.getPageActivity());
            } else if (a.this.nOt != null) {
                a.this.nOt.c(a.this.dUX().nPk.GH(), false);
            }
        }
    };
    private CustomMessageListener gRS = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ap) {
                    a.this.gRt = true;
                    a.this.gRu = (ap) data;
                    a.this.b(a.this.gRu);
                } else if (data instanceof com.baidu.live.data.a) {
                    a.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener gRT = new CustomMessageListener(2501060) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(a.this.dUX().nPk.GH().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(a.this.dUX().nPk.GH().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(a.this.dUX().nPk.GH().mLiveInfo.room_id);
                    String valueOf4 = String.valueOf(a.this.dUX().nPk.GH().aIe.userId);
                    if (a.this.nOu == null) {
                        a.this.nOu = new com.baidu.tieba.yuyinala.liveroom.l.b();
                    }
                    a.this.nOu.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, valueOf4, false, obj);
                    a.this.nOu.a(a.this.nOG);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private h.a nOG = new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.3
    };
    private CustomMessageListener gRV = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                a.this.s((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.5
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
    CustomMessageListener gRW = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gRw = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener gRX = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof cs) {
                if (TextUtils.equals(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()), ((cs) customResponsedMessage.getData()).aRx)) {
                    BdUtilHelper.getCustomToast().showToast(a.this.nOr.pageContext.getString(a.i.yuyin_sdk_redpacket_snatch_host_alert), 1);
                } else {
                    a.this.a((cs) customResponsedMessage.getData());
                }
            }
        }
    };
    private CustomMessageListener gRZ = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.x(a.this.dUX().nPk.GH());
        }
    };
    private CustomMessageListener gSb = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (a.this.gQW != null) {
                    ((com.baidu.tieba.yuyinala.liveroom.k.a) a.this.gQW).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener gSc = new CustomMessageListener(2501031) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                a.this.a(a.this.dUX().nPk.GH(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener gSe = new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.17
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.bVV();
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener nOH = new CustomMessageListener(2501034) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinSupportRoomMessage) {
                a.this.h(null, -1, -1, -1);
            }
        }
    };

    protected abstract void a(ap apVar);

    protected abstract void b(ap apVar);

    protected abstract void bUY();

    protected abstract View bVh();

    public abstract boolean bVi();

    protected abstract ViewGroup bVk();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bn bnVar) {
        this.gRj = bnVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gRo = (RelativeLayout) dUX().nPl.findViewById(a.g.ala_live_header_view);
        this.gRp = (RelativeLayout) dUX().nPl.findViewById(a.g.ala_live_footer_view);
        Hx();
        registerListener();
    }

    public void bVp() {
    }

    private void Hx() {
        if (this.nOt == null) {
            this.nOt = new com.baidu.tieba.yuyinala.liveroom.share.a(dUX().pageContext);
        }
        this.nOy = new com.baidu.tieba.yuyinala.liveroom.b.a(dUX().pageContext, false);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            if (!TbadkCoreApplication.getInst().isHaokan() || !subappVersionName.startsWith("4.14.")) {
            }
            if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && subappVersionName.startsWith("1.14.")) {
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            }
        }
        this.nOw = new com.baidu.tieba.yuyinala.liveroom.tippop.a(dUX().pageContext, this);
        bVt();
        bVw();
        bVD();
        bVE();
    }

    private void bVD() {
        this.nOz = new com.baidu.tieba.yuyinala.liveroom.turntable.b(dUX().pageContext.getPageActivity());
    }

    private void bVt() {
        this.gQI = new m();
    }

    public void mD(boolean z) {
        this.gRr = z;
    }

    private void bVw() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501037, com.baidu.live.view.input.d.class, dUX().pageContext);
        if (runTask != null && runTask.getData() != null) {
            try {
                this.nOx = (com.baidu.live.view.input.d) runTask.getData();
                this.nOx.a(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.13
                    @Override // com.baidu.live.view.input.d.a
                    public void Us() {
                        a.this.vi(11);
                    }

                    @Override // com.baidu.live.view.input.d.a
                    public void Ut() {
                        a.this.eP(11);
                    }

                    @Override // com.baidu.live.view.input.d.a
                    public boolean Lm() {
                        return a.this.Jl();
                    }

                    @Override // com.baidu.live.view.input.d.a
                    public boolean LN() {
                        return a.this.bVA();
                    }

                    @Override // com.baidu.live.view.input.d.a
                    public int Lr() {
                        return a.this.bVB();
                    }
                });
            } catch (Exception e) {
            }
        }
    }

    void mE(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bVA() {
        w GH;
        if (dUX() == null || dUX().nPk == null || (GH = dUX().nPk.GH()) == null || GH.aIA == null) {
            return false;
        }
        String str = GH.aIA.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bVB() {
        w GH;
        if (dUX() != null && dUX().nPk != null && (GH = dUX().nPk.GH()) != null && !ListUtils.isEmpty(GH.aIJ)) {
            for (AlaLiveMarkData alaLiveMarkData : GH.aIJ) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void bVE() {
        this.nOC = new com.baidu.tieba.yuyinala.liveroom.k.b(dUX().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.gRS);
        MessageManager.getInstance().registerListener(this.nOH);
        MessageManager.getInstance().registerListener(this.gRT);
        MessageManager.getInstance().registerListener(this.gRV);
        MessageManager.getInstance().registerListener(this.gRO);
        MessageManager.getInstance().registerListener(this.gRP);
        MessageManager.getInstance().registerListener(this.gRR);
        MessageManager.getInstance().registerListener(this.gRQ);
        MessageManager.getInstance().registerListener(this.gpA);
        MessageManager.getInstance().registerListener(this.gRW);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.bpy);
        MessageManager.getInstance().registerListener(this.gRX);
        MessageManager.getInstance().registerListener(this.gRZ);
        MessageManager.getInstance().registerListener(this.gSb);
        MessageManager.getInstance().registerListener(this.gSc);
        MessageManager.getInstance().registerListener(this.gRL);
        MessageManager.getInstance().registerListener(this.gRM);
        MessageManager.getInstance().registerListener(this.gRN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Jl() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(dUX().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(dUX().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(dUX().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.14
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.z.a.Pq().bmJ.aLH;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = dUX().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = dUX().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.15
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(a.this.dUX().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(dUX().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVG() {
        if (this.gQJ != null) {
            this.gQJ.Lk().a(this.nOx.Ot(), z.GB().GD(), dUX().nPk.GH().mLiveInfo);
            mE(true);
            if (this.gRb == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501042, ae.class, dUX().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gRb = (ae) runTask.getData();
                } else {
                    return;
                }
            }
            this.gRb.hd("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.nOF == null) {
            this.nOF = new com.baidu.tieba.yuyinala.liveroom.e.a(dUX().pageContext);
            this.nOF.setId(a.g.ala_live_room_back_to_last_live);
        }
        this.nOF.a(dUX().nPk.GH(), alaLastLiveroomInfo);
        this.nOF.av(this.gRp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVH() {
        if (this.gQJ != null) {
            this.gQJ.Lk().hide();
            mE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(String str, int i, int i2, int i3) {
        if (dUX().nPk.GH() != null && dUX().nPk.GH().aIe != null && dUX().nPk.GH().mLiveInfo != null) {
            a(dUX().nPk.GH(), str, i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, String str, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(ab.class) != null && Jl()) {
            if (wVar == null) {
                wVar = dUX().nPk.GH();
            }
            String valueOf = String.valueOf(wVar.aIe.userId);
            String str2 = wVar.aIe.userName;
            String valueOf2 = String.valueOf(wVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(wVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(wVar.mLiveInfo.feed_id);
            int i6 = wVar.aIA.isBlock;
            String GQ = ai.GQ();
            String str3 = wVar.mLiveInfo.appId;
            boolean z2 = wVar.aIA.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (wVar.mLiveInfo.live_type == 1 && wVar.mLiveInfo.screen_direction == 1 && com.baidu.live.z.a.Pq().bmJ.aKI) {
                z3 = true;
            }
            int i7 = -1;
            if (wVar.aIA == null) {
                z = false;
            } else {
                boolean z4 = wVar.aIA.isNewUser;
                i7 = wVar.aIA.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.gRv != null && this.gRv.bfe != null && this.gRv.bfe.anchorId == wVar.aIe.userId) {
                z5 = this.gRv.bfh;
            }
            ab abVar = new ab(dUX().pageContext.getPageActivity(), str, valueOf, str2, valueOf2, valueOf3, i6, GQ, str3, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.mAlaLiveSwitchData != null) {
                abVar.bc(wVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            abVar.ba(z);
            if (com.baidu.tieba.yuyinala.liveroom.n.b.dVE().bmT != null) {
                abVar.bb(com.baidu.tieba.yuyinala.liveroom.n.b.dVE().bmT.aJz != 1);
            }
            bd Kh = g.Kf().Kh();
            if (Kh == null || Kh.aNS <= 0) {
                i5 = 1000;
            } else {
                i5 = Kh.aNS;
            }
            abVar.dG(i5);
            boolean z6 = false;
            if (wVar != null && wVar.aIA != null) {
                String str4 = wVar.aIA.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str4) || TextUtils.isEmpty(currentAccount) || !str4.equals(currentAccount)) ? false : true;
            }
            abVar.bd(z6);
            boolean z7 = true;
            bm bmVar = com.baidu.live.z.a.Pq().bsy;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bmVar != null && bmVar.aOD != null && (!bmVar.aOD.aQU || !bmVar.aOD.aQV || !bmVar.aOD.aQW)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            abVar.be(z7);
            if (wVar != null && wVar.aIE != null) {
                abVar.fW(wVar.aIE.toJsonString());
            }
            if (!this.gRA) {
                this.gRB = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, abVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVI() {
        eP(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cs csVar) {
        if (csVar != null && Jl()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.ai(dUX().pageContext.getPageActivity(), csVar.aPz, csVar.liveId, csVar.aRx, csVar.roomId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.z.a.Pq().bmJ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(dUX().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.z.a.Pq().bmJ.aMj, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, NobleDetailInfo nobleDetailInfo) {
        if (Jl() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (wVar != null) {
                if (wVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(wVar.mLiveInfo.live_id));
                }
                if (wVar.aIe != null) {
                    hashMap.put("anchor_id", Long.valueOf(wVar.aIe.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", s.GQ());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(dUX().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bVJ() {
        if (this.nOx != null) {
            this.nOx.d(this.nOr.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bVK() {
        w GH = dUX().nPk.GH();
        LogManager.getCommonLogger().doClickQuickImHiLog((GH == null || GH.mLiveInfo == null) ? "" : GH.mLiveInfo.feed_id, Md());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Hz(String str) {
        if (this.nOx != null) {
            this.nOx.hg(str);
        }
    }

    private void bVL() {
        if ("home_rec_play".equals(dUX().fromType) || "frs_play".equals(dUX().fromType) || "frs_live_play".equals(dUX().fromType) || "person_play".equals(dUX().fromType) || "search".equals(dUX().fromType) || "person_attention".equals(dUX().fromType)) {
            com.baidu.live.c.AY().aX(true);
        } else {
            com.baidu.live.c.AY().aX(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mF(boolean z) {
        View Gf;
        if (this.gQL == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aSH = false;
            fVar.context = dUX().pageContext.getPageActivity();
            fVar.aSQ = z;
            fVar.fromType = dUX().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501040, ac.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gQL = (ac) runTask.getData();
            }
        }
        if (this.gQL != null && (Gf = this.gQL.Gf()) != null && this.nOr.nPl.indexOfChild(Gf) < 0) {
            this.nOr.nPl.addView(Gf, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVM() {
        View GT;
        if (this.gQW == null) {
            aj ajVar = new aj();
            ajVar.aSH = false;
            ajVar.pageContext = dUX().pageContext;
            ajVar.fromType = dUX().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501065, af.class, ajVar);
            if (runTask != null && runTask.getData() != null) {
                this.gQW = (af) runTask.getData();
            }
        }
        if (this.gQW != null && (GT = this.gQW.GT()) != null && dUX().nPl.indexOfChild(GT) < 0) {
            if (GT.getParent() instanceof ViewGroup) {
                ((ViewGroup) GT.getParent()).removeView(GT);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = dUX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            dUX().nPl.addView(GT, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVN() {
        View GG;
        if (this.gQM == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aSH = false;
            aVar.context = dUX().pageContext.getPageActivity();
            aVar.fromType = dUX().fromType;
            aVar.aSI = dUX().haG;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501041, aa.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gQM = (aa) runTask.getData();
            }
        }
        if (this.gQM != null && (GG = this.gQM.GG()) != null && dUX().nPl.indexOfChild(GG) < 0) {
            if (GG.getParent() instanceof ViewGroup) {
                ((ViewGroup) GG.getParent()).removeView(GG);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dUX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18) * (-1);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            dUX().nPl.addView(GG, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bVO() {
        CustomResponsedMessage runTask;
        if (this.gQK == null && (runTask = MessageManager.getInstance().runTask(2501052, com.baidu.live.im.b.a.class, dUX().pageContext)) != null) {
            this.gQK = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gQK != null) {
            this.gQK.setOtherParams(this.otherParams);
            this.gQK.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.16
                @Override // com.baidu.live.im.b.a.InterfaceC0186a
                public void LF() {
                    a.this.bVV();
                }
            });
            this.gQK.a(dUX().nPk.GH(), false);
            View Cr = this.gQK.Cr();
            if (Cr != null && this.gRp.indexOfChild(Cr) < 0) {
                Resources resources = dUX().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(dUX().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.gRp.addView(Cr, layoutParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501053));
        }
    }

    private void bVP() {
        if (this.nOv == null) {
            this.nOv = new com.baidu.tieba.yuyinala.liveroom.f.a(dUX().pageContext);
        }
        if (this.gRu != null) {
            this.nOv.HD(this.gRu.user_id);
        }
        this.nOv.av(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:201:0x0656, code lost:
        Hv(r34);
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject optJSONObject;
        long j;
        long j2;
        long j3;
        JSONObject jSONObject4;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject4 = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject4 = new JSONObject(aVar.getContent());
            }
            try {
                String optString = jSONObject4.optString("ext");
                if (!TextUtils.isEmpty(optString)) {
                    new JSONObject(new String(Base64.decode(optString.getBytes(), 0)));
                }
                jSONObject3 = jSONObject4.optJSONObject("ext_data");
                jSONObject2 = jSONObject4;
            } catch (JSONException e) {
                jSONObject = jSONObject4;
                jSONObject2 = jSONObject;
                jSONObject3 = null;
                if (aVar.getMsgType() != 12) {
                }
                if (jSONObject2 == null) {
                }
            }
        } catch (JSONException e2) {
            jSONObject = null;
        }
        if (aVar.getMsgType() != 12 || aVar.getMsgType() == 13) {
            if (jSONObject2 == null) {
                String optString2 = jSONObject2.optString("content_type");
                if ("live_on_private".equals(optString2)) {
                    boolean z = jSONObject2.optInt("on_private", 0) == 1;
                    if (this.bmm != null) {
                        this.bmm.cf(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        vk(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            dUX().nPk.GH().aIA.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            dUX().nPk.GH().aIA.isAdmin = 0;
                            dUX().nPk.cdK();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        dUX().nPk.GH().aIA.isAdmin = 0;
                        dUX().nPk.cdK();
                    }
                } else if ("task".equals(optString2)) {
                    dI(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.nOw != null && !dUX().haF) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = dUX().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = dUX().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = dUX().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bQG()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.nOw.a(dUX().haA.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    if (dUX().nPk.GH() != null && dUX().nPk.GH().mLiveInfo != null) {
                        dUX().nPk.a(dUX().nPk.GH().mLiveInfo.live_id, dUX().fromType, dUX().enterTime);
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.yuyinala.liveroom.m.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (dUX().nPk.GH() != null && dUX().nPk.GH().aIA != null && dUX().nPk.GH().aIA.userId == optLong2) {
                        dUX().nPk.GH().aIA.isBlock = 1;
                        bUY();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (dUX().nPk.GH() != null && dUX().nPk.GH().aIA != null && dUX().nPk.GH().aIA.userId == optLong3) {
                        dUX().nPk.GH().aIA.isBlock = 0;
                        bUY();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (dUX().nPk.GH() != null && dUX().nPk.GH().aIA != null && dUX().nPk.GH().aIA.userId == optLong4) {
                        dUX().nPk.GH().aIA.isUegBlock = 1;
                        bUY();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (dUX().nPk.GH() != null && dUX().nPk.GH().aIA != null && dUX().nPk.GH().aIA.userId == optLong5) {
                        dUX().nPk.GH().aIA.isUegBlock = 0;
                        bUY();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (dUX() != null && dUX().nPk != null && dUX().nPk.GH() != null && dUX().nPk.GH().aIA != null) {
                        if (dUX().nPk.GH().aIA.userId == jSONObject2.optLong("user_id")) {
                            dUX().nPk.cdK();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, dUX().nPk.GH().aIA));
                    }
                } else if ("guard_seat".equals(optString2)) {
                    if (jSONObject2.optInt("seat_status") == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913156));
                    }
                } else if ("official_notice".equals(optString2)) {
                    long optLong6 = jSONObject2.optLong("user_id");
                    if (jSONObject3 != null) {
                        String str2 = optLong6 + "";
                        TbadkCoreApplication.getInst();
                        if (str2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject3);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                } else if ("privilege_award_royal_success".equals(optString2)) {
                    String str3 = jSONObject2.optInt("effect_id") + "";
                    com.baidu.live.data.a LO = aVar.LO();
                    if (LO != null && ai.ha(str3)) {
                        ai.d(str3, 1L, "", "", LO.userId, LO.portrait, LO.userName, "", "", false, "", "", "", false, false, true, -1L, aVar.bja);
                    }
                } else if ("challenge_mvp".equals(optString2)) {
                    if (jSONObject2 != null) {
                        ay ayVar = new ay();
                        ayVar.parseJson(jSONObject2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, ayVar));
                    }
                } else if (TextUtils.equals(optString2, "challenge_mvp_punish")) {
                    if (jSONObject2 != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject2));
                    }
                } else if (TextUtils.equals(optString2, "send_redpacket") && (optJSONObject = jSONObject2.optJSONObject("live_redpacket")) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913221, new RedPacketCharmInfo(optJSONObject)));
                }
            }
        } else if (aVar.getMsgType() != 125 && aVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a LO2 = aVar.LO();
            String optString3 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString4 = jSONObject2.optString("gift_count");
            String optString5 = jSONObject2.optString("gift_name");
            String optString6 = jSONObject2.optString("gift_url");
            String optString7 = jSONObject2.optString("attach");
            long optLong7 = jSONObject2.optLong("charm_total");
            String optString8 = jSONObject2.optString("attach_new");
            String optString9 = jSONObject2.optString("gift_mul");
            boolean z2 = jSONObject2.optInt("is_dynamic_gift") == 1;
            String str4 = null;
            if (dUX().nPk == null || dUX().nPk.GH() == null || dUX().nPk.GH().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j4 = dUX().nPk.GH().mLiveInfo.live_id;
                long j5 = dUX().nPk.GH().mLiveInfo.group_id;
                long j6 = dUX().nPk.GH().aIe.userId;
                str4 = dUX().nPk.GH().mLiveInfo.appId;
                j = j6;
                j2 = j4;
                j3 = j5;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    ai.b(optString9, LO2.userId, LO2.portrait, LO2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "", aVar.getMsgId(), aVar.bja);
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                } else if (com.baidu.live.z.f.PF().hS(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            } else {
                ai.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, LO2.userId, LO2.portrait, LO2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString7, "", "", aVar.getMsgId(), aVar.bja, z2);
                Hv(optString3);
            }
            com.baidu.tieba.yuyinala.liveroom.h.c cVar = new com.baidu.tieba.yuyinala.liveroom.h.c();
            cVar.hag = optLong7;
            cVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
        }
    }

    protected void Hv(String str) {
    }

    void bVV() {
        if (bVW()) {
            BdUtilHelper.hideSoftKeyPad(dUX().pageContext.getPageActivity(), dUX().haA.getLiveContainerView());
            bVi();
        }
    }

    private boolean bVW() {
        if (bVh() == null || bVh().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        CustomResponsedMessage runTask;
        dUX().nPl.setOnTouchListener(this.gSe);
        bWf();
        bVP();
        if (this.gQI != null) {
            this.gQI.h(dUX().nPk.GH());
        }
        if (this.nOx != null) {
            this.nOx.b(dUX().nPk.GH(), Md());
        }
        if (dUX().nPl != null) {
            dUX().nPl.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.18
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    return a.this.P(motionEvent);
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean NA() {
                    if (a.this.gRG == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : a.this.gRG) {
                        if (bVar.NA()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            dUX().nPl.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.19
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return a.this.O(motionEvent);
                }
            });
        }
        if (this.gRb == null && (runTask = MessageManager.getInstance().runTask(2501042, ae.class, dUX().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gRb = (ae) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVX() {
        w GH;
        ViewGroup viewGroup;
        if (dUX() != null && dUX().nPk != null && (GH = dUX().nPk.GH()) != null && GH.mLiveInfo != null && GH.aIY && (viewGroup = (ViewGroup) dUX().haA) != null) {
            if (this.nOE == null) {
                this.nOE = new com.baidu.tieba.yuyinala.liveroom.recommend.a(dUX().pageContext);
            }
            this.nOE.o(GH);
            this.nOE.a(dUX().nPl);
            this.nOE.av(viewGroup);
            a((com.baidu.live.liveroom.g.d) this.nOE);
            a((com.baidu.live.liveroom.g.b) this.nOE);
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.gRF == null) {
            this.gRF = new ArrayList();
        }
        if (!this.gRF.contains(dVar)) {
            this.gRF.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.gRF != null && this.gRF.contains(dVar)) {
            this.gRF.remove(dVar);
        }
    }

    protected void bVY() {
        if (this.gRF != null) {
            this.gRF.clear();
            this.gRF = null;
        }
    }

    protected boolean O(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gRF == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.gRF.iterator();
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
        if (this.gRG == null) {
            this.gRG = new ArrayList();
        }
        if (!this.gRG.contains(bVar)) {
            this.gRG.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.gRG != null && this.gRG.contains(bVar)) {
            this.gRG.remove(bVar);
        }
    }

    protected void bVZ() {
        if (this.gRG != null) {
            this.gRG.clear();
            this.gRG = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gRG == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.gRG.iterator();
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
    public void bWa() {
        if (this.nOD == null && this.gRj != null && this.gRj.aON && dUX() != null && dUX().nPk != null && dUX().nPk.GH() != null) {
            this.nOD = new com.baidu.tieba.yuyinala.liveroom.f.c(dUX().pageContext, this.gRj);
            this.nOD.z(dUX().nPk.GH());
            if (this.gRj.aOQ == 1) {
                if (this.gQJ != null) {
                    this.gRx = true;
                }
            } else if (this.gRj.aOQ == 2) {
                a(dUX().nPk.GH(), null, -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bWb() {
        CustomResponsedMessage runTask;
        if (dUX() != null && (runTask = MessageManager.getInstance().runTask(2501047, k.class, dUX().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.v.a)) {
            this.gRk = (com.baidu.live.v.a) runTask.getData();
            this.gRk.s(bVk());
            if (dUX().nPk != null) {
                this.gRy = this.gRk.p(dUX().nPk.GH());
            }
            this.gRk.setCanVisible(!this.gRs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int M(boolean z, boolean z2) {
        Rect rect = new Rect();
        dUX().haA.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(dUX().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(dUX().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? dUX().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + dUX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? dUX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds192) : 0) + dUX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds32);
    }

    private void bWf() {
        if (this.gQF == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ac.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.gQF = (com.baidu.live.ac.a) runTask.getData();
            }
            bWg();
        }
    }

    private void dI(JSONObject jSONObject) {
        if (this.gQF != null) {
            this.gQF.cy(true);
            this.gQF.R(jSONObject);
        }
    }

    private void bWg() {
        if (this.gQF != null && dUX().nPk.GH() != null && dUX().nPk.GH().aIN != null) {
            this.gQF.cy(true);
            this.gQF.j(dUX().nPk.GH());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(w wVar) {
        if (wVar != null) {
            bWg();
            if (this.nOv != null && wVar.aIe != null) {
                this.nOv.HD(String.valueOf(wVar.aIe.userId));
            }
            if (this.gQM != null && wVar.mLiveInfo != null) {
                this.gQM.a(wVar.mLiveInfo, wVar.aIe);
            }
            if (this.gQK != null) {
                this.gQK.a(wVar);
            }
            if (this.gRk != null) {
                this.gRy = this.gRk.p(wVar);
            }
            vk(wVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void vk(int i) {
        if (!dUX().haF) {
            if (this.gRq < 0 && i == 0) {
                this.gRq = i;
            } else if (this.gRq != i) {
                if (i == 1) {
                    if (!this.nOw.vY(2)) {
                        String string = dUX().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(dUX().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.nOw.a(dUX().haA.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = dUX().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.nOw.vZ(2);
                    this.nOw.vZ(3);
                    if (bQG()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.nOw.a(dUX().haA.getLiveContainerView(), string2, 3);
                    }
                }
                this.gRq = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void ci(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.ci(z);
        if (z) {
            bWh();
        }
        if (this.nOt != null) {
            this.nOt.CT();
        }
        if (this.gQF != null) {
            this.gQF.onDestroy();
            this.gQF = null;
        }
        if (this.gQL != null) {
            View Gf = this.gQL.Gf();
            if (Gf != null && Gf.getParent() != null) {
                ((ViewGroup) Gf.getParent()).removeView(Gf);
            }
            this.gQL.onDestroy();
            this.gQL = null;
        }
        if (this.gQK != null) {
            this.gQK.a((a.InterfaceC0186a) null);
            this.gQK.Ct();
        }
        if (this.nOw != null) {
            this.nOw.CT();
        }
        this.gRq = -1;
        if (this.nOv != null) {
            this.nOv.CT();
            this.nOv.onDestroy();
        }
        if (this.nOy != null) {
            this.nOy.bUz();
            this.nOy.GS();
        }
        if (this.gQI != null) {
            this.gQI.GS();
        }
        if (this.nOx != null) {
            this.nOx.GS();
        }
        if (this.nOD != null) {
            this.nOD.onDestroy();
        }
        if (this.gRb != null) {
            this.gRb.GS();
        }
        if (this.nOu != null) {
            this.nOu.onDestory();
        }
        if (this.gRk != null) {
            this.gRk.GS();
        }
        if (this.nOC != null) {
            this.nOC.GS();
        }
        if (this.gQW != null) {
            this.gQW.onDestroy();
        }
        if (this.nOE != null) {
            this.nOE.CT();
            b((com.baidu.live.liveroom.g.d) this.nOE);
            b((com.baidu.live.liveroom.g.b) this.nOE);
        }
        ShowUtil.windowCount = 0;
        bVY();
        bVZ();
    }

    private void bWh() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = dUX().nPl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = dUX().nPl.getChildAt(i);
            if (childAt != this.gRo && childAt != this.gRp) {
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
        if (this.gRo != null) {
            this.gRo.removeAllViews();
        }
        if (this.gRp != null) {
            this.gRp.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, w wVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(w wVar) {
        View Cr;
        View Gf;
        if (this.gQL != null && (Gf = this.gQL.Gf()) != null && Gf.getParent() != null) {
            ((ViewGroup) Gf.getParent()).removeView(Gf);
        }
        if (this.gQK != null && (Cr = this.gQK.Cr()) != null && Cr.getParent() != null) {
            ((ViewGroup) Cr.getParent()).removeView(Cr);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean Nw() {
        bVL();
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cg(boolean z) {
        super.cg(z);
        if (this.gQF != null) {
            this.gQF.onDestroy();
            this.gQF = null;
        }
        if (this.gQL != null) {
            this.gQL.onDestroy();
            this.gQL = null;
        }
        if (this.gQM != null) {
            this.gQM.onDestroy();
            this.gQM = null;
        }
        if (this.nOw != null) {
            this.nOw.onDestroy();
        }
        if (this.nOt != null) {
            this.nOt.onDestroy();
        }
        if (this.gQW != null) {
            this.gQW.onDestroy();
            this.gQW = null;
        }
        if (this.gQK != null) {
            this.gQK.a((a.InterfaceC0186a) null);
            this.gQK.release();
            this.gQK = null;
        }
        if (this.nOx != null) {
            this.nOx.a(null);
            this.nOx.release();
        }
        if (this.nOD != null) {
            this.nOD.onDestroy();
        }
        if (this.nOC != null) {
            this.nOC.release();
        }
        if (this.gRb != null) {
            this.gRb.release();
        }
        if (this.nOu != null) {
            this.nOu.onDestory();
        }
        if (this.gRk != null) {
            this.gRk.release();
        }
        if (this.nOE != null) {
            this.nOE.onDestroy();
            b((com.baidu.live.liveroom.g.d) this.nOE);
            b((com.baidu.live.liveroom.g.b) this.nOE);
        }
        bVY();
        bVZ();
        MessageManager.getInstance().unRegisterListener(this.gRL);
        MessageManager.getInstance().unRegisterListener(this.gRM);
        MessageManager.getInstance().unRegisterListener(this.gRN);
        MessageManager.getInstance().unRegisterListener(this.gRS);
        MessageManager.getInstance().unRegisterListener(this.gRT);
        MessageManager.getInstance().unRegisterListener(this.nOH);
        MessageManager.getInstance().unRegisterListener(this.gRV);
        MessageManager.getInstance().unRegisterListener(this.gRO);
        MessageManager.getInstance().unRegisterListener(this.gRP);
        MessageManager.getInstance().unRegisterListener(this.gRR);
        MessageManager.getInstance().unRegisterListener(this.gRQ);
        MessageManager.getInstance().unRegisterListener(this.gpA);
        MessageManager.getInstance().unRegisterListener(this.gRW);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.bpy);
        MessageManager.getInstance().unRegisterListener(this.gRX);
        MessageManager.getInstance().unRegisterListener(this.gRZ);
        MessageManager.getInstance().unRegisterListener(this.gSb);
        MessageManager.getInstance().unRegisterListener(this.gSc);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        bVi();
        if (this.nOC != null) {
            this.nOC.pause();
        }
        if (this.gQW != null) {
            this.gQW.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.gRB = false;
        if (this.gRt && this.gRu != null) {
            a(this.gRu);
            this.gRt = false;
        }
        if (this.nOC != null) {
            this.nOC.resume();
        }
        if (this.gQW != null) {
            this.gQW.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ats() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.nOE != null && this.nOE.isOpen()) {
            this.nOE.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            ats();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    h(null, -1, -1, -1);
                    return;
                }
                return;
            }
            ats();
        } else if (i == 25034) {
            bVI();
        } else if (i == 25043 && i2 == -1) {
            bWk();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.gRs = z;
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
        if (this.nOu != null) {
            this.nOu.bgm();
        }
        if (this.nOE != null) {
            this.nOE.D(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        this.nOr = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.yuyinala.liveroom.data.a dUX() {
        return this.nOr;
    }

    private void bWk() {
        String Kg = g.Kf().Kg();
        if (!TextUtils.isEmpty(Kg)) {
            try {
                h(null, -1, Integer.parseInt(Kg), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                h(null, -1, -1, -1);
            }
        }
    }

    @Override // com.baidu.live.liveroom.a.a
    public boolean eO(int i) {
        if (1 == i) {
            if (bVh() != null) {
                bVh().setVisibility(8);
                return true;
            }
            return true;
        } else if (2 == i) {
            return !this.gRs;
        } else if (3 == i) {
            if (dUX().nPl == null) {
                return false;
            }
            dUX().nPl.setEnabled(false);
            if (this.bmm != null) {
                this.bmm.e(!dUX().haD, false);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    public void vi(int i) {
    }

    @Override // com.baidu.live.liveroom.a.a
    public void eP(int i) {
        if (3 == i) {
            dUX().nPl.setEnabled(true);
            if (this.bmm != null) {
                this.bmm.e(!dUX().haD, true);
            }
            if (this.gQF != null) {
                this.gQF.cy(true);
                return;
            }
            return;
        }
        if (2 == i) {
        }
    }

    public String Md() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gQK != null) {
            this.gQK.setOtherParams(str);
        }
    }

    private boolean bQG() {
        return dUX().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fVh = alaLastLiveroomInfo;
    }
}
