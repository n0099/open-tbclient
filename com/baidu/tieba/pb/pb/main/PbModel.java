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
/* loaded from: classes.dex */
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
    private final CheckRealNameModel bHp;
    private BaseActivity byF;
    private long cXD;
    private int cgK;
    private com.baidu.tieba.tbadkCore.d.b ctU;
    protected String eXW;
    private String eXX;
    private String eXY;
    private boolean eXZ;
    private boolean eYA;
    private boolean eYB;
    private boolean eYC;
    private boolean eYD;
    private boolean eYE;
    private String eYF;
    private long eYG;
    private boolean eYH;
    private int eYI;
    private boolean eYJ;
    private boolean eYK;
    private int eYL;
    private final x eYM;
    private final j eYN;
    private final o eYO;
    private final PbFloorAgreeModel eYP;
    private final z eYQ;
    private String eYR;
    private final AddExperiencedModel eYS;
    private SuggestEmotionModel eYT;
    private GetSugMatchWordsModel eYU;
    private boolean eYV;
    private int eYW;
    private String eYX;
    private PostData eYY;
    private PostData eYZ;
    private boolean eYa;
    private boolean eYb;
    private boolean eYc;
    private boolean eYd;
    private int eYe;
    private long eYf;
    private int eYg;
    private int eYh;
    private int eYi;
    private boolean eYj;
    private boolean eYk;
    private boolean eYl;
    private long eYm;
    private boolean eYn;
    private String eYo;
    protected com.baidu.tieba.pb.data.f eYp;
    private int eYq;
    private boolean eYr;
    private boolean eYs;
    private boolean eYt;
    private boolean eYu;
    private a eYv;
    private String eYw;
    private String eYx;
    private int eYy;
    private int eYz;
    private int eZa;
    private int eZb;
    private String eZc;
    private CustomMessageListener eZd;
    private CustomMessageListener eZe;
    private com.baidu.adp.framework.listener.a eZf;
    private PraiseData eZg;
    private boolean est;
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
    private static final int eXV = com.baidu.tbadk.data.b.Cw() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.f fVar);
    }

    public void ju(boolean z) {
        this.eYH = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eXW = null;
        this.eXX = null;
        this.eXY = null;
        this.mForumId = null;
        this.eXZ = false;
        this.eYa = false;
        this.eYb = true;
        this.eYc = true;
        this.eYd = false;
        this.mIsGood = 0;
        this.eYe = 0;
        this.eYf = 0L;
        this.eYg = 1;
        this.eYh = 1;
        this.eYi = 1;
        this.cgK = 1;
        this.isAd = false;
        this.eYj = false;
        this.eYk = false;
        this.est = false;
        this.isFromMark = false;
        this.eYl = false;
        this.eYm = 0L;
        this.eYn = false;
        this.eYo = null;
        this.eYp = null;
        this.isLoading = false;
        this.eYr = false;
        this.eYs = false;
        this.eYt = false;
        this.eYu = false;
        this.mLocate = null;
        this.mContext = null;
        this.eYv = null;
        this.opType = null;
        this.opUrl = null;
        this.eYw = null;
        this.eYx = null;
        this.eYy = -1;
        this.eYz = -1;
        this.ctU = null;
        this.eYB = false;
        this.eYC = false;
        this.postID = null;
        this.eYF = null;
        this.eYG = 0L;
        this.eYH = false;
        this.eYI = -1;
        this.eYK = false;
        this.eYV = false;
        this.eYW = 0;
        this.eZd = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.eYE = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.o(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.aRq() != null) {
                        pbData.aRq().bP(0);
                    }
                    if (PbModel.this.eYv != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.eYv.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.eZe = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aRo() != null && PbModel.this.getPbData().aRo().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aRo().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.eZf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.hh()) {
                        PbModel.this.byF.showToast(responsedMessage.getErrorString());
                    }
                    if (responsedMessage instanceof pbPageSocketResponseMessage) {
                        pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                        PbModel.this.a(pbpagesocketresponsemessage);
                        pbpagesocketresponsemessage.getDownSize();
                    }
                    if (!(responsedMessage instanceof pbPageHttpResponseMessage)) {
                        z = false;
                    } else {
                        pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                        PbModel.this.a(pbpagehttpresponsemessage);
                        pbpagehttpresponsemessage.getDownSize();
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
                    if (!PbModel.this.eYB || !PbModel.this.eYC) {
                        if (!PbModel.this.eYB) {
                            PbModel.this.eYB = true;
                        } else {
                            PbModel.this.eYC = true;
                        }
                        if (PbModel.this.eYv != null) {
                            PbModel.this.eYv.a(PbModel.this.aUk(), z, responsedMessage, PbModel.this.eYD, System.currentTimeMillis() - PbModel.this.cXD);
                        }
                    }
                }
            }
        };
        this.eZg = null;
        registerListener(this.eZd);
        registerListener(this.eZf);
        registerListener(this.eZe);
        this.eYp = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.byF = baseActivity;
        this.eYM = new x(this, this.byF);
        this.eYN = new j(this, this.byF);
        this.eYO = new o(this, this.byF);
        this.eYP = new PbFloorAgreeModel(this);
        this.eYQ = new z(this, this.byF);
        this.bHp = new CheckRealNameModel(this.byF.getPageContext());
        this.eYT = new SuggestEmotionModel();
        this.eYS = new AddExperiencedModel(this.byF.getPageContext());
    }

    protected int aUk() {
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
        this.eXW = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eXW)) {
            this.eXW = this.eYM.W(intent);
        }
        this.eYW = intent.getIntExtra("key_start_from", 0);
        if (this.eYW == 0) {
            this.eYW = this.eYM.eZm;
        }
        this.eXY = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eXX = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.eXZ = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.eYa = intent.getBooleanExtra("host_only", false);
        this.eYc = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.eYe = intent.getIntExtra("is_top", 0);
        this.eYf = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eYl = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eYj = intent.getBooleanExtra("is_sub_pb", false);
        this.eYn = intent.getBooleanExtra("is_pv", false);
        this.eYm = intent.getLongExtra("msg_id", 0L);
        this.eYo = intent.getStringExtra("from_forum_name");
        this.eYx = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.eYw = intent.getStringExtra("op_stat");
        this.eYr = intent.getBooleanExtra("is_from_thread_config", false);
        this.eYs = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.eYt = intent.getBooleanExtra("is_from_my_god_config", false);
        this.eYz = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.eYy = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.eYk = intent.getBooleanExtra("from_frs", false);
        this.est = intent.getBooleanExtra("from_maintab", false);
        this.eYK = intent.getBooleanExtra("from_smart_frs", false);
        this.eYu = intent.getBooleanExtra("from_hottopic", false);
        this.eYR = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.eYW = bundle.getInt("key_start_from", 0);
        this.eXW = bundle.getString("thread_id");
        this.eXY = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eXX = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.eXZ = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.eYa = bundle.getBoolean("host_only", false);
        this.eYc = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.eYe = bundle.getInt("is_top", 0);
        this.eYf = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eYl = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eYj = bundle.getBoolean("is_sub_pb", false);
        this.eYn = bundle.getBoolean("is_pv", false);
        this.eYm = bundle.getLong("msg_id", 0L);
        this.eYo = bundle.getString("from_forum_name");
        this.eYx = bundle.getString("extra_pb_cache_key");
        this.eYr = bundle.getBoolean("is_from_thread_config", false);
        this.eYs = bundle.getBoolean("is_from_interview_live_config", false);
        this.eYt = bundle.getBoolean("is_from_my_god_config", false);
        this.eYz = bundle.getInt("extra_pb_is_attention_key", -1);
        this.eYy = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eYk = bundle.getBoolean("from_frs", false);
        this.est = bundle.getBoolean("from_maintab", false);
        this.eYK = bundle.getBoolean("from_smart_frs", false);
        this.eYu = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void u(Bundle bundle) {
        bundle.putString("thread_id", this.eXW);
        bundle.putString("post_id", this.eXY);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt("key_start_from", this.eYW);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.eXZ);
        bundle.putBoolean("host_only", this.eYa);
        bundle.putBoolean("squence", this.eYc);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.eYe);
        bundle.putLong("thread_time", this.eYf);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.eYl);
        bundle.putBoolean("is_sub_pb", this.eYj);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eYn);
        bundle.putLong("msg_id", this.eYm);
        bundle.putString("extra_pb_cache_key", this.eYx);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.eYr);
        bundle.putBoolean("is_from_interview_live_config", this.eYs);
        bundle.putBoolean("is_from_my_god_config", this.eYt);
        bundle.putInt("extra_pb_is_attention_key", this.eYz);
        bundle.putInt("extra_pb_funs_count_key", this.eYy);
        bundle.putBoolean("from_frs", this.eYk);
        bundle.putBoolean("from_maintab", this.est);
        bundle.putBoolean("from_smart_frs", this.eYK);
        bundle.putBoolean("from_hottopic", this.eYu);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String aUl() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eXW);
        if (!this.eYl) {
            sb.append(this.eXY);
        }
        sb.append(this.eYa);
        sb.append(this.eYc);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.eYe);
        sb.append(this.eYf);
        sb.append(this.eYk);
        sb.append(this.est);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eYj);
        sb.append(this.eYn);
        sb.append(this.eYm);
        sb.append(this.eYo);
        sb.append(this.mThreadType);
        sb.append(this.eYr);
        sb.append(this.eYs);
        sb.append(this.eYt);
        if (this.eYx != null) {
            sb.append(this.eYx);
        }
        return sb.toString();
    }

    public String aUm() {
        return this.eYo;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eXY;
    }

    public void pN(String str) {
        this.eXY = str;
    }

    public String aUn() {
        return this.eXW;
    }

    public boolean getHostMode() {
        return this.eYa;
    }

    public boolean aUo() {
        return this.eYc;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean aUp() {
        return this.eYk;
    }

    public boolean aUq() {
        return this.eYd;
    }

    public boolean aUr() {
        return this.est;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aUs() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aUt() {
        return this.eYe;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void iQ(int i) {
        this.eYe = i;
    }

    public boolean aUu() {
        return this.eYj;
    }

    public boolean aUv() {
        if (this.eYp == null) {
            return false;
        }
        return this.eYp.isValid();
    }

    public String rF() {
        if (this.eYp == null || !this.eYp.nH()) {
            return null;
        }
        return this.eYp.nG();
    }

    public boolean qa(int i) {
        this.eYg = i;
        if (this.eYg > this.eYp.qy().qp()) {
            this.eYg = this.eYp.qy().qp();
        }
        if (this.eYg < 1) {
            this.eYg = 1;
        }
        if (this.eXW == null) {
            return false;
        }
        return qe(5);
    }

    public boolean qb(int i) {
        int sj = this.eYp.aRq().sj();
        if (i <= sj) {
            sj = i;
        }
        int i2 = sj >= 1 ? sj : 1;
        if (this.eXW == null) {
            return false;
        }
        this.eYI = i2;
        return qe(7);
    }

    public void qc(int i) {
        this.eYg = i;
        this.eYh = i;
        this.eYi = i;
    }

    public void qd(int i) {
        if (this.eYh < i) {
            this.eYh = i;
            if (this.eYh - this.eYi >= eXV) {
                this.eYi = (this.eYh - eXV) + 1;
            }
        }
        if (this.eYi > i) {
            this.eYi = i;
            if (this.eYh - this.eYi >= eXV) {
                this.eYh = (this.eYi + eXV) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eYp;
    }

    public com.baidu.tbadk.core.data.al avJ() {
        if (this.eYp == null) {
            return null;
        }
        return this.eYp.qy();
    }

    public boolean aUw() {
        if (this.eYc && this.eYp.qy().qu() == 0) {
            jv(true);
            return true;
        }
        return false;
    }

    public void pI(String str) {
        if (!StringUtils.isNull(str)) {
            this.eXW = str;
            this.eXY = null;
            this.eYa = false;
            this.eYc = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eXW == null) {
            return false;
        }
        cancelLoadData();
        if (this.ctU == null) {
            this.ctU = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.ctU.start();
        }
        boolean qe = qe(3);
        if (this.opType != null) {
            this.opType = null;
            this.eYw = null;
            this.opUrl = null;
            return qe;
        }
        return qe;
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
        if (this.eYT != null) {
            this.eYT.cancelLoadData();
        }
        if (this.eYP != null) {
            this.eYP.cancelLoadData();
        }
        if (this.eYU != null) {
            this.eYU.cancelLoadData();
        }
        ahu();
    }

    private void ahu() {
        if (this.ctU != null) {
            this.ctU.destory();
            this.ctU = null;
        }
    }

    public boolean Fz() {
        return (this.eXY == null || this.eXY.equals("0") || this.eXY.length() == 0) ? LoadData() : aUz();
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
                this.eYT.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.eYT.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.eYU == null) {
                this.eYU = new GetSugMatchWordsModel(this.byF.getPageContext());
            }
            this.eYU.b(aVar);
        }
    }

    public boolean qe(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        qf(i);
        final com.baidu.tieba.pb.data.f pbData = ai.aVw().getPbData();
        if (pbData != null && pbData.aRq() != null) {
            pbData.aRq().bP(0);
            this.eYc = ai.aVw().aUo();
            this.eYa = ai.aVw().aVB();
            this.eYd = ai.aVw().aVC();
            this.eYY = ai.aVw().aVA();
            this.eYZ = ai.aVw().aVz();
            this.eZa = ai.aVw().aVy();
            this.eYV = this.eYa;
            if (this.eYa || this.isFromMark) {
                this.eYA = false;
            }
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.eYE) {
            a(aUE(), true, this.eXY, 3);
        }
        if (i == 3 && !this.eYE) {
            if (this.isFromMark) {
                a(aUE(), true, this.eXY, 3);
            } else {
                a(aUE(), false, this.eXY, 3);
            }
        }
        this.eYE = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aAZ);
        if (this.eYa || this.isFromMark) {
            this.eYA = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eXW == null || this.eXW.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eXW, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ac = com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst().getApp());
        int ae = com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.an.vs().vu() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ac));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ae));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.eYc) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eYa) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eYn) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eYm));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eYA) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eYw, 0));
            pbPageRequestMessage.setOpMessageID(this.eYm);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aRs = this.eYp.aRs();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eYc) {
                        if (this.eYi - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eYi - 1));
                        }
                    } else if (this.eYh < this.cgK) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eYh + 1));
                    }
                }
                if (aRs != null && aRs.size() > 0) {
                    int size = aRs.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aRs.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.eXY = postData.getId();
                            if (StringUtils.isNull(this.eXY)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.eXY != null && this.eXY.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eXY, 0L));
                } else if (!this.eYc) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aRs != null && aRs.size() > 0 && aRs.get(0) != null) {
                    this.eXY = aRs.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eYc) {
                        if (this.eYi - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eYi - 1));
                        }
                    } else if (this.eYh < this.cgK) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eYh + 1));
                    }
                }
                if (this.eXY != null && this.eXY.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eXY, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.eYa) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eYc) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eXY, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eYg));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eYc && this.eYV && !this.eYa) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eXY, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.eYa) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eYI);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eYX, 0L));
                if (!this.eYc) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.eYV = this.eYa;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aUE());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.eYW));
        pbPageRequestMessage.setIsSubPostDataReverse(this.eYH);
        pbPageRequestMessage.setFromSmartFrs(this.eYK ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eXZ);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean aTD() {
        switch (aUU()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().aRq() == null || !getPbData().aRq().sI();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aUm()) && com.baidu.tieba.recapp.q.blR().blL() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.blR().blL().V(aUm(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.blR().blL().W(aUm(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aUm()) && com.baidu.tieba.recapp.q.blR().blL() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.blR().blL().W(aUm(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.blR().blL().V(aUm(), true));
        }
    }

    protected void qf(int i) {
        boolean z = false;
        qj(i);
        ArrayList<PostData> aRs = this.eYp.aRs();
        this.eYD = false;
        if (i == 1) {
            boolean z2 = false;
            while (aRs.size() + 30 > com.baidu.tbadk.data.b.Cw()) {
                aRs.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eYp.qy().bL(1);
                if (this.eYv != null) {
                    this.eYv.f(this.eYp);
                }
            }
            this.cXD = System.currentTimeMillis();
            this.eYD = true;
        } else if (i == 2) {
            while (aRs.size() + 30 > com.baidu.tbadk.data.b.Cw()) {
                aRs.remove(aRs.size() - 1);
                z = true;
            }
            if (z) {
                this.eYp.qy().bK(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.eYL = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            i(fVar2);
            h(fVar2);
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.f fVar) {
        Long l;
        if (fVar != null && !StringUtils.isNull(this.eXX)) {
            try {
                Long valueOf = Long.valueOf(this.eXX);
                com.baidu.tieba.pb.data.n aRA = fVar.aRA();
                if (aRA != null && aRA.eQx != null) {
                    if (aRA.eQx.isEmpty() || !aRA.eQx.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.eXW);
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
            if (this.eYt || this.eYr || this.eYs) {
                fVar = k(fVar);
            }
            j(fVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String l = l(fVar);
            for (int i = 0; i < fVar.aRs().size(); i++) {
                PostData postData = fVar.aRs().get(i);
                for (int i2 = 0; i2 < postData.bwS().size(); i2++) {
                    postData.bwS().get(i2).b(this.byF.getPageContext(), l.equals(postData.bwS().get(i2).rv().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n aRA = fVar.aRA();
            if (aRA != null && !com.baidu.tbadk.core.util.v.w(aRA.eQw)) {
                for (PostData postData2 : aRA.eQw) {
                    for (int i3 = 0; i3 < postData2.bwS().size(); i3++) {
                        postData2.bwS().get(i3).b(this.byF.getPageContext(), l.equals(postData2.bwS().get(i3).rv().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String l = l(fVar);
            com.baidu.tieba.pb.data.n aRA = fVar.aRA();
            if (aRA != null && !com.baidu.tbadk.core.util.v.w(aRA.eQw)) {
                for (PostData postData : aRA.eQw.subList(i, aRA.eQw.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bwS().size()) {
                            postData.bwS().get(i3).b(this.byF.getPageContext(), l.equals(postData.bwS().get(i3).rv().getUserId()));
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
        bd aRq = fVar.aRq();
        aRq.bT(this.mIsGood);
        aRq.bS(this.eYe);
        if (this.eYf > 0) {
            aRq.m(this.eYf);
            return fVar;
        }
        return fVar;
    }

    protected String l(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aRq() != null && fVar.aRq().rv() != null) {
            str = fVar.aRq().rv().getUserId();
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
        if (fVar.aRq() != null && fVar.aRq().rv() != null) {
            str = fVar.aRq().rv().getUserName();
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
        if (fVar.aRq() != null && fVar.aRq().rv() != null) {
            str = fVar.aRq().rv().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aUx() {
        if (this.eYp == null || this.eYp.aRq() == null || this.eYp.aRq().rv() == null) {
            return null;
        }
        return this.eYp.aRq().rv();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.eYJ = z3;
        this.eYq = i;
        if (this.ctU != null && !z3) {
            this.ctU.a(z2, z4, i2, str, i3, j, j2);
            this.ctU = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aUm()) && com.baidu.tieba.recapp.q.blR().blL() != null) {
            com.baidu.tieba.recapp.q.blR().blL().f(aUm(), qg(aUG()), true);
        }
        if (fVar == null || (this.eYg == 1 && i == 5 && fVar.aRs() != null && fVar.aRs().size() < 1)) {
            if (this.eYv != null) {
                this.eYc = this.eYb;
                this.eYv.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eYb = this.eYc;
            this.eYn = false;
            if (fVar.qy() != null) {
                qd(fVar.qy().qs());
                this.cgK = fVar.qy().qp();
            }
            this.cgK = this.cgK < 1 ? 1 : this.cgK;
            ArrayList<PostData> aRs = this.eYp.aRs();
            switch (i) {
                case 1:
                    this.eYp.a(fVar.qy(), 1);
                    e(fVar, aRs);
                    i5 = 0;
                    break;
                case 2:
                    if (fVar.aRs() == null) {
                        i6 = 0;
                    } else {
                        int size = fVar.aRs().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aRs, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aRs(), com.baidu.tbadk.core.util.v.v(fVar.aRs()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            fVar.aRs().remove(postData2);
                            i6 = size - 1;
                        }
                        aRs.addAll(0, fVar.aRs());
                    }
                    this.eYp.a(fVar.qy(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.eYc && fVar.qy() != null) {
                        fVar.qy().bI(fVar.qy().qp());
                    }
                    o(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eYc) {
                        aUy();
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
                    if (fVar != null && !com.baidu.tbadk.core.util.v.w(fVar.aRs()) && this.eYp != null && (!this.eYa || l(fVar).equals(fVar.aRs().get(0).rv().getUserId()))) {
                        if (this.eYp.qy().qu() == 0) {
                            this.eYp.qy().bK(1);
                        }
                        aUV();
                        this.eYY = fVar.aRs().get(0);
                        if (this.eYc) {
                            if (this.eYp.aRs().size() - this.eZa >= 3) {
                                this.eYZ = new PostData();
                                this.eYZ.gCt = true;
                                this.eYZ.setPostType(53);
                                this.eYp.aRs().add(this.eYZ);
                            }
                            this.eYp.aRs().add(this.eYY);
                            i4 = this.eYp.aRs().size() - 1;
                        } else {
                            if (this.eZa - this.eZb >= 3) {
                                this.eYZ = new PostData();
                                this.eYZ.gCt = false;
                                this.eYZ.setPostType(53);
                                this.eYp.aRs().add(0, this.eYZ);
                            }
                            this.eYp.aRs().add(0, this.eYY);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.am.O(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.eYY.gCF = this.eYp.aRP();
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
            if (this.eYp != null && this.eYp.aRq() != null) {
                PraiseData rk = this.eYp.aRq().rk();
                if (this.eZg != null && !rk.isPriaseDataValid()) {
                    this.eYp.aRq().a(this.eZg);
                } else {
                    this.eZg = this.eYp.aRq().rk();
                    this.eZg.setPostId(this.eYp.aRq().rM());
                }
                if (fVar.qy() != null && fVar.qy().qs() == 1 && fVar.aRq() != null && fVar.aRq().rH() != null && fVar.aRq().rH().size() > 0) {
                    this.eYp.aRq().h(fVar.aRq().rH());
                }
                this.eYp.aRq().bQ(fVar.aRq().rn());
                this.eYp.aRq().bN(fVar.aRq().getAnchorLevel());
                this.eYp.aRq().bP(fVar.aRq().rg());
                if (this.mThreadType == 33) {
                    this.eYp.aRq().rv().setHadConcerned(fVar.aRq().rv().hadConcerned());
                }
                if (fVar != null && fVar.aRq() != null) {
                    this.eYp.aRq().bV(fVar.aRq().rL());
                }
            }
            if (this.eYp != null && this.eYp.getUserData() != null && fVar.getUserData() != null) {
                this.eYp.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eYp.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qy() != null && fVar.qy().qs() == 1 && fVar.aRz() != null) {
                this.eYp.c(fVar.aRz());
            }
            if (this.eYJ && this.eYp.aRq() != null && this.eYp.aRq().rv() != null && this.eYp.aRs() != null && com.baidu.tbadk.core.util.v.c(this.eYp.aRs(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.eYp.aRs(), 0);
                MetaData rv = this.eYp.aRq().rv();
                if (postData3.rv() != null && postData3.rv().getGodUserData() != null) {
                    if (this.eYy != -1) {
                        rv.setFansNum(this.eYy);
                        postData3.rv().setFansNum(this.eYy);
                    }
                    if (this.eYz != -1) {
                        rv.getGodUserData().setIsLike(this.eYz == 1);
                        postData3.rv().getGodUserData().setIsLike(this.eYz == 1);
                        rv.getGodUserData().setIsFromNetWork(false);
                        postData3.rv().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eYv != null) {
                this.eYv.a(true, getErrorCode(), i, i5, this.eYp, this.mErrorString, 1);
            }
        }
        if (this.eYp != null && this.eYp.aRq() != null && this.eYp.aRo() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.byF;
            historyMessage.threadId = getPbData().aRq().getId();
            if (this.mIsShareThread && getPbData().aRq().aaF != null) {
                historyMessage.threadName = getPbData().aRq().aaF.showText;
            } else {
                historyMessage.threadName = getPbData().aRq().getTitle();
            }
            if (this.mIsShareThread && !aTD()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().aRo().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aUo();
            historyMessage.threadType = getPbData().aRq().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ak;
        if (arrayList != null && fVar.aRs() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aRs(), 0);
            if (postData != null && (ak = ak(arrayList)) != null && ak.equals(postData.getId())) {
                fVar.aRs().remove(postData);
            }
            arrayList.addAll(fVar.aRs());
        }
    }

    private int qg(int i) {
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

    private String ak(ArrayList<PostData> arrayList) {
        int v = com.baidu.tbadk.core.util.v.v(arrayList);
        if (v <= 0) {
            return null;
        }
        for (int i = v - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(com.baidu.tieba.pb.data.f fVar) {
        fVar.pH(this.eYp.aRH());
        this.eYp = fVar;
        qc(fVar.qy().qs());
    }

    private void aUy() {
        if (this.eYp != null && this.eYp.aRs() != null && this.eYp.aRF() != null) {
            ArrayList<PostData> aRs = this.eYp.aRs();
            com.baidu.tieba.pb.data.a aRF = this.eYp.aRF();
            int aRg = aRF.aRg();
            if (aRg > 0) {
                if (aRg <= aRs.size()) {
                    aRs.add(aRg, aRF);
                } else {
                    aRs.add(aRF);
                }
            }
        }
    }

    public boolean aUz() {
        if (this.eXW == null || this.eXY == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return qe(4);
        }
        return qe(6);
    }

    public boolean jv(boolean z) {
        if (this.eXW == null || this.eYp == null) {
            return false;
        }
        if (z || this.eYp.qy().qu() != 0) {
            return qe(1);
        }
        return false;
    }

    public boolean jw(boolean z) {
        if (this.eXW == null || this.eYp == null) {
            return false;
        }
        if ((z || this.eYp.qy().qv() != 0) && this.eYp.aRs() != null && this.eYp.aRs().size() >= 1) {
            return qe(2);
        }
        return false;
    }

    public boolean pO(String str) {
        this.eYa = !this.eYa;
        this.eXY = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (qe(6)) {
            return true;
        }
        this.eYa = this.eYa ? false : true;
        return false;
    }

    public boolean k(boolean z, String str) {
        if (this.eYa == z) {
            return false;
        }
        this.eYa = z;
        this.eXY = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (qe(6)) {
            return true;
        }
        this.eYa = z ? false : true;
        return false;
    }

    public boolean aUA() {
        this.eYb = this.eYc;
        this.eYc = !this.eYc;
        if (this.isLoading || !LoadData()) {
            this.eYc = this.eYc ? false : true;
            return false;
        }
        return true;
    }

    public boolean aUB() {
        return this.eYc;
    }

    public boolean hasData() {
        return (this.eYp == null || this.eYp.aRo() == null || this.eYp.aRq() == null) ? false : true;
    }

    public boolean nH() {
        if (this.eYp == null) {
            return false;
        }
        return this.eYp.nH();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fS(String str) {
        if (this.eYp == null || this.eYp.aRq() == null || this.eYp.aRo() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eYp.aRq().sI()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eYp.aRo().getId());
            writeData.setForumName(this.eYp.aRo().getName());
        }
        writeData.sourceFrom = String.valueOf(this.eYW);
        writeData.setThreadId(this.eXW);
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

    public MarkData qh(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.eYp == null) {
            return null;
        }
        ArrayList<PostData> aRs = this.eYp.aRs();
        if (com.baidu.tbadk.core.util.v.w(aRs)) {
            return null;
        }
        if (aRs.size() > 0 && i >= aRs.size()) {
            i = aRs.size() - 1;
        }
        return h(aRs.get(i));
    }

    public MarkData aUC() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eXW);
        markData.setPostId(this.eYp.nG());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eYa);
        markData.setSequence(Boolean.valueOf(this.eYc));
        markData.setId(this.eXW);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eXW);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eYa);
        markData.setSequence(Boolean.valueOf(this.eYc));
        markData.setId(this.eXW);
        markData.setFloor(postData.bwV());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aUD() {
        i.aTY().O(aUE(), this.isFromMark);
    }

    private String aUE() {
        String str = this.eXW;
        if (this.eYa) {
            str = str + DB_KEY_HOST;
        }
        if (!this.eYc) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jx(boolean z) {
        if (this.eYp != null) {
            this.eYp.ab(z);
        }
    }

    public void jy(boolean z) {
        this.eYA = z;
    }

    public boolean aUF() {
        return this.eYA;
    }

    public void a(a aVar) {
        this.eYv = aVar;
    }

    public void pm(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dy() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dx() {
        return Fz();
    }

    public boolean pP(String str) {
        if (getPbData() == null || getPbData().aRq() == null || getPbData().aRq().rv() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aRq().rv().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aUG() {
        return this.mRequestType;
    }

    public void aUH() {
        String aUE = aUE();
        i.aTY().O(aUE, false);
        i.aTY().O(aUE, true);
    }

    public void aUI() {
        if ("personalize_page".equals(this.mStType)) {
            this.eYG = System.currentTimeMillis() / 1000;
        }
    }

    public void aUJ() {
        if ("personalize_page".equals(this.mStType) && this.eYp != null && this.eYG != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ac(ImageViewerConfig.FORUM_ID, this.eYp.getForumId()).ac("tid", this.eXW).ac("obj_duration", String.valueOf(currentTimeMillis - this.eYG)).ac("obj_param3", String.valueOf(currentTimeMillis)));
            this.eYG = 0L;
        }
    }

    public boolean aUK() {
        return this.eYJ;
    }

    public int getErrorNo() {
        return this.eYL;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public j aUL() {
        return this.eYN;
    }

    public o aUM() {
        return this.eYO;
    }

    public PbFloorAgreeModel aUN() {
        return this.eYP;
    }

    public z aUO() {
        return this.eYQ;
    }

    public CheckRealNameModel aUP() {
        return this.bHp;
    }

    public AddExperiencedModel aUQ() {
        return this.eYS;
    }

    public String aUR() {
        return this.eYF;
    }

    public void pQ(String str) {
        this.eYF = str;
    }

    public boolean aUS() {
        return this.eYK;
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.eYp != null && this.eYp.aRs() != null && this.eYp.aRs().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eYp.aRs().size();
                for (int i = 0; i < size; i++) {
                    if (this.eYp.aRs().get(i) != null && this.eYp.aRs().get(i).rv() != null && currentAccount.equals(this.eYp.aRs().get(i).rv().getUserId()) && this.eYp.aRs().get(i).rv().getPendantData() != null) {
                        this.eYp.aRs().get(i).rv().getPendantData().cF(kVar.pR());
                        this.eYp.aRs().get(i).rv().getPendantData().T(kVar.CF());
                    }
                }
            }
        }
    }

    public String aUT() {
        return this.eYR;
    }

    public int aUU() {
        return this.eYW;
    }

    public void qi(int i) {
        this.eYW = i;
    }

    public void pR(String str) {
        if ((!this.eYa || pP(TbadkCoreApplication.getCurrentAccount())) && this.eYp.aRs() != null) {
            this.eYp.qy().bK(1);
            if (this.eYp.qy().qu() == 0) {
                this.eYp.qy().bK(1);
            }
            this.eYX = str;
            qe(8);
        }
    }

    private void qj(int i) {
        if (i != 8) {
            this.eYX = "";
            if (this.eYY != null) {
                if (i == 1 && !this.eYc && !com.baidu.tbadk.core.util.v.w(getPbData().aRs())) {
                    getPbData().aRs().remove(this.eYY);
                    if (this.eYZ != null) {
                        getPbData().aRs().remove(this.eYZ);
                    }
                    getPbData().aRs().add(0, this.eYY);
                } else {
                    getPbData().aRs().remove(this.eYY);
                    if (this.eYZ != null) {
                        getPbData().aRs().remove(this.eYZ);
                    }
                }
            }
            this.eYZ = null;
        }
    }

    public void aUV() {
        if (this.eYp != null && !com.baidu.tbadk.core.util.v.w(this.eYp.aRs())) {
            if (this.eYZ != null) {
                this.eYp.aRs().remove(this.eYZ);
                this.eYZ = null;
            }
            if (this.eYY != null) {
                this.eYp.aRs().remove(this.eYY);
                this.eYY = null;
            }
        }
    }

    public void bu(int i, int i2) {
        this.eZa = i;
        this.eZb = i2;
    }

    public PostData aUW() {
        return this.eYY;
    }

    public PostData aUX() {
        return this.eYZ;
    }

    public int aUY() {
        return this.eZa;
    }

    public String aUZ() {
        return this.eZc;
    }

    public void pS(String str) {
        this.eZc = str;
    }
}
