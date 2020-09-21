package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.widget.richText.TbRichTextView;
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
/* loaded from: classes21.dex */
public class PbModel extends DataModel {
    public static final String DB_KEY_HOST = "_host";
    public static final String DB_KEY_HOT = "_hot";
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
    private boolean egs;
    private BaseFragmentActivity hEa;
    private com.baidu.tieba.tbadkCore.d.b hFh;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private long ivr;
    private boolean jOV;
    protected com.baidu.tieba.pb.data.f kJe;
    private boolean kPA;
    private int kPB;
    private long kPC;
    private int kPD;
    private int kPE;
    private int kPF;
    private int kPG;
    private boolean kPH;
    private boolean kPI;
    private boolean kPJ;
    private long kPK;
    private boolean kPL;
    private String kPM;
    private boolean kPN;
    private boolean kPO;
    private boolean kPP;
    private boolean kPQ;
    private a kPR;
    private String kPS;
    private String kPT;
    private int kPU;
    private int kPV;
    private boolean kPW;
    private boolean kPX;
    private boolean kPY;
    private boolean kPZ;
    protected String kPr;
    private String kPs;
    private String kPt;
    private String kPu;
    private boolean kPv;
    private boolean kPw;
    private boolean kPx;
    private boolean kPy;
    private int kPz;
    private boolean kQA;
    private String kQB;
    private String kQC;
    private String kQD;
    private String kQE;
    private String kQF;
    private f.a kQG;
    private CustomMessageListener kQH;
    private com.baidu.adp.framework.listener.a kQI;
    private PraiseData kQJ;
    private boolean kQa;
    private String kQb;
    private long kQc;
    private boolean kQd;
    private int kQe;
    private boolean kQf;
    private boolean kQg;
    private int kQh;
    private final ag kQi;
    private final q kQj;
    private final ai kQk;
    private String kQl;
    private final CheckRealNameModel kQm;
    private final AddExperiencedModel kQn;
    private SuggestEmotionModel kQo;
    private GetSugMatchWordsModel kQp;
    private boolean kQq;
    private int kQr;
    private String kQs;
    private PostData kQt;
    private PostData kQu;
    private int kQv;
    private int kQw;
    private Rect kQx;
    private String kQy;
    private com.baidu.tieba.tbadkCore.data.n kQz;
    private com.baidu.tieba.pb.data.d mAppealInfo;
    protected Context mContext;
    private String mForumId;
    private String mFromForumId;
    private int mIsGood;
    private boolean mIsShareThread;
    private CustomMessageListener mLikeForumListener;
    private String mLocate;
    private int mRequestType;
    private String mSchemeUrl;
    private int mSortType;
    public String mStType;
    private int mTabIndex;
    protected int mThreadType;
    private CustomMessageListener mUnlikeForumListener;
    private String opType;
    private String opUrl;
    private String oriUgcNid;
    private String oriUgcTid;
    private int oriUgcType;
    private String oriUgcVid;
    private String postID;
    private static final int kPq = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes21.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.f fVar);
    }

    public PbModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.mStType = null;
        this.kPr = null;
        this.isPrivacy = false;
        this.kPs = null;
        this.kPt = null;
        this.mForumId = null;
        this.kPu = null;
        this.kPv = false;
        this.kPw = false;
        this.kPx = true;
        this.kPy = true;
        this.mSortType = 0;
        this.kPz = 0;
        this.kPA = false;
        this.mIsGood = 0;
        this.kPB = 0;
        this.kPC = 0L;
        this.kPD = 1;
        this.kPE = 1;
        this.kPF = 1;
        this.kPG = 1;
        this.isAd = false;
        this.jOV = false;
        this.egs = false;
        this.kPH = false;
        this.isFromMark = false;
        this.kPI = false;
        this.kPJ = false;
        this.kPK = 0L;
        this.kPL = false;
        this.kPM = null;
        this.kJe = null;
        this.isLoading = false;
        this.kPN = false;
        this.kPO = false;
        this.kPP = false;
        this.kPQ = false;
        this.mLocate = null;
        this.mContext = null;
        this.kPR = null;
        this.opType = null;
        this.opUrl = null;
        this.kPS = null;
        this.kPT = null;
        this.kPU = -1;
        this.kPV = -1;
        this.hFh = null;
        this.kPX = false;
        this.kPY = false;
        this.postID = null;
        this.kQb = null;
        this.kQc = 0L;
        this.kQd = false;
        this.kQe = -1;
        this.kQg = false;
        this.kQq = false;
        this.kQr = 0;
        this.mTabIndex = 0;
        this.kQA = false;
        this.kQH = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.kQI = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.hEa.showToast(responsedMessage.getErrorString());
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
                        com.baidu.tbadk.core.d.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    }
                    if (!PbModel.this.kPX || !PbModel.this.kPY) {
                        if (!PbModel.this.kPX) {
                            PbModel.this.kPX = true;
                        } else {
                            PbModel.this.kPY = true;
                        }
                        if (PbModel.this.kPR != null) {
                            PbModel.this.kPR.a(PbModel.this.dca(), z, responsedMessage, PbModel.this.kPZ, System.currentTimeMillis() - PbModel.this.ivr);
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
                    if (PbModel.this.kJe != null && PbModel.this.kJe.cYQ() != null && PbModel.this.kJe.cYQ().getForumId() != null && PbModel.this.kJe.cYQ().getForumId().equals(valueOf)) {
                        PbModel.this.kJe.cYQ().setIsLike(false);
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
                    if (PbModel.this.kJe != null && PbModel.this.kJe.cYQ() != null && PbModel.this.kJe.cYQ().getForumId() != null && PbModel.this.kJe.cYQ().getForumId().equals(valueOf)) {
                        PbModel.this.kJe.cYQ().setIsLike(true);
                    }
                }
            }
        };
        this.kQJ = null;
        registerListener(this.kQI);
        registerListener(this.kQH);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.kJe = new com.baidu.tieba.pb.data.f();
        this.kJe.Eq(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.hEa = baseFragmentActivity;
        this.kQi = new ag(this, this.hEa);
        this.kQj = new q(this, this.hEa);
        this.kQk = new ai(this, this.hEa);
        this.kQm = new CheckRealNameModel(this.hEa.getPageContext());
        this.kQo = new SuggestEmotionModel();
        this.kQn = new AddExperiencedModel(this.hEa.getPageContext());
        this.kQG = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void z(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dRq) instanceof String) {
                        PbModel.this.kPr = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dRq);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dRr) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dRr);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dRs) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dRs);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dRt) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.dRt), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dRu) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dRu);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.kQa = true;
        if (fVar != null && fVar.kFp == null) {
            q(fVar);
            l(fVar);
            if (fVar.cYR() != null) {
                fVar.cYR().np(0);
            }
            if (this.kPR != null && fVar != null) {
                this.kPR.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int dca() {
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
            this.kPr = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.kQF = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                com.baidu.tbadk.BdToken.f.aZy().c(uri, this.kQG);
            } else if (StringUtils.isNull(this.kPr)) {
                this.kQi.a(intent, this.kQG);
                if (uri != null) {
                    if (StringUtils.isNull(this.kPr)) {
                        this.kPr = uri.getQueryParameter("thread_id");
                    }
                    if (StringUtils.isNull(this.oriUgcNid)) {
                        this.oriUgcNid = uri.getQueryParameter("key_ori_ugc_nid");
                    }
                    if (StringUtils.isNull(this.oriUgcTid)) {
                        this.oriUgcTid = uri.getQueryParameter("key_ori_ugc_tid");
                    }
                    if (this.oriUgcType == 0) {
                        this.oriUgcType = com.baidu.adp.lib.f.b.toInt(uri.getQueryParameter("key_ori_ugc_type"), 0);
                    }
                    if (StringUtils.isNull(this.oriUgcVid)) {
                        this.oriUgcVid = uri.getQueryParameter("key_ori_ugc_vid");
                    }
                }
            }
            if (com.baidu.tbadk.core.util.at.isEmpty(this.kPr)) {
                this.kPr = "0";
            }
            this.kQr = intent.getIntExtra("key_start_from", 0);
            if (this.kQr == 0) {
                this.kQr = this.kQi.aFO;
            }
            this.kPt = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.kPs = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.kPv = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.kPw = intent.getBooleanExtra("host_only", false);
            this.kPy = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.kPt = this.mSortType == 2 ? "0" : this.kPt;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.kPB = intent.getIntExtra("is_top", 0);
            this.kPC = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.kPI = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.kPJ = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.jOV = intent.getBooleanExtra("is_sub_pb", false);
            this.kPL = intent.getBooleanExtra("is_pv", false);
            this.kPK = intent.getLongExtra("msg_id", 0L);
            this.kPM = intent.getStringExtra("from_forum_name");
            this.kPT = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.kPS = intent.getStringExtra("op_stat");
            this.kPN = intent.getBooleanExtra("is_from_thread_config", false);
            this.kPO = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.kPP = intent.getBooleanExtra("is_from_my_god_config", false);
            this.kPV = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.kPU = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.egs = intent.getBooleanExtra("from_frs", false);
            this.kPH = intent.getBooleanExtra("from_maintab", false);
            this.kQg = intent.getBooleanExtra("from_smart_frs", false);
            this.kPQ = intent.getBooleanExtra("from_hottopic", false);
            this.kQl = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.kPu = intent.getStringExtra("high_light_post_id");
            this.kQA = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.kPW = intent.getIntExtra("request_code", -1) == 18003;
            this.kQB = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.kQC = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.kQD = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.kQE = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean dcb() {
        return this.kQA && com.baidu.tieba.frs.l.coU() != null && com.baidu.tieba.frs.l.coU().equals(this.kPr) && com.baidu.tieba.frs.l.coT() != null;
    }

    public com.baidu.tieba.pb.data.f aI(bw bwVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.Eq(3);
        if (bwVar == null) {
            return null;
        }
        fVar.aF(bwVar);
        if (bwVar.bhm() != null) {
            fVar.d(bwVar.bhm());
            ForumData forum = fVar.getForum();
            forum.setId(bwVar.bhm().getForumId());
            forum.setName(bwVar.bhm().getForumName());
            forum.setUser_level(bwVar.bhm().beO());
            forum.setImage_url(bwVar.bhm().getAvatar());
            forum.setPost_num(bwVar.bhm().postNum);
            forum.setMember_num(bwVar.bhm().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(bwVar.getFid()));
            forum2.setName(bwVar.bfC());
        }
        PostData postData = new PostData();
        postData.Is(1);
        postData.setTime(bwVar.getCreateTime());
        postData.a(bwVar.bfy());
        MetaData bfy = bwVar.bfy();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(bfy.getUserId(), bfy);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bwVar.bfo(), false));
        fVar.d(postData);
        fVar.cYT().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.o(bwVar, null));
        fVar.kFu = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.kQr = bundle.getInt("key_start_from", 0);
        this.kPr = bundle.getString("thread_id");
        this.kPt = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.kPs = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.kPv = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.kPw = bundle.getBoolean("host_only", false);
        this.kPy = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.kPB = bundle.getInt("is_top", 0);
        this.kPC = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.kPJ = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.jOV = bundle.getBoolean("is_sub_pb", false);
        this.kPL = bundle.getBoolean("is_pv", false);
        this.kPK = bundle.getLong("msg_id", 0L);
        this.kPM = bundle.getString("from_forum_name");
        this.kPT = bundle.getString("extra_pb_cache_key");
        this.kPN = bundle.getBoolean("is_from_thread_config", false);
        this.kPO = bundle.getBoolean("is_from_interview_live_config", false);
        this.kPP = bundle.getBoolean("is_from_my_god_config", false);
        this.kPV = bundle.getInt("extra_pb_is_attention_key", -1);
        this.kPU = bundle.getInt("extra_pb_funs_count_key", -1);
        this.egs = bundle.getBoolean("from_frs", false);
        this.kPH = bundle.getBoolean("from_maintab", false);
        this.kQg = bundle.getBoolean("from_smart_frs", false);
        this.kPQ = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.kPu = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.kPW = bundle.getInt("request_code", -1) == 18003;
        this.kQB = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.kQC = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.kQD = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.kQE = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aC(Bundle bundle) {
        bundle.putString("thread_id", this.kPr);
        bundle.putString("post_id", this.kPt);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.kQr);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.kPv);
        bundle.putBoolean("host_only", this.kPw);
        bundle.putBoolean("squence", this.kPy);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.kPB);
        bundle.putLong("thread_time", this.kPC);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.kPJ);
        bundle.putBoolean("is_sub_pb", this.jOV);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.kPL);
        bundle.putLong("msg_id", this.kPK);
        bundle.putString("extra_pb_cache_key", this.kPT);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.kPN);
        bundle.putBoolean("is_from_interview_live_config", this.kPO);
        bundle.putBoolean("is_from_my_god_config", this.kPP);
        bundle.putInt("extra_pb_is_attention_key", this.kPV);
        bundle.putInt("extra_pb_funs_count_key", this.kPU);
        bundle.putBoolean("from_frs", this.egs);
        bundle.putBoolean("from_maintab", this.kPH);
        bundle.putBoolean("from_smart_frs", this.kQg);
        bundle.putBoolean("from_hottopic", this.kPQ);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.kPu);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.kQB);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.kQC);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.kQD);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.kQE);
    }

    public String dcc() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.kPr);
        if (!this.kPJ) {
            sb.append(this.kPt);
        }
        sb.append(this.kPw);
        sb.append(this.kPy);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.kPB);
        sb.append(this.kPC);
        sb.append(this.egs);
        sb.append(this.kPH);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.jOV);
        sb.append(this.kPL);
        sb.append(this.kPK);
        sb.append(this.kPM);
        sb.append(this.mThreadType);
        sb.append(this.kPN);
        sb.append(this.kPO);
        sb.append(this.kPP);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.kPT != null) {
            sb.append(this.kPT);
        }
        return sb.toString();
    }

    public String cZY() {
        return this.kPM;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String dcd() {
        return this.kPt;
    }

    public String dce() {
        return this.kPu;
    }

    public String dcf() {
        return this.kPr;
    }

    public String dcg() {
        return (StringUtils.isNull(this.kPr) || "0".equals(this.kPr)) ? this.oriUgcNid : this.kPr;
    }

    public boolean getHostMode() {
        return this.kPw;
    }

    public boolean dch() {
        return dcW();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean dci() {
        return this.egs;
    }

    public boolean dcj() {
        return this.kPA;
    }

    public boolean dck() {
        return this.kPH;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean dcl() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int chY() {
        return this.kPB;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void EI(int i) {
        this.kPB = i;
    }

    public boolean dcm() {
        return this.jOV;
    }

    public boolean dcn() {
        if (this.kJe == null) {
            return false;
        }
        return this.kJe.isValid();
    }

    public String bfG() {
        if (this.kJe == null || !this.kJe.bbu()) {
            return null;
        }
        return this.kJe.bbt();
    }

    public boolean EJ(int i) {
        this.kPD = i;
        if (this.kPD > this.kJe.getPage().bej()) {
            this.kPD = this.kJe.getPage().bej();
        }
        if (this.kPD < 1) {
            this.kPD = 1;
        }
        if (this.kPr == null) {
            return false;
        }
        return EL(5);
    }

    public void EK(int i) {
        this.kPD = i;
        this.kPE = i;
        this.kPF = i;
    }

    public void b(com.baidu.tbadk.core.data.av avVar) {
        if (avVar == null) {
            EK(1);
            return;
        }
        if (this.kPE < avVar.bem()) {
            this.kPE = avVar.bem();
        }
        if (this.kPF > avVar.bem()) {
            this.kPF = avVar.bem();
        }
        this.kPG = avVar.bej();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.kJe;
    }

    public BaijiahaoData dco() {
        if (this.kJe == null || this.kJe.cYR() == null) {
            return null;
        }
        return this.kJe.cYR().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f dcp() {
        if (this.kJe == null) {
            return this.kJe;
        }
        if (!dcq() && this.kQz != null) {
            this.kJe.b(this.kQz);
        }
        return this.kJe;
    }

    private boolean dcq() {
        return (this.kJe.cZj() == null || this.kJe.cZj().dAr() == null || this.kJe.cZj().dAr().goods != null || this.kJe.cZj().dAr().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.av getPageData() {
        if (this.kJe == null) {
            return null;
        }
        return this.kJe.getPage();
    }

    public boolean dcr() {
        if (dcW() && this.kJe.getPage().beo() == 0) {
            to(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.kPr = fVar.getThreadId();
            if (fVar.cYR() != null && fVar.cYR().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.cYR().getBaijiahaoData();
                this.oriUgcNid = baijiahaoData.oriUgcNid;
                this.oriUgcTid = baijiahaoData.oriUgcTid;
                this.oriUgcType = baijiahaoData.oriUgcType;
                this.oriUgcVid = baijiahaoData.oriUgcVid;
            } else {
                this.oriUgcNid = null;
                this.oriUgcTid = null;
                this.oriUgcType = 0;
                this.oriUgcVid = null;
            }
            this.kPt = null;
            this.kPw = false;
            this.kPy = true;
            LoadData();
        }
    }

    public void NV(String str) {
        if (!StringUtils.isNull(str)) {
            this.kPr = str;
            this.kPt = null;
            this.kPw = false;
            this.kPy = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.kPr == null) {
            return false;
        }
        cancelLoadData();
        if (this.hFh == null) {
            this.hFh = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.hFh.start();
        }
        boolean EL = EL(3);
        if (this.opType != null) {
            this.opType = null;
            this.kPS = null;
            this.opUrl = null;
            return EL;
        }
        return EL;
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
        if (this.kQo != null) {
            this.kQo.cancelLoadData();
        }
        if (this.kQp != null) {
            this.kQp.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.drP().drT();
        cjw();
    }

    private void cjw() {
        if (this.hFh != null) {
            this.hFh.destory();
            this.hFh = null;
        }
    }

    public boolean dcs() {
        return (this.kPt == null || this.kPt.equals("0") || this.kPt.length() == 0) ? LoadData() : dcw();
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
                this.kQo.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.kQo.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.kQp == null) {
                this.kQp = new GetSugMatchWordsModel(this.hEa.getPageContext());
            }
            this.kQp.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x039d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03a5 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x011d, B:51:0x016c, B:53:0x017c, B:54:0x0184, B:56:0x0191, B:57:0x0199, B:59:0x019d, B:60:0x01a2, B:62:0x01a6, B:63:0x01ab, B:65:0x01af, B:66:0x01bf, B:68:0x01c3, B:69:0x01cb, B:71:0x01cf, B:72:0x01e8, B:73:0x01f7, B:74:0x01fa, B:77:0x0226, B:79:0x0231, B:80:0x0239, B:82:0x0243, B:83:0x0247, B:85:0x0263, B:86:0x026c, B:88:0x0272, B:90:0x027c, B:202:0x053a, B:203:0x0540, B:206:0x054d, B:93:0x0289, B:201:0x0534, B:200:0x052d, B:96:0x02bd, B:97:0x02db, B:99:0x02f3, B:101:0x02f9, B:103:0x0300, B:104:0x030d, B:106:0x0321, B:108:0x0327, B:110:0x032d, B:119:0x035d, B:121:0x0363, B:111:0x0338, B:113:0x033c, B:115:0x0344, B:117:0x0353, B:118:0x0358, B:122:0x036f, B:124:0x0383, B:126:0x0387, B:129:0x0399, B:132:0x039f, B:160:0x0415, B:135:0x03a5, B:137:0x03ab, B:138:0x03b0, B:140:0x03b4, B:142:0x03be, B:147:0x03d5, B:149:0x03e3, B:150:0x03e6, B:152:0x03ea, B:153:0x03f5, B:155:0x03f9, B:157:0x0401, B:159:0x0410, B:161:0x041a, B:163:0x041e, B:144:0x03c2, B:164:0x0427, B:165:0x0455, B:167:0x0459, B:177:0x048a, B:170:0x0465, B:172:0x0473, B:173:0x047b, B:175:0x047f, B:176:0x0485, B:178:0x0493, B:180:0x049f, B:169:0x045d, B:181:0x04a9, B:183:0x04b5, B:185:0x04b9, B:187:0x04bd, B:188:0x04c2, B:190:0x04ce, B:191:0x04d6, B:195:0x04f0, B:192:0x04db, B:194:0x04ea, B:196:0x04f9, B:198:0x0508, B:94:0x02af, B:38:0x00e3), top: B:209:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03b4 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x011d, B:51:0x016c, B:53:0x017c, B:54:0x0184, B:56:0x0191, B:57:0x0199, B:59:0x019d, B:60:0x01a2, B:62:0x01a6, B:63:0x01ab, B:65:0x01af, B:66:0x01bf, B:68:0x01c3, B:69:0x01cb, B:71:0x01cf, B:72:0x01e8, B:73:0x01f7, B:74:0x01fa, B:77:0x0226, B:79:0x0231, B:80:0x0239, B:82:0x0243, B:83:0x0247, B:85:0x0263, B:86:0x026c, B:88:0x0272, B:90:0x027c, B:202:0x053a, B:203:0x0540, B:206:0x054d, B:93:0x0289, B:201:0x0534, B:200:0x052d, B:96:0x02bd, B:97:0x02db, B:99:0x02f3, B:101:0x02f9, B:103:0x0300, B:104:0x030d, B:106:0x0321, B:108:0x0327, B:110:0x032d, B:119:0x035d, B:121:0x0363, B:111:0x0338, B:113:0x033c, B:115:0x0344, B:117:0x0353, B:118:0x0358, B:122:0x036f, B:124:0x0383, B:126:0x0387, B:129:0x0399, B:132:0x039f, B:160:0x0415, B:135:0x03a5, B:137:0x03ab, B:138:0x03b0, B:140:0x03b4, B:142:0x03be, B:147:0x03d5, B:149:0x03e3, B:150:0x03e6, B:152:0x03ea, B:153:0x03f5, B:155:0x03f9, B:157:0x0401, B:159:0x0410, B:161:0x041a, B:163:0x041e, B:144:0x03c2, B:164:0x0427, B:165:0x0455, B:167:0x0459, B:177:0x048a, B:170:0x0465, B:172:0x0473, B:173:0x047b, B:175:0x047f, B:176:0x0485, B:178:0x0493, B:180:0x049f, B:169:0x045d, B:181:0x04a9, B:183:0x04b5, B:185:0x04b9, B:187:0x04bd, B:188:0x04c2, B:190:0x04ce, B:191:0x04d6, B:195:0x04f0, B:192:0x04db, B:194:0x04ea, B:196:0x04f9, B:198:0x0508, B:94:0x02af, B:38:0x00e3), top: B:209:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03ea A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x011d, B:51:0x016c, B:53:0x017c, B:54:0x0184, B:56:0x0191, B:57:0x0199, B:59:0x019d, B:60:0x01a2, B:62:0x01a6, B:63:0x01ab, B:65:0x01af, B:66:0x01bf, B:68:0x01c3, B:69:0x01cb, B:71:0x01cf, B:72:0x01e8, B:73:0x01f7, B:74:0x01fa, B:77:0x0226, B:79:0x0231, B:80:0x0239, B:82:0x0243, B:83:0x0247, B:85:0x0263, B:86:0x026c, B:88:0x0272, B:90:0x027c, B:202:0x053a, B:203:0x0540, B:206:0x054d, B:93:0x0289, B:201:0x0534, B:200:0x052d, B:96:0x02bd, B:97:0x02db, B:99:0x02f3, B:101:0x02f9, B:103:0x0300, B:104:0x030d, B:106:0x0321, B:108:0x0327, B:110:0x032d, B:119:0x035d, B:121:0x0363, B:111:0x0338, B:113:0x033c, B:115:0x0344, B:117:0x0353, B:118:0x0358, B:122:0x036f, B:124:0x0383, B:126:0x0387, B:129:0x0399, B:132:0x039f, B:160:0x0415, B:135:0x03a5, B:137:0x03ab, B:138:0x03b0, B:140:0x03b4, B:142:0x03be, B:147:0x03d5, B:149:0x03e3, B:150:0x03e6, B:152:0x03ea, B:153:0x03f5, B:155:0x03f9, B:157:0x0401, B:159:0x0410, B:161:0x041a, B:163:0x041e, B:144:0x03c2, B:164:0x0427, B:165:0x0455, B:167:0x0459, B:177:0x048a, B:170:0x0465, B:172:0x0473, B:173:0x047b, B:175:0x047f, B:176:0x0485, B:178:0x0493, B:180:0x049f, B:169:0x045d, B:181:0x04a9, B:183:0x04b5, B:185:0x04b9, B:187:0x04bd, B:188:0x04c2, B:190:0x04ce, B:191:0x04d6, B:195:0x04f0, B:192:0x04db, B:194:0x04ea, B:196:0x04f9, B:198:0x0508, B:94:0x02af, B:38:0x00e3), top: B:209:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03f9 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x011d, B:51:0x016c, B:53:0x017c, B:54:0x0184, B:56:0x0191, B:57:0x0199, B:59:0x019d, B:60:0x01a2, B:62:0x01a6, B:63:0x01ab, B:65:0x01af, B:66:0x01bf, B:68:0x01c3, B:69:0x01cb, B:71:0x01cf, B:72:0x01e8, B:73:0x01f7, B:74:0x01fa, B:77:0x0226, B:79:0x0231, B:80:0x0239, B:82:0x0243, B:83:0x0247, B:85:0x0263, B:86:0x026c, B:88:0x0272, B:90:0x027c, B:202:0x053a, B:203:0x0540, B:206:0x054d, B:93:0x0289, B:201:0x0534, B:200:0x052d, B:96:0x02bd, B:97:0x02db, B:99:0x02f3, B:101:0x02f9, B:103:0x0300, B:104:0x030d, B:106:0x0321, B:108:0x0327, B:110:0x032d, B:119:0x035d, B:121:0x0363, B:111:0x0338, B:113:0x033c, B:115:0x0344, B:117:0x0353, B:118:0x0358, B:122:0x036f, B:124:0x0383, B:126:0x0387, B:129:0x0399, B:132:0x039f, B:160:0x0415, B:135:0x03a5, B:137:0x03ab, B:138:0x03b0, B:140:0x03b4, B:142:0x03be, B:147:0x03d5, B:149:0x03e3, B:150:0x03e6, B:152:0x03ea, B:153:0x03f5, B:155:0x03f9, B:157:0x0401, B:159:0x0410, B:161:0x041a, B:163:0x041e, B:144:0x03c2, B:164:0x0427, B:165:0x0455, B:167:0x0459, B:177:0x048a, B:170:0x0465, B:172:0x0473, B:173:0x047b, B:175:0x047f, B:176:0x0485, B:178:0x0493, B:180:0x049f, B:169:0x045d, B:181:0x04a9, B:183:0x04b5, B:185:0x04b9, B:187:0x04bd, B:188:0x04c2, B:190:0x04ce, B:191:0x04d6, B:195:0x04f0, B:192:0x04db, B:194:0x04ea, B:196:0x04f9, B:198:0x0508, B:94:0x02af, B:38:0x00e3), top: B:209:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x041e A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x011d, B:51:0x016c, B:53:0x017c, B:54:0x0184, B:56:0x0191, B:57:0x0199, B:59:0x019d, B:60:0x01a2, B:62:0x01a6, B:63:0x01ab, B:65:0x01af, B:66:0x01bf, B:68:0x01c3, B:69:0x01cb, B:71:0x01cf, B:72:0x01e8, B:73:0x01f7, B:74:0x01fa, B:77:0x0226, B:79:0x0231, B:80:0x0239, B:82:0x0243, B:83:0x0247, B:85:0x0263, B:86:0x026c, B:88:0x0272, B:90:0x027c, B:202:0x053a, B:203:0x0540, B:206:0x054d, B:93:0x0289, B:201:0x0534, B:200:0x052d, B:96:0x02bd, B:97:0x02db, B:99:0x02f3, B:101:0x02f9, B:103:0x0300, B:104:0x030d, B:106:0x0321, B:108:0x0327, B:110:0x032d, B:119:0x035d, B:121:0x0363, B:111:0x0338, B:113:0x033c, B:115:0x0344, B:117:0x0353, B:118:0x0358, B:122:0x036f, B:124:0x0383, B:126:0x0387, B:129:0x0399, B:132:0x039f, B:160:0x0415, B:135:0x03a5, B:137:0x03ab, B:138:0x03b0, B:140:0x03b4, B:142:0x03be, B:147:0x03d5, B:149:0x03e3, B:150:0x03e6, B:152:0x03ea, B:153:0x03f5, B:155:0x03f9, B:157:0x0401, B:159:0x0410, B:161:0x041a, B:163:0x041e, B:144:0x03c2, B:164:0x0427, B:165:0x0455, B:167:0x0459, B:177:0x048a, B:170:0x0465, B:172:0x0473, B:173:0x047b, B:175:0x047f, B:176:0x0485, B:178:0x0493, B:180:0x049f, B:169:0x045d, B:181:0x04a9, B:183:0x04b5, B:185:0x04b9, B:187:0x04bd, B:188:0x04c2, B:190:0x04ce, B:191:0x04d6, B:195:0x04f0, B:192:0x04db, B:194:0x04ea, B:196:0x04f9, B:198:0x0508, B:94:0x02af, B:38:0x00e3), top: B:209:0x00d7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean EL(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        int i4 = 0;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        EM(i);
        final com.baidu.tieba.pb.data.f pbData = as.ddA().getPbData();
        if (pbData != null && pbData.cYR() != null) {
            pbData.cYR().np(0);
            this.kPy = as.ddA().dch();
            this.kPw = as.ddA().ddF();
            this.kPA = as.ddA().ddG();
            this.kQt = as.ddA().ddE();
            this.kQu = as.ddA().ddD();
            this.kQv = as.ddA().ddC();
            this.kQx = as.ddA().ddH();
            this.mTabIndex = as.ddA().getTabIndex();
            this.kQq = this.kPw;
            if (this.kPw || this.isFromMark) {
                this.kPW = false;
            }
            com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.kQa) {
            a(dcB(), true, this.kPt, 3);
        }
        if (i == 3 && !this.kQa) {
            if (this.isFromMark) {
                a(dcB(), true, this.kPt, 3);
            } else {
                a(dcB(), false, this.kPt, 3);
            }
        }
        this.kQa = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.kQz == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.eMf);
        if (this.kPw || this.isFromMark) {
            this.kPW = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.kPr == null || this.kPr.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.kPr, 0L));
        if (com.baidu.tbadk.a.d.baV()) {
            pbPageRequestMessage.setFloorSortType(1);
            pbPageRequestMessage.set_rn(15);
        } else {
            pbPageRequestMessage.set_rn(30);
        }
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.au.bkm().bkn() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.kPy) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.kPw) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.kPL) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.kPK));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.kPW) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.kPS, 0));
            pbPageRequestMessage.setOpMessageID(this.kPK);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> cYT = this.kJe.cYT();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kPF - 1));
                        if (this.kPF - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.kPI) {
                                if (cYT != null && cYT.size() > 0) {
                                    size = cYT.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = cYT.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.kPt = postData.getId();
                                            if (StringUtils.isNull(this.kPt)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.kPE + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.kPt == null && this.kPt.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kPt, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kPE + 1));
                        if (this.kPE >= this.kPG) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (cYT != null) {
                                size = cYT.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.kPt == null) {
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
                if (cYT != null) {
                }
                if (this.kPt == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (cYT != null && cYT.size() > 0 && cYT.get(0) != null) {
                    this.kPt = cYT.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (dcW()) {
                        if (this.kPF - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.kPF - 1));
                        }
                    } else if (this.kPE < this.kPG) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kPE + 1));
                    }
                }
                if (this.kPt != null && this.kPt.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kPt, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.kPw) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (dcW()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.kPG > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kPG));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kPt, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.kPD));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.kQq && !this.kPw) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kPt, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.kPw) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.kQe);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kQs, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.kQq = this.kPw;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(dcB());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.kQr));
        pbPageRequestMessage.setIsSubPostDataReverse(this.kQd);
        pbPageRequestMessage.setFromSmartFrs(this.kQg ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.kPv);
        if (this.kQr == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.kQF)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.kQF));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.kPG) {
                    i4 = -1;
                } else {
                    i4 = ddd();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = ddd();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.kPr);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean cZX() {
        switch (dcP()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().cYR() == null || !getPbData().cYR().bgV();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cZY()) && com.baidu.tieba.recapp.r.dqU().dqO() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dqU().dqO().aT(cZY(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dqU().dqO().aU(cZY(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cZY()) && com.baidu.tieba.recapp.r.dqU().dqO() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dqU().dqO().aU(cZY(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dqU().dqO().aT(cZY(), true));
        }
    }

    protected void EM(int i) {
        boolean z = false;
        ER(i);
        ArrayList<PostData> cYT = this.kJe.cYT();
        this.kPZ = false;
        if (i == 1) {
            boolean z2 = false;
            while (cYT.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cYT.remove(0);
                z2 = true;
            }
            if (z2) {
                this.kJe.getPage().nl(1);
                if (this.kPR != null) {
                    this.kPR.e(this.kJe);
                }
            }
            this.ivr = System.currentTimeMillis();
            this.kPZ = true;
        } else if (i == 2) {
            while (cYT.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cYT.remove(cYT.size() - 1);
                z = true;
            }
            if (z) {
                this.kJe.getPage().nk(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.kQh = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.kQz != null && this.kQz.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cZj() != null && fVar.cZj().dAr() != null && fVar.cZj().dAr().goods != null && fVar.cZj().isValidate() && fVar.cZj().dAr().goods.goods_style != 1001) {
            this.kQz = fVar.cZj();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n dct() {
        return this.kQz;
    }

    public void dcu() {
        this.kQz = null;
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

    protected void l(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            if (this.kPP || this.kPN || this.kPO) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.cYT().size(); i++) {
                PostData postData = fVar.cYT().get(i);
                for (int i2 = 0; i2 < postData.dAA().size(); i2++) {
                    postData.dAA().get(i2).a(this.hEa.getPageContext(), o.equals(postData.dAA().get(i2).bfy().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r cZf = fVar.cZf();
            if (cZf != null && !com.baidu.tbadk.core.util.y.isEmpty(cZf.kGS)) {
                for (PostData postData2 : cZf.kGS) {
                    for (int i3 = 0; i3 < postData2.dAA().size(); i3++) {
                        postData2.dAA().get(i3).a(this.hEa.getPageContext(), o.equals(postData2.dAA().get(i3).bfy().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r cZf = fVar.cZf();
            if (cZf != null && !com.baidu.tbadk.core.util.y.isEmpty(cZf.kGS)) {
                for (PostData postData : cZf.kGS.subList(i, cZf.kGS.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dAA().size()) {
                            postData.dAA().get(i3).a(this.hEa.getPageContext(), o.equals(postData.dAA().get(i3).bfy().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.f n(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null) {
            return null;
        }
        bw cYR = fVar.cYR();
        cYR.nu(this.mIsGood);
        cYR.nt(this.kPB);
        if (this.kPC > 0) {
            cYR.cB(this.kPC);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.cYR() != null && fVar.cYR().bfy() != null) {
            str = fVar.cYR().bfy().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData dcv() {
        if (this.kJe == null || this.kJe.cYR() == null || this.kJe.cYR().bfy() == null) {
            return null;
        }
        return this.kJe.cYR().bfy();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.kQf = z3;
        if (this.hFh != null && !z3) {
            this.hFh.a(z2, z4, i2, str, i3, j, j2);
            this.hFh = null;
        }
        if (this.kJe != null) {
            this.kJe.kGc = z3;
            this.kJe.Yq = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(cZY()) && com.baidu.tieba.recapp.r.dqU().dqO() != null) {
            com.baidu.tieba.recapp.r.dqU().dqO().f(cZY(), EN(dcE()), true);
        }
        if (fVar == null || (this.kPD == 1 && i == 5 && fVar.cYT() != null && fVar.cYT().size() < 1)) {
            if (this.kPR != null) {
                this.kPy = this.kPx;
                if (i2 != 350006) {
                    this.mSortType = this.kPz;
                }
                this.kPR.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.kPx = this.kPy;
            if (i != 8) {
                this.kPz = this.mSortType;
                this.mSortType = fVar.kFo;
            }
            if (fVar.kFn != null && fVar.kFn.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.hEa.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.kFn = new ArrayList();
                fVar.kFn.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.hEa.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.kFn.add(builder2.build(false));
                this.mSortType = this.kPz;
                fVar.kFo = this.mSortType;
            }
            this.kPL = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.kPG = this.kPG < 1 ? 1 : this.kPG;
            int i6 = 0;
            ArrayList<PostData> cYT = this.kJe.cYT();
            switch (i) {
                case 1:
                    this.kJe.a(fVar.getPage(), 1);
                    d(fVar, cYT);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.cYT() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.cYT().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(cYT, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.cYT(), com.baidu.tbadk.core.util.y.getCount(fVar.cYT()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.cYT().remove(postData2);
                            i5 = size2 - 1;
                        }
                        cYT.addAll(0, fVar.cYT());
                    }
                    p(fVar);
                    this.kJe.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().ni(fVar.getPage().bej());
                    }
                    q(fVar);
                    i4 = 0;
                    break;
                case 4:
                    q(fVar);
                    i4 = 0;
                    break;
                case 5:
                    q(fVar);
                    i4 = 0;
                    break;
                case 6:
                    q(fVar);
                    i4 = 0;
                    break;
                case 7:
                    q(fVar);
                    i4 = 0;
                    break;
                case 8:
                    if (fVar != null && !com.baidu.tbadk.core.util.y.isEmpty(fVar.cYT()) && this.kJe != null && (!this.kPw || o(fVar).equals(fVar.cYT().get(0).bfy().getUserId()))) {
                        if (this.kJe.getPage().beo() == 0) {
                            this.kJe.getPage().nk(1);
                        }
                        dcQ();
                        this.kQt = fVar.cYT().get(0);
                        if (dcW() || this.kJe.cZu()) {
                            if (this.kJe.cYT().size() - this.kQv >= 3) {
                                this.kQu = new PostData();
                                this.kQu.mpb = true;
                                this.kQu.setPostType(53);
                                this.kJe.cYT().add(this.kQu);
                            }
                            this.kJe.cYT().add(this.kQt);
                            size = this.kJe.cYT().size() - 1;
                        } else {
                            if (this.kQv - this.kQw >= 3) {
                                this.kQu = new PostData();
                                this.kQu.mpb = false;
                                this.kQu.setPostType(53);
                                this.kJe.cYT().add(0, this.kQu);
                            }
                            this.kJe.cYT().add(0, this.kQt);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.at.isTaday(com.baidu.tbadk.core.sharedPref.b.bjf().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.kQt.mpo = this.kJe.cZs();
                            com.baidu.tbadk.core.sharedPref.b.bjf().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        }
                        i6 = size;
                    }
                    p(fVar);
                    i4 = i6;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.kJe != null && this.kJe.cYR() != null) {
                PraiseData bfj = this.kJe.cYR().bfj();
                if (this.kQJ != null && !bfj.isPriaseDataValid()) {
                    this.kJe.cYR().a(this.kQJ);
                } else {
                    this.kQJ = this.kJe.cYR().bfj();
                    this.kQJ.setPostId(this.kJe.cYR().bfP());
                }
                if (fVar.getPage() != null && fVar.getPage().bem() == 1 && fVar.cYR() != null && fVar.cYR().bfI() != null && fVar.cYR().bfI().size() > 0) {
                    this.kJe.cYR().E(fVar.cYR().bfI());
                }
                this.kJe.cYR().nr(fVar.cYR().bfp());
                this.kJe.cYR().no(fVar.cYR().getAnchorLevel());
                this.kJe.cYR().np(fVar.cYR().bff());
                if (this.mThreadType == 33) {
                    this.kJe.cYR().bfy().setHadConcerned(fVar.cYR().bfy().hadConcerned());
                }
                if (fVar != null && fVar.cYR() != null) {
                    this.kJe.cYR().nw(fVar.cYR().bfM());
                }
            }
            if (this.kJe != null && this.kJe.getUserData() != null && fVar.getUserData() != null) {
                this.kJe.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.kJe.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().bem() == 1 && fVar.cZe() != null) {
                this.kJe.f(fVar.cZe());
            }
            if (this.kQf) {
                if (this.kJe.cYR() != null && this.kJe.cYR().bfy() != null && this.kJe.cYT() != null && com.baidu.tbadk.core.util.y.getItem(this.kJe.cYT(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(this.kJe.cYT(), 0);
                    MetaData bfy = this.kJe.cYR().bfy();
                    if (postData3.bfy() != null && postData3.bfy().getGodUserData() != null) {
                        if (this.kPU != -1) {
                            bfy.setFansNum(this.kPU);
                            postData3.bfy().setFansNum(this.kPU);
                        }
                        if (this.kPV != -1) {
                            bfy.getGodUserData().setIsLike(this.kPV == 1);
                            postData3.bfy().getGodUserData().setIsLike(this.kPV == 1);
                            bfy.getGodUserData().setIsFromNetWork(false);
                            postData3.bfy().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.kJe.kFm = -1;
                this.kJe.kFl = -1;
            }
            if (this.kPR != null) {
                this.kPR.a(true, getErrorCode(), i, i4, this.kJe, this.mErrorString, 1);
            }
        }
        if (this.kJe != null && this.kJe.cYR() != null && this.kJe.getForum() != null && !this.kJe.cZu()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.hEa.getPageContext();
            historyMessage.threadId = getPbData().cYR().getId();
            if (this.mIsShareThread && getPbData().cYR().efS != null) {
                historyMessage.threadName = getPbData().cYR().efS.showText;
            } else {
                historyMessage.threadName = getPbData().cYR().getTitle();
            }
            if (this.mIsShareThread && !cZX()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = dch();
            historyMessage.threadType = getPbData().cYR().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.kJe != null) {
            this.kJe.cZi().clear();
            this.kJe.cZi().addAll(fVar.cZi());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aY;
        if (arrayList != null && fVar.cYT() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.cYT(), 0);
            if (postData != null && (aY = aY(arrayList)) != null && aY.equals(postData.getId())) {
                fVar.cYT().remove(postData);
            }
            this.kJe.kGb = arrayList.size();
            arrayList.addAll(fVar.cYT());
        }
    }

    private int EN(int i) {
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

    private String aY(ArrayList<PostData> arrayList) {
        int count = com.baidu.tbadk.core.util.y.getCount(arrayList);
        if (count <= 0) {
            return null;
        }
        for (int i = count - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    private void q(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            fVar.NO(this.kJe.cZm());
            if (!this.kJe.kFZ && fVar.kFZ && this.kJe.cZb() != null) {
                fVar.e(this.kJe.cZb());
            }
            this.kJe = fVar;
            EK(fVar.getPage().bem());
        }
    }

    public boolean dcw() {
        if (this.kPr == null || this.kPt == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return EL(4);
        }
        return EL(6);
    }

    public boolean to(boolean z) {
        if (this.kPr == null || this.kJe == null) {
            return false;
        }
        if (z || this.kJe.getPage().beo() != 0) {
            return EL(1);
        }
        return false;
    }

    public boolean tp(boolean z) {
        if (this.kPr == null || this.kJe == null) {
            return false;
        }
        if ((z || this.kJe.getPage().bep() != 0) && this.kJe.cYT() != null && this.kJe.cYT().size() >= 1) {
            return EL(2);
        }
        return false;
    }

    public boolean Ob(String str) {
        this.kPw = !this.kPw;
        this.kPt = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").ai("obj_source", 0));
        if (EL(6)) {
            return true;
        }
        this.kPw = this.kPw ? false : true;
        return false;
    }

    public boolean z(boolean z, String str) {
        if (this.kPw == z) {
            return false;
        }
        this.kPw = z;
        this.kPt = str;
        if (this.mSortType == 2) {
            this.kPt = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").ai("obj_source", 1));
        }
        if (EL(6)) {
            return true;
        }
        this.kPw = z ? false : true;
        return false;
    }

    public boolean EO(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_pb_current_sort_type", i);
        }
        this.kPx = this.kPy;
        this.kPz = this.mSortType;
        this.mSortType = i;
        this.kPy = !this.kPy;
        if (i == 2 && this.isFromMark) {
            this.kPt = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.kPy = this.kPy ? false : true;
            this.mSortType = this.kPz;
            return false;
        }
        return true;
    }

    public boolean dcx() {
        return dcW();
    }

    public int dcy() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.kJe == null || this.kJe.getForum() == null || this.kJe.cYR() == null) ? false : true;
    }

    public boolean bbu() {
        if (this.kJe == null) {
            return false;
        }
        return this.kJe.bbu();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData Cr(String str) {
        if (this.kJe == null || this.kJe.cYR() == null || this.kJe.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.kJe.cYR().bgV()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.kJe.getForum().getId());
            writeData.setForumName(this.kJe.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.kQr);
        writeData.setThreadId(this.kPr);
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

    public MarkData EP(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.kJe == null) {
            return null;
        }
        ArrayList<PostData> cYT = this.kJe.cYT();
        if (com.baidu.tbadk.core.util.y.isEmpty(cYT)) {
            return null;
        }
        if (cYT.size() > 0 && i >= cYT.size()) {
            i = cYT.size() - 1;
        }
        return o(cYT.get(i));
    }

    public MarkData dcz() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kPr);
        markData.setPostId(this.kJe.bbt());
        markData.setTime(date.getTime());
        markData.setHostMode(this.kPw);
        markData.setSequence(Boolean.valueOf(dcW()));
        markData.setId(this.kPr);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kPr);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.kPw);
        markData.setSequence(Boolean.valueOf(dcW()));
        markData.setId(this.kPr);
        markData.setFloor(postData.dAD());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) postData).isApp());
        }
        return markData;
    }

    public void dcA() {
        j.daL().aO(dcB(), this.isFromMark);
    }

    private String dcB() {
        String dcC = (this.kPr == null || this.kPr.equals("0")) ? dcC() : this.kPr;
        if (this.kPw) {
            dcC = dcC + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            dcC = dcC + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            dcC = dcC + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return dcC + TbadkCoreApplication.getCurrentAccount();
        }
        return dcC;
    }

    private String dcC() {
        String str = this.oriUgcNid != null ? "" + this.oriUgcNid : "";
        if (this.oriUgcTid != null) {
            str = str + this.oriUgcTid;
        }
        String str2 = str + this.oriUgcType;
        if (this.oriUgcVid != null) {
            return str2 + this.oriUgcVid;
        }
        return str2;
    }

    public void tq(boolean z) {
        if (this.kJe != null) {
            this.kJe.hy(z);
        }
    }

    public boolean dcD() {
        return this.kPW;
    }

    public void a(a aVar) {
        this.kPR = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bsX() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bsW() {
        return dcs();
    }

    public boolean Oc(String str) {
        if (getPbData() == null || getPbData().cYR() == null || getPbData().cYR().bfy() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().cYR().bfy().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int dcE() {
        return this.mRequestType;
    }

    public void dcF() {
        if ("personalize_page".equals(this.mStType)) {
            this.kQc = System.currentTimeMillis() / 1000;
        }
    }

    public void dcG() {
        if ("personalize_page".equals(this.mStType) && this.kJe != null && this.kQc != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10754").dF("fid", this.kJe.getForumId()).dF("tid", this.kPr).dF("obj_duration", String.valueOf(currentTimeMillis - this.kQc)).dF(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.kQc = 0L;
        }
    }

    public boolean dcH() {
        return this.kQf;
    }

    public int getErrorNo() {
        return this.kQh;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public q dcI() {
        return this.kQj;
    }

    public ai dcJ() {
        return this.kQk;
    }

    public CheckRealNameModel dcK() {
        return this.kQm;
    }

    public AddExperiencedModel dcL() {
        return this.kQn;
    }

    public String dcM() {
        return this.kQb;
    }

    public void Od(String str) {
        this.kQb = str;
    }

    public boolean dcN() {
        return this.kQg;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.kJe != null && this.kJe.cYT() != null && this.kJe.cYT().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.kJe.cYT().size();
                for (int i = 0; i < size; i++) {
                    if (this.kJe.cYT().get(i) != null && this.kJe.cYT().get(i).bfy() != null && currentAccount.equals(this.kJe.cYT().get(i).bfy().getUserId()) && this.kJe.cYT().get(i).bfy().getPendantData() != null) {
                        this.kJe.cYT().get(i).bfy().getPendantData().zE(mVar.bdu());
                        this.kJe.cYT().get(i).bfy().getPendantData().cZ(mVar.brU());
                    }
                }
            }
        }
    }

    public String dcO() {
        return this.kQl;
    }

    public int dcP() {
        return this.kQr;
    }

    public void EQ(int i) {
        this.kQr = i;
    }

    public void Oe(String str) {
        if ((!this.kPw || Oc(TbadkCoreApplication.getCurrentAccount())) && this.kJe.cYT() != null) {
            this.kJe.getPage().nk(1);
            if (this.kJe.getPage().beo() == 0) {
                this.kJe.getPage().nk(1);
            }
            this.kQs = str;
            EL(8);
        }
    }

    private void ER(int i) {
        if (i != 8) {
            this.kQs = "";
            if (this.kQt != null) {
                if (i == 1 && this.kJe != null && this.kJe.cZu()) {
                    if (this.kQu != null) {
                        getPbData().cYT().remove(this.kQu);
                    }
                } else if (i == 1 && !this.kPy && !com.baidu.tbadk.core.util.y.isEmpty(getPbData().cYT())) {
                    getPbData().cYT().remove(this.kQt);
                    if (this.kQu != null) {
                        getPbData().cYT().remove(this.kQu);
                    }
                    getPbData().cYT().add(0, this.kQt);
                } else {
                    getPbData().cYT().remove(this.kQt);
                    if (this.kQu != null) {
                        getPbData().cYT().remove(this.kQu);
                    }
                }
            }
            this.kQu = null;
        }
    }

    public void dcQ() {
        if (this.kJe != null && !com.baidu.tbadk.core.util.y.isEmpty(this.kJe.cYT())) {
            if (this.kQu != null) {
                this.kJe.cYT().remove(this.kQu);
                this.kQu = null;
            }
            if (this.kQt != null) {
                this.kJe.cYT().remove(this.kQt);
                this.kQt = null;
            }
        }
    }

    public void cX(int i, int i2) {
        this.kQv = i;
        this.kQw = i2;
    }

    public PostData dcR() {
        return this.kQt;
    }

    public PostData dcS() {
        return this.kQu;
    }

    public int dcT() {
        return this.kQv;
    }

    public int dcU() {
        return this.kQw;
    }

    public String dcV() {
        return this.kQy;
    }

    public void Of(String str) {
        this.kQy = str;
    }

    private boolean dcW() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean dcX() {
        return this.kQr == 13 || this.kQr == 12 || this.kQr == 7;
    }

    public String dcY() {
        return this.kQB;
    }

    public String dcZ() {
        return this.kQC;
    }

    public String dda() {
        return this.kQD;
    }

    public String ddb() {
        return this.kQE;
    }

    public Rect ddc() {
        Rect rect = this.kQx;
        this.kQx = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int ddd() {
        int i;
        int i2 = 0;
        if (getPbData().cYT() == null) {
            return 0;
        }
        ArrayList<PostData> cYT = getPbData().cYT();
        int size = cYT.size() - 1;
        while (size >= 0) {
            PostData postData = cYT.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
                if (postData.getType() != AdvertAppInfo.dYh) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return cYT.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
