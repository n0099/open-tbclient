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
    protected com.baidu.tieba.pb.data.f lKf;
    private boolean lQA;
    private boolean lQB;
    private boolean lQC;
    private boolean lQD;
    private int lQE;
    private boolean lQF;
    private int lQG;
    private long lQH;
    private int lQI;
    private int lQJ;
    private int lQK;
    private int lQL;
    private boolean lQM;
    private boolean lQN;
    private boolean lQO;
    private long lQP;
    private boolean lQQ;
    private String lQR;
    private boolean lQS;
    private boolean lQT;
    private boolean lQU;
    private boolean lQV;
    private a lQW;
    private String lQX;
    private String lQY;
    private int lQZ;
    protected String lQw;
    private String lQx;
    private String lQy;
    private String lQz;
    private int lRA;
    private int lRB;
    private Rect lRC;
    private String lRD;
    private com.baidu.tieba.tbadkCore.data.o lRE;
    private boolean lRF;
    private String lRG;
    private String lRH;
    private String lRI;
    private String lRJ;
    private String lRK;
    private boolean lRL;
    private f.a lRM;
    private CustomMessageListener lRN;
    private com.baidu.adp.framework.listener.a lRO;
    private PraiseData lRP;
    private int lRa;
    private boolean lRb;
    private boolean lRc;
    private boolean lRd;
    private boolean lRe;
    private boolean lRf;
    private String lRg;
    private long lRh;
    private boolean lRi;
    private int lRj;
    private boolean lRk;
    private boolean lRl;
    private int lRm;
    private final z lRn;
    private final n lRo;
    private final ab lRp;
    private String lRq;
    private final CheckRealNameModel lRr;
    private final AddExperiencedModel lRs;
    private SuggestEmotionModel lRt;
    private GetSugMatchWordsModel lRu;
    private boolean lRv;
    private int lRw;
    private String lRx;
    private PostData lRy;
    private PostData lRz;
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
    private static final int lQv = com.baidu.tbadk.data.e.getPbListItemMaxNum() / 30;
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
        this.lQw = null;
        this.isPrivacy = false;
        this.lQx = null;
        this.lQy = null;
        this.mForumId = null;
        this.lQz = null;
        this.lQA = false;
        this.lQB = false;
        this.lQC = true;
        this.lQD = true;
        this.mSortType = 0;
        this.lQE = 0;
        this.lQF = false;
        this.mIsGood = 0;
        this.lQG = 0;
        this.lQH = 0L;
        this.lQI = 1;
        this.lQJ = 1;
        this.lQK = 1;
        this.lQL = 1;
        this.isAd = false;
        this.eWD = false;
        this.eWc = false;
        this.lQM = false;
        this.isFromMark = false;
        this.lQN = false;
        this.lQO = false;
        this.lQP = 0L;
        this.lQQ = false;
        this.lQR = null;
        this.lKf = null;
        this.isLoading = false;
        this.lQS = false;
        this.lQT = false;
        this.lQU = false;
        this.lQV = false;
        this.mLocate = null;
        this.mContext = null;
        this.lQW = null;
        this.opType = null;
        this.opUrl = null;
        this.lQX = null;
        this.lQY = null;
        this.lQZ = -1;
        this.lRa = -1;
        this.iKw = null;
        this.lRc = false;
        this.lRd = false;
        this.postID = null;
        this.lRg = null;
        this.lRh = 0L;
        this.lRi = false;
        this.lRj = -1;
        this.lRl = false;
        this.lRv = false;
        this.lRw = 0;
        this.mTabIndex = 0;
        this.lRF = false;
        this.lRN = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.lRO = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
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
                    if (!PbModel.this.lRc || !PbModel.this.lRd) {
                        if (!PbModel.this.lRc) {
                            PbModel.this.lRc = true;
                        } else {
                            PbModel.this.lRd = true;
                        }
                        if (PbModel.this.lQW != null) {
                            PbModel.this.lQW.a(PbModel.this.dpR(), z, responsedMessage, PbModel.this.lRe, System.currentTimeMillis() - PbModel.this.jDr);
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
                    if (PbModel.this.lKf != null && PbModel.this.lKf.dmD() != null && PbModel.this.lKf.dmD().getForumId() != null && PbModel.this.lKf.dmD().getForumId().equals(valueOf)) {
                        PbModel.this.lKf.dmD().setIsLike(false);
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
                    if (PbModel.this.lKf != null && PbModel.this.lKf.dmD() != null && PbModel.this.lKf.dmD().getForumId() != null && PbModel.this.lKf.dmD().getForumId().equals(valueOf)) {
                        PbModel.this.lKf.dmD().setIsLike(true);
                    }
                }
            }
        };
        this.lRP = null;
        registerListener(this.lRO);
        registerListener(this.lRN);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.lKf = new com.baidu.tieba.pb.data.f();
        this.lKf.GH(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.iJr = baseFragmentActivity;
        this.lRn = new z(this, this.iJr);
        this.lRo = new n(this, this.iJr);
        this.lRp = new ab(this, this.iJr);
        this.lRr = new CheckRealNameModel(this.iJr.getPageContext());
        this.lRt = new SuggestEmotionModel();
        this.lRs = new AddExperiencedModel(this.iJr.getPageContext());
        this.lRM = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void onCallBack(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eGs) instanceof String) {
                        PbModel.this.lQw = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eGs);
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
        this.lRf = true;
        if (fVar != null && fVar.lFT == null) {
            q(fVar);
            l(fVar);
            if (fVar.dmE() != null) {
                fVar.dmE().oL(0);
            }
            if (this.lQW != null && fVar != null) {
                this.lQW.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int dpR() {
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
            this.lQw = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.lRK = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            this.lRL = false;
            if (com.baidu.tbadk.BdToken.f.r(uri)) {
                this.lRL = true;
                com.baidu.tbadk.BdToken.f.bln().c(uri, this.lRM);
            } else if (StringUtils.isNull(this.lQw)) {
                this.lRL = true;
                this.lRn.a(intent, this.lRM);
                if (uri != null) {
                    if (StringUtils.isNull(this.lQw)) {
                        this.lQw = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.at.isEmpty(this.lQw)) {
                this.lQw = "0";
            }
            this.lRw = intent.getIntExtra("key_start_from", 0);
            if (this.lRw == 0) {
                this.lRw = this.lRn.aMg;
            }
            this.lQy = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.lQx = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.lQA = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.lQB = intent.getBooleanExtra("host_only", false);
            this.lQD = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.lQy = this.mSortType == 2 ? "0" : this.lQy;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.lQG = intent.getIntExtra("is_top", 0);
            this.lQH = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.lQN = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.lQO = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.eWD = intent.getBooleanExtra("is_sub_pb", false);
            this.lQQ = intent.getBooleanExtra("is_pv", false);
            this.lQP = intent.getLongExtra("msg_id", 0L);
            this.lQR = intent.getStringExtra("from_forum_name");
            this.lQY = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.lQX = intent.getStringExtra("op_stat");
            this.lQS = intent.getBooleanExtra("is_from_thread_config", false);
            this.lQT = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.lQU = intent.getBooleanExtra("is_from_my_god_config", false);
            this.lRa = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.lQZ = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.eWc = intent.getBooleanExtra("from_frs", false);
            this.lQM = intent.getBooleanExtra("from_maintab", false);
            this.lRl = intent.getBooleanExtra("from_smart_frs", false);
            this.lQV = intent.getBooleanExtra("from_hottopic", false);
            this.lRq = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.lQz = intent.getStringExtra("high_light_post_id");
            this.lRF = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.lRb = intent.getIntExtra("request_code", -1) == 18003;
            this.lRG = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.lRH = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.lRI = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.lRJ = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean dpS() {
        return this.lRF && com.baidu.tieba.frs.l.cEO() != null && com.baidu.tieba.frs.l.cEO().equals(this.lQw) && com.baidu.tieba.frs.l.cEN() != null;
    }

    public com.baidu.tieba.pb.data.f aL(bz bzVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.GH(3);
        if (bzVar == null) {
            return null;
        }
        fVar.aI(bzVar);
        if (bzVar.bth() != null) {
            fVar.d(bzVar.bth());
            ForumData forum = fVar.getForum();
            forum.setId(bzVar.bth().getForumId());
            forum.setName(bzVar.bth().getForumName());
            forum.setUser_level(bzVar.bth().bqG());
            forum.setImage_url(bzVar.bth().getAvatar());
            forum.setPost_num(bzVar.bth().postNum);
            forum.setMember_num(bzVar.bth().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(bzVar.getFid()));
            forum2.setName(bzVar.bru());
        }
        PostData postData = new PostData();
        postData.KR(1);
        postData.setTime(bzVar.getCreateTime());
        postData.a(bzVar.brq());
        MetaData brq = bzVar.brq();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(brq.getUserId(), brq);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bzVar.brg(), false));
        fVar.d(postData);
        fVar.dmG().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.o(bzVar, null));
        fVar.lFY = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.lRw = bundle.getInt("key_start_from", 0);
        this.lQw = bundle.getString("thread_id");
        this.lQy = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.lQx = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.lQA = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.lQB = bundle.getBoolean("host_only", false);
        this.lQD = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.lQG = bundle.getInt("is_top", 0);
        this.lQH = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.lQO = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eWD = bundle.getBoolean("is_sub_pb", false);
        this.lQQ = bundle.getBoolean("is_pv", false);
        this.lQP = bundle.getLong("msg_id", 0L);
        this.lQR = bundle.getString("from_forum_name");
        this.lQY = bundle.getString("extra_pb_cache_key");
        this.lQS = bundle.getBoolean("is_from_thread_config", false);
        this.lQT = bundle.getBoolean("is_from_interview_live_config", false);
        this.lQU = bundle.getBoolean("is_from_my_god_config", false);
        this.lRa = bundle.getInt("extra_pb_is_attention_key", -1);
        this.lQZ = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eWc = bundle.getBoolean("from_frs", false);
        this.lQM = bundle.getBoolean("from_maintab", false);
        this.lRl = bundle.getBoolean("from_smart_frs", false);
        this.lQV = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.lQz = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.lRb = bundle.getInt("request_code", -1) == 18003;
        this.lRG = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.lRH = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.lRI = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.lRJ = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aD(Bundle bundle) {
        bundle.putString("thread_id", this.lQw);
        bundle.putString("post_id", this.lQy);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.lRw);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.lQA);
        bundle.putBoolean("host_only", this.lQB);
        bundle.putBoolean("squence", this.lQD);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.lQG);
        bundle.putLong("thread_time", this.lQH);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.lQO);
        bundle.putBoolean("is_sub_pb", this.eWD);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.lQQ);
        bundle.putLong("msg_id", this.lQP);
        bundle.putString("extra_pb_cache_key", this.lQY);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.lQS);
        bundle.putBoolean("is_from_interview_live_config", this.lQT);
        bundle.putBoolean("is_from_my_god_config", this.lQU);
        bundle.putInt("extra_pb_is_attention_key", this.lRa);
        bundle.putInt("extra_pb_funs_count_key", this.lQZ);
        bundle.putBoolean("from_frs", this.eWc);
        bundle.putBoolean("from_maintab", this.lQM);
        bundle.putBoolean("from_smart_frs", this.lRl);
        bundle.putBoolean("from_hottopic", this.lQV);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.lQz);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.lRG);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.lRH);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.lRI);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.lRJ);
    }

    public String dpT() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.lQw);
        if (!this.lQO) {
            sb.append(this.lQy);
        }
        sb.append(this.lQB);
        sb.append(this.lQD);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.lQG);
        sb.append(this.lQH);
        sb.append(this.eWc);
        sb.append(this.lQM);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eWD);
        sb.append(this.lQQ);
        sb.append(this.lQP);
        sb.append(this.lQR);
        sb.append(this.mThreadType);
        sb.append(this.lQS);
        sb.append(this.lQT);
        sb.append(this.lQU);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.lQY != null) {
            sb.append(this.lQY);
        }
        return sb.toString();
    }

    public String dnO() {
        return this.lQR;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String dpU() {
        return this.lQy;
    }

    public String dpV() {
        return this.lQz;
    }

    public String dpW() {
        return this.lQw;
    }

    public String dpX() {
        return (StringUtils.isNull(this.lQw) || "0".equals(this.lQw)) ? this.oriUgcNid : this.lQw;
    }

    public boolean getHostMode() {
        return this.lQB;
    }

    public boolean dpY() {
        return dqO();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean dpZ() {
        return this.eWc;
    }

    public boolean dqa() {
        return this.lQF;
    }

    public boolean dqb() {
        return this.lQM;
    }

    public boolean dqc() {
        return this.lQV;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean dqd() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int cxN() {
        return this.lQG;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void Hb(int i) {
        this.lQG = i;
    }

    public boolean dqe() {
        return this.eWD;
    }

    public boolean dqf() {
        if (this.lKf == null) {
            return false;
        }
        return this.lKf.isValid();
    }

    public String bry() {
        if (this.lKf == null || !this.lKf.bnx()) {
            return null;
        }
        return this.lKf.bnw();
    }

    public boolean Hc(int i) {
        this.lQI = i;
        if (this.lQI > this.lKf.getPage().bqa()) {
            this.lQI = this.lKf.getPage().bqa();
        }
        if (this.lQI < 1) {
            this.lQI = 1;
        }
        if (this.lQw == null) {
            return false;
        }
        return He(5);
    }

    public void Hd(int i) {
        this.lQI = i;
        this.lQJ = i;
        this.lQK = i;
    }

    public void b(ax axVar) {
        if (axVar == null) {
            Hd(1);
            return;
        }
        if (this.lQJ < axVar.bqd()) {
            this.lQJ = axVar.bqd();
        }
        if (this.lQK > axVar.bqd()) {
            this.lQK = axVar.bqd();
        }
        this.lQL = axVar.bqa();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.lKf;
    }

    public BaijiahaoData dqg() {
        if (this.lKf == null || this.lKf.dmE() == null) {
            return null;
        }
        return this.lKf.dmE().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f dqh() {
        if (this.lKf == null) {
            return this.lKf;
        }
        if (!dqi() && this.lRE != null) {
            this.lKf.b(this.lRE);
        }
        return this.lKf;
    }

    private boolean dqi() {
        return (this.lKf.dmW() == null || this.lKf.dmW().dOR() == null || this.lKf.dmW().dOR().goods != null || this.lKf.dmW().dOR().goods.goods_style == 1001) ? false : true;
    }

    public ax getPageData() {
        if (this.lKf == null) {
            return null;
        }
        return this.lKf.getPage();
    }

    public boolean dqj() {
        if (dqO() && this.lKf.getPage().bqf() == 0) {
            vb(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.lQw = fVar.getThreadId();
            if (fVar.dmE() != null && fVar.dmE().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.dmE().getBaijiahaoData();
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
            this.lQy = null;
            this.lQB = false;
            this.lQD = true;
            LoadData();
        }
    }

    public void PJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.lQw = str;
            this.lQy = null;
            this.lQB = false;
            this.lQD = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lQw == null) {
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
            this.lQX = null;
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
        if (this.lRt != null) {
            this.lRt.cancelLoadData();
        }
        if (this.lRu != null) {
            this.lRu.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dFU().RV("PB");
        czm();
    }

    private void czm() {
        if (this.iKw != null) {
            this.iKw.destory();
            this.iKw = null;
        }
    }

    public boolean dqk() {
        return (this.lQy == null || this.lQy.equals("0") || this.lQy.length() == 0) ? LoadData() : dqo();
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
        this.lRt.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.lRu == null) {
                this.lRu = new GetSugMatchWordsModel(this.iJr.getPageContext());
            }
            this.lRu.b(aVar);
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
        final com.baidu.tieba.pb.data.f pbData = aj.drv().getPbData();
        if (pbData != null && pbData.dmE() != null) {
            pbData.dmE().oL(0);
            this.lQD = aj.drv().dpY();
            this.lQB = aj.drv().drA();
            this.lQF = aj.drv().drB();
            this.lRy = aj.drv().drz();
            this.lRz = aj.drv().dry();
            this.lRA = aj.drv().drx();
            this.lRC = aj.drv().drC();
            this.mTabIndex = aj.drv().dqV();
            this.lRv = this.lQB;
            if (this.lQB || this.isFromMark) {
                this.lRb = false;
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
        if (i == 4 && !this.lRf) {
            a(dqt(), true, this.lQy, 3);
        }
        if (i == 3 && !this.lRf) {
            if (this.isFromMark) {
                a(dqt(), true, this.lQy, 3);
            } else {
                a(dqt(), false, this.lQy, 3);
            }
        }
        this.lRf = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.lRE == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.fCT);
        if (this.lQB || this.isFromMark) {
            this.lRb = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.lQw == null || this.lQw.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.lQw, 0L));
        if (com.baidu.tbadk.a.d.bmG()) {
            pbPageRequestMessage.setFloorSortType(1);
            pbPageRequestMessage.setFloor_rn(com.baidu.tbadk.a.d.bmP());
            pbPageRequestMessage.set_rn(15);
        } else {
            pbPageRequestMessage.set_rn(30);
        }
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.au.bwr().bws() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.lQD) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.lQB) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.lQQ) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.lQP));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.lRb) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.lQX, 0));
            pbPageRequestMessage.setOpMessageID(this.lQP);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> dmG = this.lKf.dmG();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lQK - 1));
                        if (this.lQK - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.lQN) {
                                if (dmG != null && dmG.size() > 0) {
                                    size = dmG.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = dmG.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.lQy = postData.getId();
                                            if (StringUtils.isNull(this.lQy)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.lQJ + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.lQy == null && this.lQy.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lQy, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lQJ + 1));
                        if (this.lQJ >= this.lQL) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (dmG != null) {
                                size = dmG.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.lQy == null) {
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
                if (dmG != null) {
                }
                if (this.lQy == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (dmG != null && dmG.size() > 0 && dmG.get(0) != null) {
                    this.lQy = dmG.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (dqO()) {
                        if (this.lQK - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.lQK - 1));
                        }
                    } else if (this.lQJ < this.lQL) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lQJ + 1));
                    }
                }
                if (this.lQy != null && this.lQy.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lQy, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.lQB) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (dqO()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.lQL > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lQL));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lQy, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.lQI));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.lRv && !this.lQB) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lQy, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.lQB) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.lRj);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lRx, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.lRv = this.lQB;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(dqt());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.lRw));
        pbPageRequestMessage.setIsSubPostDataReverse(this.lRi);
        pbPageRequestMessage.setFromSmartFrs(this.lRl ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.lQA);
        if (this.lRw == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        if (this.lRw == 7 || this.lRw == 5 || this.lRL) {
            pbPageRequestMessage.setSourceType(1);
        } else {
            pbPageRequestMessage.setSourceType(2);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.lRK)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.lRK));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.lQL) {
                    i4 = -1;
                } else {
                    i4 = dqW();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = dqW();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.lQw);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean dnN() {
        switch (dqH()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().dmE() == null || !getPbData().dmE().bsQ();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dnO()) && com.baidu.tieba.recapp.r.dEV().dEP() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dEV().dEP().ba(dnO(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dEV().dEP().bb(dnO(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dnO()) && com.baidu.tieba.recapp.r.dEV().dEP() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dEV().dEP().bb(dnO(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dEV().dEP().ba(dnO(), true));
        }
    }

    protected void Hf(int i) {
        boolean z = false;
        Hk(i);
        ArrayList<PostData> dmG = this.lKf.dmG();
        this.lRe = false;
        if (i == 1) {
            boolean z2 = false;
            while (dmG.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dmG.remove(0);
                z2 = true;
            }
            if (z2) {
                this.lKf.getPage().oH(1);
                if (this.lQW != null) {
                    this.lQW.e(this.lKf);
                }
            }
            this.jDr = System.currentTimeMillis();
            this.lRe = true;
        } else if (i == 2) {
            while (dmG.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dmG.remove(dmG.size() - 1);
                z = true;
            }
            if (z) {
                this.lKf.getPage().oG(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.lRm = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.lRE != null && this.lRE.bPM()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmW() != null && fVar.dmW().dOR() != null && fVar.dmW().dOR().goods != null && fVar.dmW().bPM() && fVar.dmW().dOR().goods.goods_style != 1001) {
            this.lRE = fVar.dmW();
        }
    }

    public com.baidu.tieba.tbadkCore.data.o dql() {
        return this.lRE;
    }

    public void dqm() {
        this.lRE = null;
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
            if (this.lQU || this.lQS || this.lQT) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.dmG().size(); i++) {
                PostData postData = fVar.dmG().get(i);
                for (int i2 = 0; i2 < postData.dPa().size(); i2++) {
                    postData.dPa().get(i2).a(this.iJr.getPageContext(), o.equals(postData.dPa().get(i2).brq().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r dmS = fVar.dmS();
            if (dmS != null && !com.baidu.tbadk.core.util.x.isEmpty(dmS.lHy)) {
                for (PostData postData2 : dmS.lHy) {
                    for (int i3 = 0; i3 < postData2.dPa().size(); i3++) {
                        postData2.dPa().get(i3).a(this.iJr.getPageContext(), o.equals(postData2.dPa().get(i3).brq().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r dmS = fVar.dmS();
            if (dmS != null && !com.baidu.tbadk.core.util.x.isEmpty(dmS.lHy)) {
                for (PostData postData : dmS.lHy.subList(i, dmS.lHy.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dPa().size()) {
                            postData.dPa().get(i3).a(this.iJr.getPageContext(), o.equals(postData.dPa().get(i3).brq().getUserId()));
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
        bz dmE = fVar.dmE();
        dmE.oQ(this.mIsGood);
        dmE.oP(this.lQG);
        if (this.lQH > 0) {
            dmE.dG(this.lQH);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.dmE() != null && fVar.dmE().brq() != null) {
            str = fVar.dmE().brq().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData dqn() {
        if (this.lKf == null || this.lKf.dmE() == null || this.lKf.dmE().brq() == null) {
            return null;
        }
        return this.lKf.dmE().brq();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.lRk = z3;
        if (this.iKw != null && !z3) {
            this.iKw.a(z2, z4, i2, str, i3, j, j2);
            this.iKw = null;
        }
        if (this.lKf != null) {
            this.lKf.lGG = z3;
            this.lKf.aas = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(dnO()) && com.baidu.tieba.recapp.r.dEV().dEP() != null) {
            com.baidu.tieba.recapp.r.dEV().dEP().f(dnO(), Hg(dqw()), true);
        }
        if (fVar == null || (this.lQI == 1 && i == 5 && fVar.dmG() != null && fVar.dmG().size() < 1)) {
            if (this.lQW != null) {
                this.lQD = this.lQC;
                if (i2 != 350006) {
                    this.mSortType = this.lQE;
                }
                this.lQW.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.lQC = this.lQD;
            if (i != 8) {
                this.lQE = this.mSortType;
                this.mSortType = fVar.lFS;
            }
            if (fVar.lFR != null && fVar.lFR.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.iJr.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.lFR = new ArrayList();
                fVar.lFR.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.iJr.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.lFR.add(builder2.build(false));
                this.mSortType = this.lQE;
                fVar.lFS = this.mSortType;
            }
            this.lQQ = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.lQL = this.lQL < 1 ? 1 : this.lQL;
            int i6 = 0;
            ArrayList<PostData> dmG = this.lKf.dmG();
            switch (i) {
                case 1:
                    this.lKf.a(fVar.getPage(), 1);
                    d(fVar, dmG);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.dmG() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.dmG().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(dmG, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.getItem(fVar.dmG(), com.baidu.tbadk.core.util.x.getCount(fVar.dmG()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.dmG().remove(postData2);
                            i5 = size2 - 1;
                        }
                        dmG.addAll(0, fVar.dmG());
                    }
                    p(fVar);
                    this.lKf.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().oE(fVar.getPage().bqa());
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
                    if (fVar != null && !com.baidu.tbadk.core.util.x.isEmpty(fVar.dmG()) && this.lKf != null && (!this.lQB || o(fVar).equals(fVar.dmG().get(0).brq().getUserId()))) {
                        if (this.lKf.getPage().bqf() == 0) {
                            this.lKf.getPage().oG(1);
                        }
                        dqI();
                        this.lRy = fVar.dmG().get(0);
                        if (dqO() || this.lKf.dnh()) {
                            if (this.lKf.dmG().size() - this.lRA >= 3) {
                                this.lRz = new PostData();
                                this.lRz.nrV = true;
                                this.lRz.setPostType(53);
                                this.lKf.dmG().add(this.lRz);
                            }
                            this.lKf.dmG().add(this.lRy);
                            size = this.lKf.dmG().size() - 1;
                        } else {
                            if (this.lRA - this.lRB >= 3) {
                                this.lRz = new PostData();
                                this.lRz.nrV = false;
                                this.lRz.setPostType(53);
                                this.lKf.dmG().add(0, this.lRz);
                            }
                            this.lKf.dmG().add(0, this.lRy);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.at.isTaday(com.baidu.tbadk.core.sharedPref.b.bvq().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.lRy.nsi = this.lKf.dnf();
                            com.baidu.tbadk.core.sharedPref.b.bvq().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.lKf != null && this.lKf.dmE() != null) {
                PraiseData brb = this.lKf.dmE().brb();
                if (this.lRP != null && !brb.isPriaseDataValid()) {
                    this.lKf.dmE().a(this.lRP);
                } else {
                    this.lRP = this.lKf.dmE().brb();
                    this.lRP.setPostId(this.lKf.dmE().brG());
                }
                if (fVar.getPage() != null && fVar.getPage().bqd() == 1 && fVar.dmE() != null && fVar.dmE().brA() != null && fVar.dmE().brA().size() > 0) {
                    this.lKf.dmE().E(fVar.dmE().brA());
                }
                this.lKf.dmE().oN(fVar.dmE().brh());
                this.lKf.dmE().oK(fVar.dmE().getAnchorLevel());
                this.lKf.dmE().oL(fVar.dmE().bqX());
                if (this.mThreadType == 33) {
                    this.lKf.dmE().brq().setHadConcerned(fVar.dmE().brq().hadConcerned());
                }
                if (fVar != null && fVar.dmE() != null) {
                    this.lKf.dmE().oS(fVar.dmE().brE());
                }
            }
            if (this.lKf != null && this.lKf.getUserData() != null && fVar.getUserData() != null) {
                this.lKf.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.lKf.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().bqd() == 1 && fVar.dmR() != null) {
                this.lKf.f(fVar.dmR());
            }
            if (this.lRk) {
                if (this.lKf.dmE() != null && this.lKf.dmE().brq() != null && this.lKf.dmG() != null && com.baidu.tbadk.core.util.x.getItem(this.lKf.dmG(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.getItem(this.lKf.dmG(), 0);
                    MetaData brq = this.lKf.dmE().brq();
                    if (postData3.brq() != null && postData3.brq().getGodUserData() != null) {
                        if (this.lQZ != -1) {
                            brq.setFansNum(this.lQZ);
                            postData3.brq().setFansNum(this.lQZ);
                        }
                        if (this.lRa != -1) {
                            brq.getGodUserData().setIsLike(this.lRa == 1);
                            postData3.brq().getGodUserData().setIsLike(this.lRa == 1);
                            brq.getGodUserData().setIsFromNetWork(false);
                            postData3.brq().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.lKf.lFQ = -1;
                this.lKf.lFP = -1;
            }
            if (this.lQW != null) {
                this.lQW.a(true, getErrorCode(), i, i4, this.lKf, this.mErrorString, 1);
            }
        }
        if (this.lKf != null && this.lKf.dmE() != null && this.lKf.getForum() != null && !this.lKf.dnh()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.iJr.getPageContext();
            historyMessage.threadId = getPbData().dmE().getId();
            if (this.mIsShareThread && getPbData().dmE().eVB != null) {
                historyMessage.threadName = getPbData().dmE().eVB.showText;
            } else {
                historyMessage.threadName = getPbData().dmE().getTitle();
            }
            if (this.mIsShareThread && !dnN()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = dpY();
            historyMessage.threadType = getPbData().dmE().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.lKf != null) {
            this.lKf.dmV().clear();
            this.lKf.dmV().addAll(fVar.dmV());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String be;
        if (arrayList != null && fVar.dmG() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(fVar.dmG(), 0);
            if (postData != null && (be = be(arrayList)) != null && be.equals(postData.getId())) {
                fVar.dmG().remove(postData);
            }
            this.lKf.lGF = arrayList.size();
            arrayList.addAll(fVar.dmG());
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
            fVar.PC(this.lKf.dmZ());
            if (!this.lKf.lGD && fVar.lGD && this.lKf.dmO() != null) {
                fVar.e(this.lKf.dmO());
            }
            this.lKf = fVar;
            Hd(fVar.getPage().bqd());
        }
    }

    public boolean dqo() {
        if (this.lQw == null || this.lQy == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return He(4);
        }
        return He(6);
    }

    public boolean vb(boolean z) {
        if (this.lQw == null || this.lKf == null) {
            return false;
        }
        if (z || this.lKf.getPage().bqf() != 0) {
            return He(1);
        }
        return false;
    }

    public boolean vc(boolean z) {
        if (this.lQw == null || this.lKf == null) {
            return false;
        }
        if ((z || this.lKf.getPage().bqg() != 0) && this.lKf.dmG() != null && this.lKf.dmG().size() >= 1) {
            return He(2);
        }
        return false;
    }

    public boolean PP(String str) {
        this.lQB = !this.lQB;
        this.lQy = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").an("obj_source", 0));
        if (He(6)) {
            return true;
        }
        this.lQB = this.lQB ? false : true;
        return false;
    }

    public boolean C(boolean z, String str) {
        if (this.lQB == z) {
            return false;
        }
        this.lQB = z;
        this.lQy = str;
        if (this.mSortType == 2) {
            this.lQy = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").an("obj_source", 1));
        }
        if (He(6)) {
            return true;
        }
        this.lQB = z ? false : true;
        return false;
    }

    public boolean Hh(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_pb_current_sort_type", i);
        }
        this.lQC = this.lQD;
        this.lQE = this.mSortType;
        this.mSortType = i;
        this.lQD = !this.lQD;
        if (i == 2 && this.isFromMark) {
            this.lQy = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.lQD = this.lQD ? false : true;
            this.mSortType = this.lQE;
            return false;
        }
        return true;
    }

    public boolean dqp() {
        return dqO();
    }

    public int dqq() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.lKf == null || this.lKf.getForum() == null || this.lKf.dmE() == null) ? false : true;
    }

    public boolean bnx() {
        if (this.lKf == null) {
            return false;
        }
        return this.lKf.bnx();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DO(String str) {
        if (this.lKf == null || this.lKf.dmE() == null || this.lKf.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.lKf.dmE().bsQ()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.lKf.getForum().getId());
            writeData.setForumName(this.lKf.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.lRw);
        writeData.setThreadId(this.lQw);
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
        if (this.lKf == null) {
            return null;
        }
        ArrayList<PostData> dmG = this.lKf.dmG();
        if (com.baidu.tbadk.core.util.x.isEmpty(dmG)) {
            return null;
        }
        if (dmG.size() > 0 && i >= dmG.size()) {
            i = dmG.size() - 1;
        }
        return o(dmG.get(i));
    }

    public MarkData dqr() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lQw);
        markData.setPostId(this.lKf.bnw());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lQB);
        markData.setSequence(Boolean.valueOf(dqO()));
        markData.setId(this.lQw);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lQw);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lQB);
        markData.setSequence(Boolean.valueOf(dqO()));
        markData.setId(this.lQw);
        markData.setFloor(postData.dPd());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.o) postData).isApp());
        }
        return markData;
    }

    public void dqs() {
        i.doB().aV(dqt(), this.isFromMark);
    }

    private String dqt() {
        String dqu = (this.lQw == null || this.lQw.equals("0")) ? dqu() : this.lQw;
        if (this.lQB) {
            dqu = dqu + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            dqu = dqu + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            dqu = dqu + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return dqu + TbadkCoreApplication.getCurrentAccount();
        }
        return dqu;
    }

    private String dqu() {
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
        if (this.lKf != null) {
            this.lKf.jc(z);
        }
    }

    public boolean dqv() {
        return this.lRb;
    }

    public void a(a aVar) {
        this.lQW = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bFk() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bFj() {
        return dqk();
    }

    public boolean PQ(String str) {
        if (getPbData() == null || getPbData().dmE() == null || getPbData().dmE().brq() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().dmE().brq().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int dqw() {
        return this.mRequestType;
    }

    public void dqx() {
        if ("personalize_page".equals(this.mStType)) {
            this.lRh = System.currentTimeMillis() / 1000;
        }
    }

    public void dqy() {
        if ("personalize_page".equals(this.mStType) && this.lKf != null && this.lRh != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10754").dX("fid", this.lKf.getForumId()).dX("tid", this.lQw).dX("obj_duration", String.valueOf(currentTimeMillis - this.lRh)).dX(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.lRh = 0L;
        }
    }

    public boolean dqz() {
        return this.lRk;
    }

    public int getErrorNo() {
        return this.lRm;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public n dqA() {
        return this.lRo;
    }

    public ab dqB() {
        return this.lRp;
    }

    public CheckRealNameModel dqC() {
        return this.lRr;
    }

    public AddExperiencedModel dqD() {
        return this.lRs;
    }

    public String dqE() {
        return this.lRg;
    }

    public void PR(String str) {
        this.lRg = str;
    }

    public boolean dqF() {
        return this.lRl;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lKf != null && this.lKf.dmG() != null && this.lKf.dmG().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lKf.dmG().size();
                for (int i = 0; i < size; i++) {
                    if (this.lKf.dmG().get(i) != null && this.lKf.dmG().get(i).brq() != null && currentAccount.equals(this.lKf.dmG().get(i).brq().getUserId()) && this.lKf.dmG().get(i).brq().getPendantData() != null) {
                        this.lKf.dmG().get(i).brq().getPendantData().AY(nVar.getImgUrl());
                        this.lKf.dmG().get(i).brq().getPendantData().ee(nVar.bEh());
                    }
                }
            }
        }
    }

    public String dqG() {
        return this.lRq;
    }

    public int dqH() {
        return this.lRw;
    }

    public void Hj(int i) {
        this.lRw = i;
    }

    public void PS(String str) {
        if ((!this.lQB || PQ(TbadkCoreApplication.getCurrentAccount())) && this.lKf.dmG() != null) {
            this.lKf.getPage().oG(1);
            if (this.lKf.getPage().bqf() == 0) {
                this.lKf.getPage().oG(1);
            }
            this.lRx = str;
            He(8);
        }
    }

    private void Hk(int i) {
        if (i != 8) {
            this.lRx = "";
            if (this.lRy != null) {
                if (i == 1 && this.lKf != null && this.lKf.dnh()) {
                    if (this.lRz != null) {
                        getPbData().dmG().remove(this.lRz);
                    }
                } else if (i == 1 && !this.lQD && !com.baidu.tbadk.core.util.x.isEmpty(getPbData().dmG())) {
                    getPbData().dmG().remove(this.lRy);
                    if (this.lRz != null) {
                        getPbData().dmG().remove(this.lRz);
                    }
                    getPbData().dmG().add(0, this.lRy);
                } else {
                    getPbData().dmG().remove(this.lRy);
                    if (this.lRz != null) {
                        getPbData().dmG().remove(this.lRz);
                    }
                }
            }
            this.lRz = null;
        }
    }

    public void dqI() {
        if (this.lKf != null && !com.baidu.tbadk.core.util.x.isEmpty(this.lKf.dmG())) {
            if (this.lRz != null) {
                this.lKf.dmG().remove(this.lRz);
                this.lRz = null;
            }
            if (this.lRy != null) {
                this.lKf.dmG().remove(this.lRy);
                this.lRy = null;
            }
        }
    }

    public void dc(int i, int i2) {
        this.lRA = i;
        this.lRB = i2;
    }

    public PostData dqJ() {
        return this.lRy;
    }

    public PostData dqK() {
        return this.lRz;
    }

    public int dqL() {
        return this.lRA;
    }

    public int dqM() {
        return this.lRB;
    }

    public String dqN() {
        return this.lRD;
    }

    public void PT(String str) {
        this.lRD = str;
    }

    private boolean dqO() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean dqP() {
        return this.lRw == 13 || this.lRw == 12 || this.lRw == 7 || this.lRw == 23;
    }

    public String dqQ() {
        return this.lRG;
    }

    public String dqR() {
        return this.lRH;
    }

    public String dqS() {
        return this.lRI;
    }

    public String dqT() {
        return this.lRJ;
    }

    public Rect dqU() {
        Rect rect = this.lRC;
        this.lRC = null;
        return rect;
    }

    public int dqV() {
        return this.mTabIndex;
    }

    private int dqW() {
        int i;
        int i2 = 0;
        if (getPbData().dmG() == null) {
            return 0;
        }
        ArrayList<PostData> dmG = getPbData().dmG();
        int size = dmG.size() - 1;
        while (size >= 0) {
            PostData postData = dmG.get(size);
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
        return dmG.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
