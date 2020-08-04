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
    private long hZN;
    private BaseFragmentActivity hjZ;
    private com.baidu.tieba.tbadkCore.d.b hli;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private boolean jrp;
    protected com.baidu.tieba.pb.data.f kli;
    private String krA;
    private boolean krB;
    private boolean krC;
    private boolean krD;
    private boolean krE;
    private a krF;
    private String krG;
    private String krH;
    private int krI;
    private int krJ;
    private boolean krK;
    private boolean krL;
    private boolean krM;
    private boolean krN;
    private boolean krO;
    private String krP;
    private long krQ;
    private boolean krR;
    private int krS;
    private boolean krT;
    private boolean krU;
    private int krV;
    private final ag krW;
    private final q krX;
    private final ai krY;
    private String krZ;
    protected String krf;
    private String krg;
    private String krh;
    private String kri;
    private boolean krj;
    private boolean krk;
    private boolean krl;
    private boolean krm;
    private int krn;
    private boolean kro;
    private int krp;
    private long krq;
    private int krr;
    private int krs;
    private int krt;
    private int kru;
    private boolean krv;
    private boolean krw;
    private boolean krx;
    private long kry;
    private boolean krz;
    private final CheckRealNameModel ksa;
    private final AddExperiencedModel ksb;
    private SuggestEmotionModel ksc;
    private GetSugMatchWordsModel ksd;
    private boolean kse;
    private int ksf;
    private String ksg;
    private PostData ksh;
    private PostData ksi;
    private int ksj;
    private int ksk;
    private Rect ksl;
    private String ksm;
    private com.baidu.tieba.tbadkCore.data.n ksn;
    private boolean kso;
    private String ksp;
    private String ksq;
    private String ksr;
    private String kss;
    private String kst;
    private f.a ksu;
    private CustomMessageListener ksv;
    private com.baidu.adp.framework.listener.a ksw;
    private PraiseData ksx;
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
    private static final int kre = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.krf = null;
        this.isPrivacy = false;
        this.krg = null;
        this.krh = null;
        this.mForumId = null;
        this.kri = null;
        this.krj = false;
        this.krk = false;
        this.krl = true;
        this.krm = true;
        this.mSortType = 0;
        this.krn = 0;
        this.kro = false;
        this.mIsGood = 0;
        this.krp = 0;
        this.krq = 0L;
        this.krr = 1;
        this.krs = 1;
        this.krt = 1;
        this.kru = 1;
        this.isAd = false;
        this.jrp = false;
        this.dUI = false;
        this.krv = false;
        this.isFromMark = false;
        this.krw = false;
        this.krx = false;
        this.kry = 0L;
        this.krz = false;
        this.krA = null;
        this.kli = null;
        this.isLoading = false;
        this.krB = false;
        this.krC = false;
        this.krD = false;
        this.krE = false;
        this.mLocate = null;
        this.mContext = null;
        this.krF = null;
        this.opType = null;
        this.opUrl = null;
        this.krG = null;
        this.krH = null;
        this.krI = -1;
        this.krJ = -1;
        this.hli = null;
        this.krL = false;
        this.krM = false;
        this.postID = null;
        this.krP = null;
        this.krQ = 0L;
        this.krR = false;
        this.krS = -1;
        this.krU = false;
        this.kse = false;
        this.ksf = 0;
        this.mTabIndex = 0;
        this.kso = false;
        this.ksv = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.ksw = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
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
                    if (!PbModel.this.krL || !PbModel.this.krM) {
                        if (!PbModel.this.krL) {
                            PbModel.this.krL = true;
                        } else {
                            PbModel.this.krM = true;
                        }
                        if (PbModel.this.krF != null) {
                            PbModel.this.krF.a(PbModel.this.cNG(), z, responsedMessage, PbModel.this.krN, System.currentTimeMillis() - PbModel.this.hZN);
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
                    if (PbModel.this.kli != null && PbModel.this.kli.cKw() != null && PbModel.this.kli.cKw().getForumId() != null && PbModel.this.kli.cKw().getForumId().equals(valueOf)) {
                        PbModel.this.kli.cKw().setIsLike(false);
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
                    if (PbModel.this.kli != null && PbModel.this.kli.cKw() != null && PbModel.this.kli.cKw().getForumId() != null && PbModel.this.kli.cKw().getForumId().equals(valueOf)) {
                        PbModel.this.kli.cKw().setIsLike(true);
                    }
                }
            }
        };
        this.ksx = null;
        registerListener(this.ksw);
        registerListener(this.ksv);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.kli = new com.baidu.tieba.pb.data.f();
        this.kli.Bw(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.hjZ = baseFragmentActivity;
        this.krW = new ag(this, this.hjZ);
        this.krX = new q(this, this.hjZ);
        this.krY = new ai(this, this.hjZ);
        this.ksa = new CheckRealNameModel(this.hjZ.getPageContext());
        this.ksc = new SuggestEmotionModel();
        this.ksb = new AddExperiencedModel(this.hjZ.getPageContext());
        this.ksu = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void B(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dFY) instanceof String) {
                        PbModel.this.krf = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dFY);
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
        this.krO = true;
        if (fVar != null && fVar.khq == null) {
            q(fVar);
            l(fVar);
            if (fVar.cKx() != null) {
                fVar.cKx().kY(0);
            }
            if (this.krF != null && fVar != null) {
                this.krF.a(true, 0, i, 0, fVar, str, 0);
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
            this.krf = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.kst = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                com.baidu.tbadk.BdToken.f.aQv().c(uri, this.ksu);
            } else if (StringUtils.isNull(this.krf)) {
                this.krW.a(intent, this.ksu);
                if (uri != null) {
                    if (StringUtils.isNull(this.krf)) {
                        this.krf = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.as.isEmpty(this.krf)) {
                this.krf = "0";
            }
            this.ksf = intent.getIntExtra("key_start_from", 0);
            if (this.ksf == 0) {
                this.ksf = this.krW.azq;
            }
            this.krh = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.krg = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.krj = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.krk = intent.getBooleanExtra("host_only", false);
            this.krm = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, 2);
            if (this.mSortType == 2) {
                this.krh = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.krp = intent.getIntExtra("is_top", 0);
            this.krq = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.krw = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.krx = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.jrp = intent.getBooleanExtra("is_sub_pb", false);
            this.krz = intent.getBooleanExtra("is_pv", false);
            this.kry = intent.getLongExtra("msg_id", 0L);
            this.krA = intent.getStringExtra("from_forum_name");
            this.krH = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.krG = intent.getStringExtra("op_stat");
            this.krB = intent.getBooleanExtra("is_from_thread_config", false);
            this.krC = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.krD = intent.getBooleanExtra("is_from_my_god_config", false);
            this.krJ = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.krI = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.dUI = intent.getBooleanExtra("from_frs", false);
            this.krv = intent.getBooleanExtra("from_maintab", false);
            this.krU = intent.getBooleanExtra("from_smart_frs", false);
            this.krE = intent.getBooleanExtra("from_hottopic", false);
            this.krZ = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.kri = intent.getStringExtra("high_light_post_id");
            this.kso = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.krK = intent.getIntExtra("request_code", -1) == 18003;
            this.ksp = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.ksq = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.ksr = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.kss = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean cNH() {
        return this.kso && com.baidu.tieba.frs.k.cbl() != null && com.baidu.tieba.frs.k.cbl().equals(this.krf) && com.baidu.tieba.frs.k.cbk() != null;
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
        fVar.khv = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.ksf = bundle.getInt("key_start_from", 0);
        this.krf = bundle.getString("thread_id");
        this.krh = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.krg = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.krj = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.krk = bundle.getBoolean("host_only", false);
        this.krm = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.krp = bundle.getInt("is_top", 0);
        this.krq = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.krx = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.jrp = bundle.getBoolean("is_sub_pb", false);
        this.krz = bundle.getBoolean("is_pv", false);
        this.kry = bundle.getLong("msg_id", 0L);
        this.krA = bundle.getString("from_forum_name");
        this.krH = bundle.getString("extra_pb_cache_key");
        this.krB = bundle.getBoolean("is_from_thread_config", false);
        this.krC = bundle.getBoolean("is_from_interview_live_config", false);
        this.krD = bundle.getBoolean("is_from_my_god_config", false);
        this.krJ = bundle.getInt("extra_pb_is_attention_key", -1);
        this.krI = bundle.getInt("extra_pb_funs_count_key", -1);
        this.dUI = bundle.getBoolean("from_frs", false);
        this.krv = bundle.getBoolean("from_maintab", false);
        this.krU = bundle.getBoolean("from_smart_frs", false);
        this.krE = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.kri = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.krK = bundle.getInt("request_code", -1) == 18003;
        this.ksp = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.ksq = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.ksr = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.kss = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aD(Bundle bundle) {
        bundle.putString("thread_id", this.krf);
        bundle.putString("post_id", this.krh);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.ksf);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.krj);
        bundle.putBoolean("host_only", this.krk);
        bundle.putBoolean("squence", this.krm);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.krp);
        bundle.putLong("thread_time", this.krq);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.krx);
        bundle.putBoolean("is_sub_pb", this.jrp);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.krz);
        bundle.putLong("msg_id", this.kry);
        bundle.putString("extra_pb_cache_key", this.krH);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.krB);
        bundle.putBoolean("is_from_interview_live_config", this.krC);
        bundle.putBoolean("is_from_my_god_config", this.krD);
        bundle.putInt("extra_pb_is_attention_key", this.krJ);
        bundle.putInt("extra_pb_funs_count_key", this.krI);
        bundle.putBoolean("from_frs", this.dUI);
        bundle.putBoolean("from_maintab", this.krv);
        bundle.putBoolean("from_smart_frs", this.krU);
        bundle.putBoolean("from_hottopic", this.krE);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.kri);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.ksp);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.ksq);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.ksr);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.kss);
    }

    public String cNI() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.krf);
        if (!this.krx) {
            sb.append(this.krh);
        }
        sb.append(this.krk);
        sb.append(this.krm);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.krp);
        sb.append(this.krq);
        sb.append(this.dUI);
        sb.append(this.krv);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.jrp);
        sb.append(this.krz);
        sb.append(this.kry);
        sb.append(this.krA);
        sb.append(this.mThreadType);
        sb.append(this.krB);
        sb.append(this.krC);
        sb.append(this.krD);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.krH != null) {
            sb.append(this.krH);
        }
        return sb.toString();
    }

    public String cLG() {
        return this.krA;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cNJ() {
        return this.krh;
    }

    public String cNK() {
        return this.kri;
    }

    public String cNL() {
        return this.krf;
    }

    public String cNM() {
        return (StringUtils.isNull(this.krf) || "0".equals(this.krf)) ? this.oriUgcNid : this.krf;
    }

    public boolean getHostMode() {
        return this.krk;
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
        return this.kro;
    }

    public boolean cNQ() {
        return this.krv;
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
        return this.krp;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void BN(int i) {
        this.krp = i;
    }

    public boolean cNS() {
        return this.jrp;
    }

    public boolean cNT() {
        if (this.kli == null) {
            return false;
        }
        return this.kli.isValid();
    }

    public String aWt() {
        if (this.kli == null || !this.kli.aSj()) {
            return null;
        }
        return this.kli.aSi();
    }

    public boolean BO(int i) {
        this.krr = i;
        if (this.krr > this.kli.getPage().aUW()) {
            this.krr = this.kli.getPage().aUW();
        }
        if (this.krr < 1) {
            this.krr = 1;
        }
        if (this.krf == null) {
            return false;
        }
        return BQ(5);
    }

    public void BP(int i) {
        this.krr = i;
        this.krs = i;
        this.krt = i;
    }

    public void b(com.baidu.tbadk.core.data.au auVar) {
        if (auVar == null) {
            BP(1);
            return;
        }
        if (this.krs < auVar.aUZ()) {
            this.krs = auVar.aUZ();
        }
        if (this.krt > auVar.aUZ()) {
            this.krt = auVar.aUZ();
        }
        this.kru = auVar.aUW();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.kli;
    }

    public BaijiahaoData cNU() {
        if (this.kli == null || this.kli.cKx() == null) {
            return null;
        }
        return this.kli.cKx().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f cNV() {
        if (this.kli == null) {
            return this.kli;
        }
        if (!cNW() && this.ksn != null) {
            this.kli.b(this.ksn);
        }
        return this.kli;
    }

    private boolean cNW() {
        return (this.kli.cKP() == null || this.kli.cKP().dkW() == null || this.kli.cKP().dkW().goods != null || this.kli.cKP().dkW().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.au getPageData() {
        if (this.kli == null) {
            return null;
        }
        return this.kli.getPage();
    }

    public boolean cNX() {
        if (cOC() && this.kli.getPage().aVb() == 0) {
            sw(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.krf = fVar.getThreadId();
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
            this.krh = null;
            this.krk = false;
            this.krm = true;
            LoadData();
        }
    }

    public void KA(String str) {
        if (!StringUtils.isNull(str)) {
            this.krf = str;
            this.krh = null;
            this.krk = false;
            this.krm = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.krf == null) {
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
            this.krG = null;
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
        if (this.ksc != null) {
            this.ksc.cancelLoadData();
        }
        if (this.ksd != null) {
            this.ksd.cancelLoadData();
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
        return (this.krh == null || this.krh.equals("0") || this.krh.length() == 0) ? LoadData() : cOc();
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
                this.ksc.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.ksc.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.ksd == null) {
                this.ksd = new GetSugMatchWordsModel(this.hjZ.getPageContext());
            }
            this.ksd.b(aVar);
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
            this.krm = as.cPg().cNN();
            this.krk = as.cPg().cPl();
            this.kro = as.cPg().cPm();
            this.ksh = as.cPg().cPk();
            this.ksi = as.cPg().cPj();
            this.ksj = as.cPg().cPi();
            this.ksl = as.cPg().cPn();
            this.mTabIndex = as.cPg().getTabIndex();
            this.kse = this.krk;
            if (this.krk || this.isFromMark) {
                this.krK = false;
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
        if (i == 4 && !this.krO) {
            a(cOh(), true, this.krh, 3);
        }
        if (i == 3 && !this.krO) {
            if (this.isFromMark) {
                a(cOh(), true, this.krh, 3);
            } else {
                a(cOh(), false, this.krh, 3);
            }
        }
        this.krO = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.ksn == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.ezm);
        if (this.krk || this.isFromMark) {
            this.krK = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.krf == null || this.krf.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.krf, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.at.baS().baT() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.krm) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.krk) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.krz) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.kry));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.krK) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.krG, 0));
            pbPageRequestMessage.setOpMessageID(this.kry);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> cKz = this.kli.cKz();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.krt - 1));
                        if (this.krt - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.krw) {
                                if (cKz != null && cKz.size() > 0) {
                                    size = cKz.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = cKz.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.krh = postData.getId();
                                            if (StringUtils.isNull(this.krh)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.krs + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.krh == null && this.krh.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.krh, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.krs + 1));
                        if (this.krs >= this.kru) {
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
                            if (this.krh == null) {
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
                if (this.krh == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (cKz != null && cKz.size() > 0 && cKz.get(0) != null) {
                    this.krh = cKz.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (cOC()) {
                        if (this.krt - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.krt - 1));
                        }
                    } else if (this.krs < this.kru) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.krs + 1));
                    }
                }
                if (this.krh != null && this.krh.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.krh, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.krk) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (cOC()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.kru > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kru));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.krh, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.krr));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.kse && !this.krk) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.krh, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.krk) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.krS);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.ksg, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.kse = this.krk;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cOh());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.ksf));
        pbPageRequestMessage.setIsSubPostDataReverse(this.krR);
        pbPageRequestMessage.setFromSmartFrs(this.krU ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.krj);
        if (this.ksf == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.kst)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.kst));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.kru) {
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
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.krf);
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
        ArrayList<PostData> cKz = this.kli.cKz();
        this.krN = false;
        if (i == 1) {
            boolean z2 = false;
            while (cKz.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cKz.remove(0);
                z2 = true;
            }
            if (z2) {
                this.kli.getPage().kU(1);
                if (this.krF != null) {
                    this.krF.e(this.kli);
                }
            }
            this.hZN = System.currentTimeMillis();
            this.krN = true;
        } else if (i == 2) {
            while (cKz.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cKz.remove(cKz.size() - 1);
                z = true;
            }
            if (z) {
                this.kli.getPage().kT(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.krV = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.ksn != null && this.ksn.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cKP() != null && fVar.cKP().dkW() != null && fVar.cKP().dkW().goods != null && fVar.cKP().isValidate() && fVar.cKP().dkW().goods.goods_style != 1001) {
            this.ksn = fVar.cKP();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n cNZ() {
        return this.ksn;
    }

    public void cOa() {
        this.ksn = null;
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
            if (this.krD || this.krB || this.krC) {
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
                for (int i2 = 0; i2 < postData.dlf().size(); i2++) {
                    postData.dlf().get(i2).a(this.hjZ.getPageContext(), o.equals(postData.dlf().get(i2).aWl().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r cKL = fVar.cKL();
            if (cKL != null && !com.baidu.tbadk.core.util.x.isEmpty(cKL.kiW)) {
                for (PostData postData2 : cKL.kiW) {
                    for (int i3 = 0; i3 < postData2.dlf().size(); i3++) {
                        postData2.dlf().get(i3).a(this.hjZ.getPageContext(), o.equals(postData2.dlf().get(i3).aWl().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r cKL = fVar.cKL();
            if (cKL != null && !com.baidu.tbadk.core.util.x.isEmpty(cKL.kiW)) {
                for (PostData postData : cKL.kiW.subList(i, cKL.kiW.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dlf().size()) {
                            postData.dlf().get(i3).a(this.hjZ.getPageContext(), o.equals(postData.dlf().get(i3).aWl().getUserId()));
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
        cKx.lc(this.krp);
        if (this.krq > 0) {
            cKx.cq(this.krq);
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
        if (this.kli == null || this.kli.cKx() == null || this.kli.cKx().aWl() == null) {
            return null;
        }
        return this.kli.cKx().aWl();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.krT = z3;
        if (this.hli != null && !z3) {
            this.hli.a(z2, z4, i2, str, i3, j, j2);
            this.hli = null;
        }
        if (this.kli != null) {
            this.kli.kif = z3;
            this.kli.Xq = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(cLG()) && com.baidu.tieba.recapp.r.dca().dbU() != null) {
            com.baidu.tieba.recapp.r.dca().dbU().f(cLG(), BS(cOk()), true);
        }
        if (fVar == null || (this.krr == 1 && i == 5 && fVar.cKz() != null && fVar.cKz().size() < 1)) {
            if (this.krF != null) {
                this.krm = this.krl;
                if (i2 != 350006) {
                    this.mSortType = this.krn;
                }
                this.krF.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.krl = this.krm;
            if (i != 8) {
                this.krn = this.mSortType;
                this.mSortType = fVar.khp;
            }
            if (fVar.kho != null && fVar.kho.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.hjZ.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.kho = new ArrayList();
                fVar.kho.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.hjZ.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.kho.add(builder2.build(false));
                this.mSortType = this.krn;
                fVar.khp = this.mSortType;
            }
            this.krz = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.kru = this.kru < 1 ? 1 : this.kru;
            int i6 = 0;
            ArrayList<PostData> cKz = this.kli.cKz();
            switch (i) {
                case 1:
                    this.kli.a(fVar.getPage(), 1);
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
                    this.kli.a(fVar.getPage(), 2);
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
                    if (fVar != null && !com.baidu.tbadk.core.util.x.isEmpty(fVar.cKz()) && this.kli != null && (!this.krk || o(fVar).equals(fVar.cKz().get(0).aWl().getUserId()))) {
                        if (this.kli.getPage().aVb() == 0) {
                            this.kli.getPage().kT(1);
                        }
                        cOw();
                        this.ksh = fVar.cKz().get(0);
                        if (cOC() || this.kli.cLa()) {
                            if (this.kli.cKz().size() - this.ksj >= 3) {
                                this.ksi = new PostData();
                                this.ksi.lND = true;
                                this.ksi.setPostType(53);
                                this.kli.cKz().add(this.ksi);
                            }
                            this.kli.cKz().add(this.ksh);
                            size = this.kli.cKz().size() - 1;
                        } else {
                            if (this.ksj - this.ksk >= 3) {
                                this.ksi = new PostData();
                                this.ksi.lND = false;
                                this.ksi.setPostType(53);
                                this.kli.cKz().add(0, this.ksi);
                            }
                            this.kli.cKz().add(0, this.ksh);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.as.isTaday(com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.ksh.lNQ = this.kli.cKY();
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
            if (this.kli != null && this.kli.cKx() != null) {
                PraiseData aVW = this.kli.cKx().aVW();
                if (this.ksx != null && !aVW.isPriaseDataValid()) {
                    this.kli.cKx().a(this.ksx);
                } else {
                    this.ksx = this.kli.cKx().aVW();
                    this.ksx.setPostId(this.kli.cKx().aWC());
                }
                if (fVar.getPage() != null && fVar.getPage().aUZ() == 1 && fVar.cKx() != null && fVar.cKx().aWv() != null && fVar.cKx().aWv().size() > 0) {
                    this.kli.cKx().y(fVar.cKx().aWv());
                }
                this.kli.cKx().la(fVar.cKx().aWc());
                this.kli.cKx().kX(fVar.cKx().getAnchorLevel());
                this.kli.cKx().kY(fVar.cKx().aVS());
                if (this.mThreadType == 33) {
                    this.kli.cKx().aWl().setHadConcerned(fVar.cKx().aWl().hadConcerned());
                }
                if (fVar != null && fVar.cKx() != null) {
                    this.kli.cKx().lf(fVar.cKx().aWz());
                }
            }
            if (this.kli != null && this.kli.getUserData() != null && fVar.getUserData() != null) {
                this.kli.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.kli.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().aUZ() == 1 && fVar.cKK() != null) {
                this.kli.f(fVar.cKK());
            }
            if (this.krT) {
                if (this.kli.cKx() != null && this.kli.cKx().aWl() != null && this.kli.cKz() != null && com.baidu.tbadk.core.util.x.getItem(this.kli.cKz(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.getItem(this.kli.cKz(), 0);
                    MetaData aWl = this.kli.cKx().aWl();
                    if (postData3.aWl() != null && postData3.aWl().getGodUserData() != null) {
                        if (this.krI != -1) {
                            aWl.setFansNum(this.krI);
                            postData3.aWl().setFansNum(this.krI);
                        }
                        if (this.krJ != -1) {
                            aWl.getGodUserData().setIsLike(this.krJ == 1);
                            postData3.aWl().getGodUserData().setIsLike(this.krJ == 1);
                            aWl.getGodUserData().setIsFromNetWork(false);
                            postData3.aWl().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.kli.khn = -1;
                this.kli.khm = -1;
            }
            if (this.krF != null) {
                this.krF.a(true, getErrorCode(), i, i4, this.kli, this.mErrorString, 1);
            }
        }
        if (this.kli != null && this.kli.cKx() != null && this.kli.getForum() != null && !this.kli.cLa()) {
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
        if (this.kli != null) {
            this.kli.cKO().clear();
            this.kli.cKO().addAll(fVar.cKO());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aQ;
        if (arrayList != null && fVar.cKz() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(fVar.cKz(), 0);
            if (postData != null && (aQ = aQ(arrayList)) != null && aQ.equals(postData.getId())) {
                fVar.cKz().remove(postData);
            }
            this.kli.kie = arrayList.size();
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
            fVar.Ks(this.kli.cKS());
            if (!this.kli.kib && fVar.kib && this.kli.cKH() != null) {
                fVar.e(this.kli.cKH());
            }
            this.kli = fVar;
            BP(fVar.getPage().aUZ());
        }
    }

    public boolean cOc() {
        if (this.krf == null || this.krh == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return BQ(4);
        }
        return BQ(6);
    }

    public boolean sw(boolean z) {
        if (this.krf == null || this.kli == null) {
            return false;
        }
        if (z || this.kli.getPage().aVb() != 0) {
            return BQ(1);
        }
        return false;
    }

    public boolean sx(boolean z) {
        if (this.krf == null || this.kli == null) {
            return false;
        }
        if ((z || this.kli.getPage().aVc() != 0) && this.kli.cKz() != null && this.kli.cKz().size() >= 1) {
            return BQ(2);
        }
        return false;
    }

    public boolean KG(String str) {
        this.krk = !this.krk;
        this.krh = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("pb_onlyowner_click").ah("obj_source", 0));
        if (BQ(6)) {
            return true;
        }
        this.krk = this.krk ? false : true;
        return false;
    }

    public boolean y(boolean z, String str) {
        if (this.krk == z) {
            return false;
        }
        this.krk = z;
        this.krh = str;
        if (this.mSortType == 2) {
            this.krh = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("pb_onlyowner_click").ah("obj_source", 1));
        }
        if (BQ(6)) {
            return true;
        }
        this.krk = z ? false : true;
        return false;
    }

    public boolean BT(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.krl = this.krm;
        this.krn = this.mSortType;
        this.mSortType = i;
        this.krm = !this.krm;
        if (i == 2 && this.isFromMark) {
            this.krh = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.krm = this.krm ? false : true;
            this.mSortType = this.krn;
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
        return (this.kli == null || this.kli.getForum() == null || this.kli.cKx() == null) ? false : true;
    }

    public boolean aSj() {
        if (this.kli == null) {
            return false;
        }
        return this.kli.aSj();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData zE(String str) {
        if (this.kli == null || this.kli.cKx() == null || this.kli.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.kli.cKx().aXI()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.kli.getForum().getId());
            writeData.setForumName(this.kli.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.ksf);
        writeData.setThreadId(this.krf);
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
        if (this.kli == null) {
            return null;
        }
        ArrayList<PostData> cKz = this.kli.cKz();
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
        markData.setThreadId(this.krf);
        markData.setPostId(this.kli.aSi());
        markData.setTime(date.getTime());
        markData.setHostMode(this.krk);
        markData.setSequence(Boolean.valueOf(cOC()));
        markData.setId(this.krf);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.krf);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.krk);
        markData.setSequence(Boolean.valueOf(cOC()));
        markData.setId(this.krf);
        markData.setFloor(postData.dli());
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
        String cOi = (this.krf == null || this.krf.equals("0")) ? cOi() : this.krf;
        if (this.krk) {
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
        if (this.kli != null) {
            this.kli.he(z);
        }
    }

    public boolean cOj() {
        return this.krK;
    }

    public void a(a aVar) {
        this.krF = aVar;
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
            this.krQ = System.currentTimeMillis() / 1000;
        }
    }

    public void cOm() {
        if ("personalize_page".equals(this.mStType) && this.kli != null && this.krQ != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10754").dn("fid", this.kli.getForumId()).dn("tid", this.krf).dn("obj_duration", String.valueOf(currentTimeMillis - this.krQ)).dn(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.krQ = 0L;
        }
    }

    public boolean cOn() {
        return this.krT;
    }

    public int getErrorNo() {
        return this.krV;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public q cOo() {
        return this.krX;
    }

    public ai cOp() {
        return this.krY;
    }

    public CheckRealNameModel cOq() {
        return this.ksa;
    }

    public AddExperiencedModel cOr() {
        return this.ksb;
    }

    public String cOs() {
        return this.krP;
    }

    public void KI(String str) {
        this.krP = str;
    }

    public boolean cOt() {
        return this.krU;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.kli != null && this.kli.cKz() != null && this.kli.cKz().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.kli.cKz().size();
                for (int i = 0; i < size; i++) {
                    if (this.kli.cKz().get(i) != null && this.kli.cKz().get(i).aWl() != null && currentAccount.equals(this.kli.cKz().get(i).aWl().getUserId()) && this.kli.cKz().get(i).aWl().getPendantData() != null) {
                        this.kli.cKz().get(i).aWl().getPendantData().wU(lVar.aUh());
                        this.kli.cKz().get(i).aWl().getPendantData().cN(lVar.bin());
                    }
                }
            }
        }
    }

    public String cOu() {
        return this.krZ;
    }

    public int cOv() {
        return this.ksf;
    }

    public void BV(int i) {
        this.ksf = i;
    }

    public void KJ(String str) {
        if ((!this.krk || KH(TbadkCoreApplication.getCurrentAccount())) && this.kli.cKz() != null) {
            this.kli.getPage().kT(1);
            if (this.kli.getPage().aVb() == 0) {
                this.kli.getPage().kT(1);
            }
            this.ksg = str;
            BQ(8);
        }
    }

    private void BW(int i) {
        if (i != 8) {
            this.ksg = "";
            if (this.ksh != null) {
                if (i == 1 && this.kli != null && this.kli.cLa()) {
                    if (this.ksi != null) {
                        getPbData().cKz().remove(this.ksi);
                    }
                } else if (i == 1 && !this.krm && !com.baidu.tbadk.core.util.x.isEmpty(getPbData().cKz())) {
                    getPbData().cKz().remove(this.ksh);
                    if (this.ksi != null) {
                        getPbData().cKz().remove(this.ksi);
                    }
                    getPbData().cKz().add(0, this.ksh);
                } else {
                    getPbData().cKz().remove(this.ksh);
                    if (this.ksi != null) {
                        getPbData().cKz().remove(this.ksi);
                    }
                }
            }
            this.ksi = null;
        }
    }

    public void cOw() {
        if (this.kli != null && !com.baidu.tbadk.core.util.x.isEmpty(this.kli.cKz())) {
            if (this.ksi != null) {
                this.kli.cKz().remove(this.ksi);
                this.ksi = null;
            }
            if (this.ksh != null) {
                this.kli.cKz().remove(this.ksh);
                this.ksh = null;
            }
        }
    }

    public void cM(int i, int i2) {
        this.ksj = i;
        this.ksk = i2;
    }

    public PostData cOx() {
        return this.ksh;
    }

    public PostData cOy() {
        return this.ksi;
    }

    public int cOz() {
        return this.ksj;
    }

    public int cOA() {
        return this.ksk;
    }

    public String cOB() {
        return this.ksm;
    }

    public void KK(String str) {
        this.ksm = str;
    }

    private boolean cOC() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean cOD() {
        return this.ksf == 13 || this.ksf == 12;
    }

    public String cOE() {
        return this.ksp;
    }

    public String cOF() {
        return this.ksq;
    }

    public String cOG() {
        return this.ksr;
    }

    public String cOH() {
        return this.kss;
    }

    public Rect cOI() {
        Rect rect = this.ksl;
        this.ksl = null;
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
