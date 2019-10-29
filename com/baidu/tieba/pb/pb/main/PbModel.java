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
    private int eTb;
    private long fNH;
    private com.baidu.tieba.tbadkCore.d.b fcZ;
    private boolean gXB;
    private boolean hRA;
    private boolean hRB;
    private boolean hRC;
    private a hRD;
    private String hRE;
    private String hRF;
    private int hRG;
    private int hRH;
    private boolean hRI;
    private boolean hRJ;
    private boolean hRK;
    private boolean hRL;
    private boolean hRM;
    private String hRN;
    private long hRO;
    private boolean hRP;
    private int hRQ;
    private boolean hRR;
    private boolean hRS;
    private int hRT;
    private final x hRU;
    private final h hRV;
    private final m hRW;
    private final z hRX;
    private String hRY;
    private final CheckRealNameModel hRZ;
    protected String hRb;
    private String hRc;
    private String hRd;
    private String hRe;
    private boolean hRf;
    private boolean hRg;
    private boolean hRh;
    private boolean hRi;
    private int hRj;
    private boolean hRk;
    private int hRl;
    private long hRm;
    private int hRn;
    private int hRo;
    private int hRp;
    private boolean hRq;
    private boolean hRr;
    private boolean hRs;
    private boolean hRt;
    private long hRu;
    private boolean hRv;
    private String hRw;
    protected com.baidu.tieba.pb.data.d hRx;
    private int hRy;
    private boolean hRz;
    private final AddExperiencedModel hSa;
    private SuggestEmotionModel hSb;
    private GetSugMatchWordsModel hSc;
    private boolean hSd;
    private int hSe;
    private String hSf;
    private PostData hSg;
    private PostData hSh;
    private int hSi;
    private int hSj;
    private String hSk;
    private com.baidu.tieba.tbadkCore.data.m hSl;
    private CustomMessageListener hSm;
    private CustomMessageListener hSn;
    private com.baidu.adp.framework.listener.a hSo;
    private PraiseData hSp;
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
    private static final int hRa = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.hRb = null;
        this.hRc = null;
        this.hRd = null;
        this.mForumId = null;
        this.hRe = null;
        this.hRf = false;
        this.hRg = false;
        this.hRh = true;
        this.hRi = true;
        this.mSortType = 0;
        this.hRj = 0;
        this.hRk = false;
        this.mIsGood = 0;
        this.hRl = 0;
        this.hRm = 0L;
        this.hRn = 1;
        this.hRo = 1;
        this.hRp = 1;
        this.eTb = 1;
        this.isAd = false;
        this.gXB = false;
        this.hRq = false;
        this.hRr = false;
        this.isFromMark = false;
        this.hRs = false;
        this.hRt = false;
        this.hRu = 0L;
        this.hRv = false;
        this.hRw = null;
        this.hRx = null;
        this.isLoading = false;
        this.hRz = false;
        this.hRA = false;
        this.hRB = false;
        this.hRC = false;
        this.mLocate = null;
        this.mContext = null;
        this.hRD = null;
        this.opType = null;
        this.opUrl = null;
        this.hRE = null;
        this.hRF = null;
        this.hRG = -1;
        this.hRH = -1;
        this.fcZ = null;
        this.hRJ = false;
        this.hRK = false;
        this.postID = null;
        this.hRN = null;
        this.hRO = 0L;
        this.hRP = false;
        this.hRQ = -1;
        this.hRS = false;
        this.hSd = false;
        this.hSe = 0;
        this.hSm = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.hRM = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null && pbData.hJo == null) {
                    PbModel.this.l(pbData);
                    PbModel.this.h(pbData);
                    if (pbData.bQz() != null) {
                        pbData.bQz().hG(0);
                    }
                    if (PbModel.this.hRD != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.hRD.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.hSn = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.hSo = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
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
                    if (!PbModel.this.hRJ || !PbModel.this.hRK) {
                        if (!PbModel.this.hRJ) {
                            PbModel.this.hRJ = true;
                        } else {
                            PbModel.this.hRK = true;
                        }
                        if (PbModel.this.hRD != null) {
                            PbModel.this.hRD.a(PbModel.this.bTx(), z, responsedMessage, PbModel.this.hRL, System.currentTimeMillis() - PbModel.this.fNH);
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
                    if (PbModel.this.hRx != null && PbModel.this.hRx.bQy() != null && PbModel.this.hRx.bQy().getForumId() != null && PbModel.this.hRx.bQy().getForumId().equals(valueOf)) {
                        PbModel.this.hRx.bQy().setIsLike(false);
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
                    if (PbModel.this.hRx != null && PbModel.this.hRx.bQy() != null && PbModel.this.hRx.bQy().getForumId() != null && PbModel.this.hRx.bQy().getForumId().equals(valueOf)) {
                        PbModel.this.hRx.bQy().setIsLike(true);
                    }
                }
            }
        };
        this.hSp = null;
        registerListener(this.hSm);
        registerListener(this.hSo);
        registerListener(this.hSn);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.hRx = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mActivity = baseActivity;
        this.hRU = new x(this, this.mActivity);
        this.hRV = new h(this, this.mActivity);
        this.hRW = new m(this, this.mActivity);
        this.hRX = new z(this, this.mActivity);
        this.hRZ = new CheckRealNameModel(this.mActivity.getPageContext());
        this.hSb = new SuggestEmotionModel();
        this.hSa = new AddExperiencedModel(this.mActivity.getPageContext());
    }

    protected int bTx() {
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
            this.hRb = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.k(data)) {
                com.baidu.tbadk.BdToken.f.aep().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.bSq) instanceof String)) {
                            PbModel.this.hRb = (String) hashMap.get(com.baidu.tbadk.BdToken.f.bSq);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.hRb)) {
                this.hRb = this.hRU.aC(intent);
                if (StringUtils.isNull(this.hRb) && intent.getData() != null) {
                    this.hRb = data.getQueryParameter("thread_id");
                }
            }
            this.hSe = intent.getIntExtra("key_start_from", 0);
            if (this.hSe == 0) {
                this.hSe = this.hRU.hSv;
            }
            this.hRd = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.hRc = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.hRf = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.hRg = intent.getBooleanExtra("host_only", false);
            this.hRi = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.axp().aoP() ? 2 : 0);
            if (this.mSortType == 2) {
                this.hRd = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.hRl = intent.getIntExtra("is_top", 0);
            this.hRm = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.hRs = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.hRt = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.gXB = intent.getBooleanExtra("is_sub_pb", false);
            this.hRv = intent.getBooleanExtra("is_pv", false);
            this.hRu = intent.getLongExtra("msg_id", 0L);
            this.hRw = intent.getStringExtra("from_forum_name");
            this.hRF = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.hRE = intent.getStringExtra("op_stat");
            this.hRz = intent.getBooleanExtra("is_from_thread_config", false);
            this.hRA = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.hRB = intent.getBooleanExtra("is_from_my_god_config", false);
            this.hRH = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.hRG = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.hRq = intent.getBooleanExtra("from_frs", false);
            this.hRr = intent.getBooleanExtra("from_maintab", false);
            this.hRS = intent.getBooleanExtra("from_smart_frs", false);
            this.hRC = intent.getBooleanExtra("from_hottopic", false);
            this.hRY = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.hRe = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.hSe = bundle.getInt("key_start_from", 0);
        this.hRb = bundle.getString("thread_id");
        this.hRd = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.hRc = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.hRf = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.hRg = bundle.getBoolean("host_only", false);
        this.hRi = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.hRl = bundle.getInt("is_top", 0);
        this.hRm = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.hRt = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.gXB = bundle.getBoolean("is_sub_pb", false);
        this.hRv = bundle.getBoolean("is_pv", false);
        this.hRu = bundle.getLong("msg_id", 0L);
        this.hRw = bundle.getString("from_forum_name");
        this.hRF = bundle.getString("extra_pb_cache_key");
        this.hRz = bundle.getBoolean("is_from_thread_config", false);
        this.hRA = bundle.getBoolean("is_from_interview_live_config", false);
        this.hRB = bundle.getBoolean("is_from_my_god_config", false);
        this.hRH = bundle.getInt("extra_pb_is_attention_key", -1);
        this.hRG = bundle.getInt("extra_pb_funs_count_key", -1);
        this.hRq = bundle.getBoolean("from_frs", false);
        this.hRr = bundle.getBoolean("from_maintab", false);
        this.hRS = bundle.getBoolean("from_smart_frs", false);
        this.hRC = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.hRe = bundle.getString("high_light_post_id");
    }

    public void aa(Bundle bundle) {
        bundle.putString("thread_id", this.hRb);
        bundle.putString("post_id", this.hRd);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.hSe);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.hRf);
        bundle.putBoolean("host_only", this.hRg);
        bundle.putBoolean("squence", this.hRi);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.hRl);
        bundle.putLong("thread_time", this.hRm);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.hRt);
        bundle.putBoolean("is_sub_pb", this.gXB);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.hRv);
        bundle.putLong("msg_id", this.hRu);
        bundle.putString("extra_pb_cache_key", this.hRF);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.hRz);
        bundle.putBoolean("is_from_interview_live_config", this.hRA);
        bundle.putBoolean("is_from_my_god_config", this.hRB);
        bundle.putInt("extra_pb_is_attention_key", this.hRH);
        bundle.putInt("extra_pb_funs_count_key", this.hRG);
        bundle.putBoolean("from_frs", this.hRq);
        bundle.putBoolean("from_maintab", this.hRr);
        bundle.putBoolean("from_smart_frs", this.hRS);
        bundle.putBoolean("from_hottopic", this.hRC);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.hRe);
    }

    public String bTy() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.hRb);
        if (!this.hRt) {
            sb.append(this.hRd);
        }
        sb.append(this.hRg);
        sb.append(this.hRi);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.hRl);
        sb.append(this.hRm);
        sb.append(this.hRq);
        sb.append(this.hRr);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.gXB);
        sb.append(this.hRv);
        sb.append(this.hRu);
        sb.append(this.hRw);
        sb.append(this.mThreadType);
        sb.append(this.hRz);
        sb.append(this.hRA);
        sb.append(this.hRB);
        if (this.hRF != null) {
            sb.append(this.hRF);
        }
        return sb.toString();
    }

    public String bRw() {
        return this.hRw;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.hRd;
    }

    public String bTz() {
        return this.hRe;
    }

    public String bTA() {
        return this.hRb;
    }

    public boolean getHostMode() {
        return this.hRg;
    }

    public boolean bTB() {
        return bUp();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bTC() {
        return this.hRq;
    }

    public boolean bTD() {
        return this.hRk;
    }

    public boolean bTE() {
        return this.hRr;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bTF() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bdP() {
        return this.hRl;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void pb(int i) {
        this.hRl = i;
    }

    public boolean bTG() {
        return this.gXB;
    }

    public boolean bTH() {
        if (this.hRx == null) {
            return false;
        }
        return this.hRx.isValid();
    }

    public String aiP() {
        if (this.hRx == null || !this.hRx.afm()) {
            return null;
        }
        return this.hRx.afl();
    }

    public boolean wE(int i) {
        this.hRn = i;
        if (this.hRn > this.hRx.getPage().ahv()) {
            this.hRn = this.hRx.getPage().ahv();
        }
        if (this.hRn < 1) {
            this.hRn = 1;
        }
        if (this.hRb == null) {
            return false;
        }
        return wG(5);
    }

    public void wF(int i) {
        this.hRn = i;
        this.hRo = i;
        this.hRp = i;
    }

    public void b(com.baidu.tbadk.core.data.an anVar) {
        if (anVar == null) {
            wF(1);
            return;
        }
        if (this.hRo < anVar.ahy()) {
            this.hRo = anVar.ahy();
        }
        if (this.hRp > anVar.ahy()) {
            this.hRp = anVar.ahy();
        }
        this.eTb = anVar.ahv();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.hRx;
    }

    public com.baidu.tieba.pb.data.d bTI() {
        if (this.hRx == null) {
            return this.hRx;
        }
        if (!bTJ() && this.hSl != null) {
            this.hRx.b(this.hSl);
        }
        return this.hRx;
    }

    private boolean bTJ() {
        return (this.hRx.bQO() == null || this.hRx.bQO().cod() == null || this.hRx.bQO().cod().goods != null || this.hRx.bQO().cod().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.an getPageData() {
        if (this.hRx == null) {
            return null;
        }
        return this.hRx.getPage();
    }

    public boolean bTK() {
        if (bUp() && this.hRx.getPage().ahA() == 0) {
            op(true);
            return true;
        }
        return false;
    }

    public void AG(String str) {
        if (!StringUtils.isNull(str)) {
            this.hRb = str;
            this.hRd = null;
            this.hRg = false;
            this.hRi = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hRb == null) {
            return false;
        }
        cancelLoadData();
        if (this.fcZ == null) {
            this.fcZ = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.fcZ.start();
        }
        boolean wG = wG(3);
        if (this.opType != null) {
            this.opType = null;
            this.hRE = null;
            this.opUrl = null;
            return wG;
        }
        return wG;
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
        if (this.hSb != null) {
            this.hSb.cancelLoadData();
        }
        if (this.hSc != null) {
            this.hSc.cancelLoadData();
        }
        beS();
    }

    private void beS() {
        if (this.fcZ != null) {
            this.fcZ.destory();
            this.fcZ = null;
        }
    }

    public boolean loadData() {
        return (this.hRd == null || this.hRd.equals("0") || this.hRd.length() == 0) ? LoadData() : bTP();
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
                this.hSb.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.hSb.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.hSc == null) {
                this.hSc = new GetSugMatchWordsModel(this.mActivity.getPageContext());
            }
            this.hSc.b(aVar);
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
    public boolean wG(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        wH(i);
        final com.baidu.tieba.pb.data.d pbData = aj.bUK().getPbData();
        if (pbData != null && pbData.bQz() != null) {
            pbData.bQz().hG(0);
            this.hRi = aj.bUK().bTB();
            this.hRg = aj.bUK().bUP();
            this.hRk = aj.bUK().bUQ();
            this.hSg = aj.bUK().bUO();
            this.hSh = aj.bUK().bUN();
            this.hSi = aj.bUK().bUM();
            this.hSd = this.hRg;
            if (this.hRg || this.isFromMark) {
                this.hRI = false;
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
        if (i == 4 && !this.hRM) {
            a(bTU(), true, this.hRd, 3);
        }
        if (i == 3 && !this.hRM) {
            if (this.isFromMark) {
                a(bTU(), true, this.hRd, 3);
            } else {
                a(bTU(), false, this.hRd, 3);
            }
        }
        this.hRM = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.hSl == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.cEo);
        if (this.hRg || this.isFromMark) {
            this.hRI = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.hRb == null || this.hRb.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.toLong(this.hRb, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.ar.amO().isFrsShowBigImage() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(equipmentWidth));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(equipmentHeight));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.hRi) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.hRg) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.hRv) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.hRu));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.hRI) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.toInt(this.hRE, 0));
            pbPageRequestMessage.setOpMessageID(this.hRu);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bQB = this.hRx.bQB();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hRp - 1));
                        if (this.hRp - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.hRs) {
                                if (bQB != null && bQB.size() > 0) {
                                    size = bQB.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bQB.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.hRd = postData.getId();
                                            if (StringUtils.isNull(this.hRd)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.hRo + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.hRd == null && this.hRd.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.toLong(this.hRd, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hRo + 1));
                        if (this.hRo >= this.eTb) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bQB != null) {
                                size = bQB.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.hRd == null) {
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
                if (bQB != null) {
                }
                if (this.hRd == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bQB != null && bQB.size() > 0 && bQB.get(0) != null) {
                    this.hRd = bQB.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bUp()) {
                        if (this.hRp - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.hRp - 1));
                        }
                    } else if (this.hRo < this.eTb) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hRo + 1));
                    }
                }
                if (this.hRd != null && this.hRd.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.toLong(this.hRd, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.hRg) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bUp()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.eTb > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eTb));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.toLong(this.hRd, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.hRn));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.hSd && !this.hRg) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.toLong(this.hRd, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.hRg) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.hRQ);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.toLong(this.hSf, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.hSd = this.hRg;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bTU());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.hSe));
        pbPageRequestMessage.setIsSubPostDataReverse(this.hRP);
        pbPageRequestMessage.setFromSmartFrs(this.hRS ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.hRf);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.hRb);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bRv() {
        switch (bUj()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bQz() == null || !getPbData().bQz().ajX();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bRw()) && com.baidu.tieba.recapp.r.cfL().cfF() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cfL().cfF().as(bRw(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cfL().cfF().at(bRw(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bRw()) && com.baidu.tieba.recapp.r.cfL().cfF() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cfL().cfF().at(bRw(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cfL().cfF().as(bRw(), true));
        }
    }

    protected void wH(int i) {
        boolean z = false;
        wM(i);
        ArrayList<PostData> bQB = this.hRx.bQB();
        this.hRL = false;
        if (i == 1) {
            boolean z2 = false;
            while (bQB.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                bQB.remove(0);
                z2 = true;
            }
            if (z2) {
                this.hRx.getPage().hD(1);
                if (this.hRD != null) {
                    this.hRD.e(this.hRx);
                }
            }
            this.fNH = System.currentTimeMillis();
            this.hRL = true;
        } else if (i == 2) {
            while (bQB.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                bQB.remove(bQB.size() - 1);
                z = true;
            }
            if (z) {
                this.hRx.getPage().hC(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.hRT = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            h(dVar2);
        }
        g(dVar2);
        if (this.hSl != null && this.hSl.aEG()) {
            TiebaStatic.log(com.baidu.tieba.q.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bQO() != null && dVar.bQO().cod() != null && dVar.bQO().cod().goods != null && dVar.bQO().aEG() && dVar.bQO().cod().goods.goods_style != 1001) {
            this.hSl = dVar.bQO();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m bTL() {
        return this.hSl;
    }

    public void bTM() {
        this.hSl = null;
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
            if (this.hRB || this.hRz || this.hRA) {
                dVar = j(dVar);
            }
            i(dVar);
        }
    }

    protected void i(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String k = k(dVar);
            for (int i = 0; i < dVar.bQB().size(); i++) {
                PostData postData = dVar.bQB().get(i);
                for (int i2 = 0; i2 < postData.com().size(); i2++) {
                    postData.com().get(i2).a(this.mActivity.getPageContext(), k.equals(postData.com().get(i2).aiG().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.m bQK = dVar.bQK();
            if (bQK != null && !com.baidu.tbadk.core.util.v.isEmpty(bQK.hJX)) {
                for (PostData postData2 : bQK.hJX) {
                    for (int i3 = 0; i3 < postData2.com().size(); i3++) {
                        postData2.com().get(i3).a(this.mActivity.getPageContext(), k.equals(postData2.com().get(i3).aiG().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String k = k(dVar);
            com.baidu.tieba.pb.data.m bQK = dVar.bQK();
            if (bQK != null && !com.baidu.tbadk.core.util.v.isEmpty(bQK.hJX)) {
                for (PostData postData : bQK.hJX.subList(i, bQK.hJX.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.com().size()) {
                            postData.com().get(i3).a(this.mActivity.getPageContext(), k.equals(postData.com().get(i3).aiG().getUserId()));
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
        bh bQz = dVar.bQz();
        bQz.hL(this.mIsGood);
        bQz.hK(this.hRl);
        if (this.hRm > 0) {
            bQz.aK(this.hRm);
            return dVar;
        }
        return dVar;
    }

    protected String k(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bQz() != null && dVar.bQz().aiG() != null) {
            str = dVar.bQz().aiG().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bTN() {
        if (this.hRx == null || this.hRx.bQz() == null || this.hRx.bQz().aiG() == null) {
            return null;
        }
        return this.hRx.bQz().aiG();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.hRR = z3;
        this.hRy = i;
        if (this.fcZ != null && !z3) {
            this.fcZ.a(z2, z4, i2, str, i3, j, j2);
            this.fcZ = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bRw()) && com.baidu.tieba.recapp.r.cfL().cfF() != null) {
            com.baidu.tieba.recapp.r.cfL().cfF().f(bRw(), wI(bTW()), true);
        }
        if (dVar == null || (this.hRn == 1 && i == 5 && dVar.bQB() != null && dVar.bQB().size() < 1)) {
            if (this.hRD != null) {
                this.hRi = this.hRh;
                if (i2 != 350006) {
                    this.mSortType = this.hRj;
                }
                this.hRD.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.hRh = this.hRi;
            if (i != 8) {
                this.hRj = this.mSortType;
                this.mSortType = dVar.hJn;
            }
            if (dVar.hJm != null && dVar.hJm.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.mActivity.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                dVar.hJm = new ArrayList();
                dVar.hJm.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.mActivity.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                dVar.hJm.add(builder2.build(false));
                this.mSortType = this.hRj;
                dVar.hJn = this.mSortType;
            }
            this.hRv = false;
            if (dVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(dVar.getPage());
            }
            this.eTb = this.eTb < 1 ? 1 : this.eTb;
            ArrayList<PostData> bQB = this.hRx.bQB();
            switch (i) {
                case 1:
                    this.hRx.a(dVar.getPage(), 1);
                    d(dVar, bQB);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bQB() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bQB().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(bQB, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(dVar.bQB(), com.baidu.tbadk.core.util.v.getCount(dVar.bQB()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bQB().remove(postData2);
                            i6 = size - 1;
                        }
                        bQB.addAll(0, dVar.bQB());
                    }
                    this.hRx.a(dVar.getPage(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.getPage() != null) {
                        dVar.getPage().hA(dVar.getPage().ahv());
                    }
                    l(dVar);
                    if (!z3 && this.mThreadType != 33 && bUp()) {
                        bTO();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.isEmpty(dVar.bQB()) && this.hRx != null && (!this.hRg || k(dVar).equals(dVar.bQB().get(0).aiG().getUserId()))) {
                        if (this.hRx.getPage().ahA() == 0) {
                            this.hRx.getPage().hC(1);
                        }
                        bUk();
                        this.hSg = dVar.bQB().get(0);
                        if (bUp()) {
                            if (this.hRx.bQB().size() - this.hSi >= 3) {
                                this.hSh = new PostData();
                                this.hSh.jiP = true;
                                this.hSh.setPostType(53);
                                this.hRx.bQB().add(this.hSh);
                            }
                            this.hRx.bQB().add(this.hSg);
                            i4 = this.hRx.bQB().size() - 1;
                        } else {
                            if (this.hSi - this.hSj >= 3) {
                                this.hSh = new PostData();
                                this.hSh.jiP = false;
                                this.hSh.setPostType(53);
                                this.hRx.bQB().add(0, this.hSh);
                            }
                            this.hRx.bQB().add(0, this.hSg);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.isTaday(com.baidu.tbadk.core.sharedPref.b.alR().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.hSg.jjb = this.hRx.bQY();
                            com.baidu.tbadk.core.sharedPref.b.alR().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.hRx != null && this.hRx.bQz() != null) {
                PraiseData ais = this.hRx.bQz().ais();
                if (this.hSp != null && !ais.isPriaseDataValid()) {
                    this.hRx.bQz().a(this.hSp);
                } else {
                    this.hSp = this.hRx.bQz().ais();
                    this.hSp.setPostId(this.hRx.bQz().aiW());
                }
                if (dVar.getPage() != null && dVar.getPage().ahy() == 1 && dVar.bQz() != null && dVar.bQz().aiR() != null && dVar.bQz().aiR().size() > 0) {
                    this.hRx.bQz().t(dVar.bQz().aiR());
                }
                this.hRx.bQz().hI(dVar.bQz().aix());
                this.hRx.bQz().hE(dVar.bQz().getAnchorLevel());
                this.hRx.bQz().hG(dVar.bQz().aio());
                if (this.mThreadType == 33) {
                    this.hRx.bQz().aiG().setHadConcerned(dVar.bQz().aiG().hadConcerned());
                }
                if (dVar != null && dVar.bQz() != null) {
                    this.hRx.bQz().hN(dVar.bQz().aiV());
                }
            }
            if (this.hRx != null && this.hRx.getUserData() != null && dVar.getUserData() != null) {
                this.hRx.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.hRx.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.getPage() != null && dVar.getPage().ahy() == 1 && dVar.bQJ() != null) {
                this.hRx.d(dVar.bQJ());
            }
            if (this.hRR) {
                if (this.hRx.bQz() != null && this.hRx.bQz().aiG() != null && this.hRx.bQB() != null && com.baidu.tbadk.core.util.v.getItem(this.hRx.bQB(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(this.hRx.bQB(), 0);
                    MetaData aiG = this.hRx.bQz().aiG();
                    if (postData3.aiG() != null && postData3.aiG().getGodUserData() != null) {
                        if (this.hRG != -1) {
                            aiG.setFansNum(this.hRG);
                            postData3.aiG().setFansNum(this.hRG);
                        }
                        if (this.hRH != -1) {
                            aiG.getGodUserData().setIsLike(this.hRH == 1);
                            postData3.aiG().getGodUserData().setIsLike(this.hRH == 1);
                            aiG.getGodUserData().setIsFromNetWork(false);
                            postData3.aiG().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.hRx.hJl = -1;
                this.hRx.hJk = -1;
            }
            if (this.hRD != null) {
                this.hRD.a(true, getErrorCode(), i, i5, this.hRx, this.mErrorString, 1);
            }
        }
        if (this.hRx != null && this.hRx.bQz() != null && this.hRx.getForum() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mActivity.getPageContext();
            historyMessage.threadId = getPbData().bQz().getId();
            if (this.mIsShareThread && getPbData().bQz().cec != null) {
                historyMessage.threadName = getPbData().bQz().cec.showText;
            } else {
                historyMessage.threadName = getPbData().bQz().getTitle();
            }
            if (this.mIsShareThread && !bRv()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bTB();
            historyMessage.threadType = getPbData().bQz().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String aA;
        if (arrayList != null && dVar.bQB() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(dVar.bQB(), 0);
            if (postData != null && (aA = aA(arrayList)) != null && aA.equals(postData.getId())) {
                dVar.bQB().remove(postData);
            }
            arrayList.addAll(dVar.bQB());
        }
    }

    private int wI(int i) {
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
        dVar.AD(this.hRx.bQR());
        this.hRx = dVar;
        wF(dVar.getPage().ahy());
    }

    private void bTO() {
        if (this.hRx != null && this.hRx.bQB() != null && this.hRx.bQQ() != null) {
            ArrayList<PostData> bQB = this.hRx.bQB();
            com.baidu.tieba.pb.data.a bQQ = this.hRx.bQQ();
            int bQw = bQQ.bQw();
            if (bQw > 0) {
                if (bQw <= bQB.size()) {
                    bQB.add(bQw, bQQ);
                } else {
                    bQB.add(bQQ);
                }
            }
        }
    }

    public boolean bTP() {
        if (this.hRb == null || this.hRd == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return wG(4);
        }
        return wG(6);
    }

    public boolean op(boolean z) {
        if (this.hRb == null || this.hRx == null) {
            return false;
        }
        if (z || this.hRx.getPage().ahA() != 0) {
            return wG(1);
        }
        return false;
    }

    public boolean oq(boolean z) {
        if (this.hRb == null || this.hRx == null) {
            return false;
        }
        if ((z || this.hRx.getPage().ahB() != 0) && this.hRx.bQB() != null && this.hRx.bQB().size() >= 1) {
            return wG(2);
        }
        return false;
    }

    public boolean AM(String str) {
        this.hRg = !this.hRg;
        this.hRd = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").O("obj_source", 0));
        if (wG(6)) {
            return true;
        }
        this.hRg = this.hRg ? false : true;
        return false;
    }

    public boolean u(boolean z, String str) {
        if (this.hRg == z) {
            return false;
        }
        this.hRg = z;
        this.hRd = str;
        if (this.mSortType == 2) {
            this.hRd = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").O("obj_source", 1));
        }
        if (wG(6)) {
            return true;
        }
        this.hRg = z ? false : true;
        return false;
    }

    public boolean wJ(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.hRh = this.hRi;
        this.hRj = this.mSortType;
        this.mSortType = i;
        this.hRi = !this.hRi;
        if (i == 2 && this.isFromMark) {
            this.hRd = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.hRi = this.hRi ? false : true;
            this.mSortType = this.hRj;
            return false;
        }
        return true;
    }

    public boolean bTQ() {
        return bUp();
    }

    public int bTR() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.hRx == null || this.hRx.getForum() == null || this.hRx.bQz() == null) ? false : true;
    }

    public boolean afm() {
        if (this.hRx == null) {
            return false;
        }
        return this.hRx.afm();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pG(String str) {
        if (this.hRx == null || this.hRx.bQz() == null || this.hRx.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.hRx.bQz().ajX()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.hRx.getForum().getId());
            writeData.setForumName(this.hRx.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.hSe);
        writeData.setThreadId(this.hRb);
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

    public MarkData wK(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.hRx == null) {
            return null;
        }
        ArrayList<PostData> bQB = this.hRx.bQB();
        if (com.baidu.tbadk.core.util.v.isEmpty(bQB)) {
            return null;
        }
        if (bQB.size() > 0 && i >= bQB.size()) {
            i = bQB.size() - 1;
        }
        return j(bQB.get(i));
    }

    public MarkData bTS() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hRb);
        markData.setPostId(this.hRx.afl());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hRg);
        markData.setSequence(Boolean.valueOf(bUp()));
        markData.setId(this.hRb);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hRb);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hRg);
        markData.setSequence(Boolean.valueOf(bUp()));
        markData.setId(this.hRb);
        markData.setFloor(postData.cop());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void bTT() {
        g.bTk().an(bTU(), this.isFromMark);
    }

    private String bTU() {
        String str = this.hRb;
        if (this.hRg) {
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
        if (this.hRx != null) {
            this.hRx.dO(z);
        }
    }

    public void os(boolean z) {
        this.hRI = z;
    }

    public boolean bTV() {
        return this.hRI;
    }

    public void a(a aVar) {
        this.hRD = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String auu() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aut() {
        return loadData();
    }

    public boolean AN(String str) {
        if (getPbData() == null || getPbData().bQz() == null || getPbData().bQz().aiG() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bQz().aiG().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int bTW() {
        return this.mRequestType;
    }

    public void bTX() {
        String bTU = bTU();
        g.bTk().an(bTU, false);
        g.bTk().an(bTU, true);
    }

    public void bTY() {
        if ("personalize_page".equals(this.mStType)) {
            this.hRO = System.currentTimeMillis() / 1000;
        }
    }

    public void bTZ() {
        if ("personalize_page".equals(this.mStType) && this.hRx != null && this.hRO != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").bS("fid", this.hRx.getForumId()).bS("tid", this.hRb).bS("obj_duration", String.valueOf(currentTimeMillis - this.hRO)).bS(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.hRO = 0L;
        }
    }

    public boolean bUa() {
        return this.hRR;
    }

    public int getErrorNo() {
        return this.hRT;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bUb() {
        return this.hRV;
    }

    public m bUc() {
        return this.hRW;
    }

    public z bUd() {
        return this.hRX;
    }

    public CheckRealNameModel bUe() {
        return this.hRZ;
    }

    public AddExperiencedModel bUf() {
        return this.hSa;
    }

    public String bUg() {
        return this.hRN;
    }

    public void AO(String str) {
        this.hRN = str;
    }

    public boolean bUh() {
        return this.hRS;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hRx != null && this.hRx.bQB() != null && this.hRx.bQB().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hRx.bQB().size();
                for (int i = 0; i < size; i++) {
                    if (this.hRx.bQB().get(i) != null && this.hRx.bQB().get(i).aiG() != null && currentAccount.equals(this.hRx.bQB().get(i).aiG().getUserId()) && this.hRx.bQB().get(i).aiG().getPendantData() != null) {
                        this.hRx.bQB().get(i).aiG().getPendantData().mU(lVar.ahf());
                        this.hRx.bQB().get(i).aiG().getPendantData().ba(lVar.atE());
                    }
                }
            }
        }
    }

    public String bUi() {
        return this.hRY;
    }

    public int bUj() {
        return this.hSe;
    }

    public void wL(int i) {
        this.hSe = i;
    }

    public void AP(String str) {
        if ((!this.hRg || AN(TbadkCoreApplication.getCurrentAccount())) && this.hRx.bQB() != null) {
            this.hRx.getPage().hC(1);
            if (this.hRx.getPage().ahA() == 0) {
                this.hRx.getPage().hC(1);
            }
            this.hSf = str;
            wG(8);
        }
    }

    private void wM(int i) {
        if (i != 8) {
            this.hSf = "";
            if (this.hSg != null) {
                if (i == 1 && !this.hRi && !com.baidu.tbadk.core.util.v.isEmpty(getPbData().bQB())) {
                    getPbData().bQB().remove(this.hSg);
                    if (this.hSh != null) {
                        getPbData().bQB().remove(this.hSh);
                    }
                    getPbData().bQB().add(0, this.hSg);
                } else {
                    getPbData().bQB().remove(this.hSg);
                    if (this.hSh != null) {
                        getPbData().bQB().remove(this.hSh);
                    }
                }
            }
            this.hSh = null;
        }
    }

    public void bUk() {
        if (this.hRx != null && !com.baidu.tbadk.core.util.v.isEmpty(this.hRx.bQB())) {
            if (this.hSh != null) {
                this.hRx.bQB().remove(this.hSh);
                this.hSh = null;
            }
            if (this.hSg != null) {
                this.hRx.bQB().remove(this.hSg);
                this.hSg = null;
            }
        }
    }

    public void ca(int i, int i2) {
        this.hSi = i;
        this.hSj = i2;
    }

    public PostData bUl() {
        return this.hSg;
    }

    public PostData bUm() {
        return this.hSh;
    }

    public int bUn() {
        return this.hSi;
    }

    public String bUo() {
        return this.hSk;
    }

    public void AQ(String str) {
        this.hSk = str;
    }

    private boolean bUp() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean bUq() {
        return this.hSe == 13 || this.hSe == 12;
    }
}
