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
    private boolean esy;
    private BaseFragmentActivity hSW;
    private com.baidu.tieba.tbadkCore.d.b hUc;
    private long iKk;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    protected com.baidu.tieba.pb.data.f kYp;
    private boolean kdT;
    protected String leE;
    private String leF;
    private String leG;
    private String leH;
    private boolean leI;
    private boolean leJ;
    private boolean leK;
    private boolean leL;
    private int leM;
    private boolean leN;
    private int leO;
    private long leP;
    private int leQ;
    private int leR;
    private int leS;
    private int leT;
    private boolean leU;
    private boolean leV;
    private boolean leW;
    private long leX;
    private boolean leY;
    private String leZ;
    private final AddExperiencedModel lfA;
    private SuggestEmotionModel lfB;
    private GetSugMatchWordsModel lfC;
    private boolean lfD;
    private int lfE;
    private String lfF;
    private PostData lfG;
    private PostData lfH;
    private int lfI;
    private int lfJ;
    private Rect lfK;
    private String lfL;
    private com.baidu.tieba.tbadkCore.data.n lfM;
    private boolean lfN;
    private String lfO;
    private String lfP;
    private String lfQ;
    private String lfR;
    private String lfS;
    private f.a lfT;
    private CustomMessageListener lfU;
    private com.baidu.adp.framework.listener.a lfV;
    private PraiseData lfW;
    private boolean lfa;
    private boolean lfb;
    private boolean lfc;
    private boolean lfd;
    private a lfe;
    private String lff;
    private String lfg;
    private int lfh;
    private int lfi;
    private boolean lfj;
    private boolean lfk;
    private boolean lfl;
    private boolean lfm;
    private boolean lfn;
    private String lfo;
    private long lfp;
    private boolean lfq;
    private int lfr;
    private boolean lfs;
    private boolean lft;
    private int lfu;
    private final ag lfv;
    private final q lfw;
    private final ai lfx;
    private String lfy;
    private final CheckRealNameModel lfz;
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
    private static final int leD = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.leE = null;
        this.isPrivacy = false;
        this.leF = null;
        this.leG = null;
        this.mForumId = null;
        this.leH = null;
        this.leI = false;
        this.leJ = false;
        this.leK = true;
        this.leL = true;
        this.mSortType = 0;
        this.leM = 0;
        this.leN = false;
        this.mIsGood = 0;
        this.leO = 0;
        this.leP = 0L;
        this.leQ = 1;
        this.leR = 1;
        this.leS = 1;
        this.leT = 1;
        this.isAd = false;
        this.kdT = false;
        this.esy = false;
        this.leU = false;
        this.isFromMark = false;
        this.leV = false;
        this.leW = false;
        this.leX = 0L;
        this.leY = false;
        this.leZ = null;
        this.kYp = null;
        this.isLoading = false;
        this.lfa = false;
        this.lfb = false;
        this.lfc = false;
        this.lfd = false;
        this.mLocate = null;
        this.mContext = null;
        this.lfe = null;
        this.opType = null;
        this.opUrl = null;
        this.lff = null;
        this.lfg = null;
        this.lfh = -1;
        this.lfi = -1;
        this.hUc = null;
        this.lfk = false;
        this.lfl = false;
        this.postID = null;
        this.lfo = null;
        this.lfp = 0L;
        this.lfq = false;
        this.lfr = -1;
        this.lft = false;
        this.lfD = false;
        this.lfE = 0;
        this.mTabIndex = 0;
        this.lfN = false;
        this.lfU = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.lfV = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.hSW.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.lfk || !PbModel.this.lfl) {
                        if (!PbModel.this.lfk) {
                            PbModel.this.lfk = true;
                        } else {
                            PbModel.this.lfl = true;
                        }
                        if (PbModel.this.lfe != null) {
                            PbModel.this.lfe.a(PbModel.this.dfJ(), z, responsedMessage, PbModel.this.lfm, System.currentTimeMillis() - PbModel.this.iKk);
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
                    if (PbModel.this.kYp != null && PbModel.this.kYp.dcz() != null && PbModel.this.kYp.dcz().getForumId() != null && PbModel.this.kYp.dcz().getForumId().equals(valueOf)) {
                        PbModel.this.kYp.dcz().setIsLike(false);
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
                    if (PbModel.this.kYp != null && PbModel.this.kYp.dcz() != null && PbModel.this.kYp.dcz().getForumId() != null && PbModel.this.kYp.dcz().getForumId().equals(valueOf)) {
                        PbModel.this.kYp.dcz().setIsLike(true);
                    }
                }
            }
        };
        this.lfW = null;
        registerListener(this.lfV);
        registerListener(this.lfU);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.kYp = new com.baidu.tieba.pb.data.f();
        this.kYp.EW(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.hSW = baseFragmentActivity;
        this.lfv = new ag(this, this.hSW);
        this.lfw = new q(this, this.hSW);
        this.lfx = new ai(this, this.hSW);
        this.lfz = new CheckRealNameModel(this.hSW.getPageContext());
        this.lfB = new SuggestEmotionModel();
        this.lfA = new AddExperiencedModel(this.hSW.getPageContext());
        this.lfT = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void B(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.edr) instanceof String) {
                        PbModel.this.leE = (String) hashMap.get(com.baidu.tbadk.BdToken.f.edr);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eds) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eds);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.edt) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.edt);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.edu) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.edu), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.edv) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.edv);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.lfn = true;
        if (fVar != null && fVar.kUA == null) {
            q(fVar);
            l(fVar);
            if (fVar.dcA() != null) {
                fVar.dcA().nM(0);
            }
            if (this.lfe != null && fVar != null) {
                this.lfe.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int dfJ() {
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
            this.leE = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.lfS = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                com.baidu.tbadk.BdToken.f.bcg().c(uri, this.lfT);
            } else if (StringUtils.isNull(this.leE)) {
                this.lfv.a(intent, this.lfT);
                if (uri != null) {
                    if (StringUtils.isNull(this.leE)) {
                        this.leE = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.at.isEmpty(this.leE)) {
                this.leE = "0";
            }
            this.lfE = intent.getIntExtra("key_start_from", 0);
            if (this.lfE == 0) {
                this.lfE = this.lfv.aIS;
            }
            this.leG = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.leF = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.leI = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.leJ = intent.getBooleanExtra("host_only", false);
            this.leL = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.leG = this.mSortType == 2 ? "0" : this.leG;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.leO = intent.getIntExtra("is_top", 0);
            this.leP = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.leV = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.leW = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.kdT = intent.getBooleanExtra("is_sub_pb", false);
            this.leY = intent.getBooleanExtra("is_pv", false);
            this.leX = intent.getLongExtra("msg_id", 0L);
            this.leZ = intent.getStringExtra("from_forum_name");
            this.lfg = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.lff = intent.getStringExtra("op_stat");
            this.lfa = intent.getBooleanExtra("is_from_thread_config", false);
            this.lfb = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.lfc = intent.getBooleanExtra("is_from_my_god_config", false);
            this.lfi = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.lfh = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.esy = intent.getBooleanExtra("from_frs", false);
            this.leU = intent.getBooleanExtra("from_maintab", false);
            this.lft = intent.getBooleanExtra("from_smart_frs", false);
            this.lfd = intent.getBooleanExtra("from_hottopic", false);
            this.lfy = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.leH = intent.getStringExtra("high_light_post_id");
            this.lfN = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.lfj = intent.getIntExtra("request_code", -1) == 18003;
            this.lfO = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.lfP = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.lfQ = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.lfR = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean dfK() {
        return this.lfN && com.baidu.tieba.frs.l.css() != null && com.baidu.tieba.frs.l.css().equals(this.leE) && com.baidu.tieba.frs.l.csr() != null;
    }

    public com.baidu.tieba.pb.data.f aI(bw bwVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.EW(3);
        if (bwVar == null) {
            return null;
        }
        fVar.aF(bwVar);
        if (bwVar.bjV() != null) {
            fVar.d(bwVar.bjV());
            ForumData forum = fVar.getForum();
            forum.setId(bwVar.bjV().getForumId());
            forum.setName(bwVar.bjV().getForumName());
            forum.setUser_level(bwVar.bjV().bhx());
            forum.setImage_url(bwVar.bjV().getAvatar());
            forum.setPost_num(bwVar.bjV().postNum);
            forum.setMember_num(bwVar.bjV().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(bwVar.getFid()));
            forum2.setName(bwVar.bil());
        }
        PostData postData = new PostData();
        postData.IY(1);
        postData.setTime(bwVar.getCreateTime());
        postData.a(bwVar.bih());
        MetaData bih = bwVar.bih();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(bih.getUserId(), bih);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bwVar.bhX(), false));
        fVar.d(postData);
        fVar.dcC().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.o(bwVar, null));
        fVar.kUF = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.lfE = bundle.getInt("key_start_from", 0);
        this.leE = bundle.getString("thread_id");
        this.leG = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.leF = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.leI = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.leJ = bundle.getBoolean("host_only", false);
        this.leL = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.leO = bundle.getInt("is_top", 0);
        this.leP = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.leW = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.kdT = bundle.getBoolean("is_sub_pb", false);
        this.leY = bundle.getBoolean("is_pv", false);
        this.leX = bundle.getLong("msg_id", 0L);
        this.leZ = bundle.getString("from_forum_name");
        this.lfg = bundle.getString("extra_pb_cache_key");
        this.lfa = bundle.getBoolean("is_from_thread_config", false);
        this.lfb = bundle.getBoolean("is_from_interview_live_config", false);
        this.lfc = bundle.getBoolean("is_from_my_god_config", false);
        this.lfi = bundle.getInt("extra_pb_is_attention_key", -1);
        this.lfh = bundle.getInt("extra_pb_funs_count_key", -1);
        this.esy = bundle.getBoolean("from_frs", false);
        this.leU = bundle.getBoolean("from_maintab", false);
        this.lft = bundle.getBoolean("from_smart_frs", false);
        this.lfd = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.leH = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.lfj = bundle.getInt("request_code", -1) == 18003;
        this.lfO = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.lfP = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.lfQ = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.lfR = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aC(Bundle bundle) {
        bundle.putString("thread_id", this.leE);
        bundle.putString("post_id", this.leG);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.lfE);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.leI);
        bundle.putBoolean("host_only", this.leJ);
        bundle.putBoolean("squence", this.leL);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.leO);
        bundle.putLong("thread_time", this.leP);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.leW);
        bundle.putBoolean("is_sub_pb", this.kdT);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.leY);
        bundle.putLong("msg_id", this.leX);
        bundle.putString("extra_pb_cache_key", this.lfg);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.lfa);
        bundle.putBoolean("is_from_interview_live_config", this.lfb);
        bundle.putBoolean("is_from_my_god_config", this.lfc);
        bundle.putInt("extra_pb_is_attention_key", this.lfi);
        bundle.putInt("extra_pb_funs_count_key", this.lfh);
        bundle.putBoolean("from_frs", this.esy);
        bundle.putBoolean("from_maintab", this.leU);
        bundle.putBoolean("from_smart_frs", this.lft);
        bundle.putBoolean("from_hottopic", this.lfd);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.leH);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.lfO);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.lfP);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.lfQ);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.lfR);
    }

    public String dfL() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.leE);
        if (!this.leW) {
            sb.append(this.leG);
        }
        sb.append(this.leJ);
        sb.append(this.leL);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.leO);
        sb.append(this.leP);
        sb.append(this.esy);
        sb.append(this.leU);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.kdT);
        sb.append(this.leY);
        sb.append(this.leX);
        sb.append(this.leZ);
        sb.append(this.mThreadType);
        sb.append(this.lfa);
        sb.append(this.lfb);
        sb.append(this.lfc);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.lfg != null) {
            sb.append(this.lfg);
        }
        return sb.toString();
    }

    public String ddH() {
        return this.leZ;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String dfM() {
        return this.leG;
    }

    public String dfN() {
        return this.leH;
    }

    public String dfO() {
        return this.leE;
    }

    public String dfP() {
        return (StringUtils.isNull(this.leE) || "0".equals(this.leE)) ? this.oriUgcNid : this.leE;
    }

    public boolean getHostMode() {
        return this.leJ;
    }

    public boolean dfQ() {
        return dgF();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean dfR() {
        return this.esy;
    }

    public boolean dfS() {
        return this.leN;
    }

    public boolean dfT() {
        return this.leU;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean dfU() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int clu() {
        return this.leO;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void Fo(int i) {
        this.leO = i;
    }

    public boolean dfV() {
        return this.kdT;
    }

    public boolean dfW() {
        if (this.kYp == null) {
            return false;
        }
        return this.kYp.isValid();
    }

    public String bip() {
        if (this.kYp == null || !this.kYp.bec()) {
            return null;
        }
        return this.kYp.beb();
    }

    public boolean Fp(int i) {
        this.leQ = i;
        if (this.leQ > this.kYp.getPage().bgS()) {
            this.leQ = this.kYp.getPage().bgS();
        }
        if (this.leQ < 1) {
            this.leQ = 1;
        }
        if (this.leE == null) {
            return false;
        }
        return Fr(5);
    }

    public void Fq(int i) {
        this.leQ = i;
        this.leR = i;
        this.leS = i;
    }

    public void b(com.baidu.tbadk.core.data.av avVar) {
        if (avVar == null) {
            Fq(1);
            return;
        }
        if (this.leR < avVar.bgV()) {
            this.leR = avVar.bgV();
        }
        if (this.leS > avVar.bgV()) {
            this.leS = avVar.bgV();
        }
        this.leT = avVar.bgS();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.kYp;
    }

    public BaijiahaoData dfX() {
        if (this.kYp == null || this.kYp.dcA() == null) {
            return null;
        }
        return this.kYp.dcA().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f dfY() {
        if (this.kYp == null) {
            return this.kYp;
        }
        if (!dfZ() && this.lfM != null) {
            this.kYp.b(this.lfM);
        }
        return this.kYp;
    }

    private boolean dfZ() {
        return (this.kYp.dcS() == null || this.kYp.dcS().dEd() == null || this.kYp.dcS().dEd().goods != null || this.kYp.dcS().dEd().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.av getPageData() {
        if (this.kYp == null) {
            return null;
        }
        return this.kYp.getPage();
    }

    public boolean dga() {
        if (dgF() && this.kYp.getPage().bgX() == 0) {
            tV(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.leE = fVar.getThreadId();
            if (fVar.dcA() != null && fVar.dcA().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.dcA().getBaijiahaoData();
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
            this.leG = null;
            this.leJ = false;
            this.leL = true;
            LoadData();
        }
    }

    public void OK(String str) {
        if (!StringUtils.isNull(str)) {
            this.leE = str;
            this.leG = null;
            this.leJ = false;
            this.leL = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.leE == null) {
            return false;
        }
        cancelLoadData();
        if (this.hUc == null) {
            this.hUc = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.hUc.start();
        }
        boolean Fr = Fr(3);
        if (this.opType != null) {
            this.opType = null;
            this.lff = null;
            this.opUrl = null;
            return Fr;
        }
        return Fr;
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
        if (this.lfB != null) {
            this.lfB.cancelLoadData();
        }
        if (this.lfC != null) {
            this.lfC.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dvA().dvE();
        cmS();
    }

    private void cmS() {
        if (this.hUc != null) {
            this.hUc.destory();
            this.hUc = null;
        }
    }

    public boolean dgb() {
        return (this.leG == null || this.leG.equals("0") || this.leG.length() == 0) ? LoadData() : dgf();
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
                this.lfB.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.lfB.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.lfC == null) {
                this.lfC = new GetSugMatchWordsModel(this.hSW.getPageContext());
            }
            this.lfC.b(aVar);
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
    public boolean Fr(int i) {
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
        Fs(i);
        final com.baidu.tieba.pb.data.f pbData = as.dhj().getPbData();
        if (pbData != null && pbData.dcA() != null) {
            pbData.dcA().nM(0);
            this.leL = as.dhj().dfQ();
            this.leJ = as.dhj().dho();
            this.leN = as.dhj().dhp();
            this.lfG = as.dhj().dhn();
            this.lfH = as.dhj().dhm();
            this.lfI = as.dhj().dhl();
            this.lfK = as.dhj().dhq();
            this.mTabIndex = as.dhj().getTabIndex();
            this.lfD = this.leJ;
            if (this.leJ || this.isFromMark) {
                this.lfj = false;
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
        if (i == 4 && !this.lfn) {
            a(dgk(), true, this.leG, 3);
        }
        if (i == 3 && !this.lfn) {
            if (this.isFromMark) {
                a(dgk(), true, this.leG, 3);
            } else {
                a(dgk(), false, this.leG, 3);
            }
        }
        this.lfn = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.lfM == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.eYm);
        if (this.leJ || this.isFromMark) {
            this.lfj = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.leE == null || this.leE.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.leE, 0L));
        if (com.baidu.tbadk.a.d.bdD()) {
            pbPageRequestMessage.setFloorSortType(1);
            pbPageRequestMessage.set_rn(15);
        } else {
            pbPageRequestMessage.set_rn(30);
        }
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.au.bmV().bmW() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.leL) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.leJ) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.leY) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.leX));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.lfj) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.lff, 0));
            pbPageRequestMessage.setOpMessageID(this.leX);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> dcC = this.kYp.dcC();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.leS - 1));
                        if (this.leS - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.leV) {
                                if (dcC != null && dcC.size() > 0) {
                                    size = dcC.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = dcC.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.leG = postData.getId();
                                            if (StringUtils.isNull(this.leG)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.leR + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.leG == null && this.leG.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.leG, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.leR + 1));
                        if (this.leR >= this.leT) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (dcC != null) {
                                size = dcC.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.leG == null) {
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
                if (dcC != null) {
                }
                if (this.leG == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (dcC != null && dcC.size() > 0 && dcC.get(0) != null) {
                    this.leG = dcC.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (dgF()) {
                        if (this.leS - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.leS - 1));
                        }
                    } else if (this.leR < this.leT) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.leR + 1));
                    }
                }
                if (this.leG != null && this.leG.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.leG, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.leJ) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (dgF()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.leT > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.leT));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.leG, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.leQ));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.lfD && !this.leJ) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.leG, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.leJ) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.lfr);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lfF, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.lfD = this.leJ;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(dgk());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.lfE));
        pbPageRequestMessage.setIsSubPostDataReverse(this.lfq);
        pbPageRequestMessage.setFromSmartFrs(this.lft ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.leI);
        if (this.lfE == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.lfS)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.lfS));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.leT) {
                    i4 = -1;
                } else {
                    i4 = dgM();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = dgM();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.leE);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean ddG() {
        switch (dgy()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().dcA() == null || !getPbData().dcA().bjE();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(ddH()) && com.baidu.tieba.recapp.r.duF().duz() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.duF().duz().aX(ddH(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.duF().duz().aY(ddH(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(ddH()) && com.baidu.tieba.recapp.r.duF().duz() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.duF().duz().aY(ddH(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.duF().duz().aX(ddH(), true));
        }
    }

    protected void Fs(int i) {
        boolean z = false;
        Fx(i);
        ArrayList<PostData> dcC = this.kYp.dcC();
        this.lfm = false;
        if (i == 1) {
            boolean z2 = false;
            while (dcC.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                dcC.remove(0);
                z2 = true;
            }
            if (z2) {
                this.kYp.getPage().nI(1);
                if (this.lfe != null) {
                    this.lfe.e(this.kYp);
                }
            }
            this.iKk = System.currentTimeMillis();
            this.lfm = true;
        } else if (i == 2) {
            while (dcC.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                dcC.remove(dcC.size() - 1);
                z = true;
            }
            if (z) {
                this.kYp.getPage().nH(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.lfu = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.lfM != null && this.lfM.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dcS() != null && fVar.dcS().dEd() != null && fVar.dcS().dEd().goods != null && fVar.dcS().isValidate() && fVar.dcS().dEd().goods.goods_style != 1001) {
            this.lfM = fVar.dcS();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n dgc() {
        return this.lfM;
    }

    public void dgd() {
        this.lfM = null;
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
            if (this.lfc || this.lfa || this.lfb) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.dcC().size(); i++) {
                PostData postData = fVar.dcC().get(i);
                for (int i2 = 0; i2 < postData.dEm().size(); i2++) {
                    postData.dEm().get(i2).a(this.hSW.getPageContext(), o.equals(postData.dEm().get(i2).bih().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r dcO = fVar.dcO();
            if (dcO != null && !com.baidu.tbadk.core.util.y.isEmpty(dcO.kWd)) {
                for (PostData postData2 : dcO.kWd) {
                    for (int i3 = 0; i3 < postData2.dEm().size(); i3++) {
                        postData2.dEm().get(i3).a(this.hSW.getPageContext(), o.equals(postData2.dEm().get(i3).bih().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r dcO = fVar.dcO();
            if (dcO != null && !com.baidu.tbadk.core.util.y.isEmpty(dcO.kWd)) {
                for (PostData postData : dcO.kWd.subList(i, dcO.kWd.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dEm().size()) {
                            postData.dEm().get(i3).a(this.hSW.getPageContext(), o.equals(postData.dEm().get(i3).bih().getUserId()));
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
        bw dcA = fVar.dcA();
        dcA.nR(this.mIsGood);
        dcA.nQ(this.leO);
        if (this.leP > 0) {
            dcA.cJ(this.leP);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.dcA() != null && fVar.dcA().bih() != null) {
            str = fVar.dcA().bih().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData dge() {
        if (this.kYp == null || this.kYp.dcA() == null || this.kYp.dcA().bih() == null) {
            return null;
        }
        return this.kYp.dcA().bih();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.lfs = z3;
        if (this.hUc != null && !z3) {
            this.hUc.a(z2, z4, i2, str, i3, j, j2);
            this.hUc = null;
        }
        if (this.kYp != null) {
            this.kYp.kVn = z3;
            this.kYp.YG = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(ddH()) && com.baidu.tieba.recapp.r.duF().duz() != null) {
            com.baidu.tieba.recapp.r.duF().duz().f(ddH(), Ft(dgn()), true);
        }
        if (fVar == null || (this.leQ == 1 && i == 5 && fVar.dcC() != null && fVar.dcC().size() < 1)) {
            if (this.lfe != null) {
                this.leL = this.leK;
                if (i2 != 350006) {
                    this.mSortType = this.leM;
                }
                this.lfe.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.leK = this.leL;
            if (i != 8) {
                this.leM = this.mSortType;
                this.mSortType = fVar.kUz;
            }
            if (fVar.kUy != null && fVar.kUy.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.hSW.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.kUy = new ArrayList();
                fVar.kUy.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.hSW.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.kUy.add(builder2.build(false));
                this.mSortType = this.leM;
                fVar.kUz = this.mSortType;
            }
            this.leY = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.leT = this.leT < 1 ? 1 : this.leT;
            int i6 = 0;
            ArrayList<PostData> dcC = this.kYp.dcC();
            switch (i) {
                case 1:
                    this.kYp.a(fVar.getPage(), 1);
                    d(fVar, dcC);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.dcC() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.dcC().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dcC, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dcC(), com.baidu.tbadk.core.util.y.getCount(fVar.dcC()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.dcC().remove(postData2);
                            i5 = size2 - 1;
                        }
                        dcC.addAll(0, fVar.dcC());
                    }
                    p(fVar);
                    this.kYp.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().nF(fVar.getPage().bgS());
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
                    if (fVar != null && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dcC()) && this.kYp != null && (!this.leJ || o(fVar).equals(fVar.dcC().get(0).bih().getUserId()))) {
                        if (this.kYp.getPage().bgX() == 0) {
                            this.kYp.getPage().nH(1);
                        }
                        dgz();
                        this.lfG = fVar.dcC().get(0);
                        if (dgF() || this.kYp.ddd()) {
                            if (this.kYp.dcC().size() - this.lfI >= 3) {
                                this.lfH = new PostData();
                                this.lfH.mEH = true;
                                this.lfH.setPostType(53);
                                this.kYp.dcC().add(this.lfH);
                            }
                            this.kYp.dcC().add(this.lfG);
                            size = this.kYp.dcC().size() - 1;
                        } else {
                            if (this.lfI - this.lfJ >= 3) {
                                this.lfH = new PostData();
                                this.lfH.mEH = false;
                                this.lfH.setPostType(53);
                                this.kYp.dcC().add(0, this.lfH);
                            }
                            this.kYp.dcC().add(0, this.lfG);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.at.isTaday(com.baidu.tbadk.core.sharedPref.b.blO().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.lfG.mEU = this.kYp.ddb();
                            com.baidu.tbadk.core.sharedPref.b.blO().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.kYp != null && this.kYp.dcA() != null) {
                PraiseData bhS = this.kYp.dcA().bhS();
                if (this.lfW != null && !bhS.isPriaseDataValid()) {
                    this.kYp.dcA().a(this.lfW);
                } else {
                    this.lfW = this.kYp.dcA().bhS();
                    this.lfW.setPostId(this.kYp.dcA().biy());
                }
                if (fVar.getPage() != null && fVar.getPage().bgV() == 1 && fVar.dcA() != null && fVar.dcA().bir() != null && fVar.dcA().bir().size() > 0) {
                    this.kYp.dcA().E(fVar.dcA().bir());
                }
                this.kYp.dcA().nO(fVar.dcA().bhY());
                this.kYp.dcA().nL(fVar.dcA().getAnchorLevel());
                this.kYp.dcA().nM(fVar.dcA().bhO());
                if (this.mThreadType == 33) {
                    this.kYp.dcA().bih().setHadConcerned(fVar.dcA().bih().hadConcerned());
                }
                if (fVar != null && fVar.dcA() != null) {
                    this.kYp.dcA().nT(fVar.dcA().biv());
                }
            }
            if (this.kYp != null && this.kYp.getUserData() != null && fVar.getUserData() != null) {
                this.kYp.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.kYp.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().bgV() == 1 && fVar.dcN() != null) {
                this.kYp.f(fVar.dcN());
            }
            if (this.lfs) {
                if (this.kYp.dcA() != null && this.kYp.dcA().bih() != null && this.kYp.dcC() != null && com.baidu.tbadk.core.util.y.getItem(this.kYp.dcC(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(this.kYp.dcC(), 0);
                    MetaData bih = this.kYp.dcA().bih();
                    if (postData3.bih() != null && postData3.bih().getGodUserData() != null) {
                        if (this.lfh != -1) {
                            bih.setFansNum(this.lfh);
                            postData3.bih().setFansNum(this.lfh);
                        }
                        if (this.lfi != -1) {
                            bih.getGodUserData().setIsLike(this.lfi == 1);
                            postData3.bih().getGodUserData().setIsLike(this.lfi == 1);
                            bih.getGodUserData().setIsFromNetWork(false);
                            postData3.bih().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.kYp.kUx = -1;
                this.kYp.kUw = -1;
            }
            if (this.lfe != null) {
                this.lfe.a(true, getErrorCode(), i, i4, this.kYp, this.mErrorString, 1);
            }
        }
        if (this.kYp != null && this.kYp.dcA() != null && this.kYp.getForum() != null && !this.kYp.ddd()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.hSW.getPageContext();
            historyMessage.threadId = getPbData().dcA().getId();
            if (this.mIsShareThread && getPbData().dcA().erY != null) {
                historyMessage.threadName = getPbData().dcA().erY.showText;
            } else {
                historyMessage.threadName = getPbData().dcA().getTitle();
            }
            if (this.mIsShareThread && !ddG()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = dfQ();
            historyMessage.threadType = getPbData().dcA().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.kYp != null) {
            this.kYp.dcR().clear();
            this.kYp.dcR().addAll(fVar.dcR());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aY;
        if (arrayList != null && fVar.dcC() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dcC(), 0);
            if (postData != null && (aY = aY(arrayList)) != null && aY.equals(postData.getId())) {
                fVar.dcC().remove(postData);
            }
            this.kYp.kVm = arrayList.size();
            arrayList.addAll(fVar.dcC());
        }
    }

    private int Ft(int i) {
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

    private String aY(ArrayList<PostData> arrayList) {
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
            fVar.OD(this.kYp.dcV());
            if (!this.kYp.kVk && fVar.kVk && this.kYp.dcK() != null) {
                fVar.e(this.kYp.dcK());
            }
            this.kYp = fVar;
            Fq(fVar.getPage().bgV());
        }
    }

    public boolean dgf() {
        if (this.leE == null || this.leG == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return Fr(4);
        }
        return Fr(6);
    }

    public boolean tV(boolean z) {
        if (this.leE == null || this.kYp == null) {
            return false;
        }
        if (z || this.kYp.getPage().bgX() != 0) {
            return Fr(1);
        }
        return false;
    }

    public boolean tW(boolean z) {
        if (this.leE == null || this.kYp == null) {
            return false;
        }
        if ((z || this.kYp.getPage().bgY() != 0) && this.kYp.dcC() != null && this.kYp.dcC().size() >= 1) {
            return Fr(2);
        }
        return false;
    }

    public boolean OQ(String str) {
        this.leJ = !this.leJ;
        this.leG = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").aj("obj_source", 0));
        if (Fr(6)) {
            return true;
        }
        this.leJ = this.leJ ? false : true;
        return false;
    }

    public boolean z(boolean z, String str) {
        if (this.leJ == z) {
            return false;
        }
        this.leJ = z;
        this.leG = str;
        if (this.mSortType == 2) {
            this.leG = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").aj("obj_source", 1));
        }
        if (Fr(6)) {
            return true;
        }
        this.leJ = z ? false : true;
        return false;
    }

    public boolean Fu(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_pb_current_sort_type", i);
        }
        this.leK = this.leL;
        this.leM = this.mSortType;
        this.mSortType = i;
        this.leL = !this.leL;
        if (i == 2 && this.isFromMark) {
            this.leG = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.leL = this.leL ? false : true;
            this.mSortType = this.leM;
            return false;
        }
        return true;
    }

    public boolean dgg() {
        return dgF();
    }

    public int dgh() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.kYp == null || this.kYp.getForum() == null || this.kYp.dcA() == null) ? false : true;
    }

    public boolean bec() {
        if (this.kYp == null) {
            return false;
        }
        return this.kYp.bec();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData Dd(String str) {
        if (this.kYp == null || this.kYp.dcA() == null || this.kYp.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.kYp.dcA().bjE()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.kYp.getForum().getId());
            writeData.setForumName(this.kYp.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.lfE);
        writeData.setThreadId(this.leE);
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

    public MarkData Fv(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.kYp == null) {
            return null;
        }
        ArrayList<PostData> dcC = this.kYp.dcC();
        if (com.baidu.tbadk.core.util.y.isEmpty(dcC)) {
            return null;
        }
        if (dcC.size() > 0 && i >= dcC.size()) {
            i = dcC.size() - 1;
        }
        return o(dcC.get(i));
    }

    public MarkData dgi() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.leE);
        markData.setPostId(this.kYp.beb());
        markData.setTime(date.getTime());
        markData.setHostMode(this.leJ);
        markData.setSequence(Boolean.valueOf(dgF()));
        markData.setId(this.leE);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.leE);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.leJ);
        markData.setSequence(Boolean.valueOf(dgF()));
        markData.setId(this.leE);
        markData.setFloor(postData.dEp());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) postData).isApp());
        }
        return markData;
    }

    public void dgj() {
        j.deu().aS(dgk(), this.isFromMark);
    }

    private String dgk() {
        String dgl = (this.leE == null || this.leE.equals("0")) ? dgl() : this.leE;
        if (this.leJ) {
            dgl = dgl + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            dgl = dgl + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            dgl = dgl + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return dgl + TbadkCoreApplication.getCurrentAccount();
        }
        return dgl;
    }

    private String dgl() {
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

    public void tX(boolean z) {
        if (this.kYp != null) {
            this.kYp.hU(z);
        }
    }

    public boolean dgm() {
        return this.lfj;
    }

    public void a(a aVar) {
        this.lfe = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bvH() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bvG() {
        return dgb();
    }

    public boolean OR(String str) {
        if (getPbData() == null || getPbData().dcA() == null || getPbData().dcA().bih() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().dcA().bih().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int dgn() {
        return this.mRequestType;
    }

    public void dgo() {
        if ("personalize_page".equals(this.mStType)) {
            this.lfp = System.currentTimeMillis() / 1000;
        }
    }

    public void dgp() {
        if ("personalize_page".equals(this.mStType) && this.kYp != null && this.lfp != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10754").dK("fid", this.kYp.getForumId()).dK("tid", this.leE).dK("obj_duration", String.valueOf(currentTimeMillis - this.lfp)).dK(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.lfp = 0L;
        }
    }

    public boolean dgq() {
        return this.lfs;
    }

    public int getErrorNo() {
        return this.lfu;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public q dgr() {
        return this.lfw;
    }

    public ai dgs() {
        return this.lfx;
    }

    public CheckRealNameModel dgt() {
        return this.lfz;
    }

    public AddExperiencedModel dgu() {
        return this.lfA;
    }

    public String dgv() {
        return this.lfo;
    }

    public void OS(String str) {
        this.lfo = str;
    }

    public boolean dgw() {
        return this.lft;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.kYp != null && this.kYp.dcC() != null && this.kYp.dcC().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.kYp.dcC().size();
                for (int i = 0; i < size; i++) {
                    if (this.kYp.dcC().get(i) != null && this.kYp.dcC().get(i).bih() != null && currentAccount.equals(this.kYp.dcC().get(i).bih().getUserId()) && this.kYp.dcC().get(i).bih().getPendantData() != null) {
                        this.kYp.dcC().get(i).bih().getPendantData().Aq(mVar.bgd());
                        this.kYp.dcC().get(i).bih().getPendantData().dh(mVar.buE());
                    }
                }
            }
        }
    }

    public String dgx() {
        return this.lfy;
    }

    public int dgy() {
        return this.lfE;
    }

    public void Fw(int i) {
        this.lfE = i;
    }

    public void OT(String str) {
        if ((!this.leJ || OR(TbadkCoreApplication.getCurrentAccount())) && this.kYp.dcC() != null) {
            this.kYp.getPage().nH(1);
            if (this.kYp.getPage().bgX() == 0) {
                this.kYp.getPage().nH(1);
            }
            this.lfF = str;
            Fr(8);
        }
    }

    private void Fx(int i) {
        if (i != 8) {
            this.lfF = "";
            if (this.lfG != null) {
                if (i == 1 && this.kYp != null && this.kYp.ddd()) {
                    if (this.lfH != null) {
                        getPbData().dcC().remove(this.lfH);
                    }
                } else if (i == 1 && !this.leL && !com.baidu.tbadk.core.util.y.isEmpty(getPbData().dcC())) {
                    getPbData().dcC().remove(this.lfG);
                    if (this.lfH != null) {
                        getPbData().dcC().remove(this.lfH);
                    }
                    getPbData().dcC().add(0, this.lfG);
                } else {
                    getPbData().dcC().remove(this.lfG);
                    if (this.lfH != null) {
                        getPbData().dcC().remove(this.lfH);
                    }
                }
            }
            this.lfH = null;
        }
    }

    public void dgz() {
        if (this.kYp != null && !com.baidu.tbadk.core.util.y.isEmpty(this.kYp.dcC())) {
            if (this.lfH != null) {
                this.kYp.dcC().remove(this.lfH);
                this.lfH = null;
            }
            if (this.lfG != null) {
                this.kYp.dcC().remove(this.lfG);
                this.lfG = null;
            }
        }
    }

    public void cX(int i, int i2) {
        this.lfI = i;
        this.lfJ = i2;
    }

    public PostData dgA() {
        return this.lfG;
    }

    public PostData dgB() {
        return this.lfH;
    }

    public int dgC() {
        return this.lfI;
    }

    public int dgD() {
        return this.lfJ;
    }

    public String dgE() {
        return this.lfL;
    }

    public void OU(String str) {
        this.lfL = str;
    }

    private boolean dgF() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean dgG() {
        return this.lfE == 13 || this.lfE == 12 || this.lfE == 7;
    }

    public String dgH() {
        return this.lfO;
    }

    public String dgI() {
        return this.lfP;
    }

    public String dgJ() {
        return this.lfQ;
    }

    public String dgK() {
        return this.lfR;
    }

    public Rect dgL() {
        Rect rect = this.lfK;
        this.lfK = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int dgM() {
        int i;
        int i2 = 0;
        if (getPbData().dcC() == null) {
            return 0;
        }
        ArrayList<PostData> dcC = getPbData().dcC();
        int size = dcC.size() - 1;
        while (size >= 0) {
            PostData postData = dcC.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
                if (postData.getType() != AdvertAppInfo.ekj) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return dcC.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
