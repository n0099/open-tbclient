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
    private boolean eVF;
    private boolean eVe;
    private BaseFragmentActivity iMq;
    private com.baidu.tieba.tbadkCore.d.b iNv;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private long jGn;
    protected com.baidu.tieba.pb.data.f lQH;
    private boolean lXA;
    private boolean lXB;
    private boolean lXC;
    private boolean lXD;
    private a lXE;
    private String lXF;
    private String lXG;
    private int lXH;
    private int lXI;
    private boolean lXJ;
    private boolean lXK;
    private boolean lXL;
    private boolean lXM;
    private boolean lXN;
    private String lXO;
    private long lXP;
    private boolean lXQ;
    private int lXR;
    private boolean lXS;
    private boolean lXT;
    private int lXU;
    private final z lXV;
    private final n lXW;
    private final ab lXX;
    private String lXY;
    private final CheckRealNameModel lXZ;
    protected String lXe;
    private String lXf;
    private String lXg;
    private String lXh;
    private boolean lXi;
    private boolean lXj;
    private boolean lXk;
    private boolean lXl;
    private int lXm;
    private boolean lXn;
    private int lXo;
    private long lXp;
    private int lXq;
    private int lXr;
    private int lXs;
    private int lXt;
    private boolean lXu;
    private boolean lXv;
    private boolean lXw;
    private long lXx;
    private boolean lXy;
    private String lXz;
    private final AddExperiencedModel lYa;
    private SuggestEmotionModel lYb;
    private GetSugMatchWordsModel lYc;
    private boolean lYd;
    private int lYe;
    private String lYf;
    private PostData lYg;
    private PostData lYh;
    private int lYi;
    private int lYj;
    private Rect lYk;
    private String lYl;
    private com.baidu.tieba.tbadkCore.data.o lYm;
    private boolean lYn;
    private String lYo;
    private String lYp;
    private String lYq;
    private String lYr;
    private String lYs;
    private boolean lYt;
    private f.a lYu;
    private CustomMessageListener lYv;
    private com.baidu.adp.framework.listener.a lYw;
    private PraiseData lYx;
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
    private static final int lXd = com.baidu.tbadk.data.e.getPbListItemMaxNum() / 30;
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
        this.lXe = null;
        this.isPrivacy = false;
        this.lXf = null;
        this.lXg = null;
        this.mForumId = null;
        this.lXh = null;
        this.lXi = false;
        this.lXj = false;
        this.lXk = true;
        this.lXl = true;
        this.mSortType = 0;
        this.lXm = 0;
        this.lXn = false;
        this.mIsGood = 0;
        this.lXo = 0;
        this.lXp = 0L;
        this.lXq = 1;
        this.lXr = 1;
        this.lXs = 1;
        this.lXt = 1;
        this.isAd = false;
        this.eVF = false;
        this.eVe = false;
        this.lXu = false;
        this.isFromMark = false;
        this.lXv = false;
        this.lXw = false;
        this.lXx = 0L;
        this.lXy = false;
        this.lXz = null;
        this.lQH = null;
        this.isLoading = false;
        this.lXA = false;
        this.lXB = false;
        this.lXC = false;
        this.lXD = false;
        this.mLocate = null;
        this.mContext = null;
        this.lXE = null;
        this.opType = null;
        this.opUrl = null;
        this.lXF = null;
        this.lXG = null;
        this.lXH = -1;
        this.lXI = -1;
        this.iNv = null;
        this.lXK = false;
        this.lXL = false;
        this.postID = null;
        this.lXO = null;
        this.lXP = 0L;
        this.lXQ = false;
        this.lXR = -1;
        this.lXT = false;
        this.lYd = false;
        this.lYe = 0;
        this.mTabIndex = 0;
        this.lYn = false;
        this.lYv = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.lYw = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.iMq.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.lXK || !PbModel.this.lXL) {
                        if (!PbModel.this.lXK) {
                            PbModel.this.lXK = true;
                        } else {
                            PbModel.this.lXL = true;
                        }
                        if (PbModel.this.lXE != null) {
                            PbModel.this.lXE.a(PbModel.this.doE(), z, responsedMessage, PbModel.this.lXM, System.currentTimeMillis() - PbModel.this.jGn);
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
                    if (PbModel.this.lQH != null && PbModel.this.lQH.dlo() != null && PbModel.this.lQH.dlo().getForumId() != null && PbModel.this.lQH.dlo().getForumId().equals(valueOf)) {
                        PbModel.this.lQH.dlo().setIsLike(false);
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
                    if (PbModel.this.lQH != null && PbModel.this.lQH.dlo() != null && PbModel.this.lQH.dlo().getForumId() != null && PbModel.this.lQH.dlo().getForumId().equals(valueOf)) {
                        PbModel.this.lQH.dlo().setIsLike(true);
                    }
                }
            }
        };
        this.lYx = null;
        registerListener(this.lYw);
        registerListener(this.lYv);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.lQH = new com.baidu.tieba.pb.data.f();
        this.lQH.Fx(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.iMq = baseFragmentActivity;
        this.lXV = new z(this, this.iMq);
        this.lXW = new n(this, this.iMq);
        this.lXX = new ab(this, this.iMq);
        this.lXZ = new CheckRealNameModel(this.iMq.getPageContext());
        this.lYb = new SuggestEmotionModel();
        this.lYa = new AddExperiencedModel(this.iMq.getPageContext());
        this.lYu = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void onCallBack(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eFn) instanceof String) {
                        PbModel.this.lXe = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eFn);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eFo) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eFo);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eFp) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eFp);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eFq) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.eFq), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.eFr) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eFr);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.lXN = true;
        if (fVar != null && fVar.lMq == null) {
            q(fVar);
            l(fVar);
            if (fVar.dlp() != null) {
                fVar.dlp().nj(0);
            }
            if (this.lXE != null && fVar != null) {
                this.lXE.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int doE() {
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
            this.lXe = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.lYs = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            this.lYt = false;
            if (com.baidu.tbadk.BdToken.f.r(uri)) {
                this.lYt = true;
                com.baidu.tbadk.BdToken.f.bhJ().c(uri, this.lYu);
            } else if (StringUtils.isNull(this.lXe)) {
                this.lYt = true;
                this.lXV.a(intent, this.lYu);
                if (uri != null) {
                    if (StringUtils.isNull(this.lXe)) {
                        this.lXe = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.au.isEmpty(this.lXe)) {
                this.lXe = "0";
            }
            this.lYe = intent.getIntExtra("key_start_from", 0);
            if (this.lYe == 0) {
                this.lYe = this.lXV.aLy;
            }
            this.lXg = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.lXf = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.lXi = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.lXj = intent.getBooleanExtra("host_only", false);
            this.lXl = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.lXg = this.mSortType == 2 ? "0" : this.lXg;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.lXo = intent.getIntExtra("is_top", 0);
            this.lXp = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.lXv = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.lXw = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.eVF = intent.getBooleanExtra("is_sub_pb", false);
            this.lXy = intent.getBooleanExtra("is_pv", false);
            this.lXx = intent.getLongExtra("msg_id", 0L);
            this.lXz = intent.getStringExtra("from_forum_name");
            this.lXG = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.lXF = intent.getStringExtra("op_stat");
            this.lXA = intent.getBooleanExtra("is_from_thread_config", false);
            this.lXB = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.lXC = intent.getBooleanExtra("is_from_my_god_config", false);
            this.lXI = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.lXH = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.eVe = intent.getBooleanExtra("from_frs", false);
            this.lXu = intent.getBooleanExtra("from_maintab", false);
            this.lXT = intent.getBooleanExtra("from_smart_frs", false);
            this.lXD = intent.getBooleanExtra("from_hottopic", false);
            this.lXY = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.lXh = intent.getStringExtra("high_light_post_id");
            this.lYn = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.lXJ = intent.getIntExtra("request_code", -1) == 18003;
            this.lYo = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.lYp = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.lYq = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.lYr = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean doF() {
        return this.lYn && com.baidu.tieba.frs.l.cCw() != null && com.baidu.tieba.frs.l.cCw().equals(this.lXe) && com.baidu.tieba.frs.l.cCv() != null;
    }

    public com.baidu.tieba.pb.data.f aM(cb cbVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.Fx(3);
        if (cbVar == null) {
            return null;
        }
        fVar.aJ(cbVar);
        if (cbVar.bpI() != null) {
            fVar.d(cbVar.bpI());
            ForumData forum = fVar.getForum();
            forum.setId(cbVar.bpI().getForumId());
            forum.setName(cbVar.bpI().getForumName());
            forum.setUser_level(cbVar.bpI().bni());
            forum.setImage_url(cbVar.bpI().getAvatar());
            forum.setPost_num(cbVar.bpI().postNum);
            forum.setMember_num(cbVar.bpI().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(cbVar.getFid()));
            forum2.setName(cbVar.bnW());
        }
        PostData postData = new PostData();
        postData.JJ(1);
        postData.setTime(cbVar.getCreateTime());
        postData.a(cbVar.bnS());
        MetaData bnS = cbVar.bnS();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(bnS.getUserId(), bnS);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, cbVar.bnI(), doJ(), false));
        fVar.d(postData);
        fVar.dlr().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.p(cbVar, null));
        fVar.lMv = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.lYe = bundle.getInt("key_start_from", 0);
        this.lXe = bundle.getString("thread_id");
        this.lXg = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.lXf = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.lXi = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.lXj = bundle.getBoolean("host_only", false);
        this.lXl = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.lXo = bundle.getInt("is_top", 0);
        this.lXp = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.lXw = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eVF = bundle.getBoolean("is_sub_pb", false);
        this.lXy = bundle.getBoolean("is_pv", false);
        this.lXx = bundle.getLong("msg_id", 0L);
        this.lXz = bundle.getString("from_forum_name");
        this.lXG = bundle.getString("extra_pb_cache_key");
        this.lXA = bundle.getBoolean("is_from_thread_config", false);
        this.lXB = bundle.getBoolean("is_from_interview_live_config", false);
        this.lXC = bundle.getBoolean("is_from_my_god_config", false);
        this.lXI = bundle.getInt("extra_pb_is_attention_key", -1);
        this.lXH = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eVe = bundle.getBoolean("from_frs", false);
        this.lXu = bundle.getBoolean("from_maintab", false);
        this.lXT = bundle.getBoolean("from_smart_frs", false);
        this.lXD = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.lXh = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.lXJ = bundle.getInt("request_code", -1) == 18003;
        this.lYo = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.lYp = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.lYq = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.lYr = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aD(Bundle bundle) {
        bundle.putString("thread_id", this.lXe);
        bundle.putString("post_id", this.lXg);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.lYe);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.lXi);
        bundle.putBoolean("host_only", this.lXj);
        bundle.putBoolean("squence", this.lXl);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.lXo);
        bundle.putLong("thread_time", this.lXp);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.lXw);
        bundle.putBoolean("is_sub_pb", this.eVF);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.lXy);
        bundle.putLong("msg_id", this.lXx);
        bundle.putString("extra_pb_cache_key", this.lXG);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.lXA);
        bundle.putBoolean("is_from_interview_live_config", this.lXB);
        bundle.putBoolean("is_from_my_god_config", this.lXC);
        bundle.putInt("extra_pb_is_attention_key", this.lXI);
        bundle.putInt("extra_pb_funs_count_key", this.lXH);
        bundle.putBoolean("from_frs", this.eVe);
        bundle.putBoolean("from_maintab", this.lXu);
        bundle.putBoolean("from_smart_frs", this.lXT);
        bundle.putBoolean("from_hottopic", this.lXD);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.lXh);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.lYo);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.lYp);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.lYq);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.lYr);
    }

    public String doG() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.lXe);
        if (!this.lXw) {
            sb.append(this.lXg);
        }
        sb.append(this.lXj);
        sb.append(this.lXl);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.lXo);
        sb.append(this.lXp);
        sb.append(this.eVe);
        sb.append(this.lXu);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eVF);
        sb.append(this.lXy);
        sb.append(this.lXx);
        sb.append(this.lXz);
        sb.append(this.mThreadType);
        sb.append(this.lXA);
        sb.append(this.lXB);
        sb.append(this.lXC);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.lXG != null) {
            sb.append(this.lXG);
        }
        return sb.toString();
    }

    public String dmz() {
        return this.lXz;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String doH() {
        return this.lXg;
    }

    public String doI() {
        return this.lXh;
    }

    public String doJ() {
        return this.lXe;
    }

    public String doK() {
        return (StringUtils.isNull(this.lXe) || "0".equals(this.lXe)) ? this.oriUgcNid : this.lXe;
    }

    public boolean getHostMode() {
        return this.lXj;
    }

    public boolean doL() {
        return dpB();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean doM() {
        return this.eVe;
    }

    public boolean doN() {
        return this.lXn;
    }

    public boolean doO() {
        return this.lXu;
    }

    public boolean doP() {
        return this.lXD;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean doQ() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int cvv() {
        return this.lXo;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void FR(int i) {
        this.lXo = i;
    }

    public boolean doR() {
        return this.eVF;
    }

    public boolean doS() {
        if (this.lQH == null) {
            return false;
        }
        return this.lQH.isValid();
    }

    public String boa() {
        if (this.lQH == null || !this.lQH.bkb()) {
            return null;
        }
        return this.lQH.bka();
    }

    public boolean FS(int i) {
        this.lXq = i;
        if (this.lXq > this.lQH.getPage().bmC()) {
            this.lXq = this.lQH.getPage().bmC();
        }
        if (this.lXq < 1) {
            this.lXq = 1;
        }
        if (this.lXe == null) {
            return false;
        }
        return FU(5);
    }

    public void FT(int i) {
        this.lXq = i;
        this.lXr = i;
        this.lXs = i;
    }

    public void b(az azVar) {
        if (azVar == null) {
            FT(1);
            return;
        }
        if (this.lXr < azVar.bmF()) {
            this.lXr = azVar.bmF();
        }
        if (this.lXs > azVar.bmF()) {
            this.lXs = azVar.bmF();
        }
        this.lXt = azVar.bmC();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.lQH;
    }

    public BaijiahaoData doT() {
        if (this.lQH == null || this.lQH.dlp() == null) {
            return null;
        }
        return this.lQH.dlp().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f doU() {
        if (this.lQH == null) {
            return this.lQH;
        }
        if (!doV() && this.lYm != null) {
            this.lQH.b(this.lYm);
        }
        return this.lQH;
    }

    private boolean doV() {
        return (this.lQH.dlH() == null || this.lQH.dlH().dNC() == null || this.lQH.dlH().dNC().goods != null || this.lQH.dlH().dNC().goods.goods_style == 1001) ? false : true;
    }

    public az getPageData() {
        if (this.lQH == null) {
            return null;
        }
        return this.lQH.getPage();
    }

    public boolean doW() {
        if (dpB() && this.lQH.getPage().bmH() == 0) {
            vm(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.lXe = fVar.getThreadId();
            if (fVar.dlp() != null && fVar.dlp().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.dlp().getBaijiahaoData();
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
            this.lXg = null;
            this.lXj = false;
            this.lXl = true;
            LoadData();
        }
    }

    public void Pz(String str) {
        if (!StringUtils.isNull(str)) {
            this.lXe = str;
            this.lXg = null;
            this.lXj = false;
            this.lXl = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lXe == null) {
            return false;
        }
        cancelLoadData();
        if (this.iNv == null) {
            this.iNv = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.iNv.start();
        }
        boolean FU = FU(3);
        if (this.opType != null) {
            this.opType = null;
            this.lXF = null;
            this.opUrl = null;
            return FU;
        }
        return FU;
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
        if (this.lYb != null) {
            this.lYb.cancelLoadData();
        }
        if (this.lYc != null) {
            this.lYc.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dEB().RY("PB");
        cwU();
    }

    private void cwU() {
        if (this.iNv != null) {
            this.iNv.destory();
            this.iNv = null;
        }
    }

    public boolean doX() {
        return (this.lXg == null || this.lXg.equals("0") || this.lXg.length() == 0) ? LoadData() : dpb();
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
        this.lYb.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.lYc == null) {
                this.lYc = new GetSugMatchWordsModel(this.iMq.getPageContext());
            }
            this.lYc.b(aVar);
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
    public boolean FU(int i) {
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
        FV(i);
        final com.baidu.tieba.pb.data.f pbData = aj.dqi().getPbData();
        if (pbData != null && pbData.dlp() != null) {
            pbData.dlp().nj(0);
            this.lXl = aj.dqi().doL();
            this.lXj = aj.dqi().dqn();
            this.lXn = aj.dqi().dqo();
            this.lYg = aj.dqi().dqm();
            this.lYh = aj.dqi().dql();
            this.lYi = aj.dqi().dqk();
            this.lYk = aj.dqi().dqp();
            this.mTabIndex = aj.dqi().dpI();
            this.lYd = this.lXj;
            if (this.lXj || this.isFromMark) {
                this.lXJ = false;
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
        if (i == 4 && !this.lXN) {
            a(dpg(), true, this.lXg, 3);
        }
        if (i == 3 && !this.lXN) {
            if (this.isFromMark) {
                a(dpg(), true, this.lXg, 3);
            } else {
                a(dpg(), false, this.lXg, 3);
            }
        }
        this.lXN = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.lYm == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.fBZ);
        if (this.lXj || this.isFromMark) {
            this.lXJ = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.lXe == null || this.lXe.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.lXe, 0L));
        if (com.baidu.tbadk.a.d.bjb()) {
            pbPageRequestMessage.setFloorSortType(1);
            pbPageRequestMessage.setFloor_rn(com.baidu.tbadk.a.d.bjk());
            pbPageRequestMessage.set_rn(15);
        } else {
            pbPageRequestMessage.set_rn(30);
        }
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(av.bsV().bsW() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.lXl) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.lXj) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.lXy) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.lXx));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.lXJ) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.lXF, 0));
            pbPageRequestMessage.setOpMessageID(this.lXx);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> dlr = this.lQH.dlr();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lXs - 1));
                        if (this.lXs - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.lXv) {
                                if (dlr != null && dlr.size() > 0) {
                                    size = dlr.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = dlr.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.lXg = postData.getId();
                                            if (StringUtils.isNull(this.lXg)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.lXr + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.lXg == null && this.lXg.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lXg, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lXr + 1));
                        if (this.lXr >= this.lXt) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (dlr != null) {
                                size = dlr.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.lXg == null) {
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
                if (dlr != null) {
                }
                if (this.lXg == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (dlr != null && dlr.size() > 0 && dlr.get(0) != null) {
                    this.lXg = dlr.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (dpB()) {
                        if (this.lXs - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.lXs - 1));
                        }
                    } else if (this.lXr < this.lXt) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lXr + 1));
                    }
                }
                if (this.lXg != null && this.lXg.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lXg, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.lXj) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (dpB()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.lXt > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lXt));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lXg, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.lXq));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.lYd && !this.lXj) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lXg, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.lXj) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.lXR);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lYf, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.lYd = this.lXj;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(dpg());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.lYe));
        pbPageRequestMessage.setIsSubPostDataReverse(this.lXQ);
        pbPageRequestMessage.setFromSmartFrs(this.lXT ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.lXi);
        if (this.lYe == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        if (this.lYe == 7 || this.lYe == 5 || this.lYt) {
            pbPageRequestMessage.setSourceType(1);
        } else {
            pbPageRequestMessage.setSourceType(2);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.lYs)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.lYs));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.lXt) {
                    i4 = -1;
                } else {
                    i4 = dpJ();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = dpJ();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.lXe);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean dmy() {
        switch (dpu()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().dlp() == null || !getPbData().dlp().bpr();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dmz()) && com.baidu.tieba.recapp.s.dDB().dDv() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.s.dDB().dDv().ba(dmz(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.s.dDB().dDv().bb(dmz(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dmz()) && com.baidu.tieba.recapp.s.dDB().dDv() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.s.dDB().dDv().bb(dmz(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.s.dDB().dDv().ba(dmz(), true));
        }
    }

    protected void FV(int i) {
        boolean z = false;
        Ga(i);
        ArrayList<PostData> dlr = this.lQH.dlr();
        this.lXM = false;
        if (i == 1) {
            boolean z2 = false;
            while (dlr.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dlr.remove(0);
                z2 = true;
            }
            if (z2) {
                this.lQH.getPage().nf(1);
                if (this.lXE != null) {
                    this.lXE.e(this.lQH);
                }
            }
            this.jGn = System.currentTimeMillis();
            this.lXM = true;
        } else if (i == 2) {
            while (dlr.size() + 30 > com.baidu.tbadk.data.e.getPbListItemMaxNum()) {
                dlr.remove(dlr.size() - 1);
                z = true;
            }
            if (z) {
                this.lQH.getPage().ne(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.lXU = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.lYm != null && this.lYm.bMF()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlH() != null && fVar.dlH().dNC() != null && fVar.dlH().dNC().goods != null && fVar.dlH().bMF() && fVar.dlH().dNC().goods.goods_style != 1001) {
            this.lYm = fVar.dlH();
        }
    }

    public com.baidu.tieba.tbadkCore.data.o doY() {
        return this.lYm;
    }

    public void doZ() {
        this.lYm = null;
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
            if (this.lXC || this.lXA || this.lXB) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.dlr().size(); i++) {
                PostData postData = fVar.dlr().get(i);
                for (int i2 = 0; i2 < postData.dNL().size(); i2++) {
                    postData.dNL().get(i2).a(this.iMq.getPageContext(), o.equals(postData.dNL().get(i2).bnS().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.s dlD = fVar.dlD();
            if (dlD != null && !com.baidu.tbadk.core.util.y.isEmpty(dlD.lNY)) {
                for (PostData postData2 : dlD.lNY) {
                    for (int i3 = 0; i3 < postData2.dNL().size(); i3++) {
                        postData2.dNL().get(i3).a(this.iMq.getPageContext(), o.equals(postData2.dNL().get(i3).bnS().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.s dlD = fVar.dlD();
            if (dlD != null && !com.baidu.tbadk.core.util.y.isEmpty(dlD.lNY)) {
                for (PostData postData : dlD.lNY.subList(i, dlD.lNY.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dNL().size()) {
                            postData.dNL().get(i3).a(this.iMq.getPageContext(), o.equals(postData.dNL().get(i3).bnS().getUserId()));
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
        cb dlp = fVar.dlp();
        dlp.no(this.mIsGood);
        dlp.nn(this.lXo);
        if (this.lXp > 0) {
            dlp.dM(this.lXp);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.dlp() != null && fVar.dlp().bnS() != null) {
            str = fVar.dlp().bnS().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData dpa() {
        if (this.lQH == null || this.lQH.dlp() == null || this.lQH.dlp().bnS() == null) {
            return null;
        }
        return this.lQH.dlp().bnS();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.lXS = z3;
        if (this.iNv != null && !z3) {
            this.iNv.a(z2, z4, i2, str, i3, j, j2);
            this.iNv = null;
        }
        if (this.lQH != null) {
            this.lQH.lNd = z3;
            this.lQH.abG = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(dmz()) && com.baidu.tieba.recapp.s.dDB().dDv() != null) {
            com.baidu.tieba.recapp.s.dDB().dDv().f(dmz(), FW(dpj()), true);
        }
        if (fVar == null || (this.lXq == 1 && i == 5 && fVar.dlr() != null && fVar.dlr().size() < 1)) {
            if (this.lXE != null) {
                this.lXl = this.lXk;
                if (i2 != 350006) {
                    this.mSortType = this.lXm;
                }
                this.lXE.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.lXk = this.lXl;
            if (i != 8) {
                this.lXm = this.mSortType;
                this.mSortType = fVar.lMp;
            }
            if (fVar.lMo != null && fVar.lMo.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.iMq.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.lMo = new ArrayList();
                fVar.lMo.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.iMq.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.lMo.add(builder2.build(false));
                this.mSortType = this.lXm;
                fVar.lMp = this.mSortType;
            }
            this.lXy = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.lXt = this.lXt < 1 ? 1 : this.lXt;
            int i6 = 0;
            ArrayList<PostData> dlr = this.lQH.dlr();
            switch (i) {
                case 1:
                    this.lQH.a(fVar.getPage(), 1);
                    d(fVar, dlr);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.dlr() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.dlr().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dlr, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dlr(), com.baidu.tbadk.core.util.y.getCount(fVar.dlr()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.dlr().remove(postData2);
                            i5 = size2 - 1;
                        }
                        dlr.addAll(0, fVar.dlr());
                    }
                    p(fVar);
                    this.lQH.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().nc(fVar.getPage().bmC());
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
                    if (fVar != null && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dlr()) && this.lQH != null && (!this.lXj || o(fVar).equals(fVar.dlr().get(0).bnS().getUserId()))) {
                        if (this.lQH.getPage().bmH() == 0) {
                            this.lQH.getPage().ne(1);
                        }
                        dpv();
                        this.lYg = fVar.dlr().get(0);
                        if (dpB() || this.lQH.dlS()) {
                            if (this.lQH.dlr().size() - this.lYi >= 3) {
                                this.lYh = new PostData();
                                this.lYh.nzD = true;
                                this.lYh.setPostType(53);
                                this.lQH.dlr().add(this.lYh);
                            }
                            this.lQH.dlr().add(this.lYg);
                            size = this.lQH.dlr().size() - 1;
                        } else {
                            if (this.lYi - this.lYj >= 3) {
                                this.lYh = new PostData();
                                this.lYh.nzD = false;
                                this.lYh.setPostType(53);
                                this.lQH.dlr().add(0, this.lYh);
                            }
                            this.lQH.dlr().add(0, this.lYg);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.au.isTaday(com.baidu.tbadk.core.sharedPref.b.brR().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.lYg.nzQ = this.lQH.dlQ();
                            com.baidu.tbadk.core.sharedPref.b.brR().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.lQH != null && this.lQH.dlp() != null) {
                PraiseData bnD = this.lQH.dlp().bnD();
                if (this.lYx != null && !bnD.isPriaseDataValid()) {
                    this.lQH.dlp().a(this.lYx);
                } else {
                    this.lYx = this.lQH.dlp().bnD();
                    this.lYx.setPostId(this.lQH.dlp().boi());
                }
                if (fVar.getPage() != null && fVar.getPage().bmF() == 1 && fVar.dlp() != null && fVar.dlp().boc() != null && fVar.dlp().boc().size() > 0) {
                    this.lQH.dlp().z(fVar.dlp().boc());
                }
                this.lQH.dlp().nl(fVar.dlp().bnJ());
                this.lQH.dlp().ni(fVar.dlp().getAnchorLevel());
                this.lQH.dlp().nj(fVar.dlp().bnz());
                if (this.mThreadType == 33) {
                    this.lQH.dlp().bnS().setHadConcerned(fVar.dlp().bnS().hadConcerned());
                }
                if (fVar != null && fVar.dlp() != null) {
                    this.lQH.dlp().nq(fVar.dlp().bog());
                }
            }
            if (this.lQH != null && this.lQH.getUserData() != null && fVar.getUserData() != null) {
                this.lQH.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.lQH.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().bmF() == 1 && fVar.dlC() != null) {
                this.lQH.f(fVar.dlC());
            }
            if (this.lXS) {
                if (this.lQH.dlp() != null && this.lQH.dlp().bnS() != null && this.lQH.dlr() != null && com.baidu.tbadk.core.util.y.getItem(this.lQH.dlr(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(this.lQH.dlr(), 0);
                    MetaData bnS = this.lQH.dlp().bnS();
                    if (postData3.bnS() != null && postData3.bnS().getGodUserData() != null) {
                        if (this.lXH != -1) {
                            bnS.setFansNum(this.lXH);
                            postData3.bnS().setFansNum(this.lXH);
                        }
                        if (this.lXI != -1) {
                            bnS.getGodUserData().setIsLike(this.lXI == 1);
                            postData3.bnS().getGodUserData().setIsLike(this.lXI == 1);
                            bnS.getGodUserData().setIsFromNetWork(false);
                            postData3.bnS().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.lQH.lMn = -1;
                this.lQH.lMm = -1;
            }
            if (this.lXE != null) {
                this.lXE.a(true, getErrorCode(), i, i4, this.lQH, this.mErrorString, 1);
            }
        }
        if (this.lQH != null && this.lQH.dlp() != null && this.lQH.getForum() != null && !this.lQH.dlS()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.iMq.getPageContext();
            historyMessage.threadId = getPbData().dlp().getId();
            if (this.mIsShareThread && getPbData().dlp().eUD != null) {
                historyMessage.threadName = getPbData().dlp().eUD.showText;
            } else {
                historyMessage.threadName = getPbData().dlp().getTitle();
            }
            if (this.mIsShareThread && !dmy()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = doL();
            historyMessage.threadType = getPbData().dlp().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.lQH != null) {
            this.lQH.dlG().clear();
            this.lQH.dlG().addAll(fVar.dlG());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aY;
        if (arrayList != null && fVar.dlr() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dlr(), 0);
            if (postData != null && (aY = aY(arrayList)) != null && aY.equals(postData.getId())) {
                fVar.dlr().remove(postData);
            }
            this.lQH.lNc = arrayList.size();
            arrayList.addAll(fVar.dlr());
        }
    }

    private int FW(int i) {
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
            fVar.Ps(this.lQH.dlK());
            if (!this.lQH.lNa && fVar.lNa && this.lQH.dlz() != null) {
                fVar.e(this.lQH.dlz());
            }
            this.lQH = fVar;
            FT(fVar.getPage().bmF());
        }
    }

    public boolean dpb() {
        if (this.lXe == null || this.lXg == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return FU(4);
        }
        return FU(6);
    }

    public boolean vm(boolean z) {
        if (this.lXe == null || this.lQH == null) {
            return false;
        }
        if (z || this.lQH.getPage().bmH() != 0) {
            return FU(1);
        }
        return false;
    }

    public boolean vn(boolean z) {
        if (this.lXe == null || this.lQH == null) {
            return false;
        }
        if ((z || this.lQH.getPage().bmI() != 0) && this.lQH.dlr() != null && this.lQH.dlr().size() >= 1) {
            return FU(2);
        }
        return false;
    }

    public boolean PF(String str) {
        this.lXj = !this.lXj;
        this.lXg = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("pb_onlyowner_click").aq("obj_source", 0));
        if (FU(6)) {
            return true;
        }
        this.lXj = this.lXj ? false : true;
        return false;
    }

    public boolean J(boolean z, String str) {
        if (this.lXj == z) {
            return false;
        }
        this.lXj = z;
        this.lXg = str;
        if (this.mSortType == 2) {
            this.lXg = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("pb_onlyowner_click").aq("obj_source", 1));
        }
        if (FU(6)) {
            return true;
        }
        this.lXj = z ? false : true;
        return false;
    }

    public boolean FX(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_pb_current_sort_type", i);
        }
        this.lXk = this.lXl;
        this.lXm = this.mSortType;
        this.mSortType = i;
        this.lXl = !this.lXl;
        if (i == 2 && this.isFromMark) {
            this.lXg = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.lXl = this.lXl ? false : true;
            this.mSortType = this.lXm;
            return false;
        }
        return true;
    }

    public boolean dpc() {
        return dpB();
    }

    public int dpd() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.lQH == null || this.lQH.getForum() == null || this.lQH.dlp() == null) ? false : true;
    }

    public boolean bkb() {
        if (this.lQH == null) {
            return false;
        }
        return this.lQH.bkb();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData CY(String str) {
        if (this.lQH == null || this.lQH.dlp() == null || this.lQH.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.lQH.dlp().bpr()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.lQH.getForum().getId());
            writeData.setForumName(this.lQH.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.lYe);
        writeData.setThreadId(this.lXe);
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

    public MarkData FY(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.lQH == null) {
            return null;
        }
        ArrayList<PostData> dlr = this.lQH.dlr();
        if (com.baidu.tbadk.core.util.y.isEmpty(dlr)) {
            return null;
        }
        if (dlr.size() > 0 && i >= dlr.size()) {
            i = dlr.size() - 1;
        }
        return o(dlr.get(i));
    }

    public MarkData dpe() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lXe);
        markData.setPostId(this.lQH.bka());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lXj);
        markData.setSequence(Boolean.valueOf(dpB()));
        markData.setId(this.lXe);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lXe);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lXj);
        markData.setSequence(Boolean.valueOf(dpB()));
        markData.setId(this.lXe);
        markData.setFloor(postData.dNO());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.o) postData).isApp());
        }
        return markData;
    }

    public void dpf() {
        i.dnm().aU(dpg(), this.isFromMark);
    }

    private String dpg() {
        String dph = (this.lXe == null || this.lXe.equals("0")) ? dph() : this.lXe;
        if (this.lXj) {
            dph = dph + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            dph = dph + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            dph = dph + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return dph + TbadkCoreApplication.getCurrentAccount();
        }
        return dph;
    }

    private String dph() {
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
        if (this.lQH != null) {
            this.lQH.ja(z);
        }
    }

    public boolean dpi() {
        return this.lXJ;
    }

    public void a(a aVar) {
        this.lXE = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bBM() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bBL() {
        return doX();
    }

    public boolean PG(String str) {
        if (getPbData() == null || getPbData().dlp() == null || getPbData().dlp().bnS() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().dlp().bnS().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int dpj() {
        return this.mRequestType;
    }

    public void dpk() {
        if ("personalize_page".equals(this.mStType)) {
            this.lXP = System.currentTimeMillis() / 1000;
        }
    }

    public void dpl() {
        if ("personalize_page".equals(this.mStType) && this.lQH != null && this.lXP != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10754").dR("fid", this.lQH.getForumId()).dR("tid", this.lXe).dR("obj_duration", String.valueOf(currentTimeMillis - this.lXP)).dR(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.lXP = 0L;
        }
    }

    public boolean dpm() {
        return this.lXS;
    }

    public int getErrorNo() {
        return this.lXU;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public n dpn() {
        return this.lXW;
    }

    public ab dpo() {
        return this.lXX;
    }

    public CheckRealNameModel dpp() {
        return this.lXZ;
    }

    public AddExperiencedModel dpq() {
        return this.lYa;
    }

    public String dpr() {
        return this.lXO;
    }

    public void PH(String str) {
        this.lXO = str;
    }

    public boolean dps() {
        return this.lXT;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lQH != null && this.lQH.dlr() != null && this.lQH.dlr().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lQH.dlr().size();
                for (int i = 0; i < size; i++) {
                    if (this.lQH.dlr().get(i) != null && this.lQH.dlr().get(i).bnS() != null && currentAccount.equals(this.lQH.dlr().get(i).bnS().getUserId()) && this.lQH.dlr().get(i).bnS().getPendantData() != null) {
                        this.lQH.dlr().get(i).bnS().getPendantData().Ak(nVar.getImgUrl());
                        this.lQH.dlr().get(i).bnS().getPendantData().ek(nVar.bAJ());
                    }
                }
            }
        }
    }

    public String dpt() {
        return this.lXY;
    }

    public int dpu() {
        return this.lYe;
    }

    public void FZ(int i) {
        this.lYe = i;
    }

    public void PI(String str) {
        if ((!this.lXj || PG(TbadkCoreApplication.getCurrentAccount())) && this.lQH.dlr() != null) {
            this.lQH.getPage().ne(1);
            if (this.lQH.getPage().bmH() == 0) {
                this.lQH.getPage().ne(1);
            }
            this.lYf = str;
            FU(8);
        }
    }

    private void Ga(int i) {
        if (i != 8) {
            this.lYf = "";
            if (this.lYg != null) {
                if (i == 1 && this.lQH != null && this.lQH.dlS()) {
                    if (this.lYh != null) {
                        getPbData().dlr().remove(this.lYh);
                    }
                } else if (i == 1 && !this.lXl && !com.baidu.tbadk.core.util.y.isEmpty(getPbData().dlr())) {
                    getPbData().dlr().remove(this.lYg);
                    if (this.lYh != null) {
                        getPbData().dlr().remove(this.lYh);
                    }
                    getPbData().dlr().add(0, this.lYg);
                } else {
                    getPbData().dlr().remove(this.lYg);
                    if (this.lYh != null) {
                        getPbData().dlr().remove(this.lYh);
                    }
                }
            }
            this.lYh = null;
        }
    }

    public void dpv() {
        if (this.lQH != null && !com.baidu.tbadk.core.util.y.isEmpty(this.lQH.dlr())) {
            if (this.lYh != null) {
                this.lQH.dlr().remove(this.lYh);
                this.lYh = null;
            }
            if (this.lYg != null) {
                this.lQH.dlr().remove(this.lYg);
                this.lYg = null;
            }
        }
    }

    public void da(int i, int i2) {
        this.lYi = i;
        this.lYj = i2;
    }

    public PostData dpw() {
        return this.lYg;
    }

    public PostData dpx() {
        return this.lYh;
    }

    public int dpy() {
        return this.lYi;
    }

    public int dpz() {
        return this.lYj;
    }

    public String dpA() {
        return this.lYl;
    }

    public void PJ(String str) {
        this.lYl = str;
    }

    private boolean dpB() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean dpC() {
        return this.lYe == 13 || this.lYe == 12 || this.lYe == 7 || this.lYe == 23 || this.lYe == 24;
    }

    public String dpD() {
        return this.lYo;
    }

    public String dpE() {
        return this.lYp;
    }

    public String dpF() {
        return this.lYq;
    }

    public String dpG() {
        return this.lYr;
    }

    public Rect dpH() {
        Rect rect = this.lYk;
        this.lYk = null;
        return rect;
    }

    public int dpI() {
        return this.mTabIndex;
    }

    private int dpJ() {
        int i;
        int i2 = 0;
        if (getPbData().dlr() == null) {
            return 0;
        }
        ArrayList<PostData> dlr = getPbData().dlr();
        int size = dlr.size() - 1;
        while (size >= 0) {
            PostData postData = dlr.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.o) {
                if (postData.getType() != AdvertAppInfo.eMG) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return dlr.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
