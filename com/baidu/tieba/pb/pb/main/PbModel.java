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
    private final CheckRealNameModel bHh;
    private BaseActivity byz;
    private long cXo;
    private int cgs;
    private com.baidu.tieba.tbadkCore.d.b ctH;
    protected String eWO;
    private String eWP;
    private String eWQ;
    private boolean eWR;
    private boolean eWS;
    private boolean eWT;
    private boolean eWU;
    private boolean eWV;
    private int eWW;
    private long eWX;
    private int eWY;
    private int eWZ;
    private int eXA;
    private boolean eXB;
    private boolean eXC;
    private int eXD;
    private final x eXE;
    private final j eXF;
    private final o eXG;
    private final PbFloorAgreeModel eXH;
    private final z eXI;
    private String eXJ;
    private final AddExperiencedModel eXK;
    private SuggestEmotionModel eXL;
    private GetSugMatchWordsModel eXM;
    private boolean eXN;
    private int eXO;
    private String eXP;
    private PostData eXQ;
    private PostData eXR;
    private int eXS;
    private int eXT;
    private String eXU;
    private CustomMessageListener eXV;
    private CustomMessageListener eXW;
    private com.baidu.adp.framework.listener.a eXX;
    private PraiseData eXY;
    private int eXa;
    private boolean eXb;
    private boolean eXc;
    private boolean eXd;
    private long eXe;
    private boolean eXf;
    private String eXg;
    protected com.baidu.tieba.pb.data.f eXh;
    private int eXi;
    private boolean eXj;
    private boolean eXk;
    private boolean eXl;
    private boolean eXm;
    private a eXn;
    private String eXo;
    private String eXp;
    private int eXq;
    private int eXr;
    private boolean eXs;
    private boolean eXt;
    private boolean eXu;
    private boolean eXv;
    private boolean eXw;
    private String eXx;
    private long eXy;
    private boolean eXz;
    private boolean erk;
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
    private static final int eWN = com.baidu.tbadk.data.b.Cv() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.f fVar);
    }

    public void jt(boolean z) {
        this.eXz = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eWO = null;
        this.eWP = null;
        this.eWQ = null;
        this.mForumId = null;
        this.eWR = false;
        this.eWS = false;
        this.eWT = true;
        this.eWU = true;
        this.eWV = false;
        this.mIsGood = 0;
        this.eWW = 0;
        this.eWX = 0L;
        this.eWY = 1;
        this.eWZ = 1;
        this.eXa = 1;
        this.cgs = 1;
        this.isAd = false;
        this.eXb = false;
        this.eXc = false;
        this.erk = false;
        this.isFromMark = false;
        this.eXd = false;
        this.eXe = 0L;
        this.eXf = false;
        this.eXg = null;
        this.eXh = null;
        this.isLoading = false;
        this.eXj = false;
        this.eXk = false;
        this.eXl = false;
        this.eXm = false;
        this.mLocate = null;
        this.mContext = null;
        this.eXn = null;
        this.opType = null;
        this.opUrl = null;
        this.eXo = null;
        this.eXp = null;
        this.eXq = -1;
        this.eXr = -1;
        this.ctH = null;
        this.eXt = false;
        this.eXu = false;
        this.postID = null;
        this.eXx = null;
        this.eXy = 0L;
        this.eXz = false;
        this.eXA = -1;
        this.eXC = false;
        this.eXN = false;
        this.eXO = 0;
        this.eXV = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.eXw = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.o(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.aRh() != null) {
                        pbData.aRh().bP(0);
                    }
                    if (PbModel.this.eXn != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.eXn.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.eXW = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aRf() != null && PbModel.this.getPbData().aRf().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aRf().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.eXX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.hh()) {
                        PbModel.this.byz.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.eXt || !PbModel.this.eXu) {
                        if (!PbModel.this.eXt) {
                            PbModel.this.eXt = true;
                        } else {
                            PbModel.this.eXu = true;
                        }
                        if (PbModel.this.eXn != null) {
                            PbModel.this.eXn.a(PbModel.this.aUb(), z, responsedMessage, PbModel.this.eXv, System.currentTimeMillis() - PbModel.this.cXo);
                        }
                    }
                }
            }
        };
        this.eXY = null;
        registerListener(this.eXV);
        registerListener(this.eXX);
        registerListener(this.eXW);
        this.eXh = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.byz = baseActivity;
        this.eXE = new x(this, this.byz);
        this.eXF = new j(this, this.byz);
        this.eXG = new o(this, this.byz);
        this.eXH = new PbFloorAgreeModel(this);
        this.eXI = new z(this, this.byz);
        this.bHh = new CheckRealNameModel(this.byz.getPageContext());
        this.eXL = new SuggestEmotionModel();
        this.eXK = new AddExperiencedModel(this.byz.getPageContext());
    }

    protected int aUb() {
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
        this.eWO = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eWO)) {
            this.eWO = this.eXE.W(intent);
        }
        this.eXO = intent.getIntExtra("key_start_from", 0);
        if (this.eXO == 0) {
            this.eXO = this.eXE.eYe;
        }
        this.eWQ = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eWP = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.eWR = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.eWS = intent.getBooleanExtra("host_only", false);
        this.eWU = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.eWW = intent.getIntExtra("is_top", 0);
        this.eWX = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eXd = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eXb = intent.getBooleanExtra("is_sub_pb", false);
        this.eXf = intent.getBooleanExtra("is_pv", false);
        this.eXe = intent.getLongExtra("msg_id", 0L);
        this.eXg = intent.getStringExtra("from_forum_name");
        this.eXp = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.eXo = intent.getStringExtra("op_stat");
        this.eXj = intent.getBooleanExtra("is_from_thread_config", false);
        this.eXk = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.eXl = intent.getBooleanExtra("is_from_my_god_config", false);
        this.eXr = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.eXq = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.eXc = intent.getBooleanExtra("from_frs", false);
        this.erk = intent.getBooleanExtra("from_maintab", false);
        this.eXC = intent.getBooleanExtra("from_smart_frs", false);
        this.eXm = intent.getBooleanExtra("from_hottopic", false);
        this.eXJ = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.eXO = bundle.getInt("key_start_from", 0);
        this.eWO = bundle.getString("thread_id");
        this.eWQ = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eWP = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.eWR = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.eWS = bundle.getBoolean("host_only", false);
        this.eWU = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.eWW = bundle.getInt("is_top", 0);
        this.eWX = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eXd = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eXb = bundle.getBoolean("is_sub_pb", false);
        this.eXf = bundle.getBoolean("is_pv", false);
        this.eXe = bundle.getLong("msg_id", 0L);
        this.eXg = bundle.getString("from_forum_name");
        this.eXp = bundle.getString("extra_pb_cache_key");
        this.eXj = bundle.getBoolean("is_from_thread_config", false);
        this.eXk = bundle.getBoolean("is_from_interview_live_config", false);
        this.eXl = bundle.getBoolean("is_from_my_god_config", false);
        this.eXr = bundle.getInt("extra_pb_is_attention_key", -1);
        this.eXq = bundle.getInt("extra_pb_funs_count_key", -1);
        this.eXc = bundle.getBoolean("from_frs", false);
        this.erk = bundle.getBoolean("from_maintab", false);
        this.eXC = bundle.getBoolean("from_smart_frs", false);
        this.eXm = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void u(Bundle bundle) {
        bundle.putString("thread_id", this.eWO);
        bundle.putString("post_id", this.eWQ);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt("key_start_from", this.eXO);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.eWR);
        bundle.putBoolean("host_only", this.eWS);
        bundle.putBoolean("squence", this.eWU);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.eWW);
        bundle.putLong("thread_time", this.eWX);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.eXd);
        bundle.putBoolean("is_sub_pb", this.eXb);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eXf);
        bundle.putLong("msg_id", this.eXe);
        bundle.putString("extra_pb_cache_key", this.eXp);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.eXj);
        bundle.putBoolean("is_from_interview_live_config", this.eXk);
        bundle.putBoolean("is_from_my_god_config", this.eXl);
        bundle.putInt("extra_pb_is_attention_key", this.eXr);
        bundle.putInt("extra_pb_funs_count_key", this.eXq);
        bundle.putBoolean("from_frs", this.eXc);
        bundle.putBoolean("from_maintab", this.erk);
        bundle.putBoolean("from_smart_frs", this.eXC);
        bundle.putBoolean("from_hottopic", this.eXm);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String aUc() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eWO);
        if (!this.eXd) {
            sb.append(this.eWQ);
        }
        sb.append(this.eWS);
        sb.append(this.eWU);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.eWW);
        sb.append(this.eWX);
        sb.append(this.eXc);
        sb.append(this.erk);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eXb);
        sb.append(this.eXf);
        sb.append(this.eXe);
        sb.append(this.eXg);
        sb.append(this.mThreadType);
        sb.append(this.eXj);
        sb.append(this.eXk);
        sb.append(this.eXl);
        if (this.eXp != null) {
            sb.append(this.eXp);
        }
        return sb.toString();
    }

    public String aUd() {
        return this.eXg;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eWQ;
    }

    public void pN(String str) {
        this.eWQ = str;
    }

    public String aUe() {
        return this.eWO;
    }

    public boolean getHostMode() {
        return this.eWS;
    }

    public boolean aUf() {
        return this.eWU;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean aUg() {
        return this.eXc;
    }

    public boolean aUh() {
        return this.eWV;
    }

    public boolean aUi() {
        return this.erk;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aUj() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aUk() {
        return this.eWW;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void iO(int i) {
        this.eWW = i;
    }

    public boolean aUl() {
        return this.eXb;
    }

    public boolean aUm() {
        if (this.eXh == null) {
            return false;
        }
        return this.eXh.isValid();
    }

    public String rH() {
        if (this.eXh == null || !this.eXh.nJ()) {
            return null;
        }
        return this.eXh.nI();
    }

    public boolean pT(int i) {
        this.eWY = i;
        if (this.eWY > this.eXh.qA().qr()) {
            this.eWY = this.eXh.qA().qr();
        }
        if (this.eWY < 1) {
            this.eWY = 1;
        }
        if (this.eWO == null) {
            return false;
        }
        return pX(5);
    }

    public boolean pU(int i) {
        int sl = this.eXh.aRh().sl();
        if (i <= sl) {
            sl = i;
        }
        int i2 = sl >= 1 ? sl : 1;
        if (this.eWO == null) {
            return false;
        }
        this.eXA = i2;
        return pX(7);
    }

    public void pV(int i) {
        this.eWY = i;
        this.eWZ = i;
        this.eXa = i;
    }

    public void pW(int i) {
        if (this.eWZ < i) {
            this.eWZ = i;
            if (this.eWZ - this.eXa >= eWN) {
                this.eXa = (this.eWZ - eWN) + 1;
            }
        }
        if (this.eXa > i) {
            this.eXa = i;
            if (this.eWZ - this.eXa >= eWN) {
                this.eWZ = (this.eXa + eWN) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eXh;
    }

    public com.baidu.tbadk.core.data.al avA() {
        if (this.eXh == null) {
            return null;
        }
        return this.eXh.qA();
    }

    public boolean aUn() {
        if (this.eWU && this.eXh.qA().qw() == 0) {
            ju(true);
            return true;
        }
        return false;
    }

    public void pI(String str) {
        if (!StringUtils.isNull(str)) {
            this.eWO = str;
            this.eWQ = null;
            this.eWS = false;
            this.eWU = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eWO == null) {
            return false;
        }
        cancelLoadData();
        if (this.ctH == null) {
            this.ctH = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.ctH.start();
        }
        boolean pX = pX(3);
        if (this.opType != null) {
            this.opType = null;
            this.eXo = null;
            this.opUrl = null;
            return pX;
        }
        return pX;
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
        if (this.eXL != null) {
            this.eXL.cancelLoadData();
        }
        if (this.eXH != null) {
            this.eXH.cancelLoadData();
        }
        if (this.eXM != null) {
            this.eXM.cancelLoadData();
        }
        ahn();
    }

    private void ahn() {
        if (this.ctH != null) {
            this.ctH.destory();
            this.ctH = null;
        }
    }

    public boolean Fy() {
        return (this.eWQ == null || this.eWQ.equals("0") || this.eWQ.length() == 0) ? LoadData() : aUq();
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
                this.eXL.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.eXL.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.eXM == null) {
                this.eXM = new GetSugMatchWordsModel(this.byz.getPageContext());
            }
            this.eXM.b(aVar);
        }
    }

    public boolean pX(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        pY(i);
        final com.baidu.tieba.pb.data.f pbData = ai.aVn().getPbData();
        if (pbData != null && pbData.aRh() != null) {
            pbData.aRh().bP(0);
            this.eWU = ai.aVn().aUf();
            this.eWS = ai.aVn().aVs();
            this.eWV = ai.aVn().aVt();
            this.eXQ = ai.aVn().aVr();
            this.eXR = ai.aVn().aVq();
            this.eXS = ai.aVn().aVp();
            this.eXN = this.eWS;
            if (this.eWS || this.isFromMark) {
                this.eXs = false;
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
        if (i == 4 && !this.eXw) {
            a(aUv(), true, this.eWQ, 3);
        }
        if (i == 3 && !this.eXw) {
            if (this.isFromMark) {
                a(aUv(), true, this.eWQ, 3);
            } else {
                a(aUv(), false, this.eWQ, 3);
            }
        }
        this.eXw = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aAR);
        if (this.eWS || this.isFromMark) {
            this.eXs = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eWO == null || this.eWO.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eWO, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ac = com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst().getApp());
        int ae = com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.an.vv().vx() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ac));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ae));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.eWU) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eWS) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eXf) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eXe));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eXs) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eXo, 0));
            pbPageRequestMessage.setOpMessageID(this.eXe);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aRj = this.eXh.aRj();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eWU) {
                        if (this.eXa - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eXa - 1));
                        }
                    } else if (this.eWZ < this.cgs) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eWZ + 1));
                    }
                }
                if (aRj != null && aRj.size() > 0) {
                    int size = aRj.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aRj.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.eWQ = postData.getId();
                            if (StringUtils.isNull(this.eWQ)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.eWQ != null && this.eWQ.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eWQ, 0L));
                } else if (!this.eWU) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aRj != null && aRj.size() > 0 && aRj.get(0) != null) {
                    this.eWQ = aRj.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eWU) {
                        if (this.eXa - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eXa - 1));
                        }
                    } else if (this.eWZ < this.cgs) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eWZ + 1));
                    }
                }
                if (this.eWQ != null && this.eWQ.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eWQ, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.eWS) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eWU) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eWQ, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eWY));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eWU && this.eXN && !this.eWS) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eWQ, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.eWS) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eXA);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eXP, 0L));
                if (!this.eWU) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.eXN = this.eWS;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aUv());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.eXO));
        pbPageRequestMessage.setIsSubPostDataReverse(this.eXz);
        pbPageRequestMessage.setFromSmartFrs(this.eXC ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eWR);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean aTu() {
        switch (aUL()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().aRh() == null || !getPbData().aRh().sK();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aUd()) && com.baidu.tieba.recapp.q.bll().blf() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.bll().blf().U(aUd(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.bll().blf().V(aUd(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aUd()) && com.baidu.tieba.recapp.q.bll().blf() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.bll().blf().V(aUd(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.q.bll().blf().U(aUd(), true));
        }
    }

    protected void pY(int i) {
        boolean z = false;
        qc(i);
        ArrayList<PostData> aRj = this.eXh.aRj();
        this.eXv = false;
        if (i == 1) {
            boolean z2 = false;
            while (aRj.size() + 30 > com.baidu.tbadk.data.b.Cv()) {
                aRj.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eXh.qA().bL(1);
                if (this.eXn != null) {
                    this.eXn.f(this.eXh);
                }
            }
            this.cXo = System.currentTimeMillis();
            this.eXv = true;
        } else if (i == 2) {
            while (aRj.size() + 30 > com.baidu.tbadk.data.b.Cv()) {
                aRj.remove(aRj.size() - 1);
                z = true;
            }
            if (z) {
                this.eXh.qA().bK(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.eXD = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            i(fVar2);
            h(fVar2);
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.f fVar) {
        Long l;
        if (fVar != null && !StringUtils.isNull(this.eWP)) {
            try {
                Long valueOf = Long.valueOf(this.eWP);
                com.baidu.tieba.pb.data.n aRr = fVar.aRr();
                if (aRr != null && aRr.ePp != null) {
                    if (aRr.ePp.isEmpty() || !aRr.ePp.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.eWO);
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
            if (this.eXl || this.eXj || this.eXk) {
                fVar = k(fVar);
            }
            j(fVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String l = l(fVar);
            for (int i = 0; i < fVar.aRj().size(); i++) {
                PostData postData = fVar.aRj().get(i);
                for (int i2 = 0; i2 < postData.bwl().size(); i2++) {
                    postData.bwl().get(i2).b(this.byz.getPageContext(), l.equals(postData.bwl().get(i2).rx().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n aRr = fVar.aRr();
            if (aRr != null && !com.baidu.tbadk.core.util.v.w(aRr.ePo)) {
                for (PostData postData2 : aRr.ePo) {
                    for (int i3 = 0; i3 < postData2.bwl().size(); i3++) {
                        postData2.bwl().get(i3).b(this.byz.getPageContext(), l.equals(postData2.bwl().get(i3).rx().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String l = l(fVar);
            com.baidu.tieba.pb.data.n aRr = fVar.aRr();
            if (aRr != null && !com.baidu.tbadk.core.util.v.w(aRr.ePo)) {
                for (PostData postData : aRr.ePo.subList(i, aRr.ePo.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bwl().size()) {
                            postData.bwl().get(i3).b(this.byz.getPageContext(), l.equals(postData.bwl().get(i3).rx().getUserId()));
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
        bd aRh = fVar.aRh();
        aRh.bT(this.mIsGood);
        aRh.bS(this.eWW);
        if (this.eWX > 0) {
            aRh.m(this.eWX);
            return fVar;
        }
        return fVar;
    }

    protected String l(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aRh() != null && fVar.aRh().rx() != null) {
            str = fVar.aRh().rx().getUserId();
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
        if (fVar.aRh() != null && fVar.aRh().rx() != null) {
            str = fVar.aRh().rx().getUserName();
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
        if (fVar.aRh() != null && fVar.aRh().rx() != null) {
            str = fVar.aRh().rx().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aUo() {
        if (this.eXh == null || this.eXh.aRh() == null || this.eXh.aRh().rx() == null) {
            return null;
        }
        return this.eXh.aRh().rx();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.eXB = z3;
        this.eXi = i;
        if (this.ctH != null && !z3) {
            this.ctH.a(z2, z4, i2, str, i3, j, j2);
            this.ctH = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aUd()) && com.baidu.tieba.recapp.q.bll().blf() != null) {
            com.baidu.tieba.recapp.q.bll().blf().f(aUd(), pZ(aUx()), true);
        }
        if (fVar == null || (this.eWY == 1 && i == 5 && fVar.aRj() != null && fVar.aRj().size() < 1)) {
            if (this.eXn != null) {
                this.eWU = this.eWT;
                this.eXn.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eWT = this.eWU;
            this.eXf = false;
            if (fVar.qA() != null) {
                pW(fVar.qA().qu());
                this.cgs = fVar.qA().qr();
            }
            this.cgs = this.cgs < 1 ? 1 : this.cgs;
            ArrayList<PostData> aRj = this.eXh.aRj();
            switch (i) {
                case 1:
                    this.eXh.a(fVar.qA(), 1);
                    e(fVar, aRj);
                    i5 = 0;
                    break;
                case 2:
                    if (fVar.aRj() == null) {
                        i6 = 0;
                    } else {
                        int size = fVar.aRj().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aRj, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aRj(), com.baidu.tbadk.core.util.v.v(fVar.aRj()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            fVar.aRj().remove(postData2);
                            i6 = size - 1;
                        }
                        aRj.addAll(0, fVar.aRj());
                    }
                    this.eXh.a(fVar.qA(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.eWU && fVar.qA() != null) {
                        fVar.qA().bI(fVar.qA().qr());
                    }
                    o(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eWU) {
                        aUp();
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
                    if (fVar != null && !com.baidu.tbadk.core.util.v.w(fVar.aRj()) && this.eXh != null && (!this.eWS || l(fVar).equals(fVar.aRj().get(0).rx().getUserId()))) {
                        if (this.eXh.qA().qw() == 0) {
                            this.eXh.qA().bK(1);
                        }
                        aUM();
                        this.eXQ = fVar.aRj().get(0);
                        if (this.eWU) {
                            if (this.eXh.aRj().size() - this.eXS >= 3) {
                                this.eXR = new PostData();
                                this.eXR.gzF = true;
                                this.eXR.setPostType(53);
                                this.eXh.aRj().add(this.eXR);
                            }
                            this.eXh.aRj().add(this.eXQ);
                            i4 = this.eXh.aRj().size() - 1;
                        } else {
                            if (this.eXS - this.eXT >= 3) {
                                this.eXR = new PostData();
                                this.eXR.gzF = false;
                                this.eXR.setPostType(53);
                                this.eXh.aRj().add(0, this.eXR);
                            }
                            this.eXh.aRj().add(0, this.eXQ);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.am.O(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.eXQ.gzR = this.eXh.aRG();
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
            if (this.eXh != null && this.eXh.aRh() != null) {
                PraiseData rm = this.eXh.aRh().rm();
                if (this.eXY != null && !rm.isPriaseDataValid()) {
                    this.eXh.aRh().a(this.eXY);
                } else {
                    this.eXY = this.eXh.aRh().rm();
                    this.eXY.setPostId(this.eXh.aRh().rO());
                }
                if (fVar.qA() != null && fVar.qA().qu() == 1 && fVar.aRh() != null && fVar.aRh().rJ() != null && fVar.aRh().rJ().size() > 0) {
                    this.eXh.aRh().h(fVar.aRh().rJ());
                }
                this.eXh.aRh().bQ(fVar.aRh().rp());
                this.eXh.aRh().bN(fVar.aRh().getAnchorLevel());
                this.eXh.aRh().bP(fVar.aRh().ri());
                if (this.mThreadType == 33) {
                    this.eXh.aRh().rx().setHadConcerned(fVar.aRh().rx().hadConcerned());
                }
                if (fVar != null && fVar.aRh() != null) {
                    this.eXh.aRh().bV(fVar.aRh().rN());
                }
            }
            if (this.eXh != null && this.eXh.getUserData() != null && fVar.getUserData() != null) {
                this.eXh.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eXh.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qA() != null && fVar.qA().qu() == 1 && fVar.aRq() != null) {
                this.eXh.c(fVar.aRq());
            }
            if (this.eXB && this.eXh.aRh() != null && this.eXh.aRh().rx() != null && this.eXh.aRj() != null && com.baidu.tbadk.core.util.v.c(this.eXh.aRj(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.eXh.aRj(), 0);
                MetaData rx = this.eXh.aRh().rx();
                if (postData3.rx() != null && postData3.rx().getGodUserData() != null) {
                    if (this.eXq != -1) {
                        rx.setFansNum(this.eXq);
                        postData3.rx().setFansNum(this.eXq);
                    }
                    if (this.eXr != -1) {
                        rx.getGodUserData().setIsLike(this.eXr == 1);
                        postData3.rx().getGodUserData().setIsLike(this.eXr == 1);
                        rx.getGodUserData().setIsFromNetWork(false);
                        postData3.rx().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eXn != null) {
                this.eXn.a(true, getErrorCode(), i, i5, this.eXh, this.mErrorString, 1);
            }
        }
        if (this.eXh != null && this.eXh.aRh() != null && this.eXh.aRf() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.byz;
            historyMessage.threadId = getPbData().aRh().getId();
            if (this.mIsShareThread && getPbData().aRh().aaI != null) {
                historyMessage.threadName = getPbData().aRh().aaI.showText;
            } else {
                historyMessage.threadName = getPbData().aRh().getTitle();
            }
            if (this.mIsShareThread && !aTu()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().aRf().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aUf();
            historyMessage.threadType = getPbData().aRh().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aj;
        if (arrayList != null && fVar.aRj() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aRj(), 0);
            if (postData != null && (aj = aj(arrayList)) != null && aj.equals(postData.getId())) {
                fVar.aRj().remove(postData);
            }
            arrayList.addAll(fVar.aRj());
        }
    }

    private int pZ(int i) {
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

    private String aj(ArrayList<PostData> arrayList) {
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
        fVar.pH(this.eXh.aRy());
        this.eXh = fVar;
        pV(fVar.qA().qu());
    }

    private void aUp() {
        if (this.eXh != null && this.eXh.aRj() != null && this.eXh.aRw() != null) {
            ArrayList<PostData> aRj = this.eXh.aRj();
            com.baidu.tieba.pb.data.a aRw = this.eXh.aRw();
            int aQX = aRw.aQX();
            if (aQX > 0) {
                if (aQX <= aRj.size()) {
                    aRj.add(aQX, aRw);
                } else {
                    aRj.add(aRw);
                }
            }
        }
    }

    public boolean aUq() {
        if (this.eWO == null || this.eWQ == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return pX(4);
        }
        return pX(6);
    }

    public boolean ju(boolean z) {
        if (this.eWO == null || this.eXh == null) {
            return false;
        }
        if (z || this.eXh.qA().qw() != 0) {
            return pX(1);
        }
        return false;
    }

    public boolean jv(boolean z) {
        if (this.eWO == null || this.eXh == null) {
            return false;
        }
        if ((z || this.eXh.qA().qx() != 0) && this.eXh.aRj() != null && this.eXh.aRj().size() >= 1) {
            return pX(2);
        }
        return false;
    }

    public boolean pO(String str) {
        this.eWS = !this.eWS;
        this.eWQ = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (pX(6)) {
            return true;
        }
        this.eWS = this.eWS ? false : true;
        return false;
    }

    public boolean k(boolean z, String str) {
        if (this.eWS == z) {
            return false;
        }
        this.eWS = z;
        this.eWQ = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (pX(6)) {
            return true;
        }
        this.eWS = z ? false : true;
        return false;
    }

    public boolean aUr() {
        this.eWT = this.eWU;
        this.eWU = !this.eWU;
        if (this.isLoading || !LoadData()) {
            this.eWU = this.eWU ? false : true;
            return false;
        }
        return true;
    }

    public boolean aUs() {
        return this.eWU;
    }

    public boolean hasData() {
        return (this.eXh == null || this.eXh.aRf() == null || this.eXh.aRh() == null) ? false : true;
    }

    public boolean nJ() {
        if (this.eXh == null) {
            return false;
        }
        return this.eXh.nJ();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fT(String str) {
        if (this.eXh == null || this.eXh.aRh() == null || this.eXh.aRf() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eXh.aRh().sK()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eXh.aRf().getId());
            writeData.setForumName(this.eXh.aRf().getName());
        }
        writeData.sourceFrom = String.valueOf(this.eXO);
        writeData.setThreadId(this.eWO);
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

    public MarkData qa(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.eXh == null) {
            return null;
        }
        ArrayList<PostData> aRj = this.eXh.aRj();
        if (com.baidu.tbadk.core.util.v.w(aRj)) {
            return null;
        }
        if (aRj.size() > 0 && i >= aRj.size()) {
            i = aRj.size() - 1;
        }
        return h(aRj.get(i));
    }

    public MarkData aUt() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eWO);
        markData.setPostId(this.eXh.nI());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eWS);
        markData.setSequence(Boolean.valueOf(this.eWU));
        markData.setId(this.eWO);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eWO);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eWS);
        markData.setSequence(Boolean.valueOf(this.eWU));
        markData.setId(this.eWO);
        markData.setFloor(postData.bwo());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aUu() {
        i.aTP().N(aUv(), this.isFromMark);
    }

    private String aUv() {
        String str = this.eWO;
        if (this.eWS) {
            str = str + DB_KEY_HOST;
        }
        if (!this.eWU) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jw(boolean z) {
        if (this.eXh != null) {
            this.eXh.ab(z);
        }
    }

    public void jx(boolean z) {
        this.eXs = z;
    }

    public boolean aUw() {
        return this.eXs;
    }

    public void a(a aVar) {
        this.eXn = aVar;
    }

    public void pm(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dx() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dw() {
        return Fy();
    }

    public boolean pP(String str) {
        if (getPbData() == null || getPbData().aRh() == null || getPbData().aRh().rx() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aRh().rx().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aUx() {
        return this.mRequestType;
    }

    public void aUy() {
        String aUv = aUv();
        i.aTP().N(aUv, false);
        i.aTP().N(aUv, true);
    }

    public void aUz() {
        if ("personalize_page".equals(this.mStType)) {
            this.eXy = System.currentTimeMillis() / 1000;
        }
    }

    public void aUA() {
        if ("personalize_page".equals(this.mStType) && this.eXh != null && this.eXy != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ac(ImageViewerConfig.FORUM_ID, this.eXh.getForumId()).ac("tid", this.eWO).ac("obj_duration", String.valueOf(currentTimeMillis - this.eXy)).ac("obj_param3", String.valueOf(currentTimeMillis)));
            this.eXy = 0L;
        }
    }

    public boolean aUB() {
        return this.eXB;
    }

    public int getErrorNo() {
        return this.eXD;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public j aUC() {
        return this.eXF;
    }

    public o aUD() {
        return this.eXG;
    }

    public PbFloorAgreeModel aUE() {
        return this.eXH;
    }

    public z aUF() {
        return this.eXI;
    }

    public CheckRealNameModel aUG() {
        return this.bHh;
    }

    public AddExperiencedModel aUH() {
        return this.eXK;
    }

    public String aUI() {
        return this.eXx;
    }

    public void pQ(String str) {
        this.eXx = str;
    }

    public boolean aUJ() {
        return this.eXC;
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.eXh != null && this.eXh.aRj() != null && this.eXh.aRj().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eXh.aRj().size();
                for (int i = 0; i < size; i++) {
                    if (this.eXh.aRj().get(i) != null && this.eXh.aRj().get(i).rx() != null && currentAccount.equals(this.eXh.aRj().get(i).rx().getUserId()) && this.eXh.aRj().get(i).rx().getPendantData() != null) {
                        this.eXh.aRj().get(i).rx().getPendantData().cF(kVar.pT());
                        this.eXh.aRj().get(i).rx().getPendantData().T(kVar.CE());
                    }
                }
            }
        }
    }

    public String aUK() {
        return this.eXJ;
    }

    public int aUL() {
        return this.eXO;
    }

    public void qb(int i) {
        this.eXO = i;
    }

    public void pR(String str) {
        if ((!this.eWS || pP(TbadkCoreApplication.getCurrentAccount())) && this.eXh.aRj() != null) {
            this.eXh.qA().bK(1);
            if (this.eXh.qA().qw() == 0) {
                this.eXh.qA().bK(1);
            }
            this.eXP = str;
            pX(8);
        }
    }

    private void qc(int i) {
        if (i != 8) {
            this.eXP = "";
            if (this.eXQ != null) {
                if (i == 1 && !this.eWU && !com.baidu.tbadk.core.util.v.w(getPbData().aRj())) {
                    getPbData().aRj().remove(this.eXQ);
                    if (this.eXR != null) {
                        getPbData().aRj().remove(this.eXR);
                    }
                    getPbData().aRj().add(0, this.eXQ);
                } else {
                    getPbData().aRj().remove(this.eXQ);
                    if (this.eXR != null) {
                        getPbData().aRj().remove(this.eXR);
                    }
                }
            }
            this.eXR = null;
        }
    }

    public void aUM() {
        if (this.eXh != null && !com.baidu.tbadk.core.util.v.w(this.eXh.aRj())) {
            if (this.eXR != null) {
                this.eXh.aRj().remove(this.eXR);
                this.eXR = null;
            }
            if (this.eXQ != null) {
                this.eXh.aRj().remove(this.eXQ);
                this.eXQ = null;
            }
        }
    }

    public void bt(int i, int i2) {
        this.eXS = i;
        this.eXT = i2;
    }

    public PostData aUN() {
        return this.eXQ;
    }

    public PostData aUO() {
        return this.eXR;
    }

    public int aUP() {
        return this.eXS;
    }

    public String aUQ() {
        return this.eXU;
    }

    public void pS(String str) {
        this.eXU = str;
    }
}
