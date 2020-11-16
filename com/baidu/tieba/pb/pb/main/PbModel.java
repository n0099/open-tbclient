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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
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
    private boolean eFf;
    private BaseFragmentActivity imj;
    private com.baidu.tieba.tbadkCore.d.b ino;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private long jdq;
    private boolean kwY;
    protected com.baidu.tieba.pb.data.f lre;
    private boolean lxA;
    private boolean lxB;
    private int lxC;
    private boolean lxD;
    private int lxE;
    private long lxF;
    private int lxG;
    private int lxH;
    private int lxI;
    private int lxJ;
    private boolean lxK;
    private boolean lxL;
    private boolean lxM;
    private long lxN;
    private boolean lxO;
    private String lxP;
    private boolean lxQ;
    private boolean lxR;
    private boolean lxS;
    private boolean lxT;
    private a lxU;
    private String lxV;
    private String lxW;
    private int lxX;
    private int lxY;
    private boolean lxZ;
    protected String lxu;
    private String lxv;
    private String lxw;
    private String lxx;
    private boolean lxy;
    private boolean lxz;
    private int lyA;
    private Rect lyB;
    private String lyC;
    private com.baidu.tieba.tbadkCore.data.n lyD;
    private boolean lyE;
    private String lyF;
    private String lyG;
    private String lyH;
    private String lyI;
    private String lyJ;
    private f.a lyK;
    private CustomMessageListener lyL;
    private com.baidu.adp.framework.listener.a lyM;
    private PraiseData lyN;
    private boolean lya;
    private boolean lyb;
    private boolean lyc;
    private boolean lyd;
    private String lye;
    private long lyf;
    private boolean lyg;
    private int lyh;
    private boolean lyi;
    private boolean lyj;
    private int lyk;
    private final ag lyl;
    private final q lym;
    private final ai lyn;
    private String lyp;
    private final CheckRealNameModel lyq;
    private final AddExperiencedModel lyr;
    private SuggestEmotionModel lys;
    private GetSugMatchWordsModel lyt;
    private boolean lyu;
    private int lyv;
    private String lyw;
    private PostData lyx;
    private PostData lyy;
    private int lyz;
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
    private static final int lxt = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes21.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.f fVar);
    }

    public PbModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.mStType = null;
        this.lxu = null;
        this.isPrivacy = false;
        this.lxv = null;
        this.lxw = null;
        this.mForumId = null;
        this.lxx = null;
        this.lxy = false;
        this.lxz = false;
        this.lxA = true;
        this.lxB = true;
        this.mSortType = 0;
        this.lxC = 0;
        this.lxD = false;
        this.mIsGood = 0;
        this.lxE = 0;
        this.lxF = 0L;
        this.lxG = 1;
        this.lxH = 1;
        this.lxI = 1;
        this.lxJ = 1;
        this.isAd = false;
        this.kwY = false;
        this.eFf = false;
        this.lxK = false;
        this.isFromMark = false;
        this.lxL = false;
        this.lxM = false;
        this.lxN = 0L;
        this.lxO = false;
        this.lxP = null;
        this.lre = null;
        this.isLoading = false;
        this.lxQ = false;
        this.lxR = false;
        this.lxS = false;
        this.lxT = false;
        this.mLocate = null;
        this.mContext = null;
        this.lxU = null;
        this.opType = null;
        this.opUrl = null;
        this.lxV = null;
        this.lxW = null;
        this.lxX = -1;
        this.lxY = -1;
        this.ino = null;
        this.lya = false;
        this.lyb = false;
        this.postID = null;
        this.lye = null;
        this.lyf = 0L;
        this.lyg = false;
        this.lyh = -1;
        this.lyj = false;
        this.lyu = false;
        this.lyv = 0;
        this.mTabIndex = 0;
        this.lyE = false;
        this.lyL = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.lyM = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.imj.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.lya || !PbModel.this.lyb) {
                        if (!PbModel.this.lya) {
                            PbModel.this.lya = true;
                        } else {
                            PbModel.this.lyb = true;
                        }
                        if (PbModel.this.lxU != null) {
                            PbModel.this.lxU.a(PbModel.this.dkP(), z, responsedMessage, PbModel.this.lyc, System.currentTimeMillis() - PbModel.this.jdq);
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
                    if (PbModel.this.lre != null && PbModel.this.lre.dhG() != null && PbModel.this.lre.dhG().getForumId() != null && PbModel.this.lre.dhG().getForumId().equals(valueOf)) {
                        PbModel.this.lre.dhG().setIsLike(false);
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
                    if (PbModel.this.lre != null && PbModel.this.lre.dhG() != null && PbModel.this.lre.dhG().getForumId() != null && PbModel.this.lre.dhG().getForumId().equals(valueOf)) {
                        PbModel.this.lre.dhG().setIsLike(true);
                    }
                }
            }
        };
        this.lyN = null;
        registerListener(this.lyM);
        registerListener(this.lyL);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.lre = new com.baidu.tieba.pb.data.f();
        this.lre.Ga(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.imj = baseFragmentActivity;
        this.lyl = new ag(this, this.imj);
        this.lym = new q(this, this.imj);
        this.lyn = new ai(this, this.imj);
        this.lyq = new CheckRealNameModel(this.imj.getPageContext());
        this.lys = new SuggestEmotionModel();
        this.lyr = new AddExperiencedModel(this.imj.getPageContext());
        this.lyK = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void onCallBack(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eqc) instanceof String) {
                        PbModel.this.lxu = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eqc);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eqd) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eqd);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eqe) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eqe);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eqf) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.eqf), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eqg) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eqg);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.lyd = true;
        if (fVar != null && fVar.lnm == null) {
            q(fVar);
            l(fVar);
            if (fVar.dhH() != null) {
                fVar.dhH().od(0);
            }
            if (this.lxU != null && fVar != null) {
                this.lxU.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int dkP() {
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
            this.lxu = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.lyJ = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                com.baidu.tbadk.BdToken.f.bfS().c(uri, this.lyK);
            } else if (StringUtils.isNull(this.lxu)) {
                this.lyl.a(intent, this.lyK);
                if (uri != null) {
                    if (StringUtils.isNull(this.lxu)) {
                        this.lxu = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.au.isEmpty(this.lxu)) {
                this.lxu = "0";
            }
            this.lyv = intent.getIntExtra("key_start_from", 0);
            if (this.lyv == 0) {
                this.lyv = this.lyl.aIJ;
            }
            this.lxw = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.lxv = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.lxy = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.lxz = intent.getBooleanExtra("host_only", false);
            this.lxB = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.lxw = this.mSortType == 2 ? "0" : this.lxw;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.lxE = intent.getIntExtra("is_top", 0);
            this.lxF = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.lxL = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.lxM = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.kwY = intent.getBooleanExtra("is_sub_pb", false);
            this.lxO = intent.getBooleanExtra("is_pv", false);
            this.lxN = intent.getLongExtra("msg_id", 0L);
            this.lxP = intent.getStringExtra("from_forum_name");
            this.lxW = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.lxV = intent.getStringExtra("op_stat");
            this.lxQ = intent.getBooleanExtra("is_from_thread_config", false);
            this.lxR = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.lxS = intent.getBooleanExtra("is_from_my_god_config", false);
            this.lxY = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.lxX = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.eFf = intent.getBooleanExtra("from_frs", false);
            this.lxK = intent.getBooleanExtra("from_maintab", false);
            this.lyj = intent.getBooleanExtra("from_smart_frs", false);
            this.lxT = intent.getBooleanExtra("from_hottopic", false);
            this.lyp = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.lxx = intent.getStringExtra("high_light_post_id");
            this.lyE = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.lxZ = intent.getIntExtra("request_code", -1) == 18003;
            this.lyF = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.lyG = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.lyH = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.lyI = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean dkQ() {
        return this.lyE && com.baidu.tieba.frs.l.cxD() != null && com.baidu.tieba.frs.l.cxD().equals(this.lxu) && com.baidu.tieba.frs.l.cxC() != null;
    }

    public com.baidu.tieba.pb.data.f aK(bx bxVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.Ga(3);
        if (bxVar == null) {
            return null;
        }
        fVar.aH(bxVar);
        if (bxVar.bns() != null) {
            fVar.d(bxVar.bns());
            ForumData forum = fVar.getForum();
            forum.setId(bxVar.bns().getForumId());
            forum.setName(bxVar.bns().getForumName());
            forum.setUser_level(bxVar.bns().bkS());
            forum.setImage_url(bxVar.bns().getAvatar());
            forum.setPost_num(bxVar.bns().postNum);
            forum.setMember_num(bxVar.bns().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(bxVar.getFid()));
            forum2.setName(bxVar.blG());
        }
        PostData postData = new PostData();
        postData.Kf(1);
        postData.setTime(bxVar.getCreateTime());
        postData.a(bxVar.blC());
        MetaData blC = bxVar.blC();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(blC.getUserId(), blC);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bxVar.bls(), false));
        fVar.d(postData);
        fVar.dhJ().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.o(bxVar, null));
        fVar.lnr = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.lyv = bundle.getInt("key_start_from", 0);
        this.lxu = bundle.getString("thread_id");
        this.lxw = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.lxv = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.lxy = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.lxz = bundle.getBoolean("host_only", false);
        this.lxB = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.lxE = bundle.getInt("is_top", 0);
        this.lxF = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.lxM = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.kwY = bundle.getBoolean("is_sub_pb", false);
        this.lxO = bundle.getBoolean("is_pv", false);
        this.lxN = bundle.getLong("msg_id", 0L);
        this.lxP = bundle.getString("from_forum_name");
        this.lxW = bundle.getString("extra_pb_cache_key");
        this.lxQ = bundle.getBoolean("is_from_thread_config", false);
        this.lxR = bundle.getBoolean("is_from_interview_live_config", false);
        this.lxS = bundle.getBoolean("is_from_my_god_config", false);
        this.lxY = bundle.getInt("extra_pb_is_attention_key", -1);
        this.lxX = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eFf = bundle.getBoolean("from_frs", false);
        this.lxK = bundle.getBoolean("from_maintab", false);
        this.lyj = bundle.getBoolean("from_smart_frs", false);
        this.lxT = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.lxx = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.lxZ = bundle.getInt("request_code", -1) == 18003;
        this.lyF = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.lyG = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.lyH = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.lyI = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aC(Bundle bundle) {
        bundle.putString("thread_id", this.lxu);
        bundle.putString("post_id", this.lxw);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.lyv);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.lxy);
        bundle.putBoolean("host_only", this.lxz);
        bundle.putBoolean("squence", this.lxB);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.lxE);
        bundle.putLong("thread_time", this.lxF);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.lxM);
        bundle.putBoolean("is_sub_pb", this.kwY);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.lxO);
        bundle.putLong("msg_id", this.lxN);
        bundle.putString("extra_pb_cache_key", this.lxW);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.lxQ);
        bundle.putBoolean("is_from_interview_live_config", this.lxR);
        bundle.putBoolean("is_from_my_god_config", this.lxS);
        bundle.putInt("extra_pb_is_attention_key", this.lxY);
        bundle.putInt("extra_pb_funs_count_key", this.lxX);
        bundle.putBoolean("from_frs", this.eFf);
        bundle.putBoolean("from_maintab", this.lxK);
        bundle.putBoolean("from_smart_frs", this.lyj);
        bundle.putBoolean("from_hottopic", this.lxT);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.lxx);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.lyF);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.lyG);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.lyH);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.lyI);
    }

    public String dkR() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.lxu);
        if (!this.lxM) {
            sb.append(this.lxw);
        }
        sb.append(this.lxz);
        sb.append(this.lxB);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.lxE);
        sb.append(this.lxF);
        sb.append(this.eFf);
        sb.append(this.lxK);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.kwY);
        sb.append(this.lxO);
        sb.append(this.lxN);
        sb.append(this.lxP);
        sb.append(this.mThreadType);
        sb.append(this.lxQ);
        sb.append(this.lxR);
        sb.append(this.lxS);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.lxW != null) {
            sb.append(this.lxW);
        }
        return sb.toString();
    }

    public String diO() {
        return this.lxP;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String dkS() {
        return this.lxw;
    }

    public String dkT() {
        return this.lxx;
    }

    public String dkU() {
        return this.lxu;
    }

    public String dkV() {
        return (StringUtils.isNull(this.lxu) || "0".equals(this.lxu)) ? this.oriUgcNid : this.lxu;
    }

    public boolean getHostMode() {
        return this.lxz;
    }

    public boolean dkW() {
        return dlL();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean dkX() {
        return this.eFf;
    }

    public boolean dkY() {
        return this.lxD;
    }

    public boolean dkZ() {
        return this.lxK;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean dla() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int cqF() {
        return this.lxE;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void Gs(int i) {
        this.lxE = i;
    }

    public boolean dlb() {
        return this.kwY;
    }

    public boolean dlc() {
        if (this.lre == null) {
            return false;
        }
        return this.lre.isValid();
    }

    public String blK() {
        if (this.lre == null || !this.lre.bhP()) {
            return null;
        }
        return this.lre.bhO();
    }

    public boolean Gt(int i) {
        this.lxG = i;
        if (this.lxG > this.lre.getPage().bkn()) {
            this.lxG = this.lre.getPage().bkn();
        }
        if (this.lxG < 1) {
            this.lxG = 1;
        }
        if (this.lxu == null) {
            return false;
        }
        return Gv(5);
    }

    public void Gu(int i) {
        this.lxG = i;
        this.lxH = i;
        this.lxI = i;
    }

    public void b(com.baidu.tbadk.core.data.aw awVar) {
        if (awVar == null) {
            Gu(1);
            return;
        }
        if (this.lxH < awVar.bkq()) {
            this.lxH = awVar.bkq();
        }
        if (this.lxI > awVar.bkq()) {
            this.lxI = awVar.bkq();
        }
        this.lxJ = awVar.bkn();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.lre;
    }

    public BaijiahaoData dld() {
        if (this.lre == null || this.lre.dhH() == null) {
            return null;
        }
        return this.lre.dhH().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f dle() {
        if (this.lre == null) {
            return this.lre;
        }
        if (!dlf() && this.lyD != null) {
            this.lre.b(this.lyD);
        }
        return this.lre;
    }

    private boolean dlf() {
        return (this.lre.dhZ() == null || this.lre.dhZ().dJE() == null || this.lre.dhZ().dJE().goods != null || this.lre.dhZ().dJE().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.aw getPageData() {
        if (this.lre == null) {
            return null;
        }
        return this.lre.getPage();
    }

    public boolean dlg() {
        if (dlL() && this.lre.getPage().bks() == 0) {
            uy(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.lxu = fVar.getThreadId();
            if (fVar.dhH() != null && fVar.dhH().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.dhH().getBaijiahaoData();
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
            this.lxw = null;
            this.lxz = false;
            this.lxB = true;
            LoadData();
        }
    }

    public void OV(String str) {
        if (!StringUtils.isNull(str)) {
            this.lxu = str;
            this.lxw = null;
            this.lxz = false;
            this.lxB = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lxu == null) {
            return false;
        }
        cancelLoadData();
        if (this.ino == null) {
            this.ino = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.ino.start();
        }
        boolean Gv = Gv(3);
        if (this.opType != null) {
            this.opType = null;
            this.lxV = null;
            this.opUrl = null;
            return Gv;
        }
        return Gv;
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
        if (this.lys != null) {
            this.lys.cancelLoadData();
        }
        if (this.lyt != null) {
            this.lyt.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dAN().dAR();
        csd();
    }

    private void csd() {
        if (this.ino != null) {
            this.ino.destory();
            this.ino = null;
        }
    }

    public boolean dlh() {
        return (this.lxw == null || this.lxw.equals("0") || this.lxw.length() == 0) ? LoadData() : dll();
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
                this.lys.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.lys.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.lyt == null) {
                this.lyt = new GetSugMatchWordsModel(this.imj.getPageContext());
            }
            this.lyt.b(aVar);
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
    public boolean Gv(int i) {
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
        Gw(i);
        final com.baidu.tieba.pb.data.f pbData = as.dmr().getPbData();
        if (pbData != null && pbData.dhH() != null) {
            pbData.dhH().od(0);
            this.lxB = as.dmr().dkW();
            this.lxz = as.dmr().dmw();
            this.lxD = as.dmr().dmx();
            this.lyx = as.dmr().dmv();
            this.lyy = as.dmr().dmu();
            this.lyz = as.dmr().dmt();
            this.lyB = as.dmr().dmy();
            this.mTabIndex = as.dmr().getTabIndex();
            this.lyu = this.lxz;
            if (this.lxz || this.isFromMark) {
                this.lxZ = false;
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
        if (i == 4 && !this.lyd) {
            a(dlq(), true, this.lxw, 3);
        }
        if (i == 3 && !this.lyd) {
            if (this.isFromMark) {
                a(dlq(), true, this.lxw, 3);
            } else {
                a(dlq(), false, this.lxw, 3);
            }
        }
        this.lyd = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.lyD == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.flJ);
        if (this.lxz || this.isFromMark) {
            this.lxZ = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.lxu == null || this.lxu.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.lxu, 0L));
        if (com.baidu.tbadk.a.d.bho()) {
            pbPageRequestMessage.setFloorSortType(1);
            pbPageRequestMessage.set_rn(15);
        } else {
            pbPageRequestMessage.set_rn(30);
        }
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.av.bqC().bqD() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.lxB) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.lxz) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.lxO) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.lxN));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.lxZ) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.lxV, 0));
            pbPageRequestMessage.setOpMessageID(this.lxN);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> dhJ = this.lre.dhJ();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lxI - 1));
                        if (this.lxI - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.lxL) {
                                if (dhJ != null && dhJ.size() > 0) {
                                    size = dhJ.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = dhJ.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.lxw = postData.getId();
                                            if (StringUtils.isNull(this.lxw)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.lxH + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.lxw == null && this.lxw.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lxw, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lxH + 1));
                        if (this.lxH >= this.lxJ) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (dhJ != null) {
                                size = dhJ.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.lxw == null) {
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
                if (dhJ != null) {
                }
                if (this.lxw == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (dhJ != null && dhJ.size() > 0 && dhJ.get(0) != null) {
                    this.lxw = dhJ.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (dlL()) {
                        if (this.lxI - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.lxI - 1));
                        }
                    } else if (this.lxH < this.lxJ) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lxH + 1));
                    }
                }
                if (this.lxw != null && this.lxw.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lxw, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.lxz) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (dlL()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.lxJ > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lxJ));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lxw, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.lxG));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.lyu && !this.lxz) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lxw, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.lxz) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.lyh);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lyw, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.lyu = this.lxz;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(dlq());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.lyv));
        pbPageRequestMessage.setIsSubPostDataReverse(this.lyg);
        pbPageRequestMessage.setFromSmartFrs(this.lyj ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.lxy);
        if (this.lyv == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.lyJ)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.lyJ));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.lxJ) {
                    i4 = -1;
                } else {
                    i4 = dlS();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = dlS();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.lxu);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean diN() {
        switch (dlE()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().dhH() == null || !getPbData().dhH().bnb();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(diO()) && com.baidu.tieba.recapp.q.dzO().dzI() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.dzO().dzI().aZ(diO(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.dzO().dzI().ba(diO(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(diO()) && com.baidu.tieba.recapp.q.dzO().dzI() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.dzO().dzI().ba(diO(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.dzO().dzI().aZ(diO(), true));
        }
    }

    protected void Gw(int i) {
        boolean z = false;
        GB(i);
        ArrayList<PostData> dhJ = this.lre.dhJ();
        this.lyc = false;
        if (i == 1) {
            boolean z2 = false;
            while (dhJ.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                dhJ.remove(0);
                z2 = true;
            }
            if (z2) {
                this.lre.getPage().nZ(1);
                if (this.lxU != null) {
                    this.lxU.e(this.lre);
                }
            }
            this.jdq = System.currentTimeMillis();
            this.lyc = true;
        } else if (i == 2) {
            while (dhJ.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                dhJ.remove(dhJ.size() - 1);
                z = true;
            }
            if (z) {
                this.lre.getPage().nY(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.lyk = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.lyD != null && this.lyD.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.t.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dhZ() != null && fVar.dhZ().dJE() != null && fVar.dhZ().dJE().goods != null && fVar.dhZ().isValidate() && fVar.dhZ().dJE().goods.goods_style != 1001) {
            this.lyD = fVar.dhZ();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n dli() {
        return this.lyD;
    }

    public void dlj() {
        this.lyD = null;
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
            if (this.lxS || this.lxQ || this.lxR) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.dhJ().size(); i++) {
                PostData postData = fVar.dhJ().get(i);
                for (int i2 = 0; i2 < postData.dJN().size(); i2++) {
                    postData.dJN().get(i2).a(this.imj.getPageContext(), o.equals(postData.dJN().get(i2).blC().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r dhV = fVar.dhV();
            if (dhV != null && !com.baidu.tbadk.core.util.y.isEmpty(dhV.loU)) {
                for (PostData postData2 : dhV.loU) {
                    for (int i3 = 0; i3 < postData2.dJN().size(); i3++) {
                        postData2.dJN().get(i3).a(this.imj.getPageContext(), o.equals(postData2.dJN().get(i3).blC().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r dhV = fVar.dhV();
            if (dhV != null && !com.baidu.tbadk.core.util.y.isEmpty(dhV.loU)) {
                for (PostData postData : dhV.loU.subList(i, dhV.loU.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dJN().size()) {
                            postData.dJN().get(i3).a(this.imj.getPageContext(), o.equals(postData.dJN().get(i3).blC().getUserId()));
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
        bx dhH = fVar.dhH();
        dhH.oi(this.mIsGood);
        dhH.oh(this.lxE);
        if (this.lxF > 0) {
            dhH.dh(this.lxF);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.dhH() != null && fVar.dhH().blC() != null) {
            str = fVar.dhH().blC().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData dlk() {
        if (this.lre == null || this.lre.dhH() == null || this.lre.dhH().blC() == null) {
            return null;
        }
        return this.lre.dhH().blC();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.lyi = z3;
        if (this.ino != null && !z3) {
            this.ino.a(z2, z4, i2, str, i3, j, j2);
            this.ino = null;
        }
        if (this.lre != null) {
            this.lre.lnZ = z3;
            this.lre.YM = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(diO()) && com.baidu.tieba.recapp.q.dzO().dzI() != null) {
            com.baidu.tieba.recapp.q.dzO().dzI().f(diO(), Gx(dlt()), true);
        }
        if (fVar == null || (this.lxG == 1 && i == 5 && fVar.dhJ() != null && fVar.dhJ().size() < 1)) {
            if (this.lxU != null) {
                this.lxB = this.lxA;
                if (i2 != 350006) {
                    this.mSortType = this.lxC;
                }
                this.lxU.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.lxA = this.lxB;
            if (i != 8) {
                this.lxC = this.mSortType;
                this.mSortType = fVar.lnl;
            }
            if (fVar.lnk != null && fVar.lnk.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.imj.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.lnk = new ArrayList();
                fVar.lnk.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.imj.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.lnk.add(builder2.build(false));
                this.mSortType = this.lxC;
                fVar.lnl = this.mSortType;
            }
            this.lxO = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.lxJ = this.lxJ < 1 ? 1 : this.lxJ;
            int i6 = 0;
            ArrayList<PostData> dhJ = this.lre.dhJ();
            switch (i) {
                case 1:
                    this.lre.a(fVar.getPage(), 1);
                    d(fVar, dhJ);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.dhJ() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.dhJ().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dhJ, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dhJ(), com.baidu.tbadk.core.util.y.getCount(fVar.dhJ()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.dhJ().remove(postData2);
                            i5 = size2 - 1;
                        }
                        dhJ.addAll(0, fVar.dhJ());
                    }
                    p(fVar);
                    this.lre.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().nW(fVar.getPage().bkn());
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
                    if (fVar != null && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dhJ()) && this.lre != null && (!this.lxz || o(fVar).equals(fVar.dhJ().get(0).blC().getUserId()))) {
                        if (this.lre.getPage().bks() == 0) {
                            this.lre.getPage().nY(1);
                        }
                        dlF();
                        this.lyx = fVar.dhJ().get(0);
                        if (dlL() || this.lre.dik()) {
                            if (this.lre.dhJ().size() - this.lyz >= 3) {
                                this.lyy = new PostData();
                                this.lyy.mYj = true;
                                this.lyy.setPostType(53);
                                this.lre.dhJ().add(this.lyy);
                            }
                            this.lre.dhJ().add(this.lyx);
                            size = this.lre.dhJ().size() - 1;
                        } else {
                            if (this.lyz - this.lyA >= 3) {
                                this.lyy = new PostData();
                                this.lyy.mYj = false;
                                this.lyy.setPostType(53);
                                this.lre.dhJ().add(0, this.lyy);
                            }
                            this.lre.dhJ().add(0, this.lyx);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.au.isTaday(com.baidu.tbadk.core.sharedPref.b.bpu().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.lyx.mYw = this.lre.dii();
                            com.baidu.tbadk.core.sharedPref.b.bpu().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.lre != null && this.lre.dhH() != null) {
                PraiseData bln = this.lre.dhH().bln();
                if (this.lyN != null && !bln.isPriaseDataValid()) {
                    this.lre.dhH().a(this.lyN);
                } else {
                    this.lyN = this.lre.dhH().bln();
                    this.lyN.setPostId(this.lre.dhH().blT());
                }
                if (fVar.getPage() != null && fVar.getPage().bkq() == 1 && fVar.dhH() != null && fVar.dhH().blM() != null && fVar.dhH().blM().size() > 0) {
                    this.lre.dhH().E(fVar.dhH().blM());
                }
                this.lre.dhH().of(fVar.dhH().blt());
                this.lre.dhH().oc(fVar.dhH().getAnchorLevel());
                this.lre.dhH().od(fVar.dhH().blj());
                if (this.mThreadType == 33) {
                    this.lre.dhH().blC().setHadConcerned(fVar.dhH().blC().hadConcerned());
                }
                if (fVar != null && fVar.dhH() != null) {
                    this.lre.dhH().ok(fVar.dhH().blQ());
                }
            }
            if (this.lre != null && this.lre.getUserData() != null && fVar.getUserData() != null) {
                this.lre.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.lre.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().bkq() == 1 && fVar.dhU() != null) {
                this.lre.f(fVar.dhU());
            }
            if (this.lyi) {
                if (this.lre.dhH() != null && this.lre.dhH().blC() != null && this.lre.dhJ() != null && com.baidu.tbadk.core.util.y.getItem(this.lre.dhJ(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(this.lre.dhJ(), 0);
                    MetaData blC = this.lre.dhH().blC();
                    if (postData3.blC() != null && postData3.blC().getGodUserData() != null) {
                        if (this.lxX != -1) {
                            blC.setFansNum(this.lxX);
                            postData3.blC().setFansNum(this.lxX);
                        }
                        if (this.lxY != -1) {
                            blC.getGodUserData().setIsLike(this.lxY == 1);
                            postData3.blC().getGodUserData().setIsLike(this.lxY == 1);
                            blC.getGodUserData().setIsFromNetWork(false);
                            postData3.blC().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.lre.lnj = -1;
                this.lre.lni = -1;
            }
            if (this.lxU != null) {
                this.lxU.a(true, getErrorCode(), i, i4, this.lre, this.mErrorString, 1);
            }
        }
        if (this.lre != null && this.lre.dhH() != null && this.lre.getForum() != null && !this.lre.dik()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.imj.getPageContext();
            historyMessage.threadId = getPbData().dhH().getId();
            if (this.mIsShareThread && getPbData().dhH().eEF != null) {
                historyMessage.threadName = getPbData().dhH().eEF.showText;
            } else {
                historyMessage.threadName = getPbData().dhH().getTitle();
            }
            if (this.mIsShareThread && !diN()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = dkW();
            historyMessage.threadType = getPbData().dhH().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.lre != null) {
            this.lre.dhY().clear();
            this.lre.dhY().addAll(fVar.dhY());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String bc;
        if (arrayList != null && fVar.dhJ() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dhJ(), 0);
            if (postData != null && (bc = bc(arrayList)) != null && bc.equals(postData.getId())) {
                fVar.dhJ().remove(postData);
            }
            this.lre.lnY = arrayList.size();
            arrayList.addAll(fVar.dhJ());
        }
    }

    private int Gx(int i) {
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

    private String bc(ArrayList<PostData> arrayList) {
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
            fVar.OO(this.lre.dic());
            if (!this.lre.lnW && fVar.lnW && this.lre.dhR() != null) {
                fVar.e(this.lre.dhR());
            }
            this.lre = fVar;
            Gu(fVar.getPage().bkq());
        }
    }

    public boolean dll() {
        if (this.lxu == null || this.lxw == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return Gv(4);
        }
        return Gv(6);
    }

    public boolean uy(boolean z) {
        if (this.lxu == null || this.lre == null) {
            return false;
        }
        if (z || this.lre.getPage().bks() != 0) {
            return Gv(1);
        }
        return false;
    }

    public boolean uz(boolean z) {
        if (this.lxu == null || this.lre == null) {
            return false;
        }
        if ((z || this.lre.getPage().bkt() != 0) && this.lre.dhJ() != null && this.lre.dhJ().size() >= 1) {
            return Gv(2);
        }
        return false;
    }

    public boolean Pb(String str) {
        this.lxz = !this.lxz;
        this.lxw = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("pb_onlyowner_click").ak("obj_source", 0));
        if (Gv(6)) {
            return true;
        }
        this.lxz = this.lxz ? false : true;
        return false;
    }

    public boolean C(boolean z, String str) {
        if (this.lxz == z) {
            return false;
        }
        this.lxz = z;
        this.lxw = str;
        if (this.mSortType == 2) {
            this.lxw = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("pb_onlyowner_click").ak("obj_source", 1));
        }
        if (Gv(6)) {
            return true;
        }
        this.lxz = z ? false : true;
        return false;
    }

    public boolean Gy(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_pb_current_sort_type", i);
        }
        this.lxA = this.lxB;
        this.lxC = this.mSortType;
        this.mSortType = i;
        this.lxB = !this.lxB;
        if (i == 2 && this.isFromMark) {
            this.lxw = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.lxB = this.lxB ? false : true;
            this.mSortType = this.lxC;
            return false;
        }
        return true;
    }

    public boolean dlm() {
        return dlL();
    }

    public int dln() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.lre == null || this.lre.getForum() == null || this.lre.dhH() == null) ? false : true;
    }

    public boolean bhP() {
        if (this.lre == null) {
            return false;
        }
        return this.lre.bhP();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData Dj(String str) {
        if (this.lre == null || this.lre.dhH() == null || this.lre.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.lre.dhH().bnb()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.lre.getForum().getId());
            writeData.setForumName(this.lre.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.lyv);
        writeData.setThreadId(this.lxu);
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

    public MarkData Gz(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.lre == null) {
            return null;
        }
        ArrayList<PostData> dhJ = this.lre.dhJ();
        if (com.baidu.tbadk.core.util.y.isEmpty(dhJ)) {
            return null;
        }
        if (dhJ.size() > 0 && i >= dhJ.size()) {
            i = dhJ.size() - 1;
        }
        return o(dhJ.get(i));
    }

    public MarkData dlo() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lxu);
        markData.setPostId(this.lre.bhO());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lxz);
        markData.setSequence(Boolean.valueOf(dlL()));
        markData.setId(this.lxu);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lxu);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lxz);
        markData.setSequence(Boolean.valueOf(dlL()));
        markData.setId(this.lxu);
        markData.setFloor(postData.dJQ());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) postData).isApp());
        }
        return markData;
    }

    public void dlp() {
        j.djz().aU(dlq(), this.isFromMark);
    }

    private String dlq() {
        String dlr = (this.lxu == null || this.lxu.equals("0")) ? dlr() : this.lxu;
        if (this.lxz) {
            dlr = dlr + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            dlr = dlr + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            dlr = dlr + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return dlr + TbadkCoreApplication.getCurrentAccount();
        }
        return dlr;
    }

    private String dlr() {
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

    public void uA(boolean z) {
        if (this.lre != null) {
            this.lre.is(z);
        }
    }

    public boolean dls() {
        return this.lxZ;
    }

    public void a(a aVar) {
        this.lxU = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bzp() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bzo() {
        return dlh();
    }

    public boolean Pc(String str) {
        if (getPbData() == null || getPbData().dhH() == null || getPbData().dhH().blC() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().dhH().blC().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int dlt() {
        return this.mRequestType;
    }

    public void dlu() {
        if ("personalize_page".equals(this.mStType)) {
            this.lyf = System.currentTimeMillis() / 1000;
        }
    }

    public void dlv() {
        if ("personalize_page".equals(this.mStType) && this.lre != null && this.lyf != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10754").dR("fid", this.lre.getForumId()).dR("tid", this.lxu).dR("obj_duration", String.valueOf(currentTimeMillis - this.lyf)).dR(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.lyf = 0L;
        }
    }

    public boolean dlw() {
        return this.lyi;
    }

    public int getErrorNo() {
        return this.lyk;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public q dlx() {
        return this.lym;
    }

    public ai dly() {
        return this.lyn;
    }

    public CheckRealNameModel dlz() {
        return this.lyq;
    }

    public AddExperiencedModel dlA() {
        return this.lyr;
    }

    public String dlB() {
        return this.lye;
    }

    public void Pd(String str) {
        this.lye = str;
    }

    public boolean dlC() {
        return this.lyj;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.lre != null && this.lre.dhJ() != null && this.lre.dhJ().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lre.dhJ().size();
                for (int i = 0; i < size; i++) {
                    if (this.lre.dhJ().get(i) != null && this.lre.dhJ().get(i).blC() != null && currentAccount.equals(this.lre.dhJ().get(i).blC().getUserId()) && this.lre.dhJ().get(i).blC().getPendantData() != null) {
                        this.lre.dhJ().get(i).blC().getPendantData().As(mVar.bjy());
                        this.lre.dhJ().get(i).blC().getPendantData().dF(mVar.bym());
                    }
                }
            }
        }
    }

    public String dlD() {
        return this.lyp;
    }

    public int dlE() {
        return this.lyv;
    }

    public void GA(int i) {
        this.lyv = i;
    }

    public void Pe(String str) {
        if ((!this.lxz || Pc(TbadkCoreApplication.getCurrentAccount())) && this.lre.dhJ() != null) {
            this.lre.getPage().nY(1);
            if (this.lre.getPage().bks() == 0) {
                this.lre.getPage().nY(1);
            }
            this.lyw = str;
            Gv(8);
        }
    }

    private void GB(int i) {
        if (i != 8) {
            this.lyw = "";
            if (this.lyx != null) {
                if (i == 1 && this.lre != null && this.lre.dik()) {
                    if (this.lyy != null) {
                        getPbData().dhJ().remove(this.lyy);
                    }
                } else if (i == 1 && !this.lxB && !com.baidu.tbadk.core.util.y.isEmpty(getPbData().dhJ())) {
                    getPbData().dhJ().remove(this.lyx);
                    if (this.lyy != null) {
                        getPbData().dhJ().remove(this.lyy);
                    }
                    getPbData().dhJ().add(0, this.lyx);
                } else {
                    getPbData().dhJ().remove(this.lyx);
                    if (this.lyy != null) {
                        getPbData().dhJ().remove(this.lyy);
                    }
                }
            }
            this.lyy = null;
        }
    }

    public void dlF() {
        if (this.lre != null && !com.baidu.tbadk.core.util.y.isEmpty(this.lre.dhJ())) {
            if (this.lyy != null) {
                this.lre.dhJ().remove(this.lyy);
                this.lyy = null;
            }
            if (this.lyx != null) {
                this.lre.dhJ().remove(this.lyx);
                this.lyx = null;
            }
        }
    }

    public void db(int i, int i2) {
        this.lyz = i;
        this.lyA = i2;
    }

    public PostData dlG() {
        return this.lyx;
    }

    public PostData dlH() {
        return this.lyy;
    }

    public int dlI() {
        return this.lyz;
    }

    public int dlJ() {
        return this.lyA;
    }

    public String dlK() {
        return this.lyC;
    }

    public void Pf(String str) {
        this.lyC = str;
    }

    private boolean dlL() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean dlM() {
        return this.lyv == 13 || this.lyv == 12 || this.lyv == 7;
    }

    public String dlN() {
        return this.lyF;
    }

    public String dlO() {
        return this.lyG;
    }

    public String dlP() {
        return this.lyH;
    }

    public String dlQ() {
        return this.lyI;
    }

    public Rect dlR() {
        Rect rect = this.lyB;
        this.lyB = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int dlS() {
        int i;
        int i2 = 0;
        if (getPbData().dhJ() == null) {
            return 0;
        }
        ArrayList<PostData> dhJ = getPbData().dhJ();
        int size = dhJ.size() - 1;
        while (size >= 0) {
            PostData postData = dhJ.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
                if (postData.getType() != AdvertAppInfo.ewQ) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return dhJ.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
