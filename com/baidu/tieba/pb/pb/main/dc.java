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
public class dc extends com.baidu.tbadk.editortools.e.a {
    private static final int ebm = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int ebn = 1;
    private boolean aAd;
    private BaseActivity aSs;
    private String ahe;
    private long bLI;
    private com.baidu.tieba.tbadkCore.d.b bqy;
    private int dOM;
    private int dgP;
    private com.baidu.adp.framework.listener.a dgZ;
    private boolean ebA;
    private long ebB;
    private boolean ebC;
    private String ebD;
    protected com.baidu.tieba.pb.data.f ebE;
    private int ebF;
    private boolean ebG;
    private boolean ebH;
    private boolean ebI;
    private a ebJ;
    private String ebK;
    private String ebL;
    private int ebM;
    private int ebN;
    private boolean ebO;
    private boolean ebP;
    private boolean ebQ;
    private boolean ebR;
    private boolean ebS;
    private String ebT;
    private long ebU;
    private boolean ebV;
    private int ebW;
    private boolean ebX;
    private boolean ebY;
    private int ebZ;
    protected String ebo;
    private String ebp;
    private boolean ebq;
    private boolean ebr;
    private boolean ebs;
    private long ebt;
    private int ebu;
    private int ebv;
    private int ebw;
    private boolean ebx;
    private boolean eby;
    private boolean ebz;
    private final di eca;
    private final cy ecb;
    private final cq ecc;
    private final ct ecd;
    private CustomMessageListener ece;
    private CustomMessageListener ecf;
    private PraiseData ecg;
    private boolean isAd;
    private boolean isFromMark;
    private com.baidu.tieba.pb.data.e mAppealInfo;
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

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.f fVar);
    }

    public void ij(boolean z) {
        this.ebV = z;
    }

    public dc(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.ahe = null;
        this.ebo = null;
        this.ebp = null;
        this.ebq = false;
        this.ebr = true;
        this.ebs = true;
        this.mIsGood = 0;
        this.dgP = 0;
        this.ebt = 0L;
        this.ebu = 1;
        this.ebv = 1;
        this.ebw = 1;
        this.dOM = 1;
        this.isAd = false;
        this.ebx = false;
        this.eby = false;
        this.ebz = false;
        this.isFromMark = false;
        this.ebA = false;
        this.ebB = 0L;
        this.ebC = false;
        this.ebD = null;
        this.ebE = null;
        this.aAd = false;
        this.ebG = false;
        this.ebH = false;
        this.ebI = false;
        this.mLocate = null;
        this.mContext = null;
        this.ebJ = null;
        this.opType = null;
        this.opUrl = null;
        this.ebK = null;
        this.ebL = null;
        this.ebM = -1;
        this.ebN = -1;
        this.bqy = null;
        this.ebP = false;
        this.ebQ = false;
        this.postID = null;
        this.ebT = null;
        this.ebU = 0L;
        this.ebV = false;
        this.ebW = -1;
        this.ebY = false;
        this.ece = new dd(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.ecf = new df(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.dgZ = new dg(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.ecg = null;
        registerListener(this.ece);
        registerListener(this.dgZ);
        registerListener(this.ecf);
        this.ebE = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aSs = baseActivity;
        this.eca = new di(this, this.aSs);
        this.ecb = new cy(this, this.aSs);
        this.ecc = new cq(this, this.aSs);
        this.ecd = new ct(this, this.aSs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aKi() {
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
        this.ebo = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.ebo)) {
            this.ebo = this.eca.v(intent);
        }
        this.ebp = intent.getStringExtra("post_id");
        this.ebq = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.ebs = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.ahe = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dgP = intent.getIntExtra("is_top", 0);
        this.ebt = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.ebA = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.ebx = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.ebC = intent.getBooleanExtra("is_pv", false);
        this.ebB = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.ebD = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.ebL = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.ebK = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.ebG = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.ebH = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.ebI = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.ebN = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.ebM = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eby = intent.getBooleanExtra("from_frs", false);
        this.ebz = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.ebY = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.ebo = bundle.getString("thread_id");
        this.ebp = bundle.getString("post_id");
        this.ebq = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.ebs = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.ahe = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dgP = bundle.getInt("is_top", 0);
        this.ebt = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.ebA = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.ebx = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.ebC = bundle.getBoolean("is_pv", false);
        this.ebB = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.ebD = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.ebL = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.ebG = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.ebH = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.ebI = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.ebN = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.ebM = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eby = bundle.getBoolean("from_frs", false);
        this.ebz = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.ebY = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
    }

    public void n(Bundle bundle) {
        bundle.putString("thread_id", this.ebo);
        bundle.putString("post_id", this.ebp);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.ebq);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.ebs);
        bundle.putString("st_type", this.ahe);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dgP);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.ebt);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.ebA);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.ebx);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.ebC);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.ebB);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.ebL);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.ebG);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.ebH);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.ebI);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.ebN);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.ebM);
        bundle.putBoolean("from_frs", this.eby);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.ebz);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.ebY);
    }

    public String aKj() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.ebo);
        if (!this.ebA) {
            sb.append(this.ebp);
        }
        sb.append(this.ebq);
        sb.append(this.ebs);
        sb.append(this.ahe);
        sb.append(this.mIsGood);
        sb.append(this.dgP);
        sb.append(this.ebt);
        sb.append(this.eby);
        sb.append(this.ebz);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.ebx);
        sb.append(this.ebC);
        sb.append(this.ebB);
        sb.append(this.ebD);
        sb.append(this.mThreadType);
        sb.append(this.ebG);
        sb.append(this.ebH);
        sb.append(this.ebI);
        if (this.ebL != null) {
            sb.append(this.ebL);
        }
        return sb.toString();
    }

    public String aKk() {
        return this.ebD;
    }

    public String getPostId() {
        return this.ebp;
    }

    public void nV(String str) {
        this.ebp = str;
    }

    public String getThreadID() {
        return this.ebo;
    }

    public boolean getHostMode() {
        return this.ebq;
    }

    public boolean aKl() {
        return this.ebs;
    }

    public boolean aKm() {
        return this.eby;
    }

    public boolean aKn() {
        return this.ebz;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aKo() {
        return "hot_topic".equals(this.ahe);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int awc() {
        return this.dgP;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void nD(int i) {
        this.dgP = i;
    }

    public boolean aKp() {
        return this.ebx;
    }

    public boolean aKq() {
        if (this.ebE == null) {
            return false;
        }
        return this.ebE.isValid();
    }

    public String rO() {
        if (this.ebE == null || !this.ebE.nz()) {
            return null;
        }
        return this.ebE.ny();
    }

    public boolean nE(int i) {
        this.ebu = i;
        if (this.ebu > this.ebE.getPage().qz()) {
            this.ebu = this.ebE.getPage().qz();
        }
        if (this.ebu < 1) {
            this.ebu = 1;
        }
        if (this.ebo == null) {
            return false;
        }
        return nI(5);
    }

    public boolean nF(int i) {
        int sr = this.ebE.aIl().sr();
        if (i <= sr) {
            sr = i;
        }
        int i2 = sr >= 1 ? sr : 1;
        if (this.ebo == null) {
            return false;
        }
        this.ebW = i2;
        return nI(7);
    }

    public void nG(int i) {
        this.ebu = i;
        this.ebv = i;
        this.ebw = i;
    }

    public void nH(int i) {
        if (this.ebv < i) {
            this.ebv = i;
            if (this.ebv - this.ebw >= ebm) {
                this.ebw = (this.ebv - ebm) + 1;
            }
        }
        if (this.ebw > i) {
            this.ebw = i;
            if (this.ebv - this.ebw >= ebm) {
                this.ebv = (this.ebw + ebm) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.ebE;
    }

    public com.baidu.tbadk.core.data.an alG() {
        if (this.ebE == null) {
            return null;
        }
        return this.ebE.getPage();
    }

    public boolean aKr() {
        if (this.ebs) {
            if (this.ebE.getPage().qE() == 0) {
                ik(true);
                return true;
            }
        } else if (this.ebE.getPage().qF() == 0) {
            il(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.ebo == null) {
            return false;
        }
        cancelLoadData();
        if (this.bqy == null) {
            this.bqy = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bqy.start();
        }
        boolean nI = nI(3);
        if (this.opType != null) {
            this.opType = null;
            this.ebK = null;
            this.opUrl = null;
            return nI;
        }
        return nI;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.aAd = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Tw();
    }

    private void Tw() {
        if (this.bqy != null) {
            this.bqy.destory();
            this.bqy = null;
        }
    }

    public boolean EN() {
        return (this.ebp == null || this.ebp.equals("0") || this.ebp.length() == 0) ? LoadData() : aKu();
    }

    public boolean nI(int i) {
        this.mRequestType = i;
        if (this.aAd) {
            return false;
        }
        this.aAd = true;
        nJ(i);
        com.baidu.tieba.pb.data.f pbData = ej.aLu().getPbData();
        if (pbData != null && pbData.aIl() != null) {
            pbData.aIl().bU(0);
            this.ebs = ej.aLu().aKl();
            this.ebq = ej.aLu().aLw();
            if (!this.ebs || this.ebq || this.isFromMark) {
                this.ebO = false;
            }
            com.baidu.adp.lib.h.h.eG().post(new dh(this, pbData));
            return false;
        }
        if (i == 4 && !this.ebS) {
            a(aKz(), true, this.ebp, 3);
        }
        if (i == 3 && !this.ebS) {
            if (this.isFromMark) {
                a(aKz(), true, this.ebp, 3);
            } else {
                a(aKz(), false, this.ebp, 3);
            }
        }
        this.ebS = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.atj);
        if (!this.ebs || this.ebq || this.isFromMark) {
            this.ebO = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.ebo == null || this.ebo.length() == 0) {
            this.aAd = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.ebo, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int I = com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst().getApp());
        int J = com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.aw.vm().vo() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(I));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(J));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.ebs) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.ebq) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.ahe != null) {
            pbPageRequestMessage.set_st_type(this.ahe);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.ebC) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.ebB));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.ebO) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.h.b.g(this.ebK, 0));
            pbPageRequestMessage.setOpMessageID(this.ebB);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = this.ebE.aIm();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.ebs) {
                        if (this.ebw - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.ebw - 1));
                        }
                    } else if (this.ebv < this.dOM) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.ebv + 1));
                    }
                }
                if (aIm != null && aIm.size() > 0) {
                    int size = aIm.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.q qVar = aIm.get(size - i3);
                        if (qVar == null) {
                            i3++;
                        } else {
                            this.ebp = qVar.getId();
                            if (StringUtils.isNull(this.ebp)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.ebp != null && this.ebp.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.ebp, 0L));
                    break;
                } else if (!this.ebs) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aIm != null && aIm.size() > 0 && aIm.get(0) != null) {
                    this.ebp = aIm.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.ebs) {
                        if (this.ebw - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.ebw - 1));
                        }
                    } else if (this.ebv < this.dOM) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.ebv + 1));
                    }
                }
                if (this.ebp != null && this.ebp.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.ebp, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.ebs) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.ebp, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.ebu));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.ebp, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.ebW);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aKz());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.aSs != null && (this.aSs instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.aSs).aIZ());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.ebV);
        pbPageRequestMessage.setFromSmartFrs(this.ebY ? 1 : 0);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void nJ(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = this.ebE.aIm();
        this.ebR = false;
        if (i == 1) {
            boolean z2 = false;
            while (aIm.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aIm.remove(0);
                z2 = true;
            }
            if (z2) {
                this.ebE.getPage().bQ(1);
                if (this.ebJ != null) {
                    this.ebJ.c(this.ebE);
                }
            }
            this.bLI = System.currentTimeMillis();
            this.ebR = true;
        } else if (i == 2) {
            while (aIm.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aIm.remove(aIm.size() - 1);
                z = true;
            }
            if (z) {
                this.ebE.getPage().bP(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.ebZ = i2;
        this.aAd = false;
        if (fVar2 != null) {
            d(fVar2);
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
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
    public void d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            if (this.ebI || this.ebG || this.ebH) {
                fVar = f(fVar);
            }
            e(fVar);
        }
    }

    protected void e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String g = g(fVar);
            for (int i = 0; i < fVar.aIm().size(); i++) {
                com.baidu.tieba.tbadkCore.data.q qVar = fVar.aIm().get(i);
                for (int i2 = 0; i2 < qVar.bfX().size(); i2++) {
                    qVar.bfX().get(i2).b(this.aSs.getPageContext(), g.equals(qVar.bfX().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.f f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.bg aIl = fVar.aIl();
        aIl.bX(this.mIsGood);
        aIl.bW(this.dgP);
        if (this.ebt > 0) {
            aIl.o(this.ebt);
            return fVar;
        }
        return fVar;
    }

    protected String g(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aIl() != null && fVar.aIl().getAuthor() != null) {
            str = fVar.aIl().getAuthor().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String h(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aIl() != null && fVar.aIl().getAuthor() != null) {
            str = fVar.aIl().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aKs() {
        if (this.ebE == null || this.ebE.aIl() == null || this.ebE.aIl().getAuthor() == null) {
            return null;
        }
        return this.ebE.aIl().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.ebX = z3;
        this.ebF = i;
        if (this.bqy != null && !z3) {
            this.bqy.a(z2, z4, i2, str, i3, j, j2);
            this.bqy = null;
        }
        if (fVar == null || (this.ebu == 1 && i == 5 && fVar.aIm() != null && fVar.aIm().size() < 1)) {
            if (this.ebJ != null) {
                this.ebs = this.ebr;
                this.ebJ.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.ebr = this.ebs;
            this.ebC = false;
            if (fVar.getPage() != null) {
                nH(fVar.getPage().qC());
                this.dOM = fVar.getPage().qz();
            }
            this.dOM = this.dOM < 1 ? 1 : this.dOM;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = this.ebE.aIm();
            switch (i) {
                case 1:
                    this.ebE.a(fVar.getPage(), 1);
                    a(fVar, aIm);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aIm() != null) {
                        int size = fVar.aIm().size() + 1;
                        com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(aIm, 0);
                        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(fVar.aIm(), com.baidu.tbadk.core.util.x.s(fVar.aIm()) - 1);
                        if (qVar == null || qVar2 == null || !qVar.getId().equals(qVar2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aIm().remove(qVar2);
                            i5 = size - 1;
                        }
                        aIm.addAll(0, fVar.aIm());
                    }
                    this.ebE.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.ebs && fVar.getPage() != null) {
                        fVar.getPage().bN(fVar.getPage().qz());
                    }
                    i(fVar);
                    if (!z3 && this.mThreadType != 33 && this.ebs) {
                        aKt();
                        i4 = 0;
                        break;
                    }
                    i4 = 0;
                    break;
                case 4:
                    i(fVar);
                    i4 = 0;
                    break;
                case 5:
                    i(fVar);
                    i4 = 0;
                    break;
                case 6:
                    i(fVar);
                    i4 = 0;
                    break;
                case 7:
                    i(fVar);
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.ebE != null && this.ebE.aIl() != null) {
                PraiseData rv = this.ebE.aIl().rv();
                if (this.ecg != null && !rv.isPriaseDataValid()) {
                    this.ebE.aIl().a(this.ecg);
                } else {
                    this.ecg = this.ebE.aIl().rv();
                    this.ecg.setPostId(this.ebE.aIl().rV());
                }
                if (fVar.getPage() != null && fVar.getPage().qC() == 1 && fVar.aIl() != null && fVar.aIl().rQ() != null && fVar.aIl().rQ().size() > 0) {
                    this.ebE.aIl().i(fVar.aIl().rQ());
                }
                this.ebE.aIl().bV(fVar.aIl().rx());
                this.ebE.aIl().bT(fVar.aIl().getAnchorLevel());
                this.ebE.aIl().bU(fVar.aIl().rt());
                if (this.mThreadType == 33) {
                    this.ebE.aIl().getAuthor().setHadConcerned(fVar.aIl().getAuthor().hadConcerned());
                }
            }
            if (this.ebE != null && this.ebE.getUserData() != null && fVar.getUserData() != null) {
                this.ebE.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.ebE.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().qC() == 1 && fVar.aIt() != null) {
                this.ebE.a(fVar.aIt());
            }
            if (this.ebX && this.ebE.aIl() != null && this.ebE.aIl().getAuthor() != null && this.ebE.aIm() != null && com.baidu.tbadk.core.util.x.c(this.ebE.aIm(), 0) != null) {
                com.baidu.tieba.tbadkCore.data.q qVar3 = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(this.ebE.aIm(), 0);
                MetaData author = this.ebE.aIl().getAuthor();
                if (qVar3.getAuthor() != null && qVar3.getAuthor().getGodUserData() != null) {
                    if (this.ebM != -1) {
                        author.setFansNum(this.ebM);
                        qVar3.getAuthor().setFansNum(this.ebM);
                    }
                    if (this.ebN != -1) {
                        author.getGodUserData().setIsLike(this.ebN == 1);
                        qVar3.getAuthor().getGodUserData().setIsLike(this.ebN == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        qVar3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.ebE != null && this.ebE.aIi() != null && fVar.aIi() != null) {
                this.ebE.aIi().n(fVar.aIi().getItems());
                this.ebE.aIi().ao(fVar.aIi().qm());
            }
            if (this.ebJ != null) {
                this.ebJ.a(true, getErrorCode(), i, i4, this.ebE, this.mErrorString, 1);
            }
        }
        if (this.ebE != null && this.ebE.aIl() != null && this.ebE.aIk() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.aSs;
            historyMessage.threadId = getPbData().aIl().getId();
            historyMessage.forumName = getPbData().aIk().getName();
            historyMessage.threadName = getPbData().aIl().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aKl();
            historyMessage.threadType = getPbData().aIl().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        String af;
        if (arrayList != null && fVar.aIm() != null) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(fVar.aIm(), 0);
            if (qVar != null && (af = af(arrayList)) != null && af.equals(qVar.getId())) {
                fVar.aIm().remove(qVar);
            }
            arrayList.addAll(fVar.aIm());
        }
    }

    private String af(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
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
    public void i(com.baidu.tieba.pb.data.f fVar) {
        fVar.hi(this.ebE.Li());
        this.ebE = fVar;
        nG(fVar.getPage().qC());
    }

    private void aKt() {
        if (this.ebE != null && this.ebE.aIm() != null && this.ebE.aIy() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = this.ebE.aIm();
            com.baidu.tieba.pb.data.a aIy = this.ebE.aIy();
            int aIb = aIy.aIb();
            if (aIb > 0) {
                if (aIb <= aIm.size()) {
                    aIm.add(aIb, aIy);
                } else {
                    aIm.add(aIy);
                }
            }
        }
    }

    public boolean aKu() {
        if (this.ebo == null || this.ebp == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return nI(4);
        }
        return nI(6);
    }

    public boolean ik(boolean z) {
        if (this.ebo == null || this.ebE == null) {
            return false;
        }
        if (z || this.ebE.getPage().qE() != 0) {
            return nI(1);
        }
        return false;
    }

    public boolean il(boolean z) {
        if (this.ebo == null || this.ebE == null) {
            return false;
        }
        if ((z || this.ebE.getPage().qF() != 0) && this.ebE.aIm() != null && this.ebE.aIm().size() >= 1) {
            return nI(2);
        }
        return false;
    }

    public boolean nW(String str) {
        this.ebq = !this.ebq;
        this.ebp = str;
        nI(6);
        return true;
    }

    public boolean aKv() {
        if (com.baidu.adp.lib.util.i.gm()) {
            this.ebr = this.ebs;
            this.ebs = !this.ebs;
        }
        return LoadData();
    }

    public boolean aKw() {
        return this.ebs;
    }

    public boolean hasData() {
        return (this.ebE == null || this.ebE.aIk() == null || this.ebE.aIl() == null) ? false : true;
    }

    public boolean nz() {
        if (this.ebE == null) {
            return false;
        }
        return this.ebE.nz();
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public WriteData fB(String str) {
        if (this.ebE == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.ebE.aIk().getId());
        writeData.setForumName(this.ebE.aIk().getName());
        writeData.setThreadId(this.ebo);
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

    public MarkData nK(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.ebE == null || this.ebE.aIm() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = this.ebE.aIm();
        if (aIm.size() > 0 && i == aIm.size()) {
            i = aIm.size() - 1;
        }
        if (aIm.size() <= 0 || i >= aIm.size()) {
            return null;
        }
        return f(aIm.get(i));
    }

    public MarkData aKx() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ebo);
        markData.setPostId(this.ebE.ny());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ebq);
        markData.setSequence(Boolean.valueOf(this.ebs));
        markData.setId(this.ebo);
        return markData;
    }

    public MarkData f(com.baidu.tieba.tbadkCore.data.q qVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ebo);
        markData.setPostId(qVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ebq);
        markData.setSequence(Boolean.valueOf(this.ebs));
        markData.setId(this.ebo);
        markData.setFloor(qVar.bga());
        if (qVar instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (qVar instanceof com.baidu.tieba.tbadkCore.data.p) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.p) qVar).isApp());
        }
        return markData;
    }

    public void aKy() {
        cp.aJR().L(aKz(), this.isFromMark);
    }

    private String aKz() {
        String str = this.ebo;
        if (this.ebq) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.ebs) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void im(boolean z) {
        if (this.ebE != null) {
            this.ebE.ad(z);
        }
    }

    public void in(boolean z) {
        this.ebO = z;
    }

    public boolean aKA() {
        return this.ebO;
    }

    public void a(a aVar) {
        this.ebJ = aVar;
    }

    public void mE(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public String CX() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public boolean CW() {
        return EN();
    }

    public boolean nX(String str) {
        if (getPbData() == null || getPbData().aIl() == null || getPbData().aIl().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aIl().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aKB() {
        return this.mRequestType;
    }

    public void aKC() {
        String aKz = aKz();
        cp.aJR().L(aKz, false);
        cp.aJR().L(aKz, true);
    }

    public void aKD() {
        if ("personalize_page".equals(this.ahe)) {
            this.ebU = System.currentTimeMillis() / 1000;
        }
    }

    public void aKE() {
        if ("personalize_page".equals(this.ahe) && this.ebE != null && this.ebU != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10754").ab("fid", this.ebE.getForumId()).ab("tid", this.ebo).ab("obj_duration", String.valueOf(currentTimeMillis - this.ebU)).ab("obj_param3", String.valueOf(currentTimeMillis)));
            this.ebU = 0L;
        }
    }

    public boolean aKF() {
        return this.ebX;
    }

    public int aKG() {
        return this.ebF;
    }

    public int getErrorNo() {
        return this.ebZ;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public cy aKH() {
        return this.ecb;
    }

    public cq aKI() {
        return this.ecc;
    }

    public ct aKJ() {
        return this.ecd;
    }

    public String aKK() {
        return this.ebT;
    }

    public void nY(String str) {
        this.ebT = str;
    }

    public boolean aKL() {
        return this.ebY;
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.ebE != null && this.ebE.aIm() != null && this.ebE.aIm().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.ebE.aIm().size();
                for (int i = 0; i < size; i++) {
                    if (this.ebE.aIm().get(i) != null && this.ebE.aIm().get(i).getAuthor() != null && currentAccount.equals(this.ebE.aIm().get(i).getAuthor().getUserId()) && this.ebE.aIm().get(i).getAuthor().getPendantData() != null) {
                        this.ebE.aIm().get(i).getAuthor().getPendantData().cs(kVar.pS());
                        this.ebE.aIm().get(i).getAuthor().getPendantData().O(kVar.Cb());
                    }
                }
            }
        }
    }
}
