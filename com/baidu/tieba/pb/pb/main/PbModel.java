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
import com.baidu.tbadk.core.data.bu;
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
    private boolean dOx;
    private long hTM;
    private BaseFragmentActivity hep;
    private com.baidu.tieba.tbadkCore.d.b hfy;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private boolean jiH;
    protected com.baidu.tieba.pb.data.e kcE;
    private boolean kiA;
    private String kiB;
    private boolean kiC;
    private boolean kiD;
    private boolean kiE;
    private boolean kiF;
    private a kiG;
    private String kiH;
    private String kiI;
    private int kiJ;
    private int kiK;
    private boolean kiL;
    private boolean kiM;
    private boolean kiN;
    private boolean kiO;
    private boolean kiP;
    private String kiQ;
    private long kiR;
    private boolean kiS;
    private int kiT;
    private boolean kiU;
    private boolean kiV;
    private int kiW;
    private final ac kiX;
    private final o kiY;
    private final ae kiZ;
    protected String kig;
    private String kih;
    private String kii;
    private String kij;
    private boolean kik;
    private boolean kil;
    private boolean kim;
    private boolean kin;
    private int kio;
    private boolean kip;
    private int kiq;
    private long kir;
    private int kis;
    private int kit;
    private int kiu;
    private int kiv;
    private boolean kiw;
    private boolean kix;
    private boolean kiy;
    private long kiz;
    private String kja;
    private final CheckRealNameModel kjb;
    private final AddExperiencedModel kjc;
    private SuggestEmotionModel kjd;
    private GetSugMatchWordsModel kje;
    private boolean kjf;
    private int kjg;
    private String kjh;
    private PostData kji;
    private PostData kjj;
    private int kjk;
    private int kjl;
    private Rect kjm;
    private String kjn;
    private com.baidu.tieba.tbadkCore.data.n kjo;
    private boolean kjp;
    private String kjq;
    private String kjr;
    private String kjs;
    private String kjt;
    private f.a kju;
    private CustomMessageListener kjv;
    private com.baidu.adp.framework.listener.a kjw;
    private PraiseData kjx;
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
    private static final int kif = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.kig = null;
        this.isPrivacy = false;
        this.kih = null;
        this.kii = null;
        this.mForumId = null;
        this.kij = null;
        this.kik = false;
        this.kil = false;
        this.kim = true;
        this.kin = true;
        this.mSortType = 0;
        this.kio = 0;
        this.kip = false;
        this.mIsGood = 0;
        this.kiq = 0;
        this.kir = 0L;
        this.kis = 1;
        this.kit = 1;
        this.kiu = 1;
        this.kiv = 1;
        this.isAd = false;
        this.jiH = false;
        this.dOx = false;
        this.kiw = false;
        this.isFromMark = false;
        this.kix = false;
        this.kiy = false;
        this.kiz = 0L;
        this.kiA = false;
        this.kiB = null;
        this.kcE = null;
        this.isLoading = false;
        this.kiC = false;
        this.kiD = false;
        this.kiE = false;
        this.kiF = false;
        this.mLocate = null;
        this.mContext = null;
        this.kiG = null;
        this.opType = null;
        this.opUrl = null;
        this.kiH = null;
        this.kiI = null;
        this.kiJ = -1;
        this.kiK = -1;
        this.hfy = null;
        this.kiM = false;
        this.kiN = false;
        this.postID = null;
        this.kiQ = null;
        this.kiR = 0L;
        this.kiS = false;
        this.kiT = -1;
        this.kiV = false;
        this.kjf = false;
        this.kjg = 0;
        this.mTabIndex = 0;
        this.kjp = false;
        this.kjv = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.kjw = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.hep.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.kiM || !PbModel.this.kiN) {
                        if (!PbModel.this.kiM) {
                            PbModel.this.kiM = true;
                        } else {
                            PbModel.this.kiN = true;
                        }
                        if (PbModel.this.kiG != null) {
                            PbModel.this.kiG.a(PbModel.this.cJV(), z, responsedMessage, PbModel.this.kiO, System.currentTimeMillis() - PbModel.this.hTM);
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
                    if (PbModel.this.kcE != null && PbModel.this.kcE.cGN() != null && PbModel.this.kcE.cGN().getForumId() != null && PbModel.this.kcE.cGN().getForumId().equals(valueOf)) {
                        PbModel.this.kcE.cGN().setIsLike(false);
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
                    if (PbModel.this.kcE != null && PbModel.this.kcE.cGN() != null && PbModel.this.kcE.cGN().getForumId() != null && PbModel.this.kcE.cGN().getForumId().equals(valueOf)) {
                        PbModel.this.kcE.cGN().setIsLike(true);
                    }
                }
            }
        };
        this.kjx = null;
        registerListener(this.kjw);
        registerListener(this.kjv);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.kcE = new com.baidu.tieba.pb.data.e();
        this.kcE.AX(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.hep = baseFragmentActivity;
        this.kiX = new ac(this, this.hep);
        this.kiY = new o(this, this.hep);
        this.kiZ = new ae(this, this.hep);
        this.kjb = new CheckRealNameModel(this.hep.getPageContext());
        this.kjd = new SuggestEmotionModel();
        this.kjc = new AddExperiencedModel(this.hep.getPageContext());
        this.kju = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void C(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dAc) instanceof String) {
                        PbModel.this.kig = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dAc);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dAd) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dAd);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dAe) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dAe);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dAf) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.dAf), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dAg) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dAg);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, String str) {
        this.kiP = true;
        if (eVar != null && eVar.jYN == null) {
            q(eVar);
            l(eVar);
            if (eVar.cGO() != null) {
                eVar.cGO().kE(0);
            }
            if (this.kiG != null && eVar != null) {
                this.kiG.a(true, 0, i, 0, eVar, str, 0);
            }
        }
    }

    protected int cJV() {
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
            this.kig = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                com.baidu.tbadk.BdToken.f.aMH().c(uri, this.kju);
            } else if (StringUtils.isNull(this.kig)) {
                this.kiX.a(intent, this.kju);
                if (uri != null) {
                    if (StringUtils.isNull(this.kig)) {
                        this.kig = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.ar.isEmpty(this.kig)) {
                this.kig = "0";
            }
            this.kjg = intent.getIntExtra("key_start_from", 0);
            if (this.kjg == 0) {
                this.kjg = this.kiX.ayd;
            }
            this.kii = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.kih = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.kik = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.kil = intent.getBooleanExtra("host_only", false);
            this.kin = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, 2);
            if (this.mSortType == 2) {
                this.kii = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.kiq = intent.getIntExtra("is_top", 0);
            this.kir = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.kix = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.kiy = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.jiH = intent.getBooleanExtra("is_sub_pb", false);
            this.kiA = intent.getBooleanExtra("is_pv", false);
            this.kiz = intent.getLongExtra("msg_id", 0L);
            this.kiB = intent.getStringExtra("from_forum_name");
            this.kiI = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.kiH = intent.getStringExtra("op_stat");
            this.kiC = intent.getBooleanExtra("is_from_thread_config", false);
            this.kiD = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.kiE = intent.getBooleanExtra("is_from_my_god_config", false);
            this.kiK = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.kiJ = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.dOx = intent.getBooleanExtra("from_frs", false);
            this.kiw = intent.getBooleanExtra("from_maintab", false);
            this.kiV = intent.getBooleanExtra("from_smart_frs", false);
            this.kiF = intent.getBooleanExtra("from_hottopic", false);
            this.kja = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.kij = intent.getStringExtra("high_light_post_id");
            this.kjp = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.kiL = intent.getIntExtra("request_code", -1) == 18003;
            this.kjq = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.kjr = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.kjs = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.kjt = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean cJW() {
        return this.kjp && com.baidu.tieba.frs.k.bXP() != null && com.baidu.tieba.frs.k.bXP().equals(this.kig) && com.baidu.tieba.frs.k.bXO() != null;
    }

    public com.baidu.tieba.pb.data.e aJ(bu buVar) {
        com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
        eVar.AX(3);
        if (buVar == null) {
            return null;
        }
        eVar.aG(buVar);
        if (buVar.aUd() != null) {
            eVar.e(buVar.aUd());
            ForumData forum = eVar.getForum();
            forum.setId(buVar.aUd().getForumId());
            forum.setName(buVar.aUd().getForumName());
            forum.setUser_level(buVar.aUd().aRF());
            forum.setImage_url(buVar.aUd().getAvatar());
            forum.setPost_num(buVar.aUd().postNum);
            forum.setMember_num(buVar.aUd().memberNum);
        } else {
            ForumData forum2 = eVar.getForum();
            forum2.setId(String.valueOf(buVar.getFid()));
            forum2.setName(buVar.aSt());
        }
        PostData postData = new PostData();
        postData.EW(1);
        postData.setTime(buVar.getCreateTime());
        postData.a(buVar.aSp());
        MetaData aSp = buVar.aSp();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(aSp.getUserId(), aSp);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, buVar.aSf(), false));
        eVar.d(postData);
        eVar.cGQ().add(postData);
        eVar.a(new com.baidu.tieba.pb.data.m(buVar, null));
        eVar.jYS = true;
        eVar.setIsNewUrl(1);
        return eVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.kjg = bundle.getInt("key_start_from", 0);
        this.kig = bundle.getString("thread_id");
        this.kii = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.kih = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.kik = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.kil = bundle.getBoolean("host_only", false);
        this.kin = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.kiq = bundle.getInt("is_top", 0);
        this.kir = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.kiy = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.jiH = bundle.getBoolean("is_sub_pb", false);
        this.kiA = bundle.getBoolean("is_pv", false);
        this.kiz = bundle.getLong("msg_id", 0L);
        this.kiB = bundle.getString("from_forum_name");
        this.kiI = bundle.getString("extra_pb_cache_key");
        this.kiC = bundle.getBoolean("is_from_thread_config", false);
        this.kiD = bundle.getBoolean("is_from_interview_live_config", false);
        this.kiE = bundle.getBoolean("is_from_my_god_config", false);
        this.kiK = bundle.getInt("extra_pb_is_attention_key", -1);
        this.kiJ = bundle.getInt("extra_pb_funs_count_key", -1);
        this.dOx = bundle.getBoolean("from_frs", false);
        this.kiw = bundle.getBoolean("from_maintab", false);
        this.kiV = bundle.getBoolean("from_smart_frs", false);
        this.kiF = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.kij = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.kiL = bundle.getInt("request_code", -1) == 18003;
        this.kjq = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.kjr = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.kjs = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.kjt = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aC(Bundle bundle) {
        bundle.putString("thread_id", this.kig);
        bundle.putString("post_id", this.kii);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.kjg);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.kik);
        bundle.putBoolean("host_only", this.kil);
        bundle.putBoolean("squence", this.kin);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.kiq);
        bundle.putLong("thread_time", this.kir);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.kiy);
        bundle.putBoolean("is_sub_pb", this.jiH);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.kiA);
        bundle.putLong("msg_id", this.kiz);
        bundle.putString("extra_pb_cache_key", this.kiI);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.kiC);
        bundle.putBoolean("is_from_interview_live_config", this.kiD);
        bundle.putBoolean("is_from_my_god_config", this.kiE);
        bundle.putInt("extra_pb_is_attention_key", this.kiK);
        bundle.putInt("extra_pb_funs_count_key", this.kiJ);
        bundle.putBoolean("from_frs", this.dOx);
        bundle.putBoolean("from_maintab", this.kiw);
        bundle.putBoolean("from_smart_frs", this.kiV);
        bundle.putBoolean("from_hottopic", this.kiF);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.kij);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.kjq);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.kjr);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.kjs);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.kjt);
    }

    public String cJX() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.kig);
        if (!this.kiy) {
            sb.append(this.kii);
        }
        sb.append(this.kil);
        sb.append(this.kin);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.kiq);
        sb.append(this.kir);
        sb.append(this.dOx);
        sb.append(this.kiw);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.jiH);
        sb.append(this.kiA);
        sb.append(this.kiz);
        sb.append(this.kiB);
        sb.append(this.mThreadType);
        sb.append(this.kiC);
        sb.append(this.kiD);
        sb.append(this.kiE);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.kiI != null) {
            sb.append(this.kiI);
        }
        return sb.toString();
    }

    public String cHW() {
        return this.kiB;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cJY() {
        return this.kii;
    }

    public String cJZ() {
        return this.kij;
    }

    public String cKa() {
        return this.kig;
    }

    public String cKb() {
        return (StringUtils.isNull(this.kig) || "0".equals(this.kig)) ? this.oriUgcNid : this.kig;
    }

    public boolean getHostMode() {
        return this.kil;
    }

    public boolean cKc() {
        return cKR();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean cKd() {
        return this.dOx;
    }

    public boolean cKe() {
        return this.kip;
    }

    public boolean cKf() {
        return this.kiw;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean cKg() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bRl() {
        return this.kiq;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void Bo(int i) {
        this.kiq = i;
    }

    public boolean cKh() {
        return this.jiH;
    }

    public boolean cKi() {
        if (this.kcE == null) {
            return false;
        }
        return this.kcE.isValid();
    }

    public String aSx() {
        if (this.kcE == null || !this.kcE.aOo()) {
            return null;
        }
        return this.kcE.aOn();
    }

    public boolean Bp(int i) {
        this.kis = i;
        if (this.kis > this.kcE.getPage().aRa()) {
            this.kis = this.kcE.getPage().aRa();
        }
        if (this.kis < 1) {
            this.kis = 1;
        }
        if (this.kig == null) {
            return false;
        }
        return Br(5);
    }

    public void Bq(int i) {
        this.kis = i;
        this.kit = i;
        this.kiu = i;
    }

    public void b(com.baidu.tbadk.core.data.at atVar) {
        if (atVar == null) {
            Bq(1);
            return;
        }
        if (this.kit < atVar.aRd()) {
            this.kit = atVar.aRd();
        }
        if (this.kiu > atVar.aRd()) {
            this.kiu = atVar.aRd();
        }
        this.kiv = atVar.aRa();
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        return this.kcE;
    }

    public BaijiahaoData cKj() {
        if (this.kcE == null || this.kcE.cGO() == null) {
            return null;
        }
        return this.kcE.cGO().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.e cKk() {
        if (this.kcE == null) {
            return this.kcE;
        }
        if (!cKl() && this.kjo != null) {
            this.kcE.b(this.kjo);
        }
        return this.kcE;
    }

    private boolean cKl() {
        return (this.kcE.cHg() == null || this.kcE.cHg().dhN() == null || this.kcE.cHg().dhN().goods != null || this.kcE.cHg().dhN().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.at getPageData() {
        if (this.kcE == null) {
            return null;
        }
        return this.kcE.getPage();
    }

    public boolean cKm() {
        if (cKR() && this.kcE.getPage().aRf() == 0) {
            rR(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.kig = eVar.getThreadId();
            if (eVar.cGO() != null && eVar.cGO().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = eVar.cGO().getBaijiahaoData();
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
            this.kii = null;
            this.kil = false;
            this.kin = true;
            LoadData();
        }
    }

    public void JN(String str) {
        if (!StringUtils.isNull(str)) {
            this.kig = str;
            this.kii = null;
            this.kil = false;
            this.kin = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.kig == null) {
            return false;
        }
        cancelLoadData();
        if (this.hfy == null) {
            this.hfy = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.hfy.start();
        }
        boolean Br = Br(3);
        if (this.opType != null) {
            this.opType = null;
            this.kiH = null;
            this.opUrl = null;
            return Br;
        }
        return Br;
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
        if (this.kjd != null) {
            this.kjd.cancelLoadData();
        }
        if (this.kje != null) {
            this.kje.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.cZL().cZP();
        bSA();
    }

    private void bSA() {
        if (this.hfy != null) {
            this.hfy.destory();
            this.hfy = null;
        }
    }

    public boolean cKn() {
        return (this.kii == null || this.kii.equals("0") || this.kii.length() == 0) ? LoadData() : cKr();
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
                this.kjd.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.kjd.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.kje == null) {
                this.kje = new GetSugMatchWordsModel(this.hep.getPageContext());
            }
            this.kje.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x036c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0374 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x022e, B:77:0x0232, B:79:0x024c, B:81:0x0256, B:191:0x0502, B:192:0x0508, B:195:0x0515, B:84:0x0263, B:190:0x04fc, B:86:0x028c, B:87:0x02aa, B:89:0x02c2, B:91:0x02c8, B:93:0x02cf, B:94:0x02dc, B:96:0x02f0, B:98:0x02f6, B:100:0x02fc, B:109:0x032c, B:111:0x0332, B:101:0x0307, B:103:0x030b, B:105:0x0313, B:107:0x0322, B:108:0x0327, B:112:0x033e, B:114:0x0352, B:116:0x0356, B:119:0x0368, B:122:0x036e, B:150:0x03e4, B:125:0x0374, B:127:0x037a, B:128:0x037f, B:130:0x0383, B:132:0x038d, B:137:0x03a4, B:139:0x03b2, B:140:0x03b5, B:142:0x03b9, B:143:0x03c4, B:145:0x03c8, B:147:0x03d0, B:149:0x03df, B:151:0x03e9, B:153:0x03ed, B:134:0x0391, B:154:0x03f6, B:155:0x0424, B:157:0x0428, B:167:0x0459, B:160:0x0434, B:162:0x0442, B:163:0x044a, B:165:0x044e, B:166:0x0454, B:168:0x0462, B:170:0x046e, B:159:0x042c, B:171:0x0478, B:173:0x0484, B:175:0x0488, B:177:0x048c, B:178:0x0491, B:180:0x049d, B:181:0x04a5, B:185:0x04bf, B:182:0x04aa, B:184:0x04b9, B:186:0x04c8, B:188:0x04d7, B:38:0x00e3), top: B:198:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0383 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x022e, B:77:0x0232, B:79:0x024c, B:81:0x0256, B:191:0x0502, B:192:0x0508, B:195:0x0515, B:84:0x0263, B:190:0x04fc, B:86:0x028c, B:87:0x02aa, B:89:0x02c2, B:91:0x02c8, B:93:0x02cf, B:94:0x02dc, B:96:0x02f0, B:98:0x02f6, B:100:0x02fc, B:109:0x032c, B:111:0x0332, B:101:0x0307, B:103:0x030b, B:105:0x0313, B:107:0x0322, B:108:0x0327, B:112:0x033e, B:114:0x0352, B:116:0x0356, B:119:0x0368, B:122:0x036e, B:150:0x03e4, B:125:0x0374, B:127:0x037a, B:128:0x037f, B:130:0x0383, B:132:0x038d, B:137:0x03a4, B:139:0x03b2, B:140:0x03b5, B:142:0x03b9, B:143:0x03c4, B:145:0x03c8, B:147:0x03d0, B:149:0x03df, B:151:0x03e9, B:153:0x03ed, B:134:0x0391, B:154:0x03f6, B:155:0x0424, B:157:0x0428, B:167:0x0459, B:160:0x0434, B:162:0x0442, B:163:0x044a, B:165:0x044e, B:166:0x0454, B:168:0x0462, B:170:0x046e, B:159:0x042c, B:171:0x0478, B:173:0x0484, B:175:0x0488, B:177:0x048c, B:178:0x0491, B:180:0x049d, B:181:0x04a5, B:185:0x04bf, B:182:0x04aa, B:184:0x04b9, B:186:0x04c8, B:188:0x04d7, B:38:0x00e3), top: B:198:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03b9 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x022e, B:77:0x0232, B:79:0x024c, B:81:0x0256, B:191:0x0502, B:192:0x0508, B:195:0x0515, B:84:0x0263, B:190:0x04fc, B:86:0x028c, B:87:0x02aa, B:89:0x02c2, B:91:0x02c8, B:93:0x02cf, B:94:0x02dc, B:96:0x02f0, B:98:0x02f6, B:100:0x02fc, B:109:0x032c, B:111:0x0332, B:101:0x0307, B:103:0x030b, B:105:0x0313, B:107:0x0322, B:108:0x0327, B:112:0x033e, B:114:0x0352, B:116:0x0356, B:119:0x0368, B:122:0x036e, B:150:0x03e4, B:125:0x0374, B:127:0x037a, B:128:0x037f, B:130:0x0383, B:132:0x038d, B:137:0x03a4, B:139:0x03b2, B:140:0x03b5, B:142:0x03b9, B:143:0x03c4, B:145:0x03c8, B:147:0x03d0, B:149:0x03df, B:151:0x03e9, B:153:0x03ed, B:134:0x0391, B:154:0x03f6, B:155:0x0424, B:157:0x0428, B:167:0x0459, B:160:0x0434, B:162:0x0442, B:163:0x044a, B:165:0x044e, B:166:0x0454, B:168:0x0462, B:170:0x046e, B:159:0x042c, B:171:0x0478, B:173:0x0484, B:175:0x0488, B:177:0x048c, B:178:0x0491, B:180:0x049d, B:181:0x04a5, B:185:0x04bf, B:182:0x04aa, B:184:0x04b9, B:186:0x04c8, B:188:0x04d7, B:38:0x00e3), top: B:198:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03c8 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x022e, B:77:0x0232, B:79:0x024c, B:81:0x0256, B:191:0x0502, B:192:0x0508, B:195:0x0515, B:84:0x0263, B:190:0x04fc, B:86:0x028c, B:87:0x02aa, B:89:0x02c2, B:91:0x02c8, B:93:0x02cf, B:94:0x02dc, B:96:0x02f0, B:98:0x02f6, B:100:0x02fc, B:109:0x032c, B:111:0x0332, B:101:0x0307, B:103:0x030b, B:105:0x0313, B:107:0x0322, B:108:0x0327, B:112:0x033e, B:114:0x0352, B:116:0x0356, B:119:0x0368, B:122:0x036e, B:150:0x03e4, B:125:0x0374, B:127:0x037a, B:128:0x037f, B:130:0x0383, B:132:0x038d, B:137:0x03a4, B:139:0x03b2, B:140:0x03b5, B:142:0x03b9, B:143:0x03c4, B:145:0x03c8, B:147:0x03d0, B:149:0x03df, B:151:0x03e9, B:153:0x03ed, B:134:0x0391, B:154:0x03f6, B:155:0x0424, B:157:0x0428, B:167:0x0459, B:160:0x0434, B:162:0x0442, B:163:0x044a, B:165:0x044e, B:166:0x0454, B:168:0x0462, B:170:0x046e, B:159:0x042c, B:171:0x0478, B:173:0x0484, B:175:0x0488, B:177:0x048c, B:178:0x0491, B:180:0x049d, B:181:0x04a5, B:185:0x04bf, B:182:0x04aa, B:184:0x04b9, B:186:0x04c8, B:188:0x04d7, B:38:0x00e3), top: B:198:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03ed A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x022e, B:77:0x0232, B:79:0x024c, B:81:0x0256, B:191:0x0502, B:192:0x0508, B:195:0x0515, B:84:0x0263, B:190:0x04fc, B:86:0x028c, B:87:0x02aa, B:89:0x02c2, B:91:0x02c8, B:93:0x02cf, B:94:0x02dc, B:96:0x02f0, B:98:0x02f6, B:100:0x02fc, B:109:0x032c, B:111:0x0332, B:101:0x0307, B:103:0x030b, B:105:0x0313, B:107:0x0322, B:108:0x0327, B:112:0x033e, B:114:0x0352, B:116:0x0356, B:119:0x0368, B:122:0x036e, B:150:0x03e4, B:125:0x0374, B:127:0x037a, B:128:0x037f, B:130:0x0383, B:132:0x038d, B:137:0x03a4, B:139:0x03b2, B:140:0x03b5, B:142:0x03b9, B:143:0x03c4, B:145:0x03c8, B:147:0x03d0, B:149:0x03df, B:151:0x03e9, B:153:0x03ed, B:134:0x0391, B:154:0x03f6, B:155:0x0424, B:157:0x0428, B:167:0x0459, B:160:0x0434, B:162:0x0442, B:163:0x044a, B:165:0x044e, B:166:0x0454, B:168:0x0462, B:170:0x046e, B:159:0x042c, B:171:0x0478, B:173:0x0484, B:175:0x0488, B:177:0x048c, B:178:0x0491, B:180:0x049d, B:181:0x04a5, B:185:0x04bf, B:182:0x04aa, B:184:0x04b9, B:186:0x04c8, B:188:0x04d7, B:38:0x00e3), top: B:198:0x00d7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Br(int i) {
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
        Bs(i);
        final com.baidu.tieba.pb.data.e pbData = ao.cLu().getPbData();
        if (pbData != null && pbData.cGO() != null) {
            pbData.cGO().kE(0);
            this.kin = ao.cLu().cKc();
            this.kil = ao.cLu().cLz();
            this.kip = ao.cLu().cLA();
            this.kji = ao.cLu().cLy();
            this.kjj = ao.cLu().cLx();
            this.kjk = ao.cLu().cLw();
            this.kjm = ao.cLu().cLB();
            this.mTabIndex = ao.cLu().getTabIndex();
            this.kjf = this.kil;
            if (this.kil || this.isFromMark) {
                this.kiL = false;
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
        if (i == 4 && !this.kiP) {
            a(cKw(), true, this.kii, 3);
        }
        if (i == 3 && !this.kiP) {
            if (this.isFromMark) {
                a(cKw(), true, this.kii, 3);
            } else {
                a(cKw(), false, this.kii, 3);
            }
        }
        this.kiP = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.kjo == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.esT);
        if (this.kil || this.isFromMark) {
            this.kiL = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.kig == null || this.kig.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.kig, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.as.aWR().aWS() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.kin) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.kil) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.kiA) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.kiz));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.kiL) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.kiH, 0));
            pbPageRequestMessage.setOpMessageID(this.kiz);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> cGQ = this.kcE.cGQ();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kiu - 1));
                        if (this.kiu - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.kix) {
                                if (cGQ != null && cGQ.size() > 0) {
                                    size = cGQ.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = cGQ.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.kii = postData.getId();
                                            if (StringUtils.isNull(this.kii)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.kit + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.kii == null && this.kii.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kii, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kit + 1));
                        if (this.kit >= this.kiv) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (cGQ != null) {
                                size = cGQ.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.kii == null) {
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
                if (cGQ != null) {
                }
                if (this.kii == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (cGQ != null && cGQ.size() > 0 && cGQ.get(0) != null) {
                    this.kii = cGQ.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (cKR()) {
                        if (this.kiu - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.kiu - 1));
                        }
                    } else if (this.kit < this.kiv) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kit + 1));
                    }
                }
                if (this.kii != null && this.kii.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kii, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.kil) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (cKR()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.kiv > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.kiv));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kii, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.kis));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.kjf && !this.kil) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kii, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.kil) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.kiT);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.kjh, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.kjf = this.kil;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cKw());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.kjg));
        pbPageRequestMessage.setIsSubPostDataReverse(this.kiS);
        pbPageRequestMessage.setFromSmartFrs(this.kiV ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.kik);
        if (this.kjg == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.kiv) {
                    i4 = -1;
                } else {
                    i4 = cKY();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = cKY();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.kig);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean cHV() {
        switch (cKK()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().cGO() == null || !getPbData().cGO().aTM();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cHW()) && com.baidu.tieba.recapp.q.cYT().cYN() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.cYT().cYN().aS(cHW(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.cYT().cYN().aT(cHW(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cHW()) && com.baidu.tieba.recapp.q.cYT().cYN() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.cYT().cYN().aT(cHW(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.cYT().cYN().aS(cHW(), true));
        }
    }

    protected void Bs(int i) {
        boolean z = false;
        Bx(i);
        ArrayList<PostData> cGQ = this.kcE.cGQ();
        this.kiO = false;
        if (i == 1) {
            boolean z2 = false;
            while (cGQ.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cGQ.remove(0);
                z2 = true;
            }
            if (z2) {
                this.kcE.getPage().kA(1);
                if (this.kiG != null) {
                    this.kiG.e(this.kcE);
                }
            }
            this.hTM = System.currentTimeMillis();
            this.kiO = true;
        } else if (i == 2) {
            while (cGQ.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cGQ.remove(cGQ.size() - 1);
                z = true;
            }
            if (z) {
                this.kcE.getPage().kz(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.e eVar2 = z ? null : eVar;
        this.kiW = i2;
        this.isLoading = false;
        if (eVar2 != null) {
            l(eVar2);
        }
        k(eVar2);
        if (this.kjo != null && this.kjo.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(eVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cHg() != null && eVar.cHg().dhN() != null && eVar.cHg().dhN().goods != null && eVar.cHg().isValidate() && eVar.cHg().dhN().goods.goods_style != 1001) {
            this.kjo = eVar.cHg();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n cKo() {
        return this.kjo;
    }

    public void cKp() {
        this.kjo = null;
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
            if (this.kiE || this.kiC || this.kiD) {
                eVar = n(eVar);
            }
            m(eVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            String o = o(eVar);
            for (int i = 0; i < eVar.cGQ().size(); i++) {
                PostData postData = eVar.cGQ().get(i);
                for (int i2 = 0; i2 < postData.dhW().size(); i2++) {
                    postData.dhW().get(i2).a(this.hep.getPageContext(), o.equals(postData.dhW().get(i2).aSp().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.p cHc = eVar.cHc();
            if (cHc != null && !com.baidu.tbadk.core.util.w.isEmpty(cHc.kao)) {
                for (PostData postData2 : cHc.kao) {
                    for (int i3 = 0; i3 < postData2.dhW().size(); i3++) {
                        postData2.dhW().get(i3).a(this.hep.getPageContext(), o.equals(postData2.dhW().get(i3).aSp().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i) {
        if (eVar != null) {
            String o = o(eVar);
            com.baidu.tieba.pb.data.p cHc = eVar.cHc();
            if (cHc != null && !com.baidu.tbadk.core.util.w.isEmpty(cHc.kao)) {
                for (PostData postData : cHc.kao.subList(i, cHc.kao.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dhW().size()) {
                            postData.dhW().get(i3).a(this.hep.getPageContext(), o.equals(postData.dhW().get(i3).aSp().getUserId()));
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
        bu cGO = eVar.cGO();
        cGO.kJ(this.mIsGood);
        cGO.kI(this.kiq);
        if (this.kir > 0) {
            cGO.cb(this.kir);
            return eVar;
        }
        return eVar;
    }

    protected String o(com.baidu.tieba.pb.data.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.cGO() != null && eVar.cGO().aSp() != null) {
            str = eVar.cGO().aSp().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData cKq() {
        if (this.kcE == null || this.kcE.cGO() == null || this.kcE.cGO().aSp() == null) {
            return null;
        }
        return this.kcE.cGO().aSp();
    }

    protected void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.kiU = z3;
        if (this.hfy != null && !z3) {
            this.hfy.a(z2, z4, i2, str, i3, j, j2);
            this.hfy = null;
        }
        if (this.kcE != null) {
            this.kcE.jZB = z3;
            this.kcE.Xx = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(cHW()) && com.baidu.tieba.recapp.q.cYT().cYN() != null) {
            com.baidu.tieba.recapp.q.cYT().cYN().f(cHW(), Bt(cKz()), true);
        }
        if (eVar == null || (this.kis == 1 && i == 5 && eVar.cGQ() != null && eVar.cGQ().size() < 1)) {
            if (this.kiG != null) {
                this.kin = this.kim;
                if (i2 != 350006) {
                    this.mSortType = this.kio;
                }
                this.kiG.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.kim = this.kin;
            if (i != 8) {
                this.kio = this.mSortType;
                this.mSortType = eVar.jYM;
            }
            if (eVar.jYL != null && eVar.jYL.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.hep.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                eVar.jYL = new ArrayList();
                eVar.jYL.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.hep.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                eVar.jYL.add(builder2.build(false));
                this.mSortType = this.kio;
                eVar.jYM = this.mSortType;
            }
            this.kiA = false;
            if (eVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(eVar.getPage());
            }
            this.kiv = this.kiv < 1 ? 1 : this.kiv;
            int i6 = 0;
            ArrayList<PostData> cGQ = this.kcE.cGQ();
            switch (i) {
                case 1:
                    this.kcE.a(eVar.getPage(), 1);
                    d(eVar, cGQ);
                    p(eVar);
                    i4 = 0;
                    break;
                case 2:
                    if (eVar.cGQ() == null) {
                        i5 = 0;
                    } else {
                        int size2 = eVar.cGQ().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.w.getItem(cGQ, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.w.getItem(eVar.cGQ(), com.baidu.tbadk.core.util.w.getCount(eVar.cGQ()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            eVar.cGQ().remove(postData2);
                            i5 = size2 - 1;
                        }
                        cGQ.addAll(0, eVar.cGQ());
                    }
                    p(eVar);
                    this.kcE.a(eVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && eVar.getPage() != null) {
                        eVar.getPage().kx(eVar.getPage().aRa());
                    }
                    q(eVar);
                    i4 = 0;
                    break;
                case 4:
                    q(eVar);
                    i4 = 0;
                    break;
                case 5:
                    q(eVar);
                    i4 = 0;
                    break;
                case 6:
                    q(eVar);
                    i4 = 0;
                    break;
                case 7:
                    q(eVar);
                    i4 = 0;
                    break;
                case 8:
                    if (eVar != null && !com.baidu.tbadk.core.util.w.isEmpty(eVar.cGQ()) && this.kcE != null && (!this.kil || o(eVar).equals(eVar.cGQ().get(0).aSp().getUserId()))) {
                        if (this.kcE.getPage().aRf() == 0) {
                            this.kcE.getPage().kz(1);
                        }
                        cKL();
                        this.kji = eVar.cGQ().get(0);
                        if (cKR() || this.kcE.cHq()) {
                            if (this.kcE.cGQ().size() - this.kjk >= 3) {
                                this.kjj = new PostData();
                                this.kjj.lGn = true;
                                this.kjj.setPostType(53);
                                this.kcE.cGQ().add(this.kjj);
                            }
                            this.kcE.cGQ().add(this.kji);
                            size = this.kcE.cGQ().size() - 1;
                        } else {
                            if (this.kjk - this.kjl >= 3) {
                                this.kjj = new PostData();
                                this.kjj.lGn = false;
                                this.kjj.setPostType(53);
                                this.kcE.cGQ().add(0, this.kjj);
                            }
                            this.kcE.cGQ().add(0, this.kji);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ar.isTaday(com.baidu.tbadk.core.sharedPref.b.aVP().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.kji.lGA = this.kcE.cHo();
                            com.baidu.tbadk.core.sharedPref.b.aVP().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        }
                        i6 = size;
                    }
                    p(eVar);
                    i4 = i6;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.kcE != null && this.kcE.cGO() != null) {
                PraiseData aSa = this.kcE.cGO().aSa();
                if (this.kjx != null && !aSa.isPriaseDataValid()) {
                    this.kcE.cGO().a(this.kjx);
                } else {
                    this.kjx = this.kcE.cGO().aSa();
                    this.kjx.setPostId(this.kcE.cGO().aSG());
                }
                if (eVar.getPage() != null && eVar.getPage().aRd() == 1 && eVar.cGO() != null && eVar.cGO().aSz() != null && eVar.cGO().aSz().size() > 0) {
                    this.kcE.cGO().x(eVar.cGO().aSz());
                }
                this.kcE.cGO().kG(eVar.cGO().aSg());
                this.kcE.cGO().kD(eVar.cGO().getAnchorLevel());
                this.kcE.cGO().kE(eVar.cGO().aRW());
                if (this.mThreadType == 33) {
                    this.kcE.cGO().aSp().setHadConcerned(eVar.cGO().aSp().hadConcerned());
                }
                if (eVar != null && eVar.cGO() != null) {
                    this.kcE.cGO().kL(eVar.cGO().aSD());
                }
            }
            if (this.kcE != null && this.kcE.getUserData() != null && eVar.getUserData() != null) {
                this.kcE.getUserData().setBimg_end_time(eVar.getUserData().getBimg_end_time());
                this.kcE.getUserData().setBimg_url(eVar.getUserData().getBimg_url());
            }
            if (eVar.getPage() != null && eVar.getPage().aRd() == 1 && eVar.cHb() != null) {
                this.kcE.f(eVar.cHb());
            }
            if (this.kiU) {
                if (this.kcE.cGO() != null && this.kcE.cGO().aSp() != null && this.kcE.cGQ() != null && com.baidu.tbadk.core.util.w.getItem(this.kcE.cGQ(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.w.getItem(this.kcE.cGQ(), 0);
                    MetaData aSp = this.kcE.cGO().aSp();
                    if (postData3.aSp() != null && postData3.aSp().getGodUserData() != null) {
                        if (this.kiJ != -1) {
                            aSp.setFansNum(this.kiJ);
                            postData3.aSp().setFansNum(this.kiJ);
                        }
                        if (this.kiK != -1) {
                            aSp.getGodUserData().setIsLike(this.kiK == 1);
                            postData3.aSp().getGodUserData().setIsLike(this.kiK == 1);
                            aSp.getGodUserData().setIsFromNetWork(false);
                            postData3.aSp().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.kcE.jYK = -1;
                this.kcE.jYJ = -1;
            }
            if (this.kiG != null) {
                this.kiG.a(true, getErrorCode(), i, i4, this.kcE, this.mErrorString, 1);
            }
        }
        if (this.kcE != null && this.kcE.cGO() != null && this.kcE.getForum() != null && !this.kcE.cHq()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.hep.getPageContext();
            historyMessage.threadId = getPbData().cGO().getId();
            if (this.mIsShareThread && getPbData().cGO().dNX != null) {
                historyMessage.threadName = getPbData().cGO().dNX.showText;
            } else {
                historyMessage.threadName = getPbData().cGO().getTitle();
            }
            if (this.mIsShareThread && !cHV()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = cKc();
            historyMessage.threadType = getPbData().cGO().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.e eVar) {
        if (this.kcE != null) {
            this.kcE.cHf().clear();
            this.kcE.cHf().addAll(eVar.cHf());
        }
    }

    protected void d(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        String aP;
        if (arrayList != null && eVar.cGQ() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.w.getItem(eVar.cGQ(), 0);
            if (postData != null && (aP = aP(arrayList)) != null && aP.equals(postData.getId())) {
                eVar.cGQ().remove(postData);
            }
            this.kcE.jZA = arrayList.size();
            arrayList.addAll(eVar.cGQ());
        }
    }

    private int Bt(int i) {
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

    private String aP(ArrayList<PostData> arrayList) {
        int count = com.baidu.tbadk.core.util.w.getCount(arrayList);
        if (count <= 0) {
            return null;
        }
        for (int i = count - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.w.getItem(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    private void q(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            eVar.JG(this.kcE.cHi());
            if (!this.kcE.jZy && eVar.jZy && this.kcE.cGY() != null) {
                eVar.e(this.kcE.cGY());
            }
            this.kcE = eVar;
            Bq(eVar.getPage().aRd());
        }
    }

    public boolean cKr() {
        if (this.kig == null || this.kii == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return Br(4);
        }
        return Br(6);
    }

    public boolean rR(boolean z) {
        if (this.kig == null || this.kcE == null) {
            return false;
        }
        if (z || this.kcE.getPage().aRf() != 0) {
            return Br(1);
        }
        return false;
    }

    public boolean rS(boolean z) {
        if (this.kig == null || this.kcE == null) {
            return false;
        }
        if ((z || this.kcE.getPage().aRg() != 0) && this.kcE.cGQ() != null && this.kcE.cGQ().size() >= 1) {
            return Br(2);
        }
        return false;
    }

    public boolean JT(String str) {
        this.kil = !this.kil;
        this.kii = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("pb_onlyowner_click").ag("obj_source", 0));
        if (Br(6)) {
            return true;
        }
        this.kil = this.kil ? false : true;
        return false;
    }

    public boolean y(boolean z, String str) {
        if (this.kil == z) {
            return false;
        }
        this.kil = z;
        this.kii = str;
        if (this.mSortType == 2) {
            this.kii = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("pb_onlyowner_click").ag("obj_source", 1));
        }
        if (Br(6)) {
            return true;
        }
        this.kil = z ? false : true;
        return false;
    }

    public boolean Bu(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.kim = this.kin;
        this.kio = this.mSortType;
        this.mSortType = i;
        this.kin = !this.kin;
        if (i == 2 && this.isFromMark) {
            this.kii = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.kin = this.kin ? false : true;
            this.mSortType = this.kio;
            return false;
        }
        return true;
    }

    public boolean cKs() {
        return cKR();
    }

    public int cKt() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.kcE == null || this.kcE.getForum() == null || this.kcE.cGO() == null) ? false : true;
    }

    public boolean aOo() {
        if (this.kcE == null) {
            return false;
        }
        return this.kcE.aOo();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData yy(String str) {
        if (this.kcE == null || this.kcE.cGO() == null || this.kcE.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.kcE.cGO().aTM()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.kcE.getForum().getId());
            writeData.setForumName(this.kcE.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.kjg);
        writeData.setThreadId(this.kig);
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

    public MarkData Bv(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.kcE == null) {
            return null;
        }
        ArrayList<PostData> cGQ = this.kcE.cGQ();
        if (com.baidu.tbadk.core.util.w.isEmpty(cGQ)) {
            return null;
        }
        if (cGQ.size() > 0 && i >= cGQ.size()) {
            i = cGQ.size() - 1;
        }
        return o(cGQ.get(i));
    }

    public MarkData cKu() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kig);
        markData.setPostId(this.kcE.aOn());
        markData.setTime(date.getTime());
        markData.setHostMode(this.kil);
        markData.setSequence(Boolean.valueOf(cKR()));
        markData.setId(this.kig);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kig);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.kil);
        markData.setSequence(Boolean.valueOf(cKR()));
        markData.setId(this.kig);
        markData.setFloor(postData.dhZ());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) postData).isApp());
        }
        return markData;
    }

    public void cKv() {
        j.cIJ().aM(cKw(), this.isFromMark);
    }

    private String cKw() {
        String cKx = (this.kig == null || this.kig.equals("0")) ? cKx() : this.kig;
        if (this.kil) {
            cKx = cKx + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            cKx = cKx + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return cKx + TbadkCoreApplication.getCurrentAccount();
        }
        return cKx;
    }

    private String cKx() {
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

    public void rT(boolean z) {
        if (this.kcE != null) {
            this.kcE.gJ(z);
        }
    }

    public boolean cKy() {
        return this.kiL;
    }

    public void a(a aVar) {
        this.kiG = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bfw() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bfv() {
        return cKn();
    }

    public boolean JU(String str) {
        if (getPbData() == null || getPbData().cGO() == null || getPbData().cGO().aSp() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().cGO().aSp().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int cKz() {
        return this.mRequestType;
    }

    public void cKA() {
        if ("personalize_page".equals(this.mStType)) {
            this.kiR = System.currentTimeMillis() / 1000;
        }
    }

    public void cKB() {
        if ("personalize_page".equals(this.mStType) && this.kcE != null && this.kiR != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10754").dk("fid", this.kcE.getForumId()).dk("tid", this.kig).dk("obj_duration", String.valueOf(currentTimeMillis - this.kiR)).dk(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.kiR = 0L;
        }
    }

    public boolean cKC() {
        return this.kiU;
    }

    public int getErrorNo() {
        return this.kiW;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public o cKD() {
        return this.kiY;
    }

    public ae cKE() {
        return this.kiZ;
    }

    public CheckRealNameModel cKF() {
        return this.kjb;
    }

    public AddExperiencedModel cKG() {
        return this.kjc;
    }

    public String cKH() {
        return this.kiQ;
    }

    public void JV(String str) {
        this.kiQ = str;
    }

    public boolean cKI() {
        return this.kiV;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.kcE != null && this.kcE.cGQ() != null && this.kcE.cGQ().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.kcE.cGQ().size();
                for (int i = 0; i < size; i++) {
                    if (this.kcE.cGQ().get(i) != null && this.kcE.cGQ().get(i).aSp() != null && currentAccount.equals(this.kcE.cGQ().get(i).aSp().getUserId()) && this.kcE.cGQ().get(i).aSp().getPendantData() != null) {
                        this.kcE.cGQ().get(i).aSp().getPendantData().vN(lVar.aQl());
                        this.kcE.cGQ().get(i).aSp().getPendantData().ct(lVar.beE());
                    }
                }
            }
        }
    }

    public String cKJ() {
        return this.kja;
    }

    public int cKK() {
        return this.kjg;
    }

    public void Bw(int i) {
        this.kjg = i;
    }

    public void JW(String str) {
        if ((!this.kil || JU(TbadkCoreApplication.getCurrentAccount())) && this.kcE.cGQ() != null) {
            this.kcE.getPage().kz(1);
            if (this.kcE.getPage().aRf() == 0) {
                this.kcE.getPage().kz(1);
            }
            this.kjh = str;
            Br(8);
        }
    }

    private void Bx(int i) {
        if (i != 8) {
            this.kjh = "";
            if (this.kji != null) {
                if (i == 1 && this.kcE != null && this.kcE.cHq()) {
                    if (this.kjj != null) {
                        getPbData().cGQ().remove(this.kjj);
                    }
                } else if (i == 1 && !this.kin && !com.baidu.tbadk.core.util.w.isEmpty(getPbData().cGQ())) {
                    getPbData().cGQ().remove(this.kji);
                    if (this.kjj != null) {
                        getPbData().cGQ().remove(this.kjj);
                    }
                    getPbData().cGQ().add(0, this.kji);
                } else {
                    getPbData().cGQ().remove(this.kji);
                    if (this.kjj != null) {
                        getPbData().cGQ().remove(this.kjj);
                    }
                }
            }
            this.kjj = null;
        }
    }

    public void cKL() {
        if (this.kcE != null && !com.baidu.tbadk.core.util.w.isEmpty(this.kcE.cGQ())) {
            if (this.kjj != null) {
                this.kcE.cGQ().remove(this.kjj);
                this.kjj = null;
            }
            if (this.kji != null) {
                this.kcE.cGQ().remove(this.kji);
                this.kji = null;
            }
        }
    }

    public void cJ(int i, int i2) {
        this.kjk = i;
        this.kjl = i2;
    }

    public PostData cKM() {
        return this.kji;
    }

    public PostData cKN() {
        return this.kjj;
    }

    public int cKO() {
        return this.kjk;
    }

    public int cKP() {
        return this.kjl;
    }

    public String cKQ() {
        return this.kjn;
    }

    public void JX(String str) {
        this.kjn = str;
    }

    private boolean cKR() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean cKS() {
        return this.kjg == 13 || this.kjg == 12;
    }

    public String cKT() {
        return this.kjq;
    }

    public String cKU() {
        return this.kjr;
    }

    public String cKV() {
        return this.kjs;
    }

    public String cKW() {
        return this.kjt;
    }

    public Rect cKX() {
        Rect rect = this.kjm;
        this.kjm = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int cKY() {
        int i;
        int i2 = 0;
        if (getPbData().cGQ() == null) {
            return 0;
        }
        ArrayList<PostData> cGQ = getPbData().cGQ();
        int size = cGQ.size() - 1;
        while (size >= 0) {
            PostData postData = cGQ.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
                if (postData.getType() != AdvertAppInfo.dGz) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return cGQ.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
