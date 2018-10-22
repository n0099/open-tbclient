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
import com.baidu.tieba.e;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import tbclient.PbPage.PbSortType;
/* loaded from: classes6.dex */
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
    private BaseActivity bwX;
    private int cSX;
    private final CheckRealNameModel cre;
    private long dRR;
    private com.baidu.tieba.tbadkCore.d.b dhz;
    private boolean eXM;
    protected String fPL;
    private String fPM;
    private String fPN;
    private boolean fPO;
    private boolean fPP;
    private boolean fPQ;
    private boolean fPR;
    private int fPS;
    private boolean fPT;
    private int fPU;
    private long fPV;
    private int fPW;
    private int fPX;
    private int fPY;
    private boolean fPZ;
    private boolean fQA;
    private int fQB;
    private final x fQC;
    private final h fQD;
    private final m fQE;
    private final z fQF;
    private String fQG;
    private final AddExperiencedModel fQH;
    private SuggestEmotionModel fQI;
    private GetSugMatchWordsModel fQJ;
    private boolean fQK;
    private int fQL;
    private String fQM;
    private PostData fQN;
    private PostData fQO;
    private int fQP;
    private int fQQ;
    private String fQR;
    private CustomMessageListener fQS;
    private CustomMessageListener fQT;
    private com.baidu.adp.framework.listener.a fQU;
    private PraiseData fQV;
    private boolean fQa;
    private boolean fQb;
    private long fQc;
    private boolean fQd;
    private String fQe;
    protected com.baidu.tieba.pb.data.d fQf;
    private int fQg;
    private boolean fQh;
    private boolean fQi;
    private boolean fQj;
    private boolean fQk;
    private a fQl;
    private String fQm;
    private String fQn;
    private int fQo;
    private int fQp;
    private boolean fQq;
    private boolean fQr;
    private boolean fQs;
    private boolean fQt;
    private boolean fQu;
    private String fQv;
    private long fQw;
    private boolean fQx;
    private int fQy;
    private boolean fQz;
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
    private int mSortType;
    public String mStType;
    protected int mThreadType;
    private String opType;
    private String opUrl;
    private String postID;
    private static final int fPK = com.baidu.tbadk.data.d.Kg() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.d dVar);
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.fPL = null;
        this.fPM = null;
        this.fPN = null;
        this.mForumId = null;
        this.fPO = false;
        this.fPP = false;
        this.fPQ = true;
        this.fPR = true;
        this.mSortType = 0;
        this.fPS = 0;
        this.fPT = false;
        this.mIsGood = 0;
        this.fPU = 0;
        this.fPV = 0L;
        this.fPW = 1;
        this.fPX = 1;
        this.fPY = 1;
        this.cSX = 1;
        this.isAd = false;
        this.eXM = false;
        this.fPZ = false;
        this.fQa = false;
        this.isFromMark = false;
        this.fQb = false;
        this.fQc = 0L;
        this.fQd = false;
        this.fQe = null;
        this.fQf = null;
        this.isLoading = false;
        this.fQh = false;
        this.fQi = false;
        this.fQj = false;
        this.fQk = false;
        this.mLocate = null;
        this.mContext = null;
        this.fQl = null;
        this.opType = null;
        this.opUrl = null;
        this.fQm = null;
        this.fQn = null;
        this.fQo = -1;
        this.fQp = -1;
        this.dhz = null;
        this.fQr = false;
        this.fQs = false;
        this.postID = null;
        this.fQv = null;
        this.fQw = 0L;
        this.fQx = false;
        this.fQy = -1;
        this.fQA = false;
        this.fQK = false;
        this.fQL = 0;
        this.fQS = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.fQu = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.beV() != null) {
                        pbData.beV().cm(0);
                    }
                    if (PbModel.this.fQl != null && pbData != null) {
                        com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fQl.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fQT = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().beT() != null && PbModel.this.getPbData().beT().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().beT().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fQU = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.kX()) {
                        PbModel.this.bwX.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.fQr || !PbModel.this.fQs) {
                        if (!PbModel.this.fQr) {
                            PbModel.this.fQr = true;
                        } else {
                            PbModel.this.fQs = true;
                        }
                        if (PbModel.this.fQl != null) {
                            PbModel.this.fQl.a(PbModel.this.bhN(), z, responsedMessage, PbModel.this.fQt, System.currentTimeMillis() - PbModel.this.dRR);
                        }
                    }
                }
            }
        };
        this.fQV = null;
        registerListener(this.fQS);
        registerListener(this.fQU);
        registerListener(this.fQT);
        this.fQf = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bwX = baseActivity;
        this.fQC = new x(this, this.bwX);
        this.fQD = new h(this, this.bwX);
        this.fQE = new m(this, this.bwX);
        this.fQF = new z(this, this.bwX);
        this.cre = new CheckRealNameModel(this.bwX.getPageContext());
        this.fQI = new SuggestEmotionModel();
        this.fQH = new AddExperiencedModel(this.bwX.getPageContext());
    }

    protected int bhN() {
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
        this.fPL = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fPL)) {
            this.fPL = this.fQC.Y(intent);
            if (StringUtils.isNull(this.fPL) && intent.getData() != null) {
                this.fPL = intent.getData().getQueryParameter("thread_id");
            }
        }
        this.fQL = intent.getIntExtra("key_start_from", 0);
        if (this.fQL == 0) {
            this.fQL = this.fQC.fRb;
        }
        this.fPN = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.mFromForumId = intent.getStringExtra("from_forum_id");
        this.fPM = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fPO = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fPP = intent.getBooleanExtra("host_only", false);
        this.fPR = intent.getBooleanExtra("squence", true);
        this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.Os().EQ() ? 2 : 0);
        if (this.mSortType == 2) {
            this.fPN = "0";
        }
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fPU = intent.getIntExtra("is_top", 0);
        this.fPV = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fQb = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eXM = intent.getBooleanExtra("is_sub_pb", false);
        this.fQd = intent.getBooleanExtra("is_pv", false);
        this.fQc = intent.getLongExtra("msg_id", 0L);
        this.fQe = intent.getStringExtra("from_forum_name");
        this.fQn = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fQm = intent.getStringExtra("op_stat");
        this.fQh = intent.getBooleanExtra("is_from_thread_config", false);
        this.fQi = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fQj = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fQp = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fQo = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fPZ = intent.getBooleanExtra("from_frs", false);
        this.fQa = intent.getBooleanExtra("from_maintab", false);
        this.fQA = intent.getBooleanExtra("from_smart_frs", false);
        this.fQk = intent.getBooleanExtra("from_hottopic", false);
        this.fQG = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fQL = bundle.getInt("key_start_from", 0);
        this.fPL = bundle.getString("thread_id");
        this.fPN = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.fPM = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fPO = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fPP = bundle.getBoolean("host_only", false);
        this.fPR = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fPU = bundle.getInt("is_top", 0);
        this.fPV = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fQb = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eXM = bundle.getBoolean("is_sub_pb", false);
        this.fQd = bundle.getBoolean("is_pv", false);
        this.fQc = bundle.getLong("msg_id", 0L);
        this.fQe = bundle.getString("from_forum_name");
        this.fQn = bundle.getString("extra_pb_cache_key");
        this.fQh = bundle.getBoolean("is_from_thread_config", false);
        this.fQi = bundle.getBoolean("is_from_interview_live_config", false);
        this.fQj = bundle.getBoolean("is_from_my_god_config", false);
        this.fQp = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fQo = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fPZ = bundle.getBoolean("from_frs", false);
        this.fQa = bundle.getBoolean("from_maintab", false);
        this.fQA = bundle.getBoolean("from_smart_frs", false);
        this.fQk = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void A(Bundle bundle) {
        bundle.putString("thread_id", this.fPL);
        bundle.putString("post_id", this.fPN);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.fQL);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fPO);
        bundle.putBoolean("host_only", this.fPP);
        bundle.putBoolean("squence", this.fPR);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fPU);
        bundle.putLong("thread_time", this.fPV);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fQb);
        bundle.putBoolean("is_sub_pb", this.eXM);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fQd);
        bundle.putLong("msg_id", this.fQc);
        bundle.putString("extra_pb_cache_key", this.fQn);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fQh);
        bundle.putBoolean("is_from_interview_live_config", this.fQi);
        bundle.putBoolean("is_from_my_god_config", this.fQj);
        bundle.putInt("extra_pb_is_attention_key", this.fQp);
        bundle.putInt("extra_pb_funs_count_key", this.fQo);
        bundle.putBoolean("from_frs", this.fPZ);
        bundle.putBoolean("from_maintab", this.fQa);
        bundle.putBoolean("from_smart_frs", this.fQA);
        bundle.putBoolean("from_hottopic", this.fQk);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bhO() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fPL);
        if (!this.fQb) {
            sb.append(this.fPN);
        }
        sb.append(this.fPP);
        sb.append(this.fPR);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fPU);
        sb.append(this.fPV);
        sb.append(this.fPZ);
        sb.append(this.fQa);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eXM);
        sb.append(this.fQd);
        sb.append(this.fQc);
        sb.append(this.fQe);
        sb.append(this.mThreadType);
        sb.append(this.fQh);
        sb.append(this.fQi);
        sb.append(this.fQj);
        if (this.fQn != null) {
            sb.append(this.fQn);
        }
        return sb.toString();
    }

    public String bfR() {
        return this.fQe;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.fPN;
    }

    public String bhP() {
        return this.fPL;
    }

    public boolean getHostMode() {
        return this.fPP;
    }

    public boolean bhQ() {
        return biA();
    }

    public int aaJ() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bhR() {
        return this.fPZ;
    }

    public boolean bhS() {
        return this.fPT;
    }

    public boolean bhT() {
        return this.fQa;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bhU() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bhV() {
        return this.fPU;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void kf(int i) {
        this.fPU = i;
    }

    public boolean bhW() {
        return this.eXM;
    }

    public boolean bhX() {
        if (this.fQf == null) {
            return false;
        }
        return this.fQf.isValid();
    }

    public String yF() {
        if (this.fQf == null || !this.fQf.vc()) {
            return null;
        }
        return this.fQf.vb();
    }

    public boolean rA(int i) {
        this.fPW = i;
        if (this.fPW > this.fQf.xH().xy()) {
            this.fPW = this.fQf.xH().xy();
        }
        if (this.fPW < 1) {
            this.fPW = 1;
        }
        if (this.fPL == null) {
            return false;
        }
        return rC(5);
    }

    public void rB(int i) {
        this.fPW = i;
        this.fPX = i;
        this.fPY = i;
    }

    public void c(com.baidu.tbadk.core.data.al alVar) {
        if (alVar == null) {
            rB(1);
            return;
        }
        if (this.fPX < alVar.xB()) {
            this.fPX = alVar.xB();
        }
        if (this.fPY > alVar.xB()) {
            this.fPY = alVar.xB();
        }
        this.cSX = alVar.xy();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.fQf;
    }

    public com.baidu.tbadk.core.data.al getPageData() {
        if (this.fQf == null) {
            return null;
        }
        return this.fQf.xH();
    }

    public boolean bhY() {
        if (biA() && this.fQf.xH().xD() == 0) {
            kG(true);
            return true;
        }
        return false;
    }

    public void sl(String str) {
        if (!StringUtils.isNull(str)) {
            this.fPL = str;
            this.fPN = null;
            this.fPP = false;
            this.fPR = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fPL == null) {
            return false;
        }
        cancelLoadData();
        if (this.dhz == null) {
            this.dhz = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.dhz.start();
        }
        boolean rC = rC(3);
        if (this.opType != null) {
            this.opType = null;
            this.fQm = null;
            this.opUrl = null;
            return rC;
        }
        return rC;
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
        if (this.fQI != null) {
            this.fQI.cancelLoadData();
        }
        if (this.fQJ != null) {
            this.fQJ.cancelLoadData();
        }
        aut();
    }

    private void aut() {
        if (this.dhz != null) {
            this.dhz.destory();
            this.dhz = null;
        }
    }

    public boolean Nj() {
        return (this.fPN == null || this.fPN.equals("0") || this.fPN.length() == 0) ? LoadData() : bib();
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
                this.fQI.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fQI.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fQJ == null) {
                this.fQJ = new GetSugMatchWordsModel(this.bwX.getPageContext());
            }
            this.fQJ.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x02ea A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ee A[Catch: Exception -> 0x0220, TryCatch #0 {Exception -> 0x0220, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:42:0x0129, B:44:0x0146, B:45:0x014e, B:47:0x015b, B:48:0x0163, B:50:0x0167, B:51:0x016c, B:53:0x0170, B:54:0x0175, B:56:0x0179, B:57:0x0189, B:59:0x018d, B:60:0x0195, B:62:0x0199, B:63:0x01b2, B:64:0x01c1, B:65:0x01c4, B:68:0x01f0, B:70:0x0203, B:75:0x022a, B:77:0x0240, B:79:0x0246, B:81:0x024d, B:82:0x025a, B:84:0x026e, B:86:0x0274, B:88:0x027a, B:97:0x02aa, B:99:0x02b0, B:89:0x0285, B:91:0x0289, B:93:0x0291, B:95:0x02a0, B:96:0x02a5, B:100:0x02bc, B:102:0x02d0, B:104:0x02d4, B:107:0x02e6, B:136:0x035e, B:111:0x02ee, B:113:0x02f4, B:114:0x02f9, B:116:0x02fd, B:118:0x0307, B:123:0x031e, B:125:0x032c, B:126:0x032f, B:128:0x0333, B:129:0x033e, B:131:0x0342, B:133:0x034a, B:135:0x0359, B:137:0x0363, B:139:0x0367, B:120:0x030b, B:140:0x0370, B:141:0x039e, B:143:0x03a2, B:153:0x03d3, B:146:0x03ae, B:148:0x03bc, B:149:0x03c4, B:151:0x03c8, B:152:0x03ce, B:154:0x03dc, B:145:0x03a6, B:155:0x03e5, B:157:0x03f1, B:159:0x03f5, B:161:0x03f9, B:162:0x03fe, B:164:0x040a, B:165:0x0412, B:169:0x042c, B:166:0x0417, B:168:0x0426, B:170:0x0435, B:172:0x0444, B:36:0x00c8), top: B:176:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02fd A[Catch: Exception -> 0x0220, TryCatch #0 {Exception -> 0x0220, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:42:0x0129, B:44:0x0146, B:45:0x014e, B:47:0x015b, B:48:0x0163, B:50:0x0167, B:51:0x016c, B:53:0x0170, B:54:0x0175, B:56:0x0179, B:57:0x0189, B:59:0x018d, B:60:0x0195, B:62:0x0199, B:63:0x01b2, B:64:0x01c1, B:65:0x01c4, B:68:0x01f0, B:70:0x0203, B:75:0x022a, B:77:0x0240, B:79:0x0246, B:81:0x024d, B:82:0x025a, B:84:0x026e, B:86:0x0274, B:88:0x027a, B:97:0x02aa, B:99:0x02b0, B:89:0x0285, B:91:0x0289, B:93:0x0291, B:95:0x02a0, B:96:0x02a5, B:100:0x02bc, B:102:0x02d0, B:104:0x02d4, B:107:0x02e6, B:136:0x035e, B:111:0x02ee, B:113:0x02f4, B:114:0x02f9, B:116:0x02fd, B:118:0x0307, B:123:0x031e, B:125:0x032c, B:126:0x032f, B:128:0x0333, B:129:0x033e, B:131:0x0342, B:133:0x034a, B:135:0x0359, B:137:0x0363, B:139:0x0367, B:120:0x030b, B:140:0x0370, B:141:0x039e, B:143:0x03a2, B:153:0x03d3, B:146:0x03ae, B:148:0x03bc, B:149:0x03c4, B:151:0x03c8, B:152:0x03ce, B:154:0x03dc, B:145:0x03a6, B:155:0x03e5, B:157:0x03f1, B:159:0x03f5, B:161:0x03f9, B:162:0x03fe, B:164:0x040a, B:165:0x0412, B:169:0x042c, B:166:0x0417, B:168:0x0426, B:170:0x0435, B:172:0x0444, B:36:0x00c8), top: B:176:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0333 A[Catch: Exception -> 0x0220, TryCatch #0 {Exception -> 0x0220, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:42:0x0129, B:44:0x0146, B:45:0x014e, B:47:0x015b, B:48:0x0163, B:50:0x0167, B:51:0x016c, B:53:0x0170, B:54:0x0175, B:56:0x0179, B:57:0x0189, B:59:0x018d, B:60:0x0195, B:62:0x0199, B:63:0x01b2, B:64:0x01c1, B:65:0x01c4, B:68:0x01f0, B:70:0x0203, B:75:0x022a, B:77:0x0240, B:79:0x0246, B:81:0x024d, B:82:0x025a, B:84:0x026e, B:86:0x0274, B:88:0x027a, B:97:0x02aa, B:99:0x02b0, B:89:0x0285, B:91:0x0289, B:93:0x0291, B:95:0x02a0, B:96:0x02a5, B:100:0x02bc, B:102:0x02d0, B:104:0x02d4, B:107:0x02e6, B:136:0x035e, B:111:0x02ee, B:113:0x02f4, B:114:0x02f9, B:116:0x02fd, B:118:0x0307, B:123:0x031e, B:125:0x032c, B:126:0x032f, B:128:0x0333, B:129:0x033e, B:131:0x0342, B:133:0x034a, B:135:0x0359, B:137:0x0363, B:139:0x0367, B:120:0x030b, B:140:0x0370, B:141:0x039e, B:143:0x03a2, B:153:0x03d3, B:146:0x03ae, B:148:0x03bc, B:149:0x03c4, B:151:0x03c8, B:152:0x03ce, B:154:0x03dc, B:145:0x03a6, B:155:0x03e5, B:157:0x03f1, B:159:0x03f5, B:161:0x03f9, B:162:0x03fe, B:164:0x040a, B:165:0x0412, B:169:0x042c, B:166:0x0417, B:168:0x0426, B:170:0x0435, B:172:0x0444, B:36:0x00c8), top: B:176:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0342 A[Catch: Exception -> 0x0220, TryCatch #0 {Exception -> 0x0220, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:42:0x0129, B:44:0x0146, B:45:0x014e, B:47:0x015b, B:48:0x0163, B:50:0x0167, B:51:0x016c, B:53:0x0170, B:54:0x0175, B:56:0x0179, B:57:0x0189, B:59:0x018d, B:60:0x0195, B:62:0x0199, B:63:0x01b2, B:64:0x01c1, B:65:0x01c4, B:68:0x01f0, B:70:0x0203, B:75:0x022a, B:77:0x0240, B:79:0x0246, B:81:0x024d, B:82:0x025a, B:84:0x026e, B:86:0x0274, B:88:0x027a, B:97:0x02aa, B:99:0x02b0, B:89:0x0285, B:91:0x0289, B:93:0x0291, B:95:0x02a0, B:96:0x02a5, B:100:0x02bc, B:102:0x02d0, B:104:0x02d4, B:107:0x02e6, B:136:0x035e, B:111:0x02ee, B:113:0x02f4, B:114:0x02f9, B:116:0x02fd, B:118:0x0307, B:123:0x031e, B:125:0x032c, B:126:0x032f, B:128:0x0333, B:129:0x033e, B:131:0x0342, B:133:0x034a, B:135:0x0359, B:137:0x0363, B:139:0x0367, B:120:0x030b, B:140:0x0370, B:141:0x039e, B:143:0x03a2, B:153:0x03d3, B:146:0x03ae, B:148:0x03bc, B:149:0x03c4, B:151:0x03c8, B:152:0x03ce, B:154:0x03dc, B:145:0x03a6, B:155:0x03e5, B:157:0x03f1, B:159:0x03f5, B:161:0x03f9, B:162:0x03fe, B:164:0x040a, B:165:0x0412, B:169:0x042c, B:166:0x0417, B:168:0x0426, B:170:0x0435, B:172:0x0444, B:36:0x00c8), top: B:176:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0367 A[Catch: Exception -> 0x0220, TryCatch #0 {Exception -> 0x0220, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:42:0x0129, B:44:0x0146, B:45:0x014e, B:47:0x015b, B:48:0x0163, B:50:0x0167, B:51:0x016c, B:53:0x0170, B:54:0x0175, B:56:0x0179, B:57:0x0189, B:59:0x018d, B:60:0x0195, B:62:0x0199, B:63:0x01b2, B:64:0x01c1, B:65:0x01c4, B:68:0x01f0, B:70:0x0203, B:75:0x022a, B:77:0x0240, B:79:0x0246, B:81:0x024d, B:82:0x025a, B:84:0x026e, B:86:0x0274, B:88:0x027a, B:97:0x02aa, B:99:0x02b0, B:89:0x0285, B:91:0x0289, B:93:0x0291, B:95:0x02a0, B:96:0x02a5, B:100:0x02bc, B:102:0x02d0, B:104:0x02d4, B:107:0x02e6, B:136:0x035e, B:111:0x02ee, B:113:0x02f4, B:114:0x02f9, B:116:0x02fd, B:118:0x0307, B:123:0x031e, B:125:0x032c, B:126:0x032f, B:128:0x0333, B:129:0x033e, B:131:0x0342, B:133:0x034a, B:135:0x0359, B:137:0x0363, B:139:0x0367, B:120:0x030b, B:140:0x0370, B:141:0x039e, B:143:0x03a2, B:153:0x03d3, B:146:0x03ae, B:148:0x03bc, B:149:0x03c4, B:151:0x03c8, B:152:0x03ce, B:154:0x03dc, B:145:0x03a6, B:155:0x03e5, B:157:0x03f1, B:159:0x03f5, B:161:0x03f9, B:162:0x03fe, B:164:0x040a, B:165:0x0412, B:169:0x042c, B:166:0x0417, B:168:0x0426, B:170:0x0435, B:172:0x0444, B:36:0x00c8), top: B:176:0x00bc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean rC(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        rD(i);
        final com.baidu.tieba.pb.data.d pbData = aj.biX().getPbData();
        if (pbData != null && pbData.beV() != null) {
            pbData.beV().cm(0);
            this.fPR = aj.biX().bhQ();
            this.fPP = aj.biX().bjc();
            this.fPT = aj.biX().bjd();
            this.fQN = aj.biX().bjb();
            this.fQO = aj.biX().bja();
            this.fQP = aj.biX().biZ();
            this.fQK = this.fPP;
            if (this.fPP || this.isFromMark) {
                this.fQq = false;
            }
            com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.fQu) {
            a(big(), true, this.fPN, 3);
        }
        if (i == 3 && !this.fQu) {
            if (this.isFromMark) {
                a(big(), true, this.fPN, 3);
            } else {
                a(big(), false, this.fPN, 3);
            }
        }
        this.fQu = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aTh);
        if (this.fPP || this.isFromMark) {
            this.fQq = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fPL == null || this.fPL.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.fPL, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.aq.CG().CI() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(aO));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aQ));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.fPR) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.fPP) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fQd) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fQc));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fQq) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.l(this.fQm, 0));
            pbPageRequestMessage.setOpMessageID(this.fQc);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> beX = this.fQf.beX();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fPY - 1));
                        if (this.fPY - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z) {
                                if (beX != null && beX.size() > 0) {
                                    size = beX.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = beX.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.fPN = postData.getId();
                                            if (StringUtils.isNull(this.fPN)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.fPX + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.fPN == null && this.fPN.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fPN, 0L));
                                    if (this.mSortType == 2) {
                                        pbPageRequestMessage.set_pid(0L);
                                    }
                                } else if (this.mSortType == 1) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            b(pbPageRequestMessage);
                            break;
                        }
                    } else {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fPX + 1));
                        if (this.fPX >= this.cSX) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (beX != null) {
                                size = beX.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.fPN == null) {
                            }
                            if (this.mSortType == 1) {
                            }
                            b(pbPageRequestMessage);
                        }
                    }
                }
                z = false;
                if (!this.isFromMark) {
                }
                if (beX != null) {
                }
                if (this.fPN == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (beX != null && beX.size() > 0 && beX.get(0) != null) {
                    this.fPN = beX.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (biA()) {
                        if (this.fPY - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fPY - 1));
                        }
                    } else if (this.fPX < this.cSX) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fPX + 1));
                    }
                }
                if (this.fPN != null && this.fPN.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fPN, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fPP) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (biA()) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fPN, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fPW));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.fQK && !this.fPP) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fPN, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.fPP) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fQy);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fQM, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fQK = this.fPP;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(big());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fQL));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fQx);
        pbPageRequestMessage.setFromSmartFrs(this.fQA ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fPO);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bfQ() {
        switch (biu()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().beV() == null || !getPbData().beV().zG();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bfR()) && com.baidu.tieba.recapp.r.btk().bte() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.btk().bte().Y(bfR(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.btk().bte().Z(bfR(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bfR()) && com.baidu.tieba.recapp.r.btk().bte() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.btk().bte().Z(bfR(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.btk().bte().Y(bfR(), true));
        }
    }

    protected void rD(int i) {
        boolean z = false;
        rI(i);
        ArrayList<PostData> beX = this.fQf.beX();
        this.fQt = false;
        if (i == 1) {
            boolean z2 = false;
            while (beX.size() + 30 > com.baidu.tbadk.data.d.Kg()) {
                beX.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fQf.xH().ci(1);
                if (this.fQl != null) {
                    this.fQl.f(this.fQf);
                }
            }
            this.dRR = System.currentTimeMillis();
            this.fQt = true;
        } else if (i == 2) {
            while (beX.size() + 30 > com.baidu.tbadk.data.d.Kg()) {
                beX.remove(beX.size() - 1);
                z = true;
            }
            if (z) {
                this.fQf.xH().ch(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.fQB = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fPM)) {
            try {
                Long valueOf = Long.valueOf(this.fPM);
                com.baidu.tieba.pb.data.k bfg = dVar.bfg();
                if (bfg != null && bfg.fIH != null) {
                    if (bfg.fIH.isEmpty() || !bfg.fIH.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fPL);
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
            if (this.fQj || this.fQh || this.fQi) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.beX().size(); i++) {
                PostData postData = dVar.beX().get(i);
                for (int i2 = 0; i2 < postData.bBY().size(); i2++) {
                    postData.bBY().get(i2).a(this.bwX.getPageContext(), l.equals(postData.bBY().get(i2).yv().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.k bfg = dVar.bfg();
            if (bfg != null && !com.baidu.tbadk.core.util.v.J(bfg.fIG)) {
                for (PostData postData2 : bfg.fIG) {
                    for (int i3 = 0; i3 < postData2.bBY().size(); i3++) {
                        postData2.bBY().get(i3).a(this.bwX.getPageContext(), l.equals(postData2.bBY().get(i3).yv().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.k bfg = dVar.bfg();
            if (bfg != null && !com.baidu.tbadk.core.util.v.J(bfg.fIG)) {
                for (PostData postData : bfg.fIG.subList(i, bfg.fIG.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bBY().size()) {
                            postData.bBY().get(i3).a(this.bwX.getPageContext(), l.equals(postData.bBY().get(i3).yv().getUserId()));
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
        bb beV = dVar.beV();
        beV.cq(this.mIsGood);
        beV.cp(this.fPU);
        if (this.fPV > 0) {
            beV.u(this.fPV);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.beV() != null && dVar.beV().yv() != null) {
            str = dVar.beV().yv().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bhZ() {
        if (this.fQf == null || this.fQf.beV() == null || this.fQf.beV().yv() == null) {
            return null;
        }
        return this.fQf.beV().yv();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fQz = z3;
        this.fQg = i;
        if (this.dhz != null && !z3) {
            this.dhz.a(z2, z4, i2, str, i3, j, j2);
            this.dhz = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bfR()) && com.baidu.tieba.recapp.r.btk().bte() != null) {
            com.baidu.tieba.recapp.r.btk().bte().f(bfR(), rE(getRequestType()), true);
        }
        if (dVar == null || (this.fPW == 1 && i == 5 && dVar.beX() != null && dVar.beX().size() < 1)) {
            if (this.fQl != null) {
                this.fPR = this.fPQ;
                this.mSortType = this.fPS;
                this.fQl.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fPQ = this.fPR;
            if (i != 8) {
                this.fPS = this.mSortType;
                this.mSortType = dVar.fIh;
            }
            if (dVar.fIg != null && dVar.fIg.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.bwX.getResources().getString(e.j.default_sort);
                builder.sort_type = 0;
                dVar.fIg = new ArrayList();
                dVar.fIg.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.bwX.getResources().getString(e.j.view_reverse);
                builder2.sort_type = 1;
                dVar.fIg.add(builder2.build(false));
                this.mSortType = this.fPS;
                dVar.fIh = this.mSortType;
            }
            this.fQd = false;
            if (dVar.xH() != null && (this.mSortType != 2 || i != 8)) {
                c(dVar.xH());
            }
            this.cSX = this.cSX < 1 ? 1 : this.cSX;
            ArrayList<PostData> beX = this.fQf.beX();
            switch (i) {
                case 1:
                    this.fQf.a(dVar.xH(), 1);
                    d(dVar, beX);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.beX() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.beX().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(beX, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.d(dVar.beX(), com.baidu.tbadk.core.util.v.I(dVar.beX()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.beX().remove(postData2);
                            i6 = size - 1;
                        }
                        beX.addAll(0, dVar.beX());
                    }
                    this.fQf.a(dVar.xH(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.xH() != null) {
                        dVar.xH().cf(dVar.xH().xy());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && biA()) {
                        bia();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.J(dVar.beX()) && this.fQf != null && (!this.fPP || l(dVar).equals(dVar.beX().get(0).yv().getUserId()))) {
                        if (this.fQf.xH().xD() == 0) {
                            this.fQf.xH().ch(1);
                        }
                        biv();
                        this.fQN = dVar.beX().get(0);
                        if (biA()) {
                            if (this.fQf.beX().size() - this.fQP >= 3) {
                                this.fQO = new PostData();
                                this.fQO.hdv = true;
                                this.fQO.setPostType(53);
                                this.fQf.beX().add(this.fQO);
                            }
                            this.fQf.beX().add(this.fQN);
                            i4 = this.fQf.beX().size() - 1;
                        } else {
                            if (this.fQP - this.fQQ >= 3) {
                                this.fQO = new PostData();
                                this.fQO.hdv = false;
                                this.fQO.setPostType(53);
                                this.fQf.beX().add(0, this.fQO);
                            }
                            this.fQf.beX().add(0, this.fQN);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ao.aa(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fQN.hdH = this.fQf.bfw();
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
            if (this.fQf != null && this.fQf.beV() != null) {
                PraiseData yi = this.fQf.beV().yi();
                if (this.fQV != null && !yi.isPriaseDataValid()) {
                    this.fQf.beV().a(this.fQV);
                } else {
                    this.fQV = this.fQf.beV().yi();
                    this.fQV.setPostId(this.fQf.beV().yM());
                }
                if (dVar.xH() != null && dVar.xH().xB() == 1 && dVar.beV() != null && dVar.beV().yH() != null && dVar.beV().yH().size() > 0) {
                    this.fQf.beV().l(dVar.beV().yH());
                }
                this.fQf.beV().cn(dVar.beV().ym());
                this.fQf.beV().ck(dVar.beV().getAnchorLevel());
                this.fQf.beV().cm(dVar.beV().ye());
                if (this.mThreadType == 33) {
                    this.fQf.beV().yv().setHadConcerned(dVar.beV().yv().hadConcerned());
                }
                if (dVar != null && dVar.beV() != null) {
                    this.fQf.beV().cs(dVar.beV().yL());
                }
            }
            if (this.fQf != null && this.fQf.getUserData() != null && dVar.getUserData() != null) {
                this.fQf.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.fQf.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.xH() != null && dVar.xH().xB() == 1 && dVar.bff() != null) {
                this.fQf.d(dVar.bff());
            }
            if (this.fQz) {
                if (this.fQf.beV() != null && this.fQf.beV().yv() != null && this.fQf.beX() != null && com.baidu.tbadk.core.util.v.d(this.fQf.beX(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.d(this.fQf.beX(), 0);
                    MetaData yv = this.fQf.beV().yv();
                    if (postData3.yv() != null && postData3.yv().getGodUserData() != null) {
                        if (this.fQo != -1) {
                            yv.setFansNum(this.fQo);
                            postData3.yv().setFansNum(this.fQo);
                        }
                        if (this.fQp != -1) {
                            yv.getGodUserData().setIsLike(this.fQp == 1);
                            postData3.yv().getGodUserData().setIsLike(this.fQp == 1);
                            yv.getGodUserData().setIsFromNetWork(false);
                            postData3.yv().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fQf.fIf = -1;
                this.fQf.fIe = -1;
            }
            if (this.fQl != null) {
                this.fQl.a(true, getErrorCode(), i, i5, this.fQf, this.mErrorString, 1);
            }
        }
        if (this.fQf != null && this.fQf.beV() != null && this.fQf.beT() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bwX;
            historyMessage.threadId = getPbData().beV().getId();
            if (this.mIsShareThread && getPbData().beV().arg != null) {
                historyMessage.threadName = getPbData().beV().arg.showText;
            } else {
                historyMessage.threadName = getPbData().beV().getTitle();
            }
            if (this.mIsShareThread && !bfQ()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().beT().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bhQ();
            historyMessage.threadType = getPbData().beV().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String ap;
        if (arrayList != null && dVar.beX() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(dVar.beX(), 0);
            if (postData != null && (ap = ap(arrayList)) != null && ap.equals(postData.getId())) {
                dVar.beX().remove(postData);
            }
            arrayList.addAll(dVar.beX());
        }
    }

    private int rE(int i) {
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
        int I = com.baidu.tbadk.core.util.v.I(arrayList);
        if (I <= 0) {
            return null;
        }
        for (int i = I - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.tieba.pb.data.d dVar) {
        dVar.si(this.fQf.bfo());
        this.fQf = dVar;
        rB(dVar.xH().xB());
    }

    private void bia() {
        if (this.fQf != null && this.fQf.beX() != null && this.fQf.bfn() != null) {
            ArrayList<PostData> beX = this.fQf.beX();
            com.baidu.tieba.pb.data.a bfn = this.fQf.bfn();
            int beR = bfn.beR();
            if (beR > 0) {
                if (beR <= beX.size()) {
                    beX.add(beR, bfn);
                } else {
                    beX.add(bfn);
                }
            }
        }
    }

    public boolean bib() {
        if (this.fPL == null || this.fPN == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return rC(4);
        }
        return rC(6);
    }

    public boolean kG(boolean z) {
        if (this.fPL == null || this.fQf == null) {
            return false;
        }
        if (z || this.fQf.xH().xD() != 0) {
            return rC(1);
        }
        return false;
    }

    public boolean kH(boolean z) {
        if (this.fPL == null || this.fQf == null) {
            return false;
        }
        if ((z || this.fQf.xH().xE() != 0) && this.fQf.beX() != null && this.fQf.beX().size() >= 1) {
            return rC(2);
        }
        return false;
    }

    public boolean sq(String str) {
        this.fPP = !this.fPP;
        this.fPN = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (rC(6)) {
            return true;
        }
        this.fPP = this.fPP ? false : true;
        return false;
    }

    public boolean q(boolean z, String str) {
        if (this.fPP == z) {
            return false;
        }
        this.fPP = z;
        this.fPN = str;
        if (this.mSortType == 2) {
            this.fPN = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (rC(6)) {
            return true;
        }
        this.fPP = z ? false : true;
        return false;
    }

    public boolean rF(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.fPQ = this.fPR;
        this.fPS = this.mSortType;
        this.mSortType = i;
        this.fPR = !this.fPR;
        if (i == 2 && this.isFromMark) {
            this.fPN = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.fPR = this.fPR ? false : true;
            this.mSortType = this.fPS;
            return false;
        }
        return true;
    }

    public boolean bic() {
        return biA();
    }

    public int bid() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.fQf == null || this.fQf.beT() == null || this.fQf.beV() == null) ? false : true;
    }

    public boolean vc() {
        if (this.fQf == null) {
            return false;
        }
        return this.fQf.vc();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hr(String str) {
        if (this.fQf == null || this.fQf.beV() == null || this.fQf.beT() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fQf.beV().zG()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fQf.beT().getId());
            writeData.setForumName(this.fQf.beT().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.fQL);
        writeData.setThreadId(this.fPL);
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

    public MarkData rG(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fQf == null) {
            return null;
        }
        ArrayList<PostData> beX = this.fQf.beX();
        if (com.baidu.tbadk.core.util.v.J(beX)) {
            return null;
        }
        if (beX.size() > 0 && i >= beX.size()) {
            i = beX.size() - 1;
        }
        return h(beX.get(i));
    }

    public MarkData bie() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fPL);
        markData.setPostId(this.fQf.vb());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fPP);
        markData.setSequence(Boolean.valueOf(biA()));
        markData.setId(this.fPL);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fPL);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fPP);
        markData.setSequence(Boolean.valueOf(biA()));
        markData.setId(this.fPL);
        markData.setFloor(postData.bCb());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bif() {
        g.bhz().R(big(), this.isFromMark);
    }

    private String big() {
        String str = this.fPL;
        if (this.fPP) {
            str = str + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void kI(boolean z) {
        if (this.fQf != null) {
            this.fQf.ay(z);
        }
    }

    public void kJ(boolean z) {
        this.fQq = z;
    }

    public boolean bih() {
        return this.fQq;
    }

    public void a(a aVar) {
        this.fQl = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lc() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Lb() {
        return Nj();
    }

    public boolean ss(String str) {
        if (getPbData() == null || getPbData().beV() == null || getPbData().beV().yv() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().beV().yv().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bii() {
        String big = big();
        g.bhz().R(big, false);
        g.bhz().R(big, true);
    }

    public void bij() {
        if ("personalize_page".equals(this.mStType)) {
            this.fQw = System.currentTimeMillis() / 1000;
        }
    }

    public void bik() {
        if ("personalize_page".equals(this.mStType) && this.fQf != null && this.fQw != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10754").ax(ImageViewerConfig.FORUM_ID, this.fQf.getForumId()).ax("tid", this.fPL).ax("obj_duration", String.valueOf(currentTimeMillis - this.fQw)).ax("obj_param3", String.valueOf(currentTimeMillis)));
            this.fQw = 0L;
        }
    }

    public boolean bil() {
        return this.fQz;
    }

    public int getErrorNo() {
        return this.fQB;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bim() {
        return this.fQD;
    }

    public m bin() {
        return this.fQE;
    }

    public z bio() {
        return this.fQF;
    }

    public CheckRealNameModel bip() {
        return this.cre;
    }

    public AddExperiencedModel biq() {
        return this.fQH;
    }

    public String bir() {
        return this.fQv;
    }

    public void st(String str) {
        this.fQv = str;
    }

    public boolean bis() {
        return this.fQA;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.fQf != null && this.fQf.beX() != null && this.fQf.beX().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fQf.beX().size();
                for (int i = 0; i < size; i++) {
                    if (this.fQf.beX().get(i) != null && this.fQf.beX().get(i).yv() != null && currentAccount.equals(this.fQf.beX().get(i).yv().getUserId()) && this.fQf.beX().get(i).yv().getPendantData() != null) {
                        this.fQf.beX().get(i).yv().getPendantData().dR(jVar.xf());
                        this.fQf.beX().get(i).yv().getPendantData().af(jVar.Ko());
                    }
                }
            }
        }
    }

    public String bit() {
        return this.fQG;
    }

    public int biu() {
        return this.fQL;
    }

    public void rH(int i) {
        this.fQL = i;
    }

    public void su(String str) {
        if ((!this.fPP || ss(TbadkCoreApplication.getCurrentAccount())) && this.fQf.beX() != null) {
            this.fQf.xH().ch(1);
            if (this.fQf.xH().xD() == 0) {
                this.fQf.xH().ch(1);
            }
            this.fQM = str;
            rC(8);
        }
    }

    private void rI(int i) {
        if (i != 8) {
            this.fQM = "";
            if (this.fQN != null) {
                if (i == 1 && !this.fPR && !com.baidu.tbadk.core.util.v.J(getPbData().beX())) {
                    getPbData().beX().remove(this.fQN);
                    if (this.fQO != null) {
                        getPbData().beX().remove(this.fQO);
                    }
                    getPbData().beX().add(0, this.fQN);
                } else {
                    getPbData().beX().remove(this.fQN);
                    if (this.fQO != null) {
                        getPbData().beX().remove(this.fQO);
                    }
                }
            }
            this.fQO = null;
        }
    }

    public void biv() {
        if (this.fQf != null && !com.baidu.tbadk.core.util.v.J(this.fQf.beX())) {
            if (this.fQO != null) {
                this.fQf.beX().remove(this.fQO);
                this.fQO = null;
            }
            if (this.fQN != null) {
                this.fQf.beX().remove(this.fQN);
                this.fQN = null;
            }
        }
    }

    public void bx(int i, int i2) {
        this.fQP = i;
        this.fQQ = i2;
    }

    public PostData biw() {
        return this.fQN;
    }

    public PostData bix() {
        return this.fQO;
    }

    public int biy() {
        return this.fQP;
    }

    public String biz() {
        return this.fQR;
    }

    public void sv(String str) {
        this.fQR = str;
    }

    private boolean biA() {
        return this.mSortType == 0 || this.mSortType == 2;
    }
}
