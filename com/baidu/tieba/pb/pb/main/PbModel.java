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
    private final CheckRealNameModel bZn;
    private BaseActivity bkU;
    private int cEs;
    private com.baidu.tieba.tbadkCore.d.b cSM;
    private long dxh;
    private boolean eBi;
    private boolean eQY;
    private boolean fwA;
    private boolean fwB;
    private int fwC;
    private long fwD;
    private int fwE;
    private int fwF;
    private int fwG;
    private boolean fwH;
    private boolean fwI;
    private long fwJ;
    private boolean fwK;
    private String fwL;
    protected com.baidu.tieba.pb.data.d fwM;
    private int fwN;
    private boolean fwO;
    private boolean fwP;
    private boolean fwQ;
    private boolean fwR;
    private a fwS;
    private String fwT;
    private String fwU;
    private int fwV;
    private int fwW;
    private boolean fwX;
    private boolean fwY;
    private boolean fwZ;
    protected String fwu;
    private String fwv;
    private String fww;
    private boolean fwx;
    private boolean fwy;
    private boolean fwz;
    private CustomMessageListener fxA;
    private CustomMessageListener fxB;
    private com.baidu.adp.framework.listener.a fxC;
    private PraiseData fxD;
    private boolean fxa;
    private boolean fxb;
    private String fxc;
    private long fxd;
    private boolean fxe;
    private int fxf;
    private boolean fxg;
    private boolean fxh;
    private int fxi;
    private final w fxj;
    private final h fxk;
    private final m fxl;
    private final q fxm;
    private final y fxn;
    private String fxo;
    private final AddExperiencedModel fxp;
    private SuggestEmotionModel fxq;
    private GetSugMatchWordsModel fxr;
    private boolean fxs;
    private int fxt;
    private String fxu;
    private PostData fxv;
    private PostData fxw;
    private int fxx;
    private int fxy;
    private String fxz;
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
    private static final int fwt = com.baidu.tbadk.data.d.GD() / 30;
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
        this.fwu = null;
        this.fwv = null;
        this.fww = null;
        this.mForumId = null;
        this.fwx = false;
        this.fwy = false;
        this.fwz = true;
        this.fwA = true;
        this.fwB = false;
        this.mIsGood = 0;
        this.fwC = 0;
        this.fwD = 0L;
        this.fwE = 1;
        this.fwF = 1;
        this.fwG = 1;
        this.cEs = 1;
        this.isAd = false;
        this.eBi = false;
        this.fwH = false;
        this.eQY = false;
        this.isFromMark = false;
        this.fwI = false;
        this.fwJ = 0L;
        this.fwK = false;
        this.fwL = null;
        this.fwM = null;
        this.isLoading = false;
        this.fwO = false;
        this.fwP = false;
        this.fwQ = false;
        this.fwR = false;
        this.mLocate = null;
        this.mContext = null;
        this.fwS = null;
        this.opType = null;
        this.opUrl = null;
        this.fwT = null;
        this.fwU = null;
        this.fwV = -1;
        this.fwW = -1;
        this.cSM = null;
        this.fwY = false;
        this.fwZ = false;
        this.postID = null;
        this.fxc = null;
        this.fxd = 0L;
        this.fxe = false;
        this.fxf = -1;
        this.fxh = false;
        this.fxs = false;
        this.fxt = 0;
        this.fxA = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.fxb = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.bao() != null) {
                        pbData.bao().bP(0);
                    }
                    if (PbModel.this.fwS != null && pbData != null) {
                        com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fwS.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fxB = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().bam() != null && PbModel.this.getPbData().bam().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().bam().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fxC = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.jD()) {
                        PbModel.this.bkU.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.fwY || !PbModel.this.fwZ) {
                        if (!PbModel.this.fwY) {
                            PbModel.this.fwY = true;
                        } else {
                            PbModel.this.fwZ = true;
                        }
                        if (PbModel.this.fwS != null) {
                            PbModel.this.fwS.a(PbModel.this.bde(), z, responsedMessage, PbModel.this.fxa, System.currentTimeMillis() - PbModel.this.dxh);
                        }
                    }
                }
            }
        };
        this.fxD = null;
        registerListener(this.fxA);
        registerListener(this.fxC);
        registerListener(this.fxB);
        this.fwM = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bkU = baseActivity;
        this.fxj = new w(this, this.bkU);
        this.fxk = new h(this, this.bkU);
        this.fxl = new m(this, this.bkU);
        this.fxm = new q(this, getUniqueId());
        this.fxn = new y(this, this.bkU);
        this.bZn = new CheckRealNameModel(this.bkU.getPageContext());
        this.fxq = new SuggestEmotionModel();
        this.fxp = new AddExperiencedModel(this.bkU.getPageContext());
    }

    protected int bde() {
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
        this.fwu = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fwu)) {
            this.fwu = this.fxj.U(intent);
            if (StringUtils.isNull(this.fwu) && intent.getData() != null) {
                this.fwu = intent.getData().getQueryParameter("thread_id");
            }
        }
        this.fxt = intent.getIntExtra("key_start_from", 0);
        if (this.fxt == 0) {
            this.fxt = this.fxj.fxJ;
        }
        this.fww = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.fwv = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fwx = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fwy = intent.getBooleanExtra("host_only", false);
        this.fwA = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fwC = intent.getIntExtra("is_top", 0);
        this.fwD = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fwI = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eBi = intent.getBooleanExtra("is_sub_pb", false);
        this.fwK = intent.getBooleanExtra("is_pv", false);
        this.fwJ = intent.getLongExtra("msg_id", 0L);
        this.fwL = intent.getStringExtra("from_forum_name");
        this.fwU = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fwT = intent.getStringExtra("op_stat");
        this.fwO = intent.getBooleanExtra("is_from_thread_config", false);
        this.fwP = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fwQ = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fwW = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fwV = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fwH = intent.getBooleanExtra("from_frs", false);
        this.eQY = intent.getBooleanExtra("from_maintab", false);
        this.fxh = intent.getBooleanExtra("from_smart_frs", false);
        this.fwR = intent.getBooleanExtra("from_hottopic", false);
        this.fxo = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fxt = bundle.getInt("key_start_from", 0);
        this.fwu = bundle.getString("thread_id");
        this.fww = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.fwv = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fwx = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fwy = bundle.getBoolean("host_only", false);
        this.fwA = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fwC = bundle.getInt("is_top", 0);
        this.fwD = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fwI = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eBi = bundle.getBoolean("is_sub_pb", false);
        this.fwK = bundle.getBoolean("is_pv", false);
        this.fwJ = bundle.getLong("msg_id", 0L);
        this.fwL = bundle.getString("from_forum_name");
        this.fwU = bundle.getString("extra_pb_cache_key");
        this.fwO = bundle.getBoolean("is_from_thread_config", false);
        this.fwP = bundle.getBoolean("is_from_interview_live_config", false);
        this.fwQ = bundle.getBoolean("is_from_my_god_config", false);
        this.fwW = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fwV = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fwH = bundle.getBoolean("from_frs", false);
        this.eQY = bundle.getBoolean("from_maintab", false);
        this.fxh = bundle.getBoolean("from_smart_frs", false);
        this.fwR = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void z(Bundle bundle) {
        bundle.putString("thread_id", this.fwu);
        bundle.putString("post_id", this.fww);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt("key_start_from", this.fxt);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fwx);
        bundle.putBoolean("host_only", this.fwy);
        bundle.putBoolean("squence", this.fwA);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fwC);
        bundle.putLong("thread_time", this.fwD);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fwI);
        bundle.putBoolean("is_sub_pb", this.eBi);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fwK);
        bundle.putLong("msg_id", this.fwJ);
        bundle.putString("extra_pb_cache_key", this.fwU);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fwO);
        bundle.putBoolean("is_from_interview_live_config", this.fwP);
        bundle.putBoolean("is_from_my_god_config", this.fwQ);
        bundle.putInt("extra_pb_is_attention_key", this.fwW);
        bundle.putInt("extra_pb_funs_count_key", this.fwV);
        bundle.putBoolean("from_frs", this.fwH);
        bundle.putBoolean("from_maintab", this.eQY);
        bundle.putBoolean("from_smart_frs", this.fxh);
        bundle.putBoolean("from_hottopic", this.fwR);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bdf() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fwu);
        if (!this.fwI) {
            sb.append(this.fww);
        }
        sb.append(this.fwy);
        sb.append(this.fwA);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fwC);
        sb.append(this.fwD);
        sb.append(this.fwH);
        sb.append(this.eQY);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eBi);
        sb.append(this.fwK);
        sb.append(this.fwJ);
        sb.append(this.fwL);
        sb.append(this.mThreadType);
        sb.append(this.fwO);
        sb.append(this.fwP);
        sb.append(this.fwQ);
        if (this.fwU != null) {
            sb.append(this.fwU);
        }
        return sb.toString();
    }

    public String bdg() {
        return this.fwL;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.fww;
    }

    public String bdh() {
        return this.fwu;
    }

    public boolean getHostMode() {
        return this.fwy;
    }

    public boolean bdi() {
        return this.fwA;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bdj() {
        return this.fwH;
    }

    public boolean bdk() {
        return this.fwB;
    }

    public boolean bdl() {
        return this.eQY;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bdm() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bdn() {
        return this.fwC;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void iZ(int i) {
        this.fwC = i;
    }

    public boolean bdo() {
        return this.eBi;
    }

    public boolean bdp() {
        if (this.fwM == null) {
            return false;
        }
        return this.fwM.isValid();
    }

    public String vv() {
        if (this.fwM == null || !this.fwM.sc()) {
            return null;
        }
        return this.fwM.sb();
    }

    public boolean qy(int i) {
        this.fwE = i;
        if (this.fwE > this.fwM.uB().us()) {
            this.fwE = this.fwM.uB().us();
        }
        if (this.fwE < 1) {
            this.fwE = 1;
        }
        if (this.fwu == null) {
            return false;
        }
        return qA(5);
    }

    public void qz(int i) {
        this.fwE = i;
        this.fwF = i;
        this.fwG = i;
    }

    public void c(com.baidu.tbadk.core.data.am amVar) {
        if (amVar == null) {
            qz(1);
            return;
        }
        this.fwF = amVar.uv();
        this.fwG = amVar.uv();
        this.cEs = amVar.us();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.fwM;
    }

    public com.baidu.tbadk.core.data.am aEh() {
        if (this.fwM == null) {
            return null;
        }
        return this.fwM.uB();
    }

    public boolean bdq() {
        if (this.fwA && this.fwM.uB().ux() == 0) {
            jT(true);
            return true;
        }
        return false;
    }

    public void ri(String str) {
        if (!StringUtils.isNull(str)) {
            this.fwu = str;
            this.fww = null;
            this.fwy = false;
            this.fwA = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fwu == null) {
            return false;
        }
        cancelLoadData();
        if (this.cSM == null) {
            this.cSM = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.cSM.start();
        }
        boolean qA = qA(3);
        if (this.opType != null) {
            this.opType = null;
            this.fwT = null;
            this.opUrl = null;
            return qA;
        }
        return qA;
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
        if (this.fxq != null) {
            this.fxq.cancelLoadData();
        }
        if (this.fxm != null) {
            this.fxm.cancelLoadData();
        }
        if (this.fxr != null) {
            this.fxr.cancelLoadData();
        }
        apn();
    }

    private void apn() {
        if (this.cSM != null) {
            this.cSM.destory();
            this.cSM = null;
        }
    }

    public boolean JE() {
        return (this.fww == null || this.fww.equals("0") || this.fww.length() == 0) ? LoadData() : bdt();
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
                this.fxq.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fxq.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fxr == null) {
                this.fxr = new GetSugMatchWordsModel(this.bkU.getPageContext());
            }
            this.fxr.b(aVar);
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
    public boolean qA(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        qB(i);
        final com.baidu.tieba.pb.data.d pbData = ai.bep().getPbData();
        if (pbData != null && pbData.bao() != null) {
            pbData.bao().bP(0);
            this.fwA = ai.bep().bdi();
            this.fwy = ai.bep().beu();
            this.fwB = ai.bep().bev();
            this.fxv = ai.bep().bet();
            this.fxw = ai.bep().bes();
            this.fxx = ai.bep().ber();
            this.fxs = this.fwy;
            if (this.fwy || this.isFromMark) {
                this.fwX = false;
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
        if (i == 4 && !this.fxb) {
            a(bdy(), true, this.fww, 3);
        }
        if (i == 3 && !this.fxb) {
            if (this.isFromMark) {
                a(bdy(), true, this.fww, 3);
            } else {
                a(bdy(), false, this.fww, 3);
            }
        }
        this.fxb = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aKo);
        if (this.fwy || this.isFromMark) {
            this.fwX = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fwu == null || this.fwu.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.fwu, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
        int aj = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.aq.zq().zs() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aj));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.fwA) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.fwy) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fwK) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fwJ));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fwX) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.fwT, 0));
            pbPageRequestMessage.setOpMessageID(this.fwJ);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> baq = this.fwM.baq();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.fwA) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fwG - 1));
                        if (this.fwG - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z) {
                                if (baq != null && baq.size() > 0) {
                                    size = baq.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = baq.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.fww = postData.getId();
                                            if (StringUtils.isNull(this.fww)) {
                                                i3 = i2 + 1;
                                            }
                                        }
                                        i2 = i3;
                                    }
                                }
                                if (this.fww == null && this.fww.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fww, 0L));
                                } else if (!this.fwA) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            b(pbPageRequestMessage);
                            break;
                        }
                    } else {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fwF + 1));
                        if (this.fwF >= this.cEs) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (baq != null) {
                                size = baq.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                            }
                            if (this.fww == null) {
                            }
                            if (!this.fwA) {
                            }
                            b(pbPageRequestMessage);
                        }
                    }
                }
                z = false;
                if (!this.isFromMark) {
                }
                if (baq != null) {
                }
                if (this.fww == null) {
                }
                if (!this.fwA) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (baq != null && baq.size() > 0 && baq.get(0) != null) {
                    this.fww = baq.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.fwA) {
                        if (this.fwG - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fwG - 1));
                        }
                    } else if (this.fwF < this.cEs) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fwF + 1));
                    }
                }
                if (this.fww != null && this.fww.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fww, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fwy) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.fwA) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fww, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fwE));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.fwA && this.fxs && !this.fwy) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fww, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.fwy) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fxf);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fxu, 0L));
                if (!this.fwA) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fxs = this.fwy;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bdy());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fxt));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fxe);
        pbPageRequestMessage.setFromSmartFrs(this.fxh ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fwx);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bcu() {
        switch (bdN()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bao() == null || !getPbData().bao().wu();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bdg()) && com.baidu.tieba.recapp.r.boj().bod() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.boj().bod().Q(bdg(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.boj().bod().R(bdg(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bdg()) && com.baidu.tieba.recapp.r.boj().bod() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.boj().bod().R(bdg(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.boj().bod().Q(bdg(), true));
        }
    }

    protected void qB(int i) {
        boolean z = false;
        qF(i);
        ArrayList<PostData> baq = this.fwM.baq();
        this.fxa = false;
        if (i == 1) {
            boolean z2 = false;
            while (baq.size() + 30 > com.baidu.tbadk.data.d.GD()) {
                baq.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fwM.uB().bL(1);
                if (this.fwS != null) {
                    this.fwS.f(this.fwM);
                }
            }
            this.dxh = System.currentTimeMillis();
            this.fxa = true;
        } else if (i == 2) {
            while (baq.size() + 30 > com.baidu.tbadk.data.d.GD()) {
                baq.remove(baq.size() - 1);
                z = true;
            }
            if (z) {
                this.fwM.uB().bK(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.fxi = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fwv)) {
            try {
                Long valueOf = Long.valueOf(this.fwv);
                com.baidu.tieba.pb.data.l baz = dVar.baz();
                if (baz != null && baz.fpz != null) {
                    if (baz.fpz.isEmpty() || !baz.fpz.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fwu);
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
            if (this.fwQ || this.fwO || this.fwP) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.baq().size(); i++) {
                PostData postData = dVar.baq().get(i);
                for (int i2 = 0; i2 < postData.bwW().size(); i2++) {
                    postData.bwW().get(i2).b(this.bkU.getPageContext(), l.equals(postData.bwW().get(i2).vm().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.l baz = dVar.baz();
            if (baz != null && !com.baidu.tbadk.core.util.w.z(baz.fpy)) {
                for (PostData postData2 : baz.fpy) {
                    for (int i3 = 0; i3 < postData2.bwW().size(); i3++) {
                        postData2.bwW().get(i3).b(this.bkU.getPageContext(), l.equals(postData2.bwW().get(i3).vm().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.l baz = dVar.baz();
            if (baz != null && !com.baidu.tbadk.core.util.w.z(baz.fpy)) {
                for (PostData postData : baz.fpy.subList(i, baz.fpy.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bwW().size()) {
                            postData.bwW().get(i3).b(this.bkU.getPageContext(), l.equals(postData.bwW().get(i3).vm().getUserId()));
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
        bd bao = dVar.bao();
        bao.bT(this.mIsGood);
        bao.bS(this.fwC);
        if (this.fwD > 0) {
            bao.q(this.fwD);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bao() != null && dVar.bao().vm() != null) {
            str = dVar.bao().vm().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bdr() {
        if (this.fwM == null || this.fwM.bao() == null || this.fwM.bao().vm() == null) {
            return null;
        }
        return this.fwM.bao().vm();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fxg = z3;
        this.fwN = i;
        if (this.cSM != null && !z3) {
            this.cSM.a(z2, z4, i2, str, i3, j, j2);
            this.cSM = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bdg()) && com.baidu.tieba.recapp.r.boj().bod() != null) {
            com.baidu.tieba.recapp.r.boj().bod().f(bdg(), qC(getRequestType()), true);
        }
        if (dVar == null || (this.fwE == 1 && i == 5 && dVar.baq() != null && dVar.baq().size() < 1)) {
            if (this.fwS != null) {
                this.fwA = this.fwz;
                this.fwS.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fwz = this.fwA;
            this.fwK = false;
            if (dVar.uB() != null) {
                c(dVar.uB());
            }
            this.cEs = this.cEs < 1 ? 1 : this.cEs;
            ArrayList<PostData> baq = this.fwM.baq();
            switch (i) {
                case 1:
                    this.fwM.a(dVar.uB(), 1);
                    e(dVar, baq);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.baq() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.baq().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.w.c(baq, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.w.c(dVar.baq(), com.baidu.tbadk.core.util.w.y(dVar.baq()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.baq().remove(postData2);
                            i6 = size - 1;
                        }
                        baq.addAll(0, dVar.baq());
                    }
                    this.fwM.a(dVar.uB(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.fwA && dVar.uB() != null) {
                        dVar.uB().bI(dVar.uB().us());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && this.fwA) {
                        bds();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.w.z(dVar.baq()) && this.fwM != null && (!this.fwy || l(dVar).equals(dVar.baq().get(0).vm().getUserId()))) {
                        if (this.fwM.uB().ux() == 0) {
                            this.fwM.uB().bK(1);
                        }
                        bdO();
                        this.fxv = dVar.baq().get(0);
                        if (this.fwA) {
                            if (this.fwM.baq().size() - this.fxx >= 3) {
                                this.fxw = new PostData();
                                this.fxw.gJt = true;
                                this.fxw.setPostType(53);
                                this.fwM.baq().add(this.fxw);
                            }
                            this.fwM.baq().add(this.fxv);
                            i4 = this.fwM.baq().size() - 1;
                        } else {
                            if (this.fxx - this.fxy >= 3) {
                                this.fxw = new PostData();
                                this.fxw.gJt = false;
                                this.fxw.setPostType(53);
                                this.fwM.baq().add(0, this.fxw);
                            }
                            this.fwM.baq().add(0, this.fxv);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ao.R(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fxv.gJG = this.fwM.baN();
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
            if (this.fwM != null && this.fwM.bao() != null) {
                PraiseData va = this.fwM.bao().va();
                if (this.fxD != null && !va.isPriaseDataValid()) {
                    this.fwM.bao().a(this.fxD);
                } else {
                    this.fxD = this.fwM.bao().va();
                    this.fxD.setPostId(this.fwM.bao().vC());
                }
                if (dVar.uB() != null && dVar.uB().uv() == 1 && dVar.bao() != null && dVar.bao().vx() != null && dVar.bao().vx().size() > 0) {
                    this.fwM.bao().h(dVar.bao().vx());
                }
                this.fwM.bao().bQ(dVar.bao().ve());
                this.fwM.bao().bN(dVar.bao().getAnchorLevel());
                this.fwM.bao().bP(dVar.bao().uX());
                if (this.mThreadType == 33) {
                    this.fwM.bao().vm().setHadConcerned(dVar.bao().vm().hadConcerned());
                }
                if (dVar != null && dVar.bao() != null) {
                    this.fwM.bao().bV(dVar.bao().vB());
                }
            }
            if (this.fwM != null && this.fwM.getUserData() != null && dVar.getUserData() != null) {
                this.fwM.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.fwM.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.uB() != null && dVar.uB().uv() == 1 && dVar.bay() != null) {
                this.fwM.c(dVar.bay());
            }
            if (this.fxg) {
                if (this.fwM.bao() != null && this.fwM.bao().vm() != null && this.fwM.baq() != null && com.baidu.tbadk.core.util.w.c(this.fwM.baq(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.w.c(this.fwM.baq(), 0);
                    MetaData vm = this.fwM.bao().vm();
                    if (postData3.vm() != null && postData3.vm().getGodUserData() != null) {
                        if (this.fwV != -1) {
                            vm.setFansNum(this.fwV);
                            postData3.vm().setFansNum(this.fwV);
                        }
                        if (this.fwW != -1) {
                            vm.getGodUserData().setIsLike(this.fwW == 1);
                            postData3.vm().getGodUserData().setIsLike(this.fwW == 1);
                            vm.getGodUserData().setIsFromNetWork(false);
                            postData3.vm().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fwM.foT = -1;
                this.fwM.foS = -1;
            }
            if (this.fwS != null) {
                this.fwS.a(true, getErrorCode(), i, i5, this.fwM, this.mErrorString, 1);
            }
        }
        if (this.fwM != null && this.fwM.bao() != null && this.fwM.bam() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bkU;
            historyMessage.threadId = getPbData().bao().getId();
            if (this.mIsShareThread && getPbData().bao().ajP != null) {
                historyMessage.threadName = getPbData().bao().ajP.showText;
            } else {
                historyMessage.threadName = getPbData().bao().getTitle();
            }
            if (this.mIsShareThread && !bcu()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().bam().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bdi();
            historyMessage.threadType = getPbData().bao().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String an;
        if (arrayList != null && dVar.baq() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.w.c(dVar.baq(), 0);
            if (postData != null && (an = an(arrayList)) != null && an.equals(postData.getId())) {
                dVar.baq().remove(postData);
            }
            arrayList.addAll(dVar.baq());
        }
    }

    private int qC(int i) {
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

    private String an(ArrayList<PostData> arrayList) {
        int y = com.baidu.tbadk.core.util.w.y(arrayList);
        if (y <= 0) {
            return null;
        }
        for (int i = y - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.w.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.tieba.pb.data.d dVar) {
        dVar.rh(this.fwM.baF());
        this.fwM = dVar;
        qz(dVar.uB().uv());
    }

    private void bds() {
        if (this.fwM != null && this.fwM.baq() != null && this.fwM.baE() != null) {
            ArrayList<PostData> baq = this.fwM.baq();
            com.baidu.tieba.pb.data.a baE = this.fwM.baE();
            int bak = baE.bak();
            if (bak > 0) {
                if (bak <= baq.size()) {
                    baq.add(bak, baE);
                } else {
                    baq.add(baE);
                }
            }
        }
    }

    public boolean bdt() {
        if (this.fwu == null || this.fww == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return qA(4);
        }
        return qA(6);
    }

    public boolean jT(boolean z) {
        if (this.fwu == null || this.fwM == null) {
            return false;
        }
        if (z || this.fwM.uB().ux() != 0) {
            return qA(1);
        }
        return false;
    }

    public boolean jU(boolean z) {
        if (this.fwu == null || this.fwM == null) {
            return false;
        }
        if ((z || this.fwM.uB().uy() != 0) && this.fwM.baq() != null && this.fwM.baq().size() >= 1) {
            return qA(2);
        }
        return false;
    }

    public boolean rn(String str) {
        this.fwy = !this.fwy;
        this.fww = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (qA(6)) {
            return true;
        }
        this.fwy = this.fwy ? false : true;
        return false;
    }

    public boolean m(boolean z, String str) {
        if (this.fwy == z) {
            return false;
        }
        this.fwy = z;
        this.fww = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (qA(6)) {
            return true;
        }
        this.fwy = z ? false : true;
        return false;
    }

    public boolean bdu() {
        this.fwz = this.fwA;
        this.fwA = !this.fwA;
        if (this.isLoading || !LoadData()) {
            this.fwA = this.fwA ? false : true;
            return false;
        }
        return true;
    }

    public boolean bdv() {
        return this.fwA;
    }

    public boolean hasData() {
        return (this.fwM == null || this.fwM.bam() == null || this.fwM.bao() == null) ? false : true;
    }

    public boolean sc() {
        if (this.fwM == null) {
            return false;
        }
        return this.fwM.sc();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gH(String str) {
        if (this.fwM == null || this.fwM.bao() == null || this.fwM.bam() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fwM.bao().wu()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fwM.bam().getId());
            writeData.setForumName(this.fwM.bam().getName());
        }
        writeData.sourceFrom = String.valueOf(this.fxt);
        writeData.setThreadId(this.fwu);
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

    public MarkData qD(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fwM == null) {
            return null;
        }
        ArrayList<PostData> baq = this.fwM.baq();
        if (com.baidu.tbadk.core.util.w.z(baq)) {
            return null;
        }
        if (baq.size() > 0 && i >= baq.size()) {
            i = baq.size() - 1;
        }
        return g(baq.get(i));
    }

    public MarkData bdw() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fwu);
        markData.setPostId(this.fwM.sb());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fwy);
        markData.setSequence(Boolean.valueOf(this.fwA));
        markData.setId(this.fwu);
        return markData;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fwu);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fwy);
        markData.setSequence(Boolean.valueOf(this.fwA));
        markData.setId(this.fwu);
        markData.setFloor(postData.bwZ());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bdx() {
        g.bcQ().J(bdy(), this.isFromMark);
    }

    private String bdy() {
        String str = this.fwu;
        if (this.fwy) {
            str = str + DB_KEY_HOST;
        }
        if (!this.fwA) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jV(boolean z) {
        if (this.fwM != null) {
            this.fwM.ah(z);
        }
    }

    public void jW(boolean z) {
        this.fwX = z;
    }

    public boolean bdz() {
        return this.fwX;
    }

    public void a(a aVar) {
        this.fwS = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String HB() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean HA() {
        return JE();
    }

    public boolean ro(String str) {
        if (getPbData() == null || getPbData().bao() == null || getPbData().bao().vm() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bao().vm().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bdA() {
        String bdy = bdy();
        g.bcQ().J(bdy, false);
        g.bcQ().J(bdy, true);
    }

    public void bdB() {
        if ("personalize_page".equals(this.mStType)) {
            this.fxd = System.currentTimeMillis() / 1000;
        }
    }

    public void bdC() {
        if ("personalize_page".equals(this.mStType) && this.fwM != null && this.fxd != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10754").ah(ImageViewerConfig.FORUM_ID, this.fwM.getForumId()).ah("tid", this.fwu).ah("obj_duration", String.valueOf(currentTimeMillis - this.fxd)).ah("obj_param3", String.valueOf(currentTimeMillis)));
            this.fxd = 0L;
        }
    }

    public boolean bdD() {
        return this.fxg;
    }

    public int getErrorNo() {
        return this.fxi;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bdE() {
        return this.fxk;
    }

    public m bdF() {
        return this.fxl;
    }

    public q bdG() {
        return this.fxm;
    }

    public y bdH() {
        return this.fxn;
    }

    public CheckRealNameModel bdI() {
        return this.bZn;
    }

    public AddExperiencedModel bdJ() {
        return this.fxp;
    }

    public String bdK() {
        return this.fxc;
    }

    public void rp(String str) {
        this.fxc = str;
    }

    public boolean bdL() {
        return this.fxh;
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.fwM != null && this.fwM.baq() != null && this.fwM.baq().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fwM.baq().size();
                for (int i = 0; i < size; i++) {
                    if (this.fwM.baq().get(i) != null && this.fwM.baq().get(i).vm() != null && currentAccount.equals(this.fwM.baq().get(i).vm().getUserId()) && this.fwM.baq().get(i).vm().getPendantData() != null) {
                        this.fwM.baq().get(i).vm().getPendantData().dj(iVar.ub());
                        this.fwM.baq().get(i).vm().getPendantData().W(iVar.GL());
                    }
                }
            }
        }
    }

    public String bdM() {
        return this.fxo;
    }

    public int bdN() {
        return this.fxt;
    }

    public void qE(int i) {
        this.fxt = i;
    }

    public void rq(String str) {
        if ((!this.fwy || ro(TbadkCoreApplication.getCurrentAccount())) && this.fwM.baq() != null) {
            this.fwM.uB().bK(1);
            if (this.fwM.uB().ux() == 0) {
                this.fwM.uB().bK(1);
            }
            this.fxu = str;
            qA(8);
        }
    }

    private void qF(int i) {
        if (i != 8) {
            this.fxu = "";
            if (this.fxv != null) {
                if (i == 1 && !this.fwA && !com.baidu.tbadk.core.util.w.z(getPbData().baq())) {
                    getPbData().baq().remove(this.fxv);
                    if (this.fxw != null) {
                        getPbData().baq().remove(this.fxw);
                    }
                    getPbData().baq().add(0, this.fxv);
                } else {
                    getPbData().baq().remove(this.fxv);
                    if (this.fxw != null) {
                        getPbData().baq().remove(this.fxw);
                    }
                }
            }
            this.fxw = null;
        }
    }

    public void bdO() {
        if (this.fwM != null && !com.baidu.tbadk.core.util.w.z(this.fwM.baq())) {
            if (this.fxw != null) {
                this.fwM.baq().remove(this.fxw);
                this.fxw = null;
            }
            if (this.fxv != null) {
                this.fwM.baq().remove(this.fxv);
                this.fxv = null;
            }
        }
    }

    public void bq(int i, int i2) {
        this.fxx = i;
        this.fxy = i2;
    }

    public PostData bdP() {
        return this.fxv;
    }

    public PostData bdQ() {
        return this.fxw;
    }

    public int bdR() {
        return this.fxx;
    }

    public String bdS() {
        return this.fxz;
    }

    public void rr(String str) {
        this.fxz = str;
    }
}
