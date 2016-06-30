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
public class dg extends com.baidu.tbadk.editortools.d.a {
    private static final int dQM = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int dQN = 1;
    private CustomMessageListener aOz;
    private String adJ;
    private boolean awp;
    private long bPD;
    private BaseActivity bkc;
    private com.baidu.tieba.tbadkCore.d.b btR;
    protected String dQO;
    private String dQP;
    private boolean dQQ;
    private boolean dQR;
    private boolean dQS;
    private long dQT;
    private int dQU;
    private int dQV;
    private int dQW;
    private int dQX;
    private boolean dQY;
    private boolean dQZ;
    private final cp dRA;
    private final cs dRB;
    private CustomMessageListener dRC;
    private PraiseData dRD;
    private boolean dRa;
    private long dRb;
    private boolean dRc;
    private String dRd;
    protected com.baidu.tieba.pb.data.h dRe;
    private int dRf;
    private boolean dRg;
    private boolean dRh;
    private a dRi;
    private String dRj;
    private String dRk;
    private int dRl;
    private int dRm;
    private boolean dRn;
    private boolean dRo;
    private boolean dRp;
    private boolean dRq;
    private boolean dRr;
    private String dRs;
    private long dRt;
    private boolean dRu;
    private int dRv;
    private boolean dRw;
    private int dRx;
    private final dm dRy;
    private final cz dRz;
    private int dig;
    private com.baidu.adp.framework.listener.a div;
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

    public String aFI() {
        return this.dRs;
    }

    public void nw(String str) {
        this.dRs = str;
    }

    public void hv(boolean z) {
        this.dRu = z;
    }

