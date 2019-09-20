package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
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
/* loaded from: classes4.dex */
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
    private BaseActivity cXM;
    private int eKw;
    private final CheckRealNameModel ebh;
    private long fOn;
    private com.baidu.tieba.tbadkCore.d.b fao;
    private boolean gZA;
    private boolean hSA;
    private boolean hSB;
    private int hSC;
    private boolean hSD;
    private int hSE;
    private long hSF;
    private int hSG;
    private int hSH;
    private int hSI;
    private boolean hSJ;
    private boolean hSK;
    private boolean hSL;
    private boolean hSM;
    private long hSN;
    private boolean hSO;
    private String hSP;
    protected com.baidu.tieba.pb.data.d hSQ;
    private int hSR;
    private boolean hSS;
    private boolean hST;
    private boolean hSU;
    private boolean hSV;
    private a hSW;
    private String hSX;
    private String hSY;
    private int hSZ;
    protected String hSu;
    private String hSv;
    private String hSw;
    private String hSx;
    private boolean hSy;
    private boolean hSz;
    private int hTA;
    private int hTB;
    private String hTC;
    private com.baidu.tieba.tbadkCore.data.m hTD;
    private CustomMessageListener hTE;
    private CustomMessageListener hTF;
    private com.baidu.adp.framework.listener.a hTG;
    private PraiseData hTH;
    private int hTa;
    private boolean hTb;
    private boolean hTc;
    private boolean hTd;
    private boolean hTe;
    private boolean hTf;
    private String hTg;
    private long hTh;
    private boolean hTi;
    private int hTj;
    private boolean hTk;
    private boolean hTl;
    private int hTm;
    private final x hTn;
    private final h hTo;
    private final m hTp;
    private final z hTq;
    private String hTr;
    private final AddExperiencedModel hTs;
    private SuggestEmotionModel hTt;
    private GetSugMatchWordsModel hTu;
    private boolean hTv;
    private int hTw;
    private String hTx;
    private PostData hTy;
    private PostData hTz;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private com.baidu.tieba.pb.data.c mAppealInfo;
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
    protected int mThreadType;
    private CustomMessageListener mUnlikeForumListener;
    private String opType;
    private String opUrl;
    private String postID;
    private static final int hSt = com.baidu.tbadk.data.d.arG() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.d dVar);
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.hSu = null;
        this.hSv = null;
        this.hSw = null;
        this.mForumId = null;
        this.hSx = null;
        this.hSy = false;
        this.hSz = false;
        this.hSA = true;
        this.hSB = true;
        this.mSortType = 0;
        this.hSC = 0;
        this.hSD = false;
        this.mIsGood = 0;
        this.hSE = 0;
        this.hSF = 0L;
        this.hSG = 1;
        this.hSH = 1;
        this.hSI = 1;
        this.eKw = 1;
        this.isAd = false;
        this.gZA = false;
        this.hSJ = false;
        this.hSK = false;
        this.isFromMark = false;
        this.hSL = false;
        this.hSM = false;
        this.hSN = 0L;
        this.hSO = false;
        this.hSP = null;
        this.hSQ = null;
        this.isLoading = false;
        this.hSS = false;
        this.hST = false;
        this.hSU = false;
        this.hSV = false;
        this.mLocate = null;
        this.mContext = null;
        this.hSW = null;
        this.opType = null;
        this.opUrl = null;
        this.hSX = null;
        this.hSY = null;
        this.hSZ = -1;
        this.hTa = -1;
        this.fao = null;
        this.hTc = false;
        this.hTd = false;
        this.postID = null;
        this.hTg = null;
        this.hTh = 0L;
        this.hTi = false;
        this.hTj = -1;
        this.hTl = false;
        this.hTv = false;
        this.hTw = 0;
        this.hTE = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.hTf = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null && pbData.hKJ == null) {
                    PbModel.this.l(pbData);
                    PbModel.this.h(pbData);
                    if (pbData.bTy() != null) {
                        pbData.bTy().hh(0);
                    }
                    if (PbModel.this.hSW != null && pbData != null) {
                        com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.hSW.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.hTF = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.hTG = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.kc()) {
                        PbModel.this.cXM.showToast(responsedMessage.getErrorString());
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
                        objArr[4] = "seq_id";
                        objArr[5] = Long.valueOf(j);
                        com.baidu.tbadk.core.e.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    }
                    if (!PbModel.this.hTc || !PbModel.this.hTd) {
                        if (!PbModel.this.hTc) {
                            PbModel.this.hTc = true;
                        } else {
                            PbModel.this.hTd = true;
                        }
                        if (PbModel.this.hSW != null) {
                            PbModel.this.hSW.a(PbModel.this.bWv(), z, responsedMessage, PbModel.this.hTe, System.currentTimeMillis() - PbModel.this.fOn);
                        }
                    }
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    String valueOf = String.valueOf(customResponsedMessage.getData());
                    if (PbModel.this.hSQ != null && PbModel.this.hSQ.bTx() != null && PbModel.this.hSQ.bTx().getForumId() != null && PbModel.this.hSQ.bTx().getForumId().equals(valueOf)) {
                        PbModel.this.hSQ.bTx().setIsLike(false);
                    }
                }
            }
        };
        this.mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.PbModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    String valueOf = String.valueOf(customResponsedMessage.getData());
                    if (PbModel.this.hSQ != null && PbModel.this.hSQ.bTx() != null && PbModel.this.hSQ.bTx().getForumId() != null && PbModel.this.hSQ.bTx().getForumId().equals(valueOf)) {
                        PbModel.this.hSQ.bTx().setIsLike(true);
                    }
                }
            }
        };
        this.hTH = null;
        registerListener(this.hTE);
        registerListener(this.hTG);
        registerListener(this.hTF);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.hSQ = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.cXM = baseActivity;
        this.hTn = new x(this, this.cXM);
        this.hTo = new h(this, this.cXM);
        this.hTp = new m(this, this.cXM);
        this.hTq = new z(this, this.cXM);
        this.ebh = new CheckRealNameModel(this.cXM.getPageContext());
        this.hTt = new SuggestEmotionModel();
        this.hTs = new AddExperiencedModel(this.cXM.getPageContext());
    }

    protected int bWv() {
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
            this.hSu = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.m(data)) {
                com.baidu.tbadk.BdToken.f.ZA().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.bzK) instanceof String)) {
                            PbModel.this.hSu = (String) hashMap.get(com.baidu.tbadk.BdToken.f.bzK);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.hSu)) {
                this.hSu = this.hTn.au(intent);
                if (StringUtils.isNull(this.hSu) && intent.getData() != null) {
                    this.hSu = data.getQueryParameter("thread_id");
                }
            }
            this.hTw = intent.getIntExtra("key_start_from", 0);
            if (this.hTw == 0) {
                this.hTw = this.hTn.hTN;
            }
            this.hSw = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.hSv = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.hSy = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.hSz = intent.getBooleanExtra("host_only", false);
            this.hSB = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.awk().amc() ? 2 : 0);
            if (this.mSortType == 2) {
                this.hSw = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.hSE = intent.getIntExtra("is_top", 0);
            this.hSF = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.hSL = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.hSM = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.gZA = intent.getBooleanExtra("is_sub_pb", false);
            this.hSO = intent.getBooleanExtra("is_pv", false);
            this.hSN = intent.getLongExtra("msg_id", 0L);
            this.hSP = intent.getStringExtra("from_forum_name");
            this.hSY = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.hSX = intent.getStringExtra("op_stat");
            this.hSS = intent.getBooleanExtra("is_from_thread_config", false);
            this.hST = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.hSU = intent.getBooleanExtra("is_from_my_god_config", false);
            this.hTa = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.hSZ = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.hSJ = intent.getBooleanExtra("from_frs", false);
            this.hSK = intent.getBooleanExtra("from_maintab", false);
            this.hTl = intent.getBooleanExtra("from_smart_frs", false);
            this.hSV = intent.getBooleanExtra("from_hottopic", false);
            this.hTr = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.hSx = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.hTw = bundle.getInt("key_start_from", 0);
        this.hSu = bundle.getString("thread_id");
        this.hSw = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.hSv = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.hSy = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.hSz = bundle.getBoolean("host_only", false);
        this.hSB = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.hSE = bundle.getInt("is_top", 0);
        this.hSF = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.hSM = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.gZA = bundle.getBoolean("is_sub_pb", false);
        this.hSO = bundle.getBoolean("is_pv", false);
        this.hSN = bundle.getLong("msg_id", 0L);
        this.hSP = bundle.getString("from_forum_name");
        this.hSY = bundle.getString("extra_pb_cache_key");
        this.hSS = bundle.getBoolean("is_from_thread_config", false);
        this.hST = bundle.getBoolean("is_from_interview_live_config", false);
        this.hSU = bundle.getBoolean("is_from_my_god_config", false);
        this.hTa = bundle.getInt("extra_pb_is_attention_key", -1);
        this.hSZ = bundle.getInt("extra_pb_funs_count_key", -1);
        this.hSJ = bundle.getBoolean("from_frs", false);
        this.hSK = bundle.getBoolean("from_maintab", false);
        this.hTl = bundle.getBoolean("from_smart_frs", false);
        this.hSV = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.hSx = bundle.getString("high_light_post_id");
    }

    public void ab(Bundle bundle) {
        bundle.putString("thread_id", this.hSu);
        bundle.putString("post_id", this.hSw);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.hTw);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.hSy);
        bundle.putBoolean("host_only", this.hSz);
        bundle.putBoolean("squence", this.hSB);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.hSE);
        bundle.putLong("thread_time", this.hSF);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.hSM);
        bundle.putBoolean("is_sub_pb", this.gZA);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.hSO);
        bundle.putLong("msg_id", this.hSN);
        bundle.putString("extra_pb_cache_key", this.hSY);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.hSS);
        bundle.putBoolean("is_from_interview_live_config", this.hST);
        bundle.putBoolean("is_from_my_god_config", this.hSU);
        bundle.putInt("extra_pb_is_attention_key", this.hTa);
        bundle.putInt("extra_pb_funs_count_key", this.hSZ);
        bundle.putBoolean("from_frs", this.hSJ);
        bundle.putBoolean("from_maintab", this.hSK);
        bundle.putBoolean("from_smart_frs", this.hTl);
        bundle.putBoolean("from_hottopic", this.hSV);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.hSx);
    }

    public String bWw() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.hSu);
        if (!this.hSM) {
            sb.append(this.hSw);
        }
        sb.append(this.hSz);
        sb.append(this.hSB);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.hSE);
        sb.append(this.hSF);
        sb.append(this.hSJ);
        sb.append(this.hSK);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.gZA);
        sb.append(this.hSO);
        sb.append(this.hSN);
        sb.append(this.hSP);
        sb.append(this.mThreadType);
        sb.append(this.hSS);
        sb.append(this.hST);
        sb.append(this.hSU);
        if (this.hSY != null) {
            sb.append(this.hSY);
        }
        return sb.toString();
    }

    public String bUv() {
        return this.hSP;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.hSw;
    }

    public String bWx() {
        return this.hSx;
    }

    public String bWy() {
        return this.hSu;
    }

    public boolean getHostMode() {
        return this.hSz;
    }

    public boolean bWz() {
        return bXn();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bWA() {
        return this.hSJ;
    }

    public boolean bWB() {
        return this.hSD;
    }

    public boolean bWC() {
        return this.hSK;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bWD() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bfV() {
        return this.hSE;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void pZ(int i) {
        this.hSE = i;
    }

    public boolean bWE() {
        return this.gZA;
    }

    public boolean bWF() {
        if (this.hSQ == null) {
            return false;
        }
        return this.hSQ.isValid();
    }

    public String aeL() {
        if (this.hSQ == null || !this.hSQ.aaF()) {
            return null;
        }
        return this.hSQ.aaE();
    }

    public boolean xY(int i) {
        this.hSG = i;
        if (this.hSG > this.hSQ.getPage().adr()) {
            this.hSG = this.hSQ.getPage().adr();
        }
        if (this.hSG < 1) {
            this.hSG = 1;
        }
        if (this.hSu == null) {
            return false;
        }
        return ya(5);
    }

    public void xZ(int i) {
        this.hSG = i;
        this.hSH = i;
        this.hSI = i;
    }

    public void b(com.baidu.tbadk.core.data.an anVar) {
        if (anVar == null) {
            xZ(1);
            return;
        }
        if (this.hSH < anVar.adu()) {
            this.hSH = anVar.adu();
        }
        if (this.hSI > anVar.adu()) {
            this.hSI = anVar.adu();
        }
        this.eKw = anVar.adr();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.hSQ;
    }

    public com.baidu.tieba.pb.data.d bWG() {
        if (this.hSQ == null) {
            return this.hSQ;
        }
        if (!bWH() && this.hTD != null) {
            this.hSQ.b(this.hTD);
        }
        return this.hSQ;
    }

    private boolean bWH() {
        return (this.hSQ.bTN() == null || this.hSQ.bTN().cqn() == null || this.hSQ.bTN().cqn().goods != null || this.hSQ.bTN().cqn().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.an getPageData() {
        if (this.hSQ == null) {
            return null;
        }
        return this.hSQ.getPage();
    }

    public boolean bWI() {
        if (bXn() && this.hSQ.getPage().adw() == 0) {
            oG(true);
            return true;
        }
        return false;
    }

    public void Cn(String str) {
        if (!StringUtils.isNull(str)) {
            this.hSu = str;
            this.hSw = null;
            this.hSz = false;
            this.hSB = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hSu == null) {
            return false;
        }
        cancelLoadData();
        if (this.fao == null) {
            this.fao = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.fao.start();
        }
        boolean ya = ya(3);
        if (this.opType != null) {
            this.opType = null;
            this.hSX = null;
            this.opUrl = null;
            return ya;
        }
        return ya;
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
        if (this.hTt != null) {
            this.hTt.cancelLoadData();
        }
        if (this.hTu != null) {
            this.hTu.cancelLoadData();
        }
        bgZ();
    }

    private void bgZ() {
        if (this.fao != null) {
            this.fao.destory();
            this.fao = null;
        }
    }

    public boolean auR() {
        return (this.hSw == null || this.hSw.equals("0") || this.hSw.length() == 0) ? LoadData() : bWN();
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
                this.hTt.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.hTt.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.hTu == null) {
                this.hTu = new GetSugMatchWordsModel(this.cXM.getPageContext());
            }
            this.hTu.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0311 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0319 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0328 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x035e A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x036d A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0392 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean ya(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        yb(i);
        final com.baidu.tieba.pb.data.d pbData = aj.bXI().getPbData();
        if (pbData != null && pbData.bTy() != null) {
            pbData.bTy().hh(0);
            this.hSB = aj.bXI().bWz();
            this.hSz = aj.bXI().bXN();
            this.hSD = aj.bXI().bXO();
            this.hTy = aj.bXI().bXM();
            this.hTz = aj.bXI().bXL();
            this.hTA = aj.bXI().bXK();
            this.hTv = this.hSz;
            if (this.hSz || this.isFromMark) {
                this.hTb = false;
            }
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.7
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.hTf) {
            a(bWS(), true, this.hSw, 3);
        }
        if (i == 3 && !this.hTf) {
            if (this.isFromMark) {
                a(bWS(), true, this.hSw, 3);
            } else {
                a(bWS(), false, this.hSw, 3);
            }
        }
        this.hTf = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.hTD == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.cse);
        if (this.hSz || this.isFromMark) {
            this.hTb = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.hSu == null || this.hSu.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.e(this.hSu, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.ar.ajw().ajy() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.hSB) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.hSz) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.hSO) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.hSN));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.hTb) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.f(this.hSX, 0));
            pbPageRequestMessage.setOpMessageID(this.hSN);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bTA = this.hSQ.bTA();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hSI - 1));
                        if (this.hSI - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.hSL) {
                                if (bTA != null && bTA.size() > 0) {
                                    size = bTA.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bTA.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.hSw = postData.getId();
                                            if (StringUtils.isNull(this.hSw)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.hSH + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.hSw == null && this.hSw.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.e(this.hSw, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hSH + 1));
                        if (this.hSH >= this.eKw) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bTA != null) {
                                size = bTA.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.hSw == null) {
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
                if (bTA != null) {
                }
                if (this.hSw == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bTA != null && bTA.size() > 0 && bTA.get(0) != null) {
                    this.hSw = bTA.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bXn()) {
                        if (this.hSI - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.hSI - 1));
                        }
                    } else if (this.hSH < this.eKw) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hSH + 1));
                    }
                }
                if (this.hSw != null && this.hSw.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.e(this.hSw, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.hSz) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bXn()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.eKw > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eKw));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.e(this.hSw, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.hSG));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.hTv && !this.hSz) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.e(this.hSw, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.hSz) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.hTj);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.e(this.hTx, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.hTv = this.hSz;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bWS());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.hTw));
        pbPageRequestMessage.setIsSubPostDataReverse(this.hTi);
        pbPageRequestMessage.setFromSmartFrs(this.hTl ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.hSy);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.hSu);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bUu() {
        switch (bXh()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bTy() == null || !getPbData().bTy().afU();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bUv()) && com.baidu.tieba.recapp.r.ciJ().ciD() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.ciJ().ciD().ax(bUv(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.ciJ().ciD().ay(bUv(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bUv()) && com.baidu.tieba.recapp.r.ciJ().ciD() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.ciJ().ciD().ay(bUv(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.ciJ().ciD().ax(bUv(), true));
        }
    }

    protected void yb(int i) {
        boolean z = false;
        yg(i);
        ArrayList<PostData> bTA = this.hSQ.bTA();
        this.hTe = false;
        if (i == 1) {
            boolean z2 = false;
            while (bTA.size() + 30 > com.baidu.tbadk.data.d.arG()) {
                bTA.remove(0);
                z2 = true;
            }
            if (z2) {
                this.hSQ.getPage().he(1);
                if (this.hSW != null) {
                    this.hSW.e(this.hSQ);
                }
            }
            this.fOn = System.currentTimeMillis();
            this.hTe = true;
        } else if (i == 2) {
            while (bTA.size() + 30 > com.baidu.tbadk.data.d.arG()) {
                bTA.remove(bTA.size() - 1);
                z = true;
            }
            if (z) {
                this.hSQ.getPage().hd(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.hTm = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            h(dVar2);
        }
        g(dVar2);
        if (this.hTD != null && this.hTD.aEw()) {
            TiebaStatic.log(com.baidu.tieba.q.a.b("a005", "common_fill", true, 1));
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bTN() != null && dVar.bTN().cqn() != null && dVar.bTN().cqn().goods != null && dVar.bTN().aEw() && dVar.bTN().cqn().goods.goods_style != 1001) {
            this.hTD = dVar.bTN();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m bWJ() {
        return this.hTD;
    }

    public void bWK() {
        this.hTD = null;
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

    protected void h(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            if (this.hSU || this.hSS || this.hST) {
                dVar = j(dVar);
            }
            i(dVar);
        }
    }

    protected void i(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String k = k(dVar);
            for (int i = 0; i < dVar.bTA().size(); i++) {
                PostData postData = dVar.bTA().get(i);
                for (int i2 = 0; i2 < postData.cqw().size(); i2++) {
                    postData.cqw().get(i2).a(this.cXM.getPageContext(), k.equals(postData.cqw().get(i2).aeC().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.m bTJ = dVar.bTJ();
            if (bTJ != null && !com.baidu.tbadk.core.util.v.aa(bTJ.hLr)) {
                for (PostData postData2 : bTJ.hLr) {
                    for (int i3 = 0; i3 < postData2.cqw().size(); i3++) {
                        postData2.cqw().get(i3).a(this.cXM.getPageContext(), k.equals(postData2.cqw().get(i3).aeC().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String k = k(dVar);
            com.baidu.tieba.pb.data.m bTJ = dVar.bTJ();
            if (bTJ != null && !com.baidu.tbadk.core.util.v.aa(bTJ.hLr)) {
                for (PostData postData : bTJ.hLr.subList(i, bTJ.hLr.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cqw().size()) {
                            postData.cqw().get(i3).a(this.cXM.getPageContext(), k.equals(postData.cqw().get(i3).aeC().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.d j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null) {
            return null;
        }
        bh bTy = dVar.bTy();
        bTy.hm(this.mIsGood);
        bTy.hl(this.hSE);
        if (this.hSF > 0) {
            bTy.ar(this.hSF);
            return dVar;
        }
        return dVar;
    }

    protected String k(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bTy() != null && dVar.bTy().aeC() != null) {
            str = dVar.bTy().aeC().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bWL() {
        if (this.hSQ == null || this.hSQ.bTy() == null || this.hSQ.bTy().aeC() == null) {
            return null;
        }
        return this.hSQ.bTy().aeC();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.hTk = z3;
        this.hSR = i;
        if (this.fao != null && !z3) {
            this.fao.a(z2, z4, i2, str, i3, j, j2);
            this.fao = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bUv()) && com.baidu.tieba.recapp.r.ciJ().ciD() != null) {
            com.baidu.tieba.recapp.r.ciJ().ciD().g(bUv(), yc(bWU()), true);
        }
        if (dVar == null || (this.hSG == 1 && i == 5 && dVar.bTA() != null && dVar.bTA().size() < 1)) {
            if (this.hSW != null) {
                this.hSB = this.hSA;
                if (i2 != 350006) {
                    this.mSortType = this.hSC;
                }
                this.hSW.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.hSA = this.hSB;
            if (i != 8) {
                this.hSC = this.mSortType;
                this.mSortType = dVar.hKI;
            }
            if (dVar.hKH != null && dVar.hKH.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.cXM.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                dVar.hKH = new ArrayList();
                dVar.hKH.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.cXM.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                dVar.hKH.add(builder2.build(false));
                this.mSortType = this.hSC;
                dVar.hKI = this.mSortType;
            }
            this.hSO = false;
            if (dVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(dVar.getPage());
            }
            this.eKw = this.eKw < 1 ? 1 : this.eKw;
            ArrayList<PostData> bTA = this.hSQ.bTA();
            switch (i) {
                case 1:
                    this.hSQ.a(dVar.getPage(), 1);
                    d(dVar, bTA);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bTA() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bTA().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bTA, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bTA(), com.baidu.tbadk.core.util.v.Z(dVar.bTA()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bTA().remove(postData2);
                            i6 = size - 1;
                        }
                        bTA.addAll(0, dVar.bTA());
                    }
                    this.hSQ.a(dVar.getPage(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.getPage() != null) {
                        dVar.getPage().hb(dVar.getPage().adr());
                    }
                    l(dVar);
                    if (!z3 && this.mThreadType != 33 && bXn()) {
                        bWM();
                        i5 = 0;
                        break;
                    }
                    i5 = 0;
                    break;
                case 4:
                    l(dVar);
                    i5 = 0;
                    break;
                case 5:
                    l(dVar);
                    i5 = 0;
                    break;
                case 6:
                    l(dVar);
                    i5 = 0;
                    break;
                case 7:
                    l(dVar);
                    i5 = 0;
                    break;
                case 8:
                    if (dVar != null && !com.baidu.tbadk.core.util.v.aa(dVar.bTA()) && this.hSQ != null && (!this.hSz || k(dVar).equals(dVar.bTA().get(0).aeC().getUserId()))) {
                        if (this.hSQ.getPage().adw() == 0) {
                            this.hSQ.getPage().hd(1);
                        }
                        bXi();
                        this.hTy = dVar.bTA().get(0);
                        if (bXn()) {
                            if (this.hSQ.bTA().size() - this.hTA >= 3) {
                                this.hTz = new PostData();
                                this.hTz.jjb = true;
                                this.hTz.setPostType(53);
                                this.hSQ.bTA().add(this.hTz);
                            }
                            this.hSQ.bTA().add(this.hTy);
                            i4 = this.hSQ.bTA().size() - 1;
                        } else {
                            if (this.hTA - this.hTB >= 3) {
                                this.hTz = new PostData();
                                this.hTz.jjb = false;
                                this.hTz.setPostType(53);
                                this.hSQ.bTA().add(0, this.hTz);
                            }
                            this.hSQ.bTA().add(0, this.hTy);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.bc(com.baidu.tbadk.core.sharedPref.b.ahU().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.hTy.jjn = this.hSQ.bTX();
                            com.baidu.tbadk.core.sharedPref.b.ahU().putLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        }
                        i5 = i4;
                        break;
                    }
                    i5 = 0;
                    break;
                default:
                    i5 = 0;
                    break;
            }
            if (this.hSQ != null && this.hSQ.bTy() != null) {
                PraiseData aeo = this.hSQ.bTy().aeo();
                if (this.hTH != null && !aeo.isPriaseDataValid()) {
                    this.hSQ.bTy().a(this.hTH);
                } else {
                    this.hTH = this.hSQ.bTy().aeo();
                    this.hTH.setPostId(this.hSQ.bTy().aeS());
                }
                if (dVar.getPage() != null && dVar.getPage().adu() == 1 && dVar.bTy() != null && dVar.bTy().aeN() != null && dVar.bTy().aeN().size() > 0) {
                    this.hSQ.bTy().q(dVar.bTy().aeN());
                }
                this.hSQ.bTy().hj(dVar.bTy().aet());
                this.hSQ.bTy().hf(dVar.bTy().getAnchorLevel());
                this.hSQ.bTy().hh(dVar.bTy().aek());
                if (this.mThreadType == 33) {
                    this.hSQ.bTy().aeC().setHadConcerned(dVar.bTy().aeC().hadConcerned());
                }
                if (dVar != null && dVar.bTy() != null) {
                    this.hSQ.bTy().ho(dVar.bTy().aeR());
                }
            }
            if (this.hSQ != null && this.hSQ.getUserData() != null && dVar.getUserData() != null) {
                this.hSQ.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.hSQ.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.getPage() != null && dVar.getPage().adu() == 1 && dVar.bTI() != null) {
                this.hSQ.d(dVar.bTI());
            }
            if (this.hTk) {
                if (this.hSQ.bTy() != null && this.hSQ.bTy().aeC() != null && this.hSQ.bTA() != null && com.baidu.tbadk.core.util.v.c(this.hSQ.bTA(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.hSQ.bTA(), 0);
                    MetaData aeC = this.hSQ.bTy().aeC();
                    if (postData3.aeC() != null && postData3.aeC().getGodUserData() != null) {
                        if (this.hSZ != -1) {
                            aeC.setFansNum(this.hSZ);
                            postData3.aeC().setFansNum(this.hSZ);
                        }
                        if (this.hTa != -1) {
                            aeC.getGodUserData().setIsLike(this.hTa == 1);
                            postData3.aeC().getGodUserData().setIsLike(this.hTa == 1);
                            aeC.getGodUserData().setIsFromNetWork(false);
                            postData3.aeC().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.hSQ.hKG = -1;
                this.hSQ.hKF = -1;
            }
            if (this.hSW != null) {
                this.hSW.a(true, getErrorCode(), i, i5, this.hSQ, this.mErrorString, 1);
            }
        }
        if (this.hSQ != null && this.hSQ.bTy() != null && this.hSQ.getForum() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.cXM.getPageContext();
            historyMessage.threadId = getPbData().bTy().getId();
            if (this.mIsShareThread && getPbData().bTy().bMt != null) {
                historyMessage.threadName = getPbData().bTy().bMt.showText;
            } else {
                historyMessage.threadName = getPbData().bTy().getTitle();
            }
            if (this.mIsShareThread && !bUu()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bWz();
            historyMessage.threadType = getPbData().bTy().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String aw;
        if (arrayList != null && dVar.bTA() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bTA(), 0);
            if (postData != null && (aw = aw(arrayList)) != null && aw.equals(postData.getId())) {
                dVar.bTA().remove(postData);
            }
            arrayList.addAll(dVar.bTA());
        }
    }

    private int yc(int i) {
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

    private String aw(ArrayList<PostData> arrayList) {
        int Z = com.baidu.tbadk.core.util.v.Z(arrayList);
        if (Z <= 0) {
            return null;
        }
        for (int i = Z - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(com.baidu.tieba.pb.data.d dVar) {
        dVar.Ck(this.hSQ.bTQ());
        this.hSQ = dVar;
        xZ(dVar.getPage().adu());
    }

    private void bWM() {
        if (this.hSQ != null && this.hSQ.bTA() != null && this.hSQ.bTP() != null) {
            ArrayList<PostData> bTA = this.hSQ.bTA();
            com.baidu.tieba.pb.data.a bTP = this.hSQ.bTP();
            int bTv = bTP.bTv();
            if (bTv > 0) {
                if (bTv <= bTA.size()) {
                    bTA.add(bTv, bTP);
                } else {
                    bTA.add(bTP);
                }
            }
        }
    }

    public boolean bWN() {
        if (this.hSu == null || this.hSw == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return ya(4);
        }
        return ya(6);
    }

    public boolean oG(boolean z) {
        if (this.hSu == null || this.hSQ == null) {
            return false;
        }
        if (z || this.hSQ.getPage().adw() != 0) {
            return ya(1);
        }
        return false;
    }

    public boolean oH(boolean z) {
        if (this.hSu == null || this.hSQ == null) {
            return false;
        }
        if ((z || this.hSQ.getPage().adx() != 0) && this.hSQ.bTA() != null && this.hSQ.bTA().size() >= 1) {
            return ya(2);
        }
        return false;
    }

    public boolean Ct(String str) {
        this.hSz = !this.hSz;
        this.hSw = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (ya(6)) {
            return true;
        }
        this.hSz = this.hSz ? false : true;
        return false;
    }

    public boolean u(boolean z, String str) {
        if (this.hSz == z) {
            return false;
        }
        this.hSz = z;
        this.hSw = str;
        if (this.mSortType == 2) {
            this.hSw = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (ya(6)) {
            return true;
        }
        this.hSz = z ? false : true;
        return false;
    }

    public boolean yd(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.hSA = this.hSB;
        this.hSC = this.mSortType;
        this.mSortType = i;
        this.hSB = !this.hSB;
        if (i == 2 && this.isFromMark) {
            this.hSw = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.hSB = this.hSB ? false : true;
            this.mSortType = this.hSC;
            return false;
        }
        return true;
    }

    public boolean bWO() {
        return bXn();
    }

    public int bWP() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.hSQ == null || this.hSQ.getForum() == null || this.hSQ.bTy() == null) ? false : true;
    }

    public boolean aaF() {
        if (this.hSQ == null) {
            return false;
        }
        return this.hSQ.aaF();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData qx(String str) {
        if (this.hSQ == null || this.hSQ.bTy() == null || this.hSQ.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.hSQ.bTy().afU()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.hSQ.getForum().getId());
            writeData.setForumName(this.hSQ.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.hTw);
        writeData.setThreadId(this.hSu);
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

    public MarkData ye(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.hSQ == null) {
            return null;
        }
        ArrayList<PostData> bTA = this.hSQ.bTA();
        if (com.baidu.tbadk.core.util.v.aa(bTA)) {
            return null;
        }
        if (bTA.size() > 0 && i >= bTA.size()) {
            i = bTA.size() - 1;
        }
        return j(bTA.get(i));
    }

    public MarkData bWQ() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hSu);
        markData.setPostId(this.hSQ.aaE());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hSz);
        markData.setSequence(Boolean.valueOf(bXn()));
        markData.setId(this.hSu);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hSu);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hSz);
        markData.setSequence(Boolean.valueOf(bXn()));
        markData.setId(this.hSu);
        markData.setFloor(postData.cqz());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void bWR() {
        g.bWi().as(bWS(), this.isFromMark);
    }

    private String bWS() {
        String str = this.hSu;
        if (this.hSz) {
            str = str + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void oI(boolean z) {
        if (this.hSQ != null) {
            this.hSQ.dx(z);
        }
    }

    public void oJ(boolean z) {
        this.hTb = z;
    }

    public boolean bWT() {
        return this.hTb;
    }

    public void a(a aVar) {
        this.hSW = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String asI() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean asH() {
        return auR();
    }

    public boolean Cu(String str) {
        if (getPbData() == null || getPbData().bTy() == null || getPbData().bTy().aeC() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bTy().aeC().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int bWU() {
        return this.mRequestType;
    }

    public void bWV() {
        String bWS = bWS();
        g.bWi().as(bWS, false);
        g.bWi().as(bWS, true);
    }

    public void bWW() {
        if ("personalize_page".equals(this.mStType)) {
            this.hTh = System.currentTimeMillis() / 1000;
        }
    }

    public void bWX() {
        if ("personalize_page".equals(this.mStType) && this.hSQ != null && this.hTh != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").bT("fid", this.hSQ.getForumId()).bT("tid", this.hSu).bT("obj_duration", String.valueOf(currentTimeMillis - this.hTh)).bT("obj_param3", String.valueOf(currentTimeMillis)));
            this.hTh = 0L;
        }
    }

    public boolean bWY() {
        return this.hTk;
    }

    public int getErrorNo() {
        return this.hTm;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bWZ() {
        return this.hTo;
    }

    public m bXa() {
        return this.hTp;
    }

    public z bXb() {
        return this.hTq;
    }

    public CheckRealNameModel bXc() {
        return this.ebh;
    }

    public AddExperiencedModel bXd() {
        return this.hTs;
    }

    public String bXe() {
        return this.hTg;
    }

    public void Cv(String str) {
        this.hTg = str;
    }

    public boolean bXf() {
        return this.hTl;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hSQ != null && this.hSQ.bTA() != null && this.hSQ.bTA().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hSQ.bTA().size();
                for (int i = 0; i < size; i++) {
                    if (this.hSQ.bTA().get(i) != null && this.hSQ.bTA().get(i).aeC() != null && currentAccount.equals(this.hSQ.bTA().get(i).aeC().getUserId()) && this.hSQ.bTA().get(i).aeC().getPendantData() != null) {
                        this.hSQ.bTA().get(i).aeC().getPendantData().mx(lVar.acZ());
                        this.hSQ.bTA().get(i).aeC().getPendantData().bk(lVar.arQ());
                    }
                }
            }
        }
    }

    public String bXg() {
        return this.hTr;
    }

    public int bXh() {
        return this.hTw;
    }

    public void yf(int i) {
        this.hTw = i;
    }

    public void Cw(String str) {
        if ((!this.hSz || Cu(TbadkCoreApplication.getCurrentAccount())) && this.hSQ.bTA() != null) {
            this.hSQ.getPage().hd(1);
            if (this.hSQ.getPage().adw() == 0) {
                this.hSQ.getPage().hd(1);
            }
            this.hTx = str;
            ya(8);
        }
    }

    private void yg(int i) {
        if (i != 8) {
            this.hTx = "";
            if (this.hTy != null) {
                if (i == 1 && !this.hSB && !com.baidu.tbadk.core.util.v.aa(getPbData().bTA())) {
                    getPbData().bTA().remove(this.hTy);
                    if (this.hTz != null) {
                        getPbData().bTA().remove(this.hTz);
                    }
                    getPbData().bTA().add(0, this.hTy);
                } else {
                    getPbData().bTA().remove(this.hTy);
                    if (this.hTz != null) {
                        getPbData().bTA().remove(this.hTz);
                    }
                }
            }
            this.hTz = null;
        }
    }

    public void bXi() {
        if (this.hSQ != null && !com.baidu.tbadk.core.util.v.aa(this.hSQ.bTA())) {
            if (this.hTz != null) {
                this.hSQ.bTA().remove(this.hTz);
                this.hTz = null;
            }
            if (this.hTy != null) {
                this.hSQ.bTA().remove(this.hTy);
                this.hTy = null;
            }
        }
    }

    public void ch(int i, int i2) {
        this.hTA = i;
        this.hTB = i2;
    }

    public PostData bXj() {
        return this.hTy;
    }

    public PostData bXk() {
        return this.hTz;
    }

    public int bXl() {
        return this.hTA;
    }

    public String bXm() {
        return this.hTC;
    }

    public void Cx(String str) {
        this.hTC = str;
    }

    private boolean bXn() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean bXo() {
        return this.hTw == 13 || this.hTw == 12;
    }
}
