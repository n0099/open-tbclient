package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
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
    private int bGb;
    private com.baidu.tieba.tbadkCore.d.b bNa;
    private BaseActivity bfa;
    private final CheckRealNameModel bgv;
    private long cdX;
    private boolean dFF;
    private int dqG;
    private com.baidu.adp.framework.listener.a dqQ;
    private boolean epA;
    private boolean epB;
    private boolean epC;
    private a epD;
    private String epE;
    private String epF;
    private int epG;
    private int epH;
    private boolean epI;
    private boolean epJ;
    private boolean epK;
    private boolean epL;
    private boolean epM;
    private String epN;
    private long epO;
    private boolean epP;
    private int epQ;
    private boolean epR;
    private boolean epS;
    private int epT;
    private final ek epU;
    private final ec epV;
    private final df epW;
    private final Cdo epX;
    private final dy epY;
    private final en epZ;
    protected String eph;
    private String epi;
    private boolean epj;
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
    protected com.baidu.tieba.pb.data.f epx;
    private int epy;
    private boolean epz;
    private String eqa;
    private SuggestEmotionModel eqb;
    private boolean eqc;
    private int eqd;
    private CustomMessageListener eqe;
    private CustomMessageListener eqf;
    private PraiseData eqg;
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
    private static final int epg = com.baidu.tbadk.data.e.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.f fVar);
    }

    public void iq(boolean z) {
        this.epP = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eph = null;
        this.epi = null;
        this.mForumId = null;
        this.epj = false;
        this.epk = false;
        this.epl = true;
        this.epm = true;
        this.mIsGood = 0;
        this.dqG = 0;
        this.epn = 0L;
        this.epo = 1;
        this.epp = 1;
        this.epq = 1;
        this.bGb = 1;
        this.isAd = false;
        this.epr = false;
        this.eps = false;
        this.dFF = false;
        this.isFromMark = false;
        this.ept = false;
        this.epu = 0L;
        this.epv = false;
        this.epw = null;
        this.epx = null;
        this.isLoading = false;
        this.epz = false;
        this.epA = false;
        this.epB = false;
        this.epC = false;
        this.mLocate = null;
        this.mContext = null;
        this.epD = null;
        this.opType = null;
        this.opUrl = null;
        this.epE = null;
        this.epF = null;
        this.epG = -1;
        this.epH = -1;
        this.bNa = null;
        this.epJ = false;
        this.epK = false;
        this.postID = null;
        this.epN = null;
        this.epO = 0L;
        this.epP = false;
        this.epQ = -1;
        this.epS = false;
        this.eqc = false;
        this.eqd = 0;
        this.eqe = new ef(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.eqf = new eh(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.dqQ = new ei(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.eqg = null;
        registerListener(this.eqe);
        registerListener(this.dqQ);
        registerListener(this.eqf);
        this.epx = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bfa = baseActivity;
        this.epU = new ek(this, this.bfa);
        this.epV = new ec(this, this.bfa);
        this.epW = new df(this, this.bfa);
        this.epX = new Cdo(this, this.bfa);
        this.epY = new dy(this);
        this.epZ = new en(this, this.bfa);
        this.bgv = new CheckRealNameModel(this.bfa.getPageContext());
        this.eqb = new SuggestEmotionModel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aKK() {
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
        this.eph = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eph)) {
            this.eph = this.epU.U(intent);
        }
        this.eqd = intent.getIntExtra(PbActivityConfig.KEY_START_FROM, 0);
        this.epi = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.epj = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.epk = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.epm = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dqG = intent.getIntExtra("is_top", 0);
        this.epn = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.ept = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.epr = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.epv = intent.getBooleanExtra("is_pv", false);
        this.epu = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.epw = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.epF = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.epE = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.epz = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.epA = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.epB = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.epH = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.epG = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eps = intent.getBooleanExtra("from_frs", false);
        this.dFF = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.epS = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.epC = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
        this.eqa = intent.getStringExtra(PbActivityConfig.KEY_POST_THREAD_TIP);
    }

    public void initWithBundle(Bundle bundle) {
        this.eqd = bundle.getInt(PbActivityConfig.KEY_START_FROM, 0);
        this.eph = bundle.getString("thread_id");
        this.epi = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.epj = bundle.getBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.epk = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.epm = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dqG = bundle.getInt("is_top", 0);
        this.epn = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.ept = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.epr = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.epv = bundle.getBoolean("is_pv", false);
        this.epu = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.epw = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.epF = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.epz = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.epA = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.epB = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.epH = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.epG = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eps = bundle.getBoolean("from_frs", false);
        this.dFF = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.epS = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.epC = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void p(Bundle bundle) {
        bundle.putString("thread_id", this.eph);
        bundle.putString("post_id", this.epi);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt(PbActivityConfig.KEY_START_FROM, this.eqd);
        bundle.putBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, this.epj);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.epk);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.epm);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dqG);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.epn);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.ept);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.epr);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.epv);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.epu);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.epF);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.epz);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.epA);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.epB);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.epH);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.epG);
        bundle.putBoolean("from_frs", this.eps);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.dFF);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.epS);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.epC);
    }

    public String aKL() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eph);
        if (!this.ept) {
            sb.append(this.epi);
        }
        sb.append(this.epk);
        sb.append(this.epm);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.dqG);
        sb.append(this.epn);
        sb.append(this.eps);
        sb.append(this.dFF);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.epr);
        sb.append(this.epv);
        sb.append(this.epu);
        sb.append(this.epw);
        sb.append(this.mThreadType);
        sb.append(this.epz);
        sb.append(this.epA);
        sb.append(this.epB);
        if (this.epF != null) {
            sb.append(this.epF);
        }
        return sb.toString();
    }

    public String aKM() {
        return this.epw;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.epi;
    }

    public void nT(String str) {
        this.epi = str;
    }

    public String getThreadID() {
        return this.eph;
    }

    public boolean getHostMode() {
        return this.epk;
    }

    public boolean aKN() {
        return this.epm;
    }

    public boolean aKO() {
        return this.eps;
    }

    public boolean aKP() {
        return this.dFF;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aKQ() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int avp() {
        return this.dqG;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void hv(int i) {
        this.dqG = i;
    }

    public boolean aKR() {
        return this.epr;
    }

    public boolean aKS() {
        if (this.epx == null) {
            return false;
        }
        return this.epx.isValid();
    }

    public String rD() {
        if (this.epx == null || !this.epx.nD()) {
            return null;
        }
        return this.epx.nC();
    }

    public boolean oy(int i) {
        this.epo = i;
        if (this.epo > this.epx.qx().qo()) {
            this.epo = this.epx.qx().qo();
        }
        if (this.epo < 1) {
            this.epo = 1;
        }
        if (this.eph == null) {
            return false;
        }
        return oC(5);
    }

    public boolean oz(int i) {
        int si = this.epx.aIB().si();
        if (i <= si) {
            si = i;
        }
        int i2 = si >= 1 ? si : 1;
        if (this.eph == null) {
            return false;
        }
        this.epQ = i2;
        return oC(7);
    }

    public void oA(int i) {
        this.epo = i;
        this.epp = i;
        this.epq = i;
    }

    public void oB(int i) {
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

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.epx;
    }

    public com.baidu.tbadk.core.data.ar akK() {
        if (this.epx == null) {
            return null;
        }
        return this.epx.qx();
    }

    public boolean aKT() {
        if (this.epm && this.epx.qx().qt() == 0) {
            ir(true);
            return true;
        }
        return false;
    }

    public void nN(String str) {
        if (!StringUtils.isNull(str)) {
            this.eph = str;
            this.epi = null;
            this.epk = false;
            this.epm = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eph == null) {
            return false;
        }
        cancelLoadData();
        if (this.bNa == null) {
            this.bNa = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bNa.start();
        }
        boolean oC = oC(3);
        if (this.opType != null) {
            this.opType = null;
            this.epE = null;
            this.opUrl = null;
            return oC;
        }
        return oC;
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
        if (this.eqb != null) {
            this.eqb.cancelLoadData();
        }
        XF();
    }

    private void XF() {
        if (this.bNa != null) {
            this.bNa.destory();
            this.bNa = null;
        }
    }

    public boolean EA() {
        return (this.epi == null || this.epi.equals("0") || this.epi.length() == 0) ? LoadData() : aKW();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        if (forumData != null && !TextUtils.isEmpty(forumData.getId()) && !TextUtils.isEmpty(forumData.getName())) {
            this.eqb.a(forumData.getId(), forumData.getName(), aVar);
        }
    }

    public boolean oC(int i) {
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        oD(i);
        com.baidu.tieba.pb.data.f pbData = fg.aLX().getPbData();
        if (pbData != null && pbData.aIB() != null) {
            pbData.aIB().bP(0);
            this.epm = fg.aLX().aKN();
            this.epk = fg.aLX().aLZ();
            this.eqc = this.epk;
            if (this.epk || this.isFromMark) {
                this.epI = false;
            }
            com.baidu.adp.lib.g.h.fS().post(new ej(this, pbData));
            return false;
        }
        if (i == 4 && !this.epM) {
            a(aLb(), true, this.epi, 3);
        }
        if (i == 3 && !this.epM) {
            if (this.isFromMark) {
                a(aLb(), true, this.epi, 3);
            } else {
                a(aLb(), false, this.epi, 3);
            }
        }
        this.epM = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.axL);
        if (this.epk || this.isFromMark) {
            this.epI = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eph == null || this.eph.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eph, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.av.vl().vn() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.epm) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.epk) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.epv) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.epu));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.epI) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.epE, 0));
            pbPageRequestMessage.setOpMessageID(this.epu);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aID = this.epx.aID();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.epm) {
                        if (this.epq - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.epq - 1));
                        }
                    } else if (this.epp < this.bGb) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.epp + 1));
                    }
                }
                if (aID != null && aID.size() > 0) {
                    int size = aID.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        PostData postData = aID.get(size - i3);
                        if (postData == null) {
                            i3++;
                        } else {
                            this.epi = postData.getId();
                            if (StringUtils.isNull(this.epi)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.epi != null && this.epi.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.epi, 0L));
                } else if (!this.epm) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aID != null && aID.size() > 0 && aID.get(0) != null) {
                    this.epi = aID.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.epm) {
                        if (this.epq - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.epq - 1));
                        }
                    } else if (this.epp < this.bGb) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.epp + 1));
                    }
                }
                if (this.epi != null && this.epi.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.epi, 0L));
                }
                b(pbPageRequestMessage);
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
                }
                a(pbPageRequestMessage);
                break;
            case 4:
                pbPageRequestMessage.set_st_type("store_thread");
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.epi, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.epo));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.epm && this.eqc && !this.epk) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.epi, 0L));
                }
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.epQ);
                b(pbPageRequestMessage);
                break;
        }
        this.eqc = this.epk;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aLb());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bfa != null && (this.bfa instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bfa).aJC());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.epP);
        pbPageRequestMessage.setFromSmartFrs(this.epS ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.epj);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aKM()) && com.baidu.tieba.recapp.z.aZK().aZG() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.z.aZK().aZG().O(aKM(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.z.aZK().aZG().P(aKM(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aKM()) && com.baidu.tieba.recapp.z.aZK().aZG() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.z.aZK().aZG().P(aKM(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.z.aZK().aZG().O(aKM(), true));
        }
    }

    protected void oD(int i) {
        boolean z = false;
        ArrayList<PostData> aID = this.epx.aID();
        this.epL = false;
        if (i == 1) {
            boolean z2 = false;
            while (aID.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                aID.remove(0);
                z2 = true;
            }
            if (z2) {
                this.epx.qx().bL(1);
                if (this.epD != null) {
                    this.epD.c(this.epx);
                }
            }
            this.cdX = System.currentTimeMillis();
            this.epL = true;
        } else if (i == 2) {
            while (aID.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                aID.remove(aID.size() - 1);
                z = true;
            }
            if (z) {
                this.epx.qx().bK(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.epT = i2;
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
            if (this.epB || this.epz || this.epA) {
                fVar = g(fVar);
            }
            f(fVar);
        }
    }

    protected void f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String h = h(fVar);
            for (int i = 0; i < fVar.aID().size(); i++) {
                PostData postData = fVar.aID().get(i);
                for (int i2 = 0; i2 < postData.bid().size(); i2++) {
                    postData.bid().get(i2).a(this.bfa.getPageContext(), h.equals(postData.bid().get(i2).getAuthor().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.o aIL = fVar.aIL();
            if (aIL != null && !com.baidu.tbadk.core.util.x.r(aIL.eju)) {
                for (PostData postData2 : aIL.eju) {
                    for (int i3 = 0; i3 < postData2.bid().size(); i3++) {
                        postData2.bid().get(i3).a(this.bfa.getPageContext(), h.equals(postData2.bid().get(i3).getAuthor().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String h = h(fVar);
            com.baidu.tieba.pb.data.o aIL = fVar.aIL();
            if (aIL != null && !com.baidu.tbadk.core.util.x.r(aIL.eju)) {
                for (PostData postData : aIL.eju.subList(i, aIL.eju.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bid().size()) {
                            postData.bid().get(i3).a(this.bfa.getPageContext(), h.equals(postData.bid().get(i3).getAuthor().getUserId()));
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
        com.baidu.tbadk.core.data.bl aIB = fVar.aIB();
        aIB.bT(this.mIsGood);
        aIB.bS(this.dqG);
        if (this.epn > 0) {
            aIB.m(this.epn);
            return fVar;
        }
        return fVar;
    }

    protected String h(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aIB() != null && fVar.aIB().getAuthor() != null) {
            str = fVar.aIB().getAuthor().getUserId();
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
        if (fVar.aIB() != null && fVar.aIB().getAuthor() != null) {
            str = fVar.aIB().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aKU() {
        if (this.epx == null || this.epx.aIB() == null || this.epx.aIB().getAuthor() == null) {
            return null;
        }
        return this.epx.aIB().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.epR = z3;
        this.epy = i;
        if (this.bNa != null && !z3) {
            this.bNa.a(z2, z4, i2, str, i3, j, j2);
            this.bNa = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aKM()) && com.baidu.tieba.recapp.z.aZK().aZG() != null) {
            com.baidu.tieba.recapp.z.aZK().aZG().g(aKM(), oE(aLd()), true);
        }
        if (fVar == null || (this.epo == 1 && i == 5 && fVar.aID() != null && fVar.aID().size() < 1)) {
            if (this.epD != null) {
                this.epm = this.epl;
                this.epD.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.epl = this.epm;
            this.epv = false;
            if (fVar.qx() != null) {
                oB(fVar.qx().qr());
                this.bGb = fVar.qx().qo();
            }
            this.bGb = this.bGb < 1 ? 1 : this.bGb;
            int i5 = 0;
            ArrayList<PostData> aID = this.epx.aID();
            switch (i) {
                case 1:
                    this.epx.a(fVar.qx(), 1);
                    d(fVar, aID);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aID() != null) {
                        int size = fVar.aID().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(aID, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aID(), com.baidu.tbadk.core.util.x.q(fVar.aID()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aID().remove(postData2);
                            i5 = size - 1;
                        }
                        aID.addAll(0, fVar.aID());
                    }
                    this.epx.a(fVar.qx(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.epm && fVar.qx() != null) {
                        fVar.qx().bI(fVar.qx().qo());
                    }
                    j(fVar);
                    if (!z3 && this.mThreadType != 33 && this.epm) {
                        aKV();
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
            if (this.epx != null && this.epx.aIB() != null) {
                PraiseData rk = this.epx.aIB().rk();
                if (this.eqg != null && !rk.isPriaseDataValid()) {
                    this.epx.aIB().a(this.eqg);
                } else {
                    this.eqg = this.epx.aIB().rk();
                    this.eqg.setPostId(this.epx.aIB().rK());
                }
                if (fVar.qx() != null && fVar.qx().qr() == 1 && fVar.aIB() != null && fVar.aIB().rF() != null && fVar.aIB().rF().size() > 0) {
                    this.epx.aIB().h(fVar.aIB().rF());
                }
                this.epx.aIB().bQ(fVar.aIB().rn());
                this.epx.aIB().bO(fVar.aIB().getAnchorLevel());
                this.epx.aIB().bP(fVar.aIB().ri());
                if (this.mThreadType == 33) {
                    this.epx.aIB().getAuthor().setHadConcerned(fVar.aIB().getAuthor().hadConcerned());
                }
            }
            if (this.epx != null && this.epx.getUserData() != null && fVar.getUserData() != null) {
                this.epx.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.epx.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qx() != null && fVar.qx().qr() == 1 && fVar.aIK() != null) {
                this.epx.d(fVar.aIK());
            }
            if (this.epR && this.epx.aIB() != null && this.epx.aIB().getAuthor() != null && this.epx.aID() != null && com.baidu.tbadk.core.util.x.c(this.epx.aID(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.c(this.epx.aID(), 0);
                MetaData author = this.epx.aIB().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.epG != -1) {
                        author.setFansNum(this.epG);
                        postData3.getAuthor().setFansNum(this.epG);
                    }
                    if (this.epH != -1) {
                        author.getGodUserData().setIsLike(this.epH == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.epH == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.epx != null && this.epx.aIx() != null && fVar.aIx() != null) {
                this.epx.aIx().k(fVar.aIx().getItems());
                this.epx.aIx().an(fVar.aIx().pX());
            }
            if (this.epD != null) {
                this.epD.a(true, getErrorCode(), i, i4, this.epx, this.mErrorString, 1);
            }
        }
        if (this.epx != null && this.epx.aIB() != null && this.epx.aIz() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bfa;
            historyMessage.threadId = getPbData().aIB().getId();
            historyMessage.forumName = getPbData().aIz().getName();
            historyMessage.threadName = getPbData().aIB().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aKN();
            historyMessage.threadType = getPbData().aIB().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aj;
        if (arrayList != null && fVar.aID() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aID(), 0);
            if (postData != null && (aj = aj(arrayList)) != null && aj.equals(postData.getId())) {
                fVar.aID().remove(postData);
            }
            arrayList.addAll(fVar.aID());
        }
    }

    private int oE(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
            default:
                return -1;
            case 3:
                return 1;
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
        fVar.nL(this.epx.aIS());
        this.epx = fVar;
        oA(fVar.qx().qr());
    }

    private void aKV() {
        if (this.epx != null && this.epx.aID() != null && this.epx.aIQ() != null) {
            ArrayList<PostData> aID = this.epx.aID();
            com.baidu.tieba.pb.data.a aIQ = this.epx.aIQ();
            int aIq = aIQ.aIq();
            if (aIq > 0) {
                if (aIq <= aID.size()) {
                    aID.add(aIq, aIQ);
                } else {
                    aID.add(aIQ);
                }
            }
        }
    }

    public boolean aKW() {
        if (this.eph == null || this.epi == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return oC(4);
        }
        return oC(6);
    }

    public boolean ir(boolean z) {
        if (this.eph == null || this.epx == null) {
            return false;
        }
        if (z || this.epx.qx().qt() != 0) {
            return oC(1);
        }
        return false;
    }

    public boolean is(boolean z) {
        if (this.eph == null || this.epx == null) {
            return false;
        }
        if ((z || this.epx.qx().qu() != 0) && this.epx.aID() != null && this.epx.aID().size() >= 1) {
            return oC(2);
        }
        return false;
    }

    public boolean nU(String str) {
        this.epk = !this.epk;
        this.epi = str;
        oC(6);
        return true;
    }

    public boolean h(boolean z, String str) {
        if (this.epk == z) {
            return false;
        }
        this.epk = z;
        this.epi = str;
        oC(6);
        return true;
    }

    public boolean aKX() {
        if (com.baidu.adp.lib.util.i.hk()) {
            this.epl = this.epm;
            this.epm = !this.epm;
        }
        return LoadData();
    }

    public boolean it(boolean z) {
        if (this.epm == z) {
            return false;
        }
        if (com.baidu.adp.lib.util.i.hk()) {
            this.epl = z;
            this.epm = z;
        }
        return LoadData();
    }

    public boolean aKY() {
        return this.epm;
    }

    public boolean hasData() {
        return (this.epx == null || this.epx.aIz() == null || this.epx.aIB() == null) ? false : true;
    }

    public boolean nD() {
        if (this.epx == null) {
            return false;
        }
        return this.epx.nD();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fo(String str) {
        if (this.epx == null || this.epx.aIB() == null || this.epx.aIz() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.epx.aIB().sE()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.epx.aIz().getId());
            writeData.setForumName(this.epx.aIz().getName());
        }
        writeData.setThreadId(this.eph);
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

    public MarkData oF(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.epx == null || this.epx.aID() == null) {
            return null;
        }
        ArrayList<PostData> aID = this.epx.aID();
        if (aID.size() > 0 && i == aID.size()) {
            i = aID.size() - 1;
        }
        if (aID.size() <= 0 || i >= aID.size()) {
            return null;
        }
        return h(aID.get(i));
    }

    public MarkData aKZ() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eph);
        markData.setPostId(this.epx.nC());
        markData.setTime(date.getTime());
        markData.setHostMode(this.epk);
        markData.setSequence(Boolean.valueOf(this.epm));
        markData.setId(this.eph);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eph);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.epk);
        markData.setSequence(Boolean.valueOf(this.epm));
        markData.setId(this.eph);
        markData.setFloor(postData.big());
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.o) postData).isApp());
        }
        return markData;
    }

    public void aLa() {
        de.aKB().J(aLb(), this.isFromMark);
    }

    private String aLb() {
        String str = this.eph;
        if (this.epk) {
            str = String.valueOf(str) + DB_KEY_HOST;
        }
        if (!this.epm) {
            str = String.valueOf(str) + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void iu(boolean z) {
        if (this.epx != null) {
            this.epx.ac(z);
        }
    }

    public void iv(boolean z) {
        this.epI = z;
    }

    public boolean aLc() {
        return this.epI;
    }

    public void a(a aVar) {
        this.epD = aVar;
    }

    public void mT(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CH() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CG() {
        return EA();
    }

    public boolean nV(String str) {
        if (getPbData() == null || getPbData().aIB() == null || getPbData().aIB().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aIB().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aLd() {
        return this.mRequestType;
    }

    public void aLe() {
        String aLb = aLb();
        de.aKB().J(aLb, false);
        de.aKB().J(aLb, true);
    }

    public void aLf() {
        if ("personalize_page".equals(this.mStType)) {
            this.epO = System.currentTimeMillis() / 1000;
        }
    }

    public void aLg() {
        if ("personalize_page".equals(this.mStType) && this.epx != null && this.epO != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10754").Z("fid", this.epx.getForumId()).Z("tid", this.eph).Z("obj_duration", String.valueOf(currentTimeMillis - this.epO)).Z("obj_param3", String.valueOf(currentTimeMillis)));
            this.epO = 0L;
        }
    }

    public boolean aLh() {
        return this.epR;
    }

    public int aLi() {
        return this.epy;
    }

    public int getErrorNo() {
        return this.epT;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public ec aLj() {
        return this.epV;
    }

    public df aLk() {
        return this.epW;
    }

    public Cdo aLl() {
        return this.epX;
    }

    public dy aLm() {
        return this.epY;
    }

    public en aLn() {
        return this.epZ;
    }

    public CheckRealNameModel aLo() {
        return this.bgv;
    }

    public String aLp() {
        return this.epN;
    }

    public void nW(String str) {
        this.epN = str;
    }

    public boolean aLq() {
        return this.epS;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.epx != null && this.epx.aID() != null && this.epx.aID().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.epx.aID().size();
                for (int i = 0; i < size; i++) {
                    if (this.epx.aID().get(i) != null && this.epx.aID().get(i).getAuthor() != null && currentAccount.equals(this.epx.aID().get(i).getAuthor().getUserId()) && this.epx.aID().get(i).getAuthor().getPendantData() != null) {
                        this.epx.aID().get(i).getAuthor().getPendantData().cq(jVar.pL());
                        this.epx.aID().get(i).getAuthor().getPendantData().O(jVar.BN());
                    }
                }
            }
        }
    }

    public String aLr() {
        return this.eqa;
    }

    public int aLs() {
        return this.eqd;
    }
}