    public dg(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.adJ = null;
        this.dQO = null;
        this.dQP = null;
        this.dQQ = false;
        this.dQR = true;
        this.dQS = true;
        this.mIsGood = 0;
        this.dig = 0;
        this.dQT = 0L;
        this.dQU = 1;
        this.dQV = 1;
        this.dQW = 1;
        this.dQX = 1;
        this.isAd = false;
        this.dQY = false;
        this.dQZ = false;
        this.isFromMark = false;
        this.dRa = false;
        this.dRb = 0L;
        this.dRc = false;
        this.dRd = null;
        this.dRe = null;
        this.awp = false;
        this.dRg = false;
        this.dRh = false;
        this.mLocate = null;
        this.mContext = null;
        this.dRi = null;
        this.opType = null;
        this.opUrl = null;
        this.dRj = null;
        this.dRk = null;
        this.dRl = -1;
        this.dRm = -1;
        this.btR = null;
        this.dRo = false;
        this.dRp = false;
        this.postID = null;
        this.dRs = null;
        this.dRt = 0L;
        this.dRu = false;
        this.dRv = -1;
        this.aOz = new dh(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.dRC = new dj(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.div = new dk(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.dRD = null;
        registerListener(this.aOz);
        registerListener(this.div);
        registerListener(this.dRC);
        this.dRe = new com.baidu.tieba.pb.data.h();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bkc = baseActivity;
        this.dRy = new dm(this, this.bkc);
        this.dRz = new cz(this, this.bkc);
        this.dRA = new cp(this, this.bkc);
        this.dRB = new cs(this, this.bkc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aFJ() {
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
        this.dQO = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.dQO)) {
            this.dQO = this.dRy.w(intent);
        }
        this.dQP = intent.getStringExtra("post_id");
        this.dQQ = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.dQS = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.adJ = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dig = intent.getIntExtra("is_top", 0);
        this.dQT = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.dQZ = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.dRa = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.dQY = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.dRc = intent.getBooleanExtra("is_pv", false);
        this.dRb = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.dRd = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.dRk = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.dRj = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.dRg = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.dRh = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.dRm = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.dRl = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void initWithBundle(Bundle bundle) {
        this.dQO = bundle.getString("thread_id");
        this.dQP = bundle.getString("post_id");
        this.dQQ = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.dQS = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.adJ = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dig = bundle.getInt("is_top", 0);
        this.dQT = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.dQZ = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.dRa = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.dQY = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.dRc = bundle.getBoolean("is_pv", false);
        this.dRb = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.dRd = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.dRk = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.dRg = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.dRh = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.dRm = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.dRl = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void q(Bundle bundle) {
        bundle.putString("thread_id", this.dQO);
        bundle.putString("post_id", this.dQP);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.dQQ);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.dQS);
        bundle.putString("st_type", this.adJ);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dig);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.dQT);
        bundle.putBoolean("from_frs", this.dQZ);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.dRa);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.dQY);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.dRc);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.dRb);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.dRk);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.dRg);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.dRh);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.dRm);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.dRl);
    }

    public String aFK() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.dQO);
        if (!this.dRa) {
            sb.append(this.dQP);
        }
        sb.append(this.dQQ);
        sb.append(this.dQS);
        sb.append(this.adJ);
        sb.append(this.mIsGood);
        sb.append(this.dig);
        sb.append(this.dQT);
        sb.append(this.dQZ);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.dQY);
        sb.append(this.dRc);
        sb.append(this.dRb);
        sb.append(this.dRd);
        sb.append(this.mThreadType);
        sb.append(this.dRg);
        sb.append(this.dRh);
        if (this.dRk != null) {
            sb.append(this.dRk);
        }
        return sb.toString();
    }

    public String aFL() {
        return this.dRd;
    }

    public String getPostId() {
        return this.dQP;
    }

    public void nx(String str) {
        this.dQP = str;
    }

    public String getThreadID() {
        return this.dQO;
    }

    public boolean getHostMode() {
        return this.dQQ;
    }

    public boolean aFM() {
        return this.dQS;
    }

    public boolean aFN() {
        return this.dQZ;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aFO() {
        return HotTopicActivityConfig.ST_TYPE.equals(this.adJ);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int auW() {
        return this.dig;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void nl(int i) {
        this.dig = i;
    }

    public boolean aFP() {
        return this.dQY;
    }

    public boolean aFQ() {
        if (this.dRe == null) {
            return false;
        }
        return this.dRe.isValid();
    }

    public String qP() {
        if (this.dRe == null || !this.dRe.mK()) {
            return null;
        }
        return this.dRe.mJ();
    }

    public boolean nm(int i) {
        this.dQU = i;
        if (this.dQU > this.dRe.getPage().pz()) {
            this.dQU = this.dRe.getPage().pz();
        }
        if (this.dQU < 1) {
            this.dQU = 1;
        }
        if (this.dQO == null) {
            return false;
        }
        return nq(5);
    }

    public boolean nn(int i) {
        int rl = this.dRe.aDO().rl();
        if (i <= rl) {
            rl = i;
        }
        int i2 = rl >= 1 ? rl : 1;
        if (this.dQO == null) {
            return false;
        }
        this.dRv = i2;
        return nq(7);
    }

    public void no(int i) {
        this.dQU = i;
        this.dQV = i;
        this.dQW = i;
    }

    public void np(int i) {
        if (this.dQV < i) {
            this.dQV = i;
            if (this.dQV - this.dQW >= dQM) {
                this.dQW = (this.dQV - dQM) + 1;
            }
        }
        if (this.dQW > i) {
            this.dQW = i;
            if (this.dQV - this.dQW >= dQM) {
                this.dQV = (this.dQW + dQM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        return this.dRe;
    }

    public com.baidu.tbadk.core.data.af ajw() {
        if (this.dRe == null) {
            return null;
        }
        return this.dRe.getPage();
    }

    public boolean aFR() {
        if (this.dQS) {
            if (this.dRe.getPage().pE() == 0) {
                hw(true);
                return true;
            }
        } else if (this.dRe.getPage().pF() == 0) {
            hx(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.dQO == null) {
            return false;
        }
        cancelLoadData();
        if (this.btR == null) {
            this.btR = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.btR.start();
        }
        boolean nq = nq(3);
        if (this.opType != null) {
            this.opType = null;
            this.dRj = null;
            this.opUrl = null;
            return nq;
        }
        return nq;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.awp = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Sv();
    }

    private void Sv() {
        if (this.btR != null) {
            this.btR.destory();
            this.btR = null;
        }
    }

    public boolean DH() {
        return (this.dQP == null || this.dQP.equals("0") || this.dQP.length() == 0) ? LoadData() : aFU();
    }

    public boolean nq(int i) {
        this.mRequestType = i;
        if (this.awp) {
            return false;
        }
        this.awp = true;
        nr(i);
        com.baidu.tieba.pb.data.h pbData = el.aGM().getPbData();
        if (pbData != null && pbData.aDO() != null) {
            pbData.aDO().bH(0);
            this.dQS = el.aGM().aFM();
            this.dQQ = el.aGM().aGO();
            if (!this.dQS || this.dQQ || this.isFromMark) {
                this.dRn = false;
            }
            com.baidu.adp.lib.h.h.dM().post(new dl(this, pbData));
            return false;
        }
        if (i == 4 && !this.dRr) {
            a(aFZ(), true, this.dQP, 3);
        }
        if (i == 3 && !this.dRr) {
            if (this.isFromMark) {
                a(aFZ(), true, this.dQP, 3);
            } else {
                a(aFZ(), false, this.dQP, 3);
            }
        }
        this.dRr = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.apj);
        if (!this.dQS || this.dQQ || this.isFromMark) {
            this.dRn = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.dQO == null || this.dQO.length() == 0) {
            this.awp = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.dQO, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int A = com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m9getInst().getApp());
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.bb.uf().uh() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(A));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(B));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.dQS) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.dQQ) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.adJ != null) {
            pbPageRequestMessage.set_st_type(this.adJ);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.dRc) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.dRb));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.dRn) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.h.b.g(this.dRj, 0));
            pbPageRequestMessage.setOpMessageID(this.dRb);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = this.dRe.aDP();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.dQS) {
                        if (this.dQW - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.dQW - 1));
                        }
                    } else if (this.dQV < this.dQX) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.dQV + 1));
                    }
                }
                if (aDP != null && aDP.size() > 0) {
                    int size = aDP.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.s sVar = aDP.get(size - i3);
                        if (sVar == null) {
                            i3++;
                        } else {
                            this.dQP = sVar.getId();
                            if (StringUtils.isNull(this.dQP)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.dQP != null && this.dQP.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.dQP, 0L));
                    break;
                } else if (!this.dQS) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aDP != null && aDP.size() > 0 && aDP.get(0) != null) {
                    this.dQP = aDP.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.dQS) {
                        if (this.dQW - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.dQW - 1));
                        }
                    } else if (this.dQV < this.dQX) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.dQV + 1));
                    }
                }
                if (this.dQP != null && this.dQP.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.dQP, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.dQS) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.dQP, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.dQU));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.dQP, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.dRv);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aFZ());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bkc != null && (this.bkc instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bkc).aEB());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.dRu);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void nr(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = this.dRe.aDP();
        this.dRq = false;
        if (i == 1) {
            boolean z2 = false;
            while (aDP.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aDP.remove(0);
                z2 = true;
            }
            if (z2) {
                this.dRe.getPage().bE(1);
                if (this.dRi != null) {
                    this.dRi.c(this.dRe);
                }
            }
            this.bPD = System.currentTimeMillis();
            this.dRq = true;
        } else if (i == 2) {
            while (aDP.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aDP.remove(aDP.size() - 1);
                z = true;
            }
            if (z) {
                this.dRe.getPage().bD(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.h hVar2 = z ? null : hVar;
        this.dRx = i2;
        this.awp = false;
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
            if (this.dRg || this.dRh) {
                hVar = f(hVar);
            }
            e(hVar);
        }
    }

    protected void e(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null) {
            String g = g(hVar);
            for (int i = 0; i < hVar.aDP().size(); i++) {
                com.baidu.tieba.tbadkCore.data.s sVar = hVar.aDP().get(i);
                for (int i2 = 0; i2 < sVar.bci().size(); i2++) {
                    sVar.bci().get(i2).b(this.bkc.getPageContext(), g.equals(sVar.bci().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.h f(com.baidu.tieba.pb.data.h hVar) {
        if (hVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.az aDO = hVar.aDO();
        aDO.bJ(this.mIsGood);
        aDO.bI(this.dig);
        if (this.dQT > 0) {
            aDO.u(this.dQT);
            return hVar;
        }
        return hVar;
    }

    protected String g(com.baidu.tieba.pb.data.h hVar) {
        String str = null;
        if (hVar == null) {
            return null;
        }
        if (hVar.aDO() != null && hVar.aDO().getAuthor() != null) {
            str = hVar.aDO().getAuthor().getUserId();
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
        if (hVar.aDO() != null && hVar.aDO().getAuthor() != null) {
            str = hVar.aDO().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aFS() {
        if (this.dRe == null || this.dRe.aDO() == null || this.dRe.aDO().getAuthor() == null) {
            return null;
        }
        return this.dRe.aDO().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.dRw = z3;
        this.dRf = i;
        if (this.btR != null && !z3) {
            this.btR.a(z2, z4, i2, str, i3, j, j2);
            this.btR = null;
        }
        if (hVar == null || (this.dQU == 1 && i == 5 && hVar.aDP() != null && hVar.aDP().size() < 1)) {
            if (this.dRi != null) {
                this.dQS = this.dQR;
                this.dRi.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.dQR = this.dQS;
            this.dRc = false;
            if (hVar.getPage() != null) {
                np(hVar.getPage().pC());
                this.dQX = hVar.getPage().pz();
            }
            this.dQX = this.dQX < 1 ? 1 : this.dQX;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = this.dRe.aDP();
            switch (i) {
                case 1:
                    this.dRe.a(hVar.getPage(), 1);
                    a(hVar, aDP);
                    i4 = 0;
                    break;
                case 2:
                    if (hVar.aDP() != null) {
                        int size = hVar.aDP().size() + 1;
                        com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(aDP, 0);
                        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(hVar.aDP(), com.baidu.tbadk.core.util.y.s(hVar.aDP()) - 1);
                        if (sVar == null || sVar2 == null || !sVar.getId().equals(sVar2.getId())) {
                            i5 = size;
                        } else {
                            hVar.aDP().remove(sVar2);
                            i5 = size - 1;
                        }
                        aDP.addAll(0, hVar.aDP());
                    }
                    this.dRe.a(hVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.dQS && hVar.getPage() != null) {
                        hVar.getPage().bB(hVar.getPage().pz());
                    }
                    i(hVar);
                    if (!z3 && this.mThreadType != 33 && this.dQS) {
                        aFT();
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
            if (this.dRe != null && this.dRe.aDO() != null) {
                PraiseData praise = this.dRe.aDO().getPraise();
                if (this.dRD != null && !praise.isPriaseDataValid()) {
                    this.dRe.aDO().setPraise(this.dRD);
                } else {
                    this.dRD = this.dRe.aDO().getPraise();
                    this.dRD.setPostId(this.dRe.aDO().qV());
                }
                if (hVar.getPage() != null && hVar.getPage().pC() == 1 && hVar.aDO() != null && hVar.aDO().qQ() != null && hVar.aDO().qQ().size() > 0) {
                    this.dRe.aDO().h(hVar.aDO().qQ());
                }
                this.dRe.aDO().setReply_num(hVar.aDO().getReply_num());
                this.dRe.aDO().setAnchorLevel(hVar.aDO().getAnchorLevel());
                this.dRe.aDO().bH(hVar.aDO().qE());
                if (this.mThreadType == 33) {
                    this.dRe.aDO().getAuthor().setHadConcerned(hVar.aDO().getAuthor().hadConcerned());
                }
            }
            if (this.dRe != null && this.dRe.getUserData() != null && hVar.getUserData() != null) {
                this.dRe.getUserData().setBimg_end_time(hVar.getUserData().getBimg_end_time());
                this.dRe.getUserData().setBimg_url(hVar.getUserData().getBimg_url());
            }
            if (this.dRw && this.dRe.aDO() != null && this.dRe.aDO().getAuthor() != null && this.dRe.aDP() != null && com.baidu.tbadk.core.util.y.c(this.dRe.aDP(), 0) != null) {
                com.baidu.tieba.tbadkCore.data.s sVar3 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(this.dRe.aDP(), 0);
                MetaData author = this.dRe.aDO().getAuthor();
                if (sVar3.getAuthor() != null && sVar3.getAuthor().getGodUserData() != null) {
                    if (this.dRl != -1) {
                        author.setFansNum(this.dRl);
                        sVar3.getAuthor().setFansNum(this.dRl);
                    }
                    if (this.dRm != -1) {
                        author.getGodUserData().setFollowed(this.dRm);
                        sVar3.getAuthor().getGodUserData().setFollowed(this.dRm);
                        author.getGodUserData().setIsFromNetWork(false);
                        sVar3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.dRe != null && this.dRe.aDL() != null && hVar.aDL() != null) {
                this.dRe.aDL().n(hVar.aDL().getItems());
                this.dRe.aDL().ai(hVar.aDL().pm());
            }
            if (this.dRi != null) {
                this.dRi.a(true, getErrorCode(), i, i4, this.dRe, this.mErrorString, 1);
            }
        }
        if (this.dRe != null && this.dRe.aDO() != null && this.dRe.aDN() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bkc;
            historyMessage.threadId = getPbData().aDO().getId();
            historyMessage.forumName = getPbData().aDN().getName();
            historyMessage.threadName = getPbData().aDO().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aFM();
            historyMessage.threadType = getPbData().aDO().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        String aj;
        if (arrayList != null && hVar.aDP() != null) {
            com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(hVar.aDP(), 0);
            if (sVar != null && (aj = aj(arrayList)) != null && aj.equals(sVar.getId())) {
                hVar.aDP().remove(sVar);
            }
            arrayList.addAll(hVar.aDP());
        }
    }

    private String aj(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        int s = com.baidu.tbadk.core.util.y.s(arrayList);
        if (s <= 0) {
            return null;
        }
        for (int i = s - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(arrayList, i);
            if (sVar != null && !StringUtils.isNull(sVar.getId())) {
                return sVar.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tieba.pb.data.h hVar) {
        this.dRe = hVar;
        no(hVar.getPage().pC());
    }

    private void aFT() {
        if (this.dRe != null && this.dRe.aDP() != null && this.dRe.aDZ() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = this.dRe.aDP();
            com.baidu.tieba.pb.data.c aDZ = this.dRe.aDZ();
            int aDE = aDZ.aDE();
            if (aDE > 0) {
                if (aDE <= aDP.size()) {
                    aDP.add(aDE, aDZ);
                } else {
                    aDP.add(aDZ);
                }
            }
        }
    }

    public boolean aFU() {
        if (this.dQO == null || this.dQP == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return nq(4);
        }
        return nq(6);
    }

    public boolean hw(boolean z) {
        if (this.dQO == null || this.dRe == null) {
            return false;
        }
        if (z || this.dRe.getPage().pE() != 0) {
            return nq(1);
        }
        return false;
    }

    public boolean hx(boolean z) {
        if (this.dQO == null || this.dRe == null) {
            return false;
        }
        if ((z || this.dRe.getPage().pF() != 0) && this.dRe.aDP() != null && this.dRe.aDP().size() >= 1) {
            return nq(2);
        }
        return false;
    }

    public boolean ny(String str) {
        this.dQQ = !this.dQQ;
        this.dQP = str;
        nq(6);
        return true;
    }

    public boolean aFV() {
        if (com.baidu.adp.lib.util.i.fr()) {
            this.dQR = this.dQS;
            this.dQS = !this.dQS;
        }
        return LoadData();
    }

    public boolean aFW() {
        return this.dQS;
    }

    public boolean hasData() {
        return (this.dRe == null || this.dRe.aDN() == null || this.dRe.aDO() == null) ? false : true;
    }

    public boolean mK() {
        if (this.dRe == null) {
            return false;
        }
        return this.dRe.mK();
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fy(String str) {
        if (this.dRe == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.dRe.aDN().getId());
        writeData.setForumName(this.dRe.aDN().getName());
        writeData.setThreadId(this.dQO);
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

    public MarkData ns(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.dRe == null || this.dRe.aDP() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = this.dRe.aDP();
        if (aDP.size() > 0 && i == aDP.size()) {
            i = aDP.size() - 1;
        }
        if (aDP.size() <= 0 || i >= aDP.size()) {
            return null;
        }
        return d(aDP.get(i));
    }

    public MarkData aFX() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.dQO);
        markData.setPostId(this.dRe.mJ());
        markData.setTime(date.getTime());
        markData.setHostMode(this.dQQ);
        markData.setSequence(Boolean.valueOf(this.dQS));
        markData.setId(this.dQO);
        return markData;
    }

    public MarkData d(com.baidu.tieba.tbadkCore.data.s sVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.dQO);
        markData.setPostId(sVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.dQQ);
        markData.setSequence(Boolean.valueOf(this.dQS));
        markData.setId(this.dQO);
        markData.setFloor(sVar.bcm());
        if (sVar instanceof com.baidu.tieba.pb.data.f) {
            markData.setApp(true);
        } else if (sVar instanceof com.baidu.tieba.tbadkCore.data.r) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.r) sVar).isApp());
        }
        return markData;
    }

    public void aFY() {
        co.aFs().F(aFZ(), this.isFromMark);
    }

    private String aFZ() {
        String str = this.dQO;
        if (this.dQQ) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.dQS) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void hy(boolean z) {
        if (this.dRe != null) {
            this.dRe.Z(z);
        }
    }

    public void hz(boolean z) {
        this.dRn = z;
    }

    public boolean aGa() {
        return this.dRn;
    }

    public void a(a aVar) {
        this.dRi = aVar;
    }

    public void mL(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String BL() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean BK() {
        return DH();
    }

    public boolean nz(String str) {
        if (getPbData() == null || getPbData().aDO() == null || getPbData().aDO().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aDO().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aGb() {
        return this.mRequestType;
    }

    public void aGc() {
        String aFZ = aFZ();
        co.aFs().F(aFZ, false);
        co.aFs().F(aFZ, true);
    }

    public void aGd() {
        if ("personalize_page".equals(this.adJ)) {
            this.dRt = System.currentTimeMillis() / 1000;
        }
    }

    public void aGe() {
        if ("personalize_page".equals(this.adJ) && this.dRe != null && this.dRt != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10754").ab("fid", this.dRe.getForumId()).ab("tid", this.dQO).ab("obj_duration", String.valueOf(currentTimeMillis - this.dRt)).ab("obj_param3", String.valueOf(currentTimeMillis)));
            this.dRt = 0L;
        }
    }

    public boolean aGf() {
        return this.dRw;
    }

    public int aGg() {
        return this.dRf;
    }

    public int getErrorNo() {
        return this.dRx;
    }

    public com.baidu.tieba.pb.data.g getAppealInfo() {
        return this.mAppealInfo;
    }

    public cz aGh() {
        return this.dRz;
    }

    public cp aGi() {
        return this.dRA;
    }

    public cs aGj() {
        return this.dRB;
    }
}
