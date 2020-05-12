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
    private boolean dtT;
    private BaseFragmentActivity gCM;
    private com.baidu.tieba.tbadkCore.d.b gDV;
    private long hqX;
    private boolean iBY;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    protected com.baidu.tieba.pb.data.e jqZ;
    protected String jvW;
    private String jvX;
    private String jvY;
    private String jvZ;
    private int jwA;
    private int jwB;
    private boolean jwC;
    private boolean jwD;
    private boolean jwE;
    private boolean jwF;
    private boolean jwG;
    private String jwH;
    private long jwI;
    private boolean jwJ;
    private int jwK;
    private boolean jwL;
    private boolean jwM;
    private int jwN;
    private final v jwO;
    private final n jwP;
    private final x jwQ;
    private String jwR;
    private final CheckRealNameModel jwS;
    private final AddExperiencedModel jwT;
    private SuggestEmotionModel jwU;
    private GetSugMatchWordsModel jwV;
    private boolean jwW;
    private int jwX;
    private String jwY;
    private PostData jwZ;
    private boolean jwa;
    private boolean jwb;
    private boolean jwc;
    private boolean jwd;
    private int jwe;
    private boolean jwf;
    private int jwg;
    private long jwh;
    private int jwi;
    private int jwj;
    private int jwk;
    private int jwl;
    private boolean jwm;
    private boolean jwn;
    private boolean jwo;
    private long jwp;
    private boolean jwq;
    private String jwr;
    private int jws;
    private boolean jwt;
    private boolean jwu;
    private boolean jwv;
    private boolean jww;
    private a jwx;
    private String jwy;
    private String jwz;
    private PostData jxa;
    private int jxb;
    private int jxc;
    private Rect jxd;
    private String jxe;
    private com.baidu.tieba.tbadkCore.data.m jxf;
    private boolean jxg;
    private String jxh;
    private String jxi;
    private String jxj;
    private String jxk;
    private f.a jxl;
    private CustomMessageListener jxm;
    private com.baidu.adp.framework.listener.a jxn;
    private PraiseData jxo;
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
    private static final int jvV = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.jvW = null;
        this.jvX = null;
        this.jvY = null;
        this.mForumId = null;
        this.jvZ = null;
        this.jwa = false;
        this.jwb = false;
        this.jwc = true;
        this.jwd = true;
        this.mSortType = 0;
        this.jwe = 0;
        this.jwf = false;
        this.mIsGood = 0;
        this.jwg = 0;
        this.jwh = 0L;
        this.jwi = 1;
        this.jwj = 1;
        this.jwk = 1;
        this.jwl = 1;
        this.isAd = false;
        this.iBY = false;
        this.dtT = false;
        this.jwm = false;
        this.isFromMark = false;
        this.jwn = false;
        this.jwo = false;
        this.jwp = 0L;
        this.jwq = false;
        this.jwr = null;
        this.jqZ = null;
        this.isLoading = false;
        this.jwt = false;
        this.jwu = false;
        this.jwv = false;
        this.jww = false;
        this.mLocate = null;
        this.mContext = null;
        this.jwx = null;
        this.opType = null;
        this.opUrl = null;
        this.jwy = null;
        this.jwz = null;
        this.jwA = -1;
        this.jwB = -1;
        this.gDV = null;
        this.jwD = false;
        this.jwE = false;
        this.postID = null;
        this.jwH = null;
        this.jwI = 0L;
        this.jwJ = false;
        this.jwK = -1;
        this.jwM = false;
        this.jwW = false;
        this.jwX = 0;
        this.mTabIndex = 0;
        this.jxg = false;
        this.jxm = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.jxn = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.gCM.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.jwD || !PbModel.this.jwE) {
                        if (!PbModel.this.jwD) {
                            PbModel.this.jwD = true;
                        } else {
                            PbModel.this.jwE = true;
                        }
                        if (PbModel.this.jwx != null) {
                            PbModel.this.jwx.a(PbModel.this.cyt(), z, responsedMessage, PbModel.this.jwF, System.currentTimeMillis() - PbModel.this.hqX);
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
                    if (PbModel.this.jqZ != null && PbModel.this.jqZ.cvr() != null && PbModel.this.jqZ.cvr().getForumId() != null && PbModel.this.jqZ.cvr().getForumId().equals(valueOf)) {
                        PbModel.this.jqZ.cvr().setIsLike(false);
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
                    if (PbModel.this.jqZ != null && PbModel.this.jqZ.cvr() != null && PbModel.this.jqZ.cvr().getForumId() != null && PbModel.this.jqZ.cvr().getForumId().equals(valueOf)) {
                        PbModel.this.jqZ.cvr().setIsLike(true);
                    }
                }
            }
        };
        this.jxo = null;
        registerListener(this.jxn);
        registerListener(this.jxm);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.jqZ = new com.baidu.tieba.pb.data.e();
        this.jqZ.zj(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.gCM = baseFragmentActivity;
        this.jwO = new v(this, this.gCM);
        this.jwP = new n(this, this.gCM);
        this.jwQ = new x(this, this.gCM);
        this.jwS = new CheckRealNameModel(this.gCM.getPageContext());
        this.jwU = new SuggestEmotionModel();
        this.jwT = new AddExperiencedModel(this.gCM.getPageContext());
        this.jxl = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void B(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dhB) instanceof String) {
                        PbModel.this.jvW = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dhB);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dhC) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dhC);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dhD) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dhD);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dhE) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.dhE), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dhF) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dhF);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, String str) {
        this.jwG = true;
        if (eVar != null && eVar.jnB == null) {
            n(eVar);
            j(eVar);
            if (eVar.cvs() != null) {
                eVar.cvs().jO(0);
            }
            if (this.jwx != null && eVar != null) {
                this.jwx.a(true, 0, i, 0, eVar, str, 0);
            }
        }
    }

    protected int cyt() {
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
            this.jvW = intent.getStringExtra("thread_id");
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.n(uri)) {
                com.baidu.tbadk.BdToken.f.aGb().c(uri, this.jxl);
            } else if (StringUtils.isNull(this.jvW)) {
                this.jwO.a(intent, this.jxl);
                if (uri != null) {
                    if (StringUtils.isNull(this.jvW)) {
                        this.jvW = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.aq.isEmpty(this.jvW)) {
                this.jvW = "0";
            }
            this.jwX = intent.getIntExtra("key_start_from", 0);
            if (this.jwX == 0) {
                this.jwX = this.jwO.aqV;
            }
            this.jvY = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.jvX = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.jwa = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.jwb = intent.getBooleanExtra("host_only", false);
            this.jwd = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.aZX().aRx() ? 2 : 0);
            if (this.mSortType == 2) {
                this.jvY = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.jwg = intent.getIntExtra("is_top", 0);
            this.jwh = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.jwn = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.jwo = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.iBY = intent.getBooleanExtra("is_sub_pb", false);
            this.jwq = intent.getBooleanExtra("is_pv", false);
            this.jwp = intent.getLongExtra("msg_id", 0L);
            this.jwr = intent.getStringExtra("from_forum_name");
            this.jwz = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.jwy = intent.getStringExtra("op_stat");
            this.jwt = intent.getBooleanExtra("is_from_thread_config", false);
            this.jwu = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.jwv = intent.getBooleanExtra("is_from_my_god_config", false);
            this.jwB = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.jwA = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.dtT = intent.getBooleanExtra("from_frs", false);
            this.jwm = intent.getBooleanExtra("from_maintab", false);
            this.jwM = intent.getBooleanExtra("from_smart_frs", false);
            this.jww = intent.getBooleanExtra("from_hottopic", false);
            this.jwR = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.jvZ = intent.getStringExtra("high_light_post_id");
            this.jxg = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.jwC = intent.getIntExtra("request_code", -1) == 18003;
            this.jxh = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.jxi = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.jxj = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.jxk = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean cyu() {
        return this.jxg && com.baidu.tieba.frs.i.bOl() != null && com.baidu.tieba.frs.i.bOl().equals(this.jvW) && com.baidu.tieba.frs.i.bOk() != null;
    }

    public com.baidu.tieba.pb.data.e aI(bj bjVar) {
        com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
        eVar.zj(3);
        if (bjVar == null) {
            return null;
        }
        eVar.aG(bjVar);
        if (bjVar.aMn() != null) {
            eVar.e(bjVar.aMn());
            ForumData forum = eVar.getForum();
            forum.setId(bjVar.aMn().getForumId());
            forum.setName(bjVar.aMn().getForumName());
            forum.setUser_level(bjVar.aMn().aJT());
            forum.setImage_url(bjVar.aMn().getAvatar());
            forum.setPost_num(bjVar.aMn().postNum);
            forum.setMember_num(bjVar.aMn().memberNum);
        } else {
            ForumData forum2 = eVar.getForum();
            forum2.setId(String.valueOf(bjVar.getFid()));
            forum2.setName(bjVar.aKH());
        }
        PostData postData = new PostData();
        postData.Di(1);
        postData.setTime(bjVar.getCreateTime());
        postData.a(bjVar.aKC());
        MetaData aKC = bjVar.aKC();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(aKC.getUserId(), aKC);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bjVar.aKs(), false));
        eVar.d(postData);
        eVar.cvu().add(postData);
        eVar.a(new com.baidu.tieba.pb.data.k(bjVar, null));
        eVar.jnG = true;
        eVar.setIsNewUrl(1);
        return eVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.jwX = bundle.getInt("key_start_from", 0);
        this.jvW = bundle.getString("thread_id");
        this.jvY = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.jvX = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.jwa = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.jwb = bundle.getBoolean("host_only", false);
        this.jwd = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.jwg = bundle.getInt("is_top", 0);
        this.jwh = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.jwo = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.iBY = bundle.getBoolean("is_sub_pb", false);
        this.jwq = bundle.getBoolean("is_pv", false);
        this.jwp = bundle.getLong("msg_id", 0L);
        this.jwr = bundle.getString("from_forum_name");
        this.jwz = bundle.getString("extra_pb_cache_key");
        this.jwt = bundle.getBoolean("is_from_thread_config", false);
        this.jwu = bundle.getBoolean("is_from_interview_live_config", false);
        this.jwv = bundle.getBoolean("is_from_my_god_config", false);
        this.jwB = bundle.getInt("extra_pb_is_attention_key", -1);
        this.jwA = bundle.getInt("extra_pb_funs_count_key", -1);
        this.dtT = bundle.getBoolean("from_frs", false);
        this.jwm = bundle.getBoolean("from_maintab", false);
        this.jwM = bundle.getBoolean("from_smart_frs", false);
        this.jww = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.jvZ = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.jwC = bundle.getInt("request_code", -1) == 18003;
        this.jxh = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.jxi = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.jxj = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.jxk = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void au(Bundle bundle) {
        bundle.putString("thread_id", this.jvW);
        bundle.putString("post_id", this.jvY);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.jwX);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.jwa);
        bundle.putBoolean("host_only", this.jwb);
        bundle.putBoolean("squence", this.jwd);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.jwg);
        bundle.putLong("thread_time", this.jwh);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.jwo);
        bundle.putBoolean("is_sub_pb", this.iBY);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.jwq);
        bundle.putLong("msg_id", this.jwp);
        bundle.putString("extra_pb_cache_key", this.jwz);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.jwt);
        bundle.putBoolean("is_from_interview_live_config", this.jwu);
        bundle.putBoolean("is_from_my_god_config", this.jwv);
        bundle.putInt("extra_pb_is_attention_key", this.jwB);
        bundle.putInt("extra_pb_funs_count_key", this.jwA);
        bundle.putBoolean("from_frs", this.dtT);
        bundle.putBoolean("from_maintab", this.jwm);
        bundle.putBoolean("from_smart_frs", this.jwM);
        bundle.putBoolean("from_hottopic", this.jww);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.jvZ);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.jxh);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.jxi);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.jxj);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.jxk);
    }

    public String cyv() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.jvW);
        if (!this.jwo) {
            sb.append(this.jvY);
        }
        sb.append(this.jwb);
        sb.append(this.jwd);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.jwg);
        sb.append(this.jwh);
        sb.append(this.dtT);
        sb.append(this.jwm);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.iBY);
        sb.append(this.jwq);
        sb.append(this.jwp);
        sb.append(this.jwr);
        sb.append(this.mThreadType);
        sb.append(this.jwt);
        sb.append(this.jwu);
        sb.append(this.jwv);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.jwz != null) {
            sb.append(this.jwz);
        }
        return sb.toString();
    }

    public String cws() {
        return this.jwr;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cyw() {
        return this.jvY;
    }

    public String cyx() {
        return this.jvZ;
    }

    public String cyy() {
        return this.jvW;
    }

    public boolean getHostMode() {
        return this.jwb;
    }

    public boolean cyz() {
        return czo();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean cyA() {
        return this.dtT;
    }

    public boolean cyB() {
        return this.jwf;
    }

    public boolean cyC() {
        return this.jwm;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean cyD() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bHJ() {
        return this.jwg;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void zz(int i) {
        this.jwg = i;
    }

    public boolean cyE() {
        return this.iBY;
    }

    public boolean cyF() {
        if (this.jqZ == null) {
            return false;
        }
        return this.jqZ.isValid();
    }

    public String aKL() {
        if (this.jqZ == null || !this.jqZ.aGX()) {
            return null;
        }
        return this.jqZ.aGW();
    }

    public boolean zA(int i) {
        this.jwi = i;
        if (this.jwi > this.jqZ.getPage().aJt()) {
            this.jwi = this.jqZ.getPage().aJt();
        }
        if (this.jwi < 1) {
            this.jwi = 1;
        }
        if (this.jvW == null) {
            return false;
        }
        return zC(5);
    }

    public void zB(int i) {
        this.jwi = i;
        this.jwj = i;
        this.jwk = i;
    }

    public void b(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar == null) {
            zB(1);
            return;
        }
        if (this.jwj < apVar.aJw()) {
            this.jwj = apVar.aJw();
        }
        if (this.jwk > apVar.aJw()) {
            this.jwk = apVar.aJw();
        }
        this.jwl = apVar.aJt();
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        return this.jqZ;
    }

    public BaijiahaoData cyG() {
        if (this.jqZ == null || this.jqZ.cvs() == null) {
            return null;
        }
        return this.jqZ.cvs().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.e cyH() {
        if (this.jqZ == null) {
            return this.jqZ;
        }
        if (!cyI() && this.jxf != null) {
            this.jqZ.b(this.jxf);
        }
        return this.jqZ;
    }

    private boolean cyI() {
        return (this.jqZ.cvH() == null || this.jqZ.cvH().cWd() == null || this.jqZ.cvH().cWd().goods != null || this.jqZ.cvH().cWd().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.ap getPageData() {
        if (this.jqZ == null) {
            return null;
        }
        return this.jqZ.getPage();
    }

    public boolean cyJ() {
        if (czo() && this.jqZ.getPage().aJy() == 0) {
            rf(true);
            return true;
        }
        return false;
    }

    public void h(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.jvW = eVar.getThreadId();
            if (eVar.cvs() != null && eVar.cvs().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = eVar.cvs().getBaijiahaoData();
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
            this.jvY = null;
            this.jwb = false;
            this.jwd = true;
            LoadData();
        }
    }

    public void Hz(String str) {
        if (!StringUtils.isNull(str)) {
            this.jvW = str;
            this.jvY = null;
            this.jwb = false;
            this.jwd = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.jvW == null) {
            return false;
        }
        cancelLoadData();
        if (this.gDV == null) {
            this.gDV = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.gDV.start();
        }
        boolean zC = zC(3);
        if (this.opType != null) {
            this.opType = null;
            this.jwy = null;
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
        if (this.jwU != null) {
            this.jwU.cancelLoadData();
        }
        if (this.jwV != null) {
            this.jwV.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.cOd().cOh();
        bJb();
    }

    private void bJb() {
        if (this.gDV != null) {
            this.gDV.destory();
            this.gDV = null;
        }
    }

    public boolean cyK() {
        return (this.jvY == null || this.jvY.equals("0") || this.jvY.length() == 0) ? LoadData() : cyO();
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
                this.jwU.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.jwU.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.jwV == null) {
                this.jwV = new GetSugMatchWordsModel(this.gCM.getPageContext());
            }
            this.jwV.b(aVar);
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
        final com.baidu.tieba.pb.data.e pbData = ah.czQ().getPbData();
        if (pbData != null && pbData.cvs() != null) {
            pbData.cvs().jO(0);
            this.jwd = ah.czQ().cyz();
            this.jwb = ah.czQ().czV();
            this.jwf = ah.czQ().czW();
            this.jwZ = ah.czQ().czU();
            this.jxa = ah.czQ().czT();
            this.jxb = ah.czQ().czS();
            this.jxd = ah.czQ().czX();
            this.mTabIndex = ah.czQ().getTabIndex();
            this.jwW = this.jwb;
            if (this.jwb || this.isFromMark) {
                this.jwC = false;
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
        if (i == 4 && !this.jwG) {
            a(cyT(), true, this.jvY, 3);
        }
        if (i == 3 && !this.jwG) {
            if (this.isFromMark) {
                a(cyT(), true, this.jvY, 3);
            } else {
                a(cyT(), false, this.jvY, 3);
            }
        }
        this.jwG = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.jxf == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.dVZ);
        if (this.jwb || this.isFromMark) {
            this.jwC = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.jvW == null || this.jvW.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.jvW, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.ar.aOS().aOT() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.jwd) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.jwb) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.jwq) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.jwp));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.jwC) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.jwy, 0));
            pbPageRequestMessage.setOpMessageID(this.jwp);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> cvu = this.jqZ.cvu();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jwk - 1));
                        if (this.jwk - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.jwn) {
                                if (cvu != null && cvu.size() > 0) {
                                    size = cvu.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = cvu.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.jvY = postData.getId();
                                            if (StringUtils.isNull(this.jvY)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.jwj + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.jvY == null && this.jvY.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jvY, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jwj + 1));
                        if (this.jwj >= this.jwl) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (cvu != null) {
                                size = cvu.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.jvY == null) {
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
                if (cvu != null) {
                }
                if (this.jvY == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (cvu != null && cvu.size() > 0 && cvu.get(0) != null) {
                    this.jvY = cvu.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (czo()) {
                        if (this.jwk - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.jwk - 1));
                        }
                    } else if (this.jwj < this.jwl) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jwj + 1));
                    }
                }
                if (this.jvY != null && this.jvY.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jvY, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.jwb) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (czo()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.jwl > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jwl));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jvY, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.jwi));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.jwW && !this.jwb) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jvY, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.jwb) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.jwK);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jwY, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.jwW = this.jwb;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cyT());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.jwX));
        pbPageRequestMessage.setIsSubPostDataReverse(this.jwJ);
        pbPageRequestMessage.setFromSmartFrs(this.jwM ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.jwa);
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.jwl) {
                    i4 = -1;
                } else {
                    i4 = czv();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = czv();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.jvW);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean cwr() {
        switch (czh()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().cvs() == null || !getPbData().cvs().aLW();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cws()) && com.baidu.tieba.recapp.q.cNm().cNg() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.cNm().cNg().aD(cws(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.cNm().cNg().aE(cws(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cws()) && com.baidu.tieba.recapp.q.cNm().cNg() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.cNm().cNg().aE(cws(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.cNm().cNg().aD(cws(), true));
        }
    }

    protected void zD(int i) {
        boolean z = false;
        zI(i);
        ArrayList<PostData> cvu = this.jqZ.cvu();
        this.jwF = false;
        if (i == 1) {
            boolean z2 = false;
            while (cvu.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cvu.remove(0);
                z2 = true;
            }
            if (z2) {
                this.jqZ.getPage().jM(1);
                if (this.jwx != null) {
                    this.jwx.e(this.jqZ);
                }
            }
            this.hqX = System.currentTimeMillis();
            this.jwF = true;
        } else if (i == 2) {
            while (cvu.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cvu.remove(cvu.size() - 1);
                z = true;
            }
            if (z) {
                this.jqZ.getPage().jL(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.e eVar2 = z ? null : eVar;
        this.jwN = i2;
        this.isLoading = false;
        if (eVar2 != null) {
            j(eVar2);
        }
        i(eVar2);
        if (this.jxf != null && this.jxf.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(eVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void i(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvH() != null && eVar.cvH().cWd() != null && eVar.cvH().cWd().goods != null && eVar.cvH().isValidate() && eVar.cvH().cWd().goods.goods_style != 1001) {
            this.jxf = eVar.cvH();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m cyL() {
        return this.jxf;
    }

    public void cyM() {
        this.jxf = null;
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
            if (this.jwv || this.jwt || this.jwu) {
                eVar = l(eVar);
            }
            k(eVar);
        }
    }

    protected void k(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            String m = m(eVar);
            for (int i = 0; i < eVar.cvu().size(); i++) {
                PostData postData = eVar.cvu().get(i);
                for (int i2 = 0; i2 < postData.cWm().size(); i2++) {
                    postData.cWm().get(i2).a(this.gCM.getPageContext(), m.equals(postData.cWm().get(i2).aKC().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n cvD = eVar.cvD();
            if (cvD != null && !com.baidu.tbadk.core.util.v.isEmpty(cvD.joP)) {
                for (PostData postData2 : cvD.joP) {
                    for (int i3 = 0; i3 < postData2.cWm().size(); i3++) {
                        postData2.cWm().get(i3).a(this.gCM.getPageContext(), m.equals(postData2.cWm().get(i3).aKC().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i) {
        if (eVar != null) {
            String m = m(eVar);
            com.baidu.tieba.pb.data.n cvD = eVar.cvD();
            if (cvD != null && !com.baidu.tbadk.core.util.v.isEmpty(cvD.joP)) {
                for (PostData postData : cvD.joP.subList(i, cvD.joP.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cWm().size()) {
                            postData.cWm().get(i3).a(this.gCM.getPageContext(), m.equals(postData.cWm().get(i3).aKC().getUserId()));
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
        bj cvs = eVar.cvs();
        cvs.jT(this.mIsGood);
        cvs.jS(this.jwg);
        if (this.jwh > 0) {
            cvs.ca(this.jwh);
            return eVar;
        }
        return eVar;
    }

    protected String m(com.baidu.tieba.pb.data.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.cvs() != null && eVar.cvs().aKC() != null) {
            str = eVar.cvs().aKC().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData cyN() {
        if (this.jqZ == null || this.jqZ.cvs() == null || this.jqZ.cvs().aKC() == null) {
            return null;
        }
        return this.jqZ.cvs().aKC();
    }

    protected void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int size;
        int i4;
        int i5;
        boolean z4 = !z;
        this.jwL = z3;
        this.jws = i;
        if (this.gDV != null && !z3) {
            this.gDV.a(z2, z4, i2, str, i3, j, j2);
            this.gDV = null;
        }
        if (this.jqZ != null) {
            this.jqZ.jon = z3;
            this.jqZ.WD = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(cws()) && com.baidu.tieba.recapp.q.cNm().cNg() != null) {
            com.baidu.tieba.recapp.q.cNm().cNg().f(cws(), zE(cyW()), true);
        }
        if (eVar == null || (this.jwi == 1 && i == 5 && eVar.cvu() != null && eVar.cvu().size() < 1)) {
            if (this.jwx != null) {
                this.jwd = this.jwc;
                if (i2 != 350006) {
                    this.mSortType = this.jwe;
                }
                this.jwx.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.jwc = this.jwd;
            if (i != 8) {
                this.jwe = this.mSortType;
                this.mSortType = eVar.jnA;
            }
            if (eVar.jnz != null && eVar.jnz.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.gCM.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                eVar.jnz = new ArrayList();
                eVar.jnz.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.gCM.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                eVar.jnz.add(builder2.build(false));
                this.mSortType = this.jwe;
                eVar.jnA = this.mSortType;
            }
            this.jwq = false;
            if (eVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(eVar.getPage());
            }
            this.jwl = this.jwl < 1 ? 1 : this.jwl;
            ArrayList<PostData> cvu = this.jqZ.cvu();
            switch (i) {
                case 1:
                    this.jqZ.a(eVar.getPage(), 1);
                    d(eVar, cvu);
                    i4 = 0;
                    break;
                case 2:
                    if (eVar.cvu() == null) {
                        i5 = 0;
                    } else {
                        int size2 = eVar.cvu().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(cvu, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cvu(), com.baidu.tbadk.core.util.v.getCount(eVar.cvu()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            eVar.cvu().remove(postData2);
                            i5 = size2 - 1;
                        }
                        cvu.addAll(0, eVar.cvu());
                    }
                    this.jqZ.a(eVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && eVar.getPage() != null) {
                        eVar.getPage().jJ(eVar.getPage().aJt());
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
                    if (eVar != null && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cvu()) && this.jqZ != null && (!this.jwb || m(eVar).equals(eVar.cvu().get(0).aKC().getUserId()))) {
                        if (this.jqZ.getPage().aJy() == 0) {
                            this.jqZ.getPage().jL(1);
                        }
                        czi();
                        this.jwZ = eVar.cvu().get(0);
                        if (czo() || this.jqZ.cvQ()) {
                            if (this.jqZ.cvu().size() - this.jxb >= 3) {
                                this.jxa = new PostData();
                                this.jxa.kSU = true;
                                this.jxa.setPostType(53);
                                this.jqZ.cvu().add(this.jxa);
                            }
                            this.jqZ.cvu().add(this.jwZ);
                            size = this.jqZ.cvu().size() - 1;
                        } else {
                            if (this.jxb - this.jxc >= 3) {
                                this.jxa = new PostData();
                                this.jxa.kSU = false;
                                this.jxa.setPostType(53);
                                this.jqZ.cvu().add(0, this.jxa);
                            }
                            this.jqZ.cvu().add(0, this.jwZ);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.isTaday(com.baidu.tbadk.core.sharedPref.b.aNT().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.jwZ.kTh = this.jqZ.cvO();
                            com.baidu.tbadk.core.sharedPref.b.aNT().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        }
                        i4 = size;
                        break;
                    }
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.jqZ != null && this.jqZ.cvs() != null) {
                PraiseData aKn = this.jqZ.cvs().aKn();
                if (this.jxo != null && !aKn.isPriaseDataValid()) {
                    this.jqZ.cvs().a(this.jxo);
                } else {
                    this.jxo = this.jqZ.cvs().aKn();
                    this.jxo.setPostId(this.jqZ.cvs().aKS());
                }
                if (eVar.getPage() != null && eVar.getPage().aJw() == 1 && eVar.cvs() != null && eVar.cvs().aKN() != null && eVar.cvs().aKN().size() > 0) {
                    this.jqZ.cvs().x(eVar.cvs().aKN());
                }
                this.jqZ.cvs().jQ(eVar.cvs().aKt());
                this.jqZ.cvs().jN(eVar.cvs().getAnchorLevel());
                this.jqZ.cvs().jO(eVar.cvs().aKj());
                if (this.mThreadType == 33) {
                    this.jqZ.cvs().aKC().setHadConcerned(eVar.cvs().aKC().hadConcerned());
                }
                if (eVar != null && eVar.cvs() != null) {
                    this.jqZ.cvs().jV(eVar.cvs().aKR());
                }
            }
            if (this.jqZ != null && this.jqZ.getUserData() != null && eVar.getUserData() != null) {
                this.jqZ.getUserData().setBimg_end_time(eVar.getUserData().getBimg_end_time());
                this.jqZ.getUserData().setBimg_url(eVar.getUserData().getBimg_url());
            }
            if (eVar.getPage() != null && eVar.getPage().aJw() == 1 && eVar.cvC() != null) {
                this.jqZ.e(eVar.cvC());
            }
            if (this.jwL) {
                if (this.jqZ.cvs() != null && this.jqZ.cvs().aKC() != null && this.jqZ.cvu() != null && com.baidu.tbadk.core.util.v.getItem(this.jqZ.cvu(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(this.jqZ.cvu(), 0);
                    MetaData aKC = this.jqZ.cvs().aKC();
                    if (postData3.aKC() != null && postData3.aKC().getGodUserData() != null) {
                        if (this.jwA != -1) {
                            aKC.setFansNum(this.jwA);
                            postData3.aKC().setFansNum(this.jwA);
                        }
                        if (this.jwB != -1) {
                            aKC.getGodUserData().setIsLike(this.jwB == 1);
                            postData3.aKC().getGodUserData().setIsLike(this.jwB == 1);
                            aKC.getGodUserData().setIsFromNetWork(false);
                            postData3.aKC().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.jqZ.jny = -1;
                this.jqZ.jnx = -1;
            }
            if (this.jwx != null) {
                this.jwx.a(true, getErrorCode(), i, i4, this.jqZ, this.mErrorString, 1);
            }
        }
        if (this.jqZ != null && this.jqZ.cvs() != null && this.jqZ.getForum() != null && !this.jqZ.cvQ()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.gCM.getPageContext();
            historyMessage.threadId = getPbData().cvs().getId();
            if (this.mIsShareThread && getPbData().cvs().dtt != null) {
                historyMessage.threadName = getPbData().cvs().dtt.showText;
            } else {
                historyMessage.threadName = getPbData().cvs().getTitle();
            }
            if (this.mIsShareThread && !cwr()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = cyz();
            historyMessage.threadType = getPbData().cvs().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        String aN;
        if (arrayList != null && eVar.cvu() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cvu(), 0);
            if (postData != null && (aN = aN(arrayList)) != null && aN.equals(postData.getId())) {
                eVar.cvu().remove(postData);
            }
            this.jqZ.jom = arrayList.size();
            arrayList.addAll(eVar.cvu());
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
            eVar.Hu(this.jqZ.cvJ());
            this.jqZ = eVar;
            zB(eVar.getPage().aJw());
        }
    }

    public boolean cyO() {
        if (this.jvW == null || this.jvY == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return zC(4);
        }
        return zC(6);
    }

    public boolean rf(boolean z) {
        if (this.jvW == null || this.jqZ == null) {
            return false;
        }
        if (z || this.jqZ.getPage().aJy() != 0) {
            return zC(1);
        }
        return false;
    }

    public boolean rg(boolean z) {
        if (this.jvW == null || this.jqZ == null) {
            return false;
        }
        if ((z || this.jqZ.getPage().aJz() != 0) && this.jqZ.cvu() != null && this.jqZ.cvu().size() >= 1) {
            return zC(2);
        }
        return false;
    }

    public boolean HF(String str) {
        this.jwb = !this.jwb;
        this.jvY = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").af("obj_source", 0));
        if (zC(6)) {
            return true;
        }
        this.jwb = this.jwb ? false : true;
        return false;
    }

    public boolean w(boolean z, String str) {
        if (this.jwb == z) {
            return false;
        }
        this.jwb = z;
        this.jvY = str;
        if (this.mSortType == 2) {
            this.jvY = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").af("obj_source", 1));
        }
        if (zC(6)) {
            return true;
        }
        this.jwb = z ? false : true;
        return false;
    }

    public boolean zF(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.jwc = this.jwd;
        this.jwe = this.mSortType;
        this.mSortType = i;
        this.jwd = !this.jwd;
        if (i == 2 && this.isFromMark) {
            this.jvY = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.jwd = this.jwd ? false : true;
            this.mSortType = this.jwe;
            return false;
        }
        return true;
    }

    public boolean cyP() {
        return czo();
    }

    public int cyQ() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.jqZ == null || this.jqZ.getForum() == null || this.jqZ.cvs() == null) ? false : true;
    }

    public boolean aGX() {
        if (this.jqZ == null) {
            return false;
        }
        return this.jqZ.aGX();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData wz(String str) {
        if (this.jqZ == null || this.jqZ.cvs() == null || this.jqZ.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.jqZ.cvs().aLW()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.jqZ.getForum().getId());
            writeData.setForumName(this.jqZ.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.jwX);
        writeData.setThreadId(this.jvW);
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
        if (this.jqZ == null) {
            return null;
        }
        ArrayList<PostData> cvu = this.jqZ.cvu();
        if (com.baidu.tbadk.core.util.v.isEmpty(cvu)) {
            return null;
        }
        if (cvu.size() > 0 && i >= cvu.size()) {
            i = cvu.size() - 1;
        }
        return l(cvu.get(i));
    }

    public MarkData cyR() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.jvW);
        markData.setPostId(this.jqZ.aGW());
        markData.setTime(date.getTime());
        markData.setHostMode(this.jwb);
        markData.setSequence(Boolean.valueOf(czo()));
        markData.setId(this.jvW);
        return markData;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.jvW);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.jwb);
        markData.setSequence(Boolean.valueOf(czo()));
        markData.setId(this.jvW);
        markData.setFloor(postData.cWp());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void cyS() {
        i.cxh().ax(cyT(), this.isFromMark);
    }

    private String cyT() {
        String cyU = (this.jvW == null || this.jvW.equals("0")) ? cyU() : this.jvW;
        if (this.jwb) {
            cyU = cyU + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            cyU = cyU + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return cyU + TbadkCoreApplication.getCurrentAccount();
        }
        return cyU;
    }

    private String cyU() {
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
        if (this.jqZ != null) {
            this.jqZ.gk(z);
        }
    }

    public boolean cyV() {
        return this.jwC;
    }

    public void a(a aVar) {
        this.jwx = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aXi() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aXh() {
        return cyK();
    }

    public boolean HG(String str) {
        if (getPbData() == null || getPbData().cvs() == null || getPbData().cvs().aKC() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().cvs().aKC().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int cyW() {
        return this.mRequestType;
    }

    public void cyX() {
        if ("personalize_page".equals(this.mStType)) {
            this.jwI = System.currentTimeMillis() / 1000;
        }
    }

    public void cyY() {
        if ("personalize_page".equals(this.mStType) && this.jqZ != null && this.jwI != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").cI("fid", this.jqZ.getForumId()).cI("tid", this.jvW).cI("obj_duration", String.valueOf(currentTimeMillis - this.jwI)).cI(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.jwI = 0L;
        }
    }

    public boolean cyZ() {
        return this.jwL;
    }

    public int getErrorNo() {
        return this.jwN;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public n cza() {
        return this.jwP;
    }

    public x czb() {
        return this.jwQ;
    }

    public CheckRealNameModel czc() {
        return this.jwS;
    }

    public AddExperiencedModel czd() {
        return this.jwT;
    }

    public String cze() {
        return this.jwH;
    }

    public void HH(String str) {
        this.jwH = str;
    }

    public boolean czf() {
        return this.jwM;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.jqZ != null && this.jqZ.cvu() != null && this.jqZ.cvu().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.jqZ.cvu().size();
                for (int i = 0; i < size; i++) {
                    if (this.jqZ.cvu().get(i) != null && this.jqZ.cvu().get(i).aKC() != null && currentAccount.equals(this.jqZ.cvu().get(i).aKC().getUserId()) && this.jqZ.cvu().get(i).aKC().getPendantData() != null) {
                        this.jqZ.cvu().get(i).aKC().getPendantData().tR(kVar.aIU());
                        this.jqZ.cvu().get(i).aKC().getPendantData().cp(kVar.aWs());
                    }
                }
            }
        }
    }

    public String czg() {
        return this.jwR;
    }

    public int czh() {
        return this.jwX;
    }

    public void zH(int i) {
        this.jwX = i;
    }

    public void HI(String str) {
        if ((!this.jwb || HG(TbadkCoreApplication.getCurrentAccount())) && this.jqZ.cvu() != null) {
            this.jqZ.getPage().jL(1);
            if (this.jqZ.getPage().aJy() == 0) {
                this.jqZ.getPage().jL(1);
            }
            this.jwY = str;
            zC(8);
        }
    }

    private void zI(int i) {
        if (i != 8) {
            this.jwY = "";
            if (this.jwZ != null) {
                if (i == 1 && this.jqZ != null && this.jqZ.cvQ()) {
                    if (this.jxa != null) {
                        getPbData().cvu().remove(this.jxa);
                    }
                } else if (i == 1 && !this.jwd && !com.baidu.tbadk.core.util.v.isEmpty(getPbData().cvu())) {
                    getPbData().cvu().remove(this.jwZ);
                    if (this.jxa != null) {
                        getPbData().cvu().remove(this.jxa);
                    }
                    getPbData().cvu().add(0, this.jwZ);
                } else {
                    getPbData().cvu().remove(this.jwZ);
                    if (this.jxa != null) {
                        getPbData().cvu().remove(this.jxa);
                    }
                }
            }
            this.jxa = null;
        }
    }

    public void czi() {
        if (this.jqZ != null && !com.baidu.tbadk.core.util.v.isEmpty(this.jqZ.cvu())) {
            if (this.jxa != null) {
                this.jqZ.cvu().remove(this.jxa);
                this.jxa = null;
            }
            if (this.jwZ != null) {
                this.jqZ.cvu().remove(this.jwZ);
                this.jwZ = null;
            }
        }
    }

    public void cy(int i, int i2) {
        this.jxb = i;
        this.jxc = i2;
    }

    public PostData czj() {
        return this.jwZ;
    }

    public PostData czk() {
        return this.jxa;
    }

    public int czl() {
        return this.jxb;
    }

    public int czm() {
        return this.jxc;
    }

    public String czn() {
        return this.jxe;
    }

    public void HJ(String str) {
        this.jxe = str;
    }

    private boolean czo() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean czp() {
        return this.jwX == 13 || this.jwX == 12;
    }

    public String czq() {
        return this.jxh;
    }

    public String czr() {
        return this.jxi;
    }

    public String czs() {
        return this.jxj;
    }

    public String czt() {
        return this.jxk;
    }

    public Rect czu() {
        Rect rect = this.jxd;
        this.jxd = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int czv() {
        int i;
        int i2 = 0;
        if (getPbData().cvu() == null) {
            return 0;
        }
        ArrayList<PostData> cvu = getPbData().cvu();
        int size = cvu.size() - 1;
        while (size >= 0) {
            PostData postData = cvu.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
                if (postData.getType() != AdvertAppInfo.dmg) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return cvu.size();
    }
}
