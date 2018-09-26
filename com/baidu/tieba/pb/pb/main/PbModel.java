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
    private BaseActivity bsQ;
    private int cKE;
    private com.baidu.tieba.tbadkCore.d.b cZk;
    private final CheckRealNameModel ciy;
    private long dJU;
    private boolean eQd;
    private long fIA;
    private boolean fIB;
    private String fIC;
    protected com.baidu.tieba.pb.data.d fID;
    private int fIE;
    private boolean fIF;
    private boolean fIG;
    private boolean fIH;
    private boolean fII;
    private a fIJ;
    private String fIK;
    private String fIL;
    private int fIM;
    private int fIN;
    private boolean fIO;
    private boolean fIP;
    private boolean fIQ;
    private boolean fIR;
    private boolean fIS;
    private String fIT;
    private long fIU;
    private boolean fIV;
    private int fIW;
    private boolean fIX;
    private boolean fIY;
    private int fIZ;
    protected String fIj;
    private String fIk;
    private String fIl;
    private boolean fIm;
    private boolean fIn;
    private boolean fIo;
    private boolean fIp;
    private int fIq;
    private boolean fIr;
    private int fIs;
    private long fIt;
    private int fIu;
    private int fIv;
    private int fIw;
    private boolean fIx;
    private boolean fIy;
    private boolean fIz;
    private final x fJa;
    private final h fJb;
    private final m fJc;
    private final z fJd;
    private String fJe;
    private final AddExperiencedModel fJf;
    private SuggestEmotionModel fJg;
    private GetSugMatchWordsModel fJh;
    private boolean fJi;
    private int fJj;
    private String fJk;
    private PostData fJl;
    private PostData fJm;
    private int fJn;
    private int fJo;
    private String fJp;
    private CustomMessageListener fJq;
    private CustomMessageListener fJr;
    private com.baidu.adp.framework.listener.a fJs;
    private PraiseData fJt;
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
    private static final int fIi = com.baidu.tbadk.data.d.Ih() / 30;
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
        this.fIj = null;
        this.fIk = null;
        this.fIl = null;
        this.mForumId = null;
        this.fIm = false;
        this.fIn = false;
        this.fIo = true;
        this.fIp = true;
        this.mSortType = 0;
        this.fIq = 0;
        this.fIr = false;
        this.mIsGood = 0;
        this.fIs = 0;
        this.fIt = 0L;
        this.fIu = 1;
        this.fIv = 1;
        this.fIw = 1;
        this.cKE = 1;
        this.isAd = false;
        this.eQd = false;
        this.fIx = false;
        this.fIy = false;
        this.isFromMark = false;
        this.fIz = false;
        this.fIA = 0L;
        this.fIB = false;
        this.fIC = null;
        this.fID = null;
        this.isLoading = false;
        this.fIF = false;
        this.fIG = false;
        this.fIH = false;
        this.fII = false;
        this.mLocate = null;
        this.mContext = null;
        this.fIJ = null;
        this.opType = null;
        this.opUrl = null;
        this.fIK = null;
        this.fIL = null;
        this.fIM = -1;
        this.fIN = -1;
        this.cZk = null;
        this.fIP = false;
        this.fIQ = false;
        this.postID = null;
        this.fIT = null;
        this.fIU = 0L;
        this.fIV = false;
        this.fIW = -1;
        this.fIY = false;
        this.fJi = false;
        this.fJj = 0;
        this.fJq = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.fIS = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.bbJ() != null) {
                        pbData.bbJ().cb(0);
                    }
                    if (PbModel.this.fIJ != null && pbData != null) {
                        com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fIJ.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fJr = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().bbH() != null && PbModel.this.getPbData().bbH().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().bbH().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fJs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.kK()) {
                        PbModel.this.bsQ.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.fIP || !PbModel.this.fIQ) {
                        if (!PbModel.this.fIP) {
                            PbModel.this.fIP = true;
                        } else {
                            PbModel.this.fIQ = true;
                        }
                        if (PbModel.this.fIJ != null) {
                            PbModel.this.fIJ.a(PbModel.this.beB(), z, responsedMessage, PbModel.this.fIR, System.currentTimeMillis() - PbModel.this.dJU);
                        }
                    }
                }
            }
        };
        this.fJt = null;
        registerListener(this.fJq);
        registerListener(this.fJs);
        registerListener(this.fJr);
        this.fID = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bsQ = baseActivity;
        this.fJa = new x(this, this.bsQ);
        this.fJb = new h(this, this.bsQ);
        this.fJc = new m(this, this.bsQ);
        this.fJd = new z(this, this.bsQ);
        this.ciy = new CheckRealNameModel(this.bsQ.getPageContext());
        this.fJg = new SuggestEmotionModel();
        this.fJf = new AddExperiencedModel(this.bsQ.getPageContext());
    }

    protected int beB() {
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
        this.fIj = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fIj)) {
            this.fIj = this.fJa.U(intent);
            if (StringUtils.isNull(this.fIj) && intent.getData() != null) {
                this.fIj = intent.getData().getQueryParameter("thread_id");
            }
        }
        this.fJj = intent.getIntExtra("key_start_from", 0);
        if (this.fJj == 0) {
            this.fJj = this.fJa.fJz;
        }
        this.fIl = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.mFromForumId = intent.getStringExtra("from_forum_id");
        this.fIk = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fIm = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fIn = intent.getBooleanExtra("host_only", false);
        this.fIp = intent.getBooleanExtra("squence", true);
        this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.Mu().CM() ? 2 : 0);
        if (this.mSortType == 2) {
            this.fIl = "0";
        }
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fIs = intent.getIntExtra("is_top", 0);
        this.fIt = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fIz = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eQd = intent.getBooleanExtra("is_sub_pb", false);
        this.fIB = intent.getBooleanExtra("is_pv", false);
        this.fIA = intent.getLongExtra("msg_id", 0L);
        this.fIC = intent.getStringExtra("from_forum_name");
        this.fIL = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fIK = intent.getStringExtra("op_stat");
        this.fIF = intent.getBooleanExtra("is_from_thread_config", false);
        this.fIG = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fIH = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fIN = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fIM = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fIx = intent.getBooleanExtra("from_frs", false);
        this.fIy = intent.getBooleanExtra("from_maintab", false);
        this.fIY = intent.getBooleanExtra("from_smart_frs", false);
        this.fII = intent.getBooleanExtra("from_hottopic", false);
        this.fJe = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fJj = bundle.getInt("key_start_from", 0);
        this.fIj = bundle.getString("thread_id");
        this.fIl = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.fIk = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fIm = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fIn = bundle.getBoolean("host_only", false);
        this.fIp = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fIs = bundle.getInt("is_top", 0);
        this.fIt = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fIz = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eQd = bundle.getBoolean("is_sub_pb", false);
        this.fIB = bundle.getBoolean("is_pv", false);
        this.fIA = bundle.getLong("msg_id", 0L);
        this.fIC = bundle.getString("from_forum_name");
        this.fIL = bundle.getString("extra_pb_cache_key");
        this.fIF = bundle.getBoolean("is_from_thread_config", false);
        this.fIG = bundle.getBoolean("is_from_interview_live_config", false);
        this.fIH = bundle.getBoolean("is_from_my_god_config", false);
        this.fIN = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fIM = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fIx = bundle.getBoolean("from_frs", false);
        this.fIy = bundle.getBoolean("from_maintab", false);
        this.fIY = bundle.getBoolean("from_smart_frs", false);
        this.fII = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void z(Bundle bundle) {
        bundle.putString("thread_id", this.fIj);
        bundle.putString("post_id", this.fIl);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.fJj);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fIm);
        bundle.putBoolean("host_only", this.fIn);
        bundle.putBoolean("squence", this.fIp);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fIs);
        bundle.putLong("thread_time", this.fIt);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fIz);
        bundle.putBoolean("is_sub_pb", this.eQd);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fIB);
        bundle.putLong("msg_id", this.fIA);
        bundle.putString("extra_pb_cache_key", this.fIL);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fIF);
        bundle.putBoolean("is_from_interview_live_config", this.fIG);
        bundle.putBoolean("is_from_my_god_config", this.fIH);
        bundle.putInt("extra_pb_is_attention_key", this.fIN);
        bundle.putInt("extra_pb_funs_count_key", this.fIM);
        bundle.putBoolean("from_frs", this.fIx);
        bundle.putBoolean("from_maintab", this.fIy);
        bundle.putBoolean("from_smart_frs", this.fIY);
        bundle.putBoolean("from_hottopic", this.fII);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String beC() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fIj);
        if (!this.fIz) {
            sb.append(this.fIl);
        }
        sb.append(this.fIn);
        sb.append(this.fIp);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fIs);
        sb.append(this.fIt);
        sb.append(this.fIx);
        sb.append(this.fIy);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eQd);
        sb.append(this.fIB);
        sb.append(this.fIA);
        sb.append(this.fIC);
        sb.append(this.mThreadType);
        sb.append(this.fIF);
        sb.append(this.fIG);
        sb.append(this.fIH);
        if (this.fIL != null) {
            sb.append(this.fIL);
        }
        return sb.toString();
    }

    public String bcF() {
        return this.fIC;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.fIl;
    }

    public String beD() {
        return this.fIj;
    }

    public boolean getHostMode() {
        return this.fIn;
    }

    public boolean beE() {
        return bfo();
    }

    public int Xb() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean beF() {
        return this.fIx;
    }

    public boolean beG() {
        return this.fIr;
    }

    public boolean beH() {
        return this.fIy;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean beI() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int beJ() {
        return this.fIs;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void jH(int i) {
        this.fIs = i;
    }

    public boolean beK() {
        return this.eQd;
    }

    public boolean beL() {
        if (this.fID == null) {
            return false;
        }
        return this.fID.isValid();
    }

    public String ww() {
        if (this.fID == null || !this.fID.sR()) {
            return null;
        }
        return this.fID.sQ();
    }

    public boolean rd(int i) {
        this.fIu = i;
        if (this.fIu > this.fID.vy().vp()) {
            this.fIu = this.fID.vy().vp();
        }
        if (this.fIu < 1) {
            this.fIu = 1;
        }
        if (this.fIj == null) {
            return false;
        }
        return rf(5);
    }

    public void re(int i) {
        this.fIu = i;
        this.fIv = i;
        this.fIw = i;
    }

    public void c(com.baidu.tbadk.core.data.al alVar) {
        if (alVar == null) {
            re(1);
            return;
        }
        if (this.fIv < alVar.vs()) {
            this.fIv = alVar.vs();
        }
        if (this.fIw > alVar.vs()) {
            this.fIw = alVar.vs();
        }
        this.cKE = alVar.vp();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.fID;
    }

    public com.baidu.tbadk.core.data.al getPageData() {
        if (this.fID == null) {
            return null;
        }
        return this.fID.vy();
    }

    public boolean beM() {
        if (bfo() && this.fID.vy().vu() == 0) {
            kp(true);
            return true;
        }
        return false;
    }

    public void rL(String str) {
        if (!StringUtils.isNull(str)) {
            this.fIj = str;
            this.fIl = null;
            this.fIn = false;
            this.fIp = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fIj == null) {
            return false;
        }
        cancelLoadData();
        if (this.cZk == null) {
            this.cZk = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.cZk.start();
        }
        boolean rf = rf(3);
        if (this.opType != null) {
            this.opType = null;
            this.fIK = null;
            this.opUrl = null;
            return rf;
        }
        return rf;
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
        if (this.fJg != null) {
            this.fJg.cancelLoadData();
        }
        if (this.fJh != null) {
            this.fJh.cancelLoadData();
        }
        aqW();
    }

    private void aqW() {
        if (this.cZk != null) {
            this.cZk.destory();
            this.cZk = null;
        }
    }

    public boolean Ll() {
        return (this.fIl == null || this.fIl.equals("0") || this.fIl.length() == 0) ? LoadData() : beP();
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
                this.fJg.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fJg.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fJh == null) {
                this.fJh = new GetSugMatchWordsModel(this.bsQ.getPageContext());
            }
            this.fJh.b(aVar);
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
    public boolean rf(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        rg(i);
        final com.baidu.tieba.pb.data.d pbData = aj.bfL().getPbData();
        if (pbData != null && pbData.bbJ() != null) {
            pbData.bbJ().cb(0);
            this.fIp = aj.bfL().beE();
            this.fIn = aj.bfL().bfQ();
            this.fIr = aj.bfL().bfR();
            this.fJl = aj.bfL().bfP();
            this.fJm = aj.bfL().bfO();
            this.fJn = aj.bfL().bfN();
            this.fJi = this.fIn;
            if (this.fIn || this.isFromMark) {
                this.fIO = false;
            }
            com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.fIS) {
            a(beU(), true, this.fIl, 3);
        }
        if (i == 3 && !this.fIS) {
            if (this.isFromMark) {
                a(beU(), true, this.fIl, 3);
            } else {
                a(beU(), false, this.fIl, 3);
            }
        }
        this.fIS = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aOF);
        if (this.fIn || this.isFromMark) {
            this.fIO = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fIj == null || this.fIj.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.fIj, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.aq.Az().AB() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(aO));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aQ));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.fIp) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.fIn) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fIB) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fIA));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fIO) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.l(this.fIK, 0));
            pbPageRequestMessage.setOpMessageID(this.fIA);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bbL = this.fID.bbL();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fIw - 1));
                        if (this.fIw - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z) {
                                if (bbL != null && bbL.size() > 0) {
                                    size = bbL.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bbL.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.fIl = postData.getId();
                                            if (StringUtils.isNull(this.fIl)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.fIv + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.fIl == null && this.fIl.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fIl, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fIv + 1));
                        if (this.fIv >= this.cKE) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bbL != null) {
                                size = bbL.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.fIl == null) {
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
                if (bbL != null) {
                }
                if (this.fIl == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bbL != null && bbL.size() > 0 && bbL.get(0) != null) {
                    this.fIl = bbL.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bfo()) {
                        if (this.fIw - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fIw - 1));
                        }
                    } else if (this.fIv < this.cKE) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fIv + 1));
                    }
                }
                if (this.fIl != null && this.fIl.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fIl, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fIn) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bfo()) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fIl, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fIu));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.fJi && !this.fIn) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fIl, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.fIn) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fIW);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fJk, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fJi = this.fIn;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(beU());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fJj));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fIV);
        pbPageRequestMessage.setFromSmartFrs(this.fIY ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fIm);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bcE() {
        switch (bfi()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bbJ() == null || !getPbData().bbJ().xx();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bcF()) && com.baidu.tieba.recapp.r.bpV().bpP() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bpV().bpP().R(bcF(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bpV().bpP().S(bcF(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bcF()) && com.baidu.tieba.recapp.r.bpV().bpP() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bpV().bpP().S(bcF(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bpV().bpP().R(bcF(), true));
        }
    }

    protected void rg(int i) {
        boolean z = false;
        rl(i);
        ArrayList<PostData> bbL = this.fID.bbL();
        this.fIR = false;
        if (i == 1) {
            boolean z2 = false;
            while (bbL.size() + 30 > com.baidu.tbadk.data.d.Ih()) {
                bbL.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fID.vy().bX(1);
                if (this.fIJ != null) {
                    this.fIJ.f(this.fID);
                }
            }
            this.dJU = System.currentTimeMillis();
            this.fIR = true;
        } else if (i == 2) {
            while (bbL.size() + 30 > com.baidu.tbadk.data.d.Ih()) {
                bbL.remove(bbL.size() - 1);
                z = true;
            }
            if (z) {
                this.fID.vy().bW(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.fIZ = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fIk)) {
            try {
                Long valueOf = Long.valueOf(this.fIk);
                com.baidu.tieba.pb.data.k bbU = dVar.bbU();
                if (bbU != null && bbU.fBe != null) {
                    if (bbU.fBe.isEmpty() || !bbU.fBe.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fIj);
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
            if (this.fIH || this.fIF || this.fIG) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.bbL().size(); i++) {
                PostData postData = dVar.bbL().get(i);
                for (int i2 = 0; i2 < postData.byJ().size(); i2++) {
                    postData.byJ().get(i2).b(this.bsQ.getPageContext(), l.equals(postData.byJ().get(i2).wm().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.k bbU = dVar.bbU();
            if (bbU != null && !com.baidu.tbadk.core.util.v.z(bbU.fBd)) {
                for (PostData postData2 : bbU.fBd) {
                    for (int i3 = 0; i3 < postData2.byJ().size(); i3++) {
                        postData2.byJ().get(i3).b(this.bsQ.getPageContext(), l.equals(postData2.byJ().get(i3).wm().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.k bbU = dVar.bbU();
            if (bbU != null && !com.baidu.tbadk.core.util.v.z(bbU.fBd)) {
                for (PostData postData : bbU.fBd.subList(i, bbU.fBd.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.byJ().size()) {
                            postData.byJ().get(i3).b(this.bsQ.getPageContext(), l.equals(postData.byJ().get(i3).wm().getUserId()));
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
        bb bbJ = dVar.bbJ();
        bbJ.cf(this.mIsGood);
        bbJ.ce(this.fIs);
        if (this.fIt > 0) {
            bbJ.s(this.fIt);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bbJ() != null && dVar.bbJ().wm() != null) {
            str = dVar.bbJ().wm().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData beN() {
        if (this.fID == null || this.fID.bbJ() == null || this.fID.bbJ().wm() == null) {
            return null;
        }
        return this.fID.bbJ().wm();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fIX = z3;
        this.fIE = i;
        if (this.cZk != null && !z3) {
            this.cZk.a(z2, z4, i2, str, i3, j, j2);
            this.cZk = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bcF()) && com.baidu.tieba.recapp.r.bpV().bpP() != null) {
            com.baidu.tieba.recapp.r.bpV().bpP().f(bcF(), rh(getRequestType()), true);
        }
        if (dVar == null || (this.fIu == 1 && i == 5 && dVar.bbL() != null && dVar.bbL().size() < 1)) {
            if (this.fIJ != null) {
                this.fIp = this.fIo;
                this.mSortType = this.fIq;
                this.fIJ.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fIo = this.fIp;
            this.fIq = this.mSortType;
            this.mSortType = dVar.fAE;
            if (dVar.fAD != null && dVar.fAD.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.bsQ.getResources().getString(e.j.default_sort);
                builder.sort_type = 0;
                dVar.fAD = new ArrayList();
                dVar.fAD.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.bsQ.getResources().getString(e.j.view_reverse);
                builder2.sort_type = 1;
                dVar.fAD.add(builder2.build(false));
                this.mSortType = this.fIq;
                dVar.fAE = this.mSortType;
            }
            this.fIB = false;
            if (dVar.vy() != null && (this.mSortType != 2 || i != 8)) {
                c(dVar.vy());
            }
            this.cKE = this.cKE < 1 ? 1 : this.cKE;
            ArrayList<PostData> bbL = this.fID.bbL();
            switch (i) {
                case 1:
                    this.fID.a(dVar.vy(), 1);
                    d(dVar, bbL);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bbL() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bbL().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(bbL, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.d(dVar.bbL(), com.baidu.tbadk.core.util.v.y(dVar.bbL()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bbL().remove(postData2);
                            i6 = size - 1;
                        }
                        bbL.addAll(0, dVar.bbL());
                    }
                    this.fID.a(dVar.vy(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.vy() != null) {
                        dVar.vy().bU(dVar.vy().vp());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && bfo()) {
                        beO();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.z(dVar.bbL()) && this.fID != null && (!this.fIn || l(dVar).equals(dVar.bbL().get(0).wm().getUserId()))) {
                        if (this.fID.vy().vu() == 0) {
                            this.fID.vy().bW(1);
                        }
                        bfj();
                        this.fJl = dVar.bbL().get(0);
                        if (bfo()) {
                            if (this.fID.bbL().size() - this.fJn >= 3) {
                                this.fJm = new PostData();
                                this.fJm.gVZ = true;
                                this.fJm.setPostType(53);
                                this.fID.bbL().add(this.fJm);
                            }
                            this.fID.bbL().add(this.fJl);
                            i4 = this.fID.bbL().size() - 1;
                        } else {
                            if (this.fJn - this.fJo >= 3) {
                                this.fJm = new PostData();
                                this.fJm.gVZ = false;
                                this.fJm.setPostType(53);
                                this.fID.bbL().add(0, this.fJm);
                            }
                            this.fID.bbL().add(0, this.fJl);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ao.Y(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fJl.gWl = this.fID.bck();
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
            if (this.fID != null && this.fID.bbJ() != null) {
                PraiseData vZ = this.fID.bbJ().vZ();
                if (this.fJt != null && !vZ.isPriaseDataValid()) {
                    this.fID.bbJ().a(this.fJt);
                } else {
                    this.fJt = this.fID.bbJ().vZ();
                    this.fJt.setPostId(this.fID.bbJ().wD());
                }
                if (dVar.vy() != null && dVar.vy().vs() == 1 && dVar.bbJ() != null && dVar.bbJ().wy() != null && dVar.bbJ().wy().size() > 0) {
                    this.fID.bbJ().l(dVar.bbJ().wy());
                }
                this.fID.bbJ().cc(dVar.bbJ().wd());
                this.fID.bbJ().bZ(dVar.bbJ().getAnchorLevel());
                this.fID.bbJ().cb(dVar.bbJ().vV());
                if (this.mThreadType == 33) {
                    this.fID.bbJ().wm().setHadConcerned(dVar.bbJ().wm().hadConcerned());
                }
                if (dVar != null && dVar.bbJ() != null) {
                    this.fID.bbJ().ch(dVar.bbJ().wC());
                }
            }
            if (this.fID != null && this.fID.getUserData() != null && dVar.getUserData() != null) {
                this.fID.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.fID.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.vy() != null && dVar.vy().vs() == 1 && dVar.bbT() != null) {
                this.fID.d(dVar.bbT());
            }
            if (this.fIX) {
                if (this.fID.bbJ() != null && this.fID.bbJ().wm() != null && this.fID.bbL() != null && com.baidu.tbadk.core.util.v.d(this.fID.bbL(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.d(this.fID.bbL(), 0);
                    MetaData wm = this.fID.bbJ().wm();
                    if (postData3.wm() != null && postData3.wm().getGodUserData() != null) {
                        if (this.fIM != -1) {
                            wm.setFansNum(this.fIM);
                            postData3.wm().setFansNum(this.fIM);
                        }
                        if (this.fIN != -1) {
                            wm.getGodUserData().setIsLike(this.fIN == 1);
                            postData3.wm().getGodUserData().setIsLike(this.fIN == 1);
                            wm.getGodUserData().setIsFromNetWork(false);
                            postData3.wm().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fID.fAC = -1;
                this.fID.fAB = -1;
            }
            if (this.fIJ != null) {
                this.fIJ.a(true, getErrorCode(), i, i5, this.fID, this.mErrorString, 1);
            }
        }
        if (this.fID != null && this.fID.bbJ() != null && this.fID.bbH() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bsQ;
            historyMessage.threadId = getPbData().bbJ().getId();
            if (this.mIsShareThread && getPbData().bbJ().aml != null) {
                historyMessage.threadName = getPbData().bbJ().aml.showText;
            } else {
                historyMessage.threadName = getPbData().bbJ().getTitle();
            }
            if (this.mIsShareThread && !bcE()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().bbH().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = beE();
            historyMessage.threadType = getPbData().bbJ().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String ap;
        if (arrayList != null && dVar.bbL() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(dVar.bbL(), 0);
            if (postData != null && (ap = ap(arrayList)) != null && ap.equals(postData.getId())) {
                dVar.bbL().remove(postData);
            }
            arrayList.addAll(dVar.bbL());
        }
    }

    private int rh(int i) {
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

    private String ap(ArrayList<PostData> arrayList) {
        int y = com.baidu.tbadk.core.util.v.y(arrayList);
        if (y <= 0) {
            return null;
        }
        for (int i = y - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.tieba.pb.data.d dVar) {
        dVar.rI(this.fID.bcc());
        this.fID = dVar;
        re(dVar.vy().vs());
    }

    private void beO() {
        if (this.fID != null && this.fID.bbL() != null && this.fID.bcb() != null) {
            ArrayList<PostData> bbL = this.fID.bbL();
            com.baidu.tieba.pb.data.a bcb = this.fID.bcb();
            int bbF = bcb.bbF();
            if (bbF > 0) {
                if (bbF <= bbL.size()) {
                    bbL.add(bbF, bcb);
                } else {
                    bbL.add(bcb);
                }
            }
        }
    }

    public boolean beP() {
        if (this.fIj == null || this.fIl == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return rf(4);
        }
        return rf(6);
    }

    public boolean kp(boolean z) {
        if (this.fIj == null || this.fID == null) {
            return false;
        }
        if (z || this.fID.vy().vu() != 0) {
            return rf(1);
        }
        return false;
    }

    public boolean kq(boolean z) {
        if (this.fIj == null || this.fID == null) {
            return false;
        }
        if ((z || this.fID.vy().vv() != 0) && this.fID.bbL() != null && this.fID.bbL().size() >= 1) {
            return rf(2);
        }
        return false;
    }

    public boolean rQ(String str) {
        this.fIn = !this.fIn;
        this.fIl = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (rf(6)) {
            return true;
        }
        this.fIn = this.fIn ? false : true;
        return false;
    }

    public boolean q(boolean z, String str) {
        if (this.fIn == z) {
            return false;
        }
        this.fIn = z;
        this.fIl = str;
        if (this.mSortType == 2) {
            this.fIl = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (rf(6)) {
            return true;
        }
        this.fIn = z ? false : true;
        return false;
    }

    public boolean ri(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.fIo = this.fIp;
        this.fIq = this.mSortType;
        this.mSortType = i;
        this.fIp = !this.fIp;
        if (i == 2 && this.isFromMark) {
            this.fIl = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.fIp = this.fIp ? false : true;
            this.mSortType = this.fIq;
            return false;
        }
        return true;
    }

    public boolean beQ() {
        return bfo();
    }

    public int beR() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.fID == null || this.fID.bbH() == null || this.fID.bbJ() == null) ? false : true;
    }

    public boolean sR() {
        if (this.fID == null) {
            return false;
        }
        return this.fID.sR();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hd(String str) {
        if (this.fID == null || this.fID.bbJ() == null || this.fID.bbH() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fID.bbJ().xx()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fID.bbH().getId());
            writeData.setForumName(this.fID.bbH().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.fJj);
        writeData.setThreadId(this.fIj);
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

    public MarkData rj(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fID == null) {
            return null;
        }
        ArrayList<PostData> bbL = this.fID.bbL();
        if (com.baidu.tbadk.core.util.v.z(bbL)) {
            return null;
        }
        if (bbL.size() > 0 && i >= bbL.size()) {
            i = bbL.size() - 1;
        }
        return h(bbL.get(i));
    }

    public MarkData beS() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fIj);
        markData.setPostId(this.fID.sQ());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fIn);
        markData.setSequence(Boolean.valueOf(bfo()));
        markData.setId(this.fIj);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fIj);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fIn);
        markData.setSequence(Boolean.valueOf(bfo()));
        markData.setId(this.fIj);
        markData.setFloor(postData.byM());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void beT() {
        g.ben().K(beU(), this.isFromMark);
    }

    private String beU() {
        String str = this.fIj;
        if (this.fIn) {
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

    public void kr(boolean z) {
        if (this.fID != null) {
            this.fID.an(z);
        }
    }

    public void ks(boolean z) {
        this.fIO = z;
    }

    public boolean beV() {
        return this.fIO;
    }

    public void a(a aVar) {
        this.fIJ = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Je() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Jd() {
        return Ll();
    }

    public boolean rR(String str) {
        if (getPbData() == null || getPbData().bbJ() == null || getPbData().bbJ().wm() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bbJ().wm().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void beW() {
        String beU = beU();
        g.ben().K(beU, false);
        g.ben().K(beU, true);
    }

    public void beX() {
        if ("personalize_page".equals(this.mStType)) {
            this.fIU = System.currentTimeMillis() / 1000;
        }
    }

    public void beY() {
        if ("personalize_page".equals(this.mStType) && this.fID != null && this.fIU != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10754").al(ImageViewerConfig.FORUM_ID, this.fID.getForumId()).al("tid", this.fIj).al("obj_duration", String.valueOf(currentTimeMillis - this.fIU)).al("obj_param3", String.valueOf(currentTimeMillis)));
            this.fIU = 0L;
        }
    }

    public boolean beZ() {
        return this.fIX;
    }

    public int getErrorNo() {
        return this.fIZ;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bfa() {
        return this.fJb;
    }

    public m bfb() {
        return this.fJc;
    }

    public z bfc() {
        return this.fJd;
    }

    public CheckRealNameModel bfd() {
        return this.ciy;
    }

    public AddExperiencedModel bfe() {
        return this.fJf;
    }

    public String bff() {
        return this.fIT;
    }

    public void rS(String str) {
        this.fIT = str;
    }

    public boolean bfg() {
        return this.fIY;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.fID != null && this.fID.bbL() != null && this.fID.bbL().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fID.bbL().size();
                for (int i = 0; i < size; i++) {
                    if (this.fID.bbL().get(i) != null && this.fID.bbL().get(i).wm() != null && currentAccount.equals(this.fID.bbL().get(i).wm().getUserId()) && this.fID.bbL().get(i).wm().getPendantData() != null) {
                        this.fID.bbL().get(i).wm().getPendantData().dB(jVar.uW());
                        this.fID.bbL().get(i).wm().getPendantData().ad(jVar.Ip());
                    }
                }
            }
        }
    }

    public String bfh() {
        return this.fJe;
    }

    public int bfi() {
        return this.fJj;
    }

    public void rk(int i) {
        this.fJj = i;
    }

    public void rT(String str) {
        if ((!this.fIn || rR(TbadkCoreApplication.getCurrentAccount())) && this.fID.bbL() != null) {
            this.fID.vy().bW(1);
            if (this.fID.vy().vu() == 0) {
                this.fID.vy().bW(1);
            }
            this.fJk = str;
            rf(8);
        }
    }

    private void rl(int i) {
        if (i != 8) {
            this.fJk = "";
            if (this.fJl != null) {
                if (i == 1 && !this.fIp && !com.baidu.tbadk.core.util.v.z(getPbData().bbL())) {
                    getPbData().bbL().remove(this.fJl);
                    if (this.fJm != null) {
                        getPbData().bbL().remove(this.fJm);
                    }
                    getPbData().bbL().add(0, this.fJl);
                } else {
                    getPbData().bbL().remove(this.fJl);
                    if (this.fJm != null) {
                        getPbData().bbL().remove(this.fJm);
                    }
                }
            }
            this.fJm = null;
        }
    }

    public void bfj() {
        if (this.fID != null && !com.baidu.tbadk.core.util.v.z(this.fID.bbL())) {
            if (this.fJm != null) {
                this.fID.bbL().remove(this.fJm);
                this.fJm = null;
            }
            if (this.fJl != null) {
                this.fID.bbL().remove(this.fJl);
                this.fJl = null;
            }
        }
    }

    public void bu(int i, int i2) {
        this.fJn = i;
        this.fJo = i2;
    }

    public PostData bfk() {
        return this.fJl;
    }

    public PostData bfl() {
        return this.fJm;
    }

    public int bfm() {
        return this.fJn;
    }

    public String bfn() {
        return this.fJp;
    }

    public void rU(String str) {
        this.fJp = str;
    }

    private boolean bfo() {
        return this.mSortType == 0 || this.mSortType == 2;
    }
}
