package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import tbclient.PbPage.PbSortType;
/* loaded from: classes4.dex */
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
    private int eSk;
    private long fMQ;
    private com.baidu.tieba.tbadkCore.d.b fci;
    private boolean gWK;
    private boolean hQA;
    private boolean hQB;
    private boolean hQC;
    private long hQD;
    private boolean hQE;
    private String hQF;
    protected com.baidu.tieba.pb.data.d hQG;
    private int hQH;
    private boolean hQI;
    private boolean hQJ;
    private boolean hQK;
    private boolean hQL;
    private a hQM;
    private String hQN;
    private String hQO;
    private int hQP;
    private int hQQ;
    private boolean hQR;
    private boolean hQS;
    private boolean hQT;
    private boolean hQU;
    private boolean hQV;
    private String hQW;
    private long hQX;
    private boolean hQY;
    private int hQZ;
    protected String hQk;
    private String hQl;
    private String hQm;
    private String hQn;
    private boolean hQo;
    private boolean hQp;
    private boolean hQq;
    private boolean hQr;
    private int hQs;
    private boolean hQt;
    private int hQu;
    private long hQv;
    private int hQw;
    private int hQx;
    private int hQy;
    private boolean hQz;
    private boolean hRa;
    private boolean hRb;
    private int hRc;
    private final x hRd;
    private final h hRe;
    private final m hRf;
    private final z hRg;
    private String hRh;
    private final CheckRealNameModel hRi;
    private final AddExperiencedModel hRj;
    private SuggestEmotionModel hRk;
    private GetSugMatchWordsModel hRl;
    private boolean hRm;
    private int hRn;
    private String hRo;
    private PostData hRp;
    private PostData hRq;
    private int hRr;
    private int hRs;
    private String hRt;
    private com.baidu.tieba.tbadkCore.data.m hRu;
    private CustomMessageListener hRv;
    private CustomMessageListener hRw;
    private com.baidu.adp.framework.listener.a hRx;
    private PraiseData hRy;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private BaseActivity mActivity;
    private com.baidu.tieba.pb.data.c mAppealInfo;
    protected Context mContext;
    private String mForumId;
    private String mFromForumId;
    private int mIsGood;
    private boolean mIsShareThread;
    private CustomMessageListener mLikeForumListener;
    private String mLocate;
    private int mRequestType;
    private int mSortType;
    public String mStType;
    protected int mThreadType;
    private CustomMessageListener mUnlikeForumListener;
    private String opType;
    private String opUrl;
    private String postID;
    private static final int hQj = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.d dVar);
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.hQk = null;
        this.hQl = null;
        this.hQm = null;
        this.mForumId = null;
        this.hQn = null;
        this.hQo = false;
        this.hQp = false;
        this.hQq = true;
        this.hQr = true;
        this.mSortType = 0;
        this.hQs = 0;
        this.hQt = false;
        this.mIsGood = 0;
        this.hQu = 0;
        this.hQv = 0L;
        this.hQw = 1;
        this.hQx = 1;
        this.hQy = 1;
        this.eSk = 1;
        this.isAd = false;
        this.gWK = false;
        this.hQz = false;
        this.hQA = false;
        this.isFromMark = false;
        this.hQB = false;
        this.hQC = false;
        this.hQD = 0L;
        this.hQE = false;
        this.hQF = null;
        this.hQG = null;
        this.isLoading = false;
        this.hQI = false;
        this.hQJ = false;
        this.hQK = false;
        this.hQL = false;
        this.mLocate = null;
        this.mContext = null;
        this.hQM = null;
        this.opType = null;
        this.opUrl = null;
        this.hQN = null;
        this.hQO = null;
        this.hQP = -1;
        this.hQQ = -1;
        this.fci = null;
        this.hQS = false;
        this.hQT = false;
        this.postID = null;
        this.hQW = null;
        this.hQX = 0L;
        this.hQY = false;
        this.hQZ = -1;
        this.hRb = false;
        this.hRm = false;
        this.hRn = 0;
        this.hRv = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.hQV = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null && pbData.hIx == null) {
                    PbModel.this.l(pbData);
                    PbModel.this.h(pbData);
                    if (pbData.bQx() != null) {
                        pbData.bQx().hF(0);
                    }
                    if (PbModel.this.hQM != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.hQM.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.hRw = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().getForum() != null && PbModel.this.getPbData().getForum().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().getForum().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.hRx = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.mActivity.showToast(responsedMessage.getErrorString());
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
                        objArr[4] = BdStatsConstant.StatsKey.SEQUENCEID;
                        objArr[5] = Long.valueOf(j);
                        com.baidu.tbadk.core.e.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    }
                    if (!PbModel.this.hQS || !PbModel.this.hQT) {
                        if (!PbModel.this.hQS) {
                            PbModel.this.hQS = true;
                        } else {
                            PbModel.this.hQT = true;
                        }
                        if (PbModel.this.hQM != null) {
                            PbModel.this.hQM.a(PbModel.this.bTv(), z, responsedMessage, PbModel.this.hQU, System.currentTimeMillis() - PbModel.this.fMQ);
                        }
                    }
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    String valueOf = String.valueOf(customResponsedMessage.getData());
                    if (PbModel.this.hQG != null && PbModel.this.hQG.bQw() != null && PbModel.this.hQG.bQw().getForumId() != null && PbModel.this.hQG.bQw().getForumId().equals(valueOf)) {
                        PbModel.this.hQG.bQw().setIsLike(false);
                    }
                }
            }
        };
        this.mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.PbModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    String valueOf = String.valueOf(customResponsedMessage.getData());
                    if (PbModel.this.hQG != null && PbModel.this.hQG.bQw() != null && PbModel.this.hQG.bQw().getForumId() != null && PbModel.this.hQG.bQw().getForumId().equals(valueOf)) {
                        PbModel.this.hQG.bQw().setIsLike(true);
                    }
                }
            }
        };
        this.hRy = null;
        registerListener(this.hRv);
        registerListener(this.hRx);
        registerListener(this.hRw);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.hQG = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mActivity = baseActivity;
        this.hRd = new x(this, this.mActivity);
        this.hRe = new h(this, this.mActivity);
        this.hRf = new m(this, this.mActivity);
        this.hRg = new z(this, this.mActivity);
        this.hRi = new CheckRealNameModel(this.mActivity.getPageContext());
        this.hRk = new SuggestEmotionModel();
        this.hRj = new AddExperiencedModel(this.mActivity.getPageContext());
    }

    protected int bTv() {
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
        if (intent != null) {
            this.hQk = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.k(data)) {
                com.baidu.tbadk.BdToken.f.aen().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.bRz) instanceof String)) {
                            PbModel.this.hQk = (String) hashMap.get(com.baidu.tbadk.BdToken.f.bRz);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.hQk)) {
                this.hQk = this.hRd.aC(intent);
                if (StringUtils.isNull(this.hQk) && intent.getData() != null) {
                    this.hQk = data.getQueryParameter("thread_id");
                }
            }
            this.hRn = intent.getIntExtra("key_start_from", 0);
            if (this.hRn == 0) {
                this.hRn = this.hRd.hRE;
            }
            this.hQm = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.hQl = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.hQo = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.hQp = intent.getBooleanExtra("host_only", false);
            this.hQr = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.axn().aoN() ? 2 : 0);
            if (this.mSortType == 2) {
                this.hQm = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.hQu = intent.getIntExtra("is_top", 0);
            this.hQv = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.hQB = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.hQC = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.gWK = intent.getBooleanExtra("is_sub_pb", false);
            this.hQE = intent.getBooleanExtra("is_pv", false);
            this.hQD = intent.getLongExtra("msg_id", 0L);
            this.hQF = intent.getStringExtra("from_forum_name");
            this.hQO = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.hQN = intent.getStringExtra("op_stat");
            this.hQI = intent.getBooleanExtra("is_from_thread_config", false);
            this.hQJ = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.hQK = intent.getBooleanExtra("is_from_my_god_config", false);
            this.hQQ = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.hQP = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.hQz = intent.getBooleanExtra("from_frs", false);
            this.hQA = intent.getBooleanExtra("from_maintab", false);
            this.hRb = intent.getBooleanExtra("from_smart_frs", false);
            this.hQL = intent.getBooleanExtra("from_hottopic", false);
            this.hRh = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.hQn = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.hRn = bundle.getInt("key_start_from", 0);
        this.hQk = bundle.getString("thread_id");
        this.hQm = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.hQl = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.hQo = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.hQp = bundle.getBoolean("host_only", false);
        this.hQr = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.hQu = bundle.getInt("is_top", 0);
        this.hQv = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.hQC = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.gWK = bundle.getBoolean("is_sub_pb", false);
        this.hQE = bundle.getBoolean("is_pv", false);
        this.hQD = bundle.getLong("msg_id", 0L);
        this.hQF = bundle.getString("from_forum_name");
        this.hQO = bundle.getString("extra_pb_cache_key");
        this.hQI = bundle.getBoolean("is_from_thread_config", false);
        this.hQJ = bundle.getBoolean("is_from_interview_live_config", false);
        this.hQK = bundle.getBoolean("is_from_my_god_config", false);
        this.hQQ = bundle.getInt("extra_pb_is_attention_key", -1);
        this.hQP = bundle.getInt("extra_pb_funs_count_key", -1);
        this.hQz = bundle.getBoolean("from_frs", false);
        this.hQA = bundle.getBoolean("from_maintab", false);
        this.hRb = bundle.getBoolean("from_smart_frs", false);
        this.hQL = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.hQn = bundle.getString("high_light_post_id");
    }

    public void aa(Bundle bundle) {
        bundle.putString("thread_id", this.hQk);
        bundle.putString("post_id", this.hQm);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.hRn);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.hQo);
        bundle.putBoolean("host_only", this.hQp);
        bundle.putBoolean("squence", this.hQr);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.hQu);
        bundle.putLong("thread_time", this.hQv);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.hQC);
        bundle.putBoolean("is_sub_pb", this.gWK);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.hQE);
        bundle.putLong("msg_id", this.hQD);
        bundle.putString("extra_pb_cache_key", this.hQO);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.hQI);
        bundle.putBoolean("is_from_interview_live_config", this.hQJ);
        bundle.putBoolean("is_from_my_god_config", this.hQK);
        bundle.putInt("extra_pb_is_attention_key", this.hQQ);
        bundle.putInt("extra_pb_funs_count_key", this.hQP);
        bundle.putBoolean("from_frs", this.hQz);
        bundle.putBoolean("from_maintab", this.hQA);
        bundle.putBoolean("from_smart_frs", this.hRb);
        bundle.putBoolean("from_hottopic", this.hQL);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.hQn);
    }

    public String bTw() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.hQk);
        if (!this.hQC) {
            sb.append(this.hQm);
        }
        sb.append(this.hQp);
        sb.append(this.hQr);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.hQu);
        sb.append(this.hQv);
        sb.append(this.hQz);
        sb.append(this.hQA);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.gWK);
        sb.append(this.hQE);
        sb.append(this.hQD);
        sb.append(this.hQF);
        sb.append(this.mThreadType);
        sb.append(this.hQI);
        sb.append(this.hQJ);
        sb.append(this.hQK);
        if (this.hQO != null) {
            sb.append(this.hQO);
        }
        return sb.toString();
    }

    public String bRu() {
        return this.hQF;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.hQm;
    }

    public String bTx() {
        return this.hQn;
    }

    public String bTy() {
        return this.hQk;
    }

    public boolean getHostMode() {
        return this.hQp;
    }

    public boolean bTz() {
        return bUn();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bTA() {
        return this.hQz;
    }

    public boolean bTB() {
        return this.hQt;
    }

    public boolean bTC() {
        return this.hQA;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bTD() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bdN() {
        return this.hQu;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void pa(int i) {
        this.hQu = i;
    }

    public boolean bTE() {
        return this.gWK;
    }

    public boolean bTF() {
        if (this.hQG == null) {
            return false;
        }
        return this.hQG.isValid();
    }

    public String aiN() {
        if (this.hQG == null || !this.hQG.afk()) {
            return null;
        }
        return this.hQG.afj();
    }

    public boolean wD(int i) {
        this.hQw = i;
        if (this.hQw > this.hQG.getPage().aht()) {
            this.hQw = this.hQG.getPage().aht();
        }
        if (this.hQw < 1) {
            this.hQw = 1;
        }
        if (this.hQk == null) {
            return false;
        }
        return wF(5);
    }

    public void wE(int i) {
        this.hQw = i;
        this.hQx = i;
        this.hQy = i;
    }

    public void b(com.baidu.tbadk.core.data.an anVar) {
        if (anVar == null) {
            wE(1);
            return;
        }
        if (this.hQx < anVar.ahw()) {
            this.hQx = anVar.ahw();
        }
        if (this.hQy > anVar.ahw()) {
            this.hQy = anVar.ahw();
        }
        this.eSk = anVar.aht();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.hQG;
    }

    public com.baidu.tieba.pb.data.d bTG() {
        if (this.hQG == null) {
            return this.hQG;
        }
        if (!bTH() && this.hRu != null) {
            this.hQG.b(this.hRu);
        }
        return this.hQG;
    }

    private boolean bTH() {
        return (this.hQG.bQM() == null || this.hQG.bQM().cob() == null || this.hQG.bQM().cob().goods != null || this.hQG.bQM().cob().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.an getPageData() {
        if (this.hQG == null) {
            return null;
        }
        return this.hQG.getPage();
    }

    public boolean bTI() {
        if (bUn() && this.hQG.getPage().ahy() == 0) {
            op(true);
            return true;
        }
        return false;
    }

    public void AG(String str) {
        if (!StringUtils.isNull(str)) {
            this.hQk = str;
            this.hQm = null;
            this.hQp = false;
            this.hQr = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hQk == null) {
            return false;
        }
        cancelLoadData();
        if (this.fci == null) {
            this.fci = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.fci.start();
        }
        boolean wF = wF(3);
        if (this.opType != null) {
            this.opType = null;
            this.hQN = null;
            this.opUrl = null;
            return wF;
        }
        return wF;
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
        if (this.hRk != null) {
            this.hRk.cancelLoadData();
        }
        if (this.hRl != null) {
            this.hRl.cancelLoadData();
        }
        beQ();
    }

    private void beQ() {
        if (this.fci != null) {
            this.fci.destory();
            this.fci = null;
        }
    }

    public boolean loadData() {
        return (this.hQm == null || this.hQm.equals("0") || this.hQm.length() == 0) ? LoadData() : bTN();
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
                this.hRk.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.hRk.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.hRl == null) {
                this.hRl = new GetSugMatchWordsModel(this.mActivity.getPageContext());
            }
            this.hRl.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0311 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0319 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0328 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x035e A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x036d A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0392 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean wF(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        wG(i);
        final com.baidu.tieba.pb.data.d pbData = aj.bUI().getPbData();
        if (pbData != null && pbData.bQx() != null) {
            pbData.bQx().hF(0);
            this.hQr = aj.bUI().bTz();
            this.hQp = aj.bUI().bUN();
            this.hQt = aj.bUI().bUO();
            this.hRp = aj.bUI().bUM();
            this.hRq = aj.bUI().bUL();
            this.hRr = aj.bUI().bUK();
            this.hRm = this.hQp;
            if (this.hQp || this.isFromMark) {
                this.hQR = false;
            }
            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.7
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.hQV) {
            a(bTS(), true, this.hQm, 3);
        }
        if (i == 3 && !this.hQV) {
            if (this.isFromMark) {
                a(bTS(), true, this.hQm, 3);
            } else {
                a(bTS(), false, this.hQm, 3);
            }
        }
        this.hQV = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.hRu == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.cDx);
        if (this.hQp || this.isFromMark) {
            this.hQR = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.hQk == null || this.hQk.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.toLong(this.hQk, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.ar.amM().isFrsShowBigImage() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(equipmentWidth));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(equipmentHeight));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.hQr) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.hQp) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.hQE) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.hQD));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.hQR) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.toInt(this.hQN, 0));
            pbPageRequestMessage.setOpMessageID(this.hQD);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bQz = this.hQG.bQz();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hQy - 1));
                        if (this.hQy - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.hQB) {
                                if (bQz != null && bQz.size() > 0) {
                                    size = bQz.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bQz.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.hQm = postData.getId();
                                            if (StringUtils.isNull(this.hQm)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.hQx + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.hQm == null && this.hQm.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.toLong(this.hQm, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hQx + 1));
                        if (this.hQx >= this.eSk) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bQz != null) {
                                size = bQz.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.hQm == null) {
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
                if (bQz != null) {
                }
                if (this.hQm == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bQz != null && bQz.size() > 0 && bQz.get(0) != null) {
                    this.hQm = bQz.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bUn()) {
                        if (this.hQy - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.hQy - 1));
                        }
                    } else if (this.hQx < this.eSk) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hQx + 1));
                    }
                }
                if (this.hQm != null && this.hQm.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.toLong(this.hQm, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.hQp) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bUn()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.eSk > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eSk));
                    }
                }
                if (this.isFromMark) {
                    pbPageRequestMessage.set_st_type("store_thread");
                }
                a(pbPageRequestMessage);
                break;
            case 4:
                pbPageRequestMessage.set_st_type("store_thread");
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.toLong(this.hQm, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.hQw));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.hRm && !this.hQp) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.toLong(this.hQm, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.hQp) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.hQZ);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.toLong(this.hRo, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.hRm = this.hQp;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bTS());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.hRn));
        pbPageRequestMessage.setIsSubPostDataReverse(this.hQY);
        pbPageRequestMessage.setFromSmartFrs(this.hRb ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.hQo);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.hQk);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bRt() {
        switch (bUh()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bQx() == null || !getPbData().bQx().ajV();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bRu()) && com.baidu.tieba.recapp.r.cfJ().cfD() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cfJ().cfD().as(bRu(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cfJ().cfD().at(bRu(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bRu()) && com.baidu.tieba.recapp.r.cfJ().cfD() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cfJ().cfD().at(bRu(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cfJ().cfD().as(bRu(), true));
        }
    }

    protected void wG(int i) {
        boolean z = false;
        wL(i);
        ArrayList<PostData> bQz = this.hQG.bQz();
        this.hQU = false;
        if (i == 1) {
            boolean z2 = false;
            while (bQz.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                bQz.remove(0);
                z2 = true;
            }
            if (z2) {
                this.hQG.getPage().hC(1);
                if (this.hQM != null) {
                    this.hQM.e(this.hQG);
                }
            }
            this.fMQ = System.currentTimeMillis();
            this.hQU = true;
        } else if (i == 2) {
            while (bQz.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                bQz.remove(bQz.size() - 1);
                z = true;
            }
            if (z) {
                this.hQG.getPage().hB(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.hRc = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            h(dVar2);
        }
        g(dVar2);
        if (this.hRu != null && this.hRu.aEE()) {
            TiebaStatic.log(com.baidu.tieba.q.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bQM() != null && dVar.bQM().cob() != null && dVar.bQM().cob().goods != null && dVar.bQM().aEE() && dVar.bQM().cob().goods.goods_style != 1001) {
            this.hRu = dVar.bQM();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m bTJ() {
        return this.hRu;
    }

    public void bTK() {
        this.hRu = null;
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

    protected void h(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            if (this.hQK || this.hQI || this.hQJ) {
                dVar = j(dVar);
            }
            i(dVar);
        }
    }

    protected void i(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String k = k(dVar);
            for (int i = 0; i < dVar.bQz().size(); i++) {
                PostData postData = dVar.bQz().get(i);
                for (int i2 = 0; i2 < postData.cok().size(); i2++) {
                    postData.cok().get(i2).a(this.mActivity.getPageContext(), k.equals(postData.cok().get(i2).aiE().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.m bQI = dVar.bQI();
            if (bQI != null && !com.baidu.tbadk.core.util.v.isEmpty(bQI.hJg)) {
                for (PostData postData2 : bQI.hJg) {
                    for (int i3 = 0; i3 < postData2.cok().size(); i3++) {
                        postData2.cok().get(i3).a(this.mActivity.getPageContext(), k.equals(postData2.cok().get(i3).aiE().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String k = k(dVar);
            com.baidu.tieba.pb.data.m bQI = dVar.bQI();
            if (bQI != null && !com.baidu.tbadk.core.util.v.isEmpty(bQI.hJg)) {
                for (PostData postData : bQI.hJg.subList(i, bQI.hJg.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cok().size()) {
                            postData.cok().get(i3).a(this.mActivity.getPageContext(), k.equals(postData.cok().get(i3).aiE().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.d j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null) {
            return null;
        }
        bh bQx = dVar.bQx();
        bQx.hK(this.mIsGood);
        bQx.hJ(this.hQu);
        if (this.hQv > 0) {
            bQx.aJ(this.hQv);
            return dVar;
        }
        return dVar;
    }

    protected String k(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bQx() != null && dVar.bQx().aiE() != null) {
            str = dVar.bQx().aiE().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bTL() {
        if (this.hQG == null || this.hQG.bQx() == null || this.hQG.bQx().aiE() == null) {
            return null;
        }
        return this.hQG.bQx().aiE();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.hRa = z3;
        this.hQH = i;
        if (this.fci != null && !z3) {
            this.fci.a(z2, z4, i2, str, i3, j, j2);
            this.fci = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bRu()) && com.baidu.tieba.recapp.r.cfJ().cfD() != null) {
            com.baidu.tieba.recapp.r.cfJ().cfD().f(bRu(), wH(bTU()), true);
        }
        if (dVar == null || (this.hQw == 1 && i == 5 && dVar.bQz() != null && dVar.bQz().size() < 1)) {
            if (this.hQM != null) {
                this.hQr = this.hQq;
                if (i2 != 350006) {
                    this.mSortType = this.hQs;
                }
                this.hQM.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.hQq = this.hQr;
            if (i != 8) {
                this.hQs = this.mSortType;
                this.mSortType = dVar.hIw;
            }
            if (dVar.hIv != null && dVar.hIv.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.mActivity.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                dVar.hIv = new ArrayList();
                dVar.hIv.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.mActivity.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                dVar.hIv.add(builder2.build(false));
                this.mSortType = this.hQs;
                dVar.hIw = this.mSortType;
            }
            this.hQE = false;
            if (dVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(dVar.getPage());
            }
            this.eSk = this.eSk < 1 ? 1 : this.eSk;
            ArrayList<PostData> bQz = this.hQG.bQz();
            switch (i) {
                case 1:
                    this.hQG.a(dVar.getPage(), 1);
                    d(dVar, bQz);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bQz() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bQz().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(bQz, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(dVar.bQz(), com.baidu.tbadk.core.util.v.getCount(dVar.bQz()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bQz().remove(postData2);
                            i6 = size - 1;
                        }
                        bQz.addAll(0, dVar.bQz());
                    }
                    this.hQG.a(dVar.getPage(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.getPage() != null) {
                        dVar.getPage().hz(dVar.getPage().aht());
                    }
                    l(dVar);
                    if (!z3 && this.mThreadType != 33 && bUn()) {
                        bTM();
                        i5 = 0;
                        break;
                    }
                    i5 = 0;
                    break;
                case 4:
                    l(dVar);
                    i5 = 0;
                    break;
                case 5:
                    l(dVar);
                    i5 = 0;
                    break;
                case 6:
                    l(dVar);
                    i5 = 0;
                    break;
                case 7:
                    l(dVar);
                    i5 = 0;
                    break;
                case 8:
                    if (dVar != null && !com.baidu.tbadk.core.util.v.isEmpty(dVar.bQz()) && this.hQG != null && (!this.hQp || k(dVar).equals(dVar.bQz().get(0).aiE().getUserId()))) {
                        if (this.hQG.getPage().ahy() == 0) {
                            this.hQG.getPage().hB(1);
                        }
                        bUi();
                        this.hRp = dVar.bQz().get(0);
                        if (bUn()) {
                            if (this.hQG.bQz().size() - this.hRr >= 3) {
                                this.hRq = new PostData();
                                this.hRq.jhX = true;
                                this.hRq.setPostType(53);
                                this.hQG.bQz().add(this.hRq);
                            }
                            this.hQG.bQz().add(this.hRp);
                            i4 = this.hQG.bQz().size() - 1;
                        } else {
                            if (this.hRr - this.hRs >= 3) {
                                this.hRq = new PostData();
                                this.hRq.jhX = false;
                                this.hRq.setPostType(53);
                                this.hQG.bQz().add(0, this.hRq);
                            }
                            this.hQG.bQz().add(0, this.hRp);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.isTaday(com.baidu.tbadk.core.sharedPref.b.alP().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.hRp.jik = this.hQG.bQW();
                            com.baidu.tbadk.core.sharedPref.b.alP().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.hQG != null && this.hQG.bQx() != null) {
                PraiseData aiq = this.hQG.bQx().aiq();
                if (this.hRy != null && !aiq.isPriaseDataValid()) {
                    this.hQG.bQx().a(this.hRy);
                } else {
                    this.hRy = this.hQG.bQx().aiq();
                    this.hRy.setPostId(this.hQG.bQx().aiU());
                }
                if (dVar.getPage() != null && dVar.getPage().ahw() == 1 && dVar.bQx() != null && dVar.bQx().aiP() != null && dVar.bQx().aiP().size() > 0) {
                    this.hQG.bQx().t(dVar.bQx().aiP());
                }
                this.hQG.bQx().hH(dVar.bQx().aiv());
                this.hQG.bQx().hD(dVar.bQx().getAnchorLevel());
                this.hQG.bQx().hF(dVar.bQx().aim());
                if (this.mThreadType == 33) {
                    this.hQG.bQx().aiE().setHadConcerned(dVar.bQx().aiE().hadConcerned());
                }
                if (dVar != null && dVar.bQx() != null) {
                    this.hQG.bQx().hM(dVar.bQx().aiT());
                }
            }
            if (this.hQG != null && this.hQG.getUserData() != null && dVar.getUserData() != null) {
                this.hQG.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.hQG.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.getPage() != null && dVar.getPage().ahw() == 1 && dVar.bQH() != null) {
                this.hQG.d(dVar.bQH());
            }
            if (this.hRa) {
                if (this.hQG.bQx() != null && this.hQG.bQx().aiE() != null && this.hQG.bQz() != null && com.baidu.tbadk.core.util.v.getItem(this.hQG.bQz(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(this.hQG.bQz(), 0);
                    MetaData aiE = this.hQG.bQx().aiE();
                    if (postData3.aiE() != null && postData3.aiE().getGodUserData() != null) {
                        if (this.hQP != -1) {
                            aiE.setFansNum(this.hQP);
                            postData3.aiE().setFansNum(this.hQP);
                        }
                        if (this.hQQ != -1) {
                            aiE.getGodUserData().setIsLike(this.hQQ == 1);
                            postData3.aiE().getGodUserData().setIsLike(this.hQQ == 1);
                            aiE.getGodUserData().setIsFromNetWork(false);
                            postData3.aiE().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.hQG.hIu = -1;
                this.hQG.hIt = -1;
            }
            if (this.hQM != null) {
                this.hQM.a(true, getErrorCode(), i, i5, this.hQG, this.mErrorString, 1);
            }
        }
        if (this.hQG != null && this.hQG.bQx() != null && this.hQG.getForum() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mActivity.getPageContext();
            historyMessage.threadId = getPbData().bQx().getId();
            if (this.mIsShareThread && getPbData().bQx().cdl != null) {
                historyMessage.threadName = getPbData().bQx().cdl.showText;
            } else {
                historyMessage.threadName = getPbData().bQx().getTitle();
            }
            if (this.mIsShareThread && !bRt()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bTz();
            historyMessage.threadType = getPbData().bQx().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String aA;
        if (arrayList != null && dVar.bQz() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(dVar.bQz(), 0);
            if (postData != null && (aA = aA(arrayList)) != null && aA.equals(postData.getId())) {
                dVar.bQz().remove(postData);
            }
            arrayList.addAll(dVar.bQz());
        }
    }

    private int wH(int i) {
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

    private String aA(ArrayList<PostData> arrayList) {
        int count = com.baidu.tbadk.core.util.v.getCount(arrayList);
        if (count <= 0) {
            return null;
        }
        for (int i = count - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(com.baidu.tieba.pb.data.d dVar) {
        dVar.AD(this.hQG.bQP());
        this.hQG = dVar;
        wE(dVar.getPage().ahw());
    }

    private void bTM() {
        if (this.hQG != null && this.hQG.bQz() != null && this.hQG.bQO() != null) {
            ArrayList<PostData> bQz = this.hQG.bQz();
            com.baidu.tieba.pb.data.a bQO = this.hQG.bQO();
            int bQu = bQO.bQu();
            if (bQu > 0) {
                if (bQu <= bQz.size()) {
                    bQz.add(bQu, bQO);
                } else {
                    bQz.add(bQO);
                }
            }
        }
    }

    public boolean bTN() {
        if (this.hQk == null || this.hQm == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return wF(4);
        }
        return wF(6);
    }

    public boolean op(boolean z) {
        if (this.hQk == null || this.hQG == null) {
            return false;
        }
        if (z || this.hQG.getPage().ahy() != 0) {
            return wF(1);
        }
        return false;
    }

    public boolean oq(boolean z) {
        if (this.hQk == null || this.hQG == null) {
            return false;
        }
        if ((z || this.hQG.getPage().ahz() != 0) && this.hQG.bQz() != null && this.hQG.bQz().size() >= 1) {
            return wF(2);
        }
        return false;
    }

    public boolean AM(String str) {
        this.hQp = !this.hQp;
        this.hQm = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").O("obj_source", 0));
        if (wF(6)) {
            return true;
        }
        this.hQp = this.hQp ? false : true;
        return false;
    }

    public boolean u(boolean z, String str) {
        if (this.hQp == z) {
            return false;
        }
        this.hQp = z;
        this.hQm = str;
        if (this.mSortType == 2) {
            this.hQm = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").O("obj_source", 1));
        }
        if (wF(6)) {
            return true;
        }
        this.hQp = z ? false : true;
        return false;
    }

    public boolean wI(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.hQq = this.hQr;
        this.hQs = this.mSortType;
        this.mSortType = i;
        this.hQr = !this.hQr;
        if (i == 2 && this.isFromMark) {
            this.hQm = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.hQr = this.hQr ? false : true;
            this.mSortType = this.hQs;
            return false;
        }
        return true;
    }

    public boolean bTO() {
        return bUn();
    }

    public int bTP() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.hQG == null || this.hQG.getForum() == null || this.hQG.bQx() == null) ? false : true;
    }

    public boolean afk() {
        if (this.hQG == null) {
            return false;
        }
        return this.hQG.afk();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pG(String str) {
        if (this.hQG == null || this.hQG.bQx() == null || this.hQG.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.hQG.bQx().ajV()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.hQG.getForum().getId());
            writeData.setForumName(this.hQG.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.hRn);
        writeData.setThreadId(this.hQk);
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

    public MarkData wJ(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.hQG == null) {
            return null;
        }
        ArrayList<PostData> bQz = this.hQG.bQz();
        if (com.baidu.tbadk.core.util.v.isEmpty(bQz)) {
            return null;
        }
        if (bQz.size() > 0 && i >= bQz.size()) {
            i = bQz.size() - 1;
        }
        return j(bQz.get(i));
    }

    public MarkData bTQ() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hQk);
        markData.setPostId(this.hQG.afj());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hQp);
        markData.setSequence(Boolean.valueOf(bUn()));
        markData.setId(this.hQk);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hQk);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hQp);
        markData.setSequence(Boolean.valueOf(bUn()));
        markData.setId(this.hQk);
        markData.setFloor(postData.con());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void bTR() {
        g.bTi().an(bTS(), this.isFromMark);
    }

    private String bTS() {
        String str = this.hQk;
        if (this.hQp) {
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

    public void or(boolean z) {
        if (this.hQG != null) {
            this.hQG.dO(z);
        }
    }

    public void os(boolean z) {
        this.hQR = z;
    }

    public boolean bTT() {
        return this.hQR;
    }

    public void a(a aVar) {
        this.hQM = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aus() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aur() {
        return loadData();
    }

    public boolean AN(String str) {
        if (getPbData() == null || getPbData().bQx() == null || getPbData().bQx().aiE() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bQx().aiE().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int bTU() {
        return this.mRequestType;
    }

    public void bTV() {
        String bTS = bTS();
        g.bTi().an(bTS, false);
        g.bTi().an(bTS, true);
    }

    public void bTW() {
        if ("personalize_page".equals(this.mStType)) {
            this.hQX = System.currentTimeMillis() / 1000;
        }
    }

    public void bTX() {
        if ("personalize_page".equals(this.mStType) && this.hQG != null && this.hQX != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").bS("fid", this.hQG.getForumId()).bS("tid", this.hQk).bS("obj_duration", String.valueOf(currentTimeMillis - this.hQX)).bS(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.hQX = 0L;
        }
    }

    public boolean bTY() {
        return this.hRa;
    }

    public int getErrorNo() {
        return this.hRc;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bTZ() {
        return this.hRe;
    }

    public m bUa() {
        return this.hRf;
    }

    public z bUb() {
        return this.hRg;
    }

    public CheckRealNameModel bUc() {
        return this.hRi;
    }

    public AddExperiencedModel bUd() {
        return this.hRj;
    }

    public String bUe() {
        return this.hQW;
    }

    public void AO(String str) {
        this.hQW = str;
    }

    public boolean bUf() {
        return this.hRb;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hQG != null && this.hQG.bQz() != null && this.hQG.bQz().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hQG.bQz().size();
                for (int i = 0; i < size; i++) {
                    if (this.hQG.bQz().get(i) != null && this.hQG.bQz().get(i).aiE() != null && currentAccount.equals(this.hQG.bQz().get(i).aiE().getUserId()) && this.hQG.bQz().get(i).aiE().getPendantData() != null) {
                        this.hQG.bQz().get(i).aiE().getPendantData().mU(lVar.ahd());
                        this.hQG.bQz().get(i).aiE().getPendantData().aZ(lVar.atC());
                    }
                }
            }
        }
    }

    public String bUg() {
        return this.hRh;
    }

    public int bUh() {
        return this.hRn;
    }

    public void wK(int i) {
        this.hRn = i;
    }

    public void AP(String str) {
        if ((!this.hQp || AN(TbadkCoreApplication.getCurrentAccount())) && this.hQG.bQz() != null) {
            this.hQG.getPage().hB(1);
            if (this.hQG.getPage().ahy() == 0) {
                this.hQG.getPage().hB(1);
            }
            this.hRo = str;
            wF(8);
        }
    }

    private void wL(int i) {
        if (i != 8) {
            this.hRo = "";
            if (this.hRp != null) {
                if (i == 1 && !this.hQr && !com.baidu.tbadk.core.util.v.isEmpty(getPbData().bQz())) {
                    getPbData().bQz().remove(this.hRp);
                    if (this.hRq != null) {
                        getPbData().bQz().remove(this.hRq);
                    }
                    getPbData().bQz().add(0, this.hRp);
                } else {
                    getPbData().bQz().remove(this.hRp);
                    if (this.hRq != null) {
                        getPbData().bQz().remove(this.hRq);
                    }
                }
            }
            this.hRq = null;
        }
    }

    public void bUi() {
        if (this.hQG != null && !com.baidu.tbadk.core.util.v.isEmpty(this.hQG.bQz())) {
            if (this.hRq != null) {
                this.hQG.bQz().remove(this.hRq);
                this.hRq = null;
            }
            if (this.hRp != null) {
                this.hQG.bQz().remove(this.hRp);
                this.hRp = null;
            }
        }
    }

    public void bY(int i, int i2) {
        this.hRr = i;
        this.hRs = i2;
    }

    public PostData bUj() {
        return this.hRp;
    }

    public PostData bUk() {
        return this.hRq;
    }

    public int bUl() {
        return this.hRr;
    }

    public String bUm() {
        return this.hRt;
    }

    public void AQ(String str) {
        this.hRt = str;
    }

    private boolean bUn() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean bUo() {
        return this.hRn == 13 || this.hRn == 12;
    }
}
