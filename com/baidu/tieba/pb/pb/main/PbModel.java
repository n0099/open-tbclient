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
    private final CheckRealNameModel bHl;
    private BaseActivity byB;
    private long cXz;
    private int cgG;
    private com.baidu.tieba.tbadkCore.d.b ctQ;
    protected String eXR;
    private String eXS;
    private String eXT;
    private boolean eXU;
    private boolean eXV;
    private boolean eXW;
    private boolean eXX;
    private boolean eXY;
    private int eXZ;
    private String eYA;
    private long eYB;
    private boolean eYC;
    private int eYD;
    private boolean eYE;
    private boolean eYF;
    private int eYG;
    private final x eYH;
    private final j eYI;
    private final o eYJ;
    private final PbFloorAgreeModel eYK;
    private final z eYL;
    private String eYM;
    private final AddExperiencedModel eYN;
    private SuggestEmotionModel eYO;
    private GetSugMatchWordsModel eYP;
    private boolean eYQ;
    private int eYR;
    private String eYS;
    private PostData eYT;
    private PostData eYU;
    private int eYV;
    private int eYW;
    private String eYX;
    private CustomMessageListener eYY;
    private CustomMessageListener eYZ;
    private long eYa;
    private int eYb;
    private int eYc;
    private int eYd;
    private boolean eYe;
    private boolean eYf;
    private boolean eYg;
    private long eYh;
    private boolean eYi;
    private String eYj;
    protected com.baidu.tieba.pb.data.f eYk;
    private int eYl;
    private boolean eYm;
    private boolean eYn;
    private boolean eYo;
    private boolean eYp;
    private a eYq;
    private String eYr;
    private String eYs;
    private int eYt;
    private int eYu;
    private boolean eYv;
    private boolean eYw;
    private boolean eYx;
    private boolean eYy;
    private boolean eYz;
    private com.baidu.adp.framework.listener.a eZa;
    private PraiseData eZb;
    private boolean esp;
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
    private static final int eXQ = com.baidu.tbadk.data.b.Cw() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.f fVar);
    }

    public void ju(boolean z) {
        this.eYC = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eXR = null;
        this.eXS = null;
        this.eXT = null;
        this.mForumId = null;
        this.eXU = false;
        this.eXV = false;
        this.eXW = true;
        this.eXX = true;
        this.eXY = false;
        this.mIsGood = 0;
        this.eXZ = 0;
        this.eYa = 0L;
        this.eYb = 1;
        this.eYc = 1;
        this.eYd = 1;
        this.cgG = 1;
        this.isAd = false;
        this.eYe = false;
        this.eYf = false;
        this.esp = false;
        this.isFromMark = false;
        this.eYg = false;
        this.eYh = 0L;
        this.eYi = false;
        this.eYj = null;
        this.eYk = null;
        this.isLoading = false;
        this.eYm = false;
        this.eYn = false;
        this.eYo = false;
        this.eYp = false;
        this.mLocate = null;
        this.mContext = null;
        this.eYq = null;
        this.opType = null;
        this.opUrl = null;
        this.eYr = null;
        this.eYs = null;
        this.eYt = -1;
        this.eYu = -1;
        this.ctQ = null;
        this.eYw = false;
        this.eYx = false;
        this.postID = null;
        this.eYA = null;
        this.eYB = 0L;
        this.eYC = false;
        this.eYD = -1;
        this.eYF = false;
        this.eYQ = false;
        this.eYR = 0;
        this.eYY = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.eYz = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.o(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.aRp() != null) {
                        pbData.aRp().bP(0);
                    }
                    if (PbModel.this.eYq != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.eYq.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.eYZ = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aRn() != null && PbModel.this.getPbData().aRn().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aRn().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.eZa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.hh()) {
                        PbModel.this.byB.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.eYw || !PbModel.this.eYx) {
                        if (!PbModel.this.eYw) {
                            PbModel.this.eYw = true;
                        } else {
                            PbModel.this.eYx = true;
                        }
                        if (PbModel.this.eYq != null) {
                            PbModel.this.eYq.a(PbModel.this.aUj(), z, responsedMessage, PbModel.this.eYy, System.currentTimeMillis() - PbModel.this.cXz);
                        }
                    }
                }
            }
        };
        this.eZb = null;
        registerListener(this.eYY);
        registerListener(this.eZa);
        registerListener(this.eYZ);
        this.eYk = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.byB = baseActivity;
        this.eYH = new x(this, this.byB);
        this.eYI = new j(this, this.byB);
        this.eYJ = new o(this, this.byB);
        this.eYK = new PbFloorAgreeModel(this);
        this.eYL = new z(this, this.byB);
        this.bHl = new CheckRealNameModel(this.byB.getPageContext());
        this.eYO = new SuggestEmotionModel();
        this.eYN = new AddExperiencedModel(this.byB.getPageContext());
    }

    protected int aUj() {
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
        this.eXR = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eXR)) {
            this.eXR = this.eYH.W(intent);
        }
        this.eYR = intent.getIntExtra("key_start_from", 0);
        if (this.eYR == 0) {
            this.eYR = this.eYH.eZh;
        }
        this.eXT = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eXS = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.eXU = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.eXV = intent.getBooleanExtra("host_only", false);
        this.eXX = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.eXZ = intent.getIntExtra("is_top", 0);
        this.eYa = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eYg = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eYe = intent.getBooleanExtra("is_sub_pb", false);
        this.eYi = intent.getBooleanExtra("is_pv", false);
        this.eYh = intent.getLongExtra("msg_id", 0L);
        this.eYj = intent.getStringExtra("from_forum_name");
        this.eYs = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.eYr = intent.getStringExtra("op_stat");
        this.eYm = intent.getBooleanExtra("is_from_thread_config", false);
        this.eYn = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.eYo = intent.getBooleanExtra("is_from_my_god_config", false);
        this.eYu = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.eYt = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.eYf = intent.getBooleanExtra("from_frs", false);
        this.esp = intent.getBooleanExtra("from_maintab", false);
        this.eYF = intent.getBooleanExtra("from_smart_frs", false);
        this.eYp = intent.getBooleanExtra("from_hottopic", false);
        this.eYM = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.eYR = bundle.getInt("key_start_from", 0);
        this.eXR = bundle.getString("thread_id");
        this.eXT = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eXS = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.eXU = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.eXV = bundle.getBoolean("host_only", false);
        this.eXX = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.eXZ = bundle.getInt("is_top", 0);
        this.eYa = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eYg = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eYe = bundle.getBoolean("is_sub_pb", false);
        this.eYi = bundle.getBoolean("is_pv", false);
        this.eYh = bundle.getLong("msg_id", 0L);
        this.eYj = bundle.getString("from_forum_name");
        this.eYs = bundle.getString("extra_pb_cache_key");
        this.eYm = bundle.getBoolean("is_from_thread_config", false);
        this.eYn = bundle.getBoolean("is_from_interview_live_config", false);
        this.eYo = bundle.getBoolean("is_from_my_god_config", false);
        this.eYu = bundle.getInt("extra_pb_is_attention_key", -1);
        this.eYt = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eYf = bundle.getBoolean("from_frs", false);
        this.esp = bundle.getBoolean("from_maintab", false);
        this.eYF = bundle.getBoolean("from_smart_frs", false);
        this.eYp = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void u(Bundle bundle) {
        bundle.putString("thread_id", this.eXR);
        bundle.putString("post_id", this.eXT);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt("key_start_from", this.eYR);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.eXU);
        bundle.putBoolean("host_only", this.eXV);
        bundle.putBoolean("squence", this.eXX);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.eXZ);
        bundle.putLong("thread_time", this.eYa);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.eYg);
        bundle.putBoolean("is_sub_pb", this.eYe);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eYi);
        bundle.putLong("msg_id", this.eYh);
        bundle.putString("extra_pb_cache_key", this.eYs);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.eYm);
        bundle.putBoolean("is_from_interview_live_config", this.eYn);
        bundle.putBoolean("is_from_my_god_config", this.eYo);
        bundle.putInt("extra_pb_is_attention_key", this.eYu);
        bundle.putInt("extra_pb_funs_count_key", this.eYt);
        bundle.putBoolean("from_frs", this.eYf);
        bundle.putBoolean("from_maintab", this.esp);
        bundle.putBoolean("from_smart_frs", this.eYF);
        bundle.putBoolean("from_hottopic", this.eYp);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String aUk() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eXR);
        if (!this.eYg) {
            sb.append(this.eXT);
        }
        sb.append(this.eXV);
        sb.append(this.eXX);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.eXZ);
        sb.append(this.eYa);
        sb.append(this.eYf);
        sb.append(this.esp);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eYe);
        sb.append(this.eYi);
        sb.append(this.eYh);
        sb.append(this.eYj);
        sb.append(this.mThreadType);
        sb.append(this.eYm);
        sb.append(this.eYn);
        sb.append(this.eYo);
        if (this.eYs != null) {
            sb.append(this.eYs);
        }
        return sb.toString();
    }

    public String aUl() {
        return this.eYj;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eXT;
    }

    public void pN(String str) {
        this.eXT = str;
    }

    public String aUm() {
        return this.eXR;
    }

    public boolean getHostMode() {
        return this.eXV;
    }

    public boolean aUn() {
        return this.eXX;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean aUo() {
        return this.eYf;
    }

    public boolean aUp() {
        return this.eXY;
    }

    public boolean aUq() {
        return this.esp;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aUr() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aUs() {
        return this.eXZ;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void iQ(int i) {
        this.eXZ = i;
    }

    public boolean aUt() {
        return this.eYe;
    }

    public boolean aUu() {
        if (this.eYk == null) {
            return false;
        }
        return this.eYk.isValid();
    }

    public String rF() {
        if (this.eYk == null || !this.eYk.nH()) {
            return null;
        }
        return this.eYk.nG();
    }

    public boolean qa(int i) {
        this.eYb = i;
        if (this.eYb > this.eYk.qy().qp()) {
            this.eYb = this.eYk.qy().qp();
        }
        if (this.eYb < 1) {
            this.eYb = 1;
        }
        if (this.eXR == null) {
            return false;
        }
        return qe(5);
    }

    public boolean qb(int i) {
        int sj = this.eYk.aRp().sj();
        if (i <= sj) {
            sj = i;
        }
        int i2 = sj >= 1 ? sj : 1;
        if (this.eXR == null) {
            return false;
        }
        this.eYD = i2;
        return qe(7);
    }

    public void qc(int i) {
        this.eYb = i;
        this.eYc = i;
        this.eYd = i;
    }

    public void qd(int i) {
        if (this.eYc < i) {
            this.eYc = i;
            if (this.eYc - this.eYd >= eXQ) {
                this.eYd = (this.eYc - eXQ) + 1;
            }
        }
        if (this.eYd > i) {
            this.eYd = i;
            if (this.eYc - this.eYd >= eXQ) {
                this.eYc = (this.eYd + eXQ) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eYk;
    }

    public com.baidu.tbadk.core.data.al avI() {
        if (this.eYk == null) {
            return null;
        }
        return this.eYk.qy();
    }

    public boolean aUv() {
        if (this.eXX && this.eYk.qy().qu() == 0) {
            jv(true);
            return true;
        }
        return false;
    }

    public void pI(String str) {
        if (!StringUtils.isNull(str)) {
            this.eXR = str;
            this.eXT = null;
            this.eXV = false;
            this.eXX = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eXR == null) {
            return false;
        }
        cancelLoadData();
        if (this.ctQ == null) {
            this.ctQ = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.ctQ.start();
        }
        boolean qe = qe(3);
        if (this.opType != null) {
            this.opType = null;
            this.eYr = null;
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
        if (this.eYO != null) {
            this.eYO.cancelLoadData();
        }
        if (this.eYK != null) {
            this.eYK.cancelLoadData();
        }
        if (this.eYP != null) {
            this.eYP.cancelLoadData();
        }
        ahu();
    }

    private void ahu() {
        if (this.ctQ != null) {
            this.ctQ.destory();
            this.ctQ = null;
        }
    }

    public boolean Fz() {
        return (this.eXT == null || this.eXT.equals("0") || this.eXT.length() == 0) ? LoadData() : aUy();
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
                this.eYO.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.eYO.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.eYP == null) {
                this.eYP = new GetSugMatchWordsModel(this.byB.getPageContext());
            }
            this.eYP.b(aVar);
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
        final com.baidu.tieba.pb.data.f pbData = ai.aVv().getPbData();
        if (pbData != null && pbData.aRp() != null) {
            pbData.aRp().bP(0);
            this.eXX = ai.aVv().aUn();
            this.eXV = ai.aVv().aVA();
            this.eXY = ai.aVv().aVB();
            this.eYT = ai.aVv().aVz();
            this.eYU = ai.aVv().aVy();
            this.eYV = ai.aVv().aVx();
            this.eYQ = this.eXV;
            if (this.eXV || this.isFromMark) {
                this.eYv = false;
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
        if (i == 4 && !this.eYz) {
            a(aUD(), true, this.eXT, 3);
        }
        if (i == 3 && !this.eYz) {
            if (this.isFromMark) {
                a(aUD(), true, this.eXT, 3);
            } else {
                a(aUD(), false, this.eXT, 3);
            }
        }
        this.eYz = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aAW);
        if (this.eXV || this.isFromMark) {
            this.eYv = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eXR == null || this.eXR.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eXR, 0L));
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
        if (!this.eXX) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eXV) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eYi) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eYh));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eYv) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eYr, 0));
            pbPageRequestMessage.setOpMessageID(this.eYh);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aRr = this.eYk.aRr();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eXX) {
                        if (this.eYd - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eYd - 1));
                        }
                    } else if (this.eYc < this.cgG) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eYc + 1));
                    }
                }
                if (aRr != null && aRr.size() > 0) {
                    int size = aRr.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aRr.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.eXT = postData.getId();
                            if (StringUtils.isNull(this.eXT)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.eXT != null && this.eXT.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eXT, 0L));
                } else if (!this.eXX) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aRr != null && aRr.size() > 0 && aRr.get(0) != null) {
                    this.eXT = aRr.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eXX) {
                        if (this.eYd - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eYd - 1));
                        }
                    } else if (this.eYc < this.cgG) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eYc + 1));
                    }
                }
                if (this.eXT != null && this.eXT.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eXT, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.eXV) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eXX) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eXT, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eYb));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eXX && this.eYQ && !this.eXV) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eXT, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.eXV) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eYD);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eYS, 0L));
                if (!this.eXX) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.eYQ = this.eXV;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aUD());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.eYR));
        pbPageRequestMessage.setIsSubPostDataReverse(this.eYC);
        pbPageRequestMessage.setFromSmartFrs(this.eYF ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eXU);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean aTC() {
        switch (aUT()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().aRp() == null || !getPbData().aRp().sI();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aUl()) && com.baidu.tieba.recapp.q.blQ().blK() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.blQ().blK().V(aUl(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.blQ().blK().W(aUl(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aUl()) && com.baidu.tieba.recapp.q.blQ().blK() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.blQ().blK().W(aUl(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.blQ().blK().V(aUl(), true));
        }
    }

    protected void qf(int i) {
        boolean z = false;
        qj(i);
        ArrayList<PostData> aRr = this.eYk.aRr();
        this.eYy = false;
        if (i == 1) {
            boolean z2 = false;
            while (aRr.size() + 30 > com.baidu.tbadk.data.b.Cw()) {
                aRr.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eYk.qy().bL(1);
                if (this.eYq != null) {
                    this.eYq.f(this.eYk);
                }
            }
            this.cXz = System.currentTimeMillis();
            this.eYy = true;
        } else if (i == 2) {
            while (aRr.size() + 30 > com.baidu.tbadk.data.b.Cw()) {
                aRr.remove(aRr.size() - 1);
                z = true;
            }
            if (z) {
                this.eYk.qy().bK(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.eYG = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            i(fVar2);
            h(fVar2);
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.f fVar) {
        Long l;
        if (fVar != null && !StringUtils.isNull(this.eXS)) {
            try {
                Long valueOf = Long.valueOf(this.eXS);
                com.baidu.tieba.pb.data.n aRz = fVar.aRz();
                if (aRz != null && aRz.eQs != null) {
                    if (aRz.eQs.isEmpty() || !aRz.eQs.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.eXR);
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
            if (this.eYo || this.eYm || this.eYn) {
                fVar = k(fVar);
            }
            j(fVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String l = l(fVar);
            for (int i = 0; i < fVar.aRr().size(); i++) {
                PostData postData = fVar.aRr().get(i);
                for (int i2 = 0; i2 < postData.bwR().size(); i2++) {
                    postData.bwR().get(i2).b(this.byB.getPageContext(), l.equals(postData.bwR().get(i2).rv().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n aRz = fVar.aRz();
            if (aRz != null && !com.baidu.tbadk.core.util.v.w(aRz.eQr)) {
                for (PostData postData2 : aRz.eQr) {
                    for (int i3 = 0; i3 < postData2.bwR().size(); i3++) {
                        postData2.bwR().get(i3).b(this.byB.getPageContext(), l.equals(postData2.bwR().get(i3).rv().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String l = l(fVar);
            com.baidu.tieba.pb.data.n aRz = fVar.aRz();
            if (aRz != null && !com.baidu.tbadk.core.util.v.w(aRz.eQr)) {
                for (PostData postData : aRz.eQr.subList(i, aRz.eQr.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bwR().size()) {
                            postData.bwR().get(i3).b(this.byB.getPageContext(), l.equals(postData.bwR().get(i3).rv().getUserId()));
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
        bd aRp = fVar.aRp();
        aRp.bT(this.mIsGood);
        aRp.bS(this.eXZ);
        if (this.eYa > 0) {
            aRp.m(this.eYa);
            return fVar;
        }
        return fVar;
    }

    protected String l(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aRp() != null && fVar.aRp().rv() != null) {
            str = fVar.aRp().rv().getUserId();
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
        if (fVar.aRp() != null && fVar.aRp().rv() != null) {
            str = fVar.aRp().rv().getUserName();
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
        if (fVar.aRp() != null && fVar.aRp().rv() != null) {
            str = fVar.aRp().rv().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aUw() {
        if (this.eYk == null || this.eYk.aRp() == null || this.eYk.aRp().rv() == null) {
            return null;
        }
        return this.eYk.aRp().rv();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.eYE = z3;
        this.eYl = i;
        if (this.ctQ != null && !z3) {
            this.ctQ.a(z2, z4, i2, str, i3, j, j2);
            this.ctQ = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aUl()) && com.baidu.tieba.recapp.q.blQ().blK() != null) {
            com.baidu.tieba.recapp.q.blQ().blK().f(aUl(), qg(aUF()), true);
        }
        if (fVar == null || (this.eYb == 1 && i == 5 && fVar.aRr() != null && fVar.aRr().size() < 1)) {
            if (this.eYq != null) {
                this.eXX = this.eXW;
                this.eYq.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eXW = this.eXX;
            this.eYi = false;
            if (fVar.qy() != null) {
                qd(fVar.qy().qs());
                this.cgG = fVar.qy().qp();
            }
            this.cgG = this.cgG < 1 ? 1 : this.cgG;
            ArrayList<PostData> aRr = this.eYk.aRr();
            switch (i) {
                case 1:
                    this.eYk.a(fVar.qy(), 1);
                    e(fVar, aRr);
                    i5 = 0;
                    break;
                case 2:
                    if (fVar.aRr() == null) {
                        i6 = 0;
                    } else {
                        int size = fVar.aRr().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aRr, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aRr(), com.baidu.tbadk.core.util.v.v(fVar.aRr()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            fVar.aRr().remove(postData2);
                            i6 = size - 1;
                        }
                        aRr.addAll(0, fVar.aRr());
                    }
                    this.eYk.a(fVar.qy(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.eXX && fVar.qy() != null) {
                        fVar.qy().bI(fVar.qy().qp());
                    }
                    o(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eXX) {
                        aUx();
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
                    if (fVar != null && !com.baidu.tbadk.core.util.v.w(fVar.aRr()) && this.eYk != null && (!this.eXV || l(fVar).equals(fVar.aRr().get(0).rv().getUserId()))) {
                        if (this.eYk.qy().qu() == 0) {
                            this.eYk.qy().bK(1);
                        }
                        aUU();
                        this.eYT = fVar.aRr().get(0);
                        if (this.eXX) {
                            if (this.eYk.aRr().size() - this.eYV >= 3) {
                                this.eYU = new PostData();
                                this.eYU.gCo = true;
                                this.eYU.setPostType(53);
                                this.eYk.aRr().add(this.eYU);
                            }
                            this.eYk.aRr().add(this.eYT);
                            i4 = this.eYk.aRr().size() - 1;
                        } else {
                            if (this.eYV - this.eYW >= 3) {
                                this.eYU = new PostData();
                                this.eYU.gCo = false;
                                this.eYU.setPostType(53);
                                this.eYk.aRr().add(0, this.eYU);
                            }
                            this.eYk.aRr().add(0, this.eYT);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.am.O(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.eYT.gCA = this.eYk.aRO();
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
            if (this.eYk != null && this.eYk.aRp() != null) {
                PraiseData rk = this.eYk.aRp().rk();
                if (this.eZb != null && !rk.isPriaseDataValid()) {
                    this.eYk.aRp().a(this.eZb);
                } else {
                    this.eZb = this.eYk.aRp().rk();
                    this.eZb.setPostId(this.eYk.aRp().rM());
                }
                if (fVar.qy() != null && fVar.qy().qs() == 1 && fVar.aRp() != null && fVar.aRp().rH() != null && fVar.aRp().rH().size() > 0) {
                    this.eYk.aRp().h(fVar.aRp().rH());
                }
                this.eYk.aRp().bQ(fVar.aRp().rn());
                this.eYk.aRp().bN(fVar.aRp().getAnchorLevel());
                this.eYk.aRp().bP(fVar.aRp().rg());
                if (this.mThreadType == 33) {
                    this.eYk.aRp().rv().setHadConcerned(fVar.aRp().rv().hadConcerned());
                }
                if (fVar != null && fVar.aRp() != null) {
                    this.eYk.aRp().bV(fVar.aRp().rL());
                }
            }
            if (this.eYk != null && this.eYk.getUserData() != null && fVar.getUserData() != null) {
                this.eYk.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eYk.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qy() != null && fVar.qy().qs() == 1 && fVar.aRy() != null) {
                this.eYk.c(fVar.aRy());
            }
            if (this.eYE && this.eYk.aRp() != null && this.eYk.aRp().rv() != null && this.eYk.aRr() != null && com.baidu.tbadk.core.util.v.c(this.eYk.aRr(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.eYk.aRr(), 0);
                MetaData rv = this.eYk.aRp().rv();
                if (postData3.rv() != null && postData3.rv().getGodUserData() != null) {
                    if (this.eYt != -1) {
                        rv.setFansNum(this.eYt);
                        postData3.rv().setFansNum(this.eYt);
                    }
                    if (this.eYu != -1) {
                        rv.getGodUserData().setIsLike(this.eYu == 1);
                        postData3.rv().getGodUserData().setIsLike(this.eYu == 1);
                        rv.getGodUserData().setIsFromNetWork(false);
                        postData3.rv().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eYq != null) {
                this.eYq.a(true, getErrorCode(), i, i5, this.eYk, this.mErrorString, 1);
            }
        }
        if (this.eYk != null && this.eYk.aRp() != null && this.eYk.aRn() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.byB;
            historyMessage.threadId = getPbData().aRp().getId();
            if (this.mIsShareThread && getPbData().aRp().aaC != null) {
                historyMessage.threadName = getPbData().aRp().aaC.showText;
            } else {
                historyMessage.threadName = getPbData().aRp().getTitle();
            }
            if (this.mIsShareThread && !aTC()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().aRn().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aUn();
            historyMessage.threadType = getPbData().aRp().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ak;
        if (arrayList != null && fVar.aRr() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aRr(), 0);
            if (postData != null && (ak = ak(arrayList)) != null && ak.equals(postData.getId())) {
                fVar.aRr().remove(postData);
            }
            arrayList.addAll(fVar.aRr());
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
        fVar.pH(this.eYk.aRG());
        this.eYk = fVar;
        qc(fVar.qy().qs());
    }

    private void aUx() {
        if (this.eYk != null && this.eYk.aRr() != null && this.eYk.aRE() != null) {
            ArrayList<PostData> aRr = this.eYk.aRr();
            com.baidu.tieba.pb.data.a aRE = this.eYk.aRE();
            int aRf = aRE.aRf();
            if (aRf > 0) {
                if (aRf <= aRr.size()) {
                    aRr.add(aRf, aRE);
                } else {
                    aRr.add(aRE);
                }
            }
        }
    }

    public boolean aUy() {
        if (this.eXR == null || this.eXT == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return qe(4);
        }
        return qe(6);
    }

    public boolean jv(boolean z) {
        if (this.eXR == null || this.eYk == null) {
            return false;
        }
        if (z || this.eYk.qy().qu() != 0) {
            return qe(1);
        }
        return false;
    }

    public boolean jw(boolean z) {
        if (this.eXR == null || this.eYk == null) {
            return false;
        }
        if ((z || this.eYk.qy().qv() != 0) && this.eYk.aRr() != null && this.eYk.aRr().size() >= 1) {
            return qe(2);
        }
        return false;
    }

    public boolean pO(String str) {
        this.eXV = !this.eXV;
        this.eXT = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (qe(6)) {
            return true;
        }
        this.eXV = this.eXV ? false : true;
        return false;
    }

    public boolean k(boolean z, String str) {
        if (this.eXV == z) {
            return false;
        }
        this.eXV = z;
        this.eXT = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (qe(6)) {
            return true;
        }
        this.eXV = z ? false : true;
        return false;
    }

    public boolean aUz() {
        this.eXW = this.eXX;
        this.eXX = !this.eXX;
        if (this.isLoading || !LoadData()) {
            this.eXX = this.eXX ? false : true;
            return false;
        }
        return true;
    }

    public boolean aUA() {
        return this.eXX;
    }

    public boolean hasData() {
        return (this.eYk == null || this.eYk.aRn() == null || this.eYk.aRp() == null) ? false : true;
    }

    public boolean nH() {
        if (this.eYk == null) {
            return false;
        }
        return this.eYk.nH();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fS(String str) {
        if (this.eYk == null || this.eYk.aRp() == null || this.eYk.aRn() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eYk.aRp().sI()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eYk.aRn().getId());
            writeData.setForumName(this.eYk.aRn().getName());
        }
        writeData.sourceFrom = String.valueOf(this.eYR);
        writeData.setThreadId(this.eXR);
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
        if (this.eYk == null) {
            return null;
        }
        ArrayList<PostData> aRr = this.eYk.aRr();
        if (com.baidu.tbadk.core.util.v.w(aRr)) {
            return null;
        }
        if (aRr.size() > 0 && i >= aRr.size()) {
            i = aRr.size() - 1;
        }
        return h(aRr.get(i));
    }

    public MarkData aUB() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eXR);
        markData.setPostId(this.eYk.nG());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eXV);
        markData.setSequence(Boolean.valueOf(this.eXX));
        markData.setId(this.eXR);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eXR);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eXV);
        markData.setSequence(Boolean.valueOf(this.eXX));
        markData.setId(this.eXR);
        markData.setFloor(postData.bwU());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aUC() {
        i.aTX().O(aUD(), this.isFromMark);
    }

    private String aUD() {
        String str = this.eXR;
        if (this.eXV) {
            str = str + DB_KEY_HOST;
        }
        if (!this.eXX) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jx(boolean z) {
        if (this.eYk != null) {
            this.eYk.ab(z);
        }
    }

    public void jy(boolean z) {
        this.eYv = z;
    }

    public boolean aUE() {
        return this.eYv;
    }

    public void a(a aVar) {
        this.eYq = aVar;
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
        if (getPbData() == null || getPbData().aRp() == null || getPbData().aRp().rv() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aRp().rv().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aUF() {
        return this.mRequestType;
    }

    public void aUG() {
        String aUD = aUD();
        i.aTX().O(aUD, false);
        i.aTX().O(aUD, true);
    }

    public void aUH() {
        if ("personalize_page".equals(this.mStType)) {
            this.eYB = System.currentTimeMillis() / 1000;
        }
    }

    public void aUI() {
        if ("personalize_page".equals(this.mStType) && this.eYk != null && this.eYB != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ac(ImageViewerConfig.FORUM_ID, this.eYk.getForumId()).ac("tid", this.eXR).ac("obj_duration", String.valueOf(currentTimeMillis - this.eYB)).ac("obj_param3", String.valueOf(currentTimeMillis)));
            this.eYB = 0L;
        }
    }

    public boolean aUJ() {
        return this.eYE;
    }

    public int getErrorNo() {
        return this.eYG;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public j aUK() {
        return this.eYI;
    }

    public o aUL() {
        return this.eYJ;
    }

    public PbFloorAgreeModel aUM() {
        return this.eYK;
    }

    public z aUN() {
        return this.eYL;
    }

    public CheckRealNameModel aUO() {
        return this.bHl;
    }

    public AddExperiencedModel aUP() {
        return this.eYN;
    }

    public String aUQ() {
        return this.eYA;
    }

    public void pQ(String str) {
        this.eYA = str;
    }

    public boolean aUR() {
        return this.eYF;
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.eYk != null && this.eYk.aRr() != null && this.eYk.aRr().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eYk.aRr().size();
                for (int i = 0; i < size; i++) {
                    if (this.eYk.aRr().get(i) != null && this.eYk.aRr().get(i).rv() != null && currentAccount.equals(this.eYk.aRr().get(i).rv().getUserId()) && this.eYk.aRr().get(i).rv().getPendantData() != null) {
                        this.eYk.aRr().get(i).rv().getPendantData().cF(kVar.pR());
                        this.eYk.aRr().get(i).rv().getPendantData().T(kVar.CF());
                    }
                }
            }
        }
    }

    public String aUS() {
        return this.eYM;
    }

    public int aUT() {
        return this.eYR;
    }

    public void qi(int i) {
        this.eYR = i;
    }

    public void pR(String str) {
        if ((!this.eXV || pP(TbadkCoreApplication.getCurrentAccount())) && this.eYk.aRr() != null) {
            this.eYk.qy().bK(1);
            if (this.eYk.qy().qu() == 0) {
                this.eYk.qy().bK(1);
            }
            this.eYS = str;
            qe(8);
        }
    }

    private void qj(int i) {
        if (i != 8) {
            this.eYS = "";
            if (this.eYT != null) {
                if (i == 1 && !this.eXX && !com.baidu.tbadk.core.util.v.w(getPbData().aRr())) {
                    getPbData().aRr().remove(this.eYT);
                    if (this.eYU != null) {
                        getPbData().aRr().remove(this.eYU);
                    }
                    getPbData().aRr().add(0, this.eYT);
                } else {
                    getPbData().aRr().remove(this.eYT);
                    if (this.eYU != null) {
                        getPbData().aRr().remove(this.eYU);
                    }
                }
            }
            this.eYU = null;
        }
    }

    public void aUU() {
        if (this.eYk != null && !com.baidu.tbadk.core.util.v.w(this.eYk.aRr())) {
            if (this.eYU != null) {
                this.eYk.aRr().remove(this.eYU);
                this.eYU = null;
            }
            if (this.eYT != null) {
                this.eYk.aRr().remove(this.eYT);
                this.eYT = null;
            }
        }
    }

    public void bu(int i, int i2) {
        this.eYV = i;
        this.eYW = i2;
    }

    public PostData aUV() {
        return this.eYT;
    }

    public PostData aUW() {
        return this.eYU;
    }

    public int aUX() {
        return this.eYV;
    }

    public String aUY() {
        return this.eYX;
    }

    public void pS(String str) {
        this.eYX = str;
    }
}
