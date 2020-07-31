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
import com.baidu.tbadk.core.data.bv;
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
    private boolean dUI;
    private long hZL;
    private BaseFragmentActivity hjZ;
    private com.baidu.tieba.tbadkCore.d.b hli;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private boolean jrn;
    protected com.baidu.tieba.pb.data.f klg;
    private boolean krA;
    private boolean krB;
    private boolean krC;
    private a krD;
    private String krE;
    private String krF;
    private int krG;
    private int krH;
    private boolean krI;
    private boolean krJ;
    private boolean krK;
    private boolean krL;
    private boolean krM;
    private String krN;
    private long krO;
    private boolean krP;
    private int krQ;
    private boolean krR;
    private boolean krS;
    private int krT;
    private final ag krU;
    private final q krV;
    private final ai krW;
    private String krX;
    private final CheckRealNameModel krY;
    private final AddExperiencedModel krZ;
    protected String krd;
    private String kre;
    private String krf;
    private String krg;
    private boolean krh;
    private boolean kri;
    private boolean krj;
    private boolean krk;
    private int krl;
    private boolean krm;
    private int krn;
    private long kro;
    private int krp;
    private int krq;
    private int krr;
    private int krs;
    private boolean krt;
    private boolean kru;
    private boolean krv;
    private long krw;
    private boolean krx;
    private String kry;
    private boolean krz;
    private SuggestEmotionModel ksa;
    private GetSugMatchWordsModel ksb;
    private boolean ksc;
    private int ksd;
    private String kse;
    private PostData ksf;
    private PostData ksg;
    private int ksh;
    private int ksi;
    private Rect ksj;
    private String ksk;
    private com.baidu.tieba.tbadkCore.data.n ksl;
    private boolean ksm;
    private String ksn;
    private String kso;
    private String ksp;
    private String ksq;
    private String ksr;
    private f.a kss;
    private CustomMessageListener kst;
    private com.baidu.adp.framework.listener.a ksu;
    private PraiseData ksv;
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
    private static final int krc = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.krd = null;
        this.isPrivacy = false;
        this.kre = null;
        this.krf = null;
        this.mForumId = null;
        this.krg = null;
        this.krh = false;
        this.kri = false;
        this.krj = true;
        this.krk = true;
        this.mSortType = 0;
        this.krl = 0;
        this.krm = false;
        this.mIsGood = 0;
        this.krn = 0;
        this.kro = 0L;
        this.krp = 1;
        this.krq = 1;
        this.krr = 1;
        this.krs = 1;
        this.isAd = false;
        this.jrn = false;
        this.dUI = false;
        this.krt = false;
        this.isFromMark = false;
        this.kru = false;
        this.krv = false;
        this.krw = 0L;
        this.krx = false;
        this.kry = null;
        this.klg = null;
        this.isLoading = false;
        this.krz = false;
        this.krA = false;
        this.krB = false;
        this.krC = false;
        this.mLocate = null;
        this.mContext = null;
        this.krD = null;
        this.opType = null;
        this.opUrl = null;
        this.krE = null;
        this.krF = null;
        this.krG = -1;
        this.krH = -1;
        this.hli = null;
        this.krJ = false;
        this.krK = false;
        this.postID = null;
        this.krN = null;
        this.krO = 0L;
        this.krP = false;
        this.krQ = -1;
        this.krS = false;
        this.ksc = false;
        this.ksd = 0;
        this.mTabIndex = 0;
        this.ksm = false;
        this.kst = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.ksu = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.hjZ.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.krJ || !PbModel.this.krK) {
                        if (!PbModel.this.krJ) {
                            PbModel.this.krJ = true;
                        } else {
                            PbModel.this.krK = true;
                        }
                        if (PbModel.this.krD != null) {
                            PbModel.this.krD.a(PbModel.this.cNG(), z, responsedMessage, PbModel.this.krL, System.currentTimeMillis() - PbModel.this.hZL);
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
                    if (PbModel.this.klg != null && PbModel.this.klg.cKw() != null && PbModel.this.klg.cKw().getForumId() != null && PbModel.this.klg.cKw().getForumId().equals(valueOf)) {
                        PbModel.this.klg.cKw().setIsLike(false);
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
                    if (PbModel.this.klg != null && PbModel.this.klg.cKw() != null && PbModel.this.klg.cKw().getForumId() != null && PbModel.this.klg.cKw().getForumId().equals(valueOf)) {
                        PbModel.this.klg.cKw().setIsLike(true);
                    }
                }
            }
        };
        this.ksv = null;
        registerListener(this.ksu);
        registerListener(this.kst);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.klg = new com.baidu.tieba.pb.data.f();
        this.klg.Bw(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.hjZ = baseFragmentActivity;
        this.krU = new ag(this, this.hjZ);
        this.krV = new q(this, this.hjZ);
        this.krW = new ai(this, this.hjZ);
        this.krY = new CheckRealNameModel(this.hjZ.getPageContext());
        this.ksa = new SuggestEmotionModel();
        this.krZ = new AddExperiencedModel(this.hjZ.getPageContext());
        this.kss = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void B(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dFY) instanceof String) {
                        PbModel.this.krd = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dFY);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dFZ) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dFZ);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dGa) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dGa);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dGb) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.dGb), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dGc) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dGc);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.krM = true;
        if (fVar != null && fVar.kho == null) {
            q(fVar);
            l(fVar);
            if (fVar.cKx() != null) {
                fVar.cKx().kY(0);
            }
            if (this.krD != null && fVar != null) {
                this.krD.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int cNG() {
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
            this.krd = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.ksr = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                com.baidu.tbadk.BdToken.f.aQv().c(uri, this.kss);
            } else if (StringUtils.isNull(this.krd)) {
                this.krU.a(intent, this.kss);
                if (uri != null) {
                    if (StringUtils.isNull(this.krd)) {
                        this.krd = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.as.isEmpty(this.krd)) {
                this.krd = "0";
            }
            this.ksd = intent.getIntExtra("key_start_from", 0);
            if (this.ksd == 0) {
                this.ksd = this.krU.azq;
            }
            this.krf = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.kre = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.krh = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.kri = intent.getBooleanExtra("host_only", false);
            this.krk = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, 2);
            if (this.mSortType == 2) {
                this.krf = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.krn = intent.getIntExtra("is_top", 0);
            this.kro = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.kru = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.krv = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.jrn = intent.getBooleanExtra("is_sub_pb", false);
            this.krx = intent.getBooleanExtra("is_pv", false);
            this.krw = intent.getLongExtra("msg_id", 0L);
            this.kry = intent.getStringExtra("from_forum_name");
            this.krF = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.krE = intent.getStringExtra("op_stat");
            this.krz = intent.getBooleanExtra("is_from_thread_config", false);
            this.krA = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.krB = intent.getBooleanExtra("is_from_my_god_config", false);
            this.krH = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.krG = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.dUI = intent.getBooleanExtra("from_frs", false);
            this.krt = intent.getBooleanExtra("from_maintab", false);
            this.krS = intent.getBooleanExtra("from_smart_frs", false);
            this.krC = intent.getBooleanExtra("from_hottopic", false);
            this.krX = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.krg = intent.getStringExtra("high_light_post_id");
            this.ksm = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.krI = intent.getIntExtra("request_code", -1) == 18003;
            this.ksn = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.kso = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.ksp = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.ksq = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean cNH() {
        return this.ksm && com.baidu.tieba.frs.k.cbl() != null && com.baidu.tieba.frs.k.cbl().equals(this.krd) && com.baidu.tieba.frs.k.cbk() != null;
    }

    public com.baidu.tieba.pb.data.f aG(bv bvVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.Bw(3);
        if (bvVar == null) {
            return null;
        }
        fVar.aD(bvVar);
        if (bvVar.aXZ() != null) {
            fVar.d(bvVar.aXZ());
            ForumData forum = fVar.getForum();
            forum.setId(bvVar.aXZ().getForumId());
            forum.setName(bvVar.aXZ().getForumName());
            forum.setUser_level(bvVar.aXZ().aVB());
            forum.setImage_url(bvVar.aXZ().getAvatar());
            forum.setPost_num(bvVar.aXZ().postNum);
            forum.setMember_num(bvVar.aXZ().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(bvVar.getFid()));
            forum2.setName(bvVar.aWp());
        }
        PostData postData = new PostData();
        postData.Fs(1);
        postData.setTime(bvVar.getCreateTime());
        postData.a(bvVar.aWl());
        MetaData aWl = bvVar.aWl();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(aWl.getUserId(), aWl);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bvVar.aWb(), false));
        fVar.d(postData);
        fVar.cKz().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.o(bvVar, null));
        fVar.kht = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.ksd = bundle.getInt("key_start_from", 0);
        this.krd = bundle.getString("thread_id");
        this.krf = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.kre = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.krh = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.kri = bundle.getBoolean("host_only", false);
        this.krk = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.krn = bundle.getInt("is_top", 0);
        this.kro = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.krv = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.jrn = bundle.getBoolean("is_sub_pb", false);
        this.krx = bundle.getBoolean("is_pv", false);
        this.krw = bundle.getLong("msg_id", 0L);
        this.kry = bundle.getString("from_forum_name");
        this.krF = bundle.getString("extra_pb_cache_key");
        this.krz = bundle.getBoolean("is_from_thread_config", false);
        this.krA = bundle.getBoolean("is_from_interview_live_config", false);
        this.krB = bundle.getBoolean("is_from_my_god_config", false);
        this.krH = bundle.getInt("extra_pb_is_attention_key", -1);
        this.krG = bundle.getInt("extra_pb_funs_count_key", -1);
        this.dUI = bundle.getBoolean("from_frs", false);
        this.krt = bundle.getBoolean("from_maintab", false);
        this.krS = bundle.getBoolean("from_smart_frs", false);
        this.krC = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.krg = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.krI = bundle.getInt("request_code", -1) == 18003;
        this.ksn = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.kso = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.ksp = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.ksq = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aD(Bundle bundle) {
        bundle.putString("thread_id", this.krd);
        bundle.putString("post_id", this.krf);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.ksd);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.krh);
        bundle.putBoolean("host_only", this.kri);
        bundle.putBoolean("squence", this.krk);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.krn);
        bundle.putLong("thread_time", this.kro);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.krv);
        bundle.putBoolean("is_sub_pb", this.jrn);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.krx);
        bundle.putLong("msg_id", this.krw);
        bundle.putString("extra_pb_cache_key", this.krF);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.krz);
        bundle.putBoolean("is_from_interview_live_config", this.krA);
        bundle.putBoolean("is_from_my_god_config", this.krB);
        bundle.putInt("extra_pb_is_attention_key", this.krH);
        bundle.putInt("extra_pb_funs_count_key", this.krG);
        bundle.putBoolean("from_frs", this.dUI);
        bundle.putBoolean("from_maintab", this.krt);
        bundle.putBoolean("from_smart_frs", this.krS);
        bundle.putBoolean("from_hottopic", this.krC);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.krg);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.ksn);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.kso);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.ksp);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.ksq);
    }

    public String cNI() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.krd);
        if (!this.krv) {
            sb.append(this.krf);
        }
        sb.append(this.kri);
        sb.append(this.krk);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.krn);
        sb.append(this.kro);
        sb.append(this.dUI);
        sb.append(this.krt);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.jrn);
        sb.append(this.krx);
        sb.append(this.krw);
        sb.append(this.kry);
        sb.append(this.mThreadType);
        sb.append(this.krz);
        sb.append(this.krA);
        sb.append(this.krB);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.krF != null) {
            sb.append(this.krF);
        }
        return sb.toString();
    }

    public String cLG() {
        return this.kry;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cNJ() {
        return this.krf;
    }

    public String cNK() {
        return this.krg;
    }

    public String cNL() {
        return this.krd;
    }

    public String cNM() {
        return (StringUtils.isNull(this.krd) || "0".equals(this.krd)) ? this.oriUgcNid : this.krd;
    }

    public boolean getHostMode() {
        return this.kri;
    }

    public boolean cNN() {
        return cOC();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean cNO() {
        return this.dUI;
    }

    public boolean cNP() {
        return this.krm;
    }

    public boolean cNQ() {
        return this.krt;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean cNR() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bUx() {
        return this.krn;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void BN(int i) {
        this.krn = i;
    }

    public boolean cNS() {
        return this.jrn;
    }

    public boolean cNT() {
        if (this.klg == null) {
            return false;
        }
        return this.klg.isValid();
    }

    public String aWt() {
        if (this.klg == null || !this.klg.aSj()) {
            return null;
        }
        return this.klg.aSi();
    }

    public boolean BO(int i) {
        this.krp = i;
        if (this.krp > this.klg.getPage().aUW()) {
            this.krp = this.klg.getPage().aUW();
        }
        if (this.krp < 1) {
            this.krp = 1;
        }
        if (this.krd == null) {
            return false;
        }
        return BQ(5);
    }

    public void BP(int i) {
        this.krp = i;
        this.krq = i;
        this.krr = i;
    }

    public void b(com.baidu.tbadk.core.data.au auVar) {
        if (auVar == null) {
            BP(1);
            return;
        }
        if (this.krq < auVar.aUZ()) {
            this.krq = auVar.aUZ();
        }
        if (this.krr > auVar.aUZ()) {
            this.krr = auVar.aUZ();
        }
        this.krs = auVar.aUW();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.klg;
    }

    public BaijiahaoData cNU() {
        if (this.klg == null || this.klg.cKx() == null) {
            return null;
        }
        return this.klg.cKx().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f cNV() {
        if (this.klg == null) {
            return this.klg;
        }
        if (!cNW() && this.ksl != null) {
            this.klg.b(this.ksl);
        }
        return this.klg;
    }

    private boolean cNW() {
        return (this.klg.cKP() == null || this.klg.cKP().dkV() == null || this.klg.cKP().dkV().goods != null || this.klg.cKP().dkV().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.au getPageData() {
        if (this.klg == null) {
            return null;
        }
        return this.klg.getPage();
    }

    public boolean cNX() {
        if (cOC() && this.klg.getPage().aVb() == 0) {
            sw(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.krd = fVar.getThreadId();
            if (fVar.cKx() != null && fVar.cKx().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.cKx().getBaijiahaoData();
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
            this.krf = null;
            this.kri = false;
            this.krk = true;
            LoadData();
        }
    }

    public void KA(String str) {
        if (!StringUtils.isNull(str)) {
            this.krd = str;
            this.krf = null;
            this.kri = false;
            this.krk = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.krd == null) {
            return false;
        }
        cancelLoadData();
        if (this.hli == null) {
            this.hli = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.hli.start();
        }
        boolean BQ = BQ(3);
        if (this.opType != null) {
            this.opType = null;
            this.krE = null;
            this.opUrl = null;
            return BQ;
        }
        return BQ;
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
        if (this.ksa != null) {
            this.ksa.cancelLoadData();
        }
        if (this.ksb != null) {
            this.ksb.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dcS().dcW();
        bVR();
    }

    private void bVR() {
        if (this.hli != null) {
            this.hli.destory();
            this.hli = null;
        }
    }

    public boolean cNY() {
        return (this.krf == null || this.krf.equals("0") || this.krf.length() == 0) ? LoadData() : cOc();
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
                this.ksa.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.ksa.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.ksb == null) {
                this.ksb = new GetSugMatchWordsModel(this.hjZ.getPageContext());
            }
            this.ksb.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0388 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0390 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0227, B:77:0x022f, B:79:0x0239, B:80:0x023d, B:82:0x0259, B:83:0x0262, B:85:0x0268, B:87:0x0272, B:198:0x0525, B:199:0x052b, B:202:0x0538, B:90:0x027f, B:197:0x051f, B:196:0x0518, B:92:0x02a8, B:93:0x02c6, B:95:0x02de, B:97:0x02e4, B:99:0x02eb, B:100:0x02f8, B:102:0x030c, B:104:0x0312, B:106:0x0318, B:115:0x0348, B:117:0x034e, B:107:0x0323, B:109:0x0327, B:111:0x032f, B:113:0x033e, B:114:0x0343, B:118:0x035a, B:120:0x036e, B:122:0x0372, B:125:0x0384, B:128:0x038a, B:156:0x0400, B:131:0x0390, B:133:0x0396, B:134:0x039b, B:136:0x039f, B:138:0x03a9, B:143:0x03c0, B:145:0x03ce, B:146:0x03d1, B:148:0x03d5, B:149:0x03e0, B:151:0x03e4, B:153:0x03ec, B:155:0x03fb, B:157:0x0405, B:159:0x0409, B:140:0x03ad, B:160:0x0412, B:161:0x0440, B:163:0x0444, B:173:0x0475, B:166:0x0450, B:168:0x045e, B:169:0x0466, B:171:0x046a, B:172:0x0470, B:174:0x047e, B:176:0x048a, B:165:0x0448, B:177:0x0494, B:179:0x04a0, B:181:0x04a4, B:183:0x04a8, B:184:0x04ad, B:186:0x04b9, B:187:0x04c1, B:191:0x04db, B:188:0x04c6, B:190:0x04d5, B:192:0x04e4, B:194:0x04f3, B:38:0x00e3), top: B:205:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x039f A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0227, B:77:0x022f, B:79:0x0239, B:80:0x023d, B:82:0x0259, B:83:0x0262, B:85:0x0268, B:87:0x0272, B:198:0x0525, B:199:0x052b, B:202:0x0538, B:90:0x027f, B:197:0x051f, B:196:0x0518, B:92:0x02a8, B:93:0x02c6, B:95:0x02de, B:97:0x02e4, B:99:0x02eb, B:100:0x02f8, B:102:0x030c, B:104:0x0312, B:106:0x0318, B:115:0x0348, B:117:0x034e, B:107:0x0323, B:109:0x0327, B:111:0x032f, B:113:0x033e, B:114:0x0343, B:118:0x035a, B:120:0x036e, B:122:0x0372, B:125:0x0384, B:128:0x038a, B:156:0x0400, B:131:0x0390, B:133:0x0396, B:134:0x039b, B:136:0x039f, B:138:0x03a9, B:143:0x03c0, B:145:0x03ce, B:146:0x03d1, B:148:0x03d5, B:149:0x03e0, B:151:0x03e4, B:153:0x03ec, B:155:0x03fb, B:157:0x0405, B:159:0x0409, B:140:0x03ad, B:160:0x0412, B:161:0x0440, B:163:0x0444, B:173:0x0475, B:166:0x0450, B:168:0x045e, B:169:0x0466, B:171:0x046a, B:172:0x0470, B:174:0x047e, B:176:0x048a, B:165:0x0448, B:177:0x0494, B:179:0x04a0, B:181:0x04a4, B:183:0x04a8, B:184:0x04ad, B:186:0x04b9, B:187:0x04c1, B:191:0x04db, B:188:0x04c6, B:190:0x04d5, B:192:0x04e4, B:194:0x04f3, B:38:0x00e3), top: B:205:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03d5 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0227, B:77:0x022f, B:79:0x0239, B:80:0x023d, B:82:0x0259, B:83:0x0262, B:85:0x0268, B:87:0x0272, B:198:0x0525, B:199:0x052b, B:202:0x0538, B:90:0x027f, B:197:0x051f, B:196:0x0518, B:92:0x02a8, B:93:0x02c6, B:95:0x02de, B:97:0x02e4, B:99:0x02eb, B:100:0x02f8, B:102:0x030c, B:104:0x0312, B:106:0x0318, B:115:0x0348, B:117:0x034e, B:107:0x0323, B:109:0x0327, B:111:0x032f, B:113:0x033e, B:114:0x0343, B:118:0x035a, B:120:0x036e, B:122:0x0372, B:125:0x0384, B:128:0x038a, B:156:0x0400, B:131:0x0390, B:133:0x0396, B:134:0x039b, B:136:0x039f, B:138:0x03a9, B:143:0x03c0, B:145:0x03ce, B:146:0x03d1, B:148:0x03d5, B:149:0x03e0, B:151:0x03e4, B:153:0x03ec, B:155:0x03fb, B:157:0x0405, B:159:0x0409, B:140:0x03ad, B:160:0x0412, B:161:0x0440, B:163:0x0444, B:173:0x0475, B:166:0x0450, B:168:0x045e, B:169:0x0466, B:171:0x046a, B:172:0x0470, B:174:0x047e, B:176:0x048a, B:165:0x0448, B:177:0x0494, B:179:0x04a0, B:181:0x04a4, B:183:0x04a8, B:184:0x04ad, B:186:0x04b9, B:187:0x04c1, B:191:0x04db, B:188:0x04c6, B:190:0x04d5, B:192:0x04e4, B:194:0x04f3, B:38:0x00e3), top: B:205:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03e4 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0227, B:77:0x022f, B:79:0x0239, B:80:0x023d, B:82:0x0259, B:83:0x0262, B:85:0x0268, B:87:0x0272, B:198:0x0525, B:199:0x052b, B:202:0x0538, B:90:0x027f, B:197:0x051f, B:196:0x0518, B:92:0x02a8, B:93:0x02c6, B:95:0x02de, B:97:0x02e4, B:99:0x02eb, B:100:0x02f8, B:102:0x030c, B:104:0x0312, B:106:0x0318, B:115:0x0348, B:117:0x034e, B:107:0x0323, B:109:0x0327, B:111:0x032f, B:113:0x033e, B:114:0x0343, B:118:0x035a, B:120:0x036e, B:122:0x0372, B:125:0x0384, B:128:0x038a, B:156:0x0400, B:131:0x0390, B:133:0x0396, B:134:0x039b, B:136:0x039f, B:138:0x03a9, B:143:0x03c0, B:145:0x03ce, B:146:0x03d1, B:148:0x03d5, B:149:0x03e0, B:151:0x03e4, B:153:0x03ec, B:155:0x03fb, B:157:0x0405, B:159:0x0409, B:140:0x03ad, B:160:0x0412, B:161:0x0440, B:163:0x0444, B:173:0x0475, B:166:0x0450, B:168:0x045e, B:169:0x0466, B:171:0x046a, B:172:0x0470, B:174:0x047e, B:176:0x048a, B:165:0x0448, B:177:0x0494, B:179:0x04a0, B:181:0x04a4, B:183:0x04a8, B:184:0x04ad, B:186:0x04b9, B:187:0x04c1, B:191:0x04db, B:188:0x04c6, B:190:0x04d5, B:192:0x04e4, B:194:0x04f3, B:38:0x00e3), top: B:205:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0409 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0227, B:77:0x022f, B:79:0x0239, B:80:0x023d, B:82:0x0259, B:83:0x0262, B:85:0x0268, B:87:0x0272, B:198:0x0525, B:199:0x052b, B:202:0x0538, B:90:0x027f, B:197:0x051f, B:196:0x0518, B:92:0x02a8, B:93:0x02c6, B:95:0x02de, B:97:0x02e4, B:99:0x02eb, B:100:0x02f8, B:102:0x030c, B:104:0x0312, B:106:0x0318, B:115:0x0348, B:117:0x034e, B:107:0x0323, B:109:0x0327, B:111:0x032f, B:113:0x033e, B:114:0x0343, B:118:0x035a, B:120:0x036e, B:122:0x0372, B:125:0x0384, B:128:0x038a, B:156:0x0400, B:131:0x0390, B:133:0x0396, B:134:0x039b, B:136:0x039f, B:138:0x03a9, B:143:0x03c0, B:145:0x03ce, B:146:0x03d1, B:148:0x03d5, B:149:0x03e0, B:151:0x03e4, B:153:0x03ec, B:155:0x03fb, B:157:0x0405, B:159:0x0409, B:140:0x03ad, B:160:0x0412, B:161:0x0440, B:163:0x0444, B:173:0x0475, B:166:0x0450, B:168:0x045e, B:169:0x0466, B:171:0x046a, B:172:0x0470, B:174:0x047e, B:176:0x048a, B:165:0x0448, B:177:0x0494, B:179:0x04a0, B:181:0x04a4, B:183:0x04a8, B:184:0x04ad, B:186:0x04b9, B:187:0x04c1, B:191:0x04db, B:188:0x04c6, B:190:0x04d5, B:192:0x04e4, B:194:0x04f3, B:38:0x00e3), top: B:205:0x00d7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean BQ(int i) {
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
        BR(i);
        final com.baidu.tieba.pb.data.f pbData = as.cPg().getPbData();
        if (pbData != null && pbData.cKx() != null) {
            pbData.cKx().kY(0);
            this.krk = as.cPg().cNN();
            this.kri = as.cPg().cPl();
            this.krm = as.cPg().cPm();
            this.ksf = as.cPg().cPk();
            this.ksg = as.cPg().cPj();
            this.ksh = as.cPg().cPi();
            this.ksj = as.cPg().cPn();
            this.mTabIndex = as.cPg().getTabIndex();
            this.ksc = this.kri;
            if (this.kri || this.isFromMark) {
                this.krI = false;
            }
            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.krM) {
            a(cOh(), true, this.krf, 3);
        }
        if (i == 3 && !this.krM) {
            if (this.isFromMark) {
                a(cOh(), true, this.krf, 3);
            } else {
                a(cOh(), false, this.krf, 3);
            }
        }
        this.krM = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.ksl == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.ezm);
        if (this.kri || this.isFromMark) {
            this.krI = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.krd == null || this.krd.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.krd, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.at.baS().baT() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.krk) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.kri) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.krx) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.krw));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.krI) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.krE, 0));
            pbPageRequestMessage.setOpMessageID(this.krw);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> cKz = this.klg.cKz();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.krr - 1));
                        if (this.krr - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.kru) {
                                if (cKz != null && cKz.size() > 0) {
                                    size = cKz.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = cKz.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.krf = postData.getId();
                                            if (StringUtils.isNull(this.krf)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.krq + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.krf == null && this.krf.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.krf, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.krq + 1));
                        if (this.krq >= this.krs) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (cKz != null) {
                                size = cKz.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.krf == null) {
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
                if (cKz != null) {
                }
                if (this.krf == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (cKz != null && cKz.size() > 0 && cKz.get(0) != null) {
                    this.krf = cKz.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (cOC()) {
                        if (this.krr - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.krr - 1));
                        }
                    } else if (this.krq < this.krs) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.krq + 1));
                    }
                }
                if (this.krf != null && this.krf.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.krf, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.kri) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (cOC()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.krs > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.krs));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.krf, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.krp));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.ksc && !this.kri) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.krf, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.kri) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.krQ);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kse, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.ksc = this.kri;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cOh());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.ksd));
        pbPageRequestMessage.setIsSubPostDataReverse(this.krP);
        pbPageRequestMessage.setFromSmartFrs(this.krS ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.krh);
        if (this.ksd == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.ksr)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.ksr));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.krs) {
                    i4 = -1;
                } else {
                    i4 = cOJ();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = cOJ();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.krd);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean cLF() {
        switch (cOv()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().cKx() == null || !getPbData().cKx().aXI();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cLG()) && com.baidu.tieba.recapp.r.dca().dbU() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dca().dbU().aP(cLG(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dca().dbU().aQ(cLG(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cLG()) && com.baidu.tieba.recapp.r.dca().dbU() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dca().dbU().aQ(cLG(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dca().dbU().aP(cLG(), true));
        }
    }

    protected void BR(int i) {
        boolean z = false;
        BW(i);
        ArrayList<PostData> cKz = this.klg.cKz();
        this.krL = false;
        if (i == 1) {
            boolean z2 = false;
            while (cKz.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cKz.remove(0);
                z2 = true;
            }
            if (z2) {
                this.klg.getPage().kU(1);
                if (this.krD != null) {
                    this.krD.e(this.klg);
                }
            }
            this.hZL = System.currentTimeMillis();
            this.krL = true;
        } else if (i == 2) {
            while (cKz.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cKz.remove(cKz.size() - 1);
                z = true;
            }
            if (z) {
                this.klg.getPage().kT(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.krT = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.ksl != null && this.ksl.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cKP() != null && fVar.cKP().dkV() != null && fVar.cKP().dkV().goods != null && fVar.cKP().isValidate() && fVar.cKP().dkV().goods.goods_style != 1001) {
            this.ksl = fVar.cKP();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n cNZ() {
        return this.ksl;
    }

    public void cOa() {
        this.ksl = null;
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
            if (this.krB || this.krz || this.krA) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.cKz().size(); i++) {
                PostData postData = fVar.cKz().get(i);
                for (int i2 = 0; i2 < postData.dle().size(); i2++) {
                    postData.dle().get(i2).a(this.hjZ.getPageContext(), o.equals(postData.dle().get(i2).aWl().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r cKL = fVar.cKL();
            if (cKL != null && !com.baidu.tbadk.core.util.x.isEmpty(cKL.kiU)) {
                for (PostData postData2 : cKL.kiU) {
                    for (int i3 = 0; i3 < postData2.dle().size(); i3++) {
                        postData2.dle().get(i3).a(this.hjZ.getPageContext(), o.equals(postData2.dle().get(i3).aWl().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r cKL = fVar.cKL();
            if (cKL != null && !com.baidu.tbadk.core.util.x.isEmpty(cKL.kiU)) {
                for (PostData postData : cKL.kiU.subList(i, cKL.kiU.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dle().size()) {
                            postData.dle().get(i3).a(this.hjZ.getPageContext(), o.equals(postData.dle().get(i3).aWl().getUserId()));
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
        bv cKx = fVar.cKx();
        cKx.ld(this.mIsGood);
        cKx.lc(this.krn);
        if (this.kro > 0) {
            cKx.cq(this.kro);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.cKx() != null && fVar.cKx().aWl() != null) {
            str = fVar.cKx().aWl().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData cOb() {
        if (this.klg == null || this.klg.cKx() == null || this.klg.cKx().aWl() == null) {
            return null;
        }
        return this.klg.cKx().aWl();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.krR = z3;
        if (this.hli != null && !z3) {
            this.hli.a(z2, z4, i2, str, i3, j, j2);
            this.hli = null;
        }
        if (this.klg != null) {
            this.klg.kic = z3;
            this.klg.Xq = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(cLG()) && com.baidu.tieba.recapp.r.dca().dbU() != null) {
            com.baidu.tieba.recapp.r.dca().dbU().f(cLG(), BS(cOk()), true);
        }
        if (fVar == null || (this.krp == 1 && i == 5 && fVar.cKz() != null && fVar.cKz().size() < 1)) {
            if (this.krD != null) {
                this.krk = this.krj;
                if (i2 != 350006) {
                    this.mSortType = this.krl;
                }
                this.krD.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.krj = this.krk;
            if (i != 8) {
                this.krl = this.mSortType;
                this.mSortType = fVar.khn;
            }
            if (fVar.khm != null && fVar.khm.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.hjZ.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.khm = new ArrayList();
                fVar.khm.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.hjZ.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.khm.add(builder2.build(false));
                this.mSortType = this.krl;
                fVar.khn = this.mSortType;
            }
            this.krx = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.krs = this.krs < 1 ? 1 : this.krs;
            int i6 = 0;
            ArrayList<PostData> cKz = this.klg.cKz();
            switch (i) {
                case 1:
                    this.klg.a(fVar.getPage(), 1);
                    d(fVar, cKz);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.cKz() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.cKz().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(cKz, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.getItem(fVar.cKz(), com.baidu.tbadk.core.util.x.getCount(fVar.cKz()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.cKz().remove(postData2);
                            i5 = size2 - 1;
                        }
                        cKz.addAll(0, fVar.cKz());
                    }
                    p(fVar);
                    this.klg.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().kR(fVar.getPage().aUW());
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
                    if (fVar != null && !com.baidu.tbadk.core.util.x.isEmpty(fVar.cKz()) && this.klg != null && (!this.kri || o(fVar).equals(fVar.cKz().get(0).aWl().getUserId()))) {
                        if (this.klg.getPage().aVb() == 0) {
                            this.klg.getPage().kT(1);
                        }
                        cOw();
                        this.ksf = fVar.cKz().get(0);
                        if (cOC() || this.klg.cLa()) {
                            if (this.klg.cKz().size() - this.ksh >= 3) {
                                this.ksg = new PostData();
                                this.ksg.lNB = true;
                                this.ksg.setPostType(53);
                                this.klg.cKz().add(this.ksg);
                            }
                            this.klg.cKz().add(this.ksf);
                            size = this.klg.cKz().size() - 1;
                        } else {
                            if (this.ksh - this.ksi >= 3) {
                                this.ksg = new PostData();
                                this.ksg.lNB = false;
                                this.ksg.setPostType(53);
                                this.klg.cKz().add(0, this.ksg);
                            }
                            this.klg.cKz().add(0, this.ksf);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.as.isTaday(com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.ksf.lNO = this.klg.cKY();
                            com.baidu.tbadk.core.sharedPref.b.aZP().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.klg != null && this.klg.cKx() != null) {
                PraiseData aVW = this.klg.cKx().aVW();
                if (this.ksv != null && !aVW.isPriaseDataValid()) {
                    this.klg.cKx().a(this.ksv);
                } else {
                    this.ksv = this.klg.cKx().aVW();
                    this.ksv.setPostId(this.klg.cKx().aWC());
                }
                if (fVar.getPage() != null && fVar.getPage().aUZ() == 1 && fVar.cKx() != null && fVar.cKx().aWv() != null && fVar.cKx().aWv().size() > 0) {
                    this.klg.cKx().y(fVar.cKx().aWv());
                }
                this.klg.cKx().la(fVar.cKx().aWc());
                this.klg.cKx().kX(fVar.cKx().getAnchorLevel());
                this.klg.cKx().kY(fVar.cKx().aVS());
                if (this.mThreadType == 33) {
                    this.klg.cKx().aWl().setHadConcerned(fVar.cKx().aWl().hadConcerned());
                }
                if (fVar != null && fVar.cKx() != null) {
                    this.klg.cKx().lf(fVar.cKx().aWz());
                }
            }
            if (this.klg != null && this.klg.getUserData() != null && fVar.getUserData() != null) {
                this.klg.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.klg.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().aUZ() == 1 && fVar.cKK() != null) {
                this.klg.f(fVar.cKK());
            }
            if (this.krR) {
                if (this.klg.cKx() != null && this.klg.cKx().aWl() != null && this.klg.cKz() != null && com.baidu.tbadk.core.util.x.getItem(this.klg.cKz(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.getItem(this.klg.cKz(), 0);
                    MetaData aWl = this.klg.cKx().aWl();
                    if (postData3.aWl() != null && postData3.aWl().getGodUserData() != null) {
                        if (this.krG != -1) {
                            aWl.setFansNum(this.krG);
                            postData3.aWl().setFansNum(this.krG);
                        }
                        if (this.krH != -1) {
                            aWl.getGodUserData().setIsLike(this.krH == 1);
                            postData3.aWl().getGodUserData().setIsLike(this.krH == 1);
                            aWl.getGodUserData().setIsFromNetWork(false);
                            postData3.aWl().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.klg.khl = -1;
                this.klg.khk = -1;
            }
            if (this.krD != null) {
                this.krD.a(true, getErrorCode(), i, i4, this.klg, this.mErrorString, 1);
            }
        }
        if (this.klg != null && this.klg.cKx() != null && this.klg.getForum() != null && !this.klg.cLa()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.hjZ.getPageContext();
            historyMessage.threadId = getPbData().cKx().getId();
            if (this.mIsShareThread && getPbData().cKx().dUi != null) {
                historyMessage.threadName = getPbData().cKx().dUi.showText;
            } else {
                historyMessage.threadName = getPbData().cKx().getTitle();
            }
            if (this.mIsShareThread && !cLF()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = cNN();
            historyMessage.threadType = getPbData().cKx().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.klg != null) {
            this.klg.cKO().clear();
            this.klg.cKO().addAll(fVar.cKO());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aQ;
        if (arrayList != null && fVar.cKz() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(fVar.cKz(), 0);
            if (postData != null && (aQ = aQ(arrayList)) != null && aQ.equals(postData.getId())) {
                fVar.cKz().remove(postData);
            }
            this.klg.kib = arrayList.size();
            arrayList.addAll(fVar.cKz());
        }
    }

    private int BS(int i) {
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

    private String aQ(ArrayList<PostData> arrayList) {
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
            fVar.Ks(this.klg.cKS());
            if (!this.klg.khZ && fVar.khZ && this.klg.cKH() != null) {
                fVar.e(this.klg.cKH());
            }
            this.klg = fVar;
            BP(fVar.getPage().aUZ());
        }
    }

    public boolean cOc() {
        if (this.krd == null || this.krf == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return BQ(4);
        }
        return BQ(6);
    }

    public boolean sw(boolean z) {
        if (this.krd == null || this.klg == null) {
            return false;
        }
        if (z || this.klg.getPage().aVb() != 0) {
            return BQ(1);
        }
        return false;
    }

    public boolean sx(boolean z) {
        if (this.krd == null || this.klg == null) {
            return false;
        }
        if ((z || this.klg.getPage().aVc() != 0) && this.klg.cKz() != null && this.klg.cKz().size() >= 1) {
            return BQ(2);
        }
        return false;
    }

    public boolean KG(String str) {
        this.kri = !this.kri;
        this.krf = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("pb_onlyowner_click").ah("obj_source", 0));
        if (BQ(6)) {
            return true;
        }
        this.kri = this.kri ? false : true;
        return false;
    }

    public boolean y(boolean z, String str) {
        if (this.kri == z) {
            return false;
        }
        this.kri = z;
        this.krf = str;
        if (this.mSortType == 2) {
            this.krf = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("pb_onlyowner_click").ah("obj_source", 1));
        }
        if (BQ(6)) {
            return true;
        }
        this.kri = z ? false : true;
        return false;
    }

    public boolean BT(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.krj = this.krk;
        this.krl = this.mSortType;
        this.mSortType = i;
        this.krk = !this.krk;
        if (i == 2 && this.isFromMark) {
            this.krf = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.krk = this.krk ? false : true;
            this.mSortType = this.krl;
            return false;
        }
        return true;
    }

    public boolean cOd() {
        return cOC();
    }

    public int cOe() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.klg == null || this.klg.getForum() == null || this.klg.cKx() == null) ? false : true;
    }

    public boolean aSj() {
        if (this.klg == null) {
            return false;
        }
        return this.klg.aSj();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData zE(String str) {
        if (this.klg == null || this.klg.cKx() == null || this.klg.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.klg.cKx().aXI()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.klg.getForum().getId());
            writeData.setForumName(this.klg.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.ksd);
        writeData.setThreadId(this.krd);
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

    public MarkData BU(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.klg == null) {
            return null;
        }
        ArrayList<PostData> cKz = this.klg.cKz();
        if (com.baidu.tbadk.core.util.x.isEmpty(cKz)) {
            return null;
        }
        if (cKz.size() > 0 && i >= cKz.size()) {
            i = cKz.size() - 1;
        }
        return o(cKz.get(i));
    }

    public MarkData cOf() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.krd);
        markData.setPostId(this.klg.aSi());
        markData.setTime(date.getTime());
        markData.setHostMode(this.kri);
        markData.setSequence(Boolean.valueOf(cOC()));
        markData.setId(this.krd);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.krd);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.kri);
        markData.setSequence(Boolean.valueOf(cOC()));
        markData.setId(this.krd);
        markData.setFloor(postData.dlh());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) postData).isApp());
        }
        return markData;
    }

    public void cOg() {
        j.cMt().aK(cOh(), this.isFromMark);
    }

    private String cOh() {
        String cOi = (this.krd == null || this.krd.equals("0")) ? cOi() : this.krd;
        if (this.kri) {
            cOi = cOi + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            cOi = cOi + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return cOi + TbadkCoreApplication.getCurrentAccount();
        }
        return cOi;
    }

    private String cOi() {
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

    public void sy(boolean z) {
        if (this.klg != null) {
            this.klg.he(z);
        }
    }

    public boolean cOj() {
        return this.krI;
    }

    public void a(a aVar) {
        this.krD = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bjg() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bjf() {
        return cNY();
    }

    public boolean KH(String str) {
        if (getPbData() == null || getPbData().cKx() == null || getPbData().cKx().aWl() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().cKx().aWl().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int cOk() {
        return this.mRequestType;
    }

    public void cOl() {
        if ("personalize_page".equals(this.mStType)) {
            this.krO = System.currentTimeMillis() / 1000;
        }
    }

    public void cOm() {
        if ("personalize_page".equals(this.mStType) && this.klg != null && this.krO != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10754").dn("fid", this.klg.getForumId()).dn("tid", this.krd).dn("obj_duration", String.valueOf(currentTimeMillis - this.krO)).dn(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.krO = 0L;
        }
    }

    public boolean cOn() {
        return this.krR;
    }

    public int getErrorNo() {
        return this.krT;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public q cOo() {
        return this.krV;
    }

    public ai cOp() {
        return this.krW;
    }

    public CheckRealNameModel cOq() {
        return this.krY;
    }

    public AddExperiencedModel cOr() {
        return this.krZ;
    }

    public String cOs() {
        return this.krN;
    }

    public void KI(String str) {
        this.krN = str;
    }

    public boolean cOt() {
        return this.krS;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.klg != null && this.klg.cKz() != null && this.klg.cKz().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.klg.cKz().size();
                for (int i = 0; i < size; i++) {
                    if (this.klg.cKz().get(i) != null && this.klg.cKz().get(i).aWl() != null && currentAccount.equals(this.klg.cKz().get(i).aWl().getUserId()) && this.klg.cKz().get(i).aWl().getPendantData() != null) {
                        this.klg.cKz().get(i).aWl().getPendantData().wU(lVar.aUh());
                        this.klg.cKz().get(i).aWl().getPendantData().cN(lVar.bin());
                    }
                }
            }
        }
    }

    public String cOu() {
        return this.krX;
    }

    public int cOv() {
        return this.ksd;
    }

    public void BV(int i) {
        this.ksd = i;
    }

    public void KJ(String str) {
        if ((!this.kri || KH(TbadkCoreApplication.getCurrentAccount())) && this.klg.cKz() != null) {
            this.klg.getPage().kT(1);
            if (this.klg.getPage().aVb() == 0) {
                this.klg.getPage().kT(1);
            }
            this.kse = str;
            BQ(8);
        }
    }

    private void BW(int i) {
        if (i != 8) {
            this.kse = "";
            if (this.ksf != null) {
                if (i == 1 && this.klg != null && this.klg.cLa()) {
                    if (this.ksg != null) {
                        getPbData().cKz().remove(this.ksg);
                    }
                } else if (i == 1 && !this.krk && !com.baidu.tbadk.core.util.x.isEmpty(getPbData().cKz())) {
                    getPbData().cKz().remove(this.ksf);
                    if (this.ksg != null) {
                        getPbData().cKz().remove(this.ksg);
                    }
                    getPbData().cKz().add(0, this.ksf);
                } else {
                    getPbData().cKz().remove(this.ksf);
                    if (this.ksg != null) {
                        getPbData().cKz().remove(this.ksg);
                    }
                }
            }
            this.ksg = null;
        }
    }

    public void cOw() {
        if (this.klg != null && !com.baidu.tbadk.core.util.x.isEmpty(this.klg.cKz())) {
            if (this.ksg != null) {
                this.klg.cKz().remove(this.ksg);
                this.ksg = null;
            }
            if (this.ksf != null) {
                this.klg.cKz().remove(this.ksf);
                this.ksf = null;
            }
        }
    }

    public void cM(int i, int i2) {
        this.ksh = i;
        this.ksi = i2;
    }

    public PostData cOx() {
        return this.ksf;
    }

    public PostData cOy() {
        return this.ksg;
    }

    public int cOz() {
        return this.ksh;
    }

    public int cOA() {
        return this.ksi;
    }

    public String cOB() {
        return this.ksk;
    }

    public void KK(String str) {
        this.ksk = str;
    }

    private boolean cOC() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean cOD() {
        return this.ksd == 13 || this.ksd == 12;
    }

    public String cOE() {
        return this.ksn;
    }

    public String cOF() {
        return this.kso;
    }

    public String cOG() {
        return this.ksp;
    }

    public String cOH() {
        return this.ksq;
    }

    public Rect cOI() {
        Rect rect = this.ksj;
        this.ksj = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int cOJ() {
        int i;
        int i2 = 0;
        if (getPbData().cKz() == null) {
            return 0;
        }
        ArrayList<PostData> cKz = getPbData().cKz();
        int size = cKz.size() - 1;
        while (size >= 0) {
            PostData postData = cKz.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
                if (postData.getType() != AdvertAppInfo.dMK) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return cKz.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
