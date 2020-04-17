package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes9.dex */
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
    private boolean dtP;
    private BaseFragmentActivity gCG;
    private com.baidu.tieba.tbadkCore.d.b gDP;
    private long hqR;
    private boolean iBS;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    protected com.baidu.tieba.pb.data.e jqV;
    protected String jvS;
    private String jvT;
    private String jvU;
    private String jvV;
    private boolean jvW;
    private boolean jvX;
    private boolean jvY;
    private boolean jvZ;
    private boolean jwA;
    private boolean jwB;
    private boolean jwC;
    private String jwD;
    private long jwE;
    private boolean jwF;
    private int jwG;
    private boolean jwH;
    private boolean jwI;
    private int jwJ;
    private final v jwK;
    private final n jwL;
    private final x jwM;
    private String jwN;
    private final CheckRealNameModel jwO;
    private final AddExperiencedModel jwP;
    private SuggestEmotionModel jwQ;
    private GetSugMatchWordsModel jwR;
    private boolean jwS;
    private int jwT;
    private String jwU;
    private PostData jwV;
    private PostData jwW;
    private int jwX;
    private int jwY;
    private Rect jwZ;
    private int jwa;
    private boolean jwb;
    private int jwc;
    private long jwd;
    private int jwe;
    private int jwf;
    private int jwg;
    private int jwh;
    private boolean jwi;
    private boolean jwj;
    private boolean jwk;
    private long jwl;
    private boolean jwm;
    private String jwn;
    private int jwo;
    private boolean jwp;
    private boolean jwq;
    private boolean jwr;
    private boolean jws;
    private a jwt;
    private String jwu;
    private String jwv;
    private int jww;
    private int jwx;
    private boolean jwy;
    private boolean jwz;
    private String jxa;
    private com.baidu.tieba.tbadkCore.data.m jxb;
    private boolean jxc;
    private String jxd;
    private String jxe;
    private String jxf;
    private String jxg;
    private f.a jxh;
    private CustomMessageListener jxi;
    private com.baidu.adp.framework.listener.a jxj;
    private PraiseData jxk;
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
    private static final int jvR = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.e eVar);
    }

    public PbModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.mStType = null;
        this.jvS = null;
        this.jvT = null;
        this.jvU = null;
        this.mForumId = null;
        this.jvV = null;
        this.jvW = false;
        this.jvX = false;
        this.jvY = true;
        this.jvZ = true;
        this.mSortType = 0;
        this.jwa = 0;
        this.jwb = false;
        this.mIsGood = 0;
        this.jwc = 0;
        this.jwd = 0L;
        this.jwe = 1;
        this.jwf = 1;
        this.jwg = 1;
        this.jwh = 1;
        this.isAd = false;
        this.iBS = false;
        this.dtP = false;
        this.jwi = false;
        this.isFromMark = false;
        this.jwj = false;
        this.jwk = false;
        this.jwl = 0L;
        this.jwm = false;
        this.jwn = null;
        this.jqV = null;
        this.isLoading = false;
        this.jwp = false;
        this.jwq = false;
        this.jwr = false;
        this.jws = false;
        this.mLocate = null;
        this.mContext = null;
        this.jwt = null;
        this.opType = null;
        this.opUrl = null;
        this.jwu = null;
        this.jwv = null;
        this.jww = -1;
        this.jwx = -1;
        this.gDP = null;
        this.jwz = false;
        this.jwA = false;
        this.postID = null;
        this.jwD = null;
        this.jwE = 0L;
        this.jwF = false;
        this.jwG = -1;
        this.jwI = false;
        this.jwS = false;
        this.jwT = 0;
        this.mTabIndex = 0;
        this.jxc = false;
        this.jxi = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.jxj = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.gCG.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.jwz || !PbModel.this.jwA) {
                        if (!PbModel.this.jwz) {
                            PbModel.this.jwz = true;
                        } else {
                            PbModel.this.jwA = true;
                        }
                        if (PbModel.this.jwt != null) {
                            PbModel.this.jwt.a(PbModel.this.cyv(), z, responsedMessage, PbModel.this.jwB, System.currentTimeMillis() - PbModel.this.hqR);
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
                    if (PbModel.this.jqV != null && PbModel.this.jqV.cvt() != null && PbModel.this.jqV.cvt().getForumId() != null && PbModel.this.jqV.cvt().getForumId().equals(valueOf)) {
                        PbModel.this.jqV.cvt().setIsLike(false);
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
                    if (PbModel.this.jqV != null && PbModel.this.jqV.cvt() != null && PbModel.this.jqV.cvt().getForumId() != null && PbModel.this.jqV.cvt().getForumId().equals(valueOf)) {
                        PbModel.this.jqV.cvt().setIsLike(true);
                    }
                }
            }
        };
        this.jxk = null;
        registerListener(this.jxj);
        registerListener(this.jxi);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.jqV = new com.baidu.tieba.pb.data.e();
        this.jqV.zj(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.gCG = baseFragmentActivity;
        this.jwK = new v(this, this.gCG);
        this.jwL = new n(this, this.gCG);
        this.jwM = new x(this, this.gCG);
        this.jwO = new CheckRealNameModel(this.gCG.getPageContext());
        this.jwQ = new SuggestEmotionModel();
        this.jwP = new AddExperiencedModel(this.gCG.getPageContext());
        this.jxh = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void B(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dhw) instanceof String) {
                        PbModel.this.jvS = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dhw);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dhx) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dhx);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dhy) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dhy);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dhz) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.dhz), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dhA) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dhA);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, String str) {
        this.jwC = true;
        if (eVar != null && eVar.jnx == null) {
            n(eVar);
            j(eVar);
            if (eVar.cvu() != null) {
                eVar.cvu().jO(0);
            }
            if (this.jwt != null && eVar != null) {
                this.jwt.a(true, 0, i, 0, eVar, str, 0);
            }
        }
    }

    protected int cyv() {
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
            this.jvS = intent.getStringExtra("thread_id");
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.n(uri)) {
                com.baidu.tbadk.BdToken.f.aGd().c(uri, this.jxh);
            } else if (StringUtils.isNull(this.jvS)) {
                this.jwK.a(intent, this.jxh);
                if (uri != null) {
                    if (StringUtils.isNull(this.jvS)) {
                        this.jvS = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.aq.isEmpty(this.jvS)) {
                this.jvS = "0";
            }
            this.jwT = intent.getIntExtra("key_start_from", 0);
            if (this.jwT == 0) {
                this.jwT = this.jwK.aqP;
            }
            this.jvU = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.jvT = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.jvW = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.jvX = intent.getBooleanExtra("host_only", false);
            this.jvZ = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.aZZ().aRA() ? 2 : 0);
            if (this.mSortType == 2) {
                this.jvU = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.jwc = intent.getIntExtra("is_top", 0);
            this.jwd = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.jwj = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.jwk = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.iBS = intent.getBooleanExtra("is_sub_pb", false);
            this.jwm = intent.getBooleanExtra("is_pv", false);
            this.jwl = intent.getLongExtra("msg_id", 0L);
            this.jwn = intent.getStringExtra("from_forum_name");
            this.jwv = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.jwu = intent.getStringExtra("op_stat");
            this.jwp = intent.getBooleanExtra("is_from_thread_config", false);
            this.jwq = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.jwr = intent.getBooleanExtra("is_from_my_god_config", false);
            this.jwx = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.jww = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.dtP = intent.getBooleanExtra("from_frs", false);
            this.jwi = intent.getBooleanExtra("from_maintab", false);
            this.jwI = intent.getBooleanExtra("from_smart_frs", false);
            this.jws = intent.getBooleanExtra("from_hottopic", false);
            this.jwN = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.jvV = intent.getStringExtra("high_light_post_id");
            this.jxc = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.jwy = intent.getIntExtra("request_code", -1) == 18003;
            this.jxd = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.jxe = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.jxf = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.jxg = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean cyw() {
        return this.jxc && com.baidu.tieba.frs.i.bOm() != null && com.baidu.tieba.frs.i.bOm().equals(this.jvS) && com.baidu.tieba.frs.i.bOl() != null;
    }

    public com.baidu.tieba.pb.data.e aI(bj bjVar) {
        com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
        eVar.zj(3);
        if (bjVar == null) {
            return null;
        }
        eVar.aG(bjVar);
        if (bjVar.aMp() != null) {
            eVar.e(bjVar.aMp());
            ForumData forum = eVar.getForum();
            forum.setId(bjVar.aMp().getForumId());
            forum.setName(bjVar.aMp().getForumName());
            forum.setUser_level(bjVar.aMp().aJV());
            forum.setImage_url(bjVar.aMp().getAvatar());
            forum.setPost_num(bjVar.aMp().postNum);
            forum.setMember_num(bjVar.aMp().memberNum);
        } else {
            ForumData forum2 = eVar.getForum();
            forum2.setId(String.valueOf(bjVar.getFid()));
            forum2.setName(bjVar.aKJ());
        }
        PostData postData = new PostData();
        postData.Di(1);
        postData.setTime(bjVar.getCreateTime());
        postData.a(bjVar.aKE());
        MetaData aKE = bjVar.aKE();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(aKE.getUserId(), aKE);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bjVar.aKu(), false));
        eVar.d(postData);
        eVar.cvw().add(postData);
        eVar.a(new com.baidu.tieba.pb.data.k(bjVar, null));
        eVar.jnC = true;
        eVar.setIsNewUrl(1);
        return eVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.jwT = bundle.getInt("key_start_from", 0);
        this.jvS = bundle.getString("thread_id");
        this.jvU = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.jvT = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.jvW = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.jvX = bundle.getBoolean("host_only", false);
        this.jvZ = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.jwc = bundle.getInt("is_top", 0);
        this.jwd = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.jwk = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.iBS = bundle.getBoolean("is_sub_pb", false);
        this.jwm = bundle.getBoolean("is_pv", false);
        this.jwl = bundle.getLong("msg_id", 0L);
        this.jwn = bundle.getString("from_forum_name");
        this.jwv = bundle.getString("extra_pb_cache_key");
        this.jwp = bundle.getBoolean("is_from_thread_config", false);
        this.jwq = bundle.getBoolean("is_from_interview_live_config", false);
        this.jwr = bundle.getBoolean("is_from_my_god_config", false);
        this.jwx = bundle.getInt("extra_pb_is_attention_key", -1);
        this.jww = bundle.getInt("extra_pb_funs_count_key", -1);
        this.dtP = bundle.getBoolean("from_frs", false);
        this.jwi = bundle.getBoolean("from_maintab", false);
        this.jwI = bundle.getBoolean("from_smart_frs", false);
        this.jws = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.jvV = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.jwy = bundle.getInt("request_code", -1) == 18003;
        this.jxd = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.jxe = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.jxf = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.jxg = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void au(Bundle bundle) {
        bundle.putString("thread_id", this.jvS);
        bundle.putString("post_id", this.jvU);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.jwT);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.jvW);
        bundle.putBoolean("host_only", this.jvX);
        bundle.putBoolean("squence", this.jvZ);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.jwc);
        bundle.putLong("thread_time", this.jwd);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.jwk);
        bundle.putBoolean("is_sub_pb", this.iBS);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.jwm);
        bundle.putLong("msg_id", this.jwl);
        bundle.putString("extra_pb_cache_key", this.jwv);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.jwp);
        bundle.putBoolean("is_from_interview_live_config", this.jwq);
        bundle.putBoolean("is_from_my_god_config", this.jwr);
        bundle.putInt("extra_pb_is_attention_key", this.jwx);
        bundle.putInt("extra_pb_funs_count_key", this.jww);
        bundle.putBoolean("from_frs", this.dtP);
        bundle.putBoolean("from_maintab", this.jwi);
        bundle.putBoolean("from_smart_frs", this.jwI);
        bundle.putBoolean("from_hottopic", this.jws);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.jvV);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.jxd);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.jxe);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.jxf);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.jxg);
    }

    public String cyx() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.jvS);
        if (!this.jwk) {
            sb.append(this.jvU);
        }
        sb.append(this.jvX);
        sb.append(this.jvZ);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.jwc);
        sb.append(this.jwd);
        sb.append(this.dtP);
        sb.append(this.jwi);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.iBS);
        sb.append(this.jwm);
        sb.append(this.jwl);
        sb.append(this.jwn);
        sb.append(this.mThreadType);
        sb.append(this.jwp);
        sb.append(this.jwq);
        sb.append(this.jwr);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.jwv != null) {
            sb.append(this.jwv);
        }
        return sb.toString();
    }

    public String cwu() {
        return this.jwn;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cyy() {
        return this.jvU;
    }

    public String cyz() {
        return this.jvV;
    }

    public String cyA() {
        return this.jvS;
    }

    public boolean getHostMode() {
        return this.jvX;
    }

    public boolean cyB() {
        return czq();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean cyC() {
        return this.dtP;
    }

    public boolean cyD() {
        return this.jwb;
    }

    public boolean cyE() {
        return this.jwi;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean cyF() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bHK() {
        return this.jwc;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void zz(int i) {
        this.jwc = i;
    }

    public boolean cyG() {
        return this.iBS;
    }

    public boolean cyH() {
        if (this.jqV == null) {
            return false;
        }
        return this.jqV.isValid();
    }

    public String aKN() {
        if (this.jqV == null || !this.jqV.aGZ()) {
            return null;
        }
        return this.jqV.aGY();
    }

    public boolean zA(int i) {
        this.jwe = i;
        if (this.jwe > this.jqV.getPage().aJv()) {
            this.jwe = this.jqV.getPage().aJv();
        }
        if (this.jwe < 1) {
            this.jwe = 1;
        }
        if (this.jvS == null) {
            return false;
        }
        return zC(5);
    }

    public void zB(int i) {
        this.jwe = i;
        this.jwf = i;
        this.jwg = i;
    }

    public void b(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar == null) {
            zB(1);
            return;
        }
        if (this.jwf < apVar.aJy()) {
            this.jwf = apVar.aJy();
        }
        if (this.jwg > apVar.aJy()) {
            this.jwg = apVar.aJy();
        }
        this.jwh = apVar.aJv();
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        return this.jqV;
    }

    public BaijiahaoData cyI() {
        if (this.jqV == null || this.jqV.cvu() == null) {
            return null;
        }
        return this.jqV.cvu().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.e cyJ() {
        if (this.jqV == null) {
            return this.jqV;
        }
        if (!cyK() && this.jxb != null) {
            this.jqV.b(this.jxb);
        }
        return this.jqV;
    }

    private boolean cyK() {
        return (this.jqV.cvJ() == null || this.jqV.cvJ().cWf() == null || this.jqV.cvJ().cWf().goods != null || this.jqV.cvJ().cWf().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.ap getPageData() {
        if (this.jqV == null) {
            return null;
        }
        return this.jqV.getPage();
    }

    public boolean cyL() {
        if (czq() && this.jqV.getPage().aJA() == 0) {
            rf(true);
            return true;
        }
        return false;
    }

    public void h(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.jvS = eVar.getThreadId();
            if (eVar.cvu() != null && eVar.cvu().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = eVar.cvu().getBaijiahaoData();
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
            this.jvU = null;
            this.jvX = false;
            this.jvZ = true;
            LoadData();
        }
    }

    public void Hw(String str) {
        if (!StringUtils.isNull(str)) {
            this.jvS = str;
            this.jvU = null;
            this.jvX = false;
            this.jvZ = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.jvS == null) {
            return false;
        }
        cancelLoadData();
        if (this.gDP == null) {
            this.gDP = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.gDP.start();
        }
        boolean zC = zC(3);
        if (this.opType != null) {
            this.opType = null;
            this.jwu = null;
            this.opUrl = null;
            return zC;
        }
        return zC;
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
        if (this.jwQ != null) {
            this.jwQ.cancelLoadData();
        }
        if (this.jwR != null) {
            this.jwR.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.cOf().cOj();
        bJc();
    }

    private void bJc() {
        if (this.gDP != null) {
            this.gDP.destory();
            this.gDP = null;
        }
    }

    public boolean cyM() {
        return (this.jvU == null || this.jvU.equals("0") || this.jvU.length() == 0) ? LoadData() : cyQ();
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
                this.jwQ.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.jwQ.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.jwR == null) {
                this.jwR = new GetSugMatchWordsModel(this.gCG.getPageContext());
            }
            this.jwR.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0363 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x036b A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0243, B:78:0x024d, B:187:0x04f3, B:188:0x04f9, B:191:0x0506, B:81:0x025a, B:83:0x0283, B:84:0x02a1, B:86:0x02b9, B:88:0x02bf, B:90:0x02c6, B:91:0x02d3, B:93:0x02e7, B:95:0x02ed, B:97:0x02f3, B:106:0x0323, B:108:0x0329, B:98:0x02fe, B:100:0x0302, B:102:0x030a, B:104:0x0319, B:105:0x031e, B:109:0x0335, B:111:0x0349, B:113:0x034d, B:116:0x035f, B:119:0x0365, B:147:0x03db, B:122:0x036b, B:124:0x0371, B:125:0x0376, B:127:0x037a, B:129:0x0384, B:134:0x039b, B:136:0x03a9, B:137:0x03ac, B:139:0x03b0, B:140:0x03bb, B:142:0x03bf, B:144:0x03c7, B:146:0x03d6, B:148:0x03e0, B:150:0x03e4, B:131:0x0388, B:151:0x03ed, B:152:0x041b, B:154:0x041f, B:164:0x0450, B:157:0x042b, B:159:0x0439, B:160:0x0441, B:162:0x0445, B:163:0x044b, B:165:0x0459, B:167:0x0465, B:156:0x0423, B:168:0x046f, B:170:0x047b, B:172:0x047f, B:174:0x0483, B:175:0x0488, B:177:0x0494, B:178:0x049c, B:182:0x04b6, B:179:0x04a1, B:181:0x04b0, B:183:0x04bf, B:185:0x04ce, B:38:0x00e3), top: B:194:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x037a A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0243, B:78:0x024d, B:187:0x04f3, B:188:0x04f9, B:191:0x0506, B:81:0x025a, B:83:0x0283, B:84:0x02a1, B:86:0x02b9, B:88:0x02bf, B:90:0x02c6, B:91:0x02d3, B:93:0x02e7, B:95:0x02ed, B:97:0x02f3, B:106:0x0323, B:108:0x0329, B:98:0x02fe, B:100:0x0302, B:102:0x030a, B:104:0x0319, B:105:0x031e, B:109:0x0335, B:111:0x0349, B:113:0x034d, B:116:0x035f, B:119:0x0365, B:147:0x03db, B:122:0x036b, B:124:0x0371, B:125:0x0376, B:127:0x037a, B:129:0x0384, B:134:0x039b, B:136:0x03a9, B:137:0x03ac, B:139:0x03b0, B:140:0x03bb, B:142:0x03bf, B:144:0x03c7, B:146:0x03d6, B:148:0x03e0, B:150:0x03e4, B:131:0x0388, B:151:0x03ed, B:152:0x041b, B:154:0x041f, B:164:0x0450, B:157:0x042b, B:159:0x0439, B:160:0x0441, B:162:0x0445, B:163:0x044b, B:165:0x0459, B:167:0x0465, B:156:0x0423, B:168:0x046f, B:170:0x047b, B:172:0x047f, B:174:0x0483, B:175:0x0488, B:177:0x0494, B:178:0x049c, B:182:0x04b6, B:179:0x04a1, B:181:0x04b0, B:183:0x04bf, B:185:0x04ce, B:38:0x00e3), top: B:194:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03b0 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0243, B:78:0x024d, B:187:0x04f3, B:188:0x04f9, B:191:0x0506, B:81:0x025a, B:83:0x0283, B:84:0x02a1, B:86:0x02b9, B:88:0x02bf, B:90:0x02c6, B:91:0x02d3, B:93:0x02e7, B:95:0x02ed, B:97:0x02f3, B:106:0x0323, B:108:0x0329, B:98:0x02fe, B:100:0x0302, B:102:0x030a, B:104:0x0319, B:105:0x031e, B:109:0x0335, B:111:0x0349, B:113:0x034d, B:116:0x035f, B:119:0x0365, B:147:0x03db, B:122:0x036b, B:124:0x0371, B:125:0x0376, B:127:0x037a, B:129:0x0384, B:134:0x039b, B:136:0x03a9, B:137:0x03ac, B:139:0x03b0, B:140:0x03bb, B:142:0x03bf, B:144:0x03c7, B:146:0x03d6, B:148:0x03e0, B:150:0x03e4, B:131:0x0388, B:151:0x03ed, B:152:0x041b, B:154:0x041f, B:164:0x0450, B:157:0x042b, B:159:0x0439, B:160:0x0441, B:162:0x0445, B:163:0x044b, B:165:0x0459, B:167:0x0465, B:156:0x0423, B:168:0x046f, B:170:0x047b, B:172:0x047f, B:174:0x0483, B:175:0x0488, B:177:0x0494, B:178:0x049c, B:182:0x04b6, B:179:0x04a1, B:181:0x04b0, B:183:0x04bf, B:185:0x04ce, B:38:0x00e3), top: B:194:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03bf A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0243, B:78:0x024d, B:187:0x04f3, B:188:0x04f9, B:191:0x0506, B:81:0x025a, B:83:0x0283, B:84:0x02a1, B:86:0x02b9, B:88:0x02bf, B:90:0x02c6, B:91:0x02d3, B:93:0x02e7, B:95:0x02ed, B:97:0x02f3, B:106:0x0323, B:108:0x0329, B:98:0x02fe, B:100:0x0302, B:102:0x030a, B:104:0x0319, B:105:0x031e, B:109:0x0335, B:111:0x0349, B:113:0x034d, B:116:0x035f, B:119:0x0365, B:147:0x03db, B:122:0x036b, B:124:0x0371, B:125:0x0376, B:127:0x037a, B:129:0x0384, B:134:0x039b, B:136:0x03a9, B:137:0x03ac, B:139:0x03b0, B:140:0x03bb, B:142:0x03bf, B:144:0x03c7, B:146:0x03d6, B:148:0x03e0, B:150:0x03e4, B:131:0x0388, B:151:0x03ed, B:152:0x041b, B:154:0x041f, B:164:0x0450, B:157:0x042b, B:159:0x0439, B:160:0x0441, B:162:0x0445, B:163:0x044b, B:165:0x0459, B:167:0x0465, B:156:0x0423, B:168:0x046f, B:170:0x047b, B:172:0x047f, B:174:0x0483, B:175:0x0488, B:177:0x0494, B:178:0x049c, B:182:0x04b6, B:179:0x04a1, B:181:0x04b0, B:183:0x04bf, B:185:0x04ce, B:38:0x00e3), top: B:194:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03e4 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0243, B:78:0x024d, B:187:0x04f3, B:188:0x04f9, B:191:0x0506, B:81:0x025a, B:83:0x0283, B:84:0x02a1, B:86:0x02b9, B:88:0x02bf, B:90:0x02c6, B:91:0x02d3, B:93:0x02e7, B:95:0x02ed, B:97:0x02f3, B:106:0x0323, B:108:0x0329, B:98:0x02fe, B:100:0x0302, B:102:0x030a, B:104:0x0319, B:105:0x031e, B:109:0x0335, B:111:0x0349, B:113:0x034d, B:116:0x035f, B:119:0x0365, B:147:0x03db, B:122:0x036b, B:124:0x0371, B:125:0x0376, B:127:0x037a, B:129:0x0384, B:134:0x039b, B:136:0x03a9, B:137:0x03ac, B:139:0x03b0, B:140:0x03bb, B:142:0x03bf, B:144:0x03c7, B:146:0x03d6, B:148:0x03e0, B:150:0x03e4, B:131:0x0388, B:151:0x03ed, B:152:0x041b, B:154:0x041f, B:164:0x0450, B:157:0x042b, B:159:0x0439, B:160:0x0441, B:162:0x0445, B:163:0x044b, B:165:0x0459, B:167:0x0465, B:156:0x0423, B:168:0x046f, B:170:0x047b, B:172:0x047f, B:174:0x0483, B:175:0x0488, B:177:0x0494, B:178:0x049c, B:182:0x04b6, B:179:0x04a1, B:181:0x04b0, B:183:0x04bf, B:185:0x04ce, B:38:0x00e3), top: B:194:0x00d7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean zC(int i) {
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
        zD(i);
        final com.baidu.tieba.pb.data.e pbData = ah.czS().getPbData();
        if (pbData != null && pbData.cvu() != null) {
            pbData.cvu().jO(0);
            this.jvZ = ah.czS().cyB();
            this.jvX = ah.czS().czX();
            this.jwb = ah.czS().czY();
            this.jwV = ah.czS().czW();
            this.jwW = ah.czS().czV();
            this.jwX = ah.czS().czU();
            this.jwZ = ah.czS().czZ();
            this.mTabIndex = ah.czS().getTabIndex();
            this.jwS = this.jvX;
            if (this.jvX || this.isFromMark) {
                this.jwy = false;
            }
            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.jwC) {
            a(cyV(), true, this.jvU, 3);
        }
        if (i == 3 && !this.jwC) {
            if (this.isFromMark) {
                a(cyV(), true, this.jvU, 3);
            } else {
                a(cyV(), false, this.jvU, 3);
            }
        }
        this.jwC = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.jxb == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.dVU);
        if (this.jvX || this.isFromMark) {
            this.jwy = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.jvS == null || this.jvS.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.jvS, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.ar.aOV().aOW() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.jvZ) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.jvX) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.jwm) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.jwl));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.jwy) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.jwu, 0));
            pbPageRequestMessage.setOpMessageID(this.jwl);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> cvw = this.jqV.cvw();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jwg - 1));
                        if (this.jwg - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.jwj) {
                                if (cvw != null && cvw.size() > 0) {
                                    size = cvw.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = cvw.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.jvU = postData.getId();
                                            if (StringUtils.isNull(this.jvU)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.jwf + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.jvU == null && this.jvU.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jvU, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jwf + 1));
                        if (this.jwf >= this.jwh) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (cvw != null) {
                                size = cvw.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.jvU == null) {
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
                if (cvw != null) {
                }
                if (this.jvU == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (cvw != null && cvw.size() > 0 && cvw.get(0) != null) {
                    this.jvU = cvw.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (czq()) {
                        if (this.jwg - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.jwg - 1));
                        }
                    } else if (this.jwf < this.jwh) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jwf + 1));
                    }
                }
                if (this.jvU != null && this.jvU.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jvU, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.jvX) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (czq()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.jwh > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jwh));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jvU, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.jwe));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.jwS && !this.jvX) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jvU, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.jvX) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.jwG);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jwU, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.jwS = this.jvX;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cyV());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.jwT));
        pbPageRequestMessage.setIsSubPostDataReverse(this.jwF);
        pbPageRequestMessage.setFromSmartFrs(this.jwI ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.jvW);
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.jwh) {
                    i4 = -1;
                } else {
                    i4 = czx();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = czx();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.jvS);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean cwt() {
        switch (czj()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().cvu() == null || !getPbData().cvu().aLY();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cwu()) && com.baidu.tieba.recapp.q.cNo().cNi() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.cNo().cNi().aD(cwu(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.cNo().cNi().aE(cwu(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cwu()) && com.baidu.tieba.recapp.q.cNo().cNi() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.cNo().cNi().aE(cwu(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.cNo().cNi().aD(cwu(), true));
        }
    }

    protected void zD(int i) {
        boolean z = false;
        zI(i);
        ArrayList<PostData> cvw = this.jqV.cvw();
        this.jwB = false;
        if (i == 1) {
            boolean z2 = false;
            while (cvw.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cvw.remove(0);
                z2 = true;
            }
            if (z2) {
                this.jqV.getPage().jM(1);
                if (this.jwt != null) {
                    this.jwt.e(this.jqV);
                }
            }
            this.hqR = System.currentTimeMillis();
            this.jwB = true;
        } else if (i == 2) {
            while (cvw.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cvw.remove(cvw.size() - 1);
                z = true;
            }
            if (z) {
                this.jqV.getPage().jL(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.e eVar2 = z ? null : eVar;
        this.jwJ = i2;
        this.isLoading = false;
        if (eVar2 != null) {
            j(eVar2);
        }
        i(eVar2);
        if (this.jxb != null && this.jxb.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(eVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void i(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvJ() != null && eVar.cvJ().cWf() != null && eVar.cvJ().cWf().goods != null && eVar.cvJ().isValidate() && eVar.cvJ().cWf().goods.goods_style != 1001) {
            this.jxb = eVar.cvJ();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m cyN() {
        return this.jxb;
    }

    public void cyO() {
        this.jxb = null;
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

    protected void j(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            if (this.jwr || this.jwp || this.jwq) {
                eVar = l(eVar);
            }
            k(eVar);
        }
    }

    protected void k(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            String m = m(eVar);
            for (int i = 0; i < eVar.cvw().size(); i++) {
                PostData postData = eVar.cvw().get(i);
                for (int i2 = 0; i2 < postData.cWo().size(); i2++) {
                    postData.cWo().get(i2).a(this.gCG.getPageContext(), m.equals(postData.cWo().get(i2).aKE().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n cvF = eVar.cvF();
            if (cvF != null && !com.baidu.tbadk.core.util.v.isEmpty(cvF.joL)) {
                for (PostData postData2 : cvF.joL) {
                    for (int i3 = 0; i3 < postData2.cWo().size(); i3++) {
                        postData2.cWo().get(i3).a(this.gCG.getPageContext(), m.equals(postData2.cWo().get(i3).aKE().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i) {
        if (eVar != null) {
            String m = m(eVar);
            com.baidu.tieba.pb.data.n cvF = eVar.cvF();
            if (cvF != null && !com.baidu.tbadk.core.util.v.isEmpty(cvF.joL)) {
                for (PostData postData : cvF.joL.subList(i, cvF.joL.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cWo().size()) {
                            postData.cWo().get(i3).a(this.gCG.getPageContext(), m.equals(postData.cWo().get(i3).aKE().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.e l(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null) {
            return null;
        }
        bj cvu = eVar.cvu();
        cvu.jT(this.mIsGood);
        cvu.jS(this.jwc);
        if (this.jwd > 0) {
            cvu.ca(this.jwd);
            return eVar;
        }
        return eVar;
    }

    protected String m(com.baidu.tieba.pb.data.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.cvu() != null && eVar.cvu().aKE() != null) {
            str = eVar.cvu().aKE().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData cyP() {
        if (this.jqV == null || this.jqV.cvu() == null || this.jqV.cvu().aKE() == null) {
            return null;
        }
        return this.jqV.cvu().aKE();
    }

    protected void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int size;
        int i4;
        int i5;
        boolean z4 = !z;
        this.jwH = z3;
        this.jwo = i;
        if (this.gDP != null && !z3) {
            this.gDP.a(z2, z4, i2, str, i3, j, j2);
            this.gDP = null;
        }
        if (this.jqV != null) {
            this.jqV.joj = z3;
            this.jqV.WA = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(cwu()) && com.baidu.tieba.recapp.q.cNo().cNi() != null) {
            com.baidu.tieba.recapp.q.cNo().cNi().f(cwu(), zE(cyY()), true);
        }
        if (eVar == null || (this.jwe == 1 && i == 5 && eVar.cvw() != null && eVar.cvw().size() < 1)) {
            if (this.jwt != null) {
                this.jvZ = this.jvY;
                if (i2 != 350006) {
                    this.mSortType = this.jwa;
                }
                this.jwt.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.jvY = this.jvZ;
            if (i != 8) {
                this.jwa = this.mSortType;
                this.mSortType = eVar.jnw;
            }
            if (eVar.jnv != null && eVar.jnv.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.gCG.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                eVar.jnv = new ArrayList();
                eVar.jnv.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.gCG.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                eVar.jnv.add(builder2.build(false));
                this.mSortType = this.jwa;
                eVar.jnw = this.mSortType;
            }
            this.jwm = false;
            if (eVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(eVar.getPage());
            }
            this.jwh = this.jwh < 1 ? 1 : this.jwh;
            ArrayList<PostData> cvw = this.jqV.cvw();
            switch (i) {
                case 1:
                    this.jqV.a(eVar.getPage(), 1);
                    d(eVar, cvw);
                    i4 = 0;
                    break;
                case 2:
                    if (eVar.cvw() == null) {
                        i5 = 0;
                    } else {
                        int size2 = eVar.cvw().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(cvw, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cvw(), com.baidu.tbadk.core.util.v.getCount(eVar.cvw()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            eVar.cvw().remove(postData2);
                            i5 = size2 - 1;
                        }
                        cvw.addAll(0, eVar.cvw());
                    }
                    this.jqV.a(eVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && eVar.getPage() != null) {
                        eVar.getPage().jJ(eVar.getPage().aJv());
                    }
                    n(eVar);
                    i4 = 0;
                    break;
                case 4:
                    n(eVar);
                    i4 = 0;
                    break;
                case 5:
                    n(eVar);
                    i4 = 0;
                    break;
                case 6:
                    n(eVar);
                    i4 = 0;
                    break;
                case 7:
                    n(eVar);
                    i4 = 0;
                    break;
                case 8:
                    if (eVar != null && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cvw()) && this.jqV != null && (!this.jvX || m(eVar).equals(eVar.cvw().get(0).aKE().getUserId()))) {
                        if (this.jqV.getPage().aJA() == 0) {
                            this.jqV.getPage().jL(1);
                        }
                        czk();
                        this.jwV = eVar.cvw().get(0);
                        if (czq() || this.jqV.cvS()) {
                            if (this.jqV.cvw().size() - this.jwX >= 3) {
                                this.jwW = new PostData();
                                this.jwW.kSQ = true;
                                this.jwW.setPostType(53);
                                this.jqV.cvw().add(this.jwW);
                            }
                            this.jqV.cvw().add(this.jwV);
                            size = this.jqV.cvw().size() - 1;
                        } else {
                            if (this.jwX - this.jwY >= 3) {
                                this.jwW = new PostData();
                                this.jwW.kSQ = false;
                                this.jwW.setPostType(53);
                                this.jqV.cvw().add(0, this.jwW);
                            }
                            this.jqV.cvw().add(0, this.jwV);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.isTaday(com.baidu.tbadk.core.sharedPref.b.aNV().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.jwV.kTd = this.jqV.cvQ();
                            com.baidu.tbadk.core.sharedPref.b.aNV().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        }
                        i4 = size;
                        break;
                    }
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.jqV != null && this.jqV.cvu() != null) {
                PraiseData aKp = this.jqV.cvu().aKp();
                if (this.jxk != null && !aKp.isPriaseDataValid()) {
                    this.jqV.cvu().a(this.jxk);
                } else {
                    this.jxk = this.jqV.cvu().aKp();
                    this.jxk.setPostId(this.jqV.cvu().aKU());
                }
                if (eVar.getPage() != null && eVar.getPage().aJy() == 1 && eVar.cvu() != null && eVar.cvu().aKP() != null && eVar.cvu().aKP().size() > 0) {
                    this.jqV.cvu().x(eVar.cvu().aKP());
                }
                this.jqV.cvu().jQ(eVar.cvu().aKv());
                this.jqV.cvu().jN(eVar.cvu().getAnchorLevel());
                this.jqV.cvu().jO(eVar.cvu().aKl());
                if (this.mThreadType == 33) {
                    this.jqV.cvu().aKE().setHadConcerned(eVar.cvu().aKE().hadConcerned());
                }
                if (eVar != null && eVar.cvu() != null) {
                    this.jqV.cvu().jV(eVar.cvu().aKT());
                }
            }
            if (this.jqV != null && this.jqV.getUserData() != null && eVar.getUserData() != null) {
                this.jqV.getUserData().setBimg_end_time(eVar.getUserData().getBimg_end_time());
                this.jqV.getUserData().setBimg_url(eVar.getUserData().getBimg_url());
            }
            if (eVar.getPage() != null && eVar.getPage().aJy() == 1 && eVar.cvE() != null) {
                this.jqV.e(eVar.cvE());
            }
            if (this.jwH) {
                if (this.jqV.cvu() != null && this.jqV.cvu().aKE() != null && this.jqV.cvw() != null && com.baidu.tbadk.core.util.v.getItem(this.jqV.cvw(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(this.jqV.cvw(), 0);
                    MetaData aKE = this.jqV.cvu().aKE();
                    if (postData3.aKE() != null && postData3.aKE().getGodUserData() != null) {
                        if (this.jww != -1) {
                            aKE.setFansNum(this.jww);
                            postData3.aKE().setFansNum(this.jww);
                        }
                        if (this.jwx != -1) {
                            aKE.getGodUserData().setIsLike(this.jwx == 1);
                            postData3.aKE().getGodUserData().setIsLike(this.jwx == 1);
                            aKE.getGodUserData().setIsFromNetWork(false);
                            postData3.aKE().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.jqV.jnu = -1;
                this.jqV.jnt = -1;
            }
            if (this.jwt != null) {
                this.jwt.a(true, getErrorCode(), i, i4, this.jqV, this.mErrorString, 1);
            }
        }
        if (this.jqV != null && this.jqV.cvu() != null && this.jqV.getForum() != null && !this.jqV.cvS()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.gCG.getPageContext();
            historyMessage.threadId = getPbData().cvu().getId();
            if (this.mIsShareThread && getPbData().cvu().dto != null) {
                historyMessage.threadName = getPbData().cvu().dto.showText;
            } else {
                historyMessage.threadName = getPbData().cvu().getTitle();
            }
            if (this.mIsShareThread && !cwt()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = cyB();
            historyMessage.threadType = getPbData().cvu().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        String aN;
        if (arrayList != null && eVar.cvw() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cvw(), 0);
            if (postData != null && (aN = aN(arrayList)) != null && aN.equals(postData.getId())) {
                eVar.cvw().remove(postData);
            }
            this.jqV.joi = arrayList.size();
            arrayList.addAll(eVar.cvw());
        }
    }

    private int zE(int i) {
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

    private String aN(ArrayList<PostData> arrayList) {
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

    private void n(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            eVar.Hr(this.jqV.cvL());
            this.jqV = eVar;
            zB(eVar.getPage().aJy());
        }
    }

    public boolean cyQ() {
        if (this.jvS == null || this.jvU == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return zC(4);
        }
        return zC(6);
    }

    public boolean rf(boolean z) {
        if (this.jvS == null || this.jqV == null) {
            return false;
        }
        if (z || this.jqV.getPage().aJA() != 0) {
            return zC(1);
        }
        return false;
    }

    public boolean rg(boolean z) {
        if (this.jvS == null || this.jqV == null) {
            return false;
        }
        if ((z || this.jqV.getPage().aJB() != 0) && this.jqV.cvw() != null && this.jqV.cvw().size() >= 1) {
            return zC(2);
        }
        return false;
    }

    public boolean HC(String str) {
        this.jvX = !this.jvX;
        this.jvU = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").af("obj_source", 0));
        if (zC(6)) {
            return true;
        }
        this.jvX = this.jvX ? false : true;
        return false;
    }

    public boolean w(boolean z, String str) {
        if (this.jvX == z) {
            return false;
        }
        this.jvX = z;
        this.jvU = str;
        if (this.mSortType == 2) {
            this.jvU = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").af("obj_source", 1));
        }
        if (zC(6)) {
            return true;
        }
        this.jvX = z ? false : true;
        return false;
    }

    public boolean zF(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.jvY = this.jvZ;
        this.jwa = this.mSortType;
        this.mSortType = i;
        this.jvZ = !this.jvZ;
        if (i == 2 && this.isFromMark) {
            this.jvU = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.jvZ = this.jvZ ? false : true;
            this.mSortType = this.jwa;
            return false;
        }
        return true;
    }

    public boolean cyR() {
        return czq();
    }

    public int cyS() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.jqV == null || this.jqV.getForum() == null || this.jqV.cvu() == null) ? false : true;
    }

    public boolean aGZ() {
        if (this.jqV == null) {
            return false;
        }
        return this.jqV.aGZ();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData ww(String str) {
        if (this.jqV == null || this.jqV.cvu() == null || this.jqV.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.jqV.cvu().aLY()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.jqV.getForum().getId());
            writeData.setForumName(this.jqV.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.jwT);
        writeData.setThreadId(this.jvS);
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

    public MarkData zG(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.jqV == null) {
            return null;
        }
        ArrayList<PostData> cvw = this.jqV.cvw();
        if (com.baidu.tbadk.core.util.v.isEmpty(cvw)) {
            return null;
        }
        if (cvw.size() > 0 && i >= cvw.size()) {
            i = cvw.size() - 1;
        }
        return l(cvw.get(i));
    }

    public MarkData cyT() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.jvS);
        markData.setPostId(this.jqV.aGY());
        markData.setTime(date.getTime());
        markData.setHostMode(this.jvX);
        markData.setSequence(Boolean.valueOf(czq()));
        markData.setId(this.jvS);
        return markData;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.jvS);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.jvX);
        markData.setSequence(Boolean.valueOf(czq()));
        markData.setId(this.jvS);
        markData.setFloor(postData.cWr());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void cyU() {
        i.cxj().ax(cyV(), this.isFromMark);
    }

    private String cyV() {
        String cyW = (this.jvS == null || this.jvS.equals("0")) ? cyW() : this.jvS;
        if (this.jvX) {
            cyW = cyW + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            cyW = cyW + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return cyW + TbadkCoreApplication.getCurrentAccount();
        }
        return cyW;
    }

    private String cyW() {
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

    public void rh(boolean z) {
        if (this.jqV != null) {
            this.jqV.gk(z);
        }
    }

    public boolean cyX() {
        return this.jwy;
    }

    public void a(a aVar) {
        this.jwt = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aXk() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aXj() {
        return cyM();
    }

    public boolean HD(String str) {
        if (getPbData() == null || getPbData().cvu() == null || getPbData().cvu().aKE() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().cvu().aKE().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int cyY() {
        return this.mRequestType;
    }

    public void cyZ() {
        if ("personalize_page".equals(this.mStType)) {
            this.jwE = System.currentTimeMillis() / 1000;
        }
    }

    public void cza() {
        if ("personalize_page".equals(this.mStType) && this.jqV != null && this.jwE != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").cI("fid", this.jqV.getForumId()).cI("tid", this.jvS).cI("obj_duration", String.valueOf(currentTimeMillis - this.jwE)).cI(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.jwE = 0L;
        }
    }

    public boolean czb() {
        return this.jwH;
    }

    public int getErrorNo() {
        return this.jwJ;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public n czc() {
        return this.jwL;
    }

    public x czd() {
        return this.jwM;
    }

    public CheckRealNameModel cze() {
        return this.jwO;
    }

    public AddExperiencedModel czf() {
        return this.jwP;
    }

    public String czg() {
        return this.jwD;
    }

    public void HE(String str) {
        this.jwD = str;
    }

    public boolean czh() {
        return this.jwI;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.jqV != null && this.jqV.cvw() != null && this.jqV.cvw().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.jqV.cvw().size();
                for (int i = 0; i < size; i++) {
                    if (this.jqV.cvw().get(i) != null && this.jqV.cvw().get(i).aKE() != null && currentAccount.equals(this.jqV.cvw().get(i).aKE().getUserId()) && this.jqV.cvw().get(i).aKE().getPendantData() != null) {
                        this.jqV.cvw().get(i).aKE().getPendantData().tO(kVar.aIW());
                        this.jqV.cvw().get(i).aKE().getPendantData().cp(kVar.aWu());
                    }
                }
            }
        }
    }

    public String czi() {
        return this.jwN;
    }

    public int czj() {
        return this.jwT;
    }

    public void zH(int i) {
        this.jwT = i;
    }

    public void HF(String str) {
        if ((!this.jvX || HD(TbadkCoreApplication.getCurrentAccount())) && this.jqV.cvw() != null) {
            this.jqV.getPage().jL(1);
            if (this.jqV.getPage().aJA() == 0) {
                this.jqV.getPage().jL(1);
            }
            this.jwU = str;
            zC(8);
        }
    }

    private void zI(int i) {
        if (i != 8) {
            this.jwU = "";
            if (this.jwV != null) {
                if (i == 1 && this.jqV != null && this.jqV.cvS()) {
                    if (this.jwW != null) {
                        getPbData().cvw().remove(this.jwW);
                    }
                } else if (i == 1 && !this.jvZ && !com.baidu.tbadk.core.util.v.isEmpty(getPbData().cvw())) {
                    getPbData().cvw().remove(this.jwV);
                    if (this.jwW != null) {
                        getPbData().cvw().remove(this.jwW);
                    }
                    getPbData().cvw().add(0, this.jwV);
                } else {
                    getPbData().cvw().remove(this.jwV);
                    if (this.jwW != null) {
                        getPbData().cvw().remove(this.jwW);
                    }
                }
            }
            this.jwW = null;
        }
    }

    public void czk() {
        if (this.jqV != null && !com.baidu.tbadk.core.util.v.isEmpty(this.jqV.cvw())) {
            if (this.jwW != null) {
                this.jqV.cvw().remove(this.jwW);
                this.jwW = null;
            }
            if (this.jwV != null) {
                this.jqV.cvw().remove(this.jwV);
                this.jwV = null;
            }
        }
    }

    public void cy(int i, int i2) {
        this.jwX = i;
        this.jwY = i2;
    }

    public PostData czl() {
        return this.jwV;
    }

    public PostData czm() {
        return this.jwW;
    }

    public int czn() {
        return this.jwX;
    }

    public int czo() {
        return this.jwY;
    }

    public String czp() {
        return this.jxa;
    }

    public void HG(String str) {
        this.jxa = str;
    }

    private boolean czq() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean czr() {
        return this.jwT == 13 || this.jwT == 12;
    }

    public String czs() {
        return this.jxd;
    }

    public String czt() {
        return this.jxe;
    }

    public String czu() {
        return this.jxf;
    }

    public String czv() {
        return this.jxg;
    }

    public Rect czw() {
        Rect rect = this.jwZ;
        this.jwZ = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int czx() {
        int i;
        int i2 = 0;
        if (getPbData().cvw() == null) {
            return 0;
        }
        ArrayList<PostData> cvw = getPbData().cvw();
        int size = cvw.size() - 1;
        while (size >= 0) {
            PostData postData = cvw.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
                if (postData.getType() != AdvertAppInfo.dmc) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return cvw.size();
    }
}
