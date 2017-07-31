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
    private int bMo;
    private com.baidu.tieba.tbadkCore.d.b bYX;
    private BaseActivity bmv;
    private final CheckRealNameModel bnX;
    private long cuu;
    private int dJm;
    private com.baidu.adp.framework.listener.a dJw;
    private boolean dYp;
    protected String eKN;
    private String eKO;
    private boolean eKP;
    private boolean eKQ;
    private boolean eKR;
    private boolean eKS;
    private long eKT;
    private int eKU;
    private int eKV;
    private int eKW;
    private boolean eKX;
    private boolean eKY;
    private boolean eKZ;
    private final u eLA;
    private final t eLB;
    private final i eLC;
    private final m eLD;
    private final PbFloorAgreeModel eLE;
    private final w eLF;
    private String eLG;
    private final AddExperiencedModel eLH;
    private SuggestEmotionModel eLI;
    private boolean eLJ;
    private int eLK;
    private CustomMessageListener eLL;
    private CustomMessageListener eLM;
    private PraiseData eLN;
    private long eLa;
    private boolean eLb;
    private String eLc;
    protected com.baidu.tieba.pb.data.f eLd;
    private int eLe;
    private boolean eLf;
    private boolean eLg;
    private boolean eLh;
    private boolean eLi;
    private a eLj;
    private String eLk;
    private String eLl;
    private int eLm;
    private int eLn;
    private boolean eLo;
    private boolean eLp;
    private boolean eLq;
    private boolean eLr;
    private boolean eLs;
    private String eLt;
    private long eLu;
    private boolean eLv;
    private int eLw;
    private boolean eLx;
    private boolean eLy;
    private int eLz;
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
    private static final int eKM = com.baidu.tbadk.data.c.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.f fVar);
    }

    public void jg(boolean z) {
        this.eLv = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eKN = null;
        this.eKO = null;
        this.mForumId = null;
        this.eKP = false;
        this.eKQ = false;
        this.eKR = true;
        this.eKS = true;
        this.mIsGood = 0;
        this.dJm = 0;
        this.eKT = 0L;
        this.eKU = 1;
        this.eKV = 1;
        this.eKW = 1;
        this.bMo = 1;
        this.isAd = false;
        this.eKX = false;
        this.eKY = false;
        this.dYp = false;
        this.isFromMark = false;
        this.eKZ = false;
        this.eLa = 0L;
        this.eLb = false;
        this.eLc = null;
        this.eLd = null;
        this.isLoading = false;
        this.eLf = false;
        this.eLg = false;
        this.eLh = false;
        this.eLi = false;
        this.mLocate = null;
        this.mContext = null;
        this.eLj = null;
        this.opType = null;
        this.opUrl = null;
        this.eLk = null;
        this.eLl = null;
        this.eLm = -1;
        this.eLn = -1;
        this.bYX = null;
        this.eLp = false;
        this.eLq = false;
        this.postID = null;
        this.eLt = null;
        this.eLu = 0L;
        this.eLv = false;
        this.eLw = -1;
        this.eLy = false;
        this.eLJ = false;
        this.eLK = 0;
        this.eLL = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.eLs = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.k(pbData);
                    PbModel.this.e(pbData);
                    if (pbData.aPj() != null) {
                        pbData.aPj().bQ(0);
                    }
                    if (PbModel.this.eLj != null && pbData != null) {
                        com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.eLj.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.eLM = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aPh() != null && PbModel.this.getPbData().aPh().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aPh().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.dJw = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.i.hr()) {
                        PbModel.this.bmv.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.eLp || !PbModel.this.eLq) {
                        if (!PbModel.this.eLp) {
                            PbModel.this.eLp = true;
                        } else {
                            PbModel.this.eLq = true;
                        }
                        if (PbModel.this.eLj != null) {
                            PbModel.this.eLj.a(PbModel.this.aRv(), z, responsedMessage, PbModel.this.eLr, System.currentTimeMillis() - PbModel.this.cuu);
                        }
                    }
                }
            }
        };
        this.eLN = null;
        registerListener(this.eLL);
        registerListener(this.dJw);
        registerListener(this.eLM);
        this.eLd = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bmv = baseActivity;
        this.eLA = new u(this, this.bmv);
        this.eLB = new t(this, this.bmv);
        this.eLC = new i(this, this.bmv);
        this.eLD = new m(this, this.bmv);
        this.eLE = new PbFloorAgreeModel(this);
        this.eLF = new w(this, this.bmv);
        this.bnX = new CheckRealNameModel(this.bmv.getPageContext());
        this.eLI = new SuggestEmotionModel();
        this.eLH = new AddExperiencedModel(this.bmv.getPageContext());
    }

    protected int aRv() {
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
        this.eKN = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eKN)) {
            this.eKN = this.eLA.W(intent);
        }
        this.eLK = intent.getIntExtra(PbActivityConfig.KEY_START_FROM, 0);
        this.eKO = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eKP = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eKQ = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eKS = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dJm = intent.getIntExtra("is_top", 0);
        this.eKT = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eKZ = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eKX = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eLb = intent.getBooleanExtra("is_pv", false);
        this.eLa = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eLc = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eLl = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.eLk = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.eLf = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eLg = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eLh = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eLn = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eLm = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eKY = intent.getBooleanExtra("from_frs", false);
        this.dYp = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eLy = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eLi = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
        this.eLG = intent.getStringExtra(PbActivityConfig.KEY_POST_THREAD_TIP);
    }

    public void initWithBundle(Bundle bundle) {
        this.eLK = bundle.getInt(PbActivityConfig.KEY_START_FROM, 0);
        this.eKN = bundle.getString("thread_id");
        this.eKO = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eKP = bundle.getBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eKQ = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eKS = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dJm = bundle.getInt("is_top", 0);
        this.eKT = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eKZ = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eKX = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eLb = bundle.getBoolean("is_pv", false);
        this.eLa = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eLc = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eLl = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.eLf = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eLg = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eLh = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eLn = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eLm = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eKY = bundle.getBoolean("from_frs", false);
        this.dYp = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eLy = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eLi = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void r(Bundle bundle) {
        bundle.putString("thread_id", this.eKN);
        bundle.putString("post_id", this.eKO);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt(PbActivityConfig.KEY_START_FROM, this.eLK);
        bundle.putBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, this.eKP);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.eKQ);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.eKS);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dJm);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.eKT);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.eKZ);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.eKX);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eLb);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.eLa);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.eLl);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.eLf);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.eLg);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.eLh);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.eLn);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.eLm);
        bundle.putBoolean("from_frs", this.eKY);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.dYp);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.eLy);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.eLi);
    }

    public String aRw() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eKN);
        if (!this.eKZ) {
            sb.append(this.eKO);
        }
        sb.append(this.eKQ);
        sb.append(this.eKS);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.dJm);
        sb.append(this.eKT);
        sb.append(this.eKY);
        sb.append(this.dYp);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eKX);
        sb.append(this.eLb);
        sb.append(this.eLa);
        sb.append(this.eLc);
        sb.append(this.mThreadType);
        sb.append(this.eLf);
        sb.append(this.eLg);
        sb.append(this.eLh);
        if (this.eLl != null) {
            sb.append(this.eLl);
        }
        return sb.toString();
    }

    public String aRx() {
        return this.eLc;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eKO;
    }

    public void pq(String str) {
        this.eKO = str;
    }

    public String getThreadID() {
        return this.eKN;
    }

    public boolean getHostMode() {
        return this.eKQ;
    }

    public boolean aRy() {
        return this.eKS;
    }

    public boolean aRz() {
        return this.eKY;
    }

    public boolean aRA() {
        return this.dYp;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aRB() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aBb() {
        return this.dJm;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void hF(int i) {
        this.dJm = i;
    }

    public boolean aRC() {
        return this.eKX;
    }

    public boolean aRD() {
        if (this.eLd == null) {
            return false;
        }
        return this.eLd.isValid();
    }

    public String rO() {
        if (this.eLd == null || !this.eLd.nL()) {
            return null;
        }
        return this.eLd.nK();
    }

    public boolean oY(int i) {
        this.eKU = i;
        if (this.eKU > this.eLd.qH().qy()) {
            this.eKU = this.eLd.qH().qy();
        }
        if (this.eKU < 1) {
            this.eKU = 1;
        }
        if (this.eKN == null) {
            return false;
        }
        return pc(5);
    }

    public boolean oZ(int i) {
        int st = this.eLd.aPj().st();
        if (i <= st) {
            st = i;
        }
        int i2 = st >= 1 ? st : 1;
        if (this.eKN == null) {
            return false;
        }
        this.eLw = i2;
        return pc(7);
    }

    public void pa(int i) {
        this.eKU = i;
        this.eKV = i;
        this.eKW = i;
    }

    public void pb(int i) {
        if (this.eKV < i) {
            this.eKV = i;
            if (this.eKV - this.eKW >= eKM) {
                this.eKW = (this.eKV - eKM) + 1;
            }
        }
        if (this.eKW > i) {
            this.eKW = i;
            if (this.eKV - this.eKW >= eKM) {
                this.eKV = (this.eKW + eKM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eLd;
    }

    public com.baidu.tbadk.core.data.ar aqn() {
        if (this.eLd == null) {
            return null;
        }
        return this.eLd.qH();
    }

    public boolean aRE() {
        if (this.eKS && this.eLd.qH().qD() == 0) {
            jh(true);
            return true;
        }
        return false;
    }

    public void pj(String str) {
        if (!StringUtils.isNull(str)) {
            this.eKN = str;
            this.eKO = null;
            this.eKQ = false;
            this.eKS = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eKN == null) {
            return false;
        }
        cancelLoadData();
        if (this.bYX == null) {
            this.bYX = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bYX.start();
        }
        boolean pc = pc(3);
        if (this.opType != null) {
            this.opType = null;
            this.eLk = null;
            this.opUrl = null;
            return pc;
        }
        return pc;
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
        if (this.eLI != null) {
            this.eLI.cancelLoadData();
        }
        if (this.eLE != null) {
            this.eLE.cancelLoadData();
        }
        abU();
    }

    private void abU() {
        if (this.bYX != null) {
            this.bYX.destory();
            this.bYX = null;
        }
    }

    public boolean Fw() {
        return (this.eKO == null || this.eKO.equals("0") || this.eKO.length() == 0) ? LoadData() : aRH();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        if (forumData != null && !TextUtils.isEmpty(forumData.getId()) && !TextUtils.isEmpty(forumData.getName())) {
            this.eLI.a(forumData.getId(), forumData.getName(), aVar);
        }
    }

    public boolean pc(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        pd(i);
        final com.baidu.tieba.pb.data.f pbData = ai.aSJ().getPbData();
        if (pbData != null && pbData.aPj() != null) {
            pbData.aPj().bQ(0);
            this.eKS = ai.aSJ().aRy();
            this.eKQ = ai.aSJ().aSL();
            this.eLJ = this.eKQ;
            if (this.eKQ || this.isFromMark) {
                this.eLo = false;
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
        if (i == 4 && !this.eLs) {
            a(aRM(), true, this.eKO, 3);
        }
        if (i == 3 && !this.eLs) {
            if (this.isFromMark) {
                a(aRM(), true, this.eKO, 3);
            } else {
                a(aRM(), false, this.eKO, 3);
            }
        }
        this.eLs = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aBe);
        if (this.eKQ || this.isFromMark) {
            this.eLo = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eKN == null || this.eKN.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.eKN, 0L));
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
        if (!this.eKS) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eKQ) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eLb) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eLa));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eLo) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eLk, 0));
            pbPageRequestMessage.setOpMessageID(this.eLa);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aPl = this.eLd.aPl();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eKS) {
                        if (this.eKW - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eKW - 1));
                        }
                    } else if (this.eKV < this.bMo) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eKV + 1));
                    }
                }
                if (aPl != null && aPl.size() > 0) {
                    int size = aPl.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aPl.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.eKO = postData.getId();
                            if (StringUtils.isNull(this.eKO)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.eKO != null && this.eKO.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.eKO, 0L));
                } else if (!this.eKS) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aPl != null && aPl.size() > 0 && aPl.get(0) != null) {
                    this.eKO = aPl.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eKS) {
                        if (this.eKW - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eKW - 1));
                        }
                    } else if (this.eKV < this.bMo) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eKV + 1));
                    }
                }
                if (this.eKO != null && this.eKO.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.eKO, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eKS) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.eKO, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eKU));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eKS && this.eLJ && !this.eKQ) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.eKO, 0L));
                }
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eLw);
                b(pbPageRequestMessage);
                break;
        }
        this.eLJ = this.eKQ;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aRM());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bmv != null && (this.bmv instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bmv).aQk());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.eLv);
        pbPageRequestMessage.setFromSmartFrs(this.eLy ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eKP);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aRx()) && com.baidu.tieba.recapp.r.bhF().bhB() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bhF().bhB().V(aRx(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bhF().bhB().W(aRx(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aRx()) && com.baidu.tieba.recapp.r.bhF().bhB() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bhF().bhB().W(aRx(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bhF().bhB().V(aRx(), true));
        }
    }

    protected void pd(int i) {
        boolean z = false;
        ArrayList<PostData> aPl = this.eLd.aPl();
        this.eLr = false;
        if (i == 1) {
            boolean z2 = false;
            while (aPl.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                aPl.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eLd.qH().bM(1);
                if (this.eLj != null) {
                    this.eLj.c(this.eLd);
                }
            }
            this.cuu = System.currentTimeMillis();
            this.eLr = true;
        } else if (i == 2) {
            while (aPl.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                aPl.remove(aPl.size() - 1);
                z = true;
            }
            if (z) {
                this.eLd.qH().bL(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.eLz = i2;
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
            if (this.eLh || this.eLf || this.eLg) {
                fVar = g(fVar);
            }
            f(fVar);
        }
    }

    protected void f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String h = h(fVar);
            for (int i = 0; i < fVar.aPl().size(); i++) {
                PostData postData = fVar.aPl().get(i);
                for (int i2 = 0; i2 < postData.bsv().size(); i2++) {
                    postData.bsv().get(i2).a(this.bmv.getPageContext(), h.equals(postData.bsv().get(i2).getAuthor().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.o aPt = fVar.aPt();
            if (aPt != null && !com.baidu.tbadk.core.util.u.v(aPt.eEO)) {
                for (PostData postData2 : aPt.eEO) {
                    for (int i3 = 0; i3 < postData2.bsv().size(); i3++) {
                        postData2.bsv().get(i3).a(this.bmv.getPageContext(), h.equals(postData2.bsv().get(i3).getAuthor().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String h = h(fVar);
            com.baidu.tieba.pb.data.o aPt = fVar.aPt();
            if (aPt != null && !com.baidu.tbadk.core.util.u.v(aPt.eEO)) {
                for (PostData postData : aPt.eEO.subList(i, aPt.eEO.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bsv().size()) {
                            postData.bsv().get(i3).a(this.bmv.getPageContext(), h.equals(postData.bsv().get(i3).getAuthor().getUserId()));
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
        bl aPj = fVar.aPj();
        aPj.bU(this.mIsGood);
        aPj.bT(this.dJm);
        if (this.eKT > 0) {
            aPj.m(this.eKT);
            return fVar;
        }
        return fVar;
    }

    protected String h(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aPj() != null && fVar.aPj().getAuthor() != null) {
            str = fVar.aPj().getAuthor().getUserId();
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
        if (fVar.aPj() != null && fVar.aPj().getAuthor() != null) {
            str = fVar.aPj().getAuthor().getUserName();
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
        if (fVar.aPj() != null && fVar.aPj().getAuthor() != null) {
            str = fVar.aPj().getAuthor().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aRF() {
        if (this.eLd == null || this.eLd.aPj() == null || this.eLd.aPj().getAuthor() == null) {
            return null;
        }
        return this.eLd.aPj().getAuthor();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.eLx = z3;
        this.eLe = i;
        if (this.bYX != null && !z3) {
            this.bYX.a(z2, z4, i2, str, i3, j, j2);
            this.bYX = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aRx()) && com.baidu.tieba.recapp.r.bhF().bhB() != null) {
            com.baidu.tieba.recapp.r.bhF().bhB().g(aRx(), pe(aRO()), true);
        }
        if (fVar == null || (this.eKU == 1 && i == 5 && fVar.aPl() != null && fVar.aPl().size() < 1)) {
            if (this.eLj != null) {
                this.eKS = this.eKR;
                this.eLj.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eKR = this.eKS;
            this.eLb = false;
            if (fVar.qH() != null) {
                pb(fVar.qH().qB());
                this.bMo = fVar.qH().qy();
            }
            this.bMo = this.bMo < 1 ? 1 : this.bMo;
            int i5 = 0;
            ArrayList<PostData> aPl = this.eLd.aPl();
            switch (i) {
                case 1:
                    this.eLd.a(fVar.qH(), 1);
                    d(fVar, aPl);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aPl() != null) {
                        int size = fVar.aPl().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(aPl, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPl(), com.baidu.tbadk.core.util.u.u(fVar.aPl()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aPl().remove(postData2);
                            i5 = size - 1;
                        }
                        aPl.addAll(0, fVar.aPl());
                    }
                    this.eLd.a(fVar.qH(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.eKS && fVar.qH() != null) {
                        fVar.qH().bJ(fVar.qH().qy());
                    }
                    k(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eKS) {
                        aRG();
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
            if (this.eLd != null && this.eLd.aPj() != null) {
                PraiseData rv = this.eLd.aPj().rv();
                if (this.eLN != null && !rv.isPriaseDataValid()) {
                    this.eLd.aPj().a(this.eLN);
                } else {
                    this.eLN = this.eLd.aPj().rv();
                    this.eLN.setPostId(this.eLd.aPj().rV());
                }
                if (fVar.qH() != null && fVar.qH().qB() == 1 && fVar.aPj() != null && fVar.aPj().rQ() != null && fVar.aPj().rQ().size() > 0) {
                    this.eLd.aPj().h(fVar.aPj().rQ());
                }
                this.eLd.aPj().bR(fVar.aPj().rx());
                this.eLd.aPj().bP(fVar.aPj().getAnchorLevel());
                this.eLd.aPj().bQ(fVar.aPj().rs());
                if (this.mThreadType == 33) {
                    this.eLd.aPj().getAuthor().setHadConcerned(fVar.aPj().getAuthor().hadConcerned());
                }
            }
            if (this.eLd != null && this.eLd.getUserData() != null && fVar.getUserData() != null) {
                this.eLd.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eLd.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qH() != null && fVar.qH().qB() == 1 && fVar.aPs() != null) {
                this.eLd.e(fVar.aPs());
            }
            if (this.eLx && this.eLd.aPj() != null && this.eLd.aPj().getAuthor() != null && this.eLd.aPl() != null && com.baidu.tbadk.core.util.u.c(this.eLd.aPl(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.u.c(this.eLd.aPl(), 0);
                MetaData author = this.eLd.aPj().getAuthor();
                if (postData3.getAuthor() != null && postData3.getAuthor().getGodUserData() != null) {
                    if (this.eLm != -1) {
                        author.setFansNum(this.eLm);
                        postData3.getAuthor().setFansNum(this.eLm);
                    }
                    if (this.eLn != -1) {
                        author.getGodUserData().setIsLike(this.eLn == 1);
                        postData3.getAuthor().getGodUserData().setIsLike(this.eLn == 1);
                        author.getGodUserData().setIsFromNetWork(false);
                        postData3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eLd != null && this.eLd.aPf() != null && fVar.aPf() != null) {
                this.eLd.aPf().o(fVar.aPf().getItems());
                this.eLd.aPf().an(fVar.aPf().qh());
            }
            if (this.eLj != null) {
                this.eLj.a(true, getErrorCode(), i, i4, this.eLd, this.mErrorString, 1);
            }
        }
        if (this.eLd != null && this.eLd.aPj() != null && this.eLd.aPh() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bmv;
            historyMessage.threadId = getPbData().aPj().getId();
            historyMessage.forumName = getPbData().aPh().getName();
            historyMessage.threadName = getPbData().aPj().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aRy();
            historyMessage.threadType = getPbData().aPj().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String al;
        if (arrayList != null && fVar.aPl() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPl(), 0);
            if (postData != null && (al = al(arrayList)) != null && al.equals(postData.getId())) {
                fVar.aPl().remove(postData);
            }
            arrayList.addAll(fVar.aPl());
        }
    }

    private int pe(int i) {
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
        fVar.ph(this.eLd.aPA());
        this.eLd = fVar;
        pa(fVar.qH().qB());
    }

    private void aRG() {
        if (this.eLd != null && this.eLd.aPl() != null && this.eLd.aPy() != null) {
            ArrayList<PostData> aPl = this.eLd.aPl();
            com.baidu.tieba.pb.data.a aPy = this.eLd.aPy();
            int aOY = aPy.aOY();
            if (aOY > 0) {
                if (aOY <= aPl.size()) {
                    aPl.add(aOY, aPy);
                } else {
                    aPl.add(aPy);
                }
            }
        }
    }

    public boolean aRH() {
        if (this.eKN == null || this.eKO == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return pc(4);
        }
        return pc(6);
    }

    public boolean jh(boolean z) {
        if (this.eKN == null || this.eLd == null) {
            return false;
        }
        if (z || this.eLd.qH().qD() != 0) {
            return pc(1);
        }
        return false;
    }

    public boolean ji(boolean z) {
        if (this.eKN == null || this.eLd == null) {
            return false;
        }
        if ((z || this.eLd.qH().qE() != 0) && this.eLd.aPl() != null && this.eLd.aPl().size() >= 1) {
            return pc(2);
        }
        return false;
    }

    public boolean pr(String str) {
        this.eKQ = !this.eKQ;
        this.eKO = str;
        pc(6);
        return true;
    }

    public boolean i(boolean z, String str) {
        if (this.eKQ == z) {
            return false;
        }
        this.eKQ = z;
        this.eKO = str;
        pc(6);
        return true;
    }

    public boolean aRI() {
        if (com.baidu.adp.lib.util.i.hr()) {
            this.eKR = this.eKS;
            this.eKS = !this.eKS;
        }
        return LoadData();
    }

    public boolean jj(boolean z) {
        if (this.eKS == z) {
            return false;
        }
        if (com.baidu.adp.lib.util.i.hr()) {
            this.eKR = z;
            this.eKS = z;
        }
        return LoadData();
    }

    public boolean aRJ() {
        return this.eKS;
    }

    public boolean hasData() {
        return (this.eLd == null || this.eLd.aPh() == null || this.eLd.aPj() == null) ? false : true;
    }

    public boolean nL() {
        if (this.eLd == null) {
            return false;
        }
        return this.eLd.nL();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fS(String str) {
        if (this.eLd == null || this.eLd.aPj() == null || this.eLd.aPh() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eLd.aPj().sR()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eLd.aPh().getId());
            writeData.setForumName(this.eLd.aPh().getName());
        }
        writeData.setThreadId(this.eKN);
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

    public MarkData pf(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.eLd == null) {
            return null;
        }
        ArrayList<PostData> aPl = this.eLd.aPl();
        if (com.baidu.tbadk.core.util.u.v(aPl)) {
            return null;
        }
        if (aPl.size() > 0 && i >= aPl.size()) {
            i = aPl.size() - 1;
        }
        return j(aPl.get(i));
    }

    public MarkData aRK() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eKN);
        markData.setPostId(this.eLd.nK());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eKQ);
        markData.setSequence(Boolean.valueOf(this.eKS));
        markData.setId(this.eKN);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eKN);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eKQ);
        markData.setSequence(Boolean.valueOf(this.eKS));
        markData.setId(this.eKN);
        markData.setFloor(postData.bsy());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aRL() {
        h.aRm().P(aRM(), this.isFromMark);
    }

    private String aRM() {
        String str = this.eKN;
        if (this.eKQ) {
            str = str + DB_KEY_HOST;
        }
        if (!this.eKS) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jk(boolean z) {
        if (this.eLd != null) {
            this.eLd.ac(z);
        }
    }

    public void jl(boolean z) {
        this.eLo = z;
    }

    public boolean aRN() {
        return this.eLo;
    }

    public void a(a aVar) {
        this.eLj = aVar;
    }

    public void oi(String str) {
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

    public boolean ps(String str) {
        if (getPbData() == null || getPbData().aPj() == null || getPbData().aPj().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aPj().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aRO() {
        return this.mRequestType;
    }

    public void aRP() {
        String aRM = aRM();
        h.aRm().P(aRM, false);
        h.aRm().P(aRM, true);
    }

    public void aRQ() {
        if ("personalize_page".equals(this.mStType)) {
            this.eLu = System.currentTimeMillis() / 1000;
        }
    }

    public void aRR() {
        if ("personalize_page".equals(this.mStType) && this.eLd != null && this.eLu != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10754").aa("fid", this.eLd.getForumId()).aa("tid", this.eKN).aa("obj_duration", String.valueOf(currentTimeMillis - this.eLu)).aa("obj_param3", String.valueOf(currentTimeMillis)));
            this.eLu = 0L;
        }
    }

    public boolean aRS() {
        return this.eLx;
    }

    public int aRT() {
        return this.eLe;
    }

    public int getErrorNo() {
        return this.eLz;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public t aRU() {
        return this.eLB;
    }

    public i aRV() {
        return this.eLC;
    }

    public m aRW() {
        return this.eLD;
    }

    public PbFloorAgreeModel aRX() {
        return this.eLE;
    }

    public w aRY() {
        return this.eLF;
    }

    public CheckRealNameModel aRZ() {
        return this.bnX;
    }

    public AddExperiencedModel aSa() {
        return this.eLH;
    }

    public String aSb() {
        return this.eLt;
    }

    public void pt(String str) {
        this.eLt = str;
    }

    public boolean aSc() {
        return this.eLy;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.eLd != null && this.eLd.aPl() != null && this.eLd.aPl().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eLd.aPl().size();
                for (int i = 0; i < size; i++) {
                    if (this.eLd.aPl().get(i) != null && this.eLd.aPl().get(i).getAuthor() != null && currentAccount.equals(this.eLd.aPl().get(i).getAuthor().getUserId()) && this.eLd.aPl().get(i).getAuthor().getPendantData() != null) {
                        this.eLd.aPl().get(i).getAuthor().getPendantData().cH(jVar.pV());
                        this.eLd.aPl().get(i).getAuthor().getPendantData().Q(jVar.CB());
                    }
                }
            }
        }
    }

    public String aSd() {
        return this.eLG;
    }

    public int aSe() {
        return this.eLK;
    }
}
