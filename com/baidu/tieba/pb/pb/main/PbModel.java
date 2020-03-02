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
    private boolean cUq;
    private com.baidu.tieba.tbadkCore.d.b fWq;
    private long gGo;
    private BaseFragmentActivity grE;
    private boolean hQp;
    protected com.baidu.tieba.pb.data.e iFb;
    protected String iJW;
    private String iJX;
    private String iJY;
    private String iJZ;
    private int iKA;
    private int iKB;
    private boolean iKC;
    private boolean iKD;
    private boolean iKE;
    private boolean iKF;
    private boolean iKG;
    private String iKH;
    private long iKI;
    private boolean iKJ;
    private int iKK;
    private boolean iKL;
    private boolean iKM;
    private int iKN;
    private final v iKO;
    private final n iKP;
    private final x iKQ;
    private String iKR;
    private final CheckRealNameModel iKS;
    private final AddExperiencedModel iKT;
    private SuggestEmotionModel iKU;
    private GetSugMatchWordsModel iKV;
    private boolean iKW;
    private int iKX;
    private String iKY;
    private PostData iKZ;
    private boolean iKa;
    private boolean iKb;
    private boolean iKc;
    private boolean iKd;
    private int iKe;
    private boolean iKf;
    private int iKg;
    private long iKh;
    private int iKi;
    private int iKj;
    private int iKk;
    private int iKl;
    private boolean iKm;
    private boolean iKn;
    private boolean iKo;
    private long iKp;
    private boolean iKq;
    private String iKr;
    private int iKs;
    private boolean iKt;
    private boolean iKu;
    private boolean iKv;
    private boolean iKw;
    private a iKx;
    private String iKy;
    private String iKz;
    private PostData iLa;
    private int iLb;
    private int iLc;
    private Rect iLd;
    private String iLe;
    private com.baidu.tieba.tbadkCore.data.m iLf;
    private boolean iLg;
    private String iLh;
    private String iLi;
    private String iLj;
    private String iLk;
    private f.a iLl;
    private CustomMessageListener iLm;
    private com.baidu.adp.framework.listener.a iLn;
    private PraiseData iLo;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private com.baidu.tieba.pb.data.d mAppealInfo;
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
    private static final int iJV = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.iJW = null;
        this.iJX = null;
        this.iJY = null;
        this.mForumId = null;
        this.iJZ = null;
        this.iKa = false;
        this.iKb = false;
        this.iKc = true;
        this.iKd = true;
        this.mSortType = 0;
        this.iKe = 0;
        this.iKf = false;
        this.mIsGood = 0;
        this.iKg = 0;
        this.iKh = 0L;
        this.iKi = 1;
        this.iKj = 1;
        this.iKk = 1;
        this.iKl = 1;
        this.isAd = false;
        this.hQp = false;
        this.cUq = false;
        this.iKm = false;
        this.isFromMark = false;
        this.iKn = false;
        this.iKo = false;
        this.iKp = 0L;
        this.iKq = false;
        this.iKr = null;
        this.iFb = null;
        this.isLoading = false;
        this.iKt = false;
        this.iKu = false;
        this.iKv = false;
        this.iKw = false;
        this.mLocate = null;
        this.mContext = null;
        this.iKx = null;
        this.opType = null;
        this.opUrl = null;
        this.iKy = null;
        this.iKz = null;
        this.iKA = -1;
        this.iKB = -1;
        this.fWq = null;
        this.iKD = false;
        this.iKE = false;
        this.postID = null;
        this.iKH = null;
        this.iKI = 0L;
        this.iKJ = false;
        this.iKK = -1;
        this.iKM = false;
        this.iKW = false;
        this.iKX = 0;
        this.mTabIndex = 0;
        this.iLg = false;
        this.iLm = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.iLn = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.grE.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.iKD || !PbModel.this.iKE) {
                        if (!PbModel.this.iKD) {
                            PbModel.this.iKD = true;
                        } else {
                            PbModel.this.iKE = true;
                        }
                        if (PbModel.this.iKx != null) {
                            PbModel.this.iKx.a(PbModel.this.cnt(), z, responsedMessage, PbModel.this.iKF, System.currentTimeMillis() - PbModel.this.gGo);
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
                    if (PbModel.this.iFb != null && PbModel.this.iFb.ckt() != null && PbModel.this.iFb.ckt().getForumId() != null && PbModel.this.iFb.ckt().getForumId().equals(valueOf)) {
                        PbModel.this.iFb.ckt().setIsLike(false);
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
                    if (PbModel.this.iFb != null && PbModel.this.iFb.ckt() != null && PbModel.this.iFb.ckt().getForumId() != null && PbModel.this.iFb.ckt().getForumId().equals(valueOf)) {
                        PbModel.this.iFb.ckt().setIsLike(true);
                    }
                }
            }
        };
        this.iLo = null;
        registerListener(this.iLn);
        registerListener(this.iLm);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.iFb = new com.baidu.tieba.pb.data.e();
        this.iFb.yA(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.grE = baseFragmentActivity;
        this.iKO = new v(this, this.grE);
        this.iKP = new n(this, this.grE);
        this.iKQ = new x(this, this.grE);
        this.iKS = new CheckRealNameModel(this.grE.getPageContext());
        this.iKU = new SuggestEmotionModel();
        this.iKT = new AddExperiencedModel(this.grE.getPageContext());
        this.iLl = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void n(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIj) instanceof String) {
                        PbModel.this.iJW = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIj);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIk) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIk);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIl) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIl);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIm) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.cIm), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIn) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIn);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, String str) {
        this.iKG = true;
        if (eVar != null && eVar.iBF == null) {
            n(eVar);
            j(eVar);
            if (eVar.cku() != null) {
                eVar.cku().jH(0);
            }
            if (this.iKx != null && eVar != null) {
                this.iKx.a(true, 0, i, 0, eVar, str, 0);
            }
        }
    }

    protected int cnt() {
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
            this.iJW = intent.getStringExtra("thread_id");
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            Uri uri = (Uri) intent.getParcelableExtra("key_uri");
            if (com.baidu.tbadk.BdToken.f.n(uri)) {
                com.baidu.tbadk.BdToken.f.axP().c(uri, this.iLl);
            } else if (StringUtils.isNull(this.iJW)) {
                this.iKO.a(intent, this.iLl);
                if (uri != null) {
                    if (StringUtils.isNull(this.iJW)) {
                        this.iJW = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.aq.isEmpty(this.iJW)) {
                this.iJW = "0";
            }
            this.iKX = intent.getIntExtra("key_start_from", 0);
            if (this.iKX == 0) {
                this.iKX = this.iKO.Yv;
            }
            this.iJY = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.iJX = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.iKa = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.iKb = intent.getBooleanExtra("host_only", false);
            this.iKd = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.aRL().aIY() ? 2 : 0);
            if (this.mSortType == 2) {
                this.iJY = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.iKg = intent.getIntExtra("is_top", 0);
            this.iKh = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.iKn = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.iKo = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.hQp = intent.getBooleanExtra("is_sub_pb", false);
            this.iKq = intent.getBooleanExtra("is_pv", false);
            this.iKp = intent.getLongExtra("msg_id", 0L);
            this.iKr = intent.getStringExtra("from_forum_name");
            this.iKz = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.iKy = intent.getStringExtra("op_stat");
            this.iKt = intent.getBooleanExtra("is_from_thread_config", false);
            this.iKu = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.iKv = intent.getBooleanExtra("is_from_my_god_config", false);
            this.iKB = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.iKA = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.cUq = intent.getBooleanExtra("from_frs", false);
            this.iKm = intent.getBooleanExtra("from_maintab", false);
            this.iKM = intent.getBooleanExtra("from_smart_frs", false);
            this.iKw = intent.getBooleanExtra("from_hottopic", false);
            this.iKR = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.iJZ = intent.getStringExtra("high_light_post_id");
            this.iLg = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.iKC = intent.getIntExtra("request_code", -1) == 18003;
            this.iLh = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.iLi = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.iLj = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.iLk = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean cnu() {
        return this.iLg && com.baidu.tieba.frs.i.bDE() != null && com.baidu.tieba.frs.i.bDE().equals(this.iJW) && com.baidu.tieba.frs.i.bDD() != null;
    }

    public com.baidu.tieba.pb.data.e aG(bj bjVar) {
        com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
        eVar.yA(3);
        if (bjVar == null) {
            return null;
        }
        eVar.aE(bjVar);
        if (bjVar.aDX() != null) {
            eVar.e(bjVar.aDX());
            ForumData forum = eVar.getForum();
            forum.setId(bjVar.aDX().getForumId());
            forum.setName(bjVar.aDX().getForumName());
            forum.setUser_level(bjVar.aDX().aBF());
            forum.setImage_url(bjVar.aDX().getAvatar());
            forum.setPost_num(bjVar.aDX().postNum);
            forum.setMember_num(bjVar.aDX().memberNum);
        } else {
            ForumData forum2 = eVar.getForum();
            forum2.setId(String.valueOf(bjVar.getFid()));
            forum2.setName(bjVar.aCt());
        }
        PostData postData = new PostData();
        postData.Cw(1);
        postData.setTime(bjVar.getCreateTime());
        postData.a(bjVar.aCo());
        MetaData aCo = bjVar.aCo();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(aCo.getUserId(), aCo);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bjVar.aCe(), false));
        eVar.d(postData);
        eVar.ckw().add(postData);
        eVar.a(new com.baidu.tieba.pb.data.k(bjVar, null));
        eVar.iBK = true;
        eVar.setIsNewUrl(1);
        return eVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.iKX = bundle.getInt("key_start_from", 0);
        this.iJW = bundle.getString("thread_id");
        this.iJY = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.iJX = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.iKa = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.iKb = bundle.getBoolean("host_only", false);
        this.iKd = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.iKg = bundle.getInt("is_top", 0);
        this.iKh = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.iKo = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.hQp = bundle.getBoolean("is_sub_pb", false);
        this.iKq = bundle.getBoolean("is_pv", false);
        this.iKp = bundle.getLong("msg_id", 0L);
        this.iKr = bundle.getString("from_forum_name");
        this.iKz = bundle.getString("extra_pb_cache_key");
        this.iKt = bundle.getBoolean("is_from_thread_config", false);
        this.iKu = bundle.getBoolean("is_from_interview_live_config", false);
        this.iKv = bundle.getBoolean("is_from_my_god_config", false);
        this.iKB = bundle.getInt("extra_pb_is_attention_key", -1);
        this.iKA = bundle.getInt("extra_pb_funs_count_key", -1);
        this.cUq = bundle.getBoolean("from_frs", false);
        this.iKm = bundle.getBoolean("from_maintab", false);
        this.iKM = bundle.getBoolean("from_smart_frs", false);
        this.iKw = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.iJZ = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.iKC = bundle.getInt("request_code", -1) == 18003;
        this.iLh = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.iLi = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.iLj = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.iLk = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void au(Bundle bundle) {
        bundle.putString("thread_id", this.iJW);
        bundle.putString("post_id", this.iJY);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.iKX);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.iKa);
        bundle.putBoolean("host_only", this.iKb);
        bundle.putBoolean("squence", this.iKd);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.iKg);
        bundle.putLong("thread_time", this.iKh);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.iKo);
        bundle.putBoolean("is_sub_pb", this.hQp);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.iKq);
        bundle.putLong("msg_id", this.iKp);
        bundle.putString("extra_pb_cache_key", this.iKz);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.iKt);
        bundle.putBoolean("is_from_interview_live_config", this.iKu);
        bundle.putBoolean("is_from_my_god_config", this.iKv);
        bundle.putInt("extra_pb_is_attention_key", this.iKB);
        bundle.putInt("extra_pb_funs_count_key", this.iKA);
        bundle.putBoolean("from_frs", this.cUq);
        bundle.putBoolean("from_maintab", this.iKm);
        bundle.putBoolean("from_smart_frs", this.iKM);
        bundle.putBoolean("from_hottopic", this.iKw);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.iJZ);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.iLh);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.iLi);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.iLj);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.iLk);
    }

    public String cnv() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.iJW);
        if (!this.iKo) {
            sb.append(this.iJY);
        }
        sb.append(this.iKb);
        sb.append(this.iKd);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.iKg);
        sb.append(this.iKh);
        sb.append(this.cUq);
        sb.append(this.iKm);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.hQp);
        sb.append(this.iKq);
        sb.append(this.iKp);
        sb.append(this.iKr);
        sb.append(this.mThreadType);
        sb.append(this.iKt);
        sb.append(this.iKu);
        sb.append(this.iKv);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.iKz != null) {
            sb.append(this.iKz);
        }
        return sb.toString();
    }

    public String cls() {
        return this.iKr;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cnw() {
        return this.iJY;
    }

    public String cnx() {
        return this.iJZ;
    }

    public String cny() {
        return this.iJW;
    }

    public boolean getHostMode() {
        return this.iKb;
    }

    public boolean cnz() {
        return coo();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean cnA() {
        return this.cUq;
    }

    public boolean cnB() {
        return this.iKf;
    }

    public boolean cnC() {
        return this.iKm;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean cnD() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bxQ() {
        return this.iKg;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void yQ(int i) {
        this.iKg = i;
    }

    public boolean cnE() {
        return this.hQp;
    }

    public boolean cnF() {
        if (this.iFb == null) {
            return false;
        }
        return this.iFb.isValid();
    }

    public String aCx() {
        if (this.iFb == null || !this.iFb.ayL()) {
            return null;
        }
        return this.iFb.ayK();
    }

    public boolean yR(int i) {
        this.iKi = i;
        if (this.iKi > this.iFb.getPage().aBf()) {
            this.iKi = this.iFb.getPage().aBf();
        }
        if (this.iKi < 1) {
            this.iKi = 1;
        }
        if (this.iJW == null) {
            return false;
        }
        return yT(5);
    }

    public void yS(int i) {
        this.iKi = i;
        this.iKj = i;
        this.iKk = i;
    }

    public void b(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar == null) {
            yS(1);
            return;
        }
        if (this.iKj < apVar.aBi()) {
            this.iKj = apVar.aBi();
        }
        if (this.iKk > apVar.aBi()) {
            this.iKk = apVar.aBi();
        }
        this.iKl = apVar.aBf();
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        return this.iFb;
    }

    public BaijiahaoData cnG() {
        if (this.iFb == null || this.iFb.cku() == null) {
            return null;
        }
        return this.iFb.cku().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.e cnH() {
        if (this.iFb == null) {
            return this.iFb;
        }
        if (!cnI() && this.iLf != null) {
            this.iFb.b(this.iLf);
        }
        return this.iFb;
    }

    private boolean cnI() {
        return (this.iFb.ckJ() == null || this.iFb.ckJ().cKO() == null || this.iFb.ckJ().cKO().goods != null || this.iFb.ckJ().cKO().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.ap getPageData() {
        if (this.iFb == null) {
            return null;
        }
        return this.iFb.getPage();
    }

    public boolean cnJ() {
        if (coo() && this.iFb.getPage().aBk() == 0) {
            pV(true);
            return true;
        }
        return false;
    }

    public void h(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.iJW = eVar.getThreadId();
            if (eVar.cku() != null && eVar.cku().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = eVar.cku().getBaijiahaoData();
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
            this.iJY = null;
            this.iKb = false;
            this.iKd = true;
            LoadData();
        }
    }

    public void FO(String str) {
        if (!StringUtils.isNull(str)) {
            this.iJW = str;
            this.iJY = null;
            this.iKb = false;
            this.iKd = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.iJW == null) {
            return false;
        }
        cancelLoadData();
        if (this.fWq == null) {
            this.fWq = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.fWq.start();
        }
        boolean yT = yT(3);
        if (this.opType != null) {
            this.opType = null;
            this.iKy = null;
            this.opUrl = null;
            return yT;
        }
        return yT;
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
        if (this.iKU != null) {
            this.iKU.cancelLoadData();
        }
        if (this.iKV != null) {
            this.iKV.cancelLoadData();
        }
        byT();
    }

    private void byT() {
        if (this.fWq != null) {
            this.fWq.destory();
            this.fWq = null;
        }
    }

    public boolean cnK() {
        return (this.iJY == null || this.iJY.equals("0") || this.iJY.length() == 0) ? LoadData() : cnO();
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
                this.iKU.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.iKU.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.iKV == null) {
                this.iKV = new GetSugMatchWordsModel(this.grE.getPageContext());
            }
            this.iKV.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x035e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0366 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x016d, B:51:0x0175, B:53:0x0182, B:54:0x018a, B:56:0x018e, B:57:0x0193, B:59:0x0197, B:60:0x019c, B:62:0x01a0, B:63:0x01b0, B:65:0x01b4, B:66:0x01bc, B:68:0x01c0, B:69:0x01d9, B:70:0x01e8, B:71:0x01eb, B:74:0x0217, B:76:0x023e, B:78:0x0248, B:187:0x04ee, B:188:0x04f4, B:191:0x0501, B:81:0x0255, B:83:0x027e, B:84:0x029c, B:86:0x02b4, B:88:0x02ba, B:90:0x02c1, B:91:0x02ce, B:93:0x02e2, B:95:0x02e8, B:97:0x02ee, B:106:0x031e, B:108:0x0324, B:98:0x02f9, B:100:0x02fd, B:102:0x0305, B:104:0x0314, B:105:0x0319, B:109:0x0330, B:111:0x0344, B:113:0x0348, B:116:0x035a, B:119:0x0360, B:147:0x03d6, B:122:0x0366, B:124:0x036c, B:125:0x0371, B:127:0x0375, B:129:0x037f, B:134:0x0396, B:136:0x03a4, B:137:0x03a7, B:139:0x03ab, B:140:0x03b6, B:142:0x03ba, B:144:0x03c2, B:146:0x03d1, B:148:0x03db, B:150:0x03df, B:131:0x0383, B:151:0x03e8, B:152:0x0416, B:154:0x041a, B:164:0x044b, B:157:0x0426, B:159:0x0434, B:160:0x043c, B:162:0x0440, B:163:0x0446, B:165:0x0454, B:167:0x0460, B:156:0x041e, B:168:0x046a, B:170:0x0476, B:172:0x047a, B:174:0x047e, B:175:0x0483, B:177:0x048f, B:178:0x0497, B:182:0x04b1, B:179:0x049c, B:181:0x04ab, B:183:0x04ba, B:185:0x04c9, B:38:0x00e3), top: B:194:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0375 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x016d, B:51:0x0175, B:53:0x0182, B:54:0x018a, B:56:0x018e, B:57:0x0193, B:59:0x0197, B:60:0x019c, B:62:0x01a0, B:63:0x01b0, B:65:0x01b4, B:66:0x01bc, B:68:0x01c0, B:69:0x01d9, B:70:0x01e8, B:71:0x01eb, B:74:0x0217, B:76:0x023e, B:78:0x0248, B:187:0x04ee, B:188:0x04f4, B:191:0x0501, B:81:0x0255, B:83:0x027e, B:84:0x029c, B:86:0x02b4, B:88:0x02ba, B:90:0x02c1, B:91:0x02ce, B:93:0x02e2, B:95:0x02e8, B:97:0x02ee, B:106:0x031e, B:108:0x0324, B:98:0x02f9, B:100:0x02fd, B:102:0x0305, B:104:0x0314, B:105:0x0319, B:109:0x0330, B:111:0x0344, B:113:0x0348, B:116:0x035a, B:119:0x0360, B:147:0x03d6, B:122:0x0366, B:124:0x036c, B:125:0x0371, B:127:0x0375, B:129:0x037f, B:134:0x0396, B:136:0x03a4, B:137:0x03a7, B:139:0x03ab, B:140:0x03b6, B:142:0x03ba, B:144:0x03c2, B:146:0x03d1, B:148:0x03db, B:150:0x03df, B:131:0x0383, B:151:0x03e8, B:152:0x0416, B:154:0x041a, B:164:0x044b, B:157:0x0426, B:159:0x0434, B:160:0x043c, B:162:0x0440, B:163:0x0446, B:165:0x0454, B:167:0x0460, B:156:0x041e, B:168:0x046a, B:170:0x0476, B:172:0x047a, B:174:0x047e, B:175:0x0483, B:177:0x048f, B:178:0x0497, B:182:0x04b1, B:179:0x049c, B:181:0x04ab, B:183:0x04ba, B:185:0x04c9, B:38:0x00e3), top: B:194:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03ab A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x016d, B:51:0x0175, B:53:0x0182, B:54:0x018a, B:56:0x018e, B:57:0x0193, B:59:0x0197, B:60:0x019c, B:62:0x01a0, B:63:0x01b0, B:65:0x01b4, B:66:0x01bc, B:68:0x01c0, B:69:0x01d9, B:70:0x01e8, B:71:0x01eb, B:74:0x0217, B:76:0x023e, B:78:0x0248, B:187:0x04ee, B:188:0x04f4, B:191:0x0501, B:81:0x0255, B:83:0x027e, B:84:0x029c, B:86:0x02b4, B:88:0x02ba, B:90:0x02c1, B:91:0x02ce, B:93:0x02e2, B:95:0x02e8, B:97:0x02ee, B:106:0x031e, B:108:0x0324, B:98:0x02f9, B:100:0x02fd, B:102:0x0305, B:104:0x0314, B:105:0x0319, B:109:0x0330, B:111:0x0344, B:113:0x0348, B:116:0x035a, B:119:0x0360, B:147:0x03d6, B:122:0x0366, B:124:0x036c, B:125:0x0371, B:127:0x0375, B:129:0x037f, B:134:0x0396, B:136:0x03a4, B:137:0x03a7, B:139:0x03ab, B:140:0x03b6, B:142:0x03ba, B:144:0x03c2, B:146:0x03d1, B:148:0x03db, B:150:0x03df, B:131:0x0383, B:151:0x03e8, B:152:0x0416, B:154:0x041a, B:164:0x044b, B:157:0x0426, B:159:0x0434, B:160:0x043c, B:162:0x0440, B:163:0x0446, B:165:0x0454, B:167:0x0460, B:156:0x041e, B:168:0x046a, B:170:0x0476, B:172:0x047a, B:174:0x047e, B:175:0x0483, B:177:0x048f, B:178:0x0497, B:182:0x04b1, B:179:0x049c, B:181:0x04ab, B:183:0x04ba, B:185:0x04c9, B:38:0x00e3), top: B:194:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03ba A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x016d, B:51:0x0175, B:53:0x0182, B:54:0x018a, B:56:0x018e, B:57:0x0193, B:59:0x0197, B:60:0x019c, B:62:0x01a0, B:63:0x01b0, B:65:0x01b4, B:66:0x01bc, B:68:0x01c0, B:69:0x01d9, B:70:0x01e8, B:71:0x01eb, B:74:0x0217, B:76:0x023e, B:78:0x0248, B:187:0x04ee, B:188:0x04f4, B:191:0x0501, B:81:0x0255, B:83:0x027e, B:84:0x029c, B:86:0x02b4, B:88:0x02ba, B:90:0x02c1, B:91:0x02ce, B:93:0x02e2, B:95:0x02e8, B:97:0x02ee, B:106:0x031e, B:108:0x0324, B:98:0x02f9, B:100:0x02fd, B:102:0x0305, B:104:0x0314, B:105:0x0319, B:109:0x0330, B:111:0x0344, B:113:0x0348, B:116:0x035a, B:119:0x0360, B:147:0x03d6, B:122:0x0366, B:124:0x036c, B:125:0x0371, B:127:0x0375, B:129:0x037f, B:134:0x0396, B:136:0x03a4, B:137:0x03a7, B:139:0x03ab, B:140:0x03b6, B:142:0x03ba, B:144:0x03c2, B:146:0x03d1, B:148:0x03db, B:150:0x03df, B:131:0x0383, B:151:0x03e8, B:152:0x0416, B:154:0x041a, B:164:0x044b, B:157:0x0426, B:159:0x0434, B:160:0x043c, B:162:0x0440, B:163:0x0446, B:165:0x0454, B:167:0x0460, B:156:0x041e, B:168:0x046a, B:170:0x0476, B:172:0x047a, B:174:0x047e, B:175:0x0483, B:177:0x048f, B:178:0x0497, B:182:0x04b1, B:179:0x049c, B:181:0x04ab, B:183:0x04ba, B:185:0x04c9, B:38:0x00e3), top: B:194:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03df A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x016d, B:51:0x0175, B:53:0x0182, B:54:0x018a, B:56:0x018e, B:57:0x0193, B:59:0x0197, B:60:0x019c, B:62:0x01a0, B:63:0x01b0, B:65:0x01b4, B:66:0x01bc, B:68:0x01c0, B:69:0x01d9, B:70:0x01e8, B:71:0x01eb, B:74:0x0217, B:76:0x023e, B:78:0x0248, B:187:0x04ee, B:188:0x04f4, B:191:0x0501, B:81:0x0255, B:83:0x027e, B:84:0x029c, B:86:0x02b4, B:88:0x02ba, B:90:0x02c1, B:91:0x02ce, B:93:0x02e2, B:95:0x02e8, B:97:0x02ee, B:106:0x031e, B:108:0x0324, B:98:0x02f9, B:100:0x02fd, B:102:0x0305, B:104:0x0314, B:105:0x0319, B:109:0x0330, B:111:0x0344, B:113:0x0348, B:116:0x035a, B:119:0x0360, B:147:0x03d6, B:122:0x0366, B:124:0x036c, B:125:0x0371, B:127:0x0375, B:129:0x037f, B:134:0x0396, B:136:0x03a4, B:137:0x03a7, B:139:0x03ab, B:140:0x03b6, B:142:0x03ba, B:144:0x03c2, B:146:0x03d1, B:148:0x03db, B:150:0x03df, B:131:0x0383, B:151:0x03e8, B:152:0x0416, B:154:0x041a, B:164:0x044b, B:157:0x0426, B:159:0x0434, B:160:0x043c, B:162:0x0440, B:163:0x0446, B:165:0x0454, B:167:0x0460, B:156:0x041e, B:168:0x046a, B:170:0x0476, B:172:0x047a, B:174:0x047e, B:175:0x0483, B:177:0x048f, B:178:0x0497, B:182:0x04b1, B:179:0x049c, B:181:0x04ab, B:183:0x04ba, B:185:0x04c9, B:38:0x00e3), top: B:194:0x00d7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean yT(int i) {
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
        yU(i);
        final com.baidu.tieba.pb.data.e pbData = ah.coQ().getPbData();
        if (pbData != null && pbData.cku() != null) {
            pbData.cku().jH(0);
            this.iKd = ah.coQ().cnz();
            this.iKb = ah.coQ().coV();
            this.iKf = ah.coQ().coW();
            this.iKZ = ah.coQ().coU();
            this.iLa = ah.coQ().coT();
            this.iLb = ah.coQ().coS();
            this.iLd = ah.coQ().coX();
            this.mTabIndex = ah.coQ().getTabIndex();
            this.iKW = this.iKb;
            if (this.iKb || this.isFromMark) {
                this.iKC = false;
            }
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.iKG) {
            a(cnT(), true, this.iJY, 3);
        }
        if (i == 3 && !this.iKG) {
            if (this.isFromMark) {
                a(cnT(), true, this.iJY, 3);
            } else {
                a(cnT(), false, this.iJY, 3);
            }
        }
        this.iKG = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.iLf == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.dvN);
        if (this.iKb || this.isFromMark) {
            this.iKC = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.iJW == null || this.iJW.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.iJW, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.ar.aGD().aGE() ? 2 : 1));
        if (!this.iKd) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.iKb) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.iKq) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.iKp));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.iKC) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.iKy, 0));
            pbPageRequestMessage.setOpMessageID(this.iKp);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> ckw = this.iFb.ckw();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iKk - 1));
                        if (this.iKk - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.iKn) {
                                if (ckw != null && ckw.size() > 0) {
                                    size = ckw.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = ckw.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.iJY = postData.getId();
                                            if (StringUtils.isNull(this.iJY)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.iKj + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.iJY == null && this.iJY.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iJY, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iKj + 1));
                        if (this.iKj >= this.iKl) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (ckw != null) {
                                size = ckw.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.iJY == null) {
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
                if (ckw != null) {
                }
                if (this.iJY == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (ckw != null && ckw.size() > 0 && ckw.get(0) != null) {
                    this.iJY = ckw.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (coo()) {
                        if (this.iKk - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.iKk - 1));
                        }
                    } else if (this.iKj < this.iKl) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iKj + 1));
                    }
                }
                if (this.iJY != null && this.iJY.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iJY, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.iKb) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (coo()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.iKl > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iKl));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iJY, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.iKi));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.iKW && !this.iKb) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iJY, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.iKb) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.iKK);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iKY, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.iKW = this.iKb;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cnT());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.iKX));
        pbPageRequestMessage.setIsSubPostDataReverse(this.iKJ);
        pbPageRequestMessage.setFromSmartFrs(this.iKM ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.iKa);
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.iKl) {
                    i4 = -1;
                } else {
                    i4 = cov();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = cov();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.iJW);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean clr() {
        switch (coh()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().cku() == null || !getPbData().cku().aDG();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cls()) && com.baidu.tieba.recapp.r.cCv().cCp() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cCv().cCp().ax(cls(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cCv().cCp().ay(cls(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cls()) && com.baidu.tieba.recapp.r.cCv().cCp() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cCv().cCp().ay(cls(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cCv().cCp().ax(cls(), true));
        }
    }

    protected void yU(int i) {
        boolean z = false;
        yZ(i);
        ArrayList<PostData> ckw = this.iFb.ckw();
        this.iKF = false;
        if (i == 1) {
            boolean z2 = false;
            while (ckw.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                ckw.remove(0);
                z2 = true;
            }
            if (z2) {
                this.iFb.getPage().jF(1);
                if (this.iKx != null) {
                    this.iKx.e(this.iFb);
                }
            }
            this.gGo = System.currentTimeMillis();
            this.iKF = true;
        } else if (i == 2) {
            while (ckw.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                ckw.remove(ckw.size() - 1);
                z = true;
            }
            if (z) {
                this.iFb.getPage().jE(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.e eVar2 = z ? null : eVar;
        this.iKN = i2;
        this.isLoading = false;
        if (eVar2 != null) {
            j(eVar2);
        }
        i(eVar2);
        if (this.iLf != null && this.iLf.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(eVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void i(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckJ() != null && eVar.ckJ().cKO() != null && eVar.ckJ().cKO().goods != null && eVar.ckJ().isValidate() && eVar.ckJ().cKO().goods.goods_style != 1001) {
            this.iLf = eVar.ckJ();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m cnL() {
        return this.iLf;
    }

    public void cnM() {
        this.iLf = null;
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
            if (this.iKv || this.iKt || this.iKu) {
                eVar = l(eVar);
            }
            k(eVar);
        }
    }

    protected void k(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            String m = m(eVar);
            for (int i = 0; i < eVar.ckw().size(); i++) {
                PostData postData = eVar.ckw().get(i);
                for (int i2 = 0; i2 < postData.cKX().size(); i2++) {
                    postData.cKX().get(i2).a(this.grE.getPageContext(), m.equals(postData.cKX().get(i2).aCo().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n ckF = eVar.ckF();
            if (ckF != null && !com.baidu.tbadk.core.util.v.isEmpty(ckF.iCS)) {
                for (PostData postData2 : ckF.iCS) {
                    for (int i3 = 0; i3 < postData2.cKX().size(); i3++) {
                        postData2.cKX().get(i3).a(this.grE.getPageContext(), m.equals(postData2.cKX().get(i3).aCo().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i) {
        if (eVar != null) {
            String m = m(eVar);
            com.baidu.tieba.pb.data.n ckF = eVar.ckF();
            if (ckF != null && !com.baidu.tbadk.core.util.v.isEmpty(ckF.iCS)) {
                for (PostData postData : ckF.iCS.subList(i, ckF.iCS.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cKX().size()) {
                            postData.cKX().get(i3).a(this.grE.getPageContext(), m.equals(postData.cKX().get(i3).aCo().getUserId()));
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
        bj cku = eVar.cku();
        cku.jM(this.mIsGood);
        cku.jL(this.iKg);
        if (this.iKh > 0) {
            cku.bv(this.iKh);
            return eVar;
        }
        return eVar;
    }

    protected String m(com.baidu.tieba.pb.data.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.cku() != null && eVar.cku().aCo() != null) {
            str = eVar.cku().aCo().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData cnN() {
        if (this.iFb == null || this.iFb.cku() == null || this.iFb.cku().aCo() == null) {
            return null;
        }
        return this.iFb.cku().aCo();
    }

    protected void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int size;
        int i4;
        int i5;
        boolean z4 = !z;
        this.iKL = z3;
        this.iKs = i;
        if (this.fWq != null && !z3) {
            this.fWq.a(z2, z4, i2, str, i3, j, j2);
            this.fWq = null;
        }
        if (this.iFb != null) {
            this.iFb.iCr = z3;
            this.iFb.Df = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(cls()) && com.baidu.tieba.recapp.r.cCv().cCp() != null) {
            com.baidu.tieba.recapp.r.cCv().cCp().g(cls(), yV(cnW()), true);
        }
        if (eVar == null || (this.iKi == 1 && i == 5 && eVar.ckw() != null && eVar.ckw().size() < 1)) {
            if (this.iKx != null) {
                this.iKd = this.iKc;
                if (i2 != 350006) {
                    this.mSortType = this.iKe;
                }
                this.iKx.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.iKc = this.iKd;
            if (i != 8) {
                this.iKe = this.mSortType;
                this.mSortType = eVar.iBE;
            }
            if (eVar.iBD != null && eVar.iBD.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.grE.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                eVar.iBD = new ArrayList();
                eVar.iBD.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.grE.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                eVar.iBD.add(builder2.build(false));
                this.mSortType = this.iKe;
                eVar.iBE = this.mSortType;
            }
            this.iKq = false;
            if (eVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(eVar.getPage());
            }
            this.iKl = this.iKl < 1 ? 1 : this.iKl;
            ArrayList<PostData> ckw = this.iFb.ckw();
            switch (i) {
                case 1:
                    this.iFb.a(eVar.getPage(), 1);
                    d(eVar, ckw);
                    i4 = 0;
                    break;
                case 2:
                    if (eVar.ckw() == null) {
                        i5 = 0;
                    } else {
                        int size2 = eVar.ckw().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(ckw, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.ckw(), com.baidu.tbadk.core.util.v.getCount(eVar.ckw()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            eVar.ckw().remove(postData2);
                            i5 = size2 - 1;
                        }
                        ckw.addAll(0, eVar.ckw());
                    }
                    this.iFb.a(eVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && eVar.getPage() != null) {
                        eVar.getPage().jC(eVar.getPage().aBf());
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
                    if (eVar != null && !com.baidu.tbadk.core.util.v.isEmpty(eVar.ckw()) && this.iFb != null && (!this.iKb || m(eVar).equals(eVar.ckw().get(0).aCo().getUserId()))) {
                        if (this.iFb.getPage().aBk() == 0) {
                            this.iFb.getPage().jE(1);
                        }
                        coi();
                        this.iKZ = eVar.ckw().get(0);
                        if (coo() || this.iFb.ckS()) {
                            if (this.iFb.ckw().size() - this.iLb >= 3) {
                                this.iLa = new PostData();
                                this.iLa.kgV = true;
                                this.iLa.setPostType(53);
                                this.iFb.ckw().add(this.iLa);
                            }
                            this.iFb.ckw().add(this.iKZ);
                            size = this.iFb.ckw().size() - 1;
                        } else {
                            if (this.iLb - this.iLc >= 3) {
                                this.iLa = new PostData();
                                this.iLa.kgV = false;
                                this.iLa.setPostType(53);
                                this.iFb.ckw().add(0, this.iLa);
                            }
                            this.iFb.ckw().add(0, this.iKZ);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.isTaday(com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.iKZ.khi = this.iFb.ckQ();
                            com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        }
                        i4 = size;
                        break;
                    }
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.iFb != null && this.iFb.cku() != null) {
                PraiseData aBZ = this.iFb.cku().aBZ();
                if (this.iLo != null && !aBZ.isPriaseDataValid()) {
                    this.iFb.cku().a(this.iLo);
                } else {
                    this.iLo = this.iFb.cku().aBZ();
                    this.iLo.setPostId(this.iFb.cku().aCE());
                }
                if (eVar.getPage() != null && eVar.getPage().aBi() == 1 && eVar.cku() != null && eVar.cku().aCz() != null && eVar.cku().aCz().size() > 0) {
                    this.iFb.cku().x(eVar.cku().aCz());
                }
                this.iFb.cku().jJ(eVar.cku().aCf());
                this.iFb.cku().jG(eVar.cku().getAnchorLevel());
                this.iFb.cku().jH(eVar.cku().aBV());
                if (this.mThreadType == 33) {
                    this.iFb.cku().aCo().setHadConcerned(eVar.cku().aCo().hadConcerned());
                }
                if (eVar != null && eVar.cku() != null) {
                    this.iFb.cku().jO(eVar.cku().aCD());
                }
            }
            if (this.iFb != null && this.iFb.getUserData() != null && eVar.getUserData() != null) {
                this.iFb.getUserData().setBimg_end_time(eVar.getUserData().getBimg_end_time());
                this.iFb.getUserData().setBimg_url(eVar.getUserData().getBimg_url());
            }
            if (eVar.getPage() != null && eVar.getPage().aBi() == 1 && eVar.ckE() != null) {
                this.iFb.e(eVar.ckE());
            }
            if (this.iKL) {
                if (this.iFb.cku() != null && this.iFb.cku().aCo() != null && this.iFb.ckw() != null && com.baidu.tbadk.core.util.v.getItem(this.iFb.ckw(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(this.iFb.ckw(), 0);
                    MetaData aCo = this.iFb.cku().aCo();
                    if (postData3.aCo() != null && postData3.aCo().getGodUserData() != null) {
                        if (this.iKA != -1) {
                            aCo.setFansNum(this.iKA);
                            postData3.aCo().setFansNum(this.iKA);
                        }
                        if (this.iKB != -1) {
                            aCo.getGodUserData().setIsLike(this.iKB == 1);
                            postData3.aCo().getGodUserData().setIsLike(this.iKB == 1);
                            aCo.getGodUserData().setIsFromNetWork(false);
                            postData3.aCo().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.iFb.iBC = -1;
                this.iFb.iBB = -1;
            }
            if (this.iKx != null) {
                this.iKx.a(true, getErrorCode(), i, i4, this.iFb, this.mErrorString, 1);
            }
        }
        if (this.iFb != null && this.iFb.cku() != null && this.iFb.getForum() != null && !this.iFb.ckS()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.grE.getPageContext();
            historyMessage.threadId = getPbData().cku().getId();
            if (this.mIsShareThread && getPbData().cku().cTQ != null) {
                historyMessage.threadName = getPbData().cku().cTQ.showText;
            } else {
                historyMessage.threadName = getPbData().cku().getTitle();
            }
            if (this.mIsShareThread && !clr()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = cnz();
            historyMessage.threadType = getPbData().cku().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        String aL;
        if (arrayList != null && eVar.ckw() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.ckw(), 0);
            if (postData != null && (aL = aL(arrayList)) != null && aL.equals(postData.getId())) {
                eVar.ckw().remove(postData);
            }
            this.iFb.iCq = arrayList.size();
            arrayList.addAll(eVar.ckw());
        }
    }

    private int yV(int i) {
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

    private String aL(ArrayList<PostData> arrayList) {
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
            eVar.FJ(this.iFb.ckL());
            this.iFb = eVar;
            yS(eVar.getPage().aBi());
        }
    }

    public boolean cnO() {
        if (this.iJW == null || this.iJY == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return yT(4);
        }
        return yT(6);
    }

    public boolean pV(boolean z) {
        if (this.iJW == null || this.iFb == null) {
            return false;
        }
        if (z || this.iFb.getPage().aBk() != 0) {
            return yT(1);
        }
        return false;
    }

    public boolean pW(boolean z) {
        if (this.iJW == null || this.iFb == null) {
            return false;
        }
        if ((z || this.iFb.getPage().aBl() != 0) && this.iFb.ckw() != null && this.iFb.ckw().size() >= 1) {
            return yT(2);
        }
        return false;
    }

    public boolean FU(String str) {
        this.iKb = !this.iKb;
        this.iJY = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").X("obj_source", 0));
        if (yT(6)) {
            return true;
        }
        this.iKb = this.iKb ? false : true;
        return false;
    }

    public boolean v(boolean z, String str) {
        if (this.iKb == z) {
            return false;
        }
        this.iKb = z;
        this.iJY = str;
        if (this.mSortType == 2) {
            this.iJY = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").X("obj_source", 1));
        }
        if (yT(6)) {
            return true;
        }
        this.iKb = z ? false : true;
        return false;
    }

    public boolean yW(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.iKc = this.iKd;
        this.iKe = this.mSortType;
        this.mSortType = i;
        this.iKd = !this.iKd;
        if (i == 2 && this.isFromMark) {
            this.iJY = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.iKd = this.iKd ? false : true;
            this.mSortType = this.iKe;
            return false;
        }
        return true;
    }

    public boolean cnP() {
        return coo();
    }

    public int cnQ() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.iFb == null || this.iFb.getForum() == null || this.iFb.cku() == null) ? false : true;
    }

    public boolean ayL() {
        if (this.iFb == null) {
            return false;
        }
        return this.iFb.ayL();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData vi(String str) {
        if (this.iFb == null || this.iFb.cku() == null || this.iFb.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.iFb.cku().aDG()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.iFb.getForum().getId());
            writeData.setForumName(this.iFb.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.iKX);
        writeData.setThreadId(this.iJW);
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

    public MarkData yX(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.iFb == null) {
            return null;
        }
        ArrayList<PostData> ckw = this.iFb.ckw();
        if (com.baidu.tbadk.core.util.v.isEmpty(ckw)) {
            return null;
        }
        if (ckw.size() > 0 && i >= ckw.size()) {
            i = ckw.size() - 1;
        }
        return l(ckw.get(i));
    }

    public MarkData cnR() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iJW);
        markData.setPostId(this.iFb.ayK());
        markData.setTime(date.getTime());
        markData.setHostMode(this.iKb);
        markData.setSequence(Boolean.valueOf(coo()));
        markData.setId(this.iJW);
        return markData;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iJW);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.iKb);
        markData.setSequence(Boolean.valueOf(coo()));
        markData.setId(this.iJW);
        markData.setFloor(postData.cLa());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void cnS() {
        i.cmh().ar(cnT(), this.isFromMark);
    }

    private String cnT() {
        String cnU = (this.iJW == null || this.iJW.equals("0")) ? cnU() : this.iJW;
        if (this.iKb) {
            cnU = cnU + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            cnU = cnU + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return cnU + TbadkCoreApplication.getCurrentAccount();
        }
        return cnU;
    }

    private String cnU() {
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

    public void pX(boolean z) {
        if (this.iFb != null) {
            this.iFb.fm(z);
        }
    }

    public boolean cnV() {
        return this.iKC;
    }

    public void a(a aVar) {
        this.iKx = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aOO() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aON() {
        return cnK();
    }

    public boolean FV(String str) {
        if (getPbData() == null || getPbData().cku() == null || getPbData().cku().aCo() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().cku().aCo().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int cnW() {
        return this.mRequestType;
    }

    public void cnX() {
        if ("personalize_page".equals(this.mStType)) {
            this.iKI = System.currentTimeMillis() / 1000;
        }
    }

    public void cnY() {
        if ("personalize_page".equals(this.mStType) && this.iFb != null && this.iKI != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").cy("fid", this.iFb.getForumId()).cy("tid", this.iJW).cy("obj_duration", String.valueOf(currentTimeMillis - this.iKI)).cy(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.iKI = 0L;
        }
    }

    public boolean cnZ() {
        return this.iKL;
    }

    public int getErrorNo() {
        return this.iKN;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public n coa() {
        return this.iKP;
    }

    public x cob() {
        return this.iKQ;
    }

    public CheckRealNameModel coc() {
        return this.iKS;
    }

    public AddExperiencedModel cod() {
        return this.iKT;
    }

    public String coe() {
        return this.iKH;
    }

    public void FW(String str) {
        this.iKH = str;
    }

    public boolean cof() {
        return this.iKM;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.iFb != null && this.iFb.ckw() != null && this.iFb.ckw().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.iFb.ckw().size();
                for (int i = 0; i < size; i++) {
                    if (this.iFb.ckw().get(i) != null && this.iFb.ckw().get(i).aCo() != null && currentAccount.equals(this.iFb.ckw().get(i).aCo().getUserId()) && this.iFb.ckw().get(i).aCo().getPendantData() != null) {
                        this.iFb.ckw().get(i).aCo().getPendantData().sB(mVar.aAG());
                        this.iFb.ckw().get(i).aCo().getPendantData().bI(mVar.aNY());
                    }
                }
            }
        }
    }

    public String cog() {
        return this.iKR;
    }

    public int coh() {
        return this.iKX;
    }

    public void yY(int i) {
        this.iKX = i;
    }

    public void FX(String str) {
        if ((!this.iKb || FV(TbadkCoreApplication.getCurrentAccount())) && this.iFb.ckw() != null) {
            this.iFb.getPage().jE(1);
            if (this.iFb.getPage().aBk() == 0) {
                this.iFb.getPage().jE(1);
            }
            this.iKY = str;
            yT(8);
        }
    }

    private void yZ(int i) {
        if (i != 8) {
            this.iKY = "";
            if (this.iKZ != null) {
                if (i == 1 && this.iFb != null && this.iFb.ckS()) {
                    if (this.iLa != null) {
                        getPbData().ckw().remove(this.iLa);
                    }
                } else if (i == 1 && !this.iKd && !com.baidu.tbadk.core.util.v.isEmpty(getPbData().ckw())) {
                    getPbData().ckw().remove(this.iKZ);
                    if (this.iLa != null) {
                        getPbData().ckw().remove(this.iLa);
                    }
                    getPbData().ckw().add(0, this.iKZ);
                } else {
                    getPbData().ckw().remove(this.iKZ);
                    if (this.iLa != null) {
                        getPbData().ckw().remove(this.iLa);
                    }
                }
            }
            this.iLa = null;
        }
    }

    public void coi() {
        if (this.iFb != null && !com.baidu.tbadk.core.util.v.isEmpty(this.iFb.ckw())) {
            if (this.iLa != null) {
                this.iFb.ckw().remove(this.iLa);
                this.iLa = null;
            }
            if (this.iKZ != null) {
                this.iFb.ckw().remove(this.iKZ);
                this.iKZ = null;
            }
        }
    }

    public void cr(int i, int i2) {
        this.iLb = i;
        this.iLc = i2;
    }

    public PostData coj() {
        return this.iKZ;
    }

    public PostData cok() {
        return this.iLa;
    }

    public int col() {
        return this.iLb;
    }

    public int com() {
        return this.iLc;
    }

    public String con() {
        return this.iLe;
    }

    public void FY(String str) {
        this.iLe = str;
    }

    private boolean coo() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean cop() {
        return this.iKX == 13 || this.iKX == 12;
    }

    public String coq() {
        return this.iLh;
    }

    public String cor() {
        return this.iLi;
    }

    public String cos() {
        return this.iLj;
    }

    public String cot() {
        return this.iLk;
    }

    public Rect cou() {
        Rect rect = this.iLd;
        this.iLd = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int cov() {
        int i;
        int i2 = 0;
        if (getPbData().ckw() == null) {
            return 0;
        }
        ArrayList<PostData> ckw = getPbData().ckw();
        int size = ckw.size() - 1;
        while (size >= 0) {
            PostData postData = ckw.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
                if (postData.getType() != AdvertAppInfo.cMK) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return ckw.size();
    }
}
