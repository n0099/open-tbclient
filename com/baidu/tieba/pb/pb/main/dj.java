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
public class dj extends com.baidu.tbadk.editortools.e.a {
    private static final int ewX = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int ewY = 1;
    private boolean aAG;
    private BaseActivity aTb;
    private CustomMessageListener aXI;
    private String ahB;
    private com.baidu.tieba.tbadkCore.d.b bKu;
    private long cfZ;
    private int dDR;
    private com.baidu.adp.framework.listener.a dEb;
    private int eke;
    protected String ewZ;
    private boolean exA;
    private boolean exB;
    private boolean exC;
    private String exD;
    private long exE;
    private boolean exF;
    private int exG;
    private boolean exH;
    private int exI;
    private final dp exJ;
    private final dc exK;
    private final cr exL;
    private final cu exM;
    private CustomMessageListener exN;
    private PraiseData exO;
    private String exa;
    private boolean exb;
    private boolean exc;
    private boolean exd;
    private long exe;
    private int exf;
    private int exg;
    private int exh;
    private boolean exi;
    private boolean exj;
    private boolean exk;
    private long exl;
    private boolean exm;
    private String exn;
    protected com.baidu.tieba.pb.data.h exo;
    private int exp;
    private boolean exq;
    private boolean exr;
    private a exs;
    private String exu;
    private String exv;
    private int exw;
    private int exx;
    private boolean exy;
    private boolean exz;
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

    public String aQl() {
        return this.exD;
    }

    public void pu(String str) {
        this.exD = str;
    }

    public void iw(boolean z) {
        this.exF = z;
    }

