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
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bj;
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
/* loaded from: classes7.dex */
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
    private boolean cQn;
    private com.baidu.tieba.tbadkCore.d.b fTW;
    private long gEn;
    private BaseFragmentActivity gpB;
    private boolean hOp;
    protected com.baidu.tieba.pb.data.f iDs;
    private String iIA;
    private boolean iIB;
    private boolean iIC;
    private boolean iID;
    private boolean iIE;
    private int iIF;
    private boolean iIG;
    private int iIH;
    private long iII;
    private int iIJ;
    private int iIK;
    private int iIL;
    private int iIM;
    private boolean iIN;
    private boolean iIO;
    private boolean iIP;
    private long iIQ;
    private boolean iIR;
    private String iIS;
    private int iIT;
    private boolean iIU;
    private boolean iIV;
    private boolean iIW;
    private boolean iIX;
    private a iIY;
    private String iIZ;
    protected String iIx;
    private String iIy;
    private String iIz;
    private String iJA;
    private PostData iJB;
    private PostData iJC;
    private int iJD;
    private int iJE;
    private Rect iJF;
    private String iJG;
    private com.baidu.tieba.tbadkCore.data.m iJH;
    private boolean iJI;
    private String iJJ;
    private String iJK;
    private String iJL;
    private String iJM;
    private CustomMessageListener iJN;
    private com.baidu.adp.framework.listener.a iJO;
    private PraiseData iJP;
    private String iJa;
    private int iJb;
    private int iJc;
    private boolean iJd;
    private boolean iJe;
    private boolean iJf;
    private boolean iJg;
    private boolean iJh;
    private String iJi;
    private long iJj;
    private boolean iJk;
    private int iJl;
    private boolean iJm;
    private boolean iJn;
    private int iJo;
    private final y iJp;
    private final j iJq;
    private final o iJr;
    private final aa iJs;
    private String iJt;
    private final CheckRealNameModel iJu;
    private final AddExperiencedModel iJv;
    private SuggestEmotionModel iJw;
    private GetSugMatchWordsModel iJx;
    private boolean iJy;
    private int iJz;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private com.baidu.tieba.pb.data.e mAppealInfo;
    protected Context mContext;
    private String mForumId;
    private String mFromForumId;
    private int mIsGood;
    private boolean mIsShareThread;
    private CustomMessageListener mLikeForumListener;
    private String mLocate;
    private int mRequestType;
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
    private static final int iIw = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.f fVar);
    }

    public PbModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.mStType = null;
        this.iIx = null;
        this.iIy = null;
        this.iIz = null;
        this.mForumId = null;
        this.iIA = null;
        this.iIB = false;
        this.iIC = false;
        this.iID = true;
        this.iIE = true;
        this.mSortType = 0;
        this.iIF = 0;
        this.iIG = false;
        this.mIsGood = 0;
        this.iIH = 0;
        this.iII = 0L;
        this.iIJ = 1;
        this.iIK = 1;
        this.iIL = 1;
        this.iIM = 1;
        this.isAd = false;
        this.hOp = false;
        this.cQn = false;
        this.iIN = false;
        this.isFromMark = false;
        this.iIO = false;
        this.iIP = false;
        this.iIQ = 0L;
        this.iIR = false;
        this.iIS = null;
        this.iDs = null;
        this.isLoading = false;
        this.iIU = false;
        this.iIV = false;
        this.iIW = false;
        this.iIX = false;
        this.mLocate = null;
        this.mContext = null;
        this.iIY = null;
        this.opType = null;
        this.opUrl = null;
        this.iIZ = null;
        this.iJa = null;
        this.iJb = -1;
        this.iJc = -1;
        this.fTW = null;
        this.iJe = false;
        this.iJf = false;
        this.postID = null;
        this.iJi = null;
        this.iJj = 0L;
        this.iJk = false;
        this.iJl = -1;
        this.iJn = false;
        this.iJy = false;
        this.iJz = 0;
        this.mTabIndex = 0;
        this.iJI = false;
        this.iJN = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
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
        this.iJO = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.gpB.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.iJe || !PbModel.this.iJf) {
                        if (!PbModel.this.iJe) {
                            PbModel.this.iJe = true;
                        } else {
                            PbModel.this.iJf = true;
                        }
                        if (PbModel.this.iIY != null) {
                            PbModel.this.iIY.a(PbModel.this.clX(), z, responsedMessage, PbModel.this.iJg, System.currentTimeMillis() - PbModel.this.gEn);
                        }
                    }
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    String valueOf = String.valueOf(customResponsedMessage.getData());
                    if (PbModel.this.iDs != null && PbModel.this.iDs.ciR() != null && PbModel.this.iDs.ciR().getForumId() != null && PbModel.this.iDs.ciR().getForumId().equals(valueOf)) {
                        PbModel.this.iDs.ciR().setIsLike(false);
                    }
                }
            }
        };
        this.mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    String valueOf = String.valueOf(customResponsedMessage.getData());
                    if (PbModel.this.iDs != null && PbModel.this.iDs.ciR() != null && PbModel.this.iDs.ciR().getForumId() != null && PbModel.this.iDs.ciR().getForumId().equals(valueOf)) {
                        PbModel.this.iDs.ciR().setIsLike(true);
                    }
                }
            }
        };
        this.iJP = null;
        registerListener(this.iJO);
        registerListener(this.iJN);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.iDs = new com.baidu.tieba.pb.data.f();
        this.iDs.yt(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.gpB = baseFragmentActivity;
        this.iJp = new y(this, this.gpB);
        this.iJq = new j(this, this.gpB);
        this.iJr = new o(this, this.gpB);
        this.iJs = new aa(this, this.gpB);
        this.iJu = new CheckRealNameModel(this.gpB.getPageContext());
        this.iJw = new SuggestEmotionModel();
        this.iJv = new AddExperiencedModel(this.gpB.getPageContext());
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.iJh = true;
        if (fVar != null && fVar.izL == null) {
            n(fVar);
            j(fVar);
            if (fVar.ciS() != null) {
                fVar.ciS().jq(0);
            }
            if (this.iIY != null && fVar != null) {
                this.iIY.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int clX() {
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
            this.iIx = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.m(data)) {
                com.baidu.tbadk.BdToken.f.avz().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.5
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void n(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.cEk) instanceof String)) {
                            PbModel.this.iIx = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cEk);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.iIx)) {
                this.iIx = this.iJp.av(intent);
                if (StringUtils.isNull(this.iIx) && intent.getData() != null) {
                    this.iIx = data.getQueryParameter("thread_id");
                }
            }
            if (com.baidu.tbadk.core.util.aq.isEmpty(this.iIx)) {
                this.iIx = "0";
            }
            this.iJz = intent.getIntExtra("key_start_from", 0);
            if (this.iJz == 0) {
                this.iJz = this.iJp.WJ;
            }
            this.iIz = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.iIy = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.iIB = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.iIC = intent.getBooleanExtra("host_only", false);
            this.iIE = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.aPt().aGI() ? 2 : 0);
            if (this.mSortType == 2) {
                this.iIz = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.iIH = intent.getIntExtra("is_top", 0);
            this.iII = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.iIO = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.iIP = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.hOp = intent.getBooleanExtra("is_sub_pb", false);
            this.iIR = intent.getBooleanExtra("is_pv", false);
            this.iIQ = intent.getLongExtra("msg_id", 0L);
            this.iIS = intent.getStringExtra("from_forum_name");
            this.iJa = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.iIZ = intent.getStringExtra("op_stat");
            this.iIU = intent.getBooleanExtra("is_from_thread_config", false);
            this.iIV = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.iIW = intent.getBooleanExtra("is_from_my_god_config", false);
            this.iJc = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.iJb = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.cQn = intent.getBooleanExtra("from_frs", false);
            this.iIN = intent.getBooleanExtra("from_maintab", false);
            this.iJn = intent.getBooleanExtra("from_smart_frs", false);
            this.iIX = intent.getBooleanExtra("from_hottopic", false);
            this.iJt = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.iIA = intent.getStringExtra("high_light_post_id");
            this.iJI = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.iJd = intent.getIntExtra("request_code", -1) == 18003;
            this.iJJ = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.iJK = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.iJL = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.iJM = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean clY() {
        return this.iJI && com.baidu.tieba.frs.i.bBZ() != null && com.baidu.tieba.frs.i.bBZ().equals(this.iIx) && com.baidu.tieba.frs.i.bBY() != null;
    }

    public com.baidu.tieba.pb.data.f aD(bj bjVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.yt(3);
        if (bjVar == null) {
            return null;
        }
        fVar.aA(bjVar);
        if (bjVar.aBJ() != null) {
            fVar.e(bjVar.aBJ());
            ForumData forum = fVar.getForum();
            forum.setId(bjVar.aBJ().getForumId());
            forum.setName(bjVar.aBJ().getForumName());
            forum.setUser_level(bjVar.aBJ().azn());
            forum.setImage_url(bjVar.aBJ().getAvatar());
            forum.setPost_num(bjVar.aBJ().postNum);
            forum.setMember_num(bjVar.aBJ().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(bjVar.getFid()));
            forum2.setName(bjVar.aAc());
        }
        PostData postData = new PostData();
        postData.Cq(1);
        postData.setTime(bjVar.getCreateTime());
        postData.a(bjVar.azX());
        MetaData azX = bjVar.azX();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(azX.getUserId(), azX);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bjVar.azN(), false));
        fVar.d(postData);
        fVar.ciU().add(postData);
        com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
        lVar.Np = bjVar;
        fVar.a(lVar);
        fVar.izQ = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.iJz = bundle.getInt("key_start_from", 0);
        this.iIx = bundle.getString("thread_id");
        this.iIz = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.iIy = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.iIB = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.iIC = bundle.getBoolean("host_only", false);
        this.iIE = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.iIH = bundle.getInt("is_top", 0);
        this.iII = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.iIP = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.hOp = bundle.getBoolean("is_sub_pb", false);
        this.iIR = bundle.getBoolean("is_pv", false);
        this.iIQ = bundle.getLong("msg_id", 0L);
        this.iIS = bundle.getString("from_forum_name");
        this.iJa = bundle.getString("extra_pb_cache_key");
        this.iIU = bundle.getBoolean("is_from_thread_config", false);
        this.iIV = bundle.getBoolean("is_from_interview_live_config", false);
        this.iIW = bundle.getBoolean("is_from_my_god_config", false);
        this.iJc = bundle.getInt("extra_pb_is_attention_key", -1);
        this.iJb = bundle.getInt("extra_pb_funs_count_key", -1);
        this.cQn = bundle.getBoolean("from_frs", false);
        this.iIN = bundle.getBoolean("from_maintab", false);
        this.iJn = bundle.getBoolean("from_smart_frs", false);
        this.iIX = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.iIA = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.iJd = bundle.getInt("request_code", -1) == 18003;
        this.iJJ = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.iJK = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.iJL = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.iJM = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void au(Bundle bundle) {
        bundle.putString("thread_id", this.iIx);
        bundle.putString("post_id", this.iIz);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.iJz);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.iIB);
        bundle.putBoolean("host_only", this.iIC);
        bundle.putBoolean("squence", this.iIE);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.iIH);
        bundle.putLong("thread_time", this.iII);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.iIP);
        bundle.putBoolean("is_sub_pb", this.hOp);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.iIR);
        bundle.putLong("msg_id", this.iIQ);
        bundle.putString("extra_pb_cache_key", this.iJa);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.iIU);
        bundle.putBoolean("is_from_interview_live_config", this.iIV);
        bundle.putBoolean("is_from_my_god_config", this.iIW);
        bundle.putInt("extra_pb_is_attention_key", this.iJc);
        bundle.putInt("extra_pb_funs_count_key", this.iJb);
        bundle.putBoolean("from_frs", this.cQn);
        bundle.putBoolean("from_maintab", this.iIN);
        bundle.putBoolean("from_smart_frs", this.iJn);
        bundle.putBoolean("from_hottopic", this.iIX);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.iIA);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.iJJ);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.iJK);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.iJL);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.iJM);
    }

    public String clZ() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.iIx);
        if (!this.iIP) {
            sb.append(this.iIz);
        }
        sb.append(this.iIC);
        sb.append(this.iIE);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.iIH);
        sb.append(this.iII);
        sb.append(this.cQn);
        sb.append(this.iIN);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.hOp);
        sb.append(this.iIR);
        sb.append(this.iIQ);
        sb.append(this.iIS);
        sb.append(this.mThreadType);
        sb.append(this.iIU);
        sb.append(this.iIV);
        sb.append(this.iIW);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.iJa != null) {
            sb.append(this.iJa);
        }
        return sb.toString();
    }

    public String cjS() {
        return this.iIS;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String cma() {
        return this.iIz;
    }

    public String cmb() {
        return this.iIA;
    }

    public String cmc() {
        return this.iIx;
    }

    public boolean getHostMode() {
        return this.iIC;
    }

    public boolean cmd() {
        return cmV();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean cme() {
        return this.cQn;
    }

    public boolean cmf() {
        return this.iIG;
    }

    public boolean cmg() {
        return this.iIN;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean cmh() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bwl() {
        return this.iIH;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void yK(int i) {
        this.iIH = i;
    }

    public boolean cmi() {
        return this.hOp;
    }

    public boolean cmj() {
        if (this.iDs == null) {
            return false;
        }
        return this.iDs.isValid();
    }

    public String aAg() {
        if (this.iDs == null || !this.iDs.aww()) {
            return null;
        }
        return this.iDs.awv();
    }

    public boolean yL(int i) {
        this.iIJ = i;
        if (this.iIJ > this.iDs.getPage().ayM()) {
            this.iIJ = this.iDs.getPage().ayM();
        }
        if (this.iIJ < 1) {
            this.iIJ = 1;
        }
        if (this.iIx == null) {
            return false;
        }
        return yN(5);
    }

    public void yM(int i) {
        this.iIJ = i;
        this.iIK = i;
        this.iIL = i;
    }

    public void b(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar == null) {
            yM(1);
            return;
        }
        if (this.iIK < apVar.ayP()) {
            this.iIK = apVar.ayP();
        }
        if (this.iIL > apVar.ayP()) {
            this.iIL = apVar.ayP();
        }
        this.iIM = apVar.ayM();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.iDs;
    }

    public BaijiahaoData cmk() {
        if (this.iDs == null || this.iDs.ciS() == null) {
            return null;
        }
        return this.iDs.ciS().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f cml() {
        if (this.iDs == null) {
            return this.iDs;
        }
        if (!cmm() && this.iJH != null) {
            this.iDs.b(this.iJH);
        }
        return this.iDs;
    }

    private boolean cmm() {
        return (this.iDs.cjh() == null || this.iDs.cjh().cJn() == null || this.iDs.cjh().cJn().goods != null || this.iDs.cjh().cJn().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.ap getPageData() {
        if (this.iDs == null) {
            return null;
        }
        return this.iDs.getPage();
    }

    public boolean cmn() {
        if (cmV() && this.iDs.getPage().ayR() == 0) {
            pS(true);
            return true;
        }
        return false;
    }

    public void h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.iIx = fVar.getThreadId();
            if (fVar.ciS() != null && fVar.ciS().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.ciS().getBaijiahaoData();
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
            this.iIz = null;
            this.iIC = false;
            this.iIE = true;
            LoadData();
        }
    }

    public void Fz(String str) {
        if (!StringUtils.isNull(str)) {
            this.iIx = str;
            this.iIz = null;
            this.iIC = false;
            this.iIE = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.iIx == null) {
            return false;
        }
        cancelLoadData();
        if (this.fTW == null) {
            this.fTW = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.fTW.start();
        }
        boolean yN = yN(3);
        if (this.opType != null) {
            this.opType = null;
            this.iIZ = null;
            this.opUrl = null;
            return yN;
        }
        return yN;
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
        if (this.iJw != null) {
            this.iJw.cancelLoadData();
        }
        if (this.iJx != null) {
            this.iJx.cancelLoadData();
        }
        bxm();
    }

    private void bxm() {
        if (this.fTW != null) {
            this.fTW.destory();
            this.fTW = null;
        }
    }

    public boolean cmo() {
        return (this.iIz == null || this.iIz.equals("0") || this.iIz.length() == 0) ? LoadData() : cmt();
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
                this.iJw.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.iJw.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.iJx == null) {
                this.iJx = new GetSugMatchWordsModel(this.gpB.getPageContext());
            }
            this.iJx.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x033e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0346 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x016d, B:51:0x0175, B:53:0x0182, B:54:0x018a, B:56:0x018e, B:57:0x0193, B:59:0x0197, B:60:0x019c, B:62:0x01a0, B:63:0x01b0, B:65:0x01b4, B:66:0x01bc, B:68:0x01c0, B:69:0x01d9, B:70:0x01e8, B:71:0x01eb, B:74:0x0217, B:76:0x025e, B:77:0x027c, B:79:0x0294, B:81:0x029a, B:83:0x02a1, B:84:0x02ae, B:86:0x02c2, B:88:0x02c8, B:90:0x02ce, B:99:0x02fe, B:101:0x0304, B:91:0x02d9, B:93:0x02dd, B:95:0x02e5, B:97:0x02f4, B:98:0x02f9, B:102:0x0310, B:104:0x0324, B:106:0x0328, B:109:0x033a, B:112:0x0340, B:140:0x03b6, B:115:0x0346, B:117:0x034c, B:118:0x0351, B:120:0x0355, B:122:0x035f, B:127:0x0376, B:129:0x0384, B:130:0x0387, B:132:0x038b, B:133:0x0396, B:135:0x039a, B:137:0x03a2, B:139:0x03b1, B:141:0x03bb, B:143:0x03bf, B:124:0x0363, B:144:0x03c8, B:145:0x03f6, B:147:0x03fa, B:157:0x042b, B:150:0x0406, B:152:0x0414, B:153:0x041c, B:155:0x0420, B:156:0x0426, B:158:0x0434, B:160:0x0440, B:149:0x03fe, B:161:0x044a, B:163:0x0456, B:165:0x045a, B:167:0x045e, B:168:0x0463, B:170:0x046f, B:171:0x0477, B:175:0x0491, B:172:0x047c, B:174:0x048b, B:176:0x049a, B:178:0x04a9, B:38:0x00e3), top: B:181:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0355 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x016d, B:51:0x0175, B:53:0x0182, B:54:0x018a, B:56:0x018e, B:57:0x0193, B:59:0x0197, B:60:0x019c, B:62:0x01a0, B:63:0x01b0, B:65:0x01b4, B:66:0x01bc, B:68:0x01c0, B:69:0x01d9, B:70:0x01e8, B:71:0x01eb, B:74:0x0217, B:76:0x025e, B:77:0x027c, B:79:0x0294, B:81:0x029a, B:83:0x02a1, B:84:0x02ae, B:86:0x02c2, B:88:0x02c8, B:90:0x02ce, B:99:0x02fe, B:101:0x0304, B:91:0x02d9, B:93:0x02dd, B:95:0x02e5, B:97:0x02f4, B:98:0x02f9, B:102:0x0310, B:104:0x0324, B:106:0x0328, B:109:0x033a, B:112:0x0340, B:140:0x03b6, B:115:0x0346, B:117:0x034c, B:118:0x0351, B:120:0x0355, B:122:0x035f, B:127:0x0376, B:129:0x0384, B:130:0x0387, B:132:0x038b, B:133:0x0396, B:135:0x039a, B:137:0x03a2, B:139:0x03b1, B:141:0x03bb, B:143:0x03bf, B:124:0x0363, B:144:0x03c8, B:145:0x03f6, B:147:0x03fa, B:157:0x042b, B:150:0x0406, B:152:0x0414, B:153:0x041c, B:155:0x0420, B:156:0x0426, B:158:0x0434, B:160:0x0440, B:149:0x03fe, B:161:0x044a, B:163:0x0456, B:165:0x045a, B:167:0x045e, B:168:0x0463, B:170:0x046f, B:171:0x0477, B:175:0x0491, B:172:0x047c, B:174:0x048b, B:176:0x049a, B:178:0x04a9, B:38:0x00e3), top: B:181:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x038b A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x016d, B:51:0x0175, B:53:0x0182, B:54:0x018a, B:56:0x018e, B:57:0x0193, B:59:0x0197, B:60:0x019c, B:62:0x01a0, B:63:0x01b0, B:65:0x01b4, B:66:0x01bc, B:68:0x01c0, B:69:0x01d9, B:70:0x01e8, B:71:0x01eb, B:74:0x0217, B:76:0x025e, B:77:0x027c, B:79:0x0294, B:81:0x029a, B:83:0x02a1, B:84:0x02ae, B:86:0x02c2, B:88:0x02c8, B:90:0x02ce, B:99:0x02fe, B:101:0x0304, B:91:0x02d9, B:93:0x02dd, B:95:0x02e5, B:97:0x02f4, B:98:0x02f9, B:102:0x0310, B:104:0x0324, B:106:0x0328, B:109:0x033a, B:112:0x0340, B:140:0x03b6, B:115:0x0346, B:117:0x034c, B:118:0x0351, B:120:0x0355, B:122:0x035f, B:127:0x0376, B:129:0x0384, B:130:0x0387, B:132:0x038b, B:133:0x0396, B:135:0x039a, B:137:0x03a2, B:139:0x03b1, B:141:0x03bb, B:143:0x03bf, B:124:0x0363, B:144:0x03c8, B:145:0x03f6, B:147:0x03fa, B:157:0x042b, B:150:0x0406, B:152:0x0414, B:153:0x041c, B:155:0x0420, B:156:0x0426, B:158:0x0434, B:160:0x0440, B:149:0x03fe, B:161:0x044a, B:163:0x0456, B:165:0x045a, B:167:0x045e, B:168:0x0463, B:170:0x046f, B:171:0x0477, B:175:0x0491, B:172:0x047c, B:174:0x048b, B:176:0x049a, B:178:0x04a9, B:38:0x00e3), top: B:181:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x039a A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x016d, B:51:0x0175, B:53:0x0182, B:54:0x018a, B:56:0x018e, B:57:0x0193, B:59:0x0197, B:60:0x019c, B:62:0x01a0, B:63:0x01b0, B:65:0x01b4, B:66:0x01bc, B:68:0x01c0, B:69:0x01d9, B:70:0x01e8, B:71:0x01eb, B:74:0x0217, B:76:0x025e, B:77:0x027c, B:79:0x0294, B:81:0x029a, B:83:0x02a1, B:84:0x02ae, B:86:0x02c2, B:88:0x02c8, B:90:0x02ce, B:99:0x02fe, B:101:0x0304, B:91:0x02d9, B:93:0x02dd, B:95:0x02e5, B:97:0x02f4, B:98:0x02f9, B:102:0x0310, B:104:0x0324, B:106:0x0328, B:109:0x033a, B:112:0x0340, B:140:0x03b6, B:115:0x0346, B:117:0x034c, B:118:0x0351, B:120:0x0355, B:122:0x035f, B:127:0x0376, B:129:0x0384, B:130:0x0387, B:132:0x038b, B:133:0x0396, B:135:0x039a, B:137:0x03a2, B:139:0x03b1, B:141:0x03bb, B:143:0x03bf, B:124:0x0363, B:144:0x03c8, B:145:0x03f6, B:147:0x03fa, B:157:0x042b, B:150:0x0406, B:152:0x0414, B:153:0x041c, B:155:0x0420, B:156:0x0426, B:158:0x0434, B:160:0x0440, B:149:0x03fe, B:161:0x044a, B:163:0x0456, B:165:0x045a, B:167:0x045e, B:168:0x0463, B:170:0x046f, B:171:0x0477, B:175:0x0491, B:172:0x047c, B:174:0x048b, B:176:0x049a, B:178:0x04a9, B:38:0x00e3), top: B:181:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03bf A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:34:0x00d7, B:36:0x00db, B:45:0x00ff, B:48:0x0162, B:50:0x016d, B:51:0x0175, B:53:0x0182, B:54:0x018a, B:56:0x018e, B:57:0x0193, B:59:0x0197, B:60:0x019c, B:62:0x01a0, B:63:0x01b0, B:65:0x01b4, B:66:0x01bc, B:68:0x01c0, B:69:0x01d9, B:70:0x01e8, B:71:0x01eb, B:74:0x0217, B:76:0x025e, B:77:0x027c, B:79:0x0294, B:81:0x029a, B:83:0x02a1, B:84:0x02ae, B:86:0x02c2, B:88:0x02c8, B:90:0x02ce, B:99:0x02fe, B:101:0x0304, B:91:0x02d9, B:93:0x02dd, B:95:0x02e5, B:97:0x02f4, B:98:0x02f9, B:102:0x0310, B:104:0x0324, B:106:0x0328, B:109:0x033a, B:112:0x0340, B:140:0x03b6, B:115:0x0346, B:117:0x034c, B:118:0x0351, B:120:0x0355, B:122:0x035f, B:127:0x0376, B:129:0x0384, B:130:0x0387, B:132:0x038b, B:133:0x0396, B:135:0x039a, B:137:0x03a2, B:139:0x03b1, B:141:0x03bb, B:143:0x03bf, B:124:0x0363, B:144:0x03c8, B:145:0x03f6, B:147:0x03fa, B:157:0x042b, B:150:0x0406, B:152:0x0414, B:153:0x041c, B:155:0x0420, B:156:0x0426, B:158:0x0434, B:160:0x0440, B:149:0x03fe, B:161:0x044a, B:163:0x0456, B:165:0x045a, B:167:0x045e, B:168:0x0463, B:170:0x046f, B:171:0x0477, B:175:0x0491, B:172:0x047c, B:174:0x048b, B:176:0x049a, B:178:0x04a9, B:38:0x00e3), top: B:181:0x00d7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean yN(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        yO(i);
        final com.baidu.tieba.pb.data.f pbData = ak.cnx().getPbData();
        if (pbData != null && pbData.ciS() != null) {
            pbData.ciS().jq(0);
            this.iIE = ak.cnx().cmd();
            this.iIC = ak.cnx().cnC();
            this.iIG = ak.cnx().cnD();
            this.iJB = ak.cnx().cnB();
            this.iJC = ak.cnx().cnA();
            this.iJD = ak.cnx().cnz();
            this.iJF = ak.cnx().cnE();
            this.mTabIndex = ak.cnx().getTabIndex();
            this.iJy = this.iIC;
            if (this.iIC || this.isFromMark) {
                this.iJd = false;
            }
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.iJh) {
            a(cmy(), true, this.iIz, 3);
        }
        if (i == 3 && !this.iJh) {
            if (this.isFromMark) {
                a(cmy(), true, this.iIz, 3);
            } else {
                a(cmy(), false, this.iIz, 3);
            }
        }
        this.iJh = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.iJH == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.drF);
        if (this.iIC || this.isFromMark) {
            this.iJd = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.iIx == null || this.iIx.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.iIx, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.ar.aEq().aEr() ? 2 : 1));
        if (!this.iIE) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.iIC) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.iIR) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.iIQ));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.iJd) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.iIZ, 0));
            pbPageRequestMessage.setOpMessageID(this.iIQ);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> ciU = this.iDs.ciU();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iIL - 1));
                        if (this.iIL - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.iIO) {
                                if (ciU != null && ciU.size() > 0) {
                                    size = ciU.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = ciU.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.iIz = postData.getId();
                                            if (StringUtils.isNull(this.iIz)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.iIK + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.iIz == null && this.iIz.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iIz, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iIK + 1));
                        if (this.iIK >= this.iIM) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (ciU != null) {
                                size = ciU.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.iIz == null) {
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
                if (ciU != null) {
                }
                if (this.iIz == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (ciU != null && ciU.size() > 0 && ciU.get(0) != null) {
                    this.iIz = ciU.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (cmV()) {
                        if (this.iIL - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.iIL - 1));
                        }
                    } else if (this.iIK < this.iIM) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iIK + 1));
                    }
                }
                if (this.iIz != null && this.iIz.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iIz, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.iIC) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (cmV()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.iIM > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iIM));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iIz, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.iIJ));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.iJy && !this.iIC) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iIz, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.iIC) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.iJl);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iJA, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.iJy = this.iIC;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(cmy());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.iJz));
        pbPageRequestMessage.setIsSubPostDataReverse(this.iJk);
        pbPageRequestMessage.setFromSmartFrs(this.iJn ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.iIB);
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.iIx);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean cjR() {
        switch (cmO()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().ciS() == null || !getPbData().ciS().aBr();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cjS()) && com.baidu.tieba.recapp.r.cAX().cAR() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cAX().cAR().ax(cjS(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cAX().cAR().ay(cjS(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(cjS()) && com.baidu.tieba.recapp.r.cAX().cAR() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.cAX().cAR().ay(cjS(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.cAX().cAR().ax(cjS(), true));
        }
    }

    protected void yO(int i) {
        boolean z = false;
        yT(i);
        ArrayList<PostData> ciU = this.iDs.ciU();
        this.iJg = false;
        if (i == 1) {
            boolean z2 = false;
            while (ciU.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                ciU.remove(0);
                z2 = true;
            }
            if (z2) {
                this.iDs.getPage().jn(1);
                if (this.iIY != null) {
                    this.iIY.e(this.iDs);
                }
            }
            this.gEn = System.currentTimeMillis();
            this.iJg = true;
        } else if (i == 2) {
            while (ciU.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                ciU.remove(ciU.size() - 1);
                z = true;
            }
            if (z) {
                this.iDs.getPage().jm(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.iJo = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            j(fVar2);
        }
        i(fVar2);
        if (this.iJH != null && this.iJH.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.r.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cjh() != null && fVar.cjh().cJn() != null && fVar.cjh().cJn().goods != null && fVar.cjh().isValidate() && fVar.cjh().cJn().goods.goods_style != 1001) {
            this.iJH = fVar.cjh();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m cmp() {
        return this.iJH;
    }

    public void cmq() {
        this.iJH = null;
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

    protected void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            if (this.iIW || this.iIU || this.iIV) {
                fVar = l(fVar);
            }
            k(fVar);
        }
    }

    protected void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String m = m(fVar);
            for (int i = 0; i < fVar.ciU().size(); i++) {
                PostData postData = fVar.ciU().get(i);
                for (int i2 = 0; i2 < postData.cJw().size(); i2++) {
                    postData.cJw().get(i2).a(this.gpB.getPageContext(), m.equals(postData.cJw().get(i2).azX().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.o cjd = fVar.cjd();
            if (cjd != null && !com.baidu.tbadk.core.util.v.isEmpty(cjd.iAX)) {
                for (PostData postData2 : cjd.iAX) {
                    for (int i3 = 0; i3 < postData2.cJw().size(); i3++) {
                        postData2.cJw().get(i3).a(this.gpB.getPageContext(), m.equals(postData2.cJw().get(i3).azX().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String m = m(fVar);
            com.baidu.tieba.pb.data.o cjd = fVar.cjd();
            if (cjd != null && !com.baidu.tbadk.core.util.v.isEmpty(cjd.iAX)) {
                for (PostData postData : cjd.iAX.subList(i, cjd.iAX.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cJw().size()) {
                            postData.cJw().get(i3).a(this.gpB.getPageContext(), m.equals(postData.cJw().get(i3).azX().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.f l(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null) {
            return null;
        }
        bj ciS = fVar.ciS();
        ciS.jv(this.mIsGood);
        ciS.ju(this.iIH);
        if (this.iII > 0) {
            ciS.br(this.iII);
            return fVar;
        }
        return fVar;
    }

    protected String m(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.ciS() != null && fVar.ciS().azX() != null) {
            str = fVar.ciS().azX().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData cmr() {
        if (this.iDs == null || this.iDs.ciS() == null || this.iDs.ciS().azX() == null) {
            return null;
        }
        return this.iDs.ciS().azX();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int size;
        int i4;
        int i5;
        boolean z4 = !z;
        this.iJm = z3;
        this.iIT = i;
        if (this.fTW != null && !z3) {
            this.fTW.a(z2, z4, i2, str, i3, j, j2);
            this.fTW = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(cjS()) && com.baidu.tieba.recapp.r.cAX().cAR() != null) {
            com.baidu.tieba.recapp.r.cAX().cAR().g(cjS(), yP(cmB()), true);
        }
        if (fVar == null || (this.iIJ == 1 && i == 5 && fVar.ciU() != null && fVar.ciU().size() < 1)) {
            if (this.iIY != null) {
                this.iIE = this.iID;
                if (i2 != 350006) {
                    this.mSortType = this.iIF;
                }
                this.iIY.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.iID = this.iIE;
            if (i != 8) {
                this.iIF = this.mSortType;
                this.mSortType = fVar.izK;
            }
            if (fVar.izJ != null && fVar.izJ.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.gpB.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.izJ = new ArrayList();
                fVar.izJ.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.gpB.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.izJ.add(builder2.build(false));
                this.mSortType = this.iIF;
                fVar.izK = this.mSortType;
            }
            this.iIR = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.iIM = this.iIM < 1 ? 1 : this.iIM;
            ArrayList<PostData> ciU = this.iDs.ciU();
            switch (i) {
                case 1:
                    this.iDs.a(fVar.getPage(), 1);
                    d(fVar, ciU);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.ciU() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.ciU().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(ciU, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(fVar.ciU(), com.baidu.tbadk.core.util.v.getCount(fVar.ciU()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.ciU().remove(postData2);
                            i5 = size2 - 1;
                        }
                        ciU.addAll(0, fVar.ciU());
                    }
                    this.iDs.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().jk(fVar.getPage().ayM());
                    }
                    n(fVar);
                    if (!z3 && this.mThreadType != 33 && cmV()) {
                        cms();
                        i4 = 0;
                        break;
                    }
                    i4 = 0;
                    break;
                case 4:
                    n(fVar);
                    i4 = 0;
                    break;
                case 5:
                    n(fVar);
                    i4 = 0;
                    break;
                case 6:
                    n(fVar);
                    i4 = 0;
                    break;
                case 7:
                    n(fVar);
                    i4 = 0;
                    break;
                case 8:
                    if (fVar != null && !com.baidu.tbadk.core.util.v.isEmpty(fVar.ciU()) && this.iDs != null && (!this.iIC || m(fVar).equals(fVar.ciU().get(0).azX().getUserId()))) {
                        if (this.iDs.getPage().ayR() == 0) {
                            this.iDs.getPage().jm(1);
                        }
                        cmP();
                        this.iJB = fVar.ciU().get(0);
                        if (cmV() || this.iDs.cjs()) {
                            if (this.iDs.ciU().size() - this.iJD >= 3) {
                                this.iJC = new PostData();
                                this.iJC.kfS = true;
                                this.iJC.setPostType(53);
                                this.iDs.ciU().add(this.iJC);
                            }
                            this.iDs.ciU().add(this.iJB);
                            size = this.iDs.ciU().size() - 1;
                        } else {
                            if (this.iJD - this.iJE >= 3) {
                                this.iJC = new PostData();
                                this.iJC.kfS = false;
                                this.iJC.setPostType(53);
                                this.iDs.ciU().add(0, this.iJC);
                            }
                            this.iDs.ciU().add(0, this.iJB);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.isTaday(com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.iJB.kgf = this.iDs.cjq();
                            com.baidu.tbadk.core.sharedPref.b.aDr().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        }
                        i4 = size;
                        break;
                    }
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.iDs != null && this.iDs.ciS() != null) {
                PraiseData azI = this.iDs.ciS().azI();
                if (this.iJP != null && !azI.isPriaseDataValid()) {
                    this.iDs.ciS().a(this.iJP);
                } else {
                    this.iJP = this.iDs.ciS().azI();
                    this.iJP.setPostId(this.iDs.ciS().aAn());
                }
                if (fVar.getPage() != null && fVar.getPage().ayP() == 1 && fVar.ciS() != null && fVar.ciS().aAi() != null && fVar.ciS().aAi().size() > 0) {
                    this.iDs.ciS().v(fVar.ciS().aAi());
                }
                this.iDs.ciS().js(fVar.ciS().azO());
                this.iDs.ciS().jo(fVar.ciS().getAnchorLevel());
                this.iDs.ciS().jq(fVar.ciS().azE());
                if (this.mThreadType == 33) {
                    this.iDs.ciS().azX().setHadConcerned(fVar.ciS().azX().hadConcerned());
                }
                if (fVar != null && fVar.ciS() != null) {
                    this.iDs.ciS().jx(fVar.ciS().aAm());
                }
            }
            if (this.iDs != null && this.iDs.getUserData() != null && fVar.getUserData() != null) {
                this.iDs.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.iDs.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().ayP() == 1 && fVar.cjc() != null) {
                this.iDs.e(fVar.cjc());
            }
            if (this.iJm) {
                if (this.iDs.ciS() != null && this.iDs.ciS().azX() != null && this.iDs.ciU() != null && com.baidu.tbadk.core.util.v.getItem(this.iDs.ciU(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(this.iDs.ciU(), 0);
                    MetaData azX = this.iDs.ciS().azX();
                    if (postData3.azX() != null && postData3.azX().getGodUserData() != null) {
                        if (this.iJb != -1) {
                            azX.setFansNum(this.iJb);
                            postData3.azX().setFansNum(this.iJb);
                        }
                        if (this.iJc != -1) {
                            azX.getGodUserData().setIsLike(this.iJc == 1);
                            postData3.azX().getGodUserData().setIsLike(this.iJc == 1);
                            azX.getGodUserData().setIsFromNetWork(false);
                            postData3.azX().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.iDs.izI = -1;
                this.iDs.izH = -1;
            }
            if (this.iIY != null) {
                this.iIY.a(true, getErrorCode(), i, i4, this.iDs, this.mErrorString, 1);
            }
        }
        if (this.iDs != null && this.iDs.ciS() != null && this.iDs.getForum() != null && !this.iDs.cjs()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.gpB.getPageContext();
            historyMessage.threadId = getPbData().ciS().getId();
            if (this.mIsShareThread && getPbData().ciS().cPN != null) {
                historyMessage.threadName = getPbData().ciS().cPN.showText;
            } else {
                historyMessage.threadName = getPbData().ciS().getTitle();
            }
            if (this.mIsShareThread && !cjR()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = cmd();
            historyMessage.threadType = getPbData().ciS().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aL;
        if (arrayList != null && fVar.ciU() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(fVar.ciU(), 0);
            if (postData != null && (aL = aL(arrayList)) != null && aL.equals(postData.getId())) {
                fVar.ciU().remove(postData);
            }
            arrayList.addAll(fVar.ciU());
        }
    }

    private int yP(int i) {
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

    private String aL(ArrayList<PostData> arrayList) {
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

    private void n(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            fVar.Fu(this.iDs.cjk());
            this.iDs = fVar;
            yM(fVar.getPage().ayP());
        }
    }

    private void cms() {
        if (this.iDs != null && this.iDs.ciU() != null && this.iDs.cjj() != null) {
            ArrayList<PostData> ciU = this.iDs.ciU();
            com.baidu.tieba.pb.data.a cjj = this.iDs.cjj();
            int ciN = cjj.ciN();
            if (ciN > 0) {
                if (ciN <= ciU.size()) {
                    ciU.add(ciN, cjj);
                } else {
                    ciU.add(cjj);
                }
            }
        }
    }

    public boolean cmt() {
        if (this.iIx == null || this.iIz == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return yN(4);
        }
        return yN(6);
    }

    public boolean pS(boolean z) {
        if (this.iIx == null || this.iDs == null) {
            return false;
        }
        if (z || this.iDs.getPage().ayR() != 0) {
            return yN(1);
        }
        return false;
    }

    public boolean pT(boolean z) {
        if (this.iIx == null || this.iDs == null) {
            return false;
        }
        if ((z || this.iDs.getPage().ayS() != 0) && this.iDs.ciU() != null && this.iDs.ciU().size() >= 1) {
            return yN(2);
        }
        return false;
    }

    public boolean FG(String str) {
        this.iIC = !this.iIC;
        this.iIz = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").Z("obj_source", 0));
        if (yN(6)) {
            return true;
        }
        this.iIC = this.iIC ? false : true;
        return false;
    }

    public boolean u(boolean z, String str) {
        if (this.iIC == z) {
            return false;
        }
        this.iIC = z;
        this.iIz = str;
        if (this.mSortType == 2) {
            this.iIz = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").Z("obj_source", 1));
        }
        if (yN(6)) {
            return true;
        }
        this.iIC = z ? false : true;
        return false;
    }

    public boolean yQ(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.iID = this.iIE;
        this.iIF = this.mSortType;
        this.mSortType = i;
        this.iIE = !this.iIE;
        if (i == 2 && this.isFromMark) {
            this.iIz = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.iIE = this.iIE ? false : true;
            this.mSortType = this.iIF;
            return false;
        }
        return true;
    }

    public boolean cmu() {
        return cmV();
    }

    public int cmv() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.iDs == null || this.iDs.getForum() == null || this.iDs.ciS() == null) ? false : true;
    }

    public boolean aww() {
        if (this.iDs == null) {
            return false;
        }
        return this.iDs.aww();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData uR(String str) {
        if (this.iDs == null || this.iDs.ciS() == null || this.iDs.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.iDs.ciS().aBr()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.iDs.getForum().getId());
            writeData.setForumName(this.iDs.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.iJz);
        writeData.setThreadId(this.iIx);
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

    public MarkData yR(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.iDs == null) {
            return null;
        }
        ArrayList<PostData> ciU = this.iDs.ciU();
        if (com.baidu.tbadk.core.util.v.isEmpty(ciU)) {
            return null;
        }
        if (ciU.size() > 0 && i >= ciU.size()) {
            i = ciU.size() - 1;
        }
        return l(ciU.get(i));
    }

    public MarkData cmw() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iIx);
        markData.setPostId(this.iDs.awv());
        markData.setTime(date.getTime());
        markData.setHostMode(this.iIC);
        markData.setSequence(Boolean.valueOf(cmV()));
        markData.setId(this.iIx);
        return markData;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iIx);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.iIC);
        markData.setSequence(Boolean.valueOf(cmV()));
        markData.setId(this.iIx);
        markData.setFloor(postData.cJz());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void cmx() {
        i.ckK().ar(cmy(), this.isFromMark);
    }

    private String cmy() {
        String cmz = (this.iIx == null || this.iIx.equals("0")) ? cmz() : this.iIx;
        if (this.iIC) {
            cmz = cmz + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            cmz = cmz + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return cmz + TbadkCoreApplication.getCurrentAccount();
        }
        return cmz;
    }

    private String cmz() {
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

    public void pU(boolean z) {
        if (this.iDs != null) {
            this.iDs.ff(z);
        }
    }

    public boolean cmA() {
        return this.iJd;
    }

    public void a(a aVar) {
        this.iIY = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aMq() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aMp() {
        return cmo();
    }

    public boolean FH(String str) {
        if (getPbData() == null || getPbData().ciS() == null || getPbData().ciS().azX() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().ciS().azX().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int cmB() {
        return this.mRequestType;
    }

    public void cmC() {
        String cmy = cmy();
        i.ckK().ar(cmy, false);
        i.ckK().ar(cmy, true);
    }

    public void cmD() {
        if ("personalize_page".equals(this.mStType)) {
            this.iJj = System.currentTimeMillis() / 1000;
        }
    }

    public void cmE() {
        if ("personalize_page".equals(this.mStType) && this.iDs != null && this.iJj != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").cp("fid", this.iDs.getForumId()).cp("tid", this.iIx).cp("obj_duration", String.valueOf(currentTimeMillis - this.iJj)).cp(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.iJj = 0L;
        }
    }

    public boolean cmF() {
        return this.iJm;
    }

    public int getErrorNo() {
        return this.iJo;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public j cmG() {
        return this.iJq;
    }

    public o cmH() {
        return this.iJr;
    }

    public aa cmI() {
        return this.iJs;
    }

    public CheckRealNameModel cmJ() {
        return this.iJu;
    }

    public AddExperiencedModel cmK() {
        return this.iJv;
    }

    public String cmL() {
        return this.iJi;
    }

    public void FI(String str) {
        this.iJi = str;
    }

    public boolean cmM() {
        return this.iJn;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.iDs != null && this.iDs.ciU() != null && this.iDs.ciU().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.iDs.ciU().size();
                for (int i = 0; i < size; i++) {
                    if (this.iDs.ciU().get(i) != null && this.iDs.ciU().get(i).azX() != null && currentAccount.equals(this.iDs.ciU().get(i).azX().getUserId()) && this.iDs.ciU().get(i).azX().getPendantData() != null) {
                        this.iDs.ciU().get(i).azX().getPendantData().sk(mVar.ayq());
                        this.iDs.ciU().get(i).azX().getPendantData().bE(mVar.aLA());
                    }
                }
            }
        }
    }

    public String cmN() {
        return this.iJt;
    }

    public int cmO() {
        return this.iJz;
    }

    public void yS(int i) {
        this.iJz = i;
    }

    public void FJ(String str) {
        if ((!this.iIC || FH(TbadkCoreApplication.getCurrentAccount())) && this.iDs.ciU() != null) {
            this.iDs.getPage().jm(1);
            if (this.iDs.getPage().ayR() == 0) {
                this.iDs.getPage().jm(1);
            }
            this.iJA = str;
            yN(8);
        }
    }

    private void yT(int i) {
        if (i != 8) {
            this.iJA = "";
            if (this.iJB != null) {
                if (i == 1 && this.iDs != null && this.iDs.cjs()) {
                    if (this.iJC != null) {
                        getPbData().ciU().remove(this.iJC);
                    }
                } else if (i == 1 && !this.iIE && !com.baidu.tbadk.core.util.v.isEmpty(getPbData().ciU())) {
                    getPbData().ciU().remove(this.iJB);
                    if (this.iJC != null) {
                        getPbData().ciU().remove(this.iJC);
                    }
                    getPbData().ciU().add(0, this.iJB);
                } else {
                    getPbData().ciU().remove(this.iJB);
                    if (this.iJC != null) {
                        getPbData().ciU().remove(this.iJC);
                    }
                }
            }
            this.iJC = null;
        }
    }

    public void cmP() {
        if (this.iDs != null && !com.baidu.tbadk.core.util.v.isEmpty(this.iDs.ciU())) {
            if (this.iJC != null) {
                this.iDs.ciU().remove(this.iJC);
                this.iJC = null;
            }
            if (this.iJB != null) {
                this.iDs.ciU().remove(this.iJB);
                this.iJB = null;
            }
        }
    }

    public void cq(int i, int i2) {
        this.iJD = i;
        this.iJE = i2;
    }

    public PostData cmQ() {
        return this.iJB;
    }

    public PostData cmR() {
        return this.iJC;
    }

    public int cmS() {
        return this.iJD;
    }

    public int cmT() {
        return this.iJE;
    }

    public String cmU() {
        return this.iJG;
    }

    public void FK(String str) {
        this.iJG = str;
    }

    private boolean cmV() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean cmW() {
        return this.iJz == 13 || this.iJz == 12;
    }

    public String cmX() {
        return this.iJJ;
    }

    public String cmY() {
        return this.iJK;
    }

    public String cmZ() {
        return this.iJL;
    }

    public String cna() {
        return this.iJM;
    }

    public Rect cnb() {
        Rect rect = this.iJF;
        this.iJF = null;
        return rect;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }
}
