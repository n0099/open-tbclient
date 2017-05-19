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
    private int bAg;
    private com.baidu.tieba.tbadkCore.d.b bHm;
    private long bXM;
    private BaseActivity bdY;
    private boolean dAg;
    private int dlm;
    private com.baidu.adp.framework.listener.a dlw;
    private boolean ejA;
    private long ejB;
    private int ejC;
    private int ejD;
    private int ejE;
    private boolean ejF;
    private boolean ejG;
    private boolean ejH;
    private long ejI;
    private boolean ejJ;
    private String ejK;
    protected com.baidu.tieba.pb.data.f ejL;
    private int ejM;
    private boolean ejN;
    private boolean ejO;
    private boolean ejP;
    private boolean ejQ;
    private a ejR;
    private String ejS;
    private String ejT;
    private int ejU;
    private int ejV;
    private boolean ejW;
    private boolean ejX;
    private boolean ejY;
    private boolean ejZ;
    protected String ejv;
    private String ejw;
    private boolean ejx;
    private boolean ejy;
    private boolean ejz;
    private boolean eka;
    private String ekb;
    private long ekc;
    private boolean ekd;
    private int eke;
    private boolean ekf;
    private boolean ekg;
    private int ekh;
    private final eb eki;
    private final dt ekj;
    private final da ekk;
    private final di ekl;
    private final dp ekm;
    private final ee ekn;
    private String eko;
    private boolean ekp;
    private int ekq;
    private CustomMessageListener ekr;
    private CustomMessageListener eks;
    private PraiseData ekt;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private com.baidu.tieba.pb.data.e mAppealInfo;
    protected Context mContext;
    private String mForumId;
    private int mIsGood;
    private String mLocate;
    private int mRequestType;
    public String mStType;
    protected int mThreadType;
    private String opType;
    private String opUrl;
    private String postID;
    private static final int eju = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.f fVar);
    }

    public void ib(boolean z) {
        this.ekd = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.ejv = null;
        this.ejw = null;
        this.mForumId = null;
        this.ejx = false;
        this.ejy = false;
        this.ejz = true;
        this.ejA = true;
        this.mIsGood = 0;
        this.dlm = 0;
        this.ejB = 0L;
        this.ejC = 1;
        this.ejD = 1;
        this.ejE = 1;
        this.bAg = 1;
        this.isAd = false;
        this.ejF = false;
        this.ejG = false;
        this.dAg = false;
        this.isFromMark = false;
        this.ejH = false;
        this.ejI = 0L;
        this.ejJ = false;
        this.ejK = null;
        this.ejL = null;
        this.isLoading = false;
        this.ejN = false;
        this.ejO = false;
        this.ejP = false;
        this.ejQ = false;
        this.mLocate = null;
        this.mContext = null;
        this.ejR = null;
        this.opType = null;
        this.opUrl = null;
        this.ejS = null;
        this.ejT = null;
        this.ejU = -1;
        this.ejV = -1;
        this.bHm = null;
        this.ejX = false;
        this.ejY = false;
        this.postID = null;
        this.ekb = null;
        this.ekc = 0L;
        this.ekd = false;
        this.eke = -1;
        this.ekg = false;
        this.ekp = false;
        this.ekq = 0;
        this.ekr = new dw(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.eks = new dy(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.dlw = new dz(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.ekt = null;
        registerListener(this.ekr);
        registerListener(this.dlw);
        registerListener(this.eks);
        this.ejL = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bdY = baseActivity;
        this.eki = new eb(this, this.bdY);
        this.ekj = new dt(this, this.bdY);
        this.ekk = new da(this, this.bdY);
        this.ekl = new di(this, this.bdY);
        this.ekm = new dp(this);
        this.ekn = new ee(this, this.bdY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aJQ() {
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
        this.ejv = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.ejv)) {
            this.ejv = this.eki.U(intent);
        }
        this.ekq = intent.getIntExtra(PbActivityConfig.KEY_START_FROM, 0);
        this.ejw = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.ejx = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.ejy = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.ejA = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dlm = intent.getIntExtra("is_top", 0);
        this.ejB = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.ejH = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.ejF = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.ejJ = intent.getBooleanExtra("is_pv", false);
        this.ejI = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.ejK = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.ejT = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.ejS = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.ejN = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.ejO = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.ejP = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.ejV = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.ejU = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.ejG = intent.getBooleanExtra("from_frs", false);
        this.dAg = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.ekg = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.ejQ = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
        this.eko = intent.getStringExtra(PbActivityConfig.KEY_POST_THREAD_TIP);
    }

    public void initWithBundle(Bundle bundle) {
        this.ekq = bundle.getInt(PbActivityConfig.KEY_START_FROM, 0);
        this.ejv = bundle.getString("thread_id");
        this.ejw = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.ejx = bundle.getBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.ejy = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.ejA = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dlm = bundle.getInt("is_top", 0);
        this.ejB = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.ejH = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.ejF = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.ejJ = bundle.getBoolean("is_pv", false);
        this.ejI = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.ejK = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.ejT = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.ejN = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.ejO = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.ejP = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.ejV = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.ejU = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.ejG = bundle.getBoolean("from_frs", false);
        this.dAg = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.ekg = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.ejQ = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void p(Bundle bundle) {
        bundle.putString("thread_id", this.ejv);
        bundle.putString("post_id", this.ejw);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt(PbActivityConfig.KEY_START_FROM, this.ekq);
        bundle.putBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, this.ejx);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.ejy);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.ejA);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dlm);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.ejB);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.ejH);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.ejF);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.ejJ);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.ejI);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.ejT);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.ejN);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.ejO);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.ejP);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.ejV);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.ejU);
        bundle.putBoolean("from_frs", this.ejG);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.dAg);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.ekg);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.ejQ);
    }

    public String aJR() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.ejv);
        if (!this.ejH) {
            sb.append(this.ejw);
        }
        sb.append(this.ejy);
        sb.append(this.ejA);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.dlm);
        sb.append(this.ejB);
        sb.append(this.ejG);
        sb.append(this.dAg);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.ejF);
        sb.append(this.ejJ);
        sb.append(this.ejI);
        sb.append(this.ejK);
        sb.append(this.mThreadType);
        sb.append(this.ejN);
        sb.append(this.ejO);
        sb.append(this.ejP);
        if (this.ejT != null) {
            sb.append(this.ejT);
        }
        return sb.toString();
    }

    public String aJS() {
        return this.ejK;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.ejw;
    }

    public void nH(String str) {
        this.ejw = str;
    }

    public String getThreadID() {
        return this.ejv;
    }

    public boolean getHostMode() {
        return this.ejy;
    }

    public boolean aJT() {
        return this.ejA;
    }

    public boolean aJU() {
        return this.ejG;
    }

    public boolean aJV() {
        return this.dAg;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aJW() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int auv() {
        return this.dlm;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void gX(int i) {
        this.dlm = i;
    }

    public boolean aJX() {
        return this.ejF;
    }

    public boolean aJY() {
        if (this.ejL == null) {
            return false;
        }
        return this.ejL.isValid();
    }

    public String rH() {
        if (this.ejL == null || !this.ejL.nL()) {
            return null;
        }
        return this.ejL.nK();
    }

    public boolean of(int i) {
        this.ejC = i;
        if (this.ejC > this.ejL.qB().qs()) {
            this.ejC = this.ejL.qB().qs();
        }
        if (this.ejC < 1) {
            this.ejC = 1;
        }
        if (this.ejv == null) {
            return false;
        }
        return oj(5);
    }

    public boolean og(int i) {
        int sm = this.ejL.aHG().sm();
        if (i <= sm) {
            sm = i;
        }
        int i2 = sm >= 1 ? sm : 1;
        if (this.ejv == null) {
            return false;
        }
        this.eke = i2;
        return oj(7);
    }

    public void oh(int i) {
        this.ejC = i;
        this.ejD = i;
        this.ejE = i;
    }

    public void oi(int i) {
        if (this.ejD < i) {
            this.ejD = i;
            if (this.ejD - this.ejE >= eju) {
                this.ejE = (this.ejD - eju) + 1;
            }
        }
        if (this.ejE > i) {
            this.ejE = i;
            if (this.ejD - this.ejE >= eju) {
                this.ejD = (this.ejE + eju) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.ejL;
    }

    public com.baidu.tbadk.core.data.aq ajK() {
        if (this.ejL == null) {
            return null;
        }
        return this.ejL.qB();
    }

    public boolean aJZ() {
        if (this.ejA && this.ejL.qB().qx() == 0) {
            ic(true);
            return true;
        }
        return false;
    }

    public void nB(String str) {
        if (!StringUtils.isNull(str)) {
            this.ejv = str;
            this.ejw = null;
            this.ejy = false;
            this.ejA = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.ejv == null) {
            return false;
        }
        cancelLoadData();
        if (this.bHm == null) {
            this.bHm = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bHm.start();
        }
        boolean oj = oj(3);
        if (this.opType != null) {
            this.opType = null;
            this.ejS = null;
            this.opUrl = null;
            return oj;
        }
        return oj;
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
        WC();
    }

    private void WC() {
        if (this.bHm != null) {
            this.bHm.destory();
            this.bHm = null;
        }
    }

    public boolean EG() {
        return (this.ejw == null || this.ejw.equals("0") || this.ejw.length() == 0) ? LoadData() : aKc();
    }

    public boolean oj(int i) {
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        ok(i);
        com.baidu.tieba.pb.data.f pbData = ex.aLb().getPbData();
        if (pbData != null && pbData.aHG() != null) {
            pbData.aHG().bO(0);
            this.ejA = ex.aLb().aJT();
            this.ejy = ex.aLb().aLd();
            this.ekp = this.ejy;
            if (this.ejy || this.isFromMark) {
                this.ejW = false;
            }
            com.baidu.adp.lib.g.h.fS().post(new ea(this, pbData));
            return false;
        }
        if (i == 4 && !this.eka) {
            a(aKh(), true, this.ejw, 3);
        }
        if (i == 3 && !this.eka) {
            if (this.isFromMark) {
                a(aKh(), true, this.ejw, 3);
            } else {
                a(aKh(), false, this.ejw, 3);
            }
        }
        this.eka = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.axZ);
        if (this.ejy || this.isFromMark) {
            this.ejW = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.ejv == null || this.ejv.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.ejv, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.av.vo().vq() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.ejA) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.ejy) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.ejJ) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.ejI));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.ejW) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.ejS, 0));
            pbPageRequestMessage.setOpMessageID(this.ejI);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aHI = this.ejL.aHI();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.ejA) {
                        if (this.ejE - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.ejE - 1));
                        }
                    } else if (this.ejD < this.bAg) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.ejD + 1));
                    }
                }
                if (aHI != null && aHI.size() > 0) {
                    int size = aHI.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        PostData postData = aHI.get(size - i3);
                        if (postData == null) {
                            i3++;
                        } else {
                            this.ejw = postData.getId();
                            if (StringUtils.isNull(this.ejw)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.ejw != null && this.ejw.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ejw, 0L));
                    break;
                } else if (!this.ejA) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aHI != null && aHI.size() > 0 && aHI.get(0) != null) {
                    this.ejw = aHI.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.ejA) {
                        if (this.ejE - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.ejE - 1));
                        }
                    } else if (this.ejD < this.bAg) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.ejD + 1));
                    }
                }
                if (this.ejw != null && this.ejw.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ejw, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.ejA) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ejw, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.ejC));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.ejA && this.ekp && !this.ejy) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ejw, 0L));
                }
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eke);
                break;
        }
        this.ekp = this.ejy;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aKh());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bdY != null && (this.bdY instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bdY).aIK());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.ekd);
        pbPageRequestMessage.setFromSmartFrs(this.ekg ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.ejx);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void ok(int i) {
        boolean z = false;
        ArrayList<PostData> aHI = this.ejL.aHI();
        this.ejZ = false;
        if (i == 1) {
            boolean z2 = false;
            while (aHI.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aHI.remove(0);
                z2 = true;
            }
            if (z2) {
                this.ejL.qB().bK(1);
                if (this.ejR != null) {
                    this.ejR.c(this.ejL);
                }
            }
            this.bXM = System.currentTimeMillis();
            this.ejZ = true;
        } else if (i == 2) {
            while (aHI.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aHI.remove(aHI.size() - 1);
                z = true;
            }
            if (z) {
                this.ejL.qB().bJ(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.ekh = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            e(fVar2);
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
    public void e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            if (this.ejP || this.ejN || this.ejO) {
                fVar = g(fVar);
            }
            f(fVar);
        }
    }

    protected void f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String h = h(fVar);
            for (int i = 0; i < fVar.aHI().size(); i++) {
                PostData postData = fVar.aHI().get(i);
                for (int i2 = 0; i2 < postData.bgJ().size(); i2++) {
                    postData.bgJ().get(i2).a(this.bdY.getPageContext(), h.equals(postData.bgJ().get(i2).getAuthor().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.m aHQ = fVar.aHQ();
            if (aHQ != null && !com.baidu.tbadk.core.util.x.r(aHQ.edU)) {
                for (PostData postData2 : aHQ.edU) {
                    for (int i3 = 0; i3 < postData2.bgJ().size(); i3++) {
                        postData2.bgJ().get(i3).a(this.bdY.getPageContext(), h.equals(postData2.bgJ().get(i3).getAuthor().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String h = h(fVar);
            com.baidu.tieba.pb.data.m aHQ = fVar.aHQ();
            if (aHQ != null && !com.baidu.tbadk.core.util.x.r(aHQ.edU)) {
                for (PostData postData : aHQ.edU.subList(i, aHQ.edU.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bgJ().size()) {
                            postData.bgJ().get(i3).a(this.bdY.getPageContext(), h.equals(postData.bgJ().get(i3).getAuthor().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.f g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.bk aHG = fVar.aHG();
        aHG.bS(this.mIsGood);
        aHG.bR(this.dlm);
        if (this.ejB > 0) {
            aHG.m(this.ejB);
            return fVar;
        }
        return fVar;
    }

    protected String h(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aHG() != null && fVar.aHG().getAuthor() != null) {
            str = fVar.aHG().getAuthor().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String i(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aHG() != null && fVar.aHG().getAuthor() != null) {
            str = fVar.aHG().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aKa() {
        if (this.ejL == null || this.ejL.aHG() == null || this.ejL.aHG().getAuthor() == null) {
            return null;
        }
        return this.ejL.aHG().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.ekf = z3;
        this.ejM = i;
        if (this.bHm != null && !z3) {
            this.bHm.a(z2, z4, i2, str, i3, j, j2);
            this.bHm = null;
        }
        if (fVar == null || (this.ejC == 1 && i == 5 && fVar.aHI() != null && fVar.aHI().size() < 1)) {
            if (this.ejR != null) {
                this.ejA = this.ejz;
                this.ejR.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.ejz = this.ejA;
            this.ejJ = false;
            if (fVar.qB() != null) {
                oi(fVar.qB().qv());
                this.bAg = fVar.qB().qs();
            }
            this.bAg = this.bAg < 1 ? 1 : this.bAg;
            int i5 = 0;
            ArrayList<PostData> aHI = this.ejL.aHI();
            switch (i) {
                case 1:
                    this.ejL.a(fVar.qB(), 1);
                    d(fVar, aHI);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aHI() != null) {
                        int size = fVar.aHI().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(aHI, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aHI(), com.baidu.tbadk.core.util.x.q(fVar.aHI()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aHI().remove(postData2);
                            i5 = size - 1;
                        }
                        aHI.addAll(0, fVar.aHI());
                    }
                    this.ejL.a(fVar.qB(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.ejA && fVar.qB() != null) {
                        fVar.qB().bH(fVar.qB().qs());
                    }
                    j(fVar);
                    if (!z3 && this.mThreadType != 33 && this.ejA) {
                        aKb();
                        i4 = 0;
                        break;
                    }
                    i4 = 0;
                    break;
                case 4:
                    j(fVar);
                    i4 = 0;
                    break;
                case 5:
                    j(fVar);
                    i4 = 0;
                    break;
                case 6:
                    j(fVar);
                    i4 = 0;
                    break;
                case 7:
                    j(fVar);
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.ejL != null && this.ejL.aHG() != null) {
                PraiseData ro = this.ejL.aHG().ro();
                if (this.ekt != null && !ro.isPriaseDataValid()) {
                    this.ejL.aHG().a(this.ekt);
                } else {
                    this.ekt = this.ejL.aHG().ro();
                    this.ekt.setPostId(this.ejL.aHG().rO());
                }
                if (fVar.qB() != null && fVar.qB().qv() == 1 && fVar.aHG() != null && fVar.aHG().rJ() != null && fVar.aHG().rJ().size() > 0) {
                    this.ejL.aHG().h(fVar.aHG().rJ());
                }
                this.ejL.aHG().bP(fVar.aHG().rr());
                this.ejL.aHG().bN(fVar.aHG().getAnchorLevel());
                this.ejL.aHG().bO(fVar.aHG().rm());
                if (this.mThreadType == 33) {
                    this.ejL.aHG().getAuthor().setHadConcerned(fVar.aHG().getAuthor().hadConcerned());
                }
            }
            if (this.ejL != null && this.ejL.getUserData() != null && fVar.getUserData() != null) {
                this.ejL.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.ejL.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qB() != null && fVar.qB().qv() == 1 && fVar.aHP() != null) {
                this.ejL.c(fVar.aHP());
            }
            if (this.ekf && this.ejL.aHG() != null && this.ejL.aHG().getAuthor() != null && this.ejL.aHI() != null && com.baidu.tbadk.core.util.x.c(this.ejL.aHI(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.c(this.ejL.aHI(), 0);
                MetaData author = this.ejL.aHG().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.ejU != -1) {
                        author.setFansNum(this.ejU);
                        postData3.getAuthor().setFansNum(this.ejU);
                    }
                    if (this.ejV != -1) {
                        author.getGodUserData().setIsLike(this.ejV == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.ejV == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.ejL != null && this.ejL.aHC() != null && fVar.aHC() != null) {
                this.ejL.aHC().k(fVar.aHC().getItems());
                this.ejL.aHC().ao(fVar.aHC().qg());
            }
            if (this.ejR != null) {
                this.ejR.a(true, getErrorCode(), i, i4, this.ejL, this.mErrorString, 1);
            }
        }
        if (this.ejL != null && this.ejL.aHG() != null && this.ejL.aHE() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bdY;
            historyMessage.threadId = getPbData().aHG().getId();
            historyMessage.forumName = getPbData().aHE().getName();
            historyMessage.threadName = getPbData().aHG().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aJT();
            historyMessage.threadType = getPbData().aHG().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aj;
        if (arrayList != null && fVar.aHI() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aHI(), 0);
            if (postData != null && (aj = aj(arrayList)) != null && aj.equals(postData.getId())) {
                fVar.aHI().remove(postData);
            }
            arrayList.addAll(fVar.aHI());
        }
    }

    private String aj(ArrayList<PostData> arrayList) {
        int q = com.baidu.tbadk.core.util.x.q(arrayList);
        if (q <= 0) {
            return null;
        }
        for (int i = q - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.baidu.tieba.pb.data.f fVar) {
        fVar.nz(this.ejL.aHX());
        this.ejL = fVar;
        oh(fVar.qB().qv());
    }

    private void aKb() {
        if (this.ejL != null && this.ejL.aHI() != null && this.ejL.aHV() != null) {
            ArrayList<PostData> aHI = this.ejL.aHI();
            com.baidu.tieba.pb.data.a aHV = this.ejL.aHV();
            int aHv = aHV.aHv();
            if (aHv > 0) {
                if (aHv <= aHI.size()) {
                    aHI.add(aHv, aHV);
                } else {
                    aHI.add(aHV);
                }
            }
        }
    }

    public boolean aKc() {
        if (this.ejv == null || this.ejw == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return oj(4);
        }
        return oj(6);
    }

    public boolean ic(boolean z) {
        if (this.ejv == null || this.ejL == null) {
            return false;
        }
        if (z || this.ejL.qB().qx() != 0) {
            return oj(1);
        }
        return false;
    }

    public boolean id(boolean z) {
        if (this.ejv == null || this.ejL == null) {
            return false;
        }
        if ((z || this.ejL.qB().qy() != 0) && this.ejL.aHI() != null && this.ejL.aHI().size() >= 1) {
            return oj(2);
        }
        return false;
    }

    public boolean nI(String str) {
        this.ejy = !this.ejy;
        this.ejw = str;
        oj(6);
        return true;
    }

    public boolean h(boolean z, String str) {
        if (this.ejy == z) {
            return false;
        }
        this.ejy = z;
        this.ejw = str;
        oj(6);
        return true;
    }

    public boolean aKd() {
        if (com.baidu.adp.lib.util.i.hk()) {
            this.ejz = this.ejA;
            this.ejA = !this.ejA;
        }
        return LoadData();
    }

    public boolean ie(boolean z) {
        if (this.ejA == z) {
            return false;
        }
        if (com.baidu.adp.lib.util.i.hk()) {
            this.ejz = z;
            this.ejA = z;
        }
        return LoadData();
    }

    public boolean aKe() {
        return this.ejA;
    }

    public boolean hasData() {
        return (this.ejL == null || this.ejL.aHE() == null || this.ejL.aHG() == null) ? false : true;
    }

    public boolean nL() {
        if (this.ejL == null) {
            return false;
        }
        return this.ejL.nL();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fq(String str) {
        if (this.ejL == null || this.ejL.aHG() == null || this.ejL.aHE() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.ejL.aHG().sG()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.ejL.aHE().getId());
            writeData.setForumName(this.ejL.aHE().getName());
        }
        writeData.setThreadId(this.ejv);
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

    public MarkData ol(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.ejL == null || this.ejL.aHI() == null) {
            return null;
        }
        ArrayList<PostData> aHI = this.ejL.aHI();
        if (aHI.size() > 0 && i == aHI.size()) {
            i = aHI.size() - 1;
        }
        if (aHI.size() <= 0 || i >= aHI.size()) {
            return null;
        }
        return g(aHI.get(i));
    }

    public MarkData aKf() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ejv);
        markData.setPostId(this.ejL.nK());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ejy);
        markData.setSequence(Boolean.valueOf(this.ejA));
        markData.setId(this.ejv);
        return markData;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ejv);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ejy);
        markData.setSequence(Boolean.valueOf(this.ejA));
        markData.setId(this.ejv);
        markData.setFloor(postData.bgM());
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.o) postData).isApp());
        }
        return markData;
    }

    public void aKg() {
        cz.aJH().M(aKh(), this.isFromMark);
    }

    private String aKh() {
        String str = this.ejv;
        if (this.ejy) {
            str = String.valueOf(str) + DB_KEY_HOST;
        }
        if (!this.ejA) {
            str = String.valueOf(str) + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    /* renamed from: if  reason: not valid java name */
    public void m15if(boolean z) {
        if (this.ejL != null) {
            this.ejL.ad(z);
        }
    }

    public void ig(boolean z) {
        this.ejW = z;
    }

    public boolean aKi() {
        return this.ejW;
    }

    public void a(a aVar) {
        this.ejR = aVar;
    }

    public void mI(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CN() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CM() {
        return EG();
    }

    public boolean nJ(String str) {
        if (getPbData() == null || getPbData().aHG() == null || getPbData().aHG().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aHG().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aKj() {
        return this.mRequestType;
    }

    public void aKk() {
        String aKh = aKh();
        cz.aJH().M(aKh, false);
        cz.aJH().M(aKh, true);
    }

    public void aKl() {
        if ("personalize_page".equals(this.mStType)) {
            this.ekc = System.currentTimeMillis() / 1000;
        }
    }

    public void aKm() {
        if ("personalize_page".equals(this.mStType) && this.ejL != null && this.ekc != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10754").aa("fid", this.ejL.getForumId()).aa("tid", this.ejv).aa("obj_duration", String.valueOf(currentTimeMillis - this.ekc)).aa("obj_param3", String.valueOf(currentTimeMillis)));
            this.ekc = 0L;
        }
    }

    public boolean aKn() {
        return this.ekf;
    }

    public int aKo() {
        return this.ejM;
    }

    public int getErrorNo() {
        return this.ekh;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public dt aKp() {
        return this.ekj;
    }

    public da aKq() {
        return this.ekk;
    }

    public di aKr() {
        return this.ekl;
    }

    public dp aKs() {
        return this.ekm;
    }

    public ee aKt() {
        return this.ekn;
    }

    public String aKu() {
        return this.ekb;
    }

    public void nK(String str) {
        this.ekb = str;
    }

    public boolean aKv() {
        return this.ekg;
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.ejL != null && this.ejL.aHI() != null && this.ejL.aHI().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.ejL.aHI().size();
                for (int i = 0; i < size; i++) {
                    if (this.ejL.aHI().get(i) != null && this.ejL.aHI().get(i).getAuthor() != null && currentAccount.equals(this.ejL.aHI().get(i).getAuthor().getUserId()) && this.ejL.aHI().get(i).getAuthor().getPendantData() != null) {
                        this.ejL.aHI().get(i).getAuthor().getPendantData().cr(iVar.pT());
                        this.ejL.aHI().get(i).getAuthor().getPendantData().O(iVar.BT());
                    }
                }
            }
        }
    }

    public String aKw() {
        return this.eko;
    }

    public int aKx() {
        return this.ekq;
    }
}
