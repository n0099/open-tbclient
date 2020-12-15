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
    protected AlaLastLiveroomInfo giS;
    protected com.baidu.live.ah.a hfS;
    private m hfV;
    k hfW;
    com.baidu.live.im.b.a hfX;
    protected ad hfY;
    protected ab hfZ;
    protected RelativeLayout hgG;
    protected RelativeLayout hgH;
    protected boolean hgJ;
    protected ar hgM;
    protected GuardClubInfoHttpResponseMessage hgN;
    boolean hgO;
    boolean hgP;
    boolean hgQ;
    public boolean hgS;
    public boolean hgT;
    protected List<d> hgX;
    protected List<com.baidu.live.liveroom.g.b> hgY;
    protected ag hgk;
    private af hgo;
    protected bp hgy;
    protected com.baidu.live.aa.a hgz;
    private com.baidu.tieba.yuyinala.liveroom.data.a okR;
    protected com.baidu.tieba.yuyinala.liveroom.operation.a okS;
    protected com.baidu.tieba.yuyinala.liveroom.share.a okT;
    protected com.baidu.tieba.yuyinala.liveroom.l.b okU;
    private com.baidu.tieba.yuyinala.liveroom.f.a okV;
    protected com.baidu.tieba.yuyinala.liveroom.tippop.a okW;
    protected e okX;
    protected com.baidu.tieba.yuyinala.liveroom.b.a okY;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.b okZ;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.lucky.a ola;
    protected com.baidu.tieba.yuyinala.liveroom.k.b olc;
    protected com.baidu.tieba.yuyinala.liveroom.f.c old;
    protected com.baidu.tieba.yuyinala.liveroom.recommend.a ole;
    protected com.baidu.tieba.yuyinala.liveroom.e.a olf;
    protected String otherParams;
    private int olb = 0;
    private int hgI = -1;
    protected int mOrientation = 0;
    protected boolean hgK = false;
    protected boolean hgL = false;
    private CustomMessageListener hhd = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ai aiVar;
            if ((customResponsedMessage.getData() instanceof ai) && (aiVar = (ai) customResponsedMessage.getData()) != null) {
                a.this.a(aiVar.aLD, null, aiVar.aLz, aiVar.aLA, aiVar.aLB, aiVar.aLC);
            }
        }
    };
    private CustomMessageListener hhe = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.wy(7);
        }
    };
    private CustomMessageListener hhf = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.cbt();
        }
    };
    private CustomMessageListener hhg = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(a.this.edb().olV.Iq().aJV.userId);
            com.baidu.live.view.a.Yo().a(valueOf, new f(a.this.edb().olV.Iq().aJV.portrait, valueOf, true, a.this.edb().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener hhh = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof w) && a.this.okT != null) {
                a.this.okT.c((w) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener buq = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hfW != null) {
                a.this.hfW.g(z.Ii().Ik());
            }
        }
    };
    private CustomMessageListener hhi = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = a.this.okR.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                a.this.Ig(str);
            }
        }
    };
    private CustomMessageListener gDt = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.edb().pageContext.getPageActivity());
            } else if (a.this.okT != null) {
                a.this.okT.c(a.this.edb().olV.Iq(), false);
            }
        }
    };
    private CustomMessageListener hhj = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ar) {
                    a.this.hgL = true;
                    a.this.hgM = (ar) data;
                    a.this.b(a.this.hgM);
                } else if (data instanceof com.baidu.live.data.a) {
                    a.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener hhk = new CustomMessageListener(2501060) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(a.this.edb().olV.Iq().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(a.this.edb().olV.Iq().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(a.this.edb().olV.Iq().mLiveInfo.room_id);
                    String valueOf4 = String.valueOf(a.this.edb().olV.Iq().aJV.userId);
                    if (a.this.okU == null) {
                        a.this.okU = new com.baidu.tieba.yuyinala.liveroom.l.b();
                    }
                    a.this.okU.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, valueOf4, false, obj);
                    a.this.okU.a(a.this.olg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private h.a olg = new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.3
    };
    private CustomMessageListener hhm = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                a.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener gDG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.5
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
    CustomMessageListener hhn = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.hgO = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener hho = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof cy) {
                if (TextUtils.equals(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()), ((cy) customResponsedMessage.getData()).aUf)) {
                    BdUtilHelper.getCustomToast().showToast(a.this.okR.pageContext.getString(a.h.yuyin_sdk_redpacket_snatch_host_alert), 1);
                } else {
                    a.this.a((cy) customResponsedMessage.getData());
                }
            }
        }
    };
    private CustomMessageListener hhp = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.H(a.this.edb().olV.Iq());
        }
    };
    private CustomMessageListener hht = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (a.this.hgk != null) {
                    ((com.baidu.tieba.yuyinala.liveroom.k.a) a.this.hgk).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hhu = new CustomMessageListener(2501031) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                a.this.a(a.this.edb().olV.Iq(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener hhw = new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.17
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.cbI();
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener olh = new CustomMessageListener(2501034) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.20
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

    protected abstract void caI();

    protected abstract View caS();

    public abstract boolean caT();

    protected abstract ViewGroup caV();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bp bpVar) {
        this.hgy = bpVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hgG = (RelativeLayout) edb().olW.findViewById(a.f.ala_live_header_view);
        this.hgH = (RelativeLayout) edb().olW.findViewById(a.f.ala_live_footer_view);
        Jg();
        registerListener();
    }

    public void cba() {
    }

    private void Jg() {
        if (this.okT == null) {
            this.okT = new com.baidu.tieba.yuyinala.liveroom.share.a(edb().pageContext);
        }
        this.okY = new com.baidu.tieba.yuyinala.liveroom.b.a(edb().pageContext, false);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            if (!TbadkCoreApplication.getInst().isHaokan() || !subappVersionName.startsWith("4.14.")) {
            }
            if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && subappVersionName.startsWith("1.14.")) {
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            }
        }
        this.okW = new com.baidu.tieba.yuyinala.liveroom.tippop.a(edb().pageContext, this);
        cbd();
        cbg();
        cbn();
        cbo();
    }

    private void cbn() {
        this.okZ = new com.baidu.tieba.yuyinala.liveroom.turntable.b(edb().pageContext.getPageActivity());
    }

    private void cbd() {
        this.hfV = new m();
    }

    public void nh(boolean z) {
        this.hgJ = z;
    }

    private void cbg() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501037, e.class, edb().pageContext);
        if (runTask != null && runTask.getData() != null) {
            try {
                this.okX = (e) runTask.getData();
                this.okX.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.13
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
                        return a.this.cbk();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public int Nm() {
                        return a.this.cbl();
                    }
                });
            } catch (Exception e) {
            }
        }
    }

    void ni(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cbk() {
        w Iq;
        if (edb() == null || edb().olV == null || (Iq = edb().olV.Iq()) == null || Iq.aKr == null) {
            return false;
        }
        String str = Iq.aKr.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int cbl() {
        w Iq;
        if (edb() != null && edb().olV != null && (Iq = edb().olV.Iq()) != null && !ListUtils.isEmpty(Iq.aKB)) {
            for (AlaLiveMarkData alaLiveMarkData : Iq.aKB) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void cbo() {
        this.olc = new com.baidu.tieba.yuyinala.liveroom.k.b(edb().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.hhj);
        MessageManager.getInstance().registerListener(this.olh);
        MessageManager.getInstance().registerListener(this.hhk);
        MessageManager.getInstance().registerListener(this.hhm);
        MessageManager.getInstance().registerListener(this.hhg);
        MessageManager.getInstance().registerListener(this.hhh);
        MessageManager.getInstance().registerListener(this.gDt);
        MessageManager.getInstance().registerListener(this.hhi);
        MessageManager.getInstance().registerListener(this.gDG);
        MessageManager.getInstance().registerListener(this.hhn);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.buq);
        MessageManager.getInstance().registerListener(this.hho);
        MessageManager.getInstance().registerListener(this.hhp);
        MessageManager.getInstance().registerListener(this.hht);
        MessageManager.getInstance().registerListener(this.hhu);
        MessageManager.getInstance().registerListener(this.hhd);
        MessageManager.getInstance().registerListener(this.hhe);
        MessageManager.getInstance().registerListener(this.hhf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Le() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(edb().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ig(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(edb().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(edb().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.14
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.RB().brA.aNR;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = edb().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = edb().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.15
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(a.this.edb().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(edb().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbq() {
        if (this.hfW != null) {
            this.hfW.Ne().a(this.okX.QD(), z.Ii().Ik(), edb().olV.Iq().mLiveInfo);
            ni(true);
            if (this.hgo == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501042, af.class, edb().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hgo = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgo.hz("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.olf == null) {
            this.olf = new com.baidu.tieba.yuyinala.liveroom.e.a(edb().pageContext);
            this.olf.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.olf.a(edb().olV.Iq(), alaLastLiveroomInfo);
        this.olf.at(this.hgH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbs() {
        if (this.hfW != null) {
            this.hfW.Ne().hide();
            ni(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String[] strArr, int i, int i2, int i3) {
        if (edb().olV.Iq() != null && edb().olV.Iq().aJV != null && edb().olV.Iq().mLiveInfo != null) {
            a(edb().olV.Iq(), strArr, i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, String[] strArr, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(ac.class) != null && Le()) {
            if (wVar == null) {
                wVar = edb().olV.Iq();
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
            if (this.hgN != null && this.hgN.bja != null && this.hgN.bja.anchorId == wVar.aJV.userId) {
                z5 = this.hgN.bjf;
            }
            ac acVar = new ac(edb().pageContext.getPageActivity(), strArr, valueOf, str, valueOf2, valueOf3, i6, Iz, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.mAlaLiveSwitchData != null) {
                acVar.bn(wVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            acVar.bl(z);
            if (com.baidu.tieba.yuyinala.liveroom.n.b.edX().brJ != null) {
                acVar.bm(com.baidu.tieba.yuyinala.liveroom.n.b.edX().brJ.aLH != 1);
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
            if (!this.hgS) {
                this.hgT = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, acVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbt() {
        fi(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cy cyVar) {
        if (cyVar != null && Le()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.aj(edb().pageContext.getPageActivity(), cyVar.aRN, cyVar.liveId, cyVar.aUf, cyVar.roomId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.ae.a.RB().brA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(edb().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.ae.a.RB().brA.aOt, 1, false)));
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(edb().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbu() {
        if (this.okX != null) {
            this.okX.d(this.okR.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbv() {
        w Iq = edb().olV.Iq();
        LogManager.getCommonLogger().doClickQuickImHiLog((Iq == null || Iq.mLiveInfo == null) ? "" : Iq.mLiveInfo.feed_id, Oj());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ih(String str) {
        if (this.okX != null) {
            this.okX.hC(str);
        }
    }

    private void cbw() {
        if ("home_rec_play".equals(edb().fromType) || "frs_play".equals(edb().fromType) || "frs_live_play".equals(edb().fromType) || "person_play".equals(edb().fromType) || "search".equals(edb().fromType) || "person_attention".equals(edb().fromType)) {
            com.baidu.live.c.BL().bc(true);
        } else {
            com.baidu.live.c.BL().bc(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nj(boolean z) {
        View HM;
        if (this.hfY == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aVr = false;
            fVar.context = edb().pageContext.getPageActivity();
            fVar.aVA = z;
            fVar.fromType = edb().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501040, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hfY = (ad) runTask.getData();
            }
        }
        if (this.hfY != null && (HM = this.hfY.HM()) != null && this.okR.olW.indexOfChild(HM) < 0) {
            this.okR.olW.addView(HM, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbx() {
        View IC;
        if (this.hgk == null) {
            ak akVar = new ak();
            akVar.aVr = false;
            akVar.pageContext = edb().pageContext;
            akVar.fromType = edb().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501065, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hgk = (ag) runTask.getData();
            }
        }
        if (this.hgk != null && (IC = this.hgk.IC()) != null && edb().olW.indexOfChild(IC) < 0) {
            if (IC.getParent() instanceof ViewGroup) {
                ((ViewGroup) IC.getParent()).removeView(IC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = edb().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            edb().olW.addView(IC, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cby() {
        View Ip;
        if (this.hfZ == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aVr = false;
            aVar.context = edb().pageContext.getPageActivity();
            aVar.fromType = edb().fromType;
            aVar.aVs = edb().hpZ;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501041, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hfZ = (ab) runTask.getData();
            }
        }
        if (this.hfZ != null && (Ip = this.hfZ.Ip()) != null && edb().olW.indexOfChild(Ip) < 0) {
            if (Ip.getParent() instanceof ViewGroup) {
                ((ViewGroup) Ip.getParent()).removeView(Ip);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = (BdUtilHelper.getDimens(edb().pageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(edb().pageContext.getPageActivity(), a.d.sdk_ds12) : 0)) + BdUtilHelper.getDimens(edb().pageContext.getPageActivity(), a.d.sdk_ds152) + (edb().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18) * (-1));
            edb().olW.addView(Ip, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbz() {
        CustomResponsedMessage runTask;
        if (this.hfX == null && (runTask = MessageManager.getInstance().runTask(2501052, com.baidu.live.im.b.a.class, edb().pageContext)) != null) {
            this.hfX = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hfX != null) {
            this.hfX.setOtherParams(this.otherParams);
            this.hfX.a(new a.InterfaceC0193a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.16
                @Override // com.baidu.live.im.b.a.InterfaceC0193a
                public void NJ() {
                    a.this.cbI();
                }
            });
            this.hfX.a(edb().olV.Iq(), false);
            View DL = this.hfX.DL();
            if (DL != null && this.hgH.indexOfChild(DL) < 0) {
                Resources resources = edb().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(edb().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.hgH.addView(DL, layoutParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501053));
        }
    }

    private void cbA() {
        if (this.okV == null) {
            this.okV = new com.baidu.tieba.yuyinala.liveroom.f.a(edb().pageContext);
        }
        if (this.hgM != null) {
            this.okV.Il(this.hgM.user_id);
        }
        this.okV.at(null);
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
                            edb().olV.Iq().aKr.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            edb().olV.Iq().aKr.isAdmin = 0;
                            edb().olV.cjz();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        edb().olV.Iq().aKr.isAdmin = 0;
                        edb().olV.cjz();
                    }
                } else if ("task".equals(optString2)) {
                    dK(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.okW != null && !edb().hpY) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = edb().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = edb().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = edb().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bWk()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.okW.a(edb().hpS.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    if (edb().olV.Iq() != null && edb().olV.Iq().mLiveInfo != null) {
                        edb().olV.a(edb().olV.Iq().mLiveInfo.live_id, edb().fromType, edb().enterTime);
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.yuyinala.liveroom.m.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (edb().olV.Iq() != null && edb().olV.Iq().aKr != null && edb().olV.Iq().aKr.userId == optLong2) {
                        edb().olV.Iq().aKr.isBlock = 1;
                        caI();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (edb().olV.Iq() != null && edb().olV.Iq().aKr != null && edb().olV.Iq().aKr.userId == optLong3) {
                        edb().olV.Iq().aKr.isBlock = 0;
                        caI();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (edb().olV.Iq() != null && edb().olV.Iq().aKr != null && edb().olV.Iq().aKr.userId == optLong4) {
                        edb().olV.Iq().aKr.isUegBlock = 1;
                        caI();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (edb().olV.Iq() != null && edb().olV.Iq().aKr != null && edb().olV.Iq().aKr.userId == optLong5) {
                        edb().olV.Iq().aKr.isUegBlock = 0;
                        caI();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (edb() != null && edb().olV != null && edb().olV.Iq() != null && edb().olV.Iq().aKr != null) {
                        if (edb().olV.Iq().aKr.userId == jSONObject2.optLong("user_id")) {
                            edb().olV.cjz();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, edb().olV.Iq().aKr));
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
            if (edb().olV == null || edb().olV.Iq() == null || edb().olV.Iq().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j4 = edb().olV.Iq().mLiveInfo.live_id;
                long j5 = edb().olV.Iq().mLiveInfo.group_id;
                long j6 = edb().olV.Iq().aJV.userId;
                str4 = edb().olV.Iq().mLiveInfo.appId;
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

    void cbI() {
        if (cbJ()) {
            BdUtilHelper.hideSoftKeyPad(edb().pageContext.getPageActivity(), edb().hpS.getLiveContainerView());
            caT();
        }
    }

    private boolean cbJ() {
        if (caS() == null || caS().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        CustomResponsedMessage runTask;
        edb().olW.setOnTouchListener(this.hhw);
        cbT();
        cbA();
        if (this.hfV != null) {
            this.hfV.g(edb().olV.Iq());
        }
        if (this.okX != null) {
            this.okX.b(edb().olV.Iq(), Oj());
        }
        if (edb().olW != null) {
            edb().olW.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.18
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    return a.this.Q(motionEvent);
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean PK() {
                    if (a.this.hgY == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : a.this.hgY) {
                        if (bVar.PK()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            edb().olW.setLiveViewOnTouchEventListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.19
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return a.this.P(motionEvent);
                }
            });
        }
        if (this.hgo == null && (runTask = MessageManager.getInstance().runTask(2501042, af.class, edb().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hgo = (af) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbL() {
        w Iq;
        ViewGroup viewGroup;
        if (edb() != null && edb().olV != null && (Iq = edb().olV.Iq()) != null && Iq.mLiveInfo != null && Iq.aKS && (viewGroup = (ViewGroup) edb().hpS) != null) {
            if (this.ole == null) {
                this.ole = new com.baidu.tieba.yuyinala.liveroom.recommend.a(edb().pageContext);
            }
            this.ole.n(Iq);
            this.ole.a(edb().olW);
            this.ole.at(viewGroup);
            a((d) this.ole);
            a((com.baidu.live.liveroom.g.b) this.ole);
        }
    }

    protected void a(d dVar) {
        if (this.hgX == null) {
            this.hgX = new ArrayList();
        }
        if (!this.hgX.contains(dVar)) {
            this.hgX.add(dVar);
        }
    }

    protected void b(d dVar) {
        if (this.hgX != null && this.hgX.contains(dVar)) {
            this.hgX.remove(dVar);
        }
    }

    protected void cbM() {
        if (this.hgX != null) {
            this.hgX.clear();
            this.hgX = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hgX == null) {
            return false;
        }
        Iterator<d> it = this.hgX.iterator();
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
        if (this.hgY == null) {
            this.hgY = new ArrayList();
        }
        if (!this.hgY.contains(bVar)) {
            this.hgY.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hgY != null && this.hgY.contains(bVar)) {
            this.hgY.remove(bVar);
        }
    }

    protected void cbN() {
        if (this.hgY != null) {
            this.hgY.clear();
            this.hgY = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hgY == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hgY.iterator();
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
    public void cbO() {
        if (this.old == null && this.hgy != null && this.hgy.aQZ && edb() != null && edb().olV != null && edb().olV.Iq() != null) {
            this.old = new com.baidu.tieba.yuyinala.liveroom.f.c(edb().pageContext, this.hgy);
            this.old.J(edb().olV.Iq());
            if (this.hgy.aRc == 1) {
                if (this.hfW != null) {
                    this.hgP = true;
                }
            } else if (this.hgy.aRc == 2) {
                a(edb().olV.Iq(), null, -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbP() {
        CustomResponsedMessage runTask;
        if (edb() != null && (runTask = MessageManager.getInstance().runTask(2501047, k.class, edb().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.hgz = (com.baidu.live.aa.a) runTask.getData();
            this.hgz.p(caV());
            if (edb().olV != null) {
                this.hgQ = this.hgz.o(edb().olV.Iq());
            }
            this.hgz.setCanVisible(!this.hgK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int M(boolean z, boolean z2) {
        Rect rect = new Rect();
        edb().hpS.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(edb().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(edb().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? edb().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + edb().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? edb().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds192) : 0) + edb().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds32);
    }

    private void cbT() {
        if (this.hfS == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ah.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.hfS = (com.baidu.live.ah.a) runTask.getData();
            }
            cbU();
        }
    }

    private void dK(JSONObject jSONObject) {
        if (this.hfS != null) {
            this.hfS.cV(true);
            this.hfS.R(jSONObject);
        }
    }

    private void cbU() {
        if (this.hfS != null && edb().olV.Iq() != null && edb().olV.Iq().aKF != null) {
            this.hfS.cV(true);
            this.hfS.i(edb().olV.Iq());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        if (wVar != null) {
            cbU();
            if (this.okV != null && wVar.aJV != null) {
                this.okV.Il(String.valueOf(wVar.aJV.userId));
            }
            if (this.hfZ != null && wVar.mLiveInfo != null) {
                this.hfZ.a(wVar.mLiveInfo, wVar.aJV);
            }
            if (this.hfX != null) {
                this.hfX.a(wVar);
            }
            if (this.hgz != null) {
                this.hgQ = this.hgz.o(wVar);
            }
            wA(wVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void wA(int i) {
        if (!edb().hpY) {
            if (this.hgI < 0 && i == 0) {
                this.hgI = i;
            } else if (this.hgI != i) {
                if (i == 1) {
                    if (!this.okW.xo(2)) {
                        String string = edb().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(edb().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.okW.a(edb().hpS.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = edb().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.okW.xp(2);
                    this.okW.xp(3);
                    if (bWk()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.okW.a(edb().hpS.getLiveContainerView(), string2, 3);
                    }
                }
                this.hgI = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cz(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.cz(z);
        if (z) {
            cbV();
        }
        if (this.okT != null) {
            this.okT.En();
        }
        if (this.hfS != null) {
            this.hfS.onDestroy();
            this.hfS = null;
        }
        if (this.hfY != null) {
            View HM = this.hfY.HM();
            if (HM != null && HM.getParent() != null) {
                ((ViewGroup) HM.getParent()).removeView(HM);
            }
            this.hfY.onDestroy();
            this.hfY = null;
        }
        if (this.hfX != null) {
            this.hfX.a((a.InterfaceC0193a) null);
            this.hfX.DN();
        }
        if (this.okW != null) {
            this.okW.En();
        }
        this.hgI = -1;
        if (this.okV != null) {
            this.okV.En();
            this.okV.onDestroy();
        }
        if (this.okY != null) {
            this.okY.cad();
            this.okY.IB();
        }
        if (this.hfV != null) {
            this.hfV.IB();
        }
        if (this.okX != null) {
            this.okX.IB();
        }
        if (this.old != null) {
            this.old.onDestroy();
        }
        if (this.hgo != null) {
            this.hgo.IB();
        }
        if (this.okU != null) {
            this.okU.onDestory();
        }
        if (this.hgz != null) {
            this.hgz.IB();
        }
        if (this.olc != null) {
            this.olc.IB();
        }
        if (this.hgk != null) {
            this.hgk.onDestroy();
        }
        if (this.ole != null) {
            this.ole.En();
            b((d) this.ole);
            b((com.baidu.live.liveroom.g.b) this.ole);
        }
        ShowUtil.windowCount = 0;
        cbM();
        cbN();
    }

    private void cbV() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = edb().olW.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = edb().olW.getChildAt(i);
            if (childAt != this.hgG && childAt != this.hgH) {
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
        if (this.hgG != null) {
            this.hgG.removeAllViews();
        }
        if (this.hgH != null) {
            this.hgH.removeAllViews();
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
        if (this.hfY != null && (HM = this.hfY.HM()) != null && HM.getParent() != null) {
            ((ViewGroup) HM.getParent()).removeView(HM);
        }
        if (this.hfX != null && (DL = this.hfX.DL()) != null && DL.getParent() != null) {
            ((ViewGroup) DL.getParent()).removeView(DL);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean PG() {
        cbw();
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cx(boolean z) {
        super.cx(z);
        if (this.hfS != null) {
            this.hfS.onDestroy();
            this.hfS = null;
        }
        if (this.hfY != null) {
            this.hfY.onDestroy();
            this.hfY = null;
        }
        if (this.hfZ != null) {
            this.hfZ.onDestroy();
            this.hfZ = null;
        }
        if (this.okW != null) {
            this.okW.onDestroy();
        }
        if (this.okT != null) {
            this.okT.onDestroy();
        }
        if (this.hgk != null) {
            this.hgk.onDestroy();
            this.hgk = null;
        }
        if (this.hfX != null) {
            this.hfX.a((a.InterfaceC0193a) null);
            this.hfX.release();
            this.hfX = null;
        }
        if (this.okX != null) {
            this.okX.a(null);
            this.okX.release();
        }
        if (this.old != null) {
            this.old.onDestroy();
        }
        if (this.olc != null) {
            this.olc.release();
        }
        if (this.hgo != null) {
            this.hgo.release();
        }
        if (this.okU != null) {
            this.okU.onDestory();
        }
        if (this.hgz != null) {
            this.hgz.release();
        }
        if (this.ole != null) {
            this.ole.onDestroy();
            b((d) this.ole);
            b((com.baidu.live.liveroom.g.b) this.ole);
        }
        cbM();
        cbN();
        MessageManager.getInstance().unRegisterListener(this.hhd);
        MessageManager.getInstance().unRegisterListener(this.hhe);
        MessageManager.getInstance().unRegisterListener(this.hhf);
        MessageManager.getInstance().unRegisterListener(this.hhj);
        MessageManager.getInstance().unRegisterListener(this.hhk);
        MessageManager.getInstance().unRegisterListener(this.olh);
        MessageManager.getInstance().unRegisterListener(this.hhm);
        MessageManager.getInstance().unRegisterListener(this.hhg);
        MessageManager.getInstance().unRegisterListener(this.hhh);
        MessageManager.getInstance().unRegisterListener(this.gDt);
        MessageManager.getInstance().unRegisterListener(this.hhi);
        MessageManager.getInstance().unRegisterListener(this.gDG);
        MessageManager.getInstance().unRegisterListener(this.hhn);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.buq);
        MessageManager.getInstance().unRegisterListener(this.hho);
        MessageManager.getInstance().unRegisterListener(this.hhp);
        MessageManager.getInstance().unRegisterListener(this.hht);
        MessageManager.getInstance().unRegisterListener(this.hhu);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        caT();
        if (this.olc != null) {
            this.olc.pause();
        }
        if (this.hgk != null) {
            this.hgk.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.hgT = false;
        if (this.hgL && this.hgM != null) {
            a(this.hgM);
            this.hgL = false;
        }
        if (this.olc != null) {
            this.olc.resume();
        }
        if (this.hgk != null) {
            this.hgk.onResume();
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
        if (i == 4 && this.ole != null && this.ole.isOpen()) {
            this.ole.onClose();
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
            cbt();
        } else if (i == 25043 && i2 == -1) {
            cbY();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.hgK = z;
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
        if (this.okU != null) {
            this.okU.blq();
        }
        if (this.ole != null) {
            this.ole.C(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        this.okR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.yuyinala.liveroom.data.a edb() {
        return this.okR;
    }

    private void cbY() {
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
            if (caS() != null) {
                caS().setVisibility(8);
                return true;
            }
            return true;
        } else if (2 == i) {
            return !this.hgK;
        } else if (3 == i) {
            if (edb().olW == null) {
                return false;
            }
            edb().olW.setEnabled(false);
            if (this.brc != null) {
                this.brc.e(!edb().hpW, false);
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
            edb().olW.setEnabled(true);
            if (this.brc != null) {
                this.brc.e(!edb().hpW, true);
            }
            if (this.hfS != null) {
                this.hfS.cV(true);
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
        if (this.hfX != null) {
            this.hfX.setOtherParams(str);
        }
    }

    private boolean bWk() {
        return edb().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.giS = alaLastLiveroomInfo;
    }
}
