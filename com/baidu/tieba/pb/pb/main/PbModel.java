package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bz;
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
/* loaded from: classes2.dex */
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
    private boolean eWD;
    private boolean eWc;
    private BaseFragmentActivity iJr;
    private com.baidu.tieba.tbadkCore.d.b iKw;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private long jDr;
    protected com.baidu.tieba.pb.data.f lKe;
    private boolean lQA;
    private boolean lQB;
    private boolean lQC;
    private int lQD;
    private boolean lQE;
    private int lQF;
    private long lQG;
    private int lQH;
    private int lQI;
    private int lQJ;
    private int lQK;
    private boolean lQL;
    private boolean lQM;
    private boolean lQN;
    private long lQO;
    private boolean lQP;
    private String lQQ;
    private boolean lQR;
    private boolean lQS;
    private boolean lQT;
    private boolean lQU;
    private a lQV;
    private String lQW;
    private String lQX;
    private int lQY;
    private int lQZ;
    protected String lQv;
    private String lQw;
    private String lQx;
    private String lQy;
    private boolean lQz;
    private int lRA;
    private Rect lRB;
    private String lRC;
    private com.baidu.tieba.tbadkCore.data.o lRD;
    private boolean lRE;
    private String lRF;
    private String lRG;
    private String lRH;
    private String lRI;
    private String lRJ;
    private boolean lRK;
    private f.a lRL;
    private CustomMessageListener lRM;
    private com.baidu.adp.framework.listener.a lRN;
    private PraiseData lRO;
    private boolean lRa;
    private boolean lRb;
    private boolean lRc;
    private boolean lRd;
    private boolean lRe;
    private String lRf;
    private long lRg;
    private boolean lRh;
    private int lRi;
    private boolean lRj;
    private boolean lRk;
    private int lRl;
    private final z lRm;
    private final n lRn;
    private final ab lRo;
    private String lRp;
    private final CheckRealNameModel lRq;
    private final AddExperiencedModel lRr;
    private SuggestEmotionModel lRs;
    private GetSugMatchWordsModel lRt;
    private boolean lRu;
    private int lRv;
    private String lRw;
    private PostData lRx;
    private PostData lRy;
    private int lRz;
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
    private static final int lQu = com.baidu.tbadk.data.e.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.f fVar);
    }

    public PbModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.mStType = null;
        this.lQv = null;
        this.isPrivacy = false;
        this.lQw = null;
        this.lQx = null;
        this.mForumId = null;
        this.lQy = null;
        this.lQz = false;
        this.lQA = false;
        this.lQB = true;
        this.lQC = true;
        this.mSortType = 0;
        this.lQD = 0;
        this.lQE = false;
        this.mIsGood = 0;
        this.lQF = 0;
        this.lQG = 0L;
        this.lQH = 1;
        this.lQI = 1;
        this.lQJ = 1;
        this.lQK = 1;
        this.isAd = false;
        this.eWD = false;
        this.eWc = false;
        this.lQL = false;
        this.isFromMark = false;
        this.lQM = false;
        this.lQN = false;
        this.lQO = 0L;
        this.lQP = false;
        this.lQQ = null;
        this.lKe = null;
        this.isLoading = false;
        this.lQR = false;
        this.lQS = false;
        this.lQT = false;
        this.lQU = false;
        this.mLocate = null;
        this.mContext = null;
        this.lQV = null;
        this.opType = null;
        this.opUrl = null;
        this.lQW = null;
        this.lQX = null;
        this.lQY = -1;
        this.lQZ = -1;
        this.iKw = null;
        this.lRb = false;
        this.lRc = false;
        this.postID = null;
        this.lRf = null;
        this.lRg = 0L;
        this.lRh = false;
        this.lRi = -1;
        this.lRk = false;
        this.lRu = false;
        this.lRv = 0;
        this.mTabIndex = 0;
        this.lRE = false;
        this.lRM = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.lRN = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.iJr.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.lRb || !PbModel.this.lRc) {
                        if (!PbModel.this.lRb) {
                            PbModel.this.lRb = true;
                        } else {
                            PbModel.this.lRc = true;
                        }
                        if (PbModel.this.lQV != null) {
                            PbModel.this.lQV.a(PbModel.this.dpS(), z, responsedMessage, PbModel.this.lRd, System.currentTimeMillis() - PbModel.this.jDr);
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
                    if (PbModel.this.lKe != null && PbModel.this.lKe.dmE() != null && PbModel.this.lKe.dmE().getForumId() != null && PbModel.this.lKe.dmE().getForumId().equals(valueOf)) {
                        PbModel.this.lKe.dmE().setIsLike(false);
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
                    if (PbModel.this.lKe != null && PbModel.this.lKe.dmE() != null && PbModel.this.lKe.dmE().getForumId() != null && PbModel.this.lKe.dmE().getForumId().equals(valueOf)) {
                        PbModel.this.lKe.dmE().setIsLike(true);
                    }
                }
            }
        };
        this.lRO = null;
        registerListener(this.lRN);
        registerListener(this.lRM);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.lKe = new com.baidu.tieba.pb.data.f();
        this.lKe.GH(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.iJr = baseFragmentActivity;
        this.lRm = new z(this, this.iJr);
        this.lRn = new n(this, this.iJr);
        this.lRo = new ab(this, this.iJr);
        this.lRq = new CheckRealNameModel(this.iJr.getPageContext());
        this.lRs = new SuggestEmotionModel();
        this.lRr = new AddExperiencedModel(this.iJr.getPageContext());
        this.lRL = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void onCallBack(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eGs) instanceof String) {
                        PbModel.this.lQv = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eGs);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eGt) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eGt);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eGu) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eGu);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eGv) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.eGv), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eGw) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eGw);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.lRe = true;
        if (fVar != null && fVar.lFS == null) {
            q(fVar);
            l(fVar);
            if (fVar.dmF() != null) {
                fVar.dmF().oL(0);
            }
            if (this.lQV != null && fVar != null) {
                this.lQV.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int dpS() {
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
            this.lQv = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.lRJ = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            this.lRK = false;
            if (com.baidu.tbadk.BdToken.f.r(uri)) {
                this.lRK = true;
                com.baidu.tbadk.BdToken.f.blo().c(uri, this.lRL);
            } else if (StringUtils.isNull(this.lQv)) {
                this.lRK = true;
                this.lRm.a(intent, this.lRL);
                if (uri != null) {
                    if (StringUtils.isNull(this.lQv)) {
                        this.lQv = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.at.isEmpty(this.lQv)) {
                this.lQv = "0";
            }
            this.lRv = intent.getIntExtra("key_start_from", 0);
            if (this.lRv == 0) {
                this.lRv = this.lRm.aMg;
            }
            this.lQx = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.lQw = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.lQz = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.lQA = intent.getBooleanExtra("host_only", false);
            this.lQC = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.lQx = this.mSortType == 2 ? "0" : this.lQx;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.lQF = intent.getIntExtra("is_top", 0);
            this.lQG = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.lQM = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.lQN = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.eWD = intent.getBooleanExtra("is_sub_pb", false);
            this.lQP = intent.getBooleanExtra("is_pv", false);
            this.lQO = intent.getLongExtra("msg_id", 0L);
            this.lQQ = intent.getStringExtra("from_forum_name");
            this.lQX = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.lQW = intent.getStringExtra("op_stat");
            this.lQR = intent.getBooleanExtra("is_from_thread_config", false);
            this.lQS = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.lQT = intent.getBooleanExtra("is_from_my_god_config", false);
            this.lQZ = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.lQY = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.eWc = intent.getBooleanExtra("from_frs", false);
            this.lQL = intent.getBooleanExtra("from_maintab", false);
            this.lRk = intent.getBooleanExtra("from_smart_frs", false);
            this.lQU = intent.getBooleanExtra("from_hottopic", false);
            this.lRp = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.lQy = intent.getStringExtra("high_light_post_id");
            this.lRE = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.lRa = intent.getIntExtra("request_code", -1) == 18003;
            this.lRF = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.lRG = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.lRH = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.lRI = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean dpT() {
        return this.lRE && com.baidu.tieba.frs.l.cEP() != null && com.baidu.tieba.frs.l.cEP().equals(this.lQv) && com.baidu.tieba.frs.l.cEO() != null;
    }

    public com.baidu.tieba.pb.data.f aL(bz bzVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.GH(3);
        if (bzVar == null) {
            return null;
        }
        fVar.aI(bzVar);
        if (bzVar.bti() != null) {
            fVar.d(bzVar.bti());
            ForumData forum = fVar.getForum();
            forum.setId(bzVar.bti().getForumId());
            forum.setName(bzVar.bti().getForumName());
            forum.setUser_level(bzVar.bti().bqH());
            forum.setImage_url(bzVar.bti().getAvatar());
            forum.setPost_num(bzVar.bti().postNum);
            forum.setMember_num(bzVar.bti().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(bzVar.getFid()));
            forum2.setName(bzVar.brv());
        }
        PostData postData = new PostData();
        postData.KR(1);
        postData.setTime(bzVar.getCreateTime());
        postData.a(bzVar.brr());
        MetaData brr = bzVar.brr();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(brr.getUserId(), brr);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bzVar.brh(), false));
        fVar.d(postData);
        fVar.dmH().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.o(bzVar, null));
        fVar.lFX = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.lRv = bundle.getInt("key_start_from", 0);
        this.lQv = bundle.getString("thread_id");
        this.lQx = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.lQw = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.lQz = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.lQA = bundle.getBoolean("host_only", false);
        this.lQC = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.lQF = bundle.getInt("is_top", 0);
        this.lQG = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.lQN = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eWD = bundle.getBoolean("is_sub_pb", false);
        this.lQP = bundle.getBoolean("is_pv", false);
        this.lQO = bundle.getLong("msg_id", 0L);
        this.lQQ = bundle.getString("from_forum_name");
        this.lQX = bundle.getString("extra_pb_cache_key");
        this.lQR = bundle.getBoolean("is_from_thread_config", false);
        this.lQS = bundle.getBoolean("is_from_interview_live_config", false);
        this.lQT = bundle.getBoolean("is_from_my_god_config", false);
        this.lQZ = bundle.getInt("extra_pb_is_attention_key", -1);
        this.lQY = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eWc = bundle.getBoolean("from_frs", false);
        this.lQL = bundle.getBoolean("from_maintab", false);
        this.lRk = bundle.getBoolean("from_smart_frs", false);
        this.lQU = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.lQy = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.lRa = bundle.getInt("request_code", -1) == 18003;
        this.lRF = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.lRG = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.lRH = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.lRI = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aD(Bundle bundle) {
        bundle.putString("thread_id", this.lQv);
        bundle.putString("post_id", this.lQx);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.lRv);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.lQz);
        bundle.putBoolean("host_only", this.lQA);
        bundle.putBoolean("squence", this.lQC);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.lQF);
        bundle.putLong("thread_time", this.lQG);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.lQN);
        bundle.putBoolean("is_sub_pb", this.eWD);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.lQP);
        bundle.putLong("msg_id", this.lQO);
        bundle.putString("extra_pb_cache_key", this.lQX);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.lQR);
        bundle.putBoolean("is_from_interview_live_config", this.lQS);
        bundle.putBoolean("is_from_my_god_config", this.lQT);
        bundle.putInt("extra_pb_is_attention_key", this.lQZ);
        bundle.putInt("extra_pb_funs_count_key", this.lQY);
        bundle.putBoolean("from_frs", this.eWc);
        bundle.putBoolean("from_maintab", this.lQL);
        bundle.putBoolean("from_smart_frs", this.lRk);
        bundle.putBoolean("from_hottopic", this.lQU);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.lQy);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.lRF);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.lRG);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.lRH);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.lRI);
    }

    public String dpU() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.lQv);
        if (!this.lQN) {
            sb.append(this.lQx);
        }
        sb.append(this.lQA);
        sb.append(this.lQC);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.lQF);
        sb.append(this.lQG);
        sb.append(this.eWc);
        sb.append(this.lQL);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eWD);
        sb.append(this.lQP);
        sb.append(this.lQO);
        sb.append(this.lQQ);
        sb.append(this.mThreadType);
        sb.append(this.lQR);
        sb.append(this.lQS);
        sb.append(this.lQT);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.lQX != null) {
            sb.append(this.lQX);
        }
        return sb.toString();
    }

    public String dnP() {
        return this.lQQ;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String dpV() {
        return this.lQx;
    }

    public String dpW() {
        return this.lQy;
    }

    public String dpX() {
        return this.lQv;
    }

    public String dpY() {
        return (StringUtils.isNull(this.lQv) || "0".equals(this.lQv)) ? this.oriUgcNid : this.lQv;
    }

    public boolean getHostMode() {
        return this.lQA;
    }

    public boolean dpZ() {
        return dqP();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean dqa() {
        return this.eWc;
    }

    public boolean dqb() {
        return this.lQE;
    }

    public boolean dqc() {
        return this.lQL;
    }

    public boolean dqd() {
        return this.lQU;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean dqe() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int cxO() {
        return this.lQF;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void Hb(int i) {
        this.lQF = i;
    }

    public boolean dqf() {
        return this.eWD;
    }

    public boolean dqg() {
        if (this.lKe == null) {
            return false;
        }
        return this.lKe.isValid();
    }

    public String brz() {
        if (this.lKe == null || !this.lKe.bny()) {
            return null;
        }
        return this.lKe.bnx();
    }

    public boolean Hc(int i) {
        this.lQH = i;
        if (this.lQH > this.lKe.getPage().bqb()) {
            this.lQH = this.lKe.getPage().bqb();
        }
        if (this.lQH < 1) {
            this.lQH = 1;
        }
        if (this.lQv == null) {
            return false;
        }
        return He(5);
    }

    public void Hd(int i) {
        this.lQH = i;
        this.lQI = i;
        this.lQJ = i;
    }

    public void b(ax axVar) {
        if (axVar == null) {
            Hd(1);
            return;
        }
        if (this.lQI < axVar.bqe()) {
            this.lQI = axVar.bqe();
        }
        if (this.lQJ > axVar.bqe()) {
            this.lQJ = axVar.bqe();
        }
        this.lQK = axVar.bqb();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.lKe;
    }

    public BaijiahaoData dqh() {
        if (this.lKe == null || this.lKe.dmF() == null) {
            return null;
        }
        return this.lKe.dmF().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f dqi() {
        if (this.lKe == null) {
            return this.lKe;
        }
        if (!dqj() && this.lRD != null) {
            this.lKe.b(this.lRD);
        }
        return this.lKe;
    }

    private boolean dqj() {
        return (this.lKe.dmX() == null || this.lKe.dmX().dOS() == null || this.lKe.dmX().dOS().goods != null || this.lKe.dmX().dOS().goods.goods_style == 1001) ? false : true;
    }

    public ax getPageData() {
        if (this.lKe == null) {
            return null;
        }
        return this.lKe.getPage();
    }

    public boolean dqk() {
        if (dqP() && this.lKe.getPage().bqg() == 0) {
            vb(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.lQv = fVar.getThreadId();
            if (fVar.dmF() != null && fVar.dmF().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.dmF().getBaijiahaoData();
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
            this.lQx = null;
            this.lQA = false;
            this.lQC = true;
            LoadData();
        }
    }

    public void PI(String str) {
        if (!StringUtils.isNull(str)) {
            this.lQv = str;
            this.lQx = null;
            this.lQA = false;
            this.lQC = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lQv == null) {
            return false;
        }
        cancelLoadData();
        if (this.iKw == null) {
            this.iKw = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.iKw.start();
        }
        boolean He = He(3);
        if (this.opType != null) {
            this.opType = null;
            this.lQW = null;
            this.opUrl = null;
            return He;
        }
        return He;
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
        if (this.lRs != null) {
            this.lRs.cancelLoadData();
        }
        if (this.lRt != null) {
            this.lRt.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dFV().RU("PB");
        czn();
    }

    private void czn() {
        if (this.iKw != null) {
            this.iKw.destory();
            this.iKw = null;
        }
    }

    public boolean dql() {
        return (this.lQx == null || this.lQx.equals("0") || this.lQx.length() == 0) ? LoadData() : dqp();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        String str = "";
        String str2 = "";
        if (forumData != null) {
            if (!TextUtils.isEmpty(forumData.getId())) {
                str = forumData.getId();
            }
            if (!TextUtils.isEmpty(forumData.getName())) {
                str2 = forumData.getName();
            }
        }
        this.lRs.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.lRt == null) {
                this.lRt = new GetSugMatchWordsModel(this.iJr.getPageContext());
            }
            this.lRt.b(aVar);
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
    public boolean He(int i) {
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
        Hf(i);
        final com.baidu.tieba.pb.data.f pbData = aj.drw().getPbData();
        if (pbData != null && pbData.dmF() != null) {
            pbData.dmF().oL(0);
            this.lQC = aj.drw().dpZ();
            this.lQA = aj.drw().drB();
            this.lQE = aj.drw().drC();
            this.lRx = aj.drw().drA();
            this.lRy = aj.drw().drz();
            this.lRz = aj.drw().dry();
            this.lRB = aj.drw().drD();
            this.mTabIndex = aj.drw().dqW();
            this.lRu = this.lQA;
            if (this.lQA || this.isFromMark) {
                this.lRa = false;
            }
            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.lRe) {
            a(dqu(), true, this.lQx, 3);
        }
        if (i == 3 && !this.lRe) {
            if (this.isFromMark) {
                a(dqu(), true, this.lQx, 3);
            } else {
                a(dqu(), false, this.lQx, 3);
            }
        }
        this.lRe = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.lRD == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.fCT);
        if (this.lQA || this.isFromMark) {
            this.lRa = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.lQv == null || this.lQv.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.lQv, 0L));
        if (com.baidu.tbadk.a.d.bmH()) {
            pbPageRequestMessage.setFloorSortType(1);
            pbPageRequestMessage.setFloor_rn(com.baidu.tbadk.a.d.bmQ());
            pbPageRequestMessage.set_rn(15);
        } else {
            pbPageRequestMessage.set_rn(30);
        }
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.au.bws().bwt() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.lQC) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.lQA) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.lQP) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.lQO));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.lRa) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.lQW, 0));
            pbPageRequestMessage.setOpMessageID(this.lQO);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> dmH = this.lKe.dmH();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lQJ - 1));
                        if (this.lQJ - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.lQM) {
                                if (dmH != null && dmH.size() > 0) {
                                    size = dmH.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = dmH.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.lQx = postData.getId();
                                            if (StringUtils.isNull(this.lQx)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.lQI + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.lQx == null && this.lQx.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lQx, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lQI + 1));
                        if (this.lQI >= this.lQK) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (dmH != null) {
                                size = dmH.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.lQx == null) {
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
                if (dmH != null) {
                }
                if (this.lQx == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (dmH != null && dmH.size() > 0 && dmH.get(0) != null) {
                    this.lQx = dmH.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (dqP()) {
                        if (this.lQJ - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.lQJ - 1));
                        }
                    } else if (this.lQI < this.lQK) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lQI + 1));
                    }
                }
                if (this.lQx != null && this.lQx.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lQx, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.lQA) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (dqP()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.lQK > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lQK));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lQx, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.lQH));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.lRu && !this.lQA) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lQx, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.lQA) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.lRi);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lRw, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.lRu = this.lQA;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(dqu());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.lRv));
        pbPageRequestMessage.setIsSubPostDataReverse(this.lRh);
        pbPageRequestMessage.setFromSmartFrs(this.lRk ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.lQz);
        if (this.lRv == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        if (this.lRv == 7 || this.lRv == 5 || this.lRK) {
            pbPageRequestMessage.setSourceType(1);
        } else {
            pbPageRequestMessage.setSourceType(2);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.lRJ)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.lRJ));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.lQK) {
                    i4 = -1;
                } else {
                    i4 = dqX();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = dqX();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.lQv);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean dnO() {
        switch (dqI()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().dmF() == null || !getPbData().dmF().bsR();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dnP()) && com.baidu.tieba.recapp.r.dEW().dEQ() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dEW().dEQ().ba(dnP(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dEW().dEQ().bb(dnP(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dnP()) && com.baidu.tieba.recapp.r.dEW().dEQ() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dEW().dEQ().bb(dnP(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dEW().dEQ().ba(dnP(), true));
        }
    }

    protected void Hf(int i) {
        boolean z = false;
        Hk(i);
        ArrayList<PostData> dmH = this.lKe.dmH();
        this.lRd = false;
        if (i == 1) {
            boolean z2 = false;
            while (dmH.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dmH.remove(0);
                z2 = true;
            }
            if (z2) {
                this.lKe.getPage().oH(1);
                if (this.lQV != null) {
                    this.lQV.e(this.lKe);
                }
            }
            this.jDr = System.currentTimeMillis();
            this.lRd = true;
        } else if (i == 2) {
            while (dmH.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dmH.remove(dmH.size() - 1);
                z = true;
            }
            if (z) {
                this.lKe.getPage().oG(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.lRl = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.lRD != null && this.lRD.bPN()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmX() != null && fVar.dmX().dOS() != null && fVar.dmX().dOS().goods != null && fVar.dmX().bPN() && fVar.dmX().dOS().goods.goods_style != 1001) {
            this.lRD = fVar.dmX();
        }
    }

    public com.baidu.tieba.tbadkCore.data.o dqm() {
        return this.lRD;
    }

    public void dqn() {
        this.lRD = null;
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
            if (this.lQT || this.lQR || this.lQS) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.dmH().size(); i++) {
                PostData postData = fVar.dmH().get(i);
                for (int i2 = 0; i2 < postData.dPb().size(); i2++) {
                    postData.dPb().get(i2).a(this.iJr.getPageContext(), o.equals(postData.dPb().get(i2).brr().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r dmT = fVar.dmT();
            if (dmT != null && !com.baidu.tbadk.core.util.x.isEmpty(dmT.lHx)) {
                for (PostData postData2 : dmT.lHx) {
                    for (int i3 = 0; i3 < postData2.dPb().size(); i3++) {
                        postData2.dPb().get(i3).a(this.iJr.getPageContext(), o.equals(postData2.dPb().get(i3).brr().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r dmT = fVar.dmT();
            if (dmT != null && !com.baidu.tbadk.core.util.x.isEmpty(dmT.lHx)) {
                for (PostData postData : dmT.lHx.subList(i, dmT.lHx.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dPb().size()) {
                            postData.dPb().get(i3).a(this.iJr.getPageContext(), o.equals(postData.dPb().get(i3).brr().getUserId()));
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
        bz dmF = fVar.dmF();
        dmF.oQ(this.mIsGood);
        dmF.oP(this.lQF);
        if (this.lQG > 0) {
            dmF.dG(this.lQG);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.dmF() != null && fVar.dmF().brr() != null) {
            str = fVar.dmF().brr().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData dqo() {
        if (this.lKe == null || this.lKe.dmF() == null || this.lKe.dmF().brr() == null) {
            return null;
        }
        return this.lKe.dmF().brr();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.lRj = z3;
        if (this.iKw != null && !z3) {
            this.iKw.a(z2, z4, i2, str, i3, j, j2);
            this.iKw = null;
        }
        if (this.lKe != null) {
            this.lKe.lGF = z3;
            this.lKe.aas = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(dnP()) && com.baidu.tieba.recapp.r.dEW().dEQ() != null) {
            com.baidu.tieba.recapp.r.dEW().dEQ().f(dnP(), Hg(dqx()), true);
        }
        if (fVar == null || (this.lQH == 1 && i == 5 && fVar.dmH() != null && fVar.dmH().size() < 1)) {
            if (this.lQV != null) {
                this.lQC = this.lQB;
                if (i2 != 350006) {
                    this.mSortType = this.lQD;
                }
                this.lQV.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.lQB = this.lQC;
            if (i != 8) {
                this.lQD = this.mSortType;
                this.mSortType = fVar.lFR;
            }
            if (fVar.lFQ != null && fVar.lFQ.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.iJr.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.lFQ = new ArrayList();
                fVar.lFQ.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.iJr.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.lFQ.add(builder2.build(false));
                this.mSortType = this.lQD;
                fVar.lFR = this.mSortType;
            }
            this.lQP = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.lQK = this.lQK < 1 ? 1 : this.lQK;
            int i6 = 0;
            ArrayList<PostData> dmH = this.lKe.dmH();
            switch (i) {
                case 1:
                    this.lKe.a(fVar.getPage(), 1);
                    d(fVar, dmH);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.dmH() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.dmH().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(dmH, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.getItem(fVar.dmH(), com.baidu.tbadk.core.util.x.getCount(fVar.dmH()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.dmH().remove(postData2);
                            i5 = size2 - 1;
                        }
                        dmH.addAll(0, fVar.dmH());
                    }
                    p(fVar);
                    this.lKe.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().oE(fVar.getPage().bqb());
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
                    if (fVar != null && !com.baidu.tbadk.core.util.x.isEmpty(fVar.dmH()) && this.lKe != null && (!this.lQA || o(fVar).equals(fVar.dmH().get(0).brr().getUserId()))) {
                        if (this.lKe.getPage().bqg() == 0) {
                            this.lKe.getPage().oG(1);
                        }
                        dqJ();
                        this.lRx = fVar.dmH().get(0);
                        if (dqP() || this.lKe.dni()) {
                            if (this.lKe.dmH().size() - this.lRz >= 3) {
                                this.lRy = new PostData();
                                this.lRy.nrU = true;
                                this.lRy.setPostType(53);
                                this.lKe.dmH().add(this.lRy);
                            }
                            this.lKe.dmH().add(this.lRx);
                            size = this.lKe.dmH().size() - 1;
                        } else {
                            if (this.lRz - this.lRA >= 3) {
                                this.lRy = new PostData();
                                this.lRy.nrU = false;
                                this.lRy.setPostType(53);
                                this.lKe.dmH().add(0, this.lRy);
                            }
                            this.lKe.dmH().add(0, this.lRx);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.at.isTaday(com.baidu.tbadk.core.sharedPref.b.bvr().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.lRx.nsh = this.lKe.dng();
                            com.baidu.tbadk.core.sharedPref.b.bvr().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.lKe != null && this.lKe.dmF() != null) {
                PraiseData brc = this.lKe.dmF().brc();
                if (this.lRO != null && !brc.isPriaseDataValid()) {
                    this.lKe.dmF().a(this.lRO);
                } else {
                    this.lRO = this.lKe.dmF().brc();
                    this.lRO.setPostId(this.lKe.dmF().brH());
                }
                if (fVar.getPage() != null && fVar.getPage().bqe() == 1 && fVar.dmF() != null && fVar.dmF().brB() != null && fVar.dmF().brB().size() > 0) {
                    this.lKe.dmF().E(fVar.dmF().brB());
                }
                this.lKe.dmF().oN(fVar.dmF().bri());
                this.lKe.dmF().oK(fVar.dmF().getAnchorLevel());
                this.lKe.dmF().oL(fVar.dmF().bqY());
                if (this.mThreadType == 33) {
                    this.lKe.dmF().brr().setHadConcerned(fVar.dmF().brr().hadConcerned());
                }
                if (fVar != null && fVar.dmF() != null) {
                    this.lKe.dmF().oS(fVar.dmF().brF());
                }
            }
            if (this.lKe != null && this.lKe.getUserData() != null && fVar.getUserData() != null) {
                this.lKe.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.lKe.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().bqe() == 1 && fVar.dmS() != null) {
                this.lKe.f(fVar.dmS());
            }
            if (this.lRj) {
                if (this.lKe.dmF() != null && this.lKe.dmF().brr() != null && this.lKe.dmH() != null && com.baidu.tbadk.core.util.x.getItem(this.lKe.dmH(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.getItem(this.lKe.dmH(), 0);
                    MetaData brr = this.lKe.dmF().brr();
                    if (postData3.brr() != null && postData3.brr().getGodUserData() != null) {
                        if (this.lQY != -1) {
                            brr.setFansNum(this.lQY);
                            postData3.brr().setFansNum(this.lQY);
                        }
                        if (this.lQZ != -1) {
                            brr.getGodUserData().setIsLike(this.lQZ == 1);
                            postData3.brr().getGodUserData().setIsLike(this.lQZ == 1);
                            brr.getGodUserData().setIsFromNetWork(false);
                            postData3.brr().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.lKe.lFP = -1;
                this.lKe.lFO = -1;
            }
            if (this.lQV != null) {
                this.lQV.a(true, getErrorCode(), i, i4, this.lKe, this.mErrorString, 1);
            }
        }
        if (this.lKe != null && this.lKe.dmF() != null && this.lKe.getForum() != null && !this.lKe.dni()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.iJr.getPageContext();
            historyMessage.threadId = getPbData().dmF().getId();
            if (this.mIsShareThread && getPbData().dmF().eVB != null) {
                historyMessage.threadName = getPbData().dmF().eVB.showText;
            } else {
                historyMessage.threadName = getPbData().dmF().getTitle();
            }
            if (this.mIsShareThread && !dnO()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = dpZ();
            historyMessage.threadType = getPbData().dmF().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.lKe != null) {
            this.lKe.dmW().clear();
            this.lKe.dmW().addAll(fVar.dmW());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String be;
        if (arrayList != null && fVar.dmH() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(fVar.dmH(), 0);
            if (postData != null && (be = be(arrayList)) != null && be.equals(postData.getId())) {
                fVar.dmH().remove(postData);
            }
            this.lKe.lGE = arrayList.size();
            arrayList.addAll(fVar.dmH());
        }
    }

    private int Hg(int i) {
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
            fVar.PB(this.lKe.dna());
            if (!this.lKe.lGC && fVar.lGC && this.lKe.dmP() != null) {
                fVar.e(this.lKe.dmP());
            }
            this.lKe = fVar;
            Hd(fVar.getPage().bqe());
        }
    }

    public boolean dqp() {
        if (this.lQv == null || this.lQx == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return He(4);
        }
        return He(6);
    }

    public boolean vb(boolean z) {
        if (this.lQv == null || this.lKe == null) {
            return false;
        }
        if (z || this.lKe.getPage().bqg() != 0) {
            return He(1);
        }
        return false;
    }

    public boolean vc(boolean z) {
        if (this.lQv == null || this.lKe == null) {
            return false;
        }
        if ((z || this.lKe.getPage().bqh() != 0) && this.lKe.dmH() != null && this.lKe.dmH().size() >= 1) {
            return He(2);
        }
        return false;
    }

    public boolean PO(String str) {
        this.lQA = !this.lQA;
        this.lQx = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").an("obj_source", 0));
        if (He(6)) {
            return true;
        }
        this.lQA = this.lQA ? false : true;
        return false;
    }

    public boolean C(boolean z, String str) {
        if (this.lQA == z) {
            return false;
        }
        this.lQA = z;
        this.lQx = str;
        if (this.mSortType == 2) {
            this.lQx = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").an("obj_source", 1));
        }
        if (He(6)) {
            return true;
        }
        this.lQA = z ? false : true;
        return false;
    }

    public boolean Hh(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.bvr().putInt("key_pb_current_sort_type", i);
        }
        this.lQB = this.lQC;
        this.lQD = this.mSortType;
        this.mSortType = i;
        this.lQC = !this.lQC;
        if (i == 2 && this.isFromMark) {
            this.lQx = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.lQC = this.lQC ? false : true;
            this.mSortType = this.lQD;
            return false;
        }
        return true;
    }

    public boolean dqq() {
        return dqP();
    }

    public int dqr() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.lKe == null || this.lKe.getForum() == null || this.lKe.dmF() == null) ? false : true;
    }

    public boolean bny() {
        if (this.lKe == null) {
            return false;
        }
        return this.lKe.bny();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DN(String str) {
        if (this.lKe == null || this.lKe.dmF() == null || this.lKe.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.lKe.dmF().bsR()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.lKe.getForum().getId());
            writeData.setForumName(this.lKe.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.lRv);
        writeData.setThreadId(this.lQv);
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

    public MarkData Hi(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.lKe == null) {
            return null;
        }
        ArrayList<PostData> dmH = this.lKe.dmH();
        if (com.baidu.tbadk.core.util.x.isEmpty(dmH)) {
            return null;
        }
        if (dmH.size() > 0 && i >= dmH.size()) {
            i = dmH.size() - 1;
        }
        return o(dmH.get(i));
    }

    public MarkData dqs() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lQv);
        markData.setPostId(this.lKe.bnx());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lQA);
        markData.setSequence(Boolean.valueOf(dqP()));
        markData.setId(this.lQv);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lQv);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lQA);
        markData.setSequence(Boolean.valueOf(dqP()));
        markData.setId(this.lQv);
        markData.setFloor(postData.dPe());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.o) postData).isApp());
        }
        return markData;
    }

    public void dqt() {
        i.doC().aV(dqu(), this.isFromMark);
    }

    private String dqu() {
        String dqv = (this.lQv == null || this.lQv.equals("0")) ? dqv() : this.lQv;
        if (this.lQA) {
            dqv = dqv + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            dqv = dqv + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            dqv = dqv + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return dqv + TbadkCoreApplication.getCurrentAccount();
        }
        return dqv;
    }

    private String dqv() {
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

    public void vd(boolean z) {
        if (this.lKe != null) {
            this.lKe.jc(z);
        }
    }

    public boolean dqw() {
        return this.lRa;
    }

    public void a(a aVar) {
        this.lQV = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bFl() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bFk() {
        return dql();
    }

    public boolean PP(String str) {
        if (getPbData() == null || getPbData().dmF() == null || getPbData().dmF().brr() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().dmF().brr().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int dqx() {
        return this.mRequestType;
    }

    public void dqy() {
        if ("personalize_page".equals(this.mStType)) {
            this.lRg = System.currentTimeMillis() / 1000;
        }
    }

    public void dqz() {
        if ("personalize_page".equals(this.mStType) && this.lKe != null && this.lRg != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10754").dX("fid", this.lKe.getForumId()).dX("tid", this.lQv).dX("obj_duration", String.valueOf(currentTimeMillis - this.lRg)).dX(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.lRg = 0L;
        }
    }

    public boolean dqA() {
        return this.lRj;
    }

    public int getErrorNo() {
        return this.lRl;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public n dqB() {
        return this.lRn;
    }

    public ab dqC() {
        return this.lRo;
    }

    public CheckRealNameModel dqD() {
        return this.lRq;
    }

    public AddExperiencedModel dqE() {
        return this.lRr;
    }

    public String dqF() {
        return this.lRf;
    }

    public void PQ(String str) {
        this.lRf = str;
    }

    public boolean dqG() {
        return this.lRk;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lKe != null && this.lKe.dmH() != null && this.lKe.dmH().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lKe.dmH().size();
                for (int i = 0; i < size; i++) {
                    if (this.lKe.dmH().get(i) != null && this.lKe.dmH().get(i).brr() != null && currentAccount.equals(this.lKe.dmH().get(i).brr().getUserId()) && this.lKe.dmH().get(i).brr().getPendantData() != null) {
                        this.lKe.dmH().get(i).brr().getPendantData().AX(nVar.getImgUrl());
                        this.lKe.dmH().get(i).brr().getPendantData().ee(nVar.bEi());
                    }
                }
            }
        }
    }

    public String dqH() {
        return this.lRp;
    }

    public int dqI() {
        return this.lRv;
    }

    public void Hj(int i) {
        this.lRv = i;
    }

    public void PR(String str) {
        if ((!this.lQA || PP(TbadkCoreApplication.getCurrentAccount())) && this.lKe.dmH() != null) {
            this.lKe.getPage().oG(1);
            if (this.lKe.getPage().bqg() == 0) {
                this.lKe.getPage().oG(1);
            }
            this.lRw = str;
            He(8);
        }
    }

    private void Hk(int i) {
        if (i != 8) {
            this.lRw = "";
            if (this.lRx != null) {
                if (i == 1 && this.lKe != null && this.lKe.dni()) {
                    if (this.lRy != null) {
                        getPbData().dmH().remove(this.lRy);
                    }
                } else if (i == 1 && !this.lQC && !com.baidu.tbadk.core.util.x.isEmpty(getPbData().dmH())) {
                    getPbData().dmH().remove(this.lRx);
                    if (this.lRy != null) {
                        getPbData().dmH().remove(this.lRy);
                    }
                    getPbData().dmH().add(0, this.lRx);
                } else {
                    getPbData().dmH().remove(this.lRx);
                    if (this.lRy != null) {
                        getPbData().dmH().remove(this.lRy);
                    }
                }
            }
            this.lRy = null;
        }
    }

    public void dqJ() {
        if (this.lKe != null && !com.baidu.tbadk.core.util.x.isEmpty(this.lKe.dmH())) {
            if (this.lRy != null) {
                this.lKe.dmH().remove(this.lRy);
                this.lRy = null;
            }
            if (this.lRx != null) {
                this.lKe.dmH().remove(this.lRx);
                this.lRx = null;
            }
        }
    }

    public void dc(int i, int i2) {
        this.lRz = i;
        this.lRA = i2;
    }

    public PostData dqK() {
        return this.lRx;
    }

    public PostData dqL() {
        return this.lRy;
    }

    public int dqM() {
        return this.lRz;
    }

    public int dqN() {
        return this.lRA;
    }

    public String dqO() {
        return this.lRC;
    }

    public void PS(String str) {
        this.lRC = str;
    }

    private boolean dqP() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean dqQ() {
        return this.lRv == 13 || this.lRv == 12 || this.lRv == 7 || this.lRv == 23;
    }

    public String dqR() {
        return this.lRF;
    }

    public String dqS() {
        return this.lRG;
    }

    public String dqT() {
        return this.lRH;
    }

    public String dqU() {
        return this.lRI;
    }

    public Rect dqV() {
        Rect rect = this.lRB;
        this.lRB = null;
        return rect;
    }

    public int dqW() {
        return this.mTabIndex;
    }

    private int dqX() {
        int i;
        int i2 = 0;
        if (getPbData().dmH() == null) {
            return 0;
        }
        ArrayList<PostData> dmH = getPbData().dmH();
        int size = dmH.size() - 1;
        while (size >= 0) {
            PostData postData = dmH.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
                if (postData.getType() != AdvertAppInfo.eNE) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return dmH.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
