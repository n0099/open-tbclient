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
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
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
public class dh extends com.baidu.tbadk.editortools.d.a {
    private static final int epg = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int eph = 1;
    private boolean aAl;
    private BaseActivity aPR;
    private CustomMessageListener aUN;
    private String ahs;
    private com.baidu.tieba.tbadkCore.d.b bHt;
    private long ccC;
    private int dwN;
    private com.baidu.adp.framework.listener.a dxc;
    private int ecm;
    private boolean epA;
    private a epB;
    private String epC;
    private String epD;
    private int epE;
    private int epF;
    private boolean epG;
    private boolean epH;
    private boolean epI;
    private boolean epJ;
    private boolean epK;
    private String epL;
    private long epM;
    private boolean epN;
    private int epO;
    private boolean epP;
    private int epQ;
    private final dn epR;
    private final da epS;
    private final cq epT;
    private final ct epU;
    private CustomMessageListener epV;
    private PraiseData epW;
    protected String epi;
    private String epj;
    private boolean epk;
    private boolean epl;
    private boolean epm;
    private long epn;
    private int epo;
    private int epp;
    private int epq;
    private boolean epr;
    private boolean eps;
    private boolean ept;
    private long epu;
    private boolean epv;
    private String epw;
    protected com.baidu.tieba.pb.data.h epx;
    private int epy;
    private boolean epz;
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

    public String aNK() {
        return this.epL;
    }

    public void oS(String str) {
        this.epL = str;
    }

    public void ib(boolean z) {
        this.epN = z;
    }

