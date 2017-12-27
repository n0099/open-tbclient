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
import com.baidu.tbadk.core.data.be;
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
    private int cVo;
    private BaseActivity cmI;
    private final CheckRealNameModel cvX;
    private long dKA;
    private com.baidu.tieba.tbadkCore.d.b dir;
    protected String fKN;
    private String fKO;
    private String fKP;
    private boolean fKQ;
    private boolean fKR;
    private boolean fKS;
    private boolean fKT;
    private boolean fKU;
    private int fKV;
    private long fKW;
    private int fKX;
    private int fKY;
    private int fKZ;
    private boolean fLA;
    private boolean fLB;
    private int fLC;
    private final x fLD;
    private final j fLE;
    private final o fLF;
    private final PbFloorAgreeModel fLG;
    private final z fLH;
    private String fLI;
    private final AddExperiencedModel fLJ;
    private SuggestEmotionModel fLK;
    private GetSugMatchWordsModel fLL;
    private boolean fLM;
    private int fLN;
    private String fLO;
    private PostData fLP;
    private PostData fLQ;
    private int fLR;
    private int fLS;
    private String fLT;
    private CustomMessageListener fLU;
    private CustomMessageListener fLV;
    private com.baidu.adp.framework.listener.a fLW;
    private PraiseData fLX;
    private boolean fLa;
    private boolean fLb;
    private boolean fLc;
    private long fLd;
    private boolean fLe;
    private String fLf;
    protected com.baidu.tieba.pb.data.f fLg;
    private int fLh;
    private boolean fLi;
    private boolean fLj;
    private boolean fLk;
    private boolean fLl;
    private a fLm;
    private String fLn;
    private String fLo;
    private int fLp;
    private int fLq;
    private boolean fLr;
    private boolean fLs;
    private boolean fLt;
    private boolean fLu;
    private boolean fLv;
    private String fLw;
    private long fLx;
    private boolean fLy;
    private int fLz;
    private boolean fev;
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
    private static final int fKM = com.baidu.tbadk.data.d.JZ() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.f fVar);
    }

    public void jW(boolean z) {
        this.fLy = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.fKN = null;
        this.fKO = null;
        this.fKP = null;
        this.mForumId = null;
        this.fKQ = false;
        this.fKR = false;
        this.fKS = true;
        this.fKT = true;
        this.fKU = false;
        this.mIsGood = 0;
        this.fKV = 0;
        this.fKW = 0L;
        this.fKX = 1;
        this.fKY = 1;
        this.fKZ = 1;
        this.cVo = 1;
        this.isAd = false;
        this.fLa = false;
        this.fLb = false;
        this.fev = false;
        this.isFromMark = false;
        this.fLc = false;
        this.fLd = 0L;
        this.fLe = false;
        this.fLf = null;
        this.fLg = null;
        this.isLoading = false;
        this.fLi = false;
        this.fLj = false;
        this.fLk = false;
        this.fLl = false;
        this.mLocate = null;
        this.mContext = null;
        this.fLm = null;
        this.opType = null;
        this.opUrl = null;
        this.fLn = null;
        this.fLo = null;
        this.fLp = -1;
        this.fLq = -1;
        this.dir = null;
        this.fLs = false;
        this.fLt = false;
        this.postID = null;
        this.fLw = null;
        this.fLx = 0L;
        this.fLy = false;
        this.fLz = -1;
        this.fLB = false;
        this.fLM = false;
        this.fLN = 0;
        this.fLU = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.fLv = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.o(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.aYA() != null) {
                        pbData.aYA().eP(0);
                    }
                    if (PbModel.this.fLm != null && pbData != null) {
                        com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fLm.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fLV = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aYy() != null && PbModel.this.getPbData().aYy().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aYy().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fLW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.oI()) {
                        PbModel.this.cmI.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.fLs || !PbModel.this.fLt) {
                        if (!PbModel.this.fLs) {
                            PbModel.this.fLs = true;
                        } else {
                            PbModel.this.fLt = true;
                        }
                        if (PbModel.this.fLm != null) {
                            PbModel.this.fLm.a(PbModel.this.bby(), z, responsedMessage, PbModel.this.fLu, System.currentTimeMillis() - PbModel.this.dKA);
                        }
                    }
                }
            }
        };
        this.fLX = null;
        registerListener(this.fLU);
        registerListener(this.fLW);
        registerListener(this.fLV);
        this.fLg = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.cmI = baseActivity;
        this.fLD = new x(this, this.cmI);
        this.fLE = new j(this, this.cmI);
        this.fLF = new o(this, this.cmI);
        this.fLG = new PbFloorAgreeModel(this);
        this.fLH = new z(this, this.cmI);
        this.cvX = new CheckRealNameModel(this.cmI.getPageContext());
        this.fLK = new SuggestEmotionModel();
        this.fLJ = new AddExperiencedModel(this.cmI.getPageContext());
    }

    protected int bby() {
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
        this.fKN = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fKN)) {
            this.fKN = this.fLD.X(intent);
        }
        this.fLN = intent.getIntExtra("key_start_from", 0);
        if (this.fLN == 0) {
            this.fLN = this.fLD.fMd;
        }
        this.fKP = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.fKO = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fKQ = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fKR = intent.getBooleanExtra("host_only", false);
        this.fKT = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fKV = intent.getIntExtra("is_top", 0);
        this.fKW = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fLc = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.fLa = intent.getBooleanExtra("is_sub_pb", false);
        this.fLe = intent.getBooleanExtra("is_pv", false);
        this.fLd = intent.getLongExtra("msg_id", 0L);
        this.fLf = intent.getStringExtra("from_forum_name");
        this.fLo = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fLn = intent.getStringExtra("op_stat");
        this.fLi = intent.getBooleanExtra("is_from_thread_config", false);
        this.fLj = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fLk = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fLq = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fLp = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fLb = intent.getBooleanExtra("from_frs", false);
        this.fev = intent.getBooleanExtra("from_maintab", false);
        this.fLB = intent.getBooleanExtra("from_smart_frs", false);
        this.fLl = intent.getBooleanExtra("from_hottopic", false);
        this.fLI = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fLN = bundle.getInt("key_start_from", 0);
        this.fKN = bundle.getString("thread_id");
        this.fKP = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.fKO = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fKQ = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fKR = bundle.getBoolean("host_only", false);
        this.fKT = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fKV = bundle.getInt("is_top", 0);
        this.fKW = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fLc = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.fLa = bundle.getBoolean("is_sub_pb", false);
        this.fLe = bundle.getBoolean("is_pv", false);
        this.fLd = bundle.getLong("msg_id", 0L);
        this.fLf = bundle.getString("from_forum_name");
        this.fLo = bundle.getString("extra_pb_cache_key");
        this.fLi = bundle.getBoolean("is_from_thread_config", false);
        this.fLj = bundle.getBoolean("is_from_interview_live_config", false);
        this.fLk = bundle.getBoolean("is_from_my_god_config", false);
        this.fLq = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fLp = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fLb = bundle.getBoolean("from_frs", false);
        this.fev = bundle.getBoolean("from_maintab", false);
        this.fLB = bundle.getBoolean("from_smart_frs", false);
        this.fLl = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void x(Bundle bundle) {
        bundle.putString("thread_id", this.fKN);
        bundle.putString("post_id", this.fKP);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt("key_start_from", this.fLN);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fKQ);
        bundle.putBoolean("host_only", this.fKR);
        bundle.putBoolean("squence", this.fKT);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fKV);
        bundle.putLong("thread_time", this.fKW);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fLc);
        bundle.putBoolean("is_sub_pb", this.fLa);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fLe);
        bundle.putLong("msg_id", this.fLd);
        bundle.putString("extra_pb_cache_key", this.fLo);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fLi);
        bundle.putBoolean("is_from_interview_live_config", this.fLj);
        bundle.putBoolean("is_from_my_god_config", this.fLk);
        bundle.putInt("extra_pb_is_attention_key", this.fLq);
        bundle.putInt("extra_pb_funs_count_key", this.fLp);
        bundle.putBoolean("from_frs", this.fLb);
        bundle.putBoolean("from_maintab", this.fev);
        bundle.putBoolean("from_smart_frs", this.fLB);
        bundle.putBoolean("from_hottopic", this.fLl);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bbz() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fKN);
        if (!this.fLc) {
            sb.append(this.fKP);
        }
        sb.append(this.fKR);
        sb.append(this.fKT);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fKV);
        sb.append(this.fKW);
        sb.append(this.fLb);
        sb.append(this.fev);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.fLa);
        sb.append(this.fLe);
        sb.append(this.fLd);
        sb.append(this.fLf);
        sb.append(this.mThreadType);
        sb.append(this.fLi);
        sb.append(this.fLj);
        sb.append(this.fLk);
        if (this.fLo != null) {
            sb.append(this.fLo);
        }
        return sb.toString();
    }

    public String bbA() {
        return this.fLf;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.fKP;
    }

    public void pX(String str) {
        this.fKP = str;
    }

    public String bbB() {
        return this.fKN;
    }

    public boolean getHostMode() {
        return this.fKR;
    }

    public boolean bbC() {
        return this.fKT;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bbD() {
        return this.fLb;
    }

    public boolean bbE() {
        return this.fKU;
    }

    public boolean bbF() {
        return this.fev;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bbG() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bbH() {
        return this.fKV;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void lO(int i) {
        this.fKV = i;
    }

    public boolean bbI() {
        return this.fLa;
    }

    public boolean bbJ() {
        if (this.fLg == null) {
            return false;
        }
        return this.fLg.isValid();
    }

    public String zh() {
        if (this.fLg == null || !this.fLg.vk()) {
            return null;
        }
        return this.fLg.vj();
    }

    public boolean sU(int i) {
        this.fKX = i;
        if (this.fKX > this.fLg.yb().xS()) {
            this.fKX = this.fLg.yb().xS();
        }
        if (this.fKX < 1) {
            this.fKX = 1;
        }
        if (this.fKN == null) {
            return false;
        }
        return sY(5);
    }

    public boolean sV(int i) {
        int zL = this.fLg.aYA().zL();
        if (i <= zL) {
            zL = i;
        }
        int i2 = zL >= 1 ? zL : 1;
        if (this.fKN == null) {
            return false;
        }
        this.fLz = i2;
        return sY(7);
    }

    public void sW(int i) {
        this.fKX = i;
        this.fKY = i;
        this.fKZ = i;
    }

    public void sX(int i) {
        if (this.fKY < i) {
            this.fKY = i;
            if (this.fKY - this.fKZ >= fKM) {
                this.fKZ = (this.fKY - fKM) + 1;
            }
        }
        if (this.fKZ > i) {
            this.fKZ = i;
            if (this.fKY - this.fKZ >= fKM) {
                this.fKY = (this.fKZ + fKM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.fLg;
    }

    public com.baidu.tbadk.core.data.am aCL() {
        if (this.fLg == null) {
            return null;
        }
        return this.fLg.yb();
    }

    public boolean bbK() {
        if (this.fKT && this.fLg.yb().xX() == 0) {
            jX(true);
            return true;
        }
        return false;
    }

    public void pS(String str) {
        if (!StringUtils.isNull(str)) {
            this.fKN = str;
            this.fKP = null;
            this.fKR = false;
            this.fKT = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fKN == null) {
            return false;
        }
        cancelLoadData();
        if (this.dir == null) {
            this.dir = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.dir.start();
        }
        boolean sY = sY(3);
        if (this.opType != null) {
            this.opType = null;
            this.fLn = null;
            this.opUrl = null;
            return sY;
        }
        return sY;
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
        if (this.fLK != null) {
            this.fLK.cancelLoadData();
        }
        if (this.fLG != null) {
            this.fLG.cancelLoadData();
        }
        if (this.fLL != null) {
            this.fLL.cancelLoadData();
        }
        aoV();
    }

    private void aoV() {
        if (this.dir != null) {
            this.dir.destory();
            this.dir = null;
        }
    }

    public boolean Na() {
        return (this.fKP == null || this.fKP.equals("0") || this.fKP.length() == 0) ? LoadData() : bbN();
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
                this.fLK.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fLK.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fLL == null) {
                this.fLL = new GetSugMatchWordsModel(this.cmI.getPageContext());
            }
            this.fLL.b(aVar);
        }
    }

    public boolean sY(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        sZ(i);
        final com.baidu.tieba.pb.data.f pbData = aj.bcJ().getPbData();
        if (pbData != null && pbData.aYA() != null) {
            pbData.aYA().eP(0);
            this.fKT = aj.bcJ().bbC();
            this.fKR = aj.bcJ().bcO();
            this.fKU = aj.bcJ().bcP();
            this.fLP = aj.bcJ().bcN();
            this.fLQ = aj.bcJ().bcM();
            this.fLR = aj.bcJ().bcL();
            this.fLM = this.fKR;
            if (this.fKR || this.isFromMark) {
                this.fLr = false;
            }
            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.fLv) {
            a(bbS(), true, this.fKP, 3);
        }
        if (i == 3 && !this.fLv) {
            if (this.isFromMark) {
                a(bbS(), true, this.fKP, 3);
            } else {
                a(bbS(), false, this.fKP, 3);
            }
        }
        this.fLv = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.boV);
        if (this.fKR || this.isFromMark) {
            this.fLr = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fKN == null || this.fKN.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.fKN, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.an.CS().CU() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ao));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aq));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.fKT) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.fKR) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fLe) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fLd));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fLr) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.h(this.fLn, 0));
            pbPageRequestMessage.setOpMessageID(this.fLd);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aYC = this.fLg.aYC();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.fKT) {
                        if (this.fKZ - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fKZ - 1));
                        }
                    } else if (this.fKY < this.cVo) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fKY + 1));
                    }
                }
                if (aYC != null && aYC.size() > 0) {
                    int size = aYC.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aYC.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.fKP = postData.getId();
                            if (StringUtils.isNull(this.fKP)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.fKP != null && this.fKP.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fKP, 0L));
                } else if (!this.fKT) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aYC != null && aYC.size() > 0 && aYC.get(0) != null) {
                    this.fKP = aYC.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.fKT) {
                        if (this.fKZ - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fKZ - 1));
                        }
                    } else if (this.fKY < this.cVo) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fKY + 1));
                    }
                }
                if (this.fKP != null && this.fKP.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fKP, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fKR) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.fKT) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fKP, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fKX));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.fKT && this.fLM && !this.fKR) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fKP, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.fKR) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fLz);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fLO, 0L));
                if (!this.fKT) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fLM = this.fKR;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bbS());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fLN));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fLy);
        pbPageRequestMessage.setFromSmartFrs(this.fLB ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fKQ);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean baP() {
        switch (bch()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().aYA() == null || !getPbData().aYA().Ak();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bbA()) && com.baidu.tieba.recapp.q.bty().bts() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.bty().bts().W(bbA(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.bty().bts().X(bbA(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bbA()) && com.baidu.tieba.recapp.q.bty().bts() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.bty().bts().X(bbA(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.bty().bts().W(bbA(), true));
        }
    }

    protected void sZ(int i) {
        boolean z = false;
        td(i);
        ArrayList<PostData> aYC = this.fLg.aYC();
        this.fLu = false;
        if (i == 1) {
            boolean z2 = false;
            while (aYC.size() + 30 > com.baidu.tbadk.data.d.JZ()) {
                aYC.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fLg.yb().eL(1);
                if (this.fLm != null) {
                    this.fLm.f(this.fLg);
                }
            }
            this.dKA = System.currentTimeMillis();
            this.fLu = true;
        } else if (i == 2) {
            while (aYC.size() + 30 > com.baidu.tbadk.data.d.JZ()) {
                aYC.remove(aYC.size() - 1);
                z = true;
            }
            if (z) {
                this.fLg.yb().eK(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.fLC = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            i(fVar2);
            h(fVar2);
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.f fVar) {
        Long l;
        if (fVar != null && !StringUtils.isNull(this.fKO)) {
            try {
                Long valueOf = Long.valueOf(this.fKO);
                com.baidu.tieba.pb.data.n aYM = fVar.aYM();
                if (aYM != null && aYM.fCY != null) {
                    if (aYM.fCY.isEmpty() || !aYM.fCY.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fKN);
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
            if (this.fLk || this.fLi || this.fLj) {
                fVar = k(fVar);
            }
            j(fVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String l = l(fVar);
            for (int i = 0; i < fVar.aYC().size(); i++) {
                PostData postData = fVar.aYC().get(i);
                for (int i2 = 0; i2 < postData.bCi().size(); i2++) {
                    postData.bCi().get(i2).b(this.cmI.getPageContext(), l.equals(postData.bCi().get(i2).yX().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n aYM = fVar.aYM();
            if (aYM != null && !com.baidu.tbadk.core.util.v.G(aYM.fCX)) {
                for (PostData postData2 : aYM.fCX) {
                    for (int i3 = 0; i3 < postData2.bCi().size(); i3++) {
                        postData2.bCi().get(i3).b(this.cmI.getPageContext(), l.equals(postData2.bCi().get(i3).yX().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String l = l(fVar);
            com.baidu.tieba.pb.data.n aYM = fVar.aYM();
            if (aYM != null && !com.baidu.tbadk.core.util.v.G(aYM.fCX)) {
                for (PostData postData : aYM.fCX.subList(i, aYM.fCX.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bCi().size()) {
                            postData.bCi().get(i3).b(this.cmI.getPageContext(), l.equals(postData.bCi().get(i3).yX().getUserId()));
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
        be aYA = fVar.aYA();
        aYA.eT(this.mIsGood);
        aYA.eS(this.fKV);
        if (this.fKW > 0) {
            aYA.v(this.fKW);
            return fVar;
        }
        return fVar;
    }

    protected String l(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aYA() != null && fVar.aYA().yX() != null) {
            str = fVar.aYA().yX().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String m(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aYA() != null && fVar.aYA().yX() != null) {
            str = fVar.aYA().yX().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String n(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aYA() != null && fVar.aYA().yX() != null) {
            str = fVar.aYA().yX().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bbL() {
        if (this.fLg == null || this.fLg.aYA() == null || this.fLg.aYA().yX() == null) {
            return null;
        }
        return this.fLg.aYA().yX();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fLA = z3;
        this.fLh = i;
        if (this.dir != null && !z3) {
            this.dir.a(z2, z4, i2, str, i3, j, j2);
            this.dir = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bbA()) && com.baidu.tieba.recapp.q.bty().bts() != null) {
            com.baidu.tieba.recapp.q.bty().bts().f(bbA(), ta(getRequestType()), true);
        }
        if (fVar == null || (this.fKX == 1 && i == 5 && fVar.aYC() != null && fVar.aYC().size() < 1)) {
            if (this.fLm != null) {
                this.fKT = this.fKS;
                this.fLm.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fKS = this.fKT;
            this.fLe = false;
            if (fVar.yb() != null) {
                sX(fVar.yb().xV());
                this.cVo = fVar.yb().xS();
            }
            this.cVo = this.cVo < 1 ? 1 : this.cVo;
            ArrayList<PostData> aYC = this.fLg.aYC();
            switch (i) {
                case 1:
                    this.fLg.a(fVar.yb(), 1);
                    e(fVar, aYC);
                    i5 = 0;
                    break;
                case 2:
                    if (fVar.aYC() == null) {
                        i6 = 0;
                    } else {
                        int size = fVar.aYC().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(aYC, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.f(fVar.aYC(), com.baidu.tbadk.core.util.v.F(fVar.aYC()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            fVar.aYC().remove(postData2);
                            i6 = size - 1;
                        }
                        aYC.addAll(0, fVar.aYC());
                    }
                    this.fLg.a(fVar.yb(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.fKT && fVar.yb() != null) {
                        fVar.yb().eI(fVar.yb().xS());
                    }
                    o(fVar);
                    if (!z3 && this.mThreadType != 33 && this.fKT) {
                        bbM();
                        i5 = 0;
                        break;
                    }
                    i5 = 0;
                    break;
                case 4:
                    o(fVar);
                    i5 = 0;
                    break;
                case 5:
                    o(fVar);
                    i5 = 0;
                    break;
                case 6:
                    o(fVar);
                    i5 = 0;
                    break;
                case 7:
                    o(fVar);
                    i5 = 0;
                    break;
                case 8:
                    if (fVar != null && !com.baidu.tbadk.core.util.v.G(fVar.aYC()) && this.fLg != null && (!this.fKR || l(fVar).equals(fVar.aYC().get(0).yX().getUserId()))) {
                        if (this.fLg.yb().xX() == 0) {
                            this.fLg.yb().eK(1);
                        }
                        bci();
                        this.fLP = fVar.aYC().get(0);
                        if (this.fKT) {
                            if (this.fLg.aYC().size() - this.fLR >= 3) {
                                this.fLQ = new PostData();
                                this.fLQ.hjg = true;
                                this.fLQ.setPostType(53);
                                this.fLg.aYC().add(this.fLQ);
                            }
                            this.fLg.aYC().add(this.fLP);
                            i4 = this.fLg.aYC().size() - 1;
                        } else {
                            if (this.fLR - this.fLS >= 3) {
                                this.fLQ = new PostData();
                                this.fLQ.hjg = false;
                                this.fLQ.setPostType(53);
                                this.fLg.aYC().add(0, this.fLQ);
                            }
                            this.fLg.aYC().add(0, this.fLP);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.am.W(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fLP.hjt = this.fLg.aZb();
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
            if (this.fLg != null && this.fLg.aYA() != null) {
                PraiseData yM = this.fLg.aYA().yM();
                if (this.fLX != null && !yM.isPriaseDataValid()) {
                    this.fLg.aYA().a(this.fLX);
                } else {
                    this.fLX = this.fLg.aYA().yM();
                    this.fLX.setPostId(this.fLg.aYA().zo());
                }
                if (fVar.yb() != null && fVar.yb().xV() == 1 && fVar.aYA() != null && fVar.aYA().zj() != null && fVar.aYA().zj().size() > 0) {
                    this.fLg.aYA().i(fVar.aYA().zj());
                }
                this.fLg.aYA().eQ(fVar.aYA().yP());
                this.fLg.aYA().eN(fVar.aYA().getAnchorLevel());
                this.fLg.aYA().eP(fVar.aYA().yI());
                if (this.mThreadType == 33) {
                    this.fLg.aYA().yX().setHadConcerned(fVar.aYA().yX().hadConcerned());
                }
                if (fVar != null && fVar.aYA() != null) {
                    this.fLg.aYA().eV(fVar.aYA().zn());
                }
            }
            if (this.fLg != null && this.fLg.getUserData() != null && fVar.getUserData() != null) {
                this.fLg.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.fLg.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.yb() != null && fVar.yb().xV() == 1 && fVar.aYL() != null) {
                this.fLg.c(fVar.aYL());
            }
            if (this.fLA) {
                if (this.fLg.aYA() != null && this.fLg.aYA().yX() != null && this.fLg.aYC() != null && com.baidu.tbadk.core.util.v.f(this.fLg.aYC(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.f(this.fLg.aYC(), 0);
                    MetaData yX = this.fLg.aYA().yX();
                    if (postData3.yX() != null && postData3.yX().getGodUserData() != null) {
                        if (this.fLp != -1) {
                            yX.setFansNum(this.fLp);
                            postData3.yX().setFansNum(this.fLp);
                        }
                        if (this.fLq != -1) {
                            yX.getGodUserData().setIsLike(this.fLq == 1);
                            postData3.yX().getGodUserData().setIsLike(this.fLq == 1);
                            yX.getGodUserData().setIsFromNetWork(false);
                            postData3.yX().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fLg.fCs = -1;
                this.fLg.fCr = -1;
            }
            if (this.fLm != null) {
                this.fLm.a(true, getErrorCode(), i, i5, this.fLg, this.mErrorString, 1);
            }
        }
        if (this.fLg != null && this.fLg.aYA() != null && this.fLg.aYy() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.cmI;
            historyMessage.threadId = getPbData().aYA().getId();
            if (this.mIsShareThread && getPbData().aYA().aPb != null) {
                historyMessage.threadName = getPbData().aYA().aPb.showText;
            } else {
                historyMessage.threadName = getPbData().aYA().getTitle();
            }
            if (this.mIsShareThread && !baP()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().aYy().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bbC();
            historyMessage.threadType = getPbData().aYA().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String al;
        if (arrayList != null && fVar.aYC() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(fVar.aYC(), 0);
            if (postData != null && (al = al(arrayList)) != null && al.equals(postData.getId())) {
                fVar.aYC().remove(postData);
            }
            arrayList.addAll(fVar.aYC());
        }
    }

    private int ta(int i) {
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
        int F = com.baidu.tbadk.core.util.v.F(arrayList);
        if (F <= 0) {
            return null;
        }
        for (int i = F - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(com.baidu.tieba.pb.data.f fVar) {
        fVar.pR(this.fLg.aYT());
        this.fLg = fVar;
        sW(fVar.yb().xV());
    }

    private void bbM() {
        if (this.fLg != null && this.fLg.aYC() != null && this.fLg.aYR() != null) {
            ArrayList<PostData> aYC = this.fLg.aYC();
            com.baidu.tieba.pb.data.a aYR = this.fLg.aYR();
            int aYq = aYR.aYq();
            if (aYq > 0) {
                if (aYq <= aYC.size()) {
                    aYC.add(aYq, aYR);
                } else {
                    aYC.add(aYR);
                }
            }
        }
    }

    public boolean bbN() {
        if (this.fKN == null || this.fKP == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return sY(4);
        }
        return sY(6);
    }

    public boolean jX(boolean z) {
        if (this.fKN == null || this.fLg == null) {
            return false;
        }
        if (z || this.fLg.yb().xX() != 0) {
            return sY(1);
        }
        return false;
    }

    public boolean jY(boolean z) {
        if (this.fKN == null || this.fLg == null) {
            return false;
        }
        if ((z || this.fLg.yb().xY() != 0) && this.fLg.aYC() != null && this.fLg.aYC().size() >= 1) {
            return sY(2);
        }
        return false;
    }

    public boolean pY(String str) {
        this.fKR = !this.fKR;
        this.fKP = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (sY(6)) {
            return true;
        }
        this.fKR = this.fKR ? false : true;
        return false;
    }

    public boolean j(boolean z, String str) {
        if (this.fKR == z) {
            return false;
        }
        this.fKR = z;
        this.fKP = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (sY(6)) {
            return true;
        }
        this.fKR = z ? false : true;
        return false;
    }

    public boolean bbO() {
        this.fKS = this.fKT;
        this.fKT = !this.fKT;
        if (this.isLoading || !LoadData()) {
            this.fKT = this.fKT ? false : true;
            return false;
        }
        return true;
    }

    public boolean bbP() {
        return this.fKT;
    }

    public boolean hasData() {
        return (this.fLg == null || this.fLg.aYy() == null || this.fLg.aYA() == null) ? false : true;
    }

    public boolean vk() {
        if (this.fLg == null) {
            return false;
        }
        return this.fLg.vk();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fZ(String str) {
        if (this.fLg == null || this.fLg.aYA() == null || this.fLg.aYy() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fLg.aYA().Ak()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fLg.aYy().getId());
            writeData.setForumName(this.fLg.aYy().getName());
        }
        writeData.sourceFrom = String.valueOf(this.fLN);
        writeData.setThreadId(this.fKN);
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

    public MarkData tb(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fLg == null) {
            return null;
        }
        ArrayList<PostData> aYC = this.fLg.aYC();
        if (com.baidu.tbadk.core.util.v.G(aYC)) {
            return null;
        }
        if (aYC.size() > 0 && i >= aYC.size()) {
            i = aYC.size() - 1;
        }
        return h(aYC.get(i));
    }

    public MarkData bbQ() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fKN);
        markData.setPostId(this.fLg.vj());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fKR);
        markData.setSequence(Boolean.valueOf(this.fKT));
        markData.setId(this.fKN);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fKN);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fKR);
        markData.setSequence(Boolean.valueOf(this.fKT));
        markData.setId(this.fKN);
        markData.setFloor(postData.bCl());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bbR() {
        i.bbj().P(bbS(), this.isFromMark);
    }

    private String bbS() {
        String str = this.fKN;
        if (this.fKR) {
            str = str + DB_KEY_HOST;
        }
        if (!this.fKT) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jZ(boolean z) {
        if (this.fLg != null) {
            this.fLg.aH(z);
        }
    }

    public void ka(boolean z) {
        this.fLr = z;
    }

    public boolean bbT() {
        return this.fLr;
    }

    public void a(a aVar) {
        this.fLm = aVar;
    }

    public void pw(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String KZ() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean KY() {
        return Na();
    }

    public boolean pZ(String str) {
        if (getPbData() == null || getPbData().aYA() == null || getPbData().aYA().yX() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aYA().yX().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bbU() {
        String bbS = bbS();
        i.bbj().P(bbS, false);
        i.bbj().P(bbS, true);
    }

    public void bbV() {
        if ("personalize_page".equals(this.mStType)) {
            this.fLx = System.currentTimeMillis() / 1000;
        }
    }

    public void bbW() {
        if ("personalize_page".equals(this.mStType) && this.fLg != null && this.fLx != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ab(ImageViewerConfig.FORUM_ID, this.fLg.getForumId()).ab("tid", this.fKN).ab("obj_duration", String.valueOf(currentTimeMillis - this.fLx)).ab("obj_param3", String.valueOf(currentTimeMillis)));
            this.fLx = 0L;
        }
    }

    public boolean bbX() {
        return this.fLA;
    }

    public int getErrorNo() {
        return this.fLC;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public j bbY() {
        return this.fLE;
    }

    public o bbZ() {
        return this.fLF;
    }

    public PbFloorAgreeModel bca() {
        return this.fLG;
    }

    public z bcb() {
        return this.fLH;
    }

    public CheckRealNameModel bcc() {
        return this.cvX;
    }

    public AddExperiencedModel bcd() {
        return this.fLJ;
    }

    public String bce() {
        return this.fLw;
    }

    public void qa(String str) {
        this.fLw = str;
    }

    public boolean bcf() {
        return this.fLB;
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fLg != null && this.fLg.aYC() != null && this.fLg.aYC().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fLg.aYC().size();
                for (int i = 0; i < size; i++) {
                    if (this.fLg.aYC().get(i) != null && this.fLg.aYC().get(i).yX() != null && currentAccount.equals(this.fLg.aYC().get(i).yX().getUserId()) && this.fLg.aYC().get(i).yX().getPendantData() != null) {
                        this.fLg.aYC().get(i).yX().getPendantData().cM(hVar.xu());
                        this.fLg.aYC().get(i).yX().getPendantData().ab(hVar.Kh());
                    }
                }
            }
        }
    }

    public String bcg() {
        return this.fLI;
    }

    public int bch() {
        return this.fLN;
    }

    public void tc(int i) {
        this.fLN = i;
    }

    public void qb(String str) {
        if ((!this.fKR || pZ(TbadkCoreApplication.getCurrentAccount())) && this.fLg.aYC() != null) {
            this.fLg.yb().eK(1);
            if (this.fLg.yb().xX() == 0) {
                this.fLg.yb().eK(1);
            }
            this.fLO = str;
            sY(8);
        }
    }

    private void td(int i) {
        if (i != 8) {
            this.fLO = "";
            if (this.fLP != null) {
                if (i == 1 && !this.fKT && !com.baidu.tbadk.core.util.v.G(getPbData().aYC())) {
                    getPbData().aYC().remove(this.fLP);
                    if (this.fLQ != null) {
                        getPbData().aYC().remove(this.fLQ);
                    }
                    getPbData().aYC().add(0, this.fLP);
                } else {
                    getPbData().aYC().remove(this.fLP);
                    if (this.fLQ != null) {
                        getPbData().aYC().remove(this.fLQ);
                    }
                }
            }
            this.fLQ = null;
        }
    }

    public void bci() {
        if (this.fLg != null && !com.baidu.tbadk.core.util.v.G(this.fLg.aYC())) {
            if (this.fLQ != null) {
                this.fLg.aYC().remove(this.fLQ);
                this.fLQ = null;
            }
            if (this.fLP != null) {
                this.fLg.aYC().remove(this.fLP);
                this.fLP = null;
            }
        }
    }

    public void cs(int i, int i2) {
        this.fLR = i;
        this.fLS = i2;
    }

    public PostData bcj() {
        return this.fLP;
    }

    public PostData bck() {
        return this.fLQ;
    }

    public int bcl() {
        return this.fLR;
    }

    public String bcm() {
        return this.fLT;
    }

    public void qc(String str) {
        this.fLT = str;
    }
}
