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
    private BaseActivity bSF;
    private final CheckRealNameModel cAs;
    private long dSB;
    private int dcQ;
    private com.baidu.tieba.tbadkCore.d.b dpY;
    private boolean eUf;
    protected String fPW;
    private String fPX;
    private String fPY;
    private boolean fPZ;
    private boolean fQA;
    private boolean fQB;
    private boolean fQC;
    private boolean fQD;
    private String fQE;
    private long fQF;
    private boolean fQG;
    private int fQH;
    private boolean fQI;
    private boolean fQJ;
    private int fQK;
    private final w fQL;
    private final h fQM;
    private final m fQN;
    private final q fQO;
    private final y fQP;
    private String fQQ;
    private final AddExperiencedModel fQR;
    private SuggestEmotionModel fQS;
    private GetSugMatchWordsModel fQT;
    private boolean fQU;
    private int fQV;
    private String fQW;
    private PostData fQX;
    private PostData fQY;
    private int fQZ;
    private boolean fQa;
    private boolean fQb;
    private boolean fQc;
    private boolean fQd;
    private int fQe;
    private long fQf;
    private int fQg;
    private int fQh;
    private int fQi;
    private boolean fQj;
    private boolean fQk;
    private long fQl;
    private boolean fQm;
    private String fQn;
    protected com.baidu.tieba.pb.data.d fQo;
    private int fQp;
    private boolean fQq;
    private boolean fQr;
    private boolean fQs;
    private boolean fQt;
    private a fQu;
    private String fQv;
    private String fQw;
    private int fQx;
    private int fQy;
    private boolean fQz;
    private int fRa;
    private String fRb;
    private CustomMessageListener fRc;
    private CustomMessageListener fRd;
    private com.baidu.adp.framework.listener.a fRe;
    private PraiseData fRf;
    private boolean fjX;
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
    private static final int fPV = com.baidu.tbadk.data.d.Kw() / 30;
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
        this.fPW = null;
        this.fPX = null;
        this.fPY = null;
        this.mForumId = null;
        this.fPZ = false;
        this.fQa = false;
        this.fQb = true;
        this.fQc = true;
        this.fQd = false;
        this.mIsGood = 0;
        this.fQe = 0;
        this.fQf = 0L;
        this.fQg = 1;
        this.fQh = 1;
        this.fQi = 1;
        this.dcQ = 1;
        this.isAd = false;
        this.eUf = false;
        this.fQj = false;
        this.fjX = false;
        this.isFromMark = false;
        this.fQk = false;
        this.fQl = 0L;
        this.fQm = false;
        this.fQn = null;
        this.fQo = null;
        this.isLoading = false;
        this.fQq = false;
        this.fQr = false;
        this.fQs = false;
        this.fQt = false;
        this.mLocate = null;
        this.mContext = null;
        this.fQu = null;
        this.opType = null;
        this.opUrl = null;
        this.fQv = null;
        this.fQw = null;
        this.fQx = -1;
        this.fQy = -1;
        this.dpY = null;
        this.fQA = false;
        this.fQB = false;
        this.postID = null;
        this.fQE = null;
        this.fQF = 0L;
        this.fQG = false;
        this.fQH = -1;
        this.fQJ = false;
        this.fQU = false;
        this.fQV = 0;
        this.fRc = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.fQD = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.bau() != null) {
                        pbData.bau().eO(0);
                    }
                    if (PbModel.this.fQu != null && pbData != null) {
                        com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fQu.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fRd = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().bas() != null && PbModel.this.getPbData().bas().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().bas().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fRe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.oJ()) {
                        PbModel.this.bSF.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.fQA || !PbModel.this.fQB) {
                        if (!PbModel.this.fQA) {
                            PbModel.this.fQA = true;
                        } else {
                            PbModel.this.fQB = true;
                        }
                        if (PbModel.this.fQu != null) {
                            PbModel.this.fQu.a(PbModel.this.bdj(), z, responsedMessage, PbModel.this.fQC, System.currentTimeMillis() - PbModel.this.dSB);
                        }
                    }
                }
            }
        };
        this.fRf = null;
        registerListener(this.fRc);
        registerListener(this.fRe);
        registerListener(this.fRd);
        this.fQo = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bSF = baseActivity;
        this.fQL = new w(this, this.bSF);
        this.fQM = new h(this, this.bSF);
        this.fQN = new m(this, this.bSF);
        this.fQO = new q(this, getUniqueId());
        this.fQP = new y(this, this.bSF);
        this.cAs = new CheckRealNameModel(this.bSF.getPageContext());
        this.fQS = new SuggestEmotionModel();
        this.fQR = new AddExperiencedModel(this.bSF.getPageContext());
    }

    protected int bdj() {
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
        this.fPW = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fPW)) {
            this.fPW = this.fQL.V(intent);
        }
        this.fQV = intent.getIntExtra("key_start_from", 0);
        if (this.fQV == 0) {
            this.fQV = this.fQL.fRl;
        }
        this.fPY = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.fPX = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fPZ = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fQa = intent.getBooleanExtra("host_only", false);
        this.fQc = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fQe = intent.getIntExtra("is_top", 0);
        this.fQf = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fQk = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eUf = intent.getBooleanExtra("is_sub_pb", false);
        this.fQm = intent.getBooleanExtra("is_pv", false);
        this.fQl = intent.getLongExtra("msg_id", 0L);
        this.fQn = intent.getStringExtra("from_forum_name");
        this.fQw = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fQv = intent.getStringExtra("op_stat");
        this.fQq = intent.getBooleanExtra("is_from_thread_config", false);
        this.fQr = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fQs = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fQy = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fQx = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fQj = intent.getBooleanExtra("from_frs", false);
        this.fjX = intent.getBooleanExtra("from_maintab", false);
        this.fQJ = intent.getBooleanExtra("from_smart_frs", false);
        this.fQt = intent.getBooleanExtra("from_hottopic", false);
        this.fQQ = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fQV = bundle.getInt("key_start_from", 0);
        this.fPW = bundle.getString("thread_id");
        this.fPY = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.fPX = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fPZ = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fQa = bundle.getBoolean("host_only", false);
        this.fQc = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fQe = bundle.getInt("is_top", 0);
        this.fQf = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fQk = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eUf = bundle.getBoolean("is_sub_pb", false);
        this.fQm = bundle.getBoolean("is_pv", false);
        this.fQl = bundle.getLong("msg_id", 0L);
        this.fQn = bundle.getString("from_forum_name");
        this.fQw = bundle.getString("extra_pb_cache_key");
        this.fQq = bundle.getBoolean("is_from_thread_config", false);
        this.fQr = bundle.getBoolean("is_from_interview_live_config", false);
        this.fQs = bundle.getBoolean("is_from_my_god_config", false);
        this.fQy = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fQx = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fQj = bundle.getBoolean("from_frs", false);
        this.fjX = bundle.getBoolean("from_maintab", false);
        this.fQJ = bundle.getBoolean("from_smart_frs", false);
        this.fQt = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void D(Bundle bundle) {
        bundle.putString("thread_id", this.fPW);
        bundle.putString("post_id", this.fPY);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt("key_start_from", this.fQV);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fPZ);
        bundle.putBoolean("host_only", this.fQa);
        bundle.putBoolean("squence", this.fQc);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fQe);
        bundle.putLong("thread_time", this.fQf);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fQk);
        bundle.putBoolean("is_sub_pb", this.eUf);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fQm);
        bundle.putLong("msg_id", this.fQl);
        bundle.putString("extra_pb_cache_key", this.fQw);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fQq);
        bundle.putBoolean("is_from_interview_live_config", this.fQr);
        bundle.putBoolean("is_from_my_god_config", this.fQs);
        bundle.putInt("extra_pb_is_attention_key", this.fQy);
        bundle.putInt("extra_pb_funs_count_key", this.fQx);
        bundle.putBoolean("from_frs", this.fQj);
        bundle.putBoolean("from_maintab", this.fjX);
        bundle.putBoolean("from_smart_frs", this.fQJ);
        bundle.putBoolean("from_hottopic", this.fQt);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bdk() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fPW);
        if (!this.fQk) {
            sb.append(this.fPY);
        }
        sb.append(this.fQa);
        sb.append(this.fQc);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fQe);
        sb.append(this.fQf);
        sb.append(this.fQj);
        sb.append(this.fjX);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eUf);
        sb.append(this.fQm);
        sb.append(this.fQl);
        sb.append(this.fQn);
        sb.append(this.mThreadType);
        sb.append(this.fQq);
        sb.append(this.fQr);
        sb.append(this.fQs);
        if (this.fQw != null) {
            sb.append(this.fQw);
        }
        return sb.toString();
    }

    public String bdl() {
        return this.fQn;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.fPY;
    }

    public String bdm() {
        return this.fPW;
    }

    public boolean getHostMode() {
        return this.fQa;
    }

    public boolean bdn() {
        return this.fQc;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bdo() {
        return this.fQj;
    }

    public boolean bdp() {
        return this.fQd;
    }

    public boolean bdq() {
        return this.fjX;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bdr() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bds() {
        return this.fQe;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void lO(int i) {
        this.fQe = i;
    }

    public boolean bdt() {
        return this.eUf;
    }

    public boolean bdu() {
        if (this.fQo == null) {
            return false;
        }
        return this.fQo.isValid();
    }

    public String zx() {
        if (this.fQo == null || !this.fQo.vX()) {
            return null;
        }
        return this.fQo.vW();
    }

    public boolean sR(int i) {
        this.fQg = i;
        if (this.fQg > this.fQo.yA().yr()) {
            this.fQg = this.fQo.yA().yr();
        }
        if (this.fQg < 1) {
            this.fQg = 1;
        }
        if (this.fPW == null) {
            return false;
        }
        return sU(5);
    }

    public void sS(int i) {
        this.fQg = i;
        this.fQh = i;
        this.fQi = i;
    }

    public void sT(int i) {
        if (this.fQh < i) {
            this.fQh = i;
            if (this.fQh - this.fQi >= fPV) {
                this.fQi = (this.fQh - fPV) + 1;
            }
        }
        if (this.fQi > i) {
            this.fQi = i;
            if (this.fQh - this.fQi >= fPV) {
                this.fQh = (this.fQi + fPV) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.fQo;
    }

    public com.baidu.tbadk.core.data.al aEp() {
        if (this.fQo == null) {
            return null;
        }
        return this.fQo.yA();
    }

    public boolean bdv() {
        if (this.fQc && this.fQo.yA().yw() == 0) {
            kq(true);
            return true;
        }
        return false;
    }

    public void ql(String str) {
        if (!StringUtils.isNull(str)) {
            this.fPW = str;
            this.fPY = null;
            this.fQa = false;
            this.fQc = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fPW == null) {
            return false;
        }
        cancelLoadData();
        if (this.dpY == null) {
            this.dpY = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.dpY.start();
        }
        boolean sU = sU(3);
        if (this.opType != null) {
            this.opType = null;
            this.fQv = null;
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
        if (this.fQS != null) {
            this.fQS.cancelLoadData();
        }
        if (this.fQO != null) {
            this.fQO.cancelLoadData();
        }
        if (this.fQT != null) {
            this.fQT.cancelLoadData();
        }
        aqT();
    }

    private void aqT() {
        if (this.dpY != null) {
            this.dpY.destory();
            this.dpY = null;
        }
    }

    public boolean Nw() {
        return (this.fPY == null || this.fPY.equals("0") || this.fPY.length() == 0) ? LoadData() : bdy();
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
                this.fQS.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fQS.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fQT == null) {
                this.fQT = new GetSugMatchWordsModel(this.bSF.getPageContext());
            }
            this.fQT.b(aVar);
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
        final com.baidu.tieba.pb.data.d pbData = ai.beu().getPbData();
        if (pbData != null && pbData.bau() != null) {
            pbData.bau().eO(0);
            this.fQc = ai.beu().bdn();
            this.fQa = ai.beu().bez();
            this.fQd = ai.beu().beA();
            this.fQX = ai.beu().bey();
            this.fQY = ai.beu().bex();
            this.fQZ = ai.beu().bew();
            this.fQU = this.fQa;
            if (this.fQa || this.isFromMark) {
                this.fQz = false;
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
        if (i == 4 && !this.fQD) {
            a(bdD(), true, this.fPY, 3);
        }
        if (i == 3 && !this.fQD) {
            if (this.isFromMark) {
                a(bdD(), true, this.fPY, 3);
            } else {
                a(bdD(), false, this.fPY, 3);
            }
        }
        this.fQD = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.brq);
        if (this.fQa || this.isFromMark) {
            this.fQz = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fPW == null || this.fPW.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.fPW, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.ao.De().Dg() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ao));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aq));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.fQc) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.fQa) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fQm) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fQl));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fQz) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.h(this.fQv, 0));
            pbPageRequestMessage.setOpMessageID(this.fQl);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> baw = this.fQo.baw();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.fQc) {
                        if (this.fQi - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fQi - 1));
                        }
                    } else if (this.fQh < this.dcQ) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fQh + 1));
                    }
                }
                if (baw != null && baw.size() > 0) {
                    int size = baw.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = baw.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.fPY = postData.getId();
                            if (StringUtils.isNull(this.fPY)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.fPY != null && this.fPY.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fPY, 0L));
                } else if (!this.fQc) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (baw != null && baw.size() > 0 && baw.get(0) != null) {
                    this.fPY = baw.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.fQc) {
                        if (this.fQi - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fQi - 1));
                        }
                    } else if (this.fQh < this.dcQ) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fQh + 1));
                    }
                }
                if (this.fPY != null && this.fPY.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fPY, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fQa) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.fQc) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fPY, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fQg));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.fQc && this.fQU && !this.fQa) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fPY, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.fQa) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fQH);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fQW, 0L));
                if (!this.fQc) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fQU = this.fQa;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bdD());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fQV));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fQG);
        pbPageRequestMessage.setFromSmartFrs(this.fQJ ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fPZ);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bcA() {
        switch (bdS()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bau() == null || !getPbData().bau().Aw();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bdl()) && com.baidu.tieba.recapp.r.bof().bnZ() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bof().bnZ().U(bdl(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bof().bnZ().V(bdl(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bdl()) && com.baidu.tieba.recapp.r.bof().bnZ() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bof().bnZ().V(bdl(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bof().bnZ().U(bdl(), true));
        }
    }

    protected void sV(int i) {
        boolean z = false;
        sZ(i);
        ArrayList<PostData> baw = this.fQo.baw();
        this.fQC = false;
        if (i == 1) {
            boolean z2 = false;
            while (baw.size() + 30 > com.baidu.tbadk.data.d.Kw()) {
                baw.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fQo.yA().eK(1);
                if (this.fQu != null) {
                    this.fQu.f(this.fQo);
                }
            }
            this.dSB = System.currentTimeMillis();
            this.fQC = true;
        } else if (i == 2) {
            while (baw.size() + 30 > com.baidu.tbadk.data.d.Kw()) {
                baw.remove(baw.size() - 1);
                z = true;
            }
            if (z) {
                this.fQo.yA().eJ(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.fQK = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fPX)) {
            try {
                Long valueOf = Long.valueOf(this.fPX);
                com.baidu.tieba.pb.data.l baF = dVar.baF();
                if (baF != null && baF.fIv != null) {
                    if (baF.fIv.isEmpty() || !baF.fIv.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fPW);
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
            if (this.fQs || this.fQq || this.fQr) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.baw().size(); i++) {
                PostData postData = dVar.baw().get(i);
                for (int i2 = 0; i2 < postData.bwV().size(); i2++) {
                    postData.bwV().get(i2).b(this.bSF.getPageContext(), l.equals(postData.bwV().get(i2).zn().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.l baF = dVar.baF();
            if (baF != null && !com.baidu.tbadk.core.util.v.E(baF.fIu)) {
                for (PostData postData2 : baF.fIu) {
                    for (int i3 = 0; i3 < postData2.bwV().size(); i3++) {
                        postData2.bwV().get(i3).b(this.bSF.getPageContext(), l.equals(postData2.bwV().get(i3).zn().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.l baF = dVar.baF();
            if (baF != null && !com.baidu.tbadk.core.util.v.E(baF.fIu)) {
                for (PostData postData : baF.fIu.subList(i, baF.fIu.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bwV().size()) {
                            postData.bwV().get(i3).b(this.bSF.getPageContext(), l.equals(postData.bwV().get(i3).zn().getUserId()));
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
        bd bau = dVar.bau();
        bau.eS(this.mIsGood);
        bau.eR(this.fQe);
        if (this.fQf > 0) {
            bau.v(this.fQf);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bau() != null && dVar.bau().zn() != null) {
            str = dVar.bau().zn().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bdw() {
        if (this.fQo == null || this.fQo.bau() == null || this.fQo.bau().zn() == null) {
            return null;
        }
        return this.fQo.bau().zn();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fQI = z3;
        this.fQp = i;
        if (this.dpY != null && !z3) {
            this.dpY.a(z2, z4, i2, str, i3, j, j2);
            this.dpY = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bdl()) && com.baidu.tieba.recapp.r.bof().bnZ() != null) {
            com.baidu.tieba.recapp.r.bof().bnZ().f(bdl(), sW(getRequestType()), true);
        }
        if (dVar == null || (this.fQg == 1 && i == 5 && dVar.baw() != null && dVar.baw().size() < 1)) {
            if (this.fQu != null) {
                this.fQc = this.fQb;
                this.fQu.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fQb = this.fQc;
            this.fQm = false;
            if (dVar.yA() != null) {
                sT(dVar.yA().yu());
                this.dcQ = dVar.yA().yr();
            }
            this.dcQ = this.dcQ < 1 ? 1 : this.dcQ;
            ArrayList<PostData> baw = this.fQo.baw();
            switch (i) {
                case 1:
                    this.fQo.a(dVar.yA(), 1);
                    e(dVar, baw);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.baw() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.baw().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(baw, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.f(dVar.baw(), com.baidu.tbadk.core.util.v.D(dVar.baw()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.baw().remove(postData2);
                            i6 = size - 1;
                        }
                        baw.addAll(0, dVar.baw());
                    }
                    this.fQo.a(dVar.yA(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.fQc && dVar.yA() != null) {
                        dVar.yA().eH(dVar.yA().yr());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && this.fQc) {
                        bdx();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.E(dVar.baw()) && this.fQo != null && (!this.fQa || l(dVar).equals(dVar.baw().get(0).zn().getUserId()))) {
                        if (this.fQo.yA().yw() == 0) {
                            this.fQo.yA().eJ(1);
                        }
                        bdT();
                        this.fQX = dVar.baw().get(0);
                        if (this.fQc) {
                            if (this.fQo.baw().size() - this.fQZ >= 3) {
                                this.fQY = new PostData();
                                this.fQY.hbx = true;
                                this.fQY.setPostType(53);
                                this.fQo.baw().add(this.fQY);
                            }
                            this.fQo.baw().add(this.fQX);
                            i4 = this.fQo.baw().size() - 1;
                        } else {
                            if (this.fQZ - this.fRa >= 3) {
                                this.fQY = new PostData();
                                this.fQY.hbx = false;
                                this.fQY.setPostType(53);
                                this.fQo.baw().add(0, this.fQY);
                            }
                            this.fQo.baw().add(0, this.fQX);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.am.W(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fQX.hbK = this.fQo.baT();
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
            if (this.fQo != null && this.fQo.bau() != null) {
                PraiseData zc = this.fQo.bau().zc();
                if (this.fRf != null && !zc.isPriaseDataValid()) {
                    this.fQo.bau().a(this.fRf);
                } else {
                    this.fRf = this.fQo.bau().zc();
                    this.fRf.setPostId(this.fQo.bau().zE());
                }
                if (dVar.yA() != null && dVar.yA().yu() == 1 && dVar.bau() != null && dVar.bau().zz() != null && dVar.bau().zz().size() > 0) {
                    this.fQo.bau().i(dVar.bau().zz());
                }
                this.fQo.bau().eP(dVar.bau().zf());
                this.fQo.bau().eM(dVar.bau().getAnchorLevel());
                this.fQo.bau().eO(dVar.bau().yY());
                if (this.mThreadType == 33) {
                    this.fQo.bau().zn().setHadConcerned(dVar.bau().zn().hadConcerned());
                }
                if (dVar != null && dVar.bau() != null) {
                    this.fQo.bau().eU(dVar.bau().zD());
                }
            }
            if (this.fQo != null && this.fQo.getUserData() != null && dVar.getUserData() != null) {
                this.fQo.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.fQo.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.yA() != null && dVar.yA().yu() == 1 && dVar.baE() != null) {
                this.fQo.c(dVar.baE());
            }
            if (this.fQI) {
                if (this.fQo.bau() != null && this.fQo.bau().zn() != null && this.fQo.baw() != null && com.baidu.tbadk.core.util.v.f(this.fQo.baw(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.f(this.fQo.baw(), 0);
                    MetaData zn = this.fQo.bau().zn();
                    if (postData3.zn() != null && postData3.zn().getGodUserData() != null) {
                        if (this.fQx != -1) {
                            zn.setFansNum(this.fQx);
                            postData3.zn().setFansNum(this.fQx);
                        }
                        if (this.fQy != -1) {
                            zn.getGodUserData().setIsLike(this.fQy == 1);
                            postData3.zn().getGodUserData().setIsLike(this.fQy == 1);
                            zn.getGodUserData().setIsFromNetWork(false);
                            postData3.zn().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fQo.fHP = -1;
                this.fQo.fHO = -1;
            }
            if (this.fQu != null) {
                this.fQu.a(true, getErrorCode(), i, i5, this.fQo, this.mErrorString, 1);
            }
        }
        if (this.fQo != null && this.fQo.bau() != null && this.fQo.bas() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bSF;
            historyMessage.threadId = getPbData().bau().getId();
            if (this.mIsShareThread && getPbData().bau().aQm != null) {
                historyMessage.threadName = getPbData().bau().aQm.showText;
            } else {
                historyMessage.threadName = getPbData().bau().getTitle();
            }
            if (this.mIsShareThread && !bcA()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().bas().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bdn();
            historyMessage.threadType = getPbData().bau().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String am;
        if (arrayList != null && dVar.baw() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(dVar.baw(), 0);
            if (postData != null && (am = am(arrayList)) != null && am.equals(postData.getId())) {
                dVar.baw().remove(postData);
            }
            arrayList.addAll(dVar.baw());
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
        dVar.qk(this.fQo.baL());
        this.fQo = dVar;
        sS(dVar.yA().yu());
    }

    private void bdx() {
        if (this.fQo != null && this.fQo.baw() != null && this.fQo.baK() != null) {
            ArrayList<PostData> baw = this.fQo.baw();
            com.baidu.tieba.pb.data.a baK = this.fQo.baK();
            int bap = baK.bap();
            if (bap > 0) {
                if (bap <= baw.size()) {
                    baw.add(bap, baK);
                } else {
                    baw.add(baK);
                }
            }
        }
    }

    public boolean bdy() {
        if (this.fPW == null || this.fPY == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return sU(4);
        }
        return sU(6);
    }

    public boolean kq(boolean z) {
        if (this.fPW == null || this.fQo == null) {
            return false;
        }
        if (z || this.fQo.yA().yw() != 0) {
            return sU(1);
        }
        return false;
    }

    public boolean kr(boolean z) {
        if (this.fPW == null || this.fQo == null) {
            return false;
        }
        if ((z || this.fQo.yA().yx() != 0) && this.fQo.baw() != null && this.fQo.baw().size() >= 1) {
            return sU(2);
        }
        return false;
    }

    public boolean qq(String str) {
        this.fQa = !this.fQa;
        this.fPY = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (sU(6)) {
            return true;
        }
        this.fQa = this.fQa ? false : true;
        return false;
    }

    public boolean j(boolean z, String str) {
        if (this.fQa == z) {
            return false;
        }
        this.fQa = z;
        this.fPY = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (sU(6)) {
            return true;
        }
        this.fQa = z ? false : true;
        return false;
    }

    public boolean bdz() {
        this.fQb = this.fQc;
        this.fQc = !this.fQc;
        if (this.isLoading || !LoadData()) {
            this.fQc = this.fQc ? false : true;
            return false;
        }
        return true;
    }

    public boolean bdA() {
        return this.fQc;
    }

    public boolean hasData() {
        return (this.fQo == null || this.fQo.bas() == null || this.fQo.bau() == null) ? false : true;
    }

    public boolean vX() {
        if (this.fQo == null) {
            return false;
        }
        return this.fQo.vX();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gr(String str) {
        if (this.fQo == null || this.fQo.bau() == null || this.fQo.bas() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fQo.bau().Aw()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fQo.bas().getId());
            writeData.setForumName(this.fQo.bas().getName());
        }
        writeData.sourceFrom = String.valueOf(this.fQV);
        writeData.setThreadId(this.fPW);
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
        if (this.fQo == null) {
            return null;
        }
        ArrayList<PostData> baw = this.fQo.baw();
        if (com.baidu.tbadk.core.util.v.E(baw)) {
            return null;
        }
        if (baw.size() > 0 && i >= baw.size()) {
            i = baw.size() - 1;
        }
        return h(baw.get(i));
    }

    public MarkData bdB() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fPW);
        markData.setPostId(this.fQo.vW());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fQa);
        markData.setSequence(Boolean.valueOf(this.fQc));
        markData.setId(this.fPW);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fPW);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fQa);
        markData.setSequence(Boolean.valueOf(this.fQc));
        markData.setId(this.fPW);
        markData.setFloor(postData.bwY());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void bdC() {
        g.bcU().N(bdD(), this.isFromMark);
    }

    private String bdD() {
        String str = this.fPW;
        if (this.fQa) {
            str = str + DB_KEY_HOST;
        }
        if (!this.fQc) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void ks(boolean z) {
        if (this.fQo != null) {
            this.fQo.aL(z);
        }
    }

    public void kt(boolean z) {
        this.fQz = z;
    }

    public boolean bdE() {
        return this.fQz;
    }

    public void a(a aVar) {
        this.fQu = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lx() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Lw() {
        return Nw();
    }

    public boolean qr(String str) {
        if (getPbData() == null || getPbData().bau() == null || getPbData().bau().zn() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bau().zn().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bdF() {
        String bdD = bdD();
        g.bcU().N(bdD, false);
        g.bcU().N(bdD, true);
    }

    public void bdG() {
        if ("personalize_page".equals(this.mStType)) {
            this.fQF = System.currentTimeMillis() / 1000;
        }
    }

    public void bdH() {
        if ("personalize_page".equals(this.mStType) && this.fQo != null && this.fQF != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ab(ImageViewerConfig.FORUM_ID, this.fQo.getForumId()).ab("tid", this.fPW).ab("obj_duration", String.valueOf(currentTimeMillis - this.fQF)).ab("obj_param3", String.valueOf(currentTimeMillis)));
            this.fQF = 0L;
        }
    }

    public boolean bdI() {
        return this.fQI;
    }

    public int getErrorNo() {
        return this.fQK;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bdJ() {
        return this.fQM;
    }

    public m bdK() {
        return this.fQN;
    }

    public q bdL() {
        return this.fQO;
    }

    public y bdM() {
        return this.fQP;
    }

    public CheckRealNameModel bdN() {
        return this.cAs;
    }

    public AddExperiencedModel bdO() {
        return this.fQR;
    }

    public String bdP() {
        return this.fQE;
    }

    public void qs(String str) {
        this.fQE = str;
    }

    public boolean bdQ() {
        return this.fQJ;
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fQo != null && this.fQo.baw() != null && this.fQo.baw().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fQo.baw().size();
                for (int i = 0; i < size; i++) {
                    if (this.fQo.baw().get(i) != null && this.fQo.baw().get(i).zn() != null && currentAccount.equals(this.fQo.baw().get(i).zn().getUserId()) && this.fQo.baw().get(i).zn().getPendantData() != null) {
                        this.fQo.baw().get(i).zn().getPendantData().cX(hVar.ya());
                        this.fQo.baw().get(i).zn().getPendantData().ab(hVar.KE());
                    }
                }
            }
        }
    }

    public String bdR() {
        return this.fQQ;
    }

    public int bdS() {
        return this.fQV;
    }

    public void sY(int i) {
        this.fQV = i;
    }

    public void qt(String str) {
        if ((!this.fQa || qr(TbadkCoreApplication.getCurrentAccount())) && this.fQo.baw() != null) {
            this.fQo.yA().eJ(1);
            if (this.fQo.yA().yw() == 0) {
                this.fQo.yA().eJ(1);
            }
            this.fQW = str;
            sU(8);
        }
    }

    private void sZ(int i) {
        if (i != 8) {
            this.fQW = "";
            if (this.fQX != null) {
                if (i == 1 && !this.fQc && !com.baidu.tbadk.core.util.v.E(getPbData().baw())) {
                    getPbData().baw().remove(this.fQX);
                    if (this.fQY != null) {
                        getPbData().baw().remove(this.fQY);
                    }
                    getPbData().baw().add(0, this.fQX);
                } else {
                    getPbData().baw().remove(this.fQX);
                    if (this.fQY != null) {
                        getPbData().baw().remove(this.fQY);
                    }
                }
            }
            this.fQY = null;
        }
    }

    public void bdT() {
        if (this.fQo != null && !com.baidu.tbadk.core.util.v.E(this.fQo.baw())) {
            if (this.fQY != null) {
                this.fQo.baw().remove(this.fQY);
                this.fQY = null;
            }
            if (this.fQX != null) {
                this.fQo.baw().remove(this.fQX);
                this.fQX = null;
            }
        }
    }

    public void co(int i, int i2) {
        this.fQZ = i;
        this.fRa = i2;
    }

    public PostData bdU() {
        return this.fQX;
    }

    public PostData bdV() {
        return this.fQY;
    }

    public int bdW() {
        return this.fQZ;
    }

    public String bdX() {
        return this.fRb;
    }

    public void qu(String str) {
        this.fRb = str;
    }
}