    public dh(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.ahs = null;
        this.epi = null;
        this.epj = null;
        this.epk = false;
        this.epl = true;
        this.epm = true;
        this.mIsGood = 0;
        this.dwN = 0;
        this.epn = 0L;
        this.epo = 1;
        this.epp = 1;
        this.epq = 1;
        this.ecm = 1;
        this.isAd = false;
        this.epr = false;
        this.eps = false;
        this.isFromMark = false;
        this.ept = false;
        this.epu = 0L;
        this.epv = false;
        this.epw = null;
        this.epx = null;
        this.aAl = false;
        this.epz = false;
        this.epA = false;
        this.mLocate = null;
        this.mContext = null;
        this.epB = null;
        this.opType = null;
        this.opUrl = null;
        this.epC = null;
        this.epD = null;
        this.epE = -1;
        this.epF = -1;
        this.bHt = null;
        this.epH = false;
        this.epI = false;
        this.postID = null;
        this.epL = null;
        this.epM = 0L;
        this.epN = false;
        this.epO = -1;
        this.aUN = new di(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.epV = new dk(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.dxc = new dl(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.epW = null;
        registerListener(this.aUN);
        registerListener(this.dxc);
        registerListener(this.epV);
        this.epx = new com.baidu.tieba.pb.data.h();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aPR = baseActivity;
        this.epR = new dn(this, this.aPR);
        this.epS = new da(this, this.aPR);
        this.epT = new cq(this, this.aPR);
        this.epU = new ct(this, this.aPR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aNL() {
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
        this.epi = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.epi)) {
            this.epi = this.epR.x(intent);
        }
        this.epj = intent.getStringExtra("post_id");
        this.epk = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.epm = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.ahs = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dwN = intent.getIntExtra("is_top", 0);
        this.epn = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.eps = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.ept = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.epr = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.epv = intent.getBooleanExtra("is_pv", false);
        this.epu = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.epw = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.epD = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.epC = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.epz = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.epA = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.epF = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.epE = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void initWithBundle(Bundle bundle) {
        this.epi = bundle.getString("thread_id");
        this.epj = bundle.getString("post_id");
        this.epk = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.epm = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.ahs = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dwN = bundle.getInt("is_top", 0);
        this.epn = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.eps = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.ept = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.epr = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.epv = bundle.getBoolean("is_pv", false);
        this.epu = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.epw = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.epD = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.epz = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.epA = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.epF = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.epE = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void n(Bundle bundle) {
        bundle.putString("thread_id", this.epi);
        bundle.putString("post_id", this.epj);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.epk);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.epm);
        bundle.putString("st_type", this.ahs);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dwN);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.epn);
        bundle.putBoolean("from_frs", this.eps);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.ept);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.epr);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.epv);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.epu);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.epD);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.epz);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.epA);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.epF);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.epE);
    }

    public String aNM() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.epi);
        if (!this.ept) {
            sb.append(this.epj);
        }
        sb.append(this.epk);
        sb.append(this.epm);
        sb.append(this.ahs);
        sb.append(this.mIsGood);
        sb.append(this.dwN);
        sb.append(this.epn);
        sb.append(this.eps);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.epr);
        sb.append(this.epv);
        sb.append(this.epu);
        sb.append(this.epw);
        sb.append(this.mThreadType);
        sb.append(this.epz);
        sb.append(this.epA);
        if (this.epD != null) {
            sb.append(this.epD);
        }
        return sb.toString();
    }

    public String aNN() {
        return this.epw;
    }

    public String getPostId() {
        return this.epj;
    }

    public void oT(String str) {
        this.epj = str;
    }

    public String getThreadID() {
        return this.epi;
    }

    public boolean getHostMode() {
        return this.epk;
    }

    public boolean aNO() {
        return this.epm;
    }

    public boolean aNP() {
        return this.eps;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aNQ() {
        return HotTopicActivityConfig.ST_TYPE.equals(this.ahs);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aAv() {
        return this.dwN;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void oh(int i) {
        this.dwN = i;
    }

    public boolean aNR() {
        return this.epr;
    }

    public boolean aNS() {
        if (this.epx == null) {
            return false;
        }
        return this.epx.isValid();
    }

    public String rJ() {
        if (this.epx == null || !this.epx.nv()) {
            return null;
        }
        return this.epx.nu();
    }

    public boolean oi(int i) {
        this.epo = i;
        if (this.epo > this.epx.getPage().ql()) {
            this.epo = this.epx.getPage().ql();
        }
        if (this.epo < 1) {
            this.epo = 1;
        }
        if (this.epi == null) {
            return false;
        }
        return om(5);
    }

    public boolean oj(int i) {
        int so = this.epx.aLQ().so();
        if (i <= so) {
            so = i;
        }
        int i2 = so >= 1 ? so : 1;
        if (this.epi == null) {
            return false;
        }
        this.epO = i2;
        return om(7);
    }

    public void ok(int i) {
        this.epo = i;
        this.epp = i;
        this.epq = i;
    }

    public void ol(int i) {
        if (this.epp < i) {
            this.epp = i;
            if (this.epp - this.epq >= epg) {
                this.epq = (this.epp - epg) + 1;
            }
        }
        if (this.epq > i) {
            this.epq = i;
            if (this.epp - this.epq >= epg) {
                this.epp = (this.epq + epg) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        return this.epx;
    }

    public com.baidu.tbadk.core.data.ak aoU() {
        if (this.epx == null) {
            return null;
        }
        return this.epx.getPage();
    }

    public boolean aNT() {
        if (this.epm) {
            if (this.epx.getPage().qq() == 0) {
                ic(true);
                return true;
            }
        } else if (this.epx.getPage().qr() == 0) {
            id(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.epi == null) {
            return false;
        }
        cancelLoadData();
        if (this.bHt == null) {
            this.bHt = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bHt.start();
        }
        boolean om = om(3);
        if (this.opType != null) {
            this.opType = null;
            this.epC = null;
            this.opUrl = null;
            return om;
        }
        return om;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.aAl = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        XO();
    }

    private void XO() {
        if (this.bHt != null) {
            this.bHt.destory();
            this.bHt = null;
        }
    }

    public boolean Fa() {
        return (this.epj == null || this.epj.equals("0") || this.epj.length() == 0) ? LoadData() : aNW();
    }

    public boolean om(int i) {
        this.mRequestType = i;
        if (this.aAl) {
            return false;
        }
        this.aAl = true;
        on(i);
        com.baidu.tieba.pb.data.h pbData = ep.aOQ().getPbData();
        if (pbData != null && pbData.aLQ() != null) {
            pbData.aLQ().bT(0);
            this.epm = ep.aOQ().aNO();
            this.epk = ep.aOQ().aOS();
            if (!this.epm || this.epk || this.isFromMark) {
                this.epG = false;
            }
            com.baidu.adp.lib.h.h.eG().post(new dm(this, pbData));
            return false;
        }
        if (i == 4 && !this.epK) {
            a(aOb(), true, this.epj, 3);
        }
        if (i == 3 && !this.epK) {
            if (this.isFromMark) {
                a(aOb(), true, this.epj, 3);
            } else {
                a(aOb(), false, this.epj, 3);
            }
        }
        this.epK = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.atg);
        if (!this.epm || this.epk || this.isFromMark) {
            this.epG = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.epi == null || this.epi.length() == 0) {
            this.aAl = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.epi, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.bb.vk().vm() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.epm) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.epk) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.ahs != null) {
            pbPageRequestMessage.set_st_type(this.ahs);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.epv) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.epu));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.epG) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.h.b.g(this.epC, 0));
            pbPageRequestMessage.setOpMessageID(this.epu);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = this.epx.aLR();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.epm) {
                        if (this.epq - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.epq - 1));
                        }
                    } else if (this.epp < this.ecm) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.epp + 1));
                    }
                }
                if (aLR != null && aLR.size() > 0) {
                    int size = aLR.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.q qVar = aLR.get(size - i3);
                        if (qVar == null) {
                            i3++;
                        } else {
                            this.epj = qVar.getId();
                            if (StringUtils.isNull(this.epj)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.epj != null && this.epj.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.epj, 0L));
                    break;
                } else if (!this.epm) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aLR != null && aLR.size() > 0 && aLR.get(0) != null) {
                    this.epj = aLR.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.epm) {
                        if (this.epq - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.epq - 1));
                        }
                    } else if (this.epp < this.ecm) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.epp + 1));
                    }
                }
                if (this.epj != null && this.epj.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.epj, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.epm) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.epj, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.epo));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.epj, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.epO);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aOb());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.aPR != null && (this.aPR instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.aPR).aMD());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.epN);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void on(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = this.epx.aLR();
        this.epJ = false;
        if (i == 1) {
            boolean z2 = false;
            while (aLR.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aLR.remove(0);
                z2 = true;
            }
            if (z2) {
                this.epx.getPage().bQ(1);
                if (this.epB != null) {
                    this.epB.c(this.epx);
                }
            }
            this.ccC = System.currentTimeMillis();
            this.epJ = true;
        } else if (i == 2) {
            while (aLR.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aLR.remove(aLR.size() - 1);
                z = true;
            }
            if (z) {
                this.epx.getPage().bP(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.h hVar2 = z ? null : hVar;
        this.epQ = i2;
        this.aAl = false;
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
            if (this.epz || this.epA) {
                hVar = f(hVar);
            }
            e(hVar);
        }
    }

    protected void e(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null) {
            String g = g(hVar);
            for (int i = 0; i < hVar.aLR().size(); i++) {
                com.baidu.tieba.tbadkCore.data.q qVar = hVar.aLR().get(i);
                for (int i2 = 0; i2 < qVar.biY().size(); i2++) {
                    qVar.biY().get(i2).c(this.aPR.getPageContext(), g.equals(qVar.biY().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.h f(com.baidu.tieba.pb.data.h hVar) {
        if (hVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.bg aLQ = hVar.aLQ();
        aLQ.bW(this.mIsGood);
        aLQ.bV(this.dwN);
        if (this.epn > 0) {
            aLQ.p(this.epn);
            return hVar;
        }
        return hVar;
    }

    protected String g(com.baidu.tieba.pb.data.h hVar) {
        String str = null;
        if (hVar == null) {
            return null;
        }
        if (hVar.aLQ() != null && hVar.aLQ().getAuthor() != null) {
            str = hVar.aLQ().getAuthor().getUserId();
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
        if (hVar.aLQ() != null && hVar.aLQ().getAuthor() != null) {
            str = hVar.aLQ().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aNU() {
        if (this.epx == null || this.epx.aLQ() == null || this.epx.aLQ().getAuthor() == null) {
            return null;
        }
        return this.epx.aLQ().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.epP = z3;
        this.epy = i;
        if (this.bHt != null && !z3) {
            this.bHt.a(z2, z4, i2, str, i3, j, j2);
            this.bHt = null;
        }
        if (hVar == null || (this.epo == 1 && i == 5 && hVar.aLR() != null && hVar.aLR().size() < 1)) {
            if (this.epB != null) {
                this.epm = this.epl;
                this.epB.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.epl = this.epm;
            this.epv = false;
            if (hVar.getPage() != null) {
                ol(hVar.getPage().qo());
                this.ecm = hVar.getPage().ql();
            }
            this.ecm = this.ecm < 1 ? 1 : this.ecm;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = this.epx.aLR();
            switch (i) {
                case 1:
                    this.epx.a(hVar.getPage(), 1);
                    a(hVar, aLR);
                    i4 = 0;
                    break;
                case 2:
                    if (hVar.aLR() != null) {
                        int size = hVar.aLR().size() + 1;
                        com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(aLR, 0);
                        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(hVar.aLR(), com.baidu.tbadk.core.util.y.s(hVar.aLR()) - 1);
                        if (qVar == null || qVar2 == null || !qVar.getId().equals(qVar2.getId())) {
                            i5 = size;
                        } else {
                            hVar.aLR().remove(qVar2);
                            i5 = size - 1;
                        }
                        aLR.addAll(0, hVar.aLR());
                    }
                    this.epx.a(hVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.epm && hVar.getPage() != null) {
                        hVar.getPage().bN(hVar.getPage().ql());
                    }
                    i(hVar);
                    if (!z3 && this.mThreadType != 33 && this.epm) {
                        aNV();
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
            if (this.epx != null && this.epx.aLQ() != null) {
                PraiseData rt = this.epx.aLQ().rt();
                if (this.epW != null && !rt.isPriaseDataValid()) {
                    this.epx.aLQ().a(this.epW);
                } else {
                    this.epW = this.epx.aLQ().rt();
                    this.epW.setPostId(this.epx.aLQ().rQ());
                }
                if (hVar.getPage() != null && hVar.getPage().qo() == 1 && hVar.aLQ() != null && hVar.aLQ().rL() != null && hVar.aLQ().rL().size() > 0) {
                    this.epx.aLQ().i(hVar.aLQ().rL());
                }
                this.epx.aLQ().bU(hVar.aLQ().rv());
                this.epx.aLQ().setAnchorLevel(hVar.aLQ().getAnchorLevel());
                this.epx.aLQ().bT(hVar.aLQ().rr());
                if (this.mThreadType == 33) {
                    this.epx.aLQ().getAuthor().setHadConcerned(hVar.aLQ().getAuthor().hadConcerned());
                }
            }
            if (this.epx != null && this.epx.getUserData() != null && hVar.getUserData() != null) {
                this.epx.getUserData().setBimg_end_time(hVar.getUserData().getBimg_end_time());
                this.epx.getUserData().setBimg_url(hVar.getUserData().getBimg_url());
            }
            if (this.epP && this.epx.aLQ() != null && this.epx.aLQ().getAuthor() != null && this.epx.aLR() != null && com.baidu.tbadk.core.util.y.c(this.epx.aLR(), 0) != null) {
                com.baidu.tieba.tbadkCore.data.q qVar3 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(this.epx.aLR(), 0);
                MetaData author = this.epx.aLQ().getAuthor();
                if (qVar3.getAuthor() != null && qVar3.getAuthor().getGodUserData() != null) {
                    if (this.epE != -1) {
                        author.setFansNum(this.epE);
                        qVar3.getAuthor().setFansNum(this.epE);
                    }
                    if (this.epF != -1) {
                        author.getGodUserData().setFollowed(this.epF);
                        qVar3.getAuthor().getGodUserData().setFollowed(this.epF);
                        author.getGodUserData().setIsFromNetWork(false);
                        qVar3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.epx != null && this.epx.aLN() != null && hVar.aLN() != null) {
                this.epx.aLN().n(hVar.aLN().getItems());
                this.epx.aLN().am(hVar.aLN().pY());
            }
            if (this.epB != null) {
                this.epB.a(true, getErrorCode(), i, i4, this.epx, this.mErrorString, 1);
            }
        }
        if (this.epx != null && this.epx.aLQ() != null && this.epx.aLP() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.aPR;
            historyMessage.threadId = getPbData().aLQ().getId();
            historyMessage.forumName = getPbData().aLP().getName();
            historyMessage.threadName = getPbData().aLQ().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aNO();
            historyMessage.threadType = getPbData().aLQ().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        String al;
        if (arrayList != null && hVar.aLR() != null) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(hVar.aLR(), 0);
            if (qVar != null && (al = al(arrayList)) != null && al.equals(qVar.getId())) {
                hVar.aLR().remove(qVar);
            }
            arrayList.addAll(hVar.aLR());
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
        hVar.hf(this.epx.KD());
        this.epx = hVar;
        ok(hVar.getPage().qo());
    }

    private void aNV() {
        if (this.epx != null && this.epx.aLR() != null && this.epx.aMc() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = this.epx.aLR();
            com.baidu.tieba.pb.data.c aMc = this.epx.aMc();
            int aLG = aMc.aLG();
            if (aLG > 0) {
                if (aLG <= aLR.size()) {
                    aLR.add(aLG, aMc);
                } else {
                    aLR.add(aMc);
                }
            }
        }
    }

    public boolean aNW() {
        if (this.epi == null || this.epj == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return om(4);
        }
        return om(6);
    }

    public boolean ic(boolean z) {
        if (this.epi == null || this.epx == null) {
            return false;
        }
        if (z || this.epx.getPage().qq() != 0) {
            return om(1);
        }
        return false;
    }

    public boolean id(boolean z) {
        if (this.epi == null || this.epx == null) {
            return false;
        }
        if ((z || this.epx.getPage().qr() != 0) && this.epx.aLR() != null && this.epx.aLR().size() >= 1) {
            return om(2);
        }
        return false;
    }

    public boolean oU(String str) {
        this.epk = !this.epk;
        this.epj = str;
        om(6);
        return true;
    }

    public boolean aNX() {
        if (com.baidu.adp.lib.util.i.gm()) {
            this.epl = this.epm;
            this.epm = !this.epm;
        }
        return LoadData();
    }

    public boolean aNY() {
        return this.epm;
    }

    public boolean hasData() {
        return (this.epx == null || this.epx.aLP() == null || this.epx.aLQ() == null) ? false : true;
    }

    public boolean nv() {
        if (this.epx == null) {
            return false;
        }
        return this.epx.nv();
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fz(String str) {
        if (this.epx == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.epx.aLP().getId());
        writeData.setForumName(this.epx.aLP().getName());
        writeData.setThreadId(this.epi);
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

    public MarkData oo(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.epx == null || this.epx.aLR() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = this.epx.aLR();
        if (aLR.size() > 0 && i == aLR.size()) {
            i = aLR.size() - 1;
        }
        if (aLR.size() <= 0 || i >= aLR.size()) {
            return null;
        }
        return e(aLR.get(i));
    }

    public MarkData aNZ() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.epi);
        markData.setPostId(this.epx.nu());
        markData.setTime(date.getTime());
        markData.setHostMode(this.epk);
        markData.setSequence(Boolean.valueOf(this.epm));
        markData.setId(this.epi);
        return markData;
    }

    public MarkData e(com.baidu.tieba.tbadkCore.data.q qVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.epi);
        markData.setPostId(qVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.epk);
        markData.setSequence(Boolean.valueOf(this.epm));
        markData.setId(this.epi);
        markData.setFloor(qVar.bjc());
        if (qVar instanceof com.baidu.tieba.pb.data.f) {
            markData.setApp(true);
        } else if (qVar instanceof com.baidu.tieba.tbadkCore.data.p) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.p) qVar).isApp());
        }
        return markData;
    }

    public void aOa() {
        cp.aNu().J(aOb(), this.isFromMark);
    }

    private String aOb() {
        String str = this.epi;
        if (this.epk) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.epm) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void ie(boolean z) {
        if (this.epx != null) {
            this.epx.ad(z);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m17if(boolean z) {
        this.epG = z;
    }

    public boolean aOc() {
        return this.epG;
    }

    public void a(a aVar) {
        this.epB = aVar;
    }

    public void nB(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String Dg() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean Df() {
        return Fa();
    }

    public boolean oV(String str) {
        if (getPbData() == null || getPbData().aLQ() == null || getPbData().aLQ().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aLQ().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aOd() {
        return this.mRequestType;
    }

    public void aOe() {
        String aOb = aOb();
        cp.aNu().J(aOb, false);
        cp.aNu().J(aOb, true);
    }

    public void aOf() {
        if ("personalize_page".equals(this.ahs)) {
            this.epM = System.currentTimeMillis() / 1000;
        }
    }

    public void aOg() {
        if ("personalize_page".equals(this.ahs) && this.epx != null && this.epM != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10754").ab("fid", this.epx.getForumId()).ab("tid", this.epi).ab("obj_duration", String.valueOf(currentTimeMillis - this.epM)).ab("obj_param3", String.valueOf(currentTimeMillis)));
            this.epM = 0L;
        }
    }

    public boolean aOh() {
        return this.epP;
    }

    public int aOi() {
        return this.epy;
    }

    public int getErrorNo() {
        return this.epQ;
    }

    public com.baidu.tieba.pb.data.g getAppealInfo() {
        return this.mAppealInfo;
    }

    public da aOj() {
        return this.epS;
    }

    public cq aOk() {
        return this.epT;
    }

    public ct aOl() {
        return this.epU;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.epx != null && this.epx.aLR() != null && this.epx.aLR().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.epx.aLR().size();
                for (int i = 0; i < size; i++) {
                    if (this.epx.aLR().get(i) != null && this.epx.aLR().get(i).getAuthor() != null && currentAccount.equals(this.epx.aLR().get(i).getAuthor().getUserId()) && this.epx.aLR().get(i).getAuthor().getPendantData() != null) {
                        this.epx.aLR().get(i).getAuthor().getPendantData().cq(jVar.rc());
                        this.epx.aLR().get(i).getAuthor().getPendantData().P(jVar.Cd());
                    }
                }
            }
        }
    }
}
