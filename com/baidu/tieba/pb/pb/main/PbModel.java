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
    private boolean eee;
    private BaseFragmentActivity hwQ;
    private com.baidu.tieba.tbadkCore.d.b hxZ;
    private long inV;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private boolean jGn;
    protected com.baidu.tieba.pb.data.f kAA;
    protected String kGK;
    private String kGL;
    private String kGM;
    private String kGN;
    private boolean kGO;
    private boolean kGP;
    private boolean kGQ;
    private boolean kGR;
    private int kGS;
    private boolean kGT;
    private int kGU;
    private long kGV;
    private int kGW;
    private int kGX;
    private int kGY;
    private int kGZ;
    private int kHA;
    private final ag kHB;
    private final q kHC;
    private final ai kHD;
    private String kHE;
    private final CheckRealNameModel kHF;
    private final AddExperiencedModel kHG;
    private SuggestEmotionModel kHH;
    private GetSugMatchWordsModel kHI;
    private boolean kHJ;
    private int kHK;
    private String kHL;
    private PostData kHM;
    private PostData kHN;
    private int kHO;
    private int kHP;
    private Rect kHQ;
    private String kHR;
    private com.baidu.tieba.tbadkCore.data.n kHS;
    private boolean kHT;
    private String kHU;
    private String kHV;
    private String kHW;
    private String kHX;
    private String kHY;
    private f.a kHZ;
    private boolean kHa;
    private boolean kHb;
    private boolean kHc;
    private long kHd;
    private boolean kHe;
    private String kHf;
    private boolean kHg;
    private boolean kHh;
    private boolean kHi;
    private boolean kHj;
    private a kHk;
    private String kHl;
    private String kHm;
    private int kHn;
    private int kHo;
    private boolean kHp;
    private boolean kHq;
    private boolean kHr;
    private boolean kHs;
    private boolean kHt;
    private String kHu;
    private long kHv;
    private boolean kHw;
    private int kHx;
    private boolean kHy;
    private boolean kHz;
    private CustomMessageListener kIa;
    private com.baidu.adp.framework.listener.a kIb;
    private PraiseData kIc;
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
    private static final int kGJ = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.kGK = null;
        this.isPrivacy = false;
        this.kGL = null;
        this.kGM = null;
        this.mForumId = null;
        this.kGN = null;
        this.kGO = false;
        this.kGP = false;
        this.kGQ = true;
        this.kGR = true;
        this.mSortType = 0;
        this.kGS = 0;
        this.kGT = false;
        this.mIsGood = 0;
        this.kGU = 0;
        this.kGV = 0L;
        this.kGW = 1;
        this.kGX = 1;
        this.kGY = 1;
        this.kGZ = 1;
        this.isAd = false;
        this.jGn = false;
        this.eee = false;
        this.kHa = false;
        this.isFromMark = false;
        this.kHb = false;
        this.kHc = false;
        this.kHd = 0L;
        this.kHe = false;
        this.kHf = null;
        this.kAA = null;
        this.isLoading = false;
        this.kHg = false;
        this.kHh = false;
        this.kHi = false;
        this.kHj = false;
        this.mLocate = null;
        this.mContext = null;
        this.kHk = null;
        this.opType = null;
        this.opUrl = null;
        this.kHl = null;
        this.kHm = null;
        this.kHn = -1;
        this.kHo = -1;
        this.hxZ = null;
        this.kHq = false;
        this.kHr = false;
        this.postID = null;
        this.kHu = null;
        this.kHv = 0L;
        this.kHw = false;
        this.kHx = -1;
        this.kHz = false;
        this.kHJ = false;
        this.kHK = 0;
        this.mTabIndex = 0;
        this.kHT = false;
        this.kIa = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.kIb = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.hwQ.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.kHq || !PbModel.this.kHr) {
                        if (!PbModel.this.kHq) {
                            PbModel.this.kHq = true;
                        } else {
                            PbModel.this.kHr = true;
                        }
                        if (PbModel.this.kHk != null) {
                            PbModel.this.kHk.a(PbModel.this.cYw(), z, responsedMessage, PbModel.this.kHs, System.currentTimeMillis() - PbModel.this.inV);
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
                    if (PbModel.this.kAA != null && PbModel.this.kAA.cVk() != null && PbModel.this.kAA.cVk().getForumId() != null && PbModel.this.kAA.cVk().getForumId().equals(valueOf)) {
                        PbModel.this.kAA.cVk().setIsLike(false);
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
                    if (PbModel.this.kAA != null && PbModel.this.kAA.cVk() != null && PbModel.this.kAA.cVk().getForumId() != null && PbModel.this.kAA.cVk().getForumId().equals(valueOf)) {
                        PbModel.this.kAA.cVk().setIsLike(true);
                    }
                }
            }
        };
        this.kIc = null;
        registerListener(this.kIb);
        registerListener(this.kIa);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.kAA = new com.baidu.tieba.pb.data.f();
        this.kAA.DP(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.hwQ = baseFragmentActivity;
        this.kHB = new ag(this, this.hwQ);
        this.kHC = new q(this, this.hwQ);
        this.kHD = new ai(this, this.hwQ);
        this.kHF = new CheckRealNameModel(this.hwQ.getPageContext());
        this.kHH = new SuggestEmotionModel();
        this.kHG = new AddExperiencedModel(this.hwQ.getPageContext());
        this.kHZ = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void z(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dPg) instanceof String) {
                        PbModel.this.kGK = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dPg);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dPh) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dPh);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dPi) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dPi);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dPj) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.dPj), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dPk) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dPk);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.kHt = true;
        if (fVar != null && fVar.kwJ == null) {
            q(fVar);
            l(fVar);
            if (fVar.cVl() != null) {
                fVar.cVl().ne(0);
            }
            if (this.kHk != null && fVar != null) {
                this.kHk.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int cYw() {
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
            this.kGK = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.kHY = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                com.baidu.tbadk.BdToken.f.aYL().c(uri, this.kHZ);
            } else if (StringUtils.isNull(this.kGK)) {
                this.kHB.a(intent, this.kHZ);
                if (uri != null) {
                    if (StringUtils.isNull(this.kGK)) {
                        this.kGK = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.at.isEmpty(this.kGK)) {
                this.kGK = "0";
            }
            this.kHK = intent.getIntExtra("key_start_from", 0);
            if (this.kHK == 0) {
                this.kHK = this.kHB.aEB;
            }
            this.kGM = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.kGL = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.kGO = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.kGP = intent.getBooleanExtra("host_only", false);
            this.kGR = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.kGM = this.mSortType == 2 ? "0" : this.kGM;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.kGU = intent.getIntExtra("is_top", 0);
            this.kGV = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.kHb = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.kHc = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.jGn = intent.getBooleanExtra("is_sub_pb", false);
            this.kHe = intent.getBooleanExtra("is_pv", false);
            this.kHd = intent.getLongExtra("msg_id", 0L);
            this.kHf = intent.getStringExtra("from_forum_name");
            this.kHm = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.kHl = intent.getStringExtra("op_stat");
            this.kHg = intent.getBooleanExtra("is_from_thread_config", false);
            this.kHh = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.kHi = intent.getBooleanExtra("is_from_my_god_config", false);
            this.kHo = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.kHn = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.eee = intent.getBooleanExtra("from_frs", false);
            this.kHa = intent.getBooleanExtra("from_maintab", false);
            this.kHz = intent.getBooleanExtra("from_smart_frs", false);
            this.kHj = intent.getBooleanExtra("from_hottopic", false);
            this.kHE = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.kGN = intent.getStringExtra("high_light_post_id");
            this.kHT = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.kHp = intent.getIntExtra("request_code", -1) == 18003;
            this.kHU = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.kHV = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.kHW = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.kHX = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean cYx() {
        return this.kHT && com.baidu.tieba.frs.l.clH() != null && com.baidu.tieba.frs.l.clH().equals(this.kGK) && com.baidu.tieba.frs.l.clG() != null;
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
        fVar.cVn().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.o(bwVar, null));
        fVar.kwO = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.kHK = bundle.getInt("key_start_from", 0);
        this.kGK = bundle.getString("thread_id");
        this.kGM = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.kGL = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.kGO = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.kGP = bundle.getBoolean("host_only", false);
        this.kGR = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.kGU = bundle.getInt("is_top", 0);
        this.kGV = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.kHc = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.jGn = bundle.getBoolean("is_sub_pb", false);
        this.kHe = bundle.getBoolean("is_pv", false);
        this.kHd = bundle.getLong("msg_id", 0L);
        this.kHf = bundle.getString("from_forum_name");
        this.kHm = bundle.getString("extra_pb_cache_key");
        this.kHg = bundle.getBoolean("is_from_thread_config", false);
        this.kHh = bundle.getBoolean("is_from_interview_live_config", false);
        this.kHi = bundle.getBoolean("is_from_my_god_config", false);
        this.kHo = bundle.getInt("extra_pb_is_attention_key", -1);
        this.kHn = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eee = bundle.getBoolean("from_frs", false);
        this.kHa = bundle.getBoolean("from_maintab", false);
        this.kHz = bundle.getBoolean("from_smart_frs", false);
        this.kHj = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.kGN = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.kHp = bundle.getInt("request_code", -1) == 18003;
        this.kHU = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.kHV = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.kHW = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.kHX = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aC(Bundle bundle) {
        bundle.putString("thread_id", this.kGK);
        bundle.putString("post_id", this.kGM);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.kHK);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.kGO);
        bundle.putBoolean("host_only", this.kGP);
        bundle.putBoolean("squence", this.kGR);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.kGU);
        bundle.putLong("thread_time", this.kGV);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.kHc);
        bundle.putBoolean("is_sub_pb", this.jGn);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.kHe);
        bundle.putLong("msg_id", this.kHd);
        bundle.putString("extra_pb_cache_key", this.kHm);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.kHg);
        bundle.putBoolean("is_from_interview_live_config", this.kHh);
        bundle.putBoolean("is_from_my_god_config", this.kHi);
        bundle.putInt("extra_pb_is_attention_key", this.kHo);
        bundle.putInt("extra_pb_funs_count_key", this.kHn);
        bundle.putBoolean("from_frs", this.eee);
        bundle.putBoolean("from_maintab", this.kHa);
        bundle.putBoolean("from_smart_frs", this.kHz);
        bundle.putBoolean("from_hottopic", this.kHj);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.kGN);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.kHU);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.kHV);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.kHW);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.kHX);
    }

    public String cYy() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.kGK);
        if (!this.kHc) {
            sb.append(this.kGM);
        }
        sb.append(this.kGP);
        sb.append(this.kGR);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.kGU);
        sb.append(this.kGV);
        sb.append(this.eee);
        sb.append(this.kHa);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.jGn);
        sb.append(this.kHe);
        sb.append(this.kHd);
        sb.append(this.kHf);
        sb.append(this.mThreadType);
        sb.append(this.kHg);
        sb.append(this.kHh);
        sb.append(this.kHi);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.kHm != null) {
            sb.append(this.kHm);
        }
        return sb.toString();
    }

    public String cWu() {
        return this.kHf;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cYz() {
        return this.kGM;
    }

    public String cYA() {
        return this.kGN;
    }

    public String cYB() {
        return this.kGK;
    }

    public String cYC() {
        return (StringUtils.isNull(this.kGK) || "0".equals(this.kGK)) ? this.oriUgcNid : this.kGK;
    }

    public boolean getHostMode() {
        return this.kGP;
    }

    public boolean cYD() {
        return cZs();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean cYE() {
        return this.eee;
    }

    public boolean cYF() {
        return this.kGT;
    }

    public boolean cYG() {
        return this.kHa;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean cYH() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int ceI() {
        return this.kGU;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void Eh(int i) {
        this.kGU = i;
    }

    public boolean cYI() {
        return this.jGn;
    }

    public boolean cYJ() {
        if (this.kAA == null) {
            return false;
        }
        return this.kAA.isValid();
    }

    public String beM() {
        if (this.kAA == null || !this.kAA.baA()) {
            return null;
        }
        return this.kAA.baz();
    }

    public boolean Ei(int i) {
        this.kGW = i;
        if (this.kGW > this.kAA.getPage().bdp()) {
            this.kGW = this.kAA.getPage().bdp();
        }
        if (this.kGW < 1) {
            this.kGW = 1;
        }
        if (this.kGK == null) {
            return false;
        }
        return Ek(5);
    }

    public void Ej(int i) {
        this.kGW = i;
        this.kGX = i;
        this.kGY = i;
    }

    public void b(com.baidu.tbadk.core.data.av avVar) {
        if (avVar == null) {
            Ej(1);
            return;
        }
        if (this.kGX < avVar.bds()) {
            this.kGX = avVar.bds();
        }
        if (this.kGY > avVar.bds()) {
            this.kGY = avVar.bds();
        }
        this.kGZ = avVar.bdp();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.kAA;
    }

    public BaijiahaoData cYK() {
        if (this.kAA == null || this.kAA.cVl() == null) {
            return null;
        }
        return this.kAA.cVl().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f cYL() {
        if (this.kAA == null) {
            return this.kAA;
        }
        if (!cYM() && this.kHS != null) {
            this.kAA.b(this.kHS);
        }
        return this.kAA;
    }

    private boolean cYM() {
        return (this.kAA.cVD() == null || this.kAA.cVD().dwt() == null || this.kAA.cVD().dwt().goods != null || this.kAA.cVD().dwt().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.av getPageData() {
        if (this.kAA == null) {
            return null;
        }
        return this.kAA.getPage();
    }

    public boolean cYN() {
        if (cZs() && this.kAA.getPage().bdu() == 0) {
            tf(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.kGK = fVar.getThreadId();
            if (fVar.cVl() != null && fVar.cVl().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.cVl().getBaijiahaoData();
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
            this.kGM = null;
            this.kGP = false;
            this.kGR = true;
            LoadData();
        }
    }

    public void Nt(String str) {
        if (!StringUtils.isNull(str)) {
            this.kGK = str;
            this.kGM = null;
            this.kGP = false;
            this.kGR = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.kGK == null) {
            return false;
        }
        cancelLoadData();
        if (this.hxZ == null) {
            this.hxZ = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.hxZ.start();
        }
        boolean Ek = Ek(3);
        if (this.opType != null) {
            this.opType = null;
            this.kHl = null;
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
        if (this.kHH != null) {
            this.kHH.cancelLoadData();
        }
        if (this.kHI != null) {
            this.kHI.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.doc().dog();
        cge();
    }

    private void cge() {
        if (this.hxZ != null) {
            this.hxZ.destory();
            this.hxZ = null;
        }
    }

    public boolean cYO() {
        return (this.kGM == null || this.kGM.equals("0") || this.kGM.length() == 0) ? LoadData() : cYS();
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
                this.kHH.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.kHH.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.kHI == null) {
                this.kHI = new GetSugMatchWordsModel(this.hwQ.getPageContext());
            }
            this.kHI.b(aVar);
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
        final com.baidu.tieba.pb.data.f pbData = as.cZW().getPbData();
        if (pbData != null && pbData.cVl() != null) {
            pbData.cVl().ne(0);
            this.kGR = as.cZW().cYD();
            this.kGP = as.cZW().dab();
            this.kGT = as.cZW().dac();
            this.kHM = as.cZW().daa();
            this.kHN = as.cZW().cZZ();
            this.kHO = as.cZW().cZY();
            this.kHQ = as.cZW().dad();
            this.mTabIndex = as.cZW().getTabIndex();
            this.kHJ = this.kGP;
            if (this.kGP || this.isFromMark) {
                this.kHp = false;
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
        if (i == 4 && !this.kHt) {
            a(cYX(), true, this.kGM, 3);
        }
        if (i == 3 && !this.kHt) {
            if (this.isFromMark) {
                a(cYX(), true, this.kGM, 3);
            } else {
                a(cYX(), false, this.kGM, 3);
            }
        }
        this.kHt = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.kHS == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.eJK);
        if (this.kGP || this.isFromMark) {
            this.kHp = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.kGK == null || this.kGK.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.kGK, 0L));
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
        if (!this.kGR) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.kGP) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.kHe) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.kHd));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.kHp) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.kHl, 0));
            pbPageRequestMessage.setOpMessageID(this.kHd);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> cVn = this.kAA.cVn();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kGY - 1));
                        if (this.kGY - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.kHb) {
                                if (cVn != null && cVn.size() > 0) {
                                    size = cVn.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = cVn.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.kGM = postData.getId();
                                            if (StringUtils.isNull(this.kGM)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.kGX + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.kGM == null && this.kGM.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kGM, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kGX + 1));
                        if (this.kGX >= this.kGZ) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (cVn != null) {
                                size = cVn.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.kGM == null) {
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
                if (cVn != null) {
                }
                if (this.kGM == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (cVn != null && cVn.size() > 0 && cVn.get(0) != null) {
                    this.kGM = cVn.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (cZs()) {
                        if (this.kGY - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.kGY - 1));
                        }
                    } else if (this.kGX < this.kGZ) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kGX + 1));
                    }
                }
                if (this.kGM != null && this.kGM.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kGM, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.kGP) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (cZs()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.kGZ > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kGZ));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kGM, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.kGW));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.kHJ && !this.kGP) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kGM, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.kGP) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.kHx);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kHL, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.kHJ = this.kGP;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cYX());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.kHK));
        pbPageRequestMessage.setIsSubPostDataReverse(this.kHw);
        pbPageRequestMessage.setFromSmartFrs(this.kHz ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.kGO);
        if (this.kHK == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.kHY)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.kHY));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.kGZ) {
                    i4 = -1;
                } else {
                    i4 = cZz();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = cZz();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.kGK);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean cWt() {
        switch (cZl()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().cVl() == null || !getPbData().cVl().bgb();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cWu()) && com.baidu.tieba.recapp.r.dnh().dnb() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dnh().dnb().aT(cWu(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dnh().dnb().aU(cWu(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cWu()) && com.baidu.tieba.recapp.r.dnh().dnb() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dnh().dnb().aU(cWu(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dnh().dnb().aT(cWu(), true));
        }
    }

    protected void El(int i) {
        boolean z = false;
        Eq(i);
        ArrayList<PostData> cVn = this.kAA.cVn();
        this.kHs = false;
        if (i == 1) {
            boolean z2 = false;
            while (cVn.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cVn.remove(0);
                z2 = true;
            }
            if (z2) {
                this.kAA.getPage().na(1);
                if (this.kHk != null) {
                    this.kHk.e(this.kAA);
                }
            }
            this.inV = System.currentTimeMillis();
            this.kHs = true;
        } else if (i == 2) {
            while (cVn.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cVn.remove(cVn.size() - 1);
                z = true;
            }
            if (z) {
                this.kAA.getPage().mZ(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.kHA = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.kHS != null && this.kHS.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVD() != null && fVar.cVD().dwt() != null && fVar.cVD().dwt().goods != null && fVar.cVD().isValidate() && fVar.cVD().dwt().goods.goods_style != 1001) {
            this.kHS = fVar.cVD();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n cYP() {
        return this.kHS;
    }

    public void cYQ() {
        this.kHS = null;
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
            if (this.kHi || this.kHg || this.kHh) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.cVn().size(); i++) {
                PostData postData = fVar.cVn().get(i);
                for (int i2 = 0; i2 < postData.dwC().size(); i2++) {
                    postData.dwC().get(i2).a(this.hwQ.getPageContext(), o.equals(postData.dwC().get(i2).beE().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r cVz = fVar.cVz();
            if (cVz != null && !com.baidu.tbadk.core.util.y.isEmpty(cVz.kyo)) {
                for (PostData postData2 : cVz.kyo) {
                    for (int i3 = 0; i3 < postData2.dwC().size(); i3++) {
                        postData2.dwC().get(i3).a(this.hwQ.getPageContext(), o.equals(postData2.dwC().get(i3).beE().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r cVz = fVar.cVz();
            if (cVz != null && !com.baidu.tbadk.core.util.y.isEmpty(cVz.kyo)) {
                for (PostData postData : cVz.kyo.subList(i, cVz.kyo.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dwC().size()) {
                            postData.dwC().get(i3).a(this.hwQ.getPageContext(), o.equals(postData.dwC().get(i3).beE().getUserId()));
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
        bw cVl = fVar.cVl();
        cVl.nj(this.mIsGood);
        cVl.ni(this.kGU);
        if (this.kGV > 0) {
            cVl.cA(this.kGV);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.cVl() != null && fVar.cVl().beE() != null) {
            str = fVar.cVl().beE().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData cYR() {
        if (this.kAA == null || this.kAA.cVl() == null || this.kAA.cVl().beE() == null) {
            return null;
        }
        return this.kAA.cVl().beE();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.kHy = z3;
        if (this.hxZ != null && !z3) {
            this.hxZ.a(z2, z4, i2, str, i3, j, j2);
            this.hxZ = null;
        }
        if (this.kAA != null) {
            this.kAA.kxx = z3;
            this.kAA.XV = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(cWu()) && com.baidu.tieba.recapp.r.dnh().dnb() != null) {
            com.baidu.tieba.recapp.r.dnh().dnb().f(cWu(), Em(cZa()), true);
        }
        if (fVar == null || (this.kGW == 1 && i == 5 && fVar.cVn() != null && fVar.cVn().size() < 1)) {
            if (this.kHk != null) {
                this.kGR = this.kGQ;
                if (i2 != 350006) {
                    this.mSortType = this.kGS;
                }
                this.kHk.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.kGQ = this.kGR;
            if (i != 8) {
                this.kGS = this.mSortType;
                this.mSortType = fVar.kwI;
            }
            if (fVar.kwH != null && fVar.kwH.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.hwQ.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.kwH = new ArrayList();
                fVar.kwH.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.hwQ.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.kwH.add(builder2.build(false));
                this.mSortType = this.kGS;
                fVar.kwI = this.mSortType;
            }
            this.kHe = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.kGZ = this.kGZ < 1 ? 1 : this.kGZ;
            int i6 = 0;
            ArrayList<PostData> cVn = this.kAA.cVn();
            switch (i) {
                case 1:
                    this.kAA.a(fVar.getPage(), 1);
                    d(fVar, cVn);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.cVn() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.cVn().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(cVn, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.cVn(), com.baidu.tbadk.core.util.y.getCount(fVar.cVn()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.cVn().remove(postData2);
                            i5 = size2 - 1;
                        }
                        cVn.addAll(0, fVar.cVn());
                    }
                    p(fVar);
                    this.kAA.a(fVar.getPage(), 2);
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
                    if (fVar != null && !com.baidu.tbadk.core.util.y.isEmpty(fVar.cVn()) && this.kAA != null && (!this.kGP || o(fVar).equals(fVar.cVn().get(0).beE().getUserId()))) {
                        if (this.kAA.getPage().bdu() == 0) {
                            this.kAA.getPage().mZ(1);
                        }
                        cZm();
                        this.kHM = fVar.cVn().get(0);
                        if (cZs() || this.kAA.cVO()) {
                            if (this.kAA.cVn().size() - this.kHO >= 3) {
                                this.kHN = new PostData();
                                this.kHN.mfn = true;
                                this.kHN.setPostType(53);
                                this.kAA.cVn().add(this.kHN);
                            }
                            this.kAA.cVn().add(this.kHM);
                            size = this.kAA.cVn().size() - 1;
                        } else {
                            if (this.kHO - this.kHP >= 3) {
                                this.kHN = new PostData();
                                this.kHN.mfn = false;
                                this.kHN.setPostType(53);
                                this.kAA.cVn().add(0, this.kHN);
                            }
                            this.kAA.cVn().add(0, this.kHM);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.at.isTaday(com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.kHM.mfA = this.kAA.cVM();
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
            if (this.kAA != null && this.kAA.cVl() != null) {
                PraiseData bep = this.kAA.cVl().bep();
                if (this.kIc != null && !bep.isPriaseDataValid()) {
                    this.kAA.cVl().a(this.kIc);
                } else {
                    this.kIc = this.kAA.cVl().bep();
                    this.kIc.setPostId(this.kAA.cVl().beV());
                }
                if (fVar.getPage() != null && fVar.getPage().bds() == 1 && fVar.cVl() != null && fVar.cVl().beO() != null && fVar.cVl().beO().size() > 0) {
                    this.kAA.cVl().E(fVar.cVl().beO());
                }
                this.kAA.cVl().ng(fVar.cVl().bev());
                this.kAA.cVl().nd(fVar.cVl().getAnchorLevel());
                this.kAA.cVl().ne(fVar.cVl().bel());
                if (this.mThreadType == 33) {
                    this.kAA.cVl().beE().setHadConcerned(fVar.cVl().beE().hadConcerned());
                }
                if (fVar != null && fVar.cVl() != null) {
                    this.kAA.cVl().nl(fVar.cVl().beS());
                }
            }
            if (this.kAA != null && this.kAA.getUserData() != null && fVar.getUserData() != null) {
                this.kAA.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.kAA.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().bds() == 1 && fVar.cVy() != null) {
                this.kAA.f(fVar.cVy());
            }
            if (this.kHy) {
                if (this.kAA.cVl() != null && this.kAA.cVl().beE() != null && this.kAA.cVn() != null && com.baidu.tbadk.core.util.y.getItem(this.kAA.cVn(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(this.kAA.cVn(), 0);
                    MetaData beE = this.kAA.cVl().beE();
                    if (postData3.beE() != null && postData3.beE().getGodUserData() != null) {
                        if (this.kHn != -1) {
                            beE.setFansNum(this.kHn);
                            postData3.beE().setFansNum(this.kHn);
                        }
                        if (this.kHo != -1) {
                            beE.getGodUserData().setIsLike(this.kHo == 1);
                            postData3.beE().getGodUserData().setIsLike(this.kHo == 1);
                            beE.getGodUserData().setIsFromNetWork(false);
                            postData3.beE().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.kAA.kwG = -1;
                this.kAA.kwF = -1;
            }
            if (this.kHk != null) {
                this.kHk.a(true, getErrorCode(), i, i4, this.kAA, this.mErrorString, 1);
            }
        }
        if (this.kAA != null && this.kAA.cVl() != null && this.kAA.getForum() != null && !this.kAA.cVO()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.hwQ.getPageContext();
            historyMessage.threadId = getPbData().cVl().getId();
            if (this.mIsShareThread && getPbData().cVl().edE != null) {
                historyMessage.threadName = getPbData().cVl().edE.showText;
            } else {
                historyMessage.threadName = getPbData().cVl().getTitle();
            }
            if (this.mIsShareThread && !cWt()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = cYD();
            historyMessage.threadType = getPbData().cVl().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.kAA != null) {
            this.kAA.cVC().clear();
            this.kAA.cVC().addAll(fVar.cVC());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aW;
        if (arrayList != null && fVar.cVn() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.cVn(), 0);
            if (postData != null && (aW = aW(arrayList)) != null && aW.equals(postData.getId())) {
                fVar.cVn().remove(postData);
            }
            this.kAA.kxw = arrayList.size();
            arrayList.addAll(fVar.cVn());
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
            fVar.Nl(this.kAA.cVG());
            if (!this.kAA.kxu && fVar.kxu && this.kAA.cVv() != null) {
                fVar.e(this.kAA.cVv());
            }
            this.kAA = fVar;
            Ej(fVar.getPage().bds());
        }
    }

    public boolean cYS() {
        if (this.kGK == null || this.kGM == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return Ek(4);
        }
        return Ek(6);
    }

    public boolean tf(boolean z) {
        if (this.kGK == null || this.kAA == null) {
            return false;
        }
        if (z || this.kAA.getPage().bdu() != 0) {
            return Ek(1);
        }
        return false;
    }

    public boolean tg(boolean z) {
        if (this.kGK == null || this.kAA == null) {
            return false;
        }
        if ((z || this.kAA.getPage().bdv() != 0) && this.kAA.cVn() != null && this.kAA.cVn().size() >= 1) {
            return Ek(2);
        }
        return false;
    }

    public boolean Nz(String str) {
        this.kGP = !this.kGP;
        this.kGM = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").ai("obj_source", 0));
        if (Ek(6)) {
            return true;
        }
        this.kGP = this.kGP ? false : true;
        return false;
    }

    public boolean z(boolean z, String str) {
        if (this.kGP == z) {
            return false;
        }
        this.kGP = z;
        this.kGM = str;
        if (this.mSortType == 2) {
            this.kGM = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").ai("obj_source", 1));
        }
        if (Ek(6)) {
            return true;
        }
        this.kGP = z ? false : true;
        return false;
    }

    public boolean En(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_pb_current_sort_type", i);
        }
        this.kGQ = this.kGR;
        this.kGS = this.mSortType;
        this.mSortType = i;
        this.kGR = !this.kGR;
        if (i == 2 && this.isFromMark) {
            this.kGM = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.kGR = this.kGR ? false : true;
            this.mSortType = this.kGS;
            return false;
        }
        return true;
    }

    public boolean cYT() {
        return cZs();
    }

    public int cYU() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.kAA == null || this.kAA.getForum() == null || this.kAA.cVl() == null) ? false : true;
    }

    public boolean baA() {
        if (this.kAA == null) {
            return false;
        }
        return this.kAA.baA();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData BU(String str) {
        if (this.kAA == null || this.kAA.cVl() == null || this.kAA.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.kAA.cVl().bgb()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.kAA.getForum().getId());
            writeData.setForumName(this.kAA.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.kHK);
        writeData.setThreadId(this.kGK);
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
        if (this.kAA == null) {
            return null;
        }
        ArrayList<PostData> cVn = this.kAA.cVn();
        if (com.baidu.tbadk.core.util.y.isEmpty(cVn)) {
            return null;
        }
        if (cVn.size() > 0 && i >= cVn.size()) {
            i = cVn.size() - 1;
        }
        return o(cVn.get(i));
    }

    public MarkData cYV() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kGK);
        markData.setPostId(this.kAA.baz());
        markData.setTime(date.getTime());
        markData.setHostMode(this.kGP);
        markData.setSequence(Boolean.valueOf(cZs()));
        markData.setId(this.kGK);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kGK);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.kGP);
        markData.setSequence(Boolean.valueOf(cZs()));
        markData.setId(this.kGK);
        markData.setFloor(postData.dwF());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) postData).isApp());
        }
        return markData;
    }

    public void cYW() {
        j.cXh().aO(cYX(), this.isFromMark);
    }

    private String cYX() {
        String cYY = (this.kGK == null || this.kGK.equals("0")) ? cYY() : this.kGK;
        if (this.kGP) {
            cYY = cYY + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            cYY = cYY + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            cYY = cYY + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return cYY + TbadkCoreApplication.getCurrentAccount();
        }
        return cYY;
    }

    private String cYY() {
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

    public void th(boolean z) {
        if (this.kAA != null) {
            this.kAA.hA(z);
        }
    }

    public boolean cYZ() {
        return this.kHp;
    }

    public void a(a aVar) {
        this.kHk = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String brS() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean brR() {
        return cYO();
    }

    public boolean NA(String str) {
        if (getPbData() == null || getPbData().cVl() == null || getPbData().cVl().beE() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().cVl().beE().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int cZa() {
        return this.mRequestType;
    }

    public void cZb() {
        if ("personalize_page".equals(this.mStType)) {
            this.kHv = System.currentTimeMillis() / 1000;
        }
    }

    public void cZc() {
        if ("personalize_page".equals(this.mStType) && this.kAA != null && this.kHv != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10754").dD("fid", this.kAA.getForumId()).dD("tid", this.kGK).dD("obj_duration", String.valueOf(currentTimeMillis - this.kHv)).dD(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.kHv = 0L;
        }
    }

    public boolean cZd() {
        return this.kHy;
    }

    public int getErrorNo() {
        return this.kHA;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public q cZe() {
        return this.kHC;
    }

    public ai cZf() {
        return this.kHD;
    }

    public CheckRealNameModel cZg() {
        return this.kHF;
    }

    public AddExperiencedModel cZh() {
        return this.kHG;
    }

    public String cZi() {
        return this.kHu;
    }

    public void NB(String str) {
        this.kHu = str;
    }

    public boolean cZj() {
        return this.kHz;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.kAA != null && this.kAA.cVn() != null && this.kAA.cVn().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.kAA.cVn().size();
                for (int i = 0; i < size; i++) {
                    if (this.kAA.cVn().get(i) != null && this.kAA.cVn().get(i).beE() != null && currentAccount.equals(this.kAA.cVn().get(i).beE().getUserId()) && this.kAA.cVn().get(i).beE().getPendantData() != null) {
                        this.kAA.cVn().get(i).beE().getPendantData().zi(lVar.bcA());
                        this.kAA.cVn().get(i).beE().getPendantData().cY(lVar.bqZ());
                    }
                }
            }
        }
    }

    public String cZk() {
        return this.kHE;
    }

    public int cZl() {
        return this.kHK;
    }

    public void Ep(int i) {
        this.kHK = i;
    }

    public void NC(String str) {
        if ((!this.kGP || NA(TbadkCoreApplication.getCurrentAccount())) && this.kAA.cVn() != null) {
            this.kAA.getPage().mZ(1);
            if (this.kAA.getPage().bdu() == 0) {
                this.kAA.getPage().mZ(1);
            }
            this.kHL = str;
            Ek(8);
        }
    }

    private void Eq(int i) {
        if (i != 8) {
            this.kHL = "";
            if (this.kHM != null) {
                if (i == 1 && this.kAA != null && this.kAA.cVO()) {
                    if (this.kHN != null) {
                        getPbData().cVn().remove(this.kHN);
                    }
                } else if (i == 1 && !this.kGR && !com.baidu.tbadk.core.util.y.isEmpty(getPbData().cVn())) {
                    getPbData().cVn().remove(this.kHM);
                    if (this.kHN != null) {
                        getPbData().cVn().remove(this.kHN);
                    }
                    getPbData().cVn().add(0, this.kHM);
                } else {
                    getPbData().cVn().remove(this.kHM);
                    if (this.kHN != null) {
                        getPbData().cVn().remove(this.kHN);
                    }
                }
            }
            this.kHN = null;
        }
    }

    public void cZm() {
        if (this.kAA != null && !com.baidu.tbadk.core.util.y.isEmpty(this.kAA.cVn())) {
            if (this.kHN != null) {
                this.kAA.cVn().remove(this.kHN);
                this.kHN = null;
            }
            if (this.kHM != null) {
                this.kAA.cVn().remove(this.kHM);
                this.kHM = null;
            }
        }
    }

    public void cU(int i, int i2) {
        this.kHO = i;
        this.kHP = i2;
    }

    public PostData cZn() {
        return this.kHM;
    }

    public PostData cZo() {
        return this.kHN;
    }

    public int cZp() {
        return this.kHO;
    }

    public int cZq() {
        return this.kHP;
    }

    public String cZr() {
        return this.kHR;
    }

    public void ND(String str) {
        this.kHR = str;
    }

    private boolean cZs() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean cZt() {
        return this.kHK == 13 || this.kHK == 12 || this.kHK == 7;
    }

    public String cZu() {
        return this.kHU;
    }

    public String cZv() {
        return this.kHV;
    }

    public String cZw() {
        return this.kHW;
    }

    public String cZx() {
        return this.kHX;
    }

    public Rect cZy() {
        Rect rect = this.kHQ;
        this.kHQ = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int cZz() {
        int i;
        int i2 = 0;
        if (getPbData().cVn() == null) {
            return 0;
        }
        ArrayList<PostData> cVn = getPbData().cVn();
        int size = cVn.size() - 1;
        while (size >= 0) {
            PostData postData = cVn.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
                if (postData.getType() != AdvertAppInfo.dVT) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return cVn.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
