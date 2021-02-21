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
    private BaseFragmentActivity iKH;
    private com.baidu.tieba.tbadkCore.d.b iLM;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private long jEE;
    protected com.baidu.tieba.pb.data.f lOF;
    private boolean lVA;
    private boolean lVB;
    private a lVC;
    private String lVD;
    private String lVE;
    private int lVF;
    private int lVG;
    private boolean lVH;
    private boolean lVI;
    private boolean lVJ;
    private boolean lVK;
    private boolean lVL;
    private String lVM;
    private long lVN;
    private boolean lVO;
    private int lVP;
    private boolean lVQ;
    private boolean lVR;
    private int lVS;
    private final z lVT;
    private final n lVU;
    private final ab lVV;
    private String lVW;
    private final CheckRealNameModel lVX;
    private final AddExperiencedModel lVY;
    private SuggestEmotionModel lVZ;
    protected String lVc;
    private String lVd;
    private String lVe;
    private String lVf;
    private boolean lVg;
    private boolean lVh;
    private boolean lVi;
    private boolean lVj;
    private int lVk;
    private boolean lVl;
    private int lVm;
    private long lVn;
    private int lVo;
    private int lVp;
    private int lVq;
    private int lVr;
    private boolean lVs;
    private boolean lVt;
    private boolean lVu;
    private long lVv;
    private boolean lVw;
    private String lVx;
    private boolean lVy;
    private boolean lVz;
    private GetSugMatchWordsModel lWa;
    private boolean lWb;
    private int lWc;
    private String lWd;
    private PostData lWe;
    private PostData lWf;
    private int lWg;
    private int lWh;
    private Rect lWi;
    private String lWj;
    private com.baidu.tieba.tbadkCore.data.o lWk;
    private boolean lWl;
    private String lWm;
    private String lWn;
    private String lWo;
    private String lWp;
    private String lWq;
    private boolean lWr;
    private f.a lWs;
    private CustomMessageListener lWt;
    private com.baidu.adp.framework.listener.a lWu;
    private PraiseData lWv;
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
    private static final int lVb = com.baidu.tbadk.data.e.getPbListItemMaxNum() / 30;
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
        this.lVc = null;
        this.isPrivacy = false;
        this.lVd = null;
        this.lVe = null;
        this.mForumId = null;
        this.lVf = null;
        this.lVg = false;
        this.lVh = false;
        this.lVi = true;
        this.lVj = true;
        this.mSortType = 0;
        this.lVk = 0;
        this.lVl = false;
        this.mIsGood = 0;
        this.lVm = 0;
        this.lVn = 0L;
        this.lVo = 1;
        this.lVp = 1;
        this.lVq = 1;
        this.lVr = 1;
        this.isAd = false;
        this.eUg = false;
        this.eTD = false;
        this.lVs = false;
        this.isFromMark = false;
        this.lVt = false;
        this.lVu = false;
        this.lVv = 0L;
        this.lVw = false;
        this.lVx = null;
        this.lOF = null;
        this.isLoading = false;
        this.lVy = false;
        this.lVz = false;
        this.lVA = false;
        this.lVB = false;
        this.mLocate = null;
        this.mContext = null;
        this.lVC = null;
        this.opType = null;
        this.opUrl = null;
        this.lVD = null;
        this.lVE = null;
        this.lVF = -1;
        this.lVG = -1;
        this.iLM = null;
        this.lVI = false;
        this.lVJ = false;
        this.postID = null;
        this.lVM = null;
        this.lVN = 0L;
        this.lVO = false;
        this.lVP = -1;
        this.lVR = false;
        this.lWb = false;
        this.lWc = 0;
        this.mTabIndex = 0;
        this.lWl = false;
        this.lWt = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.lWu = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.iKH.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.lVI || !PbModel.this.lVJ) {
                        if (!PbModel.this.lVI) {
                            PbModel.this.lVI = true;
                        } else {
                            PbModel.this.lVJ = true;
                        }
                        if (PbModel.this.lVC != null) {
                            PbModel.this.lVC.a(PbModel.this.dov(), z, responsedMessage, PbModel.this.lVK, System.currentTimeMillis() - PbModel.this.jEE);
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
                    if (PbModel.this.lOF != null && PbModel.this.lOF.dlf() != null && PbModel.this.lOF.dlf().getForumId() != null && PbModel.this.lOF.dlf().getForumId().equals(valueOf)) {
                        PbModel.this.lOF.dlf().setIsLike(false);
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
                    if (PbModel.this.lOF != null && PbModel.this.lOF.dlf() != null && PbModel.this.lOF.dlf().getForumId() != null && PbModel.this.lOF.dlf().getForumId().equals(valueOf)) {
                        PbModel.this.lOF.dlf().setIsLike(true);
                    }
                }
            }
        };
        this.lWv = null;
        registerListener(this.lWu);
        registerListener(this.lWt);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.lOF = new com.baidu.tieba.pb.data.f();
        this.lOF.Fu(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.iKH = baseFragmentActivity;
        this.lVT = new z(this, this.iKH);
        this.lVU = new n(this, this.iKH);
        this.lVV = new ab(this, this.iKH);
        this.lVX = new CheckRealNameModel(this.iKH.getPageContext());
        this.lVZ = new SuggestEmotionModel();
        this.lVY = new AddExperiencedModel(this.iKH.getPageContext());
        this.lWs = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void onCallBack(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eDM) instanceof String) {
                        PbModel.this.lVc = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eDM);
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
        this.lVL = true;
        if (fVar != null && fVar.lKo == null) {
            q(fVar);
            l(fVar);
            if (fVar.dlg() != null) {
                fVar.dlg().ni(0);
            }
            if (this.lVC != null && fVar != null) {
                this.lVC.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int dov() {
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
            this.lVc = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.lWq = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            this.lWr = false;
            if (com.baidu.tbadk.BdToken.f.r(uri)) {
                this.lWr = true;
                com.baidu.tbadk.BdToken.f.bhH().c(uri, this.lWs);
            } else if (StringUtils.isNull(this.lVc)) {
                this.lWr = true;
                this.lVT.a(intent, this.lWs);
                if (uri != null) {
                    if (StringUtils.isNull(this.lVc)) {
                        this.lVc = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.au.isEmpty(this.lVc)) {
                this.lVc = "0";
            }
            this.lWc = intent.getIntExtra("key_start_from", 0);
            if (this.lWc == 0) {
                this.lWc = this.lVT.aJY;
            }
            this.lVe = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.lVd = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.lVg = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.lVh = intent.getBooleanExtra("host_only", false);
            this.lVj = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.lVe = this.mSortType == 2 ? "0" : this.lVe;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.lVm = intent.getIntExtra("is_top", 0);
            this.lVn = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.lVt = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.lVu = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.eUg = intent.getBooleanExtra("is_sub_pb", false);
            this.lVw = intent.getBooleanExtra("is_pv", false);
            this.lVv = intent.getLongExtra("msg_id", 0L);
            this.lVx = intent.getStringExtra("from_forum_name");
            this.lVE = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.lVD = intent.getStringExtra("op_stat");
            this.lVy = intent.getBooleanExtra("is_from_thread_config", false);
            this.lVz = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.lVA = intent.getBooleanExtra("is_from_my_god_config", false);
            this.lVG = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.lVF = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.eTD = intent.getBooleanExtra("from_frs", false);
            this.lVs = intent.getBooleanExtra("from_maintab", false);
            this.lVR = intent.getBooleanExtra("from_smart_frs", false);
            this.lVB = intent.getBooleanExtra("from_hottopic", false);
            this.lVW = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.lVf = intent.getStringExtra("high_light_post_id");
            this.lWl = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.lVH = intent.getIntExtra("request_code", -1) == 18003;
            this.lWm = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.lWn = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.lWo = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.lWp = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean dow() {
        return this.lWl && com.baidu.tieba.frs.l.cCq() != null && com.baidu.tieba.frs.l.cCq().equals(this.lVc) && com.baidu.tieba.frs.l.cCp() != null;
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
        postData.c(TbRichTextView.a(this.mContext, cbVar.bnG(), doA(), false));
        fVar.d(postData);
        fVar.dli().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.p(cbVar, null));
        fVar.lKt = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.lWc = bundle.getInt("key_start_from", 0);
        this.lVc = bundle.getString("thread_id");
        this.lVe = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.lVd = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.lVg = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.lVh = bundle.getBoolean("host_only", false);
        this.lVj = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.lVm = bundle.getInt("is_top", 0);
        this.lVn = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.lVu = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eUg = bundle.getBoolean("is_sub_pb", false);
        this.lVw = bundle.getBoolean("is_pv", false);
        this.lVv = bundle.getLong("msg_id", 0L);
        this.lVx = bundle.getString("from_forum_name");
        this.lVE = bundle.getString("extra_pb_cache_key");
        this.lVy = bundle.getBoolean("is_from_thread_config", false);
        this.lVz = bundle.getBoolean("is_from_interview_live_config", false);
        this.lVA = bundle.getBoolean("is_from_my_god_config", false);
        this.lVG = bundle.getInt("extra_pb_is_attention_key", -1);
        this.lVF = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eTD = bundle.getBoolean("from_frs", false);
        this.lVs = bundle.getBoolean("from_maintab", false);
        this.lVR = bundle.getBoolean("from_smart_frs", false);
        this.lVB = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.lVf = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.lVH = bundle.getInt("request_code", -1) == 18003;
        this.lWm = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.lWn = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.lWo = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.lWp = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aD(Bundle bundle) {
        bundle.putString("thread_id", this.lVc);
        bundle.putString("post_id", this.lVe);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.lWc);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.lVg);
        bundle.putBoolean("host_only", this.lVh);
        bundle.putBoolean("squence", this.lVj);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.lVm);
        bundle.putLong("thread_time", this.lVn);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.lVu);
        bundle.putBoolean("is_sub_pb", this.eUg);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.lVw);
        bundle.putLong("msg_id", this.lVv);
        bundle.putString("extra_pb_cache_key", this.lVE);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.lVy);
        bundle.putBoolean("is_from_interview_live_config", this.lVz);
        bundle.putBoolean("is_from_my_god_config", this.lVA);
        bundle.putInt("extra_pb_is_attention_key", this.lVG);
        bundle.putInt("extra_pb_funs_count_key", this.lVF);
        bundle.putBoolean("from_frs", this.eTD);
        bundle.putBoolean("from_maintab", this.lVs);
        bundle.putBoolean("from_smart_frs", this.lVR);
        bundle.putBoolean("from_hottopic", this.lVB);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.lVf);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.lWm);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.lWn);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.lWo);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.lWp);
    }

    public String dox() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.lVc);
        if (!this.lVu) {
            sb.append(this.lVe);
        }
        sb.append(this.lVh);
        sb.append(this.lVj);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.lVm);
        sb.append(this.lVn);
        sb.append(this.eTD);
        sb.append(this.lVs);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eUg);
        sb.append(this.lVw);
        sb.append(this.lVv);
        sb.append(this.lVx);
        sb.append(this.mThreadType);
        sb.append(this.lVy);
        sb.append(this.lVz);
        sb.append(this.lVA);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.lVE != null) {
            sb.append(this.lVE);
        }
        return sb.toString();
    }

    public String dmq() {
        return this.lVx;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String doy() {
        return this.lVe;
    }

    public String doz() {
        return this.lVf;
    }

    public String doA() {
        return this.lVc;
    }

    public String doB() {
        return (StringUtils.isNull(this.lVc) || "0".equals(this.lVc)) ? this.oriUgcNid : this.lVc;
    }

    public boolean getHostMode() {
        return this.lVh;
    }

    public boolean doC() {
        return dps();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean doD() {
        return this.eTD;
    }

    public boolean doE() {
        return this.lVl;
    }

    public boolean doF() {
        return this.lVs;
    }

    public boolean doG() {
        return this.lVB;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean doH() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int cvp() {
        return this.lVm;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void FO(int i) {
        this.lVm = i;
    }

    public boolean doI() {
        return this.eUg;
    }

    public boolean doJ() {
        if (this.lOF == null) {
            return false;
        }
        return this.lOF.isValid();
    }

    public String bnY() {
        if (this.lOF == null || !this.lOF.bjZ()) {
            return null;
        }
        return this.lOF.bjY();
    }

    public boolean FP(int i) {
        this.lVo = i;
        if (this.lVo > this.lOF.getPage().bmA()) {
            this.lVo = this.lOF.getPage().bmA();
        }
        if (this.lVo < 1) {
            this.lVo = 1;
        }
        if (this.lVc == null) {
            return false;
        }
        return FR(5);
    }

    public void FQ(int i) {
        this.lVo = i;
        this.lVp = i;
        this.lVq = i;
    }

    public void b(az azVar) {
        if (azVar == null) {
            FQ(1);
            return;
        }
        if (this.lVp < azVar.bmD()) {
            this.lVp = azVar.bmD();
        }
        if (this.lVq > azVar.bmD()) {
            this.lVq = azVar.bmD();
        }
        this.lVr = azVar.bmA();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.lOF;
    }

    public BaijiahaoData doK() {
        if (this.lOF == null || this.lOF.dlg() == null) {
            return null;
        }
        return this.lOF.dlg().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f doL() {
        if (this.lOF == null) {
            return this.lOF;
        }
        if (!doM() && this.lWk != null) {
            this.lOF.b(this.lWk);
        }
        return this.lOF;
    }

    private boolean doM() {
        return (this.lOF.dly() == null || this.lOF.dly().dNt() == null || this.lOF.dly().dNt().goods != null || this.lOF.dly().dNt().goods.goods_style == 1001) ? false : true;
    }

    public az getPageData() {
        if (this.lOF == null) {
            return null;
        }
        return this.lOF.getPage();
    }

    public boolean doN() {
        if (dps() && this.lOF.getPage().bmF() == 0) {
            vm(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.lVc = fVar.getThreadId();
            if (fVar.dlg() != null && fVar.dlg().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.dlg().getBaijiahaoData();
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
            this.lVe = null;
            this.lVh = false;
            this.lVj = true;
            LoadData();
        }
    }

    public void Pt(String str) {
        if (!StringUtils.isNull(str)) {
            this.lVc = str;
            this.lVe = null;
            this.lVh = false;
            this.lVj = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lVc == null) {
            return false;
        }
        cancelLoadData();
        if (this.iLM == null) {
            this.iLM = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.iLM.start();
        }
        boolean FR = FR(3);
        if (this.opType != null) {
            this.opType = null;
            this.lVD = null;
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
        if (this.lVZ != null) {
            this.lVZ.cancelLoadData();
        }
        if (this.lWa != null) {
            this.lWa.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dEt().RS("PB");
        cwO();
    }

    private void cwO() {
        if (this.iLM != null) {
            this.iLM.destory();
            this.iLM = null;
        }
    }

    public boolean doO() {
        return (this.lVe == null || this.lVe.equals("0") || this.lVe.length() == 0) ? LoadData() : doS();
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
        this.lVZ.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.lWa == null) {
                this.lWa = new GetSugMatchWordsModel(this.iKH.getPageContext());
            }
            this.lWa.b(aVar);
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
        final com.baidu.tieba.pb.data.f pbData = aj.dpZ().getPbData();
        if (pbData != null && pbData.dlg() != null) {
            pbData.dlg().ni(0);
            this.lVj = aj.dpZ().doC();
            this.lVh = aj.dpZ().dqe();
            this.lVl = aj.dpZ().dqf();
            this.lWe = aj.dpZ().dqd();
            this.lWf = aj.dpZ().dqc();
            this.lWg = aj.dpZ().dqb();
            this.lWi = aj.dpZ().dqg();
            this.mTabIndex = aj.dpZ().dpz();
            this.lWb = this.lVh;
            if (this.lVh || this.isFromMark) {
                this.lVH = false;
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
        if (i == 4 && !this.lVL) {
            a(doX(), true, this.lVe, 3);
        }
        if (i == 3 && !this.lVL) {
            if (this.isFromMark) {
                a(doX(), true, this.lVe, 3);
            } else {
                a(doX(), false, this.lVe, 3);
            }
        }
        this.lVL = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.lWk == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.fAA);
        if (this.lVh || this.isFromMark) {
            this.lVH = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.lVc == null || this.lVc.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.lVc, 0L));
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
        if (!this.lVj) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.lVh) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.lVw) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.lVv));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.lVH) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.lVD, 0));
            pbPageRequestMessage.setOpMessageID(this.lVv);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> dli = this.lOF.dli();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lVq - 1));
                        if (this.lVq - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.lVt) {
                                if (dli != null && dli.size() > 0) {
                                    size = dli.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = dli.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.lVe = postData.getId();
                                            if (StringUtils.isNull(this.lVe)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.lVp + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.lVe == null && this.lVe.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lVe, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lVp + 1));
                        if (this.lVp >= this.lVr) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (dli != null) {
                                size = dli.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.lVe == null) {
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
                if (dli != null) {
                }
                if (this.lVe == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (dli != null && dli.size() > 0 && dli.get(0) != null) {
                    this.lVe = dli.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (dps()) {
                        if (this.lVq - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.lVq - 1));
                        }
                    } else if (this.lVp < this.lVr) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lVp + 1));
                    }
                }
                if (this.lVe != null && this.lVe.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lVe, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.lVh) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (dps()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.lVr > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lVr));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lVe, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.lVo));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.lWb && !this.lVh) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lVe, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.lVh) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.lVP);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lWd, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.lWb = this.lVh;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(doX());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.lWc));
        pbPageRequestMessage.setIsSubPostDataReverse(this.lVO);
        pbPageRequestMessage.setFromSmartFrs(this.lVR ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.lVg);
        if (this.lWc == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        if (this.lWc == 7 || this.lWc == 5 || this.lWr) {
            pbPageRequestMessage.setSourceType(1);
        } else {
            pbPageRequestMessage.setSourceType(2);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.lWq)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.lWq));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.lVr) {
                    i4 = -1;
                } else {
                    i4 = dpA();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = dpA();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.lVc);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean dmp() {
        switch (dpl()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().dlg() == null || !getPbData().dlg().bpp();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dmq()) && com.baidu.tieba.recapp.s.dDt().dDn() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.s.dDt().dDn().ba(dmq(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.s.dDt().dDn().bb(dmq(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dmq()) && com.baidu.tieba.recapp.s.dDt().dDn() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.s.dDt().dDn().bb(dmq(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.s.dDt().dDn().ba(dmq(), true));
        }
    }

    protected void FS(int i) {
        boolean z = false;
        FX(i);
        ArrayList<PostData> dli = this.lOF.dli();
        this.lVK = false;
        if (i == 1) {
            boolean z2 = false;
            while (dli.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dli.remove(0);
                z2 = true;
            }
            if (z2) {
                this.lOF.getPage().ne(1);
                if (this.lVC != null) {
                    this.lVC.e(this.lOF);
                }
            }
            this.jEE = System.currentTimeMillis();
            this.lVK = true;
        } else if (i == 2) {
            while (dli.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dli.remove(dli.size() - 1);
                z = true;
            }
            if (z) {
                this.lOF.getPage().nd(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.lVS = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.lWk != null && this.lWk.bMC()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dly() != null && fVar.dly().dNt() != null && fVar.dly().dNt().goods != null && fVar.dly().bMC() && fVar.dly().dNt().goods.goods_style != 1001) {
            this.lWk = fVar.dly();
        }
    }

    public com.baidu.tieba.tbadkCore.data.o doP() {
        return this.lWk;
    }

    public void doQ() {
        this.lWk = null;
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
            if (this.lVA || this.lVy || this.lVz) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.dli().size(); i++) {
                PostData postData = fVar.dli().get(i);
                for (int i2 = 0; i2 < postData.dNC().size(); i2++) {
                    postData.dNC().get(i2).a(this.iKH.getPageContext(), o.equals(postData.dNC().get(i2).bnQ().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.s dlu = fVar.dlu();
            if (dlu != null && !com.baidu.tbadk.core.util.y.isEmpty(dlu.lLW)) {
                for (PostData postData2 : dlu.lLW) {
                    for (int i3 = 0; i3 < postData2.dNC().size(); i3++) {
                        postData2.dNC().get(i3).a(this.iKH.getPageContext(), o.equals(postData2.dNC().get(i3).bnQ().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.s dlu = fVar.dlu();
            if (dlu != null && !com.baidu.tbadk.core.util.y.isEmpty(dlu.lLW)) {
                for (PostData postData : dlu.lLW.subList(i, dlu.lLW.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dNC().size()) {
                            postData.dNC().get(i3).a(this.iKH.getPageContext(), o.equals(postData.dNC().get(i3).bnQ().getUserId()));
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
        cb dlg = fVar.dlg();
        dlg.nn(this.mIsGood);
        dlg.nm(this.lVm);
        if (this.lVn > 0) {
            dlg.dM(this.lVn);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.dlg() != null && fVar.dlg().bnQ() != null) {
            str = fVar.dlg().bnQ().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData doR() {
        if (this.lOF == null || this.lOF.dlg() == null || this.lOF.dlg().bnQ() == null) {
            return null;
        }
        return this.lOF.dlg().bnQ();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.lVQ = z3;
        if (this.iLM != null && !z3) {
            this.iLM.a(z2, z4, i2, str, i3, j, j2);
            this.iLM = null;
        }
        if (this.lOF != null) {
            this.lOF.lLb = z3;
            this.lOF.aam = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(dmq()) && com.baidu.tieba.recapp.s.dDt().dDn() != null) {
            com.baidu.tieba.recapp.s.dDt().dDn().f(dmq(), FT(dpa()), true);
        }
        if (fVar == null || (this.lVo == 1 && i == 5 && fVar.dli() != null && fVar.dli().size() < 1)) {
            if (this.lVC != null) {
                this.lVj = this.lVi;
                if (i2 != 350006) {
                    this.mSortType = this.lVk;
                }
                this.lVC.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.lVi = this.lVj;
            if (i != 8) {
                this.lVk = this.mSortType;
                this.mSortType = fVar.lKn;
            }
            if (fVar.lKm != null && fVar.lKm.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.iKH.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.lKm = new ArrayList();
                fVar.lKm.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.iKH.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.lKm.add(builder2.build(false));
                this.mSortType = this.lVk;
                fVar.lKn = this.mSortType;
            }
            this.lVw = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.lVr = this.lVr < 1 ? 1 : this.lVr;
            int i6 = 0;
            ArrayList<PostData> dli = this.lOF.dli();
            switch (i) {
                case 1:
                    this.lOF.a(fVar.getPage(), 1);
                    d(fVar, dli);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.dli() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.dli().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dli, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dli(), com.baidu.tbadk.core.util.y.getCount(fVar.dli()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.dli().remove(postData2);
                            i5 = size2 - 1;
                        }
                        dli.addAll(0, fVar.dli());
                    }
                    p(fVar);
                    this.lOF.a(fVar.getPage(), 2);
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
                    if (fVar != null && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dli()) && this.lOF != null && (!this.lVh || o(fVar).equals(fVar.dli().get(0).bnQ().getUserId()))) {
                        if (this.lOF.getPage().bmF() == 0) {
                            this.lOF.getPage().nd(1);
                        }
                        dpm();
                        this.lWe = fVar.dli().get(0);
                        if (dps() || this.lOF.dlJ()) {
                            if (this.lOF.dli().size() - this.lWg >= 3) {
                                this.lWf = new PostData();
                                this.lWf.nxy = true;
                                this.lWf.setPostType(53);
                                this.lOF.dli().add(this.lWf);
                            }
                            this.lOF.dli().add(this.lWe);
                            size = this.lOF.dli().size() - 1;
                        } else {
                            if (this.lWg - this.lWh >= 3) {
                                this.lWf = new PostData();
                                this.lWf.nxy = false;
                                this.lWf.setPostType(53);
                                this.lOF.dli().add(0, this.lWf);
                            }
                            this.lOF.dli().add(0, this.lWe);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.au.isTaday(com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.lWe.nxL = this.lOF.dlH();
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
            if (this.lOF != null && this.lOF.dlg() != null) {
                PraiseData bnB = this.lOF.dlg().bnB();
                if (this.lWv != null && !bnB.isPriaseDataValid()) {
                    this.lOF.dlg().a(this.lWv);
                } else {
                    this.lWv = this.lOF.dlg().bnB();
                    this.lWv.setPostId(this.lOF.dlg().bog());
                }
                if (fVar.getPage() != null && fVar.getPage().bmD() == 1 && fVar.dlg() != null && fVar.dlg().boa() != null && fVar.dlg().boa().size() > 0) {
                    this.lOF.dlg().z(fVar.dlg().boa());
                }
                this.lOF.dlg().nk(fVar.dlg().bnH());
                this.lOF.dlg().nh(fVar.dlg().getAnchorLevel());
                this.lOF.dlg().ni(fVar.dlg().bnx());
                if (this.mThreadType == 33) {
                    this.lOF.dlg().bnQ().setHadConcerned(fVar.dlg().bnQ().hadConcerned());
                }
                if (fVar != null && fVar.dlg() != null) {
                    this.lOF.dlg().np(fVar.dlg().boe());
                }
            }
            if (this.lOF != null && this.lOF.getUserData() != null && fVar.getUserData() != null) {
                this.lOF.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.lOF.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().bmD() == 1 && fVar.dlt() != null) {
                this.lOF.f(fVar.dlt());
            }
            if (this.lVQ) {
                if (this.lOF.dlg() != null && this.lOF.dlg().bnQ() != null && this.lOF.dli() != null && com.baidu.tbadk.core.util.y.getItem(this.lOF.dli(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(this.lOF.dli(), 0);
                    MetaData bnQ = this.lOF.dlg().bnQ();
                    if (postData3.bnQ() != null && postData3.bnQ().getGodUserData() != null) {
                        if (this.lVF != -1) {
                            bnQ.setFansNum(this.lVF);
                            postData3.bnQ().setFansNum(this.lVF);
                        }
                        if (this.lVG != -1) {
                            bnQ.getGodUserData().setIsLike(this.lVG == 1);
                            postData3.bnQ().getGodUserData().setIsLike(this.lVG == 1);
                            bnQ.getGodUserData().setIsFromNetWork(false);
                            postData3.bnQ().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.lOF.lKl = -1;
                this.lOF.lKk = -1;
            }
            if (this.lVC != null) {
                this.lVC.a(true, getErrorCode(), i, i4, this.lOF, this.mErrorString, 1);
            }
        }
        if (this.lOF != null && this.lOF.dlg() != null && this.lOF.getForum() != null && !this.lOF.dlJ()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.iKH.getPageContext();
            historyMessage.threadId = getPbData().dlg().getId();
            if (this.mIsShareThread && getPbData().dlg().eTc != null) {
                historyMessage.threadName = getPbData().dlg().eTc.showText;
            } else {
                historyMessage.threadName = getPbData().dlg().getTitle();
            }
            if (this.mIsShareThread && !dmp()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = doC();
            historyMessage.threadType = getPbData().dlg().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.lOF != null) {
            this.lOF.dlx().clear();
            this.lOF.dlx().addAll(fVar.dlx());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aY;
        if (arrayList != null && fVar.dli() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dli(), 0);
            if (postData != null && (aY = aY(arrayList)) != null && aY.equals(postData.getId())) {
                fVar.dli().remove(postData);
            }
            this.lOF.lLa = arrayList.size();
            arrayList.addAll(fVar.dli());
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
            fVar.Pm(this.lOF.dlB());
            if (!this.lOF.lKY && fVar.lKY && this.lOF.dlq() != null) {
                fVar.e(this.lOF.dlq());
            }
            this.lOF = fVar;
            FQ(fVar.getPage().bmD());
        }
    }

    public boolean doS() {
        if (this.lVc == null || this.lVe == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return FR(4);
        }
        return FR(6);
    }

    public boolean vm(boolean z) {
        if (this.lVc == null || this.lOF == null) {
            return false;
        }
        if (z || this.lOF.getPage().bmF() != 0) {
            return FR(1);
        }
        return false;
    }

    public boolean vn(boolean z) {
        if (this.lVc == null || this.lOF == null) {
            return false;
        }
        if ((z || this.lOF.getPage().bmG() != 0) && this.lOF.dli() != null && this.lOF.dli().size() >= 1) {
            return FR(2);
        }
        return false;
    }

    public boolean Pz(String str) {
        this.lVh = !this.lVh;
        this.lVe = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("pb_onlyowner_click").ap("obj_source", 0));
        if (FR(6)) {
            return true;
        }
        this.lVh = this.lVh ? false : true;
        return false;
    }

    public boolean J(boolean z, String str) {
        if (this.lVh == z) {
            return false;
        }
        this.lVh = z;
        this.lVe = str;
        if (this.mSortType == 2) {
            this.lVe = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("pb_onlyowner_click").ap("obj_source", 1));
        }
        if (FR(6)) {
            return true;
        }
        this.lVh = z ? false : true;
        return false;
    }

    public boolean FU(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_pb_current_sort_type", i);
        }
        this.lVi = this.lVj;
        this.lVk = this.mSortType;
        this.mSortType = i;
        this.lVj = !this.lVj;
        if (i == 2 && this.isFromMark) {
            this.lVe = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.lVj = this.lVj ? false : true;
            this.mSortType = this.lVk;
            return false;
        }
        return true;
    }

    public boolean doT() {
        return dps();
    }

    public int doU() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.lOF == null || this.lOF.getForum() == null || this.lOF.dlg() == null) ? false : true;
    }

    public boolean bjZ() {
        if (this.lOF == null) {
            return false;
        }
        return this.lOF.bjZ();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData CR(String str) {
        if (this.lOF == null || this.lOF.dlg() == null || this.lOF.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.lOF.dlg().bpp()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.lOF.getForum().getId());
            writeData.setForumName(this.lOF.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.lWc);
        writeData.setThreadId(this.lVc);
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
        if (this.lOF == null) {
            return null;
        }
        ArrayList<PostData> dli = this.lOF.dli();
        if (com.baidu.tbadk.core.util.y.isEmpty(dli)) {
            return null;
        }
        if (dli.size() > 0 && i >= dli.size()) {
            i = dli.size() - 1;
        }
        return o(dli.get(i));
    }

    public MarkData doV() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lVc);
        markData.setPostId(this.lOF.bjY());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lVh);
        markData.setSequence(Boolean.valueOf(dps()));
        markData.setId(this.lVc);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lVc);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lVh);
        markData.setSequence(Boolean.valueOf(dps()));
        markData.setId(this.lVc);
        markData.setFloor(postData.dNF());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.o) postData).isApp());
        }
        return markData;
    }

    public void doW() {
        i.dnd().aU(doX(), this.isFromMark);
    }

    private String doX() {
        String doY = (this.lVc == null || this.lVc.equals("0")) ? doY() : this.lVc;
        if (this.lVh) {
            doY = doY + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            doY = doY + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            doY = doY + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return doY + TbadkCoreApplication.getCurrentAccount();
        }
        return doY;
    }

    private String doY() {
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
        if (this.lOF != null) {
            this.lOF.ja(z);
        }
    }

    public boolean doZ() {
        return this.lVH;
    }

    public void a(a aVar) {
        this.lVC = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bBJ() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bBI() {
        return doO();
    }

    public boolean PA(String str) {
        if (getPbData() == null || getPbData().dlg() == null || getPbData().dlg().bnQ() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().dlg().bnQ().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int dpa() {
        return this.mRequestType;
    }

    public void dpb() {
        if ("personalize_page".equals(this.mStType)) {
            this.lVN = System.currentTimeMillis() / 1000;
        }
    }

    public void dpc() {
        if ("personalize_page".equals(this.mStType) && this.lOF != null && this.lVN != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10754").dR("fid", this.lOF.getForumId()).dR("tid", this.lVc).dR("obj_duration", String.valueOf(currentTimeMillis - this.lVN)).dR(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.lVN = 0L;
        }
    }

    public boolean dpd() {
        return this.lVQ;
    }

    public int getErrorNo() {
        return this.lVS;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public n dpe() {
        return this.lVU;
    }

    public ab dpf() {
        return this.lVV;
    }

    public CheckRealNameModel dpg() {
        return this.lVX;
    }

    public AddExperiencedModel dph() {
        return this.lVY;
    }

    public String dpi() {
        return this.lVM;
    }

    public void PB(String str) {
        this.lVM = str;
    }

    public boolean dpj() {
        return this.lVR;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lOF != null && this.lOF.dli() != null && this.lOF.dli().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lOF.dli().size();
                for (int i = 0; i < size; i++) {
                    if (this.lOF.dli().get(i) != null && this.lOF.dli().get(i).bnQ() != null && currentAccount.equals(this.lOF.dli().get(i).bnQ().getUserId()) && this.lOF.dli().get(i).bnQ().getPendantData() != null) {
                        this.lOF.dli().get(i).bnQ().getPendantData().Ad(nVar.getImgUrl());
                        this.lOF.dli().get(i).bnQ().getPendantData().ek(nVar.bAG());
                    }
                }
            }
        }
    }

    public String dpk() {
        return this.lVW;
    }

    public int dpl() {
        return this.lWc;
    }

    public void FW(int i) {
        this.lWc = i;
    }

    public void PC(String str) {
        if ((!this.lVh || PA(TbadkCoreApplication.getCurrentAccount())) && this.lOF.dli() != null) {
            this.lOF.getPage().nd(1);
            if (this.lOF.getPage().bmF() == 0) {
                this.lOF.getPage().nd(1);
            }
            this.lWd = str;
            FR(8);
        }
    }

    private void FX(int i) {
        if (i != 8) {
            this.lWd = "";
            if (this.lWe != null) {
                if (i == 1 && this.lOF != null && this.lOF.dlJ()) {
                    if (this.lWf != null) {
                        getPbData().dli().remove(this.lWf);
                    }
                } else if (i == 1 && !this.lVj && !com.baidu.tbadk.core.util.y.isEmpty(getPbData().dli())) {
                    getPbData().dli().remove(this.lWe);
                    if (this.lWf != null) {
                        getPbData().dli().remove(this.lWf);
                    }
                    getPbData().dli().add(0, this.lWe);
                } else {
                    getPbData().dli().remove(this.lWe);
                    if (this.lWf != null) {
                        getPbData().dli().remove(this.lWf);
                    }
                }
            }
            this.lWf = null;
        }
    }

    public void dpm() {
        if (this.lOF != null && !com.baidu.tbadk.core.util.y.isEmpty(this.lOF.dli())) {
            if (this.lWf != null) {
                this.lOF.dli().remove(this.lWf);
                this.lWf = null;
            }
            if (this.lWe != null) {
                this.lOF.dli().remove(this.lWe);
                this.lWe = null;
            }
        }
    }

    public void da(int i, int i2) {
        this.lWg = i;
        this.lWh = i2;
    }

    public PostData dpn() {
        return this.lWe;
    }

    public PostData dpo() {
        return this.lWf;
    }

    public int dpp() {
        return this.lWg;
    }

    public int dpq() {
        return this.lWh;
    }

    public String dpr() {
        return this.lWj;
    }

    public void PD(String str) {
        this.lWj = str;
    }

    private boolean dps() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean dpt() {
        return this.lWc == 13 || this.lWc == 12 || this.lWc == 7 || this.lWc == 23 || this.lWc == 24;
    }

    public String dpu() {
        return this.lWm;
    }

    public String dpv() {
        return this.lWn;
    }

    public String dpw() {
        return this.lWo;
    }

    public String dpx() {
        return this.lWp;
    }

    public Rect dpy() {
        Rect rect = this.lWi;
        this.lWi = null;
        return rect;
    }

    public int dpz() {
        return this.mTabIndex;
    }

    private int dpA() {
        int i;
        int i2 = 0;
        if (getPbData().dli() == null) {
            return 0;
        }
        ArrayList<PostData> dli = getPbData().dli();
        int size = dli.size() - 1;
        while (size >= 0) {
            PostData postData = dli.get(size);
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
        return dli.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
