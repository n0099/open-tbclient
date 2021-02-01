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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
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
    private boolean eTD;
    private boolean eUg;
    private BaseFragmentActivity iKt;
    private com.baidu.tieba.tbadkCore.d.b iLy;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private long jEq;
    protected com.baidu.tieba.pb.data.f lOq;
    protected String lUN;
    private String lUO;
    private String lUP;
    private String lUQ;
    private boolean lUR;
    private boolean lUS;
    private boolean lUT;
    private boolean lUU;
    private int lUV;
    private boolean lUW;
    private int lUX;
    private long lUY;
    private int lUZ;
    private int lVA;
    private boolean lVB;
    private boolean lVC;
    private int lVD;
    private final z lVE;
    private final n lVF;
    private final ab lVG;
    private String lVH;
    private final CheckRealNameModel lVI;
    private final AddExperiencedModel lVJ;
    private SuggestEmotionModel lVK;
    private GetSugMatchWordsModel lVL;
    private boolean lVM;
    private int lVN;
    private String lVO;
    private PostData lVP;
    private PostData lVQ;
    private int lVR;
    private int lVS;
    private Rect lVT;
    private String lVU;
    private com.baidu.tieba.tbadkCore.data.o lVV;
    private boolean lVW;
    private String lVX;
    private String lVY;
    private String lVZ;
    private int lVa;
    private int lVb;
    private int lVc;
    private boolean lVd;
    private boolean lVe;
    private boolean lVf;
    private long lVg;
    private boolean lVh;
    private String lVi;
    private boolean lVj;
    private boolean lVk;
    private boolean lVl;
    private boolean lVm;
    private a lVn;
    private String lVo;
    private String lVp;
    private int lVq;
    private int lVr;
    private boolean lVs;
    private boolean lVt;
    private boolean lVu;
    private boolean lVv;
    private boolean lVw;
    private String lVx;
    private long lVy;
    private boolean lVz;
    private String lWa;
    private String lWb;
    private boolean lWc;
    private f.a lWd;
    private CustomMessageListener lWe;
    private com.baidu.adp.framework.listener.a lWf;
    private PraiseData lWg;
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
    private static final int lUM = com.baidu.tbadk.data.e.getPbListItemMaxNum() / 30;
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
        this.lUN = null;
        this.isPrivacy = false;
        this.lUO = null;
        this.lUP = null;
        this.mForumId = null;
        this.lUQ = null;
        this.lUR = false;
        this.lUS = false;
        this.lUT = true;
        this.lUU = true;
        this.mSortType = 0;
        this.lUV = 0;
        this.lUW = false;
        this.mIsGood = 0;
        this.lUX = 0;
        this.lUY = 0L;
        this.lUZ = 1;
        this.lVa = 1;
        this.lVb = 1;
        this.lVc = 1;
        this.isAd = false;
        this.eUg = false;
        this.eTD = false;
        this.lVd = false;
        this.isFromMark = false;
        this.lVe = false;
        this.lVf = false;
        this.lVg = 0L;
        this.lVh = false;
        this.lVi = null;
        this.lOq = null;
        this.isLoading = false;
        this.lVj = false;
        this.lVk = false;
        this.lVl = false;
        this.lVm = false;
        this.mLocate = null;
        this.mContext = null;
        this.lVn = null;
        this.opType = null;
        this.opUrl = null;
        this.lVo = null;
        this.lVp = null;
        this.lVq = -1;
        this.lVr = -1;
        this.iLy = null;
        this.lVt = false;
        this.lVu = false;
        this.postID = null;
        this.lVx = null;
        this.lVy = 0L;
        this.lVz = false;
        this.lVA = -1;
        this.lVC = false;
        this.lVM = false;
        this.lVN = 0;
        this.mTabIndex = 0;
        this.lVW = false;
        this.lWe = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.lWf = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.iKt.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.lVt || !PbModel.this.lVu) {
                        if (!PbModel.this.lVt) {
                            PbModel.this.lVt = true;
                        } else {
                            PbModel.this.lVu = true;
                        }
                        if (PbModel.this.lVn != null) {
                            PbModel.this.lVn.a(PbModel.this.doo(), z, responsedMessage, PbModel.this.lVv, System.currentTimeMillis() - PbModel.this.jEq);
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
                    if (PbModel.this.lOq != null && PbModel.this.lOq.dkY() != null && PbModel.this.lOq.dkY().getForumId() != null && PbModel.this.lOq.dkY().getForumId().equals(valueOf)) {
                        PbModel.this.lOq.dkY().setIsLike(false);
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
                    if (PbModel.this.lOq != null && PbModel.this.lOq.dkY() != null && PbModel.this.lOq.dkY().getForumId() != null && PbModel.this.lOq.dkY().getForumId().equals(valueOf)) {
                        PbModel.this.lOq.dkY().setIsLike(true);
                    }
                }
            }
        };
        this.lWg = null;
        registerListener(this.lWf);
        registerListener(this.lWe);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.lOq = new com.baidu.tieba.pb.data.f();
        this.lOq.Fu(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.iKt = baseFragmentActivity;
        this.lVE = new z(this, this.iKt);
        this.lVF = new n(this, this.iKt);
        this.lVG = new ab(this, this.iKt);
        this.lVI = new CheckRealNameModel(this.iKt.getPageContext());
        this.lVK = new SuggestEmotionModel();
        this.lVJ = new AddExperiencedModel(this.iKt.getPageContext());
        this.lWd = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void onCallBack(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eDM) instanceof String) {
                        PbModel.this.lUN = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eDM);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eDN) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eDN);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eDO) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eDO);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eDP) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.eDP), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eDQ) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eDQ);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.lVw = true;
        if (fVar != null && fVar.lKa == null) {
            q(fVar);
            l(fVar);
            if (fVar.dkZ() != null) {
                fVar.dkZ().ni(0);
            }
            if (this.lVn != null && fVar != null) {
                this.lVn.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int doo() {
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
            this.lUN = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.lWb = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            this.lWc = false;
            if (com.baidu.tbadk.BdToken.f.r(uri)) {
                this.lWc = true;
                com.baidu.tbadk.BdToken.f.bhH().c(uri, this.lWd);
            } else if (StringUtils.isNull(this.lUN)) {
                this.lWc = true;
                this.lVE.a(intent, this.lWd);
                if (uri != null) {
                    if (StringUtils.isNull(this.lUN)) {
                        this.lUN = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.au.isEmpty(this.lUN)) {
                this.lUN = "0";
            }
            this.lVN = intent.getIntExtra("key_start_from", 0);
            if (this.lVN == 0) {
                this.lVN = this.lVE.aJY;
            }
            this.lUP = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.lUO = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.lUR = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.lUS = intent.getBooleanExtra("host_only", false);
            this.lUU = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.lUP = this.mSortType == 2 ? "0" : this.lUP;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.lUX = intent.getIntExtra("is_top", 0);
            this.lUY = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.lVe = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.lVf = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.eUg = intent.getBooleanExtra("is_sub_pb", false);
            this.lVh = intent.getBooleanExtra("is_pv", false);
            this.lVg = intent.getLongExtra("msg_id", 0L);
            this.lVi = intent.getStringExtra("from_forum_name");
            this.lVp = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.lVo = intent.getStringExtra("op_stat");
            this.lVj = intent.getBooleanExtra("is_from_thread_config", false);
            this.lVk = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.lVl = intent.getBooleanExtra("is_from_my_god_config", false);
            this.lVr = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.lVq = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.eTD = intent.getBooleanExtra("from_frs", false);
            this.lVd = intent.getBooleanExtra("from_maintab", false);
            this.lVC = intent.getBooleanExtra("from_smart_frs", false);
            this.lVm = intent.getBooleanExtra("from_hottopic", false);
            this.lVH = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.lUQ = intent.getStringExtra("high_light_post_id");
            this.lVW = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.lVs = intent.getIntExtra("request_code", -1) == 18003;
            this.lVX = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.lVY = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.lVZ = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.lWa = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean dop() {
        return this.lVW && com.baidu.tieba.frs.l.cCj() != null && com.baidu.tieba.frs.l.cCj().equals(this.lUN) && com.baidu.tieba.frs.l.cCi() != null;
    }

    public com.baidu.tieba.pb.data.f aM(cb cbVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.Fu(3);
        if (cbVar == null) {
            return null;
        }
        fVar.aJ(cbVar);
        if (cbVar.bpG() != null) {
            fVar.d(cbVar.bpG());
            ForumData forum = fVar.getForum();
            forum.setId(cbVar.bpG().getForumId());
            forum.setName(cbVar.bpG().getForumName());
            forum.setUser_level(cbVar.bpG().bng());
            forum.setImage_url(cbVar.bpG().getAvatar());
            forum.setPost_num(cbVar.bpG().postNum);
            forum.setMember_num(cbVar.bpG().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(cbVar.getFid()));
            forum2.setName(cbVar.bnU());
        }
        PostData postData = new PostData();
        postData.JE(1);
        postData.setTime(cbVar.getCreateTime());
        postData.a(cbVar.bnQ());
        MetaData bnQ = cbVar.bnQ();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(bnQ.getUserId(), bnQ);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, cbVar.bnG(), dot(), false));
        fVar.d(postData);
        fVar.dlb().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.p(cbVar, null));
        fVar.lKf = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.lVN = bundle.getInt("key_start_from", 0);
        this.lUN = bundle.getString("thread_id");
        this.lUP = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.lUO = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.lUR = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.lUS = bundle.getBoolean("host_only", false);
        this.lUU = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.lUX = bundle.getInt("is_top", 0);
        this.lUY = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.lVf = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eUg = bundle.getBoolean("is_sub_pb", false);
        this.lVh = bundle.getBoolean("is_pv", false);
        this.lVg = bundle.getLong("msg_id", 0L);
        this.lVi = bundle.getString("from_forum_name");
        this.lVp = bundle.getString("extra_pb_cache_key");
        this.lVj = bundle.getBoolean("is_from_thread_config", false);
        this.lVk = bundle.getBoolean("is_from_interview_live_config", false);
        this.lVl = bundle.getBoolean("is_from_my_god_config", false);
        this.lVr = bundle.getInt("extra_pb_is_attention_key", -1);
        this.lVq = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eTD = bundle.getBoolean("from_frs", false);
        this.lVd = bundle.getBoolean("from_maintab", false);
        this.lVC = bundle.getBoolean("from_smart_frs", false);
        this.lVm = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.lUQ = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.lVs = bundle.getInt("request_code", -1) == 18003;
        this.lVX = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.lVY = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.lVZ = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.lWa = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aD(Bundle bundle) {
        bundle.putString("thread_id", this.lUN);
        bundle.putString("post_id", this.lUP);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.lVN);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.lUR);
        bundle.putBoolean("host_only", this.lUS);
        bundle.putBoolean("squence", this.lUU);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.lUX);
        bundle.putLong("thread_time", this.lUY);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.lVf);
        bundle.putBoolean("is_sub_pb", this.eUg);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.lVh);
        bundle.putLong("msg_id", this.lVg);
        bundle.putString("extra_pb_cache_key", this.lVp);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.lVj);
        bundle.putBoolean("is_from_interview_live_config", this.lVk);
        bundle.putBoolean("is_from_my_god_config", this.lVl);
        bundle.putInt("extra_pb_is_attention_key", this.lVr);
        bundle.putInt("extra_pb_funs_count_key", this.lVq);
        bundle.putBoolean("from_frs", this.eTD);
        bundle.putBoolean("from_maintab", this.lVd);
        bundle.putBoolean("from_smart_frs", this.lVC);
        bundle.putBoolean("from_hottopic", this.lVm);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.lUQ);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.lVX);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.lVY);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.lVZ);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.lWa);
    }

    public String doq() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.lUN);
        if (!this.lVf) {
            sb.append(this.lUP);
        }
        sb.append(this.lUS);
        sb.append(this.lUU);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.lUX);
        sb.append(this.lUY);
        sb.append(this.eTD);
        sb.append(this.lVd);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eUg);
        sb.append(this.lVh);
        sb.append(this.lVg);
        sb.append(this.lVi);
        sb.append(this.mThreadType);
        sb.append(this.lVj);
        sb.append(this.lVk);
        sb.append(this.lVl);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.lVp != null) {
            sb.append(this.lVp);
        }
        return sb.toString();
    }

    public String dmj() {
        return this.lVi;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String dor() {
        return this.lUP;
    }

    public String dos() {
        return this.lUQ;
    }

    public String dot() {
        return this.lUN;
    }

    public String dou() {
        return (StringUtils.isNull(this.lUN) || "0".equals(this.lUN)) ? this.oriUgcNid : this.lUN;
    }

    public boolean getHostMode() {
        return this.lUS;
    }

    public boolean dov() {
        return dpl();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean dow() {
        return this.eTD;
    }

    public boolean dox() {
        return this.lUW;
    }

    public boolean doy() {
        return this.lVd;
    }

    public boolean doz() {
        return this.lVm;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean doA() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int cvi() {
        return this.lUX;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void FO(int i) {
        this.lUX = i;
    }

    public boolean doB() {
        return this.eUg;
    }

    public boolean doC() {
        if (this.lOq == null) {
            return false;
        }
        return this.lOq.isValid();
    }

    public String bnY() {
        if (this.lOq == null || !this.lOq.bjZ()) {
            return null;
        }
        return this.lOq.bjY();
    }

    public boolean FP(int i) {
        this.lUZ = i;
        if (this.lUZ > this.lOq.getPage().bmA()) {
            this.lUZ = this.lOq.getPage().bmA();
        }
        if (this.lUZ < 1) {
            this.lUZ = 1;
        }
        if (this.lUN == null) {
            return false;
        }
        return FR(5);
    }

    public void FQ(int i) {
        this.lUZ = i;
        this.lVa = i;
        this.lVb = i;
    }

    public void b(az azVar) {
        if (azVar == null) {
            FQ(1);
            return;
        }
        if (this.lVa < azVar.bmD()) {
            this.lVa = azVar.bmD();
        }
        if (this.lVb > azVar.bmD()) {
            this.lVb = azVar.bmD();
        }
        this.lVc = azVar.bmA();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.lOq;
    }

    public BaijiahaoData doD() {
        if (this.lOq == null || this.lOq.dkZ() == null) {
            return null;
        }
        return this.lOq.dkZ().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f doE() {
        if (this.lOq == null) {
            return this.lOq;
        }
        if (!doF() && this.lVV != null) {
            this.lOq.b(this.lVV);
        }
        return this.lOq;
    }

    private boolean doF() {
        return (this.lOq.dlr() == null || this.lOq.dlr().dNl() == null || this.lOq.dlr().dNl().goods != null || this.lOq.dlr().dNl().goods.goods_style == 1001) ? false : true;
    }

    public az getPageData() {
        if (this.lOq == null) {
            return null;
        }
        return this.lOq.getPage();
    }

    public boolean doG() {
        if (dpl() && this.lOq.getPage().bmF() == 0) {
            vm(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.lUN = fVar.getThreadId();
            if (fVar.dkZ() != null && fVar.dkZ().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.dkZ().getBaijiahaoData();
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
            this.lUP = null;
            this.lUS = false;
            this.lUU = true;
            LoadData();
        }
    }

    public void Ps(String str) {
        if (!StringUtils.isNull(str)) {
            this.lUN = str;
            this.lUP = null;
            this.lUS = false;
            this.lUU = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lUN == null) {
            return false;
        }
        cancelLoadData();
        if (this.iLy == null) {
            this.iLy = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.iLy.start();
        }
        boolean FR = FR(3);
        if (this.opType != null) {
            this.opType = null;
            this.lVo = null;
            this.opUrl = null;
            return FR;
        }
        return FR;
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
        if (this.lVK != null) {
            this.lVK.cancelLoadData();
        }
        if (this.lVL != null) {
            this.lVL.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dEl().RG("PB");
        cwH();
    }

    private void cwH() {
        if (this.iLy != null) {
            this.iLy.destory();
            this.iLy = null;
        }
    }

    public boolean doH() {
        return (this.lUP == null || this.lUP.equals("0") || this.lUP.length() == 0) ? LoadData() : doL();
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
        this.lVK.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.lVL == null) {
                this.lVL = new GetSugMatchWordsModel(this.iKt.getPageContext());
            }
            this.lVL.b(aVar);
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
    public boolean FR(int i) {
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
        FS(i);
        final com.baidu.tieba.pb.data.f pbData = aj.dpS().getPbData();
        if (pbData != null && pbData.dkZ() != null) {
            pbData.dkZ().ni(0);
            this.lUU = aj.dpS().dov();
            this.lUS = aj.dpS().dpX();
            this.lUW = aj.dpS().dpY();
            this.lVP = aj.dpS().dpW();
            this.lVQ = aj.dpS().dpV();
            this.lVR = aj.dpS().dpU();
            this.lVT = aj.dpS().dpZ();
            this.mTabIndex = aj.dpS().dps();
            this.lVM = this.lUS;
            if (this.lUS || this.isFromMark) {
                this.lVs = false;
            }
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.lVw) {
            a(doQ(), true, this.lUP, 3);
        }
        if (i == 3 && !this.lVw) {
            if (this.isFromMark) {
                a(doQ(), true, this.lUP, 3);
            } else {
                a(doQ(), false, this.lUP, 3);
            }
        }
        this.lVw = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.lVV == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.fAA);
        if (this.lUS || this.isFromMark) {
            this.lVs = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.lUN == null || this.lUN.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.lUN, 0L));
        if (com.baidu.tbadk.a.d.biZ()) {
            pbPageRequestMessage.setFloorSortType(1);
            pbPageRequestMessage.setFloor_rn(com.baidu.tbadk.a.d.bji());
            pbPageRequestMessage.set_rn(15);
        } else {
            pbPageRequestMessage.set_rn(30);
        }
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(av.bsS().bsT() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.lUU) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.lUS) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.lVh) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.lVg));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.lVs) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.lVo, 0));
            pbPageRequestMessage.setOpMessageID(this.lVg);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> dlb = this.lOq.dlb();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lVb - 1));
                        if (this.lVb - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.lVe) {
                                if (dlb != null && dlb.size() > 0) {
                                    size = dlb.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = dlb.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.lUP = postData.getId();
                                            if (StringUtils.isNull(this.lUP)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.lVa + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.lUP == null && this.lUP.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lUP, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lVa + 1));
                        if (this.lVa >= this.lVc) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (dlb != null) {
                                size = dlb.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.lUP == null) {
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
                if (dlb != null) {
                }
                if (this.lUP == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (dlb != null && dlb.size() > 0 && dlb.get(0) != null) {
                    this.lUP = dlb.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (dpl()) {
                        if (this.lVb - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.lVb - 1));
                        }
                    } else if (this.lVa < this.lVc) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lVa + 1));
                    }
                }
                if (this.lUP != null && this.lUP.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lUP, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.lUS) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (dpl()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.lVc > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lVc));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lUP, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.lUZ));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.lVM && !this.lUS) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lUP, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.lUS) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.lVA);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lVO, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.lVM = this.lUS;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(doQ());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.lVN));
        pbPageRequestMessage.setIsSubPostDataReverse(this.lVz);
        pbPageRequestMessage.setFromSmartFrs(this.lVC ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.lUR);
        if (this.lVN == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        if (this.lVN == 7 || this.lVN == 5 || this.lWc) {
            pbPageRequestMessage.setSourceType(1);
        } else {
            pbPageRequestMessage.setSourceType(2);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.lWb)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.lWb));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.lVc) {
                    i4 = -1;
                } else {
                    i4 = dpt();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = dpt();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.lUN);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean dmi() {
        switch (dpe()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().dkZ() == null || !getPbData().dkZ().bpp();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dmj()) && com.baidu.tieba.recapp.r.dDm().dDg() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dDm().dDg().ba(dmj(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dDm().dDg().bb(dmj(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dmj()) && com.baidu.tieba.recapp.r.dDm().dDg() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dDm().dDg().bb(dmj(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dDm().dDg().ba(dmj(), true));
        }
    }

    protected void FS(int i) {
        boolean z = false;
        FX(i);
        ArrayList<PostData> dlb = this.lOq.dlb();
        this.lVv = false;
        if (i == 1) {
            boolean z2 = false;
            while (dlb.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dlb.remove(0);
                z2 = true;
            }
            if (z2) {
                this.lOq.getPage().ne(1);
                if (this.lVn != null) {
                    this.lVn.e(this.lOq);
                }
            }
            this.jEq = System.currentTimeMillis();
            this.lVv = true;
        } else if (i == 2) {
            while (dlb.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dlb.remove(dlb.size() - 1);
                z = true;
            }
            if (z) {
                this.lOq.getPage().nd(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.lVD = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.lVV != null && this.lVV.bMv()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlr() != null && fVar.dlr().dNl() != null && fVar.dlr().dNl().goods != null && fVar.dlr().bMv() && fVar.dlr().dNl().goods.goods_style != 1001) {
            this.lVV = fVar.dlr();
        }
    }

    public com.baidu.tieba.tbadkCore.data.o doI() {
        return this.lVV;
    }

    public void doJ() {
        this.lVV = null;
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
            if (this.lVl || this.lVj || this.lVk) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.dlb().size(); i++) {
                PostData postData = fVar.dlb().get(i);
                for (int i2 = 0; i2 < postData.dNu().size(); i2++) {
                    postData.dNu().get(i2).a(this.iKt.getPageContext(), o.equals(postData.dNu().get(i2).bnQ().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.s dln = fVar.dln();
            if (dln != null && !com.baidu.tbadk.core.util.y.isEmpty(dln.lLH)) {
                for (PostData postData2 : dln.lLH) {
                    for (int i3 = 0; i3 < postData2.dNu().size(); i3++) {
                        postData2.dNu().get(i3).a(this.iKt.getPageContext(), o.equals(postData2.dNu().get(i3).bnQ().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.s dln = fVar.dln();
            if (dln != null && !com.baidu.tbadk.core.util.y.isEmpty(dln.lLH)) {
                for (PostData postData : dln.lLH.subList(i, dln.lLH.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dNu().size()) {
                            postData.dNu().get(i3).a(this.iKt.getPageContext(), o.equals(postData.dNu().get(i3).bnQ().getUserId()));
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
        cb dkZ = fVar.dkZ();
        dkZ.nn(this.mIsGood);
        dkZ.nm(this.lUX);
        if (this.lUY > 0) {
            dkZ.dM(this.lUY);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.dkZ() != null && fVar.dkZ().bnQ() != null) {
            str = fVar.dkZ().bnQ().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData doK() {
        if (this.lOq == null || this.lOq.dkZ() == null || this.lOq.dkZ().bnQ() == null) {
            return null;
        }
        return this.lOq.dkZ().bnQ();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.lVB = z3;
        if (this.iLy != null && !z3) {
            this.iLy.a(z2, z4, i2, str, i3, j, j2);
            this.iLy = null;
        }
        if (this.lOq != null) {
            this.lOq.lKN = z3;
            this.lOq.aam = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(dmj()) && com.baidu.tieba.recapp.r.dDm().dDg() != null) {
            com.baidu.tieba.recapp.r.dDm().dDg().f(dmj(), FT(doT()), true);
        }
        if (fVar == null || (this.lUZ == 1 && i == 5 && fVar.dlb() != null && fVar.dlb().size() < 1)) {
            if (this.lVn != null) {
                this.lUU = this.lUT;
                if (i2 != 350006) {
                    this.mSortType = this.lUV;
                }
                this.lVn.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.lUT = this.lUU;
            if (i != 8) {
                this.lUV = this.mSortType;
                this.mSortType = fVar.lJZ;
            }
            if (fVar.lJY != null && fVar.lJY.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.iKt.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.lJY = new ArrayList();
                fVar.lJY.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.iKt.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.lJY.add(builder2.build(false));
                this.mSortType = this.lUV;
                fVar.lJZ = this.mSortType;
            }
            this.lVh = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.lVc = this.lVc < 1 ? 1 : this.lVc;
            int i6 = 0;
            ArrayList<PostData> dlb = this.lOq.dlb();
            switch (i) {
                case 1:
                    this.lOq.a(fVar.getPage(), 1);
                    d(fVar, dlb);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.dlb() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.dlb().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dlb, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dlb(), com.baidu.tbadk.core.util.y.getCount(fVar.dlb()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.dlb().remove(postData2);
                            i5 = size2 - 1;
                        }
                        dlb.addAll(0, fVar.dlb());
                    }
                    p(fVar);
                    this.lOq.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().nb(fVar.getPage().bmA());
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
                    if (fVar != null && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dlb()) && this.lOq != null && (!this.lUS || o(fVar).equals(fVar.dlb().get(0).bnQ().getUserId()))) {
                        if (this.lOq.getPage().bmF() == 0) {
                            this.lOq.getPage().nd(1);
                        }
                        dpf();
                        this.lVP = fVar.dlb().get(0);
                        if (dpl() || this.lOq.dlC()) {
                            if (this.lOq.dlb().size() - this.lVR >= 3) {
                                this.lVQ = new PostData();
                                this.lVQ.nwY = true;
                                this.lVQ.setPostType(53);
                                this.lOq.dlb().add(this.lVQ);
                            }
                            this.lOq.dlb().add(this.lVP);
                            size = this.lOq.dlb().size() - 1;
                        } else {
                            if (this.lVR - this.lVS >= 3) {
                                this.lVQ = new PostData();
                                this.lVQ.nwY = false;
                                this.lVQ.setPostType(53);
                                this.lOq.dlb().add(0, this.lVQ);
                            }
                            this.lOq.dlb().add(0, this.lVP);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.au.isTaday(com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.lVP.nxl = this.lOq.dlA();
                            com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.lOq != null && this.lOq.dkZ() != null) {
                PraiseData bnB = this.lOq.dkZ().bnB();
                if (this.lWg != null && !bnB.isPriaseDataValid()) {
                    this.lOq.dkZ().a(this.lWg);
                } else {
                    this.lWg = this.lOq.dkZ().bnB();
                    this.lWg.setPostId(this.lOq.dkZ().bog());
                }
                if (fVar.getPage() != null && fVar.getPage().bmD() == 1 && fVar.dkZ() != null && fVar.dkZ().boa() != null && fVar.dkZ().boa().size() > 0) {
                    this.lOq.dkZ().z(fVar.dkZ().boa());
                }
                this.lOq.dkZ().nk(fVar.dkZ().bnH());
                this.lOq.dkZ().nh(fVar.dkZ().getAnchorLevel());
                this.lOq.dkZ().ni(fVar.dkZ().bnx());
                if (this.mThreadType == 33) {
                    this.lOq.dkZ().bnQ().setHadConcerned(fVar.dkZ().bnQ().hadConcerned());
                }
                if (fVar != null && fVar.dkZ() != null) {
                    this.lOq.dkZ().np(fVar.dkZ().boe());
                }
            }
            if (this.lOq != null && this.lOq.getUserData() != null && fVar.getUserData() != null) {
                this.lOq.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.lOq.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().bmD() == 1 && fVar.dlm() != null) {
                this.lOq.f(fVar.dlm());
            }
            if (this.lVB) {
                if (this.lOq.dkZ() != null && this.lOq.dkZ().bnQ() != null && this.lOq.dlb() != null && com.baidu.tbadk.core.util.y.getItem(this.lOq.dlb(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(this.lOq.dlb(), 0);
                    MetaData bnQ = this.lOq.dkZ().bnQ();
                    if (postData3.bnQ() != null && postData3.bnQ().getGodUserData() != null) {
                        if (this.lVq != -1) {
                            bnQ.setFansNum(this.lVq);
                            postData3.bnQ().setFansNum(this.lVq);
                        }
                        if (this.lVr != -1) {
                            bnQ.getGodUserData().setIsLike(this.lVr == 1);
                            postData3.bnQ().getGodUserData().setIsLike(this.lVr == 1);
                            bnQ.getGodUserData().setIsFromNetWork(false);
                            postData3.bnQ().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.lOq.lJX = -1;
                this.lOq.lJW = -1;
            }
            if (this.lVn != null) {
                this.lVn.a(true, getErrorCode(), i, i4, this.lOq, this.mErrorString, 1);
            }
        }
        if (this.lOq != null && this.lOq.dkZ() != null && this.lOq.getForum() != null && !this.lOq.dlC()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.iKt.getPageContext();
            historyMessage.threadId = getPbData().dkZ().getId();
            if (this.mIsShareThread && getPbData().dkZ().eTc != null) {
                historyMessage.threadName = getPbData().dkZ().eTc.showText;
            } else {
                historyMessage.threadName = getPbData().dkZ().getTitle();
            }
            if (this.mIsShareThread && !dmi()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = dov();
            historyMessage.threadType = getPbData().dkZ().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.lOq != null) {
            this.lOq.dlq().clear();
            this.lOq.dlq().addAll(fVar.dlq());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aY;
        if (arrayList != null && fVar.dlb() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dlb(), 0);
            if (postData != null && (aY = aY(arrayList)) != null && aY.equals(postData.getId())) {
                fVar.dlb().remove(postData);
            }
            this.lOq.lKM = arrayList.size();
            arrayList.addAll(fVar.dlb());
        }
    }

    private int FT(int i) {
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
            fVar.Pl(this.lOq.dlu());
            if (!this.lOq.lKK && fVar.lKK && this.lOq.dlj() != null) {
                fVar.e(this.lOq.dlj());
            }
            this.lOq = fVar;
            FQ(fVar.getPage().bmD());
        }
    }

    public boolean doL() {
        if (this.lUN == null || this.lUP == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return FR(4);
        }
        return FR(6);
    }

    public boolean vm(boolean z) {
        if (this.lUN == null || this.lOq == null) {
            return false;
        }
        if (z || this.lOq.getPage().bmF() != 0) {
            return FR(1);
        }
        return false;
    }

    public boolean vn(boolean z) {
        if (this.lUN == null || this.lOq == null) {
            return false;
        }
        if ((z || this.lOq.getPage().bmG() != 0) && this.lOq.dlb() != null && this.lOq.dlb().size() >= 1) {
            return FR(2);
        }
        return false;
    }

    public boolean Py(String str) {
        this.lUS = !this.lUS;
        this.lUP = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("pb_onlyowner_click").ap("obj_source", 0));
        if (FR(6)) {
            return true;
        }
        this.lUS = this.lUS ? false : true;
        return false;
    }

    public boolean J(boolean z, String str) {
        if (this.lUS == z) {
            return false;
        }
        this.lUS = z;
        this.lUP = str;
        if (this.mSortType == 2) {
            this.lUP = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("pb_onlyowner_click").ap("obj_source", 1));
        }
        if (FR(6)) {
            return true;
        }
        this.lUS = z ? false : true;
        return false;
    }

    public boolean FU(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_pb_current_sort_type", i);
        }
        this.lUT = this.lUU;
        this.lUV = this.mSortType;
        this.mSortType = i;
        this.lUU = !this.lUU;
        if (i == 2 && this.isFromMark) {
            this.lUP = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.lUU = this.lUU ? false : true;
            this.mSortType = this.lUV;
            return false;
        }
        return true;
    }

    public boolean doM() {
        return dpl();
    }

    public int doN() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.lOq == null || this.lOq.getForum() == null || this.lOq.dkZ() == null) ? false : true;
    }

    public boolean bjZ() {
        if (this.lOq == null) {
            return false;
        }
        return this.lOq.bjZ();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData CT(String str) {
        if (this.lOq == null || this.lOq.dkZ() == null || this.lOq.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.lOq.dkZ().bpp()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.lOq.getForum().getId());
            writeData.setForumName(this.lOq.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.lVN);
        writeData.setThreadId(this.lUN);
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

    public MarkData FV(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.lOq == null) {
            return null;
        }
        ArrayList<PostData> dlb = this.lOq.dlb();
        if (com.baidu.tbadk.core.util.y.isEmpty(dlb)) {
            return null;
        }
        if (dlb.size() > 0 && i >= dlb.size()) {
            i = dlb.size() - 1;
        }
        return o(dlb.get(i));
    }

    public MarkData doO() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lUN);
        markData.setPostId(this.lOq.bjY());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lUS);
        markData.setSequence(Boolean.valueOf(dpl()));
        markData.setId(this.lUN);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lUN);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lUS);
        markData.setSequence(Boolean.valueOf(dpl()));
        markData.setId(this.lUN);
        markData.setFloor(postData.dNx());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.o) postData).isApp());
        }
        return markData;
    }

    public void doP() {
        i.dmW().aU(doQ(), this.isFromMark);
    }

    private String doQ() {
        String doR = (this.lUN == null || this.lUN.equals("0")) ? doR() : this.lUN;
        if (this.lUS) {
            doR = doR + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            doR = doR + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            doR = doR + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return doR + TbadkCoreApplication.getCurrentAccount();
        }
        return doR;
    }

    private String doR() {
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

    public void vo(boolean z) {
        if (this.lOq != null) {
            this.lOq.ja(z);
        }
    }

    public boolean doS() {
        return this.lVs;
    }

    public void a(a aVar) {
        this.lVn = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bBJ() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bBI() {
        return doH();
    }

    public boolean Pz(String str) {
        if (getPbData() == null || getPbData().dkZ() == null || getPbData().dkZ().bnQ() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().dkZ().bnQ().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int doT() {
        return this.mRequestType;
    }

    public void doU() {
        if ("personalize_page".equals(this.mStType)) {
            this.lVy = System.currentTimeMillis() / 1000;
        }
    }

    public void doV() {
        if ("personalize_page".equals(this.mStType) && this.lOq != null && this.lVy != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10754").dR("fid", this.lOq.getForumId()).dR("tid", this.lUN).dR("obj_duration", String.valueOf(currentTimeMillis - this.lVy)).dR(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.lVy = 0L;
        }
    }

    public boolean doW() {
        return this.lVB;
    }

    public int getErrorNo() {
        return this.lVD;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public n doX() {
        return this.lVF;
    }

    public ab doY() {
        return this.lVG;
    }

    public CheckRealNameModel doZ() {
        return this.lVI;
    }

    public AddExperiencedModel dpa() {
        return this.lVJ;
    }

    public String dpb() {
        return this.lVx;
    }

    public void PA(String str) {
        this.lVx = str;
    }

    public boolean dpc() {
        return this.lVC;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lOq != null && this.lOq.dlb() != null && this.lOq.dlb().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lOq.dlb().size();
                for (int i = 0; i < size; i++) {
                    if (this.lOq.dlb().get(i) != null && this.lOq.dlb().get(i).bnQ() != null && currentAccount.equals(this.lOq.dlb().get(i).bnQ().getUserId()) && this.lOq.dlb().get(i).bnQ().getPendantData() != null) {
                        this.lOq.dlb().get(i).bnQ().getPendantData().Ad(nVar.getImgUrl());
                        this.lOq.dlb().get(i).bnQ().getPendantData().ek(nVar.bAG());
                    }
                }
            }
        }
    }

    public String dpd() {
        return this.lVH;
    }

    public int dpe() {
        return this.lVN;
    }

    public void FW(int i) {
        this.lVN = i;
    }

    public void PB(String str) {
        if ((!this.lUS || Pz(TbadkCoreApplication.getCurrentAccount())) && this.lOq.dlb() != null) {
            this.lOq.getPage().nd(1);
            if (this.lOq.getPage().bmF() == 0) {
                this.lOq.getPage().nd(1);
            }
            this.lVO = str;
            FR(8);
        }
    }

    private void FX(int i) {
        if (i != 8) {
            this.lVO = "";
            if (this.lVP != null) {
                if (i == 1 && this.lOq != null && this.lOq.dlC()) {
                    if (this.lVQ != null) {
                        getPbData().dlb().remove(this.lVQ);
                    }
                } else if (i == 1 && !this.lUU && !com.baidu.tbadk.core.util.y.isEmpty(getPbData().dlb())) {
                    getPbData().dlb().remove(this.lVP);
                    if (this.lVQ != null) {
                        getPbData().dlb().remove(this.lVQ);
                    }
                    getPbData().dlb().add(0, this.lVP);
                } else {
                    getPbData().dlb().remove(this.lVP);
                    if (this.lVQ != null) {
                        getPbData().dlb().remove(this.lVQ);
                    }
                }
            }
            this.lVQ = null;
        }
    }

    public void dpf() {
        if (this.lOq != null && !com.baidu.tbadk.core.util.y.isEmpty(this.lOq.dlb())) {
            if (this.lVQ != null) {
                this.lOq.dlb().remove(this.lVQ);
                this.lVQ = null;
            }
            if (this.lVP != null) {
                this.lOq.dlb().remove(this.lVP);
                this.lVP = null;
            }
        }
    }

    public void cZ(int i, int i2) {
        this.lVR = i;
        this.lVS = i2;
    }

    public PostData dpg() {
        return this.lVP;
    }

    public PostData dph() {
        return this.lVQ;
    }

    public int dpi() {
        return this.lVR;
    }

    public int dpj() {
        return this.lVS;
    }

    public String dpk() {
        return this.lVU;
    }

    public void PC(String str) {
        this.lVU = str;
    }

    private boolean dpl() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean dpm() {
        return this.lVN == 13 || this.lVN == 12 || this.lVN == 7 || this.lVN == 23 || this.lVN == 24;
    }

    public String dpn() {
        return this.lVX;
    }

    public String dpo() {
        return this.lVY;
    }

    public String dpp() {
        return this.lVZ;
    }

    public String dpq() {
        return this.lWa;
    }

    public Rect dpr() {
        Rect rect = this.lVT;
        this.lVT = null;
        return rect;
    }

    public int dps() {
        return this.mTabIndex;
    }

    private int dpt() {
        int i;
        int i2 = 0;
        if (getPbData().dlb() == null) {
            return 0;
        }
        ArrayList<PostData> dlb = getPbData().dlb();
        int size = dlb.size() - 1;
        while (size >= 0) {
            PostData postData = dlb.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
                if (postData.getType() != AdvertAppInfo.eLf) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return dlb.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
