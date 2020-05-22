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
import com.baidu.tbadk.core.data.bk;
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
    private boolean dHL;
    private BaseFragmentActivity gRv;
    private com.baidu.tieba.tbadkCore.d.b gSE;
    private long hFM;
    private boolean iQI;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    protected com.baidu.tieba.pb.data.e jHO;
    private int jNA;
    private int jNB;
    private boolean jNC;
    private boolean jND;
    private boolean jNE;
    private long jNF;
    private boolean jNG;
    private String jNH;
    private boolean jNI;
    private boolean jNJ;
    private boolean jNK;
    private boolean jNL;
    private a jNM;
    private String jNN;
    private String jNO;
    private int jNP;
    private int jNQ;
    private boolean jNR;
    private boolean jNS;
    private boolean jNT;
    private boolean jNU;
    private boolean jNV;
    private String jNW;
    private long jNX;
    private boolean jNY;
    private int jNZ;
    protected String jNm;
    private String jNn;
    private String jNo;
    private String jNp;
    private boolean jNq;
    private boolean jNr;
    private boolean jNs;
    private boolean jNt;
    private int jNu;
    private boolean jNv;
    private int jNw;
    private long jNx;
    private int jNy;
    private int jNz;
    private f.a jOA;
    private CustomMessageListener jOB;
    private com.baidu.adp.framework.listener.a jOC;
    private PraiseData jOD;
    private boolean jOa;
    private boolean jOb;
    private int jOc;
    private final ac jOd;
    private final o jOe;
    private final ae jOf;
    private String jOg;
    private final CheckRealNameModel jOh;
    private final AddExperiencedModel jOi;
    private SuggestEmotionModel jOj;
    private GetSugMatchWordsModel jOk;
    private boolean jOl;
    private int jOm;
    private String jOn;
    private PostData jOo;
    private PostData jOp;
    private int jOq;
    private int jOr;
    private Rect jOs;
    private String jOt;
    private com.baidu.tieba.tbadkCore.data.n jOu;
    private boolean jOv;
    private String jOw;
    private String jOx;
    private String jOy;
    private String jOz;
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
    private static final int jNl = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.jNm = null;
        this.jNn = null;
        this.jNo = null;
        this.mForumId = null;
        this.jNp = null;
        this.jNq = false;
        this.jNr = false;
        this.jNs = true;
        this.jNt = true;
        this.mSortType = 0;
        this.jNu = 0;
        this.jNv = false;
        this.mIsGood = 0;
        this.jNw = 0;
        this.jNx = 0L;
        this.jNy = 1;
        this.jNz = 1;
        this.jNA = 1;
        this.jNB = 1;
        this.isAd = false;
        this.iQI = false;
        this.dHL = false;
        this.jNC = false;
        this.isFromMark = false;
        this.jND = false;
        this.jNE = false;
        this.jNF = 0L;
        this.jNG = false;
        this.jNH = null;
        this.jHO = null;
        this.isLoading = false;
        this.jNI = false;
        this.jNJ = false;
        this.jNK = false;
        this.jNL = false;
        this.mLocate = null;
        this.mContext = null;
        this.jNM = null;
        this.opType = null;
        this.opUrl = null;
        this.jNN = null;
        this.jNO = null;
        this.jNP = -1;
        this.jNQ = -1;
        this.gSE = null;
        this.jNS = false;
        this.jNT = false;
        this.postID = null;
        this.jNW = null;
        this.jNX = 0L;
        this.jNY = false;
        this.jNZ = -1;
        this.jOb = false;
        this.jOl = false;
        this.jOm = 0;
        this.mTabIndex = 0;
        this.jOv = false;
        this.jOB = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.jOC = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.gRv.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.jNS || !PbModel.this.jNT) {
                        if (!PbModel.this.jNS) {
                            PbModel.this.jNS = true;
                        } else {
                            PbModel.this.jNT = true;
                        }
                        if (PbModel.this.jNM != null) {
                            PbModel.this.jNM.a(PbModel.this.cFo(), z, responsedMessage, PbModel.this.jNU, System.currentTimeMillis() - PbModel.this.hFM);
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
                    if (PbModel.this.jHO != null && PbModel.this.jHO.cCh() != null && PbModel.this.jHO.cCh().getForumId() != null && PbModel.this.jHO.cCh().getForumId().equals(valueOf)) {
                        PbModel.this.jHO.cCh().setIsLike(false);
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
                    if (PbModel.this.jHO != null && PbModel.this.jHO.cCh() != null && PbModel.this.jHO.cCh().getForumId() != null && PbModel.this.jHO.cCh().getForumId().equals(valueOf)) {
                        PbModel.this.jHO.cCh().setIsLike(true);
                    }
                }
            }
        };
        this.jOD = null;
        registerListener(this.jOC);
        registerListener(this.jOB);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.jHO = new com.baidu.tieba.pb.data.e();
        this.jHO.zT(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.gRv = baseFragmentActivity;
        this.jOd = new ac(this, this.gRv);
        this.jOe = new o(this, this.gRv);
        this.jOf = new ae(this, this.gRv);
        this.jOh = new CheckRealNameModel(this.gRv.getPageContext());
        this.jOj = new SuggestEmotionModel();
        this.jOi = new AddExperiencedModel(this.gRv.getPageContext());
        this.jOA = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void C(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dvs) instanceof String) {
                        PbModel.this.jNm = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dvs);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dvt) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dvt);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dvu) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dvu);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dvv) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.dvv), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dvw) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dvw);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, String str) {
        this.jNV = true;
        if (eVar != null && eVar.jDX == null) {
            p(eVar);
            l(eVar);
            if (eVar.cCi() != null) {
                eVar.cCi().ko(0);
            }
            if (this.jNM != null && eVar != null) {
                this.jNM.a(true, 0, i, 0, eVar, str, 0);
            }
        }
    }

    protected int cFo() {
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
            this.jNm = intent.getStringExtra("thread_id");
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                com.baidu.tbadk.BdToken.f.aLw().c(uri, this.jOA);
            } else if (StringUtils.isNull(this.jNm)) {
                this.jOd.a(intent, this.jOA);
                if (uri != null) {
                    if (StringUtils.isNull(this.jNm)) {
                        this.jNm = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.aq.isEmpty(this.jNm)) {
                this.jNm = "0";
            }
            this.jOm = intent.getIntExtra("key_start_from", 0);
            if (this.jOm == 0) {
                this.jOm = this.jOd.avV;
            }
            this.jNo = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.jNn = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.jNq = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.jNr = intent.getBooleanExtra("host_only", false);
            this.jNt = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.bgh().aXE() ? 2 : 0);
            if (this.mSortType == 2) {
                this.jNo = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.jNw = intent.getIntExtra("is_top", 0);
            this.jNx = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.jND = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.jNE = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.iQI = intent.getBooleanExtra("is_sub_pb", false);
            this.jNG = intent.getBooleanExtra("is_pv", false);
            this.jNF = intent.getLongExtra("msg_id", 0L);
            this.jNH = intent.getStringExtra("from_forum_name");
            this.jNO = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.jNN = intent.getStringExtra("op_stat");
            this.jNI = intent.getBooleanExtra("is_from_thread_config", false);
            this.jNJ = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.jNK = intent.getBooleanExtra("is_from_my_god_config", false);
            this.jNQ = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.jNP = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.dHL = intent.getBooleanExtra("from_frs", false);
            this.jNC = intent.getBooleanExtra("from_maintab", false);
            this.jOb = intent.getBooleanExtra("from_smart_frs", false);
            this.jNL = intent.getBooleanExtra("from_hottopic", false);
            this.jOg = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.jNp = intent.getStringExtra("high_light_post_id");
            this.jOv = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.jNR = intent.getIntExtra("request_code", -1) == 18003;
            this.jOw = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.jOx = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.jOy = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.jOz = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean cFp() {
        return this.jOv && com.baidu.tieba.frs.i.bUG() != null && com.baidu.tieba.frs.i.bUG().equals(this.jNm) && com.baidu.tieba.frs.i.bUF() != null;
    }

    public com.baidu.tieba.pb.data.e aI(bk bkVar) {
        com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
        eVar.zT(3);
        if (bkVar == null) {
            return null;
        }
        eVar.aG(bkVar);
        if (bkVar.aSm() != null) {
            eVar.e(bkVar.aSm());
            ForumData forum = eVar.getForum();
            forum.setId(bkVar.aSm().getForumId());
            forum.setName(bkVar.aSm().getForumName());
            forum.setUser_level(bkVar.aSm().aPO());
            forum.setImage_url(bkVar.aSm().getAvatar());
            forum.setPost_num(bkVar.aSm().postNum);
            forum.setMember_num(bkVar.aSm().memberNum);
        } else {
            ForumData forum2 = eVar.getForum();
            forum2.setId(String.valueOf(bkVar.getFid()));
            forum2.setName(bkVar.aQC());
        }
        PostData postData = new PostData();
        postData.DS(1);
        postData.setTime(bkVar.getCreateTime());
        postData.a(bkVar.aQx());
        MetaData aQx = bkVar.aQx();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(aQx.getUserId(), aQx);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bkVar.aQn(), false));
        eVar.d(postData);
        eVar.cCk().add(postData);
        eVar.a(new com.baidu.tieba.pb.data.m(bkVar, null));
        eVar.jEc = true;
        eVar.setIsNewUrl(1);
        return eVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.jOm = bundle.getInt("key_start_from", 0);
        this.jNm = bundle.getString("thread_id");
        this.jNo = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.jNn = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.jNq = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.jNr = bundle.getBoolean("host_only", false);
        this.jNt = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.jNw = bundle.getInt("is_top", 0);
        this.jNx = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.jNE = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.iQI = bundle.getBoolean("is_sub_pb", false);
        this.jNG = bundle.getBoolean("is_pv", false);
        this.jNF = bundle.getLong("msg_id", 0L);
        this.jNH = bundle.getString("from_forum_name");
        this.jNO = bundle.getString("extra_pb_cache_key");
        this.jNI = bundle.getBoolean("is_from_thread_config", false);
        this.jNJ = bundle.getBoolean("is_from_interview_live_config", false);
        this.jNK = bundle.getBoolean("is_from_my_god_config", false);
        this.jNQ = bundle.getInt("extra_pb_is_attention_key", -1);
        this.jNP = bundle.getInt("extra_pb_funs_count_key", -1);
        this.dHL = bundle.getBoolean("from_frs", false);
        this.jNC = bundle.getBoolean("from_maintab", false);
        this.jOb = bundle.getBoolean("from_smart_frs", false);
        this.jNL = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.jNp = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.jNR = bundle.getInt("request_code", -1) == 18003;
        this.jOw = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.jOx = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.jOy = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.jOz = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aA(Bundle bundle) {
        bundle.putString("thread_id", this.jNm);
        bundle.putString("post_id", this.jNo);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.jOm);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.jNq);
        bundle.putBoolean("host_only", this.jNr);
        bundle.putBoolean("squence", this.jNt);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.jNw);
        bundle.putLong("thread_time", this.jNx);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.jNE);
        bundle.putBoolean("is_sub_pb", this.iQI);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.jNG);
        bundle.putLong("msg_id", this.jNF);
        bundle.putString("extra_pb_cache_key", this.jNO);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.jNI);
        bundle.putBoolean("is_from_interview_live_config", this.jNJ);
        bundle.putBoolean("is_from_my_god_config", this.jNK);
        bundle.putInt("extra_pb_is_attention_key", this.jNQ);
        bundle.putInt("extra_pb_funs_count_key", this.jNP);
        bundle.putBoolean("from_frs", this.dHL);
        bundle.putBoolean("from_maintab", this.jNC);
        bundle.putBoolean("from_smart_frs", this.jOb);
        bundle.putBoolean("from_hottopic", this.jNL);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.jNp);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.jOw);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.jOx);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.jOy);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.jOz);
    }

    public String cFq() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.jNm);
        if (!this.jNE) {
            sb.append(this.jNo);
        }
        sb.append(this.jNr);
        sb.append(this.jNt);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.jNw);
        sb.append(this.jNx);
        sb.append(this.dHL);
        sb.append(this.jNC);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.iQI);
        sb.append(this.jNG);
        sb.append(this.jNF);
        sb.append(this.jNH);
        sb.append(this.mThreadType);
        sb.append(this.jNI);
        sb.append(this.jNJ);
        sb.append(this.jNK);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.jNO != null) {
            sb.append(this.jNO);
        }
        return sb.toString();
    }

    public String cDp() {
        return this.jNH;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cFr() {
        return this.jNo;
    }

    public String cFs() {
        return this.jNp;
    }

    public String cFt() {
        return this.jNm;
    }

    public String cFu() {
        return (StringUtils.isNull(this.jNm) || "0".equals(this.jNm)) ? this.oriUgcNid : this.jNm;
    }

    public boolean getHostMode() {
        return this.jNr;
    }

    public boolean cFv() {
        return cGk();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean cFw() {
        return this.dHL;
    }

    public boolean cFx() {
        return this.jNv;
    }

    public boolean cFy() {
        return this.jNC;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean cFz() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bOc() {
        return this.jNw;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void Ak(int i) {
        this.jNw = i;
    }

    public boolean cFA() {
        return this.iQI;
    }

    public boolean cFB() {
        if (this.jHO == null) {
            return false;
        }
        return this.jHO.isValid();
    }

    public String aQG() {
        if (this.jHO == null || !this.jHO.aML()) {
            return null;
        }
        return this.jHO.aMK();
    }

    public boolean Al(int i) {
        this.jNy = i;
        if (this.jNy > this.jHO.getPage().aPo()) {
            this.jNy = this.jHO.getPage().aPo();
        }
        if (this.jNy < 1) {
            this.jNy = 1;
        }
        if (this.jNm == null) {
            return false;
        }
        return An(5);
    }

    public void Am(int i) {
        this.jNy = i;
        this.jNz = i;
        this.jNA = i;
    }

    public void b(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar == null) {
            Am(1);
            return;
        }
        if (this.jNz < aoVar.aPr()) {
            this.jNz = aoVar.aPr();
        }
        if (this.jNA > aoVar.aPr()) {
            this.jNA = aoVar.aPr();
        }
        this.jNB = aoVar.aPo();
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        return this.jHO;
    }

    public BaijiahaoData cFC() {
        if (this.jHO == null || this.jHO.cCi() == null) {
            return null;
        }
        return this.jHO.cCi().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.e cFD() {
        if (this.jHO == null) {
            return this.jHO;
        }
        if (!cFE() && this.jOu != null) {
            this.jHO.b(this.jOu);
        }
        return this.jHO;
    }

    private boolean cFE() {
        return (this.jHO.cCA() == null || this.jHO.cCA().ddi() == null || this.jHO.cCA().ddi().goods != null || this.jHO.cCA().ddi().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.ao getPageData() {
        if (this.jHO == null) {
            return null;
        }
        return this.jHO.getPage();
    }

    public boolean cFF() {
        if (cGk() && this.jHO.getPage().aPt() == 0) {
            rE(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.jNm = eVar.getThreadId();
            if (eVar.cCi() != null && eVar.cCi().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = eVar.cCi().getBaijiahaoData();
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
            this.jNo = null;
            this.jNr = false;
            this.jNt = true;
            LoadData();
        }
    }

    public void Jk(String str) {
        if (!StringUtils.isNull(str)) {
            this.jNm = str;
            this.jNo = null;
            this.jNr = false;
            this.jNt = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.jNm == null) {
            return false;
        }
        cancelLoadData();
        if (this.gSE == null) {
            this.gSE = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.gSE.start();
        }
        boolean An = An(3);
        if (this.opType != null) {
            this.opType = null;
            this.jNN = null;
            this.opUrl = null;
            return An;
        }
        return An;
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
        if (this.jOj != null) {
            this.jOj.cancelLoadData();
        }
        if (this.jOk != null) {
            this.jOk.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.cVe().cVi();
        bPu();
    }

    private void bPu() {
        if (this.gSE != null) {
            this.gSE.destory();
            this.gSE = null;
        }
    }

    public boolean cFG() {
        return (this.jNo == null || this.jNo.equals("0") || this.jNo.length() == 0) ? LoadData() : cFK();
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
                this.jOj.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.jOj.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.jOk == null) {
                this.jOk = new GetSugMatchWordsModel(this.gRv.getPageContext());
            }
            this.jOk.b(aVar);
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
    public boolean An(int i) {
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
        Ao(i);
        final com.baidu.tieba.pb.data.e pbData = ao.cGM().getPbData();
        if (pbData != null && pbData.cCi() != null) {
            pbData.cCi().ko(0);
            this.jNt = ao.cGM().cFv();
            this.jNr = ao.cGM().cGR();
            this.jNv = ao.cGM().cGS();
            this.jOo = ao.cGM().cGQ();
            this.jOp = ao.cGM().cGP();
            this.jOq = ao.cGM().cGO();
            this.jOs = ao.cGM().cGT();
            this.mTabIndex = ao.cGM().getTabIndex();
            this.jOl = this.jNr;
            if (this.jNr || this.isFromMark) {
                this.jNR = false;
            }
            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.jNV) {
            a(cFP(), true, this.jNo, 3);
        }
        if (i == 3 && !this.jNV) {
            if (this.isFromMark) {
                a(cFP(), true, this.jNo, 3);
            } else {
                a(cFP(), false, this.jNo, 3);
            }
        }
        this.jNV = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.jOu == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.eki);
        if (this.jNr || this.isFromMark) {
            this.jNR = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.jNm == null || this.jNm.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.jNm, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.ar.aUW().aUX() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.jNt) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.jNr) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.jNG) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.jNF));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.jNR) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.jNN, 0));
            pbPageRequestMessage.setOpMessageID(this.jNF);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> cCk = this.jHO.cCk();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jNA - 1));
                        if (this.jNA - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.jND) {
                                if (cCk != null && cCk.size() > 0) {
                                    size = cCk.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = cCk.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.jNo = postData.getId();
                                            if (StringUtils.isNull(this.jNo)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.jNz + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.jNo == null && this.jNo.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jNo, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jNz + 1));
                        if (this.jNz >= this.jNB) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (cCk != null) {
                                size = cCk.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.jNo == null) {
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
                if (cCk != null) {
                }
                if (this.jNo == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (cCk != null && cCk.size() > 0 && cCk.get(0) != null) {
                    this.jNo = cCk.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (cGk()) {
                        if (this.jNA - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.jNA - 1));
                        }
                    } else if (this.jNz < this.jNB) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jNz + 1));
                    }
                }
                if (this.jNo != null && this.jNo.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jNo, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.jNr) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (cGk()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.jNB > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jNB));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jNo, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.jNy));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.jOl && !this.jNr) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jNo, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.jNr) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.jNZ);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jOn, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.jOl = this.jNr;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cFP());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.jOm));
        pbPageRequestMessage.setIsSubPostDataReverse(this.jNY);
        pbPageRequestMessage.setFromSmartFrs(this.jOb ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.jNq);
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.jNB) {
                    i4 = -1;
                } else {
                    i4 = cGr();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = cGr();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.jNm);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean cDo() {
        switch (cGd()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().cCi() == null || !getPbData().cCi().aRV();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cDp()) && com.baidu.tieba.recapp.q.cUm().cUg() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.cUm().cUg().aQ(cDp(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.cUm().cUg().aR(cDp(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cDp()) && com.baidu.tieba.recapp.q.cUm().cUg() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.cUm().cUg().aR(cDp(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.cUm().cUg().aQ(cDp(), true));
        }
    }

    protected void Ao(int i) {
        boolean z = false;
        At(i);
        ArrayList<PostData> cCk = this.jHO.cCk();
        this.jNU = false;
        if (i == 1) {
            boolean z2 = false;
            while (cCk.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cCk.remove(0);
                z2 = true;
            }
            if (z2) {
                this.jHO.getPage().km(1);
                if (this.jNM != null) {
                    this.jNM.e(this.jHO);
                }
            }
            this.hFM = System.currentTimeMillis();
            this.jNU = true;
        } else if (i == 2) {
            while (cCk.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cCk.remove(cCk.size() - 1);
                z = true;
            }
            if (z) {
                this.jHO.getPage().kl(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.e eVar2 = z ? null : eVar;
        this.jOc = i2;
        this.isLoading = false;
        if (eVar2 != null) {
            l(eVar2);
        }
        k(eVar2);
        if (this.jOu != null && this.jOu.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(eVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCA() != null && eVar.cCA().ddi() != null && eVar.cCA().ddi().goods != null && eVar.cCA().isValidate() && eVar.cCA().ddi().goods.goods_style != 1001) {
            this.jOu = eVar.cCA();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n cFH() {
        return this.jOu;
    }

    public void cFI() {
        this.jOu = null;
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

    protected void l(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            if (this.jNK || this.jNI || this.jNJ) {
                eVar = n(eVar);
            }
            m(eVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            String o = o(eVar);
            for (int i = 0; i < eVar.cCk().size(); i++) {
                PostData postData = eVar.cCk().get(i);
                for (int i2 = 0; i2 < postData.ddr().size(); i2++) {
                    postData.ddr().get(i2).a(this.gRv.getPageContext(), o.equals(postData.ddr().get(i2).aQx().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.p cCw = eVar.cCw();
            if (cCw != null && !com.baidu.tbadk.core.util.v.isEmpty(cCw.jFy)) {
                for (PostData postData2 : cCw.jFy) {
                    for (int i3 = 0; i3 < postData2.ddr().size(); i3++) {
                        postData2.ddr().get(i3).a(this.gRv.getPageContext(), o.equals(postData2.ddr().get(i3).aQx().getUserId()));
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, int i) {
        if (eVar != null) {
            String o = o(eVar);
            com.baidu.tieba.pb.data.p cCw = eVar.cCw();
            if (cCw != null && !com.baidu.tbadk.core.util.v.isEmpty(cCw.jFy)) {
                for (PostData postData : cCw.jFy.subList(i, cCw.jFy.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.ddr().size()) {
                            postData.ddr().get(i3).a(this.gRv.getPageContext(), o.equals(postData.ddr().get(i3).aQx().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.e n(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null) {
            return null;
        }
        bk cCi = eVar.cCi();
        cCi.kt(this.mIsGood);
        cCi.ks(this.jNw);
        if (this.jNx > 0) {
            cCi.ca(this.jNx);
            return eVar;
        }
        return eVar;
    }

    protected String o(com.baidu.tieba.pb.data.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.cCi() != null && eVar.cCi().aQx() != null) {
            str = eVar.cCi().aQx().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData cFJ() {
        if (this.jHO == null || this.jHO.cCi() == null || this.jHO.cCi().aQx() == null) {
            return null;
        }
        return this.jHO.cCi().aQx();
    }

    protected void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int size;
        int i4;
        int i5;
        boolean z4 = !z;
        this.jOa = z3;
        if (eVar != null && eVar.cCk() != null && eVar.cCk().size() == 1 && eVar.getPage().aPr() > 1) {
            i = 3;
        }
        if (this.gSE != null && !z3) {
            this.gSE.a(z2, z4, i2, str, i3, j, j2);
            this.gSE = null;
        }
        if (this.jHO != null) {
            this.jHO.jEL = z3;
            this.jHO.WR = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(cDp()) && com.baidu.tieba.recapp.q.cUm().cUg() != null) {
            com.baidu.tieba.recapp.q.cUm().cUg().f(cDp(), Ap(cFS()), true);
        }
        if (eVar == null || (this.jNy == 1 && i == 5 && eVar.cCk() != null && eVar.cCk().size() < 1)) {
            if (this.jNM != null) {
                this.jNt = this.jNs;
                if (i2 != 350006) {
                    this.mSortType = this.jNu;
                }
                this.jNM.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.jNs = this.jNt;
            if (i != 8) {
                this.jNu = this.mSortType;
                this.mSortType = eVar.jDW;
            }
            if (eVar.jDV != null && eVar.jDV.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.gRv.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                eVar.jDV = new ArrayList();
                eVar.jDV.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.gRv.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                eVar.jDV.add(builder2.build(false));
                this.mSortType = this.jNu;
                eVar.jDW = this.mSortType;
            }
            this.jNG = false;
            if (eVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(eVar.getPage());
            }
            this.jNB = this.jNB < 1 ? 1 : this.jNB;
            ArrayList<PostData> cCk = this.jHO.cCk();
            switch (i) {
                case 1:
                    this.jHO.a(eVar.getPage(), 1);
                    d(eVar, cCk);
                    i4 = 0;
                    break;
                case 2:
                    if (eVar.cCk() == null) {
                        i5 = 0;
                    } else {
                        int size2 = eVar.cCk().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(cCk, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cCk(), com.baidu.tbadk.core.util.v.getCount(eVar.cCk()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            eVar.cCk().remove(postData2);
                            i5 = size2 - 1;
                        }
                        cCk.addAll(0, eVar.cCk());
                    }
                    this.jHO.a(eVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && eVar.getPage() != null) {
                        eVar.getPage().kj(eVar.getPage().aPo());
                    }
                    p(eVar);
                    i4 = 0;
                    break;
                case 4:
                    p(eVar);
                    i4 = 0;
                    break;
                case 5:
                    p(eVar);
                    i4 = 0;
                    break;
                case 6:
                    p(eVar);
                    i4 = 0;
                    break;
                case 7:
                    p(eVar);
                    i4 = 0;
                    break;
                case 8:
                    if (eVar != null && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cCk()) && this.jHO != null && (!this.jNr || o(eVar).equals(eVar.cCk().get(0).aQx().getUserId()))) {
                        if (this.jHO.getPage().aPt() == 0) {
                            this.jHO.getPage().kl(1);
                        }
                        cGe();
                        this.jOo = eVar.cCk().get(0);
                        if (cGk() || this.jHO.cCJ()) {
                            if (this.jHO.cCk().size() - this.jOq >= 3) {
                                this.jOp = new PostData();
                                this.jOp.lll = true;
                                this.jOp.setPostType(53);
                                this.jHO.cCk().add(this.jOp);
                            }
                            this.jHO.cCk().add(this.jOo);
                            size = this.jHO.cCk().size() - 1;
                        } else {
                            if (this.jOq - this.jOr >= 3) {
                                this.jOp = new PostData();
                                this.jOp.lll = false;
                                this.jOp.setPostType(53);
                                this.jHO.cCk().add(0, this.jOp);
                            }
                            this.jHO.cCk().add(0, this.jOo);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.isTaday(com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.jOo.lly = this.jHO.cCH();
                            com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        }
                        i4 = size;
                        break;
                    }
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.jHO != null && this.jHO.cCi() != null) {
                PraiseData aQi = this.jHO.cCi().aQi();
                if (this.jOD != null && !aQi.isPriaseDataValid()) {
                    this.jHO.cCi().a(this.jOD);
                } else {
                    this.jOD = this.jHO.cCi().aQi();
                    this.jOD.setPostId(this.jHO.cCi().aQP());
                }
                if (eVar.getPage() != null && eVar.getPage().aPr() == 1 && eVar.cCi() != null && eVar.cCi().aQI() != null && eVar.cCi().aQI().size() > 0) {
                    this.jHO.cCi().x(eVar.cCi().aQI());
                }
                this.jHO.cCi().kq(eVar.cCi().aQo());
                this.jHO.cCi().kn(eVar.cCi().getAnchorLevel());
                this.jHO.cCi().ko(eVar.cCi().aQe());
                if (this.mThreadType == 33) {
                    this.jHO.cCi().aQx().setHadConcerned(eVar.cCi().aQx().hadConcerned());
                }
                if (eVar != null && eVar.cCi() != null) {
                    this.jHO.cCi().kv(eVar.cCi().aQM());
                }
            }
            if (this.jHO != null && this.jHO.getUserData() != null && eVar.getUserData() != null) {
                this.jHO.getUserData().setBimg_end_time(eVar.getUserData().getBimg_end_time());
                this.jHO.getUserData().setBimg_url(eVar.getUserData().getBimg_url());
            }
            if (eVar.getPage() != null && eVar.getPage().aPr() == 1 && eVar.cCv() != null) {
                this.jHO.f(eVar.cCv());
            }
            if (this.jOa) {
                if (this.jHO.cCi() != null && this.jHO.cCi().aQx() != null && this.jHO.cCk() != null && com.baidu.tbadk.core.util.v.getItem(this.jHO.cCk(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(this.jHO.cCk(), 0);
                    MetaData aQx = this.jHO.cCi().aQx();
                    if (postData3.aQx() != null && postData3.aQx().getGodUserData() != null) {
                        if (this.jNP != -1) {
                            aQx.setFansNum(this.jNP);
                            postData3.aQx().setFansNum(this.jNP);
                        }
                        if (this.jNQ != -1) {
                            aQx.getGodUserData().setIsLike(this.jNQ == 1);
                            postData3.aQx().getGodUserData().setIsLike(this.jNQ == 1);
                            aQx.getGodUserData().setIsFromNetWork(false);
                            postData3.aQx().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.jHO.jDU = -1;
                this.jHO.jDT = -1;
            }
            if (this.jNM != null) {
                this.jNM.a(true, getErrorCode(), i, i4, this.jHO, this.mErrorString, 1);
            }
        }
        if (this.jHO != null && this.jHO.cCi() != null && this.jHO.getForum() != null && !this.jHO.cCJ()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.gRv.getPageContext();
            historyMessage.threadId = getPbData().cCi().getId();
            if (this.mIsShareThread && getPbData().cCi().dHm != null) {
                historyMessage.threadName = getPbData().cCi().dHm.showText;
            } else {
                historyMessage.threadName = getPbData().cCi().getTitle();
            }
            if (this.mIsShareThread && !cDo()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = cFv();
            historyMessage.threadType = getPbData().cCi().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        String aO;
        if (arrayList != null && eVar.cCk() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cCk(), 0);
            if (postData != null && (aO = aO(arrayList)) != null && aO.equals(postData.getId())) {
                eVar.cCk().remove(postData);
            }
            this.jHO.jEK = arrayList.size();
            arrayList.addAll(eVar.cCk());
        }
    }

    private int Ap(int i) {
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

    private String aO(ArrayList<PostData> arrayList) {
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

    private void p(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            eVar.Jd(this.jHO.cCC());
            if (!this.jHO.jEI && eVar.jEI && this.jHO.cCs() != null) {
                eVar.e(this.jHO.cCs());
            }
            this.jHO = eVar;
            Am(eVar.getPage().aPr());
        }
    }

    public boolean cFK() {
        if (this.jNm == null || this.jNo == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return An(4);
        }
        return An(6);
    }

    public boolean rE(boolean z) {
        if (this.jNm == null || this.jHO == null) {
            return false;
        }
        if (z || this.jHO.getPage().aPt() != 0) {
            return An(1);
        }
        return false;
    }

    public boolean rF(boolean z) {
        if (this.jNm == null || this.jHO == null) {
            return false;
        }
        if ((z || this.jHO.getPage().aPu() != 0) && this.jHO.cCk() != null && this.jHO.cCk().size() >= 1) {
            return An(2);
        }
        return false;
    }

    public boolean Jq(String str) {
        this.jNr = !this.jNr;
        this.jNo = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").ag("obj_source", 0));
        if (An(6)) {
            return true;
        }
        this.jNr = this.jNr ? false : true;
        return false;
    }

    public boolean w(boolean z, String str) {
        if (this.jNr == z) {
            return false;
        }
        this.jNr = z;
        this.jNo = str;
        if (this.mSortType == 2) {
            this.jNo = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").ag("obj_source", 1));
        }
        if (An(6)) {
            return true;
        }
        this.jNr = z ? false : true;
        return false;
    }

    public boolean Aq(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.jNs = this.jNt;
        this.jNu = this.mSortType;
        this.mSortType = i;
        this.jNt = !this.jNt;
        if (i == 2 && this.isFromMark) {
            this.jNo = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.jNt = this.jNt ? false : true;
            this.mSortType = this.jNu;
            return false;
        }
        return true;
    }

    public boolean cFL() {
        return cGk();
    }

    public int cFM() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.jHO == null || this.jHO.getForum() == null || this.jHO.cCi() == null) ? false : true;
    }

    public boolean aML() {
        if (this.jHO == null) {
            return false;
        }
        return this.jHO.aML();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData yf(String str) {
        if (this.jHO == null || this.jHO.cCi() == null || this.jHO.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.jHO.cCi().aRV()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.jHO.getForum().getId());
            writeData.setForumName(this.jHO.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.jOm);
        writeData.setThreadId(this.jNm);
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

    public MarkData Ar(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.jHO == null) {
            return null;
        }
        ArrayList<PostData> cCk = this.jHO.cCk();
        if (com.baidu.tbadk.core.util.v.isEmpty(cCk)) {
            return null;
        }
        if (cCk.size() > 0 && i >= cCk.size()) {
            i = cCk.size() - 1;
        }
        return o(cCk.get(i));
    }

    public MarkData cFN() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.jNm);
        markData.setPostId(this.jHO.aMK());
        markData.setTime(date.getTime());
        markData.setHostMode(this.jNr);
        markData.setSequence(Boolean.valueOf(cGk()));
        markData.setId(this.jNm);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.jNm);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.jNr);
        markData.setSequence(Boolean.valueOf(cGk()));
        markData.setId(this.jNm);
        markData.setFloor(postData.ddu());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) postData).isApp());
        }
        return markData;
    }

    public void cFO() {
        j.cEc().aK(cFP(), this.isFromMark);
    }

    private String cFP() {
        String cFQ = (this.jNm == null || this.jNm.equals("0")) ? cFQ() : this.jNm;
        if (this.jNr) {
            cFQ = cFQ + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            cFQ = cFQ + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return cFQ + TbadkCoreApplication.getCurrentAccount();
        }
        return cFQ;
    }

    private String cFQ() {
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

    public void rG(boolean z) {
        if (this.jHO != null) {
            this.jHO.gC(z);
        }
    }

    public boolean cFR() {
        return this.jNR;
    }

    public void a(a aVar) {
        this.jNM = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bdr() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bdq() {
        return cFG();
    }

    public boolean Jr(String str) {
        if (getPbData() == null || getPbData().cCi() == null || getPbData().cCi().aQx() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().cCi().aQx().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int cFS() {
        return this.mRequestType;
    }

    public void cFT() {
        if ("personalize_page".equals(this.mStType)) {
            this.jNX = System.currentTimeMillis() / 1000;
        }
    }

    public void cFU() {
        if ("personalize_page".equals(this.mStType) && this.jHO != null && this.jNX != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").dh("fid", this.jHO.getForumId()).dh("tid", this.jNm).dh("obj_duration", String.valueOf(currentTimeMillis - this.jNX)).dh(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.jNX = 0L;
        }
    }

    public boolean cFV() {
        return this.jOa;
    }

    public int getErrorNo() {
        return this.jOc;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public o cFW() {
        return this.jOe;
    }

    public ae cFX() {
        return this.jOf;
    }

    public CheckRealNameModel cFY() {
        return this.jOh;
    }

    public AddExperiencedModel cFZ() {
        return this.jOi;
    }

    public String cGa() {
        return this.jNW;
    }

    public void Js(String str) {
        this.jNW = str;
    }

    public boolean cGb() {
        return this.jOb;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.jHO != null && this.jHO.cCk() != null && this.jHO.cCk().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.jHO.cCk().size();
                for (int i = 0; i < size; i++) {
                    if (this.jHO.cCk().get(i) != null && this.jHO.cCk().get(i).aQx() != null && currentAccount.equals(this.jHO.cCk().get(i).aQx().getUserId()) && this.jHO.cCk().get(i).aQx().getPendantData() != null) {
                        this.jHO.cCk().get(i).aQx().getPendantData().vx(lVar.aOP());
                        this.jHO.cCk().get(i).aQx().getPendantData().cr(lVar.bcB());
                    }
                }
            }
        }
    }

    public String cGc() {
        return this.jOg;
    }

    public int cGd() {
        return this.jOm;
    }

    public void As(int i) {
        this.jOm = i;
    }

    public void Jt(String str) {
        if ((!this.jNr || Jr(TbadkCoreApplication.getCurrentAccount())) && this.jHO.cCk() != null) {
            this.jHO.getPage().kl(1);
            if (this.jHO.getPage().aPt() == 0) {
                this.jHO.getPage().kl(1);
            }
            this.jOn = str;
            An(8);
        }
    }

    private void At(int i) {
        if (i != 8) {
            this.jOn = "";
            if (this.jOo != null) {
                if (i == 1 && this.jHO != null && this.jHO.cCJ()) {
                    if (this.jOp != null) {
                        getPbData().cCk().remove(this.jOp);
                    }
                } else if (i == 1 && !this.jNt && !com.baidu.tbadk.core.util.v.isEmpty(getPbData().cCk())) {
                    getPbData().cCk().remove(this.jOo);
                    if (this.jOp != null) {
                        getPbData().cCk().remove(this.jOp);
                    }
                    getPbData().cCk().add(0, this.jOo);
                } else {
                    getPbData().cCk().remove(this.jOo);
                    if (this.jOp != null) {
                        getPbData().cCk().remove(this.jOp);
                    }
                }
            }
            this.jOp = null;
        }
    }

    public void cGe() {
        if (this.jHO != null && !com.baidu.tbadk.core.util.v.isEmpty(this.jHO.cCk())) {
            if (this.jOp != null) {
                this.jHO.cCk().remove(this.jOp);
                this.jOp = null;
            }
            if (this.jOo != null) {
                this.jHO.cCk().remove(this.jOo);
                this.jOo = null;
            }
        }
    }

    public void cD(int i, int i2) {
        this.jOq = i;
        this.jOr = i2;
    }

    public PostData cGf() {
        return this.jOo;
    }

    public PostData cGg() {
        return this.jOp;
    }

    public int cGh() {
        return this.jOq;
    }

    public int cGi() {
        return this.jOr;
    }

    public String cGj() {
        return this.jOt;
    }

    public void Ju(String str) {
        this.jOt = str;
    }

    private boolean cGk() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean cGl() {
        return this.jOm == 13 || this.jOm == 12;
    }

    public String cGm() {
        return this.jOw;
    }

    public String cGn() {
        return this.jOx;
    }

    public String cGo() {
        return this.jOy;
    }

    public String cGp() {
        return this.jOz;
    }

    public Rect cGq() {
        Rect rect = this.jOs;
        this.jOs = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int cGr() {
        int i;
        int i2 = 0;
        if (getPbData().cCk() == null) {
            return 0;
        }
        ArrayList<PostData> cCk = getPbData().cCk();
        int size = cCk.size() - 1;
        while (size >= 0) {
            PostData postData = cCk.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
                if (postData.getType() != AdvertAppInfo.dAi) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return cCk.size();
    }
}
