package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bl;
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
    private int bLe;
    private com.baidu.tieba.tbadkCore.d.b bXR;
    private BaseActivity bll;
    private final CheckRealNameModel bmN;
    private long cta;
    private int dHV;
    private com.baidu.adp.framework.listener.a dIf;
    private boolean dWY;
    protected String eJA;
    private String eJB;
    private boolean eJC;
    private boolean eJD;
    private boolean eJE;
    private boolean eJF;
    private long eJG;
    private int eJH;
    private int eJI;
    private int eJJ;
    private boolean eJK;
    private boolean eJL;
    private boolean eJM;
    private long eJN;
    private boolean eJO;
    private String eJP;
    protected com.baidu.tieba.pb.data.f eJQ;
    private int eJR;
    private boolean eJS;
    private boolean eJT;
    private boolean eJU;
    private boolean eJV;
    private a eJW;
    private String eJX;
    private String eJY;
    private int eJZ;
    private PraiseData eKA;
    private int eKa;
    private boolean eKb;
    private boolean eKc;
    private boolean eKd;
    private boolean eKe;
    private boolean eKf;
    private String eKg;
    private long eKh;
    private boolean eKi;
    private int eKj;
    private boolean eKk;
    private boolean eKl;
    private int eKm;
    private final u eKn;
    private final t eKo;
    private final i eKp;
    private final m eKq;
    private final PbFloorAgreeModel eKr;
    private final w eKs;
    private String eKt;
    private final AddExperiencedModel eKu;
    private SuggestEmotionModel eKv;
    private boolean eKw;
    private int eKx;
    private CustomMessageListener eKy;
    private CustomMessageListener eKz;
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
    private static final int eJz = com.baidu.tbadk.data.c.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.f fVar);
    }

    public void jg(boolean z) {
        this.eKi = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eJA = null;
        this.eJB = null;
        this.mForumId = null;
        this.eJC = false;
        this.eJD = false;
        this.eJE = true;
        this.eJF = true;
        this.mIsGood = 0;
        this.dHV = 0;
        this.eJG = 0L;
        this.eJH = 1;
        this.eJI = 1;
        this.eJJ = 1;
        this.bLe = 1;
        this.isAd = false;
        this.eJK = false;
        this.eJL = false;
        this.dWY = false;
        this.isFromMark = false;
        this.eJM = false;
        this.eJN = 0L;
        this.eJO = false;
        this.eJP = null;
        this.eJQ = null;
        this.isLoading = false;
        this.eJS = false;
        this.eJT = false;
        this.eJU = false;
        this.eJV = false;
        this.mLocate = null;
        this.mContext = null;
        this.eJW = null;
        this.opType = null;
        this.opUrl = null;
        this.eJX = null;
        this.eJY = null;
        this.eJZ = -1;
        this.eKa = -1;
        this.bXR = null;
        this.eKc = false;
        this.eKd = false;
        this.postID = null;
        this.eKg = null;
        this.eKh = 0L;
        this.eKi = false;
        this.eKj = -1;
        this.eKl = false;
        this.eKw = false;
        this.eKx = 0;
        this.eKy = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.eKf = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.k(pbData);
                    PbModel.this.e(pbData);
                    if (pbData.aOY() != null) {
                        pbData.aOY().bO(0);
                    }
                    if (PbModel.this.eJW != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.eJW.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.eKz = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aOW() != null && PbModel.this.getPbData().aOW().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aOW().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.dIf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.i.hh()) {
                        PbModel.this.bll.showToast(responsedMessage.getErrorString());
                    }
                    if (responsedMessage instanceof pbPageSocketResponseMessage) {
                        pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                        PbModel.this.a(pbpagesocketresponsemessage);
                        pbpagesocketresponsemessage.getDownSize();
                    }
                    if (!(responsedMessage instanceof pbPageHttpResponseMessage)) {
                        z = false;
                    } else {
                        pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                        PbModel.this.a(pbpagehttpresponsemessage);
                        pbpagehttpresponsemessage.getDownSize();
                        z = true;
                    }
                    if (responsedMessage.getError() != 0) {
                        if (z) {
                            j = 0;
                        } else {
                            j = ((pbPageSocketResponseMessage) responsedMessage).sequenceID;
                        }
                        PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getExtra();
                        long clientLogID = responsedMessage.getOrginalMessage().getClientLogID();
                        int cmd = responsedMessage.getOrginalMessage().getCmd();
                        int error = responsedMessage.getError();
                        String errorString = responsedMessage.getErrorString();
                        Object[] objArr = new Object[6];
                        objArr[0] = "updateType";
                        objArr[1] = pbPageRequestMessage != null ? String.valueOf(pbPageRequestMessage.getUpdateType()) : null;
                        objArr[2] = "ThreadId";
                        objArr[3] = pbPageRequestMessage != null ? String.valueOf(pbPageRequestMessage.get_kz()) : null;
                        objArr[4] = "seq_id";
                        objArr[5] = Long.valueOf(j);
                        com.baidu.tbadk.core.d.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    }
                    if (!PbModel.this.eKc || !PbModel.this.eKd) {
                        if (!PbModel.this.eKc) {
                            PbModel.this.eKc = true;
                        } else {
                            PbModel.this.eKd = true;
                        }
                        if (PbModel.this.eJW != null) {
                            PbModel.this.eJW.a(PbModel.this.aRk(), z, responsedMessage, PbModel.this.eKe, System.currentTimeMillis() - PbModel.this.cta);
                        }
                    }
                }
            }
        };
        this.eKA = null;
        registerListener(this.eKy);
        registerListener(this.dIf);
        registerListener(this.eKz);
        this.eJQ = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bll = baseActivity;
        this.eKn = new u(this, this.bll);
        this.eKo = new t(this, this.bll);
        this.eKp = new i(this, this.bll);
        this.eKq = new m(this, this.bll);
        this.eKr = new PbFloorAgreeModel(this);
        this.eKs = new w(this, this.bll);
        this.bmN = new CheckRealNameModel(this.bll.getPageContext());
        this.eKv = new SuggestEmotionModel();
        this.eKu = new AddExperiencedModel(this.bll.getPageContext());
    }

    protected int aRk() {
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
        this.eJA = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eJA)) {
            this.eJA = this.eKn.W(intent);
        }
        this.eKx = intent.getIntExtra(PbActivityConfig.KEY_START_FROM, 0);
        this.eJB = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eJC = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eJD = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eJF = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dHV = intent.getIntExtra("is_top", 0);
        this.eJG = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eJM = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eJK = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eJO = intent.getBooleanExtra("is_pv", false);
        this.eJN = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eJP = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eJY = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.eJX = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.eJS = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eJT = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eJU = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eKa = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eJZ = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eJL = intent.getBooleanExtra("from_frs", false);
        this.dWY = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eKl = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eJV = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
        this.eKt = intent.getStringExtra(PbActivityConfig.KEY_POST_THREAD_TIP);
    }

    public void initWithBundle(Bundle bundle) {
        this.eKx = bundle.getInt(PbActivityConfig.KEY_START_FROM, 0);
        this.eJA = bundle.getString("thread_id");
        this.eJB = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eJC = bundle.getBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eJD = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eJF = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dHV = bundle.getInt("is_top", 0);
        this.eJG = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eJM = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eJK = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eJO = bundle.getBoolean("is_pv", false);
        this.eJN = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eJP = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eJY = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.eJS = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eJT = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eJU = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eKa = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eJZ = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eJL = bundle.getBoolean("from_frs", false);
        this.dWY = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eKl = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eJV = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void r(Bundle bundle) {
        bundle.putString("thread_id", this.eJA);
        bundle.putString("post_id", this.eJB);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt(PbActivityConfig.KEY_START_FROM, this.eKx);
        bundle.putBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, this.eJC);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.eJD);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.eJF);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dHV);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.eJG);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.eJM);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.eJK);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eJO);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.eJN);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.eJY);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.eJS);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.eJT);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.eJU);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.eKa);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.eJZ);
        bundle.putBoolean("from_frs", this.eJL);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.dWY);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.eKl);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.eJV);
    }

    public String aRl() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eJA);
        if (!this.eJM) {
            sb.append(this.eJB);
        }
        sb.append(this.eJD);
        sb.append(this.eJF);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.dHV);
        sb.append(this.eJG);
        sb.append(this.eJL);
        sb.append(this.dWY);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eJK);
        sb.append(this.eJO);
        sb.append(this.eJN);
        sb.append(this.eJP);
        sb.append(this.mThreadType);
        sb.append(this.eJS);
        sb.append(this.eJT);
        sb.append(this.eJU);
        if (this.eJY != null) {
            sb.append(this.eJY);
        }
        return sb.toString();
    }

    public String aRm() {
        return this.eJP;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eJB;
    }

    public void pl(String str) {
        this.eJB = str;
    }

    public String getThreadID() {
        return this.eJA;
    }

    public boolean getHostMode() {
        return this.eJD;
    }

    public boolean aRn() {
        return this.eJF;
    }

    public boolean aRo() {
        return this.eJL;
    }

    public boolean aRp() {
        return this.dWY;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aRq() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aAQ() {
        return this.dHV;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void hE(int i) {
        this.dHV = i;
    }

    public boolean aRr() {
        return this.eJK;
    }

    public boolean aRs() {
        if (this.eJQ == null) {
            return false;
        }
        return this.eJQ.isValid();
    }

    public String rE() {
        if (this.eJQ == null || !this.eJQ.nB()) {
            return null;
        }
        return this.eJQ.nA();
    }

    public boolean oZ(int i) {
        this.eJH = i;
        if (this.eJH > this.eJQ.qx().qo()) {
            this.eJH = this.eJQ.qx().qo();
        }
        if (this.eJH < 1) {
            this.eJH = 1;
        }
        if (this.eJA == null) {
            return false;
        }
        return pd(5);
    }

    public boolean pa(int i) {
        int sj = this.eJQ.aOY().sj();
        if (i <= sj) {
            sj = i;
        }
        int i2 = sj >= 1 ? sj : 1;
        if (this.eJA == null) {
            return false;
        }
        this.eKj = i2;
        return pd(7);
    }

    public void pb(int i) {
        this.eJH = i;
        this.eJI = i;
        this.eJJ = i;
    }

    public void pc(int i) {
        if (this.eJI < i) {
            this.eJI = i;
            if (this.eJI - this.eJJ >= eJz) {
                this.eJJ = (this.eJI - eJz) + 1;
            }
        }
        if (this.eJJ > i) {
            this.eJJ = i;
            if (this.eJI - this.eJJ >= eJz) {
                this.eJI = (this.eJJ + eJz) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eJQ;
    }

    public com.baidu.tbadk.core.data.ar aqb() {
        if (this.eJQ == null) {
            return null;
        }
        return this.eJQ.qx();
    }

    public boolean aRt() {
        if (this.eJF && this.eJQ.qx().qt() == 0) {
            jh(true);
            return true;
        }
        return false;
    }

    public void pf(String str) {
        if (!StringUtils.isNull(str)) {
            this.eJA = str;
            this.eJB = null;
            this.eJD = false;
            this.eJF = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eJA == null) {
            return false;
        }
        cancelLoadData();
        if (this.bXR == null) {
            this.bXR = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bXR.start();
        }
        boolean pd = pd(3);
        if (this.opType != null) {
            this.opType = null;
            this.eJX = null;
            this.opUrl = null;
            return pd;
        }
        return pd;
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
        if (this.eKv != null) {
            this.eKv.cancelLoadData();
        }
        if (this.eKr != null) {
            this.eKr.cancelLoadData();
        }
        abP();
    }

    private void abP() {
        if (this.bXR != null) {
            this.bXR.destory();
            this.bXR = null;
        }
    }

    public boolean Fo() {
        return (this.eJB == null || this.eJB.equals("0") || this.eJB.length() == 0) ? LoadData() : aRw();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        if (forumData != null && !TextUtils.isEmpty(forumData.getId()) && !TextUtils.isEmpty(forumData.getName())) {
            this.eKv.a(forumData.getId(), forumData.getName(), aVar);
        }
    }

    public boolean pd(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        pe(i);
        final com.baidu.tieba.pb.data.f pbData = ai.aSy().getPbData();
        if (pbData != null && pbData.aOY() != null) {
            pbData.aOY().bO(0);
            this.eJF = ai.aSy().aRn();
            this.eJD = ai.aSy().aSA();
            this.eKw = this.eJD;
            if (this.eJD || this.isFromMark) {
                this.eKb = false;
            }
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.eKf) {
            a(aRB(), true, this.eJB, 3);
        }
        if (i == 3 && !this.eKf) {
            if (this.isFromMark) {
                a(aRB(), true, this.eJB, 3);
            } else {
                a(aRB(), false, this.eJB, 3);
            }
        }
        this.eKf = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.azN);
        if (this.eJD || this.isFromMark) {
            this.eKb = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eJA == null || this.eJA.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eJA, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.am.vG().vI() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.eJF) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eJD) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eJO) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eJN));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eKb) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eJX, 0));
            pbPageRequestMessage.setOpMessageID(this.eJN);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aPa = this.eJQ.aPa();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eJF) {
                        if (this.eJJ - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eJJ - 1));
                        }
                    } else if (this.eJI < this.bLe) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eJI + 1));
                    }
                }
                if (aPa != null && aPa.size() > 0) {
                    int size = aPa.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aPa.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.eJB = postData.getId();
                            if (StringUtils.isNull(this.eJB)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.eJB != null && this.eJB.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eJB, 0L));
                } else if (!this.eJF) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aPa != null && aPa.size() > 0 && aPa.get(0) != null) {
                    this.eJB = aPa.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eJF) {
                        if (this.eJJ - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eJJ - 1));
                        }
                    } else if (this.eJI < this.bLe) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eJI + 1));
                    }
                }
                if (this.eJB != null && this.eJB.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eJB, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eJF) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eJB, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eJH));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eJF && this.eKw && !this.eJD) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eJB, 0L));
                }
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eKj);
                b(pbPageRequestMessage);
                break;
        }
        this.eKw = this.eJD;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aRB());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bll != null && (this.bll instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bll).aPZ());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.eKi);
        pbPageRequestMessage.setFromSmartFrs(this.eKl ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eJC);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aRm()) && com.baidu.tieba.recapp.r.bhv().bhr() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bhv().bhr().W(aRm(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bhv().bhr().X(aRm(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aRm()) && com.baidu.tieba.recapp.r.bhv().bhr() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bhv().bhr().X(aRm(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bhv().bhr().W(aRm(), true));
        }
    }

    protected void pe(int i) {
        boolean z = false;
        ArrayList<PostData> aPa = this.eJQ.aPa();
        this.eKe = false;
        if (i == 1) {
            boolean z2 = false;
            while (aPa.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                aPa.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eJQ.qx().bK(1);
                if (this.eJW != null) {
                    this.eJW.c(this.eJQ);
                }
            }
            this.cta = System.currentTimeMillis();
            this.eKe = true;
        } else if (i == 2) {
            while (aPa.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                aPa.remove(aPa.size() - 1);
                z = true;
            }
            if (z) {
                this.eJQ.qx().bJ(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.eKm = i2;
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

    protected void e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            if (this.eJU || this.eJS || this.eJT) {
                fVar = g(fVar);
            }
            f(fVar);
        }
    }

    protected void f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String h = h(fVar);
            for (int i = 0; i < fVar.aPa().size(); i++) {
                PostData postData = fVar.aPa().get(i);
                for (int i2 = 0; i2 < postData.bso().size(); i2++) {
                    postData.bso().get(i2).a(this.bll.getPageContext(), h.equals(postData.bso().get(i2).getAuthor().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.o aPi = fVar.aPi();
            if (aPi != null && !com.baidu.tbadk.core.util.u.v(aPi.eDB)) {
                for (PostData postData2 : aPi.eDB) {
                    for (int i3 = 0; i3 < postData2.bso().size(); i3++) {
                        postData2.bso().get(i3).a(this.bll.getPageContext(), h.equals(postData2.bso().get(i3).getAuthor().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String h = h(fVar);
            com.baidu.tieba.pb.data.o aPi = fVar.aPi();
            if (aPi != null && !com.baidu.tbadk.core.util.u.v(aPi.eDB)) {
                for (PostData postData : aPi.eDB.subList(i, aPi.eDB.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bso().size()) {
                            postData.bso().get(i3).a(this.bll.getPageContext(), h.equals(postData.bso().get(i3).getAuthor().getUserId()));
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
        bl aOY = fVar.aOY();
        aOY.bS(this.mIsGood);
        aOY.bR(this.dHV);
        if (this.eJG > 0) {
            aOY.m(this.eJG);
            return fVar;
        }
        return fVar;
    }

    protected String h(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aOY() != null && fVar.aOY().getAuthor() != null) {
            str = fVar.aOY().getAuthor().getUserId();
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
        if (fVar.aOY() != null && fVar.aOY().getAuthor() != null) {
            str = fVar.aOY().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String j(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aOY() != null && fVar.aOY().getAuthor() != null) {
            str = fVar.aOY().getAuthor().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aRu() {
        if (this.eJQ == null || this.eJQ.aOY() == null || this.eJQ.aOY().getAuthor() == null) {
            return null;
        }
        return this.eJQ.aOY().getAuthor();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.eKk = z3;
        this.eJR = i;
        if (this.bXR != null && !z3) {
            this.bXR.a(z2, z4, i2, str, i3, j, j2);
            this.bXR = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aRm()) && com.baidu.tieba.recapp.r.bhv().bhr() != null) {
            com.baidu.tieba.recapp.r.bhv().bhr().g(aRm(), pf(aRD()), true);
        }
        if (fVar == null || (this.eJH == 1 && i == 5 && fVar.aPa() != null && fVar.aPa().size() < 1)) {
            if (this.eJW != null) {
                this.eJF = this.eJE;
                this.eJW.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eJE = this.eJF;
            this.eJO = false;
            if (fVar.qx() != null) {
                pc(fVar.qx().qr());
                this.bLe = fVar.qx().qo();
            }
            this.bLe = this.bLe < 1 ? 1 : this.bLe;
            int i5 = 0;
            ArrayList<PostData> aPa = this.eJQ.aPa();
            switch (i) {
                case 1:
                    this.eJQ.a(fVar.qx(), 1);
                    d(fVar, aPa);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aPa() != null) {
                        int size = fVar.aPa().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(aPa, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPa(), com.baidu.tbadk.core.util.u.u(fVar.aPa()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aPa().remove(postData2);
                            i5 = size - 1;
                        }
                        aPa.addAll(0, fVar.aPa());
                    }
                    this.eJQ.a(fVar.qx(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.eJF && fVar.qx() != null) {
                        fVar.qx().bH(fVar.qx().qo());
                    }
                    k(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eJF) {
                        aRv();
                        i4 = 0;
                        break;
                    }
                    i4 = 0;
                    break;
                case 4:
                    k(fVar);
                    i4 = 0;
                    break;
                case 5:
                    k(fVar);
                    i4 = 0;
                    break;
                case 6:
                    k(fVar);
                    i4 = 0;
                    break;
                case 7:
                    k(fVar);
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.eJQ != null && this.eJQ.aOY() != null) {
                PraiseData rl = this.eJQ.aOY().rl();
                if (this.eKA != null && !rl.isPriaseDataValid()) {
                    this.eJQ.aOY().a(this.eKA);
                } else {
                    this.eKA = this.eJQ.aOY().rl();
                    this.eKA.setPostId(this.eJQ.aOY().rL());
                }
                if (fVar.qx() != null && fVar.qx().qr() == 1 && fVar.aOY() != null && fVar.aOY().rG() != null && fVar.aOY().rG().size() > 0) {
                    this.eJQ.aOY().h(fVar.aOY().rG());
                }
                this.eJQ.aOY().bP(fVar.aOY().rn());
                this.eJQ.aOY().bN(fVar.aOY().getAnchorLevel());
                this.eJQ.aOY().bO(fVar.aOY().ri());
                if (this.mThreadType == 33) {
                    this.eJQ.aOY().getAuthor().setHadConcerned(fVar.aOY().getAuthor().hadConcerned());
                }
            }
            if (this.eJQ != null && this.eJQ.getUserData() != null && fVar.getUserData() != null) {
                this.eJQ.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eJQ.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qx() != null && fVar.qx().qr() == 1 && fVar.aPh() != null) {
                this.eJQ.e(fVar.aPh());
            }
            if (this.eKk && this.eJQ.aOY() != null && this.eJQ.aOY().getAuthor() != null && this.eJQ.aPa() != null && com.baidu.tbadk.core.util.u.c(this.eJQ.aPa(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.u.c(this.eJQ.aPa(), 0);
                MetaData author = this.eJQ.aOY().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.eJZ != -1) {
                        author.setFansNum(this.eJZ);
                        postData3.getAuthor().setFansNum(this.eJZ);
                    }
                    if (this.eKa != -1) {
                        author.getGodUserData().setIsLike(this.eKa == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.eKa == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eJQ != null && this.eJQ.aOU() != null && fVar.aOU() != null) {
                this.eJQ.aOU().o(fVar.aOU().getItems());
                this.eJQ.aOU().an(fVar.aOU().pX());
            }
            if (this.eJW != null) {
                this.eJW.a(true, getErrorCode(), i, i4, this.eJQ, this.mErrorString, 1);
            }
        }
        if (this.eJQ != null && this.eJQ.aOY() != null && this.eJQ.aOW() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bll;
            historyMessage.threadId = getPbData().aOY().getId();
            historyMessage.forumName = getPbData().aOW().getName();
            historyMessage.threadName = getPbData().aOY().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aRn();
            historyMessage.threadType = getPbData().aOY().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String al;
        if (arrayList != null && fVar.aPa() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPa(), 0);
            if (postData != null && (al = al(arrayList)) != null && al.equals(postData.getId())) {
                fVar.aPa().remove(postData);
            }
            arrayList.addAll(fVar.aPa());
        }
    }

    private int pf(int i) {
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
        int u = com.baidu.tbadk.core.util.u.u(arrayList);
        if (u <= 0) {
            return null;
        }
        for (int i = u - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(com.baidu.tieba.pb.data.f fVar) {
        fVar.pd(this.eJQ.aPp());
        this.eJQ = fVar;
        pb(fVar.qx().qr());
    }

    private void aRv() {
        if (this.eJQ != null && this.eJQ.aPa() != null && this.eJQ.aPn() != null) {
            ArrayList<PostData> aPa = this.eJQ.aPa();
            com.baidu.tieba.pb.data.a aPn = this.eJQ.aPn();
            int aON = aPn.aON();
            if (aON > 0) {
                if (aON <= aPa.size()) {
                    aPa.add(aON, aPn);
                } else {
                    aPa.add(aPn);
                }
            }
        }
    }

    public boolean aRw() {
        if (this.eJA == null || this.eJB == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return pd(4);
        }
        return pd(6);
    }

    public boolean jh(boolean z) {
        if (this.eJA == null || this.eJQ == null) {
            return false;
        }
        if (z || this.eJQ.qx().qt() != 0) {
            return pd(1);
        }
        return false;
    }

    public boolean ji(boolean z) {
        if (this.eJA == null || this.eJQ == null) {
            return false;
        }
        if ((z || this.eJQ.qx().qu() != 0) && this.eJQ.aPa() != null && this.eJQ.aPa().size() >= 1) {
            return pd(2);
        }
        return false;
    }

    public boolean pm(String str) {
        this.eJD = !this.eJD;
        this.eJB = str;
        pd(6);
        return true;
    }

    public boolean i(boolean z, String str) {
        if (this.eJD == z) {
            return false;
        }
        this.eJD = z;
        this.eJB = str;
        pd(6);
        return true;
    }

    public boolean aRx() {
        if (com.baidu.adp.lib.util.i.hh()) {
            this.eJE = this.eJF;
            this.eJF = !this.eJF;
        }
        return LoadData();
    }

    public boolean jj(boolean z) {
        if (this.eJF == z) {
            return false;
        }
        if (com.baidu.adp.lib.util.i.hh()) {
            this.eJE = z;
            this.eJF = z;
        }
        return LoadData();
    }

    public boolean aRy() {
        return this.eJF;
    }

    public boolean hasData() {
        return (this.eJQ == null || this.eJQ.aOW() == null || this.eJQ.aOY() == null) ? false : true;
    }

    public boolean nB() {
        if (this.eJQ == null) {
            return false;
        }
        return this.eJQ.nB();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fM(String str) {
        if (this.eJQ == null || this.eJQ.aOY() == null || this.eJQ.aOW() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eJQ.aOY().sH()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eJQ.aOW().getId());
            writeData.setForumName(this.eJQ.aOW().getName());
        }
        writeData.setThreadId(this.eJA);
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

    public MarkData pg(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.eJQ == null) {
            return null;
        }
        ArrayList<PostData> aPa = this.eJQ.aPa();
        if (com.baidu.tbadk.core.util.u.v(aPa)) {
            return null;
        }
        if (aPa.size() > 0 && i >= aPa.size()) {
            i = aPa.size() - 1;
        }
        return j(aPa.get(i));
    }

    public MarkData aRz() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eJA);
        markData.setPostId(this.eJQ.nA());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eJD);
        markData.setSequence(Boolean.valueOf(this.eJF));
        markData.setId(this.eJA);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eJA);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eJD);
        markData.setSequence(Boolean.valueOf(this.eJF));
        markData.setId(this.eJA);
        markData.setFloor(postData.bsr());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aRA() {
        h.aRb().Q(aRB(), this.isFromMark);
    }

    private String aRB() {
        String str = this.eJA;
        if (this.eJD) {
            str = str + DB_KEY_HOST;
        }
        if (!this.eJF) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jk(boolean z) {
        if (this.eJQ != null) {
            this.eJQ.ac(z);
        }
    }

    public void jl(boolean z) {
        this.eKb = z;
    }

    public boolean aRC() {
        return this.eKb;
    }

    public void a(a aVar) {
        this.eJW = aVar;
    }

    public void od(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dn() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dm() {
        return Fo();
    }

    public boolean pn(String str) {
        if (getPbData() == null || getPbData().aOY() == null || getPbData().aOY().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aOY().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aRD() {
        return this.mRequestType;
    }

    public void aRE() {
        String aRB = aRB();
        h.aRb().Q(aRB, false);
        h.aRb().Q(aRB, true);
    }

    public void aRF() {
        if ("personalize_page".equals(this.mStType)) {
            this.eKh = System.currentTimeMillis() / 1000;
        }
    }

    public void aRG() {
        if ("personalize_page".equals(this.mStType) && this.eJQ != null && this.eKh != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10754").aa("fid", this.eJQ.getForumId()).aa("tid", this.eJA).aa("obj_duration", String.valueOf(currentTimeMillis - this.eKh)).aa("obj_param3", String.valueOf(currentTimeMillis)));
            this.eKh = 0L;
        }
    }

    public boolean aRH() {
        return this.eKk;
    }

    public int aRI() {
        return this.eJR;
    }

    public int getErrorNo() {
        return this.eKm;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public t aRJ() {
        return this.eKo;
    }

    public i aRK() {
        return this.eKp;
    }

    public m aRL() {
        return this.eKq;
    }

    public PbFloorAgreeModel aRM() {
        return this.eKr;
    }

    public w aRN() {
        return this.eKs;
    }

    public CheckRealNameModel aRO() {
        return this.bmN;
    }

    public AddExperiencedModel aRP() {
        return this.eKu;
    }

    public String aRQ() {
        return this.eKg;
    }

    public void po(String str) {
        this.eKg = str;
    }

    public boolean aRR() {
        return this.eKl;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.eJQ != null && this.eJQ.aPa() != null && this.eJQ.aPa().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eJQ.aPa().size();
                for (int i = 0; i < size; i++) {
                    if (this.eJQ.aPa().get(i) != null && this.eJQ.aPa().get(i).getAuthor() != null && currentAccount.equals(this.eJQ.aPa().get(i).getAuthor().getUserId()) && this.eJQ.aPa().get(i).getAuthor().getPendantData() != null) {
                        this.eJQ.aPa().get(i).getAuthor().getPendantData().cB(jVar.pL());
                        this.eJQ.aPa().get(i).getAuthor().getPendantData().Q(jVar.Ct());
                    }
                }
            }
        }
    }

    public String aRS() {
        return this.eKt;
    }

    public int aRT() {
        return this.eKx;
    }
}
