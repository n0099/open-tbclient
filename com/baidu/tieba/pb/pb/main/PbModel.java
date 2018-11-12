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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.e;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import tbclient.PbPage.PbSortType;
/* loaded from: classes6.dex */
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
    private BaseActivity bxI;
    private int cUd;
    private final CheckRealNameModel crg;
    private long dSX;
    private com.baidu.tieba.tbadkCore.d.b diE;
    private boolean eZe;
    private boolean fRA;
    private long fRB;
    private boolean fRC;
    private String fRD;
    protected com.baidu.tieba.pb.data.d fRE;
    private int fRF;
    private boolean fRG;
    private boolean fRH;
    private boolean fRI;
    private boolean fRJ;
    private a fRK;
    private String fRL;
    private String fRM;
    private int fRN;
    private int fRO;
    private boolean fRP;
    private boolean fRQ;
    private boolean fRR;
    private boolean fRS;
    private boolean fRT;
    private String fRU;
    private long fRV;
    private boolean fRW;
    private int fRX;
    private boolean fRY;
    private boolean fRZ;
    protected String fRk;
    private String fRl;
    private String fRm;
    private boolean fRn;
    private boolean fRo;
    private boolean fRp;
    private boolean fRq;
    private int fRr;
    private boolean fRs;
    private int fRt;
    private long fRu;
    private int fRv;
    private int fRw;
    private int fRx;
    private boolean fRy;
    private boolean fRz;
    private int fSa;
    private final x fSb;
    private final h fSc;
    private final m fSd;
    private final z fSe;
    private String fSf;
    private final AddExperiencedModel fSg;
    private SuggestEmotionModel fSh;
    private GetSugMatchWordsModel fSi;
    private boolean fSj;
    private int fSk;
    private String fSl;
    private PostData fSm;
    private PostData fSn;
    private int fSo;
    private int fSp;
    private String fSq;
    private CustomMessageListener fSr;
    private CustomMessageListener fSs;
    private com.baidu.adp.framework.listener.a fSt;
    private PraiseData fSu;
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
    private int mSortType;
    public String mStType;
    protected int mThreadType;
    private String opType;
    private String opUrl;
    private String postID;
    private static final int fRj = com.baidu.tbadk.data.d.Ks() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.d dVar);
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.fRk = null;
        this.fRl = null;
        this.fRm = null;
        this.mForumId = null;
        this.fRn = false;
        this.fRo = false;
        this.fRp = true;
        this.fRq = true;
        this.mSortType = 0;
        this.fRr = 0;
        this.fRs = false;
        this.mIsGood = 0;
        this.fRt = 0;
        this.fRu = 0L;
        this.fRv = 1;
        this.fRw = 1;
        this.fRx = 1;
        this.cUd = 1;
        this.isAd = false;
        this.eZe = false;
        this.fRy = false;
        this.fRz = false;
        this.isFromMark = false;
        this.fRA = false;
        this.fRB = 0L;
        this.fRC = false;
        this.fRD = null;
        this.fRE = null;
        this.isLoading = false;
        this.fRG = false;
        this.fRH = false;
        this.fRI = false;
        this.fRJ = false;
        this.mLocate = null;
        this.mContext = null;
        this.fRK = null;
        this.opType = null;
        this.opUrl = null;
        this.fRL = null;
        this.fRM = null;
        this.fRN = -1;
        this.fRO = -1;
        this.diE = null;
        this.fRQ = false;
        this.fRR = false;
        this.postID = null;
        this.fRU = null;
        this.fRV = 0L;
        this.fRW = false;
        this.fRX = -1;
        this.fRZ = false;
        this.fSj = false;
        this.fSk = 0;
        this.fSr = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.fRT = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.bet() != null) {
                        pbData.bet().cA(0);
                    }
                    if (PbModel.this.fRK != null && pbData != null) {
                        com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fRK.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fSs = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().ber() != null && PbModel.this.getPbData().ber().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().ber().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fSt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.kV()) {
                        PbModel.this.bxI.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.fRQ || !PbModel.this.fRR) {
                        if (!PbModel.this.fRQ) {
                            PbModel.this.fRQ = true;
                        } else {
                            PbModel.this.fRR = true;
                        }
                        if (PbModel.this.fRK != null) {
                            PbModel.this.fRK.a(PbModel.this.bhk(), z, responsedMessage, PbModel.this.fRS, System.currentTimeMillis() - PbModel.this.dSX);
                        }
                    }
                }
            }
        };
        this.fSu = null;
        registerListener(this.fSr);
        registerListener(this.fSt);
        registerListener(this.fSs);
        this.fRE = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bxI = baseActivity;
        this.fSb = new x(this, this.bxI);
        this.fSc = new h(this, this.bxI);
        this.fSd = new m(this, this.bxI);
        this.fSe = new z(this, this.bxI);
        this.crg = new CheckRealNameModel(this.bxI.getPageContext());
        this.fSh = new SuggestEmotionModel();
        this.fSg = new AddExperiencedModel(this.bxI.getPageContext());
    }

    protected int bhk() {
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
        this.fRk = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fRk)) {
            this.fRk = this.fSb.Y(intent);
            if (StringUtils.isNull(this.fRk) && intent.getData() != null) {
                this.fRk = intent.getData().getQueryParameter("thread_id");
            }
        }
        this.fSk = intent.getIntExtra("key_start_from", 0);
        if (this.fSk == 0) {
            this.fSk = this.fSb.fSA;
        }
        this.fRm = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.mFromForumId = intent.getStringExtra("from_forum_id");
        this.fRl = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fRn = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fRo = intent.getBooleanExtra("host_only", false);
        this.fRq = intent.getBooleanExtra("squence", true);
        this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.OB().Fb() ? 2 : 0);
        if (this.mSortType == 2) {
            this.fRm = "0";
        }
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fRt = intent.getIntExtra("is_top", 0);
        this.fRu = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fRA = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eZe = intent.getBooleanExtra("is_sub_pb", false);
        this.fRC = intent.getBooleanExtra("is_pv", false);
        this.fRB = intent.getLongExtra("msg_id", 0L);
        this.fRD = intent.getStringExtra("from_forum_name");
        this.fRM = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fRL = intent.getStringExtra("op_stat");
        this.fRG = intent.getBooleanExtra("is_from_thread_config", false);
        this.fRH = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fRI = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fRO = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fRN = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fRy = intent.getBooleanExtra("from_frs", false);
        this.fRz = intent.getBooleanExtra("from_maintab", false);
        this.fRZ = intent.getBooleanExtra("from_smart_frs", false);
        this.fRJ = intent.getBooleanExtra("from_hottopic", false);
        this.fSf = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fSk = bundle.getInt("key_start_from", 0);
        this.fRk = bundle.getString("thread_id");
        this.fRm = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.fRl = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fRn = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fRo = bundle.getBoolean("host_only", false);
        this.fRq = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fRt = bundle.getInt("is_top", 0);
        this.fRu = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fRA = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eZe = bundle.getBoolean("is_sub_pb", false);
        this.fRC = bundle.getBoolean("is_pv", false);
        this.fRB = bundle.getLong("msg_id", 0L);
        this.fRD = bundle.getString("from_forum_name");
        this.fRM = bundle.getString("extra_pb_cache_key");
        this.fRG = bundle.getBoolean("is_from_thread_config", false);
        this.fRH = bundle.getBoolean("is_from_interview_live_config", false);
        this.fRI = bundle.getBoolean("is_from_my_god_config", false);
        this.fRO = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fRN = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fRy = bundle.getBoolean("from_frs", false);
        this.fRz = bundle.getBoolean("from_maintab", false);
        this.fRZ = bundle.getBoolean("from_smart_frs", false);
        this.fRJ = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void D(Bundle bundle) {
        bundle.putString("thread_id", this.fRk);
        bundle.putString("post_id", this.fRm);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.fSk);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fRn);
        bundle.putBoolean("host_only", this.fRo);
        bundle.putBoolean("squence", this.fRq);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fRt);
        bundle.putLong("thread_time", this.fRu);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fRA);
        bundle.putBoolean("is_sub_pb", this.eZe);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fRC);
        bundle.putLong("msg_id", this.fRB);
        bundle.putString("extra_pb_cache_key", this.fRM);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fRG);
        bundle.putBoolean("is_from_interview_live_config", this.fRH);
        bundle.putBoolean("is_from_my_god_config", this.fRI);
        bundle.putInt("extra_pb_is_attention_key", this.fRO);
        bundle.putInt("extra_pb_funs_count_key", this.fRN);
        bundle.putBoolean("from_frs", this.fRy);
        bundle.putBoolean("from_maintab", this.fRz);
        bundle.putBoolean("from_smart_frs", this.fRZ);
        bundle.putBoolean("from_hottopic", this.fRJ);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bhl() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fRk);
        if (!this.fRA) {
            sb.append(this.fRm);
        }
        sb.append(this.fRo);
        sb.append(this.fRq);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fRt);
        sb.append(this.fRu);
        sb.append(this.fRy);
        sb.append(this.fRz);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eZe);
        sb.append(this.fRC);
        sb.append(this.fRB);
        sb.append(this.fRD);
        sb.append(this.mThreadType);
        sb.append(this.fRG);
        sb.append(this.fRH);
        sb.append(this.fRI);
        if (this.fRM != null) {
            sb.append(this.fRM);
        }
        return sb.toString();
    }

    public String bfo() {
        return this.fRD;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.fRm;
    }

    public String bhm() {
        return this.fRk;
    }

    public boolean getHostMode() {
        return this.fRo;
    }

    public boolean bhn() {
        return bhX();
    }

    public int aaT() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bho() {
        return this.fRy;
    }

    public boolean bhp() {
        return this.fRs;
    }

    public boolean bhq() {
        return this.fRz;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bhr() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bhs() {
        return this.fRt;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void ky(int i) {
        this.fRt = i;
    }

    public boolean bht() {
        return this.eZe;
    }

    public boolean bhu() {
        if (this.fRE == null) {
            return false;
        }
        return this.fRE.isValid();
    }

    public String yM() {
        if (this.fRE == null || !this.fRE.vm()) {
            return null;
        }
        return this.fRE.vl();
    }

    public boolean rT(int i) {
        this.fRv = i;
        if (this.fRv > this.fRE.xO().xG()) {
            this.fRv = this.fRE.xO().xG();
        }
        if (this.fRv < 1) {
            this.fRv = 1;
        }
        if (this.fRk == null) {
            return false;
        }
        return rV(5);
    }

    public void rU(int i) {
        this.fRv = i;
        this.fRw = i;
        this.fRx = i;
    }

    public void c(com.baidu.tbadk.core.data.al alVar) {
        if (alVar == null) {
            rU(1);
            return;
        }
        if (this.fRw < alVar.xJ()) {
            this.fRw = alVar.xJ();
        }
        if (this.fRx > alVar.xJ()) {
            this.fRx = alVar.xJ();
        }
        this.cUd = alVar.xG();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.fRE;
    }

    public com.baidu.tbadk.core.data.al getPageData() {
        if (this.fRE == null) {
            return null;
        }
        return this.fRE.xO();
    }

    public boolean bhv() {
        if (bhX() && this.fRE.xO().xL() == 0) {
            kR(true);
            return true;
        }
        return false;
    }

    public void sm(String str) {
        if (!StringUtils.isNull(str)) {
            this.fRk = str;
            this.fRm = null;
            this.fRo = false;
            this.fRq = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fRk == null) {
            return false;
        }
        cancelLoadData();
        if (this.diE == null) {
            this.diE = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.diE.start();
        }
        boolean rV = rV(3);
        if (this.opType != null) {
            this.opType = null;
            this.fRL = null;
            this.opUrl = null;
            return rV;
        }
        return rV;
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
        if (this.fSh != null) {
            this.fSh.cancelLoadData();
        }
        if (this.fSi != null) {
            this.fSi.cancelLoadData();
        }
        atR();
    }

    private void atR() {
        if (this.diE != null) {
            this.diE.destory();
            this.diE = null;
        }
    }

    public boolean Ns() {
        return (this.fRm == null || this.fRm.equals("0") || this.fRm.length() == 0) ? LoadData() : bhy();
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
                this.fSh.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fSh.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fSi == null) {
                this.fSi = new GetSugMatchWordsModel(this.bxI.getPageContext());
            }
            this.fSi.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x02ea A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ee A[Catch: Exception -> 0x0220, TryCatch #0 {Exception -> 0x0220, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:42:0x0129, B:44:0x0146, B:45:0x014e, B:47:0x015b, B:48:0x0163, B:50:0x0167, B:51:0x016c, B:53:0x0170, B:54:0x0175, B:56:0x0179, B:57:0x0189, B:59:0x018d, B:60:0x0195, B:62:0x0199, B:63:0x01b2, B:64:0x01c1, B:65:0x01c4, B:68:0x01f0, B:70:0x0203, B:75:0x022a, B:77:0x0240, B:79:0x0246, B:81:0x024d, B:82:0x025a, B:84:0x026e, B:86:0x0274, B:88:0x027a, B:97:0x02aa, B:99:0x02b0, B:89:0x0285, B:91:0x0289, B:93:0x0291, B:95:0x02a0, B:96:0x02a5, B:100:0x02bc, B:102:0x02d0, B:104:0x02d4, B:107:0x02e6, B:136:0x035e, B:111:0x02ee, B:113:0x02f4, B:114:0x02f9, B:116:0x02fd, B:118:0x0307, B:123:0x031e, B:125:0x032c, B:126:0x032f, B:128:0x0333, B:129:0x033e, B:131:0x0342, B:133:0x034a, B:135:0x0359, B:137:0x0363, B:139:0x0367, B:120:0x030b, B:140:0x0370, B:141:0x039e, B:143:0x03a2, B:153:0x03d3, B:146:0x03ae, B:148:0x03bc, B:149:0x03c4, B:151:0x03c8, B:152:0x03ce, B:154:0x03dc, B:145:0x03a6, B:155:0x03e5, B:157:0x03f1, B:159:0x03f5, B:161:0x03f9, B:162:0x03fe, B:164:0x040a, B:165:0x0412, B:169:0x042c, B:166:0x0417, B:168:0x0426, B:170:0x0435, B:172:0x0444, B:36:0x00c8), top: B:176:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02fd A[Catch: Exception -> 0x0220, TryCatch #0 {Exception -> 0x0220, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:42:0x0129, B:44:0x0146, B:45:0x014e, B:47:0x015b, B:48:0x0163, B:50:0x0167, B:51:0x016c, B:53:0x0170, B:54:0x0175, B:56:0x0179, B:57:0x0189, B:59:0x018d, B:60:0x0195, B:62:0x0199, B:63:0x01b2, B:64:0x01c1, B:65:0x01c4, B:68:0x01f0, B:70:0x0203, B:75:0x022a, B:77:0x0240, B:79:0x0246, B:81:0x024d, B:82:0x025a, B:84:0x026e, B:86:0x0274, B:88:0x027a, B:97:0x02aa, B:99:0x02b0, B:89:0x0285, B:91:0x0289, B:93:0x0291, B:95:0x02a0, B:96:0x02a5, B:100:0x02bc, B:102:0x02d0, B:104:0x02d4, B:107:0x02e6, B:136:0x035e, B:111:0x02ee, B:113:0x02f4, B:114:0x02f9, B:116:0x02fd, B:118:0x0307, B:123:0x031e, B:125:0x032c, B:126:0x032f, B:128:0x0333, B:129:0x033e, B:131:0x0342, B:133:0x034a, B:135:0x0359, B:137:0x0363, B:139:0x0367, B:120:0x030b, B:140:0x0370, B:141:0x039e, B:143:0x03a2, B:153:0x03d3, B:146:0x03ae, B:148:0x03bc, B:149:0x03c4, B:151:0x03c8, B:152:0x03ce, B:154:0x03dc, B:145:0x03a6, B:155:0x03e5, B:157:0x03f1, B:159:0x03f5, B:161:0x03f9, B:162:0x03fe, B:164:0x040a, B:165:0x0412, B:169:0x042c, B:166:0x0417, B:168:0x0426, B:170:0x0435, B:172:0x0444, B:36:0x00c8), top: B:176:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0333 A[Catch: Exception -> 0x0220, TryCatch #0 {Exception -> 0x0220, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:42:0x0129, B:44:0x0146, B:45:0x014e, B:47:0x015b, B:48:0x0163, B:50:0x0167, B:51:0x016c, B:53:0x0170, B:54:0x0175, B:56:0x0179, B:57:0x0189, B:59:0x018d, B:60:0x0195, B:62:0x0199, B:63:0x01b2, B:64:0x01c1, B:65:0x01c4, B:68:0x01f0, B:70:0x0203, B:75:0x022a, B:77:0x0240, B:79:0x0246, B:81:0x024d, B:82:0x025a, B:84:0x026e, B:86:0x0274, B:88:0x027a, B:97:0x02aa, B:99:0x02b0, B:89:0x0285, B:91:0x0289, B:93:0x0291, B:95:0x02a0, B:96:0x02a5, B:100:0x02bc, B:102:0x02d0, B:104:0x02d4, B:107:0x02e6, B:136:0x035e, B:111:0x02ee, B:113:0x02f4, B:114:0x02f9, B:116:0x02fd, B:118:0x0307, B:123:0x031e, B:125:0x032c, B:126:0x032f, B:128:0x0333, B:129:0x033e, B:131:0x0342, B:133:0x034a, B:135:0x0359, B:137:0x0363, B:139:0x0367, B:120:0x030b, B:140:0x0370, B:141:0x039e, B:143:0x03a2, B:153:0x03d3, B:146:0x03ae, B:148:0x03bc, B:149:0x03c4, B:151:0x03c8, B:152:0x03ce, B:154:0x03dc, B:145:0x03a6, B:155:0x03e5, B:157:0x03f1, B:159:0x03f5, B:161:0x03f9, B:162:0x03fe, B:164:0x040a, B:165:0x0412, B:169:0x042c, B:166:0x0417, B:168:0x0426, B:170:0x0435, B:172:0x0444, B:36:0x00c8), top: B:176:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0342 A[Catch: Exception -> 0x0220, TryCatch #0 {Exception -> 0x0220, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:42:0x0129, B:44:0x0146, B:45:0x014e, B:47:0x015b, B:48:0x0163, B:50:0x0167, B:51:0x016c, B:53:0x0170, B:54:0x0175, B:56:0x0179, B:57:0x0189, B:59:0x018d, B:60:0x0195, B:62:0x0199, B:63:0x01b2, B:64:0x01c1, B:65:0x01c4, B:68:0x01f0, B:70:0x0203, B:75:0x022a, B:77:0x0240, B:79:0x0246, B:81:0x024d, B:82:0x025a, B:84:0x026e, B:86:0x0274, B:88:0x027a, B:97:0x02aa, B:99:0x02b0, B:89:0x0285, B:91:0x0289, B:93:0x0291, B:95:0x02a0, B:96:0x02a5, B:100:0x02bc, B:102:0x02d0, B:104:0x02d4, B:107:0x02e6, B:136:0x035e, B:111:0x02ee, B:113:0x02f4, B:114:0x02f9, B:116:0x02fd, B:118:0x0307, B:123:0x031e, B:125:0x032c, B:126:0x032f, B:128:0x0333, B:129:0x033e, B:131:0x0342, B:133:0x034a, B:135:0x0359, B:137:0x0363, B:139:0x0367, B:120:0x030b, B:140:0x0370, B:141:0x039e, B:143:0x03a2, B:153:0x03d3, B:146:0x03ae, B:148:0x03bc, B:149:0x03c4, B:151:0x03c8, B:152:0x03ce, B:154:0x03dc, B:145:0x03a6, B:155:0x03e5, B:157:0x03f1, B:159:0x03f5, B:161:0x03f9, B:162:0x03fe, B:164:0x040a, B:165:0x0412, B:169:0x042c, B:166:0x0417, B:168:0x0426, B:170:0x0435, B:172:0x0444, B:36:0x00c8), top: B:176:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0367 A[Catch: Exception -> 0x0220, TryCatch #0 {Exception -> 0x0220, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:42:0x0129, B:44:0x0146, B:45:0x014e, B:47:0x015b, B:48:0x0163, B:50:0x0167, B:51:0x016c, B:53:0x0170, B:54:0x0175, B:56:0x0179, B:57:0x0189, B:59:0x018d, B:60:0x0195, B:62:0x0199, B:63:0x01b2, B:64:0x01c1, B:65:0x01c4, B:68:0x01f0, B:70:0x0203, B:75:0x022a, B:77:0x0240, B:79:0x0246, B:81:0x024d, B:82:0x025a, B:84:0x026e, B:86:0x0274, B:88:0x027a, B:97:0x02aa, B:99:0x02b0, B:89:0x0285, B:91:0x0289, B:93:0x0291, B:95:0x02a0, B:96:0x02a5, B:100:0x02bc, B:102:0x02d0, B:104:0x02d4, B:107:0x02e6, B:136:0x035e, B:111:0x02ee, B:113:0x02f4, B:114:0x02f9, B:116:0x02fd, B:118:0x0307, B:123:0x031e, B:125:0x032c, B:126:0x032f, B:128:0x0333, B:129:0x033e, B:131:0x0342, B:133:0x034a, B:135:0x0359, B:137:0x0363, B:139:0x0367, B:120:0x030b, B:140:0x0370, B:141:0x039e, B:143:0x03a2, B:153:0x03d3, B:146:0x03ae, B:148:0x03bc, B:149:0x03c4, B:151:0x03c8, B:152:0x03ce, B:154:0x03dc, B:145:0x03a6, B:155:0x03e5, B:157:0x03f1, B:159:0x03f5, B:161:0x03f9, B:162:0x03fe, B:164:0x040a, B:165:0x0412, B:169:0x042c, B:166:0x0417, B:168:0x0426, B:170:0x0435, B:172:0x0444, B:36:0x00c8), top: B:176:0x00bc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean rV(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        rW(i);
        final com.baidu.tieba.pb.data.d pbData = aj.biu().getPbData();
        if (pbData != null && pbData.bet() != null) {
            pbData.bet().cA(0);
            this.fRq = aj.biu().bhn();
            this.fRo = aj.biu().biz();
            this.fRs = aj.biu().biA();
            this.fSm = aj.biu().biy();
            this.fSn = aj.biu().bix();
            this.fSo = aj.biu().biw();
            this.fSj = this.fRo;
            if (this.fRo || this.isFromMark) {
                this.fRP = false;
            }
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.fRT) {
            a(bhD(), true, this.fRm, 3);
        }
        if (i == 3 && !this.fRT) {
            if (this.isFromMark) {
                a(bhD(), true, this.fRm, 3);
            } else {
                a(bhD(), false, this.fRm, 3);
            }
        }
        this.fRT = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aTX);
        if (this.fRo || this.isFromMark) {
            this.fRP = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fRk == null || this.fRk.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.fRk, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.aq.CN().CP() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(aO));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aQ));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.fRq) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.fRo) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fRC) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fRB));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fRP) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.l(this.fRL, 0));
            pbPageRequestMessage.setOpMessageID(this.fRB);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bev = this.fRE.bev();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fRx - 1));
                        if (this.fRx - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z) {
                                if (bev != null && bev.size() > 0) {
                                    size = bev.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bev.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.fRm = postData.getId();
                                            if (StringUtils.isNull(this.fRm)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.fRw + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.fRm == null && this.fRm.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fRm, 0L));
                                    if (this.mSortType == 2) {
                                        pbPageRequestMessage.set_pid(0L);
                                    }
                                } else if (this.mSortType == 1) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            b(pbPageRequestMessage);
                            break;
                        }
                    } else {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fRw + 1));
                        if (this.fRw >= this.cUd) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bev != null) {
                                size = bev.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.fRm == null) {
                            }
                            if (this.mSortType == 1) {
                            }
                            b(pbPageRequestMessage);
                        }
                    }
                }
                z = false;
                if (!this.isFromMark) {
                }
                if (bev != null) {
                }
                if (this.fRm == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bev != null && bev.size() > 0 && bev.get(0) != null) {
                    this.fRm = bev.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bhX()) {
                        if (this.fRx - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fRx - 1));
                        }
                    } else if (this.fRw < this.cUd) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fRw + 1));
                    }
                }
                if (this.fRm != null && this.fRm.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fRm, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fRo) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bhX()) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fRm, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fRv));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.fSj && !this.fRo) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fRm, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.fRo) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fRX);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fSl, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fSj = this.fRo;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bhD());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fSk));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fRW);
        pbPageRequestMessage.setFromSmartFrs(this.fRZ ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fRn);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bfn() {
        switch (bhR()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bet() == null || !getPbData().bet().zN();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bfo()) && com.baidu.tieba.recapp.r.bsG().bsA() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bsG().bsA().Y(bfo(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bsG().bsA().Z(bfo(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bfo()) && com.baidu.tieba.recapp.r.bsG().bsA() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bsG().bsA().Z(bfo(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bsG().bsA().Y(bfo(), true));
        }
    }

    protected void rW(int i) {
        boolean z = false;
        sb(i);
        ArrayList<PostData> bev = this.fRE.bev();
        this.fRS = false;
        if (i == 1) {
            boolean z2 = false;
            while (bev.size() + 30 > com.baidu.tbadk.data.d.Ks()) {
                bev.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fRE.xO().cx(1);
                if (this.fRK != null) {
                    this.fRK.f(this.fRE);
                }
            }
            this.dSX = System.currentTimeMillis();
            this.fRS = true;
        } else if (i == 2) {
            while (bev.size() + 30 > com.baidu.tbadk.data.d.Ks()) {
                bev.remove(bev.size() - 1);
                z = true;
            }
            if (z) {
                this.fRE.xO().cw(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.fSa = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fRl)) {
            try {
                Long valueOf = Long.valueOf(this.fRl);
                com.baidu.tieba.pb.data.k beE = dVar.beE();
                if (beE != null && beE.fKf != null) {
                    if (beE.fKf.isEmpty() || !beE.fKf.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fRk);
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
            if (this.fRI || this.fRG || this.fRH) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.bev().size(); i++) {
                PostData postData = dVar.bev().get(i);
                for (int i2 = 0; i2 < postData.bBu().size(); i2++) {
                    postData.bBu().get(i2).a(this.bxI.getPageContext(), l.equals(postData.bBu().get(i2).yC().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.k beE = dVar.beE();
            if (beE != null && !com.baidu.tbadk.core.util.v.I(beE.fKe)) {
                for (PostData postData2 : beE.fKe) {
                    for (int i3 = 0; i3 < postData2.bBu().size(); i3++) {
                        postData2.bBu().get(i3).a(this.bxI.getPageContext(), l.equals(postData2.bBu().get(i3).yC().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.k beE = dVar.beE();
            if (beE != null && !com.baidu.tbadk.core.util.v.I(beE.fKe)) {
                for (PostData postData : beE.fKe.subList(i, beE.fKe.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bBu().size()) {
                            postData.bBu().get(i3).a(this.bxI.getPageContext(), l.equals(postData.bBu().get(i3).yC().getUserId()));
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
        bb bet = dVar.bet();
        bet.cE(this.mIsGood);
        bet.cD(this.fRt);
        if (this.fRu > 0) {
            bet.w(this.fRu);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bet() != null && dVar.bet().yC() != null) {
            str = dVar.bet().yC().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bhw() {
        if (this.fRE == null || this.fRE.bet() == null || this.fRE.bet().yC() == null) {
            return null;
        }
        return this.fRE.bet().yC();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fRY = z3;
        this.fRF = i;
        if (this.diE != null && !z3) {
            this.diE.a(z2, z4, i2, str, i3, j, j2);
            this.diE = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bfo()) && com.baidu.tieba.recapp.r.bsG().bsA() != null) {
            com.baidu.tieba.recapp.r.bsG().bsA().f(bfo(), rX(getRequestType()), true);
        }
        if (dVar == null || (this.fRv == 1 && i == 5 && dVar.bev() != null && dVar.bev().size() < 1)) {
            if (this.fRK != null) {
                this.fRq = this.fRp;
                this.mSortType = this.fRr;
                this.fRK.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fRp = this.fRq;
            if (i != 8) {
                this.fRr = this.mSortType;
                this.mSortType = dVar.fJF;
            }
            if (dVar.fJE != null && dVar.fJE.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.bxI.getResources().getString(e.j.default_sort);
                builder.sort_type = 0;
                dVar.fJE = new ArrayList();
                dVar.fJE.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.bxI.getResources().getString(e.j.view_reverse);
                builder2.sort_type = 1;
                dVar.fJE.add(builder2.build(false));
                this.mSortType = this.fRr;
                dVar.fJF = this.mSortType;
            }
            this.fRC = false;
            if (dVar.xO() != null && (this.mSortType != 2 || i != 8)) {
                c(dVar.xO());
            }
            this.cUd = this.cUd < 1 ? 1 : this.cUd;
            ArrayList<PostData> bev = this.fRE.bev();
            switch (i) {
                case 1:
                    this.fRE.a(dVar.xO(), 1);
                    d(dVar, bev);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bev() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bev().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(bev, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.d(dVar.bev(), com.baidu.tbadk.core.util.v.H(dVar.bev()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bev().remove(postData2);
                            i6 = size - 1;
                        }
                        bev.addAll(0, dVar.bev());
                    }
                    this.fRE.a(dVar.xO(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.xO() != null) {
                        dVar.xO().cu(dVar.xO().xG());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && bhX()) {
                        bhx();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.I(dVar.bev()) && this.fRE != null && (!this.fRo || l(dVar).equals(dVar.bev().get(0).yC().getUserId()))) {
                        if (this.fRE.xO().xL() == 0) {
                            this.fRE.xO().cw(1);
                        }
                        bhS();
                        this.fSm = dVar.bev().get(0);
                        if (bhX()) {
                            if (this.fRE.bev().size() - this.fSo >= 3) {
                                this.fSn = new PostData();
                                this.fSn.heS = true;
                                this.fSn.setPostType(53);
                                this.fRE.bev().add(this.fSn);
                            }
                            this.fRE.bev().add(this.fSm);
                            i4 = this.fRE.bev().size() - 1;
                        } else {
                            if (this.fSo - this.fSp >= 3) {
                                this.fSn = new PostData();
                                this.fSn.heS = false;
                                this.fSn.setPostType(53);
                                this.fRE.bev().add(0, this.fSn);
                            }
                            this.fRE.bev().add(0, this.fSm);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ao.ac(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fSm.hfe = this.fRE.beU();
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
            if (this.fRE != null && this.fRE.bet() != null) {
                PraiseData yp = this.fRE.bet().yp();
                if (this.fSu != null && !yp.isPriaseDataValid()) {
                    this.fRE.bet().a(this.fSu);
                } else {
                    this.fSu = this.fRE.bet().yp();
                    this.fSu.setPostId(this.fRE.bet().yT());
                }
                if (dVar.xO() != null && dVar.xO().xJ() == 1 && dVar.bet() != null && dVar.bet().yO() != null && dVar.bet().yO().size() > 0) {
                    this.fRE.bet().l(dVar.bet().yO());
                }
                this.fRE.bet().cB(dVar.bet().yt());
                this.fRE.bet().cy(dVar.bet().getAnchorLevel());
                this.fRE.bet().cA(dVar.bet().yl());
                if (this.mThreadType == 33) {
                    this.fRE.bet().yC().setHadConcerned(dVar.bet().yC().hadConcerned());
                }
                if (dVar != null && dVar.bet() != null) {
                    this.fRE.bet().cG(dVar.bet().yS());
                }
            }
            if (this.fRE != null && this.fRE.getUserData() != null && dVar.getUserData() != null) {
                this.fRE.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.fRE.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.xO() != null && dVar.xO().xJ() == 1 && dVar.beD() != null) {
                this.fRE.d(dVar.beD());
            }
            if (this.fRY) {
                if (this.fRE.bet() != null && this.fRE.bet().yC() != null && this.fRE.bev() != null && com.baidu.tbadk.core.util.v.d(this.fRE.bev(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.d(this.fRE.bev(), 0);
                    MetaData yC = this.fRE.bet().yC();
                    if (postData3.yC() != null && postData3.yC().getGodUserData() != null) {
                        if (this.fRN != -1) {
                            yC.setFansNum(this.fRN);
                            postData3.yC().setFansNum(this.fRN);
                        }
                        if (this.fRO != -1) {
                            yC.getGodUserData().setIsLike(this.fRO == 1);
                            postData3.yC().getGodUserData().setIsLike(this.fRO == 1);
                            yC.getGodUserData().setIsFromNetWork(false);
                            postData3.yC().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fRE.fJD = -1;
                this.fRE.fJC = -1;
            }
            if (this.fRK != null) {
                this.fRK.a(true, getErrorCode(), i, i5, this.fRE, this.mErrorString, 1);
            }
        }
        if (this.fRE != null && this.fRE.bet() != null && this.fRE.ber() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bxI.getPageContext();
            historyMessage.threadId = getPbData().bet().getId();
            if (this.mIsShareThread && getPbData().bet().arT != null) {
                historyMessage.threadName = getPbData().bet().arT.showText;
            } else {
                historyMessage.threadName = getPbData().bet().getTitle();
            }
            if (this.mIsShareThread && !bfn()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().ber().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bhn();
            historyMessage.threadType = getPbData().bet().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String ao;
        if (arrayList != null && dVar.bev() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(dVar.bev(), 0);
            if (postData != null && (ao = ao(arrayList)) != null && ao.equals(postData.getId())) {
                dVar.bev().remove(postData);
            }
            arrayList.addAll(dVar.bev());
        }
    }

    private int rX(int i) {
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

    private String ao(ArrayList<PostData> arrayList) {
        int H = com.baidu.tbadk.core.util.v.H(arrayList);
        if (H <= 0) {
            return null;
        }
        for (int i = H - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.tieba.pb.data.d dVar) {
        dVar.sj(this.fRE.beM());
        this.fRE = dVar;
        rU(dVar.xO().xJ());
    }

    private void bhx() {
        if (this.fRE != null && this.fRE.bev() != null && this.fRE.beL() != null) {
            ArrayList<PostData> bev = this.fRE.bev();
            com.baidu.tieba.pb.data.a beL = this.fRE.beL();
            int bep = beL.bep();
            if (bep > 0) {
                if (bep <= bev.size()) {
                    bev.add(bep, beL);
                } else {
                    bev.add(beL);
                }
            }
        }
    }

    public boolean bhy() {
        if (this.fRk == null || this.fRm == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return rV(4);
        }
        return rV(6);
    }

    public boolean kR(boolean z) {
        if (this.fRk == null || this.fRE == null) {
            return false;
        }
        if (z || this.fRE.xO().xL() != 0) {
            return rV(1);
        }
        return false;
    }

    public boolean kS(boolean z) {
        if (this.fRk == null || this.fRE == null) {
            return false;
        }
        if ((z || this.fRE.xO().xM() != 0) && this.fRE.bev() != null && this.fRE.bev().size() >= 1) {
            return rV(2);
        }
        return false;
    }

    public boolean ss(String str) {
        this.fRo = !this.fRo;
        this.fRm = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (rV(6)) {
            return true;
        }
        this.fRo = this.fRo ? false : true;
        return false;
    }

    public boolean p(boolean z, String str) {
        if (this.fRo == z) {
            return false;
        }
        this.fRo = z;
        this.fRm = str;
        if (this.mSortType == 2) {
            this.fRm = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (rV(6)) {
            return true;
        }
        this.fRo = z ? false : true;
        return false;
    }

    public boolean rY(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.fRp = this.fRq;
        this.fRr = this.mSortType;
        this.mSortType = i;
        this.fRq = !this.fRq;
        if (i == 2 && this.isFromMark) {
            this.fRm = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.fRq = this.fRq ? false : true;
            this.mSortType = this.fRr;
            return false;
        }
        return true;
    }

    public boolean bhz() {
        return bhX();
    }

    public int bhA() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.fRE == null || this.fRE.ber() == null || this.fRE.bet() == null) ? false : true;
    }

    public boolean vm() {
        if (this.fRE == null) {
            return false;
        }
        return this.fRE.vm();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hs(String str) {
        if (this.fRE == null || this.fRE.bet() == null || this.fRE.ber() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fRE.bet().zN()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fRE.ber().getId());
            writeData.setForumName(this.fRE.ber().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.fSk);
        writeData.setThreadId(this.fRk);
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

    public MarkData rZ(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fRE == null) {
            return null;
        }
        ArrayList<PostData> bev = this.fRE.bev();
        if (com.baidu.tbadk.core.util.v.I(bev)) {
            return null;
        }
        if (bev.size() > 0 && i >= bev.size()) {
            i = bev.size() - 1;
        }
        return h(bev.get(i));
    }

    public MarkData bhB() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fRk);
        markData.setPostId(this.fRE.vl());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fRo);
        markData.setSequence(Boolean.valueOf(bhX()));
        markData.setId(this.fRk);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fRk);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fRo);
        markData.setSequence(Boolean.valueOf(bhX()));
        markData.setId(this.fRk);
        markData.setFloor(postData.bBx());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bhC() {
        g.bgW().R(bhD(), this.isFromMark);
    }

    private String bhD() {
        String str = this.fRk;
        if (this.fRo) {
            str = str + DB_KEY_HOST;
        }
        if (this.mSortType == 1) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void kT(boolean z) {
        if (this.fRE != null) {
            this.fRE.aO(z);
        }
    }

    public void kU(boolean z) {
        this.fRP = z;
    }

    public boolean bhE() {
        return this.fRP;
    }

    public void a(a aVar) {
        this.fRK = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lo() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Ln() {
        return Ns();
    }

    public boolean st(String str) {
        if (getPbData() == null || getPbData().bet() == null || getPbData().bet().yC() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bet().yC().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bhF() {
        String bhD = bhD();
        g.bgW().R(bhD, false);
        g.bgW().R(bhD, true);
    }

    public void bhG() {
        if ("personalize_page".equals(this.mStType)) {
            this.fRV = System.currentTimeMillis() / 1000;
        }
    }

    public void bhH() {
        if ("personalize_page".equals(this.mStType) && this.fRE != null && this.fRV != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10754").ax(ImageViewerConfig.FORUM_ID, this.fRE.getForumId()).ax("tid", this.fRk).ax("obj_duration", String.valueOf(currentTimeMillis - this.fRV)).ax("obj_param3", String.valueOf(currentTimeMillis)));
            this.fRV = 0L;
        }
    }

    public boolean bhI() {
        return this.fRY;
    }

    public int getErrorNo() {
        return this.fSa;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bhJ() {
        return this.fSc;
    }

    public m bhK() {
        return this.fSd;
    }

    public z bhL() {
        return this.fSe;
    }

    public CheckRealNameModel bhM() {
        return this.crg;
    }

    public AddExperiencedModel bhN() {
        return this.fSg;
    }

    public String bhO() {
        return this.fRU;
    }

    public void su(String str) {
        this.fRU = str;
    }

    public boolean bhP() {
        return this.fRZ;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.fRE != null && this.fRE.bev() != null && this.fRE.bev().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fRE.bev().size();
                for (int i = 0; i < size; i++) {
                    if (this.fRE.bev().get(i) != null && this.fRE.bev().get(i).yC() != null && currentAccount.equals(this.fRE.bev().get(i).yC().getUserId()) && this.fRE.bev().get(i).yC().getPendantData() != null) {
                        this.fRE.bev().get(i).yC().getPendantData().dR(jVar.xn());
                        this.fRE.bev().get(i).yC().getPendantData().ah(jVar.KA());
                    }
                }
            }
        }
    }

    public String bhQ() {
        return this.fSf;
    }

    public int bhR() {
        return this.fSk;
    }

    public void sa(int i) {
        this.fSk = i;
    }

    public void sv(String str) {
        if ((!this.fRo || st(TbadkCoreApplication.getCurrentAccount())) && this.fRE.bev() != null) {
            this.fRE.xO().cw(1);
            if (this.fRE.xO().xL() == 0) {
                this.fRE.xO().cw(1);
            }
            this.fSl = str;
            rV(8);
        }
    }

    private void sb(int i) {
        if (i != 8) {
            this.fSl = "";
            if (this.fSm != null) {
                if (i == 1 && !this.fRq && !com.baidu.tbadk.core.util.v.I(getPbData().bev())) {
                    getPbData().bev().remove(this.fSm);
                    if (this.fSn != null) {
                        getPbData().bev().remove(this.fSn);
                    }
                    getPbData().bev().add(0, this.fSm);
                } else {
                    getPbData().bev().remove(this.fSm);
                    if (this.fSn != null) {
                        getPbData().bev().remove(this.fSn);
                    }
                }
            }
            this.fSn = null;
        }
    }

    public void bhS() {
        if (this.fRE != null && !com.baidu.tbadk.core.util.v.I(this.fRE.bev())) {
            if (this.fSn != null) {
                this.fRE.bev().remove(this.fSn);
                this.fSn = null;
            }
            if (this.fSm != null) {
                this.fRE.bev().remove(this.fSm);
                this.fSm = null;
            }
        }
    }

    public void bz(int i, int i2) {
        this.fSo = i;
        this.fSp = i2;
    }

    public PostData bhT() {
        return this.fSm;
    }

    public PostData bhU() {
        return this.fSn;
    }

    public int bhV() {
        return this.fSo;
    }

    public String bhW() {
        return this.fSq;
    }

    public void sw(String str) {
        this.fSq = str;
    }

    private boolean bhX() {
        return this.mSortType == 0 || this.mSortType == 2;
    }
}
