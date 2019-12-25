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
/* loaded from: classes6.dex */
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
    private boolean cQd;
    private com.baidu.tieba.tbadkCore.d.b fQM;
    private long gBd;
    private BaseFragmentActivity gms;
    private boolean hKM;
    protected String iET;
    private String iEU;
    private String iEV;
    private String iEW;
    private boolean iEX;
    private boolean iEY;
    private boolean iEZ;
    private boolean iFA;
    private boolean iFB;
    private boolean iFC;
    private boolean iFD;
    private String iFE;
    private long iFF;
    private boolean iFG;
    private int iFH;
    private boolean iFI;
    private boolean iFJ;
    private int iFK;
    private final y iFL;
    private final j iFM;
    private final o iFN;
    private final aa iFO;
    private String iFP;
    private final CheckRealNameModel iFQ;
    private final AddExperiencedModel iFR;
    private SuggestEmotionModel iFS;
    private GetSugMatchWordsModel iFT;
    private boolean iFU;
    private int iFV;
    private String iFW;
    private PostData iFX;
    private PostData iFY;
    private int iFZ;
    private boolean iFa;
    private int iFb;
    private boolean iFc;
    private int iFd;
    private long iFe;
    private int iFf;
    private int iFg;
    private int iFh;
    private int iFi;
    private boolean iFj;
    private boolean iFk;
    private boolean iFl;
    private long iFm;
    private boolean iFn;
    private String iFo;
    private int iFp;
    private boolean iFq;
    private boolean iFr;
    private boolean iFs;
    private boolean iFt;
    private a iFu;
    private String iFv;
    private String iFw;
    private int iFx;
    private int iFy;
    private boolean iFz;
    private int iGa;
    private Rect iGb;
    private String iGc;
    private com.baidu.tieba.tbadkCore.data.m iGd;
    private boolean iGe;
    private String iGf;
    private String iGg;
    private String iGh;
    private String iGi;
    private CustomMessageListener iGj;
    private com.baidu.adp.framework.listener.a iGk;
    private PraiseData iGl;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    protected com.baidu.tieba.pb.data.f izO;
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
    private static final int iES = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.f fVar);
    }

    public PbModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.mStType = null;
        this.iET = null;
        this.iEU = null;
        this.iEV = null;
        this.mForumId = null;
        this.iEW = null;
        this.iEX = false;
        this.iEY = false;
        this.iEZ = true;
        this.iFa = true;
        this.mSortType = 0;
        this.iFb = 0;
        this.iFc = false;
        this.mIsGood = 0;
        this.iFd = 0;
        this.iFe = 0L;
        this.iFf = 1;
        this.iFg = 1;
        this.iFh = 1;
        this.iFi = 1;
        this.isAd = false;
        this.hKM = false;
        this.cQd = false;
        this.iFj = false;
        this.isFromMark = false;
        this.iFk = false;
        this.iFl = false;
        this.iFm = 0L;
        this.iFn = false;
        this.iFo = null;
        this.izO = null;
        this.isLoading = false;
        this.iFq = false;
        this.iFr = false;
        this.iFs = false;
        this.iFt = false;
        this.mLocate = null;
        this.mContext = null;
        this.iFu = null;
        this.opType = null;
        this.opUrl = null;
        this.iFv = null;
        this.iFw = null;
        this.iFx = -1;
        this.iFy = -1;
        this.fQM = null;
        this.iFA = false;
        this.iFB = false;
        this.postID = null;
        this.iFE = null;
        this.iFF = 0L;
        this.iFG = false;
        this.iFH = -1;
        this.iFJ = false;
        this.iFU = false;
        this.iFV = 0;
        this.mTabIndex = 0;
        this.iGe = false;
        this.iGj = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
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
        this.iGk = new com.baidu.adp.framework.listener.a(1001801, CmdConfigSocket.CMD_PB_PAGE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbModel.this.gms.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.iFA || !PbModel.this.iFB) {
                        if (!PbModel.this.iFA) {
                            PbModel.this.iFA = true;
                        } else {
                            PbModel.this.iFB = true;
                        }
                        if (PbModel.this.iFu != null) {
                            PbModel.this.iFu.a(PbModel.this.ckP(), z, responsedMessage, PbModel.this.iFC, System.currentTimeMillis() - PbModel.this.gBd);
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
                    if (PbModel.this.izO != null && PbModel.this.izO.chJ() != null && PbModel.this.izO.chJ().getForumId() != null && PbModel.this.izO.chJ().getForumId().equals(valueOf)) {
                        PbModel.this.izO.chJ().setIsLike(false);
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
                    if (PbModel.this.izO != null && PbModel.this.izO.chJ() != null && PbModel.this.izO.chJ().getForumId() != null && PbModel.this.izO.chJ().getForumId().equals(valueOf)) {
                        PbModel.this.izO.chJ().setIsLike(true);
                    }
                }
            }
        };
        this.iGl = null;
        registerListener(this.iGk);
        registerListener(this.iGj);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.izO = new com.baidu.tieba.pb.data.f();
        this.izO.yo(0);
        this.mContext = baseFragmentActivity.getPageContext().getPageActivity();
        this.gms = baseFragmentActivity;
        this.iFL = new y(this, this.gms);
        this.iFM = new j(this, this.gms);
        this.iFN = new o(this, this.gms);
        this.iFO = new aa(this, this.gms);
        this.iFQ = new CheckRealNameModel(this.gms.getPageContext());
        this.iFS = new SuggestEmotionModel();
        this.iFR = new AddExperiencedModel(this.gms.getPageContext());
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, String str) {
        this.iFD = true;
        if (fVar != null && fVar.iwh == null) {
            n(fVar);
            j(fVar);
            if (fVar.chK() != null) {
                fVar.chK().jq(0);
            }
            if (this.iFu != null && fVar != null) {
                this.iFu.a(true, 0, i, 0, fVar, str, 0);
            }
        }
    }

    protected int ckP() {
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
            this.iET = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.m(data)) {
                com.baidu.tbadk.BdToken.f.avg().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.5
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void n(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.cDZ) instanceof String)) {
                            PbModel.this.iET = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cDZ);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.iET)) {
                this.iET = this.iFL.av(intent);
                if (StringUtils.isNull(this.iET) && intent.getData() != null) {
                    this.iET = data.getQueryParameter("thread_id");
                }
            }
            if (com.baidu.tbadk.core.util.aq.isEmpty(this.iET)) {
                this.iET = "0";
            }
            this.iFV = intent.getIntExtra("key_start_from", 0);
            if (this.iFV == 0) {
                this.iFV = this.iFL.Wq;
            }
            this.iEV = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.iEU = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.iEX = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.iEY = intent.getBooleanExtra("host_only", false);
            this.iFa = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.aPa().aGp() ? 2 : 0);
            if (this.mSortType == 2) {
                this.iEV = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.iFd = intent.getIntExtra("is_top", 0);
            this.iFe = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.iFk = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.iFl = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.hKM = intent.getBooleanExtra("is_sub_pb", false);
            this.iFn = intent.getBooleanExtra("is_pv", false);
            this.iFm = intent.getLongExtra("msg_id", 0L);
            this.iFo = intent.getStringExtra("from_forum_name");
            this.iFw = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.iFv = intent.getStringExtra("op_stat");
            this.iFq = intent.getBooleanExtra("is_from_thread_config", false);
            this.iFr = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.iFs = intent.getBooleanExtra("is_from_my_god_config", false);
            this.iFy = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.iFx = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.cQd = intent.getBooleanExtra("from_frs", false);
            this.iFj = intent.getBooleanExtra("from_maintab", false);
            this.iFJ = intent.getBooleanExtra("from_smart_frs", false);
            this.iFt = intent.getBooleanExtra("from_hottopic", false);
            this.iFP = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.iEW = intent.getStringExtra("high_light_post_id");
            this.iGe = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.iFz = intent.getIntExtra("request_code", -1) == 18003;
            this.iGf = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
            this.iGg = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
            this.iGh = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
            this.iGi = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public boolean ckQ() {
        return this.iGe && com.baidu.tieba.frs.i.bAX() != null && com.baidu.tieba.frs.i.bAX().equals(this.iET) && com.baidu.tieba.frs.i.bAW() != null;
    }

    public com.baidu.tieba.pb.data.f aC(bj bjVar) {
        com.baidu.tieba.pb.data.f fVar = new com.baidu.tieba.pb.data.f();
        fVar.yo(3);
        if (bjVar == null) {
            return null;
        }
        fVar.az(bjVar);
        if (bjVar.aBq() != null) {
            fVar.e(bjVar.aBq());
            ForumData forum = fVar.getForum();
            forum.setId(bjVar.aBq().getForumId());
            forum.setName(bjVar.aBq().getForumName());
            forum.setUser_level(bjVar.aBq().ayU());
            forum.setImage_url(bjVar.aBq().getAvatar());
            forum.setPost_num(bjVar.aBq().postNum);
            forum.setMember_num(bjVar.aBq().memberNum);
        } else {
            ForumData forum2 = fVar.getForum();
            forum2.setId(String.valueOf(bjVar.getFid()));
            forum2.setName(bjVar.azJ());
        }
        PostData postData = new PostData();
        postData.Cl(1);
        postData.setTime(bjVar.getCreateTime());
        postData.a(bjVar.azE());
        MetaData azE = bjVar.azE();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(azE.getUserId(), azE);
        postData.setUserMap(hashMap);
        postData.c(TbRichTextView.a(this.mContext, bjVar.azu(), false));
        fVar.d(postData);
        fVar.chM().add(postData);
        com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
        lVar.Nl = bjVar;
        fVar.a(lVar);
        fVar.iwm = true;
        fVar.setIsNewUrl(1);
        return fVar;
    }

    public void initWithBundle(Bundle bundle) {
        this.iFV = bundle.getInt("key_start_from", 0);
        this.iET = bundle.getString("thread_id");
        this.iEV = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.iEU = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.iEX = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.iEY = bundle.getBoolean("host_only", false);
        this.iFa = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.iFd = bundle.getInt("is_top", 0);
        this.iFe = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.iFl = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.hKM = bundle.getBoolean("is_sub_pb", false);
        this.iFn = bundle.getBoolean("is_pv", false);
        this.iFm = bundle.getLong("msg_id", 0L);
        this.iFo = bundle.getString("from_forum_name");
        this.iFw = bundle.getString("extra_pb_cache_key");
        this.iFq = bundle.getBoolean("is_from_thread_config", false);
        this.iFr = bundle.getBoolean("is_from_interview_live_config", false);
        this.iFs = bundle.getBoolean("is_from_my_god_config", false);
        this.iFy = bundle.getInt("extra_pb_is_attention_key", -1);
        this.iFx = bundle.getInt("extra_pb_funs_count_key", -1);
        this.cQd = bundle.getBoolean("from_frs", false);
        this.iFj = bundle.getBoolean("from_maintab", false);
        this.iFJ = bundle.getBoolean("from_smart_frs", false);
        this.iFt = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.iEW = bundle.getString("high_light_post_id");
        this.oriUgcNid = bundle.getString("key_ori_ugc_nid");
        this.oriUgcTid = bundle.getString("key_ori_ugc_tid");
        this.oriUgcType = bundle.getInt("key_ori_ugc_type", 0);
        this.oriUgcVid = bundle.getString("key_ori_ugc_vid");
        this.iFz = bundle.getInt("request_code", -1) == 18003;
        this.iGf = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.iGg = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.iGh = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.iGi = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void au(Bundle bundle) {
        bundle.putString("thread_id", this.iET);
        bundle.putString("post_id", this.iEV);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.iFV);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.iEX);
        bundle.putBoolean("host_only", this.iEY);
        bundle.putBoolean("squence", this.iFa);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.iFd);
        bundle.putLong("thread_time", this.iFe);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.iFl);
        bundle.putBoolean("is_sub_pb", this.hKM);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.iFn);
        bundle.putLong("msg_id", this.iFm);
        bundle.putString("extra_pb_cache_key", this.iFw);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.iFq);
        bundle.putBoolean("is_from_interview_live_config", this.iFr);
        bundle.putBoolean("is_from_my_god_config", this.iFs);
        bundle.putInt("extra_pb_is_attention_key", this.iFy);
        bundle.putInt("extra_pb_funs_count_key", this.iFx);
        bundle.putBoolean("from_frs", this.cQd);
        bundle.putBoolean("from_maintab", this.iFj);
        bundle.putBoolean("from_smart_frs", this.iFJ);
        bundle.putBoolean("from_hottopic", this.iFt);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.iEW);
        bundle.putString("key_ori_ugc_nid", this.oriUgcNid);
        bundle.putString("key_ori_ugc_tid", this.oriUgcTid);
        bundle.putInt("key_ori_ugc_type", this.oriUgcType);
        bundle.putString("key_ori_ugc_vid", this.oriUgcVid);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.iGf);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.iGg);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.iGh);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.iGi);
    }

    public String ckR() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.iET);
        if (!this.iFl) {
            sb.append(this.iEV);
        }
        sb.append(this.iEY);
        sb.append(this.iFa);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.iFd);
        sb.append(this.iFe);
        sb.append(this.cQd);
        sb.append(this.iFj);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.hKM);
        sb.append(this.iFn);
        sb.append(this.iFm);
        sb.append(this.iFo);
        sb.append(this.mThreadType);
        sb.append(this.iFq);
        sb.append(this.iFr);
        sb.append(this.iFs);
        sb.append(this.oriUgcNid);
        sb.append(this.oriUgcTid);
        sb.append(this.oriUgcVid);
        sb.append(this.oriUgcType);
        if (this.iFw != null) {
            sb.append(this.iFw);
        }
        return sb.toString();
    }

    public String ciK() {
        return this.iFo;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String ckS() {
        return this.iEV;
    }

    public String ckT() {
        return this.iEW;
    }

    public String ckU() {
        return this.iET;
    }

    public boolean getHostMode() {
        return this.iEY;
    }

    public boolean ckV() {
        return clN();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean ckW() {
        return this.cQd;
    }

    public boolean ckX() {
        return this.iFc;
    }

    public boolean ckY() {
        return this.iFj;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean ckZ() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bvj() {
        return this.iFd;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void yF(int i) {
        this.iFd = i;
    }

    public boolean cla() {
        return this.hKM;
    }

    public boolean clb() {
        if (this.izO == null) {
            return false;
        }
        return this.izO.isValid();
    }

    public String azN() {
        if (this.izO == null || !this.izO.awd()) {
            return null;
        }
        return this.izO.awc();
    }

    public boolean yG(int i) {
        this.iFf = i;
        if (this.iFf > this.izO.getPage().ayt()) {
            this.iFf = this.izO.getPage().ayt();
        }
        if (this.iFf < 1) {
            this.iFf = 1;
        }
        if (this.iET == null) {
            return false;
        }
        return yI(5);
    }

    public void yH(int i) {
        this.iFf = i;
        this.iFg = i;
        this.iFh = i;
    }

    public void b(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar == null) {
            yH(1);
            return;
        }
        if (this.iFg < apVar.ayw()) {
            this.iFg = apVar.ayw();
        }
        if (this.iFh > apVar.ayw()) {
            this.iFh = apVar.ayw();
        }
        this.iFi = apVar.ayt();
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.izO;
    }

    public BaijiahaoData clc() {
        if (this.izO == null || this.izO.chK() == null) {
            return null;
        }
        return this.izO.chK().getBaijiahaoData();
    }

    public com.baidu.tieba.pb.data.f cld() {
        if (this.izO == null) {
            return this.izO;
        }
        if (!cle() && this.iGd != null) {
            this.izO.b(this.iGd);
        }
        return this.izO;
    }

    private boolean cle() {
        return (this.izO.chZ() == null || this.izO.chZ().cIh() == null || this.izO.chZ().cIh().goods != null || this.izO.chZ().cIh().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.ap getPageData() {
        if (this.izO == null) {
            return null;
        }
        return this.izO.getPage();
    }

    public boolean clf() {
        if (clN() && this.izO.getPage().ayy() == 0) {
            pG(true);
            return true;
        }
        return false;
    }

    public void h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            this.iET = fVar.getThreadId();
            if (fVar.chK() != null && fVar.chK().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fVar.chK().getBaijiahaoData();
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
            this.iEV = null;
            this.iEY = false;
            this.iFa = true;
            LoadData();
        }
    }

    public void Fp(String str) {
        if (!StringUtils.isNull(str)) {
            this.iET = str;
            this.iEV = null;
            this.iEY = false;
            this.iFa = true;
            LoadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.iET == null) {
            return false;
        }
        cancelLoadData();
        if (this.fQM == null) {
            this.fQM = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.fQM.start();
        }
        boolean yI = yI(3);
        if (this.opType != null) {
            this.opType = null;
            this.iFv = null;
            this.opUrl = null;
            return yI;
        }
        return yI;
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
        if (this.iFS != null) {
            this.iFS.cancelLoadData();
        }
        if (this.iFT != null) {
            this.iFT.cancelLoadData();
        }
        bwk();
    }

    private void bwk() {
        if (this.fQM != null) {
            this.fQM.destory();
            this.fQM = null;
        }
    }

    public boolean clg() {
        return (this.iEV == null || this.iEV.equals("0") || this.iEV.length() == 0) ? LoadData() : cll();
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
                this.iFS.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.iFS.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.iFT == null) {
                this.iFT = new GetSugMatchWordsModel(this.gms.getPageContext());
            }
            this.iFT.b(aVar);
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
    public boolean yI(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        yJ(i);
        final com.baidu.tieba.pb.data.f pbData = ak.cmq().getPbData();
        if (pbData != null && pbData.chK() != null) {
            pbData.chK().jq(0);
            this.iFa = ak.cmq().ckV();
            this.iEY = ak.cmq().cmv();
            this.iFc = ak.cmq().cmw();
            this.iFX = ak.cmq().cmu();
            this.iFY = ak.cmq().cmt();
            this.iFZ = ak.cmq().cms();
            this.iGb = ak.cmq().cmx();
            this.mTabIndex = ak.cmq().clU();
            this.iFU = this.iEY;
            if (this.iEY || this.isFromMark) {
                this.iFz = false;
            }
            com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.iFD) {
            a(clq(), true, this.iEV, 3);
        }
        if (i == 3 && !this.iFD) {
            if (this.isFromMark) {
                a(clq(), true, this.iEV, 3);
            } else {
                a(clq(), false, this.iEV, 3);
            }
        }
        this.iFD = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.iGd == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.dru);
        if (this.iEY || this.isFromMark) {
            this.iFz = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.iET == null || this.iET.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.f.b.toLong(this.iET, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        pbPageRequestMessage.set_scr_w(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        pbPageRequestMessage.set_q_type(Integer.valueOf(com.baidu.tbadk.core.util.ar.aDX().aDY() ? 2 : 1));
        if (!this.iFa) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.iEY) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.iFn) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.iFm));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.iFz) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.f.b.toInt(this.iFv, 0));
            pbPageRequestMessage.setOpMessageID(this.iFm);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> chM = this.izO.chM();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iFh - 1));
                        if (this.iFh - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.iFk) {
                                if (chM != null && chM.size() > 0) {
                                    size = chM.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = chM.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.iEV = postData.getId();
                                            if (StringUtils.isNull(this.iEV)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.iFg + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.iEV == null && this.iEV.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iEV, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iFg + 1));
                        if (this.iFg >= this.iFi) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (chM != null) {
                                size = chM.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.iEV == null) {
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
                if (chM != null) {
                }
                if (this.iEV == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (chM != null && chM.size() > 0 && chM.get(0) != null) {
                    this.iEV = chM.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (clN()) {
                        if (this.iFh - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.iFh - 1));
                        }
                    } else if (this.iFg < this.iFi) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iFg + 1));
                    }
                }
                if (this.iEV != null && this.iEV.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iEV, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.iEY) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (clN()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.iFi > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.iFi));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iEV, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.iFf));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.iFU && !this.iEY) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iEV, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.iEY) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.iFH);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.f.b.toLong(this.iFW, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.iFU = this.iEY;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(clq());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.iFV));
        pbPageRequestMessage.setIsSubPostDataReverse(this.iFG);
        pbPageRequestMessage.setFromSmartFrs(this.iFJ ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.iEX);
        pbPageRequestMessage.setOriUgcNid(this.oriUgcNid);
        pbPageRequestMessage.setOriUgcTid(this.oriUgcTid);
        pbPageRequestMessage.setOriUgcType(this.oriUgcType);
        pbPageRequestMessage.setOriUgcVid(this.oriUgcVid);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.iET);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean ciJ() {
        switch (clG()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().chK() == null || !getPbData().chK().aAY();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(ciK()) && com.baidu.tieba.recapp.r.czO().czI() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.czO().czI().ax(ciK(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.czO().czI().ay(ciK(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(ciK()) && com.baidu.tieba.recapp.r.czO().czI() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.czO().czI().ay(ciK(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.czO().czI().ax(ciK(), true));
        }
    }

    protected void yJ(int i) {
        boolean z = false;
        yO(i);
        ArrayList<PostData> chM = this.izO.chM();
        this.iFC = false;
        if (i == 1) {
            boolean z2 = false;
            while (chM.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                chM.remove(0);
                z2 = true;
            }
            if (z2) {
                this.izO.getPage().jn(1);
                if (this.iFu != null) {
                    this.iFu.e(this.izO);
                }
            }
            this.gBd = System.currentTimeMillis();
            this.iFC = true;
        } else if (i == 2) {
            while (chM.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                chM.remove(chM.size() - 1);
                z = true;
            }
            if (z) {
                this.izO.getPage().jm(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.iFK = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            j(fVar2);
        }
        i(fVar2);
        if (this.iGd != null && this.iGd.isValidate()) {
            TiebaStatic.log(com.baidu.tieba.r.a.b(PageStayDurationConstants.PageName.PB, "common_fill", true, 1));
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.chZ() != null && fVar.chZ().cIh() != null && fVar.chZ().cIh().goods != null && fVar.chZ().isValidate() && fVar.chZ().cIh().goods.goods_style != 1001) {
            this.iGd = fVar.chZ();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m clh() {
        return this.iGd;
    }

    public void cli() {
        this.iGd = null;
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
            if (this.iFs || this.iFq || this.iFr) {
                fVar = l(fVar);
            }
            k(fVar);
        }
    }

    protected void k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String m = m(fVar);
            for (int i = 0; i < fVar.chM().size(); i++) {
                PostData postData = fVar.chM().get(i);
                for (int i2 = 0; i2 < postData.cIq().size(); i2++) {
                    postData.cIq().get(i2).a(this.gms.getPageContext(), m.equals(postData.cIq().get(i2).azE().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.o chV = fVar.chV();
            if (chV != null && !com.baidu.tbadk.core.util.v.isEmpty(chV.ixt)) {
                for (PostData postData2 : chV.ixt) {
                    for (int i3 = 0; i3 < postData2.cIq().size(); i3++) {
                        postData2.cIq().get(i3).a(this.gms.getPageContext(), m.equals(postData2.cIq().get(i3).azE().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String m = m(fVar);
            com.baidu.tieba.pb.data.o chV = fVar.chV();
            if (chV != null && !com.baidu.tbadk.core.util.v.isEmpty(chV.ixt)) {
                for (PostData postData : chV.ixt.subList(i, chV.ixt.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cIq().size()) {
                            postData.cIq().get(i3).a(this.gms.getPageContext(), m.equals(postData.cIq().get(i3).azE().getUserId()));
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
        bj chK = fVar.chK();
        chK.jv(this.mIsGood);
        chK.ju(this.iFd);
        if (this.iFe > 0) {
            chK.bo(this.iFe);
            return fVar;
        }
        return fVar;
    }

    protected String m(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.chK() != null && fVar.chK().azE() != null) {
            str = fVar.chK().azE().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public MetaData clj() {
        if (this.izO == null || this.izO.chK() == null || this.izO.chK().azE() == null) {
            return null;
        }
        return this.izO.chK().azE();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int size;
        int i4;
        int i5;
        boolean z4 = !z;
        this.iFI = z3;
        this.iFp = i;
        if (this.fQM != null && !z3) {
            this.fQM.a(z2, z4, i2, str, i3, j, j2);
            this.fQM = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(ciK()) && com.baidu.tieba.recapp.r.czO().czI() != null) {
            com.baidu.tieba.recapp.r.czO().czI().g(ciK(), yK(clt()), true);
        }
        if (fVar == null || (this.iFf == 1 && i == 5 && fVar.chM() != null && fVar.chM().size() < 1)) {
            if (this.iFu != null) {
                this.iFa = this.iEZ;
                if (i2 != 350006) {
                    this.mSortType = this.iFb;
                }
                this.iFu.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.iEZ = this.iFa;
            if (i != 8) {
                this.iFb = this.mSortType;
                this.mSortType = fVar.iwg;
            }
            if (fVar.iwf != null && fVar.iwf.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.gms.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                fVar.iwf = new ArrayList();
                fVar.iwf.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.gms.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                fVar.iwf.add(builder2.build(false));
                this.mSortType = this.iFb;
                fVar.iwg = this.mSortType;
            }
            this.iFn = false;
            if (fVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(fVar.getPage());
            }
            this.iFi = this.iFi < 1 ? 1 : this.iFi;
            ArrayList<PostData> chM = this.izO.chM();
            switch (i) {
                case 1:
                    this.izO.a(fVar.getPage(), 1);
                    d(fVar, chM);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.chM() == null) {
                        i5 = 0;
                    } else {
                        int size2 = fVar.chM().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(chM, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(fVar.chM(), com.baidu.tbadk.core.util.v.getCount(fVar.chM()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size2;
                        } else {
                            fVar.chM().remove(postData2);
                            i5 = size2 - 1;
                        }
                        chM.addAll(0, fVar.chM());
                    }
                    this.izO.a(fVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (this.mSortType == 1 && fVar.getPage() != null) {
                        fVar.getPage().jk(fVar.getPage().ayt());
                    }
                    n(fVar);
                    if (!z3 && this.mThreadType != 33 && clN()) {
                        clk();
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
                    if (fVar != null && !com.baidu.tbadk.core.util.v.isEmpty(fVar.chM()) && this.izO != null && (!this.iEY || m(fVar).equals(fVar.chM().get(0).azE().getUserId()))) {
                        if (this.izO.getPage().ayy() == 0) {
                            this.izO.getPage().jm(1);
                        }
                        clH();
                        this.iFX = fVar.chM().get(0);
                        if (clN() || this.izO.cik()) {
                            if (this.izO.chM().size() - this.iFZ >= 3) {
                                this.iFY = new PostData();
                                this.iFY.kck = true;
                                this.iFY.setPostType(53);
                                this.izO.chM().add(this.iFY);
                            }
                            this.izO.chM().add(this.iFX);
                            size = this.izO.chM().size() - 1;
                        } else {
                            if (this.iFZ - this.iGa >= 3) {
                                this.iFY = new PostData();
                                this.iFY.kck = false;
                                this.iFY.setPostType(53);
                                this.izO.chM().add(0, this.iFY);
                            }
                            this.izO.chM().add(0, this.iFX);
                            size = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.isTaday(com.baidu.tbadk.core.sharedPref.b.aCY().getLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.iFX.kcx = this.izO.cii();
                            com.baidu.tbadk.core.sharedPref.b.aCY().putLong(SharedPrefConfig.KEY_PB_POST_RECOMMEND_LIVE_DATE_PREFIX + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.izO != null && this.izO.chK() != null) {
                PraiseData azp = this.izO.chK().azp();
                if (this.iGl != null && !azp.isPriaseDataValid()) {
                    this.izO.chK().a(this.iGl);
                } else {
                    this.iGl = this.izO.chK().azp();
                    this.iGl.setPostId(this.izO.chK().azU());
                }
                if (fVar.getPage() != null && fVar.getPage().ayw() == 1 && fVar.chK() != null && fVar.chK().azP() != null && fVar.chK().azP().size() > 0) {
                    this.izO.chK().v(fVar.chK().azP());
                }
                this.izO.chK().js(fVar.chK().azv());
                this.izO.chK().jo(fVar.chK().getAnchorLevel());
                this.izO.chK().jq(fVar.chK().azl());
                if (this.mThreadType == 33) {
                    this.izO.chK().azE().setHadConcerned(fVar.chK().azE().hadConcerned());
                }
                if (fVar != null && fVar.chK() != null) {
                    this.izO.chK().jx(fVar.chK().azT());
                }
            }
            if (this.izO != null && this.izO.getUserData() != null && fVar.getUserData() != null) {
                this.izO.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.izO.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.getPage() != null && fVar.getPage().ayw() == 1 && fVar.chU() != null) {
                this.izO.e(fVar.chU());
            }
            if (this.iFI) {
                if (this.izO.chK() != null && this.izO.chK().azE() != null && this.izO.chM() != null && com.baidu.tbadk.core.util.v.getItem(this.izO.chM(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(this.izO.chM(), 0);
                    MetaData azE = this.izO.chK().azE();
                    if (postData3.azE() != null && postData3.azE().getGodUserData() != null) {
                        if (this.iFx != -1) {
                            azE.setFansNum(this.iFx);
                            postData3.azE().setFansNum(this.iFx);
                        }
                        if (this.iFy != -1) {
                            azE.getGodUserData().setIsLike(this.iFy == 1);
                            postData3.azE().getGodUserData().setIsLike(this.iFy == 1);
                            azE.getGodUserData().setIsFromNetWork(false);
                            postData3.azE().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.izO.iwe = -1;
                this.izO.iwd = -1;
            }
            if (this.iFu != null) {
                this.iFu.a(true, getErrorCode(), i, i4, this.izO, this.mErrorString, 1);
            }
        }
        if (this.izO != null && this.izO.chK() != null && this.izO.getForum() != null && !this.izO.cik()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.gms.getPageContext();
            historyMessage.threadId = getPbData().chK().getId();
            if (this.mIsShareThread && getPbData().chK().cPD != null) {
                historyMessage.threadName = getPbData().chK().cPD.showText;
            } else {
                historyMessage.threadName = getPbData().chK().getTitle();
            }
            if (this.mIsShareThread && !ciJ()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = ckV();
            historyMessage.threadType = getPbData().chK().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aL;
        if (arrayList != null && fVar.chM() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(fVar.chM(), 0);
            if (postData != null && (aL = aL(arrayList)) != null && aL.equals(postData.getId())) {
                fVar.chM().remove(postData);
            }
            arrayList.addAll(fVar.chM());
        }
    }

    private int yK(int i) {
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
            fVar.Fk(this.izO.cic());
            this.izO = fVar;
            yH(fVar.getPage().ayw());
        }
    }

    private void clk() {
        if (this.izO != null && this.izO.chM() != null && this.izO.cib() != null) {
            ArrayList<PostData> chM = this.izO.chM();
            com.baidu.tieba.pb.data.a cib = this.izO.cib();
            int chF = cib.chF();
            if (chF > 0) {
                if (chF <= chM.size()) {
                    chM.add(chF, cib);
                } else {
                    chM.add(cib);
                }
            }
        }
    }

    public boolean cll() {
        if (this.iET == null || this.iEV == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return yI(4);
        }
        return yI(6);
    }

    public boolean pG(boolean z) {
        if (this.iET == null || this.izO == null) {
            return false;
        }
        if (z || this.izO.getPage().ayy() != 0) {
            return yI(1);
        }
        return false;
    }

    public boolean pH(boolean z) {
        if (this.iET == null || this.izO == null) {
            return false;
        }
        if ((z || this.izO.getPage().ayz() != 0) && this.izO.chM() != null && this.izO.chM().size() >= 1) {
            return yI(2);
        }
        return false;
    }

    public boolean Fw(String str) {
        this.iEY = !this.iEY;
        this.iEV = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").Z("obj_source", 0));
        if (yI(6)) {
            return true;
        }
        this.iEY = this.iEY ? false : true;
        return false;
    }

    public boolean u(boolean z, String str) {
        if (this.iEY == z) {
            return false;
        }
        this.iEY = z;
        this.iEV = str;
        if (this.mSortType == 2) {
            this.iEV = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").Z("obj_source", 1));
        }
        if (yI(6)) {
            return true;
        }
        this.iEY = z ? false : true;
        return false;
    }

    public boolean yL(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.iEZ = this.iFa;
        this.iFb = this.mSortType;
        this.mSortType = i;
        this.iFa = !this.iFa;
        if (i == 2 && this.isFromMark) {
            this.iEV = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.iFa = this.iFa ? false : true;
            this.mSortType = this.iFb;
            return false;
        }
        return true;
    }

    public boolean clm() {
        return clN();
    }

    public int cln() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.izO == null || this.izO.getForum() == null || this.izO.chK() == null) ? false : true;
    }

    public boolean awd() {
        if (this.izO == null) {
            return false;
        }
        return this.izO.awd();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData uM(String str) {
        if (this.izO == null || this.izO.chK() == null || this.izO.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.izO.chK().aAY()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.izO.getForum().getId());
            writeData.setForumName(this.izO.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.iFV);
        writeData.setThreadId(this.iET);
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

    public MarkData yM(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.izO == null) {
            return null;
        }
        ArrayList<PostData> chM = this.izO.chM();
        if (com.baidu.tbadk.core.util.v.isEmpty(chM)) {
            return null;
        }
        if (chM.size() > 0 && i >= chM.size()) {
            i = chM.size() - 1;
        }
        return l(chM.get(i));
    }

    public MarkData clo() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iET);
        markData.setPostId(this.izO.awc());
        markData.setTime(date.getTime());
        markData.setHostMode(this.iEY);
        markData.setSequence(Boolean.valueOf(clN()));
        markData.setId(this.iET);
        return markData;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iET);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.iEY);
        markData.setSequence(Boolean.valueOf(clN()));
        markData.setId(this.iET);
        markData.setFloor(postData.cIt());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void clp() {
        i.cjC().ar(clq(), this.isFromMark);
    }

    private String clq() {
        String clr = (this.iET == null || this.iET.equals("0")) ? clr() : this.iET;
        if (this.iEY) {
            clr = clr + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            clr = clr + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return clr + TbadkCoreApplication.getCurrentAccount();
        }
        return clr;
    }

    private String clr() {
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

    public void pI(boolean z) {
        if (this.izO != null) {
            this.izO.fa(z);
        }
    }

    public boolean cls() {
        return this.iFz;
    }

    public void a(a aVar) {
        this.iFu = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aLX() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aLW() {
        return clg();
    }

    public boolean Fx(String str) {
        if (getPbData() == null || getPbData().chK() == null || getPbData().chK().azE() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().chK().azE().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int clt() {
        return this.mRequestType;
    }

    public void clu() {
        String clq = clq();
        i.cjC().ar(clq, false);
        i.cjC().ar(clq, true);
    }

    public void clv() {
        if ("personalize_page".equals(this.mStType)) {
            this.iFF = System.currentTimeMillis() / 1000;
        }
    }

    public void clw() {
        if ("personalize_page".equals(this.mStType) && this.izO != null && this.iFF != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").cp("fid", this.izO.getForumId()).cp("tid", this.iET).cp("obj_duration", String.valueOf(currentTimeMillis - this.iFF)).cp(TiebaInitialize.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.iFF = 0L;
        }
    }

    public boolean clx() {
        return this.iFI;
    }

    public int getErrorNo() {
        return this.iFK;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public j cly() {
        return this.iFM;
    }

    public o clz() {
        return this.iFN;
    }

    public aa clA() {
        return this.iFO;
    }

    public CheckRealNameModel clB() {
        return this.iFQ;
    }

    public AddExperiencedModel clC() {
        return this.iFR;
    }

    public String clD() {
        return this.iFE;
    }

    public void Fy(String str) {
        this.iFE = str;
    }

    public boolean clE() {
        return this.iFJ;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.izO != null && this.izO.chM() != null && this.izO.chM().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.izO.chM().size();
                for (int i = 0; i < size; i++) {
                    if (this.izO.chM().get(i) != null && this.izO.chM().get(i).azE() != null && currentAccount.equals(this.izO.chM().get(i).azE().getUserId()) && this.izO.chM().get(i).azE().getPendantData() != null) {
                        this.izO.chM().get(i).azE().getPendantData().sh(mVar.axX());
                        this.izO.chM().get(i).azE().getPendantData().bB(mVar.aLh());
                    }
                }
            }
        }
    }

    public String clF() {
        return this.iFP;
    }

    public int clG() {
        return this.iFV;
    }

    public void yN(int i) {
        this.iFV = i;
    }

    public void Fz(String str) {
        if ((!this.iEY || Fx(TbadkCoreApplication.getCurrentAccount())) && this.izO.chM() != null) {
            this.izO.getPage().jm(1);
            if (this.izO.getPage().ayy() == 0) {
                this.izO.getPage().jm(1);
            }
            this.iFW = str;
            yI(8);
        }
    }

    private void yO(int i) {
        if (i != 8) {
            this.iFW = "";
            if (this.iFX != null) {
                if (i == 1 && this.izO != null && this.izO.cik()) {
                    if (this.iFY != null) {
                        getPbData().chM().remove(this.iFY);
                    }
                } else if (i == 1 && !this.iFa && !com.baidu.tbadk.core.util.v.isEmpty(getPbData().chM())) {
                    getPbData().chM().remove(this.iFX);
                    if (this.iFY != null) {
                        getPbData().chM().remove(this.iFY);
                    }
                    getPbData().chM().add(0, this.iFX);
                } else {
                    getPbData().chM().remove(this.iFX);
                    if (this.iFY != null) {
                        getPbData().chM().remove(this.iFY);
                    }
                }
            }
            this.iFY = null;
        }
    }

    public void clH() {
        if (this.izO != null && !com.baidu.tbadk.core.util.v.isEmpty(this.izO.chM())) {
            if (this.iFY != null) {
                this.izO.chM().remove(this.iFY);
                this.iFY = null;
            }
            if (this.iFX != null) {
                this.izO.chM().remove(this.iFX);
                this.iFX = null;
            }
        }
    }

    public void cr(int i, int i2) {
        this.iFZ = i;
        this.iGa = i2;
    }

    public PostData clI() {
        return this.iFX;
    }

    public PostData clJ() {
        return this.iFY;
    }

    public int clK() {
        return this.iFZ;
    }

    public int clL() {
        return this.iGa;
    }

    public String clM() {
        return this.iGc;
    }

    public void FA(String str) {
        this.iGc = str;
    }

    private boolean clN() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean clO() {
        return this.iFV == 13 || this.iFV == 12;
    }

    public String clP() {
        return this.iGf;
    }

    public String clQ() {
        return this.iGg;
    }

    public String clR() {
        return this.iGh;
    }

    public String clS() {
        return this.iGi;
    }

    public Rect clT() {
        Rect rect = this.iGb;
        this.iGb = null;
        return rect;
    }

    public int clU() {
        return this.mTabIndex;
    }
}
