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
    private final CheckRealNameModel dLK;
    private com.baidu.tieba.tbadkCore.d.b eDQ;
    private int eos;
    private long fqD;
    private boolean gzA;
    private boolean hsA;
    private boolean hsB;
    private a hsC;
    private String hsD;
    private String hsE;
    private int hsF;
    private int hsG;
    private boolean hsH;
    private boolean hsI;
    private boolean hsJ;
    private boolean hsK;
    private boolean hsL;
    private String hsM;
    private long hsN;
    private boolean hsO;
    private int hsP;
    private boolean hsQ;
    private boolean hsR;
    private int hsS;
    private final x hsT;
    private final h hsU;
    private final m hsV;
    private final z hsW;
    private String hsX;
    private final AddExperiencedModel hsY;
    private SuggestEmotionModel hsZ;
    protected String hsa;
    private String hsb;
    private String hsc;
    private String hsd;
    private boolean hse;
    private boolean hsf;
    private boolean hsg;
    private boolean hsh;
    private int hsi;
    private boolean hsj;
    private int hsk;
    private long hsl;
    private int hsm;
    private int hsn;
    private int hso;
    private boolean hsp;
    private boolean hsq;
    private boolean hsr;
    private boolean hss;
    private long hst;
    private boolean hsu;
    private String hsv;
    protected com.baidu.tieba.pb.data.d hsw;
    private int hsx;
    private boolean hsy;
    private boolean hsz;
    private GetSugMatchWordsModel hta;
    private boolean htb;
    private int htc;
    private String htd;
    private PostData hte;
    private PostData htf;
    private int htg;
    private int hth;
    private String hti;
    private com.baidu.tieba.tbadkCore.data.m htj;
    private CustomMessageListener htk;
    private CustomMessageListener htl;
    private com.baidu.adp.framework.listener.a htm;
    private PraiseData htn;
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
    private static final int hrZ = com.baidu.tbadk.data.d.alo() / 30;
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
        this.hsa = null;
        this.hsb = null;
        this.hsc = null;
        this.mForumId = null;
        this.hsd = null;
        this.hse = false;
        this.hsf = false;
        this.hsg = true;
        this.hsh = true;
        this.mSortType = 0;
        this.hsi = 0;
        this.hsj = false;
        this.mIsGood = 0;
        this.hsk = 0;
        this.hsl = 0L;
        this.hsm = 1;
        this.hsn = 1;
        this.hso = 1;
        this.eos = 1;
        this.isAd = false;
        this.gzA = false;
        this.hsp = false;
        this.hsq = false;
        this.isFromMark = false;
        this.hsr = false;
        this.hss = false;
        this.hst = 0L;
        this.hsu = false;
        this.hsv = null;
        this.hsw = null;
        this.isLoading = false;
        this.hsy = false;
        this.hsz = false;
        this.hsA = false;
        this.hsB = false;
        this.mLocate = null;
        this.mContext = null;
        this.hsC = null;
        this.opType = null;
        this.opUrl = null;
        this.hsD = null;
        this.hsE = null;
        this.hsF = -1;
        this.hsG = -1;
        this.eDQ = null;
        this.hsI = false;
        this.hsJ = false;
        this.postID = null;
        this.hsM = null;
        this.hsN = 0L;
        this.hsO = false;
        this.hsP = -1;
        this.hsR = false;
        this.htb = false;
        this.htc = 0;
        this.htk = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.hsL = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.n(pbData);
                    PbModel.this.j(pbData);
                    if (pbData.bIa() != null) {
                        pbData.bIa().gq(0);
                    }
                    if (PbModel.this.hsC != null && pbData != null) {
                        com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.hsC.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.htl = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.htm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
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
                    if (!PbModel.this.hsI || !PbModel.this.hsJ) {
                        if (!PbModel.this.hsI) {
                            PbModel.this.hsI = true;
                        } else {
                            PbModel.this.hsJ = true;
                        }
                        if (PbModel.this.hsC != null) {
                            PbModel.this.hsC.a(PbModel.this.bKP(), z, responsedMessage, PbModel.this.hsK, System.currentTimeMillis() - PbModel.this.fqD);
                        }
                    }
                }
            }
        };
        this.htn = null;
        registerListener(this.htk);
        registerListener(this.htm);
        registerListener(this.htl);
        this.hsw = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.cNd = baseActivity;
        this.hsT = new x(this, this.cNd);
        this.hsU = new h(this, this.cNd);
        this.hsV = new m(this, this.cNd);
        this.hsW = new z(this, this.cNd);
        this.dLK = new CheckRealNameModel(this.cNd.getPageContext());
        this.hsZ = new SuggestEmotionModel();
        this.hsY = new AddExperiencedModel(this.cNd.getPageContext());
    }

    protected int bKP() {
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
            this.hsa = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.m(data)) {
                com.baidu.tbadk.BdToken.f.Uk().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.brI) instanceof String)) {
                            PbModel.this.hsa = (String) hashMap.get(com.baidu.tbadk.BdToken.f.brI);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.hsa)) {
                this.hsa = this.hsT.ap(intent);
                if (StringUtils.isNull(this.hsa) && intent.getData() != null) {
                    this.hsa = data.getQueryParameter("thread_id");
                }
            }
            this.htc = intent.getIntExtra("key_start_from", 0);
            if (this.htc == 0) {
                this.htc = this.hsT.htt;
            }
            this.hsc = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.hsb = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.hse = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.hsf = intent.getBooleanExtra("host_only", false);
            this.hsh = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.apN().afN() ? 2 : 0);
            if (this.mSortType == 2) {
                this.hsc = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.hsk = intent.getIntExtra("is_top", 0);
            this.hsl = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.hsr = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.hss = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.gzA = intent.getBooleanExtra("is_sub_pb", false);
            this.hsu = intent.getBooleanExtra("is_pv", false);
            this.hst = intent.getLongExtra("msg_id", 0L);
            this.hsv = intent.getStringExtra("from_forum_name");
            this.hsE = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.hsD = intent.getStringExtra("op_stat");
            this.hsy = intent.getBooleanExtra("is_from_thread_config", false);
            this.hsz = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.hsA = intent.getBooleanExtra("is_from_my_god_config", false);
            this.hsG = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.hsF = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.hsp = intent.getBooleanExtra("from_frs", false);
            this.hsq = intent.getBooleanExtra("from_maintab", false);
            this.hsR = intent.getBooleanExtra("from_smart_frs", false);
            this.hsB = intent.getBooleanExtra("from_hottopic", false);
            this.hsX = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.hsd = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.htc = bundle.getInt("key_start_from", 0);
        this.hsa = bundle.getString("thread_id");
        this.hsc = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.hsb = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.hse = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.hsf = bundle.getBoolean("host_only", false);
        this.hsh = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.hsk = bundle.getInt("is_top", 0);
        this.hsl = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.hss = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.gzA = bundle.getBoolean("is_sub_pb", false);
        this.hsu = bundle.getBoolean("is_pv", false);
        this.hst = bundle.getLong("msg_id", 0L);
        this.hsv = bundle.getString("from_forum_name");
        this.hsE = bundle.getString("extra_pb_cache_key");
        this.hsy = bundle.getBoolean("is_from_thread_config", false);
        this.hsz = bundle.getBoolean("is_from_interview_live_config", false);
        this.hsA = bundle.getBoolean("is_from_my_god_config", false);
        this.hsG = bundle.getInt("extra_pb_is_attention_key", -1);
        this.hsF = bundle.getInt("extra_pb_funs_count_key", -1);
        this.hsp = bundle.getBoolean("from_frs", false);
        this.hsq = bundle.getBoolean("from_maintab", false);
        this.hsR = bundle.getBoolean("from_smart_frs", false);
        this.hsB = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.hsd = bundle.getString("high_light_post_id");
    }

    public void aa(Bundle bundle) {
        bundle.putString("thread_id", this.hsa);
        bundle.putString("post_id", this.hsc);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.htc);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.hse);
        bundle.putBoolean("host_only", this.hsf);
        bundle.putBoolean("squence", this.hsh);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.hsk);
        bundle.putLong("thread_time", this.hsl);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.hss);
        bundle.putBoolean("is_sub_pb", this.gzA);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.hsu);
        bundle.putLong("msg_id", this.hst);
        bundle.putString("extra_pb_cache_key", this.hsE);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.hsy);
        bundle.putBoolean("is_from_interview_live_config", this.hsz);
        bundle.putBoolean("is_from_my_god_config", this.hsA);
        bundle.putInt("extra_pb_is_attention_key", this.hsG);
        bundle.putInt("extra_pb_funs_count_key", this.hsF);
        bundle.putBoolean("from_frs", this.hsp);
        bundle.putBoolean("from_maintab", this.hsq);
        bundle.putBoolean("from_smart_frs", this.hsR);
        bundle.putBoolean("from_hottopic", this.hsB);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.hsd);
    }

    public String bKQ() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.hsa);
        if (!this.hss) {
            sb.append(this.hsc);
        }
        sb.append(this.hsf);
        sb.append(this.hsh);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.hsk);
        sb.append(this.hsl);
        sb.append(this.hsp);
        sb.append(this.hsq);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.gzA);
        sb.append(this.hsu);
        sb.append(this.hst);
        sb.append(this.hsv);
        sb.append(this.mThreadType);
        sb.append(this.hsy);
        sb.append(this.hsz);
        sb.append(this.hsA);
        if (this.hsE != null) {
            sb.append(this.hsE);
        }
        return sb.toString();
    }

    public String bIS() {
        return this.hsv;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.hsc;
    }

    public String bKR() {
        return this.hsd;
    }

    public String bKS() {
        return this.hsa;
    }

    public boolean getHostMode() {
        return this.hsf;
    }

    public boolean bKT() {
        return bLG();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bKU() {
        return this.hsp;
    }

    public boolean bKV() {
        return this.hsj;
    }

    public boolean bKW() {
        return this.hsq;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bKX() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aWl() {
        return this.hsk;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void oE(int i) {
        this.hsk = i;
    }

    public boolean bKY() {
        return this.gzA;
    }

    public boolean bKZ() {
        if (this.hsw == null) {
            return false;
        }
        return this.hsw.isValid();
    }

    public String Za() {
        if (this.hsw == null || !this.hsw.Vb()) {
            return null;
        }
        return this.hsw.Va();
    }

    public boolean wn(int i) {
        this.hsm = i;
        if (this.hsm > this.hsw.getPage().XF()) {
            this.hsm = this.hsw.getPage().XF();
        }
        if (this.hsm < 1) {
            this.hsm = 1;
        }
        if (this.hsa == null) {
            return false;
        }
        return wp(5);
    }

    public void wo(int i) {
        this.hsm = i;
        this.hsn = i;
        this.hso = i;
    }

    public void b(com.baidu.tbadk.core.data.an anVar) {
        if (anVar == null) {
            wo(1);
            return;
        }
        if (this.hsn < anVar.XI()) {
            this.hsn = anVar.XI();
        }
        if (this.hso > anVar.XI()) {
            this.hso = anVar.XI();
        }
        this.eos = anVar.XF();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.hsw;
    }

    public com.baidu.tieba.pb.data.d bLa() {
        if (this.hsw == null) {
            return this.hsw;
        }
        if (!bLb() && this.htj != null) {
            this.hsw.b(this.htj);
        }
        return this.hsw;
    }

    private boolean bLb() {
        return (this.hsw.bIp() == null || this.hsw.bIp().cef() == null || this.hsw.bIp().cef().goods != null || this.hsw.bIp().cef().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.an getPageData() {
        if (this.hsw == null) {
            return null;
        }
        return this.hsw.getPage();
    }

    public boolean bLc() {
        if (bLG() && this.hsw.getPage().XK() == 0) {
            ny(true);
            return true;
        }
        return false;
    }

    public void zM(String str) {
        if (!StringUtils.isNull(str)) {
            this.hsa = str;
            this.hsc = null;
            this.hsf = false;
            this.hsh = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hsa == null) {
            return false;
        }
        cancelLoadData();
        if (this.eDQ == null) {
            this.eDQ = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.eDQ.start();
        }
        boolean wp = wp(3);
        if (this.opType != null) {
            this.opType = null;
            this.hsD = null;
            this.opUrl = null;
            return wp;
        }
        return wp;
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
        if (this.hsZ != null) {
            this.hsZ.cancelLoadData();
        }
        if (this.hta != null) {
            this.hta.cancelLoadData();
        }
        aWZ();
    }

    private void aWZ() {
        if (this.eDQ != null) {
            this.eDQ.destory();
            this.eDQ = null;
        }
    }

    public boolean aov() {
        return (this.hsc == null || this.hsc.equals("0") || this.hsc.length() == 0) ? LoadData() : bLh();
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
                this.hsZ.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.hsZ.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.hta == null) {
                this.hta = new GetSugMatchWordsModel(this.cNd.getPageContext());
            }
            this.hta.b(aVar);
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
    public boolean wp(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        wq(i);
        final com.baidu.tieba.pb.data.d pbData = aj.bMb().getPbData();
        if (pbData != null && pbData.bIa() != null) {
            pbData.bIa().gq(0);
            this.hsh = aj.bMb().bKT();
            this.hsf = aj.bMb().bMg();
            this.hsj = aj.bMb().bMh();
            this.hte = aj.bMb().bMf();
            this.htf = aj.bMb().bMe();
            this.htg = aj.bMb().bMd();
            this.htb = this.hsf;
            if (this.hsf || this.isFromMark) {
                this.hsH = false;
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
        if (i == 4 && !this.hsL) {
            a(bLm(), true, this.hsc, 3);
        }
        if (i == 3 && !this.hsL) {
            if (this.isFromMark) {
                a(bLm(), true, this.hsc, 3);
            } else {
                a(bLm(), false, this.hsc, 3);
            }
        }
        this.hsL = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.htj == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.chE);
        if (this.hsf || this.isFromMark) {
            this.hsH = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.hsa == null || this.hsa.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.hsa, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.ar.adp().adr() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(aO));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aQ));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.hsh) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.hsf) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.hsu) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.hst));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.hsH) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.l(this.hsD, 0));
            pbPageRequestMessage.setOpMessageID(this.hst);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bIc = this.hsw.bIc();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hso - 1));
                        if (this.hso - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.hsr) {
                                if (bIc != null && bIc.size() > 0) {
                                    size = bIc.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bIc.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.hsc = postData.getId();
                                            if (StringUtils.isNull(this.hsc)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.hsn + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.hsc == null && this.hsc.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hsc, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hsn + 1));
                        if (this.hsn >= this.eos) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bIc != null) {
                                size = bIc.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.hsc == null) {
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
                if (bIc != null) {
                }
                if (this.hsc == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bIc != null && bIc.size() > 0 && bIc.get(0) != null) {
                    this.hsc = bIc.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bLG()) {
                        if (this.hso - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.hso - 1));
                        }
                    } else if (this.hsn < this.eos) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hsn + 1));
                    }
                }
                if (this.hsc != null && this.hsc.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hsc, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.hsf) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bLG()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.eos > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eos));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hsc, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.hsm));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.htb && !this.hsf) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hsc, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.hsf) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.hsP);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.htd, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.htb = this.hsf;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bLm());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.htc));
        pbPageRequestMessage.setIsSubPostDataReverse(this.hsO);
        pbPageRequestMessage.setFromSmartFrs(this.hsR ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.hse);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.hsa);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bIR() {
        switch (bLA()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bIa() == null || !getPbData().bIa().aaj();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bIS()) && com.baidu.tieba.recapp.r.bWH().bWB() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bWH().bWB().ar(bIS(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bWH().bWB().as(bIS(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bIS()) && com.baidu.tieba.recapp.r.bWH().bWB() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bWH().bWB().as(bIS(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bWH().bWB().ar(bIS(), true));
        }
    }

    protected void wq(int i) {
        boolean z = false;
        wv(i);
        ArrayList<PostData> bIc = this.hsw.bIc();
        this.hsK = false;
        if (i == 1) {
            boolean z2 = false;
            while (bIc.size() + 30 > com.baidu.tbadk.data.d.alo()) {
                bIc.remove(0);
                z2 = true;
            }
            if (z2) {
                this.hsw.getPage().gn(1);
                if (this.hsC != null) {
                    this.hsC.f(this.hsw);
                }
            }
            this.fqD = System.currentTimeMillis();
            this.hsK = true;
        } else if (i == 2) {
            while (bIc.size() + 30 > com.baidu.tbadk.data.d.alo()) {
                bIc.remove(bIc.size() - 1);
                z = true;
            }
            if (z) {
                this.hsw.getPage().gm(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.hsS = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            j(dVar2);
            i(dVar2);
        }
        h(dVar2);
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bIp() != null && dVar.bIp().cef() != null && dVar.bIp().cef().goods != null && dVar.bIp().axv() && dVar.bIp().cef().goods.goods_style != 1001) {
            this.htj = dVar.bIp();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m bLd() {
        return this.htj;
    }

    public void bLe() {
        this.htj = null;
    }

    private void i(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.hsb)) {
            try {
                Long valueOf = Long.valueOf(this.hsb);
                com.baidu.tieba.pb.data.k bIl = dVar.bIl();
                if (bIl != null && bIl.hkY != null) {
                    if (bIl.hkY.isEmpty() || !bIl.hkY.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.hsa);
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

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            if (this.hsA || this.hsy || this.hsz) {
                dVar = l(dVar);
            }
            k(dVar);
        }
    }

    protected void k(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String m = m(dVar);
            for (int i = 0; i < dVar.bIc().size(); i++) {
                PostData postData = dVar.bIc().get(i);
                for (int i2 = 0; i2 < postData.ceo().size(); i2++) {
                    postData.ceo().get(i2).a(this.cNd.getPageContext(), m.equals(postData.ceo().get(i2).YR().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.k bIl = dVar.bIl();
            if (bIl != null && !com.baidu.tbadk.core.util.v.T(bIl.hkX)) {
                for (PostData postData2 : bIl.hkX) {
                    for (int i3 = 0; i3 < postData2.ceo().size(); i3++) {
                        postData2.ceo().get(i3).a(this.cNd.getPageContext(), m.equals(postData2.ceo().get(i3).YR().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String m = m(dVar);
            com.baidu.tieba.pb.data.k bIl = dVar.bIl();
            if (bIl != null && !com.baidu.tbadk.core.util.v.T(bIl.hkX)) {
                for (PostData postData : bIl.hkX.subList(i, bIl.hkX.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.ceo().size()) {
                            postData.ceo().get(i3).a(this.cNd.getPageContext(), m.equals(postData.ceo().get(i3).YR().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.d l(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null) {
            return null;
        }
        bg bIa = dVar.bIa();
        bIa.gu(this.mIsGood);
        bIa.gt(this.hsk);
        if (this.hsl > 0) {
            bIa.ae(this.hsl);
            return dVar;
        }
        return dVar;
    }

    protected String m(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bIa() != null && dVar.bIa().YR() != null) {
            str = dVar.bIa().YR().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bLf() {
        if (this.hsw == null || this.hsw.bIa() == null || this.hsw.bIa().YR() == null) {
            return null;
        }
        return this.hsw.bIa().YR();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.hsQ = z3;
        this.hsx = i;
        if (this.eDQ != null && !z3) {
            this.eDQ.a(z2, z4, i2, str, i3, j, j2);
            this.eDQ = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bIS()) && com.baidu.tieba.recapp.r.bWH().bWB() != null) {
            com.baidu.tieba.recapp.r.bWH().bWB().g(bIS(), wr(getRequestType()), true);
        }
        if (dVar == null || (this.hsm == 1 && i == 5 && dVar.bIc() != null && dVar.bIc().size() < 1)) {
            if (this.hsC != null) {
                this.hsh = this.hsg;
                if (i2 != 350006) {
                    this.mSortType = this.hsi;
                }
                this.hsC.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.hsg = this.hsh;
            if (i != 8) {
                this.hsi = this.mSortType;
                this.mSortType = dVar.hkx;
            }
            if (dVar.hkw != null && dVar.hkw.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.cNd.getResources().getString(d.j.default_sort);
                builder.sort_type = 0;
                dVar.hkw = new ArrayList();
                dVar.hkw.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.cNd.getResources().getString(d.j.view_reverse);
                builder2.sort_type = 1;
                dVar.hkw.add(builder2.build(false));
                this.mSortType = this.hsi;
                dVar.hkx = this.mSortType;
            }
            this.hsu = false;
            if (dVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(dVar.getPage());
            }
            this.eos = this.eos < 1 ? 1 : this.eos;
            ArrayList<PostData> bIc = this.hsw.bIc();
            switch (i) {
                case 1:
                    this.hsw.a(dVar.getPage(), 1);
                    d(dVar, bIc);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bIc() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bIc().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bIc, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bIc(), com.baidu.tbadk.core.util.v.S(dVar.bIc()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bIc().remove(postData2);
                            i6 = size - 1;
                        }
                        bIc.addAll(0, dVar.bIc());
                    }
                    this.hsw.a(dVar.getPage(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.getPage() != null) {
                        dVar.getPage().gk(dVar.getPage().XF());
                    }
                    n(dVar);
                    if (!z3 && this.mThreadType != 33 && bLG()) {
                        bLg();
                        i5 = 0;
                        break;
                    }
                    i5 = 0;
                    break;
                case 4:
                    n(dVar);
                    i5 = 0;
                    break;
                case 5:
                    n(dVar);
                    i5 = 0;
                    break;
                case 6:
                    n(dVar);
                    i5 = 0;
                    break;
                case 7:
                    n(dVar);
                    i5 = 0;
                    break;
                case 8:
                    if (dVar != null && !com.baidu.tbadk.core.util.v.T(dVar.bIc()) && this.hsw != null && (!this.hsf || m(dVar).equals(dVar.bIc().get(0).YR().getUserId()))) {
                        if (this.hsw.getPage().XK() == 0) {
                            this.hsw.getPage().gm(1);
                        }
                        bLB();
                        this.hte = dVar.bIc().get(0);
                        if (bLG()) {
                            if (this.hsw.bIc().size() - this.htg >= 3) {
                                this.htf = new PostData();
                                this.htf.iGJ = true;
                                this.htf.setPostType(53);
                                this.hsw.bIc().add(this.htf);
                            }
                            this.hsw.bIc().add(this.hte);
                            i4 = this.hsw.bIc().size() - 1;
                        } else {
                            if (this.htg - this.hth >= 3) {
                                this.htf = new PostData();
                                this.htf.iGJ = false;
                                this.htf.setPostType(53);
                                this.hsw.bIc().add(0, this.htf);
                            }
                            this.hsw.bIc().add(0, this.hte);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ap.aM(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.hte.iGV = this.hsw.bIz();
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
            if (this.hsw != null && this.hsw.bIa() != null) {
                PraiseData YD = this.hsw.bIa().YD();
                if (this.htn != null && !YD.isPriaseDataValid()) {
                    this.hsw.bIa().a(this.htn);
                } else {
                    this.htn = this.hsw.bIa().YD();
                    this.htn.setPostId(this.hsw.bIa().Zh());
                }
                if (dVar.getPage() != null && dVar.getPage().XI() == 1 && dVar.bIa() != null && dVar.bIa().Zc() != null && dVar.bIa().Zc().size() > 0) {
                    this.hsw.bIa().n(dVar.bIa().Zc());
                }
                this.hsw.bIa().gr(dVar.bIa().YI());
                this.hsw.bIa().go(dVar.bIa().getAnchorLevel());
                this.hsw.bIa().gq(dVar.bIa().Yz());
                if (this.mThreadType == 33) {
                    this.hsw.bIa().YR().setHadConcerned(dVar.bIa().YR().hadConcerned());
                }
                if (dVar != null && dVar.bIa() != null) {
                    this.hsw.bIa().gw(dVar.bIa().Zg());
                }
            }
            if (this.hsw != null && this.hsw.getUserData() != null && dVar.getUserData() != null) {
                this.hsw.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.hsw.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.getPage() != null && dVar.getPage().XI() == 1 && dVar.bIk() != null) {
                this.hsw.d(dVar.bIk());
            }
            if (this.hsQ) {
                if (this.hsw.bIa() != null && this.hsw.bIa().YR() != null && this.hsw.bIc() != null && com.baidu.tbadk.core.util.v.c(this.hsw.bIc(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.hsw.bIc(), 0);
                    MetaData YR = this.hsw.bIa().YR();
                    if (postData3.YR() != null && postData3.YR().getGodUserData() != null) {
                        if (this.hsF != -1) {
                            YR.setFansNum(this.hsF);
                            postData3.YR().setFansNum(this.hsF);
                        }
                        if (this.hsG != -1) {
                            YR.getGodUserData().setIsLike(this.hsG == 1);
                            postData3.YR().getGodUserData().setIsLike(this.hsG == 1);
                            YR.getGodUserData().setIsFromNetWork(false);
                            postData3.YR().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.hsw.hkv = -1;
                this.hsw.hku = -1;
            }
            if (this.hsC != null) {
                this.hsC.a(true, getErrorCode(), i, i5, this.hsw, this.mErrorString, 1);
            }
        }
        if (this.hsw != null && this.hsw.bIa() != null && this.hsw.getForum() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.cNd.getPageContext();
            historyMessage.threadId = getPbData().bIa().getId();
            if (this.mIsShareThread && getPbData().bIa().bDt != null) {
                historyMessage.threadName = getPbData().bIa().bDt.showText;
            } else {
                historyMessage.threadName = getPbData().bIa().getTitle();
            }
            if (this.mIsShareThread && !bIR()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bKT();
            historyMessage.threadType = getPbData().bIa().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String as;
        if (arrayList != null && dVar.bIc() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bIc(), 0);
            if (postData != null && (as = as(arrayList)) != null && as.equals(postData.getId())) {
                dVar.bIc().remove(postData);
            }
            arrayList.addAll(dVar.bIc());
        }
    }

    private int wr(int i) {
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
    public void n(com.baidu.tieba.pb.data.d dVar) {
        dVar.zJ(this.hsw.bIs());
        this.hsw = dVar;
        wo(dVar.getPage().XI());
    }

    private void bLg() {
        if (this.hsw != null && this.hsw.bIc() != null && this.hsw.bIr() != null) {
            ArrayList<PostData> bIc = this.hsw.bIc();
            com.baidu.tieba.pb.data.a bIr = this.hsw.bIr();
            int bHX = bIr.bHX();
            if (bHX > 0) {
                if (bHX <= bIc.size()) {
                    bIc.add(bHX, bIr);
                } else {
                    bIc.add(bIr);
                }
            }
        }
    }

    public boolean bLh() {
        if (this.hsa == null || this.hsc == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return wp(4);
        }
        return wp(6);
    }

    public boolean ny(boolean z) {
        if (this.hsa == null || this.hsw == null) {
            return false;
        }
        if (z || this.hsw.getPage().XK() != 0) {
            return wp(1);
        }
        return false;
    }

    public boolean nz(boolean z) {
        if (this.hsa == null || this.hsw == null) {
            return false;
        }
        if ((z || this.hsw.getPage().XL() != 0) && this.hsw.bIc() != null && this.hsw.bIc().size() >= 1) {
            return wp(2);
        }
        return false;
    }

    public boolean zS(String str) {
        this.hsf = !this.hsf;
        this.hsc = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (wp(6)) {
            return true;
        }
        this.hsf = this.hsf ? false : true;
        return false;
    }

    public boolean u(boolean z, String str) {
        if (this.hsf == z) {
            return false;
        }
        this.hsf = z;
        this.hsc = str;
        if (this.mSortType == 2) {
            this.hsc = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (wp(6)) {
            return true;
        }
        this.hsf = z ? false : true;
        return false;
    }

    public boolean ws(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.hsg = this.hsh;
        this.hsi = this.mSortType;
        this.mSortType = i;
        this.hsh = !this.hsh;
        if (i == 2 && this.isFromMark) {
            this.hsc = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.hsh = this.hsh ? false : true;
            this.mSortType = this.hsi;
            return false;
        }
        return true;
    }

    public boolean bLi() {
        return bLG();
    }

    public int bLj() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.hsw == null || this.hsw.getForum() == null || this.hsw.bIa() == null) ? false : true;
    }

    public boolean Vb() {
        if (this.hsw == null) {
            return false;
        }
        return this.hsw.Vb();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oN(String str) {
        if (this.hsw == null || this.hsw.bIa() == null || this.hsw.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.hsw.bIa().aaj()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.hsw.getForum().getId());
            writeData.setForumName(this.hsw.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.htc);
        writeData.setThreadId(this.hsa);
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

    public MarkData wt(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.hsw == null) {
            return null;
        }
        ArrayList<PostData> bIc = this.hsw.bIc();
        if (com.baidu.tbadk.core.util.v.T(bIc)) {
            return null;
        }
        if (bIc.size() > 0 && i >= bIc.size()) {
            i = bIc.size() - 1;
        }
        return j(bIc.get(i));
    }

    public MarkData bLk() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hsa);
        markData.setPostId(this.hsw.Va());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hsf);
        markData.setSequence(Boolean.valueOf(bLG()));
        markData.setId(this.hsa);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hsa);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hsf);
        markData.setSequence(Boolean.valueOf(bLG()));
        markData.setId(this.hsa);
        markData.setFloor(postData.cer());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void bLl() {
        g.bKC().am(bLm(), this.isFromMark);
    }

    private String bLm() {
        String str = this.hsa;
        if (this.hsf) {
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
        if (this.hsw != null) {
            this.hsw.cZ(z);
        }
    }

    public void nB(boolean z) {
        this.hsH = z;
    }

    public boolean bLn() {
        return this.hsH;
    }

    public void a(a aVar) {
        this.hsC = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String amp() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean amo() {
        return aov();
    }

    public boolean zT(String str) {
        if (getPbData() == null || getPbData().bIa() == null || getPbData().bIa().YR() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bIa().YR().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bLo() {
        String bLm = bLm();
        g.bKC().am(bLm, false);
        g.bKC().am(bLm, true);
    }

    public void bLp() {
        if ("personalize_page".equals(this.mStType)) {
            this.hsN = System.currentTimeMillis() / 1000;
        }
    }

    public void bLq() {
        if ("personalize_page".equals(this.mStType) && this.hsw != null && this.hsN != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10754").bJ(ImageViewerConfig.FORUM_ID, this.hsw.getForumId()).bJ("tid", this.hsa).bJ("obj_duration", String.valueOf(currentTimeMillis - this.hsN)).bJ("obj_param3", String.valueOf(currentTimeMillis)));
            this.hsN = 0L;
        }
    }

    public boolean bLr() {
        return this.hsQ;
    }

    public int getErrorNo() {
        return this.hsS;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bLs() {
        return this.hsU;
    }

    public m bLt() {
        return this.hsV;
    }

    public z bLu() {
        return this.hsW;
    }

    public CheckRealNameModel bLv() {
        return this.dLK;
    }

    public AddExperiencedModel bLw() {
        return this.hsY;
    }

    public String bLx() {
        return this.hsM;
    }

    public void zU(String str) {
        this.hsM = str;
    }

    public boolean bLy() {
        return this.hsR;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hsw != null && this.hsw.bIc() != null && this.hsw.bIc().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hsw.bIc().size();
                for (int i = 0; i < size; i++) {
                    if (this.hsw.bIc().get(i) != null && this.hsw.bIc().get(i).YR() != null && currentAccount.equals(this.hsw.bIc().get(i).YR().getUserId()) && this.hsw.bIc().get(i).YR().getPendantData() != null) {
                        this.hsw.bIc().get(i).YR().getPendantData().lf(lVar.Xn());
                        this.hsw.bIc().get(i).YR().getPendantData().aR(lVar.aly());
                    }
                }
            }
        }
    }

    public String bLz() {
        return this.hsX;
    }

    public int bLA() {
        return this.htc;
    }

    public void wu(int i) {
        this.htc = i;
    }

    public void zV(String str) {
        if ((!this.hsf || zT(TbadkCoreApplication.getCurrentAccount())) && this.hsw.bIc() != null) {
            this.hsw.getPage().gm(1);
            if (this.hsw.getPage().XK() == 0) {
                this.hsw.getPage().gm(1);
            }
            this.htd = str;
            wp(8);
        }
    }

    private void wv(int i) {
        if (i != 8) {
            this.htd = "";
            if (this.hte != null) {
                if (i == 1 && !this.hsh && !com.baidu.tbadk.core.util.v.T(getPbData().bIc())) {
                    getPbData().bIc().remove(this.hte);
                    if (this.htf != null) {
                        getPbData().bIc().remove(this.htf);
                    }
                    getPbData().bIc().add(0, this.hte);
                } else {
                    getPbData().bIc().remove(this.hte);
                    if (this.htf != null) {
                        getPbData().bIc().remove(this.htf);
                    }
                }
            }
            this.htf = null;
        }
    }

    public void bLB() {
        if (this.hsw != null && !com.baidu.tbadk.core.util.v.T(this.hsw.bIc())) {
            if (this.htf != null) {
                this.hsw.bIc().remove(this.htf);
                this.htf = null;
            }
            if (this.hte != null) {
                this.hsw.bIc().remove(this.hte);
                this.hte = null;
            }
        }
    }

    public void bU(int i, int i2) {
        this.htg = i;
        this.hth = i2;
    }

    public PostData bLC() {
        return this.hte;
    }

    public PostData bLD() {
        return this.htf;
    }

    public int bLE() {
        return this.htg;
    }

    public String bLF() {
        return this.hti;
    }

    public void zW(String str) {
        this.hti = str;
    }

    private boolean bLG() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean bLH() {
        return this.htc == 13 || this.htc == 12;
    }
}
