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
import com.baidu.live.d.ac;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.ai;
import com.baidu.live.data.ar;
import com.baidu.live.data.bb;
import com.baidu.live.data.bg;
import com.baidu.live.data.bo;
import com.baidu.live.data.bp;
import com.baidu.live.data.cy;
import com.baidu.live.data.f;
import com.baidu.live.data.w;
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
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.utils.s;
import com.baidu.live.view.input.e;
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
    protected AlaLastLiveroomInfo giQ;
    protected com.baidu.live.ah.a hfQ;
    private m hfT;
    k hfU;
    com.baidu.live.im.b.a hfV;
    protected ad hfW;
    protected ab hfX;
    protected RelativeLayout hgE;
    protected RelativeLayout hgF;
    protected boolean hgH;
    protected ar hgK;
    protected GuardClubInfoHttpResponseMessage hgL;
    boolean hgM;
    boolean hgN;
    boolean hgO;
    public boolean hgQ;
    public boolean hgR;
    protected List<d> hgV;
    protected List<com.baidu.live.liveroom.g.b> hgW;
    protected ag hgi;
    private af hgm;
    protected bp hgw;
    protected com.baidu.live.aa.a hgx;
    private com.baidu.tieba.yuyinala.liveroom.data.a okP;
    protected com.baidu.tieba.yuyinala.liveroom.operation.a okQ;
    protected com.baidu.tieba.yuyinala.liveroom.share.a okR;
    protected com.baidu.tieba.yuyinala.liveroom.l.b okS;
    private com.baidu.tieba.yuyinala.liveroom.f.a okT;
    protected com.baidu.tieba.yuyinala.liveroom.tippop.a okU;
    protected e okV;
    protected com.baidu.tieba.yuyinala.liveroom.b.a okW;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.b okX;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.lucky.a okY;
    protected com.baidu.tieba.yuyinala.liveroom.k.b ola;
    protected com.baidu.tieba.yuyinala.liveroom.f.c olb;
    protected com.baidu.tieba.yuyinala.liveroom.recommend.a olc;
    protected com.baidu.tieba.yuyinala.liveroom.e.a old;
    protected String otherParams;
    private int okZ = 0;
    private int hgG = -1;
    protected int mOrientation = 0;
    protected boolean hgI = false;
    protected boolean hgJ = false;
    private CustomMessageListener hhb = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ai aiVar;
            if ((customResponsedMessage.getData() instanceof ai) && (aiVar = (ai) customResponsedMessage.getData()) != null) {
                a.this.a(aiVar.aLD, null, aiVar.aLz, aiVar.aLA, aiVar.aLB, aiVar.aLC);
            }
        }
    };
    private CustomMessageListener hhc = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.wy(7);
        }
    };
    private CustomMessageListener hhd = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.cbs();
        }
    };
    private CustomMessageListener hhe = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(a.this.eda().olT.Iq().aJV.userId);
            com.baidu.live.view.a.Yo().a(valueOf, new f(a.this.eda().olT.Iq().aJV.portrait, valueOf, true, a.this.eda().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener hhf = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof w) && a.this.okR != null) {
                a.this.okR.c((w) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener buq = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hfU != null) {
                a.this.hfU.g(z.Ii().Ik());
            }
        }
    };
    private CustomMessageListener hhg = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = a.this.okP.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                a.this.Ig(str);
            }
        }
    };
    private CustomMessageListener gDr = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.eda().pageContext.getPageActivity());
            } else if (a.this.okR != null) {
                a.this.okR.c(a.this.eda().olT.Iq(), false);
            }
        }
    };
    private CustomMessageListener hhh = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ar) {
                    a.this.hgJ = true;
                    a.this.hgK = (ar) data;
                    a.this.b(a.this.hgK);
                } else if (data instanceof com.baidu.live.data.a) {
                    a.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener hhi = new CustomMessageListener(2501060) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(a.this.eda().olT.Iq().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(a.this.eda().olT.Iq().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(a.this.eda().olT.Iq().mLiveInfo.room_id);
                    String valueOf4 = String.valueOf(a.this.eda().olT.Iq().aJV.userId);
                    if (a.this.okS == null) {
                        a.this.okS = new com.baidu.tieba.yuyinala.liveroom.l.b();
                    }
                    a.this.okS.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, valueOf4, false, obj);
                    a.this.okS.a(a.this.ole);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private h.a ole = new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.3
    };
    private CustomMessageListener hhk = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                a.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.5
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
    CustomMessageListener hhl = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.hgM = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener hhm = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof cy) {
                if (TextUtils.equals(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()), ((cy) customResponsedMessage.getData()).aUf)) {
                    BdUtilHelper.getCustomToast().showToast(a.this.okP.pageContext.getString(a.h.yuyin_sdk_redpacket_snatch_host_alert), 1);
                } else {
                    a.this.a((cy) customResponsedMessage.getData());
                }
            }
        }
    };
    private CustomMessageListener hhn = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.H(a.this.eda().olT.Iq());
        }
    };
    private CustomMessageListener hhr = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (a.this.hgi != null) {
                    ((com.baidu.tieba.yuyinala.liveroom.k.a) a.this.hgi).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hhs = new CustomMessageListener(2501031) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                a.this.a(a.this.eda().olT.Iq(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener hhu = new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.17
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.cbH();
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener olf = new CustomMessageListener(2501034) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinSupportRoomMessage) {
                a.this.a(null, -1, -1, -1);
            }
        }
    };

    protected abstract void a(ar arVar);

    protected abstract void b(ar arVar);

    protected abstract void caH();

    protected abstract View caR();

    public abstract boolean caS();

    protected abstract ViewGroup caU();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bp bpVar) {
        this.hgw = bpVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hgE = (RelativeLayout) eda().olU.findViewById(a.f.ala_live_header_view);
        this.hgF = (RelativeLayout) eda().olU.findViewById(a.f.ala_live_footer_view);
        Jg();
        registerListener();
    }

    public void caZ() {
    }

    private void Jg() {
        if (this.okR == null) {
            this.okR = new com.baidu.tieba.yuyinala.liveroom.share.a(eda().pageContext);
        }
        this.okW = new com.baidu.tieba.yuyinala.liveroom.b.a(eda().pageContext, false);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            if (!TbadkCoreApplication.getInst().isHaokan() || !subappVersionName.startsWith("4.14.")) {
            }
            if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && subappVersionName.startsWith("1.14.")) {
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            }
        }
        this.okU = new com.baidu.tieba.yuyinala.liveroom.tippop.a(eda().pageContext, this);
        cbc();
        cbf();
        cbm();
        cbn();
    }

    private void cbm() {
        this.okX = new com.baidu.tieba.yuyinala.liveroom.turntable.b(eda().pageContext.getPageActivity());
    }

    private void cbc() {
        this.hfT = new m();
    }

    public void nh(boolean z) {
        this.hgH = z;
    }

    private void cbf() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501037, e.class, eda().pageContext);
        if (runTask != null && runTask.getData() != null) {
            try {
                this.okV = (e) runTask.getData();
                this.okV.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.13
                    @Override // com.baidu.live.view.input.e.a
                    public void YJ() {
                        a.this.wy(11);
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public void YK() {
                        a.this.fi(11);
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public boolean Nh() {
                        return a.this.Le();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public boolean NR() {
                        return a.this.cbj();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public int Nm() {
                        return a.this.cbk();
                    }
                });
            } catch (Exception e) {
            }
        }
    }

    void ni(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cbj() {
        w Iq;
        if (eda() == null || eda().olT == null || (Iq = eda().olT.Iq()) == null || Iq.aKr == null) {
            return false;
        }
        String str = Iq.aKr.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int cbk() {
        w Iq;
        if (eda() != null && eda().olT != null && (Iq = eda().olT.Iq()) != null && !ListUtils.isEmpty(Iq.aKB)) {
            for (AlaLiveMarkData alaLiveMarkData : Iq.aKB) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void cbn() {
        this.ola = new com.baidu.tieba.yuyinala.liveroom.k.b(eda().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.hhh);
        MessageManager.getInstance().registerListener(this.olf);
        MessageManager.getInstance().registerListener(this.hhi);
        MessageManager.getInstance().registerListener(this.hhk);
        MessageManager.getInstance().registerListener(this.hhe);
        MessageManager.getInstance().registerListener(this.hhf);
        MessageManager.getInstance().registerListener(this.gDr);
        MessageManager.getInstance().registerListener(this.hhg);
        MessageManager.getInstance().registerListener(this.gDE);
        MessageManager.getInstance().registerListener(this.hhl);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.buq);
        MessageManager.getInstance().registerListener(this.hhm);
        MessageManager.getInstance().registerListener(this.hhn);
        MessageManager.getInstance().registerListener(this.hhr);
        MessageManager.getInstance().registerListener(this.hhs);
        MessageManager.getInstance().registerListener(this.hhb);
        MessageManager.getInstance().registerListener(this.hhc);
        MessageManager.getInstance().registerListener(this.hhd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Le() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(eda().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ig(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(eda().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(eda().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.14
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.RB().brA.aNR;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = eda().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = eda().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.15
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(a.this.eda().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(eda().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbp() {
        if (this.hfU != null) {
            this.hfU.Ne().a(this.okV.QD(), z.Ii().Ik(), eda().olT.Iq().mLiveInfo);
            ni(true);
            if (this.hgm == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501042, af.class, eda().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hgm = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgm.hz("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.old == null) {
            this.old = new com.baidu.tieba.yuyinala.liveroom.e.a(eda().pageContext);
            this.old.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.old.a(eda().olT.Iq(), alaLastLiveroomInfo);
        this.old.at(this.hgF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbr() {
        if (this.hfU != null) {
            this.hfU.Ne().hide();
            ni(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String[] strArr, int i, int i2, int i3) {
        if (eda().olT.Iq() != null && eda().olT.Iq().aJV != null && eda().olT.Iq().mLiveInfo != null) {
            a(eda().olT.Iq(), strArr, i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, String[] strArr, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(ac.class) != null && Le()) {
            if (wVar == null) {
                wVar = eda().olT.Iq();
            }
            String valueOf = String.valueOf(wVar.aJV.userId);
            String str = wVar.aJV.userName;
            String valueOf2 = String.valueOf(wVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(wVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(wVar.mLiveInfo.feed_id);
            int i6 = wVar.aKr.isBlock;
            String Iz = aj.Iz();
            String str2 = wVar.mLiveInfo.appId;
            boolean z2 = wVar.aKr.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (wVar.mLiveInfo.live_type == 1 && wVar.mLiveInfo.screen_direction == 1 && com.baidu.live.ae.a.RB().brA.aMS) {
                z3 = true;
            }
            int i7 = -1;
            if (wVar.aKr == null) {
                z = false;
            } else {
                boolean z4 = wVar.aKr.isNewUser;
                i7 = wVar.aKr.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.hgL != null && this.hgL.bja != null && this.hgL.bja.anchorId == wVar.aJV.userId) {
                z5 = this.hgL.bjf;
            }
            ac acVar = new ac(eda().pageContext.getPageActivity(), strArr, valueOf, str, valueOf2, valueOf3, i6, Iz, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.mAlaLiveSwitchData != null) {
                acVar.bn(wVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            acVar.bl(z);
            if (com.baidu.tieba.yuyinala.liveroom.n.b.edW().brJ != null) {
                acVar.bm(com.baidu.tieba.yuyinala.liveroom.n.b.edW().brJ.aLH != 1);
            }
            bg Mb = g.LZ().Mb();
            if (Mb == null || Mb.aQj <= 0) {
                i5 = 1000;
            } else {
                i5 = Mb.aQj;
            }
            acVar.dV(i5);
            boolean z6 = false;
            if (wVar != null && wVar.aKr != null) {
                String str3 = wVar.aKr.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            acVar.bo(z6);
            boolean z7 = true;
            bo boVar = com.baidu.live.ae.a.RB().bxq;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (boVar != null && boVar.aQP != null && (!boVar.aQP.aTn || !boVar.aQP.aTo || !boVar.aQP.aTp)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            acVar.bp(z7);
            if (wVar != null && wVar.aKu != null) {
                acVar.gq(wVar.aKu.toJsonString());
            }
            if (!this.hgQ) {
                this.hgR = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, acVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbs() {
        fi(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cy cyVar) {
        if (cyVar != null && Le()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.aj(eda().pageContext.getPageActivity(), cyVar.aRN, cyVar.liveId, cyVar.aUf, cyVar.roomId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.ae.a.RB().brA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(eda().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.ae.a.RB().brA.aOt, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, NobleDetailInfo nobleDetailInfo) {
        if (Le() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (wVar != null) {
                if (wVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(wVar.mLiveInfo.live_id));
                }
                if (wVar.aJV != null) {
                    hashMap.put("anchor_id", Long.valueOf(wVar.aJV.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", s.Iz());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put("day", Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(eda().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbt() {
        if (this.okV != null) {
            this.okV.d(this.okP.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbu() {
        w Iq = eda().olT.Iq();
        LogManager.getCommonLogger().doClickQuickImHiLog((Iq == null || Iq.mLiveInfo == null) ? "" : Iq.mLiveInfo.feed_id, Oj());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ih(String str) {
        if (this.okV != null) {
            this.okV.hC(str);
        }
    }

    private void cbv() {
        if ("home_rec_play".equals(eda().fromType) || "frs_play".equals(eda().fromType) || "frs_live_play".equals(eda().fromType) || "person_play".equals(eda().fromType) || "search".equals(eda().fromType) || "person_attention".equals(eda().fromType)) {
            com.baidu.live.c.BL().bc(true);
        } else {
            com.baidu.live.c.BL().bc(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nj(boolean z) {
        View HM;
        if (this.hfW == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aVr = false;
            fVar.context = eda().pageContext.getPageActivity();
            fVar.aVA = z;
            fVar.fromType = eda().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501040, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hfW = (ad) runTask.getData();
            }
        }
        if (this.hfW != null && (HM = this.hfW.HM()) != null && this.okP.olU.indexOfChild(HM) < 0) {
            this.okP.olU.addView(HM, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbw() {
        View IC;
        if (this.hgi == null) {
            ak akVar = new ak();
            akVar.aVr = false;
            akVar.pageContext = eda().pageContext;
            akVar.fromType = eda().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501065, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hgi = (ag) runTask.getData();
            }
        }
        if (this.hgi != null && (IC = this.hgi.IC()) != null && eda().olU.indexOfChild(IC) < 0) {
            if (IC.getParent() instanceof ViewGroup) {
                ((ViewGroup) IC.getParent()).removeView(IC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = eda().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            eda().olU.addView(IC, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbx() {
        View Ip;
        if (this.hfX == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aVr = false;
            aVar.context = eda().pageContext.getPageActivity();
            aVar.fromType = eda().fromType;
            aVar.aVs = eda().hpX;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501041, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hfX = (ab) runTask.getData();
            }
        }
        if (this.hfX != null && (Ip = this.hfX.Ip()) != null && eda().olU.indexOfChild(Ip) < 0) {
            if (Ip.getParent() instanceof ViewGroup) {
                ((ViewGroup) Ip.getParent()).removeView(Ip);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = (BdUtilHelper.getDimens(eda().pageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(eda().pageContext.getPageActivity(), a.d.sdk_ds12) : 0)) + BdUtilHelper.getDimens(eda().pageContext.getPageActivity(), a.d.sdk_ds152) + (eda().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18) * (-1));
            eda().olU.addView(Ip, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cby() {
        CustomResponsedMessage runTask;
        if (this.hfV == null && (runTask = MessageManager.getInstance().runTask(2501052, com.baidu.live.im.b.a.class, eda().pageContext)) != null) {
            this.hfV = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hfV != null) {
            this.hfV.setOtherParams(this.otherParams);
            this.hfV.a(new a.InterfaceC0193a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.16
                @Override // com.baidu.live.im.b.a.InterfaceC0193a
                public void NJ() {
                    a.this.cbH();
                }
            });
            this.hfV.a(eda().olT.Iq(), false);
            View DL = this.hfV.DL();
            if (DL != null && this.hgF.indexOfChild(DL) < 0) {
                Resources resources = eda().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(eda().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.hgF.addView(DL, layoutParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501053));
        }
    }

    private void cbz() {
        if (this.okT == null) {
            this.okT = new com.baidu.tieba.yuyinala.liveroom.f.a(eda().pageContext);
        }
        if (this.hgK != null) {
            this.okT.Il(this.hgK.user_id);
        }
        this.okT.at(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:201:0x0656, code lost:
        Ic(r34);
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject optJSONObject;
        long j;
        long j2;
        long j3;
        JSONObject jSONObject4;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject4 = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject4 = new JSONObject(bVar.getContent());
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
                if (bVar.getMsgType() != 12) {
                }
                if (jSONObject2 == null) {
                }
            }
        } catch (JSONException e2) {
            jSONObject = null;
        }
        if (bVar.getMsgType() != 12 || bVar.getMsgType() == 13) {
            if (jSONObject2 == null) {
                String optString2 = jSONObject2.optString("content_type");
                if ("live_on_private".equals(optString2)) {
                    boolean z = jSONObject2.optInt("on_private", 0) == 1;
                    if (this.brc != null) {
                        this.brc.cw(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        wA(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            eda().olT.Iq().aKr.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            eda().olT.Iq().aKr.isAdmin = 0;
                            eda().olT.cjy();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        eda().olT.Iq().aKr.isAdmin = 0;
                        eda().olT.cjy();
                    }
                } else if ("task".equals(optString2)) {
                    dK(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.okU != null && !eda().hpW) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = eda().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = eda().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = eda().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bWj()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.okU.a(eda().hpQ.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    if (eda().olT.Iq() != null && eda().olT.Iq().mLiveInfo != null) {
                        eda().olT.a(eda().olT.Iq().mLiveInfo.live_id, eda().fromType, eda().enterTime);
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.yuyinala.liveroom.m.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (eda().olT.Iq() != null && eda().olT.Iq().aKr != null && eda().olT.Iq().aKr.userId == optLong2) {
                        eda().olT.Iq().aKr.isBlock = 1;
                        caH();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (eda().olT.Iq() != null && eda().olT.Iq().aKr != null && eda().olT.Iq().aKr.userId == optLong3) {
                        eda().olT.Iq().aKr.isBlock = 0;
                        caH();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (eda().olT.Iq() != null && eda().olT.Iq().aKr != null && eda().olT.Iq().aKr.userId == optLong4) {
                        eda().olT.Iq().aKr.isUegBlock = 1;
                        caH();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (eda().olT.Iq() != null && eda().olT.Iq().aKr != null && eda().olT.Iq().aKr.userId == optLong5) {
                        eda().olT.Iq().aKr.isUegBlock = 0;
                        caH();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (eda() != null && eda().olT != null && eda().olT.Iq() != null && eda().olT.Iq().aKr != null) {
                        if (eda().olT.Iq().aKr.userId == jSONObject2.optLong("user_id")) {
                            eda().olT.cjy();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, eda().olT.Iq().aKr));
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
                    com.baidu.live.data.a NU = bVar.NU();
                    if (NU != null && aj.hv(str3)) {
                        aj.d(str3, 1L, "", "", NU.userId, NU.portrait, NU.userName, "", "", false, "", "", "", false, false, true, -1L, bVar.bnb);
                    }
                } else if ("challenge_mvp".equals(optString2)) {
                    if (jSONObject2 != null) {
                        bb bbVar = new bb();
                        bbVar.parseJson(jSONObject2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, bbVar));
                    }
                } else if (TextUtils.equals(optString2, "challenge_mvp_punish")) {
                    if (jSONObject2 != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject2));
                    }
                } else if (TextUtils.equals(optString2, "send_redpacket") && (optJSONObject = jSONObject2.optJSONObject("live_redpacket")) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913221, new RedPacketCharmInfo(optJSONObject)));
                }
            }
        } else if (bVar.getMsgType() != 125 && bVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a NU2 = bVar.NU();
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
            if (eda().olT == null || eda().olT.Iq() == null || eda().olT.Iq().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j4 = eda().olT.Iq().mLiveInfo.live_id;
                long j5 = eda().olT.Iq().mLiveInfo.group_id;
                long j6 = eda().olT.Iq().aJV.userId;
                str4 = eda().olT.Iq().mLiveInfo.appId;
                j = j6;
                j2 = j4;
                j3 = j5;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    aj.b(optString9, NU2.userId, NU2.portrait, NU2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "", bVar.getMsgId(), bVar.bnb);
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                } else if (com.baidu.live.ae.f.RR().ix(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                aj.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, NU2.userId, NU2.portrait, NU2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString7, "", "", bVar.getMsgId(), bVar.bnb, z2);
                Ic(optString3);
            }
            com.baidu.tieba.yuyinala.liveroom.h.c cVar = new com.baidu.tieba.yuyinala.liveroom.h.c();
            cVar.boX = optLong7;
            cVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
        }
    }

    protected void Ic(String str) {
    }

    void cbH() {
        if (cbI()) {
            BdUtilHelper.hideSoftKeyPad(eda().pageContext.getPageActivity(), eda().hpQ.getLiveContainerView());
            caS();
        }
    }

    private boolean cbI() {
        if (caR() == null || caR().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        CustomResponsedMessage runTask;
        eda().olU.setOnTouchListener(this.hhu);
        cbS();
        cbz();
        if (this.hfT != null) {
            this.hfT.g(eda().olT.Iq());
        }
        if (this.okV != null) {
            this.okV.b(eda().olT.Iq(), Oj());
        }
        if (eda().olU != null) {
            eda().olU.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.18
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    return a.this.Q(motionEvent);
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean PK() {
                    if (a.this.hgW == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : a.this.hgW) {
                        if (bVar.PK()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            eda().olU.setLiveViewOnTouchEventListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.19
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return a.this.P(motionEvent);
                }
            });
        }
        if (this.hgm == null && (runTask = MessageManager.getInstance().runTask(2501042, af.class, eda().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hgm = (af) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbK() {
        w Iq;
        ViewGroup viewGroup;
        if (eda() != null && eda().olT != null && (Iq = eda().olT.Iq()) != null && Iq.mLiveInfo != null && Iq.aKS && (viewGroup = (ViewGroup) eda().hpQ) != null) {
            if (this.olc == null) {
                this.olc = new com.baidu.tieba.yuyinala.liveroom.recommend.a(eda().pageContext);
            }
            this.olc.n(Iq);
            this.olc.a(eda().olU);
            this.olc.at(viewGroup);
            a((d) this.olc);
            a((com.baidu.live.liveroom.g.b) this.olc);
        }
    }

    protected void a(d dVar) {
        if (this.hgV == null) {
            this.hgV = new ArrayList();
        }
        if (!this.hgV.contains(dVar)) {
            this.hgV.add(dVar);
        }
    }

    protected void b(d dVar) {
        if (this.hgV != null && this.hgV.contains(dVar)) {
            this.hgV.remove(dVar);
        }
    }

    protected void cbL() {
        if (this.hgV != null) {
            this.hgV.clear();
            this.hgV = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hgV == null) {
            return false;
        }
        Iterator<d> it = this.hgV.iterator();
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
        if (this.hgW == null) {
            this.hgW = new ArrayList();
        }
        if (!this.hgW.contains(bVar)) {
            this.hgW.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hgW != null && this.hgW.contains(bVar)) {
            this.hgW.remove(bVar);
        }
    }

    protected void cbM() {
        if (this.hgW != null) {
            this.hgW.clear();
            this.hgW = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hgW == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hgW.iterator();
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
    public void cbN() {
        if (this.olb == null && this.hgw != null && this.hgw.aQZ && eda() != null && eda().olT != null && eda().olT.Iq() != null) {
            this.olb = new com.baidu.tieba.yuyinala.liveroom.f.c(eda().pageContext, this.hgw);
            this.olb.J(eda().olT.Iq());
            if (this.hgw.aRc == 1) {
                if (this.hfU != null) {
                    this.hgN = true;
                }
            } else if (this.hgw.aRc == 2) {
                a(eda().olT.Iq(), null, -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbO() {
        CustomResponsedMessage runTask;
        if (eda() != null && (runTask = MessageManager.getInstance().runTask(2501047, k.class, eda().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.hgx = (com.baidu.live.aa.a) runTask.getData();
            this.hgx.p(caU());
            if (eda().olT != null) {
                this.hgO = this.hgx.o(eda().olT.Iq());
            }
            this.hgx.setCanVisible(!this.hgI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int M(boolean z, boolean z2) {
        Rect rect = new Rect();
        eda().hpQ.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(eda().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(eda().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? eda().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + eda().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? eda().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds192) : 0) + eda().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds32);
    }

    private void cbS() {
        if (this.hfQ == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ah.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.hfQ = (com.baidu.live.ah.a) runTask.getData();
            }
            cbT();
        }
    }

    private void dK(JSONObject jSONObject) {
        if (this.hfQ != null) {
            this.hfQ.cV(true);
            this.hfQ.R(jSONObject);
        }
    }

    private void cbT() {
        if (this.hfQ != null && eda().olT.Iq() != null && eda().olT.Iq().aKF != null) {
            this.hfQ.cV(true);
            this.hfQ.i(eda().olT.Iq());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        if (wVar != null) {
            cbT();
            if (this.okT != null && wVar.aJV != null) {
                this.okT.Il(String.valueOf(wVar.aJV.userId));
            }
            if (this.hfX != null && wVar.mLiveInfo != null) {
                this.hfX.a(wVar.mLiveInfo, wVar.aJV);
            }
            if (this.hfV != null) {
                this.hfV.a(wVar);
            }
            if (this.hgx != null) {
                this.hgO = this.hgx.o(wVar);
            }
            wA(wVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void wA(int i) {
        if (!eda().hpW) {
            if (this.hgG < 0 && i == 0) {
                this.hgG = i;
            } else if (this.hgG != i) {
                if (i == 1) {
                    if (!this.okU.xo(2)) {
                        String string = eda().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(eda().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.okU.a(eda().hpQ.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = eda().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.okU.xp(2);
                    this.okU.xp(3);
                    if (bWj()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.okU.a(eda().hpQ.getLiveContainerView(), string2, 3);
                    }
                }
                this.hgG = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cz(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.cz(z);
        if (z) {
            cbU();
        }
        if (this.okR != null) {
            this.okR.En();
        }
        if (this.hfQ != null) {
            this.hfQ.onDestroy();
            this.hfQ = null;
        }
        if (this.hfW != null) {
            View HM = this.hfW.HM();
            if (HM != null && HM.getParent() != null) {
                ((ViewGroup) HM.getParent()).removeView(HM);
            }
            this.hfW.onDestroy();
            this.hfW = null;
        }
        if (this.hfV != null) {
            this.hfV.a((a.InterfaceC0193a) null);
            this.hfV.DN();
        }
        if (this.okU != null) {
            this.okU.En();
        }
        this.hgG = -1;
        if (this.okT != null) {
            this.okT.En();
            this.okT.onDestroy();
        }
        if (this.okW != null) {
            this.okW.cac();
            this.okW.IB();
        }
        if (this.hfT != null) {
            this.hfT.IB();
        }
        if (this.okV != null) {
            this.okV.IB();
        }
        if (this.olb != null) {
            this.olb.onDestroy();
        }
        if (this.hgm != null) {
            this.hgm.IB();
        }
        if (this.okS != null) {
            this.okS.onDestory();
        }
        if (this.hgx != null) {
            this.hgx.IB();
        }
        if (this.ola != null) {
            this.ola.IB();
        }
        if (this.hgi != null) {
            this.hgi.onDestroy();
        }
        if (this.olc != null) {
            this.olc.En();
            b((d) this.olc);
            b((com.baidu.live.liveroom.g.b) this.olc);
        }
        ShowUtil.windowCount = 0;
        cbL();
        cbM();
    }

    private void cbU() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = eda().olU.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = eda().olU.getChildAt(i);
            if (childAt != this.hgE && childAt != this.hgF) {
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
        if (this.hgE != null) {
            this.hgE.removeAllViews();
        }
        if (this.hgF != null) {
            this.hgF.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, w wVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        View DL;
        View HM;
        if (this.hfW != null && (HM = this.hfW.HM()) != null && HM.getParent() != null) {
            ((ViewGroup) HM.getParent()).removeView(HM);
        }
        if (this.hfV != null && (DL = this.hfV.DL()) != null && DL.getParent() != null) {
            ((ViewGroup) DL.getParent()).removeView(DL);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean PG() {
        cbv();
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cx(boolean z) {
        super.cx(z);
        if (this.hfQ != null) {
            this.hfQ.onDestroy();
            this.hfQ = null;
        }
        if (this.hfW != null) {
            this.hfW.onDestroy();
            this.hfW = null;
        }
        if (this.hfX != null) {
            this.hfX.onDestroy();
            this.hfX = null;
        }
        if (this.okU != null) {
            this.okU.onDestroy();
        }
        if (this.okR != null) {
            this.okR.onDestroy();
        }
        if (this.hgi != null) {
            this.hgi.onDestroy();
            this.hgi = null;
        }
        if (this.hfV != null) {
            this.hfV.a((a.InterfaceC0193a) null);
            this.hfV.release();
            this.hfV = null;
        }
        if (this.okV != null) {
            this.okV.a(null);
            this.okV.release();
        }
        if (this.olb != null) {
            this.olb.onDestroy();
        }
        if (this.ola != null) {
            this.ola.release();
        }
        if (this.hgm != null) {
            this.hgm.release();
        }
        if (this.okS != null) {
            this.okS.onDestory();
        }
        if (this.hgx != null) {
            this.hgx.release();
        }
        if (this.olc != null) {
            this.olc.onDestroy();
            b((d) this.olc);
            b((com.baidu.live.liveroom.g.b) this.olc);
        }
        cbL();
        cbM();
        MessageManager.getInstance().unRegisterListener(this.hhb);
        MessageManager.getInstance().unRegisterListener(this.hhc);
        MessageManager.getInstance().unRegisterListener(this.hhd);
        MessageManager.getInstance().unRegisterListener(this.hhh);
        MessageManager.getInstance().unRegisterListener(this.hhi);
        MessageManager.getInstance().unRegisterListener(this.olf);
        MessageManager.getInstance().unRegisterListener(this.hhk);
        MessageManager.getInstance().unRegisterListener(this.hhe);
        MessageManager.getInstance().unRegisterListener(this.hhf);
        MessageManager.getInstance().unRegisterListener(this.gDr);
        MessageManager.getInstance().unRegisterListener(this.hhg);
        MessageManager.getInstance().unRegisterListener(this.gDE);
        MessageManager.getInstance().unRegisterListener(this.hhl);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.buq);
        MessageManager.getInstance().unRegisterListener(this.hhm);
        MessageManager.getInstance().unRegisterListener(this.hhn);
        MessageManager.getInstance().unRegisterListener(this.hhr);
        MessageManager.getInstance().unRegisterListener(this.hhs);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        caS();
        if (this.ola != null) {
            this.ola.pause();
        }
        if (this.hgi != null) {
            this.hgi.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.hgR = false;
        if (this.hgJ && this.hgK != null) {
            a(this.hgK);
            this.hgJ = false;
        }
        if (this.ola != null) {
            this.ola.resume();
        }
        if (this.hgi != null) {
            this.hgi.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ays() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.olc != null && this.olc.isOpen()) {
            this.olc.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            ays();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    a(null, -1, -1, -1);
                    return;
                }
                return;
            }
            ays();
        } else if (i == 25034) {
            cbs();
        } else if (i == 25043 && i2 == -1) {
            cbX();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.hgI = z;
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
        if (this.okS != null) {
            this.okS.blq();
        }
        if (this.olc != null) {
            this.olc.C(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        this.okP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.yuyinala.liveroom.data.a eda() {
        return this.okP;
    }

    private void cbX() {
        String Ma = g.LZ().Ma();
        if (!TextUtils.isEmpty(Ma)) {
            try {
                a(null, -1, Integer.parseInt(Ma), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                a(null, -1, -1, -1);
            }
        }
    }

    @Override // com.baidu.live.liveroom.a.a
    public boolean fh(int i) {
        if (1 == i) {
            if (caR() != null) {
                caR().setVisibility(8);
                return true;
            }
            return true;
        } else if (2 == i) {
            return !this.hgI;
        } else if (3 == i) {
            if (eda().olU == null) {
                return false;
            }
            eda().olU.setEnabled(false);
            if (this.brc != null) {
                this.brc.e(!eda().hpU, false);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    public void wy(int i) {
    }

    @Override // com.baidu.live.liveroom.a.a
    public void fi(int i) {
        if (3 == i) {
            eda().olU.setEnabled(true);
            if (this.brc != null) {
                this.brc.e(!eda().hpU, true);
            }
            if (this.hfQ != null) {
                this.hfQ.cV(true);
                return;
            }
            return;
        }
        if (2 == i) {
        }
    }

    public String Oj() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.hfV != null) {
            this.hfV.setOtherParams(str);
        }
    }

    private boolean bWj() {
        return eda().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.giQ = alaLastLiveroomInfo;
    }
}
