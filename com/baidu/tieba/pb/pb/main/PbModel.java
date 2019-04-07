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
    private BaseActivity cNc;
    private final CheckRealNameModel dKX;
    private com.baidu.tieba.tbadkCore.d.b eDx;
    private int enZ;
    private long fqo;
    private boolean gzm;
    protected String hrG;
    private String hrH;
    private String hrI;
    private String hrJ;
    private boolean hrK;
    private boolean hrL;
    private boolean hrM;
    private boolean hrN;
    private int hrO;
    private boolean hrP;
    private int hrQ;
    private long hrR;
    private int hrS;
    private int hrT;
    private int hrU;
    private boolean hrV;
    private boolean hrW;
    private boolean hrX;
    private boolean hrY;
    private long hrZ;
    private final h hsA;
    private final m hsB;
    private final z hsC;
    private String hsD;
    private final AddExperiencedModel hsE;
    private SuggestEmotionModel hsF;
    private GetSugMatchWordsModel hsG;
    private boolean hsH;
    private int hsI;
    private String hsJ;
    private PostData hsK;
    private PostData hsL;
    private int hsM;
    private int hsN;
    private String hsO;
    private com.baidu.tieba.tbadkCore.data.m hsP;
    private CustomMessageListener hsQ;
    private CustomMessageListener hsR;
    private com.baidu.adp.framework.listener.a hsS;
    private PraiseData hsT;
    private boolean hsa;
    private String hsb;
    protected com.baidu.tieba.pb.data.d hsc;
    private int hsd;
    private boolean hse;
    private boolean hsf;
    private boolean hsg;
    private boolean hsh;
    private a hsi;
    private String hsj;
    private String hsk;
    private int hsl;
    private int hsm;
    private boolean hsn;
    private boolean hso;
    private boolean hsp;
    private boolean hsq;
    private boolean hsr;
    private String hss;
    private long hst;
    private boolean hsu;
    private int hsv;
    private boolean hsw;
    private boolean hsx;
    private int hsy;
    private final x hsz;
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
    private static final int hrF = com.baidu.tbadk.data.d.alk() / 30;
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
        this.hrG = null;
        this.hrH = null;
        this.hrI = null;
        this.mForumId = null;
        this.hrJ = null;
        this.hrK = false;
        this.hrL = false;
        this.hrM = true;
        this.hrN = true;
        this.mSortType = 0;
        this.hrO = 0;
        this.hrP = false;
        this.mIsGood = 0;
        this.hrQ = 0;
        this.hrR = 0L;
        this.hrS = 1;
        this.hrT = 1;
        this.hrU = 1;
        this.enZ = 1;
        this.isAd = false;
        this.gzm = false;
        this.hrV = false;
        this.hrW = false;
        this.isFromMark = false;
        this.hrX = false;
        this.hrY = false;
        this.hrZ = 0L;
        this.hsa = false;
        this.hsb = null;
        this.hsc = null;
        this.isLoading = false;
        this.hse = false;
        this.hsf = false;
        this.hsg = false;
        this.hsh = false;
        this.mLocate = null;
        this.mContext = null;
        this.hsi = null;
        this.opType = null;
        this.opUrl = null;
        this.hsj = null;
        this.hsk = null;
        this.hsl = -1;
        this.hsm = -1;
        this.eDx = null;
        this.hso = false;
        this.hsp = false;
        this.postID = null;
        this.hss = null;
        this.hst = 0L;
        this.hsu = false;
        this.hsv = -1;
        this.hsx = false;
        this.hsH = false;
        this.hsI = 0;
        this.hsQ = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.hsr = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.bHW() != null) {
                        pbData.bHW().gp(0);
                    }
                    if (PbModel.this.hsi != null && pbData != null) {
                        com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.hsi.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.hsR = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.hsS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.kY()) {
                        PbModel.this.cNc.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.hso || !PbModel.this.hsp) {
                        if (!PbModel.this.hso) {
                            PbModel.this.hso = true;
                        } else {
                            PbModel.this.hsp = true;
                        }
                        if (PbModel.this.hsi != null) {
                            PbModel.this.hsi.a(PbModel.this.bKL(), z, responsedMessage, PbModel.this.hsq, System.currentTimeMillis() - PbModel.this.fqo);
                        }
                    }
                }
            }
        };
        this.hsT = null;
        registerListener(this.hsQ);
        registerListener(this.hsS);
        registerListener(this.hsR);
        this.hsc = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.cNc = baseActivity;
        this.hsz = new x(this, this.cNc);
        this.hsA = new h(this, this.cNc);
        this.hsB = new m(this, this.cNc);
        this.hsC = new z(this, this.cNc);
        this.dKX = new CheckRealNameModel(this.cNc.getPageContext());
        this.hsF = new SuggestEmotionModel();
        this.hsE = new AddExperiencedModel(this.cNc.getPageContext());
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
            this.hrG = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.m(data)) {
                com.baidu.tbadk.BdToken.f.Ui().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.brM) instanceof String)) {
                            PbModel.this.hrG = (String) hashMap.get(com.baidu.tbadk.BdToken.f.brM);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.hrG)) {
                this.hrG = this.hsz.ap(intent);
                if (StringUtils.isNull(this.hrG) && intent.getData() != null) {
                    this.hrG = data.getQueryParameter("thread_id");
                }
            }
            this.hsI = intent.getIntExtra("key_start_from", 0);
            if (this.hsI == 0) {
                this.hsI = this.hsz.hsZ;
            }
            this.hrI = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.hrH = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.hrK = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.hrL = intent.getBooleanExtra("host_only", false);
            this.hrN = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.apJ().afK() ? 2 : 0);
            if (this.mSortType == 2) {
                this.hrI = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.hrQ = intent.getIntExtra("is_top", 0);
            this.hrR = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.hrX = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.hrY = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.gzm = intent.getBooleanExtra("is_sub_pb", false);
            this.hsa = intent.getBooleanExtra("is_pv", false);
            this.hrZ = intent.getLongExtra("msg_id", 0L);
            this.hsb = intent.getStringExtra("from_forum_name");
            this.hsk = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.hsj = intent.getStringExtra("op_stat");
            this.hse = intent.getBooleanExtra("is_from_thread_config", false);
            this.hsf = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.hsg = intent.getBooleanExtra("is_from_my_god_config", false);
            this.hsm = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.hsl = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.hrV = intent.getBooleanExtra("from_frs", false);
            this.hrW = intent.getBooleanExtra("from_maintab", false);
            this.hsx = intent.getBooleanExtra("from_smart_frs", false);
            this.hsh = intent.getBooleanExtra("from_hottopic", false);
            this.hsD = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.hrJ = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.hsI = bundle.getInt("key_start_from", 0);
        this.hrG = bundle.getString("thread_id");
        this.hrI = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.hrH = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.hrK = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.hrL = bundle.getBoolean("host_only", false);
        this.hrN = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.hrQ = bundle.getInt("is_top", 0);
        this.hrR = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.hrY = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.gzm = bundle.getBoolean("is_sub_pb", false);
        this.hsa = bundle.getBoolean("is_pv", false);
        this.hrZ = bundle.getLong("msg_id", 0L);
        this.hsb = bundle.getString("from_forum_name");
        this.hsk = bundle.getString("extra_pb_cache_key");
        this.hse = bundle.getBoolean("is_from_thread_config", false);
        this.hsf = bundle.getBoolean("is_from_interview_live_config", false);
        this.hsg = bundle.getBoolean("is_from_my_god_config", false);
        this.hsm = bundle.getInt("extra_pb_is_attention_key", -1);
        this.hsl = bundle.getInt("extra_pb_funs_count_key", -1);
        this.hrV = bundle.getBoolean("from_frs", false);
        this.hrW = bundle.getBoolean("from_maintab", false);
        this.hsx = bundle.getBoolean("from_smart_frs", false);
        this.hsh = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.hrJ = bundle.getString("high_light_post_id");
    }

    public void aa(Bundle bundle) {
        bundle.putString("thread_id", this.hrG);
        bundle.putString("post_id", this.hrI);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.hsI);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.hrK);
        bundle.putBoolean("host_only", this.hrL);
        bundle.putBoolean("squence", this.hrN);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.hrQ);
        bundle.putLong("thread_time", this.hrR);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.hrY);
        bundle.putBoolean("is_sub_pb", this.gzm);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.hsa);
        bundle.putLong("msg_id", this.hrZ);
        bundle.putString("extra_pb_cache_key", this.hsk);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.hse);
        bundle.putBoolean("is_from_interview_live_config", this.hsf);
        bundle.putBoolean("is_from_my_god_config", this.hsg);
        bundle.putInt("extra_pb_is_attention_key", this.hsm);
        bundle.putInt("extra_pb_funs_count_key", this.hsl);
        bundle.putBoolean("from_frs", this.hrV);
        bundle.putBoolean("from_maintab", this.hrW);
        bundle.putBoolean("from_smart_frs", this.hsx);
        bundle.putBoolean("from_hottopic", this.hsh);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.hrJ);
    }

    public String bKM() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.hrG);
        if (!this.hrY) {
            sb.append(this.hrI);
        }
        sb.append(this.hrL);
        sb.append(this.hrN);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.hrQ);
        sb.append(this.hrR);
        sb.append(this.hrV);
        sb.append(this.hrW);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.gzm);
        sb.append(this.hsa);
        sb.append(this.hrZ);
        sb.append(this.hsb);
        sb.append(this.mThreadType);
        sb.append(this.hse);
        sb.append(this.hsf);
        sb.append(this.hsg);
        if (this.hsk != null) {
            sb.append(this.hsk);
        }
        return sb.toString();
    }

    public String bIO() {
        return this.hsb;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.hrI;
    }

    public String bKN() {
        return this.hrJ;
    }

    public String bKO() {
        return this.hrG;
    }

    public boolean getHostMode() {
        return this.hrL;
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
        return this.hrV;
    }

    public boolean bKR() {
        return this.hrP;
    }

    public boolean bKS() {
        return this.hrW;
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
        return this.hrQ;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void oA(int i) {
        this.hrQ = i;
    }

    public boolean bKU() {
        return this.gzm;
    }

    public boolean bKV() {
        if (this.hsc == null) {
            return false;
        }
        return this.hsc.isValid();
    }

    public String YX() {
        if (this.hsc == null || !this.hsc.UY()) {
            return null;
        }
        return this.hsc.UX();
    }

    public boolean wj(int i) {
        this.hrS = i;
        if (this.hrS > this.hsc.getPage().XC()) {
            this.hrS = this.hsc.getPage().XC();
        }
        if (this.hrS < 1) {
            this.hrS = 1;
        }
        if (this.hrG == null) {
            return false;
        }
        return wl(5);
    }

    public void wk(int i) {
        this.hrS = i;
        this.hrT = i;
        this.hrU = i;
    }

    public void b(com.baidu.tbadk.core.data.an anVar) {
        if (anVar == null) {
            wk(1);
            return;
        }
        if (this.hrT < anVar.XF()) {
            this.hrT = anVar.XF();
        }
        if (this.hrU > anVar.XF()) {
            this.hrU = anVar.XF();
        }
        this.enZ = anVar.XC();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.hsc;
    }

    public com.baidu.tieba.pb.data.d bKW() {
        if (this.hsc == null) {
            return this.hsc;
        }
        if (!bKX() && this.hsP != null) {
            this.hsc.b(this.hsP);
        }
        return this.hsc;
    }

    private boolean bKX() {
        return (this.hsc.bIl() == null || this.hsc.bIl().ced() == null || this.hsc.bIl().ced().goods != null || this.hsc.bIl().ced().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.an getPageData() {
        if (this.hsc == null) {
            return null;
        }
        return this.hsc.getPage();
    }

    public boolean bKY() {
        if (bLC() && this.hsc.getPage().XH() == 0) {
            ny(true);
            return true;
        }
        return false;
    }

    public void zJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.hrG = str;
            this.hrI = null;
            this.hrL = false;
            this.hrN = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hrG == null) {
            return false;
        }
        cancelLoadData();
        if (this.eDx == null) {
            this.eDx = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.eDx.start();
        }
        boolean wl = wl(3);
        if (this.opType != null) {
            this.opType = null;
            this.hsj = null;
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
        if (this.hsF != null) {
            this.hsF.cancelLoadData();
        }
        if (this.hsG != null) {
            this.hsG.cancelLoadData();
        }
        aWW();
    }

    private void aWW() {
        if (this.eDx != null) {
            this.eDx.destory();
            this.eDx = null;
        }
    }

    public boolean aor() {
        return (this.hrI == null || this.hrI.equals("0") || this.hrI.length() == 0) ? LoadData() : bLd();
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
                this.hsF.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.hsF.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.hsG == null) {
                this.hsG = new GetSugMatchWordsModel(this.cNc.getPageContext());
            }
            this.hsG.b(aVar);
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
            this.hrN = aj.bLX().bKP();
            this.hrL = aj.bLX().bMc();
            this.hrP = aj.bLX().bMd();
            this.hsK = aj.bLX().bMb();
            this.hsL = aj.bLX().bMa();
            this.hsM = aj.bLX().bLZ();
            this.hsH = this.hrL;
            if (this.hrL || this.isFromMark) {
                this.hsn = false;
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
        if (i == 4 && !this.hsr) {
            a(bLi(), true, this.hrI, 3);
        }
        if (i == 3 && !this.hsr) {
            if (this.isFromMark) {
                a(bLi(), true, this.hrI, 3);
            } else {
                a(bLi(), false, this.hrI, 3);
            }
        }
        this.hsr = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.hsP == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.chG);
        if (this.hrL || this.isFromMark) {
            this.hsn = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.hrG == null || this.hrG.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.hrG, 0L));
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
        if (!this.hrN) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.hrL) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.hsa) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.hrZ));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.hsn) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.l(this.hsj, 0));
            pbPageRequestMessage.setOpMessageID(this.hrZ);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bHY = this.hsc.bHY();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hrU - 1));
                        if (this.hrU - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.hrX) {
                                if (bHY != null && bHY.size() > 0) {
                                    size = bHY.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bHY.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.hrI = postData.getId();
                                            if (StringUtils.isNull(this.hrI)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.hrT + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.hrI == null && this.hrI.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hrI, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hrT + 1));
                        if (this.hrT >= this.enZ) {
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
                            if (this.hrI == null) {
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
                if (this.hrI == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bHY != null && bHY.size() > 0 && bHY.get(0) != null) {
                    this.hrI = bHY.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bLC()) {
                        if (this.hrU - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.hrU - 1));
                        }
                    } else if (this.hrT < this.enZ) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hrT + 1));
                    }
                }
                if (this.hrI != null && this.hrI.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hrI, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.hrL) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bLC()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.enZ > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.enZ));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hrI, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.hrS));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.hsH && !this.hrL) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hrI, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.hrL) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.hsv);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hsJ, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.hsH = this.hrL;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bLi());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.hsI));
        pbPageRequestMessage.setIsSubPostDataReverse(this.hsu);
        pbPageRequestMessage.setFromSmartFrs(this.hsx ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.hrK);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.hrG);
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
        ArrayList<PostData> bHY = this.hsc.bHY();
        this.hsq = false;
        if (i == 1) {
            boolean z2 = false;
            while (bHY.size() + 30 > com.baidu.tbadk.data.d.alk()) {
                bHY.remove(0);
                z2 = true;
            }
            if (z2) {
                this.hsc.getPage().gm(1);
                if (this.hsi != null) {
                    this.hsi.f(this.hsc);
                }
            }
            this.fqo = System.currentTimeMillis();
            this.hsq = true;
        } else if (i == 2) {
            while (bHY.size() + 30 > com.baidu.tbadk.data.d.alk()) {
                bHY.remove(bHY.size() - 1);
                z = true;
            }
            if (z) {
                this.hsc.getPage().gl(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.hsy = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
        }
        h(dVar2);
        if (this.hsP != null && this.hsP.axr()) {
            TiebaStatic.log(com.baidu.tieba.q.a.b("a005", "common_fill", true, 1));
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bIl() != null && dVar.bIl().ced() != null && dVar.bIl().ced().goods != null && dVar.bIl().axr() && dVar.bIl().ced().goods.goods_style != 1001) {
            this.hsP = dVar.bIl();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m bKZ() {
        return this.hsP;
    }

    public void bLa() {
        this.hsP = null;
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
            if (this.hsg || this.hse || this.hsf) {
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
                    postData.cem().get(i2).a(this.cNc.getPageContext(), l.equals(postData.cem().get(i2).YO().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.k bIh = dVar.bIh();
            if (bIh != null && !com.baidu.tbadk.core.util.v.T(bIh.hkJ)) {
                for (PostData postData2 : bIh.hkJ) {
                    for (int i3 = 0; i3 < postData2.cem().size(); i3++) {
                        postData2.cem().get(i3).a(this.cNc.getPageContext(), l.equals(postData2.cem().get(i3).YO().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.k bIh = dVar.bIh();
            if (bIh != null && !com.baidu.tbadk.core.util.v.T(bIh.hkJ)) {
                for (PostData postData : bIh.hkJ.subList(i, bIh.hkJ.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cem().size()) {
                            postData.cem().get(i3).a(this.cNc.getPageContext(), l.equals(postData.cem().get(i3).YO().getUserId()));
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
        bHW.gs(this.hrQ);
        if (this.hrR > 0) {
            bHW.ae(this.hrR);
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
        if (this.hsc == null || this.hsc.bHW() == null || this.hsc.bHW().YO() == null) {
            return null;
        }
        return this.hsc.bHW().YO();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.hsw = z3;
        this.hsd = i;
        if (this.eDx != null && !z3) {
            this.eDx.a(z2, z4, i2, str, i3, j, j2);
            this.eDx = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bIO()) && com.baidu.tieba.recapp.r.bWF().bWz() != null) {
            com.baidu.tieba.recapp.r.bWF().bWz().g(bIO(), wn(getRequestType()), true);
        }
        if (dVar == null || (this.hrS == 1 && i == 5 && dVar.bHY() != null && dVar.bHY().size() < 1)) {
            if (this.hsi != null) {
                this.hrN = this.hrM;
                if (i2 != 350006) {
                    this.mSortType = this.hrO;
                }
                this.hsi.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.hrM = this.hrN;
            if (i != 8) {
                this.hrO = this.mSortType;
                this.mSortType = dVar.hkj;
            }
            if (dVar.hki != null && dVar.hki.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.cNc.getResources().getString(d.j.default_sort);
                builder.sort_type = 0;
                dVar.hki = new ArrayList();
                dVar.hki.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.cNc.getResources().getString(d.j.view_reverse);
                builder2.sort_type = 1;
                dVar.hki.add(builder2.build(false));
                this.mSortType = this.hrO;
                dVar.hkj = this.mSortType;
            }
            this.hsa = false;
            if (dVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(dVar.getPage());
            }
            this.enZ = this.enZ < 1 ? 1 : this.enZ;
            ArrayList<PostData> bHY = this.hsc.bHY();
            switch (i) {
                case 1:
                    this.hsc.a(dVar.getPage(), 1);
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
                    this.hsc.a(dVar.getPage(), 2);
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.T(dVar.bHY()) && this.hsc != null && (!this.hrL || l(dVar).equals(dVar.bHY().get(0).YO().getUserId()))) {
                        if (this.hsc.getPage().XH() == 0) {
                            this.hsc.getPage().gl(1);
                        }
                        bLx();
                        this.hsK = dVar.bHY().get(0);
                        if (bLC()) {
                            if (this.hsc.bHY().size() - this.hsM >= 3) {
                                this.hsL = new PostData();
                                this.hsL.iGl = true;
                                this.hsL.setPostType(53);
                                this.hsc.bHY().add(this.hsL);
                            }
                            this.hsc.bHY().add(this.hsK);
                            i4 = this.hsc.bHY().size() - 1;
                        } else {
                            if (this.hsM - this.hsN >= 3) {
                                this.hsL = new PostData();
                                this.hsL.iGl = false;
                                this.hsL.setPostType(53);
                                this.hsc.bHY().add(0, this.hsL);
                            }
                            this.hsc.bHY().add(0, this.hsK);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ap.aM(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.hsK.iGx = this.hsc.bIv();
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
            if (this.hsc != null && this.hsc.bHW() != null) {
                PraiseData YA = this.hsc.bHW().YA();
                if (this.hsT != null && !YA.isPriaseDataValid()) {
                    this.hsc.bHW().a(this.hsT);
                } else {
                    this.hsT = this.hsc.bHW().YA();
                    this.hsT.setPostId(this.hsc.bHW().Ze());
                }
                if (dVar.getPage() != null && dVar.getPage().XF() == 1 && dVar.bHW() != null && dVar.bHW().YZ() != null && dVar.bHW().YZ().size() > 0) {
                    this.hsc.bHW().n(dVar.bHW().YZ());
                }
                this.hsc.bHW().gq(dVar.bHW().YF());
                this.hsc.bHW().gn(dVar.bHW().getAnchorLevel());
                this.hsc.bHW().gp(dVar.bHW().Yw());
                if (this.mThreadType == 33) {
                    this.hsc.bHW().YO().setHadConcerned(dVar.bHW().YO().hadConcerned());
                }
                if (dVar != null && dVar.bHW() != null) {
                    this.hsc.bHW().gv(dVar.bHW().Zd());
                }
            }
            if (this.hsc != null && this.hsc.getUserData() != null && dVar.getUserData() != null) {
                this.hsc.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.hsc.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.getPage() != null && dVar.getPage().XF() == 1 && dVar.bIg() != null) {
                this.hsc.d(dVar.bIg());
            }
            if (this.hsw) {
                if (this.hsc.bHW() != null && this.hsc.bHW().YO() != null && this.hsc.bHY() != null && com.baidu.tbadk.core.util.v.c(this.hsc.bHY(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.hsc.bHY(), 0);
                    MetaData YO = this.hsc.bHW().YO();
                    if (postData3.YO() != null && postData3.YO().getGodUserData() != null) {
                        if (this.hsl != -1) {
                            YO.setFansNum(this.hsl);
                            postData3.YO().setFansNum(this.hsl);
                        }
                        if (this.hsm != -1) {
                            YO.getGodUserData().setIsLike(this.hsm == 1);
                            postData3.YO().getGodUserData().setIsLike(this.hsm == 1);
                            YO.getGodUserData().setIsFromNetWork(false);
                            postData3.YO().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.hsc.hkh = -1;
                this.hsc.hkg = -1;
            }
            if (this.hsi != null) {
                this.hsi.a(true, getErrorCode(), i, i5, this.hsc, this.mErrorString, 1);
            }
        }
        if (this.hsc != null && this.hsc.bHW() != null && this.hsc.getForum() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.cNc.getPageContext();
            historyMessage.threadId = getPbData().bHW().getId();
            if (this.mIsShareThread && getPbData().bHW().bDy != null) {
                historyMessage.threadName = getPbData().bHW().bDy.showText;
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
        dVar.zG(this.hsc.bIo());
        this.hsc = dVar;
        wk(dVar.getPage().XF());
    }

    private void bLc() {
        if (this.hsc != null && this.hsc.bHY() != null && this.hsc.bIn() != null) {
            ArrayList<PostData> bHY = this.hsc.bHY();
            com.baidu.tieba.pb.data.a bIn = this.hsc.bIn();
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
        if (this.hrG == null || this.hrI == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return wl(4);
        }
        return wl(6);
    }

    public boolean ny(boolean z) {
        if (this.hrG == null || this.hsc == null) {
            return false;
        }
        if (z || this.hsc.getPage().XH() != 0) {
            return wl(1);
        }
        return false;
    }

    public boolean nz(boolean z) {
        if (this.hrG == null || this.hsc == null) {
            return false;
        }
        if ((z || this.hsc.getPage().XI() != 0) && this.hsc.bHY() != null && this.hsc.bHY().size() >= 1) {
            return wl(2);
        }
        return false;
    }

    public boolean zP(String str) {
        this.hrL = !this.hrL;
        this.hrI = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (wl(6)) {
            return true;
        }
        this.hrL = this.hrL ? false : true;
        return false;
    }

    public boolean u(boolean z, String str) {
        if (this.hrL == z) {
            return false;
        }
        this.hrL = z;
        this.hrI = str;
        if (this.mSortType == 2) {
            this.hrI = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (wl(6)) {
            return true;
        }
        this.hrL = z ? false : true;
        return false;
    }

    public boolean wo(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.hrM = this.hrN;
        this.hrO = this.mSortType;
        this.mSortType = i;
        this.hrN = !this.hrN;
        if (i == 2 && this.isFromMark) {
            this.hrI = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.hrN = this.hrN ? false : true;
            this.mSortType = this.hrO;
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
        return (this.hsc == null || this.hsc.getForum() == null || this.hsc.bHW() == null) ? false : true;
    }

    public boolean UY() {
        if (this.hsc == null) {
            return false;
        }
        return this.hsc.UY();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oO(String str) {
        if (this.hsc == null || this.hsc.bHW() == null || this.hsc.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.hsc.bHW().aag()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.hsc.getForum().getId());
            writeData.setForumName(this.hsc.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.hsI);
        writeData.setThreadId(this.hrG);
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
        if (this.hsc == null) {
            return null;
        }
        ArrayList<PostData> bHY = this.hsc.bHY();
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
        markData.setThreadId(this.hrG);
        markData.setPostId(this.hsc.UX());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hrL);
        markData.setSequence(Boolean.valueOf(bLC()));
        markData.setId(this.hrG);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hrG);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hrL);
        markData.setSequence(Boolean.valueOf(bLC()));
        markData.setId(this.hrG);
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
        String str = this.hrG;
        if (this.hrL) {
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
        if (this.hsc != null) {
            this.hsc.cZ(z);
        }
    }

    public void nB(boolean z) {
        this.hsn = z;
    }

    public boolean bLj() {
        return this.hsn;
    }

    public void a(a aVar) {
        this.hsi = aVar;
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
            this.hst = System.currentTimeMillis() / 1000;
        }
    }

    public void bLm() {
        if ("personalize_page".equals(this.mStType) && this.hsc != null && this.hst != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10754").bJ(ImageViewerConfig.FORUM_ID, this.hsc.getForumId()).bJ("tid", this.hrG).bJ("obj_duration", String.valueOf(currentTimeMillis - this.hst)).bJ("obj_param3", String.valueOf(currentTimeMillis)));
            this.hst = 0L;
        }
    }

    public boolean bLn() {
        return this.hsw;
    }

    public int getErrorNo() {
        return this.hsy;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bLo() {
        return this.hsA;
    }

    public m bLp() {
        return this.hsB;
    }

    public z bLq() {
        return this.hsC;
    }

    public CheckRealNameModel bLr() {
        return this.dKX;
    }

    public AddExperiencedModel bLs() {
        return this.hsE;
    }

    public String bLt() {
        return this.hss;
    }

    public void zR(String str) {
        this.hss = str;
    }

    public boolean bLu() {
        return this.hsx;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hsc != null && this.hsc.bHY() != null && this.hsc.bHY().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hsc.bHY().size();
                for (int i = 0; i < size; i++) {
                    if (this.hsc.bHY().get(i) != null && this.hsc.bHY().get(i).YO() != null && currentAccount.equals(this.hsc.bHY().get(i).YO().getUserId()) && this.hsc.bHY().get(i).YO().getPendantData() != null) {
                        this.hsc.bHY().get(i).YO().getPendantData().lg(lVar.Xk());
                        this.hsc.bHY().get(i).YO().getPendantData().aR(lVar.alu());
                    }
                }
            }
        }
    }

    public String bLv() {
        return this.hsD;
    }

    public int bLw() {
        return this.hsI;
    }

    public void wq(int i) {
        this.hsI = i;
    }

    public void zS(String str) {
        if ((!this.hrL || zQ(TbadkCoreApplication.getCurrentAccount())) && this.hsc.bHY() != null) {
            this.hsc.getPage().gl(1);
            if (this.hsc.getPage().XH() == 0) {
                this.hsc.getPage().gl(1);
            }
            this.hsJ = str;
            wl(8);
        }
    }

    private void wr(int i) {
        if (i != 8) {
            this.hsJ = "";
            if (this.hsK != null) {
                if (i == 1 && !this.hrN && !com.baidu.tbadk.core.util.v.T(getPbData().bHY())) {
                    getPbData().bHY().remove(this.hsK);
                    if (this.hsL != null) {
                        getPbData().bHY().remove(this.hsL);
                    }
                    getPbData().bHY().add(0, this.hsK);
                } else {
                    getPbData().bHY().remove(this.hsK);
                    if (this.hsL != null) {
                        getPbData().bHY().remove(this.hsL);
                    }
                }
            }
            this.hsL = null;
        }
    }

    public void bLx() {
        if (this.hsc != null && !com.baidu.tbadk.core.util.v.T(this.hsc.bHY())) {
            if (this.hsL != null) {
                this.hsc.bHY().remove(this.hsL);
                this.hsL = null;
            }
            if (this.hsK != null) {
                this.hsc.bHY().remove(this.hsK);
                this.hsK = null;
            }
        }
    }

    public void bU(int i, int i2) {
        this.hsM = i;
        this.hsN = i2;
    }

    public PostData bLy() {
        return this.hsK;
    }

    public PostData bLz() {
        return this.hsL;
    }

    public int bLA() {
        return this.hsM;
    }

    public String bLB() {
        return this.hsO;
    }

    public void zT(String str) {
        this.hsO = str;
    }

    private boolean bLC() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean bLD() {
        return this.hsI == 13 || this.hsI == 12;
    }
}
