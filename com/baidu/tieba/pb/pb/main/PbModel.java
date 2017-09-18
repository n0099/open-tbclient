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
import com.baidu.tbadk.core.data.bj;
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
    private int bQI;
    private BaseActivity bnc;
    private final CheckRealNameModel bpq;
    private long cDL;
    private com.baidu.tieba.tbadkCore.d.b cdy;
    private int dSH;
    private com.baidu.adp.framework.listener.a dSR;
    protected String eLV;
    private String eLW;
    private boolean eLX;
    private boolean eLY;
    private boolean eLZ;
    private boolean eMA;
    private boolean eMB;
    private String eMC;
    private long eMD;
    private boolean eME;
    private int eMF;
    private boolean eMG;
    private boolean eMH;
    private int eMI;
    private final u eMJ;
    private final t eMK;
    private final i eML;
    private final m eMM;
    private final PbFloorAgreeModel eMN;
    private final w eMO;
    private String eMP;
    private final AddExperiencedModel eMQ;
    private SuggestEmotionModel eMR;
    private boolean eMS;
    private int eMT;
    private CustomMessageListener eMU;
    private CustomMessageListener eMV;
    private PraiseData eMW;
    private boolean eMa;
    private boolean eMb;
    private long eMc;
    private int eMd;
    private int eMe;
    private int eMf;
    private boolean eMg;
    private boolean eMh;
    private boolean eMi;
    private long eMj;
    private boolean eMk;
    private String eMl;
    protected com.baidu.tieba.pb.data.f eMm;
    private int eMn;
    private boolean eMo;
    private boolean eMp;
    private boolean eMq;
    private boolean eMr;
    private a eMs;
    private String eMt;
    private String eMu;
    private int eMv;
    private int eMw;
    private boolean eMx;
    private boolean eMy;
    private boolean eMz;
    private boolean ehO;
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
    private static final int eLU = com.baidu.tbadk.data.c.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void d(com.baidu.tieba.pb.data.f fVar);
    }

    public void jl(boolean z) {
        this.eME = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eLV = null;
        this.eLW = null;
        this.mForumId = null;
        this.eLX = false;
        this.eLY = false;
        this.eLZ = true;
        this.eMa = true;
        this.eMb = false;
        this.mIsGood = 0;
        this.dSH = 0;
        this.eMc = 0L;
        this.eMd = 1;
        this.eMe = 1;
        this.eMf = 1;
        this.bQI = 1;
        this.isAd = false;
        this.eMg = false;
        this.eMh = false;
        this.ehO = false;
        this.isFromMark = false;
        this.eMi = false;
        this.eMj = 0L;
        this.eMk = false;
        this.eMl = null;
        this.eMm = null;
        this.isLoading = false;
        this.eMo = false;
        this.eMp = false;
        this.eMq = false;
        this.eMr = false;
        this.mLocate = null;
        this.mContext = null;
        this.eMs = null;
        this.opType = null;
        this.opUrl = null;
        this.eMt = null;
        this.eMu = null;
        this.eMv = -1;
        this.eMw = -1;
        this.cdy = null;
        this.eMy = false;
        this.eMz = false;
        this.postID = null;
        this.eMC = null;
        this.eMD = 0L;
        this.eME = false;
        this.eMF = -1;
        this.eMH = false;
        this.eMS = false;
        this.eMT = 0;
        this.eMU = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.eMB = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.l(pbData);
                    PbModel.this.f(pbData);
                    if (pbData.aPi() != null) {
                        pbData.aPi().bQ(0);
                    }
                    if (PbModel.this.eMs != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.eMs.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.eMV = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aPg() != null && PbModel.this.getPbData().aPg().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aPg().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.dSR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.i.hi()) {
                        PbModel.this.bnc.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.eMy || !PbModel.this.eMz) {
                        if (!PbModel.this.eMy) {
                            PbModel.this.eMy = true;
                        } else {
                            PbModel.this.eMz = true;
                        }
                        if (PbModel.this.eMs != null) {
                            PbModel.this.eMs.a(PbModel.this.aRA(), z, responsedMessage, PbModel.this.eMA, System.currentTimeMillis() - PbModel.this.cDL);
                        }
                    }
                }
            }
        };
        this.eMW = null;
        registerListener(this.eMU);
        registerListener(this.dSR);
        registerListener(this.eMV);
        this.eMm = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bnc = baseActivity;
        this.eMJ = new u(this, this.bnc);
        this.eMK = new t(this, this.bnc);
        this.eML = new i(this, this.bnc);
        this.eMM = new m(this, this.bnc);
        this.eMN = new PbFloorAgreeModel(this);
        this.eMO = new w(this, this.bnc);
        this.bpq = new CheckRealNameModel(this.bnc.getPageContext());
        this.eMR = new SuggestEmotionModel();
        this.eMQ = new AddExperiencedModel(this.bnc.getPageContext());
    }

    protected int aRA() {
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
        this.eLV = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eLV)) {
            this.eLV = this.eMJ.X(intent);
        }
        this.eMT = intent.getIntExtra(PbActivityConfig.KEY_START_FROM, 0);
        this.eLW = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eLX = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eLY = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eMa = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dSH = intent.getIntExtra("is_top", 0);
        this.eMc = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eMi = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eMg = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eMk = intent.getBooleanExtra("is_pv", false);
        this.eMj = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eMl = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eMu = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.eMt = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.eMo = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eMp = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eMq = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eMw = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eMv = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eMh = intent.getBooleanExtra("from_frs", false);
        this.ehO = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eMH = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eMr = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
        this.eMP = intent.getStringExtra(PbActivityConfig.KEY_POST_THREAD_TIP);
    }

    public void initWithBundle(Bundle bundle) {
        this.eMT = bundle.getInt(PbActivityConfig.KEY_START_FROM, 0);
        this.eLV = bundle.getString("thread_id");
        this.eLW = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eLX = bundle.getBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eLY = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eMa = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dSH = bundle.getInt("is_top", 0);
        this.eMc = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eMi = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eMg = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eMk = bundle.getBoolean("is_pv", false);
        this.eMj = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eMl = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eMu = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.eMo = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eMp = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eMq = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eMw = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eMv = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eMh = bundle.getBoolean("from_frs", false);
        this.ehO = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eMH = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eMr = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void t(Bundle bundle) {
        bundle.putString("thread_id", this.eLV);
        bundle.putString("post_id", this.eLW);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt(PbActivityConfig.KEY_START_FROM, this.eMT);
        bundle.putBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, this.eLX);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.eLY);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.eMa);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dSH);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.eMc);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.eMi);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.eMg);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eMk);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.eMj);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.eMu);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.eMo);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.eMp);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.eMq);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.eMw);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.eMv);
        bundle.putBoolean("from_frs", this.eMh);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.ehO);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.eMH);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.eMr);
    }

    public String aRB() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eLV);
        if (!this.eMi) {
            sb.append(this.eLW);
        }
        sb.append(this.eLY);
        sb.append(this.eMa);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.dSH);
        sb.append(this.eMc);
        sb.append(this.eMh);
        sb.append(this.ehO);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eMg);
        sb.append(this.eMk);
        sb.append(this.eMj);
        sb.append(this.eMl);
        sb.append(this.mThreadType);
        sb.append(this.eMo);
        sb.append(this.eMp);
        sb.append(this.eMq);
        if (this.eMu != null) {
            sb.append(this.eMu);
        }
        return sb.toString();
    }

    public String aRC() {
        return this.eMl;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eLW;
    }

    public void pn(String str) {
        this.eLW = str;
    }

    public String getThreadID() {
        return this.eLV;
    }

    public boolean getHostMode() {
        return this.eLY;
    }

    public boolean aRD() {
        return this.eMa;
    }

    public boolean aRE() {
        return this.eMh;
    }

    public boolean aRF() {
        return this.eMb;
    }

    public boolean aRG() {
        return this.ehO;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aRH() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aDD() {
        return this.dSH;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void hT(int i) {
        this.dSH = i;
    }

    public boolean aRI() {
        return this.eMg;
    }

    public boolean aRJ() {
        if (this.eMm == null) {
            return false;
        }
        return this.eMm.isValid();
    }

    public String rK() {
        if (this.eMm == null || !this.eMm.nG()) {
            return null;
        }
        return this.eMm.nF();
    }

    public boolean pr(int i) {
        this.eMd = i;
        if (this.eMd > this.eMm.qD().qu()) {
            this.eMd = this.eMm.qD().qu();
        }
        if (this.eMd < 1) {
            this.eMd = 1;
        }
        if (this.eLV == null) {
            return false;
        }
        return pv(5);
    }

    public boolean ps(int i) {
        int sp = this.eMm.aPi().sp();
        if (i <= sp) {
            sp = i;
        }
        int i2 = sp >= 1 ? sp : 1;
        if (this.eLV == null) {
            return false;
        }
        this.eMF = i2;
        return pv(7);
    }

    public void pt(int i) {
        this.eMd = i;
        this.eMe = i;
        this.eMf = i;
    }

    public void pu(int i) {
        if (this.eMe < i) {
            this.eMe = i;
            if (this.eMe - this.eMf >= eLU) {
                this.eMf = (this.eMe - eLU) + 1;
            }
        }
        if (this.eMf > i) {
            this.eMf = i;
            if (this.eMe - this.eMf >= eLU) {
                this.eMe = (this.eMf + eLU) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eMm;
    }

    public com.baidu.tbadk.core.data.ar asJ() {
        if (this.eMm == null) {
            return null;
        }
        return this.eMm.qD();
    }

    public boolean aRK() {
        if (this.eMa && this.eMm.qD().qz() == 0) {
            jm(true);
            return true;
        }
        return false;
    }

    public void pg(String str) {
        if (!StringUtils.isNull(str)) {
            this.eLV = str;
            this.eLW = null;
            this.eLY = false;
            this.eMa = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eLV == null) {
            return false;
        }
        cancelLoadData();
        if (this.cdy == null) {
            this.cdy = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.cdy.start();
        }
        boolean pv = pv(3);
        if (this.opType != null) {
            this.opType = null;
            this.eMt = null;
            this.opUrl = null;
            return pv;
        }
        return pv;
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
        if (this.eMR != null) {
            this.eMR.cancelLoadData();
        }
        if (this.eMN != null) {
            this.eMN.cancelLoadData();
        }
        adw();
    }

    private void adw() {
        if (this.cdy != null) {
            this.cdy.destory();
            this.cdy = null;
        }
    }

    public boolean Fu() {
        return (this.eLW == null || this.eLW.equals("0") || this.eLW.length() == 0) ? LoadData() : aRN();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        if (forumData != null && !TextUtils.isEmpty(forumData.getId()) && !TextUtils.isEmpty(forumData.getName())) {
            this.eMR.a(forumData.getId(), forumData.getName(), aVar);
        }
    }

    public boolean pv(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        pw(i);
        final com.baidu.tieba.pb.data.f pbData = af.aSE().getPbData();
        if (pbData != null && pbData.aPi() != null) {
            pbData.aPi().bQ(0);
            this.eMa = af.aSE().aRD();
            this.eLY = af.aSE().aSG();
            this.eMb = af.aSE().aSH();
            this.eMS = this.eLY;
            if (this.eLY || this.isFromMark) {
                this.eMx = false;
            }
            com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.eMB) {
            a(aRS(), true, this.eLW, 3);
        }
        if (i == 3 && !this.eMB) {
            if (this.isFromMark) {
                a(aRS(), true, this.eLW, 3);
            } else {
                a(aRS(), false, this.eLW, 3);
            }
        }
        this.eMB = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aAp);
        if (this.eLY || this.isFromMark) {
            this.eMx = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eLV == null || this.eLV.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eLV, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ae = com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst().getApp());
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.an.vO().vQ() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ae));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.eMa) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eLY) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eMk) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eMj));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eMx) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eMt, 0));
            pbPageRequestMessage.setOpMessageID(this.eMj);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aPk = this.eMm.aPk();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eMa) {
                        if (this.eMf - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eMf - 1));
                        }
                    } else if (this.eMe < this.bQI) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eMe + 1));
                    }
                }
                if (aPk != null && aPk.size() > 0) {
                    int size = aPk.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aPk.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.eLW = postData.getId();
                            if (StringUtils.isNull(this.eLW)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.eLW != null && this.eLW.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eLW, 0L));
                } else if (!this.eMa) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aPk != null && aPk.size() > 0 && aPk.get(0) != null) {
                    this.eLW = aPk.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eMa) {
                        if (this.eMf - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eMf - 1));
                        }
                    } else if (this.eMe < this.bQI) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eMe + 1));
                    }
                }
                if (this.eLW != null && this.eLW.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eLW, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eMa) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eLW, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eMd));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eMa && this.eMS && !this.eLY) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eLW, 0L));
                }
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eMF);
                b(pbPageRequestMessage);
                break;
        }
        this.eMS = this.eLY;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aRS());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bnc != null && (this.bnc instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bnc).aQk());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.eME);
        pbPageRequestMessage.setFromSmartFrs(this.eMH ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eLX);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aRC()) && com.baidu.tieba.recapp.r.bho().bhi() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bho().bhi().X(aRC(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bho().bhi().Y(aRC(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aRC()) && com.baidu.tieba.recapp.r.bho().bhi() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bho().bhi().Y(aRC(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bho().bhi().X(aRC(), true));
        }
    }

    protected void pw(int i) {
        boolean z = false;
        ArrayList<PostData> aPk = this.eMm.aPk();
        this.eMA = false;
        if (i == 1) {
            boolean z2 = false;
            while (aPk.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                aPk.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eMm.qD().bM(1);
                if (this.eMs != null) {
                    this.eMs.d(this.eMm);
                }
            }
            this.cDL = System.currentTimeMillis();
            this.eMA = true;
        } else if (i == 2) {
            while (aPk.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                aPk.remove(aPk.size() - 1);
                z = true;
            }
            if (z) {
                this.eMm.qD().bL(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.eMI = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            f(fVar2);
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

    protected void f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            if (this.eMq || this.eMo || this.eMp) {
                fVar = h(fVar);
            }
            g(fVar);
        }
    }

    protected void g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String i = i(fVar);
            for (int i2 = 0; i2 < fVar.aPk().size(); i2++) {
                PostData postData = fVar.aPk().get(i2);
                for (int i3 = 0; i3 < postData.bsw().size(); i3++) {
                    postData.bsw().get(i3).b(this.bnc.getPageContext(), i.equals(postData.bsw().get(i3).getAuthor().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n aPs = fVar.aPs();
            if (aPs != null && !com.baidu.tbadk.core.util.v.v(aPs.eFY)) {
                for (PostData postData2 : aPs.eFY) {
                    for (int i4 = 0; i4 < postData2.bsw().size(); i4++) {
                        postData2.bsw().get(i4).b(this.bnc.getPageContext(), i.equals(postData2.bsw().get(i4).getAuthor().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String i2 = i(fVar);
            com.baidu.tieba.pb.data.n aPs = fVar.aPs();
            if (aPs != null && !com.baidu.tbadk.core.util.v.v(aPs.eFY)) {
                for (PostData postData : aPs.eFY.subList(i, aPs.eFY.size())) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < postData.bsw().size()) {
                            postData.bsw().get(i4).b(this.bnc.getPageContext(), i2.equals(postData.bsw().get(i4).getAuthor().getUserId()));
                            i3 = i4 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.f h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null) {
            return null;
        }
        bj aPi = fVar.aPi();
        aPi.bU(this.mIsGood);
        aPi.bT(this.dSH);
        if (this.eMc > 0) {
            aPi.m(this.eMc);
            return fVar;
        }
        return fVar;
    }

    protected String i(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aPi() != null && fVar.aPi().getAuthor() != null) {
            str = fVar.aPi().getAuthor().getUserId();
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
        if (fVar.aPi() != null && fVar.aPi().getAuthor() != null) {
            str = fVar.aPi().getAuthor().getUserName();
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
        if (fVar.aPi() != null && fVar.aPi().getAuthor() != null) {
            str = fVar.aPi().getAuthor().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aRL() {
        if (this.eMm == null || this.eMm.aPi() == null || this.eMm.aPi().getAuthor() == null) {
            return null;
        }
        return this.eMm.aPi().getAuthor();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.eMG = z3;
        this.eMn = i;
        if (this.cdy != null && !z3) {
            this.cdy.a(z2, z4, i2, str, i3, j, j2);
            this.cdy = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aRC()) && com.baidu.tieba.recapp.r.bho().bhi() != null) {
            com.baidu.tieba.recapp.r.bho().bhi().g(aRC(), px(aRU()), true);
        }
        if (fVar == null || (this.eMd == 1 && i == 5 && fVar.aPk() != null && fVar.aPk().size() < 1)) {
            if (this.eMs != null) {
                this.eMa = this.eLZ;
                this.eMs.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eLZ = this.eMa;
            this.eMk = false;
            if (fVar.qD() != null) {
                pu(fVar.qD().qx());
                this.bQI = fVar.qD().qu();
            }
            this.bQI = this.bQI < 1 ? 1 : this.bQI;
            int i5 = 0;
            ArrayList<PostData> aPk = this.eMm.aPk();
            switch (i) {
                case 1:
                    this.eMm.a(fVar.qD(), 1);
                    f(fVar, aPk);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aPk() != null) {
                        int size = fVar.aPk().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aPk, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aPk(), com.baidu.tbadk.core.util.v.u(fVar.aPk()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aPk().remove(postData2);
                            i5 = size - 1;
                        }
                        aPk.addAll(0, fVar.aPk());
                    }
                    this.eMm.a(fVar.qD(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.eMa && fVar.qD() != null) {
                        fVar.qD().bJ(fVar.qD().qu());
                    }
                    l(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eMa) {
                        aRM();
                        i4 = 0;
                        break;
                    }
                    i4 = 0;
                    break;
                case 4:
                    l(fVar);
                    i4 = 0;
                    break;
                case 5:
                    l(fVar);
                    i4 = 0;
                    break;
                case 6:
                    l(fVar);
                    i4 = 0;
                    break;
                case 7:
                    l(fVar);
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.eMm != null && this.eMm.aPi() != null) {
                PraiseData rr = this.eMm.aPi().rr();
                if (this.eMW != null && !rr.isPriaseDataValid()) {
                    this.eMm.aPi().a(this.eMW);
                } else {
                    this.eMW = this.eMm.aPi().rr();
                    this.eMW.setPostId(this.eMm.aPi().rR());
                }
                if (fVar.qD() != null && fVar.qD().qx() == 1 && fVar.aPi() != null && fVar.aPi().rM() != null && fVar.aPi().rM().size() > 0) {
                    this.eMm.aPi().h(fVar.aPi().rM());
                }
                this.eMm.aPi().bR(fVar.aPi().rt());
                this.eMm.aPi().bO(fVar.aPi().getAnchorLevel());
                this.eMm.aPi().bQ(fVar.aPi().ro());
                if (this.mThreadType == 33) {
                    this.eMm.aPi().getAuthor().setHadConcerned(fVar.aPi().getAuthor().hadConcerned());
                }
            }
            if (this.eMm != null && this.eMm.getUserData() != null && fVar.getUserData() != null) {
                this.eMm.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eMm.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qD() != null && fVar.qD().qx() == 1 && fVar.aPr() != null) {
                this.eMm.e(fVar.aPr());
            }
            if (this.eMG && this.eMm.aPi() != null && this.eMm.aPi().getAuthor() != null && this.eMm.aPk() != null && com.baidu.tbadk.core.util.v.c(this.eMm.aPk(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.eMm.aPk(), 0);
                MetaData author = this.eMm.aPi().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.eMv != -1) {
                        author.setFansNum(this.eMv);
                        postData3.getAuthor().setFansNum(this.eMv);
                    }
                    if (this.eMw != -1) {
                        author.getGodUserData().setIsLike(this.eMw == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.eMw == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eMm != null && this.eMm.aPe() != null && fVar.aPe() != null) {
                this.eMm.aPe().o(fVar.aPe().getItems());
                this.eMm.aPe().an(fVar.aPe().qd());
            }
            if (this.eMs != null) {
                this.eMs.a(true, getErrorCode(), i, i4, this.eMm, this.mErrorString, 1);
            }
        }
        if (this.eMm != null && this.eMm.aPi() != null && this.eMm.aPg() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bnc;
            historyMessage.threadId = getPbData().aPi().getId();
            historyMessage.forumName = getPbData().aPg().getName();
            historyMessage.threadName = getPbData().aPi().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aRD();
            historyMessage.threadType = getPbData().aPi().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void f(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ak;
        if (arrayList != null && fVar.aPk() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aPk(), 0);
            if (postData != null && (ak = ak(arrayList)) != null && ak.equals(postData.getId())) {
                fVar.aPk().remove(postData);
            }
            arrayList.addAll(fVar.aPk());
        }
    }

    private int px(int i) {
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

    private String ak(ArrayList<PostData> arrayList) {
        int u = com.baidu.tbadk.core.util.v.u(arrayList);
        if (u <= 0) {
            return null;
        }
        for (int i = u - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(com.baidu.tieba.pb.data.f fVar) {
        fVar.pe(this.eMm.aPz());
        this.eMm = fVar;
        pt(fVar.qD().qx());
    }

    private void aRM() {
        if (this.eMm != null && this.eMm.aPk() != null && this.eMm.aPx() != null) {
            ArrayList<PostData> aPk = this.eMm.aPk();
            com.baidu.tieba.pb.data.a aPx = this.eMm.aPx();
            int aOX = aPx.aOX();
            if (aOX > 0) {
                if (aOX <= aPk.size()) {
                    aPk.add(aOX, aPx);
                } else {
                    aPk.add(aPx);
                }
            }
        }
    }

    public boolean aRN() {
        if (this.eLV == null || this.eLW == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return pv(4);
        }
        return pv(6);
    }

    public boolean jm(boolean z) {
        if (this.eLV == null || this.eMm == null) {
            return false;
        }
        if (z || this.eMm.qD().qz() != 0) {
            return pv(1);
        }
        return false;
    }

    public boolean jn(boolean z) {
        if (this.eLV == null || this.eMm == null) {
            return false;
        }
        if ((z || this.eMm.qD().qA() != 0) && this.eMm.aPk() != null && this.eMm.aPk().size() >= 1) {
            return pv(2);
        }
        return false;
    }

    public boolean po(String str) {
        this.eLY = !this.eLY;
        this.eLW = str;
        if (pv(6)) {
            return true;
        }
        this.eLY = this.eLY ? false : true;
        return false;
    }

    public boolean j(boolean z, String str) {
        if (this.eLY == z) {
            return false;
        }
        this.eLY = z;
        this.eLW = str;
        if (pv(6)) {
            return true;
        }
        this.eLY = z ? false : true;
        return false;
    }

    public boolean aRO() {
        this.eLZ = this.eMa;
        this.eMa = !this.eMa;
        if (this.isLoading || !LoadData()) {
            this.eMa = this.eMa ? false : true;
            return false;
        }
        return true;
    }

    public boolean aRP() {
        return this.eMa;
    }

    public boolean hasData() {
        return (this.eMm == null || this.eMm.aPg() == null || this.eMm.aPi() == null) ? false : true;
    }

    public boolean nG() {
        if (this.eMm == null) {
            return false;
        }
        return this.eMm.nG();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fQ(String str) {
        if (this.eMm == null || this.eMm.aPi() == null || this.eMm.aPg() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eMm.aPi().sN()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eMm.aPg().getId());
            writeData.setForumName(this.eMm.aPg().getName());
        }
        writeData.setThreadId(this.eLV);
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

    public MarkData py(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.eMm == null) {
            return null;
        }
        ArrayList<PostData> aPk = this.eMm.aPk();
        if (com.baidu.tbadk.core.util.v.v(aPk)) {
            return null;
        }
        if (aPk.size() > 0 && i >= aPk.size()) {
            i = aPk.size() - 1;
        }
        return j(aPk.get(i));
    }

    public MarkData aRQ() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eLV);
        markData.setPostId(this.eMm.nF());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eLY);
        markData.setSequence(Boolean.valueOf(this.eMa));
        markData.setId(this.eLV);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eLV);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eLY);
        markData.setSequence(Boolean.valueOf(this.eMa));
        markData.setId(this.eLV);
        markData.setFloor(postData.bsz());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aRR() {
        h.aRq().R(aRS(), this.isFromMark);
    }

    private String aRS() {
        String str = this.eLV;
        if (this.eLY) {
            str = str + DB_KEY_HOST;
        }
        if (!this.eMa) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jo(boolean z) {
        if (this.eMm != null) {
            this.eMm.ac(z);
        }
    }

    public void jp(boolean z) {
        this.eMx = z;
    }

    public boolean aRT() {
        return this.eMx;
    }

    public void a(a aVar) {
        this.eMs = aVar;
    }

    public void oM(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dq() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dp() {
        return Fu();
    }

    public boolean pp(String str) {
        if (getPbData() == null || getPbData().aPi() == null || getPbData().aPi().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aPi().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aRU() {
        return this.mRequestType;
    }

    public void aRV() {
        String aRS = aRS();
        h.aRq().R(aRS, false);
        h.aRq().R(aRS, true);
    }

    public void aRW() {
        if ("personalize_page".equals(this.mStType)) {
            this.eMD = System.currentTimeMillis() / 1000;
        }
    }

    public void aRX() {
        if ("personalize_page".equals(this.mStType) && this.eMm != null && this.eMD != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ad("fid", this.eMm.getForumId()).ad("tid", this.eLV).ad("obj_duration", String.valueOf(currentTimeMillis - this.eMD)).ad("obj_param3", String.valueOf(currentTimeMillis)));
            this.eMD = 0L;
        }
    }

    public boolean aRY() {
        return this.eMG;
    }

    public int getErrorNo() {
        return this.eMI;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public t aRZ() {
        return this.eMK;
    }

    public i aSa() {
        return this.eML;
    }

    public m aSb() {
        return this.eMM;
    }

    public PbFloorAgreeModel aSc() {
        return this.eMN;
    }

    public w aSd() {
        return this.eMO;
    }

    public CheckRealNameModel aSe() {
        return this.bpq;
    }

    public AddExperiencedModel aSf() {
        return this.eMQ;
    }

    public String aSg() {
        return this.eMC;
    }

    public void pq(String str) {
        this.eMC = str;
    }

    public boolean aSh() {
        return this.eMH;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.eMm != null && this.eMm.aPk() != null && this.eMm.aPk().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eMm.aPk().size();
                for (int i = 0; i < size; i++) {
                    if (this.eMm.aPk().get(i) != null && this.eMm.aPk().get(i).getAuthor() != null && currentAccount.equals(this.eMm.aPk().get(i).getAuthor().getUserId()) && this.eMm.aPk().get(i).getAuthor().getPendantData() != null) {
                        this.eMm.aPk().get(i).getAuthor().getPendantData().cA(jVar.pR());
                        this.eMm.aPk().get(i).getAuthor().getPendantData().P(jVar.Cw());
                    }
                }
            }
        }
    }

    public String aSi() {
        return this.eMP;
    }

    public int aSj() {
        return this.eMT;
    }
}
