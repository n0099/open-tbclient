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
    private int bPR;
    private BaseActivity bnd;
    private final CheckRealNameModel bpd;
    private long cCT;
    private com.baidu.tieba.tbadkCore.d.b ccG;
    private int dRN;
    private com.baidu.adp.framework.listener.a dRX;
    private String eLA;
    private int eLB;
    private int eLC;
    private boolean eLD;
    private boolean eLE;
    private boolean eLF;
    private boolean eLG;
    private boolean eLH;
    private String eLI;
    private long eLJ;
    private boolean eLK;
    private int eLL;
    private boolean eLM;
    private boolean eLN;
    private int eLO;
    private final u eLP;
    private final t eLQ;
    private final i eLR;
    private final m eLS;
    private final PbFloorAgreeModel eLT;
    private final w eLU;
    private String eLV;
    private final AddExperiencedModel eLW;
    private SuggestEmotionModel eLX;
    private boolean eLY;
    private int eLZ;
    protected String eLb;
    private String eLc;
    private boolean eLd;
    private boolean eLe;
    private boolean eLf;
    private boolean eLg;
    private boolean eLh;
    private long eLi;
    private int eLj;
    private int eLk;
    private int eLl;
    private boolean eLm;
    private boolean eLn;
    private boolean eLo;
    private long eLp;
    private boolean eLq;
    private String eLr;
    protected com.baidu.tieba.pb.data.f eLs;
    private int eLt;
    private boolean eLu;
    private boolean eLv;
    private boolean eLw;
    private boolean eLx;
    private a eLy;
    private String eLz;
    private CustomMessageListener eMa;
    private CustomMessageListener eMb;
    private PraiseData eMc;
    private boolean egU;
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
    private static final int eLa = com.baidu.tbadk.data.c.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void d(com.baidu.tieba.pb.data.f fVar);
    }

    public void jk(boolean z) {
        this.eLK = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eLb = null;
        this.eLc = null;
        this.mForumId = null;
        this.eLd = false;
        this.eLe = false;
        this.eLf = true;
        this.eLg = true;
        this.eLh = false;
        this.mIsGood = 0;
        this.dRN = 0;
        this.eLi = 0L;
        this.eLj = 1;
        this.eLk = 1;
        this.eLl = 1;
        this.bPR = 1;
        this.isAd = false;
        this.eLm = false;
        this.eLn = false;
        this.egU = false;
        this.isFromMark = false;
        this.eLo = false;
        this.eLp = 0L;
        this.eLq = false;
        this.eLr = null;
        this.eLs = null;
        this.isLoading = false;
        this.eLu = false;
        this.eLv = false;
        this.eLw = false;
        this.eLx = false;
        this.mLocate = null;
        this.mContext = null;
        this.eLy = null;
        this.opType = null;
        this.opUrl = null;
        this.eLz = null;
        this.eLA = null;
        this.eLB = -1;
        this.eLC = -1;
        this.ccG = null;
        this.eLE = false;
        this.eLF = false;
        this.postID = null;
        this.eLI = null;
        this.eLJ = 0L;
        this.eLK = false;
        this.eLL = -1;
        this.eLN = false;
        this.eLY = false;
        this.eLZ = 0;
        this.eMa = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.eLH = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.l(pbData);
                    PbModel.this.f(pbData);
                    if (pbData.aOX() != null) {
                        pbData.aOX().bQ(0);
                    }
                    if (PbModel.this.eLy != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.eLy.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.eMb = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aOV() != null && PbModel.this.getPbData().aOV().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aOV().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.dRX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.i.hi()) {
                        PbModel.this.bnd.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.eLE || !PbModel.this.eLF) {
                        if (!PbModel.this.eLE) {
                            PbModel.this.eLE = true;
                        } else {
                            PbModel.this.eLF = true;
                        }
                        if (PbModel.this.eLy != null) {
                            PbModel.this.eLy.a(PbModel.this.aRp(), z, responsedMessage, PbModel.this.eLG, System.currentTimeMillis() - PbModel.this.cCT);
                        }
                    }
                }
            }
        };
        this.eMc = null;
        registerListener(this.eMa);
        registerListener(this.dRX);
        registerListener(this.eMb);
        this.eLs = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bnd = baseActivity;
        this.eLP = new u(this, this.bnd);
        this.eLQ = new t(this, this.bnd);
        this.eLR = new i(this, this.bnd);
        this.eLS = new m(this, this.bnd);
        this.eLT = new PbFloorAgreeModel(this);
        this.eLU = new w(this, this.bnd);
        this.bpd = new CheckRealNameModel(this.bnd.getPageContext());
        this.eLX = new SuggestEmotionModel();
        this.eLW = new AddExperiencedModel(this.bnd.getPageContext());
    }

    protected int aRp() {
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
        this.eLb = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eLb)) {
            this.eLb = this.eLP.Y(intent);
        }
        this.eLZ = intent.getIntExtra(PbActivityConfig.KEY_START_FROM, 0);
        this.eLc = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eLd = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eLe = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eLg = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dRN = intent.getIntExtra("is_top", 0);
        this.eLi = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eLo = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eLm = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eLq = intent.getBooleanExtra("is_pv", false);
        this.eLp = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eLr = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eLA = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.eLz = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.eLu = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eLv = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eLw = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eLC = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eLB = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eLn = intent.getBooleanExtra("from_frs", false);
        this.egU = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eLN = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eLx = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
        this.eLV = intent.getStringExtra(PbActivityConfig.KEY_POST_THREAD_TIP);
    }

    public void initWithBundle(Bundle bundle) {
        this.eLZ = bundle.getInt(PbActivityConfig.KEY_START_FROM, 0);
        this.eLb = bundle.getString("thread_id");
        this.eLc = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eLd = bundle.getBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eLe = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eLg = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dRN = bundle.getInt("is_top", 0);
        this.eLi = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eLo = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eLm = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eLq = bundle.getBoolean("is_pv", false);
        this.eLp = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eLr = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eLA = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.eLu = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eLv = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eLw = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eLC = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eLB = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eLn = bundle.getBoolean("from_frs", false);
        this.egU = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eLN = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eLx = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void t(Bundle bundle) {
        bundle.putString("thread_id", this.eLb);
        bundle.putString("post_id", this.eLc);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt(PbActivityConfig.KEY_START_FROM, this.eLZ);
        bundle.putBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, this.eLd);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.eLe);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.eLg);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dRN);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.eLi);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.eLo);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.eLm);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eLq);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.eLp);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.eLA);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.eLu);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.eLv);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.eLw);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.eLC);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.eLB);
        bundle.putBoolean("from_frs", this.eLn);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.egU);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.eLN);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.eLx);
    }

    public String aRq() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eLb);
        if (!this.eLo) {
            sb.append(this.eLc);
        }
        sb.append(this.eLe);
        sb.append(this.eLg);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.dRN);
        sb.append(this.eLi);
        sb.append(this.eLn);
        sb.append(this.egU);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eLm);
        sb.append(this.eLq);
        sb.append(this.eLp);
        sb.append(this.eLr);
        sb.append(this.mThreadType);
        sb.append(this.eLu);
        sb.append(this.eLv);
        sb.append(this.eLw);
        if (this.eLA != null) {
            sb.append(this.eLA);
        }
        return sb.toString();
    }

    public String aRr() {
        return this.eLr;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eLc;
    }

    public void pl(String str) {
        this.eLc = str;
    }

    public String getThreadID() {
        return this.eLb;
    }

    public boolean getHostMode() {
        return this.eLe;
    }

    public boolean aRs() {
        return this.eLg;
    }

    public boolean aRt() {
        return this.eLn;
    }

    public boolean aRu() {
        return this.eLh;
    }

    public boolean aRv() {
        return this.egU;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aRw() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aDs() {
        return this.dRN;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void hR(int i) {
        this.dRN = i;
    }

    public boolean aRx() {
        return this.eLm;
    }

    public boolean aRy() {
        if (this.eLs == null) {
            return false;
        }
        return this.eLs.isValid();
    }

    public String rK() {
        if (this.eLs == null || !this.eLs.nG()) {
            return null;
        }
        return this.eLs.nF();
    }

    public boolean pp(int i) {
        this.eLj = i;
        if (this.eLj > this.eLs.qD().qu()) {
            this.eLj = this.eLs.qD().qu();
        }
        if (this.eLj < 1) {
            this.eLj = 1;
        }
        if (this.eLb == null) {
            return false;
        }
        return pt(5);
    }

    public boolean pq(int i) {
        int sp = this.eLs.aOX().sp();
        if (i <= sp) {
            sp = i;
        }
        int i2 = sp >= 1 ? sp : 1;
        if (this.eLb == null) {
            return false;
        }
        this.eLL = i2;
        return pt(7);
    }

    public void pr(int i) {
        this.eLj = i;
        this.eLk = i;
        this.eLl = i;
    }

    public void ps(int i) {
        if (this.eLk < i) {
            this.eLk = i;
            if (this.eLk - this.eLl >= eLa) {
                this.eLl = (this.eLk - eLa) + 1;
            }
        }
        if (this.eLl > i) {
            this.eLl = i;
            if (this.eLk - this.eLl >= eLa) {
                this.eLk = (this.eLl + eLa) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eLs;
    }

    public com.baidu.tbadk.core.data.ar asy() {
        if (this.eLs == null) {
            return null;
        }
        return this.eLs.qD();
    }

    public boolean aRz() {
        if (this.eLg && this.eLs.qD().qz() == 0) {
            jl(true);
            return true;
        }
        return false;
    }

    public void pe(String str) {
        if (!StringUtils.isNull(str)) {
            this.eLb = str;
            this.eLc = null;
            this.eLe = false;
            this.eLg = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eLb == null) {
            return false;
        }
        cancelLoadData();
        if (this.ccG == null) {
            this.ccG = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.ccG.start();
        }
        boolean pt = pt(3);
        if (this.opType != null) {
            this.opType = null;
            this.eLz = null;
            this.opUrl = null;
            return pt;
        }
        return pt;
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
        if (this.eLX != null) {
            this.eLX.cancelLoadData();
        }
        if (this.eLT != null) {
            this.eLT.cancelLoadData();
        }
        adl();
    }

    private void adl() {
        if (this.ccG != null) {
            this.ccG.destory();
            this.ccG = null;
        }
    }

    public boolean Fu() {
        return (this.eLc == null || this.eLc.equals("0") || this.eLc.length() == 0) ? LoadData() : aRC();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        if (forumData != null && !TextUtils.isEmpty(forumData.getId()) && !TextUtils.isEmpty(forumData.getName())) {
            this.eLX.a(forumData.getId(), forumData.getName(), aVar);
        }
    }

    public boolean pt(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        pu(i);
        final com.baidu.tieba.pb.data.f pbData = af.aSt().getPbData();
        if (pbData != null && pbData.aOX() != null) {
            pbData.aOX().bQ(0);
            this.eLg = af.aSt().aRs();
            this.eLe = af.aSt().aSv();
            this.eLh = af.aSt().aSw();
            this.eLY = this.eLe;
            if (this.eLe || this.isFromMark) {
                this.eLD = false;
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
        if (i == 4 && !this.eLH) {
            a(aRH(), true, this.eLc, 3);
        }
        if (i == 3 && !this.eLH) {
            if (this.isFromMark) {
                a(aRH(), true, this.eLc, 3);
            } else {
                a(aRH(), false, this.eLc, 3);
            }
        }
        this.eLH = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aAs);
        if (this.eLe || this.isFromMark) {
            this.eLD = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eLb == null || this.eLb.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eLb, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ad = com.baidu.adp.lib.util.k.ad(TbadkCoreApplication.getInst().getApp());
        int ae = com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.an.vO().vQ() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ad));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ae));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.eLg) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eLe) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eLq) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eLp));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eLD) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eLz, 0));
            pbPageRequestMessage.setOpMessageID(this.eLp);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aOZ = this.eLs.aOZ();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eLg) {
                        if (this.eLl - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eLl - 1));
                        }
                    } else if (this.eLk < this.bPR) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eLk + 1));
                    }
                }
                if (aOZ != null && aOZ.size() > 0) {
                    int size = aOZ.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aOZ.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.eLc = postData.getId();
                            if (StringUtils.isNull(this.eLc)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.eLc != null && this.eLc.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eLc, 0L));
                } else if (!this.eLg) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aOZ != null && aOZ.size() > 0 && aOZ.get(0) != null) {
                    this.eLc = aOZ.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eLg) {
                        if (this.eLl - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eLl - 1));
                        }
                    } else if (this.eLk < this.bPR) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eLk + 1));
                    }
                }
                if (this.eLc != null && this.eLc.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eLc, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eLg) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eLc, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eLj));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eLg && this.eLY && !this.eLe) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eLc, 0L));
                }
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eLL);
                b(pbPageRequestMessage);
                break;
        }
        this.eLY = this.eLe;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aRH());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bnd != null && (this.bnd instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bnd).aPZ());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.eLK);
        pbPageRequestMessage.setFromSmartFrs(this.eLN ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eLd);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aRr()) && com.baidu.tieba.recapp.r.bhd().bgX() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bhd().bgX().X(aRr(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bhd().bgX().Y(aRr(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aRr()) && com.baidu.tieba.recapp.r.bhd().bgX() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bhd().bgX().Y(aRr(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bhd().bgX().X(aRr(), true));
        }
    }

    protected void pu(int i) {
        boolean z = false;
        ArrayList<PostData> aOZ = this.eLs.aOZ();
        this.eLG = false;
        if (i == 1) {
            boolean z2 = false;
            while (aOZ.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                aOZ.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eLs.qD().bM(1);
                if (this.eLy != null) {
                    this.eLy.d(this.eLs);
                }
            }
            this.cCT = System.currentTimeMillis();
            this.eLG = true;
        } else if (i == 2) {
            while (aOZ.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                aOZ.remove(aOZ.size() - 1);
                z = true;
            }
            if (z) {
                this.eLs.qD().bL(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.eLO = i2;
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
            if (this.eLw || this.eLu || this.eLv) {
                fVar = h(fVar);
            }
            g(fVar);
        }
    }

    protected void g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String i = i(fVar);
            for (int i2 = 0; i2 < fVar.aOZ().size(); i2++) {
                PostData postData = fVar.aOZ().get(i2);
                for (int i3 = 0; i3 < postData.bsl().size(); i3++) {
                    postData.bsl().get(i3).b(this.bnd.getPageContext(), i.equals(postData.bsl().get(i3).getAuthor().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n aPh = fVar.aPh();
            if (aPh != null && !com.baidu.tbadk.core.util.v.v(aPh.eFe)) {
                for (PostData postData2 : aPh.eFe) {
                    for (int i4 = 0; i4 < postData2.bsl().size(); i4++) {
                        postData2.bsl().get(i4).b(this.bnd.getPageContext(), i.equals(postData2.bsl().get(i4).getAuthor().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String i2 = i(fVar);
            com.baidu.tieba.pb.data.n aPh = fVar.aPh();
            if (aPh != null && !com.baidu.tbadk.core.util.v.v(aPh.eFe)) {
                for (PostData postData : aPh.eFe.subList(i, aPh.eFe.size())) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < postData.bsl().size()) {
                            postData.bsl().get(i4).b(this.bnd.getPageContext(), i2.equals(postData.bsl().get(i4).getAuthor().getUserId()));
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
        bj aOX = fVar.aOX();
        aOX.bU(this.mIsGood);
        aOX.bT(this.dRN);
        if (this.eLi > 0) {
            aOX.m(this.eLi);
            return fVar;
        }
        return fVar;
    }

    protected String i(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aOX() != null && fVar.aOX().getAuthor() != null) {
            str = fVar.aOX().getAuthor().getUserId();
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
        if (fVar.aOX() != null && fVar.aOX().getAuthor() != null) {
            str = fVar.aOX().getAuthor().getUserName();
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
        if (fVar.aOX() != null && fVar.aOX().getAuthor() != null) {
            str = fVar.aOX().getAuthor().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aRA() {
        if (this.eLs == null || this.eLs.aOX() == null || this.eLs.aOX().getAuthor() == null) {
            return null;
        }
        return this.eLs.aOX().getAuthor();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.eLM = z3;
        this.eLt = i;
        if (this.ccG != null && !z3) {
            this.ccG.a(z2, z4, i2, str, i3, j, j2);
            this.ccG = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aRr()) && com.baidu.tieba.recapp.r.bhd().bgX() != null) {
            com.baidu.tieba.recapp.r.bhd().bgX().g(aRr(), pv(aRJ()), true);
        }
        if (fVar == null || (this.eLj == 1 && i == 5 && fVar.aOZ() != null && fVar.aOZ().size() < 1)) {
            if (this.eLy != null) {
                this.eLg = this.eLf;
                this.eLy.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eLf = this.eLg;
            this.eLq = false;
            if (fVar.qD() != null) {
                ps(fVar.qD().qx());
                this.bPR = fVar.qD().qu();
            }
            this.bPR = this.bPR < 1 ? 1 : this.bPR;
            int i5 = 0;
            ArrayList<PostData> aOZ = this.eLs.aOZ();
            switch (i) {
                case 1:
                    this.eLs.a(fVar.qD(), 1);
                    f(fVar, aOZ);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aOZ() != null) {
                        int size = fVar.aOZ().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aOZ, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aOZ(), com.baidu.tbadk.core.util.v.u(fVar.aOZ()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aOZ().remove(postData2);
                            i5 = size - 1;
                        }
                        aOZ.addAll(0, fVar.aOZ());
                    }
                    this.eLs.a(fVar.qD(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.eLg && fVar.qD() != null) {
                        fVar.qD().bJ(fVar.qD().qu());
                    }
                    l(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eLg) {
                        aRB();
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
            if (this.eLs != null && this.eLs.aOX() != null) {
                PraiseData rr = this.eLs.aOX().rr();
                if (this.eMc != null && !rr.isPriaseDataValid()) {
                    this.eLs.aOX().a(this.eMc);
                } else {
                    this.eMc = this.eLs.aOX().rr();
                    this.eMc.setPostId(this.eLs.aOX().rR());
                }
                if (fVar.qD() != null && fVar.qD().qx() == 1 && fVar.aOX() != null && fVar.aOX().rM() != null && fVar.aOX().rM().size() > 0) {
                    this.eLs.aOX().h(fVar.aOX().rM());
                }
                this.eLs.aOX().bR(fVar.aOX().rt());
                this.eLs.aOX().bO(fVar.aOX().getAnchorLevel());
                this.eLs.aOX().bQ(fVar.aOX().ro());
                if (this.mThreadType == 33) {
                    this.eLs.aOX().getAuthor().setHadConcerned(fVar.aOX().getAuthor().hadConcerned());
                }
            }
            if (this.eLs != null && this.eLs.getUserData() != null && fVar.getUserData() != null) {
                this.eLs.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eLs.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qD() != null && fVar.qD().qx() == 1 && fVar.aPg() != null) {
                this.eLs.e(fVar.aPg());
            }
            if (this.eLM && this.eLs.aOX() != null && this.eLs.aOX().getAuthor() != null && this.eLs.aOZ() != null && com.baidu.tbadk.core.util.v.c(this.eLs.aOZ(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.eLs.aOZ(), 0);
                MetaData author = this.eLs.aOX().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.eLB != -1) {
                        author.setFansNum(this.eLB);
                        postData3.getAuthor().setFansNum(this.eLB);
                    }
                    if (this.eLC != -1) {
                        author.getGodUserData().setIsLike(this.eLC == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.eLC == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eLs != null && this.eLs.aOT() != null && fVar.aOT() != null) {
                this.eLs.aOT().o(fVar.aOT().getItems());
                this.eLs.aOT().an(fVar.aOT().qd());
            }
            if (this.eLy != null) {
                this.eLy.a(true, getErrorCode(), i, i4, this.eLs, this.mErrorString, 1);
            }
        }
        if (this.eLs != null && this.eLs.aOX() != null && this.eLs.aOV() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bnd;
            historyMessage.threadId = getPbData().aOX().getId();
            historyMessage.forumName = getPbData().aOV().getName();
            historyMessage.threadName = getPbData().aOX().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aRs();
            historyMessage.threadType = getPbData().aOX().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void f(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ak;
        if (arrayList != null && fVar.aOZ() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aOZ(), 0);
            if (postData != null && (ak = ak(arrayList)) != null && ak.equals(postData.getId())) {
                fVar.aOZ().remove(postData);
            }
            arrayList.addAll(fVar.aOZ());
        }
    }

    private int pv(int i) {
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
        fVar.pc(this.eLs.aPo());
        this.eLs = fVar;
        pr(fVar.qD().qx());
    }

    private void aRB() {
        if (this.eLs != null && this.eLs.aOZ() != null && this.eLs.aPm() != null) {
            ArrayList<PostData> aOZ = this.eLs.aOZ();
            com.baidu.tieba.pb.data.a aPm = this.eLs.aPm();
            int aOM = aPm.aOM();
            if (aOM > 0) {
                if (aOM <= aOZ.size()) {
                    aOZ.add(aOM, aPm);
                } else {
                    aOZ.add(aPm);
                }
            }
        }
    }

    public boolean aRC() {
        if (this.eLb == null || this.eLc == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return pt(4);
        }
        return pt(6);
    }

    public boolean jl(boolean z) {
        if (this.eLb == null || this.eLs == null) {
            return false;
        }
        if (z || this.eLs.qD().qz() != 0) {
            return pt(1);
        }
        return false;
    }

    public boolean jm(boolean z) {
        if (this.eLb == null || this.eLs == null) {
            return false;
        }
        if ((z || this.eLs.qD().qA() != 0) && this.eLs.aOZ() != null && this.eLs.aOZ().size() >= 1) {
            return pt(2);
        }
        return false;
    }

    public boolean pm(String str) {
        this.eLe = !this.eLe;
        this.eLc = str;
        if (pt(6)) {
            return true;
        }
        this.eLe = this.eLe ? false : true;
        return false;
    }

    public boolean j(boolean z, String str) {
        if (this.eLe == z) {
            return false;
        }
        this.eLe = z;
        this.eLc = str;
        if (pt(6)) {
            return true;
        }
        this.eLe = z ? false : true;
        return false;
    }

    public boolean aRD() {
        this.eLf = this.eLg;
        this.eLg = !this.eLg;
        if (this.isLoading || !LoadData()) {
            this.eLg = this.eLg ? false : true;
            return false;
        }
        return true;
    }

    public boolean aRE() {
        return this.eLg;
    }

    public boolean hasData() {
        return (this.eLs == null || this.eLs.aOV() == null || this.eLs.aOX() == null) ? false : true;
    }

    public boolean nG() {
        if (this.eLs == null) {
            return false;
        }
        return this.eLs.nG();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fQ(String str) {
        if (this.eLs == null || this.eLs.aOX() == null || this.eLs.aOV() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eLs.aOX().sN()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eLs.aOV().getId());
            writeData.setForumName(this.eLs.aOV().getName());
        }
        writeData.setThreadId(this.eLb);
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

    public MarkData pw(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.eLs == null) {
            return null;
        }
        ArrayList<PostData> aOZ = this.eLs.aOZ();
        if (com.baidu.tbadk.core.util.v.v(aOZ)) {
            return null;
        }
        if (aOZ.size() > 0 && i >= aOZ.size()) {
            i = aOZ.size() - 1;
        }
        return j(aOZ.get(i));
    }

    public MarkData aRF() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eLb);
        markData.setPostId(this.eLs.nF());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eLe);
        markData.setSequence(Boolean.valueOf(this.eLg));
        markData.setId(this.eLb);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eLb);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eLe);
        markData.setSequence(Boolean.valueOf(this.eLg));
        markData.setId(this.eLb);
        markData.setFloor(postData.bso());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aRG() {
        h.aRf().R(aRH(), this.isFromMark);
    }

    private String aRH() {
        String str = this.eLb;
        if (this.eLe) {
            str = str + DB_KEY_HOST;
        }
        if (!this.eLg) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jn(boolean z) {
        if (this.eLs != null) {
            this.eLs.ac(z);
        }
    }

    public void jo(boolean z) {
        this.eLD = z;
    }

    public boolean aRI() {
        return this.eLD;
    }

    public void a(a aVar) {
        this.eLy = aVar;
    }

    public void oK(String str) {
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

    public boolean pn(String str) {
        if (getPbData() == null || getPbData().aOX() == null || getPbData().aOX().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aOX().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aRJ() {
        return this.mRequestType;
    }

    public void aRK() {
        String aRH = aRH();
        h.aRf().R(aRH, false);
        h.aRf().R(aRH, true);
    }

    public void aRL() {
        if ("personalize_page".equals(this.mStType)) {
            this.eLJ = System.currentTimeMillis() / 1000;
        }
    }

    public void aRM() {
        if ("personalize_page".equals(this.mStType) && this.eLs != null && this.eLJ != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ad("fid", this.eLs.getForumId()).ad("tid", this.eLb).ad("obj_duration", String.valueOf(currentTimeMillis - this.eLJ)).ad("obj_param3", String.valueOf(currentTimeMillis)));
            this.eLJ = 0L;
        }
    }

    public boolean aRN() {
        return this.eLM;
    }

    public int getErrorNo() {
        return this.eLO;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public t aRO() {
        return this.eLQ;
    }

    public i aRP() {
        return this.eLR;
    }

    public m aRQ() {
        return this.eLS;
    }

    public PbFloorAgreeModel aRR() {
        return this.eLT;
    }

    public w aRS() {
        return this.eLU;
    }

    public CheckRealNameModel aRT() {
        return this.bpd;
    }

    public AddExperiencedModel aRU() {
        return this.eLW;
    }

    public String aRV() {
        return this.eLI;
    }

    public void po(String str) {
        this.eLI = str;
    }

    public boolean aRW() {
        return this.eLN;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.eLs != null && this.eLs.aOZ() != null && this.eLs.aOZ().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eLs.aOZ().size();
                for (int i = 0; i < size; i++) {
                    if (this.eLs.aOZ().get(i) != null && this.eLs.aOZ().get(i).getAuthor() != null && currentAccount.equals(this.eLs.aOZ().get(i).getAuthor().getUserId()) && this.eLs.aOZ().get(i).getAuthor().getPendantData() != null) {
                        this.eLs.aOZ().get(i).getAuthor().getPendantData().cA(jVar.pR());
                        this.eLs.aOZ().get(i).getAuthor().getPendantData().P(jVar.Cw());
                    }
                }
            }
        }
    }

    public String aRX() {
        return this.eLV;
    }

    public int aRY() {
        return this.eLZ;
    }
}
