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
    private int bMY;
    private com.baidu.tieba.tbadkCore.d.b bZK;
    private BaseActivity bmG;
    private final CheckRealNameModel boy;
    private long cwy;
    private int dLi;
    private com.baidu.adp.framework.listener.a dLs;
    protected String eMJ;
    private String eMK;
    private boolean eML;
    private boolean eMM;
    private boolean eMN;
    private boolean eMO;
    private long eMP;
    private int eMQ;
    private int eMR;
    private int eMS;
    private boolean eMT;
    private boolean eMU;
    private boolean eMV;
    private long eMW;
    private boolean eMX;
    private String eMY;
    protected com.baidu.tieba.pb.data.f eMZ;
    private final PbFloorAgreeModel eNA;
    private final w eNB;
    private String eNC;
    private final AddExperiencedModel eND;
    private SuggestEmotionModel eNE;
    private boolean eNF;
    private int eNG;
    private CustomMessageListener eNH;
    private CustomMessageListener eNI;
    private PraiseData eNJ;
    private int eNa;
    private boolean eNb;
    private boolean eNc;
    private boolean eNd;
    private boolean eNe;
    private a eNf;
    private String eNg;
    private String eNh;
    private int eNi;
    private int eNj;
    private boolean eNk;
    private boolean eNl;
    private boolean eNm;
    private boolean eNn;
    private boolean eNo;
    private String eNp;
    private long eNq;
    private boolean eNr;
    private int eNs;
    private boolean eNt;
    private boolean eNu;
    private int eNv;
    private final u eNw;
    private final t eNx;
    private final i eNy;
    private final m eNz;
    private boolean eal;
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
    private static final int eMI = com.baidu.tbadk.data.c.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.f fVar);
    }

    public void jj(boolean z) {
        this.eNr = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eMJ = null;
        this.eMK = null;
        this.mForumId = null;
        this.eML = false;
        this.eMM = false;
        this.eMN = true;
        this.eMO = true;
        this.mIsGood = 0;
        this.dLi = 0;
        this.eMP = 0L;
        this.eMQ = 1;
        this.eMR = 1;
        this.eMS = 1;
        this.bMY = 1;
        this.isAd = false;
        this.eMT = false;
        this.eMU = false;
        this.eal = false;
        this.isFromMark = false;
        this.eMV = false;
        this.eMW = 0L;
        this.eMX = false;
        this.eMY = null;
        this.eMZ = null;
        this.isLoading = false;
        this.eNb = false;
        this.eNc = false;
        this.eNd = false;
        this.eNe = false;
        this.mLocate = null;
        this.mContext = null;
        this.eNf = null;
        this.opType = null;
        this.opUrl = null;
        this.eNg = null;
        this.eNh = null;
        this.eNi = -1;
        this.eNj = -1;
        this.bZK = null;
        this.eNl = false;
        this.eNm = false;
        this.postID = null;
        this.eNp = null;
        this.eNq = 0L;
        this.eNr = false;
        this.eNs = -1;
        this.eNu = false;
        this.eNF = false;
        this.eNG = 0;
        this.eNH = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.eNo = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.k(pbData);
                    PbModel.this.e(pbData);
                    if (pbData.aPL() != null) {
                        pbData.aPL().bQ(0);
                    }
                    if (PbModel.this.eNf != null && pbData != null) {
                        com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.eNf.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.eNI = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aPJ() != null && PbModel.this.getPbData().aPJ().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aPJ().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.dLs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.i.hr()) {
                        PbModel.this.bmG.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.eNl || !PbModel.this.eNm) {
                        if (!PbModel.this.eNl) {
                            PbModel.this.eNl = true;
                        } else {
                            PbModel.this.eNm = true;
                        }
                        if (PbModel.this.eNf != null) {
                            PbModel.this.eNf.a(PbModel.this.aRX(), z, responsedMessage, PbModel.this.eNn, System.currentTimeMillis() - PbModel.this.cwy);
                        }
                    }
                }
            }
        };
        this.eNJ = null;
        registerListener(this.eNH);
        registerListener(this.dLs);
        registerListener(this.eNI);
        this.eMZ = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bmG = baseActivity;
        this.eNw = new u(this, this.bmG);
        this.eNx = new t(this, this.bmG);
        this.eNy = new i(this, this.bmG);
        this.eNz = new m(this, this.bmG);
        this.eNA = new PbFloorAgreeModel(this);
        this.eNB = new w(this, this.bmG);
        this.boy = new CheckRealNameModel(this.bmG.getPageContext());
        this.eNE = new SuggestEmotionModel();
        this.eND = new AddExperiencedModel(this.bmG.getPageContext());
    }

    protected int aRX() {
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
        this.eMJ = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eMJ)) {
            this.eMJ = this.eNw.Y(intent);
        }
        this.eNG = intent.getIntExtra(PbActivityConfig.KEY_START_FROM, 0);
        this.eMK = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eML = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eMM = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eMO = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dLi = intent.getIntExtra("is_top", 0);
        this.eMP = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eMV = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eMT = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eMX = intent.getBooleanExtra("is_pv", false);
        this.eMW = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eMY = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eNh = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.eNg = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.eNb = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eNc = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eNd = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eNj = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eNi = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eMU = intent.getBooleanExtra("from_frs", false);
        this.eal = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eNu = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eNe = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
        this.eNC = intent.getStringExtra(PbActivityConfig.KEY_POST_THREAD_TIP);
    }

    public void initWithBundle(Bundle bundle) {
        this.eNG = bundle.getInt(PbActivityConfig.KEY_START_FROM, 0);
        this.eMJ = bundle.getString("thread_id");
        this.eMK = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eML = bundle.getBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eMM = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eMO = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dLi = bundle.getInt("is_top", 0);
        this.eMP = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eMV = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eMT = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eMX = bundle.getBoolean("is_pv", false);
        this.eMW = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eMY = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eNh = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.eNb = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eNc = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eNd = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eNj = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eNi = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eMU = bundle.getBoolean("from_frs", false);
        this.eal = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eNu = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eNe = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void q(Bundle bundle) {
        bundle.putString("thread_id", this.eMJ);
        bundle.putString("post_id", this.eMK);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt(PbActivityConfig.KEY_START_FROM, this.eNG);
        bundle.putBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, this.eML);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.eMM);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.eMO);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dLi);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.eMP);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.eMV);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.eMT);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eMX);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.eMW);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.eNh);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.eNb);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.eNc);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.eNd);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.eNj);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.eNi);
        bundle.putBoolean("from_frs", this.eMU);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.eal);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.eNu);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.eNe);
    }

    public String aRY() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eMJ);
        if (!this.eMV) {
            sb.append(this.eMK);
        }
        sb.append(this.eMM);
        sb.append(this.eMO);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.dLi);
        sb.append(this.eMP);
        sb.append(this.eMU);
        sb.append(this.eal);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eMT);
        sb.append(this.eMX);
        sb.append(this.eMW);
        sb.append(this.eMY);
        sb.append(this.mThreadType);
        sb.append(this.eNb);
        sb.append(this.eNc);
        sb.append(this.eNd);
        if (this.eNh != null) {
            sb.append(this.eNh);
        }
        return sb.toString();
    }

    public String aRZ() {
        return this.eMY;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eMK;
    }

    public void py(String str) {
        this.eMK = str;
    }

    public String getThreadID() {
        return this.eMJ;
    }

    public boolean getHostMode() {
        return this.eMM;
    }

    public boolean aSa() {
        return this.eMO;
    }

    public boolean aSb() {
        return this.eMU;
    }

    public boolean aSc() {
        return this.eal;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aSd() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aBD() {
        return this.dLi;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void hG(int i) {
        this.dLi = i;
    }

    public boolean aSe() {
        return this.eMT;
    }

    public boolean aSf() {
        if (this.eMZ == null) {
            return false;
        }
        return this.eMZ.isValid();
    }

    public String rP() {
        if (this.eMZ == null || !this.eMZ.nM()) {
            return null;
        }
        return this.eMZ.nL();
    }

    public boolean pi(int i) {
        this.eMQ = i;
        if (this.eMQ > this.eMZ.qI().qz()) {
            this.eMQ = this.eMZ.qI().qz();
        }
        if (this.eMQ < 1) {
            this.eMQ = 1;
        }
        if (this.eMJ == null) {
            return false;
        }
        return pm(5);
    }

    public boolean pj(int i) {
        int su = this.eMZ.aPL().su();
        if (i <= su) {
            su = i;
        }
        int i2 = su >= 1 ? su : 1;
        if (this.eMJ == null) {
            return false;
        }
        this.eNs = i2;
        return pm(7);
    }

    public void pk(int i) {
        this.eMQ = i;
        this.eMR = i;
        this.eMS = i;
    }

    public void pl(int i) {
        if (this.eMR < i) {
            this.eMR = i;
            if (this.eMR - this.eMS >= eMI) {
                this.eMS = (this.eMR - eMI) + 1;
            }
        }
        if (this.eMS > i) {
            this.eMS = i;
            if (this.eMR - this.eMS >= eMI) {
                this.eMR = (this.eMS + eMI) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eMZ;
    }

    public com.baidu.tbadk.core.data.ar aqO() {
        if (this.eMZ == null) {
            return null;
        }
        return this.eMZ.qI();
    }

    public boolean aSg() {
        if (this.eMO && this.eMZ.qI().qE() == 0) {
            jk(true);
            return true;
        }
        return false;
    }

    public void ps(String str) {
        if (!StringUtils.isNull(str)) {
            this.eMJ = str;
            this.eMK = null;
            this.eMM = false;
            this.eMO = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eMJ == null) {
            return false;
        }
        cancelLoadData();
        if (this.bZK == null) {
            this.bZK = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bZK.start();
        }
        boolean pm = pm(3);
        if (this.opType != null) {
            this.opType = null;
            this.eNg = null;
            this.opUrl = null;
            return pm;
        }
        return pm;
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
        if (this.eNE != null) {
            this.eNE.cancelLoadData();
        }
        if (this.eNA != null) {
            this.eNA.cancelLoadData();
        }
        acl();
    }

    private void acl() {
        if (this.bZK != null) {
            this.bZK.destory();
            this.bZK = null;
        }
    }

    public boolean Fw() {
        return (this.eMK == null || this.eMK.equals("0") || this.eMK.length() == 0) ? LoadData() : aSj();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        if (forumData != null && !TextUtils.isEmpty(forumData.getId()) && !TextUtils.isEmpty(forumData.getName())) {
            this.eNE.a(forumData.getId(), forumData.getName(), aVar);
        }
    }

    public boolean pm(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        pn(i);
        final com.baidu.tieba.pb.data.f pbData = ai.aTl().getPbData();
        if (pbData != null && pbData.aPL() != null) {
            pbData.aPL().bQ(0);
            this.eMO = ai.aTl().aSa();
            this.eMM = ai.aTl().aTn();
            this.eNF = this.eMM;
            if (this.eMM || this.isFromMark) {
                this.eNk = false;
            }
            com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.eNo) {
            a(aSo(), true, this.eMK, 3);
        }
        if (i == 3 && !this.eNo) {
            if (this.isFromMark) {
                a(aSo(), true, this.eMK, 3);
            } else {
                a(aSo(), false, this.eMK, 3);
            }
        }
        this.eNo = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aBg);
        if (this.eMM || this.isFromMark) {
            this.eNk = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eMJ == null || this.eMJ.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.eMJ, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getApp());
        int ah = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.am.vR().vT() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.eMO) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eMM) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eMX) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eMW));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eNk) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eNg, 0));
            pbPageRequestMessage.setOpMessageID(this.eMW);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aPN = this.eMZ.aPN();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eMO) {
                        if (this.eMS - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eMS - 1));
                        }
                    } else if (this.eMR < this.bMY) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eMR + 1));
                    }
                }
                if (aPN != null && aPN.size() > 0) {
                    int size = aPN.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aPN.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.eMK = postData.getId();
                            if (StringUtils.isNull(this.eMK)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.eMK != null && this.eMK.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.eMK, 0L));
                } else if (!this.eMO) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aPN != null && aPN.size() > 0 && aPN.get(0) != null) {
                    this.eMK = aPN.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eMO) {
                        if (this.eMS - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eMS - 1));
                        }
                    } else if (this.eMR < this.bMY) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eMR + 1));
                    }
                }
                if (this.eMK != null && this.eMK.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.eMK, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eMO) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.eMK, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eMQ));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eMO && this.eNF && !this.eMM) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.eMK, 0L));
                }
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eNs);
                b(pbPageRequestMessage);
                break;
        }
        this.eNF = this.eMM;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aSo());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bmG != null && (this.bmG instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bmG).aQM());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.eNr);
        pbPageRequestMessage.setFromSmartFrs(this.eNu ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eML);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aRZ()) && com.baidu.tieba.recapp.r.big().bic() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.big().bic().W(aRZ(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.big().bic().X(aRZ(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aRZ()) && com.baidu.tieba.recapp.r.big().bic() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.big().bic().X(aRZ(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.big().bic().W(aRZ(), true));
        }
    }

    protected void pn(int i) {
        boolean z = false;
        ArrayList<PostData> aPN = this.eMZ.aPN();
        this.eNn = false;
        if (i == 1) {
            boolean z2 = false;
            while (aPN.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                aPN.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eMZ.qI().bM(1);
                if (this.eNf != null) {
                    this.eNf.c(this.eMZ);
                }
            }
            this.cwy = System.currentTimeMillis();
            this.eNn = true;
        } else if (i == 2) {
            while (aPN.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                aPN.remove(aPN.size() - 1);
                z = true;
            }
            if (z) {
                this.eMZ.qI().bL(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.eNv = i2;
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
            if (this.eNd || this.eNb || this.eNc) {
                fVar = g(fVar);
            }
            f(fVar);
        }
    }

    protected void f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String h = h(fVar);
            for (int i = 0; i < fVar.aPN().size(); i++) {
                PostData postData = fVar.aPN().get(i);
                for (int i2 = 0; i2 < postData.bsW().size(); i2++) {
                    postData.bsW().get(i2).a(this.bmG.getPageContext(), h.equals(postData.bsW().get(i2).getAuthor().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.o aPV = fVar.aPV();
            if (aPV != null && !com.baidu.tbadk.core.util.u.v(aPV.eGK)) {
                for (PostData postData2 : aPV.eGK) {
                    for (int i3 = 0; i3 < postData2.bsW().size(); i3++) {
                        postData2.bsW().get(i3).a(this.bmG.getPageContext(), h.equals(postData2.bsW().get(i3).getAuthor().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String h = h(fVar);
            com.baidu.tieba.pb.data.o aPV = fVar.aPV();
            if (aPV != null && !com.baidu.tbadk.core.util.u.v(aPV.eGK)) {
                for (PostData postData : aPV.eGK.subList(i, aPV.eGK.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bsW().size()) {
                            postData.bsW().get(i3).a(this.bmG.getPageContext(), h.equals(postData.bsW().get(i3).getAuthor().getUserId()));
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
        bl aPL = fVar.aPL();
        aPL.bU(this.mIsGood);
        aPL.bT(this.dLi);
        if (this.eMP > 0) {
            aPL.m(this.eMP);
            return fVar;
        }
        return fVar;
    }

    protected String h(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aPL() != null && fVar.aPL().getAuthor() != null) {
            str = fVar.aPL().getAuthor().getUserId();
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
        if (fVar.aPL() != null && fVar.aPL().getAuthor() != null) {
            str = fVar.aPL().getAuthor().getUserName();
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
        if (fVar.aPL() != null && fVar.aPL().getAuthor() != null) {
            str = fVar.aPL().getAuthor().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aSh() {
        if (this.eMZ == null || this.eMZ.aPL() == null || this.eMZ.aPL().getAuthor() == null) {
            return null;
        }
        return this.eMZ.aPL().getAuthor();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.eNt = z3;
        this.eNa = i;
        if (this.bZK != null && !z3) {
            this.bZK.a(z2, z4, i2, str, i3, j, j2);
            this.bZK = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aRZ()) && com.baidu.tieba.recapp.r.big().bic() != null) {
            com.baidu.tieba.recapp.r.big().bic().g(aRZ(), po(aSq()), true);
        }
        if (fVar == null || (this.eMQ == 1 && i == 5 && fVar.aPN() != null && fVar.aPN().size() < 1)) {
            if (this.eNf != null) {
                this.eMO = this.eMN;
                this.eNf.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eMN = this.eMO;
            this.eMX = false;
            if (fVar.qI() != null) {
                pl(fVar.qI().qC());
                this.bMY = fVar.qI().qz();
            }
            this.bMY = this.bMY < 1 ? 1 : this.bMY;
            int i5 = 0;
            ArrayList<PostData> aPN = this.eMZ.aPN();
            switch (i) {
                case 1:
                    this.eMZ.a(fVar.qI(), 1);
                    d(fVar, aPN);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aPN() != null) {
                        int size = fVar.aPN().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(aPN, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPN(), com.baidu.tbadk.core.util.u.u(fVar.aPN()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aPN().remove(postData2);
                            i5 = size - 1;
                        }
                        aPN.addAll(0, fVar.aPN());
                    }
                    this.eMZ.a(fVar.qI(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.eMO && fVar.qI() != null) {
                        fVar.qI().bJ(fVar.qI().qz());
                    }
                    k(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eMO) {
                        aSi();
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
            if (this.eMZ != null && this.eMZ.aPL() != null) {
                PraiseData rw = this.eMZ.aPL().rw();
                if (this.eNJ != null && !rw.isPriaseDataValid()) {
                    this.eMZ.aPL().a(this.eNJ);
                } else {
                    this.eNJ = this.eMZ.aPL().rw();
                    this.eNJ.setPostId(this.eMZ.aPL().rW());
                }
                if (fVar.qI() != null && fVar.qI().qC() == 1 && fVar.aPL() != null && fVar.aPL().rR() != null && fVar.aPL().rR().size() > 0) {
                    this.eMZ.aPL().h(fVar.aPL().rR());
                }
                this.eMZ.aPL().bR(fVar.aPL().ry());
                this.eMZ.aPL().bP(fVar.aPL().getAnchorLevel());
                this.eMZ.aPL().bQ(fVar.aPL().rt());
                if (this.mThreadType == 33) {
                    this.eMZ.aPL().getAuthor().setHadConcerned(fVar.aPL().getAuthor().hadConcerned());
                }
            }
            if (this.eMZ != null && this.eMZ.getUserData() != null && fVar.getUserData() != null) {
                this.eMZ.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eMZ.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qI() != null && fVar.qI().qC() == 1 && fVar.aPU() != null) {
                this.eMZ.e(fVar.aPU());
            }
            if (this.eNt && this.eMZ.aPL() != null && this.eMZ.aPL().getAuthor() != null && this.eMZ.aPN() != null && com.baidu.tbadk.core.util.u.c(this.eMZ.aPN(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.u.c(this.eMZ.aPN(), 0);
                MetaData author = this.eMZ.aPL().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.eNi != -1) {
                        author.setFansNum(this.eNi);
                        postData3.getAuthor().setFansNum(this.eNi);
                    }
                    if (this.eNj != -1) {
                        author.getGodUserData().setIsLike(this.eNj == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.eNj == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eMZ != null && this.eMZ.aPH() != null && fVar.aPH() != null) {
                this.eMZ.aPH().o(fVar.aPH().getItems());
                this.eMZ.aPH().an(fVar.aPH().qi());
            }
            if (this.eNf != null) {
                this.eNf.a(true, getErrorCode(), i, i4, this.eMZ, this.mErrorString, 1);
            }
        }
        if (this.eMZ != null && this.eMZ.aPL() != null && this.eMZ.aPJ() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bmG;
            historyMessage.threadId = getPbData().aPL().getId();
            historyMessage.forumName = getPbData().aPJ().getName();
            historyMessage.threadName = getPbData().aPL().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aSa();
            historyMessage.threadType = getPbData().aPL().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String al;
        if (arrayList != null && fVar.aPN() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPN(), 0);
            if (postData != null && (al = al(arrayList)) != null && al.equals(postData.getId())) {
                fVar.aPN().remove(postData);
            }
            arrayList.addAll(fVar.aPN());
        }
    }

    private int po(int i) {
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
        fVar.pq(this.eMZ.aQc());
        this.eMZ = fVar;
        pk(fVar.qI().qC());
    }

    private void aSi() {
        if (this.eMZ != null && this.eMZ.aPN() != null && this.eMZ.aQa() != null) {
            ArrayList<PostData> aPN = this.eMZ.aPN();
            com.baidu.tieba.pb.data.a aQa = this.eMZ.aQa();
            int aPA = aQa.aPA();
            if (aPA > 0) {
                if (aPA <= aPN.size()) {
                    aPN.add(aPA, aQa);
                } else {
                    aPN.add(aQa);
                }
            }
        }
    }

    public boolean aSj() {
        if (this.eMJ == null || this.eMK == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return pm(4);
        }
        return pm(6);
    }

    public boolean jk(boolean z) {
        if (this.eMJ == null || this.eMZ == null) {
            return false;
        }
        if (z || this.eMZ.qI().qE() != 0) {
            return pm(1);
        }
        return false;
    }

    public boolean jl(boolean z) {
        if (this.eMJ == null || this.eMZ == null) {
            return false;
        }
        if ((z || this.eMZ.qI().qF() != 0) && this.eMZ.aPN() != null && this.eMZ.aPN().size() >= 1) {
            return pm(2);
        }
        return false;
    }

    public boolean pz(String str) {
        this.eMM = !this.eMM;
        this.eMK = str;
        pm(6);
        return true;
    }

    public boolean j(boolean z, String str) {
        if (this.eMM == z) {
            return false;
        }
        this.eMM = z;
        this.eMK = str;
        pm(6);
        return true;
    }

    public boolean aSk() {
        if (com.baidu.adp.lib.util.i.hr()) {
            this.eMN = this.eMO;
            this.eMO = !this.eMO;
        }
        return LoadData();
    }

    public boolean jm(boolean z) {
        if (this.eMO == z) {
            return false;
        }
        if (com.baidu.adp.lib.util.i.hr()) {
            this.eMN = z;
            this.eMO = z;
        }
        return LoadData();
    }

    public boolean aSl() {
        return this.eMO;
    }

    public boolean hasData() {
        return (this.eMZ == null || this.eMZ.aPJ() == null || this.eMZ.aPL() == null) ? false : true;
    }

    public boolean nM() {
        if (this.eMZ == null) {
            return false;
        }
        return this.eMZ.nM();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fW(String str) {
        if (this.eMZ == null || this.eMZ.aPL() == null || this.eMZ.aPJ() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eMZ.aPL().sS()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eMZ.aPJ().getId());
            writeData.setForumName(this.eMZ.aPJ().getName());
        }
        writeData.setThreadId(this.eMJ);
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

    public MarkData pp(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.eMZ == null) {
            return null;
        }
        ArrayList<PostData> aPN = this.eMZ.aPN();
        if (com.baidu.tbadk.core.util.u.v(aPN)) {
            return null;
        }
        if (aPN.size() > 0 && i >= aPN.size()) {
            i = aPN.size() - 1;
        }
        return j(aPN.get(i));
    }

    public MarkData aSm() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eMJ);
        markData.setPostId(this.eMZ.nL());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eMM);
        markData.setSequence(Boolean.valueOf(this.eMO));
        markData.setId(this.eMJ);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eMJ);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eMM);
        markData.setSequence(Boolean.valueOf(this.eMO));
        markData.setId(this.eMJ);
        markData.setFloor(postData.bsZ());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aSn() {
        h.aRO().Q(aSo(), this.isFromMark);
    }

    private String aSo() {
        String str = this.eMJ;
        if (this.eMM) {
            str = str + DB_KEY_HOST;
        }
        if (!this.eMO) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jn(boolean z) {
        if (this.eMZ != null) {
            this.eMZ.ac(z);
        }
    }

    public void jo(boolean z) {
        this.eNk = z;
    }

    public boolean aSp() {
        return this.eNk;
    }

    public void a(a aVar) {
        this.eNf = aVar;
    }

    public void os(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dv() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Du() {
        return Fw();
    }

    public boolean pA(String str) {
        if (getPbData() == null || getPbData().aPL() == null || getPbData().aPL().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aPL().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aSq() {
        return this.mRequestType;
    }

    public void aSr() {
        String aSo = aSo();
        h.aRO().Q(aSo, false);
        h.aRO().Q(aSo, true);
    }

    public void aSs() {
        if ("personalize_page".equals(this.mStType)) {
            this.eNq = System.currentTimeMillis() / 1000;
        }
    }

    public void aSt() {
        if ("personalize_page".equals(this.mStType) && this.eMZ != null && this.eNq != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10754").aa("fid", this.eMZ.getForumId()).aa("tid", this.eMJ).aa("obj_duration", String.valueOf(currentTimeMillis - this.eNq)).aa("obj_param3", String.valueOf(currentTimeMillis)));
            this.eNq = 0L;
        }
    }

    public boolean aSu() {
        return this.eNt;
    }

    public int aSv() {
        return this.eNa;
    }

    public int getErrorNo() {
        return this.eNv;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public t aSw() {
        return this.eNx;
    }

    public i aSx() {
        return this.eNy;
    }

    public m aSy() {
        return this.eNz;
    }

    public PbFloorAgreeModel aSz() {
        return this.eNA;
    }

    public w aSA() {
        return this.eNB;
    }

    public CheckRealNameModel aSB() {
        return this.boy;
    }

    public AddExperiencedModel aSC() {
        return this.eND;
    }

    public String aSD() {
        return this.eNp;
    }

    public void pB(String str) {
        this.eNp = str;
    }

    public boolean aSE() {
        return this.eNu;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.eMZ != null && this.eMZ.aPN() != null && this.eMZ.aPN().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eMZ.aPN().size();
                for (int i = 0; i < size; i++) {
                    if (this.eMZ.aPN().get(i) != null && this.eMZ.aPN().get(i).getAuthor() != null && currentAccount.equals(this.eMZ.aPN().get(i).getAuthor().getUserId()) && this.eMZ.aPN().get(i).getAuthor().getPendantData() != null) {
                        this.eMZ.aPN().get(i).getAuthor().getPendantData().cK(jVar.pW());
                        this.eMZ.aPN().get(i).getAuthor().getPendantData().Q(jVar.CB());
                    }
                }
            }
        }
    }

    public String aSF() {
        return this.eNC;
    }

    public int aSG() {
        return this.eNG;
    }
}
