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
    private String alK;
    private com.baidu.tieba.tbadkCore.d.b bFr;
    private long bZg;
    private BaseActivity bcF;
    private int bxV;
    private com.baidu.adp.framework.listener.a dqC;
    private int dqs;
    private int enA;
    private int enB;
    private boolean enC;
    private boolean enD;
    private boolean enE;
    private boolean enF;
    private boolean enG;
    private String enH;
    private long enI;
    private boolean enJ;
    private int enK;
    private boolean enL;
    private boolean enM;
    private int enN;
    private final dq enO;
    private final dh enP;
    private final cx enQ;
    private final da enR;
    private final dd enS;
    private CustomMessageListener enT;
    private CustomMessageListener enU;
    private PraiseData enV;
    protected String enb;
    private String enc;
    private boolean ene;
    private boolean enf;
    private boolean eng;
    private long enh;
    private int eni;
    private int enj;
    private int enk;
    private boolean enl;
    private boolean enm;
    private boolean enn;
    private boolean eno;
    private long enp;
    private boolean enq;
    private String enr;
    protected com.baidu.tieba.pb.data.f ens;
    private int ent;
    private boolean enu;
    private boolean env;
    private boolean enw;
    private a enx;
    private String eny;
    private String enz;
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
    private static final int ena = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.f fVar);
    }

    public void io(boolean z) {
        this.enJ = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.alK = null;
        this.enb = null;
        this.enc = null;
        this.ene = false;
        this.enf = true;
        this.eng = true;
        this.mIsGood = 0;
        this.dqs = 0;
        this.enh = 0L;
        this.eni = 1;
        this.enj = 1;
        this.enk = 1;
        this.bxV = 1;
        this.isAd = false;
        this.enl = false;
        this.enm = false;
        this.enn = false;
        this.isFromMark = false;
        this.eno = false;
        this.enp = 0L;
        this.enq = false;
        this.enr = null;
        this.ens = null;
        this.isLoading = false;
        this.enu = false;
        this.env = false;
        this.enw = false;
        this.mLocate = null;
        this.mContext = null;
        this.enx = null;
        this.opType = null;
        this.opUrl = null;
        this.eny = null;
        this.enz = null;
        this.enA = -1;
        this.enB = -1;
        this.bFr = null;
        this.enD = false;
        this.enE = false;
        this.postID = null;
        this.enH = null;
        this.enI = 0L;
        this.enJ = false;
        this.enK = -1;
        this.enM = false;
        this.enT = new dl(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.enU = new dn(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.dqC = new Cdo(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.enV = null;
        registerListener(this.enT);
        registerListener(this.dqC);
        registerListener(this.enU);
        this.ens = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bcF = baseActivity;
        this.enO = new dq(this, this.bcF);
        this.enP = new dh(this, this.bcF);
        this.enQ = new cx(this, this.bcF);
        this.enR = new da(this, this.bcF);
        this.enS = new dd(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aLr() {
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
        this.enb = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.enb)) {
            this.enb = this.enO.R(intent);
        }
        this.enc = intent.getStringExtra("post_id");
        this.ene = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eng = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.alK = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dqs = intent.getIntExtra("is_top", 0);
        this.enh = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eno = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.enl = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.enq = intent.getBooleanExtra("is_pv", false);
        this.enp = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.enr = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.enz = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.eny = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.enu = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.env = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.enw = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.enB = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.enA = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.enm = intent.getBooleanExtra("from_frs", false);
        this.enn = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.enM = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.enb = bundle.getString("thread_id");
        this.enc = bundle.getString("post_id");
        this.ene = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eng = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.alK = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dqs = bundle.getInt("is_top", 0);
        this.enh = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eno = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.enl = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.enq = bundle.getBoolean("is_pv", false);
        this.enp = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.enr = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.enz = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.enu = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.env = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.enw = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.enB = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.enA = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.enm = bundle.getBoolean("from_frs", false);
        this.enn = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.enM = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
    }

    public void o(Bundle bundle) {
        bundle.putString("thread_id", this.enb);
        bundle.putString("post_id", this.enc);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.ene);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.eng);
        bundle.putString("st_type", this.alK);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dqs);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.enh);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.eno);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.enl);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.enq);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.enp);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.enz);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.enu);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.env);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.enw);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.enB);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.enA);
        bundle.putBoolean("from_frs", this.enm);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.enn);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.enM);
    }

    public String aLs() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.enb);
        if (!this.eno) {
            sb.append(this.enc);
        }
        sb.append(this.ene);
        sb.append(this.eng);
        sb.append(this.alK);
        sb.append(this.mIsGood);
        sb.append(this.dqs);
        sb.append(this.enh);
        sb.append(this.enm);
        sb.append(this.enn);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.enl);
        sb.append(this.enq);
        sb.append(this.enp);
        sb.append(this.enr);
        sb.append(this.mThreadType);
        sb.append(this.enu);
        sb.append(this.env);
        sb.append(this.enw);
        if (this.enz != null) {
            sb.append(this.enz);
        }
        return sb.toString();
    }

    public String aLt() {
        return this.enr;
    }

    public String getPostId() {
        return this.enc;
    }

    public void nt(String str) {
        this.enc = str;
    }

    public String getThreadID() {
        return this.enb;
    }

    public boolean getHostMode() {
        return this.ene;
    }

    public boolean aLu() {
        return this.eng;
    }

    public boolean aLv() {
        return this.enm;
    }

    public boolean aLw() {
        return this.enn;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aLx() {
        return "hot_topic".equals(this.alK);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int awF() {
        return this.dqs;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void gS(int i) {
        this.dqs = i;
    }

    public boolean aLy() {
        return this.enl;
    }

    public boolean aLz() {
        if (this.ens == null) {
            return false;
        }
        return this.ens.isValid();
    }

    public String rZ() {
        if (this.ens == null || !this.ens.nH()) {
            return null;
        }
        return this.ens.nG();
    }

    public boolean oj(int i) {
        this.eni = i;
        if (this.eni > this.ens.getPage().qL()) {
            this.eni = this.ens.getPage().qL();
        }
        if (this.eni < 1) {
            this.eni = 1;
        }
        if (this.enb == null) {
            return false;
        }
        return on(5);
    }

    public boolean ok(int i) {
        int sE = this.ens.aJq().sE();
        if (i <= sE) {
            sE = i;
        }
        int i2 = sE >= 1 ? sE : 1;
        if (this.enb == null) {
            return false;
        }
        this.enK = i2;
        return on(7);
    }

    public void ol(int i) {
        this.eni = i;
        this.enj = i;
        this.enk = i;
    }

    public void om(int i) {
        if (this.enj < i) {
            this.enj = i;
            if (this.enj - this.enk >= ena) {
                this.enk = (this.enj - ena) + 1;
            }
        }
        if (this.enk > i) {
            this.enk = i;
            if (this.enj - this.enk >= ena) {
                this.enj = (this.enk + ena) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.ens;
    }

    public com.baidu.tbadk.core.data.aq ama() {
        if (this.ens == null) {
            return null;
        }
        return this.ens.getPage();
    }

    public boolean aLA() {
        if (this.eng) {
            if (this.ens.getPage().qQ() == 0) {
                ip(true);
                return true;
            }
        } else if (this.ens.getPage().qR() == 0) {
            iq(true);
            return true;
        }
        return false;
    }

    public void nn(String str) {
        if (!StringUtils.isNull(str)) {
            this.enb = str;
            this.enc = null;
            this.ene = false;
            this.eng = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.enb == null) {
            return false;
        }
        cancelLoadData();
        if (this.bFr == null) {
            this.bFr = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bFr.start();
        }
        boolean on = on(3);
        if (this.opType != null) {
            this.opType = null;
            this.eny = null;
            this.opUrl = null;
            return on;
        }
        return on;
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
        VN();
    }

    private void VN() {
        if (this.bFr != null) {
            this.bFr.destory();
            this.bFr = null;
        }
    }

    public boolean Fe() {
        return (this.enc == null || this.enc.equals("0") || this.enc.length() == 0) ? LoadData() : aLD();
    }

    public boolean on(int i) {
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        oo(i);
        com.baidu.tieba.pb.data.f pbData = er.aMB().getPbData();
        if (pbData != null && pbData.aJq() != null) {
            pbData.aJq().bO(0);
            this.eng = er.aMB().aLu();
            this.ene = er.aMB().aMD();
            if (!this.eng || this.ene || this.isFromMark) {
                this.enC = false;
            }
            com.baidu.adp.lib.g.h.fM().post(new dp(this, pbData));
            return false;
        }
        if (i == 4 && !this.enG) {
            a(aLI(), true, this.enc, 3);
        }
        if (i == 3 && !this.enG) {
            if (this.isFromMark) {
                a(aLI(), true, this.enc, 3);
            } else {
                a(aLI(), false, this.enc, 3);
            }
        }
        this.enG = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.axK);
        if (!this.eng || this.ene || this.isFromMark) {
            this.enC = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.enb == null || this.enb.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.enb, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        int ah = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.av.vD().vF() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.eng) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.ene) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.alK != null) {
            pbPageRequestMessage.set_st_type(this.alK);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.enq) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.enp));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.enC) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eny, 0));
            pbPageRequestMessage.setOpMessageID(this.enp);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aJs = this.ens.aJs();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eng) {
                        if (this.enk - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.enk - 1));
                        }
                    } else if (this.enj < this.bxV) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.enj + 1));
                    }
                }
                if (aJs != null && aJs.size() > 0) {
                    int size = aJs.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        PostData postData = aJs.get(size - i3);
                        if (postData == null) {
                            i3++;
                        } else {
                            this.enc = postData.getId();
                            if (StringUtils.isNull(this.enc)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.enc != null && this.enc.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.enc, 0L));
                    break;
                } else if (!this.eng) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aJs != null && aJs.size() > 0 && aJs.get(0) != null) {
                    this.enc = aJs.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eng) {
                        if (this.enk - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.enk - 1));
                        }
                    } else if (this.enj < this.bxV) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.enj + 1));
                    }
                }
                if (this.enc != null && this.enc.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.enc, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eng) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.enc, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eni));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.enc, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.enK);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aLI());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bcF != null && (this.bcF instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bcF).aKh());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.enJ);
        pbPageRequestMessage.setFromSmartFrs(this.enM ? 1 : 0);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void oo(int i) {
        boolean z = false;
        ArrayList<PostData> aJs = this.ens.aJs();
        this.enF = false;
        if (i == 1) {
            boolean z2 = false;
            while (aJs.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aJs.remove(0);
                z2 = true;
            }
            if (z2) {
                this.ens.getPage().bK(1);
                if (this.enx != null) {
                    this.enx.c(this.ens);
                }
            }
            this.bZg = System.currentTimeMillis();
            this.enF = true;
        } else if (i == 2) {
            while (aJs.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aJs.remove(aJs.size() - 1);
                z = true;
            }
            if (z) {
                this.ens.getPage().bJ(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.enN = i2;
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
            if (this.enw || this.enu || this.env) {
                fVar = f(fVar);
            }
            e(fVar);
        }
    }

    protected void e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String g = g(fVar);
            for (int i = 0; i < fVar.aJs().size(); i++) {
                PostData postData = fVar.aJs().get(i);
                for (int i2 = 0; i2 < postData.bhA().size(); i2++) {
                    postData.bhA().get(i2).b(this.bcF.getPageContext(), g.equals(postData.bhA().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.f f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.bj aJq = fVar.aJq();
        aJq.bR(this.mIsGood);
        aJq.bQ(this.dqs);
        if (this.enh > 0) {
            aJq.m(this.enh);
            return fVar;
        }
        return fVar;
    }

    protected String g(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aJq() != null && fVar.aJq().getAuthor() != null) {
            str = fVar.aJq().getAuthor().getUserId();
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
        if (fVar.aJq() != null && fVar.aJq().getAuthor() != null) {
            str = fVar.aJq().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aLB() {
        if (this.ens == null || this.ens.aJq() == null || this.ens.aJq().getAuthor() == null) {
            return null;
        }
        return this.ens.aJq().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.enL = z3;
        this.ent = i;
        if (this.bFr != null && !z3) {
            this.bFr.a(z2, z4, i2, str, i3, j, j2);
            this.bFr = null;
        }
        if (fVar == null || (this.eni == 1 && i == 5 && fVar.aJs() != null && fVar.aJs().size() < 1)) {
            if (this.enx != null) {
                this.eng = this.enf;
                this.enx.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.enf = this.eng;
            this.enq = false;
            if (fVar.getPage() != null) {
                om(fVar.getPage().qO());
                this.bxV = fVar.getPage().qL();
            }
            this.bxV = this.bxV < 1 ? 1 : this.bxV;
            int i5 = 0;
            ArrayList<PostData> aJs = this.ens.aJs();
            switch (i) {
                case 1:
                    this.ens.a(fVar.getPage(), 1);
                    b(fVar, aJs);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aJs() != null) {
                        int size = fVar.aJs().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(aJs, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aJs(), com.baidu.tbadk.core.util.x.p(fVar.aJs()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aJs().remove(postData2);
                            i5 = size - 1;
                        }
                        aJs.addAll(0, fVar.aJs());
                    }
                    this.ens.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.eng && fVar.getPage() != null) {
                        fVar.getPage().bH(fVar.getPage().qL());
                    }
                    i(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eng) {
                        aLC();
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
            if (this.ens != null && this.ens.aJq() != null) {
                PraiseData rG = this.ens.aJq().rG();
                if (this.enV != null && !rG.isPriaseDataValid()) {
                    this.ens.aJq().a(this.enV);
                } else {
                    this.enV = this.ens.aJq().rG();
                    this.enV.setPostId(this.ens.aJq().sg());
                }
                if (fVar.getPage() != null && fVar.getPage().qO() == 1 && fVar.aJq() != null && fVar.aJq().sb() != null && fVar.aJq().sb().size() > 0) {
                    this.ens.aJq().h(fVar.aJq().sb());
                }
                this.ens.aJq().bP(fVar.aJq().rJ());
                this.ens.aJq().bN(fVar.aJq().getAnchorLevel());
                this.ens.aJq().bO(fVar.aJq().rE());
                if (this.mThreadType == 33) {
                    this.ens.aJq().getAuthor().setHadConcerned(fVar.aJq().getAuthor().hadConcerned());
                }
            }
            if (this.ens != null && this.ens.getUserData() != null && fVar.getUserData() != null) {
                this.ens.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.ens.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().qO() == 1 && fVar.aJz() != null) {
                this.ens.a(fVar.aJz());
            }
            if (this.enL && this.ens.aJq() != null && this.ens.aJq().getAuthor() != null && this.ens.aJs() != null && com.baidu.tbadk.core.util.x.c(this.ens.aJs(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.c(this.ens.aJs(), 0);
                MetaData author = this.ens.aJq().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.enA != -1) {
                        author.setFansNum(this.enA);
                        postData3.getAuthor().setFansNum(this.enA);
                    }
                    if (this.enB != -1) {
                        author.getGodUserData().setIsLike(this.enB == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.enB == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.ens != null && this.ens.aJn() != null && fVar.aJn() != null) {
                this.ens.aJn().k(fVar.aJn().getItems());
                this.ens.aJn().an(fVar.aJn().qx());
            }
            if (this.enx != null) {
                this.enx.a(true, getErrorCode(), i, i4, this.ens, this.mErrorString, 1);
            }
        }
        if (this.ens != null && this.ens.aJq() != null && this.ens.aJp() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bcF;
            historyMessage.threadId = getPbData().aJq().getId();
            historyMessage.forumName = getPbData().aJp().getName();
            historyMessage.threadName = getPbData().aJq().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aLu();
            historyMessage.threadType = getPbData().aJq().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void b(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ak;
        if (arrayList != null && fVar.aJs() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aJs(), 0);
            if (postData != null && (ak = ak(arrayList)) != null && ak.equals(postData.getId())) {
                fVar.aJs().remove(postData);
            }
            arrayList.addAll(fVar.aJs());
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
        fVar.nm(this.ens.aJG());
        this.ens = fVar;
        ol(fVar.getPage().qO());
    }

    private void aLC() {
        if (this.ens != null && this.ens.aJs() != null && this.ens.aJE() != null) {
            ArrayList<PostData> aJs = this.ens.aJs();
            com.baidu.tieba.pb.data.a aJE = this.ens.aJE();
            int aJg = aJE.aJg();
            if (aJg > 0) {
                if (aJg <= aJs.size()) {
                    aJs.add(aJg, aJE);
                } else {
                    aJs.add(aJE);
                }
            }
        }
    }

    public boolean aLD() {
        if (this.enb == null || this.enc == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return on(4);
        }
        return on(6);
    }

    public boolean ip(boolean z) {
        if (this.enb == null || this.ens == null) {
            return false;
        }
        if (z || this.ens.getPage().qQ() != 0) {
            return on(1);
        }
        return false;
    }

    public boolean iq(boolean z) {
        if (this.enb == null || this.ens == null) {
            return false;
        }
        if ((z || this.ens.getPage().qR() != 0) && this.ens.aJs() != null && this.ens.aJs().size() >= 1) {
            return on(2);
        }
        return false;
    }

    public boolean nu(String str) {
        this.ene = !this.ene;
        this.enc = str;
        on(6);
        return true;
    }

    public boolean aLE() {
        if (com.baidu.adp.lib.util.i.he()) {
            this.enf = this.eng;
            this.eng = !this.eng;
        }
        return LoadData();
    }

    public boolean aLF() {
        return this.eng;
    }

    public boolean hasData() {
        return (this.ens == null || this.ens.aJp() == null || this.ens.aJq() == null) ? false : true;
    }

    public boolean nH() {
        if (this.ens == null) {
            return false;
        }
        return this.ens.nH();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fn(String str) {
        if (this.ens == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.ens.aJp().getId());
        writeData.setForumName(this.ens.aJp().getName());
        writeData.setThreadId(this.enb);
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

    public MarkData op(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.ens == null || this.ens.aJs() == null) {
            return null;
        }
        ArrayList<PostData> aJs = this.ens.aJs();
        if (aJs.size() > 0 && i == aJs.size()) {
            i = aJs.size() - 1;
        }
        if (aJs.size() <= 0 || i >= aJs.size()) {
            return null;
        }
        return e(aJs.get(i));
    }

    public MarkData aLG() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.enb);
        markData.setPostId(this.ens.nG());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ene);
        markData.setSequence(Boolean.valueOf(this.eng));
        markData.setId(this.enb);
        return markData;
    }

    public MarkData e(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.enb);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ene);
        markData.setSequence(Boolean.valueOf(this.eng));
        markData.setId(this.enb);
        markData.setFloor(postData.bhD());
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.o) postData).isApp());
        }
        return markData;
    }

    public void aLH() {
        cw.aKZ().M(aLI(), this.isFromMark);
    }

    private String aLI() {
        String str = this.enb;
        if (this.ene) {
            str = String.valueOf(str) + DB_KEY_HOST;
        }
        if (!this.eng) {
            str = String.valueOf(str) + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void ir(boolean z) {
        if (this.ens != null) {
            this.ens.ac(z);
        }
    }

    public void is(boolean z) {
        this.enC = z;
    }

    public boolean aLJ() {
        return this.enC;
    }

    public void a(a aVar) {
        this.enx = aVar;
    }

    public void mx(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dl() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dk() {
        return Fe();
    }

    public boolean nv(String str) {
        if (getPbData() == null || getPbData().aJq() == null || getPbData().aJq().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aJq().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aLK() {
        return this.mRequestType;
    }

    public void aLL() {
        String aLI = aLI();
        cw.aKZ().M(aLI, false);
        cw.aKZ().M(aLI, true);
    }

    public void aLM() {
        if ("personalize_page".equals(this.alK)) {
            this.enI = System.currentTimeMillis() / 1000;
        }
    }

    public void aLN() {
        if ("personalize_page".equals(this.alK) && this.ens != null && this.enI != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10754").Z("fid", this.ens.getForumId()).Z("tid", this.enb).Z("obj_duration", String.valueOf(currentTimeMillis - this.enI)).Z("obj_param3", String.valueOf(currentTimeMillis)));
            this.enI = 0L;
        }
    }

    public boolean aLO() {
        return this.enL;
    }

    public int aLP() {
        return this.ent;
    }

    public int getErrorNo() {
        return this.enN;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public dh aLQ() {
        return this.enP;
    }

    public cx aLR() {
        return this.enQ;
    }

    public da aLS() {
        return this.enR;
    }

    public dd aLT() {
        return this.enS;
    }

    public String aLU() {
        return this.enH;
    }

    public void nw(String str) {
        this.enH = str;
    }

    public boolean aLV() {
        return this.enM;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.ens != null && this.ens.aJs() != null && this.ens.aJs().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.ens.aJs().size();
                for (int i = 0; i < size; i++) {
                    if (this.ens.aJs().get(i) != null && this.ens.aJs().get(i).getAuthor() != null && currentAccount.equals(this.ens.aJs().get(i).getAuthor().getUserId()) && this.ens.aJs().get(i).getAuthor().getPendantData() != null) {
                        this.ens.aJs().get(i).getAuthor().getPendantData().ck(jVar.qd());
                        this.ens.aJs().get(i).getAuthor().getPendantData().N(jVar.Cq());
                    }
                }
            }
        }
    }
}
