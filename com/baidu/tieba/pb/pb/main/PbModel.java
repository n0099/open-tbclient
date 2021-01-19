package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bz;
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
/* loaded from: classes2.dex */
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
    private boolean eRS;
    private boolean eRr;
    private BaseFragmentActivity iEK;
    private com.baidu.tieba.tbadkCore.d.b iFP;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private long jyL;
    protected com.baidu.tieba.pb.data.f lFA;
    protected String lLR;
    private String lLS;
    private String lLT;
    private String lLU;
    private boolean lLV;
    private boolean lLW;
    private boolean lLX;
    private boolean lLY;
    private int lLZ;
    private boolean lMA;
    private String lMB;
    private long lMC;
    private boolean lMD;
    private int lME;
    private boolean lMF;
    private boolean lMG;
    private int lMH;
    private final z lMI;
    private final n lMJ;
    private final ab lMK;
    private String lML;
    private final CheckRealNameModel lMM;
    private final AddExperiencedModel lMN;
    private SuggestEmotionModel lMO;
    private GetSugMatchWordsModel lMP;
    private boolean lMQ;
    private int lMR;
    private String lMS;
    private PostData lMT;
    private PostData lMU;
    private int lMV;
    private int lMW;
    private Rect lMX;
    private String lMY;
    private com.baidu.tieba.tbadkCore.data.o lMZ;
    private boolean lMa;
    private int lMb;
    private long lMc;
    private int lMd;
    private int lMe;
    private int lMf;
    private int lMg;
    private boolean lMh;
    private boolean lMi;
    private boolean lMj;
    private long lMk;
    private boolean lMl;
    private String lMm;
    private boolean lMn;
    private boolean lMo;
    private boolean lMp;
    private boolean lMq;
    private a lMr;
    private String lMs;
    private String lMt;
    private int lMu;
    private int lMv;
    private boolean lMw;
    private boolean lMx;
    private boolean lMy;
    private boolean lMz;
    private boolean lNa;
    private String lNb;
    private String lNc;
    private String lNd;
    private String lNe;
    private String lNf;
    private boolean lNg;
    private f.a lNh;
    private CustomMessageListener lNi;
    private com.baidu.adp.framework.listener.a lNj;
    private PraiseData lNk;
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
    private static final int lLQ = com.baidu.tbadk.data.e.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.f fVar);
    }

    public PbModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.mStType = null;
        this.lLR = null;
        this.isPrivacy = false;
        this.lLS = null;
        this.lLT = null;
        this.mForumId = null;
        this.lLU = null;
        this.lLV = false;
        this.lLW = false;
        this.lLX = true;
        this.lLY = true;
        this.mSortType = 0;
        this.lLZ = 0;
        this.lMa = false;
        this.mIsGood = 0;
        this.lMb = 0;
        this.lMc = 0L;
        this.lMd = 1;
        this.lMe = 1;
        this.lMf = 1;
        this.lMg = 1;
        this.isAd = false;
        this.eRS = false;
        this.eRr = false;
        this.lMh = false;
        this.isFromMark = false;
        this.lMi = false;
        this.lMj = false;
        this.lMk = 0L;
        this.lMl = false;
        this.lMm = null;
        this.lFA = null;
        this.isLoading = false;
        this.lMn = false;
        this.lMo = false;
        this.lMp = false;
        this.lMq = false;
        this.mLocate = null;
        this.mContext = null;
        this.lMr = null;
        this.opType = null;
        this.opUrl = null;
        this.lMs = null;
        this.lMt = null;
        this.lMu = -1;
        this.lMv = -1;
        this.iFP = null;
        this.lMx = false;
        this.lMy = false;
        this.postID = null;
        this.lMB = null;
        this.lMC = 0L;
        this.lMD = false;
        this.lME = -1;
        this.lMG = false;
        this.lMQ = false;
        this.lMR = 0;
        this.mTabIndex = 0;
        this.lNa = false;
        this.lNi = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.lNj = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.iEK.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.lMx || !PbModel.this.lMy) {
                        if (!PbModel.this.lMx) {
                            PbModel.this.lMx = true;
                        } else {
                            PbModel.this.lMy = true;
                        }
                        if (PbModel.this.lMr != null) {
                            PbModel.this.lMr.a(PbModel.this.dlZ(), z, responsedMessage, PbModel.this.lMz, System.currentTimeMillis() - PbModel.this.jyL);
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
                    if (PbModel.this.lFA != null && PbModel.this.lFA.diM() != null && PbModel.this.lFA.diM().getForumId() != null && PbModel.this.lFA.diM().getForumId().equals(valueOf)) {
                        PbModel.this.lFA.diM().setIsLike(false);
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
                    if (PbModel.this.lFA != null && PbModel.this.lFA.diM() != null && PbModel.this.lFA.diM().getForumId() != null && PbModel.this.lFA.diM().getForumId().equals(valueOf)) {
                        PbModel.this.lFA.diM().setIsLike(true);
                    }
                }
            }
        };
        this.lNk = null;
        registerListener(this.lNj);
        registerListener(this.lNi);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.lFA = new com.baidu.tieba.pb.data.f();
        this.lFA.Fb(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.iEK = baseFragmentActivity;
        this.lMI = new z(this, this.iEK);
        this.lMJ = new n(this, this.iEK);
        this.lMK = new ab(this, this.iEK);
        this.lMM = new CheckRealNameModel(this.iEK.getPageContext());
        this.lMO = new SuggestEmotionModel();
        this.lMN = new AddExperiencedModel(this.iEK.getPageContext());
        this.lNh = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void onCallBack(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eBG) instanceof String) {
                        PbModel.this.lLR = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eBG);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eBH) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eBH);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eBI) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eBI);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eBJ) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.eBJ), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eBK) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eBK);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.lMA = true;
        if (fVar != null && fVar.lBn == null) {
            q(fVar);
            l(fVar);
            if (fVar.diN() != null) {
                fVar.diN().nf(0);
            }
            if (this.lMr != null && fVar != null) {
                this.lMr.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int dlZ() {
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
            this.lLR = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.lNf = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            this.lNg = false;
            if (com.baidu.tbadk.BdToken.f.r(uri)) {
                this.lNg = true;
                com.baidu.tbadk.BdToken.f.bhu().c(uri, this.lNh);
            } else if (StringUtils.isNull(this.lLR)) {
                this.lNg = true;
                this.lMI.a(intent, this.lNh);
                if (uri != null) {
                    if (StringUtils.isNull(this.lLR)) {
                        this.lLR = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.at.isEmpty(this.lLR)) {
                this.lLR = "0";
            }
            this.lMR = intent.getIntExtra("key_start_from", 0);
            if (this.lMR == 0) {
                this.lMR = this.lMI.aHt;
            }
            this.lLT = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.lLS = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.lLV = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.lLW = intent.getBooleanExtra("host_only", false);
            this.lLY = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.lLT = this.mSortType == 2 ? "0" : this.lLT;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.lMb = intent.getIntExtra("is_top", 0);
            this.lMc = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.lMi = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.lMj = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.eRS = intent.getBooleanExtra("is_sub_pb", false);
            this.lMl = intent.getBooleanExtra("is_pv", false);
            this.lMk = intent.getLongExtra("msg_id", 0L);
            this.lMm = intent.getStringExtra("from_forum_name");
            this.lMt = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.lMs = intent.getStringExtra("op_stat");
            this.lMn = intent.getBooleanExtra("is_from_thread_config", false);
            this.lMo = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.lMp = intent.getBooleanExtra("is_from_my_god_config", false);
            this.lMv = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.lMu = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.eRr = intent.getBooleanExtra("from_frs", false);
            this.lMh = intent.getBooleanExtra("from_maintab", false);
            this.lMG = intent.getBooleanExtra("from_smart_frs", false);
            this.lMq = intent.getBooleanExtra("from_hottopic", false);
            this.lML = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.lLU = intent.getStringExtra("high_light_post_id");
            this.lNa = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.lMw = intent.getIntExtra("request_code", -1) == 18003;
            this.lNb = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.lNc = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.lNd = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.lNe = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean dma() {
        return this.lNa && com.baidu.tieba.frs.l.cAX() != null && com.baidu.tieba.frs.l.cAX().equals(this.lLR) && com.baidu.tieba.frs.l.cAW() != null;
    }

    public com.baidu.tieba.pb.data.f aL(bz bzVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.Fb(3);
        if (bzVar == null) {
            return null;
        }
        fVar.aI(bzVar);
        if (bzVar.bpo() != null) {
            fVar.d(bzVar.bpo());
            ForumData forum = fVar.getForum();
            forum.setId(bzVar.bpo().getForumId());
            forum.setName(bzVar.bpo().getForumName());
            forum.setUser_level(bzVar.bpo().bmN());
            forum.setImage_url(bzVar.bpo().getAvatar());
            forum.setPost_num(bzVar.bpo().postNum);
            forum.setMember_num(bzVar.bpo().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(bzVar.getFid()));
            forum2.setName(bzVar.bnB());
        }
        PostData postData = new PostData();
        postData.Jk(1);
        postData.setTime(bzVar.getCreateTime());
        postData.a(bzVar.bnx());
        MetaData bnx = bzVar.bnx();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(bnx.getUserId(), bnx);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bzVar.bnn(), false));
        fVar.d(postData);
        fVar.diP().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.o(bzVar, null));
        fVar.lBs = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.lMR = bundle.getInt("key_start_from", 0);
        this.lLR = bundle.getString("thread_id");
        this.lLT = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.lLS = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.lLV = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.lLW = bundle.getBoolean("host_only", false);
        this.lLY = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.lMb = bundle.getInt("is_top", 0);
        this.lMc = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.lMj = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eRS = bundle.getBoolean("is_sub_pb", false);
        this.lMl = bundle.getBoolean("is_pv", false);
        this.lMk = bundle.getLong("msg_id", 0L);
        this.lMm = bundle.getString("from_forum_name");
        this.lMt = bundle.getString("extra_pb_cache_key");
        this.lMn = bundle.getBoolean("is_from_thread_config", false);
        this.lMo = bundle.getBoolean("is_from_interview_live_config", false);
        this.lMp = bundle.getBoolean("is_from_my_god_config", false);
        this.lMv = bundle.getInt("extra_pb_is_attention_key", -1);
        this.lMu = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eRr = bundle.getBoolean("from_frs", false);
        this.lMh = bundle.getBoolean("from_maintab", false);
        this.lMG = bundle.getBoolean("from_smart_frs", false);
        this.lMq = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.lLU = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.lMw = bundle.getInt("request_code", -1) == 18003;
        this.lNb = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.lNc = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.lNd = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.lNe = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aD(Bundle bundle) {
        bundle.putString("thread_id", this.lLR);
        bundle.putString("post_id", this.lLT);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.lMR);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.lLV);
        bundle.putBoolean("host_only", this.lLW);
        bundle.putBoolean("squence", this.lLY);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.lMb);
        bundle.putLong("thread_time", this.lMc);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.lMj);
        bundle.putBoolean("is_sub_pb", this.eRS);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.lMl);
        bundle.putLong("msg_id", this.lMk);
        bundle.putString("extra_pb_cache_key", this.lMt);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.lMn);
        bundle.putBoolean("is_from_interview_live_config", this.lMo);
        bundle.putBoolean("is_from_my_god_config", this.lMp);
        bundle.putInt("extra_pb_is_attention_key", this.lMv);
        bundle.putInt("extra_pb_funs_count_key", this.lMu);
        bundle.putBoolean("from_frs", this.eRr);
        bundle.putBoolean("from_maintab", this.lMh);
        bundle.putBoolean("from_smart_frs", this.lMG);
        bundle.putBoolean("from_hottopic", this.lMq);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.lLU);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.lNb);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.lNc);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.lNd);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.lNe);
    }

    public String dmb() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.lLR);
        if (!this.lMj) {
            sb.append(this.lLT);
        }
        sb.append(this.lLW);
        sb.append(this.lLY);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.lMb);
        sb.append(this.lMc);
        sb.append(this.eRr);
        sb.append(this.lMh);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eRS);
        sb.append(this.lMl);
        sb.append(this.lMk);
        sb.append(this.lMm);
        sb.append(this.mThreadType);
        sb.append(this.lMn);
        sb.append(this.lMo);
        sb.append(this.lMp);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.lMt != null) {
            sb.append(this.lMt);
        }
        return sb.toString();
    }

    public String djW() {
        return this.lMm;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String dmc() {
        return this.lLT;
    }

    public String dmd() {
        return this.lLU;
    }

    public String dme() {
        return this.lLR;
    }

    public String dmf() {
        return (StringUtils.isNull(this.lLR) || "0".equals(this.lLR)) ? this.oriUgcNid : this.lLR;
    }

    public boolean getHostMode() {
        return this.lLW;
    }

    public boolean dmg() {
        return dmW();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean dmh() {
        return this.eRr;
    }

    public boolean dmi() {
        return this.lMa;
    }

    public boolean dmj() {
        return this.lMh;
    }

    public boolean dmk() {
        return this.lMq;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean dml() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int ctW() {
        return this.lMb;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void Fv(int i) {
        this.lMb = i;
    }

    public boolean dmm() {
        return this.eRS;
    }

    public boolean dmn() {
        if (this.lFA == null) {
            return false;
        }
        return this.lFA.isValid();
    }

    public String bnF() {
        if (this.lFA == null || !this.lFA.bjE()) {
            return null;
        }
        return this.lFA.bjD();
    }

    public boolean Fw(int i) {
        this.lMd = i;
        if (this.lMd > this.lFA.getPage().bmh()) {
            this.lMd = this.lFA.getPage().bmh();
        }
        if (this.lMd < 1) {
            this.lMd = 1;
        }
        if (this.lLR == null) {
            return false;
        }
        return Fy(5);
    }

    public void Fx(int i) {
        this.lMd = i;
        this.lMe = i;
        this.lMf = i;
    }

    public void b(ax axVar) {
        if (axVar == null) {
            Fx(1);
            return;
        }
        if (this.lMe < axVar.bmk()) {
            this.lMe = axVar.bmk();
        }
        if (this.lMf > axVar.bmk()) {
            this.lMf = axVar.bmk();
        }
        this.lMg = axVar.bmh();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.lFA;
    }

    public BaijiahaoData dmo() {
        if (this.lFA == null || this.lFA.diN() == null) {
            return null;
        }
        return this.lFA.diN().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f dmp() {
        if (this.lFA == null) {
            return this.lFA;
        }
        if (!dmq() && this.lMZ != null) {
            this.lFA.b(this.lMZ);
        }
        return this.lFA;
    }

    private boolean dmq() {
        return (this.lFA.djf() == null || this.lFA.djf().dLa() == null || this.lFA.djf().dLa().goods != null || this.lFA.djf().dLa().goods.goods_style == 1001) ? false : true;
    }

    public ax getPageData() {
        if (this.lFA == null) {
            return null;
        }
        return this.lFA.getPage();
    }

    public boolean dmr() {
        if (dmW() && this.lFA.getPage().bmm() == 0) {
            uX(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.lLR = fVar.getThreadId();
            if (fVar.diN() != null && fVar.diN().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.diN().getBaijiahaoData();
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
            this.lLT = null;
            this.lLW = false;
            this.lLY = true;
            LoadData();
        }
    }

    public void OB(String str) {
        if (!StringUtils.isNull(str)) {
            this.lLR = str;
            this.lLT = null;
            this.lLW = false;
            this.lLY = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lLR == null) {
            return false;
        }
        cancelLoadData();
        if (this.iFP == null) {
            this.iFP = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.iFP.start();
        }
        boolean Fy = Fy(3);
        if (this.opType != null) {
            this.opType = null;
            this.lMs = null;
            this.opUrl = null;
            return Fy;
        }
        return Fy;
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
        if (this.lMO != null) {
            this.lMO.cancelLoadData();
        }
        if (this.lMP != null) {
            this.lMP.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dCd().QN("PB");
        cvv();
    }

    private void cvv() {
        if (this.iFP != null) {
            this.iFP.destory();
            this.iFP = null;
        }
    }

    public boolean dms() {
        return (this.lLT == null || this.lLT.equals("0") || this.lLT.length() == 0) ? LoadData() : dmw();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        String str = "";
        String str2 = "";
        if (forumData != null) {
            if (!TextUtils.isEmpty(forumData.getId())) {
                str = forumData.getId();
            }
            if (!TextUtils.isEmpty(forumData.getName())) {
                str2 = forumData.getName();
            }
        }
        this.lMO.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.lMP == null) {
                this.lMP = new GetSugMatchWordsModel(this.iEK.getPageContext());
            }
            this.lMP.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x03b6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03be A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x0124, B:51:0x0173, B:53:0x0183, B:54:0x018b, B:56:0x0198, B:57:0x01a0, B:59:0x01a4, B:60:0x01a9, B:62:0x01ad, B:63:0x01b2, B:65:0x01b6, B:66:0x01c6, B:68:0x01ca, B:69:0x01d2, B:71:0x01d6, B:72:0x01ef, B:73:0x01fe, B:74:0x0201, B:77:0x022d, B:79:0x0238, B:80:0x0240, B:82:0x024a, B:83:0x024e, B:85:0x0253, B:87:0x0258, B:209:0x0553, B:90:0x0260, B:92:0x027c, B:93:0x0285, B:95:0x028b, B:97:0x0295, B:210:0x0559, B:211:0x055f, B:214:0x056c, B:100:0x02a2, B:89:0x025c, B:208:0x054d, B:207:0x0546, B:103:0x02d6, B:104:0x02f4, B:106:0x030c, B:108:0x0312, B:110:0x0319, B:111:0x0326, B:113:0x033a, B:115:0x0340, B:117:0x0346, B:126:0x0376, B:128:0x037c, B:118:0x0351, B:120:0x0355, B:122:0x035d, B:124:0x036c, B:125:0x0371, B:129:0x0388, B:131:0x039c, B:133:0x03a0, B:136:0x03b2, B:139:0x03b8, B:167:0x042e, B:142:0x03be, B:144:0x03c4, B:145:0x03c9, B:147:0x03cd, B:149:0x03d7, B:154:0x03ee, B:156:0x03fc, B:157:0x03ff, B:159:0x0403, B:160:0x040e, B:162:0x0412, B:164:0x041a, B:166:0x0429, B:168:0x0433, B:170:0x0437, B:151:0x03db, B:171:0x0440, B:172:0x046e, B:174:0x0472, B:184:0x04a3, B:177:0x047e, B:179:0x048c, B:180:0x0494, B:182:0x0498, B:183:0x049e, B:185:0x04ac, B:187:0x04b8, B:176:0x0476, B:188:0x04c2, B:190:0x04ce, B:192:0x04d2, B:194:0x04d6, B:195:0x04db, B:197:0x04e7, B:198:0x04ef, B:202:0x0509, B:199:0x04f4, B:201:0x0503, B:203:0x0512, B:205:0x0521, B:101:0x02c8, B:38:0x00e3), top: B:217:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03cd A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x0124, B:51:0x0173, B:53:0x0183, B:54:0x018b, B:56:0x0198, B:57:0x01a0, B:59:0x01a4, B:60:0x01a9, B:62:0x01ad, B:63:0x01b2, B:65:0x01b6, B:66:0x01c6, B:68:0x01ca, B:69:0x01d2, B:71:0x01d6, B:72:0x01ef, B:73:0x01fe, B:74:0x0201, B:77:0x022d, B:79:0x0238, B:80:0x0240, B:82:0x024a, B:83:0x024e, B:85:0x0253, B:87:0x0258, B:209:0x0553, B:90:0x0260, B:92:0x027c, B:93:0x0285, B:95:0x028b, B:97:0x0295, B:210:0x0559, B:211:0x055f, B:214:0x056c, B:100:0x02a2, B:89:0x025c, B:208:0x054d, B:207:0x0546, B:103:0x02d6, B:104:0x02f4, B:106:0x030c, B:108:0x0312, B:110:0x0319, B:111:0x0326, B:113:0x033a, B:115:0x0340, B:117:0x0346, B:126:0x0376, B:128:0x037c, B:118:0x0351, B:120:0x0355, B:122:0x035d, B:124:0x036c, B:125:0x0371, B:129:0x0388, B:131:0x039c, B:133:0x03a0, B:136:0x03b2, B:139:0x03b8, B:167:0x042e, B:142:0x03be, B:144:0x03c4, B:145:0x03c9, B:147:0x03cd, B:149:0x03d7, B:154:0x03ee, B:156:0x03fc, B:157:0x03ff, B:159:0x0403, B:160:0x040e, B:162:0x0412, B:164:0x041a, B:166:0x0429, B:168:0x0433, B:170:0x0437, B:151:0x03db, B:171:0x0440, B:172:0x046e, B:174:0x0472, B:184:0x04a3, B:177:0x047e, B:179:0x048c, B:180:0x0494, B:182:0x0498, B:183:0x049e, B:185:0x04ac, B:187:0x04b8, B:176:0x0476, B:188:0x04c2, B:190:0x04ce, B:192:0x04d2, B:194:0x04d6, B:195:0x04db, B:197:0x04e7, B:198:0x04ef, B:202:0x0509, B:199:0x04f4, B:201:0x0503, B:203:0x0512, B:205:0x0521, B:101:0x02c8, B:38:0x00e3), top: B:217:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0403 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x0124, B:51:0x0173, B:53:0x0183, B:54:0x018b, B:56:0x0198, B:57:0x01a0, B:59:0x01a4, B:60:0x01a9, B:62:0x01ad, B:63:0x01b2, B:65:0x01b6, B:66:0x01c6, B:68:0x01ca, B:69:0x01d2, B:71:0x01d6, B:72:0x01ef, B:73:0x01fe, B:74:0x0201, B:77:0x022d, B:79:0x0238, B:80:0x0240, B:82:0x024a, B:83:0x024e, B:85:0x0253, B:87:0x0258, B:209:0x0553, B:90:0x0260, B:92:0x027c, B:93:0x0285, B:95:0x028b, B:97:0x0295, B:210:0x0559, B:211:0x055f, B:214:0x056c, B:100:0x02a2, B:89:0x025c, B:208:0x054d, B:207:0x0546, B:103:0x02d6, B:104:0x02f4, B:106:0x030c, B:108:0x0312, B:110:0x0319, B:111:0x0326, B:113:0x033a, B:115:0x0340, B:117:0x0346, B:126:0x0376, B:128:0x037c, B:118:0x0351, B:120:0x0355, B:122:0x035d, B:124:0x036c, B:125:0x0371, B:129:0x0388, B:131:0x039c, B:133:0x03a0, B:136:0x03b2, B:139:0x03b8, B:167:0x042e, B:142:0x03be, B:144:0x03c4, B:145:0x03c9, B:147:0x03cd, B:149:0x03d7, B:154:0x03ee, B:156:0x03fc, B:157:0x03ff, B:159:0x0403, B:160:0x040e, B:162:0x0412, B:164:0x041a, B:166:0x0429, B:168:0x0433, B:170:0x0437, B:151:0x03db, B:171:0x0440, B:172:0x046e, B:174:0x0472, B:184:0x04a3, B:177:0x047e, B:179:0x048c, B:180:0x0494, B:182:0x0498, B:183:0x049e, B:185:0x04ac, B:187:0x04b8, B:176:0x0476, B:188:0x04c2, B:190:0x04ce, B:192:0x04d2, B:194:0x04d6, B:195:0x04db, B:197:0x04e7, B:198:0x04ef, B:202:0x0509, B:199:0x04f4, B:201:0x0503, B:203:0x0512, B:205:0x0521, B:101:0x02c8, B:38:0x00e3), top: B:217:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0412 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x0124, B:51:0x0173, B:53:0x0183, B:54:0x018b, B:56:0x0198, B:57:0x01a0, B:59:0x01a4, B:60:0x01a9, B:62:0x01ad, B:63:0x01b2, B:65:0x01b6, B:66:0x01c6, B:68:0x01ca, B:69:0x01d2, B:71:0x01d6, B:72:0x01ef, B:73:0x01fe, B:74:0x0201, B:77:0x022d, B:79:0x0238, B:80:0x0240, B:82:0x024a, B:83:0x024e, B:85:0x0253, B:87:0x0258, B:209:0x0553, B:90:0x0260, B:92:0x027c, B:93:0x0285, B:95:0x028b, B:97:0x0295, B:210:0x0559, B:211:0x055f, B:214:0x056c, B:100:0x02a2, B:89:0x025c, B:208:0x054d, B:207:0x0546, B:103:0x02d6, B:104:0x02f4, B:106:0x030c, B:108:0x0312, B:110:0x0319, B:111:0x0326, B:113:0x033a, B:115:0x0340, B:117:0x0346, B:126:0x0376, B:128:0x037c, B:118:0x0351, B:120:0x0355, B:122:0x035d, B:124:0x036c, B:125:0x0371, B:129:0x0388, B:131:0x039c, B:133:0x03a0, B:136:0x03b2, B:139:0x03b8, B:167:0x042e, B:142:0x03be, B:144:0x03c4, B:145:0x03c9, B:147:0x03cd, B:149:0x03d7, B:154:0x03ee, B:156:0x03fc, B:157:0x03ff, B:159:0x0403, B:160:0x040e, B:162:0x0412, B:164:0x041a, B:166:0x0429, B:168:0x0433, B:170:0x0437, B:151:0x03db, B:171:0x0440, B:172:0x046e, B:174:0x0472, B:184:0x04a3, B:177:0x047e, B:179:0x048c, B:180:0x0494, B:182:0x0498, B:183:0x049e, B:185:0x04ac, B:187:0x04b8, B:176:0x0476, B:188:0x04c2, B:190:0x04ce, B:192:0x04d2, B:194:0x04d6, B:195:0x04db, B:197:0x04e7, B:198:0x04ef, B:202:0x0509, B:199:0x04f4, B:201:0x0503, B:203:0x0512, B:205:0x0521, B:101:0x02c8, B:38:0x00e3), top: B:217:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0437 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x0124, B:51:0x0173, B:53:0x0183, B:54:0x018b, B:56:0x0198, B:57:0x01a0, B:59:0x01a4, B:60:0x01a9, B:62:0x01ad, B:63:0x01b2, B:65:0x01b6, B:66:0x01c6, B:68:0x01ca, B:69:0x01d2, B:71:0x01d6, B:72:0x01ef, B:73:0x01fe, B:74:0x0201, B:77:0x022d, B:79:0x0238, B:80:0x0240, B:82:0x024a, B:83:0x024e, B:85:0x0253, B:87:0x0258, B:209:0x0553, B:90:0x0260, B:92:0x027c, B:93:0x0285, B:95:0x028b, B:97:0x0295, B:210:0x0559, B:211:0x055f, B:214:0x056c, B:100:0x02a2, B:89:0x025c, B:208:0x054d, B:207:0x0546, B:103:0x02d6, B:104:0x02f4, B:106:0x030c, B:108:0x0312, B:110:0x0319, B:111:0x0326, B:113:0x033a, B:115:0x0340, B:117:0x0346, B:126:0x0376, B:128:0x037c, B:118:0x0351, B:120:0x0355, B:122:0x035d, B:124:0x036c, B:125:0x0371, B:129:0x0388, B:131:0x039c, B:133:0x03a0, B:136:0x03b2, B:139:0x03b8, B:167:0x042e, B:142:0x03be, B:144:0x03c4, B:145:0x03c9, B:147:0x03cd, B:149:0x03d7, B:154:0x03ee, B:156:0x03fc, B:157:0x03ff, B:159:0x0403, B:160:0x040e, B:162:0x0412, B:164:0x041a, B:166:0x0429, B:168:0x0433, B:170:0x0437, B:151:0x03db, B:171:0x0440, B:172:0x046e, B:174:0x0472, B:184:0x04a3, B:177:0x047e, B:179:0x048c, B:180:0x0494, B:182:0x0498, B:183:0x049e, B:185:0x04ac, B:187:0x04b8, B:176:0x0476, B:188:0x04c2, B:190:0x04ce, B:192:0x04d2, B:194:0x04d6, B:195:0x04db, B:197:0x04e7, B:198:0x04ef, B:202:0x0509, B:199:0x04f4, B:201:0x0503, B:203:0x0512, B:205:0x0521, B:101:0x02c8, B:38:0x00e3), top: B:217:0x00d7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Fy(int i) {
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
        Fz(i);
        final com.baidu.tieba.pb.data.f pbData = aj.dnE().getPbData();
        if (pbData != null && pbData.diN() != null) {
            pbData.diN().nf(0);
            this.lLY = aj.dnE().dmg();
            this.lLW = aj.dnE().dnJ();
            this.lMa = aj.dnE().dnK();
            this.lMT = aj.dnE().dnI();
            this.lMU = aj.dnE().dnH();
            this.lMV = aj.dnE().dnG();
            this.lMX = aj.dnE().dnL();
            this.mTabIndex = aj.dnE().dnd();
            this.lMQ = this.lLW;
            if (this.lLW || this.isFromMark) {
                this.lMw = false;
            }
            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.lMA) {
            a(dmB(), true, this.lLT, 3);
        }
        if (i == 3 && !this.lMA) {
            if (this.isFromMark) {
                a(dmB(), true, this.lLT, 3);
            } else {
                a(dmB(), false, this.lLT, 3);
            }
        }
        this.lMA = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.lMZ == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.fyl);
        if (this.lLW || this.isFromMark) {
            this.lMw = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.lLR == null || this.lLR.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.lLR, 0L));
        if (com.baidu.tbadk.a.d.biN()) {
            pbPageRequestMessage.setFloorSortType(1);
            pbPageRequestMessage.setFloor_rn(com.baidu.tbadk.a.d.biW());
            pbPageRequestMessage.set_rn(15);
        } else {
            pbPageRequestMessage.set_rn(30);
        }
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.au.bsy().bsz() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.lLY) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.lLW) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.lMl) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.lMk));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.lMw) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.lMs, 0));
            pbPageRequestMessage.setOpMessageID(this.lMk);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> diP = this.lFA.diP();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lMf - 1));
                        if (this.lMf - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.lMi) {
                                if (diP != null && diP.size() > 0) {
                                    size = diP.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = diP.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.lLT = postData.getId();
                                            if (StringUtils.isNull(this.lLT)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.lMe + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.lLT == null && this.lLT.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lLT, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lMe + 1));
                        if (this.lMe >= this.lMg) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (diP != null) {
                                size = diP.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.lLT == null) {
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
                if (diP != null) {
                }
                if (this.lLT == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (diP != null && diP.size() > 0 && diP.get(0) != null) {
                    this.lLT = diP.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (dmW()) {
                        if (this.lMf - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.lMf - 1));
                        }
                    } else if (this.lMe < this.lMg) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lMe + 1));
                    }
                }
                if (this.lLT != null && this.lLT.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lLT, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.lLW) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (dmW()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.lMg > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lMg));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lLT, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.lMd));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.lMQ && !this.lLW) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lLT, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.lLW) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.lME);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lMS, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.lMQ = this.lLW;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(dmB());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.lMR));
        pbPageRequestMessage.setIsSubPostDataReverse(this.lMD);
        pbPageRequestMessage.setFromSmartFrs(this.lMG ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.lLV);
        if (this.lMR == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        if (this.lMR == 7 || this.lMR == 5 || this.lNg) {
            pbPageRequestMessage.setSourceType(1);
        } else {
            pbPageRequestMessage.setSourceType(2);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.lNf)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.lNf));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.lMg) {
                    i4 = -1;
                } else {
                    i4 = dne();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = dne();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.lLR);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean djV() {
        switch (dmP()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().diN() == null || !getPbData().diN().boX();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(djW()) && com.baidu.tieba.recapp.r.dBe().dAY() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dBe().dAY().ba(djW(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dBe().dAY().bb(djW(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(djW()) && com.baidu.tieba.recapp.r.dBe().dAY() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dBe().dAY().bb(djW(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dBe().dAY().ba(djW(), true));
        }
    }

    protected void Fz(int i) {
        boolean z = false;
        FE(i);
        ArrayList<PostData> diP = this.lFA.diP();
        this.lMz = false;
        if (i == 1) {
            boolean z2 = false;
            while (diP.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                diP.remove(0);
                z2 = true;
            }
            if (z2) {
                this.lFA.getPage().nb(1);
                if (this.lMr != null) {
                    this.lMr.e(this.lFA);
                }
            }
            this.jyL = System.currentTimeMillis();
            this.lMz = true;
        } else if (i == 2) {
            while (diP.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                diP.remove(diP.size() - 1);
                z = true;
            }
            if (z) {
                this.lFA.getPage().na(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.lMH = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.lMZ != null && this.lMZ.bLV()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.djf() != null && fVar.djf().dLa() != null && fVar.djf().dLa().goods != null && fVar.djf().bLV() && fVar.djf().dLa().goods.goods_style != 1001) {
            this.lMZ = fVar.djf();
        }
    }

    public com.baidu.tieba.tbadkCore.data.o dmt() {
        return this.lMZ;
    }

    public void dmu() {
        this.lMZ = null;
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
            if (this.lMp || this.lMn || this.lMo) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.diP().size(); i++) {
                PostData postData = fVar.diP().get(i);
                for (int i2 = 0; i2 < postData.dLj().size(); i2++) {
                    postData.dLj().get(i2).a(this.iEK.getPageContext(), o.equals(postData.dLj().get(i2).bnx().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r djb = fVar.djb();
            if (djb != null && !com.baidu.tbadk.core.util.x.isEmpty(djb.lCS)) {
                for (PostData postData2 : djb.lCS) {
                    for (int i3 = 0; i3 < postData2.dLj().size(); i3++) {
                        postData2.dLj().get(i3).a(this.iEK.getPageContext(), o.equals(postData2.dLj().get(i3).bnx().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r djb = fVar.djb();
            if (djb != null && !com.baidu.tbadk.core.util.x.isEmpty(djb.lCS)) {
                for (PostData postData : djb.lCS.subList(i, djb.lCS.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dLj().size()) {
                            postData.dLj().get(i3).a(this.iEK.getPageContext(), o.equals(postData.dLj().get(i3).bnx().getUserId()));
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
        bz diN = fVar.diN();
        diN.nk(this.mIsGood);
        diN.nj(this.lMb);
        if (this.lMc > 0) {
            diN.dG(this.lMc);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.diN() != null && fVar.diN().bnx() != null) {
            str = fVar.diN().bnx().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData dmv() {
        if (this.lFA == null || this.lFA.diN() == null || this.lFA.diN().bnx() == null) {
            return null;
        }
        return this.lFA.diN().bnx();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.lMF = z3;
        if (this.iFP != null && !z3) {
            this.iFP.a(z2, z4, i2, str, i3, j, j2);
            this.iFP = null;
        }
        if (this.lFA != null) {
            this.lFA.lCa = z3;
            this.lFA.aaq = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(djW()) && com.baidu.tieba.recapp.r.dBe().dAY() != null) {
            com.baidu.tieba.recapp.r.dBe().dAY().f(djW(), FA(dmE()), true);
        }
        if (fVar == null || (this.lMd == 1 && i == 5 && fVar.diP() != null && fVar.diP().size() < 1)) {
            if (this.lMr != null) {
                this.lLY = this.lLX;
                if (i2 != 350006) {
                    this.mSortType = this.lLZ;
                }
                this.lMr.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.lLX = this.lLY;
            if (i != 8) {
                this.lLZ = this.mSortType;
                this.mSortType = fVar.lBm;
            }
            if (fVar.lBl != null && fVar.lBl.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.iEK.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.lBl = new ArrayList();
                fVar.lBl.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.iEK.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.lBl.add(builder2.build(false));
                this.mSortType = this.lLZ;
                fVar.lBm = this.mSortType;
            }
            this.lMl = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.lMg = this.lMg < 1 ? 1 : this.lMg;
            int i6 = 0;
            ArrayList<PostData> diP = this.lFA.diP();
            switch (i) {
                case 1:
                    this.lFA.a(fVar.getPage(), 1);
                    d(fVar, diP);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.diP() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.diP().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(diP, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.getItem(fVar.diP(), com.baidu.tbadk.core.util.x.getCount(fVar.diP()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.diP().remove(postData2);
                            i5 = size2 - 1;
                        }
                        diP.addAll(0, fVar.diP());
                    }
                    p(fVar);
                    this.lFA.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().mY(fVar.getPage().bmh());
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
                    if (fVar != null && !com.baidu.tbadk.core.util.x.isEmpty(fVar.diP()) && this.lFA != null && (!this.lLW || o(fVar).equals(fVar.diP().get(0).bnx().getUserId()))) {
                        if (this.lFA.getPage().bmm() == 0) {
                            this.lFA.getPage().na(1);
                        }
                        dmQ();
                        this.lMT = fVar.diP().get(0);
                        if (dmW() || this.lFA.djq()) {
                            if (this.lFA.diP().size() - this.lMV >= 3) {
                                this.lMU = new PostData();
                                this.lMU.nno = true;
                                this.lMU.setPostType(53);
                                this.lFA.diP().add(this.lMU);
                            }
                            this.lFA.diP().add(this.lMT);
                            size = this.lFA.diP().size() - 1;
                        } else {
                            if (this.lMV - this.lMW >= 3) {
                                this.lMU = new PostData();
                                this.lMU.nno = false;
                                this.lMU.setPostType(53);
                                this.lFA.diP().add(0, this.lMU);
                            }
                            this.lFA.diP().add(0, this.lMT);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.at.isTaday(com.baidu.tbadk.core.sharedPref.b.brx().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.lMT.nnB = this.lFA.djo();
                            com.baidu.tbadk.core.sharedPref.b.brx().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.lFA != null && this.lFA.diN() != null) {
                PraiseData bni = this.lFA.diN().bni();
                if (this.lNk != null && !bni.isPriaseDataValid()) {
                    this.lFA.diN().a(this.lNk);
                } else {
                    this.lNk = this.lFA.diN().bni();
                    this.lNk.setPostId(this.lFA.diN().bnN());
                }
                if (fVar.getPage() != null && fVar.getPage().bmk() == 1 && fVar.diN() != null && fVar.diN().bnH() != null && fVar.diN().bnH().size() > 0) {
                    this.lFA.diN().z(fVar.diN().bnH());
                }
                this.lFA.diN().nh(fVar.diN().bno());
                this.lFA.diN().ne(fVar.diN().getAnchorLevel());
                this.lFA.diN().nf(fVar.diN().bne());
                if (this.mThreadType == 33) {
                    this.lFA.diN().bnx().setHadConcerned(fVar.diN().bnx().hadConcerned());
                }
                if (fVar != null && fVar.diN() != null) {
                    this.lFA.diN().nm(fVar.diN().bnL());
                }
            }
            if (this.lFA != null && this.lFA.getUserData() != null && fVar.getUserData() != null) {
                this.lFA.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.lFA.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().bmk() == 1 && fVar.dja() != null) {
                this.lFA.f(fVar.dja());
            }
            if (this.lMF) {
                if (this.lFA.diN() != null && this.lFA.diN().bnx() != null && this.lFA.diP() != null && com.baidu.tbadk.core.util.x.getItem(this.lFA.diP(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.getItem(this.lFA.diP(), 0);
                    MetaData bnx = this.lFA.diN().bnx();
                    if (postData3.bnx() != null && postData3.bnx().getGodUserData() != null) {
                        if (this.lMu != -1) {
                            bnx.setFansNum(this.lMu);
                            postData3.bnx().setFansNum(this.lMu);
                        }
                        if (this.lMv != -1) {
                            bnx.getGodUserData().setIsLike(this.lMv == 1);
                            postData3.bnx().getGodUserData().setIsLike(this.lMv == 1);
                            bnx.getGodUserData().setIsFromNetWork(false);
                            postData3.bnx().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.lFA.lBk = -1;
                this.lFA.lBj = -1;
            }
            if (this.lMr != null) {
                this.lMr.a(true, getErrorCode(), i, i4, this.lFA, this.mErrorString, 1);
            }
        }
        if (this.lFA != null && this.lFA.diN() != null && this.lFA.getForum() != null && !this.lFA.djq()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.iEK.getPageContext();
            historyMessage.threadId = getPbData().diN().getId();
            if (this.mIsShareThread && getPbData().diN().eQQ != null) {
                historyMessage.threadName = getPbData().diN().eQQ.showText;
            } else {
                historyMessage.threadName = getPbData().diN().getTitle();
            }
            if (this.mIsShareThread && !djV()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = dmg();
            historyMessage.threadType = getPbData().diN().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.lFA != null) {
            this.lFA.dje().clear();
            this.lFA.dje().addAll(fVar.dje());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aZ;
        if (arrayList != null && fVar.diP() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(fVar.diP(), 0);
            if (postData != null && (aZ = aZ(arrayList)) != null && aZ.equals(postData.getId())) {
                fVar.diP().remove(postData);
            }
            this.lFA.lBZ = arrayList.size();
            arrayList.addAll(fVar.diP());
        }
    }

    private int FA(int i) {
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

    private String aZ(ArrayList<PostData> arrayList) {
        int count = com.baidu.tbadk.core.util.x.getCount(arrayList);
        if (count <= 0) {
            return null;
        }
        for (int i = count - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    private void q(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            fVar.Ou(this.lFA.dji());
            if (!this.lFA.lBX && fVar.lBX && this.lFA.diX() != null) {
                fVar.e(this.lFA.diX());
            }
            this.lFA = fVar;
            Fx(fVar.getPage().bmk());
        }
    }

    public boolean dmw() {
        if (this.lLR == null || this.lLT == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return Fy(4);
        }
        return Fy(6);
    }

    public boolean uX(boolean z) {
        if (this.lLR == null || this.lFA == null) {
            return false;
        }
        if (z || this.lFA.getPage().bmm() != 0) {
            return Fy(1);
        }
        return false;
    }

    public boolean uY(boolean z) {
        if (this.lLR == null || this.lFA == null) {
            return false;
        }
        if ((z || this.lFA.getPage().bmn() != 0) && this.lFA.diP() != null && this.lFA.diP().size() >= 1) {
            return Fy(2);
        }
        return false;
    }

    public boolean OH(String str) {
        this.lLW = !this.lLW;
        this.lLT = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").an("obj_source", 0));
        if (Fy(6)) {
            return true;
        }
        this.lLW = this.lLW ? false : true;
        return false;
    }

    public boolean C(boolean z, String str) {
        if (this.lLW == z) {
            return false;
        }
        this.lLW = z;
        this.lLT = str;
        if (this.mSortType == 2) {
            this.lLT = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").an("obj_source", 1));
        }
        if (Fy(6)) {
            return true;
        }
        this.lLW = z ? false : true;
        return false;
    }

    public boolean FB(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_pb_current_sort_type", i);
        }
        this.lLX = this.lLY;
        this.lLZ = this.mSortType;
        this.mSortType = i;
        this.lLY = !this.lLY;
        if (i == 2 && this.isFromMark) {
            this.lLT = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.lLY = this.lLY ? false : true;
            this.mSortType = this.lLZ;
            return false;
        }
        return true;
    }

    public boolean dmx() {
        return dmW();
    }

    public int dmy() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.lFA == null || this.lFA.getForum() == null || this.lFA.diN() == null) ? false : true;
    }

    public boolean bjE() {
        if (this.lFA == null) {
            return false;
        }
        return this.lFA.bjE();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData CC(String str) {
        if (this.lFA == null || this.lFA.diN() == null || this.lFA.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.lFA.diN().boX()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.lFA.getForum().getId());
            writeData.setForumName(this.lFA.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.lMR);
        writeData.setThreadId(this.lLR);
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

    public MarkData FC(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.lFA == null) {
            return null;
        }
        ArrayList<PostData> diP = this.lFA.diP();
        if (com.baidu.tbadk.core.util.x.isEmpty(diP)) {
            return null;
        }
        if (diP.size() > 0 && i >= diP.size()) {
            i = diP.size() - 1;
        }
        return o(diP.get(i));
    }

    public MarkData dmz() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lLR);
        markData.setPostId(this.lFA.bjD());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lLW);
        markData.setSequence(Boolean.valueOf(dmW()));
        markData.setId(this.lLR);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lLR);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lLW);
        markData.setSequence(Boolean.valueOf(dmW()));
        markData.setId(this.lLR);
        markData.setFloor(postData.dLm());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.o) postData).isApp());
        }
        return markData;
    }

    public void dmA() {
        i.dkJ().aV(dmB(), this.isFromMark);
    }

    private String dmB() {
        String dmC = (this.lLR == null || this.lLR.equals("0")) ? dmC() : this.lLR;
        if (this.lLW) {
            dmC = dmC + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            dmC = dmC + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            dmC = dmC + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return dmC + TbadkCoreApplication.getCurrentAccount();
        }
        return dmC;
    }

    private String dmC() {
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

    public void uZ(boolean z) {
        if (this.lFA != null) {
            this.lFA.iY(z);
        }
    }

    public boolean dmD() {
        return this.lMw;
    }

    public void a(a aVar) {
        this.lMr = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bBr() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bBq() {
        return dms();
    }

    public boolean OI(String str) {
        if (getPbData() == null || getPbData().diN() == null || getPbData().diN().bnx() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().diN().bnx().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int dmE() {
        return this.mRequestType;
    }

    public void dmF() {
        if ("personalize_page".equals(this.mStType)) {
            this.lMC = System.currentTimeMillis() / 1000;
        }
    }

    public void dmG() {
        if ("personalize_page".equals(this.mStType) && this.lFA != null && this.lMC != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10754").dW("fid", this.lFA.getForumId()).dW("tid", this.lLR).dW("obj_duration", String.valueOf(currentTimeMillis - this.lMC)).dW(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.lMC = 0L;
        }
    }

    public boolean dmH() {
        return this.lMF;
    }

    public int getErrorNo() {
        return this.lMH;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public n dmI() {
        return this.lMJ;
    }

    public ab dmJ() {
        return this.lMK;
    }

    public CheckRealNameModel dmK() {
        return this.lMM;
    }

    public AddExperiencedModel dmL() {
        return this.lMN;
    }

    public String dmM() {
        return this.lMB;
    }

    public void OJ(String str) {
        this.lMB = str;
    }

    public boolean dmN() {
        return this.lMG;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lFA != null && this.lFA.diP() != null && this.lFA.diP().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lFA.diP().size();
                for (int i = 0; i < size; i++) {
                    if (this.lFA.diP().get(i) != null && this.lFA.diP().get(i).bnx() != null && currentAccount.equals(this.lFA.diP().get(i).bnx().getUserId()) && this.lFA.diP().get(i).bnx().getPendantData() != null) {
                        this.lFA.diP().get(i).bnx().getPendantData().zM(nVar.getImgUrl());
                        this.lFA.diP().get(i).bnx().getPendantData().ee(nVar.bAo());
                    }
                }
            }
        }
    }

    public String dmO() {
        return this.lML;
    }

    public int dmP() {
        return this.lMR;
    }

    public void FD(int i) {
        this.lMR = i;
    }

    public void OK(String str) {
        if ((!this.lLW || OI(TbadkCoreApplication.getCurrentAccount())) && this.lFA.diP() != null) {
            this.lFA.getPage().na(1);
            if (this.lFA.getPage().bmm() == 0) {
                this.lFA.getPage().na(1);
            }
            this.lMS = str;
            Fy(8);
        }
    }

    private void FE(int i) {
        if (i != 8) {
            this.lMS = "";
            if (this.lMT != null) {
                if (i == 1 && this.lFA != null && this.lFA.djq()) {
                    if (this.lMU != null) {
                        getPbData().diP().remove(this.lMU);
                    }
                } else if (i == 1 && !this.lLY && !com.baidu.tbadk.core.util.x.isEmpty(getPbData().diP())) {
                    getPbData().diP().remove(this.lMT);
                    if (this.lMU != null) {
                        getPbData().diP().remove(this.lMU);
                    }
                    getPbData().diP().add(0, this.lMT);
                } else {
                    getPbData().diP().remove(this.lMT);
                    if (this.lMU != null) {
                        getPbData().diP().remove(this.lMU);
                    }
                }
            }
            this.lMU = null;
        }
    }

    public void dmQ() {
        if (this.lFA != null && !com.baidu.tbadk.core.util.x.isEmpty(this.lFA.diP())) {
            if (this.lMU != null) {
                this.lFA.diP().remove(this.lMU);
                this.lMU = null;
            }
            if (this.lMT != null) {
                this.lFA.diP().remove(this.lMT);
                this.lMT = null;
            }
        }
    }

    public void dc(int i, int i2) {
        this.lMV = i;
        this.lMW = i2;
    }

    public PostData dmR() {
        return this.lMT;
    }

    public PostData dmS() {
        return this.lMU;
    }

    public int dmT() {
        return this.lMV;
    }

    public int dmU() {
        return this.lMW;
    }

    public String dmV() {
        return this.lMY;
    }

    public void OL(String str) {
        this.lMY = str;
    }

    private boolean dmW() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean dmX() {
        return this.lMR == 13 || this.lMR == 12 || this.lMR == 7 || this.lMR == 23;
    }

    public String dmY() {
        return this.lNb;
    }

    public String dmZ() {
        return this.lNc;
    }

    public String dna() {
        return this.lNd;
    }

    public String dnb() {
        return this.lNe;
    }

    public Rect dnc() {
        Rect rect = this.lMX;
        this.lMX = null;
        return rect;
    }

    public int dnd() {
        return this.mTabIndex;
    }

    private int dne() {
        int i;
        int i2 = 0;
        if (getPbData().diP() == null) {
            return 0;
        }
        ArrayList<PostData> diP = getPbData().diP();
        int size = diP.size() - 1;
        while (size >= 0) {
            PostData postData = diP.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
                if (postData.getType() != AdvertAppInfo.eIT) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return diP.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
