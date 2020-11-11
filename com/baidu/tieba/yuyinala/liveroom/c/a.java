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
    protected com.baidu.live.ad.a gWJ;
    private m gWM;
    k gWN;
    com.baidu.live.im.b.a gWO;
    protected ab gWP;
    protected z gWQ;
    protected aq gXA;
    protected GuardClubInfoHttpResponseMessage gXB;
    boolean gXC;
    boolean gXD;
    boolean gXE;
    public boolean gXG;
    public boolean gXH;
    protected List<d> gXL;
    protected List<com.baidu.live.liveroom.g.b> gXM;
    protected ae gXa;
    private ad gXf;
    protected bo gXn;
    protected com.baidu.live.w.a gXo;
    protected RelativeLayout gXu;
    protected RelativeLayout gXv;
    protected boolean gXx;
    protected AlaLastLiveroomInfo gaY;
    protected com.baidu.tieba.yuyinala.liveroom.f.c nUA;
    protected com.baidu.tieba.yuyinala.liveroom.recommend.a nUB;
    protected com.baidu.tieba.yuyinala.liveroom.e.a nUC;
    private com.baidu.tieba.yuyinala.liveroom.data.a nUo;
    protected com.baidu.tieba.yuyinala.liveroom.operation.a nUp;
    protected com.baidu.tieba.yuyinala.liveroom.share.a nUq;
    protected com.baidu.tieba.yuyinala.liveroom.l.b nUr;
    private com.baidu.tieba.yuyinala.liveroom.f.a nUs;
    protected com.baidu.tieba.yuyinala.liveroom.tippop.a nUt;
    protected com.baidu.live.view.input.d nUu;
    protected com.baidu.tieba.yuyinala.liveroom.b.a nUv;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.b nUw;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.lucky.a nUx;
    protected com.baidu.tieba.yuyinala.liveroom.k.b nUz;
    protected String otherParams;
    private int nUy = 0;
    private int gXw = -1;
    protected int mOrientation = 0;
    protected boolean gXy = false;
    protected boolean gXz = false;
    private CustomMessageListener gXR = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ah ahVar;
            if ((customResponsedMessage.getData() instanceof ah) && (ahVar = (ah) customResponsedMessage.getData()) != null) {
                a.this.a(ahVar.aKv, null, ahVar.aKr, ahVar.aKs, ahVar.aKt, ahVar.aKu);
            }
        }
    };
    private CustomMessageListener gXS = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.vv(7);
        }
    };
    private CustomMessageListener gXT = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bYi();
        }
    };
    private CustomMessageListener gXU = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(a.this.dXx().nVs.Hi().aIV.userId);
            com.baidu.live.view.a.Wx().a(valueOf, new f(a.this.dXx().nVs.Hi().aIV.portrait, valueOf, true, a.this.dXx().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener gXV = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof w) && a.this.nUq != null) {
                a.this.nUq.c((w) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bqR = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.gWN != null) {
                a.this.gWN.g(y.Hc().He());
            }
        }
    };
    private CustomMessageListener gXW = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = a.this.nUo.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                a.this.HQ(str);
            }
        }
    };
    private CustomMessageListener gvb = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.dXx().pageContext.getPageActivity());
            } else if (a.this.nUq != null) {
                a.this.nUq.c(a.this.dXx().nVs.Hi(), false);
            }
        }
    };
    private CustomMessageListener gXX = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof aq) {
                    a.this.gXz = true;
                    a.this.gXA = (aq) data;
                    a.this.b(a.this.gXA);
                } else if (data instanceof com.baidu.live.data.a) {
                    a.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener gXY = new CustomMessageListener(2501060) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(a.this.dXx().nVs.Hi().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(a.this.dXx().nVs.Hi().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(a.this.dXx().nVs.Hi().mLiveInfo.room_id);
                    String valueOf4 = String.valueOf(a.this.dXx().nVs.Hi().aIV.userId);
                    if (a.this.nUr == null) {
                        a.this.nUr = new com.baidu.tieba.yuyinala.liveroom.l.b();
                    }
                    a.this.nUr.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, valueOf4, false, obj);
                    a.this.nUr.a(a.this.nUD);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private h.a nUD = new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.3
    };
    private CustomMessageListener gYa = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                a.this.t((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.5
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
    CustomMessageListener gYb = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gXC = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener gYc = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof cw) {
                if (TextUtils.equals(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()), ((cw) customResponsedMessage.getData()).aSO)) {
                    BdUtilHelper.getCustomToast().showToast(a.this.nUo.pageContext.getString(a.h.yuyin_sdk_redpacket_snatch_host_alert), 1);
                } else {
                    a.this.a((cw) customResponsedMessage.getData());
                }
            }
        }
    };
    private CustomMessageListener gYe = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.C(a.this.dXx().nVs.Hi());
        }
    };
    private CustomMessageListener gYg = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (a.this.gXa != null) {
                    ((com.baidu.tieba.yuyinala.liveroom.k.a) a.this.gXa).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener gYh = new CustomMessageListener(2501031) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                a.this.a(a.this.dXx().nVs.Hi(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener gYj = new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.17
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.bYv();
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener nUE = new CustomMessageListener(2501034) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.20
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

    protected abstract View bXH();

    public abstract boolean bXI();

    protected abstract ViewGroup bXK();

    protected abstract void bXy();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bo boVar) {
        this.gXn = boVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gXu = (RelativeLayout) dXx().nVt.findViewById(a.f.ala_live_header_view);
        this.gXv = (RelativeLayout) dXx().nVt.findViewById(a.f.ala_live_footer_view);
        HY();
        registerListener();
    }

    public void bXP() {
    }

    private void HY() {
        if (this.nUq == null) {
            this.nUq = new com.baidu.tieba.yuyinala.liveroom.share.a(dXx().pageContext);
        }
        this.nUv = new com.baidu.tieba.yuyinala.liveroom.b.a(dXx().pageContext, false);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            if (!TbadkCoreApplication.getInst().isHaokan() || !subappVersionName.startsWith("4.14.")) {
            }
            if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && subappVersionName.startsWith("1.14.")) {
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            }
        }
        this.nUt = new com.baidu.tieba.yuyinala.liveroom.tippop.a(dXx().pageContext, this);
        bXT();
        bXW();
        bYd();
        bYe();
    }

    private void bYd() {
        this.nUw = new com.baidu.tieba.yuyinala.liveroom.turntable.b(dXx().pageContext.getPageActivity());
    }

    private void bXT() {
        this.gWM = new m();
    }

    public void mM(boolean z) {
        this.gXx = z;
    }

    private void bXW() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501037, com.baidu.live.view.input.d.class, dXx().pageContext);
        if (runTask != null && runTask.getData() != null) {
            try {
                this.nUu = (com.baidu.live.view.input.d) runTask.getData();
                this.nUu.a(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.13
                    @Override // com.baidu.live.view.input.d.a
                    public void WS() {
                        a.this.vv(11);
                    }

                    @Override // com.baidu.live.view.input.d.a
                    public void WT() {
                        a.this.eP(11);
                    }

                    @Override // com.baidu.live.view.input.d.a
                    public boolean LM() {
                        return a.this.JM();
                    }

                    @Override // com.baidu.live.view.input.d.a
                    public boolean Mn() {
                        return a.this.bYa();
                    }

                    @Override // com.baidu.live.view.input.d.a
                    public int LR() {
                        return a.this.bYb();
                    }
                });
            } catch (Exception e) {
            }
        }
    }

    void mN(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bYa() {
        w Hi;
        if (dXx() == null || dXx().nVs == null || (Hi = dXx().nVs.Hi()) == null || Hi.aJr == null) {
            return false;
        }
        String str = Hi.aJr.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bYb() {
        w Hi;
        if (dXx() != null && dXx().nVs != null && (Hi = dXx().nVs.Hi()) != null && !ListUtils.isEmpty(Hi.aJA)) {
            for (AlaLiveMarkData alaLiveMarkData : Hi.aJA) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void bYe() {
        this.nUz = new com.baidu.tieba.yuyinala.liveroom.k.b(dXx().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.gXX);
        MessageManager.getInstance().registerListener(this.nUE);
        MessageManager.getInstance().registerListener(this.gXY);
        MessageManager.getInstance().registerListener(this.gYa);
        MessageManager.getInstance().registerListener(this.gXU);
        MessageManager.getInstance().registerListener(this.gXV);
        MessageManager.getInstance().registerListener(this.gvb);
        MessageManager.getInstance().registerListener(this.gXW);
        MessageManager.getInstance().registerListener(this.gvo);
        MessageManager.getInstance().registerListener(this.gYb);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.bqR);
        MessageManager.getInstance().registerListener(this.gYc);
        MessageManager.getInstance().registerListener(this.gYe);
        MessageManager.getInstance().registerListener(this.gYg);
        MessageManager.getInstance().registerListener(this.gYh);
        MessageManager.getInstance().registerListener(this.gXR);
        MessageManager.getInstance().registerListener(this.gXS);
        MessageManager.getInstance().registerListener(this.gXT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean JM() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(dXx().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HQ(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(dXx().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(dXx().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.14
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.aa.a.PQ().bod.aMH;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = dXx().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = dXx().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.15
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(a.this.dXx().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(dXx().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYg() {
        if (this.gWN != null) {
            this.gWN.LK().a(this.nUu.OT(), y.Hc().He(), dXx().nVs.Hi().mLiveInfo);
            mN(true);
            if (this.gXf == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501042, ad.class, dXx().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gXf = (ad) runTask.getData();
                } else {
                    return;
                }
            }
            this.gXf.hk("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.nUC == null) {
            this.nUC = new com.baidu.tieba.yuyinala.liveroom.e.a(dXx().pageContext);
            this.nUC.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.nUC.a(dXx().nVs.Hi(), alaLastLiveroomInfo);
        this.nUC.ax(this.gXv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYh() {
        if (this.gWN != null) {
            this.gWN.LK().hide();
            mN(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String[] strArr, int i, int i2, int i3) {
        if (dXx().nVs.Hi() != null && dXx().nVs.Hi().aIV != null && dXx().nVs.Hi().mLiveInfo != null) {
            a(dXx().nVs.Hi(), strArr, i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, String[] strArr, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(com.baidu.live.b.ab.class) != null && JM()) {
            if (wVar == null) {
                wVar = dXx().nVs.Hi();
            }
            String valueOf = String.valueOf(wVar.aIV.userId);
            String str = wVar.aIV.userName;
            String valueOf2 = String.valueOf(wVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(wVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(wVar.mLiveInfo.feed_id);
            int i6 = wVar.aJr.isBlock;
            String Hr = com.baidu.live.gift.ah.Hr();
            String str2 = wVar.mLiveInfo.appId;
            boolean z2 = wVar.aJr.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (wVar.mLiveInfo.live_type == 1 && wVar.mLiveInfo.screen_direction == 1 && com.baidu.live.aa.a.PQ().bod.aLI) {
                z3 = true;
            }
            int i7 = -1;
            if (wVar.aJr == null) {
                z = false;
            } else {
                boolean z4 = wVar.aJr.isNewUser;
                i7 = wVar.aJr.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.gXB != null && this.gXB.bgz != null && this.gXB.bgz.anchorId == wVar.aIV.userId) {
                z5 = this.gXB.bgC;
            }
            com.baidu.live.b.ab abVar = new com.baidu.live.b.ab(dXx().pageContext.getPageActivity(), strArr, valueOf, str, valueOf2, valueOf3, i6, Hr, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.mAlaLiveSwitchData != null) {
                abVar.bd(wVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            abVar.bb(z);
            if (com.baidu.tieba.yuyinala.liveroom.n.b.dYt().bom != null) {
                abVar.bc(com.baidu.tieba.yuyinala.liveroom.n.b.dYt().bom.aKz != 1);
            }
            bf KH = g.KF().KH();
            if (KH == null || KH.aOV <= 0) {
                i5 = 1000;
            } else {
                i5 = KH.aOV;
            }
            abVar.dG(i5);
            boolean z6 = false;
            if (wVar != null && wVar.aJr != null) {
                String str3 = wVar.aJr.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            abVar.be(z6);
            boolean z7 = true;
            bn bnVar = com.baidu.live.aa.a.PQ().btT;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bnVar != null && bnVar.aPA != null && (!bnVar.aPA.aRW || !bnVar.aPA.aRX || !bnVar.aPA.aRY)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            abVar.bf(z7);
            if (wVar != null && wVar.aJv != null) {
                abVar.gb(wVar.aJv.toJsonString());
            }
            if (!this.gXG) {
                this.gXH = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, abVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYi() {
        eP(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cw cwVar) {
        if (cwVar != null && JM()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ai(dXx().pageContext.getPageActivity(), cwVar.aQw, cwVar.liveId, cwVar.aSO, cwVar.roomId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.aa.a.PQ().bod != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(dXx().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.aa.a.PQ().bod.aNj, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, NobleDetailInfo nobleDetailInfo) {
        if (JM() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (wVar != null) {
                if (wVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(wVar.mLiveInfo.live_id));
                }
                if (wVar.aIV != null) {
                    hashMap.put("anchor_id", Long.valueOf(wVar.aIV.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", s.Hr());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put("day", Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(dXx().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bYj() {
        if (this.nUu != null) {
            this.nUu.d(this.nUo.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bYk() {
        w Hi = dXx().nVs.Hi();
        LogManager.getCommonLogger().doClickQuickImHiLog((Hi == null || Hi.mLiveInfo == null) ? "" : Hi.mLiveInfo.feed_id, MD());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void HR(String str) {
        if (this.nUu != null) {
            this.nUu.hn(str);
        }
    }

    private void bYl() {
        if ("home_rec_play".equals(dXx().fromType) || "frs_play".equals(dXx().fromType) || "frs_live_play".equals(dXx().fromType) || "person_play".equals(dXx().fromType) || "search".equals(dXx().fromType) || "person_attention".equals(dXx().fromType)) {
            com.baidu.live.c.AY().aX(true);
        } else {
            com.baidu.live.c.AY().aX(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mO(boolean z) {
        View GG;
        if (this.gWP == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aUa = false;
            fVar.context = dXx().pageContext.getPageActivity();
            fVar.aUj = z;
            fVar.fromType = dXx().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501040, ab.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWP = (ab) runTask.getData();
            }
        }
        if (this.gWP != null && (GG = this.gWP.GG()) != null && this.nUo.nVt.indexOfChild(GG) < 0) {
            this.nUo.nVt.addView(GG, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYm() {
        View Hu;
        if (this.gXa == null) {
            com.baidu.live.gift.ai aiVar = new com.baidu.live.gift.ai();
            aiVar.aUa = false;
            aiVar.pageContext = dXx().pageContext;
            aiVar.fromType = dXx().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501065, ae.class, aiVar);
            if (runTask != null && runTask.getData() != null) {
                this.gXa = (ae) runTask.getData();
            }
        }
        if (this.gXa != null && (Hu = this.gXa.Hu()) != null && dXx().nVt.indexOfChild(Hu) < 0) {
            if (Hu.getParent() instanceof ViewGroup) {
                ((ViewGroup) Hu.getParent()).removeView(Hu);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = dXx().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            dXx().nVt.addView(Hu, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYn() {
        View Hh;
        if (this.gWQ == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aUa = false;
            aVar.context = dXx().pageContext.getPageActivity();
            aVar.fromType = dXx().fromType;
            aVar.aUb = dXx().hgJ;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501041, z.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWQ = (z) runTask.getData();
            }
        }
        if (this.gWQ != null && (Hh = this.gWQ.Hh()) != null && dXx().nVt.indexOfChild(Hh) < 0) {
            if (Hh.getParent() instanceof ViewGroup) {
                ((ViewGroup) Hh.getParent()).removeView(Hh);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = (BdUtilHelper.getDimens(dXx().pageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(dXx().pageContext.getPageActivity(), a.d.sdk_ds12) : 0)) + BdUtilHelper.getDimens(dXx().pageContext.getPageActivity(), a.d.sdk_ds152) + (dXx().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18) * (-1));
            dXx().nVt.addView(Hh, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bYo() {
        CustomResponsedMessage runTask;
        if (this.gWO == null && (runTask = MessageManager.getInstance().runTask(2501052, com.baidu.live.im.b.a.class, dXx().pageContext)) != null) {
            this.gWO = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gWO != null) {
            this.gWO.setOtherParams(this.otherParams);
            this.gWO.a(new a.InterfaceC0188a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.16
                @Override // com.baidu.live.im.b.a.InterfaceC0188a
                public void Mf() {
                    a.this.bYv();
                }
            });
            this.gWO.a(dXx().nVs.Hi(), false);
            View CK = this.gWO.CK();
            if (CK != null && this.gXv.indexOfChild(CK) < 0) {
                Resources resources = dXx().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(dXx().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.gXv.addView(CK, layoutParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501053));
        }
    }

    private void bYp() {
        if (this.nUs == null) {
            this.nUs = new com.baidu.tieba.yuyinala.liveroom.f.a(dXx().pageContext);
        }
        if (this.gXA != null) {
            this.nUs.HV(this.gXA.user_id);
        }
        this.nUs.ax(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:201:0x0656, code lost:
        HN(r34);
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
                    if (this.bnG != null) {
                        this.bnG.cg(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        vx(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            dXx().nVs.Hi().aJr.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            dXx().nVs.Hi().aJr.isAdmin = 0;
                            dXx().nVs.cgl();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        dXx().nVs.Hi().aJr.isAdmin = 0;
                        dXx().nVs.cgl();
                    }
                } else if ("task".equals(optString2)) {
                    dO(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.nUt != null && !dXx().hgI) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = dXx().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = dXx().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = dXx().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bTg()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.nUt.a(dXx().hgC.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    if (dXx().nVs.Hi() != null && dXx().nVs.Hi().mLiveInfo != null) {
                        dXx().nVs.a(dXx().nVs.Hi().mLiveInfo.live_id, dXx().fromType, dXx().enterTime);
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.yuyinala.liveroom.m.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (dXx().nVs.Hi() != null && dXx().nVs.Hi().aJr != null && dXx().nVs.Hi().aJr.userId == optLong2) {
                        dXx().nVs.Hi().aJr.isBlock = 1;
                        bXy();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (dXx().nVs.Hi() != null && dXx().nVs.Hi().aJr != null && dXx().nVs.Hi().aJr.userId == optLong3) {
                        dXx().nVs.Hi().aJr.isBlock = 0;
                        bXy();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (dXx().nVs.Hi() != null && dXx().nVs.Hi().aJr != null && dXx().nVs.Hi().aJr.userId == optLong4) {
                        dXx().nVs.Hi().aJr.isUegBlock = 1;
                        bXy();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (dXx().nVs.Hi() != null && dXx().nVs.Hi().aJr != null && dXx().nVs.Hi().aJr.userId == optLong5) {
                        dXx().nVs.Hi().aJr.isUegBlock = 0;
                        bXy();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (dXx() != null && dXx().nVs != null && dXx().nVs.Hi() != null && dXx().nVs.Hi().aJr != null) {
                        if (dXx().nVs.Hi().aJr.userId == jSONObject2.optLong("user_id")) {
                            dXx().nVs.cgl();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, dXx().nVs.Hi().aJr));
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
                    com.baidu.live.data.a Mo = aVar.Mo();
                    if (Mo != null && com.baidu.live.gift.ah.hg(str3)) {
                        com.baidu.live.gift.ah.d(str3, 1L, "", "", Mo.userId, Mo.portrait, Mo.userName, "", "", false, "", "", "", false, false, true, -1L, aVar.bku);
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
            com.baidu.live.data.a Mo2 = aVar.Mo();
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
            if (dXx().nVs == null || dXx().nVs.Hi() == null || dXx().nVs.Hi().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j4 = dXx().nVs.Hi().mLiveInfo.live_id;
                long j5 = dXx().nVs.Hi().mLiveInfo.group_id;
                long j6 = dXx().nVs.Hi().aIV.userId;
                str4 = dXx().nVs.Hi().mLiveInfo.appId;
                j = j6;
                j2 = j4;
                j3 = j5;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    com.baidu.live.gift.ah.b(optString9, Mo2.userId, Mo2.portrait, Mo2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "", aVar.getMsgId(), aVar.bku);
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                } else if (com.baidu.live.aa.f.Qg().hZ(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                com.baidu.live.gift.ah.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, Mo2.userId, Mo2.portrait, Mo2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString7, "", "", aVar.getMsgId(), aVar.bku, z2);
                HN(optString3);
            }
            com.baidu.tieba.yuyinala.liveroom.h.c cVar = new com.baidu.tieba.yuyinala.liveroom.h.c();
            cVar.hgk = optLong7;
            cVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
        }
    }

    protected void HN(String str) {
    }

    void bYv() {
        if (bYw()) {
            BdUtilHelper.hideSoftKeyPad(dXx().pageContext.getPageActivity(), dXx().hgC.getLiveContainerView());
            bXI();
        }
    }

    private boolean bYw() {
        if (bXH() == null || bXH().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        CustomResponsedMessage runTask;
        dXx().nVt.setOnTouchListener(this.gYj);
        bYG();
        bYp();
        if (this.gWM != null) {
            this.gWM.g(dXx().nVs.Hi());
        }
        if (this.nUu != null) {
            this.nUu.b(dXx().nVs.Hi(), MD());
        }
        if (dXx().nVt != null) {
            dXx().nVt.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.18
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    return a.this.Q(motionEvent);
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Oa() {
                    if (a.this.gXM == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : a.this.gXM) {
                        if (bVar.Oa()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            dXx().nVt.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.19
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return a.this.P(motionEvent);
                }
            });
        }
        if (this.gXf == null && (runTask = MessageManager.getInstance().runTask(2501042, ad.class, dXx().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gXf = (ad) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYy() {
        w Hi;
        ViewGroup viewGroup;
        if (dXx() != null && dXx().nVs != null && (Hi = dXx().nVs.Hi()) != null && Hi.mLiveInfo != null && Hi.aJR && (viewGroup = (ViewGroup) dXx().hgC) != null) {
            if (this.nUB == null) {
                this.nUB = new com.baidu.tieba.yuyinala.liveroom.recommend.a(dXx().pageContext);
            }
            this.nUB.n(Hi);
            this.nUB.a(dXx().nVt);
            this.nUB.ax(viewGroup);
            a((com.baidu.live.liveroom.g.d) this.nUB);
            a((com.baidu.live.liveroom.g.b) this.nUB);
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.gXL == null) {
            this.gXL = new ArrayList();
        }
        if (!this.gXL.contains(dVar)) {
            this.gXL.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.gXL != null && this.gXL.contains(dVar)) {
            this.gXL.remove(dVar);
        }
    }

    protected void bYz() {
        if (this.gXL != null) {
            this.gXL.clear();
            this.gXL = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gXL == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.gXL.iterator();
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
        if (this.gXM == null) {
            this.gXM = new ArrayList();
        }
        if (!this.gXM.contains(bVar)) {
            this.gXM.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.gXM != null && this.gXM.contains(bVar)) {
            this.gXM.remove(bVar);
        }
    }

    protected void bYA() {
        if (this.gXM != null) {
            this.gXM.clear();
            this.gXM = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gXM == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.gXM.iterator();
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
    public void bYB() {
        if (this.nUA == null && this.gXn != null && this.gXn.aPK && dXx() != null && dXx().nVs != null && dXx().nVs.Hi() != null) {
            this.nUA = new com.baidu.tieba.yuyinala.liveroom.f.c(dXx().pageContext, this.gXn);
            this.nUA.E(dXx().nVs.Hi());
            if (this.gXn.aPN == 1) {
                if (this.gWN != null) {
                    this.gXD = true;
                }
            } else if (this.gXn.aPN == 2) {
                a(dXx().nVs.Hi(), null, -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYC() {
        CustomResponsedMessage runTask;
        if (dXx() != null && (runTask = MessageManager.getInstance().runTask(2501047, k.class, dXx().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.w.a)) {
            this.gXo = (com.baidu.live.w.a) runTask.getData();
            this.gXo.t(bXK());
            if (dXx().nVs != null) {
                this.gXE = this.gXo.o(dXx().nVs.Hi());
            }
            this.gXo.setCanVisible(!this.gXy);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int M(boolean z, boolean z2) {
        Rect rect = new Rect();
        dXx().hgC.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(dXx().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(dXx().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? dXx().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + dXx().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? dXx().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds192) : 0) + dXx().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds32);
    }

    private void bYG() {
        if (this.gWJ == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ad.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.gWJ = (com.baidu.live.ad.a) runTask.getData();
            }
            bYH();
        }
    }

    private void dO(JSONObject jSONObject) {
        if (this.gWJ != null) {
            this.gWJ.cF(true);
            this.gWJ.V(jSONObject);
        }
    }

    private void bYH() {
        if (this.gWJ != null && dXx().nVs.Hi() != null && dXx().nVs.Hi().aJE != null) {
            this.gWJ.cF(true);
            this.gWJ.i(dXx().nVs.Hi());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        if (wVar != null) {
            bYH();
            if (this.nUs != null && wVar.aIV != null) {
                this.nUs.HV(String.valueOf(wVar.aIV.userId));
            }
            if (this.gWQ != null && wVar.mLiveInfo != null) {
                this.gWQ.a(wVar.mLiveInfo, wVar.aIV);
            }
            if (this.gWO != null) {
                this.gWO.a(wVar);
            }
            if (this.gXo != null) {
                this.gXE = this.gXo.o(wVar);
            }
            vx(wVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void vx(int i) {
        if (!dXx().hgI) {
            if (this.gXw < 0 && i == 0) {
                this.gXw = i;
            } else if (this.gXw != i) {
                if (i == 1) {
                    if (!this.nUt.wl(2)) {
                        String string = dXx().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(dXx().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.nUt.a(dXx().hgC.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = dXx().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.nUt.wm(2);
                    this.nUt.wm(3);
                    if (bTg()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.nUt.a(dXx().hgC.getLiveContainerView(), string2, 3);
                    }
                }
                this.gXw = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cj(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.cj(z);
        if (z) {
            bYI();
        }
        if (this.nUq != null) {
            this.nUq.Dm();
        }
        if (this.gWJ != null) {
            this.gWJ.onDestroy();
            this.gWJ = null;
        }
        if (this.gWP != null) {
            View GG = this.gWP.GG();
            if (GG != null && GG.getParent() != null) {
                ((ViewGroup) GG.getParent()).removeView(GG);
            }
            this.gWP.onDestroy();
            this.gWP = null;
        }
        if (this.gWO != null) {
            this.gWO.a((a.InterfaceC0188a) null);
            this.gWO.CM();
        }
        if (this.nUt != null) {
            this.nUt.Dm();
        }
        this.gXw = -1;
        if (this.nUs != null) {
            this.nUs.Dm();
            this.nUs.onDestroy();
        }
        if (this.nUv != null) {
            this.nUv.bWZ();
            this.nUv.Ht();
        }
        if (this.gWM != null) {
            this.gWM.Ht();
        }
        if (this.nUu != null) {
            this.nUu.Ht();
        }
        if (this.nUA != null) {
            this.nUA.onDestroy();
        }
        if (this.gXf != null) {
            this.gXf.Ht();
        }
        if (this.nUr != null) {
            this.nUr.onDestory();
        }
        if (this.gXo != null) {
            this.gXo.Ht();
        }
        if (this.nUz != null) {
            this.nUz.Ht();
        }
        if (this.gXa != null) {
            this.gXa.onDestroy();
        }
        if (this.nUB != null) {
            this.nUB.Dm();
            b((com.baidu.live.liveroom.g.d) this.nUB);
            b((com.baidu.live.liveroom.g.b) this.nUB);
        }
        ShowUtil.windowCount = 0;
        bYz();
        bYA();
    }

    private void bYI() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = dXx().nVt.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = dXx().nVt.getChildAt(i);
            if (childAt != this.gXu && childAt != this.gXv) {
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
        if (this.gXu != null) {
            this.gXu.removeAllViews();
        }
        if (this.gXv != null) {
            this.gXv.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, w wVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        View CK;
        View GG;
        if (this.gWP != null && (GG = this.gWP.GG()) != null && GG.getParent() != null) {
            ((ViewGroup) GG.getParent()).removeView(GG);
        }
        if (this.gWO != null && (CK = this.gWO.CK()) != null && CK.getParent() != null) {
            ((ViewGroup) CK.getParent()).removeView(CK);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean NW() {
        bYl();
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void ch(boolean z) {
        super.ch(z);
        if (this.gWJ != null) {
            this.gWJ.onDestroy();
            this.gWJ = null;
        }
        if (this.gWP != null) {
            this.gWP.onDestroy();
            this.gWP = null;
        }
        if (this.gWQ != null) {
            this.gWQ.onDestroy();
            this.gWQ = null;
        }
        if (this.nUt != null) {
            this.nUt.onDestroy();
        }
        if (this.nUq != null) {
            this.nUq.onDestroy();
        }
        if (this.gXa != null) {
            this.gXa.onDestroy();
            this.gXa = null;
        }
        if (this.gWO != null) {
            this.gWO.a((a.InterfaceC0188a) null);
            this.gWO.release();
            this.gWO = null;
        }
        if (this.nUu != null) {
            this.nUu.a(null);
            this.nUu.release();
        }
        if (this.nUA != null) {
            this.nUA.onDestroy();
        }
        if (this.nUz != null) {
            this.nUz.release();
        }
        if (this.gXf != null) {
            this.gXf.release();
        }
        if (this.nUr != null) {
            this.nUr.onDestory();
        }
        if (this.gXo != null) {
            this.gXo.release();
        }
        if (this.nUB != null) {
            this.nUB.onDestroy();
            b((com.baidu.live.liveroom.g.d) this.nUB);
            b((com.baidu.live.liveroom.g.b) this.nUB);
        }
        bYz();
        bYA();
        MessageManager.getInstance().unRegisterListener(this.gXR);
        MessageManager.getInstance().unRegisterListener(this.gXS);
        MessageManager.getInstance().unRegisterListener(this.gXT);
        MessageManager.getInstance().unRegisterListener(this.gXX);
        MessageManager.getInstance().unRegisterListener(this.gXY);
        MessageManager.getInstance().unRegisterListener(this.nUE);
        MessageManager.getInstance().unRegisterListener(this.gYa);
        MessageManager.getInstance().unRegisterListener(this.gXU);
        MessageManager.getInstance().unRegisterListener(this.gXV);
        MessageManager.getInstance().unRegisterListener(this.gvb);
        MessageManager.getInstance().unRegisterListener(this.gXW);
        MessageManager.getInstance().unRegisterListener(this.gvo);
        MessageManager.getInstance().unRegisterListener(this.gYb);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.bqR);
        MessageManager.getInstance().unRegisterListener(this.gYc);
        MessageManager.getInstance().unRegisterListener(this.gYe);
        MessageManager.getInstance().unRegisterListener(this.gYg);
        MessageManager.getInstance().unRegisterListener(this.gYh);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        bXI();
        if (this.nUz != null) {
            this.nUz.pause();
        }
        if (this.gXa != null) {
            this.gXa.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.gXH = false;
        if (this.gXz && this.gXA != null) {
            a(this.gXA);
            this.gXz = false;
        }
        if (this.nUz != null) {
            this.nUz.resume();
        }
        if (this.gXa != null) {
            this.gXa.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avS() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.nUB != null && this.nUB.isOpen()) {
            this.nUB.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            avS();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    a(null, -1, -1, -1);
                    return;
                }
                return;
            }
            avS();
        } else if (i == 25034) {
            bYi();
        } else if (i == 25043 && i2 == -1) {
            bYL();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.gXy = z;
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
        if (this.nUr != null) {
            this.nUr.biM();
        }
        if (this.nUB != null) {
            this.nUB.D(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        this.nUo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.yuyinala.liveroom.data.a dXx() {
        return this.nUo;
    }

    private void bYL() {
        String KG = g.KF().KG();
        if (!TextUtils.isEmpty(KG)) {
            try {
                a(null, -1, Integer.parseInt(KG), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                a(null, -1, -1, -1);
            }
        }
    }

    @Override // com.baidu.live.liveroom.a.a
    public boolean eO(int i) {
        if (1 == i) {
            if (bXH() != null) {
                bXH().setVisibility(8);
                return true;
            }
            return true;
        } else if (2 == i) {
            return !this.gXy;
        } else if (3 == i) {
            if (dXx().nVt == null) {
                return false;
            }
            dXx().nVt.setEnabled(false);
            if (this.bnG != null) {
                this.bnG.e(!dXx().hgG, false);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    public void vv(int i) {
    }

    @Override // com.baidu.live.liveroom.a.a
    public void eP(int i) {
        if (3 == i) {
            dXx().nVt.setEnabled(true);
            if (this.bnG != null) {
                this.bnG.e(!dXx().hgG, true);
            }
            if (this.gWJ != null) {
                this.gWJ.cF(true);
                return;
            }
            return;
        }
        if (2 == i) {
        }
    }

    public String MD() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gWO != null) {
            this.gWO.setOtherParams(str);
        }
    }

    private boolean bTg() {
        return dXx().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gaY = alaLastLiveroomInfo;
    }
}
