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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.share.AddExperiencedModel;
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
    private BaseActivity bmZ;
    private int cEQ;
    private com.baidu.tieba.tbadkCore.d.b cTx;
    private final CheckRealNameModel ccK;
    private long dDh;
    private boolean eIS;
    protected String fAH;
    private String fAI;
    private String fAJ;
    private boolean fAK;
    private boolean fAL;
    private boolean fAM;
    private boolean fAN;
    private boolean fAO;
    private int fAP;
    private long fAQ;
    private int fAR;
    private int fAS;
    private int fAT;
    private boolean fAU;
    private boolean fAV;
    private boolean fAW;
    private long fAX;
    private boolean fAY;
    private String fAZ;
    private final r fBA;
    private final z fBB;
    private String fBC;
    private final AddExperiencedModel fBD;
    private SuggestEmotionModel fBE;
    private GetSugMatchWordsModel fBF;
    private boolean fBG;
    private int fBH;
    private String fBI;
    private PostData fBJ;
    private PostData fBK;
    private int fBL;
    private int fBM;
    private String fBN;
    private CustomMessageListener fBO;
    private CustomMessageListener fBP;
    private com.baidu.adp.framework.listener.a fBQ;
    private PraiseData fBR;
    protected com.baidu.tieba.pb.data.d fBa;
    private int fBb;
    private boolean fBc;
    private boolean fBd;
    private boolean fBe;
    private boolean fBf;
    private a fBg;
    private String fBh;
    private String fBi;
    private int fBj;
    private int fBk;
    private boolean fBl;
    private boolean fBm;
    private boolean fBn;
    private boolean fBo;
    private boolean fBp;
    private String fBq;
    private long fBr;
    private boolean fBs;
    private int fBt;
    private boolean fBu;
    private boolean fBv;
    private int fBw;
    private final x fBx;
    private final h fBy;
    private final m fBz;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private com.baidu.tieba.pb.data.c mAppealInfo;
    protected Context mContext;
    private String mForumId;
    private String mFromForumId;
    private int mIsGood;
    private boolean mIsShareThread;
    private String mLocate;
    private int mRequestType;
    public String mStType;
    protected int mThreadType;
    private String opType;
    private String opUrl;
    private String postID;
    private static final int fAG = com.baidu.tbadk.data.d.GR() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.d dVar);
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.fAH = null;
        this.fAI = null;
        this.fAJ = null;
        this.mForumId = null;
        this.fAK = false;
        this.fAL = false;
        this.fAM = true;
        this.fAN = true;
        this.fAO = false;
        this.mIsGood = 0;
        this.fAP = 0;
        this.fAQ = 0L;
        this.fAR = 1;
        this.fAS = 1;
        this.fAT = 1;
        this.cEQ = 1;
        this.isAd = false;
        this.eIS = false;
        this.fAU = false;
        this.fAV = false;
        this.isFromMark = false;
        this.fAW = false;
        this.fAX = 0L;
        this.fAY = false;
        this.fAZ = null;
        this.fBa = null;
        this.isLoading = false;
        this.fBc = false;
        this.fBd = false;
        this.fBe = false;
        this.fBf = false;
        this.mLocate = null;
        this.mContext = null;
        this.fBg = null;
        this.opType = null;
        this.opUrl = null;
        this.fBh = null;
        this.fBi = null;
        this.fBj = -1;
        this.fBk = -1;
        this.cTx = null;
        this.fBm = false;
        this.fBn = false;
        this.postID = null;
        this.fBq = null;
        this.fBr = 0L;
        this.fBs = false;
        this.fBt = -1;
        this.fBv = false;
        this.fBG = false;
        this.fBH = 0;
        this.fBO = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.fBp = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.aZn() != null) {
                        pbData.aZn().bS(0);
                    }
                    if (PbModel.this.fBg != null && pbData != null) {
                        com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fBg.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fBP = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aZl() != null && PbModel.this.getPbData().aZl().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aZl().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fBQ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.jE()) {
                        PbModel.this.bmZ.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.fBm || !PbModel.this.fBn) {
                        if (!PbModel.this.fBm) {
                            PbModel.this.fBm = true;
                        } else {
                            PbModel.this.fBn = true;
                        }
                        if (PbModel.this.fBg != null) {
                            PbModel.this.fBg.a(PbModel.this.bcf(), z, responsedMessage, PbModel.this.fBo, System.currentTimeMillis() - PbModel.this.dDh);
                        }
                    }
                }
            }
        };
        this.fBR = null;
        registerListener(this.fBO);
        registerListener(this.fBQ);
        registerListener(this.fBP);
        this.fBa = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bmZ = baseActivity;
        this.fBx = new x(this, this.bmZ);
        this.fBy = new h(this, this.bmZ);
        this.fBz = new m(this, this.bmZ);
        this.fBA = new r(this, getUniqueId());
        this.fBB = new z(this, this.bmZ);
        this.ccK = new CheckRealNameModel(this.bmZ.getPageContext());
        this.fBE = new SuggestEmotionModel();
        this.fBD = new AddExperiencedModel(this.bmZ.getPageContext());
    }

    protected int bcf() {
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
        this.fAH = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fAH)) {
            this.fAH = this.fBx.U(intent);
            if (StringUtils.isNull(this.fAH) && intent.getData() != null) {
                this.fAH = intent.getData().getQueryParameter("thread_id");
            }
        }
        this.fBH = intent.getIntExtra("key_start_from", 0);
        if (this.fBH == 0) {
            this.fBH = this.fBx.fBX;
        }
        this.fAJ = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.mFromForumId = intent.getStringExtra("from_forum_id");
        this.fAI = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fAK = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fAL = intent.getBooleanExtra("host_only", false);
        this.fAN = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fAP = intent.getIntExtra("is_top", 0);
        this.fAQ = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fAW = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eIS = intent.getBooleanExtra("is_sub_pb", false);
        this.fAY = intent.getBooleanExtra("is_pv", false);
        this.fAX = intent.getLongExtra("msg_id", 0L);
        this.fAZ = intent.getStringExtra("from_forum_name");
        this.fBi = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fBh = intent.getStringExtra("op_stat");
        this.fBc = intent.getBooleanExtra("is_from_thread_config", false);
        this.fBd = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fBe = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fBk = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fBj = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fAU = intent.getBooleanExtra("from_frs", false);
        this.fAV = intent.getBooleanExtra("from_maintab", false);
        this.fBv = intent.getBooleanExtra("from_smart_frs", false);
        this.fBf = intent.getBooleanExtra("from_hottopic", false);
        this.fBC = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fBH = bundle.getInt("key_start_from", 0);
        this.fAH = bundle.getString("thread_id");
        this.fAJ = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.fAI = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fAK = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fAL = bundle.getBoolean("host_only", false);
        this.fAN = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fAP = bundle.getInt("is_top", 0);
        this.fAQ = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fAW = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eIS = bundle.getBoolean("is_sub_pb", false);
        this.fAY = bundle.getBoolean("is_pv", false);
        this.fAX = bundle.getLong("msg_id", 0L);
        this.fAZ = bundle.getString("from_forum_name");
        this.fBi = bundle.getString("extra_pb_cache_key");
        this.fBc = bundle.getBoolean("is_from_thread_config", false);
        this.fBd = bundle.getBoolean("is_from_interview_live_config", false);
        this.fBe = bundle.getBoolean("is_from_my_god_config", false);
        this.fBk = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fBj = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fAU = bundle.getBoolean("from_frs", false);
        this.fAV = bundle.getBoolean("from_maintab", false);
        this.fBv = bundle.getBoolean("from_smart_frs", false);
        this.fBf = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void z(Bundle bundle) {
        bundle.putString("thread_id", this.fAH);
        bundle.putString("post_id", this.fAJ);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.fBH);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fAK);
        bundle.putBoolean("host_only", this.fAL);
        bundle.putBoolean("squence", this.fAN);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fAP);
        bundle.putLong("thread_time", this.fAQ);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fAW);
        bundle.putBoolean("is_sub_pb", this.eIS);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fAY);
        bundle.putLong("msg_id", this.fAX);
        bundle.putString("extra_pb_cache_key", this.fBi);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fBc);
        bundle.putBoolean("is_from_interview_live_config", this.fBd);
        bundle.putBoolean("is_from_my_god_config", this.fBe);
        bundle.putInt("extra_pb_is_attention_key", this.fBk);
        bundle.putInt("extra_pb_funs_count_key", this.fBj);
        bundle.putBoolean("from_frs", this.fAU);
        bundle.putBoolean("from_maintab", this.fAV);
        bundle.putBoolean("from_smart_frs", this.fBv);
        bundle.putBoolean("from_hottopic", this.fBf);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bcg() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fAH);
        if (!this.fAW) {
            sb.append(this.fAJ);
        }
        sb.append(this.fAL);
        sb.append(this.fAN);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fAP);
        sb.append(this.fAQ);
        sb.append(this.fAU);
        sb.append(this.fAV);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eIS);
        sb.append(this.fAY);
        sb.append(this.fAX);
        sb.append(this.fAZ);
        sb.append(this.mThreadType);
        sb.append(this.fBc);
        sb.append(this.fBd);
        sb.append(this.fBe);
        if (this.fBi != null) {
            sb.append(this.fBi);
        }
        return sb.toString();
    }

    public String bch() {
        return this.fAZ;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.fAJ;
    }

    public String bci() {
        return this.fAH;
    }

    public boolean getHostMode() {
        return this.fAL;
    }

    public boolean bcj() {
        return this.fAN;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bck() {
        return this.fAU;
    }

    public boolean bcl() {
        return this.fAO;
    }

    public boolean bcm() {
        return this.fAV;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bcn() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bco() {
        return this.fAP;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void jj(int i) {
        this.fAP = i;
    }

    public boolean bcp() {
        return this.eIS;
    }

    public boolean bcq() {
        if (this.fBa == null) {
            return false;
        }
        return this.fBa.isValid();
    }

    public String vu() {
        if (this.fBa == null || !this.fBa.rN()) {
            return null;
        }
        return this.fBa.rM();
    }

    public boolean qD(int i) {
        this.fAR = i;
        if (this.fAR > this.fBa.uw().un()) {
            this.fAR = this.fBa.uw().un();
        }
        if (this.fAR < 1) {
            this.fAR = 1;
        }
        if (this.fAH == null) {
            return false;
        }
        return qF(5);
    }

    public void qE(int i) {
        this.fAR = i;
        this.fAS = i;
        this.fAT = i;
    }

    public void c(com.baidu.tbadk.core.data.al alVar) {
        if (alVar == null) {
            qE(1);
            return;
        }
        this.fAS = alVar.uq();
        this.fAT = alVar.uq();
        this.cEQ = alVar.un();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.fBa;
    }

    public com.baidu.tbadk.core.data.al getPageData() {
        if (this.fBa == null) {
            return null;
        }
        return this.fBa.uw();
    }

    public boolean bcr() {
        if (this.fAN && this.fBa.uw().us() == 0) {
            jP(true);
            return true;
        }
        return false;
    }

    public void rb(String str) {
        if (!StringUtils.isNull(str)) {
            this.fAH = str;
            this.fAJ = null;
            this.fAL = false;
            this.fAN = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fAH == null) {
            return false;
        }
        cancelLoadData();
        if (this.cTx == null) {
            this.cTx = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.cTx.start();
        }
        boolean qF = qF(3);
        if (this.opType != null) {
            this.opType = null;
            this.fBh = null;
            this.opUrl = null;
            return qF;
        }
        return qF;
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
        if (this.fBE != null) {
            this.fBE.cancelLoadData();
        }
        if (this.fBA != null) {
            this.fBA.cancelLoadData();
        }
        if (this.fBF != null) {
            this.fBF.cancelLoadData();
        }
        aph();
    }

    private void aph() {
        if (this.cTx != null) {
            this.cTx.destory();
            this.cTx = null;
        }
    }

    public boolean JR() {
        return (this.fAJ == null || this.fAJ.equals("0") || this.fAJ.length() == 0) ? LoadData() : bcu();
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
                this.fBE.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fBE.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fBF == null) {
                this.fBF = new GetSugMatchWordsModel(this.bmZ.getPageContext());
            }
            this.fBF.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02d9 A[Catch: Exception -> 0x0216, TryCatch #0 {Exception -> 0x0216, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:41:0x0128, B:43:0x0145, B:44:0x014d, B:46:0x0151, B:47:0x0159, B:49:0x015d, B:50:0x0162, B:52:0x0166, B:53:0x016b, B:55:0x016f, B:56:0x017f, B:58:0x0183, B:59:0x018b, B:61:0x018f, B:62:0x01a8, B:63:0x01b7, B:64:0x01ba, B:67:0x01e6, B:69:0x01f9, B:74:0x0220, B:76:0x0236, B:78:0x023c, B:80:0x0243, B:81:0x0250, B:83:0x0264, B:85:0x0268, B:87:0x026e, B:94:0x0295, B:96:0x029b, B:88:0x0279, B:90:0x027d, B:92:0x0285, B:93:0x0290, B:97:0x02a7, B:99:0x02bb, B:101:0x02bf, B:104:0x02d1, B:128:0x0331, B:108:0x02d9, B:110:0x02df, B:111:0x02e4, B:113:0x02e8, B:115:0x02f2, B:120:0x0309, B:122:0x0317, B:123:0x031a, B:125:0x031e, B:127:0x0326, B:129:0x0336, B:131:0x033a, B:117:0x02f6, B:132:0x0343, B:133:0x0371, B:135:0x0375, B:145:0x03a4, B:138:0x0381, B:140:0x038d, B:141:0x0395, B:143:0x0399, B:144:0x039f, B:146:0x03ad, B:137:0x0379, B:147:0x03b6, B:149:0x03c2, B:151:0x03c6, B:153:0x03ca, B:154:0x03cf, B:156:0x03db, B:157:0x03e3, B:159:0x03f4, B:158:0x03e8, B:160:0x03fd, B:162:0x040c, B:36:0x00c8), top: B:166:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02e8 A[Catch: Exception -> 0x0216, TryCatch #0 {Exception -> 0x0216, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:41:0x0128, B:43:0x0145, B:44:0x014d, B:46:0x0151, B:47:0x0159, B:49:0x015d, B:50:0x0162, B:52:0x0166, B:53:0x016b, B:55:0x016f, B:56:0x017f, B:58:0x0183, B:59:0x018b, B:61:0x018f, B:62:0x01a8, B:63:0x01b7, B:64:0x01ba, B:67:0x01e6, B:69:0x01f9, B:74:0x0220, B:76:0x0236, B:78:0x023c, B:80:0x0243, B:81:0x0250, B:83:0x0264, B:85:0x0268, B:87:0x026e, B:94:0x0295, B:96:0x029b, B:88:0x0279, B:90:0x027d, B:92:0x0285, B:93:0x0290, B:97:0x02a7, B:99:0x02bb, B:101:0x02bf, B:104:0x02d1, B:128:0x0331, B:108:0x02d9, B:110:0x02df, B:111:0x02e4, B:113:0x02e8, B:115:0x02f2, B:120:0x0309, B:122:0x0317, B:123:0x031a, B:125:0x031e, B:127:0x0326, B:129:0x0336, B:131:0x033a, B:117:0x02f6, B:132:0x0343, B:133:0x0371, B:135:0x0375, B:145:0x03a4, B:138:0x0381, B:140:0x038d, B:141:0x0395, B:143:0x0399, B:144:0x039f, B:146:0x03ad, B:137:0x0379, B:147:0x03b6, B:149:0x03c2, B:151:0x03c6, B:153:0x03ca, B:154:0x03cf, B:156:0x03db, B:157:0x03e3, B:159:0x03f4, B:158:0x03e8, B:160:0x03fd, B:162:0x040c, B:36:0x00c8), top: B:166:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x031e A[Catch: Exception -> 0x0216, TryCatch #0 {Exception -> 0x0216, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:41:0x0128, B:43:0x0145, B:44:0x014d, B:46:0x0151, B:47:0x0159, B:49:0x015d, B:50:0x0162, B:52:0x0166, B:53:0x016b, B:55:0x016f, B:56:0x017f, B:58:0x0183, B:59:0x018b, B:61:0x018f, B:62:0x01a8, B:63:0x01b7, B:64:0x01ba, B:67:0x01e6, B:69:0x01f9, B:74:0x0220, B:76:0x0236, B:78:0x023c, B:80:0x0243, B:81:0x0250, B:83:0x0264, B:85:0x0268, B:87:0x026e, B:94:0x0295, B:96:0x029b, B:88:0x0279, B:90:0x027d, B:92:0x0285, B:93:0x0290, B:97:0x02a7, B:99:0x02bb, B:101:0x02bf, B:104:0x02d1, B:128:0x0331, B:108:0x02d9, B:110:0x02df, B:111:0x02e4, B:113:0x02e8, B:115:0x02f2, B:120:0x0309, B:122:0x0317, B:123:0x031a, B:125:0x031e, B:127:0x0326, B:129:0x0336, B:131:0x033a, B:117:0x02f6, B:132:0x0343, B:133:0x0371, B:135:0x0375, B:145:0x03a4, B:138:0x0381, B:140:0x038d, B:141:0x0395, B:143:0x0399, B:144:0x039f, B:146:0x03ad, B:137:0x0379, B:147:0x03b6, B:149:0x03c2, B:151:0x03c6, B:153:0x03ca, B:154:0x03cf, B:156:0x03db, B:157:0x03e3, B:159:0x03f4, B:158:0x03e8, B:160:0x03fd, B:162:0x040c, B:36:0x00c8), top: B:166:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x033a A[Catch: Exception -> 0x0216, TryCatch #0 {Exception -> 0x0216, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:41:0x0128, B:43:0x0145, B:44:0x014d, B:46:0x0151, B:47:0x0159, B:49:0x015d, B:50:0x0162, B:52:0x0166, B:53:0x016b, B:55:0x016f, B:56:0x017f, B:58:0x0183, B:59:0x018b, B:61:0x018f, B:62:0x01a8, B:63:0x01b7, B:64:0x01ba, B:67:0x01e6, B:69:0x01f9, B:74:0x0220, B:76:0x0236, B:78:0x023c, B:80:0x0243, B:81:0x0250, B:83:0x0264, B:85:0x0268, B:87:0x026e, B:94:0x0295, B:96:0x029b, B:88:0x0279, B:90:0x027d, B:92:0x0285, B:93:0x0290, B:97:0x02a7, B:99:0x02bb, B:101:0x02bf, B:104:0x02d1, B:128:0x0331, B:108:0x02d9, B:110:0x02df, B:111:0x02e4, B:113:0x02e8, B:115:0x02f2, B:120:0x0309, B:122:0x0317, B:123:0x031a, B:125:0x031e, B:127:0x0326, B:129:0x0336, B:131:0x033a, B:117:0x02f6, B:132:0x0343, B:133:0x0371, B:135:0x0375, B:145:0x03a4, B:138:0x0381, B:140:0x038d, B:141:0x0395, B:143:0x0399, B:144:0x039f, B:146:0x03ad, B:137:0x0379, B:147:0x03b6, B:149:0x03c2, B:151:0x03c6, B:153:0x03ca, B:154:0x03cf, B:156:0x03db, B:157:0x03e3, B:159:0x03f4, B:158:0x03e8, B:160:0x03fd, B:162:0x040c, B:36:0x00c8), top: B:166:0x00bc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean qF(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        qG(i);
        final com.baidu.tieba.pb.data.d pbData = aj.bdq().getPbData();
        if (pbData != null && pbData.aZn() != null) {
            pbData.aZn().bS(0);
            this.fAN = aj.bdq().bcj();
            this.fAL = aj.bdq().bdv();
            this.fAO = aj.bdq().bdw();
            this.fBJ = aj.bdq().bdu();
            this.fBK = aj.bdq().bdt();
            this.fBL = aj.bdq().bds();
            this.fBG = this.fAL;
            if (this.fAL || this.isFromMark) {
                this.fBl = false;
            }
            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.fBp) {
            a(bcz(), true, this.fAJ, 3);
        }
        if (i == 3 && !this.fBp) {
            if (this.isFromMark) {
                a(bcz(), true, this.fAJ, 3);
            } else {
                a(bcz(), false, this.fAJ, 3);
            }
        }
        this.fBp = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aLq);
        if (this.fAL || this.isFromMark) {
            this.fBl = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fAH == null || this.fAH.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.fAH, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
        int aj = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.ar.zw().zy() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aj));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.fAN) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.fAL) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fAY) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fAX));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fBl) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.fBh, 0));
            pbPageRequestMessage.setOpMessageID(this.fAX);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aZp = this.fBa.aZp();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.fAN) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fAT - 1));
                        if (this.fAT - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z) {
                                if (aZp != null && aZp.size() > 0) {
                                    size = aZp.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = aZp.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.fAJ = postData.getId();
                                            if (StringUtils.isNull(this.fAJ)) {
                                                i3 = i2 + 1;
                                            }
                                        }
                                        i2 = i3;
                                    }
                                }
                                if (this.fAJ == null && this.fAJ.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fAJ, 0L));
                                } else if (!this.fAN) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            b(pbPageRequestMessage);
                            break;
                        }
                    } else {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fAS + 1));
                        if (this.fAS >= this.cEQ) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (aZp != null) {
                                size = aZp.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                            }
                            if (this.fAJ == null) {
                            }
                            if (!this.fAN) {
                            }
                            b(pbPageRequestMessage);
                        }
                    }
                }
                z = false;
                if (!this.isFromMark) {
                }
                if (aZp != null) {
                }
                if (this.fAJ == null) {
                }
                if (!this.fAN) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (aZp != null && aZp.size() > 0 && aZp.get(0) != null) {
                    this.fAJ = aZp.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.fAN) {
                        if (this.fAT - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fAT - 1));
                        }
                    } else if (this.fAS < this.cEQ) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fAS + 1));
                    }
                }
                if (this.fAJ != null && this.fAJ.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fAJ, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fAL) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.fAN) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fAJ, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fAR));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.fAN && this.fBG && !this.fAL) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fAJ, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.fAL) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fBt);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fBI, 0L));
                if (!this.fAN) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fBG = this.fAL;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bcz());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fBH));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fBs);
        pbPageRequestMessage.setFromSmartFrs(this.fBv ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fAK);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bbu() {
        switch (bcO()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().aZn() == null || !getPbData().aZn().wt();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bch()) && com.baidu.tieba.recapp.r.bnn().bnh() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bnn().bnh().Q(bch(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bnn().bnh().R(bch(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bch()) && com.baidu.tieba.recapp.r.bnn().bnh() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bnn().bnh().R(bch(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bnn().bnh().Q(bch(), true));
        }
    }

    protected void qG(int i) {
        boolean z = false;
        qK(i);
        ArrayList<PostData> aZp = this.fBa.aZp();
        this.fBo = false;
        if (i == 1) {
            boolean z2 = false;
            while (aZp.size() + 30 > com.baidu.tbadk.data.d.GR()) {
                aZp.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fBa.uw().bO(1);
                if (this.fBg != null) {
                    this.fBg.f(this.fBa);
                }
            }
            this.dDh = System.currentTimeMillis();
            this.fBo = true;
        } else if (i == 2) {
            while (aZp.size() + 30 > com.baidu.tbadk.data.d.GR()) {
                aZp.remove(aZp.size() - 1);
                z = true;
            }
            if (z) {
                this.fBa.uw().bN(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.fBw = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fAI)) {
            try {
                Long valueOf = Long.valueOf(this.fAI);
                com.baidu.tieba.pb.data.l aZy = dVar.aZy();
                if (aZy != null && aZy.ftC != null) {
                    if (aZy.ftC.isEmpty() || !aZy.ftC.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fAH);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            l = null;
                        }
                        if (l != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921313, l));
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

    protected void i(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            if (this.fBe || this.fBc || this.fBd) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.aZp().size(); i++) {
                PostData postData = dVar.aZp().get(i);
                for (int i2 = 0; i2 < postData.bwc().size(); i2++) {
                    postData.bwc().get(i2).b(this.bmZ.getPageContext(), l.equals(postData.bwc().get(i2).vk().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.l aZy = dVar.aZy();
            if (aZy != null && !com.baidu.tbadk.core.util.w.z(aZy.ftB)) {
                for (PostData postData2 : aZy.ftB) {
                    for (int i3 = 0; i3 < postData2.bwc().size(); i3++) {
                        postData2.bwc().get(i3).b(this.bmZ.getPageContext(), l.equals(postData2.bwc().get(i3).vk().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.l aZy = dVar.aZy();
            if (aZy != null && !com.baidu.tbadk.core.util.w.z(aZy.ftB)) {
                for (PostData postData : aZy.ftB.subList(i, aZy.ftB.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bwc().size()) {
                            postData.bwc().get(i3).b(this.bmZ.getPageContext(), l.equals(postData.bwc().get(i3).vk().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.d k(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null) {
            return null;
        }
        bb aZn = dVar.aZn();
        aZn.bW(this.mIsGood);
        aZn.bV(this.fAP);
        if (this.fAQ > 0) {
            aZn.q(this.fAQ);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.aZn() != null && dVar.aZn().vk() != null) {
            str = dVar.aZn().vk().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bcs() {
        if (this.fBa == null || this.fBa.aZn() == null || this.fBa.aZn().vk() == null) {
            return null;
        }
        return this.fBa.aZn().vk();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fBu = z3;
        this.fBb = i;
        if (this.cTx != null && !z3) {
            this.cTx.a(z2, z4, i2, str, i3, j, j2);
            this.cTx = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bch()) && com.baidu.tieba.recapp.r.bnn().bnh() != null) {
            com.baidu.tieba.recapp.r.bnn().bnh().f(bch(), qH(getRequestType()), true);
        }
        if (dVar == null || (this.fAR == 1 && i == 5 && dVar.aZp() != null && dVar.aZp().size() < 1)) {
            if (this.fBg != null) {
                this.fAN = this.fAM;
                this.fBg.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fAM = this.fAN;
            this.fAY = false;
            if (dVar.uw() != null) {
                c(dVar.uw());
            }
            this.cEQ = this.cEQ < 1 ? 1 : this.cEQ;
            ArrayList<PostData> aZp = this.fBa.aZp();
            switch (i) {
                case 1:
                    this.fBa.a(dVar.uw(), 1);
                    e(dVar, aZp);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.aZp() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.aZp().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.w.d(aZp, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.w.d(dVar.aZp(), com.baidu.tbadk.core.util.w.y(dVar.aZp()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.aZp().remove(postData2);
                            i6 = size - 1;
                        }
                        aZp.addAll(0, dVar.aZp());
                    }
                    this.fBa.a(dVar.uw(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.fAN && dVar.uw() != null) {
                        dVar.uw().bL(dVar.uw().un());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && this.fAN) {
                        bct();
                        i5 = 0;
                        break;
                    }
                    i5 = 0;
                    break;
                case 4:
                    m(dVar);
                    i5 = 0;
                    break;
                case 5:
                    m(dVar);
                    i5 = 0;
                    break;
                case 6:
                    m(dVar);
                    i5 = 0;
                    break;
                case 7:
                    m(dVar);
                    i5 = 0;
                    break;
                case 8:
                    if (dVar != null && !com.baidu.tbadk.core.util.w.z(dVar.aZp()) && this.fBa != null && (!this.fAL || l(dVar).equals(dVar.aZp().get(0).vk().getUserId()))) {
                        if (this.fBa.uw().us() == 0) {
                            this.fBa.uw().bN(1);
                        }
                        bcP();
                        this.fBJ = dVar.aZp().get(0);
                        if (this.fAN) {
                            if (this.fBa.aZp().size() - this.fBL >= 3) {
                                this.fBK = new PostData();
                                this.fBK.gOs = true;
                                this.fBK.setPostType(53);
                                this.fBa.aZp().add(this.fBK);
                            }
                            this.fBa.aZp().add(this.fBJ);
                            i4 = this.fBa.aZp().size() - 1;
                        } else {
                            if (this.fBL - this.fBM >= 3) {
                                this.fBK = new PostData();
                                this.fBK.gOs = false;
                                this.fBK.setPostType(53);
                                this.fBa.aZp().add(0, this.fBK);
                            }
                            this.fBa.aZp().add(0, this.fBJ);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ap.U(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fBJ.gOF = this.fBa.aZO();
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
            if (this.fBa != null && this.fBa.aZn() != null) {
                PraiseData uX = this.fBa.aZn().uX();
                if (this.fBR != null && !uX.isPriaseDataValid()) {
                    this.fBa.aZn().a(this.fBR);
                } else {
                    this.fBR = this.fBa.aZn().uX();
                    this.fBR.setPostId(this.fBa.aZn().vB());
                }
                if (dVar.uw() != null && dVar.uw().uq() == 1 && dVar.aZn() != null && dVar.aZn().vw() != null && dVar.aZn().vw().size() > 0) {
                    this.fBa.aZn().l(dVar.aZn().vw());
                }
                this.fBa.aZn().bT(dVar.aZn().vb());
                this.fBa.aZn().bQ(dVar.aZn().getAnchorLevel());
                this.fBa.aZn().bS(dVar.aZn().uT());
                if (this.mThreadType == 33) {
                    this.fBa.aZn().vk().setHadConcerned(dVar.aZn().vk().hadConcerned());
                }
                if (dVar != null && dVar.aZn() != null) {
                    this.fBa.aZn().bY(dVar.aZn().vA());
                }
            }
            if (this.fBa != null && this.fBa.getUserData() != null && dVar.getUserData() != null) {
                this.fBa.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.fBa.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.uw() != null && dVar.uw().uq() == 1 && dVar.aZx() != null) {
                this.fBa.c(dVar.aZx());
            }
            if (this.fBu) {
                if (this.fBa.aZn() != null && this.fBa.aZn().vk() != null && this.fBa.aZp() != null && com.baidu.tbadk.core.util.w.d(this.fBa.aZp(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.w.d(this.fBa.aZp(), 0);
                    MetaData vk = this.fBa.aZn().vk();
                    if (postData3.vk() != null && postData3.vk().getGodUserData() != null) {
                        if (this.fBj != -1) {
                            vk.setFansNum(this.fBj);
                            postData3.vk().setFansNum(this.fBj);
                        }
                        if (this.fBk != -1) {
                            vk.getGodUserData().setIsLike(this.fBk == 1);
                            postData3.vk().getGodUserData().setIsLike(this.fBk == 1);
                            vk.getGodUserData().setIsFromNetWork(false);
                            postData3.vk().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fBa.fsZ = -1;
                this.fBa.fsY = -1;
            }
            if (this.fBg != null) {
                this.fBg.a(true, getErrorCode(), i, i5, this.fBa, this.mErrorString, 1);
            }
        }
        if (this.fBa != null && this.fBa.aZn() != null && this.fBa.aZl() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bmZ;
            historyMessage.threadId = getPbData().aZn().getId();
            if (this.mIsShareThread && getPbData().aZn().ajH != null) {
                historyMessage.threadName = getPbData().aZn().ajH.showText;
            } else {
                historyMessage.threadName = getPbData().aZn().getTitle();
            }
            if (this.mIsShareThread && !bbu()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().aZl().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bcj();
            historyMessage.threadType = getPbData().aZn().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String ap;
        if (arrayList != null && dVar.aZp() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.w.d(dVar.aZp(), 0);
            if (postData != null && (ap = ap(arrayList)) != null && ap.equals(postData.getId())) {
                dVar.aZp().remove(postData);
            }
            arrayList.addAll(dVar.aZp());
        }
    }

    private int qH(int i) {
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

    private String ap(ArrayList<PostData> arrayList) {
        int y = com.baidu.tbadk.core.util.w.y(arrayList);
        if (y <= 0) {
            return null;
        }
        for (int i = y - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.w.d(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.tieba.pb.data.d dVar) {
        dVar.qZ(this.fBa.aZG());
        this.fBa = dVar;
        qE(dVar.uw().uq());
    }

    private void bct() {
        if (this.fBa != null && this.fBa.aZp() != null && this.fBa.aZF() != null) {
            ArrayList<PostData> aZp = this.fBa.aZp();
            com.baidu.tieba.pb.data.a aZF = this.fBa.aZF();
            int aZj = aZF.aZj();
            if (aZj > 0) {
                if (aZj <= aZp.size()) {
                    aZp.add(aZj, aZF);
                } else {
                    aZp.add(aZF);
                }
            }
        }
    }

    public boolean bcu() {
        if (this.fAH == null || this.fAJ == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return qF(4);
        }
        return qF(6);
    }

    public boolean jP(boolean z) {
        if (this.fAH == null || this.fBa == null) {
            return false;
        }
        if (z || this.fBa.uw().us() != 0) {
            return qF(1);
        }
        return false;
    }

    public boolean jQ(boolean z) {
        if (this.fAH == null || this.fBa == null) {
            return false;
        }
        if ((z || this.fBa.uw().ut() != 0) && this.fBa.aZp() != null && this.fBa.aZp().size() >= 1) {
            return qF(2);
        }
        return false;
    }

    public boolean rg(String str) {
        this.fAL = !this.fAL;
        this.fAJ = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (qF(6)) {
            return true;
        }
        this.fAL = this.fAL ? false : true;
        return false;
    }

    public boolean m(boolean z, String str) {
        if (this.fAL == z) {
            return false;
        }
        this.fAL = z;
        this.fAJ = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (qF(6)) {
            return true;
        }
        this.fAL = z ? false : true;
        return false;
    }

    public boolean bcv() {
        this.fAM = this.fAN;
        this.fAN = !this.fAN;
        if (this.isLoading || !LoadData()) {
            this.fAN = this.fAN ? false : true;
            return false;
        }
        return true;
    }

    public boolean bcw() {
        return this.fAN;
    }

    public boolean hasData() {
        return (this.fBa == null || this.fBa.aZl() == null || this.fBa.aZn() == null) ? false : true;
    }

    public boolean rN() {
        if (this.fBa == null) {
            return false;
        }
        return this.fBa.rN();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gH(String str) {
        if (this.fBa == null || this.fBa.aZn() == null || this.fBa.aZl() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fBa.aZn().wt()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fBa.aZl().getId());
            writeData.setForumName(this.fBa.aZl().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.fBH);
        writeData.setThreadId(this.fAH);
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

    public MarkData qI(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fBa == null) {
            return null;
        }
        ArrayList<PostData> aZp = this.fBa.aZp();
        if (com.baidu.tbadk.core.util.w.z(aZp)) {
            return null;
        }
        if (aZp.size() > 0 && i >= aZp.size()) {
            i = aZp.size() - 1;
        }
        return g(aZp.get(i));
    }

    public MarkData bcx() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fAH);
        markData.setPostId(this.fBa.rM());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fAL);
        markData.setSequence(Boolean.valueOf(this.fAN));
        markData.setId(this.fAH);
        return markData;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fAH);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fAL);
        markData.setSequence(Boolean.valueOf(this.fAN));
        markData.setId(this.fAH);
        markData.setFloor(postData.bwf());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bcy() {
        g.bbR().J(bcz(), this.isFromMark);
    }

    private String bcz() {
        String str = this.fAH;
        if (this.fAL) {
            str = str + DB_KEY_HOST;
        }
        if (!this.fAN) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jR(boolean z) {
        if (this.fBa != null) {
            this.fBa.ad(z);
        }
    }

    public void jS(boolean z) {
        this.fBl = z;
    }

    public boolean bcA() {
        return this.fBl;
    }

    public void a(a aVar) {
        this.fBg = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String HO() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean HN() {
        return JR();
    }

    public boolean rh(String str) {
        if (getPbData() == null || getPbData().aZn() == null || getPbData().aZn().vk() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aZn().vk().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bcB() {
        String bcz = bcz();
        g.bbR().J(bcz, false);
        g.bbR().J(bcz, true);
    }

    public void bcC() {
        if ("personalize_page".equals(this.mStType)) {
            this.fBr = System.currentTimeMillis() / 1000;
        }
    }

    public void bcD() {
        if ("personalize_page".equals(this.mStType) && this.fBa != null && this.fBr != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").af(ImageViewerConfig.FORUM_ID, this.fBa.getForumId()).af("tid", this.fAH).af("obj_duration", String.valueOf(currentTimeMillis - this.fBr)).af("obj_param3", String.valueOf(currentTimeMillis)));
            this.fBr = 0L;
        }
    }

    public boolean bcE() {
        return this.fBu;
    }

    public int getErrorNo() {
        return this.fBw;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bcF() {
        return this.fBy;
    }

    public m bcG() {
        return this.fBz;
    }

    public r bcH() {
        return this.fBA;
    }

    public z bcI() {
        return this.fBB;
    }

    public CheckRealNameModel bcJ() {
        return this.ccK;
    }

    public AddExperiencedModel bcK() {
        return this.fBD;
    }

    public String bcL() {
        return this.fBq;
    }

    public void ri(String str) {
        this.fBq = str;
    }

    public boolean bcM() {
        return this.fBv;
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.fBa != null && this.fBa.aZp() != null && this.fBa.aZp().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fBa.aZp().size();
                for (int i = 0; i < size; i++) {
                    if (this.fBa.aZp().get(i) != null && this.fBa.aZp().get(i).vk() != null && currentAccount.equals(this.fBa.aZp().get(i).vk().getUserId()) && this.fBa.aZp().get(i).vk().getPendantData() != null) {
                        this.fBa.aZp().get(i).vk().getPendantData().dj(iVar.tU());
                        this.fBa.aZp().get(i).vk().getPendantData().Z(iVar.GZ());
                    }
                }
            }
        }
    }

    public String bcN() {
        return this.fBC;
    }

    public int bcO() {
        return this.fBH;
    }

    public void qJ(int i) {
        this.fBH = i;
    }

    public void rj(String str) {
        if ((!this.fAL || rh(TbadkCoreApplication.getCurrentAccount())) && this.fBa.aZp() != null) {
            this.fBa.uw().bN(1);
            if (this.fBa.uw().us() == 0) {
                this.fBa.uw().bN(1);
            }
            this.fBI = str;
            qF(8);
        }
    }

    private void qK(int i) {
        if (i != 8) {
            this.fBI = "";
            if (this.fBJ != null) {
                if (i == 1 && !this.fAN && !com.baidu.tbadk.core.util.w.z(getPbData().aZp())) {
                    getPbData().aZp().remove(this.fBJ);
                    if (this.fBK != null) {
                        getPbData().aZp().remove(this.fBK);
                    }
                    getPbData().aZp().add(0, this.fBJ);
                } else {
                    getPbData().aZp().remove(this.fBJ);
                    if (this.fBK != null) {
                        getPbData().aZp().remove(this.fBK);
                    }
                }
            }
            this.fBK = null;
        }
    }

    public void bcP() {
        if (this.fBa != null && !com.baidu.tbadk.core.util.w.z(this.fBa.aZp())) {
            if (this.fBK != null) {
                this.fBa.aZp().remove(this.fBK);
                this.fBK = null;
            }
            if (this.fBJ != null) {
                this.fBa.aZp().remove(this.fBJ);
                this.fBJ = null;
            }
        }
    }

    public void bq(int i, int i2) {
        this.fBL = i;
        this.fBM = i2;
    }

    public PostData bcQ() {
        return this.fBJ;
    }

    public PostData bcR() {
        return this.fBK;
    }

    public int bcS() {
        return this.fBL;
    }

    public String bcT() {
        return this.fBN;
    }

    public void rk(String str) {
        this.fBN = str;
    }
}
