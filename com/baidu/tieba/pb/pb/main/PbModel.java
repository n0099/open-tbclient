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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.share.AddExperiencedModel;
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
    private BaseActivity cmZ;
    private final CheckRealNameModel cwt;
    private long dPx;
    private int dal;
    private com.baidu.tieba.tbadkCore.d.b dnn;
    protected String fMI;
    private String fMJ;
    private String fMK;
    private boolean fML;
    private boolean fMM;
    private boolean fMN;
    private boolean fMO;
    private boolean fMP;
    private int fMQ;
    private long fMR;
    private int fMS;
    private int fMT;
    private int fMU;
    private boolean fMV;
    private boolean fMW;
    private boolean fMX;
    private long fMY;
    private boolean fMZ;
    private final o fNA;
    private final PbFloorAgreeModel fNB;
    private final z fNC;
    private String fND;
    private final AddExperiencedModel fNE;
    private SuggestEmotionModel fNF;
    private GetSugMatchWordsModel fNG;
    private boolean fNH;
    private int fNI;
    private String fNJ;
    private PostData fNK;
    private PostData fNL;
    private int fNM;
    private int fNN;
    private String fNO;
    private CustomMessageListener fNP;
    private CustomMessageListener fNQ;
    private com.baidu.adp.framework.listener.a fNR;
    private PraiseData fNS;
    private String fNa;
    protected com.baidu.tieba.pb.data.f fNb;
    private int fNc;
    private boolean fNd;
    private boolean fNe;
    private boolean fNf;
    private boolean fNg;
    private a fNh;
    private String fNi;
    private String fNj;
    private int fNk;
    private int fNl;
    private boolean fNm;
    private boolean fNn;
    private boolean fNo;
    private boolean fNp;
    private boolean fNq;
    private String fNr;
    private long fNs;
    private boolean fNt;
    private int fNu;
    private boolean fNv;
    private boolean fNw;
    private int fNx;
    private final x fNy;
    private final j fNz;
    private boolean fgq;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private com.baidu.tieba.pb.data.e mAppealInfo;
    protected Context mContext;
    private String mForumId;
    private int mIsGood;
    private boolean mIsShareThread;
    private String mLocate;
    private int mRequestType;
    public String mStType;
    protected int mThreadType;
    private String opType;
    private String opUrl;
    private String postID;
    private static final int fMH = com.baidu.tbadk.data.d.JQ() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.f fVar);
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.fMI = null;
        this.fMJ = null;
        this.fMK = null;
        this.mForumId = null;
        this.fML = false;
        this.fMM = false;
        this.fMN = true;
        this.fMO = true;
        this.fMP = false;
        this.mIsGood = 0;
        this.fMQ = 0;
        this.fMR = 0L;
        this.fMS = 1;
        this.fMT = 1;
        this.fMU = 1;
        this.dal = 1;
        this.isAd = false;
        this.fMV = false;
        this.fMW = false;
        this.fgq = false;
        this.isFromMark = false;
        this.fMX = false;
        this.fMY = 0L;
        this.fMZ = false;
        this.fNa = null;
        this.fNb = null;
        this.isLoading = false;
        this.fNd = false;
        this.fNe = false;
        this.fNf = false;
        this.fNg = false;
        this.mLocate = null;
        this.mContext = null;
        this.fNh = null;
        this.opType = null;
        this.opUrl = null;
        this.fNi = null;
        this.fNj = null;
        this.fNk = -1;
        this.fNl = -1;
        this.dnn = null;
        this.fNn = false;
        this.fNo = false;
        this.postID = null;
        this.fNr = null;
        this.fNs = 0L;
        this.fNt = false;
        this.fNu = -1;
        this.fNw = false;
        this.fNH = false;
        this.fNI = 0;
        this.fNP = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.fNq = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.aYL() != null) {
                        pbData.aYL().eO(0);
                    }
                    if (PbModel.this.fNh != null && pbData != null) {
                        com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fNh.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fNQ = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aYJ() != null && PbModel.this.getPbData().aYJ().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aYJ().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fNR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.oJ()) {
                        PbModel.this.cmZ.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.fNn || !PbModel.this.fNo) {
                        if (!PbModel.this.fNn) {
                            PbModel.this.fNn = true;
                        } else {
                            PbModel.this.fNo = true;
                        }
                        if (PbModel.this.fNh != null) {
                            PbModel.this.fNh.a(PbModel.this.bbH(), z, responsedMessage, PbModel.this.fNp, System.currentTimeMillis() - PbModel.this.dPx);
                        }
                    }
                }
            }
        };
        this.fNS = null;
        registerListener(this.fNP);
        registerListener(this.fNR);
        registerListener(this.fNQ);
        this.fNb = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.cmZ = baseActivity;
        this.fNy = new x(this, this.cmZ);
        this.fNz = new j(this, this.cmZ);
        this.fNA = new o(this, this.cmZ);
        this.fNB = new PbFloorAgreeModel(this);
        this.fNC = new z(this, this.cmZ);
        this.cwt = new CheckRealNameModel(this.cmZ.getPageContext());
        this.fNF = new SuggestEmotionModel();
        this.fNE = new AddExperiencedModel(this.cmZ.getPageContext());
    }

    protected int bbH() {
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
        this.fMI = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fMI)) {
            this.fMI = this.fNy.X(intent);
        }
        this.fNI = intent.getIntExtra("key_start_from", 0);
        if (this.fNI == 0) {
            this.fNI = this.fNy.fNY;
        }
        this.fMK = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.fMJ = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fML = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fMM = intent.getBooleanExtra("host_only", false);
        this.fMO = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fMQ = intent.getIntExtra("is_top", 0);
        this.fMR = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fMX = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.fMV = intent.getBooleanExtra("is_sub_pb", false);
        this.fMZ = intent.getBooleanExtra("is_pv", false);
        this.fMY = intent.getLongExtra("msg_id", 0L);
        this.fNa = intent.getStringExtra("from_forum_name");
        this.fNj = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fNi = intent.getStringExtra("op_stat");
        this.fNd = intent.getBooleanExtra("is_from_thread_config", false);
        this.fNe = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fNf = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fNl = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fNk = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fMW = intent.getBooleanExtra("from_frs", false);
        this.fgq = intent.getBooleanExtra("from_maintab", false);
        this.fNw = intent.getBooleanExtra("from_smart_frs", false);
        this.fNg = intent.getBooleanExtra("from_hottopic", false);
        this.fND = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fNI = bundle.getInt("key_start_from", 0);
        this.fMI = bundle.getString("thread_id");
        this.fMK = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.fMJ = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fML = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fMM = bundle.getBoolean("host_only", false);
        this.fMO = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fMQ = bundle.getInt("is_top", 0);
        this.fMR = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fMX = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.fMV = bundle.getBoolean("is_sub_pb", false);
        this.fMZ = bundle.getBoolean("is_pv", false);
        this.fMY = bundle.getLong("msg_id", 0L);
        this.fNa = bundle.getString("from_forum_name");
        this.fNj = bundle.getString("extra_pb_cache_key");
        this.fNd = bundle.getBoolean("is_from_thread_config", false);
        this.fNe = bundle.getBoolean("is_from_interview_live_config", false);
        this.fNf = bundle.getBoolean("is_from_my_god_config", false);
        this.fNl = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fNk = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fMW = bundle.getBoolean("from_frs", false);
        this.fgq = bundle.getBoolean("from_maintab", false);
        this.fNw = bundle.getBoolean("from_smart_frs", false);
        this.fNg = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void x(Bundle bundle) {
        bundle.putString("thread_id", this.fMI);
        bundle.putString("post_id", this.fMK);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt("key_start_from", this.fNI);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fML);
        bundle.putBoolean("host_only", this.fMM);
        bundle.putBoolean("squence", this.fMO);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fMQ);
        bundle.putLong("thread_time", this.fMR);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fMX);
        bundle.putBoolean("is_sub_pb", this.fMV);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fMZ);
        bundle.putLong("msg_id", this.fMY);
        bundle.putString("extra_pb_cache_key", this.fNj);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fNd);
        bundle.putBoolean("is_from_interview_live_config", this.fNe);
        bundle.putBoolean("is_from_my_god_config", this.fNf);
        bundle.putInt("extra_pb_is_attention_key", this.fNl);
        bundle.putInt("extra_pb_funs_count_key", this.fNk);
        bundle.putBoolean("from_frs", this.fMW);
        bundle.putBoolean("from_maintab", this.fgq);
        bundle.putBoolean("from_smart_frs", this.fNw);
        bundle.putBoolean("from_hottopic", this.fNg);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bbI() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fMI);
        if (!this.fMX) {
            sb.append(this.fMK);
        }
        sb.append(this.fMM);
        sb.append(this.fMO);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fMQ);
        sb.append(this.fMR);
        sb.append(this.fMW);
        sb.append(this.fgq);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.fMV);
        sb.append(this.fMZ);
        sb.append(this.fMY);
        sb.append(this.fNa);
        sb.append(this.mThreadType);
        sb.append(this.fNd);
        sb.append(this.fNe);
        sb.append(this.fNf);
        if (this.fNj != null) {
            sb.append(this.fNj);
        }
        return sb.toString();
    }

    public String bbJ() {
        return this.fNa;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.fMK;
    }

    public String bbK() {
        return this.fMI;
    }

    public boolean getHostMode() {
        return this.fMM;
    }

    public boolean bbL() {
        return this.fMO;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bbM() {
        return this.fMW;
    }

    public boolean bbN() {
        return this.fMP;
    }

    public boolean bbO() {
        return this.fgq;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bbP() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bbQ() {
        return this.fMQ;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void lR(int i) {
        this.fMQ = i;
    }

    public boolean bbR() {
        return this.fMV;
    }

    public boolean bbS() {
        if (this.fNb == null) {
            return false;
        }
        return this.fNb.isValid();
    }

    public String zd() {
        if (this.fNb == null || !this.fNb.vl()) {
            return null;
        }
        return this.fNb.vk();
    }

    public boolean sN(int i) {
        this.fMS = i;
        if (this.fMS > this.fNb.xZ().xQ()) {
            this.fMS = this.fNb.xZ().xQ();
        }
        if (this.fMS < 1) {
            this.fMS = 1;
        }
        if (this.fMI == null) {
            return false;
        }
        return sQ(5);
    }

    public void sO(int i) {
        this.fMS = i;
        this.fMT = i;
        this.fMU = i;
    }

    public void sP(int i) {
        if (this.fMT < i) {
            this.fMT = i;
            if (this.fMT - this.fMU >= fMH) {
                this.fMU = (this.fMT - fMH) + 1;
            }
        }
        if (this.fMU > i) {
            this.fMU = i;
            if (this.fMT - this.fMU >= fMH) {
                this.fMT = (this.fMU + fMH) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.fNb;
    }

    public com.baidu.tbadk.core.data.al aCV() {
        if (this.fNb == null) {
            return null;
        }
        return this.fNb.xZ();
    }

    public boolean bbT() {
        if (this.fMO && this.fNb.xZ().xV() == 0) {
            kc(true);
            return true;
        }
        return false;
    }

    public void qd(String str) {
        if (!StringUtils.isNull(str)) {
            this.fMI = str;
            this.fMK = null;
            this.fMM = false;
            this.fMO = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fMI == null) {
            return false;
        }
        cancelLoadData();
        if (this.dnn == null) {
            this.dnn = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.dnn.start();
        }
        boolean sQ = sQ(3);
        if (this.opType != null) {
            this.opType = null;
            this.fNi = null;
            this.opUrl = null;
            return sQ;
        }
        return sQ;
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
        if (this.fNF != null) {
            this.fNF.cancelLoadData();
        }
        if (this.fNB != null) {
            this.fNB.cancelLoadData();
        }
        if (this.fNG != null) {
            this.fNG.cancelLoadData();
        }
        aqd();
    }

    private void aqd() {
        if (this.dnn != null) {
            this.dnn.destory();
            this.dnn = null;
        }
    }

    public boolean MQ() {
        return (this.fMK == null || this.fMK.equals("0") || this.fMK.length() == 0) ? LoadData() : bbW();
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
                this.fNF.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fNF.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fNG == null) {
                this.fNG = new GetSugMatchWordsModel(this.cmZ.getPageContext());
            }
            this.fNG.b(aVar);
        }
    }

    public boolean sQ(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        sR(i);
        final com.baidu.tieba.pb.data.f pbData = aj.bcS().getPbData();
        if (pbData != null && pbData.aYL() != null) {
            pbData.aYL().eO(0);
            this.fMO = aj.bcS().bbL();
            this.fMM = aj.bcS().bcX();
            this.fMP = aj.bcS().bcY();
            this.fNK = aj.bcS().bcW();
            this.fNL = aj.bcS().bcV();
            this.fNM = aj.bcS().bcU();
            this.fNH = this.fMM;
            if (this.fMM || this.isFromMark) {
                this.fNm = false;
            }
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.fNq) {
            a(bcb(), true, this.fMK, 3);
        }
        if (i == 3 && !this.fNq) {
            if (this.isFromMark) {
                a(bcb(), true, this.fMK, 3);
            } else {
                a(bcb(), false, this.fMK, 3);
            }
        }
        this.fNq = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.bpn);
        if (this.fMM || this.isFromMark) {
            this.fNm = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fMI == null || this.fMI.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.fMI, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.an.CK().CM() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ao));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aq));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.fMO) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.fMM) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fMZ) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fMY));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fNm) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.h(this.fNi, 0));
            pbPageRequestMessage.setOpMessageID(this.fMY);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aYN = this.fNb.aYN();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.fMO) {
                        if (this.fMU - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fMU - 1));
                        }
                    } else if (this.fMT < this.dal) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fMT + 1));
                    }
                }
                if (aYN != null && aYN.size() > 0) {
                    int size = aYN.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aYN.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.fMK = postData.getId();
                            if (StringUtils.isNull(this.fMK)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.fMK != null && this.fMK.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fMK, 0L));
                } else if (!this.fMO) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aYN != null && aYN.size() > 0 && aYN.get(0) != null) {
                    this.fMK = aYN.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.fMO) {
                        if (this.fMU - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fMU - 1));
                        }
                    } else if (this.fMT < this.dal) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fMT + 1));
                    }
                }
                if (this.fMK != null && this.fMK.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fMK, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fMM) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.fMO) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fMK, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fMS));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.fMO && this.fNH && !this.fMM) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fMK, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.fMM) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fNu);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fNJ, 0L));
                if (!this.fMO) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fNH = this.fMM;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bcb());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fNI));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fNt);
        pbPageRequestMessage.setFromSmartFrs(this.fNw ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fML);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean baY() {
        switch (bcq()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().aYL() == null || !getPbData().aYL().Ad();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bbJ()) && com.baidu.tieba.recapp.q.bmS().bmM() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.bmS().bmM().W(bbJ(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.bmS().bmM().X(bbJ(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bbJ()) && com.baidu.tieba.recapp.q.bmS().bmM() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.bmS().bmM().X(bbJ(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.bmS().bmM().W(bbJ(), true));
        }
    }

    protected void sR(int i) {
        boolean z = false;
        sV(i);
        ArrayList<PostData> aYN = this.fNb.aYN();
        this.fNp = false;
        if (i == 1) {
            boolean z2 = false;
            while (aYN.size() + 30 > com.baidu.tbadk.data.d.JQ()) {
                aYN.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fNb.xZ().eK(1);
                if (this.fNh != null) {
                    this.fNh.f(this.fNb);
                }
            }
            this.dPx = System.currentTimeMillis();
            this.fNp = true;
        } else if (i == 2) {
            while (aYN.size() + 30 > com.baidu.tbadk.data.d.JQ()) {
                aYN.remove(aYN.size() - 1);
                z = true;
            }
            if (z) {
                this.fNb.xZ().eJ(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.fNx = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            i(fVar2);
            h(fVar2);
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.f fVar) {
        Long l;
        if (fVar != null && !StringUtils.isNull(this.fMJ)) {
            try {
                Long valueOf = Long.valueOf(this.fMJ);
                com.baidu.tieba.pb.data.n aYW = fVar.aYW();
                if (aYW != null && aYW.fET != null) {
                    if (aYW.fET.isEmpty() || !aYW.fET.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fMI);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            l = null;
                        }
                        if (l != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_GOD_REPLY, l));
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

    protected void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            if (this.fNf || this.fNd || this.fNe) {
                fVar = k(fVar);
            }
            j(fVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String l = l(fVar);
            for (int i = 0; i < fVar.aYN().size(); i++) {
                PostData postData = fVar.aYN().get(i);
                for (int i2 = 0; i2 < postData.bvG().size(); i2++) {
                    postData.bvG().get(i2).b(this.cmZ.getPageContext(), l.equals(postData.bvG().get(i2).yT().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n aYW = fVar.aYW();
            if (aYW != null && !com.baidu.tbadk.core.util.v.E(aYW.fES)) {
                for (PostData postData2 : aYW.fES) {
                    for (int i3 = 0; i3 < postData2.bvG().size(); i3++) {
                        postData2.bvG().get(i3).b(this.cmZ.getPageContext(), l.equals(postData2.bvG().get(i3).yT().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String l = l(fVar);
            com.baidu.tieba.pb.data.n aYW = fVar.aYW();
            if (aYW != null && !com.baidu.tbadk.core.util.v.E(aYW.fES)) {
                for (PostData postData : aYW.fES.subList(i, aYW.fES.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bvG().size()) {
                            postData.bvG().get(i3).b(this.cmZ.getPageContext(), l.equals(postData.bvG().get(i3).yT().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.f k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null) {
            return null;
        }
        bd aYL = fVar.aYL();
        aYL.eS(this.mIsGood);
        aYL.eR(this.fMQ);
        if (this.fMR > 0) {
            aYL.v(this.fMR);
            return fVar;
        }
        return fVar;
    }

    protected String l(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aYL() != null && fVar.aYL().yT() != null) {
            str = fVar.aYL().yT().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bbU() {
        if (this.fNb == null || this.fNb.aYL() == null || this.fNb.aYL().yT() == null) {
            return null;
        }
        return this.fNb.aYL().yT();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fNv = z3;
        this.fNc = i;
        if (this.dnn != null && !z3) {
            this.dnn.a(z2, z4, i2, str, i3, j, j2);
            this.dnn = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bbJ()) && com.baidu.tieba.recapp.q.bmS().bmM() != null) {
            com.baidu.tieba.recapp.q.bmS().bmM().f(bbJ(), sS(getRequestType()), true);
        }
        if (fVar == null || (this.fMS == 1 && i == 5 && fVar.aYN() != null && fVar.aYN().size() < 1)) {
            if (this.fNh != null) {
                this.fMO = this.fMN;
                this.fNh.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fMN = this.fMO;
            this.fMZ = false;
            if (fVar.xZ() != null) {
                sP(fVar.xZ().xT());
                this.dal = fVar.xZ().xQ();
            }
            this.dal = this.dal < 1 ? 1 : this.dal;
            ArrayList<PostData> aYN = this.fNb.aYN();
            switch (i) {
                case 1:
                    this.fNb.a(fVar.xZ(), 1);
                    e(fVar, aYN);
                    i5 = 0;
                    break;
                case 2:
                    if (fVar.aYN() == null) {
                        i6 = 0;
                    } else {
                        int size = fVar.aYN().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(aYN, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.f(fVar.aYN(), com.baidu.tbadk.core.util.v.D(fVar.aYN()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            fVar.aYN().remove(postData2);
                            i6 = size - 1;
                        }
                        aYN.addAll(0, fVar.aYN());
                    }
                    this.fNb.a(fVar.xZ(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.fMO && fVar.xZ() != null) {
                        fVar.xZ().eH(fVar.xZ().xQ());
                    }
                    m(fVar);
                    if (!z3 && this.mThreadType != 33 && this.fMO) {
                        bbV();
                        i5 = 0;
                        break;
                    }
                    i5 = 0;
                    break;
                case 4:
                    m(fVar);
                    i5 = 0;
                    break;
                case 5:
                    m(fVar);
                    i5 = 0;
                    break;
                case 6:
                    m(fVar);
                    i5 = 0;
                    break;
                case 7:
                    m(fVar);
                    i5 = 0;
                    break;
                case 8:
                    if (fVar != null && !com.baidu.tbadk.core.util.v.E(fVar.aYN()) && this.fNb != null && (!this.fMM || l(fVar).equals(fVar.aYN().get(0).yT().getUserId()))) {
                        if (this.fNb.xZ().xV() == 0) {
                            this.fNb.xZ().eJ(1);
                        }
                        bcr();
                        this.fNK = fVar.aYN().get(0);
                        if (this.fMO) {
                            if (this.fNb.aYN().size() - this.fNM >= 3) {
                                this.fNL = new PostData();
                                this.fNL.gZa = true;
                                this.fNL.setPostType(53);
                                this.fNb.aYN().add(this.fNL);
                            }
                            this.fNb.aYN().add(this.fNK);
                            i4 = this.fNb.aYN().size() - 1;
                        } else {
                            if (this.fNM - this.fNN >= 3) {
                                this.fNL = new PostData();
                                this.fNL.gZa = false;
                                this.fNL.setPostType(53);
                                this.fNb.aYN().add(0, this.fNL);
                            }
                            this.fNb.aYN().add(0, this.fNK);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.am.W(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fNK.gZn = this.fNb.aZk();
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
            if (this.fNb != null && this.fNb.aYL() != null) {
                PraiseData yI = this.fNb.aYL().yI();
                if (this.fNS != null && !yI.isPriaseDataValid()) {
                    this.fNb.aYL().a(this.fNS);
                } else {
                    this.fNS = this.fNb.aYL().yI();
                    this.fNS.setPostId(this.fNb.aYL().zk());
                }
                if (fVar.xZ() != null && fVar.xZ().xT() == 1 && fVar.aYL() != null && fVar.aYL().zf() != null && fVar.aYL().zf().size() > 0) {
                    this.fNb.aYL().i(fVar.aYL().zf());
                }
                this.fNb.aYL().eP(fVar.aYL().yL());
                this.fNb.aYL().eM(fVar.aYL().getAnchorLevel());
                this.fNb.aYL().eO(fVar.aYL().yE());
                if (this.mThreadType == 33) {
                    this.fNb.aYL().yT().setHadConcerned(fVar.aYL().yT().hadConcerned());
                }
                if (fVar != null && fVar.aYL() != null) {
                    this.fNb.aYL().eU(fVar.aYL().zj());
                }
            }
            if (this.fNb != null && this.fNb.getUserData() != null && fVar.getUserData() != null) {
                this.fNb.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.fNb.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.xZ() != null && fVar.xZ().xT() == 1 && fVar.aYV() != null) {
                this.fNb.c(fVar.aYV());
            }
            if (this.fNv) {
                if (this.fNb.aYL() != null && this.fNb.aYL().yT() != null && this.fNb.aYN() != null && com.baidu.tbadk.core.util.v.f(this.fNb.aYN(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.f(this.fNb.aYN(), 0);
                    MetaData yT = this.fNb.aYL().yT();
                    if (postData3.yT() != null && postData3.yT().getGodUserData() != null) {
                        if (this.fNk != -1) {
                            yT.setFansNum(this.fNk);
                            postData3.yT().setFansNum(this.fNk);
                        }
                        if (this.fNl != -1) {
                            yT.getGodUserData().setIsLike(this.fNl == 1);
                            postData3.yT().getGodUserData().setIsLike(this.fNl == 1);
                            yT.getGodUserData().setIsFromNetWork(false);
                            postData3.yT().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fNb.fEn = -1;
                this.fNb.fEm = -1;
            }
            if (this.fNh != null) {
                this.fNh.a(true, getErrorCode(), i, i5, this.fNb, this.mErrorString, 1);
            }
        }
        if (this.fNb != null && this.fNb.aYL() != null && this.fNb.aYJ() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.cmZ;
            historyMessage.threadId = getPbData().aYL().getId();
            if (this.mIsShareThread && getPbData().aYL().aPc != null) {
                historyMessage.threadName = getPbData().aYL().aPc.showText;
            } else {
                historyMessage.threadName = getPbData().aYL().getTitle();
            }
            if (this.mIsShareThread && !baY()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().aYJ().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bbL();
            historyMessage.threadType = getPbData().aYL().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String al;
        if (arrayList != null && fVar.aYN() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(fVar.aYN(), 0);
            if (postData != null && (al = al(arrayList)) != null && al.equals(postData.getId())) {
                fVar.aYN().remove(postData);
            }
            arrayList.addAll(fVar.aYN());
        }
    }

    private int sS(int i) {
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

    private String al(ArrayList<PostData> arrayList) {
        int D = com.baidu.tbadk.core.util.v.D(arrayList);
        if (D <= 0) {
            return null;
        }
        for (int i = D - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.tieba.pb.data.f fVar) {
        fVar.qc(this.fNb.aZc());
        this.fNb = fVar;
        sO(fVar.xZ().xT());
    }

    private void bbV() {
        if (this.fNb != null && this.fNb.aYN() != null && this.fNb.aZb() != null) {
            ArrayList<PostData> aYN = this.fNb.aYN();
            com.baidu.tieba.pb.data.a aZb = this.fNb.aZb();
            int aYB = aZb.aYB();
            if (aYB > 0) {
                if (aYB <= aYN.size()) {
                    aYN.add(aYB, aZb);
                } else {
                    aYN.add(aZb);
                }
            }
        }
    }

    public boolean bbW() {
        if (this.fMI == null || this.fMK == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return sQ(4);
        }
        return sQ(6);
    }

    public boolean kc(boolean z) {
        if (this.fMI == null || this.fNb == null) {
            return false;
        }
        if (z || this.fNb.xZ().xV() != 0) {
            return sQ(1);
        }
        return false;
    }

    public boolean kd(boolean z) {
        if (this.fMI == null || this.fNb == null) {
            return false;
        }
        if ((z || this.fNb.xZ().xW() != 0) && this.fNb.aYN() != null && this.fNb.aYN().size() >= 1) {
            return sQ(2);
        }
        return false;
    }

    public boolean qi(String str) {
        this.fMM = !this.fMM;
        this.fMK = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (sQ(6)) {
            return true;
        }
        this.fMM = this.fMM ? false : true;
        return false;
    }

    public boolean j(boolean z, String str) {
        if (this.fMM == z) {
            return false;
        }
        this.fMM = z;
        this.fMK = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (sQ(6)) {
            return true;
        }
        this.fMM = z ? false : true;
        return false;
    }

    public boolean bbX() {
        this.fMN = this.fMO;
        this.fMO = !this.fMO;
        if (this.isLoading || !LoadData()) {
            this.fMO = this.fMO ? false : true;
            return false;
        }
        return true;
    }

    public boolean bbY() {
        return this.fMO;
    }

    public boolean hasData() {
        return (this.fNb == null || this.fNb.aYJ() == null || this.fNb.aYL() == null) ? false : true;
    }

    public boolean vl() {
        if (this.fNb == null) {
            return false;
        }
        return this.fNb.vl();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gi(String str) {
        if (this.fNb == null || this.fNb.aYL() == null || this.fNb.aYJ() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fNb.aYL().Ad()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fNb.aYJ().getId());
            writeData.setForumName(this.fNb.aYJ().getName());
        }
        writeData.sourceFrom = String.valueOf(this.fNI);
        writeData.setThreadId(this.fMI);
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

    public MarkData sT(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fNb == null) {
            return null;
        }
        ArrayList<PostData> aYN = this.fNb.aYN();
        if (com.baidu.tbadk.core.util.v.E(aYN)) {
            return null;
        }
        if (aYN.size() > 0 && i >= aYN.size()) {
            i = aYN.size() - 1;
        }
        return h(aYN.get(i));
    }

    public MarkData bbZ() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fMI);
        markData.setPostId(this.fNb.vk());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fMM);
        markData.setSequence(Boolean.valueOf(this.fMO));
        markData.setId(this.fMI);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fMI);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fMM);
        markData.setSequence(Boolean.valueOf(this.fMO));
        markData.setId(this.fMI);
        markData.setFloor(postData.bvJ());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bca() {
        i.bbs().P(bcb(), this.isFromMark);
    }

    private String bcb() {
        String str = this.fMI;
        if (this.fMM) {
            str = str + DB_KEY_HOST;
        }
        if (!this.fMO) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void ke(boolean z) {
        if (this.fNb != null) {
            this.fNb.aI(z);
        }
    }

    public void kf(boolean z) {
        this.fNm = z;
    }

    public boolean bcc() {
        return this.fNm;
    }

    public void a(a aVar) {
        this.fNh = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String KQ() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean KP() {
        return MQ();
    }

    public boolean qj(String str) {
        if (getPbData() == null || getPbData().aYL() == null || getPbData().aYL().yT() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aYL().yT().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bcd() {
        String bcb = bcb();
        i.bbs().P(bcb, false);
        i.bbs().P(bcb, true);
    }

    public void bce() {
        if ("personalize_page".equals(this.mStType)) {
            this.fNs = System.currentTimeMillis() / 1000;
        }
    }

    public void bcf() {
        if ("personalize_page".equals(this.mStType) && this.fNb != null && this.fNs != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").aa(ImageViewerConfig.FORUM_ID, this.fNb.getForumId()).aa("tid", this.fMI).aa("obj_duration", String.valueOf(currentTimeMillis - this.fNs)).aa("obj_param3", String.valueOf(currentTimeMillis)));
            this.fNs = 0L;
        }
    }

    public boolean bcg() {
        return this.fNv;
    }

    public int getErrorNo() {
        return this.fNx;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public j bch() {
        return this.fNz;
    }

    public o bci() {
        return this.fNA;
    }

    public PbFloorAgreeModel bcj() {
        return this.fNB;
    }

    public z bck() {
        return this.fNC;
    }

    public CheckRealNameModel bcl() {
        return this.cwt;
    }

    public AddExperiencedModel bcm() {
        return this.fNE;
    }

    public String bcn() {
        return this.fNr;
    }

    public void qk(String str) {
        this.fNr = str;
    }

    public boolean bco() {
        return this.fNw;
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fNb != null && this.fNb.aYN() != null && this.fNb.aYN().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fNb.aYN().size();
                for (int i = 0; i < size; i++) {
                    if (this.fNb.aYN().get(i) != null && this.fNb.aYN().get(i).yT() != null && currentAccount.equals(this.fNb.aYN().get(i).yT().getUserId()) && this.fNb.aYN().get(i).yT().getPendantData() != null) {
                        this.fNb.aYN().get(i).yT().getPendantData().cM(hVar.xu());
                        this.fNb.aYN().get(i).yT().getPendantData().ab(hVar.JY());
                    }
                }
            }
        }
    }

    public String bcp() {
        return this.fND;
    }

    public int bcq() {
        return this.fNI;
    }

    public void sU(int i) {
        this.fNI = i;
    }

    public void ql(String str) {
        if ((!this.fMM || qj(TbadkCoreApplication.getCurrentAccount())) && this.fNb.aYN() != null) {
            this.fNb.xZ().eJ(1);
            if (this.fNb.xZ().xV() == 0) {
                this.fNb.xZ().eJ(1);
            }
            this.fNJ = str;
            sQ(8);
        }
    }

    private void sV(int i) {
        if (i != 8) {
            this.fNJ = "";
            if (this.fNK != null) {
                if (i == 1 && !this.fMO && !com.baidu.tbadk.core.util.v.E(getPbData().aYN())) {
                    getPbData().aYN().remove(this.fNK);
                    if (this.fNL != null) {
                        getPbData().aYN().remove(this.fNL);
                    }
                    getPbData().aYN().add(0, this.fNK);
                } else {
                    getPbData().aYN().remove(this.fNK);
                    if (this.fNL != null) {
                        getPbData().aYN().remove(this.fNL);
                    }
                }
            }
            this.fNL = null;
        }
    }

    public void bcr() {
        if (this.fNb != null && !com.baidu.tbadk.core.util.v.E(this.fNb.aYN())) {
            if (this.fNL != null) {
                this.fNb.aYN().remove(this.fNL);
                this.fNL = null;
            }
            if (this.fNK != null) {
                this.fNb.aYN().remove(this.fNK);
                this.fNK = null;
            }
        }
    }

    public void cs(int i, int i2) {
        this.fNM = i;
        this.fNN = i2;
    }

    public PostData bcs() {
        return this.fNK;
    }

    public PostData bct() {
        return this.fNL;
    }

    public int bcu() {
        return this.fNM;
    }

    public String bcv() {
        return this.fNO;
    }

    public void qm(String str) {
        this.fNO = str;
    }
}
