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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bd;
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
/* loaded from: classes2.dex */
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
    private int cZQ;
    private BaseActivity cmR;
    private final CheckRealNameModel cwi;
    private long dPc;
    private com.baidu.tieba.tbadkCore.d.b dmS;
    private boolean fMA;
    private boolean fMB;
    private boolean fMC;
    private long fMD;
    private boolean fME;
    private String fMF;
    protected com.baidu.tieba.pb.data.f fMG;
    private int fMH;
    private boolean fMI;
    private boolean fMJ;
    private boolean fMK;
    private boolean fML;
    private a fMM;
    private String fMN;
    private String fMO;
    private int fMP;
    private int fMQ;
    private boolean fMR;
    private boolean fMS;
    private boolean fMT;
    private boolean fMU;
    private boolean fMV;
    private String fMW;
    private long fMX;
    private boolean fMY;
    private int fMZ;
    protected String fMn;
    private String fMo;
    private String fMp;
    private boolean fMq;
    private boolean fMr;
    private boolean fMs;
    private boolean fMt;
    private boolean fMu;
    private int fMv;
    private long fMw;
    private int fMx;
    private int fMy;
    private int fMz;
    private boolean fNa;
    private boolean fNb;
    private int fNc;
    private final x fNd;
    private final j fNe;
    private final o fNf;
    private final PbFloorAgreeModel fNg;
    private final z fNh;
    private String fNi;
    private final AddExperiencedModel fNj;
    private SuggestEmotionModel fNk;
    private GetSugMatchWordsModel fNl;
    private boolean fNm;
    private int fNn;
    private String fNo;
    private PostData fNp;
    private PostData fNq;
    private int fNr;
    private int fNs;
    private String fNt;
    private CustomMessageListener fNu;
    private CustomMessageListener fNv;
    private com.baidu.adp.framework.listener.a fNw;
    private PraiseData fNx;
    private boolean ffV;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private com.baidu.tieba.pb.data.e mAppealInfo;
    protected Context mContext;
    private String mForumId;
    private int mIsGood;
    private boolean mIsShareThread;
    private String mLocate;
    private int mRequestType;
    public String mStType;
    protected int mThreadType;
    private String opType;
    private String opUrl;
    private String postID;
    private static final int fMm = com.baidu.tbadk.data.d.JO() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.f fVar);
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.fMn = null;
        this.fMo = null;
        this.fMp = null;
        this.mForumId = null;
        this.fMq = false;
        this.fMr = false;
        this.fMs = true;
        this.fMt = true;
        this.fMu = false;
        this.mIsGood = 0;
        this.fMv = 0;
        this.fMw = 0L;
        this.fMx = 1;
        this.fMy = 1;
        this.fMz = 1;
        this.cZQ = 1;
        this.isAd = false;
        this.fMA = false;
        this.fMB = false;
        this.ffV = false;
        this.isFromMark = false;
        this.fMC = false;
        this.fMD = 0L;
        this.fME = false;
        this.fMF = null;
        this.fMG = null;
        this.isLoading = false;
        this.fMI = false;
        this.fMJ = false;
        this.fMK = false;
        this.fML = false;
        this.mLocate = null;
        this.mContext = null;
        this.fMM = null;
        this.opType = null;
        this.opUrl = null;
        this.fMN = null;
        this.fMO = null;
        this.fMP = -1;
        this.fMQ = -1;
        this.dmS = null;
        this.fMS = false;
        this.fMT = false;
        this.postID = null;
        this.fMW = null;
        this.fMX = 0L;
        this.fMY = false;
        this.fMZ = -1;
        this.fNb = false;
        this.fNm = false;
        this.fNn = 0;
        this.fNu = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.fMV = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.aYG() != null) {
                        pbData.aYG().eO(0);
                    }
                    if (PbModel.this.fMM != null && pbData != null) {
                        com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fMM.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fNv = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aYE() != null && PbModel.this.getPbData().aYE().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aYE().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fNw = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.oI()) {
                        PbModel.this.cmR.showToast(responsedMessage.getErrorString());
                    }
                    if (responsedMessage instanceof pbPageSocketResponseMessage) {
                        PbModel.this.a((pbPageSocketResponseMessage) responsedMessage);
                    }
                    if (!(responsedMessage instanceof pbPageHttpResponseMessage)) {
                        z = false;
                    } else {
                        PbModel.this.a((pbPageHttpResponseMessage) responsedMessage);
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
                    if (!PbModel.this.fMS || !PbModel.this.fMT) {
                        if (!PbModel.this.fMS) {
                            PbModel.this.fMS = true;
                        } else {
                            PbModel.this.fMT = true;
                        }
                        if (PbModel.this.fMM != null) {
                            PbModel.this.fMM.a(PbModel.this.bbC(), z, responsedMessage, PbModel.this.fMU, System.currentTimeMillis() - PbModel.this.dPc);
                        }
                    }
                }
            }
        };
        this.fNx = null;
        registerListener(this.fNu);
        registerListener(this.fNw);
        registerListener(this.fNv);
        this.fMG = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.cmR = baseActivity;
        this.fNd = new x(this, this.cmR);
        this.fNe = new j(this, this.cmR);
        this.fNf = new o(this, this.cmR);
        this.fNg = new PbFloorAgreeModel(this);
        this.fNh = new z(this, this.cmR);
        this.cwi = new CheckRealNameModel(this.cmR.getPageContext());
        this.fNk = new SuggestEmotionModel();
        this.fNj = new AddExperiencedModel(this.cmR.getPageContext());
    }

    protected int bbC() {
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
        this.fMn = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fMn)) {
            this.fMn = this.fNd.X(intent);
        }
        this.fNn = intent.getIntExtra("key_start_from", 0);
        if (this.fNn == 0) {
            this.fNn = this.fNd.fND;
        }
        this.fMp = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.fMo = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fMq = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fMr = intent.getBooleanExtra("host_only", false);
        this.fMt = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fMv = intent.getIntExtra("is_top", 0);
        this.fMw = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fMC = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.fMA = intent.getBooleanExtra("is_sub_pb", false);
        this.fME = intent.getBooleanExtra("is_pv", false);
        this.fMD = intent.getLongExtra("msg_id", 0L);
        this.fMF = intent.getStringExtra("from_forum_name");
        this.fMO = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fMN = intent.getStringExtra("op_stat");
        this.fMI = intent.getBooleanExtra("is_from_thread_config", false);
        this.fMJ = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fMK = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fMQ = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fMP = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fMB = intent.getBooleanExtra("from_frs", false);
        this.ffV = intent.getBooleanExtra("from_maintab", false);
        this.fNb = intent.getBooleanExtra("from_smart_frs", false);
        this.fML = intent.getBooleanExtra("from_hottopic", false);
        this.fNi = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fNn = bundle.getInt("key_start_from", 0);
        this.fMn = bundle.getString("thread_id");
        this.fMp = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.fMo = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fMq = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fMr = bundle.getBoolean("host_only", false);
        this.fMt = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fMv = bundle.getInt("is_top", 0);
        this.fMw = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fMC = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.fMA = bundle.getBoolean("is_sub_pb", false);
        this.fME = bundle.getBoolean("is_pv", false);
        this.fMD = bundle.getLong("msg_id", 0L);
        this.fMF = bundle.getString("from_forum_name");
        this.fMO = bundle.getString("extra_pb_cache_key");
        this.fMI = bundle.getBoolean("is_from_thread_config", false);
        this.fMJ = bundle.getBoolean("is_from_interview_live_config", false);
        this.fMK = bundle.getBoolean("is_from_my_god_config", false);
        this.fMQ = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fMP = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fMB = bundle.getBoolean("from_frs", false);
        this.ffV = bundle.getBoolean("from_maintab", false);
        this.fNb = bundle.getBoolean("from_smart_frs", false);
        this.fML = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void x(Bundle bundle) {
        bundle.putString("thread_id", this.fMn);
        bundle.putString("post_id", this.fMp);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt("key_start_from", this.fNn);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fMq);
        bundle.putBoolean("host_only", this.fMr);
        bundle.putBoolean("squence", this.fMt);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fMv);
        bundle.putLong("thread_time", this.fMw);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fMC);
        bundle.putBoolean("is_sub_pb", this.fMA);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fME);
        bundle.putLong("msg_id", this.fMD);
        bundle.putString("extra_pb_cache_key", this.fMO);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fMI);
        bundle.putBoolean("is_from_interview_live_config", this.fMJ);
        bundle.putBoolean("is_from_my_god_config", this.fMK);
        bundle.putInt("extra_pb_is_attention_key", this.fMQ);
        bundle.putInt("extra_pb_funs_count_key", this.fMP);
        bundle.putBoolean("from_frs", this.fMB);
        bundle.putBoolean("from_maintab", this.ffV);
        bundle.putBoolean("from_smart_frs", this.fNb);
        bundle.putBoolean("from_hottopic", this.fML);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bbD() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fMn);
        if (!this.fMC) {
            sb.append(this.fMp);
        }
        sb.append(this.fMr);
        sb.append(this.fMt);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fMv);
        sb.append(this.fMw);
        sb.append(this.fMB);
        sb.append(this.ffV);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.fMA);
        sb.append(this.fME);
        sb.append(this.fMD);
        sb.append(this.fMF);
        sb.append(this.mThreadType);
        sb.append(this.fMI);
        sb.append(this.fMJ);
        sb.append(this.fMK);
        if (this.fMO != null) {
            sb.append(this.fMO);
        }
        return sb.toString();
    }

    public String bbE() {
        return this.fMF;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.fMp;
    }

    public String bbF() {
        return this.fMn;
    }

    public boolean getHostMode() {
        return this.fMr;
    }

    public boolean bbG() {
        return this.fMt;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bbH() {
        return this.fMB;
    }

    public boolean bbI() {
        return this.fMu;
    }

    public boolean bbJ() {
        return this.ffV;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bbK() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bbL() {
        return this.fMv;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void lR(int i) {
        this.fMv = i;
    }

    public boolean bbM() {
        return this.fMA;
    }

    public boolean bbN() {
        if (this.fMG == null) {
            return false;
        }
        return this.fMG.isValid();
    }

    public String zc() {
        if (this.fMG == null || !this.fMG.vk()) {
            return null;
        }
        return this.fMG.vj();
    }

    public boolean sN(int i) {
        this.fMx = i;
        if (this.fMx > this.fMG.xY().xP()) {
            this.fMx = this.fMG.xY().xP();
        }
        if (this.fMx < 1) {
            this.fMx = 1;
        }
        if (this.fMn == null) {
            return false;
        }
        return sQ(5);
    }

    public void sO(int i) {
        this.fMx = i;
        this.fMy = i;
        this.fMz = i;
    }

    public void sP(int i) {
        if (this.fMy < i) {
            this.fMy = i;
            if (this.fMy - this.fMz >= fMm) {
                this.fMz = (this.fMy - fMm) + 1;
            }
        }
        if (this.fMz > i) {
            this.fMz = i;
            if (this.fMy - this.fMz >= fMm) {
                this.fMy = (this.fMz + fMm) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.fMG;
    }

    public com.baidu.tbadk.core.data.al aCQ() {
        if (this.fMG == null) {
            return null;
        }
        return this.fMG.xY();
    }

    public boolean bbO() {
        if (this.fMt && this.fMG.xY().xU() == 0) {
            jZ(true);
            return true;
        }
        return false;
    }

    public void pV(String str) {
        if (!StringUtils.isNull(str)) {
            this.fMn = str;
            this.fMp = null;
            this.fMr = false;
            this.fMt = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fMn == null) {
            return false;
        }
        cancelLoadData();
        if (this.dmS == null) {
            this.dmS = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.dmS.start();
        }
        boolean sQ = sQ(3);
        if (this.opType != null) {
            this.opType = null;
            this.fMN = null;
            this.opUrl = null;
            return sQ;
        }
        return sQ;
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
        if (this.fNk != null) {
            this.fNk.cancelLoadData();
        }
        if (this.fNg != null) {
            this.fNg.cancelLoadData();
        }
        if (this.fNl != null) {
            this.fNl.cancelLoadData();
        }
        apY();
    }

    private void apY() {
        if (this.dmS != null) {
            this.dmS.destory();
            this.dmS = null;
        }
    }

    public boolean MO() {
        return (this.fMp == null || this.fMp.equals("0") || this.fMp.length() == 0) ? LoadData() : bbR();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        String str;
        String str2;
        String str3 = "";
        if (forumData != null) {
            if (!TextUtils.isEmpty(forumData.getId())) {
                str3 = forumData.getId();
            }
            if (!TextUtils.isEmpty(forumData.getName())) {
                str = str3;
                str2 = forumData.getName();
                this.fNk.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fNk.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fNl == null) {
                this.fNl = new GetSugMatchWordsModel(this.cmR.getPageContext());
            }
            this.fNl.b(aVar);
        }
    }

    public boolean sQ(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        sR(i);
        final com.baidu.tieba.pb.data.f pbData = aj.bcN().getPbData();
        if (pbData != null && pbData.aYG() != null) {
            pbData.aYG().eO(0);
            this.fMt = aj.bcN().bbG();
            this.fMr = aj.bcN().bcS();
            this.fMu = aj.bcN().bcT();
            this.fNp = aj.bcN().bcR();
            this.fNq = aj.bcN().bcQ();
            this.fNr = aj.bcN().bcP();
            this.fNm = this.fMr;
            if (this.fMr || this.isFromMark) {
                this.fMR = false;
            }
            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.fMV) {
            a(bbW(), true, this.fMp, 3);
        }
        if (i == 3 && !this.fMV) {
            if (this.isFromMark) {
                a(bbW(), true, this.fMp, 3);
            } else {
                a(bbW(), false, this.fMp, 3);
            }
        }
        this.fMV = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.bpe);
        if (this.fMr || this.isFromMark) {
            this.fMR = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fMn == null || this.fMn.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.fMn, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.an.CJ().CL() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ao));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aq));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.fMt) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.fMr) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fME) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fMD));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fMR) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.h(this.fMN, 0));
            pbPageRequestMessage.setOpMessageID(this.fMD);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aYI = this.fMG.aYI();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.fMt) {
                        if (this.fMz - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fMz - 1));
                        }
                    } else if (this.fMy < this.cZQ) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fMy + 1));
                    }
                }
                if (aYI != null && aYI.size() > 0) {
                    int size = aYI.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aYI.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.fMp = postData.getId();
                            if (StringUtils.isNull(this.fMp)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.fMp != null && this.fMp.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fMp, 0L));
                } else if (!this.fMt) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aYI != null && aYI.size() > 0 && aYI.get(0) != null) {
                    this.fMp = aYI.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.fMt) {
                        if (this.fMz - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fMz - 1));
                        }
                    } else if (this.fMy < this.cZQ) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fMy + 1));
                    }
                }
                if (this.fMp != null && this.fMp.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fMp, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fMr) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.fMt) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fMp, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fMx));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.fMt && this.fNm && !this.fMr) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fMp, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.fMr) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fMZ);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fNo, 0L));
                if (!this.fMt) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fNm = this.fMr;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bbW());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fNn));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fMY);
        pbPageRequestMessage.setFromSmartFrs(this.fNb ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fMq);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean baT() {
        switch (bcl()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().aYG() == null || !getPbData().aYG().Ac();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bbE()) && com.baidu.tieba.recapp.q.bmR().bmL() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.bmR().bmL().W(bbE(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.bmR().bmL().X(bbE(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bbE()) && com.baidu.tieba.recapp.q.bmR().bmL() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.bmR().bmL().X(bbE(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.bmR().bmL().W(bbE(), true));
        }
    }

    protected void sR(int i) {
        boolean z = false;
        sV(i);
        ArrayList<PostData> aYI = this.fMG.aYI();
        this.fMU = false;
        if (i == 1) {
            boolean z2 = false;
            while (aYI.size() + 30 > com.baidu.tbadk.data.d.JO()) {
                aYI.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fMG.xY().eK(1);
                if (this.fMM != null) {
                    this.fMM.f(this.fMG);
                }
            }
            this.dPc = System.currentTimeMillis();
            this.fMU = true;
        } else if (i == 2) {
            while (aYI.size() + 30 > com.baidu.tbadk.data.d.JO()) {
                aYI.remove(aYI.size() - 1);
                z = true;
            }
            if (z) {
                this.fMG.xY().eJ(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.fNc = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            i(fVar2);
            h(fVar2);
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.f fVar) {
        Long l;
        if (fVar != null && !StringUtils.isNull(this.fMo)) {
            try {
                Long valueOf = Long.valueOf(this.fMo);
                com.baidu.tieba.pb.data.n aYR = fVar.aYR();
                if (aYR != null && aYR.fEy != null) {
                    if (aYR.fEy.isEmpty() || !aYR.fEy.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fMn);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            l = null;
                        }
                        if (l != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_GOD_REPLY, l));
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
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

    protected void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            if (this.fMK || this.fMI || this.fMJ) {
                fVar = k(fVar);
            }
            j(fVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String l = l(fVar);
            for (int i = 0; i < fVar.aYI().size(); i++) {
                PostData postData = fVar.aYI().get(i);
                for (int i2 = 0; i2 < postData.bvE().size(); i2++) {
                    postData.bvE().get(i2).b(this.cmR.getPageContext(), l.equals(postData.bvE().get(i2).yS().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n aYR = fVar.aYR();
            if (aYR != null && !com.baidu.tbadk.core.util.v.E(aYR.fEx)) {
                for (PostData postData2 : aYR.fEx) {
                    for (int i3 = 0; i3 < postData2.bvE().size(); i3++) {
                        postData2.bvE().get(i3).b(this.cmR.getPageContext(), l.equals(postData2.bvE().get(i3).yS().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String l = l(fVar);
            com.baidu.tieba.pb.data.n aYR = fVar.aYR();
            if (aYR != null && !com.baidu.tbadk.core.util.v.E(aYR.fEx)) {
                for (PostData postData : aYR.fEx.subList(i, aYR.fEx.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bvE().size()) {
                            postData.bvE().get(i3).b(this.cmR.getPageContext(), l.equals(postData.bvE().get(i3).yS().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.f k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null) {
            return null;
        }
        bd aYG = fVar.aYG();
        aYG.eS(this.mIsGood);
        aYG.eR(this.fMv);
        if (this.fMw > 0) {
            aYG.v(this.fMw);
            return fVar;
        }
        return fVar;
    }

    protected String l(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aYG() != null && fVar.aYG().yS() != null) {
            str = fVar.aYG().yS().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bbP() {
        if (this.fMG == null || this.fMG.aYG() == null || this.fMG.aYG().yS() == null) {
            return null;
        }
        return this.fMG.aYG().yS();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fNa = z3;
        this.fMH = i;
        if (this.dmS != null && !z3) {
            this.dmS.a(z2, z4, i2, str, i3, j, j2);
            this.dmS = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bbE()) && com.baidu.tieba.recapp.q.bmR().bmL() != null) {
            com.baidu.tieba.recapp.q.bmR().bmL().f(bbE(), sS(getRequestType()), true);
        }
        if (fVar == null || (this.fMx == 1 && i == 5 && fVar.aYI() != null && fVar.aYI().size() < 1)) {
            if (this.fMM != null) {
                this.fMt = this.fMs;
                this.fMM.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fMs = this.fMt;
            this.fME = false;
            if (fVar.xY() != null) {
                sP(fVar.xY().xS());
                this.cZQ = fVar.xY().xP();
            }
            this.cZQ = this.cZQ < 1 ? 1 : this.cZQ;
            ArrayList<PostData> aYI = this.fMG.aYI();
            switch (i) {
                case 1:
                    this.fMG.a(fVar.xY(), 1);
                    e(fVar, aYI);
                    i5 = 0;
                    break;
                case 2:
                    if (fVar.aYI() == null) {
                        i6 = 0;
                    } else {
                        int size = fVar.aYI().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(aYI, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.f(fVar.aYI(), com.baidu.tbadk.core.util.v.D(fVar.aYI()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            fVar.aYI().remove(postData2);
                            i6 = size - 1;
                        }
                        aYI.addAll(0, fVar.aYI());
                    }
                    this.fMG.a(fVar.xY(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.fMt && fVar.xY() != null) {
                        fVar.xY().eH(fVar.xY().xP());
                    }
                    m(fVar);
                    if (!z3 && this.mThreadType != 33 && this.fMt) {
                        bbQ();
                        i5 = 0;
                        break;
                    }
                    i5 = 0;
                    break;
                case 4:
                    m(fVar);
                    i5 = 0;
                    break;
                case 5:
                    m(fVar);
                    i5 = 0;
                    break;
                case 6:
                    m(fVar);
                    i5 = 0;
                    break;
                case 7:
                    m(fVar);
                    i5 = 0;
                    break;
                case 8:
                    if (fVar != null && !com.baidu.tbadk.core.util.v.E(fVar.aYI()) && this.fMG != null && (!this.fMr || l(fVar).equals(fVar.aYI().get(0).yS().getUserId()))) {
                        if (this.fMG.xY().xU() == 0) {
                            this.fMG.xY().eJ(1);
                        }
                        bcm();
                        this.fNp = fVar.aYI().get(0);
                        if (this.fMt) {
                            if (this.fMG.aYI().size() - this.fNr >= 3) {
                                this.fNq = new PostData();
                                this.fNq.gYG = true;
                                this.fNq.setPostType(53);
                                this.fMG.aYI().add(this.fNq);
                            }
                            this.fMG.aYI().add(this.fNp);
                            i4 = this.fMG.aYI().size() - 1;
                        } else {
                            if (this.fNr - this.fNs >= 3) {
                                this.fNq = new PostData();
                                this.fNq.gYG = false;
                                this.fNq.setPostType(53);
                                this.fMG.aYI().add(0, this.fNq);
                            }
                            this.fMG.aYI().add(0, this.fNp);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.am.W(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fNp.gYT = this.fMG.aZf();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        }
                        i5 = i4;
                        break;
                    }
                    i5 = 0;
                    break;
                default:
                    i5 = 0;
                    break;
            }
            if (this.fMG != null && this.fMG.aYG() != null) {
                PraiseData yH = this.fMG.aYG().yH();
                if (this.fNx != null && !yH.isPriaseDataValid()) {
                    this.fMG.aYG().a(this.fNx);
                } else {
                    this.fNx = this.fMG.aYG().yH();
                    this.fNx.setPostId(this.fMG.aYG().zj());
                }
                if (fVar.xY() != null && fVar.xY().xS() == 1 && fVar.aYG() != null && fVar.aYG().ze() != null && fVar.aYG().ze().size() > 0) {
                    this.fMG.aYG().i(fVar.aYG().ze());
                }
                this.fMG.aYG().eP(fVar.aYG().yK());
                this.fMG.aYG().eM(fVar.aYG().getAnchorLevel());
                this.fMG.aYG().eO(fVar.aYG().yD());
                if (this.mThreadType == 33) {
                    this.fMG.aYG().yS().setHadConcerned(fVar.aYG().yS().hadConcerned());
                }
                if (fVar != null && fVar.aYG() != null) {
                    this.fMG.aYG().eU(fVar.aYG().zi());
                }
            }
            if (this.fMG != null && this.fMG.getUserData() != null && fVar.getUserData() != null) {
                this.fMG.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.fMG.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.xY() != null && fVar.xY().xS() == 1 && fVar.aYQ() != null) {
                this.fMG.c(fVar.aYQ());
            }
            if (this.fNa) {
                if (this.fMG.aYG() != null && this.fMG.aYG().yS() != null && this.fMG.aYI() != null && com.baidu.tbadk.core.util.v.f(this.fMG.aYI(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.f(this.fMG.aYI(), 0);
                    MetaData yS = this.fMG.aYG().yS();
                    if (postData3.yS() != null && postData3.yS().getGodUserData() != null) {
                        if (this.fMP != -1) {
                            yS.setFansNum(this.fMP);
                            postData3.yS().setFansNum(this.fMP);
                        }
                        if (this.fMQ != -1) {
                            yS.getGodUserData().setIsLike(this.fMQ == 1);
                            postData3.yS().getGodUserData().setIsLike(this.fMQ == 1);
                            yS.getGodUserData().setIsFromNetWork(false);
                            postData3.yS().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fMG.fDS = -1;
                this.fMG.fDR = -1;
            }
            if (this.fMM != null) {
                this.fMM.a(true, getErrorCode(), i, i5, this.fMG, this.mErrorString, 1);
            }
        }
        if (this.fMG != null && this.fMG.aYG() != null && this.fMG.aYE() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.cmR;
            historyMessage.threadId = getPbData().aYG().getId();
            if (this.mIsShareThread && getPbData().aYG().aOZ != null) {
                historyMessage.threadName = getPbData().aYG().aOZ.showText;
            } else {
                historyMessage.threadName = getPbData().aYG().getTitle();
            }
            if (this.mIsShareThread && !baT()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().aYE().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bbG();
            historyMessage.threadType = getPbData().aYG().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String al;
        if (arrayList != null && fVar.aYI() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(fVar.aYI(), 0);
            if (postData != null && (al = al(arrayList)) != null && al.equals(postData.getId())) {
                fVar.aYI().remove(postData);
            }
            arrayList.addAll(fVar.aYI());
        }
    }

    private int sS(int i) {
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
        int D = com.baidu.tbadk.core.util.v.D(arrayList);
        if (D <= 0) {
            return null;
        }
        for (int i = D - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.tieba.pb.data.f fVar) {
        fVar.pU(this.fMG.aYX());
        this.fMG = fVar;
        sO(fVar.xY().xS());
    }

    private void bbQ() {
        if (this.fMG != null && this.fMG.aYI() != null && this.fMG.aYW() != null) {
            ArrayList<PostData> aYI = this.fMG.aYI();
            com.baidu.tieba.pb.data.a aYW = this.fMG.aYW();
            int aYw = aYW.aYw();
            if (aYw > 0) {
                if (aYw <= aYI.size()) {
                    aYI.add(aYw, aYW);
                } else {
                    aYI.add(aYW);
                }
            }
        }
    }

    public boolean bbR() {
        if (this.fMn == null || this.fMp == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return sQ(4);
        }
        return sQ(6);
    }

    public boolean jZ(boolean z) {
        if (this.fMn == null || this.fMG == null) {
            return false;
        }
        if (z || this.fMG.xY().xU() != 0) {
            return sQ(1);
        }
        return false;
    }

    public boolean ka(boolean z) {
        if (this.fMn == null || this.fMG == null) {
            return false;
        }
        if ((z || this.fMG.xY().xV() != 0) && this.fMG.aYI() != null && this.fMG.aYI().size() >= 1) {
            return sQ(2);
        }
        return false;
    }

    public boolean qa(String str) {
        this.fMr = !this.fMr;
        this.fMp = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (sQ(6)) {
            return true;
        }
        this.fMr = this.fMr ? false : true;
        return false;
    }

    public boolean j(boolean z, String str) {
        if (this.fMr == z) {
            return false;
        }
        this.fMr = z;
        this.fMp = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (sQ(6)) {
            return true;
        }
        this.fMr = z ? false : true;
        return false;
    }

    public boolean bbS() {
        this.fMs = this.fMt;
        this.fMt = !this.fMt;
        if (this.isLoading || !LoadData()) {
            this.fMt = this.fMt ? false : true;
            return false;
        }
        return true;
    }

    public boolean bbT() {
        return this.fMt;
    }

    public boolean hasData() {
        return (this.fMG == null || this.fMG.aYE() == null || this.fMG.aYG() == null) ? false : true;
    }

    public boolean vk() {
        if (this.fMG == null) {
            return false;
        }
        return this.fMG.vk();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData ga(String str) {
        if (this.fMG == null || this.fMG.aYG() == null || this.fMG.aYE() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fMG.aYG().Ac()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fMG.aYE().getId());
            writeData.setForumName(this.fMG.aYE().getName());
        }
        writeData.sourceFrom = String.valueOf(this.fNn);
        writeData.setThreadId(this.fMn);
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

    public MarkData sT(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fMG == null) {
            return null;
        }
        ArrayList<PostData> aYI = this.fMG.aYI();
        if (com.baidu.tbadk.core.util.v.E(aYI)) {
            return null;
        }
        if (aYI.size() > 0 && i >= aYI.size()) {
            i = aYI.size() - 1;
        }
        return h(aYI.get(i));
    }

    public MarkData bbU() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fMn);
        markData.setPostId(this.fMG.vj());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fMr);
        markData.setSequence(Boolean.valueOf(this.fMt));
        markData.setId(this.fMn);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fMn);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fMr);
        markData.setSequence(Boolean.valueOf(this.fMt));
        markData.setId(this.fMn);
        markData.setFloor(postData.bvH());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bbV() {
        i.bbn().P(bbW(), this.isFromMark);
    }

    private String bbW() {
        String str = this.fMn;
        if (this.fMr) {
            str = str + DB_KEY_HOST;
        }
        if (!this.fMt) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void kb(boolean z) {
        if (this.fMG != null) {
            this.fMG.aH(z);
        }
    }

    public void kc(boolean z) {
        this.fMR = z;
    }

    public boolean bbX() {
        return this.fMR;
    }

    public void a(a aVar) {
        this.fMM = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String KO() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean KN() {
        return MO();
    }

    public boolean qb(String str) {
        if (getPbData() == null || getPbData().aYG() == null || getPbData().aYG().yS() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aYG().yS().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bbY() {
        String bbW = bbW();
        i.bbn().P(bbW, false);
        i.bbn().P(bbW, true);
    }

    public void bbZ() {
        if ("personalize_page".equals(this.mStType)) {
            this.fMX = System.currentTimeMillis() / 1000;
        }
    }

    public void bca() {
        if ("personalize_page".equals(this.mStType) && this.fMG != null && this.fMX != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ab(ImageViewerConfig.FORUM_ID, this.fMG.getForumId()).ab("tid", this.fMn).ab("obj_duration", String.valueOf(currentTimeMillis - this.fMX)).ab("obj_param3", String.valueOf(currentTimeMillis)));
            this.fMX = 0L;
        }
    }

    public boolean bcb() {
        return this.fNa;
    }

    public int getErrorNo() {
        return this.fNc;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public j bcc() {
        return this.fNe;
    }

    public o bcd() {
        return this.fNf;
    }

    public PbFloorAgreeModel bce() {
        return this.fNg;
    }

    public z bcf() {
        return this.fNh;
    }

    public CheckRealNameModel bcg() {
        return this.cwi;
    }

    public AddExperiencedModel bch() {
        return this.fNj;
    }

    public String bci() {
        return this.fMW;
    }

    public void qc(String str) {
        this.fMW = str;
    }

    public boolean bcj() {
        return this.fNb;
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fMG != null && this.fMG.aYI() != null && this.fMG.aYI().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fMG.aYI().size();
                for (int i = 0; i < size; i++) {
                    if (this.fMG.aYI().get(i) != null && this.fMG.aYI().get(i).yS() != null && currentAccount.equals(this.fMG.aYI().get(i).yS().getUserId()) && this.fMG.aYI().get(i).yS().getPendantData() != null) {
                        this.fMG.aYI().get(i).yS().getPendantData().cM(hVar.xt());
                        this.fMG.aYI().get(i).yS().getPendantData().ab(hVar.JW());
                    }
                }
            }
        }
    }

    public String bck() {
        return this.fNi;
    }

    public int bcl() {
        return this.fNn;
    }

    public void sU(int i) {
        this.fNn = i;
    }

    public void qd(String str) {
        if ((!this.fMr || qb(TbadkCoreApplication.getCurrentAccount())) && this.fMG.aYI() != null) {
            this.fMG.xY().eJ(1);
            if (this.fMG.xY().xU() == 0) {
                this.fMG.xY().eJ(1);
            }
            this.fNo = str;
            sQ(8);
        }
    }

    private void sV(int i) {
        if (i != 8) {
            this.fNo = "";
            if (this.fNp != null) {
                if (i == 1 && !this.fMt && !com.baidu.tbadk.core.util.v.E(getPbData().aYI())) {
                    getPbData().aYI().remove(this.fNp);
                    if (this.fNq != null) {
                        getPbData().aYI().remove(this.fNq);
                    }
                    getPbData().aYI().add(0, this.fNp);
                } else {
                    getPbData().aYI().remove(this.fNp);
                    if (this.fNq != null) {
                        getPbData().aYI().remove(this.fNq);
                    }
                }
            }
            this.fNq = null;
        }
    }

    public void bcm() {
        if (this.fMG != null && !com.baidu.tbadk.core.util.v.E(this.fMG.aYI())) {
            if (this.fNq != null) {
                this.fMG.aYI().remove(this.fNq);
                this.fNq = null;
            }
            if (this.fNp != null) {
                this.fMG.aYI().remove(this.fNp);
                this.fNp = null;
            }
        }
    }

    public void cs(int i, int i2) {
        this.fNr = i;
        this.fNs = i2;
    }

    public PostData bcn() {
        return this.fNp;
    }

    public PostData bco() {
        return this.fNq;
    }

    public int bcp() {
        return this.fNr;
    }

    public String bcq() {
        return this.fNt;
    }

    public void qe(String str) {
        this.fNt = str;
    }
}
