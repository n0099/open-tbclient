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
import com.baidu.live.b.ai;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.ah;
import com.baidu.live.data.aq;
import com.baidu.live.data.ba;
import com.baidu.live.data.bf;
import com.baidu.live.data.bn;
import com.baidu.live.data.bo;
import com.baidu.live.data.cw;
import com.baidu.live.data.f;
import com.baidu.live.data.w;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.ae;
import com.baidu.live.gift.y;
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
    protected ae gWH;
    private ad gWM;
    protected bo gWU;
    protected com.baidu.live.w.a gWV;
    protected com.baidu.live.ad.a gWq;
    private m gWt;
    k gWu;
    com.baidu.live.im.b.a gWv;
    protected ab gWw;
    protected z gWx;
    protected RelativeLayout gXb;
    protected RelativeLayout gXc;
    protected boolean gXe;
    protected aq gXh;
    protected GuardClubInfoHttpResponseMessage gXi;
    boolean gXj;
    boolean gXk;
    boolean gXl;
    public boolean gXn;
    public boolean gXo;
    protected List<d> gXs;
    protected List<com.baidu.live.liveroom.g.b> gXt;
    protected AlaLastLiveroomInfo gaF;
    private com.baidu.tieba.yuyinala.liveroom.data.a nVR;
    protected com.baidu.tieba.yuyinala.liveroom.operation.a nVS;
    protected com.baidu.tieba.yuyinala.liveroom.share.a nVT;
    protected com.baidu.tieba.yuyinala.liveroom.l.b nVU;
    private com.baidu.tieba.yuyinala.liveroom.f.a nVV;
    protected com.baidu.tieba.yuyinala.liveroom.tippop.a nVW;
    protected com.baidu.live.view.input.d nVX;
    protected com.baidu.tieba.yuyinala.liveroom.b.a nVY;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.b nVZ;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.lucky.a nWa;
    protected com.baidu.tieba.yuyinala.liveroom.k.b nWc;
    protected com.baidu.tieba.yuyinala.liveroom.f.c nWd;
    protected com.baidu.tieba.yuyinala.liveroom.recommend.a nWe;
    protected com.baidu.tieba.yuyinala.liveroom.e.a nWf;
    protected String otherParams;
    private int nWb = 0;
    private int gXd = -1;
    protected int mOrientation = 0;
    protected boolean gXf = false;
    protected boolean gXg = false;
    private CustomMessageListener gXy = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ah ahVar;
            if ((customResponsedMessage.getData() instanceof ah) && (ahVar = (ah) customResponsedMessage.getData()) != null) {
                a.this.a(ahVar.aIK, null, ahVar.aIG, ahVar.aIH, ahVar.aII, ahVar.aIJ);
            }
        }
    };
    private CustomMessageListener gXz = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.vT(7);
        }
    };
    private CustomMessageListener gXA = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bXB();
        }
    };
    private CustomMessageListener gXB = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(a.this.dXw().nWV.Gz().aHk.userId);
            com.baidu.live.view.a.VO().a(valueOf, new f(a.this.dXw().nWV.Gz().aHk.portrait, valueOf, true, a.this.dXw().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener gXC = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof w) && a.this.nVT != null) {
                a.this.nVT.c((w) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bpg = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.gWu != null) {
                a.this.gWu.g(y.Gt().Gv());
            }
        }
    };
    private CustomMessageListener gXD = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = a.this.nVR.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                a.this.Hr(str);
            }
        }
    };
    private CustomMessageListener guI = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.dXw().pageContext.getPageActivity());
            } else if (a.this.nVT != null) {
                a.this.nVT.c(a.this.dXw().nWV.Gz(), false);
            }
        }
    };
    private CustomMessageListener gXE = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof aq) {
                    a.this.gXg = true;
                    a.this.gXh = (aq) data;
                    a.this.b(a.this.gXh);
                } else if (data instanceof com.baidu.live.data.a) {
                    a.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener gXF = new CustomMessageListener(2501060) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(a.this.dXw().nWV.Gz().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(a.this.dXw().nWV.Gz().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(a.this.dXw().nWV.Gz().mLiveInfo.room_id);
                    String valueOf4 = String.valueOf(a.this.dXw().nWV.Gz().aHk.userId);
                    if (a.this.nVU == null) {
                        a.this.nVU = new com.baidu.tieba.yuyinala.liveroom.l.b();
                    }
                    a.this.nVU.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, valueOf4, false, obj);
                    a.this.nVU.a(a.this.nWg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private h.a nWg = new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.3
    };
    private CustomMessageListener gXH = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                a.this.t((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.5
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
    CustomMessageListener gXI = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gXj = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener gXJ = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof cw) {
                if (TextUtils.equals(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()), ((cw) customResponsedMessage.getData()).aRd)) {
                    BdUtilHelper.getCustomToast().showToast(a.this.nVR.pageContext.getString(a.h.yuyin_sdk_redpacket_snatch_host_alert), 1);
                } else {
                    a.this.a((cw) customResponsedMessage.getData());
                }
            }
        }
    };
    private CustomMessageListener gXL = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.C(a.this.dXw().nWV.Gz());
        }
    };
    private CustomMessageListener gXN = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (a.this.gWH != null) {
                    ((com.baidu.tieba.yuyinala.liveroom.k.a) a.this.gWH).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener gXO = new CustomMessageListener(2501031) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                a.this.a(a.this.dXw().nWV.Gz(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener gXQ = new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.17
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.bXO();
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener nWh = new CustomMessageListener(2501034) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinSupportRoomMessage) {
                a.this.a(null, -1, -1, -1);
            }
        }
    };

    protected abstract void a(aq aqVar);

    protected abstract void b(aq aqVar);

    protected abstract void bWR();

    protected abstract View bXa();

    public abstract boolean bXb();

    protected abstract ViewGroup bXd();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bo boVar) {
        this.gWU = boVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gXb = (RelativeLayout) dXw().nWW.findViewById(a.f.ala_live_header_view);
        this.gXc = (RelativeLayout) dXw().nWW.findViewById(a.f.ala_live_footer_view);
        Hp();
        registerListener();
    }

    public void bXi() {
    }

    private void Hp() {
        if (this.nVT == null) {
            this.nVT = new com.baidu.tieba.yuyinala.liveroom.share.a(dXw().pageContext);
        }
        this.nVY = new com.baidu.tieba.yuyinala.liveroom.b.a(dXw().pageContext, false);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            if (!TbadkCoreApplication.getInst().isHaokan() || !subappVersionName.startsWith("4.14.")) {
            }
            if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && subappVersionName.startsWith("1.14.")) {
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            }
        }
        this.nVW = new com.baidu.tieba.yuyinala.liveroom.tippop.a(dXw().pageContext, this);
        bXm();
        bXp();
        bXw();
        bXx();
    }

    private void bXw() {
        this.nVZ = new com.baidu.tieba.yuyinala.liveroom.turntable.b(dXw().pageContext.getPageActivity());
    }

    private void bXm() {
        this.gWt = new m();
    }

    public void mN(boolean z) {
        this.gXe = z;
    }

    private void bXp() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501037, com.baidu.live.view.input.d.class, dXw().pageContext);
        if (runTask != null && runTask.getData() != null) {
            try {
                this.nVX = (com.baidu.live.view.input.d) runTask.getData();
                this.nVX.a(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.13
                    @Override // com.baidu.live.view.input.d.a
                    public void Wj() {
                        a.this.vT(11);
                    }

                    @Override // com.baidu.live.view.input.d.a
                    public void Wk() {
                        a.this.eL(11);
                    }

                    @Override // com.baidu.live.view.input.d.a
                    public boolean Ld() {
                        return a.this.Jd();
                    }

                    @Override // com.baidu.live.view.input.d.a
                    public boolean LE() {
                        return a.this.bXt();
                    }

                    @Override // com.baidu.live.view.input.d.a
                    public int Li() {
                        return a.this.bXu();
                    }
                });
            } catch (Exception e) {
            }
        }
    }

    void mO(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bXt() {
        w Gz;
        if (dXw() == null || dXw().nWV == null || (Gz = dXw().nWV.Gz()) == null || Gz.aHG == null) {
            return false;
        }
        String str = Gz.aHG.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bXu() {
        w Gz;
        if (dXw() != null && dXw().nWV != null && (Gz = dXw().nWV.Gz()) != null && !ListUtils.isEmpty(Gz.aHP)) {
            for (AlaLiveMarkData alaLiveMarkData : Gz.aHP) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void bXx() {
        this.nWc = new com.baidu.tieba.yuyinala.liveroom.k.b(dXw().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.gXE);
        MessageManager.getInstance().registerListener(this.nWh);
        MessageManager.getInstance().registerListener(this.gXF);
        MessageManager.getInstance().registerListener(this.gXH);
        MessageManager.getInstance().registerListener(this.gXB);
        MessageManager.getInstance().registerListener(this.gXC);
        MessageManager.getInstance().registerListener(this.guI);
        MessageManager.getInstance().registerListener(this.gXD);
        MessageManager.getInstance().registerListener(this.guV);
        MessageManager.getInstance().registerListener(this.gXI);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.bpg);
        MessageManager.getInstance().registerListener(this.gXJ);
        MessageManager.getInstance().registerListener(this.gXL);
        MessageManager.getInstance().registerListener(this.gXN);
        MessageManager.getInstance().registerListener(this.gXO);
        MessageManager.getInstance().registerListener(this.gXy);
        MessageManager.getInstance().registerListener(this.gXz);
        MessageManager.getInstance().registerListener(this.gXA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Jd() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(dXw().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hr(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(dXw().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(dXw().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.14
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.aa.a.Ph().bms.aKW;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = dXw().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = dXw().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.15
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(a.this.dXw().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(dXw().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXz() {
        if (this.gWu != null) {
            this.gWu.Lb().a(this.nVX.Ok(), y.Gt().Gv(), dXw().nWV.Gz().mLiveInfo);
            mO(true);
            if (this.gWM == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501042, ad.class, dXw().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gWM = (ad) runTask.getData();
                } else {
                    return;
                }
            }
            this.gWM.he("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.nWf == null) {
            this.nWf = new com.baidu.tieba.yuyinala.liveroom.e.a(dXw().pageContext);
            this.nWf.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.nWf.a(dXw().nWV.Gz(), alaLastLiveroomInfo);
        this.nWf.at(this.gXc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXA() {
        if (this.gWu != null) {
            this.gWu.Lb().hide();
            mO(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String[] strArr, int i, int i2, int i3) {
        if (dXw().nWV.Gz() != null && dXw().nWV.Gz().aHk != null && dXw().nWV.Gz().mLiveInfo != null) {
            a(dXw().nWV.Gz(), strArr, i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, String[] strArr, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(com.baidu.live.b.ab.class) != null && Jd()) {
            if (wVar == null) {
                wVar = dXw().nWV.Gz();
            }
            String valueOf = String.valueOf(wVar.aHk.userId);
            String str = wVar.aHk.userName;
            String valueOf2 = String.valueOf(wVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(wVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(wVar.mLiveInfo.feed_id);
            int i6 = wVar.aHG.isBlock;
            String GI = com.baidu.live.gift.ah.GI();
            String str2 = wVar.mLiveInfo.appId;
            boolean z2 = wVar.aHG.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (wVar.mLiveInfo.live_type == 1 && wVar.mLiveInfo.screen_direction == 1 && com.baidu.live.aa.a.Ph().bms.aJX) {
                z3 = true;
            }
            int i7 = -1;
            if (wVar.aHG == null) {
                z = false;
            } else {
                boolean z4 = wVar.aHG.isNewUser;
                i7 = wVar.aHG.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.gXi != null && this.gXi.beL != null && this.gXi.beL.anchorId == wVar.aHk.userId) {
                z5 = this.gXi.beO;
            }
            com.baidu.live.b.ab abVar = new com.baidu.live.b.ab(dXw().pageContext.getPageActivity(), strArr, valueOf, str, valueOf2, valueOf3, i6, GI, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.mAlaLiveSwitchData != null) {
                abVar.bf(wVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            abVar.bd(z);
            if (com.baidu.tieba.yuyinala.liveroom.n.b.dYs().bmB != null) {
                abVar.be(com.baidu.tieba.yuyinala.liveroom.n.b.dYs().bmB.aIO != 1);
            }
            bf JY = g.JW().JY();
            if (JY == null || JY.aNk <= 0) {
                i5 = 1000;
            } else {
                i5 = JY.aNk;
            }
            abVar.dC(i5);
            boolean z6 = false;
            if (wVar != null && wVar.aHG != null) {
                String str3 = wVar.aHG.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            abVar.bg(z6);
            boolean z7 = true;
            bn bnVar = com.baidu.live.aa.a.Ph().bsh;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bnVar != null && bnVar.aNP != null && (!bnVar.aNP.aQl || !bnVar.aNP.aQm || !bnVar.aNP.aQn)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            abVar.bh(z7);
            if (wVar != null && wVar.aHK != null) {
                abVar.fV(wVar.aHK.toJsonString());
            }
            if (!this.gXn) {
                this.gXo = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, abVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXB() {
        eL(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cw cwVar) {
        if (cwVar != null && Jd()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ai(dXw().pageContext.getPageActivity(), cwVar.aOL, cwVar.liveId, cwVar.aRd, cwVar.roomId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.aa.a.Ph().bms != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(dXw().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.aa.a.Ph().bms.aLy, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, NobleDetailInfo nobleDetailInfo) {
        if (Jd() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (wVar != null) {
                if (wVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(wVar.mLiveInfo.live_id));
                }
                if (wVar.aHk != null) {
                    hashMap.put("anchor_id", Long.valueOf(wVar.aHk.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", s.GI());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put("day", Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(dXw().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bXC() {
        if (this.nVX != null) {
            this.nVX.d(this.nVR.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bXD() {
        w Gz = dXw().nWV.Gz();
        LogManager.getCommonLogger().doClickQuickImHiLog((Gz == null || Gz.mLiveInfo == null) ? "" : Gz.mLiveInfo.feed_id, LU());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Hs(String str) {
        if (this.nVX != null) {
            this.nVX.hh(str);
        }
    }

    private void bXE() {
        if ("home_rec_play".equals(dXw().fromType) || "frs_play".equals(dXw().fromType) || "frs_live_play".equals(dXw().fromType) || "person_play".equals(dXw().fromType) || "search".equals(dXw().fromType) || "person_attention".equals(dXw().fromType)) {
            com.baidu.live.c.Ap().aZ(true);
        } else {
            com.baidu.live.c.Ap().aZ(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mP(boolean z) {
        View FX;
        if (this.gWw == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aSp = false;
            fVar.context = dXw().pageContext.getPageActivity();
            fVar.aSy = z;
            fVar.fromType = dXw().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501040, ab.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWw = (ab) runTask.getData();
            }
        }
        if (this.gWw != null && (FX = this.gWw.FX()) != null && this.nVR.nWW.indexOfChild(FX) < 0) {
            this.nVR.nWW.addView(FX, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXF() {
        View GL;
        if (this.gWH == null) {
            com.baidu.live.gift.ai aiVar = new com.baidu.live.gift.ai();
            aiVar.aSp = false;
            aiVar.pageContext = dXw().pageContext;
            aiVar.fromType = dXw().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501065, ae.class, aiVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWH = (ae) runTask.getData();
            }
        }
        if (this.gWH != null && (GL = this.gWH.GL()) != null && dXw().nWW.indexOfChild(GL) < 0) {
            if (GL.getParent() instanceof ViewGroup) {
                ((ViewGroup) GL.getParent()).removeView(GL);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = dXw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            dXw().nWW.addView(GL, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXG() {
        View Gy;
        if (this.gWx == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aSp = false;
            aVar.context = dXw().pageContext.getPageActivity();
            aVar.fromType = dXw().fromType;
            aVar.aSq = dXw().hgq;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501041, z.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWx = (z) runTask.getData();
            }
        }
        if (this.gWx != null && (Gy = this.gWx.Gy()) != null && dXw().nWW.indexOfChild(Gy) < 0) {
            if (Gy.getParent() instanceof ViewGroup) {
                ((ViewGroup) Gy.getParent()).removeView(Gy);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = (BdUtilHelper.getDimens(dXw().pageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(dXw().pageContext.getPageActivity(), a.d.sdk_ds12) : 0)) + BdUtilHelper.getDimens(dXw().pageContext.getPageActivity(), a.d.sdk_ds152) + (dXw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18) * (-1));
            dXw().nWW.addView(Gy, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bXH() {
        CustomResponsedMessage runTask;
        if (this.gWv == null && (runTask = MessageManager.getInstance().runTask(2501052, com.baidu.live.im.b.a.class, dXw().pageContext)) != null) {
            this.gWv = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gWv != null) {
            this.gWv.setOtherParams(this.otherParams);
            this.gWv.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.16
                @Override // com.baidu.live.im.b.a.InterfaceC0186a
                public void Lw() {
                    a.this.bXO();
                }
            });
            this.gWv.a(dXw().nWV.Gz(), false);
            View Cb = this.gWv.Cb();
            if (Cb != null && this.gXc.indexOfChild(Cb) < 0) {
                Resources resources = dXw().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(dXw().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.gXc.addView(Cb, layoutParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501053));
        }
    }

    private void bXI() {
        if (this.nVV == null) {
            this.nVV = new com.baidu.tieba.yuyinala.liveroom.f.a(dXw().pageContext);
        }
        if (this.gXh != null) {
            this.nVV.Hw(this.gXh.user_id);
        }
        this.nVV.at(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:201:0x0656, code lost:
        Ho(r34);
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(com.baidu.live.im.data.a aVar) {
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
                    if (this.blV != null) {
                        this.blV.ci(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        vV(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            dXw().nWV.Gz().aHG.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            dXw().nWV.Gz().aHG.isAdmin = 0;
                            dXw().nWV.cfE();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        dXw().nWV.Gz().aHG.isAdmin = 0;
                        dXw().nWV.cfE();
                    }
                } else if ("task".equals(optString2)) {
                    dI(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.nVW != null && !dXw().hgp) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = dXw().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = dXw().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = dXw().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bSz()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.nVW.a(dXw().hgj.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    if (dXw().nWV.Gz() != null && dXw().nWV.Gz().mLiveInfo != null) {
                        dXw().nWV.a(dXw().nWV.Gz().mLiveInfo.live_id, dXw().fromType, dXw().enterTime);
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.yuyinala.liveroom.m.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (dXw().nWV.Gz() != null && dXw().nWV.Gz().aHG != null && dXw().nWV.Gz().aHG.userId == optLong2) {
                        dXw().nWV.Gz().aHG.isBlock = 1;
                        bWR();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (dXw().nWV.Gz() != null && dXw().nWV.Gz().aHG != null && dXw().nWV.Gz().aHG.userId == optLong3) {
                        dXw().nWV.Gz().aHG.isBlock = 0;
                        bWR();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (dXw().nWV.Gz() != null && dXw().nWV.Gz().aHG != null && dXw().nWV.Gz().aHG.userId == optLong4) {
                        dXw().nWV.Gz().aHG.isUegBlock = 1;
                        bWR();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (dXw().nWV.Gz() != null && dXw().nWV.Gz().aHG != null && dXw().nWV.Gz().aHG.userId == optLong5) {
                        dXw().nWV.Gz().aHG.isUegBlock = 0;
                        bWR();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (dXw() != null && dXw().nWV != null && dXw().nWV.Gz() != null && dXw().nWV.Gz().aHG != null) {
                        if (dXw().nWV.Gz().aHG.userId == jSONObject2.optLong("user_id")) {
                            dXw().nWV.cfE();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, dXw().nWV.Gz().aHG));
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
                    com.baidu.live.data.a LF = aVar.LF();
                    if (LF != null && com.baidu.live.gift.ah.ha(str3)) {
                        com.baidu.live.gift.ah.d(str3, 1L, "", "", LF.userId, LF.portrait, LF.userName, "", "", false, "", "", "", false, false, true, -1L, aVar.biJ);
                    }
                } else if ("challenge_mvp".equals(optString2)) {
                    if (jSONObject2 != null) {
                        ba baVar = new ba();
                        baVar.parseJson(jSONObject2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, baVar));
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
            com.baidu.live.data.a LF2 = aVar.LF();
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
            if (dXw().nWV == null || dXw().nWV.Gz() == null || dXw().nWV.Gz().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j4 = dXw().nWV.Gz().mLiveInfo.live_id;
                long j5 = dXw().nWV.Gz().mLiveInfo.group_id;
                long j6 = dXw().nWV.Gz().aHk.userId;
                str4 = dXw().nWV.Gz().mLiveInfo.appId;
                j = j6;
                j2 = j4;
                j3 = j5;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    com.baidu.live.gift.ah.b(optString9, LF2.userId, LF2.portrait, LF2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "", aVar.getMsgId(), aVar.biJ);
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                } else if (com.baidu.live.aa.f.Px().hT(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                com.baidu.live.gift.ah.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, LF2.userId, LF2.portrait, LF2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString7, "", "", aVar.getMsgId(), aVar.biJ, z2);
                Ho(optString3);
            }
            com.baidu.tieba.yuyinala.liveroom.h.c cVar = new com.baidu.tieba.yuyinala.liveroom.h.c();
            cVar.hfR = optLong7;
            cVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
        }
    }

    protected void Ho(String str) {
    }

    void bXO() {
        if (bXP()) {
            BdUtilHelper.hideSoftKeyPad(dXw().pageContext.getPageActivity(), dXw().hgj.getLiveContainerView());
            bXb();
        }
    }

    private boolean bXP() {
        if (bXa() == null || bXa().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        CustomResponsedMessage runTask;
        dXw().nWW.setOnTouchListener(this.gXQ);
        bXZ();
        bXI();
        if (this.gWt != null) {
            this.gWt.g(dXw().nWV.Gz());
        }
        if (this.nVX != null) {
            this.nVX.b(dXw().nWV.Gz(), LU());
        }
        if (dXw().nWW != null) {
            dXw().nWW.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.18
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    return a.this.Q(motionEvent);
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Nr() {
                    if (a.this.gXt == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : a.this.gXt) {
                        if (bVar.Nr()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            dXw().nWW.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.19
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return a.this.P(motionEvent);
                }
            });
        }
        if (this.gWM == null && (runTask = MessageManager.getInstance().runTask(2501042, ad.class, dXw().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gWM = (ad) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXR() {
        w Gz;
        ViewGroup viewGroup;
        if (dXw() != null && dXw().nWV != null && (Gz = dXw().nWV.Gz()) != null && Gz.mLiveInfo != null && Gz.aIg && (viewGroup = (ViewGroup) dXw().hgj) != null) {
            if (this.nWe == null) {
                this.nWe = new com.baidu.tieba.yuyinala.liveroom.recommend.a(dXw().pageContext);
            }
            this.nWe.n(Gz);
            this.nWe.a(dXw().nWW);
            this.nWe.at(viewGroup);
            a((com.baidu.live.liveroom.g.d) this.nWe);
            a((com.baidu.live.liveroom.g.b) this.nWe);
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.gXs == null) {
            this.gXs = new ArrayList();
        }
        if (!this.gXs.contains(dVar)) {
            this.gXs.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.gXs != null && this.gXs.contains(dVar)) {
            this.gXs.remove(dVar);
        }
    }

    protected void bXS() {
        if (this.gXs != null) {
            this.gXs.clear();
            this.gXs = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gXs == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.gXs.iterator();
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
        if (this.gXt == null) {
            this.gXt = new ArrayList();
        }
        if (!this.gXt.contains(bVar)) {
            this.gXt.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.gXt != null && this.gXt.contains(bVar)) {
            this.gXt.remove(bVar);
        }
    }

    protected void bXT() {
        if (this.gXt != null) {
            this.gXt.clear();
            this.gXt = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gXt == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.gXt.iterator();
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
    public void bXU() {
        if (this.nWd == null && this.gWU != null && this.gWU.aNZ && dXw() != null && dXw().nWV != null && dXw().nWV.Gz() != null) {
            this.nWd = new com.baidu.tieba.yuyinala.liveroom.f.c(dXw().pageContext, this.gWU);
            this.nWd.E(dXw().nWV.Gz());
            if (this.gWU.aOc == 1) {
                if (this.gWu != null) {
                    this.gXk = true;
                }
            } else if (this.gWU.aOc == 2) {
                a(dXw().nWV.Gz(), null, -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXV() {
        CustomResponsedMessage runTask;
        if (dXw() != null && (runTask = MessageManager.getInstance().runTask(2501047, k.class, dXw().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.w.a)) {
            this.gWV = (com.baidu.live.w.a) runTask.getData();
            this.gWV.p(bXd());
            if (dXw().nWV != null) {
                this.gXl = this.gWV.o(dXw().nWV.Gz());
            }
            this.gWV.setCanVisible(!this.gXf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int M(boolean z, boolean z2) {
        Rect rect = new Rect();
        dXw().hgj.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(dXw().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(dXw().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? dXw().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + dXw().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? dXw().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds192) : 0) + dXw().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds32);
    }

    private void bXZ() {
        if (this.gWq == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ad.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.gWq = (com.baidu.live.ad.a) runTask.getData();
            }
            bYa();
        }
    }

    private void dI(JSONObject jSONObject) {
        if (this.gWq != null) {
            this.gWq.cH(true);
            this.gWq.P(jSONObject);
        }
    }

    private void bYa() {
        if (this.gWq != null && dXw().nWV.Gz() != null && dXw().nWV.Gz().aHT != null) {
            this.gWq.cH(true);
            this.gWq.i(dXw().nWV.Gz());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        if (wVar != null) {
            bYa();
            if (this.nVV != null && wVar.aHk != null) {
                this.nVV.Hw(String.valueOf(wVar.aHk.userId));
            }
            if (this.gWx != null && wVar.mLiveInfo != null) {
                this.gWx.a(wVar.mLiveInfo, wVar.aHk);
            }
            if (this.gWv != null) {
                this.gWv.a(wVar);
            }
            if (this.gWV != null) {
                this.gXl = this.gWV.o(wVar);
            }
            vV(wVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void vV(int i) {
        if (!dXw().hgp) {
            if (this.gXd < 0 && i == 0) {
                this.gXd = i;
            } else if (this.gXd != i) {
                if (i == 1) {
                    if (!this.nVW.wJ(2)) {
                        String string = dXw().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(dXw().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.nVW.a(dXw().hgj.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = dXw().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.nVW.wK(2);
                    this.nVW.wK(3);
                    if (bSz()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.nVW.a(dXw().hgj.getLiveContainerView(), string2, 3);
                    }
                }
                this.gXd = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cl(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.cl(z);
        if (z) {
            bYb();
        }
        if (this.nVT != null) {
            this.nVT.CD();
        }
        if (this.gWq != null) {
            this.gWq.onDestroy();
            this.gWq = null;
        }
        if (this.gWw != null) {
            View FX = this.gWw.FX();
            if (FX != null && FX.getParent() != null) {
                ((ViewGroup) FX.getParent()).removeView(FX);
            }
            this.gWw.onDestroy();
            this.gWw = null;
        }
        if (this.gWv != null) {
            this.gWv.a((a.InterfaceC0186a) null);
            this.gWv.Cd();
        }
        if (this.nVW != null) {
            this.nVW.CD();
        }
        this.gXd = -1;
        if (this.nVV != null) {
            this.nVV.CD();
            this.nVV.onDestroy();
        }
        if (this.nVY != null) {
            this.nVY.bWs();
            this.nVY.GK();
        }
        if (this.gWt != null) {
            this.gWt.GK();
        }
        if (this.nVX != null) {
            this.nVX.GK();
        }
        if (this.nWd != null) {
            this.nWd.onDestroy();
        }
        if (this.gWM != null) {
            this.gWM.GK();
        }
        if (this.nVU != null) {
            this.nVU.onDestory();
        }
        if (this.gWV != null) {
            this.gWV.GK();
        }
        if (this.nWc != null) {
            this.nWc.GK();
        }
        if (this.gWH != null) {
            this.gWH.onDestroy();
        }
        if (this.nWe != null) {
            this.nWe.CD();
            b((com.baidu.live.liveroom.g.d) this.nWe);
            b((com.baidu.live.liveroom.g.b) this.nWe);
        }
        ShowUtil.windowCount = 0;
        bXS();
        bXT();
    }

    private void bYb() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = dXw().nWW.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = dXw().nWW.getChildAt(i);
            if (childAt != this.gXb && childAt != this.gXc) {
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
        if (this.gXb != null) {
            this.gXb.removeAllViews();
        }
        if (this.gXc != null) {
            this.gXc.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, w wVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        View Cb;
        View FX;
        if (this.gWw != null && (FX = this.gWw.FX()) != null && FX.getParent() != null) {
            ((ViewGroup) FX.getParent()).removeView(FX);
        }
        if (this.gWv != null && (Cb = this.gWv.Cb()) != null && Cb.getParent() != null) {
            ((ViewGroup) Cb.getParent()).removeView(Cb);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean Nn() {
        bXE();
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cj(boolean z) {
        super.cj(z);
        if (this.gWq != null) {
            this.gWq.onDestroy();
            this.gWq = null;
        }
        if (this.gWw != null) {
            this.gWw.onDestroy();
            this.gWw = null;
        }
        if (this.gWx != null) {
            this.gWx.onDestroy();
            this.gWx = null;
        }
        if (this.nVW != null) {
            this.nVW.onDestroy();
        }
        if (this.nVT != null) {
            this.nVT.onDestroy();
        }
        if (this.gWH != null) {
            this.gWH.onDestroy();
            this.gWH = null;
        }
        if (this.gWv != null) {
            this.gWv.a((a.InterfaceC0186a) null);
            this.gWv.release();
            this.gWv = null;
        }
        if (this.nVX != null) {
            this.nVX.a(null);
            this.nVX.release();
        }
        if (this.nWd != null) {
            this.nWd.onDestroy();
        }
        if (this.nWc != null) {
            this.nWc.release();
        }
        if (this.gWM != null) {
            this.gWM.release();
        }
        if (this.nVU != null) {
            this.nVU.onDestory();
        }
        if (this.gWV != null) {
            this.gWV.release();
        }
        if (this.nWe != null) {
            this.nWe.onDestroy();
            b((com.baidu.live.liveroom.g.d) this.nWe);
            b((com.baidu.live.liveroom.g.b) this.nWe);
        }
        bXS();
        bXT();
        MessageManager.getInstance().unRegisterListener(this.gXy);
        MessageManager.getInstance().unRegisterListener(this.gXz);
        MessageManager.getInstance().unRegisterListener(this.gXA);
        MessageManager.getInstance().unRegisterListener(this.gXE);
        MessageManager.getInstance().unRegisterListener(this.gXF);
        MessageManager.getInstance().unRegisterListener(this.nWh);
        MessageManager.getInstance().unRegisterListener(this.gXH);
        MessageManager.getInstance().unRegisterListener(this.gXB);
        MessageManager.getInstance().unRegisterListener(this.gXC);
        MessageManager.getInstance().unRegisterListener(this.guI);
        MessageManager.getInstance().unRegisterListener(this.gXD);
        MessageManager.getInstance().unRegisterListener(this.guV);
        MessageManager.getInstance().unRegisterListener(this.gXI);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.bpg);
        MessageManager.getInstance().unRegisterListener(this.gXJ);
        MessageManager.getInstance().unRegisterListener(this.gXL);
        MessageManager.getInstance().unRegisterListener(this.gXN);
        MessageManager.getInstance().unRegisterListener(this.gXO);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        bXb();
        if (this.nWc != null) {
            this.nWc.pause();
        }
        if (this.gWH != null) {
            this.gWH.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.gXo = false;
        if (this.gXg && this.gXh != null) {
            a(this.gXh);
            this.gXg = false;
        }
        if (this.nWc != null) {
            this.nWc.resume();
        }
        if (this.gWH != null) {
            this.gWH.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avk() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.nWe != null && this.nWe.isOpen()) {
            this.nWe.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            avk();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    a(null, -1, -1, -1);
                    return;
                }
                return;
            }
            avk();
        } else if (i == 25034) {
            bXB();
        } else if (i == 25043 && i2 == -1) {
            bYe();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.gXf = z;
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
        if (this.nVU != null) {
            this.nVU.big();
        }
        if (this.nWe != null) {
            this.nWe.D(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        this.nVR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.yuyinala.liveroom.data.a dXw() {
        return this.nVR;
    }

    private void bYe() {
        String JX = g.JW().JX();
        if (!TextUtils.isEmpty(JX)) {
            try {
                a(null, -1, Integer.parseInt(JX), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                a(null, -1, -1, -1);
            }
        }
    }

    @Override // com.baidu.live.liveroom.a.a
    public boolean eK(int i) {
        if (1 == i) {
            if (bXa() != null) {
                bXa().setVisibility(8);
                return true;
            }
            return true;
        } else if (2 == i) {
            return !this.gXf;
        } else if (3 == i) {
            if (dXw().nWW == null) {
                return false;
            }
            dXw().nWW.setEnabled(false);
            if (this.blV != null) {
                this.blV.e(!dXw().hgn, false);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    public void vT(int i) {
    }

    @Override // com.baidu.live.liveroom.a.a
    public void eL(int i) {
        if (3 == i) {
            dXw().nWW.setEnabled(true);
            if (this.blV != null) {
                this.blV.e(!dXw().hgn, true);
            }
            if (this.gWq != null) {
                this.gWq.cH(true);
                return;
            }
            return;
        }
        if (2 == i) {
        }
    }

    public String LU() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gWv != null) {
            this.gWv.setOtherParams(str);
        }
    }

    private boolean bSz() {
        return dXw().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gaF = alaLastLiveroomInfo;
    }
}
