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
import com.baidu.tbadk.core.data.bc;
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
    private BaseActivity bmt;
    private int cCl;
    private com.baidu.tieba.tbadkCore.d.b cQK;
    private final CheckRealNameModel cbx;
    private long dAv;
    private boolean eEY;
    private boolean eUP;
    private boolean fAA;
    private boolean fAB;
    private boolean fAC;
    private int fAD;
    private long fAE;
    private int fAF;
    private int fAG;
    private int fAH;
    private boolean fAI;
    private boolean fAJ;
    private long fAK;
    private boolean fAL;
    private String fAM;
    protected com.baidu.tieba.pb.data.d fAN;
    private int fAO;
    private boolean fAP;
    private boolean fAQ;
    private boolean fAR;
    private boolean fAS;
    private a fAT;
    private String fAU;
    private String fAV;
    private int fAW;
    private int fAX;
    private boolean fAY;
    private boolean fAZ;
    protected String fAv;
    private String fAw;
    private String fAx;
    private boolean fAy;
    private boolean fAz;
    private String fBA;
    private CustomMessageListener fBB;
    private CustomMessageListener fBC;
    private com.baidu.adp.framework.listener.a fBD;
    private PraiseData fBE;
    private boolean fBa;
    private boolean fBb;
    private boolean fBc;
    private String fBd;
    private long fBe;
    private boolean fBf;
    private int fBg;
    private boolean fBh;
    private boolean fBi;
    private int fBj;
    private final x fBk;
    private final h fBl;
    private final m fBm;
    private final r fBn;
    private final z fBo;
    private String fBp;
    private final AddExperiencedModel fBq;
    private SuggestEmotionModel fBr;
    private GetSugMatchWordsModel fBs;
    private boolean fBt;
    private int fBu;
    private String fBv;
    private PostData fBw;
    private PostData fBx;
    private int fBy;
    private int fBz;
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
    private static final int fAu = com.baidu.tbadk.data.d.GV() / 30;
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
        this.fAv = null;
        this.fAw = null;
        this.fAx = null;
        this.mForumId = null;
        this.fAy = false;
        this.fAz = false;
        this.fAA = true;
        this.fAB = true;
        this.fAC = false;
        this.mIsGood = 0;
        this.fAD = 0;
        this.fAE = 0L;
        this.fAF = 1;
        this.fAG = 1;
        this.fAH = 1;
        this.cCl = 1;
        this.isAd = false;
        this.eEY = false;
        this.fAI = false;
        this.eUP = false;
        this.isFromMark = false;
        this.fAJ = false;
        this.fAK = 0L;
        this.fAL = false;
        this.fAM = null;
        this.fAN = null;
        this.isLoading = false;
        this.fAP = false;
        this.fAQ = false;
        this.fAR = false;
        this.fAS = false;
        this.mLocate = null;
        this.mContext = null;
        this.fAT = null;
        this.opType = null;
        this.opUrl = null;
        this.fAU = null;
        this.fAV = null;
        this.fAW = -1;
        this.fAX = -1;
        this.cQK = null;
        this.fAZ = false;
        this.fBa = false;
        this.postID = null;
        this.fBd = null;
        this.fBe = 0L;
        this.fBf = false;
        this.fBg = -1;
        this.fBi = false;
        this.fBt = false;
        this.fBu = 0;
        this.fBB = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.fBc = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.baV() != null) {
                        pbData.baV().bQ(0);
                    }
                    if (PbModel.this.fAT != null && pbData != null) {
                        com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fAT.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fBC = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().baT() != null && PbModel.this.getPbData().baT().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().baT().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fBD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.jD()) {
                        PbModel.this.bmt.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.fAZ || !PbModel.this.fBa) {
                        if (!PbModel.this.fAZ) {
                            PbModel.this.fAZ = true;
                        } else {
                            PbModel.this.fBa = true;
                        }
                        if (PbModel.this.fAT != null) {
                            PbModel.this.fAT.a(PbModel.this.bdM(), z, responsedMessage, PbModel.this.fBb, System.currentTimeMillis() - PbModel.this.dAv);
                        }
                    }
                }
            }
        };
        this.fBE = null;
        registerListener(this.fBB);
        registerListener(this.fBD);
        registerListener(this.fBC);
        this.fAN = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bmt = baseActivity;
        this.fBk = new x(this, this.bmt);
        this.fBl = new h(this, this.bmt);
        this.fBm = new m(this, this.bmt);
        this.fBn = new r(this, getUniqueId());
        this.fBo = new z(this, this.bmt);
        this.cbx = new CheckRealNameModel(this.bmt.getPageContext());
        this.fBr = new SuggestEmotionModel();
        this.fBq = new AddExperiencedModel(this.bmt.getPageContext());
    }

    protected int bdM() {
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
        this.fAv = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fAv)) {
            this.fAv = this.fBk.U(intent);
            if (StringUtils.isNull(this.fAv) && intent.getData() != null) {
                this.fAv = intent.getData().getQueryParameter("thread_id");
            }
        }
        this.fBu = intent.getIntExtra("key_start_from", 0);
        if (this.fBu == 0) {
            this.fBu = this.fBk.fBK;
        }
        this.fAx = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.mFromForumId = intent.getStringExtra("from_forum_id");
        this.fAw = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fAy = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fAz = intent.getBooleanExtra("host_only", false);
        this.fAB = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fAD = intent.getIntExtra("is_top", 0);
        this.fAE = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fAJ = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eEY = intent.getBooleanExtra("is_sub_pb", false);
        this.fAL = intent.getBooleanExtra("is_pv", false);
        this.fAK = intent.getLongExtra("msg_id", 0L);
        this.fAM = intent.getStringExtra("from_forum_name");
        this.fAV = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fAU = intent.getStringExtra("op_stat");
        this.fAP = intent.getBooleanExtra("is_from_thread_config", false);
        this.fAQ = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fAR = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fAX = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fAW = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fAI = intent.getBooleanExtra("from_frs", false);
        this.eUP = intent.getBooleanExtra("from_maintab", false);
        this.fBi = intent.getBooleanExtra("from_smart_frs", false);
        this.fAS = intent.getBooleanExtra("from_hottopic", false);
        this.fBp = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fBu = bundle.getInt("key_start_from", 0);
        this.fAv = bundle.getString("thread_id");
        this.fAx = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.fAw = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fAy = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fAz = bundle.getBoolean("host_only", false);
        this.fAB = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fAD = bundle.getInt("is_top", 0);
        this.fAE = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fAJ = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eEY = bundle.getBoolean("is_sub_pb", false);
        this.fAL = bundle.getBoolean("is_pv", false);
        this.fAK = bundle.getLong("msg_id", 0L);
        this.fAM = bundle.getString("from_forum_name");
        this.fAV = bundle.getString("extra_pb_cache_key");
        this.fAP = bundle.getBoolean("is_from_thread_config", false);
        this.fAQ = bundle.getBoolean("is_from_interview_live_config", false);
        this.fAR = bundle.getBoolean("is_from_my_god_config", false);
        this.fAX = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fAW = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fAI = bundle.getBoolean("from_frs", false);
        this.eUP = bundle.getBoolean("from_maintab", false);
        this.fBi = bundle.getBoolean("from_smart_frs", false);
        this.fAS = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void z(Bundle bundle) {
        bundle.putString("thread_id", this.fAv);
        bundle.putString("post_id", this.fAx);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.fBu);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fAy);
        bundle.putBoolean("host_only", this.fAz);
        bundle.putBoolean("squence", this.fAB);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fAD);
        bundle.putLong("thread_time", this.fAE);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fAJ);
        bundle.putBoolean("is_sub_pb", this.eEY);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fAL);
        bundle.putLong("msg_id", this.fAK);
        bundle.putString("extra_pb_cache_key", this.fAV);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fAP);
        bundle.putBoolean("is_from_interview_live_config", this.fAQ);
        bundle.putBoolean("is_from_my_god_config", this.fAR);
        bundle.putInt("extra_pb_is_attention_key", this.fAX);
        bundle.putInt("extra_pb_funs_count_key", this.fAW);
        bundle.putBoolean("from_frs", this.fAI);
        bundle.putBoolean("from_maintab", this.eUP);
        bundle.putBoolean("from_smart_frs", this.fBi);
        bundle.putBoolean("from_hottopic", this.fAS);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bdN() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fAv);
        if (!this.fAJ) {
            sb.append(this.fAx);
        }
        sb.append(this.fAz);
        sb.append(this.fAB);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fAD);
        sb.append(this.fAE);
        sb.append(this.fAI);
        sb.append(this.eUP);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eEY);
        sb.append(this.fAL);
        sb.append(this.fAK);
        sb.append(this.fAM);
        sb.append(this.mThreadType);
        sb.append(this.fAP);
        sb.append(this.fAQ);
        sb.append(this.fAR);
        if (this.fAV != null) {
            sb.append(this.fAV);
        }
        return sb.toString();
    }

    public String bdO() {
        return this.fAM;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.fAx;
    }

    public String bdP() {
        return this.fAv;
    }

    public boolean getHostMode() {
        return this.fAz;
    }

    public boolean bdQ() {
        return this.fAB;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bdR() {
        return this.fAI;
    }

    public boolean bdS() {
        return this.fAC;
    }

    public boolean bdT() {
        return this.eUP;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bdU() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bdV() {
        return this.fAD;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void iX(int i) {
        this.fAD = i;
    }

    public boolean bdW() {
        return this.eEY;
    }

    public boolean bdX() {
        if (this.fAN == null) {
            return false;
        }
        return this.fAN.isValid();
    }

    public String vF() {
        if (this.fAN == null || !this.fAN.sc()) {
            return null;
        }
        return this.fAN.sb();
    }

    public boolean qG(int i) {
        this.fAF = i;
        if (this.fAF > this.fAN.uJ().uA()) {
            this.fAF = this.fAN.uJ().uA();
        }
        if (this.fAF < 1) {
            this.fAF = 1;
        }
        if (this.fAv == null) {
            return false;
        }
        return qI(5);
    }

    public void qH(int i) {
        this.fAF = i;
        this.fAG = i;
        this.fAH = i;
    }

    public void c(com.baidu.tbadk.core.data.am amVar) {
        if (amVar == null) {
            qH(1);
            return;
        }
        this.fAG = amVar.uD();
        this.fAH = amVar.uD();
        this.cCl = amVar.uA();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.fAN;
    }

    public com.baidu.tbadk.core.data.am getPageData() {
        if (this.fAN == null) {
            return null;
        }
        return this.fAN.uJ();
    }

    public boolean bdY() {
        if (this.fAB && this.fAN.uJ().uF() == 0) {
            kd(true);
            return true;
        }
        return false;
    }

    public void rh(String str) {
        if (!StringUtils.isNull(str)) {
            this.fAv = str;
            this.fAx = null;
            this.fAz = false;
            this.fAB = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fAv == null) {
            return false;
        }
        cancelLoadData();
        if (this.cQK == null) {
            this.cQK = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.cQK.start();
        }
        boolean qI = qI(3);
        if (this.opType != null) {
            this.opType = null;
            this.fAU = null;
            this.opUrl = null;
            return qI;
        }
        return qI;
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
        if (this.fBr != null) {
            this.fBr.cancelLoadData();
        }
        if (this.fBn != null) {
            this.fBn.cancelLoadData();
        }
        if (this.fBs != null) {
            this.fBs.cancelLoadData();
        }
        aoH();
    }

    private void aoH() {
        if (this.cQK != null) {
            this.cQK.destory();
            this.cQK = null;
        }
    }

    public boolean JW() {
        return (this.fAx == null || this.fAx.equals("0") || this.fAx.length() == 0) ? LoadData() : beb();
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
                this.fBr.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fBr.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fBs == null) {
                this.fBs = new GetSugMatchWordsModel(this.bmt.getPageContext());
            }
            this.fBs.b(aVar);
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
    public boolean qI(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        qJ(i);
        final com.baidu.tieba.pb.data.d pbData = aj.beX().getPbData();
        if (pbData != null && pbData.baV() != null) {
            pbData.baV().bQ(0);
            this.fAB = aj.beX().bdQ();
            this.fAz = aj.beX().bfc();
            this.fAC = aj.beX().bfd();
            this.fBw = aj.beX().bfb();
            this.fBx = aj.beX().bfa();
            this.fBy = aj.beX().beZ();
            this.fBt = this.fAz;
            if (this.fAz || this.isFromMark) {
                this.fAY = false;
            }
            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.fBc) {
            a(beg(), true, this.fAx, 3);
        }
        if (i == 3 && !this.fBc) {
            if (this.isFromMark) {
                a(beg(), true, this.fAx, 3);
            } else {
                a(beg(), false, this.fAx, 3);
            }
        }
        this.fBc = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aLk);
        if (this.fAz || this.isFromMark) {
            this.fAY = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fAv == null || this.fAv.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.fAv, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
        int aj = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.ar.zF().zH() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aj));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.fAB) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.fAz) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fAL) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fAK));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fAY) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.fAU, 0));
            pbPageRequestMessage.setOpMessageID(this.fAK);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> baX = this.fAN.baX();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.fAB) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fAH - 1));
                        if (this.fAH - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z) {
                                if (baX != null && baX.size() > 0) {
                                    size = baX.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = baX.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.fAx = postData.getId();
                                            if (StringUtils.isNull(this.fAx)) {
                                                i3 = i2 + 1;
                                            }
                                        }
                                        i2 = i3;
                                    }
                                }
                                if (this.fAx == null && this.fAx.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fAx, 0L));
                                } else if (!this.fAB) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            b(pbPageRequestMessage);
                            break;
                        }
                    } else {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fAG + 1));
                        if (this.fAG >= this.cCl) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (baX != null) {
                                size = baX.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                            }
                            if (this.fAx == null) {
                            }
                            if (!this.fAB) {
                            }
                            b(pbPageRequestMessage);
                        }
                    }
                }
                z = false;
                if (!this.isFromMark) {
                }
                if (baX != null) {
                }
                if (this.fAx == null) {
                }
                if (!this.fAB) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (baX != null && baX.size() > 0 && baX.get(0) != null) {
                    this.fAx = baX.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.fAB) {
                        if (this.fAH - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fAH - 1));
                        }
                    } else if (this.fAG < this.cCl) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fAG + 1));
                    }
                }
                if (this.fAx != null && this.fAx.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fAx, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fAz) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.fAB) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fAx, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fAF));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.fAB && this.fBt && !this.fAz) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fAx, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.fAz) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fBg);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fBv, 0L));
                if (!this.fAB) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fBt = this.fAz;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(beg());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fBu));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fBf);
        pbPageRequestMessage.setFromSmartFrs(this.fBi ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fAy);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bdb() {
        switch (bev()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().baV() == null || !getPbData().baV().wE();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bdO()) && com.baidu.tieba.recapp.r.boJ().boD() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.boJ().boD().R(bdO(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.boJ().boD().S(bdO(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bdO()) && com.baidu.tieba.recapp.r.boJ().boD() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.boJ().boD().S(bdO(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.boJ().boD().R(bdO(), true));
        }
    }

    protected void qJ(int i) {
        boolean z = false;
        qN(i);
        ArrayList<PostData> baX = this.fAN.baX();
        this.fBb = false;
        if (i == 1) {
            boolean z2 = false;
            while (baX.size() + 30 > com.baidu.tbadk.data.d.GV()) {
                baX.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fAN.uJ().bM(1);
                if (this.fAT != null) {
                    this.fAT.f(this.fAN);
                }
            }
            this.dAv = System.currentTimeMillis();
            this.fBb = true;
        } else if (i == 2) {
            while (baX.size() + 30 > com.baidu.tbadk.data.d.GV()) {
                baX.remove(baX.size() - 1);
                z = true;
            }
            if (z) {
                this.fAN.uJ().bL(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.fBj = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fAw)) {
            try {
                Long valueOf = Long.valueOf(this.fAw);
                com.baidu.tieba.pb.data.l bbg = dVar.bbg();
                if (bbg != null && bbg.ftr != null) {
                    if (bbg.ftr.isEmpty() || !bbg.ftr.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fAv);
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
            if (this.fAR || this.fAP || this.fAQ) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.baX().size(); i++) {
                PostData postData = dVar.baX().get(i);
                for (int i2 = 0; i2 < postData.bxz().size(); i2++) {
                    postData.bxz().get(i2).b(this.bmt.getPageContext(), l.equals(postData.bxz().get(i2).vw().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.l bbg = dVar.bbg();
            if (bbg != null && !com.baidu.tbadk.core.util.w.A(bbg.ftq)) {
                for (PostData postData2 : bbg.ftq) {
                    for (int i3 = 0; i3 < postData2.bxz().size(); i3++) {
                        postData2.bxz().get(i3).b(this.bmt.getPageContext(), l.equals(postData2.bxz().get(i3).vw().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.l bbg = dVar.bbg();
            if (bbg != null && !com.baidu.tbadk.core.util.w.A(bbg.ftq)) {
                for (PostData postData : bbg.ftq.subList(i, bbg.ftq.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bxz().size()) {
                            postData.bxz().get(i3).b(this.bmt.getPageContext(), l.equals(postData.bxz().get(i3).vw().getUserId()));
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
        bc baV = dVar.baV();
        baV.bU(this.mIsGood);
        baV.bT(this.fAD);
        if (this.fAE > 0) {
            baV.q(this.fAE);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.baV() != null && dVar.baV().vw() != null) {
            str = dVar.baV().vw().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bdZ() {
        if (this.fAN == null || this.fAN.baV() == null || this.fAN.baV().vw() == null) {
            return null;
        }
        return this.fAN.baV().vw();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fBh = z3;
        this.fAO = i;
        if (this.cQK != null && !z3) {
            this.cQK.a(z2, z4, i2, str, i3, j, j2);
            this.cQK = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bdO()) && com.baidu.tieba.recapp.r.boJ().boD() != null) {
            com.baidu.tieba.recapp.r.boJ().boD().f(bdO(), qK(getRequestType()), true);
        }
        if (dVar == null || (this.fAF == 1 && i == 5 && dVar.baX() != null && dVar.baX().size() < 1)) {
            if (this.fAT != null) {
                this.fAB = this.fAA;
                this.fAT.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fAA = this.fAB;
            this.fAL = false;
            if (dVar.uJ() != null) {
                c(dVar.uJ());
            }
            this.cCl = this.cCl < 1 ? 1 : this.cCl;
            ArrayList<PostData> baX = this.fAN.baX();
            switch (i) {
                case 1:
                    this.fAN.a(dVar.uJ(), 1);
                    e(dVar, baX);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.baX() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.baX().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.w.d(baX, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.w.d(dVar.baX(), com.baidu.tbadk.core.util.w.z(dVar.baX()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.baX().remove(postData2);
                            i6 = size - 1;
                        }
                        baX.addAll(0, dVar.baX());
                    }
                    this.fAN.a(dVar.uJ(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.fAB && dVar.uJ() != null) {
                        dVar.uJ().bJ(dVar.uJ().uA());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && this.fAB) {
                        bea();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.w.A(dVar.baX()) && this.fAN != null && (!this.fAz || l(dVar).equals(dVar.baX().get(0).vw().getUserId()))) {
                        if (this.fAN.uJ().uF() == 0) {
                            this.fAN.uJ().bL(1);
                        }
                        bew();
                        this.fBw = dVar.baX().get(0);
                        if (this.fAB) {
                            if (this.fAN.baX().size() - this.fBy >= 3) {
                                this.fBx = new PostData();
                                this.fBx.gNu = true;
                                this.fBx.setPostType(53);
                                this.fAN.baX().add(this.fBx);
                            }
                            this.fAN.baX().add(this.fBw);
                            i4 = this.fAN.baX().size() - 1;
                        } else {
                            if (this.fBy - this.fBz >= 3) {
                                this.fBx = new PostData();
                                this.fBx.gNu = false;
                                this.fBx.setPostType(53);
                                this.fAN.baX().add(0, this.fBx);
                            }
                            this.fAN.baX().add(0, this.fBw);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ap.S(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fBw.gNH = this.fAN.bbv();
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
            if (this.fAN != null && this.fAN.baV() != null) {
                PraiseData vj = this.fAN.baV().vj();
                if (this.fBE != null && !vj.isPriaseDataValid()) {
                    this.fAN.baV().a(this.fBE);
                } else {
                    this.fBE = this.fAN.baV().vj();
                    this.fBE.setPostId(this.fAN.baV().vM());
                }
                if (dVar.uJ() != null && dVar.uJ().uD() == 1 && dVar.baV() != null && dVar.baV().vH() != null && dVar.baV().vH().size() > 0) {
                    this.fAN.baV().l(dVar.baV().vH());
                }
                this.fAN.baV().bR(dVar.baV().vn());
                this.fAN.baV().bO(dVar.baV().getAnchorLevel());
                this.fAN.baV().bQ(dVar.baV().vf());
                if (this.mThreadType == 33) {
                    this.fAN.baV().vw().setHadConcerned(dVar.baV().vw().hadConcerned());
                }
                if (dVar != null && dVar.baV() != null) {
                    this.fAN.baV().bW(dVar.baV().vL());
                }
            }
            if (this.fAN != null && this.fAN.getUserData() != null && dVar.getUserData() != null) {
                this.fAN.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.fAN.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.uJ() != null && dVar.uJ().uD() == 1 && dVar.bbf() != null) {
                this.fAN.c(dVar.bbf());
            }
            if (this.fBh) {
                if (this.fAN.baV() != null && this.fAN.baV().vw() != null && this.fAN.baX() != null && com.baidu.tbadk.core.util.w.d(this.fAN.baX(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.w.d(this.fAN.baX(), 0);
                    MetaData vw = this.fAN.baV().vw();
                    if (postData3.vw() != null && postData3.vw().getGodUserData() != null) {
                        if (this.fAW != -1) {
                            vw.setFansNum(this.fAW);
                            postData3.vw().setFansNum(this.fAW);
                        }
                        if (this.fAX != -1) {
                            vw.getGodUserData().setIsLike(this.fAX == 1);
                            postData3.vw().getGodUserData().setIsLike(this.fAX == 1);
                            vw.getGodUserData().setIsFromNetWork(false);
                            postData3.vw().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fAN.fsN = -1;
                this.fAN.fsM = -1;
            }
            if (this.fAT != null) {
                this.fAT.a(true, getErrorCode(), i, i5, this.fAN, this.mErrorString, 1);
            }
        }
        if (this.fAN != null && this.fAN.baV() != null && this.fAN.baT() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bmt;
            historyMessage.threadId = getPbData().baV().getId();
            if (this.mIsShareThread && getPbData().baV().akk != null) {
                historyMessage.threadName = getPbData().baV().akk.showText;
            } else {
                historyMessage.threadName = getPbData().baV().getTitle();
            }
            if (this.mIsShareThread && !bdb()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().baT().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bdQ();
            historyMessage.threadType = getPbData().baV().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String ar;
        if (arrayList != null && dVar.baX() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.w.d(dVar.baX(), 0);
            if (postData != null && (ar = ar(arrayList)) != null && ar.equals(postData.getId())) {
                dVar.baX().remove(postData);
            }
            arrayList.addAll(dVar.baX());
        }
    }

    private int qK(int i) {
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

    private String ar(ArrayList<PostData> arrayList) {
        int z = com.baidu.tbadk.core.util.w.z(arrayList);
        if (z <= 0) {
            return null;
        }
        for (int i = z - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.w.d(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.tieba.pb.data.d dVar) {
        dVar.rg(this.fAN.bbn());
        this.fAN = dVar;
        qH(dVar.uJ().uD());
    }

    private void bea() {
        if (this.fAN != null && this.fAN.baX() != null && this.fAN.bbm() != null) {
            ArrayList<PostData> baX = this.fAN.baX();
            com.baidu.tieba.pb.data.a bbm = this.fAN.bbm();
            int baR = bbm.baR();
            if (baR > 0) {
                if (baR <= baX.size()) {
                    baX.add(baR, bbm);
                } else {
                    baX.add(bbm);
                }
            }
        }
    }

    public boolean beb() {
        if (this.fAv == null || this.fAx == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return qI(4);
        }
        return qI(6);
    }

    public boolean kd(boolean z) {
        if (this.fAv == null || this.fAN == null) {
            return false;
        }
        if (z || this.fAN.uJ().uF() != 0) {
            return qI(1);
        }
        return false;
    }

    public boolean ke(boolean z) {
        if (this.fAv == null || this.fAN == null) {
            return false;
        }
        if ((z || this.fAN.uJ().uG() != 0) && this.fAN.baX() != null && this.fAN.baX().size() >= 1) {
            return qI(2);
        }
        return false;
    }

    public boolean rm(String str) {
        this.fAz = !this.fAz;
        this.fAx = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (qI(6)) {
            return true;
        }
        this.fAz = this.fAz ? false : true;
        return false;
    }

    public boolean m(boolean z, String str) {
        if (this.fAz == z) {
            return false;
        }
        this.fAz = z;
        this.fAx = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (qI(6)) {
            return true;
        }
        this.fAz = z ? false : true;
        return false;
    }

    public boolean bec() {
        this.fAA = this.fAB;
        this.fAB = !this.fAB;
        if (this.isLoading || !LoadData()) {
            this.fAB = this.fAB ? false : true;
            return false;
        }
        return true;
    }

    public boolean bed() {
        return this.fAB;
    }

    public boolean hasData() {
        return (this.fAN == null || this.fAN.baT() == null || this.fAN.baV() == null) ? false : true;
    }

    public boolean sc() {
        if (this.fAN == null) {
            return false;
        }
        return this.fAN.sc();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gL(String str) {
        if (this.fAN == null || this.fAN.baV() == null || this.fAN.baT() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fAN.baV().wE()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fAN.baT().getId());
            writeData.setForumName(this.fAN.baT().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.fBu);
        writeData.setThreadId(this.fAv);
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

    public MarkData qL(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fAN == null) {
            return null;
        }
        ArrayList<PostData> baX = this.fAN.baX();
        if (com.baidu.tbadk.core.util.w.A(baX)) {
            return null;
        }
        if (baX.size() > 0 && i >= baX.size()) {
            i = baX.size() - 1;
        }
        return g(baX.get(i));
    }

    public MarkData bee() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fAv);
        markData.setPostId(this.fAN.sb());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fAz);
        markData.setSequence(Boolean.valueOf(this.fAB));
        markData.setId(this.fAv);
        return markData;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fAv);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fAz);
        markData.setSequence(Boolean.valueOf(this.fAB));
        markData.setId(this.fAv);
        markData.setFloor(postData.bxC());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bef() {
        g.bdy().K(beg(), this.isFromMark);
    }

    private String beg() {
        String str = this.fAv;
        if (this.fAz) {
            str = str + DB_KEY_HOST;
        }
        if (!this.fAB) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void kf(boolean z) {
        if (this.fAN != null) {
            this.fAN.ah(z);
        }
    }

    public void kg(boolean z) {
        this.fAY = z;
    }

    public boolean beh() {
        return this.fAY;
    }

    public void a(a aVar) {
        this.fAT = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String HT() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean HS() {
        return JW();
    }

    public boolean rn(String str) {
        if (getPbData() == null || getPbData().baV() == null || getPbData().baV().vw() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().baV().vw().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bei() {
        String beg = beg();
        g.bdy().K(beg, false);
        g.bdy().K(beg, true);
    }

    public void bej() {
        if ("personalize_page".equals(this.mStType)) {
            this.fBe = System.currentTimeMillis() / 1000;
        }
    }

    public void bek() {
        if ("personalize_page".equals(this.mStType) && this.fAN != null && this.fBe != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").ah(ImageViewerConfig.FORUM_ID, this.fAN.getForumId()).ah("tid", this.fAv).ah("obj_duration", String.valueOf(currentTimeMillis - this.fBe)).ah("obj_param3", String.valueOf(currentTimeMillis)));
            this.fBe = 0L;
        }
    }

    public boolean bel() {
        return this.fBh;
    }

    public int getErrorNo() {
        return this.fBj;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bem() {
        return this.fBl;
    }

    public m ben() {
        return this.fBm;
    }

    public r beo() {
        return this.fBn;
    }

    public z bep() {
        return this.fBo;
    }

    public CheckRealNameModel beq() {
        return this.cbx;
    }

    public AddExperiencedModel ber() {
        return this.fBq;
    }

    public String bes() {
        return this.fBd;
    }

    public void ro(String str) {
        this.fBd = str;
    }

    public boolean bet() {
        return this.fBi;
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.fAN != null && this.fAN.baX() != null && this.fAN.baX().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fAN.baX().size();
                for (int i = 0; i < size; i++) {
                    if (this.fAN.baX().get(i) != null && this.fAN.baX().get(i).vw() != null && currentAccount.equals(this.fAN.baX().get(i).vw().getUserId()) && this.fAN.baX().get(i).vw().getPendantData() != null) {
                        this.fAN.baX().get(i).vw().getPendantData().dm(iVar.uh());
                        this.fAN.baX().get(i).vw().getPendantData().X(iVar.Hd());
                    }
                }
            }
        }
    }

    public String beu() {
        return this.fBp;
    }

    public int bev() {
        return this.fBu;
    }

    public void qM(int i) {
        this.fBu = i;
    }

    public void rp(String str) {
        if ((!this.fAz || rn(TbadkCoreApplication.getCurrentAccount())) && this.fAN.baX() != null) {
            this.fAN.uJ().bL(1);
            if (this.fAN.uJ().uF() == 0) {
                this.fAN.uJ().bL(1);
            }
            this.fBv = str;
            qI(8);
        }
    }

    private void qN(int i) {
        if (i != 8) {
            this.fBv = "";
            if (this.fBw != null) {
                if (i == 1 && !this.fAB && !com.baidu.tbadk.core.util.w.A(getPbData().baX())) {
                    getPbData().baX().remove(this.fBw);
                    if (this.fBx != null) {
                        getPbData().baX().remove(this.fBx);
                    }
                    getPbData().baX().add(0, this.fBw);
                } else {
                    getPbData().baX().remove(this.fBw);
                    if (this.fBx != null) {
                        getPbData().baX().remove(this.fBx);
                    }
                }
            }
            this.fBx = null;
        }
    }

    public void bew() {
        if (this.fAN != null && !com.baidu.tbadk.core.util.w.A(this.fAN.baX())) {
            if (this.fBx != null) {
                this.fAN.baX().remove(this.fBx);
                this.fBx = null;
            }
            if (this.fBw != null) {
                this.fAN.baX().remove(this.fBw);
                this.fBw = null;
            }
        }
    }

    public void bp(int i, int i2) {
        this.fBy = i;
        this.fBz = i2;
    }

    public PostData bex() {
        return this.fBw;
    }

    public PostData bey() {
        return this.fBx;
    }

    public int bez() {
        return this.fBy;
    }

    public String beA() {
        return this.fBA;
    }

    public void rq(String str) {
        this.fBA = str;
    }
}
