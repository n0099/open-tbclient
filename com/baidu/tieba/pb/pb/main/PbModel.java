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
    private int bMX;
    private com.baidu.tieba.tbadkCore.d.b bZJ;
    private BaseActivity bmE;
    private final CheckRealNameModel bow;
    private long cwy;
    private int dLi;
    private com.baidu.adp.framework.listener.a dLs;
    protected String eMH;
    private String eMI;
    private boolean eMJ;
    private boolean eMK;
    private boolean eML;
    private boolean eMM;
    private long eMN;
    private int eMO;
    private int eMP;
    private int eMQ;
    private boolean eMR;
    private boolean eMS;
    private boolean eMT;
    private long eMU;
    private boolean eMV;
    private String eMW;
    protected com.baidu.tieba.pb.data.f eMX;
    private int eMY;
    private boolean eMZ;
    private String eNA;
    private final AddExperiencedModel eNB;
    private SuggestEmotionModel eNC;
    private boolean eND;
    private int eNE;
    private CustomMessageListener eNF;
    private CustomMessageListener eNG;
    private PraiseData eNH;
    private boolean eNa;
    private boolean eNb;
    private boolean eNc;
    private a eNd;
    private String eNe;
    private String eNf;
    private int eNg;
    private int eNh;
    private boolean eNi;
    private boolean eNj;
    private boolean eNk;
    private boolean eNl;
    private boolean eNm;
    private String eNn;
    private long eNo;
    private boolean eNp;
    private int eNq;
    private boolean eNr;
    private boolean eNs;
    private int eNt;
    private final u eNu;
    private final t eNv;
    private final i eNw;
    private final m eNx;
    private final PbFloorAgreeModel eNy;
    private final w eNz;
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
    private static final int eMG = com.baidu.tbadk.data.c.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.f fVar);
    }

    public void jj(boolean z) {
        this.eNp = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eMH = null;
        this.eMI = null;
        this.mForumId = null;
        this.eMJ = false;
        this.eMK = false;
        this.eML = true;
        this.eMM = true;
        this.mIsGood = 0;
        this.dLi = 0;
        this.eMN = 0L;
        this.eMO = 1;
        this.eMP = 1;
        this.eMQ = 1;
        this.bMX = 1;
        this.isAd = false;
        this.eMR = false;
        this.eMS = false;
        this.eal = false;
        this.isFromMark = false;
        this.eMT = false;
        this.eMU = 0L;
        this.eMV = false;
        this.eMW = null;
        this.eMX = null;
        this.isLoading = false;
        this.eMZ = false;
        this.eNa = false;
        this.eNb = false;
        this.eNc = false;
        this.mLocate = null;
        this.mContext = null;
        this.eNd = null;
        this.opType = null;
        this.opUrl = null;
        this.eNe = null;
        this.eNf = null;
        this.eNg = -1;
        this.eNh = -1;
        this.bZJ = null;
        this.eNj = false;
        this.eNk = false;
        this.postID = null;
        this.eNn = null;
        this.eNo = 0L;
        this.eNp = false;
        this.eNq = -1;
        this.eNs = false;
        this.eND = false;
        this.eNE = 0;
        this.eNF = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.eNm = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.k(pbData);
                    PbModel.this.e(pbData);
                    if (pbData.aPQ() != null) {
                        pbData.aPQ().bQ(0);
                    }
                    if (PbModel.this.eNd != null && pbData != null) {
                        com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.eNd.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.eNG = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aPO() != null && PbModel.this.getPbData().aPO().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aPO().getSignData().is_signed = signData.is_signed;
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
                        PbModel.this.bmE.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.eNj || !PbModel.this.eNk) {
                        if (!PbModel.this.eNj) {
                            PbModel.this.eNj = true;
                        } else {
                            PbModel.this.eNk = true;
                        }
                        if (PbModel.this.eNd != null) {
                            PbModel.this.eNd.a(PbModel.this.aSc(), z, responsedMessage, PbModel.this.eNl, System.currentTimeMillis() - PbModel.this.cwy);
                        }
                    }
                }
            }
        };
        this.eNH = null;
        registerListener(this.eNF);
        registerListener(this.dLs);
        registerListener(this.eNG);
        this.eMX = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bmE = baseActivity;
        this.eNu = new u(this, this.bmE);
        this.eNv = new t(this, this.bmE);
        this.eNw = new i(this, this.bmE);
        this.eNx = new m(this, this.bmE);
        this.eNy = new PbFloorAgreeModel(this);
        this.eNz = new w(this, this.bmE);
        this.bow = new CheckRealNameModel(this.bmE.getPageContext());
        this.eNC = new SuggestEmotionModel();
        this.eNB = new AddExperiencedModel(this.bmE.getPageContext());
    }

    protected int aSc() {
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
        this.eMH = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eMH)) {
            this.eMH = this.eNu.Y(intent);
        }
        this.eNE = intent.getIntExtra(PbActivityConfig.KEY_START_FROM, 0);
        this.eMI = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eMJ = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eMK = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eMM = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dLi = intent.getIntExtra("is_top", 0);
        this.eMN = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eMT = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eMR = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eMV = intent.getBooleanExtra("is_pv", false);
        this.eMU = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eMW = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eNf = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.eNe = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.eMZ = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eNa = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eNb = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eNh = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eNg = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eMS = intent.getBooleanExtra("from_frs", false);
        this.eal = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eNs = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eNc = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
        this.eNA = intent.getStringExtra(PbActivityConfig.KEY_POST_THREAD_TIP);
    }

    public void initWithBundle(Bundle bundle) {
        this.eNE = bundle.getInt(PbActivityConfig.KEY_START_FROM, 0);
        this.eMH = bundle.getString("thread_id");
        this.eMI = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eMJ = bundle.getBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eMK = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eMM = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dLi = bundle.getInt("is_top", 0);
        this.eMN = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eMT = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eMR = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eMV = bundle.getBoolean("is_pv", false);
        this.eMU = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eMW = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eNf = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.eMZ = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eNa = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eNb = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eNh = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eNg = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eMS = bundle.getBoolean("from_frs", false);
        this.eal = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eNs = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eNc = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void r(Bundle bundle) {
        bundle.putString("thread_id", this.eMH);
        bundle.putString("post_id", this.eMI);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt(PbActivityConfig.KEY_START_FROM, this.eNE);
        bundle.putBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, this.eMJ);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.eMK);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.eMM);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dLi);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.eMN);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.eMT);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.eMR);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eMV);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.eMU);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.eNf);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.eMZ);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.eNa);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.eNb);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.eNh);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.eNg);
        bundle.putBoolean("from_frs", this.eMS);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.eal);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.eNs);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.eNc);
    }

    public String aSd() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eMH);
        if (!this.eMT) {
            sb.append(this.eMI);
        }
        sb.append(this.eMK);
        sb.append(this.eMM);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.dLi);
        sb.append(this.eMN);
        sb.append(this.eMS);
        sb.append(this.eal);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eMR);
        sb.append(this.eMV);
        sb.append(this.eMU);
        sb.append(this.eMW);
        sb.append(this.mThreadType);
        sb.append(this.eMZ);
        sb.append(this.eNa);
        sb.append(this.eNb);
        if (this.eNf != null) {
            sb.append(this.eNf);
        }
        return sb.toString();
    }

    public String aSe() {
        return this.eMW;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eMI;
    }

    public void pt(String str) {
        this.eMI = str;
    }

    public String getThreadID() {
        return this.eMH;
    }

    public boolean getHostMode() {
        return this.eMK;
    }

    public boolean aSf() {
        return this.eMM;
    }

    public boolean aSg() {
        return this.eMS;
    }

    public boolean aSh() {
        return this.eal;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aSi() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aBI() {
        return this.dLi;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void hG(int i) {
        this.dLi = i;
    }

    public boolean aSj() {
        return this.eMR;
    }

    public boolean aSk() {
        if (this.eMX == null) {
            return false;
        }
        return this.eMX.isValid();
    }

    public String rO() {
        if (this.eMX == null || !this.eMX.nL()) {
            return null;
        }
        return this.eMX.nK();
    }

    public boolean pi(int i) {
        this.eMO = i;
        if (this.eMO > this.eMX.qH().qy()) {
            this.eMO = this.eMX.qH().qy();
        }
        if (this.eMO < 1) {
            this.eMO = 1;
        }
        if (this.eMH == null) {
            return false;
        }
        return pm(5);
    }

    public boolean pj(int i) {
        int st = this.eMX.aPQ().st();
        if (i <= st) {
            st = i;
        }
        int i2 = st >= 1 ? st : 1;
        if (this.eMH == null) {
            return false;
        }
        this.eNq = i2;
        return pm(7);
    }

    public void pk(int i) {
        this.eMO = i;
        this.eMP = i;
        this.eMQ = i;
    }

    public void pl(int i) {
        if (this.eMP < i) {
            this.eMP = i;
            if (this.eMP - this.eMQ >= eMG) {
                this.eMQ = (this.eMP - eMG) + 1;
            }
        }
        if (this.eMQ > i) {
            this.eMQ = i;
            if (this.eMP - this.eMQ >= eMG) {
                this.eMP = (this.eMQ + eMG) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eMX;
    }

    public com.baidu.tbadk.core.data.ar aqU() {
        if (this.eMX == null) {
            return null;
        }
        return this.eMX.qH();
    }

    public boolean aSl() {
        if (this.eMM && this.eMX.qH().qD() == 0) {
            jk(true);
            return true;
        }
        return false;
    }

    public void pn(String str) {
        if (!StringUtils.isNull(str)) {
            this.eMH = str;
            this.eMI = null;
            this.eMK = false;
            this.eMM = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eMH == null) {
            return false;
        }
        cancelLoadData();
        if (this.bZJ == null) {
            this.bZJ = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bZJ.start();
        }
        boolean pm = pm(3);
        if (this.opType != null) {
            this.opType = null;
            this.eNe = null;
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
        if (this.eNC != null) {
            this.eNC.cancelLoadData();
        }
        if (this.eNy != null) {
            this.eNy.cancelLoadData();
        }
        acp();
    }

    private void acp() {
        if (this.bZJ != null) {
            this.bZJ.destory();
            this.bZJ = null;
        }
    }

    public boolean Fw() {
        return (this.eMI == null || this.eMI.equals("0") || this.eMI.length() == 0) ? LoadData() : aSo();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        if (forumData != null && !TextUtils.isEmpty(forumData.getId()) && !TextUtils.isEmpty(forumData.getName())) {
            this.eNC.a(forumData.getId(), forumData.getName(), aVar);
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
        final com.baidu.tieba.pb.data.f pbData = ai.aTq().getPbData();
        if (pbData != null && pbData.aPQ() != null) {
            pbData.aPQ().bQ(0);
            this.eMM = ai.aTq().aSf();
            this.eMK = ai.aTq().aTs();
            this.eND = this.eMK;
            if (this.eMK || this.isFromMark) {
                this.eNi = false;
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
        if (i == 4 && !this.eNm) {
            a(aSt(), true, this.eMI, 3);
        }
        if (i == 3 && !this.eNm) {
            if (this.isFromMark) {
                a(aSt(), true, this.eMI, 3);
            } else {
                a(aSt(), false, this.eMI, 3);
            }
        }
        this.eNm = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aBf);
        if (this.eMK || this.isFromMark) {
            this.eNi = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eMH == null || this.eMH.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.eMH, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getApp());
        int ah = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.am.vQ().vS() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.eMM) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eMK) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eMV) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eMU));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eNi) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eNe, 0));
            pbPageRequestMessage.setOpMessageID(this.eMU);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aPS = this.eMX.aPS();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eMM) {
                        if (this.eMQ - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eMQ - 1));
                        }
                    } else if (this.eMP < this.bMX) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eMP + 1));
                    }
                }
                if (aPS != null && aPS.size() > 0) {
                    int size = aPS.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aPS.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.eMI = postData.getId();
                            if (StringUtils.isNull(this.eMI)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.eMI != null && this.eMI.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.eMI, 0L));
                } else if (!this.eMM) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aPS != null && aPS.size() > 0 && aPS.get(0) != null) {
                    this.eMI = aPS.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eMM) {
                        if (this.eMQ - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eMQ - 1));
                        }
                    } else if (this.eMP < this.bMX) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eMP + 1));
                    }
                }
                if (this.eMI != null && this.eMI.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.eMI, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eMM) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.eMI, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eMO));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eMM && this.eND && !this.eMK) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.eMI, 0L));
                }
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eNq);
                b(pbPageRequestMessage);
                break;
        }
        this.eND = this.eMK;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aSt());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bmE != null && (this.bmE instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bmE).aQR());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.eNp);
        pbPageRequestMessage.setFromSmartFrs(this.eNs ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eMJ);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aSe()) && com.baidu.tieba.recapp.r.bil().bih() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bil().bih().W(aSe(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bil().bih().X(aSe(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aSe()) && com.baidu.tieba.recapp.r.bil().bih() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bil().bih().X(aSe(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bil().bih().W(aSe(), true));
        }
    }

    protected void pn(int i) {
        boolean z = false;
        ArrayList<PostData> aPS = this.eMX.aPS();
        this.eNl = false;
        if (i == 1) {
            boolean z2 = false;
            while (aPS.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                aPS.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eMX.qH().bM(1);
                if (this.eNd != null) {
                    this.eNd.c(this.eMX);
                }
            }
            this.cwy = System.currentTimeMillis();
            this.eNl = true;
        } else if (i == 2) {
            while (aPS.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                aPS.remove(aPS.size() - 1);
                z = true;
            }
            if (z) {
                this.eMX.qH().bL(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.eNt = i2;
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
            if (this.eNb || this.eMZ || this.eNa) {
                fVar = g(fVar);
            }
            f(fVar);
        }
    }

    protected void f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String h = h(fVar);
            for (int i = 0; i < fVar.aPS().size(); i++) {
                PostData postData = fVar.aPS().get(i);
                for (int i2 = 0; i2 < postData.btd().size(); i2++) {
                    postData.btd().get(i2).a(this.bmE.getPageContext(), h.equals(postData.btd().get(i2).getAuthor().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.o aQa = fVar.aQa();
            if (aQa != null && !com.baidu.tbadk.core.util.u.v(aQa.eGI)) {
                for (PostData postData2 : aQa.eGI) {
                    for (int i3 = 0; i3 < postData2.btd().size(); i3++) {
                        postData2.btd().get(i3).a(this.bmE.getPageContext(), h.equals(postData2.btd().get(i3).getAuthor().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String h = h(fVar);
            com.baidu.tieba.pb.data.o aQa = fVar.aQa();
            if (aQa != null && !com.baidu.tbadk.core.util.u.v(aQa.eGI)) {
                for (PostData postData : aQa.eGI.subList(i, aQa.eGI.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.btd().size()) {
                            postData.btd().get(i3).a(this.bmE.getPageContext(), h.equals(postData.btd().get(i3).getAuthor().getUserId()));
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
        bl aPQ = fVar.aPQ();
        aPQ.bU(this.mIsGood);
        aPQ.bT(this.dLi);
        if (this.eMN > 0) {
            aPQ.m(this.eMN);
            return fVar;
        }
        return fVar;
    }

    protected String h(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aPQ() != null && fVar.aPQ().getAuthor() != null) {
            str = fVar.aPQ().getAuthor().getUserId();
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
        if (fVar.aPQ() != null && fVar.aPQ().getAuthor() != null) {
            str = fVar.aPQ().getAuthor().getUserName();
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
        if (fVar.aPQ() != null && fVar.aPQ().getAuthor() != null) {
            str = fVar.aPQ().getAuthor().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aSm() {
        if (this.eMX == null || this.eMX.aPQ() == null || this.eMX.aPQ().getAuthor() == null) {
            return null;
        }
        return this.eMX.aPQ().getAuthor();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.eNr = z3;
        this.eMY = i;
        if (this.bZJ != null && !z3) {
            this.bZJ.a(z2, z4, i2, str, i3, j, j2);
            this.bZJ = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aSe()) && com.baidu.tieba.recapp.r.bil().bih() != null) {
            com.baidu.tieba.recapp.r.bil().bih().g(aSe(), po(aSv()), true);
        }
        if (fVar == null || (this.eMO == 1 && i == 5 && fVar.aPS() != null && fVar.aPS().size() < 1)) {
            if (this.eNd != null) {
                this.eMM = this.eML;
                this.eNd.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eML = this.eMM;
            this.eMV = false;
            if (fVar.qH() != null) {
                pl(fVar.qH().qB());
                this.bMX = fVar.qH().qy();
            }
            this.bMX = this.bMX < 1 ? 1 : this.bMX;
            int i5 = 0;
            ArrayList<PostData> aPS = this.eMX.aPS();
            switch (i) {
                case 1:
                    this.eMX.a(fVar.qH(), 1);
                    d(fVar, aPS);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aPS() != null) {
                        int size = fVar.aPS().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(aPS, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPS(), com.baidu.tbadk.core.util.u.u(fVar.aPS()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aPS().remove(postData2);
                            i5 = size - 1;
                        }
                        aPS.addAll(0, fVar.aPS());
                    }
                    this.eMX.a(fVar.qH(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.eMM && fVar.qH() != null) {
                        fVar.qH().bJ(fVar.qH().qy());
                    }
                    k(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eMM) {
                        aSn();
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
            if (this.eMX != null && this.eMX.aPQ() != null) {
                PraiseData rv = this.eMX.aPQ().rv();
                if (this.eNH != null && !rv.isPriaseDataValid()) {
                    this.eMX.aPQ().a(this.eNH);
                } else {
                    this.eNH = this.eMX.aPQ().rv();
                    this.eNH.setPostId(this.eMX.aPQ().rV());
                }
                if (fVar.qH() != null && fVar.qH().qB() == 1 && fVar.aPQ() != null && fVar.aPQ().rQ() != null && fVar.aPQ().rQ().size() > 0) {
                    this.eMX.aPQ().h(fVar.aPQ().rQ());
                }
                this.eMX.aPQ().bR(fVar.aPQ().rx());
                this.eMX.aPQ().bP(fVar.aPQ().getAnchorLevel());
                this.eMX.aPQ().bQ(fVar.aPQ().rs());
                if (this.mThreadType == 33) {
                    this.eMX.aPQ().getAuthor().setHadConcerned(fVar.aPQ().getAuthor().hadConcerned());
                }
            }
            if (this.eMX != null && this.eMX.getUserData() != null && fVar.getUserData() != null) {
                this.eMX.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eMX.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qH() != null && fVar.qH().qB() == 1 && fVar.aPZ() != null) {
                this.eMX.e(fVar.aPZ());
            }
            if (this.eNr && this.eMX.aPQ() != null && this.eMX.aPQ().getAuthor() != null && this.eMX.aPS() != null && com.baidu.tbadk.core.util.u.c(this.eMX.aPS(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.u.c(this.eMX.aPS(), 0);
                MetaData author = this.eMX.aPQ().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.eNg != -1) {
                        author.setFansNum(this.eNg);
                        postData3.getAuthor().setFansNum(this.eNg);
                    }
                    if (this.eNh != -1) {
                        author.getGodUserData().setIsLike(this.eNh == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.eNh == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eMX != null && this.eMX.aPM() != null && fVar.aPM() != null) {
                this.eMX.aPM().o(fVar.aPM().getItems());
                this.eMX.aPM().an(fVar.aPM().qh());
            }
            if (this.eNd != null) {
                this.eNd.a(true, getErrorCode(), i, i4, this.eMX, this.mErrorString, 1);
            }
        }
        if (this.eMX != null && this.eMX.aPQ() != null && this.eMX.aPO() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bmE;
            historyMessage.threadId = getPbData().aPQ().getId();
            historyMessage.forumName = getPbData().aPO().getName();
            historyMessage.threadName = getPbData().aPQ().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aSf();
            historyMessage.threadType = getPbData().aPQ().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String al;
        if (arrayList != null && fVar.aPS() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPS(), 0);
            if (postData != null && (al = al(arrayList)) != null && al.equals(postData.getId())) {
                fVar.aPS().remove(postData);
            }
            arrayList.addAll(fVar.aPS());
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
        fVar.pl(this.eMX.aQh());
        this.eMX = fVar;
        pk(fVar.qH().qB());
    }

    private void aSn() {
        if (this.eMX != null && this.eMX.aPS() != null && this.eMX.aQf() != null) {
            ArrayList<PostData> aPS = this.eMX.aPS();
            com.baidu.tieba.pb.data.a aQf = this.eMX.aQf();
            int aPF = aQf.aPF();
            if (aPF > 0) {
                if (aPF <= aPS.size()) {
                    aPS.add(aPF, aQf);
                } else {
                    aPS.add(aQf);
                }
            }
        }
    }

    public boolean aSo() {
        if (this.eMH == null || this.eMI == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return pm(4);
        }
        return pm(6);
    }

    public boolean jk(boolean z) {
        if (this.eMH == null || this.eMX == null) {
            return false;
        }
        if (z || this.eMX.qH().qD() != 0) {
            return pm(1);
        }
        return false;
    }

    public boolean jl(boolean z) {
        if (this.eMH == null || this.eMX == null) {
            return false;
        }
        if ((z || this.eMX.qH().qE() != 0) && this.eMX.aPS() != null && this.eMX.aPS().size() >= 1) {
            return pm(2);
        }
        return false;
    }

    public boolean pu(String str) {
        this.eMK = !this.eMK;
        this.eMI = str;
        pm(6);
        return true;
    }

    public boolean i(boolean z, String str) {
        if (this.eMK == z) {
            return false;
        }
        this.eMK = z;
        this.eMI = str;
        pm(6);
        return true;
    }

    public boolean aSp() {
        if (com.baidu.adp.lib.util.i.hr()) {
            this.eML = this.eMM;
            this.eMM = !this.eMM;
        }
        return LoadData();
    }

    public boolean jm(boolean z) {
        if (this.eMM == z) {
            return false;
        }
        if (com.baidu.adp.lib.util.i.hr()) {
            this.eML = z;
            this.eMM = z;
        }
        return LoadData();
    }

    public boolean aSq() {
        return this.eMM;
    }

    public boolean hasData() {
        return (this.eMX == null || this.eMX.aPO() == null || this.eMX.aPQ() == null) ? false : true;
    }

    public boolean nL() {
        if (this.eMX == null) {
            return false;
        }
        return this.eMX.nL();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fS(String str) {
        if (this.eMX == null || this.eMX.aPQ() == null || this.eMX.aPO() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eMX.aPQ().sR()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eMX.aPO().getId());
            writeData.setForumName(this.eMX.aPO().getName());
        }
        writeData.setThreadId(this.eMH);
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
        if (this.eMX == null) {
            return null;
        }
        ArrayList<PostData> aPS = this.eMX.aPS();
        if (com.baidu.tbadk.core.util.u.v(aPS)) {
            return null;
        }
        if (aPS.size() > 0 && i >= aPS.size()) {
            i = aPS.size() - 1;
        }
        return j(aPS.get(i));
    }

    public MarkData aSr() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eMH);
        markData.setPostId(this.eMX.nK());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eMK);
        markData.setSequence(Boolean.valueOf(this.eMM));
        markData.setId(this.eMH);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eMH);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eMK);
        markData.setSequence(Boolean.valueOf(this.eMM));
        markData.setId(this.eMH);
        markData.setFloor(postData.btg());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aSs() {
        h.aRT().Q(aSt(), this.isFromMark);
    }

    private String aSt() {
        String str = this.eMH;
        if (this.eMK) {
            str = str + DB_KEY_HOST;
        }
        if (!this.eMM) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jn(boolean z) {
        if (this.eMX != null) {
            this.eMX.ac(z);
        }
    }

    public void jo(boolean z) {
        this.eNi = z;
    }

    public boolean aSu() {
        return this.eNi;
    }

    public void a(a aVar) {
        this.eNd = aVar;
    }

    public void om(String str) {
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

    public boolean pv(String str) {
        if (getPbData() == null || getPbData().aPQ() == null || getPbData().aPQ().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aPQ().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aSv() {
        return this.mRequestType;
    }

    public void aSw() {
        String aSt = aSt();
        h.aRT().Q(aSt, false);
        h.aRT().Q(aSt, true);
    }

    public void aSx() {
        if ("personalize_page".equals(this.mStType)) {
            this.eNo = System.currentTimeMillis() / 1000;
        }
    }

    public void aSy() {
        if ("personalize_page".equals(this.mStType) && this.eMX != null && this.eNo != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10754").aa("fid", this.eMX.getForumId()).aa("tid", this.eMH).aa("obj_duration", String.valueOf(currentTimeMillis - this.eNo)).aa("obj_param3", String.valueOf(currentTimeMillis)));
            this.eNo = 0L;
        }
    }

    public boolean aSz() {
        return this.eNr;
    }

    public int aSA() {
        return this.eMY;
    }

    public int getErrorNo() {
        return this.eNt;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public t aSB() {
        return this.eNv;
    }

    public i aSC() {
        return this.eNw;
    }

    public m aSD() {
        return this.eNx;
    }

    public PbFloorAgreeModel aSE() {
        return this.eNy;
    }

    public w aSF() {
        return this.eNz;
    }

    public CheckRealNameModel aSG() {
        return this.bow;
    }

    public AddExperiencedModel aSH() {
        return this.eNB;
    }

    public String aSI() {
        return this.eNn;
    }

    public void pw(String str) {
        this.eNn = str;
    }

    public boolean aSJ() {
        return this.eNs;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.eMX != null && this.eMX.aPS() != null && this.eMX.aPS().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eMX.aPS().size();
                for (int i = 0; i < size; i++) {
                    if (this.eMX.aPS().get(i) != null && this.eMX.aPS().get(i).getAuthor() != null && currentAccount.equals(this.eMX.aPS().get(i).getAuthor().getUserId()) && this.eMX.aPS().get(i).getAuthor().getPendantData() != null) {
                        this.eMX.aPS().get(i).getAuthor().getPendantData().cH(jVar.pV());
                        this.eMX.aPS().get(i).getAuthor().getPendantData().Q(jVar.CB());
                    }
                }
            }
        }
    }

    public String aSK() {
        return this.eNA;
    }

    public int aSL() {
        return this.eNE;
    }
}
