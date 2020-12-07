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
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
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
    private boolean eMG;
    private boolean eMh;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private BaseFragmentActivity ixc;
    private com.baidu.tieba.tbadkCore.d.b iyh;
    private long jqT;
    protected com.baidu.tieba.pb.data.f lEN;
    private long lLA;
    private boolean lLB;
    private String lLC;
    private boolean lLD;
    private boolean lLE;
    private boolean lLF;
    private boolean lLG;
    private a lLH;
    private String lLI;
    private String lLJ;
    private int lLK;
    private int lLL;
    private boolean lLM;
    private boolean lLN;
    private boolean lLO;
    private boolean lLP;
    private boolean lLQ;
    private String lLR;
    private long lLS;
    private boolean lLT;
    private int lLU;
    private boolean lLV;
    private boolean lLW;
    private int lLX;
    private final ag lLY;
    private final q lLZ;
    protected String lLh;
    private String lLi;
    private String lLj;
    private String lLk;
    private boolean lLl;
    private boolean lLm;
    private boolean lLn;
    private boolean lLo;
    private int lLp;
    private boolean lLq;
    private int lLr;
    private long lLs;
    private int lLt;
    private int lLu;
    private int lLv;
    private int lLw;
    private boolean lLx;
    private boolean lLy;
    private boolean lLz;
    private PraiseData lMA;
    private final ai lMa;
    private String lMb;
    private final CheckRealNameModel lMc;
    private final AddExperiencedModel lMd;
    private SuggestEmotionModel lMe;
    private GetSugMatchWordsModel lMf;
    private boolean lMg;
    private int lMh;
    private String lMi;
    private PostData lMj;
    private PostData lMk;
    private int lMl;
    private int lMm;
    private Rect lMn;
    private String lMo;
    private com.baidu.tieba.tbadkCore.data.n lMp;
    private boolean lMq;
    private String lMr;
    private String lMs;
    private String lMt;
    private String lMu;
    private String lMv;
    private boolean lMw;
    private f.a lMx;
    private CustomMessageListener lMy;
    private com.baidu.adp.framework.listener.a lMz;
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
    private static final int lLg = com.baidu.tbadk.data.e.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes22.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.f fVar);
    }

    public PbModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.mStType = null;
        this.lLh = null;
        this.isPrivacy = false;
        this.lLi = null;
        this.lLj = null;
        this.mForumId = null;
        this.lLk = null;
        this.lLl = false;
        this.lLm = false;
        this.lLn = true;
        this.lLo = true;
        this.mSortType = 0;
        this.lLp = 0;
        this.lLq = false;
        this.mIsGood = 0;
        this.lLr = 0;
        this.lLs = 0L;
        this.lLt = 1;
        this.lLu = 1;
        this.lLv = 1;
        this.lLw = 1;
        this.isAd = false;
        this.eMG = false;
        this.eMh = false;
        this.lLx = false;
        this.isFromMark = false;
        this.lLy = false;
        this.lLz = false;
        this.lLA = 0L;
        this.lLB = false;
        this.lLC = null;
        this.lEN = null;
        this.isLoading = false;
        this.lLD = false;
        this.lLE = false;
        this.lLF = false;
        this.lLG = false;
        this.mLocate = null;
        this.mContext = null;
        this.lLH = null;
        this.opType = null;
        this.opUrl = null;
        this.lLI = null;
        this.lLJ = null;
        this.lLK = -1;
        this.lLL = -1;
        this.iyh = null;
        this.lLN = false;
        this.lLO = false;
        this.postID = null;
        this.lLR = null;
        this.lLS = 0L;
        this.lLT = false;
        this.lLU = -1;
        this.lLW = false;
        this.lMg = false;
        this.lMh = 0;
        this.mTabIndex = 0;
        this.lMq = false;
        this.lMy = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.lMz = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.ixc.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.lLN || !PbModel.this.lLO) {
                        if (!PbModel.this.lLN) {
                            PbModel.this.lLN = true;
                        } else {
                            PbModel.this.lLO = true;
                        }
                        if (PbModel.this.lLH != null) {
                            PbModel.this.lLH.a(PbModel.this.dqe(), z, responsedMessage, PbModel.this.lLP, System.currentTimeMillis() - PbModel.this.jqT);
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
                    if (PbModel.this.lEN != null && PbModel.this.lEN.dmS() != null && PbModel.this.lEN.dmS().getForumId() != null && PbModel.this.lEN.dmS().getForumId().equals(valueOf)) {
                        PbModel.this.lEN.dmS().setIsLike(false);
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
                    if (PbModel.this.lEN != null && PbModel.this.lEN.dmS() != null && PbModel.this.lEN.dmS().getForumId() != null && PbModel.this.lEN.dmS().getForumId().equals(valueOf)) {
                        PbModel.this.lEN.dmS().setIsLike(true);
                    }
                }
            }
        };
        this.lMA = null;
        registerListener(this.lMz);
        registerListener(this.lMy);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.lEN = new com.baidu.tieba.pb.data.f();
        this.lEN.GP(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.ixc = baseFragmentActivity;
        this.lLY = new ag(this, this.ixc);
        this.lLZ = new q(this, this.ixc);
        this.lMa = new ai(this, this.ixc);
        this.lMc = new CheckRealNameModel(this.ixc.getPageContext());
        this.lMe = new SuggestEmotionModel();
        this.lMd = new AddExperiencedModel(this.ixc.getPageContext());
        this.lMx = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void onCallBack(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.exc) instanceof String) {
                        PbModel.this.lLh = (String) hashMap.get(com.baidu.tbadk.BdToken.f.exc);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.exd) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.exd);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.exe) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.exe);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.exf) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.exf), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.exg) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.exg);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.lLQ = true;
        if (fVar != null && fVar.lAL == null) {
            q(fVar);
            l(fVar);
            if (fVar.dmT() != null) {
                fVar.dmT().oB(0);
            }
            if (this.lLH != null && fVar != null) {
                this.lLH.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int dqe() {
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
            this.lLh = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.lMv = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            this.lMw = false;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                this.lMw = true;
                com.baidu.tbadk.BdToken.f.biX().c(uri, this.lMx);
            } else if (StringUtils.isNull(this.lLh)) {
                this.lMw = true;
                this.lLY.a(intent, this.lMx);
                if (uri != null) {
                    if (StringUtils.isNull(this.lLh)) {
                        this.lLh = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.au.isEmpty(this.lLh)) {
                this.lLh = "0";
            }
            this.lMh = intent.getIntExtra("key_start_from", 0);
            if (this.lMh == 0) {
                this.lMh = this.lLY.aLC;
            }
            this.lLj = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.lLi = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.lLl = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.lLm = intent.getBooleanExtra("host_only", false);
            this.lLo = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.lLj = this.mSortType == 2 ? "0" : this.lLj;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.lLr = intent.getIntExtra("is_top", 0);
            this.lLs = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.lLy = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.lLz = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.eMG = intent.getBooleanExtra("is_sub_pb", false);
            this.lLB = intent.getBooleanExtra("is_pv", false);
            this.lLA = intent.getLongExtra("msg_id", 0L);
            this.lLC = intent.getStringExtra("from_forum_name");
            this.lLJ = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.lLI = intent.getStringExtra("op_stat");
            this.lLD = intent.getBooleanExtra("is_from_thread_config", false);
            this.lLE = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.lLF = intent.getBooleanExtra("is_from_my_god_config", false);
            this.lLL = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.lLK = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.eMh = intent.getBooleanExtra("from_frs", false);
            this.lLx = intent.getBooleanExtra("from_maintab", false);
            this.lLW = intent.getBooleanExtra("from_smart_frs", false);
            this.lLG = intent.getBooleanExtra("from_hottopic", false);
            this.lMb = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.lLk = intent.getStringExtra("high_light_post_id");
            this.lMq = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.lLM = intent.getIntExtra("request_code", -1) == 18003;
            this.lMr = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.lMs = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.lMt = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.lMu = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean dqf() {
        return this.lMq && com.baidu.tieba.frs.l.cBT() != null && com.baidu.tieba.frs.l.cBT().equals(this.lLh) && com.baidu.tieba.frs.l.cBS() != null;
    }

    public com.baidu.tieba.pb.data.f aK(by byVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.GP(3);
        if (byVar == null) {
            return null;
        }
        fVar.aH(byVar);
        if (byVar.bqF() != null) {
            fVar.d(byVar.bqF());
            ForumData forum = fVar.getForum();
            forum.setId(byVar.bqF().getForumId());
            forum.setName(byVar.bqF().getForumName());
            forum.setUser_level(byVar.bqF().bof());
            forum.setImage_url(byVar.bqF().getAvatar());
            forum.setPost_num(byVar.bqF().postNum);
            forum.setMember_num(byVar.bqF().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(byVar.getFid()));
            forum2.setName(byVar.boT());
        }
        PostData postData = new PostData();
        postData.KV(1);
        postData.setTime(byVar.getCreateTime());
        postData.a(byVar.boP());
        MetaData boP = byVar.boP();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(boP.getUserId(), boP);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, byVar.boF(), false));
        fVar.d(postData);
        fVar.dmV().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.o(byVar, null));
        fVar.lAQ = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.lMh = bundle.getInt("key_start_from", 0);
        this.lLh = bundle.getString("thread_id");
        this.lLj = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.lLi = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.lLl = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.lLm = bundle.getBoolean("host_only", false);
        this.lLo = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.lLr = bundle.getInt("is_top", 0);
        this.lLs = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.lLz = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eMG = bundle.getBoolean("is_sub_pb", false);
        this.lLB = bundle.getBoolean("is_pv", false);
        this.lLA = bundle.getLong("msg_id", 0L);
        this.lLC = bundle.getString("from_forum_name");
        this.lLJ = bundle.getString("extra_pb_cache_key");
        this.lLD = bundle.getBoolean("is_from_thread_config", false);
        this.lLE = bundle.getBoolean("is_from_interview_live_config", false);
        this.lLF = bundle.getBoolean("is_from_my_god_config", false);
        this.lLL = bundle.getInt("extra_pb_is_attention_key", -1);
        this.lLK = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eMh = bundle.getBoolean("from_frs", false);
        this.lLx = bundle.getBoolean("from_maintab", false);
        this.lLW = bundle.getBoolean("from_smart_frs", false);
        this.lLG = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.lLk = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.lLM = bundle.getInt("request_code", -1) == 18003;
        this.lMr = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.lMs = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.lMt = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.lMu = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aD(Bundle bundle) {
        bundle.putString("thread_id", this.lLh);
        bundle.putString("post_id", this.lLj);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.lMh);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.lLl);
        bundle.putBoolean("host_only", this.lLm);
        bundle.putBoolean("squence", this.lLo);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.lLr);
        bundle.putLong("thread_time", this.lLs);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.lLz);
        bundle.putBoolean("is_sub_pb", this.eMG);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.lLB);
        bundle.putLong("msg_id", this.lLA);
        bundle.putString("extra_pb_cache_key", this.lLJ);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.lLD);
        bundle.putBoolean("is_from_interview_live_config", this.lLE);
        bundle.putBoolean("is_from_my_god_config", this.lLF);
        bundle.putInt("extra_pb_is_attention_key", this.lLL);
        bundle.putInt("extra_pb_funs_count_key", this.lLK);
        bundle.putBoolean("from_frs", this.eMh);
        bundle.putBoolean("from_maintab", this.lLx);
        bundle.putBoolean("from_smart_frs", this.lLW);
        bundle.putBoolean("from_hottopic", this.lLG);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.lLk);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.lMr);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.lMs);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.lMt);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.lMu);
    }

    public String dqg() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.lLh);
        if (!this.lLz) {
            sb.append(this.lLj);
        }
        sb.append(this.lLm);
        sb.append(this.lLo);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.lLr);
        sb.append(this.lLs);
        sb.append(this.eMh);
        sb.append(this.lLx);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eMG);
        sb.append(this.lLB);
        sb.append(this.lLA);
        sb.append(this.lLC);
        sb.append(this.mThreadType);
        sb.append(this.lLD);
        sb.append(this.lLE);
        sb.append(this.lLF);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.lLJ != null) {
            sb.append(this.lLJ);
        }
        return sb.toString();
    }

    public String dod() {
        return this.lLC;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String dqh() {
        return this.lLj;
    }

    public String dqi() {
        return this.lLk;
    }

    public String dqj() {
        return this.lLh;
    }

    public String dqk() {
        return (StringUtils.isNull(this.lLh) || "0".equals(this.lLh)) ? this.oriUgcNid : this.lLh;
    }

    public boolean getHostMode() {
        return this.lLm;
    }

    public boolean dql() {
        return drb();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean dqm() {
        return this.eMh;
    }

    public boolean dqn() {
        return this.lLq;
    }

    public boolean dqo() {
        return this.lLx;
    }

    public boolean dqp() {
        return this.lLG;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean dqq() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int cuT() {
        return this.lLr;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void Hi(int i) {
        this.lLr = i;
    }

    public boolean dqr() {
        return this.eMG;
    }

    public boolean dqs() {
        if (this.lEN == null) {
            return false;
        }
        return this.lEN.isValid();
    }

    public String boX() {
        if (this.lEN == null || !this.lEN.bkY()) {
            return null;
        }
        return this.lEN.bkX();
    }

    public boolean Hj(int i) {
        this.lLt = i;
        if (this.lLt > this.lEN.getPage().bnA()) {
            this.lLt = this.lEN.getPage().bnA();
        }
        if (this.lLt < 1) {
            this.lLt = 1;
        }
        if (this.lLh == null) {
            return false;
        }
        return Hl(5);
    }

    public void Hk(int i) {
        this.lLt = i;
        this.lLu = i;
        this.lLv = i;
    }

    public void b(com.baidu.tbadk.core.data.ax axVar) {
        if (axVar == null) {
            Hk(1);
            return;
        }
        if (this.lLu < axVar.bnD()) {
            this.lLu = axVar.bnD();
        }
        if (this.lLv > axVar.bnD()) {
            this.lLv = axVar.bnD();
        }
        this.lLw = axVar.bnA();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.lEN;
    }

    public BaijiahaoData dqt() {
        if (this.lEN == null || this.lEN.dmT() == null) {
            return null;
        }
        return this.lEN.dmT().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f dqu() {
        if (this.lEN == null) {
            return this.lEN;
        }
        if (!dqv() && this.lMp != null) {
            this.lEN.b(this.lMp);
        }
        return this.lEN;
    }

    private boolean dqv() {
        return (this.lEN.dnl() == null || this.lEN.dnl().dOU() == null || this.lEN.dnl().dOU().goods != null || this.lEN.dnl().dOU().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.ax getPageData() {
        if (this.lEN == null) {
            return null;
        }
        return this.lEN.getPage();
    }

    public boolean dqw() {
        if (drb() && this.lEN.getPage().bnF() == 0) {
            va(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.lLh = fVar.getThreadId();
            if (fVar.dmT() != null && fVar.dmT().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.dmT().getBaijiahaoData();
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
            this.lLj = null;
            this.lLm = false;
            this.lLo = true;
            LoadData();
        }
    }

    public void Qd(String str) {
        if (!StringUtils.isNull(str)) {
            this.lLh = str;
            this.lLj = null;
            this.lLm = false;
            this.lLo = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lLh == null) {
            return false;
        }
        cancelLoadData();
        if (this.iyh == null) {
            this.iyh = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.iyh.start();
        }
        boolean Hl = Hl(3);
        if (this.opType != null) {
            this.opType = null;
            this.lLI = null;
            this.opUrl = null;
            return Hl;
        }
        return Hl;
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
        if (this.lMe != null) {
            this.lMe.cancelLoadData();
        }
        if (this.lMf != null) {
            this.lMf.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dGe().Sn("tag_pb_tab");
        cws();
    }

    private void cws() {
        if (this.iyh != null) {
            this.iyh.destory();
            this.iyh = null;
        }
    }

    public boolean dqx() {
        return (this.lLj == null || this.lLj.equals("0") || this.lLj.length() == 0) ? LoadData() : dqB();
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
                this.lMe.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.lMe.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.lMf == null) {
                this.lMf = new GetSugMatchWordsModel(this.ixc.getPageContext());
            }
            this.lMf.b(aVar);
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
    public boolean Hl(int i) {
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
        Hm(i);
        final com.baidu.tieba.pb.data.f pbData = as.drI().getPbData();
        if (pbData != null && pbData.dmT() != null) {
            pbData.dmT().oB(0);
            this.lLo = as.drI().dql();
            this.lLm = as.drI().drN();
            this.lLq = as.drI().drO();
            this.lMj = as.drI().drM();
            this.lMk = as.drI().drL();
            this.lMl = as.drI().drK();
            this.lMn = as.drI().drP();
            this.mTabIndex = as.drI().dri();
            this.lMg = this.lLm;
            if (this.lLm || this.isFromMark) {
                this.lLM = false;
            }
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.lLQ) {
            a(dqG(), true, this.lLj, 3);
        }
        if (i == 3 && !this.lLQ) {
            if (this.isFromMark) {
                a(dqG(), true, this.lLj, 3);
            } else {
                a(dqG(), false, this.lLj, 3);
            }
        }
        this.lLQ = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.lMp == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.ftn);
        if (this.lLm || this.isFromMark) {
            this.lLM = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.lLh == null || this.lLh.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.lLh, 0L));
        if (com.baidu.tbadk.a.d.bks()) {
            pbPageRequestMessage.setFloorSortType(1);
            pbPageRequestMessage.setFloor_rn(com.baidu.tbadk.a.d.bkC());
            pbPageRequestMessage.set_rn(15);
        } else {
            pbPageRequestMessage.set_rn(30);
        }
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.av.btX().btY() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.lLo) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.lLm) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.lLB) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.lLA));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.lLM) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.lLI, 0));
            pbPageRequestMessage.setOpMessageID(this.lLA);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> dmV = this.lEN.dmV();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lLv - 1));
                        if (this.lLv - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.lLy) {
                                if (dmV != null && dmV.size() > 0) {
                                    size = dmV.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = dmV.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.lLj = postData.getId();
                                            if (StringUtils.isNull(this.lLj)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.lLu + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.lLj == null && this.lLj.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lLj, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lLu + 1));
                        if (this.lLu >= this.lLw) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (dmV != null) {
                                size = dmV.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.lLj == null) {
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
                if (dmV != null) {
                }
                if (this.lLj == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (dmV != null && dmV.size() > 0 && dmV.get(0) != null) {
                    this.lLj = dmV.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (drb()) {
                        if (this.lLv - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.lLv - 1));
                        }
                    } else if (this.lLu < this.lLw) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lLu + 1));
                    }
                }
                if (this.lLj != null && this.lLj.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lLj, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.lLm) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (drb()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.lLw > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lLw));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lLj, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.lLt));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.lMg && !this.lLm) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lLj, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.lLm) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.lLU);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lMi, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.lMg = this.lLm;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(dqG());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.lMh));
        pbPageRequestMessage.setIsSubPostDataReverse(this.lLT);
        pbPageRequestMessage.setFromSmartFrs(this.lLW ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.lLl);
        if (this.lMh == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        if (this.lMh == 7 || this.lMh == 5 || this.lMw) {
            pbPageRequestMessage.setSourceType(1);
        } else {
            pbPageRequestMessage.setSourceType(2);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.lMv)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.lMv));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.lLw) {
                    i4 = -1;
                } else {
                    i4 = drj();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = drj();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.lLh);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean doc() {
        switch (dqU()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().dmT() == null || !getPbData().dmT().bqo();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dod()) && com.baidu.tieba.recapp.r.dFf().dEZ() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dFf().dEZ().ba(dod(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dFf().dEZ().bb(dod(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dod()) && com.baidu.tieba.recapp.r.dFf().dEZ() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dFf().dEZ().bb(dod(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dFf().dEZ().ba(dod(), true));
        }
    }

    protected void Hm(int i) {
        boolean z = false;
        Hr(i);
        ArrayList<PostData> dmV = this.lEN.dmV();
        this.lLP = false;
        if (i == 1) {
            boolean z2 = false;
            while (dmV.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dmV.remove(0);
                z2 = true;
            }
            if (z2) {
                this.lEN.getPage().ox(1);
                if (this.lLH != null) {
                    this.lLH.e(this.lEN);
                }
            }
            this.jqT = System.currentTimeMillis();
            this.lLP = true;
        } else if (i == 2) {
            while (dmV.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dmV.remove(dmV.size() - 1);
                z = true;
            }
            if (z) {
                this.lEN.getPage().ow(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.lLX = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.lMp != null && this.lMp.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.t.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dnl() != null && fVar.dnl().dOU() != null && fVar.dnl().dOU().goods != null && fVar.dnl().isValidate() && fVar.dnl().dOU().goods.goods_style != 1001) {
            this.lMp = fVar.dnl();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n dqy() {
        return this.lMp;
    }

    public void dqz() {
        this.lMp = null;
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
            if (this.lLF || this.lLD || this.lLE) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.dmV().size(); i++) {
                PostData postData = fVar.dmV().get(i);
                for (int i2 = 0; i2 < postData.dPd().size(); i2++) {
                    postData.dPd().get(i2).a(this.ixc.getPageContext(), o.equals(postData.dPd().get(i2).boP().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r dnh = fVar.dnh();
            if (dnh != null && !com.baidu.tbadk.core.util.y.isEmpty(dnh.lCq)) {
                for (PostData postData2 : dnh.lCq) {
                    for (int i3 = 0; i3 < postData2.dPd().size(); i3++) {
                        postData2.dPd().get(i3).a(this.ixc.getPageContext(), o.equals(postData2.dPd().get(i3).boP().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r dnh = fVar.dnh();
            if (dnh != null && !com.baidu.tbadk.core.util.y.isEmpty(dnh.lCq)) {
                for (PostData postData : dnh.lCq.subList(i, dnh.lCq.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dPd().size()) {
                            postData.dPd().get(i3).a(this.ixc.getPageContext(), o.equals(postData.dPd().get(i3).boP().getUserId()));
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
        by dmT = fVar.dmT();
        dmT.oG(this.mIsGood);
        dmT.oF(this.lLr);
        if (this.lLs > 0) {
            dmT.dG(this.lLs);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.dmT() != null && fVar.dmT().boP() != null) {
            str = fVar.dmT().boP().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData dqA() {
        if (this.lEN == null || this.lEN.dmT() == null || this.lEN.dmT().boP() == null) {
            return null;
        }
        return this.lEN.dmT().boP();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.lLV = z3;
        if (this.iyh != null && !z3) {
            this.iyh.a(z2, z4, i2, str, i3, j, j2);
            this.iyh = null;
        }
        if (this.lEN != null) {
            this.lEN.lBy = z3;
            this.lEN.ZJ = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(dod()) && com.baidu.tieba.recapp.r.dFf().dEZ() != null) {
            com.baidu.tieba.recapp.r.dFf().dEZ().f(dod(), Hn(dqJ()), true);
        }
        if (fVar == null || (this.lLt == 1 && i == 5 && fVar.dmV() != null && fVar.dmV().size() < 1)) {
            if (this.lLH != null) {
                this.lLo = this.lLn;
                if (i2 != 350006) {
                    this.mSortType = this.lLp;
                }
                this.lLH.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.lLn = this.lLo;
            if (i != 8) {
                this.lLp = this.mSortType;
                this.mSortType = fVar.lAK;
            }
            if (fVar.lAJ != null && fVar.lAJ.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.ixc.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.lAJ = new ArrayList();
                fVar.lAJ.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.ixc.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.lAJ.add(builder2.build(false));
                this.mSortType = this.lLp;
                fVar.lAK = this.mSortType;
            }
            this.lLB = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.lLw = this.lLw < 1 ? 1 : this.lLw;
            int i6 = 0;
            ArrayList<PostData> dmV = this.lEN.dmV();
            switch (i) {
                case 1:
                    this.lEN.a(fVar.getPage(), 1);
                    d(fVar, dmV);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.dmV() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.dmV().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dmV, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dmV(), com.baidu.tbadk.core.util.y.getCount(fVar.dmV()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.dmV().remove(postData2);
                            i5 = size2 - 1;
                        }
                        dmV.addAll(0, fVar.dmV());
                    }
                    p(fVar);
                    this.lEN.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().ou(fVar.getPage().bnA());
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
                    if (fVar != null && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dmV()) && this.lEN != null && (!this.lLm || o(fVar).equals(fVar.dmV().get(0).boP().getUserId()))) {
                        if (this.lEN.getPage().bnF() == 0) {
                            this.lEN.getPage().ow(1);
                        }
                        dqV();
                        this.lMj = fVar.dmV().get(0);
                        if (drb() || this.lEN.dnx()) {
                            if (this.lEN.dmV().size() - this.lMl >= 3) {
                                this.lMk = new PostData();
                                this.lMk.nmh = true;
                                this.lMk.setPostType(53);
                                this.lEN.dmV().add(this.lMk);
                            }
                            this.lEN.dmV().add(this.lMj);
                            size = this.lEN.dmV().size() - 1;
                        } else {
                            if (this.lMl - this.lMm >= 3) {
                                this.lMk = new PostData();
                                this.lMk.nmh = false;
                                this.lMk.setPostType(53);
                                this.lEN.dmV().add(0, this.lMk);
                            }
                            this.lEN.dmV().add(0, this.lMj);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.au.isTaday(com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.lMj.nmu = this.lEN.dnv();
                            com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.lEN != null && this.lEN.dmT() != null) {
                PraiseData boA = this.lEN.dmT().boA();
                if (this.lMA != null && !boA.isPriaseDataValid()) {
                    this.lEN.dmT().a(this.lMA);
                } else {
                    this.lMA = this.lEN.dmT().boA();
                    this.lMA.setPostId(this.lEN.dmT().bpg());
                }
                if (fVar.getPage() != null && fVar.getPage().bnD() == 1 && fVar.dmT() != null && fVar.dmT().boZ() != null && fVar.dmT().boZ().size() > 0) {
                    this.lEN.dmT().E(fVar.dmT().boZ());
                }
                this.lEN.dmT().oD(fVar.dmT().boG());
                this.lEN.dmT().oA(fVar.dmT().getAnchorLevel());
                this.lEN.dmT().oB(fVar.dmT().bow());
                if (this.mThreadType == 33) {
                    this.lEN.dmT().boP().setHadConcerned(fVar.dmT().boP().hadConcerned());
                }
                if (fVar != null && fVar.dmT() != null) {
                    this.lEN.dmT().oI(fVar.dmT().bpd());
                }
            }
            if (this.lEN != null && this.lEN.getUserData() != null && fVar.getUserData() != null) {
                this.lEN.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.lEN.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().bnD() == 1 && fVar.dng() != null) {
                this.lEN.f(fVar.dng());
            }
            if (this.lLV) {
                if (this.lEN.dmT() != null && this.lEN.dmT().boP() != null && this.lEN.dmV() != null && com.baidu.tbadk.core.util.y.getItem(this.lEN.dmV(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(this.lEN.dmV(), 0);
                    MetaData boP = this.lEN.dmT().boP();
                    if (postData3.boP() != null && postData3.boP().getGodUserData() != null) {
                        if (this.lLK != -1) {
                            boP.setFansNum(this.lLK);
                            postData3.boP().setFansNum(this.lLK);
                        }
                        if (this.lLL != -1) {
                            boP.getGodUserData().setIsLike(this.lLL == 1);
                            postData3.boP().getGodUserData().setIsLike(this.lLL == 1);
                            boP.getGodUserData().setIsFromNetWork(false);
                            postData3.boP().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.lEN.lAI = -1;
                this.lEN.lAH = -1;
            }
            if (this.lLH != null) {
                this.lLH.a(true, getErrorCode(), i, i4, this.lEN, this.mErrorString, 1);
            }
        }
        if (this.lEN != null && this.lEN.dmT() != null && this.lEN.getForum() != null && !this.lEN.dnx()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.ixc.getPageContext();
            historyMessage.threadId = getPbData().dmT().getId();
            if (this.mIsShareThread && getPbData().dmT().eLH != null) {
                historyMessage.threadName = getPbData().dmT().eLH.showText;
            } else {
                historyMessage.threadName = getPbData().dmT().getTitle();
            }
            if (this.mIsShareThread && !doc()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = dql();
            historyMessage.threadType = getPbData().dmT().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.lEN != null) {
            this.lEN.dnk().clear();
            this.lEN.dnk().addAll(fVar.dnk());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String be;
        if (arrayList != null && fVar.dmV() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dmV(), 0);
            if (postData != null && (be = be(arrayList)) != null && be.equals(postData.getId())) {
                fVar.dmV().remove(postData);
            }
            this.lEN.lBx = arrayList.size();
            arrayList.addAll(fVar.dmV());
        }
    }

    private int Hn(int i) {
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

    private String be(ArrayList<PostData> arrayList) {
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
            fVar.PW(this.lEN.dno());
            if (!this.lEN.lBv && fVar.lBv && this.lEN.dnd() != null) {
                fVar.e(this.lEN.dnd());
            }
            this.lEN = fVar;
            Hk(fVar.getPage().bnD());
        }
    }

    public boolean dqB() {
        if (this.lLh == null || this.lLj == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return Hl(4);
        }
        return Hl(6);
    }

    public boolean va(boolean z) {
        if (this.lLh == null || this.lEN == null) {
            return false;
        }
        if (z || this.lEN.getPage().bnF() != 0) {
            return Hl(1);
        }
        return false;
    }

    public boolean vb(boolean z) {
        if (this.lLh == null || this.lEN == null) {
            return false;
        }
        if ((z || this.lEN.getPage().bnG() != 0) && this.lEN.dmV() != null && this.lEN.dmV().size() >= 1) {
            return Hl(2);
        }
        return false;
    }

    public boolean Qj(String str) {
        this.lLm = !this.lLm;
        this.lLj = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("pb_onlyowner_click").al("obj_source", 0));
        if (Hl(6)) {
            return true;
        }
        this.lLm = this.lLm ? false : true;
        return false;
    }

    public boolean C(boolean z, String str) {
        if (this.lLm == z) {
            return false;
        }
        this.lLm = z;
        this.lLj = str;
        if (this.mSortType == 2) {
            this.lLj = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("pb_onlyowner_click").al("obj_source", 1));
        }
        if (Hl(6)) {
            return true;
        }
        this.lLm = z ? false : true;
        return false;
    }

    public boolean Ho(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_pb_current_sort_type", i);
        }
        this.lLn = this.lLo;
        this.lLp = this.mSortType;
        this.mSortType = i;
        this.lLo = !this.lLo;
        if (i == 2 && this.isFromMark) {
            this.lLj = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.lLo = this.lLo ? false : true;
            this.mSortType = this.lLp;
            return false;
        }
        return true;
    }

    public boolean dqC() {
        return drb();
    }

    public int dqD() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.lEN == null || this.lEN.getForum() == null || this.lEN.dmT() == null) ? false : true;
    }

    public boolean bkY() {
        if (this.lEN == null) {
            return false;
        }
        return this.lEN.bkY();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DR(String str) {
        if (this.lEN == null || this.lEN.dmT() == null || this.lEN.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.lEN.dmT().bqo()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.lEN.getForum().getId());
            writeData.setForumName(this.lEN.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.lMh);
        writeData.setThreadId(this.lLh);
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

    public MarkData Hp(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.lEN == null) {
            return null;
        }
        ArrayList<PostData> dmV = this.lEN.dmV();
        if (com.baidu.tbadk.core.util.y.isEmpty(dmV)) {
            return null;
        }
        if (dmV.size() > 0 && i >= dmV.size()) {
            i = dmV.size() - 1;
        }
        return o(dmV.get(i));
    }

    public MarkData dqE() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lLh);
        markData.setPostId(this.lEN.bkX());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lLm);
        markData.setSequence(Boolean.valueOf(drb()));
        markData.setId(this.lLh);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lLh);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lLm);
        markData.setSequence(Boolean.valueOf(drb()));
        markData.setId(this.lLh);
        markData.setFloor(postData.dPg());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) postData).isApp());
        }
        return markData;
    }

    public void dqF() {
        j.doO().aV(dqG(), this.isFromMark);
    }

    private String dqG() {
        String dqH = (this.lLh == null || this.lLh.equals("0")) ? dqH() : this.lLh;
        if (this.lLm) {
            dqH = dqH + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            dqH = dqH + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            dqH = dqH + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return dqH + TbadkCoreApplication.getCurrentAccount();
        }
        return dqH;
    }

    private String dqH() {
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

    public void vc(boolean z) {
        if (this.lEN != null) {
            this.lEN.iH(z);
        }
    }

    public boolean dqI() {
        return this.lLM;
    }

    public void a(a aVar) {
        this.lLH = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bCP() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bCO() {
        return dqx();
    }

    public boolean Qk(String str) {
        if (getPbData() == null || getPbData().dmT() == null || getPbData().dmT().boP() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().dmT().boP().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int dqJ() {
        return this.mRequestType;
    }

    public void dqK() {
        if ("personalize_page".equals(this.mStType)) {
            this.lLS = System.currentTimeMillis() / 1000;
        }
    }

    public void dqL() {
        if ("personalize_page".equals(this.mStType) && this.lEN != null && this.lLS != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10754").dY("fid", this.lEN.getForumId()).dY("tid", this.lLh).dY("obj_duration", String.valueOf(currentTimeMillis - this.lLS)).dY(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.lLS = 0L;
        }
    }

    public boolean dqM() {
        return this.lLV;
    }

    public int getErrorNo() {
        return this.lLX;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public q dqN() {
        return this.lLZ;
    }

    public ai dqO() {
        return this.lMa;
    }

    public CheckRealNameModel dqP() {
        return this.lMc;
    }

    public AddExperiencedModel dqQ() {
        return this.lMd;
    }

    public String dqR() {
        return this.lLR;
    }

    public void Ql(String str) {
        this.lLR = str;
    }

    public boolean dqS() {
        return this.lLW;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lEN != null && this.lEN.dmV() != null && this.lEN.dmV().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lEN.dmV().size();
                for (int i = 0; i < size; i++) {
                    if (this.lEN.dmV().get(i) != null && this.lEN.dmV().get(i).boP() != null && currentAccount.equals(this.lEN.dmV().get(i).boP().getUserId()) && this.lEN.dmV().get(i).boP().getPendantData() != null) {
                        this.lEN.dmV().get(i).boP().getPendantData().AZ(nVar.bmL());
                        this.lEN.dmV().get(i).boP().getPendantData().ee(nVar.bBM());
                    }
                }
            }
        }
    }

    public String dqT() {
        return this.lMb;
    }

    public int dqU() {
        return this.lMh;
    }

    public void Hq(int i) {
        this.lMh = i;
    }

    public void Qm(String str) {
        if ((!this.lLm || Qk(TbadkCoreApplication.getCurrentAccount())) && this.lEN.dmV() != null) {
            this.lEN.getPage().ow(1);
            if (this.lEN.getPage().bnF() == 0) {
                this.lEN.getPage().ow(1);
            }
            this.lMi = str;
            Hl(8);
        }
    }

    private void Hr(int i) {
        if (i != 8) {
            this.lMi = "";
            if (this.lMj != null) {
                if (i == 1 && this.lEN != null && this.lEN.dnx()) {
                    if (this.lMk != null) {
                        getPbData().dmV().remove(this.lMk);
                    }
                } else if (i == 1 && !this.lLo && !com.baidu.tbadk.core.util.y.isEmpty(getPbData().dmV())) {
                    getPbData().dmV().remove(this.lMj);
                    if (this.lMk != null) {
                        getPbData().dmV().remove(this.lMk);
                    }
                    getPbData().dmV().add(0, this.lMj);
                } else {
                    getPbData().dmV().remove(this.lMj);
                    if (this.lMk != null) {
                        getPbData().dmV().remove(this.lMk);
                    }
                }
            }
            this.lMk = null;
        }
    }

    public void dqV() {
        if (this.lEN != null && !com.baidu.tbadk.core.util.y.isEmpty(this.lEN.dmV())) {
            if (this.lMk != null) {
                this.lEN.dmV().remove(this.lMk);
                this.lMk = null;
            }
            if (this.lMj != null) {
                this.lEN.dmV().remove(this.lMj);
                this.lMj = null;
            }
        }
    }

    public void dg(int i, int i2) {
        this.lMl = i;
        this.lMm = i2;
    }

    public PostData dqW() {
        return this.lMj;
    }

    public PostData dqX() {
        return this.lMk;
    }

    public int dqY() {
        return this.lMl;
    }

    public int dqZ() {
        return this.lMm;
    }

    public String dra() {
        return this.lMo;
    }

    public void Qn(String str) {
        this.lMo = str;
    }

    private boolean drb() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean drc() {
        return this.lMh == 13 || this.lMh == 12 || this.lMh == 7;
    }

    public String drd() {
        return this.lMr;
    }

    public String dre() {
        return this.lMs;
    }

    public String drf() {
        return this.lMt;
    }

    public String drg() {
        return this.lMu;
    }

    public Rect drh() {
        Rect rect = this.lMn;
        this.lMn = null;
        return rect;
    }

    public int dri() {
        return this.mTabIndex;
    }

    private int drj() {
        int i;
        int i2 = 0;
        if (getPbData().dmV() == null) {
            return 0;
        }
        ArrayList<PostData> dmV = getPbData().dmV();
        int size = dmV.size() - 1;
        while (size >= 0) {
            PostData postData = dmV.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
                if (postData.getType() != AdvertAppInfo.eDR) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return dmV.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
