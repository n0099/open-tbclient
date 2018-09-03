package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
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
    private BaseActivity bnc;
    private int cEN;
    private com.baidu.tieba.tbadkCore.d.b cTt;
    private final CheckRealNameModel ccI;
    private long dDe;
    private boolean eIN;
    protected String fAA;
    private String fAB;
    private String fAC;
    private boolean fAD;
    private boolean fAE;
    private boolean fAF;
    private boolean fAG;
    private boolean fAH;
    private int fAI;
    private long fAJ;
    private int fAK;
    private int fAL;
    private int fAM;
    private boolean fAN;
    private boolean fAO;
    private boolean fAP;
    private long fAQ;
    private boolean fAR;
    private String fAS;
    protected com.baidu.tieba.pb.data.d fAT;
    private int fAU;
    private boolean fAV;
    private boolean fAW;
    private boolean fAX;
    private boolean fAY;
    private a fAZ;
    private int fBA;
    private String fBB;
    private PostData fBC;
    private PostData fBD;
    private int fBE;
    private int fBF;
    private String fBG;
    private CustomMessageListener fBH;
    private CustomMessageListener fBI;
    private com.baidu.adp.framework.listener.a fBJ;
    private PraiseData fBK;
    private String fBa;
    private String fBb;
    private int fBc;
    private int fBd;
    private boolean fBe;
    private boolean fBf;
    private boolean fBg;
    private boolean fBh;
    private boolean fBi;
    private String fBj;
    private long fBk;
    private boolean fBl;
    private int fBm;
    private boolean fBn;
    private boolean fBo;
    private int fBp;
    private final x fBq;
    private final h fBr;
    private final m fBs;
    private final r fBt;
    private final z fBu;
    private String fBv;
    private final AddExperiencedModel fBw;
    private SuggestEmotionModel fBx;
    private GetSugMatchWordsModel fBy;
    private boolean fBz;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private com.baidu.tieba.pb.data.c mAppealInfo;
    protected Context mContext;
    private String mForumId;
    private String mFromForumId;
    private int mIsGood;
    private boolean mIsShareThread;
    private String mLocate;
    private int mRequestType;
    public String mStType;
    protected int mThreadType;
    private String opType;
    private String opUrl;
    private String postID;
    private static final int fAz = com.baidu.tbadk.data.d.GR() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.d dVar);
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.fAA = null;
        this.fAB = null;
        this.fAC = null;
        this.mForumId = null;
        this.fAD = false;
        this.fAE = false;
        this.fAF = true;
        this.fAG = true;
        this.fAH = false;
        this.mIsGood = 0;
        this.fAI = 0;
        this.fAJ = 0L;
        this.fAK = 1;
        this.fAL = 1;
        this.fAM = 1;
        this.cEN = 1;
        this.isAd = false;
        this.eIN = false;
        this.fAN = false;
        this.fAO = false;
        this.isFromMark = false;
        this.fAP = false;
        this.fAQ = 0L;
        this.fAR = false;
        this.fAS = null;
        this.fAT = null;
        this.isLoading = false;
        this.fAV = false;
        this.fAW = false;
        this.fAX = false;
        this.fAY = false;
        this.mLocate = null;
        this.mContext = null;
        this.fAZ = null;
        this.opType = null;
        this.opUrl = null;
        this.fBa = null;
        this.fBb = null;
        this.fBc = -1;
        this.fBd = -1;
        this.cTt = null;
        this.fBf = false;
        this.fBg = false;
        this.postID = null;
        this.fBj = null;
        this.fBk = 0L;
        this.fBl = false;
        this.fBm = -1;
        this.fBo = false;
        this.fBz = false;
        this.fBA = 0;
        this.fBH = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.fBi = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.aZi() != null) {
                        pbData.aZi().bS(0);
                    }
                    if (PbModel.this.fAZ != null && pbData != null) {
                        com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fAZ.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fBI = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aZg() != null && PbModel.this.getPbData().aZg().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aZg().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fBJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.jE()) {
                        PbModel.this.bnc.showToast(responsedMessage.getErrorString());
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
                        com.baidu.tbadk.core.d.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    }
                    if (!PbModel.this.fBf || !PbModel.this.fBg) {
                        if (!PbModel.this.fBf) {
                            PbModel.this.fBf = true;
                        } else {
                            PbModel.this.fBg = true;
                        }
                        if (PbModel.this.fAZ != null) {
                            PbModel.this.fAZ.a(PbModel.this.bca(), z, responsedMessage, PbModel.this.fBh, System.currentTimeMillis() - PbModel.this.dDe);
                        }
                    }
                }
            }
        };
        this.fBK = null;
        registerListener(this.fBH);
        registerListener(this.fBJ);
        registerListener(this.fBI);
        this.fAT = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bnc = baseActivity;
        this.fBq = new x(this, this.bnc);
        this.fBr = new h(this, this.bnc);
        this.fBs = new m(this, this.bnc);
        this.fBt = new r(this, getUniqueId());
        this.fBu = new z(this, this.bnc);
        this.ccI = new CheckRealNameModel(this.bnc.getPageContext());
        this.fBx = new SuggestEmotionModel();
        this.fBw = new AddExperiencedModel(this.bnc.getPageContext());
    }

    protected int bca() {
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
        this.fAA = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fAA)) {
            this.fAA = this.fBq.U(intent);
            if (StringUtils.isNull(this.fAA) && intent.getData() != null) {
                this.fAA = intent.getData().getQueryParameter("thread_id");
            }
        }
        this.fBA = intent.getIntExtra("key_start_from", 0);
        if (this.fBA == 0) {
            this.fBA = this.fBq.fBQ;
        }
        this.fAC = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.mFromForumId = intent.getStringExtra("from_forum_id");
        this.fAB = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fAD = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fAE = intent.getBooleanExtra("host_only", false);
        this.fAG = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fAI = intent.getIntExtra("is_top", 0);
        this.fAJ = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fAP = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eIN = intent.getBooleanExtra("is_sub_pb", false);
        this.fAR = intent.getBooleanExtra("is_pv", false);
        this.fAQ = intent.getLongExtra("msg_id", 0L);
        this.fAS = intent.getStringExtra("from_forum_name");
        this.fBb = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fBa = intent.getStringExtra("op_stat");
        this.fAV = intent.getBooleanExtra("is_from_thread_config", false);
        this.fAW = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fAX = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fBd = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fBc = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fAN = intent.getBooleanExtra("from_frs", false);
        this.fAO = intent.getBooleanExtra("from_maintab", false);
        this.fBo = intent.getBooleanExtra("from_smart_frs", false);
        this.fAY = intent.getBooleanExtra("from_hottopic", false);
        this.fBv = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fBA = bundle.getInt("key_start_from", 0);
        this.fAA = bundle.getString("thread_id");
        this.fAC = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.fAB = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fAD = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fAE = bundle.getBoolean("host_only", false);
        this.fAG = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fAI = bundle.getInt("is_top", 0);
        this.fAJ = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fAP = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eIN = bundle.getBoolean("is_sub_pb", false);
        this.fAR = bundle.getBoolean("is_pv", false);
        this.fAQ = bundle.getLong("msg_id", 0L);
        this.fAS = bundle.getString("from_forum_name");
        this.fBb = bundle.getString("extra_pb_cache_key");
        this.fAV = bundle.getBoolean("is_from_thread_config", false);
        this.fAW = bundle.getBoolean("is_from_interview_live_config", false);
        this.fAX = bundle.getBoolean("is_from_my_god_config", false);
        this.fBd = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fBc = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fAN = bundle.getBoolean("from_frs", false);
        this.fAO = bundle.getBoolean("from_maintab", false);
        this.fBo = bundle.getBoolean("from_smart_frs", false);
        this.fAY = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void z(Bundle bundle) {
        bundle.putString("thread_id", this.fAA);
        bundle.putString("post_id", this.fAC);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.fBA);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fAD);
        bundle.putBoolean("host_only", this.fAE);
        bundle.putBoolean("squence", this.fAG);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fAI);
        bundle.putLong("thread_time", this.fAJ);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fAP);
        bundle.putBoolean("is_sub_pb", this.eIN);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fAR);
        bundle.putLong("msg_id", this.fAQ);
        bundle.putString("extra_pb_cache_key", this.fBb);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fAV);
        bundle.putBoolean("is_from_interview_live_config", this.fAW);
        bundle.putBoolean("is_from_my_god_config", this.fAX);
        bundle.putInt("extra_pb_is_attention_key", this.fBd);
        bundle.putInt("extra_pb_funs_count_key", this.fBc);
        bundle.putBoolean("from_frs", this.fAN);
        bundle.putBoolean("from_maintab", this.fAO);
        bundle.putBoolean("from_smart_frs", this.fBo);
        bundle.putBoolean("from_hottopic", this.fAY);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bcb() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fAA);
        if (!this.fAP) {
            sb.append(this.fAC);
        }
        sb.append(this.fAE);
        sb.append(this.fAG);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fAI);
        sb.append(this.fAJ);
        sb.append(this.fAN);
        sb.append(this.fAO);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eIN);
        sb.append(this.fAR);
        sb.append(this.fAQ);
        sb.append(this.fAS);
        sb.append(this.mThreadType);
        sb.append(this.fAV);
        sb.append(this.fAW);
        sb.append(this.fAX);
        if (this.fBb != null) {
            sb.append(this.fBb);
        }
        return sb.toString();
    }

    public String bcc() {
        return this.fAS;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.fAC;
    }

    public String bcd() {
        return this.fAA;
    }

    public boolean getHostMode() {
        return this.fAE;
    }

    public boolean bce() {
        return this.fAG;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bcf() {
        return this.fAN;
    }

    public boolean bcg() {
        return this.fAH;
    }

    public boolean bch() {
        return this.fAO;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bci() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bcj() {
        return this.fAI;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void ji(int i) {
        this.fAI = i;
    }

    public boolean bck() {
        return this.eIN;
    }

    public boolean bcl() {
        if (this.fAT == null) {
            return false;
        }
        return this.fAT.isValid();
    }

    public String vt() {
        if (this.fAT == null || !this.fAT.rL()) {
            return null;
        }
        return this.fAT.rK();
    }

    public boolean qD(int i) {
        this.fAK = i;
        if (this.fAK > this.fAT.uv().um()) {
            this.fAK = this.fAT.uv().um();
        }
        if (this.fAK < 1) {
            this.fAK = 1;
        }
        if (this.fAA == null) {
            return false;
        }
        return qF(5);
    }

    public void qE(int i) {
        this.fAK = i;
        this.fAL = i;
        this.fAM = i;
    }

    public void c(com.baidu.tbadk.core.data.al alVar) {
        if (alVar == null) {
            qE(1);
            return;
        }
        this.fAL = alVar.up();
        this.fAM = alVar.up();
        this.cEN = alVar.um();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.fAT;
    }

    public com.baidu.tbadk.core.data.al getPageData() {
        if (this.fAT == null) {
            return null;
        }
        return this.fAT.uv();
    }

    public boolean bcm() {
        if (this.fAG && this.fAT.uv().ur() == 0) {
            jP(true);
            return true;
        }
        return false;
    }

    public void re(String str) {
        if (!StringUtils.isNull(str)) {
            this.fAA = str;
            this.fAC = null;
            this.fAE = false;
            this.fAG = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fAA == null) {
            return false;
        }
        cancelLoadData();
        if (this.cTt == null) {
            this.cTt = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.cTt.start();
        }
        boolean qF = qF(3);
        if (this.opType != null) {
            this.opType = null;
            this.fBa = null;
            this.opUrl = null;
            return qF;
        }
        return qF;
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
        if (this.fBx != null) {
            this.fBx.cancelLoadData();
        }
        if (this.fBt != null) {
            this.fBt.cancelLoadData();
        }
        if (this.fBy != null) {
            this.fBy.cancelLoadData();
        }
        aph();
    }

    private void aph() {
        if (this.cTt != null) {
            this.cTt.destory();
            this.cTt = null;
        }
    }

    public boolean JV() {
        return (this.fAC == null || this.fAC.equals("0") || this.fAC.length() == 0) ? LoadData() : bcp();
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
                this.fBx.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fBx.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fBy == null) {
                this.fBy = new GetSugMatchWordsModel(this.bnc.getPageContext());
            }
            this.fBy.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02d9 A[Catch: Exception -> 0x0216, TryCatch #0 {Exception -> 0x0216, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:41:0x0128, B:43:0x0145, B:44:0x014d, B:46:0x0151, B:47:0x0159, B:49:0x015d, B:50:0x0162, B:52:0x0166, B:53:0x016b, B:55:0x016f, B:56:0x017f, B:58:0x0183, B:59:0x018b, B:61:0x018f, B:62:0x01a8, B:63:0x01b7, B:64:0x01ba, B:67:0x01e6, B:69:0x01f9, B:74:0x0220, B:76:0x0236, B:78:0x023c, B:80:0x0243, B:81:0x0250, B:83:0x0264, B:85:0x0268, B:87:0x026e, B:94:0x0295, B:96:0x029b, B:88:0x0279, B:90:0x027d, B:92:0x0285, B:93:0x0290, B:97:0x02a7, B:99:0x02bb, B:101:0x02bf, B:104:0x02d1, B:128:0x0331, B:108:0x02d9, B:110:0x02df, B:111:0x02e4, B:113:0x02e8, B:115:0x02f2, B:120:0x0309, B:122:0x0317, B:123:0x031a, B:125:0x031e, B:127:0x0326, B:129:0x0336, B:131:0x033a, B:117:0x02f6, B:132:0x0343, B:133:0x0371, B:135:0x0375, B:145:0x03a4, B:138:0x0381, B:140:0x038d, B:141:0x0395, B:143:0x0399, B:144:0x039f, B:146:0x03ad, B:137:0x0379, B:147:0x03b6, B:149:0x03c2, B:151:0x03c6, B:153:0x03ca, B:154:0x03cf, B:156:0x03db, B:157:0x03e3, B:159:0x03f4, B:158:0x03e8, B:160:0x03fd, B:162:0x040c, B:36:0x00c8), top: B:166:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02e8 A[Catch: Exception -> 0x0216, TryCatch #0 {Exception -> 0x0216, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:41:0x0128, B:43:0x0145, B:44:0x014d, B:46:0x0151, B:47:0x0159, B:49:0x015d, B:50:0x0162, B:52:0x0166, B:53:0x016b, B:55:0x016f, B:56:0x017f, B:58:0x0183, B:59:0x018b, B:61:0x018f, B:62:0x01a8, B:63:0x01b7, B:64:0x01ba, B:67:0x01e6, B:69:0x01f9, B:74:0x0220, B:76:0x0236, B:78:0x023c, B:80:0x0243, B:81:0x0250, B:83:0x0264, B:85:0x0268, B:87:0x026e, B:94:0x0295, B:96:0x029b, B:88:0x0279, B:90:0x027d, B:92:0x0285, B:93:0x0290, B:97:0x02a7, B:99:0x02bb, B:101:0x02bf, B:104:0x02d1, B:128:0x0331, B:108:0x02d9, B:110:0x02df, B:111:0x02e4, B:113:0x02e8, B:115:0x02f2, B:120:0x0309, B:122:0x0317, B:123:0x031a, B:125:0x031e, B:127:0x0326, B:129:0x0336, B:131:0x033a, B:117:0x02f6, B:132:0x0343, B:133:0x0371, B:135:0x0375, B:145:0x03a4, B:138:0x0381, B:140:0x038d, B:141:0x0395, B:143:0x0399, B:144:0x039f, B:146:0x03ad, B:137:0x0379, B:147:0x03b6, B:149:0x03c2, B:151:0x03c6, B:153:0x03ca, B:154:0x03cf, B:156:0x03db, B:157:0x03e3, B:159:0x03f4, B:158:0x03e8, B:160:0x03fd, B:162:0x040c, B:36:0x00c8), top: B:166:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x031e A[Catch: Exception -> 0x0216, TryCatch #0 {Exception -> 0x0216, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:41:0x0128, B:43:0x0145, B:44:0x014d, B:46:0x0151, B:47:0x0159, B:49:0x015d, B:50:0x0162, B:52:0x0166, B:53:0x016b, B:55:0x016f, B:56:0x017f, B:58:0x0183, B:59:0x018b, B:61:0x018f, B:62:0x01a8, B:63:0x01b7, B:64:0x01ba, B:67:0x01e6, B:69:0x01f9, B:74:0x0220, B:76:0x0236, B:78:0x023c, B:80:0x0243, B:81:0x0250, B:83:0x0264, B:85:0x0268, B:87:0x026e, B:94:0x0295, B:96:0x029b, B:88:0x0279, B:90:0x027d, B:92:0x0285, B:93:0x0290, B:97:0x02a7, B:99:0x02bb, B:101:0x02bf, B:104:0x02d1, B:128:0x0331, B:108:0x02d9, B:110:0x02df, B:111:0x02e4, B:113:0x02e8, B:115:0x02f2, B:120:0x0309, B:122:0x0317, B:123:0x031a, B:125:0x031e, B:127:0x0326, B:129:0x0336, B:131:0x033a, B:117:0x02f6, B:132:0x0343, B:133:0x0371, B:135:0x0375, B:145:0x03a4, B:138:0x0381, B:140:0x038d, B:141:0x0395, B:143:0x0399, B:144:0x039f, B:146:0x03ad, B:137:0x0379, B:147:0x03b6, B:149:0x03c2, B:151:0x03c6, B:153:0x03ca, B:154:0x03cf, B:156:0x03db, B:157:0x03e3, B:159:0x03f4, B:158:0x03e8, B:160:0x03fd, B:162:0x040c, B:36:0x00c8), top: B:166:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x033a A[Catch: Exception -> 0x0216, TryCatch #0 {Exception -> 0x0216, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:41:0x0128, B:43:0x0145, B:44:0x014d, B:46:0x0151, B:47:0x0159, B:49:0x015d, B:50:0x0162, B:52:0x0166, B:53:0x016b, B:55:0x016f, B:56:0x017f, B:58:0x0183, B:59:0x018b, B:61:0x018f, B:62:0x01a8, B:63:0x01b7, B:64:0x01ba, B:67:0x01e6, B:69:0x01f9, B:74:0x0220, B:76:0x0236, B:78:0x023c, B:80:0x0243, B:81:0x0250, B:83:0x0264, B:85:0x0268, B:87:0x026e, B:94:0x0295, B:96:0x029b, B:88:0x0279, B:90:0x027d, B:92:0x0285, B:93:0x0290, B:97:0x02a7, B:99:0x02bb, B:101:0x02bf, B:104:0x02d1, B:128:0x0331, B:108:0x02d9, B:110:0x02df, B:111:0x02e4, B:113:0x02e8, B:115:0x02f2, B:120:0x0309, B:122:0x0317, B:123:0x031a, B:125:0x031e, B:127:0x0326, B:129:0x0336, B:131:0x033a, B:117:0x02f6, B:132:0x0343, B:133:0x0371, B:135:0x0375, B:145:0x03a4, B:138:0x0381, B:140:0x038d, B:141:0x0395, B:143:0x0399, B:144:0x039f, B:146:0x03ad, B:137:0x0379, B:147:0x03b6, B:149:0x03c2, B:151:0x03c6, B:153:0x03ca, B:154:0x03cf, B:156:0x03db, B:157:0x03e3, B:159:0x03f4, B:158:0x03e8, B:160:0x03fd, B:162:0x040c, B:36:0x00c8), top: B:166:0x00bc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean qF(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        qG(i);
        final com.baidu.tieba.pb.data.d pbData = aj.bdl().getPbData();
        if (pbData != null && pbData.aZi() != null) {
            pbData.aZi().bS(0);
            this.fAG = aj.bdl().bce();
            this.fAE = aj.bdl().bdq();
            this.fAH = aj.bdl().bdr();
            this.fBC = aj.bdl().bdp();
            this.fBD = aj.bdl().bdo();
            this.fBE = aj.bdl().bdn();
            this.fBz = this.fAE;
            if (this.fAE || this.isFromMark) {
                this.fBe = false;
            }
            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.fBi) {
            a(bcu(), true, this.fAC, 3);
        }
        if (i == 3 && !this.fBi) {
            if (this.isFromMark) {
                a(bcu(), true, this.fAC, 3);
            } else {
                a(bcu(), false, this.fAC, 3);
            }
        }
        this.fBi = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aLn);
        if (this.fAE || this.isFromMark) {
            this.fBe = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fAA == null || this.fAA.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.fAA, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
        int aj = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.ar.zu().zw() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aj));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.fAG) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.fAE) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fAR) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fAQ));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fBe) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.fBa, 0));
            pbPageRequestMessage.setOpMessageID(this.fAQ);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aZk = this.fAT.aZk();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.fAG) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fAM - 1));
                        if (this.fAM - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z) {
                                if (aZk != null && aZk.size() > 0) {
                                    size = aZk.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = aZk.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.fAC = postData.getId();
                                            if (StringUtils.isNull(this.fAC)) {
                                                i3 = i2 + 1;
                                            }
                                        }
                                        i2 = i3;
                                    }
                                }
                                if (this.fAC == null && this.fAC.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fAC, 0L));
                                } else if (!this.fAG) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            b(pbPageRequestMessage);
                            break;
                        }
                    } else {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fAL + 1));
                        if (this.fAL >= this.cEN) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (aZk != null) {
                                size = aZk.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                            }
                            if (this.fAC == null) {
                            }
                            if (!this.fAG) {
                            }
                            b(pbPageRequestMessage);
                        }
                    }
                }
                z = false;
                if (!this.isFromMark) {
                }
                if (aZk != null) {
                }
                if (this.fAC == null) {
                }
                if (!this.fAG) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (aZk != null && aZk.size() > 0 && aZk.get(0) != null) {
                    this.fAC = aZk.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.fAG) {
                        if (this.fAM - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fAM - 1));
                        }
                    } else if (this.fAL < this.cEN) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fAL + 1));
                    }
                }
                if (this.fAC != null && this.fAC.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fAC, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fAE) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.fAG) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                }
                if (this.isFromMark) {
                    pbPageRequestMessage.set_st_type("store_thread");
                }
                a(pbPageRequestMessage);
                break;
            case 4:
                pbPageRequestMessage.set_st_type("store_thread");
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fAC, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fAK));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.fAG && this.fBz && !this.fAE) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fAC, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.fAE) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fBm);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fBB, 0L));
                if (!this.fAG) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fBz = this.fAE;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bcu());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fBA));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fBl);
        pbPageRequestMessage.setFromSmartFrs(this.fBo ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fAD);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bbp() {
        switch (bcJ()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().aZi() == null || !getPbData().aZi().ws();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bcc()) && com.baidu.tieba.recapp.r.bno().bni() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bno().bni().Q(bcc(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bno().bni().R(bcc(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bcc()) && com.baidu.tieba.recapp.r.bno().bni() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bno().bni().R(bcc(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bno().bni().Q(bcc(), true));
        }
    }

    protected void qG(int i) {
        boolean z = false;
        qK(i);
        ArrayList<PostData> aZk = this.fAT.aZk();
        this.fBh = false;
        if (i == 1) {
            boolean z2 = false;
            while (aZk.size() + 30 > com.baidu.tbadk.data.d.GR()) {
                aZk.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fAT.uv().bO(1);
                if (this.fAZ != null) {
                    this.fAZ.f(this.fAT);
                }
            }
            this.dDe = System.currentTimeMillis();
            this.fBh = true;
        } else if (i == 2) {
            while (aZk.size() + 30 > com.baidu.tbadk.data.d.GR()) {
                aZk.remove(aZk.size() - 1);
                z = true;
            }
            if (z) {
                this.fAT.uv().bN(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.fBp = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fAB)) {
            try {
                Long valueOf = Long.valueOf(this.fAB);
                com.baidu.tieba.pb.data.l aZt = dVar.aZt();
                if (aZt != null && aZt.ftv != null) {
                    if (aZt.ftv.isEmpty() || !aZt.ftv.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fAA);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            l = null;
                        }
                        if (l != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921313, l));
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
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

    protected void i(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            if (this.fAX || this.fAV || this.fAW) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.aZk().size(); i++) {
                PostData postData = dVar.aZk().get(i);
                for (int i2 = 0; i2 < postData.bwd().size(); i2++) {
                    postData.bwd().get(i2).b(this.bnc.getPageContext(), l.equals(postData.bwd().get(i2).vj().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.l aZt = dVar.aZt();
            if (aZt != null && !com.baidu.tbadk.core.util.w.z(aZt.ftu)) {
                for (PostData postData2 : aZt.ftu) {
                    for (int i3 = 0; i3 < postData2.bwd().size(); i3++) {
                        postData2.bwd().get(i3).b(this.bnc.getPageContext(), l.equals(postData2.bwd().get(i3).vj().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.l aZt = dVar.aZt();
            if (aZt != null && !com.baidu.tbadk.core.util.w.z(aZt.ftu)) {
                for (PostData postData : aZt.ftu.subList(i, aZt.ftu.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bwd().size()) {
                            postData.bwd().get(i3).b(this.bnc.getPageContext(), l.equals(postData.bwd().get(i3).vj().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.d k(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null) {
            return null;
        }
        bb aZi = dVar.aZi();
        aZi.bW(this.mIsGood);
        aZi.bV(this.fAI);
        if (this.fAJ > 0) {
            aZi.q(this.fAJ);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.aZi() != null && dVar.aZi().vj() != null) {
            str = dVar.aZi().vj().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bcn() {
        if (this.fAT == null || this.fAT.aZi() == null || this.fAT.aZi().vj() == null) {
            return null;
        }
        return this.fAT.aZi().vj();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fBn = z3;
        this.fAU = i;
        if (this.cTt != null && !z3) {
            this.cTt.a(z2, z4, i2, str, i3, j, j2);
            this.cTt = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bcc()) && com.baidu.tieba.recapp.r.bno().bni() != null) {
            com.baidu.tieba.recapp.r.bno().bni().f(bcc(), qH(getRequestType()), true);
        }
        if (dVar == null || (this.fAK == 1 && i == 5 && dVar.aZk() != null && dVar.aZk().size() < 1)) {
            if (this.fAZ != null) {
                this.fAG = this.fAF;
                this.fAZ.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fAF = this.fAG;
            this.fAR = false;
            if (dVar.uv() != null) {
                c(dVar.uv());
            }
            this.cEN = this.cEN < 1 ? 1 : this.cEN;
            ArrayList<PostData> aZk = this.fAT.aZk();
            switch (i) {
                case 1:
                    this.fAT.a(dVar.uv(), 1);
                    e(dVar, aZk);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.aZk() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.aZk().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.w.d(aZk, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.w.d(dVar.aZk(), com.baidu.tbadk.core.util.w.y(dVar.aZk()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.aZk().remove(postData2);
                            i6 = size - 1;
                        }
                        aZk.addAll(0, dVar.aZk());
                    }
                    this.fAT.a(dVar.uv(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.fAG && dVar.uv() != null) {
                        dVar.uv().bL(dVar.uv().um());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && this.fAG) {
                        bco();
                        i5 = 0;
                        break;
                    }
                    i5 = 0;
                    break;
                case 4:
                    m(dVar);
                    i5 = 0;
                    break;
                case 5:
                    m(dVar);
                    i5 = 0;
                    break;
                case 6:
                    m(dVar);
                    i5 = 0;
                    break;
                case 7:
                    m(dVar);
                    i5 = 0;
                    break;
                case 8:
                    if (dVar != null && !com.baidu.tbadk.core.util.w.z(dVar.aZk()) && this.fAT != null && (!this.fAE || l(dVar).equals(dVar.aZk().get(0).vj().getUserId()))) {
                        if (this.fAT.uv().ur() == 0) {
                            this.fAT.uv().bN(1);
                        }
                        bcK();
                        this.fBC = dVar.aZk().get(0);
                        if (this.fAG) {
                            if (this.fAT.aZk().size() - this.fBE >= 3) {
                                this.fBD = new PostData();
                                this.fBD.gOu = true;
                                this.fBD.setPostType(53);
                                this.fAT.aZk().add(this.fBD);
                            }
                            this.fAT.aZk().add(this.fBC);
                            i4 = this.fAT.aZk().size() - 1;
                        } else {
                            if (this.fBE - this.fBF >= 3) {
                                this.fBD = new PostData();
                                this.fBD.gOu = false;
                                this.fBD.setPostType(53);
                                this.fAT.aZk().add(0, this.fBD);
                            }
                            this.fAT.aZk().add(0, this.fBC);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ap.U(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fBC.gOH = this.fAT.aZJ();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.fAT != null && this.fAT.aZi() != null) {
                PraiseData uW = this.fAT.aZi().uW();
                if (this.fBK != null && !uW.isPriaseDataValid()) {
                    this.fAT.aZi().a(this.fBK);
                } else {
                    this.fBK = this.fAT.aZi().uW();
                    this.fBK.setPostId(this.fAT.aZi().vA());
                }
                if (dVar.uv() != null && dVar.uv().up() == 1 && dVar.aZi() != null && dVar.aZi().vv() != null && dVar.aZi().vv().size() > 0) {
                    this.fAT.aZi().l(dVar.aZi().vv());
                }
                this.fAT.aZi().bT(dVar.aZi().va());
                this.fAT.aZi().bQ(dVar.aZi().getAnchorLevel());
                this.fAT.aZi().bS(dVar.aZi().uS());
                if (this.mThreadType == 33) {
                    this.fAT.aZi().vj().setHadConcerned(dVar.aZi().vj().hadConcerned());
                }
                if (dVar != null && dVar.aZi() != null) {
                    this.fAT.aZi().bY(dVar.aZi().vz());
                }
            }
            if (this.fAT != null && this.fAT.getUserData() != null && dVar.getUserData() != null) {
                this.fAT.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.fAT.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.uv() != null && dVar.uv().up() == 1 && dVar.aZs() != null) {
                this.fAT.c(dVar.aZs());
            }
            if (this.fBn) {
                if (this.fAT.aZi() != null && this.fAT.aZi().vj() != null && this.fAT.aZk() != null && com.baidu.tbadk.core.util.w.d(this.fAT.aZk(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.w.d(this.fAT.aZk(), 0);
                    MetaData vj = this.fAT.aZi().vj();
                    if (postData3.vj() != null && postData3.vj().getGodUserData() != null) {
                        if (this.fBc != -1) {
                            vj.setFansNum(this.fBc);
                            postData3.vj().setFansNum(this.fBc);
                        }
                        if (this.fBd != -1) {
                            vj.getGodUserData().setIsLike(this.fBd == 1);
                            postData3.vj().getGodUserData().setIsLike(this.fBd == 1);
                            vj.getGodUserData().setIsFromNetWork(false);
                            postData3.vj().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fAT.fsS = -1;
                this.fAT.fsR = -1;
            }
            if (this.fAZ != null) {
                this.fAZ.a(true, getErrorCode(), i, i5, this.fAT, this.mErrorString, 1);
            }
        }
        if (this.fAT != null && this.fAT.aZi() != null && this.fAT.aZg() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bnc;
            historyMessage.threadId = getPbData().aZi().getId();
            if (this.mIsShareThread && getPbData().aZi().ajH != null) {
                historyMessage.threadName = getPbData().aZi().ajH.showText;
            } else {
                historyMessage.threadName = getPbData().aZi().getTitle();
            }
            if (this.mIsShareThread && !bbp()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().aZg().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bce();
            historyMessage.threadType = getPbData().aZi().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String ap;
        if (arrayList != null && dVar.aZk() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.w.d(dVar.aZk(), 0);
            if (postData != null && (ap = ap(arrayList)) != null && ap.equals(postData.getId())) {
                dVar.aZk().remove(postData);
            }
            arrayList.addAll(dVar.aZk());
        }
    }

    private int qH(int i) {
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

    private String ap(ArrayList<PostData> arrayList) {
        int y = com.baidu.tbadk.core.util.w.y(arrayList);
        if (y <= 0) {
            return null;
        }
        for (int i = y - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.w.d(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.tieba.pb.data.d dVar) {
        dVar.rc(this.fAT.aZB());
        this.fAT = dVar;
        qE(dVar.uv().up());
    }

    private void bco() {
        if (this.fAT != null && this.fAT.aZk() != null && this.fAT.aZA() != null) {
            ArrayList<PostData> aZk = this.fAT.aZk();
            com.baidu.tieba.pb.data.a aZA = this.fAT.aZA();
            int aZe = aZA.aZe();
            if (aZe > 0) {
                if (aZe <= aZk.size()) {
                    aZk.add(aZe, aZA);
                } else {
                    aZk.add(aZA);
                }
            }
        }
    }

    public boolean bcp() {
        if (this.fAA == null || this.fAC == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return qF(4);
        }
        return qF(6);
    }

    public boolean jP(boolean z) {
        if (this.fAA == null || this.fAT == null) {
            return false;
        }
        if (z || this.fAT.uv().ur() != 0) {
            return qF(1);
        }
        return false;
    }

    public boolean jQ(boolean z) {
        if (this.fAA == null || this.fAT == null) {
            return false;
        }
        if ((z || this.fAT.uv().us() != 0) && this.fAT.aZk() != null && this.fAT.aZk().size() >= 1) {
            return qF(2);
        }
        return false;
    }

    public boolean rj(String str) {
        this.fAE = !this.fAE;
        this.fAC = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (qF(6)) {
            return true;
        }
        this.fAE = this.fAE ? false : true;
        return false;
    }

    public boolean l(boolean z, String str) {
        if (this.fAE == z) {
            return false;
        }
        this.fAE = z;
        this.fAC = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (qF(6)) {
            return true;
        }
        this.fAE = z ? false : true;
        return false;
    }

    public boolean bcq() {
        this.fAF = this.fAG;
        this.fAG = !this.fAG;
        if (this.isLoading || !LoadData()) {
            this.fAG = this.fAG ? false : true;
            return false;
        }
        return true;
    }

    public boolean bcr() {
        return this.fAG;
    }

    public boolean hasData() {
        return (this.fAT == null || this.fAT.aZg() == null || this.fAT.aZi() == null) ? false : true;
    }

    public boolean rL() {
        if (this.fAT == null) {
            return false;
        }
        return this.fAT.rL();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gH(String str) {
        if (this.fAT == null || this.fAT.aZi() == null || this.fAT.aZg() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fAT.aZi().ws()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fAT.aZg().getId());
            writeData.setForumName(this.fAT.aZg().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.fBA);
        writeData.setThreadId(this.fAA);
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

    public MarkData qI(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fAT == null) {
            return null;
        }
        ArrayList<PostData> aZk = this.fAT.aZk();
        if (com.baidu.tbadk.core.util.w.z(aZk)) {
            return null;
        }
        if (aZk.size() > 0 && i >= aZk.size()) {
            i = aZk.size() - 1;
        }
        return g(aZk.get(i));
    }

    public MarkData bcs() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fAA);
        markData.setPostId(this.fAT.rK());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fAE);
        markData.setSequence(Boolean.valueOf(this.fAG));
        markData.setId(this.fAA);
        return markData;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fAA);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fAE);
        markData.setSequence(Boolean.valueOf(this.fAG));
        markData.setId(this.fAA);
        markData.setFloor(postData.bwg());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bct() {
        g.bbM().J(bcu(), this.isFromMark);
    }

    private String bcu() {
        String str = this.fAA;
        if (this.fAE) {
            str = str + DB_KEY_HOST;
        }
        if (!this.fAG) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jR(boolean z) {
        if (this.fAT != null) {
            this.fAT.ae(z);
        }
    }

    public void jS(boolean z) {
        this.fBe = z;
    }

    public boolean bcv() {
        return this.fBe;
    }

    public void a(a aVar) {
        this.fAZ = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String HO() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean HN() {
        return JV();
    }

    public boolean rk(String str) {
        if (getPbData() == null || getPbData().aZi() == null || getPbData().aZi().vj() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aZi().vj().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bcw() {
        String bcu = bcu();
        g.bbM().J(bcu, false);
        g.bbM().J(bcu, true);
    }

    public void bcx() {
        if ("personalize_page".equals(this.mStType)) {
            this.fBk = System.currentTimeMillis() / 1000;
        }
    }

    public void bcy() {
        if ("personalize_page".equals(this.mStType) && this.fAT != null && this.fBk != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").ae(ImageViewerConfig.FORUM_ID, this.fAT.getForumId()).ae("tid", this.fAA).ae("obj_duration", String.valueOf(currentTimeMillis - this.fBk)).ae("obj_param3", String.valueOf(currentTimeMillis)));
            this.fBk = 0L;
        }
    }

    public boolean bcz() {
        return this.fBn;
    }

    public int getErrorNo() {
        return this.fBp;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bcA() {
        return this.fBr;
    }

    public m bcB() {
        return this.fBs;
    }

    public r bcC() {
        return this.fBt;
    }

    public z bcD() {
        return this.fBu;
    }

    public CheckRealNameModel bcE() {
        return this.ccI;
    }

    public AddExperiencedModel bcF() {
        return this.fBw;
    }

    public String bcG() {
        return this.fBj;
    }

    public void rl(String str) {
        this.fBj = str;
    }

    public boolean bcH() {
        return this.fBo;
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.fAT != null && this.fAT.aZk() != null && this.fAT.aZk().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fAT.aZk().size();
                for (int i = 0; i < size; i++) {
                    if (this.fAT.aZk().get(i) != null && this.fAT.aZk().get(i).vj() != null && currentAccount.equals(this.fAT.aZk().get(i).vj().getUserId()) && this.fAT.aZk().get(i).vj().getPendantData() != null) {
                        this.fAT.aZk().get(i).vj().getPendantData().dj(iVar.tT());
                        this.fAT.aZk().get(i).vj().getPendantData().Z(iVar.GZ());
                    }
                }
            }
        }
    }

    public String bcI() {
        return this.fBv;
    }

    public int bcJ() {
        return this.fBA;
    }

    public void qJ(int i) {
        this.fBA = i;
    }

    public void rm(String str) {
        if ((!this.fAE || rk(TbadkCoreApplication.getCurrentAccount())) && this.fAT.aZk() != null) {
            this.fAT.uv().bN(1);
            if (this.fAT.uv().ur() == 0) {
                this.fAT.uv().bN(1);
            }
            this.fBB = str;
            qF(8);
        }
    }

    private void qK(int i) {
        if (i != 8) {
            this.fBB = "";
            if (this.fBC != null) {
                if (i == 1 && !this.fAG && !com.baidu.tbadk.core.util.w.z(getPbData().aZk())) {
                    getPbData().aZk().remove(this.fBC);
                    if (this.fBD != null) {
                        getPbData().aZk().remove(this.fBD);
                    }
                    getPbData().aZk().add(0, this.fBC);
                } else {
                    getPbData().aZk().remove(this.fBC);
                    if (this.fBD != null) {
                        getPbData().aZk().remove(this.fBD);
                    }
                }
            }
            this.fBD = null;
        }
    }

    public void bcK() {
        if (this.fAT != null && !com.baidu.tbadk.core.util.w.z(this.fAT.aZk())) {
            if (this.fBD != null) {
                this.fAT.aZk().remove(this.fBD);
                this.fBD = null;
            }
            if (this.fBC != null) {
                this.fAT.aZk().remove(this.fBC);
                this.fBC = null;
            }
        }
    }

    public void bq(int i, int i2) {
        this.fBE = i;
        this.fBF = i2;
    }

    public PostData bcL() {
        return this.fBC;
    }

    public PostData bcM() {
        return this.fBD;
    }

    public int bcN() {
        return this.fBE;
    }

    public String bcO() {
        return this.fBG;
    }

    public void rn(String str) {
        this.fBG = str;
    }
}
