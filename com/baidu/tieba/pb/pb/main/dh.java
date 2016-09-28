package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class dh extends com.baidu.tbadk.editortools.e.a {
    private static final int ere = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int erf = 1;
    private BaseActivity aRd;
    private CustomMessageListener aVw;
    private String ahb;
    private boolean azO;
    private com.baidu.tieba.tbadkCore.d.b bHA;
    private long ccC;
    private int dyn;
    private com.baidu.adp.framework.listener.a dyx;
    private int eeh;
    private String erA;
    private String erB;
    private int erC;
    private int erD;
    private boolean erE;
    private boolean erF;
    private boolean erG;
    private boolean erH;
    private boolean erI;
    private String erJ;
    private long erK;
    private boolean erL;
    private int erM;
    private boolean erN;
    private int erO;
    private final dn erP;
    private final da erQ;
    private final cq erR;
    private final ct erS;
    private CustomMessageListener erT;
    private PraiseData erU;
    protected String erg;
    private String erh;
    private boolean eri;
    private boolean erj;
    private boolean erk;
    private long erl;
    private int erm;
    private int ern;
    private int ero;
    private boolean erp;
    private boolean erq;
    private boolean err;
    private long ers;
    private boolean ert;
    private String eru;
    protected com.baidu.tieba.pb.data.h erv;
    private int erw;
    private boolean erx;
    private boolean ery;
    private a erz;
    private boolean isAd;
    private boolean isFromMark;
    private com.baidu.tieba.pb.data.g mAppealInfo;
    protected Context mContext;
    private int mIsGood;
    private String mLocate;
    private int mRequestType;
    protected int mThreadType;
    private String opType;
    private String opUrl;
    private String postID;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.h hVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.h hVar);
    }

    public String aOs() {
        return this.erJ;
    }

    public void ph(String str) {
        this.erJ = str;
    }

    public void ie(boolean z) {
        this.erL = z;
    }

    public dh(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.ahb = null;
        this.erg = null;
        this.erh = null;
        this.eri = false;
        this.erj = true;
        this.erk = true;
        this.mIsGood = 0;
        this.dyn = 0;
        this.erl = 0L;
        this.erm = 1;
        this.ern = 1;
        this.ero = 1;
        this.eeh = 1;
        this.isAd = false;
        this.erp = false;
        this.erq = false;
        this.isFromMark = false;
        this.err = false;
        this.ers = 0L;
        this.ert = false;
        this.eru = null;
        this.erv = null;
        this.azO = false;
        this.erx = false;
        this.ery = false;
        this.mLocate = null;
        this.mContext = null;
        this.erz = null;
        this.opType = null;
        this.opUrl = null;
        this.erA = null;
        this.erB = null;
        this.erC = -1;
        this.erD = -1;
        this.bHA = null;
        this.erF = false;
        this.erG = false;
        this.postID = null;
        this.erJ = null;
        this.erK = 0L;
        this.erL = false;
        this.erM = -1;
        this.aVw = new di(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.erT = new dk(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.dyx = new dl(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.erU = null;
        registerListener(this.aVw);
        registerListener(this.dyx);
        registerListener(this.erT);
        this.erv = new com.baidu.tieba.pb.data.h();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aRd = baseActivity;
        this.erP = new dn(this, this.aRd);
        this.erQ = new da(this, this.aRd);
        this.erR = new cq(this, this.aRd);
        this.erS = new ct(this, this.aRd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aOt() {
        return 1001;
    }

    private void a(String str, boolean z, String str2, int i) {
        PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
        pbPageReadLocalRequestMessage.setCacheKey(str);
        pbPageReadLocalRequestMessage.setContext(this.mContext);
        pbPageReadLocalRequestMessage.setMarkCache(z);
        pbPageReadLocalRequestMessage.setPostId(str2);
        pbPageReadLocalRequestMessage.setUpdateType(i);
        sendMessage(pbPageReadLocalRequestMessage);
    }

    public void initWithIntent(Intent intent) {
        this.erg = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.erg)) {
            this.erg = this.erP.w(intent);
        }
        this.erh = intent.getStringExtra("post_id");
        this.eri = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.erk = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.ahb = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dyn = intent.getIntExtra("is_top", 0);
        this.erl = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.erq = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.err = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.erp = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.ert = intent.getBooleanExtra("is_pv", false);
        this.ers = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eru = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.erB = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.erA = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.erx = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.ery = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.erD = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.erC = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void initWithBundle(Bundle bundle) {
        this.erg = bundle.getString("thread_id");
        this.erh = bundle.getString("post_id");
        this.eri = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.erk = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.ahb = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dyn = bundle.getInt("is_top", 0);
        this.erl = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.erq = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.err = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.erp = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.ert = bundle.getBoolean("is_pv", false);
        this.ers = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eru = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.erB = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.erx = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.ery = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.erD = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.erC = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void n(Bundle bundle) {
        bundle.putString("thread_id", this.erg);
        bundle.putString("post_id", this.erh);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.eri);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.erk);
        bundle.putString("st_type", this.ahb);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dyn);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.erl);
        bundle.putBoolean("from_frs", this.erq);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.err);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.erp);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.ert);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.ers);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.erB);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.erx);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.ery);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.erD);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.erC);
    }

    public String aOu() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.erg);
        if (!this.err) {
            sb.append(this.erh);
        }
        sb.append(this.eri);
        sb.append(this.erk);
        sb.append(this.ahb);
        sb.append(this.mIsGood);
        sb.append(this.dyn);
        sb.append(this.erl);
        sb.append(this.erq);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.erp);
        sb.append(this.ert);
        sb.append(this.ers);
        sb.append(this.eru);
        sb.append(this.mThreadType);
        sb.append(this.erx);
        sb.append(this.ery);
        if (this.erB != null) {
            sb.append(this.erB);
        }
        return sb.toString();
    }

    public String aOv() {
        return this.eru;
    }

    public String getPostId() {
        return this.erh;
    }

    public void pi(String str) {
        this.erh = str;
    }

    public String getThreadID() {
        return this.erg;
    }

    public boolean getHostMode() {
        return this.eri;
    }

    public boolean aOw() {
        return this.erk;
    }

    public boolean aOx() {
        return this.erq;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aOy() {
        return "hot_topic".equals(this.ahb);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aAT() {
        return this.dyn;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void or(int i) {
        this.dyn = i;
    }

    public boolean aOz() {
        return this.erp;
    }

    public boolean aOA() {
        if (this.erv == null) {
            return false;
        }
        return this.erv.isValid();
    }

    public String rV() {
        if (this.erv == null || !this.erv.nv()) {
            return null;
        }
        return this.erv.nu();
    }

    public boolean os(int i) {
        this.erm = i;
        if (this.erm > this.erv.getPage().qw()) {
            this.erm = this.erv.getPage().qw();
        }
        if (this.erm < 1) {
            this.erm = 1;
        }
        if (this.erg == null) {
            return false;
        }
        return ow(5);
    }

    public boolean ot(int i) {
        int sA = this.erv.aMs().sA();
        if (i <= sA) {
            sA = i;
        }
        int i2 = sA >= 1 ? sA : 1;
        if (this.erg == null) {
            return false;
        }
        this.erM = i2;
        return ow(7);
    }

    public void ou(int i) {
        this.erm = i;
        this.ern = i;
        this.ero = i;
    }

    public void ov(int i) {
        if (this.ern < i) {
            this.ern = i;
            if (this.ern - this.ero >= ere) {
                this.ero = (this.ern - ere) + 1;
            }
        }
        if (this.ero > i) {
            this.ero = i;
            if (this.ern - this.ero >= ere) {
                this.ern = (this.ero + ere) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        return this.erv;
    }

    public com.baidu.tbadk.core.data.am api() {
        if (this.erv == null) {
            return null;
        }
        return this.erv.getPage();
    }

    public boolean aOB() {
        if (this.erk) {
            if (this.erv.getPage().qB() == 0) {
                m17if(true);
                return true;
            }
        } else if (this.erv.getPage().qC() == 0) {
            ig(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.erg == null) {
            return false;
        }
        cancelLoadData();
        if (this.bHA == null) {
            this.bHA = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bHA.start();
        }
        boolean ow = ow(3);
        if (this.opType != null) {
            this.opType = null;
            this.erA = null;
            this.opUrl = null;
            return ow;
        }
        return ow;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.azO = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Yh();
    }

    private void Yh() {
        if (this.bHA != null) {
            this.bHA.destory();
            this.bHA = null;
        }
    }

    public boolean Fa() {
        return (this.erh == null || this.erh.equals("0") || this.erh.length() == 0) ? LoadData() : aOE();
    }

    public boolean ow(int i) {
        this.mRequestType = i;
        if (this.azO) {
            return false;
        }
        this.azO = true;
        ox(i);
        com.baidu.tieba.pb.data.h pbData = ep.aPz().getPbData();
        if (pbData != null && pbData.aMs() != null) {
            pbData.aMs().bT(0);
            this.erk = ep.aPz().aOw();
            this.eri = ep.aPz().aPB();
            if (!this.erk || this.eri || this.isFromMark) {
                this.erE = false;
            }
            com.baidu.adp.lib.h.h.eG().post(new dm(this, pbData));
            return false;
        }
        if (i == 4 && !this.erI) {
            a(aOJ(), true, this.erh, 3);
        }
        if (i == 3 && !this.erI) {
            if (this.isFromMark) {
                a(aOJ(), true, this.erh, 3);
            } else {
                a(aOJ(), false, this.erh, 3);
            }
        }
        this.erI = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.asJ);
        if (!this.erk || this.eri || this.isFromMark) {
            this.erE = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.erg == null || this.erg.length() == 0) {
            this.azO = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.erg, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.ba.vy().vA() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.erk) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eri) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.ahb != null) {
            pbPageRequestMessage.set_st_type(this.ahb);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.ert) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.ers));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.erE) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.h.b.g(this.erA, 0));
            pbPageRequestMessage.setOpMessageID(this.ers);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = this.erv.aMt();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.erk) {
                        if (this.ero - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.ero - 1));
                        }
                    } else if (this.ern < this.eeh) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.ern + 1));
                    }
                }
                if (aMt != null && aMt.size() > 0) {
                    int size = aMt.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.q qVar = aMt.get(size - i3);
                        if (qVar == null) {
                            i3++;
                        } else {
                            this.erh = qVar.getId();
                            if (StringUtils.isNull(this.erh)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.erh != null && this.erh.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.erh, 0L));
                    break;
                } else if (!this.erk) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aMt != null && aMt.size() > 0 && aMt.get(0) != null) {
                    this.erh = aMt.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.erk) {
                        if (this.ero - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.ero - 1));
                        }
                    } else if (this.ern < this.eeh) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.ern + 1));
                    }
                }
                if (this.erh != null && this.erh.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.erh, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.erk) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                }
                if (this.isFromMark) {
                    pbPageRequestMessage.set_st_type("store_thread");
                    break;
                }
                break;
            case 4:
                pbPageRequestMessage.set_st_type("store_thread");
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.erh, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.erm));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.erh, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.erM);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aOJ());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.aRd != null && (this.aRd instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.aRd).aNi());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.erL);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void ox(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = this.erv.aMt();
        this.erH = false;
        if (i == 1) {
            boolean z2 = false;
            while (aMt.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aMt.remove(0);
                z2 = true;
            }
            if (z2) {
                this.erv.getPage().bQ(1);
                if (this.erz != null) {
                    this.erz.c(this.erv);
                }
            }
            this.ccC = System.currentTimeMillis();
            this.erH = true;
        } else if (i == 2) {
            while (aMt.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aMt.remove(aMt.size() - 1);
                z = true;
            }
            if (z) {
                this.erv.getPage().bP(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.h hVar2 = z ? null : hVar;
        this.erO = i2;
        this.azO = false;
        if (hVar2 != null) {
            d(hVar2);
        }
        a(hVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        int downSize = pbpagesocketresponsemessage.getDownSize();
        long costTime = pbpagesocketresponsemessage.getCostTime();
        if (pbpagesocketresponsemessage.getError() == 4) {
            this.mAppealInfo = pbpagesocketresponsemessage.getAppealInfo();
        }
        a(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, downSize, 0L, costTime);
    }

    public void a(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        int downSize = pbpagehttpresponsemessage.getDownSize();
        long costTime = pbpagehttpresponsemessage.getCostTime();
        if (pbpagehttpresponsemessage.getError() == 4) {
            this.mAppealInfo = pbpagehttpresponsemessage.getAppealInfo();
        }
        a(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, downSize, costTime, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null) {
            if (this.erx || this.ery) {
                hVar = f(hVar);
            }
            e(hVar);
        }
    }

    protected void e(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null) {
            String g = g(hVar);
            for (int i = 0; i < hVar.aMt().size(); i++) {
                com.baidu.tieba.tbadkCore.data.q qVar = hVar.aMt().get(i);
                for (int i2 = 0; i2 < qVar.bjK().size(); i2++) {
                    qVar.bjK().get(i2).c(this.aRd.getPageContext(), g.equals(qVar.bjK().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.h f(com.baidu.tieba.pb.data.h hVar) {
        if (hVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.bi aMs = hVar.aMs();
        aMs.bW(this.mIsGood);
        aMs.bV(this.dyn);
        if (this.erl > 0) {
            aMs.p(this.erl);
            return hVar;
        }
        return hVar;
    }

    protected String g(com.baidu.tieba.pb.data.h hVar) {
        String str = null;
        if (hVar == null) {
            return null;
        }
        if (hVar.aMs() != null && hVar.aMs().getAuthor() != null) {
            str = hVar.aMs().getAuthor().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String h(com.baidu.tieba.pb.data.h hVar) {
        String str = null;
        if (hVar == null) {
            return null;
        }
        if (hVar.aMs() != null && hVar.aMs().getAuthor() != null) {
            str = hVar.aMs().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aOC() {
        if (this.erv == null || this.erv.aMs() == null || this.erv.aMs().getAuthor() == null) {
            return null;
        }
        return this.erv.aMs().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.erN = z3;
        this.erw = i;
        if (this.bHA != null && !z3) {
            this.bHA.a(z2, z4, i2, str, i3, j, j2);
            this.bHA = null;
        }
        if (hVar == null || (this.erm == 1 && i == 5 && hVar.aMt() != null && hVar.aMt().size() < 1)) {
            if (this.erz != null) {
                this.erk = this.erj;
                this.erz.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.erj = this.erk;
            this.ert = false;
            if (hVar.getPage() != null) {
                ov(hVar.getPage().qz());
                this.eeh = hVar.getPage().qw();
            }
            this.eeh = this.eeh < 1 ? 1 : this.eeh;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = this.erv.aMt();
            switch (i) {
                case 1:
                    this.erv.a(hVar.getPage(), 1);
                    a(hVar, aMt);
                    i4 = 0;
                    break;
                case 2:
                    if (hVar.aMt() != null) {
                        int size = hVar.aMt().size() + 1;
                        com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(aMt, 0);
                        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(hVar.aMt(), com.baidu.tbadk.core.util.y.s(hVar.aMt()) - 1);
                        if (qVar == null || qVar2 == null || !qVar.getId().equals(qVar2.getId())) {
                            i5 = size;
                        } else {
                            hVar.aMt().remove(qVar2);
                            i5 = size - 1;
                        }
                        aMt.addAll(0, hVar.aMt());
                    }
                    this.erv.a(hVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.erk && hVar.getPage() != null) {
                        hVar.getPage().bN(hVar.getPage().qw());
                    }
                    i(hVar);
                    if (!z3 && this.mThreadType != 33 && this.erk) {
                        aOD();
                        i4 = 0;
                        break;
                    }
                    i4 = 0;
                    break;
                case 4:
                    i(hVar);
                    i4 = 0;
                    break;
                case 5:
                    i(hVar);
                    i4 = 0;
                    break;
                case 6:
                    i(hVar);
                    i4 = 0;
                    break;
                case 7:
                    i(hVar);
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.erv != null && this.erv.aMs() != null) {
                PraiseData rF = this.erv.aMs().rF();
                if (this.erU != null && !rF.isPriaseDataValid()) {
                    this.erv.aMs().a(this.erU);
                } else {
                    this.erU = this.erv.aMs().rF();
                    this.erU.setPostId(this.erv.aMs().sc());
                }
                if (hVar.getPage() != null && hVar.getPage().qz() == 1 && hVar.aMs() != null && hVar.aMs().rX() != null && hVar.aMs().rX().size() > 0) {
                    this.erv.aMs().i(hVar.aMs().rX());
                }
                this.erv.aMs().bU(hVar.aMs().rH());
                this.erv.aMs().setAnchorLevel(hVar.aMs().getAnchorLevel());
                this.erv.aMs().bT(hVar.aMs().rD());
                if (this.mThreadType == 33) {
                    this.erv.aMs().getAuthor().setHadConcerned(hVar.aMs().getAuthor().hadConcerned());
                }
            }
            if (this.erv != null && this.erv.getUserData() != null && hVar.getUserData() != null) {
                this.erv.getUserData().setBimg_end_time(hVar.getUserData().getBimg_end_time());
                this.erv.getUserData().setBimg_url(hVar.getUserData().getBimg_url());
            }
            if (this.erN && this.erv.aMs() != null && this.erv.aMs().getAuthor() != null && this.erv.aMt() != null && com.baidu.tbadk.core.util.y.c(this.erv.aMt(), 0) != null) {
                com.baidu.tieba.tbadkCore.data.q qVar3 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(this.erv.aMt(), 0);
                MetaData author = this.erv.aMs().getAuthor();
                if (qVar3.getAuthor() != null && qVar3.getAuthor().getGodUserData() != null) {
                    if (this.erC != -1) {
                        author.setFansNum(this.erC);
                        qVar3.getAuthor().setFansNum(this.erC);
                    }
                    if (this.erD != -1) {
                        author.getGodUserData().setFollowed(this.erD);
                        qVar3.getAuthor().getGodUserData().setFollowed(this.erD);
                        author.getGodUserData().setIsFromNetWork(false);
                        qVar3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.erv != null && this.erv.aMp() != null && hVar.aMp() != null) {
                this.erv.aMp().n(hVar.aMp().getItems());
                this.erv.aMp().am(hVar.aMp().qj());
            }
            if (this.erz != null) {
                this.erz.a(true, getErrorCode(), i, i4, this.erv, this.mErrorString, 1);
            }
        }
        if (this.erv != null && this.erv.aMs() != null && this.erv.aMr() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.aRd;
            historyMessage.threadId = getPbData().aMs().getId();
            historyMessage.forumName = getPbData().aMr().getName();
            historyMessage.threadName = getPbData().aMs().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aOw();
            historyMessage.threadType = getPbData().aMs().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        String al;
        if (arrayList != null && hVar.aMt() != null) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(hVar.aMt(), 0);
            if (qVar != null && (al = al(arrayList)) != null && al.equals(qVar.getId())) {
                hVar.aMt().remove(qVar);
            }
            arrayList.addAll(hVar.aMt());
        }
    }

    private String al(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        int s = com.baidu.tbadk.core.util.y.s(arrayList);
        if (s <= 0) {
            return null;
        }
        for (int i = s - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(arrayList, i);
            if (qVar != null && !StringUtils.isNull(qVar.getId())) {
                return qVar.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tieba.pb.data.h hVar) {
        hVar.hm(this.erv.Lm());
        this.erv = hVar;
        ou(hVar.getPage().qz());
    }

    private void aOD() {
        if (this.erv != null && this.erv.aMt() != null && this.erv.aME() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = this.erv.aMt();
            com.baidu.tieba.pb.data.c aME = this.erv.aME();
            int aMi = aME.aMi();
            if (aMi > 0) {
                if (aMi <= aMt.size()) {
                    aMt.add(aMi, aME);
                } else {
                    aMt.add(aME);
                }
            }
        }
    }

    public boolean aOE() {
        if (this.erg == null || this.erh == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return ow(4);
        }
        return ow(6);
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m17if(boolean z) {
        if (this.erg == null || this.erv == null) {
            return false;
        }
        if (z || this.erv.getPage().qB() != 0) {
            return ow(1);
        }
        return false;
    }

    public boolean ig(boolean z) {
        if (this.erg == null || this.erv == null) {
            return false;
        }
        if ((z || this.erv.getPage().qC() != 0) && this.erv.aMt() != null && this.erv.aMt().size() >= 1) {
            return ow(2);
        }
        return false;
    }

    public boolean pj(String str) {
        this.eri = !this.eri;
        this.erh = str;
        ow(6);
        return true;
    }

    public boolean aOF() {
        if (com.baidu.adp.lib.util.i.gm()) {
            this.erj = this.erk;
            this.erk = !this.erk;
        }
        return LoadData();
    }

    public boolean aOG() {
        return this.erk;
    }

    public boolean hasData() {
        return (this.erv == null || this.erv.aMr() == null || this.erv.aMs() == null) ? false : true;
    }

    public boolean nv() {
        if (this.erv == null) {
            return false;
        }
        return this.erv.nv();
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public WriteData fC(String str) {
        if (this.erv == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.erv.aMr().getId());
        writeData.setForumName(this.erv.aMr().getName());
        writeData.setThreadId(this.erg);
        writeData.setIsAd(this.isAd);
        if (str == null) {
            writeData.setType(1);
            return writeData;
        }
        writeData.setType(2);
        writeData.setFloor(str);
        writeData.setFloorNum(0);
        return writeData;
    }

    public MarkData oy(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.erv == null || this.erv.aMt() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = this.erv.aMt();
        if (aMt.size() > 0 && i == aMt.size()) {
            i = aMt.size() - 1;
        }
        if (aMt.size() <= 0 || i >= aMt.size()) {
            return null;
        }
        return e(aMt.get(i));
    }

    public MarkData aOH() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.erg);
        markData.setPostId(this.erv.nu());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eri);
        markData.setSequence(Boolean.valueOf(this.erk));
        markData.setId(this.erg);
        return markData;
    }

    public MarkData e(com.baidu.tieba.tbadkCore.data.q qVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.erg);
        markData.setPostId(qVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eri);
        markData.setSequence(Boolean.valueOf(this.erk));
        markData.setId(this.erg);
        markData.setFloor(qVar.bjO());
        if (qVar instanceof com.baidu.tieba.pb.data.f) {
            markData.setApp(true);
        } else if (qVar instanceof com.baidu.tieba.tbadkCore.data.p) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.p) qVar).isApp());
        }
        return markData;
    }

    public void aOI() {
        cp.aOc().K(aOJ(), this.isFromMark);
    }

    private String aOJ() {
        String str = this.erg;
        if (this.eri) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.erk) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void ih(boolean z) {
        if (this.erv != null) {
            this.erv.ad(z);
        }
    }

    public void ii(boolean z) {
        this.erE = z;
    }

    public boolean aOK() {
        return this.erE;
    }

    public void a(a aVar) {
        this.erz = aVar;
    }

    public void nP(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public String Dg() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public boolean Df() {
        return Fa();
    }

    public boolean pk(String str) {
        if (getPbData() == null || getPbData().aMs() == null || getPbData().aMs().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aMs().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aOL() {
        return this.mRequestType;
    }

    public void aOM() {
        String aOJ = aOJ();
        cp.aOc().K(aOJ, false);
        cp.aOc().K(aOJ, true);
    }

    public void aON() {
        if ("personalize_page".equals(this.ahb)) {
            this.erK = System.currentTimeMillis() / 1000;
        }
    }

    public void aOO() {
        if ("personalize_page".equals(this.ahb) && this.erv != null && this.erK != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10754").ab("fid", this.erv.getForumId()).ab("tid", this.erg).ab("obj_duration", String.valueOf(currentTimeMillis - this.erK)).ab("obj_param3", String.valueOf(currentTimeMillis)));
            this.erK = 0L;
        }
    }

    public boolean aOP() {
        return this.erN;
    }

    public int aOQ() {
        return this.erw;
    }

    public int getErrorNo() {
        return this.erO;
    }

    public com.baidu.tieba.pb.data.g getAppealInfo() {
        return this.mAppealInfo;
    }

    public da aOR() {
        return this.erQ;
    }

    public cq aOS() {
        return this.erR;
    }

    public ct aOT() {
        return this.erS;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.erv != null && this.erv.aMt() != null && this.erv.aMt().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.erv.aMt().size();
                for (int i = 0; i < size; i++) {
                    if (this.erv.aMt().get(i) != null && this.erv.aMt().get(i).getAuthor() != null && currentAccount.equals(this.erv.aMt().get(i).getAuthor().getUserId()) && this.erv.aMt().get(i).getAuthor().getPendantData() != null) {
                        this.erv.aMt().get(i).getAuthor().getPendantData().cq(jVar.pO());
                        this.erv.aMt().get(i).getAuthor().getPendantData().Q(jVar.Cg());
                    }
                }
            }
        }
    }
}
