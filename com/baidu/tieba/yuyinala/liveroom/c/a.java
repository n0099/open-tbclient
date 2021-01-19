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
/* loaded from: classes10.dex */
public abstract class a extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a {
    protected AlaLastLiveroomInfo goI;
    protected br hnH;
    protected com.baidu.live.ab.a hnI;
    protected RelativeLayout hnP;
    protected RelativeLayout hnQ;
    protected boolean hnS;
    protected at hnV;
    protected GuardClubInfoHttpResponseMessage hnW;
    boolean hnX;
    boolean hnY;
    boolean hnZ;
    protected com.baidu.live.ai.a hna;
    private m hnd;
    k hne;
    com.baidu.live.im.b.a hnf;
    protected ad hng;
    protected ab hnh;
    protected ag hns;
    private af hnw;
    public boolean hob;
    public boolean hoc;
    protected List<d> hog;
    protected List<com.baidu.live.liveroom.g.b> hoh;
    private com.baidu.tieba.yuyinala.liveroom.data.a ojb;
    protected com.baidu.tieba.yuyinala.liveroom.operation.a ojc;
    protected com.baidu.tieba.yuyinala.liveroom.share.a ojd;
    protected com.baidu.tieba.yuyinala.liveroom.n.b oje;
    private com.baidu.tieba.yuyinala.liveroom.f.a ojf;
    protected com.baidu.tieba.yuyinala.liveroom.tippop.a ojg;
    protected e ojh;
    protected com.baidu.tieba.yuyinala.liveroom.b.a oji;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.b ojj;
    protected com.baidu.tieba.yuyinala.liveroom.turntable.lucky.a ojk;
    protected com.baidu.tieba.yuyinala.liveroom.m.b ojm;
    protected com.baidu.tieba.yuyinala.liveroom.f.c ojn;
    protected com.baidu.tieba.yuyinala.liveroom.recommend.a ojo;
    private CustomMessageTask ojp;
    private CustomMessageTask.CustomRunnable<Integer> ojq;
    com.baidu.tieba.yuyinala.liveroom.h.b ojr;
    protected com.baidu.tieba.yuyinala.liveroom.e.a ojs;
    protected String otherParams;
    private int ojl = 0;
    private int hnR = -1;
    protected int mOrientation = 0;
    protected boolean hnT = false;
    protected boolean hnU = false;
    private CustomMessageListener hom = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ak akVar;
            if ((customResponsedMessage.getData() instanceof ak) && (akVar = (ak) customResponsedMessage.getData()) != null) {
                a.this.a(akVar.aHu, null, akVar.aHq, akVar.aHr, akVar.aHs, akVar.aHt);
            }
        }
    };
    private CustomMessageListener hon = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.vd(7);
        }
    };
    private CustomMessageListener hoo = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.caj();
        }
    };
    private CustomMessageListener hop = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(a.this.dYs().okl.DW().aFH.userId);
            com.baidu.live.view.a.VF().a(valueOf, new f(a.this.dYs().okl.DW().aFH.portrait, valueOf, true, a.this.dYs().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener hoq = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof x) && a.this.ojd != null) {
                a.this.ojd.d((x) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bup = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hne != null) {
                a.this.hne.g(z.DO().DQ());
            }
        }
    };
    private CustomMessageListener hor = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = a.this.ojb.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                a.this.GU(str);
            }
        }
    };
    private CustomMessageListener gKz = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.dYs().pageContext.getPageActivity());
            } else if (a.this.ojd != null) {
                a.this.ojd.d(a.this.dYs().okl.DW(), false);
            }
        }
    };
    private CustomMessageListener hos = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof at) {
                    a.this.hnU = true;
                    a.this.hnV = (at) data;
                    a.this.b(a.this.hnV);
                } else if (data instanceof com.baidu.live.data.a) {
                    a.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener hou = new CustomMessageListener(2501060) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(a.this.dYs().okl.DW().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(a.this.dYs().okl.DW().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(a.this.dYs().okl.DW().mLiveInfo.room_id);
                    String valueOf4 = String.valueOf(a.this.dYs().okl.DW().aFH.userId);
                    if (a.this.oje == null) {
                        a.this.oje = new com.baidu.tieba.yuyinala.liveroom.n.b();
                    }
                    a.this.oje.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, valueOf4, false, obj);
                    a.this.oje.a(a.this.ojt);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private h.a ojt = new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.3
    };
    private CustomMessageListener how = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                a.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.5
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
    CustomMessageListener hox = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.hnX = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.ojr != null) {
                a.this.ojr.Ek();
            }
        }
    };
    private CustomMessageListener hoy = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof dc) {
                if (TextUtils.equals(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()), ((dc) customResponsedMessage.getData()).aQG)) {
                    BdUtilHelper.getCustomToast().showToast(a.this.ojb.pageContext.getString(a.h.yuyin_sdk_redpacket_snatch_host_alert), 1);
                } else {
                    a.this.a((dc) customResponsedMessage.getData());
                }
            }
        }
    };
    private CustomMessageListener hoz = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.H(a.this.dYs().okl.DW());
        }
    };
    private CustomMessageListener hoE = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (a.this.hns != null) {
                    ((com.baidu.tieba.yuyinala.liveroom.m.a) a.this.hns).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hoF = new CustomMessageListener(2501031) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                a.this.a(a.this.dYs().okl.DW(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener hoH = new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.20
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.caz();
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener oju = new CustomMessageListener(2501034) { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.24
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

    protected abstract View bZH();

    public abstract boolean bZI();

    protected abstract ViewGroup bZK();

    protected abstract void bZx();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(br brVar) {
        this.hnH = brVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hnP = (RelativeLayout) dYs().okm.findViewById(a.f.ala_live_header_view);
        this.hnQ = (RelativeLayout) dYs().okm.findViewById(a.f.ala_live_footer_view);
        EN();
        registerListener();
    }

    public void bZP() {
    }

    private void EN() {
        if (this.ojd == null) {
            this.ojd = new com.baidu.tieba.yuyinala.liveroom.share.a(dYs().pageContext);
        }
        this.oji = new com.baidu.tieba.yuyinala.liveroom.b.a(dYs().pageContext, false);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            if (!TbadkCoreApplication.getInst().isHaokan() || !subappVersionName.startsWith("4.14.")) {
            }
            if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && subappVersionName.startsWith("1.14.")) {
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            }
        }
        this.ojg = new com.baidu.tieba.yuyinala.liveroom.tippop.a(dYs().pageContext, this);
        bZS();
        bZV();
        cac();
        cad();
        bZW();
    }

    private void cac() {
        this.ojj = new com.baidu.tieba.yuyinala.liveroom.turntable.b(dYs().pageContext.getPageActivity());
    }

    private void bZS() {
        this.hnd = new m();
    }

    public void nD(boolean z) {
        this.hnS = z;
    }

    private void bZV() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501037, e.class, dYs().pageContext);
        if (runTask != null && runTask.getData() != null) {
            try {
                this.ojh = (e) runTask.getData();
                this.ojh.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.13
                    @Override // com.baidu.live.view.input.e.a
                    public void Wh() {
                        a.this.vd(11);
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public void Wi() {
                        a.this.dA(11);
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public boolean IJ() {
                        return a.this.GJ();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public boolean Jy() {
                        return a.this.bZZ();
                    }

                    @Override // com.baidu.live.view.input.e.a
                    public int IP() {
                        return a.this.caa();
                    }
                });
                this.ojq = new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.14
                    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<Integer> run(CustomMessage<Integer> customMessage) {
                        return new CustomResponsedMessage<>(2501083, Integer.valueOf(a.this.hne != null ? a.this.hne.getImMsgListViewHeight() : 0));
                    }
                };
                this.ojp = new CustomMessageTask(2501083, this.ojq);
                this.ojp.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                MessageManager.getInstance().registerTask(this.ojp);
            } catch (Exception e) {
            }
        }
    }

    void nE(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bZZ() {
        x DW;
        if (dYs() == null || dYs().okl == null || (DW = dYs().okl.DW()) == null || DW.aGd == null) {
            return false;
        }
        String str = DW.aGd.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int caa() {
        x DW;
        if (dYs() != null && dYs().okl != null && (DW = dYs().okl.DW()) != null && !ListUtils.isEmpty(DW.aGo)) {
            for (AlaLiveMarkData alaLiveMarkData : DW.aGo) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void cad() {
        this.ojm = new com.baidu.tieba.yuyinala.liveroom.m.b(dYs().pageContext.getPageActivity());
    }

    private void bZW() {
        this.ojr = new com.baidu.tieba.yuyinala.liveroom.h.b(this.ojb.pageContext);
        this.ojr.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.15
            @Override // com.baidu.tieba.yuyinala.liveroom.h.b.a
            public boolean caS() {
                x DW;
                if (a.this.dYs() == null || a.this.dYs().okl == null || (DW = a.this.dYs().okl.DW()) == null || DW.aGy == null) {
                    return false;
                }
                return DW.aGy.is_followed;
            }
        });
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.hos);
        MessageManager.getInstance().registerListener(this.oju);
        MessageManager.getInstance().registerListener(this.hou);
        MessageManager.getInstance().registerListener(this.how);
        MessageManager.getInstance().registerListener(this.hop);
        MessageManager.getInstance().registerListener(this.hoq);
        MessageManager.getInstance().registerListener(this.gKz);
        MessageManager.getInstance().registerListener(this.hor);
        MessageManager.getInstance().registerListener(this.gKM);
        MessageManager.getInstance().registerListener(this.hox);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.bup);
        MessageManager.getInstance().registerListener(this.hoy);
        MessageManager.getInstance().registerListener(this.hoz);
        MessageManager.getInstance().registerListener(this.hoE);
        MessageManager.getInstance().registerListener(this.hoF);
        MessageManager.getInstance().registerListener(this.hom);
        MessageManager.getInstance().registerListener(this.hon);
        MessageManager.getInstance().registerListener(this.hoo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean GJ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(dYs().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(dYs().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(dYs().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.16
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.af.a.OJ().bru.aJI;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = dYs().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = dYs().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.17
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(a.this.dYs().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(dYs().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caf() {
        if (this.hne != null && this.ojh != null) {
            this.hne.IG().a(this.ojh.NM(), z.DO().DQ(), dYs().okl.DW().mLiveInfo);
            nE(true);
            if (this.hnw == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501042, af.class, dYs().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hnw = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.hnw.fY("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.ojs == null) {
            this.ojs = new com.baidu.tieba.yuyinala.liveroom.e.a(dYs().pageContext);
            this.ojs.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.ojs.a(dYs().okl.DW(), alaLastLiveroomInfo);
        this.ojs.aF(this.hnQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cai() {
        if (this.hne != null) {
            this.hne.IG().hide();
            nE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String[] strArr, int i, int i2, int i3) {
        if (dYs().okl.DW() != null && dYs().okl.DW().aFH != null && dYs().okl.DW().mLiveInfo != null) {
            a(dYs().okl.DW(), strArr, i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, String[] strArr, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(ac.class) != null && GJ()) {
            if (xVar == null) {
                xVar = dYs().okl.DW();
            }
            String valueOf = String.valueOf(xVar.aFH.userId);
            String str = xVar.aFH.userName;
            String valueOf2 = String.valueOf(xVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(xVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(xVar.mLiveInfo.feed_id);
            int i6 = xVar.aGd.isBlock;
            String Ef = aj.Ef();
            String str2 = xVar.mLiveInfo.appId;
            boolean z2 = xVar.aGd.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (xVar.mLiveInfo.live_type == 1 && xVar.mLiveInfo.screen_direction == 1 && com.baidu.live.af.a.OJ().bru.aIJ) {
                z3 = true;
            }
            int i7 = -1;
            if (xVar.aGd == null) {
                z = false;
            } else {
                boolean z4 = xVar.aGd.isNewUser;
                i7 = xVar.aGd.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.hnW != null && this.hnW.bfP != null && this.hnW.bfP.anchorId == xVar.aFH.userId) {
                z5 = this.hnW.bfU;
            }
            ac acVar = new ac(dYs().pageContext.getPageActivity(), strArr, valueOf, str, valueOf2, valueOf3, i6, Ef, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.mAlaLiveSwitchData != null) {
                acVar.bg(xVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            acVar.be(z);
            if (com.baidu.tieba.yuyinala.liveroom.p.b.dZy().brD != null) {
                acVar.bf(com.baidu.tieba.yuyinala.liveroom.p.b.dZy().brD.aHy != 1);
            }
            bi HF = g.HD().HF();
            if (HF == null || HF.aMl <= 0) {
                i5 = 1000;
            } else {
                i5 = HF.aMl;
            }
            acVar.cm(i5);
            boolean z6 = false;
            if (xVar != null && xVar.aGd != null) {
                String str3 = xVar.aGd.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            acVar.bh(z6);
            boolean z7 = true;
            bq bqVar = com.baidu.live.af.a.OJ().bxp;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bqVar != null && bqVar.aMR != null && (!bqVar.aMR.aPy || !bqVar.aMR.aPz || !bqVar.aMR.aPA)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            acVar.bi(z7);
            if (xVar != null && xVar.aGg != null) {
                acVar.eP(xVar.aGg.toJsonString());
            }
            if (!this.hob) {
                this.hoc = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, acVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caj() {
        dA(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(dc dcVar) {
        if (dcVar != null && GJ()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.aj(dYs().pageContext.getPageActivity(), dcVar.aNP, dcVar.liveId, dcVar.aQG, dcVar.roomId, dcVar.time)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && com.baidu.live.af.a.OJ().bru != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(dYs().pageContext.getPageActivity(), String.valueOf(xVar.mLiveInfo.live_id), String.valueOf(xVar.mLiveInfo.user_id), com.baidu.live.af.a.OJ().bru.aKn, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, NobleDetailInfo nobleDetailInfo) {
        if (GJ() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (xVar != null) {
                if (xVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(xVar.mLiveInfo.live_id));
                }
                if (xVar.aFH != null) {
                    hashMap.put("anchor_id", Long.valueOf(xVar.aFH.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", t.Ef());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put(Config.TRACE_VISIT_RECENT_DAY, Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(dYs().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cak() {
        if (this.ojh != null) {
            this.ojh.d(this.ojb.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cal() {
        x DW = dYs().okl.DW();
        LogManager.getCommonLogger().doClickQuickImHiLog((DW == null || DW.mLiveInfo == null) ? "" : DW.mLiveInfo.feed_id, JQ());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void GV(String str) {
        if (this.ojh != null) {
            this.ojh.gb(str);
        }
    }

    private void cam() {
        if ("home_rec_play".equals(dYs().fromType) || "frs_play".equals(dYs().fromType) || "frs_live_play".equals(dYs().fromType) || "person_play".equals(dYs().fromType) || "search".equals(dYs().fromType) || "person_attention".equals(dYs().fromType)) {
            com.baidu.live.c.xe().aV(true);
        } else {
            com.baidu.live.c.xe().aV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nF(boolean z) {
        View Ds;
        if (this.hng == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aSj = false;
            fVar.context = dYs().pageContext.getPageActivity();
            fVar.aSt = z;
            fVar.fromType = dYs().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501040, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hng = (ad) runTask.getData();
            }
        }
        if (this.hng != null && (Ds = this.hng.Ds()) != null && this.ojb.okm.indexOfChild(Ds) < 0) {
            u.a(dYs().okm, Ds, new RelativeLayout.LayoutParams(-1, -1), 250);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void can() {
        View Ej;
        if (this.hns == null) {
            com.baidu.live.gift.ak akVar = new com.baidu.live.gift.ak();
            akVar.aSj = false;
            akVar.pageContext = dYs().pageContext;
            akVar.fromType = dYs().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501065, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hns = (ag) runTask.getData();
            }
        }
        if (this.hns != null && (Ej = this.hns.Ej()) != null && dYs().okm.indexOfChild(Ej) < 0) {
            if (Ej.getParent() instanceof ViewGroup) {
                ((ViewGroup) Ej.getParent()).removeView(Ej);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = dYs().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            u.a(dYs().okm, Ej, layoutParams, 550);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cao() {
        View DV;
        if (this.hnh == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aSj = false;
            aVar.context = dYs().pageContext.getPageActivity();
            aVar.fromType = dYs().fromType;
            aVar.aSk = dYs().hxp;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501041, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hnh = (ab) runTask.getData();
            }
        }
        if (this.hnh != null && (DV = this.hnh.DV()) != null && dYs().okm.indexOfChild(DV) < 0) {
            if (DV.getParent() instanceof ViewGroup) {
                ((ViewGroup) DV.getParent()).removeView(DV);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = (BdUtilHelper.getDimens(dYs().pageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(dYs().pageContext.getPageActivity(), a.d.sdk_ds12) : 0)) + BdUtilHelper.getDimens(dYs().pageContext.getPageActivity(), a.d.sdk_ds152) + (dYs().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18) * (-1));
            u.a(dYs().okm, DV, layoutParams, 300);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cap() {
        CustomResponsedMessage runTask;
        if (this.hnf == null && (runTask = MessageManager.getInstance().runTask(2501052, com.baidu.live.im.b.a.class, dYs().pageContext)) != null) {
            this.hnf = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hnf != null) {
            this.hnf.setOtherParams(this.otherParams);
            this.hnf.a(new a.InterfaceC0177a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.18
                @Override // com.baidu.live.im.b.a.InterfaceC0177a
                public void Jo() {
                    a.this.caz();
                }
            });
            this.hnf.a(dYs().okl.DW(), false);
            View zf = this.hnf.zf();
            if (zf != null && this.hnQ.indexOfChild(zf) < 0) {
                Resources resources = dYs().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(dYs().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.hnQ.addView(zf, layoutParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501053));
        }
    }

    private void caq() {
        if (this.ojf == null) {
            this.ojf = new com.baidu.tieba.yuyinala.liveroom.f.a(dYs().pageContext);
        }
        if (this.hnV != null) {
            this.ojf.Hb(this.hnV.user_id);
        }
        this.ojf.aF(null);
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
                    if (this.bok != null) {
                        this.bok.cv(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        vf(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            dYs().okl.DW().aGd.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            dYs().okl.DW().aGd.isAdmin = 0;
                            dYs().okl.ciu();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        dYs().okl.DW().aGd.isAdmin = 0;
                        dYs().okl.ciu();
                    }
                } else if ("task".equals(optString2)) {
                    dT(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.ojg != null && !dYs().hxo) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = dYs().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = dYs().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = dYs().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bUY()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.ojg.c(dYs().hxi.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    if (dYs().okl.DW() != null && dYs().okl.DW().mLiveInfo != null) {
                        dYs().okl.a(dYs().okl.DW().mLiveInfo.live_id, dYs().fromType, dYs().enterTime);
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.yuyinala.liveroom.o.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (dYs().okl.DW() != null && dYs().okl.DW().aGd != null && dYs().okl.DW().aGd.userId == optLong2) {
                        dYs().okl.DW().aGd.isBlock = 1;
                        bZx();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (dYs().okl.DW() != null && dYs().okl.DW().aGd != null && dYs().okl.DW().aGd.userId == optLong3) {
                        dYs().okl.DW().aGd.isBlock = 0;
                        bZx();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (dYs().okl.DW() != null && dYs().okl.DW().aGd != null && dYs().okl.DW().aGd.userId == optLong4) {
                        dYs().okl.DW().aGd.isUegBlock = 1;
                        bZx();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (dYs().okl.DW() != null && dYs().okl.DW().aGd != null && dYs().okl.DW().aGd.userId == optLong5) {
                        dYs().okl.DW().aGd.isUegBlock = 0;
                        bZx();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (dYs() != null && dYs().okl != null && dYs().okl.DW() != null && dYs().okl.DW().aGd != null) {
                        if (dYs().okl.DW().aGd.userId == jSONObject2.optLong("user_id")) {
                            dYs().okl.ciu();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, dYs().okl.DW().aGd));
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
                    com.baidu.live.data.a JB = bVar.JB();
                    if (JB != null && aj.fU(str3)) {
                        aj.d(str3, 1L, "", "", JB.userId, JB.portrait, JB.userName, "", "", false, "", "", "", false, false, true, -1L, bVar.bjV);
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
                    com.baidu.tieba.yuyinala.liveroom.j.c.a(dYs(), bVar, jSONObject2);
                }
            }
        } else if (bVar.getMsgType() != 125 && bVar.getMsgType() == 24) {
            com.baidu.tieba.yuyinala.liveroom.j.c.b(dYs(), bVar, jSONObject2, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.19
                @Override // com.baidu.tieba.yuyinala.liveroom.j.c.a
                public void UH(String str4) {
                    a.this.GQ(str4);
                }
            });
        }
    }

    protected void GQ(String str) {
    }

    void caz() {
        if (caA() && this.hne != null) {
            if (!this.hne.IG().KA()) {
                this.hne.IG().hide();
            }
            BdUtilHelper.hideSoftKeyPad(dYs().pageContext.getPageActivity(), dYs().hxi.getLiveContainerView());
            bZI();
        }
    }

    private boolean caA() {
        if (bZH() == null || bZH().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(x xVar) {
        CustomResponsedMessage runTask;
        dYs().okm.setOnTouchListener(this.hoH);
        caK();
        caq();
        if (this.hnd != null) {
            this.hnd.h(dYs().okl.DW());
        }
        if (this.ojh != null) {
            this.ojh.b(dYs().okl.DW(), JQ());
        }
        if (this.ojr != null) {
            this.ojr.f(dYs().okl.DW());
        }
        if (dYs().okm != null) {
            dYs().okm.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.21
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    return a.this.Q(motionEvent);
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean LE() {
                    if (a.this.hoh == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : a.this.hoh) {
                        if (bVar.LE()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            dYs().okm.setLiveViewOnTouchEventListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.c.a.22
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return a.this.P(motionEvent);
                }
            });
        }
        if (this.hnw == null && (runTask = MessageManager.getInstance().runTask(2501042, af.class, dYs().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hnw = (af) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caC() {
        x DW;
        ViewGroup viewGroup;
        if (dYs() != null && dYs().okl != null && (DW = dYs().okl.DW()) != null && DW.mLiveInfo != null && DW.aGF && (viewGroup = (ViewGroup) dYs().hxi) != null) {
            if (this.ojo == null) {
                this.ojo = new com.baidu.tieba.yuyinala.liveroom.recommend.a(dYs().pageContext);
            }
            this.ojo.o(DW);
            this.ojo.a(dYs().okm);
            this.ojo.aF(viewGroup);
            a((d) this.ojo);
            a((com.baidu.live.liveroom.g.b) this.ojo);
        }
    }

    protected void a(d dVar) {
        if (this.hog == null) {
            this.hog = new ArrayList();
        }
        if (!this.hog.contains(dVar)) {
            this.hog.add(dVar);
        }
    }

    protected void b(d dVar) {
        if (this.hog != null && this.hog.contains(dVar)) {
            this.hog.remove(dVar);
        }
    }

    protected void caD() {
        if (this.hog != null) {
            this.hog.clear();
            this.hog = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hog == null) {
            return false;
        }
        Iterator<d> it = this.hog.iterator();
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
        if (this.hoh == null) {
            this.hoh = new ArrayList();
        }
        if (!this.hoh.contains(bVar)) {
            this.hoh.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hoh != null && this.hoh.contains(bVar)) {
            this.hoh.remove(bVar);
        }
    }

    protected void caE() {
        if (this.hoh != null) {
            this.hoh.clear();
            this.hoh = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hoh == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hoh.iterator();
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
    public void caF() {
        if (this.ojn == null && this.hnH != null && this.hnH.aNb && dYs() != null && dYs().okl != null && dYs().okl.DW() != null) {
            this.ojn = new com.baidu.tieba.yuyinala.liveroom.f.c(dYs().pageContext, this.hnH);
            this.ojn.J(dYs().okl.DW());
            if (this.hnH.aNe == 1) {
                if (this.hne != null) {
                    this.hnY = true;
                }
            } else if (this.hnH.aNe == 2) {
                a(dYs().okl.DW(), null, -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caG() {
        CustomResponsedMessage runTask;
        if (dYs() != null && (runTask = MessageManager.getInstance().runTask(2501047, k.class, dYs().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.ab.a)) {
            this.hnI = (com.baidu.live.ab.a) runTask.getData();
            this.hnI.s(bZK());
            if (dYs().okl != null) {
                this.hnZ = this.hnI.p(dYs().okl.DW());
            }
            this.hnI.setCanVisible(!this.hnT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(boolean z, boolean z2) {
        Rect rect = new Rect();
        dYs().hxi.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(dYs().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(dYs().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? dYs().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + dYs().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? dYs().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds192) : 0) + dYs().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds32);
    }

    private void caK() {
        if (this.hna == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ai.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.hna = (com.baidu.live.ai.a) runTask.getData();
            }
            caL();
        }
    }

    private void dT(JSONObject jSONObject) {
        if (this.hna != null) {
            this.hna.cU(true);
            this.hna.Z(jSONObject);
        }
    }

    private void caL() {
        if (this.hna != null && dYs().okl.DW() != null && dYs().okl.DW().aGs != null) {
            this.hna.cU(true);
            this.hna.j(dYs().okl.DW());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(x xVar) {
        if (xVar != null) {
            caL();
            if (this.ojf != null && xVar.aFH != null) {
                this.ojf.Hb(String.valueOf(xVar.aFH.userId));
            }
            if (this.hnh != null && xVar.mLiveInfo != null) {
                this.hnh.a(xVar.mLiveInfo, xVar.aFH);
            }
            if (this.hnf != null) {
                this.hnf.a(xVar);
            }
            if (this.hnI != null) {
                this.hnZ = this.hnI.p(xVar);
            }
            vf(xVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void vf(int i) {
        if (!dYs().hxo) {
            if (this.hnR < 0 && i == 0) {
                this.hnR = i;
            } else if (this.hnR != i) {
                if (i == 1) {
                    if (!this.ojg.vU(2)) {
                        String string = dYs().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(dYs().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.ojg.a(dYs().hxi.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = dYs().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.ojg.vV(2);
                    this.ojg.vV(3);
                    if (bUY()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.ojg.c(dYs().hxi.getLiveContainerView(), string2, 3);
                    }
                }
                this.hnR = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cy(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.cy(z);
        if (z) {
            caM();
        }
        if (this.ojd != null) {
            this.ojd.zH();
        }
        if (this.hna != null) {
            this.hna.onDestroy();
            this.hna = null;
        }
        if (this.ojr != null) {
            this.ojr.onDestroy();
        }
        if (this.hng != null) {
            View Ds = this.hng.Ds();
            if (Ds != null && Ds.getParent() != null) {
                ((ViewGroup) Ds.getParent()).removeView(Ds);
            }
            this.hng.onDestroy();
            this.hng = null;
        }
        if (this.hnf != null) {
            this.hnf.a((a.InterfaceC0177a) null);
            this.hnf.zh();
        }
        if (this.ojg != null) {
            this.ojg.zH();
        }
        this.hnR = -1;
        if (this.ojf != null) {
            this.ojf.zH();
            this.ojf.onDestroy();
        }
        if (this.oji != null) {
            this.oji.bYT();
            this.oji.Ei();
        }
        if (this.hnd != null) {
            this.hnd.Ei();
        }
        if (this.ojh != null) {
            this.ojh.Ei();
        }
        if (this.ojn != null) {
            this.ojn.onDestroy();
        }
        if (this.hnw != null) {
            this.hnw.Ei();
        }
        if (this.oje != null) {
            this.oje.onDestory();
        }
        if (this.hnI != null) {
            this.hnI.Ei();
        }
        if (this.ojm != null) {
            this.ojm.Ei();
        }
        if (this.hns != null) {
            this.hns.onDestroy();
        }
        if (this.ojo != null) {
            this.ojo.zH();
            b((d) this.ojo);
            b((com.baidu.live.liveroom.g.b) this.ojo);
        }
        ShowUtil.windowCount = 0;
        caD();
        caE();
    }

    private void caM() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = dYs().okm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = dYs().okm.getChildAt(i);
            if (childAt != this.hnP && childAt != this.hnQ) {
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
        if (this.hnP != null) {
            this.hnP.removeAllViews();
        }
        if (this.hnQ != null) {
            this.hnQ.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, x xVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(x xVar) {
        View zf;
        View Ds;
        if (this.hng != null && (Ds = this.hng.Ds()) != null && Ds.getParent() != null) {
            ((ViewGroup) Ds.getParent()).removeView(Ds);
        }
        if (this.hnf != null && (zf = this.hnf.zf()) != null && zf.getParent() != null) {
            ((ViewGroup) zf.getParent()).removeView(zf);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean LA() {
        cam();
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cw(boolean z) {
        super.cw(z);
        if (this.hna != null) {
            this.hna.onDestroy();
            this.hna = null;
        }
        if (this.hng != null) {
            this.hng.onDestroy();
            this.hng = null;
        }
        if (this.hnh != null) {
            this.hnh.onDestroy();
            this.hnh = null;
        }
        if (this.ojg != null) {
            this.ojg.onDestroy();
        }
        if (this.ojd != null) {
            this.ojd.onDestroy();
        }
        if (this.hns != null) {
            this.hns.onDestroy();
            this.hns = null;
        }
        if (this.hnf != null) {
            this.hnf.a((a.InterfaceC0177a) null);
            this.hnf.release();
            this.hnf = null;
        }
        if (this.ojh != null) {
            this.ojh.a(null);
            this.ojh.release();
        }
        if (this.ojn != null) {
            this.ojn.onDestroy();
        }
        if (this.ojm != null) {
            this.ojm.release();
        }
        if (this.hnw != null) {
            this.hnw.release();
        }
        if (this.oje != null) {
            this.oje.onDestory();
        }
        if (this.hnI != null) {
            this.hnI.release();
        }
        if (this.ojr != null) {
            this.ojr.a((b.a) null);
            this.ojr.onDestroy();
        }
        if (this.ojo != null) {
            this.ojo.onDestroy();
            b((d) this.ojo);
            b((com.baidu.live.liveroom.g.b) this.ojo);
        }
        caD();
        caE();
        MessageManager.getInstance().unRegisterListener(this.hom);
        MessageManager.getInstance().unRegisterListener(this.hon);
        MessageManager.getInstance().unRegisterListener(this.hoo);
        MessageManager.getInstance().unRegisterListener(this.hos);
        MessageManager.getInstance().unRegisterListener(this.hou);
        MessageManager.getInstance().unRegisterListener(this.oju);
        MessageManager.getInstance().unRegisterListener(this.how);
        MessageManager.getInstance().unRegisterListener(this.hop);
        MessageManager.getInstance().unRegisterListener(this.hoq);
        MessageManager.getInstance().unRegisterListener(this.gKz);
        MessageManager.getInstance().unRegisterListener(this.hor);
        MessageManager.getInstance().unRegisterListener(this.gKM);
        MessageManager.getInstance().unRegisterListener(this.hox);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.bup);
        MessageManager.getInstance().unRegisterListener(this.hoy);
        MessageManager.getInstance().unRegisterListener(this.hoz);
        MessageManager.getInstance().unRegisterListener(this.hoE);
        MessageManager.getInstance().unRegisterListener(this.hoF);
        MessageManager.getInstance().unRegisterTask(2501083);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        bZI();
        if (this.ojm != null) {
            this.ojm.pause();
        }
        if (this.hns != null) {
            this.hns.onPause();
        }
        if (this.ojr != null) {
            this.ojr.og(false);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.hoc = false;
        if (this.hnU && this.hnV != null) {
            a(this.hnV);
            this.hnU = false;
        }
        if (this.ojm != null) {
            this.ojm.resume();
        }
        if (this.hns != null) {
            this.hns.onResume();
        }
        if (this.ojr != null) {
            this.ojr.og(true);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avQ() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.ojo != null && this.ojo.isOpen()) {
            this.ojo.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            avQ();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    a(null, -1, -1, -1);
                    return;
                }
                return;
            }
            avQ();
        } else if (i == 25034) {
            caj();
        } else if (i == 25043 && i2 == -1) {
            caP();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void e(boolean z, int i) {
        this.hnT = z;
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
        if (this.oje != null) {
            this.oje.bjV();
        }
        if (this.ojo != null) {
            this.ojo.C(i, i3);
        }
        if (this.ojr != null) {
            this.ojr.bjV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        this.ojb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.yuyinala.liveroom.data.a dYs() {
        return this.ojb;
    }

    private void caP() {
        String HE = g.HD().HE();
        if (!TextUtils.isEmpty(HE)) {
            try {
                a(null, -1, Integer.parseInt(HE), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                a(null, -1, -1, -1);
            }
        }
    }

    @Override // com.baidu.live.liveroom.a.a
    public boolean dz(int i) {
        if (1 == i) {
            if (bZH() != null) {
                bZH().setVisibility(8);
                return true;
            }
            return true;
        } else if (2 == i) {
            return !this.hnT;
        } else if (3 == i) {
            if (dYs().okm == null) {
                return false;
            }
            dYs().okm.setEnabled(false);
            if (this.bok != null) {
                this.bok.e(!dYs().hxm, false);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    public void vd(int i) {
    }

    @Override // com.baidu.live.liveroom.a.a
    public void dA(int i) {
        if (3 == i) {
            dYs().okm.setEnabled(true);
            if (this.bok != null) {
                this.bok.e(!dYs().hxm, true);
            }
            if (this.hna != null) {
                this.hna.cU(true);
                return;
            }
            return;
        }
        if (2 == i) {
        }
    }

    public String JQ() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.hnf != null) {
            this.hnf.setOtherParams(str);
        }
    }

    private boolean bUY() {
        return dYs().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.goI = alaLastLiveroomInfo;
    }
}
