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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class PbModel extends DataModel {
    public static final String DB_KEY_HOST = "_host";
    public static final String DB_KEY_REVER = "_rev";
    public static final int MIN_NUM_SHOW_GO_BACK_ITEM = 3;
    public static final int UPDATE_TYPE_MARK = 4;
    public static final int UPDATE_TYPE_MORE = 1;
    public static final int UPDATE_TYPE_PREVIOUS = 2;
    public static final int UPDATE_TYPE_REDIRECTPAGE = 5;
    public static final int UPDATE_TYPE_REDIRECT_FLOOR = 7;
    public static final int UPDATE_TYPE_SINGLE_FLOOR = 8;
    public static final int UPDATE_TYPE_SPEC_FLOOR = 6;
    public static final int UPDATE_TYPE_UPDATE = 3;
    private int bQd;
    private BaseActivity boA;
    private final CheckRealNameModel bqN;
    private long cEs;
    private com.baidu.tieba.tbadkCore.d.b cdn;
    private com.baidu.adp.framework.listener.a dOJ;
    private int dOz;
    protected com.baidu.tieba.pb.data.f eFA;
    private int eFB;
    private boolean eFC;
    private boolean eFD;
    private boolean eFE;
    private boolean eFF;
    private a eFG;
    private String eFH;
    private String eFI;
    private int eFJ;
    private int eFK;
    private boolean eFL;
    private boolean eFM;
    private boolean eFN;
    private boolean eFO;
    private boolean eFP;
    private String eFQ;
    private long eFR;
    private boolean eFS;
    private int eFT;
    private boolean eFU;
    private boolean eFV;
    private int eFW;
    private final t eFX;
    private final h eFY;
    private final m eFZ;
    protected String eFj;
    private String eFk;
    private boolean eFl;
    private boolean eFm;
    private boolean eFn;
    private boolean eFo;
    private boolean eFp;
    private long eFq;
    private int eFr;
    private int eFs;
    private int eFt;
    private boolean eFu;
    private boolean eFv;
    private boolean eFw;
    private long eFx;
    private boolean eFy;
    private String eFz;
    private final PbFloorAgreeModel eGa;
    private final v eGb;
    private String eGc;
    private final AddExperiencedModel eGd;
    private SuggestEmotionModel eGe;
    private GetSugMatchWordsModel eGf;
    private boolean eGg;
    private int eGh;
    private String eGi;
    private PostData eGj;
    private PostData eGk;
    private int eGl;
    private int eGm;
    private CustomMessageListener eGn;
    private CustomMessageListener eGo;
    private PraiseData eGp;
    private boolean edJ;
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
    private static final int eFi = com.baidu.tbadk.data.b.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.f fVar);
    }

    public void iW(boolean z) {
        this.eFS = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eFj = null;
        this.eFk = null;
        this.mForumId = null;
        this.eFl = false;
        this.eFm = false;
        this.eFn = true;
        this.eFo = true;
        this.eFp = false;
        this.mIsGood = 0;
        this.dOz = 0;
        this.eFq = 0L;
        this.eFr = 1;
        this.eFs = 1;
        this.eFt = 1;
        this.bQd = 1;
        this.isAd = false;
        this.eFu = false;
        this.eFv = false;
        this.edJ = false;
        this.isFromMark = false;
        this.eFw = false;
        this.eFx = 0L;
        this.eFy = false;
        this.eFz = null;
        this.eFA = null;
        this.isLoading = false;
        this.eFC = false;
        this.eFD = false;
        this.eFE = false;
        this.eFF = false;
        this.mLocate = null;
        this.mContext = null;
        this.eFG = null;
        this.opType = null;
        this.opUrl = null;
        this.eFH = null;
        this.eFI = null;
        this.eFJ = -1;
        this.eFK = -1;
        this.cdn = null;
        this.eFM = false;
        this.eFN = false;
        this.postID = null;
        this.eFQ = null;
        this.eFR = 0L;
        this.eFS = false;
        this.eFT = -1;
        this.eFV = false;
        this.eGg = false;
        this.eGh = 0;
        this.eGn = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.eFP = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.g(pbData);
                    if (pbData.aMW() != null) {
                        pbData.aMW().bQ(0);
                    }
                    if (PbModel.this.eFG != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.eFG.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.eGo = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aMU() != null && PbModel.this.getPbData().aMU().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aMU().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.dOJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.hh()) {
                        PbModel.this.boA.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.eFM || !PbModel.this.eFN) {
                        if (!PbModel.this.eFM) {
                            PbModel.this.eFM = true;
                        } else {
                            PbModel.this.eFN = true;
                        }
                        if (PbModel.this.eFG != null) {
                            PbModel.this.eFG.a(PbModel.this.aPp(), z, responsedMessage, PbModel.this.eFO, System.currentTimeMillis() - PbModel.this.cEs);
                        }
                    }
                }
            }
        };
        this.eGp = null;
        registerListener(this.eGn);
        registerListener(this.dOJ);
        registerListener(this.eGo);
        this.eFA = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.boA = baseActivity;
        this.eFX = new t(this, this.boA);
        this.eFY = new h(this, this.boA);
        this.eFZ = new m(this, this.boA);
        this.eGa = new PbFloorAgreeModel(this);
        this.eGb = new v(this, this.boA);
        this.bqN = new CheckRealNameModel(this.boA.getPageContext());
        this.eGe = new SuggestEmotionModel();
        this.eGd = new AddExperiencedModel(this.boA.getPageContext());
    }

    protected int aPp() {
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
        this.eFj = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eFj)) {
            this.eFj = this.eFX.T(intent);
        }
        this.eGh = intent.getIntExtra(PbActivityConfig.KEY_START_FROM, 0);
        this.eFk = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eFl = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eFm = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eFo = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dOz = intent.getIntExtra("is_top", 0);
        this.eFq = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eFw = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eFu = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eFy = intent.getBooleanExtra("is_pv", false);
        this.eFx = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eFz = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eFI = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.eFH = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.eFC = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eFD = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eFE = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eFK = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eFJ = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eFv = intent.getBooleanExtra("from_frs", false);
        this.edJ = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eFV = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eFF = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
        this.eGc = intent.getStringExtra(PbActivityConfig.KEY_POST_THREAD_TIP);
    }

    public void initWithBundle(Bundle bundle) {
        this.eGh = bundle.getInt(PbActivityConfig.KEY_START_FROM, 0);
        this.eFj = bundle.getString("thread_id");
        this.eFk = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eFl = bundle.getBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eFm = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eFo = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dOz = bundle.getInt("is_top", 0);
        this.eFq = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eFw = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eFu = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eFy = bundle.getBoolean("is_pv", false);
        this.eFx = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eFz = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eFI = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.eFC = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eFD = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eFE = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eFK = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eFJ = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eFv = bundle.getBoolean("from_frs", false);
        this.edJ = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eFV = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eFF = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void u(Bundle bundle) {
        bundle.putString("thread_id", this.eFj);
        bundle.putString("post_id", this.eFk);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt(PbActivityConfig.KEY_START_FROM, this.eGh);
        bundle.putBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, this.eFl);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.eFm);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.eFo);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dOz);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.eFq);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.eFw);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.eFu);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eFy);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.eFx);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.eFI);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.eFC);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.eFD);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.eFE);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.eFK);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.eFJ);
        bundle.putBoolean("from_frs", this.eFv);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.edJ);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.eFV);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.eFF);
    }

    public String aPq() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eFj);
        if (!this.eFw) {
            sb.append(this.eFk);
        }
        sb.append(this.eFm);
        sb.append(this.eFo);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.dOz);
        sb.append(this.eFq);
        sb.append(this.eFv);
        sb.append(this.edJ);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eFu);
        sb.append(this.eFy);
        sb.append(this.eFx);
        sb.append(this.eFz);
        sb.append(this.mThreadType);
        sb.append(this.eFC);
        sb.append(this.eFD);
        sb.append(this.eFE);
        if (this.eFI != null) {
            sb.append(this.eFI);
        }
        return sb.toString();
    }

    public String aPr() {
        return this.eFz;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eFk;
    }

    public void oP(String str) {
        this.eFk = str;
    }

    public String getThreadID() {
        return this.eFj;
    }

    public boolean getHostMode() {
        return this.eFm;
    }

    public boolean aPs() {
        return this.eFo;
    }

    public boolean aPt() {
        return this.eFv;
    }

    public boolean aPu() {
        return this.eFp;
    }

    public boolean aPv() {
        return this.edJ;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aPw() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aCm() {
        return this.dOz;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void ia(int i) {
        this.dOz = i;
    }

    public boolean aPx() {
        return this.eFu;
    }

    public boolean aPy() {
        if (this.eFA == null) {
            return false;
        }
        return this.eFA.isValid();
    }

    public String rx() {
        if (this.eFA == null || !this.eFA.nz()) {
            return null;
        }
        return this.eFA.ny();
    }

    public boolean pj(int i) {
        this.eFr = i;
        if (this.eFr > this.eFA.qq().qh()) {
            this.eFr = this.eFA.qq().qh();
        }
        if (this.eFr < 1) {
            this.eFr = 1;
        }
        if (this.eFj == null) {
            return false;
        }
        return pn(5);
    }

    public boolean pk(int i) {
        int sc = this.eFA.aMW().sc();
        if (i <= sc) {
            sc = i;
        }
        int i2 = sc >= 1 ? sc : 1;
        if (this.eFj == null) {
            return false;
        }
        this.eFT = i2;
        return pn(7);
    }

    public void pl(int i) {
        this.eFr = i;
        this.eFs = i;
        this.eFt = i;
    }

    public void pm(int i) {
        if (this.eFs < i) {
            this.eFs = i;
            if (this.eFs - this.eFt >= eFi) {
                this.eFt = (this.eFs - eFi) + 1;
            }
        }
        if (this.eFt > i) {
            this.eFt = i;
            if (this.eFs - this.eFt >= eFi) {
                this.eFs = (this.eFt + eFi) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eFA;
    }

    public com.baidu.tbadk.core.data.ap arn() {
        if (this.eFA == null) {
            return null;
        }
        return this.eFA.qq();
    }

    public boolean aPz() {
        if (this.eFo && this.eFA.qq().qm() == 0) {
            iX(true);
            return true;
        }
        return false;
    }

    public void oJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.eFj = str;
            this.eFk = null;
            this.eFm = false;
            this.eFo = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eFj == null) {
            return false;
        }
        cancelLoadData();
        if (this.cdn == null) {
            this.cdn = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.cdn.start();
        }
        boolean pn = pn(3);
        if (this.opType != null) {
            this.opType = null;
            this.eFH = null;
            this.opUrl = null;
            return pn;
        }
        return pn;
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
        if (this.eGe != null) {
            this.eGe.cancelLoadData();
        }
        if (this.eGa != null) {
            this.eGa.cancelLoadData();
        }
        if (this.eGf != null) {
            this.eGf.cancelLoadData();
        }
        adf();
    }

    private void adf() {
        if (this.cdn != null) {
            this.cdn.destory();
            this.cdn = null;
        }
    }

    public boolean ET() {
        return (this.eFk == null || this.eFk.equals("0") || this.eFk.length() == 0) ? LoadData() : aPC();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        if (forumData != null && !TextUtils.isEmpty(forumData.getId()) && !TextUtils.isEmpty(forumData.getName())) {
            this.eGe.a(forumData.getId(), forumData.getName(), aVar);
        }
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.eGf == null) {
                this.eGf = new GetSugMatchWordsModel(this.boA.getPageContext());
            }
            this.eGf.b(aVar);
        }
    }

    public boolean pn(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        po(i);
        final com.baidu.tieba.pb.data.f pbData = ae.aQz().getPbData();
        if (pbData != null && pbData.aMW() != null) {
            pbData.aMW().bQ(0);
            this.eFo = ae.aQz().aPs();
            this.eFm = ae.aQz().aQE();
            this.eFp = ae.aQz().aQF();
            this.eGj = ae.aQz().aQD();
            this.eGk = ae.aQz().aQC();
            this.eGl = ae.aQz().aQB();
            this.eGg = this.eFm;
            if (this.eFm || this.isFromMark) {
                this.eFL = false;
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
        if (i == 4 && !this.eFP) {
            a(aPH(), true, this.eFk, 3);
        }
        if (i == 3 && !this.eFP) {
            if (this.isFromMark) {
                a(aPH(), true, this.eFk, 3);
            } else {
                a(aPH(), false, this.eFk, 3);
            }
        }
        this.eFP = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.azx);
        if (this.eFm || this.isFromMark) {
            this.eFL = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eFj == null || this.eFj.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eFj, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ad = com.baidu.adp.lib.util.l.ad(TbadkCoreApplication.getInst().getApp());
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.an.vl().vn() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ad));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.eFo) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eFm) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eFy) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eFx));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eFL) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eFH, 0));
            pbPageRequestMessage.setOpMessageID(this.eFx);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aMY = this.eFA.aMY();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eFo) {
                        if (this.eFt - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eFt - 1));
                        }
                    } else if (this.eFs < this.bQd) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eFs + 1));
                    }
                }
                if (aMY != null && aMY.size() > 0) {
                    int size = aMY.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aMY.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.eFk = postData.getId();
                            if (StringUtils.isNull(this.eFk)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.eFk != null && this.eFk.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eFk, 0L));
                } else if (!this.eFo) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aMY != null && aMY.size() > 0 && aMY.get(0) != null) {
                    this.eFk = aMY.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eFo) {
                        if (this.eFt - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eFt - 1));
                        }
                    } else if (this.eFs < this.bQd) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eFs + 1));
                    }
                }
                if (this.eFk != null && this.eFk.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eFk, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.eFm) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eFo) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eFk, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eFr));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eFo && this.eGg && !this.eFm) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eFk, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.eFm) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eFT);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eGi, 0L));
                if (!this.eFo) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.eGg = this.eFm;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aPH());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.boA != null && (this.boA instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.boA).aOa());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.eFS);
        pbPageRequestMessage.setFromSmartFrs(this.eFV ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eFl);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aPr()) && com.baidu.tieba.recapp.r.bfO().bfI() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bfO().bfI().U(aPr(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bfO().bfI().V(aPr(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aPr()) && com.baidu.tieba.recapp.r.bfO().bfI() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bfO().bfI().V(aPr(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bfO().bfI().U(aPr(), true));
        }
    }

    protected void po(int i) {
        boolean z = false;
        pr(i);
        ArrayList<PostData> aMY = this.eFA.aMY();
        this.eFO = false;
        if (i == 1) {
            boolean z2 = false;
            while (aMY.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aMY.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eFA.qq().bM(1);
                if (this.eFG != null) {
                    this.eFG.e(this.eFA);
                }
            }
            this.cEs = System.currentTimeMillis();
            this.eFO = true;
        } else if (i == 2) {
            while (aMY.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aMY.remove(aMY.size() - 1);
                z = true;
            }
            if (z) {
                this.eFA.qq().bL(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.eFW = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            g(fVar2);
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

    protected void g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            if (this.eFE || this.eFC || this.eFD) {
                fVar = i(fVar);
            }
            h(fVar);
        }
    }

    protected void h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String j = j(fVar);
            for (int i = 0; i < fVar.aMY().size(); i++) {
                PostData postData = fVar.aMY().get(i);
                for (int i2 = 0; i2 < postData.brn().size(); i2++) {
                    postData.brn().get(i2).b(this.boA.getPageContext(), j.equals(postData.brn().get(i2).getAuthor().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n aNg = fVar.aNg();
            if (aNg != null && !com.baidu.tbadk.core.util.v.u(aNg.ezg)) {
                for (PostData postData2 : aNg.ezg) {
                    for (int i3 = 0; i3 < postData2.brn().size(); i3++) {
                        postData2.brn().get(i3).b(this.boA.getPageContext(), j.equals(postData2.brn().get(i3).getAuthor().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String j = j(fVar);
            com.baidu.tieba.pb.data.n aNg = fVar.aNg();
            if (aNg != null && !com.baidu.tbadk.core.util.v.u(aNg.ezg)) {
                for (PostData postData : aNg.ezg.subList(i, aNg.ezg.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.brn().size()) {
                            postData.brn().get(i3).b(this.boA.getPageContext(), j.equals(postData.brn().get(i3).getAuthor().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.f i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null) {
            return null;
        }
        bh aMW = fVar.aMW();
        aMW.bU(this.mIsGood);
        aMW.bT(this.dOz);
        if (this.eFq > 0) {
            aMW.m(this.eFq);
            return fVar;
        }
        return fVar;
    }

    protected String j(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aMW() != null && fVar.aMW().getAuthor() != null) {
            str = fVar.aMW().getAuthor().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String k(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aMW() != null && fVar.aMW().getAuthor() != null) {
            str = fVar.aMW().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String l(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aMW() != null && fVar.aMW().getAuthor() != null) {
            str = fVar.aMW().getAuthor().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aPA() {
        if (this.eFA == null || this.eFA.aMW() == null || this.eFA.aMW().getAuthor() == null) {
            return null;
        }
        return this.eFA.aMW().getAuthor();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        boolean z4 = !z;
        this.eFU = z3;
        this.eFB = i;
        if (this.cdn != null && !z3) {
            this.cdn.a(z2, z4, i2, str, i3, j, j2);
            this.cdn = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aPr()) && com.baidu.tieba.recapp.r.bfO().bfI() != null) {
            com.baidu.tieba.recapp.r.bfO().bfI().g(aPr(), pp(aPJ()), true);
        }
        if (fVar == null || (this.eFr == 1 && i == 5 && fVar.aMY() != null && fVar.aMY().size() < 1)) {
            if (this.eFG != null) {
                this.eFo = this.eFn;
                this.eFG.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eFn = this.eFo;
            this.eFy = false;
            if (fVar.qq() != null) {
                pm(fVar.qq().qk());
                this.bQd = fVar.qq().qh();
            }
            this.bQd = this.bQd < 1 ? 1 : this.bQd;
            ArrayList<PostData> aMY = this.eFA.aMY();
            switch (i) {
                case 1:
                    this.eFA.a(fVar.qq(), 1);
                    f(fVar, aMY);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aMY() == null) {
                        i5 = 0;
                    } else {
                        int size = fVar.aMY().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aMY, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aMY(), com.baidu.tbadk.core.util.v.t(fVar.aMY()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aMY().remove(postData2);
                            i5 = size - 1;
                        }
                        aMY.addAll(0, fVar.aMY());
                    }
                    this.eFA.a(fVar.qq(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.eFo && fVar.qq() != null) {
                        fVar.qq().bJ(fVar.qq().qh());
                    }
                    m(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eFo) {
                        aPB();
                        i4 = 0;
                        break;
                    }
                    i4 = 0;
                    break;
                case 4:
                    m(fVar);
                    i4 = 0;
                    break;
                case 5:
                    m(fVar);
                    i4 = 0;
                    break;
                case 6:
                    m(fVar);
                    i4 = 0;
                    break;
                case 7:
                    m(fVar);
                    i4 = 0;
                    break;
                case 8:
                    if (fVar != null && !com.baidu.tbadk.core.util.v.u(fVar.aMY()) && this.eFA != null && (!this.eFm || j(fVar).equals(fVar.aMY().get(0).getAuthor().getUserId()))) {
                        if (this.eFA.qq().qm() == 0) {
                            this.eFA.qq().bL(1);
                        }
                        aPY();
                        this.eGj = fVar.aMY().get(0);
                        if (this.eFo) {
                            if (this.eFA.aMY().size() - this.eGl >= 3) {
                                this.eGk = new PostData();
                                this.eGk.ggX = true;
                                this.eGk.setPostType(53);
                                this.eFA.aMY().add(this.eGk);
                            }
                            this.eFA.aMY().add(this.eGj);
                            i4 = this.eFA.aMY().size() - 1;
                            break;
                        } else {
                            if (this.eGl - this.eGm >= 3) {
                                this.eGk = new PostData();
                                this.eGk.ggX = false;
                                this.eGk.setPostType(53);
                                this.eFA.aMY().add(0, this.eGk);
                            }
                            this.eFA.aMY().add(0, this.eGj);
                            i4 = 0;
                            break;
                        }
                    }
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.eFA != null && this.eFA.aMW() != null) {
                PraiseData re = this.eFA.aMW().re();
                if (this.eGp != null && !re.isPriaseDataValid()) {
                    this.eFA.aMW().a(this.eGp);
                } else {
                    this.eGp = this.eFA.aMW().re();
                    this.eGp.setPostId(this.eFA.aMW().rE());
                }
                if (fVar.qq() != null && fVar.qq().qk() == 1 && fVar.aMW() != null && fVar.aMW().rz() != null && fVar.aMW().rz().size() > 0) {
                    this.eFA.aMW().h(fVar.aMW().rz());
                }
                this.eFA.aMW().bR(fVar.aMW().rg());
                this.eFA.aMW().bO(fVar.aMW().getAnchorLevel());
                this.eFA.aMW().bQ(fVar.aMW().rb());
                if (this.mThreadType == 33) {
                    this.eFA.aMW().getAuthor().setHadConcerned(fVar.aMW().getAuthor().hadConcerned());
                }
            }
            if (this.eFA != null && this.eFA.getUserData() != null && fVar.getUserData() != null) {
                this.eFA.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eFA.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qq() != null && fVar.qq().qk() == 1 && fVar.aNf() != null) {
                this.eFA.d(fVar.aNf());
            }
            if (this.eFU && this.eFA.aMW() != null && this.eFA.aMW().getAuthor() != null && this.eFA.aMY() != null && com.baidu.tbadk.core.util.v.c(this.eFA.aMY(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.eFA.aMY(), 0);
                MetaData author = this.eFA.aMW().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.eFJ != -1) {
                        author.setFansNum(this.eFJ);
                        postData3.getAuthor().setFansNum(this.eFJ);
                    }
                    if (this.eFK != -1) {
                        author.getGodUserData().setIsLike(this.eFK == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.eFK == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eFG != null) {
                this.eFG.a(true, getErrorCode(), i, i4, this.eFA, this.mErrorString, 1);
            }
        }
        if (this.eFA != null && this.eFA.aMW() != null && this.eFA.aMU() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.boA;
            historyMessage.threadId = getPbData().aMW().getId();
            historyMessage.forumName = getPbData().aMU().getName();
            historyMessage.threadName = getPbData().aMW().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aPs();
            historyMessage.threadType = getPbData().aMW().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void f(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ai;
        if (arrayList != null && fVar.aMY() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aMY(), 0);
            if (postData != null && (ai = ai(arrayList)) != null && ai.equals(postData.getId())) {
                fVar.aMY().remove(postData);
            }
            arrayList.addAll(fVar.aMY());
        }
    }

    private int pp(int i) {
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

    private String ai(ArrayList<PostData> arrayList) {
        int t = com.baidu.tbadk.core.util.v.t(arrayList);
        if (t <= 0) {
            return null;
        }
        for (int i = t - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.tieba.pb.data.f fVar) {
        fVar.oH(this.eFA.aNn());
        this.eFA = fVar;
        pl(fVar.qq().qk());
    }

    private void aPB() {
        if (this.eFA != null && this.eFA.aMY() != null && this.eFA.aNl() != null) {
            ArrayList<PostData> aMY = this.eFA.aMY();
            com.baidu.tieba.pb.data.a aNl = this.eFA.aNl();
            int aMM = aNl.aMM();
            if (aMM > 0) {
                if (aMM <= aMY.size()) {
                    aMY.add(aMM, aNl);
                } else {
                    aMY.add(aNl);
                }
            }
        }
    }

    public boolean aPC() {
        if (this.eFj == null || this.eFk == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return pn(4);
        }
        return pn(6);
    }

    public boolean iX(boolean z) {
        if (this.eFj == null || this.eFA == null) {
            return false;
        }
        if (z || this.eFA.qq().qm() != 0) {
            return pn(1);
        }
        return false;
    }

    public boolean iY(boolean z) {
        if (this.eFj == null || this.eFA == null) {
            return false;
        }
        if ((z || this.eFA.qq().qn() != 0) && this.eFA.aMY() != null && this.eFA.aMY().size() >= 1) {
            return pn(2);
        }
        return false;
    }

    public boolean oQ(String str) {
        this.eFm = !this.eFm;
        this.eFk = str;
        if (pn(6)) {
            return true;
        }
        this.eFm = this.eFm ? false : true;
        return false;
    }

    public boolean j(boolean z, String str) {
        if (this.eFm == z) {
            return false;
        }
        this.eFm = z;
        this.eFk = str;
        if (pn(6)) {
            return true;
        }
        this.eFm = z ? false : true;
        return false;
    }

    public boolean aPD() {
        this.eFn = this.eFo;
        this.eFo = !this.eFo;
        if (this.isLoading || !LoadData()) {
            this.eFo = this.eFo ? false : true;
            return false;
        }
        return true;
    }

    public boolean aPE() {
        return this.eFo;
    }

    public boolean hasData() {
        return (this.eFA == null || this.eFA.aMU() == null || this.eFA.aMW() == null) ? false : true;
    }

    public boolean nz() {
        if (this.eFA == null) {
            return false;
        }
        return this.eFA.nz();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fI(String str) {
        if (this.eFA == null || this.eFA.aMW() == null || this.eFA.aMU() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eFA.aMW().sA()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eFA.aMU().getId());
            writeData.setForumName(this.eFA.aMU().getName());
        }
        writeData.setThreadId(this.eFj);
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

    public MarkData pq(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.eFA == null) {
            return null;
        }
        ArrayList<PostData> aMY = this.eFA.aMY();
        if (com.baidu.tbadk.core.util.v.u(aMY)) {
            return null;
        }
        if (aMY.size() > 0 && i >= aMY.size()) {
            i = aMY.size() - 1;
        }
        return i(aMY.get(i));
    }

    public MarkData aPF() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eFj);
        markData.setPostId(this.eFA.ny());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eFm);
        markData.setSequence(Boolean.valueOf(this.eFo));
        markData.setId(this.eFj);
        return markData;
    }

    public MarkData i(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eFj);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eFm);
        markData.setSequence(Boolean.valueOf(this.eFo));
        markData.setId(this.eFj);
        markData.setFloor(postData.brq());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aPG() {
        g.aPh().O(aPH(), this.isFromMark);
    }

    private String aPH() {
        String str = this.eFj;
        if (this.eFm) {
            str = str + DB_KEY_HOST;
        }
        if (!this.eFo) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void iZ(boolean z) {
        if (this.eFA != null) {
            this.eFA.ac(z);
        }
    }

    public void ja(boolean z) {
        this.eFL = z;
    }

    public boolean aPI() {
        return this.eFL;
    }

    public void a(a aVar) {
        this.eFG = aVar;
    }

    public void oo(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CO() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CN() {
        return ET();
    }

    public boolean oR(String str) {
        if (getPbData() == null || getPbData().aMW() == null || getPbData().aMW().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aMW().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aPJ() {
        return this.mRequestType;
    }

    public void aPK() {
        String aPH = aPH();
        g.aPh().O(aPH, false);
        g.aPh().O(aPH, true);
    }

    public void aPL() {
        if ("personalize_page".equals(this.mStType)) {
            this.eFR = System.currentTimeMillis() / 1000;
        }
    }

    public void aPM() {
        if ("personalize_page".equals(this.mStType) && this.eFA != null && this.eFR != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ac("fid", this.eFA.getForumId()).ac("tid", this.eFj).ac("obj_duration", String.valueOf(currentTimeMillis - this.eFR)).ac("obj_param3", String.valueOf(currentTimeMillis)));
            this.eFR = 0L;
        }
    }

    public boolean aPN() {
        return this.eFU;
    }

    public int getErrorNo() {
        return this.eFW;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public h aPO() {
        return this.eFY;
    }

    public m aPP() {
        return this.eFZ;
    }

    public PbFloorAgreeModel aPQ() {
        return this.eGa;
    }

    public v aPR() {
        return this.eGb;
    }

    public CheckRealNameModel aPS() {
        return this.bqN;
    }

    public AddExperiencedModel aPT() {
        return this.eGd;
    }

    public String aPU() {
        return this.eFQ;
    }

    public void oS(String str) {
        this.eFQ = str;
    }

    public boolean aPV() {
        return this.eFV;
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.eFA != null && this.eFA.aMY() != null && this.eFA.aMY().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eFA.aMY().size();
                for (int i = 0; i < size; i++) {
                    if (this.eFA.aMY().get(i) != null && this.eFA.aMY().get(i).getAuthor() != null && currentAccount.equals(this.eFA.aMY().get(i).getAuthor().getUserId()) && this.eFA.aMY().get(i).getAuthor().getPendantData() != null) {
                        this.eFA.aMY().get(i).getAuthor().getPendantData().cz(iVar.pL());
                        this.eFA.aMY().get(i).getAuthor().getPendantData().Q(iVar.BU());
                    }
                }
            }
        }
    }

    public String aPW() {
        return this.eGc;
    }

    public int aPX() {
        return this.eGh;
    }

    public void oT(String str) {
        if ((!this.eFm || oR(TbadkCoreApplication.getCurrentAccount())) && this.eFA.aMY() != null) {
            this.eFA.qq().bL(1);
            if (this.eFA.qq().qm() == 0) {
                this.eFA.qq().bL(1);
            }
            this.eGi = str;
            pn(8);
        }
    }

    private void pr(int i) {
        if (i != 8) {
            this.eGi = "";
            if (this.eGj != null) {
                if (i == 1 && !this.eFo && !com.baidu.tbadk.core.util.v.u(getPbData().aMY())) {
                    getPbData().aMY().remove(this.eGj);
                    if (this.eGk != null) {
                        getPbData().aMY().remove(this.eGk);
                    }
                    getPbData().aMY().add(0, this.eGj);
                } else {
                    getPbData().aMY().remove(this.eGj);
                    if (this.eGk != null) {
                        getPbData().aMY().remove(this.eGk);
                    }
                }
            }
            this.eGk = null;
        }
    }

    public void aPY() {
        if (this.eFA != null && !com.baidu.tbadk.core.util.v.u(this.eFA.aMY())) {
            if (this.eGk != null) {
                this.eFA.aMY().remove(this.eGk);
                this.eGk = null;
            }
            if (this.eGj != null) {
                this.eFA.aMY().remove(this.eGj);
                this.eGj = null;
            }
        }
    }

    public void bt(int i, int i2) {
        this.eGl = i;
        this.eGm = i2;
    }

    public PostData aPZ() {
        return this.eGj;
    }

    public PostData aQa() {
        return this.eGk;
    }

    public int aQb() {
        return this.eGl;
    }
}