    public dj(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.ahB = null;
        this.ewZ = null;
        this.exa = null;
        this.exb = false;
        this.exc = true;
        this.exd = true;
        this.mIsGood = 0;
        this.dDR = 0;
        this.exe = 0L;
        this.exf = 1;
        this.exg = 1;
        this.exh = 1;
        this.eke = 1;
        this.isAd = false;
        this.exi = false;
        this.exj = false;
        this.isFromMark = false;
        this.exk = false;
        this.exl = 0L;
        this.exm = false;
        this.exn = null;
        this.exo = null;
        this.aAG = false;
        this.exq = false;
        this.exr = false;
        this.mLocate = null;
        this.mContext = null;
        this.exs = null;
        this.opType = null;
        this.opUrl = null;
        this.exu = null;
        this.exv = null;
        this.exw = -1;
        this.exx = -1;
        this.bKu = null;
        this.exz = false;
        this.exA = false;
        this.postID = null;
        this.exD = null;
        this.exE = 0L;
        this.exF = false;
        this.exG = -1;
        this.aXI = new dk(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.exN = new dm(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.dEb = new dn(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.exO = null;
        registerListener(this.aXI);
        registerListener(this.dEb);
        registerListener(this.exN);
        this.exo = new com.baidu.tieba.pb.data.h();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aTb = baseActivity;
        this.exJ = new dp(this, this.aTb);
        this.exK = new dc(this, this.aTb);
        this.exL = new cr(this, this.aTb);
        this.exM = new cu(this, this.aTb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aQm() {
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
        this.ewZ = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.ewZ)) {
            this.ewZ = this.exJ.v(intent);
        }
        this.exa = intent.getStringExtra("post_id");
        this.exb = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.exd = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.ahB = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dDR = intent.getIntExtra("is_top", 0);
        this.exe = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.exj = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.exk = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.exi = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.exm = intent.getBooleanExtra("is_pv", false);
        this.exl = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.exn = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.exv = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.exu = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.exq = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.exr = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.exx = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.exw = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void initWithBundle(Bundle bundle) {
        this.ewZ = bundle.getString("thread_id");
        this.exa = bundle.getString("post_id");
        this.exb = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.exd = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.ahB = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dDR = bundle.getInt("is_top", 0);
        this.exe = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.exj = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.exk = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.exi = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.exm = bundle.getBoolean("is_pv", false);
        this.exl = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.exn = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.exv = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.exq = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.exr = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.exx = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.exw = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void n(Bundle bundle) {
        bundle.putString("thread_id", this.ewZ);
        bundle.putString("post_id", this.exa);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.exb);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.exd);
        bundle.putString("st_type", this.ahB);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dDR);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.exe);
        bundle.putBoolean("from_frs", this.exj);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.exk);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.exi);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.exm);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.exl);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.exv);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.exq);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.exr);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.exx);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.exw);
    }

    public String aQn() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.ewZ);
        if (!this.exk) {
            sb.append(this.exa);
        }
        sb.append(this.exb);
        sb.append(this.exd);
        sb.append(this.ahB);
        sb.append(this.mIsGood);
        sb.append(this.dDR);
        sb.append(this.exe);
        sb.append(this.exj);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.exi);
        sb.append(this.exm);
        sb.append(this.exl);
        sb.append(this.exn);
        sb.append(this.mThreadType);
        sb.append(this.exq);
        sb.append(this.exr);
        if (this.exv != null) {
            sb.append(this.exv);
        }
        return sb.toString();
    }

    public String aQo() {
        return this.exn;
    }

    public String getPostId() {
        return this.exa;
    }

    public void pv(String str) {
        this.exa = str;
    }

    public String getThreadID() {
        return this.ewZ;
    }

    public boolean getHostMode() {
        return this.exb;
    }

    public boolean aQp() {
        return this.exd;
    }

    public boolean aQq() {
        return this.exj;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aQr() {
        return "hot_topic".equals(this.ahB);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aCP() {
        return this.dDR;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void oB(int i) {
        this.dDR = i;
    }

    public boolean aQs() {
        return this.exi;
    }

    public boolean aQt() {
        if (this.exo == null) {
            return false;
        }
        return this.exo.isValid();
    }

    public String rX() {
        if (this.exo == null || !this.exo.nz()) {
            return null;
        }
        return this.exo.ny();
    }

    public boolean oC(int i) {
        this.exf = i;
        if (this.exf > this.exo.getPage().qy()) {
            this.exf = this.exo.getPage().qy();
        }
        if (this.exf < 1) {
            this.exf = 1;
        }
        if (this.ewZ == null) {
            return false;
        }
        return oG(5);
    }

    public boolean oD(int i) {
        int sC = this.exo.aOl().sC();
        if (i <= sC) {
            sC = i;
        }
        int i2 = sC >= 1 ? sC : 1;
        if (this.ewZ == null) {
            return false;
        }
        this.exG = i2;
        return oG(7);
    }

    public void oE(int i) {
        this.exf = i;
        this.exg = i;
        this.exh = i;
    }

    public void oF(int i) {
        if (this.exg < i) {
            this.exg = i;
            if (this.exg - this.exh >= ewX) {
                this.exh = (this.exg - ewX) + 1;
            }
        }
        if (this.exh > i) {
            this.exh = i;
            if (this.exg - this.exh >= ewX) {
                this.exg = (this.exh + ewX) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        return this.exo;
    }

    public com.baidu.tbadk.core.data.ao are() {
        if (this.exo == null) {
            return null;
        }
        return this.exo.getPage();
    }

    public boolean aQu() {
        if (this.exd) {
            if (this.exo.getPage().qD() == 0) {
                ix(true);
                return true;
            }
        } else if (this.exo.getPage().qE() == 0) {
            iy(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.ewZ == null) {
            return false;
        }
        cancelLoadData();
        if (this.bKu == null) {
            this.bKu = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bKu.start();
        }
        boolean oG = oG(3);
        if (this.opType != null) {
            this.opType = null;
            this.exu = null;
            this.opUrl = null;
            return oG;
        }
        return oG;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.aAG = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Zj();
    }

    private void Zj() {
        if (this.bKu != null) {
            this.bKu.destory();
            this.bKu = null;
        }
    }

    public boolean Ff() {
        return (this.exa == null || this.exa.equals("0") || this.exa.length() == 0) ? LoadData() : aQx();
    }

    public boolean oG(int i) {
        this.mRequestType = i;
        if (this.aAG) {
            return false;
        }
        this.aAG = true;
        oH(i);
        com.baidu.tieba.pb.data.h pbData = eq.aRA().getPbData();
        if (pbData != null && pbData.aOl() != null) {
            pbData.aOl().bT(0);
            this.exd = eq.aRA().aQp();
            this.exb = eq.aRA().aRC();
            if (!this.exd || this.exb || this.isFromMark) {
                this.exy = false;
            }
            com.baidu.adp.lib.h.h.eG().post(new Cdo(this, pbData));
            return false;
        }
        if (i == 4 && !this.exC) {
            a(aQC(), true, this.exa, 3);
        }
        if (i == 3 && !this.exC) {
            if (this.isFromMark) {
                a(aQC(), true, this.exa, 3);
            } else {
                a(aQC(), false, this.exa, 3);
            }
        }
        this.exC = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.atE);
        if (!this.exd || this.exb || this.isFromMark) {
            this.exy = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.ewZ == null || this.ewZ.length() == 0) {
            this.aAG = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.ewZ, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.ay.vC().vE() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.exd) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.exb) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.ahB != null) {
            pbPageRequestMessage.set_st_type(this.ahB);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.exm) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.exl));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.exy) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.h.b.g(this.exu, 0));
            pbPageRequestMessage.setOpMessageID(this.exl);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = this.exo.aOm();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.exd) {
                        if (this.exh - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.exh - 1));
                        }
                    } else if (this.exg < this.eke) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.exg + 1));
                    }
                }
                if (aOm != null && aOm.size() > 0) {
                    int size = aOm.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.q qVar = aOm.get(size - i3);
                        if (qVar == null) {
                            i3++;
                        } else {
                            this.exa = qVar.getId();
                            if (StringUtils.isNull(this.exa)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.exa != null && this.exa.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.exa, 0L));
                    break;
                } else if (!this.exd) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aOm != null && aOm.size() > 0 && aOm.get(0) != null) {
                    this.exa = aOm.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.exd) {
                        if (this.exh - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.exh - 1));
                        }
                    } else if (this.exg < this.eke) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.exg + 1));
                    }
                }
                if (this.exa != null && this.exa.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.exa, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.exd) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.exa, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.exf));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.exa, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.exG);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aQC());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.aTb != null && (this.aTb instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.aTb).aPa());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.exF);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void oH(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = this.exo.aOm();
        this.exB = false;
        if (i == 1) {
            boolean z2 = false;
            while (aOm.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aOm.remove(0);
                z2 = true;
            }
            if (z2) {
                this.exo.getPage().bQ(1);
                if (this.exs != null) {
                    this.exs.c(this.exo);
                }
            }
            this.cfZ = System.currentTimeMillis();
            this.exB = true;
        } else if (i == 2) {
            while (aOm.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aOm.remove(aOm.size() - 1);
                z = true;
            }
            if (z) {
                this.exo.getPage().bP(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.h hVar2 = z ? null : hVar;
        this.exI = i2;
        this.aAG = false;
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
            if (this.exq || this.exr) {
                hVar = f(hVar);
            }
            e(hVar);
        }
    }

    protected void e(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null) {
            String g = g(hVar);
            for (int i = 0; i < hVar.aOm().size(); i++) {
                com.baidu.tieba.tbadkCore.data.q qVar = hVar.aOm().get(i);
                for (int i2 = 0; i2 < qVar.bmi().size(); i2++) {
                    qVar.bmi().get(i2).b(this.aTb.getPageContext(), g.equals(qVar.bmi().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.h f(com.baidu.tieba.pb.data.h hVar) {
        if (hVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.bk aOl = hVar.aOl();
        aOl.bW(this.mIsGood);
        aOl.bV(this.dDR);
        if (this.exe > 0) {
            aOl.o(this.exe);
            return hVar;
        }
        return hVar;
    }

    protected String g(com.baidu.tieba.pb.data.h hVar) {
        String str = null;
        if (hVar == null) {
            return null;
        }
        if (hVar.aOl() != null && hVar.aOl().getAuthor() != null) {
            str = hVar.aOl().getAuthor().getUserId();
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
        if (hVar.aOl() != null && hVar.aOl().getAuthor() != null) {
            str = hVar.aOl().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aQv() {
        if (this.exo == null || this.exo.aOl() == null || this.exo.aOl().getAuthor() == null) {
            return null;
        }
        return this.exo.aOl().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.exH = z3;
        this.exp = i;
        if (this.bKu != null && !z3) {
            this.bKu.a(z2, z4, i2, str, i3, j, j2);
            this.bKu = null;
        }
        if (hVar == null || (this.exf == 1 && i == 5 && hVar.aOm() != null && hVar.aOm().size() < 1)) {
            if (this.exs != null) {
                this.exd = this.exc;
                this.exs.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.exc = this.exd;
            this.exm = false;
            if (hVar.getPage() != null) {
                oF(hVar.getPage().qB());
                this.eke = hVar.getPage().qy();
            }
            this.eke = this.eke < 1 ? 1 : this.eke;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = this.exo.aOm();
            switch (i) {
                case 1:
                    this.exo.a(hVar.getPage(), 1);
                    a(hVar, aOm);
                    i4 = 0;
                    break;
                case 2:
                    if (hVar.aOm() != null) {
                        int size = hVar.aOm().size() + 1;
                        com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(aOm, 0);
                        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(hVar.aOm(), com.baidu.tbadk.core.util.x.s(hVar.aOm()) - 1);
                        if (qVar == null || qVar2 == null || !qVar.getId().equals(qVar2.getId())) {
                            i5 = size;
                        } else {
                            hVar.aOm().remove(qVar2);
                            i5 = size - 1;
                        }
                        aOm.addAll(0, hVar.aOm());
                    }
                    this.exo.a(hVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.exd && hVar.getPage() != null) {
                        hVar.getPage().bN(hVar.getPage().qy());
                    }
                    i(hVar);
                    if (!z3 && this.mThreadType != 33 && this.exd) {
                        aQw();
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
            if (this.exo != null && this.exo.aOl() != null) {
                PraiseData rH = this.exo.aOl().rH();
                if (this.exO != null && !rH.isPriaseDataValid()) {
                    this.exo.aOl().a(this.exO);
                } else {
                    this.exO = this.exo.aOl().rH();
                    this.exO.setPostId(this.exo.aOl().se());
                }
                if (hVar.getPage() != null && hVar.getPage().qB() == 1 && hVar.aOl() != null && hVar.aOl().rZ() != null && hVar.aOl().rZ().size() > 0) {
                    this.exo.aOl().i(hVar.aOl().rZ());
                }
                this.exo.aOl().bU(hVar.aOl().rJ());
                this.exo.aOl().setAnchorLevel(hVar.aOl().getAnchorLevel());
                this.exo.aOl().bT(hVar.aOl().rF());
                if (this.mThreadType == 33) {
                    this.exo.aOl().getAuthor().setHadConcerned(hVar.aOl().getAuthor().hadConcerned());
                }
            }
            if (this.exo != null && this.exo.getUserData() != null && hVar.getUserData() != null) {
                this.exo.getUserData().setBimg_end_time(hVar.getUserData().getBimg_end_time());
                this.exo.getUserData().setBimg_url(hVar.getUserData().getBimg_url());
            }
            if (hVar.getPage() != null && hVar.getPage().qB() == 1 && hVar.aOs() != null) {
                this.exo.a(hVar.aOs());
            }
            if (this.exH && this.exo.aOl() != null && this.exo.aOl().getAuthor() != null && this.exo.aOm() != null && com.baidu.tbadk.core.util.x.c(this.exo.aOm(), 0) != null) {
                com.baidu.tieba.tbadkCore.data.q qVar3 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(this.exo.aOm(), 0);
                MetaData author = this.exo.aOl().getAuthor();
                if (qVar3.getAuthor() != null && qVar3.getAuthor().getGodUserData() != null) {
                    if (this.exw != -1) {
                        author.setFansNum(this.exw);
                        qVar3.getAuthor().setFansNum(this.exw);
                    }
                    if (this.exx != -1) {
                        author.getGodUserData().setIsLike(this.exx == 1);
                        qVar3.getAuthor().getGodUserData().setIsLike(this.exx == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        qVar3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.exo != null && this.exo.aOi() != null && hVar.aOi() != null) {
                this.exo.aOi().n(hVar.aOi().getItems());
                this.exo.aOi().ao(hVar.aOi().ql());
            }
            if (this.exs != null) {
                this.exs.a(true, getErrorCode(), i, i4, this.exo, this.mErrorString, 1);
            }
        }
        if (this.exo != null && this.exo.aOl() != null && this.exo.aOk() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.aTb;
            historyMessage.threadId = getPbData().aOl().getId();
            historyMessage.forumName = getPbData().aOk().getName();
            historyMessage.threadName = getPbData().aOl().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aQp();
            historyMessage.threadType = getPbData().aOl().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        String ao;
        if (arrayList != null && hVar.aOm() != null) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(hVar.aOm(), 0);
            if (qVar != null && (ao = ao(arrayList)) != null && ao.equals(qVar.getId())) {
                hVar.aOm().remove(qVar);
            }
            arrayList.addAll(hVar.aOm());
        }
    }

    private String ao(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        int s = com.baidu.tbadk.core.util.x.s(arrayList);
        if (s <= 0) {
            return null;
        }
        for (int i = s - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(arrayList, i);
            if (qVar != null && !StringUtils.isNull(qVar.getId())) {
                return qVar.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tieba.pb.data.h hVar) {
        hVar.hn(this.exo.LP());
        this.exo = hVar;
        oE(hVar.getPage().qB());
    }

    private void aQw() {
        if (this.exo != null && this.exo.aOm() != null && this.exo.aOx() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = this.exo.aOm();
            com.baidu.tieba.pb.data.c aOx = this.exo.aOx();
            int aOb = aOx.aOb();
            if (aOb > 0) {
                if (aOb <= aOm.size()) {
                    aOm.add(aOb, aOx);
                } else {
                    aOm.add(aOx);
                }
            }
        }
    }

    public boolean aQx() {
        if (this.ewZ == null || this.exa == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return oG(4);
        }
        return oG(6);
    }

    public boolean ix(boolean z) {
        if (this.ewZ == null || this.exo == null) {
            return false;
        }
        if (z || this.exo.getPage().qD() != 0) {
            return oG(1);
        }
        return false;
    }

    public boolean iy(boolean z) {
        if (this.ewZ == null || this.exo == null) {
            return false;
        }
        if ((z || this.exo.getPage().qE() != 0) && this.exo.aOm() != null && this.exo.aOm().size() >= 1) {
            return oG(2);
        }
        return false;
    }

    public boolean pw(String str) {
        this.exb = !this.exb;
        this.exa = str;
        oG(6);
        return true;
    }

    public boolean aQy() {
        if (com.baidu.adp.lib.util.i.gm()) {
            this.exc = this.exd;
            this.exd = !this.exd;
        }
        return LoadData();
    }

    public boolean aQz() {
        return this.exd;
    }

    public boolean hasData() {
        return (this.exo == null || this.exo.aOk() == null || this.exo.aOl() == null) ? false : true;
    }

    public boolean nz() {
        if (this.exo == null) {
            return false;
        }
        return this.exo.nz();
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public WriteData fF(String str) {
        if (this.exo == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.exo.aOk().getId());
        writeData.setForumName(this.exo.aOk().getName());
        writeData.setThreadId(this.ewZ);
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

    public MarkData oI(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.exo == null || this.exo.aOm() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = this.exo.aOm();
        if (aOm.size() > 0 && i == aOm.size()) {
            i = aOm.size() - 1;
        }
        if (aOm.size() <= 0 || i >= aOm.size()) {
            return null;
        }
        return f(aOm.get(i));
    }

    public MarkData aQA() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ewZ);
        markData.setPostId(this.exo.ny());
        markData.setTime(date.getTime());
        markData.setHostMode(this.exb);
        markData.setSequence(Boolean.valueOf(this.exd));
        markData.setId(this.ewZ);
        return markData;
    }

    public MarkData f(com.baidu.tieba.tbadkCore.data.q qVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ewZ);
        markData.setPostId(qVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.exb);
        markData.setSequence(Boolean.valueOf(this.exd));
        markData.setId(this.ewZ);
        markData.setFloor(qVar.bml());
        if (qVar instanceof com.baidu.tieba.pb.data.f) {
            markData.setApp(true);
        } else if (qVar instanceof com.baidu.tieba.tbadkCore.data.p) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.p) qVar).isApp());
        }
        return markData;
    }

    public void aQB() {
        cq.aPS().K(aQC(), this.isFromMark);
    }

    private String aQC() {
        String str = this.ewZ;
        if (this.exb) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.exd) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void iz(boolean z) {
        if (this.exo != null) {
            this.exo.ad(z);
        }
    }

    public void iA(boolean z) {
        this.exy = z;
    }

    public boolean aQD() {
        return this.exy;
    }

    public void a(a aVar) {
        this.exs = aVar;
    }

    public void oc(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public String Do() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public boolean Dn() {
        return Ff();
    }

    public boolean px(String str) {
        if (getPbData() == null || getPbData().aOl() == null || getPbData().aOl().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aOl().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aQE() {
        return this.mRequestType;
    }

    public void aQF() {
        String aQC = aQC();
        cq.aPS().K(aQC, false);
        cq.aPS().K(aQC, true);
    }

    public void aQG() {
        if ("personalize_page".equals(this.ahB)) {
            this.exE = System.currentTimeMillis() / 1000;
        }
    }

    public void aQH() {
        if ("personalize_page".equals(this.ahB) && this.exo != null && this.exE != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10754").ab("fid", this.exo.getForumId()).ab("tid", this.ewZ).ab("obj_duration", String.valueOf(currentTimeMillis - this.exE)).ab("obj_param3", String.valueOf(currentTimeMillis)));
            this.exE = 0L;
        }
    }

    public boolean aQI() {
        return this.exH;
    }

    public int aQJ() {
        return this.exp;
    }

    public int getErrorNo() {
        return this.exI;
    }

    public com.baidu.tieba.pb.data.g getAppealInfo() {
        return this.mAppealInfo;
    }

    public dc aQK() {
        return this.exK;
    }

    public cr aQL() {
        return this.exL;
    }

    public cu aQM() {
        return this.exM;
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.exo != null && this.exo.aOm() != null && this.exo.aOm().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.exo.aOm().size();
                for (int i = 0; i < size; i++) {
                    if (this.exo.aOm().get(i) != null && this.exo.aOm().get(i).getAuthor() != null && currentAccount.equals(this.exo.aOm().get(i).getAuthor().getUserId()) && this.exo.aOm().get(i).getAuthor().getPendantData() != null) {
                        this.exo.aOm().get(i).getAuthor().getPendantData().cs(kVar.pR());
                        this.exo.aOm().get(i).getAuthor().getPendantData().P(kVar.Co());
                    }
                }
            }
        }
    }
}
