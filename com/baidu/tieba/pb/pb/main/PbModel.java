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
    private int bQp;
    private BaseActivity boM;
    private final CheckRealNameModel bqZ;
    private long cEE;
    private com.baidu.tieba.tbadkCore.d.b cdz;
    private int dON;
    private com.baidu.adp.framework.listener.a dOX;
    private boolean eFA;
    private boolean eFB;
    private boolean eFC;
    private boolean eFD;
    private long eFE;
    private int eFF;
    private int eFG;
    private int eFH;
    private boolean eFI;
    private boolean eFJ;
    private boolean eFK;
    private long eFL;
    private boolean eFM;
    private String eFN;
    protected com.baidu.tieba.pb.data.f eFO;
    private int eFP;
    private boolean eFQ;
    private boolean eFR;
    private boolean eFS;
    private boolean eFT;
    private a eFU;
    private String eFV;
    private String eFW;
    private int eFX;
    private int eFY;
    private boolean eFZ;
    protected String eFx;
    private String eFy;
    private boolean eFz;
    private int eGA;
    private CustomMessageListener eGB;
    private CustomMessageListener eGC;
    private PraiseData eGD;
    private boolean eGa;
    private boolean eGb;
    private boolean eGc;
    private boolean eGd;
    private String eGe;
    private long eGf;
    private boolean eGg;
    private int eGh;
    private boolean eGi;
    private boolean eGj;
    private int eGk;
    private final t eGl;
    private final h eGm;
    private final m eGn;
    private final PbFloorAgreeModel eGo;
    private final v eGp;
    private String eGq;
    private final AddExperiencedModel eGr;
    private SuggestEmotionModel eGs;
    private GetSugMatchWordsModel eGt;
    private boolean eGu;
    private int eGv;
    private String eGw;
    private PostData eGx;
    private PostData eGy;
    private int eGz;
    private boolean edX;
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
    private static final int eFw = com.baidu.tbadk.data.b.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.f fVar);
    }

    public void iX(boolean z) {
        this.eGg = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eFx = null;
        this.eFy = null;
        this.mForumId = null;
        this.eFz = false;
        this.eFA = false;
        this.eFB = true;
        this.eFC = true;
        this.eFD = false;
        this.mIsGood = 0;
        this.dON = 0;
        this.eFE = 0L;
        this.eFF = 1;
        this.eFG = 1;
        this.eFH = 1;
        this.bQp = 1;
        this.isAd = false;
        this.eFI = false;
        this.eFJ = false;
        this.edX = false;
        this.isFromMark = false;
        this.eFK = false;
        this.eFL = 0L;
        this.eFM = false;
        this.eFN = null;
        this.eFO = null;
        this.isLoading = false;
        this.eFQ = false;
        this.eFR = false;
        this.eFS = false;
        this.eFT = false;
        this.mLocate = null;
        this.mContext = null;
        this.eFU = null;
        this.opType = null;
        this.opUrl = null;
        this.eFV = null;
        this.eFW = null;
        this.eFX = -1;
        this.eFY = -1;
        this.cdz = null;
        this.eGa = false;
        this.eGb = false;
        this.postID = null;
        this.eGe = null;
        this.eGf = 0L;
        this.eGg = false;
        this.eGh = -1;
        this.eGj = false;
        this.eGu = false;
        this.eGv = 0;
        this.eGB = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.eGd = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.g(pbData);
                    if (pbData.aNb() != null) {
                        pbData.aNb().bR(0);
                    }
                    if (PbModel.this.eFU != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.eFU.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.eGC = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aMZ() != null && PbModel.this.getPbData().aMZ().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aMZ().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.dOX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.hh()) {
                        PbModel.this.boM.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.eGa || !PbModel.this.eGb) {
                        if (!PbModel.this.eGa) {
                            PbModel.this.eGa = true;
                        } else {
                            PbModel.this.eGb = true;
                        }
                        if (PbModel.this.eFU != null) {
                            PbModel.this.eFU.a(PbModel.this.aPu(), z, responsedMessage, PbModel.this.eGc, System.currentTimeMillis() - PbModel.this.cEE);
                        }
                    }
                }
            }
        };
        this.eGD = null;
        registerListener(this.eGB);
        registerListener(this.dOX);
        registerListener(this.eGC);
        this.eFO = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.boM = baseActivity;
        this.eGl = new t(this, this.boM);
        this.eGm = new h(this, this.boM);
        this.eGn = new m(this, this.boM);
        this.eGo = new PbFloorAgreeModel(this);
        this.eGp = new v(this, this.boM);
        this.bqZ = new CheckRealNameModel(this.boM.getPageContext());
        this.eGs = new SuggestEmotionModel();
        this.eGr = new AddExperiencedModel(this.boM.getPageContext());
    }

    protected int aPu() {
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
        this.eFx = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eFx)) {
            this.eFx = this.eGl.T(intent);
        }
        this.eGv = intent.getIntExtra(PbActivityConfig.KEY_START_FROM, 0);
        this.eFy = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eFz = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eFA = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eFC = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dON = intent.getIntExtra("is_top", 0);
        this.eFE = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eFK = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eFI = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eFM = intent.getBooleanExtra("is_pv", false);
        this.eFL = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eFN = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eFW = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.eFV = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.eFQ = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eFR = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eFS = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eFY = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eFX = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eFJ = intent.getBooleanExtra("from_frs", false);
        this.edX = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eGj = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eFT = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
        this.eGq = intent.getStringExtra(PbActivityConfig.KEY_POST_THREAD_TIP);
    }

    public void initWithBundle(Bundle bundle) {
        this.eGv = bundle.getInt(PbActivityConfig.KEY_START_FROM, 0);
        this.eFx = bundle.getString("thread_id");
        this.eFy = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eFz = bundle.getBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eFA = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eFC = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dON = bundle.getInt("is_top", 0);
        this.eFE = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eFK = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eFI = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eFM = bundle.getBoolean("is_pv", false);
        this.eFL = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eFN = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eFW = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.eFQ = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eFR = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eFS = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eFY = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eFX = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eFJ = bundle.getBoolean("from_frs", false);
        this.edX = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eGj = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eFT = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void u(Bundle bundle) {
        bundle.putString("thread_id", this.eFx);
        bundle.putString("post_id", this.eFy);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt(PbActivityConfig.KEY_START_FROM, this.eGv);
        bundle.putBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, this.eFz);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.eFA);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.eFC);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dON);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.eFE);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.eFK);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.eFI);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eFM);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.eFL);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.eFW);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.eFQ);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.eFR);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.eFS);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.eFY);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.eFX);
        bundle.putBoolean("from_frs", this.eFJ);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.edX);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.eGj);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.eFT);
    }

    public String aPv() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eFx);
        if (!this.eFK) {
            sb.append(this.eFy);
        }
        sb.append(this.eFA);
        sb.append(this.eFC);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.dON);
        sb.append(this.eFE);
        sb.append(this.eFJ);
        sb.append(this.edX);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eFI);
        sb.append(this.eFM);
        sb.append(this.eFL);
        sb.append(this.eFN);
        sb.append(this.mThreadType);
        sb.append(this.eFQ);
        sb.append(this.eFR);
        sb.append(this.eFS);
        if (this.eFW != null) {
            sb.append(this.eFW);
        }
        return sb.toString();
    }

    public String aPw() {
        return this.eFN;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eFy;
    }

    public void oQ(String str) {
        this.eFy = str;
    }

    public String getThreadID() {
        return this.eFx;
    }

    public boolean getHostMode() {
        return this.eFA;
    }

    public boolean aPx() {
        return this.eFC;
    }

    public boolean aPy() {
        return this.eFJ;
    }

    public boolean aPz() {
        return this.eFD;
    }

    public boolean aPA() {
        return this.edX;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aPB() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aCr() {
        return this.dON;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void ib(int i) {
        this.dON = i;
    }

    public boolean aPC() {
        return this.eFI;
    }

    public boolean aPD() {
        if (this.eFO == null) {
            return false;
        }
        return this.eFO.isValid();
    }

    public String rE() {
        if (this.eFO == null || !this.eFO.nG()) {
            return null;
        }
        return this.eFO.nF();
    }

    public boolean pk(int i) {
        this.eFF = i;
        if (this.eFF > this.eFO.qx().qo()) {
            this.eFF = this.eFO.qx().qo();
        }
        if (this.eFF < 1) {
            this.eFF = 1;
        }
        if (this.eFx == null) {
            return false;
        }
        return po(5);
    }

    public boolean pl(int i) {
        int sj = this.eFO.aNb().sj();
        if (i <= sj) {
            sj = i;
        }
        int i2 = sj >= 1 ? sj : 1;
        if (this.eFx == null) {
            return false;
        }
        this.eGh = i2;
        return po(7);
    }

    public void pm(int i) {
        this.eFF = i;
        this.eFG = i;
        this.eFH = i;
    }

    public void pn(int i) {
        if (this.eFG < i) {
            this.eFG = i;
            if (this.eFG - this.eFH >= eFw) {
                this.eFH = (this.eFG - eFw) + 1;
            }
        }
        if (this.eFH > i) {
            this.eFH = i;
            if (this.eFG - this.eFH >= eFw) {
                this.eFG = (this.eFH + eFw) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eFO;
    }

    public com.baidu.tbadk.core.data.ap ars() {
        if (this.eFO == null) {
            return null;
        }
        return this.eFO.qx();
    }

    public boolean aPE() {
        if (this.eFC && this.eFO.qx().qt() == 0) {
            iY(true);
            return true;
        }
        return false;
    }

    public void oK(String str) {
        if (!StringUtils.isNull(str)) {
            this.eFx = str;
            this.eFy = null;
            this.eFA = false;
            this.eFC = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eFx == null) {
            return false;
        }
        cancelLoadData();
        if (this.cdz == null) {
            this.cdz = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.cdz.start();
        }
        boolean po = po(3);
        if (this.opType != null) {
            this.opType = null;
            this.eFV = null;
            this.opUrl = null;
            return po;
        }
        return po;
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
        if (this.eGs != null) {
            this.eGs.cancelLoadData();
        }
        if (this.eGo != null) {
            this.eGo.cancelLoadData();
        }
        if (this.eGt != null) {
            this.eGt.cancelLoadData();
        }
        adj();
    }

    private void adj() {
        if (this.cdz != null) {
            this.cdz.destory();
            this.cdz = null;
        }
    }

    public boolean EZ() {
        return (this.eFy == null || this.eFy.equals("0") || this.eFy.length() == 0) ? LoadData() : aPH();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        if (forumData != null && !TextUtils.isEmpty(forumData.getId()) && !TextUtils.isEmpty(forumData.getName())) {
            this.eGs.a(forumData.getId(), forumData.getName(), aVar);
        }
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.eGt == null) {
                this.eGt = new GetSugMatchWordsModel(this.boM.getPageContext());
            }
            this.eGt.b(aVar);
        }
    }

    public boolean po(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        pp(i);
        final com.baidu.tieba.pb.data.f pbData = ae.aQE().getPbData();
        if (pbData != null && pbData.aNb() != null) {
            pbData.aNb().bR(0);
            this.eFC = ae.aQE().aPx();
            this.eFA = ae.aQE().aQJ();
            this.eFD = ae.aQE().aQK();
            this.eGx = ae.aQE().aQI();
            this.eGy = ae.aQE().aQH();
            this.eGz = ae.aQE().aQG();
            this.eGu = this.eFA;
            if (this.eFA || this.isFromMark) {
                this.eFZ = false;
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
        if (i == 4 && !this.eGd) {
            a(aPM(), true, this.eFy, 3);
        }
        if (i == 3 && !this.eGd) {
            if (this.isFromMark) {
                a(aPM(), true, this.eFy, 3);
            } else {
                a(aPM(), false, this.eFy, 3);
            }
        }
        this.eGd = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.azJ);
        if (this.eFA || this.isFromMark) {
            this.eFZ = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eFx == null || this.eFx.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eFx, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ad = com.baidu.adp.lib.util.l.ad(TbadkCoreApplication.getInst().getApp());
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.an.vs().vu() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ad));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.eFC) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eFA) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eFM) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eFL));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eFZ) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eFV, 0));
            pbPageRequestMessage.setOpMessageID(this.eFL);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aNd = this.eFO.aNd();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eFC) {
                        if (this.eFH - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eFH - 1));
                        }
                    } else if (this.eFG < this.bQp) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eFG + 1));
                    }
                }
                if (aNd != null && aNd.size() > 0) {
                    int size = aNd.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aNd.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.eFy = postData.getId();
                            if (StringUtils.isNull(this.eFy)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.eFy != null && this.eFy.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eFy, 0L));
                } else if (!this.eFC) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aNd != null && aNd.size() > 0 && aNd.get(0) != null) {
                    this.eFy = aNd.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eFC) {
                        if (this.eFH - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eFH - 1));
                        }
                    } else if (this.eFG < this.bQp) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eFG + 1));
                    }
                }
                if (this.eFy != null && this.eFy.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eFy, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.eFA) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eFC) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eFy, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eFF));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eFC && this.eGu && !this.eFA) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eFy, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.eFA) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eGh);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eGw, 0L));
                if (!this.eFC) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.eGu = this.eFA;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aPM());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.boM != null && (this.boM instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.boM).aOf());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.eGg);
        pbPageRequestMessage.setFromSmartFrs(this.eGj ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eFz);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aPw()) && com.baidu.tieba.recapp.r.bfU().bfO() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bfU().bfO().U(aPw(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bfU().bfO().V(aPw(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aPw()) && com.baidu.tieba.recapp.r.bfU().bfO() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bfU().bfO().V(aPw(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bfU().bfO().U(aPw(), true));
        }
    }

    protected void pp(int i) {
        boolean z = false;
        ps(i);
        ArrayList<PostData> aNd = this.eFO.aNd();
        this.eGc = false;
        if (i == 1) {
            boolean z2 = false;
            while (aNd.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aNd.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eFO.qx().bN(1);
                if (this.eFU != null) {
                    this.eFU.e(this.eFO);
                }
            }
            this.cEE = System.currentTimeMillis();
            this.eGc = true;
        } else if (i == 2) {
            while (aNd.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aNd.remove(aNd.size() - 1);
                z = true;
            }
            if (z) {
                this.eFO.qx().bM(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.eGk = i2;
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
            if (this.eFS || this.eFQ || this.eFR) {
                fVar = i(fVar);
            }
            h(fVar);
        }
    }

    protected void h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String j = j(fVar);
            for (int i = 0; i < fVar.aNd().size(); i++) {
                PostData postData = fVar.aNd().get(i);
                for (int i2 = 0; i2 < postData.brv().size(); i2++) {
                    postData.brv().get(i2).b(this.boM.getPageContext(), j.equals(postData.brv().get(i2).getAuthor().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n aNl = fVar.aNl();
            if (aNl != null && !com.baidu.tbadk.core.util.v.u(aNl.ezu)) {
                for (PostData postData2 : aNl.ezu) {
                    for (int i3 = 0; i3 < postData2.brv().size(); i3++) {
                        postData2.brv().get(i3).b(this.boM.getPageContext(), j.equals(postData2.brv().get(i3).getAuthor().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String j = j(fVar);
            com.baidu.tieba.pb.data.n aNl = fVar.aNl();
            if (aNl != null && !com.baidu.tbadk.core.util.v.u(aNl.ezu)) {
                for (PostData postData : aNl.ezu.subList(i, aNl.ezu.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.brv().size()) {
                            postData.brv().get(i3).b(this.boM.getPageContext(), j.equals(postData.brv().get(i3).getAuthor().getUserId()));
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
        bh aNb = fVar.aNb();
        aNb.bV(this.mIsGood);
        aNb.bU(this.dON);
        if (this.eFE > 0) {
            aNb.l(this.eFE);
            return fVar;
        }
        return fVar;
    }

    protected String j(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aNb() != null && fVar.aNb().getAuthor() != null) {
            str = fVar.aNb().getAuthor().getUserId();
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
        if (fVar.aNb() != null && fVar.aNb().getAuthor() != null) {
            str = fVar.aNb().getAuthor().getUserName();
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
        if (fVar.aNb() != null && fVar.aNb().getAuthor() != null) {
            str = fVar.aNb().getAuthor().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aPF() {
        if (this.eFO == null || this.eFO.aNb() == null || this.eFO.aNb().getAuthor() == null) {
            return null;
        }
        return this.eFO.aNb().getAuthor();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        boolean z4 = !z;
        this.eGi = z3;
        this.eFP = i;
        if (this.cdz != null && !z3) {
            this.cdz.a(z2, z4, i2, str, i3, j, j2);
            this.cdz = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aPw()) && com.baidu.tieba.recapp.r.bfU().bfO() != null) {
            com.baidu.tieba.recapp.r.bfU().bfO().g(aPw(), pq(aPO()), true);
        }
        if (fVar == null || (this.eFF == 1 && i == 5 && fVar.aNd() != null && fVar.aNd().size() < 1)) {
            if (this.eFU != null) {
                this.eFC = this.eFB;
                this.eFU.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eFB = this.eFC;
            this.eFM = false;
            if (fVar.qx() != null) {
                pn(fVar.qx().qr());
                this.bQp = fVar.qx().qo();
            }
            this.bQp = this.bQp < 1 ? 1 : this.bQp;
            ArrayList<PostData> aNd = this.eFO.aNd();
            switch (i) {
                case 1:
                    this.eFO.a(fVar.qx(), 1);
                    f(fVar, aNd);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aNd() == null) {
                        i5 = 0;
                    } else {
                        int size = fVar.aNd().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aNd, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aNd(), com.baidu.tbadk.core.util.v.t(fVar.aNd()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aNd().remove(postData2);
                            i5 = size - 1;
                        }
                        aNd.addAll(0, fVar.aNd());
                    }
                    this.eFO.a(fVar.qx(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.eFC && fVar.qx() != null) {
                        fVar.qx().bK(fVar.qx().qo());
                    }
                    m(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eFC) {
                        aPG();
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
                    if (fVar != null && !com.baidu.tbadk.core.util.v.u(fVar.aNd()) && this.eFO != null && (!this.eFA || j(fVar).equals(fVar.aNd().get(0).getAuthor().getUserId()))) {
                        if (this.eFO.qx().qt() == 0) {
                            this.eFO.qx().bM(1);
                        }
                        aQd();
                        this.eGx = fVar.aNd().get(0);
                        if (this.eFC) {
                            if (this.eFO.aNd().size() - this.eGz >= 3) {
                                this.eGy = new PostData();
                                this.eGy.ghm = true;
                                this.eGy.setPostType(53);
                                this.eFO.aNd().add(this.eGy);
                            }
                            this.eFO.aNd().add(this.eGx);
                            i4 = this.eFO.aNd().size() - 1;
                            break;
                        } else {
                            if (this.eGz - this.eGA >= 3) {
                                this.eGy = new PostData();
                                this.eGy.ghm = false;
                                this.eGy.setPostType(53);
                                this.eFO.aNd().add(0, this.eGy);
                            }
                            this.eFO.aNd().add(0, this.eGx);
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
            if (this.eFO != null && this.eFO.aNb() != null) {
                PraiseData rl = this.eFO.aNb().rl();
                if (this.eGD != null && !rl.isPriaseDataValid()) {
                    this.eFO.aNb().a(this.eGD);
                } else {
                    this.eGD = this.eFO.aNb().rl();
                    this.eGD.setPostId(this.eFO.aNb().rL());
                }
                if (fVar.qx() != null && fVar.qx().qr() == 1 && fVar.aNb() != null && fVar.aNb().rG() != null && fVar.aNb().rG().size() > 0) {
                    this.eFO.aNb().h(fVar.aNb().rG());
                }
                this.eFO.aNb().bS(fVar.aNb().rn());
                this.eFO.aNb().bP(fVar.aNb().getAnchorLevel());
                this.eFO.aNb().bR(fVar.aNb().ri());
                if (this.mThreadType == 33) {
                    this.eFO.aNb().getAuthor().setHadConcerned(fVar.aNb().getAuthor().hadConcerned());
                }
            }
            if (this.eFO != null && this.eFO.getUserData() != null && fVar.getUserData() != null) {
                this.eFO.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eFO.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qx() != null && fVar.qx().qr() == 1 && fVar.aNk() != null) {
                this.eFO.d(fVar.aNk());
            }
            if (this.eGi && this.eFO.aNb() != null && this.eFO.aNb().getAuthor() != null && this.eFO.aNd() != null && com.baidu.tbadk.core.util.v.c(this.eFO.aNd(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.eFO.aNd(), 0);
                MetaData author = this.eFO.aNb().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.eFX != -1) {
                        author.setFansNum(this.eFX);
                        postData3.getAuthor().setFansNum(this.eFX);
                    }
                    if (this.eFY != -1) {
                        author.getGodUserData().setIsLike(this.eFY == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.eFY == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eFU != null) {
                this.eFU.a(true, getErrorCode(), i, i4, this.eFO, this.mErrorString, 1);
            }
        }
        if (this.eFO != null && this.eFO.aNb() != null && this.eFO.aMZ() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.boM;
            historyMessage.threadId = getPbData().aNb().getId();
            historyMessage.forumName = getPbData().aMZ().getName();
            historyMessage.threadName = getPbData().aNb().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aPx();
            historyMessage.threadType = getPbData().aNb().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void f(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ai;
        if (arrayList != null && fVar.aNd() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aNd(), 0);
            if (postData != null && (ai = ai(arrayList)) != null && ai.equals(postData.getId())) {
                fVar.aNd().remove(postData);
            }
            arrayList.addAll(fVar.aNd());
        }
    }

    private int pq(int i) {
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
        fVar.oI(this.eFO.aNs());
        this.eFO = fVar;
        pm(fVar.qx().qr());
    }

    private void aPG() {
        if (this.eFO != null && this.eFO.aNd() != null && this.eFO.aNq() != null) {
            ArrayList<PostData> aNd = this.eFO.aNd();
            com.baidu.tieba.pb.data.a aNq = this.eFO.aNq();
            int aMR = aNq.aMR();
            if (aMR > 0) {
                if (aMR <= aNd.size()) {
                    aNd.add(aMR, aNq);
                } else {
                    aNd.add(aNq);
                }
            }
        }
    }

    public boolean aPH() {
        if (this.eFx == null || this.eFy == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return po(4);
        }
        return po(6);
    }

    public boolean iY(boolean z) {
        if (this.eFx == null || this.eFO == null) {
            return false;
        }
        if (z || this.eFO.qx().qt() != 0) {
            return po(1);
        }
        return false;
    }

    public boolean iZ(boolean z) {
        if (this.eFx == null || this.eFO == null) {
            return false;
        }
        if ((z || this.eFO.qx().qu() != 0) && this.eFO.aNd() != null && this.eFO.aNd().size() >= 1) {
            return po(2);
        }
        return false;
    }

    public boolean oR(String str) {
        this.eFA = !this.eFA;
        this.eFy = str;
        if (po(6)) {
            return true;
        }
        this.eFA = this.eFA ? false : true;
        return false;
    }

    public boolean j(boolean z, String str) {
        if (this.eFA == z) {
            return false;
        }
        this.eFA = z;
        this.eFy = str;
        if (po(6)) {
            return true;
        }
        this.eFA = z ? false : true;
        return false;
    }

    public boolean aPI() {
        this.eFB = this.eFC;
        this.eFC = !this.eFC;
        if (this.isLoading || !LoadData()) {
            this.eFC = this.eFC ? false : true;
            return false;
        }
        return true;
    }

    public boolean aPJ() {
        return this.eFC;
    }

    public boolean hasData() {
        return (this.eFO == null || this.eFO.aMZ() == null || this.eFO.aNb() == null) ? false : true;
    }

    public boolean nG() {
        if (this.eFO == null) {
            return false;
        }
        return this.eFO.nG();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fJ(String str) {
        if (this.eFO == null || this.eFO.aNb() == null || this.eFO.aMZ() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eFO.aNb().sH()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eFO.aMZ().getId());
            writeData.setForumName(this.eFO.aMZ().getName());
        }
        writeData.setThreadId(this.eFx);
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

    public MarkData pr(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.eFO == null) {
            return null;
        }
        ArrayList<PostData> aNd = this.eFO.aNd();
        if (com.baidu.tbadk.core.util.v.u(aNd)) {
            return null;
        }
        if (aNd.size() > 0 && i >= aNd.size()) {
            i = aNd.size() - 1;
        }
        return i(aNd.get(i));
    }

    public MarkData aPK() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eFx);
        markData.setPostId(this.eFO.nF());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eFA);
        markData.setSequence(Boolean.valueOf(this.eFC));
        markData.setId(this.eFx);
        return markData;
    }

    public MarkData i(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eFx);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eFA);
        markData.setSequence(Boolean.valueOf(this.eFC));
        markData.setId(this.eFx);
        markData.setFloor(postData.bry());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aPL() {
        g.aPm().O(aPM(), this.isFromMark);
    }

    private String aPM() {
        String str = this.eFx;
        if (this.eFA) {
            str = str + DB_KEY_HOST;
        }
        if (!this.eFC) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void ja(boolean z) {
        if (this.eFO != null) {
            this.eFO.ad(z);
        }
    }

    public void jb(boolean z) {
        this.eFZ = z;
    }

    public boolean aPN() {
        return this.eFZ;
    }

    public void a(a aVar) {
        this.eFU = aVar;
    }

    public void op(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CU() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CT() {
        return EZ();
    }

    public boolean oS(String str) {
        if (getPbData() == null || getPbData().aNb() == null || getPbData().aNb().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aNb().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aPO() {
        return this.mRequestType;
    }

    public void aPP() {
        String aPM = aPM();
        g.aPm().O(aPM, false);
        g.aPm().O(aPM, true);
    }

    public void aPQ() {
        if ("personalize_page".equals(this.mStType)) {
            this.eGf = System.currentTimeMillis() / 1000;
        }
    }

    public void aPR() {
        if ("personalize_page".equals(this.mStType) && this.eFO != null && this.eGf != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ad("fid", this.eFO.getForumId()).ad("tid", this.eFx).ad("obj_duration", String.valueOf(currentTimeMillis - this.eGf)).ad("obj_param3", String.valueOf(currentTimeMillis)));
            this.eGf = 0L;
        }
    }

    public boolean aPS() {
        return this.eGi;
    }

    public int getErrorNo() {
        return this.eGk;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public h aPT() {
        return this.eGm;
    }

    public m aPU() {
        return this.eGn;
    }

    public PbFloorAgreeModel aPV() {
        return this.eGo;
    }

    public v aPW() {
        return this.eGp;
    }

    public CheckRealNameModel aPX() {
        return this.bqZ;
    }

    public AddExperiencedModel aPY() {
        return this.eGr;
    }

    public String aPZ() {
        return this.eGe;
    }

    public void oT(String str) {
        this.eGe = str;
    }

    public boolean aQa() {
        return this.eGj;
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.eFO != null && this.eFO.aNd() != null && this.eFO.aNd().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eFO.aNd().size();
                for (int i = 0; i < size; i++) {
                    if (this.eFO.aNd().get(i) != null && this.eFO.aNd().get(i).getAuthor() != null && currentAccount.equals(this.eFO.aNd().get(i).getAuthor().getUserId()) && this.eFO.aNd().get(i).getAuthor().getPendantData() != null) {
                        this.eFO.aNd().get(i).getAuthor().getPendantData().cA(iVar.pS());
                        this.eFO.aNd().get(i).getAuthor().getPendantData().P(iVar.Ca());
                    }
                }
            }
        }
    }

    public String aQb() {
        return this.eGq;
    }

    public int aQc() {
        return this.eGv;
    }

    public void oU(String str) {
        if ((!this.eFA || oS(TbadkCoreApplication.getCurrentAccount())) && this.eFO.aNd() != null) {
            this.eFO.qx().bM(1);
            if (this.eFO.qx().qt() == 0) {
                this.eFO.qx().bM(1);
            }
            this.eGw = str;
            po(8);
        }
    }

    private void ps(int i) {
        if (i != 8) {
            this.eGw = "";
            if (this.eGx != null) {
                if (i == 1 && !this.eFC && !com.baidu.tbadk.core.util.v.u(getPbData().aNd())) {
                    getPbData().aNd().remove(this.eGx);
                    if (this.eGy != null) {
                        getPbData().aNd().remove(this.eGy);
                    }
                    getPbData().aNd().add(0, this.eGx);
                } else {
                    getPbData().aNd().remove(this.eGx);
                    if (this.eGy != null) {
                        getPbData().aNd().remove(this.eGy);
                    }
                }
            }
            this.eGy = null;
        }
    }

    public void aQd() {
        if (this.eFO != null && !com.baidu.tbadk.core.util.v.u(this.eFO.aNd())) {
            if (this.eGy != null) {
                this.eFO.aNd().remove(this.eGy);
                this.eGy = null;
            }
            if (this.eGx != null) {
                this.eFO.aNd().remove(this.eGx);
                this.eGx = null;
            }
        }
    }

    public void bt(int i, int i2) {
        this.eGz = i;
        this.eGA = i2;
    }

    public PostData aQe() {
        return this.eGx;
    }

    public PostData aQf() {
        return this.eGy;
    }

    public int aQg() {
        return this.eGz;
    }
}
