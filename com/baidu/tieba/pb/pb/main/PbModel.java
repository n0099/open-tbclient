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
    private BaseActivity aWr;
    private String agr;
    private long bRY;
    private int bqV;
    private com.baidu.tieba.tbadkCore.d.b byl;
    private int dnY;
    private com.baidu.adp.framework.listener.a doj;
    private a ekA;
    private String ekB;
    private String ekC;
    private int ekD;
    private int ekE;
    private boolean ekF;
    private boolean ekG;
    private boolean ekH;
    private boolean ekI;
    private boolean ekJ;
    private String ekK;
    private long ekL;
    private boolean ekM;
    private int ekN;
    private boolean ekO;
    private boolean ekP;
    private int ekQ;
    private final dp ekR;
    private final dg ekS;
    private final cy ekT;
    private final db ekU;
    private CustomMessageListener ekV;
    private CustomMessageListener ekW;
    private PraiseData ekX;
    protected String ekf;
    private String ekg;
    private boolean ekh;
    private boolean eki;
    private boolean ekj;
    private long ekk;
    private int ekl;
    private int ekm;
    private int ekn;
    private boolean eko;
    private boolean ekp;
    private boolean ekq;
    private boolean ekr;
    private long eks;
    private boolean ekt;
    private String eku;
    protected com.baidu.tieba.pb.data.f ekv;
    private int ekw;
    private boolean ekx;
    private boolean eky;
    private boolean ekz;
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
    private static final int eke = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.f fVar);
    }

    public void it(boolean z) {
        this.ekM = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.agr = null;
        this.ekf = null;
        this.ekg = null;
        this.ekh = false;
        this.eki = true;
        this.ekj = true;
        this.mIsGood = 0;
        this.dnY = 0;
        this.ekk = 0L;
        this.ekl = 1;
        this.ekm = 1;
        this.ekn = 1;
        this.bqV = 1;
        this.isAd = false;
        this.eko = false;
        this.ekp = false;
        this.ekq = false;
        this.isFromMark = false;
        this.ekr = false;
        this.eks = 0L;
        this.ekt = false;
        this.eku = null;
        this.ekv = null;
        this.isLoading = false;
        this.ekx = false;
        this.eky = false;
        this.ekz = false;
        this.mLocate = null;
        this.mContext = null;
        this.ekA = null;
        this.opType = null;
        this.opUrl = null;
        this.ekB = null;
        this.ekC = null;
        this.ekD = -1;
        this.ekE = -1;
        this.byl = null;
        this.ekG = false;
        this.ekH = false;
        this.postID = null;
        this.ekK = null;
        this.ekL = 0L;
        this.ekM = false;
        this.ekN = -1;
        this.ekP = false;
        this.ekV = new dk(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.ekW = new dm(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.doj = new dn(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.ekX = null;
        registerListener(this.ekV);
        registerListener(this.doj);
        registerListener(this.ekW);
        this.ekv = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aWr = baseActivity;
        this.ekR = new dp(this, this.aWr);
        this.ekS = new dg(this, this.aWr);
        this.ekT = new cy(this, this.aWr);
        this.ekU = new db(this, this.aWr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aLV() {
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
        this.ekf = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.ekf)) {
            this.ekf = this.ekR.v(intent);
        }
        this.ekg = intent.getStringExtra("post_id");
        this.ekh = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.ekj = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.agr = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dnY = intent.getIntExtra("is_top", 0);
        this.ekk = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.ekr = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eko = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.ekt = intent.getBooleanExtra("is_pv", false);
        this.eks = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eku = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.ekC = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.ekB = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.ekx = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eky = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.ekz = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.ekE = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.ekD = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.ekp = intent.getBooleanExtra("from_frs", false);
        this.ekq = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.ekP = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.ekf = bundle.getString("thread_id");
        this.ekg = bundle.getString("post_id");
        this.ekh = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.ekj = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.agr = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dnY = bundle.getInt("is_top", 0);
        this.ekk = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.ekr = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eko = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.ekt = bundle.getBoolean("is_pv", false);
        this.eks = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eku = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.ekC = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.ekx = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eky = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.ekz = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.ekE = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.ekD = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.ekp = bundle.getBoolean("from_frs", false);
        this.ekq = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.ekP = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
    }

    public void o(Bundle bundle) {
        bundle.putString("thread_id", this.ekf);
        bundle.putString("post_id", this.ekg);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.ekh);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.ekj);
        bundle.putString("st_type", this.agr);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dnY);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.ekk);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.ekr);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.eko);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.ekt);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.eks);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.ekC);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.ekx);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.eky);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.ekz);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.ekE);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.ekD);
        bundle.putBoolean("from_frs", this.ekp);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.ekq);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.ekP);
    }

    public String aLW() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.ekf);
        if (!this.ekr) {
            sb.append(this.ekg);
        }
        sb.append(this.ekh);
        sb.append(this.ekj);
        sb.append(this.agr);
        sb.append(this.mIsGood);
        sb.append(this.dnY);
        sb.append(this.ekk);
        sb.append(this.ekp);
        sb.append(this.ekq);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eko);
        sb.append(this.ekt);
        sb.append(this.eks);
        sb.append(this.eku);
        sb.append(this.mThreadType);
        sb.append(this.ekx);
        sb.append(this.eky);
        sb.append(this.ekz);
        if (this.ekC != null) {
            sb.append(this.ekC);
        }
        return sb.toString();
    }

    public String aLX() {
        return this.eku;
    }

    public String getPostId() {
        return this.ekg;
    }

    public void om(String str) {
        this.ekg = str;
    }

    public String getThreadID() {
        return this.ekf;
    }

    public boolean getHostMode() {
        return this.ekh;
    }

    public boolean aLY() {
        return this.ekj;
    }

    public boolean aLZ() {
        return this.ekp;
    }

    public boolean aMa() {
        return this.ekq;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aMb() {
        return "hot_topic".equals(this.agr);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int axj() {
        return this.dnY;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void gV(int i) {
        this.dnY = i;
    }

    public boolean aMc() {
        return this.eko;
    }

    public boolean aMd() {
        if (this.ekv == null) {
            return false;
        }
        return this.ekv.isValid();
    }

    public String rF() {
        if (this.ekv == null || !this.ekv.nt()) {
            return null;
        }
        return this.ekv.ns();
    }

    public boolean ov(int i) {
        this.ekl = i;
        if (this.ekl > this.ekv.getPage().qs()) {
            this.ekl = this.ekv.getPage().qs();
        }
        if (this.ekl < 1) {
            this.ekl = 1;
        }
        if (this.ekf == null) {
            return false;
        }
        return oz(5);
    }

    public boolean ow(int i) {
        int sj = this.ekv.aJZ().sj();
        if (i <= sj) {
            sj = i;
        }
        int i2 = sj >= 1 ? sj : 1;
        if (this.ekf == null) {
            return false;
        }
        this.ekN = i2;
        return oz(7);
    }

    public void ox(int i) {
        this.ekl = i;
        this.ekm = i;
        this.ekn = i;
    }

    public void oy(int i) {
        if (this.ekm < i) {
            this.ekm = i;
            if (this.ekm - this.ekn >= eke) {
                this.ekn = (this.ekm - eke) + 1;
            }
        }
        if (this.ekn > i) {
            this.ekn = i;
            if (this.ekm - this.ekn >= eke) {
                this.ekm = (this.ekn + eke) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.ekv;
    }

    public com.baidu.tbadk.core.data.ao amN() {
        if (this.ekv == null) {
            return null;
        }
        return this.ekv.getPage();
    }

    public boolean aMe() {
        if (this.ekj) {
            if (this.ekv.getPage().qx() == 0) {
                iu(true);
                return true;
            }
        } else if (this.ekv.getPage().qy() == 0) {
            iv(true);
            return true;
        }
        return false;
    }

    public void og(String str) {
        if (!StringUtils.isNull(str)) {
            this.ekf = str;
            this.ekg = null;
            this.ekh = false;
            this.ekj = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.ekf == null) {
            return false;
        }
        cancelLoadData();
        if (this.byl == null) {
            this.byl = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.byl.start();
        }
        boolean oz = oz(3);
        if (this.opType != null) {
            this.opType = null;
            this.ekB = null;
            this.opUrl = null;
            return oz;
        }
        return oz;
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
        UP();
    }

    private void UP() {
        if (this.byl != null) {
            this.byl.destory();
            this.byl = null;
        }
    }

    public boolean EH() {
        return (this.ekg == null || this.ekg.equals("0") || this.ekg.length() == 0) ? LoadData() : aMh();
    }

    public boolean oz(int i) {
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        oA(i);
        com.baidu.tieba.pb.data.f pbData = eq.aNi().getPbData();
        if (pbData != null && pbData.aJZ() != null) {
            pbData.aJZ().bT(0);
            this.ekj = eq.aNi().aLY();
            this.ekh = eq.aNi().aNk();
            if (!this.ekj || this.ekh || this.isFromMark) {
                this.ekF = false;
            }
            com.baidu.adp.lib.g.h.eE().post(new Cdo(this, pbData));
            return false;
        }
        if (i == 4 && !this.ekJ) {
            a(aMm(), true, this.ekg, 3);
        }
        if (i == 3 && !this.ekJ) {
            if (this.isFromMark) {
                a(aMm(), true, this.ekg, 3);
            } else {
                a(aMm(), false, this.ekg, 3);
            }
        }
        this.ekJ = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.asp);
        if (!this.ekj || this.ekh || this.isFromMark) {
            this.ekF = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.ekf == null || this.ekf.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.ekf, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int I = com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst().getApp());
        int J = com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.au.vg().vi() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(I));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(J));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.ekj) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.ekh) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.agr != null) {
            pbPageRequestMessage.set_st_type(this.agr);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.ekt) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eks));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.ekF) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.ekB, 0));
            pbPageRequestMessage.setOpMessageID(this.eks);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = this.ekv.aKb();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.ekj) {
                        if (this.ekn - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.ekn - 1));
                        }
                    } else if (this.ekm < this.bqV) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.ekm + 1));
                    }
                }
                if (aKb != null && aKb.size() > 0) {
                    int size = aKb.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.p pVar = aKb.get(size - i3);
                        if (pVar == null) {
                            i3++;
                        } else {
                            this.ekg = pVar.getId();
                            if (StringUtils.isNull(this.ekg)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.ekg != null && this.ekg.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ekg, 0L));
                    break;
                } else if (!this.ekj) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aKb != null && aKb.size() > 0 && aKb.get(0) != null) {
                    this.ekg = aKb.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.ekj) {
                        if (this.ekn - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.ekn - 1));
                        }
                    } else if (this.ekm < this.bqV) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.ekm + 1));
                    }
                }
                if (this.ekg != null && this.ekg.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ekg, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.ekj) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ekg, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.ekl));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ekg, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.ekN);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aMm());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.aWr != null && (this.aWr instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.aWr).aKM());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.ekM);
        pbPageRequestMessage.setFromSmartFrs(this.ekP ? 1 : 0);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void oA(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = this.ekv.aKb();
        this.ekI = false;
        if (i == 1) {
            boolean z2 = false;
            while (aKb.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aKb.remove(0);
                z2 = true;
            }
            if (z2) {
                this.ekv.getPage().bP(1);
                if (this.ekA != null) {
                    this.ekA.c(this.ekv);
                }
            }
            this.bRY = System.currentTimeMillis();
            this.ekI = true;
        } else if (i == 2) {
            while (aKb.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aKb.remove(aKb.size() - 1);
                z = true;
            }
            if (z) {
                this.ekv.getPage().bO(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.ekQ = i2;
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
            if (this.ekz || this.ekx || this.eky) {
                fVar = f(fVar);
            }
            e(fVar);
        }
    }

    protected void e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String g = g(fVar);
            for (int i = 0; i < fVar.aKb().size(); i++) {
                com.baidu.tieba.tbadkCore.data.p pVar = fVar.aKb().get(i);
                for (int i2 = 0; i2 < pVar.bhN().size(); i2++) {
                    pVar.bhN().get(i2).b(this.aWr.getPageContext(), g.equals(pVar.bhN().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.f f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.bh aJZ = fVar.aJZ();
        aJZ.bW(this.mIsGood);
        aJZ.bV(this.dnY);
        if (this.ekk > 0) {
            aJZ.n(this.ekk);
            return fVar;
        }
        return fVar;
    }

    protected String g(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aJZ() != null && fVar.aJZ().getAuthor() != null) {
            str = fVar.aJZ().getAuthor().getUserId();
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
        if (fVar.aJZ() != null && fVar.aJZ().getAuthor() != null) {
            str = fVar.aJZ().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aMf() {
        if (this.ekv == null || this.ekv.aJZ() == null || this.ekv.aJZ().getAuthor() == null) {
            return null;
        }
        return this.ekv.aJZ().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.ekO = z3;
        this.ekw = i;
        if (this.byl != null && !z3) {
            this.byl.a(z2, z4, i2, str, i3, j, j2);
            this.byl = null;
        }
        if (fVar == null || (this.ekl == 1 && i == 5 && fVar.aKb() != null && fVar.aKb().size() < 1)) {
            if (this.ekA != null) {
                this.ekj = this.eki;
                this.ekA.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eki = this.ekj;
            this.ekt = false;
            if (fVar.getPage() != null) {
                oy(fVar.getPage().qv());
                this.bqV = fVar.getPage().qs();
            }
            this.bqV = this.bqV < 1 ? 1 : this.bqV;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = this.ekv.aKb();
            switch (i) {
                case 1:
                    this.ekv.a(fVar.getPage(), 1);
                    b(fVar, aKb);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aKb() != null) {
                        int size = fVar.aKb().size() + 1;
                        com.baidu.tieba.tbadkCore.data.p pVar = (com.baidu.tieba.tbadkCore.data.p) com.baidu.tbadk.core.util.w.c(aKb, 0);
                        com.baidu.tieba.tbadkCore.data.p pVar2 = (com.baidu.tieba.tbadkCore.data.p) com.baidu.tbadk.core.util.w.c(fVar.aKb(), com.baidu.tbadk.core.util.w.r(fVar.aKb()) - 1);
                        if (pVar == null || pVar2 == null || !pVar.getId().equals(pVar2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aKb().remove(pVar2);
                            i5 = size - 1;
                        }
                        aKb.addAll(0, fVar.aKb());
                    }
                    this.ekv.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.ekj && fVar.getPage() != null) {
                        fVar.getPage().bM(fVar.getPage().qs());
                    }
                    i(fVar);
                    if (!z3 && this.mThreadType != 33 && this.ekj) {
                        aMg();
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
            if (this.ekv != null && this.ekv.aJZ() != null) {
                PraiseData rn = this.ekv.aJZ().rn();
                if (this.ekX != null && !rn.isPriaseDataValid()) {
                    this.ekv.aJZ().a(this.ekX);
                } else {
                    this.ekX = this.ekv.aJZ().rn();
                    this.ekX.setPostId(this.ekv.aJZ().rM());
                }
                if (fVar.getPage() != null && fVar.getPage().qv() == 1 && fVar.aJZ() != null && fVar.aJZ().rH() != null && fVar.aJZ().rH().size() > 0) {
                    this.ekv.aJZ().i(fVar.aJZ().rH());
                }
                this.ekv.aJZ().bU(fVar.aJZ().rp());
                this.ekv.aJZ().bS(fVar.aJZ().getAnchorLevel());
                this.ekv.aJZ().bT(fVar.aJZ().rl());
                if (this.mThreadType == 33) {
                    this.ekv.aJZ().getAuthor().setHadConcerned(fVar.aJZ().getAuthor().hadConcerned());
                }
            }
            if (this.ekv != null && this.ekv.getUserData() != null && fVar.getUserData() != null) {
                this.ekv.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.ekv.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().qv() == 1 && fVar.aKi() != null) {
                this.ekv.a(fVar.aKi());
            }
            if (this.ekO && this.ekv.aJZ() != null && this.ekv.aJZ().getAuthor() != null && this.ekv.aKb() != null && com.baidu.tbadk.core.util.w.c(this.ekv.aKb(), 0) != null) {
                com.baidu.tieba.tbadkCore.data.p pVar3 = (com.baidu.tieba.tbadkCore.data.p) com.baidu.tbadk.core.util.w.c(this.ekv.aKb(), 0);
                MetaData author = this.ekv.aJZ().getAuthor();
                if (pVar3.getAuthor() != null && pVar3.getAuthor().getGodUserData() != null) {
                    if (this.ekD != -1) {
                        author.setFansNum(this.ekD);
                        pVar3.getAuthor().setFansNum(this.ekD);
                    }
                    if (this.ekE != -1) {
                        author.getGodUserData().setIsLike(this.ekE == 1);
                        pVar3.getAuthor().getGodUserData().setIsLike(this.ekE == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        pVar3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.ekv != null && this.ekv.aJW() != null && fVar.aJW() != null) {
                this.ekv.aJW().m(fVar.aJW().getItems());
                this.ekv.aJW().ao(fVar.aJW().qf());
            }
            if (this.ekA != null) {
                this.ekA.a(true, getErrorCode(), i, i4, this.ekv, this.mErrorString, 1);
            }
        }
        if (this.ekv != null && this.ekv.aJZ() != null && this.ekv.aJY() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.aWr;
            historyMessage.threadId = getPbData().aJZ().getId();
            historyMessage.forumName = getPbData().aJY().getName();
            historyMessage.threadName = getPbData().aJZ().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aLY();
            historyMessage.threadType = getPbData().aJZ().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.tieba.tbadkCore.data.p> arrayList) {
        String ak;
        if (arrayList != null && fVar.aKb() != null) {
            com.baidu.tieba.tbadkCore.data.p pVar = (com.baidu.tieba.tbadkCore.data.p) com.baidu.tbadk.core.util.w.c(fVar.aKb(), 0);
            if (pVar != null && (ak = ak(arrayList)) != null && ak.equals(pVar.getId())) {
                fVar.aKb().remove(pVar);
            }
            arrayList.addAll(fVar.aKb());
        }
    }

    private String ak(ArrayList<com.baidu.tieba.tbadkCore.data.p> arrayList) {
        int r = com.baidu.tbadk.core.util.w.r(arrayList);
        if (r <= 0) {
            return null;
        }
        for (int i = r - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.p pVar = (com.baidu.tieba.tbadkCore.data.p) com.baidu.tbadk.core.util.w.c(arrayList, i);
            if (pVar != null && !StringUtils.isNull(pVar.getId())) {
                return pVar.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tieba.pb.data.f fVar) {
        fVar.oe(this.ekv.aKp());
        this.ekv = fVar;
        ox(fVar.getPage().qv());
    }

    private void aMg() {
        if (this.ekv != null && this.ekv.aKb() != null && this.ekv.aKn() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = this.ekv.aKb();
            com.baidu.tieba.pb.data.a aKn = this.ekv.aKn();
            int aJP = aKn.aJP();
            if (aJP > 0) {
                if (aJP <= aKb.size()) {
                    aKb.add(aJP, aKn);
                } else {
                    aKb.add(aKn);
                }
            }
        }
    }

    public boolean aMh() {
        if (this.ekf == null || this.ekg == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return oz(4);
        }
        return oz(6);
    }

    public boolean iu(boolean z) {
        if (this.ekf == null || this.ekv == null) {
            return false;
        }
        if (z || this.ekv.getPage().qx() != 0) {
            return oz(1);
        }
        return false;
    }

    public boolean iv(boolean z) {
        if (this.ekf == null || this.ekv == null) {
            return false;
        }
        if ((z || this.ekv.getPage().qy() != 0) && this.ekv.aKb() != null && this.ekv.aKb().size() >= 1) {
            return oz(2);
        }
        return false;
    }

    public boolean on(String str) {
        this.ekh = !this.ekh;
        this.ekg = str;
        oz(6);
        return true;
    }

    public boolean aMi() {
        if (com.baidu.adp.lib.util.i.gk()) {
            this.eki = this.ekj;
            this.ekj = !this.ekj;
        }
        return LoadData();
    }

    public boolean aMj() {
        return this.ekj;
    }

    public boolean hasData() {
        return (this.ekv == null || this.ekv.aJY() == null || this.ekv.aJZ() == null) ? false : true;
    }

    public boolean nt() {
        if (this.ekv == null) {
            return false;
        }
        return this.ekv.nt();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fy(String str) {
        if (this.ekv == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.ekv.aJY().getId());
        writeData.setForumName(this.ekv.aJY().getName());
        writeData.setThreadId(this.ekf);
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

    public MarkData oB(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.ekv == null || this.ekv.aKb() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = this.ekv.aKb();
        if (aKb.size() > 0 && i == aKb.size()) {
            i = aKb.size() - 1;
        }
        if (aKb.size() <= 0 || i >= aKb.size()) {
            return null;
        }
        return e(aKb.get(i));
    }

    public MarkData aMk() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ekf);
        markData.setPostId(this.ekv.ns());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ekh);
        markData.setSequence(Boolean.valueOf(this.ekj));
        markData.setId(this.ekf);
        return markData;
    }

    public MarkData e(com.baidu.tieba.tbadkCore.data.p pVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ekf);
        markData.setPostId(pVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ekh);
        markData.setSequence(Boolean.valueOf(this.ekj));
        markData.setId(this.ekf);
        markData.setFloor(pVar.bhQ());
        if (pVar instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (pVar instanceof com.baidu.tieba.tbadkCore.data.o) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.o) pVar).isApp());
        }
        return markData;
    }

    public void aMl() {
        cx.aLE().L(aMm(), this.isFromMark);
    }

    private String aMm() {
        String str = this.ekf;
        if (this.ekh) {
            str = String.valueOf(str) + DB_KEY_HOST;
        }
        if (!this.ekj) {
            str = String.valueOf(str) + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void iw(boolean z) {
        if (this.ekv != null) {
            this.ekv.ad(z);
        }
    }

    public void ix(boolean z) {
        this.ekF = z;
    }

    public boolean aMn() {
        return this.ekF;
    }

    public void a(a aVar) {
        this.ekA = aVar;
    }

    public void mV(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CS() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CR() {
        return EH();
    }

    public boolean oo(String str) {
        if (getPbData() == null || getPbData().aJZ() == null || getPbData().aJZ().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aJZ().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aMo() {
        return this.mRequestType;
    }

    public void aMp() {
        String aMm = aMm();
        cx.aLE().L(aMm, false);
        cx.aLE().L(aMm, true);
    }

    public void aMq() {
        if ("personalize_page".equals(this.agr)) {
            this.ekL = System.currentTimeMillis() / 1000;
        }
    }

    public void aMr() {
        if ("personalize_page".equals(this.agr) && this.ekv != null && this.ekL != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10754").ab("fid", this.ekv.getForumId()).ab("tid", this.ekf).ab("obj_duration", String.valueOf(currentTimeMillis - this.ekL)).ab("obj_param3", String.valueOf(currentTimeMillis)));
            this.ekL = 0L;
        }
    }

    public boolean aMs() {
        return this.ekO;
    }

    public int aMt() {
        return this.ekw;
    }

    public int getErrorNo() {
        return this.ekQ;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public dg aMu() {
        return this.ekS;
    }

    public cy aMv() {
        return this.ekT;
    }

    public db aMw() {
        return this.ekU;
    }

    public String aMx() {
        return this.ekK;
    }

    public void op(String str) {
        this.ekK = str;
    }

    public boolean aMy() {
        return this.ekP;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.ekv != null && this.ekv.aKb() != null && this.ekv.aKb().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.ekv.aKb().size();
                for (int i = 0; i < size; i++) {
                    if (this.ekv.aKb().get(i) != null && this.ekv.aKb().get(i).getAuthor() != null && currentAccount.equals(this.ekv.aKb().get(i).getAuthor().getUserId()) && this.ekv.aKb().get(i).getAuthor().getPendantData() != null) {
                        this.ekv.aKb().get(i).getAuthor().getPendantData().cq(jVar.pL());
                        this.ekv.aKb().get(i).getAuthor().getPendantData().N(jVar.BX());
                    }
                }
            }
        }
    }
}
