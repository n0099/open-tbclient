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
    private final CheckRealNameModel bRm;
    private BaseActivity bcK;
    private com.baidu.tieba.tbadkCore.d.b cJG;
    private int cvP;
    private long dnQ;
    private boolean eFF;
    private boolean epR;
    protected String fkZ;
    private int flA;
    private int flB;
    private boolean flC;
    private boolean flD;
    private boolean flE;
    private boolean flF;
    private boolean flG;
    private String flH;
    private long flI;
    private boolean flJ;
    private int flK;
    private boolean flL;
    private boolean flM;
    private int flN;
    private final w flO;
    private final h flP;
    private final m flQ;
    private final q flR;
    private final y flS;
    private String flT;
    private final AddExperiencedModel flU;
    private SuggestEmotionModel flV;
    private GetSugMatchWordsModel flW;
    private boolean flX;
    private int flY;
    private String flZ;
    private String fla;
    private String flb;
    private boolean flc;
    private boolean fld;
    private boolean fle;
    private boolean flf;
    private boolean flg;
    private int flh;
    private long fli;
    private int flj;
    private int flk;
    private int fll;
    private boolean flm;
    private boolean fln;
    private long flo;
    private boolean flp;
    private String flq;
    protected com.baidu.tieba.pb.data.d flr;
    private int fls;
    private boolean flt;
    private boolean flu;
    private boolean flv;
    private boolean flw;
    private a flx;
    private String fly;
    private String flz;
    private PostData fma;
    private PostData fmb;
    private int fmc;
    private int fmd;
    private String fme;
    private CustomMessageListener fmf;
    private CustomMessageListener fmg;
    private com.baidu.adp.framework.listener.a fmh;
    private PraiseData fmi;
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
    private static final int fkY = com.baidu.tbadk.data.d.Da() / 30;
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
        this.fkZ = null;
        this.fla = null;
        this.flb = null;
        this.mForumId = null;
        this.flc = false;
        this.fld = false;
        this.fle = true;
        this.flf = true;
        this.flg = false;
        this.mIsGood = 0;
        this.flh = 0;
        this.fli = 0L;
        this.flj = 1;
        this.flk = 1;
        this.fll = 1;
        this.cvP = 1;
        this.isAd = false;
        this.epR = false;
        this.flm = false;
        this.eFF = false;
        this.isFromMark = false;
        this.fln = false;
        this.flo = 0L;
        this.flp = false;
        this.flq = null;
        this.flr = null;
        this.isLoading = false;
        this.flt = false;
        this.flu = false;
        this.flv = false;
        this.flw = false;
        this.mLocate = null;
        this.mContext = null;
        this.flx = null;
        this.opType = null;
        this.opUrl = null;
        this.fly = null;
        this.flz = null;
        this.flA = -1;
        this.flB = -1;
        this.cJG = null;
        this.flD = false;
        this.flE = false;
        this.postID = null;
        this.flH = null;
        this.flI = 0L;
        this.flJ = false;
        this.flK = -1;
        this.flM = false;
        this.flX = false;
        this.flY = 0;
        this.fmf = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.flG = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.aVs() != null) {
                        pbData.aVs().bN(0);
                    }
                    if (PbModel.this.flx != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.flx.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fmg = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aVq() != null && PbModel.this.getPbData().aVq().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aVq().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fmh = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.gP()) {
                        PbModel.this.bcK.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.flD || !PbModel.this.flE) {
                        if (!PbModel.this.flD) {
                            PbModel.this.flD = true;
                        } else {
                            PbModel.this.flE = true;
                        }
                        if (PbModel.this.flx != null) {
                            PbModel.this.flx.a(PbModel.this.aYg(), z, responsedMessage, PbModel.this.flF, System.currentTimeMillis() - PbModel.this.dnQ);
                        }
                    }
                }
            }
        };
        this.fmi = null;
        registerListener(this.fmf);
        registerListener(this.fmh);
        registerListener(this.fmg);
        this.flr = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bcK = baseActivity;
        this.flO = new w(this, this.bcK);
        this.flP = new h(this, this.bcK);
        this.flQ = new m(this, this.bcK);
        this.flR = new q(this, getUniqueId());
        this.flS = new y(this, this.bcK);
        this.bRm = new CheckRealNameModel(this.bcK.getPageContext());
        this.flV = new SuggestEmotionModel();
        this.flU = new AddExperiencedModel(this.bcK.getPageContext());
    }

    protected int aYg() {
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
        this.fkZ = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fkZ)) {
            this.fkZ = this.flO.U(intent);
            if (StringUtils.isNull(this.fkZ) && intent.getData() != null) {
                this.fkZ = intent.getData().getQueryParameter("thread_id");
            }
        }
        this.flY = intent.getIntExtra("key_start_from", 0);
        if (this.flY == 0) {
            this.flY = this.flO.fmo;
        }
        this.flb = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.fla = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.flc = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fld = intent.getBooleanExtra("host_only", false);
        this.flf = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.flh = intent.getIntExtra("is_top", 0);
        this.fli = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fln = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.epR = intent.getBooleanExtra("is_sub_pb", false);
        this.flp = intent.getBooleanExtra("is_pv", false);
        this.flo = intent.getLongExtra("msg_id", 0L);
        this.flq = intent.getStringExtra("from_forum_name");
        this.flz = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fly = intent.getStringExtra("op_stat");
        this.flt = intent.getBooleanExtra("is_from_thread_config", false);
        this.flu = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.flv = intent.getBooleanExtra("is_from_my_god_config", false);
        this.flB = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.flA = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.flm = intent.getBooleanExtra("from_frs", false);
        this.eFF = intent.getBooleanExtra("from_maintab", false);
        this.flM = intent.getBooleanExtra("from_smart_frs", false);
        this.flw = intent.getBooleanExtra("from_hottopic", false);
        this.flT = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.flY = bundle.getInt("key_start_from", 0);
        this.fkZ = bundle.getString("thread_id");
        this.flb = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.fla = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.flc = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fld = bundle.getBoolean("host_only", false);
        this.flf = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.flh = bundle.getInt("is_top", 0);
        this.fli = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fln = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.epR = bundle.getBoolean("is_sub_pb", false);
        this.flp = bundle.getBoolean("is_pv", false);
        this.flo = bundle.getLong("msg_id", 0L);
        this.flq = bundle.getString("from_forum_name");
        this.flz = bundle.getString("extra_pb_cache_key");
        this.flt = bundle.getBoolean("is_from_thread_config", false);
        this.flu = bundle.getBoolean("is_from_interview_live_config", false);
        this.flv = bundle.getBoolean("is_from_my_god_config", false);
        this.flB = bundle.getInt("extra_pb_is_attention_key", -1);
        this.flA = bundle.getInt("extra_pb_funs_count_key", -1);
        this.flm = bundle.getBoolean("from_frs", false);
        this.eFF = bundle.getBoolean("from_maintab", false);
        this.flM = bundle.getBoolean("from_smart_frs", false);
        this.flw = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void y(Bundle bundle) {
        bundle.putString("thread_id", this.fkZ);
        bundle.putString("post_id", this.flb);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt("key_start_from", this.flY);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.flc);
        bundle.putBoolean("host_only", this.fld);
        bundle.putBoolean("squence", this.flf);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.flh);
        bundle.putLong("thread_time", this.fli);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fln);
        bundle.putBoolean("is_sub_pb", this.epR);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.flp);
        bundle.putLong("msg_id", this.flo);
        bundle.putString("extra_pb_cache_key", this.flz);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.flt);
        bundle.putBoolean("is_from_interview_live_config", this.flu);
        bundle.putBoolean("is_from_my_god_config", this.flv);
        bundle.putInt("extra_pb_is_attention_key", this.flB);
        bundle.putInt("extra_pb_funs_count_key", this.flA);
        bundle.putBoolean("from_frs", this.flm);
        bundle.putBoolean("from_maintab", this.eFF);
        bundle.putBoolean("from_smart_frs", this.flM);
        bundle.putBoolean("from_hottopic", this.flw);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String aYh() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fkZ);
        if (!this.fln) {
            sb.append(this.flb);
        }
        sb.append(this.fld);
        sb.append(this.flf);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.flh);
        sb.append(this.fli);
        sb.append(this.flm);
        sb.append(this.eFF);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.epR);
        sb.append(this.flp);
        sb.append(this.flo);
        sb.append(this.flq);
        sb.append(this.mThreadType);
        sb.append(this.flt);
        sb.append(this.flu);
        sb.append(this.flv);
        if (this.flz != null) {
            sb.append(this.flz);
        }
        return sb.toString();
    }

    public String aYi() {
        return this.flq;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.flb;
    }

    public String aYj() {
        return this.fkZ;
    }

    public boolean getHostMode() {
        return this.fld;
    }

    public boolean aYk() {
        return this.flf;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean aYl() {
        return this.flm;
    }

    public boolean aYm() {
        return this.flg;
    }

    public boolean aYn() {
        return this.eFF;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aYo() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aYp() {
        return this.flh;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void iX(int i) {
        this.flh = i;
    }

    public boolean aYq() {
        return this.epR;
    }

    public boolean aYr() {
        if (this.flr == null) {
            return false;
        }
        return this.flr.isValid();
    }

    public String rY() {
        if (this.flr == null || !this.flr.oH()) {
            return null;
        }
        return this.flr.oG();
    }

    public boolean qm(int i) {
        this.flj = i;
        if (this.flj > this.flr.rf().qW()) {
            this.flj = this.flr.rf().qW();
        }
        if (this.flj < 1) {
            this.flj = 1;
        }
        if (this.fkZ == null) {
            return false;
        }
        return qo(5);
    }

    public void qn(int i) {
        this.flj = i;
        this.flk = i;
        this.fll = i;
    }

    public void c(com.baidu.tbadk.core.data.am amVar) {
        if (amVar == null) {
            qn(1);
            return;
        }
        this.flk = amVar.qZ();
        this.fll = amVar.qZ();
        this.cvP = amVar.qW();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.flr;
    }

    public com.baidu.tbadk.core.data.am azm() {
        if (this.flr == null) {
            return null;
        }
        return this.flr.rf();
    }

    public boolean aYs() {
        if (this.flf && this.flr.rf().rb() == 0) {
            jN(true);
            return true;
        }
        return false;
    }

    public void qu(String str) {
        if (!StringUtils.isNull(str)) {
            this.fkZ = str;
            this.flb = null;
            this.fld = false;
            this.flf = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fkZ == null) {
            return false;
        }
        cancelLoadData();
        if (this.cJG == null) {
            this.cJG = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.cJG.start();
        }
        boolean qo = qo(3);
        if (this.opType != null) {
            this.opType = null;
            this.fly = null;
            this.opUrl = null;
            return qo;
        }
        return qo;
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
        if (this.flV != null) {
            this.flV.cancelLoadData();
        }
        if (this.flR != null) {
            this.flR.cancelLoadData();
        }
        if (this.flW != null) {
            this.flW.cancelLoadData();
        }
        alh();
    }

    private void alh() {
        if (this.cJG != null) {
            this.cJG.destory();
            this.cJG = null;
        }
    }

    public boolean FW() {
        return (this.flb == null || this.flb.equals("0") || this.flb.length() == 0) ? LoadData() : aYv();
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
                this.flV.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.flV.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.flW == null) {
                this.flW = new GetSugMatchWordsModel(this.bcK.getPageContext());
            }
            this.flW.b(aVar);
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
    public boolean qo(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        qp(i);
        final com.baidu.tieba.pb.data.d pbData = ai.aZr().getPbData();
        if (pbData != null && pbData.aVs() != null) {
            pbData.aVs().bN(0);
            this.flf = ai.aZr().aYk();
            this.fld = ai.aZr().aZw();
            this.flg = ai.aZr().aZx();
            this.fma = ai.aZr().aZv();
            this.fmb = ai.aZr().aZu();
            this.fmc = ai.aZr().aZt();
            this.flX = this.fld;
            if (this.fld || this.isFromMark) {
                this.flC = false;
            }
            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.flG) {
            a(aYA(), true, this.flb, 3);
        }
        if (i == 3 && !this.flG) {
            if (this.isFromMark) {
                a(aYA(), true, this.flb, 3);
            } else {
                a(aYA(), false, this.flb, 3);
            }
        }
        this.flG = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aBS);
        if (this.fld || this.isFromMark) {
            this.flC = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fkZ == null || this.fkZ.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.fkZ, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.ap.vP().vR() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.flf) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.fld) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.flp) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.flo));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.flC) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.fly, 0));
            pbPageRequestMessage.setOpMessageID(this.flo);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aVu = this.flr.aVu();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.flf) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fll - 1));
                        if (this.fll - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z) {
                                if (aVu != null && aVu.size() > 0) {
                                    size = aVu.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = aVu.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.flb = postData.getId();
                                            if (StringUtils.isNull(this.flb)) {
                                                i3 = i2 + 1;
                                            }
                                        }
                                        i2 = i3;
                                    }
                                }
                                if (this.flb == null && this.flb.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.flb, 0L));
                                } else if (!this.flf) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            b(pbPageRequestMessage);
                            break;
                        }
                    } else {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.flk + 1));
                        if (this.flk >= this.cvP) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (aVu != null) {
                                size = aVu.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                            }
                            if (this.flb == null) {
                            }
                            if (!this.flf) {
                            }
                            b(pbPageRequestMessage);
                        }
                    }
                }
                z = false;
                if (!this.isFromMark) {
                }
                if (aVu != null) {
                }
                if (this.flb == null) {
                }
                if (!this.flf) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (aVu != null && aVu.size() > 0 && aVu.get(0) != null) {
                    this.flb = aVu.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.flf) {
                        if (this.fll - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fll - 1));
                        }
                    } else if (this.flk < this.cvP) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.flk + 1));
                    }
                }
                if (this.flb != null && this.flb.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.flb, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fld) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.flf) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.flb, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.flj));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.flf && this.flX && !this.fld) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.flb, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.fld) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.flK);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.flZ, 0L));
                if (!this.flf) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.flX = this.fld;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aYA());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.flY));
        pbPageRequestMessage.setIsSubPostDataReverse(this.flJ);
        pbPageRequestMessage.setFromSmartFrs(this.flM ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.flc);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean aXy() {
        switch (aYP()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().aVs() == null || !getPbData().aVs().sX();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aYi()) && com.baidu.tieba.recapp.r.bjk().bje() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bjk().bje().Q(aYi(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bjk().bje().R(aYi(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aYi()) && com.baidu.tieba.recapp.r.bjk().bje() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bjk().bje().R(aYi(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bjk().bje().Q(aYi(), true));
        }
    }

    protected void qp(int i) {
        boolean z = false;
        qt(i);
        ArrayList<PostData> aVu = this.flr.aVu();
        this.flF = false;
        if (i == 1) {
            boolean z2 = false;
            while (aVu.size() + 30 > com.baidu.tbadk.data.d.Da()) {
                aVu.remove(0);
                z2 = true;
            }
            if (z2) {
                this.flr.rf().bJ(1);
                if (this.flx != null) {
                    this.flx.f(this.flr);
                }
            }
            this.dnQ = System.currentTimeMillis();
            this.flF = true;
        } else if (i == 2) {
            while (aVu.size() + 30 > com.baidu.tbadk.data.d.Da()) {
                aVu.remove(aVu.size() - 1);
                z = true;
            }
            if (z) {
                this.flr.rf().bI(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.flN = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fla)) {
            try {
                Long valueOf = Long.valueOf(this.fla);
                com.baidu.tieba.pb.data.l aVD = dVar.aVD();
                if (aVD != null && aVD.fec != null) {
                    if (aVD.fec.isEmpty() || !aVD.fec.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fkZ);
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
            if (this.flv || this.flt || this.flu) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.aVu().size(); i++) {
                PostData postData = dVar.aVu().get(i);
                for (int i2 = 0; i2 < postData.brU().size(); i2++) {
                    postData.brU().get(i2).b(this.bcK.getPageContext(), l.equals(postData.brU().get(i2).rP().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.l aVD = dVar.aVD();
            if (aVD != null && !com.baidu.tbadk.core.util.v.w(aVD.feb)) {
                for (PostData postData2 : aVD.feb) {
                    for (int i3 = 0; i3 < postData2.brU().size(); i3++) {
                        postData2.brU().get(i3).b(this.bcK.getPageContext(), l.equals(postData2.brU().get(i3).rP().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.l aVD = dVar.aVD();
            if (aVD != null && !com.baidu.tbadk.core.util.v.w(aVD.feb)) {
                for (PostData postData : aVD.feb.subList(i, aVD.feb.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.brU().size()) {
                            postData.brU().get(i3).b(this.bcK.getPageContext(), l.equals(postData.brU().get(i3).rP().getUserId()));
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
        bd aVs = dVar.aVs();
        aVs.bR(this.mIsGood);
        aVs.bQ(this.flh);
        if (this.fli > 0) {
            aVs.n(this.fli);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.aVs() != null && dVar.aVs().rP() != null) {
            str = dVar.aVs().rP().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aYt() {
        if (this.flr == null || this.flr.aVs() == null || this.flr.aVs().rP() == null) {
            return null;
        }
        return this.flr.aVs().rP();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.flL = z3;
        this.fls = i;
        if (this.cJG != null && !z3) {
            this.cJG.a(z2, z4, i2, str, i3, j, j2);
            this.cJG = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aYi()) && com.baidu.tieba.recapp.r.bjk().bje() != null) {
            com.baidu.tieba.recapp.r.bjk().bje().f(aYi(), qq(getRequestType()), true);
        }
        if (dVar == null || (this.flj == 1 && i == 5 && dVar.aVu() != null && dVar.aVu().size() < 1)) {
            if (this.flx != null) {
                this.flf = this.fle;
                this.flx.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fle = this.flf;
            this.flp = false;
            if (dVar.rf() != null) {
                c(dVar.rf());
            }
            this.cvP = this.cvP < 1 ? 1 : this.cvP;
            ArrayList<PostData> aVu = this.flr.aVu();
            switch (i) {
                case 1:
                    this.flr.a(dVar.rf(), 1);
                    e(dVar, aVu);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.aVu() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.aVu().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aVu, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(dVar.aVu(), com.baidu.tbadk.core.util.v.v(dVar.aVu()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.aVu().remove(postData2);
                            i6 = size - 1;
                        }
                        aVu.addAll(0, dVar.aVu());
                    }
                    this.flr.a(dVar.rf(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.flf && dVar.rf() != null) {
                        dVar.rf().bG(dVar.rf().qW());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && this.flf) {
                        aYu();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.w(dVar.aVu()) && this.flr != null && (!this.fld || l(dVar).equals(dVar.aVu().get(0).rP().getUserId()))) {
                        if (this.flr.rf().rb() == 0) {
                            this.flr.rf().bI(1);
                        }
                        aYQ();
                        this.fma = dVar.aVu().get(0);
                        if (this.flf) {
                            if (this.flr.aVu().size() - this.fmc >= 3) {
                                this.fmb = new PostData();
                                this.fmb.gxU = true;
                                this.fmb.setPostType(53);
                                this.flr.aVu().add(this.fmb);
                            }
                            this.flr.aVu().add(this.fma);
                            i4 = this.flr.aVu().size() - 1;
                        } else {
                            if (this.fmc - this.fmd >= 3) {
                                this.fmb = new PostData();
                                this.fmb.gxU = false;
                                this.fmb.setPostType(53);
                                this.flr.aVu().add(0, this.fmb);
                            }
                            this.flr.aVu().add(0, this.fma);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.an.O(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fma.gyh = this.flr.aVR();
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
            if (this.flr != null && this.flr.aVs() != null) {
                PraiseData rE = this.flr.aVs().rE();
                if (this.fmi != null && !rE.isPriaseDataValid()) {
                    this.flr.aVs().a(this.fmi);
                } else {
                    this.fmi = this.flr.aVs().rE();
                    this.fmi.setPostId(this.flr.aVs().sf());
                }
                if (dVar.rf() != null && dVar.rf().qZ() == 1 && dVar.aVs() != null && dVar.aVs().sa() != null && dVar.aVs().sa().size() > 0) {
                    this.flr.aVs().h(dVar.aVs().sa());
                }
                this.flr.aVs().bO(dVar.aVs().rH());
                this.flr.aVs().bL(dVar.aVs().getAnchorLevel());
                this.flr.aVs().bN(dVar.aVs().rB());
                if (this.mThreadType == 33) {
                    this.flr.aVs().rP().setHadConcerned(dVar.aVs().rP().hadConcerned());
                }
                if (dVar != null && dVar.aVs() != null) {
                    this.flr.aVs().bT(dVar.aVs().se());
                }
            }
            if (this.flr != null && this.flr.getUserData() != null && dVar.getUserData() != null) {
                this.flr.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.flr.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.rf() != null && dVar.rf().qZ() == 1 && dVar.aVC() != null) {
                this.flr.c(dVar.aVC());
            }
            if (this.flL) {
                if (this.flr.aVs() != null && this.flr.aVs().rP() != null && this.flr.aVu() != null && com.baidu.tbadk.core.util.v.c(this.flr.aVu(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.flr.aVu(), 0);
                    MetaData rP = this.flr.aVs().rP();
                    if (postData3.rP() != null && postData3.rP().getGodUserData() != null) {
                        if (this.flA != -1) {
                            rP.setFansNum(this.flA);
                            postData3.rP().setFansNum(this.flA);
                        }
                        if (this.flB != -1) {
                            rP.getGodUserData().setIsLike(this.flB == 1);
                            postData3.rP().getGodUserData().setIsLike(this.flB == 1);
                            rP.getGodUserData().setIsFromNetWork(false);
                            postData3.rP().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.flr.fdx = -1;
                this.flr.fdw = -1;
            }
            if (this.flx != null) {
                this.flx.a(true, getErrorCode(), i, i5, this.flr, this.mErrorString, 1);
            }
        }
        if (this.flr != null && this.flr.aVs() != null && this.flr.aVq() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bcK;
            historyMessage.threadId = getPbData().aVs().getId();
            if (this.mIsShareThread && getPbData().aVs().abM != null) {
                historyMessage.threadName = getPbData().aVs().abM.showText;
            } else {
                historyMessage.threadName = getPbData().aVs().getTitle();
            }
            if (this.mIsShareThread && !aXy()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().aVq().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aYk();
            historyMessage.threadType = getPbData().aVs().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String an;
        if (arrayList != null && dVar.aVu() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(dVar.aVu(), 0);
            if (postData != null && (an = an(arrayList)) != null && an.equals(postData.getId())) {
                dVar.aVu().remove(postData);
            }
            arrayList.addAll(dVar.aVu());
        }
    }

    private int qq(int i) {
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
    public void m(com.baidu.tieba.pb.data.d dVar) {
        dVar.qt(this.flr.aVJ());
        this.flr = dVar;
        qn(dVar.rf().qZ());
    }

    private void aYu() {
        if (this.flr != null && this.flr.aVu() != null && this.flr.aVI() != null) {
            ArrayList<PostData> aVu = this.flr.aVu();
            com.baidu.tieba.pb.data.a aVI = this.flr.aVI();
            int aVo = aVI.aVo();
            if (aVo > 0) {
                if (aVo <= aVu.size()) {
                    aVu.add(aVo, aVI);
                } else {
                    aVu.add(aVI);
                }
            }
        }
    }

    public boolean aYv() {
        if (this.fkZ == null || this.flb == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return qo(4);
        }
        return qo(6);
    }

    public boolean jN(boolean z) {
        if (this.fkZ == null || this.flr == null) {
            return false;
        }
        if (z || this.flr.rf().rb() != 0) {
            return qo(1);
        }
        return false;
    }

    public boolean jO(boolean z) {
        if (this.fkZ == null || this.flr == null) {
            return false;
        }
        if ((z || this.flr.rf().rc() != 0) && this.flr.aVu() != null && this.flr.aVu().size() >= 1) {
            return qo(2);
        }
        return false;
    }

    public boolean qz(String str) {
        this.fld = !this.fld;
        this.flb = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.al("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (qo(6)) {
            return true;
        }
        this.fld = this.fld ? false : true;
        return false;
    }

    public boolean l(boolean z, String str) {
        if (this.fld == z) {
            return false;
        }
        this.fld = z;
        this.flb = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (qo(6)) {
            return true;
        }
        this.fld = z ? false : true;
        return false;
    }

    public boolean aYw() {
        this.fle = this.flf;
        this.flf = !this.flf;
        if (this.isLoading || !LoadData()) {
            this.flf = this.flf ? false : true;
            return false;
        }
        return true;
    }

    public boolean aYx() {
        return this.flf;
    }

    public boolean hasData() {
        return (this.flr == null || this.flr.aVq() == null || this.flr.aVs() == null) ? false : true;
    }

    public boolean oH() {
        if (this.flr == null) {
            return false;
        }
        return this.flr.oH();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gi(String str) {
        if (this.flr == null || this.flr.aVs() == null || this.flr.aVq() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.flr.aVs().sX()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.flr.aVq().getId());
            writeData.setForumName(this.flr.aVq().getName());
        }
        writeData.sourceFrom = String.valueOf(this.flY);
        writeData.setThreadId(this.fkZ);
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

    public MarkData qr(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.flr == null) {
            return null;
        }
        ArrayList<PostData> aVu = this.flr.aVu();
        if (com.baidu.tbadk.core.util.v.w(aVu)) {
            return null;
        }
        if (aVu.size() > 0 && i >= aVu.size()) {
            i = aVu.size() - 1;
        }
        return g(aVu.get(i));
    }

    public MarkData aYy() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fkZ);
        markData.setPostId(this.flr.oG());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fld);
        markData.setSequence(Boolean.valueOf(this.flf));
        markData.setId(this.fkZ);
        return markData;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fkZ);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fld);
        markData.setSequence(Boolean.valueOf(this.flf));
        markData.setId(this.fkZ);
        markData.setFloor(postData.brX());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aYz() {
        g.aXS().J(aYA(), this.isFromMark);
    }

    private String aYA() {
        String str = this.fkZ;
        if (this.fld) {
            str = str + DB_KEY_HOST;
        }
        if (!this.flf) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jP(boolean z) {
        if (this.flr != null) {
            this.flr.ae(z);
        }
    }

    public void jQ(boolean z) {
        this.flC = z;
    }

    public boolean aYB() {
        return this.flC;
    }

    public void a(a aVar) {
        this.flx = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String DY() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean DX() {
        return FW();
    }

    public boolean qA(String str) {
        if (getPbData() == null || getPbData().aVs() == null || getPbData().aVs().rP() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aVs().rP().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void aYC() {
        String aYA = aYA();
        g.aXS().J(aYA, false);
        g.aXS().J(aYA, true);
    }

    public void aYD() {
        if ("personalize_page".equals(this.mStType)) {
            this.flI = System.currentTimeMillis() / 1000;
        }
    }

    public void aYE() {
        if ("personalize_page".equals(this.mStType) && this.flr != null && this.flI != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10754").ac(ImageViewerConfig.FORUM_ID, this.flr.getForumId()).ac("tid", this.fkZ).ac("obj_duration", String.valueOf(currentTimeMillis - this.flI)).ac("obj_param3", String.valueOf(currentTimeMillis)));
            this.flI = 0L;
        }
    }

    public boolean aYF() {
        return this.flL;
    }

    public int getErrorNo() {
        return this.flN;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h aYG() {
        return this.flP;
    }

    public m aYH() {
        return this.flQ;
    }

    public q aYI() {
        return this.flR;
    }

    public y aYJ() {
        return this.flS;
    }

    public CheckRealNameModel aYK() {
        return this.bRm;
    }

    public AddExperiencedModel aYL() {
        return this.flU;
    }

    public String aYM() {
        return this.flH;
    }

    public void qB(String str) {
        this.flH = str;
    }

    public boolean aYN() {
        return this.flM;
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.flr != null && this.flr.aVu() != null && this.flr.aVu().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.flr.aVu().size();
                for (int i = 0; i < size; i++) {
                    if (this.flr.aVu().get(i) != null && this.flr.aVu().get(i).rP() != null && currentAccount.equals(this.flr.aVu().get(i).rP().getUserId()) && this.flr.aVu().get(i).rP().getPendantData() != null) {
                        this.flr.aVu().get(i).rP().getPendantData().cL(hVar.qF());
                        this.flr.aVu().get(i).rP().getPendantData().T(hVar.Di());
                    }
                }
            }
        }
    }

    public String aYO() {
        return this.flT;
    }

    public int aYP() {
        return this.flY;
    }

    public void qs(int i) {
        this.flY = i;
    }

    public void qC(String str) {
        if ((!this.fld || qA(TbadkCoreApplication.getCurrentAccount())) && this.flr.aVu() != null) {
            this.flr.rf().bI(1);
            if (this.flr.rf().rb() == 0) {
                this.flr.rf().bI(1);
            }
            this.flZ = str;
            qo(8);
        }
    }

    private void qt(int i) {
        if (i != 8) {
            this.flZ = "";
            if (this.fma != null) {
                if (i == 1 && !this.flf && !com.baidu.tbadk.core.util.v.w(getPbData().aVu())) {
                    getPbData().aVu().remove(this.fma);
                    if (this.fmb != null) {
                        getPbData().aVu().remove(this.fmb);
                    }
                    getPbData().aVu().add(0, this.fma);
                } else {
                    getPbData().aVu().remove(this.fma);
                    if (this.fmb != null) {
                        getPbData().aVu().remove(this.fmb);
                    }
                }
            }
            this.fmb = null;
        }
    }

    public void aYQ() {
        if (this.flr != null && !com.baidu.tbadk.core.util.v.w(this.flr.aVu())) {
            if (this.fmb != null) {
                this.flr.aVu().remove(this.fmb);
                this.fmb = null;
            }
            if (this.fma != null) {
                this.flr.aVu().remove(this.fma);
                this.fma = null;
            }
        }
    }

    public void bo(int i, int i2) {
        this.fmc = i;
        this.fmd = i2;
    }

    public PostData aYR() {
        return this.fma;
    }

    public PostData aYS() {
        return this.fmb;
    }

    public int aYT() {
        return this.fmc;
    }

    public String aYU() {
        return this.fme;
    }

    public void qD(String str) {
        this.fme = str;
    }
}
