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
    private boolean cUr;
    private com.baidu.tieba.tbadkCore.d.b fWD;
    private long gGA;
    private BaseFragmentActivity grR;
    private boolean hQB;
    protected com.baidu.tieba.pb.data.e iFn;
    private boolean iKA;
    private long iKB;
    private boolean iKC;
    private String iKD;
    private int iKE;
    private boolean iKF;
    private boolean iKG;
    private boolean iKH;
    private boolean iKI;
    private a iKJ;
    private String iKK;
    private String iKL;
    private int iKM;
    private int iKN;
    private boolean iKO;
    private boolean iKP;
    private boolean iKQ;
    private boolean iKR;
    private boolean iKS;
    private String iKT;
    private long iKU;
    private boolean iKV;
    private int iKW;
    private boolean iKX;
    private boolean iKY;
    private int iKZ;
    protected String iKi;
    private String iKj;
    private String iKk;
    private String iKl;
    private boolean iKm;
    private boolean iKn;
    private boolean iKo;
    private boolean iKp;
    private int iKq;
    private boolean iKr;
    private int iKs;
    private long iKt;
    private int iKu;
    private int iKv;
    private int iKw;
    private int iKx;
    private boolean iKy;
    private boolean iKz;
    private PraiseData iLA;
    private final v iLa;
    private final n iLb;
    private final x iLc;
    private String iLd;
    private final CheckRealNameModel iLe;
    private final AddExperiencedModel iLf;
    private SuggestEmotionModel iLg;
    private GetSugMatchWordsModel iLh;
    private boolean iLi;
    private int iLj;
    private String iLk;
    private PostData iLl;
    private PostData iLm;
    private int iLn;
    private int iLo;
    private Rect iLp;
    private String iLq;
    private com.baidu.tieba.tbadkCore.data.m iLr;
    private boolean iLs;
    private String iLt;
    private String iLu;
    private String iLv;
    private String iLw;
    private f.a iLx;
    private CustomMessageListener iLy;
    private com.baidu.adp.framework.listener.a iLz;
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
    private static final int iKh = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.iKi = null;
        this.iKj = null;
        this.iKk = null;
        this.mForumId = null;
        this.iKl = null;
        this.iKm = false;
        this.iKn = false;
        this.iKo = true;
        this.iKp = true;
        this.mSortType = 0;
        this.iKq = 0;
        this.iKr = false;
        this.mIsGood = 0;
        this.iKs = 0;
        this.iKt = 0L;
        this.iKu = 1;
        this.iKv = 1;
        this.iKw = 1;
        this.iKx = 1;
        this.isAd = false;
        this.hQB = false;
        this.cUr = false;
        this.iKy = false;
        this.isFromMark = false;
        this.iKz = false;
        this.iKA = false;
        this.iKB = 0L;
        this.iKC = false;
        this.iKD = null;
        this.iFn = null;
        this.isLoading = false;
        this.iKF = false;
        this.iKG = false;
        this.iKH = false;
        this.iKI = false;
        this.mLocate = null;
        this.mContext = null;
        this.iKJ = null;
        this.opType = null;
        this.opUrl = null;
        this.iKK = null;
        this.iKL = null;
        this.iKM = -1;
        this.iKN = -1;
        this.fWD = null;
        this.iKP = false;
        this.iKQ = false;
        this.postID = null;
        this.iKT = null;
        this.iKU = 0L;
        this.iKV = false;
        this.iKW = -1;
        this.iKY = false;
        this.iLi = false;
        this.iLj = 0;
        this.mTabIndex = 0;
        this.iLs = false;
        this.iLy = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.iLz = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.grR.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.iKP || !PbModel.this.iKQ) {
                        if (!PbModel.this.iKP) {
                            PbModel.this.iKP = true;
                        } else {
                            PbModel.this.iKQ = true;
                        }
                        if (PbModel.this.iKJ != null) {
                            PbModel.this.iKJ.a(PbModel.this.cnu(), z, responsedMessage, PbModel.this.iKR, System.currentTimeMillis() - PbModel.this.gGA);
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
                    if (PbModel.this.iFn != null && PbModel.this.iFn.cku() != null && PbModel.this.iFn.cku().getForumId() != null && PbModel.this.iFn.cku().getForumId().equals(valueOf)) {
                        PbModel.this.iFn.cku().setIsLike(false);
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
                    if (PbModel.this.iFn != null && PbModel.this.iFn.cku() != null && PbModel.this.iFn.cku().getForumId() != null && PbModel.this.iFn.cku().getForumId().equals(valueOf)) {
                        PbModel.this.iFn.cku().setIsLike(true);
                    }
                }
            }
        };
        this.iLA = null;
        registerListener(this.iLz);
        registerListener(this.iLy);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.iFn = new com.baidu.tieba.pb.data.e();
        this.iFn.yA(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.grR = baseFragmentActivity;
        this.iLa = new v(this, this.grR);
        this.iLb = new n(this, this.grR);
        this.iLc = new x(this, this.grR);
        this.iLe = new CheckRealNameModel(this.grR.getPageContext());
        this.iLg = new SuggestEmotionModel();
        this.iLf = new AddExperiencedModel(this.grR.getPageContext());
        this.iLx = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void n(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIk) instanceof String) {
                        PbModel.this.iKi = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIk);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIl) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIl);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIm) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIm);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIn) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.cIn), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIo) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIo);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, String str) {
        this.iKS = true;
        if (eVar != null && eVar.iBR == null) {
            n(eVar);
            j(eVar);
            if (eVar.ckv() != null) {
                eVar.ckv().jH(0);
            }
            if (this.iKJ != null && eVar != null) {
                this.iKJ.a(true, 0, i, 0, eVar, str, 0);
            }
        }
    }

    protected int cnu() {
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
            this.iKi = intent.getStringExtra("thread_id");
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            Uri uri = (Uri) intent.getParcelableExtra("key_uri");
            if (com.baidu.tbadk.BdToken.f.n(uri)) {
                com.baidu.tbadk.BdToken.f.axP().c(uri, this.iLx);
            } else if (StringUtils.isNull(this.iKi)) {
                this.iLa.a(intent, this.iLx);
                if (uri != null) {
                    if (StringUtils.isNull(this.iKi)) {
                        this.iKi = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.aq.isEmpty(this.iKi)) {
                this.iKi = "0";
            }
            this.iLj = intent.getIntExtra("key_start_from", 0);
            if (this.iLj == 0) {
                this.iLj = this.iLa.Yv;
            }
            this.iKk = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.iKj = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.iKm = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.iKn = intent.getBooleanExtra("host_only", false);
            this.iKp = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.aRM().aIZ() ? 2 : 0);
            if (this.mSortType == 2) {
                this.iKk = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.iKs = intent.getIntExtra("is_top", 0);
            this.iKt = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.iKz = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.iKA = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.hQB = intent.getBooleanExtra("is_sub_pb", false);
            this.iKC = intent.getBooleanExtra("is_pv", false);
            this.iKB = intent.getLongExtra("msg_id", 0L);
            this.iKD = intent.getStringExtra("from_forum_name");
            this.iKL = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.iKK = intent.getStringExtra("op_stat");
            this.iKF = intent.getBooleanExtra("is_from_thread_config", false);
            this.iKG = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.iKH = intent.getBooleanExtra("is_from_my_god_config", false);
            this.iKN = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.iKM = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.cUr = intent.getBooleanExtra("from_frs", false);
            this.iKy = intent.getBooleanExtra("from_maintab", false);
            this.iKY = intent.getBooleanExtra("from_smart_frs", false);
            this.iKI = intent.getBooleanExtra("from_hottopic", false);
            this.iLd = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.iKl = intent.getStringExtra("high_light_post_id");
            this.iLs = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.iKO = intent.getIntExtra("request_code", -1) == 18003;
            this.iLt = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.iLu = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.iLv = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.iLw = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean cnv() {
        return this.iLs && com.baidu.tieba.frs.i.bDF() != null && com.baidu.tieba.frs.i.bDF().equals(this.iKi) && com.baidu.tieba.frs.i.bDE() != null;
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
        eVar.ckx().add(postData);
        eVar.a(new com.baidu.tieba.pb.data.k(bjVar, null));
        eVar.iBW = true;
        eVar.setIsNewUrl(1);
        return eVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.iLj = bundle.getInt("key_start_from", 0);
        this.iKi = bundle.getString("thread_id");
        this.iKk = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.iKj = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.iKm = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.iKn = bundle.getBoolean("host_only", false);
        this.iKp = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.iKs = bundle.getInt("is_top", 0);
        this.iKt = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.iKA = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.hQB = bundle.getBoolean("is_sub_pb", false);
        this.iKC = bundle.getBoolean("is_pv", false);
        this.iKB = bundle.getLong("msg_id", 0L);
        this.iKD = bundle.getString("from_forum_name");
        this.iKL = bundle.getString("extra_pb_cache_key");
        this.iKF = bundle.getBoolean("is_from_thread_config", false);
        this.iKG = bundle.getBoolean("is_from_interview_live_config", false);
        this.iKH = bundle.getBoolean("is_from_my_god_config", false);
        this.iKN = bundle.getInt("extra_pb_is_attention_key", -1);
        this.iKM = bundle.getInt("extra_pb_funs_count_key", -1);
        this.cUr = bundle.getBoolean("from_frs", false);
        this.iKy = bundle.getBoolean("from_maintab", false);
        this.iKY = bundle.getBoolean("from_smart_frs", false);
        this.iKI = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.iKl = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.iKO = bundle.getInt("request_code", -1) == 18003;
        this.iLt = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.iLu = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.iLv = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.iLw = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void au(Bundle bundle) {
        bundle.putString("thread_id", this.iKi);
        bundle.putString("post_id", this.iKk);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.iLj);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.iKm);
        bundle.putBoolean("host_only", this.iKn);
        bundle.putBoolean("squence", this.iKp);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.iKs);
        bundle.putLong("thread_time", this.iKt);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.iKA);
        bundle.putBoolean("is_sub_pb", this.hQB);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.iKC);
        bundle.putLong("msg_id", this.iKB);
        bundle.putString("extra_pb_cache_key", this.iKL);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.iKF);
        bundle.putBoolean("is_from_interview_live_config", this.iKG);
        bundle.putBoolean("is_from_my_god_config", this.iKH);
        bundle.putInt("extra_pb_is_attention_key", this.iKN);
        bundle.putInt("extra_pb_funs_count_key", this.iKM);
        bundle.putBoolean("from_frs", this.cUr);
        bundle.putBoolean("from_maintab", this.iKy);
        bundle.putBoolean("from_smart_frs", this.iKY);
        bundle.putBoolean("from_hottopic", this.iKI);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.iKl);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.iLt);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.iLu);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.iLv);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.iLw);
    }

    public String cnw() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.iKi);
        if (!this.iKA) {
            sb.append(this.iKk);
        }
        sb.append(this.iKn);
        sb.append(this.iKp);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.iKs);
        sb.append(this.iKt);
        sb.append(this.cUr);
        sb.append(this.iKy);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.hQB);
        sb.append(this.iKC);
        sb.append(this.iKB);
        sb.append(this.iKD);
        sb.append(this.mThreadType);
        sb.append(this.iKF);
        sb.append(this.iKG);
        sb.append(this.iKH);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.iKL != null) {
            sb.append(this.iKL);
        }
        return sb.toString();
    }

    public String clt() {
        return this.iKD;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cnx() {
        return this.iKk;
    }

    public String cny() {
        return this.iKl;
    }

    public String cnz() {
        return this.iKi;
    }

    public boolean getHostMode() {
        return this.iKn;
    }

    public boolean cnA() {
        return cop();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean cnB() {
        return this.cUr;
    }

    public boolean cnC() {
        return this.iKr;
    }

    public boolean cnD() {
        return this.iKy;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean cnE() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bxR() {
        return this.iKs;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void yQ(int i) {
        this.iKs = i;
    }

    public boolean cnF() {
        return this.hQB;
    }

    public boolean cnG() {
        if (this.iFn == null) {
            return false;
        }
        return this.iFn.isValid();
    }

    public String aCx() {
        if (this.iFn == null || !this.iFn.ayL()) {
            return null;
        }
        return this.iFn.ayK();
    }

    public boolean yR(int i) {
        this.iKu = i;
        if (this.iKu > this.iFn.getPage().aBf()) {
            this.iKu = this.iFn.getPage().aBf();
        }
        if (this.iKu < 1) {
            this.iKu = 1;
        }
        if (this.iKi == null) {
            return false;
        }
        return yT(5);
    }

    public void yS(int i) {
        this.iKu = i;
        this.iKv = i;
        this.iKw = i;
    }

    public void b(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar == null) {
            yS(1);
            return;
        }
        if (this.iKv < apVar.aBi()) {
            this.iKv = apVar.aBi();
        }
        if (this.iKw > apVar.aBi()) {
            this.iKw = apVar.aBi();
        }
        this.iKx = apVar.aBf();
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        return this.iFn;
    }

    public BaijiahaoData cnH() {
        if (this.iFn == null || this.iFn.ckv() == null) {
            return null;
        }
        return this.iFn.ckv().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.e cnI() {
        if (this.iFn == null) {
            return this.iFn;
        }
        if (!cnJ() && this.iLr != null) {
            this.iFn.b(this.iLr);
        }
        return this.iFn;
    }

    private boolean cnJ() {
        return (this.iFn.ckK() == null || this.iFn.ckK().cKP() == null || this.iFn.ckK().cKP().goods != null || this.iFn.ckK().cKP().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.ap getPageData() {
        if (this.iFn == null) {
            return null;
        }
        return this.iFn.getPage();
    }

    public boolean cnK() {
        if (cop() && this.iFn.getPage().aBk() == 0) {
            pV(true);
            return true;
        }
        return false;
    }

    public void h(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.iKi = eVar.getThreadId();
            if (eVar.ckv() != null && eVar.ckv().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = eVar.ckv().getBaijiahaoData();
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
            this.iKk = null;
            this.iKn = false;
            this.iKp = true;
            LoadData();
        }
    }

    public void FP(String str) {
        if (!StringUtils.isNull(str)) {
            this.iKi = str;
            this.iKk = null;
            this.iKn = false;
            this.iKp = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.iKi == null) {
            return false;
        }
        cancelLoadData();
        if (this.fWD == null) {
            this.fWD = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.fWD.start();
        }
        boolean yT = yT(3);
        if (this.opType != null) {
            this.opType = null;
            this.iKK = null;
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
        if (this.iLg != null) {
            this.iLg.cancelLoadData();
        }
        if (this.iLh != null) {
            this.iLh.cancelLoadData();
        }
        byU();
    }

    private void byU() {
        if (this.fWD != null) {
            this.fWD.destory();
            this.fWD = null;
        }
    }

    public boolean cnL() {
        return (this.iKk == null || this.iKk.equals("0") || this.iKk.length() == 0) ? LoadData() : cnP();
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
                this.iLg.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.iLg.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.iLh == null) {
                this.iLh = new GetSugMatchWordsModel(this.grR.getPageContext());
            }
            this.iLh.b(aVar);
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
        final com.baidu.tieba.pb.data.e pbData = ah.coR().getPbData();
        if (pbData != null && pbData.ckv() != null) {
            pbData.ckv().jH(0);
            this.iKp = ah.coR().cnA();
            this.iKn = ah.coR().coW();
            this.iKr = ah.coR().coX();
            this.iLl = ah.coR().coV();
            this.iLm = ah.coR().coU();
            this.iLn = ah.coR().coT();
            this.iLp = ah.coR().coY();
            this.mTabIndex = ah.coR().getTabIndex();
            this.iLi = this.iKn;
            if (this.iKn || this.isFromMark) {
                this.iKO = false;
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
        if (i == 4 && !this.iKS) {
            a(cnU(), true, this.iKk, 3);
        }
        if (i == 3 && !this.iKS) {
            if (this.isFromMark) {
                a(cnU(), true, this.iKk, 3);
            } else {
                a(cnU(), false, this.iKk, 3);
            }
        }
        this.iKS = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.iLr == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.dwa);
        if (this.iKn || this.isFromMark) {
            this.iKO = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.iKi == null || this.iKi.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.iKi, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.ar.aGD().aGE() ? 2 : 1));
        if (!this.iKp) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.iKn) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.iKC) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.iKB));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.iKO) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.iKK, 0));
            pbPageRequestMessage.setOpMessageID(this.iKB);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> ckx = this.iFn.ckx();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iKw - 1));
                        if (this.iKw - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.iKz) {
                                if (ckx != null && ckx.size() > 0) {
                                    size = ckx.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = ckx.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.iKk = postData.getId();
                                            if (StringUtils.isNull(this.iKk)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.iKv + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.iKk == null && this.iKk.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iKk, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iKv + 1));
                        if (this.iKv >= this.iKx) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (ckx != null) {
                                size = ckx.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.iKk == null) {
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
                if (ckx != null) {
                }
                if (this.iKk == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (ckx != null && ckx.size() > 0 && ckx.get(0) != null) {
                    this.iKk = ckx.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (cop()) {
                        if (this.iKw - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.iKw - 1));
                        }
                    } else if (this.iKv < this.iKx) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iKv + 1));
                    }
                }
                if (this.iKk != null && this.iKk.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iKk, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.iKn) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (cop()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.iKx > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iKx));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iKk, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.iKu));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.iLi && !this.iKn) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iKk, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.iKn) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.iKW);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iLk, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.iLi = this.iKn;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cnU());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.iLj));
        pbPageRequestMessage.setIsSubPostDataReverse(this.iKV);
        pbPageRequestMessage.setFromSmartFrs(this.iKY ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.iKm);
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.iKx) {
                    i4 = -1;
                } else {
                    i4 = cow();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = cow();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.iKi);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean cls() {
        switch (coi()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().ckv() == null || !getPbData().ckv().aDG();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(clt()) && com.baidu.tieba.recapp.r.cCw().cCq() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cCw().cCq().ax(clt(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cCw().cCq().ay(clt(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(clt()) && com.baidu.tieba.recapp.r.cCw().cCq() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cCw().cCq().ay(clt(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cCw().cCq().ax(clt(), true));
        }
    }

    protected void yU(int i) {
        boolean z = false;
        yZ(i);
        ArrayList<PostData> ckx = this.iFn.ckx();
        this.iKR = false;
        if (i == 1) {
            boolean z2 = false;
            while (ckx.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                ckx.remove(0);
                z2 = true;
            }
            if (z2) {
                this.iFn.getPage().jF(1);
                if (this.iKJ != null) {
                    this.iKJ.e(this.iFn);
                }
            }
            this.gGA = System.currentTimeMillis();
            this.iKR = true;
        } else if (i == 2) {
            while (ckx.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                ckx.remove(ckx.size() - 1);
                z = true;
            }
            if (z) {
                this.iFn.getPage().jE(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.e eVar2 = z ? null : eVar;
        this.iKZ = i2;
        this.isLoading = false;
        if (eVar2 != null) {
            j(eVar2);
        }
        i(eVar2);
        if (this.iLr != null && this.iLr.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(eVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void i(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckK() != null && eVar.ckK().cKP() != null && eVar.ckK().cKP().goods != null && eVar.ckK().isValidate() && eVar.ckK().cKP().goods.goods_style != 1001) {
            this.iLr = eVar.ckK();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m cnM() {
        return this.iLr;
    }

    public void cnN() {
        this.iLr = null;
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
            if (this.iKH || this.iKF || this.iKG) {
                eVar = l(eVar);
            }
            k(eVar);
        }
    }

    protected void k(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            String m = m(eVar);
            for (int i = 0; i < eVar.ckx().size(); i++) {
                PostData postData = eVar.ckx().get(i);
                for (int i2 = 0; i2 < postData.cKY().size(); i2++) {
                    postData.cKY().get(i2).a(this.grR.getPageContext(), m.equals(postData.cKY().get(i2).aCo().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n ckG = eVar.ckG();
            if (ckG != null && !com.baidu.tbadk.core.util.v.isEmpty(ckG.iDe)) {
                for (PostData postData2 : ckG.iDe) {
                    for (int i3 = 0; i3 < postData2.cKY().size(); i3++) {
                        postData2.cKY().get(i3).a(this.grR.getPageContext(), m.equals(postData2.cKY().get(i3).aCo().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i) {
        if (eVar != null) {
            String m = m(eVar);
            com.baidu.tieba.pb.data.n ckG = eVar.ckG();
            if (ckG != null && !com.baidu.tbadk.core.util.v.isEmpty(ckG.iDe)) {
                for (PostData postData : ckG.iDe.subList(i, ckG.iDe.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cKY().size()) {
                            postData.cKY().get(i3).a(this.grR.getPageContext(), m.equals(postData.cKY().get(i3).aCo().getUserId()));
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
        bj ckv = eVar.ckv();
        ckv.jM(this.mIsGood);
        ckv.jL(this.iKs);
        if (this.iKt > 0) {
            ckv.bv(this.iKt);
            return eVar;
        }
        return eVar;
    }

    protected String m(com.baidu.tieba.pb.data.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.ckv() != null && eVar.ckv().aCo() != null) {
            str = eVar.ckv().aCo().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData cnO() {
        if (this.iFn == null || this.iFn.ckv() == null || this.iFn.ckv().aCo() == null) {
            return null;
        }
        return this.iFn.ckv().aCo();
    }

    protected void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int size;
        int i4;
        int i5;
        boolean z4 = !z;
        this.iKX = z3;
        this.iKE = i;
        if (this.fWD != null && !z3) {
            this.fWD.a(z2, z4, i2, str, i3, j, j2);
            this.fWD = null;
        }
        if (this.iFn != null) {
            this.iFn.iCD = z3;
            this.iFn.Df = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(clt()) && com.baidu.tieba.recapp.r.cCw().cCq() != null) {
            com.baidu.tieba.recapp.r.cCw().cCq().g(clt(), yV(cnX()), true);
        }
        if (eVar == null || (this.iKu == 1 && i == 5 && eVar.ckx() != null && eVar.ckx().size() < 1)) {
            if (this.iKJ != null) {
                this.iKp = this.iKo;
                if (i2 != 350006) {
                    this.mSortType = this.iKq;
                }
                this.iKJ.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.iKo = this.iKp;
            if (i != 8) {
                this.iKq = this.mSortType;
                this.mSortType = eVar.iBQ;
            }
            if (eVar.iBP != null && eVar.iBP.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.grR.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                eVar.iBP = new ArrayList();
                eVar.iBP.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.grR.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                eVar.iBP.add(builder2.build(false));
                this.mSortType = this.iKq;
                eVar.iBQ = this.mSortType;
            }
            this.iKC = false;
            if (eVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(eVar.getPage());
            }
            this.iKx = this.iKx < 1 ? 1 : this.iKx;
            ArrayList<PostData> ckx = this.iFn.ckx();
            switch (i) {
                case 1:
                    this.iFn.a(eVar.getPage(), 1);
                    d(eVar, ckx);
                    i4 = 0;
                    break;
                case 2:
                    if (eVar.ckx() == null) {
                        i5 = 0;
                    } else {
                        int size2 = eVar.ckx().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(ckx, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.ckx(), com.baidu.tbadk.core.util.v.getCount(eVar.ckx()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            eVar.ckx().remove(postData2);
                            i5 = size2 - 1;
                        }
                        ckx.addAll(0, eVar.ckx());
                    }
                    this.iFn.a(eVar.getPage(), 2);
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
                    if (eVar != null && !com.baidu.tbadk.core.util.v.isEmpty(eVar.ckx()) && this.iFn != null && (!this.iKn || m(eVar).equals(eVar.ckx().get(0).aCo().getUserId()))) {
                        if (this.iFn.getPage().aBk() == 0) {
                            this.iFn.getPage().jE(1);
                        }
                        coj();
                        this.iLl = eVar.ckx().get(0);
                        if (cop() || this.iFn.ckT()) {
                            if (this.iFn.ckx().size() - this.iLn >= 3) {
                                this.iLm = new PostData();
                                this.iLm.khh = true;
                                this.iLm.setPostType(53);
                                this.iFn.ckx().add(this.iLm);
                            }
                            this.iFn.ckx().add(this.iLl);
                            size = this.iFn.ckx().size() - 1;
                        } else {
                            if (this.iLn - this.iLo >= 3) {
                                this.iLm = new PostData();
                                this.iLm.khh = false;
                                this.iLm.setPostType(53);
                                this.iFn.ckx().add(0, this.iLm);
                            }
                            this.iFn.ckx().add(0, this.iLl);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.isTaday(com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.iLl.khu = this.iFn.ckR();
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
            if (this.iFn != null && this.iFn.ckv() != null) {
                PraiseData aBZ = this.iFn.ckv().aBZ();
                if (this.iLA != null && !aBZ.isPriaseDataValid()) {
                    this.iFn.ckv().a(this.iLA);
                } else {
                    this.iLA = this.iFn.ckv().aBZ();
                    this.iLA.setPostId(this.iFn.ckv().aCE());
                }
                if (eVar.getPage() != null && eVar.getPage().aBi() == 1 && eVar.ckv() != null && eVar.ckv().aCz() != null && eVar.ckv().aCz().size() > 0) {
                    this.iFn.ckv().x(eVar.ckv().aCz());
                }
                this.iFn.ckv().jJ(eVar.ckv().aCf());
                this.iFn.ckv().jG(eVar.ckv().getAnchorLevel());
                this.iFn.ckv().jH(eVar.ckv().aBV());
                if (this.mThreadType == 33) {
                    this.iFn.ckv().aCo().setHadConcerned(eVar.ckv().aCo().hadConcerned());
                }
                if (eVar != null && eVar.ckv() != null) {
                    this.iFn.ckv().jO(eVar.ckv().aCD());
                }
            }
            if (this.iFn != null && this.iFn.getUserData() != null && eVar.getUserData() != null) {
                this.iFn.getUserData().setBimg_end_time(eVar.getUserData().getBimg_end_time());
                this.iFn.getUserData().setBimg_url(eVar.getUserData().getBimg_url());
            }
            if (eVar.getPage() != null && eVar.getPage().aBi() == 1 && eVar.ckF() != null) {
                this.iFn.e(eVar.ckF());
            }
            if (this.iKX) {
                if (this.iFn.ckv() != null && this.iFn.ckv().aCo() != null && this.iFn.ckx() != null && com.baidu.tbadk.core.util.v.getItem(this.iFn.ckx(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(this.iFn.ckx(), 0);
                    MetaData aCo = this.iFn.ckv().aCo();
                    if (postData3.aCo() != null && postData3.aCo().getGodUserData() != null) {
                        if (this.iKM != -1) {
                            aCo.setFansNum(this.iKM);
                            postData3.aCo().setFansNum(this.iKM);
                        }
                        if (this.iKN != -1) {
                            aCo.getGodUserData().setIsLike(this.iKN == 1);
                            postData3.aCo().getGodUserData().setIsLike(this.iKN == 1);
                            aCo.getGodUserData().setIsFromNetWork(false);
                            postData3.aCo().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.iFn.iBO = -1;
                this.iFn.iBN = -1;
            }
            if (this.iKJ != null) {
                this.iKJ.a(true, getErrorCode(), i, i4, this.iFn, this.mErrorString, 1);
            }
        }
        if (this.iFn != null && this.iFn.ckv() != null && this.iFn.getForum() != null && !this.iFn.ckT()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.grR.getPageContext();
            historyMessage.threadId = getPbData().ckv().getId();
            if (this.mIsShareThread && getPbData().ckv().cTR != null) {
                historyMessage.threadName = getPbData().ckv().cTR.showText;
            } else {
                historyMessage.threadName = getPbData().ckv().getTitle();
            }
            if (this.mIsShareThread && !cls()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = cnA();
            historyMessage.threadType = getPbData().ckv().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        String aL;
        if (arrayList != null && eVar.ckx() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.ckx(), 0);
            if (postData != null && (aL = aL(arrayList)) != null && aL.equals(postData.getId())) {
                eVar.ckx().remove(postData);
            }
            this.iFn.iCC = arrayList.size();
            arrayList.addAll(eVar.ckx());
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
            eVar.FK(this.iFn.ckM());
            this.iFn = eVar;
            yS(eVar.getPage().aBi());
        }
    }

    public boolean cnP() {
        if (this.iKi == null || this.iKk == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return yT(4);
        }
        return yT(6);
    }

    public boolean pV(boolean z) {
        if (this.iKi == null || this.iFn == null) {
            return false;
        }
        if (z || this.iFn.getPage().aBk() != 0) {
            return yT(1);
        }
        return false;
    }

    public boolean pW(boolean z) {
        if (this.iKi == null || this.iFn == null) {
            return false;
        }
        if ((z || this.iFn.getPage().aBl() != 0) && this.iFn.ckx() != null && this.iFn.ckx().size() >= 1) {
            return yT(2);
        }
        return false;
    }

    public boolean FV(String str) {
        this.iKn = !this.iKn;
        this.iKk = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").X("obj_source", 0));
        if (yT(6)) {
            return true;
        }
        this.iKn = this.iKn ? false : true;
        return false;
    }

    public boolean v(boolean z, String str) {
        if (this.iKn == z) {
            return false;
        }
        this.iKn = z;
        this.iKk = str;
        if (this.mSortType == 2) {
            this.iKk = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").X("obj_source", 1));
        }
        if (yT(6)) {
            return true;
        }
        this.iKn = z ? false : true;
        return false;
    }

    public boolean yW(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.iKo = this.iKp;
        this.iKq = this.mSortType;
        this.mSortType = i;
        this.iKp = !this.iKp;
        if (i == 2 && this.isFromMark) {
            this.iKk = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.iKp = this.iKp ? false : true;
            this.mSortType = this.iKq;
            return false;
        }
        return true;
    }

    public boolean cnQ() {
        return cop();
    }

    public int cnR() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.iFn == null || this.iFn.getForum() == null || this.iFn.ckv() == null) ? false : true;
    }

    public boolean ayL() {
        if (this.iFn == null) {
            return false;
        }
        return this.iFn.ayL();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData vj(String str) {
        if (this.iFn == null || this.iFn.ckv() == null || this.iFn.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.iFn.ckv().aDG()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.iFn.getForum().getId());
            writeData.setForumName(this.iFn.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.iLj);
        writeData.setThreadId(this.iKi);
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
        if (this.iFn == null) {
            return null;
        }
        ArrayList<PostData> ckx = this.iFn.ckx();
        if (com.baidu.tbadk.core.util.v.isEmpty(ckx)) {
            return null;
        }
        if (ckx.size() > 0 && i >= ckx.size()) {
            i = ckx.size() - 1;
        }
        return l(ckx.get(i));
    }

    public MarkData cnS() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iKi);
        markData.setPostId(this.iFn.ayK());
        markData.setTime(date.getTime());
        markData.setHostMode(this.iKn);
        markData.setSequence(Boolean.valueOf(cop()));
        markData.setId(this.iKi);
        return markData;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iKi);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.iKn);
        markData.setSequence(Boolean.valueOf(cop()));
        markData.setId(this.iKi);
        markData.setFloor(postData.cLb());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void cnT() {
        i.cmi().ar(cnU(), this.isFromMark);
    }

    private String cnU() {
        String cnV = (this.iKi == null || this.iKi.equals("0")) ? cnV() : this.iKi;
        if (this.iKn) {
            cnV = cnV + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            cnV = cnV + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return cnV + TbadkCoreApplication.getCurrentAccount();
        }
        return cnV;
    }

    private String cnV() {
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
        if (this.iFn != null) {
            this.iFn.fm(z);
        }
    }

    public boolean cnW() {
        return this.iKO;
    }

    public void a(a aVar) {
        this.iKJ = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aOP() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aOO() {
        return cnL();
    }

    public boolean FW(String str) {
        if (getPbData() == null || getPbData().ckv() == null || getPbData().ckv().aCo() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().ckv().aCo().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int cnX() {
        return this.mRequestType;
    }

    public void cnY() {
        if ("personalize_page".equals(this.mStType)) {
            this.iKU = System.currentTimeMillis() / 1000;
        }
    }

    public void cnZ() {
        if ("personalize_page".equals(this.mStType) && this.iFn != null && this.iKU != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").cy("fid", this.iFn.getForumId()).cy("tid", this.iKi).cy("obj_duration", String.valueOf(currentTimeMillis - this.iKU)).cy(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.iKU = 0L;
        }
    }

    public boolean coa() {
        return this.iKX;
    }

    public int getErrorNo() {
        return this.iKZ;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public n cob() {
        return this.iLb;
    }

    public x coc() {
        return this.iLc;
    }

    public CheckRealNameModel cod() {
        return this.iLe;
    }

    public AddExperiencedModel coe() {
        return this.iLf;
    }

    public String cof() {
        return this.iKT;
    }

    public void FX(String str) {
        this.iKT = str;
    }

    public boolean cog() {
        return this.iKY;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.iFn != null && this.iFn.ckx() != null && this.iFn.ckx().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.iFn.ckx().size();
                for (int i = 0; i < size; i++) {
                    if (this.iFn.ckx().get(i) != null && this.iFn.ckx().get(i).aCo() != null && currentAccount.equals(this.iFn.ckx().get(i).aCo().getUserId()) && this.iFn.ckx().get(i).aCo().getPendantData() != null) {
                        this.iFn.ckx().get(i).aCo().getPendantData().sB(mVar.aAG());
                        this.iFn.ckx().get(i).aCo().getPendantData().bI(mVar.aNZ());
                    }
                }
            }
        }
    }

    public String coh() {
        return this.iLd;
    }

    public int coi() {
        return this.iLj;
    }

    public void yY(int i) {
        this.iLj = i;
    }

    public void FY(String str) {
        if ((!this.iKn || FW(TbadkCoreApplication.getCurrentAccount())) && this.iFn.ckx() != null) {
            this.iFn.getPage().jE(1);
            if (this.iFn.getPage().aBk() == 0) {
                this.iFn.getPage().jE(1);
            }
            this.iLk = str;
            yT(8);
        }
    }

    private void yZ(int i) {
        if (i != 8) {
            this.iLk = "";
            if (this.iLl != null) {
                if (i == 1 && this.iFn != null && this.iFn.ckT()) {
                    if (this.iLm != null) {
                        getPbData().ckx().remove(this.iLm);
                    }
                } else if (i == 1 && !this.iKp && !com.baidu.tbadk.core.util.v.isEmpty(getPbData().ckx())) {
                    getPbData().ckx().remove(this.iLl);
                    if (this.iLm != null) {
                        getPbData().ckx().remove(this.iLm);
                    }
                    getPbData().ckx().add(0, this.iLl);
                } else {
                    getPbData().ckx().remove(this.iLl);
                    if (this.iLm != null) {
                        getPbData().ckx().remove(this.iLm);
                    }
                }
            }
            this.iLm = null;
        }
    }

    public void coj() {
        if (this.iFn != null && !com.baidu.tbadk.core.util.v.isEmpty(this.iFn.ckx())) {
            if (this.iLm != null) {
                this.iFn.ckx().remove(this.iLm);
                this.iLm = null;
            }
            if (this.iLl != null) {
                this.iFn.ckx().remove(this.iLl);
                this.iLl = null;
            }
        }
    }

    public void cr(int i, int i2) {
        this.iLn = i;
        this.iLo = i2;
    }

    public PostData cok() {
        return this.iLl;
    }

    public PostData col() {
        return this.iLm;
    }

    public int com() {
        return this.iLn;
    }

    public int con() {
        return this.iLo;
    }

    public String coo() {
        return this.iLq;
    }

    public void FZ(String str) {
        this.iLq = str;
    }

    private boolean cop() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean coq() {
        return this.iLj == 13 || this.iLj == 12;
    }

    public String cor() {
        return this.iLt;
    }

    public String cos() {
        return this.iLu;
    }

    public String cot() {
        return this.iLv;
    }

    public String cou() {
        return this.iLw;
    }

    public Rect cov() {
        Rect rect = this.iLp;
        this.iLp = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int cow() {
        int i;
        int i2 = 0;
        if (getPbData().ckx() == null) {
            return 0;
        }
        ArrayList<PostData> ckx = getPbData().ckx();
        int size = ckx.size() - 1;
        while (size >= 0) {
            PostData postData = ckx.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
                if (postData.getType() != AdvertAppInfo.cML) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return ckx.size();
    }
}
