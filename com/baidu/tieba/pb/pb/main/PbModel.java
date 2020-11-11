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
    private boolean eGN;
    private BaseFragmentActivity ilu;
    private com.baidu.tieba.tbadkCore.d.b imA;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private long jcD;
    private boolean kwo;
    protected com.baidu.tieba.pb.data.f lqP;
    private boolean lxA;
    private boolean lxB;
    private boolean lxC;
    private a lxD;
    private String lxE;
    private String lxF;
    private int lxG;
    private int lxH;
    private boolean lxI;
    private boolean lxJ;
    private boolean lxK;
    private boolean lxL;
    private boolean lxM;
    private String lxN;
    private long lxO;
    private boolean lxP;
    private int lxQ;
    private boolean lxR;
    private boolean lxS;
    private int lxT;
    private final ag lxU;
    private final q lxV;
    private final ai lxW;
    private String lxX;
    private final CheckRealNameModel lxY;
    private final AddExperiencedModel lxZ;
    protected String lxd;
    private String lxe;
    private String lxf;
    private String lxg;
    private boolean lxh;
    private boolean lxi;
    private boolean lxj;
    private boolean lxk;
    private int lxl;
    private boolean lxm;
    private int lxn;
    private long lxo;
    private int lxp;
    private int lxq;
    private int lxr;
    private int lxs;
    private boolean lxt;
    private boolean lxu;
    private boolean lxv;
    private long lxw;
    private boolean lxx;
    private String lxy;
    private boolean lxz;
    private SuggestEmotionModel lya;
    private GetSugMatchWordsModel lyb;
    private boolean lyc;
    private int lyd;
    private String lye;
    private PostData lyf;
    private PostData lyg;
    private int lyh;
    private int lyi;
    private Rect lyj;
    private String lyk;
    private com.baidu.tieba.tbadkCore.data.n lyl;
    private boolean lym;
    private String lyn;
    private String lyp;
    private String lyq;
    private String lyr;
    private String lys;
    private f.a lyt;
    private CustomMessageListener lyu;
    private com.baidu.adp.framework.listener.a lyv;
    private PraiseData lyw;
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
    private static final int lxc = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.lxd = null;
        this.isPrivacy = false;
        this.lxe = null;
        this.lxf = null;
        this.mForumId = null;
        this.lxg = null;
        this.lxh = false;
        this.lxi = false;
        this.lxj = true;
        this.lxk = true;
        this.mSortType = 0;
        this.lxl = 0;
        this.lxm = false;
        this.mIsGood = 0;
        this.lxn = 0;
        this.lxo = 0L;
        this.lxp = 1;
        this.lxq = 1;
        this.lxr = 1;
        this.lxs = 1;
        this.isAd = false;
        this.kwo = false;
        this.eGN = false;
        this.lxt = false;
        this.isFromMark = false;
        this.lxu = false;
        this.lxv = false;
        this.lxw = 0L;
        this.lxx = false;
        this.lxy = null;
        this.lqP = null;
        this.isLoading = false;
        this.lxz = false;
        this.lxA = false;
        this.lxB = false;
        this.lxC = false;
        this.mLocate = null;
        this.mContext = null;
        this.lxD = null;
        this.opType = null;
        this.opUrl = null;
        this.lxE = null;
        this.lxF = null;
        this.lxG = -1;
        this.lxH = -1;
        this.imA = null;
        this.lxJ = false;
        this.lxK = false;
        this.postID = null;
        this.lxN = null;
        this.lxO = 0L;
        this.lxP = false;
        this.lxQ = -1;
        this.lxS = false;
        this.lyc = false;
        this.lyd = 0;
        this.mTabIndex = 0;
        this.lym = false;
        this.lyu = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.lyv = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.ilu.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.lxJ || !PbModel.this.lxK) {
                        if (!PbModel.this.lxJ) {
                            PbModel.this.lxJ = true;
                        } else {
                            PbModel.this.lxK = true;
                        }
                        if (PbModel.this.lxD != null) {
                            PbModel.this.lxD.a(PbModel.this.dls(), z, responsedMessage, PbModel.this.lxL, System.currentTimeMillis() - PbModel.this.jcD);
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
                    if (PbModel.this.lqP != null && PbModel.this.lqP.dij() != null && PbModel.this.lqP.dij().getForumId() != null && PbModel.this.lqP.dij().getForumId().equals(valueOf)) {
                        PbModel.this.lqP.dij().setIsLike(false);
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
                    if (PbModel.this.lqP != null && PbModel.this.lqP.dij() != null && PbModel.this.lqP.dij().getForumId() != null && PbModel.this.lqP.dij().getForumId().equals(valueOf)) {
                        PbModel.this.lqP.dij().setIsLike(true);
                    }
                }
            }
        };
        this.lyw = null;
        registerListener(this.lyv);
        registerListener(this.lyu);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.lqP = new com.baidu.tieba.pb.data.f();
        this.lqP.FC(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.ilu = baseFragmentActivity;
        this.lxU = new ag(this, this.ilu);
        this.lxV = new q(this, this.ilu);
        this.lxW = new ai(this, this.ilu);
        this.lxY = new CheckRealNameModel(this.ilu.getPageContext());
        this.lya = new SuggestEmotionModel();
        this.lxZ = new AddExperiencedModel(this.ilu.getPageContext());
        this.lyt = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void B(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.erI) instanceof String) {
                        PbModel.this.lxd = (String) hashMap.get(com.baidu.tbadk.BdToken.f.erI);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.erJ) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.erJ);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.erK) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.erK);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.erL) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.erL), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.erM) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.erM);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.lxM = true;
        if (fVar != null && fVar.lmV == null) {
            q(fVar);
            l(fVar);
            if (fVar.dik() != null) {
                fVar.dik().oh(0);
            }
            if (this.lxD != null && fVar != null) {
                this.lxD.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int dls() {
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
            this.lxd = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.lys = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                com.baidu.tbadk.BdToken.f.bgz().c(uri, this.lyt);
            } else if (StringUtils.isNull(this.lxd)) {
                this.lxU.a(intent, this.lyt);
                if (uri != null) {
                    if (StringUtils.isNull(this.lxd)) {
                        this.lxd = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.at.isEmpty(this.lxd)) {
                this.lxd = "0";
            }
            this.lyd = intent.getIntExtra("key_start_from", 0);
            if (this.lyd == 0) {
                this.lyd = this.lxU.aKu;
            }
            this.lxf = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.lxe = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.lxh = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.lxi = intent.getBooleanExtra("host_only", false);
            this.lxk = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.lxf = this.mSortType == 2 ? "0" : this.lxf;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.lxn = intent.getIntExtra("is_top", 0);
            this.lxo = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.lxu = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.lxv = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.kwo = intent.getBooleanExtra("is_sub_pb", false);
            this.lxx = intent.getBooleanExtra("is_pv", false);
            this.lxw = intent.getLongExtra("msg_id", 0L);
            this.lxy = intent.getStringExtra("from_forum_name");
            this.lxF = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.lxE = intent.getStringExtra("op_stat");
            this.lxz = intent.getBooleanExtra("is_from_thread_config", false);
            this.lxA = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.lxB = intent.getBooleanExtra("is_from_my_god_config", false);
            this.lxH = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.lxG = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.eGN = intent.getBooleanExtra("from_frs", false);
            this.lxt = intent.getBooleanExtra("from_maintab", false);
            this.lxS = intent.getBooleanExtra("from_smart_frs", false);
            this.lxC = intent.getBooleanExtra("from_hottopic", false);
            this.lxX = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.lxg = intent.getStringExtra("high_light_post_id");
            this.lym = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.lxI = intent.getIntExtra("request_code", -1) == 18003;
            this.lyn = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.lyp = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.lyq = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.lyr = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean dlt() {
        return this.lym && com.baidu.tieba.frs.l.cya() != null && com.baidu.tieba.frs.l.cya().equals(this.lxd) && com.baidu.tieba.frs.l.cxZ() != null;
    }

    public com.baidu.tieba.pb.data.f aI(bw bwVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.FC(3);
        if (bwVar == null) {
            return null;
        }
        fVar.aF(bwVar);
        if (bwVar.boo() != null) {
            fVar.d(bwVar.boo());
            ForumData forum = fVar.getForum();
            forum.setId(bwVar.boo().getForumId());
            forum.setName(bwVar.boo().getForumName());
            forum.setUser_level(bwVar.boo().blQ());
            forum.setImage_url(bwVar.boo().getAvatar());
            forum.setPost_num(bwVar.boo().postNum);
            forum.setMember_num(bwVar.boo().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(bwVar.getFid()));
            forum2.setName(bwVar.bmE());
        }
        PostData postData = new PostData();
        postData.JD(1);
        postData.setTime(bwVar.getCreateTime());
        postData.a(bwVar.bmA());
        MetaData bmA = bwVar.bmA();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(bmA.getUserId(), bmA);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bwVar.bmq(), false));
        fVar.d(postData);
        fVar.dim().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.o(bwVar, null));
        fVar.lna = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.lyd = bundle.getInt("key_start_from", 0);
        this.lxd = bundle.getString("thread_id");
        this.lxf = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.lxe = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.lxh = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.lxi = bundle.getBoolean("host_only", false);
        this.lxk = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.lxn = bundle.getInt("is_top", 0);
        this.lxo = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.lxv = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.kwo = bundle.getBoolean("is_sub_pb", false);
        this.lxx = bundle.getBoolean("is_pv", false);
        this.lxw = bundle.getLong("msg_id", 0L);
        this.lxy = bundle.getString("from_forum_name");
        this.lxF = bundle.getString("extra_pb_cache_key");
        this.lxz = bundle.getBoolean("is_from_thread_config", false);
        this.lxA = bundle.getBoolean("is_from_interview_live_config", false);
        this.lxB = bundle.getBoolean("is_from_my_god_config", false);
        this.lxH = bundle.getInt("extra_pb_is_attention_key", -1);
        this.lxG = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eGN = bundle.getBoolean("from_frs", false);
        this.lxt = bundle.getBoolean("from_maintab", false);
        this.lxS = bundle.getBoolean("from_smart_frs", false);
        this.lxC = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.lxg = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.lxI = bundle.getInt("request_code", -1) == 18003;
        this.lyn = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.lyp = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.lyq = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.lyr = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aC(Bundle bundle) {
        bundle.putString("thread_id", this.lxd);
        bundle.putString("post_id", this.lxf);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.lyd);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.lxh);
        bundle.putBoolean("host_only", this.lxi);
        bundle.putBoolean("squence", this.lxk);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.lxn);
        bundle.putLong("thread_time", this.lxo);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.lxv);
        bundle.putBoolean("is_sub_pb", this.kwo);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.lxx);
        bundle.putLong("msg_id", this.lxw);
        bundle.putString("extra_pb_cache_key", this.lxF);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.lxz);
        bundle.putBoolean("is_from_interview_live_config", this.lxA);
        bundle.putBoolean("is_from_my_god_config", this.lxB);
        bundle.putInt("extra_pb_is_attention_key", this.lxH);
        bundle.putInt("extra_pb_funs_count_key", this.lxG);
        bundle.putBoolean("from_frs", this.eGN);
        bundle.putBoolean("from_maintab", this.lxt);
        bundle.putBoolean("from_smart_frs", this.lxS);
        bundle.putBoolean("from_hottopic", this.lxC);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.lxg);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.lyn);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.lyp);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.lyq);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.lyr);
    }

    public String dlu() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.lxd);
        if (!this.lxv) {
            sb.append(this.lxf);
        }
        sb.append(this.lxi);
        sb.append(this.lxk);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.lxn);
        sb.append(this.lxo);
        sb.append(this.eGN);
        sb.append(this.lxt);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.kwo);
        sb.append(this.lxx);
        sb.append(this.lxw);
        sb.append(this.lxy);
        sb.append(this.mThreadType);
        sb.append(this.lxz);
        sb.append(this.lxA);
        sb.append(this.lxB);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.lxF != null) {
            sb.append(this.lxF);
        }
        return sb.toString();
    }

    public String djr() {
        return this.lxy;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String dlv() {
        return this.lxf;
    }

    public String dlw() {
        return this.lxg;
    }

    public String dlx() {
        return this.lxd;
    }

    public String dly() {
        return (StringUtils.isNull(this.lxd) || "0".equals(this.lxd)) ? this.oriUgcNid : this.lxd;
    }

    public boolean getHostMode() {
        return this.lxi;
    }

    public boolean dlz() {
        return dmo();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean dlA() {
        return this.eGN;
    }

    public boolean dlB() {
        return this.lxm;
    }

    public boolean dlC() {
        return this.lxt;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean dlD() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int crc() {
        return this.lxn;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void FU(int i) {
        this.lxn = i;
    }

    public boolean dlE() {
        return this.kwo;
    }

    public boolean dlF() {
        if (this.lqP == null) {
            return false;
        }
        return this.lqP.isValid();
    }

    public String bmI() {
        if (this.lqP == null || !this.lqP.biv()) {
            return null;
        }
        return this.lqP.biu();
    }

    public boolean FV(int i) {
        this.lxp = i;
        if (this.lxp > this.lqP.getPage().bll()) {
            this.lxp = this.lqP.getPage().bll();
        }
        if (this.lxp < 1) {
            this.lxp = 1;
        }
        if (this.lxd == null) {
            return false;
        }
        return FX(5);
    }

    public void FW(int i) {
        this.lxp = i;
        this.lxq = i;
        this.lxr = i;
    }

    public void b(com.baidu.tbadk.core.data.av avVar) {
        if (avVar == null) {
            FW(1);
            return;
        }
        if (this.lxq < avVar.blo()) {
            this.lxq = avVar.blo();
        }
        if (this.lxr > avVar.blo()) {
            this.lxr = avVar.blo();
        }
        this.lxs = avVar.bll();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.lqP;
    }

    public BaijiahaoData dlG() {
        if (this.lqP == null || this.lqP.dik() == null) {
            return null;
        }
        return this.lqP.dik().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f dlH() {
        if (this.lqP == null) {
            return this.lqP;
        }
        if (!dlI() && this.lyl != null) {
            this.lqP.b(this.lyl);
        }
        return this.lqP;
    }

    private boolean dlI() {
        return (this.lqP.diC() == null || this.lqP.diC().dJN() == null || this.lqP.diC().dJN().goods != null || this.lqP.diC().dJN().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.av getPageData() {
        if (this.lqP == null) {
            return null;
        }
        return this.lqP.getPage();
    }

    public boolean dlJ() {
        if (dmo() && this.lqP.getPage().blq() == 0) {
            uv(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.lxd = fVar.getThreadId();
            if (fVar.dik() != null && fVar.dik().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.dik().getBaijiahaoData();
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
            this.lxf = null;
            this.lxi = false;
            this.lxk = true;
            LoadData();
        }
    }

    public void Pz(String str) {
        if (!StringUtils.isNull(str)) {
            this.lxd = str;
            this.lxf = null;
            this.lxi = false;
            this.lxk = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lxd == null) {
            return false;
        }
        cancelLoadData();
        if (this.imA == null) {
            this.imA = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.imA.start();
        }
        boolean FX = FX(3);
        if (this.opType != null) {
            this.opType = null;
            this.lxE = null;
            this.opUrl = null;
            return FX;
        }
        return FX;
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
        if (this.lya != null) {
            this.lya.cancelLoadData();
        }
        if (this.lyb != null) {
            this.lyb.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dBj().dBn();
        csA();
    }

    private void csA() {
        if (this.imA != null) {
            this.imA.destory();
            this.imA = null;
        }
    }

    public boolean dlK() {
        return (this.lxf == null || this.lxf.equals("0") || this.lxf.length() == 0) ? LoadData() : dlO();
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
                this.lya.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.lya.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.lyb == null) {
                this.lyb = new GetSugMatchWordsModel(this.ilu.getPageContext());
            }
            this.lyb.b(aVar);
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
    public boolean FX(int i) {
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
        FY(i);
        final com.baidu.tieba.pb.data.f pbData = as.dmS().getPbData();
        if (pbData != null && pbData.dik() != null) {
            pbData.dik().oh(0);
            this.lxk = as.dmS().dlz();
            this.lxi = as.dmS().dmX();
            this.lxm = as.dmS().dmY();
            this.lyf = as.dmS().dmW();
            this.lyg = as.dmS().dmV();
            this.lyh = as.dmS().dmU();
            this.lyj = as.dmS().dmZ();
            this.mTabIndex = as.dmS().getTabIndex();
            this.lyc = this.lxi;
            if (this.lxi || this.isFromMark) {
                this.lxI = false;
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
        if (i == 4 && !this.lxM) {
            a(dlT(), true, this.lxf, 3);
        }
        if (i == 3 && !this.lxM) {
            if (this.isFromMark) {
                a(dlT(), true, this.lxf, 3);
            } else {
                a(dlT(), false, this.lxf, 3);
            }
        }
        this.lxM = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.lyl == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.fmC);
        if (this.lxi || this.isFromMark) {
            this.lxI = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.lxd == null || this.lxd.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.lxd, 0L));
        if (com.baidu.tbadk.a.d.bhW()) {
            pbPageRequestMessage.setFloorSortType(1);
            pbPageRequestMessage.set_rn(15);
        } else {
            pbPageRequestMessage.set_rn(30);
        }
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.au.bro().brp() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.lxk) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.lxi) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.lxx) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.lxw));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.lxI) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.lxE, 0));
            pbPageRequestMessage.setOpMessageID(this.lxw);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> dim = this.lqP.dim();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lxr - 1));
                        if (this.lxr - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.lxu) {
                                if (dim != null && dim.size() > 0) {
                                    size = dim.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = dim.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.lxf = postData.getId();
                                            if (StringUtils.isNull(this.lxf)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.lxq + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.lxf == null && this.lxf.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lxf, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lxq + 1));
                        if (this.lxq >= this.lxs) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (dim != null) {
                                size = dim.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.lxf == null) {
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
                if (dim != null) {
                }
                if (this.lxf == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (dim != null && dim.size() > 0 && dim.get(0) != null) {
                    this.lxf = dim.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (dmo()) {
                        if (this.lxr - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.lxr - 1));
                        }
                    } else if (this.lxq < this.lxs) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lxq + 1));
                    }
                }
                if (this.lxf != null && this.lxf.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lxf, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.lxi) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (dmo()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.lxs > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lxs));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lxf, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.lxp));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.lyc && !this.lxi) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lxf, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.lxi) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.lxQ);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lye, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.lyc = this.lxi;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(dlT());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.lyd));
        pbPageRequestMessage.setIsSubPostDataReverse(this.lxP);
        pbPageRequestMessage.setFromSmartFrs(this.lxS ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.lxh);
        if (this.lyd == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.lys)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.lys));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.lxs) {
                    i4 = -1;
                } else {
                    i4 = dmv();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = dmv();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.lxd);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean djq() {
        switch (dmh()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().dik() == null || !getPbData().dik().bnX();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(djr()) && com.baidu.tieba.recapp.r.dAo().dAi() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dAo().dAi().aZ(djr(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dAo().dAi().ba(djr(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(djr()) && com.baidu.tieba.recapp.r.dAo().dAi() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dAo().dAi().ba(djr(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dAo().dAi().aZ(djr(), true));
        }
    }

    protected void FY(int i) {
        boolean z = false;
        Gd(i);
        ArrayList<PostData> dim = this.lqP.dim();
        this.lxL = false;
        if (i == 1) {
            boolean z2 = false;
            while (dim.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                dim.remove(0);
                z2 = true;
            }
            if (z2) {
                this.lqP.getPage().od(1);
                if (this.lxD != null) {
                    this.lxD.e(this.lqP);
                }
            }
            this.jcD = System.currentTimeMillis();
            this.lxL = true;
        } else if (i == 2) {
            while (dim.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                dim.remove(dim.size() - 1);
                z = true;
            }
            if (z) {
                this.lqP.getPage().oc(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.lxT = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.lyl != null && this.lyl.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.diC() != null && fVar.diC().dJN() != null && fVar.diC().dJN().goods != null && fVar.diC().isValidate() && fVar.diC().dJN().goods.goods_style != 1001) {
            this.lyl = fVar.diC();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n dlL() {
        return this.lyl;
    }

    public void dlM() {
        this.lyl = null;
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
            if (this.lxB || this.lxz || this.lxA) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.dim().size(); i++) {
                PostData postData = fVar.dim().get(i);
                for (int i2 = 0; i2 < postData.dJW().size(); i2++) {
                    postData.dJW().get(i2).a(this.ilu.getPageContext(), o.equals(postData.dJW().get(i2).bmA().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r diy = fVar.diy();
            if (diy != null && !com.baidu.tbadk.core.util.y.isEmpty(diy.loD)) {
                for (PostData postData2 : diy.loD) {
                    for (int i3 = 0; i3 < postData2.dJW().size(); i3++) {
                        postData2.dJW().get(i3).a(this.ilu.getPageContext(), o.equals(postData2.dJW().get(i3).bmA().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r diy = fVar.diy();
            if (diy != null && !com.baidu.tbadk.core.util.y.isEmpty(diy.loD)) {
                for (PostData postData : diy.loD.subList(i, diy.loD.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dJW().size()) {
                            postData.dJW().get(i3).a(this.ilu.getPageContext(), o.equals(postData.dJW().get(i3).bmA().getUserId()));
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
        bw dik = fVar.dik();
        dik.om(this.mIsGood);
        dik.ol(this.lxn);
        if (this.lxo > 0) {
            dik.dh(this.lxo);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.dik() != null && fVar.dik().bmA() != null) {
            str = fVar.dik().bmA().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData dlN() {
        if (this.lqP == null || this.lqP.dik() == null || this.lqP.dik().bmA() == null) {
            return null;
        }
        return this.lqP.dik().bmA();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.lxR = z3;
        if (this.imA != null && !z3) {
            this.imA.a(z2, z4, i2, str, i3, j, j2);
            this.imA = null;
        }
        if (this.lqP != null) {
            this.lqP.lnJ = z3;
            this.lqP.YH = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(djr()) && com.baidu.tieba.recapp.r.dAo().dAi() != null) {
            com.baidu.tieba.recapp.r.dAo().dAi().f(djr(), FZ(dlW()), true);
        }
        if (fVar == null || (this.lxp == 1 && i == 5 && fVar.dim() != null && fVar.dim().size() < 1)) {
            if (this.lxD != null) {
                this.lxk = this.lxj;
                if (i2 != 350006) {
                    this.mSortType = this.lxl;
                }
                this.lxD.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.lxj = this.lxk;
            if (i != 8) {
                this.lxl = this.mSortType;
                this.mSortType = fVar.lmU;
            }
            if (fVar.lmT != null && fVar.lmT.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.ilu.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.lmT = new ArrayList();
                fVar.lmT.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.ilu.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.lmT.add(builder2.build(false));
                this.mSortType = this.lxl;
                fVar.lmU = this.mSortType;
            }
            this.lxx = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.lxs = this.lxs < 1 ? 1 : this.lxs;
            int i6 = 0;
            ArrayList<PostData> dim = this.lqP.dim();
            switch (i) {
                case 1:
                    this.lqP.a(fVar.getPage(), 1);
                    d(fVar, dim);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.dim() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.dim().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dim, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dim(), com.baidu.tbadk.core.util.y.getCount(fVar.dim()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.dim().remove(postData2);
                            i5 = size2 - 1;
                        }
                        dim.addAll(0, fVar.dim());
                    }
                    p(fVar);
                    this.lqP.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().oa(fVar.getPage().bll());
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
                    if (fVar != null && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dim()) && this.lqP != null && (!this.lxi || o(fVar).equals(fVar.dim().get(0).bmA().getUserId()))) {
                        if (this.lqP.getPage().blq() == 0) {
                            this.lqP.getPage().oc(1);
                        }
                        dmi();
                        this.lyf = fVar.dim().get(0);
                        if (dmo() || this.lqP.diN()) {
                            if (this.lqP.dim().size() - this.lyh >= 3) {
                                this.lyg = new PostData();
                                this.lyg.mXr = true;
                                this.lyg.setPostType(53);
                                this.lqP.dim().add(this.lyg);
                            }
                            this.lqP.dim().add(this.lyf);
                            size = this.lqP.dim().size() - 1;
                        } else {
                            if (this.lyh - this.lyi >= 3) {
                                this.lyg = new PostData();
                                this.lyg.mXr = false;
                                this.lyg.setPostType(53);
                                this.lqP.dim().add(0, this.lyg);
                            }
                            this.lqP.dim().add(0, this.lyf);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.at.isTaday(com.baidu.tbadk.core.sharedPref.b.bqh().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.lyf.mXE = this.lqP.diL();
                            com.baidu.tbadk.core.sharedPref.b.bqh().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.lqP != null && this.lqP.dik() != null) {
                PraiseData bml = this.lqP.dik().bml();
                if (this.lyw != null && !bml.isPriaseDataValid()) {
                    this.lqP.dik().a(this.lyw);
                } else {
                    this.lyw = this.lqP.dik().bml();
                    this.lyw.setPostId(this.lqP.dik().bmR());
                }
                if (fVar.getPage() != null && fVar.getPage().blo() == 1 && fVar.dik() != null && fVar.dik().bmK() != null && fVar.dik().bmK().size() > 0) {
                    this.lqP.dik().E(fVar.dik().bmK());
                }
                this.lqP.dik().oj(fVar.dik().bmr());
                this.lqP.dik().og(fVar.dik().getAnchorLevel());
                this.lqP.dik().oh(fVar.dik().bmh());
                if (this.mThreadType == 33) {
                    this.lqP.dik().bmA().setHadConcerned(fVar.dik().bmA().hadConcerned());
                }
                if (fVar != null && fVar.dik() != null) {
                    this.lqP.dik().oo(fVar.dik().bmO());
                }
            }
            if (this.lqP != null && this.lqP.getUserData() != null && fVar.getUserData() != null) {
                this.lqP.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.lqP.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().blo() == 1 && fVar.dix() != null) {
                this.lqP.f(fVar.dix());
            }
            if (this.lxR) {
                if (this.lqP.dik() != null && this.lqP.dik().bmA() != null && this.lqP.dim() != null && com.baidu.tbadk.core.util.y.getItem(this.lqP.dim(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(this.lqP.dim(), 0);
                    MetaData bmA = this.lqP.dik().bmA();
                    if (postData3.bmA() != null && postData3.bmA().getGodUserData() != null) {
                        if (this.lxG != -1) {
                            bmA.setFansNum(this.lxG);
                            postData3.bmA().setFansNum(this.lxG);
                        }
                        if (this.lxH != -1) {
                            bmA.getGodUserData().setIsLike(this.lxH == 1);
                            postData3.bmA().getGodUserData().setIsLike(this.lxH == 1);
                            bmA.getGodUserData().setIsFromNetWork(false);
                            postData3.bmA().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.lqP.lmS = -1;
                this.lqP.lmR = -1;
            }
            if (this.lxD != null) {
                this.lxD.a(true, getErrorCode(), i, i4, this.lqP, this.mErrorString, 1);
            }
        }
        if (this.lqP != null && this.lqP.dik() != null && this.lqP.getForum() != null && !this.lqP.diN()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.ilu.getPageContext();
            historyMessage.threadId = getPbData().dik().getId();
            if (this.mIsShareThread && getPbData().dik().eGn != null) {
                historyMessage.threadName = getPbData().dik().eGn.showText;
            } else {
                historyMessage.threadName = getPbData().dik().getTitle();
            }
            if (this.mIsShareThread && !djq()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = dlz();
            historyMessage.threadType = getPbData().dik().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.lqP != null) {
            this.lqP.diB().clear();
            this.lqP.diB().addAll(fVar.diB());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String bb;
        if (arrayList != null && fVar.dim() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dim(), 0);
            if (postData != null && (bb = bb(arrayList)) != null && bb.equals(postData.getId())) {
                fVar.dim().remove(postData);
            }
            this.lqP.lnI = arrayList.size();
            arrayList.addAll(fVar.dim());
        }
    }

    private int FZ(int i) {
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

    private String bb(ArrayList<PostData> arrayList) {
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
            fVar.Ps(this.lqP.diF());
            if (!this.lqP.lnG && fVar.lnG && this.lqP.diu() != null) {
                fVar.e(this.lqP.diu());
            }
            this.lqP = fVar;
            FW(fVar.getPage().blo());
        }
    }

    public boolean dlO() {
        if (this.lxd == null || this.lxf == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return FX(4);
        }
        return FX(6);
    }

    public boolean uv(boolean z) {
        if (this.lxd == null || this.lqP == null) {
            return false;
        }
        if (z || this.lqP.getPage().blq() != 0) {
            return FX(1);
        }
        return false;
    }

    public boolean uw(boolean z) {
        if (this.lxd == null || this.lqP == null) {
            return false;
        }
        if ((z || this.lqP.getPage().blr() != 0) && this.lqP.dim() != null && this.lqP.dim().size() >= 1) {
            return FX(2);
        }
        return false;
    }

    public boolean PF(String str) {
        this.lxi = !this.lxi;
        this.lxf = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").al("obj_source", 0));
        if (FX(6)) {
            return true;
        }
        this.lxi = this.lxi ? false : true;
        return false;
    }

    public boolean B(boolean z, String str) {
        if (this.lxi == z) {
            return false;
        }
        this.lxi = z;
        this.lxf = str;
        if (this.mSortType == 2) {
            this.lxf = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").al("obj_source", 1));
        }
        if (FX(6)) {
            return true;
        }
        this.lxi = z ? false : true;
        return false;
    }

    public boolean Ga(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_pb_current_sort_type", i);
        }
        this.lxj = this.lxk;
        this.lxl = this.mSortType;
        this.mSortType = i;
        this.lxk = !this.lxk;
        if (i == 2 && this.isFromMark) {
            this.lxf = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.lxk = this.lxk ? false : true;
            this.mSortType = this.lxl;
            return false;
        }
        return true;
    }

    public boolean dlP() {
        return dmo();
    }

    public int dlQ() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.lqP == null || this.lqP.getForum() == null || this.lqP.dik() == null) ? false : true;
    }

    public boolean biv() {
        if (this.lqP == null) {
            return false;
        }
        return this.lqP.biv();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DK(String str) {
        if (this.lqP == null || this.lqP.dik() == null || this.lqP.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.lqP.dik().bnX()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.lqP.getForum().getId());
            writeData.setForumName(this.lqP.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.lyd);
        writeData.setThreadId(this.lxd);
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

    public MarkData Gb(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.lqP == null) {
            return null;
        }
        ArrayList<PostData> dim = this.lqP.dim();
        if (com.baidu.tbadk.core.util.y.isEmpty(dim)) {
            return null;
        }
        if (dim.size() > 0 && i >= dim.size()) {
            i = dim.size() - 1;
        }
        return o(dim.get(i));
    }

    public MarkData dlR() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lxd);
        markData.setPostId(this.lqP.biu());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lxi);
        markData.setSequence(Boolean.valueOf(dmo()));
        markData.setId(this.lxd);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lxd);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lxi);
        markData.setSequence(Boolean.valueOf(dmo()));
        markData.setId(this.lxd);
        markData.setFloor(postData.dJZ());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) postData).isApp());
        }
        return markData;
    }

    public void dlS() {
        j.dkd().aU(dlT(), this.isFromMark);
    }

    private String dlT() {
        String dlU = (this.lxd == null || this.lxd.equals("0")) ? dlU() : this.lxd;
        if (this.lxi) {
            dlU = dlU + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            dlU = dlU + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            dlU = dlU + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return dlU + TbadkCoreApplication.getCurrentAccount();
        }
        return dlU;
    }

    private String dlU() {
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

    public void ux(boolean z) {
        if (this.lqP != null) {
            this.lqP.iq(z);
        }
    }

    public boolean dlV() {
        return this.lxI;
    }

    public void a(a aVar) {
        this.lxD = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bzZ() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bzY() {
        return dlK();
    }

    public boolean PG(String str) {
        if (getPbData() == null || getPbData().dik() == null || getPbData().dik().bmA() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().dik().bmA().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int dlW() {
        return this.mRequestType;
    }

    public void dlX() {
        if ("personalize_page".equals(this.mStType)) {
            this.lxO = System.currentTimeMillis() / 1000;
        }
    }

    public void dlY() {
        if ("personalize_page".equals(this.mStType) && this.lqP != null && this.lxO != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10754").dR("fid", this.lqP.getForumId()).dR("tid", this.lxd).dR("obj_duration", String.valueOf(currentTimeMillis - this.lxO)).dR(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.lxO = 0L;
        }
    }

    public boolean dlZ() {
        return this.lxR;
    }

    public int getErrorNo() {
        return this.lxT;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public q dma() {
        return this.lxV;
    }

    public ai dmb() {
        return this.lxW;
    }

    public CheckRealNameModel dmc() {
        return this.lxY;
    }

    public AddExperiencedModel dmd() {
        return this.lxZ;
    }

    public String dme() {
        return this.lxN;
    }

    public void PH(String str) {
        this.lxN = str;
    }

    public boolean dmf() {
        return this.lxS;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.lqP != null && this.lqP.dim() != null && this.lqP.dim().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lqP.dim().size();
                for (int i = 0; i < size; i++) {
                    if (this.lqP.dim().get(i) != null && this.lqP.dim().get(i).bmA() != null && currentAccount.equals(this.lqP.dim().get(i).bmA().getUserId()) && this.lqP.dim().get(i).bmA().getPendantData() != null) {
                        this.lqP.dim().get(i).bmA().getPendantData().AX(mVar.bkw());
                        this.lqP.dim().get(i).bmA().getPendantData().dF(mVar.byW());
                    }
                }
            }
        }
    }

    public String dmg() {
        return this.lxX;
    }

    public int dmh() {
        return this.lyd;
    }

    public void Gc(int i) {
        this.lyd = i;
    }

    public void PI(String str) {
        if ((!this.lxi || PG(TbadkCoreApplication.getCurrentAccount())) && this.lqP.dim() != null) {
            this.lqP.getPage().oc(1);
            if (this.lqP.getPage().blq() == 0) {
                this.lqP.getPage().oc(1);
            }
            this.lye = str;
            FX(8);
        }
    }

    private void Gd(int i) {
        if (i != 8) {
            this.lye = "";
            if (this.lyf != null) {
                if (i == 1 && this.lqP != null && this.lqP.diN()) {
                    if (this.lyg != null) {
                        getPbData().dim().remove(this.lyg);
                    }
                } else if (i == 1 && !this.lxk && !com.baidu.tbadk.core.util.y.isEmpty(getPbData().dim())) {
                    getPbData().dim().remove(this.lyf);
                    if (this.lyg != null) {
                        getPbData().dim().remove(this.lyg);
                    }
                    getPbData().dim().add(0, this.lyf);
                } else {
                    getPbData().dim().remove(this.lyf);
                    if (this.lyg != null) {
                        getPbData().dim().remove(this.lyg);
                    }
                }
            }
            this.lyg = null;
        }
    }

    public void dmi() {
        if (this.lqP != null && !com.baidu.tbadk.core.util.y.isEmpty(this.lqP.dim())) {
            if (this.lyg != null) {
                this.lqP.dim().remove(this.lyg);
                this.lyg = null;
            }
            if (this.lyf != null) {
                this.lqP.dim().remove(this.lyf);
                this.lyf = null;
            }
        }
    }

    public void db(int i, int i2) {
        this.lyh = i;
        this.lyi = i2;
    }

    public PostData dmj() {
        return this.lyf;
    }

    public PostData dmk() {
        return this.lyg;
    }

    public int dml() {
        return this.lyh;
    }

    public int dmm() {
        return this.lyi;
    }

    public String dmn() {
        return this.lyk;
    }

    public void PJ(String str) {
        this.lyk = str;
    }

    private boolean dmo() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean dmp() {
        return this.lyd == 13 || this.lyd == 12 || this.lyd == 7;
    }

    public String dmq() {
        return this.lyn;
    }

    public String dmr() {
        return this.lyp;
    }

    public String dms() {
        return this.lyq;
    }

    public String dmt() {
        return this.lyr;
    }

    public Rect dmu() {
        Rect rect = this.lyj;
        this.lyj = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int dmv() {
        int i;
        int i2 = 0;
        if (getPbData().dim() == null) {
            return 0;
        }
        ArrayList<PostData> dim = getPbData().dim();
        int size = dim.size() - 1;
        while (size >= 0) {
            PostData postData = dim.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
                if (postData.getType() != AdvertAppInfo.eyC) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return dim.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
