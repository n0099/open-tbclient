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
    private BaseActivity bSC;
    private final CheckRealNameModel cAp;
    private long dSw;
    private int dcN;
    private com.baidu.tieba.tbadkCore.d.b dpV;
    private boolean eTQ;
    protected String fPG;
    private String fPH;
    private String fPI;
    private boolean fPJ;
    private boolean fPK;
    private boolean fPL;
    private boolean fPM;
    private boolean fPN;
    private int fPO;
    private long fPP;
    private int fPQ;
    private int fPR;
    private int fPS;
    private boolean fPT;
    private boolean fPU;
    private long fPV;
    private boolean fPW;
    private String fPX;
    protected com.baidu.tieba.pb.data.d fPY;
    private int fPZ;
    private String fQA;
    private final AddExperiencedModel fQB;
    private SuggestEmotionModel fQC;
    private GetSugMatchWordsModel fQD;
    private boolean fQE;
    private int fQF;
    private String fQG;
    private PostData fQH;
    private PostData fQI;
    private int fQJ;
    private int fQK;
    private String fQL;
    private CustomMessageListener fQM;
    private CustomMessageListener fQN;
    private com.baidu.adp.framework.listener.a fQO;
    private PraiseData fQP;
    private boolean fQa;
    private boolean fQb;
    private boolean fQc;
    private boolean fQd;
    private a fQe;
    private String fQf;
    private String fQg;
    private int fQh;
    private int fQi;
    private boolean fQj;
    private boolean fQk;
    private boolean fQl;
    private boolean fQm;
    private boolean fQn;
    private String fQo;
    private long fQp;
    private boolean fQq;
    private int fQr;
    private boolean fQs;
    private boolean fQt;
    private int fQu;
    private final w fQv;
    private final h fQw;
    private final m fQx;
    private final q fQy;
    private final y fQz;
    private boolean fjH;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private com.baidu.tieba.pb.data.c mAppealInfo;
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
    private static final int fPF = com.baidu.tbadk.data.d.Kv() / 30;
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
        this.fPG = null;
        this.fPH = null;
        this.fPI = null;
        this.mForumId = null;
        this.fPJ = false;
        this.fPK = false;
        this.fPL = true;
        this.fPM = true;
        this.fPN = false;
        this.mIsGood = 0;
        this.fPO = 0;
        this.fPP = 0L;
        this.fPQ = 1;
        this.fPR = 1;
        this.fPS = 1;
        this.dcN = 1;
        this.isAd = false;
        this.eTQ = false;
        this.fPT = false;
        this.fjH = false;
        this.isFromMark = false;
        this.fPU = false;
        this.fPV = 0L;
        this.fPW = false;
        this.fPX = null;
        this.fPY = null;
        this.isLoading = false;
        this.fQa = false;
        this.fQb = false;
        this.fQc = false;
        this.fQd = false;
        this.mLocate = null;
        this.mContext = null;
        this.fQe = null;
        this.opType = null;
        this.opUrl = null;
        this.fQf = null;
        this.fQg = null;
        this.fQh = -1;
        this.fQi = -1;
        this.dpV = null;
        this.fQk = false;
        this.fQl = false;
        this.postID = null;
        this.fQo = null;
        this.fQp = 0L;
        this.fQq = false;
        this.fQr = -1;
        this.fQt = false;
        this.fQE = false;
        this.fQF = 0;
        this.fQM = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.fQn = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.bat() != null) {
                        pbData.bat().eO(0);
                    }
                    if (PbModel.this.fQe != null && pbData != null) {
                        com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fQe.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fQN = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().bar() != null && PbModel.this.getPbData().bar().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().bar().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fQO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.oJ()) {
                        PbModel.this.bSC.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.fQk || !PbModel.this.fQl) {
                        if (!PbModel.this.fQk) {
                            PbModel.this.fQk = true;
                        } else {
                            PbModel.this.fQl = true;
                        }
                        if (PbModel.this.fQe != null) {
                            PbModel.this.fQe.a(PbModel.this.bdi(), z, responsedMessage, PbModel.this.fQm, System.currentTimeMillis() - PbModel.this.dSw);
                        }
                    }
                }
            }
        };
        this.fQP = null;
        registerListener(this.fQM);
        registerListener(this.fQO);
        registerListener(this.fQN);
        this.fPY = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bSC = baseActivity;
        this.fQv = new w(this, this.bSC);
        this.fQw = new h(this, this.bSC);
        this.fQx = new m(this, this.bSC);
        this.fQy = new q(this, getUniqueId());
        this.fQz = new y(this, this.bSC);
        this.cAp = new CheckRealNameModel(this.bSC.getPageContext());
        this.fQC = new SuggestEmotionModel();
        this.fQB = new AddExperiencedModel(this.bSC.getPageContext());
    }

    protected int bdi() {
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
        this.fPG = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fPG)) {
            this.fPG = this.fQv.V(intent);
        }
        this.fQF = intent.getIntExtra("key_start_from", 0);
        if (this.fQF == 0) {
            this.fQF = this.fQv.fQV;
        }
        this.fPI = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.fPH = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fPJ = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fPK = intent.getBooleanExtra("host_only", false);
        this.fPM = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fPO = intent.getIntExtra("is_top", 0);
        this.fPP = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fPU = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eTQ = intent.getBooleanExtra("is_sub_pb", false);
        this.fPW = intent.getBooleanExtra("is_pv", false);
        this.fPV = intent.getLongExtra("msg_id", 0L);
        this.fPX = intent.getStringExtra("from_forum_name");
        this.fQg = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fQf = intent.getStringExtra("op_stat");
        this.fQa = intent.getBooleanExtra("is_from_thread_config", false);
        this.fQb = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fQc = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fQi = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fQh = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fPT = intent.getBooleanExtra("from_frs", false);
        this.fjH = intent.getBooleanExtra("from_maintab", false);
        this.fQt = intent.getBooleanExtra("from_smart_frs", false);
        this.fQd = intent.getBooleanExtra("from_hottopic", false);
        this.fQA = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fQF = bundle.getInt("key_start_from", 0);
        this.fPG = bundle.getString("thread_id");
        this.fPI = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.fPH = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fPJ = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fPK = bundle.getBoolean("host_only", false);
        this.fPM = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fPO = bundle.getInt("is_top", 0);
        this.fPP = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fPU = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eTQ = bundle.getBoolean("is_sub_pb", false);
        this.fPW = bundle.getBoolean("is_pv", false);
        this.fPV = bundle.getLong("msg_id", 0L);
        this.fPX = bundle.getString("from_forum_name");
        this.fQg = bundle.getString("extra_pb_cache_key");
        this.fQa = bundle.getBoolean("is_from_thread_config", false);
        this.fQb = bundle.getBoolean("is_from_interview_live_config", false);
        this.fQc = bundle.getBoolean("is_from_my_god_config", false);
        this.fQi = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fQh = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fPT = bundle.getBoolean("from_frs", false);
        this.fjH = bundle.getBoolean("from_maintab", false);
        this.fQt = bundle.getBoolean("from_smart_frs", false);
        this.fQd = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void D(Bundle bundle) {
        bundle.putString("thread_id", this.fPG);
        bundle.putString("post_id", this.fPI);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt("key_start_from", this.fQF);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fPJ);
        bundle.putBoolean("host_only", this.fPK);
        bundle.putBoolean("squence", this.fPM);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fPO);
        bundle.putLong("thread_time", this.fPP);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fPU);
        bundle.putBoolean("is_sub_pb", this.eTQ);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fPW);
        bundle.putLong("msg_id", this.fPV);
        bundle.putString("extra_pb_cache_key", this.fQg);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fQa);
        bundle.putBoolean("is_from_interview_live_config", this.fQb);
        bundle.putBoolean("is_from_my_god_config", this.fQc);
        bundle.putInt("extra_pb_is_attention_key", this.fQi);
        bundle.putInt("extra_pb_funs_count_key", this.fQh);
        bundle.putBoolean("from_frs", this.fPT);
        bundle.putBoolean("from_maintab", this.fjH);
        bundle.putBoolean("from_smart_frs", this.fQt);
        bundle.putBoolean("from_hottopic", this.fQd);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bdj() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fPG);
        if (!this.fPU) {
            sb.append(this.fPI);
        }
        sb.append(this.fPK);
        sb.append(this.fPM);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fPO);
        sb.append(this.fPP);
        sb.append(this.fPT);
        sb.append(this.fjH);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eTQ);
        sb.append(this.fPW);
        sb.append(this.fPV);
        sb.append(this.fPX);
        sb.append(this.mThreadType);
        sb.append(this.fQa);
        sb.append(this.fQb);
        sb.append(this.fQc);
        if (this.fQg != null) {
            sb.append(this.fQg);
        }
        return sb.toString();
    }

    public String bdk() {
        return this.fPX;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.fPI;
    }

    public String bdl() {
        return this.fPG;
    }

    public boolean getHostMode() {
        return this.fPK;
    }

    public boolean bdm() {
        return this.fPM;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bdn() {
        return this.fPT;
    }

    public boolean bdo() {
        return this.fPN;
    }

    public boolean bdp() {
        return this.fjH;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bdq() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bdr() {
        return this.fPO;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void lO(int i) {
        this.fPO = i;
    }

    public boolean bds() {
        return this.eTQ;
    }

    public boolean bdt() {
        if (this.fPY == null) {
            return false;
        }
        return this.fPY.isValid();
    }

    public String zx() {
        if (this.fPY == null || !this.fPY.vX()) {
            return null;
        }
        return this.fPY.vW();
    }

    public boolean sR(int i) {
        this.fPQ = i;
        if (this.fPQ > this.fPY.yA().yr()) {
            this.fPQ = this.fPY.yA().yr();
        }
        if (this.fPQ < 1) {
            this.fPQ = 1;
        }
        if (this.fPG == null) {
            return false;
        }
        return sU(5);
    }

    public void sS(int i) {
        this.fPQ = i;
        this.fPR = i;
        this.fPS = i;
    }

    public void sT(int i) {
        if (this.fPR < i) {
            this.fPR = i;
            if (this.fPR - this.fPS >= fPF) {
                this.fPS = (this.fPR - fPF) + 1;
            }
        }
        if (this.fPS > i) {
            this.fPS = i;
            if (this.fPR - this.fPS >= fPF) {
                this.fPR = (this.fPS + fPF) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.fPY;
    }

    public com.baidu.tbadk.core.data.al aEo() {
        if (this.fPY == null) {
            return null;
        }
        return this.fPY.yA();
    }

    public boolean bdu() {
        if (this.fPM && this.fPY.yA().yw() == 0) {
            kl(true);
            return true;
        }
        return false;
    }

    public void ql(String str) {
        if (!StringUtils.isNull(str)) {
            this.fPG = str;
            this.fPI = null;
            this.fPK = false;
            this.fPM = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fPG == null) {
            return false;
        }
        cancelLoadData();
        if (this.dpV == null) {
            this.dpV = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.dpV.start();
        }
        boolean sU = sU(3);
        if (this.opType != null) {
            this.opType = null;
            this.fQf = null;
            this.opUrl = null;
            return sU;
        }
        return sU;
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
        if (this.fQC != null) {
            this.fQC.cancelLoadData();
        }
        if (this.fQy != null) {
            this.fQy.cancelLoadData();
        }
        if (this.fQD != null) {
            this.fQD.cancelLoadData();
        }
        aqS();
    }

    private void aqS() {
        if (this.dpV != null) {
            this.dpV.destory();
            this.dpV = null;
        }
    }

    public boolean Nv() {
        return (this.fPI == null || this.fPI.equals("0") || this.fPI.length() == 0) ? LoadData() : bdx();
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
                this.fQC.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fQC.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fQD == null) {
                this.fQD = new GetSugMatchWordsModel(this.bSC.getPageContext());
            }
            this.fQD.b(aVar);
        }
    }

    public boolean sU(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        sV(i);
        final com.baidu.tieba.pb.data.d pbData = ai.bet().getPbData();
        if (pbData != null && pbData.bat() != null) {
            pbData.bat().eO(0);
            this.fPM = ai.bet().bdm();
            this.fPK = ai.bet().bey();
            this.fPN = ai.bet().bez();
            this.fQH = ai.bet().bex();
            this.fQI = ai.bet().bew();
            this.fQJ = ai.bet().bev();
            this.fQE = this.fPK;
            if (this.fPK || this.isFromMark) {
                this.fQj = false;
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
        if (i == 4 && !this.fQn) {
            a(bdC(), true, this.fPI, 3);
        }
        if (i == 3 && !this.fQn) {
            if (this.isFromMark) {
                a(bdC(), true, this.fPI, 3);
            } else {
                a(bdC(), false, this.fPI, 3);
            }
        }
        this.fQn = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.brn);
        if (this.fPK || this.isFromMark) {
            this.fQj = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fPG == null || this.fPG.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.fPG, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.ao.Dd().Df() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ao));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aq));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.fPM) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.fPK) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fPW) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fPV));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fQj) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.h(this.fQf, 0));
            pbPageRequestMessage.setOpMessageID(this.fPV);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bav = this.fPY.bav();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.fPM) {
                        if (this.fPS - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fPS - 1));
                        }
                    } else if (this.fPR < this.dcN) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fPR + 1));
                    }
                }
                if (bav != null && bav.size() > 0) {
                    int size = bav.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = bav.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.fPI = postData.getId();
                            if (StringUtils.isNull(this.fPI)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.fPI != null && this.fPI.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fPI, 0L));
                } else if (!this.fPM) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (bav != null && bav.size() > 0 && bav.get(0) != null) {
                    this.fPI = bav.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.fPM) {
                        if (this.fPS - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fPS - 1));
                        }
                    } else if (this.fPR < this.dcN) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fPR + 1));
                    }
                }
                if (this.fPI != null && this.fPI.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fPI, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fPK) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.fPM) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fPI, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fPQ));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.fPM && this.fQE && !this.fPK) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fPI, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.fPK) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fQr);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fQG, 0L));
                if (!this.fPM) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fQE = this.fPK;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bdC());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fQF));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fQq);
        pbPageRequestMessage.setFromSmartFrs(this.fQt ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fPJ);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bcz() {
        switch (bdR()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bat() == null || !getPbData().bat().Aw();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bdk()) && com.baidu.tieba.recapp.r.boe().bnY() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.boe().bnY().U(bdk(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.boe().bnY().V(bdk(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bdk()) && com.baidu.tieba.recapp.r.boe().bnY() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.boe().bnY().V(bdk(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.boe().bnY().U(bdk(), true));
        }
    }

    protected void sV(int i) {
        boolean z = false;
        sZ(i);
        ArrayList<PostData> bav = this.fPY.bav();
        this.fQm = false;
        if (i == 1) {
            boolean z2 = false;
            while (bav.size() + 30 > com.baidu.tbadk.data.d.Kv()) {
                bav.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fPY.yA().eK(1);
                if (this.fQe != null) {
                    this.fQe.f(this.fPY);
                }
            }
            this.dSw = System.currentTimeMillis();
            this.fQm = true;
        } else if (i == 2) {
            while (bav.size() + 30 > com.baidu.tbadk.data.d.Kv()) {
                bav.remove(bav.size() - 1);
                z = true;
            }
            if (z) {
                this.fPY.yA().eJ(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.fQu = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fPH)) {
            try {
                Long valueOf = Long.valueOf(this.fPH);
                com.baidu.tieba.pb.data.l baE = dVar.baE();
                if (baE != null && baE.fIf != null) {
                    if (baE.fIf.isEmpty() || !baE.fIf.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fPG);
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
            if (this.fQc || this.fQa || this.fQb) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.bav().size(); i++) {
                PostData postData = dVar.bav().get(i);
                for (int i2 = 0; i2 < postData.bwQ().size(); i2++) {
                    postData.bwQ().get(i2).b(this.bSC.getPageContext(), l.equals(postData.bwQ().get(i2).zn().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.l baE = dVar.baE();
            if (baE != null && !com.baidu.tbadk.core.util.v.E(baE.fIe)) {
                for (PostData postData2 : baE.fIe) {
                    for (int i3 = 0; i3 < postData2.bwQ().size(); i3++) {
                        postData2.bwQ().get(i3).b(this.bSC.getPageContext(), l.equals(postData2.bwQ().get(i3).zn().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.l baE = dVar.baE();
            if (baE != null && !com.baidu.tbadk.core.util.v.E(baE.fIe)) {
                for (PostData postData : baE.fIe.subList(i, baE.fIe.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bwQ().size()) {
                            postData.bwQ().get(i3).b(this.bSC.getPageContext(), l.equals(postData.bwQ().get(i3).zn().getUserId()));
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
        bd bat = dVar.bat();
        bat.eS(this.mIsGood);
        bat.eR(this.fPO);
        if (this.fPP > 0) {
            bat.v(this.fPP);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bat() != null && dVar.bat().zn() != null) {
            str = dVar.bat().zn().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bdv() {
        if (this.fPY == null || this.fPY.bat() == null || this.fPY.bat().zn() == null) {
            return null;
        }
        return this.fPY.bat().zn();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fQs = z3;
        this.fPZ = i;
        if (this.dpV != null && !z3) {
            this.dpV.a(z2, z4, i2, str, i3, j, j2);
            this.dpV = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bdk()) && com.baidu.tieba.recapp.r.boe().bnY() != null) {
            com.baidu.tieba.recapp.r.boe().bnY().f(bdk(), sW(getRequestType()), true);
        }
        if (dVar == null || (this.fPQ == 1 && i == 5 && dVar.bav() != null && dVar.bav().size() < 1)) {
            if (this.fQe != null) {
                this.fPM = this.fPL;
                this.fQe.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fPL = this.fPM;
            this.fPW = false;
            if (dVar.yA() != null) {
                sT(dVar.yA().yu());
                this.dcN = dVar.yA().yr();
            }
            this.dcN = this.dcN < 1 ? 1 : this.dcN;
            ArrayList<PostData> bav = this.fPY.bav();
            switch (i) {
                case 1:
                    this.fPY.a(dVar.yA(), 1);
                    e(dVar, bav);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bav() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bav().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(bav, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.f(dVar.bav(), com.baidu.tbadk.core.util.v.D(dVar.bav()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bav().remove(postData2);
                            i6 = size - 1;
                        }
                        bav.addAll(0, dVar.bav());
                    }
                    this.fPY.a(dVar.yA(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.fPM && dVar.yA() != null) {
                        dVar.yA().eH(dVar.yA().yr());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && this.fPM) {
                        bdw();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.E(dVar.bav()) && this.fPY != null && (!this.fPK || l(dVar).equals(dVar.bav().get(0).zn().getUserId()))) {
                        if (this.fPY.yA().yw() == 0) {
                            this.fPY.yA().eJ(1);
                        }
                        bdS();
                        this.fQH = dVar.bav().get(0);
                        if (this.fPM) {
                            if (this.fPY.bav().size() - this.fQJ >= 3) {
                                this.fQI = new PostData();
                                this.fQI.haZ = true;
                                this.fQI.setPostType(53);
                                this.fPY.bav().add(this.fQI);
                            }
                            this.fPY.bav().add(this.fQH);
                            i4 = this.fPY.bav().size() - 1;
                        } else {
                            if (this.fQJ - this.fQK >= 3) {
                                this.fQI = new PostData();
                                this.fQI.haZ = false;
                                this.fQI.setPostType(53);
                                this.fPY.bav().add(0, this.fQI);
                            }
                            this.fPY.bav().add(0, this.fQH);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.am.W(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fQH.hbm = this.fPY.baS();
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
            if (this.fPY != null && this.fPY.bat() != null) {
                PraiseData zc = this.fPY.bat().zc();
                if (this.fQP != null && !zc.isPriaseDataValid()) {
                    this.fPY.bat().a(this.fQP);
                } else {
                    this.fQP = this.fPY.bat().zc();
                    this.fQP.setPostId(this.fPY.bat().zE());
                }
                if (dVar.yA() != null && dVar.yA().yu() == 1 && dVar.bat() != null && dVar.bat().zz() != null && dVar.bat().zz().size() > 0) {
                    this.fPY.bat().i(dVar.bat().zz());
                }
                this.fPY.bat().eP(dVar.bat().zf());
                this.fPY.bat().eM(dVar.bat().getAnchorLevel());
                this.fPY.bat().eO(dVar.bat().yY());
                if (this.mThreadType == 33) {
                    this.fPY.bat().zn().setHadConcerned(dVar.bat().zn().hadConcerned());
                }
                if (dVar != null && dVar.bat() != null) {
                    this.fPY.bat().eU(dVar.bat().zD());
                }
            }
            if (this.fPY != null && this.fPY.getUserData() != null && dVar.getUserData() != null) {
                this.fPY.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.fPY.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.yA() != null && dVar.yA().yu() == 1 && dVar.baD() != null) {
                this.fPY.c(dVar.baD());
            }
            if (this.fQs) {
                if (this.fPY.bat() != null && this.fPY.bat().zn() != null && this.fPY.bav() != null && com.baidu.tbadk.core.util.v.f(this.fPY.bav(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.f(this.fPY.bav(), 0);
                    MetaData zn = this.fPY.bat().zn();
                    if (postData3.zn() != null && postData3.zn().getGodUserData() != null) {
                        if (this.fQh != -1) {
                            zn.setFansNum(this.fQh);
                            postData3.zn().setFansNum(this.fQh);
                        }
                        if (this.fQi != -1) {
                            zn.getGodUserData().setIsLike(this.fQi == 1);
                            postData3.zn().getGodUserData().setIsLike(this.fQi == 1);
                            zn.getGodUserData().setIsFromNetWork(false);
                            postData3.zn().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fPY.fHz = -1;
                this.fPY.fHy = -1;
            }
            if (this.fQe != null) {
                this.fQe.a(true, getErrorCode(), i, i5, this.fPY, this.mErrorString, 1);
            }
        }
        if (this.fPY != null && this.fPY.bat() != null && this.fPY.bar() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bSC;
            historyMessage.threadId = getPbData().bat().getId();
            if (this.mIsShareThread && getPbData().bat().aQl != null) {
                historyMessage.threadName = getPbData().bat().aQl.showText;
            } else {
                historyMessage.threadName = getPbData().bat().getTitle();
            }
            if (this.mIsShareThread && !bcz()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().bar().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bdm();
            historyMessage.threadType = getPbData().bat().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String am;
        if (arrayList != null && dVar.bav() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(dVar.bav(), 0);
            if (postData != null && (am = am(arrayList)) != null && am.equals(postData.getId())) {
                dVar.bav().remove(postData);
            }
            arrayList.addAll(dVar.bav());
        }
    }

    private int sW(int i) {
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

    private String am(ArrayList<PostData> arrayList) {
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
    public void m(com.baidu.tieba.pb.data.d dVar) {
        dVar.qk(this.fPY.baK());
        this.fPY = dVar;
        sS(dVar.yA().yu());
    }

    private void bdw() {
        if (this.fPY != null && this.fPY.bav() != null && this.fPY.baJ() != null) {
            ArrayList<PostData> bav = this.fPY.bav();
            com.baidu.tieba.pb.data.a baJ = this.fPY.baJ();
            int bao = baJ.bao();
            if (bao > 0) {
                if (bao <= bav.size()) {
                    bav.add(bao, baJ);
                } else {
                    bav.add(baJ);
                }
            }
        }
    }

    public boolean bdx() {
        if (this.fPG == null || this.fPI == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return sU(4);
        }
        return sU(6);
    }

    public boolean kl(boolean z) {
        if (this.fPG == null || this.fPY == null) {
            return false;
        }
        if (z || this.fPY.yA().yw() != 0) {
            return sU(1);
        }
        return false;
    }

    public boolean km(boolean z) {
        if (this.fPG == null || this.fPY == null) {
            return false;
        }
        if ((z || this.fPY.yA().yx() != 0) && this.fPY.bav() != null && this.fPY.bav().size() >= 1) {
            return sU(2);
        }
        return false;
    }

    public boolean qq(String str) {
        this.fPK = !this.fPK;
        this.fPI = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (sU(6)) {
            return true;
        }
        this.fPK = this.fPK ? false : true;
        return false;
    }

    public boolean j(boolean z, String str) {
        if (this.fPK == z) {
            return false;
        }
        this.fPK = z;
        this.fPI = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (sU(6)) {
            return true;
        }
        this.fPK = z ? false : true;
        return false;
    }

    public boolean bdy() {
        this.fPL = this.fPM;
        this.fPM = !this.fPM;
        if (this.isLoading || !LoadData()) {
            this.fPM = this.fPM ? false : true;
            return false;
        }
        return true;
    }

    public boolean bdz() {
        return this.fPM;
    }

    public boolean hasData() {
        return (this.fPY == null || this.fPY.bar() == null || this.fPY.bat() == null) ? false : true;
    }

    public boolean vX() {
        if (this.fPY == null) {
            return false;
        }
        return this.fPY.vX();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gr(String str) {
        if (this.fPY == null || this.fPY.bat() == null || this.fPY.bar() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fPY.bat().Aw()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fPY.bar().getId());
            writeData.setForumName(this.fPY.bar().getName());
        }
        writeData.sourceFrom = String.valueOf(this.fQF);
        writeData.setThreadId(this.fPG);
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

    public MarkData sX(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fPY == null) {
            return null;
        }
        ArrayList<PostData> bav = this.fPY.bav();
        if (com.baidu.tbadk.core.util.v.E(bav)) {
            return null;
        }
        if (bav.size() > 0 && i >= bav.size()) {
            i = bav.size() - 1;
        }
        return h(bav.get(i));
    }

    public MarkData bdA() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fPG);
        markData.setPostId(this.fPY.vW());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fPK);
        markData.setSequence(Boolean.valueOf(this.fPM));
        markData.setId(this.fPG);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fPG);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fPK);
        markData.setSequence(Boolean.valueOf(this.fPM));
        markData.setId(this.fPG);
        markData.setFloor(postData.bwT());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bdB() {
        g.bcT().N(bdC(), this.isFromMark);
    }

    private String bdC() {
        String str = this.fPG;
        if (this.fPK) {
            str = str + DB_KEY_HOST;
        }
        if (!this.fPM) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void kn(boolean z) {
        if (this.fPY != null) {
            this.fPY.aL(z);
        }
    }

    public void ko(boolean z) {
        this.fQj = z;
    }

    public boolean bdD() {
        return this.fQj;
    }

    public void a(a aVar) {
        this.fQe = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lw() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Lv() {
        return Nv();
    }

    public boolean qr(String str) {
        if (getPbData() == null || getPbData().bat() == null || getPbData().bat().zn() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bat().zn().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bdE() {
        String bdC = bdC();
        g.bcT().N(bdC, false);
        g.bcT().N(bdC, true);
    }

    public void bdF() {
        if ("personalize_page".equals(this.mStType)) {
            this.fQp = System.currentTimeMillis() / 1000;
        }
    }

    public void bdG() {
        if ("personalize_page".equals(this.mStType) && this.fPY != null && this.fQp != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ab(ImageViewerConfig.FORUM_ID, this.fPY.getForumId()).ab("tid", this.fPG).ab("obj_duration", String.valueOf(currentTimeMillis - this.fQp)).ab("obj_param3", String.valueOf(currentTimeMillis)));
            this.fQp = 0L;
        }
    }

    public boolean bdH() {
        return this.fQs;
    }

    public int getErrorNo() {
        return this.fQu;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bdI() {
        return this.fQw;
    }

    public m bdJ() {
        return this.fQx;
    }

    public q bdK() {
        return this.fQy;
    }

    public y bdL() {
        return this.fQz;
    }

    public CheckRealNameModel bdM() {
        return this.cAp;
    }

    public AddExperiencedModel bdN() {
        return this.fQB;
    }

    public String bdO() {
        return this.fQo;
    }

    public void qs(String str) {
        this.fQo = str;
    }

    public boolean bdP() {
        return this.fQt;
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fPY != null && this.fPY.bav() != null && this.fPY.bav().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fPY.bav().size();
                for (int i = 0; i < size; i++) {
                    if (this.fPY.bav().get(i) != null && this.fPY.bav().get(i).zn() != null && currentAccount.equals(this.fPY.bav().get(i).zn().getUserId()) && this.fPY.bav().get(i).zn().getPendantData() != null) {
                        this.fPY.bav().get(i).zn().getPendantData().cX(hVar.ya());
                        this.fPY.bav().get(i).zn().getPendantData().ab(hVar.KD());
                    }
                }
            }
        }
    }

    public String bdQ() {
        return this.fQA;
    }

    public int bdR() {
        return this.fQF;
    }

    public void sY(int i) {
        this.fQF = i;
    }

    public void qt(String str) {
        if ((!this.fPK || qr(TbadkCoreApplication.getCurrentAccount())) && this.fPY.bav() != null) {
            this.fPY.yA().eJ(1);
            if (this.fPY.yA().yw() == 0) {
                this.fPY.yA().eJ(1);
            }
            this.fQG = str;
            sU(8);
        }
    }

    private void sZ(int i) {
        if (i != 8) {
            this.fQG = "";
            if (this.fQH != null) {
                if (i == 1 && !this.fPM && !com.baidu.tbadk.core.util.v.E(getPbData().bav())) {
                    getPbData().bav().remove(this.fQH);
                    if (this.fQI != null) {
                        getPbData().bav().remove(this.fQI);
                    }
                    getPbData().bav().add(0, this.fQH);
                } else {
                    getPbData().bav().remove(this.fQH);
                    if (this.fQI != null) {
                        getPbData().bav().remove(this.fQI);
                    }
                }
            }
            this.fQI = null;
        }
    }

    public void bdS() {
        if (this.fPY != null && !com.baidu.tbadk.core.util.v.E(this.fPY.bav())) {
            if (this.fQI != null) {
                this.fPY.bav().remove(this.fQI);
                this.fQI = null;
            }
            if (this.fQH != null) {
                this.fPY.bav().remove(this.fQH);
                this.fQH = null;
            }
        }
    }

    public void co(int i, int i2) {
        this.fQJ = i;
        this.fQK = i2;
    }

    public PostData bdT() {
        return this.fQH;
    }

    public PostData bdU() {
        return this.fQI;
    }

    public int bdV() {
        return this.fQJ;
    }

    public String bdW() {
        return this.fQL;
    }

    public void qu(String str) {
        this.fQL = str;
    }
}
