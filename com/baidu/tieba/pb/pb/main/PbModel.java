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
    private BaseActivity cNa;
    private final CheckRealNameModel dLG;
    private com.baidu.tieba.tbadkCore.d.b eDM;
    private int eoo;
    private long fqC;
    private boolean gzz;
    protected String hrT;
    private String hrU;
    private String hrV;
    private String hrW;
    private boolean hrX;
    private boolean hrY;
    private boolean hrZ;
    private boolean hsA;
    private boolean hsB;
    private boolean hsC;
    private boolean hsD;
    private boolean hsE;
    private String hsF;
    private long hsG;
    private boolean hsH;
    private int hsI;
    private boolean hsJ;
    private boolean hsK;
    private int hsL;
    private final x hsM;
    private final h hsN;
    private final m hsO;
    private final z hsP;
    private String hsQ;
    private final AddExperiencedModel hsR;
    private SuggestEmotionModel hsS;
    private GetSugMatchWordsModel hsT;
    private boolean hsU;
    private int hsV;
    private String hsW;
    private PostData hsX;
    private PostData hsY;
    private int hsZ;
    private boolean hsa;
    private int hsb;
    private boolean hsc;
    private int hsd;
    private long hse;
    private int hsf;
    private int hsg;
    private int hsh;
    private boolean hsi;
    private boolean hsj;
    private boolean hsk;
    private boolean hsl;
    private long hsm;
    private boolean hsn;
    private String hso;
    protected com.baidu.tieba.pb.data.d hsp;
    private int hsq;
    private boolean hsr;
    private boolean hss;
    private boolean hst;
    private boolean hsu;
    private a hsv;
    private String hsw;
    private String hsx;
    private int hsy;
    private int hsz;
    private int hta;
    private String htb;
    private com.baidu.tieba.tbadkCore.data.m htc;
    private CustomMessageListener htd;
    private CustomMessageListener hte;
    private com.baidu.adp.framework.listener.a htf;
    private PraiseData htg;
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
    private static final int hrS = com.baidu.tbadk.data.d.aln() / 30;
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
        this.hrT = null;
        this.hrU = null;
        this.hrV = null;
        this.mForumId = null;
        this.hrW = null;
        this.hrX = false;
        this.hrY = false;
        this.hrZ = true;
        this.hsa = true;
        this.mSortType = 0;
        this.hsb = 0;
        this.hsc = false;
        this.mIsGood = 0;
        this.hsd = 0;
        this.hse = 0L;
        this.hsf = 1;
        this.hsg = 1;
        this.hsh = 1;
        this.eoo = 1;
        this.isAd = false;
        this.gzz = false;
        this.hsi = false;
        this.hsj = false;
        this.isFromMark = false;
        this.hsk = false;
        this.hsl = false;
        this.hsm = 0L;
        this.hsn = false;
        this.hso = null;
        this.hsp = null;
        this.isLoading = false;
        this.hsr = false;
        this.hss = false;
        this.hst = false;
        this.hsu = false;
        this.mLocate = null;
        this.mContext = null;
        this.hsv = null;
        this.opType = null;
        this.opUrl = null;
        this.hsw = null;
        this.hsx = null;
        this.hsy = -1;
        this.hsz = -1;
        this.eDM = null;
        this.hsB = false;
        this.hsC = false;
        this.postID = null;
        this.hsF = null;
        this.hsG = 0L;
        this.hsH = false;
        this.hsI = -1;
        this.hsK = false;
        this.hsU = false;
        this.hsV = 0;
        this.htd = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.hsE = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.n(pbData);
                    PbModel.this.j(pbData);
                    if (pbData.bHZ() != null) {
                        pbData.bHZ().gq(0);
                    }
                    if (PbModel.this.hsv != null && pbData != null) {
                        com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.hsv.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.hte = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.htf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.kY()) {
                        PbModel.this.cNa.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.hsB || !PbModel.this.hsC) {
                        if (!PbModel.this.hsB) {
                            PbModel.this.hsB = true;
                        } else {
                            PbModel.this.hsC = true;
                        }
                        if (PbModel.this.hsv != null) {
                            PbModel.this.hsv.a(PbModel.this.bKO(), z, responsedMessage, PbModel.this.hsD, System.currentTimeMillis() - PbModel.this.fqC);
                        }
                    }
                }
            }
        };
        this.htg = null;
        registerListener(this.htd);
        registerListener(this.htf);
        registerListener(this.hte);
        this.hsp = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.cNa = baseActivity;
        this.hsM = new x(this, this.cNa);
        this.hsN = new h(this, this.cNa);
        this.hsO = new m(this, this.cNa);
        this.hsP = new z(this, this.cNa);
        this.dLG = new CheckRealNameModel(this.cNa.getPageContext());
        this.hsS = new SuggestEmotionModel();
        this.hsR = new AddExperiencedModel(this.cNa.getPageContext());
    }

    protected int bKO() {
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
            this.hrT = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.m(data)) {
                com.baidu.tbadk.BdToken.f.Uk().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.brJ) instanceof String)) {
                            PbModel.this.hrT = (String) hashMap.get(com.baidu.tbadk.BdToken.f.brJ);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.hrT)) {
                this.hrT = this.hsM.ap(intent);
                if (StringUtils.isNull(this.hrT) && intent.getData() != null) {
                    this.hrT = data.getQueryParameter("thread_id");
                }
            }
            this.hsV = intent.getIntExtra("key_start_from", 0);
            if (this.hsV == 0) {
                this.hsV = this.hsM.htm;
            }
            this.hrV = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.hrU = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.hrX = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.hrY = intent.getBooleanExtra("host_only", false);
            this.hsa = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.apM().afN() ? 2 : 0);
            if (this.mSortType == 2) {
                this.hrV = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.hsd = intent.getIntExtra("is_top", 0);
            this.hse = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.hsk = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.hsl = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.gzz = intent.getBooleanExtra("is_sub_pb", false);
            this.hsn = intent.getBooleanExtra("is_pv", false);
            this.hsm = intent.getLongExtra("msg_id", 0L);
            this.hso = intent.getStringExtra("from_forum_name");
            this.hsx = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.hsw = intent.getStringExtra("op_stat");
            this.hsr = intent.getBooleanExtra("is_from_thread_config", false);
            this.hss = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.hst = intent.getBooleanExtra("is_from_my_god_config", false);
            this.hsz = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.hsy = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.hsi = intent.getBooleanExtra("from_frs", false);
            this.hsj = intent.getBooleanExtra("from_maintab", false);
            this.hsK = intent.getBooleanExtra("from_smart_frs", false);
            this.hsu = intent.getBooleanExtra("from_hottopic", false);
            this.hsQ = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.hrW = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.hsV = bundle.getInt("key_start_from", 0);
        this.hrT = bundle.getString("thread_id");
        this.hrV = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.hrU = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.hrX = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.hrY = bundle.getBoolean("host_only", false);
        this.hsa = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.hsd = bundle.getInt("is_top", 0);
        this.hse = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.hsl = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.gzz = bundle.getBoolean("is_sub_pb", false);
        this.hsn = bundle.getBoolean("is_pv", false);
        this.hsm = bundle.getLong("msg_id", 0L);
        this.hso = bundle.getString("from_forum_name");
        this.hsx = bundle.getString("extra_pb_cache_key");
        this.hsr = bundle.getBoolean("is_from_thread_config", false);
        this.hss = bundle.getBoolean("is_from_interview_live_config", false);
        this.hst = bundle.getBoolean("is_from_my_god_config", false);
        this.hsz = bundle.getInt("extra_pb_is_attention_key", -1);
        this.hsy = bundle.getInt("extra_pb_funs_count_key", -1);
        this.hsi = bundle.getBoolean("from_frs", false);
        this.hsj = bundle.getBoolean("from_maintab", false);
        this.hsK = bundle.getBoolean("from_smart_frs", false);
        this.hsu = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.hrW = bundle.getString("high_light_post_id");
    }

    public void aa(Bundle bundle) {
        bundle.putString("thread_id", this.hrT);
        bundle.putString("post_id", this.hrV);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.hsV);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.hrX);
        bundle.putBoolean("host_only", this.hrY);
        bundle.putBoolean("squence", this.hsa);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.hsd);
        bundle.putLong("thread_time", this.hse);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.hsl);
        bundle.putBoolean("is_sub_pb", this.gzz);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.hsn);
        bundle.putLong("msg_id", this.hsm);
        bundle.putString("extra_pb_cache_key", this.hsx);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.hsr);
        bundle.putBoolean("is_from_interview_live_config", this.hss);
        bundle.putBoolean("is_from_my_god_config", this.hst);
        bundle.putInt("extra_pb_is_attention_key", this.hsz);
        bundle.putInt("extra_pb_funs_count_key", this.hsy);
        bundle.putBoolean("from_frs", this.hsi);
        bundle.putBoolean("from_maintab", this.hsj);
        bundle.putBoolean("from_smart_frs", this.hsK);
        bundle.putBoolean("from_hottopic", this.hsu);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.hrW);
    }

    public String bKP() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.hrT);
        if (!this.hsl) {
            sb.append(this.hrV);
        }
        sb.append(this.hrY);
        sb.append(this.hsa);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.hsd);
        sb.append(this.hse);
        sb.append(this.hsi);
        sb.append(this.hsj);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.gzz);
        sb.append(this.hsn);
        sb.append(this.hsm);
        sb.append(this.hso);
        sb.append(this.mThreadType);
        sb.append(this.hsr);
        sb.append(this.hss);
        sb.append(this.hst);
        if (this.hsx != null) {
            sb.append(this.hsx);
        }
        return sb.toString();
    }

    public String bIR() {
        return this.hso;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.hrV;
    }

    public String bKQ() {
        return this.hrW;
    }

    public String bKR() {
        return this.hrT;
    }

    public boolean getHostMode() {
        return this.hrY;
    }

    public boolean bKS() {
        return bLF();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bKT() {
        return this.hsi;
    }

    public boolean bKU() {
        return this.hsc;
    }

    public boolean bKV() {
        return this.hsj;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bKW() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aWk() {
        return this.hsd;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void oE(int i) {
        this.hsd = i;
    }

    public boolean bKX() {
        return this.gzz;
    }

    public boolean bKY() {
        if (this.hsp == null) {
            return false;
        }
        return this.hsp.isValid();
    }

    public String Za() {
        if (this.hsp == null || !this.hsp.Vb()) {
            return null;
        }
        return this.hsp.Va();
    }

    public boolean wn(int i) {
        this.hsf = i;
        if (this.hsf > this.hsp.getPage().XF()) {
            this.hsf = this.hsp.getPage().XF();
        }
        if (this.hsf < 1) {
            this.hsf = 1;
        }
        if (this.hrT == null) {
            return false;
        }
        return wp(5);
    }

    public void wo(int i) {
        this.hsf = i;
        this.hsg = i;
        this.hsh = i;
    }

    public void b(com.baidu.tbadk.core.data.an anVar) {
        if (anVar == null) {
            wo(1);
            return;
        }
        if (this.hsg < anVar.XI()) {
            this.hsg = anVar.XI();
        }
        if (this.hsh > anVar.XI()) {
            this.hsh = anVar.XI();
        }
        this.eoo = anVar.XF();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.hsp;
    }

    public com.baidu.tieba.pb.data.d bKZ() {
        if (this.hsp == null) {
            return this.hsp;
        }
        if (!bLa() && this.htc != null) {
            this.hsp.b(this.htc);
        }
        return this.hsp;
    }

    private boolean bLa() {
        return (this.hsp.bIo() == null || this.hsp.bIo().ceh() == null || this.hsp.bIo().ceh().goods != null || this.hsp.bIo().ceh().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.an getPageData() {
        if (this.hsp == null) {
            return null;
        }
        return this.hsp.getPage();
    }

    public boolean bLb() {
        if (bLF() && this.hsp.getPage().XK() == 0) {
            ny(true);
            return true;
        }
        return false;
    }

    public void zK(String str) {
        if (!StringUtils.isNull(str)) {
            this.hrT = str;
            this.hrV = null;
            this.hrY = false;
            this.hsa = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hrT == null) {
            return false;
        }
        cancelLoadData();
        if (this.eDM == null) {
            this.eDM = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.eDM.start();
        }
        boolean wp = wp(3);
        if (this.opType != null) {
            this.opType = null;
            this.hsw = null;
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
        if (this.hsS != null) {
            this.hsS.cancelLoadData();
        }
        if (this.hsT != null) {
            this.hsT.cancelLoadData();
        }
        aWY();
    }

    private void aWY() {
        if (this.eDM != null) {
            this.eDM.destory();
            this.eDM = null;
        }
    }

    public boolean aou() {
        return (this.hrV == null || this.hrV.equals("0") || this.hrV.length() == 0) ? LoadData() : bLg();
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
                this.hsS.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.hsS.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.hsT == null) {
                this.hsT = new GetSugMatchWordsModel(this.cNa.getPageContext());
            }
            this.hsT.b(aVar);
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
        final com.baidu.tieba.pb.data.d pbData = aj.bMa().getPbData();
        if (pbData != null && pbData.bHZ() != null) {
            pbData.bHZ().gq(0);
            this.hsa = aj.bMa().bKS();
            this.hrY = aj.bMa().bMf();
            this.hsc = aj.bMa().bMg();
            this.hsX = aj.bMa().bMe();
            this.hsY = aj.bMa().bMd();
            this.hsZ = aj.bMa().bMc();
            this.hsU = this.hrY;
            if (this.hrY || this.isFromMark) {
                this.hsA = false;
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
        if (i == 4 && !this.hsE) {
            a(bLl(), true, this.hrV, 3);
        }
        if (i == 3 && !this.hsE) {
            if (this.isFromMark) {
                a(bLl(), true, this.hrV, 3);
            } else {
                a(bLl(), false, this.hrV, 3);
            }
        }
        this.hsE = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.htc == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.chE);
        if (this.hrY || this.isFromMark) {
            this.hsA = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.hrT == null || this.hrT.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.hrT, 0L));
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
        if (!this.hsa) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.hrY) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.hsn) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.hsm));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.hsA) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.l(this.hsw, 0));
            pbPageRequestMessage.setOpMessageID(this.hsm);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bIb = this.hsp.bIb();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hsh - 1));
                        if (this.hsh - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.hsk) {
                                if (bIb != null && bIb.size() > 0) {
                                    size = bIb.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bIb.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.hrV = postData.getId();
                                            if (StringUtils.isNull(this.hrV)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.hsg + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.hrV == null && this.hrV.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hrV, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hsg + 1));
                        if (this.hsg >= this.eoo) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bIb != null) {
                                size = bIb.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.hrV == null) {
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
                if (bIb != null) {
                }
                if (this.hrV == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bIb != null && bIb.size() > 0 && bIb.get(0) != null) {
                    this.hrV = bIb.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bLF()) {
                        if (this.hsh - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.hsh - 1));
                        }
                    } else if (this.hsg < this.eoo) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hsg + 1));
                    }
                }
                if (this.hrV != null && this.hrV.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hrV, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.hrY) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bLF()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.eoo > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eoo));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hrV, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.hsf));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.hsU && !this.hrY) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hrV, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.hrY) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.hsI);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.hsW, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.hsU = this.hrY;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bLl());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.hsV));
        pbPageRequestMessage.setIsSubPostDataReverse(this.hsH);
        pbPageRequestMessage.setFromSmartFrs(this.hsK ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.hrX);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.hrT);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bIQ() {
        switch (bLz()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bHZ() == null || !getPbData().bHZ().aaj();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bIR()) && com.baidu.tieba.recapp.r.bWJ().bWD() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bWJ().bWD().ar(bIR(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bWJ().bWD().as(bIR(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bIR()) && com.baidu.tieba.recapp.r.bWJ().bWD() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bWJ().bWD().as(bIR(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bWJ().bWD().ar(bIR(), true));
        }
    }

    protected void wq(int i) {
        boolean z = false;
        wv(i);
        ArrayList<PostData> bIb = this.hsp.bIb();
        this.hsD = false;
        if (i == 1) {
            boolean z2 = false;
            while (bIb.size() + 30 > com.baidu.tbadk.data.d.aln()) {
                bIb.remove(0);
                z2 = true;
            }
            if (z2) {
                this.hsp.getPage().gn(1);
                if (this.hsv != null) {
                    this.hsv.f(this.hsp);
                }
            }
            this.fqC = System.currentTimeMillis();
            this.hsD = true;
        } else if (i == 2) {
            while (bIb.size() + 30 > com.baidu.tbadk.data.d.aln()) {
                bIb.remove(bIb.size() - 1);
                z = true;
            }
            if (z) {
                this.hsp.getPage().gm(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.hsL = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            j(dVar2);
            i(dVar2);
        }
        h(dVar2);
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bIo() != null && dVar.bIo().ceh() != null && dVar.bIo().ceh().goods != null && dVar.bIo().axu() && dVar.bIo().ceh().goods.goods_style != 1001) {
            this.htc = dVar.bIo();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m bLc() {
        return this.htc;
    }

    public void bLd() {
        this.htc = null;
    }

    private void i(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.hrU)) {
            try {
                Long valueOf = Long.valueOf(this.hrU);
                com.baidu.tieba.pb.data.k bIk = dVar.bIk();
                if (bIk != null && bIk.hkX != null) {
                    if (bIk.hkX.isEmpty() || !bIk.hkX.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.hrT);
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
            if (this.hst || this.hsr || this.hss) {
                dVar = l(dVar);
            }
            k(dVar);
        }
    }

    protected void k(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String m = m(dVar);
            for (int i = 0; i < dVar.bIb().size(); i++) {
                PostData postData = dVar.bIb().get(i);
                for (int i2 = 0; i2 < postData.ceq().size(); i2++) {
                    postData.ceq().get(i2).a(this.cNa.getPageContext(), m.equals(postData.ceq().get(i2).YR().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.k bIk = dVar.bIk();
            if (bIk != null && !com.baidu.tbadk.core.util.v.T(bIk.hkW)) {
                for (PostData postData2 : bIk.hkW) {
                    for (int i3 = 0; i3 < postData2.ceq().size(); i3++) {
                        postData2.ceq().get(i3).a(this.cNa.getPageContext(), m.equals(postData2.ceq().get(i3).YR().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String m = m(dVar);
            com.baidu.tieba.pb.data.k bIk = dVar.bIk();
            if (bIk != null && !com.baidu.tbadk.core.util.v.T(bIk.hkW)) {
                for (PostData postData : bIk.hkW.subList(i, bIk.hkW.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.ceq().size()) {
                            postData.ceq().get(i3).a(this.cNa.getPageContext(), m.equals(postData.ceq().get(i3).YR().getUserId()));
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
        bg bHZ = dVar.bHZ();
        bHZ.gu(this.mIsGood);
        bHZ.gt(this.hsd);
        if (this.hse > 0) {
            bHZ.ae(this.hse);
            return dVar;
        }
        return dVar;
    }

    protected String m(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bHZ() != null && dVar.bHZ().YR() != null) {
            str = dVar.bHZ().YR().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bLe() {
        if (this.hsp == null || this.hsp.bHZ() == null || this.hsp.bHZ().YR() == null) {
            return null;
        }
        return this.hsp.bHZ().YR();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.hsJ = z3;
        this.hsq = i;
        if (this.eDM != null && !z3) {
            this.eDM.a(z2, z4, i2, str, i3, j, j2);
            this.eDM = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bIR()) && com.baidu.tieba.recapp.r.bWJ().bWD() != null) {
            com.baidu.tieba.recapp.r.bWJ().bWD().g(bIR(), wr(getRequestType()), true);
        }
        if (dVar == null || (this.hsf == 1 && i == 5 && dVar.bIb() != null && dVar.bIb().size() < 1)) {
            if (this.hsv != null) {
                this.hsa = this.hrZ;
                if (i2 != 350006) {
                    this.mSortType = this.hsb;
                }
                this.hsv.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.hrZ = this.hsa;
            if (i != 8) {
                this.hsb = this.mSortType;
                this.mSortType = dVar.hkw;
            }
            if (dVar.hkv != null && dVar.hkv.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.cNa.getResources().getString(d.j.default_sort);
                builder.sort_type = 0;
                dVar.hkv = new ArrayList();
                dVar.hkv.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.cNa.getResources().getString(d.j.view_reverse);
                builder2.sort_type = 1;
                dVar.hkv.add(builder2.build(false));
                this.mSortType = this.hsb;
                dVar.hkw = this.mSortType;
            }
            this.hsn = false;
            if (dVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(dVar.getPage());
            }
            this.eoo = this.eoo < 1 ? 1 : this.eoo;
            ArrayList<PostData> bIb = this.hsp.bIb();
            switch (i) {
                case 1:
                    this.hsp.a(dVar.getPage(), 1);
                    d(dVar, bIb);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bIb() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bIb().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bIb, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bIb(), com.baidu.tbadk.core.util.v.S(dVar.bIb()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bIb().remove(postData2);
                            i6 = size - 1;
                        }
                        bIb.addAll(0, dVar.bIb());
                    }
                    this.hsp.a(dVar.getPage(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.getPage() != null) {
                        dVar.getPage().gk(dVar.getPage().XF());
                    }
                    n(dVar);
                    if (!z3 && this.mThreadType != 33 && bLF()) {
                        bLf();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.T(dVar.bIb()) && this.hsp != null && (!this.hrY || m(dVar).equals(dVar.bIb().get(0).YR().getUserId()))) {
                        if (this.hsp.getPage().XK() == 0) {
                            this.hsp.getPage().gm(1);
                        }
                        bLA();
                        this.hsX = dVar.bIb().get(0);
                        if (bLF()) {
                            if (this.hsp.bIb().size() - this.hsZ >= 3) {
                                this.hsY = new PostData();
                                this.hsY.iGB = true;
                                this.hsY.setPostType(53);
                                this.hsp.bIb().add(this.hsY);
                            }
                            this.hsp.bIb().add(this.hsX);
                            i4 = this.hsp.bIb().size() - 1;
                        } else {
                            if (this.hsZ - this.hta >= 3) {
                                this.hsY = new PostData();
                                this.hsY.iGB = false;
                                this.hsY.setPostType(53);
                                this.hsp.bIb().add(0, this.hsY);
                            }
                            this.hsp.bIb().add(0, this.hsX);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ap.aM(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.hsX.iGN = this.hsp.bIy();
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
            if (this.hsp != null && this.hsp.bHZ() != null) {
                PraiseData YD = this.hsp.bHZ().YD();
                if (this.htg != null && !YD.isPriaseDataValid()) {
                    this.hsp.bHZ().a(this.htg);
                } else {
                    this.htg = this.hsp.bHZ().YD();
                    this.htg.setPostId(this.hsp.bHZ().Zh());
                }
                if (dVar.getPage() != null && dVar.getPage().XI() == 1 && dVar.bHZ() != null && dVar.bHZ().Zc() != null && dVar.bHZ().Zc().size() > 0) {
                    this.hsp.bHZ().n(dVar.bHZ().Zc());
                }
                this.hsp.bHZ().gr(dVar.bHZ().YI());
                this.hsp.bHZ().go(dVar.bHZ().getAnchorLevel());
                this.hsp.bHZ().gq(dVar.bHZ().Yz());
                if (this.mThreadType == 33) {
                    this.hsp.bHZ().YR().setHadConcerned(dVar.bHZ().YR().hadConcerned());
                }
                if (dVar != null && dVar.bHZ() != null) {
                    this.hsp.bHZ().gw(dVar.bHZ().Zg());
                }
            }
            if (this.hsp != null && this.hsp.getUserData() != null && dVar.getUserData() != null) {
                this.hsp.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.hsp.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.getPage() != null && dVar.getPage().XI() == 1 && dVar.bIj() != null) {
                this.hsp.d(dVar.bIj());
            }
            if (this.hsJ) {
                if (this.hsp.bHZ() != null && this.hsp.bHZ().YR() != null && this.hsp.bIb() != null && com.baidu.tbadk.core.util.v.c(this.hsp.bIb(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.hsp.bIb(), 0);
                    MetaData YR = this.hsp.bHZ().YR();
                    if (postData3.YR() != null && postData3.YR().getGodUserData() != null) {
                        if (this.hsy != -1) {
                            YR.setFansNum(this.hsy);
                            postData3.YR().setFansNum(this.hsy);
                        }
                        if (this.hsz != -1) {
                            YR.getGodUserData().setIsLike(this.hsz == 1);
                            postData3.YR().getGodUserData().setIsLike(this.hsz == 1);
                            YR.getGodUserData().setIsFromNetWork(false);
                            postData3.YR().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.hsp.hku = -1;
                this.hsp.hkt = -1;
            }
            if (this.hsv != null) {
                this.hsv.a(true, getErrorCode(), i, i5, this.hsp, this.mErrorString, 1);
            }
        }
        if (this.hsp != null && this.hsp.bHZ() != null && this.hsp.getForum() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.cNa.getPageContext();
            historyMessage.threadId = getPbData().bHZ().getId();
            if (this.mIsShareThread && getPbData().bHZ().bDv != null) {
                historyMessage.threadName = getPbData().bHZ().bDv.showText;
            } else {
                historyMessage.threadName = getPbData().bHZ().getTitle();
            }
            if (this.mIsShareThread && !bIQ()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bKS();
            historyMessage.threadType = getPbData().bHZ().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String as;
        if (arrayList != null && dVar.bIb() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bIb(), 0);
            if (postData != null && (as = as(arrayList)) != null && as.equals(postData.getId())) {
                dVar.bIb().remove(postData);
            }
            arrayList.addAll(dVar.bIb());
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
        dVar.zH(this.hsp.bIr());
        this.hsp = dVar;
        wo(dVar.getPage().XI());
    }

    private void bLf() {
        if (this.hsp != null && this.hsp.bIb() != null && this.hsp.bIq() != null) {
            ArrayList<PostData> bIb = this.hsp.bIb();
            com.baidu.tieba.pb.data.a bIq = this.hsp.bIq();
            int bHW = bIq.bHW();
            if (bHW > 0) {
                if (bHW <= bIb.size()) {
                    bIb.add(bHW, bIq);
                } else {
                    bIb.add(bIq);
                }
            }
        }
    }

    public boolean bLg() {
        if (this.hrT == null || this.hrV == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return wp(4);
        }
        return wp(6);
    }

    public boolean ny(boolean z) {
        if (this.hrT == null || this.hsp == null) {
            return false;
        }
        if (z || this.hsp.getPage().XK() != 0) {
            return wp(1);
        }
        return false;
    }

    public boolean nz(boolean z) {
        if (this.hrT == null || this.hsp == null) {
            return false;
        }
        if ((z || this.hsp.getPage().XL() != 0) && this.hsp.bIb() != null && this.hsp.bIb().size() >= 1) {
            return wp(2);
        }
        return false;
    }

    public boolean zQ(String str) {
        this.hrY = !this.hrY;
        this.hrV = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (wp(6)) {
            return true;
        }
        this.hrY = this.hrY ? false : true;
        return false;
    }

    public boolean u(boolean z, String str) {
        if (this.hrY == z) {
            return false;
        }
        this.hrY = z;
        this.hrV = str;
        if (this.mSortType == 2) {
            this.hrV = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (wp(6)) {
            return true;
        }
        this.hrY = z ? false : true;
        return false;
    }

    public boolean ws(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.hrZ = this.hsa;
        this.hsb = this.mSortType;
        this.mSortType = i;
        this.hsa = !this.hsa;
        if (i == 2 && this.isFromMark) {
            this.hrV = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.hsa = this.hsa ? false : true;
            this.mSortType = this.hsb;
            return false;
        }
        return true;
    }

    public boolean bLh() {
        return bLF();
    }

    public int bLi() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.hsp == null || this.hsp.getForum() == null || this.hsp.bHZ() == null) ? false : true;
    }

    public boolean Vb() {
        if (this.hsp == null) {
            return false;
        }
        return this.hsp.Vb();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oN(String str) {
        if (this.hsp == null || this.hsp.bHZ() == null || this.hsp.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.hsp.bHZ().aaj()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.hsp.getForum().getId());
            writeData.setForumName(this.hsp.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.hsV);
        writeData.setThreadId(this.hrT);
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
        if (this.hsp == null) {
            return null;
        }
        ArrayList<PostData> bIb = this.hsp.bIb();
        if (com.baidu.tbadk.core.util.v.T(bIb)) {
            return null;
        }
        if (bIb.size() > 0 && i >= bIb.size()) {
            i = bIb.size() - 1;
        }
        return j(bIb.get(i));
    }

    public MarkData bLj() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hrT);
        markData.setPostId(this.hsp.Va());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hrY);
        markData.setSequence(Boolean.valueOf(bLF()));
        markData.setId(this.hrT);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hrT);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hrY);
        markData.setSequence(Boolean.valueOf(bLF()));
        markData.setId(this.hrT);
        markData.setFloor(postData.cet());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void bLk() {
        g.bKB().am(bLl(), this.isFromMark);
    }

    private String bLl() {
        String str = this.hrT;
        if (this.hrY) {
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
        if (this.hsp != null) {
            this.hsp.cZ(z);
        }
    }

    public void nB(boolean z) {
        this.hsA = z;
    }

    public boolean bLm() {
        return this.hsA;
    }

    public void a(a aVar) {
        this.hsv = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String amo() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean amn() {
        return aou();
    }

    public boolean zR(String str) {
        if (getPbData() == null || getPbData().bHZ() == null || getPbData().bHZ().YR() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bHZ().YR().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bLn() {
        String bLl = bLl();
        g.bKB().am(bLl, false);
        g.bKB().am(bLl, true);
    }

    public void bLo() {
        if ("personalize_page".equals(this.mStType)) {
            this.hsG = System.currentTimeMillis() / 1000;
        }
    }

    public void bLp() {
        if ("personalize_page".equals(this.mStType) && this.hsp != null && this.hsG != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10754").bJ(ImageViewerConfig.FORUM_ID, this.hsp.getForumId()).bJ("tid", this.hrT).bJ("obj_duration", String.valueOf(currentTimeMillis - this.hsG)).bJ("obj_param3", String.valueOf(currentTimeMillis)));
            this.hsG = 0L;
        }
    }

    public boolean bLq() {
        return this.hsJ;
    }

    public int getErrorNo() {
        return this.hsL;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bLr() {
        return this.hsN;
    }

    public m bLs() {
        return this.hsO;
    }

    public z bLt() {
        return this.hsP;
    }

    public CheckRealNameModel bLu() {
        return this.dLG;
    }

    public AddExperiencedModel bLv() {
        return this.hsR;
    }

    public String bLw() {
        return this.hsF;
    }

    public void zS(String str) {
        this.hsF = str;
    }

    public boolean bLx() {
        return this.hsK;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hsp != null && this.hsp.bIb() != null && this.hsp.bIb().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hsp.bIb().size();
                for (int i = 0; i < size; i++) {
                    if (this.hsp.bIb().get(i) != null && this.hsp.bIb().get(i).YR() != null && currentAccount.equals(this.hsp.bIb().get(i).YR().getUserId()) && this.hsp.bIb().get(i).YR().getPendantData() != null) {
                        this.hsp.bIb().get(i).YR().getPendantData().lf(lVar.Xn());
                        this.hsp.bIb().get(i).YR().getPendantData().aR(lVar.alx());
                    }
                }
            }
        }
    }

    public String bLy() {
        return this.hsQ;
    }

    public int bLz() {
        return this.hsV;
    }

    public void wu(int i) {
        this.hsV = i;
    }

    public void zT(String str) {
        if ((!this.hrY || zR(TbadkCoreApplication.getCurrentAccount())) && this.hsp.bIb() != null) {
            this.hsp.getPage().gm(1);
            if (this.hsp.getPage().XK() == 0) {
                this.hsp.getPage().gm(1);
            }
            this.hsW = str;
            wp(8);
        }
    }

    private void wv(int i) {
        if (i != 8) {
            this.hsW = "";
            if (this.hsX != null) {
                if (i == 1 && !this.hsa && !com.baidu.tbadk.core.util.v.T(getPbData().bIb())) {
                    getPbData().bIb().remove(this.hsX);
                    if (this.hsY != null) {
                        getPbData().bIb().remove(this.hsY);
                    }
                    getPbData().bIb().add(0, this.hsX);
                } else {
                    getPbData().bIb().remove(this.hsX);
                    if (this.hsY != null) {
                        getPbData().bIb().remove(this.hsY);
                    }
                }
            }
            this.hsY = null;
        }
    }

    public void bLA() {
        if (this.hsp != null && !com.baidu.tbadk.core.util.v.T(this.hsp.bIb())) {
            if (this.hsY != null) {
                this.hsp.bIb().remove(this.hsY);
                this.hsY = null;
            }
            if (this.hsX != null) {
                this.hsp.bIb().remove(this.hsX);
                this.hsX = null;
            }
        }
    }

    public void bU(int i, int i2) {
        this.hsZ = i;
        this.hta = i2;
    }

    public PostData bLB() {
        return this.hsX;
    }

    public PostData bLC() {
        return this.hsY;
    }

    public int bLD() {
        return this.hsZ;
    }

    public String bLE() {
        return this.htb;
    }

    public void zU(String str) {
        this.htb = str;
    }

    private boolean bLF() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean bLG() {
        return this.hsV == 13 || this.hsV == 12;
    }
}
