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
    private BaseActivity cWT;
    private final CheckRealNameModel dZx;
    private int eIN;
    private com.baidu.tieba.tbadkCore.d.b eYI;
    private long fMy;
    private boolean gXG;
    private String hQA;
    private boolean hQB;
    private boolean hQC;
    private boolean hQD;
    private boolean hQE;
    private int hQF;
    private boolean hQG;
    private int hQH;
    private long hQI;
    private int hQJ;
    private int hQK;
    private int hQL;
    private boolean hQM;
    private boolean hQN;
    private boolean hQO;
    private boolean hQP;
    private long hQQ;
    private boolean hQR;
    private String hQS;
    protected com.baidu.tieba.pb.data.d hQT;
    private int hQU;
    private boolean hQV;
    private boolean hQW;
    private boolean hQX;
    private boolean hQY;
    private a hQZ;
    protected String hQx;
    private String hQy;
    private String hQz;
    private String hRA;
    private PostData hRB;
    private PostData hRC;
    private int hRD;
    private int hRE;
    private String hRF;
    private com.baidu.tieba.tbadkCore.data.m hRG;
    private CustomMessageListener hRH;
    private CustomMessageListener hRI;
    private com.baidu.adp.framework.listener.a hRJ;
    private PraiseData hRK;
    private String hRa;
    private String hRb;
    private int hRc;
    private int hRd;
    private boolean hRe;
    private boolean hRf;
    private boolean hRg;
    private boolean hRh;
    private boolean hRi;
    private String hRj;
    private long hRk;
    private boolean hRl;
    private int hRm;
    private boolean hRn;
    private boolean hRo;
    private int hRp;
    private final x hRq;
    private final h hRr;
    private final m hRs;
    private final z hRt;
    private String hRu;
    private final AddExperiencedModel hRv;
    private SuggestEmotionModel hRw;
    private GetSugMatchWordsModel hRx;
    private boolean hRy;
    private int hRz;
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
    private static final int hQw = com.baidu.tbadk.data.d.aru() / 30;
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
        this.hQx = null;
        this.hQy = null;
        this.hQz = null;
        this.mForumId = null;
        this.hQA = null;
        this.hQB = false;
        this.hQC = false;
        this.hQD = true;
        this.hQE = true;
        this.mSortType = 0;
        this.hQF = 0;
        this.hQG = false;
        this.mIsGood = 0;
        this.hQH = 0;
        this.hQI = 0L;
        this.hQJ = 1;
        this.hQK = 1;
        this.hQL = 1;
        this.eIN = 1;
        this.isAd = false;
        this.gXG = false;
        this.hQM = false;
        this.hQN = false;
        this.isFromMark = false;
        this.hQO = false;
        this.hQP = false;
        this.hQQ = 0L;
        this.hQR = false;
        this.hQS = null;
        this.hQT = null;
        this.isLoading = false;
        this.hQV = false;
        this.hQW = false;
        this.hQX = false;
        this.hQY = false;
        this.mLocate = null;
        this.mContext = null;
        this.hQZ = null;
        this.opType = null;
        this.opUrl = null;
        this.hRa = null;
        this.hRb = null;
        this.hRc = -1;
        this.hRd = -1;
        this.eYI = null;
        this.hRf = false;
        this.hRg = false;
        this.postID = null;
        this.hRj = null;
        this.hRk = 0L;
        this.hRl = false;
        this.hRm = -1;
        this.hRo = false;
        this.hRy = false;
        this.hRz = 0;
        this.hRH = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.hRi = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null && pbData.hIN == null) {
                    PbModel.this.l(pbData);
                    PbModel.this.h(pbData);
                    if (pbData.bSL() != null) {
                        pbData.bSL().hg(0);
                    }
                    if (PbModel.this.hQZ != null && pbData != null) {
                        com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.hQZ.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.hRI = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.hRJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.kc()) {
                        PbModel.this.cWT.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.hRf || !PbModel.this.hRg) {
                        if (!PbModel.this.hRf) {
                            PbModel.this.hRf = true;
                        } else {
                            PbModel.this.hRg = true;
                        }
                        if (PbModel.this.hQZ != null) {
                            PbModel.this.hQZ.a(PbModel.this.bVI(), z, responsedMessage, PbModel.this.hRh, System.currentTimeMillis() - PbModel.this.fMy);
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
                    if (PbModel.this.hQT != null && PbModel.this.hQT.bSK() != null && PbModel.this.hQT.bSK().getForumId() != null && PbModel.this.hQT.bSK().getForumId().equals(valueOf)) {
                        PbModel.this.hQT.bSK().setIsLike(false);
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
                    if (PbModel.this.hQT != null && PbModel.this.hQT.bSK() != null && PbModel.this.hQT.bSK().getForumId() != null && PbModel.this.hQT.bSK().getForumId().equals(valueOf)) {
                        PbModel.this.hQT.bSK().setIsLike(true);
                    }
                }
            }
        };
        this.hRK = null;
        registerListener(this.hRH);
        registerListener(this.hRJ);
        registerListener(this.hRI);
        registerListener(this.mLikeForumListener);
        registerListener(this.mUnlikeForumListener);
        this.hQT = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.cWT = baseActivity;
        this.hRq = new x(this, this.cWT);
        this.hRr = new h(this, this.cWT);
        this.hRs = new m(this, this.cWT);
        this.hRt = new z(this, this.cWT);
        this.dZx = new CheckRealNameModel(this.cWT.getPageContext());
        this.hRw = new SuggestEmotionModel();
        this.hRv = new AddExperiencedModel(this.cWT.getPageContext());
    }

    protected int bVI() {
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
            this.hQx = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.m(data)) {
                com.baidu.tbadk.BdToken.f.Zw().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.6
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.bzm) instanceof String)) {
                            PbModel.this.hQx = (String) hashMap.get(com.baidu.tbadk.BdToken.f.bzm);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.hQx)) {
                this.hQx = this.hRq.au(intent);
                if (StringUtils.isNull(this.hQx) && intent.getData() != null) {
                    this.hQx = data.getQueryParameter("thread_id");
                }
            }
            this.hRz = intent.getIntExtra("key_start_from", 0);
            if (this.hRz == 0) {
                this.hRz = this.hRq.hRQ;
            }
            this.hQz = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.hQy = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.hQB = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.hQC = intent.getBooleanExtra("host_only", false);
            this.hQE = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.avY().alQ() ? 2 : 0);
            if (this.mSortType == 2) {
                this.hQz = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.hQH = intent.getIntExtra("is_top", 0);
            this.hQI = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.hQO = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.hQP = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.gXG = intent.getBooleanExtra("is_sub_pb", false);
            this.hQR = intent.getBooleanExtra("is_pv", false);
            this.hQQ = intent.getLongExtra("msg_id", 0L);
            this.hQS = intent.getStringExtra("from_forum_name");
            this.hRb = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.hRa = intent.getStringExtra("op_stat");
            this.hQV = intent.getBooleanExtra("is_from_thread_config", false);
            this.hQW = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.hQX = intent.getBooleanExtra("is_from_my_god_config", false);
            this.hRd = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.hRc = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.hQM = intent.getBooleanExtra("from_frs", false);
            this.hQN = intent.getBooleanExtra("from_maintab", false);
            this.hRo = intent.getBooleanExtra("from_smart_frs", false);
            this.hQY = intent.getBooleanExtra("from_hottopic", false);
            this.hRu = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.hQA = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.hRz = bundle.getInt("key_start_from", 0);
        this.hQx = bundle.getString("thread_id");
        this.hQz = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.hQy = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.hQB = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.hQC = bundle.getBoolean("host_only", false);
        this.hQE = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.hQH = bundle.getInt("is_top", 0);
        this.hQI = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.hQP = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.gXG = bundle.getBoolean("is_sub_pb", false);
        this.hQR = bundle.getBoolean("is_pv", false);
        this.hQQ = bundle.getLong("msg_id", 0L);
        this.hQS = bundle.getString("from_forum_name");
        this.hRb = bundle.getString("extra_pb_cache_key");
        this.hQV = bundle.getBoolean("is_from_thread_config", false);
        this.hQW = bundle.getBoolean("is_from_interview_live_config", false);
        this.hQX = bundle.getBoolean("is_from_my_god_config", false);
        this.hRd = bundle.getInt("extra_pb_is_attention_key", -1);
        this.hRc = bundle.getInt("extra_pb_funs_count_key", -1);
        this.hQM = bundle.getBoolean("from_frs", false);
        this.hQN = bundle.getBoolean("from_maintab", false);
        this.hRo = bundle.getBoolean("from_smart_frs", false);
        this.hQY = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.hQA = bundle.getString("high_light_post_id");
    }

    public void ab(Bundle bundle) {
        bundle.putString("thread_id", this.hQx);
        bundle.putString("post_id", this.hQz);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.hRz);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.hQB);
        bundle.putBoolean("host_only", this.hQC);
        bundle.putBoolean("squence", this.hQE);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.hQH);
        bundle.putLong("thread_time", this.hQI);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.hQP);
        bundle.putBoolean("is_sub_pb", this.gXG);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.hQR);
        bundle.putLong("msg_id", this.hQQ);
        bundle.putString("extra_pb_cache_key", this.hRb);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.hQV);
        bundle.putBoolean("is_from_interview_live_config", this.hQW);
        bundle.putBoolean("is_from_my_god_config", this.hQX);
        bundle.putInt("extra_pb_is_attention_key", this.hRd);
        bundle.putInt("extra_pb_funs_count_key", this.hRc);
        bundle.putBoolean("from_frs", this.hQM);
        bundle.putBoolean("from_maintab", this.hQN);
        bundle.putBoolean("from_smart_frs", this.hRo);
        bundle.putBoolean("from_hottopic", this.hQY);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.hQA);
    }

    public String bVJ() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.hQx);
        if (!this.hQP) {
            sb.append(this.hQz);
        }
        sb.append(this.hQC);
        sb.append(this.hQE);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.hQH);
        sb.append(this.hQI);
        sb.append(this.hQM);
        sb.append(this.hQN);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.gXG);
        sb.append(this.hQR);
        sb.append(this.hQQ);
        sb.append(this.hQS);
        sb.append(this.mThreadType);
        sb.append(this.hQV);
        sb.append(this.hQW);
        sb.append(this.hQX);
        if (this.hRb != null) {
            sb.append(this.hRb);
        }
        return sb.toString();
    }

    public String bTI() {
        return this.hQS;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.hQz;
    }

    public String bVK() {
        return this.hQA;
    }

    public String bVL() {
        return this.hQx;
    }

    public boolean getHostMode() {
        return this.hQC;
    }

    public boolean bVM() {
        return bWA();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bVN() {
        return this.hQM;
    }

    public boolean bVO() {
        return this.hQG;
    }

    public boolean bVP() {
        return this.hQN;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bVQ() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bfr() {
        return this.hQH;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void pV(int i) {
        this.hQH = i;
    }

    public boolean bVR() {
        return this.gXG;
    }

    public boolean bVS() {
        if (this.hQT == null) {
            return false;
        }
        return this.hQT.isValid();
    }

    public String aeH() {
        if (this.hQT == null || !this.hQT.aaB()) {
            return null;
        }
        return this.hQT.aaA();
    }

    public boolean xV(int i) {
        this.hQJ = i;
        if (this.hQJ > this.hQT.getPage().adn()) {
            this.hQJ = this.hQT.getPage().adn();
        }
        if (this.hQJ < 1) {
            this.hQJ = 1;
        }
        if (this.hQx == null) {
            return false;
        }
        return xX(5);
    }

    public void xW(int i) {
        this.hQJ = i;
        this.hQK = i;
        this.hQL = i;
    }

    public void b(com.baidu.tbadk.core.data.an anVar) {
        if (anVar == null) {
            xW(1);
            return;
        }
        if (this.hQK < anVar.adq()) {
            this.hQK = anVar.adq();
        }
        if (this.hQL > anVar.adq()) {
            this.hQL = anVar.adq();
        }
        this.eIN = anVar.adn();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.hQT;
    }

    public com.baidu.tieba.pb.data.d bVT() {
        if (this.hQT == null) {
            return this.hQT;
        }
        if (!bVU() && this.hRG != null) {
            this.hQT.b(this.hRG);
        }
        return this.hQT;
    }

    private boolean bVU() {
        return (this.hQT.bTa() == null || this.hQT.bTa().cpz() == null || this.hQT.bTa().cpz().goods != null || this.hQT.bTa().cpz().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.an getPageData() {
        if (this.hQT == null) {
            return null;
        }
        return this.hQT.getPage();
    }

    public boolean bVV() {
        if (bWA() && this.hQT.getPage().ads() == 0) {
            oC(true);
            return true;
        }
        return false;
    }

    public void BO(String str) {
        if (!StringUtils.isNull(str)) {
            this.hQx = str;
            this.hQz = null;
            this.hQC = false;
            this.hQE = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hQx == null) {
            return false;
        }
        cancelLoadData();
        if (this.eYI == null) {
            this.eYI = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.eYI.start();
        }
        boolean xX = xX(3);
        if (this.opType != null) {
            this.opType = null;
            this.hRa = null;
            this.opUrl = null;
            return xX;
        }
        return xX;
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
        if (this.hRw != null) {
            this.hRw.cancelLoadData();
        }
        if (this.hRx != null) {
            this.hRx.cancelLoadData();
        }
        bgt();
    }

    private void bgt() {
        if (this.eYI != null) {
            this.eYI.destory();
            this.eYI = null;
        }
    }

    public boolean auF() {
        return (this.hQz == null || this.hQz.equals("0") || this.hQz.length() == 0) ? LoadData() : bWa();
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
                this.hRw.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.hRw.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.hRx == null) {
                this.hRx = new GetSugMatchWordsModel(this.cWT.getPageContext());
            }
            this.hRx.b(aVar);
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
    public boolean xX(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        xY(i);
        final com.baidu.tieba.pb.data.d pbData = aj.bWV().getPbData();
        if (pbData != null && pbData.bSL() != null) {
            pbData.bSL().hg(0);
            this.hQE = aj.bWV().bVM();
            this.hQC = aj.bWV().bXa();
            this.hQG = aj.bWV().bXb();
            this.hRB = aj.bWV().bWZ();
            this.hRC = aj.bWV().bWY();
            this.hRD = aj.bWV().bWX();
            this.hRy = this.hQC;
            if (this.hQC || this.isFromMark) {
                this.hRe = false;
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
        if (i == 4 && !this.hRi) {
            a(bWf(), true, this.hQz, 3);
        }
        if (i == 3 && !this.hRi) {
            if (this.isFromMark) {
                a(bWf(), true, this.hQz, 3);
            } else {
                a(bWf(), false, this.hQz, 3);
            }
        }
        this.hRi = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.hRG == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.crk);
        if (this.hQC || this.isFromMark) {
            this.hRe = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.hQx == null || this.hQx.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.hQx, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.as.ajq().ajs() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.hQE) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.hQC) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.hQR) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.hQQ));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.hRe) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.f(this.hRa, 0));
            pbPageRequestMessage.setOpMessageID(this.hQQ);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bSN = this.hQT.bSN();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hQL - 1));
                        if (this.hQL - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.hQO) {
                                if (bSN != null && bSN.size() > 0) {
                                    size = bSN.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bSN.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.hQz = postData.getId();
                                            if (StringUtils.isNull(this.hQz)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.hQK + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.hQz == null && this.hQz.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hQz, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hQK + 1));
                        if (this.hQK >= this.eIN) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bSN != null) {
                                size = bSN.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.hQz == null) {
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
                if (bSN != null) {
                }
                if (this.hQz == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bSN != null && bSN.size() > 0 && bSN.get(0) != null) {
                    this.hQz = bSN.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bWA()) {
                        if (this.hQL - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.hQL - 1));
                        }
                    } else if (this.hQK < this.eIN) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hQK + 1));
                    }
                }
                if (this.hQz != null && this.hQz.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hQz, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.hQC) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bWA()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.eIN > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eIN));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hQz, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.hQJ));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.hRy && !this.hQC) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hQz, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.hQC) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.hRm);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hRA, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.hRy = this.hQC;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bWf());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.hRz));
        pbPageRequestMessage.setIsSubPostDataReverse(this.hRl);
        pbPageRequestMessage.setFromSmartFrs(this.hRo ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.hQB);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.hQx);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bTH() {
        switch (bWu()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bSL() == null || !getPbData().bSL().afQ();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bTI()) && com.baidu.tieba.recapp.r.chV().chP() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.chV().chP().ax(bTI(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.chV().chP().ay(bTI(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bTI()) && com.baidu.tieba.recapp.r.chV().chP() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.chV().chP().ay(bTI(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.chV().chP().ax(bTI(), true));
        }
    }

    protected void xY(int i) {
        boolean z = false;
        yd(i);
        ArrayList<PostData> bSN = this.hQT.bSN();
        this.hRh = false;
        if (i == 1) {
            boolean z2 = false;
            while (bSN.size() + 30 > com.baidu.tbadk.data.d.aru()) {
                bSN.remove(0);
                z2 = true;
            }
            if (z2) {
                this.hQT.getPage().hd(1);
                if (this.hQZ != null) {
                    this.hQZ.e(this.hQT);
                }
            }
            this.fMy = System.currentTimeMillis();
            this.hRh = true;
        } else if (i == 2) {
            while (bSN.size() + 30 > com.baidu.tbadk.data.d.aru()) {
                bSN.remove(bSN.size() - 1);
                z = true;
            }
            if (z) {
                this.hQT.getPage().hc(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.hRp = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            h(dVar2);
        }
        g(dVar2);
        if (this.hRG != null && this.hRG.aDS()) {
            TiebaStatic.log(com.baidu.tieba.q.a.b("a005", "common_fill", true, 1));
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bTa() != null && dVar.bTa().cpz() != null && dVar.bTa().cpz().goods != null && dVar.bTa().aDS() && dVar.bTa().cpz().goods.goods_style != 1001) {
            this.hRG = dVar.bTa();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m bVW() {
        return this.hRG;
    }

    public void bVX() {
        this.hRG = null;
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
            if (this.hQX || this.hQV || this.hQW) {
                dVar = j(dVar);
            }
            i(dVar);
        }
    }

    protected void i(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String k = k(dVar);
            for (int i = 0; i < dVar.bSN().size(); i++) {
                PostData postData = dVar.bSN().get(i);
                for (int i2 = 0; i2 < postData.cpI().size(); i2++) {
                    postData.cpI().get(i2).a(this.cWT.getPageContext(), k.equals(postData.cpI().get(i2).aey().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.m bSW = dVar.bSW();
            if (bSW != null && !com.baidu.tbadk.core.util.v.aa(bSW.hJu)) {
                for (PostData postData2 : bSW.hJu) {
                    for (int i3 = 0; i3 < postData2.cpI().size(); i3++) {
                        postData2.cpI().get(i3).a(this.cWT.getPageContext(), k.equals(postData2.cpI().get(i3).aey().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String k = k(dVar);
            com.baidu.tieba.pb.data.m bSW = dVar.bSW();
            if (bSW != null && !com.baidu.tbadk.core.util.v.aa(bSW.hJu)) {
                for (PostData postData : bSW.hJu.subList(i, bSW.hJu.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cpI().size()) {
                            postData.cpI().get(i3).a(this.cWT.getPageContext(), k.equals(postData.cpI().get(i3).aey().getUserId()));
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
        bh bSL = dVar.bSL();
        bSL.hl(this.mIsGood);
        bSL.hk(this.hQH);
        if (this.hQI > 0) {
            bSL.ar(this.hQI);
            return dVar;
        }
        return dVar;
    }

    protected String k(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bSL() != null && dVar.bSL().aey() != null) {
            str = dVar.bSL().aey().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bVY() {
        if (this.hQT == null || this.hQT.bSL() == null || this.hQT.bSL().aey() == null) {
            return null;
        }
        return this.hQT.bSL().aey();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.hRn = z3;
        this.hQU = i;
        if (this.eYI != null && !z3) {
            this.eYI.a(z2, z4, i2, str, i3, j, j2);
            this.eYI = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bTI()) && com.baidu.tieba.recapp.r.chV().chP() != null) {
            com.baidu.tieba.recapp.r.chV().chP().g(bTI(), xZ(bWh()), true);
        }
        if (dVar == null || (this.hQJ == 1 && i == 5 && dVar.bSN() != null && dVar.bSN().size() < 1)) {
            if (this.hQZ != null) {
                this.hQE = this.hQD;
                if (i2 != 350006) {
                    this.mSortType = this.hQF;
                }
                this.hQZ.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.hQD = this.hQE;
            if (i != 8) {
                this.hQF = this.mSortType;
                this.mSortType = dVar.hIM;
            }
            if (dVar.hIL != null && dVar.hIL.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.cWT.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                dVar.hIL = new ArrayList();
                dVar.hIL.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.cWT.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                dVar.hIL.add(builder2.build(false));
                this.mSortType = this.hQF;
                dVar.hIM = this.mSortType;
            }
            this.hQR = false;
            if (dVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(dVar.getPage());
            }
            this.eIN = this.eIN < 1 ? 1 : this.eIN;
            ArrayList<PostData> bSN = this.hQT.bSN();
            switch (i) {
                case 1:
                    this.hQT.a(dVar.getPage(), 1);
                    d(dVar, bSN);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bSN() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bSN().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bSN, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bSN(), com.baidu.tbadk.core.util.v.Z(dVar.bSN()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bSN().remove(postData2);
                            i6 = size - 1;
                        }
                        bSN.addAll(0, dVar.bSN());
                    }
                    this.hQT.a(dVar.getPage(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.getPage() != null) {
                        dVar.getPage().ha(dVar.getPage().adn());
                    }
                    l(dVar);
                    if (!z3 && this.mThreadType != 33 && bWA()) {
                        bVZ();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.aa(dVar.bSN()) && this.hQT != null && (!this.hQC || k(dVar).equals(dVar.bSN().get(0).aey().getUserId()))) {
                        if (this.hQT.getPage().ads() == 0) {
                            this.hQT.getPage().hc(1);
                        }
                        bWv();
                        this.hRB = dVar.bSN().get(0);
                        if (bWA()) {
                            if (this.hQT.bSN().size() - this.hRD >= 3) {
                                this.hRC = new PostData();
                                this.hRC.jgF = true;
                                this.hRC.setPostType(53);
                                this.hQT.bSN().add(this.hRC);
                            }
                            this.hQT.bSN().add(this.hRB);
                            i4 = this.hQT.bSN().size() - 1;
                        } else {
                            if (this.hRD - this.hRE >= 3) {
                                this.hRC = new PostData();
                                this.hRC.jgF = false;
                                this.hRC.setPostType(53);
                                this.hQT.bSN().add(0, this.hRC);
                            }
                            this.hQT.bSN().add(0, this.hRB);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.bc(com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.hRB.jgR = this.hQT.bTk();
                            com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.hQT != null && this.hQT.bSL() != null) {
                PraiseData aek = this.hQT.bSL().aek();
                if (this.hRK != null && !aek.isPriaseDataValid()) {
                    this.hQT.bSL().a(this.hRK);
                } else {
                    this.hRK = this.hQT.bSL().aek();
                    this.hRK.setPostId(this.hQT.bSL().aeO());
                }
                if (dVar.getPage() != null && dVar.getPage().adq() == 1 && dVar.bSL() != null && dVar.bSL().aeJ() != null && dVar.bSL().aeJ().size() > 0) {
                    this.hQT.bSL().q(dVar.bSL().aeJ());
                }
                this.hQT.bSL().hi(dVar.bSL().aep());
                this.hQT.bSL().he(dVar.bSL().getAnchorLevel());
                this.hQT.bSL().hg(dVar.bSL().aeg());
                if (this.mThreadType == 33) {
                    this.hQT.bSL().aey().setHadConcerned(dVar.bSL().aey().hadConcerned());
                }
                if (dVar != null && dVar.bSL() != null) {
                    this.hQT.bSL().hn(dVar.bSL().aeN());
                }
            }
            if (this.hQT != null && this.hQT.getUserData() != null && dVar.getUserData() != null) {
                this.hQT.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.hQT.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.getPage() != null && dVar.getPage().adq() == 1 && dVar.bSV() != null) {
                this.hQT.d(dVar.bSV());
            }
            if (this.hRn) {
                if (this.hQT.bSL() != null && this.hQT.bSL().aey() != null && this.hQT.bSN() != null && com.baidu.tbadk.core.util.v.c(this.hQT.bSN(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.hQT.bSN(), 0);
                    MetaData aey = this.hQT.bSL().aey();
                    if (postData3.aey() != null && postData3.aey().getGodUserData() != null) {
                        if (this.hRc != -1) {
                            aey.setFansNum(this.hRc);
                            postData3.aey().setFansNum(this.hRc);
                        }
                        if (this.hRd != -1) {
                            aey.getGodUserData().setIsLike(this.hRd == 1);
                            postData3.aey().getGodUserData().setIsLike(this.hRd == 1);
                            aey.getGodUserData().setIsFromNetWork(false);
                            postData3.aey().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.hQT.hIK = -1;
                this.hQT.hIJ = -1;
            }
            if (this.hQZ != null) {
                this.hQZ.a(true, getErrorCode(), i, i5, this.hQT, this.mErrorString, 1);
            }
        }
        if (this.hQT != null && this.hQT.bSL() != null && this.hQT.getForum() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.cWT.getPageContext();
            historyMessage.threadId = getPbData().bSL().getId();
            if (this.mIsShareThread && getPbData().bSL().bLV != null) {
                historyMessage.threadName = getPbData().bSL().bLV.showText;
            } else {
                historyMessage.threadName = getPbData().bSL().getTitle();
            }
            if (this.mIsShareThread && !bTH()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bVM();
            historyMessage.threadType = getPbData().bSL().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String aw;
        if (arrayList != null && dVar.bSN() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bSN(), 0);
            if (postData != null && (aw = aw(arrayList)) != null && aw.equals(postData.getId())) {
                dVar.bSN().remove(postData);
            }
            arrayList.addAll(dVar.bSN());
        }
    }

    private int xZ(int i) {
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
        dVar.BL(this.hQT.bTd());
        this.hQT = dVar;
        xW(dVar.getPage().adq());
    }

    private void bVZ() {
        if (this.hQT != null && this.hQT.bSN() != null && this.hQT.bTc() != null) {
            ArrayList<PostData> bSN = this.hQT.bSN();
            com.baidu.tieba.pb.data.a bTc = this.hQT.bTc();
            int bSI = bTc.bSI();
            if (bSI > 0) {
                if (bSI <= bSN.size()) {
                    bSN.add(bSI, bTc);
                } else {
                    bSN.add(bTc);
                }
            }
        }
    }

    public boolean bWa() {
        if (this.hQx == null || this.hQz == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return xX(4);
        }
        return xX(6);
    }

    public boolean oC(boolean z) {
        if (this.hQx == null || this.hQT == null) {
            return false;
        }
        if (z || this.hQT.getPage().ads() != 0) {
            return xX(1);
        }
        return false;
    }

    public boolean oD(boolean z) {
        if (this.hQx == null || this.hQT == null) {
            return false;
        }
        if ((z || this.hQT.getPage().adt() != 0) && this.hQT.bSN() != null && this.hQT.bSN().size() >= 1) {
            return xX(2);
        }
        return false;
    }

    public boolean BU(String str) {
        this.hQC = !this.hQC;
        this.hQz = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (xX(6)) {
            return true;
        }
        this.hQC = this.hQC ? false : true;
        return false;
    }

    public boolean u(boolean z, String str) {
        if (this.hQC == z) {
            return false;
        }
        this.hQC = z;
        this.hQz = str;
        if (this.mSortType == 2) {
            this.hQz = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (xX(6)) {
            return true;
        }
        this.hQC = z ? false : true;
        return false;
    }

    public boolean ya(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.hQD = this.hQE;
        this.hQF = this.mSortType;
        this.mSortType = i;
        this.hQE = !this.hQE;
        if (i == 2 && this.isFromMark) {
            this.hQz = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.hQE = this.hQE ? false : true;
            this.mSortType = this.hQF;
            return false;
        }
        return true;
    }

    public boolean bWb() {
        return bWA();
    }

    public int bWc() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.hQT == null || this.hQT.getForum() == null || this.hQT.bSL() == null) ? false : true;
    }

    public boolean aaB() {
        if (this.hQT == null) {
            return false;
        }
        return this.hQT.aaB();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData qm(String str) {
        if (this.hQT == null || this.hQT.bSL() == null || this.hQT.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.hQT.bSL().afQ()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.hQT.getForum().getId());
            writeData.setForumName(this.hQT.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.hRz);
        writeData.setThreadId(this.hQx);
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

    public MarkData yb(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.hQT == null) {
            return null;
        }
        ArrayList<PostData> bSN = this.hQT.bSN();
        if (com.baidu.tbadk.core.util.v.aa(bSN)) {
            return null;
        }
        if (bSN.size() > 0 && i >= bSN.size()) {
            i = bSN.size() - 1;
        }
        return j(bSN.get(i));
    }

    public MarkData bWd() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hQx);
        markData.setPostId(this.hQT.aaA());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hQC);
        markData.setSequence(Boolean.valueOf(bWA()));
        markData.setId(this.hQx);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hQx);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hQC);
        markData.setSequence(Boolean.valueOf(bWA()));
        markData.setId(this.hQx);
        markData.setFloor(postData.cpL());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void bWe() {
        g.bVv().as(bWf(), this.isFromMark);
    }

    private String bWf() {
        String str = this.hQx;
        if (this.hQC) {
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

    public void oE(boolean z) {
        if (this.hQT != null) {
            this.hQT.dx(z);
        }
    }

    public void oF(boolean z) {
        this.hRe = z;
    }

    public boolean bWg() {
        return this.hRe;
    }

    public void a(a aVar) {
        this.hQZ = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String asw() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean asv() {
        return auF();
    }

    public boolean BV(String str) {
        if (getPbData() == null || getPbData().bSL() == null || getPbData().bSL().aey() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bSL().aey().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int bWh() {
        return this.mRequestType;
    }

    public void bWi() {
        String bWf = bWf();
        g.bVv().as(bWf, false);
        g.bVv().as(bWf, true);
    }

    public void bWj() {
        if ("personalize_page".equals(this.mStType)) {
            this.hRk = System.currentTimeMillis() / 1000;
        }
    }

    public void bWk() {
        if ("personalize_page".equals(this.mStType) && this.hQT != null && this.hRk != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").bT("fid", this.hQT.getForumId()).bT("tid", this.hQx).bT("obj_duration", String.valueOf(currentTimeMillis - this.hRk)).bT("obj_param3", String.valueOf(currentTimeMillis)));
            this.hRk = 0L;
        }
    }

    public boolean bWl() {
        return this.hRn;
    }

    public int getErrorNo() {
        return this.hRp;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bWm() {
        return this.hRr;
    }

    public m bWn() {
        return this.hRs;
    }

    public z bWo() {
        return this.hRt;
    }

    public CheckRealNameModel bWp() {
        return this.dZx;
    }

    public AddExperiencedModel bWq() {
        return this.hRv;
    }

    public String bWr() {
        return this.hRj;
    }

    public void BW(String str) {
        this.hRj = str;
    }

    public boolean bWs() {
        return this.hRo;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hQT != null && this.hQT.bSN() != null && this.hQT.bSN().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hQT.bSN().size();
                for (int i = 0; i < size; i++) {
                    if (this.hQT.bSN().get(i) != null && this.hQT.bSN().get(i).aey() != null && currentAccount.equals(this.hQT.bSN().get(i).aey().getUserId()) && this.hQT.bSN().get(i).aey().getPendantData() != null) {
                        this.hQT.bSN().get(i).aey().getPendantData().mv(lVar.acV());
                        this.hQT.bSN().get(i).aey().getPendantData().bh(lVar.arE());
                    }
                }
            }
        }
    }

    public String bWt() {
        return this.hRu;
    }

    public int bWu() {
        return this.hRz;
    }

    public void yc(int i) {
        this.hRz = i;
    }

    public void BX(String str) {
        if ((!this.hQC || BV(TbadkCoreApplication.getCurrentAccount())) && this.hQT.bSN() != null) {
            this.hQT.getPage().hc(1);
            if (this.hQT.getPage().ads() == 0) {
                this.hQT.getPage().hc(1);
            }
            this.hRA = str;
            xX(8);
        }
    }

    private void yd(int i) {
        if (i != 8) {
            this.hRA = "";
            if (this.hRB != null) {
                if (i == 1 && !this.hQE && !com.baidu.tbadk.core.util.v.aa(getPbData().bSN())) {
                    getPbData().bSN().remove(this.hRB);
                    if (this.hRC != null) {
                        getPbData().bSN().remove(this.hRC);
                    }
                    getPbData().bSN().add(0, this.hRB);
                } else {
                    getPbData().bSN().remove(this.hRB);
                    if (this.hRC != null) {
                        getPbData().bSN().remove(this.hRC);
                    }
                }
            }
            this.hRC = null;
        }
    }

    public void bWv() {
        if (this.hQT != null && !com.baidu.tbadk.core.util.v.aa(this.hQT.bSN())) {
            if (this.hRC != null) {
                this.hQT.bSN().remove(this.hRC);
                this.hRC = null;
            }
            if (this.hRB != null) {
                this.hQT.bSN().remove(this.hRB);
                this.hRB = null;
            }
        }
    }

    public void ch(int i, int i2) {
        this.hRD = i;
        this.hRE = i2;
    }

    public PostData bWw() {
        return this.hRB;
    }

    public PostData bWx() {
        return this.hRC;
    }

    public int bWy() {
        return this.hRD;
    }

    public String bWz() {
        return this.hRF;
    }

    public void BY(String str) {
        this.hRF = str;
    }

    private boolean bWA() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean bWB() {
        return this.hRz == 13 || this.hRz == 12;
    }
}
