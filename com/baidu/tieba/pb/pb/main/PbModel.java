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
import com.baidu.tbadk.core.data.bw;
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
/* loaded from: classes16.dex */
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
    private boolean eei;
    private BaseFragmentActivity hwW;
    private com.baidu.tieba.tbadkCore.d.b hyf;
    private long iob;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private boolean jGt;
    protected com.baidu.tieba.pb.data.f kAH;
    protected String kGR;
    private String kGS;
    private String kGT;
    private String kGU;
    private boolean kGV;
    private boolean kGW;
    private boolean kGX;
    private boolean kGY;
    private int kGZ;
    private boolean kHA;
    private String kHB;
    private long kHC;
    private boolean kHD;
    private int kHE;
    private boolean kHF;
    private boolean kHG;
    private int kHH;
    private final ag kHI;
    private final q kHJ;
    private final ai kHK;
    private String kHL;
    private final CheckRealNameModel kHM;
    private final AddExperiencedModel kHN;
    private SuggestEmotionModel kHO;
    private GetSugMatchWordsModel kHP;
    private boolean kHQ;
    private int kHR;
    private String kHS;
    private PostData kHT;
    private PostData kHU;
    private int kHV;
    private int kHW;
    private Rect kHX;
    private String kHY;
    private com.baidu.tieba.tbadkCore.data.n kHZ;
    private boolean kHa;
    private int kHb;
    private long kHc;
    private int kHd;
    private int kHe;
    private int kHf;
    private int kHg;
    private boolean kHh;
    private boolean kHi;
    private boolean kHj;
    private long kHk;
    private boolean kHl;
    private String kHm;
    private boolean kHn;
    private boolean kHo;
    private boolean kHp;
    private boolean kHq;
    private a kHr;
    private String kHs;
    private String kHt;
    private int kHu;
    private int kHv;
    private boolean kHw;
    private boolean kHx;
    private boolean kHy;
    private boolean kHz;
    private boolean kIa;
    private String kIb;
    private String kIc;
    private String kId;
    private String kIe;
    private String kIf;
    private f.a kIg;
    private CustomMessageListener kIh;
    private com.baidu.adp.framework.listener.a kIi;
    private PraiseData kIj;
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
    private static final int kGQ = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes16.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.f fVar);
    }

    public PbModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.mStType = null;
        this.kGR = null;
        this.isPrivacy = false;
        this.kGS = null;
        this.kGT = null;
        this.mForumId = null;
        this.kGU = null;
        this.kGV = false;
        this.kGW = false;
        this.kGX = true;
        this.kGY = true;
        this.mSortType = 0;
        this.kGZ = 0;
        this.kHa = false;
        this.mIsGood = 0;
        this.kHb = 0;
        this.kHc = 0L;
        this.kHd = 1;
        this.kHe = 1;
        this.kHf = 1;
        this.kHg = 1;
        this.isAd = false;
        this.jGt = false;
        this.eei = false;
        this.kHh = false;
        this.isFromMark = false;
        this.kHi = false;
        this.kHj = false;
        this.kHk = 0L;
        this.kHl = false;
        this.kHm = null;
        this.kAH = null;
        this.isLoading = false;
        this.kHn = false;
        this.kHo = false;
        this.kHp = false;
        this.kHq = false;
        this.mLocate = null;
        this.mContext = null;
        this.kHr = null;
        this.opType = null;
        this.opUrl = null;
        this.kHs = null;
        this.kHt = null;
        this.kHu = -1;
        this.kHv = -1;
        this.hyf = null;
        this.kHx = false;
        this.kHy = false;
        this.postID = null;
        this.kHB = null;
        this.kHC = 0L;
        this.kHD = false;
        this.kHE = -1;
        this.kHG = false;
        this.kHQ = false;
        this.kHR = 0;
        this.mTabIndex = 0;
        this.kIa = false;
        this.kIh = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.kIi = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.hwW.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.kHx || !PbModel.this.kHy) {
                        if (!PbModel.this.kHx) {
                            PbModel.this.kHx = true;
                        } else {
                            PbModel.this.kHy = true;
                        }
                        if (PbModel.this.kHr != null) {
                            PbModel.this.kHr.a(PbModel.this.cYx(), z, responsedMessage, PbModel.this.kHz, System.currentTimeMillis() - PbModel.this.iob);
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
                    if (PbModel.this.kAH != null && PbModel.this.kAH.cVl() != null && PbModel.this.kAH.cVl().getForumId() != null && PbModel.this.kAH.cVl().getForumId().equals(valueOf)) {
                        PbModel.this.kAH.cVl().setIsLike(false);
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
                    if (PbModel.this.kAH != null && PbModel.this.kAH.cVl() != null && PbModel.this.kAH.cVl().getForumId() != null && PbModel.this.kAH.cVl().getForumId().equals(valueOf)) {
                        PbModel.this.kAH.cVl().setIsLike(true);
                    }
                }
            }
        };
        this.kIj = null;
        registerListener(this.kIi);
        registerListener(this.kIh);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.kAH = new com.baidu.tieba.pb.data.f();
        this.kAH.DP(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.hwW = baseFragmentActivity;
        this.kHI = new ag(this, this.hwW);
        this.kHJ = new q(this, this.hwW);
        this.kHK = new ai(this, this.hwW);
        this.kHM = new CheckRealNameModel(this.hwW.getPageContext());
        this.kHO = new SuggestEmotionModel();
        this.kHN = new AddExperiencedModel(this.hwW.getPageContext());
        this.kIg = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void z(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dPk) instanceof String) {
                        PbModel.this.kGR = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dPk);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dPl) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dPl);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dPm) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dPm);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dPn) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.dPn), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dPo) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dPo);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.kHA = true;
        if (fVar != null && fVar.kwQ == null) {
            q(fVar);
            l(fVar);
            if (fVar.cVm() != null) {
                fVar.cVm().ne(0);
            }
            if (this.kHr != null && fVar != null) {
                this.kHr.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int cYx() {
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
            this.kGR = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.kIf = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                com.baidu.tbadk.BdToken.f.aYL().c(uri, this.kIg);
            } else if (StringUtils.isNull(this.kGR)) {
                this.kHI.a(intent, this.kIg);
                if (uri != null) {
                    if (StringUtils.isNull(this.kGR)) {
                        this.kGR = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.at.isEmpty(this.kGR)) {
                this.kGR = "0";
            }
            this.kHR = intent.getIntExtra("key_start_from", 0);
            if (this.kHR == 0) {
                this.kHR = this.kHI.aED;
            }
            this.kGT = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.kGS = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.kGV = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.kGW = intent.getBooleanExtra("host_only", false);
            this.kGY = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.kGT = this.mSortType == 2 ? "0" : this.kGT;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.kHb = intent.getIntExtra("is_top", 0);
            this.kHc = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.kHi = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.kHj = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.jGt = intent.getBooleanExtra("is_sub_pb", false);
            this.kHl = intent.getBooleanExtra("is_pv", false);
            this.kHk = intent.getLongExtra("msg_id", 0L);
            this.kHm = intent.getStringExtra("from_forum_name");
            this.kHt = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.kHs = intent.getStringExtra("op_stat");
            this.kHn = intent.getBooleanExtra("is_from_thread_config", false);
            this.kHo = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.kHp = intent.getBooleanExtra("is_from_my_god_config", false);
            this.kHv = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.kHu = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.eei = intent.getBooleanExtra("from_frs", false);
            this.kHh = intent.getBooleanExtra("from_maintab", false);
            this.kHG = intent.getBooleanExtra("from_smart_frs", false);
            this.kHq = intent.getBooleanExtra("from_hottopic", false);
            this.kHL = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.kGU = intent.getStringExtra("high_light_post_id");
            this.kIa = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.kHw = intent.getIntExtra("request_code", -1) == 18003;
            this.kIb = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.kIc = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.kId = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.kIe = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean cYy() {
        return this.kIa && com.baidu.tieba.frs.l.clI() != null && com.baidu.tieba.frs.l.clI().equals(this.kGR) && com.baidu.tieba.frs.l.clH() != null;
    }

    public com.baidu.tieba.pb.data.f aH(bw bwVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.DP(3);
        if (bwVar == null) {
            return null;
        }
        fVar.aE(bwVar);
        if (bwVar.bgs() != null) {
            fVar.d(bwVar.bgs());
            ForumData forum = fVar.getForum();
            forum.setId(bwVar.bgs().getForumId());
            forum.setName(bwVar.bgs().getForumName());
            forum.setUser_level(bwVar.bgs().bdU());
            forum.setImage_url(bwVar.bgs().getAvatar());
            forum.setPost_num(bwVar.bgs().postNum);
            forum.setMember_num(bwVar.bgs().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(bwVar.getFid()));
            forum2.setName(bwVar.beI());
        }
        PostData postData = new PostData();
        postData.HP(1);
        postData.setTime(bwVar.getCreateTime());
        postData.a(bwVar.beE());
        MetaData beE = bwVar.beE();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(beE.getUserId(), beE);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bwVar.beu(), false));
        fVar.d(postData);
        fVar.cVo().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.o(bwVar, null));
        fVar.kwV = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.kHR = bundle.getInt("key_start_from", 0);
        this.kGR = bundle.getString("thread_id");
        this.kGT = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.kGS = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.kGV = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.kGW = bundle.getBoolean("host_only", false);
        this.kGY = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.kHb = bundle.getInt("is_top", 0);
        this.kHc = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.kHj = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.jGt = bundle.getBoolean("is_sub_pb", false);
        this.kHl = bundle.getBoolean("is_pv", false);
        this.kHk = bundle.getLong("msg_id", 0L);
        this.kHm = bundle.getString("from_forum_name");
        this.kHt = bundle.getString("extra_pb_cache_key");
        this.kHn = bundle.getBoolean("is_from_thread_config", false);
        this.kHo = bundle.getBoolean("is_from_interview_live_config", false);
        this.kHp = bundle.getBoolean("is_from_my_god_config", false);
        this.kHv = bundle.getInt("extra_pb_is_attention_key", -1);
        this.kHu = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eei = bundle.getBoolean("from_frs", false);
        this.kHh = bundle.getBoolean("from_maintab", false);
        this.kHG = bundle.getBoolean("from_smart_frs", false);
        this.kHq = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.kGU = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.kHw = bundle.getInt("request_code", -1) == 18003;
        this.kIb = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.kIc = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.kId = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.kIe = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aC(Bundle bundle) {
        bundle.putString("thread_id", this.kGR);
        bundle.putString("post_id", this.kGT);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.kHR);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.kGV);
        bundle.putBoolean("host_only", this.kGW);
        bundle.putBoolean("squence", this.kGY);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.kHb);
        bundle.putLong("thread_time", this.kHc);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.kHj);
        bundle.putBoolean("is_sub_pb", this.jGt);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.kHl);
        bundle.putLong("msg_id", this.kHk);
        bundle.putString("extra_pb_cache_key", this.kHt);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.kHn);
        bundle.putBoolean("is_from_interview_live_config", this.kHo);
        bundle.putBoolean("is_from_my_god_config", this.kHp);
        bundle.putInt("extra_pb_is_attention_key", this.kHv);
        bundle.putInt("extra_pb_funs_count_key", this.kHu);
        bundle.putBoolean("from_frs", this.eei);
        bundle.putBoolean("from_maintab", this.kHh);
        bundle.putBoolean("from_smart_frs", this.kHG);
        bundle.putBoolean("from_hottopic", this.kHq);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.kGU);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.kIb);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.kIc);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.kId);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.kIe);
    }

    public String cYz() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.kGR);
        if (!this.kHj) {
            sb.append(this.kGT);
        }
        sb.append(this.kGW);
        sb.append(this.kGY);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.kHb);
        sb.append(this.kHc);
        sb.append(this.eei);
        sb.append(this.kHh);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.jGt);
        sb.append(this.kHl);
        sb.append(this.kHk);
        sb.append(this.kHm);
        sb.append(this.mThreadType);
        sb.append(this.kHn);
        sb.append(this.kHo);
        sb.append(this.kHp);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.kHt != null) {
            sb.append(this.kHt);
        }
        return sb.toString();
    }

    public String cWv() {
        return this.kHm;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cYA() {
        return this.kGT;
    }

    public String cYB() {
        return this.kGU;
    }

    public String cYC() {
        return this.kGR;
    }

    public String cYD() {
        return (StringUtils.isNull(this.kGR) || "0".equals(this.kGR)) ? this.oriUgcNid : this.kGR;
    }

    public boolean getHostMode() {
        return this.kGW;
    }

    public boolean cYE() {
        return cZt();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean cYF() {
        return this.eei;
    }

    public boolean cYG() {
        return this.kHa;
    }

    public boolean cYH() {
        return this.kHh;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean cYI() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int ceJ() {
        return this.kHb;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void Eh(int i) {
        this.kHb = i;
    }

    public boolean cYJ() {
        return this.jGt;
    }

    public boolean cYK() {
        if (this.kAH == null) {
            return false;
        }
        return this.kAH.isValid();
    }

    public String beM() {
        if (this.kAH == null || !this.kAH.baA()) {
            return null;
        }
        return this.kAH.baz();
    }

    public boolean Ei(int i) {
        this.kHd = i;
        if (this.kHd > this.kAH.getPage().bdp()) {
            this.kHd = this.kAH.getPage().bdp();
        }
        if (this.kHd < 1) {
            this.kHd = 1;
        }
        if (this.kGR == null) {
            return false;
        }
        return Ek(5);
    }

    public void Ej(int i) {
        this.kHd = i;
        this.kHe = i;
        this.kHf = i;
    }

    public void b(com.baidu.tbadk.core.data.av avVar) {
        if (avVar == null) {
            Ej(1);
            return;
        }
        if (this.kHe < avVar.bds()) {
            this.kHe = avVar.bds();
        }
        if (this.kHf > avVar.bds()) {
            this.kHf = avVar.bds();
        }
        this.kHg = avVar.bdp();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.kAH;
    }

    public BaijiahaoData cYL() {
        if (this.kAH == null || this.kAH.cVm() == null) {
            return null;
        }
        return this.kAH.cVm().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f cYM() {
        if (this.kAH == null) {
            return this.kAH;
        }
        if (!cYN() && this.kHZ != null) {
            this.kAH.b(this.kHZ);
        }
        return this.kAH;
    }

    private boolean cYN() {
        return (this.kAH.cVE() == null || this.kAH.cVE().dwy() == null || this.kAH.cVE().dwy().goods != null || this.kAH.cVE().dwy().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.av getPageData() {
        if (this.kAH == null) {
            return null;
        }
        return this.kAH.getPage();
    }

    public boolean cYO() {
        if (cZt() && this.kAH.getPage().bdu() == 0) {
            th(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.kGR = fVar.getThreadId();
            if (fVar.cVm() != null && fVar.cVm().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.cVm().getBaijiahaoData();
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
            this.kGT = null;
            this.kGW = false;
            this.kGY = true;
            LoadData();
        }
    }

    public void Nu(String str) {
        if (!StringUtils.isNull(str)) {
            this.kGR = str;
            this.kGT = null;
            this.kGW = false;
            this.kGY = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.kGR == null) {
            return false;
        }
        cancelLoadData();
        if (this.hyf == null) {
            this.hyf = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.hyf.start();
        }
        boolean Ek = Ek(3);
        if (this.opType != null) {
            this.opType = null;
            this.kHs = null;
            this.opUrl = null;
            return Ek;
        }
        return Ek;
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
        if (this.kHO != null) {
            this.kHO.cancelLoadData();
        }
        if (this.kHP != null) {
            this.kHP.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dof().doj();
        cgf();
    }

    private void cgf() {
        if (this.hyf != null) {
            this.hyf.destory();
            this.hyf = null;
        }
    }

    public boolean cYP() {
        return (this.kGT == null || this.kGT.equals("0") || this.kGT.length() == 0) ? LoadData() : cYT();
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
                this.kHO.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.kHO.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.kHP == null) {
                this.kHP = new GetSugMatchWordsModel(this.hwW.getPageContext());
            }
            this.kHP.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x039d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03a5 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x011d, B:51:0x016c, B:53:0x017c, B:54:0x0184, B:56:0x0191, B:57:0x0199, B:59:0x019d, B:60:0x01a2, B:62:0x01a6, B:63:0x01ab, B:65:0x01af, B:66:0x01bf, B:68:0x01c3, B:69:0x01cb, B:71:0x01cf, B:72:0x01e8, B:73:0x01f7, B:74:0x01fa, B:77:0x0226, B:79:0x0231, B:80:0x0239, B:82:0x0243, B:83:0x0247, B:85:0x0263, B:86:0x026c, B:88:0x0272, B:90:0x027c, B:202:0x053a, B:203:0x0540, B:206:0x054d, B:93:0x0289, B:201:0x0534, B:200:0x052d, B:96:0x02bd, B:97:0x02db, B:99:0x02f3, B:101:0x02f9, B:103:0x0300, B:104:0x030d, B:106:0x0321, B:108:0x0327, B:110:0x032d, B:119:0x035d, B:121:0x0363, B:111:0x0338, B:113:0x033c, B:115:0x0344, B:117:0x0353, B:118:0x0358, B:122:0x036f, B:124:0x0383, B:126:0x0387, B:129:0x0399, B:132:0x039f, B:160:0x0415, B:135:0x03a5, B:137:0x03ab, B:138:0x03b0, B:140:0x03b4, B:142:0x03be, B:147:0x03d5, B:149:0x03e3, B:150:0x03e6, B:152:0x03ea, B:153:0x03f5, B:155:0x03f9, B:157:0x0401, B:159:0x0410, B:161:0x041a, B:163:0x041e, B:144:0x03c2, B:164:0x0427, B:165:0x0455, B:167:0x0459, B:177:0x048a, B:170:0x0465, B:172:0x0473, B:173:0x047b, B:175:0x047f, B:176:0x0485, B:178:0x0493, B:180:0x049f, B:169:0x045d, B:181:0x04a9, B:183:0x04b5, B:185:0x04b9, B:187:0x04bd, B:188:0x04c2, B:190:0x04ce, B:191:0x04d6, B:195:0x04f0, B:192:0x04db, B:194:0x04ea, B:196:0x04f9, B:198:0x0508, B:94:0x02af, B:38:0x00e3), top: B:209:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03b4 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x011d, B:51:0x016c, B:53:0x017c, B:54:0x0184, B:56:0x0191, B:57:0x0199, B:59:0x019d, B:60:0x01a2, B:62:0x01a6, B:63:0x01ab, B:65:0x01af, B:66:0x01bf, B:68:0x01c3, B:69:0x01cb, B:71:0x01cf, B:72:0x01e8, B:73:0x01f7, B:74:0x01fa, B:77:0x0226, B:79:0x0231, B:80:0x0239, B:82:0x0243, B:83:0x0247, B:85:0x0263, B:86:0x026c, B:88:0x0272, B:90:0x027c, B:202:0x053a, B:203:0x0540, B:206:0x054d, B:93:0x0289, B:201:0x0534, B:200:0x052d, B:96:0x02bd, B:97:0x02db, B:99:0x02f3, B:101:0x02f9, B:103:0x0300, B:104:0x030d, B:106:0x0321, B:108:0x0327, B:110:0x032d, B:119:0x035d, B:121:0x0363, B:111:0x0338, B:113:0x033c, B:115:0x0344, B:117:0x0353, B:118:0x0358, B:122:0x036f, B:124:0x0383, B:126:0x0387, B:129:0x0399, B:132:0x039f, B:160:0x0415, B:135:0x03a5, B:137:0x03ab, B:138:0x03b0, B:140:0x03b4, B:142:0x03be, B:147:0x03d5, B:149:0x03e3, B:150:0x03e6, B:152:0x03ea, B:153:0x03f5, B:155:0x03f9, B:157:0x0401, B:159:0x0410, B:161:0x041a, B:163:0x041e, B:144:0x03c2, B:164:0x0427, B:165:0x0455, B:167:0x0459, B:177:0x048a, B:170:0x0465, B:172:0x0473, B:173:0x047b, B:175:0x047f, B:176:0x0485, B:178:0x0493, B:180:0x049f, B:169:0x045d, B:181:0x04a9, B:183:0x04b5, B:185:0x04b9, B:187:0x04bd, B:188:0x04c2, B:190:0x04ce, B:191:0x04d6, B:195:0x04f0, B:192:0x04db, B:194:0x04ea, B:196:0x04f9, B:198:0x0508, B:94:0x02af, B:38:0x00e3), top: B:209:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03ea A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x011d, B:51:0x016c, B:53:0x017c, B:54:0x0184, B:56:0x0191, B:57:0x0199, B:59:0x019d, B:60:0x01a2, B:62:0x01a6, B:63:0x01ab, B:65:0x01af, B:66:0x01bf, B:68:0x01c3, B:69:0x01cb, B:71:0x01cf, B:72:0x01e8, B:73:0x01f7, B:74:0x01fa, B:77:0x0226, B:79:0x0231, B:80:0x0239, B:82:0x0243, B:83:0x0247, B:85:0x0263, B:86:0x026c, B:88:0x0272, B:90:0x027c, B:202:0x053a, B:203:0x0540, B:206:0x054d, B:93:0x0289, B:201:0x0534, B:200:0x052d, B:96:0x02bd, B:97:0x02db, B:99:0x02f3, B:101:0x02f9, B:103:0x0300, B:104:0x030d, B:106:0x0321, B:108:0x0327, B:110:0x032d, B:119:0x035d, B:121:0x0363, B:111:0x0338, B:113:0x033c, B:115:0x0344, B:117:0x0353, B:118:0x0358, B:122:0x036f, B:124:0x0383, B:126:0x0387, B:129:0x0399, B:132:0x039f, B:160:0x0415, B:135:0x03a5, B:137:0x03ab, B:138:0x03b0, B:140:0x03b4, B:142:0x03be, B:147:0x03d5, B:149:0x03e3, B:150:0x03e6, B:152:0x03ea, B:153:0x03f5, B:155:0x03f9, B:157:0x0401, B:159:0x0410, B:161:0x041a, B:163:0x041e, B:144:0x03c2, B:164:0x0427, B:165:0x0455, B:167:0x0459, B:177:0x048a, B:170:0x0465, B:172:0x0473, B:173:0x047b, B:175:0x047f, B:176:0x0485, B:178:0x0493, B:180:0x049f, B:169:0x045d, B:181:0x04a9, B:183:0x04b5, B:185:0x04b9, B:187:0x04bd, B:188:0x04c2, B:190:0x04ce, B:191:0x04d6, B:195:0x04f0, B:192:0x04db, B:194:0x04ea, B:196:0x04f9, B:198:0x0508, B:94:0x02af, B:38:0x00e3), top: B:209:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03f9 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x011d, B:51:0x016c, B:53:0x017c, B:54:0x0184, B:56:0x0191, B:57:0x0199, B:59:0x019d, B:60:0x01a2, B:62:0x01a6, B:63:0x01ab, B:65:0x01af, B:66:0x01bf, B:68:0x01c3, B:69:0x01cb, B:71:0x01cf, B:72:0x01e8, B:73:0x01f7, B:74:0x01fa, B:77:0x0226, B:79:0x0231, B:80:0x0239, B:82:0x0243, B:83:0x0247, B:85:0x0263, B:86:0x026c, B:88:0x0272, B:90:0x027c, B:202:0x053a, B:203:0x0540, B:206:0x054d, B:93:0x0289, B:201:0x0534, B:200:0x052d, B:96:0x02bd, B:97:0x02db, B:99:0x02f3, B:101:0x02f9, B:103:0x0300, B:104:0x030d, B:106:0x0321, B:108:0x0327, B:110:0x032d, B:119:0x035d, B:121:0x0363, B:111:0x0338, B:113:0x033c, B:115:0x0344, B:117:0x0353, B:118:0x0358, B:122:0x036f, B:124:0x0383, B:126:0x0387, B:129:0x0399, B:132:0x039f, B:160:0x0415, B:135:0x03a5, B:137:0x03ab, B:138:0x03b0, B:140:0x03b4, B:142:0x03be, B:147:0x03d5, B:149:0x03e3, B:150:0x03e6, B:152:0x03ea, B:153:0x03f5, B:155:0x03f9, B:157:0x0401, B:159:0x0410, B:161:0x041a, B:163:0x041e, B:144:0x03c2, B:164:0x0427, B:165:0x0455, B:167:0x0459, B:177:0x048a, B:170:0x0465, B:172:0x0473, B:173:0x047b, B:175:0x047f, B:176:0x0485, B:178:0x0493, B:180:0x049f, B:169:0x045d, B:181:0x04a9, B:183:0x04b5, B:185:0x04b9, B:187:0x04bd, B:188:0x04c2, B:190:0x04ce, B:191:0x04d6, B:195:0x04f0, B:192:0x04db, B:194:0x04ea, B:196:0x04f9, B:198:0x0508, B:94:0x02af, B:38:0x00e3), top: B:209:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x041e A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:47:0x0110, B:48:0x011d, B:51:0x016c, B:53:0x017c, B:54:0x0184, B:56:0x0191, B:57:0x0199, B:59:0x019d, B:60:0x01a2, B:62:0x01a6, B:63:0x01ab, B:65:0x01af, B:66:0x01bf, B:68:0x01c3, B:69:0x01cb, B:71:0x01cf, B:72:0x01e8, B:73:0x01f7, B:74:0x01fa, B:77:0x0226, B:79:0x0231, B:80:0x0239, B:82:0x0243, B:83:0x0247, B:85:0x0263, B:86:0x026c, B:88:0x0272, B:90:0x027c, B:202:0x053a, B:203:0x0540, B:206:0x054d, B:93:0x0289, B:201:0x0534, B:200:0x052d, B:96:0x02bd, B:97:0x02db, B:99:0x02f3, B:101:0x02f9, B:103:0x0300, B:104:0x030d, B:106:0x0321, B:108:0x0327, B:110:0x032d, B:119:0x035d, B:121:0x0363, B:111:0x0338, B:113:0x033c, B:115:0x0344, B:117:0x0353, B:118:0x0358, B:122:0x036f, B:124:0x0383, B:126:0x0387, B:129:0x0399, B:132:0x039f, B:160:0x0415, B:135:0x03a5, B:137:0x03ab, B:138:0x03b0, B:140:0x03b4, B:142:0x03be, B:147:0x03d5, B:149:0x03e3, B:150:0x03e6, B:152:0x03ea, B:153:0x03f5, B:155:0x03f9, B:157:0x0401, B:159:0x0410, B:161:0x041a, B:163:0x041e, B:144:0x03c2, B:164:0x0427, B:165:0x0455, B:167:0x0459, B:177:0x048a, B:170:0x0465, B:172:0x0473, B:173:0x047b, B:175:0x047f, B:176:0x0485, B:178:0x0493, B:180:0x049f, B:169:0x045d, B:181:0x04a9, B:183:0x04b5, B:185:0x04b9, B:187:0x04bd, B:188:0x04c2, B:190:0x04ce, B:191:0x04d6, B:195:0x04f0, B:192:0x04db, B:194:0x04ea, B:196:0x04f9, B:198:0x0508, B:94:0x02af, B:38:0x00e3), top: B:209:0x00d7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Ek(int i) {
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
        El(i);
        final com.baidu.tieba.pb.data.f pbData = as.cZX().getPbData();
        if (pbData != null && pbData.cVm() != null) {
            pbData.cVm().ne(0);
            this.kGY = as.cZX().cYE();
            this.kGW = as.cZX().dac();
            this.kHa = as.cZX().dad();
            this.kHT = as.cZX().dab();
            this.kHU = as.cZX().daa();
            this.kHV = as.cZX().cZZ();
            this.kHX = as.cZX().dae();
            this.mTabIndex = as.cZX().getTabIndex();
            this.kHQ = this.kGW;
            if (this.kGW || this.isFromMark) {
                this.kHw = false;
            }
            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.kHA) {
            a(cYY(), true, this.kGT, 3);
        }
        if (i == 3 && !this.kHA) {
            if (this.isFromMark) {
                a(cYY(), true, this.kGT, 3);
            } else {
                a(cYY(), false, this.kGT, 3);
            }
        }
        this.kHA = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.kHZ == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.eJO);
        if (this.kGW || this.isFromMark) {
            this.kHw = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.kGR == null || this.kGR.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.kGR, 0L));
        if (com.baidu.tbadk.a.d.bag()) {
            pbPageRequestMessage.setFloorSortType(1);
            pbPageRequestMessage.set_rn(15);
        } else {
            pbPageRequestMessage.set_rn(30);
        }
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.au.bjr().bjs() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.kGY) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.kGW) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.kHl) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.kHk));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.kHw) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.kHs, 0));
            pbPageRequestMessage.setOpMessageID(this.kHk);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> cVo = this.kAH.cVo();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kHf - 1));
                        if (this.kHf - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.kHi) {
                                if (cVo != null && cVo.size() > 0) {
                                    size = cVo.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = cVo.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.kGT = postData.getId();
                                            if (StringUtils.isNull(this.kGT)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.kHe + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.kGT == null && this.kGT.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kGT, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kHe + 1));
                        if (this.kHe >= this.kHg) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (cVo != null) {
                                size = cVo.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.kGT == null) {
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
                if (cVo != null) {
                }
                if (this.kGT == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (cVo != null && cVo.size() > 0 && cVo.get(0) != null) {
                    this.kGT = cVo.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (cZt()) {
                        if (this.kHf - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.kHf - 1));
                        }
                    } else if (this.kHe < this.kHg) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kHe + 1));
                    }
                }
                if (this.kGT != null && this.kGT.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kGT, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.kGW) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (cZt()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.kHg > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kHg));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kGT, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.kHd));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.kHQ && !this.kGW) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kGT, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.kGW) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.kHE);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kHS, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.kHQ = this.kGW;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cYY());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.kHR));
        pbPageRequestMessage.setIsSubPostDataReverse(this.kHD);
        pbPageRequestMessage.setFromSmartFrs(this.kHG ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.kGV);
        if (this.kHR == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.kIf)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.kIf));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.kHg) {
                    i4 = -1;
                } else {
                    i4 = cZA();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = cZA();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.kGR);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean cWu() {
        switch (cZm()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().cVm() == null || !getPbData().cVm().bgb();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cWv()) && com.baidu.tieba.recapp.r.dnk().dne() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dnk().dne().aT(cWv(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dnk().dne().aU(cWv(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cWv()) && com.baidu.tieba.recapp.r.dnk().dne() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dnk().dne().aU(cWv(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dnk().dne().aT(cWv(), true));
        }
    }

    protected void El(int i) {
        boolean z = false;
        Eq(i);
        ArrayList<PostData> cVo = this.kAH.cVo();
        this.kHz = false;
        if (i == 1) {
            boolean z2 = false;
            while (cVo.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cVo.remove(0);
                z2 = true;
            }
            if (z2) {
                this.kAH.getPage().na(1);
                if (this.kHr != null) {
                    this.kHr.e(this.kAH);
                }
            }
            this.iob = System.currentTimeMillis();
            this.kHz = true;
        } else if (i == 2) {
            while (cVo.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cVo.remove(cVo.size() - 1);
                z = true;
            }
            if (z) {
                this.kAH.getPage().mZ(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.kHH = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.kHZ != null && this.kHZ.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVE() != null && fVar.cVE().dwy() != null && fVar.cVE().dwy().goods != null && fVar.cVE().isValidate() && fVar.cVE().dwy().goods.goods_style != 1001) {
            this.kHZ = fVar.cVE();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n cYQ() {
        return this.kHZ;
    }

    public void cYR() {
        this.kHZ = null;
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
            if (this.kHp || this.kHn || this.kHo) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.cVo().size(); i++) {
                PostData postData = fVar.cVo().get(i);
                for (int i2 = 0; i2 < postData.dwH().size(); i2++) {
                    postData.dwH().get(i2).a(this.hwW.getPageContext(), o.equals(postData.dwH().get(i2).beE().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r cVA = fVar.cVA();
            if (cVA != null && !com.baidu.tbadk.core.util.y.isEmpty(cVA.kyv)) {
                for (PostData postData2 : cVA.kyv) {
                    for (int i3 = 0; i3 < postData2.dwH().size(); i3++) {
                        postData2.dwH().get(i3).a(this.hwW.getPageContext(), o.equals(postData2.dwH().get(i3).beE().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r cVA = fVar.cVA();
            if (cVA != null && !com.baidu.tbadk.core.util.y.isEmpty(cVA.kyv)) {
                for (PostData postData : cVA.kyv.subList(i, cVA.kyv.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dwH().size()) {
                            postData.dwH().get(i3).a(this.hwW.getPageContext(), o.equals(postData.dwH().get(i3).beE().getUserId()));
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
        bw cVm = fVar.cVm();
        cVm.nj(this.mIsGood);
        cVm.ni(this.kHb);
        if (this.kHc > 0) {
            cVm.cA(this.kHc);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.cVm() != null && fVar.cVm().beE() != null) {
            str = fVar.cVm().beE().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData cYS() {
        if (this.kAH == null || this.kAH.cVm() == null || this.kAH.cVm().beE() == null) {
            return null;
        }
        return this.kAH.cVm().beE();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.kHF = z3;
        if (this.hyf != null && !z3) {
            this.hyf.a(z2, z4, i2, str, i3, j, j2);
            this.hyf = null;
        }
        if (this.kAH != null) {
            this.kAH.kxE = z3;
            this.kAH.XX = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(cWv()) && com.baidu.tieba.recapp.r.dnk().dne() != null) {
            com.baidu.tieba.recapp.r.dnk().dne().f(cWv(), Em(cZb()), true);
        }
        if (fVar == null || (this.kHd == 1 && i == 5 && fVar.cVo() != null && fVar.cVo().size() < 1)) {
            if (this.kHr != null) {
                this.kGY = this.kGX;
                if (i2 != 350006) {
                    this.mSortType = this.kGZ;
                }
                this.kHr.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.kGX = this.kGY;
            if (i != 8) {
                this.kGZ = this.mSortType;
                this.mSortType = fVar.kwP;
            }
            if (fVar.kwO != null && fVar.kwO.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.hwW.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.kwO = new ArrayList();
                fVar.kwO.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.hwW.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.kwO.add(builder2.build(false));
                this.mSortType = this.kGZ;
                fVar.kwP = this.mSortType;
            }
            this.kHl = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.kHg = this.kHg < 1 ? 1 : this.kHg;
            int i6 = 0;
            ArrayList<PostData> cVo = this.kAH.cVo();
            switch (i) {
                case 1:
                    this.kAH.a(fVar.getPage(), 1);
                    d(fVar, cVo);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.cVo() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.cVo().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(cVo, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.cVo(), com.baidu.tbadk.core.util.y.getCount(fVar.cVo()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.cVo().remove(postData2);
                            i5 = size2 - 1;
                        }
                        cVo.addAll(0, fVar.cVo());
                    }
                    p(fVar);
                    this.kAH.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().mX(fVar.getPage().bdp());
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
                    if (fVar != null && !com.baidu.tbadk.core.util.y.isEmpty(fVar.cVo()) && this.kAH != null && (!this.kGW || o(fVar).equals(fVar.cVo().get(0).beE().getUserId()))) {
                        if (this.kAH.getPage().bdu() == 0) {
                            this.kAH.getPage().mZ(1);
                        }
                        cZn();
                        this.kHT = fVar.cVo().get(0);
                        if (cZt() || this.kAH.cVP()) {
                            if (this.kAH.cVo().size() - this.kHV >= 3) {
                                this.kHU = new PostData();
                                this.kHU.mfC = true;
                                this.kHU.setPostType(53);
                                this.kAH.cVo().add(this.kHU);
                            }
                            this.kAH.cVo().add(this.kHT);
                            size = this.kAH.cVo().size() - 1;
                        } else {
                            if (this.kHV - this.kHW >= 3) {
                                this.kHU = new PostData();
                                this.kHU.mfC = false;
                                this.kHU.setPostType(53);
                                this.kAH.cVo().add(0, this.kHU);
                            }
                            this.kAH.cVo().add(0, this.kHT);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.at.isTaday(com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.kHT.mfP = this.kAH.cVN();
                            com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.kAH != null && this.kAH.cVm() != null) {
                PraiseData bep = this.kAH.cVm().bep();
                if (this.kIj != null && !bep.isPriaseDataValid()) {
                    this.kAH.cVm().a(this.kIj);
                } else {
                    this.kIj = this.kAH.cVm().bep();
                    this.kIj.setPostId(this.kAH.cVm().beV());
                }
                if (fVar.getPage() != null && fVar.getPage().bds() == 1 && fVar.cVm() != null && fVar.cVm().beO() != null && fVar.cVm().beO().size() > 0) {
                    this.kAH.cVm().E(fVar.cVm().beO());
                }
                this.kAH.cVm().ng(fVar.cVm().bev());
                this.kAH.cVm().nd(fVar.cVm().getAnchorLevel());
                this.kAH.cVm().ne(fVar.cVm().bel());
                if (this.mThreadType == 33) {
                    this.kAH.cVm().beE().setHadConcerned(fVar.cVm().beE().hadConcerned());
                }
                if (fVar != null && fVar.cVm() != null) {
                    this.kAH.cVm().nl(fVar.cVm().beS());
                }
            }
            if (this.kAH != null && this.kAH.getUserData() != null && fVar.getUserData() != null) {
                this.kAH.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.kAH.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().bds() == 1 && fVar.cVz() != null) {
                this.kAH.f(fVar.cVz());
            }
            if (this.kHF) {
                if (this.kAH.cVm() != null && this.kAH.cVm().beE() != null && this.kAH.cVo() != null && com.baidu.tbadk.core.util.y.getItem(this.kAH.cVo(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(this.kAH.cVo(), 0);
                    MetaData beE = this.kAH.cVm().beE();
                    if (postData3.beE() != null && postData3.beE().getGodUserData() != null) {
                        if (this.kHu != -1) {
                            beE.setFansNum(this.kHu);
                            postData3.beE().setFansNum(this.kHu);
                        }
                        if (this.kHv != -1) {
                            beE.getGodUserData().setIsLike(this.kHv == 1);
                            postData3.beE().getGodUserData().setIsLike(this.kHv == 1);
                            beE.getGodUserData().setIsFromNetWork(false);
                            postData3.beE().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.kAH.kwN = -1;
                this.kAH.kwM = -1;
            }
            if (this.kHr != null) {
                this.kHr.a(true, getErrorCode(), i, i4, this.kAH, this.mErrorString, 1);
            }
        }
        if (this.kAH != null && this.kAH.cVm() != null && this.kAH.getForum() != null && !this.kAH.cVP()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.hwW.getPageContext();
            historyMessage.threadId = getPbData().cVm().getId();
            if (this.mIsShareThread && getPbData().cVm().edI != null) {
                historyMessage.threadName = getPbData().cVm().edI.showText;
            } else {
                historyMessage.threadName = getPbData().cVm().getTitle();
            }
            if (this.mIsShareThread && !cWu()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = cYE();
            historyMessage.threadType = getPbData().cVm().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.kAH != null) {
            this.kAH.cVD().clear();
            this.kAH.cVD().addAll(fVar.cVD());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aW;
        if (arrayList != null && fVar.cVo() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.cVo(), 0);
            if (postData != null && (aW = aW(arrayList)) != null && aW.equals(postData.getId())) {
                fVar.cVo().remove(postData);
            }
            this.kAH.kxD = arrayList.size();
            arrayList.addAll(fVar.cVo());
        }
    }

    private int Em(int i) {
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

    private String aW(ArrayList<PostData> arrayList) {
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
            fVar.Nm(this.kAH.cVH());
            if (!this.kAH.kxB && fVar.kxB && this.kAH.cVw() != null) {
                fVar.e(this.kAH.cVw());
            }
            this.kAH = fVar;
            Ej(fVar.getPage().bds());
        }
    }

    public boolean cYT() {
        if (this.kGR == null || this.kGT == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return Ek(4);
        }
        return Ek(6);
    }

    public boolean th(boolean z) {
        if (this.kGR == null || this.kAH == null) {
            return false;
        }
        if (z || this.kAH.getPage().bdu() != 0) {
            return Ek(1);
        }
        return false;
    }

    public boolean ti(boolean z) {
        if (this.kGR == null || this.kAH == null) {
            return false;
        }
        if ((z || this.kAH.getPage().bdv() != 0) && this.kAH.cVo() != null && this.kAH.cVo().size() >= 1) {
            return Ek(2);
        }
        return false;
    }

    public boolean NA(String str) {
        this.kGW = !this.kGW;
        this.kGT = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").ai("obj_source", 0));
        if (Ek(6)) {
            return true;
        }
        this.kGW = this.kGW ? false : true;
        return false;
    }

    public boolean z(boolean z, String str) {
        if (this.kGW == z) {
            return false;
        }
        this.kGW = z;
        this.kGT = str;
        if (this.mSortType == 2) {
            this.kGT = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").ai("obj_source", 1));
        }
        if (Ek(6)) {
            return true;
        }
        this.kGW = z ? false : true;
        return false;
    }

    public boolean En(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_pb_current_sort_type", i);
        }
        this.kGX = this.kGY;
        this.kGZ = this.mSortType;
        this.mSortType = i;
        this.kGY = !this.kGY;
        if (i == 2 && this.isFromMark) {
            this.kGT = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.kGY = this.kGY ? false : true;
            this.mSortType = this.kGZ;
            return false;
        }
        return true;
    }

    public boolean cYU() {
        return cZt();
    }

    public int cYV() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.kAH == null || this.kAH.getForum() == null || this.kAH.cVm() == null) ? false : true;
    }

    public boolean baA() {
        if (this.kAH == null) {
            return false;
        }
        return this.kAH.baA();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData BV(String str) {
        if (this.kAH == null || this.kAH.cVm() == null || this.kAH.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.kAH.cVm().bgb()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.kAH.getForum().getId());
            writeData.setForumName(this.kAH.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.kHR);
        writeData.setThreadId(this.kGR);
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

    public MarkData Eo(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.kAH == null) {
            return null;
        }
        ArrayList<PostData> cVo = this.kAH.cVo();
        if (com.baidu.tbadk.core.util.y.isEmpty(cVo)) {
            return null;
        }
        if (cVo.size() > 0 && i >= cVo.size()) {
            i = cVo.size() - 1;
        }
        return o(cVo.get(i));
    }

    public MarkData cYW() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kGR);
        markData.setPostId(this.kAH.baz());
        markData.setTime(date.getTime());
        markData.setHostMode(this.kGW);
        markData.setSequence(Boolean.valueOf(cZt()));
        markData.setId(this.kGR);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kGR);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.kGW);
        markData.setSequence(Boolean.valueOf(cZt()));
        markData.setId(this.kGR);
        markData.setFloor(postData.dwK());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) postData).isApp());
        }
        return markData;
    }

    public void cYX() {
        j.cXi().aO(cYY(), this.isFromMark);
    }

    private String cYY() {
        String cYZ = (this.kGR == null || this.kGR.equals("0")) ? cYZ() : this.kGR;
        if (this.kGW) {
            cYZ = cYZ + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            cYZ = cYZ + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            cYZ = cYZ + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return cYZ + TbadkCoreApplication.getCurrentAccount();
        }
        return cYZ;
    }

    private String cYZ() {
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

    public void tj(boolean z) {
        if (this.kAH != null) {
            this.kAH.hB(z);
        }
    }

    public boolean cZa() {
        return this.kHw;
    }

    public void a(a aVar) {
        this.kHr = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String brT() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean brS() {
        return cYP();
    }

    public boolean NB(String str) {
        if (getPbData() == null || getPbData().cVm() == null || getPbData().cVm().beE() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().cVm().beE().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int cZb() {
        return this.mRequestType;
    }

    public void cZc() {
        if ("personalize_page".equals(this.mStType)) {
            this.kHC = System.currentTimeMillis() / 1000;
        }
    }

    public void cZd() {
        if ("personalize_page".equals(this.mStType) && this.kAH != null && this.kHC != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10754").dD("fid", this.kAH.getForumId()).dD("tid", this.kGR).dD("obj_duration", String.valueOf(currentTimeMillis - this.kHC)).dD(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.kHC = 0L;
        }
    }

    public boolean cZe() {
        return this.kHF;
    }

    public int getErrorNo() {
        return this.kHH;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public q cZf() {
        return this.kHJ;
    }

    public ai cZg() {
        return this.kHK;
    }

    public CheckRealNameModel cZh() {
        return this.kHM;
    }

    public AddExperiencedModel cZi() {
        return this.kHN;
    }

    public String cZj() {
        return this.kHB;
    }

    public void NC(String str) {
        this.kHB = str;
    }

    public boolean cZk() {
        return this.kHG;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.kAH != null && this.kAH.cVo() != null && this.kAH.cVo().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.kAH.cVo().size();
                for (int i = 0; i < size; i++) {
                    if (this.kAH.cVo().get(i) != null && this.kAH.cVo().get(i).beE() != null && currentAccount.equals(this.kAH.cVo().get(i).beE().getUserId()) && this.kAH.cVo().get(i).beE().getPendantData() != null) {
                        this.kAH.cVo().get(i).beE().getPendantData().zj(lVar.bcA());
                        this.kAH.cVo().get(i).beE().getPendantData().cY(lVar.bra());
                    }
                }
            }
        }
    }

    public String cZl() {
        return this.kHL;
    }

    public int cZm() {
        return this.kHR;
    }

    public void Ep(int i) {
        this.kHR = i;
    }

    public void ND(String str) {
        if ((!this.kGW || NB(TbadkCoreApplication.getCurrentAccount())) && this.kAH.cVo() != null) {
            this.kAH.getPage().mZ(1);
            if (this.kAH.getPage().bdu() == 0) {
                this.kAH.getPage().mZ(1);
            }
            this.kHS = str;
            Ek(8);
        }
    }

    private void Eq(int i) {
        if (i != 8) {
            this.kHS = "";
            if (this.kHT != null) {
                if (i == 1 && this.kAH != null && this.kAH.cVP()) {
                    if (this.kHU != null) {
                        getPbData().cVo().remove(this.kHU);
                    }
                } else if (i == 1 && !this.kGY && !com.baidu.tbadk.core.util.y.isEmpty(getPbData().cVo())) {
                    getPbData().cVo().remove(this.kHT);
                    if (this.kHU != null) {
                        getPbData().cVo().remove(this.kHU);
                    }
                    getPbData().cVo().add(0, this.kHT);
                } else {
                    getPbData().cVo().remove(this.kHT);
                    if (this.kHU != null) {
                        getPbData().cVo().remove(this.kHU);
                    }
                }
            }
            this.kHU = null;
        }
    }

    public void cZn() {
        if (this.kAH != null && !com.baidu.tbadk.core.util.y.isEmpty(this.kAH.cVo())) {
            if (this.kHU != null) {
                this.kAH.cVo().remove(this.kHU);
                this.kHU = null;
            }
            if (this.kHT != null) {
                this.kAH.cVo().remove(this.kHT);
                this.kHT = null;
            }
        }
    }

    public void cU(int i, int i2) {
        this.kHV = i;
        this.kHW = i2;
    }

    public PostData cZo() {
        return this.kHT;
    }

    public PostData cZp() {
        return this.kHU;
    }

    public int cZq() {
        return this.kHV;
    }

    public int cZr() {
        return this.kHW;
    }

    public String cZs() {
        return this.kHY;
    }

    public void NE(String str) {
        this.kHY = str;
    }

    private boolean cZt() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean cZu() {
        return this.kHR == 13 || this.kHR == 12 || this.kHR == 7;
    }

    public String cZv() {
        return this.kIb;
    }

    public String cZw() {
        return this.kIc;
    }

    public String cZx() {
        return this.kId;
    }

    public String cZy() {
        return this.kIe;
    }

    public Rect cZz() {
        Rect rect = this.kHX;
        this.kHX = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int cZA() {
        int i;
        int i2 = 0;
        if (getPbData().cVo() == null) {
            return 0;
        }
        ArrayList<PostData> cVo = getPbData().cVo();
        int size = cVo.size() - 1;
        while (size >= 0) {
            PostData postData = cVo.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
                if (postData.getType() != AdvertAppInfo.dVX) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return cVo.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
