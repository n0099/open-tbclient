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
    private BaseActivity bSO;
    private final CheckRealNameModel cAB;
    private long dSI;
    private int dcZ;
    private com.baidu.tieba.tbadkCore.d.b dqh;
    private boolean eUc;
    protected String fPR;
    private String fPS;
    private String fPT;
    private boolean fPU;
    private boolean fPV;
    private boolean fPW;
    private boolean fPX;
    private boolean fPY;
    private int fPZ;
    private long fQA;
    private boolean fQB;
    private int fQC;
    private boolean fQD;
    private boolean fQE;
    private int fQF;
    private final w fQG;
    private final h fQH;
    private final m fQI;
    private final q fQJ;
    private final y fQK;
    private String fQL;
    private final AddExperiencedModel fQM;
    private SuggestEmotionModel fQN;
    private GetSugMatchWordsModel fQO;
    private boolean fQP;
    private int fQQ;
    private String fQR;
    private PostData fQS;
    private PostData fQT;
    private int fQU;
    private int fQV;
    private String fQW;
    private CustomMessageListener fQX;
    private CustomMessageListener fQY;
    private com.baidu.adp.framework.listener.a fQZ;
    private long fQa;
    private int fQb;
    private int fQc;
    private int fQd;
    private boolean fQe;
    private boolean fQf;
    private long fQg;
    private boolean fQh;
    private String fQi;
    protected com.baidu.tieba.pb.data.d fQj;
    private int fQk;
    private boolean fQl;
    private boolean fQm;
    private boolean fQn;
    private boolean fQo;
    private a fQp;
    private String fQq;
    private String fQr;
    private int fQs;
    private int fQt;
    private boolean fQu;
    private boolean fQv;
    private boolean fQw;
    private boolean fQx;
    private boolean fQy;
    private String fQz;
    private PraiseData fRa;
    private boolean fjT;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private com.baidu.tieba.pb.data.c mAppealInfo;
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
    private static final int fPQ = com.baidu.tbadk.data.d.Kw() / 30;
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
        this.fPR = null;
        this.fPS = null;
        this.fPT = null;
        this.mForumId = null;
        this.fPU = false;
        this.fPV = false;
        this.fPW = true;
        this.fPX = true;
        this.fPY = false;
        this.mIsGood = 0;
        this.fPZ = 0;
        this.fQa = 0L;
        this.fQb = 1;
        this.fQc = 1;
        this.fQd = 1;
        this.dcZ = 1;
        this.isAd = false;
        this.eUc = false;
        this.fQe = false;
        this.fjT = false;
        this.isFromMark = false;
        this.fQf = false;
        this.fQg = 0L;
        this.fQh = false;
        this.fQi = null;
        this.fQj = null;
        this.isLoading = false;
        this.fQl = false;
        this.fQm = false;
        this.fQn = false;
        this.fQo = false;
        this.mLocate = null;
        this.mContext = null;
        this.fQp = null;
        this.opType = null;
        this.opUrl = null;
        this.fQq = null;
        this.fQr = null;
        this.fQs = -1;
        this.fQt = -1;
        this.dqh = null;
        this.fQv = false;
        this.fQw = false;
        this.postID = null;
        this.fQz = null;
        this.fQA = 0L;
        this.fQB = false;
        this.fQC = -1;
        this.fQE = false;
        this.fQP = false;
        this.fQQ = 0;
        this.fQX = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.fQy = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.bau() != null) {
                        pbData.bau().eO(0);
                    }
                    if (PbModel.this.fQp != null && pbData != null) {
                        com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fQp.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fQY = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().bas() != null && PbModel.this.getPbData().bas().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().bas().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fQZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.oJ()) {
                        PbModel.this.bSO.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.fQv || !PbModel.this.fQw) {
                        if (!PbModel.this.fQv) {
                            PbModel.this.fQv = true;
                        } else {
                            PbModel.this.fQw = true;
                        }
                        if (PbModel.this.fQp != null) {
                            PbModel.this.fQp.a(PbModel.this.bdj(), z, responsedMessage, PbModel.this.fQx, System.currentTimeMillis() - PbModel.this.dSI);
                        }
                    }
                }
            }
        };
        this.fRa = null;
        registerListener(this.fQX);
        registerListener(this.fQZ);
        registerListener(this.fQY);
        this.fQj = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bSO = baseActivity;
        this.fQG = new w(this, this.bSO);
        this.fQH = new h(this, this.bSO);
        this.fQI = new m(this, this.bSO);
        this.fQJ = new q(this, getUniqueId());
        this.fQK = new y(this, this.bSO);
        this.cAB = new CheckRealNameModel(this.bSO.getPageContext());
        this.fQN = new SuggestEmotionModel();
        this.fQM = new AddExperiencedModel(this.bSO.getPageContext());
    }

    protected int bdj() {
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
        this.fPR = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fPR)) {
            this.fPR = this.fQG.V(intent);
        }
        this.fQQ = intent.getIntExtra("key_start_from", 0);
        if (this.fQQ == 0) {
            this.fQQ = this.fQG.fRg;
        }
        this.fPT = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.fPS = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fPU = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fPV = intent.getBooleanExtra("host_only", false);
        this.fPX = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fPZ = intent.getIntExtra("is_top", 0);
        this.fQa = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fQf = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eUc = intent.getBooleanExtra("is_sub_pb", false);
        this.fQh = intent.getBooleanExtra("is_pv", false);
        this.fQg = intent.getLongExtra("msg_id", 0L);
        this.fQi = intent.getStringExtra("from_forum_name");
        this.fQr = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fQq = intent.getStringExtra("op_stat");
        this.fQl = intent.getBooleanExtra("is_from_thread_config", false);
        this.fQm = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fQn = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fQt = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fQs = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fQe = intent.getBooleanExtra("from_frs", false);
        this.fjT = intent.getBooleanExtra("from_maintab", false);
        this.fQE = intent.getBooleanExtra("from_smart_frs", false);
        this.fQo = intent.getBooleanExtra("from_hottopic", false);
        this.fQL = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fQQ = bundle.getInt("key_start_from", 0);
        this.fPR = bundle.getString("thread_id");
        this.fPT = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.fPS = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fPU = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fPV = bundle.getBoolean("host_only", false);
        this.fPX = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fPZ = bundle.getInt("is_top", 0);
        this.fQa = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fQf = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eUc = bundle.getBoolean("is_sub_pb", false);
        this.fQh = bundle.getBoolean("is_pv", false);
        this.fQg = bundle.getLong("msg_id", 0L);
        this.fQi = bundle.getString("from_forum_name");
        this.fQr = bundle.getString("extra_pb_cache_key");
        this.fQl = bundle.getBoolean("is_from_thread_config", false);
        this.fQm = bundle.getBoolean("is_from_interview_live_config", false);
        this.fQn = bundle.getBoolean("is_from_my_god_config", false);
        this.fQt = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fQs = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fQe = bundle.getBoolean("from_frs", false);
        this.fjT = bundle.getBoolean("from_maintab", false);
        this.fQE = bundle.getBoolean("from_smart_frs", false);
        this.fQo = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void D(Bundle bundle) {
        bundle.putString("thread_id", this.fPR);
        bundle.putString("post_id", this.fPT);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt("key_start_from", this.fQQ);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fPU);
        bundle.putBoolean("host_only", this.fPV);
        bundle.putBoolean("squence", this.fPX);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fPZ);
        bundle.putLong("thread_time", this.fQa);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fQf);
        bundle.putBoolean("is_sub_pb", this.eUc);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fQh);
        bundle.putLong("msg_id", this.fQg);
        bundle.putString("extra_pb_cache_key", this.fQr);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fQl);
        bundle.putBoolean("is_from_interview_live_config", this.fQm);
        bundle.putBoolean("is_from_my_god_config", this.fQn);
        bundle.putInt("extra_pb_is_attention_key", this.fQt);
        bundle.putInt("extra_pb_funs_count_key", this.fQs);
        bundle.putBoolean("from_frs", this.fQe);
        bundle.putBoolean("from_maintab", this.fjT);
        bundle.putBoolean("from_smart_frs", this.fQE);
        bundle.putBoolean("from_hottopic", this.fQo);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bdk() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fPR);
        if (!this.fQf) {
            sb.append(this.fPT);
        }
        sb.append(this.fPV);
        sb.append(this.fPX);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fPZ);
        sb.append(this.fQa);
        sb.append(this.fQe);
        sb.append(this.fjT);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eUc);
        sb.append(this.fQh);
        sb.append(this.fQg);
        sb.append(this.fQi);
        sb.append(this.mThreadType);
        sb.append(this.fQl);
        sb.append(this.fQm);
        sb.append(this.fQn);
        if (this.fQr != null) {
            sb.append(this.fQr);
        }
        return sb.toString();
    }

    public String bdl() {
        return this.fQi;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.fPT;
    }

    public String bdm() {
        return this.fPR;
    }

    public boolean getHostMode() {
        return this.fPV;
    }

    public boolean bdn() {
        return this.fPX;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bdo() {
        return this.fQe;
    }

    public boolean bdp() {
        return this.fPY;
    }

    public boolean bdq() {
        return this.fjT;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bdr() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bds() {
        return this.fPZ;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void lO(int i) {
        this.fPZ = i;
    }

    public boolean bdt() {
        return this.eUc;
    }

    public boolean bdu() {
        if (this.fQj == null) {
            return false;
        }
        return this.fQj.isValid();
    }

    public String zx() {
        if (this.fQj == null || !this.fQj.vX()) {
            return null;
        }
        return this.fQj.vW();
    }

    public boolean sQ(int i) {
        this.fQb = i;
        if (this.fQb > this.fQj.yA().yr()) {
            this.fQb = this.fQj.yA().yr();
        }
        if (this.fQb < 1) {
            this.fQb = 1;
        }
        if (this.fPR == null) {
            return false;
        }
        return sT(5);
    }

    public void sR(int i) {
        this.fQb = i;
        this.fQc = i;
        this.fQd = i;
    }

    public void sS(int i) {
        if (this.fQc < i) {
            this.fQc = i;
            if (this.fQc - this.fQd >= fPQ) {
                this.fQd = (this.fQc - fPQ) + 1;
            }
        }
        if (this.fQd > i) {
            this.fQd = i;
            if (this.fQc - this.fQd >= fPQ) {
                this.fQc = (this.fQd + fPQ) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.fQj;
    }

    public com.baidu.tbadk.core.data.al aEp() {
        if (this.fQj == null) {
            return null;
        }
        return this.fQj.yA();
    }

    public boolean bdv() {
        if (this.fPX && this.fQj.yA().yw() == 0) {
            kl(true);
            return true;
        }
        return false;
    }

    public void ql(String str) {
        if (!StringUtils.isNull(str)) {
            this.fPR = str;
            this.fPT = null;
            this.fPV = false;
            this.fPX = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fPR == null) {
            return false;
        }
        cancelLoadData();
        if (this.dqh == null) {
            this.dqh = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.dqh.start();
        }
        boolean sT = sT(3);
        if (this.opType != null) {
            this.opType = null;
            this.fQq = null;
            this.opUrl = null;
            return sT;
        }
        return sT;
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
        if (this.fQN != null) {
            this.fQN.cancelLoadData();
        }
        if (this.fQJ != null) {
            this.fQJ.cancelLoadData();
        }
        if (this.fQO != null) {
            this.fQO.cancelLoadData();
        }
        aqT();
    }

    private void aqT() {
        if (this.dqh != null) {
            this.dqh.destory();
            this.dqh = null;
        }
    }

    public boolean Nw() {
        return (this.fPT == null || this.fPT.equals("0") || this.fPT.length() == 0) ? LoadData() : bdy();
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
                this.fQN.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fQN.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fQO == null) {
                this.fQO = new GetSugMatchWordsModel(this.bSO.getPageContext());
            }
            this.fQO.b(aVar);
        }
    }

    public boolean sT(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        sU(i);
        final com.baidu.tieba.pb.data.d pbData = ai.beu().getPbData();
        if (pbData != null && pbData.bau() != null) {
            pbData.bau().eO(0);
            this.fPX = ai.beu().bdn();
            this.fPV = ai.beu().bez();
            this.fPY = ai.beu().beA();
            this.fQS = ai.beu().bey();
            this.fQT = ai.beu().bex();
            this.fQU = ai.beu().bew();
            this.fQP = this.fPV;
            if (this.fPV || this.isFromMark) {
                this.fQu = false;
            }
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.fQy) {
            a(bdD(), true, this.fPT, 3);
        }
        if (i == 3 && !this.fQy) {
            if (this.isFromMark) {
                a(bdD(), true, this.fPT, 3);
            } else {
                a(bdD(), false, this.fPT, 3);
            }
        }
        this.fQy = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.brA);
        if (this.fPV || this.isFromMark) {
            this.fQu = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fPR == null || this.fPR.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.fPR, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.ao.De().Dg() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ao));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aq));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.fPX) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.fPV) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fQh) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fQg));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fQu) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.h(this.fQq, 0));
            pbPageRequestMessage.setOpMessageID(this.fQg);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> baw = this.fQj.baw();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.fPX) {
                        if (this.fQd - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fQd - 1));
                        }
                    } else if (this.fQc < this.dcZ) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fQc + 1));
                    }
                }
                if (baw != null && baw.size() > 0) {
                    int size = baw.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = baw.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.fPT = postData.getId();
                            if (StringUtils.isNull(this.fPT)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.fPT != null && this.fPT.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fPT, 0L));
                } else if (!this.fPX) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (baw != null && baw.size() > 0 && baw.get(0) != null) {
                    this.fPT = baw.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.fPX) {
                        if (this.fQd - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fQd - 1));
                        }
                    } else if (this.fQc < this.dcZ) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fQc + 1));
                    }
                }
                if (this.fPT != null && this.fPT.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fPT, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fPV) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.fPX) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fPT, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fQb));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.fPX && this.fQP && !this.fPV) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fPT, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.fPV) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fQC);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fQR, 0L));
                if (!this.fPX) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fQP = this.fPV;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bdD());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fQQ));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fQB);
        pbPageRequestMessage.setFromSmartFrs(this.fQE ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fPU);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bcA() {
        switch (bdS()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bau() == null || !getPbData().bau().Aw();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bdl()) && com.baidu.tieba.recapp.r.bof().bnZ() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bof().bnZ().V(bdl(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bof().bnZ().W(bdl(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bdl()) && com.baidu.tieba.recapp.r.bof().bnZ() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bof().bnZ().W(bdl(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bof().bnZ().V(bdl(), true));
        }
    }

    protected void sU(int i) {
        boolean z = false;
        sY(i);
        ArrayList<PostData> baw = this.fQj.baw();
        this.fQx = false;
        if (i == 1) {
            boolean z2 = false;
            while (baw.size() + 30 > com.baidu.tbadk.data.d.Kw()) {
                baw.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fQj.yA().eK(1);
                if (this.fQp != null) {
                    this.fQp.f(this.fQj);
                }
            }
            this.dSI = System.currentTimeMillis();
            this.fQx = true;
        } else if (i == 2) {
            while (baw.size() + 30 > com.baidu.tbadk.data.d.Kw()) {
                baw.remove(baw.size() - 1);
                z = true;
            }
            if (z) {
                this.fQj.yA().eJ(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.fQF = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fPS)) {
            try {
                Long valueOf = Long.valueOf(this.fPS);
                com.baidu.tieba.pb.data.l baF = dVar.baF();
                if (baF != null && baF.fIq != null) {
                    if (baF.fIq.isEmpty() || !baF.fIq.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fPR);
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
            if (this.fQn || this.fQl || this.fQm) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.baw().size(); i++) {
                PostData postData = dVar.baw().get(i);
                for (int i2 = 0; i2 < postData.bwR().size(); i2++) {
                    postData.bwR().get(i2).b(this.bSO.getPageContext(), l.equals(postData.bwR().get(i2).zn().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.l baF = dVar.baF();
            if (baF != null && !com.baidu.tbadk.core.util.v.E(baF.fIp)) {
                for (PostData postData2 : baF.fIp) {
                    for (int i3 = 0; i3 < postData2.bwR().size(); i3++) {
                        postData2.bwR().get(i3).b(this.bSO.getPageContext(), l.equals(postData2.bwR().get(i3).zn().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.l baF = dVar.baF();
            if (baF != null && !com.baidu.tbadk.core.util.v.E(baF.fIp)) {
                for (PostData postData : baF.fIp.subList(i, baF.fIp.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bwR().size()) {
                            postData.bwR().get(i3).b(this.bSO.getPageContext(), l.equals(postData.bwR().get(i3).zn().getUserId()));
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
        bd bau = dVar.bau();
        bau.eS(this.mIsGood);
        bau.eR(this.fPZ);
        if (this.fQa > 0) {
            bau.v(this.fQa);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bau() != null && dVar.bau().zn() != null) {
            str = dVar.bau().zn().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bdw() {
        if (this.fQj == null || this.fQj.bau() == null || this.fQj.bau().zn() == null) {
            return null;
        }
        return this.fQj.bau().zn();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fQD = z3;
        this.fQk = i;
        if (this.dqh != null && !z3) {
            this.dqh.a(z2, z4, i2, str, i3, j, j2);
            this.dqh = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bdl()) && com.baidu.tieba.recapp.r.bof().bnZ() != null) {
            com.baidu.tieba.recapp.r.bof().bnZ().f(bdl(), sV(getRequestType()), true);
        }
        if (dVar == null || (this.fQb == 1 && i == 5 && dVar.baw() != null && dVar.baw().size() < 1)) {
            if (this.fQp != null) {
                this.fPX = this.fPW;
                this.fQp.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fPW = this.fPX;
            this.fQh = false;
            if (dVar.yA() != null) {
                sS(dVar.yA().yu());
                this.dcZ = dVar.yA().yr();
            }
            this.dcZ = this.dcZ < 1 ? 1 : this.dcZ;
            ArrayList<PostData> baw = this.fQj.baw();
            switch (i) {
                case 1:
                    this.fQj.a(dVar.yA(), 1);
                    e(dVar, baw);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.baw() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.baw().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(baw, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.f(dVar.baw(), com.baidu.tbadk.core.util.v.D(dVar.baw()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.baw().remove(postData2);
                            i6 = size - 1;
                        }
                        baw.addAll(0, dVar.baw());
                    }
                    this.fQj.a(dVar.yA(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.fPX && dVar.yA() != null) {
                        dVar.yA().eH(dVar.yA().yr());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && this.fPX) {
                        bdx();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.E(dVar.baw()) && this.fQj != null && (!this.fPV || l(dVar).equals(dVar.baw().get(0).zn().getUserId()))) {
                        if (this.fQj.yA().yw() == 0) {
                            this.fQj.yA().eJ(1);
                        }
                        bdT();
                        this.fQS = dVar.baw().get(0);
                        if (this.fPX) {
                            if (this.fQj.baw().size() - this.fQU >= 3) {
                                this.fQT = new PostData();
                                this.fQT.hbo = true;
                                this.fQT.setPostType(53);
                                this.fQj.baw().add(this.fQT);
                            }
                            this.fQj.baw().add(this.fQS);
                            i4 = this.fQj.baw().size() - 1;
                        } else {
                            if (this.fQU - this.fQV >= 3) {
                                this.fQT = new PostData();
                                this.fQT.hbo = false;
                                this.fQT.setPostType(53);
                                this.fQj.baw().add(0, this.fQT);
                            }
                            this.fQj.baw().add(0, this.fQS);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.am.W(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fQS.hbB = this.fQj.baT();
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
            if (this.fQj != null && this.fQj.bau() != null) {
                PraiseData zc = this.fQj.bau().zc();
                if (this.fRa != null && !zc.isPriaseDataValid()) {
                    this.fQj.bau().a(this.fRa);
                } else {
                    this.fRa = this.fQj.bau().zc();
                    this.fRa.setPostId(this.fQj.bau().zE());
                }
                if (dVar.yA() != null && dVar.yA().yu() == 1 && dVar.bau() != null && dVar.bau().zz() != null && dVar.bau().zz().size() > 0) {
                    this.fQj.bau().i(dVar.bau().zz());
                }
                this.fQj.bau().eP(dVar.bau().zf());
                this.fQj.bau().eM(dVar.bau().getAnchorLevel());
                this.fQj.bau().eO(dVar.bau().yY());
                if (this.mThreadType == 33) {
                    this.fQj.bau().zn().setHadConcerned(dVar.bau().zn().hadConcerned());
                }
                if (dVar != null && dVar.bau() != null) {
                    this.fQj.bau().eU(dVar.bau().zD());
                }
            }
            if (this.fQj != null && this.fQj.getUserData() != null && dVar.getUserData() != null) {
                this.fQj.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.fQj.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.yA() != null && dVar.yA().yu() == 1 && dVar.baE() != null) {
                this.fQj.c(dVar.baE());
            }
            if (this.fQD) {
                if (this.fQj.bau() != null && this.fQj.bau().zn() != null && this.fQj.baw() != null && com.baidu.tbadk.core.util.v.f(this.fQj.baw(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.f(this.fQj.baw(), 0);
                    MetaData zn = this.fQj.bau().zn();
                    if (postData3.zn() != null && postData3.zn().getGodUserData() != null) {
                        if (this.fQs != -1) {
                            zn.setFansNum(this.fQs);
                            postData3.zn().setFansNum(this.fQs);
                        }
                        if (this.fQt != -1) {
                            zn.getGodUserData().setIsLike(this.fQt == 1);
                            postData3.zn().getGodUserData().setIsLike(this.fQt == 1);
                            zn.getGodUserData().setIsFromNetWork(false);
                            postData3.zn().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fQj.fHK = -1;
                this.fQj.fHJ = -1;
            }
            if (this.fQp != null) {
                this.fQp.a(true, getErrorCode(), i, i5, this.fQj, this.mErrorString, 1);
            }
        }
        if (this.fQj != null && this.fQj.bau() != null && this.fQj.bas() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bSO;
            historyMessage.threadId = getPbData().bau().getId();
            if (this.mIsShareThread && getPbData().bau().aQw != null) {
                historyMessage.threadName = getPbData().bau().aQw.showText;
            } else {
                historyMessage.threadName = getPbData().bau().getTitle();
            }
            if (this.mIsShareThread && !bcA()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().bas().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bdn();
            historyMessage.threadType = getPbData().bau().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String am;
        if (arrayList != null && dVar.baw() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(dVar.baw(), 0);
            if (postData != null && (am = am(arrayList)) != null && am.equals(postData.getId())) {
                dVar.baw().remove(postData);
            }
            arrayList.addAll(dVar.baw());
        }
    }

    private int sV(int i) {
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

    private String am(ArrayList<PostData> arrayList) {
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
    public void m(com.baidu.tieba.pb.data.d dVar) {
        dVar.qk(this.fQj.baL());
        this.fQj = dVar;
        sR(dVar.yA().yu());
    }

    private void bdx() {
        if (this.fQj != null && this.fQj.baw() != null && this.fQj.baK() != null) {
            ArrayList<PostData> baw = this.fQj.baw();
            com.baidu.tieba.pb.data.a baK = this.fQj.baK();
            int bap = baK.bap();
            if (bap > 0) {
                if (bap <= baw.size()) {
                    baw.add(bap, baK);
                } else {
                    baw.add(baK);
                }
            }
        }
    }

    public boolean bdy() {
        if (this.fPR == null || this.fPT == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return sT(4);
        }
        return sT(6);
    }

    public boolean kl(boolean z) {
        if (this.fPR == null || this.fQj == null) {
            return false;
        }
        if (z || this.fQj.yA().yw() != 0) {
            return sT(1);
        }
        return false;
    }

    public boolean km(boolean z) {
        if (this.fPR == null || this.fQj == null) {
            return false;
        }
        if ((z || this.fQj.yA().yx() != 0) && this.fQj.baw() != null && this.fQj.baw().size() >= 1) {
            return sT(2);
        }
        return false;
    }

    public boolean qq(String str) {
        this.fPV = !this.fPV;
        this.fPT = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (sT(6)) {
            return true;
        }
        this.fPV = this.fPV ? false : true;
        return false;
    }

    public boolean j(boolean z, String str) {
        if (this.fPV == z) {
            return false;
        }
        this.fPV = z;
        this.fPT = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (sT(6)) {
            return true;
        }
        this.fPV = z ? false : true;
        return false;
    }

    public boolean bdz() {
        this.fPW = this.fPX;
        this.fPX = !this.fPX;
        if (this.isLoading || !LoadData()) {
            this.fPX = this.fPX ? false : true;
            return false;
        }
        return true;
    }

    public boolean bdA() {
        return this.fPX;
    }

    public boolean hasData() {
        return (this.fQj == null || this.fQj.bas() == null || this.fQj.bau() == null) ? false : true;
    }

    public boolean vX() {
        if (this.fQj == null) {
            return false;
        }
        return this.fQj.vX();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gr(String str) {
        if (this.fQj == null || this.fQj.bau() == null || this.fQj.bas() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fQj.bau().Aw()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fQj.bas().getId());
            writeData.setForumName(this.fQj.bas().getName());
        }
        writeData.sourceFrom = String.valueOf(this.fQQ);
        writeData.setThreadId(this.fPR);
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

    public MarkData sW(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fQj == null) {
            return null;
        }
        ArrayList<PostData> baw = this.fQj.baw();
        if (com.baidu.tbadk.core.util.v.E(baw)) {
            return null;
        }
        if (baw.size() > 0 && i >= baw.size()) {
            i = baw.size() - 1;
        }
        return h(baw.get(i));
    }

    public MarkData bdB() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fPR);
        markData.setPostId(this.fQj.vW());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fPV);
        markData.setSequence(Boolean.valueOf(this.fPX));
        markData.setId(this.fPR);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fPR);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fPV);
        markData.setSequence(Boolean.valueOf(this.fPX));
        markData.setId(this.fPR);
        markData.setFloor(postData.bwU());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bdC() {
        g.bcU().O(bdD(), this.isFromMark);
    }

    private String bdD() {
        String str = this.fPR;
        if (this.fPV) {
            str = str + DB_KEY_HOST;
        }
        if (!this.fPX) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void kn(boolean z) {
        if (this.fQj != null) {
            this.fQj.aL(z);
        }
    }

    public void ko(boolean z) {
        this.fQu = z;
    }

    public boolean bdE() {
        return this.fQu;
    }

    public void a(a aVar) {
        this.fQp = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lx() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Lw() {
        return Nw();
    }

    public boolean qr(String str) {
        if (getPbData() == null || getPbData().bau() == null || getPbData().bau().zn() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bau().zn().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bdF() {
        String bdD = bdD();
        g.bcU().O(bdD, false);
        g.bcU().O(bdD, true);
    }

    public void bdG() {
        if ("personalize_page".equals(this.mStType)) {
            this.fQA = System.currentTimeMillis() / 1000;
        }
    }

    public void bdH() {
        if ("personalize_page".equals(this.mStType) && this.fQj != null && this.fQA != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ab(ImageViewerConfig.FORUM_ID, this.fQj.getForumId()).ab("tid", this.fPR).ab("obj_duration", String.valueOf(currentTimeMillis - this.fQA)).ab("obj_param3", String.valueOf(currentTimeMillis)));
            this.fQA = 0L;
        }
    }

    public boolean bdI() {
        return this.fQD;
    }

    public int getErrorNo() {
        return this.fQF;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bdJ() {
        return this.fQH;
    }

    public m bdK() {
        return this.fQI;
    }

    public q bdL() {
        return this.fQJ;
    }

    public y bdM() {
        return this.fQK;
    }

    public CheckRealNameModel bdN() {
        return this.cAB;
    }

    public AddExperiencedModel bdO() {
        return this.fQM;
    }

    public String bdP() {
        return this.fQz;
    }

    public void qs(String str) {
        this.fQz = str;
    }

    public boolean bdQ() {
        return this.fQE;
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fQj != null && this.fQj.baw() != null && this.fQj.baw().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fQj.baw().size();
                for (int i = 0; i < size; i++) {
                    if (this.fQj.baw().get(i) != null && this.fQj.baw().get(i).zn() != null && currentAccount.equals(this.fQj.baw().get(i).zn().getUserId()) && this.fQj.baw().get(i).zn().getPendantData() != null) {
                        this.fQj.baw().get(i).zn().getPendantData().cX(hVar.ya());
                        this.fQj.baw().get(i).zn().getPendantData().ab(hVar.KE());
                    }
                }
            }
        }
    }

    public String bdR() {
        return this.fQL;
    }

    public int bdS() {
        return this.fQQ;
    }

    public void sX(int i) {
        this.fQQ = i;
    }

    public void qt(String str) {
        if ((!this.fPV || qr(TbadkCoreApplication.getCurrentAccount())) && this.fQj.baw() != null) {
            this.fQj.yA().eJ(1);
            if (this.fQj.yA().yw() == 0) {
                this.fQj.yA().eJ(1);
            }
            this.fQR = str;
            sT(8);
        }
    }

    private void sY(int i) {
        if (i != 8) {
            this.fQR = "";
            if (this.fQS != null) {
                if (i == 1 && !this.fPX && !com.baidu.tbadk.core.util.v.E(getPbData().baw())) {
                    getPbData().baw().remove(this.fQS);
                    if (this.fQT != null) {
                        getPbData().baw().remove(this.fQT);
                    }
                    getPbData().baw().add(0, this.fQS);
                } else {
                    getPbData().baw().remove(this.fQS);
                    if (this.fQT != null) {
                        getPbData().baw().remove(this.fQT);
                    }
                }
            }
            this.fQT = null;
        }
    }

    public void bdT() {
        if (this.fQj != null && !com.baidu.tbadk.core.util.v.E(this.fQj.baw())) {
            if (this.fQT != null) {
                this.fQj.baw().remove(this.fQT);
                this.fQT = null;
            }
            if (this.fQS != null) {
                this.fQj.baw().remove(this.fQS);
                this.fQS = null;
            }
        }
    }

    public void co(int i, int i2) {
        this.fQU = i;
        this.fQV = i2;
    }

    public PostData bdU() {
        return this.fQS;
    }

    public PostData bdV() {
        return this.fQT;
    }

    public int bdW() {
        return this.fQU;
    }

    public String bdX() {
        return this.fQW;
    }

    public void qu(String str) {
        this.fQW = str;
    }
}
