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
    private boolean cUp;
    private com.baidu.tieba.tbadkCore.d.b fWo;
    private long gGm;
    private BaseFragmentActivity grC;
    private boolean hQn;
    protected com.baidu.tieba.pb.data.e iEZ;
    protected String iJU;
    private String iJV;
    private String iJW;
    private String iJX;
    private boolean iJY;
    private boolean iJZ;
    private boolean iKA;
    private boolean iKB;
    private boolean iKC;
    private boolean iKD;
    private boolean iKE;
    private String iKF;
    private long iKG;
    private boolean iKH;
    private int iKI;
    private boolean iKJ;
    private boolean iKK;
    private int iKL;
    private final v iKM;
    private final n iKN;
    private final x iKO;
    private String iKP;
    private final CheckRealNameModel iKQ;
    private final AddExperiencedModel iKR;
    private SuggestEmotionModel iKS;
    private GetSugMatchWordsModel iKT;
    private boolean iKU;
    private int iKV;
    private String iKW;
    private PostData iKX;
    private PostData iKY;
    private int iKZ;
    private boolean iKa;
    private boolean iKb;
    private int iKc;
    private boolean iKd;
    private int iKe;
    private long iKf;
    private int iKg;
    private int iKh;
    private int iKi;
    private int iKj;
    private boolean iKk;
    private boolean iKl;
    private boolean iKm;
    private long iKn;
    private boolean iKo;
    private String iKp;
    private int iKq;
    private boolean iKr;
    private boolean iKs;
    private boolean iKt;
    private boolean iKu;
    private a iKv;
    private String iKw;
    private String iKx;
    private int iKy;
    private int iKz;
    private int iLa;
    private Rect iLb;
    private String iLc;
    private com.baidu.tieba.tbadkCore.data.m iLd;
    private boolean iLe;
    private String iLf;
    private String iLg;
    private String iLh;
    private String iLi;
    private f.a iLj;
    private CustomMessageListener iLk;
    private com.baidu.adp.framework.listener.a iLl;
    private PraiseData iLm;
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
    private static final int iJT = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.iJU = null;
        this.iJV = null;
        this.iJW = null;
        this.mForumId = null;
        this.iJX = null;
        this.iJY = false;
        this.iJZ = false;
        this.iKa = true;
        this.iKb = true;
        this.mSortType = 0;
        this.iKc = 0;
        this.iKd = false;
        this.mIsGood = 0;
        this.iKe = 0;
        this.iKf = 0L;
        this.iKg = 1;
        this.iKh = 1;
        this.iKi = 1;
        this.iKj = 1;
        this.isAd = false;
        this.hQn = false;
        this.cUp = false;
        this.iKk = false;
        this.isFromMark = false;
        this.iKl = false;
        this.iKm = false;
        this.iKn = 0L;
        this.iKo = false;
        this.iKp = null;
        this.iEZ = null;
        this.isLoading = false;
        this.iKr = false;
        this.iKs = false;
        this.iKt = false;
        this.iKu = false;
        this.mLocate = null;
        this.mContext = null;
        this.iKv = null;
        this.opType = null;
        this.opUrl = null;
        this.iKw = null;
        this.iKx = null;
        this.iKy = -1;
        this.iKz = -1;
        this.fWo = null;
        this.iKB = false;
        this.iKC = false;
        this.postID = null;
        this.iKF = null;
        this.iKG = 0L;
        this.iKH = false;
        this.iKI = -1;
        this.iKK = false;
        this.iKU = false;
        this.iKV = 0;
        this.mTabIndex = 0;
        this.iLe = false;
        this.iLk = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.iLl = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.grC.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.iKB || !PbModel.this.iKC) {
                        if (!PbModel.this.iKB) {
                            PbModel.this.iKB = true;
                        } else {
                            PbModel.this.iKC = true;
                        }
                        if (PbModel.this.iKv != null) {
                            PbModel.this.iKv.a(PbModel.this.cnr(), z, responsedMessage, PbModel.this.iKD, System.currentTimeMillis() - PbModel.this.gGm);
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
                    if (PbModel.this.iEZ != null && PbModel.this.iEZ.ckr() != null && PbModel.this.iEZ.ckr().getForumId() != null && PbModel.this.iEZ.ckr().getForumId().equals(valueOf)) {
                        PbModel.this.iEZ.ckr().setIsLike(false);
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
                    if (PbModel.this.iEZ != null && PbModel.this.iEZ.ckr() != null && PbModel.this.iEZ.ckr().getForumId() != null && PbModel.this.iEZ.ckr().getForumId().equals(valueOf)) {
                        PbModel.this.iEZ.ckr().setIsLike(true);
                    }
                }
            }
        };
        this.iLm = null;
        registerListener(this.iLl);
        registerListener(this.iLk);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.iEZ = new com.baidu.tieba.pb.data.e();
        this.iEZ.yA(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.grC = baseFragmentActivity;
        this.iKM = new v(this, this.grC);
        this.iKN = new n(this, this.grC);
        this.iKO = new x(this, this.grC);
        this.iKQ = new CheckRealNameModel(this.grC.getPageContext());
        this.iKS = new SuggestEmotionModel();
        this.iKR = new AddExperiencedModel(this.grC.getPageContext());
        this.iLj = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void n(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIi) instanceof String) {
                        PbModel.this.iJU = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIi);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIj) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIj);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIk) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIk);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIl) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.cIl), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.cIm) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIm);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, String str) {
        this.iKE = true;
        if (eVar != null && eVar.iBD == null) {
            n(eVar);
            j(eVar);
            if (eVar.cks() != null) {
                eVar.cks().jH(0);
            }
            if (this.iKv != null && eVar != null) {
                this.iKv.a(true, 0, i, 0, eVar, str, 0);
            }
        }
    }

    protected int cnr() {
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
            this.iJU = intent.getStringExtra("thread_id");
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            Uri uri = (Uri) intent.getParcelableExtra("key_uri");
            if (com.baidu.tbadk.BdToken.f.n(uri)) {
                com.baidu.tbadk.BdToken.f.axN().c(uri, this.iLj);
            } else if (StringUtils.isNull(this.iJU)) {
                this.iKM.a(intent, this.iLj);
                if (uri != null) {
                    if (StringUtils.isNull(this.iJU)) {
                        this.iJU = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.aq.isEmpty(this.iJU)) {
                this.iJU = "0";
            }
            this.iKV = intent.getIntExtra("key_start_from", 0);
            if (this.iKV == 0) {
                this.iKV = this.iKM.Yv;
            }
            this.iJW = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.iJV = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.iJY = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.iJZ = intent.getBooleanExtra("host_only", false);
            this.iKb = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.aRJ().aIW() ? 2 : 0);
            if (this.mSortType == 2) {
                this.iJW = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.iKe = intent.getIntExtra("is_top", 0);
            this.iKf = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.iKl = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.iKm = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.hQn = intent.getBooleanExtra("is_sub_pb", false);
            this.iKo = intent.getBooleanExtra("is_pv", false);
            this.iKn = intent.getLongExtra("msg_id", 0L);
            this.iKp = intent.getStringExtra("from_forum_name");
            this.iKx = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.iKw = intent.getStringExtra("op_stat");
            this.iKr = intent.getBooleanExtra("is_from_thread_config", false);
            this.iKs = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.iKt = intent.getBooleanExtra("is_from_my_god_config", false);
            this.iKz = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.iKy = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.cUp = intent.getBooleanExtra("from_frs", false);
            this.iKk = intent.getBooleanExtra("from_maintab", false);
            this.iKK = intent.getBooleanExtra("from_smart_frs", false);
            this.iKu = intent.getBooleanExtra("from_hottopic", false);
            this.iKP = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.iJX = intent.getStringExtra("high_light_post_id");
            this.iLe = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.iKA = intent.getIntExtra("request_code", -1) == 18003;
            this.iLf = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.iLg = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.iLh = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.iLi = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean cns() {
        return this.iLe && com.baidu.tieba.frs.i.bDC() != null && com.baidu.tieba.frs.i.bDC().equals(this.iJU) && com.baidu.tieba.frs.i.bDB() != null;
    }

    public com.baidu.tieba.pb.data.e aG(bj bjVar) {
        com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
        eVar.yA(3);
        if (bjVar == null) {
            return null;
        }
        eVar.aE(bjVar);
        if (bjVar.aDV() != null) {
            eVar.e(bjVar.aDV());
            ForumData forum = eVar.getForum();
            forum.setId(bjVar.aDV().getForumId());
            forum.setName(bjVar.aDV().getForumName());
            forum.setUser_level(bjVar.aDV().aBD());
            forum.setImage_url(bjVar.aDV().getAvatar());
            forum.setPost_num(bjVar.aDV().postNum);
            forum.setMember_num(bjVar.aDV().memberNum);
        } else {
            ForumData forum2 = eVar.getForum();
            forum2.setId(String.valueOf(bjVar.getFid()));
            forum2.setName(bjVar.aCr());
        }
        PostData postData = new PostData();
        postData.Cw(1);
        postData.setTime(bjVar.getCreateTime());
        postData.a(bjVar.aCm());
        MetaData aCm = bjVar.aCm();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(aCm.getUserId(), aCm);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bjVar.aCc(), false));
        eVar.d(postData);
        eVar.cku().add(postData);
        eVar.a(new com.baidu.tieba.pb.data.k(bjVar, null));
        eVar.iBI = true;
        eVar.setIsNewUrl(1);
        return eVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.iKV = bundle.getInt("key_start_from", 0);
        this.iJU = bundle.getString("thread_id");
        this.iJW = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.iJV = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.iJY = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.iJZ = bundle.getBoolean("host_only", false);
        this.iKb = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.iKe = bundle.getInt("is_top", 0);
        this.iKf = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.iKm = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.hQn = bundle.getBoolean("is_sub_pb", false);
        this.iKo = bundle.getBoolean("is_pv", false);
        this.iKn = bundle.getLong("msg_id", 0L);
        this.iKp = bundle.getString("from_forum_name");
        this.iKx = bundle.getString("extra_pb_cache_key");
        this.iKr = bundle.getBoolean("is_from_thread_config", false);
        this.iKs = bundle.getBoolean("is_from_interview_live_config", false);
        this.iKt = bundle.getBoolean("is_from_my_god_config", false);
        this.iKz = bundle.getInt("extra_pb_is_attention_key", -1);
        this.iKy = bundle.getInt("extra_pb_funs_count_key", -1);
        this.cUp = bundle.getBoolean("from_frs", false);
        this.iKk = bundle.getBoolean("from_maintab", false);
        this.iKK = bundle.getBoolean("from_smart_frs", false);
        this.iKu = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.iJX = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.iKA = bundle.getInt("request_code", -1) == 18003;
        this.iLf = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.iLg = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.iLh = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.iLi = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void au(Bundle bundle) {
        bundle.putString("thread_id", this.iJU);
        bundle.putString("post_id", this.iJW);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.iKV);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.iJY);
        bundle.putBoolean("host_only", this.iJZ);
        bundle.putBoolean("squence", this.iKb);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.iKe);
        bundle.putLong("thread_time", this.iKf);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.iKm);
        bundle.putBoolean("is_sub_pb", this.hQn);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.iKo);
        bundle.putLong("msg_id", this.iKn);
        bundle.putString("extra_pb_cache_key", this.iKx);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.iKr);
        bundle.putBoolean("is_from_interview_live_config", this.iKs);
        bundle.putBoolean("is_from_my_god_config", this.iKt);
        bundle.putInt("extra_pb_is_attention_key", this.iKz);
        bundle.putInt("extra_pb_funs_count_key", this.iKy);
        bundle.putBoolean("from_frs", this.cUp);
        bundle.putBoolean("from_maintab", this.iKk);
        bundle.putBoolean("from_smart_frs", this.iKK);
        bundle.putBoolean("from_hottopic", this.iKu);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.iJX);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.iLf);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.iLg);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.iLh);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.iLi);
    }

    public String cnt() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.iJU);
        if (!this.iKm) {
            sb.append(this.iJW);
        }
        sb.append(this.iJZ);
        sb.append(this.iKb);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.iKe);
        sb.append(this.iKf);
        sb.append(this.cUp);
        sb.append(this.iKk);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.hQn);
        sb.append(this.iKo);
        sb.append(this.iKn);
        sb.append(this.iKp);
        sb.append(this.mThreadType);
        sb.append(this.iKr);
        sb.append(this.iKs);
        sb.append(this.iKt);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.iKx != null) {
            sb.append(this.iKx);
        }
        return sb.toString();
    }

    public String clq() {
        return this.iKp;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cnu() {
        return this.iJW;
    }

    public String cnv() {
        return this.iJX;
    }

    public String cnw() {
        return this.iJU;
    }

    public boolean getHostMode() {
        return this.iJZ;
    }

    public boolean cnx() {
        return com();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean cny() {
        return this.cUp;
    }

    public boolean cnz() {
        return this.iKd;
    }

    public boolean cnA() {
        return this.iKk;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean cnB() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bxO() {
        return this.iKe;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void yQ(int i) {
        this.iKe = i;
    }

    public boolean cnC() {
        return this.hQn;
    }

    public boolean cnD() {
        if (this.iEZ == null) {
            return false;
        }
        return this.iEZ.isValid();
    }

    public String aCv() {
        if (this.iEZ == null || !this.iEZ.ayJ()) {
            return null;
        }
        return this.iEZ.ayI();
    }

    public boolean yR(int i) {
        this.iKg = i;
        if (this.iKg > this.iEZ.getPage().aBd()) {
            this.iKg = this.iEZ.getPage().aBd();
        }
        if (this.iKg < 1) {
            this.iKg = 1;
        }
        if (this.iJU == null) {
            return false;
        }
        return yT(5);
    }

    public void yS(int i) {
        this.iKg = i;
        this.iKh = i;
        this.iKi = i;
    }

    public void b(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar == null) {
            yS(1);
            return;
        }
        if (this.iKh < apVar.aBg()) {
            this.iKh = apVar.aBg();
        }
        if (this.iKi > apVar.aBg()) {
            this.iKi = apVar.aBg();
        }
        this.iKj = apVar.aBd();
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        return this.iEZ;
    }

    public BaijiahaoData cnE() {
        if (this.iEZ == null || this.iEZ.cks() == null) {
            return null;
        }
        return this.iEZ.cks().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.e cnF() {
        if (this.iEZ == null) {
            return this.iEZ;
        }
        if (!cnG() && this.iLd != null) {
            this.iEZ.b(this.iLd);
        }
        return this.iEZ;
    }

    private boolean cnG() {
        return (this.iEZ.ckH() == null || this.iEZ.ckH().cKM() == null || this.iEZ.ckH().cKM().goods != null || this.iEZ.ckH().cKM().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.ap getPageData() {
        if (this.iEZ == null) {
            return null;
        }
        return this.iEZ.getPage();
    }

    public boolean cnH() {
        if (com() && this.iEZ.getPage().aBi() == 0) {
            pV(true);
            return true;
        }
        return false;
    }

    public void h(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.iJU = eVar.getThreadId();
            if (eVar.cks() != null && eVar.cks().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = eVar.cks().getBaijiahaoData();
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
            this.iJW = null;
            this.iJZ = false;
            this.iKb = true;
            LoadData();
        }
    }

    public void FO(String str) {
        if (!StringUtils.isNull(str)) {
            this.iJU = str;
            this.iJW = null;
            this.iJZ = false;
            this.iKb = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.iJU == null) {
            return false;
        }
        cancelLoadData();
        if (this.fWo == null) {
            this.fWo = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.fWo.start();
        }
        boolean yT = yT(3);
        if (this.opType != null) {
            this.opType = null;
            this.iKw = null;
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
        if (this.iKS != null) {
            this.iKS.cancelLoadData();
        }
        if (this.iKT != null) {
            this.iKT.cancelLoadData();
        }
        byR();
    }

    private void byR() {
        if (this.fWo != null) {
            this.fWo.destory();
            this.fWo = null;
        }
    }

    public boolean cnI() {
        return (this.iJW == null || this.iJW.equals("0") || this.iJW.length() == 0) ? LoadData() : cnM();
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
                this.iKS.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.iKS.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.iKT == null) {
                this.iKT = new GetSugMatchWordsModel(this.grC.getPageContext());
            }
            this.iKT.b(aVar);
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
        final com.baidu.tieba.pb.data.e pbData = ah.coO().getPbData();
        if (pbData != null && pbData.cks() != null) {
            pbData.cks().jH(0);
            this.iKb = ah.coO().cnx();
            this.iJZ = ah.coO().coT();
            this.iKd = ah.coO().coU();
            this.iKX = ah.coO().coS();
            this.iKY = ah.coO().coR();
            this.iKZ = ah.coO().coQ();
            this.iLb = ah.coO().coV();
            this.mTabIndex = ah.coO().getTabIndex();
            this.iKU = this.iJZ;
            if (this.iJZ || this.isFromMark) {
                this.iKA = false;
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
        if (i == 4 && !this.iKE) {
            a(cnR(), true, this.iJW, 3);
        }
        if (i == 3 && !this.iKE) {
            if (this.isFromMark) {
                a(cnR(), true, this.iJW, 3);
            } else {
                a(cnR(), false, this.iJW, 3);
            }
        }
        this.iKE = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.iLd == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.dvM);
        if (this.iJZ || this.isFromMark) {
            this.iKA = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.iJU == null || this.iJU.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.iJU, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.ar.aGB().aGC() ? 2 : 1));
        if (!this.iKb) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.iJZ) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.iKo) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.iKn));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.iKA) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.iKw, 0));
            pbPageRequestMessage.setOpMessageID(this.iKn);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> cku = this.iEZ.cku();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iKi - 1));
                        if (this.iKi - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.iKl) {
                                if (cku != null && cku.size() > 0) {
                                    size = cku.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = cku.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.iJW = postData.getId();
                                            if (StringUtils.isNull(this.iJW)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.iKh + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.iJW == null && this.iJW.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iJW, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iKh + 1));
                        if (this.iKh >= this.iKj) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (cku != null) {
                                size = cku.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.iJW == null) {
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
                if (cku != null) {
                }
                if (this.iJW == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (cku != null && cku.size() > 0 && cku.get(0) != null) {
                    this.iJW = cku.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (com()) {
                        if (this.iKi - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.iKi - 1));
                        }
                    } else if (this.iKh < this.iKj) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iKh + 1));
                    }
                }
                if (this.iJW != null && this.iJW.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iJW, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.iJZ) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (com()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.iKj > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iKj));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iJW, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.iKg));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.iKU && !this.iJZ) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iJW, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.iJZ) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.iKI);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iKW, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.iKU = this.iJZ;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cnR());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.iKV));
        pbPageRequestMessage.setIsSubPostDataReverse(this.iKH);
        pbPageRequestMessage.setFromSmartFrs(this.iKK ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.iJY);
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.iKj) {
                    i4 = -1;
                } else {
                    i4 = cot();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = cot();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.iJU);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean clp() {
        switch (cof()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().cks() == null || !getPbData().cks().aDE();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(clq()) && com.baidu.tieba.recapp.r.cCt().cCn() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cCt().cCn().ax(clq(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cCt().cCn().ay(clq(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(clq()) && com.baidu.tieba.recapp.r.cCt().cCn() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cCt().cCn().ay(clq(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cCt().cCn().ax(clq(), true));
        }
    }

    protected void yU(int i) {
        boolean z = false;
        yZ(i);
        ArrayList<PostData> cku = this.iEZ.cku();
        this.iKD = false;
        if (i == 1) {
            boolean z2 = false;
            while (cku.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cku.remove(0);
                z2 = true;
            }
            if (z2) {
                this.iEZ.getPage().jF(1);
                if (this.iKv != null) {
                    this.iKv.e(this.iEZ);
                }
            }
            this.gGm = System.currentTimeMillis();
            this.iKD = true;
        } else if (i == 2) {
            while (cku.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cku.remove(cku.size() - 1);
                z = true;
            }
            if (z) {
                this.iEZ.getPage().jE(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.e eVar2 = z ? null : eVar;
        this.iKL = i2;
        this.isLoading = false;
        if (eVar2 != null) {
            j(eVar2);
        }
        i(eVar2);
        if (this.iLd != null && this.iLd.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(eVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void i(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckH() != null && eVar.ckH().cKM() != null && eVar.ckH().cKM().goods != null && eVar.ckH().isValidate() && eVar.ckH().cKM().goods.goods_style != 1001) {
            this.iLd = eVar.ckH();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m cnJ() {
        return this.iLd;
    }

    public void cnK() {
        this.iLd = null;
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
            if (this.iKt || this.iKr || this.iKs) {
                eVar = l(eVar);
            }
            k(eVar);
        }
    }

    protected void k(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            String m = m(eVar);
            for (int i = 0; i < eVar.cku().size(); i++) {
                PostData postData = eVar.cku().get(i);
                for (int i2 = 0; i2 < postData.cKV().size(); i2++) {
                    postData.cKV().get(i2).a(this.grC.getPageContext(), m.equals(postData.cKV().get(i2).aCm().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n ckD = eVar.ckD();
            if (ckD != null && !com.baidu.tbadk.core.util.v.isEmpty(ckD.iCQ)) {
                for (PostData postData2 : ckD.iCQ) {
                    for (int i3 = 0; i3 < postData2.cKV().size(); i3++) {
                        postData2.cKV().get(i3).a(this.grC.getPageContext(), m.equals(postData2.cKV().get(i3).aCm().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i) {
        if (eVar != null) {
            String m = m(eVar);
            com.baidu.tieba.pb.data.n ckD = eVar.ckD();
            if (ckD != null && !com.baidu.tbadk.core.util.v.isEmpty(ckD.iCQ)) {
                for (PostData postData : ckD.iCQ.subList(i, ckD.iCQ.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cKV().size()) {
                            postData.cKV().get(i3).a(this.grC.getPageContext(), m.equals(postData.cKV().get(i3).aCm().getUserId()));
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
        bj cks = eVar.cks();
        cks.jM(this.mIsGood);
        cks.jL(this.iKe);
        if (this.iKf > 0) {
            cks.bv(this.iKf);
            return eVar;
        }
        return eVar;
    }

    protected String m(com.baidu.tieba.pb.data.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.cks() != null && eVar.cks().aCm() != null) {
            str = eVar.cks().aCm().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData cnL() {
        if (this.iEZ == null || this.iEZ.cks() == null || this.iEZ.cks().aCm() == null) {
            return null;
        }
        return this.iEZ.cks().aCm();
    }

    protected void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int size;
        int i4;
        int i5;
        boolean z4 = !z;
        this.iKJ = z3;
        this.iKq = i;
        if (this.fWo != null && !z3) {
            this.fWo.a(z2, z4, i2, str, i3, j, j2);
            this.fWo = null;
        }
        if (this.iEZ != null) {
            this.iEZ.iCp = z3;
            this.iEZ.Df = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(clq()) && com.baidu.tieba.recapp.r.cCt().cCn() != null) {
            com.baidu.tieba.recapp.r.cCt().cCn().g(clq(), yV(cnU()), true);
        }
        if (eVar == null || (this.iKg == 1 && i == 5 && eVar.cku() != null && eVar.cku().size() < 1)) {
            if (this.iKv != null) {
                this.iKb = this.iKa;
                if (i2 != 350006) {
                    this.mSortType = this.iKc;
                }
                this.iKv.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.iKa = this.iKb;
            if (i != 8) {
                this.iKc = this.mSortType;
                this.mSortType = eVar.iBC;
            }
            if (eVar.iBB != null && eVar.iBB.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.grC.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                eVar.iBB = new ArrayList();
                eVar.iBB.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.grC.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                eVar.iBB.add(builder2.build(false));
                this.mSortType = this.iKc;
                eVar.iBC = this.mSortType;
            }
            this.iKo = false;
            if (eVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(eVar.getPage());
            }
            this.iKj = this.iKj < 1 ? 1 : this.iKj;
            ArrayList<PostData> cku = this.iEZ.cku();
            switch (i) {
                case 1:
                    this.iEZ.a(eVar.getPage(), 1);
                    d(eVar, cku);
                    i4 = 0;
                    break;
                case 2:
                    if (eVar.cku() == null) {
                        i5 = 0;
                    } else {
                        int size2 = eVar.cku().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(cku, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cku(), com.baidu.tbadk.core.util.v.getCount(eVar.cku()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            eVar.cku().remove(postData2);
                            i5 = size2 - 1;
                        }
                        cku.addAll(0, eVar.cku());
                    }
                    this.iEZ.a(eVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && eVar.getPage() != null) {
                        eVar.getPage().jC(eVar.getPage().aBd());
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
                    if (eVar != null && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cku()) && this.iEZ != null && (!this.iJZ || m(eVar).equals(eVar.cku().get(0).aCm().getUserId()))) {
                        if (this.iEZ.getPage().aBi() == 0) {
                            this.iEZ.getPage().jE(1);
                        }
                        cog();
                        this.iKX = eVar.cku().get(0);
                        if (com() || this.iEZ.ckQ()) {
                            if (this.iEZ.cku().size() - this.iKZ >= 3) {
                                this.iKY = new PostData();
                                this.iKY.kgT = true;
                                this.iKY.setPostType(53);
                                this.iEZ.cku().add(this.iKY);
                            }
                            this.iEZ.cku().add(this.iKX);
                            size = this.iEZ.cku().size() - 1;
                        } else {
                            if (this.iKZ - this.iLa >= 3) {
                                this.iKY = new PostData();
                                this.iKY.kgT = false;
                                this.iKY.setPostType(53);
                                this.iEZ.cku().add(0, this.iKY);
                            }
                            this.iEZ.cku().add(0, this.iKX);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.isTaday(com.baidu.tbadk.core.sharedPref.b.aFB().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.iKX.khg = this.iEZ.ckO();
                            com.baidu.tbadk.core.sharedPref.b.aFB().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        }
                        i4 = size;
                        break;
                    }
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.iEZ != null && this.iEZ.cks() != null) {
                PraiseData aBX = this.iEZ.cks().aBX();
                if (this.iLm != null && !aBX.isPriaseDataValid()) {
                    this.iEZ.cks().a(this.iLm);
                } else {
                    this.iLm = this.iEZ.cks().aBX();
                    this.iLm.setPostId(this.iEZ.cks().aCC());
                }
                if (eVar.getPage() != null && eVar.getPage().aBg() == 1 && eVar.cks() != null && eVar.cks().aCx() != null && eVar.cks().aCx().size() > 0) {
                    this.iEZ.cks().x(eVar.cks().aCx());
                }
                this.iEZ.cks().jJ(eVar.cks().aCd());
                this.iEZ.cks().jG(eVar.cks().getAnchorLevel());
                this.iEZ.cks().jH(eVar.cks().aBT());
                if (this.mThreadType == 33) {
                    this.iEZ.cks().aCm().setHadConcerned(eVar.cks().aCm().hadConcerned());
                }
                if (eVar != null && eVar.cks() != null) {
                    this.iEZ.cks().jO(eVar.cks().aCB());
                }
            }
            if (this.iEZ != null && this.iEZ.getUserData() != null && eVar.getUserData() != null) {
                this.iEZ.getUserData().setBimg_end_time(eVar.getUserData().getBimg_end_time());
                this.iEZ.getUserData().setBimg_url(eVar.getUserData().getBimg_url());
            }
            if (eVar.getPage() != null && eVar.getPage().aBg() == 1 && eVar.ckC() != null) {
                this.iEZ.e(eVar.ckC());
            }
            if (this.iKJ) {
                if (this.iEZ.cks() != null && this.iEZ.cks().aCm() != null && this.iEZ.cku() != null && com.baidu.tbadk.core.util.v.getItem(this.iEZ.cku(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(this.iEZ.cku(), 0);
                    MetaData aCm = this.iEZ.cks().aCm();
                    if (postData3.aCm() != null && postData3.aCm().getGodUserData() != null) {
                        if (this.iKy != -1) {
                            aCm.setFansNum(this.iKy);
                            postData3.aCm().setFansNum(this.iKy);
                        }
                        if (this.iKz != -1) {
                            aCm.getGodUserData().setIsLike(this.iKz == 1);
                            postData3.aCm().getGodUserData().setIsLike(this.iKz == 1);
                            aCm.getGodUserData().setIsFromNetWork(false);
                            postData3.aCm().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.iEZ.iBA = -1;
                this.iEZ.iBz = -1;
            }
            if (this.iKv != null) {
                this.iKv.a(true, getErrorCode(), i, i4, this.iEZ, this.mErrorString, 1);
            }
        }
        if (this.iEZ != null && this.iEZ.cks() != null && this.iEZ.getForum() != null && !this.iEZ.ckQ()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.grC.getPageContext();
            historyMessage.threadId = getPbData().cks().getId();
            if (this.mIsShareThread && getPbData().cks().cTP != null) {
                historyMessage.threadName = getPbData().cks().cTP.showText;
            } else {
                historyMessage.threadName = getPbData().cks().getTitle();
            }
            if (this.mIsShareThread && !clp()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = cnx();
            historyMessage.threadType = getPbData().cks().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        String aL;
        if (arrayList != null && eVar.cku() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cku(), 0);
            if (postData != null && (aL = aL(arrayList)) != null && aL.equals(postData.getId())) {
                eVar.cku().remove(postData);
            }
            this.iEZ.iCo = arrayList.size();
            arrayList.addAll(eVar.cku());
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
            eVar.FJ(this.iEZ.ckJ());
            this.iEZ = eVar;
            yS(eVar.getPage().aBg());
        }
    }

    public boolean cnM() {
        if (this.iJU == null || this.iJW == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return yT(4);
        }
        return yT(6);
    }

    public boolean pV(boolean z) {
        if (this.iJU == null || this.iEZ == null) {
            return false;
        }
        if (z || this.iEZ.getPage().aBi() != 0) {
            return yT(1);
        }
        return false;
    }

    public boolean pW(boolean z) {
        if (this.iJU == null || this.iEZ == null) {
            return false;
        }
        if ((z || this.iEZ.getPage().aBj() != 0) && this.iEZ.cku() != null && this.iEZ.cku().size() >= 1) {
            return yT(2);
        }
        return false;
    }

    public boolean FU(String str) {
        this.iJZ = !this.iJZ;
        this.iJW = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").X("obj_source", 0));
        if (yT(6)) {
            return true;
        }
        this.iJZ = this.iJZ ? false : true;
        return false;
    }

    public boolean v(boolean z, String str) {
        if (this.iJZ == z) {
            return false;
        }
        this.iJZ = z;
        this.iJW = str;
        if (this.mSortType == 2) {
            this.iJW = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").X("obj_source", 1));
        }
        if (yT(6)) {
            return true;
        }
        this.iJZ = z ? false : true;
        return false;
    }

    public boolean yW(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.iKa = this.iKb;
        this.iKc = this.mSortType;
        this.mSortType = i;
        this.iKb = !this.iKb;
        if (i == 2 && this.isFromMark) {
            this.iJW = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.iKb = this.iKb ? false : true;
            this.mSortType = this.iKc;
            return false;
        }
        return true;
    }

    public boolean cnN() {
        return com();
    }

    public int cnO() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.iEZ == null || this.iEZ.getForum() == null || this.iEZ.cks() == null) ? false : true;
    }

    public boolean ayJ() {
        if (this.iEZ == null) {
            return false;
        }
        return this.iEZ.ayJ();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData vi(String str) {
        if (this.iEZ == null || this.iEZ.cks() == null || this.iEZ.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.iEZ.cks().aDE()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.iEZ.getForum().getId());
            writeData.setForumName(this.iEZ.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.iKV);
        writeData.setThreadId(this.iJU);
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
        if (this.iEZ == null) {
            return null;
        }
        ArrayList<PostData> cku = this.iEZ.cku();
        if (com.baidu.tbadk.core.util.v.isEmpty(cku)) {
            return null;
        }
        if (cku.size() > 0 && i >= cku.size()) {
            i = cku.size() - 1;
        }
        return l(cku.get(i));
    }

    public MarkData cnP() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iJU);
        markData.setPostId(this.iEZ.ayI());
        markData.setTime(date.getTime());
        markData.setHostMode(this.iJZ);
        markData.setSequence(Boolean.valueOf(com()));
        markData.setId(this.iJU);
        return markData;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iJU);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.iJZ);
        markData.setSequence(Boolean.valueOf(com()));
        markData.setId(this.iJU);
        markData.setFloor(postData.cKY());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void cnQ() {
        i.cmf().ar(cnR(), this.isFromMark);
    }

    private String cnR() {
        String cnS = (this.iJU == null || this.iJU.equals("0")) ? cnS() : this.iJU;
        if (this.iJZ) {
            cnS = cnS + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            cnS = cnS + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return cnS + TbadkCoreApplication.getCurrentAccount();
        }
        return cnS;
    }

    private String cnS() {
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
        if (this.iEZ != null) {
            this.iEZ.fm(z);
        }
    }

    public boolean cnT() {
        return this.iKA;
    }

    public void a(a aVar) {
        this.iKv = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aOM() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aOL() {
        return cnI();
    }

    public boolean FV(String str) {
        if (getPbData() == null || getPbData().cks() == null || getPbData().cks().aCm() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().cks().aCm().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int cnU() {
        return this.mRequestType;
    }

    public void cnV() {
        if ("personalize_page".equals(this.mStType)) {
            this.iKG = System.currentTimeMillis() / 1000;
        }
    }

    public void cnW() {
        if ("personalize_page".equals(this.mStType) && this.iEZ != null && this.iKG != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").cy("fid", this.iEZ.getForumId()).cy("tid", this.iJU).cy("obj_duration", String.valueOf(currentTimeMillis - this.iKG)).cy(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.iKG = 0L;
        }
    }

    public boolean cnX() {
        return this.iKJ;
    }

    public int getErrorNo() {
        return this.iKL;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public n cnY() {
        return this.iKN;
    }

    public x cnZ() {
        return this.iKO;
    }

    public CheckRealNameModel coa() {
        return this.iKQ;
    }

    public AddExperiencedModel cob() {
        return this.iKR;
    }

    public String coc() {
        return this.iKF;
    }

    public void FW(String str) {
        this.iKF = str;
    }

    public boolean cod() {
        return this.iKK;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.iEZ != null && this.iEZ.cku() != null && this.iEZ.cku().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.iEZ.cku().size();
                for (int i = 0; i < size; i++) {
                    if (this.iEZ.cku().get(i) != null && this.iEZ.cku().get(i).aCm() != null && currentAccount.equals(this.iEZ.cku().get(i).aCm().getUserId()) && this.iEZ.cku().get(i).aCm().getPendantData() != null) {
                        this.iEZ.cku().get(i).aCm().getPendantData().sB(mVar.aAE());
                        this.iEZ.cku().get(i).aCm().getPendantData().bI(mVar.aNW());
                    }
                }
            }
        }
    }

    public String coe() {
        return this.iKP;
    }

    public int cof() {
        return this.iKV;
    }

    public void yY(int i) {
        this.iKV = i;
    }

    public void FX(String str) {
        if ((!this.iJZ || FV(TbadkCoreApplication.getCurrentAccount())) && this.iEZ.cku() != null) {
            this.iEZ.getPage().jE(1);
            if (this.iEZ.getPage().aBi() == 0) {
                this.iEZ.getPage().jE(1);
            }
            this.iKW = str;
            yT(8);
        }
    }

    private void yZ(int i) {
        if (i != 8) {
            this.iKW = "";
            if (this.iKX != null) {
                if (i == 1 && this.iEZ != null && this.iEZ.ckQ()) {
                    if (this.iKY != null) {
                        getPbData().cku().remove(this.iKY);
                    }
                } else if (i == 1 && !this.iKb && !com.baidu.tbadk.core.util.v.isEmpty(getPbData().cku())) {
                    getPbData().cku().remove(this.iKX);
                    if (this.iKY != null) {
                        getPbData().cku().remove(this.iKY);
                    }
                    getPbData().cku().add(0, this.iKX);
                } else {
                    getPbData().cku().remove(this.iKX);
                    if (this.iKY != null) {
                        getPbData().cku().remove(this.iKY);
                    }
                }
            }
            this.iKY = null;
        }
    }

    public void cog() {
        if (this.iEZ != null && !com.baidu.tbadk.core.util.v.isEmpty(this.iEZ.cku())) {
            if (this.iKY != null) {
                this.iEZ.cku().remove(this.iKY);
                this.iKY = null;
            }
            if (this.iKX != null) {
                this.iEZ.cku().remove(this.iKX);
                this.iKX = null;
            }
        }
    }

    public void cr(int i, int i2) {
        this.iKZ = i;
        this.iLa = i2;
    }

    public PostData coh() {
        return this.iKX;
    }

    public PostData coi() {
        return this.iKY;
    }

    public int coj() {
        return this.iKZ;
    }

    public int cok() {
        return this.iLa;
    }

    public String col() {
        return this.iLc;
    }

    public void FY(String str) {
        this.iLc = str;
    }

    private boolean com() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean con() {
        return this.iKV == 13 || this.iKV == 12;
    }

    public String coo() {
        return this.iLf;
    }

    public String cop() {
        return this.iLg;
    }

    public String coq() {
        return this.iLh;
    }

    public String cor() {
        return this.iLi;
    }

    public Rect cos() {
        Rect rect = this.iLb;
        this.iLb = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int cot() {
        int i;
        int i2 = 0;
        if (getPbData().cku() == null) {
            return 0;
        }
        ArrayList<PostData> cku = getPbData().cku();
        int size = cku.size() - 1;
        while (size >= 0) {
            PostData postData = cku.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
                if (postData.getType() != AdvertAppInfo.cMJ) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return cku.size();
    }
}
