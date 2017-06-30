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
import com.baidu.tieba.pb.share.AddExperiencedModel;
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
    private int bGT;
    private com.baidu.tieba.tbadkCore.d.b bTD;
    private BaseActivity bhX;
    private final CheckRealNameModel bjw;
    private long cmk;
    private boolean dOa;
    private com.baidu.adp.framework.listener.a dzD;
    private int dzt;
    private int eyA;
    private boolean eyB;
    private boolean eyC;
    private boolean eyD;
    private long eyE;
    private boolean eyF;
    private String eyG;
    protected com.baidu.tieba.pb.data.f eyH;
    private int eyI;
    private boolean eyJ;
    private boolean eyK;
    private boolean eyL;
    private boolean eyM;
    private a eyN;
    private String eyO;
    private String eyP;
    private int eyQ;
    private int eyR;
    private boolean eyS;
    private boolean eyT;
    private boolean eyU;
    private boolean eyV;
    private boolean eyW;
    private String eyX;
    private long eyY;
    private boolean eyZ;
    protected String eyr;
    private String eys;
    private boolean eyt;
    private boolean eyu;
    private boolean eyv;
    private boolean eyw;
    private long eyx;
    private int eyy;
    private int eyz;
    private int eza;
    private boolean ezb;
    private boolean ezc;
    private int ezd;
    private final et eze;
    private final el ezf;
    private final dm ezg;
    private final dv ezh;
    private final PbFloorAgreeModel ezi;
    private final ew ezj;
    private String ezk;
    private final AddExperiencedModel ezl;
    private SuggestEmotionModel ezm;
    private boolean ezn;
    private int ezo;
    private CustomMessageListener ezp;
    private CustomMessageListener ezq;
    private PraiseData ezr;
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
    private static final int eyq = com.baidu.tbadk.data.e.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.f fVar);
    }

    public void iM(boolean z) {
        this.eyZ = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eyr = null;
        this.eys = null;
        this.mForumId = null;
        this.eyt = false;
        this.eyu = false;
        this.eyv = true;
        this.eyw = true;
        this.mIsGood = 0;
        this.dzt = 0;
        this.eyx = 0L;
        this.eyy = 1;
        this.eyz = 1;
        this.eyA = 1;
        this.bGT = 1;
        this.isAd = false;
        this.eyB = false;
        this.eyC = false;
        this.dOa = false;
        this.isFromMark = false;
        this.eyD = false;
        this.eyE = 0L;
        this.eyF = false;
        this.eyG = null;
        this.eyH = null;
        this.isLoading = false;
        this.eyJ = false;
        this.eyK = false;
        this.eyL = false;
        this.eyM = false;
        this.mLocate = null;
        this.mContext = null;
        this.eyN = null;
        this.opType = null;
        this.opUrl = null;
        this.eyO = null;
        this.eyP = null;
        this.eyQ = -1;
        this.eyR = -1;
        this.bTD = null;
        this.eyT = false;
        this.eyU = false;
        this.postID = null;
        this.eyX = null;
        this.eyY = 0L;
        this.eyZ = false;
        this.eza = -1;
        this.ezc = false;
        this.ezn = false;
        this.ezo = 0;
        this.ezp = new eo(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.ezq = new eq(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.dzD = new er(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.ezr = null;
        registerListener(this.ezp);
        registerListener(this.dzD);
        registerListener(this.ezq);
        this.eyH = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bhX = baseActivity;
        this.eze = new et(this, this.bhX);
        this.ezf = new el(this, this.bhX);
        this.ezg = new dm(this, this.bhX);
        this.ezh = new dv(this, this.bhX);
        this.ezi = new PbFloorAgreeModel(this);
        this.ezj = new ew(this, this.bhX);
        this.bjw = new CheckRealNameModel(this.bhX.getPageContext());
        this.ezm = new SuggestEmotionModel();
        this.ezl = new AddExperiencedModel(this.bhX.getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aOH() {
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
        this.eyr = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eyr)) {
            this.eyr = this.eze.V(intent);
        }
        this.ezo = intent.getIntExtra(PbActivityConfig.KEY_START_FROM, 0);
        this.eys = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eyt = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eyu = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eyw = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dzt = intent.getIntExtra("is_top", 0);
        this.eyx = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eyD = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eyB = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eyF = intent.getBooleanExtra("is_pv", false);
        this.eyE = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eyG = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eyP = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.eyO = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.eyJ = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eyK = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eyL = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eyR = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eyQ = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eyC = intent.getBooleanExtra("from_frs", false);
        this.dOa = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.ezc = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eyM = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
        this.ezk = intent.getStringExtra(PbActivityConfig.KEY_POST_THREAD_TIP);
    }

    public void initWithBundle(Bundle bundle) {
        this.ezo = bundle.getInt(PbActivityConfig.KEY_START_FROM, 0);
        this.eyr = bundle.getString("thread_id");
        this.eys = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eyt = bundle.getBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eyu = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eyw = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dzt = bundle.getInt("is_top", 0);
        this.eyx = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eyD = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eyB = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eyF = bundle.getBoolean("is_pv", false);
        this.eyE = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eyG = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eyP = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.eyJ = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eyK = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eyL = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eyR = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eyQ = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eyC = bundle.getBoolean("from_frs", false);
        this.dOa = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.ezc = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eyM = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void p(Bundle bundle) {
        bundle.putString("thread_id", this.eyr);
        bundle.putString("post_id", this.eys);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt(PbActivityConfig.KEY_START_FROM, this.ezo);
        bundle.putBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, this.eyt);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.eyu);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.eyw);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dzt);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.eyx);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.eyD);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.eyB);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eyF);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.eyE);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.eyP);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.eyJ);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.eyK);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.eyL);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.eyR);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.eyQ);
        bundle.putBoolean("from_frs", this.eyC);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.dOa);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.ezc);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.eyM);
    }

    public String aOI() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eyr);
        if (!this.eyD) {
            sb.append(this.eys);
        }
        sb.append(this.eyu);
        sb.append(this.eyw);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.dzt);
        sb.append(this.eyx);
        sb.append(this.eyC);
        sb.append(this.dOa);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eyB);
        sb.append(this.eyF);
        sb.append(this.eyE);
        sb.append(this.eyG);
        sb.append(this.mThreadType);
        sb.append(this.eyJ);
        sb.append(this.eyK);
        sb.append(this.eyL);
        if (this.eyP != null) {
            sb.append(this.eyP);
        }
        return sb.toString();
    }

    public String aOJ() {
        return this.eyG;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eys;
    }

    public void oO(String str) {
        this.eys = str;
    }

    public String getThreadID() {
        return this.eyr;
    }

    public boolean getHostMode() {
        return this.eyu;
    }

    public boolean aOK() {
        return this.eyw;
    }

    public boolean aOL() {
        return this.eyC;
    }

    public boolean aOM() {
        return this.dOa;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aON() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int azn() {
        return this.dzt;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void hy(int i) {
        this.dzt = i;
    }

    public boolean aOO() {
        return this.eyB;
    }

    public boolean aOP() {
        if (this.eyH == null) {
            return false;
        }
        return this.eyH.isValid();
    }

    public String rA() {
        if (this.eyH == null || !this.eyH.nz()) {
            return null;
        }
        return this.eyH.ny();
    }

    public boolean oP(int i) {
        this.eyy = i;
        if (this.eyy > this.eyH.qu().ql()) {
            this.eyy = this.eyH.qu().ql();
        }
        if (this.eyy < 1) {
            this.eyy = 1;
        }
        if (this.eyr == null) {
            return false;
        }
        return oT(5);
    }

    public boolean oQ(int i) {
        int sf = this.eyH.aMv().sf();
        if (i <= sf) {
            sf = i;
        }
        int i2 = sf >= 1 ? sf : 1;
        if (this.eyr == null) {
            return false;
        }
        this.eza = i2;
        return oT(7);
    }

    public void oR(int i) {
        this.eyy = i;
        this.eyz = i;
        this.eyA = i;
    }

    public void oS(int i) {
        if (this.eyz < i) {
            this.eyz = i;
            if (this.eyz - this.eyA >= eyq) {
                this.eyA = (this.eyz - eyq) + 1;
            }
        }
        if (this.eyA > i) {
            this.eyA = i;
            if (this.eyz - this.eyA >= eyq) {
                this.eyz = (this.eyA + eyq) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eyH;
    }

    public com.baidu.tbadk.core.data.as aov() {
        if (this.eyH == null) {
            return null;
        }
        return this.eyH.qu();
    }

    public boolean aOQ() {
        if (this.eyw && this.eyH.qu().qq() == 0) {
            iN(true);
            return true;
        }
        return false;
    }

    public void oH(String str) {
        if (!StringUtils.isNull(str)) {
            this.eyr = str;
            this.eys = null;
            this.eyu = false;
            this.eyw = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eyr == null) {
            return false;
        }
        cancelLoadData();
        if (this.bTD == null) {
            this.bTD = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bTD.start();
        }
        boolean oT = oT(3);
        if (this.opType != null) {
            this.opType = null;
            this.eyO = null;
            this.opUrl = null;
            return oT;
        }
        return oT;
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
        if (this.ezm != null) {
            this.ezm.cancelLoadData();
        }
        if (this.ezi != null) {
            this.ezi.cancelLoadData();
        }
        abd();
    }

    private void abd() {
        if (this.bTD != null) {
            this.bTD.destory();
            this.bTD = null;
        }
    }

    public boolean EX() {
        return (this.eys == null || this.eys.equals("0") || this.eys.length() == 0) ? LoadData() : aOT();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        if (forumData != null && !TextUtils.isEmpty(forumData.getId()) && !TextUtils.isEmpty(forumData.getName())) {
            this.ezm.a(forumData.getId(), forumData.getName(), aVar);
        }
    }

    public boolean oT(int i) {
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        oU(i);
        com.baidu.tieba.pb.data.f pbData = fp.aPV().getPbData();
        if (pbData != null && pbData.aMv() != null) {
            pbData.aMv().bP(0);
            this.eyw = fp.aPV().aOK();
            this.eyu = fp.aPV().aPX();
            this.ezn = this.eyu;
            if (this.eyu || this.isFromMark) {
                this.eyS = false;
            }
            com.baidu.adp.lib.g.h.fR().post(new es(this, pbData));
            return false;
        }
        if (i == 4 && !this.eyW) {
            a(aOY(), true, this.eys, 3);
        }
        if (i == 3 && !this.eyW) {
            if (this.isFromMark) {
                a(aOY(), true, this.eys, 3);
            } else {
                a(aOY(), false, this.eys, 3);
            }
        }
        this.eyW = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.ayN);
        if (this.eyu || this.isFromMark) {
            this.eyS = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eyr == null || this.eyr.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eyr, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.ax.vA().vC() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.eyw) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eyu) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eyF) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eyE));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eyS) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eyO, 0));
            pbPageRequestMessage.setOpMessageID(this.eyE);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aMx = this.eyH.aMx();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eyw) {
                        if (this.eyA - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eyA - 1));
                        }
                    } else if (this.eyz < this.bGT) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eyz + 1));
                    }
                }
                if (aMx != null && aMx.size() > 0) {
                    int size = aMx.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        PostData postData = aMx.get(size - i3);
                        if (postData == null) {
                            i3++;
                        } else {
                            this.eys = postData.getId();
                            if (StringUtils.isNull(this.eys)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.eys != null && this.eys.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eys, 0L));
                } else if (!this.eyw) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aMx != null && aMx.size() > 0 && aMx.get(0) != null) {
                    this.eys = aMx.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eyw) {
                        if (this.eyA - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eyA - 1));
                        }
                    } else if (this.eyz < this.bGT) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eyz + 1));
                    }
                }
                if (this.eys != null && this.eys.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eys, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eyw) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eys, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eyy));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eyw && this.ezn && !this.eyu) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eys, 0L));
                }
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eza);
                b(pbPageRequestMessage);
                break;
        }
        this.ezn = this.eyu;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aOY());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bhX != null && (this.bhX instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bhX).aNw());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.eyZ);
        pbPageRequestMessage.setFromSmartFrs(this.ezc ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eyt);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aOJ()) && com.baidu.tieba.recapp.aa.bdU().bdQ() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.aa.bdU().bdQ().T(aOJ(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.aa.bdU().bdQ().U(aOJ(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aOJ()) && com.baidu.tieba.recapp.aa.bdU().bdQ() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.aa.bdU().bdQ().U(aOJ(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.aa.bdU().bdQ().T(aOJ(), true));
        }
    }

    protected void oU(int i) {
        boolean z = false;
        ArrayList<PostData> aMx = this.eyH.aMx();
        this.eyV = false;
        if (i == 1) {
            boolean z2 = false;
            while (aMx.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                aMx.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eyH.qu().bL(1);
                if (this.eyN != null) {
                    this.eyN.c(this.eyH);
                }
            }
            this.cmk = System.currentTimeMillis();
            this.eyV = true;
        } else if (i == 2) {
            while (aMx.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                aMx.remove(aMx.size() - 1);
                z = true;
            }
            if (z) {
                this.eyH.qu().bK(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.ezd = i2;
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
            if (this.eyL || this.eyJ || this.eyK) {
                fVar = g(fVar);
            }
            f(fVar);
        }
    }

    protected void f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String h = h(fVar);
            for (int i = 0; i < fVar.aMx().size(); i++) {
                PostData postData = fVar.aMx().get(i);
                for (int i2 = 0; i2 < postData.bmr().size(); i2++) {
                    postData.bmr().get(i2).a(this.bhX.getPageContext(), h.equals(postData.bmr().get(i2).getAuthor().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.o aMF = fVar.aMF();
            if (aMF != null && !com.baidu.tbadk.core.util.z.t(aMF.ess)) {
                for (PostData postData2 : aMF.ess) {
                    for (int i3 = 0; i3 < postData2.bmr().size(); i3++) {
                        postData2.bmr().get(i3).a(this.bhX.getPageContext(), h.equals(postData2.bmr().get(i3).getAuthor().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String h = h(fVar);
            com.baidu.tieba.pb.data.o aMF = fVar.aMF();
            if (aMF != null && !com.baidu.tbadk.core.util.z.t(aMF.ess)) {
                for (PostData postData : aMF.ess.subList(i, aMF.ess.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bmr().size()) {
                            postData.bmr().get(i3).a(this.bhX.getPageContext(), h.equals(postData.bmr().get(i3).getAuthor().getUserId()));
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
        com.baidu.tbadk.core.data.bm aMv = fVar.aMv();
        aMv.bT(this.mIsGood);
        aMv.bS(this.dzt);
        if (this.eyx > 0) {
            aMv.m(this.eyx);
            return fVar;
        }
        return fVar;
    }

    protected String h(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aMv() != null && fVar.aMv().getAuthor() != null) {
            str = fVar.aMv().getAuthor().getUserId();
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
        if (fVar.aMv() != null && fVar.aMv().getAuthor() != null) {
            str = fVar.aMv().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aOR() {
        if (this.eyH == null || this.eyH.aMv() == null || this.eyH.aMv().getAuthor() == null) {
            return null;
        }
        return this.eyH.aMv().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.ezb = z3;
        this.eyI = i;
        if (this.bTD != null && !z3) {
            this.bTD.a(z2, z4, i2, str, i3, j, j2);
            this.bTD = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aOJ()) && com.baidu.tieba.recapp.aa.bdU().bdQ() != null) {
            com.baidu.tieba.recapp.aa.bdU().bdQ().g(aOJ(), oV(aPa()), true);
        }
        if (fVar == null || (this.eyy == 1 && i == 5 && fVar.aMx() != null && fVar.aMx().size() < 1)) {
            if (this.eyN != null) {
                this.eyw = this.eyv;
                this.eyN.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eyv = this.eyw;
            this.eyF = false;
            if (fVar.qu() != null) {
                oS(fVar.qu().qo());
                this.bGT = fVar.qu().ql();
            }
            this.bGT = this.bGT < 1 ? 1 : this.bGT;
            int i5 = 0;
            ArrayList<PostData> aMx = this.eyH.aMx();
            switch (i) {
                case 1:
                    this.eyH.a(fVar.qu(), 1);
                    d(fVar, aMx);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aMx() != null) {
                        int size = fVar.aMx().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.z.c(aMx, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.z.c(fVar.aMx(), com.baidu.tbadk.core.util.z.s(fVar.aMx()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aMx().remove(postData2);
                            i5 = size - 1;
                        }
                        aMx.addAll(0, fVar.aMx());
                    }
                    this.eyH.a(fVar.qu(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.eyw && fVar.qu() != null) {
                        fVar.qu().bI(fVar.qu().ql());
                    }
                    j(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eyw) {
                        aOS();
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
            if (this.eyH != null && this.eyH.aMv() != null) {
                PraiseData rh = this.eyH.aMv().rh();
                if (this.ezr != null && !rh.isPriaseDataValid()) {
                    this.eyH.aMv().a(this.ezr);
                } else {
                    this.ezr = this.eyH.aMv().rh();
                    this.ezr.setPostId(this.eyH.aMv().rH());
                }
                if (fVar.qu() != null && fVar.qu().qo() == 1 && fVar.aMv() != null && fVar.aMv().rC() != null && fVar.aMv().rC().size() > 0) {
                    this.eyH.aMv().h(fVar.aMv().rC());
                }
                this.eyH.aMv().bQ(fVar.aMv().rj());
                this.eyH.aMv().bO(fVar.aMv().getAnchorLevel());
                this.eyH.aMv().bP(fVar.aMv().rf());
                if (this.mThreadType == 33) {
                    this.eyH.aMv().getAuthor().setHadConcerned(fVar.aMv().getAuthor().hadConcerned());
                }
            }
            if (this.eyH != null && this.eyH.getUserData() != null && fVar.getUserData() != null) {
                this.eyH.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eyH.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qu() != null && fVar.qu().qo() == 1 && fVar.aME() != null) {
                this.eyH.e(fVar.aME());
            }
            if (this.ezb && this.eyH.aMv() != null && this.eyH.aMv().getAuthor() != null && this.eyH.aMx() != null && com.baidu.tbadk.core.util.z.c(this.eyH.aMx(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.z.c(this.eyH.aMx(), 0);
                MetaData author = this.eyH.aMv().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.eyQ != -1) {
                        author.setFansNum(this.eyQ);
                        postData3.getAuthor().setFansNum(this.eyQ);
                    }
                    if (this.eyR != -1) {
                        author.getGodUserData().setIsLike(this.eyR == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.eyR == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eyH != null && this.eyH.aMr() != null && fVar.aMr() != null) {
                this.eyH.aMr().m(fVar.aMr().getItems());
                this.eyH.aMr().an(fVar.aMr().pU());
            }
            if (this.eyN != null) {
                this.eyN.a(true, getErrorCode(), i, i4, this.eyH, this.mErrorString, 1);
            }
        }
        if (this.eyH != null && this.eyH.aMv() != null && this.eyH.aMt() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bhX;
            historyMessage.threadId = getPbData().aMv().getId();
            historyMessage.forumName = getPbData().aMt().getName();
            historyMessage.threadName = getPbData().aMv().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aOK();
            historyMessage.threadType = getPbData().aMv().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String al;
        if (arrayList != null && fVar.aMx() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.z.c(fVar.aMx(), 0);
            if (postData != null && (al = al(arrayList)) != null && al.equals(postData.getId())) {
                fVar.aMx().remove(postData);
            }
            arrayList.addAll(fVar.aMx());
        }
    }

    private int oV(int i) {
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

    private String al(ArrayList<PostData> arrayList) {
        int s = com.baidu.tbadk.core.util.z.s(arrayList);
        if (s <= 0) {
            return null;
        }
        for (int i = s - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.z.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.baidu.tieba.pb.data.f fVar) {
        fVar.oF(this.eyH.aMM());
        this.eyH = fVar;
        oR(fVar.qu().qo());
    }

    private void aOS() {
        if (this.eyH != null && this.eyH.aMx() != null && this.eyH.aMK() != null) {
            ArrayList<PostData> aMx = this.eyH.aMx();
            com.baidu.tieba.pb.data.a aMK = this.eyH.aMK();
            int aMk = aMK.aMk();
            if (aMk > 0) {
                if (aMk <= aMx.size()) {
                    aMx.add(aMk, aMK);
                } else {
                    aMx.add(aMK);
                }
            }
        }
    }

    public boolean aOT() {
        if (this.eyr == null || this.eys == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return oT(4);
        }
        return oT(6);
    }

    public boolean iN(boolean z) {
        if (this.eyr == null || this.eyH == null) {
            return false;
        }
        if (z || this.eyH.qu().qq() != 0) {
            return oT(1);
        }
        return false;
    }

    public boolean iO(boolean z) {
        if (this.eyr == null || this.eyH == null) {
            return false;
        }
        if ((z || this.eyH.qu().qr() != 0) && this.eyH.aMx() != null && this.eyH.aMx().size() >= 1) {
            return oT(2);
        }
        return false;
    }

    public boolean oP(String str) {
        this.eyu = !this.eyu;
        this.eys = str;
        oT(6);
        return true;
    }

    public boolean h(boolean z, String str) {
        if (this.eyu == z) {
            return false;
        }
        this.eyu = z;
        this.eys = str;
        oT(6);
        return true;
    }

    public boolean aOU() {
        if (com.baidu.adp.lib.util.i.hj()) {
            this.eyv = this.eyw;
            this.eyw = !this.eyw;
        }
        return LoadData();
    }

    public boolean iP(boolean z) {
        if (this.eyw == z) {
            return false;
        }
        if (com.baidu.adp.lib.util.i.hj()) {
            this.eyv = z;
            this.eyw = z;
        }
        return LoadData();
    }

    public boolean aOV() {
        return this.eyw;
    }

    public boolean hasData() {
        return (this.eyH == null || this.eyH.aMt() == null || this.eyH.aMv() == null) ? false : true;
    }

    public boolean nz() {
        if (this.eyH == null) {
            return false;
        }
        return this.eyH.nz();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fI(String str) {
        if (this.eyH == null || this.eyH.aMv() == null || this.eyH.aMt() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eyH.aMv().sC()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eyH.aMt().getId());
            writeData.setForumName(this.eyH.aMt().getName());
        }
        writeData.setThreadId(this.eyr);
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

    public MarkData oW(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.eyH == null) {
            return null;
        }
        ArrayList<PostData> aMx = this.eyH.aMx();
        if (com.baidu.tbadk.core.util.z.t(aMx)) {
            return null;
        }
        if (aMx.size() > 0 && i >= aMx.size()) {
            i = aMx.size() - 1;
        }
        return j(aMx.get(i));
    }

    public MarkData aOW() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eyr);
        markData.setPostId(this.eyH.ny());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eyu);
        markData.setSequence(Boolean.valueOf(this.eyw));
        markData.setId(this.eyr);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eyr);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eyu);
        markData.setSequence(Boolean.valueOf(this.eyw));
        markData.setId(this.eyr);
        markData.setFloor(postData.bmu());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.o) postData).isApp());
        }
        return markData;
    }

    public void aOX() {
        dl.aOy().O(aOY(), this.isFromMark);
    }

    private String aOY() {
        String str = this.eyr;
        if (this.eyu) {
            str = String.valueOf(str) + DB_KEY_HOST;
        }
        if (!this.eyw) {
            str = String.valueOf(str) + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void iQ(boolean z) {
        if (this.eyH != null) {
            this.eyH.ac(z);
        }
    }

    public void iR(boolean z) {
        this.eyS = z;
    }

    public boolean aOZ() {
        return this.eyS;
    }

    public void a(a aVar) {
        this.eyN = aVar;
    }

    public void nI(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Db() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Da() {
        return EX();
    }

    public boolean oQ(String str) {
        if (getPbData() == null || getPbData().aMv() == null || getPbData().aMv().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aMv().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aPa() {
        return this.mRequestType;
    }

    public void aPb() {
        String aOY = aOY();
        dl.aOy().O(aOY, false);
        dl.aOy().O(aOY, true);
    }

    public void aPc() {
        if ("personalize_page".equals(this.mStType)) {
            this.eyY = System.currentTimeMillis() / 1000;
        }
    }

    public void aPd() {
        if ("personalize_page".equals(this.mStType) && this.eyH != null && this.eyY != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10754").Z("fid", this.eyH.getForumId()).Z("tid", this.eyr).Z("obj_duration", String.valueOf(currentTimeMillis - this.eyY)).Z("obj_param3", String.valueOf(currentTimeMillis)));
            this.eyY = 0L;
        }
    }

    public boolean aPe() {
        return this.ezb;
    }

    public int aPf() {
        return this.eyI;
    }

    public int getErrorNo() {
        return this.ezd;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public el aPg() {
        return this.ezf;
    }

    public dm aPh() {
        return this.ezg;
    }

    public dv aPi() {
        return this.ezh;
    }

    public PbFloorAgreeModel aPj() {
        return this.ezi;
    }

    public ew aPk() {
        return this.ezj;
    }

    public CheckRealNameModel aPl() {
        return this.bjw;
    }

    public AddExperiencedModel aPm() {
        return this.ezl;
    }

    public String aPn() {
        return this.eyX;
    }

    public void oR(String str) {
        this.eyX = str;
    }

    public boolean aPo() {
        return this.ezc;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.eyH != null && this.eyH.aMx() != null && this.eyH.aMx().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eyH.aMx().size();
                for (int i = 0; i < size; i++) {
                    if (this.eyH.aMx().get(i) != null && this.eyH.aMx().get(i).getAuthor() != null && currentAccount.equals(this.eyH.aMx().get(i).getAuthor().getUserId()) && this.eyH.aMx().get(i).getAuthor().getPendantData() != null) {
                        this.eyH.aMx().get(i).getAuthor().getPendantData().cw(jVar.pI());
                        this.eyH.aMx().get(i).getAuthor().getPendantData().P(jVar.Ch());
                    }
                }
            }
        }
    }

    public String aPp() {
        return this.ezk;
    }

    public int aPq() {
        return this.ezo;
    }
}
