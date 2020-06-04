package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
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
import com.baidu.tbadk.core.data.bk;
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
    private boolean dHL;
    private BaseFragmentActivity gRG;
    private com.baidu.tieba.tbadkCore.d.b gSP;
    private long hGz;
    private boolean iRv;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    protected com.baidu.tieba.pb.data.e jIU;
    private int jOA;
    private boolean jOB;
    private int jOC;
    private long jOD;
    private int jOE;
    private int jOF;
    private int jOG;
    private int jOH;
    private boolean jOI;
    private boolean jOJ;
    private boolean jOK;
    private long jOL;
    private boolean jOM;
    private String jON;
    private boolean jOO;
    private boolean jOP;
    private boolean jOQ;
    private boolean jOR;
    private a jOS;
    private String jOT;
    private String jOU;
    private int jOV;
    private int jOW;
    private boolean jOX;
    private boolean jOY;
    private boolean jOZ;
    protected String jOs;
    private String jOt;
    private String jOu;
    private String jOv;
    private boolean jOw;
    private boolean jOx;
    private boolean jOy;
    private boolean jOz;
    private com.baidu.tieba.tbadkCore.data.n jPA;
    private boolean jPB;
    private String jPC;
    private String jPD;
    private String jPE;
    private String jPF;
    private f.a jPG;
    private CustomMessageListener jPH;
    private com.baidu.adp.framework.listener.a jPI;
    private PraiseData jPJ;
    private boolean jPa;
    private boolean jPb;
    private String jPc;
    private long jPd;
    private boolean jPe;
    private int jPf;
    private boolean jPg;
    private boolean jPh;
    private int jPi;
    private final ac jPj;
    private final o jPk;
    private final ae jPl;
    private String jPm;
    private final CheckRealNameModel jPn;
    private final AddExperiencedModel jPo;
    private SuggestEmotionModel jPp;
    private GetSugMatchWordsModel jPq;
    private boolean jPr;
    private int jPs;
    private String jPt;
    private PostData jPu;
    private PostData jPv;
    private int jPw;
    private int jPx;
    private Rect jPy;
    private String jPz;
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
    private static final int jOr = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.jOs = null;
        this.jOt = null;
        this.jOu = null;
        this.mForumId = null;
        this.jOv = null;
        this.jOw = false;
        this.jOx = false;
        this.jOy = true;
        this.jOz = true;
        this.mSortType = 0;
        this.jOA = 0;
        this.jOB = false;
        this.mIsGood = 0;
        this.jOC = 0;
        this.jOD = 0L;
        this.jOE = 1;
        this.jOF = 1;
        this.jOG = 1;
        this.jOH = 1;
        this.isAd = false;
        this.iRv = false;
        this.dHL = false;
        this.jOI = false;
        this.isFromMark = false;
        this.jOJ = false;
        this.jOK = false;
        this.jOL = 0L;
        this.jOM = false;
        this.jON = null;
        this.jIU = null;
        this.isLoading = false;
        this.jOO = false;
        this.jOP = false;
        this.jOQ = false;
        this.jOR = false;
        this.mLocate = null;
        this.mContext = null;
        this.jOS = null;
        this.opType = null;
        this.opUrl = null;
        this.jOT = null;
        this.jOU = null;
        this.jOV = -1;
        this.jOW = -1;
        this.gSP = null;
        this.jOY = false;
        this.jOZ = false;
        this.postID = null;
        this.jPc = null;
        this.jPd = 0L;
        this.jPe = false;
        this.jPf = -1;
        this.jPh = false;
        this.jPr = false;
        this.jPs = 0;
        this.mTabIndex = 0;
        this.jPB = false;
        this.jPH = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.jPI = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.gRG.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.jOY || !PbModel.this.jOZ) {
                        if (!PbModel.this.jOY) {
                            PbModel.this.jOY = true;
                        } else {
                            PbModel.this.jOZ = true;
                        }
                        if (PbModel.this.jOS != null) {
                            PbModel.this.jOS.a(PbModel.this.cFE(), z, responsedMessage, PbModel.this.jPa, System.currentTimeMillis() - PbModel.this.hGz);
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
                    if (PbModel.this.jIU != null && PbModel.this.jIU.cCx() != null && PbModel.this.jIU.cCx().getForumId() != null && PbModel.this.jIU.cCx().getForumId().equals(valueOf)) {
                        PbModel.this.jIU.cCx().setIsLike(false);
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
                    if (PbModel.this.jIU != null && PbModel.this.jIU.cCx() != null && PbModel.this.jIU.cCx().getForumId() != null && PbModel.this.jIU.cCx().getForumId().equals(valueOf)) {
                        PbModel.this.jIU.cCx().setIsLike(true);
                    }
                }
            }
        };
        this.jPJ = null;
        registerListener(this.jPI);
        registerListener(this.jPH);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.jIU = new com.baidu.tieba.pb.data.e();
        this.jIU.zV(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.gRG = baseFragmentActivity;
        this.jPj = new ac(this, this.gRG);
        this.jPk = new o(this, this.gRG);
        this.jPl = new ae(this, this.gRG);
        this.jPn = new CheckRealNameModel(this.gRG.getPageContext());
        this.jPp = new SuggestEmotionModel();
        this.jPo = new AddExperiencedModel(this.gRG.getPageContext());
        this.jPG = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void C(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dvs) instanceof String) {
                        PbModel.this.jOs = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dvs);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dvt) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dvt);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dvu) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dvu);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dvv) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.dvv), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.dvw) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dvw);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, String str) {
        this.jPb = true;
        if (eVar != null && eVar.jFd == null) {
            p(eVar);
            l(eVar);
            if (eVar.cCy() != null) {
                eVar.cCy().kq(0);
            }
            if (this.jOS != null && eVar != null) {
                this.jOS.a(true, 0, i, 0, eVar, str, 0);
            }
        }
    }

    protected int cFE() {
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
            this.jOs = intent.getStringExtra("thread_id");
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                com.baidu.tbadk.BdToken.f.aLw().c(uri, this.jPG);
            } else if (StringUtils.isNull(this.jOs)) {
                this.jPj.a(intent, this.jPG);
                if (uri != null) {
                    if (StringUtils.isNull(this.jOs)) {
                        this.jOs = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.aq.isEmpty(this.jOs)) {
                this.jOs = "0";
            }
            this.jPs = intent.getIntExtra("key_start_from", 0);
            if (this.jPs == 0) {
                this.jPs = this.jPj.avV;
            }
            this.jOu = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.jOt = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.jOw = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.jOx = intent.getBooleanExtra("host_only", false);
            this.jOz = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.bgi().aXF() ? 2 : 0);
            if (this.mSortType == 2) {
                this.jOu = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.jOC = intent.getIntExtra("is_top", 0);
            this.jOD = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.jOJ = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.jOK = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.iRv = intent.getBooleanExtra("is_sub_pb", false);
            this.jOM = intent.getBooleanExtra("is_pv", false);
            this.jOL = intent.getLongExtra("msg_id", 0L);
            this.jON = intent.getStringExtra("from_forum_name");
            this.jOU = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.jOT = intent.getStringExtra("op_stat");
            this.jOO = intent.getBooleanExtra("is_from_thread_config", false);
            this.jOP = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.jOQ = intent.getBooleanExtra("is_from_my_god_config", false);
            this.jOW = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.jOV = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.dHL = intent.getBooleanExtra("from_frs", false);
            this.jOI = intent.getBooleanExtra("from_maintab", false);
            this.jPh = intent.getBooleanExtra("from_smart_frs", false);
            this.jOR = intent.getBooleanExtra("from_hottopic", false);
            this.jPm = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.jOv = intent.getStringExtra("high_light_post_id");
            this.jPB = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.jOX = intent.getIntExtra("request_code", -1) == 18003;
            this.jPC = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.jPD = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.jPE = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.jPF = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean cFF() {
        return this.jPB && com.baidu.tieba.frs.i.bUI() != null && com.baidu.tieba.frs.i.bUI().equals(this.jOs) && com.baidu.tieba.frs.i.bUH() != null;
    }

    public com.baidu.tieba.pb.data.e aI(bk bkVar) {
        com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
        eVar.zV(3);
        if (bkVar == null) {
            return null;
        }
        eVar.aG(bkVar);
        if (bkVar.aSm() != null) {
            eVar.e(bkVar.aSm());
            ForumData forum = eVar.getForum();
            forum.setId(bkVar.aSm().getForumId());
            forum.setName(bkVar.aSm().getForumName());
            forum.setUser_level(bkVar.aSm().aPO());
            forum.setImage_url(bkVar.aSm().getAvatar());
            forum.setPost_num(bkVar.aSm().postNum);
            forum.setMember_num(bkVar.aSm().memberNum);
        } else {
            ForumData forum2 = eVar.getForum();
            forum2.setId(String.valueOf(bkVar.getFid()));
            forum2.setName(bkVar.aQC());
        }
        PostData postData = new PostData();
        postData.DU(1);
        postData.setTime(bkVar.getCreateTime());
        postData.a(bkVar.aQx());
        MetaData aQx = bkVar.aQx();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(aQx.getUserId(), aQx);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bkVar.aQn(), false));
        eVar.d(postData);
        eVar.cCA().add(postData);
        eVar.a(new com.baidu.tieba.pb.data.m(bkVar, null));
        eVar.jFi = true;
        eVar.setIsNewUrl(1);
        return eVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.jPs = bundle.getInt("key_start_from", 0);
        this.jOs = bundle.getString("thread_id");
        this.jOu = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.jOt = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.jOw = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.jOx = bundle.getBoolean("host_only", false);
        this.jOz = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.jOC = bundle.getInt("is_top", 0);
        this.jOD = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.jOK = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.iRv = bundle.getBoolean("is_sub_pb", false);
        this.jOM = bundle.getBoolean("is_pv", false);
        this.jOL = bundle.getLong("msg_id", 0L);
        this.jON = bundle.getString("from_forum_name");
        this.jOU = bundle.getString("extra_pb_cache_key");
        this.jOO = bundle.getBoolean("is_from_thread_config", false);
        this.jOP = bundle.getBoolean("is_from_interview_live_config", false);
        this.jOQ = bundle.getBoolean("is_from_my_god_config", false);
        this.jOW = bundle.getInt("extra_pb_is_attention_key", -1);
        this.jOV = bundle.getInt("extra_pb_funs_count_key", -1);
        this.dHL = bundle.getBoolean("from_frs", false);
        this.jOI = bundle.getBoolean("from_maintab", false);
        this.jPh = bundle.getBoolean("from_smart_frs", false);
        this.jOR = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.jOv = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.jOX = bundle.getInt("request_code", -1) == 18003;
        this.jPC = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.jPD = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.jPE = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.jPF = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aA(Bundle bundle) {
        bundle.putString("thread_id", this.jOs);
        bundle.putString("post_id", this.jOu);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.jPs);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.jOw);
        bundle.putBoolean("host_only", this.jOx);
        bundle.putBoolean("squence", this.jOz);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.jOC);
        bundle.putLong("thread_time", this.jOD);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.jOK);
        bundle.putBoolean("is_sub_pb", this.iRv);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.jOM);
        bundle.putLong("msg_id", this.jOL);
        bundle.putString("extra_pb_cache_key", this.jOU);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.jOO);
        bundle.putBoolean("is_from_interview_live_config", this.jOP);
        bundle.putBoolean("is_from_my_god_config", this.jOQ);
        bundle.putInt("extra_pb_is_attention_key", this.jOW);
        bundle.putInt("extra_pb_funs_count_key", this.jOV);
        bundle.putBoolean("from_frs", this.dHL);
        bundle.putBoolean("from_maintab", this.jOI);
        bundle.putBoolean("from_smart_frs", this.jPh);
        bundle.putBoolean("from_hottopic", this.jOR);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.jOv);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.jPC);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.jPD);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.jPE);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.jPF);
    }

    public String cFG() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.jOs);
        if (!this.jOK) {
            sb.append(this.jOu);
        }
        sb.append(this.jOx);
        sb.append(this.jOz);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.jOC);
        sb.append(this.jOD);
        sb.append(this.dHL);
        sb.append(this.jOI);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.iRv);
        sb.append(this.jOM);
        sb.append(this.jOL);
        sb.append(this.jON);
        sb.append(this.mThreadType);
        sb.append(this.jOO);
        sb.append(this.jOP);
        sb.append(this.jOQ);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.jOU != null) {
            sb.append(this.jOU);
        }
        return sb.toString();
    }

    public String cDF() {
        return this.jON;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cFH() {
        return this.jOu;
    }

    public String cFI() {
        return this.jOv;
    }

    public String cFJ() {
        return this.jOs;
    }

    public String cFK() {
        return (StringUtils.isNull(this.jOs) || "0".equals(this.jOs)) ? this.oriUgcNid : this.jOs;
    }

    public boolean getHostMode() {
        return this.jOx;
    }

    public boolean cFL() {
        return cGA();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean cFM() {
        return this.dHL;
    }

    public boolean cFN() {
        return this.jOB;
    }

    public boolean cFO() {
        return this.jOI;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean cFP() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bOe() {
        return this.jOC;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void Am(int i) {
        this.jOC = i;
    }

    public boolean cFQ() {
        return this.iRv;
    }

    public boolean cFR() {
        if (this.jIU == null) {
            return false;
        }
        return this.jIU.isValid();
    }

    public String aQG() {
        if (this.jIU == null || !this.jIU.aML()) {
            return null;
        }
        return this.jIU.aMK();
    }

    public boolean An(int i) {
        this.jOE = i;
        if (this.jOE > this.jIU.getPage().aPo()) {
            this.jOE = this.jIU.getPage().aPo();
        }
        if (this.jOE < 1) {
            this.jOE = 1;
        }
        if (this.jOs == null) {
            return false;
        }
        return Ap(5);
    }

    public void Ao(int i) {
        this.jOE = i;
        this.jOF = i;
        this.jOG = i;
    }

    public void b(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar == null) {
            Ao(1);
            return;
        }
        if (this.jOF < aoVar.aPr()) {
            this.jOF = aoVar.aPr();
        }
        if (this.jOG > aoVar.aPr()) {
            this.jOG = aoVar.aPr();
        }
        this.jOH = aoVar.aPo();
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        return this.jIU;
    }

    public BaijiahaoData cFS() {
        if (this.jIU == null || this.jIU.cCy() == null) {
            return null;
        }
        return this.jIU.cCy().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.e cFT() {
        if (this.jIU == null) {
            return this.jIU;
        }
        if (!cFU() && this.jPA != null) {
            this.jIU.b(this.jPA);
        }
        return this.jIU;
    }

    private boolean cFU() {
        return (this.jIU.cCQ() == null || this.jIU.cCQ().ddx() == null || this.jIU.cCQ().ddx().goods != null || this.jIU.cCQ().ddx().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.ao getPageData() {
        if (this.jIU == null) {
            return null;
        }
        return this.jIU.getPage();
    }

    public boolean cFV() {
        if (cGA() && this.jIU.getPage().aPt() == 0) {
            rE(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.jOs = eVar.getThreadId();
            if (eVar.cCy() != null && eVar.cCy().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = eVar.cCy().getBaijiahaoData();
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
            this.jOu = null;
            this.jOx = false;
            this.jOz = true;
            LoadData();
        }
    }

    public void Jl(String str) {
        if (!StringUtils.isNull(str)) {
            this.jOs = str;
            this.jOu = null;
            this.jOx = false;
            this.jOz = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.jOs == null) {
            return false;
        }
        cancelLoadData();
        if (this.gSP == null) {
            this.gSP = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.gSP.start();
        }
        boolean Ap = Ap(3);
        if (this.opType != null) {
            this.opType = null;
            this.jOT = null;
            this.opUrl = null;
            return Ap;
        }
        return Ap;
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
        if (this.jPp != null) {
            this.jPp.cancelLoadData();
        }
        if (this.jPq != null) {
            this.jPq.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.cVu().cVy();
        bPw();
    }

    private void bPw() {
        if (this.gSP != null) {
            this.gSP.destory();
            this.gSP = null;
        }
    }

    public boolean cFW() {
        return (this.jOu == null || this.jOu.equals("0") || this.jOu.length() == 0) ? LoadData() : cGa();
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
                this.jPp.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.jPp.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.jPq == null) {
                this.jPq = new GetSugMatchWordsModel(this.gRG.getPageContext());
            }
            this.jPq.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0363 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x036b A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0243, B:78:0x024d, B:187:0x04f3, B:188:0x04f9, B:191:0x0506, B:81:0x025a, B:83:0x0283, B:84:0x02a1, B:86:0x02b9, B:88:0x02bf, B:90:0x02c6, B:91:0x02d3, B:93:0x02e7, B:95:0x02ed, B:97:0x02f3, B:106:0x0323, B:108:0x0329, B:98:0x02fe, B:100:0x0302, B:102:0x030a, B:104:0x0319, B:105:0x031e, B:109:0x0335, B:111:0x0349, B:113:0x034d, B:116:0x035f, B:119:0x0365, B:147:0x03db, B:122:0x036b, B:124:0x0371, B:125:0x0376, B:127:0x037a, B:129:0x0384, B:134:0x039b, B:136:0x03a9, B:137:0x03ac, B:139:0x03b0, B:140:0x03bb, B:142:0x03bf, B:144:0x03c7, B:146:0x03d6, B:148:0x03e0, B:150:0x03e4, B:131:0x0388, B:151:0x03ed, B:152:0x041b, B:154:0x041f, B:164:0x0450, B:157:0x042b, B:159:0x0439, B:160:0x0441, B:162:0x0445, B:163:0x044b, B:165:0x0459, B:167:0x0465, B:156:0x0423, B:168:0x046f, B:170:0x047b, B:172:0x047f, B:174:0x0483, B:175:0x0488, B:177:0x0494, B:178:0x049c, B:182:0x04b6, B:179:0x04a1, B:181:0x04b0, B:183:0x04bf, B:185:0x04ce, B:38:0x00e3), top: B:194:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x037a A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0243, B:78:0x024d, B:187:0x04f3, B:188:0x04f9, B:191:0x0506, B:81:0x025a, B:83:0x0283, B:84:0x02a1, B:86:0x02b9, B:88:0x02bf, B:90:0x02c6, B:91:0x02d3, B:93:0x02e7, B:95:0x02ed, B:97:0x02f3, B:106:0x0323, B:108:0x0329, B:98:0x02fe, B:100:0x0302, B:102:0x030a, B:104:0x0319, B:105:0x031e, B:109:0x0335, B:111:0x0349, B:113:0x034d, B:116:0x035f, B:119:0x0365, B:147:0x03db, B:122:0x036b, B:124:0x0371, B:125:0x0376, B:127:0x037a, B:129:0x0384, B:134:0x039b, B:136:0x03a9, B:137:0x03ac, B:139:0x03b0, B:140:0x03bb, B:142:0x03bf, B:144:0x03c7, B:146:0x03d6, B:148:0x03e0, B:150:0x03e4, B:131:0x0388, B:151:0x03ed, B:152:0x041b, B:154:0x041f, B:164:0x0450, B:157:0x042b, B:159:0x0439, B:160:0x0441, B:162:0x0445, B:163:0x044b, B:165:0x0459, B:167:0x0465, B:156:0x0423, B:168:0x046f, B:170:0x047b, B:172:0x047f, B:174:0x0483, B:175:0x0488, B:177:0x0494, B:178:0x049c, B:182:0x04b6, B:179:0x04a1, B:181:0x04b0, B:183:0x04bf, B:185:0x04ce, B:38:0x00e3), top: B:194:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03b0 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0243, B:78:0x024d, B:187:0x04f3, B:188:0x04f9, B:191:0x0506, B:81:0x025a, B:83:0x0283, B:84:0x02a1, B:86:0x02b9, B:88:0x02bf, B:90:0x02c6, B:91:0x02d3, B:93:0x02e7, B:95:0x02ed, B:97:0x02f3, B:106:0x0323, B:108:0x0329, B:98:0x02fe, B:100:0x0302, B:102:0x030a, B:104:0x0319, B:105:0x031e, B:109:0x0335, B:111:0x0349, B:113:0x034d, B:116:0x035f, B:119:0x0365, B:147:0x03db, B:122:0x036b, B:124:0x0371, B:125:0x0376, B:127:0x037a, B:129:0x0384, B:134:0x039b, B:136:0x03a9, B:137:0x03ac, B:139:0x03b0, B:140:0x03bb, B:142:0x03bf, B:144:0x03c7, B:146:0x03d6, B:148:0x03e0, B:150:0x03e4, B:131:0x0388, B:151:0x03ed, B:152:0x041b, B:154:0x041f, B:164:0x0450, B:157:0x042b, B:159:0x0439, B:160:0x0441, B:162:0x0445, B:163:0x044b, B:165:0x0459, B:167:0x0465, B:156:0x0423, B:168:0x046f, B:170:0x047b, B:172:0x047f, B:174:0x0483, B:175:0x0488, B:177:0x0494, B:178:0x049c, B:182:0x04b6, B:179:0x04a1, B:181:0x04b0, B:183:0x04bf, B:185:0x04ce, B:38:0x00e3), top: B:194:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03bf A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0243, B:78:0x024d, B:187:0x04f3, B:188:0x04f9, B:191:0x0506, B:81:0x025a, B:83:0x0283, B:84:0x02a1, B:86:0x02b9, B:88:0x02bf, B:90:0x02c6, B:91:0x02d3, B:93:0x02e7, B:95:0x02ed, B:97:0x02f3, B:106:0x0323, B:108:0x0329, B:98:0x02fe, B:100:0x0302, B:102:0x030a, B:104:0x0319, B:105:0x031e, B:109:0x0335, B:111:0x0349, B:113:0x034d, B:116:0x035f, B:119:0x0365, B:147:0x03db, B:122:0x036b, B:124:0x0371, B:125:0x0376, B:127:0x037a, B:129:0x0384, B:134:0x039b, B:136:0x03a9, B:137:0x03ac, B:139:0x03b0, B:140:0x03bb, B:142:0x03bf, B:144:0x03c7, B:146:0x03d6, B:148:0x03e0, B:150:0x03e4, B:131:0x0388, B:151:0x03ed, B:152:0x041b, B:154:0x041f, B:164:0x0450, B:157:0x042b, B:159:0x0439, B:160:0x0441, B:162:0x0445, B:163:0x044b, B:165:0x0459, B:167:0x0465, B:156:0x0423, B:168:0x046f, B:170:0x047b, B:172:0x047f, B:174:0x0483, B:175:0x0488, B:177:0x0494, B:178:0x049c, B:182:0x04b6, B:179:0x04a1, B:181:0x04b0, B:183:0x04bf, B:185:0x04ce, B:38:0x00e3), top: B:194:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03e4 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x0172, B:51:0x017a, B:53:0x0187, B:54:0x018f, B:56:0x0193, B:57:0x0198, B:59:0x019c, B:60:0x01a1, B:62:0x01a5, B:63:0x01b5, B:65:0x01b9, B:66:0x01c1, B:68:0x01c5, B:69:0x01de, B:70:0x01ed, B:71:0x01f0, B:74:0x021c, B:76:0x0243, B:78:0x024d, B:187:0x04f3, B:188:0x04f9, B:191:0x0506, B:81:0x025a, B:83:0x0283, B:84:0x02a1, B:86:0x02b9, B:88:0x02bf, B:90:0x02c6, B:91:0x02d3, B:93:0x02e7, B:95:0x02ed, B:97:0x02f3, B:106:0x0323, B:108:0x0329, B:98:0x02fe, B:100:0x0302, B:102:0x030a, B:104:0x0319, B:105:0x031e, B:109:0x0335, B:111:0x0349, B:113:0x034d, B:116:0x035f, B:119:0x0365, B:147:0x03db, B:122:0x036b, B:124:0x0371, B:125:0x0376, B:127:0x037a, B:129:0x0384, B:134:0x039b, B:136:0x03a9, B:137:0x03ac, B:139:0x03b0, B:140:0x03bb, B:142:0x03bf, B:144:0x03c7, B:146:0x03d6, B:148:0x03e0, B:150:0x03e4, B:131:0x0388, B:151:0x03ed, B:152:0x041b, B:154:0x041f, B:164:0x0450, B:157:0x042b, B:159:0x0439, B:160:0x0441, B:162:0x0445, B:163:0x044b, B:165:0x0459, B:167:0x0465, B:156:0x0423, B:168:0x046f, B:170:0x047b, B:172:0x047f, B:174:0x0483, B:175:0x0488, B:177:0x0494, B:178:0x049c, B:182:0x04b6, B:179:0x04a1, B:181:0x04b0, B:183:0x04bf, B:185:0x04ce, B:38:0x00e3), top: B:194:0x00d7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Ap(int i) {
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
        Aq(i);
        final com.baidu.tieba.pb.data.e pbData = ao.cHc().getPbData();
        if (pbData != null && pbData.cCy() != null) {
            pbData.cCy().kq(0);
            this.jOz = ao.cHc().cFL();
            this.jOx = ao.cHc().cHh();
            this.jOB = ao.cHc().cHi();
            this.jPu = ao.cHc().cHg();
            this.jPv = ao.cHc().cHf();
            this.jPw = ao.cHc().cHe();
            this.jPy = ao.cHc().cHj();
            this.mTabIndex = ao.cHc().getTabIndex();
            this.jPr = this.jOx;
            if (this.jOx || this.isFromMark) {
                this.jOX = false;
            }
            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.jPb) {
            a(cGf(), true, this.jOu, 3);
        }
        if (i == 3 && !this.jPb) {
            if (this.isFromMark) {
                a(cGf(), true, this.jOu, 3);
            } else {
                a(cGf(), false, this.jOu, 3);
            }
        }
        this.jPb = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.jPA == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.eki);
        if (this.jOx || this.isFromMark) {
            this.jOX = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.jOs == null || this.jOs.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.jOs, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.ar.aUX().aUY() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.jOz) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.jOx) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.jOM) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.jOL));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.jOX) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.jOT, 0));
            pbPageRequestMessage.setOpMessageID(this.jOL);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> cCA = this.jIU.cCA();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jOG - 1));
                        if (this.jOG - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.jOJ) {
                                if (cCA != null && cCA.size() > 0) {
                                    size = cCA.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = cCA.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.jOu = postData.getId();
                                            if (StringUtils.isNull(this.jOu)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.jOF + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.jOu == null && this.jOu.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jOu, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jOF + 1));
                        if (this.jOF >= this.jOH) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (cCA != null) {
                                size = cCA.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.jOu == null) {
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
                if (cCA != null) {
                }
                if (this.jOu == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (cCA != null && cCA.size() > 0 && cCA.get(0) != null) {
                    this.jOu = cCA.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (cGA()) {
                        if (this.jOG - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.jOG - 1));
                        }
                    } else if (this.jOF < this.jOH) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jOF + 1));
                    }
                }
                if (this.jOu != null && this.jOu.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jOu, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.jOx) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (cGA()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.jOH > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.jOH));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jOu, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.jOE));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.jPr && !this.jOx) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jOu, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.jOx) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.jPf);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.jPt, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.jPr = this.jOx;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cGf());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.jPs));
        pbPageRequestMessage.setIsSubPostDataReverse(this.jPe);
        pbPageRequestMessage.setFromSmartFrs(this.jPh ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.jOw);
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.jOH) {
                    i4 = -1;
                } else {
                    i4 = cGH();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = cGH();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.jOs);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean cDE() {
        switch (cGt()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().cCy() == null || !getPbData().cCy().aRV();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cDF()) && com.baidu.tieba.recapp.q.cUC().cUw() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.cUC().cUw().aQ(cDF(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.cUC().cUw().aR(cDF(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cDF()) && com.baidu.tieba.recapp.q.cUC().cUw() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.cUC().cUw().aR(cDF(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.cUC().cUw().aQ(cDF(), true));
        }
    }

    protected void Aq(int i) {
        boolean z = false;
        Av(i);
        ArrayList<PostData> cCA = this.jIU.cCA();
        this.jPa = false;
        if (i == 1) {
            boolean z2 = false;
            while (cCA.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cCA.remove(0);
                z2 = true;
            }
            if (z2) {
                this.jIU.getPage().ko(1);
                if (this.jOS != null) {
                    this.jOS.e(this.jIU);
                }
            }
            this.hGz = System.currentTimeMillis();
            this.jPa = true;
        } else if (i == 2) {
            while (cCA.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                cCA.remove(cCA.size() - 1);
                z = true;
            }
            if (z) {
                this.jIU.getPage().kn(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.e eVar2 = z ? null : eVar;
        this.jPi = i2;
        this.isLoading = false;
        if (eVar2 != null) {
            l(eVar2);
        }
        k(eVar2);
        if (this.jPA != null && this.jPA.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(eVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCQ() != null && eVar.cCQ().ddx() != null && eVar.cCQ().ddx().goods != null && eVar.cCQ().isValidate() && eVar.cCQ().ddx().goods.goods_style != 1001) {
            this.jPA = eVar.cCQ();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n cFX() {
        return this.jPA;
    }

    public void cFY() {
        this.jPA = null;
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
            if (this.jOQ || this.jOO || this.jOP) {
                eVar = n(eVar);
            }
            m(eVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            String o = o(eVar);
            for (int i = 0; i < eVar.cCA().size(); i++) {
                PostData postData = eVar.cCA().get(i);
                for (int i2 = 0; i2 < postData.ddG().size(); i2++) {
                    postData.ddG().get(i2).a(this.gRG.getPageContext(), o.equals(postData.ddG().get(i2).aQx().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.p cCM = eVar.cCM();
            if (cCM != null && !com.baidu.tbadk.core.util.v.isEmpty(cCM.jGE)) {
                for (PostData postData2 : cCM.jGE) {
                    for (int i3 = 0; i3 < postData2.ddG().size(); i3++) {
                        postData2.ddG().get(i3).a(this.gRG.getPageContext(), o.equals(postData2.ddG().get(i3).aQx().getUserId()));
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, int i) {
        if (eVar != null) {
            String o = o(eVar);
            com.baidu.tieba.pb.data.p cCM = eVar.cCM();
            if (cCM != null && !com.baidu.tbadk.core.util.v.isEmpty(cCM.jGE)) {
                for (PostData postData : cCM.jGE.subList(i, cCM.jGE.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.ddG().size()) {
                            postData.ddG().get(i3).a(this.gRG.getPageContext(), o.equals(postData.ddG().get(i3).aQx().getUserId()));
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
        bk cCy = eVar.cCy();
        cCy.kv(this.mIsGood);
        cCy.ku(this.jOC);
        if (this.jOD > 0) {
            cCy.ca(this.jOD);
            return eVar;
        }
        return eVar;
    }

    protected String o(com.baidu.tieba.pb.data.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.cCy() != null && eVar.cCy().aQx() != null) {
            str = eVar.cCy().aQx().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData cFZ() {
        if (this.jIU == null || this.jIU.cCy() == null || this.jIU.cCy().aQx() == null) {
            return null;
        }
        return this.jIU.cCy().aQx();
    }

    protected void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int size;
        int i4;
        int i5;
        boolean z4 = !z;
        this.jPg = z3;
        if (this.gSP != null && !z3) {
            this.gSP.a(z2, z4, i2, str, i3, j, j2);
            this.gSP = null;
        }
        if (this.jIU != null) {
            this.jIU.jFR = z3;
            this.jIU.WR = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(cDF()) && com.baidu.tieba.recapp.q.cUC().cUw() != null) {
            com.baidu.tieba.recapp.q.cUC().cUw().f(cDF(), Ar(cGi()), true);
        }
        if (eVar == null || (this.jOE == 1 && i == 5 && eVar.cCA() != null && eVar.cCA().size() < 1)) {
            if (this.jOS != null) {
                this.jOz = this.jOy;
                if (i2 != 350006) {
                    this.mSortType = this.jOA;
                }
                this.jOS.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.jOy = this.jOz;
            if (i != 8) {
                this.jOA = this.mSortType;
                this.mSortType = eVar.jFc;
            }
            if (eVar.jFb != null && eVar.jFb.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.gRG.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                eVar.jFb = new ArrayList();
                eVar.jFb.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.gRG.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                eVar.jFb.add(builder2.build(false));
                this.mSortType = this.jOA;
                eVar.jFc = this.mSortType;
            }
            this.jOM = false;
            if (eVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(eVar.getPage());
            }
            this.jOH = this.jOH < 1 ? 1 : this.jOH;
            ArrayList<PostData> cCA = this.jIU.cCA();
            switch (i) {
                case 1:
                    this.jIU.a(eVar.getPage(), 1);
                    d(eVar, cCA);
                    i4 = 0;
                    break;
                case 2:
                    if (eVar.cCA() == null) {
                        i5 = 0;
                    } else {
                        int size2 = eVar.cCA().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(cCA, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cCA(), com.baidu.tbadk.core.util.v.getCount(eVar.cCA()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            eVar.cCA().remove(postData2);
                            i5 = size2 - 1;
                        }
                        cCA.addAll(0, eVar.cCA());
                    }
                    this.jIU.a(eVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && eVar.getPage() != null) {
                        eVar.getPage().kl(eVar.getPage().aPo());
                    }
                    p(eVar);
                    i4 = 0;
                    break;
                case 4:
                    p(eVar);
                    i4 = 0;
                    break;
                case 5:
                    p(eVar);
                    i4 = 0;
                    break;
                case 6:
                    p(eVar);
                    i4 = 0;
                    break;
                case 7:
                    p(eVar);
                    i4 = 0;
                    break;
                case 8:
                    if (eVar != null && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cCA()) && this.jIU != null && (!this.jOx || o(eVar).equals(eVar.cCA().get(0).aQx().getUserId()))) {
                        if (this.jIU.getPage().aPt() == 0) {
                            this.jIU.getPage().kn(1);
                        }
                        cGu();
                        this.jPu = eVar.cCA().get(0);
                        if (cGA() || this.jIU.cCZ()) {
                            if (this.jIU.cCA().size() - this.jPw >= 3) {
                                this.jPv = new PostData();
                                this.jPv.lmu = true;
                                this.jPv.setPostType(53);
                                this.jIU.cCA().add(this.jPv);
                            }
                            this.jIU.cCA().add(this.jPu);
                            size = this.jIU.cCA().size() - 1;
                        } else {
                            if (this.jPw - this.jPx >= 3) {
                                this.jPv = new PostData();
                                this.jPv.lmu = false;
                                this.jPv.setPostType(53);
                                this.jIU.cCA().add(0, this.jPv);
                            }
                            this.jIU.cCA().add(0, this.jPu);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.isTaday(com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.jPu.lmH = this.jIU.cCX();
                            com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        }
                        i4 = size;
                        break;
                    }
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.jIU != null && this.jIU.cCy() != null) {
                PraiseData aQi = this.jIU.cCy().aQi();
                if (this.jPJ != null && !aQi.isPriaseDataValid()) {
                    this.jIU.cCy().a(this.jPJ);
                } else {
                    this.jPJ = this.jIU.cCy().aQi();
                    this.jPJ.setPostId(this.jIU.cCy().aQP());
                }
                if (eVar.getPage() != null && eVar.getPage().aPr() == 1 && eVar.cCy() != null && eVar.cCy().aQI() != null && eVar.cCy().aQI().size() > 0) {
                    this.jIU.cCy().x(eVar.cCy().aQI());
                }
                this.jIU.cCy().ks(eVar.cCy().aQo());
                this.jIU.cCy().kp(eVar.cCy().getAnchorLevel());
                this.jIU.cCy().kq(eVar.cCy().aQe());
                if (this.mThreadType == 33) {
                    this.jIU.cCy().aQx().setHadConcerned(eVar.cCy().aQx().hadConcerned());
                }
                if (eVar != null && eVar.cCy() != null) {
                    this.jIU.cCy().kx(eVar.cCy().aQM());
                }
            }
            if (this.jIU != null && this.jIU.getUserData() != null && eVar.getUserData() != null) {
                this.jIU.getUserData().setBimg_end_time(eVar.getUserData().getBimg_end_time());
                this.jIU.getUserData().setBimg_url(eVar.getUserData().getBimg_url());
            }
            if (eVar.getPage() != null && eVar.getPage().aPr() == 1 && eVar.cCL() != null) {
                this.jIU.f(eVar.cCL());
            }
            if (this.jPg) {
                if (this.jIU.cCy() != null && this.jIU.cCy().aQx() != null && this.jIU.cCA() != null && com.baidu.tbadk.core.util.v.getItem(this.jIU.cCA(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(this.jIU.cCA(), 0);
                    MetaData aQx = this.jIU.cCy().aQx();
                    if (postData3.aQx() != null && postData3.aQx().getGodUserData() != null) {
                        if (this.jOV != -1) {
                            aQx.setFansNum(this.jOV);
                            postData3.aQx().setFansNum(this.jOV);
                        }
                        if (this.jOW != -1) {
                            aQx.getGodUserData().setIsLike(this.jOW == 1);
                            postData3.aQx().getGodUserData().setIsLike(this.jOW == 1);
                            aQx.getGodUserData().setIsFromNetWork(false);
                            postData3.aQx().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.jIU.jFa = -1;
                this.jIU.jEZ = -1;
            }
            if (this.jOS != null) {
                this.jOS.a(true, getErrorCode(), i, i4, this.jIU, this.mErrorString, 1);
            }
        }
        if (this.jIU != null && this.jIU.cCy() != null && this.jIU.getForum() != null && !this.jIU.cCZ()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.gRG.getPageContext();
            historyMessage.threadId = getPbData().cCy().getId();
            if (this.mIsShareThread && getPbData().cCy().dHm != null) {
                historyMessage.threadName = getPbData().cCy().dHm.showText;
            } else {
                historyMessage.threadName = getPbData().cCy().getTitle();
            }
            if (this.mIsShareThread && !cDE()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = cFL();
            historyMessage.threadType = getPbData().cCy().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        String aO;
        if (arrayList != null && eVar.cCA() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cCA(), 0);
            if (postData != null && (aO = aO(arrayList)) != null && aO.equals(postData.getId())) {
                eVar.cCA().remove(postData);
            }
            this.jIU.jFQ = arrayList.size();
            arrayList.addAll(eVar.cCA());
        }
    }

    private int Ar(int i) {
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

    private String aO(ArrayList<PostData> arrayList) {
        int count = com.baidu.tbadk.core.util.v.getCount(arrayList);
        if (count <= 0) {
            return null;
        }
        for (int i = count - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    private void p(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            eVar.Je(this.jIU.cCS());
            if (!this.jIU.jFO && eVar.jFO && this.jIU.cCI() != null) {
                eVar.e(this.jIU.cCI());
            }
            this.jIU = eVar;
            Ao(eVar.getPage().aPr());
        }
    }

    public boolean cGa() {
        if (this.jOs == null || this.jOu == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return Ap(4);
        }
        return Ap(6);
    }

    public boolean rE(boolean z) {
        if (this.jOs == null || this.jIU == null) {
            return false;
        }
        if (z || this.jIU.getPage().aPt() != 0) {
            return Ap(1);
        }
        return false;
    }

    public boolean rF(boolean z) {
        if (this.jOs == null || this.jIU == null) {
            return false;
        }
        if ((z || this.jIU.getPage().aPu() != 0) && this.jIU.cCA() != null && this.jIU.cCA().size() >= 1) {
            return Ap(2);
        }
        return false;
    }

    public boolean Jr(String str) {
        this.jOx = !this.jOx;
        this.jOu = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").ag("obj_source", 0));
        if (Ap(6)) {
            return true;
        }
        this.jOx = this.jOx ? false : true;
        return false;
    }

    public boolean w(boolean z, String str) {
        if (this.jOx == z) {
            return false;
        }
        this.jOx = z;
        this.jOu = str;
        if (this.mSortType == 2) {
            this.jOu = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").ag("obj_source", 1));
        }
        if (Ap(6)) {
            return true;
        }
        this.jOx = z ? false : true;
        return false;
    }

    public boolean As(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.jOy = this.jOz;
        this.jOA = this.mSortType;
        this.mSortType = i;
        this.jOz = !this.jOz;
        if (i == 2 && this.isFromMark) {
            this.jOu = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.jOz = this.jOz ? false : true;
            this.mSortType = this.jOA;
            return false;
        }
        return true;
    }

    public boolean cGb() {
        return cGA();
    }

    public int cGc() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.jIU == null || this.jIU.getForum() == null || this.jIU.cCy() == null) ? false : true;
    }

    public boolean aML() {
        if (this.jIU == null) {
            return false;
        }
        return this.jIU.aML();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData yf(String str) {
        if (this.jIU == null || this.jIU.cCy() == null || this.jIU.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.jIU.cCy().aRV()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.jIU.getForum().getId());
            writeData.setForumName(this.jIU.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.jPs);
        writeData.setThreadId(this.jOs);
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

    public MarkData At(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.jIU == null) {
            return null;
        }
        ArrayList<PostData> cCA = this.jIU.cCA();
        if (com.baidu.tbadk.core.util.v.isEmpty(cCA)) {
            return null;
        }
        if (cCA.size() > 0 && i >= cCA.size()) {
            i = cCA.size() - 1;
        }
        return o(cCA.get(i));
    }

    public MarkData cGd() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.jOs);
        markData.setPostId(this.jIU.aMK());
        markData.setTime(date.getTime());
        markData.setHostMode(this.jOx);
        markData.setSequence(Boolean.valueOf(cGA()));
        markData.setId(this.jOs);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.jOs);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.jOx);
        markData.setSequence(Boolean.valueOf(cGA()));
        markData.setId(this.jOs);
        markData.setFloor(postData.ddJ());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) postData).isApp());
        }
        return markData;
    }

    public void cGe() {
        j.cEs().aK(cGf(), this.isFromMark);
    }

    private String cGf() {
        String cGg = (this.jOs == null || this.jOs.equals("0")) ? cGg() : this.jOs;
        if (this.jOx) {
            cGg = cGg + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            cGg = cGg + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return cGg + TbadkCoreApplication.getCurrentAccount();
        }
        return cGg;
    }

    private String cGg() {
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

    public void rG(boolean z) {
        if (this.jIU != null) {
            this.jIU.gC(z);
        }
    }

    public boolean cGh() {
        return this.jOX;
    }

    public void a(a aVar) {
        this.jOS = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bds() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bdr() {
        return cFW();
    }

    public boolean Js(String str) {
        if (getPbData() == null || getPbData().cCy() == null || getPbData().cCy().aQx() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().cCy().aQx().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int cGi() {
        return this.mRequestType;
    }

    public void cGj() {
        if ("personalize_page".equals(this.mStType)) {
            this.jPd = System.currentTimeMillis() / 1000;
        }
    }

    public void cGk() {
        if ("personalize_page".equals(this.mStType) && this.jIU != null && this.jPd != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").dh("fid", this.jIU.getForumId()).dh("tid", this.jOs).dh("obj_duration", String.valueOf(currentTimeMillis - this.jPd)).dh(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.jPd = 0L;
        }
    }

    public boolean cGl() {
        return this.jPg;
    }

    public int getErrorNo() {
        return this.jPi;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public o cGm() {
        return this.jPk;
    }

    public ae cGn() {
        return this.jPl;
    }

    public CheckRealNameModel cGo() {
        return this.jPn;
    }

    public AddExperiencedModel cGp() {
        return this.jPo;
    }

    public String cGq() {
        return this.jPc;
    }

    public void Jt(String str) {
        this.jPc = str;
    }

    public boolean cGr() {
        return this.jPh;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.jIU != null && this.jIU.cCA() != null && this.jIU.cCA().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.jIU.cCA().size();
                for (int i = 0; i < size; i++) {
                    if (this.jIU.cCA().get(i) != null && this.jIU.cCA().get(i).aQx() != null && currentAccount.equals(this.jIU.cCA().get(i).aQx().getUserId()) && this.jIU.cCA().get(i).aQx().getPendantData() != null) {
                        this.jIU.cCA().get(i).aQx().getPendantData().vx(lVar.aOP());
                        this.jIU.cCA().get(i).aQx().getPendantData().cr(lVar.bcC());
                    }
                }
            }
        }
    }

    public String cGs() {
        return this.jPm;
    }

    public int cGt() {
        return this.jPs;
    }

    public void Au(int i) {
        this.jPs = i;
    }

    public void Ju(String str) {
        if ((!this.jOx || Js(TbadkCoreApplication.getCurrentAccount())) && this.jIU.cCA() != null) {
            this.jIU.getPage().kn(1);
            if (this.jIU.getPage().aPt() == 0) {
                this.jIU.getPage().kn(1);
            }
            this.jPt = str;
            Ap(8);
        }
    }

    private void Av(int i) {
        if (i != 8) {
            this.jPt = "";
            if (this.jPu != null) {
                if (i == 1 && this.jIU != null && this.jIU.cCZ()) {
                    if (this.jPv != null) {
                        getPbData().cCA().remove(this.jPv);
                    }
                } else if (i == 1 && !this.jOz && !com.baidu.tbadk.core.util.v.isEmpty(getPbData().cCA())) {
                    getPbData().cCA().remove(this.jPu);
                    if (this.jPv != null) {
                        getPbData().cCA().remove(this.jPv);
                    }
                    getPbData().cCA().add(0, this.jPu);
                } else {
                    getPbData().cCA().remove(this.jPu);
                    if (this.jPv != null) {
                        getPbData().cCA().remove(this.jPv);
                    }
                }
            }
            this.jPv = null;
        }
    }

    public void cGu() {
        if (this.jIU != null && !com.baidu.tbadk.core.util.v.isEmpty(this.jIU.cCA())) {
            if (this.jPv != null) {
                this.jIU.cCA().remove(this.jPv);
                this.jPv = null;
            }
            if (this.jPu != null) {
                this.jIU.cCA().remove(this.jPu);
                this.jPu = null;
            }
        }
    }

    public void cD(int i, int i2) {
        this.jPw = i;
        this.jPx = i2;
    }

    public PostData cGv() {
        return this.jPu;
    }

    public PostData cGw() {
        return this.jPv;
    }

    public int cGx() {
        return this.jPw;
    }

    public int cGy() {
        return this.jPx;
    }

    public String cGz() {
        return this.jPz;
    }

    public void Jv(String str) {
        this.jPz = str;
    }

    private boolean cGA() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean cGB() {
        return this.jPs == 13 || this.jPs == 12;
    }

    public String cGC() {
        return this.jPC;
    }

    public String cGD() {
        return this.jPD;
    }

    public String cGE() {
        return this.jPE;
    }

    public String cGF() {
        return this.jPF;
    }

    public Rect cGG() {
        Rect rect = this.jPy;
        this.jPy = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int cGH() {
        int i;
        int i2 = 0;
        if (getPbData().cCA() == null) {
            return 0;
        }
        ArrayList<PostData> cCA = getPbData().cCA();
        int size = cCA.size() - 1;
        while (size >= 0) {
            PostData postData = cCA.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
                if (postData.getType() != AdvertAppInfo.dAi) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return cCA.size();
    }
}
