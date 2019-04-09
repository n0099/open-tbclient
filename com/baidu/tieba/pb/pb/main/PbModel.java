package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.d;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import tbclient.PbPage.PbSortType;
/* loaded from: classes4.dex */
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
    private BaseActivity cNd;
    private final CheckRealNameModel dKY;
    private com.baidu.tieba.tbadkCore.d.b eDy;
    private int eoa;
    private long fqo;
    private boolean gzn;
    protected String hrH;
    private String hrI;
    private String hrJ;
    private String hrK;
    private boolean hrL;
    private boolean hrM;
    private boolean hrN;
    private boolean hrO;
    private int hrP;
    private boolean hrQ;
    private int hrR;
    private long hrS;
    private int hrT;
    private int hrU;
    private int hrV;
    private boolean hrW;
    private boolean hrX;
    private boolean hrY;
    private boolean hrZ;
    private final x hsA;
    private final h hsB;
    private final m hsC;
    private final z hsD;
    private String hsE;
    private final AddExperiencedModel hsF;
    private SuggestEmotionModel hsG;
    private GetSugMatchWordsModel hsH;
    private boolean hsI;
    private int hsJ;
    private String hsK;
    private PostData hsL;
    private PostData hsM;
    private int hsN;
    private int hsO;
    private String hsP;
    private com.baidu.tieba.tbadkCore.data.m hsQ;
    private CustomMessageListener hsR;
    private CustomMessageListener hsS;
    private com.baidu.adp.framework.listener.a hsT;
    private PraiseData hsU;
    private long hsa;
    private boolean hsb;
    private String hsc;
    protected com.baidu.tieba.pb.data.d hsd;
    private int hse;
    private boolean hsf;
    private boolean hsg;
    private boolean hsh;
    private boolean hsi;
    private a hsj;
    private String hsk;
    private String hsl;
    private int hsm;
    private int hsn;
    private boolean hso;
    private boolean hsp;
    private boolean hsq;
    private boolean hsr;
    private boolean hss;
    private String hst;
    private long hsu;
    private boolean hsv;
    private int hsw;
    private boolean hsx;
    private boolean hsy;
    private int hsz;
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
    private static final int hrG = com.baidu.tbadk.data.d.alk() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.d dVar);
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.hrH = null;
        this.hrI = null;
        this.hrJ = null;
        this.mForumId = null;
        this.hrK = null;
        this.hrL = false;
        this.hrM = false;
        this.hrN = true;
        this.hrO = true;
        this.mSortType = 0;
        this.hrP = 0;
        this.hrQ = false;
        this.mIsGood = 0;
        this.hrR = 0;
        this.hrS = 0L;
        this.hrT = 1;
        this.hrU = 1;
        this.hrV = 1;
        this.eoa = 1;
        this.isAd = false;
        this.gzn = false;
        this.hrW = false;
        this.hrX = false;
        this.isFromMark = false;
        this.hrY = false;
        this.hrZ = false;
        this.hsa = 0L;
        this.hsb = false;
        this.hsc = null;
        this.hsd = null;
        this.isLoading = false;
        this.hsf = false;
        this.hsg = false;
        this.hsh = false;
        this.hsi = false;
        this.mLocate = null;
        this.mContext = null;
        this.hsj = null;
        this.opType = null;
        this.opUrl = null;
        this.hsk = null;
        this.hsl = null;
        this.hsm = -1;
        this.hsn = -1;
        this.eDy = null;
        this.hsp = false;
        this.hsq = false;
        this.postID = null;
        this.hst = null;
        this.hsu = 0L;
        this.hsv = false;
        this.hsw = -1;
        this.hsy = false;
        this.hsI = false;
        this.hsJ = 0;
        this.hsR = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.hss = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.bHW() != null) {
                        pbData.bHW().gp(0);
                    }
                    if (PbModel.this.hsj != null && pbData != null) {
                        com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.hsj.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.hsS = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().getForum() != null && PbModel.this.getPbData().getForum().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().getForum().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.hsT = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.kY()) {
                        PbModel.this.cNd.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.hsp || !PbModel.this.hsq) {
                        if (!PbModel.this.hsp) {
                            PbModel.this.hsp = true;
                        } else {
                            PbModel.this.hsq = true;
                        }
                        if (PbModel.this.hsj != null) {
                            PbModel.this.hsj.a(PbModel.this.bKL(), z, responsedMessage, PbModel.this.hsr, System.currentTimeMillis() - PbModel.this.fqo);
                        }
                    }
                }
            }
        };
        this.hsU = null;
        registerListener(this.hsR);
        registerListener(this.hsT);
        registerListener(this.hsS);
        this.hsd = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.cNd = baseActivity;
        this.hsA = new x(this, this.cNd);
        this.hsB = new h(this, this.cNd);
        this.hsC = new m(this, this.cNd);
        this.hsD = new z(this, this.cNd);
        this.dKY = new CheckRealNameModel(this.cNd.getPageContext());
        this.hsG = new SuggestEmotionModel();
        this.hsF = new AddExperiencedModel(this.cNd.getPageContext());
    }

    protected int bKL() {
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
        if (intent != null) {
            this.hrH = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.m(data)) {
                com.baidu.tbadk.BdToken.f.Ui().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.brN) instanceof String)) {
                            PbModel.this.hrH = (String) hashMap.get(com.baidu.tbadk.BdToken.f.brN);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.hrH)) {
                this.hrH = this.hsA.ap(intent);
                if (StringUtils.isNull(this.hrH) && intent.getData() != null) {
                    this.hrH = data.getQueryParameter("thread_id");
                }
            }
            this.hsJ = intent.getIntExtra("key_start_from", 0);
            if (this.hsJ == 0) {
                this.hsJ = this.hsA.hta;
            }
            this.hrJ = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.hrI = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.hrL = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.hrM = intent.getBooleanExtra("host_only", false);
            this.hrO = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.apJ().afK() ? 2 : 0);
            if (this.mSortType == 2) {
                this.hrJ = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.hrR = intent.getIntExtra("is_top", 0);
            this.hrS = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.hrY = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.hrZ = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.gzn = intent.getBooleanExtra("is_sub_pb", false);
            this.hsb = intent.getBooleanExtra("is_pv", false);
            this.hsa = intent.getLongExtra("msg_id", 0L);
            this.hsc = intent.getStringExtra("from_forum_name");
            this.hsl = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.hsk = intent.getStringExtra("op_stat");
            this.hsf = intent.getBooleanExtra("is_from_thread_config", false);
            this.hsg = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.hsh = intent.getBooleanExtra("is_from_my_god_config", false);
            this.hsn = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.hsm = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.hrW = intent.getBooleanExtra("from_frs", false);
            this.hrX = intent.getBooleanExtra("from_maintab", false);
            this.hsy = intent.getBooleanExtra("from_smart_frs", false);
            this.hsi = intent.getBooleanExtra("from_hottopic", false);
            this.hsE = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.hrK = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.hsJ = bundle.getInt("key_start_from", 0);
        this.hrH = bundle.getString("thread_id");
        this.hrJ = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.hrI = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.hrL = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.hrM = bundle.getBoolean("host_only", false);
        this.hrO = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.hrR = bundle.getInt("is_top", 0);
        this.hrS = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.hrZ = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.gzn = bundle.getBoolean("is_sub_pb", false);
        this.hsb = bundle.getBoolean("is_pv", false);
        this.hsa = bundle.getLong("msg_id", 0L);
        this.hsc = bundle.getString("from_forum_name");
        this.hsl = bundle.getString("extra_pb_cache_key");
        this.hsf = bundle.getBoolean("is_from_thread_config", false);
        this.hsg = bundle.getBoolean("is_from_interview_live_config", false);
        this.hsh = bundle.getBoolean("is_from_my_god_config", false);
        this.hsn = bundle.getInt("extra_pb_is_attention_key", -1);
        this.hsm = bundle.getInt("extra_pb_funs_count_key", -1);
        this.hrW = bundle.getBoolean("from_frs", false);
        this.hrX = bundle.getBoolean("from_maintab", false);
        this.hsy = bundle.getBoolean("from_smart_frs", false);
        this.hsi = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.hrK = bundle.getString("high_light_post_id");
    }

    public void aa(Bundle bundle) {
        bundle.putString("thread_id", this.hrH);
        bundle.putString("post_id", this.hrJ);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.hsJ);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.hrL);
        bundle.putBoolean("host_only", this.hrM);
        bundle.putBoolean("squence", this.hrO);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.hrR);
        bundle.putLong("thread_time", this.hrS);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.hrZ);
        bundle.putBoolean("is_sub_pb", this.gzn);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.hsb);
        bundle.putLong("msg_id", this.hsa);
        bundle.putString("extra_pb_cache_key", this.hsl);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.hsf);
        bundle.putBoolean("is_from_interview_live_config", this.hsg);
        bundle.putBoolean("is_from_my_god_config", this.hsh);
        bundle.putInt("extra_pb_is_attention_key", this.hsn);
        bundle.putInt("extra_pb_funs_count_key", this.hsm);
        bundle.putBoolean("from_frs", this.hrW);
        bundle.putBoolean("from_maintab", this.hrX);
        bundle.putBoolean("from_smart_frs", this.hsy);
        bundle.putBoolean("from_hottopic", this.hsi);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.hrK);
    }

    public String bKM() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.hrH);
        if (!this.hrZ) {
            sb.append(this.hrJ);
        }
        sb.append(this.hrM);
        sb.append(this.hrO);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.hrR);
        sb.append(this.hrS);
        sb.append(this.hrW);
        sb.append(this.hrX);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.gzn);
        sb.append(this.hsb);
        sb.append(this.hsa);
        sb.append(this.hsc);
        sb.append(this.mThreadType);
        sb.append(this.hsf);
        sb.append(this.hsg);
        sb.append(this.hsh);
        if (this.hsl != null) {
            sb.append(this.hsl);
        }
        return sb.toString();
    }

    public String bIO() {
        return this.hsc;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.hrJ;
    }

    public String bKN() {
        return this.hrK;
    }

    public String bKO() {
        return this.hrH;
    }

    public boolean getHostMode() {
        return this.hrM;
    }

    public boolean bKP() {
        return bLC();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bKQ() {
        return this.hrW;
    }

    public boolean bKR() {
        return this.hrQ;
    }

    public boolean bKS() {
        return this.hrX;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bKT() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aWi() {
        return this.hrR;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void oA(int i) {
        this.hrR = i;
    }

    public boolean bKU() {
        return this.gzn;
    }

    public boolean bKV() {
        if (this.hsd == null) {
            return false;
        }
        return this.hsd.isValid();
    }

    public String YX() {
        if (this.hsd == null || !this.hsd.UY()) {
            return null;
        }
        return this.hsd.UX();
    }

    public boolean wj(int i) {
        this.hrT = i;
        if (this.hrT > this.hsd.getPage().XC()) {
            this.hrT = this.hsd.getPage().XC();
        }
        if (this.hrT < 1) {
            this.hrT = 1;
        }
        if (this.hrH == null) {
            return false;
        }
        return wl(5);
    }

    public void wk(int i) {
        this.hrT = i;
        this.hrU = i;
        this.hrV = i;
    }

    public void b(com.baidu.tbadk.core.data.an anVar) {
        if (anVar == null) {
            wk(1);
            return;
        }
        if (this.hrU < anVar.XF()) {
            this.hrU = anVar.XF();
        }
        if (this.hrV > anVar.XF()) {
            this.hrV = anVar.XF();
        }
        this.eoa = anVar.XC();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.hsd;
    }

    public com.baidu.tieba.pb.data.d bKW() {
        if (this.hsd == null) {
            return this.hsd;
        }
        if (!bKX() && this.hsQ != null) {
            this.hsd.b(this.hsQ);
        }
        return this.hsd;
    }

    private boolean bKX() {
        return (this.hsd.bIl() == null || this.hsd.bIl().ced() == null || this.hsd.bIl().ced().goods != null || this.hsd.bIl().ced().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.an getPageData() {
        if (this.hsd == null) {
            return null;
        }
        return this.hsd.getPage();
    }

    public boolean bKY() {
        if (bLC() && this.hsd.getPage().XH() == 0) {
            ny(true);
            return true;
        }
        return false;
    }

    public void zJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.hrH = str;
            this.hrJ = null;
            this.hrM = false;
            this.hrO = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hrH == null) {
            return false;
        }
        cancelLoadData();
        if (this.eDy == null) {
            this.eDy = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.eDy.start();
        }
        boolean wl = wl(3);
        if (this.opType != null) {
            this.opType = null;
            this.hsk = null;
            this.opUrl = null;
            return wl;
        }
        return wl;
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
        if (this.hsG != null) {
            this.hsG.cancelLoadData();
        }
        if (this.hsH != null) {
            this.hsH.cancelLoadData();
        }
        aWW();
    }

    private void aWW() {
        if (this.eDy != null) {
            this.eDy.destory();
            this.eDy = null;
        }
    }

    public boolean aor() {
        return (this.hrJ == null || this.hrJ.equals("0") || this.hrJ.length() == 0) ? LoadData() : bLd();
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
                this.hsG.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.hsG.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.hsH == null) {
                this.hsH = new GetSugMatchWordsModel(this.cNd.getPageContext());
            }
            this.hsH.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0311 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0319 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0328 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x035e A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x036d A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0392 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:111:0x0313, B:139:0x0389, B:114:0x0319, B:116:0x031f, B:117:0x0324, B:119:0x0328, B:121:0x0332, B:126:0x0349, B:128:0x0357, B:129:0x035a, B:131:0x035e, B:132:0x0369, B:134:0x036d, B:136:0x0375, B:138:0x0384, B:140:0x038e, B:142:0x0392, B:123:0x0336, B:143:0x039b, B:144:0x03c9, B:146:0x03cd, B:156:0x03fe, B:149:0x03d9, B:151:0x03e7, B:152:0x03ef, B:154:0x03f3, B:155:0x03f9, B:157:0x0407, B:159:0x0413, B:148:0x03d1, B:160:0x041d, B:162:0x0429, B:164:0x042d, B:166:0x0431, B:167:0x0436, B:169:0x0442, B:170:0x044a, B:174:0x0464, B:171:0x044f, B:173:0x045e, B:175:0x046d, B:177:0x047c, B:38:0x00ce), top: B:181:0x00c2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean wl(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        wm(i);
        final com.baidu.tieba.pb.data.d pbData = aj.bLX().getPbData();
        if (pbData != null && pbData.bHW() != null) {
            pbData.bHW().gp(0);
            this.hrO = aj.bLX().bKP();
            this.hrM = aj.bLX().bMc();
            this.hrQ = aj.bLX().bMd();
            this.hsL = aj.bLX().bMb();
            this.hsM = aj.bLX().bMa();
            this.hsN = aj.bLX().bLZ();
            this.hsI = this.hrM;
            if (this.hrM || this.isFromMark) {
                this.hso = false;
            }
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.5
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.hss) {
            a(bLi(), true, this.hrJ, 3);
        }
        if (i == 3 && !this.hss) {
            if (this.isFromMark) {
                a(bLi(), true, this.hrJ, 3);
            } else {
                a(bLi(), false, this.hrJ, 3);
            }
        }
        this.hss = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.hsQ == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.chH);
        if (this.hrM || this.isFromMark) {
            this.hso = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.hrH == null || this.hrH.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.hrH, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.ar.adm().ado() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(aO));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aQ));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.hrO) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.hrM) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.hsb) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.hsa));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.hso) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.l(this.hsk, 0));
            pbPageRequestMessage.setOpMessageID(this.hsa);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bHY = this.hsd.bHY();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hrV - 1));
                        if (this.hrV - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.hrY) {
                                if (bHY != null && bHY.size() > 0) {
                                    size = bHY.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bHY.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.hrJ = postData.getId();
                                            if (StringUtils.isNull(this.hrJ)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.hrU + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.hrJ == null && this.hrJ.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hrJ, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hrU + 1));
                        if (this.hrU >= this.eoa) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bHY != null) {
                                size = bHY.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.hrJ == null) {
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
                if (bHY != null) {
                }
                if (this.hrJ == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bHY != null && bHY.size() > 0 && bHY.get(0) != null) {
                    this.hrJ = bHY.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bLC()) {
                        if (this.hrV - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.hrV - 1));
                        }
                    } else if (this.hrU < this.eoa) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hrU + 1));
                    }
                }
                if (this.hrJ != null && this.hrJ.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hrJ, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.hrM) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bLC()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.eoa > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eoa));
                    }
                }
                if (this.isFromMark) {
                    pbPageRequestMessage.set_st_type("store_thread");
                }
                a(pbPageRequestMessage);
                break;
            case 4:
                pbPageRequestMessage.set_st_type("store_thread");
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hrJ, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.hrT));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.hsI && !this.hrM) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hrJ, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.hrM) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.hsw);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hsK, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.hsI = this.hrM;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bLi());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.hsJ));
        pbPageRequestMessage.setIsSubPostDataReverse(this.hsv);
        pbPageRequestMessage.setFromSmartFrs(this.hsy ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.hrL);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.hrH);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bIN() {
        switch (bLw()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bHW() == null || !getPbData().bHW().aag();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bIO()) && com.baidu.tieba.recapp.r.bWF().bWz() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bWF().bWz().ar(bIO(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bWF().bWz().as(bIO(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bIO()) && com.baidu.tieba.recapp.r.bWF().bWz() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bWF().bWz().as(bIO(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bWF().bWz().ar(bIO(), true));
        }
    }

    protected void wm(int i) {
        boolean z = false;
        wr(i);
        ArrayList<PostData> bHY = this.hsd.bHY();
        this.hsr = false;
        if (i == 1) {
            boolean z2 = false;
            while (bHY.size() + 30 > com.baidu.tbadk.data.d.alk()) {
                bHY.remove(0);
                z2 = true;
            }
            if (z2) {
                this.hsd.getPage().gm(1);
                if (this.hsj != null) {
                    this.hsj.f(this.hsd);
                }
            }
            this.fqo = System.currentTimeMillis();
            this.hsr = true;
        } else if (i == 2) {
            while (bHY.size() + 30 > com.baidu.tbadk.data.d.alk()) {
                bHY.remove(bHY.size() - 1);
                z = true;
            }
            if (z) {
                this.hsd.getPage().gl(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.hsz = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
        }
        h(dVar2);
        if (this.hsQ != null && this.hsQ.axr()) {
            TiebaStatic.log(com.baidu.tieba.q.a.b("a005", "common_fill", true, 1));
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bIl() != null && dVar.bIl().ced() != null && dVar.bIl().ced().goods != null && dVar.bIl().axr() && dVar.bIl().ced().goods.goods_style != 1001) {
            this.hsQ = dVar.bIl();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m bKZ() {
        return this.hsQ;
    }

    public void bLa() {
        this.hsQ = null;
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
            if (this.hsh || this.hsf || this.hsg) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.bHY().size(); i++) {
                PostData postData = dVar.bHY().get(i);
                for (int i2 = 0; i2 < postData.cem().size(); i2++) {
                    postData.cem().get(i2).a(this.cNd.getPageContext(), l.equals(postData.cem().get(i2).YO().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.k bIh = dVar.bIh();
            if (bIh != null && !com.baidu.tbadk.core.util.v.T(bIh.hkK)) {
                for (PostData postData2 : bIh.hkK) {
                    for (int i3 = 0; i3 < postData2.cem().size(); i3++) {
                        postData2.cem().get(i3).a(this.cNd.getPageContext(), l.equals(postData2.cem().get(i3).YO().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.k bIh = dVar.bIh();
            if (bIh != null && !com.baidu.tbadk.core.util.v.T(bIh.hkK)) {
                for (PostData postData : bIh.hkK.subList(i, bIh.hkK.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cem().size()) {
                            postData.cem().get(i3).a(this.cNd.getPageContext(), l.equals(postData.cem().get(i3).YO().getUserId()));
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
        bg bHW = dVar.bHW();
        bHW.gt(this.mIsGood);
        bHW.gs(this.hrR);
        if (this.hrS > 0) {
            bHW.ae(this.hrS);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bHW() != null && dVar.bHW().YO() != null) {
            str = dVar.bHW().YO().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bLb() {
        if (this.hsd == null || this.hsd.bHW() == null || this.hsd.bHW().YO() == null) {
            return null;
        }
        return this.hsd.bHW().YO();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.hsx = z3;
        this.hse = i;
        if (this.eDy != null && !z3) {
            this.eDy.a(z2, z4, i2, str, i3, j, j2);
            this.eDy = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bIO()) && com.baidu.tieba.recapp.r.bWF().bWz() != null) {
            com.baidu.tieba.recapp.r.bWF().bWz().g(bIO(), wn(getRequestType()), true);
        }
        if (dVar == null || (this.hrT == 1 && i == 5 && dVar.bHY() != null && dVar.bHY().size() < 1)) {
            if (this.hsj != null) {
                this.hrO = this.hrN;
                if (i2 != 350006) {
                    this.mSortType = this.hrP;
                }
                this.hsj.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.hrN = this.hrO;
            if (i != 8) {
                this.hrP = this.mSortType;
                this.mSortType = dVar.hkk;
            }
            if (dVar.hkj != null && dVar.hkj.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.cNd.getResources().getString(d.j.default_sort);
                builder.sort_type = 0;
                dVar.hkj = new ArrayList();
                dVar.hkj.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.cNd.getResources().getString(d.j.view_reverse);
                builder2.sort_type = 1;
                dVar.hkj.add(builder2.build(false));
                this.mSortType = this.hrP;
                dVar.hkk = this.mSortType;
            }
            this.hsb = false;
            if (dVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(dVar.getPage());
            }
            this.eoa = this.eoa < 1 ? 1 : this.eoa;
            ArrayList<PostData> bHY = this.hsd.bHY();
            switch (i) {
                case 1:
                    this.hsd.a(dVar.getPage(), 1);
                    d(dVar, bHY);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bHY() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bHY().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bHY, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bHY(), com.baidu.tbadk.core.util.v.S(dVar.bHY()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bHY().remove(postData2);
                            i6 = size - 1;
                        }
                        bHY.addAll(0, dVar.bHY());
                    }
                    this.hsd.a(dVar.getPage(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.getPage() != null) {
                        dVar.getPage().gj(dVar.getPage().XC());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && bLC()) {
                        bLc();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.T(dVar.bHY()) && this.hsd != null && (!this.hrM || l(dVar).equals(dVar.bHY().get(0).YO().getUserId()))) {
                        if (this.hsd.getPage().XH() == 0) {
                            this.hsd.getPage().gl(1);
                        }
                        bLx();
                        this.hsL = dVar.bHY().get(0);
                        if (bLC()) {
                            if (this.hsd.bHY().size() - this.hsN >= 3) {
                                this.hsM = new PostData();
                                this.hsM.iGm = true;
                                this.hsM.setPostType(53);
                                this.hsd.bHY().add(this.hsM);
                            }
                            this.hsd.bHY().add(this.hsL);
                            i4 = this.hsd.bHY().size() - 1;
                        } else {
                            if (this.hsN - this.hsO >= 3) {
                                this.hsM = new PostData();
                                this.hsM.iGm = false;
                                this.hsM.setPostType(53);
                                this.hsd.bHY().add(0, this.hsM);
                            }
                            this.hsd.bHY().add(0, this.hsL);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ap.aM(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.hsL.iGy = this.hsd.bIv();
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
            if (this.hsd != null && this.hsd.bHW() != null) {
                PraiseData YA = this.hsd.bHW().YA();
                if (this.hsU != null && !YA.isPriaseDataValid()) {
                    this.hsd.bHW().a(this.hsU);
                } else {
                    this.hsU = this.hsd.bHW().YA();
                    this.hsU.setPostId(this.hsd.bHW().Ze());
                }
                if (dVar.getPage() != null && dVar.getPage().XF() == 1 && dVar.bHW() != null && dVar.bHW().YZ() != null && dVar.bHW().YZ().size() > 0) {
                    this.hsd.bHW().n(dVar.bHW().YZ());
                }
                this.hsd.bHW().gq(dVar.bHW().YF());
                this.hsd.bHW().gn(dVar.bHW().getAnchorLevel());
                this.hsd.bHW().gp(dVar.bHW().Yw());
                if (this.mThreadType == 33) {
                    this.hsd.bHW().YO().setHadConcerned(dVar.bHW().YO().hadConcerned());
                }
                if (dVar != null && dVar.bHW() != null) {
                    this.hsd.bHW().gv(dVar.bHW().Zd());
                }
            }
            if (this.hsd != null && this.hsd.getUserData() != null && dVar.getUserData() != null) {
                this.hsd.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.hsd.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.getPage() != null && dVar.getPage().XF() == 1 && dVar.bIg() != null) {
                this.hsd.d(dVar.bIg());
            }
            if (this.hsx) {
                if (this.hsd.bHW() != null && this.hsd.bHW().YO() != null && this.hsd.bHY() != null && com.baidu.tbadk.core.util.v.c(this.hsd.bHY(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.hsd.bHY(), 0);
                    MetaData YO = this.hsd.bHW().YO();
                    if (postData3.YO() != null && postData3.YO().getGodUserData() != null) {
                        if (this.hsm != -1) {
                            YO.setFansNum(this.hsm);
                            postData3.YO().setFansNum(this.hsm);
                        }
                        if (this.hsn != -1) {
                            YO.getGodUserData().setIsLike(this.hsn == 1);
                            postData3.YO().getGodUserData().setIsLike(this.hsn == 1);
                            YO.getGodUserData().setIsFromNetWork(false);
                            postData3.YO().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.hsd.hki = -1;
                this.hsd.hkh = -1;
            }
            if (this.hsj != null) {
                this.hsj.a(true, getErrorCode(), i, i5, this.hsd, this.mErrorString, 1);
            }
        }
        if (this.hsd != null && this.hsd.bHW() != null && this.hsd.getForum() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.cNd.getPageContext();
            historyMessage.threadId = getPbData().bHW().getId();
            if (this.mIsShareThread && getPbData().bHW().bDz != null) {
                historyMessage.threadName = getPbData().bHW().bDz.showText;
            } else {
                historyMessage.threadName = getPbData().bHW().getTitle();
            }
            if (this.mIsShareThread && !bIN()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bKP();
            historyMessage.threadType = getPbData().bHW().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String as;
        if (arrayList != null && dVar.bHY() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bHY(), 0);
            if (postData != null && (as = as(arrayList)) != null && as.equals(postData.getId())) {
                dVar.bHY().remove(postData);
            }
            arrayList.addAll(dVar.bHY());
        }
    }

    private int wn(int i) {
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

    private String as(ArrayList<PostData> arrayList) {
        int S = com.baidu.tbadk.core.util.v.S(arrayList);
        if (S <= 0) {
            return null;
        }
        for (int i = S - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.tieba.pb.data.d dVar) {
        dVar.zG(this.hsd.bIo());
        this.hsd = dVar;
        wk(dVar.getPage().XF());
    }

    private void bLc() {
        if (this.hsd != null && this.hsd.bHY() != null && this.hsd.bIn() != null) {
            ArrayList<PostData> bHY = this.hsd.bHY();
            com.baidu.tieba.pb.data.a bIn = this.hsd.bIn();
            int bHT = bIn.bHT();
            if (bHT > 0) {
                if (bHT <= bHY.size()) {
                    bHY.add(bHT, bIn);
                } else {
                    bHY.add(bIn);
                }
            }
        }
    }

    public boolean bLd() {
        if (this.hrH == null || this.hrJ == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return wl(4);
        }
        return wl(6);
    }

    public boolean ny(boolean z) {
        if (this.hrH == null || this.hsd == null) {
            return false;
        }
        if (z || this.hsd.getPage().XH() != 0) {
            return wl(1);
        }
        return false;
    }

    public boolean nz(boolean z) {
        if (this.hrH == null || this.hsd == null) {
            return false;
        }
        if ((z || this.hsd.getPage().XI() != 0) && this.hsd.bHY() != null && this.hsd.bHY().size() >= 1) {
            return wl(2);
        }
        return false;
    }

    public boolean zP(String str) {
        this.hrM = !this.hrM;
        this.hrJ = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (wl(6)) {
            return true;
        }
        this.hrM = this.hrM ? false : true;
        return false;
    }

    public boolean u(boolean z, String str) {
        if (this.hrM == z) {
            return false;
        }
        this.hrM = z;
        this.hrJ = str;
        if (this.mSortType == 2) {
            this.hrJ = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (wl(6)) {
            return true;
        }
        this.hrM = z ? false : true;
        return false;
    }

    public boolean wo(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.hrN = this.hrO;
        this.hrP = this.mSortType;
        this.mSortType = i;
        this.hrO = !this.hrO;
        if (i == 2 && this.isFromMark) {
            this.hrJ = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.hrO = this.hrO ? false : true;
            this.mSortType = this.hrP;
            return false;
        }
        return true;
    }

    public boolean bLe() {
        return bLC();
    }

    public int bLf() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.hsd == null || this.hsd.getForum() == null || this.hsd.bHW() == null) ? false : true;
    }

    public boolean UY() {
        if (this.hsd == null) {
            return false;
        }
        return this.hsd.UY();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oO(String str) {
        if (this.hsd == null || this.hsd.bHW() == null || this.hsd.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.hsd.bHW().aag()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.hsd.getForum().getId());
            writeData.setForumName(this.hsd.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.hsJ);
        writeData.setThreadId(this.hrH);
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

    public MarkData wp(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.hsd == null) {
            return null;
        }
        ArrayList<PostData> bHY = this.hsd.bHY();
        if (com.baidu.tbadk.core.util.v.T(bHY)) {
            return null;
        }
        if (bHY.size() > 0 && i >= bHY.size()) {
            i = bHY.size() - 1;
        }
        return j(bHY.get(i));
    }

    public MarkData bLg() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hrH);
        markData.setPostId(this.hsd.UX());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hrM);
        markData.setSequence(Boolean.valueOf(bLC()));
        markData.setId(this.hrH);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hrH);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hrM);
        markData.setSequence(Boolean.valueOf(bLC()));
        markData.setId(this.hrH);
        markData.setFloor(postData.cep());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void bLh() {
        g.bKy().am(bLi(), this.isFromMark);
    }

    private String bLi() {
        String str = this.hrH;
        if (this.hrM) {
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

    public void nA(boolean z) {
        if (this.hsd != null) {
            this.hsd.cZ(z);
        }
    }

    public void nB(boolean z) {
        this.hso = z;
    }

    public boolean bLj() {
        return this.hso;
    }

    public void a(a aVar) {
        this.hsj = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aml() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean amk() {
        return aor();
    }

    public boolean zQ(String str) {
        if (getPbData() == null || getPbData().bHW() == null || getPbData().bHW().YO() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bHW().YO().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bLk() {
        String bLi = bLi();
        g.bKy().am(bLi, false);
        g.bKy().am(bLi, true);
    }

    public void bLl() {
        if ("personalize_page".equals(this.mStType)) {
            this.hsu = System.currentTimeMillis() / 1000;
        }
    }

    public void bLm() {
        if ("personalize_page".equals(this.mStType) && this.hsd != null && this.hsu != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10754").bJ(ImageViewerConfig.FORUM_ID, this.hsd.getForumId()).bJ("tid", this.hrH).bJ("obj_duration", String.valueOf(currentTimeMillis - this.hsu)).bJ("obj_param3", String.valueOf(currentTimeMillis)));
            this.hsu = 0L;
        }
    }

    public boolean bLn() {
        return this.hsx;
    }

    public int getErrorNo() {
        return this.hsz;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bLo() {
        return this.hsB;
    }

    public m bLp() {
        return this.hsC;
    }

    public z bLq() {
        return this.hsD;
    }

    public CheckRealNameModel bLr() {
        return this.dKY;
    }

    public AddExperiencedModel bLs() {
        return this.hsF;
    }

    public String bLt() {
        return this.hst;
    }

    public void zR(String str) {
        this.hst = str;
    }

    public boolean bLu() {
        return this.hsy;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hsd != null && this.hsd.bHY() != null && this.hsd.bHY().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hsd.bHY().size();
                for (int i = 0; i < size; i++) {
                    if (this.hsd.bHY().get(i) != null && this.hsd.bHY().get(i).YO() != null && currentAccount.equals(this.hsd.bHY().get(i).YO().getUserId()) && this.hsd.bHY().get(i).YO().getPendantData() != null) {
                        this.hsd.bHY().get(i).YO().getPendantData().lg(lVar.Xk());
                        this.hsd.bHY().get(i).YO().getPendantData().aR(lVar.alu());
                    }
                }
            }
        }
    }

    public String bLv() {
        return this.hsE;
    }

    public int bLw() {
        return this.hsJ;
    }

    public void wq(int i) {
        this.hsJ = i;
    }

    public void zS(String str) {
        if ((!this.hrM || zQ(TbadkCoreApplication.getCurrentAccount())) && this.hsd.bHY() != null) {
            this.hsd.getPage().gl(1);
            if (this.hsd.getPage().XH() == 0) {
                this.hsd.getPage().gl(1);
            }
            this.hsK = str;
            wl(8);
        }
    }

    private void wr(int i) {
        if (i != 8) {
            this.hsK = "";
            if (this.hsL != null) {
                if (i == 1 && !this.hrO && !com.baidu.tbadk.core.util.v.T(getPbData().bHY())) {
                    getPbData().bHY().remove(this.hsL);
                    if (this.hsM != null) {
                        getPbData().bHY().remove(this.hsM);
                    }
                    getPbData().bHY().add(0, this.hsL);
                } else {
                    getPbData().bHY().remove(this.hsL);
                    if (this.hsM != null) {
                        getPbData().bHY().remove(this.hsM);
                    }
                }
            }
            this.hsM = null;
        }
    }

    public void bLx() {
        if (this.hsd != null && !com.baidu.tbadk.core.util.v.T(this.hsd.bHY())) {
            if (this.hsM != null) {
                this.hsd.bHY().remove(this.hsM);
                this.hsM = null;
            }
            if (this.hsL != null) {
                this.hsd.bHY().remove(this.hsL);
                this.hsL = null;
            }
        }
    }

    public void bU(int i, int i2) {
        this.hsN = i;
        this.hsO = i2;
    }

    public PostData bLy() {
        return this.hsL;
    }

    public PostData bLz() {
        return this.hsM;
    }

    public int bLA() {
        return this.hsN;
    }

    public String bLB() {
        return this.hsP;
    }

    public void zT(String str) {
        this.hsP = str;
    }

    private boolean bLC() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean bLD() {
        return this.hsJ == 13 || this.hsJ == 12;
    }
}
