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
    private boolean cUE;
    private com.baidu.tieba.tbadkCore.d.b fXl;
    private long gHy;
    private BaseFragmentActivity gsB;
    private boolean hSb;
    protected com.baidu.tieba.pb.data.e iGO;
    protected String iLJ;
    private String iLK;
    private String iLL;
    private String iLM;
    private boolean iLN;
    private boolean iLO;
    private boolean iLP;
    private boolean iLQ;
    private int iLR;
    private boolean iLS;
    private int iLT;
    private long iLU;
    private int iLV;
    private int iLW;
    private int iLX;
    private int iLY;
    private boolean iLZ;
    private int iMA;
    private final v iMB;
    private final n iMC;
    private final x iMD;
    private String iME;
    private final CheckRealNameModel iMF;
    private final AddExperiencedModel iMG;
    private SuggestEmotionModel iMH;
    private GetSugMatchWordsModel iMI;
    private boolean iMJ;
    private int iMK;
    private String iML;
    private PostData iMM;
    private PostData iMN;
    private int iMO;
    private int iMP;
    private Rect iMQ;
    private String iMR;
    private com.baidu.tieba.tbadkCore.data.m iMS;
    private boolean iMT;
    private String iMU;
    private String iMV;
    private String iMW;
    private String iMX;
    private f.a iMY;
    private CustomMessageListener iMZ;
    private boolean iMa;
    private boolean iMb;
    private long iMc;
    private boolean iMd;
    private String iMe;
    private int iMf;
    private boolean iMg;
    private boolean iMh;
    private boolean iMi;
    private boolean iMj;
    private a iMk;
    private String iMl;
    private String iMm;
    private int iMn;
    private int iMo;
    private boolean iMp;
    private boolean iMq;
    private boolean iMr;
    private boolean iMs;
    private boolean iMt;
    private String iMu;
    private long iMv;
    private boolean iMw;
    private int iMx;
    private boolean iMy;
    private boolean iMz;
    private com.baidu.adp.framework.listener.a iNa;
    private PraiseData iNb;
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
    private static final int iLI = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.iLJ = null;
        this.iLK = null;
        this.iLL = null;
        this.mForumId = null;
        this.iLM = null;
        this.iLN = false;
        this.iLO = false;
        this.iLP = true;
        this.iLQ = true;
        this.mSortType = 0;
        this.iLR = 0;
        this.iLS = false;
        this.mIsGood = 0;
        this.iLT = 0;
        this.iLU = 0L;
        this.iLV = 1;
        this.iLW = 1;
        this.iLX = 1;
        this.iLY = 1;
        this.isAd = false;
        this.hSb = false;
        this.cUE = false;
        this.iLZ = false;
        this.isFromMark = false;
        this.iMa = false;
        this.iMb = false;
        this.iMc = 0L;
        this.iMd = false;
        this.iMe = null;
        this.iGO = null;
        this.isLoading = false;
        this.iMg = false;
        this.iMh = false;
        this.iMi = false;
        this.iMj = false;
        this.mLocate = null;
        this.mContext = null;
        this.iMk = null;
        this.opType = null;
        this.opUrl = null;
        this.iMl = null;
        this.iMm = null;
        this.iMn = -1;
        this.iMo = -1;
        this.fXl = null;
        this.iMq = false;
        this.iMr = false;
        this.postID = null;
        this.iMu = null;
        this.iMv = 0L;
        this.iMw = false;
        this.iMx = -1;
        this.iMz = false;
        this.iMJ = false;
        this.iMK = 0;
        this.mTabIndex = 0;
        this.iMT = false;
        this.iMZ = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.iNa = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.gsB.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.iMq || !PbModel.this.iMr) {
                        if (!PbModel.this.iMq) {
                            PbModel.this.iMq = true;
                        } else {
                            PbModel.this.iMr = true;
                        }
                        if (PbModel.this.iMk != null) {
                            PbModel.this.iMk.a(PbModel.this.cnP(), z, responsedMessage, PbModel.this.iMs, System.currentTimeMillis() - PbModel.this.gHy);
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
                    if (PbModel.this.iGO != null && PbModel.this.iGO.ckO() != null && PbModel.this.iGO.ckO().getForumId() != null && PbModel.this.iGO.ckO().getForumId().equals(valueOf)) {
                        PbModel.this.iGO.ckO().setIsLike(false);
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
                    if (PbModel.this.iGO != null && PbModel.this.iGO.ckO() != null && PbModel.this.iGO.ckO().getForumId() != null && PbModel.this.iGO.ckO().getForumId().equals(valueOf)) {
                        PbModel.this.iGO.ckO().setIsLike(true);
                    }
                }
            }
        };
        this.iNb = null;
        registerListener(this.iNa);
        registerListener(this.iMZ);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.iGO = new com.baidu.tieba.pb.data.e();
        this.iGO.yI(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.gsB = baseFragmentActivity;
        this.iMB = new v(this, this.gsB);
        this.iMC = new n(this, this.gsB);
        this.iMD = new x(this, this.gsB);
        this.iMF = new CheckRealNameModel(this.gsB.getPageContext());
        this.iMH = new SuggestEmotionModel();
        this.iMG = new AddExperiencedModel(this.gsB.getPageContext());
        this.iMY = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void n(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIv) instanceof String) {
                        PbModel.this.iLJ = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIv);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIw) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIw);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIx) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIx);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIy) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.cIy), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIz) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIz);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, String str) {
        this.iMt = true;
        if (eVar != null && eVar.iDr == null) {
            n(eVar);
            j(eVar);
            if (eVar.ckP() != null) {
                eVar.ckP().jH(0);
            }
            if (this.iMk != null && eVar != null) {
                this.iMk.a(true, 0, i, 0, eVar, str, 0);
            }
        }
    }

    protected int cnP() {
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
            this.iLJ = intent.getStringExtra("thread_id");
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            Uri uri = (Uri) intent.getParcelableExtra("key_uri");
            if (com.baidu.tbadk.BdToken.f.n(uri)) {
                com.baidu.tbadk.BdToken.f.axS().c(uri, this.iMY);
            } else if (StringUtils.isNull(this.iLJ)) {
                this.iMB.a(intent, this.iMY);
                if (uri != null) {
                    if (StringUtils.isNull(this.iLJ)) {
                        this.iLJ = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.aq.isEmpty(this.iLJ)) {
                this.iLJ = "0";
            }
            this.iMK = intent.getIntExtra("key_start_from", 0);
            if (this.iMK == 0) {
                this.iMK = this.iMB.YF;
            }
            this.iLL = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.iLK = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.iLN = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.iLO = intent.getBooleanExtra("host_only", false);
            this.iLQ = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.aRQ().aJd() ? 2 : 0);
            if (this.mSortType == 2) {
                this.iLL = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.iLT = intent.getIntExtra("is_top", 0);
            this.iLU = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.iMa = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.iMb = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.hSb = intent.getBooleanExtra("is_sub_pb", false);
            this.iMd = intent.getBooleanExtra("is_pv", false);
            this.iMc = intent.getLongExtra("msg_id", 0L);
            this.iMe = intent.getStringExtra("from_forum_name");
            this.iMm = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.iMl = intent.getStringExtra("op_stat");
            this.iMg = intent.getBooleanExtra("is_from_thread_config", false);
            this.iMh = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.iMi = intent.getBooleanExtra("is_from_my_god_config", false);
            this.iMo = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.iMn = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.cUE = intent.getBooleanExtra("from_frs", false);
            this.iLZ = intent.getBooleanExtra("from_maintab", false);
            this.iMz = intent.getBooleanExtra("from_smart_frs", false);
            this.iMj = intent.getBooleanExtra("from_hottopic", false);
            this.iME = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.iLM = intent.getStringExtra("high_light_post_id");
            this.iMT = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.iMp = intent.getIntExtra("request_code", -1) == 18003;
            this.iMU = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.iMV = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.iMW = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.iMX = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean cnQ() {
        return this.iMT && com.baidu.tieba.frs.i.bDN() != null && com.baidu.tieba.frs.i.bDN().equals(this.iLJ) && com.baidu.tieba.frs.i.bDM() != null;
    }

    public com.baidu.tieba.pb.data.e aH(bj bjVar) {
        com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
        eVar.yI(3);
        if (bjVar == null) {
            return null;
        }
        eVar.aF(bjVar);
        if (bjVar.aEb() != null) {
            eVar.e(bjVar.aEb());
            ForumData forum = eVar.getForum();
            forum.setId(bjVar.aEb().getForumId());
            forum.setName(bjVar.aEb().getForumName());
            forum.setUser_level(bjVar.aEb().aBI());
            forum.setImage_url(bjVar.aEb().getAvatar());
            forum.setPost_num(bjVar.aEb().postNum);
            forum.setMember_num(bjVar.aEb().memberNum);
        } else {
            ForumData forum2 = eVar.getForum();
            forum2.setId(String.valueOf(bjVar.getFid()));
            forum2.setName(bjVar.aCw());
        }
        PostData postData = new PostData();
        postData.CE(1);
        postData.setTime(bjVar.getCreateTime());
        postData.a(bjVar.aCr());
        MetaData aCr = bjVar.aCr();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(aCr.getUserId(), aCr);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bjVar.aCh(), false));
        eVar.d(postData);
        eVar.ckR().add(postData);
        eVar.a(new com.baidu.tieba.pb.data.k(bjVar, null));
        eVar.iDw = true;
        eVar.setIsNewUrl(1);
        return eVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.iMK = bundle.getInt("key_start_from", 0);
        this.iLJ = bundle.getString("thread_id");
        this.iLL = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.iLK = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.iLN = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.iLO = bundle.getBoolean("host_only", false);
        this.iLQ = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.iLT = bundle.getInt("is_top", 0);
        this.iLU = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.iMb = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.hSb = bundle.getBoolean("is_sub_pb", false);
        this.iMd = bundle.getBoolean("is_pv", false);
        this.iMc = bundle.getLong("msg_id", 0L);
        this.iMe = bundle.getString("from_forum_name");
        this.iMm = bundle.getString("extra_pb_cache_key");
        this.iMg = bundle.getBoolean("is_from_thread_config", false);
        this.iMh = bundle.getBoolean("is_from_interview_live_config", false);
        this.iMi = bundle.getBoolean("is_from_my_god_config", false);
        this.iMo = bundle.getInt("extra_pb_is_attention_key", -1);
        this.iMn = bundle.getInt("extra_pb_funs_count_key", -1);
        this.cUE = bundle.getBoolean("from_frs", false);
        this.iLZ = bundle.getBoolean("from_maintab", false);
        this.iMz = bundle.getBoolean("from_smart_frs", false);
        this.iMj = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.iLM = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.iMp = bundle.getInt("request_code", -1) == 18003;
        this.iMU = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.iMV = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.iMW = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.iMX = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void au(Bundle bundle) {
        bundle.putString("thread_id", this.iLJ);
        bundle.putString("post_id", this.iLL);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.iMK);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.iLN);
        bundle.putBoolean("host_only", this.iLO);
        bundle.putBoolean("squence", this.iLQ);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.iLT);
        bundle.putLong("thread_time", this.iLU);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.iMb);
        bundle.putBoolean("is_sub_pb", this.hSb);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.iMd);
        bundle.putLong("msg_id", this.iMc);
        bundle.putString("extra_pb_cache_key", this.iMm);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.iMg);
        bundle.putBoolean("is_from_interview_live_config", this.iMh);
        bundle.putBoolean("is_from_my_god_config", this.iMi);
        bundle.putInt("extra_pb_is_attention_key", this.iMo);
        bundle.putInt("extra_pb_funs_count_key", this.iMn);
        bundle.putBoolean("from_frs", this.cUE);
        bundle.putBoolean("from_maintab", this.iLZ);
        bundle.putBoolean("from_smart_frs", this.iMz);
        bundle.putBoolean("from_hottopic", this.iMj);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.iLM);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.iMU);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.iMV);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.iMW);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.iMX);
    }

    public String cnR() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.iLJ);
        if (!this.iMb) {
            sb.append(this.iLL);
        }
        sb.append(this.iLO);
        sb.append(this.iLQ);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.iLT);
        sb.append(this.iLU);
        sb.append(this.cUE);
        sb.append(this.iLZ);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.hSb);
        sb.append(this.iMd);
        sb.append(this.iMc);
        sb.append(this.iMe);
        sb.append(this.mThreadType);
        sb.append(this.iMg);
        sb.append(this.iMh);
        sb.append(this.iMi);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.iMm != null) {
            sb.append(this.iMm);
        }
        return sb.toString();
    }

    public String clO() {
        return this.iMe;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cnS() {
        return this.iLL;
    }

    public String cnT() {
        return this.iLM;
    }

    public String cnU() {
        return this.iLJ;
    }

    public boolean getHostMode() {
        return this.iLO;
    }

    public boolean cnV() {
        return coK();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean cnW() {
        return this.cUE;
    }

    public boolean cnX() {
        return this.iLS;
    }

    public boolean cnY() {
        return this.iLZ;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean cnZ() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bxW() {
        return this.iLT;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void yY(int i) {
        this.iLT = i;
    }

    public boolean coa() {
        return this.hSb;
    }

    public boolean cob() {
        if (this.iGO == null) {
            return false;
        }
        return this.iGO.isValid();
    }

    public String aCA() {
        if (this.iGO == null || !this.iGO.ayO()) {
            return null;
        }
        return this.iGO.ayN();
    }

    public boolean yZ(int i) {
        this.iLV = i;
        if (this.iLV > this.iGO.getPage().aBi()) {
            this.iLV = this.iGO.getPage().aBi();
        }
        if (this.iLV < 1) {
            this.iLV = 1;
        }
        if (this.iLJ == null) {
            return false;
        }
        return zb(5);
    }

    public void za(int i) {
        this.iLV = i;
        this.iLW = i;
        this.iLX = i;
    }

    public void b(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar == null) {
            za(1);
            return;
        }
        if (this.iLW < apVar.aBl()) {
            this.iLW = apVar.aBl();
        }
        if (this.iLX > apVar.aBl()) {
            this.iLX = apVar.aBl();
        }
        this.iLY = apVar.aBi();
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        return this.iGO;
    }

    public BaijiahaoData coc() {
        if (this.iGO == null || this.iGO.ckP() == null) {
            return null;
        }
        return this.iGO.ckP().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.e cod() {
        if (this.iGO == null) {
            return this.iGO;
        }
        if (!coe() && this.iMS != null) {
            this.iGO.b(this.iMS);
        }
        return this.iGO;
    }

    private boolean coe() {
        return (this.iGO.cle() == null || this.iGO.cle().cLj() == null || this.iGO.cle().cLj().goods != null || this.iGO.cle().cLj().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.ap getPageData() {
        if (this.iGO == null) {
            return null;
        }
        return this.iGO.getPage();
    }

    public boolean cof() {
        if (coK() && this.iGO.getPage().aBn() == 0) {
            qb(true);
            return true;
        }
        return false;
    }

    public void h(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.iLJ = eVar.getThreadId();
            if (eVar.ckP() != null && eVar.ckP().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = eVar.ckP().getBaijiahaoData();
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
            this.iLL = null;
            this.iLO = false;
            this.iLQ = true;
            LoadData();
        }
    }

    public void FO(String str) {
        if (!StringUtils.isNull(str)) {
            this.iLJ = str;
            this.iLL = null;
            this.iLO = false;
            this.iLQ = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.iLJ == null) {
            return false;
        }
        cancelLoadData();
        if (this.fXl == null) {
            this.fXl = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.fXl.start();
        }
        boolean zb = zb(3);
        if (this.opType != null) {
            this.opType = null;
            this.iMl = null;
            this.opUrl = null;
            return zb;
        }
        return zb;
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
        if (this.iMH != null) {
            this.iMH.cancelLoadData();
        }
        if (this.iMI != null) {
            this.iMI.cancelLoadData();
        }
        bza();
    }

    private void bza() {
        if (this.fXl != null) {
            this.fXl.destory();
            this.fXl = null;
        }
    }

    public boolean cog() {
        return (this.iLL == null || this.iLL.equals("0") || this.iLL.length() == 0) ? LoadData() : cok();
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
                this.iMH.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.iMH.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.iMI == null) {
                this.iMI = new GetSugMatchWordsModel(this.gsB.getPageContext());
            }
            this.iMI.b(aVar);
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
    public boolean zb(int i) {
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
        zc(i);
        final com.baidu.tieba.pb.data.e pbData = ah.cpm().getPbData();
        if (pbData != null && pbData.ckP() != null) {
            pbData.ckP().jH(0);
            this.iLQ = ah.cpm().cnV();
            this.iLO = ah.cpm().cpr();
            this.iLS = ah.cpm().cps();
            this.iMM = ah.cpm().cpq();
            this.iMN = ah.cpm().cpp();
            this.iMO = ah.cpm().cpo();
            this.iMQ = ah.cpm().cpt();
            this.mTabIndex = ah.cpm().getTabIndex();
            this.iMJ = this.iLO;
            if (this.iLO || this.isFromMark) {
                this.iMp = false;
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
        if (i == 4 && !this.iMt) {
            a(cop(), true, this.iLL, 3);
        }
        if (i == 3 && !this.iMt) {
            if (this.isFromMark) {
                a(cop(), true, this.iLL, 3);
            } else {
                a(cop(), false, this.iLL, 3);
            }
        }
        this.iMt = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.iMS == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.dwn);
        if (this.iLO || this.isFromMark) {
            this.iMp = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.iLJ == null || this.iLJ.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.iLJ, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.ar.aGH().aGI() ? 2 : 1));
        if (!this.iLQ) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.iLO) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.iMd) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.iMc));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.iMp) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.iMl, 0));
            pbPageRequestMessage.setOpMessageID(this.iMc);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> ckR = this.iGO.ckR();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iLX - 1));
                        if (this.iLX - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.iMa) {
                                if (ckR != null && ckR.size() > 0) {
                                    size = ckR.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = ckR.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.iLL = postData.getId();
                                            if (StringUtils.isNull(this.iLL)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.iLW + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.iLL == null && this.iLL.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iLL, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iLW + 1));
                        if (this.iLW >= this.iLY) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (ckR != null) {
                                size = ckR.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.iLL == null) {
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
                if (ckR != null) {
                }
                if (this.iLL == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (ckR != null && ckR.size() > 0 && ckR.get(0) != null) {
                    this.iLL = ckR.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (coK()) {
                        if (this.iLX - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.iLX - 1));
                        }
                    } else if (this.iLW < this.iLY) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iLW + 1));
                    }
                }
                if (this.iLL != null && this.iLL.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iLL, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.iLO) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (coK()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.iLY > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iLY));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iLL, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.iLV));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.iMJ && !this.iLO) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iLL, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.iLO) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.iMx);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iML, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.iMJ = this.iLO;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cop());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.iMK));
        pbPageRequestMessage.setIsSubPostDataReverse(this.iMw);
        pbPageRequestMessage.setFromSmartFrs(this.iMz ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.iLN);
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.iLY) {
                    i4 = -1;
                } else {
                    i4 = coR();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = coR();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.iLJ);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean clN() {
        switch (coD()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().ckP() == null || !getPbData().ckP().aDK();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(clO()) && com.baidu.tieba.recapp.r.cCQ().cCK() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cCQ().cCK().ax(clO(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cCQ().cCK().ay(clO(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(clO()) && com.baidu.tieba.recapp.r.cCQ().cCK() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cCQ().cCK().ay(clO(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cCQ().cCK().ax(clO(), true));
        }
    }

    protected void zc(int i) {
        boolean z = false;
        zh(i);
        ArrayList<PostData> ckR = this.iGO.ckR();
        this.iMs = false;
        if (i == 1) {
            boolean z2 = false;
            while (ckR.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                ckR.remove(0);
                z2 = true;
            }
            if (z2) {
                this.iGO.getPage().jF(1);
                if (this.iMk != null) {
                    this.iMk.e(this.iGO);
                }
            }
            this.gHy = System.currentTimeMillis();
            this.iMs = true;
        } else if (i == 2) {
            while (ckR.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                ckR.remove(ckR.size() - 1);
                z = true;
            }
            if (z) {
                this.iGO.getPage().jE(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.e eVar2 = z ? null : eVar;
        this.iMA = i2;
        this.isLoading = false;
        if (eVar2 != null) {
            j(eVar2);
        }
        i(eVar2);
        if (this.iMS != null && this.iMS.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(eVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void i(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cle() != null && eVar.cle().cLj() != null && eVar.cle().cLj().goods != null && eVar.cle().isValidate() && eVar.cle().cLj().goods.goods_style != 1001) {
            this.iMS = eVar.cle();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m coh() {
        return this.iMS;
    }

    public void coi() {
        this.iMS = null;
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
            if (this.iMi || this.iMg || this.iMh) {
                eVar = l(eVar);
            }
            k(eVar);
        }
    }

    protected void k(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            String m = m(eVar);
            for (int i = 0; i < eVar.ckR().size(); i++) {
                PostData postData = eVar.ckR().get(i);
                for (int i2 = 0; i2 < postData.cLs().size(); i2++) {
                    postData.cLs().get(i2).a(this.gsB.getPageContext(), m.equals(postData.cLs().get(i2).aCr().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n cla = eVar.cla();
            if (cla != null && !com.baidu.tbadk.core.util.v.isEmpty(cla.iEF)) {
                for (PostData postData2 : cla.iEF) {
                    for (int i3 = 0; i3 < postData2.cLs().size(); i3++) {
                        postData2.cLs().get(i3).a(this.gsB.getPageContext(), m.equals(postData2.cLs().get(i3).aCr().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i) {
        if (eVar != null) {
            String m = m(eVar);
            com.baidu.tieba.pb.data.n cla = eVar.cla();
            if (cla != null && !com.baidu.tbadk.core.util.v.isEmpty(cla.iEF)) {
                for (PostData postData : cla.iEF.subList(i, cla.iEF.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cLs().size()) {
                            postData.cLs().get(i3).a(this.gsB.getPageContext(), m.equals(postData.cLs().get(i3).aCr().getUserId()));
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
        bj ckP = eVar.ckP();
        ckP.jM(this.mIsGood);
        ckP.jL(this.iLT);
        if (this.iLU > 0) {
            ckP.bv(this.iLU);
            return eVar;
        }
        return eVar;
    }

    protected String m(com.baidu.tieba.pb.data.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.ckP() != null && eVar.ckP().aCr() != null) {
            str = eVar.ckP().aCr().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData coj() {
        if (this.iGO == null || this.iGO.ckP() == null || this.iGO.ckP().aCr() == null) {
            return null;
        }
        return this.iGO.ckP().aCr();
    }

    protected void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int size;
        int i4;
        int i5;
        boolean z4 = !z;
        this.iMy = z3;
        this.iMf = i;
        if (this.fXl != null && !z3) {
            this.fXl.a(z2, z4, i2, str, i3, j, j2);
            this.fXl = null;
        }
        if (this.iGO != null) {
            this.iGO.iEd = z3;
            this.iGO.Df = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(clO()) && com.baidu.tieba.recapp.r.cCQ().cCK() != null) {
            com.baidu.tieba.recapp.r.cCQ().cCK().f(clO(), zd(cos()), true);
        }
        if (eVar == null || (this.iLV == 1 && i == 5 && eVar.ckR() != null && eVar.ckR().size() < 1)) {
            if (this.iMk != null) {
                this.iLQ = this.iLP;
                if (i2 != 350006) {
                    this.mSortType = this.iLR;
                }
                this.iMk.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.iLP = this.iLQ;
            if (i != 8) {
                this.iLR = this.mSortType;
                this.mSortType = eVar.iDq;
            }
            if (eVar.iDp != null && eVar.iDp.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.gsB.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                eVar.iDp = new ArrayList();
                eVar.iDp.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.gsB.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                eVar.iDp.add(builder2.build(false));
                this.mSortType = this.iLR;
                eVar.iDq = this.mSortType;
            }
            this.iMd = false;
            if (eVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(eVar.getPage());
            }
            this.iLY = this.iLY < 1 ? 1 : this.iLY;
            ArrayList<PostData> ckR = this.iGO.ckR();
            switch (i) {
                case 1:
                    this.iGO.a(eVar.getPage(), 1);
                    d(eVar, ckR);
                    i4 = 0;
                    break;
                case 2:
                    if (eVar.ckR() == null) {
                        i5 = 0;
                    } else {
                        int size2 = eVar.ckR().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(ckR, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.ckR(), com.baidu.tbadk.core.util.v.getCount(eVar.ckR()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            eVar.ckR().remove(postData2);
                            i5 = size2 - 1;
                        }
                        ckR.addAll(0, eVar.ckR());
                    }
                    this.iGO.a(eVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && eVar.getPage() != null) {
                        eVar.getPage().jC(eVar.getPage().aBi());
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
                    if (eVar != null && !com.baidu.tbadk.core.util.v.isEmpty(eVar.ckR()) && this.iGO != null && (!this.iLO || m(eVar).equals(eVar.ckR().get(0).aCr().getUserId()))) {
                        if (this.iGO.getPage().aBn() == 0) {
                            this.iGO.getPage().jE(1);
                        }
                        coE();
                        this.iMM = eVar.ckR().get(0);
                        if (coK() || this.iGO.cln()) {
                            if (this.iGO.ckR().size() - this.iMO >= 3) {
                                this.iMN = new PostData();
                                this.iMN.kiK = true;
                                this.iMN.setPostType(53);
                                this.iGO.ckR().add(this.iMN);
                            }
                            this.iGO.ckR().add(this.iMM);
                            size = this.iGO.ckR().size() - 1;
                        } else {
                            if (this.iMO - this.iMP >= 3) {
                                this.iMN = new PostData();
                                this.iMN.kiK = false;
                                this.iMN.setPostType(53);
                                this.iGO.ckR().add(0, this.iMN);
                            }
                            this.iGO.ckR().add(0, this.iMM);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.isTaday(com.baidu.tbadk.core.sharedPref.b.aFH().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.iMM.kiX = this.iGO.cll();
                            com.baidu.tbadk.core.sharedPref.b.aFH().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        }
                        i4 = size;
                        break;
                    }
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.iGO != null && this.iGO.ckP() != null) {
                PraiseData aCc = this.iGO.ckP().aCc();
                if (this.iNb != null && !aCc.isPriaseDataValid()) {
                    this.iGO.ckP().a(this.iNb);
                } else {
                    this.iNb = this.iGO.ckP().aCc();
                    this.iNb.setPostId(this.iGO.ckP().aCH());
                }
                if (eVar.getPage() != null && eVar.getPage().aBl() == 1 && eVar.ckP() != null && eVar.ckP().aCC() != null && eVar.ckP().aCC().size() > 0) {
                    this.iGO.ckP().x(eVar.ckP().aCC());
                }
                this.iGO.ckP().jJ(eVar.ckP().aCi());
                this.iGO.ckP().jG(eVar.ckP().getAnchorLevel());
                this.iGO.ckP().jH(eVar.ckP().aBY());
                if (this.mThreadType == 33) {
                    this.iGO.ckP().aCr().setHadConcerned(eVar.ckP().aCr().hadConcerned());
                }
                if (eVar != null && eVar.ckP() != null) {
                    this.iGO.ckP().jO(eVar.ckP().aCG());
                }
            }
            if (this.iGO != null && this.iGO.getUserData() != null && eVar.getUserData() != null) {
                this.iGO.getUserData().setBimg_end_time(eVar.getUserData().getBimg_end_time());
                this.iGO.getUserData().setBimg_url(eVar.getUserData().getBimg_url());
            }
            if (eVar.getPage() != null && eVar.getPage().aBl() == 1 && eVar.ckZ() != null) {
                this.iGO.e(eVar.ckZ());
            }
            if (this.iMy) {
                if (this.iGO.ckP() != null && this.iGO.ckP().aCr() != null && this.iGO.ckR() != null && com.baidu.tbadk.core.util.v.getItem(this.iGO.ckR(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(this.iGO.ckR(), 0);
                    MetaData aCr = this.iGO.ckP().aCr();
                    if (postData3.aCr() != null && postData3.aCr().getGodUserData() != null) {
                        if (this.iMn != -1) {
                            aCr.setFansNum(this.iMn);
                            postData3.aCr().setFansNum(this.iMn);
                        }
                        if (this.iMo != -1) {
                            aCr.getGodUserData().setIsLike(this.iMo == 1);
                            postData3.aCr().getGodUserData().setIsLike(this.iMo == 1);
                            aCr.getGodUserData().setIsFromNetWork(false);
                            postData3.aCr().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.iGO.iDo = -1;
                this.iGO.iDn = -1;
            }
            if (this.iMk != null) {
                this.iMk.a(true, getErrorCode(), i, i4, this.iGO, this.mErrorString, 1);
            }
        }
        if (this.iGO != null && this.iGO.ckP() != null && this.iGO.getForum() != null && !this.iGO.cln()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.gsB.getPageContext();
            historyMessage.threadId = getPbData().ckP().getId();
            if (this.mIsShareThread && getPbData().ckP().cUe != null) {
                historyMessage.threadName = getPbData().ckP().cUe.showText;
            } else {
                historyMessage.threadName = getPbData().ckP().getTitle();
            }
            if (this.mIsShareThread && !clN()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = cnV();
            historyMessage.threadType = getPbData().ckP().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        String aL;
        if (arrayList != null && eVar.ckR() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.ckR(), 0);
            if (postData != null && (aL = aL(arrayList)) != null && aL.equals(postData.getId())) {
                eVar.ckR().remove(postData);
            }
            this.iGO.iEc = arrayList.size();
            arrayList.addAll(eVar.ckR());
        }
    }

    private int zd(int i) {
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
            eVar.FJ(this.iGO.clg());
            this.iGO = eVar;
            za(eVar.getPage().aBl());
        }
    }

    public boolean cok() {
        if (this.iLJ == null || this.iLL == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return zb(4);
        }
        return zb(6);
    }

    public boolean qb(boolean z) {
        if (this.iLJ == null || this.iGO == null) {
            return false;
        }
        if (z || this.iGO.getPage().aBn() != 0) {
            return zb(1);
        }
        return false;
    }

    public boolean qc(boolean z) {
        if (this.iLJ == null || this.iGO == null) {
            return false;
        }
        if ((z || this.iGO.getPage().aBo() != 0) && this.iGO.ckR() != null && this.iGO.ckR().size() >= 1) {
            return zb(2);
        }
        return false;
    }

    public boolean FU(String str) {
        this.iLO = !this.iLO;
        this.iLL = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").X("obj_source", 0));
        if (zb(6)) {
            return true;
        }
        this.iLO = this.iLO ? false : true;
        return false;
    }

    public boolean v(boolean z, String str) {
        if (this.iLO == z) {
            return false;
        }
        this.iLO = z;
        this.iLL = str;
        if (this.mSortType == 2) {
            this.iLL = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").X("obj_source", 1));
        }
        if (zb(6)) {
            return true;
        }
        this.iLO = z ? false : true;
        return false;
    }

    public boolean ze(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.iLP = this.iLQ;
        this.iLR = this.mSortType;
        this.mSortType = i;
        this.iLQ = !this.iLQ;
        if (i == 2 && this.isFromMark) {
            this.iLL = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.iLQ = this.iLQ ? false : true;
            this.mSortType = this.iLR;
            return false;
        }
        return true;
    }

    public boolean col() {
        return coK();
    }

    public int com() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.iGO == null || this.iGO.getForum() == null || this.iGO.ckP() == null) ? false : true;
    }

    public boolean ayO() {
        if (this.iGO == null) {
            return false;
        }
        return this.iGO.ayO();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData vi(String str) {
        if (this.iGO == null || this.iGO.ckP() == null || this.iGO.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.iGO.ckP().aDK()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.iGO.getForum().getId());
            writeData.setForumName(this.iGO.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.iMK);
        writeData.setThreadId(this.iLJ);
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

    public MarkData zf(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.iGO == null) {
            return null;
        }
        ArrayList<PostData> ckR = this.iGO.ckR();
        if (com.baidu.tbadk.core.util.v.isEmpty(ckR)) {
            return null;
        }
        if (ckR.size() > 0 && i >= ckR.size()) {
            i = ckR.size() - 1;
        }
        return l(ckR.get(i));
    }

    public MarkData con() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iLJ);
        markData.setPostId(this.iGO.ayN());
        markData.setTime(date.getTime());
        markData.setHostMode(this.iLO);
        markData.setSequence(Boolean.valueOf(coK()));
        markData.setId(this.iLJ);
        return markData;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iLJ);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.iLO);
        markData.setSequence(Boolean.valueOf(coK()));
        markData.setId(this.iLJ);
        markData.setFloor(postData.cLv());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void coo() {
        i.cmD().ar(cop(), this.isFromMark);
    }

    private String cop() {
        String coq = (this.iLJ == null || this.iLJ.equals("0")) ? coq() : this.iLJ;
        if (this.iLO) {
            coq = coq + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            coq = coq + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return coq + TbadkCoreApplication.getCurrentAccount();
        }
        return coq;
    }

    private String coq() {
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

    public void qd(boolean z) {
        if (this.iGO != null) {
            this.iGO.fn(z);
        }
    }

    public boolean cor() {
        return this.iMp;
    }

    public void a(a aVar) {
        this.iMk = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aOT() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aOS() {
        return cog();
    }

    public boolean FV(String str) {
        if (getPbData() == null || getPbData().ckP() == null || getPbData().ckP().aCr() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().ckP().aCr().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int cos() {
        return this.mRequestType;
    }

    public void cot() {
        if ("personalize_page".equals(this.mStType)) {
            this.iMv = System.currentTimeMillis() / 1000;
        }
    }

    public void cou() {
        if ("personalize_page".equals(this.mStType) && this.iGO != null && this.iMv != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").cx("fid", this.iGO.getForumId()).cx("tid", this.iLJ).cx("obj_duration", String.valueOf(currentTimeMillis - this.iMv)).cx(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.iMv = 0L;
        }
    }

    public boolean cov() {
        return this.iMy;
    }

    public int getErrorNo() {
        return this.iMA;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public n cow() {
        return this.iMC;
    }

    public x cox() {
        return this.iMD;
    }

    public CheckRealNameModel coy() {
        return this.iMF;
    }

    public AddExperiencedModel coz() {
        return this.iMG;
    }

    public String coA() {
        return this.iMu;
    }

    public void FW(String str) {
        this.iMu = str;
    }

    public boolean coB() {
        return this.iMz;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.iGO != null && this.iGO.ckR() != null && this.iGO.ckR().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.iGO.ckR().size();
                for (int i = 0; i < size; i++) {
                    if (this.iGO.ckR().get(i) != null && this.iGO.ckR().get(i).aCr() != null && currentAccount.equals(this.iGO.ckR().get(i).aCr().getUserId()) && this.iGO.ckR().get(i).aCr().getPendantData() != null) {
                        this.iGO.ckR().get(i).aCr().getPendantData().sA(mVar.aAJ());
                        this.iGO.ckR().get(i).aCr().getPendantData().bI(mVar.aOd());
                    }
                }
            }
        }
    }

    public String coC() {
        return this.iME;
    }

    public int coD() {
        return this.iMK;
    }

    public void zg(int i) {
        this.iMK = i;
    }

    public void FX(String str) {
        if ((!this.iLO || FV(TbadkCoreApplication.getCurrentAccount())) && this.iGO.ckR() != null) {
            this.iGO.getPage().jE(1);
            if (this.iGO.getPage().aBn() == 0) {
                this.iGO.getPage().jE(1);
            }
            this.iML = str;
            zb(8);
        }
    }

    private void zh(int i) {
        if (i != 8) {
            this.iML = "";
            if (this.iMM != null) {
                if (i == 1 && this.iGO != null && this.iGO.cln()) {
                    if (this.iMN != null) {
                        getPbData().ckR().remove(this.iMN);
                    }
                } else if (i == 1 && !this.iLQ && !com.baidu.tbadk.core.util.v.isEmpty(getPbData().ckR())) {
                    getPbData().ckR().remove(this.iMM);
                    if (this.iMN != null) {
                        getPbData().ckR().remove(this.iMN);
                    }
                    getPbData().ckR().add(0, this.iMM);
                } else {
                    getPbData().ckR().remove(this.iMM);
                    if (this.iMN != null) {
                        getPbData().ckR().remove(this.iMN);
                    }
                }
            }
            this.iMN = null;
        }
    }

    public void coE() {
        if (this.iGO != null && !com.baidu.tbadk.core.util.v.isEmpty(this.iGO.ckR())) {
            if (this.iMN != null) {
                this.iGO.ckR().remove(this.iMN);
                this.iMN = null;
            }
            if (this.iMM != null) {
                this.iGO.ckR().remove(this.iMM);
                this.iMM = null;
            }
        }
    }

    public void cs(int i, int i2) {
        this.iMO = i;
        this.iMP = i2;
    }

    public PostData coF() {
        return this.iMM;
    }

    public PostData coG() {
        return this.iMN;
    }

    public int coH() {
        return this.iMO;
    }

    public int coI() {
        return this.iMP;
    }

    public String coJ() {
        return this.iMR;
    }

    public void FY(String str) {
        this.iMR = str;
    }

    private boolean coK() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean coL() {
        return this.iMK == 13 || this.iMK == 12;
    }

    public String coM() {
        return this.iMU;
    }

    public String coN() {
        return this.iMV;
    }

    public String coO() {
        return this.iMW;
    }

    public String coP() {
        return this.iMX;
    }

    public Rect coQ() {
        Rect rect = this.iMQ;
        this.iMQ = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int coR() {
        int i;
        int i2 = 0;
        if (getPbData().ckR() == null) {
            return 0;
        }
        ArrayList<PostData> ckR = getPbData().ckR();
        int size = ckR.size() - 1;
        while (size >= 0) {
            PostData postData = ckR.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
                if (postData.getType() != AdvertAppInfo.cMW) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return ckR.size();
    }
}
