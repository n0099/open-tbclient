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
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class PbModel extends DataModel {
    public static final String DB_KEY_HOST = "_host";
    public static final String DB_KEY_REVER = "_rev";
    public static final int UPDATE_TYPE_MARK = 4;
    public static final int UPDATE_TYPE_MORE = 1;
    public static final int UPDATE_TYPE_PREVIOUS = 2;
    public static final int UPDATE_TYPE_REDIRECTPAGE = 5;
    public static final int UPDATE_TYPE_REDIRECT_FLOOR = 7;
    public static final int UPDATE_TYPE_SPEC_FLOOR = 6;
    public static final int UPDATE_TYPE_UPDATE = 3;
    private String alY;
    private int bAf;
    private com.baidu.tieba.tbadkCore.d.b bHB;
    private long bZW;
    private BaseActivity bdG;
    private int dri;
    private com.baidu.adp.framework.listener.a drs;
    protected String enB;
    private String enC;
    private boolean enD;
    private boolean enE;
    private boolean enF;
    private long enG;
    private int enH;
    private int enI;
    private int enJ;
    private boolean enK;
    private boolean enL;
    private boolean enM;
    private boolean enN;
    private long enO;
    private boolean enP;
    private String enQ;
    protected com.baidu.tieba.pb.data.f enR;
    private int enS;
    private boolean enT;
    private boolean enU;
    private boolean enV;
    private boolean enW;
    private a enX;
    private String enY;
    private String enZ;
    private int eoa;
    private int eob;
    private boolean eoc;
    private boolean eod;
    private boolean eoe;
    private boolean eog;
    private boolean eoh;
    private String eoi;
    private long eoj;
    private boolean eok;
    private int eol;
    private boolean eom;
    private boolean eon;
    private int eoo;
    private final Cdo eop;
    private final df eoq;
    private final cv eor;
    private final cy eos;
    private final db eot;
    private CustomMessageListener eou;
    private CustomMessageListener eov;
    private PraiseData eow;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private com.baidu.tieba.pb.data.e mAppealInfo;
    protected Context mContext;
    private int mIsGood;
    private String mLocate;
    private int mRequestType;
    protected int mThreadType;
    private String opType;
    private String opUrl;
    private String postID;
    private static final int enA = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.f fVar);
    }

    public void ix(boolean z) {
        this.eok = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.alY = null;
        this.enB = null;
        this.enC = null;
        this.enD = false;
        this.enE = true;
        this.enF = true;
        this.mIsGood = 0;
        this.dri = 0;
        this.enG = 0L;
        this.enH = 1;
        this.enI = 1;
        this.enJ = 1;
        this.bAf = 1;
        this.isAd = false;
        this.enK = false;
        this.enL = false;
        this.enM = false;
        this.isFromMark = false;
        this.enN = false;
        this.enO = 0L;
        this.enP = false;
        this.enQ = null;
        this.enR = null;
        this.isLoading = false;
        this.enT = false;
        this.enU = false;
        this.enV = false;
        this.enW = false;
        this.mLocate = null;
        this.mContext = null;
        this.enX = null;
        this.opType = null;
        this.opUrl = null;
        this.enY = null;
        this.enZ = null;
        this.eoa = -1;
        this.eob = -1;
        this.bHB = null;
        this.eod = false;
        this.eoe = false;
        this.postID = null;
        this.eoi = null;
        this.eoj = 0L;
        this.eok = false;
        this.eol = -1;
        this.eon = false;
        this.eou = new dj(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.eov = new dl(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.drs = new dm(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.eow = null;
        registerListener(this.eou);
        registerListener(this.drs);
        registerListener(this.eov);
        this.enR = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bdG = baseActivity;
        this.eop = new Cdo(this, this.bdG);
        this.eoq = new df(this, this.bdG);
        this.eor = new cv(this, this.bdG);
        this.eos = new cy(this, this.bdG);
        this.eot = new db(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aMA() {
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
        this.enB = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.enB)) {
            this.enB = this.eop.S(intent);
        }
        this.enC = intent.getStringExtra("post_id");
        this.enD = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.enF = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.alY = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dri = intent.getIntExtra("is_top", 0);
        this.enG = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.enN = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.enK = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.enP = intent.getBooleanExtra("is_pv", false);
        this.enO = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.enQ = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.enZ = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.enY = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.enT = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.enU = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.enV = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eob = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eoa = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.enL = intent.getBooleanExtra("from_frs", false);
        this.enM = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eon = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.enW = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.enB = bundle.getString("thread_id");
        this.enC = bundle.getString("post_id");
        this.enD = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.enF = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.alY = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dri = bundle.getInt("is_top", 0);
        this.enG = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.enN = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.enK = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.enP = bundle.getBoolean("is_pv", false);
        this.enO = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.enQ = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.enZ = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.enT = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.enU = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.enV = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eob = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eoa = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.enL = bundle.getBoolean("from_frs", false);
        this.enM = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eon = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.enW = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void p(Bundle bundle) {
        bundle.putString("thread_id", this.enB);
        bundle.putString("post_id", this.enC);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.enD);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.enF);
        bundle.putString("st_type", this.alY);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dri);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.enG);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.enN);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.enK);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.enP);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.enO);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.enZ);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.enT);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.enU);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.enV);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.eob);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.eoa);
        bundle.putBoolean("from_frs", this.enL);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.enM);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.eon);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.enW);
    }

    public String aMB() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.enB);
        if (!this.enN) {
            sb.append(this.enC);
        }
        sb.append(this.enD);
        sb.append(this.enF);
        sb.append(this.alY);
        sb.append(this.mIsGood);
        sb.append(this.dri);
        sb.append(this.enG);
        sb.append(this.enL);
        sb.append(this.enM);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.enK);
        sb.append(this.enP);
        sb.append(this.enO);
        sb.append(this.enQ);
        sb.append(this.mThreadType);
        sb.append(this.enT);
        sb.append(this.enU);
        sb.append(this.enV);
        if (this.enZ != null) {
            sb.append(this.enZ);
        }
        return sb.toString();
    }

    public String aMC() {
        return this.enQ;
    }

    public String getPostId() {
        return this.enC;
    }

    public void nA(String str) {
        this.enC = str;
    }

    public String getThreadID() {
        return this.enB;
    }

    public boolean getHostMode() {
        return this.enD;
    }

    public boolean aMD() {
        return this.enF;
    }

    public boolean aME() {
        return this.enL;
    }

    public boolean aMF() {
        return this.enM;
    }

    public boolean aMG() {
        return this.enW;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aMH() {
        return "hot_topic".equals(this.alY);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int axz() {
        return this.dri;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void hb(int i) {
        this.dri = i;
    }

    public boolean aMI() {
        return this.enK;
    }

    public boolean aMJ() {
        if (this.enR == null) {
            return false;
        }
        return this.enR.isValid();
    }

    public String sx() {
        if (this.enR == null || !this.enR.oe()) {
            return null;
        }
        return this.enR.od();
    }

    public boolean on(int i) {
        this.enH = i;
        if (this.enH > this.enR.rr().ri()) {
            this.enH = this.enR.rr().ri();
        }
        if (this.enH < 1) {
            this.enH = 1;
        }
        if (this.enB == null) {
            return false;
        }
        return or(5);
    }

    public boolean oo(int i) {
        int tc = this.enR.aKy().tc();
        if (i <= tc) {
            tc = i;
        }
        int i2 = tc >= 1 ? tc : 1;
        if (this.enB == null) {
            return false;
        }
        this.eol = i2;
        return or(7);
    }

    public void op(int i) {
        this.enH = i;
        this.enI = i;
        this.enJ = i;
    }

    public void oq(int i) {
        if (this.enI < i) {
            this.enI = i;
            if (this.enI - this.enJ >= enA) {
                this.enJ = (this.enI - enA) + 1;
            }
        }
        if (this.enJ > i) {
            this.enJ = i;
            if (this.enI - this.enJ >= enA) {
                this.enI = (this.enJ + enA) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.enR;
    }

    public com.baidu.tbadk.core.data.ap amV() {
        if (this.enR == null) {
            return null;
        }
        return this.enR.rr();
    }

    public boolean aMK() {
        if (this.enF) {
            if (this.enR.rr().rn() == 0) {
                iy(true);
                return true;
            }
        } else if (this.enR.rr().ro() == 0) {
            iz(true);
            return true;
        }
        return false;
    }

    public void nu(String str) {
        if (!StringUtils.isNull(str)) {
            this.enB = str;
            this.enC = null;
            this.enD = false;
            this.enF = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.enB == null) {
            return false;
        }
        cancelLoadData();
        if (this.bHB == null) {
            this.bHB = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bHB.start();
        }
        boolean or = or(3);
        if (this.opType != null) {
            this.opType = null;
            this.enY = null;
            this.opUrl = null;
            return or;
        }
        return or;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        this.isLoading = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Xm();
    }

    private void Xm() {
        if (this.bHB != null) {
            this.bHB.destory();
            this.bHB = null;
        }
    }

    public boolean FC() {
        return (this.enC == null || this.enC.equals("0") || this.enC.length() == 0) ? LoadData() : aMN();
    }

    public boolean or(int i) {
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        os(i);
        com.baidu.tieba.pb.data.f pbData = ep.aNL().getPbData();
        if (pbData != null && pbData.aKy() != null) {
            pbData.aKy().bR(0);
            this.enF = ep.aNL().aMD();
            this.enD = ep.aNL().aNN();
            if (!this.enF || this.enD || this.isFromMark) {
                this.eoc = false;
            }
            com.baidu.adp.lib.g.h.fS().post(new dn(this, pbData));
            return false;
        }
        if (i == 4 && !this.eoh) {
            a(aMS(), true, this.enC, 3);
        }
        if (i == 3 && !this.eoh) {
            if (this.isFromMark) {
                a(aMS(), true, this.enC, 3);
            } else {
                a(aMS(), false, this.enC, 3);
            }
        }
        this.eoh = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.ayc);
        if (!this.enF || this.enD || this.isFromMark) {
            this.eoc = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.enB == null || this.enB.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.enB, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.av.wa().wc() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.enF) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.enD) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.alY != null) {
            pbPageRequestMessage.set_st_type(this.alY);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.enP) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.enO));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eoc) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.enY, 0));
            pbPageRequestMessage.setOpMessageID(this.enO);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aKA = this.enR.aKA();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.enF) {
                        if (this.enJ - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.enJ - 1));
                        }
                    } else if (this.enI < this.bAf) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.enI + 1));
                    }
                }
                if (aKA != null && aKA.size() > 0) {
                    int size = aKA.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        PostData postData = aKA.get(size - i3);
                        if (postData == null) {
                            i3++;
                        } else {
                            this.enC = postData.getId();
                            if (StringUtils.isNull(this.enC)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.enC != null && this.enC.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.enC, 0L));
                    break;
                } else if (!this.enF) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aKA != null && aKA.size() > 0 && aKA.get(0) != null) {
                    this.enC = aKA.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.enF) {
                        if (this.enJ - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.enJ - 1));
                        }
                    } else if (this.enI < this.bAf) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.enI + 1));
                    }
                }
                if (this.enC != null && this.enC.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.enC, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.enF) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.enC, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.enH));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.enC, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eol);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aMS());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bdG != null && (this.bdG instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bdG).aLp());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.eok);
        pbPageRequestMessage.setFromSmartFrs(this.eon ? 1 : 0);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void os(int i) {
        boolean z = false;
        ArrayList<PostData> aKA = this.enR.aKA();
        this.eog = false;
        if (i == 1) {
            boolean z2 = false;
            while (aKA.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aKA.remove(0);
                z2 = true;
            }
            if (z2) {
                this.enR.rr().bN(1);
                if (this.enX != null) {
                    this.enX.c(this.enR);
                }
            }
            this.bZW = System.currentTimeMillis();
            this.eog = true;
        } else if (i == 2) {
            while (aKA.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aKA.remove(aKA.size() - 1);
                z = true;
            }
            if (z) {
                this.enR.rr().bM(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.eoo = i2;
        this.isLoading = false;
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
            if (this.enV || this.enT || this.enU) {
                fVar = f(fVar);
            }
            e(fVar);
        }
    }

    protected void e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String g = g(fVar);
            for (int i = 0; i < fVar.aKA().size(); i++) {
                PostData postData = fVar.aKA().get(i);
                for (int i2 = 0; i2 < postData.bjm().size(); i2++) {
                    postData.bjm().get(i2).b(this.bdG.getPageContext(), g.equals(postData.bjm().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.f f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.bi aKy = fVar.aKy();
        aKy.bU(this.mIsGood);
        aKy.bT(this.dri);
        if (this.enG > 0) {
            aKy.m(this.enG);
            return fVar;
        }
        return fVar;
    }

    protected String g(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aKy() != null && fVar.aKy().getAuthor() != null) {
            str = fVar.aKy().getAuthor().getUserId();
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
        if (fVar.aKy() != null && fVar.aKy().getAuthor() != null) {
            str = fVar.aKy().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aML() {
        if (this.enR == null || this.enR.aKy() == null || this.enR.aKy().getAuthor() == null) {
            return null;
        }
        return this.enR.aKy().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.eom = z3;
        this.enS = i;
        if (this.bHB != null && !z3) {
            this.bHB.a(z2, z4, i2, str, i3, j, j2);
            this.bHB = null;
        }
        if (fVar == null || (this.enH == 1 && i == 5 && fVar.aKA() != null && fVar.aKA().size() < 1)) {
            if (this.enX != null) {
                this.enF = this.enE;
                this.enX.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.enE = this.enF;
            this.enP = false;
            if (fVar.rr() != null) {
                oq(fVar.rr().rl());
                this.bAf = fVar.rr().ri();
            }
            this.bAf = this.bAf < 1 ? 1 : this.bAf;
            int i5 = 0;
            ArrayList<PostData> aKA = this.enR.aKA();
            switch (i) {
                case 1:
                    this.enR.a(fVar.rr(), 1);
                    b(fVar, aKA);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aKA() != null) {
                        int size = fVar.aKA().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(aKA, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aKA(), com.baidu.tbadk.core.util.x.p(fVar.aKA()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aKA().remove(postData2);
                            i5 = size - 1;
                        }
                        aKA.addAll(0, fVar.aKA());
                    }
                    this.enR.a(fVar.rr(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.enF && fVar.rr() != null) {
                        fVar.rr().bK(fVar.rr().ri());
                    }
                    i(fVar);
                    if (!z3 && this.mThreadType != 33 && this.enF) {
                        aMM();
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
            if (this.enR != null && this.enR.aKy() != null) {
                PraiseData se = this.enR.aKy().se();
                if (this.eow != null && !se.isPriaseDataValid()) {
                    this.enR.aKy().a(this.eow);
                } else {
                    this.eow = this.enR.aKy().se();
                    this.eow.setPostId(this.enR.aKy().sE());
                }
                if (fVar.rr() != null && fVar.rr().rl() == 1 && fVar.aKy() != null && fVar.aKy().sz() != null && fVar.aKy().sz().size() > 0) {
                    this.enR.aKy().h(fVar.aKy().sz());
                }
                this.enR.aKy().bS(fVar.aKy().sh());
                this.enR.aKy().bQ(fVar.aKy().getAnchorLevel());
                this.enR.aKy().bR(fVar.aKy().sc());
                if (this.mThreadType == 33) {
                    this.enR.aKy().getAuthor().setHadConcerned(fVar.aKy().getAuthor().hadConcerned());
                }
            }
            if (this.enR != null && this.enR.getUserData() != null && fVar.getUserData() != null) {
                this.enR.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.enR.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.rr() != null && fVar.rr().rl() == 1 && fVar.aKH() != null) {
                this.enR.a(fVar.aKH());
            }
            if (this.eom && this.enR.aKy() != null && this.enR.aKy().getAuthor() != null && this.enR.aKA() != null && com.baidu.tbadk.core.util.x.c(this.enR.aKA(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.c(this.enR.aKA(), 0);
                MetaData author = this.enR.aKy().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.eoa != -1) {
                        author.setFansNum(this.eoa);
                        postData3.getAuthor().setFansNum(this.eoa);
                    }
                    if (this.eob != -1) {
                        author.getGodUserData().setIsLike(this.eob == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.eob == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.enR != null && this.enR.aKv() != null && fVar.aKv() != null) {
                this.enR.aKv().k(fVar.aKv().getItems());
                this.enR.aKv().ap(fVar.aKv().qU());
            }
            if (this.enX != null) {
                this.enX.a(true, getErrorCode(), i, i4, this.enR, this.mErrorString, 1);
            }
        }
        if (this.enR != null && this.enR.aKy() != null && this.enR.aKx() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bdG;
            historyMessage.threadId = getPbData().aKy().getId();
            historyMessage.forumName = getPbData().aKx().getName();
            historyMessage.threadName = getPbData().aKy().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aMD();
            historyMessage.threadType = getPbData().aKy().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void b(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ak;
        if (arrayList != null && fVar.aKA() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aKA(), 0);
            if (postData != null && (ak = ak(arrayList)) != null && ak.equals(postData.getId())) {
                fVar.aKA().remove(postData);
            }
            arrayList.addAll(fVar.aKA());
        }
    }

    private String ak(ArrayList<PostData> arrayList) {
        int p = com.baidu.tbadk.core.util.x.p(arrayList);
        if (p <= 0) {
            return null;
        }
        for (int i = p - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tieba.pb.data.f fVar) {
        fVar.nt(this.enR.aKO());
        this.enR = fVar;
        op(fVar.rr().rl());
    }

    private void aMM() {
        if (this.enR != null && this.enR.aKA() != null && this.enR.aKM() != null) {
            ArrayList<PostData> aKA = this.enR.aKA();
            com.baidu.tieba.pb.data.a aKM = this.enR.aKM();
            int aKo = aKM.aKo();
            if (aKo > 0) {
                if (aKo <= aKA.size()) {
                    aKA.add(aKo, aKM);
                } else {
                    aKA.add(aKM);
                }
            }
        }
    }

    public boolean aMN() {
        if (this.enB == null || this.enC == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return or(4);
        }
        return or(6);
    }

    public boolean iy(boolean z) {
        if (this.enB == null || this.enR == null) {
            return false;
        }
        if (z || this.enR.rr().rn() != 0) {
            return or(1);
        }
        return false;
    }

    public boolean iz(boolean z) {
        if (this.enB == null || this.enR == null) {
            return false;
        }
        if ((z || this.enR.rr().ro() != 0) && this.enR.aKA() != null && this.enR.aKA().size() >= 1) {
            return or(2);
        }
        return false;
    }

    public boolean nB(String str) {
        this.enD = !this.enD;
        this.enC = str;
        or(6);
        return true;
    }

    public boolean aMO() {
        if (com.baidu.adp.lib.util.i.hk()) {
            this.enE = this.enF;
            this.enF = !this.enF;
        }
        return LoadData();
    }

    public boolean aMP() {
        return this.enF;
    }

    public boolean hasData() {
        return (this.enR == null || this.enR.aKx() == null || this.enR.aKy() == null) ? false : true;
    }

    public boolean oe() {
        if (this.enR == null) {
            return false;
        }
        return this.enR.oe();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData ft(String str) {
        if (this.enR == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.enR.aKx().getId());
        writeData.setForumName(this.enR.aKx().getName());
        writeData.setThreadId(this.enB);
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

    public MarkData ot(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.enR == null || this.enR.aKA() == null) {
            return null;
        }
        ArrayList<PostData> aKA = this.enR.aKA();
        if (aKA.size() > 0 && i == aKA.size()) {
            i = aKA.size() - 1;
        }
        if (aKA.size() <= 0 || i >= aKA.size()) {
            return null;
        }
        return e(aKA.get(i));
    }

    public MarkData aMQ() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.enB);
        markData.setPostId(this.enR.od());
        markData.setTime(date.getTime());
        markData.setHostMode(this.enD);
        markData.setSequence(Boolean.valueOf(this.enF));
        markData.setId(this.enB);
        return markData;
    }

    public MarkData e(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.enB);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.enD);
        markData.setSequence(Boolean.valueOf(this.enF));
        markData.setId(this.enB);
        markData.setFloor(postData.bjp());
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.o) postData).isApp());
        }
        return markData;
    }

    public void aMR() {
        cu.aMi().M(aMS(), this.isFromMark);
    }

    private String aMS() {
        String str = this.enB;
        if (this.enD) {
            str = String.valueOf(str) + DB_KEY_HOST;
        }
        if (!this.enF) {
            str = String.valueOf(str) + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void iA(boolean z) {
        if (this.enR != null) {
            this.enR.ae(z);
        }
    }

    public void iB(boolean z) {
        this.eoc = z;
    }

    public boolean aMT() {
        return this.eoc;
    }

    public void a(a aVar) {
        this.enX = aVar;
    }

    public void mC(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String DJ() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean DI() {
        return FC();
    }

    public boolean nC(String str) {
        if (getPbData() == null || getPbData().aKy() == null || getPbData().aKy().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aKy().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aMU() {
        return this.mRequestType;
    }

    public void aMV() {
        String aMS = aMS();
        cu.aMi().M(aMS, false);
        cu.aMi().M(aMS, true);
    }

    public void aMW() {
        if ("personalize_page".equals(this.alY)) {
            this.eoj = System.currentTimeMillis() / 1000;
        }
    }

    public void aMX() {
        if ("personalize_page".equals(this.alY) && this.enR != null && this.eoj != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10754").aa("fid", this.enR.getForumId()).aa("tid", this.enB).aa("obj_duration", String.valueOf(currentTimeMillis - this.eoj)).aa("obj_param3", String.valueOf(currentTimeMillis)));
            this.eoj = 0L;
        }
    }

    public boolean aMY() {
        return this.eom;
    }

    public int aMZ() {
        return this.enS;
    }

    public int getErrorNo() {
        return this.eoo;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public df aNa() {
        return this.eoq;
    }

    public cv aNb() {
        return this.eor;
    }

    public cy aNc() {
        return this.eos;
    }

    public db aNd() {
        return this.eot;
    }

    public String aNe() {
        return this.eoi;
    }

    public void nD(String str) {
        this.eoi = str;
    }

    public boolean aNf() {
        return this.eon;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.enR != null && this.enR.aKA() != null && this.enR.aKA().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.enR.aKA().size();
                for (int i = 0; i < size; i++) {
                    if (this.enR.aKA().get(i) != null && this.enR.aKA().get(i).getAuthor() != null && currentAccount.equals(this.enR.aKA().get(i).getAuthor().getUserId()) && this.enR.aKA().get(i).getAuthor().getPendantData() != null) {
                        this.enR.aKA().get(i).getAuthor().getPendantData().cr(jVar.qB());
                        this.enR.aKA().get(i).getAuthor().getPendantData().N(jVar.CO());
                    }
                }
            }
        }
    }
}
