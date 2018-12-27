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
import java.util.HashMap;
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
    private BaseActivity bBi;
    private final CheckRealNameModel cwe;
    private int ddE;
    private com.baidu.tieba.tbadkCore.d.b drX;
    private long ecr;
    private boolean fiM;
    protected String gaS;
    private String gaT;
    private String gaU;
    private boolean gaV;
    private boolean gaW;
    private boolean gaX;
    private boolean gaY;
    private int gaZ;
    private boolean gbA;
    private boolean gbB;
    private String gbC;
    private long gbD;
    private boolean gbE;
    private int gbF;
    private boolean gbG;
    private boolean gbH;
    private int gbI;
    private final x gbJ;
    private final h gbK;
    private final m gbL;
    private final z gbM;
    private String gbN;
    private final AddExperiencedModel gbO;
    private SuggestEmotionModel gbP;
    private GetSugMatchWordsModel gbQ;
    private boolean gbR;
    private int gbS;
    private String gbT;
    private PostData gbU;
    private PostData gbV;
    private int gbW;
    private int gbX;
    private String gbY;
    private CustomMessageListener gbZ;
    private boolean gba;
    private int gbb;
    private long gbc;
    private int gbd;
    private int gbe;
    private int gbf;
    private boolean gbg;
    private boolean gbh;
    private boolean gbi;
    private long gbj;
    private boolean gbk;
    private String gbl;
    protected com.baidu.tieba.pb.data.d gbm;
    private int gbn;
    private boolean gbo;
    private boolean gbp;
    private boolean gbq;
    private boolean gbr;
    private a gbs;
    private String gbt;
    private String gbu;
    private int gbv;
    private int gbw;
    private boolean gbx;
    private boolean gby;
    private boolean gbz;
    private CustomMessageListener gca;
    private com.baidu.adp.framework.listener.a gcb;
    private PraiseData gcc;
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
    private static final int gaR = com.baidu.tbadk.data.d.Lx() / 30;
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
        this.gaS = null;
        this.gaT = null;
        this.gaU = null;
        this.mForumId = null;
        this.gaV = false;
        this.gaW = false;
        this.gaX = true;
        this.gaY = true;
        this.mSortType = 0;
        this.gaZ = 0;
        this.gba = false;
        this.mIsGood = 0;
        this.gbb = 0;
        this.gbc = 0L;
        this.gbd = 1;
        this.gbe = 1;
        this.gbf = 1;
        this.ddE = 1;
        this.isAd = false;
        this.fiM = false;
        this.gbg = false;
        this.gbh = false;
        this.isFromMark = false;
        this.gbi = false;
        this.gbj = 0L;
        this.gbk = false;
        this.gbl = null;
        this.gbm = null;
        this.isLoading = false;
        this.gbo = false;
        this.gbp = false;
        this.gbq = false;
        this.gbr = false;
        this.mLocate = null;
        this.mContext = null;
        this.gbs = null;
        this.opType = null;
        this.opUrl = null;
        this.gbt = null;
        this.gbu = null;
        this.gbv = -1;
        this.gbw = -1;
        this.drX = null;
        this.gby = false;
        this.gbz = false;
        this.postID = null;
        this.gbC = null;
        this.gbD = 0L;
        this.gbE = false;
        this.gbF = -1;
        this.gbH = false;
        this.gbR = false;
        this.gbS = 0;
        this.gbZ = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.gbB = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.bgV() != null) {
                        pbData.bgV().cO(0);
                    }
                    if (PbModel.this.gbs != null && pbData != null) {
                        com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.gbs.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.gca = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().bgT() != null && PbModel.this.getPbData().bgT().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().bgT().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.gcb = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.kV()) {
                        PbModel.this.bBi.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.gby || !PbModel.this.gbz) {
                        if (!PbModel.this.gby) {
                            PbModel.this.gby = true;
                        } else {
                            PbModel.this.gbz = true;
                        }
                        if (PbModel.this.gbs != null) {
                            PbModel.this.gbs.a(PbModel.this.bjN(), z, responsedMessage, PbModel.this.gbA, System.currentTimeMillis() - PbModel.this.ecr);
                        }
                    }
                }
            }
        };
        this.gcc = null;
        registerListener(this.gbZ);
        registerListener(this.gcb);
        registerListener(this.gca);
        this.gbm = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bBi = baseActivity;
        this.gbJ = new x(this, this.bBi);
        this.gbK = new h(this, this.bBi);
        this.gbL = new m(this, this.bBi);
        this.gbM = new z(this, this.bBi);
        this.cwe = new CheckRealNameModel(this.bBi.getPageContext());
        this.gbP = new SuggestEmotionModel();
        this.gbO = new AddExperiencedModel(this.bBi.getPageContext());
    }

    protected int bjN() {
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
            this.gaS = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.e(data)) {
                com.baidu.tbadk.BdToken.f.vF().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void n(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.akT) instanceof String)) {
                            PbModel.this.gaS = (String) hashMap.get(com.baidu.tbadk.BdToken.f.akT);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.gaS)) {
                this.gaS = this.gbJ.Y(intent);
                if (StringUtils.isNull(this.gaS) && intent.getData() != null) {
                    this.gaS = data.getQueryParameter("thread_id");
                }
            }
            this.gbS = intent.getIntExtra("key_start_from", 0);
            if (this.gbS == 0) {
                this.gbS = this.gbJ.gci;
            }
            this.gaU = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.gaT = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.gaV = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.gaW = intent.getBooleanExtra("host_only", false);
            this.gaY = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.PJ().Gg() ? 2 : 0);
            if (this.mSortType == 2) {
                this.gaU = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.gbb = intent.getIntExtra("is_top", 0);
            this.gbc = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.gbi = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.fiM = intent.getBooleanExtra("is_sub_pb", false);
            this.gbk = intent.getBooleanExtra("is_pv", false);
            this.gbj = intent.getLongExtra("msg_id", 0L);
            this.gbl = intent.getStringExtra("from_forum_name");
            this.gbu = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.gbt = intent.getStringExtra("op_stat");
            this.gbo = intent.getBooleanExtra("is_from_thread_config", false);
            this.gbp = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.gbq = intent.getBooleanExtra("is_from_my_god_config", false);
            this.gbw = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.gbv = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.gbg = intent.getBooleanExtra("from_frs", false);
            this.gbh = intent.getBooleanExtra("from_maintab", false);
            this.gbH = intent.getBooleanExtra("from_smart_frs", false);
            this.gbr = intent.getBooleanExtra("from_hottopic", false);
            this.gbN = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.gbS = bundle.getInt("key_start_from", 0);
        this.gaS = bundle.getString("thread_id");
        this.gaU = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.gaT = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.gaV = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.gaW = bundle.getBoolean("host_only", false);
        this.gaY = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.gbb = bundle.getInt("is_top", 0);
        this.gbc = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.gbi = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.fiM = bundle.getBoolean("is_sub_pb", false);
        this.gbk = bundle.getBoolean("is_pv", false);
        this.gbj = bundle.getLong("msg_id", 0L);
        this.gbl = bundle.getString("from_forum_name");
        this.gbu = bundle.getString("extra_pb_cache_key");
        this.gbo = bundle.getBoolean("is_from_thread_config", false);
        this.gbp = bundle.getBoolean("is_from_interview_live_config", false);
        this.gbq = bundle.getBoolean("is_from_my_god_config", false);
        this.gbw = bundle.getInt("extra_pb_is_attention_key", -1);
        this.gbv = bundle.getInt("extra_pb_funs_count_key", -1);
        this.gbg = bundle.getBoolean("from_frs", false);
        this.gbh = bundle.getBoolean("from_maintab", false);
        this.gbH = bundle.getBoolean("from_smart_frs", false);
        this.gbr = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void G(Bundle bundle) {
        bundle.putString("thread_id", this.gaS);
        bundle.putString("post_id", this.gaU);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.gbS);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.gaV);
        bundle.putBoolean("host_only", this.gaW);
        bundle.putBoolean("squence", this.gaY);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.gbb);
        bundle.putLong("thread_time", this.gbc);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.gbi);
        bundle.putBoolean("is_sub_pb", this.fiM);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.gbk);
        bundle.putLong("msg_id", this.gbj);
        bundle.putString("extra_pb_cache_key", this.gbu);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.gbo);
        bundle.putBoolean("is_from_interview_live_config", this.gbp);
        bundle.putBoolean("is_from_my_god_config", this.gbq);
        bundle.putInt("extra_pb_is_attention_key", this.gbw);
        bundle.putInt("extra_pb_funs_count_key", this.gbv);
        bundle.putBoolean("from_frs", this.gbg);
        bundle.putBoolean("from_maintab", this.gbh);
        bundle.putBoolean("from_smart_frs", this.gbH);
        bundle.putBoolean("from_hottopic", this.gbr);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bjO() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.gaS);
        if (!this.gbi) {
            sb.append(this.gaU);
        }
        sb.append(this.gaW);
        sb.append(this.gaY);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.gbb);
        sb.append(this.gbc);
        sb.append(this.gbg);
        sb.append(this.gbh);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.fiM);
        sb.append(this.gbk);
        sb.append(this.gbj);
        sb.append(this.gbl);
        sb.append(this.mThreadType);
        sb.append(this.gbo);
        sb.append(this.gbp);
        sb.append(this.gbq);
        if (this.gbu != null) {
            sb.append(this.gbu);
        }
        return sb.toString();
    }

    public String bhQ() {
        return this.gbl;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.gaU;
    }

    public String bjP() {
        return this.gaS;
    }

    public boolean getHostMode() {
        return this.gaW;
    }

    public boolean bjQ() {
        return bkA();
    }

    public int acb() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bjR() {
        return this.gbg;
    }

    public boolean bjS() {
        return this.gba;
    }

    public boolean bjT() {
        return this.gbh;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bjU() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bjV() {
        return this.gbb;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void lb(int i) {
        this.gbb = i;
    }

    public boolean bjW() {
        return this.fiM;
    }

    public boolean bjX() {
        if (this.gbm == null) {
            return false;
        }
        return this.gbm.isValid();
    }

    public String zQ() {
        if (this.gbm == null || !this.gbm.wq()) {
            return null;
        }
        return this.gbm.wp();
    }

    public boolean sA(int i) {
        this.gbd = i;
        if (this.gbd > this.gbm.yS().yK()) {
            this.gbd = this.gbm.yS().yK();
        }
        if (this.gbd < 1) {
            this.gbd = 1;
        }
        if (this.gaS == null) {
            return false;
        }
        return sC(5);
    }

    public void sB(int i) {
        this.gbd = i;
        this.gbe = i;
        this.gbf = i;
    }

    public void c(com.baidu.tbadk.core.data.al alVar) {
        if (alVar == null) {
            sB(1);
            return;
        }
        if (this.gbe < alVar.yN()) {
            this.gbe = alVar.yN();
        }
        if (this.gbf > alVar.yN()) {
            this.gbf = alVar.yN();
        }
        this.ddE = alVar.yK();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.gbm;
    }

    public com.baidu.tbadk.core.data.al getPageData() {
        if (this.gbm == null) {
            return null;
        }
        return this.gbm.yS();
    }

    public boolean bjY() {
        if (bkA() && this.gbm.yS().yP() == 0) {
            kX(true);
            return true;
        }
        return false;
    }

    public void sS(String str) {
        if (!StringUtils.isNull(str)) {
            this.gaS = str;
            this.gaU = null;
            this.gaW = false;
            this.gaY = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.gaS == null) {
            return false;
        }
        cancelLoadData();
        if (this.drX == null) {
            this.drX = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.drX.start();
        }
        boolean sC = sC(3);
        if (this.opType != null) {
            this.opType = null;
            this.gbt = null;
            this.opUrl = null;
            return sC;
        }
        return sC;
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
        if (this.gbP != null) {
            this.gbP.cancelLoadData();
        }
        if (this.gbQ != null) {
            this.gbQ.cancelLoadData();
        }
        awr();
    }

    private void awr() {
        if (this.drX != null) {
            this.drX.destory();
            this.drX = null;
        }
    }

    public boolean Ox() {
        return (this.gaU == null || this.gaU.equals("0") || this.gaU.length() == 0) ? LoadData() : bkb();
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
                this.gbP.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.gbP.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.gbQ == null) {
                this.gbQ = new GetSugMatchWordsModel(this.bBi.getPageContext());
            }
            this.gbQ.b(aVar);
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
    public boolean sC(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        sD(i);
        final com.baidu.tieba.pb.data.d pbData = aj.bkX().getPbData();
        if (pbData != null && pbData.bgV() != null) {
            pbData.bgV().cO(0);
            this.gaY = aj.bkX().bjQ();
            this.gaW = aj.bkX().blc();
            this.gba = aj.bkX().bld();
            this.gbU = aj.bkX().blb();
            this.gbV = aj.bkX().bla();
            this.gbW = aj.bkX().bkZ();
            this.gbR = this.gaW;
            if (this.gaW || this.isFromMark) {
                this.gbx = false;
            }
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.5
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.gbB) {
            a(bkg(), true, this.gaU, 3);
        }
        if (i == 3 && !this.gbB) {
            if (this.isFromMark) {
                a(bkg(), true, this.gaU, 3);
            } else {
                a(bkg(), false, this.gaU, 3);
            }
        }
        this.gbB = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aXx);
        if (this.gaW || this.isFromMark) {
            this.gbx = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.gaS == null || this.gaS.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.gaS, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.aq.DR().DT() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(aO));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aQ));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.gaY) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.gaW) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.gbk) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.gbj));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.gbx) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.l(this.gbt, 0));
            pbPageRequestMessage.setOpMessageID(this.gbj);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bgX = this.gbm.bgX();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.gbf - 1));
                        if (this.gbf - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z) {
                                if (bgX != null && bgX.size() > 0) {
                                    size = bgX.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bgX.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.gaU = postData.getId();
                                            if (StringUtils.isNull(this.gaU)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.gbe + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.gaU == null && this.gaU.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.gaU, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.gbe + 1));
                        if (this.gbe >= this.ddE) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bgX != null) {
                                size = bgX.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.gaU == null) {
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
                if (bgX != null) {
                }
                if (this.gaU == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bgX != null && bgX.size() > 0 && bgX.get(0) != null) {
                    this.gaU = bgX.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bkA()) {
                        if (this.gbf - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.gbf - 1));
                        }
                    } else if (this.gbe < this.ddE) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.gbe + 1));
                    }
                }
                if (this.gaU != null && this.gaU.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.gaU, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.gaW) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bkA()) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.gaU, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.gbd));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.gbR && !this.gaW) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.gaU, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.gaW) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.gbF);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.gbT, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.gbR = this.gaW;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bkg());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.gbS));
        pbPageRequestMessage.setIsSubPostDataReverse(this.gbE);
        pbPageRequestMessage.setFromSmartFrs(this.gbH ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.gaV);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bhP() {
        switch (bku()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bgV() == null || !getPbData().bgV().AR();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bhQ()) && com.baidu.tieba.recapp.r.bvk().bve() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bvk().bve().aa(bhQ(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bvk().bve().ab(bhQ(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bhQ()) && com.baidu.tieba.recapp.r.bvk().bve() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bvk().bve().ab(bhQ(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bvk().bve().aa(bhQ(), true));
        }
    }

    protected void sD(int i) {
        boolean z = false;
        sI(i);
        ArrayList<PostData> bgX = this.gbm.bgX();
        this.gbA = false;
        if (i == 1) {
            boolean z2 = false;
            while (bgX.size() + 30 > com.baidu.tbadk.data.d.Lx()) {
                bgX.remove(0);
                z2 = true;
            }
            if (z2) {
                this.gbm.yS().cL(1);
                if (this.gbs != null) {
                    this.gbs.f(this.gbm);
                }
            }
            this.ecr = System.currentTimeMillis();
            this.gbA = true;
        } else if (i == 2) {
            while (bgX.size() + 30 > com.baidu.tbadk.data.d.Lx()) {
                bgX.remove(bgX.size() - 1);
                z = true;
            }
            if (z) {
                this.gbm.yS().cK(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.gbI = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.gaT)) {
            try {
                Long valueOf = Long.valueOf(this.gaT);
                com.baidu.tieba.pb.data.k bhg = dVar.bhg();
                if (bhg != null && bhg.fTN != null) {
                    if (bhg.fTN.isEmpty() || !bhg.fTN.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.gaS);
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
            if (this.gbq || this.gbo || this.gbp) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.bgX().size(); i++) {
                PostData postData = dVar.bgX().get(i);
                for (int i2 = 0; i2 < postData.bEg().size(); i2++) {
                    postData.bEg().get(i2).a(this.bBi.getPageContext(), l.equals(postData.bEg().get(i2).zG().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.k bhg = dVar.bhg();
            if (bhg != null && !com.baidu.tbadk.core.util.v.I(bhg.fTM)) {
                for (PostData postData2 : bhg.fTM) {
                    for (int i3 = 0; i3 < postData2.bEg().size(); i3++) {
                        postData2.bEg().get(i3).a(this.bBi.getPageContext(), l.equals(postData2.bEg().get(i3).zG().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.k bhg = dVar.bhg();
            if (bhg != null && !com.baidu.tbadk.core.util.v.I(bhg.fTM)) {
                for (PostData postData : bhg.fTM.subList(i, bhg.fTM.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bEg().size()) {
                            postData.bEg().get(i3).a(this.bBi.getPageContext(), l.equals(postData.bEg().get(i3).zG().getUserId()));
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
        bb bgV = dVar.bgV();
        bgV.cS(this.mIsGood);
        bgV.cR(this.gbb);
        if (this.gbc > 0) {
            bgV.B(this.gbc);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bgV() != null && dVar.bgV().zG() != null) {
            str = dVar.bgV().zG().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bjZ() {
        if (this.gbm == null || this.gbm.bgV() == null || this.gbm.bgV().zG() == null) {
            return null;
        }
        return this.gbm.bgV().zG();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.gbG = z3;
        this.gbn = i;
        if (this.drX != null && !z3) {
            this.drX.a(z2, z4, i2, str, i3, j, j2);
            this.drX = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bhQ()) && com.baidu.tieba.recapp.r.bvk().bve() != null) {
            com.baidu.tieba.recapp.r.bvk().bve().f(bhQ(), sE(getRequestType()), true);
        }
        if (dVar == null || (this.gbd == 1 && i == 5 && dVar.bgX() != null && dVar.bgX().size() < 1)) {
            if (this.gbs != null) {
                this.gaY = this.gaX;
                this.mSortType = this.gaZ;
                this.gbs.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.gaX = this.gaY;
            if (i != 8) {
                this.gaZ = this.mSortType;
                this.mSortType = dVar.fTn;
            }
            if (dVar.fTm != null && dVar.fTm.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.bBi.getResources().getString(e.j.default_sort);
                builder.sort_type = 0;
                dVar.fTm = new ArrayList();
                dVar.fTm.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.bBi.getResources().getString(e.j.view_reverse);
                builder2.sort_type = 1;
                dVar.fTm.add(builder2.build(false));
                this.mSortType = this.gaZ;
                dVar.fTn = this.mSortType;
            }
            this.gbk = false;
            if (dVar.yS() != null && (this.mSortType != 2 || i != 8)) {
                c(dVar.yS());
            }
            this.ddE = this.ddE < 1 ? 1 : this.ddE;
            ArrayList<PostData> bgX = this.gbm.bgX();
            switch (i) {
                case 1:
                    this.gbm.a(dVar.yS(), 1);
                    d(dVar, bgX);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bgX() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bgX().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(bgX, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.d(dVar.bgX(), com.baidu.tbadk.core.util.v.H(dVar.bgX()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bgX().remove(postData2);
                            i6 = size - 1;
                        }
                        bgX.addAll(0, dVar.bgX());
                    }
                    this.gbm.a(dVar.yS(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.yS() != null) {
                        dVar.yS().cI(dVar.yS().yK());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && bkA()) {
                        bka();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.I(dVar.bgX()) && this.gbm != null && (!this.gaW || l(dVar).equals(dVar.bgX().get(0).zG().getUserId()))) {
                        if (this.gbm.yS().yP() == 0) {
                            this.gbm.yS().cK(1);
                        }
                        bkv();
                        this.gbU = dVar.bgX().get(0);
                        if (bkA()) {
                            if (this.gbm.bgX().size() - this.gbW >= 3) {
                                this.gbV = new PostData();
                                this.gbV.hoX = true;
                                this.gbV.setPostType(53);
                                this.gbm.bgX().add(this.gbV);
                            }
                            this.gbm.bgX().add(this.gbU);
                            i4 = this.gbm.bgX().size() - 1;
                        } else {
                            if (this.gbW - this.gbX >= 3) {
                                this.gbV = new PostData();
                                this.gbV.hoX = false;
                                this.gbV.setPostType(53);
                                this.gbm.bgX().add(0, this.gbV);
                            }
                            this.gbm.bgX().add(0, this.gbU);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ao.ak(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.gbU.hpj = this.gbm.bhw();
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
            if (this.gbm != null && this.gbm.bgV() != null) {
                PraiseData zt = this.gbm.bgV().zt();
                if (this.gcc != null && !zt.isPriaseDataValid()) {
                    this.gbm.bgV().a(this.gcc);
                } else {
                    this.gcc = this.gbm.bgV().zt();
                    this.gcc.setPostId(this.gbm.bgV().zX());
                }
                if (dVar.yS() != null && dVar.yS().yN() == 1 && dVar.bgV() != null && dVar.bgV().zS() != null && dVar.bgV().zS().size() > 0) {
                    this.gbm.bgV().l(dVar.bgV().zS());
                }
                this.gbm.bgV().cP(dVar.bgV().zx());
                this.gbm.bgV().cM(dVar.bgV().getAnchorLevel());
                this.gbm.bgV().cO(dVar.bgV().zp());
                if (this.mThreadType == 33) {
                    this.gbm.bgV().zG().setHadConcerned(dVar.bgV().zG().hadConcerned());
                }
                if (dVar != null && dVar.bgV() != null) {
                    this.gbm.bgV().cU(dVar.bgV().zW());
                }
            }
            if (this.gbm != null && this.gbm.getUserData() != null && dVar.getUserData() != null) {
                this.gbm.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.gbm.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.yS() != null && dVar.yS().yN() == 1 && dVar.bhf() != null) {
                this.gbm.d(dVar.bhf());
            }
            if (this.gbG) {
                if (this.gbm.bgV() != null && this.gbm.bgV().zG() != null && this.gbm.bgX() != null && com.baidu.tbadk.core.util.v.d(this.gbm.bgX(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.d(this.gbm.bgX(), 0);
                    MetaData zG = this.gbm.bgV().zG();
                    if (postData3.zG() != null && postData3.zG().getGodUserData() != null) {
                        if (this.gbv != -1) {
                            zG.setFansNum(this.gbv);
                            postData3.zG().setFansNum(this.gbv);
                        }
                        if (this.gbw != -1) {
                            zG.getGodUserData().setIsLike(this.gbw == 1);
                            postData3.zG().getGodUserData().setIsLike(this.gbw == 1);
                            zG.getGodUserData().setIsFromNetWork(false);
                            postData3.zG().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.gbm.fTl = -1;
                this.gbm.fTk = -1;
            }
            if (this.gbs != null) {
                this.gbs.a(true, getErrorCode(), i, i5, this.gbm, this.mErrorString, 1);
            }
        }
        if (this.gbm != null && this.gbm.bgV() != null && this.gbm.bgT() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bBi.getPageContext();
            historyMessage.threadId = getPbData().bgV().getId();
            if (this.mIsShareThread && getPbData().bgV().avt != null) {
                historyMessage.threadName = getPbData().bgV().avt.showText;
            } else {
                historyMessage.threadName = getPbData().bgV().getTitle();
            }
            if (this.mIsShareThread && !bhP()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().bgT().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bjQ();
            historyMessage.threadType = getPbData().bgV().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String ao;
        if (arrayList != null && dVar.bgX() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(dVar.bgX(), 0);
            if (postData != null && (ao = ao(arrayList)) != null && ao.equals(postData.getId())) {
                dVar.bgX().remove(postData);
            }
            arrayList.addAll(dVar.bgX());
        }
    }

    private int sE(int i) {
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
        dVar.sP(this.gbm.bho());
        this.gbm = dVar;
        sB(dVar.yS().yN());
    }

    private void bka() {
        if (this.gbm != null && this.gbm.bgX() != null && this.gbm.bhn() != null) {
            ArrayList<PostData> bgX = this.gbm.bgX();
            com.baidu.tieba.pb.data.a bhn = this.gbm.bhn();
            int bgR = bhn.bgR();
            if (bgR > 0) {
                if (bgR <= bgX.size()) {
                    bgX.add(bgR, bhn);
                } else {
                    bgX.add(bhn);
                }
            }
        }
    }

    public boolean bkb() {
        if (this.gaS == null || this.gaU == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return sC(4);
        }
        return sC(6);
    }

    public boolean kX(boolean z) {
        if (this.gaS == null || this.gbm == null) {
            return false;
        }
        if (z || this.gbm.yS().yP() != 0) {
            return sC(1);
        }
        return false;
    }

    public boolean kY(boolean z) {
        if (this.gaS == null || this.gbm == null) {
            return false;
        }
        if ((z || this.gbm.yS().yQ() != 0) && this.gbm.bgX() != null && this.gbm.bgX().size() >= 1) {
            return sC(2);
        }
        return false;
    }

    public boolean sX(String str) {
        this.gaW = !this.gaW;
        this.gaU = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (sC(6)) {
            return true;
        }
        this.gaW = this.gaW ? false : true;
        return false;
    }

    public boolean q(boolean z, String str) {
        if (this.gaW == z) {
            return false;
        }
        this.gaW = z;
        this.gaU = str;
        if (this.mSortType == 2) {
            this.gaU = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (sC(6)) {
            return true;
        }
        this.gaW = z ? false : true;
        return false;
    }

    public boolean sF(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.gaX = this.gaY;
        this.gaZ = this.mSortType;
        this.mSortType = i;
        this.gaY = !this.gaY;
        if (i == 2 && this.isFromMark) {
            this.gaU = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.gaY = this.gaY ? false : true;
            this.mSortType = this.gaZ;
            return false;
        }
        return true;
    }

    public boolean bkc() {
        return bkA();
    }

    public int bkd() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.gbm == null || this.gbm.bgT() == null || this.gbm.bgV() == null) ? false : true;
    }

    public boolean wq() {
        if (this.gbm == null) {
            return false;
        }
        return this.gbm.wq();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hL(String str) {
        if (this.gbm == null || this.gbm.bgV() == null || this.gbm.bgT() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.gbm.bgV().AR()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.gbm.bgT().getId());
            writeData.setForumName(this.gbm.bgT().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.gbS);
        writeData.setThreadId(this.gaS);
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

    public MarkData sG(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.gbm == null) {
            return null;
        }
        ArrayList<PostData> bgX = this.gbm.bgX();
        if (com.baidu.tbadk.core.util.v.I(bgX)) {
            return null;
        }
        if (bgX.size() > 0 && i >= bgX.size()) {
            i = bgX.size() - 1;
        }
        return h(bgX.get(i));
    }

    public MarkData bke() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.gaS);
        markData.setPostId(this.gbm.wp());
        markData.setTime(date.getTime());
        markData.setHostMode(this.gaW);
        markData.setSequence(Boolean.valueOf(bkA()));
        markData.setId(this.gaS);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.gaS);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.gaW);
        markData.setSequence(Boolean.valueOf(bkA()));
        markData.setId(this.gaS);
        markData.setFloor(postData.bEj());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bkf() {
        g.bjz().T(bkg(), this.isFromMark);
    }

    private String bkg() {
        String str = this.gaS;
        if (this.gaW) {
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

    public void kZ(boolean z) {
        if (this.gbm != null) {
            this.gbm.aP(z);
        }
    }

    public void la(boolean z) {
        this.gbx = z;
    }

    public boolean bkh() {
        return this.gbx;
    }

    public void a(a aVar) {
        this.gbs = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Mt() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Ms() {
        return Ox();
    }

    public boolean sY(String str) {
        if (getPbData() == null || getPbData().bgV() == null || getPbData().bgV().zG() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bgV().zG().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bki() {
        String bkg = bkg();
        g.bjz().T(bkg, false);
        g.bjz().T(bkg, true);
    }

    public void bkj() {
        if ("personalize_page".equals(this.mStType)) {
            this.gbD = System.currentTimeMillis() / 1000;
        }
    }

    public void bkk() {
        if ("personalize_page".equals(this.mStType) && this.gbm != null && this.gbD != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10754").aA(ImageViewerConfig.FORUM_ID, this.gbm.getForumId()).aA("tid", this.gaS).aA("obj_duration", String.valueOf(currentTimeMillis - this.gbD)).aA("obj_param3", String.valueOf(currentTimeMillis)));
            this.gbD = 0L;
        }
    }

    public boolean bkl() {
        return this.gbG;
    }

    public int getErrorNo() {
        return this.gbI;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bkm() {
        return this.gbK;
    }

    public m bkn() {
        return this.gbL;
    }

    public z bko() {
        return this.gbM;
    }

    public CheckRealNameModel bkp() {
        return this.cwe;
    }

    public AddExperiencedModel bkq() {
        return this.gbO;
    }

    public String bkr() {
        return this.gbC;
    }

    public void sZ(String str) {
        this.gbC = str;
    }

    public boolean bks() {
        return this.gbH;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.gbm != null && this.gbm.bgX() != null && this.gbm.bgX().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.gbm.bgX().size();
                for (int i = 0; i < size; i++) {
                    if (this.gbm.bgX().get(i) != null && this.gbm.bgX().get(i).zG() != null && currentAccount.equals(this.gbm.bgX().get(i).zG().getUserId()) && this.gbm.bgX().get(i).zG().getPendantData() != null) {
                        this.gbm.bgX().get(i).zG().getPendantData().ej(jVar.ys());
                        this.gbm.bgX().get(i).zG().getPendantData().ap(jVar.LF());
                    }
                }
            }
        }
    }

    public String bkt() {
        return this.gbN;
    }

    public int bku() {
        return this.gbS;
    }

    public void sH(int i) {
        this.gbS = i;
    }

    public void ta(String str) {
        if ((!this.gaW || sY(TbadkCoreApplication.getCurrentAccount())) && this.gbm.bgX() != null) {
            this.gbm.yS().cK(1);
            if (this.gbm.yS().yP() == 0) {
                this.gbm.yS().cK(1);
            }
            this.gbT = str;
            sC(8);
        }
    }

    private void sI(int i) {
        if (i != 8) {
            this.gbT = "";
            if (this.gbU != null) {
                if (i == 1 && !this.gaY && !com.baidu.tbadk.core.util.v.I(getPbData().bgX())) {
                    getPbData().bgX().remove(this.gbU);
                    if (this.gbV != null) {
                        getPbData().bgX().remove(this.gbV);
                    }
                    getPbData().bgX().add(0, this.gbU);
                } else {
                    getPbData().bgX().remove(this.gbU);
                    if (this.gbV != null) {
                        getPbData().bgX().remove(this.gbV);
                    }
                }
            }
            this.gbV = null;
        }
    }

    public void bkv() {
        if (this.gbm != null && !com.baidu.tbadk.core.util.v.I(this.gbm.bgX())) {
            if (this.gbV != null) {
                this.gbm.bgX().remove(this.gbV);
                this.gbV = null;
            }
            if (this.gbU != null) {
                this.gbm.bgX().remove(this.gbU);
                this.gbU = null;
            }
        }
    }

    public void by(int i, int i2) {
        this.gbW = i;
        this.gbX = i2;
    }

    public PostData bkw() {
        return this.gbU;
    }

    public PostData bkx() {
        return this.gbV;
    }

    public int bky() {
        return this.gbW;
    }

    public String bkz() {
        return this.gbY;
    }

    public void tb(String str) {
        this.gbY = str;
    }

    private boolean bkA() {
        return this.mSortType == 0 || this.mSortType == 2;
    }
}
