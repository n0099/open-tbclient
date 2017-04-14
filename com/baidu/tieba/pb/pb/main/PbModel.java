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
    private com.baidu.tieba.tbadkCore.d.b bFk;
    private long bXF;
    private BaseActivity bcy;
    private int bxO;
    private int doR;
    private com.baidu.adp.framework.listener.a dpb;
    private int elA;
    private boolean elB;
    private boolean elC;
    private boolean elD;
    private boolean elE;
    private a elF;
    private String elG;
    private String elH;
    private int elI;
    private int elJ;
    private boolean elK;
    private boolean elL;
    private boolean elM;
    private boolean elN;
    private boolean elO;
    private String elP;
    private long elQ;
    private boolean elR;
    private int elS;
    private boolean elT;
    private boolean elU;
    private int elV;
    private final Cdo elW;
    private final df elX;
    private final cv elY;
    private final cy elZ;
    protected String elj;
    private String elk;
    private boolean ell;
    private boolean elm;
    private boolean eln;
    private long elo;
    private int elp;
    private int elq;
    private int elr;
    private boolean els;
    private boolean elt;
    private boolean elu;
    private boolean elv;
    private long elw;
    private boolean elx;
    private String ely;
    protected com.baidu.tieba.pb.data.f elz;
    private final db ema;
    private CustomMessageListener emb;
    private CustomMessageListener emc;
    private PraiseData emd;
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
    private static final int eli = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.f fVar);
    }

    public void in(boolean z) {
        this.elR = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.alY = null;
        this.elj = null;
        this.elk = null;
        this.ell = false;
        this.elm = true;
        this.eln = true;
        this.mIsGood = 0;
        this.doR = 0;
        this.elo = 0L;
        this.elp = 1;
        this.elq = 1;
        this.elr = 1;
        this.bxO = 1;
        this.isAd = false;
        this.els = false;
        this.elt = false;
        this.elu = false;
        this.isFromMark = false;
        this.elv = false;
        this.elw = 0L;
        this.elx = false;
        this.ely = null;
        this.elz = null;
        this.isLoading = false;
        this.elB = false;
        this.elC = false;
        this.elD = false;
        this.elE = false;
        this.mLocate = null;
        this.mContext = null;
        this.elF = null;
        this.opType = null;
        this.opUrl = null;
        this.elG = null;
        this.elH = null;
        this.elI = -1;
        this.elJ = -1;
        this.bFk = null;
        this.elL = false;
        this.elM = false;
        this.postID = null;
        this.elP = null;
        this.elQ = 0L;
        this.elR = false;
        this.elS = -1;
        this.elU = false;
        this.emb = new dj(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.emc = new dl(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.dpb = new dm(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.emd = null;
        registerListener(this.emb);
        registerListener(this.dpb);
        registerListener(this.emc);
        this.elz = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bcy = baseActivity;
        this.elW = new Cdo(this, this.bcy);
        this.elX = new df(this, this.bcy);
        this.elY = new cv(this, this.bcy);
        this.elZ = new cy(this, this.bcy);
        this.ema = new db(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aLz() {
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
        this.elj = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.elj)) {
            this.elj = this.elW.R(intent);
        }
        this.elk = intent.getStringExtra("post_id");
        this.ell = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eln = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.alY = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.doR = intent.getIntExtra("is_top", 0);
        this.elo = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.elv = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.els = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.elx = intent.getBooleanExtra("is_pv", false);
        this.elw = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.ely = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.elH = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.elG = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.elB = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.elC = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.elD = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.elJ = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.elI = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.elt = intent.getBooleanExtra("from_frs", false);
        this.elu = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.elU = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.elE = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.elj = bundle.getString("thread_id");
        this.elk = bundle.getString("post_id");
        this.ell = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eln = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.alY = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.doR = bundle.getInt("is_top", 0);
        this.elo = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.elv = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.els = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.elx = bundle.getBoolean("is_pv", false);
        this.elw = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.ely = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.elH = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.elB = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.elC = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.elD = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.elJ = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.elI = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.elt = bundle.getBoolean("from_frs", false);
        this.elu = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.elU = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.elE = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void p(Bundle bundle) {
        bundle.putString("thread_id", this.elj);
        bundle.putString("post_id", this.elk);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.ell);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.eln);
        bundle.putString("st_type", this.alY);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.doR);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.elo);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.elv);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.els);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.elx);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.elw);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.elH);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.elB);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.elC);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.elD);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.elJ);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.elI);
        bundle.putBoolean("from_frs", this.elt);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.elu);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.elU);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.elE);
    }

    public String aLA() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.elj);
        if (!this.elv) {
            sb.append(this.elk);
        }
        sb.append(this.ell);
        sb.append(this.eln);
        sb.append(this.alY);
        sb.append(this.mIsGood);
        sb.append(this.doR);
        sb.append(this.elo);
        sb.append(this.elt);
        sb.append(this.elu);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.els);
        sb.append(this.elx);
        sb.append(this.elw);
        sb.append(this.ely);
        sb.append(this.mThreadType);
        sb.append(this.elB);
        sb.append(this.elC);
        sb.append(this.elD);
        if (this.elH != null) {
            sb.append(this.elH);
        }
        return sb.toString();
    }

    public String aLB() {
        return this.ely;
    }

    public String getPostId() {
        return this.elk;
    }

    public void nz(String str) {
        this.elk = str;
    }

    public String getThreadID() {
        return this.elj;
    }

    public boolean getHostMode() {
        return this.ell;
    }

    public boolean aLC() {
        return this.eln;
    }

    public boolean aLD() {
        return this.elt;
    }

    public boolean aLE() {
        return this.elu;
    }

    public boolean aLF() {
        return this.elE;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aLG() {
        return "hot_topic".equals(this.alY);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int awy() {
        return this.doR;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void gV(int i) {
        this.doR = i;
    }

    public boolean aLH() {
        return this.els;
    }

    public boolean aLI() {
        if (this.elz == null) {
            return false;
        }
        return this.elz.isValid();
    }

    public String sx() {
        if (this.elz == null || !this.elz.oe()) {
            return null;
        }
        return this.elz.od();
    }

    public boolean oh(int i) {
        this.elp = i;
        if (this.elp > this.elz.rr().ri()) {
            this.elp = this.elz.rr().ri();
        }
        if (this.elp < 1) {
            this.elp = 1;
        }
        if (this.elj == null) {
            return false;
        }
        return ol(5);
    }

    public boolean oi(int i) {
        int tc = this.elz.aJx().tc();
        if (i <= tc) {
            tc = i;
        }
        int i2 = tc >= 1 ? tc : 1;
        if (this.elj == null) {
            return false;
        }
        this.elS = i2;
        return ol(7);
    }

    public void oj(int i) {
        this.elp = i;
        this.elq = i;
        this.elr = i;
    }

    public void ok(int i) {
        if (this.elq < i) {
            this.elq = i;
            if (this.elq - this.elr >= eli) {
                this.elr = (this.elq - eli) + 1;
            }
        }
        if (this.elr > i) {
            this.elr = i;
            if (this.elq - this.elr >= eli) {
                this.elq = (this.elr + eli) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.elz;
    }

    public com.baidu.tbadk.core.data.ap alU() {
        if (this.elz == null) {
            return null;
        }
        return this.elz.rr();
    }

    public boolean aLJ() {
        if (this.eln) {
            if (this.elz.rr().rn() == 0) {
                io(true);
                return true;
            }
        } else if (this.elz.rr().ro() == 0) {
            ip(true);
            return true;
        }
        return false;
    }

    public void nt(String str) {
        if (!StringUtils.isNull(str)) {
            this.elj = str;
            this.elk = null;
            this.ell = false;
            this.eln = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.elj == null) {
            return false;
        }
        cancelLoadData();
        if (this.bFk == null) {
            this.bFk = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bFk.start();
        }
        boolean ol = ol(3);
        if (this.opType != null) {
            this.opType = null;
            this.elG = null;
            this.opUrl = null;
            return ol;
        }
        return ol;
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
        Wl();
    }

    private void Wl() {
        if (this.bFk != null) {
            this.bFk.destory();
            this.bFk = null;
        }
    }

    public boolean FC() {
        return (this.elk == null || this.elk.equals("0") || this.elk.length() == 0) ? LoadData() : aLM();
    }

    public boolean ol(int i) {
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        om(i);
        com.baidu.tieba.pb.data.f pbData = ep.aMK().getPbData();
        if (pbData != null && pbData.aJx() != null) {
            pbData.aJx().bR(0);
            this.eln = ep.aMK().aLC();
            this.ell = ep.aMK().aMM();
            if (!this.eln || this.ell || this.isFromMark) {
                this.elK = false;
            }
            com.baidu.adp.lib.g.h.fR().post(new dn(this, pbData));
            return false;
        }
        if (i == 4 && !this.elO) {
            a(aLR(), true, this.elk, 3);
        }
        if (i == 3 && !this.elO) {
            if (this.isFromMark) {
                a(aLR(), true, this.elk, 3);
            } else {
                a(aLR(), false, this.elk, 3);
            }
        }
        this.elO = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aya);
        if (!this.eln || this.ell || this.isFromMark) {
            this.elK = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.elj == null || this.elj.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.elj, 0L));
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
        if (!this.eln) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.ell) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.alY != null) {
            pbPageRequestMessage.set_st_type(this.alY);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.elx) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.elw));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.elK) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.elG, 0));
            pbPageRequestMessage.setOpMessageID(this.elw);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aJz = this.elz.aJz();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eln) {
                        if (this.elr - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.elr - 1));
                        }
                    } else if (this.elq < this.bxO) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.elq + 1));
                    }
                }
                if (aJz != null && aJz.size() > 0) {
                    int size = aJz.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        PostData postData = aJz.get(size - i3);
                        if (postData == null) {
                            i3++;
                        } else {
                            this.elk = postData.getId();
                            if (StringUtils.isNull(this.elk)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.elk != null && this.elk.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.elk, 0L));
                    break;
                } else if (!this.eln) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aJz != null && aJz.size() > 0 && aJz.get(0) != null) {
                    this.elk = aJz.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eln) {
                        if (this.elr - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.elr - 1));
                        }
                    } else if (this.elq < this.bxO) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.elq + 1));
                    }
                }
                if (this.elk != null && this.elk.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.elk, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eln) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.elk, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.elp));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.elk, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.elS);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aLR());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bcy != null && (this.bcy instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bcy).aKo());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.elR);
        pbPageRequestMessage.setFromSmartFrs(this.elU ? 1 : 0);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void om(int i) {
        boolean z = false;
        ArrayList<PostData> aJz = this.elz.aJz();
        this.elN = false;
        if (i == 1) {
            boolean z2 = false;
            while (aJz.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aJz.remove(0);
                z2 = true;
            }
            if (z2) {
                this.elz.rr().bN(1);
                if (this.elF != null) {
                    this.elF.c(this.elz);
                }
            }
            this.bXF = System.currentTimeMillis();
            this.elN = true;
        } else if (i == 2) {
            while (aJz.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aJz.remove(aJz.size() - 1);
                z = true;
            }
            if (z) {
                this.elz.rr().bM(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.elV = i2;
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
            if (this.elD || this.elB || this.elC) {
                fVar = f(fVar);
            }
            e(fVar);
        }
    }

    protected void e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String g = g(fVar);
            for (int i = 0; i < fVar.aJz().size(); i++) {
                PostData postData = fVar.aJz().get(i);
                for (int i2 = 0; i2 < postData.bil().size(); i2++) {
                    postData.bil().get(i2).b(this.bcy.getPageContext(), g.equals(postData.bil().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.f f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.bi aJx = fVar.aJx();
        aJx.bU(this.mIsGood);
        aJx.bT(this.doR);
        if (this.elo > 0) {
            aJx.m(this.elo);
            return fVar;
        }
        return fVar;
    }

    protected String g(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aJx() != null && fVar.aJx().getAuthor() != null) {
            str = fVar.aJx().getAuthor().getUserId();
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
        if (fVar.aJx() != null && fVar.aJx().getAuthor() != null) {
            str = fVar.aJx().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aLK() {
        if (this.elz == null || this.elz.aJx() == null || this.elz.aJx().getAuthor() == null) {
            return null;
        }
        return this.elz.aJx().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.elT = z3;
        this.elA = i;
        if (this.bFk != null && !z3) {
            this.bFk.a(z2, z4, i2, str, i3, j, j2);
            this.bFk = null;
        }
        if (fVar == null || (this.elp == 1 && i == 5 && fVar.aJz() != null && fVar.aJz().size() < 1)) {
            if (this.elF != null) {
                this.eln = this.elm;
                this.elF.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.elm = this.eln;
            this.elx = false;
            if (fVar.rr() != null) {
                ok(fVar.rr().rl());
                this.bxO = fVar.rr().ri();
            }
            this.bxO = this.bxO < 1 ? 1 : this.bxO;
            int i5 = 0;
            ArrayList<PostData> aJz = this.elz.aJz();
            switch (i) {
                case 1:
                    this.elz.a(fVar.rr(), 1);
                    b(fVar, aJz);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aJz() != null) {
                        int size = fVar.aJz().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(aJz, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aJz(), com.baidu.tbadk.core.util.x.p(fVar.aJz()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aJz().remove(postData2);
                            i5 = size - 1;
                        }
                        aJz.addAll(0, fVar.aJz());
                    }
                    this.elz.a(fVar.rr(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.eln && fVar.rr() != null) {
                        fVar.rr().bK(fVar.rr().ri());
                    }
                    i(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eln) {
                        aLL();
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
            if (this.elz != null && this.elz.aJx() != null) {
                PraiseData se = this.elz.aJx().se();
                if (this.emd != null && !se.isPriaseDataValid()) {
                    this.elz.aJx().a(this.emd);
                } else {
                    this.emd = this.elz.aJx().se();
                    this.emd.setPostId(this.elz.aJx().sE());
                }
                if (fVar.rr() != null && fVar.rr().rl() == 1 && fVar.aJx() != null && fVar.aJx().sz() != null && fVar.aJx().sz().size() > 0) {
                    this.elz.aJx().h(fVar.aJx().sz());
                }
                this.elz.aJx().bS(fVar.aJx().sh());
                this.elz.aJx().bQ(fVar.aJx().getAnchorLevel());
                this.elz.aJx().bR(fVar.aJx().sc());
                if (this.mThreadType == 33) {
                    this.elz.aJx().getAuthor().setHadConcerned(fVar.aJx().getAuthor().hadConcerned());
                }
            }
            if (this.elz != null && this.elz.getUserData() != null && fVar.getUserData() != null) {
                this.elz.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.elz.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.rr() != null && fVar.rr().rl() == 1 && fVar.aJG() != null) {
                this.elz.a(fVar.aJG());
            }
            if (this.elT && this.elz.aJx() != null && this.elz.aJx().getAuthor() != null && this.elz.aJz() != null && com.baidu.tbadk.core.util.x.c(this.elz.aJz(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.c(this.elz.aJz(), 0);
                MetaData author = this.elz.aJx().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.elI != -1) {
                        author.setFansNum(this.elI);
                        postData3.getAuthor().setFansNum(this.elI);
                    }
                    if (this.elJ != -1) {
                        author.getGodUserData().setIsLike(this.elJ == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.elJ == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.elz != null && this.elz.aJu() != null && fVar.aJu() != null) {
                this.elz.aJu().k(fVar.aJu().getItems());
                this.elz.aJu().ap(fVar.aJu().qU());
            }
            if (this.elF != null) {
                this.elF.a(true, getErrorCode(), i, i4, this.elz, this.mErrorString, 1);
            }
        }
        if (this.elz != null && this.elz.aJx() != null && this.elz.aJw() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bcy;
            historyMessage.threadId = getPbData().aJx().getId();
            historyMessage.forumName = getPbData().aJw().getName();
            historyMessage.threadName = getPbData().aJx().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aLC();
            historyMessage.threadType = getPbData().aJx().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void b(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ak;
        if (arrayList != null && fVar.aJz() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aJz(), 0);
            if (postData != null && (ak = ak(arrayList)) != null && ak.equals(postData.getId())) {
                fVar.aJz().remove(postData);
            }
            arrayList.addAll(fVar.aJz());
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
        fVar.ns(this.elz.aJN());
        this.elz = fVar;
        oj(fVar.rr().rl());
    }

    private void aLL() {
        if (this.elz != null && this.elz.aJz() != null && this.elz.aJL() != null) {
            ArrayList<PostData> aJz = this.elz.aJz();
            com.baidu.tieba.pb.data.a aJL = this.elz.aJL();
            int aJn = aJL.aJn();
            if (aJn > 0) {
                if (aJn <= aJz.size()) {
                    aJz.add(aJn, aJL);
                } else {
                    aJz.add(aJL);
                }
            }
        }
    }

    public boolean aLM() {
        if (this.elj == null || this.elk == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return ol(4);
        }
        return ol(6);
    }

    public boolean io(boolean z) {
        if (this.elj == null || this.elz == null) {
            return false;
        }
        if (z || this.elz.rr().rn() != 0) {
            return ol(1);
        }
        return false;
    }

    public boolean ip(boolean z) {
        if (this.elj == null || this.elz == null) {
            return false;
        }
        if ((z || this.elz.rr().ro() != 0) && this.elz.aJz() != null && this.elz.aJz().size() >= 1) {
            return ol(2);
        }
        return false;
    }

    public boolean nA(String str) {
        this.ell = !this.ell;
        this.elk = str;
        ol(6);
        return true;
    }

    public boolean aLN() {
        if (com.baidu.adp.lib.util.i.hj()) {
            this.elm = this.eln;
            this.eln = !this.eln;
        }
        return LoadData();
    }

    public boolean aLO() {
        return this.eln;
    }

    public boolean hasData() {
        return (this.elz == null || this.elz.aJw() == null || this.elz.aJx() == null) ? false : true;
    }

    public boolean oe() {
        if (this.elz == null) {
            return false;
        }
        return this.elz.oe();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData ft(String str) {
        if (this.elz == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.elz.aJw().getId());
        writeData.setForumName(this.elz.aJw().getName());
        writeData.setThreadId(this.elj);
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

    public MarkData on(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.elz == null || this.elz.aJz() == null) {
            return null;
        }
        ArrayList<PostData> aJz = this.elz.aJz();
        if (aJz.size() > 0 && i == aJz.size()) {
            i = aJz.size() - 1;
        }
        if (aJz.size() <= 0 || i >= aJz.size()) {
            return null;
        }
        return e(aJz.get(i));
    }

    public MarkData aLP() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.elj);
        markData.setPostId(this.elz.od());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ell);
        markData.setSequence(Boolean.valueOf(this.eln));
        markData.setId(this.elj);
        return markData;
    }

    public MarkData e(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.elj);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ell);
        markData.setSequence(Boolean.valueOf(this.eln));
        markData.setId(this.elj);
        markData.setFloor(postData.bio());
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.o) postData).isApp());
        }
        return markData;
    }

    public void aLQ() {
        cu.aLh().M(aLR(), this.isFromMark);
    }

    private String aLR() {
        String str = this.elj;
        if (this.ell) {
            str = String.valueOf(str) + DB_KEY_HOST;
        }
        if (!this.eln) {
            str = String.valueOf(str) + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void iq(boolean z) {
        if (this.elz != null) {
            this.elz.ae(z);
        }
    }

    public void ir(boolean z) {
        this.elK = z;
    }

    public boolean aLS() {
        return this.elK;
    }

    public void a(a aVar) {
        this.elF = aVar;
    }

    public void mB(String str) {
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

    public boolean nB(String str) {
        if (getPbData() == null || getPbData().aJx() == null || getPbData().aJx().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aJx().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aLT() {
        return this.mRequestType;
    }

    public void aLU() {
        String aLR = aLR();
        cu.aLh().M(aLR, false);
        cu.aLh().M(aLR, true);
    }

    public void aLV() {
        if ("personalize_page".equals(this.alY)) {
            this.elQ = System.currentTimeMillis() / 1000;
        }
    }

    public void aLW() {
        if ("personalize_page".equals(this.alY) && this.elz != null && this.elQ != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10754").aa("fid", this.elz.getForumId()).aa("tid", this.elj).aa("obj_duration", String.valueOf(currentTimeMillis - this.elQ)).aa("obj_param3", String.valueOf(currentTimeMillis)));
            this.elQ = 0L;
        }
    }

    public boolean aLX() {
        return this.elT;
    }

    public int aLY() {
        return this.elA;
    }

    public int getErrorNo() {
        return this.elV;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public df aLZ() {
        return this.elX;
    }

    public cv aMa() {
        return this.elY;
    }

    public cy aMb() {
        return this.elZ;
    }

    public db aMc() {
        return this.ema;
    }

    public String aMd() {
        return this.elP;
    }

    public void nC(String str) {
        this.elP = str;
    }

    public boolean aMe() {
        return this.elU;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.elz != null && this.elz.aJz() != null && this.elz.aJz().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.elz.aJz().size();
                for (int i = 0; i < size; i++) {
                    if (this.elz.aJz().get(i) != null && this.elz.aJz().get(i).getAuthor() != null && currentAccount.equals(this.elz.aJz().get(i).getAuthor().getUserId()) && this.elz.aJz().get(i).getAuthor().getPendantData() != null) {
                        this.elz.aJz().get(i).getAuthor().getPendantData().cr(jVar.qB());
                        this.elz.aJz().get(i).getAuthor().getPendantData().N(jVar.CO());
                    }
                }
            }
        }
    }
}
