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
    private BaseFragmentActivity ixe;
    private com.baidu.tieba.tbadkCore.d.b iyj;
    private long jqV;
    protected com.baidu.tieba.pb.data.f lEP;
    private boolean lLA;
    private boolean lLB;
    private long lLC;
    private boolean lLD;
    private String lLE;
    private boolean lLF;
    private boolean lLG;
    private boolean lLH;
    private boolean lLI;
    private a lLJ;
    private String lLK;
    private String lLL;
    private int lLM;
    private int lLN;
    private boolean lLO;
    private boolean lLP;
    private boolean lLQ;
    private boolean lLR;
    private boolean lLS;
    private String lLT;
    private long lLU;
    private boolean lLV;
    private int lLW;
    private boolean lLX;
    private boolean lLY;
    private int lLZ;
    protected String lLj;
    private String lLk;
    private String lLl;
    private String lLm;
    private boolean lLn;
    private boolean lLo;
    private boolean lLp;
    private boolean lLq;
    private int lLr;
    private boolean lLs;
    private int lLt;
    private long lLu;
    private int lLv;
    private int lLw;
    private int lLx;
    private int lLy;
    private boolean lLz;
    private CustomMessageListener lMA;
    private com.baidu.adp.framework.listener.a lMB;
    private PraiseData lMC;
    private final ag lMa;
    private final q lMb;
    private final ai lMc;
    private String lMd;
    private final CheckRealNameModel lMe;
    private final AddExperiencedModel lMf;
    private SuggestEmotionModel lMg;
    private GetSugMatchWordsModel lMh;
    private boolean lMi;
    private int lMj;
    private String lMk;
    private PostData lMl;
    private PostData lMm;
    private int lMn;
    private int lMo;
    private Rect lMp;
    private String lMq;
    private com.baidu.tieba.tbadkCore.data.n lMr;
    private boolean lMs;
    private String lMt;
    private String lMu;
    private String lMv;
    private String lMw;
    private String lMx;
    private boolean lMy;
    private f.a lMz;
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
    private static final int lLi = com.baidu.tbadk.data.e.getPbListItemMaxNum() / 30;
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
        this.lLj = null;
        this.isPrivacy = false;
        this.lLk = null;
        this.lLl = null;
        this.mForumId = null;
        this.lLm = null;
        this.lLn = false;
        this.lLo = false;
        this.lLp = true;
        this.lLq = true;
        this.mSortType = 0;
        this.lLr = 0;
        this.lLs = false;
        this.mIsGood = 0;
        this.lLt = 0;
        this.lLu = 0L;
        this.lLv = 1;
        this.lLw = 1;
        this.lLx = 1;
        this.lLy = 1;
        this.isAd = false;
        this.eMG = false;
        this.eMh = false;
        this.lLz = false;
        this.isFromMark = false;
        this.lLA = false;
        this.lLB = false;
        this.lLC = 0L;
        this.lLD = false;
        this.lLE = null;
        this.lEP = null;
        this.isLoading = false;
        this.lLF = false;
        this.lLG = false;
        this.lLH = false;
        this.lLI = false;
        this.mLocate = null;
        this.mContext = null;
        this.lLJ = null;
        this.opType = null;
        this.opUrl = null;
        this.lLK = null;
        this.lLL = null;
        this.lLM = -1;
        this.lLN = -1;
        this.iyj = null;
        this.lLP = false;
        this.lLQ = false;
        this.postID = null;
        this.lLT = null;
        this.lLU = 0L;
        this.lLV = false;
        this.lLW = -1;
        this.lLY = false;
        this.lMi = false;
        this.lMj = 0;
        this.mTabIndex = 0;
        this.lMs = false;
        this.lMA = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.lMB = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.ixe.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.lLP || !PbModel.this.lLQ) {
                        if (!PbModel.this.lLP) {
                            PbModel.this.lLP = true;
                        } else {
                            PbModel.this.lLQ = true;
                        }
                        if (PbModel.this.lLJ != null) {
                            PbModel.this.lLJ.a(PbModel.this.dqf(), z, responsedMessage, PbModel.this.lLR, System.currentTimeMillis() - PbModel.this.jqV);
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
                    if (PbModel.this.lEP != null && PbModel.this.lEP.dmT() != null && PbModel.this.lEP.dmT().getForumId() != null && PbModel.this.lEP.dmT().getForumId().equals(valueOf)) {
                        PbModel.this.lEP.dmT().setIsLike(false);
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
                    if (PbModel.this.lEP != null && PbModel.this.lEP.dmT() != null && PbModel.this.lEP.dmT().getForumId() != null && PbModel.this.lEP.dmT().getForumId().equals(valueOf)) {
                        PbModel.this.lEP.dmT().setIsLike(true);
                    }
                }
            }
        };
        this.lMC = null;
        registerListener(this.lMB);
        registerListener(this.lMA);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.lEP = new com.baidu.tieba.pb.data.f();
        this.lEP.GP(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.ixe = baseFragmentActivity;
        this.lMa = new ag(this, this.ixe);
        this.lMb = new q(this, this.ixe);
        this.lMc = new ai(this, this.ixe);
        this.lMe = new CheckRealNameModel(this.ixe.getPageContext());
        this.lMg = new SuggestEmotionModel();
        this.lMf = new AddExperiencedModel(this.ixe.getPageContext());
        this.lMz = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void onCallBack(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.exc) instanceof String) {
                        PbModel.this.lLj = (String) hashMap.get(com.baidu.tbadk.BdToken.f.exc);
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
        this.lLS = true;
        if (fVar != null && fVar.lAN == null) {
            q(fVar);
            l(fVar);
            if (fVar.dmU() != null) {
                fVar.dmU().oB(0);
            }
            if (this.lLJ != null && fVar != null) {
                this.lLJ.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int dqf() {
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
            this.lLj = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.lMx = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            this.lMy = false;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                this.lMy = true;
                com.baidu.tbadk.BdToken.f.biX().c(uri, this.lMz);
            } else if (StringUtils.isNull(this.lLj)) {
                this.lMy = true;
                this.lMa.a(intent, this.lMz);
                if (uri != null) {
                    if (StringUtils.isNull(this.lLj)) {
                        this.lLj = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.au.isEmpty(this.lLj)) {
                this.lLj = "0";
            }
            this.lMj = intent.getIntExtra("key_start_from", 0);
            if (this.lMj == 0) {
                this.lMj = this.lMa.aLC;
            }
            this.lLl = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.lLk = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.lLn = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.lLo = intent.getBooleanExtra("host_only", false);
            this.lLq = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.lLl = this.mSortType == 2 ? "0" : this.lLl;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.lLt = intent.getIntExtra("is_top", 0);
            this.lLu = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.lLA = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.lLB = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.eMG = intent.getBooleanExtra("is_sub_pb", false);
            this.lLD = intent.getBooleanExtra("is_pv", false);
            this.lLC = intent.getLongExtra("msg_id", 0L);
            this.lLE = intent.getStringExtra("from_forum_name");
            this.lLL = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.lLK = intent.getStringExtra("op_stat");
            this.lLF = intent.getBooleanExtra("is_from_thread_config", false);
            this.lLG = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.lLH = intent.getBooleanExtra("is_from_my_god_config", false);
            this.lLN = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.lLM = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.eMh = intent.getBooleanExtra("from_frs", false);
            this.lLz = intent.getBooleanExtra("from_maintab", false);
            this.lLY = intent.getBooleanExtra("from_smart_frs", false);
            this.lLI = intent.getBooleanExtra("from_hottopic", false);
            this.lMd = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.lLm = intent.getStringExtra("high_light_post_id");
            this.lMs = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.lLO = intent.getIntExtra("request_code", -1) == 18003;
            this.lMt = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.lMu = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.lMv = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.lMw = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean dqg() {
        return this.lMs && com.baidu.tieba.frs.l.cBU() != null && com.baidu.tieba.frs.l.cBU().equals(this.lLj) && com.baidu.tieba.frs.l.cBT() != null;
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
        fVar.dmW().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.o(byVar, null));
        fVar.lAS = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.lMj = bundle.getInt("key_start_from", 0);
        this.lLj = bundle.getString("thread_id");
        this.lLl = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.lLk = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.lLn = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.lLo = bundle.getBoolean("host_only", false);
        this.lLq = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.lLt = bundle.getInt("is_top", 0);
        this.lLu = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.lLB = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eMG = bundle.getBoolean("is_sub_pb", false);
        this.lLD = bundle.getBoolean("is_pv", false);
        this.lLC = bundle.getLong("msg_id", 0L);
        this.lLE = bundle.getString("from_forum_name");
        this.lLL = bundle.getString("extra_pb_cache_key");
        this.lLF = bundle.getBoolean("is_from_thread_config", false);
        this.lLG = bundle.getBoolean("is_from_interview_live_config", false);
        this.lLH = bundle.getBoolean("is_from_my_god_config", false);
        this.lLN = bundle.getInt("extra_pb_is_attention_key", -1);
        this.lLM = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eMh = bundle.getBoolean("from_frs", false);
        this.lLz = bundle.getBoolean("from_maintab", false);
        this.lLY = bundle.getBoolean("from_smart_frs", false);
        this.lLI = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.lLm = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.lLO = bundle.getInt("request_code", -1) == 18003;
        this.lMt = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.lMu = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.lMv = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.lMw = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aD(Bundle bundle) {
        bundle.putString("thread_id", this.lLj);
        bundle.putString("post_id", this.lLl);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.lMj);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.lLn);
        bundle.putBoolean("host_only", this.lLo);
        bundle.putBoolean("squence", this.lLq);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.lLt);
        bundle.putLong("thread_time", this.lLu);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.lLB);
        bundle.putBoolean("is_sub_pb", this.eMG);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.lLD);
        bundle.putLong("msg_id", this.lLC);
        bundle.putString("extra_pb_cache_key", this.lLL);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.lLF);
        bundle.putBoolean("is_from_interview_live_config", this.lLG);
        bundle.putBoolean("is_from_my_god_config", this.lLH);
        bundle.putInt("extra_pb_is_attention_key", this.lLN);
        bundle.putInt("extra_pb_funs_count_key", this.lLM);
        bundle.putBoolean("from_frs", this.eMh);
        bundle.putBoolean("from_maintab", this.lLz);
        bundle.putBoolean("from_smart_frs", this.lLY);
        bundle.putBoolean("from_hottopic", this.lLI);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.lLm);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.lMt);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.lMu);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.lMv);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.lMw);
    }

    public String dqh() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.lLj);
        if (!this.lLB) {
            sb.append(this.lLl);
        }
        sb.append(this.lLo);
        sb.append(this.lLq);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.lLt);
        sb.append(this.lLu);
        sb.append(this.eMh);
        sb.append(this.lLz);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eMG);
        sb.append(this.lLD);
        sb.append(this.lLC);
        sb.append(this.lLE);
        sb.append(this.mThreadType);
        sb.append(this.lLF);
        sb.append(this.lLG);
        sb.append(this.lLH);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.lLL != null) {
            sb.append(this.lLL);
        }
        return sb.toString();
    }

    public String doe() {
        return this.lLE;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String dqi() {
        return this.lLl;
    }

    public String dqj() {
        return this.lLm;
    }

    public String dqk() {
        return this.lLj;
    }

    public String dql() {
        return (StringUtils.isNull(this.lLj) || "0".equals(this.lLj)) ? this.oriUgcNid : this.lLj;
    }

    public boolean getHostMode() {
        return this.lLo;
    }

    public boolean dqm() {
        return drc();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean dqn() {
        return this.eMh;
    }

    public boolean dqo() {
        return this.lLs;
    }

    public boolean dqp() {
        return this.lLz;
    }

    public boolean dqq() {
        return this.lLI;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean dqr() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int cuU() {
        return this.lLt;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void Hi(int i) {
        this.lLt = i;
    }

    public boolean dqs() {
        return this.eMG;
    }

    public boolean dqt() {
        if (this.lEP == null) {
            return false;
        }
        return this.lEP.isValid();
    }

    public String boX() {
        if (this.lEP == null || !this.lEP.bkY()) {
            return null;
        }
        return this.lEP.bkX();
    }

    public boolean Hj(int i) {
        this.lLv = i;
        if (this.lLv > this.lEP.getPage().bnA()) {
            this.lLv = this.lEP.getPage().bnA();
        }
        if (this.lLv < 1) {
            this.lLv = 1;
        }
        if (this.lLj == null) {
            return false;
        }
        return Hl(5);
    }

    public void Hk(int i) {
        this.lLv = i;
        this.lLw = i;
        this.lLx = i;
    }

    public void b(com.baidu.tbadk.core.data.ax axVar) {
        if (axVar == null) {
            Hk(1);
            return;
        }
        if (this.lLw < axVar.bnD()) {
            this.lLw = axVar.bnD();
        }
        if (this.lLx > axVar.bnD()) {
            this.lLx = axVar.bnD();
        }
        this.lLy = axVar.bnA();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.lEP;
    }

    public BaijiahaoData dqu() {
        if (this.lEP == null || this.lEP.dmU() == null) {
            return null;
        }
        return this.lEP.dmU().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f dqv() {
        if (this.lEP == null) {
            return this.lEP;
        }
        if (!dqw() && this.lMr != null) {
            this.lEP.b(this.lMr);
        }
        return this.lEP;
    }

    private boolean dqw() {
        return (this.lEP.dnm() == null || this.lEP.dnm().dOV() == null || this.lEP.dnm().dOV().goods != null || this.lEP.dnm().dOV().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.ax getPageData() {
        if (this.lEP == null) {
            return null;
        }
        return this.lEP.getPage();
    }

    public boolean dqx() {
        if (drc() && this.lEP.getPage().bnF() == 0) {
            va(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.lLj = fVar.getThreadId();
            if (fVar.dmU() != null && fVar.dmU().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.dmU().getBaijiahaoData();
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
            this.lLl = null;
            this.lLo = false;
            this.lLq = true;
            LoadData();
        }
    }

    public void Qd(String str) {
        if (!StringUtils.isNull(str)) {
            this.lLj = str;
            this.lLl = null;
            this.lLo = false;
            this.lLq = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lLj == null) {
            return false;
        }
        cancelLoadData();
        if (this.iyj == null) {
            this.iyj = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.iyj.start();
        }
        boolean Hl = Hl(3);
        if (this.opType != null) {
            this.opType = null;
            this.lLK = null;
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
        if (this.lMg != null) {
            this.lMg.cancelLoadData();
        }
        if (this.lMh != null) {
            this.lMh.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dGf().Sn("tag_pb_tab");
        cwt();
    }

    private void cwt() {
        if (this.iyj != null) {
            this.iyj.destory();
            this.iyj = null;
        }
    }

    public boolean dqy() {
        return (this.lLl == null || this.lLl.equals("0") || this.lLl.length() == 0) ? LoadData() : dqC();
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
                this.lMg.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.lMg.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.lMh == null) {
                this.lMh = new GetSugMatchWordsModel(this.ixe.getPageContext());
            }
            this.lMh.b(aVar);
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
        final com.baidu.tieba.pb.data.f pbData = as.drJ().getPbData();
        if (pbData != null && pbData.dmU() != null) {
            pbData.dmU().oB(0);
            this.lLq = as.drJ().dqm();
            this.lLo = as.drJ().drO();
            this.lLs = as.drJ().drP();
            this.lMl = as.drJ().drN();
            this.lMm = as.drJ().drM();
            this.lMn = as.drJ().drL();
            this.lMp = as.drJ().drQ();
            this.mTabIndex = as.drJ().drj();
            this.lMi = this.lLo;
            if (this.lLo || this.isFromMark) {
                this.lLO = false;
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
        if (i == 4 && !this.lLS) {
            a(dqH(), true, this.lLl, 3);
        }
        if (i == 3 && !this.lLS) {
            if (this.isFromMark) {
                a(dqH(), true, this.lLl, 3);
            } else {
                a(dqH(), false, this.lLl, 3);
            }
        }
        this.lLS = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.lMr == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.ftn);
        if (this.lLo || this.isFromMark) {
            this.lLO = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.lLj == null || this.lLj.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.lLj, 0L));
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
        if (!this.lLq) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.lLo) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.lLD) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.lLC));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.lLO) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.lLK, 0));
            pbPageRequestMessage.setOpMessageID(this.lLC);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> dmW = this.lEP.dmW();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lLx - 1));
                        if (this.lLx - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.lLA) {
                                if (dmW != null && dmW.size() > 0) {
                                    size = dmW.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = dmW.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.lLl = postData.getId();
                                            if (StringUtils.isNull(this.lLl)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.lLw + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.lLl == null && this.lLl.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lLl, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lLw + 1));
                        if (this.lLw >= this.lLy) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (dmW != null) {
                                size = dmW.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.lLl == null) {
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
                if (dmW != null) {
                }
                if (this.lLl == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (dmW != null && dmW.size() > 0 && dmW.get(0) != null) {
                    this.lLl = dmW.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (drc()) {
                        if (this.lLx - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.lLx - 1));
                        }
                    } else if (this.lLw < this.lLy) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lLw + 1));
                    }
                }
                if (this.lLl != null && this.lLl.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lLl, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.lLo) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (drc()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.lLy > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lLy));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lLl, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.lLv));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.lMi && !this.lLo) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lLl, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.lLo) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.lLW);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lMk, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.lMi = this.lLo;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(dqH());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.lMj));
        pbPageRequestMessage.setIsSubPostDataReverse(this.lLV);
        pbPageRequestMessage.setFromSmartFrs(this.lLY ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.lLn);
        if (this.lMj == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        if (this.lMj == 7 || this.lMj == 5 || this.lMy) {
            pbPageRequestMessage.setSourceType(1);
        } else {
            pbPageRequestMessage.setSourceType(2);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.lMx)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.lMx));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.lLy) {
                    i4 = -1;
                } else {
                    i4 = drk();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = drk();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.lLj);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean dod() {
        switch (dqV()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().dmU() == null || !getPbData().dmU().bqo();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(doe()) && com.baidu.tieba.recapp.r.dFg().dFa() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dFg().dFa().ba(doe(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dFg().dFa().bb(doe(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(doe()) && com.baidu.tieba.recapp.r.dFg().dFa() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dFg().dFa().bb(doe(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dFg().dFa().ba(doe(), true));
        }
    }

    protected void Hm(int i) {
        boolean z = false;
        Hr(i);
        ArrayList<PostData> dmW = this.lEP.dmW();
        this.lLR = false;
        if (i == 1) {
            boolean z2 = false;
            while (dmW.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dmW.remove(0);
                z2 = true;
            }
            if (z2) {
                this.lEP.getPage().ox(1);
                if (this.lLJ != null) {
                    this.lLJ.e(this.lEP);
                }
            }
            this.jqV = System.currentTimeMillis();
            this.lLR = true;
        } else if (i == 2) {
            while (dmW.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dmW.remove(dmW.size() - 1);
                z = true;
            }
            if (z) {
                this.lEP.getPage().ow(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.lLZ = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.lMr != null && this.lMr.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.t.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dnm() != null && fVar.dnm().dOV() != null && fVar.dnm().dOV().goods != null && fVar.dnm().isValidate() && fVar.dnm().dOV().goods.goods_style != 1001) {
            this.lMr = fVar.dnm();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n dqz() {
        return this.lMr;
    }

    public void dqA() {
        this.lMr = null;
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
            if (this.lLH || this.lLF || this.lLG) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.dmW().size(); i++) {
                PostData postData = fVar.dmW().get(i);
                for (int i2 = 0; i2 < postData.dPe().size(); i2++) {
                    postData.dPe().get(i2).a(this.ixe.getPageContext(), o.equals(postData.dPe().get(i2).boP().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r dni = fVar.dni();
            if (dni != null && !com.baidu.tbadk.core.util.y.isEmpty(dni.lCs)) {
                for (PostData postData2 : dni.lCs) {
                    for (int i3 = 0; i3 < postData2.dPe().size(); i3++) {
                        postData2.dPe().get(i3).a(this.ixe.getPageContext(), o.equals(postData2.dPe().get(i3).boP().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r dni = fVar.dni();
            if (dni != null && !com.baidu.tbadk.core.util.y.isEmpty(dni.lCs)) {
                for (PostData postData : dni.lCs.subList(i, dni.lCs.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dPe().size()) {
                            postData.dPe().get(i3).a(this.ixe.getPageContext(), o.equals(postData.dPe().get(i3).boP().getUserId()));
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
        by dmU = fVar.dmU();
        dmU.oG(this.mIsGood);
        dmU.oF(this.lLt);
        if (this.lLu > 0) {
            dmU.dG(this.lLu);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.dmU() != null && fVar.dmU().boP() != null) {
            str = fVar.dmU().boP().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData dqB() {
        if (this.lEP == null || this.lEP.dmU() == null || this.lEP.dmU().boP() == null) {
            return null;
        }
        return this.lEP.dmU().boP();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.lLX = z3;
        if (this.iyj != null && !z3) {
            this.iyj.a(z2, z4, i2, str, i3, j, j2);
            this.iyj = null;
        }
        if (this.lEP != null) {
            this.lEP.lBA = z3;
            this.lEP.ZJ = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(doe()) && com.baidu.tieba.recapp.r.dFg().dFa() != null) {
            com.baidu.tieba.recapp.r.dFg().dFa().f(doe(), Hn(dqK()), true);
        }
        if (fVar == null || (this.lLv == 1 && i == 5 && fVar.dmW() != null && fVar.dmW().size() < 1)) {
            if (this.lLJ != null) {
                this.lLq = this.lLp;
                if (i2 != 350006) {
                    this.mSortType = this.lLr;
                }
                this.lLJ.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.lLp = this.lLq;
            if (i != 8) {
                this.lLr = this.mSortType;
                this.mSortType = fVar.lAM;
            }
            if (fVar.lAL != null && fVar.lAL.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.ixe.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.lAL = new ArrayList();
                fVar.lAL.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.ixe.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.lAL.add(builder2.build(false));
                this.mSortType = this.lLr;
                fVar.lAM = this.mSortType;
            }
            this.lLD = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.lLy = this.lLy < 1 ? 1 : this.lLy;
            int i6 = 0;
            ArrayList<PostData> dmW = this.lEP.dmW();
            switch (i) {
                case 1:
                    this.lEP.a(fVar.getPage(), 1);
                    d(fVar, dmW);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.dmW() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.dmW().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dmW, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dmW(), com.baidu.tbadk.core.util.y.getCount(fVar.dmW()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.dmW().remove(postData2);
                            i5 = size2 - 1;
                        }
                        dmW.addAll(0, fVar.dmW());
                    }
                    p(fVar);
                    this.lEP.a(fVar.getPage(), 2);
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
                    if (fVar != null && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dmW()) && this.lEP != null && (!this.lLo || o(fVar).equals(fVar.dmW().get(0).boP().getUserId()))) {
                        if (this.lEP.getPage().bnF() == 0) {
                            this.lEP.getPage().ow(1);
                        }
                        dqW();
                        this.lMl = fVar.dmW().get(0);
                        if (drc() || this.lEP.dny()) {
                            if (this.lEP.dmW().size() - this.lMn >= 3) {
                                this.lMm = new PostData();
                                this.lMm.nmj = true;
                                this.lMm.setPostType(53);
                                this.lEP.dmW().add(this.lMm);
                            }
                            this.lEP.dmW().add(this.lMl);
                            size = this.lEP.dmW().size() - 1;
                        } else {
                            if (this.lMn - this.lMo >= 3) {
                                this.lMm = new PostData();
                                this.lMm.nmj = false;
                                this.lMm.setPostType(53);
                                this.lEP.dmW().add(0, this.lMm);
                            }
                            this.lEP.dmW().add(0, this.lMl);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.au.isTaday(com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.lMl.nmw = this.lEP.dnw();
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
            if (this.lEP != null && this.lEP.dmU() != null) {
                PraiseData boA = this.lEP.dmU().boA();
                if (this.lMC != null && !boA.isPriaseDataValid()) {
                    this.lEP.dmU().a(this.lMC);
                } else {
                    this.lMC = this.lEP.dmU().boA();
                    this.lMC.setPostId(this.lEP.dmU().bpg());
                }
                if (fVar.getPage() != null && fVar.getPage().bnD() == 1 && fVar.dmU() != null && fVar.dmU().boZ() != null && fVar.dmU().boZ().size() > 0) {
                    this.lEP.dmU().E(fVar.dmU().boZ());
                }
                this.lEP.dmU().oD(fVar.dmU().boG());
                this.lEP.dmU().oA(fVar.dmU().getAnchorLevel());
                this.lEP.dmU().oB(fVar.dmU().bow());
                if (this.mThreadType == 33) {
                    this.lEP.dmU().boP().setHadConcerned(fVar.dmU().boP().hadConcerned());
                }
                if (fVar != null && fVar.dmU() != null) {
                    this.lEP.dmU().oI(fVar.dmU().bpd());
                }
            }
            if (this.lEP != null && this.lEP.getUserData() != null && fVar.getUserData() != null) {
                this.lEP.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.lEP.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().bnD() == 1 && fVar.dnh() != null) {
                this.lEP.f(fVar.dnh());
            }
            if (this.lLX) {
                if (this.lEP.dmU() != null && this.lEP.dmU().boP() != null && this.lEP.dmW() != null && com.baidu.tbadk.core.util.y.getItem(this.lEP.dmW(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(this.lEP.dmW(), 0);
                    MetaData boP = this.lEP.dmU().boP();
                    if (postData3.boP() != null && postData3.boP().getGodUserData() != null) {
                        if (this.lLM != -1) {
                            boP.setFansNum(this.lLM);
                            postData3.boP().setFansNum(this.lLM);
                        }
                        if (this.lLN != -1) {
                            boP.getGodUserData().setIsLike(this.lLN == 1);
                            postData3.boP().getGodUserData().setIsLike(this.lLN == 1);
                            boP.getGodUserData().setIsFromNetWork(false);
                            postData3.boP().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.lEP.lAK = -1;
                this.lEP.lAJ = -1;
            }
            if (this.lLJ != null) {
                this.lLJ.a(true, getErrorCode(), i, i4, this.lEP, this.mErrorString, 1);
            }
        }
        if (this.lEP != null && this.lEP.dmU() != null && this.lEP.getForum() != null && !this.lEP.dny()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.ixe.getPageContext();
            historyMessage.threadId = getPbData().dmU().getId();
            if (this.mIsShareThread && getPbData().dmU().eLH != null) {
                historyMessage.threadName = getPbData().dmU().eLH.showText;
            } else {
                historyMessage.threadName = getPbData().dmU().getTitle();
            }
            if (this.mIsShareThread && !dod()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = dqm();
            historyMessage.threadType = getPbData().dmU().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.lEP != null) {
            this.lEP.dnl().clear();
            this.lEP.dnl().addAll(fVar.dnl());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String be;
        if (arrayList != null && fVar.dmW() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dmW(), 0);
            if (postData != null && (be = be(arrayList)) != null && be.equals(postData.getId())) {
                fVar.dmW().remove(postData);
            }
            this.lEP.lBz = arrayList.size();
            arrayList.addAll(fVar.dmW());
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
            fVar.PW(this.lEP.dnp());
            if (!this.lEP.lBx && fVar.lBx && this.lEP.dne() != null) {
                fVar.e(this.lEP.dne());
            }
            this.lEP = fVar;
            Hk(fVar.getPage().bnD());
        }
    }

    public boolean dqC() {
        if (this.lLj == null || this.lLl == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return Hl(4);
        }
        return Hl(6);
    }

    public boolean va(boolean z) {
        if (this.lLj == null || this.lEP == null) {
            return false;
        }
        if (z || this.lEP.getPage().bnF() != 0) {
            return Hl(1);
        }
        return false;
    }

    public boolean vb(boolean z) {
        if (this.lLj == null || this.lEP == null) {
            return false;
        }
        if ((z || this.lEP.getPage().bnG() != 0) && this.lEP.dmW() != null && this.lEP.dmW().size() >= 1) {
            return Hl(2);
        }
        return false;
    }

    public boolean Qj(String str) {
        this.lLo = !this.lLo;
        this.lLl = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("pb_onlyowner_click").al("obj_source", 0));
        if (Hl(6)) {
            return true;
        }
        this.lLo = this.lLo ? false : true;
        return false;
    }

    public boolean C(boolean z, String str) {
        if (this.lLo == z) {
            return false;
        }
        this.lLo = z;
        this.lLl = str;
        if (this.mSortType == 2) {
            this.lLl = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("pb_onlyowner_click").al("obj_source", 1));
        }
        if (Hl(6)) {
            return true;
        }
        this.lLo = z ? false : true;
        return false;
    }

    public boolean Ho(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_pb_current_sort_type", i);
        }
        this.lLp = this.lLq;
        this.lLr = this.mSortType;
        this.mSortType = i;
        this.lLq = !this.lLq;
        if (i == 2 && this.isFromMark) {
            this.lLl = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.lLq = this.lLq ? false : true;
            this.mSortType = this.lLr;
            return false;
        }
        return true;
    }

    public boolean dqD() {
        return drc();
    }

    public int dqE() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.lEP == null || this.lEP.getForum() == null || this.lEP.dmU() == null) ? false : true;
    }

    public boolean bkY() {
        if (this.lEP == null) {
            return false;
        }
        return this.lEP.bkY();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DR(String str) {
        if (this.lEP == null || this.lEP.dmU() == null || this.lEP.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.lEP.dmU().bqo()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.lEP.getForum().getId());
            writeData.setForumName(this.lEP.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.lMj);
        writeData.setThreadId(this.lLj);
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
        if (this.lEP == null) {
            return null;
        }
        ArrayList<PostData> dmW = this.lEP.dmW();
        if (com.baidu.tbadk.core.util.y.isEmpty(dmW)) {
            return null;
        }
        if (dmW.size() > 0 && i >= dmW.size()) {
            i = dmW.size() - 1;
        }
        return o(dmW.get(i));
    }

    public MarkData dqF() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lLj);
        markData.setPostId(this.lEP.bkX());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lLo);
        markData.setSequence(Boolean.valueOf(drc()));
        markData.setId(this.lLj);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lLj);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lLo);
        markData.setSequence(Boolean.valueOf(drc()));
        markData.setId(this.lLj);
        markData.setFloor(postData.dPh());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) postData).isApp());
        }
        return markData;
    }

    public void dqG() {
        j.doP().aV(dqH(), this.isFromMark);
    }

    private String dqH() {
        String dqI = (this.lLj == null || this.lLj.equals("0")) ? dqI() : this.lLj;
        if (this.lLo) {
            dqI = dqI + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            dqI = dqI + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            dqI = dqI + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return dqI + TbadkCoreApplication.getCurrentAccount();
        }
        return dqI;
    }

    private String dqI() {
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
        if (this.lEP != null) {
            this.lEP.iH(z);
        }
    }

    public boolean dqJ() {
        return this.lLO;
    }

    public void a(a aVar) {
        this.lLJ = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bCP() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bCO() {
        return dqy();
    }

    public boolean Qk(String str) {
        if (getPbData() == null || getPbData().dmU() == null || getPbData().dmU().boP() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().dmU().boP().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int dqK() {
        return this.mRequestType;
    }

    public void dqL() {
        if ("personalize_page".equals(this.mStType)) {
            this.lLU = System.currentTimeMillis() / 1000;
        }
    }

    public void dqM() {
        if ("personalize_page".equals(this.mStType) && this.lEP != null && this.lLU != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10754").dY("fid", this.lEP.getForumId()).dY("tid", this.lLj).dY("obj_duration", String.valueOf(currentTimeMillis - this.lLU)).dY(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.lLU = 0L;
        }
    }

    public boolean dqN() {
        return this.lLX;
    }

    public int getErrorNo() {
        return this.lLZ;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public q dqO() {
        return this.lMb;
    }

    public ai dqP() {
        return this.lMc;
    }

    public CheckRealNameModel dqQ() {
        return this.lMe;
    }

    public AddExperiencedModel dqR() {
        return this.lMf;
    }

    public String dqS() {
        return this.lLT;
    }

    public void Ql(String str) {
        this.lLT = str;
    }

    public boolean dqT() {
        return this.lLY;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lEP != null && this.lEP.dmW() != null && this.lEP.dmW().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lEP.dmW().size();
                for (int i = 0; i < size; i++) {
                    if (this.lEP.dmW().get(i) != null && this.lEP.dmW().get(i).boP() != null && currentAccount.equals(this.lEP.dmW().get(i).boP().getUserId()) && this.lEP.dmW().get(i).boP().getPendantData() != null) {
                        this.lEP.dmW().get(i).boP().getPendantData().AZ(nVar.bmL());
                        this.lEP.dmW().get(i).boP().getPendantData().ee(nVar.bBM());
                    }
                }
            }
        }
    }

    public String dqU() {
        return this.lMd;
    }

    public int dqV() {
        return this.lMj;
    }

    public void Hq(int i) {
        this.lMj = i;
    }

    public void Qm(String str) {
        if ((!this.lLo || Qk(TbadkCoreApplication.getCurrentAccount())) && this.lEP.dmW() != null) {
            this.lEP.getPage().ow(1);
            if (this.lEP.getPage().bnF() == 0) {
                this.lEP.getPage().ow(1);
            }
            this.lMk = str;
            Hl(8);
        }
    }

    private void Hr(int i) {
        if (i != 8) {
            this.lMk = "";
            if (this.lMl != null) {
                if (i == 1 && this.lEP != null && this.lEP.dny()) {
                    if (this.lMm != null) {
                        getPbData().dmW().remove(this.lMm);
                    }
                } else if (i == 1 && !this.lLq && !com.baidu.tbadk.core.util.y.isEmpty(getPbData().dmW())) {
                    getPbData().dmW().remove(this.lMl);
                    if (this.lMm != null) {
                        getPbData().dmW().remove(this.lMm);
                    }
                    getPbData().dmW().add(0, this.lMl);
                } else {
                    getPbData().dmW().remove(this.lMl);
                    if (this.lMm != null) {
                        getPbData().dmW().remove(this.lMm);
                    }
                }
            }
            this.lMm = null;
        }
    }

    public void dqW() {
        if (this.lEP != null && !com.baidu.tbadk.core.util.y.isEmpty(this.lEP.dmW())) {
            if (this.lMm != null) {
                this.lEP.dmW().remove(this.lMm);
                this.lMm = null;
            }
            if (this.lMl != null) {
                this.lEP.dmW().remove(this.lMl);
                this.lMl = null;
            }
        }
    }

    public void dg(int i, int i2) {
        this.lMn = i;
        this.lMo = i2;
    }

    public PostData dqX() {
        return this.lMl;
    }

    public PostData dqY() {
        return this.lMm;
    }

    public int dqZ() {
        return this.lMn;
    }

    public int dra() {
        return this.lMo;
    }

    public String drb() {
        return this.lMq;
    }

    public void Qn(String str) {
        this.lMq = str;
    }

    private boolean drc() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean drd() {
        return this.lMj == 13 || this.lMj == 12 || this.lMj == 7;
    }

    public String dre() {
        return this.lMt;
    }

    public String drf() {
        return this.lMu;
    }

    public String drg() {
        return this.lMv;
    }

    public String drh() {
        return this.lMw;
    }

    public Rect dri() {
        Rect rect = this.lMp;
        this.lMp = null;
        return rect;
    }

    public int drj() {
        return this.mTabIndex;
    }

    private int drk() {
        int i;
        int i2 = 0;
        if (getPbData().dmW() == null) {
            return 0;
        }
        ArrayList<PostData> dmW = getPbData().dmW();
        int size = dmW.size() - 1;
        while (size >= 0) {
            PostData postData = dmW.get(size);
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
        return dmW.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
