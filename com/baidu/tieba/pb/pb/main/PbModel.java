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
    private boolean eAY;
    private long iWG;
    private BaseFragmentActivity ifx;
    private com.baidu.tieba.tbadkCore.d.b igC;
    private boolean isAd;
    private boolean isFromMark;
    public boolean isLoading;
    private boolean isPrivacy;
    private boolean kqs;
    protected com.baidu.tieba.pb.data.f lkO;
    private boolean lrA;
    private String lrB;
    private boolean lrC;
    private boolean lrD;
    private boolean lrE;
    private boolean lrF;
    private a lrG;
    private String lrH;
    private String lrI;
    private int lrJ;
    private int lrK;
    private boolean lrL;
    private boolean lrM;
    private boolean lrN;
    private boolean lrO;
    private boolean lrP;
    private String lrQ;
    private long lrR;
    private boolean lrS;
    private int lrT;
    private boolean lrU;
    private boolean lrV;
    private int lrW;
    private final ag lrX;
    private final q lrY;
    private final ai lrZ;
    protected String lrg;
    private String lrh;
    private String lri;
    private String lrj;
    private boolean lrk;
    private boolean lrl;
    private boolean lrm;
    private boolean lrn;
    private int lro;
    private boolean lrp;
    private int lrq;
    private long lrr;
    private int lrs;
    private int lrt;
    private int lru;
    private int lrv;
    private boolean lrw;
    private boolean lrx;
    private boolean lry;
    private long lrz;
    private String lsa;
    private final CheckRealNameModel lsb;
    private final AddExperiencedModel lsc;
    private SuggestEmotionModel lsd;
    private GetSugMatchWordsModel lse;
    private boolean lsf;
    private int lsg;
    private String lsh;
    private PostData lsi;
    private PostData lsj;
    private int lsk;
    private int lsl;
    private Rect lsm;
    private String lsn;
    private com.baidu.tieba.tbadkCore.data.n lso;
    private boolean lsp;
    private String lsq;
    private String lsr;
    private String lss;
    private String lst;
    private String lsu;
    private f.a lsv;
    private CustomMessageListener lsw;
    private com.baidu.adp.framework.listener.a lsx;
    private PraiseData lsy;
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
    private static final int lrf = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
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
        this.lrg = null;
        this.isPrivacy = false;
        this.lrh = null;
        this.lri = null;
        this.mForumId = null;
        this.lrj = null;
        this.lrk = false;
        this.lrl = false;
        this.lrm = true;
        this.lrn = true;
        this.mSortType = 0;
        this.lro = 0;
        this.lrp = false;
        this.mIsGood = 0;
        this.lrq = 0;
        this.lrr = 0L;
        this.lrs = 1;
        this.lrt = 1;
        this.lru = 1;
        this.lrv = 1;
        this.isAd = false;
        this.kqs = false;
        this.eAY = false;
        this.lrw = false;
        this.isFromMark = false;
        this.lrx = false;
        this.lry = false;
        this.lrz = 0L;
        this.lrA = false;
        this.lrB = null;
        this.lkO = null;
        this.isLoading = false;
        this.lrC = false;
        this.lrD = false;
        this.lrE = false;
        this.lrF = false;
        this.mLocate = null;
        this.mContext = null;
        this.lrG = null;
        this.opType = null;
        this.opUrl = null;
        this.lrH = null;
        this.lrI = null;
        this.lrJ = -1;
        this.lrK = -1;
        this.igC = null;
        this.lrM = false;
        this.lrN = false;
        this.postID = null;
        this.lrQ = null;
        this.lrR = 0L;
        this.lrS = false;
        this.lrT = -1;
        this.lrV = false;
        this.lsf = false;
        this.lsg = 0;
        this.mTabIndex = 0;
        this.lsp = false;
        this.lsw = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.lsx = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.ifx.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.lrM || !PbModel.this.lrN) {
                        if (!PbModel.this.lrM) {
                            PbModel.this.lrM = true;
                        } else {
                            PbModel.this.lrN = true;
                        }
                        if (PbModel.this.lrG != null) {
                            PbModel.this.lrG.a(PbModel.this.diQ(), z, responsedMessage, PbModel.this.lrO, System.currentTimeMillis() - PbModel.this.iWG);
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
                    if (PbModel.this.lkO != null && PbModel.this.lkO.dfH() != null && PbModel.this.lkO.dfH().getForumId() != null && PbModel.this.lkO.dfH().getForumId().equals(valueOf)) {
                        PbModel.this.lkO.dfH().setIsLike(false);
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
                    if (PbModel.this.lkO != null && PbModel.this.lkO.dfH() != null && PbModel.this.lkO.dfH().getForumId() != null && PbModel.this.lkO.dfH().getForumId().equals(valueOf)) {
                        PbModel.this.lkO.dfH().setIsLike(true);
                    }
                }
            }
        };
        this.lsy = null;
        registerListener(this.lsx);
        registerListener(this.lsw);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.lkO = new com.baidu.tieba.pb.data.f();
        this.lkO.Fp(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.ifx = baseFragmentActivity;
        this.lrX = new ag(this, this.ifx);
        this.lrY = new q(this, this.ifx);
        this.lrZ = new ai(this, this.ifx);
        this.lsb = new CheckRealNameModel(this.ifx.getPageContext());
        this.lsd = new SuggestEmotionModel();
        this.lsc = new AddExperiencedModel(this.ifx.getPageContext());
        this.lsv = new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            @Override // com.baidu.tbadk.BdToken.f.a
            public void B(HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.elN) instanceof String) {
                        PbModel.this.lrg = (String) hashMap.get(com.baidu.tbadk.BdToken.f.elN);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.elO) instanceof String) {
                        PbModel.this.oriUgcNid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.elO);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.elP) instanceof String) {
                        PbModel.this.oriUgcTid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.elP);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.elQ) instanceof String) {
                        PbModel.this.oriUgcType = com.baidu.adp.lib.f.b.toInt((String) hashMap.get(com.baidu.tbadk.BdToken.f.elQ), 0);
                    }
                    if (hashMap.get(com.baidu.tbadk.BdToken.f.elR) instanceof String) {
                        PbModel.this.oriUgcVid = (String) hashMap.get(com.baidu.tbadk.BdToken.f.elR);
                    }
                }
            }
        };
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.lrP = true;
        if (fVar != null && fVar.lgZ == null) {
            q(fVar);
            l(fVar);
            if (fVar.dfI() != null) {
                fVar.dfI().nX(0);
            }
            if (this.lrG != null && fVar != null) {
                this.lrG.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int diQ() {
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
            this.lrg = intent.getStringExtra("thread_id");
            this.isPrivacy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.lsu = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (com.baidu.tbadk.BdToken.f.p(uri)) {
                com.baidu.tbadk.BdToken.f.bdZ().c(uri, this.lsv);
            } else if (StringUtils.isNull(this.lrg)) {
                this.lrX.a(intent, this.lsv);
                if (uri != null) {
                    if (StringUtils.isNull(this.lrg)) {
                        this.lrg = uri.getQueryParameter("thread_id");
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
            if (com.baidu.tbadk.core.util.at.isEmpty(this.lrg)) {
                this.lrg = "0";
            }
            this.lsg = intent.getIntExtra("key_start_from", 0);
            if (this.lsg == 0) {
                this.lsg = this.lrX.aJu;
            }
            this.lri = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.lrh = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.lrk = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.lrl = intent.getBooleanExtra("host_only", false);
            this.lrn = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, -1);
            this.mSortType = this.mSortType < 0 ? com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_pb_current_sort_type", 2) : this.mSortType;
            this.lri = this.mSortType == 2 ? "0" : this.lri;
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.lrq = intent.getIntExtra("is_top", 0);
            this.lrr = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.lrx = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.lry = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.kqs = intent.getBooleanExtra("is_sub_pb", false);
            this.lrA = intent.getBooleanExtra("is_pv", false);
            this.lrz = intent.getLongExtra("msg_id", 0L);
            this.lrB = intent.getStringExtra("from_forum_name");
            this.lrI = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.lrH = intent.getStringExtra("op_stat");
            this.lrC = intent.getBooleanExtra("is_from_thread_config", false);
            this.lrD = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.lrE = intent.getBooleanExtra("is_from_my_god_config", false);
            this.lrK = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.lrJ = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.eAY = intent.getBooleanExtra("from_frs", false);
            this.lrw = intent.getBooleanExtra("from_maintab", false);
            this.lrV = intent.getBooleanExtra("from_smart_frs", false);
            this.lrF = intent.getBooleanExtra("from_hottopic", false);
            this.lsa = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.lrj = intent.getStringExtra("high_light_post_id");
            this.lsp = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.lrL = intent.getIntExtra("request_code", -1) == 18003;
            this.lsq = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.lsr = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.lss = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.lst = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean diR() {
        return this.lsp && com.baidu.tieba.frs.l.cvz() != null && com.baidu.tieba.frs.l.cvz().equals(this.lrg) && com.baidu.tieba.frs.l.cvy() != null;
    }

    public com.baidu.tieba.pb.data.f aI(bw bwVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.Fp(3);
        if (bwVar == null) {
            return null;
        }
        fVar.aF(bwVar);
        if (bwVar.blO() != null) {
            fVar.d(bwVar.blO());
            ForumData forum = fVar.getForum();
            forum.setId(bwVar.blO().getForumId());
            forum.setName(bwVar.blO().getForumName());
            forum.setUser_level(bwVar.blO().bjq());
            forum.setImage_url(bwVar.blO().getAvatar());
            forum.setPost_num(bwVar.blO().postNum);
            forum.setMember_num(bwVar.blO().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(bwVar.getFid()));
            forum2.setName(bwVar.bke());
        }
        PostData postData = new PostData();
        postData.Jq(1);
        postData.setTime(bwVar.getCreateTime());
        postData.a(bwVar.bka());
        MetaData bka = bwVar.bka();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(bka.getUserId(), bka);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bwVar.bjQ(), false));
        fVar.d(postData);
        fVar.dfK().add(postData);
        fVar.a(new com.baidu.tieba.pb.data.o(bwVar, null));
        fVar.lhe = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.lsg = bundle.getInt("key_start_from", 0);
        this.lrg = bundle.getString("thread_id");
        this.lri = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.lrh = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.lrk = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.lrl = bundle.getBoolean("host_only", false);
        this.lrn = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.lrq = bundle.getInt("is_top", 0);
        this.lrr = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.lry = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.kqs = bundle.getBoolean("is_sub_pb", false);
        this.lrA = bundle.getBoolean("is_pv", false);
        this.lrz = bundle.getLong("msg_id", 0L);
        this.lrB = bundle.getString("from_forum_name");
        this.lrI = bundle.getString("extra_pb_cache_key");
        this.lrC = bundle.getBoolean("is_from_thread_config", false);
        this.lrD = bundle.getBoolean("is_from_interview_live_config", false);
        this.lrE = bundle.getBoolean("is_from_my_god_config", false);
        this.lrK = bundle.getInt("extra_pb_is_attention_key", -1);
        this.lrJ = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eAY = bundle.getBoolean("from_frs", false);
        this.lrw = bundle.getBoolean("from_maintab", false);
        this.lrV = bundle.getBoolean("from_smart_frs", false);
        this.lrF = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.lrj = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.lrL = bundle.getInt("request_code", -1) == 18003;
        this.lsq = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.lsr = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.lss = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.lst = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void aC(Bundle bundle) {
        bundle.putString("thread_id", this.lrg);
        bundle.putString("post_id", this.lri);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.lsg);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.lrk);
        bundle.putBoolean("host_only", this.lrl);
        bundle.putBoolean("squence", this.lrn);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.lrq);
        bundle.putLong("thread_time", this.lrr);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.lry);
        bundle.putBoolean("is_sub_pb", this.kqs);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.lrA);
        bundle.putLong("msg_id", this.lrz);
        bundle.putString("extra_pb_cache_key", this.lrI);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.lrC);
        bundle.putBoolean("is_from_interview_live_config", this.lrD);
        bundle.putBoolean("is_from_my_god_config", this.lrE);
        bundle.putInt("extra_pb_is_attention_key", this.lrK);
        bundle.putInt("extra_pb_funs_count_key", this.lrJ);
        bundle.putBoolean("from_frs", this.eAY);
        bundle.putBoolean("from_maintab", this.lrw);
        bundle.putBoolean("from_smart_frs", this.lrV);
        bundle.putBoolean("from_hottopic", this.lrF);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.lrj);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.lsq);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.lsr);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.lss);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.lst);
    }

    public String diS() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.lrg);
        if (!this.lry) {
            sb.append(this.lri);
        }
        sb.append(this.lrl);
        sb.append(this.lrn);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.lrq);
        sb.append(this.lrr);
        sb.append(this.eAY);
        sb.append(this.lrw);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.kqs);
        sb.append(this.lrA);
        sb.append(this.lrz);
        sb.append(this.lrB);
        sb.append(this.mThreadType);
        sb.append(this.lrC);
        sb.append(this.lrD);
        sb.append(this.lrE);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.lrI != null) {
            sb.append(this.lrI);
        }
        return sb.toString();
    }

    public String dgP() {
        return this.lrB;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String diT() {
        return this.lri;
    }

    public String diU() {
        return this.lrj;
    }

    public String diV() {
        return this.lrg;
    }

    public String diW() {
        return (StringUtils.isNull(this.lrg) || "0".equals(this.lrg)) ? this.oriUgcNid : this.lrg;
    }

    public boolean getHostMode() {
        return this.lrl;
    }

    public boolean diX() {
        return djM();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean diY() {
        return this.eAY;
    }

    public boolean diZ() {
        return this.lrp;
    }

    public boolean dja() {
        return this.lrw;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean djb() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int coB() {
        return this.lrq;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void FH(int i) {
        this.lrq = i;
    }

    public boolean djc() {
        return this.kqs;
    }

    public boolean djd() {
        if (this.lkO == null) {
            return false;
        }
        return this.lkO.isValid();
    }

    public String bki() {
        if (this.lkO == null || !this.lkO.bfV()) {
            return null;
        }
        return this.lkO.bfU();
    }

    public boolean FI(int i) {
        this.lrs = i;
        if (this.lrs > this.lkO.getPage().biL()) {
            this.lrs = this.lkO.getPage().biL();
        }
        if (this.lrs < 1) {
            this.lrs = 1;
        }
        if (this.lrg == null) {
            return false;
        }
        return FK(5);
    }

    public void FJ(int i) {
        this.lrs = i;
        this.lrt = i;
        this.lru = i;
    }

    public void b(com.baidu.tbadk.core.data.av avVar) {
        if (avVar == null) {
            FJ(1);
            return;
        }
        if (this.lrt < avVar.biO()) {
            this.lrt = avVar.biO();
        }
        if (this.lru > avVar.biO()) {
            this.lru = avVar.biO();
        }
        this.lrv = avVar.biL();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.lkO;
    }

    public BaijiahaoData dje() {
        if (this.lkO == null || this.lkO.dfI() == null) {
            return null;
        }
        return this.lkO.dfI().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f djf() {
        if (this.lkO == null) {
            return this.lkO;
        }
        if (!djg() && this.lso != null) {
            this.lkO.b(this.lso);
        }
        return this.lkO;
    }

    private boolean djg() {
        return (this.lkO.dga() == null || this.lkO.dga().dHl() == null || this.lkO.dga().dHl().goods != null || this.lkO.dga().dHl().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.av getPageData() {
        if (this.lkO == null) {
            return null;
        }
        return this.lkO.getPage();
    }

    public boolean djh() {
        if (djM() && this.lkO.getPage().biQ() == 0) {
            um(true);
            return true;
        }
        return false;
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.lrg = fVar.getThreadId();
            if (fVar.dfI() != null && fVar.dfI().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.dfI().getBaijiahaoData();
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
            this.lri = null;
            this.lrl = false;
            this.lrn = true;
            LoadData();
        }
    }

    public void Pi(String str) {
        if (!StringUtils.isNull(str)) {
            this.lrg = str;
            this.lri = null;
            this.lrl = false;
            this.lrn = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lrg == null) {
            return false;
        }
        cancelLoadData();
        if (this.igC == null) {
            this.igC = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.igC.start();
        }
        boolean FK = FK(3);
        if (this.opType != null) {
            this.opType = null;
            this.lrH = null;
            this.opUrl = null;
            return FK;
        }
        return FK;
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
        if (this.lsd != null) {
            this.lsd.cancelLoadData();
        }
        if (this.lse != null) {
            this.lse.cancelLoadData();
        }
        com.baidu.tieba.recapp.report.b.dyH().dyL();
        cpZ();
    }

    private void cpZ() {
        if (this.igC != null) {
            this.igC.destory();
            this.igC = null;
        }
    }

    public boolean dji() {
        return (this.lri == null || this.lri.equals("0") || this.lri.length() == 0) ? LoadData() : djm();
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
                this.lsd.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.lsd.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.lse == null) {
                this.lse = new GetSugMatchWordsModel(this.ifx.getPageContext());
            }
            this.lse.b(aVar);
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
    public boolean FK(int i) {
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
        FL(i);
        final com.baidu.tieba.pb.data.f pbData = as.dkq().getPbData();
        if (pbData != null && pbData.dfI() != null) {
            pbData.dfI().nX(0);
            this.lrn = as.dkq().diX();
            this.lrl = as.dkq().dkv();
            this.lrp = as.dkq().dkw();
            this.lsi = as.dkq().dku();
            this.lsj = as.dkq().dkt();
            this.lsk = as.dkq().dks();
            this.lsm = as.dkq().dkx();
            this.mTabIndex = as.dkq().getTabIndex();
            this.lsf = this.lrl;
            if (this.lrl || this.isFromMark) {
                this.lrL = false;
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
        if (i == 4 && !this.lrP) {
            a(djr(), true, this.lri, 3);
        }
        if (i == 3 && !this.lrP) {
            if (this.isFromMark) {
                a(djr(), true, this.lri, 3);
            } else {
                a(djr(), false, this.lri, 3);
            }
        }
        this.lrP = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.lso == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.fgI);
        if (this.lrl || this.isFromMark) {
            this.lrL = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.lrg == null || this.lrg.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.lrg, 0L));
        if (com.baidu.tbadk.a.d.bfw()) {
            pbPageRequestMessage.setFloorSortType(1);
            pbPageRequestMessage.set_rn(15);
        } else {
            pbPageRequestMessage.set_rn(30);
        }
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.au.boO().boP() ? 2 : 1));
        pbPageRequestMessage.setSchemeUrl(this.mSchemeUrl);
        if (!this.lrn) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.lrl) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.lrA) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.lrz));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.lrL) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.lrH, 0));
            pbPageRequestMessage.setOpMessageID(this.lrz);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> dfK = this.lkO.dfK();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lru - 1));
                        if (this.lru - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.lrx) {
                                if (dfK != null && dfK.size() > 0) {
                                    size = dfK.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = dfK.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.lri = postData.getId();
                                            if (StringUtils.isNull(this.lri)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.lrt + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.lri == null && this.lri.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lri, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lrt + 1));
                        if (this.lrt >= this.lrv) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (dfK != null) {
                                size = dfK.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.lri == null) {
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
                if (dfK != null) {
                }
                if (this.lri == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (dfK != null && dfK.size() > 0 && dfK.get(0) != null) {
                    this.lri = dfK.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (djM()) {
                        if (this.lru - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.lru - 1));
                        }
                    } else if (this.lrt < this.lrv) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lrt + 1));
                    }
                }
                if (this.lri != null && this.lri.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lri, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.lrl) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (djM()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.lrv > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.lrv));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lri, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.lrs));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.lsf && !this.lrl) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lri, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.lrl) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.lrT);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.lsh, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.lsf = this.lrl;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(djr());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.lsg));
        pbPageRequestMessage.setIsSubPostDataReverse(this.lrS);
        pbPageRequestMessage.setFromSmartFrs(this.lrV ? 1 : 0);
        if (UtilHelper.isUgcThreadType(this.oriUgcType)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.mForumId);
        }
        pbPageRequestMessage.setNeedRepostRecommendForum(this.lrk);
        if (this.lsg == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (!StringUtils.isNull(this.lsu)) {
            pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.lsu));
        }
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() == this.lrv) {
                    i4 = -1;
                } else {
                    i4 = djT();
                }
            } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                i4 = -1;
            } else {
                i4 = djT();
            }
        }
        pbPageRequestMessage.setAfterAdThreadCount(i4);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.lrg);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean dgO() {
        switch (djF()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().dfI() == null || !getPbData().dfI().blx();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dgP()) && com.baidu.tieba.recapp.r.dxM().dxG() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dxM().dxG().aZ(dgP(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dxM().dxG().ba(dgP(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(dgP()) && com.baidu.tieba.recapp.r.dxM().dxG() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.dxM().dxG().ba(dgP(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.dxM().dxG().aZ(dgP(), true));
        }
    }

    protected void FL(int i) {
        boolean z = false;
        FQ(i);
        ArrayList<PostData> dfK = this.lkO.dfK();
        this.lrO = false;
        if (i == 1) {
            boolean z2 = false;
            while (dfK.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                dfK.remove(0);
                z2 = true;
            }
            if (z2) {
                this.lkO.getPage().nT(1);
                if (this.lrG != null) {
                    this.lrG.e(this.lkO);
                }
            }
            this.iWG = System.currentTimeMillis();
            this.lrO = true;
        } else if (i == 2) {
            while (dfK.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                dfK.remove(dfK.size() - 1);
                z = true;
            }
            if (z) {
                this.lkO.getPage().nS(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.lrW = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            l(fVar2);
        }
        k(fVar2);
        if (this.lso != null && this.lso.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dga() != null && fVar.dga().dHl() != null && fVar.dga().dHl().goods != null && fVar.dga().isValidate() && fVar.dga().dHl().goods.goods_style != 1001) {
            this.lso = fVar.dga();
        }
    }

    public com.baidu.tieba.tbadkCore.data.n djj() {
        return this.lso;
    }

    public void djk() {
        this.lso = null;
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
            if (this.lrE || this.lrC || this.lrD) {
                fVar = n(fVar);
            }
            m(fVar);
        }
    }

    protected void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String o = o(fVar);
            for (int i = 0; i < fVar.dfK().size(); i++) {
                PostData postData = fVar.dfK().get(i);
                for (int i2 = 0; i2 < postData.dHu().size(); i2++) {
                    postData.dHu().get(i2).a(this.ifx.getPageContext(), o.equals(postData.dHu().get(i2).bka().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.r dfW = fVar.dfW();
            if (dfW != null && !com.baidu.tbadk.core.util.y.isEmpty(dfW.liC)) {
                for (PostData postData2 : dfW.liC) {
                    for (int i3 = 0; i3 < postData2.dHu().size(); i3++) {
                        postData2.dHu().get(i3).a(this.ifx.getPageContext(), o.equals(postData2.dHu().get(i3).bka().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String o = o(fVar);
            com.baidu.tieba.pb.data.r dfW = fVar.dfW();
            if (dfW != null && !com.baidu.tbadk.core.util.y.isEmpty(dfW.liC)) {
                for (PostData postData : dfW.liC.subList(i, dfW.liC.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.dHu().size()) {
                            postData.dHu().get(i3).a(this.ifx.getPageContext(), o.equals(postData.dHu().get(i3).bka().getUserId()));
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
        bw dfI = fVar.dfI();
        dfI.oc(this.mIsGood);
        dfI.ob(this.lrq);
        if (this.lrr > 0) {
            dfI.cL(this.lrr);
            return fVar;
        }
        return fVar;
    }

    protected String o(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.dfI() != null && fVar.dfI().bka() != null) {
            str = fVar.dfI().bka().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData djl() {
        if (this.lkO == null || this.lkO.dfI() == null || this.lkO.dfI().bka() == null) {
            return null;
        }
        return this.lkO.dfI().bka();
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int size;
        int i5;
        boolean z4 = !z;
        this.lrU = z3;
        if (this.igC != null && !z3) {
            this.igC.a(z2, z4, i2, str, i3, j, j2);
            this.igC = null;
        }
        if (this.lkO != null) {
            this.lkO.lhM = z3;
            this.lkO.YH = i;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(dgP()) && com.baidu.tieba.recapp.r.dxM().dxG() != null) {
            com.baidu.tieba.recapp.r.dxM().dxG().f(dgP(), FM(dju()), true);
        }
        if (fVar == null || (this.lrs == 1 && i == 5 && fVar.dfK() != null && fVar.dfK().size() < 1)) {
            if (this.lrG != null) {
                this.lrn = this.lrm;
                if (i2 != 350006) {
                    this.mSortType = this.lro;
                }
                this.lrG.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.lrm = this.lrn;
            if (i != 8) {
                this.lro = this.mSortType;
                this.mSortType = fVar.lgY;
            }
            if (fVar.lgX != null && fVar.lgX.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.ifx.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.lgX = new ArrayList();
                fVar.lgX.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.ifx.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.lgX.add(builder2.build(false));
                this.mSortType = this.lro;
                fVar.lgY = this.mSortType;
            }
            this.lrA = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.lrv = this.lrv < 1 ? 1 : this.lrv;
            int i6 = 0;
            ArrayList<PostData> dfK = this.lkO.dfK();
            switch (i) {
                case 1:
                    this.lkO.a(fVar.getPage(), 1);
                    d(fVar, dfK);
                    p(fVar);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.dfK() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.dfK().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dfK, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dfK(), com.baidu.tbadk.core.util.y.getCount(fVar.dfK()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.dfK().remove(postData2);
                            i5 = size2 - 1;
                        }
                        dfK.addAll(0, fVar.dfK());
                    }
                    p(fVar);
                    this.lkO.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().nQ(fVar.getPage().biL());
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
                    if (fVar != null && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dfK()) && this.lkO != null && (!this.lrl || o(fVar).equals(fVar.dfK().get(0).bka().getUserId()))) {
                        if (this.lkO.getPage().biQ() == 0) {
                            this.lkO.getPage().nS(1);
                        }
                        djG();
                        this.lsi = fVar.dfK().get(0);
                        if (djM() || this.lkO.dgl()) {
                            if (this.lkO.dfK().size() - this.lsk >= 3) {
                                this.lsj = new PostData();
                                this.lsj.mRo = true;
                                this.lsj.setPostType(53);
                                this.lkO.dfK().add(this.lsj);
                            }
                            this.lkO.dfK().add(this.lsi);
                            size = this.lkO.dfK().size() - 1;
                        } else {
                            if (this.lsk - this.lsl >= 3) {
                                this.lsj = new PostData();
                                this.lsj.mRo = false;
                                this.lsj.setPostType(53);
                                this.lkO.dfK().add(0, this.lsj);
                            }
                            this.lkO.dfK().add(0, this.lsi);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.at.isTaday(com.baidu.tbadk.core.sharedPref.b.bnH().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.lsi.mRB = this.lkO.dgj();
                            com.baidu.tbadk.core.sharedPref.b.bnH().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.lkO != null && this.lkO.dfI() != null) {
                PraiseData bjL = this.lkO.dfI().bjL();
                if (this.lsy != null && !bjL.isPriaseDataValid()) {
                    this.lkO.dfI().a(this.lsy);
                } else {
                    this.lsy = this.lkO.dfI().bjL();
                    this.lsy.setPostId(this.lkO.dfI().bkr());
                }
                if (fVar.getPage() != null && fVar.getPage().biO() == 1 && fVar.dfI() != null && fVar.dfI().bkk() != null && fVar.dfI().bkk().size() > 0) {
                    this.lkO.dfI().E(fVar.dfI().bkk());
                }
                this.lkO.dfI().nZ(fVar.dfI().bjR());
                this.lkO.dfI().nW(fVar.dfI().getAnchorLevel());
                this.lkO.dfI().nX(fVar.dfI().bjH());
                if (this.mThreadType == 33) {
                    this.lkO.dfI().bka().setHadConcerned(fVar.dfI().bka().hadConcerned());
                }
                if (fVar != null && fVar.dfI() != null) {
                    this.lkO.dfI().oe(fVar.dfI().bko());
                }
            }
            if (this.lkO != null && this.lkO.getUserData() != null && fVar.getUserData() != null) {
                this.lkO.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.lkO.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().biO() == 1 && fVar.dfV() != null) {
                this.lkO.f(fVar.dfV());
            }
            if (this.lrU) {
                if (this.lkO.dfI() != null && this.lkO.dfI().bka() != null && this.lkO.dfK() != null && com.baidu.tbadk.core.util.y.getItem(this.lkO.dfK(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(this.lkO.dfK(), 0);
                    MetaData bka = this.lkO.dfI().bka();
                    if (postData3.bka() != null && postData3.bka().getGodUserData() != null) {
                        if (this.lrJ != -1) {
                            bka.setFansNum(this.lrJ);
                            postData3.bka().setFansNum(this.lrJ);
                        }
                        if (this.lrK != -1) {
                            bka.getGodUserData().setIsLike(this.lrK == 1);
                            postData3.bka().getGodUserData().setIsLike(this.lrK == 1);
                            bka.getGodUserData().setIsFromNetWork(false);
                            postData3.bka().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.lkO.lgW = -1;
                this.lkO.lgV = -1;
            }
            if (this.lrG != null) {
                this.lrG.a(true, getErrorCode(), i, i4, this.lkO, this.mErrorString, 1);
            }
        }
        if (this.lkO != null && this.lkO.dfI() != null && this.lkO.getForum() != null && !this.lkO.dgl()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.ifx.getPageContext();
            historyMessage.threadId = getPbData().dfI().getId();
            if (this.mIsShareThread && getPbData().dfI().eAy != null) {
                historyMessage.threadName = getPbData().dfI().eAy.showText;
            } else {
                historyMessage.threadName = getPbData().dfI().getTitle();
            }
            if (this.mIsShareThread && !dgO()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = diX();
            historyMessage.threadType = getPbData().dfI().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void p(@NonNull com.baidu.tieba.pb.data.f fVar) {
        if (this.lkO != null) {
            this.lkO.dfZ().clear();
            this.lkO.dfZ().addAll(fVar.dfZ());
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String bb;
        if (arrayList != null && fVar.dfK() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dfK(), 0);
            if (postData != null && (bb = bb(arrayList)) != null && bb.equals(postData.getId())) {
                fVar.dfK().remove(postData);
            }
            this.lkO.lhL = arrayList.size();
            arrayList.addAll(fVar.dfK());
        }
    }

    private int FM(int i) {
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
            fVar.Pb(this.lkO.dgd());
            if (!this.lkO.lhJ && fVar.lhJ && this.lkO.dfS() != null) {
                fVar.e(this.lkO.dfS());
            }
            this.lkO = fVar;
            FJ(fVar.getPage().biO());
        }
    }

    public boolean djm() {
        if (this.lrg == null || this.lri == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return FK(4);
        }
        return FK(6);
    }

    public boolean um(boolean z) {
        if (this.lrg == null || this.lkO == null) {
            return false;
        }
        if (z || this.lkO.getPage().biQ() != 0) {
            return FK(1);
        }
        return false;
    }

    public boolean un(boolean z) {
        if (this.lrg == null || this.lkO == null) {
            return false;
        }
        if ((z || this.lkO.getPage().biR() != 0) && this.lkO.dfK() != null && this.lkO.dfK().size() >= 1) {
            return FK(2);
        }
        return false;
    }

    public boolean Po(String str) {
        this.lrl = !this.lrl;
        this.lri = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").aj("obj_source", 0));
        if (FK(6)) {
            return true;
        }
        this.lrl = this.lrl ? false : true;
        return false;
    }

    public boolean B(boolean z, String str) {
        if (this.lrl == z) {
            return false;
        }
        this.lrl = z;
        this.lri = str;
        if (this.mSortType == 2) {
            this.lri = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("pb_onlyowner_click").aj("obj_source", 1));
        }
        if (FK(6)) {
            return true;
        }
        this.lrl = z ? false : true;
        return false;
    }

    public boolean FN(int i) {
        if (i == this.mSortType) {
            return false;
        }
        if (i != 1) {
            com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_pb_current_sort_type", i);
        }
        this.lrm = this.lrn;
        this.lro = this.mSortType;
        this.mSortType = i;
        this.lrn = !this.lrn;
        if (i == 2 && this.isFromMark) {
            this.lri = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.lrn = this.lrn ? false : true;
            this.mSortType = this.lro;
            return false;
        }
        return true;
    }

    public boolean djn() {
        return djM();
    }

    public int djo() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.lkO == null || this.lkO.getForum() == null || this.lkO.dfI() == null) ? false : true;
    }

    public boolean bfV() {
        if (this.lkO == null) {
            return false;
        }
        return this.lkO.bfV();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData Dw(String str) {
        if (this.lkO == null || this.lkO.dfI() == null || this.lkO.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.lkO.dfI().blx()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.lkO.getForum().getId());
            writeData.setForumName(this.lkO.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.lsg);
        writeData.setThreadId(this.lrg);
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

    public MarkData FO(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.lkO == null) {
            return null;
        }
        ArrayList<PostData> dfK = this.lkO.dfK();
        if (com.baidu.tbadk.core.util.y.isEmpty(dfK)) {
            return null;
        }
        if (dfK.size() > 0 && i >= dfK.size()) {
            i = dfK.size() - 1;
        }
        return o(dfK.get(i));
    }

    public MarkData djp() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lrg);
        markData.setPostId(this.lkO.bfU());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lrl);
        markData.setSequence(Boolean.valueOf(djM()));
        markData.setId(this.lrg);
        return markData;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lrg);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.lrl);
        markData.setSequence(Boolean.valueOf(djM()));
        markData.setId(this.lrg);
        markData.setFloor(postData.dHx());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) postData).isApp());
        }
        return markData;
    }

    public void djq() {
        j.dhB().aU(djr(), this.isFromMark);
    }

    private String djr() {
        String djs = (this.lrg == null || this.lrg.equals("0")) ? djs() : this.lrg;
        if (this.lrl) {
            djs = djs + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            djs = djs + DB_KEY_REVER;
        } else if (this.mSortType == 2) {
            djs = djs + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return djs + TbadkCoreApplication.getCurrentAccount();
        }
        return djs;
    }

    private String djs() {
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

    public void uo(boolean z) {
        if (this.lkO != null) {
            this.lkO.ih(z);
        }
    }

    public boolean djt() {
        return this.lrL;
    }

    public void a(a aVar) {
        this.lrG = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bxA() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bxz() {
        return dji();
    }

    public boolean Pp(String str) {
        if (getPbData() == null || getPbData().dfI() == null || getPbData().dfI().bka() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().dfI().bka().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int dju() {
        return this.mRequestType;
    }

    public void djv() {
        if ("personalize_page".equals(this.mStType)) {
            this.lrR = System.currentTimeMillis() / 1000;
        }
    }

    public void djw() {
        if ("personalize_page".equals(this.mStType) && this.lkO != null && this.lrR != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10754").dR("fid", this.lkO.getForumId()).dR("tid", this.lrg).dR("obj_duration", String.valueOf(currentTimeMillis - this.lrR)).dR(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.lrR = 0L;
        }
    }

    public boolean djx() {
        return this.lrU;
    }

    public int getErrorNo() {
        return this.lrW;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public q djy() {
        return this.lrY;
    }

    public ai djz() {
        return this.lrZ;
    }

    public CheckRealNameModel djA() {
        return this.lsb;
    }

    public AddExperiencedModel djB() {
        return this.lsc;
    }

    public String djC() {
        return this.lrQ;
    }

    public void Pq(String str) {
        this.lrQ = str;
    }

    public boolean djD() {
        return this.lrV;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.lkO != null && this.lkO.dfK() != null && this.lkO.dfK().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lkO.dfK().size();
                for (int i = 0; i < size; i++) {
                    if (this.lkO.dfK().get(i) != null && this.lkO.dfK().get(i).bka() != null && currentAccount.equals(this.lkO.dfK().get(i).bka().getUserId()) && this.lkO.dfK().get(i).bka().getPendantData() != null) {
                        this.lkO.dfK().get(i).bka().getPendantData().AJ(mVar.bhW());
                        this.lkO.dfK().get(i).bka().getPendantData().dj(mVar.bwx());
                    }
                }
            }
        }
    }

    public String djE() {
        return this.lsa;
    }

    public int djF() {
        return this.lsg;
    }

    public void FP(int i) {
        this.lsg = i;
    }

    public void Pr(String str) {
        if ((!this.lrl || Pp(TbadkCoreApplication.getCurrentAccount())) && this.lkO.dfK() != null) {
            this.lkO.getPage().nS(1);
            if (this.lkO.getPage().biQ() == 0) {
                this.lkO.getPage().nS(1);
            }
            this.lsh = str;
            FK(8);
        }
    }

    private void FQ(int i) {
        if (i != 8) {
            this.lsh = "";
            if (this.lsi != null) {
                if (i == 1 && this.lkO != null && this.lkO.dgl()) {
                    if (this.lsj != null) {
                        getPbData().dfK().remove(this.lsj);
                    }
                } else if (i == 1 && !this.lrn && !com.baidu.tbadk.core.util.y.isEmpty(getPbData().dfK())) {
                    getPbData().dfK().remove(this.lsi);
                    if (this.lsj != null) {
                        getPbData().dfK().remove(this.lsj);
                    }
                    getPbData().dfK().add(0, this.lsi);
                } else {
                    getPbData().dfK().remove(this.lsi);
                    if (this.lsj != null) {
                        getPbData().dfK().remove(this.lsj);
                    }
                }
            }
            this.lsj = null;
        }
    }

    public void djG() {
        if (this.lkO != null && !com.baidu.tbadk.core.util.y.isEmpty(this.lkO.dfK())) {
            if (this.lsj != null) {
                this.lkO.dfK().remove(this.lsj);
                this.lsj = null;
            }
            if (this.lsi != null) {
                this.lkO.dfK().remove(this.lsi);
                this.lsi = null;
            }
        }
    }

    public void cZ(int i, int i2) {
        this.lsk = i;
        this.lsl = i2;
    }

    public PostData djH() {
        return this.lsi;
    }

    public PostData djI() {
        return this.lsj;
    }

    public int djJ() {
        return this.lsk;
    }

    public int djK() {
        return this.lsl;
    }

    public String djL() {
        return this.lsn;
    }

    public void Ps(String str) {
        this.lsn = str;
    }

    private boolean djM() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean djN() {
        return this.lsg == 13 || this.lsg == 12 || this.lsg == 7;
    }

    public String djO() {
        return this.lsq;
    }

    public String djP() {
        return this.lsr;
    }

    public String djQ() {
        return this.lss;
    }

    public String djR() {
        return this.lst;
    }

    public Rect djS() {
        Rect rect = this.lsm;
        this.lsm = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    private int djT() {
        int i;
        int i2 = 0;
        if (getPbData().dfK() == null) {
            return 0;
        }
        ArrayList<PostData> dfK = getPbData().dfK();
        int size = dfK.size() - 1;
        while (size >= 0) {
            PostData postData = dfK.get(size);
            if (postData instanceof com.baidu.tieba.tbadkCore.data.n) {
                if (postData.getType() != AdvertAppInfo.esI) {
                    return i2;
                }
                i = i2;
            } else {
                i = i2 + 1;
            }
            size--;
            i2 = i;
        }
        return dfK.size();
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }
}
